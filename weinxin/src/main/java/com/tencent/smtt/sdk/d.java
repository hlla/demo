package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

class d
{
  private static d wRA = null;
  private static int wRD = 0;
  private static int wRE = 0;
  static boolean wRF = false;
  private static int wRG = 3;
  private static String wRI = null;
  boolean wRB = false;
  boolean wRC = false;
  private File wRH = null;
  w wRz = null;
  
  static void CO(int paramInt)
  {
    wRD = paramInt;
  }
  
  private void CP(int paramInt)
  {
    Properties localProperties = new Properties();
    localProperties.setProperty(wRI, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.wRH, "count.prop")), null);
      return;
    }
    catch (IOException localIOException) {}catch (FileNotFoundException localFileNotFoundException) {}
  }
  
  static void Vk(String paramString)
  {
    wRI = paramString;
  }
  
  public static int cdJ()
  {
    return wRD;
  }
  
  static boolean cdK()
  {
    wRF = true;
    return true;
  }
  
  /* Error */
  private int cdL()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 70	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 46	com/tencent/smtt/sdk/d:wRH	Ljava/io/File;
    //   10: ldc 72
    //   12: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 94	java/io/File:exists	()Z
    //   20: ifne +5 -> 25
    //   23: iconst_0
    //   24: ireturn
    //   25: new 96	java/io/BufferedInputStream
    //   28: dup
    //   29: new 98	java/io/FileInputStream
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 99	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: invokespecial 102	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore_2
    //   41: new 55	java/util/Properties
    //   44: dup
    //   45: invokespecial 56	java/util/Properties:<init>	()V
    //   48: astore_3
    //   49: aload_3
    //   50: aload_2
    //   51: invokevirtual 105	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   54: aload_3
    //   55: getstatic 34	com/tencent/smtt/sdk/d:wRI	Ljava/lang/String;
    //   58: ldc 107
    //   60: invokevirtual 111	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   63: invokestatic 116	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   66: invokevirtual 119	java/lang/Integer:intValue	()I
    //   69: istore_1
    //   70: aload_2
    //   71: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   74: iload_1
    //   75: ireturn
    //   76: astore_2
    //   77: iload_1
    //   78: ireturn
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_2
    //   82: aload_2
    //   83: ifnull +41 -> 124
    //   86: aload_2
    //   87: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   90: iconst_0
    //   91: ireturn
    //   92: astore_2
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_2
    //   96: aload_3
    //   97: ifnull +7 -> 104
    //   100: aload_3
    //   101: invokevirtual 122	java/io/BufferedInputStream:close	()V
    //   104: aload_2
    //   105: athrow
    //   106: astore_3
    //   107: goto -3 -> 104
    //   110: astore 4
    //   112: aload_2
    //   113: astore_3
    //   114: aload 4
    //   116: astore_2
    //   117: goto -21 -> 96
    //   120: astore_3
    //   121: goto -39 -> 82
    //   124: iconst_0
    //   125: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	d
    //   69	9	1	i	int
    //   15	56	2	localObject1	Object
    //   76	1	2	localIOException1	IOException
    //   79	1	2	localException1	Exception
    //   81	6	2	localObject2	Object
    //   92	1	2	localIOException2	IOException
    //   95	18	2	localObject3	Object
    //   116	1	2	localObject4	Object
    //   1	100	3	localProperties	Properties
    //   106	1	3	localIOException3	IOException
    //   113	1	3	localObject5	Object
    //   120	1	3	localException2	Exception
    //   110	5	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   70	74	76	java/io/IOException
    //   2	23	79	java/lang/Exception
    //   25	41	79	java/lang/Exception
    //   86	90	92	java/io/IOException
    //   2	23	95	finally
    //   25	41	95	finally
    //   100	104	106	java/io/IOException
    //   41	70	110	finally
    //   41	70	120	java/lang/Exception
  }
  
  public static d lY(boolean paramBoolean)
  {
    if ((wRA == null) && (paramBoolean)) {}
    try
    {
      if (wRA == null) {
        wRA = new d();
      }
      return wRA;
    }
    finally {}
  }
  
  public static boolean useSoftWare()
  {
    return QbSdk.useSoftWare();
  }
  
  public final void a(Context paramContext, o paramo)
  {
    int j = 0;
    boolean bool1;
    label121:
    boolean bool2;
    label188:
    int i;
    try
    {
      TbsLog.addLog(999, null, new Object[0]);
      TbsLog.initIfNeed(paramContext);
      wRE += 1;
      if (paramo != null)
      {
        if (wRE == 1)
        {
          bool1 = true;
          paramo.wST = bool1;
        }
      }
      else
      {
        localObject1 = i.cdS();
        if (((i)localObject1).wSp != null)
        {
          localObject2 = ((i)localObject1).wSp;
          Arrays.fill(((i.a)localObject2).wSu, 0);
          ((i.a)localObject2).wSv = 0;
          ((i.a)localObject2).wSw = 0;
        }
        ((i)localObject1).wSq = false;
        if (paramo != null) {
          paramo.a("tbs_rename_task", (byte)1);
        }
        localObject1 = p.ceq();
        if (wRE != 1) {
          break label212;
        }
        bool1 = true;
        ((p)localObject1).v(paramContext, bool1);
        if (paramo != null) {
          paramo.a("tbs_rename_task", (byte)2);
        }
        t.x(paramContext, true);
        if (paramo != null) {
          paramo.a("can_load_x5", (byte)1);
        }
        bool2 = QbSdk.p(paramContext, false);
        if (paramo != null) {
          paramo.a("can_load_x5", (byte)2);
        }
        if (Build.VERSION.SDK_INT < 7) {
          break label218;
        }
        bool1 = true;
        break label579;
        if (i == 0) {
          break label488;
        }
        bool1 = this.wRB;
        if (!bool1) {
          break label229;
        }
      }
      for (;;)
      {
        label203:
        return;
        bool1 = false;
        break;
        label212:
        bool1 = false;
        break label121;
        label218:
        bool1 = false;
        break label579;
        label224:
        i = 0;
        break label188;
        try
        {
          label229:
          if (!t.gu(paramContext)) {
            break label362;
          }
          TbsLog.addLog(995, null, new Object[0]);
          if (paramo != null) {
            paramo.a("read_core_info", (byte)1);
          }
          if (paramo != null) {
            paramo.a("read_core_info", (byte)2);
          }
          this.wRB = false;
          QbSdk.bu(paramContext, "SDKEngine::useSystemWebView by error_host_unavailable");
        }
        catch (Throwable paramo)
        {
          TbsLog.e("SDKEngine", "useSystemWebView by exception: " + paramo);
          i.cdS().a(paramContext, 327, paramo);
          this.wRB = false;
          QbSdk.bu(paramContext, "SDKEngine::useSystemWebView by exception: " + paramo);
        }
        label341:
        this.wRH = p.gm(paramContext);
        this.wRC = true;
      }
      TbsLog.addLog(996, null, new Object[0]);
    }
    finally {}
    label362:
    p.ceq();
    Object localObject2 = p.gk(paramContext);
    if (wRD != 25436)
    {
      i = j;
      if (wRD != 25437) {
        label407:
        if (i == 0) {
          break label599;
        }
      }
    }
    label488:
    label579:
    label599:
    for (Object localObject1 = paramContext.getApplicationContext();; localObject1 = paramContext)
    {
      if (localObject2 == null)
      {
        this.wRB = false;
        QbSdk.bu(paramContext, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
        break label203;
      }
      String[] arrayOfString = QbSdk.getDexLoaderFileList(paramContext, (Context)localObject1, ((File)localObject2).getAbsolutePath());
      this.wRz = new w(paramContext, (Context)localObject1, ((File)localObject2).getAbsolutePath(), ((File)localObject2).getAbsolutePath(), arrayOfString, QbSdk.wRg, paramo);
      this.wRB = true;
      break label341;
      paramo = "can_load_x5=" + bool2 + "; is_compatible=" + bool1;
      TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + paramo);
      if ((QbSdk.wQZ) && (this.wRB)) {
        break label341;
      }
      this.wRB = false;
      i.cdS().a(paramContext, 405, new Throwable(paramo));
      break label341;
      if ((!bool2) || (!bool1)) {
        break label224;
      }
      i = 1;
      break;
      i = 1;
      break label407;
    }
  }
  
  public final w cdI()
  {
    if (this.wRB) {
      return this.wRz;
    }
    return null;
  }
  
  final boolean getTbsNeedReboot()
  {
    int i;
    if (wRF)
    {
      if (wRI == null) {
        return false;
      }
      i = cdL();
      if (i != 0) {
        break label32;
      }
      CP(1);
    }
    for (;;)
    {
      return wRF;
      label32:
      if (i + 1 > wRG) {
        break;
      }
      CP(i + 1);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */