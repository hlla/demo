package com.google.android.gms.ads.internal.m;

import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class j
{
  private final boolean a;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  
  j(k paramk)
  {
    this.c = paramk.c;
    this.e = paramk.e;
    this.a = paramk.a;
    this.d = paramk.d;
    this.b = paramk.b;
  }
  
  public final JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("sms", this.c).put("tel", this.e).put("calendar", this.a).put("storePicture", this.d).put("inlineVideo", this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      e.c("Error occured while obtaining the MRAID capabilities.", localJSONException);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/m/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */