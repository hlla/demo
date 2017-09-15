package com.tencent.mm.modelbiz;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.protocal.c.ayq;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.n;

public final class c
  extends i<b>
  implements com.tencent.mm.y.e
{
  public static final String[] gUn;
  private com.tencent.mm.sdk.e.e gUp;
  private final com.tencent.mm.sdk.e.k<a, c.a.a> htP;
  
  static
  {
    GMTrace.i(4536424988672L, 33799);
    gUn = new String[] { i.a(b.gTF, "BizEnterprise") };
    GMTrace.o(4536424988672L, 33799);
  }
  
  public c(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, b.gTF, "BizEnterprise", null);
    GMTrace.i(4534411722752L, 33784);
    this.htP = new com.tencent.mm.sdk.e.k() {};
    this.gUp = parame;
    parame.eE("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
    h.vH().gXs.a(1343, this);
    h.vH().gXs.a(1228, this);
    GMTrace.o(4534411722752L, 33784);
  }
  
  public static v a(String paramString, boolean paramBoolean, com.tencent.mm.y.e parame)
  {
    GMTrace.i(4535753900032L, 33794);
    gy localgy = new gy();
    localgy.tjf = paramString;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localgy.tjr = i;
      localgy.tjp = 0;
      paramString = new v(localgy, parame);
      if (!h.vH().gXs.a(paramString, 0)) {
        break;
      }
      GMTrace.o(4535753900032L, 33794);
      return paramString;
    }
    GMTrace.o(4535753900032L, 33794);
    return null;
  }
  
  public static void a(v paramv)
  {
    GMTrace.i(4536022335488L, 33796);
    h.vH().gXs.c(paramv);
    paramv.data = null;
    GMTrace.o(4536022335488L, 33796);
  }
  
  private boolean a(b paramb)
  {
    GMTrace.i(4535351246848L, 33791);
    if (paramb == null)
    {
      GMTrace.o(4535351246848L, 33791);
      return false;
    }
    boolean bool = super.b(paramb);
    int i = c.a.b.htU;
    if (!bool)
    {
      bool = super.a(paramb);
      i = c.a.b.htW;
    }
    for (;;)
    {
      if (bool)
      {
        c.a.a locala = new c.a.a();
        locala.htS = paramb.field_userName;
        locala.htR = i;
        locala.htT = paramb;
        this.htP.by(locala);
        this.htP.doNotify();
      }
      GMTrace.o(4535351246848L, 33791);
      return bool;
    }
  }
  
  private boolean a(gy paramgy)
  {
    GMTrace.i(4535485464576L, 33792);
    b localb = hD(paramgy.tjf);
    localb.field_userName = paramgy.tjf;
    localb.field_qyUin = paramgy.tjp;
    localb.field_userUin = paramgy.tjq;
    localb.field_wwMaxExposeTimes = paramgy.tjs;
    localb.field_wwUserVid = paramgy.tjt;
    localb.field_wwCorpId = paramgy.tju;
    if ((paramgy.tjt == 0L) && (paramgy.tju == 0L) && (paramgy.tjp != 0))
    {
      localb.field_wwUserVid = paramgy.tjq;
      localb.field_wwCorpId = paramgy.tjp;
    }
    paramgy.tjr &= 0xFFFFFFF7;
    localb.field_userFlag = (paramgy.tjr | localb.field_userFlag & 0x8);
    boolean bool = a(localb);
    GMTrace.o(4535485464576L, 33792);
    return bool;
  }
  
  public static boolean a(String paramString, com.tencent.mm.y.e parame)
  {
    GMTrace.i(4535619682304L, 33793);
    if (bf.mA(paramString))
    {
      GMTrace.o(4535619682304L, 33793);
      return false;
    }
    if (e.ib(paramString)) {}
    for (int i = 1;; i = 2)
    {
      paramString = new q(paramString, i, parame);
      boolean bool = h.vH().gXs.a(paramString, 0);
      GMTrace.o(4535619682304L, 33793);
      return bool;
      if (!e.ia(paramString)) {
        break;
      }
    }
    GMTrace.o(4535619682304L, 33793);
    return false;
  }
  
  private b hD(String paramString)
  {
    GMTrace.i(4534948593664L, 33788);
    b localb = hC(paramString);
    if (localb == null)
    {
      localb = new b();
      localb.field_userName = paramString;
      localb.field_qyUin = 0;
      localb.field_userUin = 0;
      localb.field_userFlag = 0;
      localb.field_wwExposeTimes = 0;
      localb.field_wwMaxExposeTimes = 0;
      localb.field_wwUserVid = 0L;
      localb.field_wwCorpId = 0L;
      GMTrace.o(4534948593664L, 33788);
      return localb;
    }
    GMTrace.o(4534948593664L, 33788);
    return localb;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    int j = -1;
    GMTrace.i(4536290770944L, 33798);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      GMTrace.o(4536290770944L, 33798);
      return;
    }
    int i = paramInt2;
    Object localObject2;
    Object localObject1;
    if ((paramk instanceof q))
    {
      localObject2 = (q)paramk;
      if ((((q)localObject2).gUq != null) && (((q)localObject2).gUq.hrT.hsa != null)) {}
      for (localObject1 = (vk)((q)localObject2).gUq.hrT.hsa; (localObject1 == null) || (((vk)localObject1).tjl == null) || (((vk)localObject1).tjl.ret != 0) || (((vk)localObject1).tBf == null); localObject1 = null)
      {
        GMTrace.o(4536290770944L, 33798);
        return;
      }
      if (!a(((vk)localObject1).tBf)) {
        paramInt2 = -1;
      }
      localObject1 = (com.tencent.mm.y.e)((q)localObject2).data;
      i = paramInt2;
      if (localObject1 != null)
      {
        ((com.tencent.mm.y.e)localObject1).a(paramInt1, paramInt2, paramString, paramk);
        i = paramInt2;
      }
    }
    if ((paramk instanceof v))
    {
      localObject2 = (v)paramk;
      if ((((v)localObject2).gUq != null) && (((v)localObject2).gUq.hrT.hsa != null)) {}
      for (localObject1 = (ayq)((v)localObject2).gUq.hrT.hsa; (localObject1 == null) || (((ayq)localObject1).tjl == null) || (((ayq)localObject1).tjl.ret != 0) || (((ayq)localObject1).tBf == null); localObject1 = null)
      {
        GMTrace.o(4536290770944L, 33798);
        return;
      }
      if (a(((ayq)localObject1).tBf)) {
        break label329;
      }
    }
    label329:
    for (paramInt2 = j;; paramInt2 = i)
    {
      localObject1 = (com.tencent.mm.y.e)((v)localObject2).data;
      if (localObject1 != null) {
        ((com.tencent.mm.y.e)localObject1).a(paramInt1, paramInt2, paramString, paramk);
      }
      GMTrace.o(4536290770944L, 33798);
      return;
    }
  }
  
  public final void a(a parama)
  {
    GMTrace.i(4534680158208L, 33786);
    if (this.htP != null) {
      this.htP.remove(parama);
    }
    GMTrace.o(4534680158208L, 33786);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    GMTrace.i(4534545940480L, 33785);
    this.htP.a(parama, paramLooper);
    GMTrace.o(4534545940480L, 33785);
  }
  
  public final boolean gR(String paramString)
  {
    GMTrace.i(4535217029120L, 33790);
    if (bf.mA(paramString))
    {
      GMTrace.o(4535217029120L, 33790);
      return false;
    }
    b localb = new b();
    localb.field_userName = paramString;
    boolean bool = super.a(localb, new String[] { "userName" });
    if (bool)
    {
      c.a.a locala = new c.a.a();
      locala.htS = paramString;
      locala.htR = c.a.b.htV;
      locala.htT = localb;
      this.htP.by(locala);
      this.htP.doNotify();
    }
    GMTrace.o(4535217029120L, 33790);
    return bool;
  }
  
  public final b hC(String paramString)
  {
    GMTrace.i(4534814375936L, 33787);
    if (bf.mA(paramString))
    {
      GMTrace.o(4534814375936L, 33787);
      return null;
    }
    b localb = new b();
    localb.field_userName = paramString;
    if (super.b(localb, new String[0]))
    {
      GMTrace.o(4534814375936L, 33787);
      return localb;
    }
    a(paramString, null);
    GMTrace.o(4534814375936L, 33787);
    return null;
  }
  
  public final int hE(String paramString)
  {
    GMTrace.i(4535082811392L, 33789);
    paramString = hC(paramString);
    if (paramString == null)
    {
      GMTrace.o(4535082811392L, 33789);
      return 0;
    }
    int i = paramString.field_qyUin;
    GMTrace.o(4535082811392L, 33789);
    return i;
  }
  
  public final void hF(String paramString)
  {
    GMTrace.i(4535888117760L, 33795);
    paramString = hD(paramString);
    if (paramString.field_wwExposeTimes >= paramString.field_wwMaxExposeTimes)
    {
      GMTrace.o(4535888117760L, 33795);
      return;
    }
    paramString.field_wwExposeTimes += 1;
    a(paramString);
    GMTrace.o(4535888117760L, 33795);
  }
  
  public final boolean hG(String paramString)
  {
    GMTrace.i(4536156553216L, 33797);
    paramString = hC(paramString);
    if ((paramString != null) && ((paramString.field_userFlag & 0x1) != 0))
    {
      GMTrace.o(4536156553216L, 33797);
      return true;
    }
    GMTrace.o(4536156553216L, 33797);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public static final class a
    {
      public int htR;
      public String htS;
      public b htT;
      
      public a()
      {
        GMTrace.i(4529177231360L, 33745);
        GMTrace.o(4529177231360L, 33745);
      }
    }
    
    public static enum b
    {
      static
      {
        GMTrace.i(4551725809664L, 33913);
        htU = 1;
        htV = 2;
        htW = 3;
        htX = new int[] { htU, htV, htW };
        GMTrace.o(4551725809664L, 33913);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */