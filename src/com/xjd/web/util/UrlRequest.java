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

    public static void main(String[] args) {
        String url = "http://192.168.0.216:8082/bimp-base-bst/doFireBusCheckByBusCode.do";
        String json="{\"busCode\":\"S0K-1044\",\"workNo\":\"1802090833\"}";
      String re=  sendPost(url,"Json="+json);
        System.out.println(re);
    }
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
            // ����ʵ�ʵ�����
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
            logger.error("����GET��������쳣��" + e);
        } catch (IOException e) {
            logger.error("����GET��������쳣��" + e);
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
     * ��ָ�� URL ����POST����������
     *
     * @param url
     *            ��������� URL
     * @param param
     *            ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
     * @return ������Զ����Դ����Ӧ���
     */
    public static String sendPost(String url, String param) {
        OutputStream out_stream = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // �򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            // ����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������
            out_stream = conn.getOutputStream();
            // out = new PrintWriter(conn.getOutputStream());

            // �����������
            byte[] out_b = param.getBytes("utf-8");
            // out.print(param);
            out_stream.write(out_b);
            // flush������Ļ���
            // out.flush();
            out_stream.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("���� POST ��������쳣��" + e);
            // System.out.println("���� POST ��������쳣��" + e);
            e.printStackTrace();
        }
        // ʹ��finally�����ر��������������
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
