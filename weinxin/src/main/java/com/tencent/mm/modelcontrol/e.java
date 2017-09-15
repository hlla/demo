package com.tencent.mm.modelcontrol;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;

public final class e
{
  protected String hzs;
  protected int hzt;
  protected int hzu;
  protected int hzv;
  protected int hzw;
  protected boolean hzx;
  protected f[] hzy;
  
  public e()
  {
    GMTrace.i(4105317646336L, 30587);
    GMTrace.o(4105317646336L, 30587);
  }
  
  protected final boolean EE()
  {
    GMTrace.i(4105586081792L, 30589);
    if (bf.mA(this.hzs))
    {
      GMTrace.o(4105586081792L, 30589);
      return true;
    }
    boolean bool = b.iU(this.hzs);
    GMTrace.o(4105586081792L, 30589);
    return bool;
  }
  
  protected final VideoTransPara EF()
  {
    GMTrace.i(4105720299520L, 30590);
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.hzy != null)
    {
      f[] arrayOff = this.hzy;
      int j = arrayOff.length;
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        f localf = arrayOff[i];
        localObject2 = localObject1;
        if (localf != null)
        {
          localObject2 = localObject1;
          if (localf.hzz <= 0)
          {
            localObject2 = localObject1;
            if (localf.hzA >= 0)
            {
              localObject2 = new VideoTransPara();
              ((VideoTransPara)localObject2).width = localf.hzB;
              ((VideoTransPara)localObject2).height = localf.hzC;
              ((VideoTransPara)localObject2).gPu = localf.hzD;
              ((VideoTransPara)localObject2).hzG = localf.hzE;
              ((VideoTransPara)localObject2).hzu = this.hzu;
              ((VideoTransPara)localObject2).hzt = this.hzt;
              ((VideoTransPara)localObject2).hzv = this.hzv;
              ((VideoTransPara)localObject2).hzw = this.hzw;
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    GMTrace.o(4105720299520L, 30590);
    return (VideoTransPara)localObject2;
  }
  
  protected final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    GMTrace.i(4105451864064L, 30588);
    this.hzs = paramString1;
    this.hzt = bf.getInt(paramString2, 0);
    int i;
    if (this.hzt == 0)
    {
      i = 64000;
      this.hzt = i;
      this.hzu = bf.getInt(paramString3, 1);
      this.hzv = bf.getInt(paramString4, 2);
      this.hzw = bf.getInt(paramString5, 1);
      if (bf.getInt(paramString6, 0) <= 0) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      this.hzx = bool;
      GMTrace.o(4105451864064L, 30588);
      return;
      i = this.hzt * 1000;
      break;
    }
  }
  
  public final String toString()
  {
    GMTrace.i(4105854517248L, 30591);
    String str = "[ busyTime " + this.hzs + " audioBitrate " + this.hzt + " iFrame " + this.hzu + " profileIndex " + this.hzv + " presetIndex " + this.hzw + " isStepBr " + this.hzx + " ]";
    GMTrace.o(4105854517248L, 30591);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcontrol/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */