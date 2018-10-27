package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.p;
import com.airbnb.lottie.c.a.ac;
import com.airbnb.lottie.c.a.y;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.k;

public final class n
  implements b
{
  public final com.airbnb.lottie.c.a.c a;
  public final String b;
  public final y c;
  public final com.airbnb.lottie.c.a.n d;
  
  n(String paramString, y paramy, com.airbnb.lottie.c.a.n paramn, com.airbnb.lottie.c.a.c paramc)
  {
    this.b = paramString;
    this.c = paramy;
    this.d = paramn;
    this.a = paramc;
  }
  
  public final com.airbnb.lottie.a.a.c a(k paramk, a parama)
  {
    return new p(paramk, parama, this);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RectangleShape{cornerRadius=");
    localStringBuilder.append((Float)this.a.b());
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */