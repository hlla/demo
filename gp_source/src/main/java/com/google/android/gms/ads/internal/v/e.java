package com.google.android.gms.ads.internal.v;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.mediation.c;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class e
{
  public JSONObject a;
  public String b;
  public final Map c = new HashMap();
  private final List d = new ArrayList();
  private final List e = new ArrayList();
  
  public e(String paramString)
  {
    this.b = paramString;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      int i;
      String str1;
      Object localObject;
      String str2;
      try
      {
        this.a = new JSONObject(paramString);
        if (this.a.optInt("status", -1) != 1) {
          break label300;
        }
        this.a.optString("app_id");
        paramString = this.a.optJSONArray("ad_unit_id_settings");
        if (paramString != null) {
          break label306;
        }
        paramString = this.a.optJSONArray("persistable_banner_ad_unit_ids");
        if (paramString != null)
        {
          i = j;
          if (i < paramString.length())
          {
            str1 = paramString.optString(i);
            this.e.add(str1);
            i += 1;
            continue;
            if (i >= paramString.length()) {
              continue;
            }
            localObject = paramString.getJSONObject(i);
            str2 = ((JSONObject)localObject).optString("format");
            str1 = ((JSONObject)localObject).optString("ad_unit_id");
            if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
              break label311;
            }
            if (!"interstitial".equalsIgnoreCase(str2)) {
              break label248;
            }
            this.d.add(str1);
          }
        }
      }
      catch (JSONException paramString)
      {
        com.google.android.gms.ads.internal.util.e.e("Exception occurred while processing app setting json", paramString);
        bt.A.i.a(paramString, "AppSettings.parseAppSettingsJson");
      }
      return;
      label248:
      if ("rewarded".equalsIgnoreCase(str2))
      {
        localObject = ((JSONObject)localObject).optJSONObject("mediation_config");
        if (localObject != null)
        {
          localObject = new c((JSONObject)localObject);
          this.c.put(str1, localObject);
          break label311;
          label300:
          com.google.android.gms.ads.internal.util.e.e("App settings could not be fetched successfully.");
          return;
          label306:
          i = 0;
          continue;
        }
      }
      label311:
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/v/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */