package com.google.android.gms.ads.internal.m;

import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.webview.i;
import org.json.JSONException;
import org.json.JSONObject;

@a
public class m
{
  private final String a;
  public final i b;
  
  public m(i parami)
  {
    this(parami, "");
  }
  
  public m(i parami, String paramString)
  {
    this.b = parami;
    this.a = paramString;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("width", paramInt1).put("height", paramInt2).put("maxSizeWidth", paramInt3).put("maxSizeHeight", paramInt4).put("density", paramFloat).put("rotation", paramInt5);
      this.b.a("onScreenInfoChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      e.c("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("message", paramString).put("action", this.a);
      this.b.a("onError", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      e.c("Error occurred while dispatching error event.", paramString);
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("state", paramString);
      this.b.a("onStateChanged", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      e.c("Error occured while dispatching state change.", paramString);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/m/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */