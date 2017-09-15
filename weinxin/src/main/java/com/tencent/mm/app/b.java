package com.tencent.mm.app;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.k;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.x.d;
import com.tencent.mm.x.d.a;
import com.tencent.mm.x.n;

final class b
  implements j.a
{
  private Bitmap fvE;
  d fvF;
  
  public b()
  {
    GMTrace.i(13043278807040L, 97180);
    this.fvE = null;
    this.fvE = a.decodeResource(aa.getContext().getResources(), R.k.ber);
    GMTrace.o(13043278807040L, 97180);
  }
  
  public final Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(13043949895680L, 97185);
    paramString = com.tencent.mm.x.b.b(paramString, paramInt1, paramInt2, paramInt3);
    GMTrace.o(13043949895680L, 97185);
    return paramString;
  }
  
  public final void a(j paramj)
  {
    GMTrace.i(13043413024768L, 97181);
    if ((paramj instanceof d.a)) {
      n.Bl().a((d.a)paramj);
    }
    GMTrace.o(13043413024768L, 97181);
  }
  
  public final Bitmap bf(String paramString)
  {
    GMTrace.i(13043547242496L, 97182);
    paramString = com.tencent.mm.x.b.a(paramString, false, -1);
    GMTrace.o(13043547242496L, 97182);
    return paramString;
  }
  
  public final Bitmap bg(String paramString)
  {
    GMTrace.i(13043815677952L, 97184);
    if (this.fvF == null) {
      this.fvF = n.Bl();
    }
    paramString = d.hj(paramString);
    GMTrace.o(13043815677952L, 97184);
    return paramString;
  }
  
  public final Bitmap nZ()
  {
    GMTrace.i(13043681460224L, 97183);
    Bitmap localBitmap = this.fvE;
    GMTrace.o(13043681460224L, 97183);
    return localBitmap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/app/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */