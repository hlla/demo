package android.support.v4.view;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

final class i
  extends Handler
{
  i(h paramh) {}
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown message ");
      ((StringBuilder)localObject).append(paramMessage);
      throw new RuntimeException(((StringBuilder)localObject).toString());
    case 1: 
      paramMessage = this.a;
      paramMessage.f.onShowPress(paramMessage.a);
    case 3: 
      do
      {
        return;
        paramMessage = this.a;
        localObject = paramMessage.c;
      } while (localObject == null);
      if (!paramMessage.g)
      {
        ((GestureDetector.OnDoubleTapListener)localObject).onSingleTapConfirmed(paramMessage.a);
        return;
      }
      paramMessage.b = true;
      return;
    }
    paramMessage = this.a;
    paramMessage.d.removeMessages(3);
    paramMessage.b = false;
    paramMessage.e = true;
    paramMessage.f.onLongPress(paramMessage.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */