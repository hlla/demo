package com.android.launcher2;

import android.view.View;

public abstract interface ItemViewBuilder
{
  public abstract View buildView(BaseItem paramBaseItem, CellLayout paramCellLayout);
  
  public abstract void onViewAdded(View paramView, BaseItem paramBaseItem, CellLayout paramCellLayout);
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/ItemViewBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */