package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.app.v;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;

final class s
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, ag
{
  public v a;
  public p b;
  public m c;
  
  public s(p paramp)
  {
    this.b = paramp;
  }
  
  public final void a(p paramp, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      paramp = this.a;
      if (paramp != null) {
        paramp.dismiss();
      }
      do
      {
        return;
      } while (paramp != this.b);
    }
  }
  
  public final boolean a(p paramp)
  {
    return false;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.a((t)this.c.b().getItem(paramInt), null, 0);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    this.c.a(this.b, true);
  }
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {}
    for (;;)
    {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = this.a.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      do
      {
        Object localObject;
        do
        {
          do
          {
            do
            {
              do
              {
                return this.b.performShortcut(paramInt, paramKeyEvent, 0);
              } while ((paramKeyEvent.getAction() != 1) || (paramKeyEvent.isCanceled()));
              localObject = this.a.getWindow();
            } while (localObject == null);
            localObject = ((Window)localObject).getDecorView();
          } while (localObject == null);
          localObject = ((View)localObject).getKeyDispatcherState();
        } while ((localObject == null) || (!((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)));
        this.b.a(true);
        paramDialogInterface.dismiss();
        return true;
      } while (paramInt != 4);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */