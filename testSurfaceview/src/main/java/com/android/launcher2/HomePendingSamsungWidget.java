package com.android.launcher2;

import android.content.ComponentName;

class HomePendingSamsungWidget
  extends HomePendingItem
{
  SamsungWidgetProviderInfo mInfo;
  
  public HomePendingSamsungWidget(SamsungWidgetProviderInfo paramSamsungWidgetProviderInfo)
  {
    super(BaseItem.Type.HOME_SAMSUNG_WIDGET);
    this.mInfo = paramSamsungWidgetProviderInfo;
  }
  
  public ComponentName getComponentName()
  {
    return this.mInfo.getComponentName();
  }
  
  public String getPackageName()
  {
    return this.mInfo.mPackageName;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomePendingSamsungWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */