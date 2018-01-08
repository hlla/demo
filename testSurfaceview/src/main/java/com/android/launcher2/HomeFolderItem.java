package com.android.launcher2;

import android.content.ContentValues;
import android.content.Context;
import com.sec.dtl.launcher.Talk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class HomeFolderItem
  extends HomeItem
  implements FolderItem
{
  public static final Comparator<BaseItem> IN_FOLDER_POSITION_COMPARATOR = new Comparator()
  {
    public final int compare(BaseItem paramAnonymousBaseItem1, BaseItem paramAnonymousBaseItem2)
    {
      return paramAnonymousBaseItem1.mScreen - paramAnonymousBaseItem2.mScreen;
    }
  };
  ArrayList<HomeItem> contents = new ArrayList();
  ArrayList<FolderListener> listeners = new ArrayList();
  private boolean mEnabled;
  private boolean mHiddenAddButton = false;
  private boolean mOpened;
  private boolean mRedrawIcons;
  
  HomeFolderItem()
  {
    super(BaseItem.Type.HOME_FOLDER);
  }
  
  private void adjustPositions(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= paramInt2)
    {
      Iterator localIterator = this.contents.iterator();
      while (localIterator.hasNext())
      {
        HomeItem localHomeItem = (HomeItem)localIterator.next();
        if ((localHomeItem.mScreen >= paramInt1) && (localHomeItem.mScreen <= paramInt2)) {
          localHomeItem.mScreen += paramInt3;
        }
      }
    }
  }
  
  static HomeFolderItem createFromAppFolderItem(Context paramContext, AppFolderItem paramAppFolderItem, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    HomeFolderItem localHomeFolderItem = new HomeFolderItem();
    localHomeFolderItem.mSecretItem = paramAppFolderItem.mSecretItem;
    localHomeFolderItem.mTitle = paramAppFolderItem.mTitle;
    localHomeFolderItem.mColor = paramAppFolderItem.mColor;
    LauncherModel.addItemToDatabase(paramContext, localHomeFolderItem, paramLong, paramInt1, paramInt2, paramInt3, false);
    LauncherApplication localLauncherApplication = (LauncherApplication)paramContext.getApplicationContext();
    paramInt2 = 0;
    paramInt3 = paramAppFolderItem.getItemCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt3)
    {
      AppItem localAppItem = (AppItem)paramAppFolderItem.getItemAt(paramInt1);
      HomeShortcutItem localHomeShortcutItem;
      if (LauncherApplication.isMenuIconSizeChanged())
      {
        PkgResCache.TitleIconInfo localTitleIconInfo = new PkgResCache.TitleIconInfo();
        localTitleIconInfo.mIconResId = localAppItem.mIconResId;
        ((LauncherApplication)paramContext.getApplicationContext()).getPkgResCache().refreshTitleAndIcon(localAppItem.mComponentName, localTitleIconInfo);
        localHomeShortcutItem = localAppItem.makeHomeItem();
        localHomeShortcutItem.setIcon(localTitleIconInfo.mIcon);
      }
      for (;;)
      {
        localHomeShortcutItem.container = localHomeFolderItem.mId;
        localHomeShortcutItem.mId = localLauncherApplication.getLauncherProvider().generateNewHomeId();
        localHomeFolderItem.addItem(localHomeShortcutItem);
        LauncherModel.addItemToItemList(paramContext, localHomeShortcutItem);
        paramInt2 += localAppItem.mBadgeCount;
        paramInt1 += 1;
        break;
        localHomeShortcutItem = localAppItem.makeHomeItem();
      }
    }
    localLauncherApplication.getLauncherProvider().addHomeFolderItems(localHomeFolderItem.mId, localHomeFolderItem);
    localHomeFolderItem.mBadgeCount = paramInt2;
    return localHomeFolderItem;
  }
  
  public void addItem(BaseItem paramBaseItem)
  {
    addItemAt(paramBaseItem, -1);
  }
  
  public void addItemAt(BaseItem paramBaseItem, int paramInt)
  {
    if (!isValidItem(paramBaseItem)) {
      throw new IllegalArgumentException("Can only add HOME_APPLICATIONs or HOME_SHORTCUTs to HOME_FOLDERs. Tried to add " + paramBaseItem);
    }
    HomeItem localHomeItem = (HomeItem)paramBaseItem;
    int j = this.contents.size();
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= j) {}
    }
    else
    {
      i = j;
    }
    int k;
    if ((localHomeItem.container == this.mId) && (this.contents.contains(paramBaseItem))) {
      if (localHomeItem.mScreen != i)
      {
        if (localHomeItem.mScreen >= i) {
          break label179;
        }
        k = localHomeItem.mScreen + 1;
        j = i - 1;
        paramInt = -1;
        i -= 1;
        adjustPositions(k, j, paramInt);
        localHomeItem.mScreen = i;
      }
    }
    for (;;)
    {
      paramInt = 0;
      while (paramInt < this.listeners.size())
      {
        ((FolderListener)this.listeners.get(paramInt)).onAdd(paramBaseItem);
        paramInt += 1;
      }
      label179:
      k = i;
      j = localHomeItem.mScreen - 1;
      paramInt = 1;
      break;
      adjustPositions(i, j - 1, 1);
      localHomeItem.cellX = -1;
      localHomeItem.cellY = -1;
      localHomeItem.container = this.mId;
      localHomeItem.mScreen = i;
      this.contents.add(i, localHomeItem);
    }
    sort();
    itemsChanged();
  }
  
  public void addListener(FolderListener paramFolderListener)
  {
    this.listeners.add(paramFolderListener);
  }
  
  public boolean contains(BaseItem paramBaseItem)
  {
    return this.contents.contains(paramBaseItem);
  }
  
  public long getContainer()
  {
    return this.container;
  }
  
  public int getFolderColor()
  {
    return this.mColor;
  }
  
  public long getId()
  {
    return this.mId;
  }
  
  public BaseItem getItemAt(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.contents.size()) {
        localObject1 = (BaseItem)this.contents.get(paramInt);
      }
    }
    return (BaseItem)localObject1;
  }
  
  public int getItemCount()
  {
    return this.contents.size();
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public boolean isEnabled()
  {
    return this.mEnabled;
  }
  
  public boolean isHiddenAddButton()
  {
    return this.mHiddenAddButton;
  }
  
  public boolean isOpened()
  {
    return this.mOpened;
  }
  
  public boolean isRequiredToRedraw()
  {
    return this.mRedrawIcons;
  }
  
  public boolean isValidItem(BaseItem paramBaseItem)
  {
    return (paramBaseItem.mType == BaseItem.Type.HOME_APPLICATION) || (paramBaseItem.mType == BaseItem.Type.HOME_SHORTCUT);
  }
  
  void itemsChanged()
  {
    int i = 0;
    while (i < this.listeners.size())
    {
      ((FolderListener)this.listeners.get(i)).onItemsChanged();
      i += 1;
    }
  }
  
  void loadItem(HomeItem paramHomeItem)
  {
    this.contents.add(paramHomeItem);
  }
  
  public void normalize(List<HomeItem> paramList)
  {
    sort();
    int i = this.contents.size() - 1;
    while (i >= 0)
    {
      HomeItem localHomeItem = (HomeItem)this.contents.get(i);
      if (localHomeItem.mScreen != i)
      {
        localHomeItem.mScreen = i;
        paramList.add(localHomeItem);
      }
      i -= 1;
    }
  }
  
  void onAddToDatabase(ContentValues paramContentValues)
  {
    super.onAddToDatabase(paramContentValues);
    if (this.mTitle != null) {
      paramContentValues.put("title", this.mTitle);
    }
    if (this.mColor != -1) {
      paramContentValues.put("color", Integer.valueOf(this.mColor));
    }
  }
  
  public void removeItem(BaseItem paramBaseItem)
  {
    this.contents.remove(paramBaseItem);
    adjustPositions(paramBaseItem.mScreen, this.contents.size(), -1);
    int i = 0;
    while (i < this.listeners.size())
    {
      ((FolderListener)this.listeners.get(i)).onRemove(paramBaseItem);
      i += 1;
    }
    Talk.INSTANCE.say(2131755207);
    itemsChanged();
  }
  
  public void removeListener(FolderListener paramFolderListener)
  {
    if (this.listeners.contains(paramFolderListener)) {
      this.listeners.remove(paramFolderListener);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }
  
  public void setFolderColor(int paramInt)
  {
    this.mColor = paramInt;
    LauncherModel.updateItemInDatabase((LauncherApplication)Launcher.getInstance().getApplicationContext(), this);
  }
  
  public void setHiddenAddButton(boolean paramBoolean)
  {
    this.mHiddenAddButton = paramBoolean;
  }
  
  public void setOpened(boolean paramBoolean)
  {
    this.mOpened = paramBoolean;
  }
  
  public void setTitle(Context paramContext, String paramString)
  {
    this.mTitle = paramString;
    int i = 0;
    while (i < this.listeners.size())
    {
      ((FolderListener)this.listeners.get(i)).onTitleChanged(paramString);
      i += 1;
    }
    LauncherModel.updateItemInDatabase(paramContext, this);
  }
  
  public void setToRedrawIcons(boolean paramBoolean)
  {
    this.mRedrawIcons = paramBoolean;
  }
  
  public void sort()
  {
    Collections.sort(this.contents, IN_FOLDER_POSITION_COMPARATOR);
  }
  
  public String toString()
  {
    return "HomeFolderItem(id=" + this.mId + " container=" + this.container + " screen=" + this.mScreen + " cellX=" + this.cellX + " cellY=" + this.cellY + " title=" + this.mTitle + ")";
  }
  
  public void unbind()
  {
    super.unbind();
    this.listeners.clear();
  }
  
  static abstract interface FolderListener
  {
    public abstract void onAdd(BaseItem paramBaseItem);
    
    public abstract void onItemsChanged();
    
    public abstract void onRemove(BaseItem paramBaseItem);
    
    public abstract void onTitleChanged(String paramString);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeFolderItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */