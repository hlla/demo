package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.sdk.platformtools.bf;

public final class t
{
  public static final class a
    extends k.d
    implements k.b
  {
    public abk sYr;
    
    public a()
    {
      GMTrace.i(4082769068032L, 30419);
      this.sYr = new abk();
      GMTrace.o(4082769068032L, 30419);
    }
    
    public final byte[] zh()
    {
      GMTrace.i(4082903285760L, 30420);
      this.sXU = ac.bHi();
      this.sYr.thY = new avt().bb(bf.bJG());
      this.sYr.tXb = k.a(this);
      byte[] arrayOfByte = this.sYr.toByteArray();
      GMTrace.o(4082903285760L, 30420);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(4083037503488L, 30421);
      GMTrace.o(4083037503488L, 30421);
      return 429;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public abl sYs;
    
    public b()
    {
      GMTrace.i(4086258728960L, 30445);
      this.sYs = new abl();
      GMTrace.o(4086258728960L, 30445);
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(4086392946688L, 30446);
      this.sYs = ((abl)new abl().aD(paramArrayOfByte));
      k.a(this, this.sYs.tXs);
      int i = this.sYs.tXs.tgr;
      GMTrace.o(4086392946688L, 30446);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */