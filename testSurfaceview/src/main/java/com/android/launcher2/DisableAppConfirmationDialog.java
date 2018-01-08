package com.android.launcher2;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Locale;

public class DisableAppConfirmationDialog
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private static final String TAG = "DisableAppConfirmationDialog";
  private static boolean isUninstall = false;
  private static final String sFragmentTag = "DisableAppConfirm";
  private DialogCheckBoxListener mDialogCheckBoxListener = new DialogCheckBoxListener();
  private String mPackage;
  private String mPackageLabel;
  private View mView = null;
  
  static void createAndShow(String paramString1, String paramString2, FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    if ((isActive(paramFragmentManager)) || (paramString2 == null)) {
      return;
    }
    DisableAppConfirmationDialog localDisableAppConfirmationDialog = new DisableAppConfirmationDialog();
    Bundle localBundle = new Bundle();
    localBundle.putString("package", paramString1);
    localBundle.putString("label", paramString2);
    localDisableAppConfirmationDialog.setArguments(localBundle);
    localDisableAppConfirmationDialog.show(paramFragmentManager, "DisableAppConfirm");
    isUninstall = paramBoolean;
  }
  
  static void dismiss(FragmentTransaction paramFragmentTransaction, FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("DisableAppConfirm");
    if (paramFragmentManager != null)
    {
      paramFragmentManager.dismiss();
      paramFragmentTransaction.remove(paramFragmentManager);
    }
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return paramFragmentManager.findFragmentByTag("DisableAppConfirm") != null;
  }
  
  private boolean isRtl()
  {
    String str = Locale.getDefault().getLanguage();
    return ("iw".equals(str)) || ("ar".equals(str)) || ("fa".equals(str)) || ("ur".equals(str));
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      paramDialogInterface = (Launcher)getActivity();
      if ((paramDialogInterface != null) && (this.mView != null)) {
        paramDialogInterface.saveToastPopupForDisableDialog(Boolean.valueOf(((CheckBox)this.mView.findViewById(2131689519)).isChecked()));
      }
      if (!Launcher.mNonDisableItems.contains(this.mPackage.toString())) {
        break label76;
      }
      Toast.makeText(getActivity(), "This App can not be disabled", 1).show();
    }
    for (;;)
    {
      return;
      try
      {
        label76:
        if (isUninstall)
        {
          if (paramDialogInterface == null) {
            continue;
          }
          Launcher.mPackageTobeDisabled = this.mPackage;
          paramDialogInterface.uninstallPackage(this.mPackage);
        }
      }
      catch (SecurityException paramDialogInterface)
      {
        Log.e("DisableAppConfirmationDialog", "Problem uninstalling package. This should only happen when installed outside of /system/app.", paramDialogInterface);
        Toast.makeText(getActivity(), "Not installed with permissions needed for uninstalling", 1).show();
        return;
        getActivity().getPackageManager().setApplicationEnabledSetting(this.mPackage, 3, 0);
        return;
      }
      catch (NullPointerException paramDialogInterface)
      {
        Log.e("DisableAppConfirmationDialog", "Problem uninstalling package. This should only happen when either Activity or PackageManager is NULL.", paramDialogInterface);
        Toast.makeText(getActivity(), "Unable to install, please try again !", 0).show();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mPackage = getArguments().getString("package");
    this.mPackageLabel = getArguments().getString("label");
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity();
    Launcher localLauncher = (Launcher)getActivity();
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramBundle);
    View localView = View.inflate(paramBundle, 2130903048, null);
    localBuilder.setTitle(getString(2131755049));
    localBuilder.setPositiveButton(2131755083, this);
    localBuilder.setNegativeButton(2131755126, this);
    Object localObject = getString(2131755050, new Object[] { this.mPackageLabel, this.mPackageLabel });
    paramBundle = (Bundle)localObject;
    if (isRtl()) {
      paramBundle = "‏" + (String)localObject;
    }
    localBuilder.setMessage(paramBundle);
    if (isUninstall)
    {
      localObject = getString(2131755052, new Object[] { this.mPackageLabel });
      paramBundle = (Bundle)localObject;
      if (isRtl()) {
        paramBundle = "‏" + (String)localObject;
      }
      localBuilder.setMessage(paramBundle);
      localBuilder.setTitle(getString(2131755051));
      localBuilder.setPositiveButton(2131755083, this);
    }
    paramBundle = localBuilder.create();
    localObject = (CheckBox)localView.findViewById(2131689490);
    if (localObject != null)
    {
      ((CheckBox)localObject).setOnClickListener(this.mDialogCheckBoxListener);
      ((CheckBox)localObject).setChecked(localLauncher.isDialogChecked());
    }
    return paramBundle;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public static class DialogCheckBoxListener
    implements View.OnClickListener
  {
    public void onClick(View paramView) {}
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/DisableAppConfirmationDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */