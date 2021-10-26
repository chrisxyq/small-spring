package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.test.bean.UserService;
import cn.bugstack.springframework.test.bean.UserService2;
import org.junit.Test;


/**
 * 本节实现：使用使用 newInstance创建bean
 * 在此次的单元测试中除了包括；Bean 工厂、注册 Bean、获取 Bean，三个步骤，
 * 还额外增加了一次对象的获取和调用。这里主要测试验证单例对象的是否正确的存放到了缓存中。
 * 此外与上一章节测试过程中不同的是，我们把 UserService.class 传递给了 BeanDefinition
 * 而不是像上一章节那样直接 new UserService() 操作
 */
public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        System.out.println("userService.equals(userService_singleton):"+userService.equals(userService_singleton));
        userService_singleton.queryUserInfo();
    }

    /**
     * java.lang.InstantiationException: cn.bugstack.springframework.test.bean.UserService2
     * 发生这一现象的主要原因就是因为 beanDefinition.getBeanClass().newInstance();
     * 实例化方式并没有考虑构造函数的入参，所以就这个坑就在这等着你了！
     */
    @Test
    public void test2(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService2.class);
        beanFactory.registerBeanDefinition("userService2", beanDefinition);

        // 3.第一次获取 bean
        UserService2 userService2 = (UserService2) beanFactory.getBean("userService2");
        userService2.queryUserInfo();
    }

}
