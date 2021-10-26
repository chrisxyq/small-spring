package cn.bugstack.springframework.beans.factory.config;

/**
 * 3. 单例注册接口定义和实现
 * 定义了一个获取单例对象的接口
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
