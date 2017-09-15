package com.tencent.mm.ap;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class i
  implements com.tencent.mm.y.e
{
  public i()
  {
    GMTrace.i(12943420817408L, 96436);
    h.vH().gXs.a(159, this);
    h.vH().gXs.a(160, this);
    k localk = new k(5);
    h.vH().gXs.a(localk, 0);
    GMTrace.o(12943420817408L, 96436);
  }
  
  private static void HX()
  {
    GMTrace.i(12943823470592L, 96439);
    h.vI().vr().set(81939, Long.valueOf(bf.NA()));
    GMTrace.o(12943823470592L, 96439);
  }
  
  private void release()
  {
    GMTrace.i(12943555035136L, 96437);
    h.vH().gXs.b(159, this);
    h.vH().gXs.b(160, this);
    GMTrace.o(12943555035136L, 96437);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(12943689252864L, 96438);
    if ((!(paramk instanceof com.tencent.mm.y.m)) || (((com.tencent.mm.y.m)paramk).BQ() != 5))
    {
      v.d("MicroMsg.LangPackageUpdater", "another scene");
      GMTrace.o(12943689252864L, 96438);
      return;
    }
    int i = paramk.getType();
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        HX();
        paramString = t.Id().gl(5);
        if ((paramString == null) || (paramString.length == 0))
        {
          v.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
          release();
          GMTrace.o(12943689252864L, 96438);
          return;
        }
        paramString = paramString[0];
        v.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.fKC);
        if (5 != paramString.status)
        {
          release();
          GMTrace.o(12943689252864L, 96438);
          return;
        }
        paramString = new j(paramString.id, 5);
        h.vH().gXs.a(paramString, 0);
        GMTrace.o(12943689252864L, 96438);
        return;
      }
      release();
      GMTrace.o(12943689252864L, 96438);
      return;
    }
    if (i == 160)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        HX();
      }
      release();
    }
    GMTrace.o(12943689252864L, 96438);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */