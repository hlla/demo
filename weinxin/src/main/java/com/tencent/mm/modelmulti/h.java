package com.tencent.mm.modelmulti;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.x.a;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;

public final class h
  extends k
  implements j
{
  private com.tencent.mm.y.e gUt;
  public long hJQ;
  private byte[] hKl;
  private com.tencent.mm.network.p htc;
  private int uin;
  
  public h(long paramLong, byte[] paramArrayOfByte)
  {
    GMTrace.i(13449958522880L, 100210);
    this.hJQ = -1L;
    this.uin = 0;
    this.hJQ = paramLong;
    this.hKl = paramArrayOfByte;
    GMTrace.o(13449958522880L, 100210);
  }
  
  public h(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    GMTrace.i(13450092740608L, 100211);
    this.hJQ = -1L;
    this.uin = 0;
    this.hJQ = paramLong;
    this.hKl = paramArrayOfByte;
    this.uin = paramInt;
    GMTrace.o(13450092740608L, 100211);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13450226958336L, 100212);
    if (bf.bm(this.hKl))
    {
      v.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[] { "get keyBuf failed" });
      GMTrace.o(13450226958336L, 100212);
      return -1;
    }
    if (this.uin == 0) {
      this.htc = new a();
    }
    for (;;)
    {
      v.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[] { Long.valueOf(this.hJQ), bf.bk(this.hKl) });
      ((x.a)this.htc.BG()).hMr = this.hJQ;
      ((x.a)this.htc.BG()).fKf = this.hKl;
      this.gUt = parame1;
      int i = a(parame, this.htc, this);
      GMTrace.o(13450226958336L, 100212);
      return i;
      this.htc = new b();
      ((b)this.htc).uin = this.uin;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13450495393792L, 100214);
    v.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(13450495393792L, 100214);
  }
  
  public final int getType()
  {
    GMTrace.i(13450361176064L, 100213);
    GMTrace.o(13450361176064L, 100213);
    return 268369922;
  }
  
  public static final class a
    extends i
  {
    private final x.a hKm;
    private final x.b hKn;
    
    public a()
    {
      GMTrace.i(13448482127872L, 100199);
      this.hKm = new x.a();
      this.hKn = new x.b();
      GMTrace.o(13448482127872L, 100199);
    }
    
    public final int getType()
    {
      GMTrace.i(13448616345600L, 100200);
      GMTrace.o(13448616345600L, 100200);
      return 268369922;
    }
    
    public final String getUri()
    {
      GMTrace.i(13448750563328L, 100201);
      GMTrace.o(13448750563328L, 100201);
      return null;
    }
  }
  
  public static final class b
    implements com.tencent.mm.network.p
  {
    private final x.a hKm;
    private final x.b hKn;
    int uin;
    
    public b()
    {
      GMTrace.i(13435731443712L, 100104);
      this.hKm = new x.a();
      this.hKn = new x.b();
      GMTrace.o(13435731443712L, 100104);
    }
    
    public final int BD()
    {
      GMTrace.i(13436402532352L, 100109);
      GMTrace.o(13436402532352L, 100109);
      return 0;
    }
    
    public final k.d BG()
    {
      GMTrace.i(13436134096896L, 100107);
      this.hKm.sXP = com.tencent.mm.compatible.d.p.rB();
      this.hKm.sXO = d.DEVICE_TYPE;
      this.hKm.sXN = d.sXh;
      this.hKm.dj(this.uin);
      x.a locala = this.hKm;
      GMTrace.o(13436134096896L, 100107);
      return locala;
    }
    
    public final boolean BH()
    {
      GMTrace.i(13436268314624L, 100108);
      GMTrace.o(13436268314624L, 100108);
      return false;
    }
    
    public final int getType()
    {
      GMTrace.i(13435865661440L, 100105);
      GMTrace.o(13435865661440L, 100105);
      return 268369922;
    }
    
    public final String getUri()
    {
      GMTrace.i(13435999879168L, 100106);
      GMTrace.o(13435999879168L, 100106);
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */