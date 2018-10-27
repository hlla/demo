package com.google.android.finsky.dn.a;

import android.text.TextUtils;
import com.google.android.finsky.as.h;
import com.google.android.finsky.as.n;
import com.google.protobuf.nano.g;
import java.util.List;

public final class b
{
  private final com.google.android.finsky.accounts.c a;
  private byte[] b;
  private final com.google.android.finsky.deviceconfig.d c;
  private final h d;
  
  public b(h paramh, com.google.android.finsky.deviceconfig.d paramd, com.google.android.finsky.accounts.c paramc)
  {
    this.d = paramh;
    this.c = paramd;
    this.a = paramc;
  }
  
  public final byte[] a()
  {
    int i = 3;
    com.google.f.a.a.a.a locala;
    h localh;
    int j;
    if (this.b == null)
    {
      locala = new com.google.f.a.a.a.a();
      localh = this.d;
      if (!localh.c)
      {
        localObject = com.google.android.finsky.as.c.a("marketenvs.csv", localh.b);
        j = ((n)localObject).b;
        if (j >= 0) {
          break label186;
        }
        if (((String)com.google.android.play.utils.b.a.a("url:finsky_dfe_url", "").b()).contains((CharSequence)com.google.android.finsky.ag.d.bI.b())) {
          break label181;
        }
      }
    }
    label181:
    for (i = 1;; i = 3)
    {
      localh.a = i;
      localh.c = true;
      locala.d = localh.a;
      locala.a |= 0x1;
      if ((((Boolean)com.google.android.finsky.ag.d.o.b()).booleanValue()) && (this.a.cQ().isEmpty()))
      {
        locala.c = this.c.b();
        locala.b = this.c.e();
      }
      this.b = g.a(locala);
      return this.b;
    }
    label186:
    Object localObject = (String)((n)localObject).a().get(j);
    if (!TextUtils.equals((CharSequence)localObject, "Dogfood"))
    {
      if (TextUtils.equals((CharSequence)localObject, "Demo")) {
        break label293;
      }
      if (TextUtils.equals((CharSequence)localObject, "Autopush")) {
        break label288;
      }
      if (TextUtils.equals((CharSequence)localObject, "Staging")) {
        break label283;
      }
      if (TextUtils.equals((CharSequence)localObject, "Internal")) {
        break label278;
      }
      if (TextUtils.equals((CharSequence)localObject, "QA")) {
        break label273;
      }
      i = 1;
    }
    for (;;)
    {
      localh.a = i;
      break;
      label273:
      i = 4;
      continue;
      label278:
      i = 4;
      continue;
      label283:
      i = 5;
      continue;
      label288:
      i = 2;
      continue;
      label293:
      i = 2;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */