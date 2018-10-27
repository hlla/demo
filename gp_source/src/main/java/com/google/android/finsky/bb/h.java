package com.google.android.finsky.bb;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;

public final class h
  extends j
{
  public final Dialog c(Bundle paramBundle)
  {
    b(false);
    paramBundle = new ProgressDialog(j());
    paramBundle.setProgressStyle(0);
    int i = this.g.getInt("message_id", 2131952572);
    if (this.g.containsKey("message")) {
      paramBundle.setMessage(this.g.getString("message"));
    }
    for (;;)
    {
      paramBundle.setCancelable(false);
      paramBundle.setIndeterminate(true);
      return paramBundle;
      if (i != 0) {
        paramBundle.setMessage(k().getString(i));
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bb/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */