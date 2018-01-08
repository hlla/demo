package com.android.launcher2;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;

public class MenuViewTypeDialog
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private static final String sFragmentTag = "MenuViewTypeDialog";
  private final String[] choices;
  
  public MenuViewTypeDialog()
  {
    if ((LauncherApplication.isTabletLayout()) || (!LauncherApplication.isAppsListAllowed())) {}
    for (int i = 2;; i = 3)
    {
      this.choices = new String[i];
      return;
    }
  }
  
  static void createAndShow(MenuView.ViewType paramViewType, FragmentManager paramFragmentManager)
  {
    if (isActive(paramFragmentManager)) {
      return;
    }
    MenuViewTypeDialog localMenuViewTypeDialog = new MenuViewTypeDialog();
    int i = -1;
    switch (paramViewType)
    {
    }
    for (;;)
    {
      paramViewType = new Bundle();
      paramViewType.putInt("selected", i);
      localMenuViewTypeDialog.setArguments(paramViewType);
      localMenuViewTypeDialog.show(paramFragmentManager, "MenuViewTypeDialog");
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  static void dismiss(FragmentTransaction paramFragmentTransaction, FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("MenuViewTypeDialog");
    if (paramFragmentManager != null)
    {
      paramFragmentManager.dismiss();
      paramFragmentTransaction.remove(paramFragmentManager);
    }
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return paramFragmentManager.findFragmentByTag("MenuViewTypeDialog") != null;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MenuView.ViewType localViewType;
    if (paramInt != -2) {
      switch (paramInt)
      {
      default: 
        localViewType = MenuView.ViewType.CUSTOM_GRID;
      }
    }
    for (;;)
    {
      if (getActivity() != null)
      {
        MenuView localMenuView = ((Launcher)getActivity()).getMenuView();
        if (localMenuView != null) {
          localMenuView.setViewType(localViewType);
        }
      }
      paramDialogInterface.dismiss();
      return;
      localViewType = MenuView.ViewType.ALPHABETIC_GRID;
      continue;
      localViewType = MenuView.ViewType.ALPHABETIC_LIST;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getResources();
    this.choices[0] = paramBundle.getString(2131755128);
    this.choices[1] = paramBundle.getString(2131755129);
    if ((!LauncherApplication.isTabletLayout()) && (LauncherApplication.isAppsListAllowed())) {
      this.choices[2] = paramBundle.getString(2131755130);
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    int i = getArguments().getInt("selected");
    return new AlertDialog.Builder(paramBundle).setTitle(2131755127).setSingleChoiceItems(this.choices, i, this).setNegativeButton(2131755131, this).create();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MenuViewTypeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */