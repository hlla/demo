package com.tencent.mm.plugin.a;

import com.tencent.gmtrace.GMTrace;

public final class g
{
  public int id;
  public long ilM;
  public int ilN;
  public int size;
  public long start;
  
  public g()
  {
    GMTrace.i(17457699880960L, 130070);
    GMTrace.o(17457699880960L, 130070);
  }
  
  public final String toString()
  {
    GMTrace.i(17457834098688L, 130071);
    String str = " id: " + this.id + " start: " + this.start + " size: " + this.size + " sampleTime: " + this.ilM + " sampleFlag: " + this.ilN;
    GMTrace.o(17457834098688L, 130071);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */