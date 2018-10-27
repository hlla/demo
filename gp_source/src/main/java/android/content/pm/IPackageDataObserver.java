package android.content.pm;

import android.os.IInterface;

public abstract interface IPackageDataObserver
  extends IInterface
{
  public abstract void onRemoveCompleted(String paramString, boolean paramBoolean);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/content/pm/IPackageDataObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */