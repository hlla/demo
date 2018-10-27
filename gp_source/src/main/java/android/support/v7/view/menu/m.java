package android.support.v7.view.menu;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.app.v;
import android.support.v7.app.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

public final class m
  implements af, AdapterView.OnItemClickListener
{
  public n a;
  public ag b;
  public LayoutInflater c;
  public int d = 2131623952;
  public p e;
  public ExpandedMenuView f;
  private Context g;
  
  private m(int paramInt) {}
  
  public m(Context paramContext)
  {
    this(2131623952);
    this.g = paramContext;
    this.c = LayoutInflater.from(this.g);
  }
  
  public final void a(Context paramContext, p paramp)
  {
    if (this.g != null)
    {
      this.g = paramContext;
      if (this.c == null) {
        this.c = LayoutInflater.from(this.g);
      }
    }
    this.e = paramp;
    paramContext = this.a;
    if (paramContext != null) {
      paramContext.notifyDataSetChanged();
    }
  }
  
  public final void a(ag paramag)
  {
    this.b = paramag;
  }
  
  public final void a(p paramp, boolean paramBoolean)
  {
    ag localag = this.b;
    if (localag != null) {
      localag.a(paramp, paramBoolean);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    n localn = this.a;
    if (localn != null) {
      localn.notifyDataSetChanged();
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
      Object localObject1 = new s(paramap);
      Object localObject2 = ((s)localObject1).b;
      w localw = new w(((p)localObject2).c);
      ((s)localObject1).c = new m(localw.a.e);
      Object localObject3 = ((s)localObject1).c;
      ((m)localObject3).b = ((ag)localObject1);
      ((s)localObject1).b.a((af)localObject3);
      localObject3 = ((s)localObject1).c.b();
      android.support.v7.app.p localp = localw.a;
      localp.a = ((ListAdapter)localObject3);
      localp.t = ((DialogInterface.OnClickListener)localObject1);
      localObject3 = ((p)localObject2).h;
      if (localObject3 != null) {
        localw.a((View)localObject3);
      }
      for (;;)
      {
        localw.a.u = ((DialogInterface.OnKeyListener)localObject1);
        ((s)localObject1).a = localw.a();
        ((s)localObject1).a.setOnDismissListener((DialogInterface.OnDismissListener)localObject1);
        localObject2 = ((s)localObject1).a.getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject2).type = 1003;
        ((WindowManager.LayoutParams)localObject2).flags |= 0x20000;
        ((s)localObject1).a.show();
        localObject1 = this.b;
        if (localObject1 != null) {
          ((ag)localObject1).a(paramap);
        }
        return true;
        localw.a(((p)localObject2).f).a(((p)localObject2).g);
      }
    }
    return false;
  }
  
  public final ListAdapter b()
  {
    if (this.a == null) {
      this.a = new n(this);
    }
    return this.a;
  }
  
  public final boolean b(t paramt)
  {
    return false;
  }
  
  public final boolean c(t paramt)
  {
    return false;
  }
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.e.a((t)this.a.getItem(paramInt), this, 0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */