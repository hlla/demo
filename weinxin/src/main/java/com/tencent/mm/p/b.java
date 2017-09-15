package com.tencent.mm.p;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.yh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements com.tencent.mm.y.e
{
  private List<d> gUf;
  private List<d> gUg;
  private d gUh;
  private a gUi;
  
  public b(List<d> paramList, a parama)
  {
    GMTrace.i(4505689128960L, 33570);
    this.gUf = null;
    this.gUg = null;
    this.gUh = null;
    this.gUf = paramList;
    this.gUg = new ArrayList();
    this.gUi = parama;
    GMTrace.o(4505689128960L, 33570);
  }
  
  private void tV()
  {
    GMTrace.i(4505957564416L, 33572);
    v.d("MicroMsg.FunctionMsgFetchLooper", "fetchNext, fetchItemList.size: %s", new Object[] { Integer.valueOf(this.gUf.size()) });
    if (this.gUf.size() > 0)
    {
      this.gUh = ((d)this.gUf.remove(0));
      Object localObject = this.gUh;
      if (localObject != null)
      {
        v.i("MicroMsg.FunctionMsgFetchLooper", "fetchInternal, functionMsgId: %s", new Object[] { ((d)localObject).field_functionmsgid });
        ((d)localObject).field_status = 0;
        localObject = new g((d)localObject);
        h.vd().a((k)localObject, 0);
      }
      GMTrace.o(4505957564416L, 33572);
      return;
    }
    h.vd().b(825, this);
    if (this.gUi != null) {
      this.gUi.q(this.gUg);
    }
    GMTrace.o(4505957564416L, 33572);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(4506091782144L, 33573);
    v.i("MicroMsg.FunctionMsgFetchLooper", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramk.getType() == 825)
    {
      paramk = (g)paramk;
      paramString = paramk.gUs;
      paramk = paramk.gUu;
      if ((paramk != null) && (paramk.field_functionmsgid.equals(this.gUh.field_functionmsgid)))
      {
        if ((paramInt1 == 0) || (paramInt2 == 0)) {
          break label182;
        }
        v.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s", new Object[] { paramk.field_functionmsgid, Long.valueOf(paramk.field_preVersion), Long.valueOf(paramk.field_version) });
        paramk.field_status = 3;
        paramk.field_version = paramk.field_preVersion;
        i.uf().a(paramk.field_functionmsgid, paramk);
      }
    }
    for (;;)
    {
      tV();
      GMTrace.o(4506091782144L, 33573);
      return;
      label182:
      v.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s", new Object[] { paramk.field_functionmsgid, Long.valueOf(paramString.tDe), Long.valueOf(paramk.field_version) });
      if (paramString.tDe >= paramk.field_version)
      {
        paramk.field_preVersion = paramk.field_version;
        paramk.field_version = paramString.tDe;
        paramk.field_status = 2;
        paramk.b(paramString.tDf);
        i.uf().a(paramk.field_functionmsgid, paramk);
        this.gUg.add(paramk);
      }
    }
  }
  
  public final boolean start()
  {
    GMTrace.i(4505823346688L, 33571);
    if ((this.gUf != null) && (this.gUf.size() > 0))
    {
      v.i("MicroMsg.FunctionMsgFetchLooper", "start, fetchItemList.size: %s", new Object[] { Integer.valueOf(this.gUf.size()) });
      h.vd().a(825, this);
      tV();
      GMTrace.o(4505823346688L, 33571);
      return true;
    }
    GMTrace.o(4505823346688L, 33571);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void q(List<d> paramList);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/p/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */