package com.google.android.finsky.l;

import com.google.android.finsky.bo.f;
import com.google.android.finsky.ds.a.cq;
import com.google.android.finsky.ds.a.fa;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.installer.b.a.d;
import com.google.android.finsky.utils.FinskyLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class k
{
  public boolean a = false;
  public int b = 0;
  public long c = 0L;
  public String[] d = null;
  public int e = -1;
  public boolean f = false;
  public long g = 0L;
  private final com.google.android.finsky.bo.c h;
  private int i = 0;
  private String[] j = null;
  private int k = -1;
  
  public k(com.google.android.finsky.bo.c paramc)
  {
    this.h = paramc;
  }
  
  private final int j()
  {
    int m = 1;
    int n = h();
    if ((n != 0) || (!this.f))
    {
      if ((this.h.cY().a(12650166L)) && (n == 1) && (this.a))
      {
        FinskyLog.a("disabled update for system preview app", new Object[0]);
        m = 0;
      }
    }
    else {
      return m;
    }
    return n;
  }
  
  public final k a(int paramInt, fa paramfa, String[] paramArrayOfString)
  {
    this.k = paramInt;
    if (paramfa != null) {}
    for (paramInt = paramfa.e;; paramInt = 0)
    {
      this.i = paramInt;
      if (paramfa != null) {}
      for (long l = paramfa.f;; l = 0L)
      {
        this.g = l;
        if (paramfa != null) {}
        for (paramfa = paramfa.i;; paramfa = null)
        {
          this.j = ((String[])com.google.android.finsky.utils.b.a(paramfa, paramArrayOfString));
          return this;
        }
      }
    }
  }
  
  public final k a(com.google.android.finsky.cg.c paramc)
  {
    if (paramc != null) {}
    for (int m = paramc.n;; m = -1)
    {
      this.k = m;
      if (paramc != null) {}
      for (m = paramc.l;; m = 0)
      {
        this.i = m;
        this.g = 0L;
        Object localObject = paramc.w;
        if (localObject != null)
        {
          localObject = ((d)localObject).g;
          if (localObject != null)
          {
            if ((((fa)localObject).c & 0x10) != 0) {
              this.g = ((fa)localObject).f;
            }
            this.j = ((fa)localObject).i;
          }
        }
        this.j = ((String[])com.google.android.finsky.utils.b.a(this.j, paramc.J));
        return this;
      }
    }
  }
  
  public final k a(com.google.android.finsky.dh.b paramb)
  {
    boolean bool2 = false;
    if (paramb != null) {}
    for (int m = paramb.f;; m = -1)
    {
      this.e = m;
      if (paramb != null) {}
      for (m = paramb.d;; m = 0)
      {
        this.b = m;
        if (paramb != null) {}
        for (long l = paramb.e;; l = 0L)
        {
          this.c = l;
          if (paramb != null) {}
          for (String[] arrayOfString = paramb.p;; arrayOfString = null)
          {
            this.d = arrayOfString;
            boolean bool1;
            if (paramb != null) {
              if (paramb.k) {
                bool1 = true;
              }
            }
            for (;;)
            {
              this.f = bool1;
              bool1 = bool2;
              if (paramb != null)
              {
                bool1 = bool2;
                if (paramb.c) {
                  bool1 = true;
                }
              }
              this.a = bool1;
              return this;
              bool1 = false;
              continue;
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public final k a(cq paramcq)
  {
    return a(paramcq.b, null, null);
  }
  
  public final k a(o paramo)
  {
    if (paramo != null) {
      a(paramo.D, paramo.o, null);
    }
    return this;
  }
  
  public final boolean a()
  {
    return j() > 0;
  }
  
  public final boolean b()
  {
    return j() < 0;
  }
  
  public final boolean c()
  {
    return (h() == 0) && (!i().isEmpty());
  }
  
  public final boolean d()
  {
    return (a()) || (c()) || (g());
  }
  
  public final String e()
  {
    int m = this.k;
    int n = this.i;
    long l = this.g;
    StringBuilder localStringBuilder = new StringBuilder(44);
    localStringBuilder.append(m);
    localStringBuilder.append(".");
    localStringBuilder.append(n);
    localStringBuilder.append(".");
    localStringBuilder.append(l);
    return localStringBuilder.toString();
  }
  
  public final String f()
  {
    int m = this.e;
    int n = this.b;
    long l = this.c;
    StringBuilder localStringBuilder = new StringBuilder(44);
    localStringBuilder.append(m);
    localStringBuilder.append(".");
    localStringBuilder.append(n);
    localStringBuilder.append(".");
    localStringBuilder.append(l);
    return localStringBuilder.toString();
  }
  
  public final boolean g()
  {
    boolean bool2 = false;
    f localf = this.h.cY();
    boolean bool1 = bool2;
    if (localf.a(12637130L))
    {
      bool1 = bool2;
      if (localf.a(12643849L)) {
        if (localf.a(12650166L))
        {
          bool1 = bool2;
          if (this.a) {}
        }
        else
        {
          bool1 = bool2;
          if (j() == 0)
          {
            bool1 = bool2;
            if (this.g > this.c)
            {
              int m = this.e;
              m = this.b;
              long l = this.c;
              m = this.k;
              m = this.i;
              l = this.g;
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final int h()
  {
    int m = this.k;
    int n = this.e;
    if (m <= n)
    {
      if (m != n) {
        break label116;
      }
      m = Integer.valueOf(this.i).compareTo(Integer.valueOf(this.b));
      if ((m == 0) && (this.h.cY().a(12637130L)) && (this.g == -1L) && (this.c != 0L))
      {
        m = this.e;
        m = this.b;
        long l = this.c;
        m = this.k;
        m = this.i;
        l = this.g;
      }
    }
    else
    {
      return 1;
    }
    return m;
    label116:
    return -1;
  }
  
  public final Set i()
  {
    Object localObject = this.j;
    if ((localObject == null) || (localObject.length == 0)) {
      localObject = Collections.emptySet();
    }
    HashSet localHashSet;
    String[] arrayOfString;
    do
    {
      do
      {
        return (Set)localObject;
        localHashSet = new HashSet(Arrays.asList((Object[])localObject));
        arrayOfString = this.d;
        localObject = localHashSet;
      } while (arrayOfString == null);
      localObject = localHashSet;
    } while (arrayOfString.length <= 0);
    localHashSet.removeAll(Arrays.asList(arrayOfString));
    return localHashSet;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/l/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */