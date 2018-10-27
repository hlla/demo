package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.a.af;
import com.google.android.gms.ads.internal.util.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class ad
  implements u
{
  public final HashMap a = new HashMap();
  
  public final void a(Object paramObject, Map paramMap)
  {
    paramObject = (String)paramMap.get("request_id");
    String str = (String)paramMap.get("fetched_ad");
    e.b("Received ad from the cache.");
    paramMap = (af)this.a.get(paramObject);
    if (paramMap == null)
    {
      e.c("Could not find the ad request for the corresponding ad response.");
      return;
    }
    try
    {
      paramMap.b(new JSONObject(str));
      return;
    }
    catch (JSONException localJSONException)
    {
      e.c("Failed constructing JSON object from value passed from javascript", localJSONException);
      paramMap.b(null);
      return;
    }
    finally
    {
      this.a.remove(paramObject);
    }
  }
  
  public final void a(String paramString)
  {
    af localaf = (af)this.a.get(paramString);
    if (localaf == null)
    {
      e.c("Could not find the ad request for the corresponding ad response.");
      return;
    }
    if (!localaf.isDone()) {
      localaf.cancel(true);
    }
    this.a.remove(paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/gmsg/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */