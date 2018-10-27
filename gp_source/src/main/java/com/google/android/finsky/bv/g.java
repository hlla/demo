package com.google.android.finsky.bv;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.ds.a.cx;
import com.google.android.finsky.ds.a.cy;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.ka;
import com.google.android.finsky.frameworkviews.as;
import com.google.android.finsky.frameworkviews.az;
import com.google.android.finsky.frameworkviews.bb;
import com.google.android.finsky.frameworkviews.be;
import com.google.android.finsky.frameworkviews.bg;
import com.google.android.finsky.ratereview.p;
import com.google.android.finsky.utils.n;
import com.google.android.play.utils.c;

public final class g
{
  private final n a;
  private final p b;
  
  public g(n paramn, p paramp)
  {
    this.a = paramn;
    this.b = paramp;
  }
  
  private static az a(Document paramDocument, int paramInt, boolean paramBoolean)
  {
    az localaz = new az();
    localaz.a = paramDocument.a.g;
    localaz.c = paramInt;
    localaz.b = paramBoolean;
    return localaz;
  }
  
  public final be a(Context paramContext, ka paramka, Document paramDocument, int paramInt)
  {
    be localbe = new be();
    localbe.a = paramDocument.a.s;
    localbe.o = paramka.d;
    localbe.s = paramInt;
    Object localObject1 = paramka.a;
    Object localObject2;
    if (localObject1 != null)
    {
      localbe.k = ((de)localObject1).I;
      localObject2 = c.a((de)localObject1, 4);
      if (localObject2 == null) {
        break label762;
      }
      localObject1 = new as();
      ((as)localObject1).a = ((bu)localObject2).g;
      ((as)localObject1).b = ((bu)localObject2).h;
    }
    for (;;)
    {
      localbe.j = ((as)localObject1);
      localObject1 = paramka.a.o;
      if (localObject1 != null)
      {
        localObject1 = ((cx)localObject1).h;
        if (localObject1 != null) {
          break label749;
        }
      }
      for (;;)
      {
        boolean bool1;
        if (!paramka.m) {
          if (paramka.e()) {
            if (paramka.f()) {
              if (paramka.d()) {
                if (paramka.r <= paramka.k) {
                  bool1 = false;
                }
              }
            }
          }
        }
        for (;;)
        {
          localbe.b = bool1;
          bool1 = localbe.b;
          localObject1 = new bb();
          ((bb)localObject1).a = paramDocument.a.g;
          switch (((bb)localObject1).a)
          {
          default: 
            ((bb)localObject1).d = 0;
          }
          for (;;)
          {
            ((bb)localObject1).c = paramka.c();
            if (!paramka.c()) {}
            for (;;)
            {
              if (paramka.d()) {
                ((bb)localObject1).b = this.a.a(paramka.r);
              }
              ((bb)localObject1).e = bool1;
              localbe.p = ((bb)localObject1);
              boolean bool2;
              if (paramDocument.a.g == 3)
              {
                localObject2 = paramka.g;
                localObject1 = paramka.f;
                bool1 = TextUtils.isEmpty((CharSequence)localObject2);
                bool2 = TextUtils.isEmpty((CharSequence)localObject1);
                if ((bool1 ^ true))
                {
                  com.google.android.finsky.ds.a.o localo = paramDocument.U();
                  if ((!localo.b()) || (!((String)localObject2).equals(localo.E))) {
                    if ((bool2 ^ true)) {
                      paramContext = paramContext.getString(2131953203, new Object[] { localObject1 });
                    }
                  }
                }
              }
              for (;;)
              {
                localbe.m = paramContext;
                localbe.r = paramka.s;
                localbe.l = paramka.e;
                localbe.t = false;
                localbe.c = this.b.a(localbe.a, localbe.o, com.google.android.finsky.ratereview.o.a);
                localbe.f = this.b.a(localbe.a, localbe.o, com.google.android.finsky.ratereview.o.d);
                localbe.d = this.b.a(localbe.a, localbe.o, com.google.android.finsky.ratereview.o.b);
                localbe.g = this.b.a(localbe.a, localbe.o, com.google.android.finsky.ratereview.o.c);
                localbe.n = paramka.q;
                localbe.h = a(paramDocument, 1, localbe.c);
                localbe.i = a(paramDocument, 2, localbe.g);
                if (paramka.e())
                {
                  paramContext = new bg();
                  paramContext.d = paramka.d;
                  paramContext.a = paramDocument.a.l;
                  if (paramka.f()) {
                    paramContext.c = this.a.a(paramka.k);
                  }
                  paramContext.b = paramka.j;
                  paramContext.e = false;
                  localbe.q = paramContext;
                }
                return localbe;
                paramContext = paramContext.getString(2131953202);
                continue;
                paramContext = (Context)localObject1;
                if (bool2)
                {
                  paramContext = null;
                  continue;
                  paramContext = (Context)localObject1;
                  if (bool2)
                  {
                    paramContext = null;
                    continue;
                    paramContext = null;
                  }
                }
              }
              ((bb)localObject1).f = paramka.o;
            }
            ((bb)localObject1).d = 1;
            continue;
            ((bb)localObject1).d = 3;
          }
          bool1 = true;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = true;
        }
        label749:
        localbe.e = ((cy)localObject1).a;
      }
      label762:
      localObject1 = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bv/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */