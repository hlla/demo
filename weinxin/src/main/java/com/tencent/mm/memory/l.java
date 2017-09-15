package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.v;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l
{
  private static m hgA;
  private static int hgB;
  private static j hgz;
  
  static
  {
    GMTrace.i(1287684882432L, 9594);
    hgz = new j();
    hgA = new m();
    hgB = -1;
    GMTrace.o(1287684882432L, 9594);
  }
  
  public l()
  {
    GMTrace.i(1286745358336L, 9587);
    GMTrace.o(1286745358336L, 9587);
  }
  
  protected static void d(InputStream paramInputStream)
  {
    GMTrace.i(1287148011520L, 9590);
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      if (!(paramInputStream instanceof FileInputStream)) {
        break label51;
      }
    }
    for (localObject = new i((FileInputStream)paramInputStream);; localObject = new BufferedInputStream(paramInputStream, 65536)) {
      try
      {
        ((InputStream)localObject).reset();
        GMTrace.o(1287148011520L, 9590);
        return;
      }
      catch (Exception paramInputStream)
      {
        label51:
        v.printErrStackTrace("MicroMsg.PlatformBitmapFactory", paramInputStream, "reset stream error: %s", new Object[] { paramInputStream.getMessage() });
        GMTrace.o(1287148011520L, 9590);
      }
    }
  }
  
  public static l wu()
  {
    GMTrace.i(1286879576064L, 9588);
    if (hgB == -1) {
      if (!wv()) {
        break label67;
      }
    }
    label67:
    for (hgB = 1;; hgB = 2) {
      switch (hgB)
      {
      default: 
        localObject = hgA;
        GMTrace.o(1286879576064L, 9588);
        return (l)localObject;
      }
    }
    Object localObject = hgz;
    GMTrace.o(1286879576064L, 9588);
    return (l)localObject;
    localObject = hgA;
    GMTrace.o(1286879576064L, 9588);
    return (l)localObject;
  }
  
  public static boolean wv()
  {
    GMTrace.i(1287013793792L, 9589);
    boolean bool = d.eo(19);
    v.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(bf.bJS()), Boolean.valueOf(bool) });
    GMTrace.o(1287013793792L, 9589);
    return bool;
  }
  
  public abstract Bitmap a(String paramString, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger);
  
  public abstract Bitmap a(String paramString, Rect paramRect, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger);
  
  public abstract void f(Bitmap paramBitmap);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/memory/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */