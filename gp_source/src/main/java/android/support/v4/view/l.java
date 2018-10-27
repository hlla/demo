package android.support.v4.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class l
{
  private static boolean a = false;
  private static Method b = null;
  private static boolean c = false;
  private static Field d = null;
  
  private static DialogInterface.OnKeyListener a(Dialog paramDialog)
  {
    if (!c) {}
    try
    {
      Field localField = Dialog.class.getDeclaredField("mOnKeyListener");
      d = localField;
      localField.setAccessible(true);
      c = true;
      if (d != null) {
        try
        {
          paramDialog = (DialogInterface.OnKeyListener)d.get(paramDialog);
          return paramDialog;
        }
        catch (IllegalAccessException paramDialog) {}
      }
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
  
  private static boolean a(ActionBar paramActionBar, KeyEvent paramKeyEvent)
  {
    if (!a) {}
    try
    {
      b = paramActionBar.getClass().getMethod("onMenuKeyEvent", new Class[] { KeyEvent.class });
      a = true;
      if (b != null) {}
      try
      {
        boolean bool = ((Boolean)b.invoke(paramActionBar, new Object[] { paramKeyEvent })).booleanValue();
        return bool;
      }
      catch (InvocationTargetException paramActionBar)
      {
        return false;
      }
      catch (IllegalAccessException paramActionBar)
      {
        for (;;) {}
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
  }
  
  public static boolean a(m paramm, View paramView, Window.Callback paramCallback, KeyEvent paramKeyEvent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramm != null)
    {
      if (Build.VERSION.SDK_INT >= 28) {
        return paramm.a(paramKeyEvent);
      }
      if ((paramCallback instanceof Activity))
      {
        paramView = (Activity)paramCallback;
        paramView.onUserInteraction();
        paramm = paramView.getWindow();
        if (paramm.hasFeature(8))
        {
          paramCallback = paramView.getActionBar();
          if (paramKeyEvent.getKeyCode() == 82) {
            break label115;
          }
        }
        label115:
        while ((paramCallback == null) || (!a(paramCallback, paramKeyEvent)))
        {
          if (!paramm.superDispatchKeyEvent(paramKeyEvent))
          {
            paramCallback = paramm.getDecorView();
            if (!ac.b(paramCallback, paramKeyEvent))
            {
              paramm = (m)localObject1;
              if (paramCallback != null) {
                paramm = paramCallback.getKeyDispatcherState();
              }
              return paramKeyEvent.dispatch(paramView, paramm, paramView);
            }
            return true;
          }
          return true;
        }
        return true;
      }
      if ((paramCallback instanceof Dialog))
      {
        paramView = (Dialog)paramCallback;
        paramm = a(paramView);
        if ((paramm == null) || (!paramm.onKey(paramView, paramKeyEvent.getKeyCode(), paramKeyEvent)))
        {
          paramm = paramView.getWindow();
          if (!paramm.superDispatchKeyEvent(paramKeyEvent))
          {
            paramCallback = paramm.getDecorView();
            if (!ac.b(paramCallback, paramKeyEvent))
            {
              paramm = (m)localObject2;
              if (paramCallback != null) {
                paramm = paramCallback.getKeyDispatcherState();
              }
              return paramKeyEvent.dispatch(paramView, paramm, paramView);
            }
            return true;
          }
          return true;
        }
        return true;
      }
      if (paramView == null) {}
      for (;;)
      {
        if (paramm.a(paramKeyEvent)) {}
        do
        {
          return true;
          return false;
        } while (ac.b(paramView, paramKeyEvent));
      }
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */