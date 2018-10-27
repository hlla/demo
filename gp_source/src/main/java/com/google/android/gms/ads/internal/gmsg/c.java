package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import java.util.Map;

@a
public final class c
  implements u
{
  private final d a;
  
  public c(d paramd)
  {
    this.a = paramd;
  }
  
  public final void a(Object paramObject, Map paramMap)
  {
    paramObject = (String)paramMap.get("name");
    if (paramObject == null)
    {
      e.e("App event with no name parameter.");
      return;
    }
    this.a.a((String)paramObject, (String)paramMap.get("info"));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/gmsg/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */