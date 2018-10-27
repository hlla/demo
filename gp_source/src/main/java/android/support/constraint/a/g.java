package android.support.constraint.a;

final class g
  implements f
{
  private final Object[] a = new Object['Ā'];
  private int b;
  
  public final Object a()
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
  
  public final void a(Object[] paramArrayOfObject, int paramInt)
  {
    int j = paramArrayOfObject.length;
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    paramInt = 0;
    if (paramInt < i)
    {
      Object localObject = paramArrayOfObject[paramInt];
      j = this.b;
      Object[] arrayOfObject = this.a;
      if (j >= arrayOfObject.length) {}
      for (;;)
      {
        paramInt += 1;
        break;
        arrayOfObject[j] = localObject;
        this.b = (j + 1);
      }
    }
  }
  
  public final boolean a(Object paramObject)
  {
    int i = this.b;
    Object[] arrayOfObject = this.a;
    if (i < arrayOfObject.length)
    {
      arrayOfObject[i] = paramObject;
      this.b = (i + 1);
      return true;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */