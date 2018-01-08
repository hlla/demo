package com.android.launcher2;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;

public class DeleteWorkscreenDialogFragment
  extends DialogFragment
  implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener
{
  private static final String TAG = "DeleteWorkscreenDialogFragment";
  private static final String sFragmentTag = "DeleteWorkscreenDialog";
  
  static void createAndShow(FragmentManager paramFragmentManager)
  {
    if (isActive(paramFragmentManager)) {
      return;
    }
    new DeleteWorkscreenDialogFragment().show(paramFragmentManager, "DeleteWorkscreenDialog");
  }
  
  static void dismiss(FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("DeleteWorkscreenDialog");
    if (paramFragmentManager != null) {
      paramFragmentManager.dismissAllowingStateLoss();
    }
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return paramFragmentManager.findFragmentByTag("DeleteWorkscreenDialog") != null;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    paramDialogInterface = (Launcher)getActivity();
    if (paramDialogInterface == null)
    {
      Log.d("DeleteWorkscreenDialogFragment", "onCancel: getActivity fail.");
      return;
    }
    paramDialogInterface.mHomeView.cancelRemovePage();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (Launcher)getActivity();
    if (paramDialogInterface == null) {
      Log.d("DeleteWorkscreenDialogFragment", "onClick: getActivity fail.");
    }
    do
    {
      return;
      if (paramInt == -1)
      {
        paramDialogInterface.mHomeView.removePage();
        return;
      }
    } while (paramInt != -2);
    paramDialogInterface.mHomeView.cancelRemovePage();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new AlertDialog.Builder(getActivity());
    paramBundle.setTitle(2131755135).setMessage(2131755008).setPositiveButton(2131755021, this).setNegativeButton(2131755018, this);
    return paramBundle.create();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DeleteWorkscreenDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */