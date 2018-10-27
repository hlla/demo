package com.google.android.finsky.bb;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

final class n
  implements OnShowListener
{
  n(TextView paramTextView) {}
  
  public final void onShow(DialogInterface paramDialogInterface)
  {
    this.a.setMovementMethod(LinkMovementMethod.getInstance());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bb/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */