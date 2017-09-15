package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.f;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer
  extends FrameLayout
{
  Drawable Qd;
  private boolean RI;
  View RJ;
  private View RK;
  private View RL;
  Drawable RM;
  Drawable RN;
  boolean RO;
  boolean RP;
  private int RQ;
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = new c(this);
      setBackgroundDrawable((Drawable)localObject);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.aV);
      this.Qd = paramContext.getDrawable(a.k.KY);
      this.RM = paramContext.getDrawable(a.k.La);
      this.RQ = paramContext.getDimensionPixelSize(a.k.Lg, -1);
      if (getId() == a.f.Kt)
      {
        this.RO = true;
        this.RN = paramContext.getDrawable(a.k.KZ);
      }
      paramContext.recycle();
      if (!this.RO) {
        break label143;
      }
      if (this.RN != null) {
        break label138;
      }
      bool = true;
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      localObject = new b(this);
      break;
      label138:
      bool = false;
      continue;
      label143:
      if ((this.Qd == null) && (this.RM == null)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private static boolean aL(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  private static int aM(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  public final void J(boolean paramBoolean)
  {
    this.RI = paramBoolean;
    if (paramBoolean) {}
    for (int i = 393216;; i = 262144)
    {
      setDescendantFocusability(i);
      return;
    }
  }
  
  public final void a(ai paramai)
  {
    if (this.RJ != null) {
      removeView(this.RJ);
    }
    this.RJ = paramai;
    if (paramai != null)
    {
      addView(paramai);
      ViewGroup.LayoutParams localLayoutParams = paramai.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramai.abO = false;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.Qd != null) && (this.Qd.isStateful())) {
      this.Qd.setState(getDrawableState());
    }
    if ((this.RM != null) && (this.RM.isStateful())) {
      this.RM.setState(getDrawableState());
    }
    if ((this.RN != null) && (this.RN.isStateful())) {
      this.RN.setState(getDrawableState());
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.jumpDrawablesToCurrentState();
      if (this.Qd != null) {
        this.Qd.jumpToCurrentState();
      }
      if (this.RM != null) {
        this.RM.jumpToCurrentState();
      }
      if (this.RN != null) {
        this.RN.jumpToCurrentState();
      }
    }
  }
  
  public final void l(Drawable paramDrawable)
  {
    boolean bool = true;
    if (this.Qd != null)
    {
      this.Qd.setCallback(null);
      unscheduleDrawable(this.Qd);
    }
    this.Qd = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.RK != null) {
        this.Qd.setBounds(this.RK.getLeft(), this.RK.getTop(), this.RK.getRight(), this.RK.getBottom());
      }
    }
    if (this.RO) {
      if (this.RN != null) {}
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      if ((this.Qd != null) || (this.RM != null)) {
        bool = false;
      }
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.RK = findViewById(a.f.JL);
    this.RL = findViewById(a.f.JQ);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.RI) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.RJ;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, paramInt2 - localLayoutParams.bottomMargin);
      }
      if (!this.RO) {
        break label143;
      }
      if (this.RN == null) {
        break label323;
      }
      this.RN.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        invalidate();
      }
      return;
      paramBoolean = false;
      break;
      label143:
      if (this.Qd != null) {
        if (this.RK.getVisibility() == 0) {
          this.Qd.setBounds(this.RK.getLeft(), this.RK.getTop(), this.RK.getRight(), this.RK.getBottom());
        }
      }
      label195:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        this.RP = paramBoolean;
        if ((paramBoolean) && (this.RM != null))
        {
          this.RM.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = i;
          break;
          if ((this.RL != null) && (this.RL.getVisibility() == 0))
          {
            this.Qd.setBounds(this.RL.getLeft(), this.RL.getTop(), this.RL.getRight(), this.RL.getBottom());
            break label195;
          }
          this.Qd.setBounds(0, 0, 0, 0);
          break label195;
        }
        break;
      }
      label323:
      paramInt1 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.RK == null)
    {
      i = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE)
      {
        i = paramInt2;
        if (this.RQ >= 0) {
          i = View.MeasureSpec.makeMeasureSpec(Math.min(this.RQ, View.MeasureSpec.getSize(paramInt2)), Integer.MIN_VALUE);
        }
      }
    }
    super.onMeasure(paramInt1, i);
    if (this.RK == null) {}
    do
    {
      return;
      paramInt2 = View.MeasureSpec.getMode(i);
    } while ((this.RJ == null) || (this.RJ.getVisibility() == 8) || (paramInt2 == 1073741824));
    if (!aL(this.RK))
    {
      paramInt1 = aM(this.RK);
      if (paramInt2 != Integer.MIN_VALUE) {
        break label168;
      }
    }
    label168:
    for (paramInt2 = View.MeasureSpec.getSize(i);; paramInt2 = Integer.MAX_VALUE)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + aM(this.RJ), paramInt2));
      return;
      if (!aL(this.RL))
      {
        paramInt1 = aM(this.RL);
        break;
      }
      paramInt1 = 0;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.Qd != null) {
        this.Qd.setVisible(bool, false);
      }
      if (this.RM != null) {
        this.RM.setVisible(bool, false);
      }
      if (this.RN != null) {
        this.RN.setVisible(bool, false);
      }
      return;
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable == this.Qd) && (!this.RO)) || ((paramDrawable == this.RM) && (this.RP)) || ((paramDrawable == this.RN) && (this.RO)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/ActionBarContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */