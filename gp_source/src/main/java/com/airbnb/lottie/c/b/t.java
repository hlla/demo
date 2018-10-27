package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.r;
import com.airbnb.lottie.c.a.ac;
import com.airbnb.lottie.c.a.q;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.k;

public final class t
  implements b
{
  public final String a;
  public final q b;
  private final int c;
  
  t(String paramString, int paramInt, q paramq)
  {
    this.a = paramString;
    this.c = paramInt;
    this.b = paramq;
  }
  
  public final c a(k paramk, a parama)
  {
    return new r(paramk, parama, this);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapePath{name=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", index=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", hasAnimation=");
    localStringBuilder.append(this.b.c());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */