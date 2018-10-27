package android.a.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class b
  implements Iterable
{
  public e b;
  public WeakHashMap c = new WeakHashMap();
  public int d = 0;
  public e e;
  
  protected e a(Object paramObject)
  {
    for (e locale = this.e; (locale != null) && (!locale.a.equals(paramObject)); locale = locale.b) {}
    return locale;
  }
  
  public final f a()
  {
    f localf = new f(this);
    this.c.put(localf, Boolean.valueOf(false));
    return localf;
  }
  
  public Object a(Object paramObject1, Object paramObject2)
  {
    e locale = a(paramObject1);
    if (locale != null) {
      return locale.d;
    }
    b(paramObject1, paramObject2);
    return null;
  }
  
  protected final e b(Object paramObject1, Object paramObject2)
  {
    paramObject1 = new e(paramObject1, paramObject2);
    this.d += 1;
    paramObject2 = this.b;
    if (paramObject2 == null)
    {
      this.e = ((e)paramObject1);
      this.b = this.e;
      return (e)paramObject1;
    }
    ((e)paramObject2).b = ((e)paramObject1);
    ((e)paramObject1).c = ((e)paramObject2);
    this.b = ((e)paramObject1);
    return (e)paramObject1;
  }
  
  public Object b(Object paramObject)
  {
    paramObject = a(paramObject);
    if (paramObject != null)
    {
      this.d -= 1;
      if (!this.c.isEmpty())
      {
        localObject = this.c.keySet().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((h)((Iterator)localObject).next()).a_((e)paramObject);
        }
      }
      Object localObject = ((e)paramObject).c;
      if (localObject != null) {
        ((e)localObject).b = ((e)paramObject).b;
      }
      for (;;)
      {
        e locale = ((e)paramObject).b;
        if (locale != null) {
          locale.c = ((e)localObject);
        }
        for (;;)
        {
          ((e)paramObject).b = null;
          ((e)paramObject).c = null;
          return ((e)paramObject).d;
          this.b = ((e)localObject);
        }
        this.e = ((e)paramObject).b;
      }
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof b))
      {
        Object localObject1 = (b)paramObject;
        if (this.d == ((b)localObject1).d)
        {
          paramObject = iterator();
          localObject1 = ((b)localObject1).iterator();
          while ((((Iterator)paramObject).hasNext()) && (((Iterator)localObject1).hasNext()))
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)paramObject).next();
            Object localObject2 = ((Iterator)localObject1).next();
            if (localEntry != null) {}
            while ((localEntry != null) && (!localEntry.equals(localObject2))) {
              do
              {
                return false;
              } while (localObject2 != null);
            }
          }
          return (!((Iterator)paramObject).hasNext()) && (!((Iterator)localObject1).hasNext());
        }
        return false;
      }
      return false;
    }
    return true;
  }
  
  public Iterator iterator()
  {
    c localc = new c(this.e, this.b);
    this.c.put(localc, Boolean.valueOf(false));
    return localc;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/a/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */