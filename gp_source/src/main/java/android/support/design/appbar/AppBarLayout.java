package android.support.design.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.design.internal.n;
import android.support.design.widget.i;
import android.support.v4.view.ac;
import android.support.v4.view.bf;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

@i(a=AppBarLayout.Behavior.class)
public class AppBarLayout
  extends LinearLayout
{
  public boolean a;
  public bf b;
  public boolean c;
  public int d = 0;
  private int e = -1;
  private int f = -1;
  private boolean g;
  private boolean h;
  private int[] i;
  private int j = -1;
  
  public AppBarLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      k.a(this);
      k.a(this, paramAttributeSet);
    }
    paramContext = n.a(paramContext, paramAttributeSet, h.a, 0, 2132018424, new int[0]);
    ac.a(this, paramContext.getDrawable(h.e));
    if (paramContext.hasValue(h.i)) {
      a(paramContext.getBoolean(h.i, false), false, false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.hasValue(h.h))) {
      k.a(this, paramContext.getDimensionPixelSize(h.h, 0));
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramContext.hasValue(h.f)) {
        setKeyboardNavigationCluster(paramContext.getBoolean(h.f, false));
      }
      if (paramContext.hasValue(h.g)) {
        setTouchscreenBlocksFocus(paramContext.getBoolean(h.g, false));
      }
    }
    this.c = paramContext.getBoolean(h.j, false);
    paramContext.recycle();
    ac.a(this, new a(this));
  }
  
  public d a(AttributeSet paramAttributeSet)
  {
    return new d(getContext(), paramAttributeSet);
  }
  
  public d a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams))) {
      return new d((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new d((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new d(paramLayoutParams);
  }
  
  final void a()
  {
    this.j = -1;
    this.e = -1;
    this.f = -1;
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int n = 0;
    if (!paramBoolean1) {}
    for (int k = 2;; k = 1)
    {
      if (!paramBoolean2) {}
      for (int m = 0;; m = 4)
      {
        if (!paramBoolean3) {}
        for (;;)
        {
          this.d = (n | m | k);
          requestLayout();
          return;
          n = 8;
        }
      }
    }
  }
  
  final boolean a(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }
  
  public d b()
  {
    return new d();
  }
  
  final int c()
  {
    int m = this.e;
    int k = m;
    View localView;
    int n;
    int i1;
    if (m == -1)
    {
      m = getChildCount() - 1;
      k = 0;
      if (m >= 0)
      {
        localView = getChildAt(m);
        d locald = (d)localView.getLayoutParams();
        n = localView.getMeasuredHeight();
        i1 = locald.a;
        if ((i1 & 0x5) == 5)
        {
          int i2 = locald.topMargin;
          k = locald.bottomMargin + i2 + k;
          if ((i1 & 0x8) != 0) {
            k += ac.s(localView);
          }
        }
      }
    }
    for (;;)
    {
      m -= 1;
      break;
      if ((i1 & 0x2) == 0)
      {
        k += n - e();
      }
      else
      {
        k += n - ac.s(localView);
        continue;
        if (k > 0)
        {
          k = Math.max(0, k);
          this.e = k;
          return k;
        }
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof d;
  }
  
  final int d()
  {
    int m = this.f;
    int k = m;
    if (m == -1)
    {
      int n = getChildCount();
      m = 0;
      k = 0;
      if (m >= n) {
        break label132;
      }
      View localView = getChildAt(m);
      d locald = (d)localView.getLayoutParams();
      int i2 = localView.getMeasuredHeight();
      int i3 = locald.topMargin;
      int i4 = locald.bottomMargin;
      int i1 = locald.a;
      if ((i1 & 0x1) == 0) {
        break label129;
      }
      k += i2 + (i3 + i4);
      if ((i1 & 0x2) == 0) {
        break label122;
      }
      k -= ac.s(localView) + e();
    }
    label122:
    label129:
    label132:
    for (;;)
    {
      k = Math.max(0, k);
      this.f = k;
      return k;
      m += 1;
      break;
    }
  }
  
  final int e()
  {
    bf localbf = this.b;
    if (localbf != null) {
      return localbf.b();
    }
    return 0;
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    int m = e();
    int k = ac.s(this);
    if (k == 0)
    {
      k = getChildCount();
      if (k > 0) {}
      for (k = ac.s(getChildAt(k - 1));; k = 0)
      {
        if (k == 0) {
          return getHeight() / 3;
        }
        return k + k + m;
      }
    }
    return k + k + m;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  public final int getTotalScrollRange()
  {
    int m = this.j;
    int k = m;
    if (m == -1)
    {
      int n = getChildCount();
      m = 0;
      k = 0;
      for (;;)
      {
        if (m < n)
        {
          View localView = getChildAt(m);
          d locald = (d)localView.getLayoutParams();
          int i2 = localView.getMeasuredHeight();
          int i1 = locald.a;
          if ((i1 & 0x1) != 0)
          {
            int i3 = locald.topMargin;
            k += locald.bottomMargin + (i2 + i3);
            if ((i1 & 0x2) == 0)
            {
              m += 1;
              continue;
            }
            k -= ac.s(localView);
          }
        }
      }
    }
    for (;;)
    {
      k = Math.max(0, k - e());
      this.j = k;
      return k;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.i == null) {
      this.i = new int[4];
    }
    int[] arrayOfInt1 = this.i;
    int[] arrayOfInt2 = super.onCreateDrawableState(arrayOfInt1.length + paramInt);
    boolean bool = this.g;
    if (!bool) {}
    for (paramInt = -2130969530;; paramInt = 2130969530)
    {
      arrayOfInt1[0] = paramInt;
      if (bool) {
        if (this.h) {
          paramInt = 2130969531;
        }
      }
      for (;;)
      {
        arrayOfInt1[1] = paramInt;
        if (!bool) {}
        for (paramInt = -2130969529;; paramInt = 2130969529)
        {
          arrayOfInt1[2] = paramInt;
          if (bool) {
            if (this.h) {
              paramInt = 2130969528;
            }
          }
          for (;;)
          {
            arrayOfInt1[3] = paramInt;
            return mergeDrawableStates(arrayOfInt2, arrayOfInt1);
            paramInt = -2130969528;
            continue;
            paramInt = -2130969528;
          }
        }
        paramInt = -2130969531;
        continue;
        paramInt = -2130969531;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a();
    this.a = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2) {
      if (((d)getChildAt(paramInt1).getLayoutParams()).b == null) {
        paramInt1 += 1;
      } else {
        this.a = true;
      }
    }
    if (!this.c)
    {
      paramInt2 = getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        paramInt3 = ((d)getChildAt(paramInt1).getLayoutParams()).a;
        if ((paramInt3 & 0x1) != 1) {}
        while ((paramInt3 & 0xA) == 0)
        {
          paramInt1 += 1;
          break;
        }
        paramBoolean = true;
      }
    }
    for (;;)
    {
      if (this.g != paramBoolean)
      {
        this.g = paramBoolean;
        refreshDrawableState();
      }
      return;
      paramBoolean = false;
      continue;
      paramBoolean = true;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    a();
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    a(paramBoolean, ac.I(this), true);
  }
  
  public void setLiftOnScroll(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt != 1) {
      throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }
    super.setOrientation(paramInt);
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      k.a(this, paramFloat);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/appbar/AppBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */