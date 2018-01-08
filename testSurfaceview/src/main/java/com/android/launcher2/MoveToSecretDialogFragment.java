package com.android.launcher2;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class MoveToSecretDialogFragment
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private static final String TAG = "MoveToSecretDialog";
  private static MoveToSecretDialogFragment f;
  private static final String sFragmentTag = "MoveToSecretDialog";
  private View mView = null;
  
  static void createAndShow(FragmentManager paramFragmentManager)
  {
    if (isActive(paramFragmentManager)) {
      return;
    }
    f = new MoveToSecretDialogFragment();
    f.show(paramFragmentManager, "MoveToSecretDialog");
  }
  
  static void dismiss(FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("MoveToSecretDialog");
    if (paramFragmentManager != null) {
      paramFragmentManager.dismissAllowingStateLoss();
    }
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return paramFragmentManager.findFragmentByTag("MoveToSecretDialog") != null;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = (Launcher)getActivity();
    if (localObject == null) {
      Log.d("MoveToSecretDialog", "onClick: getActivity fail.");
    }
    do
    {
      return;
      localObject = ((Launcher)localObject).getMenuView().getMenuAppsGrid();
      if (paramInt == -1)
      {
        if ((localObject != null) && (this.mView != null))
        {
          ((MenuAppsGrid)localObject).saveSecretNoti(Boolean.valueOf(((CheckBox)this.mView.findViewById(2131689674)).isChecked()));
          ((MenuAppsGrid)localObject).completeMoveSecretItem();
        }
        paramDialogInterface.dismiss();
        return;
      }
    } while (paramInt != -2);
    onCancel(paramDialogInterface);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    Object localObject = getActivity();
    paramBundle = ((Launcher)getActivity()).getMenuView().getMenuAppsGrid();
    localObject = new AlertDialog.Builder((Context)localObject);
    View localView = getActivity().getLayoutInflater().inflate(2130903120, null);
    this.mView = localView;
    CheckBox localCheckBox = (CheckBox)localView.findViewById(2131689674);
    if (localCheckBox != null)
    {
      localCheckBox.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView) {}
      });
      localCheckBox.setChecked(paramBundle.isReminderChecked());
    }
    ((AlertDialog.Builder)localObject).setTitle(2131755258);
    ((AlertDialog.Builder)localObject).setPositiveButton(2131755187, this);
    ((AlertDialog.Builder)localObject).setNegativeButton(2131755018, this);
    ((AlertDialog.Builder)localObject).setView(localView);
    ((AlertDialog.Builder)localObject).setCancelable(true);
    return ((AlertDialog.Builder)localObject).create();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/MoveToSecretDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */