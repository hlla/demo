package com.tencent.mm.modelsimple;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.i.g;
import com.tencent.mm.network.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.fu;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.a;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class f
  extends k
  implements j
{
  private com.tencent.mm.y.e gUt;
  private p htc;
  
  private f(boolean paramBoolean)
  {
    GMTrace.i(1362444156928L, 10151);
    this.htc = new a();
    l.a locala = (l.a)this.htc.BG();
    locala.netType = l.getNetType(aa.getContext());
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      locala.sXY = i;
      GMTrace.o(1362444156928L, 10151);
      return;
    }
  }
  
  public static void bn(boolean paramBoolean)
  {
    GMTrace.i(1362175721472L, 10149);
    if (!ap.zb())
    {
      GMTrace.o(1362175721472L, 10149);
      return;
    }
    if ((ap.vd() == null) || (ap.vd().hsI == null) || (ap.vd().hsI.Cc() == null))
    {
      GMTrace.o(1362175721472L, 10149);
      return;
    }
    if (paramBoolean)
    {
      ap.vd().hsI.Cc().aY(true);
      ap.vd().a(new f(true), 0);
      GMTrace.o(1362175721472L, 10149);
      return;
    }
    paramBoolean = gu(2);
    ap.vd().hsI.Cc().aY(paramBoolean);
    f localf = new f(gu(1));
    ap.vd().a(localf, 0);
    GMTrace.o(1362175721472L, 10149);
  }
  
  private static boolean gu(int paramInt)
  {
    GMTrace.i(1362309939200L, 10150);
    int i;
    boolean bool;
    if (r.iji != -1)
    {
      i = r.iji;
      bool = b.foreground;
      v.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(r.iji), Integer.valueOf(i), Boolean.valueOf(bool) });
      if ((i & paramInt) == 0) {
        break label118;
      }
      bool = true;
    }
    label118:
    for (;;)
    {
      GMTrace.o(1362309939200L, 10150);
      return bool;
      try
      {
        i = bf.getInt(g.sV().getValue("MuteRoomDisable"), 0);
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.NetSceneBgFg", localException, "", new Object[0]);
        i = 0;
      }
      break;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1362578374656L, 10152);
    this.gUt = parame1;
    int i = a(parame, this.htc, this);
    GMTrace.o(1362578374656L, 10152);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1362846810112L, 10154);
    v.d("MicroMsg.NetSceneBgFg", " ret[%d]", new Object[] { Integer.valueOf(((l.b)paramp.zg()).sXZ.kyO) });
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1362846810112L, 10154);
  }
  
  public final int getType()
  {
    GMTrace.i(1362712592384L, 10153);
    GMTrace.o(1362712592384L, 10153);
    return 0;
  }
  
  public static final class a
    extends i
  {
    private final l.a hRp;
    private final l.b hRq;
    
    public a()
    {
      GMTrace.i(1349425037312L, 10054);
      this.hRp = new l.a();
      this.hRq = new l.b();
      GMTrace.o(1349425037312L, 10054);
    }
    
    public final int getType()
    {
      GMTrace.i(1349827690496L, 10057);
      GMTrace.o(1349827690496L, 10057);
      return 0;
    }
    
    public final String getUri()
    {
      GMTrace.i(1349961908224L, 10058);
      GMTrace.o(1349961908224L, 10058);
      return null;
    }
    
    protected final k.d zf()
    {
      GMTrace.i(1349559255040L, 10055);
      l.a locala = this.hRp;
      GMTrace.o(1349559255040L, 10055);
      return locala;
    }
    
    public final k.e zg()
    {
      GMTrace.i(1349693472768L, 10056);
      l.b localb = this.hRq;
      GMTrace.o(1349693472768L, 10056);
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */