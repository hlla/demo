package com.airbnb.lottie;

import android.graphics.ColorFilter;

final class p
{
  public final ColorFilter a;
  public final String b = null;
  public final String c = null;
  
  p(ColorFilter paramColorFilter)
  {
    this.a = paramColorFilter;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof p)) {
        paramObject = (p)paramObject;
      }
    }
    else {
      return (hashCode() == ((p)paramObject).hashCode()) && (this.a == ((p)paramObject).a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return 17;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */