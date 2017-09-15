package com.tencent.mm.modelcontrol;

import com.tencent.gmtrace.GMTrace;

public final class f
  implements Comparable
{
  public int hzA;
  public int hzB;
  public int hzC;
  public int hzD;
  public int hzE;
  public int hzF;
  public int hzz;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    GMTrace.i(4104109686784L, 30578);
    this.hzz = paramInt1;
    this.hzA = paramInt2;
    this.hzB = paramInt3;
    this.hzC = paramInt4;
    this.hzD = paramInt5;
    this.hzE = paramInt6;
    this.hzF = paramInt7;
    GMTrace.o(4104109686784L, 30578);
  }
  
  public final int compareTo(Object paramObject)
  {
    GMTrace.i(4104243904512L, 30579);
    if (paramObject == null)
    {
      GMTrace.o(4104243904512L, 30579);
      return 0;
    }
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      int i = this.hzz;
      int j = ((f)paramObject).hzz;
      GMTrace.o(4104243904512L, 30579);
      return i - j;
    }
    GMTrace.o(4104243904512L, 30579);
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcontrol/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */