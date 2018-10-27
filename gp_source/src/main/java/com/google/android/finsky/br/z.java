package com.google.android.finsky.br;

import android.content.Intent;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.utils.FinskyLog;

public final class z
  extends y
{
  public z(q paramq)
  {
    super(paramq);
  }
  
  public final void a()
  {
    Object localObject = this.c.a();
    a locala = this.c.e();
    localObject = new Intent("com.google.android.gms.family.v2.INVITE_MEMBER").setPackage((String)d.df.b()).putExtra("accountName", (String)localObject).putExtra("appId", locala.a).putExtra("predefinedTheme", locala.c);
    this.c.d().a((Intent)localObject, 2);
  }
  
  public final void a(int paramInt, Intent paramIntent)
  {
    FinskyLog.a("result code=%d", new Object[] { Integer.valueOf(paramInt) });
    d();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */