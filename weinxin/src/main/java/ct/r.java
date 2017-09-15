package ct;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class r
  implements q
{
  private static r a = null;
  
  public static r a()
  {
    try
    {
      if (a == null) {
        a = new r();
      }
      r localr = a;
      return localr;
    }
    finally {}
  }
  
  public static void a(ap paramap)
  {
    HashMap localHashMap = i.a(paramap);
    localHashMap.put("B64", paramap.G);
    localHashMap.put("B79", paramap.P);
    if (!TextUtils.isEmpty(paramap.M)) {
      localHashMap.put("B73", paramap.G);
    }
    localHashMap.put("B65", paramap.q);
    localHashMap.put("B66", paramap.s);
    localHashMap.put("B75", paramap.r);
    localHashMap.put("B67", paramap.H);
    localHashMap.put("B70", paramap.L);
    localHashMap.put("B72", paramap.I);
    localHashMap.put("B74", paramap.J);
    localHashMap.put("B68", paramap.K);
    localHashMap.put("B80", paramap.Q);
    localHashMap.put("B81", paramap.R);
    localHashMap.put("B77", paramap.N);
    localHashMap.put("B82", paramap.S);
    localHashMap.put("B83", paramap.l);
    localHashMap.put("B84", paramap.f);
    localHashMap.put("B63", paramap.F);
    localHashMap.put("B90", paramap.y);
    localHashMap.put("B91", paramap.z);
    localHashMap.put("B92", paramap.A);
    localHashMap.put("B59", "0");
    localHashMap.put("B60", paramap.B);
    localHashMap.put("B61", "0");
    localHashMap.put("B62", paramap.C);
    localHashMap.put("B71", paramap.E);
    localHashMap.put("B76", paramap.D);
    try
    {
      if (as.k() == null) {
        as.a(p.a);
      }
      av.a("B_ACSDK_SDKExt_Result", localHashMap);
      return;
    }
    catch (OutOfMemoryError paramap) {}catch (Exception paramap) {}
  }
  
  public final void a(f paramf)
  {
    bd.b();
    ap localap = new ap();
    localap.a = paramf.b;
    localap.b = paramf.c;
    localap.c = paramf.d;
    localap.d = paramf.a;
    localap.e = paramf.e;
    localap.h = paramf.i;
    if (localap.h == 1) {
      localap.g = bc.a();
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localap.i = paramf.j;
      Object localObject = paramf.h;
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label341;
      }
      localStringBuilder = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append((String)((Iterator)localObject).next());
        localStringBuilder.append(";");
      }
      localap.f = bc.a();
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    localap.j = localStringBuilder.toString();
    localap.k = paramf.n;
    if (paramf.o) {}
    for (int i = 1;; i = 0)
    {
      localap.m = i;
      localap.n = paramf.k;
      localap.o = paramf.l;
      localap.p = paramf.m;
      localap.t = paramf.p;
      localap.v = paramf.r;
      localap.u = paramf.q;
      localap.w = paramf.s;
      localap.x = paramf.t;
      localap.F = paramf.f;
      new StringBuilder("AccessSchedulerFinished：").append(localap.toString());
      bd.b();
      paramf = new a(localap);
      o.a().a(paramf);
      return;
      label341:
      localap.j = "";
      break;
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc2_w 26
      //   3: invokestatic 33	java/lang/Thread:sleep	(J)V
      //   6: aload_0
      //   7: getfield 17	ct/r$a:a	Lct/ap;
      //   10: invokestatic 38	ct/i:a	(Lct/ap;)Ljava/util/HashMap;
      //   13: astore_1
      //   14: aload_1
      //   15: ldc 40
      //   17: new 42	java/lang/StringBuilder
      //   20: dup
      //   21: invokespecial 43	java/lang/StringBuilder:<init>	()V
      //   24: aload_0
      //   25: getfield 17	ct/r$a:a	Lct/ap;
      //   28: getfield 49	ct/ap:F	Ljava/lang/String;
      //   31: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   34: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   37: invokevirtual 63	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   40: pop
      //   41: aload_1
      //   42: ldc 65
      //   44: new 42	java/lang/StringBuilder
      //   47: dup
      //   48: invokespecial 43	java/lang/StringBuilder:<init>	()V
      //   51: aload_0
      //   52: getfield 17	ct/r$a:a	Lct/ap;
      //   55: getfield 69	ct/ap:t	J
      //   58: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   61: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   64: invokevirtual 63	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   67: pop
      //   68: aload_1
      //   69: ldc 74
      //   71: new 42	java/lang/StringBuilder
      //   74: dup
      //   75: invokespecial 43	java/lang/StringBuilder:<init>	()V
      //   78: aload_0
      //   79: getfield 17	ct/r$a:a	Lct/ap;
      //   82: getfield 77	ct/ap:u	J
      //   85: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   88: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   91: invokevirtual 63	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   94: pop
      //   95: aload_1
      //   96: ldc 79
      //   98: new 42	java/lang/StringBuilder
      //   101: dup
      //   102: invokespecial 43	java/lang/StringBuilder:<init>	()V
      //   105: aload_0
      //   106: getfield 17	ct/r$a:a	Lct/ap;
      //   109: getfield 82	ct/ap:v	J
      //   112: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   115: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   118: invokevirtual 63	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   121: pop
      //   122: aload_1
      //   123: ldc 84
      //   125: new 42	java/lang/StringBuilder
      //   128: dup
      //   129: invokespecial 43	java/lang/StringBuilder:<init>	()V
      //   132: aload_0
      //   133: getfield 17	ct/r$a:a	Lct/ap;
      //   136: getfield 87	ct/ap:w	J
      //   139: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   142: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   145: invokevirtual 63	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   148: pop
      //   149: aload_1
      //   150: ldc 89
      //   152: new 42	java/lang/StringBuilder
      //   155: dup
      //   156: invokespecial 43	java/lang/StringBuilder:<init>	()V
      //   159: aload_0
      //   160: getfield 17	ct/r$a:a	Lct/ap;
      //   163: getfield 92	ct/ap:x	J
      //   166: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   169: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   172: invokevirtual 63	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   175: pop
      //   176: new 42	java/lang/StringBuilder
      //   179: dup
      //   180: ldc 94
      //   182: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   185: aload_0
      //   186: getfield 17	ct/r$a:a	Lct/ap;
      //   189: getfield 69	ct/ap:t	J
      //   192: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   195: ldc 99
      //   197: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   200: aload_0
      //   201: getfield 17	ct/r$a:a	Lct/ap;
      //   204: getfield 77	ct/ap:u	J
      //   207: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   210: ldc 101
      //   212: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   215: aload_0
      //   216: getfield 17	ct/r$a:a	Lct/ap;
      //   219: getfield 82	ct/ap:v	J
      //   222: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   225: ldc 103
      //   227: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   230: aload_0
      //   231: getfield 17	ct/r$a:a	Lct/ap;
      //   234: getfield 87	ct/ap:w	J
      //   237: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   240: ldc 105
      //   242: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   245: aload_0
      //   246: getfield 17	ct/r$a:a	Lct/ap;
      //   249: getfield 92	ct/ap:x	J
      //   252: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   255: pop
      //   256: invokestatic 109	ct/bd:a	()V
      //   259: invokestatic 115	ct/as:k	()Lct/as;
      //   262: ifnonnull +9 -> 271
      //   265: getstatic 120	ct/p:a	Landroid/content/Context;
      //   268: invokestatic 123	ct/as:a	(Landroid/content/Context;)V
      //   271: ldc 125
      //   273: aload_1
      //   274: invokestatic 130	ct/av:a	(Ljava/lang/String;Ljava/util/HashMap;)V
      //   277: return
      //   278: astore_1
      //   279: return
      //   280: astore_1
      //   281: return
      //   282: astore_1
      //   283: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	284	0	this	a
      //   13	261	1	localHashMap	HashMap
      //   278	1	1	localInterruptedException	InterruptedException
      //   280	1	1	localOutOfMemoryError	OutOfMemoryError
      //   282	1	1	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   0	259	278	java/lang/InterruptedException
      //   259	271	278	java/lang/InterruptedException
      //   271	277	278	java/lang/InterruptedException
      //   259	271	280	java/lang/OutOfMemoryError
      //   271	277	280	java/lang/OutOfMemoryError
      //   259	271	282	java/lang/Exception
      //   271	277	282	java/lang/Exception
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */