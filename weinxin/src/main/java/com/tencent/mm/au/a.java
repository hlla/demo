package com.tencent.mm.au;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bhq;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;

public final class a
  extends k
  implements j
{
  private String filemd5;
  public String filename;
  private b gUq;
  public com.tencent.mm.y.e gUt;
  private String hTp;
  private int hTq;
  private int hTr;
  public int hTs;
  private int hTt;
  ai hqz;
  private int sampleRate;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(3497982427136L, 26062);
    this.hTp = null;
    this.filemd5 = null;
    this.filename = null;
    this.sampleRate = 0;
    this.hTq = 0;
    this.hTr = 0;
    this.hTs = 0;
    this.hTt = 5;
    this.hqz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(3501740523520L, 26090);
        long l = com.tencent.mm.a.e.aN(a.this.filename);
        v.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.sd() + " onTimerExpired: file:" + a.this.filename + " nowlen:" + l + " oldoff:" + a.this.hTs);
        if (a.this.a(a.this.hsm, a.this.gUt) == -1) {
          a.this.gUt.a(3, -1, "doScene failed", a.this);
        }
        GMTrace.o(3501740523520L, 26090);
        return false;
      }
    }, true);
    this.hTp = bf.NA();
    this.filename = paramString;
    this.hTt = paramInt1;
    this.sampleRate = paramInt2;
    this.hTq = paramInt3;
    this.hTr = paramInt4;
    paramInt1 = com.tencent.mm.a.e.aN(this.filename);
    this.filemd5 = com.tencent.mm.a.g.n(com.tencent.mm.a.e.c(this.filename, 0, paramInt1));
    GMTrace.o(3497982427136L, 26062);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    int i = 3960;
    GMTrace.i(3498116644864L, 26063);
    this.gUt = parame1;
    int k = com.tencent.mm.a.e.aN(this.filename);
    v.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.sd() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.hTs + "this.filemd5 " + this.filemd5);
    if (k <= 0)
    {
      v.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
      GMTrace.o(3498116644864L, 26063);
      return -1;
    }
    int j = k - this.hTs;
    if (j > 3960) {}
    for (;;)
    {
      v.i("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.sd() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.hTs + "  canReadLen " + i);
      parame1 = com.tencent.mm.a.e.c(this.filename, this.hTs, i);
      if (parame1 == null)
      {
        v.e("MicroMsg.NetSceneUploadMedia", "read data error");
        GMTrace.o(3498116644864L, 26063);
        return -1;
      }
      Object localObject = new b.a();
      ((b.a)localObject).hrV = new bhp();
      ((b.a)localObject).hrW = new bhq();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
      ((b.a)localObject).hrU = 240;
      ((b.a)localObject).hrX = 111;
      ((b.a)localObject).hrY = 1000000111;
      this.gUq = ((b.a)localObject).BE();
      localObject = (bhp)this.gUq.hrS.hsa;
      ((bhp)localObject).uft = new avu().OU(this.hTp);
      ((bhp)localObject).tqC = new avt().bb(parame1);
      ((bhp)localObject).tff = parame1.length;
      ((bhp)localObject).ufu = new avu().OU(this.filemd5);
      ((bhp)localObject).tfd = k;
      ((bhp)localObject).tfe = this.hTs;
      ((bhp)localObject).mtN = this.hTt;
      ((bhp)localObject).ufv = 1;
      ((bhp)localObject).ufw = this.sampleRate;
      ((bhp)localObject).ufx = this.hTq;
      ((bhp)localObject).ufy = this.hTr;
      i = a(parame, this.gUq, this);
      GMTrace.o(3498116644864L, 26063);
      return i;
      i = j;
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(3498519298048L, 26066);
    int i = k.b.hsC;
    GMTrace.o(3498519298048L, 26066);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(3498385080320L, 26065);
    v.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.sd() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bhp)((b)paramp).hrS.hsa;
    paramp = ((bhq)((b)paramp).hrT.hsa).tso;
    v.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[] { this.filename, paramp, Integer.valueOf(paramArrayOfByte.tfd), Integer.valueOf(paramArrayOfByte.tff), Integer.valueOf(paramArrayOfByte.tfe) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.sd() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(3498385080320L, 26065);
      return;
    }
    if ((paramArrayOfByte.tfd <= paramArrayOfByte.tff + paramArrayOfByte.tfe) && (paramp != null) && (!paramp.equals("0")))
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(3498385080320L, 26065);
      return;
    }
    paramInt1 = paramArrayOfByte.tfe;
    this.hTs = (paramArrayOfByte.tqC.tXB + paramInt1);
    v.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
    this.hqz.v(500L, 500L);
    GMTrace.o(3498385080320L, 26065);
  }
  
  public final int getType()
  {
    GMTrace.i(3498250862592L, 26064);
    GMTrace.o(3498250862592L, 26064);
    return 240;
  }
  
  protected final int ub()
  {
    GMTrace.i(3498653515776L, 26067);
    GMTrace.o(3498653515776L, 26067);
    return 60;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/au/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */