package com.google.android.finsky.da.a;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.finsky.accounts.c;
import com.google.android.finsky.da.k;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.notification.m;
import com.google.android.finsky.utils.i;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class n
  implements com.google.android.finsky.accounts.b, com.google.android.finsky.da.e, k, com.google.android.finsky.notification.r
{
  public int a;
  public final Set b = new HashSet();
  public final com.google.android.finsky.aq.f c;
  public final com.google.android.finsky.af.d d;
  private final c e;
  private final Context f;
  private final com.google.android.finsky.aq.a g;
  
  public n(com.google.android.finsky.aq.g paramg, com.google.android.finsky.af.d paramd, com.google.android.finsky.accounts.a parama, c paramc, Context paramContext)
  {
    android.support.v4.g.a locala = new android.support.v4.g.a(4);
    locala.put("notification_id", "TEXT");
    locala.put("account_name", "TEXT");
    locala.put("timestamp", "INTEGER");
    locala.put("notification_count", "INTEGER");
    this.g = paramg.a("notification_cache", 1, new com.google.android.finsky.aq.e[] { new com.google.android.finsky.aq.e("notifications", "TEXT", locala) });
    this.c = paramg.a(this.g, "notifications", new p(), new q(), new r(), 0, new s());
    this.d = paramd;
    this.e = paramc;
    this.f = paramContext;
    parama.a(this);
    this.a = 0;
    c();
  }
  
  static String a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    return TextUtils.join("|", Arrays.asList(new String[] { paramString1, str }));
  }
  
  static long b()
  {
    return i.a() - TimeUnit.DAYS.toMillis(((Integer)com.google.android.finsky.ag.d.ga.b()).intValue());
  }
  
  private final void c(String paramString)
  {
    com.google.android.finsky.aq.s locals1 = com.google.android.finsky.aq.s.a(new com.google.android.finsky.aq.s().a("account_name", paramString), new com.google.android.finsky.aq.s().a("account_name"), "OR");
    com.google.android.finsky.aq.s locals2 = new com.google.android.finsky.aq.s().a("notification_count", Integer.valueOf(1));
    this.c.a(com.google.android.finsky.aq.s.a(locals1, locals2, "AND")).a(new o(this, paramString));
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(Account paramAccount)
  {
    if (paramAccount != null) {
      c(paramAccount.name);
    }
  }
  
  public final void a(com.google.android.finsky.da.f paramf)
  {
    this.b.add(paramf);
  }
  
  public final void a(com.google.android.finsky.notification.d paramd)
  {
    if ((!com.google.android.finsky.ba.a.c(this.f)) && (!com.google.android.finsky.ba.a.b(this.f)) && (!com.google.android.finsky.ba.a.a(this.f)) && (paramd.a.f != 2)) {
      b(paramd);
    }
  }
  
  public final void a(String paramString)
  {
    b(paramString, null);
  }
  
  final com.google.android.finsky.af.e b(com.google.android.finsky.notification.d paramd)
  {
    com.google.android.finsky.cv.b localb;
    Object localObject1;
    Object localObject2;
    int i;
    if (paramd.a.f != 2)
    {
      localb = new com.google.android.finsky.cv.b();
      localObject1 = paramd.a;
      localObject2 = ((com.google.android.finsky.notification.f)localObject1).g;
      if (localObject2 == null) {
        break label653;
      }
      localb.b |= 0x1;
      localb.h = ((String)localObject2);
      localObject2 = ((com.google.android.finsky.notification.f)localObject1).e;
      if (localObject2 == null) {
        break label661;
      }
      localb.b |= 0x20;
      localb.g = ((String)localObject2);
      i = ((com.google.android.finsky.notification.f)localObject1).l;
      localb.b |= 0x40;
      localb.m = i;
      localObject2 = ((com.google.android.finsky.notification.f)localObject1).m;
      if (localObject2 == null) {
        break label669;
      }
      localb.b |= 0x10;
      localb.n = ((String)localObject2);
      long l = ((com.google.android.finsky.notification.f)localObject1).h;
      localb.b |= 0x4;
      localb.i = l;
      if (((com.google.android.finsky.notification.f)localObject1).f == 0)
      {
        i = 1;
        localb.b |= 0x8;
        localb.d = i;
        localObject2 = ((com.google.android.finsky.notification.f)localObject1).a;
        if (localObject2 == null)
        {
          label211:
          localObject2 = ((com.google.android.finsky.notification.f)localObject1).d;
          if (localObject2 == null)
          {
            localObject1 = paramd.a.b;
            if (localObject1 == null)
            {
              label237:
              localObject1 = paramd.a.c;
              if (localObject1 == null)
              {
                label251:
                localObject1 = paramd.a.i;
                if (localObject1 == null)
                {
                  label265:
                  localObject1 = paramd.a.j;
                  if (localObject1 == null)
                  {
                    label279:
                    localObject1 = paramd.a.o;
                    if (localObject1 == null)
                    {
                      label293:
                      paramd = paramd.a.k;
                      if (paramd == null) {
                        paramd = localb;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramd != null) {
        return this.c.b(paramd).a(new t(this));
      }
      return this.d.a(null);
      if (paramd == null) {
        break label677;
      }
      localb.b |= 0x100;
      localb.l = paramd;
      paramd = localb;
      continue;
      localb.o = ((Integer)localObject1).intValue();
      localb.b |= 0x80;
      break label293;
      localb.k = aa.a((com.google.android.finsky.notification.a)localObject1);
      break label279;
      localb.j = aa.a((com.google.android.finsky.notification.a)localObject1);
      break label265;
      localb.e = aa.a((m)localObject1);
      break label251;
      localb.c = aa.a((m)localObject1);
      break label237;
      localObject1 = new com.google.android.finsky.cv.d();
      Object localObject3 = ((com.google.android.finsky.notification.g)localObject2).a;
      if (localObject3 == null)
      {
        localObject3 = ((com.google.android.finsky.notification.g)localObject2).b;
        if (localObject3 == null)
        {
          localObject2 = ((com.google.android.finsky.notification.g)localObject2).c;
          if (localObject2 != null) {}
        }
      }
      for (;;)
      {
        localb.f = ((com.google.android.finsky.cv.d)localObject1);
        break;
        if (localObject2 == null) {
          break label685;
        }
        ((com.google.android.finsky.cv.d)localObject1).d = -1;
        ((com.google.android.finsky.cv.d)localObject1).d = 2;
        ((com.google.android.finsky.cv.d)localObject1).c = ((String)localObject2);
        continue;
        if (localObject3 != null)
        {
          ((com.google.android.finsky.cv.d)localObject1).d = -1;
          ((com.google.android.finsky.cv.d)localObject1).d = 1;
          ((com.google.android.finsky.cv.d)localObject1).b = ((bu)localObject3);
        }
        else
        {
          if (((com.google.android.finsky.cv.d)localObject1).d == 1) {
            ((com.google.android.finsky.cv.d)localObject1).d = -1;
          }
          ((com.google.android.finsky.cv.d)localObject1).b = null;
          continue;
          i = ((Integer)localObject3).intValue();
          ((com.google.android.finsky.cv.d)localObject1).d = -1;
          ((com.google.android.finsky.cv.d)localObject1).d = 0;
          ((com.google.android.finsky.cv.d)localObject1).a = i;
        }
      }
      if (localObject2 == null) {
        break label693;
      }
      localb.b |= 0x2;
      localb.a = ((String)localObject2);
      break label211;
      i = 0;
      break;
      paramd = null;
    }
    label653:
    throw new NullPointerException();
    label661:
    throw new NullPointerException();
    label669:
    throw new NullPointerException();
    label677:
    throw new NullPointerException();
    label685:
    throw new NullPointerException();
    label693:
    throw new NullPointerException();
  }
  
  public final com.google.android.finsky.af.e b(String paramString)
  {
    paramString = com.google.android.finsky.aq.s.a(new com.google.android.finsky.aq.s().a("account_name", paramString), new com.google.android.finsky.aq.s().a("account_name"), "OR");
    com.google.android.finsky.aq.s locals = new com.google.android.finsky.aq.s().e("timestamp", Long.valueOf(b()));
    return this.c.a(com.google.android.finsky.aq.s.a(paramString, locals, "AND"), "timestamp desc", null).a(new x());
  }
  
  final com.google.android.finsky.af.e b(String paramString1, String paramString2)
  {
    return this.c.d(a(paramString1, paramString2));
  }
  
  public final void b(com.google.android.finsky.da.f paramf)
  {
    this.b.remove(paramf);
  }
  
  final void c()
  {
    c(this.e.cS());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/da/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */