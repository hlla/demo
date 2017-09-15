package com.tencent.mm.ah.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ah.a.c.l;
import com.tencent.mm.ah.a.d.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
  implements l
{
  private a<String, Bitmap> hIW;
  private a<String, Bitmap> hIX;
  
  public f()
  {
    GMTrace.i(13718662414336L, 102212);
    this.hIW = new a(50);
    this.hIX = new a(10);
    GMTrace.o(13718662414336L, 102212);
  }
  
  public final void b(String paramString, Bitmap paramBitmap)
  {
    GMTrace.i(13718930849792L, 102214);
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
      GMTrace.o(13718930849792L, 102214);
      return;
    }
    if (paramBitmap == null)
    {
      v.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
      GMTrace.o(13718930849792L, 102214);
      return;
    }
    Bitmap localBitmap;
    long l;
    if ((paramBitmap != null) && ((paramBitmap instanceof Bitmap)))
    {
      localBitmap = (Bitmap)paramBitmap;
      if (Build.VERSION.SDK_INT >= 12) {
        l = localBitmap.getByteCount();
      }
    }
    for (;;)
    {
      v.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", new Object[] { paramString, Long.valueOf(l), bf.ay(l) });
      if (l <= 524288L) {
        break;
      }
      this.hIX.put(paramString, paramBitmap);
      GMTrace.o(13718930849792L, 102214);
      return;
      int i = localBitmap.getRowBytes();
      l = localBitmap.getHeight() * i;
      continue;
      l = 0L;
    }
    this.hIW.put(paramString, paramBitmap);
    GMTrace.o(13718930849792L, 102214);
  }
  
  public final void clear()
  {
    GMTrace.i(13719065067520L, 102215);
    Bitmap localBitmap;
    try
    {
      if (this.hIW != null)
      {
        Object localObject1 = this.hIW.snapshot();
        if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localBitmap != null) && (!localBitmap.isRecycled())) {
              v.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
            }
          }
        }
        this.hIW.clear();
      }
    }
    finally {}
    if (this.hIX != null)
    {
      Object localObject3 = this.hIX.snapshot();
      if ((!((Map)localObject3).isEmpty()) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject3).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            v.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      this.hIX.clear();
    }
    GMTrace.o(13719065067520L, 102215);
  }
  
  public final Bitmap gS(String paramString)
  {
    GMTrace.i(13718796632064L, 102213);
    if (!bf.mA(paramString))
    {
      if (this.hIW.get(paramString) == null)
      {
        paramString = (Bitmap)this.hIX.get(paramString);
        GMTrace.o(13718796632064L, 102213);
        return paramString;
      }
      paramString = (Bitmap)this.hIW.get(paramString);
      GMTrace.o(13718796632064L, 102213);
      return paramString;
    }
    GMTrace.o(13718796632064L, 102213);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */