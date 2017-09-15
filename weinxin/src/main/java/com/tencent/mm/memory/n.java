package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
  implements i
{
  private static ConcurrentHashMap<Bitmap, Integer> hgG;
  private boolean DEBUG;
  public Bitmap bitmap;
  private ad hgD;
  private boolean hgE;
  private AtomicInteger hgF;
  private boolean hgH;
  private Runnable hgI;
  private int hgJ;
  private int hgK;
  
  static
  {
    GMTrace.i(1294127333376L, 9642);
    hgG = new ConcurrentHashMap();
    GMTrace.o(1294127333376L, 9642);
  }
  
  private n(Bitmap paramBitmap)
  {
    GMTrace.i(1292248285184L, 9628);
    this.bitmap = null;
    this.DEBUG = false;
    this.hgD = new ad(Looper.getMainLooper());
    this.hgE = false;
    this.hgF = new AtomicInteger();
    this.hgH = true;
    this.hgI = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1280168689664L, 9538);
        n.this.wz();
        GMTrace.o(1280168689664L, 9538);
      }
    };
    this.hgJ = 0;
    this.hgK = 0;
    this.bitmap = paramBitmap;
    this.hgF.set(1);
    if (this.DEBUG) {
      v.i("MicroMsg.ReleasableBitmap", "bitmap " + paramBitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bf.bJP().toString());
    }
    this.hgE = false;
    getAllocationByteCount();
    GMTrace.o(1292248285184L, 9628);
  }
  
  public static n g(Bitmap paramBitmap)
  {
    GMTrace.i(1292382502912L, 9629);
    if (paramBitmap == null)
    {
      GMTrace.o(1292382502912L, 9629);
      return null;
    }
    paramBitmap = new n(paramBitmap);
    GMTrace.o(1292382502912L, 9629);
    return paramBitmap;
  }
  
  protected final void finalize()
  {
    GMTrace.i(1293724680192L, 9639);
    if (this.DEBUG) {
      v.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
    }
    GMTrace.o(1293724680192L, 9639);
  }
  
  public final int getAllocationByteCount()
  {
    GMTrace.i(1293456244736L, 9637);
    if (d.ep(19))
    {
      if ((this.bitmap == null) || (this.bitmap.isRecycled()))
      {
        v.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.hgJ + " " + toString());
        i = this.hgJ;
        GMTrace.o(1293456244736L, 9637);
        return i;
      }
      this.hgJ = this.bitmap.getByteCount();
      i = this.hgJ;
      GMTrace.o(1293456244736L, 9637);
      return i;
    }
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      v.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.hgK + " " + toString());
      i = this.hgK;
      GMTrace.o(1293456244736L, 9637);
      return i;
    }
    this.hgK = this.bitmap.getAllocationByteCount();
    int i = this.hgK;
    GMTrace.o(1293456244736L, 9637);
    return i;
  }
  
  public final boolean isRecycled()
  {
    GMTrace.i(1293053591552L, 9634);
    if ((this.hgE) || (this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      GMTrace.o(1293053591552L, 9634);
      return true;
    }
    GMTrace.o(1293053591552L, 9634);
    return false;
  }
  
  public final String toString()
  {
    GMTrace.i(1293590462464L, 9638);
    if (this.DEBUG)
    {
      String str2 = super.toString() + " code: " + hashCode() + " attachCount: " + this.hgF;
      str1 = str2;
      if (this.bitmap != null) {
        str1 = str2 + this.bitmap;
      }
      GMTrace.o(1293590462464L, 9638);
      return str1;
    }
    String str1 = super.toString();
    GMTrace.o(1293590462464L, 9638);
    return str1;
  }
  
  public final String wA()
  {
    GMTrace.i(1293858897920L, 9640);
    String str = this + " " + this.bitmap;
    GMTrace.o(1293858897920L, 9640);
    return str;
  }
  
  public final void ws()
  {
    GMTrace.i(1292650938368L, 9631);
    this.hgF.incrementAndGet();
    if (this.DEBUG) {
      v.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.hgF + " bitmap:" + this.bitmap + " " + this + " " + bf.bJP().toString());
    }
    GMTrace.o(1292650938368L, 9631);
  }
  
  public final void wt()
  {
    GMTrace.i(1292785156096L, 9632);
    if (this.DEBUG) {
      v.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.hgF + " bitmap:" + this.bitmap + " " + this + " " + bf.bJP().toString());
    }
    if (this.hgF.get() > 0)
    {
      this.hgF.decrementAndGet();
      if (this.hgF.get() < 0)
      {
        GMTrace.o(1292785156096L, 9632);
        return;
      }
      this.hgD.removeCallbacks(this.hgI);
      this.hgD.postDelayed(this.hgI, 500L);
    }
    GMTrace.o(1292785156096L, 9632);
  }
  
  public final Bitmap ww()
  {
    GMTrace.i(1292516720640L, 9630);
    this.hgH = false;
    Bitmap localBitmap = this.bitmap;
    GMTrace.o(1292516720640L, 9630);
    return localBitmap;
  }
  
  public final Bitmap wx()
  {
    GMTrace.i(1292919373824L, 9633);
    if (this.DEBUG) {
      v.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bf.bJP().toString());
    }
    Bitmap localBitmap = this.bitmap;
    GMTrace.o(1292919373824L, 9633);
    return localBitmap;
  }
  
  public final boolean wy()
  {
    GMTrace.i(1293187809280L, 9635);
    this.hgF.decrementAndGet();
    if (this.DEBUG) {
      v.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.hgE + " isMutable:" + this.hgH + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.hgF + bf.bJP().toString());
    }
    wz();
    GMTrace.o(1293187809280L, 9635);
    return true;
  }
  
  public final boolean wz()
  {
    GMTrace.i(1293322027008L, 9636);
    if (this.DEBUG) {
      v.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.hgE + " isMutable:" + this.hgH + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.hgF + bf.bJP().toString());
    }
    if ((this.hgE) || (this.hgF.get() > 0))
    {
      GMTrace.o(1293322027008L, 9636);
      return false;
    }
    this.hgE = true;
    if (this.DEBUG) {
      hgG.remove(this.bitmap);
    }
    if (this.hgH) {
      l.wu().f(this.bitmap);
    }
    GMTrace.o(1293322027008L, 9636);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/memory/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */