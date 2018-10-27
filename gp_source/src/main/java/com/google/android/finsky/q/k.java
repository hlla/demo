package com.google.android.finsky.q;

import android.content.Intent;
import com.google.android.finsky.fd.h;
import com.google.android.finsky.utils.FinskyLog;

final class k
  implements h
{
  k(a parama, boolean[] paramArrayOfBoolean, boolean paramBoolean) {}
  
  public final void l_()
  {
    this.c[0] = false;
    ((com.google.android.finsky.fd.a)this.a.at.a()).b(this);
    if (((com.google.android.finsky.accounts.a)this.a.H.a()).a(this.a.I()))
    {
      this.a.h(this.b);
      return;
    }
    a locala = this.a;
    if (this.b) {}
    for (Intent localIntent = locala.getIntent();; localIntent = null)
    {
      locala.a(null, localIntent);
      return;
    }
  }
  
  public final void m_()
  {
    this.c[0] = false;
    ((com.google.android.finsky.fd.a)this.a.at.a()).b(this);
    FinskyLog.c("User settings failed to load, continuing start anyways.", new Object[0]);
    this.a.h(this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/q/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */