package com.airbnb.lottie.c.b;

import android.util.Log;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.c.c.a;

public final class j
  implements b
{
  public final k a;
  public final String b;
  
  j(String paramString, k paramk)
  {
    this.b = paramString;
    this.a = paramk;
  }
  
  public final c a(com.airbnb.lottie.k paramk, a parama)
  {
    if (!paramk.f)
    {
      Log.w("LOTTIE", "Animation contains merge paths but they are disabled.");
      return null;
    }
    return new com.airbnb.lottie.a.a.k(this);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MergePaths{mode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/airbnb/lottie/c/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */