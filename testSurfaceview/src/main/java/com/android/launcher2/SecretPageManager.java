package com.android.launcher2;

import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SecretPageManager
{
  public static final boolean DEBUG = false;
  private static final boolean DEBUGGABLE = ;
  public static final String TAG = "SecretPageManager";
  private boolean mCompleteShowHidedPage;
  private HashMap<Integer, CellLayout> mHidedPage = new HashMap();
  private HomeView mHomeView;
  private Launcher mLauncher;
  private boolean mPageSwitchBySecretMode = false;
  private Workspace mWorkspace;
  
  public SecretPageManager(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
  }
  
  private void checkHomeViewItemListByPageName(CellLayout paramCellLayout, List<HomeItem> paramList, String paramString)
  {
    int i = 0;
    while (i < paramCellLayout.getPageChildCount())
    {
      Object localObject = paramCellLayout.getChildOnPageAt(i).getTag();
      if ((localObject instanceof HomeFolderItem))
      {
        localObject = (HomeFolderItem)localObject;
        int j = 0;
        while (j < ((HomeFolderItem)localObject).getItemCount())
        {
          BaseItem localBaseItem = ((HomeFolderItem)localObject).getItemAt(j);
          if ((localBaseItem.getPackageName() != null) && (localBaseItem.getPackageName().startsWith(paramString))) {
            paramList.add((HomeItem)localBaseItem);
          }
          j += 1;
        }
      }
      if ((localObject instanceof HomeItem))
      {
        localObject = (HomeItem)localObject;
        if ((((HomeItem)localObject).getPackageName() != null) && (((HomeItem)localObject).getPackageName().startsWith(paramString))) {
          paramList.add(localObject);
        }
      }
      i += 1;
    }
  }
  
  public void ShowEqualPageWithItem(BaseItem paramBaseItem, Workspace.State paramState)
  {
    if (paramBaseItem == null) {}
    while (!Launcher.sIsSecretModeOn) {
      return;
    }
    setCompleteShowHidedPage(false);
    int k = this.mWorkspace.getCurrentPage();
    this.mHidedPage.clear();
    int i = 0;
    while (i < this.mWorkspace.getChildCount())
    {
      localObject = (CellLayout)this.mWorkspace.getChildAt(i);
      if (((((CellLayout)localObject).getPageType() == 1) && (!paramBaseItem.mSecretItem)) || ((((CellLayout)localObject).getPageType() != 1) && (paramBaseItem.mSecretItem))) {
        this.mHidedPage.put(Integer.valueOf(i), localObject);
      }
      i += 1;
    }
    for (i = 0; i < this.mWorkspace.getChildCount(); i = j + 1)
    {
      localObject = (CellLayout)this.mWorkspace.getChildAt(i);
      if ((((CellLayout)localObject).getPageType() != 1) || (paramBaseItem.mSecretItem))
      {
        j = i;
        if (((CellLayout)localObject).getPageType() != 1)
        {
          j = i;
          if (!paramBaseItem.mSecretItem) {}
        }
      }
      else
      {
        this.mWorkspace.removeViewAt(i);
        j = i - 1;
        this.mPageSwitchBySecretMode = true;
      }
    }
    Log.i("SecretPageManager", "ShowEqualPageWithItem - (isSecret:" + paramBaseItem.mSecretItem + ") " + this.mHidedPage.size() + " pages removed");
    i = 0;
    Object localObject = this.mHidedPage.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (k > ((Integer)((Iterator)localObject).next()).intValue()) {
        i += 1;
      }
    }
    int j = this.mWorkspace.getPendingSnapToPage();
    if ((paramState == Workspace.State.RESIZE) && (j >= 0)) {
      if (paramBaseItem.mSecretItem) {
        this.mWorkspace.snapToPage(j);
      }
    }
    for (;;)
    {
      this.mWorkspace.setPendingSnapToPage(-1);
      return;
      this.mWorkspace.snapToPage(j - LauncherApplication.getSecretScreenCount());
      continue;
      j = k - i;
      i = j;
      if (j >= this.mWorkspace.getChildCount()) {
        i = 0;
      }
      this.mWorkspace.setCurrentPage(i);
    }
  }
  
  public void ShowHidedPage()
  {
    if (this.mHidedPage.size() > 0)
    {
      Log.i("SecretPageManager", "ShowHidedPage - " + this.mHidedPage.size() + " pages will be added");
      int m = LauncherApplication.getScreenCount();
      int n = LauncherApplication.getSecretScreenCount();
      int j = -1;
      int k = 0;
      if (k < m + n)
      {
        if (!this.mHidedPage.containsKey(Integer.valueOf(k))) {
          i = j;
        }
        for (;;)
        {
          k += 1;
          j = i;
          break;
          i = j;
          if (j < 0)
          {
            j = this.mWorkspace.getCurrentPage();
            i = j;
            if (((CellLayout)this.mHidedPage.get(Integer.valueOf(k))).getPageType() == 1) {
              i = j + LauncherApplication.getSecretScreenCount();
            }
          }
          this.mWorkspace.addView((View)this.mHidedPage.get(Integer.valueOf(k)), k);
          this.mPageSwitchBySecretMode = true;
        }
      }
      int i = 0;
      while (i < this.mWorkspace.getChildCount())
      {
        CellLayout localCellLayout = (CellLayout)this.mWorkspace.getChildAt(i);
        if (localCellLayout != null) {
          localCellLayout.destroyDummyPanel();
        }
        i += 1;
      }
      this.mWorkspace.setAllEmptyMessageVisibility(false);
      this.mWorkspace.setCurrentPage(j);
      this.mHidedPage.clear();
      setCompleteShowHidedPage(true);
      if (this.mWorkspace.getCreatedPageForDrag() != null) {
        this.mWorkspace.removeCreatedPageForDrag();
      }
      i = this.mWorkspace.getPendingSnapToPage();
      if (i >= 0) {
        this.mWorkspace.snapToPage(i);
      }
    }
  }
  
  public boolean getCompleteShowHidedPage()
  {
    return this.mCompleteShowHidedPage;
  }
  
  public void getHomeViewItemListByPackageName(List<HomeItem> paramList, String paramString)
  {
    int i = 0;
    CellLayout localCellLayout;
    while (i < this.mWorkspace.getChildCount())
    {
      localCellLayout = (CellLayout)this.mWorkspace.getChildAt(i);
      if (localCellLayout != null) {
        checkHomeViewItemListByPageName(localCellLayout, paramList, paramString);
      }
      i += 1;
    }
    if (this.mHomeView.getHotseat() == null) {}
    do
    {
      return;
      localCellLayout = this.mHomeView.getHotseat().getLayout();
    } while (localCellLayout == null);
    checkHomeViewItemListByPageName(localCellLayout, paramList, paramString);
  }
  
  public boolean getPageSwitchBySecretMode()
  {
    return this.mPageSwitchBySecretMode;
  }
  
  public int getSecretPageCount()
  {
    int j = 0;
    int i = 0;
    while (i < this.mWorkspace.getChildCount())
    {
      int k = j;
      if (((CellLayout)this.mWorkspace.getChildAt(i)).getPageType() == 1) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public void initSecretPage(HomeView paramHomeView)
  {
    this.mHomeView = paramHomeView;
    this.mWorkspace = this.mHomeView.getWorkspace();
  }
  
  public void printWorkspaceInfo()
  {
    String str = "|";
    int i = 0;
    if (i < this.mWorkspace.getChildCount())
    {
      if (((CellLayout)this.mWorkspace.getChildAt(i)).getPageType() == 1) {}
      for (str = str + "S|";; str = str + "N|")
      {
        i += 1;
        break;
      }
    }
    Log.i("SecretPageManager", "WorkspaceInfo - " + str);
    Log.i("SecretPageManager", "HidedPage size - " + this.mHidedPage.size());
  }
  
  public void setCompleteShowHidedPage(boolean paramBoolean)
  {
    this.mCompleteShowHidedPage = paramBoolean;
  }
  
  public void setPageSwitchBySecretMode(boolean paramBoolean)
  {
    this.mPageSwitchBySecretMode = paramBoolean;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/SecretPageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */