package android.support.v7.widget;

import android.support.v4.os.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class ck
  implements Runnable
{
  public static final ThreadLocal c = new ThreadLocal();
  private static Comparator f = new cl();
  public long a;
  public ArrayList b = new ArrayList();
  private long d;
  private ArrayList e = new ArrayList();
  
  /* Error */
  private static fz a(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	android/support/v7/widget/RecyclerView:k	Landroid/support/v7/widget/be;
    //   4: invokevirtual 51	android/support/v7/widget/be:b	()I
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: iload 5
    //   16: if_icmpge +45 -> 61
    //   19: aload_0
    //   20: getfield 46	android/support/v7/widget/RecyclerView:k	Landroid/support/v7/widget/be;
    //   23: iload 4
    //   25: invokevirtual 54	android/support/v7/widget/be:c	(I)Landroid/view/View;
    //   28: invokestatic 57	android/support/v7/widget/RecyclerView:b	(Landroid/view/View;)Landroid/support/v7/widget/fz;
    //   31: astore 6
    //   33: aload 6
    //   35: getfield 63	android/support/v7/widget/fz:l	I
    //   38: iload_1
    //   39: if_icmpeq +12 -> 51
    //   42: iload 4
    //   44: iconst_1
    //   45: iadd
    //   46: istore 4
    //   48: goto -36 -> 12
    //   51: aload 6
    //   53: invokevirtual 67	android/support/v7/widget/fz:j	()Z
    //   56: ifne -14 -> 42
    //   59: aconst_null
    //   60: areturn
    //   61: aload_0
    //   62: getfield 71	android/support/v7/widget/RecyclerView:B	Landroid/support/v7/widget/fp;
    //   65: astore 6
    //   67: aload_0
    //   68: invokevirtual 73	android/support/v7/widget/RecyclerView:k	()V
    //   71: aload 6
    //   73: iload_1
    //   74: lload_2
    //   75: invokevirtual 78	android/support/v7/widget/fp:a	(IJ)Landroid/support/v7/widget/fz;
    //   78: astore 7
    //   80: aload 7
    //   82: ifnull +31 -> 113
    //   85: aload 7
    //   87: getfield 80	android/support/v7/widget/fz:d	I
    //   90: iconst_1
    //   91: iand
    //   92: ifeq +29 -> 121
    //   95: aload 7
    //   97: invokevirtual 67	android/support/v7/widget/fz:j	()Z
    //   100: ifne +21 -> 121
    //   103: aload 6
    //   105: aload 7
    //   107: getfield 83	android/support/v7/widget/fz:c	Landroid/view/View;
    //   110: invokevirtual 86	android/support/v7/widget/fp:a	(Landroid/view/View;)V
    //   113: aload_0
    //   114: iconst_0
    //   115: invokevirtual 89	android/support/v7/widget/RecyclerView:b	(Z)V
    //   118: aload 7
    //   120: areturn
    //   121: aload 6
    //   123: aload 7
    //   125: iconst_0
    //   126: invokevirtual 92	android/support/v7/widget/fp:a	(Landroid/support/v7/widget/fz;Z)V
    //   129: goto -16 -> 113
    //   132: astore 6
    //   134: aload_0
    //   135: iconst_0
    //   136: invokevirtual 89	android/support/v7/widget/RecyclerView:b	(Z)V
    //   139: aload 6
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramRecyclerView	RecyclerView
    //   0	142	1	paramInt	int
    //   0	142	2	paramLong	long
    //   10	37	4	i	int
    //   7	10	5	j	int
    //   31	91	6	localObject1	Object
    //   132	8	6	localObject2	Object
    //   78	46	7	localfz	fz
    // Exception table:
    //   from	to	target	type
    //   67	80	132	finally
    //   85	113	132	finally
    //   121	129	132	finally
  }
  
  final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (this.d == 0L))
    {
      this.d = RecyclerView.q();
      paramRecyclerView.post(this);
    }
    paramRecyclerView = paramRecyclerView.A;
    paramRecyclerView.c = paramInt1;
    paramRecyclerView.d = paramInt2;
  }
  
  public final void run()
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        c.a("RV Prefetch");
        if (!this.b.isEmpty())
        {
          j = this.b.size();
          l1 = 0L;
          i = 0;
          if (i < j)
          {
            localObject1 = (RecyclerView)this.b.get(i);
            if (((RecyclerView)localObject1).getWindowVisibility() != 0) {
              break label729;
            }
            l1 = Math.max(((RecyclerView)localObject1).getDrawingTime(), l1);
            break label722;
          }
          if (l1 != 0L)
          {
            l2 = TimeUnit.MILLISECONDS.toNanos(l1) + this.a;
            int m = this.b.size();
            i = 0;
            j = 0;
            if (j < m)
            {
              localObject1 = (RecyclerView)this.b.get(j);
              if (((RecyclerView)localObject1).getWindowVisibility() != 0) {
                break label739;
              }
              ((RecyclerView)localObject1).A.a((RecyclerView)localObject1, false);
              i = ((RecyclerView)localObject1).A.a + i;
              break label732;
            }
            this.e.ensureCapacity(i);
            i = 0;
            j = 0;
            if (j < m)
            {
              localObject4 = (RecyclerView)this.b.get(j);
              if (((RecyclerView)localObject4).getWindowVisibility() != 0) {
                break label748;
              }
              localcm = ((RecyclerView)localObject4).A;
              int n = Math.abs(localcm.c) + Math.abs(localcm.d);
              k = 0;
              int i1 = localcm.a;
              if (k >= i1 + i1) {
                break label719;
              }
              if (i >= this.e.size())
              {
                localObject1 = new cn();
                this.e.add(localObject1);
                localObject5 = localcm.b;
                i1 = localObject5[(k + 1)];
                if (i1 > n) {
                  break label742;
                }
                bool = true;
                ((cn)localObject1).b = bool;
                ((cn)localObject1).e = n;
                ((cn)localObject1).a = i1;
                ((cn)localObject1).d = ((RecyclerView)localObject4);
                ((cn)localObject1).c = localObject5[k];
                i += 1;
                k += 2;
                continue;
              }
              localObject1 = (cn)this.e.get(i);
              continue;
            }
            Collections.sort(this.e, f);
            i = 0;
            if (i < this.e.size())
            {
              localObject1 = (cn)this.e.get(i);
              localObject4 = ((cn)localObject1).d;
              if (localObject4 != null) {
                if (!((cn)localObject1).b)
                {
                  l1 = l2;
                  localObject4 = a((RecyclerView)localObject4, ((cn)localObject1).c, l1);
                  if ((localObject4 != null) && (((fz)localObject4).h != null) && ((((fz)localObject4).d & 0x1) != 0) && (!((fz)localObject4).j()))
                  {
                    localObject4 = (RecyclerView)((fz)localObject4).h.get();
                    if (localObject4 != null)
                    {
                      if ((((RecyclerView)localObject4).l) && (((RecyclerView)localObject4).k.b() != 0)) {
                        continue;
                      }
                      localcm = ((RecyclerView)localObject4).A;
                      localcm.a((RecyclerView)localObject4, true);
                      j = localcm.a;
                      if (j == 0) {}
                    }
                  }
                }
              }
            }
          }
        }
      }
      finally
      {
        Object localObject1;
        long l2;
        Object localObject4;
        cm localcm;
        int k;
        Object localObject5;
        eu localeu;
        this.d = 0L;
        c.a();
      }
      try
      {
        c.a("RV Nested Prefetch");
        localObject5 = ((RecyclerView)localObject4).G;
        localeu = ((RecyclerView)localObject4).g;
        ((fw)localObject5).h = 1;
        ((fw)localObject5).g = localeu.c();
        ((fw)localObject5).e = false;
        ((fw)localObject5).n = false;
        ((fw)localObject5).f = false;
        j = 0;
        k = localcm.a;
        if (j < k + k)
        {
          a((RecyclerView)localObject4, localcm.b[j], l2);
          j += 2;
          continue;
        }
        c.a();
        ((cn)localObject1).b = false;
        ((cn)localObject1).e = 0;
        ((cn)localObject1).a = 0;
        ((cn)localObject1).d = null;
        ((cn)localObject1).c = 0;
        i += 1;
        continue;
      }
      finally
      {
        c.a();
      }
      ((RecyclerView)localObject4).b();
      continue;
      long l1 = Long.MAX_VALUE;
      continue;
      this.d = 0L;
      c.a();
      return;
      this.d = 0L;
      c.a();
      return;
      this.d = 0L;
      c.a();
      return;
      label719:
      break label748;
      label722:
      label729:
      for (;;)
      {
        i += 1;
        break;
      }
      label732:
      label739:
      for (;;)
      {
        j += 1;
        break;
      }
      label742:
      boolean bool = false;
      continue;
      label748:
      j += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */