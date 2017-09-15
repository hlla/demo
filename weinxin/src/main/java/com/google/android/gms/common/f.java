package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.h;
import android.support.v4.app.l;
import com.google.android.gms.common.internal.w;

public final class f
  extends h
{
  private DialogInterface.OnCancelListener amb = null;
  private Dialog oL = null;
  
  public static f b(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    f localf = new f();
    paramDialog = (Dialog)w.h(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    localf.oL = paramDialog;
    if (paramOnCancelListener != null) {
      localf.amb = paramOnCancelListener;
    }
    return localf;
  }
  
  public final void a(l paraml, String paramString)
  {
    super.a(paraml, paramString);
  }
  
  public final Dialog aF()
  {
    if (this.oL == null) {
      this.oJ = false;
    }
    return this.oL;
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.amb != null) {
      this.amb.onCancel(paramDialogInterface);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */