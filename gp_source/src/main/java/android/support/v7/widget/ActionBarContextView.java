package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ac;
import android.support.v7.view.b;
import android.support.v7.view.menu.p;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView
  extends a
{
  public View f;
  public boolean g;
  private int h;
  private View i;
  private CharSequence j;
  private int k;
  private TextView l;
  private CharSequence m;
  private LinearLayout n;
  private int o;
  private TextView p;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968603);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = hf.a(paramContext, paramAttributeSet, android.support.v7.a.a.x, paramInt, 0);
    ac.a(this, paramContext.a(android.support.v7.a.a.y));
    this.o = paramContext.g(android.support.v7.a.a.C, 0);
    this.k = paramContext.g(android.support.v7.a.a.B, 0);
    this.b = paramContext.f(android.support.v7.a.a.A, 0);
    this.h = paramContext.g(android.support.v7.a.a.z, 2131623941);
    paramContext.c.recycle();
  }
  
  private final void c()
  {
    int i2 = 0;
    if (this.n == null)
    {
      LayoutInflater.from(getContext()).inflate(2131623936, this);
      this.n = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.p = ((TextView)this.n.findViewById(2131427374));
      this.l = ((TextView)this.n.findViewById(2131427373));
      if (this.o != 0) {
        this.p.setTextAppearance(getContext(), this.o);
      }
      if (this.k != 0) {
        this.l.setTextAppearance(getContext(), this.k);
      }
    }
    this.p.setText(this.m);
    this.l.setText(this.j);
    boolean bool1 = TextUtils.isEmpty(this.m);
    boolean bool2 = TextUtils.isEmpty(this.j);
    Object localObject = this.l;
    if (!bool2) {}
    for (int i1 = 0;; i1 = 8)
    {
      ((TextView)localObject).setVisibility(i1);
      localObject = this.n;
      if ((bool1 ^ true)) {
        i1 = i2;
      }
      for (;;)
      {
        ((LinearLayout)localObject).setVisibility(i1);
        if (this.n.getParent() == null) {
          addView(this.n);
        }
        return;
        i1 = i2;
        if (!(bool2 ^ true)) {
          i1 = 8;
        }
      }
    }
  }
  
  public final void a(b paramb)
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      this.f = LayoutInflater.from(getContext()).inflate(this.h, this, false);
      addView(this.f);
    }
    for (;;)
    {
      this.f.findViewById(2131427386).setOnClickListener(new d(paramb));
      paramb = (p)paramb.b();
      localObject = this.a;
      if (localObject != null) {
        ((j)localObject).e();
      }
      this.a = new j(getContext());
      this.a.b();
      localObject = new ViewGroup.LayoutParams(-2, -1);
      paramb.a(this.a, this.d);
      this.c = ((ActionMenuView)this.a.a(this));
      ac.a(this.c, null);
      addView(this.c, (ViewGroup.LayoutParams)localObject);
      return;
      if (((View)localObject).getParent() == null) {
        addView(this.f);
      }
    }
  }
  
  public final boolean a()
  {
    j localj = this.a;
    if (localj == null) {
      return false;
    }
    return localj.c();
  }
  
  public final void b()
  {
    removeAllViews();
    this.i = null;
    this.c = null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.j;
  }
  
  public CharSequence getTitle()
  {
    return this.m;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    j localj = this.a;
    if (localj != null)
    {
      localj.d();
      this.a.f();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.m);
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = id.a(this);
    if (paramBoolean) {}
    for (int i1 = paramInt3 - paramInt1 - getPaddingRight();; i1 = getPaddingLeft())
    {
      int i2 = getPaddingTop();
      int i3 = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
      Object localObject = this.f;
      if (localObject != null) {
        if (((View)localObject).getVisibility() != 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.f.getLayoutParams();
          if (!paramBoolean)
          {
            paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
            if (!paramBoolean)
            {
              paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
              label96:
              paramInt2 = a(i1, paramInt2, paramBoolean);
              paramInt2 = a(paramInt2 + a(this.f, paramInt2, i2, i3, paramBoolean), paramInt4, paramBoolean);
            }
          }
        }
      }
      for (;;)
      {
        localObject = this.n;
        paramInt4 = paramInt2;
        if (localObject != null)
        {
          paramInt4 = paramInt2;
          if (this.i == null)
          {
            paramInt4 = paramInt2;
            if (((LinearLayout)localObject).getVisibility() != 8) {
              paramInt4 = paramInt2 + a(this.n, paramInt2, i2, i3, paramBoolean);
            }
          }
        }
        localObject = this.i;
        if (localObject != null) {
          a((View)localObject, paramInt4, i2, i3, paramBoolean);
        }
        if (!paramBoolean) {}
        for (paramInt1 = paramInt3 - paramInt1 - getPaddingRight();; paramInt1 = getPaddingLeft())
        {
          localObject = this.c;
          if (localObject != null) {
            a((View)localObject, paramInt1, i2, i3, paramBoolean ^ true);
          }
          return;
        }
        paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        break label96;
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        break;
        paramInt2 = i1;
        continue;
        paramInt2 = i1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = 0;
    Object localObject;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(" can only be used ");
      ((StringBuilder)localObject).append("with android:layout_width=\"match_parent\" (or fill_parent)");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(" can only be used ");
      ((StringBuilder)localObject).append("with android:layout_height=\"wrap_content\"");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    int i5 = View.MeasureSpec.getSize(paramInt1);
    int i1 = this.b;
    if (i1 <= 0) {
      i1 = View.MeasureSpec.getSize(paramInt2);
    }
    for (;;)
    {
      int i6 = getPaddingTop() + getPaddingBottom();
      paramInt1 = i5 - getPaddingLeft() - getPaddingRight();
      int i3 = i1 - i6;
      int i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
      localObject = this.f;
      paramInt2 = paramInt1;
      if (localObject != null)
      {
        paramInt1 = a((View)localObject, paramInt1, i2);
        localObject = (ViewGroup.MarginLayoutParams)this.f.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      localObject = this.c;
      paramInt1 = paramInt2;
      if (localObject != null)
      {
        paramInt1 = paramInt2;
        if (((ActionMenuView)localObject).getParent() == this) {
          paramInt1 = a(this.c, paramInt2, i2);
        }
      }
      localObject = this.n;
      paramInt2 = paramInt1;
      if (localObject != null)
      {
        paramInt2 = paramInt1;
        if (this.i == null)
        {
          if (!this.g) {
            break label561;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.n.measure(paramInt2, i2);
          i2 = this.n.getMeasuredWidth();
          if (i2 > paramInt1) {
            break label556;
          }
          paramInt2 = paramInt1 - i2;
          localObject = this.n;
          if (i2 > paramInt1) {
            break label550;
          }
          paramInt1 = 0;
          label350:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      for (;;)
      {
        localObject = this.i;
        if (localObject != null)
        {
          localObject = ((View)localObject).getLayoutParams();
          if (((ViewGroup.LayoutParams)localObject).width == -2) {
            break label543;
          }
        }
        label543:
        for (paramInt1 = 1073741824;; paramInt1 = Integer.MIN_VALUE)
        {
          if (((ViewGroup.LayoutParams)localObject).width >= 0) {
            paramInt2 = Math.min(((ViewGroup.LayoutParams)localObject).width, paramInt2);
          }
          for (;;)
          {
            if (((ViewGroup.LayoutParams)localObject).height != -2) {}
            for (i2 = 1073741824;; i2 = Integer.MIN_VALUE)
            {
              if (((ViewGroup.LayoutParams)localObject).height >= 0) {
                i3 = Math.min(((ViewGroup.LayoutParams)localObject).height, i3);
              }
              for (;;)
              {
                this.i.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, paramInt1), View.MeasureSpec.makeMeasureSpec(i3, i2));
                if (this.b <= 0)
                {
                  i2 = getChildCount();
                  paramInt1 = 0;
                  paramInt2 = i4;
                  if (paramInt2 < i2)
                  {
                    i1 = getChildAt(paramInt2).getMeasuredHeight() + i6;
                    if (i1 > paramInt1) {
                      paramInt1 = i1;
                    }
                    for (;;)
                    {
                      paramInt2 += 1;
                      break;
                    }
                  }
                  setMeasuredDimension(i5, paramInt1);
                  return;
                }
                setMeasuredDimension(i5, i1);
                return;
              }
            }
          }
        }
        label550:
        paramInt1 = 8;
        break label350;
        label556:
        paramInt2 = paramInt1;
        break;
        label561:
        paramInt2 = a((View)localObject, paramInt1, i2);
      }
    }
  }
  
  public void setContentHeight(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    Object localObject = this.i;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.i = paramView;
    if (paramView != null)
    {
      localObject = this.n;
      if (localObject != null)
      {
        removeView((View)localObject);
        this.n = null;
      }
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
    c();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
    c();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.g) {
      requestLayout();
    }
    this.g = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ActionBarContextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */