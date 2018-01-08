package com.android.launcher2;

import android.content.Context;
import com.sec.dtl.launcher.Talk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AppFolderItem
  extends AppItem
  implements FolderItem
{
  private ArrayList<HomeFolderItem.FolderListener> listeners = new ArrayList();
  private boolean mEnabled = true;
  private boolean mHiddenAddButton = false;
  private List<AppItem> mItems = new ArrayList();
  private boolean mOpened = false;
  private boolean mRedrawIcons = false;
  private List<AppItem> mSavedItems;
  
  public AppFolderItem()
  {
    super(BaseItem.Type.MENU_FOLDER, null, false);
  }
  
  private void adjustPositions(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= paramInt2)
    {
      Iterator localIterator = this.mItems.iterator();
      while (localIterator.hasNext())
      {
        AppItem localAppItem = (AppItem)localIterator.next();
        if ((localAppItem.mScreen >= paramInt1) && (localAppItem.mScreen <= paramInt2)) {
          localAppItem.mScreen += paramInt3;
        }
      }
    }
  }
  
  private void freeEditResources()
  {
    this.mSavedItems = null;
  }
  
  public void addItem(BaseItem paramBaseItem)
  {
    addItemAt(paramBaseItem, -1);
  }
  
  public void addItemAt(BaseItem paramBaseItem, int paramInt)
  {
    if (!isValidItem(paramBaseItem)) {
      throw new IllegalArgumentException("Can only add MENU_APPs to MENU_FOLDERs");
    }
    AppItem localAppItem = (AppItem)paramBaseItem;
    int j = this.mItems.size();
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
    if (localAppItem.mFolder == this)
    {
      int k;
      if (localAppItem.mScreen != i)
      {
        if (localAppItem.mScreen >= i) {
          break label121;
        }
        k = localAppItem.mScreen + 1;
        j = i - 1;
        paramInt = -1;
        i -= 1;
      }
      for (;;)
      {
        adjustPositions(k, j, paramInt);
        localAppItem.mScreen = i;
        sort();
        itemsChanged();
        return;
        label121:
        k = i;
        j = localAppItem.mScreen - 1;
        paramInt = 1;
      }
    }
    if (localAppItem.mFolder == null) {
      MenuAppModel.INSTANCE.invalidateTopLevelItems();
    }
    for (;;)
    {
      adjustPositions(i, j - 1, 1);
      localAppItem.mScreen = i;
      localAppItem.mCell = -1;
      localAppItem.mFolder = this;
      this.mItems.add(i, localAppItem);
      break;
      localAppItem.mFolder.removeItem(paramBaseItem);
    }
  }
  
  public void addListener(HomeFolderItem.FolderListener paramFolderListener)
  {
    this.listeners.add(paramFolderListener);
  }
  
  public void childDestroyed(AppItem paramAppItem)
  {
    this.mItems.remove(paramAppItem);
    if (this.mSavedItems != null) {
      this.mSavedItems.remove(paramAppItem);
    }
  }
  
  public boolean contains(BaseItem paramBaseItem)
  {
    return this.mItems.contains(paramBaseItem);
  }
  
  public boolean containsNonSystemApps()
  {
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext()) {
      if (!((AppItem)localIterator.next()).mSystemApp) {
        return true;
      }
    }
    return false;
  }
  
  public void destroy()
  {
    super.destroy();
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext()) {
      ((AppItem)localIterator.next()).parentDestroyed(this);
    }
    if (this.mSavedItems != null)
    {
      localIterator = this.mSavedItems.iterator();
      while (localIterator.hasNext()) {
        ((AppItem)localIterator.next()).parentDestroyed(this);
      }
    }
    this.mItems = null;
    freeEditResources();
    this.mSavedItems = null;
  }
  
  public void editBegin()
  {
    super.editBegin();
    this.mSavedItems = new ArrayList(this.mItems);
  }
  
  public void editCommit()
  {
    super.editCommit();
    freeEditResources();
  }
  
  public void editDestroy()
  {
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext()) {
      ((AppItem)localIterator.next()).editParentDestroyed();
    }
  }
  
  public void editRevert()
  {
    super.editRevert();
    this.mItems = this.mSavedItems;
    freeEditResources();
  }
  
  public List<AppItem> getAllItems()
  {
    return new ArrayList(this.mItems);
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
      if (paramInt < this.mItems.size()) {
        localObject1 = (BaseItem)this.mItems.get(paramInt);
      }
    }
    return (BaseItem)localObject1;
  }
  
  public int getItemCount()
  {
    return this.mItems.size();
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
    return paramBaseItem.mType == BaseItem.Type.MENU_APP;
  }
  
  void itemsChanged()
  {
    setToRedrawIcons(true);
    int i = 0;
    while (i < this.listeners.size())
    {
      ((HomeFolderItem.FolderListener)this.listeners.get(i)).onItemsChanged();
      i += 1;
    }
  }
  
  void loadItem(AppItem paramAppItem)
  {
    this.mItems.add(paramAppItem);
    paramAppItem.mFolder = this;
  }
  
  public void normalize(MenuAppModel.Normalizer<AppItem> paramNormalizer)
  {
    paramNormalizer.normalize(this.mItems, -1, false);
  }
  
  public void removeItem(BaseItem paramBaseItem)
  {
    if (this.mItems.remove(paramBaseItem))
    {
      ((AppItem)paramBaseItem).mFolder = null;
      adjustPositions(paramBaseItem.mScreen, this.mItems.size(), -1);
      paramBaseItem.mScreen = -1;
      MenuAppModel.INSTANCE.invalidateTopLevelItems();
      Talk.INSTANCE.say(2131755207);
      itemsChanged();
    }
  }
  
  public void removeListener(HomeFolderItem.FolderListener paramFolderListener)
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
    MenuAppModel.INSTANCE.changeFolderColor(this);
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
    if (((paramString != null) && (!paramString.equals(this.mTitle))) || ((this.mTitle != null) && (!this.mTitle.equals(paramString))))
    {
      this.mTitle = paramString;
      MenuAppModel.INSTANCE.changeFolderName(this);
    }
  }
  
  public void setToRedrawIcons(boolean paramBoolean)
  {
    this.mRedrawIcons = paramBoolean;
  }
  
  public void sort()
  {
    Collections.sort(this.mItems, MenuAppModel.INSTANCE.getCurrentComparator());
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AppFolderItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */