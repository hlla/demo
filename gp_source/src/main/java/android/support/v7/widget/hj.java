package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.d;
import android.support.v7.view.menu.af;
import android.support.v7.view.menu.ag;
import android.support.v7.view.menu.ap;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.t;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import java.util.ArrayList;

final class hj
  implements af
{
  public t a;
  private p b;
  
  hj(Toolbar paramToolbar) {}
  
  public final void a(Context paramContext, p paramp)
  {
    paramContext = this.b;
    if (paramContext != null)
    {
      t localt = this.a;
      if (localt != null) {
        paramContext.b(localt);
      }
    }
    this.b = paramp;
  }
  
  public final void a(ag paramag) {}
  
  public final void a(p paramp, boolean paramBoolean) {}
  
  public final void a(boolean paramBoolean)
  {
    if (this.a != null)
    {
      p localp = this.b;
      if (localp != null)
      {
        int j = localp.size();
        int i = 0;
        while (i < j)
        {
          if (this.b.getItem(i) == this.a) {
            return;
          }
          i += 1;
        }
      }
      c(this.a);
    }
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(ap paramap)
  {
    return false;
  }
  
  public final boolean b(t paramt)
  {
    Object localObject1 = this.c;
    if (((Toolbar)localObject1).c == null)
    {
      ((Toolbar)localObject1).c = new al(((Toolbar)localObject1).getContext(), null, 2130969683);
      ((Toolbar)localObject1).c.setImageDrawable(((Toolbar)localObject1).e);
      ((Toolbar)localObject1).c.setContentDescription(((Toolbar)localObject1).d);
      localObject2 = Toolbar.g();
      ((hk)localObject2).a = (((Toolbar)localObject1).b & 0x70 | 0x800003);
      ((hk)localObject2).b = 2;
      ((Toolbar)localObject1).c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((Toolbar)localObject1).c.setOnClickListener(new hi((Toolbar)localObject1));
    }
    localObject1 = this.c.c.getParent();
    Object localObject2 = this.c;
    if (localObject1 != localObject2)
    {
      if ((localObject1 instanceof ViewGroup)) {
        ((ViewGroup)localObject1).removeView(((Toolbar)localObject2).c);
      }
      localObject1 = this.c;
      ((Toolbar)localObject1).addView(((Toolbar)localObject1).c);
    }
    this.c.g = paramt.getActionView();
    this.a = paramt;
    localObject1 = this.c.g.getParent();
    localObject2 = this.c;
    if (localObject1 != localObject2)
    {
      if ((localObject1 instanceof ViewGroup)) {
        ((ViewGroup)localObject1).removeView(((Toolbar)localObject2).g);
      }
      localObject1 = Toolbar.g();
      localObject2 = this.c;
      ((hk)localObject1).a = (((Toolbar)localObject2).b & 0x70 | 0x800003);
      ((hk)localObject1).b = 2;
      ((Toolbar)localObject2).g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.c;
      ((Toolbar)localObject1).addView(((Toolbar)localObject1).g);
    }
    localObject1 = this.c;
    int i = ((Toolbar)localObject1).getChildCount() - 1;
    if (i < 0)
    {
      this.c.requestLayout();
      paramt.d(true);
      paramt = this.c.g;
      if ((paramt instanceof d)) {
        ((d)paramt).onActionViewExpanded();
      }
      return true;
    }
    localObject2 = ((Toolbar)localObject1).getChildAt(i);
    if (((hk)((View)localObject2).getLayoutParams()).b == 2) {}
    for (;;)
    {
      i -= 1;
      break;
      if (localObject2 != ((Toolbar)localObject1).k)
      {
        ((Toolbar)localObject1).removeViewAt(i);
        ((Toolbar)localObject1).i.add(localObject2);
      }
    }
  }
  
  public final boolean c(t paramt)
  {
    Object localObject = this.c.g;
    if ((localObject instanceof d)) {
      ((d)localObject).onActionViewCollapsed();
    }
    localObject = this.c;
    ((Toolbar)localObject).removeView(((Toolbar)localObject).g);
    localObject = this.c;
    ((Toolbar)localObject).removeView(((Toolbar)localObject).c);
    localObject = this.c;
    ((Toolbar)localObject).g = null;
    int i = ((Toolbar)localObject).i.size() - 1;
    while (i >= 0)
    {
      ((Toolbar)localObject).addView((View)((Toolbar)localObject).i.get(i));
      i -= 1;
    }
    ((Toolbar)localObject).i.clear();
    this.a = null;
    this.c.requestLayout();
    paramt.d(false);
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */