package com.tencent.mm.vending.g;

import android.os.Looper;
import android.util.Pair;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.vending.h.f.a;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vending.j.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import junit.framework.Assert;

public class e<_Var>
  implements c<_Var>
{
  public int aMo;
  private volatile boolean wAE;
  public volatile d wAF;
  public boolean wAG;
  private Queue<a> wAH;
  private volatile com.tencent.mm.vending.h.d wAI;
  private volatile com.tencent.mm.vending.h.d wAJ;
  public volatile Object wAK;
  public volatile boolean wAL;
  public volatile Object wAM;
  public a wAN;
  public a wAO;
  private long wAP;
  private boolean wAQ;
  private b wAR;
  private com.tencent.mm.vending.h.d wAS;
  private f.a wAT;
  public List<Pair<d.a, com.tencent.mm.vending.h.d>> wAU;
  private List<Pair<d.b, com.tencent.mm.vending.h.d>> wAV;
  private boolean wAW;
  public boolean wAX;
  public boolean wAY;
  private Object wAZ;
  com.tencent.mm.vending.h.f wAr;
  public Object wBa;
  
  public e()
  {
    GMTrace.i(284407365632L, 2119);
    this.wAE = false;
    this.wAF = d.wBk;
    this.wAG = false;
    this.wAH = new LinkedList();
    this.aMo = 0;
    this.wAP = -1L;
    this.wAQ = false;
    this.wAR = new b();
    this.wAT = new f.a()
    {
      public final void bM(Object paramAnonymousObject)
      {
        GMTrace.i(281991446528L, 2101);
        ((Stack)f.cby().wBs.get()).pop();
        synchronized (e.this)
        {
          e.this.wAN = e.this.wAO;
          e.this.wAO = null;
          if (!e.this.wAG)
          {
            e.this.wAK = paramAnonymousObject;
            if (e.this.wAF == e.d.wBo)
            {
              com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
              GMTrace.o(281991446528L, 2101);
            }
          }
          else
          {
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
          }
        }
        if (e.this.wAF == e.d.wBn)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
          GMTrace.o(281991446528L, 2101);
          return;
        }
        e.this.wAF = e.d.wBl;
        e.this.bL(e.this.bK(paramAnonymousObject));
        GMTrace.o(281991446528L, 2101);
      }
      
      public final void cbw()
      {
        GMTrace.i(281857228800L, 2100);
        f localf = f.cby();
        e locale = e.this;
        Stack localStack2 = (Stack)localf.wBs.get();
        Stack localStack1 = localStack2;
        if (localStack2 == null)
        {
          localStack1 = new Stack();
          localf.wBs.set(localStack1);
        }
        localStack1.push(locale);
        GMTrace.o(281857228800L, 2100);
      }
      
      public final void interrupt()
      {
        GMTrace.i(282125664256L, 2102);
        e.this.lT(true);
        GMTrace.o(282125664256L, 2102);
      }
    };
    this.wAW = false;
    this.wAX = false;
    this.wAY = false;
    this.wAJ = com.tencent.mm.vending.h.g.cbB();
    this.wAI = this.wAJ;
    this.wAr = new com.tencent.mm.vending.h.f(this.wAJ, this.wAT);
    GMTrace.o(284407365632L, 2119);
  }
  
  /* Error */
  private <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 140
    //   5: sipush 2130
    //   8: invokestatic 81	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: invokespecial 144	com/tencent/mm/vending/g/e:cbs	()V
    //   15: aload_0
    //   16: getfield 95	com/tencent/mm/vending/g/e:wAH	Ljava/util/Queue;
    //   19: new 19	com/tencent/mm/vending/g/e$a
    //   22: dup
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 127	com/tencent/mm/vending/g/e:wAI	Lcom/tencent/mm/vending/h/d;
    //   28: aload_0
    //   29: getfield 101	com/tencent/mm/vending/g/e:wAP	J
    //   32: iload_2
    //   33: invokespecial 147	com/tencent/mm/vending/g/e$a:<init>	(Lcom/tencent/mm/vending/c/a;Lcom/tencent/mm/vending/h/d;JZ)V
    //   36: invokeinterface 153 2 0
    //   41: pop
    //   42: aload_0
    //   43: ldc2_w 98
    //   46: putfield 101	com/tencent/mm/vending/g/e:wAP	J
    //   49: aload_0
    //   50: getfield 88	com/tencent/mm/vending/g/e:wAF	Lcom/tencent/mm/vending/g/e$d;
    //   53: getstatic 86	com/tencent/mm/vending/g/e$d:wBk	Lcom/tencent/mm/vending/g/e$d;
    //   56: if_acmpne +16 -> 72
    //   59: ldc2_w 140
    //   62: sipush 2130
    //   65: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_0
    //   71: areturn
    //   72: aload_0
    //   73: getfield 88	com/tencent/mm/vending/g/e:wAF	Lcom/tencent/mm/vending/g/e$d;
    //   76: getstatic 156	com/tencent/mm/vending/g/e$d:wBl	Lcom/tencent/mm/vending/g/e$d;
    //   79: if_acmpeq +15 -> 94
    //   82: ldc2_w 140
    //   85: sipush 2130
    //   88: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   91: goto -23 -> 68
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 158	com/tencent/mm/vending/g/e:wAK	Ljava/lang/Object;
    //   99: invokevirtual 162	com/tencent/mm/vending/g/e:bL	(Ljava/lang/Object;)V
    //   102: ldc2_w 140
    //   105: sipush 2130
    //   108: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   111: goto -43 -> 68
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	e
    //   0	119	1	parama	com.tencent.mm.vending.c.a<_Ret, _Var>
    //   0	119	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	68	114	finally
    //   72	91	114	finally
    //   94	111	114	finally
  }
  
  /* Error */
  private void a(d.a parama, com.tencent.mm.vending.h.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 166
    //   5: sipush 2135
    //   8: invokestatic 81	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: invokespecial 171	com/tencent/mm/vending/g/e:cbt	()Lcom/tencent/mm/vending/g/d;
    //   15: pop
    //   16: aload_0
    //   17: getfield 173	com/tencent/mm/vending/g/e:wAU	Ljava/util/List;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: new 92	java/util/LinkedList
    //   27: dup
    //   28: invokespecial 93	java/util/LinkedList:<init>	()V
    //   31: putfield 173	com/tencent/mm/vending/g/e:wAU	Ljava/util/List;
    //   34: new 175	android/util/Pair
    //   37: dup
    //   38: aload_1
    //   39: aload_2
    //   40: invokespecial 178	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   43: astore_1
    //   44: aload_0
    //   45: getfield 115	com/tencent/mm/vending/g/e:wAX	Z
    //   48: ifeq +24 -> 72
    //   51: aload_0
    //   52: aload_1
    //   53: aload_0
    //   54: getfield 180	com/tencent/mm/vending/g/e:wBa	Ljava/lang/Object;
    //   57: invokevirtual 183	com/tencent/mm/vending/g/e:a	(Landroid/util/Pair;Ljava/lang/Object;)V
    //   60: ldc2_w 166
    //   63: sipush 2135
    //   66: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_0
    //   73: getfield 173	com/tencent/mm/vending/g/e:wAU	Ljava/util/List;
    //   76: aload_1
    //   77: invokeinterface 186 2 0
    //   82: pop
    //   83: ldc2_w 166
    //   86: sipush 2135
    //   89: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   92: goto -23 -> 69
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	e
    //   0	100	1	parama	d.a
    //   0	100	2	paramd	com.tencent.mm.vending.h.d
    // Exception table:
    //   from	to	target	type
    //   2	34	95	finally
    //   34	69	95	finally
    //   72	92	95	finally
  }
  
  /* Error */
  private void a(d.b paramb, com.tencent.mm.vending.h.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 188
    //   5: sipush 2136
    //   8: invokestatic 81	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: invokespecial 171	com/tencent/mm/vending/g/e:cbt	()Lcom/tencent/mm/vending/g/d;
    //   15: pop
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 158	com/tencent/mm/vending/g/e:wAK	Ljava/lang/Object;
    //   21: invokevirtual 162	com/tencent/mm/vending/g/e:bL	(Ljava/lang/Object;)V
    //   24: aload_0
    //   25: getfield 191	com/tencent/mm/vending/g/e:wAV	Ljava/util/List;
    //   28: ifnonnull +14 -> 42
    //   31: aload_0
    //   32: new 92	java/util/LinkedList
    //   35: dup
    //   36: invokespecial 93	java/util/LinkedList:<init>	()V
    //   39: putfield 191	com/tencent/mm/vending/g/e:wAV	Ljava/util/List;
    //   42: new 175	android/util/Pair
    //   45: dup
    //   46: aload_1
    //   47: aload_2
    //   48: invokespecial 178	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   51: astore_1
    //   52: aload_0
    //   53: getfield 113	com/tencent/mm/vending/g/e:wAW	Z
    //   56: ifeq +24 -> 80
    //   59: aload_0
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 193	com/tencent/mm/vending/g/e:wAZ	Ljava/lang/Object;
    //   65: invokespecial 195	com/tencent/mm/vending/g/e:b	(Landroid/util/Pair;Ljava/lang/Object;)V
    //   68: ldc2_w 188
    //   71: sipush 2136
    //   74: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_0
    //   81: getfield 191	com/tencent/mm/vending/g/e:wAV	Ljava/util/List;
    //   84: aload_1
    //   85: invokeinterface 186 2 0
    //   90: pop
    //   91: ldc2_w 188
    //   94: sipush 2136
    //   97: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   100: goto -23 -> 77
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	e
    //   0	108	1	paramb	d.b
    //   0	108	2	paramd	com.tencent.mm.vending.h.d
    // Exception table:
    //   from	to	target	type
    //   2	42	103	finally
    //   42	77	103	finally
    //   80	100	103	finally
  }
  
  private void b(final Pair<d.b, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    try
    {
      GMTrace.i(286420631552L, 2134);
      final RuntimeException localRuntimeException = new RuntimeException("object is not right: " + paramObject);
      new com.tencent.mm.vending.h.f((com.tencent.mm.vending.h.d)paramPair.second, null).a(new com.tencent.mm.vending.c.a()
      {
        private Void cbx()
        {
          GMTrace.i(18925639172096L, 141007);
          try
          {
            ((d.b)paramPair.first).ar(paramObject);
            Void localVoid = wAy;
            GMTrace.o(18925639172096L, 141007);
            return localVoid;
          }
          catch (ClassCastException localClassCastException)
          {
            if (localRuntimeException.getCause() == null) {
              localRuntimeException.initCause(localClassCastException);
            }
            throw localRuntimeException;
          }
        }
      }, null, this.wAQ);
      GMTrace.o(286420631552L, 2134);
      return;
    }
    finally
    {
      paramPair = finally;
      throw paramPair;
    }
  }
  
  private void cbs()
  {
    try
    {
      GMTrace.i(286152196096L, 2132);
      if (this.wAE) {
        throw new c("This Pipeline(%s) has terminate and do not allow any next().", new Object[] { this });
      }
    }
    finally {}
    GMTrace.o(286152196096L, 2132);
  }
  
  private d<_Var> cbt()
  {
    try
    {
      GMTrace.i(286823284736L, 2137);
      this.wAE = true;
      GMTrace.o(286823284736L, 2137);
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public c<_Var> Ux(String paramString)
  {
    GMTrace.i(284541583360L, 2120);
    if (paramString == null)
    {
      Assert.assertNotNull("schedulerTypeString should not be null!", paramString);
      GMTrace.o(284541583360L, 2120);
      return this;
    }
    this.wAI = com.tencent.mm.vending.h.g.Uz(paramString);
    Assert.assertNotNull("mCurrentScheduler should not be null!", this.wAI);
    GMTrace.o(284541583360L, 2120);
    return this;
  }
  
  public <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    try
    {
      GMTrace.i(286017978368L, 2131);
      parama = a(parama, this.wAQ);
      GMTrace.o(286017978368L, 2131);
      return parama;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public c<_Var> a(final c.a<_Var> parama)
  {
    try
    {
      GMTrace.i(285078454272L, 2124);
      t(new Object[0]);
      a(new com.tencent.mm.vending.c.a()
      {
        public final _Var call(_Var paramAnonymous_Var)
        {
          GMTrace.i(282394099712L, 2104);
          paramAnonymous_Var = parama.call();
          GMTrace.o(282394099712L, 2104);
          return paramAnonymous_Var;
        }
      }, true);
      GMTrace.o(285078454272L, 2124);
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public c<_Var> a(com.tencent.mm.vending.h.d paramd)
  {
    GMTrace.i(284675801088L, 2121);
    if (paramd == null)
    {
      Assert.assertNotNull("scheduler should not be null!", paramd);
      GMTrace.o(284675801088L, 2121);
      return this;
    }
    this.wAI = paramd;
    GMTrace.o(284675801088L, 2121);
    return this;
  }
  
  public final d<_Var> a(d.a parama)
  {
    try
    {
      GMTrace.i(286957502464L, 2138);
      a(parama, this.wAJ);
      GMTrace.o(286957502464L, 2138);
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final d<_Var> a(d.b<_Var> paramb)
  {
    try
    {
      GMTrace.i(287091720192L, 2139);
      a(paramb, this.wAJ);
      GMTrace.o(287091720192L, 2139);
      return this;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public final d<_Var> a(com.tencent.mm.vending.h.d paramd, d.b<_Var> paramb)
  {
    try
    {
      GMTrace.i(287225937920L, 2140);
      a(paramb, paramd);
      GMTrace.o(287225937920L, 2140);
      return this;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void a(final Pair<d.a, com.tencent.mm.vending.h.d> paramPair, final Object paramObject)
  {
    try
    {
      GMTrace.i(286286413824L, 2133);
      com.tencent.mm.vending.h.d locald = (com.tencent.mm.vending.h.d)paramPair.second;
      paramPair = new Runnable()
      {
        public final void run()
        {
          GMTrace.i(282662535168L, 2106);
          ((d.a)paramPair.first).aD(paramObject);
          GMTrace.o(282662535168L, 2106);
        }
      };
      if (locald == null) {
        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", new Object[] { this.wAJ });
      }
      locald.ab(paramPair);
      GMTrace.o(286286413824L, 2133);
      return;
    }
    finally {}
  }
  
  public <_Ret> c<_Ret> b(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    GMTrace.i(285749542912L, 2129);
    parama = Ux("Vending.LOGIC").a(parama);
    GMTrace.o(285749542912L, 2129);
    return parama;
  }
  
  public c<_Var> b(com.tencent.mm.vending.e.b paramb)
  {
    GMTrace.i(284810018816L, 2122);
    Assert.assertNotNull("keeper should not be null!", paramb);
    paramb.a(this);
    GMTrace.o(284810018816L, 2122);
    return this;
  }
  
  public final Object bK(Object paramObject)
  {
    for (;;)
    {
      try
      {
        GMTrace.i(287494373376L, 2142);
        if (this.wAG)
        {
          this.aMo += 1;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", new Object[] { this.wAN.wBi.toString(), Integer.valueOf(this.aMo) });
          ((LinkedList)this.wAH).add(0, this.wAN);
          this.wAG = false;
          paramObject = this.wAK;
          GMTrace.o(287494373376L, 2142);
          return paramObject;
        }
        if (this.wAL)
        {
          this.wAK = this.wAM;
          this.wAM = null;
          this.wAL = false;
          this.aMo = 0;
        }
        else
        {
          this.wAK = paramObject;
        }
      }
      finally {}
    }
  }
  
  public final void bL(final Object paramObject)
  {
    label146:
    label153:
    label165:
    final com.tencent.mm.vending.c.a locala1;
    long l;
    final boolean bool;
    for (;;)
    {
      a locala;
      try
      {
        GMTrace.i(287628591104L, 2143);
        if (this.wAF != d.wBl)
        {
          GMTrace.o(287628591104L, 2143);
          return;
        }
        this.wAF = d.wBm;
        locala = (a)this.wAH.peek();
        if (locala != null) {
          break label165;
        }
        if (!this.wAE) {
          break label146;
        }
        this.wAF = d.wBp;
        this.wAW = true;
        this.wAZ = paramObject;
        if (this.wAV == null) {
          break label153;
        }
        paramObject = this.wAV.iterator();
        if (((Iterator)paramObject).hasNext())
        {
          b((Pair)((Iterator)paramObject).next(), this.wAZ);
          continue;
        }
        GMTrace.o(287628591104L, 2143);
      }
      finally {}
      continue;
      this.wAF = d.wBl;
      GMTrace.o(287628591104L, 2143);
      continue;
      locala1 = locala.wBi;
      com.tencent.mm.vending.h.d locald = locala.fwq;
      l = locala.jdQ;
      bool = locala.wBj;
      if (this.wAF == d.wBn)
      {
        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
        GMTrace.o(287628591104L, 2143);
      }
      else
      {
        this.wAO = ((a)this.wAH.poll());
        this.wAr.b(locald);
        if (l >= 0L) {
          break;
        }
        this.wAr.a(locala1, paramObject, bool);
        GMTrace.o(287628591104L, 2143);
      }
    }
    if (Looper.myLooper() == null) {}
    for (this.wAS = new com.tencent.mm.vending.h.c();; this.wAS = new h(Looper.myLooper(), Looper.myLooper().toString()))
    {
      this.wAS.h(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(283199406080L, 2110);
          e.this.wAr.a(locala1, paramObject, bool);
          GMTrace.o(283199406080L, 2110);
        }
      }, l);
      GMTrace.o(287628591104L, 2143);
      break;
    }
  }
  
  public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    GMTrace.i(17854447484928L, 133026);
    parama = Ux("Vending.HEAVY_WORK").a(parama);
    GMTrace.o(17854447484928L, 133026);
    return parama;
  }
  
  public final b cbr()
  {
    GMTrace.i(285481107456L, 2127);
    b localb = this.wAR;
    GMTrace.o(285481107456L, 2127);
    return localb;
  }
  
  public final boolean cbu()
  {
    GMTrace.i(18926176043008L, 141011);
    if (this.wAO != null)
    {
      GMTrace.o(18926176043008L, 141011);
      return true;
    }
    GMTrace.o(18926176043008L, 141011);
    return false;
  }
  
  public final boolean cbv()
  {
    GMTrace.i(18926310260736L, 141012);
    if (this.wAR == g.cbr())
    {
      GMTrace.o(18926310260736L, 141012);
      return true;
    }
    GMTrace.o(18926310260736L, 141012);
    return false;
  }
  
  public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> parama)
  {
    GMTrace.i(285615325184L, 2128);
    parama = Ux("Vending.UI").a(parama);
    GMTrace.o(285615325184L, 2128);
    return parama;
  }
  
  public void dead()
  {
    GMTrace.i(285346889728L, 2126);
    lT(true);
    GMTrace.o(285346889728L, 2126);
  }
  
  public c<_Var> lS(boolean paramBoolean)
  {
    GMTrace.i(284944236544L, 2123);
    this.wAQ = paramBoolean;
    GMTrace.o(284944236544L, 2123);
    return this;
  }
  
  /* Error */
  public final void lT(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 471
    //   5: sipush 2141
    //   8: invokestatic 81	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: getfield 88	com/tencent/mm/vending/g/e:wAF	Lcom/tencent/mm/vending/g/e$d;
    //   15: getstatic 475	com/tencent/mm/vending/g/e$d:wBo	Lcom/tencent/mm/vending/g/e$d;
    //   18: if_acmpeq +13 -> 31
    //   21: aload_0
    //   22: getfield 88	com/tencent/mm/vending/g/e:wAF	Lcom/tencent/mm/vending/g/e$d;
    //   25: getstatic 374	com/tencent/mm/vending/g/e$d:wBp	Lcom/tencent/mm/vending/g/e$d;
    //   28: if_acmpne +15 -> 43
    //   31: ldc2_w 471
    //   34: sipush 2141
    //   37: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: iload_1
    //   44: ifeq +43 -> 87
    //   47: aload_0
    //   48: getfield 95	com/tencent/mm/vending/g/e:wAH	Ljava/util/Queue;
    //   51: invokeinterface 479 1 0
    //   56: ifle +31 -> 87
    //   59: ldc_w 302
    //   62: ldc_w 481
    //   65: iconst_1
    //   66: anewarray 5	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_0
    //   72: getfield 95	com/tencent/mm/vending/g/e:wAH	Ljava/util/Queue;
    //   75: invokeinterface 479 1 0
    //   80: invokestatic 353	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aastore
    //   84: invokestatic 484	com/tencent/mm/vending/f/a:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload_0
    //   88: getstatic 475	com/tencent/mm/vending/g/e$d:wBo	Lcom/tencent/mm/vending/g/e$d;
    //   91: putfield 88	com/tencent/mm/vending/g/e:wAF	Lcom/tencent/mm/vending/g/e$d;
    //   94: aload_0
    //   95: getfield 95	com/tencent/mm/vending/g/e:wAH	Ljava/util/Queue;
    //   98: invokeinterface 487 1 0
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 158	com/tencent/mm/vending/g/e:wAK	Ljava/lang/Object;
    //   108: aload_0
    //   109: getfield 420	com/tencent/mm/vending/g/e:wAS	Lcom/tencent/mm/vending/h/d;
    //   112: ifnull +10 -> 122
    //   115: aload_0
    //   116: getfield 420	com/tencent/mm/vending/g/e:wAS	Lcom/tencent/mm/vending/h/d;
    //   119: invokevirtual 490	com/tencent/mm/vending/h/d:cancel	()V
    //   122: ldc2_w 471
    //   125: sipush 2141
    //   128: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   131: goto -91 -> 40
    //   134: astore_2
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_2
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	e
    //   0	139	1	paramBoolean	boolean
    //   134	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	134	finally
    //   31	40	134	finally
    //   47	87	134	finally
    //   87	122	134	finally
    //   122	131	134	finally
  }
  
  /* Error */
  public c<_Var> t(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 491
    //   5: sipush 2125
    //   8: invokestatic 81	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: getfield 88	com/tencent/mm/vending/g/e:wAF	Lcom/tencent/mm/vending/g/e$d;
    //   15: getstatic 86	com/tencent/mm/vending/g/e$d:wBk	Lcom/tencent/mm/vending/g/e$d;
    //   18: if_acmpeq +16 -> 34
    //   21: ldc2_w 491
    //   24: sipush 2125
    //   27: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: aload_0
    //   35: getstatic 156	com/tencent/mm/vending/g/e$d:wBl	Lcom/tencent/mm/vending/g/e$d;
    //   38: putfield 88	com/tencent/mm/vending/g/e:wAF	Lcom/tencent/mm/vending/g/e$d;
    //   41: aload_1
    //   42: arraylength
    //   43: ifne +30 -> 73
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_0
    //   49: aload_1
    //   50: putfield 158	com/tencent/mm/vending/g/e:wAK	Ljava/lang/Object;
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 158	com/tencent/mm/vending/g/e:wAK	Ljava/lang/Object;
    //   58: invokevirtual 162	com/tencent/mm/vending/g/e:bL	(Ljava/lang/Object;)V
    //   61: ldc2_w 491
    //   64: sipush 2125
    //   67: invokestatic 137	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   70: goto -40 -> 30
    //   73: aload_1
    //   74: arraylength
    //   75: iconst_1
    //   76: if_icmpne +10 -> 86
    //   79: aload_1
    //   80: iconst_0
    //   81: aaload
    //   82: astore_1
    //   83: goto -35 -> 48
    //   86: aload_1
    //   87: invokestatic 498	com/tencent/mm/vending/j/k:u	([Ljava/lang/Object;)Lcom/tencent/mm/vending/j/k;
    //   90: astore_1
    //   91: goto -43 -> 48
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	e
    //   0	99	1	paramVarArgs	Object[]
    // Exception table:
    //   from	to	target	type
    //   2	30	94	finally
    //   34	46	94	finally
    //   48	70	94	finally
    //   73	79	94	finally
    //   86	91	94	finally
  }
  
  private static final class a
  {
    public com.tencent.mm.vending.h.d fwq;
    public long jdQ;
    public com.tencent.mm.vending.c.a wBi;
    public boolean wBj;
    
    public a(com.tencent.mm.vending.c.a parama, com.tencent.mm.vending.h.d paramd, long paramLong, boolean paramBoolean)
    {
      GMTrace.i(283333623808L, 2111);
      this.wBi = parama;
      this.fwq = paramd;
      this.jdQ = paramLong;
      this.wBj = paramBoolean;
      GMTrace.o(283333623808L, 2111);
    }
  }
  
  final class b
    implements b
  {
    b()
    {
      GMTrace.i(283467841536L, 2112);
      GMTrace.o(283467841536L, 2112);
    }
    
    public final void bJ(Object paramObject)
    {
      GMTrace.i(283602059264L, 2113);
      synchronized (e.this)
      {
        if (e.this.wAF == e.d.wBo)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
          GMTrace.o(283602059264L, 2113);
          return;
        }
        if ((!e.this.cbu()) && (e.this.wAF != e.d.wBn))
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
          GMTrace.o(283602059264L, 2113);
          return;
        }
        com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupt Pipeline(%s)", new Object[] { e.this });
        e.this.lT(false);
        e.this.wAX = true;
        e.this.wBa = paramObject;
        if (e.this.wAU != null)
        {
          Iterator localIterator = e.this.wAU.iterator();
          if (localIterator.hasNext())
          {
            Pair localPair = (Pair)localIterator.next();
            e.this.a(localPair, paramObject);
          }
        }
      }
      GMTrace.o(283602059264L, 2113);
    }
    
    public final void cbq()
    {
      GMTrace.i(283736276992L, 2114);
      for (;;)
      {
        synchronized (e.this)
        {
          synchronized (e.this)
          {
            if ((e.this.wAF == e.d.wBo) || (e.this.wAF == e.d.wBk))
            {
              com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", new Object[] { e.this.wAF });
              GMTrace.o(283736276992L, 2114);
              return;
            }
            if (!e.this.cbu()) {
              com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", new Object[] { e.this });
            }
          }
        }
        if (!e.this.cbv()) {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", new Object[] { e.this });
        } else {
          e.this.wAF = e.d.wBn;
        }
      }
    }
    
    public final void resume()
    {
      GMTrace.i(284004712448L, 2116);
      synchronized (e.this)
      {
        if (e.this.wAF != e.d.wBn)
        {
          com.tencent.mm.vending.f.a.e("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", new Object[] { e.this });
          GMTrace.o(284004712448L, 2116);
          return;
        }
        if (!e.this.cbu())
        {
          e.this.wAF = e.d.wBl;
          if (!e.this.cbv()) {
            e.this.bL(e.this.bK(e.this.wAK));
          }
          GMTrace.o(284004712448L, 2116);
          return;
        }
        e.this.wAF = e.d.wBm;
      }
    }
    
    public final void s(Object... paramVarArgs)
    {
      GMTrace.i(283870494720L, 2115);
      synchronized (e.this)
      {
        if (e.this.wAF != e.d.wBn)
        {
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", new Object[] { e.this.wAF });
          GMTrace.o(283870494720L, 2115);
          return;
        }
        e locale2 = e.this;
        if (paramVarArgs.length == 0) {}
        for (paramVarArgs = null;; paramVarArgs = paramVarArgs[0])
        {
          locale2.wAM = paramVarArgs;
          e.this.wAL = true;
          com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", new Object[] { e.this });
          resume();
          GMTrace.o(283870494720L, 2115);
          return;
          if (paramVarArgs.length != 1) {
            break;
          }
        }
        paramVarArgs = k.u(paramVarArgs);
      }
    }
  }
  
  public static final class c
    extends Error
  {
    public c(String paramString, Object... paramVarArgs)
    {
      super();
      GMTrace.i(284138930176L, 2117);
      GMTrace.o(284138930176L, 2117);
    }
  }
  
  private static enum d
  {
    static
    {
      GMTrace.i(284273147904L, 2118);
      wBk = new d("Idle", 0);
      wBl = new d("Resolved", 1);
      wBm = new d("Invoking", 2);
      wBn = new d("Pausing", 3);
      wBo = new d("Interrupted", 4);
      wBp = new d("AllDone", 5);
      wBq = new d[] { wBk, wBl, wBm, wBn, wBo, wBp };
      GMTrace.o(284273147904L, 2118);
    }
    
    private d()
    {
      GMTrace.i(18926041825280L, 141010);
      GMTrace.o(18926041825280L, 141010);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/vending/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */