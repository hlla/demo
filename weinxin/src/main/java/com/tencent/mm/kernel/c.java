package com.tencent.mm.kernel;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.b;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import junit.framework.Assert;

public final class c
{
  private final HashMap<Class<? extends com.tencent.mm.kernel.b.a>, com.tencent.mm.kernel.b.d> gXC;
  public final ArrayList<com.tencent.mm.kernel.b.d> gXD;
  private final HashMap<Class<? extends com.tencent.mm.kernel.b.d>, ArrayList<Class<? extends com.tencent.mm.kernel.b.a>>> gXE;
  private final HashMap<Class<? extends com.tencent.mm.kernel.b.a>, Class<? extends com.tencent.mm.kernel.b.d>> gXF;
  public f<Class<? extends com.tencent.mm.kernel.b.d>> gXG;
  private HashMap<Class<? extends com.tencent.mm.kernel.c.a>, b> gXH;
  protected a gXI;
  public Class<? extends com.tencent.mm.kernel.b.a> gXJ;
  private HashMap<com.tencent.mm.kernel.b.c, ArrayList<Object>> gXK;
  
  public c()
  {
    GMTrace.i(13509416976384L, 100653);
    this.gXC = new HashMap();
    this.gXD = new ArrayList();
    this.gXE = new HashMap();
    this.gXF = new HashMap();
    this.gXG = new f();
    this.gXH = new HashMap();
    this.gXJ = null;
    this.gXK = new HashMap();
    GMTrace.o(13509416976384L, 100653);
  }
  
  private void a(com.tencent.mm.kernel.b.d paramd)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        GMTrace.i(13509819629568L, 100656);
        if (g(paramd.getClass()))
        {
          j.w("MMSkeleton.CorePlugins", "Plugin %s has been installed.", new Object[] { paramd.getClass() });
          GMTrace.o(13509819629568L, 100656);
          return;
        }
        Assert.assertNotNull(paramd);
        String[] arrayOfString = paramd.ofProcesses();
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          e locale = i.vN().vF().vj();
          int j = arrayOfString.length;
          int i = 0;
          boolean bool2 = bool1;
          if (i < j)
          {
            bool1 = locale.ej(arrayOfString[i]);
            bool2 = bool1;
            if (!bool1)
            {
              i += 1;
              continue;
            }
          }
          if (!bool2) {
            throw new IllegalStateException(String.format("Plugin %s can't install in process %s. It only support process %s.", new Object[] { paramd, locale.gWE, Arrays.asList(arrayOfString) }));
          }
        }
      }
      finally {}
      this.gXC.put(paramd.getClass(), paramd);
      this.gXD.add(paramd);
      paramd.invokeInstalled();
      if (this.gXI != null) {
        this.gXI.b(paramd);
      }
      GMTrace.o(13509819629568L, 100656);
    }
  }
  
  /* Error */
  private boolean k(Class<? extends com.tencent.mm.kernel.b.a> paramClass)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc2_w 168
    //   7: ldc -86
    //   9: invokestatic 42	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   12: aload_1
    //   13: invokestatic 99	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 83	com/tencent/mm/kernel/c:g	(Ljava/lang/Class;)Z
    //   21: ifne +45 -> 66
    //   24: ldc 85
    //   26: new 172	java/lang/StringBuilder
    //   29: dup
    //   30: ldc -82
    //   32: invokespecial 175	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: ldc -75
    //   41: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: iconst_0
    //   48: anewarray 4	java/lang/Object
    //   51: invokestatic 93	com/tencent/mm/kernel/j:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: ldc2_w 168
    //   57: ldc -86
    //   59: invokestatic 70	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   62: aload_0
    //   63: monitorexit
    //   64: iload_2
    //   65: ireturn
    //   66: iconst_1
    //   67: istore_2
    //   68: ldc2_w 168
    //   71: ldc -86
    //   73: invokestatic 70	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   76: goto -14 -> 62
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	c
    //   0	84	1	paramClass	Class<? extends com.tencent.mm.kernel.b.a>
    //   1	67	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	62	79	finally
    //   68	76	79	finally
  }
  
  public final void a(e parame)
  {
    Object localObject2;
    try
    {
      GMTrace.i(13510759153664L, 100663);
      localObject2 = new f(this.gXG);
      localObject1 = ((f)localObject2).vD();
      com.tencent.mm.kernel.a.a.a("configure chain ... %s", new Object[] { localObject1 });
      localObject2 = ((f)localObject2).vC();
      if (((ArrayList)localObject2).size() > 0) {
        throw new RuntimeException("Found cycle dependencies between plugins : " + localObject2);
      }
    }
    finally {}
    com.tencent.mm.kernel.a.a.a("configure check plugin cycle dependency ok...", new Object[0]);
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.kernel.b.d)j((Class)((Iterator)localObject1).next());
      if (((com.tencent.mm.kernel.b.d)localObject2).isConfigured())
      {
        com.tencent.mm.kernel.a.a.a("skip configure for plugin %s.", new Object[] { localObject2 });
      }
      else
      {
        com.tencent.mm.kernel.a.a.a("configuring plugin [%s]...", new Object[] { localObject2 });
        ((com.tencent.mm.kernel.b.d)localObject2).invokeConfigure(parame);
        if (this.gXK.containsKey(localObject2))
        {
          localObject2 = ((ArrayList)this.gXK.get(localObject2)).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Iterator)localObject2).next();
          }
        }
      }
    }
    GMTrace.o(13510759153664L, 100663);
  }
  
  public final <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> paramClass, b<N> paramb)
  {
    GMTrace.i(13510222282752L, 100659);
    this.gXH.put(paramClass, paramb);
    if (((paramb instanceof com.tencent.mm.kernel.c.c)) && (this.gXI != null)) {
      this.gXI.a(paramb.vP());
    }
    j.i("MMSkeleton.CorePlugins", "register service %s %s", new Object[] { paramClass, paramb });
    GMTrace.o(13510222282752L, 100659);
  }
  
  public final void c(Class<? extends com.tencent.mm.kernel.b.d> paramClass, Class<? extends com.tencent.mm.kernel.b.a> paramClass1)
  {
    try
    {
      GMTrace.i(13510088065024L, 100658);
      Assert.assertNotNull(paramClass);
      Assert.assertNotNull(paramClass1);
      com.tencent.mm.kernel.b.d locald = (com.tencent.mm.kernel.b.d)this.gXC.get(paramClass);
      Assert.assertNotNull(locald);
      ArrayList localArrayList2 = (ArrayList)this.gXE.get(paramClass);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.gXE.put(paramClass, localArrayList1);
      }
      this.gXF.put(paramClass1, paramClass);
      localArrayList1.add(paramClass1);
      this.gXC.put(paramClass1, locald);
      GMTrace.o(13510088065024L, 100658);
      return;
    }
    finally {}
  }
  
  public final void d(Class<? extends com.tencent.mm.kernel.b.d> paramClass, Class<? extends com.tencent.mm.kernel.b.a> paramClass1)
  {
    GMTrace.i(13510624935936L, 100662);
    Assert.assertNotNull(paramClass);
    Assert.assertNotNull(paramClass1);
    if (!k(paramClass1))
    {
      paramClass = String.format("depends plugin %s not install, plugin %s will not add in to dependency tree", new Object[] { paramClass1.getName(), paramClass.getName() });
      j.e("MMSkeleton.CorePlugins", paramClass, new Object[0]);
      throw new IllegalAccessError(paramClass);
    }
    if (this.gXF.containsKey(paramClass1)) {
      paramClass1 = (Class)this.gXF.get(paramClass1);
    }
    for (;;)
    {
      this.gXG.n(paramClass, paramClass1);
      i.vN().vF().vj().gZo.a(j(paramClass), j(paramClass1));
      GMTrace.o(13510624935936L, 100662);
      return;
    }
  }
  
  /* Error */
  public final void ee(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 317
    //   5: ldc_w 319
    //   8: invokestatic 42	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_1
    //   12: invokestatic 323	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   15: astore_2
    //   16: ldc 101
    //   18: aload_2
    //   19: invokevirtual 326	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   22: ifeq +20 -> 42
    //   25: aload_0
    //   26: aload_2
    //   27: invokevirtual 330	com/tencent/mm/kernel/c:f	(Ljava/lang/Class;)V
    //   30: ldc2_w 317
    //   33: ldc_w 319
    //   36: invokestatic 70	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: ldc 85
    //   44: ldc_w 332
    //   47: iconst_1
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: invokestatic 299	com/tencent/mm/kernel/j:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: ldc2_w 317
    //   61: ldc_w 319
    //   64: invokestatic 70	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   67: goto -28 -> 39
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    //   75: astore_2
    //   76: ldc 85
    //   78: ldc_w 334
    //   81: iconst_1
    //   82: anewarray 4	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_1
    //   88: aastore
    //   89: invokestatic 299	com/tencent/mm/kernel/j:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: invokestatic 111	com/tencent/mm/kernel/i:vN	()Lcom/tencent/mm/kernel/i;
    //   95: invokevirtual 115	com/tencent/mm/kernel/i:vF	()Lcom/tencent/mm/kernel/d;
    //   98: invokevirtual 121	com/tencent/mm/kernel/d:vj	()Lcom/tencent/mm/kernel/b/e;
    //   101: pop
    //   102: ldc2_w 317
    //   105: ldc_w 319
    //   108: invokestatic 70	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   111: goto -72 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	c
    //   0	114	1	paramString	String
    //   15	12	2	localClass	Class
    //   75	1	2	localClassNotFoundException	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   2	11	70	finally
    //   11	39	70	finally
    //   42	58	70	finally
    //   58	67	70	finally
    //   76	111	70	finally
    //   11	39	75	java/lang/ClassNotFoundException
    //   42	58	75	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public final void f(Class<? extends com.tencent.mm.kernel.b.d> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 339
    //   5: ldc_w 341
    //   8: invokestatic 42	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_1
    //   12: invokestatic 99	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 344	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   20: checkcast 101	com/tencent/mm/kernel/b/d
    //   23: invokespecial 346	com/tencent/mm/kernel/c:a	(Lcom/tencent/mm/kernel/b/d;)V
    //   26: ldc2_w 339
    //   29: ldc_w 341
    //   32: invokestatic 70	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_2
    //   39: ldc 85
    //   41: aload_2
    //   42: ldc_w 348
    //   45: iconst_0
    //   46: anewarray 4	java/lang/Object
    //   49: invokestatic 352	com/tencent/mm/kernel/j:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: ldc 85
    //   54: aload_2
    //   55: ldc_w 354
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: aastore
    //   66: invokestatic 352	com/tencent/mm/kernel/j:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: ldc2_w 339
    //   72: ldc_w 341
    //   75: invokestatic 70	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   78: goto -43 -> 35
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_2
    //   87: ldc 85
    //   89: aload_2
    //   90: ldc_w 348
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 352	com/tencent/mm/kernel/j:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: ldc 85
    //   102: aload_2
    //   103: ldc_w 354
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_1
    //   113: aastore
    //   114: invokestatic 352	com/tencent/mm/kernel/j:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: ldc2_w 339
    //   120: ldc_w 341
    //   123: invokestatic 70	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   126: goto -91 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	c
    //   0	129	1	paramClass	Class<? extends com.tencent.mm.kernel.b.d>
    //   38	17	2	localInstantiationException	InstantiationException
    //   86	17	2	localIllegalAccessException	IllegalAccessException
    // Exception table:
    //   from	to	target	type
    //   15	26	38	java/lang/InstantiationException
    //   2	15	81	finally
    //   15	26	81	finally
    //   26	35	81	finally
    //   39	78	81	finally
    //   87	126	81	finally
    //   15	26	86	java/lang/IllegalAccessException
  }
  
  public final boolean g(Class<? extends com.tencent.mm.kernel.b.a> paramClass)
  {
    try
    {
      GMTrace.i(13509953847296L, 100657);
      boolean bool = this.gXC.containsKey(paramClass);
      GMTrace.o(13509953847296L, 100657);
      return bool;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public final <T extends com.tencent.mm.kernel.c.a> T h(Class<T> paramClass)
  {
    GMTrace.i(18789945049088L, 139996);
    b localb = (b)this.gXH.get(paramClass);
    if ((!paramClass.isInterface()) && (Modifier.isAbstract(paramClass.getModifiers()))) {
      j.w("MMSkeleton.CorePlugins", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!", new Object[0]);
    }
    for (int i = 1;; i = 0)
    {
      if (localb != null)
      {
        paramClass = localb.vP();
        GMTrace.o(18789945049088L, 139996);
        return paramClass;
      }
      j.e("MMSkeleton.CorePlugins", "Service(%s) not found!!! ", new Object[] { paramClass });
      if (i != 0) {
        j.e("MMSkeleton.CorePlugins", "This error must cause by using implementation class to call service! Use interface instead! Understand?", new Object[0]);
      }
      i.vN().vF().vj();
      paramClass = (com.tencent.mm.kernel.c.a)g.l(paramClass);
      GMTrace.o(18789945049088L, 139996);
      return paramClass;
    }
  }
  
  public final void i(Class<? extends com.tencent.mm.kernel.c.a> paramClass)
  {
    GMTrace.i(14610539216896L, 108857);
    paramClass = (b)this.gXH.remove(paramClass);
    if (((paramClass instanceof com.tencent.mm.kernel.c.c)) && (this.gXI != null)) {
      this.gXI.b(paramClass.vP());
    }
    GMTrace.o(14610539216896L, 108857);
  }
  
  public final <T extends com.tencent.mm.kernel.b.a> T j(Class<T> paramClass)
  {
    try
    {
      GMTrace.i(18790079266816L, 139997);
      Assert.assertNotNull(paramClass);
      com.tencent.mm.kernel.b.a locala2 = (com.tencent.mm.kernel.b.a)this.gXC.get(paramClass);
      com.tencent.mm.kernel.b.a locala1 = locala2;
      if (locala2 == null) {
        locala1 = (com.tencent.mm.kernel.b.a)g.l(paramClass);
      }
      GMTrace.o(18790079266816L, 139997);
      return locala1;
    }
    finally {}
  }
  
  public final void vi()
  {
    for (;;)
    {
      com.tencent.mm.kernel.b.d locald;
      try
      {
        GMTrace.i(13510893371392L, 100664);
        Iterator localIterator = this.gXD.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locald = (com.tencent.mm.kernel.b.d)localIterator.next();
        if (!locald.isDependencyMade())
        {
          com.tencent.mm.kernel.a.a.a("make dependency for plugin %s...", new Object[] { locald });
          locald.invokeDependency();
          continue;
        }
      }
      finally {}
      tmp78_75[0] = locald;
      com.tencent.mm.kernel.a.a.a("skip make dependency for plugin %s.", tmp78_75);
    }
    GMTrace.o(13510893371392L, 100664);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.kernel.c.a parama);
    
    public abstract void b(com.tencent.mm.kernel.b.d paramd);
    
    public abstract void b(com.tencent.mm.kernel.c.a parama);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kernel/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */