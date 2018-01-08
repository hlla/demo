package com.android.launcher2;

import android.content.ComponentName;

public class SamsungWidgetProviderInfo
{
  public final String mClassName;
  public String mDescription;
  public int mHorizontalHeight = 0;
  public int mHorizontalWidth = 0;
  public final String mPackageName;
  public final String mThemeName;
  public int mVerticalHeight = 0;
  public int mVerticalWidth = 0;
  public int mWidgetPreview;
  public String mWidgetTitle;
  
  public SamsungWidgetProviderInfo(String paramString1, String paramString2, String paramString3)
  {
    this.mPackageName = paramString1;
    this.mClassName = paramString2;
    this.mThemeName = paramString3;
  }
  
  public ComponentName getComponentName()
  {
    return new ComponentName(this.mPackageName, this.mClassName);
  }
  
  public int getHeight(int paramInt)
  {
    if (paramInt == 2) {
      return this.mHorizontalHeight;
    }
    return this.mVerticalHeight;
  }
  
  public int getWidth(int paramInt)
  {
    if (paramInt == 2) {
      return this.mHorizontalWidth;
    }
    return this.mVerticalWidth;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/SamsungWidgetProviderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */