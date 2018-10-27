package com.airbnb.lottie.a.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
public final class k
  implements j, m
{
  private final Path a = new Path();
  private final com.airbnb.lottie.c.b.j b;
  private final String c;
  private final Path d = new Path();
  private final List e = new ArrayList();
  private final Path f = new Path();
  
  public k(com.airbnb.lottie.c.b.j paramj)
  {
    if (Build.VERSION.SDK_INT < 19) {
      throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }
    this.c = paramj.b;
    this.b = paramj;
  }
  
  @TargetApi(19)
  private final void a(Path.Op paramOp)
  {
    int k = 0;
    this.f.reset();
    this.a.reset();
    int i = this.e.size() - 1;
    List localList;
    Path localPath;
    while (i > 0)
    {
      localm = (m)this.e.get(i);
      if ((localm instanceof d))
      {
        localList = ((d)localm).c();
        int j = localList.size() - 1;
        while (j >= 0)
        {
          localPath = ((m)localList.get(j)).e();
          localPath.transform(((d)localm).d());
          this.f.addPath(localPath);
          j -= 1;
        }
      }
      this.f.addPath(localm.e());
      i -= 1;
    }
    m localm = (m)this.e.get(0);
    if ((localm instanceof d))
    {
      localList = ((d)localm).c();
      i = k;
      while (i < localList.size())
      {
        localPath = ((m)localList.get(i)).e();
        localPath.transform(((d)localm).d());
        this.a.addPath(localPath);
        i += 1;
      }
    }
    this.a.set(localm.e());
    this.d.op(this.a, this.f, paramOp);
  }
  
  public final void a(List paramList1, List paramList2)
  {
    int i = 0;
    while (i < this.e.size())
    {
      ((m)this.e.get(i)).a(paramList1, paramList2);
      i += 1;
    }
  }
  
  public final void a(ListIterator paramListIterator)
  {
    for (;;)
    {
      if (!paramListIterator.hasPrevious()) {}
      while (paramListIterator.previous() == this) {
        while (paramListIterator.hasPrevious())
        {
          c localc = (c)paramListIterator.previous();
          if ((localc instanceof m))
          {
            this.e.add((m)localc);
            paramListIterator.remove();
          }
        }
      }
    }
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final Path e()
  {
    this.d.reset();
    switch (l.a[this.b.a.ordinal()])
    {
    }
    for (;;)
    {
      return this.d;
      a(Path.Op.UNION);
      continue;
      int i = 0;
      while (i < this.e.size())
      {
        this.d.addPath(((m)this.e.get(i)).e());
        i += 1;
      }
      a(Path.Op.XOR);
      continue;
      a(Path.Op.INTERSECT);
      continue;
      a(Path.Op.REVERSE_DIFFERENCE);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */