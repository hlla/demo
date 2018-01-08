package com.android.launcher2;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class AddAppsWidgetToastPopUp
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private static final String sFragmentTag = "AddAppsWidgetToastPopUp";
  private DialogCheckBoxListener mDialogCheckBoxListener = new DialogCheckBoxListener();
  private View mView = null;
  CheckBox toastRepeat = null;
  
  static void createAndShow(FragmentManager paramFragmentManager)
  {
    if (isActive(paramFragmentManager)) {
      return;
    }
    new AddAppsWidgetToastPopUp().show(paramFragmentManager, "AddAppsWidgetToastPopUp");
  }
  
  static void dismiss(FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("AddAppsWidgetToastPopUp");
    if (paramFragmentManager != null) {
      paramFragmentManager.dismissAllowingStateLoss();
    }
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFragmentManager != null)
    {
      bool1 = bool2;
      if (paramFragmentManager.findFragmentByTag("AddAppsWidgetToastPopUp") != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      Launcher localLauncher = (Launcher)getActivity();
      if ((localLauncher != null) && (this.mView != null)) {
        localLauncher.saveToastPopup(Boolean.valueOf(((CheckBox)this.mView.findViewById(2131689490)).isChecked()));
      }
      paramDialogInterface.dismiss();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    Object localObject = getActivity();
    paramBundle = (Launcher)getActivity();
    View localView = View.inflate((Context)localObject, 2130903040, null);
    this.mView = localView;
    localObject = new AlertDialog.Builder((Context)localObject);
    ((AlertDialog.Builder)localObject).setTitle(getString(2131755033));
    ((AlertDialog.Builder)localObject).setView(localView);
    ((AlertDialog.Builder)localObject).setPositiveButton(2131755142, this);
    localObject = ((AlertDialog.Builder)localObject).create();
    this.toastRepeat = ((CheckBox)localView.findViewById(2131689490));
    if (this.toastRepeat != null)
    {
      this.toastRepeat.setOnClickListener(this.mDialogCheckBoxListener);
      this.toastRepeat.setChecked(paramBundle.isDialogChecked());
    }
    return (Dialog)localObject;
  }
  
  public class DialogCheckBoxListener
    implements View.OnClickListener
  {
    public DialogCheckBoxListener() {}
    
    public void onClick(View paramView) {}
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/AddAppsWidgetToastPopUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */