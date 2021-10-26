package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 2. 资源加载接口定义和实现
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
