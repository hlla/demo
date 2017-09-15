package com.tencent.mm.protocal;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.protocal.c.en;
import com.tencent.mm.sdk.platformtools.v;

public final class k
{
  public static em a(d paramd)
  {
    GMTrace.i(13591826661376L, 101267);
    em localem = new em();
    localem.tgV = paramd.sXN;
    localem.tcg = paramd.sXQ;
    localem.lcP = paramd.sXM;
    localem.tgU = b.aU(paramd.sXP.getBytes());
    if (localem.tgU.sWU.length >= 16) {
      localem.tgU = localem.tgU.xQ(16);
    }
    localem.tgW = b.aU(paramd.sXO.getBytes());
    if (localem.tgW.sWU.length >= 132) {
      localem.tgW = localem.tgW.xQ(132);
    }
    localem.tgT = b.aU(paramd.aMt);
    if (localem.tgT.sWU.length >= 36) {
      localem.tgT = localem.tgT.xQ(36);
    }
    GMTrace.o(13591826661376L, 101267);
    return localem;
  }
  
  public static void a(e parame, en paramen)
  {
    GMTrace.i(13591960879104L, 101268);
    if (paramen.tgX != null)
    {
      parame.sXX = paramen.tgX.tXF;
      GMTrace.o(13591960879104L, 101268);
      return;
    }
    parame.sXX = "";
    v.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
    GMTrace.o(13591960879104L, 101268);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(PByteArray paramPByteArray, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract boolean bHf();
    
    public abstract byte[] zh();
    
    public abstract int zi();
  }
  
  public static abstract interface c
  {
    public abstract boolean bHf();
    
    public abstract int y(byte[] paramArrayOfByte);
  }
  
  public static class d
  {
    public byte[] aMt;
    public int sXM;
    public int sXN;
    public String sXO;
    public String sXP;
    public int sXQ;
    public boolean sXR;
    public k.a sXS;
    public byte[] sXT;
    public ac sXU;
    public long sXV;
    
    public d()
    {
      GMTrace.i(13568070123520L, 101090);
      this.sXR = true;
      this.sXV = 0L;
      this.sXM = 0;
      this.sXN = 0;
      this.aMt = new byte[0];
      this.sXO = "";
      this.sXP = "";
      this.sXQ = 0;
      this.sXU = new ac("", "", 0);
      GMTrace.o(13568070123520L, 101090);
    }
    
    public boolean Cl()
    {
      GMTrace.i(13568606994432L, 101094);
      boolean bool = this.sXR;
      GMTrace.o(13568606994432L, 101094);
      return bool;
    }
    
    public boolean bHf()
    {
      GMTrace.i(13568472776704L, 101093);
      GMTrace.o(13568472776704L, 101093);
      return false;
    }
    
    public void dj(int paramInt)
    {
      GMTrace.i(13568204341248L, 101091);
      this.sXM = paramInt;
      GMTrace.o(13568204341248L, 101091);
    }
    
    public int getCmdId()
    {
      GMTrace.i(13568338558976L, 101092);
      GMTrace.o(13568338558976L, 101092);
      return 0;
    }
  }
  
  public static class e
  {
    public long sXV;
    public int sXW;
    public String sXX;
    
    public e()
    {
      GMTrace.i(13590216048640L, 101255);
      this.sXV = 0L;
      this.sXW = -99;
      this.sXX = "";
      GMTrace.o(13590216048640L, 101255);
    }
    
    public boolean bHf()
    {
      GMTrace.i(13590484484096L, 101257);
      GMTrace.o(13590484484096L, 101257);
      return false;
    }
    
    public int getCmdId()
    {
      GMTrace.i(13590350266368L, 101256);
      GMTrace.o(13590350266368L, 101256);
      return 0;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */