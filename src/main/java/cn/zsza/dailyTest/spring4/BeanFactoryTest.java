package cn.zsza.dailyTest.spring4;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Created by zs on 2017/5/5.
 * 15:22
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource res = resolver.getResource("classpath:spring/beans-test.xml");
        System.out.println(res.getURL());  // 返回file:/D:/WorkSpace_new/IDEA/SpringMVC/target/classes/spring/beans-test.xml

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();


        /**
         * XmlBeanDefinitionReader通过Resource装载Spring配置信息并启动IoC容器，然后就可以通过BeanFactory#getBean(beanName)
         * 方法从IoC容器中获取Bean。通过BeanFactory启动IoC容器时，并不会初始化配置文件中定义的Bean,初始化动作发生在第一个调用时。
         * 对于单实例(singleton)的Bean来说，BeanFactory会缓存Bean实例，所以第二次使用getBean()方法获取Bean时，将直接从IOC容器
         * 的缓存中获取Bean实例。
         *
         * Spring在DefaultSingletonBeanRegistry类中提供了一个用于缓存但实例Bean的缓存器，它是一个用HashMap实现的缓存器，单实例的
         * Bean以beanName为键保存在这个HashMap中
         */
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        reader.loadBeanDefinitions(res);

        Car car1 = factory.getBean("car",Car.class);
        Car car2 = factory.getBean("car",Car.class);

        System.out.println(car1 == car2);
        System.out.println(car2.toString());

    }
}
