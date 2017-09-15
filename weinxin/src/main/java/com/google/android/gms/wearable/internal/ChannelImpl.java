package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.Channel;

public class ChannelImpl
  implements SafeParcelable, Channel
{
  public static final Parcelable.Creator<ChannelImpl> CREATOR = new bb();
  final String aFN;
  public final String aGM;
  final String aGN;
  final int mVersionCode;
  
  ChannelImpl(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.aGM = ((String)w.Z(paramString1));
    this.aFN = ((String)w.Z(paramString2));
    this.aGN = ((String)w.Z(paramString3));
  }
  
  public final e<Status> a(c paramc, final Uri paramUri)
  {
    w.h(paramc, "client is null");
    w.h(paramUri, "uri is null");
    paramc.b(new aw(paramc) {});
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ChannelImpl)) {
        return false;
      }
      paramObject = (ChannelImpl)paramObject;
    } while ((this.aGM.equals(((ChannelImpl)paramObject).aGM)) && (v.d(((ChannelImpl)paramObject).aFN, this.aFN)) && (v.d(((ChannelImpl)paramObject).aGN, this.aGN)) && (((ChannelImpl)paramObject).mVersionCode == this.mVersionCode));
    return false;
  }
  
  public final String getPath()
  {
    return this.aGN;
  }
  
  public int hashCode()
  {
    return this.aGM.hashCode();
  }
  
  public final String mB()
  {
    return this.aFN;
  }
  
  public String toString()
  {
    return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.aGM + '\'' + ", nodeId='" + this.aFN + '\'' + ", path='" + this.aGN + '\'' + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bb.a(this, paramParcel);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/ChannelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */