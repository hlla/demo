package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.ank;
import com.tencent.mm.protocal.c.anl;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.en;

public final class v
{
  public static final class a
    extends k.d
    implements k.b
  {
    public ank sYu;
    
    public a()
    {
      GMTrace.i(13590887137280L, 101260);
      this.sYu = new ank();
      GMTrace.o(13590887137280L, 101260);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13591289790464L, 101263);
      GMTrace.o(13591289790464L, 101263);
      return 27;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13591021355008L, 101261);
      this.sYu.tXb = k.a(this);
      byte[] arrayOfByte = this.sYu.toByteArray();
      GMTrace.o(13591021355008L, 101261);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(13591155572736L, 101262);
      GMTrace.o(13591155572736L, 101262);
      return 139;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public anl sYv;
    
    public b()
    {
      GMTrace.i(13608201224192L, 101389);
      this.sYv = new anl();
      GMTrace.o(13608201224192L, 101389);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13608469659648L, 101391);
      GMTrace.o(13608469659648L, 101391);
      return 1000000027;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13608335441920L, 101390);
      this.sYv = ((anl)new anl().aD(paramArrayOfByte));
      k.a(this, this.sYv.tXs);
      int i = this.sYv.tXs.tgr;
      GMTrace.o(13608335441920L, 101390);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */