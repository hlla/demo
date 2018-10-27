package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout
  extends FrameLayout
{
  public final Rect a = new Rect();
  private bh b;
  private TypedValue c;
  private TypedValue d;
  private TypedValue e;
  private TypedValue f;
  private TypedValue g;
  private TypedValue h;
  
  public ContentFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(Rect paramRect)
  {
    fitSystemWindows(paramRect);
  }
  
  public TypedValue getFixedHeightMajor()
  {
    if (this.c == null) {
      this.c = new TypedValue();
    }
    return this.c;
  }
  
  public TypedValue getFixedHeightMinor()
  {
    if (this.d == null) {
      this.d = new TypedValue();
    }
    return this.d;
  }
  
  public TypedValue getFixedWidthMajor()
  {
    if (this.e == null) {
      this.e = new TypedValue();
    }
    return this.e;
  }
  
  public TypedValue getFixedWidthMinor()
  {
    if (this.f == null) {
      this.f = new TypedValue();
    }
    return this.f;
  }
  
  public TypedValue getMinWidthMajor()
  {
    if (this.g == null) {
      this.g = new TypedValue();
    }
    return this.g;
  }
  
  public TypedValue getMinWidthMinor()
  {
    if (this.h == null) {
      this.h = new TypedValue();
    }
    return this.h;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    bh localbh = this.b;
    if (localbh != null) {
      localbh.a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    bh localbh = this.b;
    if (localbh != null) {
      localbh.b();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int n = localDisplayMetrics.widthPixels;
    int i1 = localDisplayMetrics.heightPixels;
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i;
    int k;
    if (i2 != Integer.MIN_VALUE)
    {
      i = 0;
      k = paramInt1;
      if (j != Integer.MIN_VALUE)
      {
        j = paramInt2;
        super.onMeasure(k, j);
        k = getMeasuredWidth();
        paramInt1 = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
        if (i != 0) {}
        for (paramInt2 = m;; paramInt2 = m)
        {
          if (paramInt2 != 0) {
            super.onMeasure(paramInt1, j);
          }
          return;
          if (i2 == Integer.MIN_VALUE) {
            break;
          }
        }
        if (n >= i1) {}
        for (localTypedValue = this.g;; localTypedValue = this.h)
        {
          if (localTypedValue == null)
          {
            paramInt2 = m;
            break;
          }
          if (localTypedValue.type == 0)
          {
            paramInt2 = m;
            break;
          }
          if (localTypedValue.type == 5) {
            paramInt2 = (int)localTypedValue.getDimension(localDisplayMetrics);
          }
          for (;;)
          {
            i = paramInt2;
            if (paramInt2 > 0) {
              i = paramInt2 - (this.a.left + this.a.right);
            }
            if (k < i)
            {
              paramInt1 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
              paramInt2 = 1;
              break;
            }
            paramInt2 = m;
            break;
            if (localTypedValue.type == 6) {
              paramInt2 = (int)localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
            } else {
              paramInt2 = 0;
            }
          }
        }
      }
      if (n >= i1) {}
      for (localTypedValue = this.d;; localTypedValue = this.c)
      {
        j = paramInt2;
        if (localTypedValue == null) {
          break;
        }
        j = paramInt2;
        if (localTypedValue.type == 0) {
          break;
        }
        if (localTypedValue.type == 5) {
          paramInt1 = (int)localTypedValue.getDimension(localDisplayMetrics);
        }
        for (;;)
        {
          j = paramInt2;
          if (paramInt1 <= 0) {
            break;
          }
          j = View.MeasureSpec.makeMeasureSpec(Math.min(paramInt1 - (this.a.top + this.a.bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          break;
          if (localTypedValue.type == 6) {
            paramInt1 = (int)localTypedValue.getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels);
          } else {
            paramInt1 = 0;
          }
        }
      }
    }
    if (n >= i1) {}
    for (TypedValue localTypedValue = this.e;; localTypedValue = this.f)
    {
      if (localTypedValue == null)
      {
        i = 0;
        k = paramInt1;
        break;
      }
      if (localTypedValue.type == 0)
      {
        i = 0;
        k = paramInt1;
        break;
      }
      if (localTypedValue.type == 5) {
        i = (int)localTypedValue.getDimension(localDisplayMetrics);
      }
      for (;;)
      {
        if (i > 0)
        {
          k = View.MeasureSpec.makeMeasureSpec(Math.min(i - (this.a.left + this.a.right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
          i = 1;
          break;
        }
        i = 0;
        k = paramInt1;
        break;
        if (localTypedValue.type == 6) {
          i = (int)localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels);
        } else {
          i = 0;
        }
      }
    }
  }
  
  public void setAttachListener(bh parambh)
  {
    this.b = parambh;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ContentFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */