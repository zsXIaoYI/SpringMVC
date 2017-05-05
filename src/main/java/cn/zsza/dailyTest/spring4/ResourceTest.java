package cn.zsza.dailyTest.spring4;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

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

        String filePath = "D:\\WorkSpace_new\\IDEA\\SpringMVC\\src\\main\\resources\\conf\\file.txt";
        String classPath = "conf/file.txt";

//        testWritableResource(filePath);

//        testClassPathResource(classPath);

        testRead(filePath);


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


}
