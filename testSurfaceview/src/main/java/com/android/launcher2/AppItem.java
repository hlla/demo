package com.android.launcher2;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppItem
  extends BaseItem
{
  private static final boolean DEBUGGABLE = ;
  public int mCell = -1;
  public final ComponentName mComponentName;
  public long mCreateTime = -1L;
  protected AppFolderItem mFolder;
  public boolean mHidden = false;
  private int mSavedCell;
  private boolean mSavedDirty;
  private AppFolderItem mSavedFolder;
  private boolean mSavedHidden;
  private int mSavedScreen;
  private boolean mSavedSecret;
  public int[] mScreenLocation = new int[2];
  public final boolean mSystemApp;
  public boolean mUnavailable = false;
  
  public AppItem(ComponentName paramComponentName, boolean paramBoolean)
  {
    super(BaseItem.Type.MENU_APP);
    this.mComponentName = paramComponentName;
    this.mSystemApp = paramBoolean;
  }
  
  protected AppItem(BaseItem.Type paramType, ComponentName paramComponentName, boolean paramBoolean)
  {
    super(paramType);
    this.mComponentName = paramComponentName;
    this.mSystemApp = paramBoolean;
  }
  
  public static void dumpApplicationInfoList(String paramString1, String paramString2, ArrayList<AppItem> paramArrayList)
  {
    if (DEBUGGABLE) {
      Log.d(paramString1, paramString2 + " size=" + paramArrayList.size());
    }
    paramString2 = paramArrayList.iterator();
    while (paramString2.hasNext())
    {
      paramArrayList = (AppItem)paramString2.next();
      if (DEBUGGABLE) {
        Log.d(paramString1, "   title=\"" + paramArrayList.mTitle + "\" iconBitmap=" + paramArrayList.mIconBitmap + " createTime=" + paramArrayList.mCreateTime);
      }
    }
  }
  
  private void freeEditResources()
  {
    this.mSavedFolder = null;
  }
  
  public void destroy()
  {
    if (this.mFolder != null) {
      this.mFolder.childDestroyed(this);
    }
    if ((this.mSavedFolder != null) && (this.mSavedFolder != this.mFolder)) {
      this.mSavedFolder.childDestroyed(this);
    }
    this.mFolder = null;
    this.mTitle = null;
    this.mIconBitmap = null;
    this.mIconShadowBitmap = null;
    this.mSavedFolder = null;
  }
  
  public void editBegin()
  {
    this.mSavedFolder = this.mFolder;
    this.mSavedScreen = this.mScreen;
    this.mSavedCell = this.mCell;
    this.mSavedDirty = this.mDirty;
    this.mSavedHidden = this.mHidden;
    this.mSavedSecret = this.mSecretItem;
  }
  
  public void editCommit()
  {
    if (editIsDirty(false)) {
      this.mDirty = true;
    }
    freeEditResources();
  }
  
  public boolean editIsDirty(boolean paramBoolean)
  {
    return (this.mSavedFolder != this.mFolder) || ((!paramBoolean) && ((this.mSavedScreen != this.mScreen) || (this.mSavedCell != this.mCell) || (this.mSavedHidden != this.mHidden) || (this.mSavedSecret != this.mSecretItem)));
  }
  
  public void editParentDestroyed()
  {
    this.mFolder = null;
    this.mScreen = -1;
    this.mCell = -1;
  }
  
  public void editRevert()
  {
    this.mFolder = this.mSavedFolder;
    this.mScreen = this.mSavedScreen;
    this.mCell = this.mSavedCell;
    this.mDirty = this.mSavedDirty;
    this.mHidden = this.mSavedHidden;
    this.mSecretItem = this.mSavedSecret;
    freeEditResources();
  }
  
  public void editRevertCell()
  {
    this.mCell = this.mSavedCell;
  }
  
  public ComponentName getComponentName()
  {
    return this.mComponentName;
  }
  
  public Intent getLaunchIntent()
  {
    Intent localIntent = null;
    if (this.mComponentName != null)
    {
      localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setComponent(this.mComponentName);
      localIntent.setFlags(270532608);
    }
    return localIntent;
  }
  
  public String getPackageName()
  {
    String str = null;
    if (this.mComponentName != null) {
      str = this.mComponentName.getPackageName();
    }
    return str;
  }
  
  public int getPosition()
  {
    if ((this.mFolder != null) && (MenuAppModel.INSTANCE.getCurrentComparator() == MenuAppModel.MENU_ALPHA_NORMALIZER)) {
      return this.mFolder.getAllItems().indexOf(this);
    }
    if (this.mFolder == null) {
      return this.mCell;
    }
    return this.mScreen;
  }
  
  public int getSavedCell()
  {
    return this.mSavedCell;
  }
  
  public int getSavedScreen()
  {
    return this.mSavedScreen;
  }
  
  public void hide()
  {
    removeFromFolder();
    this.mScreen = -1;
    this.mCell = -1;
    this.mHidden = true;
  }
  
  public HomeShortcutItem makeHomeItem()
  {
    HomeShortcutItem localHomeShortcutItem = new HomeShortcutItem(BaseItem.Type.HOME_APPLICATION);
    localHomeShortcutItem.customIcon = false;
    localHomeShortcutItem.mTitle = this.mTitle;
    localHomeShortcutItem.intent = getLaunchIntent();
    localHomeShortcutItem.mIconShadowBitmap = this.mIconShadowBitmap;
    localHomeShortcutItem.setIcon(this.mIconBitmap);
    localHomeShortcutItem.mColor = this.mColor;
    localHomeShortcutItem.mSecretItem = this.mSecretItem;
    localHomeShortcutItem.mBadgeCount = this.mBadgeCount;
    return localHomeShortcutItem;
  }
  
  public void moveSecretBox()
  {
    removeFromFolder();
    this.mScreen = -1;
    this.mCell = -1;
    this.mSecretItem = true;
  }
  
  public void parentDestroyed(AppFolderItem paramAppFolderItem)
  {
    if (paramAppFolderItem == this.mFolder)
    {
      this.mFolder = null;
      this.mScreen = -1;
      this.mCell = -1;
    }
    if (paramAppFolderItem == this.mSavedFolder)
    {
      this.mSavedFolder = null;
      this.mSavedScreen = -1;
      this.mSavedCell = -1;
    }
  }
  
  public void removeFromFolder()
  {
    AppFolderItem localAppFolderItem = this.mFolder;
    if (localAppFolderItem != null)
    {
      localAppFolderItem.removeItem(this);
      this.mScreen = localAppFolderItem.mScreen;
      this.mCell = localAppFolderItem.mCell;
    }
  }
  
  public void removeSecretBox()
  {
    removeFromFolder();
    this.mScreen = -1;
    this.mCell = -1;
    this.mSecretItem = false;
  }
  
  public void setPosition(int paramInt)
  {
    if (this.mFolder != null)
    {
      this.mScreen = paramInt;
      return;
    }
    this.mCell = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Item(id=").append(this.mId).append(" folderId=");
    if (this.mFolder != null) {}
    for (long l = this.mFolder.mId;; l = -1L) {
      return l + " screen=" + this.mScreen + " cell=" + this.mCell + " title=" + this.mTitle + " componentName=" + this.mComponentName + " unavailable=" + this.mUnavailable + ")";
    }
  }
  
  public void unhide()
  {
    this.mHidden = false;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AppItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */