package com.google.android.gms.ads.internal.request.a;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.v;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class i
{
  public boolean A = false;
  public List B;
  public List C;
  public boolean D;
  public String E;
  public int F = -1;
  public long G = -1L;
  public RewardItemParcel H;
  public List I;
  public List J;
  public SafeBrowsingConfigParcel K;
  public boolean L = false;
  public String M;
  public String a;
  public final AdRequestInfoParcel b;
  public String c;
  public String d;
  public AutoClickProtectionConfigurationParcel e;
  public String f;
  public String g;
  public List h;
  public boolean i = true;
  public boolean j = true;
  public String k;
  public String l;
  public List m;
  public String n = "";
  public List o;
  public long p = -1L;
  public boolean q = false;
  public boolean r;
  public boolean s;
  public boolean t = false;
  public boolean u = false;
  public boolean v = false;
  public boolean w = false;
  public boolean x = false;
  public boolean y;
  public boolean z;
  
  public i(AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    this.f = paramString;
    this.b = paramAdRequestInfoParcel;
  }
  
  private static String a(Map paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      return (String)paramMap.get(0);
    }
    return null;
  }
  
  private static long b(Map paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      try
      {
        float f1 = Float.parseFloat(paramMap);
        return (f1 * 1000.0F);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 36 + String.valueOf(paramMap).length());
        localStringBuilder.append("Could not parse float from ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" header: ");
        localStringBuilder.append(paramMap);
        e.e(localStringBuilder.toString());
      }
    }
    return -1L;
  }
  
  private static List c(Map paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = (String)paramMap.get(0);
      if (paramMap != null) {
        return Arrays.asList(paramMap.trim().split("\\s+"));
      }
    }
    return null;
  }
  
  private static boolean d(Map paramMap, String paramString)
  {
    paramMap = (List)paramMap.get(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      return Boolean.valueOf((String)paramMap.get(0)).booleanValue();
    }
    return false;
  }
  
  public final void a(Map paramMap)
  {
    this.c = a(paramMap, "X-Afma-Ad-Size");
    this.d = a(paramMap, "X-Afma-Ad-Slot-Size");
    Object localObject = c(paramMap, "X-Afma-Click-Tracking-Urls");
    if (localObject == null) {}
    for (;;)
    {
      this.l = a(paramMap, "X-Afma-Debug-Signals");
      localObject = (List)paramMap.get("X-Afma-Debug-Dialog");
      label71:
      label84:
      label97:
      long l1;
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        localObject = c(paramMap, "X-Afma-Tracking-Urls");
        if (localObject == null)
        {
          localObject = c(paramMap, "X-Afma-Downloaded-Impression-Urls");
          if (localObject == null)
          {
            l1 = b(paramMap, "X-Afma-Interstitial-Timeout");
            if (l1 != -1L) {
              this.p = l1;
            }
            this.v |= d(paramMap, "X-Afma-Mediation");
            localObject = c(paramMap, "X-Afma-Manual-Tracking-Urls");
            if (localObject == null)
            {
              label145:
              l1 = b(paramMap, "X-Afma-Refresh-Rate");
              if (l1 == -1L)
              {
                label160:
                localObject = (List)paramMap.get("X-Afma-Orientation");
                if ((localObject != null) && (!((List)localObject).isEmpty()))
                {
                  localObject = (String)((List)localObject).get(0);
                  if ("portrait".equalsIgnoreCase((String)localObject)) {
                    break label961;
                  }
                  if ("landscape".equalsIgnoreCase((String)localObject)) {}
                }
                else
                {
                  label221:
                  this.a = a(paramMap, "X-Afma-ActiveView");
                  localObject = (List)paramMap.get("X-Afma-Use-HTTPS");
                  if ((localObject != null) && (!((List)localObject).isEmpty())) {
                    this.L = Boolean.valueOf((String)((List)localObject).get(0)).booleanValue();
                  }
                  this.t |= d(paramMap, "X-Afma-Custom-Rendering-Allowed");
                  this.w = "native".equals(a(paramMap, "X-Afma-Ad-Format"));
                  localObject = (List)paramMap.get("X-Afma-Content-Url-Opted-Out");
                  if ((localObject != null) && (!((List)localObject).isEmpty())) {
                    this.i = Boolean.valueOf((String)((List)localObject).get(0)).booleanValue();
                  }
                  localObject = (List)paramMap.get("X-Afma-Content-Vertical-Opted-Out");
                  if ((localObject != null) && (!((List)localObject).isEmpty())) {
                    this.j = Boolean.valueOf((String)((List)localObject).get(0)).booleanValue();
                  }
                  localObject = (List)paramMap.get("X-Afma-Gws-Query-Id");
                  if ((localObject == null) || (((List)localObject).isEmpty()))
                  {
                    label436:
                    localObject = a(paramMap, "X-Afma-Fluid");
                    if ((localObject == null) || (!((String)localObject).equals("height")))
                    {
                      label459:
                      this.x = "native_express".equals(a(paramMap, "X-Afma-Ad-Format"));
                      this.H = RewardItemParcel.a(a(paramMap, "X-Afma-Rewards"));
                      if (this.J == null) {
                        this.J = c(paramMap, "X-Afma-Reward-Video-Start-Urls");
                      }
                      if (this.I == null) {
                        this.I = c(paramMap, "X-Afma-Reward-Video-Complete-Urls");
                      }
                      this.A |= d(paramMap, "X-Afma-Use-Displayed-Impression");
                      this.q |= d(paramMap, "X-Afma-Auto-Collect-Location");
                      this.M = a(paramMap, "Set-Cookie");
                      localObject = a(paramMap, "X-Afma-Auto-Protection-Configuration");
                      if (localObject == null)
                      {
                        label580:
                        localObject = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
                        ((Uri.Builder)localObject).appendQueryParameter("id", "gmob-apps-blocked-navigation");
                        if (!TextUtils.isEmpty(this.k)) {
                          ((Uri.Builder)localObject).appendQueryParameter("debugDialog", this.k);
                        }
                        localObject = ((Uri.Builder)localObject).toString();
                        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 31);
                        localStringBuilder.append((String)localObject);
                        localStringBuilder.append("&");
                        localStringBuilder.append("navigationURL");
                        localStringBuilder.append("={NAVIGATION_URL}");
                        this.e = new AutoClickProtectionConfigurationParcel(true, Arrays.asList(new String[] { localStringBuilder.toString() }));
                        label715:
                        localObject = c(paramMap, "X-Afma-Remote-Ping-Urls");
                        if (localObject == null)
                        {
                          label729:
                          localObject = a(paramMap, "X-Afma-Safe-Browsing");
                          if (TextUtils.isEmpty((CharSequence)localObject)) {}
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      try
      {
        this.K = SafeBrowsingConfigParcel.a(new JSONObject((String)localObject));
        this.D |= d(paramMap, "X-Afma-Render-In-Browser");
        localObject = a(paramMap, "X-Afma-Pool");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          this.y = new JSONObject((String)localObject).getBoolean("never_pool");
          this.s = d(paramMap, "X-Afma-Custom-Close-Blocked");
          this.z = d(paramMap, "X-Afma-Enable-Omid");
          this.r = d(paramMap, "X-Afma-Disable-Closable-Area");
          this.E = a(paramMap, "X-Afma-Omid-Settings");
          return;
          this.C = ((List)localObject);
          break label729;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label580;
          }
          try
          {
            this.e = AutoClickProtectionConfigurationParcel.a(new JSONObject((String)localObject));
          }
          catch (JSONException localJSONException1)
          {
            e.e("Error parsing configuration JSON", localJSONException1);
            this.e = new AutoClickProtectionConfigurationParcel();
          }
          break label715;
          this.u = true;
          break label459;
          this.n = ((String)localJSONException1.get(0));
          break label436;
          this.F = bt.A.g.a();
          break label221;
          label961:
          this.F = bt.A.g.b();
          break label221;
          this.G = l1;
          break label160;
          this.B = localJSONException1;
          break label145;
          this.m = localJSONException1;
          break label97;
          this.o = localJSONException1;
          break label84;
          this.k = ((String)localJSONException1.get(0));
          break label71;
          this.h = localJSONException1;
          continue;
          localJSONException2 = localJSONException2;
          e.e("Error parsing safe browsing header", localJSONException2);
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            e.e("Error parsing interstitial pool header", localJSONException3);
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */