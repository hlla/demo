package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.k;
import android.support.v7.widget.du;
import android.support.v7.widget.ec;
import android.support.v7.widget.ed;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class g
  extends ac
  implements af, View.OnKeyListener, PopupWindow.OnDismissListener
{
  private static final int h = 2131623947;
  private int A;
  private int B;
  public final ViewTreeObserver.OnGlobalLayoutListener a = new h(this);
  public boolean b;
  public final List c = new ArrayList();
  public View d;
  public final Handler e;
  public ViewTreeObserver f;
  private View i;
  private final View.OnAttachStateChangeListener j = new i(this);
  private final Context k;
  private int l = 0;
  private boolean m;
  private boolean n;
  private boolean o;
  private int p;
  private final ec q = new j(this);
  private final int r;
  private PopupWindow.OnDismissListener s;
  private final boolean t;
  private final List u = new ArrayList();
  private final int v;
  private final int w;
  private ag x;
  private int y = 0;
  private boolean z;
  
  public g(Context paramContext, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.k = paramContext;
    this.i = paramView;
    this.v = paramInt1;
    this.w = paramInt2;
    this.t = paramBoolean;
    this.m = false;
    this.p = g();
    paramContext = paramContext.getResources();
    this.r = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131165207));
    this.e = new Handler();
  }
  
  private final void c(p paramp)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.k);
    Object localObject1 = new o(paramp, localLayoutInflater, this.t, h);
    if ((d()) || (!this.m)) {
      if (d()) {
        ((o)localObject1).b = ac.b(paramp);
      }
    }
    for (;;)
    {
      int i4 = a((ListAdapter)localObject1, null, this.k, this.r);
      ed localed = new ed(this.k, this.v, this.w);
      localed.a = this.q;
      localed.l = this;
      localed.a(this);
      localed.e = this.i;
      localed.f = this.l;
      localed.f();
      localed.h();
      localed.a((ListAdapter)localObject1);
      localed.b(i4);
      localed.f = this.l;
      Object localObject3;
      Object localObject2;
      int i2;
      int i1;
      label262:
      Object localObject4;
      label315:
      int i3;
      if (this.c.size() > 0)
      {
        localObject1 = this.c;
        localObject3 = (l)((List)localObject1).get(((List)localObject1).size() - 1);
        localObject2 = ((l)localObject3).a;
        i2 = ((p)localObject2).size();
        i1 = 0;
        if (i1 < i2)
        {
          localObject1 = ((p)localObject2).getItem(i1);
          if (!((MenuItem)localObject1).hasSubMenu()) {}
          while (paramp != ((MenuItem)localObject1).getSubMenu())
          {
            i1 += 1;
            break;
          }
          if (localObject1 != null)
          {
            localObject4 = ((l)localObject3).c.h;
            localObject2 = ((ListView)localObject4).getAdapter();
            if ((localObject2 instanceof HeaderViewListAdapter))
            {
              localObject2 = (HeaderViewListAdapter)localObject2;
              i2 = ((HeaderViewListAdapter)localObject2).getHeadersCount();
              localObject2 = (o)((HeaderViewListAdapter)localObject2).getWrappedAdapter();
              i3 = ((o)localObject2).getCount();
              i1 = 0;
              for (;;)
              {
                if (i1 < i3) {
                  if (localObject1 != (t)((o)localObject2).getItem(i1)) {
                    i1 += 1;
                  } else {
                    label351:
                    if (i1 != -1)
                    {
                      i1 = i1 + i2 - ((ListView)localObject4).getFirstVisiblePosition();
                      if (i1 >= 0) {
                        if (i1 < ((ListView)localObject4).getChildCount())
                        {
                          localObject1 = ((ListView)localObject4).getChildAt(i1);
                          label387:
                          localObject2 = localObject1;
                          localObject1 = localObject3;
                          label395:
                          if ((localObject2 != null) && (ed.b == null)) {
                            break;
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
      try
      {
        ed.b.invoke(localed.q, new Object[] { Boolean.valueOf(false) });
        if (Build.VERSION.SDK_INT >= 23) {
          localed.q.setEnterTransition(null);
        }
        localObject3 = this.c;
        localObject3 = ((l)((List)localObject3).get(((List)localObject3).size() - 1)).c.h;
        localObject4 = new int[2];
        ((ListView)localObject3).getLocationOnScreen((int[])localObject4);
        Rect localRect = new Rect();
        this.d.getWindowVisibleDisplayFrame(localRect);
        if (this.p == 1)
        {
          i1 = localObject4[0];
          if (((ListView)localObject3).getWidth() + i1 + i4 > localRect.right)
          {
            i1 = 0;
            this.p = i1;
            if (Build.VERSION.SDK_INT < 26)
            {
              localObject3 = new int[2];
              this.i.getLocationOnScreen((int[])localObject3);
              localObject4 = new int[2];
              ((View)localObject2).getLocationOnScreen((int[])localObject4);
              if ((this.l & 0x7) == 5)
              {
                localObject3[0] += this.i.getWidth();
                localObject4[0] += ((View)localObject2).getWidth();
              }
              i3 = localObject4[0] - localObject3[0];
              i2 = localObject4[1] - localObject3[1];
              label643:
              if ((this.l & 0x5) != 5) {
                if (i1 != 0)
                {
                  i1 = ((View)localObject2).getWidth() + i3;
                  label666:
                  localed.g = i1;
                  localed.p = true;
                  localed.o = true;
                  localed.a(i2);
                }
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = new l(localed, paramp, this.p);
          this.c.add(localObject2);
          localed.b();
          localObject2 = localed.h;
          ((ListView)localObject2).setOnKeyListener(this);
          if ((localObject1 == null) && (this.z) && (paramp.g != null))
          {
            localObject1 = (FrameLayout)localLayoutInflater.inflate(2131623954, (ViewGroup)localObject2, false);
            localObject3 = (TextView)((FrameLayout)localObject1).findViewById(16908310);
            ((FrameLayout)localObject1).setEnabled(false);
            ((TextView)localObject3).setText(paramp.g);
            ((ListView)localObject2).addHeaderView((View)localObject1, null, false);
            localed.b();
          }
          return;
          i1 = i3 - i4;
          break label666;
          if (i1 == 0)
          {
            i1 = i3 - ((View)localObject2).getWidth();
            break label666;
          }
          i1 = i3 + i4;
          break label666;
          localed.e = ((View)localObject2);
          i3 = 0;
          i2 = 0;
          break label643;
          i1 = 1;
          break;
          if (localObject4[0] - i4 >= 0)
          {
            i1 = 0;
            break;
          }
          i1 = 1;
          break;
          if (this.n) {
            localed.g = this.A;
          }
          if (this.o) {
            localed.a(this.B);
          }
          localed.j = this.g;
        }
        localObject1 = null;
        break label387;
        localObject1 = null;
        break label387;
        localObject1 = null;
        break label387;
        i1 = -1;
        break label351;
        localObject2 = (o)localObject2;
        i2 = 0;
        break label315;
        localObject1 = null;
        break label387;
        localObject1 = null;
        break label262;
        localObject2 = null;
        localObject1 = null;
        break label395;
        ((o)localObject1).b = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
        }
      }
    }
  }
  
  private final int g()
  {
    int i1 = 1;
    if (android.support.v4.view.ac.h(this.i) == 1) {
      i1 = 0;
    }
    return i1;
  }
  
  public final void a(int paramInt)
  {
    if (this.y != paramInt)
    {
      this.y = paramInt;
      this.l = k.a(paramInt, android.support.v4.view.ac.h(this.i));
    }
  }
  
  public final void a(ag paramag)
  {
    this.x = paramag;
  }
  
  public final void a(p paramp)
  {
    paramp.a(this, this.k);
    if (d())
    {
      c(paramp);
      return;
    }
    this.u.add(paramp);
  }
  
  public final void a(p paramp, boolean paramBoolean)
  {
    int i3 = this.c.size();
    int i1 = 0;
    while (i1 < i3)
    {
      i2 = i1;
      if (paramp == ((l)this.c.get(i1)).a) {
        break label52;
      }
      i1 += 1;
    }
    int i2 = -1;
    label52:
    Object localObject;
    if (i2 >= 0)
    {
      i1 = i2 + 1;
      if (i1 < this.c.size()) {
        ((l)this.c.get(i1)).a.a(false);
      }
      localObject = (l)this.c.remove(i2);
      ((l)localObject).a.b(this);
      if (this.b)
      {
        ed localed = ((l)localObject).c;
        if (Build.VERSION.SDK_INT >= 23) {
          localed.q.setExitTransition(null);
        }
        ((l)localObject).c.q.setAnimationStyle(0);
      }
      ((l)localObject).c.c();
      i1 = this.c.size();
      if (i1 <= 0) {
        break label313;
      }
    }
    label313:
    for (this.p = ((l)this.c.get(i1 - 1)).b;; this.p = g())
    {
      if (i1 == 0)
      {
        c();
        localObject = this.x;
        if (localObject != null) {
          ((ag)localObject).a(paramp, true);
        }
        paramp = this.f;
        if (paramp != null)
        {
          if (paramp.isAlive()) {
            this.f.removeGlobalOnLayoutListener(this.a);
          }
          this.f = null;
        }
        this.d.removeOnAttachStateChangeListener(this.j);
        this.s.onDismiss();
      }
      while (!paramBoolean) {
        return;
      }
      ((l)this.c.get(0)).a.a(false);
      return;
    }
  }
  
  public final void a(View paramView)
  {
    if (this.i != paramView)
    {
      this.i = paramView;
      this.l = k.a(this.y, android.support.v4.view.ac.h(this.i));
    }
  }
  
  public final void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.s = paramOnDismissListener;
  }
  
  public final void a(boolean paramBoolean)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      a(((l)localIterator.next()).c.h.getAdapter()).notifyDataSetChanged();
    }
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(ap paramap)
  {
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      l locall = (l)((Iterator)localObject).next();
      if (paramap == locall.a)
      {
        locall.c.h.requestFocus();
        return true;
      }
    }
    if (paramap.hasVisibleItems())
    {
      a(paramap);
      localObject = this.x;
      if (localObject != null) {
        ((ag)localObject).a(paramap);
      }
      return true;
    }
    return false;
  }
  
  public final void b()
  {
    if (!d())
    {
      Object localObject = this.u.iterator();
      while (((Iterator)localObject).hasNext()) {
        c((p)((Iterator)localObject).next());
      }
      this.u.clear();
      this.d = this.i;
      localObject = this.d;
      if (localObject != null)
      {
        ViewTreeObserver localViewTreeObserver = this.f;
        this.f = ((View)localObject).getViewTreeObserver();
        if (localViewTreeObserver == null) {
          this.f.addOnGlobalLayoutListener(this.a);
        }
        this.d.addOnAttachStateChangeListener(this.j);
      }
    }
  }
  
  public final void b(int paramInt)
  {
    this.n = true;
    this.A = paramInt;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public final void c()
  {
    int i1 = this.c.size();
    if (i1 > 0)
    {
      l[] arrayOfl = (l[])this.c.toArray(new l[i1]);
      i1 -= 1;
      if (i1 >= 0)
      {
        l locall = arrayOfl[i1];
        if (!locall.c.q.isShowing()) {}
        for (;;)
        {
          i1 -= 1;
          break;
          locall.c.c();
        }
      }
    }
  }
  
  public final void c(int paramInt)
  {
    this.o = true;
    this.B = paramInt;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public final boolean d()
  {
    return (this.c.size() > 0) && (((l)this.c.get(0)).c.q.isShowing());
  }
  
  public final ListView e()
  {
    if (!this.c.isEmpty())
    {
      List localList = this.c;
      return ((l)localList.get(localList.size() - 1)).c.h;
    }
    return null;
  }
  
  protected final boolean f()
  {
    return false;
  }
  
  public final void onDismiss()
  {
    int i2 = this.c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      l locall2 = (l)this.c.get(i1);
      locall1 = locall2;
      if (!locall2.c.q.isShowing()) {
        break label58;
      }
      i1 += 1;
    }
    l locall1 = null;
    label58:
    if (locall1 != null) {
      locall1.a.a(false);
    }
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() != 1) || (paramInt != 82)) {
      return false;
    }
    c();
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */