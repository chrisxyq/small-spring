package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * 2. 新增 getBean 接口
 BeanFactory 中我们重载了一个含有入参信息 args 的 getBean 方法，这样就可以方便的传递入参给构造函数实例化了
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;
    //BeanFactory 中我们重载了一个含有入参信息 args 的 getBean 方法，这样就可以方便的传递入参给构造函数实例化了
    Object getBean(String name, Object... args) throws BeansException;

}
