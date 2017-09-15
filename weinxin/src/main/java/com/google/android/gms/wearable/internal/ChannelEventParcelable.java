package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.b.a;

public final class ChannelEventParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChannelEventParcelable> CREATOR = new ba();
  final ChannelImpl aGJ;
  final int aGK;
  final int aGL;
  final int mVersionCode;
  final int type;
  
  ChannelEventParcelable(int paramInt1, ChannelImpl paramChannelImpl, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.aGJ = paramChannelImpl;
    this.type = paramInt2;
    this.aGK = paramInt3;
    this.aGL = paramInt4;
  }
  
  public final void a(b.a parama)
  {
    switch (this.type)
    {
    default: 
      new StringBuilder("Unknown type: ").append(this.type);
      return;
    case 1: 
      parama.a(this.aGJ);
      return;
    case 2: 
      parama.a(this.aGJ, this.aGK, this.aGL);
      return;
    case 3: 
      parama.b(this.aGJ, this.aGK, this.aGL);
      return;
    }
    parama.c(this.aGJ, this.aGK, this.aGL);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ChannelEventParcelable[versionCode=").append(this.mVersionCode).append(", channel=").append(this.aGJ).append(", type=");
    int i = this.type;
    String str;
    switch (i)
    {
    default: 
      str = Integer.toString(i);
      localStringBuilder = localStringBuilder.append(str).append(", closeReason=");
      i = this.aGK;
      switch (i)
      {
      default: 
        str = Integer.toString(i);
      }
      break;
    }
    for (;;)
    {
      return str + ", appErrorCode=" + this.aGL + "]";
      str = "CHANNEL_OPENED";
      break;
      str = "CHANNEL_CLOSED";
      break;
      str = "OUTPUT_CLOSED";
      break;
      str = "INPUT_CLOSED";
      break;
      str = "CLOSE_REASON_DISCONNECTED";
      continue;
      str = "CLOSE_REASON_REMOTE_CLOSE";
      continue;
      str = "CLOSE_REASON_LOCAL_CLOSE";
      continue;
      str = "CLOSE_REASON_NORMAL";
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ba.a(this, paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/ChannelEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */