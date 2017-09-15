package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.be.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.x.d.a;
import java.io.IOException;

public final class b
  extends j
  implements d.a
{
  Bitmap kat;
  private float sGC;
  
  private b(String paramString)
  {
    super(a.b.bDS(), paramString);
    GMTrace.i(1180579135488L, 8796);
    this.sGC = 0.5F;
    this.kat = null;
    GMTrace.o(1180579135488L, 8796);
  }
  
  public b(String paramString, float paramFloat)
  {
    this(paramString);
    GMTrace.i(1180713353216L, 8797);
    this.sGC = paramFloat;
    GMTrace.o(1180713353216L, 8797);
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    GMTrace.i(1181116006400L, 8800);
    Rect localRect2 = getBounds();
    Rect localRect1 = null;
    if ((this.sHA > 1.0F) || (this.sHu))
    {
      int i = paramBitmap.getHeight() / 15 / 2;
      int j = paramBitmap.getWidth() / 15 / 2;
      localRect1 = new Rect(j, i, paramBitmap.getWidth() - j, paramBitmap.getHeight() - i);
    }
    paramCanvas.drawBitmap(paramBitmap, localRect1, localRect2, hgO);
    GMTrace.o(1181116006400L, 8800);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = null;
    GMTrace.i(1180981788672L, 8799);
    com.tencent.mm.be.a.a locala = a.a.unq;
    if (locala != null) {
      localBitmap = a.a.unq.zm(this.tag);
    }
    if (localBitmap != null)
    {
      a(paramCanvas, localBitmap);
      GMTrace.o(1180981788672L, 8799);
      return;
    }
    if (this.sHv) {}
    for (localBitmap = this.ouZ.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1); localBitmap != null; localBitmap = this.ouZ.bf(this.tag))
    {
      localBitmap = d.a(localBitmap, false, this.sGC * localBitmap.getWidth());
      if (locala != null) {
        locala.o(this.tag, localBitmap);
      }
      a(paramCanvas, localBitmap);
      GMTrace.o(1180981788672L, 8799);
      return;
    }
    if (((localBitmap != null) && (!localBitmap.isRecycled())) || (this.kat == null)) {}
    try
    {
      this.kat = BackwardSupportUtil.b.a(aa.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bg.a.getDensity(null));
      this.kat = d.a(this.kat, false, this.sGC * this.kat.getWidth());
      a(paramCanvas, this.kat);
      GMTrace.o(1180981788672L, 8799);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.AvatarRoundDrawable", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final void ho(String paramString)
  {
    GMTrace.i(1180847570944L, 8798);
    super.ho(paramString);
    GMTrace.o(1180847570944L, 8798);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */