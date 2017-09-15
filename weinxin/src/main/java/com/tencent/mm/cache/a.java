package com.tencent.mm.cache;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public abstract interface a
{
  public abstract Object get(Object paramObject);
  
  public abstract void m(Object paramObject1, Object paramObject2);
  
  public abstract Object remove(Object paramObject);
  
  public static final class a
  {
    private static Map<String, a> gMF;
    
    static
    {
      GMTrace.i(13637729124352L, 101609);
      gMF = new HashMap();
      GMTrace.o(13637729124352L, 101609);
    }
    
    private static <T> T a(a parama, String paramString)
    {
      GMTrace.i(13637594906624L, 101608);
      if (parama == null)
      {
        v.e("MicroMsg.ICacheService.Factory", "null service");
        GMTrace.o(13637594906624L, 101608);
        return null;
      }
      try
      {
        parama = parama.remove(paramString);
        GMTrace.o(13637594906624L, 101608);
        return parama;
      }
      catch (Exception parama)
      {
        v.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
        v.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { bf.g(parama) });
        GMTrace.o(13637594906624L, 101608);
      }
      return null;
    }
    
    private static <T> T a(a parama, String paramString, T paramT)
    {
      GMTrace.i(13637460688896L, 101607);
      if (parama == null)
      {
        v.e("MicroMsg.ICacheService.Factory", "null service");
        GMTrace.o(13637460688896L, 101607);
        return null;
      }
      try
      {
        parama = parama.get(paramString);
        GMTrace.o(13637460688896L, 101607);
        return parama;
      }
      catch (Exception parama)
      {
        v.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
        v.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { bf.g(parama) });
        GMTrace.o(13637460688896L, 101607);
      }
      return null;
    }
    
    public static void a(String paramString, a parama)
    {
      GMTrace.i(13636789600256L, 101602);
      gMF.put(paramString, parama);
      GMTrace.o(13636789600256L, 101602);
    }
    
    public static <T> void a(String paramString1, String paramString2, T paramT)
    {
      GMTrace.i(13637192253440L, 101605);
      paramString1 = dq(paramString1);
      if (paramString1 == null)
      {
        v.e("MicroMsg.ICacheService.Factory", "null service");
        GMTrace.o(13637192253440L, 101605);
        return;
      }
      paramString1.m(paramString2, paramT);
      GMTrace.o(13637192253440L, 101605);
    }
    
    private static a dq(String paramString)
    {
      GMTrace.i(13636923817984L, 101603);
      paramString = (a)gMF.get(paramString);
      GMTrace.o(13636923817984L, 101603);
      return paramString;
    }
    
    public static <T> T x(String paramString1, String paramString2)
    {
      GMTrace.i(13637058035712L, 101604);
      paramString1 = a(dq(paramString1), paramString2, null);
      GMTrace.o(13637058035712L, 101604);
      return paramString1;
    }
    
    public static <T> void y(String paramString1, String paramString2)
    {
      GMTrace.i(13637326471168L, 101606);
      a(dq(paramString1), paramString2);
      GMTrace.o(13637326471168L, 101606);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/cache/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */