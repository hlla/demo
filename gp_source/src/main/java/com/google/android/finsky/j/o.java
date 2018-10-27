package com.google.android.finsky.j;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import com.google.android.finsky.bb.a;
import com.google.android.finsky.bb.c;
import com.google.android.finsky.dt.b;
import java.util.ArrayList;

public final class o
  extends j
  implements OnClickListener
{
  public a aa;
  public p ab;
  
  public final Dialog c(Bundle paramBundle)
  {
    ((k)b.a(k.class)).a(this);
    paramBundle = new c();
    paramBundle.d = k().getString(2131953359);
    paramBundle.a = this.g.getInt("sort_type", 0);
    ArrayList localArrayList = this.g.getStringArrayList("sort_options");
    paramBundle.c = ((CharSequence[])localArrayList.toArray(new String[localArrayList.size()]));
    paramBundle.b = this;
    return this.aa.a(j(), paramBundle);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.ab;
    if (paramDialogInterface != null) {
      paramDialogInterface.b(paramInt);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/j/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */