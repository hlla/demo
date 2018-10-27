package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.ah;
import android.support.v7.view.menu.ai;
import android.support.v7.view.menu.ap;
import android.support.v7.view.menu.d;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.util.ArrayList;

final class j
  extends d
{
  public k f;
  public boolean g;
  public int h;
  public n i;
  public p j;
  public Drawable k;
  public boolean l;
  public final q m = new q(this);
  public m n;
  private final SparseBooleanArray o = new SparseBooleanArray();
  private int p;
  private l q;
  private boolean r;
  private boolean s;
  private View t;
  private int u;
  
  public j(Context paramContext)
  {
    super(paramContext);
  }
  
  public final ah a(ViewGroup paramViewGroup)
  {
    ah localah = this.d;
    paramViewGroup = super.a(paramViewGroup);
    if (localah != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public final View a(android.support.v7.view.menu.t paramt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramt.getActionView();
    if ((localView == null) || (paramt.h())) {
      localView = super.a(paramt, paramView, paramViewGroup);
    }
    if (!paramt.isActionViewExpanded()) {}
    for (int i1 = 0;; i1 = 8)
    {
      localView.setVisibility(i1);
      paramt = (ActionMenuView)paramViewGroup;
      paramView = localView.getLayoutParams();
      if (!paramt.checkLayoutParams(paramView)) {
        localView.setLayoutParams(ActionMenuView.a(paramView));
      }
      return localView;
    }
  }
  
  public final void a(Context paramContext, android.support.v7.view.menu.p paramp)
  {
    super.a(paramContext, paramp);
    paramp = paramContext.getResources();
    paramContext = a.a(paramContext);
    if (this.s)
    {
      this.u = (paramContext.a.getResources().getDisplayMetrics().widthPixels / 2);
      this.h = paramContext.a();
      int i1 = this.u;
      if (this.r)
      {
        if (this.i == null)
        {
          this.i = new n(this, this.e);
          if (this.l)
          {
            this.i.setImageDrawable(this.k);
            this.k = null;
            this.l = false;
          }
          int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.i.measure(i2, i2);
        }
        i1 -= this.i.getMeasuredWidth();
      }
      for (;;)
      {
        this.p = i1;
        float f1 = paramp.getDisplayMetrics().density;
        this.t = null;
        return;
        this.i = null;
      }
    }
    if (Build.VERSION.SDK_INT < 19) {}
    for (boolean bool = ViewConfiguration.get(paramContext.a).hasPermanentMenuKey() ^ true;; bool = true)
    {
      this.r = bool;
      break;
    }
  }
  
  public final void a(android.support.v7.view.menu.p paramp, boolean paramBoolean)
  {
    e();
    super.a(paramp, paramBoolean);
  }
  
  public final void a(android.support.v7.view.menu.t paramt, ai paramai)
  {
    paramai.a(paramt);
    paramt = (ActionMenuView)this.d;
    paramai = (ActionMenuItemView)paramai;
    paramai.setItemInvoker(paramt);
    if (this.q == null) {
      this.q = new l(this);
    }
    paramai.setPopupCallback(this.q);
  }
  
  public final void a(ActionMenuView paramActionMenuView)
  {
    this.d = paramActionMenuView;
    paramActionMenuView.a = this.c;
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ((View)this.d).requestLayout();
    Object localObject1 = this.c;
    if (localObject1 == null) {}
    for (;;)
    {
      localObject1 = this.c;
      if (localObject1 != null) {}
      for (localObject1 = ((android.support.v7.view.menu.p)localObject1).k();; localObject1 = null)
      {
        if (!this.r) {}
        Object localObject2;
        label94:
        do
        {
          do
          {
            localObject1 = this.i;
            if (localObject1 != null)
            {
              localObject1 = ((n)localObject1).getParent();
              localObject2 = this.d;
              if (localObject1 == localObject2) {
                ((ViewGroup)localObject2).removeView(this.i);
              }
            }
            ((ActionMenuView)this.d).setOverflowReserved(this.r);
            return;
          } while (localObject1 == null);
          i1 = ((ArrayList)localObject1).size();
          if (i1 != 1) {
            break;
          }
        } while (!(((android.support.v7.view.menu.t)((ArrayList)localObject1).get(0)).isActionViewExpanded() ^ true));
        for (;;)
        {
          if (this.i == null) {
            this.i = new n(this, this.e);
          }
          localObject1 = (ViewGroup)this.i.getParent();
          if (localObject1 == this.d) {
            break label94;
          }
          if (localObject1 == null) {}
          for (;;)
          {
            localObject1 = (ActionMenuView)this.d;
            localObject2 = this.i;
            t localt = ActionMenuView.a();
            localt.e = true;
            ((ActionMenuView)localObject1).addView((View)localObject2, localt);
            break;
            ((ViewGroup)localObject1).removeView(this.i);
          }
          if (i1 <= 0) {
            break;
          }
        }
      }
      ((android.support.v7.view.menu.p)localObject1).j();
      localObject1 = ((android.support.v7.view.menu.p)localObject1).a;
      int i2 = ((ArrayList)localObject1).size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((ArrayList)localObject1).get(i1);
        i1 += 1;
      }
    }
  }
  
  public final boolean a()
  {
    Object localObject1 = this.c;
    int i5;
    int i1;
    int i7;
    int i3;
    int i6;
    int i4;
    int i2;
    Object localObject2;
    label153:
    android.support.v7.view.menu.t localt;
    label253:
    label290:
    label337:
    int i9;
    boolean bool;
    label357:
    int i10;
    if (localObject1 != null)
    {
      localObject1 = ((android.support.v7.view.menu.p)localObject1).i();
      i5 = ((ArrayList)localObject1).size();
      i1 = this.h;
      i7 = this.p;
      int i8 = View.MeasureSpec.makeMeasureSpec(0, 0);
      ViewGroup localViewGroup = (ViewGroup)this.d;
      i3 = 0;
      i6 = 0;
      i4 = 0;
      i2 = 0;
      if (i2 < i5)
      {
        localObject2 = (android.support.v7.view.menu.t)((ArrayList)localObject1).get(i2);
        if (((android.support.v7.view.menu.t)localObject2).g()) {
          i3 += 1;
        }
        for (;;)
        {
          if (this.g) {
            if (((android.support.v7.view.menu.t)localObject2).isActionViewExpanded()) {
              i1 = 0;
            }
          }
          for (;;)
          {
            i2 += 1;
            break;
          }
          if ((((android.support.v7.view.menu.t)localObject2).f & 0x1) != 0) {
            i6 += 1;
          } else {
            i4 = 1;
          }
        }
      }
      if (!this.r)
      {
        i1 -= i3;
        localObject2 = this.o;
        ((SparseBooleanArray)localObject2).clear();
        i2 = 0;
        i6 = 0;
        i3 = i7;
        if (i6 < i5)
        {
          localt = (android.support.v7.view.menu.t)((ArrayList)localObject1).get(i6);
          Object localObject3;
          if (localt.g())
          {
            localObject3 = a(localt, this.t, localViewGroup);
            if (this.t == null) {
              this.t = ((View)localObject3);
            }
            ((View)localObject3).measure(i8, i8);
            i4 = ((View)localObject3).getMeasuredWidth();
            if (i2 == 0)
            {
              i2 = i4;
              i7 = localt.getGroupId();
              if (i7 != 0) {
                ((SparseBooleanArray)localObject2).put(i7, true);
              }
              localt.c(true);
              i4 = i3 - i4;
              i3 = i1;
              i1 = i4;
            }
          }
          for (;;)
          {
            i6 += 1;
            i4 = i1;
            i1 = i3;
            i3 = i4;
            break;
            break label253;
            if ((localt.f & 0x1) != 0) {
              break label337;
            }
            localt.c(false);
            i4 = i1;
            i1 = i3;
            i3 = i4;
          }
          i9 = localt.getGroupId();
          bool = ((SparseBooleanArray)localObject2).get(i9);
          if (i1 > 0) {
            if (i3 > 0)
            {
              i10 = 1;
              label364:
              if (i10 != 0)
              {
                localObject3 = a(localt, this.t, localViewGroup);
                if (this.t == null) {
                  this.t = ((View)localObject3);
                }
                ((View)localObject3).measure(i8, i8);
                i7 = ((View)localObject3).getMeasuredWidth();
                i4 = i3 - i7;
                if (i2 != 0)
                {
                  i3 = i2;
                  label424:
                  if (i4 + i3 > 0)
                  {
                    i2 = 1;
                    label433:
                    i10 = i2 & i10;
                    i2 = i4;
                    label442:
                    if (i10 == 0) {
                      label447:
                      if (bool)
                      {
                        ((SparseBooleanArray)localObject2).put(i9, false);
                        i7 = 0;
                        while (i7 < i6)
                        {
                          localObject3 = (android.support.v7.view.menu.t)((ArrayList)localObject1).get(i7);
                          i4 = i1;
                          if (((android.support.v7.view.menu.t)localObject3).getGroupId() == i9)
                          {
                            i4 = i1;
                            if (((android.support.v7.view.menu.t)localObject3).f()) {
                              i4 = i1 + 1;
                            }
                            ((android.support.v7.view.menu.t)localObject3).c(false);
                          }
                          i7 += 1;
                          i1 = i4;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i4 = i1;
      if (i10 != 0) {
        i4 = i1 - 1;
      }
      localt.c(i10);
      i7 = i3;
      i1 = i2;
      i3 = i4;
      i2 = i7;
      break label290;
      if (i9 == 0) {
        break label447;
      }
      ((SparseBooleanArray)localObject2).put(i9, true);
      continue;
      i2 = 0;
      break label433;
      i3 = i7;
      break label424;
      i4 = i3;
      i3 = i2;
      i2 = i4;
      break label442;
      int i11 = 0;
      break label364;
      if (bool) {
        break label357;
      }
      i11 = 0;
      break label364;
      return true;
      if (i4 != 0) {}
      while (i3 + i6 > i1)
      {
        i1 -= 1;
        break;
      }
      break label153;
      i5 = 0;
      localObject1 = null;
      break;
    }
  }
  
  public final boolean a(ap paramap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject1;
    Object localObject2;
    int i2;
    int i1;
    if (paramap.hasVisibleItems())
    {
      for (localObject1 = paramap;; localObject1 = (ap)localObject2)
      {
        localObject2 = ((ap)localObject1).l;
        if (localObject2 == this.c) {
          break;
        }
      }
      localObject2 = ((ap)localObject1).getItem();
      ViewGroup localViewGroup = (ViewGroup)this.d;
      if (localViewGroup == null) {
        break label242;
      }
      i2 = localViewGroup.getChildCount();
      i1 = 0;
      if (i1 >= i2) {
        break label236;
      }
      localObject1 = localViewGroup.getChildAt(i1);
      if (!(localObject1 instanceof ai)) {}
      while (((ai)localObject1).getItemData() != localObject2)
      {
        i1 += 1;
        break;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (localObject1 != null)
      {
        paramap.getItem().getItemId();
        i2 = paramap.size();
        i1 = 0;
        if (i1 >= i2) {
          break label230;
        }
        localObject2 = paramap.getItem(i1);
        if (!((MenuItem)localObject2).isVisible()) {}
        while (((MenuItem)localObject2).getIcon() == null)
        {
          i1 += 1;
          break;
        }
      }
      label230:
      for (bool1 = true;; bool1 = false)
      {
        this.f = new k(this, this.b, paramap, (View)localObject1);
        this.f.a(bool1);
        this.f.a();
        super.a(paramap);
        bool1 = true;
        return bool1;
      }
      label236:
      localObject1 = null;
      continue;
      label242:
      localObject1 = null;
    }
  }
  
  public final boolean a(android.support.v7.view.menu.t paramt)
  {
    return paramt.f();
  }
  
  public final boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) != this.i) {
      return super.a(paramViewGroup, paramInt);
    }
    return false;
  }
  
  public final void b()
  {
    this.r = true;
    this.s = true;
  }
  
  public final boolean c()
  {
    if ((this.r) && (!g()))
    {
      android.support.v7.view.menu.p localp = this.c;
      if ((localp != null) && (this.d != null) && (this.n == null) && (!localp.k().isEmpty()))
      {
        this.n = new m(this, new p(this, this.b, this.c, this.i));
        ((View)this.d).post(this.n);
        super.a(null);
        return true;
      }
    }
    return false;
  }
  
  public final boolean d()
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      ah localah = this.d;
      if (localah != null)
      {
        ((View)localah).removeCallbacks((Runnable)localObject);
        this.n = null;
        return true;
      }
    }
    localObject = this.j;
    if (localObject == null) {
      return false;
    }
    ((ad)localObject).d();
    return true;
  }
  
  public final boolean e()
  {
    return d() | f();
  }
  
  public final boolean f()
  {
    k localk = this.f;
    if (localk != null)
    {
      localk.d();
      return true;
    }
    return false;
  }
  
  public final boolean g()
  {
    p localp = this.j;
    return (localp != null) && (localp.f());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */