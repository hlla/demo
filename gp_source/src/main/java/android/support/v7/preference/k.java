package android.support.v7.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class k
  implements DialogInterface.OnClickListener
{
  k(j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    j localj = this.a;
    localj.aa = paramInt;
    localj.onClick(paramDialogInterface, -1);
    paramDialogInterface.dismiss();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */