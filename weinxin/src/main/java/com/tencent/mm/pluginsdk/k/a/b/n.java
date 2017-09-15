package com.tencent.mm.pluginsdk.k.a.b;

import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avf;
import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class n
  extends k
  implements j
{
  protected static final SparseArray<com.tencent.mm.pluginsdk.k.a.a.a> sED;
  private volatile com.tencent.mm.y.e gUt;
  protected final List<avl> sEC;
  
  static
  {
    GMTrace.i(16426639294464L, 122388);
    sED = new SparseArray();
    GMTrace.o(16426639294464L, 122388);
  }
  
  public n()
  {
    GMTrace.i(850135089152L, 6334);
    this.sEC = new LinkedList();
    int[] arrayOfInt = i.sEg;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Object localObject = (com.tencent.mm.pluginsdk.k.a.a.a)sED.get(k);
      if ((localObject == null) || (!((com.tencent.mm.pluginsdk.k.a.a.a)localObject).jE(k)))
      {
        localObject = new avl();
        ((avl)localObject).jMq = k;
        this.sEC.add(localObject);
      }
      i += 1;
    }
    GMTrace.o(850135089152L, 6334);
  }
  
  public static void a(com.tencent.mm.pluginsdk.k.a.a.a parama)
  {
    GMTrace.i(16426505076736L, 122387);
    sED.put(39, parama);
    GMTrace.o(16426505076736L, 122387);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(850269306880L, 6335);
    this.gUt = parame1;
    v.d(getTag(), "before dispatch");
    int i = a(parame, bDs(), this);
    GMTrace.o(850269306880L, 6335);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(850403524608L, 6336);
    v.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (h.vG().uV())
    {
      long l = bf.Nz();
      h.vI().vr().a(w.a.uAD, Long.valueOf(l + 86400L));
    }
    String str;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = h(paramp);
      str = getTag();
      if (!bf.bV(paramArrayOfByte.tpG)) {
        break label177;
      }
    }
    label177:
    for (paramp = "null";; paramp = String.valueOf(paramArrayOfByte.tpG.size()))
    {
      v.i(str, "response.Res.size() = %s", new Object[] { paramp });
      if (!bf.bV(paramArrayOfByte.tpG)) {
        com.tencent.mm.sdk.f.e.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(861006725120L, 6415);
            Iterator localIterator = this.sEE.iterator();
            if (localIterator.hasNext())
            {
              avk localavk = (avk)localIterator.next();
              Object localObject2 = n.this.getTag();
              int i = localavk.jMq;
              if (bf.bV(localavk.tXq)) {}
              for (Object localObject1 = "null";; localObject1 = String.valueOf(localavk.tXq.size()))
              {
                v.i((String)localObject2, "resType(%d) responses.size() = %s", new Object[] { Integer.valueOf(i), localObject1 });
                if (bf.bV(localavk.tXq)) {
                  break;
                }
                localObject1 = localavk.tXq.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (avf)((Iterator)localObject1).next();
                  n.this.a(localavk.jMq, (avf)localObject2);
                }
                break;
              }
            }
            GMTrace.o(861006725120L, 6415);
          }
        }, "NetSceneCheckResUpdate-ResponseHandlingThread");
      }
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(850403524608L, 6336);
      return;
    }
  }
  
  public final void a(int paramInt, avf paramavf)
  {
    GMTrace.i(16011638079488L, 119296);
    v.i(getTag(), "resType = %d, subType = %d, res.Oper = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramavf.tUe), Integer.valueOf(paramavf.tDn) });
    if (paramavf.tXc != null) {
      v.i(getTag(), "resource.Info.FileFlag %d ", new Object[] { Integer.valueOf(paramavf.tXc.tXn) });
    }
    if (i.b.xa(paramavf.tDn))
    {
      v.i(getTag(), "just do nothing");
      GMTrace.o(16011638079488L, 119296);
      return;
    }
    if (i.b.xb(paramavf.tDn))
    {
      v.i(getTag(), "do cache");
      b.c.sDY.b(paramInt, paramavf, false);
    }
    if (i.b.xc(paramavf.tDn))
    {
      v.i(getTag(), "do decrypt");
      b.c.sDY.c(paramInt, paramavf, false);
    }
    if (i.b.xd(paramavf.tDn))
    {
      v.i(getTag(), "do delete");
      b.c.sDY.a(paramInt, paramavf, false);
    }
    GMTrace.o(16011638079488L, 119296);
  }
  
  protected abstract p bDs();
  
  protected abstract String getTag();
  
  protected abstract kx h(p paramp);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/k/a/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */