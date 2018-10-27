package b.a;

public final class c
  implements b.a, e.a.a
{
  private static final Object a = new Object();
  private volatile Object b = a;
  private volatile e.a.a c;
  
  private c(e.a.a parama)
  {
    this.c = parama;
  }
  
  public static e.a.a a(e.a.a parama)
  {
    i.a(parama);
    Object localObject = parama;
    if (!(parama instanceof c)) {
      localObject = new c(parama);
    }
    return (e.a.a)localObject;
  }
  
  public static b.a b(e.a.a parama)
  {
    if ((parama instanceof b.a)) {
      return (b.a)parama;
    }
    return new c((e.a.a)i.a(parama));
  }
  
  public final Object a()
  {
    Object localObject1 = this.b;
    if (localObject1 == a) {
      try
      {
        Object localObject3 = this.b;
        localObject1 = localObject3;
        if (localObject3 == a)
        {
          localObject1 = this.c.a();
          localObject3 = this.b;
          localObject4 = a;
          if ((localObject3 != localObject4) && (!(localObject3 instanceof h))) {
            break label73;
          }
        }
        label73:
        while (localObject3 == localObject1)
        {
          this.b = localObject1;
          this.c = null;
          return localObject1;
        }
        localObject3 = String.valueOf(localObject3);
        localObject1 = String.valueOf(localObject1);
        Object localObject4 = new StringBuilder(String.valueOf(localObject3).length() + 118 + String.valueOf(localObject1).length());
        ((StringBuilder)localObject4).append("Scoped provider was invoked recursively returning different results: ");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(" & ");
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(". This is likely due to a circular dependency.");
        throw new IllegalStateException(((StringBuilder)localObject4).toString());
      }
      finally {}
    }
    return localObject2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */