package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class e
  extends d
{
  private int abH;
  private int wd;
  private ImageSpan xok;
  
  public e(Paint paramPaint, String paramString, ImageSpan paramImageSpan, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramPaint, 2, paramString, paramFloat);
    GMTrace.i(18951811629056L, 141202);
    this.xok = paramImageSpan;
    this.abH = paramInt1;
    this.wd = paramInt2;
    this.wwv = paramFloat;
    GMTrace.o(18951811629056L, 141202);
  }
  
  public final float Cv(int paramInt)
  {
    GMTrace.i(18755048439808L, 139736);
    float f = this.xok.getDrawable().getBounds().height() + paramInt;
    GMTrace.o(18755048439808L, 139736);
    return f;
  }
  
  public final void a(Canvas paramCanvas, RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(18917317672960L, 140945);
    caQ();
    paramFloat1 = paramRectF.top + (int)((paramRectF.height() - wwx.descent() - wwx.ascent()) / 2.0F) + (wwx.getFontMetrics().bottom - wwx.getFontMetrics().top) / 2.0F - this.xok.getDrawable().getBounds().height() / 2;
    int i = (int)(paramRectF.left + (paramRectF.width() - this.xok.getDrawable().getBounds().width()) / 2.0F);
    v.i("ImageCell", "[draw] rect:%s drawX:%s drawY:%s", new Object[] { paramRectF, Integer.valueOf(i), Float.valueOf(paramFloat1) });
    this.xok.draw(paramCanvas, "", this.abH, this.wd, i, (int)paramRectF.top, (int)paramFloat1, (int)paramRectF.bottom, wwx);
    GMTrace.o(18917317672960L, 140945);
  }
  
  public final boolean caN()
  {
    GMTrace.i(18754511568896L, 139732);
    GMTrace.o(18754511568896L, 139732);
    return false;
  }
  
  public final d caP()
  {
    GMTrace.i(18755182657536L, 139737);
    e locale = new e(this.fu, this.jpC, this.xok, this.abH, this.wd, this.wwv);
    GMTrace.o(18755182657536L, 139737);
    return locale;
  }
  
  public final int getLength()
  {
    GMTrace.i(18754780004352L, 139734);
    int i = super.getLength();
    if (i < 2)
    {
      GMTrace.o(18754780004352L, 139734);
      return 2;
    }
    GMTrace.o(18754780004352L, 139734);
    return i;
  }
  
  public final float getWidth()
  {
    GMTrace.i(18754645786624L, 139733);
    float f = this.xok.getDrawable().getBounds().width();
    GMTrace.o(18754645786624L, 139733);
    return f;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */