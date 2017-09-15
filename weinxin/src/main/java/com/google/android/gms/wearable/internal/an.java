package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.c.a;
import com.google.android.gms.wearable.c.c;
import com.google.android.gms.wearable.c.d;
import com.google.android.gms.wearable.h;
import com.google.android.gms.wearable.n.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

final class an
{
  static abstract class a<T>
    extends a
  {
    private com.google.android.gms.common.api.k.b<T> aHs;
    
    public a(com.google.android.gms.common.api.k.b<T> paramb)
    {
      this.aHs = paramb;
    }
    
    public final void ai(T paramT)
    {
      com.google.android.gms.common.api.k.b localb = this.aHs;
      if (localb != null)
      {
        localb.V(paramT);
        this.aHs = null;
      }
    }
  }
  
  static final class b
    extends an.a<c.c>
  {
    public b(com.google.android.gms.common.api.k.b<c.c> paramb)
    {
      super();
    }
    
    public final void a(DeleteDataItemsResponse paramDeleteDataItemsResponse)
    {
      ai(new bg.b(ak.cx(paramDeleteDataItemsResponse.statusCode), paramDeleteDataItemsResponse.aGS));
    }
  }
  
  static final class c
    extends an.a<n.a>
  {
    public c(com.google.android.gms.common.api.k.b<n.a> paramb)
    {
      super();
    }
    
    public final void a(GetConnectedNodesResponse paramGetConnectedNodesResponse)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramGetConnectedNodesResponse.aHb);
      ai(new ac.a(ak.cx(paramGetConnectedNodesResponse.statusCode), localArrayList));
    }
  }
  
  static final class d
    extends an.a<h>
  {
    public d(com.google.android.gms.common.api.k.b<h> paramb)
    {
      super();
    }
    
    public final void b(DataHolder paramDataHolder)
    {
      ai(new h(paramDataHolder));
    }
  }
  
  static final class e
    extends an.a<c.d>
  {
    public e(com.google.android.gms.common.api.k.b<c.d> paramb)
    {
      super();
    }
    
    public final void a(GetFdForAssetResponse paramGetFdForAssetResponse)
    {
      ai(new bg.c(ak.cx(paramGetFdForAssetResponse.statusCode), paramGetFdForAssetResponse.aHd));
    }
  }
  
  static final class f
    extends a
  {
    public final void f(Status paramStatus) {}
  }
  
  static final class g
    extends an.a<c.a>
  {
    private final List<FutureTask<Boolean>> aHt;
    
    g(com.google.android.gms.common.api.k.b<c.a> paramb, List<FutureTask<Boolean>> paramList)
    {
      super();
      this.aHt = paramList;
    }
    
    public final void a(PutDataResponse paramPutDataResponse)
    {
      ai(new bg.a(ak.cx(paramPutDataResponse.statusCode), paramPutDataResponse.aHc));
      if (paramPutDataResponse.statusCode != 0)
      {
        paramPutDataResponse = this.aHt.iterator();
        while (paramPutDataResponse.hasNext()) {
          ((FutureTask)paramPutDataResponse.next()).cancel(true);
        }
      }
    }
  }
  
  static final class h
    extends an.a<com.google.android.gms.wearable.k.b>
  {
    public h(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.k.b> paramb)
    {
      super();
    }
    
    public final void a(SendMessageResponse paramSendMessageResponse)
    {
      ai(new z.a(ak.cx(paramSendMessageResponse.statusCode), paramSendMessageResponse.atK));
    }
  }
  
  static final class i
    extends an.a<Status>
  {
    public i(com.google.android.gms.common.api.k.b<Status> paramb)
    {
      super();
    }
    
    public final void a(ChannelReceiveFileResponse paramChannelReceiveFileResponse)
    {
      ai(new Status(paramChannelReceiveFileResponse.statusCode));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/wearable/internal/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */