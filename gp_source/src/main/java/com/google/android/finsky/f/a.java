package com.google.android.finsky.f;

import android.annotation.TargetApi;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.finsky.ag.d;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.bf;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.l.k;
import com.google.android.finsky.library.g;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.i;
import com.google.android.finsky.utils.j;
import java.util.List;

public final class a
{
  public final long a;
  public final boolean b;
  public final boolean c;
  public final boolean d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  public boolean i;
  public final boolean j;
  public String k;
  private final c l;
  private final Context m;
  private final com.google.android.finsky.l.a n;
  private final String[] o;
  private final com.google.android.finsky.ac.a p;
  private final b.a q;
  private final com.google.android.finsky.bo.c r;
  private final com.google.android.finsky.cg.c s;
  private Boolean t;
  private final boolean u;
  private final boolean v;
  private final List w;
  private com.google.android.finsky.dh.b x;
  private final String y;
  private List z = null;
  
  a(Context paramContext, String paramString, com.google.android.finsky.l.a parama, com.google.android.finsky.library.c paramc, com.google.android.finsky.bo.c paramc1, c paramc2, com.google.android.finsky.ac.a parama1, b.a parama2)
  {
    this.y = paramString;
    this.m = paramContext;
    this.r = paramc1;
    this.n = parama;
    this.l = paramc2;
    this.p = parama1;
    this.q = parama2;
    paramString = this.n.a(this.y, false);
    this.e = c.a(paramString);
    boolean bool;
    if (this.e)
    {
      this.x = paramString.c;
      paramContext = this.x;
      this.g = paramContext.m;
      this.v = paramContext.n;
      this.b = paramContext.g;
      bool = this.n.a.e(this.y);
      paramContext = this.x;
      this.d = paramContext.i;
      if (bool) {
        if (!this.d)
        {
          bool = true;
          this.h = bool;
          this.u = this.l.a(paramContext, 12609316L);
        }
      }
    }
    for (this.o = paramString.c.a;; this.o = null)
    {
      this.w = paramc.b(this.y, this.o);
      this.j = (this.w.isEmpty() ^ true);
      if (this.e) {
        if (this.j) {
          bool = true;
        }
      }
      for (;;)
      {
        this.f = bool;
        if (paramString != null) {}
        for (paramContext = paramString.a;; paramContext = null)
        {
          this.s = paramContext;
          paramContext = this.s;
          if (paramContext == null) {}
          for (this.a = 0L;; this.a = paramContext.r)
          {
            paramContext = this.w;
            long l3 = i.a();
            long l4 = this.a;
            int i2 = paramContext.size();
            int i1 = 0;
            for (;;)
            {
              if (i1 >= i2) {
                break label574;
              }
              parama = (com.google.android.finsky.library.f)paramContext.get(i1);
              long l2 = parama.d;
              long l1 = l2;
              if (l4 != 0L) {
                l1 = Math.min(l2, parama.c + l4);
              }
              if (l1 >= l3) {
                break;
              }
              i1 += 1;
            }
            label574:
            for (paramContext = parama.e;; paramContext = null)
            {
              this.k = paramContext;
              if (this.k != null) {}
              for (bool = true;; bool = false)
              {
                this.i = bool;
                if ((this.e) && (!this.j) && (!paramc.a(this.y).isEmpty())) {
                  FinskyLog.a("%s is installed but certificate mistmatch", new Object[] { this.y });
                }
                if (paramString != null)
                {
                  paramContext = paramString.a;
                  if (paramContext != null)
                  {
                    paramContext = paramContext.h;
                    if (!TextUtils.isEmpty(paramContext)) {
                      if (this.r.cY().a(12650840L)) {
                        if (this.e) {
                          if (((com.google.android.finsky.cl.a)this.q.a()).a(this.y, paramContext)) {
                            bool = true;
                          }
                        }
                      }
                    }
                  }
                }
                for (;;)
                {
                  this.c = bool;
                  return;
                  bool = false;
                  continue;
                  bool = true;
                  continue;
                  bool = true;
                  continue;
                  bool = false;
                  continue;
                  bool = false;
                  continue;
                  bool = false;
                }
              }
            }
          }
        }
        bool = false;
        continue;
        bool = false;
      }
      bool = false;
      break;
      bool = false;
      break;
      this.g = false;
      this.v = false;
      this.b = false;
      this.d = false;
      this.h = false;
      this.u = false;
    }
  }
  
  private static boolean a(String paramString, List paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i1 >= paramList.size()) {
          return bool1;
        }
        if (((com.google.android.finsky.library.f)paramList.get(i1)).e.equals(paramString)) {
          break;
        }
        i1 += 1;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public final String a(String paramString)
  {
    if (this.f)
    {
      localObject = this.s;
      if (localObject != null)
      {
        localObject = ((com.google.android.finsky.cg.c)localObject).a;
        if (a((String)localObject, this.w)) {
          return localObject;
        }
      }
    }
    if (this.f)
    {
      localObject = this.s;
      if (localObject != null)
      {
        localObject = ((com.google.android.finsky.cg.c)localObject).b;
        if (a((String)localObject, this.w)) {
          break label110;
        }
      }
    }
    Object localObject = paramString;
    if (!a(paramString, this.w))
    {
      localObject = paramString;
      if (!this.w.isEmpty()) {
        localObject = ((com.google.android.finsky.library.f)this.w.get(0)).e;
      }
    }
    return (String)localObject;
    label110:
    return (String)localObject;
    return (String)localObject;
  }
  
  public final boolean a()
  {
    if (android.support.v4.os.a.a())
    {
      if (this.t == null)
      {
        if (this.z == null) {
          this.z = com.google.android.finsky.utils.b.a(j.a((String)d.jy.b()));
        }
        this.t = Boolean.valueOf(this.z.contains(this.y) ^ true);
      }
      return this.t.booleanValue();
    }
    return true;
  }
  
  public final boolean a(Document paramDocument)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.e)
    {
      bool1 = bool2;
      if (!this.g)
      {
        bool1 = bool2;
        if (!this.f)
        {
          bf[] arrayOfbf = paramDocument.U().d;
          bool1 = bool2;
          if (this.p.a(this.o, arrayOfbf))
          {
            bool1 = bool2;
            if (!(new k(this.r).a(paramDocument.U()).a(this.x).a() ^ true)) {
              bool1 = paramDocument.ao() ^ true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final boolean b()
  {
    return (this.e) && (!this.b) && ((!this.g) || (this.v)) && (!c());
  }
  
  public final boolean b(Document paramDocument)
  {
    if (this.f) {}
    for (;;)
    {
      if ((!this.u) && (new k(this.r).a(paramDocument.U()).a(this.x).a())) {
        return true;
      }
      do
      {
        return false;
      } while (!this.g);
    }
  }
  
  @TargetApi(21)
  public final boolean c()
  {
    DevicePolicyManager localDevicePolicyManager = (DevicePolicyManager)this.m.getSystemService("device_policy");
    return (Build.VERSION.SDK_INT > 21) && (localDevicePolicyManager.isUninstallBlocked(null, this.y));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */