package com.airbnb.lottie.c;

import android.support.v4.g.q;

public final class i
{
  public Object a;
  public Object b;
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool2;
    if (paramObject1 != paramObject2)
    {
      if (paramObject1 == null) {
        break label31;
      }
      bool1 = bool3;
      if (!paramObject1.equals(paramObject2)) {}
    }
    label31:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof q))
    {
      paramObject = (q)paramObject;
      bool1 = bool2;
      if (a(((q)paramObject).a, this.a))
      {
        bool1 = bool2;
        if (a(((q)paramObject).b, this.b)) {
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */