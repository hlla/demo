package com.google.android.finsky.de;

import android.text.TextUtils;
import com.android.volley.x;
import com.google.android.finsky.ag.c;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.installqueue.InstallConstraint;
import com.google.android.finsky.installqueue.InstallRequest;
import com.google.android.finsky.installqueue.TimeWindow;
import com.google.android.finsky.installqueue.k;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.i;
import com.google.protobuf.nano.g;
import com.google.wireless.android.finsky.dfe.r.a.b;
import java.util.concurrent.TimeUnit;

public final class a
  implements x
{
  public final b.a a;
  
  public a(b.a parama)
  {
    this.a = parama;
  }
  
  public static InstallRequest a(com.google.android.finsky.e.af paramaf, String paramString, Document paramDocument, com.google.wireless.android.finsky.dfe.r.a.a parama)
  {
    paramaf = new k(paramaf, paramDocument);
    paramaf.b(paramString);
    return a(paramaf.a(), parama);
  }
  
  public static InstallRequest a(InstallRequest paramInstallRequest, com.google.wireless.android.finsky.dfe.r.a.a parama)
  {
    InstallConstraint localInstallConstraint = new com.google.android.finsky.installqueue.d().a(2).b();
    long l1 = TimeUnit.SECONDS.toMillis(parama.c);
    long l2 = TimeUnit.SECONDS.toMillis(parama.b);
    parama = new com.google.android.finsky.installqueue.d().a(3);
    parama.b = new TimeWindow(l1, l2);
    parama = parama.b();
    return new k(paramInstallRequest).a(1).a(new InstallConstraint[] { localInstallConstraint, parama }).a("offpeak").a();
  }
  
  public static com.google.wireless.android.finsky.dfe.r.a.a a()
  {
    int i = 0;
    String str = (String)c.N.a();
    Object localObject;
    if (!TextUtils.isEmpty(str))
    {
      localObject = new b();
      if (!com.google.android.finsky.utils.af.a(str, (g)localObject))
      {
        FinskyLog.e("Could not de-serialize the cached DataPlanResponse.", new Object[0]);
        localObject = null;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        long l1 = i.a();
        localObject = ((b)localObject).a;
        int j = localObject.length;
        while (i < j)
        {
          str = localObject[i];
          long l2 = str.b;
          if ((l1 >= l2) || (l2 - l1 < TimeUnit.MINUTES.toSeconds(((Integer)com.google.android.finsky.ag.d.gh.b()).intValue()))) {
            i += 1;
          } else {
            return str;
          }
        }
        return null;
      }
      FinskyLog.c("Cannot get next flex time window. Cache is empty.", new Object[0]);
      return null;
      continue;
      localObject = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/de/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */