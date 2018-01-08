package com.android.launcher2;

import android.view.View;
import android.view.ViewParent;

public abstract interface DragReceivable
{
  public abstract boolean addItem(BaseItem paramBaseItem);
  
  public abstract View createViewForItem(BaseItem paramBaseItem);
  
  public abstract long getContainerType();
  
  public abstract ViewParent getParent();
  
  public abstract void setItemLocation(BaseItem paramBaseItem, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
  
  public abstract void show(BaseItem paramBaseItem);
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DragReceivable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */