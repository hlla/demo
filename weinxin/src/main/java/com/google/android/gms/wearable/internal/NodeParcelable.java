package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.m;

public class NodeParcelable
  implements SafeParcelable, m
{
  public static final Parcelable.Creator<NodeParcelable> CREATOR = new ad();
  final String aDg;
  final int aHg;
  final boolean aHh;
  final String ahk;
  final int mVersionCode;
  
  NodeParcelable(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.ahk = paramString1;
    this.aDg = paramString2;
    this.aHg = paramInt2;
    this.aHh = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NodeParcelable)) {
      return false;
    }
    return ((NodeParcelable)paramObject).ahk.equals(this.ahk);
  }
  
  public final String getId()
  {
    return this.ahk;
  }
  
  public int hashCode()
  {
    return this.ahk.hashCode();
  }
  
  public String toString()
  {
    return "Node{" + this.aDg + ", id=" + this.ahk + ", hops=" + this.aHg + ", isNearby=" + this.aHh + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ad.a(this, paramParcel);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/NodeParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */