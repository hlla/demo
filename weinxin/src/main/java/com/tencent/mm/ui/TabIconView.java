package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.d;

public class TabIconView
  extends ImageView
{
  private Paint jVY;
  private Bitmap uUS;
  private Bitmap uUT;
  private Bitmap uUU;
  private Rect uUV;
  private Rect uUW;
  private Rect uUX;
  private int uUY;
  
  public TabIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(2897760747520L, 21590);
    this.uUY = 0;
    GMTrace.o(2897760747520L, 21590);
  }
  
  public TabIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(2897626529792L, 21589);
    this.uUY = 0;
    GMTrace.o(2897626529792L, 21589);
  }
  
  public final void g(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    GMTrace.i(2897894965248L, 21591);
    if (paramBoolean)
    {
      this.uUS = d.yl(paramInt1);
      this.uUT = d.yl(paramInt3);
    }
    for (this.uUU = d.yl(paramInt2);; this.uUU = d.yk(paramInt2))
    {
      this.uUV = new Rect(0, 0, this.uUS.getWidth(), this.uUS.getHeight());
      this.uUW = new Rect(0, 0, this.uUT.getWidth(), this.uUT.getHeight());
      this.uUX = new Rect(0, 0, this.uUU.getWidth(), this.uUU.getHeight());
      this.jVY = new Paint(1);
      GMTrace.o(2897894965248L, 21591);
      return;
      this.uUS = d.yk(paramInt1);
      this.uUT = d.yk(paramInt3);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(2898163400704L, 21593);
    super.onDraw(paramCanvas);
    if (this.jVY == null)
    {
      GMTrace.o(2898163400704L, 21593);
      return;
    }
    if (this.uUY < 128)
    {
      this.jVY.setAlpha(255 - this.uUY * 2);
      paramCanvas.drawBitmap(this.uUT, null, this.uUW, this.jVY);
      this.jVY.setAlpha(this.uUY * 2);
      paramCanvas.drawBitmap(this.uUU, null, this.uUX, this.jVY);
      GMTrace.o(2898163400704L, 21593);
      return;
    }
    this.jVY.setAlpha(255 - this.uUY * 2);
    paramCanvas.drawBitmap(this.uUU, null, this.uUX, this.jVY);
    this.jVY.setAlpha(this.uUY * 2);
    paramCanvas.drawBitmap(this.uUS, null, this.uUV, this.jVY);
    GMTrace.o(2898163400704L, 21593);
  }
  
  public final void zt(int paramInt)
  {
    GMTrace.i(2898029182976L, 21592);
    this.uUY = paramInt;
    invalidate();
    GMTrace.o(2898029182976L, 21592);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/TabIconView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */