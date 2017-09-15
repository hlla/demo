package com.tencent.c.e;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

public final class d
{
  public static String Vd(String paramString)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      localObject = (String)((Method)localObject).invoke(null, new Object[] { paramString });
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      g.bS(" getBuildPropByReflect: " + paramString);
    }
    return "";
  }
  
  public static int ccV()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (Throwable localThrowable)
    {
      g.bS("getSDKVersion: " + localThrowable);
    }
    return 0;
  }
  
  /* Error */
  public static String cdC()
  {
    // Byte code:
    //   0: new 81	java/io/FileInputStream
    //   3: dup
    //   4: ldc 83
    //   6: invokespecial 84	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   9: astore_0
    //   10: new 86	java/io/BufferedReader
    //   13: dup
    //   14: new 88	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 91	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: sipush 8192
    //   25: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_2
    //   29: new 41	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 39
    //   35: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +38 -> 83
    //   48: aload_1
    //   49: aload_3
    //   50: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: goto -15 -> 39
    //   57: astore_3
    //   58: aload_3
    //   59: invokestatic 103	com/tencent/c/e/g:bT	(Ljava/lang/Object;)V
    //   62: aload_2
    //   63: invokevirtual 107	java/io/BufferedReader:close	()V
    //   66: aload_0
    //   67: invokevirtual 110	java/io/InputStream:close	()V
    //   70: aload_1
    //   71: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokestatic 103	com/tencent/c/e/g:bT	(Ljava/lang/Object;)V
    //   80: ldc 39
    //   82: areturn
    //   83: aload_2
    //   84: invokevirtual 107	java/io/BufferedReader:close	()V
    //   87: aload_0
    //   88: invokevirtual 110	java/io/InputStream:close	()V
    //   91: aload_1
    //   92: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: areturn
    //   96: astore_2
    //   97: aload_2
    //   98: invokestatic 103	com/tencent/c/e/g:bT	(Ljava/lang/Object;)V
    //   101: goto -14 -> 87
    //   104: astore_0
    //   105: aload_0
    //   106: invokestatic 103	com/tencent/c/e/g:bT	(Ljava/lang/Object;)V
    //   109: goto -18 -> 91
    //   112: astore_2
    //   113: aload_2
    //   114: invokestatic 103	com/tencent/c/e/g:bT	(Ljava/lang/Object;)V
    //   117: goto -51 -> 66
    //   120: astore_0
    //   121: aload_0
    //   122: invokestatic 103	com/tencent/c/e/g:bT	(Ljava/lang/Object;)V
    //   125: goto -55 -> 70
    //   128: astore_1
    //   129: aload_2
    //   130: invokevirtual 107	java/io/BufferedReader:close	()V
    //   133: aload_0
    //   134: invokevirtual 110	java/io/InputStream:close	()V
    //   137: aload_1
    //   138: athrow
    //   139: astore_2
    //   140: aload_2
    //   141: invokestatic 103	com/tencent/c/e/g:bT	(Ljava/lang/Object;)V
    //   144: goto -11 -> 133
    //   147: astore_0
    //   148: aload_0
    //   149: invokestatic 103	com/tencent/c/e/g:bT	(Ljava/lang/Object;)V
    //   152: goto -15 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	58	0	localFileInputStream	java.io.FileInputStream
    //   75	13	0	localThrowable1	Throwable
    //   104	2	0	localThrowable2	Throwable
    //   120	14	0	localThrowable3	Throwable
    //   147	2	0	localThrowable4	Throwable
    //   38	54	1	localStringBuilder	StringBuilder
    //   128	10	1	localObject	Object
    //   28	56	2	localBufferedReader	java.io.BufferedReader
    //   96	2	2	localThrowable5	Throwable
    //   112	18	2	localThrowable6	Throwable
    //   139	2	2	localThrowable7	Throwable
    //   43	7	3	str	String
    //   57	2	3	localThrowable8	Throwable
    // Exception table:
    //   from	to	target	type
    //   39	44	57	java/lang/Throwable
    //   48	54	57	java/lang/Throwable
    //   0	10	75	java/lang/Throwable
    //   83	87	96	java/lang/Throwable
    //   87	91	104	java/lang/Throwable
    //   62	66	112	java/lang/Throwable
    //   66	70	120	java/lang/Throwable
    //   39	44	128	finally
    //   48	54	128	finally
    //   58	62	128	finally
    //   129	133	139	java/lang/Throwable
    //   133	137	147	java/lang/Throwable
  }
  
  public static String fA(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      g.bS("getIMSI: " + paramContext);
    }
    return "";
  }
  
  public static String fB(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      g.bS("getAndroidId: " + paramContext);
    }
    return "";
  }
  
  public static String fz(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      g.bS("getIMEI: " + paramContext);
    }
    return "";
  }
  
  /* Error */
  public static String lX(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: iload_0
    //   10: ifeq +132 -> 142
    //   13: ldc -102
    //   15: astore_3
    //   16: ldc -100
    //   18: astore_1
    //   19: new 86	java/io/BufferedReader
    //   22: dup
    //   23: new 158	java/io/FileReader
    //   26: dup
    //   27: new 41	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   34: aload_3
    //   35: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc -94
    //   40: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 163	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   49: invokespecial 166	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore 7
    //   59: aload 6
    //   61: astore 4
    //   63: aload 7
    //   65: ifnull +89 -> 154
    //   68: aload 6
    //   70: astore 4
    //   72: aload 7
    //   74: invokevirtual 169	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   77: aload_1
    //   78: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +73 -> 154
    //   84: new 86	java/io/BufferedReader
    //   87: dup
    //   88: new 158	java/io/FileReader
    //   91: dup
    //   92: new 41	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   99: aload_3
    //   100: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc -81
    //   105: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 163	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   114: invokespecial 166	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   122: astore_3
    //   123: aload_3
    //   124: ifnull +27 -> 151
    //   127: aload_3
    //   128: invokevirtual 178	java/lang/String:trim	()Ljava/lang/String;
    //   131: astore_3
    //   132: aload_2
    //   133: invokevirtual 107	java/io/BufferedReader:close	()V
    //   136: aload_1
    //   137: invokevirtual 107	java/io/BufferedReader:close	()V
    //   140: aload_3
    //   141: areturn
    //   142: ldc -76
    //   144: astore_3
    //   145: ldc -74
    //   147: astore_1
    //   148: goto -129 -> 19
    //   151: aload_1
    //   152: astore 4
    //   154: aload_2
    //   155: invokevirtual 107	java/io/BufferedReader:close	()V
    //   158: aload 4
    //   160: ifnull +8 -> 168
    //   163: aload 4
    //   165: invokevirtual 107	java/io/BufferedReader:close	()V
    //   168: ldc 39
    //   170: areturn
    //   171: astore_3
    //   172: aconst_null
    //   173: astore_1
    //   174: aload 4
    //   176: astore_2
    //   177: new 41	java/lang/StringBuilder
    //   180: dup
    //   181: ldc -72
    //   183: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   186: aload_3
    //   187: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 61	com/tencent/c/e/g:bS	(Ljava/lang/Object;)V
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 107	java/io/BufferedReader:close	()V
    //   204: aload_1
    //   205: ifnull -37 -> 168
    //   208: aload_1
    //   209: invokevirtual 107	java/io/BufferedReader:close	()V
    //   212: goto -44 -> 168
    //   215: astore_1
    //   216: goto -48 -> 168
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_2
    //   222: aload 5
    //   224: astore_3
    //   225: aload_2
    //   226: ifnull +7 -> 233
    //   229: aload_2
    //   230: invokevirtual 107	java/io/BufferedReader:close	()V
    //   233: aload_3
    //   234: ifnull +7 -> 241
    //   237: aload_3
    //   238: invokevirtual 107	java/io/BufferedReader:close	()V
    //   241: aload_1
    //   242: athrow
    //   243: astore_2
    //   244: goto -108 -> 136
    //   247: astore_1
    //   248: aload_3
    //   249: areturn
    //   250: astore_1
    //   251: goto -93 -> 158
    //   254: astore_1
    //   255: goto -87 -> 168
    //   258: astore_2
    //   259: goto -55 -> 204
    //   262: astore_2
    //   263: goto -30 -> 233
    //   266: astore_2
    //   267: goto -26 -> 241
    //   270: astore_1
    //   271: aload 5
    //   273: astore_3
    //   274: goto -49 -> 225
    //   277: astore 4
    //   279: aload_1
    //   280: astore_3
    //   281: aload 4
    //   283: astore_1
    //   284: goto -59 -> 225
    //   287: astore 4
    //   289: aload_1
    //   290: astore_3
    //   291: aload 4
    //   293: astore_1
    //   294: goto -69 -> 225
    //   297: astore_3
    //   298: aconst_null
    //   299: astore_1
    //   300: goto -123 -> 177
    //   303: astore_3
    //   304: goto -127 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramBoolean	boolean
    //   18	191	1	localObject1	Object
    //   215	1	1	localIOException1	java.io.IOException
    //   219	23	1	localObject2	Object
    //   247	1	1	localIOException2	java.io.IOException
    //   250	1	1	localIOException3	java.io.IOException
    //   254	1	1	localIOException4	java.io.IOException
    //   270	10	1	localObject3	Object
    //   283	17	1	localObject4	Object
    //   52	178	2	localObject5	Object
    //   243	1	2	localIOException5	java.io.IOException
    //   258	1	2	localIOException6	java.io.IOException
    //   262	1	2	localIOException7	java.io.IOException
    //   266	1	2	localIOException8	java.io.IOException
    //   15	130	3	str1	String
    //   171	16	3	localThrowable1	Throwable
    //   224	67	3	localObject6	Object
    //   297	1	3	localThrowable2	Throwable
    //   303	1	3	localThrowable3	Throwable
    //   1	174	4	localObject7	Object
    //   277	5	4	localObject8	Object
    //   287	5	4	localObject9	Object
    //   4	268	5	localObject10	Object
    //   7	62	6	localObject11	Object
    //   57	16	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   19	53	171	java/lang/Throwable
    //   208	212	215	java/io/IOException
    //   19	53	219	finally
    //   132	136	243	java/io/IOException
    //   136	140	247	java/io/IOException
    //   154	158	250	java/io/IOException
    //   163	168	254	java/io/IOException
    //   200	204	258	java/io/IOException
    //   229	233	262	java/io/IOException
    //   237	241	266	java/io/IOException
    //   53	59	270	finally
    //   72	118	270	finally
    //   118	123	277	finally
    //   127	132	277	finally
    //   177	196	287	finally
    //   53	59	297	java/lang/Throwable
    //   72	118	297	java/lang/Throwable
    //   118	123	303	java/lang/Throwable
    //   127	132	303	java/lang/Throwable
  }
  
  public static enum a {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */