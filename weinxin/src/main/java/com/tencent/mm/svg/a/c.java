package com.tencent.mm.svg.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;

public final class c
  extends b
{
  private a uLt;
  
  public c(Picture paramPicture, int paramInt) {}
  
  public final void draw(Canvas paramCanvas)
  {
    int i = 1;
    int j = 0;
    GMTrace.i(3482413170688L, 25946);
    long l1 = com.tencent.mm.svg.b.b.bNS();
    label268:
    label345:
    label372:
    label446:
    label483:
    label507:
    label509:
    for (;;)
    {
      long l2;
      try
      {
        if (!paramCanvas.isHardwareAccelerated()) {
          break label372;
        }
        if (this.uLt.uLu == null)
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", new Object[] { Integer.valueOf(this.uLl) });
          if (this.uLt.uLv == null) {
            break label507;
          }
          if (!this.uLt.uLv.isRecycled()) {
            break label345;
          }
          break label507;
          if (this.lBh == null) {
            this.lBh = a.u(this);
          }
          a.b(this.lBh, this.uLn);
          if (i != 0) {
            break label483;
          }
          if ((!paramCanvas.isHardwareAccelerated()) || (Build.VERSION.SDK_INT >= 16)) {
            break label446;
          }
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
          this.mDuration = com.tencent.mm.svg.b.b.eD(l1);
          n(paramCanvas);
          GMTrace.o(3482413170688L, 25946);
          return;
        }
        l2 = System.nanoTime();
        if ((this.uLt.uLv != null) && (!this.uLt.uLv.isRecycled())) {
          continue;
        }
        if ((getIntrinsicWidth() > 2048) || (getIntrinsicHeight() > 2048))
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", new Object[] { Integer.valueOf(this.uLl) });
          continue;
        }
        if (getIntrinsicWidth() <= 0) {
          break label268;
        }
      }
      finally
      {
        this.mDuration = com.tencent.mm.svg.b.b.eD(l1);
        n(paramCanvas);
      }
      if (getIntrinsicHeight() <= 0)
      {
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
      }
      else
      {
        Object localObject2 = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas((Bitmap)localObject2);
        this.uLt.uLu.draw(localCanvas);
        this.uLt.uLv = ((Bitmap)localObject2);
        com.tencent.mm.svg.b.b.eD(l2);
        n(localCanvas);
        continue;
        bNL();
        paramCanvas.drawBitmap(this.uLt.uLv, null, this.tZ, this.uLn);
        break label509;
        i = j;
        if (this.uLt.uLv != null)
        {
          i = j;
          if (!this.uLt.uLv.isRecycled())
          {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", new Object[] { this.uLt.uLv.toString() });
            this.uLt.uLv.recycle();
            this.uLt.uLv = null;
            i = j;
            continue;
            localObject2 = this.uLt.uLu;
            if (localObject2 != null)
            {
              bNL();
              paramCanvas.save();
              paramCanvas.drawPicture((Picture)localObject2, this.tZ);
              paramCanvas.restore();
            }
            this.mDuration = com.tencent.mm.svg.b.b.eD(l1);
            n(paramCanvas);
            GMTrace.o(3482413170688L, 25946);
            return;
            i = 0;
          }
        }
      }
    }
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    GMTrace.i(3482278952960L, 25945);
    a locala = this.uLt;
    GMTrace.o(3482278952960L, 25945);
    return locala;
  }
  
  public static final class a
    extends Drawable.ConstantState
  {
    protected int rba;
    protected Picture uLu;
    protected Bitmap uLv;
    
    public a(Picture paramPicture, int paramInt)
    {
      GMTrace.i(3489392492544L, 25998);
      this.uLu = paramPicture;
      this.rba = paramInt;
      GMTrace.o(3489392492544L, 25998);
    }
    
    public final int getChangingConfigurations()
    {
      GMTrace.i(3489660928000L, 26000);
      GMTrace.o(3489660928000L, 26000);
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      GMTrace.i(3489526710272L, 25999);
      c localc = new c(this.uLu, this.rba);
      GMTrace.o(3489526710272L, 25999);
      return localc;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/svg/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */