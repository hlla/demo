package android.support.v4.widget;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;

final class m
  extends ContentObserver
{
  m(l paraml)
  {
    super(new Handler());
  }
  
  public final boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    l locall = this.a;
    if (locall.a)
    {
      Cursor localCursor = locall.c;
      if ((localCursor != null) && (!localCursor.isClosed())) {
        locall.d = locall.c.requery();
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */