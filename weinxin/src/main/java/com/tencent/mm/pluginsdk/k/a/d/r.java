package com.tencent.mm.pluginsdk.k.a.d;

import android.annotation.SuppressLint;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class r
  extends i<q>
{
  public static final String[] gUn;
  private static final String sFn;
  @SuppressLint({"UseSparseArrays"})
  private static final HashMap<Integer, g.c> sFo;
  public final com.tencent.mm.bj.g hnp;
  private final HashMap<String, Object> sFp;
  
  static
  {
    GMTrace.i(881944690688L, 6571);
    gUn = new String[] { i.a(q.gTF, "ResDownloaderRecordTable") };
    sFn = w.hgg + com.tencent.mm.a.g.n(String.format("mm%d", new Object[] { Integer.valueOf(Integer.MIN_VALUE) }).getBytes()) + "/";
    Object localObject = new HashMap();
    sFo = (HashMap)localObject;
    ((HashMap)localObject).put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(879260336128L, 6551);
        String[] arrayOfString = r.gUn;
        GMTrace.o(879260336128L, 6551);
        return arrayOfString;
      }
    });
    localObject = p.bDz().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    GMTrace.o(881944690688L, 6571);
  }
  
  private r(com.tencent.mm.bj.g paramg)
  {
    super(paramg, q.gTF, "ResDownloaderRecordTable", null);
    GMTrace.i(880870948864L, 6563);
    this.sFp = new HashMap();
    this.hnp = paramg;
    paramg = p.bDz().iterator();
    while (paramg.hasNext()) {
      paramg.next();
    }
    GMTrace.o(880870948864L, 6563);
  }
  
  static r bDA()
  {
    GMTrace.i(881005166592L, 6564);
    try
    {
      new File(sFn).mkdirs();
      Object localObject = new com.tencent.mm.bj.g();
      if (!((com.tencent.mm.bj.g)localObject).a(sFn + "ResDown.db", sFn + "EnResDown.db", -2147483648L, com.tencent.mm.compatible.d.p.rA(), sFo))
      {
        v.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
        GMTrace.o(881005166592L, 6564);
        return null;
      }
      localObject = new r((com.tencent.mm.bj.g)localObject);
      GMTrace.o(881005166592L, 6564);
      return (r)localObject;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", new Object[] { localException });
      GMTrace.o(881005166592L, 6564);
    }
    return null;
  }
  
  public final q Mt(String paramString)
  {
    GMTrace.i(881542037504L, 6568);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
      GMTrace.o(881542037504L, 6568);
      return null;
    }
    q localq = new q();
    localq.field_urlKey_hashcode = paramString.hashCode();
    if (super.b(localq, new String[] { "urlKey_hashcode" }))
    {
      GMTrace.o(881542037504L, 6568);
      return localq;
    }
    GMTrace.o(881542037504L, 6568);
    return null;
  }
  
  public final boolean f(q paramq)
  {
    GMTrace.i(881273602048L, 6566);
    if (bf.mA(paramq.field_urlKey))
    {
      GMTrace.o(881273602048L, 6566);
      return false;
    }
    paramq.field_urlKey_hashcode = paramq.field_urlKey.hashCode();
    boolean bool = super.c(paramq, new String[] { "urlKey_hashcode" });
    GMTrace.o(881273602048L, 6566);
    return bool;
  }
  
  public final boolean g(q paramq)
  {
    GMTrace.i(881407819776L, 6567);
    if (bf.mA(paramq.field_urlKey))
    {
      GMTrace.o(881407819776L, 6567);
      return false;
    }
    paramq.field_urlKey_hashcode = paramq.field_urlKey.hashCode();
    boolean bool = super.b(paramq);
    GMTrace.o(881407819776L, 6567);
    return bool;
  }
  
  public final boolean gR(String paramString)
  {
    GMTrace.i(881139384320L, 6565);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
      GMTrace.o(881139384320L, 6565);
      return false;
    }
    q localq = new q();
    localq.field_urlKey_hashcode = paramString.hashCode();
    boolean bool = super.a(localq, new String[] { "urlKey_hashcode" });
    GMTrace.o(881139384320L, 6565);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/d/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */