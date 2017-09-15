package com.tencent.mm.plugin.fts.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public abstract class b
  implements i
{
  private boolean lXe;
  public boolean lXf;
  
  public b()
  {
    GMTrace.i(18626333638656L, 138777);
    v.i("MicroMsg.FTS.BaseFTS5SearchLogic", "Create %s", new Object[] { getName() });
    GMTrace.o(18626333638656L, 138777);
  }
  
  public a a(f paramf)
  {
    GMTrace.i(18627541598208L, 138786);
    GMTrace.o(18627541598208L, 138786);
    return null;
  }
  
  public void a(String paramString, com.tencent.mm.plugin.fts.a.a.i parami, int paramInt, HashMap<String, String> paramHashMap)
  {
    GMTrace.i(18627138945024L, 138783);
    GMTrace.o(18627138945024L, 138783);
  }
  
  public void addSOSHistory(String paramString)
  {
    GMTrace.i(18627273162752L, 138784);
    GMTrace.o(18627273162752L, 138784);
  }
  
  public final boolean axB()
  {
    GMTrace.i(18626467856384L, 138778);
    boolean bool = this.lXe;
    GMTrace.o(18626467856384L, 138778);
    return bool;
  }
  
  public final void create()
  {
    GMTrace.i(18626602074112L, 138779);
    v.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnCreate %s | isCreated =%b", new Object[] { getName(), Boolean.valueOf(this.lXe) });
    if ((!this.lXe) && (onCreate()))
    {
      v.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetCreated");
      this.lXe = true;
    }
    GMTrace.o(18626602074112L, 138779);
  }
  
  public void deleteSOSHistory(String paramString)
  {
    GMTrace.i(18627407380480L, 138785);
    GMTrace.o(18627407380480L, 138785);
  }
  
  public final void destroy()
  {
    GMTrace.i(18626870509568L, 138781);
    v.i("MicroMsg.FTS.BaseFTS5SearchLogic", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.lXf), Boolean.valueOf(this.lXe) });
    if ((!this.lXf) && (this.lXe) && (tT()))
    {
      v.i("MicroMsg.FTS.BaseFTS5SearchLogic", "SetDestroyed");
      this.lXf = true;
    }
    GMTrace.o(18626870509568L, 138781);
  }
  
  public abstract boolean onCreate();
  
  public abstract boolean tT();
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */