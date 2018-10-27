package com.google.android.finsky.av;

import com.google.android.finsky.ag.d;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dh.b;
import com.google.android.finsky.ds.a.cq;
import com.google.android.finsky.ds.a.fa;
import com.google.android.finsky.l.k;
import com.google.android.finsky.utils.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class m
{
  private final com.google.android.finsky.bo.c a;
  private final com.google.android.finsky.library.c b;
  private final com.google.android.finsky.dh.a c;
  private final k d;
  
  public m(k paramk, com.google.android.finsky.dh.a parama, com.google.android.finsky.bo.c paramc, com.google.android.finsky.library.c paramc1)
  {
    this.d = paramk;
    this.c = parama;
    this.a = paramc;
    this.b = paramc1;
  }
  
  public static boolean a(Document paramDocument, String paramString, int paramInt)
  {
    boolean bool2 = false;
    paramDocument = b(paramDocument);
    boolean bool1 = bool2;
    if (paramDocument != null)
    {
      int j = paramDocument.length;
      int i = 0;
      bool1 = bool2;
      if (i < j)
      {
        cq localcq = paramDocument[i];
        if (!paramString.equals(localcq.c)) {}
        while ((localcq.b < paramInt) || (a(localcq)))
        {
          i += 1;
          break;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean a(cq paramcq)
  {
    return (paramcq.c()) && (paramcq.a);
  }
  
  private static cq[] b(Document paramDocument)
  {
    paramDocument = paramDocument.E();
    if (paramDocument != null) {
      return paramDocument.d;
    }
    return null;
  }
  
  public final List a(Document paramDocument)
  {
    return a(paramDocument, j.b((String)d.Y.b()));
  }
  
  public final List a(Document paramDocument, Set paramSet)
  {
    if (!this.a.cY().a(12643667L)) {
      return Collections.emptyList();
    }
    paramDocument = b(paramDocument);
    if (paramDocument == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramDocument.length;
    int i = 0;
    if (i < j)
    {
      cq localcq = paramDocument[i];
      Object localObject;
      boolean bool2;
      boolean bool3;
      if (paramSet.contains(localcq.c))
      {
        localObject = this.c.a(localcq.c);
        this.d.a(localcq).a((b)localObject);
        bool2 = this.d.a();
        bool3 = a(localcq);
        localObject = this.b.a(localcq.c);
        if (this.c.a(localcq.c) == null) {
          break label192;
        }
      }
      label192:
      for (boolean bool1 = true;; bool1 = false)
      {
        localArrayList.add(new n(bool2 ^ true, bool3, (List)localObject, bool1));
        i += 1;
        break;
      }
    }
    return localArrayList;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/av/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */