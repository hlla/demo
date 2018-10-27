package com.google.android.finsky.bd;

import android.os.Bundle;
import android.view.View;
import com.google.android.finsky.be.d;
import com.google.android.finsky.e.af;
import com.google.android.finsky.utils.ParcelableProto;
import com.google.wireless.android.finsky.dfe.e.a.cp;

public final class a
{
  public d a;
  public boolean b;
  public View c;
  public cp d;
  public View e;
  public final b f;
  public final af g;
  
  public a(Bundle paramBundle, af paramaf, b paramb)
  {
    this.g = paramaf;
    this.f = paramb;
    if (paramBundle != null)
    {
      this.b = paramBundle.getBoolean("DialogFragmentContainerModel.finishedEventLogged");
      if (paramBundle.containsKey("DialogFragmentContainerModel.component")) {
        this.d = ((cp)ParcelableProto.a(paramBundle, "DialogFragmentContainerModel.component"));
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bd/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */