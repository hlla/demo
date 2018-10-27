package com.google.android.finsky.bh;

final class a
  extends d
{
  private final int a;
  private final String b;
  
  a(int paramInt, String paramString)
  {
    this.a = paramInt;
    if (paramString == null) {
      throw new NullPointerException("Null splitId");
    }
    this.b = paramString;
  }
  
  final int a()
  {
    return this.a;
  }
  
  final String b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof d)) {
        paramObject = (d)paramObject;
      }
    }
    else {
      return (this.a == ((d)paramObject).a()) && (this.b.equals(((d)paramObject).b()));
    }
    return false;
  }
  
  public final int hashCode()
  {
    return (this.a ^ 0xF4243) * 1000003 ^ this.b.hashCode();
  }
  
  public final String toString()
  {
    int i = this.a;
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 39);
    localStringBuilder.append("FileKey{fileType=");
    localStringBuilder.append(i);
    localStringBuilder.append(", splitId=");
    localStringBuilder.append(str);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bh/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */