package com.tencent.mm.pluginsdk.e;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.jk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class b
  extends c<jk>
{
  protected ArrayList<String> sAf;
  
  public b(int paramInt)
  {
    super(0);
    GMTrace.i(902480003072L, 6724);
    this.sAf = new ArrayList(3);
    this.uqt = jk.class.getName().hashCode();
    GMTrace.o(902480003072L, 6724);
  }
  
  public static void a(String paramString, b paramb)
  {
    GMTrace.i(902748438528L, 6726);
    if (!paramb.sAf.contains(paramString)) {
      paramb.sAf.add(paramString);
    }
    a.uql.b(paramb);
    e.LJ(paramString);
    GMTrace.o(902748438528L, 6726);
  }
  
  public static void b(String paramString, b paramb)
  {
    GMTrace.i(902882656256L, 6727);
    e.LK(paramString);
    a.uql.c(paramb);
    if (paramb.sAf.contains(paramString)) {
      paramb.sAf.remove(paramString);
    }
    GMTrace.o(902882656256L, 6727);
  }
  
  public abstract void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.sdk.b.b paramb);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */