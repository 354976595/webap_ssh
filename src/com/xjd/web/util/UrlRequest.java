package com.xjd.web.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/23.
 */
public class UrlRequest {
    private static  final Logger logger=Logger.getLogger(UrlRequest.class);
    public static String sendGost(String url,String params){
        String hollUrl=url+"?"+params;
        String result = "";
        BufferedReader in=null;
        try {
            URL url1=new URL(hollUrl);
            URLConnection urlConnection=url1.openConnection();
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            urlConnection.connect();
            Map<String, List<String>> map = urlConnection.getHeaderFields();
            for (String s : map.keySet()) {
                logger.debug(s + "--->" + map.get(s));
            }
             in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
            String line;
            while ((line=in.readLine())!=null){
                result+=line;
            }
        } catch (MalformedURLException e) {
            logger.error("发送GET请求出现异常！" + e);
        } catch (IOException e) {
            logger.error("发送GET请求出现异常！" + e);
        }finally {
          if(in!=null){
              try {
                  in.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        OutputStream out_stream = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out_stream = conn.getOutputStream();
            // out = new PrintWriter(conn.getOutputStream());

            // 发送请求参数
            byte[] out_b = param.getBytes("utf-8");
            // out.print(param);
            out_stream.write(out_b);
            // flush输出流的缓冲
            // out.flush();
            out_stream.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("发送 POST 请求出现异常！" + e);
            // System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out_stream != null) {
                    out_stream.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
