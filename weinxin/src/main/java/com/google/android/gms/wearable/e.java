package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.h;

public final class e
  extends h<d>
  implements g
{
  public final Status aFq;
  
  public e(DataHolder paramDataHolder)
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


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */