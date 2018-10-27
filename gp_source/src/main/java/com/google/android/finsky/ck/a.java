package com.google.android.finsky.ck;

import android.text.TextUtils;
import com.google.android.finsky.cg.b;
import com.google.android.finsky.externalreferrer.ExternalReferrerStatus;
import com.google.android.finsky.utils.i;

public final class a
  implements com.google.android.finsky.instantapps.f.a.a
{
  private final com.google.android.finsky.accounts.c a;
  private final com.google.android.finsky.devicemanagement.a b;
  private final com.google.android.finsky.externalreferrer.d c;
  private final b d;
  
  public a(b paramb, com.google.android.finsky.externalreferrer.d paramd, com.google.android.finsky.devicemanagement.a parama, com.google.android.finsky.accounts.c paramc)
  {
    this.d = paramb;
    this.c = paramd;
    this.b = parama;
    this.a = paramc;
  }
  
  public final String a(String paramString)
  {
    Object localObject = this.d.a(paramString);
    paramString = this.c.a(paramString, (com.google.android.finsky.cg.c)localObject);
    if (paramString == null)
    {
      paramString = (String)com.google.android.finsky.ag.d.dd.b();
      return paramString;
    }
    Long localLong = paramString.a();
    if ((localLong.longValue() > 0L) && (localLong.longValue() + ((Long)com.google.android.finsky.ag.d.de.b()).longValue() < i.a())) {
      return (String)com.google.android.finsky.ag.d.dd.b();
    }
    int i;
    if (localObject != null) {
      if (this.b.a(this.a.c(((com.google.android.finsky.cg.c)localObject).b))) {
        i = 1;
      }
    }
    for (;;)
    {
      boolean bool = this.b.c();
      if ((i == 0) && (!bool))
      {
        localObject = paramString.a.d;
        paramString = (String)localObject;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        return (String)com.google.android.finsky.ag.d.dc.b();
      }
      return (String)com.google.android.finsky.ag.d.dc.b();
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/ck/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */