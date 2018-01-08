package com.android.launcher2;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MenuWidgetsSearch
  implements View.OnKeyListener, SearchView.OnQueryTextListener, View.OnClickListener
{
  private static final String MENU_WIDGET_KEYBOARD_IS_UP = "MENU_WIDGET_KEYBOARD_IS_UP";
  private static final String MENU_WIDGET_SEARCH_PATTERN = "MENU_WIDGET_SEARCH_PATTERN";
  private View mMenuSelBackDown = null;
  private MenuWidgets mMenuWidgets;
  private SearchView mSearchEdit;
  private boolean mSkippedFirst = false;
  private MenuTitleBarManager mTitleBarManager;
  
  public MenuWidgetsSearch(MenuView paramMenuView, MenuWidgets paramMenuWidgets)
  {
    this.mMenuWidgets = paramMenuWidgets;
    paramMenuWidgets = paramMenuView.getTitleBarManager().getActiveTitleBarForState(paramMenuWidgets.getWidgetState());
    this.mSearchEdit = ((SearchView)paramMenuWidgets.findViewById(2131689671));
    this.mSearchEdit.onActionViewCollapsed();
    this.mSearchEdit.onActionViewExpanded();
    this.mSearchEdit.setImeOptions(33554435);
    if (LauncherApplication.isWidgetSearchTextColorLight())
    {
      int i = this.mSearchEdit.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
      AutoCompleteTextView localAutoCompleteTextView = (AutoCompleteTextView)this.mSearchEdit.findViewById(i);
      if (localAutoCompleteTextView != null) {
        localAutoCompleteTextView.setTextColor(-16777216);
      }
    }
    this.mMenuSelBackDown = paramMenuWidgets.findViewById(2131689633);
    this.mTitleBarManager = paramMenuView.getTitleBarManager();
  }
  
  public void closeKeyboard()
  {
    if (this.mSearchEdit.hasFocus()) {
      this.mSearchEdit.clearFocus();
    }
  }
  
  public void enter(MenuWidgets.WidgetState paramWidgetState, List<Animator> paramList)
  {
    this.mSearchEdit.setOnKeyListener(this);
    this.mSearchEdit.setOnQueryTextListener(this);
    if (paramWidgetState == null) {}
    for (boolean bool = true;; bool = false)
    {
      this.mTitleBarManager.changeTitleBar(paramList, this.mMenuWidgets.getWidgetState(), bool);
      this.mSkippedFirst = false;
      this.mMenuWidgets.setFilter(new SearchFilter());
      if (this.mMenuSelBackDown != null) {
        this.mMenuSelBackDown.setOnClickListener(this);
      }
      if (((Launcher)this.mSearchEdit.getContext()).getMenuView().isVisible()) {
        this.mSearchEdit.requestFocus();
      }
      if (paramWidgetState != MenuWidgets.WidgetState.NORMAL) {
        this.mMenuWidgets.runFilter();
      }
      return;
    }
  }
  
  public void exit(List<Animator> paramList)
  {
    this.mSearchEdit.performAccessibilityAction(128, null);
    this.mSearchEdit.setOnKeyListener(null);
    this.mSearchEdit.setOnQueryTextListener(null);
    if (this.mMenuSelBackDown != null)
    {
      this.mMenuSelBackDown.performAccessibilityAction(128, null);
      this.mMenuSelBackDown.setOnClickListener(null);
    }
    this.mMenuWidgets.setFilter(null);
    if (!this.mSearchEdit.getQuery().toString().isEmpty())
    {
      this.mSearchEdit.setQuery("", true);
      if (!this.mMenuWidgets.mDragOnSearchState) {
        this.mMenuWidgets.runFilter();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.mMenuSelBackDown)
    {
      this.mMenuSelBackDown.performAccessibilityAction(128, null);
      this.mMenuWidgets.changeToWidgetStateNormal();
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramKeyEvent.getAction() == 0) && (paramInt == 66);
  }
  
  public boolean onQueryTextChange(String paramString)
  {
    if ((this.mSkippedFirst) || (!paramString.isEmpty())) {
      this.mMenuWidgets.runFilter();
    }
    this.mSkippedFirst = true;
    return false;
  }
  
  public boolean onQueryTextSubmit(String paramString)
  {
    closeKeyboard();
    return false;
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.mSearchEdit.requestFocus();
    }
  }
  
  public void restore(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.mSearchEdit.setQuery(paramBundle.getString("MENU_WIDGET_SEARCH_PATTERN", ""), true);
      if (paramBundle.getBoolean("MENU_WIDGET_KEYBOARD_IS_UP", true)) {
        this.mSearchEdit.setIconified(false);
      }
    }
    else
    {
      return;
    }
    this.mSearchEdit.clearFocus();
  }
  
  public void save(Bundle paramBundle)
  {
    paramBundle.putString("MENU_WIDGET_SEARCH_PATTERN", this.mSearchEdit.getQuery().toString());
    paramBundle.putBoolean("MENU_WIDGET_KEYBOARD_IS_UP", ((InputMethodManager)this.mSearchEdit.getContext().getSystemService("input_method")).isAcceptingText());
  }
  
  class SearchFilter
    implements MenuWidgets.Filter
  {
    SearchFilter() {}
    
    public List<AvailableWidget> filterWidgets(List<AvailableWidget> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      String str = MenuWidgetsSearch.this.mSearchEdit.getQuery().toString().toUpperCase();
      MenuWidgetsSearch.this.mMenuWidgets.setSearchString(str);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        AvailableWidget localAvailableWidget = (AvailableWidget)paramList.next();
        if (localAvailableWidget.getLabel().toUpperCase().indexOf(str) != -1) {
          localArrayList.add(localAvailableWidget);
        }
      }
      return localArrayList;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MenuWidgetsSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */