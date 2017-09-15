package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.a.a;
import com.google.android.gms.wearable.b.a;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.e;
import com.google.android.gms.wearable.k.a;
import com.google.android.gms.wearable.n.b;
import com.google.android.gms.wearable.n.c;
import com.google.android.gms.wearable.q.a;
import com.google.android.gms.wearable.r.a;
import java.util.List;

final class ap<T>
  extends w.a
{
  q.a aHH;
  r.a aHI;
  c.b aHJ;
  k.a aHK;
  n.b aHL;
  n.c aHM;
  b.a aHN;
  a.a aHO;
  final IntentFilter[] aHP;
  final String aHQ;
  final String aHR;
  
  public final void a(DataHolder paramDataHolder)
  {
    if (this.aHJ != null) {
      try
      {
        this.aHJ.a(new e(paramDataHolder));
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }
    paramDataHolder.close();
  }
  
  public final void a(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable) {}
  
  public final void a(AncsNotificationParcelable paramAncsNotificationParcelable) {}
  
  public final void a(CapabilityInfoParcelable paramCapabilityInfoParcelable) {}
  
  public final void a(ChannelEventParcelable paramChannelEventParcelable)
  {
    if (this.aHN != null) {
      paramChannelEventParcelable.a(this.aHN);
    }
  }
  
  public final void a(MessageEventParcelable paramMessageEventParcelable)
  {
    if (this.aHK != null) {
      this.aHK.a(paramMessageEventParcelable);
    }
  }
  
  public final void a(NodeParcelable paramNodeParcelable)
  {
    if (this.aHL != null) {
      this.aHL.a(paramNodeParcelable);
    }
  }
  
  public final void b(NodeParcelable paramNodeParcelable)
  {
    if (this.aHL != null) {
      this.aHL.b(paramNodeParcelable);
    }
  }
  
  public final void m(List<NodeParcelable> paramList) {}
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */