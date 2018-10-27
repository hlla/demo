package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class l
  extends Handler
{
  l(k paramk, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    this.a.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */