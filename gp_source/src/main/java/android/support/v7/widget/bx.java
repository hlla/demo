package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.ag;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.e.a.a.a.a.b;
import java.lang.reflect.Field;

class bx
  extends ListView
{
  public boolean a;
  public bz b;
  private boolean c;
  private boolean d;
  private Field e;
  private int f;
  private ag g;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private by l;
  private final Rect m = new Rect();
  
  bx(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, 2130968867);
    this.d = paramBoolean;
    setCacheColorHint(0);
    try
    {
      this.e = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.e.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException paramContext)
    {
      com.google.e.a.a.a.a.a.a.a(paramContext);
    }
  }
  
  private final void a()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (this.c) && (isPressed())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    by localby = this.l;
    if (localby != null) {
      localby.a = paramBoolean;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int n = getListPaddingTop();
    int i1 = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    paramInt3 = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter != null)
    {
      if (paramInt3 <= 0) {
        paramInt3 = 0;
      }
      for (;;)
      {
        int i5 = localListAdapter.getCount();
        paramInt2 = 0;
        int i2 = 0;
        int i3 = 0;
        localObject = null;
        i1 = n + i1;
        if (i3 < i5)
        {
          int i4 = localListAdapter.getItemViewType(i3);
          if (i4 != i2) {}
          for (n = i4;; n = i2)
          {
            if (i4 != i2) {
              localObject = null;
            }
            View localView = localListAdapter.getView(i3, (View)localObject, this);
            ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
            localObject = localLayoutParams;
            if (localLayoutParams == null)
            {
              localObject = generateDefaultLayoutParams();
              localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            }
            if (((ViewGroup.LayoutParams)localObject).height > 0) {}
            for (i2 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i2 = View.MeasureSpec.makeMeasureSpec(0, 0))
            {
              localView.measure(paramInt1, i2);
              localView.forceLayout();
              if (i3 > 0) {
                i1 += paramInt3;
              }
              for (;;)
              {
                i1 = localView.getMeasuredHeight() + i1;
                if (i1 < paramInt4)
                {
                  if (paramInt5 < 0) {}
                  for (;;)
                  {
                    i3 += 1;
                    localObject = localView;
                    i2 = n;
                    break;
                    if (i3 >= paramInt5) {
                      paramInt2 = i1;
                    }
                  }
                }
                if ((paramInt5 >= 0) && (i3 > paramInt5) && (paramInt2 > 0) && (i1 != paramInt4)) {
                  return paramInt2;
                }
                return paramInt4;
              }
            }
          }
        }
        return i1;
        if (localObject == null) {
          paramInt3 = 0;
        }
      }
    }
    return n + i1;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    int n = paramMotionEvent.getActionMasked();
    View localView;
    switch (n)
    {
    default: 
      bool = true;
      paramInt = 0;
      if (!bool) {}
      for (;;)
      {
        this.c = false;
        setPressed(false);
        drawableStateChanged();
        localView = getChildAt(this.f - getFirstVisiblePosition());
        if (localView != null) {
          localView.setPressed(false);
        }
        do
        {
          if (!bool)
          {
            paramMotionEvent = this.g;
            if (paramMotionEvent != null) {
              paramMotionEvent.a(false);
            }
            return bool;
          }
          if (this.g == null) {
            this.g = new ag(this);
          }
          this.g.a(true);
          this.g.onTouch(this, paramMotionEvent);
          return bool;
        } while (paramInt == 0);
      }
    }
    for (boolean bool = false;; bool = true)
    {
      int i1 = paramMotionEvent.findPointerIndex(paramInt);
      if (i1 >= 0)
      {
        paramInt = (int)paramMotionEvent.getX(i1);
        int i2 = (int)paramMotionEvent.getY(i1);
        i1 = pointToPosition(paramInt, i2);
        if (i1 != -1)
        {
          localView = getChildAt(i1 - getFirstVisiblePosition());
          float f1 = paramInt;
          float f2 = i2;
          this.c = true;
          if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f1, f2);
          }
          if (!isPressed()) {
            setPressed(true);
          }
          layoutChildren();
          paramInt = this.f;
          Object localObject;
          if (paramInt != -1)
          {
            localObject = getChildAt(paramInt - getFirstVisiblePosition());
            if (localObject != null) {
              break label658;
            }
          }
          for (;;)
          {
            this.f = i1;
            float f3 = localView.getLeft();
            float f4 = localView.getTop();
            if (Build.VERSION.SDK_INT >= 21) {
              localView.drawableHotspotChanged(f1 - f3, f2 - f4);
            }
            if (!localView.isPressed()) {
              localView.setPressed(true);
            }
            localObject = getSelector();
            if (localObject == null) {
              paramInt = 0;
            }
            for (;;)
            {
              if (paramInt == 0) {}
              for (;;)
              {
                Rect localRect = this.m;
                localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
                localRect.left -= this.i;
                localRect.top -= this.k;
                localRect.right += this.j;
                localRect.bottom += this.h;
                try
                {
                  bool = this.e.getBoolean(this);
                  if (localView.isEnabled() != bool)
                  {
                    this.e.set(this, Boolean.valueOf(bool ^ true));
                    if (i1 != -1) {
                      refreshDrawableState();
                    }
                  }
                }
                catch (IllegalAccessException localIllegalAccessException)
                {
                  for (;;)
                  {
                    com.google.e.a.a.a.a.a.a.a(localIllegalAccessException);
                  }
                }
                if (paramInt != 0)
                {
                  localRect = this.m;
                  f3 = localRect.exactCenterX();
                  f4 = localRect.exactCenterY();
                  if (getVisibility() != 0) {
                    break label625;
                  }
                }
                label625:
                for (bool = true;; bool = false)
                {
                  ((Drawable)localObject).setVisible(bool, false);
                  android.support.v4.a.a.a.a((Drawable)localObject, f3, f4);
                  localObject = getSelector();
                  if (localObject == null) {}
                  for (;;)
                  {
                    a(false);
                    refreshDrawableState();
                    if (n == 1)
                    {
                      performItemClick(localView, i1, getItemIdAtPosition(i1));
                      bool = true;
                      paramInt = 0;
                      break;
                    }
                    bool = true;
                    paramInt = 0;
                    break;
                    if (i1 != -1) {
                      android.support.v4.a.a.a.a((Drawable)localObject, f1, f2);
                    }
                  }
                }
                ((Drawable)localObject).setVisible(false, false);
              }
              if (i1 != -1) {
                paramInt = 1;
              } else {
                paramInt = 0;
              }
            }
            label658:
            if ((localObject != localView) && (((View)localObject).isPressed())) {
              ((View)localObject).setPressed(false);
            }
          }
        }
        paramInt = 1;
        break;
      }
      bool = false;
      paramInt = 0;
      break;
      bool = false;
      paramInt = 0;
      break;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.m.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.m);
        localDrawable.draw(paramCanvas);
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.b == null)
    {
      super.drawableStateChanged();
      a(true);
      a();
    }
  }
  
  public boolean hasFocus()
  {
    return (this.d) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (this.d) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (this.d) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    if (!this.d) {}
    for (;;)
    {
      if (super.isInTouchMode()) {}
      do
      {
        return true;
        return false;
      } while (this.a);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.b = null;
    super.onDetachedFromWindow();
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (Build.VERSION.SDK_INT < 26)
    {
      bool1 = super.onHoverEvent(paramMotionEvent);
      return bool1;
    }
    int n = paramMotionEvent.getActionMasked();
    if ((n == 10) && (this.b == null))
    {
      this.b = new bz(this);
      bz localbz = this.b;
      localbz.a.post(localbz);
    }
    boolean bool2 = super.onHoverEvent(paramMotionEvent);
    if (n == 9) {}
    while (n == 7)
    {
      n = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool1 = bool2;
      if (n == -1) {
        break;
      }
      bool1 = bool2;
      if (n == getSelectedItemPosition()) {
        break;
      }
      paramMotionEvent = getChildAt(n - getFirstVisiblePosition());
      if (paramMotionEvent.isEnabled()) {
        setSelectionFromTop(n, paramMotionEvent.getTop() - getTop());
      }
      a();
      return bool2;
    }
    setSelection(-1);
    return bool2;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bz localbz = this.b;
      if (localbz != null)
      {
        bx localbx = localbz.a;
        localbx.b = null;
        localbx.removeCallbacks(localbz);
      }
      return super.onTouchEvent(paramMotionEvent);
      this.f = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {}
    for (Object localObject = new by(paramDrawable);; localObject = null)
    {
      this.l = ((by)localObject);
      super.setSelector(this.l);
      localObject = new Rect();
      if (paramDrawable != null) {
        paramDrawable.getPadding((Rect)localObject);
      }
      this.i = ((Rect)localObject).left;
      this.k = ((Rect)localObject).top;
      this.j = ((Rect)localObject).right;
      this.h = ((Rect)localObject).bottom;
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */