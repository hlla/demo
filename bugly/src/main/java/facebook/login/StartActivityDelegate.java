package com.facebook.login;

import android.app.Activity;
import android.content.Intent;

abstract interface StartActivityDelegate
{
  public abstract void startActivityForResult(Intent paramIntent, int paramInt);
  
  public abstract Activity getActivityContext();
}


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/login/StartActivityDelegate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */