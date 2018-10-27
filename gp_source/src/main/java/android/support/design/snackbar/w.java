package android.support.design.snackbar;

import android.os.Handler.Callback;
import android.os.Message;

final class w
  implements Handler.Callback
{
  w(v paramv) {}
  
  public final boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return false;
    }
    v localv = this.a;
    y localy = (y)???.obj;
    synchronized (localv.c)
    {
      if (localv.a == localy) {
        localv.a(localy, 2);
      }
      while (localv.d != localy) {
        return true;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/snackbar/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */