package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d
  implements e
{
  public Map<Integer, Set<t>> hsM;
  
  public d()
  {
    GMTrace.i(808527593472L, 6024);
    this.hsM = new HashMap();
    h.vH().gXs.a(452, this);
    GMTrace.o(808527593472L, 6024);
  }
  
  public static void a(int paramInt, w paramw)
  {
    GMTrace.i(808930246656L, 6027);
    paramw = new x(paramInt, paramw);
    h.vH().gXs.a(paramw, 0);
    GMTrace.o(808930246656L, 6027);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(809064464384L, 6028);
    paramk = (x)paramk;
    Set localSet = (Set)this.hsM.get(Integer.valueOf(paramk.sBX));
    if ((localSet != null) && (localSet.size() > 0))
    {
      Object localObject = new HashSet();
      ((Set)localObject).addAll(localSet);
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        t localt = (t)((Iterator)localObject).next();
        if ((localt != null) && (localSet.contains(localt))) {
          localt.a(paramInt1, paramInt2, paramString, paramk.sBY);
        }
      }
    }
    GMTrace.o(809064464384L, 6028);
  }
  
  public final void a(int paramInt, t paramt)
  {
    GMTrace.i(808661811200L, 6025);
    if (!this.hsM.containsKey(Integer.valueOf(paramInt))) {
      this.hsM.put(Integer.valueOf(paramInt), new HashSet());
    }
    if (!((Set)this.hsM.get(Integer.valueOf(paramInt))).contains(paramt)) {
      ((Set)this.hsM.get(Integer.valueOf(paramInt))).add(paramt);
    }
    GMTrace.o(808661811200L, 6025);
  }
  
  public final void b(int paramInt, t paramt)
  {
    GMTrace.i(808796028928L, 6026);
    if (this.hsM.get(Integer.valueOf(paramInt)) != null) {
      ((Set)this.hsM.get(Integer.valueOf(paramInt))).remove(paramt);
    }
    GMTrace.o(808796028928L, 6026);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */