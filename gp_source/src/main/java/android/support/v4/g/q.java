package android.support.v4.g;

public final class q
{
  public final Object a;
  public final Object b;
  
  public q(Object paramObject1, Object paramObject2)
  {
    this.a = paramObject1;
    this.b = paramObject2;
  }
  
  public static q a(Object paramObject1, Object paramObject2)
  {
    return new q(paramObject1, paramObject2);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof q))
    {
      paramObject = (q)paramObject;
      bool1 = bool2;
      if (p.a(((q)paramObject).a, this.a))
      {
        bool1 = bool2;
        if (p.a(((q)paramObject).b, this.b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    int j = 0;
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.b;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i ^ j;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Pair{");
    localStringBuilder.append(String.valueOf(this.a));
    localStringBuilder.append(" ");
    localStringBuilder.append(String.valueOf(this.b));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */