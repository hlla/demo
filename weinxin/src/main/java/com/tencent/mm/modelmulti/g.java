package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.ank;
import com.tencent.mm.protocal.c.anl;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.f;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class g
  extends k
  implements j
{
  public com.tencent.mm.y.e gUt;
  public final Queue<a> hDp;
  f hGb;
  public boolean hJL;
  public com.tencent.mm.compatible.util.g.a hJO;
  private StringBuilder hJP;
  final ank hJZ;
  public int hKa;
  public boolean hKb;
  public int hKc;
  public int hKd;
  private final ai hqz;
  private int retryCount;
  
  public g(f paramf)
  {
    GMTrace.i(13446871515136L, 100187);
    this.hGb = null;
    this.hJZ = new ank();
    this.hJP = new StringBuilder();
    this.hKa = 0;
    this.hKb = false;
    this.hKc = 0;
    this.hKd = 0;
    this.retryCount = 3;
    this.hJL = false;
    this.hDp = new LinkedList();
    this.hqz = new ai(h.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(13435597225984L, 100103);
        if ((!h.vG().uV()) || (a.uP()))
        {
          v.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
          GMTrace.o(13435597225984L, 100103);
          return false;
        }
        if (g.this.hJL)
        {
          v.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", new Object[] { Integer.valueOf(g.this.hashCode()) });
          GMTrace.o(13435597225984L, 100103);
          return false;
        }
        if (g.this.hDp.isEmpty())
        {
          v.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
          GMTrace.o(13435597225984L, 100103);
          return false;
        }
        v.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", new Object[] { Integer.valueOf(g.this.hashCode()), Long.valueOf(g.this.hJO.se()), Integer.valueOf(g.this.hDp.size()), Integer.valueOf(g.this.hKa), Boolean.valueOf(g.this.hKb), Integer.valueOf(g.this.hKd), Integer.valueOf(g.this.hKc) });
        h.vJ();
        long l = h.vI().gXW.cs(Thread.currentThread().getId());
        Object localObject1 = new c();
        ((c)localObject1).aX("NetSceneInit");
        int i;
        int j;
        label281:
        final Object localObject2;
        boolean bool;
        label325:
        Object localObject3;
        if (g.this.hKb)
        {
          i = 40;
          j = 0;
          if (j >= i) {
            break label1024;
          }
          localObject2 = (g.a)g.this.hDp.peek();
          if (((g.a)localObject2).hKi != Integer.MAX_VALUE) {
            break label647;
          }
          if (((g.a)localObject2).hKh != null) {
            break label641;
          }
          bool = true;
          Assert.assertTrue("in Queue tail , resp should be null", bool);
          h.vJ();
          localObject3 = (String)h.vI().vr().get(8198, null);
          h.vJ();
          h.vI().vr().set(8195, localObject3);
          aa.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", (String)localObject3).commit();
          h.vJ();
          h.vI().vr().set(8197, "");
          h.vJ();
          h.vI().vr().set(8198, "");
          h.vJ();
          h.vI().vr().set(15, Integer.valueOf(1));
          h.vJ();
          h.vI().vr().jV(true);
          v.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", new Object[] { Integer.valueOf(g.this.hashCode()), Long.valueOf(g.this.hJO.se()), Integer.valueOf(g.this.hKa), Integer.valueOf(g.this.hKc), Integer.valueOf(((g.a)localObject2).errType), Integer.valueOf(((g.a)localObject2).errCode) });
          h.vL().D(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(13437610491904L, 100118);
              g.this.gUt.a(localObject2.errType, localObject2.errCode, localObject2.fOW, g.this);
              GMTrace.o(13437610491904L, 100118);
            }
          });
          bool = false;
        }
        for (;;)
        {
          ((c)localObject1).aY("NetSceneInit");
          h.vJ();
          h.vI().gXW.aD(l);
          localObject1 = g.this;
          if (((g)localObject1).hGb == null)
          {
            v.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
            GMTrace.o(13435597225984L, 100103);
            return bool;
            i = 10;
            break;
            label641:
            bool = false;
            break label325;
            label647:
            localObject3 = ((g.a)localObject2).hKh.tQI;
            if ((localObject3 != null) && (((LinkedList)localObject3).size() > ((g.a)localObject2).hDC))
            {
              ((LinkedList)localObject3).size();
              if (((c)localObject1).a((lt)((LinkedList)localObject3).get(((g.a)localObject2).hDC), true)) {}
            }
            else
            {
              g.this.hDp.poll();
              h.vJ();
              h.vI().vr().set(8197, bf.bo(n.a(((g.a)localObject2).hKh.tQE)));
              h.vJ();
              h.vI().vr().set(8198, bf.bo(n.a(((g.a)localObject2).hKh.tQF)));
              h.vJ();
              h.vI().vr().set(16, Integer.valueOf(0));
              h.vJ();
              h.vI().vr().set(8196, Long.valueOf(((g.a)localObject2).hKh.tQG));
              h.vJ();
              h.vI().vr().jV(true);
              bool = true;
              continue;
            }
            ((g.a)localObject2).hDC += 1;
            localObject2 = g.this;
            ((g)localObject2).hKd += 1;
            j += 1;
            break label281;
          }
          label895:
          float f1;
          if (((g)localObject1).hKa > 50)
          {
            i = 50;
            if (((g)localObject1).hKb) {
              break label984;
            }
            f1 = 1.0F;
          }
          for (j = i;; j = (int)((100 - i) * f1 + i))
          {
            v.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", new Object[] { Integer.valueOf(((g)localObject1).hKd), Integer.valueOf(((g)localObject1).hKc), Float.valueOf(f1), Integer.valueOf(i) });
            ((g)localObject1).hGb.a(j, 100, (k)localObject1);
            break;
            i = ((g)localObject1).hKa;
            break label895;
            label984:
            float f2 = ((g)localObject1).hKd / ((g)localObject1).hKc;
            f1 = f2;
            if (f2 > 1.0F) {
              f1 = 1.0F;
            }
          }
          label1024:
          bool = true;
        }
      }
    }, true);
    v.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bf.bJP() });
    this.hJP.append("stack:" + bf.bJP() + " time:" + bf.Nz());
    this.hGb = paramf;
    GMTrace.o(13446871515136L, 100187);
  }
  
  private int a(com.tencent.mm.network.e parame, avt paramavt1, avt paramavt2)
  {
    GMTrace.i(13447139950592L, 100189);
    this.hJP.append(" lastd:" + this.hsn + " dotime:" + bf.Nz() + " net:" + al.getNetType(aa.getContext()));
    b localb = new b();
    avt localavt = paramavt1;
    if (paramavt1 == null)
    {
      h.vJ();
      localavt = n.G(bf.PS(bf.mz((String)h.vI().vr().get(8197, null))));
    }
    paramavt1 = paramavt2;
    if (paramavt2 == null)
    {
      h.vJ();
      paramavt1 = n.G(bf.PS(bf.mz((String)h.vI().vr().get(8198, null))));
    }
    h.vJ();
    if ((bf.f((Integer)h.vI().vr().get(16, null)) != 0) && ((localavt == null) || (localavt.tXB <= 0))) {
      localb.BG().sXQ = 7;
    }
    for (;;)
    {
      this.hJZ.tQE = localavt;
      this.hJZ.tQF = paramavt1;
      ((v.a)localb.BG()).sYu = this.hJZ;
      v.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.hJO.se()), Integer.valueOf(this.hKa), this.hJZ.jLx, this.hJZ.lda, Integer.valueOf(localb.BG().sXQ), bf.bo(n.a(localavt)), bf.bo(n.a(paramavt1)) });
      this.hKa += 1;
      int i = a(parame, localb, this);
      GMTrace.o(13447139950592L, 100189);
      return i;
      h.vJ();
      if (bf.mz((String)h.vI().vr().get(8195, null)).length() <= 0) {
        localb.BG().sXQ = 3;
      } else {
        localb.BG().sXQ = 4;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, anl paramanl)
  {
    GMTrace.i(13447676821504L, 100193);
    a locala = new a();
    locala.hKi = paramInt1;
    locala.errCode = paramInt3;
    locala.errType = paramInt2;
    locala.fOW = paramString;
    locala.hKh = paramanl;
    this.hDp.add(locala);
    if (this.hqz.bJg()) {
      this.hqz.v(50L, 50L);
    }
    GMTrace.o(13447676821504L, 100193);
  }
  
  public final boolean BI()
  {
    GMTrace.i(13447408386048L, 100191);
    GMTrace.o(13447408386048L, 100191);
    return true;
  }
  
  public final boolean BJ()
  {
    GMTrace.i(15694481588224L, 116933);
    boolean bool = super.BJ();
    GMTrace.o(15694481588224L, 116933);
    return bool;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13447005732864L, 100188);
    this.hJO = new com.tencent.mm.compatible.util.g.a();
    this.gUt = parame1;
    parame1 = this.hJZ;
    h.vJ();
    parame1.jLx = ((String)h.vI().vr().get(2, null));
    if (!bf.mA(this.hJZ.jLx)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("by DK: req.UserName is null", bool);
      this.hJZ.lda = u.bID();
      int i = a(parame, null, null);
      GMTrace.o(13447005732864L, 100188);
      return i;
    }
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(13448079474688L, 100196);
    int i = k.b.hsC;
    GMTrace.o(13448079474688L, 100196);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13447274168320L, 100190);
    this.hJP.append(" endtime:" + bf.Nz());
    v.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(paramInt1) });
    if ((paramInt2 == 4) && (paramInt3 == -100))
    {
      v.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      this.hJL = true;
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(13447274168320L, 100190);
      return;
    }
    if (((paramInt2 != 0) || (paramInt3 != 0)) && ((paramInt2 != 4) || (paramInt3 != -17)))
    {
      v.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", new Object[] { Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
      if (this.retryCount > 0)
      {
        this.retryCount -= 1;
        if (a(this.hsm, null, null) != -1) {}
      }
      else
      {
        this.hJL = true;
        this.gUt.a(3, -1, "", this);
      }
      GMTrace.o(13447274168320L, 100190);
      return;
    }
    paramp = ((v.b)paramp.zg()).sYv;
    this.hKc += paramp.tQH;
    v.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(this.hJO.se()), Integer.valueOf(this.hKc), Integer.valueOf(this.hKa), Integer.valueOf(paramp.tkt) });
    a(this.hKa - 1, paramInt2, paramInt3, paramString, paramp);
    if (((paramp.tkt & 0x7) != 0) && (!super.BJ()))
    {
      if (a(this.hsm, paramp.tQE, paramp.tQF) == -1)
      {
        v.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
        a(Integer.MAX_VALUE, 3, -1, "", null);
        GMTrace.o(13447274168320L, 100190);
      }
    }
    else
    {
      v.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.hJO.se()), Integer.valueOf(this.hKa) });
      this.hKb = true;
      a(Integer.MAX_VALUE, 0, 0, "", null);
    }
    GMTrace.o(13447274168320L, 100190);
  }
  
  protected final void cancel()
  {
    GMTrace.i(13447542603776L, 100192);
    v.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", new Object[] { bf.bJP() });
    super.cancel();
    this.hJL = true;
    GMTrace.o(13447542603776L, 100192);
  }
  
  public final String getInfo()
  {
    GMTrace.i(13447811039232L, 100194);
    String str = this.hJP.toString();
    GMTrace.o(13447811039232L, 100194);
    return str;
  }
  
  public final int getType()
  {
    GMTrace.i(13448347910144L, 100198);
    GMTrace.o(13448347910144L, 100198);
    return 139;
  }
  
  protected final int ub()
  {
    GMTrace.i(13447945256960L, 100195);
    GMTrace.o(13447945256960L, 100195);
    return 500;
  }
  
  final class a
  {
    int errCode;
    int errType;
    String fOW;
    int hDC;
    anl hKh;
    int hKi;
    
    a()
    {
      GMTrace.i(13450898046976L, 100217);
      this.hDC = 0;
      this.hKi = 0;
      GMTrace.o(13450898046976L, 100217);
    }
  }
  
  public static final class b
    extends i
  {
    private final v.a hKj;
    private final v.b hKk;
    
    public b()
    {
      GMTrace.i(13451032264704L, 100218);
      this.hKj = new v.a();
      this.hKk = new v.b();
      GMTrace.o(13451032264704L, 100218);
    }
    
    public final int getType()
    {
      GMTrace.i(13451434917888L, 100221);
      GMTrace.o(13451434917888L, 100221);
      return 139;
    }
    
    public final String getUri()
    {
      GMTrace.i(13451569135616L, 100222);
      GMTrace.o(13451569135616L, 100222);
      return "/cgi-bin/micromsg-bin/newinit";
    }
    
    protected final k.d zf()
    {
      GMTrace.i(13451166482432L, 100219);
      v.a locala = this.hKj;
      GMTrace.o(13451166482432L, 100219);
      return locala;
    }
    
    public final k.e zg()
    {
      GMTrace.i(13451300700160L, 100220);
      v.b localb = this.hKk;
      GMTrace.o(13451300700160L, 100220);
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */