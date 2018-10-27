package com.airbnb.lottie.c.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class ac
  implements y
{
  public final Object a;
  public final List b;
  
  ac(Object paramObject)
  {
    this(Collections.emptyList(), paramObject);
  }
  
  ac(List paramList, Object paramObject)
  {
    this.b = paramList;
    this.a = paramObject;
  }
  
  Object a(Object paramObject)
  {
    return paramObject;
  }
  
  public Object b()
  {
    return a(this.a);
  }
  
  public final boolean c()
  {
    return this.b.isEmpty() ^ true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseInitialValue=");
    localStringBuilder.append(this.a);
    if (!this.b.isEmpty())
    {
      localStringBuilder.append(", values=");
      localStringBuilder.append(Arrays.toString(this.b.toArray()));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */