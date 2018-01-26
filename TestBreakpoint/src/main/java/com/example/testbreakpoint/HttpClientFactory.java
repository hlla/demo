
package com.example.testbreakpoint;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientFactory {

    public HttpClientFactory() {

    }

    // public static DefaultHttpClient createHttpClient() {
    // HClientParams hcParams = new HClientParams();
    // hcParams.retryCount = 0;// 默认为0，不重试
    // return createHttpClient(hcParams);
    // }

    // public static DefaultHttpClient createHttpClient(HClientParams hcParams)
    // {
    // SchemeRegistry schemeRegistry = new SchemeRegistry();
    // schemeRegistry.register(new Scheme("http", PlainSocketFactory
    // .getSocketFactory(), 80));
    //
    // HttpParams connManagerParams = new BasicHttpParams();
    // ConnManagerParams.setMaxTotalConnections(connManagerParams, 5);
    // ConnManagerParams.setMaxConnectionsPerRoute(connManagerParams,
    // new ConnPerRouteBean(5));
    // ConnManagerParams.setTimeout(connManagerParams, 15 * 1000);
    //
    // ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(
    // connManagerParams, schemeRegistry);
    //
    // HttpParams clientParams = new BasicHttpParams();
    // HttpProtocolParams.setUserAgent(clientParams,
    // ConfigurationUtil.getInstance().getUAString());
    // HttpConnectionParams.setConnectionTimeout(clientParams, 15 * 1000);
    // HttpConnectionParams.setSoTimeout(clientParams, 15 * 1000);
    // DefaultHttpClient httpClient = new DefaultHttpClient(cm, clientParams);
    //
    // // 如果有重试次数的设定，才会加上重试机制
    // if (hcParams.retryCount != 0) {
    // DefaultHttpRequestRetryHandler retryHandler = new
    // DefaultHttpRequestRetryHandler(
    // 5, false) {
    //
    // public boolean retryRequest(IOException exception,
    // int executionCount, HttpContext context) {
    // if (!super.retryRequest(exception, executionCount, context)) {
    // ARKDebugManager.showArkDebugInfo("HTTP retry-handler", "Won't retry");
    // return false;
    // }
    // try {
    // Thread.sleep(2000);
    // } catch (InterruptedException e) {
    // }
    // ARKDebugManager.showArkDebugInfo("HTTP retry-handler", "Retrying
    // request...");
    // return true;
    // }
    // };
    // httpClient.setHttpRequestRetryHandler(retryHandler);
    // }
    // return httpClient;
    // }

    /*
     * 发起POST请求
     */
    public static String post(String url, String content) {
        int timeout = 10000;
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        // 尝试发送请求
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();

            conn.setConnectTimeout(timeout);
            conn.setReadTimeout(timeout);

            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(content);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            // int fileSize = conn.getContentLength();
            // int code = conn.getResponseCode();
            // Log.d("MainActivity1",
            // "fileSize11=" + fileSize + " code=" + code + " type="
            // + conn.getHeaderFields());
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            int i = 0;
            char[] buffer = new char[102400];
            int length = -1;
            int sum = 0;
            while ((length = in.read(buffer)) != -1) {
                i++;
                sum = +length;
                // result = String.valueOf(buffer, 0, length) + result;
            }
            // while ((line = in.readLine()) != null) {
            // i++;
            // result += line;
            // }
            Log.d("MainActivity1", "i=" + i);
            Log.d("MainActivity1", "sum=" + sum);
            return result;
        } catch (Exception e) {
            Log.d("MainActivity1 e", "e=" + e);
        }
        return "";
    }

}
