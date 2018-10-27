package c.a;

import java.util.Iterator;

public final class o
  extends n
{
  protected o(f paramf)
  {
    super(paramf, (byte)0);
  }
  
  public final boolean a(Object paramObject)
  {
    return this.a.containsValue(paramObject);
  }
  
  public final boolean b(Object paramObject)
  {
    Object localObject1 = this.a;
    Object[] arrayOfObject = ((f)localObject1).c;
    localObject1 = ((f)localObject1).g;
    int i = arrayOfObject.length;
    int j = i - 1;
    if (i > 0)
    {
      if (localObject1[j] == ak.d) {}
      for (;;)
      {
        label42:
        Object localObject2 = arrayOfObject[j];
        if (localObject2 != null) {
          if (!localObject2.equals(paramObject))
          {
            i = j;
            break;
          }
        }
        do
        {
          this.a.b(j);
          return true;
          i = j;
          break;
          if (localObject1[j] == ak.e) {
            break label42;
          }
        } while (paramObject == arrayOfObject[j]);
      }
    }
    return false;
  }
  
  public final Iterator iterator()
  {
    return new p(this, this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */