package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.ads.f.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.x;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.google.android.gms.ads.internal.q.a.a
public final class RewardItemParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new e();
  public final int a;
  public final String b;
  
  public RewardItemParcel(b paramb)
  {
    this(paramb.a(), paramb.b());
  }
  
  public RewardItemParcel(String paramString, int paramInt)
  {
    this.b = paramString;
    this.a = paramInt;
  }
  
  public static RewardItemParcel a(String paramString)
  {
    RewardItemParcel localRewardItemParcel = null;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localRewardItemParcel = a(new JSONArray(paramString));
      return localRewardItemParcel;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public static RewardItemParcel a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0)) {
      return new RewardItemParcel(paramJSONArray.getJSONObject(0).optString("rb_type"), paramJSONArray.getJSONObject(0).optInt("rb_amount"));
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof RewardItemParcel))
      {
        paramObject = (RewardItemParcel)paramObject;
        bool1 = bool2;
        if (x.a(this.b, ((RewardItemParcel)paramObject).b))
        {
          bool1 = bool2;
          if (x.a(Integer.valueOf(this.a), Integer.valueOf(((RewardItemParcel)paramObject).a))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.b, Integer.valueOf(this.a) });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.b);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 3, this.a);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/reward/mediation/client/RewardItemParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */