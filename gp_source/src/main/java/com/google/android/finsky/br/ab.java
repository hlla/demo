package com.google.android.finsky.br;

import android.content.Intent;
import com.google.android.finsky.ag.d;

final class ab
  implements m
{
  ab(aa paramaa) {}
  
  public final void b()
  {
    Object localObject = this.a.c.a();
    String str1 = this.a.c.a(3);
    String str2 = this.a.c.a(2);
    a locala = this.a.c.e();
    localObject = new Intent("com.google.android.gms.family.v2.ACCEPT_TOS").setPackage((String)d.df.b()).putExtra("accountName", (String)localObject).putExtra("appId", locala.a).putExtra("tosRequired", true).putExtra("tosContinueButton", str1).putExtra("tosContent", str2).putExtra("predefinedTheme", locala.c);
    this.a.c.d().a((Intent)localObject, 3);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */