package com.google.android.play.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView.ScaleType;
import com.android.volley.r;
import com.google.android.play.utils.PlayCommonLog;
import com.google.android.play.utils.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class d
  implements p, x
{
  public int a = 100;
  public final HashMap b = new HashMap();
  public final HashMap c = new HashMap();
  public boolean d;
  public Runnable e;
  private final v f;
  private final o g;
  private aa h;
  private final Handler i = new Handler(Looper.getMainLooper());
  private final l j;
  private final n k;
  private final r l;
  private ab m;
  private ac n;
  private final bz o;
  
  public d(r paramr, bz parambz, n paramn, boolean paramBoolean, int paramInt)
  {
    this(paramr, parambz, paramn, paramBoolean, paramInt, null, null);
  }
  
  public d(r paramr, bz parambz, n paramn, boolean paramBoolean, int paramInt, o paramo, l paraml)
  {
    this.l = paramr;
    int i1 = Math.max(((Integer)com.google.android.play.utils.b.j.p.b()).intValue(), paramInt / 6);
    if (paramBoolean) {}
    for (this.f = new bw(paramInt, i1);; this.f = new b(paramInt, i1))
    {
      this.o = parambz;
      this.k = paramn;
      this.j = paraml;
      this.g = paramo;
      return;
    }
  }
  
  private final void a(String paramString, bv parambv)
  {
    this.b.put(paramString, parambv);
    if (this.e == null)
    {
      this.e = new i(this);
      this.i.postDelayed(this.e, this.a);
    }
  }
  
  private final void b(bv parambv)
  {
    this.i.post(new h(this, parambv));
  }
  
  public final v a()
  {
    return this.f;
  }
  
  public final y a(String paramString, int paramInt1, int paramInt2, z paramz)
  {
    return a(paramString, paramInt1, paramInt2, true, paramz, false);
  }
  
  public final y a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, z paramz, boolean paramBoolean2)
  {
    if (paramInt1 > 0) {}
    for (String str = bg.a(paramString, paramInt1, paramInt2);; str = paramString)
    {
      Object localObject1 = new m(paramString, str, paramString, paramInt1, paramInt2, Config.RGB_565, ImageView.ScaleType.CENTER_INSIDE, paramBoolean2);
      if (TextUtils.isEmpty(paramString)) {
        return new j(this, null, (m)localObject1, null);
      }
      if (!paramBoolean2) {}
      for (paramString = this.f.a(paramString, paramInt1, paramInt2);; paramString = null)
      {
        Object localObject2;
        if (paramString != null)
        {
          localObject2 = paramString.a;
          if (localObject2 != null) {
            if (((Bitmap)localObject2).isRecycled()) {
              paramString = null;
            }
          }
        }
        for (;;)
        {
          if (paramString != null)
          {
            int i1;
            if (paramString.c == paramInt1) {
              if (paramString.b == paramInt2) {
                i1 = 1;
              }
            }
            for (;;)
            {
              br.a();
              if (i1 == 0) {
                break;
              }
              paramz = this.h;
              if (paramz != null) {
                paramz.a();
              }
              return new j(this, paramString.a, (m)localObject1, null);
              i1 = 0;
              continue;
              i1 = 0;
            }
          }
          if (!paramBoolean1) {
            paramString = null;
          }
          for (;;)
          {
            localObject2 = this.h;
            if (localObject2 == null)
            {
              paramz = new j(this, paramString, (m)localObject1, paramz);
              if (!paramBoolean1) {}
              for (;;)
              {
                paramString = (bv)this.c.get(str);
                if (paramString == null)
                {
                  if (this.g == null)
                  {
                    paramInt1 *= paramInt2;
                    this.o.a(paramInt1 + paramInt1);
                    paramString = new e(this, (m)localObject1);
                    localObject2 = new f(this, str);
                    localObject3 = this.k;
                    if (localObject3 == null) {}
                    for (paramString = new k((m)localObject1, paramString, (com.android.volley.w)localObject2);; paramString = ((n)localObject3).a((m)localObject1, paramString, (com.android.volley.w)localObject2))
                    {
                      localObject1 = this.m;
                      if (localObject1 != null) {
                        paramString.g = new com.android.volley.f(((ab)localObject1).a(), 2, 2.0F);
                      }
                      this.l.a(paramString);
                      this.c.put(str, new bv(paramString, paramz));
                      return paramz;
                    }
                  }
                  localObject2 = new bv(null, paramz);
                  paramString = new g(this, str);
                  Object localObject3 = this.g;
                  bz localbz = this.o;
                  l locall = this.j;
                  if (locall == null) {}
                  for (paramString = new bu((m)localObject1, null, paramString, (o)localObject3, this, localbz, (bv)localObject2);; paramString = locall.a((m)localObject1, paramString, (o)localObject3, this, localbz, (bv)localObject2))
                  {
                    ((bv)localObject2).c = paramString;
                    localObject1 = this.m;
                    if (localObject1 != null) {
                      paramString.g = new com.android.volley.f(((ab)localObject1).a(), 2, 2.0F);
                    }
                    this.l.a(paramString);
                    this.c.put(str, localObject2);
                    break;
                  }
                }
                paramString.a.add(paramz);
                return paramz;
                if (paramString == null)
                {
                  paramString = this.n;
                  if (paramString != null) {
                    paramString.a(paramz, this.f);
                  }
                }
              }
            }
            if (paramString != null) {}
            for (paramBoolean2 = true;; paramBoolean2 = false)
            {
              ((aa)localObject2).a(paramBoolean2);
              break;
            }
            if (paramString != null) {
              paramString = paramString.a;
            } else {
              paramString = null;
            }
          }
          continue;
        }
      }
      if (paramInt2 > 0) {
        break;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.c.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      com.android.volley.n localn = ((bv)this.c.get(str)).c;
      if ((localn == null) || (localn.ab_() < paramInt)) {
        localArrayList.add(str);
      }
    }
    int i1 = localArrayList.size();
    paramInt = 0;
    while (paramInt < i1)
    {
      localObject = (String)localArrayList.get(paramInt);
      this.c.remove(localObject);
      paramInt += 1;
    }
  }
  
  public final void a(Bitmap paramBitmap, m paramm)
  {
    b(paramBitmap, paramm);
  }
  
  public final void a(aa paramaa)
  {
    this.h = paramaa;
  }
  
  public final void a(ab paramab)
  {
    this.m = paramab;
  }
  
  public final void a(ac paramac)
  {
    this.n = paramac;
  }
  
  final void a(bv parambv)
  {
    Object localObject = this.h;
    if (localObject == null) {}
    for (;;)
    {
      localObject = parambv.a;
      int i2 = ((List)localObject).size();
      int i1 = 0;
      if (i1 >= i2) {
        break;
      }
      j localj = (j)((List)localObject).get(i1);
      localj.a = parambv.d;
      z localz = localj.b;
      if (localz == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        localz.a(localj);
      }
      ((aa)localObject).a(parambv.c);
    }
  }
  
  public final void a(String paramString)
  {
    b(paramString);
  }
  
  public final y b(String paramString, int paramInt1, int paramInt2, z paramz)
  {
    return a(paramString, paramInt1, paramInt2, false, paramz, false);
  }
  
  public final void b()
  {
    this.f.a();
  }
  
  final void b(Bitmap paramBitmap, m paramm)
  {
    if (!paramm.h) {
      this.f.a(paramm.a, paramm.e, paramm.c, paramBitmap);
    }
    for (;;)
    {
      bv localbv = (bv)this.c.remove(paramm.g);
      if (localbv != null)
      {
        localbv.d = paramBitmap;
        if (this.a != 0) {
          break label86;
        }
        b(localbv);
      }
      for (;;)
      {
        PlayCommonLog.g("Loaded bitmap %s", new Object[] { localbv.c.ac_() });
        return;
        label86:
        a(paramm.g, localbv);
      }
      PlayCommonLog.b("%s is not cached", new Object[] { paramm.g });
    }
  }
  
  final void b(String paramString)
  {
    bv localbv = (bv)this.c.remove(paramString);
    if (localbv != null)
    {
      if (this.a != 0) {
        break label64;
      }
      b(localbv);
    }
    for (;;)
    {
      paramString = localbv.c;
      if (paramString == null) {}
      for (paramString = "<null request>";; paramString = paramString.ac_())
      {
        PlayCommonLog.g("Bitmap error %s", new Object[] { paramString });
        return;
      }
      label64:
      a(paramString, localbv);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/image/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */