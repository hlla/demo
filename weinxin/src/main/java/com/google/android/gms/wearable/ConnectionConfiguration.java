package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class ConnectionConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new u();
  final String aFI;
  final int aFJ;
  final boolean aFK;
  String aFL;
  boolean aFM;
  String aFN;
  boolean ahM;
  final int aoA;
  final String mName;
  final int mVersionCode;
  
  ConnectionConfiguration(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    this.mVersionCode = paramInt1;
    this.mName = paramString1;
    this.aFI = paramString2;
    this.aoA = paramInt2;
    this.aFJ = paramInt3;
    this.aFK = paramBoolean1;
    this.ahM = paramBoolean2;
    this.aFL = paramString3;
    this.aFM = paramBoolean3;
    this.aFN = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionConfiguration)) {}
    do
    {
      return false;
      paramObject = (ConnectionConfiguration)paramObject;
    } while ((!v.d(Integer.valueOf(this.mVersionCode), Integer.valueOf(((ConnectionConfiguration)paramObject).mVersionCode))) || (!v.d(this.mName, ((ConnectionConfiguration)paramObject).mName)) || (!v.d(this.aFI, ((ConnectionConfiguration)paramObject).aFI)) || (!v.d(Integer.valueOf(this.aoA), Integer.valueOf(((ConnectionConfiguration)paramObject).aoA))) || (!v.d(Integer.valueOf(this.aFJ), Integer.valueOf(((ConnectionConfiguration)paramObject).aFJ))) || (!v.d(Boolean.valueOf(this.aFK), Boolean.valueOf(((ConnectionConfiguration)paramObject).aFK))) || (!v.d(Boolean.valueOf(this.aFM), Boolean.valueOf(((ConnectionConfiguration)paramObject).aFM))));
    return true;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), this.mName, this.aFI, Integer.valueOf(this.aoA), Integer.valueOf(this.aFJ), Boolean.valueOf(this.aFK), Boolean.valueOf(this.aFM) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + this.mName);
    localStringBuilder.append(", mAddress=" + this.aFI);
    localStringBuilder.append(", mType=" + this.aoA);
    localStringBuilder.append(", mRole=" + this.aFJ);
    localStringBuilder.append(", mEnabled=" + this.aFK);
    localStringBuilder.append(", mIsConnected=" + this.ahM);
    localStringBuilder.append(", mPeerNodeId=" + this.aFL);
    localStringBuilder.append(", mBtlePriority=" + this.aFM);
    localStringBuilder.append(", mNodeId=" + this.aFN);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    u.a(this, paramParcel);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/ConnectionConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */