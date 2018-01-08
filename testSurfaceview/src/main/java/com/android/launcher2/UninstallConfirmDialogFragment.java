package com.android.launcher2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.admin.DevicePolicyManager;
import android.app.enterprise.ApplicationPolicy;
import android.app.enterprise.EnterpriseDeviceManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

public class UninstallConfirmDialogFragment
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private static final String TAG = "UninstallConfirmDialogFragment";
  private static final String sFragmentTag = "UninstallConfirm";
  private String mPackage;
  private String mPackageLabel;
  private boolean mReset;
  
  private boolean blockUninsatll()
  {
    boolean bool1 = false;
    try
    {
      EnterpriseDeviceManager localEnterpriseDeviceManager = (EnterpriseDeviceManager)getActivity().getSystemService("enterprise_policy");
      DevicePolicyManager localDevicePolicyManager = (DevicePolicyManager)getActivity().getSystemService("device_policy");
      if (localEnterpriseDeviceManager.getApplicationPolicy().getApplicationUninstallationEnabled(this.mPackage))
      {
        boolean bool2 = localDevicePolicyManager.packageHasActiveAdmins(this.mPackage);
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("UninstallConfirmDialogFragment", "EnterpriseDeviceManager is not getting started" + localNullPointerException);
    }
    return false;
  }
  
  static void createAndShow(String paramString1, String paramString2, FragmentManager paramFragmentManager)
  {
    createAndShow(paramString1, paramString2, paramFragmentManager, false);
  }
  
  static void createAndShow(String paramString1, String paramString2, FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    if ((isActive(paramFragmentManager)) || (paramString2 == null)) {
      return;
    }
    UninstallConfirmDialogFragment localUninstallConfirmDialogFragment = new UninstallConfirmDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("package", paramString1);
    localBundle.putString("label", paramString2);
    localBundle.putBoolean("reset", paramBoolean);
    localUninstallConfirmDialogFragment.setArguments(localBundle);
    localUninstallConfirmDialogFragment.show(paramFragmentManager, "UninstallConfirm");
  }
  
  static void dismiss(FragmentTransaction paramFragmentTransaction, FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("UninstallConfirm");
    if (paramFragmentManager != null)
    {
      paramFragmentManager.dismiss();
      paramFragmentTransaction.remove(paramFragmentManager);
    }
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return paramFragmentManager.findFragmentByTag("UninstallConfirm") != null;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = getActivity().getPackageManager();
    if (paramInt == -1) {}
    try
    {
      paramDialogInterface.deletePackage(this.mPackage, null, 0);
      return;
    }
    catch (SecurityException paramDialogInterface)
    {
      Log.e("UninstallConfirmDialogFragment", "Problem uninstalling package. This should only happen when installed outside of /system/app.", paramDialogInterface);
      Toast.makeText(getActivity(), "Not installed with permissions needed for uninstalling", 0).show();
      return;
    }
    catch (NullPointerException paramDialogInterface)
    {
      Log.e("UninstallConfirmDialogFragment", "Problem uninstalling package. This should only happen when either Activity or PackageManager is NULL.", paramDialogInterface);
      Toast.makeText(getActivity(), "Unable to install, please try again !", 0).show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mPackage = getArguments().getString("package");
    this.mPackageLabel = getArguments().getString("label");
    this.mReset = getArguments().getBoolean("reset");
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    Activity localActivity = getActivity();
    if (LauncherApplication.RemovablePreloadEnabled == 1) {
      if (Launcher.mRemovablePreloadAppItems.contains(this.mPackage))
      {
        paramBundle = localActivity.getResources().getString(2131755250, new Object[] { this.mPackageLabel });
        if (!this.mReset) {
          break label136;
        }
      }
    }
    label136:
    for (int i = 2131755054;; i = 2131755125)
    {
      return new AlertDialog.Builder(localActivity).setTitle(2131755123).setMessage(paramBundle).setPositiveButton(i, this).setNegativeButton(2131755126, this).create();
      paramBundle = localActivity.getResources().getString(2131755124, new Object[] { this.mPackageLabel });
      break;
      paramBundle = localActivity.getResources().getString(2131755124, new Object[] { this.mPackageLabel });
      break;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (blockUninsatll()) {
      ((AlertDialog)getDialog()).getButton(-1).setEnabled(false);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/UninstallConfirmDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */