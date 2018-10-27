package android.support.v7.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class t
  extends Handler
{
  private WeakReference a;
  
  public t(DialogInterface paramDialogInterface)
  {
    this.a = new WeakReference(paramDialogInterface);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 0: 
    default: 
      return;
    case -3: 
    case -2: 
    case -1: 
      ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.a.get(), paramMessage.what);
      return;
    }
    ((DialogInterface)paramMessage.obj).dismiss();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */