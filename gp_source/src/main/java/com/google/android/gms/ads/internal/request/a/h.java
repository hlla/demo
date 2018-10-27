package com.google.android.gms.ads.internal.request.a;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class h
{
  public static AdResponseParcel a(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, String paramString)
  {
    try
    {
      localObject6 = new JSONObject(paramString);
      str1 = ((JSONObject)localObject6).optString("ad_base_url", null);
      localObject2 = ((JSONObject)localObject6).optString("ad_url", null);
      str2 = ((JSONObject)localObject6).optString("ad_size", null);
      str3 = ((JSONObject)localObject6).optString("ad_slot_size", str2);
      if (paramAdRequestInfoParcel == null) {
        break label992;
      }
      if (paramAdRequestInfoParcel.K == 0) {
        break label986;
      }
      bool1 = true;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        Object localObject6;
        String str1;
        Object localObject2;
        String str2;
        String str3;
        boolean bool1;
        String str4;
        String str5;
        long l1;
        label180:
        label220:
        long l2;
        label236:
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject7;
        int j;
        long l3;
        boolean bool3;
        boolean bool4;
        boolean bool5;
        boolean bool6;
        boolean bool7;
        boolean bool8;
        long l4;
        boolean bool9;
        boolean bool10;
        List localList1;
        List localList2;
        RewardItemParcel localRewardItemParcel;
        boolean bool11;
        AutoClickProtectionConfigurationParcel localAutoClickProtectionConfigurationParcel;
        String str6;
        List localList3;
        SafeBrowsingConfigParcel localSafeBrowsingConfigParcel;
        boolean bool12;
        boolean bool13;
        boolean bool14;
        String str7;
        boolean bool15;
        paramContext = String.valueOf(paramContext.getMessage());
        if (paramContext.length() == 0) {}
        for (paramContext = new String("Could not parse the inline ad response: ");; paramContext = "Could not parse the inline ad response: ".concat(paramContext))
        {
          e.e(paramContext);
          return new AdResponseParcel(0);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            l2 = -1L;
            paramContext = paramString;
            paramString = null;
            break label236;
          }
          paramString = c.a(paramAdRequestInfoParcel, paramContext, paramAdRequestInfoParcel.ae.a, (String)localObject2, null, null, null, null, null);
          str1 = paramString.e;
          paramContext = paramString.f;
          l2 = paramString.o;
          break label236;
          i = bt.A.g.b();
          break label220;
          l1 = -1L;
          break label180;
          label986:
          bool1 = false;
          break;
          label992:
          bool1 = false;
          break;
        }
        label1009:
        boolean bool2 = false;
        continue;
        label1015:
        bool2 = false;
        continue;
        label1021:
        paramString = null;
        continue;
        label1026:
        continue;
        label1029:
        continue;
        label1032:
        continue;
        label1035:
        Object localObject1 = null;
        continue;
        label1041:
        localObject1 = null;
        continue;
        label1047:
        localObject1 = null;
        continue;
        label1053:
        localObject1 = null;
        continue;
        label1059:
        int i = -1;
      }
    }
    localObject1 = ((JSONObject)localObject6).optString("ad_json", null);
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = ((JSONObject)localObject6).optString("ad_html", null);
    }
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = ((JSONObject)localObject6).optString("body", null);
    }
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = (String)localObject1;
      if (((JSONObject)localObject6).has("ads")) {
        paramString = ((JSONObject)localObject6).toString();
      }
    }
    str4 = ((JSONObject)localObject6).optString("debug_dialog", null);
    str5 = ((JSONObject)localObject6).optString("debug_signals", null);
    if (((JSONObject)localObject6).has("interstitial_timeout"))
    {
      l1 = (((JSONObject)localObject6).getDouble("interstitial_timeout") * 1000.0D);
      localObject1 = ((JSONObject)localObject6).optString("orientation", null);
      if (!"portrait".equals(localObject1))
      {
        if (!"landscape".equals(localObject1)) {
          break label1059;
        }
        i = bt.A.g.a();
        if (!TextUtils.isEmpty(paramString))
        {
          l2 = -1L;
          paramContext = paramString;
          paramString = null;
          if (paramContext != null)
          {
            localObject3 = ((JSONObject)localObject6).optJSONArray("click_urls");
            if (paramString == null) {
              break label1053;
            }
            localObject1 = paramString.g;
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = a((JSONArray)localObject3, (List)localObject1);
            }
            localObject4 = ((JSONObject)localObject6).optJSONArray("impression_urls");
            if (paramString == null) {
              break label1047;
            }
            localObject1 = paramString.q;
            localObject3 = localObject1;
            if (localObject4 != null) {
              localObject3 = a((JSONArray)localObject4, (List)localObject1);
            }
            localObject5 = ((JSONObject)localObject6).optJSONArray("downloaded_impression_urls");
            if (paramString == null) {
              break label1041;
            }
            localObject1 = paramString.m;
            localObject4 = localObject1;
            if (localObject5 != null) {
              localObject4 = a((JSONArray)localObject5, (List)localObject1);
            }
            localObject7 = ((JSONObject)localObject6).optJSONArray("manual_impression_urls");
            if (paramString == null) {
              break label1035;
            }
            localObject1 = paramString.F;
            localObject5 = localObject1;
            if (localObject7 != null) {
              localObject5 = a((JSONArray)localObject7, (List)localObject1);
            }
            if (paramString == null) {
              break label1032;
            }
            j = paramString.K;
            if (j == -1) {
              break label1029;
            }
            i = j;
            l3 = paramString.r;
            if (l3 <= 0L) {
              break label1026;
            }
            l1 = l3;
            localObject1 = ((JSONObject)localObject6).optString("active_view");
            bool3 = ((JSONObject)localObject6).optBoolean("ad_is_javascript", false);
            if (!bool3) {
              break label1021;
            }
            paramString = ((JSONObject)localObject6).optString("ad_passback_url", null);
            bool4 = ((JSONObject)localObject6).optBoolean("mediation", false);
            bool5 = ((JSONObject)localObject6).optBoolean("custom_render_allowed", false);
            bool6 = ((JSONObject)localObject6).optBoolean("content_url_opted_out", true);
            bool7 = ((JSONObject)localObject6).optBoolean("content_vertical_opted_out", true);
            bool8 = ((JSONObject)localObject6).optBoolean("prefetch", false);
            l3 = ((JSONObject)localObject6).optLong("refresh_interval_milliseconds", -1L);
            l4 = ((JSONObject)localObject6).optLong("mediation_config_cache_time_milliseconds", -1L);
            localObject7 = ((JSONObject)localObject6).optString("gws_query_id", "");
            bool9 = "height".equals(((JSONObject)localObject6).optString("fluid", ""));
            bool10 = ((JSONObject)localObject6).optBoolean("native_express", false);
            localList1 = a(((JSONObject)localObject6).optJSONArray("video_start_urls"), null);
            localList2 = a(((JSONObject)localObject6).optJSONArray("video_complete_urls"), null);
            localRewardItemParcel = RewardItemParcel.a(((JSONObject)localObject6).optJSONArray("rewards"));
            bool11 = ((JSONObject)localObject6).optBoolean("use_displayed_impression", false);
            localAutoClickProtectionConfigurationParcel = AutoClickProtectionConfigurationParcel.a(((JSONObject)localObject6).optJSONObject("auto_protection_configuration"));
            str6 = ((JSONObject)localObject6).optString("set_cookie", "");
            localList3 = a(((JSONObject)localObject6).optJSONArray("remote_ping_urls"), null);
            localSafeBrowsingConfigParcel = SafeBrowsingConfigParcel.a(((JSONObject)localObject6).optJSONObject("safe_browsing"));
            bool12 = ((JSONObject)localObject6).optBoolean("render_in_browser", paramAdRequestInfoParcel.L);
            bool13 = ((JSONObject)localObject6).optBoolean("custom_close_blocked");
            bool14 = ((JSONObject)localObject6).optBoolean("enable_omid", false);
            str7 = ((JSONObject)localObject6).optString("omid_settings", null);
            bool15 = ((JSONObject)localObject6).optBoolean("disable_closable_area", false);
            localObject6 = paramAdRequestInfoParcel.b.n.getBundle(AdMobAdapter.class.getName());
            if (localObject6 == null) {
              break label1015;
            }
            if (!((Bundle)localObject6).getBoolean("is_analytics_logging_enabled", false)) {
              break label1009;
            }
            bool2 = true;
            return new AdResponseParcel(paramAdRequestInfoParcel, str1, paramContext, (List)localObject2, (List)localObject3, l1, bool4, l4, (List)localObject5, l3, i, str2, l2, str4, bool3, paramString, (String)localObject1, bool5, bool1, paramAdRequestInfoParcel.ac, bool6, bool8, (String)localObject7, bool9, bool10, localRewardItemParcel, localList1, localList2, bool11, localAutoClickProtectionConfigurationParcel, paramAdRequestInfoParcel.z, str6, localList3, bool12, str3, localSafeBrowsingConfigParcel, str5, bool7, paramAdRequestInfoParcel.C, bool13, bool14, (List)localObject4, bool15, str7, "", bool2);
          }
          paramContext = new AdResponseParcel(0);
          return paramContext;
        }
      }
    }
  }
  
  private static List a(JSONArray paramJSONArray, List paramList)
  {
    if (paramJSONArray != null)
    {
      Object localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      int i = 0;
      for (;;)
      {
        paramList = (List)localObject;
        if (i >= paramJSONArray.length()) {
          break;
        }
        ((List)localObject).add(paramJSONArray.getString(i));
        i += 1;
      }
    }
    paramList = null;
    return paramList;
  }
  
  private static JSONArray a(List paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put((String)paramList.next());
    }
    return localJSONArray;
  }
  
  public static JSONObject a(Context paramContext, a parama)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public static JSONObject a(AdResponseParcel paramAdResponseParcel)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = paramAdResponseParcel.e;
    if (localObject1 != null) {
      localJSONObject.put("ad_base_url", localObject1);
    }
    localObject1 = paramAdResponseParcel.b;
    if (localObject1 != null) {
      localJSONObject.put("ad_size", localObject1);
    }
    localJSONObject.put("native", paramAdResponseParcel.z);
    if (paramAdResponseParcel.z) {
      localJSONObject.put("ad_json", paramAdResponseParcel.f);
    }
    for (;;)
    {
      localObject1 = paramAdResponseParcel.k;
      if (localObject1 != null) {
        localJSONObject.put("debug_dialog", localObject1);
      }
      localObject1 = paramAdResponseParcel.l;
      if (localObject1 != null) {
        localJSONObject.put("debug_signals", localObject1);
      }
      long l = paramAdResponseParcel.r;
      if (l != -1L) {
        localJSONObject.put("interstitial_timeout", l / 1000.0D);
      }
      if (paramAdResponseParcel.K == bt.A.g.b()) {
        localJSONObject.put("orientation", "portrait");
      }
      for (;;)
      {
        localObject1 = paramAdResponseParcel.g;
        if (localObject1 != null) {
          localJSONObject.put("click_urls", a((List)localObject1));
        }
        localObject1 = paramAdResponseParcel.q;
        if (localObject1 != null) {
          localJSONObject.put("impression_urls", a((List)localObject1));
        }
        localObject1 = paramAdResponseParcel.m;
        if (localObject1 != null) {
          localJSONObject.put("downloaded_impression_urls", a((List)localObject1));
        }
        localObject1 = paramAdResponseParcel.F;
        if (localObject1 != null) {
          localJSONObject.put("manual_impression_urls", a((List)localObject1));
        }
        localObject1 = paramAdResponseParcel.a;
        if (localObject1 != null) {
          localJSONObject.put("active_view", localObject1);
        }
        localJSONObject.put("ad_is_javascript", paramAdResponseParcel.x);
        localObject1 = paramAdResponseParcel.L;
        if (localObject1 != null) {
          localJSONObject.put("ad_passback_url", localObject1);
        }
        localJSONObject.put("mediation", paramAdResponseParcel.y);
        localJSONObject.put("custom_render_allowed", paramAdResponseParcel.v);
        localJSONObject.put("content_url_opted_out", paramAdResponseParcel.h);
        localJSONObject.put("content_vertical_opted_out", paramAdResponseParcel.i);
        localJSONObject.put("prefetch", paramAdResponseParcel.D);
        l = paramAdResponseParcel.M;
        if (l != -1L) {
          localJSONObject.put("refresh_interval_milliseconds", l);
        }
        l = paramAdResponseParcel.G;
        if (l != -1L) {
          localJSONObject.put("mediation_config_cache_time_milliseconds", l);
        }
        if (!TextUtils.isEmpty(paramAdResponseParcel.p)) {
          localJSONObject.put("gws_query_id", paramAdResponseParcel.p);
        }
        if (!paramAdResponseParcel.w) {}
        for (localObject1 = "";; localObject1 = "height")
        {
          localJSONObject.put("fluid", localObject1);
          localJSONObject.put("native_express", paramAdResponseParcel.A);
          localObject1 = paramAdResponseParcel.Q;
          if (localObject1 != null) {
            localJSONObject.put("video_start_urls", a((List)localObject1));
          }
          localObject1 = paramAdResponseParcel.O;
          if (localObject1 != null) {
            localJSONObject.put("video_complete_urls", a((List)localObject1));
          }
          Object localObject2 = paramAdResponseParcel.P;
          if (localObject2 != null)
          {
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("rb_type", ((RewardItemParcel)localObject2).b);
            ((JSONObject)localObject1).put("rb_amount", ((RewardItemParcel)localObject2).a);
            localObject2 = new JSONArray();
            ((JSONArray)localObject2).put(localObject1);
            localJSONObject.put("rewards", localObject2);
          }
          localJSONObject.put("use_displayed_impression", paramAdResponseParcel.E);
          localJSONObject.put("auto_protection_configuration", paramAdResponseParcel.d);
          localJSONObject.put("render_in_browser", paramAdResponseParcel.I);
          localJSONObject.put("disable_closable_area", paramAdResponseParcel.t);
          return localJSONObject;
        }
        if (paramAdResponseParcel.K == bt.A.g.a()) {
          localJSONObject.put("orientation", "landscape");
        }
      }
      localJSONObject.put("ad_html", paramAdResponseParcel.f);
    }
  }
  
  private static void a(HashMap paramHashMap, Location paramLocation)
  {
    HashMap localHashMap = new HashMap();
    float f = paramLocation.getAccuracy();
    long l1 = paramLocation.getTime();
    long l2 = (paramLocation.getLatitude() * 1.0E7D);
    long l3 = (paramLocation.getLongitude() * 1.0E7D);
    localHashMap.put("radius", Float.valueOf(f * 1000.0F));
    localHashMap.put("lat", Long.valueOf(l2));
    localHashMap.put("long", Long.valueOf(l3));
    localHashMap.put("time", Long.valueOf(l1 * 1000L));
    paramHashMap.put("uule", localHashMap);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */