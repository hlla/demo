package com.android.launcher2;

import android.content.ComponentName;

class HomePendingItem
  extends HomeItem
{
  ComponentName componentName;
  public boolean mSystemApp = true;
  
  HomePendingItem()
  {
    super(BaseItem.Type.HOME_APPLICATION);
  }
  
  protected HomePendingItem(BaseItem.Type paramType)
  {
    super(paramType);
  }
  
  public ComponentName getComponentName()
  {
    return this.componentName;
  }
  
  public String getPackageName()
  {
    String str = null;
    if (this.componentName != null) {
      str = this.componentName.getPackageName();
    }
    return str;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomePendingItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */