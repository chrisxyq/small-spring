package cn.bugstack.springframework.beans.factory.config;

/**
 * 2. BeanDefinition 定义
 * 把上一章节中的 Object bean 替换为 Class，
 * 这样就可以把 Bean 的实例化操作放到容器中处理了
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
