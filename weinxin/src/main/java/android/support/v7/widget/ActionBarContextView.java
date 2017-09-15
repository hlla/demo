package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.support.v7.view.b;
import android.support.v7.view.menu.f;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView
  extends a
{
  private TextView Fy;
  private View RR;
  private LinearLayout RS;
  private TextView RT;
  private int RU;
  private int RV;
  public boolean RW;
  private int RX;
  private View kD;
  public CharSequence uI;
  public CharSequence uJ;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ap.a(paramContext, paramAttributeSet, a.k.aZ, paramInt);
    setBackgroundDrawable(paramContext.getDrawable(a.k.Lr));
    this.RU = paramContext.getResourceId(a.k.Lv, 0);
    this.RV = paramContext.getResourceId(a.k.Lu, 0);
    this.RA = paramContext.getLayoutDimension(a.k.Lt, 0);
    this.RX = paramContext.getResourceId(a.k.Ls, a.h.KC);
    paramContext.aeG.recycle();
  }
  
  private void dM()
  {
    int m = 8;
    int j = 1;
    if (this.RS == null)
    {
      LayoutInflater.from(getContext()).inflate(a.h.Kz, this);
      this.RS = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.Fy = ((TextView)this.RS.findViewById(a.f.JP));
      this.RT = ((TextView)this.RS.findViewById(a.f.JO));
      if (this.RU != 0) {
        this.Fy.setTextAppearance(getContext(), this.RU);
      }
      if (this.RV != 0) {
        this.RT.setTextAppearance(getContext(), this.RV);
      }
    }
    this.Fy.setText(this.uI);
    this.RT.setText(this.uJ);
    int i;
    label167:
    Object localObject;
    if (!TextUtils.isEmpty(this.uI))
    {
      i = 1;
      if (TextUtils.isEmpty(this.uJ)) {
        break label234;
      }
      localObject = this.RT;
      if (j == 0) {
        break label239;
      }
    }
    label234:
    label239:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = this.RS;
      if (i == 0)
      {
        i = m;
        if (j == 0) {}
      }
      else
      {
        i = 0;
      }
      ((LinearLayout)localObject).setVisibility(i);
      if (this.RS.getParent() == null) {
        addView(this.RS);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label167;
    }
  }
  
  public final void K(boolean paramBoolean)
  {
    if (paramBoolean != this.RW) {
      requestLayout();
    }
    this.RW = paramBoolean;
  }
  
  public final void ay(int paramInt)
  {
    this.RA = paramInt;
  }
  
  public final void c(final b paramb)
  {
    if (this.RR == null)
    {
      this.RR = LayoutInflater.from(getContext()).inflate(this.RX, this, false);
      addView(this.RR);
    }
    for (;;)
    {
      this.RR.findViewById(a.f.JT).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramb.finish();
        }
      });
      paramb = (f)paramb.getMenu();
      if (this.Rz != null) {
        this.Rz.dY();
      }
      this.Rz = new ActionMenuPresenter(getContext());
      this.Rz.dX();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      paramb.a(this.Rz, this.Rx);
      this.Ry = ((ActionMenuView)this.Rz.c(this));
      this.Ry.setBackgroundDrawable(null);
      addView(this.Ry, localLayoutParams);
      return;
      if (this.RR.getParent() == null) {
        addView(this.RR);
      }
    }
  }
  
  public final void dN()
  {
    if (this.RR == null) {
      dO();
    }
  }
  
  public final void dO()
  {
    removeAllViews();
    this.kD = null;
    this.Ry = null;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.Rz != null)
    {
      this.Rz.hideOverflowMenu();
      this.Rz.dZ();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent.setSource(this);
        paramAccessibilityEvent.setClassName(getClass().getName());
        paramAccessibilityEvent.setPackageName(getContext().getPackageName());
        paramAccessibilityEvent.setContentDescription(this.uI);
      }
    }
    else {
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = at.bw(this);
    int i;
    int j;
    int k;
    Object localObject;
    if (paramBoolean)
    {
      i = paramInt3 - paramInt1 - getPaddingRight();
      j = getPaddingTop();
      k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
      paramInt2 = i;
      if (this.RR != null)
      {
        paramInt2 = i;
        if (this.RR.getVisibility() != 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)this.RR.getLayoutParams();
          if (!paramBoolean) {
            break label254;
          }
          paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
          label89:
          if (!paramBoolean) {
            break label263;
          }
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
          label100:
          paramInt2 = c(i, paramInt2, paramBoolean);
          paramInt2 = c(paramInt2 + a(this.RR, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
        }
      }
      paramInt4 = paramInt2;
      if (this.RS != null)
      {
        paramInt4 = paramInt2;
        if (this.kD == null)
        {
          paramInt4 = paramInt2;
          if (this.RS.getVisibility() != 8) {
            paramInt4 = paramInt2 + a(this.RS, paramInt2, j, k, paramBoolean);
          }
        }
      }
      if (this.kD != null) {
        a(this.kD, paramInt4, j, k, paramBoolean);
      }
      if (!paramBoolean) {
        break label273;
      }
      paramInt1 = getPaddingLeft();
      label213:
      if (this.Ry != null)
      {
        localObject = this.Ry;
        if (paramBoolean) {
          break label286;
        }
      }
    }
    label254:
    label263:
    label273:
    label286:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a((View)localObject, paramInt1, j, k, paramBoolean);
      return;
      i = getPaddingLeft();
      break;
      paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      break label89;
      paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
      break label100;
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
      break label213;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 1073741824;
    int m = 0;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
    }
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i;
    int n;
    int j;
    if (this.RA > 0)
    {
      i = this.RA;
      int i2 = getPaddingTop() + getPaddingBottom();
      paramInt1 = i1 - getPaddingLeft() - getPaddingRight();
      n = i - i2;
      j = View.MeasureSpec.makeMeasureSpec(n, Integer.MIN_VALUE);
      paramInt2 = paramInt1;
      Object localObject;
      if (this.RR != null)
      {
        paramInt1 = g(this.RR, paramInt1, j);
        localObject = (ViewGroup.MarginLayoutParams)this.RR.getLayoutParams();
        paramInt2 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt2);
      }
      paramInt1 = paramInt2;
      if (this.Ry != null)
      {
        paramInt1 = paramInt2;
        if (this.Ry.getParent() == this) {
          paramInt1 = g(this.Ry, paramInt2, j);
        }
      }
      paramInt2 = paramInt1;
      if (this.RS != null)
      {
        paramInt2 = paramInt1;
        if (this.kD == null)
        {
          if (!this.RW) {
            break label496;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.RS.measure(paramInt2, j);
          int i3 = this.RS.getMeasuredWidth();
          if (i3 > paramInt1) {
            break label484;
          }
          j = 1;
          label291:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i3;
          }
          localObject = this.RS;
          if (j == 0) {
            break label490;
          }
          paramInt1 = 0;
          label316:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label322:
      if (this.kD != null)
      {
        localObject = this.kD.getLayoutParams();
        if (((ViewGroup.LayoutParams)localObject).width == -2) {
          break label510;
        }
        paramInt1 = 1073741824;
        label352:
        j = paramInt2;
        if (((ViewGroup.LayoutParams)localObject).width >= 0) {
          j = Math.min(((ViewGroup.LayoutParams)localObject).width, paramInt2);
        }
        if (((ViewGroup.LayoutParams)localObject).height == -2) {
          break label517;
        }
        paramInt2 = k;
        label387:
        if (((ViewGroup.LayoutParams)localObject).height < 0) {
          break label524;
        }
        k = Math.min(((ViewGroup.LayoutParams)localObject).height, n);
        label407:
        this.kD.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
      }
      if (this.RA > 0) {
        break label539;
      }
      j = getChildCount();
      paramInt1 = 0;
      paramInt2 = m;
      label444:
      if (paramInt2 >= j) {
        break label531;
      }
      i = getChildAt(paramInt2).getMeasuredHeight() + i2;
      if (i <= paramInt1) {
        break label547;
      }
      paramInt1 = i;
    }
    label484:
    label490:
    label496:
    label510:
    label517:
    label524:
    label531:
    label539:
    label547:
    for (;;)
    {
      paramInt2 += 1;
      break label444;
      i = View.MeasureSpec.getSize(paramInt2);
      break;
      j = 0;
      break label291;
      paramInt1 = 8;
      break label316;
      paramInt2 = g(this.RS, paramInt1, j);
      break label322;
      paramInt1 = Integer.MIN_VALUE;
      break label352;
      paramInt2 = Integer.MIN_VALUE;
      break label387;
      k = n;
      break label407;
      setMeasuredDimension(i1, paramInt1);
      return;
      setMeasuredDimension(i1, i);
      return;
    }
  }
  
  public final void setCustomView(View paramView)
  {
    if (this.kD != null) {
      removeView(this.kD);
    }
    this.kD = paramView;
    if ((paramView != null) && (this.RS != null))
    {
      removeView(this.RS);
      this.RS = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public final void setSubtitle(CharSequence paramCharSequence)
  {
    this.uJ = paramCharSequence;
    dM();
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.uI = paramCharSequence;
    dM();
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    if (this.Rz != null) {
      return this.Rz.showOverflowMenu();
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/ActionBarContextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */