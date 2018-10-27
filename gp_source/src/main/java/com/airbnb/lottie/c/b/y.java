package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.t;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.k;

public final class y
  implements b
{
  public final com.airbnb.lottie.c.a.c a;
  public final String b;
  public final com.airbnb.lottie.c.a.c c;
  public final com.airbnb.lottie.c.a.c d;
  public final z e;
  
  y(String paramString, z paramz, com.airbnb.lottie.c.a.c paramc1, com.airbnb.lottie.c.a.c paramc2, com.airbnb.lottie.c.a.c paramc3)
  {
    this.b = paramString;
    this.e = paramz;
    this.d = paramc1;
    this.a = paramc2;
    this.c = paramc3;
  }
  
  public final com.airbnb.lottie.a.a.c a(k paramk, a parama)
  {
    return new t(parama, this);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Trim Path: {start: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", end: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", offset: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */