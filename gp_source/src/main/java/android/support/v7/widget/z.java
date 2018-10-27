package android.support.v7.widget;

final class z
{
  public int a;
  public int b;
  public Object c;
  public int d;
  
  z(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    this.a = paramInt1;
    this.d = paramInt2;
    this.b = paramInt3;
    this.c = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        break label143;
      }
      paramObject = (z)paramObject;
      int i = this.a;
      if (i != ((z)paramObject).a) {
        break label141;
      }
      if ((i != 8) || (Math.abs(this.b - this.d) != 1) || (this.b != ((z)paramObject).d) || (this.d != ((z)paramObject).b))
      {
        if (this.b != ((z)paramObject).b) {
          break label139;
        }
        if (this.d != ((z)paramObject).d) {
          break label137;
        }
        Object localObject = this.c;
        if (localObject == null) {
          break label128;
        }
        if (!localObject.equals(((z)paramObject).c)) {
          break label126;
        }
      }
    }
    label126:
    label128:
    while (((z)paramObject).c == null)
    {
      return true;
      return false;
    }
    return false;
    label137:
    return false;
    label139:
    return false;
    label141:
    return false;
    label143:
    return false;
  }
  
  public final int hashCode()
  {
    return (this.a * 31 + this.d) * 31 + this.b;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("[");
    String str;
    switch (this.a)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      str = "??";
    }
    for (;;)
    {
      localStringBuilder.append(str);
      localStringBuilder.append(",s:");
      localStringBuilder.append(this.d);
      localStringBuilder.append("c:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",p:");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      str = "mv";
      continue;
      str = "up";
      continue;
      str = "rm";
      continue;
      str = "add";
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */