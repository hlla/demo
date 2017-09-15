package com.tencent.mm.p;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class i
  implements am
{
  private static HashMap<Integer, g.c> gJh;
  Map<Integer, List<f>> gUA;
  private e gUy;
  private c gUz;
  
  static
  {
    GMTrace.i(4510252531712L, 33604);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("FunctionMsgItem".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(4508373483520L, 33590);
        String[] arrayOfString = e.gUn;
        GMTrace.o(4508373483520L, 33590);
        return arrayOfString;
      }
    });
    GMTrace.o(4510252531712L, 33604);
  }
  
  public i()
  {
    GMTrace.i(4508776136704L, 33593);
    this.gUz = new c();
    this.gUA = new HashMap();
    GMTrace.o(4508776136704L, 33593);
  }
  
  public static void a(f paramf)
  {
    try
    {
      GMTrace.i(4509313007616L, 33597);
      v.i("MicroMsg.SubCoreFunctionMsg", "removeUpdateCallback, msgType: %s, callback: %s", new Object[] { Integer.valueOf(12399999), paramf });
      if (paramf != null)
      {
        List localList = (List)ue().gUA.get(Integer.valueOf(12399999));
        if ((localList != null) && (localList.contains(paramf)))
        {
          localList.remove(paramf);
          ue().gUA.put(Integer.valueOf(12399999), localList);
        }
      }
      GMTrace.o(4509313007616L, 33597);
      return;
    }
    finally {}
  }
  
  public static void b(f paramf)
  {
    try
    {
      GMTrace.i(4509447225344L, 33598);
      v.i("MicroMsg.SubCoreFunctionMsg", "addUpdateCallback, msgType: %s, callback: %s", new Object[] { Integer.valueOf(12399999), paramf });
      if (paramf != null)
      {
        List localList = (List)ue().gUA.get(Integer.valueOf(12399999));
        Object localObject = localList;
        if (localList == null) {
          localObject = new ArrayList();
        }
        if (!((List)localObject).contains(paramf)) {
          ((List)localObject).add(paramf);
        }
        ue().gUA.put(Integer.valueOf(12399999), localObject);
      }
      GMTrace.o(4509447225344L, 33598);
      return;
    }
    finally {}
  }
  
  static i ue()
  {
    GMTrace.i(4508910354432L, 33594);
    i locali = (i)l.o(i.class);
    GMTrace.o(4508910354432L, 33594);
    return locali;
  }
  
  public static e uf()
  {
    GMTrace.i(4509044572160L, 33595);
    if (ue().gUy == null) {
      ue().gUy = new e(h.vI().gXW);
    }
    e locale = ue().gUy;
    GMTrace.o(4509044572160L, 33595);
    return locale;
  }
  
  public static c ug()
  {
    GMTrace.i(4509178789888L, 33596);
    if (ue().gUz == null) {
      ue().gUz = new c();
    }
    c localc = ue().gUz;
    GMTrace.o(4509178789888L, 33596);
    return localc;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(4509849878528L, 33601);
    v.i("MicroMsg.SubCoreFunctionMsg", "onAccountPostReset");
    h.vL().e(new a.1(), 10000L);
    GMTrace.o(4509849878528L, 33601);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(4509984096256L, 33602);
    GMTrace.o(4509984096256L, 33602);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(4509715660800L, 33600);
    GMTrace.o(4509715660800L, 33600);
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(4510118313984L, 33603);
    v.d("MicroMsg.SubCoreFunctionMsg", "onAccountRelease");
    GMTrace.o(4510118313984L, 33603);
  }
  
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(4509581443072L, 33599);
    v.i("MicroMsg.SubCoreFunctionMsg", "getBaseDBFactories");
    HashMap localHashMap = gJh;
    GMTrace.o(4509581443072L, 33599);
    return localHashMap;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/p/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */