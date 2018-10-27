package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.webview.i;
import java.util.Map;

@a
public final class ak
  implements u
{
  private final al a;
  
  private ak(al paramal)
  {
    this.a = paramal;
  }
  
  public static void a(i parami, al paramal)
  {
    parami.a("/reward", new ak(paramal));
  }
  
  public final void a(Object paramObject, Map paramMap)
  {
    paramObject = (String)paramMap.get("action");
    if (!"grant".equals(paramObject))
    {
      if (!"video_start".equals(paramObject))
      {
        if ("video_complete".equals(paramObject)) {
          this.a.Z();
        }
        return;
      }
      this.a.Y();
      return;
    }
    try
    {
      int i = Integer.parseInt((String)paramMap.get("amount"));
      paramObject = (String)paramMap.get("type");
      if (!TextUtils.isEmpty((CharSequence)paramObject)) {}
      for (paramObject = new RewardItemParcel((String)paramObject, i);; paramObject = null)
      {
        this.a.b((RewardItemParcel)paramObject);
        return;
      }
    }
    catch (NumberFormatException paramObject)
    {
      for (;;)
      {
        e.e("Unable to parse reward amount.", (Throwable)paramObject);
        paramObject = null;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/gmsg/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */