package com.android.launcher2;

import android.content.Context;

public abstract interface FolderItem
{
  public abstract void addItem(BaseItem paramBaseItem);
  
  public abstract void addItemAt(BaseItem paramBaseItem, int paramInt);
  
  public abstract void addListener(HomeFolderItem.FolderListener paramFolderListener);
  
  public abstract boolean contains(BaseItem paramBaseItem);
  
  public abstract int getFolderColor();
  
  public abstract long getId();
  
  public abstract BaseItem getItemAt(int paramInt);
  
  public abstract int getItemCount();
  
  public abstract String getTitle();
  
  public abstract boolean isEnabled();
  
  public abstract boolean isHiddenAddButton();
  
  public abstract boolean isOpened();
  
  public abstract boolean isRequiredToRedraw();
  
  public abstract boolean isValidItem(BaseItem paramBaseItem);
  
  public abstract void removeItem(BaseItem paramBaseItem);
  
  public abstract void removeListener(HomeFolderItem.FolderListener paramFolderListener);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setFolderColor(int paramInt);
  
  public abstract void setHiddenAddButton(boolean paramBoolean);
  
  public abstract void setOpened(boolean paramBoolean);
  
  public abstract void setTitle(Context paramContext, String paramString);
  
  public abstract void setToRedrawIcons(boolean paramBoolean);
  
  public abstract void sort();
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/FolderItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */