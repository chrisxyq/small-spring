package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * 5. 实例化Bean类(AbstractAutowireCapableBeanFactory)
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            //实现了 Bean 的实例化操作 newInstance，其实这块会埋下一个坑，有构造函数入参的对象怎么处理？
            //发生这一现象的主要原因就是因为 beanDefinition.getBeanClass().newInstance(); 实例化方式并没有考虑构造函数的入参，所以就这个坑就在这等着你了！
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        //在处理完 Bean 对象的实例化后，直接调用 addSingleton 方法存放到单例对象的缓存中去
        addSingleton(beanName, bean);
        return bean;
    }

}
