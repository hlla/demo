package com.android.launcher2;

import android.graphics.Bitmap;

abstract interface AvailableWidget
{
  public abstract boolean canUninstall();
  
  public abstract void cleanupCache();
  
  public abstract HomePendingItem createHomePendingItem();
  
  public abstract void dump(String paramString);
  
  public abstract void getCellSpan(int[] paramArrayOfInt);
  
  public abstract String getLabel();
  
  public abstract Bitmap getPreview(int paramInt1, int paramInt2);
  
  public abstract String getWidgetPackageName();
  
  public abstract boolean isSecret();
  
  public abstract void setSecret(boolean paramBoolean);
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AvailableWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */