package com.android.launcher2;

import android.graphics.Bitmap;
import android.view.View;

public abstract interface CellLayoutContainer
{
  public abstract Bitmap getDragOutline(View paramView);
  
  public abstract void onDragEndedWithItem(BaseItem paramBaseItem);
  
  public abstract void onDragStartedWithItem(View paramView);
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CellLayoutContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */