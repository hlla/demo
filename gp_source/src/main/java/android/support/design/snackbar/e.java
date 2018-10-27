package android.support.design.snackbar;

import android.os.Bundle;
import android.support.v4.view.a.a;
import android.support.v4.view.b;
import android.view.View;

final class e
  extends b
{
  e(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public final void a(View paramView, a parama)
  {
    super.a(paramView, parama);
    parama.a(1048576);
    parama.a();
  }
  
  public final boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 1048576)
    {
      this.b.a(3);
      return true;
    }
    return super.a(paramView, paramInt, paramBundle);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */