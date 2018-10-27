package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ac;
import android.support.v7.a.a;
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
  public Drawable a;
  public boolean b;
  public boolean c;
  public Drawable d;
  public Drawable e;
  private View f;
  private View g;
  private int h;
  private boolean i;
  private View j;
  
  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ac.a(this, new c(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a);
    this.a = paramContext.getDrawable(a.d);
    this.e = paramContext.getDrawable(a.f);
    this.h = paramContext.getDimensionPixelSize(a.l, -1);
    if (getId() == 2131429301)
    {
      this.b = true;
      this.d = paramContext.getDrawable(a.e);
    }
    paramContext.recycle();
    if (!this.b) {
      if (this.a == null) {
        if (this.e != null) {}
      }
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      bool = false;
      continue;
      bool = false;
      continue;
      if (this.d != null) {
        bool = false;
      }
    }
  }
  
  private static boolean a(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  private static int b(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int k = paramView.getMeasuredHeight();
    int m = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (k + m);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.a;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.a.setState(getDrawableState());
    }
    localDrawable = this.e;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.e.setState(getDrawableState());
    }
    localDrawable = this.d;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.d.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.j;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.d;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.f = findViewById(2131427367);
    this.g = findViewById(2131427377);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.i) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = this.j;
    if (localObject1 != null) {
      if (((View)localObject1).getVisibility() != 8) {
        paramBoolean = true;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {}
      for (;;)
      {
        if (this.b)
        {
          localObject1 = this.d;
          if (localObject1 != null)
          {
            ((Drawable)localObject1).setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            invalidate();
          }
          label76:
          return;
        }
        if (this.a != null) {
          if (this.f.getVisibility() == 0)
          {
            this.a.setBounds(this.f.getLeft(), this.f.getTop(), this.f.getRight(), this.f.getBottom());
            paramInt1 = 1;
          }
        }
        Object localObject2;
        for (;;)
        {
          this.c = paramBoolean;
          if (paramBoolean)
          {
            localObject2 = this.e;
            if (localObject2 != null)
            {
              ((Drawable)localObject2).setBounds(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom());
              break;
            }
          }
          if (paramInt1 == 0) {
            break label76;
          }
          break;
          localObject2 = this.g;
          if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0))
          {
            this.a.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            paramInt1 = 1;
          }
          else
          {
            this.a.setBounds(0, 0, 0, 0);
            paramInt1 = 1;
            continue;
            paramInt1 = 0;
          }
        }
        if (((View)localObject1).getVisibility() != 8)
        {
          paramInt2 = getMeasuredHeight();
          localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((View)localObject1).layout(paramInt1, paramInt2 - ((View)localObject1).getMeasuredHeight() - ((FrameLayout.LayoutParams)localObject2).bottomMargin, paramInt3, paramInt2 - ((FrameLayout.LayoutParams)localObject2).bottomMargin);
        }
      }
      paramBoolean = false;
      continue;
      paramBoolean = false;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k = paramInt2;
    if (this.f == null)
    {
      k = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE)
      {
        int m = this.h;
        k = paramInt2;
        if (m >= 0) {
          k = View.MeasureSpec.makeMeasureSpec(Math.min(m, View.MeasureSpec.getSize(paramInt2)), Integer.MIN_VALUE);
        }
      }
    }
    super.onMeasure(paramInt1, k);
    if (this.f != null)
    {
      paramInt2 = View.MeasureSpec.getMode(k);
      View localView = this.j;
      if ((localView != null) && (localView.getVisibility() != 8) && (paramInt2 != 1073741824))
      {
        if (a(this.f)) {
          break label150;
        }
        paramInt1 = b(this.f);
      }
    }
    for (;;)
    {
      if (paramInt2 == Integer.MIN_VALUE) {}
      for (paramInt2 = View.MeasureSpec.getSize(k);; paramInt2 = Integer.MAX_VALUE)
      {
        setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + b(this.j), paramInt2));
        return;
      }
      label150:
      if (!a(this.g)) {
        paramInt1 = b(this.g);
      } else {
        paramInt1 = 0;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(this.a);
    }
    this.a = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      paramDrawable = this.f;
      if (paramDrawable != null) {
        this.a.setBounds(paramDrawable.getLeft(), this.f.getTop(), this.f.getRight(), this.f.getBottom());
      }
    }
    if (!this.b) {
      if (this.a == null) {
        if (this.e != null) {}
      }
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      bool = false;
      continue;
      if (this.d != null) {
        bool = false;
      }
    }
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    Drawable localDrawable = this.d;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(this.d);
    }
    this.d = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.b)
      {
        paramDrawable = this.d;
        if (paramDrawable != null) {
          paramDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
      }
    }
    if (!this.b) {
      if (this.a == null) {
        if (this.e != null) {}
      }
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      bool = false;
      continue;
      if (this.d != null) {
        bool = false;
      }
    }
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    boolean bool = true;
    Drawable localDrawable = this.e;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      unscheduleDrawable(this.e);
    }
    this.e = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.c)
      {
        paramDrawable = this.e;
        if (paramDrawable != null) {
          paramDrawable.setBounds(this.j.getLeft(), this.j.getTop(), this.j.getRight(), this.j.getBottom());
        }
      }
    }
    if (!this.b) {
      if (this.a == null) {
        if (this.e != null) {}
      }
    }
    for (;;)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
      bool = false;
      continue;
      bool = false;
      continue;
      if (this.d != null) {
        bool = false;
      }
    }
  }
  
  public void setTabContainer(ge paramge)
  {
    Object localObject = this.j;
    if (localObject != null) {
      removeView((View)localObject);
    }
    this.j = paramge;
    if (paramge != null)
    {
      addView(paramge);
      localObject = paramge.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = -1;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      paramge.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (!paramBoolean) {}
    for (int k = 262144;; k = 393216)
    {
      setDescendantFocusability(k);
      return;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Drawable localDrawable = this.a;
      if (localDrawable != null) {
        localDrawable.setVisible(bool, false);
      }
      localDrawable = this.e;
      if (localDrawable != null) {
        localDrawable.setVisible(bool, false);
      }
      localDrawable = this.d;
      if (localDrawable != null) {
        localDrawable.setVisible(bool, false);
      }
      return;
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    if (paramInt == 0) {
      return null;
    }
    return super.startActionModeForChild(paramView, paramCallback, paramInt);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != this.a) {}
    for (;;)
    {
      if (paramDrawable != this.e) {
        if (((paramDrawable != this.d) || (!this.b)) && (!super.verifyDrawable(paramDrawable))) {}
      }
      do
      {
        do
        {
          return true;
          return false;
        } while (this.c);
        break;
      } while (!this.b);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ActionBarContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */