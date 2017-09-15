package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.ed;
import com.tencent.mm.protocal.c.ef;
import com.tencent.mm.sdk.platformtools.v;

public final class j
{
  public static final class a
    extends k.d
    implements k.b
  {
    public ed sXJ;
    public byte[] sXK;
    
    public a()
    {
      GMTrace.i(3611799060480L, 26910);
      this.sXJ = new ed();
      GMTrace.o(3611799060480L, 26910);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(3612201713664L, 26913);
      GMTrace.o(3612201713664L, 26913);
      return 1000;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(3611933278208L, 26911);
      this.sXJ.tXb = k.a(this);
      v.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", new Object[] { this.sXK, Integer.valueOf(this.sXJ.tgl), this.sXJ.tgm, this.sXJ.tgn, this.sXJ.tgo, Integer.valueOf(this.sXJ.tcg), Long.valueOf(this.sXJ.jLL), this.sXJ.tgp, this.sXJ.tgq });
      byte[] arrayOfByte = this.sXJ.toByteArray();
      GMTrace.o(3611933278208L, 26911);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(3612067495936L, 26912);
      GMTrace.o(3612067495936L, 26912);
      return 1000;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public ef sXL;
    
    public b()
    {
      GMTrace.i(3616496680960L, 26945);
      this.sXL = new ef();
      GMTrace.o(3616496680960L, 26945);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(3616765116416L, 26947);
      GMTrace.o(3616765116416L, 26947);
      return 1000;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(3616630898688L, 26946);
      this.sXL = ((ef)new ef().aD(paramArrayOfByte));
      v.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", new Object[] { Integer.valueOf(this.sXL.tgr), this.sXL.tgs, this.sXL.tgt });
      int i = this.sXL.tgr;
      GMTrace.o(3616630898688L, 26946);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */