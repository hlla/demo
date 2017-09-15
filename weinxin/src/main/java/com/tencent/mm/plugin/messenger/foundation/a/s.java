package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bn.a.a;
import com.tencent.mm.bn.b;

public final class s
{
  private static SparseArray<a> nxf;
  private static b<r> nxg;
  
  static
  {
    GMTrace.i(13388352585728L, 99751);
    nxf = new SparseArray();
    GMTrace.o(13388352585728L, 99751);
  }
  
  public static <T extends com.tencent.mm.bd.a> void a(int paramInt, T paramT)
  {
    try
    {
      GMTrace.i(13387949932544L, 99748);
      a locala = (a)nxf.get(paramInt);
      if (locala != null) {
        locala.a(paramT);
      }
      GMTrace.o(13387949932544L, 99748);
      return;
    }
    finally {}
  }
  
  public static <T extends com.tencent.mm.bd.a> void a(int paramInt, q<T> paramq)
  {
    try
    {
      GMTrace.i(13387815714816L, 99747);
      a locala2 = (a)nxf.get(paramInt);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a();
        nxf.put(paramInt, locala1);
      }
      locala1.bI(paramq);
      GMTrace.o(13387815714816L, 99747);
      return;
    }
    finally {}
  }
  
  public static final b<r> aJR()
  {
    GMTrace.i(13388084150272L, 99749);
    b localb = nxg;
    GMTrace.o(13388084150272L, 99749);
    return localb;
  }
  
  public static final void b(b<r> paramb)
  {
    GMTrace.i(13388218368000L, 99750);
    nxg = paramb;
    GMTrace.o(13388218368000L, 99750);
  }
  
  public static <T extends com.tencent.mm.bd.a> void d(T paramT)
  {
    try
    {
      GMTrace.i(16289200340992L, 121364);
      a locala = (a)nxf.get(5);
      if (locala != null) {
        locala.b(paramT);
      }
      GMTrace.o(16289200340992L, 121364);
      return;
    }
    finally {}
  }
  
  private static final class a<T extends com.tencent.mm.bd.a>
    extends com.tencent.mm.bn.a<q<T>>
    implements q<T>
  {
    public a()
    {
      GMTrace.i(13364327612416L, 99572);
      GMTrace.o(13364327612416L, 99572);
    }
    
    public final void a(final T paramT)
    {
      GMTrace.i(13364461830144L, 99573);
      a(new a.a() {});
      GMTrace.o(13364461830144L, 99573);
    }
    
    public final void b(final T paramT)
    {
      GMTrace.i(16289334558720L, 121365);
      a(new a.a() {});
      GMTrace.o(16289334558720L, 121365);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/messenger/foundation/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */