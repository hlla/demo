package com.tencent.mm.modelfriend;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;

public final class x
  extends k
  implements j
{
  public com.tencent.mm.y.e gUt;
  public final p htc;
  
  public x(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    GMTrace.i(4447572852736L, 33137);
    this.gUt = null;
    this.htc = new a();
    t.a locala = (t.a)this.htc.BG();
    locala.sYr.tFu = paramString1;
    locala.sYr.tFv = paramString2;
    locala.sYr.jMD = paramString3;
    locala.sYr.tFw = paramString4;
    locala.sYr.tFx = paramString5;
    locala.sYr.tFy = paramString6;
    locala.sYr.tFz = paramInt;
    locala.sYr.lda = u.bID();
    locala.sYr.tfW = ap.uY();
    GMTrace.o(4447572852736L, 33137);
  }
  
  public final byte[] FJ()
  {
    GMTrace.i(4448512376832L, 33144);
    byte[] arrayOfByte = n.a(((t.b)this.htc.zg()).sYs.tFA, new byte[0]);
    GMTrace.o(4448512376832L, 33144);
    return arrayOfByte;
  }
  
  public final String FK()
  {
    GMTrace.i(4448646594560L, 33145);
    String str = ((t.b)this.htc.zg()).sYs.tFx;
    GMTrace.o(4448646594560L, 33145);
    return str;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4447707070464L, 33138);
    this.gUt = parame1;
    int i = a(parame, this.htc, this);
    GMTrace.o(4447707070464L, 33138);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(4448109723648L, 33141);
    int i = k.b.hsC;
    GMTrace.o(4448109723648L, 33141);
    return i;
  }
  
  public final void a(final int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4448378159104L, 33143);
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramp.BG().sXU.ver;
      v.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(4433345773568L, 33031);
          new m().a(x.this.hsm, new com.tencent.mm.y.e()
          {
            public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, k paramAnonymous2k)
            {
              GMTrace.i(4433614209024L, 33033);
              v.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2k.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                x.this.gUt.a(paramAnonymous2Int1, paramAnonymous2Int2, "", x.this);
                GMTrace.o(4433614209024L, 33033);
                return;
              }
              x.this.a(x.this.hsm, x.this.gUt);
              GMTrace.o(4433614209024L, 33033);
            }
          });
          GMTrace.o(4433345773568L, 33031);
        }
      });
      GMTrace.o(4448378159104L, 33143);
      return;
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(4448378159104L, 33143);
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(4448243941376L, 33142);
    GMTrace.o(4448243941376L, 33142);
  }
  
  public final int getType()
  {
    GMTrace.i(4447841288192L, 33139);
    GMTrace.o(4447841288192L, 33139);
    return 429;
  }
  
  protected final int ub()
  {
    GMTrace.i(4447975505920L, 33140);
    GMTrace.o(4447975505920L, 33140);
    return 3;
  }
  
  public static final class a
    extends i
  {
    private final t.a hBs;
    private final t.b hBt;
    
    public a()
    {
      GMTrace.i(4454954827776L, 33192);
      this.hBs = new t.a();
      this.hBt = new t.b();
      GMTrace.o(4454954827776L, 33192);
    }
    
    public final int BD()
    {
      GMTrace.i(4455625916416L, 33197);
      GMTrace.o(4455625916416L, 33197);
      return 1;
    }
    
    public final int getType()
    {
      GMTrace.i(4455357480960L, 33195);
      GMTrace.o(4455357480960L, 33195);
      return 429;
    }
    
    public final String getUri()
    {
      GMTrace.i(4455491698688L, 33196);
      GMTrace.o(4455491698688L, 33196);
      return "/cgi-bin/micromsg-bin/getsuggestalias";
    }
    
    protected final k.d zf()
    {
      GMTrace.i(4455089045504L, 33193);
      t.a locala = this.hBs;
      GMTrace.o(4455089045504L, 33193);
      return locala;
    }
    
    public final k.e zg()
    {
      GMTrace.i(4455223263232L, 33194);
      t.b localb = this.hBt;
      GMTrace.o(4455223263232L, 33194);
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */