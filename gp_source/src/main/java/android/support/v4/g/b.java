package android.support.v4.g;

import java.util.Map;

final class b
  extends j
{
  b(a parama) {}
  
  protected final int a()
  {
    return this.c.b;
  }
  
  protected final int a(Object paramObject)
  {
    return this.c.a(paramObject);
  }
  
  protected final Object a(int paramInt1, int paramInt2)
  {
    return this.c.a[(paramInt1 + paramInt1 + paramInt2)];
  }
  
  protected final Object a(int paramInt, Object paramObject)
  {
    paramInt = paramInt + paramInt + 1;
    Object[] arrayOfObject = this.c.a;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramObject;
    return localObject;
  }
  
  protected final void a(int paramInt)
  {
    this.c.d(paramInt);
  }
  
  protected final void a(Object paramObject1, Object paramObject2)
  {
    this.c.put(paramObject1, paramObject2);
  }
  
  protected final int b(Object paramObject)
  {
    return this.c.b(paramObject);
  }
  
  protected final Map b()
  {
    return this.c;
  }
  
  protected final void c()
  {
    this.c.clear();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */