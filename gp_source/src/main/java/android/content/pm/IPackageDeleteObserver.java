package android.content.pm;

import android.os.IInterface;

public abstract interface IPackageDeleteObserver
  extends IInterface
{
  public abstract void packageDeleted(String paramString, int paramInt);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/content/pm/IPackageDeleteObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */