package android.support.v7.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import java.util.Set;

final class m
  implements DialogInterface.OnMultiChoiceClickListener
{
  m(l paraml) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramDialogInterface = this.a;
      paramDialogInterface.ac |= paramDialogInterface.ab.remove(paramDialogInterface.aa[paramInt].toString());
      return;
    }
    paramDialogInterface = this.a;
    paramDialogInterface.ac |= paramDialogInterface.ab.add(paramDialogInterface.aa[paramInt].toString());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */