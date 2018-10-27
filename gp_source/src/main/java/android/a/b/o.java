package android.a.b;

import android.a.a.b.a;
import android.a.a.b.b;
import android.a.a.b.d;
import android.a.a.b.e;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class o
  extends j
{
  private int a = 0;
  private boolean b = false;
  private final WeakReference c;
  private boolean d = false;
  private a e = new a();
  private ArrayList f = new ArrayList();
  private l g;
  
  public o(n paramn)
  {
    this.c = new WeakReference(paramn);
    this.g = l.c;
  }
  
  static l a(l paraml1, l paraml2)
  {
    if ((paraml2 != null) && (paraml2.compareTo(paraml1) < 0)) {
      return paraml2;
    }
    return paraml1;
  }
  
  static l b(k paramk)
  {
    switch (p.a[paramk.ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected event value ");
      localStringBuilder.append(paramk);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 6: 
      return l.b;
    case 5: 
      return l.d;
    case 3: 
    case 4: 
      return l.e;
    }
    return l.a;
  }
  
  private final void b()
  {
    ArrayList localArrayList = this.f;
    localArrayList.remove(localArrayList.size() - 1);
  }
  
  private final void b(l paraml)
  {
    this.f.add(paraml);
  }
  
  private static k c(l paraml)
  {
    switch (p.b[paraml.ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected state value ");
      localStringBuilder.append(paraml);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 3: 
      return k.e;
    case 2: 
      return k.f;
    case 1: 
    case 5: 
      return k.b;
    }
    throw new IllegalArgumentException();
  }
  
  private final l c(m paramm)
  {
    Object localObject = this.e;
    if (((a)localObject).c(paramm)) {}
    for (paramm = ((e)((a)localObject).a.get(paramm)).c;; paramm = null)
    {
      if (paramm != null) {}
      for (paramm = ((q)paramm.getValue()).a;; paramm = null)
      {
        if (!this.f.isEmpty()) {
          localObject = this.f;
        }
        for (localObject = (l)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);; localObject = null) {
          return a(a(this.g, paramm), (l)localObject);
        }
      }
    }
  }
  
  private final void c()
  {
    Object localObject2 = (n)this.c.get();
    Object localObject1;
    q localq;
    if (localObject2 != null)
    {
      localObject1 = this.e;
      if (((b)localObject1).d != 0)
      {
        localObject1 = ((q)((b)localObject1).e.getValue()).a;
        Object localObject3 = ((q)this.e.b.getValue()).a;
        if ((localObject1 != localObject3) || (this.g != localObject3))
        {
          this.d = false;
          if (this.g.compareTo(((q)this.e.e.getValue()).a) >= 0) {}
          Object localObject4;
          do
          {
            while ((!((Iterator)localObject3).hasNext()) || (this.d))
            {
              localObject1 = this.e.b;
              if ((this.d) || (localObject1 == null) || (this.g.compareTo(((q)((Map.Entry)localObject1).getValue()).a) <= 0)) {
                break;
              }
              localObject1 = this.e.a();
              while ((((Iterator)localObject1).hasNext()) && (!this.d))
              {
                localObject3 = (Map.Entry)((Iterator)localObject1).next();
                localObject4 = (q)((Map.Entry)localObject3).getValue();
                while ((((q)localObject4).a.compareTo(this.g) < 0) && (!this.d) && (this.e.c(((Map.Entry)localObject3).getKey())))
                {
                  b(((q)localObject4).a);
                  ((q)localObject4).a((n)localObject2, c(((q)localObject4).a));
                  b();
                }
              }
              localObject1 = this.e;
              localObject3 = new d(((b)localObject1).b, ((b)localObject1).e);
              ((b)localObject1).c.put(localObject3, Boolean.valueOf(false));
            }
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            localq = (q)((Map.Entry)localObject4).getValue();
          } while ((localq.a.compareTo(this.g) <= 0) || (this.d) || (!this.e.c(((Map.Entry)localObject4).getKey())));
          localObject1 = localq.a;
        }
      }
    }
    switch (p.b[localObject1.ordinal()])
    {
    default: 
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Unexpected state value ");
      ((StringBuilder)localObject2).append(localObject1);
      throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
    case 2: 
      localObject1 = k.c;
    case 4: 
    case 3: 
      for (;;)
      {
        b(b((k)localObject1));
        localq.a((n)localObject2, (k)localObject1);
        b();
        break;
        localObject1 = k.d;
        continue;
        localObject1 = k.g;
      }
      this.d = false;
      return;
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    case 1: 
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  public final l a()
  {
    return this.g;
  }
  
  public final void a(k paramk)
  {
    a(b(paramk));
  }
  
  public final void a(l paraml)
  {
    if (this.g != paraml)
    {
      this.g = paraml;
      if ((this.b) || (this.a != 0)) {
        this.d = true;
      }
    }
    else
    {
      return;
    }
    this.b = true;
    c();
    this.b = false;
  }
  
  public final void a(m paramm)
  {
    int j = 1;
    if (this.g != l.b) {}
    for (l locall = l.c;; locall = l.b)
    {
      q localq = new q(paramm, locall);
      if ((q)this.e.a(paramm, localq) == null)
      {
        n localn = (n)this.c.get();
        if (localn != null)
        {
          int i = j;
          if (this.a == 0)
          {
            i = j;
            if (!this.b) {
              i = 0;
            }
          }
          locall = c(paramm);
          this.a += 1;
          while ((localq.a.compareTo(locall) < 0) && (this.e.c(paramm)))
          {
            b(localq.a);
            localq.a(localn, c(localq.a));
            b();
            locall = c(paramm);
          }
          if (i == 0) {
            c();
          }
          this.a -= 1;
        }
      }
      return;
    }
  }
  
  public final void b(m paramm)
  {
    this.e.b(paramm);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */