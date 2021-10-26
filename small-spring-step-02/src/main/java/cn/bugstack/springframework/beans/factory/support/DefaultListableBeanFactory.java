package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * #6. 核心类实现(DefaultListableBeanFactory)
 * 非常核心的类
 * 现在注册Bean定义与获取Bean定义就可以同时使用了
 * 接口BeanDefinitionRegistry 定义了注册，抽象类AbstractAutowireCapableBeanFactory 定义了获取，
 * 都集中在 DefaultListableBeanFactory 中的 beanDefinitionMap 里
 *
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 接口BeanDefinitionRegistry 定义了注册
     * @param beanName
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 抽象类AbstractAutowireCapableBeanFactory 定义了获取，
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

}
