package com.airbnb.lottie.c.c;

import com.airbnb.lottie.c.a.c;
import com.airbnb.lottie.c.a.t;
import com.airbnb.lottie.c.a.v;
import com.airbnb.lottie.c.a.w;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class g
{
  public final com.airbnb.lottie.i a;
  public final List b;
  public final long c;
  public final String d;
  public final i e;
  public final List f;
  public final j g;
  public final long h;
  public final int i;
  public final int j;
  public final String k;
  public final List l;
  public final int m;
  public final int n;
  public final int o;
  public final float p;
  public final t q;
  public final v r;
  public final c s;
  public final float t;
  public final w u;
  
  static
  {
    g.class.getSimpleName();
  }
  
  private g(List paramList1, com.airbnb.lottie.i parami, String paramString1, long paramLong1, i parami1, long paramLong2, String paramString2, List paramList2, w paramw, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, int paramInt5, t paramt, v paramv, List paramList3, j paramj, c paramc)
  {
    this.l = paramList1;
    this.a = parami;
    this.d = paramString1;
    this.c = paramLong1;
    this.e = parami1;
    this.h = paramLong2;
    this.k = paramString2;
    this.f = paramList2;
    this.u = paramw;
    this.o = paramInt1;
    this.n = paramInt2;
    this.m = paramInt3;
    this.t = paramFloat1;
    this.p = paramFloat2;
    this.j = paramInt4;
    this.i = paramInt5;
    this.q = paramt;
    this.r = paramv;
    this.b = paramList3;
    this.g = paramj;
    this.s = paramc;
  }
  
  public final String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n");
    Object localObject1 = this.a.a(this.h);
    if (localObject1 != null)
    {
      localStringBuilder.append("\t\tParents: ");
      localStringBuilder.append(((g)localObject1).d);
      for (localObject1 = this.a.a(((g)localObject1).h); localObject1 != null; localObject1 = this.a.a(((g)localObject1).h))
      {
        localStringBuilder.append("->");
        localStringBuilder.append(((g)localObject1).d);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
    }
    if (!this.f.isEmpty())
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tMasks: ");
      localStringBuilder.append(this.f.size());
      localStringBuilder.append("\n");
    }
    if ((this.o != 0) && (this.n != 0))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tBackground: ");
      localStringBuilder.append(String.format(Locale.US, "%dx%d %X\n", new Object[] { Integer.valueOf(this.o), Integer.valueOf(this.n), Integer.valueOf(this.m) }));
    }
    if (!this.l.isEmpty())
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tShapes:\n");
      localObject1 = this.l.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        localStringBuilder.append(paramString);
        localStringBuilder.append("\t\t");
        localStringBuilder.append(localObject2);
        localStringBuilder.append("\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return a("");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */