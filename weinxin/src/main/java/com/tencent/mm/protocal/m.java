package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.sdk.platformtools.bf;

public final class m
{
  public static final class a
    extends k.d
    implements k.b
  {
    public gd sYa;
    
    public a()
    {
      GMTrace.i(13171188301824L, 98133);
      this.sYa = new gd();
      GMTrace.o(13171188301824L, 98133);
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13171322519552L, 98134);
      this.sXU = ac.bHi();
      this.sYa.thY = new avt().bb(bf.bJG());
      this.sYa.tXb = k.a(this);
      byte[] arrayOfByte = this.sYa.toByteArray();
      GMTrace.o(13171322519552L, 98134);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(13171456737280L, 98135);
      GMTrace.o(13171456737280L, 98135);
      return 145;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public ge sYb;
    
    public b()
    {
      GMTrace.i(13171590955008L, 98136);
      this.sYb = new ge();
      GMTrace.o(13171590955008L, 98136);
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13171725172736L, 98137);
      this.sYb = ((ge)new ge().aD(paramArrayOfByte));
      k.a(this, this.sYb.tXs);
      int i = this.sYb.tXs.tgr;
      GMTrace.o(13171725172736L, 98137);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */