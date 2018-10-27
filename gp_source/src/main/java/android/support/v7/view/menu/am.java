package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.du;
import android.support.v7.widget.ed;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class am
  extends ac
  implements af, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static final int e = 2131623955;
  public final ViewTreeObserver.OnGlobalLayoutListener a = new an(this);
  public final ed b;
  public View c;
  public ViewTreeObserver d;
  private final o f;
  private View h;
  private final View.OnAttachStateChangeListener i = new ao(this);
  private int j;
  private final Context k;
  private int l = 0;
  private boolean m;
  private final p n;
  private PopupWindow.OnDismissListener o;
  private final boolean p;
  private final int q;
  private final int r;
  private final int s;
  private ag t;
  private boolean u;
  private boolean v;
  
  public am(Context paramContext, p paramp, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.k = paramContext;
    this.n = paramp;
    this.p = paramBoolean;
    this.f = new o(paramp, LayoutInflater.from(paramContext), this.p, e);
    this.r = paramInt1;
    this.s = paramInt2;
    Resources localResources = paramContext.getResources();
    this.q = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(2131165207));
    this.h = paramView;
    this.b = new ed(this.k, this.r, this.s);
    paramp.a(this, paramContext);
  }
  
  public final void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public final void a(ag paramag)
  {
    this.t = paramag;
  }
  
  public final void a(p paramp) {}
  
  public final void a(p paramp, boolean paramBoolean)
  {
    if (paramp == this.n)
    {
      c();
      ag localag = this.t;
      if (localag != null) {
        localag.a(paramp, paramBoolean);
      }
    }
  }
  
  public final void a(View paramView)
  {
    this.h = paramView;
  }
  
  public final void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.o = paramOnDismissListener;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.m = false;
    o localo = this.f;
    if (localo != null) {
      localo.notifyDataSetChanged();
    }
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(ap paramap)
  {
    if (paramap.hasVisibleItems())
    {
      Object localObject = new ad(this.k, paramap, this.c, this.p, this.r, this.s);
      ((ad)localObject).a(this.t);
      ((ad)localObject).a(ac.b(paramap));
      ((ad)localObject).c = this.o;
      this.o = null;
      this.n.a(false);
      ed localed = this.b;
      int i2 = localed.g;
      int i3 = localed.g();
      int i1 = i2;
      if ((Gravity.getAbsoluteGravity(this.l, android.support.v4.view.ac.h(this.h)) & 0x7) == 5) {
        i1 = i2 + this.h.getWidth();
      }
      if (!((ad)localObject).f())
      {
        if (((ad)localObject).a != null) {
          ((ad)localObject).a(i1, i3, true, true);
        }
      }
      else
      {
        localObject = this.t;
        if (localObject != null) {
          ((ag)localObject).a(paramap);
        }
        return true;
      }
    }
    return false;
  }
  
  public final void b()
  {
    Object localObject1;
    Object localObject2;
    if (!d())
    {
      if (this.v) {
        break label285;
      }
      localObject1 = this.h;
      if (localObject1 == null) {
        break label285;
      }
      this.c = ((View)localObject1);
      this.b.a(this);
      localObject1 = this.b;
      ((du)localObject1).l = this;
      ((du)localObject1).f();
      localObject1 = this.c;
      localObject2 = this.d;
      this.d = ((View)localObject1).getViewTreeObserver();
      if (localObject2 == null) {
        this.d.addOnGlobalLayoutListener(this.a);
      }
      ((View)localObject1).addOnAttachStateChangeListener(this.i);
      localObject2 = this.b;
      ((du)localObject2).e = ((View)localObject1);
      ((du)localObject2).f = this.l;
      if (!this.m)
      {
        this.j = a(this.f, null, this.k, this.q);
        this.m = true;
      }
      this.b.b(this.j);
      this.b.h();
      localObject1 = this.b;
      ((du)localObject1).j = this.g;
      ((du)localObject1).b();
      localObject1 = this.b.h;
      ((ListView)localObject1).setOnKeyListener(this);
      if ((this.u) && (this.n.g != null)) {
        break label225;
      }
    }
    for (;;)
    {
      this.b.a(this.f);
      this.b.b();
      return;
      label225:
      localObject2 = (FrameLayout)LayoutInflater.from(this.k).inflate(2131623954, (ViewGroup)localObject1, false);
      TextView localTextView = (TextView)((FrameLayout)localObject2).findViewById(16908310);
      if (localTextView != null) {
        localTextView.setText(this.n.g);
      }
      ((FrameLayout)localObject2).setEnabled(false);
      ((ListView)localObject1).addHeaderView((View)localObject2, null, false);
    }
    label285:
    throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
  }
  
  public final void b(int paramInt)
  {
    this.b.g = paramInt;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.f.b = paramBoolean;
  }
  
  public final void c()
  {
    if (d()) {
      this.b.c();
    }
  }
  
  public final void c(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public final void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public final boolean d()
  {
    return (!this.v) && (this.b.q.isShowing());
  }
  
  public final ListView e()
  {
    return this.b.h;
  }
  
  public final void onDismiss()
  {
    this.v = true;
    this.n.close();
    Object localObject = this.d;
    if (localObject != null)
    {
      if (!((ViewTreeObserver)localObject).isAlive()) {
        this.d = this.c.getViewTreeObserver();
      }
      this.d.removeGlobalOnLayoutListener(this.a);
      this.d = null;
    }
    this.c.removeOnAttachStateChangeListener(this.i);
    localObject = this.o;
    if (localObject != null) {
      ((PopupWindow.OnDismissListener)localObject).onDismiss();
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */