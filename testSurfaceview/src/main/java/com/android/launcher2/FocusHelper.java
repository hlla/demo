package com.android.launcher2;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.android.launcher2.guide.GuideFragment;
import com.sec.android.app.CscFeature;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FocusHelper
{
  public static final View.OnKeyListener APPS_CUSTOMIZE_TABKEY_LISTENER;
  public static final View.OnKeyListener CREATE_FOLDER_COLOR_VIEW_ITEM_LISTENER;
  public static final View.OnKeyListener CREATE_FOLDER_OPTIONS_BUTTON_KEY_LISTENER;
  public static final View.OnKeyListener DOWNLOADED_ICON_KEY_LISTENER;
  public static final View.OnKeyListener FOLDERNAME_KEY_LISTENER;
  public static final View.OnKeyListener FOLDER_ADDITEM_KEY_LISTENER;
  public static final View.OnKeyListener FOLDER_COLOR_VIEW_ITEM_LISTENER;
  public static final View.OnKeyListener FOLDER_KEY_LISTENER;
  public static final View.OnKeyListener FOLDER_OPTIONS_BUTTON_KEY_LISTENER;
  public static final View.OnKeyListener GOOGLE_SEARCH_KEY_LISTENER;
  public static final View.OnKeyListener HOME_MAGAZINE_BUTTON_KEY_LISTENER;
  public static final View.OnKeyListener HOME_OPTION_MENU_KEY_LISTENER;
  public static final View.OnKeyListener HOME_SOFTKEY_ALLAPPS_ICON_KEY_LISTENER;
  public static final View.OnKeyListener HOME_SOFTKEY_PHONE_ICON_KEY_LISTENER;
  public static final View.OnKeyListener HOTSEAT_ICON_KEY_LISTENER;
  public static final View.OnKeyListener MENUAPPGRID_ICON_KEY_LISTENER;
  public static final View.OnKeyListener MENU_WIDGETS_ITEM_LISTENER;
  public static final View.OnKeyListener QUICK_ALLAPPS_ICON_KEY_LISTENER;
  public static final View.OnKeyListener QUICK_CAMERA_ICON_KEY_LISTENER;
  public static final View.OnKeyListener TITLEBAR_KEY_LISTENER;
  public static final View.OnKeyListener WIDGET_FOLDER_WIDGET_ITEM_LISTENER;
  public static final View.OnKeyListener WORKSPACE_ICON_KEY_LISTENER;
  private static HomeView sHomeView;
  private static boolean sIsLoopingEnabled;
  
  static
  {
    if (!CscFeature.getInstance().getEnableStatus("CscFeature_Launcher_DisablePageRotation")) {}
    for (boolean bool = true;; bool = false)
    {
      sIsLoopingEnabled = bool;
      DOWNLOADED_ICON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleDownloadedIconKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      TITLEBAR_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleTitleBarKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      WORKSPACE_ICON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleWorkspaceIconKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent, paramAnonymousView.getResources().getConfiguration().orientation);
        }
      };
      GOOGLE_SEARCH_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleWorkspaceGoogleSearchKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      QUICK_ALLAPPS_ICON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleQuickAllappsIconKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent, paramAnonymousView.getResources().getConfiguration().orientation);
        }
      };
      QUICK_CAMERA_ICON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleQuickCameraIconKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent, paramAnonymousView.getResources().getConfiguration().orientation);
        }
      };
      HOME_SOFTKEY_PHONE_ICON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleHomeSoftkeyPhoneIconKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent, paramAnonymousView.getResources().getConfiguration().orientation);
        }
      };
      HOME_SOFTKEY_ALLAPPS_ICON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleHomeSoftkeyAllappsIconKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent, paramAnonymousView.getResources().getConfiguration().orientation);
        }
      };
      FOLDER_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleFolderKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      FOLDERNAME_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleFolderNameKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      FOLDER_ADDITEM_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleFolderAddItemKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      FOLDER_OPTIONS_BUTTON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleFolderOptionsButtonKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      CREATE_FOLDER_OPTIONS_BUTTON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleCreateFolderOptionsButtonKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      HOTSEAT_ICON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleHotseatButtonKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent, paramAnonymousView.getResources().getConfiguration().orientation);
        }
      };
      HOME_OPTION_MENU_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleHomeOptionMenuonKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      MENUAPPGRID_ICON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleMenuAppGridIconKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      APPS_CUSTOMIZE_TABKEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleAppsCustomizeTabKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      WIDGET_FOLDER_WIDGET_ITEM_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleWidgetFolderPagedViewWidgetKeyEvent(((Launcher)FocusHelper.sHomeView.getContext()).getMenuView().getMenuWidgets(), (PagedViewWidget)paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      MENU_WIDGETS_ITEM_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handlePagedViewWidgetKeyEvent((PagedViewWidget)paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      FOLDER_COLOR_VIEW_ITEM_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleFolderColorViewItemsKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      CREATE_FOLDER_COLOR_VIEW_ITEM_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleCreateFolderColorViewItemsKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      HOME_MAGAZINE_BUTTON_KEY_LISTENER = new View.OnKeyListener()
      {
        public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          return FocusHelper.handleHomeMagazineButtonKeyEvent(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
      };
      return;
    }
  }
  
  private static Folder findFolderParent(View paramView)
  {
    for (paramView = paramView.getParent(); (paramView != null) && (!(paramView instanceof Folder)); paramView = paramView.getParent()) {}
    return (Folder)paramView;
  }
  
  private static View findIndexOfIcon(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i = paramArrayList.size();
    paramInt1 += paramInt2;
    while ((paramInt1 >= 0) && (paramInt1 < i))
    {
      View localView = (View)paramArrayList.get(paramInt1);
      if ((localView instanceof AppIconView)) {
        return localView;
      }
      paramInt1 += paramInt2;
    }
    return null;
  }
  
  private static TabHost findTabHostParent(View paramView)
  {
    for (ViewParent localViewParent1 = paramView.getParent(); (localViewParent1 != null) && (!(localViewParent1 instanceof TabHost)); localViewParent1 = localViewParent1.getParent()) {}
    ViewParent localViewParent2 = localViewParent1;
    if (localViewParent1 == null) {
      localViewParent2 = (ViewParent)paramView;
    }
    return (TabHost)localViewParent2;
  }
  
  private static CellLayoutChildren getCellLayoutChildrenForIndex(ViewGroup paramViewGroup, int paramInt)
  {
    return (CellLayoutChildren)((ViewGroup)paramViewGroup.getChildAt(paramInt)).getChildAt(0);
  }
  
  private static ArrayList<View> getCellLayoutChildrenSortedSpatially(CellLayout paramCellLayout, ViewGroup paramViewGroup)
  {
    int j = paramCellLayout.getCountX();
    int k = paramViewGroup.getChildCount();
    paramCellLayout = new ArrayList();
    int i = 0;
    while (i < k)
    {
      paramCellLayout.add(paramViewGroup.getChildAt(i));
      i += 1;
    }
    Collections.sort(paramCellLayout, new Comparator()
    {
      public int compare(View paramAnonymousView1, View paramAnonymousView2)
      {
        paramAnonymousView1 = (CellLayout.LayoutParams)paramAnonymousView1.getLayoutParams();
        paramAnonymousView2 = (CellLayout.LayoutParams)paramAnonymousView2.getLayoutParams();
        return paramAnonymousView1.cellY * this.val$cellCountX + paramAnonymousView1.cellX - (paramAnonymousView2.cellY * this.val$cellCountX + paramAnonymousView2.cellX);
      }
    });
    return paramCellLayout;
  }
  
  private static View getClosestIconOnLine(CellLayout paramCellLayout, ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    paramViewGroup = getCellLayoutChildrenSortedSpatially(paramCellLayout, paramViewGroup);
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramCellLayout.getCountY();
    int i1 = localLayoutParams.cellY;
    int j = i1 + paramInt;
    if ((j >= 0) && (j < i))
    {
      float f1 = Float.MAX_VALUE;
      int m = -1;
      i = paramViewGroup.indexOf(paramView);
      int k;
      if (paramInt < 0) {
        k = -1;
      }
      while (i != k)
      {
        paramCellLayout = (View)paramViewGroup.get(i);
        paramView = (CellLayout.LayoutParams)paramCellLayout.getLayoutParams();
        if (paramInt < 0) {
          if (paramView.cellY < i1) {
            j = 1;
          }
        }
        float f2;
        int n;
        for (;;)
        {
          f2 = f1;
          n = m;
          if (j != 0)
          {
            f2 = f1;
            n = m;
            if ((paramCellLayout instanceof AppIconView))
            {
              float f3 = (float)Math.sqrt(Math.pow(paramView.cellX - localLayoutParams.cellX, 2.0D) + Math.pow(paramView.cellY - localLayoutParams.cellY, 2.0D));
              f2 = f1;
              n = m;
              if (f3 < f1)
              {
                n = i;
                f2 = f3;
              }
            }
          }
          if (i > k) {
            break label262;
          }
          i += 1;
          f1 = f2;
          m = n;
          break;
          k = paramViewGroup.size();
          break;
          j = 0;
          continue;
          if (paramView.cellY > i1) {
            j = 1;
          } else {
            j = 0;
          }
        }
        label262:
        i -= 1;
        f1 = f2;
        m = n;
      }
      if (m > -1) {
        return (View)paramViewGroup.get(m);
      }
    }
    return null;
  }
  
  private static Folder.FolderColor getFolderColorViewKey(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return Folder.FolderColor.FOLDER_DEFAULT;
    case 2131689528: 
      return Folder.FolderColor.FOLDER_GRAY;
    case 2131689531: 
      return Folder.FolderColor.FOLDER_GREEN;
    case 2131689529: 
      return Folder.FolderColor.FOLDER_RED;
    }
    return Folder.FolderColor.FOLDER_YELLOW;
  }
  
  private static View getIconAtPosition(CellLayoutChildren paramCellLayoutChildren, int paramInt1, int paramInt2)
  {
    return paramCellLayoutChildren.getChildAt(paramInt1 % paramInt2, paramInt1 / paramInt2);
  }
  
  public static View getIconInDirection(CellLayout paramCellLayout, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    return findIndexOfIcon(getCellLayoutChildrenSortedSpatially(paramCellLayout, paramViewGroup), paramInt1, paramInt2);
  }
  
  public static View getIconInDirection(CellLayout paramCellLayout, ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    paramCellLayout = getCellLayoutChildrenSortedSpatially(paramCellLayout, paramViewGroup);
    return findIndexOfIcon(paramCellLayout, paramCellLayout.indexOf(paramView), paramInt);
  }
  
  private static ViewGroup getPage(PagedView paramPagedView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramPagedView.getPageAt(paramInt);
    paramPagedView = localViewGroup;
    if ((localViewGroup instanceof CellLayoutMenu)) {
      paramPagedView = (ViewGroup)localViewGroup.getChildAt(0);
    }
    return paramPagedView;
  }
  
  private static boolean handleAppsCustomizeTabKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = (FocusOnlyTabWidget)paramView.getParent();
    TabHost localTabHost = findTabHostParent((View)localObject);
    ViewGroup localViewGroup = (ViewGroup)localTabHost.findViewById(16908305);
    View localView1 = ((MenuView)localTabHost).getMenuOrMarketButton();
    View localView2 = ((MenuView)localTabHost).getDownButton();
    View localView3 = ((FocusOnlyTabWidget)localObject).getChildAt(0);
    View localView4 = ((FocusOnlyTabWidget)localObject).getChildAt(1);
    MenuView localMenuView = ((Launcher)paramView.getContext()).getMenuView();
    MenuAppsGrid localMenuAppsGrid = localMenuView.getMenuAppsGrid();
    localObject = localMenuView.getMenuWidgets();
    int i;
    if (paramKeyEvent.getAction() != 1) {
      i = 1;
    }
    switch (paramInt)
    {
    default: 
    case 61: 
    case 21: 
    case 22: 
    case 20: 
      label198:
      label342:
      label473:
      do
      {
        return false;
        i = 0;
        break;
        if (paramKeyEvent.isShiftPressed())
        {
          if (i != 0)
          {
            if (paramView != localView4) {
              break label198;
            }
            localView3.requestFocus();
            localView3.playSoundEffect(0);
          }
          for (;;)
          {
            return true;
            if (paramView == localView3)
            {
              paramView = getPage(localMenuAppsGrid, localMenuAppsGrid.getCurrentPage());
              if ((paramView != null) && (localTabHost.getCurrentTabTag() != "WIDGETS"))
              {
                paramInt = paramView.getChildCount();
                i = ((CellLayoutMenu)paramView.getParent()).getCountX();
                paramView = getIconAtPosition((CellLayoutChildren)paramView, paramInt - 1, i);
                if (paramView != null)
                {
                  paramView.requestFocus();
                  paramView.playSoundEffect(0);
                }
              }
              else
              {
                paramView = getPage((PagedView)localObject, ((PagedView)localObject).getCurrentPage());
                if (paramView != null)
                {
                  paramView = paramView.getChildAt(paramView.getChildCount() - 1);
                  if (paramView != null)
                  {
                    paramView.requestFocus();
                    paramView.playSoundEffect(0);
                  }
                }
              }
            }
          }
        }
        if (i != 0)
        {
          if (paramView != localView3) {
            break label342;
          }
          localView4.requestFocus();
          localView4.playSoundEffect(0);
        }
        for (;;)
        {
          return true;
          if ((paramView == localView4) && (localView2 != null))
          {
            if (localView2.isEnabled())
            {
              localView2.requestFocus();
              localView2.playSoundEffect(0);
            }
            else
            {
              localView1.requestFocus();
              localView1.playSoundEffect(0);
            }
          }
          else if ((paramView == localView4) && (localView2 == null) && (localView1.isEnabled()))
          {
            localView1.requestFocus();
            localView1.playSoundEffect(0);
          }
        }
        if ((i != 0) && (paramView == localView4))
        {
          localView3.requestFocus();
          localView3.playSoundEffect(0);
        }
        return true;
        if (i != 0)
        {
          if (paramView != localView3) {
            break label473;
          }
          localView4.requestFocus();
          localView4.playSoundEffect(0);
        }
        for (;;)
        {
          return true;
          if ((paramView == localView4) && (localView2 != null))
          {
            if (localView2.isEnabled())
            {
              localView2.requestFocus();
              localView2.playSoundEffect(0);
            }
            else
            {
              localView1.requestFocus();
              localView1.playSoundEffect(0);
            }
          }
          else if ((paramView == localView4) && (localView2 == null) && (localView1.isEnabled()))
          {
            localView1.requestFocus();
            localView1.playSoundEffect(0);
          }
        }
      } while ((i == 0) || (paramView != localView1));
      localViewGroup.requestFocus();
      return true;
    }
    if (i != 0) {
      if (paramView == localView3) {
        localView3.setPressed(true);
      }
    }
    for (;;)
    {
      return true;
      if (paramView == localView4)
      {
        localView4.setPressed(true);
        continue;
        if (paramView == localView3)
        {
          localView3.setPressed(false);
          localMenuView.selectAppsTab();
          localView3.playSoundEffect(0);
        }
        else if (paramView == localView4)
        {
          localView4.setPressed(false);
          localMenuView.selectWidgetsTab();
          localView4.playSoundEffect(0);
        }
      }
    }
  }
  
  private static boolean handleCreateFolderColorViewItemsKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    FrameLayout localFrameLayout = (FrameLayout)paramView.getParent().getParent();
    View localView = localFrameLayout.findViewById(2131689512);
    Folder.FolderColor localFolderColor = getFolderColorViewKey(paramView);
    if (paramKeyEvent.getAction() != 1) {}
    for (;;)
    {
      paramView = new HashMap();
      paramView.put(Folder.FolderColor.FOLDER_DEFAULT, (ImageView)localFrameLayout.findViewById(2131689527));
      paramView.put(Folder.FolderColor.FOLDER_GRAY, (ImageView)localFrameLayout.findViewById(2131689528));
      paramView.put(Folder.FolderColor.FOLDER_RED, (ImageView)localFrameLayout.findViewById(2131689529));
      paramView.put(Folder.FolderColor.FOLDER_YELLOW, (ImageView)localFrameLayout.findViewById(2131689530));
      paramView.put(Folder.FolderColor.FOLDER_GREEN, (ImageView)localFrameLayout.findViewById(2131689531));
      switch (paramInt)
      {
      default: 
        return false;
        i = 0;
      }
    }
    if (i != 0)
    {
      if (localFolderColor != Folder.FolderColor.FOLDER_GREEN) {
        break label201;
      }
      localView.requestFocus();
      localView.playSoundEffect(0);
    }
    for (;;)
    {
      return true;
      label201:
      paramKeyEvent = Folder.FolderColor.values()[(localFolderColor.ordinal() + 1)];
      ((ImageView)paramView.get(paramKeyEvent)).requestFocus();
      ((ImageView)paramView.get(paramKeyEvent)).playSoundEffect(0);
    }
    if (i != 0)
    {
      if (localFolderColor != Folder.FolderColor.FOLDER_DEFAULT) {
        break label266;
      }
      localView.requestFocus();
      localView.playSoundEffect(0);
    }
    for (;;)
    {
      return true;
      label266:
      paramKeyEvent = Folder.FolderColor.values()[(localFolderColor.ordinal() - 1)];
      ((ImageView)paramView.get(paramKeyEvent)).requestFocus();
      ((ImageView)paramView.get(paramKeyEvent)).playSoundEffect(0);
    }
  }
  
  private static boolean handleCreateFolderOptionsButtonKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    Object localObject = (LinearLayout)paramView.getParent().getParent().getParent().getParent();
    paramView = (EditText)((LinearLayout)localObject).findViewById(2131689507);
    LinearLayout localLinearLayout = (LinearLayout)((LinearLayout)localObject).findViewById(2131689513);
    localObject = ((LinearLayout)localObject).findViewById(2131689510);
    if (paramKeyEvent.getAction() != 1) {}
    for (;;)
    {
      switch (paramInt)
      {
      case 20: 
      default: 
        return false;
        i = 0;
      }
    }
    if (i != 0)
    {
      if ((localLinearLayout == null) || (localLinearLayout.getVisibility() != 0)) {
        break label142;
      }
      localLinearLayout.getChildAt(0).requestFocus();
      localLinearLayout.getChildAt(0).playSoundEffect(0);
    }
    for (;;)
    {
      return true;
      label142:
      if (localObject != null)
      {
        ((View)localObject).requestFocus();
        ((View)localObject).playSoundEffect(0);
      }
      else if (paramView != null)
      {
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
    }
  }
  
  private static boolean handleDownloadedIconKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    TabHost localTabHost = findTabHostParent(paramView);
    ViewGroup localViewGroup = (ViewGroup)localTabHost.findViewById(16908305);
    View localView1 = ((FocusOnlyTabWidget)localTabHost.findViewById(16908307)).getChildAt(1);
    View localView2 = ((MenuView)localTabHost).getMenuOrMarketButton();
    View localView3 = ((MenuView)localTabHost).getDownButton();
    if (paramKeyEvent.getAction() != 1) {
      switch (paramInt)
      {
      }
    }
    label137:
    label172:
    do
    {
      return false;
      i = 0;
      break;
      if (i != 0)
      {
        if (LauncherApplication.hasMenuKey()) {
          break label172;
        }
        if ((paramView != localView2) || (!localView3.isEnabled())) {
          break label137;
        }
        localView3.requestFocus();
        localView3.playSoundEffect(0);
      }
      for (;;)
      {
        return true;
        if (((paramView == localView2) && (!localView3.isEnabled())) || (paramView == localView3))
        {
          localView1.requestFocus();
          localView1.playSoundEffect(0);
          continue;
          if (paramView != localTabHost)
          {
            localView1.requestFocus();
            localView1.playSoundEffect(0);
          }
        }
      }
      if ((!LauncherApplication.hasMenuKey()) && (i != 0) && (paramView == localView3))
      {
        localView2.requestFocus();
        localView2.playSoundEffect(0);
      }
      return true;
    } while (i == 0);
    localViewGroup.requestFocus();
    localViewGroup.playSoundEffect(0);
    return true;
  }
  
  private static boolean handleFolderAddItemKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = findFolderParent(paramView);
    paramView = (CellLayout)((Folder)localObject).findViewById(2131689687);
    CellLayoutChildren localCellLayoutChildren = (CellLayoutChildren)paramView.getChildAt(0);
    FolderEditText localFolderEditText = ((Folder)localObject).mFolderName;
    localObject = ((Folder)localObject).findViewById(2131689512);
    if (paramKeyEvent.getAction() != 1) {}
    for (int i = 1;; i = 0) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    if ((i != 0) && (localObject != null))
    {
      ((View)localObject).requestFocus();
      ((View)localObject).playSoundEffect(0);
    }
    return true;
    if (i != 0)
    {
      if (localCellLayoutChildren.getChildCount() == 0) {
        break label175;
      }
      paramView = getIconInDirection(paramView, localCellLayoutChildren, -1, 1);
      if (paramView != null)
      {
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
    }
    for (;;)
    {
      return true;
      label175:
      if (localObject != null)
      {
        ((View)localObject).requestFocus();
        ((View)localObject).playSoundEffect(0);
      }
    }
    if ((i != 0) && (localFolderEditText != null))
    {
      localFolderEditText.requestFocus();
      localFolderEditText.playSoundEffect(0);
    }
    return true;
  }
  
  private static boolean handleFolderColorViewItemsKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = findFolderParent(paramView);
    if (localObject == null) {
      return false;
    }
    CellLayout localCellLayout = (CellLayout)((Folder)localObject).findViewById(2131689687);
    CellLayoutChildren localCellLayoutChildren = (CellLayoutChildren)localCellLayout.getChildAt(0);
    View localView = ((Folder)localObject).findViewById(2131689524);
    ImageView localImageView = ((Folder)localObject).mFolderOptionButton;
    localObject = ((Folder)localObject).mFolderColorViews;
    paramView = getFolderColorViewKey(paramView);
    int i;
    if (paramKeyEvent.getAction() != 1) {
      i = 1;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 20: 
      if (i != 0)
      {
        if (localCellLayoutChildren.getChildCount() == 0) {
          break label149;
        }
        paramView = getIconInDirection(localCellLayout, localCellLayoutChildren, -1, 1);
        if (paramView != null)
        {
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
      }
      for (;;)
      {
        return true;
        i = 0;
        break;
        if (localView != null)
        {
          localView.requestFocus();
          localView.playSoundEffect(0);
        }
      }
    case 22: 
      label149:
      if (i != 0)
      {
        if (paramView != Folder.FolderColor.FOLDER_GREEN) {
          break label194;
        }
        localImageView.requestFocus();
        localImageView.playSoundEffect(0);
      }
      for (;;)
      {
        return true;
        label194:
        paramView = Folder.FolderColor.values()[(paramView.ordinal() + 1)];
        ((ImageView)((HashMap)localObject).get(paramView)).requestFocus();
        ((ImageView)((HashMap)localObject).get(paramView)).playSoundEffect(0);
      }
    }
    if (i != 0)
    {
      if (paramView != Folder.FolderColor.FOLDER_DEFAULT) {
        break label259;
      }
      localImageView.requestFocus();
      localImageView.playSoundEffect(0);
    }
    for (;;)
    {
      return true;
      label259:
      paramView = Folder.FolderColor.values()[(paramView.ordinal() - 1)];
      ((ImageView)((HashMap)localObject).get(paramView)).requestFocus();
      ((ImageView)((HashMap)localObject).get(paramView)).playSoundEffect(0);
    }
  }
  
  private static boolean handleFolderKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    CellLayoutChildren localCellLayoutChildren = (CellLayoutChildren)paramView.getParent();
    CellLayout localCellLayout = (CellLayout)localCellLayoutChildren.getParent();
    Object localObject = (Folder)((ScrollView)localCellLayout.getParent()).getParent();
    FolderEditText localFolderEditText = ((Folder)localObject).mFolderName;
    LinearLayout localLinearLayout = ((Folder)localObject).mFolderOptionView;
    View localView = ((Folder)localObject).findViewById(2131689524);
    localObject = ((Folder)localObject).findViewById(2131689512);
    if (paramKeyEvent.getAction() != 1) {}
    for (int i = 1;; i = 0) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    if (i != 0)
    {
      paramView = getIconInDirection(localCellLayout, localCellLayoutChildren, paramView, -1);
      if (paramView == null) {
        break label185;
      }
      paramView.requestFocus();
      paramView.playSoundEffect(0);
    }
    for (;;)
    {
      return true;
      label185:
      if (localObject != null)
      {
        ((View)localObject).requestFocus();
        ((View)localObject).playSoundEffect(0);
      }
      else
      {
        localFolderEditText.requestFocus();
        localFolderEditText.playSoundEffect(0);
      }
    }
    if (i != 0)
    {
      paramView = getIconInDirection(localCellLayout, localCellLayoutChildren, paramView, 1);
      if (paramView == null) {
        break label250;
      }
      paramView.requestFocus();
      paramView.playSoundEffect(0);
    }
    for (;;)
    {
      return true;
      label250:
      if ((localView != null) && (!localView.isFocused()))
      {
        localView.requestFocus();
        localView.playSoundEffect(0);
      }
    }
    if (i != 0)
    {
      paramView = getClosestIconOnLine(localCellLayout, localCellLayoutChildren, paramView, -1);
      if (paramView == null) {
        break label308;
      }
      paramView.requestFocus();
      paramView.playSoundEffect(0);
    }
    for (;;)
    {
      return true;
      label308:
      if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 0))
      {
        localLinearLayout.getChildAt(0).requestFocus();
        localLinearLayout.getChildAt(0).playSoundEffect(0);
      }
      else if (localFolderEditText != null)
      {
        localFolderEditText.requestFocus();
        localFolderEditText.playSoundEffect(0);
      }
    }
    if (i != 0)
    {
      paramView = getClosestIconOnLine(localCellLayout, localCellLayoutChildren, paramView, 1);
      if (paramView != null)
      {
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
    }
    return true;
    if (i != 0)
    {
      paramView = getIconInDirection(localCellLayout, localCellLayoutChildren, -1, 1);
      if (paramView != null)
      {
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
    }
    return true;
    if (i != 0)
    {
      paramView = getIconInDirection(localCellLayout, localCellLayoutChildren, localCellLayoutChildren.getChildCount(), -1);
      if (paramView != null)
      {
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
    }
    return true;
  }
  
  private static boolean handleFolderNameKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    Folder localFolder = findFolderParent(paramView);
    FolderEditText localFolderEditText = (FolderEditText)paramView;
    CellLayout localCellLayout = (CellLayout)localFolder.findViewById(2131689687);
    CellLayoutChildren localCellLayoutChildren = (CellLayoutChildren)localCellLayout.getChildAt(0);
    paramView = localFolder.findViewById(2131689512);
    int i;
    if (paramKeyEvent.getAction() != 1) {
      i = 1;
    }
    switch (paramInt)
    {
    default: 
    case 21: 
    case 22: 
    case 61: 
      do
      {
        do
        {
          do
          {
            return false;
            i = 0;
            break;
          } while ((i == 0) || (localFolderEditText.getSelectionStart() != 0) || (localFolderEditText.getSelectionEnd() != 0));
          return true;
        } while (i == 0);
        paramInt = localFolderEditText.length();
      } while ((localFolderEditText.getSelectionStart() != paramInt) || (localFolderEditText.getSelectionEnd() != paramInt));
      paramKeyEvent = getIconInDirection(localCellLayout, localCellLayoutChildren, -1, 1);
      if (paramView != null)
      {
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
      for (;;)
      {
        return true;
        if (paramKeyEvent != null)
        {
          paramKeyEvent.requestFocus();
          paramKeyEvent.playSoundEffect(0);
        }
      }
    case 19: 
      return true;
    case 20: 
      if ((i != 0) && (localCellLayoutChildren.getChildCount() != 0))
      {
        paramView = getIconInDirection(localCellLayout, localCellLayoutChildren, -1, 1);
        if (paramView != null)
        {
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
      }
      return true;
    }
    if (i != 0) {
      localFolder.close(true, true);
    }
    return true;
  }
  
  private static boolean handleFolderOptionsButtonKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = findFolderParent(paramView);
    paramView = (CellLayout)((Folder)localObject).findViewById(2131689687);
    CellLayoutChildren localCellLayoutChildren = (CellLayoutChildren)paramView.getChildAt(0);
    FolderEditText localFolderEditText = ((Folder)localObject).mFolderName;
    localObject = ((Folder)localObject).mFolderOptionView;
    if (paramKeyEvent.getAction() != 1) {}
    for (int i = 1;; i = 0) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    if (i != 0)
    {
      paramInt = localFolderEditText.length();
      if ((localFolderEditText.getSelectionStart() == paramInt) && (localFolderEditText.getSelectionEnd() == paramInt))
      {
        paramView = getIconInDirection(paramView, localCellLayoutChildren, -1, 1);
        if (paramView != null)
        {
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
      }
    }
    return true;
    if (i != 0)
    {
      if ((localObject == null) || (((LinearLayout)localObject).getVisibility() != 0)) {
        break label203;
      }
      ((LinearLayout)localObject).getChildAt(0).requestFocus();
      ((LinearLayout)localObject).getChildAt(0).playSoundEffect(0);
    }
    for (;;)
    {
      return true;
      label203:
      if (localFolderEditText != null)
      {
        localFolderEditText.requestFocus();
        localFolderEditText.playSoundEffect(0);
      }
    }
  }
  
  private static boolean handleHomeMagazineButtonKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    Workspace localWorkspace = (Workspace)((ViewGroup)((ViewGroup)paramView.getParent()).getParent()).getRootView().findViewById(2131689593);
    int i = localWorkspace.getCurrentPage();
    int k = localWorkspace.getPageCount();
    ((CellLayout)localWorkspace.getChildAt(localWorkspace.getCurrentPage())).getChildrenLayout();
    int j;
    if (paramKeyEvent.getAction() != 1)
    {
      j = 1;
      paramView = (String)paramView.getTag();
    }
    switch (paramInt)
    {
    default: 
    case 21: 
    case 22: 
      do
      {
        do
        {
          return false;
          j = 0;
          break;
        } while (j == 0);
        paramInt = i;
        if (!localWorkspace.mScroller.isFinished())
        {
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          paramInt = localWorkspace.getCurrentPage();
        }
        if (paramInt > 0) {
          i = paramInt - 1;
        }
        for (;;)
        {
          if (i != paramInt)
          {
            if (!Launcher.isHelpAppRunning) {
              localWorkspace.snapToPage(i);
            }
            paramView = getCellLayoutChildrenForIndex(localWorkspace, i);
            paramView = getIconInDirection((CellLayout)paramView.getParent(), paramView, paramView.getChildCount(), -1);
            if (paramView != null)
            {
              paramView.requestFocus();
              paramView.playSoundEffect(0);
            }
          }
          return true;
          if (sIsLoopingEnabled) {
            i = k - 1;
          } else {
            i = paramInt;
          }
        }
      } while (j == 0);
      paramInt = i;
      if (!localWorkspace.mScroller.isFinished())
      {
        localWorkspace.mScroller.abortAnimation();
        localWorkspace.computeScrollHelper();
        paramInt = localWorkspace.getCurrentPage();
      }
      if (paramInt < k - 1) {
        i = paramInt + 1;
      }
      for (;;)
      {
        if (i != paramInt)
        {
          if (!Launcher.isHelpAppRunning) {
            localWorkspace.snapToPage(i);
          }
          paramView = getCellLayoutChildrenForIndex(localWorkspace, i);
          paramKeyEvent = (CellLayout)paramView.getParent();
          paramView = getIconInDirection(paramKeyEvent, paramView, paramKeyEvent.getRootView(), 1);
          if (paramView != null)
          {
            paramView.requestFocus();
            paramView.playSoundEffect(0);
          }
        }
        return true;
        if (sIsLoopingEnabled) {
          i = 0;
        } else {
          i = paramInt;
        }
      }
    }
    return true;
  }
  
  private static boolean handleHomeOptionMenuonKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramView = (HomeScreenOptionMenu)paramView.getRootView().findViewById(2131689680);
    if (!Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) {
      paramView.removeView(paramView.findViewById(2131689563));
    }
    View localView = paramView.getFocusedChild();
    int i = paramView.indexOfChild(localView);
    if (paramKeyEvent.getAction() != 1) {}
    for (int j = 1;; j = 0) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    if (j != 0)
    {
      paramInt = i;
      if (i <= 0) {
        paramInt = paramView.getChildCount();
      }
      paramView = paramView.getChildAt(paramInt - 1);
      if (paramView != null)
      {
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
    }
    return true;
    if (j != 0)
    {
      paramInt = i;
      if (i >= paramView.getChildCount() - 1) {
        paramInt = -1;
      }
      paramView = paramView.getChildAt(paramInt + 1);
      if (paramView != null)
      {
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
    }
    return true;
    return true;
    if (j != 0)
    {
      if (!Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) {
        break label269;
      }
      if (i != 0) {
        break label233;
      }
      paramView.launchOptionWallpaper();
    }
    for (;;)
    {
      if (localView != null) {
        localView.playSoundEffect(0);
      }
      return true;
      label233:
      if (i == 1)
      {
        paramView.launchOptionWidgets();
      }
      else if (i == 2)
      {
        paramView.launchOptionSettings();
      }
      else if (i == 3)
      {
        paramView.launchOptionThemes();
        continue;
        label269:
        if (i == 0) {
          paramView.launchOptionWallpaper();
        } else if (i == 1) {
          paramView.launchOptionWidgets();
        } else if (i == 2) {
          paramView.launchOptionSettings();
        }
      }
    }
  }
  
  private static boolean handleHomeSoftkeyAllappsIconKeyEvent(View paramView, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    if (paramView == null) {
      return true;
    }
    Workspace localWorkspace = (Workspace)((ViewGroup)((ViewGroup)paramView.getParent()).getParent()).getRootView().findViewById(2131689593);
    paramInt2 = localWorkspace.getCurrentPage();
    int j = localWorkspace.getPageCount();
    CellLayout localCellLayout = (CellLayout)localWorkspace.getChildAt(paramInt2);
    int i;
    if (paramKeyEvent.getAction() != 1)
    {
      i = 1;
      paramKeyEvent = sHomeView.findViewById(2131689601);
      switch (paramInt1)
      {
      case 20: 
      default: 
        return false;
      case 19: 
        if (i != 0)
        {
          if (!localWorkspace.mScroller.isFinished())
          {
            localWorkspace.mScroller.abortAnimation();
            localWorkspace.computeScrollHelper();
            localWorkspace.getCurrentPage();
          }
          paramView = localCellLayout.getChildrenLayout();
          paramView = getIconInDirection(localCellLayout, paramView, paramView.getChildCount(), -1);
          if (paramView == null) {
            break label385;
          }
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
        break;
      }
    }
    for (;;)
    {
      return true;
      i = 0;
      break;
      if (i != 0)
      {
        paramInt1 = paramInt2;
        if (!localWorkspace.mScroller.isFinished())
        {
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          paramInt1 = localWorkspace.getCurrentPage();
        }
        if (paramInt1 >= j - 1) {
          break label254;
        }
        paramInt2 = paramInt1 + 1;
      }
      for (;;)
      {
        if (paramInt2 != paramInt1)
        {
          localWorkspace.snapToPage(paramInt2);
          paramView.requestFocus();
        }
        return true;
        label254:
        if (sIsLoopingEnabled) {
          paramInt2 = 0;
        } else {
          paramInt2 = paramInt1;
        }
      }
      if (i != 0)
      {
        if ((Launcher.is_TB) && (paramKeyEvent != null))
        {
          paramKeyEvent.requestFocus();
          paramKeyEvent.playSoundEffect(0);
        }
      }
      else {
        return true;
      }
      paramInt1 = paramInt2;
      if (!localWorkspace.mScroller.isFinished())
      {
        localWorkspace.mScroller.abortAnimation();
        localWorkspace.computeScrollHelper();
        paramInt1 = localWorkspace.getCurrentPage();
      }
      if (paramInt1 > 0) {
        paramInt2 = paramInt1 - 1;
      }
      for (;;)
      {
        if (paramInt2 != paramInt1)
        {
          localWorkspace.snapToPage(paramInt2);
          paramView.requestFocus();
        }
        if (paramView == null) {
          break;
        }
        paramView.requestFocus();
        break;
        if (sIsLoopingEnabled) {
          paramInt2 = j - 1;
        } else {
          paramInt2 = paramInt1;
        }
      }
      label385:
      localWorkspace.requestFocus();
    }
  }
  
  private static boolean handleHomeSoftkeyPhoneIconKeyEvent(View paramView, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    if (paramView == null) {
      return true;
    }
    Workspace localWorkspace = (Workspace)((ViewGroup)((ViewGroup)paramView.getParent()).getParent()).getRootView().findViewById(2131689593);
    paramInt2 = localWorkspace.getCurrentPage();
    int j = localWorkspace.getPageCount();
    CellLayout localCellLayout = (CellLayout)localWorkspace.getChildAt(paramInt2);
    int i;
    if (paramKeyEvent.getAction() != 1)
    {
      i = 1;
      paramKeyEvent = sHomeView.findViewById(2131689602);
      switch (paramInt1)
      {
      case 20: 
      default: 
        return false;
      case 19: 
        if (i != 0)
        {
          if (!localWorkspace.mScroller.isFinished())
          {
            localWorkspace.mScroller.abortAnimation();
            localWorkspace.computeScrollHelper();
            localWorkspace.getCurrentPage();
          }
          paramView = localCellLayout.getChildrenLayout();
          paramView = getIconInDirection(localCellLayout, paramView, paramView.getChildCount(), -1);
          if (paramView == null) {
            break label385;
          }
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
        break;
      }
    }
    for (;;)
    {
      return true;
      i = 0;
      break;
      if (i != 0)
      {
        if ((!Launcher.is_TB) || (paramKeyEvent == null)) {
          break label213;
        }
        paramKeyEvent.requestFocus();
        paramKeyEvent.playSoundEffect(0);
      }
      label213:
      label291:
      for (;;)
      {
        return true;
        paramInt1 = paramInt2;
        if (!localWorkspace.mScroller.isFinished())
        {
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          paramInt1 = localWorkspace.getCurrentPage();
        }
        if (paramInt1 < j - 1) {
          paramInt2 = paramInt1 + 1;
        }
        for (;;)
        {
          if (paramInt2 == paramInt1) {
            break label291;
          }
          localWorkspace.snapToPage(paramInt2);
          paramView.requestFocus();
          break;
          if (sIsLoopingEnabled) {
            paramInt2 = 0;
          } else {
            paramInt2 = paramInt1;
          }
        }
      }
      if (i != 0)
      {
        paramInt1 = paramInt2;
        if (!localWorkspace.mScroller.isFinished())
        {
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          paramInt1 = localWorkspace.getCurrentPage();
        }
        if (paramInt1 <= 0) {
          break label366;
        }
        paramInt2 = paramInt1 - 1;
      }
      for (;;)
      {
        if (paramInt2 != paramInt1)
        {
          localWorkspace.snapToPage(paramInt2);
          paramView.requestFocus();
        }
        if (paramView != null) {
          paramView.requestFocus();
        }
        return true;
        label366:
        if (sIsLoopingEnabled) {
          paramInt2 = j - 1;
        } else {
          paramInt2 = paramInt1;
        }
      }
      label385:
      localWorkspace.requestFocus();
    }
  }
  
  private static boolean handleHotseatButtonKeyEvent(View paramView, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    Workspace localWorkspace = (Workspace)((ViewGroup)((ViewGroup)paramView.getParent()).getParent()).getRootView().findViewById(2131689593);
    int i = localWorkspace.getCurrentPage();
    int k = localWorkspace.getPageCount();
    Object localObject = (CellLayout)localWorkspace.getChildAt(localWorkspace.getCurrentPage());
    CellLayoutChildren localCellLayoutChildren = ((CellLayout)localObject).getChildrenLayout();
    localObject = getIconInDirection((CellLayout)localObject, localCellLayoutChildren, localCellLayoutChildren.getChildCount(), -1);
    int j;
    boolean bool2;
    boolean bool1;
    if (paramKeyEvent.getAction() != 1)
    {
      j = 1;
      bool2 = false;
      switch (paramInt1)
      {
      default: 
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      j = 0;
      break;
      if (j != 0)
      {
        paramKeyEvent = (KeyEvent)localObject;
        paramInt1 = i;
        if (!localWorkspace.mScroller.isFinished())
        {
          if (localWorkspace.mScroller.timePassed() <= localWorkspace.mScroller.getDuration() / 2) {
            break label284;
          }
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          paramInt1 = localWorkspace.getCurrentPage();
          paramKeyEvent = (CellLayout)localWorkspace.getChildAt(localWorkspace.getCurrentPage());
          localObject = paramKeyEvent.getChildrenLayout();
          paramKeyEvent = getIconInDirection(paramKeyEvent, (ViewGroup)localObject, ((CellLayoutChildren)localObject).getChildCount(), -1);
        }
        if ((paramInt2 != 2) || (LauncherApplication.isLargeTabletLayout())) {
          break label380;
        }
        if (paramKeyEvent == null) {
          break label286;
        }
        paramKeyEvent.requestFocus();
        paramKeyEvent.playSoundEffect(0);
      }
      label284:
      label286:
      label378:
      label380:
      label511:
      for (;;)
      {
        bool1 = true;
        break;
        return true;
        if (paramInt1 > 0) {
          paramInt2 = paramInt1 - 1;
        }
        for (;;)
        {
          if (paramInt2 == paramInt1) {
            break label378;
          }
          if (!Launcher.isHelpAppRunning) {
            localWorkspace.snapToPage(paramInt2);
          }
          paramView = (CellLayout)localWorkspace.getChildAt(paramInt2);
          if (paramView == null) {
            break;
          }
          paramKeyEvent = paramView.getChildrenLayout();
          paramView = getIconInDirection(paramView, paramKeyEvent, paramView.getRootView(), paramKeyEvent.getChildCount());
          if (paramView == null) {
            break;
          }
          paramView.requestFocus();
          paramView.playSoundEffect(0);
          break;
          if (sIsLoopingEnabled) {
            paramInt2 = k - 1;
          } else {
            paramInt2 = paramInt1;
          }
        }
        continue;
        paramKeyEvent = (CellLayoutChildren)paramView.getParent();
        paramView = getIconInDirection((CellLayout)paramKeyEvent.getParent(), paramKeyEvent, paramView, -1);
        if (paramView != null)
        {
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
        else
        {
          if (paramInt1 > 0) {
            paramInt2 = paramInt1 - 1;
          }
          for (;;)
          {
            if (paramInt2 == paramInt1) {
              break label511;
            }
            if (!Launcher.isHelpAppRunning) {
              localWorkspace.snapToPage(paramInt2);
            }
            paramView = (CellLayout)localWorkspace.getChildAt(paramInt2);
            if (paramView == null) {
              break;
            }
            paramKeyEvent = paramView.getChildrenLayout();
            paramView = getIconInDirection(paramView, paramKeyEvent, paramView.getRootView(), paramKeyEvent.getChildCount());
            if (paramView == null) {
              break;
            }
            paramView.requestFocus();
            paramView.playSoundEffect(0);
            break;
            if (sIsLoopingEnabled) {
              paramInt2 = k - 1;
            } else {
              paramInt2 = paramInt1;
            }
          }
        }
      }
      if (j != 0)
      {
        paramInt1 = i;
        if (!localWorkspace.mScroller.isFinished())
        {
          if (localWorkspace.mScroller.timePassed() <= localWorkspace.mScroller.getDuration() / 2) {
            break label661;
          }
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          paramInt1 = localWorkspace.getCurrentPage();
        }
        if ((paramInt2 != 2) || (LauncherApplication.isLargeTabletLayout())) {
          break label679;
        }
        if (paramInt1 >= k - 1) {
          break label663;
        }
        paramInt2 = paramInt1 + 1;
        label596:
        if (paramInt2 != paramInt1)
        {
          if (!Launcher.isHelpAppRunning) {
            localWorkspace.snapToPage(paramInt2);
          }
          paramView = (CellLayout)localWorkspace.getChildAt(paramInt2);
          if (paramView != null)
          {
            paramView = getIconInDirection(paramView, paramView.getChildrenLayout(), paramView.getRootView(), 1);
            if (paramView != null)
            {
              paramView.requestFocus();
              paramView.playSoundEffect(0);
            }
          }
        }
      }
      label661:
      label663:
      label679:
      label806:
      for (;;)
      {
        bool1 = true;
        break;
        return true;
        if (sIsLoopingEnabled)
        {
          paramInt2 = 0;
          break label596;
        }
        paramInt2 = paramInt1;
        break label596;
        paramKeyEvent = (CellLayoutChildren)paramView.getParent();
        paramView = getIconInDirection((CellLayout)paramKeyEvent.getParent(), paramKeyEvent, paramView, 1);
        if (paramView != null)
        {
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
        else
        {
          if (paramInt1 < k - 1) {
            paramInt2 = paramInt1 + 1;
          }
          for (;;)
          {
            if (paramInt2 == paramInt1) {
              break label806;
            }
            if (!Launcher.isHelpAppRunning) {
              localWorkspace.snapToPage(paramInt2);
            }
            paramView = (CellLayout)localWorkspace.getChildAt(paramInt2);
            if (paramView == null) {
              break;
            }
            paramView = getIconInDirection(paramView, paramView.getChildrenLayout(), paramView.getRootView(), 1);
            if (paramView == null) {
              break;
            }
            paramView.requestFocus();
            paramView.playSoundEffect(0);
            break;
            if (sIsLoopingEnabled) {
              paramInt2 = 0;
            } else {
              paramInt2 = paramInt1;
            }
          }
        }
      }
      if (j != 0)
      {
        if (!localWorkspace.mScroller.isFinished())
        {
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          i = localWorkspace.getCurrentPage();
        }
        if ((paramInt2 != 2) || (LauncherApplication.isLargeTabletLayout())) {
          break label898;
        }
        paramKeyEvent = (CellLayoutChildren)paramView.getParent();
        paramView = getIconInDirection((CellLayout)paramKeyEvent.getParent(), paramKeyEvent, paramView, -1);
        if (paramView != null)
        {
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
      }
      for (;;)
      {
        bool1 = true;
        break;
        label898:
        if (is12KEYNaviKeyFocus(paramView)) {
          return false;
        }
        paramView = (CellLayout)localWorkspace.getChildAt(i);
        paramKeyEvent = paramView.getChildrenLayout();
        paramView = getIconInDirection(paramView, paramKeyEvent, paramKeyEvent.getChildCount(), -1);
        if (paramView != null)
        {
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
        else
        {
          localWorkspace.requestFocus();
        }
      }
      if (j != 0)
      {
        if (!localWorkspace.mScroller.isFinished())
        {
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          localWorkspace.getCurrentPage();
        }
        if ((paramInt2 == 2) && (!LauncherApplication.isLargeTabletLayout()))
        {
          paramKeyEvent = (CellLayoutChildren)paramView.getParent();
          paramView = getIconInDirection((CellLayout)paramKeyEvent.getParent(), paramKeyEvent, paramView, 1);
          if (paramView != null)
          {
            paramView.requestFocus();
            paramView.playSoundEffect(0);
          }
        }
      }
      bool1 = true;
      continue;
      bool1 = bool2;
      if (Launcher.isHelpAppRunning)
      {
        bool1 = bool2;
        if ((paramView instanceof AllappsIcon)) {
          if ((!"addapps".equals(GuideFragment.GMode)) && (!"add_widgets".equals(GuideFragment.GMode)))
          {
            bool1 = bool2;
            if (!"create_folder".equals(GuideFragment.GMode)) {}
          }
          else
          {
            localWorkspace.launchAllAppsIcon();
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private static boolean handleMenuAppGridIconKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    CellLayoutChildren localCellLayoutChildren = (CellLayoutChildren)paramView.getParent();
    CellLayoutMenu localCellLayoutMenu = (CellLayoutMenu)localCellLayoutChildren.getParent();
    CellLayout.LayoutParams localLayoutParams = (CellLayout.LayoutParams)paramView.getLayoutParams();
    int j = localCellLayoutMenu.getCountX();
    int m = localCellLayoutMenu.getCountY();
    MenuAppsGrid localMenuAppsGrid = (MenuAppsGrid)localCellLayoutMenu.getParent();
    int n = localCellLayoutChildren.getChildCount();
    int i1 = localMenuAppsGrid.indexToPage(localMenuAppsGrid.indexOfChild(localCellLayoutMenu));
    int i2 = localMenuAppsGrid.getChildCount();
    int i3 = localLayoutParams.cellX;
    int i4 = localLayoutParams.cellY;
    int k = i4 * j + i3;
    int i;
    if (paramKeyEvent.getAction() != 1)
    {
      i = 1;
      paramKeyEvent = paramView.getResources().getConfiguration();
    }
    switch (paramInt)
    {
    default: 
    case 21: 
    case 22: 
    case 19: 
    case 20: 
    case 23: 
    case 66: 
      do
      {
        return false;
        i = 0;
        break;
        if (i != 0)
        {
          if (k <= 0) {
            break label256;
          }
          paramView = getIconAtPosition(localCellLayoutChildren, k - 1, j);
          if (paramView != null)
          {
            paramView.requestFocus();
            paramView.playSoundEffect(0);
          }
        }
        for (;;)
        {
          return true;
          if (!Launcher.isHelpAppRunning) {
            if (i1 > 0)
            {
              paramView = getPage(localMenuAppsGrid, i1 - 1);
              if (paramView != null)
              {
                localMenuAppsGrid.snapToPageFromFocusHelper(i1 - 1, 2);
                paramView = getIconAtPosition((CellLayoutChildren)paramView, paramView.getChildCount() - 1, j);
                if (paramView != null)
                {
                  paramView.requestFocus();
                  paramView.playSoundEffect(0);
                }
              }
            }
            else if (sIsLoopingEnabled)
            {
              paramView = getPage(localMenuAppsGrid, i2 - 1);
              if (paramView != null)
              {
                localMenuAppsGrid.snapToPageFromFocusHelper(i2 - 1, 2);
                paramView = getIconAtPosition((CellLayoutChildren)paramView, paramView.getChildCount() - 1, j);
                if (paramView != null)
                {
                  paramView.requestFocus();
                  paramView.playSoundEffect(0);
                }
              }
            }
          }
        }
        if (i != 0)
        {
          if (k >= n - 1) {
            break label428;
          }
          paramView = getIconAtPosition(localCellLayoutChildren, k + 1, j);
          if (paramView != null)
          {
            paramView.requestFocus();
            paramView.playSoundEffect(0);
          }
        }
        for (;;)
        {
          return true;
          if (!Launcher.isHelpAppRunning) {
            if (i1 < i2 - 1)
            {
              paramView = getPage(localMenuAppsGrid, i1 + 1);
              if (paramView != null)
              {
                localMenuAppsGrid.snapToPageFromFocusHelper(i1 + 1, 3);
                paramView = getIconAtPosition((CellLayoutChildren)paramView, 0, j);
                if (paramView != null)
                {
                  paramView.requestFocus();
                  paramView.playSoundEffect(0);
                }
              }
            }
            else if (sIsLoopingEnabled)
            {
              paramView = getPage(localMenuAppsGrid, 0);
              if (paramView != null)
              {
                localMenuAppsGrid.snapToPageFromFocusHelper(0, 3);
                paramView = getIconAtPosition((CellLayoutChildren)paramView, 0, j);
                if (paramView != null)
                {
                  paramView.requestFocus();
                  paramView.playSoundEffect(0);
                }
              }
            }
          }
        }
        if (i != 0)
        {
          if (i4 <= 0) {
            break label590;
          }
          paramView = getIconAtPosition(localCellLayoutChildren, (i4 - 1) * j + i3, j);
          if (paramView != null)
          {
            paramView.requestFocus();
            paramView.playSoundEffect(0);
          }
        }
        for (;;)
        {
          return true;
          if (localMenuAppsGrid != null)
          {
            paramView = localMenuAppsGrid.getActiveTitleBarForState();
            if (paramView != null)
            {
              paramInt = paramView.getChildCount();
              if (paramInt > 0)
              {
                paramView = paramView.getChildAt(paramInt - 1);
                paramView.requestFocus();
                paramView.playSoundEffect(0);
              }
            }
          }
        }
        if ((i != 0) && (i4 < m - 1))
        {
          paramView = getIconAtPosition(localCellLayoutChildren, Math.min(n - 1, (i4 + 1) * j + i3), j);
          if (paramView != null)
          {
            paramView.requestFocus();
            paramView.playSoundEffect(0);
          }
        }
        return true;
        if (((paramView instanceof FolderIconView)) && (localMenuAppsGrid.isPageMoving())) {
          return true;
        }
      } while ((paramKeyEvent.keyboard == 3) && (paramKeyEvent.navigation == 2));
      paramKeyEvent = getIconAtPosition(localCellLayoutChildren, k, j);
      if ((i == 0) && (paramKeyEvent != null) && (localMenuAppsGrid.getState() != MenuAppsGrid.State.EDIT))
      {
        localMenuAppsGrid.onClick(paramView);
        paramKeyEvent.playSoundEffect(0);
      }
      for (;;)
      {
        return true;
        if ((i != 0) && (paramKeyEvent != null) && (localMenuAppsGrid.getState() == MenuAppsGrid.State.EDIT) && ((paramView instanceof FolderIconView)))
        {
          localMenuAppsGrid.onClick(paramView);
          paramKeyEvent.playSoundEffect(0);
        }
      }
    case 92: 
      if (i != 0)
      {
        if (i1 <= 0) {
          break label863;
        }
        paramView = getPage(localMenuAppsGrid, i1 - 1);
        if (paramView != null)
        {
          localMenuAppsGrid.snapToPage(i1 - 1);
          paramView = getIconAtPosition((CellLayoutChildren)paramView, 0, j);
          if (paramView != null)
          {
            paramView.requestFocus();
            paramView.playSoundEffect(0);
          }
        }
      }
      for (;;)
      {
        return true;
        if (k != 0)
        {
          paramView = getIconAtPosition(localCellLayoutChildren, 0, j);
          if (paramView != null)
          {
            paramView.requestFocus();
            paramView.playSoundEffect(0);
          }
        }
      }
    case 93: 
      if (i != 0)
      {
        if (i1 >= i2 - 1) {
          break label957;
        }
        paramView = getPage(localMenuAppsGrid, i1 + 1);
        if (paramView != null)
        {
          localMenuAppsGrid.snapToPage(i1 + 1);
          paramView = getIconAtPosition((CellLayoutChildren)paramView, 0, j);
          if (paramView != null)
          {
            paramView.requestFocus();
            paramView.playSoundEffect(0);
          }
        }
      }
      for (;;)
      {
        return true;
        paramInt = localCellLayoutChildren.getChildCount() - 1;
        if (k != paramInt)
        {
          paramView = getIconAtPosition(localCellLayoutChildren, paramInt, j);
          if (paramView != null)
          {
            paramView.requestFocus();
            paramView.playSoundEffect(0);
          }
        }
      }
    case 122: 
      label256:
      label428:
      label590:
      label863:
      label957:
      if ((i != 0) && (k != 0))
      {
        paramView = getIconAtPosition(localCellLayoutChildren, 0, j);
        if (paramView != null)
        {
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
      }
      return true;
    }
    if (i != 0)
    {
      paramInt = localCellLayoutChildren.getChildCount() - 1;
      if (k != paramInt)
      {
        paramView = getIconAtPosition(localCellLayoutChildren, paramInt, j);
        if (paramView != null)
        {
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
      }
    }
    return true;
  }
  
  static boolean handlePagedViewWidgetKeyEvent(PagedViewWidget paramPagedViewWidget, int paramInt, KeyEvent paramKeyEvent)
  {
    if (!(paramPagedViewWidget.getParent() instanceof PagedViewGridLayout)) {
      return false;
    }
    PagedViewGridLayout localPagedViewGridLayout = (PagedViewGridLayout)paramPagedViewWidget.getParent();
    MenuWidgets localMenuWidgets = (MenuWidgets)localPagedViewGridLayout.getParent();
    TabHost localTabHost = findTabHostParent(localMenuWidgets);
    TabWidget localTabWidget = (TabWidget)localTabHost.findViewById(16908307);
    View localView = ((MenuView)localTabHost).getMenuOrMarketButton();
    int j = localPagedViewGridLayout.indexOfChild(paramPagedViewWidget);
    int k = localPagedViewGridLayout.getChildCount();
    int m = localMenuWidgets.indexToPage(localMenuWidgets.indexOfChild(localPagedViewGridLayout));
    int n = localMenuWidgets.getChildCount();
    int i1 = localPagedViewGridLayout.getCellCountX();
    int i2 = localPagedViewGridLayout.getCellCountY();
    int i3 = j % i1;
    int i4 = j / i1;
    int i;
    ViewGroup localViewGroup;
    if (paramKeyEvent.getAction() != 1)
    {
      i = 1;
      localViewGroup = null;
      paramKeyEvent = null;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 19: 
      if (i != 0)
      {
        if (i4 <= 0) {
          break label584;
        }
        paramPagedViewWidget = localPagedViewGridLayout.getChildAt((i4 - 1) * i1 + i3);
        if (paramPagedViewWidget != null)
        {
          paramPagedViewWidget.requestFocus();
          paramPagedViewWidget.playSoundEffect(0);
        }
      }
    case 21: 
    case 22: 
      for (;;)
      {
        return true;
        i = 0;
        break;
        if (i != 0)
        {
          if (j <= 0) {
            break label317;
          }
          localPagedViewGridLayout.getChildAt(j - 1).requestFocus();
          localPagedViewGridLayout.getChildAt(j - 1).playSoundEffect(0);
        }
        for (;;)
        {
          return true;
          if (!Launcher.isHelpAppRunning) {
            if (m > 0)
            {
              paramPagedViewWidget = getPage(localMenuWidgets, m - 1);
              if (paramPagedViewWidget != null)
              {
                localMenuWidgets.snapToPage(m - 1);
                paramPagedViewWidget = paramPagedViewWidget.getChildAt(paramPagedViewWidget.getChildCount() - 1);
                if (paramPagedViewWidget != null)
                {
                  paramPagedViewWidget.requestFocus();
                  paramPagedViewWidget.playSoundEffect(0);
                }
              }
            }
            else if (sIsLoopingEnabled)
            {
              paramPagedViewWidget = getPage(localMenuWidgets, n - 1);
              if (paramPagedViewWidget != null)
              {
                localMenuWidgets.snapToPage(n - 1);
                paramPagedViewWidget = paramPagedViewWidget.getChildAt(paramPagedViewWidget.getChildCount() - 1);
                if (paramPagedViewWidget != null)
                {
                  paramPagedViewWidget.requestFocus();
                  paramPagedViewWidget.playSoundEffect(0);
                }
              }
            }
          }
        }
        if (i != 0)
        {
          if (j >= k - 1) {
            break label477;
          }
          localPagedViewGridLayout.getChildAt(j + 1).requestFocus();
          localPagedViewGridLayout.getChildAt(j + 1).playSoundEffect(0);
        }
        for (;;)
        {
          return true;
          if (!Launcher.isHelpAppRunning) {
            if (m < n - 1)
            {
              paramPagedViewWidget = getPage(localMenuWidgets, m + 1);
              if (paramPagedViewWidget != null)
              {
                localMenuWidgets.snapToPage(m + 1);
                paramPagedViewWidget = paramPagedViewWidget.getChildAt(0);
                if (paramPagedViewWidget != null)
                {
                  paramPagedViewWidget.requestFocus();
                  paramPagedViewWidget.playSoundEffect(0);
                }
              }
            }
            else if (sIsLoopingEnabled)
            {
              paramPagedViewWidget = getPage(localMenuWidgets, 0);
              if (paramPagedViewWidget != null)
              {
                localMenuWidgets.snapToPage(0);
                paramPagedViewWidget = paramPagedViewWidget.getChildAt(0);
                if (paramPagedViewWidget != null)
                {
                  paramPagedViewWidget.requestFocus();
                  paramPagedViewWidget.playSoundEffect(0);
                }
              }
            }
          }
        }
        if ((ViewGroup)localTabHost.findViewById(2131689664) != null) {
          return false;
        }
        if (localView != null)
        {
          localView.requestFocus();
          localView.playSoundEffect(0);
        }
        else
        {
          localTabWidget.requestFocus();
          localTabWidget.playSoundEffect(0);
        }
      }
    case 20: 
      if ((i != 0) && (i4 < i2 - 1))
      {
        paramPagedViewWidget = localPagedViewGridLayout.getChildAt(Math.min(k - 1, (i4 + 1) * i1 + i3));
        if ((paramPagedViewWidget != null) && (!paramPagedViewWidget.isFocused()))
        {
          paramPagedViewWidget.requestFocus();
          paramPagedViewWidget.playSoundEffect(0);
        }
      }
      return true;
    case 23: 
    case 66: 
      if (i != 0) {
        ((View.OnClickListener)localMenuWidgets).onClick(paramPagedViewWidget);
      }
      return true;
    case 92: 
      if (i != 0)
      {
        if (m <= 0) {
          break label761;
        }
        localViewGroup = getPage(localMenuWidgets, m - 1);
        paramPagedViewWidget = paramKeyEvent;
        if (localViewGroup == null) {}
      }
      for (paramPagedViewWidget = localViewGroup.getChildAt(0);; paramPagedViewWidget = localPagedViewGridLayout.getChildAt(0))
      {
        if (paramPagedViewWidget != null)
        {
          paramPagedViewWidget.requestFocus();
          paramPagedViewWidget.playSoundEffect(0);
        }
        return true;
      }
    case 93: 
      if (i != 0)
      {
        if (m >= n - 1) {
          break label823;
        }
        paramKeyEvent = getPage(localMenuWidgets, m + 1);
        paramPagedViewWidget = localViewGroup;
        if (paramKeyEvent == null) {}
      }
      for (paramPagedViewWidget = paramKeyEvent.getChildAt(0);; paramPagedViewWidget = localPagedViewGridLayout.getChildAt(k - 1))
      {
        if (paramPagedViewWidget != null)
        {
          paramPagedViewWidget.requestFocus();
          paramPagedViewWidget.playSoundEffect(0);
        }
        return true;
      }
    case 122: 
      label317:
      label477:
      label584:
      label761:
      label823:
      if (i != 0)
      {
        paramPagedViewWidget = localPagedViewGridLayout.getChildAt(0);
        if (paramPagedViewWidget != null)
        {
          paramPagedViewWidget.requestFocus();
          paramPagedViewWidget.playSoundEffect(0);
        }
      }
      return true;
    }
    if (i != 0)
    {
      localPagedViewGridLayout.getChildAt(k - 1).requestFocus();
      localPagedViewGridLayout.getChildAt(k - 1).playSoundEffect(0);
    }
    return true;
  }
  
  private static boolean handleQuickAllappsIconKeyEvent(View paramView, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    if (paramView == null) {
      return true;
    }
    QuickLaunch localQuickLaunch = (QuickLaunch)((LinearLayout)paramView.getParent()).getParent();
    Workspace localWorkspace = (Workspace)((FrameLayout)localQuickLaunch.getParent()).findViewById(2131689593);
    Object localObject = (QuickLaunch)((ViewGroup)localWorkspace.getParent()).findViewById(2131689607);
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = sHomeView.getQuickLaunchCamera();
    }
    localObject = localQuickLaunch.getAllappsIcon();
    int i;
    CellLayout localCellLayout;
    int k;
    int j;
    if (paramView != null)
    {
      paramView = paramView.getCameraIcon();
      i = localWorkspace.getCurrentPage();
      localCellLayout = (CellLayout)localWorkspace.getChildAt(i);
      k = localWorkspace.getChildCount();
      if (paramKeyEvent.getAction() == 1) {
        break label236;
      }
      j = 1;
      switch (paramInt1)
      {
      default: 
        return false;
      case 21: 
        label127:
        if (j != 0)
        {
          if (!localWorkspace.mScroller.isFinished())
          {
            localWorkspace.mScroller.abortAnimation();
            localWorkspace.computeScrollHelper();
            i = localWorkspace.getCurrentPage();
          }
          paramKeyEvent = getCellLayoutChildrenForIndex(localWorkspace, i);
          paramKeyEvent = getIconInDirection(localCellLayout, paramKeyEvent, paramKeyEvent.getChildCount(), -1);
          if ((paramKeyEvent == null) || (paramInt2 != 2)) {
            break label364;
          }
          paramKeyEvent.requestFocus();
        }
        break;
      }
    }
    for (;;)
    {
      return true;
      paramView = localQuickLaunch.getCameraIcon();
      break;
      label236:
      j = 0;
      break label127;
      if (j != 0)
      {
        paramInt1 = i;
        if (!localWorkspace.mScroller.isFinished())
        {
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          paramInt1 = localWorkspace.getCurrentPage();
        }
        if (paramInt1 >= k - 1) {
          break label323;
        }
        paramInt2 = paramInt1 + 1;
        if (paramInt2 != paramInt1)
        {
          paramView = getIconInDirection(localCellLayout, getCellLayoutChildrenForIndex(localWorkspace, paramInt2), -1, 1);
          if (paramView == null) {
            break label339;
          }
          paramView.requestFocus();
        }
      }
      for (;;)
      {
        return true;
        label323:
        if (sIsLoopingEnabled)
        {
          paramInt2 = 0;
          break;
        }
        paramInt2 = paramInt1;
        break;
        label339:
        localWorkspace.snapToPage(paramInt2);
        if ((localQuickLaunch != null) && (localObject != null)) {
          ((View)localObject).requestFocus();
        }
      }
      label364:
      if (paramView != null) {
        paramView.requestFocus();
      }
    }
  }
  
  private static boolean handleQuickCameraIconKeyEvent(View paramView, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    if (paramView == null) {
      return true;
    }
    Workspace localWorkspace = (Workspace)((FrameLayout)((QuickLaunch)((LinearLayout)paramView.getParent()).getParent()).getParent()).findViewById(2131689593);
    paramView = (ViewGroup)localWorkspace.getParent();
    Object localObject2 = (QuickLaunch)paramView.findViewById(2131689607);
    Object localObject1 = (QuickLaunch)paramView.findViewById(2131689606);
    paramView = (View)localObject2;
    if (localObject2 == null) {
      paramView = sHomeView.getQuickLaunchCamera();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = sHomeView.getQuickLaunch();
    }
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((QuickLaunch)localObject2).getAllappsIcon();
    }
    Object localObject3 = null;
    int i;
    int k;
    int j;
    if (paramView != null)
    {
      paramView = paramView.getCameraIcon();
      i = localWorkspace.getCurrentPage();
      localObject2 = (CellLayout)localWorkspace.getChildAt(i);
      k = localWorkspace.getChildCount();
      if (paramKeyEvent.getAction() == 1) {
        break label289;
      }
      j = 1;
    }
    switch (paramInt1)
    {
    default: 
      return false;
    case 21: 
      label165:
      if (j != 0)
      {
        paramInt1 = i;
        if (!localWorkspace.mScroller.isFinished())
        {
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          paramInt1 = localWorkspace.getCurrentPage();
        }
        if (paramInt1 <= 0) {
          break label295;
        }
        paramInt2 = paramInt1 - 1;
        label237:
        if (paramInt2 != paramInt1)
        {
          paramKeyEvent = getCellLayoutChildrenForIndex(localWorkspace, paramInt2);
          paramKeyEvent = getIconInDirection((CellLayout)localObject2, paramKeyEvent, paramKeyEvent.getChildCount(), -1);
          if (paramKeyEvent == null) {
            break label314;
          }
          paramKeyEvent.requestFocus();
        }
      }
      for (;;)
      {
        return true;
        paramView = (View)localObject3;
        if (localObject2 == null) {
          break;
        }
        paramView = ((QuickLaunch)localObject2).getCameraIcon();
        break;
        label289:
        j = 0;
        break label165;
        label295:
        if (sIsLoopingEnabled)
        {
          paramInt2 = k - 1;
          break label237;
        }
        paramInt2 = paramInt1;
        break label237;
        label314:
        if (paramView != null)
        {
          localWorkspace.snapToPage(paramInt2);
          paramView.requestFocus();
        }
      }
    }
    if (j != 0)
    {
      if (!localWorkspace.mScroller.isFinished())
      {
        localWorkspace.mScroller.abortAnimation();
        localWorkspace.computeScrollHelper();
        i = localWorkspace.getCurrentPage();
      }
      paramView = getIconInDirection((CellLayout)localObject2, getCellLayoutChildrenForIndex(localWorkspace, i), -1, 1);
      if ((paramView == null) || (paramInt2 != 2)) {
        break label400;
      }
      paramView.requestFocus();
    }
    for (;;)
    {
      return true;
      label400:
      if (localObject1 != null) {
        ((View)localObject1).requestFocus();
      }
    }
  }
  
  static boolean handleTabKeyEvent(AccessibleTabView paramAccessibleTabView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    if (!LauncherApplication.isTabletLayout()) {
      return false;
    }
    FocusOnlyTabWidget localFocusOnlyTabWidget = (FocusOnlyTabWidget)paramAccessibleTabView.getParent();
    TabHost localTabHost = findTabHostParent(localFocusOnlyTabWidget);
    ViewGroup localViewGroup = (ViewGroup)localTabHost.findViewById(16908305);
    int j = localFocusOnlyTabWidget.getTabCount();
    int k = localFocusOnlyTabWidget.getChildTabIndex(paramAccessibleTabView);
    if (paramKeyEvent.getAction() != 1) {}
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 19: 
        return true;
        i = 0;
      }
    }
    if ((i != 0) && (k > 0)) {
      localFocusOnlyTabWidget.getChildTabViewAt(k - 1).requestFocus();
    }
    return true;
    if (i != 0)
    {
      if (k >= j - 1) {
        break label173;
      }
      localFocusOnlyTabWidget.getChildTabViewAt(k + 1).requestFocus();
    }
    for (;;)
    {
      return true;
      label173:
      if (paramAccessibleTabView.getNextFocusRightId() != -1) {
        localTabHost.findViewById(paramAccessibleTabView.getNextFocusRightId()).requestFocus();
      }
    }
    if (i != 0)
    {
      localViewGroup.requestFocus();
      localViewGroup.playSoundEffect(0);
    }
    return true;
    return true;
  }
  
  private static boolean handleTitleBarKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramView = (MenuAppsGrid)paramView.getRootView().findViewById(2131689632);
    if (paramKeyEvent.getAction() != 1) {}
    for (int i = 1;; i = 0) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    View localView1;
    View localView2;
    if (i != 0)
    {
      paramKeyEvent = (ViewGroup)paramView.getActiveTitleBarForState().getChildAt(0);
      if (paramKeyEvent != null)
      {
        if (paramView.getState() != MenuAppsGrid.State.EDIT) {
          break label144;
        }
        paramView = paramKeyEvent.findViewById(2131689639);
        localView1 = paramKeyEvent.findViewById(2131689590);
        localView2 = paramKeyEvent.findViewById(2131689645);
        if ((localView1 == null) || (paramKeyEvent.getFocusedChild() != localView1) || (localView2 == null)) {
          break label155;
        }
        localView2.requestFocus();
        localView2.playSoundEffect(0);
      }
    }
    for (;;)
    {
      return true;
      label144:
      paramView = paramKeyEvent.findViewById(2131689641);
      break;
      label155:
      if ((localView2 != null) && (paramKeyEvent.getFocusedChild() == localView2) && (paramView != null))
      {
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
      else if (paramView != null)
      {
        paramView.playSoundEffect(0);
      }
    }
    if (i != 0)
    {
      paramKeyEvent = (ViewGroup)paramView.getActiveTitleBarForState().getChildAt(0);
      if (paramKeyEvent != null)
      {
        if (paramView.getState() != MenuAppsGrid.State.EDIT) {
          break label295;
        }
        paramView = paramKeyEvent.findViewById(2131689639);
        localView1 = paramKeyEvent.findViewById(2131689590);
        localView2 = paramKeyEvent.findViewById(2131689645);
        if ((localView2 == null) || (paramKeyEvent.getFocusedChild() != localView2) || (localView1 == null) || (!localView1.isEnabled())) {
          break label306;
        }
        localView1.requestFocus();
        localView1.playSoundEffect(0);
      }
    }
    for (;;)
    {
      return true;
      label295:
      paramView = paramKeyEvent.findViewById(2131689641);
      break;
      label306:
      if ((paramView != null) && (paramKeyEvent.getFocusedChild() == paramView) && (localView1 != null) && (localView1.isEnabled()))
      {
        localView1.requestFocus();
        localView1.playSoundEffect(0);
      }
      else if ((paramView != null) && (paramKeyEvent.getFocusedChild() == paramView) && (localView2 != null))
      {
        localView2.requestFocus();
        localView2.playSoundEffect(0);
      }
      else if (paramView != null)
      {
        paramView.playSoundEffect(0);
      }
    }
  }
  
  static boolean handleWidgetFolderPagedViewWidgetKeyEvent(MenuWidgets paramMenuWidgets, PagedViewWidget paramPagedViewWidget, int paramInt, KeyEvent paramKeyEvent)
  {
    GridLayout localGridLayout = (GridLayout)paramPagedViewWidget.getParent();
    int j = localGridLayout.indexOfChild(paramPagedViewWidget);
    int k = localGridLayout.getChildCount();
    int m = localGridLayout.getColumnCount();
    int n = k / 2;
    int i1 = j % m;
    int i2 = j / m;
    if (paramKeyEvent.getAction() != 1) {}
    for (int i = 1;; i = 0) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    if ((i != 0) && (j > 0))
    {
      localGridLayout.getChildAt(j - 1).requestFocus();
      localGridLayout.getChildAt(j - 1).playSoundEffect(0);
    }
    return true;
    if ((i != 0) && (j < k - 1))
    {
      localGridLayout.getChildAt(j + 1).requestFocus();
      localGridLayout.getChildAt(j + 1).playSoundEffect(0);
    }
    return true;
    if ((i != 0) && (i2 > 0))
    {
      paramMenuWidgets = localGridLayout.getChildAt((i2 - 1) * m + i1);
      if (paramMenuWidgets != null)
      {
        paramMenuWidgets.requestFocus();
        paramMenuWidgets.playSoundEffect(0);
      }
    }
    return true;
    if ((i != 0) && (i2 < n + k % 2 - 1))
    {
      paramMenuWidgets = localGridLayout.getChildAt(Math.min(k - 1, (i2 + 1) * m + i1));
      if ((paramMenuWidgets != null) && (!paramMenuWidgets.isFocused()))
      {
        paramMenuWidgets.requestFocus();
        paramMenuWidgets.playSoundEffect(0);
      }
    }
    return true;
    if ((i != 0) && (paramMenuWidgets != null)) {
      paramMenuWidgets.onClick(paramPagedViewWidget);
    }
    return true;
    if (i != 0) {}
    return true;
    if (i != 0) {}
    return true;
    if (i != 0)
    {
      paramMenuWidgets = localGridLayout.getChildAt(0);
      if (paramMenuWidgets != null)
      {
        paramMenuWidgets.requestFocus();
        paramMenuWidgets.playSoundEffect(0);
      }
    }
    return true;
    if (i != 0)
    {
      localGridLayout.getChildAt(k - 1).requestFocus();
      localGridLayout.getChildAt(k - 1).playSoundEffect(0);
    }
    return true;
  }
  
  private static boolean handleWorkspaceGoogleSearchKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (!LauncherApplication.isTabletLayout()) {}
    Workspace localWorkspace;
    ViewGroup localViewGroup;
    View localView2;
    View localView3;
    int i;
    int k;
    int j;
    do
    {
      return false;
      paramView = (ViewGroup)((ViewGroup)paramView.getParent().getParent()).getParent();
      localWorkspace = (Workspace)paramView.findViewById(2131689593);
      localViewGroup = (ViewGroup)paramView.findViewById(2131689610);
      localView2 = paramView.findViewById(2131689611);
      localView3 = paramView.findViewById(2131689612);
      View localView1 = paramView.findViewById(2131689595);
      paramView = localView1;
      if (localView1 == null) {
        paramView = sHomeView.getHotseat();
      }
      i = localWorkspace.getCurrentPage();
      k = localWorkspace.getPageCount() - 1;
      if (paramKeyEvent.getAction() != 1) {}
      for (j = 1;; j = 0) {
        switch (paramInt)
        {
        default: 
          return false;
        case 19: 
          if (j != 0)
          {
            if (!localWorkspace.mScroller.isFinished())
            {
              localWorkspace.mScroller.abortAnimation();
              localWorkspace.computeScrollHelper();
              i = localWorkspace.getCurrentPage();
            }
            paramView = (CellLayout)localWorkspace.getChildAt(i);
            if (paramView != null)
            {
              paramKeyEvent = paramView.getChildrenLayout();
              paramView = getIconInDirection(paramView, paramKeyEvent, paramKeyEvent.getChildCount(), -1);
              if (paramView != null) {
                paramView.requestFocus();
              }
            }
          }
          return true;
        }
      }
    } while ((j == 0) || (localViewGroup == null) || (!localViewGroup.getFocusedChild().equals(localView3)));
    localView2.requestFocus();
    localView2.playSoundEffect(0);
    return true;
    if (j != 0)
    {
      if (!localWorkspace.mScroller.isFinished())
      {
        localWorkspace.mScroller.abortAnimation();
        localWorkspace.computeScrollHelper();
        i = localWorkspace.getCurrentPage();
      }
      if (i <= 0) {
        break label408;
      }
      paramInt = Math.max(i - 1, 0);
      if (paramInt != i)
      {
        paramView = (CellLayout)localWorkspace.getChildAt(paramInt);
        localWorkspace.snapToPage(paramInt);
        paramKeyEvent = getCellLayoutChildrenForIndex(localWorkspace, paramInt);
        paramView = getIconInDirection(paramView, paramKeyEvent, paramKeyEvent.getChildCount(), -1);
        if (paramView == null) {
          break label425;
        }
        paramView.requestFocus();
      }
    }
    for (;;)
    {
      return true;
      label408:
      if (sIsLoopingEnabled)
      {
        paramInt = k;
        break;
      }
      paramInt = i;
      break;
      label425:
      localView2.requestFocus();
      localView2.playSoundEffect(0);
    }
    if (j != 0)
    {
      if ((localViewGroup == null) || (localViewGroup.getFocusedChild() != localView2)) {
        break label474;
      }
      localView3.requestFocus();
      localView3.playSoundEffect(0);
    }
    for (;;)
    {
      return true;
      label474:
      if ((localViewGroup != null) && (localViewGroup.getFocusedChild() == localView3))
      {
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
    }
    if (j != 0)
    {
      if (!localWorkspace.mScroller.isFinished())
      {
        localWorkspace.mScroller.abortAnimation();
        localWorkspace.computeScrollHelper();
        i = localWorkspace.getCurrentPage();
      }
      if (i >= k) {
        break label598;
      }
      paramInt = Math.min(i + 1, k);
      if (paramInt != i)
      {
        paramView = (CellLayout)localWorkspace.getChildAt(paramInt);
        localWorkspace.snapToPage(paramInt);
        paramView = getIconInDirection(paramView, getCellLayoutChildrenForIndex(localWorkspace, paramInt), -1, 1);
        if (paramView == null) {
          break label614;
        }
        paramView.requestFocus();
      }
    }
    for (;;)
    {
      return true;
      label598:
      if (sIsLoopingEnabled)
      {
        paramInt = 0;
        break;
      }
      paramInt = i;
      break;
      label614:
      localView2.requestFocus();
      localView2.playSoundEffect(0);
    }
    return true;
  }
  
  private static boolean handleWorkspaceIconKeyEvent(View paramView, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool;
    if ((paramView == null) || (!(paramView.getParent() instanceof CellLayoutChildren)))
    {
      bool = true;
      return bool;
    }
    CellLayoutChildren localCellLayoutChildren = (CellLayoutChildren)paramView.getParent();
    CellLayout localCellLayout = (CellLayout)localCellLayoutChildren.getParent();
    Workspace localWorkspace = (Workspace)localCellLayout.getParent();
    Object localObject2 = (ViewGroup)localWorkspace.getParent();
    Object localObject1 = null;
    label96:
    Object localObject4;
    Object localObject3;
    AllappsIcon localAllappsIcon;
    label199:
    View localView1;
    View localView2;
    Hotseat localHotseat1;
    int i;
    int k;
    int j;
    if (LauncherApplication.isTabletLayout())
    {
      localObject1 = (ViewGroup)((ViewGroup)localObject2).findViewById(2131689609);
      if (localObject1 != null) {
        localObject1 = ((ViewGroup)localObject1).findViewById(2131689611);
      }
    }
    else
    {
      Hotseat localHotseat2 = (Hotseat)((ViewGroup)localObject2).findViewById(2131689595);
      localObject4 = (QuickLaunch)((ViewGroup)localObject2).findViewById(2131689607);
      localObject2 = (QuickLaunch)((ViewGroup)localObject2).findViewById(2131689606);
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = sHomeView.getQuickLaunchCamera();
      }
      localObject4 = localObject2;
      if (localObject2 == null) {
        localObject4 = sHomeView.getQuickLaunch();
      }
      localAllappsIcon = null;
      if (localObject4 != null) {
        localAllappsIcon = ((QuickLaunch)localObject4).getAllappsIcon();
      }
      localObject2 = null;
      if (localObject3 == null) {
        break label398;
      }
      localObject2 = ((QuickLaunch)localObject3).getCameraIcon();
      localView1 = sHomeView.findViewById(2131689601);
      localView2 = sHomeView.findViewById(2131689602);
      localHotseat1 = localHotseat2;
      if (localHotseat2 == null) {
        localHotseat1 = sHomeView.getHotseat();
      }
      i = localWorkspace.indexOfChild(localCellLayout);
      k = localWorkspace.getChildCount();
      if (paramKeyEvent.getAction() == 1) {
        break label413;
      }
      j = 1;
      label265:
      bool = false;
      paramKeyEvent = paramView.getResources().getConfiguration();
    }
    switch (paramInt1)
    {
    default: 
      return false;
    case 19: 
      if (j != 0)
      {
        if (!localWorkspace.mScroller.isFinished())
        {
          localWorkspace.mScroller.abortAnimation();
          localWorkspace.computeScrollHelper();
          localWorkspace.getCurrentPage();
        }
        paramView = getClosestIconOnLine(localCellLayout, localCellLayoutChildren, paramView, -1);
        if (paramView == null) {
          break label905;
        }
        paramView.requestFocus();
        paramView.playSoundEffect(0);
      }
    case 66: 
    case 21: 
    case 22: 
      for (;;)
      {
        return true;
        localObject1 = null;
        break label96;
        label398:
        if (localObject4 == null) {
          break label199;
        }
        localObject2 = ((QuickLaunch)localObject4).getCameraIcon();
        break label199;
        label413:
        j = 0;
        break label265;
        if (paramKeyEvent.keyboard != 3) {
          break;
        }
        localWorkspace.setAllowLongPress(true);
        return false;
        if (j != 0)
        {
          paramInt1 = i;
          if (!localWorkspace.mScroller.isFinished())
          {
            localWorkspace.mScroller.abortAnimation();
            localWorkspace.computeScrollHelper();
            paramInt1 = localWorkspace.getCurrentPage();
          }
          paramView = getIconInDirection(localCellLayout, localCellLayoutChildren, paramView, -1);
          if (paramView == null) {
            break label500;
          }
          paramView.requestFocus();
          paramView.playSoundEffect(0);
        }
        for (;;)
        {
          return true;
          label500:
          if ((localObject3 != null) && (localObject2 != null) && (paramInt2 == 2))
          {
            ((View)localObject2).requestFocus();
          }
          else
          {
            if (paramInt1 > 0) {
              paramInt2 = paramInt1 - 1;
            }
            for (;;)
            {
              if (paramInt2 == paramInt1) {
                break label590;
              }
              paramView = getCellLayoutChildrenForIndex(localWorkspace, paramInt2);
              paramView = getIconInDirection(localCellLayout, paramView, paramView.getChildCount(), -1);
              if (paramView == null) {
                break label592;
              }
              paramView.requestFocus();
              paramView.playSoundEffect(0);
              break;
              if (sIsLoopingEnabled) {
                paramInt2 = k - 1;
              } else {
                paramInt2 = paramInt1;
              }
            }
            label590:
            continue;
            label592:
            if (!Launcher.isHelpAppRunning) {
              localWorkspace.snapToPage(paramInt2);
            }
            if (LauncherApplication.isTabletLayout())
            {
              if (localObject1 != null)
              {
                ((View)localObject1).requestFocus();
                ((View)localObject1).playSoundEffect(0);
              }
            }
            else if (localHotseat1 != null)
            {
              localHotseat1.requestFocus();
              localHotseat1.playSoundEffect(0);
            }
          }
        }
        if (j != 0)
        {
          paramInt1 = i;
          if (!localWorkspace.mScroller.isFinished())
          {
            localWorkspace.mScroller.abortAnimation();
            localWorkspace.computeScrollHelper();
            paramInt1 = localWorkspace.getCurrentPage();
          }
          paramKeyEvent = getIconInDirection(localCellLayout, localCellLayoutChildren, paramView, 1);
          if (paramKeyEvent == null) {
            break label715;
          }
          paramKeyEvent.requestFocus();
          paramKeyEvent.playSoundEffect(0);
        }
        label715:
        label807:
        label809:
        do
        {
          for (;;)
          {
            return true;
            if ((localObject3 != null) && (localAllappsIcon != null) && (paramInt2 == 2))
            {
              localAllappsIcon.requestFocus();
              localAllappsIcon.playSoundEffect(0);
            }
            else
            {
              if (paramInt1 < k - 1) {
                paramInt2 = paramInt1 + 1;
              }
              for (;;)
              {
                if (paramInt2 == paramInt1) {
                  break label807;
                }
                paramKeyEvent = getIconInDirection(localCellLayout, getCellLayoutChildrenForIndex(localWorkspace, paramInt2), -1, 1);
                if (paramKeyEvent == null) {
                  break label809;
                }
                paramKeyEvent.requestFocus();
                paramKeyEvent.playSoundEffect(0);
                break;
                if (sIsLoopingEnabled) {
                  paramInt2 = 0;
                } else {
                  paramInt2 = paramInt1;
                }
              }
              continue;
              if (!Launcher.isHelpAppRunning) {
                localWorkspace.snapToPage(paramInt2);
              }
              if (!LauncherApplication.isTabletLayout()) {
                break;
              }
              if (localObject1 != null)
              {
                ((View)localObject1).requestFocus();
                ((View)localObject1).playSoundEffect(0);
              }
            }
          }
        } while (localHotseat1 == null);
        if ((is12KEYNaviKeyFocus(paramView)) && (localHotseat1.mContent != null))
        {
          paramView = localHotseat1.mContent.getChildAt(0, 0);
          if (paramView != null) {
            paramView.requestFocus();
          }
        }
        for (;;)
        {
          localHotseat1.playSoundEffect(0);
          break;
          localHotseat1.requestFocus();
        }
        label905:
        if ((localHotseat1 != null) && (paramInt2 == 2) && (!LauncherApplication.isLargeTabletLayout()))
        {
          localHotseat1.requestFocus();
          localHotseat1.playSoundEffect(0);
        }
      }
    }
    if (j != 0)
    {
      if (!localWorkspace.mScroller.isFinished())
      {
        localWorkspace.mScroller.abortAnimation();
        localWorkspace.computeScrollHelper();
        localWorkspace.getCurrentPage();
      }
      paramKeyEvent = getClosestIconOnLine(localCellLayout, localCellLayoutChildren, paramView, 1);
      if (paramKeyEvent == null) {
        break label998;
      }
      paramKeyEvent.requestFocus();
      paramKeyEvent.playSoundEffect(0);
    }
    for (;;)
    {
      return true;
      label998:
      if (is12KEYNaviKeyFocus(paramView)) {
        return false;
      }
      if ((localHotseat1 != null) && (!LauncherApplication.isTabletLayout()))
      {
        localHotseat1.requestFocus();
        localHotseat1.playSoundEffect(0);
      }
      else if (localObject1 != null)
      {
        ((View)localObject1).requestFocus();
        ((View)localObject1).playSoundEffect(0);
      }
      else if ((localObject4 != null) && (localAllappsIcon != null) && (paramInt2 == 1))
      {
        localAllappsIcon.requestFocus();
        localAllappsIcon.playSoundEffect(0);
      }
      else if ((Launcher.is_TB) && (localView1 != null))
      {
        localView1.requestFocus();
        localView1.playSoundEffect(0);
      }
      else if ((Launcher.is_TB) && (localView2 != null))
      {
        localView2.requestFocus();
        localView2.playSoundEffect(0);
      }
    }
  }
  
  static boolean is12KEYNaviKeyFocus(View paramView)
  {
    paramView = paramView.getResources().getConfiguration();
    return (paramView.keyboard == 3) && (paramView.navigation == 2);
  }
  
  public static void setup(HomeView paramHomeView)
  {
    sHomeView = paramHomeView;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/FocusHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */