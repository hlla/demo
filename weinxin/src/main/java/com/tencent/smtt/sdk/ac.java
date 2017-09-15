package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import java.nio.channels.FileLock;

public class ac
{
  private static ac wUT;
  private static FileLock wUW = null;
  boolean wRC;
  ad wUU;
  private boolean wUV;
  
  public static FileLock ceQ()
  {
    return wUW;
  }
  
  public static ac ceR()
  {
    if (wUT == null) {}
    try
    {
      if (wUT == null) {
        wUT = new ac();
      }
      return wUT;
    }
    finally {}
  }
  
  public final void b(Context paramContext, o paramo)
  {
    Object localObject4 = null;
    if (paramo != null) {}
    for (;;)
    {
      d locald;
      StringBuilder localStringBuilder;
      w localw;
      try
      {
        paramo.a("x5_core_engine_init_sync", (byte)2);
        locald = d.lY(true);
        locald.a(paramContext, paramo);
        localStringBuilder = new StringBuilder();
        if (paramo != null) {
          paramo.a("init_x5_core", (byte)1);
        }
        localw = locald.cdI();
        if ((locald.wRB) && (localw != null))
        {
          if (this.wRC) {
            break label604;
          }
          if (paramo != null) {
            paramo.wSS = true;
          }
          this.wUU = new ad(localw.wUo);
          try
          {
            this.wUV = this.wUU.ceU();
            if (!this.wUV) {
              localStringBuilder.append("can not use X5 by x5corewizard return false");
            }
            localObject1 = null;
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            Object localObject1;
            boolean bool;
            this.wUV = true;
            Object localObject2 = null;
            continue;
          }
          catch (Throwable localThrowable1)
          {
            this.wUV = false;
            localStringBuilder.append("can not use x5 by throwable " + Log.getStackTraceString(localThrowable1));
            continue;
          }
          localObject3 = localObject1;
          if (this.wUV)
          {
            CookieManager.getInstance().n(paramContext, true);
            CookieManager.getInstance().cdE();
            localObject3 = localObject1;
          }
          if (this.wUV) {
            break label584;
          }
          TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
          bool = locald.wRB;
          if ((!bool) || (localw == null) || (localObject3 != null)) {
            break label502;
          }
        }
      }
      finally {}
      try
      {
        localObject3 = localw.wUo;
        localObject1 = localObject4;
        if (localObject3 != null) {
          localObject1 = ((DexLoader)localObject3).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
        }
        if ((localObject1 instanceof Throwable))
        {
          localObject3 = (Throwable)localObject1;
          localStringBuilder.append("#" + ((Throwable)localObject3).getMessage() + "; cause: " + ((Throwable)localObject3).getCause() + "; th: " + localObject3);
        }
        if ((localObject1 instanceof String)) {
          localStringBuilder.append("failure detail:" + localObject1);
        }
      }
      catch (Throwable localThrowable2)
      {
        label502:
        label584:
        continue;
      }
      if (localStringBuilder.toString().contains("isPreloadX5Disabled:-10000"))
      {
        i.cdS().a(paramContext, 408, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + localStringBuilder.toString()));
        this.wRC = true;
        if (paramo != null) {
          paramo.a("init_x5_core", (byte)2);
        }
        return;
        this.wUV = false;
        localStringBuilder.append("can not use X5 by !tbs available");
      }
      else
      {
        i.cdS().a(paramContext, 407, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + localStringBuilder.toString()));
        continue;
        if (locald.wRB)
        {
          i.cdS().a(paramContext, 409, new Throwable("mCanUseX5=false, available true, reason: " + localObject3));
          continue;
        }
        i.cdS().a(paramContext, 410, new Throwable("mCanUseX5=false, available false, reason: " + localObject3));
        continue;
        if (wUW != null) {
          continue;
        }
        gF(paramContext);
        continue;
      }
      label604:
      Object localObject3 = null;
    }
  }
  
  public final boolean ceS()
  {
    if (QbSdk.wQZ) {
      return false;
    }
    return this.wUV;
  }
  
  public final ad ceT()
  {
    if (QbSdk.wQZ) {
      return null;
    }
    return this.wUU;
  }
  
  /* Error */
  public final FileLock gF(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 17	com/tencent/smtt/sdk/ac:wUW	Ljava/nio/channels/FileLock;
    //   5: ifnull +11 -> 16
    //   8: getstatic 17	com/tencent/smtt/sdk/ac:wUW	Ljava/nio/channels/FileLock;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_1
    //   17: iconst_1
    //   18: ldc -56
    //   20: invokestatic 205	com/tencent/smtt/utils/f:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +10 -> 35
    //   28: aload_1
    //   29: invokestatic 208	com/tencent/smtt/utils/f:a	(Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   32: putstatic 17	com/tencent/smtt/sdk/ac:wUW	Ljava/nio/channels/FileLock;
    //   35: getstatic 17	com/tencent/smtt/sdk/ac:wUW	Ljava/nio/channels/FileLock;
    //   38: astore_1
    //   39: goto -27 -> 12
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	ac
    //   0	47	1	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	12	42	finally
    //   16	24	42	finally
    //   28	35	42	finally
    //   35	39	42	finally
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */