package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wm;
import com.tencent.mm.sdk.platformtools.bf;

public final class r
{
  public static final class a
    extends k.d
    implements k.b
  {
    public wl sYo;
    
    public a()
    {
      GMTrace.i(13589142306816L, 101247);
      this.sYo = new wl();
      GMTrace.o(13589142306816L, 101247);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13589544960000L, 101250);
      GMTrace.o(13589544960000L, 101250);
      return 179;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(13589276524544L, 101248);
      this.sXU = ac.bHk();
      this.sYo.thY = new avt().bb(bf.bJG());
      this.sYo.tBx = ac.bHi().ver;
      this.sYo.tXb = k.a(this);
      byte[] arrayOfByte = this.sYo.toByteArray();
      GMTrace.o(13589276524544L, 101248);
      return arrayOfByte;
    }
    
    public final int zi()
    {
      GMTrace.i(13589410742272L, 101249);
      GMTrace.o(13589410742272L, 101249);
      return 381;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public wm sYp;
    
    public b()
    {
      GMTrace.i(13593437274112L, 101279);
      this.sYp = new wm();
      GMTrace.o(13593437274112L, 101279);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13593705709568L, 101281);
      GMTrace.o(13593705709568L, 101281);
      return 1000000179;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13593571491840L, 101280);
      this.sYp = ((wm)new wm().aD(paramArrayOfByte));
      k.a(this, this.sYp.tXs);
      int i = this.sYp.tXs.tgr;
      GMTrace.o(13593571491840L, 101280);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */