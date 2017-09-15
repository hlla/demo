package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Iterator;
import java.util.List;

public final class g
  extends i<f>
{
  public static final String[] gUn;
  private com.tencent.mm.bj.g hnp;
  SparseArray<String> uxh;
  
  static
  {
    GMTrace.i(1570481635328L, 11701);
    gUn = new String[] { i.a(f.pw(), "AddContactAntispamTicket") };
    GMTrace.o(1570481635328L, 11701);
  }
  
  public g(e parame)
  {
    super(parame, f.pw(), "AddContactAntispamTicket", null);
    GMTrace.i(1569810546688L, 11696);
    this.uxh = new SparseArray();
    this.hnp = ((com.tencent.mm.bj.g)parame);
    GMTrace.o(1569810546688L, 11696);
  }
  
  public final String QE(String paramString)
  {
    GMTrace.i(1570347417600L, 11700);
    if (bf.mA(paramString))
    {
      GMTrace.o(1570347417600L, 11700);
      return null;
    }
    Object localObject = (String)this.uxh.get(paramString.hashCode());
    if (!bf.mA((String)localObject))
    {
      GMTrace.o(1570347417600L, 11700);
      return (String)localObject;
    }
    localObject = new a();
    ((a)localObject).field_userName = paramString;
    if (b((c)localObject, new String[] { "userName" }))
    {
      paramString = ((a)localObject).field_userName;
      int i = ((a)localObject).field_scene;
      eI(paramString, ((a)localObject).field_ticket);
      paramString = ((a)localObject).field_ticket;
      GMTrace.o(1570347417600L, 11700);
      return paramString;
    }
    GMTrace.o(1570347417600L, 11700);
    return null;
  }
  
  public final void bW(List<f> paramList)
  {
    GMTrace.i(1570078982144L, 11698);
    if (paramList.size() == 0)
    {
      GMTrace.o(1570078982144L, 11698);
      return;
    }
    long l = this.hnp.cs(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((f)paramList.next());
    }
    this.hnp.aD(l);
    GMTrace.o(1570078982144L, 11698);
  }
  
  public final void eI(String paramString1, String paramString2)
  {
    GMTrace.i(1570213199872L, 11699);
    if (bf.mA(paramString1))
    {
      GMTrace.o(1570213199872L, 11699);
      return;
    }
    this.uxh.put(paramString1.hashCode(), paramString2);
    GMTrace.o(1570213199872L, 11699);
  }
  
  public final void o(String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(1569944764416L, 11697);
    if (bf.mA(paramString1))
    {
      GMTrace.o(1569944764416L, 11697);
      return;
    }
    a locala = new a();
    locala.field_userName = paramString1;
    locala.field_scene = paramInt;
    locala.field_ticket = paramString2;
    a(locala);
    eI(paramString1, paramString2);
    GMTrace.o(1569944764416L, 11697);
  }
  
  public static final class a
    extends f
  {
    public a()
    {
      GMTrace.i(1565918232576L, 11667);
      GMTrace.o(1565918232576L, 11667);
    }
    
    protected final c.a sY()
    {
      GMTrace.i(1566052450304L, 11668);
      c.a locala = f.pw();
      GMTrace.o(1566052450304L, 11668);
      return locala;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */