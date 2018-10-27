package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;

public class SearchView$SearchAutoComplete
  extends aa
{
  public boolean a;
  public SearchView b;
  private final Runnable c = new gu(this);
  private int d = getThreshold();
  
  public SearchView$SearchAutoComplete(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968644);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  final void a(boolean paramBoolean)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (!paramBoolean)
    {
      this.a = false;
      removeCallbacks(this.c);
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      return;
    }
    if (localInputMethodManager.isActive(this))
    {
      this.a = false;
      removeCallbacks(this.c);
      localInputMethodManager.showSoftInput(this, 0);
      return;
    }
    this.a = true;
  }
  
  public boolean enoughToFilter()
  {
    return (this.d <= 0) || (super.enoughToFilter());
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
    if (this.a)
    {
      removeCallbacks(this.c);
      post(this.c);
    }
    return paramEditorInfo;
  }
  
  protected void onFinishInflate()
  {
    int j = 160;
    super.onFinishInflate();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    Configuration localConfiguration = getResources().getConfiguration();
    int k = localConfiguration.screenWidthDp;
    int m = localConfiguration.screenHeightDp;
    int i;
    if (k < 960) {
      if (k < 600)
      {
        i = j;
        if (k >= 640)
        {
          if (m >= 480) {
            break label86;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      setMinWidth((int)TypedValue.applyDimension(1, i, localDisplayMetrics));
      return;
      label86:
      i = 192;
      continue;
      i = 192;
      continue;
      if ((m < 720) || (localConfiguration.orientation != 2)) {
        break;
      }
      i = 256;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.b.onTextFocusChanged();
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.handleUpEvent(paramKeyEvent);
        }
        if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
        {
          this.b.clearFocus();
          a(false);
          return true;
        }
      }
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.b.hasFocus()) && (getVisibility() == 0))
    {
      this.a = true;
      if (SearchView.isLandscapeMode(getContext())) {
        SearchView.HIDDEN_METHOD_INVOKER.a(this);
      }
    }
  }
  
  public void performCompletion() {}
  
  protected void replaceText(CharSequence paramCharSequence) {}
  
  public void setThreshold(int paramInt)
  {
    super.setThreshold(paramInt);
    this.d = paramInt;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/SearchView$SearchAutoComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */