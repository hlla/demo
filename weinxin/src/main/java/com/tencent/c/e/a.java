package com.tencent.c.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.File;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  /* Error */
  public static String Vc(String paramString)
  {
    // Byte code:
    //   0: new 12	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 16	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: new 18	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 19	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokevirtual 23	java/io/File:exists	()Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifne +10 -> 33
    //   26: aload 4
    //   28: invokevirtual 27	java/util/zip/ZipFile:close	()V
    //   31: aconst_null
    //   32: areturn
    //   33: aload 4
    //   35: ldc 29
    //   37: invokevirtual 33	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +101 -> 143
    //   45: new 35	java/io/BufferedReader
    //   48: dup
    //   49: new 37	java/io/InputStreamReader
    //   52: dup
    //   53: aload 4
    //   55: aload_0
    //   56: invokevirtual 41	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   59: invokespecial 44	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   62: invokespecial 47	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   65: astore_0
    //   66: aload_0
    //   67: invokevirtual 51	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   70: astore 5
    //   72: aload_0
    //   73: astore_3
    //   74: aload 5
    //   76: ifnull +69 -> 145
    //   79: aload 5
    //   81: ldc 53
    //   83: invokevirtual 59	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   86: ifeq -20 -> 66
    //   89: aload_0
    //   90: invokevirtual 51	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   93: astore_3
    //   94: aload_3
    //   95: ifnull -29 -> 66
    //   98: aload_3
    //   99: ldc 61
    //   101: invokevirtual 59	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: ifeq -38 -> 66
    //   107: aload_3
    //   108: ldc 63
    //   110: invokevirtual 67	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   113: istore_1
    //   114: iload_1
    //   115: ifle -49 -> 66
    //   118: aload_3
    //   119: iload_1
    //   120: iconst_1
    //   121: iadd
    //   122: invokevirtual 71	java/lang/String:substring	(I)Ljava/lang/String;
    //   125: invokevirtual 74	java/lang/String:trim	()Ljava/lang/String;
    //   128: astore_3
    //   129: aload_0
    //   130: invokevirtual 75	java/io/BufferedReader:close	()V
    //   133: aload 4
    //   135: invokevirtual 27	java/util/zip/ZipFile:close	()V
    //   138: aload_3
    //   139: areturn
    //   140: astore_0
    //   141: aload_3
    //   142: areturn
    //   143: aconst_null
    //   144: astore_3
    //   145: aload_3
    //   146: ifnull +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 75	java/io/BufferedReader:close	()V
    //   153: aload 4
    //   155: invokevirtual 27	java/util/zip/ZipFile:close	()V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_0
    //   161: aconst_null
    //   162: areturn
    //   163: astore_0
    //   164: aconst_null
    //   165: astore 4
    //   167: aconst_null
    //   168: astore_0
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 75	java/io/BufferedReader:close	()V
    //   177: aload 4
    //   179: ifnull -148 -> 31
    //   182: aload 4
    //   184: invokevirtual 27	java/util/zip/ZipFile:close	()V
    //   187: aconst_null
    //   188: areturn
    //   189: astore_0
    //   190: aconst_null
    //   191: areturn
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_0
    //   195: aconst_null
    //   196: astore 4
    //   198: aload_0
    //   199: ifnull +7 -> 206
    //   202: aload_0
    //   203: invokevirtual 75	java/io/BufferedReader:close	()V
    //   206: aload 4
    //   208: ifnull +8 -> 216
    //   211: aload 4
    //   213: invokevirtual 27	java/util/zip/ZipFile:close	()V
    //   216: aload_3
    //   217: athrow
    //   218: astore_0
    //   219: aconst_null
    //   220: areturn
    //   221: astore_0
    //   222: goto -89 -> 133
    //   225: astore_0
    //   226: goto -73 -> 153
    //   229: astore_0
    //   230: goto -53 -> 177
    //   233: astore_0
    //   234: goto -28 -> 206
    //   237: astore_0
    //   238: goto -22 -> 216
    //   241: astore_3
    //   242: aconst_null
    //   243: astore_0
    //   244: goto -46 -> 198
    //   247: astore_3
    //   248: goto -50 -> 198
    //   251: astore_0
    //   252: aconst_null
    //   253: astore_0
    //   254: goto -85 -> 169
    //   257: astore_3
    //   258: goto -89 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramString	String
    //   113	9	1	i	int
    //   21	2	2	bool	boolean
    //   73	77	3	str1	String
    //   192	25	3	localObject1	Object
    //   241	1	3	localObject2	Object
    //   247	1	3	localObject3	Object
    //   257	1	3	localException	Exception
    //   8	204	4	localZipFile	java.util.zip.ZipFile
    //   70	10	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   133	138	140	java/io/IOException
    //   153	158	160	java/io/IOException
    //   0	10	163	java/lang/Exception
    //   182	187	189	java/io/IOException
    //   0	10	192	finally
    //   26	31	218	java/io/IOException
    //   129	133	221	java/io/IOException
    //   149	153	225	java/io/IOException
    //   173	177	229	java/io/IOException
    //   202	206	233	java/io/IOException
    //   211	216	237	java/io/IOException
    //   10	22	241	finally
    //   33	41	241	finally
    //   45	66	241	finally
    //   66	72	247	finally
    //   79	94	247	finally
    //   98	114	247	finally
    //   118	129	247	finally
    //   10	22	251	java/lang/Exception
    //   33	41	251	java/lang/Exception
    //   45	66	251	java/lang/Exception
    //   66	72	257	java/lang/Exception
    //   79	94	257	java/lang/Exception
    //   98	114	257	java/lang/Exception
    //   118	129	257	java/lang/Exception
  }
  
  /* Error */
  private static java.security.cert.Certificate a(CertificateFactory paramCertificateFactory, android.content.pm.Signature paramSignature)
  {
    // Byte code:
    //   0: new 82	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 88	android/content/pm/Signature:toByteArray	()[B
    //   8: invokespecial 91	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_1
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 97	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   17: checkcast 99	java/security/cert/X509Certificate
    //   20: astore_0
    //   21: aload_1
    //   22: invokevirtual 100	java/io/ByteArrayInputStream:close	()V
    //   25: aload_0
    //   26: areturn
    //   27: astore_0
    //   28: aload_1
    //   29: invokevirtual 100	java/io/ByteArrayInputStream:close	()V
    //   32: aconst_null
    //   33: areturn
    //   34: astore_0
    //   35: aconst_null
    //   36: areturn
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 100	java/io/ByteArrayInputStream:close	()V
    //   42: aconst_null
    //   43: areturn
    //   44: astore_0
    //   45: aconst_null
    //   46: areturn
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 100	java/io/ByteArrayInputStream:close	()V
    //   52: aload_0
    //   53: athrow
    //   54: astore_1
    //   55: aload_0
    //   56: areturn
    //   57: astore_1
    //   58: goto -6 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramCertificateFactory	CertificateFactory
    //   0	61	1	paramSignature	android.content.pm.Signature
    // Exception table:
    //   from	to	target	type
    //   12	21	27	java/security/cert/CertificateException
    //   28	32	34	java/io/IOException
    //   12	21	37	java/lang/Exception
    //   38	42	44	java/io/IOException
    //   12	21	47	finally
    //   21	25	54	java/io/IOException
    //   48	52	57	java/io/IOException
  }
  
  public static List<byte[]> bs(Context paramContext, String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if ((paramContext != null) && (paramContext.signatures != null) && (paramContext.signatures.length > 0))
      {
        paramContext = paramContext.signatures;
        int i = 0;
        for (;;)
        {
          if ((i < paramContext.length) && (i < 5))
          {
            paramString = (X509Certificate)a(CertificateFactory.getInstance("X.509"), paramContext[i]);
            if (paramString != null) {}
            try
            {
              localArrayList.add(e.bx(paramString.getEncoded()));
              i += 1;
            }
            catch (CertificateEncodingException paramString)
            {
              for (;;)
              {
                g.bT("extractPkgCertMd5s(), CertificateEncodingException: " + paramString);
              }
            }
          }
        }
      }
      return localArrayList;
    }
    catch (Exception paramContext)
    {
      g.bT("extractPkgCertMd5s(), Exception: " + paramContext);
    }
  }
  
  public static com.tencent.c.a.a bt(Context paramContext, String paramString)
  {
    locala = new com.tencent.c.a.a();
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      locala.fwG = paramString;
      locala.versionName = paramContext.versionName;
      locala.versionCode = paramContext.versionCode;
      paramContext = (X509Certificate)a(CertificateFactory.getInstance("X.509"), paramContext.signatures[0]);
      if (paramContext != null)
      {
        paramContext = e.bx(paramContext.getEncoded());
        if (paramContext == null) {}
        for (paramContext = null;; paramContext = paramString.toString())
        {
          locala.wOC = paramContext;
          return locala;
          paramString = new StringBuffer(paramContext.length);
          int i = 0;
          while (i < paramContext.length)
          {
            String str = Integer.toHexString(paramContext[i] & 0xFF);
            if (str.length() < 2) {
              paramString.append(0);
            }
            paramString.append(str.toUpperCase());
            i += 1;
          }
        }
      }
      return locala;
    }
    catch (Exception paramContext)
    {
      return locala;
    }
    catch (CertificateEncodingException paramContext)
    {
      return locala;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  public static List<com.tencent.c.a.a> fy(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        String str = paramContext.getPackageName();
        PackageManager localPackageManager = paramContext.getPackageManager();
        Iterator localIterator = localPackageManager.getInstalledApplications(0).iterator();
        if (!localIterator.hasNext()) {
          break label226;
        }
        localApplicationInfo = (ApplicationInfo)localIterator.next();
        if ((localApplicationInfo.packageName == null) || (localApplicationInfo.packageName.equals(str))) {
          continue;
        }
        if ((localApplicationInfo.flags & 0x1) == 0) {
          break label228;
        }
        i = 1;
        locala = bt(paramContext, localApplicationInfo.packageName);
        locala.wOB = localPackageManager.getApplicationLabel(localApplicationInfo).toString();
        if (locala.wOB != null) {
          break label238;
        }
        locala.wOB = "";
      }
      catch (Throwable paramContext)
      {
        ApplicationInfo localApplicationInfo;
        com.tencent.c.a.a locala;
        g.bS("getAllAppInfos(), exception: " + paramContext);
      }
      locala.mnt = i;
      locala.fileSize = new File(localApplicationInfo.sourceDir).length();
      locala.wOD = localApplicationInfo.sourceDir;
      localArrayList.add(locala);
      g.bU("add app: " + localApplicationInfo.packageName);
      continue;
      label226:
      return localArrayList;
      label228:
      int i = 0;
      continue;
      label238:
      do
      {
        i = 0;
        break;
      } while (i == 0);
      i = 1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/c/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */