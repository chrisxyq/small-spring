package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.bean.UserService;
import cn.bugstack.springframework.test.common.MyBeanFactoryPostProcessor;
import cn.bugstack.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

/**
 * 本节实现：DefaultListableBeanFactory、XmlBeanDefinitionReader，
 * 是我们在目前 Spring 框架中对于服务功能测试的使用方式，
 * 它能很好的体现出 Spring是如何对 xml 加载以及注册Bean对象的操作过程，
 * 但这种方式是面向 Spring 本身的，还不具备一定的扩展性
 *
 * 本文主要新增了 Spring 框架中两个非常重要的接口 BeanFactoryPostProcess、BeanPostProcessor
 * 同时还添加了关于应用上下文的实现，ApplicationContext 接口的定义是继承 BeanFactory 外新增加功能的接口，
 * 它可以满足于自动识别、资源加载、容器事件、监听器等功能，同时例如一些国际化支持、单例Bean自动初始化等，
 * 也是可以在这个类里实现和扩充的。
 * 通过本文的实现一定会非常了解 BeanFactoryPostProcess、BeanPostProcessor，以后再做一些关于 Spring 中间件的开发时，
 * 如果需要用到 Bean 对象的获取以及修改一些属性信息，那么就可以使用这两个接口了。
 * 同时 BeanPostProcessor 也是实现 AOP 切面技术的关键所在。
 *
 */
public class ApiTest {
    /**
     * 不用应用上下文
     */
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
    /**
     * 用应用上下文
     */
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

}
