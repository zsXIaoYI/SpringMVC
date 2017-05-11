package cn.zsza.dailyTest.spring4;

import cn.zsza.common.configuration.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 * Created by zs on 2017/5/11.
 * 17:52
 */
public class ApplicationContextTest {

    public static void main(String[] args) {


//        testApplicationXml();

        testApplicationAnnotation();
    }

    /**
     * 通过加载Bean.class，实例化一个容器
     */
    private static void testApplicationAnnotation() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanDefinition.class);

        List<Car> carList = ctx.getBean("carList", List.class);
        System.out.println(carList);

    }

    private static void testApplicationXml() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans-test.xml");
        System.out.println("bean init count=" +ctx.getBeanDefinitionCount());
        Car car = ctx.getBean("car1", Car.class);
        System.out.println(car.toString());
    }


}
