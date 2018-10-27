package com.google.android.finsky.bo.a;

import android.support.v4.g.h;
import android.text.TextUtils;
import com.google.android.finsky.ag.p;
import com.google.android.finsky.ag.q;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.ds.a.mb;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.af;
import com.google.android.finsky.utils.j;
import com.google.wireless.android.finsky.dfe.nano.cp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class c
  implements f
{
  private final com.google.android.finsky.accounts.a a;
  private final String b;
  private final List c = new ArrayList();
  private long[] d;
  private h e = new h();
  private String f;
  private String g;
  private h h;
  private long[] i;
  private String j;
  
  public c(String paramString, com.google.android.finsky.accounts.a parama, com.google.android.finsky.bo.g... paramVarArgs)
  {
    this.b = paramString;
    this.a = parama;
    Collections.addAll(this.c, paramVarArgs);
    paramString = b(j.c((String)com.google.android.finsky.ag.c.bR.b(this.b).a()));
    this.e.b();
    int i2 = paramString.length;
    parama = new long[i2];
    paramVarArgs = new long[i2];
    int m = 0;
    int n = 0;
    int k = 0;
    if (m >= i2)
    {
      a(parama, paramVarArgs, k, n);
      paramString = com.google.android.finsky.ag.c.bS.b(this.b);
      parama = j.c((String)paramString.a());
      if ((parama.length != 0) && (k()))
      {
        a(parama);
        return;
      }
      paramString.c();
      this.h = null;
      return;
    }
    long l = paramString[m];
    if (d.b.b(l) >= 0)
    {
      int i1 = k + 1;
      parama[k] = l;
      this.e.c(l, null);
      k = i1;
    }
    for (;;)
    {
      m += 1;
      break;
      paramVarArgs[n] = l;
      n += 1;
    }
  }
  
  private static void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Arrays.sort(paramArrayOfLong1);
    paramArrayOfLong2[0] = paramArrayOfLong1[0];
    int k = 1;
    while (k < paramArrayOfLong1.length)
    {
      paramArrayOfLong1[k] -= paramArrayOfLong1[(k - 1)];
      k += 1;
    }
  }
  
  private final void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, int paramInt1, int paramInt2)
  {
    this.d = Arrays.copyOf(paramArrayOfLong1, paramInt1);
    this.i = Arrays.copyOf(paramArrayOfLong2, paramInt2);
    this.f = j.a(this.d);
    this.j = j.a(this.i);
    this.g = null;
  }
  
  private static boolean b(long paramLong)
  {
    int k = d.a.b(paramLong);
    if (k >= 0)
    {
      Boolean localBoolean = (Boolean)d.a.b(k);
      return (localBoolean != null) && (localBoolean.booleanValue());
    }
    return false;
  }
  
  private static long[] b(long[] paramArrayOfLong)
  {
    int n = 0;
    long[] arrayOfLong2 = j.c((String)com.google.android.finsky.ag.d.g.b());
    int k = arrayOfLong2.length;
    long[] arrayOfLong1 = paramArrayOfLong;
    if (k != 0)
    {
      arrayOfLong1 = new long[k + paramArrayOfLong.length];
      k = 0;
      int m;
      for (;;)
      {
        m = n;
        if (k >= paramArrayOfLong.length) {
          break;
        }
        arrayOfLong1[k] = paramArrayOfLong[k];
        k += 1;
      }
      while (m < arrayOfLong2.length)
      {
        arrayOfLong1[(paramArrayOfLong.length + m)] = arrayOfLong2[m];
        m += 1;
      }
    }
    return arrayOfLong1;
  }
  
  public final h a()
  {
    return d.b;
  }
  
  public final void a(com.google.android.finsky.bo.g paramg)
  {
    this.c.add(paramg);
  }
  
  public final void a(mb parammb)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int k;
      int m;
      long l;
      int n;
      Object localObject4;
      int i2;
      int i1;
      label265:
      label277:
      label322:
      label373:
      try
      {
        localObject1 = com.google.android.finsky.ag.c.bR.b(this.b);
        localObject2 = (String)((q)localObject1).a();
        parammb = parammb.a;
        Arrays.sort(parammb);
        localObject3 = j.a(parammb);
        if (TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject3)) {
          break label487;
        }
        ((q)localObject1).a(localObject3);
        parammb = b(parammb);
        localObject1 = this.e;
        localObject2 = new long[d.a.a()];
        k = 0;
        m = 0;
        if (m < d.a.a())
        {
          l = d.a.a(m);
          if (!a(l)) {
            break label743;
          }
          n = k + 1;
          localObject2[k] = l;
          k = n;
          break label736;
        }
        localObject4 = Arrays.copyOf((long[])localObject2, k);
        k = parammb.length;
        this.e = new h(k);
        localObject2 = new long[localObject4.length + k];
        localObject3 = new long[k];
        m = 0;
        k = 0;
        if (k >= localObject4.length) {
          break label746;
        }
        localObject2[m] = localObject4[k];
        this.e.c(localObject4[k], null);
        k += 1;
        m += 1;
        continue;
        if (n >= localObject4.length) {
          break label624;
        }
        l = localObject4[n];
        int i3 = parammb.length;
        i2 = 0;
        if (i2 < i3) {
          break label845;
        }
        FinskyLog.a("Process stable target turned off mid-process: %d", new Object[] { Long.valueOf(l) });
        if (b(l)) {
          break label766;
        }
        i1 = 1;
      }
      finally {}
      label487:
      label583:
      boolean bool;
      if (this.c.isEmpty())
      {
        i2 = parammb.length;
        k = 0;
        n = 0;
        if (n >= i2)
        {
          i1 = parammb.length;
          localObject4 = new h(i1);
          h localh1 = new h(i1);
          n = 0;
          if (n >= i1)
          {
            i1 = parammb.length;
            h localh2 = new h(i1);
            n = 0;
            if (n < i1)
            {
              localh2.c(parammb[n], null);
              n += 1;
              continue;
              if (n < ((h)localObject1).a())
              {
                l = ((h)localObject1).a(n);
                if (localh2.b(l) >= 0) {
                  break label777;
                }
                localh1.c(l, null);
                break label777;
              }
              if ((((h)localObject4).a() > 0) || (localh1.a() > 0))
              {
                parammb = this.c.iterator();
                while (parammb.hasNext()) {
                  ((com.google.android.finsky.bo.g)parammb.next()).a((h)localObject4, localh1);
                }
              }
              a((long[])localObject2, (long[])localObject3, m, k);
            }
          }
          else
          {
            l = parammb[n];
            if (((h)localObject1).b(l) >= 0) {
              break label786;
            }
            ((h)localObject4).c(l, null);
            break label786;
          }
        }
        else
        {
          l = parammb[n];
          if (this.e.b(l) >= 0) {
            break label821;
          }
          if ((d.b.b(l) < 0) || (d.a.b(l) >= 0)) {
            break label804;
          }
          localObject2[m] = l;
          this.e.c(l, null);
          m += 1;
          break label795;
          localObject4 = this.c.iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((com.google.android.finsky.bo.g)((Iterator)localObject4).next()).a(bool);
          }
          continue;
          label624:
          i2 = parammb.length;
          n = 0;
          for (;;)
          {
            if (n < i2)
            {
              l = parammb[n];
              i1 = k;
              if (d.a.b(l) >= 0)
              {
                i1 = k;
                if (this.e.b(l) < 0)
                {
                  FinskyLog.a("Process stable target turned on mid-process: %d", new Object[] { Long.valueOf(l) });
                  bool = b(l);
                  if (bool) {
                    break label717;
                  }
                  i1 = 1;
                }
              }
              n += 1;
              k = i1;
              continue;
              label717:
              k = 1;
              break;
            }
          }
          if (k == 0)
          {
            k = 0;
            continue;
          }
          k = 2;
          continue;
          label736:
          label743:
          for (;;)
          {
            m += 1;
            break;
          }
          label746:
          n = 0;
          k = 0;
          continue;
        }
      }
      label766:
      label777:
      label786:
      label795:
      label804:
      label821:
      label845:
      do
      {
        n += 1;
        k = i1;
        break;
        k = 1;
        break label265;
        n = 0;
        break label373;
        n += 1;
        break label373;
        n += 1;
        break label322;
        for (;;)
        {
          n += 1;
          break;
          i1 = k + 1;
          localObject3[k] = l;
          k = i1;
        }
        if (k == 0) {
          break label277;
        }
        if (k == 1)
        {
          bool = true;
          break label583;
        }
        bool = false;
        break label583;
        i1 = k;
      } while (parammb[i2] == l);
      i2 += 1;
    }
  }
  
  public final void a(long[] paramArrayOfLong)
  {
    int k = 0;
    if (!k()) {
      FinskyLog.e("Experiment overriding not allowed.", new Object[0]);
    }
    for (;;)
    {
      return;
      q localq = com.google.android.finsky.ag.c.bS.b(this.b);
      int m;
      if (paramArrayOfLong != null)
      {
        m = paramArrayOfLong.length;
        if (m != 0) {}
      }
      else
      {
        localq.c();
        this.h = null;
        return;
      }
      localq.a(j.a(paramArrayOfLong));
      this.h = new h(m);
      while (k < m)
      {
        long l = paramArrayOfLong[k];
        this.h.c(l, null);
        k += 1;
      }
    }
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 91	com/google/android/finsky/bo/a/c:h	Landroid/support/v4/g/h;
    //   9: astore 7
    //   11: aload 7
    //   13: ifnull +82 -> 95
    //   16: aload 7
    //   18: lload_1
    //   19: invokevirtual 98	android/support/v4/g/h:b	(J)I
    //   22: iflt +67 -> 89
    //   25: iconst_1
    //   26: istore 4
    //   28: aload_0
    //   29: getfield 31	com/google/android/finsky/bo/a/c:e	Landroid/support/v4/g/h;
    //   32: lload_1
    //   33: invokevirtual 98	android/support/v4/g/h:b	(J)I
    //   36: ifge +47 -> 83
    //   39: iload 4
    //   41: istore 5
    //   43: iload 4
    //   45: iload 6
    //   47: if_icmpeq +31 -> 78
    //   50: ldc -32
    //   52: iconst_2
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: lload_1
    //   59: invokestatic 186	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: iload 4
    //   67: invokestatic 227	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: aastore
    //   71: invokestatic 191	com/google/android/finsky/utils/FinskyLog:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: iload 4
    //   76: istore 5
    //   78: aload_0
    //   79: monitorexit
    //   80: iload 5
    //   82: ireturn
    //   83: iconst_1
    //   84: istore 6
    //   86: goto -47 -> 39
    //   89: iconst_0
    //   90: istore 4
    //   92: goto -64 -> 28
    //   95: aload_0
    //   96: getfield 31	com/google/android/finsky/bo/a/c:e	Landroid/support/v4/g/h;
    //   99: lload_1
    //   100: invokevirtual 98	android/support/v4/g/h:b	(J)I
    //   103: istore_3
    //   104: iload_3
    //   105: iflt +9 -> 114
    //   108: iconst_1
    //   109: istore 5
    //   111: goto -33 -> 78
    //   114: iconst_0
    //   115: istore 5
    //   117: goto -39 -> 78
    //   120: astore 7
    //   122: aload_0
    //   123: monitorexit
    //   124: aload 7
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	c
    //   0	127	1	paramLong	long
    //   103	2	3	k	int
    //   26	65	4	bool1	boolean
    //   41	75	5	bool2	boolean
    //   1	84	6	m	int
    //   9	8	7	localh	h
    //   120	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	11	120	finally
    //   16	25	120	finally
    //   28	39	120	finally
    //   50	74	120	finally
    //   95	104	120	finally
  }
  
  public final long[] b()
  {
    try
    {
      long[] arrayOfLong = this.d;
      return arrayOfLong;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long[] c()
  {
    try
    {
      long[] arrayOfLong = this.i;
      return arrayOfLong;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 91	com/google/android/finsky/bo/a/c:h	Landroid/support/v4/g/h;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +21 -> 31
    //   13: aload_3
    //   14: invokevirtual 170	android/support/v4/g/h:a	()I
    //   17: istore_1
    //   18: iload_1
    //   19: ifle +7 -> 26
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_2
    //   28: goto -6 -> 22
    //   31: aload_0
    //   32: getfield 31	com/google/android/finsky/bo/a/c:e	Landroid/support/v4/g/h;
    //   35: invokevirtual 170	android/support/v4/g/h:a	()I
    //   38: istore_1
    //   39: iload_1
    //   40: ifgt -18 -> 22
    //   43: iconst_0
    //   44: istore_2
    //   45: goto -23 -> 22
    //   48: astore_3
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_3
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	c
    //   17	23	1	k	int
    //   1	44	2	bool	boolean
    //   8	6	3	localh	h
    //   48	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	48	finally
    //   13	18	48	finally
    //   31	39	48	finally
  }
  
  public final boolean e()
  {
    try
    {
      boolean bool = TextUtils.isEmpty(this.j);
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String f()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String g()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String h()
  {
    try
    {
      if (this.g == null)
      {
        localObject1 = new cp();
        ((cp)localObject1).d = 1;
        ((cp)localObject1).a |= 0x1;
        long[] arrayOfLong = this.d;
        int k;
        if (arrayOfLong != null)
        {
          k = arrayOfLong.length;
          if (k > 0)
          {
            ((cp)localObject1).b = new long[k];
            a(arrayOfLong, ((cp)localObject1).b);
          }
        }
        arrayOfLong = this.i;
        if (arrayOfLong != null)
        {
          k = arrayOfLong.length;
          if (k > 0)
          {
            ((cp)localObject1).c = new long[k];
            a(arrayOfLong, ((cp)localObject1).c);
          }
        }
        this.g = af.a((com.google.protobuf.nano.g)localObject1);
      }
      Object localObject1 = this.g;
      return (String)localObject1;
    }
    finally {}
  }
  
  public final h i()
  {
    try
    {
      h localh = this.e;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final h j()
  {
    return this.h;
  }
  
  public final boolean k()
  {
    return (((Boolean)com.google.android.finsky.ag.d.bp.b()).booleanValue()) && (this.a.f());
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bo/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */