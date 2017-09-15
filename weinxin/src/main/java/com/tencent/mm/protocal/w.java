package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.anq;
import com.tencent.mm.protocal.c.anr;

public final class w
{
  public static final class a
    extends k.d
    implements k.b
  {
    public anq sYw;
    
    public a()
    {
      GMTrace.i(13589679177728L, 101251);
      this.sYw = new anq();
      GMTrace.o(13589679177728L, 101251);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13590081830912L, 101254);
      GMTrace.o(13590081830912L, 101254);
      return 121;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13589813395456L, 101252);
      byte[] arrayOfByte = this.sYw.toByteArray();
      GMTrace.o(13589813395456L, 101252);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(13589947613184L, 101253);
      GMTrace.o(13589947613184L, 101253);
      return 138;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public anr sYx;
    
    public b()
    {
      GMTrace.i(13606322176000L, 101375);
      this.sYx = new anr();
      GMTrace.o(13606322176000L, 101375);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13606590611456L, 101377);
      GMTrace.o(13606590611456L, 101377);
      return 1000000121;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13606456393728L, 101376);
      this.sYx = ((anr)new anr().aD(paramArrayOfByte));
      int i = this.sYx.tgr;
      GMTrace.o(13606456393728L, 101376);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */