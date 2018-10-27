package android.support.v4.content;

import android.database.ContentObserver;
import android.os.Handler;

public final class i
  extends ContentObserver
{
  public i(h paramh)
  {
    super(new Handler());
  }
  
  public final boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    this.a.m();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */