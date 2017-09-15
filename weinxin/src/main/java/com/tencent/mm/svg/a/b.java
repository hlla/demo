package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Gravity;
import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.svg.b.c;

public abstract class b
  extends Drawable
{
  protected View lBh;
  public long mDuration;
  protected final Rect tZ;
  protected int uLl;
  protected boolean uLm;
  protected Paint uLn;
  protected int uLo;
  protected int uLp;
  protected int uLq;
  protected int uLr;
  protected float uLs;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(3482547388416L, 25947);
    this.mDuration = 0L;
    this.uLl = 0;
    this.tZ = new Rect();
    this.uLm = false;
    this.uLn = new Paint();
    this.uLo = 0;
    this.uLp = 0;
    this.uLq = 0;
    this.uLr = 0;
    this.uLq = paramInt1;
    this.uLr = paramInt2;
    this.uLs = 1.0F;
    this.uLo = this.uLq;
    this.uLp = this.uLr;
    setLevel(10000);
    this.uLl = paramInt3;
    GMTrace.o(3482547388416L, 25947);
  }
  
  private void bNM()
  {
    GMTrace.i(3483218477056L, 25952);
    this.lBh = a.u(this);
    if (this.lBh != null) {
      a.b(this.lBh, this.uLn);
    }
    GMTrace.o(3483218477056L, 25952);
  }
  
  protected final void bNK()
  {
    GMTrace.i(3482681606144L, 25948);
    this.tZ.set(0, 0, getIntrinsicWidth(), getIntrinsicHeight());
    GMTrace.o(3482681606144L, 25948);
  }
  
  protected final void bNL()
  {
    GMTrace.i(3483084259328L, 25951);
    if (this.uLm)
    {
      Rect localRect = getBounds();
      Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), localRect, this.tZ);
    }
    this.uLm = false;
    GMTrace.o(3483084259328L, 25951);
  }
  
  public int getIntrinsicHeight()
  {
    GMTrace.i(3484158001152L, 25959);
    int i = this.uLp;
    GMTrace.o(3484158001152L, 25959);
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    GMTrace.i(3484023783424L, 25958);
    int i = this.uLo;
    GMTrace.o(3484023783424L, 25958);
    return i;
  }
  
  public int getOpacity()
  {
    GMTrace.i(3483755347968L, 25956);
    if ((this.lBh != null) && (this.lBh.getAlpha() < 1.0F))
    {
      GMTrace.o(3483755347968L, 25956);
      return -3;
    }
    if ((this.uLn != null) && (this.uLn.getAlpha() < 255))
    {
      GMTrace.o(3483755347968L, 25956);
      return -3;
    }
    GMTrace.o(3483755347968L, 25956);
    return 0;
  }
  
  protected final void n(Canvas paramCanvas)
  {
    GMTrace.i(3483889565696L, 25957);
    if (com.tencent.mm.svg.b.b.bNP())
    {
      int i = this.tZ.height() / 3;
      paramCanvas.save();
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setColor(-12303292);
      localPaint.setAlpha(127);
      localPaint.setTextSize(i);
      localPaint.setStrokeWidth(1.0F);
      float f = localPaint.measureText("SVG");
      paramCanvas.translate(this.tZ.width() - f, this.tZ.height() * 2 / 3);
      paramCanvas.drawText("SVG", 0.0F, i, localPaint);
      paramCanvas.restore();
    }
    GMTrace.o(3483889565696L, 25957);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    GMTrace.i(3482815823872L, 25949);
    this.uLm = true;
    GMTrace.o(3482815823872L, 25949);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    GMTrace.i(3482950041600L, 25950);
    bNM();
    boolean bool = super.onLevelChange(paramInt);
    GMTrace.o(3482950041600L, 25950);
    return bool;
  }
  
  @TargetApi(17)
  public void setAlpha(int paramInt)
  {
    GMTrace.i(3483486912512L, 25954);
    this.uLn.setAlpha(paramInt);
    if ((this.lBh != null) && (Build.VERSION.SDK_INT >= 17)) {
      try
      {
        this.lBh.setLayerPaint(this.uLn);
        GMTrace.o(3483486912512L, 25954);
        return;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        c.printErrStackTrace("MicroMsg.SVGDrawable", localNoSuchMethodError, "fucking samsung", new Object[0]);
      }
    }
    GMTrace.o(3483486912512L, 25954);
  }
  
  @TargetApi(17)
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    GMTrace.i(3483621130240L, 25955);
    this.uLn.setColorFilter(paramColorFilter);
    if ((this.lBh != null) && (Build.VERSION.SDK_INT >= 17)) {
      try
      {
        this.lBh.setLayerPaint(this.uLn);
        GMTrace.o(3483621130240L, 25955);
        return;
      }
      catch (NoSuchMethodError paramColorFilter)
      {
        c.printErrStackTrace("MicroMsg.SVGDrawable", paramColorFilter, "fucking samsung", new Object[0]);
      }
    }
    GMTrace.o(3483621130240L, 25955);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(3483352694784L, 25953);
    bNM();
    paramBoolean1 = super.setVisible(paramBoolean1, paramBoolean2);
    GMTrace.o(3483352694784L, 25953);
    return paramBoolean1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/svg/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */