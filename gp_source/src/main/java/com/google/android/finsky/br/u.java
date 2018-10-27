package com.google.android.finsky.br;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.finsky.pagesystem.b;

public final class u
{
  public Activity a;
  public boolean b;
  public final q c;
  public y[] d;
  public boolean e;
  public int f;
  
  public u(q paramq)
  {
    this.c = paramq;
  }
  
  public final void a()
  {
    Intent localIntent = new Intent();
    if (this.b) {
      localIntent.putExtra("family_created", true);
    }
    if (this.e)
    {
      String str = this.c.g();
      if (!TextUtils.isEmpty(str)) {
        localIntent.putExtra("completionRedirectUrl", str);
      }
      this.a.setResult(-1, localIntent);
    }
    for (;;)
    {
      this.a.finish();
      return;
      this.a.setResult(0, localIntent);
    }
  }
  
  public final void a(Intent paramIntent, int paramInt)
  {
    this.a.startActivityForResult(paramIntent, paramInt);
  }
  
  public final void a(p paramp, boolean paramBoolean)
  {
    paramp.ad = this.c;
    s locals = (s)this.a;
    paramp.a_(locals.J_());
    locals.a(paramp, paramBoolean);
  }
  
  public final void b()
  {
    this.f += 1;
    int i = this.f;
    y[] arrayOfy = this.d;
    if (i >= arrayOfy.length)
    {
      a();
      return;
    }
    arrayOfy[i].a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */