package android.support.design.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ac;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

public class q
  extends FrameLayout
{
  private static final View.OnTouchListener c = new r();
  public o a;
  public p b;
  
  public q(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public q(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, t.a);
    if (paramContext.hasValue(t.c)) {
      ac.g(this, paramContext.getDimensionPixelSize(t.c, 0));
    }
    paramContext.recycle();
    setOnTouchListener(c);
    setFocusable(true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ac.x(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    o localo = this.a;
    if (localo != null) {
      localo.a();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    p localp = this.b;
    if (localp != null) {
      localp.a();
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null) {}
    for (View.OnTouchListener localOnTouchListener = c;; localOnTouchListener = null)
    {
      setOnTouchListener(localOnTouchListener);
      super.setOnClickListener(paramOnClickListener);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */