package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.a.d;
import android.support.v4.view.b;
import android.view.View;

public final class gb
  extends b
{
  private final ga b;
  
  public gb(ga paramga)
  {
    this.b = paramga;
  }
  
  public final void a(View paramView, a parama)
  {
    super.a(paramView, parama);
    ff localff;
    if ((!this.b.c.p()) && (this.b.c.getLayoutManager() != null))
    {
      localff = this.b.c.getLayoutManager();
      Object localObject = RecyclerView.b(paramView);
      if ((localObject != null) && (!((fz)localObject).l()) && (!localff.f.d(((fz)localObject).c)))
      {
        localObject = localff.m;
        fp localfp = ((RecyclerView)localObject).B;
        localObject = ((RecyclerView)localObject).G;
        if (!localff.o()) {
          break label152;
        }
      }
    }
    label152:
    for (int i = localff.a(paramView);; i = 0)
    {
      if (localff.n()) {}
      for (int j = localff.a(paramView);; j = 0)
      {
        parama.a(d.a(i, 1, j, 1, false, false));
        return;
      }
    }
  }
  
  public final boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (!super.a(paramView, paramInt, paramBundle))
    {
      if ((!this.b.c.p()) && (this.b.c.getLayoutManager() != null))
      {
        paramView = this.b.c.getLayoutManager().m;
        paramBundle = paramView.B;
        paramView = paramView.G;
      }
      return false;
    }
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */