package com.tencent.mm.sdk.b;

import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.g.g;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a
{
  public static a uql;
  private final HashMap<Integer, LinkedList<c>> uqm;
  private final HashMap<Integer, a> uqn;
  
  static
  {
    GMTrace.i(13956227792896L, 103982);
    uql = new a();
    GMTrace.o(13956227792896L, 103982);
  }
  
  private a()
  {
    GMTrace.i(13955019833344L, 103973);
    this.uqm = new HashMap();
    this.uqn = new HashMap();
    GMTrace.o(13955019833344L, 103973);
  }
  
  private void a(LinkedList<c> paramLinkedList, b paramb)
  {
    GMTrace.i(13956093575168L, 103981);
    if (paramb.uqr) {
      Collections.sort(paramLinkedList, new Comparator() {});
    }
    c[] arrayOfc = new c[paramLinkedList.size()];
    paramLinkedList.toArray(arrayOfc);
    int j = arrayOfc.length;
    int i = 0;
    while ((i < j) && ((!arrayOfc[i].a(paramb)) || (!paramb.uqr))) {
      i += 1;
    }
    if (paramb.nDP != null) {
      paramb.nDP.run();
    }
    GMTrace.o(13956093575168L, 103981);
  }
  
  public final com.tencent.mm.vending.b.b<c> a(c paramc)
  {
    GMTrace.i(13955154051072L, 103974);
    try
    {
      Assert.assertNotNull("EventPoolImpl.add", paramc);
      v.v("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.bIn()) });
      Object localObject2 = (a)this.uqn.get(Integer.valueOf(paramc.bIn()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.uqn;
        int i = paramc.bIn();
        localObject1 = new a();
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      paramc = ((a)localObject1).a(new com.tencent.mm.vending.b.b(paramc, (com.tencent.mm.vending.b.a)localObject1));
      GMTrace.o(13955154051072L, 103974);
      return paramc;
    }
    finally {}
  }
  
  public final void a(final b paramb, Looper paramLooper)
  {
    GMTrace.i(13955690921984L, 103978);
    Assert.assertNotNull("EventPoolImpl.asyncPublish event", paramb);
    Assert.assertNotNull("EventPoolImpl.asyncPublish looper", paramLooper);
    v.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramb, Integer.valueOf(paramb.bIn()) });
    new ad(paramLooper).post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(13956496228352L, 103984);
        a.uql.m(paramb);
        GMTrace.o(13956496228352L, 103984);
      }
    });
    GMTrace.o(13955690921984L, 103978);
  }
  
  @Deprecated
  public final boolean b(c paramc)
  {
    GMTrace.i(13955288268800L, 103975);
    try
    {
      Assert.assertNotNull("EventPoolImpl.add", paramc);
      v.v("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.bIn()) });
      Object localObject2 = (LinkedList)this.uqm.get(Integer.valueOf(paramc.bIn()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.uqm;
        int i = paramc.bIn();
        localObject1 = new LinkedList();
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      if (((LinkedList)localObject1).contains(paramc))
      {
        GMTrace.o(13955288268800L, 103975);
        return true;
      }
      boolean bool = ((LinkedList)localObject1).add(paramc);
      GMTrace.o(13955288268800L, 103975);
      return bool;
    }
    finally {}
  }
  
  @Deprecated
  public final boolean c(c paramc)
  {
    boolean bool = false;
    GMTrace.i(13955422486528L, 103976);
    for (;;)
    {
      try
      {
        Assert.assertNotNull("EventPoolImpl.remove", paramc);
        v.v("MicroMsg.EventCenter", "removeListener %s(%d)", new Object[] { paramc, Integer.valueOf(paramc.bIn()) });
        Object localObject = (LinkedList)this.uqm.get(Integer.valueOf(paramc.bIn()));
        if (localObject != null) {
          bool = ((LinkedList)localObject).remove(paramc);
        }
        localObject = (a)this.uqn.get(Integer.valueOf(paramc.bIn()));
        if (localObject != null)
        {
          ((a)localObject).b(new com.tencent.mm.vending.b.b(paramc, (com.tencent.mm.vending.b.a)localObject));
          bool = true;
          GMTrace.o(13955422486528L, 103976);
          return bool;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final boolean d(c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 199
    //   5: ldc -55
    //   7: invokestatic 31	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   10: ldc -53
    //   12: aload_1
    //   13: invokestatic 108	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   16: aload_0
    //   17: getfield 49	com/tencent/mm/sdk/b/a:uqm	Ljava/util/HashMap;
    //   20: aload_1
    //   21: invokevirtual 115	com/tencent/mm/sdk/b/c:bIn	()I
    //   24: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokevirtual 131	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 72	java/util/LinkedList
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +32 -> 67
    //   38: aload_3
    //   39: invokevirtual 207	java/util/LinkedList:isEmpty	()Z
    //   42: ifne +25 -> 67
    //   45: aload_3
    //   46: aload_1
    //   47: invokevirtual 179	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   50: ifeq +17 -> 67
    //   53: ldc2_w 199
    //   56: ldc -55
    //   58: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   61: iconst_1
    //   62: istore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: iload_2
    //   66: ireturn
    //   67: aload_0
    //   68: getfield 51	com/tencent/mm/sdk/b/a:uqn	Ljava/util/HashMap;
    //   71: aload_1
    //   72: invokevirtual 115	com/tencent/mm/sdk/b/c:bIn	()I
    //   75: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: invokevirtual 131	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 10	com/tencent/mm/sdk/b/a$a
    //   84: astore_3
    //   85: aload_3
    //   86: ifnull +31 -> 117
    //   89: aload_3
    //   90: invokevirtual 208	com/tencent/mm/sdk/b/a$a:size	()I
    //   93: ifle +24 -> 117
    //   96: aload_3
    //   97: aload_1
    //   98: invokevirtual 209	com/tencent/mm/sdk/b/a$a:contains	(Ljava/lang/Object;)Z
    //   101: ifeq +16 -> 117
    //   104: ldc2_w 199
    //   107: ldc -55
    //   109: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   112: iconst_1
    //   113: istore_2
    //   114: goto -51 -> 63
    //   117: iconst_0
    //   118: istore_2
    //   119: ldc2_w 199
    //   122: ldc -55
    //   124: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   127: goto -64 -> 63
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	a
    //   0	135	1	paramc	c
    //   62	57	2	bool	boolean
    //   33	64	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	130	finally
    //   38	61	130	finally
    //   67	85	130	finally
    //   89	112	130	finally
    //   119	127	130	finally
  }
  
  public final boolean m(b paramb)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    GMTrace.i(13955556704256L, 103977);
    Assert.assertNotNull("EventPoolImpl.publish", paramb);
    v.v("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramb, Integer.valueOf(paramb.bIn()) });
    LinkedList localLinkedList = null;
    for (;;)
    {
      try
      {
        int i = paramb.bIn();
        Object localObject = (LinkedList)this.uqm.get(Integer.valueOf(i));
        if (localObject != null)
        {
          localLinkedList = new LinkedList((Collection)localObject);
          bool1 = true;
        }
        localObject = (a)this.uqn.get(Integer.valueOf(i));
        if (localObject != null)
        {
          bool1 = bool2;
          if (!bool1) {
            v.w("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", new Object[] { paramb, Integer.valueOf(i), "" });
          }
          if (localLinkedList != null) {
            a(localLinkedList, paramb);
          }
          if (localObject != null) {
            ((a)localObject).a(g.bO(paramb));
          }
          GMTrace.o(13955556704256L, 103977);
          return bool1;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final boolean s(Class<? extends b> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 239
    //   5: ldc -15
    //   7: invokestatic 31	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   10: ldc -13
    //   12: aload_1
    //   13: invokestatic 108	junit/framework/Assert:assertNotNull	(Ljava/lang/String;Ljava/lang/Object;)V
    //   16: aload_0
    //   17: getfield 49	com/tencent/mm/sdk/b/a:uqm	Ljava/util/HashMap;
    //   20: aload_1
    //   21: invokevirtual 249	java/lang/Class:getName	()Ljava/lang/String;
    //   24: invokevirtual 254	java/lang/String:hashCode	()I
    //   27: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: invokevirtual 131	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 72	java/util/LinkedList
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull +24 -> 62
    //   41: aload_3
    //   42: invokevirtual 76	java/util/LinkedList:size	()I
    //   45: ifle +17 -> 62
    //   48: ldc2_w 239
    //   51: ldc -15
    //   53: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   56: iconst_1
    //   57: istore_2
    //   58: aload_0
    //   59: monitorexit
    //   60: iload_2
    //   61: ireturn
    //   62: aload_0
    //   63: getfield 51	com/tencent/mm/sdk/b/a:uqn	Ljava/util/HashMap;
    //   66: aload_1
    //   67: invokevirtual 249	java/lang/Class:getName	()Ljava/lang/String;
    //   70: invokevirtual 254	java/lang/String:hashCode	()I
    //   73: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: invokevirtual 131	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 10	com/tencent/mm/sdk/b/a$a
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +23 -> 107
    //   87: aload_1
    //   88: invokevirtual 208	com/tencent/mm/sdk/b/a$a:size	()I
    //   91: ifle +16 -> 107
    //   94: ldc2_w 239
    //   97: ldc -15
    //   99: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   102: iconst_1
    //   103: istore_2
    //   104: goto -46 -> 58
    //   107: iconst_0
    //   108: istore_2
    //   109: ldc2_w 239
    //   112: ldc -15
    //   114: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   117: goto -59 -> 58
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	a
    //   0	125	1	paramClass	Class<? extends b>
    //   57	52	2	bool	boolean
    //   36	6	3	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	37	120	finally
    //   41	56	120	finally
    //   62	83	120	finally
    //   87	102	120	finally
    //   109	117	120	finally
  }
  
  private final class a
    extends com.tencent.mm.vending.b.a<c>
  {
    public a()
    {
      GMTrace.i(13958241058816L, 103997);
      GMTrace.o(13958241058816L, 103997);
    }
    
    public final void a(com.tencent.mm.vending.j.a parama)
    {
      GMTrace.i(13958375276544L, 103998);
      LinkedList localLinkedList = cbn();
      parama = (b)parama.get(0);
      if (parama.uqr) {
        Collections.sort(localLinkedList, new Comparator() {});
      }
      com.tencent.mm.vending.b.b[] arrayOfb = new com.tencent.mm.vending.b.b[localLinkedList.size()];
      localLinkedList.toArray(arrayOfb);
      int j = arrayOfb.length;
      int i = 0;
      while ((i < j) && ((!((c)arrayOfb[i].wAt).a(parama)) || (!parama.uqr))) {
        i += 1;
      }
      if (parama.nDP != null) {
        parama.nDP.run();
      }
      GMTrace.o(13958375276544L, 103998);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */