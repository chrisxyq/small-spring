package cn.bugstack.springframework.test.bean;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class UserService2 {
    private String name;
    public UserService2(String name) {
        this.name = name;
    }
    public void queryUserInfo(){
        System.out.println("查询用户信息");
    }

}
