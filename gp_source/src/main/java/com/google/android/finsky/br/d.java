package com.google.android.finsky.br;

import android.content.Intent;

final class d
  implements m
{
  d(c paramc) {}
  
  public final void b()
  {
    Object localObject = this.a.c.a();
    String str1 = this.a.c.a(3);
    String str2 = this.a.c.a(2);
    a locala = this.a.c.e();
    localObject = new Intent("com.google.android.gms.family.v2.CREATE").setPackage((String)com.google.android.finsky.ag.d.df.b()).putExtra("accountName", (String)localObject).putExtra("appId", locala.a).putExtra("tosRequired", true).putExtra("tosContinueButton", str1).putExtra("tosContent", str2).putExtra("predefinedTheme", locala.c);
    this.a.c.d().a((Intent)localObject, 1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/br/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */