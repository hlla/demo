package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class z
{
  public static void a(Context paramContext, Set<Long> paramSet, dx paramdx)
  {
    GMTrace.i(2241436057600L, 16700);
    if (paramContext == null)
    {
      v.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
      GMTrace.o(2241436057600L, 16700);
      return;
    }
    if ((paramSet == null) || (paramSet.isEmpty()))
    {
      v.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
      GMTrace.o(2241436057600L, 16700);
      return;
    }
    paramContext.getString(R.l.dIG);
    paramContext = com.tencent.mm.ui.base.g.a(paramContext, paramContext.getString(R.l.ebp), false, null);
    da.vEf.c(new a(paramSet, paramContext, paramdx));
    com.tencent.mm.plugin.report.service.g.oSF.i(10811, new Object[] { Integer.valueOf(4), Integer.valueOf(paramSet.size()) });
    GMTrace.o(2241436057600L, 16700);
  }
  
  private static final class a
    implements aq.a
  {
    private Set<Long> vzi;
    private p vzj;
    private dx vzk;
    
    public a(Set<Long> paramSet, p paramp, dx paramdx)
    {
      GMTrace.i(2213250334720L, 16490);
      this.vzi = paramSet;
      this.vzj = paramp;
      this.vzk = paramdx;
      GMTrace.o(2213250334720L, 16490);
    }
    
    public final boolean Bn()
    {
      GMTrace.i(2213384552448L, 16491);
      Object localObject1 = this.vzi;
      LinkedList localLinkedList = new LinkedList();
      localObject1 = ((Set)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject1).next();
        ap.yY();
        Object localObject2 = com.tencent.mm.u.c.wT().cA(localLong.longValue());
        if (((ce)localObject2).field_msgId == localLong.longValue())
        {
          if (!((au)localObject2).axH()) {
            break label150;
          }
          com.tencent.mm.modelstat.b.hTV.d((au)localObject2, com.tencent.mm.t.g.g((au)localObject2));
        }
        for (;;)
        {
          localLinkedList.add(localLong);
          localObject2 = new lz();
          ((lz)localObject2).fSV.type = 3;
          ((lz)localObject2).fSV.fGD = localLong.longValue();
          a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
          break;
          label150:
          com.tencent.mm.modelstat.b.hTV.u((au)localObject2);
        }
      }
      ay.v(localLinkedList);
      if (this.vzk != null) {
        this.vzk.a(dx.a.vLq);
      }
      GMTrace.o(2213384552448L, 16491);
      return true;
    }
    
    public final boolean Bo()
    {
      GMTrace.i(2213518770176L, 16492);
      if (this.vzj != null)
      {
        this.vzj.dismiss();
        if (this.vzk != null) {
          this.vzk.b(dx.a.vLq);
        }
      }
      GMTrace.o(2213518770176L, 16492);
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */