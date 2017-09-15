package android.support.v7.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.support.v7.view.menu.f;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class e
  extends d
{
  final Window Fe;
  boolean GA;
  boolean GB;
  boolean GC;
  boolean GD;
  final Window.Callback Gu;
  final Window.Callback Gv;
  final c Gw;
  ActionBar Gx;
  boolean Gy;
  boolean Gz;
  MenuInflater iP;
  final Context mContext;
  CharSequence uI;
  
  e(Context paramContext, Window paramWindow, c paramc)
  {
    this.mContext = paramContext;
    this.Fe = paramWindow;
    this.Gw = paramc;
    this.Gu = this.Fe.getCallback();
    if ((this.Gu instanceof a)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.Gv = a(this.Gu);
    this.Fe.setCallback(this.Gv);
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  abstract void ar(int paramInt);
  
  abstract boolean as(int paramInt);
  
  public final ActionBar cP()
  {
    cU();
    return this.Gx;
  }
  
  public boolean cS()
  {
    return false;
  }
  
  abstract void cU();
  
  final Context cV()
  {
    Context localContext = null;
    Object localObject = cP();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).getThemedContext();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = this.mContext;
    }
    return (Context)localObject;
  }
  
  abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  abstract void f(CharSequence paramCharSequence);
  
  public final MenuInflater getMenuInflater()
  {
    if (this.iP == null)
    {
      cU();
      if (this.Gx == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.Gx.getThemedContext();; localContext = this.mContext)
    {
      this.iP = new g(localContext);
      return this.iP;
    }
  }
  
  public void onDestroy()
  {
    this.GD = true;
  }
  
  abstract boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent);
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.uI = paramCharSequence;
    f(paramCharSequence);
  }
  
  class a
    extends i
  {
    a(Window.Callback paramCallback)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (e.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (e.this.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof f))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      e.this.as(paramInt);
      return true;
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      e.this.ar(paramInt);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      f localf;
      boolean bool1;
      if ((paramMenu instanceof f))
      {
        localf = (f)paramMenu;
        if ((paramInt != 0) || (localf != null)) {
          break label34;
        }
        bool1 = false;
      }
      label34:
      boolean bool2;
      do
      {
        return bool1;
        localf = null;
        break;
        if (localf != null) {
          localf.QJ = true;
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localf == null);
      localf.QJ = false;
      return bool2;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */