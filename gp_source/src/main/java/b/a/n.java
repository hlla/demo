package b.a;

import e.a.a;

public final class n
  implements a
{
  private static final Object a = new Object();
  private volatile Object b = a;
  private volatile a c;
  
  private n(a parama)
  {
    this.c = parama;
  }
  
  public static a a(a parama)
  {
    Object localObject = parama;
    if (!(parama instanceof n))
    {
      localObject = parama;
      if (!(parama instanceof c)) {
        localObject = new n((a)i.a(parama));
      }
    }
    return (a)localObject;
  }
  
  public final Object a()
  {
    Object localObject2 = this.b;
    Object localObject1 = localObject2;
    if (localObject2 == a)
    {
      localObject1 = this.c;
      if (localObject1 == null) {
        localObject1 = this.b;
      }
    }
    else
    {
      return localObject1;
    }
    localObject1 = ((a)localObject1).a();
    this.b = localObject1;
    this.c = null;
    return localObject1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */