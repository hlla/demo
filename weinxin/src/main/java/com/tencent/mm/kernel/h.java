package com.tencent.mm.kernel;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.bn.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ac;
import com.tencent.mm.u.br;
import com.tencent.mm.y.n;
import com.tencent.mm.y.n.a;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class h
{
  private static h gYy;
  public final e.b gXN;
  public final e.c gXO;
  public final e.a gXP;
  public final List<com.tencent.mm.kernel.api.a> gXS;
  public final b.a gXr;
  private ae gYA;
  private br gYB;
  public e gYC;
  public a gYD;
  public b gYE;
  public final a gYF;
  public final b gYG;
  public final List<ac> gYH;
  private final boolean gYI;
  public volatile boolean gYJ;
  public i<com.tencent.mm.kernel.b.f> gYz;
  
  private h(final com.tencent.mm.kernel.b.f paramf)
  {
    GMTrace.i(18788602871808L, 139986);
    this.gYB = null;
    this.gYF = new a();
    this.gYG = new b();
    this.gXS = new ArrayList();
    this.gYH = new ArrayList();
    this.gXN = new e.b();
    this.gXO = new e.c();
    this.gXr = new b.a();
    this.gXP = new e.a();
    this.gYJ = false;
    this.gYz = i.b(paramf);
    this.gYI = ((com.tencent.mm.kernel.b.f)this.gYz.vF().vj()).ej("");
    if (this.gYI)
    {
      this.gYB = new br();
      this.gYA = new ae();
      this.gYA.D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13506061533184L, 100628);
          al.ei(aa.getContext());
          GMTrace.o(13506061533184L, 100628);
        }
      });
    }
    i.vE().gXI = new c.a()
    {
      public final void a(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        GMTrace.i(13491029147648L, 100516);
        h.this.a(paramf, paramAnonymousa);
        GMTrace.o(13491029147648L, 100516);
      }
      
      public final void b(com.tencent.mm.kernel.b.d paramAnonymousd)
      {
        GMTrace.i(13490894929920L, 100515);
        h.this.a(paramf, paramAnonymousd);
        GMTrace.o(13490894929920L, 100515);
      }
      
      public final void b(com.tencent.mm.kernel.c.a paramAnonymousa)
      {
        GMTrace.i(14609062821888L, 108846);
        h localh = h.this;
        com.tencent.mm.kernel.b.f localf = paramf;
        if ((paramAnonymousa instanceof ApplicationLifeCycle))
        {
          ApplicationLifeCycle localApplicationLifeCycle = (ApplicationLifeCycle)paramAnonymousa;
          localf.gZr.remove(localApplicationLifeCycle);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.c)) {
          localh.gYF.remove((com.tencent.mm.kernel.api.c)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.a)) {
          localh.gXS.remove(paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.b)) {
          localh.gXP.remove((com.tencent.mm.kernel.api.b)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.e)) {
          localh.gXN.remove((com.tencent.mm.kernel.api.e)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.f)) {
          localh.gXO.remove((com.tencent.mm.kernel.api.f)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.d)) {
          localh.gXr.remove((com.tencent.mm.kernel.api.d)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof com.tencent.mm.kernel.api.h)) {
          localh.gYz.b((com.tencent.mm.kernel.api.h)paramAnonymousa);
        }
        if ((paramAnonymousa instanceof ac)) {
          localh.gYH.remove(paramAnonymousa);
        }
        GMTrace.o(14609062821888L, 108846);
      }
    };
    GMTrace.o(18788602871808L, 139986);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, N paramN)
  {
    GMTrace.i(13514383032320L, 100690);
    vJ();
    vE().a(paramClass, new com.tencent.mm.kernel.c.c(paramN));
    GMTrace.o(13514383032320L, 100690);
  }
  
  public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, com.tencent.mm.kernel.c.b<N> paramb)
  {
    GMTrace.i(13514517250048L, 100691);
    vJ();
    vE().a(paramClass, paramb);
    GMTrace.o(13514517250048L, 100691);
  }
  
  /* Error */
  public static void a(String paramString, android.app.Application paramApplication, com.tencent.mm.app.MMApplicationLike paramMMApplicationLike)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc2_w 198
    //   6: ldc -56
    //   8: invokestatic 75	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: getstatic 202	com/tencent/mm/kernel/h:gYy	Lcom/tencent/mm/kernel/h;
    //   14: ifnull +48 -> 62
    //   17: getstatic 202	com/tencent/mm/kernel/h:gYy	Lcom/tencent/mm/kernel/h;
    //   20: getfield 119	com/tencent/mm/kernel/h:gYz	Lcom/tencent/mm/kernel/i;
    //   23: invokevirtual 123	com/tencent/mm/kernel/i:vF	()Lcom/tencent/mm/kernel/d;
    //   26: invokevirtual 129	com/tencent/mm/kernel/d:vj	()Lcom/tencent/mm/kernel/b/e;
    //   29: checkcast 131	com/tencent/mm/kernel/b/f
    //   32: astore_0
    //   33: aload_0
    //   34: aload_2
    //   35: putfield 206	com/tencent/mm/kernel/b/f:gZq	Lcom/tencent/mm/app/MMApplicationLike;
    //   38: aload_0
    //   39: aload_1
    //   40: putfield 210	com/tencent/mm/kernel/b/e:gZp	Landroid/app/Application;
    //   43: ldc -44
    //   45: ldc -42
    //   47: invokestatic 219	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: ldc2_w 198
    //   53: ldc -56
    //   55: invokestatic 172	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   58: ldc 2
    //   60: monitorexit
    //   61: return
    //   62: new 10	com/tencent/mm/kernel/h$3
    //   65: dup
    //   66: invokespecial 220	com/tencent/mm/kernel/h$3:<init>	()V
    //   69: invokestatic 225	com/tencent/mm/kernel/j:a	(Lcom/tencent/mm/kernel/j$a;)V
    //   72: ldc -44
    //   74: ldc -29
    //   76: invokestatic 219	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: new 2	com/tencent/mm/kernel/h
    //   82: dup
    //   83: new 131	com/tencent/mm/kernel/b/f
    //   86: dup
    //   87: aload_0
    //   88: aload_1
    //   89: aload_2
    //   90: invokespecial 229	com/tencent/mm/kernel/b/f:<init>	(Ljava/lang/String;Landroid/app/Application;Lcom/tencent/mm/app/MMApplicationLike;)V
    //   93: invokespecial 231	com/tencent/mm/kernel/h:<init>	(Lcom/tencent/mm/kernel/b/f;)V
    //   96: putstatic 202	com/tencent/mm/kernel/h:gYy	Lcom/tencent/mm/kernel/h;
    //   99: ldc2_w 198
    //   102: ldc -56
    //   104: invokestatic 172	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   107: goto -49 -> 58
    //   110: astore_0
    //   111: ldc 2
    //   113: monitorexit
    //   114: aload_0
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramString	String
    //   0	116	1	paramApplication	android.app.Application
    //   0	116	2	paramMMApplicationLike	com.tencent.mm.app.MMApplicationLike
    // Exception table:
    //   from	to	target	type
    //   3	58	110	finally
    //   62	107	110	finally
  }
  
  public static void eO(int paramInt)
  {
    GMTrace.i(13515188338688L, 100696);
    a locala = vG();
    if ((a.eL(paramInt)) && (a.gWW.uH() == paramInt) && (locala.uV()))
    {
      com.tencent.mm.sdk.platformtools.v.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", new Object[] { Integer.valueOf(paramInt) });
      GMTrace.o(13515188338688L, 100696);
      return;
    }
    synchronized (locala.gWV)
    {
      a.gWW.dj(paramInt);
      locala.uN();
      locala.aP(true);
      GMTrace.o(13515188338688L, 100696);
      return;
    }
  }
  
  public static <T extends com.tencent.mm.kernel.c.a> T h(Class<T> paramClass)
  {
    GMTrace.i(13514248814592L, 100689);
    vJ();
    paramClass = vE().h(paramClass);
    GMTrace.o(13514248814592L, 100689);
    return paramClass;
  }
  
  public static <T extends com.tencent.mm.kernel.b.a> T j(Class<T> paramClass)
  {
    GMTrace.i(18788871307264L, 139988);
    vJ();
    paramClass = vE().j(paramClass);
    GMTrace.o(18788871307264L, 139988);
    return paramClass;
  }
  
  public static c vE()
  {
    GMTrace.i(13513309290496L, 100682);
    vJ();
    Assert.assertNotNull("mCorePlugins not initialized!", i.vE());
    vJ();
    c localc = i.vE();
    GMTrace.o(13513309290496L, 100682);
    return localc;
  }
  
  public static d<com.tencent.mm.kernel.b.f> vF()
  {
    GMTrace.i(13513443508224L, 100683);
    Assert.assertNotNull("mCoreProcess not initialized!", vJ().gYz.vF());
    d locald = vJ().gYz.vF();
    GMTrace.o(13513443508224L, 100683);
    return locald;
  }
  
  public static a vG()
  {
    GMTrace.i(13513577725952L, 100684);
    Assert.assertNotNull("mCoreAccount not initialized!", vJ().gYD);
    a locala = vJ().gYD;
    GMTrace.o(13513577725952L, 100684);
    return locala;
  }
  
  public static b vH()
  {
    GMTrace.i(13513711943680L, 100685);
    Assert.assertNotNull("mCoreNetwork not initialized!", vJ().gYE);
    b localb = vJ().gYE;
    GMTrace.o(13513711943680L, 100685);
    return localb;
  }
  
  public static e vI()
  {
    GMTrace.i(13513846161408L, 100686);
    Assert.assertNotNull("mCoreStorage not initialized!", vJ().gYC);
    e locale = vJ().gYC;
    GMTrace.o(13513846161408L, 100686);
    return locale;
  }
  
  public static h vJ()
  {
    GMTrace.i(13513980379136L, 100687);
    Assert.assertNotNull("Kernel not initialized by MMApplication!", gYy);
    h localh = gYy;
    GMTrace.o(13513980379136L, 100687);
    return localh;
  }
  
  public static br vK()
  {
    GMTrace.i(13514785685504L, 100693);
    Assert.assertTrue(vJ().gYI);
    br localbr = vJ().gYB;
    GMTrace.o(13514785685504L, 100693);
    return localbr;
  }
  
  public static ae vL()
  {
    GMTrace.i(13514919903232L, 100694);
    Assert.assertTrue(vJ().gYI);
    ae localae = vJ().gYA;
    GMTrace.o(13514919903232L, 100694);
    return localae;
  }
  
  public static n vd()
  {
    GMTrace.i(13514651467776L, 100692);
    vJ();
    n localn = vH().gXs;
    GMTrace.o(13514651467776L, 100692);
    return localn;
  }
  
  public final void a(com.tencent.mm.kernel.api.h paramh)
  {
    GMTrace.i(13513040855040L, 100680);
    this.gYz.a(paramh);
    GMTrace.o(13513040855040L, 100680);
  }
  
  public final void a(com.tencent.mm.kernel.b.f paramf, Object paramObject)
  {
    GMTrace.i(18788737089536L, 139987);
    if ((paramObject instanceof ApplicationLifeCycle))
    {
      ApplicationLifeCycle localApplicationLifeCycle = (ApplicationLifeCycle)paramObject;
      paramf.gZr.bI(localApplicationLifeCycle);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.c)) {
      this.gYF.bI((com.tencent.mm.kernel.api.c)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.a)) {
      this.gXS.add((com.tencent.mm.kernel.api.a)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.b)) {
      this.gXP.bI((com.tencent.mm.kernel.api.b)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.e)) {
      this.gXN.bI((com.tencent.mm.kernel.api.e)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.f)) {
      this.gXO.bI((com.tencent.mm.kernel.api.f)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.d)) {
      this.gXr.bI((com.tencent.mm.kernel.api.d)paramObject);
    }
    if ((paramObject instanceof com.tencent.mm.kernel.api.h)) {
      this.gYz.a((com.tencent.mm.kernel.api.h)paramObject);
    }
    if ((paramObject instanceof ac)) {
      this.gYH.add((ac)paramObject);
    }
    GMTrace.o(18788737089536L, 139987);
  }
  
  public final void b(com.tencent.mm.kernel.api.h paramh)
  {
    GMTrace.i(13513175072768L, 100681);
    this.gYz.b(paramh);
    GMTrace.o(13513175072768L, 100681);
  }
  
  public final void eh(String paramString)
  {
    GMTrace.i(13515322556416L, 100697);
    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", new Object[] { o.getString(a.uH()), paramString, bf.bJP() });
    a.eb(bf.bJP().toString() + paramString);
    this.gYD.gWS.T(a.uH());
    releaseAll();
    a.uL();
    a.aQ(false);
    GMTrace.o(13515322556416L, 100697);
  }
  
  public final void releaseAll()
  {
    GMTrace.i(13515456774144L, 100698);
    if (this.gYD != null) {}
    for (String str = o.getString(a.uH());; str = "-1")
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MMKernel", "release uin:%s ", new Object[] { str });
      if (this.gYE.gXs != null) {
        this.gYE.gXs.reset();
      }
      if (this.gYA != null) {
        this.gYA.a(new ae.b()
        {
          public final void vM()
          {
            GMTrace.i(18786455388160L, 139970);
            if (h.this.gYD != null) {
              h.this.gYD.release();
            }
            GMTrace.o(18786455388160L, 139970);
          }
        });
      }
      GMTrace.o(13515456774144L, 100698);
      return;
    }
  }
  
  private static final class a
    extends com.tencent.mm.bn.a<com.tencent.mm.kernel.api.c>
    implements com.tencent.mm.kernel.api.c
  {
    public a()
    {
      GMTrace.i(13498411122688L, 100571);
      GMTrace.o(13498411122688L, 100571);
    }
    
    public final void onAccountInitialized(final e.f paramf)
    {
      GMTrace.i(13498545340416L, 100572);
      a(new a.a() {});
      GMTrace.o(13498545340416L, 100572);
    }
    
    public final void onAccountRelease()
    {
      GMTrace.i(13498679558144L, 100573);
      a(new a.a() {});
      GMTrace.o(13498679558144L, 100573);
    }
  }
  
  private static final class b
    extends com.tencent.mm.bn.a<n.a>
    implements n.a
  {
    public b()
    {
      GMTrace.i(13489686970368L, 100506);
      GMTrace.o(13489686970368L, 100506);
    }
    
    public final void a(final n paramn)
    {
      GMTrace.i(13489955405824L, 100508);
      a(new a.a() {});
      GMTrace.o(13489955405824L, 100508);
    }
    
    public final void a(final n paramn, final boolean paramBoolean)
    {
      GMTrace.i(13489821188096L, 100507);
      a(new a.a() {});
      GMTrace.o(13489821188096L, 100507);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kernel/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */