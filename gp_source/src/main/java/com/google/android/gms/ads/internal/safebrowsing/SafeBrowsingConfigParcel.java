package com.google.android.gms.ads.internal.safebrowsing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.util.bh;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public class SafeBrowsingConfigParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new i();
  public final List a;
  public final boolean b;
  public final String c;
  public final boolean d;
  public final boolean e;
  public final String f;
  public final boolean g;
  public final List h;
  
  public SafeBrowsingConfigParcel(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, List paramList1, boolean paramBoolean3, boolean paramBoolean4, List paramList2)
  {
    this.c = paramString1;
    this.f = paramString2;
    this.g = paramBoolean1;
    this.e = paramBoolean2;
    this.a = paramList1;
    this.b = paramBoolean3;
    this.d = paramBoolean4;
    paramString1 = paramList2;
    if (paramList2 == null) {
      paramString1 = new ArrayList();
    }
    this.h = paramString1;
  }
  
  public static SafeBrowsingConfigParcel a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      String str1 = paramJSONObject.optString("click_string", "");
      String str2 = paramJSONObject.optString("report_url", "");
      boolean bool1 = paramJSONObject.optBoolean("rendered_ad_enabled", false);
      boolean bool2 = paramJSONObject.optBoolean("non_malicious_reporting_enabled", false);
      List localList1 = bh.a(paramJSONObject.optJSONArray("allowed_headers"));
      List localList2 = bh.a(paramJSONObject.optJSONArray("webview_permissions"));
      return new SafeBrowsingConfigParcel(str1, str2, bool1, bool2, localList1, paramJSONObject.optBoolean("protection_enabled", false), paramJSONObject.optBoolean("malicious_reporting_enabled", false), localList2);
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.c);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.f);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 4, this.g);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 5, this.e);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 6, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 7, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 8, this.d);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 9, this.h);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/safebrowsing/SafeBrowsingConfigParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */