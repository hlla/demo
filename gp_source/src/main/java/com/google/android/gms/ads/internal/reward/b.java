package com.google.android.gms.ads.internal.reward;

import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.common.internal.x;

@a
public final class b
  extends com.google.android.gms.ads.internal.reward.client.b
{
  private final int a;
  private final String b;
  
  public b(String paramString, int paramInt)
  {
    this.b = paramString;
    this.a = paramInt;
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final int b()
  {
    return this.a;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        bool1 = bool2;
        if (x.a(this.b, ((b)paramObject).b))
        {
          bool1 = bool2;
          if (x.a(Integer.valueOf(this.a), Integer.valueOf(((b)paramObject).a))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */