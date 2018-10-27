package android.support.c;

import android.content.ComponentName;
import android.net.Uri;
import android.os.RemoteException;

public final class m
{
  public final n a;
  public final ComponentName b;
  private final p c;
  
  m(p paramp, n paramn, ComponentName paramComponentName)
  {
    new Object();
    this.c = paramp;
    this.a = paramn;
    this.b = paramComponentName;
  }
  
  public final boolean a(Uri paramUri)
  {
    try
    {
      boolean bool = this.c.a(this.a, paramUri, null, null);
      return bool;
    }
    catch (RemoteException paramUri) {}
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */