package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AncsNotificationParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<AncsNotificationParcelable> CREATOR = new av();
  final String aAU;
  String aDg;
  final String aGA;
  final String aGB;
  final String aGC;
  byte aGD;
  byte aGE;
  byte aGF;
  byte aGG;
  final String aGz;
  int dX;
  final int mVersionCode;
  
  AncsNotificationParcelable(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    this.dX = paramInt2;
    this.mVersionCode = paramInt1;
    this.aAU = paramString1;
    this.aGz = paramString2;
    this.aGA = paramString3;
    this.aGB = paramString4;
    this.aGC = paramString5;
    this.aDg = paramString6;
    this.aGD = paramByte1;
    this.aGE = paramByte2;
    this.aGF = paramByte3;
    this.aGG = paramByte4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AncsNotificationParcelable)paramObject;
      if (this.aGG != ((AncsNotificationParcelable)paramObject).aGG) {
        return false;
      }
      if (this.aGF != ((AncsNotificationParcelable)paramObject).aGF) {
        return false;
      }
      if (this.aGE != ((AncsNotificationParcelable)paramObject).aGE) {
        return false;
      }
      if (this.aGD != ((AncsNotificationParcelable)paramObject).aGD) {
        return false;
      }
      if (this.dX != ((AncsNotificationParcelable)paramObject).dX) {
        return false;
      }
      if (this.mVersionCode != ((AncsNotificationParcelable)paramObject).mVersionCode) {
        return false;
      }
      if (!this.aAU.equals(((AncsNotificationParcelable)paramObject).aAU)) {
        return false;
      }
      if (this.aGz != null)
      {
        if (this.aGz.equals(((AncsNotificationParcelable)paramObject).aGz)) {}
      }
      else {
        while (((AncsNotificationParcelable)paramObject).aGz != null) {
          return false;
        }
      }
      if (!this.aDg.equals(((AncsNotificationParcelable)paramObject).aDg)) {
        return false;
      }
      if (!this.aGA.equals(((AncsNotificationParcelable)paramObject).aGA)) {
        return false;
      }
      if (!this.aGC.equals(((AncsNotificationParcelable)paramObject).aGC)) {
        return false;
      }
    } while (this.aGB.equals(((AncsNotificationParcelable)paramObject).aGB));
    return false;
  }
  
  public int hashCode()
  {
    int j = this.mVersionCode;
    int k = this.dX;
    int m = this.aAU.hashCode();
    if (this.aGz != null) {}
    for (int i = this.aGz.hashCode();; i = 0) {
      return ((((((((i + ((j * 31 + k) * 31 + m) * 31) * 31 + this.aGA.hashCode()) * 31 + this.aGB.hashCode()) * 31 + this.aGC.hashCode()) * 31 + this.aDg.hashCode()) * 31 + this.aGD) * 31 + this.aGE) * 31 + this.aGF) * 31 + this.aGG;
    }
  }
  
  public String toString()
  {
    return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.dX + ", mAppId='" + this.aAU + '\'' + ", mDateTime='" + this.aGz + '\'' + ", mNotificationText='" + this.aGA + '\'' + ", mTitle='" + this.aGB + '\'' + ", mSubtitle='" + this.aGC + '\'' + ", mDisplayName='" + this.aDg + '\'' + ", mEventId=" + this.aGD + ", mEventFlags=" + this.aGE + ", mCategoryId=" + this.aGF + ", mCategoryCount=" + this.aGG + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    av.a(this, paramParcel);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/AncsNotificationParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */