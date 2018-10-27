package android.support.v7.widget;

import android.view.View;

public abstract class dp
  extends LinearLayoutManager
  implements di
{
  private final dq r = new dq();
  private final dr s = new dr();
  private dn t;
  private final ds u = new ds();
  
  public abstract View a(ds paramds, int paramInt1, int paramInt2, int paramInt3);
  
  final View a(fp paramfp, fw paramfw, int paramInt1, int paramInt2, int paramInt3)
  {
    p();
    ds localds = this.u;
    localds.a = this.t;
    localds.b = paramfp;
    localds.c = paramfw;
    return a(localds, paramInt1, paramInt2, paramInt3);
  }
  
  public abstract void a(ds paramds, dq paramdq, int paramInt);
  
  public abstract void a(ds paramds, dr paramdr);
  
  final void a(fp paramfp, fw paramfw, dl paramdl, int paramInt)
  {
    int i = -1;
    ds localds = this.u;
    localds.a = this.t;
    localds.b = paramfp;
    localds.c = paramfw;
    paramfp = this.r;
    paramfp.a = paramdl;
    if (paramInt == -1) {}
    for (paramInt = i;; paramInt = 1)
    {
      a(localds, paramfp, paramInt);
      return;
    }
  }
  
  final void a(fp paramfp, fw paramfw, dn paramdn, dm paramdm)
  {
    ds localds = this.u;
    localds.a = paramdn;
    localds.b = paramfp;
    localds.c = paramfw;
    paramfp = this.s;
    paramfp.a = paramdm;
    a(localds, paramfp);
  }
  
  public final void a(View paramView, ds paramds)
  {
    super.a(paramds.b, this.f.c(paramView), paramView);
  }
  
  public final boolean a()
  {
    return this.d;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, fj paramfj)
  {
    return super.a(paramView, paramInt1, paramInt2, paramfj);
  }
  
  public final eh b()
  {
    return this.c;
  }
  
  public final boolean b(View paramView, int paramInt1, int paramInt2, fj paramfj)
  {
    return super.b(paramView, paramInt1, paramInt2, paramfj);
  }
  
  public final boolean d()
  {
    return super.d();
  }
  
  final dn q()
  {
    this.t = super.q();
    return this.t;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */