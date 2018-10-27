package com.google.android.finsky.dd;

import com.google.android.finsky.accounts.c;
import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dfemodel.t;
import com.google.android.finsky.ds.a.by;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.fs;
import com.google.android.finsky.library.e;
import com.google.android.finsky.library.r;
import java.util.List;

public final class b
{
  public final c a;
  public final r b;
  
  public b(c paramc, r paramr)
  {
    this.a = paramc;
    this.b = paramr;
  }
  
  public static float a(by paramby)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (paramby.d())
    {
      long l1 = paramby.h;
      long l2 = l1 - paramby.k;
      f1 = f2;
      if (l1 > 0L)
      {
        f1 = f2;
        if (l2 > 0L) {
          f1 = (float)l2 / (float)l1;
        }
      }
    }
    return f1;
  }
  
  public static int a(by[] paramArrayOfby)
  {
    int j = 0;
    int m = paramArrayOfby.length;
    int i = 0;
    if (i < m)
    {
      by localby = paramArrayOfby[i];
      int k = j;
      if (localby.c())
      {
        k = localby.m;
        if (k != 1) {
          break label53;
        }
      }
      label40:
      for (k = j + 1;; k = j)
      {
        i += 1;
        j = k;
        break;
        label53:
        if ((k == 7) || (k == 3) || (k == 4)) {
          break label40;
        }
      }
    }
    return j;
  }
  
  public static by a(by[] paramArrayOfby, boolean paramBoolean, t paramt)
  {
    int j = paramArrayOfby.length;
    Object localObject = null;
    int i = 0;
    long l1 = Long.MAX_VALUE;
    if (i < j)
    {
      by localby = paramArrayOfby[i];
      int k;
      if (localby.c())
      {
        k = localby.m;
        if ((k == 1) || (k == 7) || (k == 3) || (k == 4)) {}
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramt == null) {}
        while (paramt.a(k))
        {
          long l2 = localby.k;
          if ((!paramBoolean) && (l2 == 0L)) {
            break;
          }
          if (l2 < l1)
          {
            l1 = l2;
            localObject = localby;
            break;
          }
          break;
        }
      }
    }
    return (by)localObject;
  }
  
  private static by b(by[] paramArrayOfby)
  {
    int j = paramArrayOfby.length;
    Object localObject = null;
    float f1 = 0.0F;
    int i = 0;
    if (i < j)
    {
      by localby = paramArrayOfby[i];
      float f2 = a(localby);
      if (f2 > f1) {
        localObject = localby;
      }
      if (f2 > f1) {
        f1 = f2;
      }
      for (;;)
      {
        i += 1;
        break;
      }
    }
    return (by)localObject;
  }
  
  public final by a(Document paramDocument, DfeToc paramDfeToc, e parame)
  {
    Object localObject1 = paramDocument.a;
    int i = ((de)localObject1).r;
    if (i == 16) {}
    label89:
    while (i == 24)
    {
      localObject1 = paramDocument.ac();
      if (localObject1 == null) {}
      for (;;)
      {
        Object localObject2 = this.b.b(paramDocument, paramDfeToc, parame);
        int k = ((List)localObject2).size();
        if (k <= 0) {}
        do
        {
          paramDocument = paramDocument.bE();
          if (paramDocument != null)
          {
            paramDfeToc = b(paramDocument, paramDfeToc, parame);
            if (paramDfeToc != null)
            {
              paramDocument = paramDfeToc;
              if (paramDfeToc.c()) {
                break label89;
              }
            }
          }
          paramDocument = null;
          return paramDocument;
          if (k == 1) {
            localObject1 = ((Document)((List)localObject2).get(0)).a.w;
          }
          for (;;)
          {
            localObject2 = a((by[])localObject1, false, null);
            if (localObject2 == null) {}
            for (localObject1 = a((by[])localObject1, true, null); localObject1 != null; localObject1 = localObject2) {
              return (by)localObject1;
            }
            break;
            i = 0;
            int j = 0;
            while (i < k)
            {
              j += ((Document)((List)localObject2).get(i)).a.w.length;
              i += 1;
            }
            localObject1 = new by[j];
            i = 0;
            j = 0;
            while (i < k)
            {
              by[] arrayOfby = ((Document)((List)localObject2).get(i)).a.w;
              int m = arrayOfby.length;
              System.arraycopy(arrayOfby, 0, localObject1, j, m);
              j += m;
              i += 1;
            }
          }
        } while (((fs)localObject1).c);
      }
    }
    return a(((de)localObject1).w, true, null);
  }
  
  public final by b(Document paramDocument, DfeToc paramDfeToc, e parame)
  {
    if (paramDocument != null)
    {
      int i = paramDocument.a.r;
      if (i == 17) {}
      label81:
      while (i == 25)
      {
        if (this.b.a(paramDocument, paramDfeToc, parame))
        {
          parame = paramDocument.a.w;
          int j = parame.length;
          i = 0;
          while (i < j)
          {
            paramDfeToc = parame[i];
            paramDocument = paramDfeToc;
            if (paramDfeToc.m == 1) {
              break label81;
            }
            i += 1;
          }
        }
        paramDocument = null;
        return paramDocument;
      }
      return null;
    }
    return null;
  }
  
  public final by c(Document paramDocument, DfeToc paramDfeToc, e parame)
  {
    Object localObject = paramDocument.a;
    int i = ((de)localObject).r;
    if (i == 16) {}
    while (i == 24)
    {
      List localList = this.b.b(paramDocument, paramDfeToc, parame);
      int j = localList.size();
      float f1 = 0.0F;
      localObject = null;
      i = 0;
      if (i < j)
      {
        by localby = b(((Document)localList.get(i)).a.w);
        if (localby != null)
        {
          float f2 = a(localby);
          if (f2 > f1)
          {
            f1 = f2;
            localObject = localby;
          }
        }
        for (;;)
        {
          i += 1;
          break;
        }
      }
      paramDocument = paramDocument.bE();
      if (paramDocument != null)
      {
        paramDocument = b(paramDocument, paramDfeToc, parame);
        if ((paramDocument != null) && (paramDocument.c()) && (a(paramDocument) > f1)) {}
      }
      else
      {
        return (by)localObject;
      }
      return paramDocument;
    }
    return b(((de)localObject).w);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dd/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */