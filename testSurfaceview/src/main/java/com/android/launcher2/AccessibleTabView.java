package com.android.launcher2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;

public class AccessibleTabView
  extends TextView
{
  public AccessibleTabView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AccessibleTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AccessibleTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return (FocusHelper.handleTabKeyEvent(this, paramInt, paramKeyEvent)) || (super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return (FocusHelper.handleTabKeyEvent(this, paramInt, paramKeyEvent)) || (super.onKeyUp(paramInt, paramKeyEvent));
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AccessibleTabView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */