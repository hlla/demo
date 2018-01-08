package com.android.launcher2;

import android.view.View;

public abstract interface DragOrigin
{
  public abstract View getViewForItem(BaseItem paramBaseItem);
  
  public abstract void hide(BaseItem paramBaseItem);
  
  public abstract void onFailedDrop(BaseItem paramBaseItem);
  
  public abstract boolean removeItem(BaseItem paramBaseItem);
  
  public abstract void show(BaseItem paramBaseItem);
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DragOrigin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */