package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;

public final class h
  extends com.google.android.gms.common.data.h<f>
  implements g
{
  private final Status aFq;
  
  public h(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.aFq = new Status(paramDataHolder.alZ);
  }
  
  protected final String jP()
  {
    return "path";
  }
  
  public final Status jv()
  {
    return this.aFq;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */