package android.support.v7.app;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

final class k
  implements View.OnClickListener
{
  k(AlertController paramAlertController) {}
  
  public final void onClick(View paramView)
  {
    Object localObject2 = null;
    AlertController localAlertController = this.a;
    Object localObject1;
    if (paramView == localAlertController.m)
    {
      localObject1 = localAlertController.o;
      if (localObject1 != null) {
        localObject1 = Message.obtain((Message)localObject1);
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((Message)localObject1).sendToTarget();
      }
      paramView = this.a;
      paramView.u.obtainMessage(1, paramView.t).sendToTarget();
      return;
      if (paramView == localAlertController.e)
      {
        localObject1 = localAlertController.g;
        if (localObject1 != null)
        {
          localObject1 = Message.obtain((Message)localObject1);
          continue;
        }
      }
      localObject1 = localObject2;
      if (paramView == localAlertController.i)
      {
        paramView = localAlertController.k;
        localObject1 = localObject2;
        if (paramView != null) {
          localObject1 = Message.obtain(paramView);
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */