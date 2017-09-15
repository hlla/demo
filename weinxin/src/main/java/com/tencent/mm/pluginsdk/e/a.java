package com.tencent.mm.pluginsdk.e;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ip;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a
  extends c<ip>
{
  protected ArrayList<String> sAf;
  
  public a()
  {
    GMTrace.i(900198301696L, 6707);
    this.sAf = new ArrayList(3);
    this.uqt = ip.class.getName().hashCode();
    GMTrace.o(900198301696L, 6707);
  }
  
  public static void a(String paramString, a parama)
  {
    GMTrace.i(900466737152L, 6709);
    if (!parama.sAf.contains(paramString)) {
      parama.sAf.add(paramString);
    }
    com.tencent.mm.sdk.b.a.uql.b(parama);
    e.LJ(paramString);
    GMTrace.o(900466737152L, 6709);
  }
  
  public static void b(String paramString, a parama)
  {
    GMTrace.i(900600954880L, 6710);
    e.LK(paramString);
    com.tencent.mm.sdk.b.a.uql.c(parama);
    if (parama.sAf.contains(paramString)) {
      parama.sAf.remove(paramString);
    }
    GMTrace.o(900600954880L, 6710);
  }
  
  public abstract void j(b paramb);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */