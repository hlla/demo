package com.google.android.finsky.bh;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.ds;
import com.google.android.finsky.ds.a.hr;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.utils.FinskyLog;
import com.google.common.a.dk;
import com.google.common.a.du;
import com.google.common.a.ea;
import com.google.common.a.eq;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  public final Map a = new HashMap();
  private final b.a b;
  private final b.a c;
  
  public b(b.a parama1, b.a parama2)
  {
    this.c = parama1;
    this.b = parama2;
  }
  
  public static hr a(com.google.wireless.android.finsky.b.d paramd)
  {
    if (paramd != null)
    {
      hr localhr = new hr();
      int i = paramd.a;
      localhr.b |= 0x1;
      localhr.a = i;
      long l = paramd.f;
      localhr.b |= 0x2;
      localhr.c = l;
      return localhr;
    }
    return null;
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    if (paramLong != -1L)
    {
      if (paramLong <= 0L) {
        FinskyLog.c("Found negative or zero app size", new Object[0]);
      }
    }
    else {
      return null;
    }
    return Formatter.formatShortFileSize(paramContext, paramLong);
  }
  
  private static Map a(ds[] paramArrayOfds)
  {
    if (paramArrayOfds != null)
    {
      int j = paramArrayOfds.length;
      HashMap localHashMap = new HashMap(j);
      int i = 0;
      for (;;)
      {
        localObject = localHashMap;
        if (i >= j) {
          break;
        }
        localObject = paramArrayOfds[i];
        localHashMap.put(new a(((ds)localObject).c, ((ds)localObject).f), localObject);
        i += 1;
      }
    }
    Object localObject = new HashMap();
    return (Map)localObject;
  }
  
  public final long a(Document paramDocument, boolean paramBoolean)
  {
    Object localObject1 = paramDocument.U();
    if (localObject1 != null)
    {
      com.google.android.finsky.dh.b localb = ((com.google.android.finsky.dh.a)this.c.a()).a(((o)localObject1).t);
      if (localb != null) {}
      for (int i = localb.f;; i = -1)
      {
        paramDocument = ((com.google.android.finsky.cg.b)this.b.a()).a(((o)localObject1).t);
        if (paramDocument != null) {}
        for (paramDocument = paramDocument.e;; paramDocument = null)
        {
          HashSet localHashSet = new HashSet();
          Object localObject2;
          if (localb != null)
          {
            localObject2 = localb.p;
            if (localObject2 != null) {
              localHashSet.addAll(Arrays.asList((Object[])localObject2));
            }
          }
          Map localMap = a(((o)localObject1).n);
          if (!paramBoolean) {}
          for (localObject1 = dk.a;; localObject1 = a(paramDocument.n))
          {
            eq localeq = (eq)du.a(localMap.keySet(), ((Map)localObject1).keySet()).iterator();
            long l2 = 0L;
            do
            {
              l1 = l2;
              if (!localeq.hasNext()) {
                break;
              }
              localObject3 = (d)localeq.next();
              paramDocument = (ds)localMap.get(localObject3);
              localObject2 = paramDocument;
              if (paramDocument == null) {
                localObject2 = (ds)((Map)localObject1).get(localObject3);
              }
            } while ((i >= ((ds)localObject2).g) && ((TextUtils.isEmpty(((ds)localObject2).f)) || (localHashSet.contains(((ds)localObject2).f))));
            Object localObject3 = (ds)((Map)localObject1).get(localObject3);
            l1 = ((ds)localObject2).e;
            long l3;
            if ((((ds)localObject2).a & 0x8) != 0)
            {
              l3 = ((ds)localObject2).b;
              if (l3 > 0L) {
                l1 = l3;
              }
            }
            for (;;)
            {
              l3 = l1;
              if (localb != null) {
                if (localb.m)
                {
                  l3 = l1;
                  if (!localb.n) {}
                }
                else
                {
                  paramDocument = ((ds)localObject2).d;
                  if (paramDocument == null) {
                    break label388;
                  }
                }
              }
              for (;;)
              {
                l3 = l1;
                if (paramDocument != null)
                {
                  l3 = l1;
                  if (paramDocument.a <= localb.f) {
                    l3 = paramDocument.c;
                  }
                }
                l2 += l3;
                break;
                label388:
                if (localObject3 != null) {
                  if (((ds)localObject3).g == ((ds)localObject2).g) {
                    paramDocument = ((ds)localObject3).d;
                  } else {}
                }
              }
            }
            if ((paramDocument == null) || (paramDocument.D != ((o)localObject1).D)) {
              break;
            }
          }
        }
      }
    }
    long l1 = 0L;
    return l1;
  }
  
  public final String a(Context paramContext, Document paramDocument)
  {
    return a(paramContext, a(paramDocument, true));
  }
  
  public final void a(Document paramDocument)
  {
    o localo = paramDocument.U();
    if (localo != null)
    {
      long l = a(paramDocument, true);
      a(localo.t);
      this.a.put(localo.t, new c(localo.D, l));
    }
  }
  
  public final void a(String paramString)
  {
    this.a.remove(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bh/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */