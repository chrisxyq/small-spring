package cn.bugstack.springframework.beans;

/**
 * 2. 定义属性
 * 创建出一个用于传递类中属性信息的类，因为属性可能会有很多，所以还需要定义一个集合包装下。
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
