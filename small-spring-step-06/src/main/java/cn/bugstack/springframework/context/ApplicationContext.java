package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.factory.ListableBeanFactory;

/**
 * 4. 定义上下文接口
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 * 继承于 ListableBeanFactory，也就继承了关于 BeanFactory 方法，比如一些 getBean 的方法
 * 应用上下文
 */
public interface ApplicationContext extends ListableBeanFactory {
}
