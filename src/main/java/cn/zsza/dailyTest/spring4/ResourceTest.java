package cn.zsza.dailyTest.spring4;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by zs on 2017/5/5.
 * 14:35
 */
public class ResourceTest {
    public static void main(String[] args) throws IOException {

        String filePath = "D:\\WorkSpace_new\\IDEA\\SpringMVC\\src\\main\\resources\\conf\\file1.txt";
        String classPath = "conf/file.txt";

//        testWritableResource(filePath);

//        testClassPathResource(classPath);

//        testRead(filePath);

        testPatternResolver();


    }

    private static void testRead(String filePath) throws IOException {
        WritableResource res1 = new PathResource(filePath);

        InputStream inputStream = res1.getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int i;
        while ((i=inputStream.read()) != -1){
            baos.write(i);
        }
        System.out.println(baos.toString());

    }

    /**
     * 使用WritableResource接口写资源文件
     * 使用系统文件路径方式加载文件
     */
    private static void testWritableResource(String filePath) throws IOException {

        WritableResource res1 = new PathResource(filePath);     // Spring4中的API
        /**
         * 指定路径的文件不存在，则会创建
         */
        boolean isExist = res1.exists();
        System.out.println("isExist=" + isExist);
        System.out.println("fileName = " + res1.getFilename());
        OutputStream out = res1.getOutputStream();
        out.write("大家好\n我是小黑".getBytes());
        out.close();
    }

    /**
     * 使用类路径方式加载文件
     * @param classPath
     */
    private static void testClassPathResource(String classPath){
        Resource resource = new ClassPathResource(classPath);
        System.out.println(resource.getFilename());
    }

    /**
     * 加载类路径下以及类路径下jar包中Spring包底下以及子包下的.xml文件
     * 比如lib目录下有个test.jar,该jar包的spring包底下有xml文件
     * @throws IOException
     */
    public static void testPatternResolver() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resources[] = resolver.getResources("classpath*:spring/**/*.xml");

        for (Resource resource : resources){

            System.out.println(resource.getDescription());
        }
    }


}
