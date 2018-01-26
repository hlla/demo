
package com.example.testbreakpoint;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtility {
    public static InputStream getWebDataStream(String path) throws Exception {
        Log.d("CommonUtility", "getWebDataStream path=" + path);
        if (!TextUtils.isEmpty(path)) {
            path = path.replace(" ", "");
        }

        Log.d("CommonUtility", "getWebDataStream11 path=" + path);
        URL url = new URL(path);
        HttpURLConnection conn = null;

        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (Exception var9) {
            Log.d("CommonUtility", "getWebDataStream ex=" + var9);
        }

        if (conn != null) {
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");
            conn.setInstanceFollowRedirects(true);
            int responseCode = conn.getResponseCode();
            Log.d("CommonUtility", "getWebDataStream2 responseCode=" + responseCode);
            if (responseCode >= 200 && responseCode < 400) {
                return conn.getInputStream();
            }
        }

        return null;
    }

    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        boolean len = false;

        int len1;
        while ((len1 = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len1);
        }

        inStream.close();
        return outStream.toByteArray();
    }

    public static String loadConfig(Context context, int rawId) {
        InputStream inputStream = context.getResources().openRawResource(rawId);
        InputStreamReader inputStreamReader = null;

        try {
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        } catch (UnsupportedEncodingException var8) {
            var8.printStackTrace();
            return null;
        }

        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException var9) {
            var9.printStackTrace();
            return null;
        }

        return sb.toString();
    }

    public static String loadAssets(Context context, String fileName) throws IOException {
        InputStream inputStream = context.getAssets().open(fileName);
        InputStreamReader inputStreamReader = null;

        try {
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        } catch (UnsupportedEncodingException var8) {
            var8.printStackTrace();
            return null;
        }

        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException var9) {
            var9.printStackTrace();
            return null;
        }

        return sb.toString();
    }

    @SuppressLint({
            "NewApi"
    })

    public static String MD5Helper(byte[] input) {
        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.reset();
            e.update(input);
            byte[] byteArray = e.digest();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < byteArray.length; ++i) {
                if (Integer.toHexString(255 & byteArray[i]).length() == 1) {
                    sb.append("0").append(Integer.toHexString(255 & byteArray[i]));
                } else {
                    sb.append(Integer.toHexString(255 & byteArray[i]));
                }
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException var5) {
            var5.printStackTrace();
            throw new RuntimeException("MD5Helper failed");
        }
    }

    public static String MD5Helper(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] result = read(fis);
        fis.close();
        return MD5Helper(result);
    }

    public static String MD5Helper(String str) {
        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.reset();
            e.update(str.getBytes("UTF-8"));
            byte[] byteArray = e.digest();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < byteArray.length; ++i) {
                if (Integer.toHexString(255 & byteArray[i]).length() == 1) {
                    sb.append("0").append(Integer.toHexString(255 & byteArray[i]));
                } else {
                    sb.append(Integer.toHexString(255 & byteArray[i]));
                }
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException var5) {
            var5.printStackTrace();
        } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
        }

        throw new RuntimeException("MD5Helper failed");
    }

    public static PackageInfo getPackageInfo(Context context, String apkFilepath) {
        PackageManager pm = context.getPackageManager();
        PackageInfo pkgInfo = null;
        try {
            pkgInfo = pm.getPackageArchiveInfo(apkFilepath, PackageManager.GET_ACTIVITIES);
        } catch (Exception e) {
            // should be something wrong with parse
            e.printStackTrace();
        }

        return pkgInfo;
    }
}
