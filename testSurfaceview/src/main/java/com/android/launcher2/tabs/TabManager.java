package com.android.launcher2.tabs;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import com.android.launcher2.CellLayoutChildren;
import com.android.launcher2.CellLayoutMenu;
import com.android.launcher2.Launcher;
import com.android.launcher2.MenuAppsGrid;
import com.android.launcher2.MenuAppsGridFragment;
import com.android.launcher2.MenuView;
import com.android.launcher2.MenuView.NeedsTabHost;
import com.android.launcher2.MenuWidgets;
import com.android.launcher2.MenuWidgetsFragment;
import com.android.launcher2.Utilities;
import com.android.launcher2.guide.GuideFragment;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class TabManager
  implements TabHost.OnTabChangeListener
{
  private static final boolean DEBUGGABLE = ;
  private static final String TAG = "TabManager";
  private final Activity mActivity;
  private final int mContainerId;
  private View.OnKeyListener mEndTabKeyListener;
  private TabInfo mLastTab;
  private final MenuView mTabHost;
  private TabWidget mTabWidget;
  private final HashMap<String, TabInfo> mTabs = new HashMap();
  
  public TabManager(Activity paramActivity, MenuView paramMenuView, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mTabHost = paramMenuView;
    this.mContainerId = paramInt;
    this.mTabHost.setOnTabChangedListener(this);
  }
  
  private void onAddTab(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((paramFragment instanceof MenuView.NeedsTabHost)))
    {
      ((MenuView.NeedsTabHost)paramFragment).setTabHost(this.mTabHost);
      if (paramFragment.isHidden()) {
        ((MenuView.NeedsTabHost)paramFragment).onHideTab(this.mTabHost);
      }
    }
    else
    {
      return;
    }
    ((MenuView.NeedsTabHost)paramFragment).onShowTab(this.mTabHost);
  }
  
  private void onHideTab(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((paramFragment instanceof MenuView.NeedsTabHost))) {
      ((MenuView.NeedsTabHost)paramFragment).onHideTab(this.mTabHost);
    }
  }
  
  private void onShowTab(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((paramFragment instanceof MenuView.NeedsTabHost))) {
      ((MenuView.NeedsTabHost)paramFragment).onShowTab(this.mTabHost);
    }
  }
  
  public void addTab(TabHost.TabSpec paramTabSpec, Class<?> paramClass, Bundle paramBundle)
  {
    paramTabSpec.setContent(new DummyTabFactory(this.mActivity));
    paramClass = new TabInfo(paramTabSpec.getTag(), paramClass, paramBundle);
    paramBundle = this.mActivity.getFragmentManager();
    TabInfo.access$002(paramClass, paramBundle.findFragmentByTag(paramClass.tag));
    if ((paramClass.fragment != null) && (!paramClass.fragment.isDetached())) {
      paramBundle.beginTransaction().hide(paramClass.fragment).commit();
    }
    onAddTab(paramClass.fragment);
    this.mTabs.put(paramClass.tag, paramClass);
    this.mTabHost.addTab(paramTabSpec);
    this.mTabWidget = this.mTabHost.getTabWidget();
    if (this.mEndTabKeyListener != null)
    {
      int i = this.mTabWidget.getChildCount() - 1;
      if (i > 0) {
        this.mTabWidget.getChildAt(i - 1).setOnKeyListener(null);
      }
      this.mTabWidget.getChildAt(i).setOnKeyListener(this.mEndTabKeyListener);
    }
  }
  
  public void attachFragments() {}
  
  public void changeTabFragment(String paramString, Class<?> paramClass)
  {
    paramString = (TabInfo)this.mTabs.get(paramString);
    if (paramString == null) {}
    do
    {
      return;
      TabInfo.access$102(paramString, paramClass);
    } while (paramString.fragment == null);
    paramClass = Fragment.instantiate(this.mActivity, paramString.clss.getName(), paramString.args);
    FragmentTransaction localFragmentTransaction = this.mActivity.getFragmentManager().beginTransaction().remove(paramString.fragment).add(this.mContainerId, paramClass, paramString.tag);
    if (paramString.fragment.isHidden()) {
      localFragmentTransaction.hide(paramClass);
    }
    localFragmentTransaction.commit();
    TabInfo.access$002(paramString, paramClass);
    onAddTab(paramClass);
  }
  
  public void detachFragments() {}
  
  public Fragment getCurrentlyShownFragment()
  {
    if (this.mLastTab != null) {
      return this.mLastTab.fragment;
    }
    return null;
  }
  
  public Fragment getFragmentForTab(String paramString)
  {
    return getFragmentForTab(paramString, true);
  }
  
  public Fragment getFragmentForTab(String paramString, boolean paramBoolean)
  {
    paramString = (TabInfo)this.mTabs.get(paramString);
    if (paramString == null) {
      return null;
    }
    FragmentTransaction localFragmentTransaction;
    if ((paramString.fragment == null) && (paramBoolean))
    {
      TabInfo.access$002(paramString, Fragment.instantiate(this.mActivity, paramString.clss.getName(), paramString.args));
      localFragmentTransaction = this.mActivity.getFragmentManager().beginTransaction().add(this.mContainerId, paramString.fragment, paramString.tag).hide(paramString.fragment);
      if (((Launcher)this.mActivity).isResumed_()) {
        break label116;
      }
      localFragmentTransaction.commitAllowingStateLoss();
    }
    for (;;)
    {
      onAddTab(paramString.fragment);
      return paramString.fragment;
      label116:
      localFragmentTransaction.commit();
    }
  }
  
  public Collection<TabInfo> getTabInfo()
  {
    return Collections.unmodifiableCollection(this.mTabs.values());
  }
  
  public void onTabChanged(String paramString)
  {
    TabInfo localTabInfo = (TabInfo)this.mTabs.get(paramString);
    if ((Launcher.isHelpAppRunning) && (this.mLastTab != null) && ((GuideFragment.GMode.equals("addapps")) || (GuideFragment.GMode.equals("create_folder"))) && (!MenuView.onShowAllAppsClicked)) {
      this.mTabHost.setCurrentTabByTag(this.mLastTab.fragment.getTag());
    }
    do
    {
      return;
      MenuView.onShowAllAppsClicked = false;
    } while (this.mLastTab == localTabInfo);
    FragmentTransaction localFragmentTransaction = this.mActivity.getFragmentManager().beginTransaction();
    Object localObject;
    if ((this.mLastTab != null) && (this.mLastTab.fragment != null))
    {
      if ((this.mLastTab.fragment instanceof MenuWidgetsFragment))
      {
        localObject = ((MenuWidgetsFragment)this.mLastTab.fragment).getMenuWidgets();
        if (localObject != null) {
          ((MenuWidgets)localObject).changeToWidgetStateNormal();
        }
      }
      localFragmentTransaction.hide(this.mLastTab.fragment);
      onHideTab(this.mLastTab.fragment);
    }
    if (localTabInfo != null)
    {
      if (localTabInfo.fragment == null)
      {
        TabInfo.access$002(localTabInfo, Fragment.instantiate(this.mActivity, localTabInfo.clss.getName(), localTabInfo.args));
        localFragmentTransaction.add(this.mContainerId, localTabInfo.fragment, localTabInfo.tag);
        onAddTab(localTabInfo.fragment);
        if (DEBUGGABLE) {
          Log.i("TabManager", "onTabChanged() adding class " + localTabInfo.clss.getName() + " obj " + localTabInfo.fragment);
        }
      }
      while ((localTabInfo.fragment instanceof MenuAppsGridFragment))
      {
        paramString = ((MenuAppsGridFragment)localTabInfo.fragment).getMenuAppsGrid();
        if (paramString != null)
        {
          if (DEBUGGABLE) {
            Log.i("TabManager", "onTabChanged() menu pages: " + paramString.getChildCount());
          }
          int i = 0;
          while (i < paramString.getChildCount())
          {
            localObject = (CellLayoutMenu)paramString.getChildAt(i);
            if (DEBUGGABLE) {
              Log.i("TabManager", "onTabChanged() Page " + i + " contains item " + ((CellLayoutMenu)localObject).getChildrenLayout().getChildCount());
            }
            i += 1;
          }
          if (localTabInfo.fragment.isDetached()) {
            localFragmentTransaction.attach(localTabInfo.fragment);
          }
          localFragmentTransaction.show(localTabInfo.fragment);
          onShowTab(localTabInfo.fragment);
          if (DEBUGGABLE) {
            Log.i("TabManager", "onTabChanged() show fragment " + localTabInfo.fragment);
          }
        }
        else if (DEBUGGABLE)
        {
          Log.e("TabManager", "onTabChanged() no MenuAppsGrid!");
        }
      }
    }
    for (;;)
    {
      this.mLastTab = localTabInfo;
      if (((Launcher)this.mActivity).isResumed_()) {
        break;
      }
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      if (DEBUGGABLE) {
        Log.e("TabManager", "onTabChanged() no tab for " + paramString);
      }
    }
    localFragmentTransaction.commit();
  }
  
  public void setLastTabKeyListener(View.OnKeyListener paramOnKeyListener)
  {
    this.mEndTabKeyListener = paramOnKeyListener;
    this.mTabWidget.getChildAt(this.mTabWidget.getChildCount() - 1).setOnKeyListener(this.mEndTabKeyListener);
    this.mTabWidget.getChildAt(this.mTabWidget.getChildCount() - 2).setOnKeyListener(this.mEndTabKeyListener);
  }
  
  private static class DummyTabFactory
    implements TabHost.TabContentFactory
  {
    private final Context mContext;
    
    public DummyTabFactory(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public View createTabContent(String paramString)
    {
      paramString = new View(this.mContext);
      paramString.setMinimumWidth(0);
      paramString.setMinimumHeight(0);
      return paramString;
    }
  }
  
  public static final class TabInfo
  {
    private final Bundle args;
    private Class<?> clss;
    private Fragment fragment;
    public final String tag;
    
    TabInfo(String paramString, Class<?> paramClass, Bundle paramBundle)
    {
      this.tag = paramString;
      this.clss = paramClass;
      this.args = paramBundle;
    }
    
    public Fragment getFrag()
    {
      return this.fragment;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/tabs/TabManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */