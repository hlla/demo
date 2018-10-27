package com.google.android.finsky.j;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.j;

final class m
  implements OnClickListener
{
  m(l paraml) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a(false);
    paramDialogInterface = this.a.ab;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(i.values()[((Integer)this.a.aa.get(paramInt)).intValue()]);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/j/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */