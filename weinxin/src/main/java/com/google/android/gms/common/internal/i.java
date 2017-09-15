package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;

public final class i
  implements DialogInterface.OnClickListener
{
  private final Intent PC;
  private final Fragment aqr;
  private final int aqs;
  private final Activity qb;
  
  public i(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.qb = paramActivity;
    this.aqr = null;
    this.PC = paramIntent;
    this.aqs = 2;
  }
  
  public i(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.qb = null;
    this.aqr = paramFragment;
    this.PC = paramIntent;
    this.aqs = 2;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((this.PC != null) && (this.aqr != null)) {
        this.aqr.startActivityForResult(this.PC, this.aqs);
      }
      for (;;)
      {
        paramDialogInterface.dismiss();
        return;
        if (this.PC != null) {
          this.qb.startActivityForResult(this.PC, this.aqs);
        }
      }
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface) {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */