package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.n;
import com.google.android.gms.wearable.n.a;
import java.util.List;

public final class ac
  implements n
{
  public final e<n.a> b(c paramc)
  {
    paramc.a(new aw(paramc) {});
  }
  
  public static final class a
    implements n.a
  {
    private final Status aFq;
    private final List<m> aHr;
    
    public a(Status paramStatus, List<m> paramList)
    {
      this.aFq = paramStatus;
      this.aHr = paramList;
    }
    
    public final Status jv()
    {
      return this.aFq;
    }
    
    public final List<m> mF()
    {
      return this.aHr;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */