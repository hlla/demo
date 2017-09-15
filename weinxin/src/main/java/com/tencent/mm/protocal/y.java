package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;

public final class y
{
  public static final class a
    extends k.d
    implements k.b
  {
    public byte[] sXF;
    public ann sYy;
    
    public a()
    {
      GMTrace.i(13606993264640L, 101380);
      this.sYy = new ann();
      GMTrace.o(13606993264640L, 101380);
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13607395917824L, 101383);
      GMTrace.o(13607395917824L, 101383);
      return 0;
    }
    
    public final byte[] zh()
    {
      int j = -1;
      GMTrace.i(13607127482368L, 101381);
      this.sXU = ac.bHi();
      this.sYy.thY = new avt().bb(bf.bJG());
      this.sYy.tXb = k.a(this);
      this.sYy.tQK = f.uqD;
      or localor = new or();
      localor.tsC = 713;
      Object localObject2 = new PByteArray();
      Object localObject1 = new PByteArray();
      int k = MMProtocalJni.generateECKey(localor.tsC, (PByteArray)localObject2, (PByteArray)localObject1);
      byte[] arrayOfByte = ((PByteArray)localObject2).value;
      localObject2 = ((PByteArray)localObject1).value;
      int m;
      int i;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        this.sXF = ((byte[])localObject1);
        m = localor.tsC;
        if (arrayOfByte != null) {
          break label265;
        }
        i = -1;
        label149:
        if (localObject2 != null) {
          break label272;
        }
      }
      for (;;)
      {
        v.d("MicroMsg.MMReg2.Req", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j), bf.bl(arrayOfByte), bf.bl((byte[])localObject2) });
        localor.tfZ = new avt().bb(arrayOfByte);
        this.sYy.tgd = localor;
        localObject1 = this.sYy.toByteArray();
        GMTrace.o(13607127482368L, 101381);
        return (byte[])localObject1;
        localObject1 = new byte[0];
        break;
        label265:
        i = arrayOfByte.length;
        break label149;
        label272:
        j = localObject2.length;
      }
    }
    
    public final int zi()
    {
      GMTrace.i(13607261700096L, 101382);
      GMTrace.o(13607261700096L, 101382);
      return 126;
    }
  }
  
  public static final class b
    extends k.e
    implements k.c
  {
    public byte[] idE;
    public byte[] sXH;
    public int sXI;
    public ano sYz;
    
    public b()
    {
      GMTrace.i(13587665911808L, 101236);
      this.sYz = new ano();
      this.sXI = 0;
      GMTrace.o(13587665911808L, 101236);
    }
    
    public final void aW(byte[] paramArrayOfByte)
    {
      GMTrace.i(13588068564992L, 101239);
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.idE = paramArrayOfByte;
        GMTrace.o(13588068564992L, 101239);
        return;
        paramArrayOfByte = new byte[0];
      }
    }
    
    public final int getCmdId()
    {
      GMTrace.i(13587934347264L, 101238);
      GMTrace.o(13587934347264L, 101238);
      return 0;
    }
    
    public final int y(byte[] paramArrayOfByte)
    {
      GMTrace.i(13587800129536L, 101237);
      this.sXI = 0;
      this.sYz = ((ano)new ano().aD(paramArrayOfByte));
      k.a(this, this.sYz.tXs);
      this.sXI = 0;
      int i = this.sYz.tXs.tgr;
      GMTrace.o(13587800129536L, 101237);
      return i;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */