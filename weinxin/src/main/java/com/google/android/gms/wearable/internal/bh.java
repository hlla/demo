package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.f;

public final class bh
  implements d
{
  private f aHW;
  private int aoA;
  
  public bh(d paramd)
  {
    this.aoA = paramd.getType();
    this.aHW = ((f)paramd.mC().jO());
  }
  
  public final int getType()
  {
    return this.aoA;
  }
  
  public final f mC()
  {
    return this.aHW;
  }
  
  public final String toString()
  {
    String str;
    if (this.aoA == 1) {
      str = "changed";
    }
    for (;;)
    {
      return "DataEventEntity{ type=" + str + ", dataitem=" + this.aHW + " }";
      if (this.aoA == 2) {
        str = "deleted";
      } else {
        str = "unknown";
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */