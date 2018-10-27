package android.support.design.snackbar;

import android.os.Handler;

final class h
  implements o
{
  h(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public final void a()
  {
    BaseTransientBottomBar localBaseTransientBottomBar = this.a;
    if (v.a().d(localBaseTransientBottomBar.g)) {
      BaseTransientBottomBar.f.post(new i(this));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */