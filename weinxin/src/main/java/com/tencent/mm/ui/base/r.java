package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@TargetApi(16)
final class r
  extends SurfaceTexture
{
  public SurfaceTexture lzC;
  
  public r()
  {
    super(0);
    GMTrace.i(3355980070912L, 25004);
    this.lzC = null;
    GMTrace.o(3355980070912L, 25004);
  }
  
  private static String AD()
  {
    GMTrace.i(3356651159552L, 25009);
    StringBuilder localStringBuilder = new StringBuilder(256);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject2 = aa.getContext();
    localStringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
    localStringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + f.fuN);
    Object localObject3 = new StringBuilder("#accinfo.env=");
    Object localObject1;
    if (b.foreground) {
      localObject1 = "f";
    }
    for (;;)
    {
      localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + b.uqf);
      try
      {
        localObject1 = Environment.getDataDirectory();
        localObject3 = new StatFs(((File)localObject1).getPath());
        StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.hgi);
        localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)((Context)localObject2).getSystemService("activity")).getMemoryClass()), ((File)localObject1).getAbsolutePath(), Integer.valueOf(((StatFs)localObject3).getBlockSize()), Integer.valueOf(((StatFs)localObject3).getBlockCount()), Integer.valueOf(((StatFs)localObject3).getAvailableBlocks()), com.tencent.mm.compatible.util.e.hgi, Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
        localStringBuilderPrinter.println("#accinfo.data=" + (String)localObject1);
        localObject1 = new Date();
        localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilderPrinter.println("#accinfo.crashTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
        localStringBuilderPrinter.println("#crashContent=");
        localObject1 = localStringBuilder.toString();
        GMTrace.o(3356651159552L, 25009);
        return (String)localObject1;
        localObject1 = "b";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", new Object[] { localException.getMessage() });
          String str = "";
        }
      }
    }
  }
  
  public final void attachToGLContext(int paramInt)
  {
    GMTrace.i(3356785377280L, 25010);
    v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
    this.lzC.attachToGLContext(paramInt);
    GMTrace.o(3356785377280L, 25010);
  }
  
  public final void detachFromGLContext()
  {
    GMTrace.i(3356516941824L, 25008);
    v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
    try
    {
      this.lzC.detachFromGLContext();
      bool = false;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject1 = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
          ((Method)localObject1).setAccessible(true);
          int i = ((Integer)((Method)localObject1).invoke(this.lzC, new Object[0])).intValue();
          localObject1 = AD() + " detect texture problem error code = " + i + ", detach = true, and error = " + bool;
          b.r(Base64.encodeToString(((String)localObject1).getBytes(), 2), "DetachFromGLContext");
          v.w("MicroMsg.MMSurfaceTextureWrap", (String)localObject1);
          v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(true), Boolean.valueOf(bool) });
          GMTrace.o(3356516941824L, 25008);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          v.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localIllegalArgumentException, "%s", new Object[] { "detect texture problem, IllegalArgumentException" });
          String str1 = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + bool;
          b.r(Base64.encodeToString(str1.getBytes(), 2), "DetachFromGLContext");
          v.w("MicroMsg.MMSurfaceTextureWrap", str1);
          v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool) });
          GMTrace.o(3356516941824L, 25008);
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          v.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localIllegalAccessException, "%s", new Object[] { "detect texture problem, IllegalAccessException" });
          String str2 = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + bool;
          b.r(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
          v.w("MicroMsg.MMSurfaceTextureWrap", str2);
          v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool) });
          GMTrace.o(3356516941824L, 25008);
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          v.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localInvocationTargetException, "%s", new Object[] { "detect texture problem, InvocationTargetException" });
          String str3 = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + bool;
          b.r(Base64.encodeToString(str3.getBytes(), 2), "DetachFromGLContext");
          v.w("MicroMsg.MMSurfaceTextureWrap", str3);
          v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool) });
          GMTrace.o(3356516941824L, 25008);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          v.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localNoSuchMethodException, "%s", new Object[] { "detect texture problem, NoSuchMethodException" });
          String str4 = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + bool;
          b.r(Base64.encodeToString(str4.getBytes(), 2), "DetachFromGLContext");
          v.w("MicroMsg.MMSurfaceTextureWrap", str4);
          v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool) });
          GMTrace.o(3356516941824L, 25008);
          return;
        }
        catch (Exception localException2)
        {
          v.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localException2, "%s", new Object[] { "detect texture problem, Exception" });
          String str5 = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + bool;
          b.r(Base64.encodeToString(str5.getBytes(), 2), "DetachFromGLContext");
          v.w("MicroMsg.MMSurfaceTextureWrap", str5);
          v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool) });
          GMTrace.o(3356516941824L, 25008);
          return;
        }
        finally
        {
          boolean bool;
          String str6 = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + bool;
          b.r(Base64.encodeToString(str6.getBytes(), 2), "DetachFromGLContext");
          v.w("MicroMsg.MMSurfaceTextureWrap", str6);
          v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool) });
        }
        localException1 = localException1;
        v.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", localException1, "%s", new Object[] { "detect texture problem, RuntimeException detachFromGLContext" });
        bool = true;
      }
    }
    if (bool) {}
    GMTrace.o(3356516941824L, 25008);
  }
  
  public final boolean equals(Object paramObject)
  {
    GMTrace.i(3357322248192L, 25014);
    boolean bool = this.lzC.equals(paramObject);
    GMTrace.o(3357322248192L, 25014);
    return bool;
  }
  
  public final long getTimestamp()
  {
    GMTrace.i(3357053812736L, 25012);
    v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
    long l = this.lzC.getTimestamp();
    GMTrace.o(3357053812736L, 25012);
    return l;
  }
  
  public final void getTransformMatrix(float[] paramArrayOfFloat)
  {
    GMTrace.i(3356919595008L, 25011);
    v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
    this.lzC.getTransformMatrix(paramArrayOfFloat);
    GMTrace.o(3356919595008L, 25011);
  }
  
  public final int hashCode()
  {
    GMTrace.i(3357456465920L, 25015);
    int i = this.lzC.hashCode();
    GMTrace.o(3357456465920L, 25015);
    return i;
  }
  
  public final void release()
  {
    GMTrace.i(3357188030464L, 25013);
    super.release();
    v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
    this.lzC.release();
    GMTrace.o(3357188030464L, 25013);
  }
  
  @TargetApi(19)
  public final void releaseTexImage()
  {
    GMTrace.i(3357724901376L, 25017);
    v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
    this.lzC.releaseTexImage();
    GMTrace.o(3357724901376L, 25017);
  }
  
  public final void setDefaultBufferSize(int paramInt1, int paramInt2)
  {
    GMTrace.i(3356248506368L, 25006);
    v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
    this.lzC.setDefaultBufferSize(paramInt1, paramInt2);
    GMTrace.o(3356248506368L, 25006);
  }
  
  public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    GMTrace.i(3356114288640L, 25005);
    v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
    this.lzC.setOnFrameAvailableListener(paramOnFrameAvailableListener);
    GMTrace.o(3356114288640L, 25005);
  }
  
  public final String toString()
  {
    GMTrace.i(3357590683648L, 25016);
    String str = this.lzC.toString();
    GMTrace.o(3357590683648L, 25016);
    return str;
  }
  
  public final void updateTexImage()
  {
    GMTrace.i(3356382724096L, 25007);
    v.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
    this.lzC.updateTexImage();
    GMTrace.o(3356382724096L, 25007);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */