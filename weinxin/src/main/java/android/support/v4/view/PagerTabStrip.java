package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private final Rect eq = new Rect();
  private int iE;
  private int xA;
  private boolean xB;
  private float xC;
  private float xD;
  private int xq = this.xT;
  private int xr;
  private int xs;
  private int xt;
  private int xu;
  private int xv;
  private final Paint xw = new Paint();
  private int xx = 255;
  private boolean xy = false;
  private boolean xz = false;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.xw.setColor(this.xq);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.xr = ((int)(3.0F * f + 0.5F));
    this.xs = ((int)(6.0F * f + 0.5F));
    this.xt = ((int)(64.0F * f));
    this.xv = ((int)(16.0F * f + 0.5F));
    this.xA = ((int)(1.0F * f + 0.5F));
    this.xu = ((int)(f * 32.0F + 0.5F));
    this.iE = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    U(this.xL);
    setWillNotDraw(false);
    this.xG.setFocusable(true);
    this.xG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.xF.Y(PagerTabStrip.this.xF.ys - 1);
      }
    });
    this.xI.setFocusable(true);
    this.xI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.xF.Y(PagerTabStrip.this.xF.ys + 1);
      }
    });
    if (getBackground() == null) {
      this.xy = true;
    }
  }
  
  public final void U(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.xt) {
      i = this.xt;
    }
    super.U(i);
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.eq;
    int i = getHeight();
    int j = this.xH.getLeft();
    int k = this.xv;
    int m = this.xH.getRight();
    int n = this.xv;
    int i1 = i - this.xr;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.xx = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.xH.getLeft() - this.xv, i1, this.xH.getRight() + this.xv, i);
    invalidate(localRect);
  }
  
  final int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.xu);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.xH.getLeft();
    int k = this.xv;
    int m = this.xH.getRight();
    int n = this.xv;
    int i1 = this.xr;
    this.xw.setColor(this.xx << 24 | this.xq & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.xw);
    if (this.xy)
    {
      this.xw.setColor(0xFF000000 | this.xq & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.xA, getWidth() - getPaddingRight(), i, this.xw);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.xB)) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      this.xC = f1;
      this.xD = f2;
      this.xB = false;
      continue;
      if ((Math.abs(f1 - this.xC) > this.iE) || (Math.abs(f2 - this.xD) > this.iE))
      {
        this.xB = true;
        continue;
        if (f1 < this.xH.getLeft() - this.xv) {
          this.xF.Y(this.xF.ys - 1);
        } else if (f1 > this.xH.getRight() + this.xv) {
          this.xF.Y(this.xF.ys + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.xz) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.xy = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.xz) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.xy = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.xz) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.xy = bool;
      return;
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.xs) {
      i = this.xs;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/PagerTabStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */