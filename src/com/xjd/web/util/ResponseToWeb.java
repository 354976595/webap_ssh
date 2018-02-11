package com.xjd.web.util;


import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/11/23.
 */
@Deprecated

public class ResponseToWeb {
    public static void responseToWeb(String str) {
        HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
        PrintWriter wt = null;
        try {
            httpServletResponse.setContentType("application/json;utf-8");
            httpServletResponse.setCharacterEncoding("utf-8");
            wt = httpServletResponse.getWriter();
            wt.write(str);
            wt.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null!=wt){
                wt.close();
            }
        }

    }
}
