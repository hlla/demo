package android.support.v7.app;

import android.support.v4.view.ac;
import android.support.v4.view.az;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

final class al
  implements c
{
  private c b;
  
  public al(aa paramaa, c paramc)
  {
    this.b = paramc;
  }
  
  public final void a(b paramb)
  {
    this.b.a(paramb);
    paramb = this.a;
    if (paramb.c != null) {
      paramb.p.getDecorView().removeCallbacks(this.a.o);
    }
    paramb = this.a;
    if (paramb.d != null)
    {
      paramb.o();
      paramb = this.a;
      paramb.h = ac.t(paramb.d).a(0.0F);
      this.a.h.a(new am(this));
    }
    Object localObject = this.a;
    paramb = ((aa)localObject).e;
    if (paramb != null)
    {
      localObject = ((aa)localObject).b;
      paramb.i();
    }
    this.a.b = null;
  }
  
  public final boolean a(b paramb, Menu paramMenu)
  {
    return this.b.a(paramb, paramMenu);
  }
  
  public final boolean a(b paramb, MenuItem paramMenuItem)
  {
    return this.b.a(paramb, paramMenuItem);
  }
  
  public final boolean b(b paramb, Menu paramMenu)
  {
    return this.b.b(paramb, paramMenu);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */