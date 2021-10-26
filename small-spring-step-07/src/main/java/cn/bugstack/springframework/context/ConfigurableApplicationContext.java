package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.BeansException;

/**
 * 7. 虚拟机关闭钩子注册调用销毁方法
 *
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the
 * {@link cn.bugstack.springframework.context.ApplicationContext} interface.
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 注册虚拟机钩子的方法 registerShutdownHook
     */
    void registerShutdownHook();

    /**
     * 手动执行关闭的方法 close
     */
    void close();

}
