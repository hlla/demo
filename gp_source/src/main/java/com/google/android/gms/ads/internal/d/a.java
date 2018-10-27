package com.google.android.gms.ads.internal.d;

import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.client.u;
import com.google.android.gms.ads.internal.d.a.c;
import com.google.android.gms.ads.internal.f.k;
import com.google.android.gms.ads.internal.f.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  private final com.google.android.gms.ads.internal.d.a.e a;
  private final boolean b;
  private final h c;
  
  private a()
  {
    this.b = false;
    this.c = new h();
    this.a = new com.google.android.gms.ads.internal.d.a.e();
    b();
  }
  
  public a(h paramh)
  {
    this.c = paramh;
    paramh = n.C;
    this.b = ((Boolean)u.h.e.a(paramh)).booleanValue();
    this.a = new com.google.android.gms.ads.internal.d.a.e();
    b();
  }
  
  public static a a()
  {
    return new a();
  }
  
  private final void b()
  {
    try
    {
      this.a.a = new com.google.android.gms.ads.internal.d.a.a();
      this.a.a.b = new com.google.android.gms.ads.internal.d.a.b();
      this.a.b = new c();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private final void b(g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/google/android/gms/ads/internal/d/a:a	Lcom/google/android/gms/ads/internal/d/a/e;
    //   6: invokestatic 82	com/google/android/gms/ads/internal/d/a:c	()[J
    //   9: putfield 86	com/google/android/gms/ads/internal/d/a/e:d	[J
    //   12: aload_0
    //   13: getfield 22	com/google/android/gms/ads/internal/d/a:c	Lcom/google/android/gms/ads/internal/d/h;
    //   16: aload_0
    //   17: getfield 27	com/google/android/gms/ads/internal/d/a:a	Lcom/google/android/gms/ads/internal/d/a/e;
    //   20: invokestatic 91	com/google/protobuf/nano/g:a	(Lcom/google/protobuf/nano/g;)[B
    //   23: invokevirtual 94	com/google/android/gms/ads/internal/d/h:a	([B)Lcom/google/android/gms/ads/internal/d/k;
    //   26: astore_2
    //   27: aload_2
    //   28: aload_1
    //   29: getfield 100	com/google/android/gms/ads/internal/d/g:z	I
    //   32: putfield 104	com/google/android/gms/ads/internal/d/k:a	I
    //   35: aload_2
    //   36: invokevirtual 106	com/google/android/gms/ads/internal/d/k:a	()V
    //   39: aload_1
    //   40: getfield 100	com/google/android/gms/ads/internal/d/g:z	I
    //   43: bipush 10
    //   45: invokestatic 112	java/lang/Integer:toString	(II)Ljava/lang/String;
    //   48: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 122	java/lang/String:length	()I
    //   56: ifne +20 -> 76
    //   59: new 114	java/lang/String
    //   62: dup
    //   63: ldc 124
    //   65: invokespecial 127	java/lang/String:<init>	(Ljava/lang/String;)V
    //   68: astore_1
    //   69: aload_1
    //   70: invokestatic 131	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: ldc 124
    //   78: aload_1
    //   79: invokevirtual 135	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_1
    //   83: goto -14 -> 69
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	a
    //   0	91	1	paramg	g
    //   26	10	2	localk	k
    // Exception table:
    //   from	to	target	type
    //   2	69	86	finally
    //   69	73	86	finally
    //   76	83	86	finally
  }
  
  /* Error */
  private final void c(g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 145	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +46 -> 53
    //   10: new 147	java/io/File
    //   13: dup
    //   14: aload_2
    //   15: ldc -107
    //   17: invokespecial 152	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_2
    //   21: new 154	java/io/FileOutputStream
    //   24: dup
    //   25: aload_2
    //   26: iconst_1
    //   27: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   30: astore_2
    //   31: aload_2
    //   32: aload_0
    //   33: aload_1
    //   34: invokespecial 160	com/google/android/gms/ads/internal/d/a:d	(Lcom/google/android/gms/ads/internal/d/g;)Ljava/lang/String;
    //   37: invokevirtual 164	java/lang/String:getBytes	()[B
    //   40: invokevirtual 168	java/io/FileOutputStream:write	([B)V
    //   43: aload_2
    //   44: bipush 10
    //   46: invokevirtual 171	java/io/FileOutputStream:write	(I)V
    //   49: aload_2
    //   50: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: astore_1
    //   57: ldc -80
    //   59: invokestatic 131	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   62: goto -9 -> 53
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: ldc -78
    //   73: invokestatic 131	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   76: aload_2
    //   77: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   80: goto -27 -> 53
    //   83: astore_1
    //   84: ldc -76
    //   86: invokestatic 131	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   89: goto -36 -> 53
    //   92: astore_1
    //   93: aload_2
    //   94: invokevirtual 174	java/io/FileOutputStream:close	()V
    //   97: aload_1
    //   98: athrow
    //   99: astore_1
    //   100: ldc -76
    //   102: invokestatic 131	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   105: goto -52 -> 53
    //   108: astore_2
    //   109: ldc -76
    //   111: invokestatic 131	com/google/android/gms/ads/internal/util/e:a	(Ljava/lang/String;)V
    //   114: goto -17 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	a
    //   0	117	1	paramg	g
    //   5	89	2	localObject	Object
    //   108	1	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   21	31	56	java/io/FileNotFoundException
    //   49	53	56	java/io/FileNotFoundException
    //   76	80	56	java/io/FileNotFoundException
    //   84	89	56	java/io/FileNotFoundException
    //   93	97	56	java/io/FileNotFoundException
    //   97	99	56	java/io/FileNotFoundException
    //   100	105	56	java/io/FileNotFoundException
    //   109	114	56	java/io/FileNotFoundException
    //   2	6	65	finally
    //   10	21	65	finally
    //   21	31	65	finally
    //   49	53	65	finally
    //   57	62	65	finally
    //   76	80	65	finally
    //   84	89	65	finally
    //   93	97	65	finally
    //   97	99	65	finally
    //   100	105	65	finally
    //   109	114	65	finally
    //   31	49	70	java/io/IOException
    //   76	80	83	java/io/IOException
    //   31	49	92	finally
    //   71	76	92	finally
    //   49	53	99	java/io/IOException
    //   93	97	108	java/io/IOException
  }
  
  private static long[] c()
  {
    int k = 0;
    Object localObject = n.b();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    String[] arrayOfString;
    int j;
    int i;
    if (((Iterator)localObject).hasNext())
    {
      arrayOfString = ((String)((Iterator)localObject).next()).split(",");
      j = arrayOfString.length;
      i = 0;
    }
    while (i < j)
    {
      String str = arrayOfString[i];
      try
      {
        localArrayList.add(Long.valueOf(str));
        i += 1;
        continue;
        localObject = new long[localArrayList.size()];
        int m = localArrayList.size();
        j = 0;
        i = k;
        while (j < m)
        {
          localObject[i] = ((Long)localArrayList.get(j)).longValue();
          j += 1;
          i += 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.e.a("Experiment ID is not a number");
        }
      }
    }
    return (long[])localObject;
  }
  
  private final String d(g paramg)
  {
    try
    {
      paramg = String.format("id=%s,timestamp=%s,event=%s", new Object[] { this.a.c, Long.valueOf(bt.A.l.b()), Integer.valueOf(paramg.z) });
      return paramg;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  /* Error */
  public final void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/google/android/gms/ads/internal/d/a:b	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +13 -> 21
    //   11: aload_1
    //   12: aload_0
    //   13: getfield 27	com/google/android/gms/ads/internal/d/a:a	Lcom/google/android/gms/ads/internal/d/a/e;
    //   16: invokeinterface 268 2 0
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: getstatic 242	com/google/android/gms/ads/internal/bt:A	Lcom/google/android/gms/ads/internal/bt;
    //   28: getfield 272	com/google/android/gms/ads/internal/bt:i	Lcom/google/android/gms/ads/internal/v/f;
    //   31: aload_1
    //   32: ldc_w 274
    //   35: invokevirtual 279	com/google/android/gms/ads/internal/v/f:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   38: goto -17 -> 21
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	a
    //   0	46	1	paramb	b
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	21	24	java/lang/NullPointerException
    //   2	7	41	finally
    //   11	21	41	finally
    //   25	38	41	finally
  }
  
  /* Error */
  public final void a(g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/google/android/gms/ads/internal/d/a:b	Z
    //   6: ifeq +31 -> 37
    //   9: getstatic 282	com/google/android/gms/ads/internal/f/n:D	Lcom/google/android/gms/ads/internal/f/c;
    //   12: astore_2
    //   13: getstatic 43	com/google/android/gms/ads/internal/client/u:h	Lcom/google/android/gms/ads/internal/client/u;
    //   16: getfield 47	com/google/android/gms/ads/internal/client/u:e	Lcom/google/android/gms/ads/internal/f/k;
    //   19: aload_2
    //   20: invokevirtual 52	com/google/android/gms/ads/internal/f/k:a	(Lcom/google/android/gms/ads/internal/f/c;)Ljava/lang/Object;
    //   23: checkcast 54	java/lang/Boolean
    //   26: invokevirtual 58	java/lang/Boolean:booleanValue	()Z
    //   29: ifeq +11 -> 40
    //   32: aload_0
    //   33: aload_1
    //   34: invokespecial 284	com/google/android/gms/ads/internal/d/a:c	(Lcom/google/android/gms/ads/internal/d/g;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 286	com/google/android/gms/ads/internal/d/a:b	(Lcom/google/android/gms/ads/internal/d/g;)V
    //   45: goto -8 -> 37
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	a
    //   0	53	1	paramg	g
    //   12	8	2	localc	com.google.android.gms.ads.internal.f.c
    // Exception table:
    //   from	to	target	type
    //   2	37	48	finally
    //   40	45	48	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */