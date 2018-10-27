package com.google.android.finsky.bv;

import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.bu;
import com.google.android.finsky.ds.a.bv;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.frameworkviews.bl;
import com.google.android.finsky.frameworkviews.bm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private static bu a(Document paramDocument, int... paramVarArgs)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDocument != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = paramDocument.c(paramVarArgs[i]);
        if (localObject1 == null) {}
        while (((List)localObject1).isEmpty())
        {
          i += 1;
          break;
        }
        localObject1 = (bu)((List)localObject1).get(0);
      }
    }
    return (bu)localObject1;
  }
  
  public static bl a(Document paramDocument, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    bl localbl = new bl();
    localbl.e = paramDocument.a.I;
    localbl.f = -1;
    Object localObject1 = paramDocument.c(1);
    Object localObject2 = new ArrayList();
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (bu)((Iterator)localObject1).next();
        bm localbm = new bm();
        localbm.b = ((bu)localObject3);
        localbm.f = 0;
        ((List)localObject2).add(localbm);
      }
      if (paramDocument.an() != 12)
      {
        localObject1 = paramDocument.c(3);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          break label302;
        }
      }
    }
    label286:
    label302:
    while (!paramBoolean1)
    {
      localbl.d = ((List)localObject2);
      localbl.c = paramInt;
      paramDocument = localbl.d;
      localbl.a = true;
      localbl.b = true;
      paramInt = 0;
      if ((paramInt >= paramDocument.size()) || (!localbl.b)) {
        break;
      }
      localObject1 = (bm)paramDocument.get(paramInt);
      localObject2 = ((bm)localObject1).b;
      if ((paramBoolean2) && (((bm)localObject1).f == 1)) {}
      for (;;)
      {
        paramInt += 1;
        break;
        localObject1 = ((bu)localObject2).d;
        int i;
        int j;
        if (localObject1 != null)
        {
          i = ((bv)localObject1).a;
          if (i > 0)
          {
            j = ((bv)localObject1).b;
            if (j > 0) {
              break label286;
            }
          }
        }
        localbl.a = false;
        localbl.b = false;
        continue;
        if (j > i) {
          localbl.a = false;
        }
      }
    }
    switch (paramDocument.a.r)
    {
    default: 
      localObject1 = a(paramDocument, new int[] { 4, 0 });
    }
    while (localObject1 != null)
    {
      localObject3 = new bm();
      ((bm)localObject3).b = ((bu)localObject1);
      ((bm)localObject3).f = 1;
      ((bm)localObject3).e = ((bu)paramDocument.c(3).get(0)).g;
      paramDocument = paramDocument.a;
      ((bm)localObject3).c = paramDocument.v;
      ((bm)localObject3).a = paramDocument.g;
      if (paramDocument.r == 6) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ((bm)localObject3).d = paramBoolean1;
        ((List)localObject2).add(0, localObject3);
        localbl.f = 0;
        break;
      }
      localObject1 = null;
      continue;
      localObject1 = a(paramDocument, new int[] { 14, 0 });
      continue;
      localObject1 = a(paramDocument, new int[] { 14 });
      continue;
      localObject1 = a(paramDocument, new int[] { 14 });
      continue;
      localObject1 = a(paramDocument, new int[] { 13, 2, 4 });
      continue;
      localObject1 = a(paramDocument, new int[] { 2, 4 });
      continue;
      localObject1 = a(paramDocument, new int[] { 14 });
      continue;
      localObject1 = a(paramDocument, new int[] { 14 });
      continue;
      localObject1 = a(paramDocument, new int[] { 1 });
      continue;
      localObject1 = a(paramDocument, new int[] { 0, 13 });
      continue;
      localObject1 = a(paramDocument, new int[] { 4, 0 });
      continue;
      localObject1 = a(paramDocument, new int[] { 4, 0 });
      continue;
      localObject1 = a(paramDocument, new int[] { 2 });
    }
    return localbl;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bv/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */