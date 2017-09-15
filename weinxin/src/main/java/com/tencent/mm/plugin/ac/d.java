package com.tencent.mm.plugin.ac;

import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;

public final class d
{
  public SparseArray<b> prS;
  
  public d()
  {
    GMTrace.i(6619349909504L, 49318);
    this.prS = new SparseArray();
    GMTrace.o(6619349909504L, 49318);
  }
  
  public final boolean a(b paramb)
  {
    GMTrace.i(6619484127232L, 49319);
    this.prS.put(paramb.getType(), paramb);
    GMTrace.o(6619484127232L, 49319);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ac/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */