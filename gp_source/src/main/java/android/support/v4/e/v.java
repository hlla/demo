package android.support.v4.e;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

final class v
  implements Handler.Callback
{
  v(u paramu) {}
  
  public final boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return true;
    case 1: 
      u localu1 = this.a;
      ((Runnable)???.obj).run();
      synchronized (localu1.c)
      {
        localu1.b.removeMessages(0);
        Handler localHandler = localu1.b;
        localHandler.sendMessageDelayed(localHandler.obtainMessage(0), localu1.a);
        return true;
      }
    }
    u localu2 = this.a;
    synchronized (localu2.c)
    {
      if (!localu2.b.hasMessages(1))
      {
        localu2.d.quit();
        localu2.d = null;
        localu2.b = null;
        return true;
      }
    }
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/e/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */