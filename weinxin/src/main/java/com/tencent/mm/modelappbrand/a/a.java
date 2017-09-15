package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.i;
import android.support.v4.b.a.k;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.j;
import com.tencent.mm.sdk.platformtools.aa;
import java.lang.ref.WeakReference;

public enum a
{
  private static volatile WeakReference<Bitmap> hpJ;
  
  static
  {
    GMTrace.i(12923690811392L, 96289);
    hpK = new a[0];
    GMTrace.o(12923690811392L, 96289);
  }
  
  public static Drawable AX()
  {
    GMTrace.i(12923556593664L, 96288);
    if ((hpJ == null) || (hpJ.get() == null) || (((Bitmap)hpJ.get()).isRecycled())) {
      hpJ = new WeakReference(com.tencent.mm.compatible.f.a.decodeResource(aa.getResources(), a.j.ber));
    }
    i locali = k.a(aa.getResources(), (Bitmap)hpJ.get());
    locali.bt();
    GMTrace.o(12923556593664L, 96288);
    return locali;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelappbrand/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */