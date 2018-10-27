package android.support.v7.widget;

final class dd
{
  public final int a;
  public final int b;
  
  public dd(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramInt2;
  }
  
  final int a()
  {
    return this.a - this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        break label53;
      }
      paramObject = (dd)paramObject;
      if (this.a != ((dd)paramObject).a) {}
    }
    else
    {
      return this.b == ((dd)paramObject).b;
    }
    return false;
    label53:
    return false;
  }
  
  public final int hashCode()
  {
    return this.b * 31 + this.a;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */