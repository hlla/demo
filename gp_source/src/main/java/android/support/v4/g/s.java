package android.support.v4.g;

public class s
  implements r
{
  private final Object[] a;
  private int b;
  
  public s(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    this.a = new Object[paramInt];
  }
  
  public Object a()
  {
    int i = this.b;
    if (i > 0)
    {
      i -= 1;
      Object[] arrayOfObject = this.a;
      Object localObject = arrayOfObject[i];
      arrayOfObject[i] = null;
      this.b = i;
      return localObject;
    }
    return null;
  }
  
  public boolean a(Object paramObject)
  {
    boolean bool = false;
    int i = 0;
    int j;
    for (;;)
    {
      j = this.b;
      if (i >= j) {
        break;
      }
      if (this.a[i] == paramObject) {
        throw new IllegalStateException("Already in the pool!");
      }
      i += 1;
    }
    Object[] arrayOfObject = this.a;
    if (j < arrayOfObject.length)
    {
      arrayOfObject[j] = paramObject;
      this.b = (j + 1);
      bool = true;
    }
    return bool;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */