package com.google.android.finsky.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.library.r;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.i;
import com.google.wireless.android.finsky.c.a.q;
import com.google.wireless.android.finsky.c.a.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class c
{
  private static final List a = new ArrayList();
  private static final List b = new ArrayList();
  private final com.google.android.finsky.l.a c;
  private final Context d;
  private final com.google.android.finsky.bh.b e;
  private final com.google.android.finsky.bo.c f;
  private final com.google.android.finsky.p2p.c g;
  private final com.google.android.finsky.cg.b h;
  private final com.google.android.finsky.library.c i;
  private final r j;
  private final com.google.android.finsky.cw.a k;
  private final PackageManager l;
  private final com.google.android.finsky.dl.d m;
  private final com.google.android.finsky.ev.a n;
  
  public c(Context paramContext, com.google.android.finsky.bo.c paramc, com.google.android.finsky.l.a parama, com.google.android.finsky.cg.b paramb, com.google.android.finsky.ev.a parama1, com.google.android.finsky.library.c paramc1, r paramr, com.google.android.finsky.cw.a parama2, PackageManager paramPackageManager, com.google.android.finsky.bh.b paramb1, com.google.android.finsky.dl.d paramd, com.google.android.finsky.p2p.c paramc2)
  {
    this.d = paramContext;
    this.f = paramc;
    this.c = parama;
    this.h = paramb;
    this.n = parama1;
    this.i = paramc1;
    this.j = paramr;
    this.k = parama2;
    this.l = paramPackageManager;
    this.e = paramb1;
    this.m = paramd;
    this.g = paramc2;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 2)
      {
        bool1 = bool2;
        if (paramInt != 3) {
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(com.google.android.finsky.dh.b paramb)
  {
    return (paramb != null) && (paramb.q >= 10000) && (!"REL".equals(Build.VERSION.CODENAME));
  }
  
  public static boolean a(com.google.android.finsky.l.b paramb)
  {
    return (paramb != null) && (paramb.c != null);
  }
  
  private final boolean c(com.google.android.finsky.dh.b paramb, Document paramDocument)
  {
    if (paramb != null)
    {
      if (this.i.a()) {
        break label27;
      }
      FinskyLog.e("Library not loaded.", new Object[0]);
    }
    label27:
    while ((paramb.i) || (a(paramb, 12609314L))) {
      return false;
    }
    if (!this.j.a(paramDocument, null, this.i))
    {
      FinskyLog.a("Cannot update unavailable app: pkg=%s,restriction=%d", new Object[] { paramb.o, Integer.valueOf(paramDocument.an()) });
      return false;
    }
    return true;
  }
  
  private final boolean d(com.google.android.finsky.dh.b paramb, Document paramDocument)
  {
    com.google.android.finsky.bo.f localf = this.f.cY();
    if ((localf.a(12637130L)) && (localf.a(12643849L)))
    {
      if (new com.google.android.finsky.l.k(this.f).a(paramDocument.U()).a(paramb).g())
      {
        paramDocument = this.g.a(paramb.o);
        long l1;
        if (paramDocument != null)
        {
          paramDocument = paramDocument.e;
          if (paramDocument != null) {
            l1 = paramDocument.b;
          }
        }
        for (;;)
        {
          long l2 = l1;
          if (l1 == 0L) {}
          try
          {
            l2 = this.l.getPackageInfo(paramb.o, 4194304).lastUpdateTime;
            return i.a() - l2 > ((Long)com.google.android.finsky.ag.d.dK.b()).longValue();
          }
          catch (NameNotFoundException paramb) {}
          l1 = 0L;
          continue;
          l1 = 0L;
        }
      }
      return false;
    }
    return false;
    return false;
  }
  
  public final d a(Document paramDocument, boolean paramBoolean)
  {
    int i3 = 0;
    if (this.k.a()) {}
    for (long l1 = this.k.c;; l1 = Long.MAX_VALUE)
    {
      Object localObject2 = paramDocument.U();
      Object localObject1 = ((o)localObject2).t;
      int i1;
      if (Build.VERSION.SDK_INT <= 22) {
        if (!com.google.android.play.utils.k.d(this.d)) {
          i1 = 0;
        }
      }
      for (;;)
      {
        d locald = new d();
        if (a.contains(localObject1))
        {
          FinskyLog.c("Forcing true for size limit for package %s", new Object[] { localObject1 });
          locald.b = true;
        }
        if (this.e.a(paramDocument, true) >= l1) {
          locald.b = true;
        }
        paramDocument = this.c.a(((o)localObject2).t, false);
        int i2;
        if (paramDocument != null) {
          if (paramDocument.c != null) {
            i2 = 0;
          }
        }
        for (;;)
        {
          if (i1 != 0) {
            locald.c = false;
          }
          for (;;)
          {
            if ((i2 == 0) && (paramBoolean))
            {
              paramDocument = paramDocument.a;
              if ((paramDocument != null) && (paramDocument.f == 2)) {
                locald.a = true;
              }
            }
            return locald;
            if (i2 == 0)
            {
              Set localSet = com.google.android.finsky.permissionui.f.a(com.google.android.finsky.permissionui.f.a(this.l, (String)localObject1));
              boolean bool = this.m.b(this.h, (String)localObject1);
              localObject2 = this.m.a(((o)localObject2).u, localSet, bool);
              if ((b.contains(localObject1)) || (((com.google.android.finsky.dl.c)localObject2).a)) {}
              for (;;)
              {
                locald.c = true;
                break;
                localObject1 = localObject2.c[localObject2.b];
                if ((localObject1 == null) || (!((com.google.android.finsky.dl.b)localObject1).b()))
                {
                  localObject1 = ((com.google.android.finsky.dl.c)localObject2).c;
                  int i4 = localObject1.length;
                  i1 = i3;
                  label314:
                  if (i1 < i4)
                  {
                    localObject2 = localObject1[i1];
                    if (localObject2 != null) {
                      break label338;
                    }
                  }
                  label338:
                  while ((((com.google.android.finsky.dl.b)localObject2).a()) || (!((com.google.android.finsky.dl.b)localObject2).b()))
                  {
                    i1 += 1;
                    break label314;
                    break;
                  }
                }
              }
            }
            locald.c = true;
          }
          i2 = 1;
          continue;
          i2 = 1;
        }
        i1 = 1;
        continue;
        if (paramDocument.ap() <= 22) {
          break;
        }
        i1 = 1;
      }
    }
  }
  
  public final boolean a(Document paramDocument)
  {
    return (paramDocument != null) && (a(paramDocument.cC()));
  }
  
  public final boolean a(Document paramDocument, int paramInt)
  {
    return (!a(paramDocument.cC())) && (!a(paramInt)) && (this.j.a(paramDocument, this.n.a, this.i));
  }
  
  public final boolean a(com.google.android.finsky.dh.b paramb, long paramLong)
  {
    return (!this.f.cY().a(paramLong)) && (a(paramb));
  }
  
  public final boolean a(com.google.android.finsky.dh.b paramb, Document paramDocument)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (c(paramb, paramDocument))
    {
      bool1 = bool2;
      if (new com.google.android.finsky.l.k(this.f).a(paramDocument.U()).a(paramb).a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (a(this.c.a(paramString, false))) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      paramString = this.h.a(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if ((paramString.s & 0x800) != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final void b(Document paramDocument)
  {
    if (paramDocument != null)
    {
      o localo = paramDocument.U();
      if (localo == null)
      {
        FinskyLog.e("Null app details provided for %s", new Object[] { paramDocument.a.f });
        return;
      }
      paramDocument = localo.t;
      if (!localo.d())
      {
        FinskyLog.c("No everExternallyHosted provided for %s", new Object[] { paramDocument });
        return;
      }
      b(paramDocument, localo.l);
      return;
    }
    FinskyLog.e("Null document provided", new Object[0]);
  }
  
  public final void b(String paramString, boolean paramBoolean)
  {
    Object localObject = this.c.a(paramString, false);
    if ((localObject == null) || (((com.google.android.finsky.l.b)localObject).c == null)) {
      FinskyLog.a("Presetting external-hosting status for non-installed %s", new Object[] { paramString });
    }
    if (localObject != null) {}
    for (localObject = ((com.google.android.finsky.l.b)localObject).a;; localObject = null)
    {
      if (localObject != null) {}
      for (int i1 = ((com.google.android.finsky.cg.c)localObject).H;; i1 = 0)
      {
        if (!paramBoolean) {}
        for (int i2 = i1 & 0xFFFFFFFD | 0x4;; i2 = i1 | 0x2 | 0x4)
        {
          if (i2 != i1) {
            this.h.e(paramString, i2);
          }
          return;
        }
      }
    }
  }
  
  public final boolean b(com.google.android.finsky.dh.b paramb, Document paramDocument)
  {
    if (c(paramb, paramDocument)) {
      return d(paramb, paramDocument);
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */