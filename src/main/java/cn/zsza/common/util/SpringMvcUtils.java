package cn.zsza.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zs on 2017/6/2.
 * 16:01
 */
public class SpringMvcUtils {

    public SpringMvcUtils() {
    }

    /**
     * 获取Request对象
     * @return
     */
    public static HttpServletRequest getRequest(){

        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    public static Long getUserCode() {
        return (Long)getRequest().getAttribute("userCode");
    }

    public static Object getAttr(String name) {
        return getRequest().getAttribute(name);
    }

    public static HttpServletResponse getResponse() {
        return ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
