package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.ft;
import com.tencent.mm.protocal.c.fu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public final class l
  extends a
{
  public static final class a
    extends k.d
    implements k.b
  {
    public int netType;
    public int sXY;
    
    public a()
    {
      GMTrace.i(4073776480256L, 30352);
      this.sXY = 0;
      GMTrace.o(4073776480256L, 30352);
    }
    
    public final boolean Cl()
    {
      GMTrace.i(4074447568896L, 30357);
      GMTrace.o(4074447568896L, 30357);
      return false;
    }
    
    public final boolean bHf()
    {
      GMTrace.i(4074313351168L, 30356);
      GMTrace.o(4074313351168L, 30356);
      return true;
    }
    
    public final int getCmdId()
    {
      GMTrace.i(4074179133440L, 30355);
      GMTrace.o(4074179133440L, 30355);
      return 312;
    }
    
    public final byte[] zh()
    {
      GMTrace.i(4073910697984L, 30353);
      Object localObject2 = new ft();
      ((ft)localObject2).tgV = d.sXh;
      ((ft)localObject2).thA = 2;
      ((ft)localObject2).thB = this.netType;
      ((ft)localObject2).thC = this.sXY;
      v.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[] { Integer.valueOf(((ft)localObject2).thC), Integer.valueOf(((ft)localObject2).thB), Integer.valueOf(((ft)localObject2).tgV), Integer.valueOf(((ft)localObject2).thA) });
      Object localObject1 = null;
      try
      {
        localObject2 = ((ft)localObject2).toByteArray();
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          v.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", new Object[] { bf.g(localIOException) });
        }
      }
      GMTrace.o(4073910697984L, 30353);
      return (byte[])localObject1;
    }
    
    public final int zi()
    {
      GMTrace.i(4074044915712L, 30354);
      GMTrace.o(4074044915712L, 30354);
      return 0;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public fu sXZ;
    
    public b()
    {
      GMTrace.i(4087600906240L, 30455);
      this.sXZ = new fu();
      GMTrace.o(4087600906240L, 30455);
    }
    
    public final boolean bHf()
    {
      GMTrace.i(4088003559424L, 30458);
      GMTrace.o(4088003559424L, 30458);
      return true;
    }
    
    public final int getCmdId()
    {
      GMTrace.i(4087869341696L, 30457);
      GMTrace.o(4087869341696L, 30457);
      return 1000000312;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(4087735123968L, 30456);
      this.sXZ = ((fu)new fu().aD(paramArrayOfByte));
      v.d("MicroMsg.MMBgFg", "retcode:" + this.sXZ.kyO);
      int i = this.sXZ.kyO;
      GMTrace.o(4087735123968L, 30456);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */