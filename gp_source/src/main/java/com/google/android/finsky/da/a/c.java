package com.google.android.finsky.da.a;

import android.content.Intent;
import com.google.android.finsky.da.b;
import com.google.android.finsky.ds.a.hi;
import com.google.android.finsky.notification.q;
import com.google.android.finsky.utils.FinskyLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class c
  implements com.google.android.finsky.da.a
{
  public final b.a a;
  private final com.google.android.finsky.accounts.c b;
  private final com.google.android.finsky.api.i c;
  private final com.google.android.finsky.ba.d d;
  
  public c(b.a parama, com.google.android.finsky.api.i parami, com.google.android.finsky.accounts.c paramc, com.google.android.finsky.ba.d paramd)
  {
    this.a = parama;
    this.c = parami;
    this.b = paramc;
    this.d = paramd;
  }
  
  private static hi a(q paramq, int paramInt)
  {
    hi localhi = new hi();
    paramq = paramq.b.replaceAll("rich.user.notification.", "");
    if (paramq != null)
    {
      localhi.a |= 0x1;
      localhi.c = paramq;
      localhi.b = paramInt;
      localhi.a |= 0x2;
      return localhi;
    }
    throw new NullPointerException();
  }
  
  public final void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("mark_as_read_notification_id");
    if (str != null) {
      a(Collections.singletonList(new q(str, paramIntent.getStringExtra("mark_as_read_account_name"))));
    }
  }
  
  public final void a(com.google.android.finsky.notification.d paramd)
  {
    this.d.a(new d(this, paramd));
  }
  
  public final void a(q paramq, b paramb, com.google.android.finsky.da.c paramc)
  {
    String str2 = paramq.a;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.b.cS();
    }
    str2 = paramq.b;
    if (str2.startsWith("rich.user.notification."))
    {
      paramq = a(paramq, 3);
      this.c.a(str1).b(new ArrayList(Arrays.asList(new hi[] { paramq })), new g(paramc), new h(paramb));
      return;
    }
    ((n)this.a.a()).b(str2, paramq.a);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a(new q(paramString1, paramString2), e.a, f.a);
  }
  
  public final void a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      Object localObject3 = (q)paramList.next();
      localObject1 = ((q)localObject3).b;
      if (((String)localObject1).startsWith("rich.user.notification."))
      {
        localArrayList.add(localObject3);
      }
      else
      {
        localObject2 = (n)this.a.a();
        localObject3 = ((q)localObject3).a;
        ((n)localObject2).c.a(n.a((String)localObject1, (String)localObject3)).a(new y()).a(new z((n)localObject2));
      }
    }
    paramList = this.b.cS();
    Object localObject1 = new ArrayList();
    int i = 0;
    if (i < localArrayList.size())
    {
      localObject2 = ((q)localArrayList.get(i)).a;
      if ((localObject2 != null) && (!((String)localObject2).equals(paramList)) && (localArrayList.size() > 1)) {
        FinskyLog.e("Rich user notification '%s' marked as read which does not match current account: '%s'. This is not allowed as part of a batch update.", new Object[] { localArrayList.get(i), paramList });
      }
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject1).add(a((q)localArrayList.get(i), 2));
      }
    }
    if (((List)localObject1).size() > 0) {
      if (((q)localArrayList.get(0)).a == null) {
        break label322;
      }
    }
    label322:
    for (paramList = this.c.a(((q)localArrayList.get(0)).a);; paramList = this.c.a())
    {
      paramList.b((List)localObject1, i.a, j.a);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/da/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */