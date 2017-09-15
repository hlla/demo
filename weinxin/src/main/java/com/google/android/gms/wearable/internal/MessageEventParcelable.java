package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.l;

public class MessageEventParcelable
  implements SafeParcelable, l
{
  public static final Parcelable.Creator<MessageEventParcelable> CREATOR = new aa();
  final String aAW;
  final byte[] aFF;
  final String aGN;
  final int aHf;
  final int mVersionCode;
  
  MessageEventParcelable(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.mVersionCode = paramInt1;
    this.aHf = paramInt2;
    this.aGN = paramString1;
    this.aFF = paramArrayOfByte;
    this.aAW = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final byte[] getData()
  {
    return this.aFF;
  }
  
  public final String getPath()
  {
    return this.aGN;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageEventParcelable[").append(this.aHf).append(",").append(this.aGN).append(", size=");
    if (this.aFF == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.aFF.length)) {
      return localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aa.a(this, paramParcel);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/MessageEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */