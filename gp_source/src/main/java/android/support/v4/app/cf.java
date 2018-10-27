package android.support.v4.app;

import android.app.Notification.BigTextStyle;

public final class cf
  extends ci
{
  private CharSequence c;
  
  public final cf a(CharSequence paramCharSequence)
  {
    this.a = cg.d(paramCharSequence);
    return this;
  }
  
  public final void a(cb paramcb)
  {
    new Notification.BigTextStyle(paramcb.a()).setBigContentTitle(this.a).bigText(this.c);
  }
  
  public final cf b(CharSequence paramCharSequence)
  {
    this.c = cg.d(paramCharSequence);
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */