package jlu.vending;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试类继承此类可以使用依赖注入
 */
@RunWith(SpringJUnit4ClassRunner.class)
//Spring 配置文件位置
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class BaseTest
{

}
