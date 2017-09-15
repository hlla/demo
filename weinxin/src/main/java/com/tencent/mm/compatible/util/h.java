package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.bf;
import java.io.File;

public final class h
{
  private static Boolean gSF;
  
  static
  {
    GMTrace.i(14412836503552L, 107384);
    gSF = null;
    GMTrace.o(14412836503552L, 107384);
  }
  
  public static File getDataDirectory()
  {
    GMTrace.i(13790603116544L, 102748);
    if (bf.mA(p.gRb.gQn))
    {
      localFile = Environment.getDataDirectory();
      GMTrace.o(13790603116544L, 102748);
      return localFile;
    }
    File localFile = new File(p.gRb.gQn);
    GMTrace.o(13790603116544L, 102748);
    return localFile;
  }
  
  public static File getDownloadCacheDirectory()
  {
    GMTrace.i(14412568068096L, 107382);
    if (bf.mA(p.gRb.gQq))
    {
      localFile = Environment.getDownloadCacheDirectory();
      GMTrace.o(14412568068096L, 107382);
      return localFile;
    }
    File localFile = new File(p.gRb.gQq);
    GMTrace.o(14412568068096L, 107382);
    return localFile;
  }
  
  public static File getExternalStorageDirectory()
  {
    GMTrace.i(13790334681088L, 102746);
    if (bf.mA(p.gRb.gQl))
    {
      localFile = Environment.getExternalStorageDirectory();
      GMTrace.o(13790334681088L, 102746);
      return localFile;
    }
    File localFile = new File(p.gRb.gQl);
    GMTrace.o(13790334681088L, 102746);
    return localFile;
  }
  
  @TargetApi(8)
  public static File getExternalStoragePublicDirectory(String paramString)
  {
    GMTrace.i(13790468898816L, 102747);
    if (bf.mA(p.gRb.gQm))
    {
      paramString = Environment.getExternalStoragePublicDirectory(paramString);
      GMTrace.o(13790468898816L, 102747);
      return paramString;
    }
    paramString = new File(p.gRb.gQm);
    GMTrace.o(13790468898816L, 102747);
    return paramString;
  }
  
  public static String getExternalStorageState()
  {
    GMTrace.i(13790737334272L, 102749);
    if (bf.mA(p.gRb.gQp))
    {
      str = Environment.getExternalStorageState();
      GMTrace.o(13790737334272L, 102749);
      return str;
    }
    String str = p.gRb.gQp;
    GMTrace.o(13790737334272L, 102749);
    return str;
  }
  
  public static File getRootDirectory()
  {
    GMTrace.i(14412433850368L, 107381);
    if (bf.mA(p.gRb.gQo))
    {
      localFile = Environment.getRootDirectory();
      GMTrace.o(14412433850368L, 107381);
      return localFile;
    }
    File localFile = new File(p.gRb.gQo);
    GMTrace.o(14412433850368L, 107381);
    return localFile;
  }
  
  /* Error */
  public static boolean sf()
  {
    // Byte code:
    //   0: ldc2_w 112
    //   3: ldc 114
    //   5: invokestatic 17	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: getstatic 19	com/tencent/mm/compatible/util/h:gSF	Ljava/lang/Boolean;
    //   11: ifnonnull +58 -> 69
    //   14: new 116	java/io/FileInputStream
    //   17: dup
    //   18: new 52	java/io/File
    //   21: dup
    //   22: invokestatic 107	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   25: ldc 118
    //   27: invokespecial 121	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: invokespecial 124	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_2
    //   34: aload_2
    //   35: astore_1
    //   36: new 126	java/util/Properties
    //   39: dup
    //   40: invokespecial 128	java/util/Properties:<init>	()V
    //   43: astore_3
    //   44: aload_2
    //   45: astore_1
    //   46: aload_3
    //   47: aload_2
    //   48: invokevirtual 132	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: ldc -122
    //   56: invokevirtual 138	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   59: invokestatic 144	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   62: putstatic 19	com/tencent/mm/compatible/util/h:gSF	Ljava/lang/Boolean;
    //   65: aload_2
    //   66: invokevirtual 147	java/io/FileInputStream:close	()V
    //   69: getstatic 19	com/tencent/mm/compatible/util/h:gSF	Ljava/lang/Boolean;
    //   72: invokevirtual 150	java/lang/Boolean:booleanValue	()Z
    //   75: istore_0
    //   76: ldc2_w 112
    //   79: ldc 114
    //   81: invokestatic 22	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   84: iload_0
    //   85: ireturn
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_2
    //   89: aload_2
    //   90: astore_1
    //   91: ldc -104
    //   93: aload_3
    //   94: ldc -102
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 160	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_2
    //   104: astore_1
    //   105: iconst_0
    //   106: invokestatic 144	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   109: putstatic 19	com/tencent/mm/compatible/util/h:gSF	Ljava/lang/Boolean;
    //   112: aload_2
    //   113: ifnull -44 -> 69
    //   116: aload_2
    //   117: invokevirtual 147	java/io/FileInputStream:close	()V
    //   120: goto -51 -> 69
    //   123: astore_1
    //   124: goto -55 -> 69
    //   127: astore_2
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 147	java/io/FileInputStream:close	()V
    //   138: aload_2
    //   139: athrow
    //   140: astore_1
    //   141: goto -72 -> 69
    //   144: astore_1
    //   145: goto -7 -> 138
    //   148: astore_2
    //   149: goto -19 -> 130
    //   152: astore_3
    //   153: goto -64 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   75	10	0	bool	boolean
    //   35	70	1	localFileInputStream1	java.io.FileInputStream
    //   123	1	1	localException1	Exception
    //   129	6	1	localObject1	Object
    //   140	1	1	localException2	Exception
    //   144	1	1	localException3	Exception
    //   33	84	2	localFileInputStream2	java.io.FileInputStream
    //   127	12	2	localObject2	Object
    //   148	1	2	localObject3	Object
    //   43	11	3	localProperties	java.util.Properties
    //   86	8	3	localException4	Exception
    //   152	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   14	34	86	java/lang/Exception
    //   116	120	123	java/lang/Exception
    //   14	34	127	finally
    //   65	69	140	java/lang/Exception
    //   134	138	144	java/lang/Exception
    //   36	44	148	finally
    //   46	51	148	finally
    //   53	65	148	finally
    //   91	103	148	finally
    //   105	112	148	finally
    //   36	44	152	java/lang/Exception
    //   46	51	152	java/lang/Exception
    //   53	65	152	java/lang/Exception
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/compatible/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */