package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ac;
import android.support.v4.view.k;
import android.support.v4.widget.ak;
import android.support.v7.a.a;
import android.support.v7.view.menu.al;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class du
  implements al
{
  private static Method A;
  private static Method B;
  private static Method z;
  private ListAdapter a;
  private Context b;
  private int c = -2;
  private int d;
  public View e;
  public int f = 0;
  public int g;
  public bx h;
  public int i = -2;
  public Rect j;
  public final Handler k;
  public AdapterView.OnItemClickListener l;
  public int m = Integer.MAX_VALUE;
  public boolean n;
  public boolean o;
  public boolean p;
  public PopupWindow q;
  public final eb r = new eb(this);
  private boolean s;
  private int t = 1002;
  private final dx u = new dx(this);
  private DataSetObserver v;
  private final dz w = new dz(this);
  private final Rect x = new Rect();
  private final ea y = new ea(this);
  
  static
  {
    try
    {
      z = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      try
      {
        for (;;)
        {
          A = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
          try
          {
            B = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
          }
          localNoSuchMethodException1 = localNoSuchMethodException1;
          Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;)
        {
          Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
      }
    }
  }
  
  public du(Context paramContext)
  {
    this(paramContext, null, 2130969329);
  }
  
  public du(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public du(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.b = paramContext;
    this.k = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.bm, paramInt1, paramInt2);
    this.g = localTypedArray.getDimensionPixelOffset(a.bn, 0);
    this.d = localTypedArray.getDimensionPixelOffset(a.bo, 0);
    if (this.d != 0) {
      this.s = true;
    }
    localTypedArray.recycle();
    this.q = new ao(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.q.setInputMethodMode(1);
  }
  
  private final int a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (A != null) {
      try
      {
        int i1 = ((Integer)A.invoke(this.q, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i1;
      }
      catch (Exception localException)
      {
        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
      }
    }
    return this.q.getMaxAvailableHeight(paramView, paramInt);
  }
  
  bx a(Context paramContext, boolean paramBoolean)
  {
    return new bx(paramContext, paramBoolean);
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
    this.s = true;
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.q.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    DataSetObserver localDataSetObserver = this.v;
    if (localDataSetObserver == null) {
      this.v = new dy(this);
    }
    for (;;)
    {
      this.a = paramListAdapter;
      if (paramListAdapter != null) {
        paramListAdapter.registerDataSetObserver(this.v);
      }
      paramListAdapter = this.h;
      if (paramListAdapter != null) {
        paramListAdapter.setAdapter(this.a);
      }
      return;
      ListAdapter localListAdapter = this.a;
      if (localListAdapter != null) {
        localListAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
  }
  
  public final void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.q.setOnDismissListener(paramOnDismissListener);
  }
  
  public void b()
  {
    int i3 = 0;
    Object localObject;
    if (this.h == null)
    {
      localObject = this.b;
      new dv(this);
      this.h = a((Context)localObject, this.n ^ true);
      this.h.setAdapter(this.a);
      this.h.setOnItemClickListener(this.l);
      this.h.setFocusable(true);
      this.h.setFocusableInTouchMode(true);
      this.h.setOnItemSelectedListener(new dw(this));
      this.h.setOnScrollListener(this.w);
      localObject = this.h;
      this.q.setContentView((View)localObject);
    }
    for (;;)
    {
      localObject = this.q.getBackground();
      int i1;
      label178:
      boolean bool;
      label192:
      int i4;
      int i2;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(this.x);
        i1 = this.x.top + this.x.bottom;
        if (!this.s)
        {
          this.d = (-this.x.top);
          if (this.q.getInputMethodMode() == 2)
          {
            bool = true;
            i4 = a(this.e, this.d, bool);
            if (this.c != -1)
            {
              i2 = this.i;
              switch (i2)
              {
              default: 
                i2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                label252:
                i2 = this.h.a(i2, 0, -1, i4, -1);
                if (i2 > 0)
                {
                  i1 = this.h.getPaddingTop() + this.h.getPaddingBottom() + i1;
                  label288:
                  i1 += i2;
                  label292:
                  bool = j();
                  ak.a(this.q, this.t);
                  if (!this.q.isShowing())
                  {
                    i3 = this.i;
                    if (i3 == -1)
                    {
                      i2 = -1;
                      i3 = this.c;
                      if (i3 == -1)
                      {
                        i1 = -1;
                        label343:
                        this.q.setWidth(i2);
                        this.q.setHeight(i1);
                        if (z == null) {
                          break;
                        }
                      }
                    }
                  }
                }
                break;
              }
            }
          }
        }
      }
      try
      {
        z.invoke(this.q, new Object[] { Boolean.valueOf(true) });
        this.q.setOutsideTouchable(true);
        this.q.setTouchInterceptor(this.y);
        if (this.p) {
          ak.a(this.q, this.o);
        }
        if (B == null) {}
      }
      catch (Exception localException1)
      {
        try
        {
          B.invoke(this.q, new Object[] { this.j });
          localObject = this.q;
          View localView = this.e;
          i2 = this.g;
          i3 = this.d;
          i4 = this.f;
          if (Build.VERSION.SDK_INT >= 19)
          {
            ((PopupWindow)localObject).showAsDropDown(localView, i2, i3, i4);
            label499:
            this.h.setSelection(-1);
            if ((!this.n) || (this.h.isInTouchMode())) {
              i();
            }
            if (!this.n) {
              this.k.post(this.u);
            }
          }
          do
          {
            return;
            i1 = i2;
            if ((k.a(i4, ac.h(localView)) & 0x7) == 5) {
              i1 = i2 - (((PopupWindow)localObject).getWidth() - localView.getWidth());
            }
            ((PopupWindow)localObject).showAsDropDown(localView, i1, i3);
            break label499;
            if (i3 == -2) {
              break label343;
            }
            i1 = i3;
            break label343;
            i2 = i3;
            if (i3 != -2) {
              break;
            }
            i2 = this.e.getWidth();
            break;
          } while (!ac.L(this.e));
          i2 = this.i;
          if (i2 == -1) {
            i2 = -1;
          }
          for (;;)
          {
            i4 = this.c;
            if (i4 != -1)
            {
              if (i4 != -2) {
                i1 = i4;
              }
              for (;;)
              {
                this.q.setOutsideTouchable(true);
                localObject = this.q;
                localView = this.e;
                i4 = this.g;
                int i5 = this.d;
                i3 = i2;
                if (i2 < 0) {
                  i3 = -1;
                }
                i2 = i1;
                if (i1 < 0) {
                  i2 = -1;
                }
                ((PopupWindow)localObject).update(localView, i4, i5, i3, i2);
                return;
              }
            }
            if (!bool) {
              i1 = -1;
            }
            for (;;)
            {
              if (!bool)
              {
                localObject = this.q;
                if (this.i == -1) {
                  i3 = -1;
                }
                ((PopupWindow)localObject).setWidth(i3);
                this.q.setHeight(-1);
                break;
              }
              localObject = this.q;
              if (this.i == -1) {}
              for (i3 = -1;; i3 = 0)
              {
                ((PopupWindow)localObject).setWidth(i3);
                this.q.setHeight(0);
                break;
              }
            }
            if (i2 == -2) {
              i2 = this.e.getWidth();
            }
          }
          i1 = 0;
          break label288;
          i2 = View.MeasureSpec.makeMeasureSpec(this.b.getResources().getDisplayMetrics().widthPixels - (this.x.left + this.x.right), 1073741824);
          break label252;
          i2 = View.MeasureSpec.makeMeasureSpec(this.b.getResources().getDisplayMetrics().widthPixels - (this.x.left + this.x.right), Integer.MIN_VALUE);
          break label252;
          i1 = i4 + i1;
          break label292;
          bool = false;
          break label192;
          break label178;
          this.x.setEmpty();
          i1 = 0;
          break label178;
          this.q.getContentView();
          continue;
          localException1 = localException1;
          Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", localException2);
          }
        }
      }
    }
  }
  
  public final void b(int paramInt)
  {
    Drawable localDrawable = this.q.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.x);
      this.i = (this.x.left + this.x.right + paramInt);
      return;
    }
    this.i = paramInt;
  }
  
  public final void c()
  {
    this.q.dismiss();
    this.q.setContentView(null);
    this.h = null;
    this.k.removeCallbacks(this.r);
  }
  
  public final boolean d()
  {
    return this.q.isShowing();
  }
  
  public final ListView e()
  {
    return this.h;
  }
  
  public final void f()
  {
    this.n = true;
    this.q.setFocusable(true);
  }
  
  public final int g()
  {
    if (this.s) {
      return this.d;
    }
    return 0;
  }
  
  public final void h()
  {
    this.q.setInputMethodMode(2);
  }
  
  public final void i()
  {
    bx localbx = this.h;
    if (localbx != null)
    {
      localbx.a = true;
      localbx.requestLayout();
    }
  }
  
  public final boolean j()
  {
    return this.q.getInputMethodMode() == 2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */