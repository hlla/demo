package com.android.launcher2.popup;

import android.graphics.drawable.Drawable;

public abstract interface MenuView
{
  public abstract int getWindowAnimations();
  
  public abstract void initialize(MenuBuilder paramMenuBuilder);
  
  public static abstract interface ItemView
  {
    public abstract MenuItemImpl getItemData();
    
    public abstract void initialize(MenuItemImpl paramMenuItemImpl, int paramInt);
    
    public abstract boolean prefersCondensedTitle();
    
    public abstract void setCheckable(boolean paramBoolean);
    
    public abstract void setChecked(boolean paramBoolean);
    
    public abstract void setEnabled(boolean paramBoolean);
    
    public abstract void setIcon(Drawable paramDrawable);
    
    public abstract void setShortcut(boolean paramBoolean, char paramChar);
    
    public abstract void setTitle(CharSequence paramCharSequence);
    
    public abstract boolean showsIcon();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/popup/MenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */