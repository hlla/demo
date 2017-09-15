package com.tencent.mm.ao;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.protocal.c.aif;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i
  extends e.b
{
  private aif hNj;
  
  public i(List<a> paramList)
  {
    super(36);
    GMTrace.i(13241518391296L, 98657);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((a)localIterator.next()).hNk);
    }
    this.hNj = new aif();
    this.hNj.jLr = paramList.size();
    this.hNj.jLs = localLinkedList;
    this.nxx = this.hNj;
    GMTrace.o(13241518391296L, 98657);
  }
  
  public static final class a
  {
    aie hNk;
    private int key;
    private String value;
    
    public a()
    {
      GMTrace.i(13241786826752L, 98659);
      this.key = 0;
      this.value = "";
      this.hNk = new aie();
      this.hNk.oSb = 0;
      this.hNk.oSl = "";
      GMTrace.o(13241786826752L, 98659);
    }
    
    public a(int paramInt, String paramString)
    {
      GMTrace.i(13241921044480L, 98660);
      this.key = paramInt;
      this.value = paramString;
      this.hNk = new aie();
      this.hNk.oSb = paramInt;
      this.hNk.oSl = paramString;
      GMTrace.o(13241921044480L, 98660);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ao/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */