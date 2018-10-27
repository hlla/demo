package com.airbnb.lottie.c.b;

import android.graphics.Path.FillType;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.g;
import com.airbnb.lottie.c.a.ac;
import com.airbnb.lottie.c.a.i;
import com.airbnb.lottie.k;

public final class r
  implements b
{
  public final com.airbnb.lottie.c.a.a a;
  public final Path.FillType b;
  public final String c;
  public final i d;
  private final boolean e;
  
  r(String paramString, boolean paramBoolean, Path.FillType paramFillType, com.airbnb.lottie.c.a.a parama, i parami)
  {
    this.c = paramString;
    this.e = paramBoolean;
    this.b = paramFillType;
    this.a = parama;
    this.d = parami;
  }
  
  public final c a(k paramk, com.airbnb.lottie.c.c.a parama)
  {
    return new g(paramk, parama, this);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeFill{color=");
    Object localObject = this.a;
    if (localObject == null) {}
    for (localObject = "null";; localObject = Integer.toHexString(((Integer)((ac)localObject).b()).intValue()))
    {
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", fillEnabled=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", opacity=");
      localObject = this.d;
      if (localObject == null) {}
      for (localObject = "null";; localObject = (Integer)((ac)localObject).b())
      {
        localStringBuilder.append(localObject);
        localStringBuilder.append('}');
        return localStringBuilder.toString();
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/b/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */