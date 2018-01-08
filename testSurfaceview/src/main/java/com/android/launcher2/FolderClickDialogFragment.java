package com.android.launcher2;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class FolderClickDialogFragment
  extends DialogFragment
{
  private static FolderItem mFolder;
  private static MenuAppsGrid.State mState = MenuAppsGrid.State.NORMAL;
  private static final String sFragmentTag = "FolderEditClick";
  private Context mContext;
  private ArrayList<String> mItems;
  
  static void createAndShow(FragmentManager paramFragmentManager, FolderItem paramFolderItem, MenuAppsGrid.State paramState)
  {
    if (isActive(paramFragmentManager)) {
      return;
    }
    mFolder = paramFolderItem;
    mState = paramState;
    new FolderClickDialogFragment().show(paramFragmentManager, "FolderEditClick");
  }
  
  static void dismiss(FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("FolderEditClick");
    if (paramFragmentManager != null) {
      paramFragmentManager.dismissAllowingStateLoss();
    }
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return paramFragmentManager.findFragmentByTag("FolderEditClick") != null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mContext = getActivity();
    super.onCreate(paramBundle);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    this.mItems = new ArrayList();
    this.mItems.add(this.mContext.getResources().getString(2131755313));
    if (mState == MenuAppsGrid.State.EDIT) {
      this.mItems.add(this.mContext.getResources().getString(2131755019));
    }
    paramBundle = new AlertDialog.Builder(getActivity());
    paramBundle.setTitle(this.mContext.getResources().getString(2131755030));
    paramBundle.setAdapter(new ArrayAdapter(this.mContext, 2130903041, this.mItems), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 0: 
          paramAnonymousDialogInterface = ((Launcher)FolderClickDialogFragment.this.mContext).getMenuView().getMenuAppsGrid();
          paramAnonymousDialogInterface.cancelClicksOnChildrenForCurrentPage();
          paramAnonymousDialogInterface.openFolder(FolderClickDialogFragment.mFolder, true);
          return;
        }
        if (FolderClickDialogFragment.mFolder.getItemCount() == 0)
        {
          MenuAppModel.INSTANCE.setFolderToDelete((AppFolderItem)FolderClickDialogFragment.mFolder);
          MenuAppModel.INSTANCE.editRemoveFolder();
          ((Launcher)FolderClickDialogFragment.this.mContext).getMenuView().appModelUpdated();
          return;
        }
        AppFolderRemoveDialog.createAndShow((AppFolderItem)FolderClickDialogFragment.mFolder, Launcher.getInstance().getFragmentManager(), false);
      }
    });
    paramBundle = paramBundle.create();
    paramBundle.setCanceledOnTouchOutside(true);
    return paramBundle;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (Launcher)getActivity();
    if ((paramDialogInterface != null) && (paramDialogInterface.getFragmentManager() != null) && (isActive(paramDialogInterface.getFragmentManager()))) {
      dismiss();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/FolderClickDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */