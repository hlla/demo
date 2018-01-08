package com.android.launcher2.guide;

import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.view.KeyEvent;

public abstract interface GuideFragmentCallback
{
  public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract DialogInterface.OnDismissListener getOnDismissListener();
  
  public abstract DialogInterface.OnKeyListener getOnKeyListener();
  
  public abstract DialogInterface.OnShowListener getOnShowListener();
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/GuideFragmentCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */