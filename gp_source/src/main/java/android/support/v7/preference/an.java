package android.support.v7.preference;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.b;
import android.support.v7.widget.RecyclerView;
import android.view.View;

final class an
  extends b
{
  an(am paramam) {}
  
  public final void a(View paramView, a parama)
  {
    this.b.b.a(paramView, parama);
    int i = RecyclerView.c(paramView);
    paramView = this.b.c.getAdapter();
    if ((paramView instanceof ae))
    {
      paramView = ((ae)paramView).a(i);
      if (paramView != null) {
        paramView.a(parama);
      }
    }
  }
  
  public final boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    return this.b.b.a(paramView, paramInt, paramBundle);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */