package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.ap;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  private Drawable eo;
  private Rect ep;
  private Rect eq = new Rect();
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.cD, paramInt, a.h.aS);
    this.eo = paramContext.getDrawable(a.i.cE);
    paramContext.recycle();
    setWillNotDraw(true);
    z.b(this, new t()
    {
      public final ap a(View paramAnonymousView, ap paramAnonymousap)
      {
        if (ScrimInsetsFrameLayout.a(ScrimInsetsFrameLayout.this) == null) {
          ScrimInsetsFrameLayout.a(ScrimInsetsFrameLayout.this, new Rect());
        }
        ScrimInsetsFrameLayout.a(ScrimInsetsFrameLayout.this).set(paramAnonymousap.getSystemWindowInsetLeft(), paramAnonymousap.getSystemWindowInsetTop(), paramAnonymousap.getSystemWindowInsetRight(), paramAnonymousap.getSystemWindowInsetBottom());
        ScrimInsetsFrameLayout.this.a(ScrimInsetsFrameLayout.a(ScrimInsetsFrameLayout.this));
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        if ((ScrimInsetsFrameLayout.a(ScrimInsetsFrameLayout.this).isEmpty()) || (ScrimInsetsFrameLayout.b(ScrimInsetsFrameLayout.this) == null)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setWillNotDraw(bool);
          z.F(ScrimInsetsFrameLayout.this);
          return paramAnonymousap.ca();
        }
      }
    });
  }
  
  public void a(Rect paramRect) {}
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.ep != null) && (this.eo != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.eq.set(0, 0, i, this.ep.top);
      this.eo.setBounds(this.eq);
      this.eo.draw(paramCanvas);
      this.eq.set(0, j - this.ep.bottom, i, j);
      this.eo.setBounds(this.eq);
      this.eo.draw(paramCanvas);
      this.eq.set(0, this.ep.top, this.ep.left, j - this.ep.bottom);
      this.eo.setBounds(this.eq);
      this.eo.draw(paramCanvas);
      this.eq.set(i - this.ep.right, this.ep.top, i, j - this.ep.bottom);
      this.eo.setBounds(this.eq);
      this.eo.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.eo != null) {
      this.eo.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.eo != null) {
      this.eo.setCallback(null);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/internal/ScrimInsetsFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */