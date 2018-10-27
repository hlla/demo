package android.support.design.g;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.ac;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

final class h
  extends LinearLayout
{
  public ValueAnimator a;
  public int b = -1;
  public float c;
  private final GradientDrawable d;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h;
  private final Paint i;
  
  h(c paramc, Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    this.i = new Paint();
    this.d = new GradientDrawable();
  }
  
  private final void a(m paramm, RectF paramRectF)
  {
    int i1 = 0;
    TextView localTextView = paramm.f;
    ImageView localImageView = paramm.e;
    View localView1 = paramm.d;
    int n = 0;
    int k = 0;
    int m = 0;
    if (n >= 3)
    {
      m = i1 - k;
      k = m;
      if (m < this.j.b(24)) {
        k = this.j.b(24);
      }
      m = (paramm.getLeft() + paramm.getRight()) / 2;
      k /= 2;
      paramRectF.set(m - k, 0.0F, k + m, 0.0F);
      return;
    }
    View localView2 = new View[] { localTextView, localImageView, localView1 }[n];
    int i4;
    int i3;
    int i2;
    if (localView2 == null)
    {
      i4 = m;
      i3 = k;
      i2 = i1;
    }
    do
    {
      n += 1;
      i1 = i2;
      k = i3;
      m = i4;
      break;
      i2 = i1;
      i3 = k;
      i4 = m;
    } while (localView2.getVisibility() != 0);
    if (m != 0) {}
    for (k = Math.min(k, localView2.getLeft());; k = localView2.getLeft())
    {
      if (m != 0) {}
      for (m = Math.max(i1, localView2.getRight());; m = localView2.getRight())
      {
        i4 = 1;
        i2 = m;
        i3 = k;
        break;
      }
    }
  }
  
  final void a()
  {
    int m = -1;
    View localView = getChildAt(this.b);
    int k;
    if (localView == null) {
      k = -1;
    }
    for (;;)
    {
      a(m, k);
      return;
      if (localView.getWidth() > 0)
      {
        m = localView.getLeft();
        k = localView.getRight();
        c localc = this.j;
        if (localc.e) {}
        for (;;)
        {
          if (this.c > 0.0F)
          {
            if (this.b < getChildCount() - 1)
            {
              localView = getChildAt(this.b + 1);
              int n = localView.getLeft();
              int i1 = localView.getRight();
              localc = this.j;
              int i2;
              if (localc.e)
              {
                i2 = i1;
                i1 = n;
                n = i2;
              }
              for (;;)
              {
                float f1 = this.c;
                float f2 = 1.0F - f1;
                float f3 = i1;
                m = (int)(m * f2 + f3 * f1);
                k = (int)(n * f1 + k * f2);
                break;
                if ((localView instanceof m))
                {
                  a((m)localView, localc.r);
                  i1 = (int)this.j.r.left;
                  n = (int)this.j.r.right;
                }
                else
                {
                  i2 = n;
                  n = i1;
                  i1 = i2;
                }
              }
            }
            break;
          }
          break;
          if ((localView instanceof m))
          {
            a((m)localView, localc.r);
            m = (int)this.j.r.left;
            k = (int)this.j.r.right;
          }
        }
      }
      k = -1;
    }
  }
  
  final void a(int paramInt)
  {
    if (this.i.getColor() != paramInt)
    {
      this.i.setColor(paramInt);
      ac.e(this);
    }
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.e) || (paramInt2 != this.f))
    {
      this.e = paramInt1;
      this.f = paramInt2;
      ac.e(this);
    }
  }
  
  final void b(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      ac.e(this);
    }
  }
  
  final void b(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning())) {
      this.a.cancel();
    }
    localObject = getChildAt(paramInt1);
    if (localObject == null)
    {
      a();
      return;
    }
    int k = ((View)localObject).getLeft();
    int m = ((View)localObject).getRight();
    c localc = this.j;
    if (localc.e) {}
    for (;;)
    {
      int n = this.e;
      int i1 = this.f;
      if (n != k) {}
      for (;;)
      {
        localObject = new ValueAnimator();
        this.a = ((ValueAnimator)localObject);
        ((ValueAnimator)localObject).setInterpolator(android.support.design.a.a.c);
        ((ValueAnimator)localObject).setDuration(paramInt2);
        ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener(new i(this, n, k, i1, m));
        ((ValueAnimator)localObject).addListener(new j(this, paramInt1));
        ((ValueAnimator)localObject).start();
        return;
        if (i1 == m) {
          break;
        }
      }
      if ((localObject instanceof m))
      {
        a((m)localObject, localc.r);
        k = (int)this.j.r.left;
        m = (int)this.j.r.right;
      }
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int m = 0;
    Object localObject = this.j.m;
    if (localObject != null) {}
    for (int k = ((Drawable)localObject).getIntrinsicHeight();; k = 0)
    {
      int n = this.h;
      if (n >= 0) {
        k = n;
      }
      switch (this.j.f)
      {
      default: 
        k = 0;
      }
      for (;;)
      {
        n = this.e;
        if ((n >= 0) && (this.f > n))
        {
          Drawable localDrawable = this.j.m;
          localObject = localDrawable;
          if (localDrawable == null) {
            localObject = this.d;
          }
          localObject = android.support.v4.a.a.a.f((Drawable)localObject);
          ((Drawable)localObject).setBounds(this.e, k, this.f, m);
          if (this.i != null)
          {
            if (Build.VERSION.SDK_INT != 21) {
              break label182;
            }
            ((Drawable)localObject).setColorFilter(this.i.getColor(), PorterDuff.Mode.SRC_IN);
          }
        }
        for (;;)
        {
          ((Drawable)localObject).draw(paramCanvas);
          super.draw(paramCanvas);
          return;
          label182:
          android.support.v4.a.a.a.a((Drawable)localObject, this.i.getColor());
        }
        k = getHeight() - k;
        m = getHeight();
        continue;
        m = getHeight();
        k = 0;
        continue;
        n = 0;
        m = k;
        k = n;
        continue;
        n = (getHeight() - k) / 2;
        m = (k + getHeight()) / 2;
        k = n;
      }
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ValueAnimator localValueAnimator = this.a;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.a.cancel();
      long l = this.a.getDuration();
      paramInt1 = this.b;
      float f1 = this.a.getAnimatedFraction();
      b(paramInt1, Math.round((float)l * (1.0F - f1)));
      return;
    }
    a();
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    super.onMeasure(paramInt1, paramInt2);
    Object localObject;
    int i2;
    int m;
    int k;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      localObject = this.j;
      if ((((c)localObject).b == 1) && (((c)localObject).d == 1))
      {
        i2 = getChildCount();
        m = 0;
        k = 0;
        if (m < i2)
        {
          localObject = getChildAt(m);
          if (((View)localObject).getVisibility() == 0) {
            k = Math.max(k, ((View)localObject).getMeasuredWidth());
          }
          for (;;)
          {
            m += 1;
            break;
          }
        }
        if (k > 0)
        {
          m = this.j.b(16);
          if (k * i2 <= getMeasuredWidth() - (m + m)) {
            break label156;
          }
          localObject = this.j;
          ((c)localObject).d = 0;
          ((c)localObject).a(false);
        }
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      label156:
      do
      {
        return;
        int n = 0;
        m = i1;
        if (n < i2)
        {
          localObject = (LinearLayout.LayoutParams)getChildAt(n).getLayoutParams();
          if ((((LinearLayout.LayoutParams)localObject).width != k) || (((LinearLayout.LayoutParams)localObject).weight != 0.0F))
          {
            ((LinearLayout.LayoutParams)localObject).width = k;
            ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
            m = 1;
          }
          for (;;)
          {
            n += 1;
            break;
          }
        }
      } while (m == 0);
    }
  }
  
  public final void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if ((Build.VERSION.SDK_INT < 23) && (this.g != paramInt))
    {
      requestLayout();
      this.g = paramInt;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/g/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */