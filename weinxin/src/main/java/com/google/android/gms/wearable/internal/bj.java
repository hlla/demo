package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.g;

public final class bj
  implements g
{
  private final String ahk;
  private final String azV;
  
  public bj(g paramg)
  {
    this.ahk = paramg.getId();
    this.azV = paramg.mE();
  }
  
  public final String getId()
  {
    return this.ahk;
  }
  
  public final String mE()
  {
    return this.azV;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.ahk == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.azV);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.ahk);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */