package com.android.launcher2;

import android.view.View;

abstract interface Page
{
  public abstract void disableHardwareLayers();
  
  public abstract void enableHardwareLayers();
  
  public abstract View getChildOnPageAt(int paramInt);
  
  public abstract int getPageItemCount();
  
  public abstract int getPageType();
  
  public abstract int indexOfChildOnPage(View paramView);
  
  public abstract void removeAllViewsOnPage();
  
  public abstract void removeViewOnPageAt(int paramInt);
  
  public abstract void setPageType(int paramInt);
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/Page.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */