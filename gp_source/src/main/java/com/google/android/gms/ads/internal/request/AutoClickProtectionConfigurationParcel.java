package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class AutoClickProtectionConfigurationParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new y();
  public final boolean a;
  public final List b;
  
  public AutoClickProtectionConfigurationParcel()
  {
    this(false, Collections.emptyList());
  }
  
  public AutoClickProtectionConfigurationParcel(boolean paramBoolean, List paramList)
  {
    this.a = paramBoolean;
    this.b = paramList;
  }
  
  public static AutoClickProtectionConfigurationParcel a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray;
    ArrayList localArrayList;
    int i;
    if (paramJSONObject != null)
    {
      localJSONArray = paramJSONObject.optJSONArray("reporting_urls");
      localArrayList = new ArrayList();
      if (localJSONArray != null) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < localJSONArray.length()) {}
      try
      {
        localArrayList.add(localJSONArray.getString(i));
        i += 1;
        continue;
        return new AutoClickProtectionConfigurationParcel(paramJSONObject.optBoolean("enable_protection"), localArrayList);
        return new AutoClickProtectionConfigurationParcel();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          e.e("Error grabbing url from json.", localJSONException);
        }
      }
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.a);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.b);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/AutoClickProtectionConfigurationParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */