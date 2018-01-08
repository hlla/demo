package com.android.launcher2.guide;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import java.lang.ref.WeakReference;

abstract class GuiderBase
{
  private WeakReference<Activity> mActivityRef;
  private WeakReference<Fragment> mFragmentRef;
  
  public GuiderBase(Activity paramActivity)
  {
    if (paramActivity == null) {
      throw new IllegalArgumentException("Expecting not null");
    }
    this.mActivityRef = new WeakReference(paramActivity);
    this.mFragmentRef = new WeakReference(paramActivity.getFragmentManager().findFragmentByTag("GuideFragment"));
  }
  
  public void finish() {}
  
  Activity getActivity()
  {
    if (this.mActivityRef != null) {
      return (Activity)this.mActivityRef.get();
    }
    return null;
  }
  
  Fragment getFragment()
  {
    if (this.mFragmentRef != null) {
      return (Fragment)this.mFragmentRef.get();
    }
    return null;
  }
  
  public boolean onSwitcherChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    return false;
  }
  
  public void showCompleteDialog()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    final Activity localActivity = getActivity();
    if (localActivity == null) {
      return;
    }
    Resources localResources = localActivity.getResources();
    localBuilder.setMessage(localResources.getText(2131755173)).setCancelable(false).setTitle(localResources.getText(2131755172)).setPositiveButton(localResources.getText(2131755172), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent("android.intent.action.MAIN");
        paramAnonymousDialogInterface.addCategory("android.intent.category.HOME");
        localActivity.startActivity(paramAnonymousDialogInterface);
        localActivity.finish();
      }
    }).show();
  }
  
  protected void showDialog(View paramView) {}
  
  public void showHelpDialog() {}
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/guide/GuiderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */