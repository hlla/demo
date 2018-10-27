package android.support.design.snackbar;

import android.os.Handler;

final class f
  implements x
{
  f(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public final void a()
  {
    BaseTransientBottomBar.f.sendMessage(BaseTransientBottomBar.f.obtainMessage(0, this.a));
  }
  
  public final void a(int paramInt)
  {
    BaseTransientBottomBar.f.sendMessage(BaseTransientBottomBar.f.obtainMessage(1, paramInt, 0, this.a));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */