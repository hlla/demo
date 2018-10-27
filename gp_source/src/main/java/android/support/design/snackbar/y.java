package android.support.design.snackbar;

import java.lang.ref.WeakReference;

final class y
{
  public final WeakReference a;
  public int b;
  public boolean c;
  
  y(int paramInt, x paramx)
  {
    this.a = new WeakReference(paramx);
    this.b = paramInt;
  }
  
  final boolean a(x paramx)
  {
    return (paramx != null) && (this.a.get() == paramx);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */