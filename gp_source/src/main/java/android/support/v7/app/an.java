package android.support.v7.app;

import android.os.Build.VERSION;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.view.h;
import android.support.v7.view.menu.p;
import android.support.v7.view.n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;
import java.util.List;

final class an
  extends n
{
  an(aa paramaa, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  private final ActionMode a(ActionMode.Callback paramCallback)
  {
    paramCallback = new h(this.a.f, paramCallback);
    Object localObject1 = this.a;
    Object localObject2 = ((aa)localObject1).b;
    if (localObject2 != null) {
      ((b)localObject2).c();
    }
    localObject2 = new al((aa)localObject1, paramCallback);
    Object localObject3 = ((z)localObject1).a();
    if (localObject3 != null)
    {
      ((aa)localObject1).b = ((a)localObject3).a((c)localObject2);
      if (((aa)localObject1).b != null)
      {
        localObject3 = ((aa)localObject1).e;
        if (localObject3 != null) {
          ((y)localObject3).K_();
        }
      }
    }
    if (((aa)localObject1).b == null) {
      ((aa)localObject1).b = ((aa)localObject1).a((c)localObject2);
    }
    localObject1 = ((aa)localObject1).b;
    if (localObject1 != null) {
      return paramCallback.b((b)localObject1);
    }
    return null;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this.a.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  public final boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    aa localaa;
    Object localObject;
    if (!super.dispatchKeyShortcutEvent(paramKeyEvent))
    {
      localaa = this.a;
      int i = paramKeyEvent.getKeyCode();
      localObject = localaa.a();
      if ((localObject == null) || (!((a)localObject).a(i, paramKeyEvent)))
      {
        localObject = localaa.n;
        if ((localObject == null) || (!localaa.a((ar)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          break label89;
        }
        paramKeyEvent = localaa.n;
        if (paramKeyEvent != null) {
          paramKeyEvent.g = true;
        }
      }
    }
    label89:
    do
    {
      bool = true;
      do
      {
        return bool;
      } while (localaa.n != null);
      localObject = localaa.d(0);
      localaa.a((ar)localObject, paramKeyEvent);
      bool = localaa.a((ar)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      ((ar)localObject).i = false;
    } while (bool);
    return false;
  }
  
  public final void onContentChanged() {}
  
  public final boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if ((paramInt != 0) || ((paramMenu instanceof p))) {
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    return false;
  }
  
  public final boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    super.onMenuOpened(paramInt, paramMenu);
    paramMenu = this.a;
    if (paramInt == 108)
    {
      paramMenu = paramMenu.a();
      if (paramMenu != null) {
        paramMenu.d(true);
      }
    }
    return true;
  }
  
  public final void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
    paramMenu = this.a;
    if (paramInt == 108)
    {
      paramMenu = paramMenu.a();
      if (paramMenu != null) {
        paramMenu.d(false);
      }
    }
    ar localar;
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localar = paramMenu.d(paramInt);
    } while (!localar.h);
    paramMenu.a(localar, false);
  }
  
  public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramMenu instanceof p)) {}
    for (p localp = (p)paramMenu;; localp = null)
    {
      if (paramInt != 0) {}
      while (localp != null)
      {
        if (localp == null) {}
        for (;;)
        {
          boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
          if (localp != null) {
            localp.k = false;
          }
          return bool;
          localp.k = true;
        }
      }
      return false;
    }
  }
  
  public final void onProvideKeyboardShortcuts(List paramList, Menu paramMenu, int paramInt)
  {
    Object localObject = this.a.d(0);
    if (localObject != null)
    {
      localObject = ((ar)localObject).l;
      if (localObject != null)
      {
        super.onProvideKeyboardShortcuts(paramList, (Menu)localObject, paramInt);
        return;
      }
    }
    super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      if (this.a.i) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    return null;
  }
  
  public final ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    if (this.a.i) {}
    switch (paramInt)
    {
    default: 
      return super.onWindowStartingActionMode(paramCallback, paramInt);
    }
    return a(paramCallback);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */