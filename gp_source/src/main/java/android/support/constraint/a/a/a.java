package android.support.constraint.a.a;

import android.support.constraint.a.h;
import android.support.constraint.a.i;
import java.util.HashSet;

public final class a
{
  public int a = 0;
  public c b = c.a;
  public int c = 0;
  public final f d;
  public h e;
  public d f = d.a;
  public a g;
  public final e h;
  private int i = -1;
  
  public a(f paramf, e parame)
  {
    this.d = paramf;
    this.h = parame;
  }
  
  private final String a(HashSet paramHashSet)
  {
    if (paramHashSet.add(this))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(null);
      localStringBuilder1.append(":");
      localStringBuilder1.append(this.h.toString());
      StringBuilder localStringBuilder2;
      if (this.g != null)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(" connected to ");
        localStringBuilder2.append(this.g.a(paramHashSet));
      }
      for (paramHashSet = localStringBuilder2.toString();; paramHashSet = "")
      {
        localStringBuilder1.append(paramHashSet);
        return localStringBuilder1.toString();
      }
    }
    return "<-";
  }
  
  public final void a()
  {
    h localh = this.e;
    if (localh == null)
    {
      this.e = new h(i.d);
      return;
    }
    localh.a();
  }
  
  public final boolean a(a parama, int paramInt1, int paramInt2, d paramd, int paramInt3, boolean paramBoolean)
  {
    if (parama == null)
    {
      this.g = null;
      this.c = 0;
      this.i = -1;
      this.f = d.a;
      this.a = 2;
      return true;
    }
    if (paramBoolean) {}
    e locale1;
    for (;;)
    {
      this.g = parama;
      if (paramInt1 > 0) {}
      for (this.c = paramInt1;; this.c = 0)
      {
        this.i = paramInt2;
        this.f = paramd;
        this.a = paramInt3;
        return true;
      }
      if (parama != null)
      {
        locale1 = parama.h;
        e locale2 = this.h;
        if (locale1 != locale2) {
          break label142;
        }
        if ((locale2 != e.c) && ((this.h != e.a) || ((parama.d.k()) && (this.d.k())))) {
          continue;
        }
      }
      label140:
      label142:
      do
      {
        for (;;)
        {
          return false;
          switch (b.a[this.h.ordinal()])
          {
          }
        }
      } while ((locale1 == e.a) || (locale1 == e.d) || (locale1 == e.e));
    }
    int j;
    if (locale1 != e.h) {
      if (locale1 != e.b) {
        j = 0;
      }
    }
    int k;
    for (;;)
    {
      if (!(parama.d instanceof j))
      {
        k = j;
        label251:
        if (k != 0) {
          break;
        }
        break label140;
      }
      if ((j != 0) || (locale1 == e.e)) {
        break;
      }
      break label140;
      j = 1;
      continue;
      j = 1;
    }
    if (locale1 != e.f) {
      if (locale1 != e.g) {
        j = 0;
      }
    }
    for (;;)
    {
      k = j;
      if (!(parama.d instanceof j)) {
        break label251;
      }
      if ((j != 0) || (locale1 == e.d)) {
        break;
      }
      break label140;
      j = 1;
      continue;
      j = 1;
    }
  }
  
  public final int b()
  {
    if (this.d.W != 8)
    {
      int j = this.i;
      if (j >= 0)
      {
        a locala = this.g;
        if ((locala != null) && (locala.d.W == 8)) {}
      }
      else
      {
        j = this.c;
      }
      return j;
    }
    return 0;
  }
  
  public final void c()
  {
    this.g = null;
    this.c = 0;
    this.i = -1;
    this.f = d.b;
    this.a = 0;
    this.b = c.a;
  }
  
  public final boolean d()
  {
    return this.g != null;
  }
  
  public final String toString()
  {
    Object localObject = new HashSet();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(null);
    localStringBuilder1.append(":");
    localStringBuilder1.append(this.h.toString());
    StringBuilder localStringBuilder2;
    if (this.g != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" connected to ");
      localStringBuilder2.append(this.g.a((HashSet)localObject));
    }
    for (localObject = localStringBuilder2.toString();; localObject = "")
    {
      localStringBuilder1.append((String)localObject);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */