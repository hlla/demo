package com.tencent.mm.memory;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable>
{
  protected NavigableMap<S, d<T, S>> hgs;
  private Vector<e<T, S>.a> hgt;
  protected long hgu;
  
  public e()
  {
    GMTrace.i(1289966583808L, 9611);
    this.hgs = new ConcurrentSkipListMap();
    this.hgt = new Vector();
    this.hgu = 0L;
    GMTrace.o(1289966583808L, 9611);
  }
  
  private void I(long paramLong)
  {
    try
    {
      GMTrace.i(1291577196544L, 9623);
      this.hgu += paramLong;
      GMTrace.o(1291577196544L, 9623);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected final void J(long paramLong)
  {
    try
    {
      GMTrace.i(1291711414272L, 9624);
      this.hgu -= paramLong;
      GMTrace.o(1291711414272L, 9624);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public T a(S paramS)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 54
    //   5: sipush 9614
    //   8: invokestatic 30	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: aload_0
    //   12: getfield 35	com/tencent/mm/memory/e:hgs	Ljava/util/NavigableMap;
    //   15: aload_1
    //   16: invokeinterface 61 2 0
    //   21: checkcast 63	com/tencent/mm/memory/d
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +52 -> 78
    //   29: aload_2
    //   30: invokevirtual 67	com/tencent/mm/memory/d:size	()I
    //   33: ifle +45 -> 78
    //   36: aload_2
    //   37: invokevirtual 71	com/tencent/mm/memory/d:pop	()Ljava/lang/Object;
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 35	com/tencent/mm/memory/e:hgs	Ljava/util/NavigableMap;
    //   45: aload_2
    //   46: invokevirtual 74	com/tencent/mm/memory/d:wm	()Ljava/lang/Object;
    //   49: aload_2
    //   50: invokeinterface 78 3 0
    //   55: pop
    //   56: aload_0
    //   57: aload_0
    //   58: aload_1
    //   59: invokevirtual 82	com/tencent/mm/memory/e:at	(Ljava/lang/Object;)J
    //   62: invokevirtual 84	com/tencent/mm/memory/e:J	(J)V
    //   65: ldc2_w 54
    //   68: sipush 9614
    //   71: invokestatic 45	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: areturn
    //   78: ldc 86
    //   80: ldc 88
    //   82: iconst_1
    //   83: anewarray 5	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_1
    //   89: aastore
    //   90: invokestatic 94	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aconst_null
    //   94: astore_1
    //   95: ldc2_w 54
    //   98: sipush 9614
    //   101: invokestatic 45	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   104: goto -30 -> 74
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	e
    //   0	112	1	paramS	S
    //   24	26	2	locald	d
    // Exception table:
    //   from	to	target	type
    //   2	25	107	finally
    //   29	74	107	finally
    //   78	93	107	finally
    //   95	104	107	finally
  }
  
  public final void a(e<T, S>.a parame)
  {
    GMTrace.i(1290100801536L, 9612);
    this.hgt.add(parame);
    v.i("MicroMsg.BucketPool", "%s addPreload: %s", new Object[] { this, parame });
    wn();
    GMTrace.o(1290100801536L, 9612);
  }
  
  public void as(T paramT)
  {
    for (;;)
    {
      Comparable localComparable;
      long l;
      try
      {
        GMTrace.i(1291174543360L, 9620);
        if (paramT == null)
        {
          GMTrace.o(1291174543360L, 9620);
          return;
        }
        localComparable = au(paramT);
        l = at(paramT);
        if (l > wk())
        {
          v.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", new Object[] { Long.valueOf(l) });
          GMTrace.o(1291174543360L, 9620);
          continue;
        }
        if (this.hgu + l <= wj()) {
          break label138;
        }
      }
      finally {}
      v.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", new Object[] { Long.valueOf(l), Long.valueOf(this.hgu) });
      GMTrace.o(1291174543360L, 9620);
      continue;
      label138:
      d locald2 = (d)this.hgs.get(localComparable);
      d locald1 = locald2;
      if (locald2 == null) {
        locald1 = c(localComparable);
      }
      locald1.put(paramT);
      this.hgs.put(localComparable, locald1);
      I(l);
      GMTrace.o(1291174543360L, 9620);
    }
  }
  
  public abstract long at(T paramT);
  
  public abstract S au(T paramT);
  
  public abstract S b(S paramS);
  
  public abstract d<T, S> c(S paramS);
  
  public abstract T d(S paramS);
  
  public abstract long wj();
  
  public abstract long wk();
  
  public void wl()
  {
    GMTrace.i(1291845632000L, 9625);
    v.i("MicroMsg.BucketPool", "freeAll: %s", new Object[] { getClass().getName() });
    this.hgs.clear();
    this.hgu = 0L;
    GMTrace.o(1291845632000L, 9625);
  }
  
  public final void wn()
  {
    GMTrace.i(1290235019264L, 9613);
    if (this.hgt.size() > 0) {
      com.tencent.mm.sdk.f.e.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1295066857472L, 9649);
          e.this.wo();
          GMTrace.o(1295066857472L, 9649);
        }
      }, "BucketPool_preload");
    }
    GMTrace.o(1290235019264L, 9613);
  }
  
  public final void wo()
  {
    GMTrace.i(16012443385856L, 119302);
    while (this.hgt.size() > 0)
    {
      long l2 = System.currentTimeMillis();
      a locala = (a)this.hgt.remove(0);
      d locald = c(b(locala.wp()));
      long l1 = 0L;
      int i = 0;
      long l3 = locala.wq();
      int j = locala.wr();
      v.i("MicroMsg.BucketPool", "%s preload start preloadSize: %s sizeInBytes: %s  preLoadBytes: %s and nums: %s", new Object[] { this, locala.wp(), b(locala.wp()), Long.valueOf(l3), Integer.valueOf(j) });
      while ((this.hgu < wj()) && ((l3 <= 0L) || (l1 < l3)) && ((j <= 0) || (i < j)))
      {
        Object localObject = d(locala.wp());
        locald.put(localObject);
        l1 += at(localObject);
        i += 1;
        I(at(localObject));
      }
      l1 = System.currentTimeMillis();
      v.d("MicroMsg.BucketPool", "%s preload finished, put %d elements, used %dms", new Object[] { this, Integer.valueOf(locald.size()), Long.valueOf(l1 - l2) });
      this.hgs.put(b(locala.wp()), locald);
    }
    GMTrace.o(16012443385856L, 119302);
  }
  
  public abstract class a
  {
    public a()
    {
      GMTrace.i(1295469510656L, 9652);
      GMTrace.o(1295469510656L, 9652);
    }
    
    public abstract S wp();
    
    public abstract long wq();
    
    public abstract int wr();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/memory/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */