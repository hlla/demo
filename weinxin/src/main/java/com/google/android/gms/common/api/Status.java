package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.v.a;
import java.util.Arrays;

public final class Status
  implements g, SafeParcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new t();
  public static final Status amM = new Status(0);
  public static final Status amN = new Status(14);
  public static final Status amO = new Status(8);
  public static final Status amP = new Status(15);
  public static final Status amQ = new Status(16);
  public final int alZ;
  public final String amR;
  final PendingIntent ama;
  final int mVersionCode;
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.mVersionCode = paramInt1;
    this.alZ = paramInt2;
    this.amR = paramString;
    this.ama = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(String paramString)
  {
    this(1, 8, paramString, null);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    do
    {
      return false;
      paramObject = (Status)paramObject;
    } while ((this.mVersionCode != ((Status)paramObject).mVersionCode) || (this.alZ != ((Status)paramObject).alZ) || (!v.d(this.amR, ((Status)paramObject).amR)) || (!v.d(this.ama, ((Status)paramObject).ama)));
    return true;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), Integer.valueOf(this.alZ), this.amR, this.ama });
  }
  
  public final boolean isSuccess()
  {
    return this.alZ <= 0;
  }
  
  public final Status jv()
  {
    return this;
  }
  
  public final String toString()
  {
    v.a locala = v.Y(this);
    if (this.amR != null) {}
    for (String str = this.amR;; str = b.bQ(this.alZ)) {
      return locala.h("statusCode", str).h("resolution", this.ama).toString();
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    t.a(this, paramParcel, paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/api/Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */