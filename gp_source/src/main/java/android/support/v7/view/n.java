package android.support.v7.view;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class n
  implements Window.Callback
{
  private final Window.Callback a;
  
  public n(Window.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("Window callback may not be null");
    }
    this.a = paramCallback;
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.a.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return this.a.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchTrackballEvent(paramMotionEvent);
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    this.a.onActionModeFinished(paramActionMode);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    this.a.onActionModeStarted(paramActionMode);
  }
  
  public void onAttachedToWindow()
  {
    this.a.onAttachedToWindow();
  }
  
  public void onContentChanged()
  {
    this.a.onContentChanged();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return this.a.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return this.a.onCreatePanelView(paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    this.a.onDetachedFromWindow();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return this.a.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return this.a.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    this.a.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean)
  {
    this.a.onPointerCaptureChanged(paramBoolean);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.a.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onProvideKeyboardShortcuts(List paramList, Menu paramMenu, int paramInt)
  {
    this.a.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  public boolean onSearchRequested()
  {
    return this.a.onSearchRequested();
  }
  
  public boolean onSearchRequested(SearchEvent paramSearchEvent)
  {
    return this.a.onSearchRequested(paramSearchEvent);
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    this.a.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.a.onWindowFocusChanged(paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return this.a.onWindowStartingActionMode(paramCallback);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    return this.a.onWindowStartingActionMode(paramCallback, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */