package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class h
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  int oG = 0;
  int oH = 0;
  boolean oI = true;
  public boolean oJ = true;
  int oK = -1;
  Dialog oL;
  boolean oM;
  boolean oN;
  boolean oO;
  
  public void a(l paraml, String paramString)
  {
    this.oN = false;
    this.oO = true;
    paraml = paraml.aV();
    paraml.a(this, paramString);
    paraml.commit();
  }
  
  public Dialog aF()
  {
    return new Dialog(aG(), this.oH);
  }
  
  public final LayoutInflater c(Bundle paramBundle)
  {
    if (!this.oJ) {
      return super.c(paramBundle);
    }
    this.oL = aF();
    if (this.oL != null)
    {
      paramBundle = this.oL;
      switch (this.oG)
      {
      }
      for (;;)
      {
        return (LayoutInflater)this.oL.getContext().getSystemService("layout_inflater");
        paramBundle.getWindow().addFlags(24);
        paramBundle.requestWindowFeature(1);
      }
    }
    return (LayoutInflater)this.ph.mContext.getSystemService("layout_inflater");
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (!this.oJ) {}
    do
    {
      do
      {
        return;
        View localView = this.mView;
        if (localView != null)
        {
          if (localView.getParent() != null) {
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
          }
          this.oL.setContentView(localView);
        }
        this.oL.setOwnerActivity(aG());
        this.oL.setCancelable(this.oI);
        this.oL.setOnCancelListener(this);
        this.oL.setOnDismissListener(this);
      } while (paramBundle == null);
      paramBundle = paramBundle.getBundle("android:savedDialogState");
    } while (paramBundle == null);
    this.oL.onRestoreInstanceState(paramBundle);
  }
  
  public final void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (!this.oO) {
      this.oN = false;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.pl == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.oJ = bool;
      if (paramBundle != null)
      {
        this.oG = paramBundle.getInt("android:style", 0);
        this.oH = paramBundle.getInt("android:theme", 0);
        this.oI = paramBundle.getBoolean("android:cancelable", true);
        this.oJ = paramBundle.getBoolean("android:showsDialog", this.oJ);
        this.oK = paramBundle.getInt("android:backStackId", -1);
      }
      return;
    }
  }
  
  public final void onDestroyView()
  {
    super.onDestroyView();
    if (this.oL != null)
    {
      this.oM = true;
      this.oL.dismiss();
      this.oL = null;
    }
  }
  
  public final void onDetach()
  {
    super.onDetach();
    if ((!this.oO) && (!this.oN)) {
      this.oN = true;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((!this.oM) && (!this.oN))
    {
      this.oN = true;
      this.oO = false;
      if (this.oL != null)
      {
        this.oL.dismiss();
        this.oL = null;
      }
      this.oM = true;
      if (this.oK >= 0)
      {
        this.pg.F(this.oK);
        this.oK = -1;
      }
    }
    else
    {
      return;
    }
    paramDialogInterface = this.pg.aV();
    paramDialogInterface.a(this);
    paramDialogInterface.commitAllowingStateLoss();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.oL != null)
    {
      Bundle localBundle = this.oL.onSaveInstanceState();
      if (localBundle != null) {
        paramBundle.putBundle("android:savedDialogState", localBundle);
      }
    }
    if (this.oG != 0) {
      paramBundle.putInt("android:style", this.oG);
    }
    if (this.oH != 0) {
      paramBundle.putInt("android:theme", this.oH);
    }
    if (!this.oI) {
      paramBundle.putBoolean("android:cancelable", this.oI);
    }
    if (!this.oJ) {
      paramBundle.putBoolean("android:showsDialog", this.oJ);
    }
    if (this.oK != -1) {
      paramBundle.putInt("android:backStackId", this.oK);
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    if (this.oL != null)
    {
      this.oM = false;
      this.oL.show();
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    if (this.oL != null) {
      this.oL.hide();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */