package com.xjd.web.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/2/11.
 */
public class ExceptionIntercepter extends AbstractInterceptor {


    /**
     * Allows the Interceptor to do some processing on the request before and/or after the rest of the processing of the
     * request by the {@link ActionInvocation} or to short-circuit the processing and just return a String return code.
     *
     * @param actioninvocation the action invocation
     * @return the return code, either returned from {@link ActionInvocation#invoke()}, or from the interceptor itself.
     * @throws Exception any system-level error, as defined in {@link Action#execute()}.
     */
    public String intercept(ActionInvocation actioninvocation) throws Exception {
        String result = null; // Action的返回值
        try {
            // 运行被拦截的Action,期间如果发生异常会被catch住
            result = actioninvocation.invoke();
            return result;
        } catch (Exception e) {
            /**
             * 处理异常
             */
            String errorMsg = "出现错误信息，请查看日志！";
            //通过instanceof判断到底是什么异常类型
            if (e instanceof RuntimeException) {
                //未知的运行时异常
                RuntimeException re = (RuntimeException) e;
                //re.printStackTrace();
                errorMsg = re.getMessage().trim();
            }
            //把自定义错误信息
            HttpServletRequest request = (HttpServletRequest) actioninvocation
                    .getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
            /**
             * 发送错误消息到页面
             */
            request.setAttribute("message", errorMsg);

            /**
             * log4j记录日志
             */
            Log log = LogFactory
                    .getLog(actioninvocation.getAction().getClass());
            log.error(errorMsg, e);
            return "exception";
        }// ...end of catch
    }
}
