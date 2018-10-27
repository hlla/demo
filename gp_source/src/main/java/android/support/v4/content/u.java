package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.atomic.AtomicBoolean;

final class u
  extends Handler
{
  u()
  {
    super(Looper.getMainLooper());
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject = (t)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2: 
      o.b();
      return;
    }
    paramMessage = ((t)localObject).b;
    localObject = localObject.a[0];
    if (paramMessage.c.get()) {
      paramMessage.b(localObject);
    }
    for (;;)
    {
      paramMessage.e = v.a;
      return;
      paramMessage.a(localObject);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */