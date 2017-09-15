package com.tencent.mm.ao;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.kr;
import com.tencent.mm.e.a.kr.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.aor;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements d, com.tencent.mm.y.e
{
  public f<Integer, Integer> hDm;
  private final int hDr;
  public ai hDt;
  public j hNs;
  long hqC;
  public boolean hqr;
  
  public r(j paramj)
  {
    GMTrace.i(13183804768256L, 98227);
    this.hqr = false;
    this.hDm = new f(200);
    this.hqC = 0L;
    this.hDr = 500;
    this.hDt = new ai(h.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(13184475856896L, 98232);
        v.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
        r localr = r.this;
        long l = bf.NA();
        if ((localr.hqr) && (l - localr.hqC > 10000L)) {
          localr.hqr = false;
        }
        if (localr.hqr) {
          v.d("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
        }
        for (;;)
        {
          GMTrace.o(13184475856896L, 98232);
          return false;
          Object localObject = localr.hNs;
          ArrayList localArrayList = new ArrayList();
          localObject = ((j)localObject).hnp.a("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[] { "200" }, 0);
          if (localObject == null) {}
          for (;;)
          {
            if (localArrayList.size() != 0) {
              break label310;
            }
            v.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
            break;
            int j = ((Cursor)localObject).getCount();
            if (j > 0)
            {
              int i = 0;
              while (i < j)
              {
                ((Cursor)localObject).moveToPosition(i);
                e.b localb = new e.b(0);
                localb.id = ((Cursor)localObject).getInt(0);
                localb.hDk = ((Cursor)localObject).getLong(1);
                localb.cmdId = ((Cursor)localObject).getInt(2);
                localb.buffer = ((Cursor)localObject).getBlob(3);
                localb.nxt = ((Cursor)localObject).getInt(4);
                localb.nxu = ((Cursor)localObject).getLong(4);
                localb.nxv = ((Cursor)localObject).getString(4);
                localb.nxw = ((Cursor)localObject).getString(4);
                localArrayList.add(localb);
                i += 1;
              }
            }
            ((Cursor)localObject).close();
          }
          label310:
          if ((!localr.hqr) && (localArrayList.size() > 0))
          {
            localr.hqC = l;
            localr.hqr = true;
            h.vJ();
            h.vH().gXs.a(new a(localArrayList), 0);
          }
          v.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. ", new Object[] { Long.valueOf(localr.hqC), Boolean.valueOf(localr.hqr), Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      
      public final String toString()
      {
        GMTrace.i(13184610074624L, 98233);
        String str = super.toString() + "|pusherTry";
        GMTrace.o(13184610074624L, 98233);
        return str;
      }
    }, false);
    this.hNs = paramj;
    h.vJ();
    h.vH().gXs.a(681, this);
    GMTrace.o(13183804768256L, 98227);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(13184207421440L, 98230);
    v.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramk.getType() != 681)
    {
      GMTrace.o(13184207421440L, 98230);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0) || (((a)paramk).hMW == null))
    {
      v.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ((a)paramk).hMW.toString() });
      this.hqr = false;
      GMTrace.o(13184207421440L, 98230);
      return;
    }
    aot localaot = ((a.c)((a)paramk).hMW.hMZ).hNb;
    if ((localaot.tgr != 0) || (localaot.tSg == null) || (localaot.tSg.tCl == null))
    {
      v.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[] { Integer.valueOf(localaot.tgr) });
      this.hqr = false;
      GMTrace.o(13184207421440L, 98230);
      return;
    }
    kr localkr = new kr();
    localkr.fRa.ret = ((Integer)localaot.tSg.tCl.getLast()).intValue();
    LinkedList localLinkedList = localaot.tSg.tSh;
    kr.a locala = localkr.fRa;
    if (localLinkedList.isEmpty())
    {
      paramString = "";
      locala.fRb = paramString;
      locala = localkr.fRa;
      if (!localLinkedList.isEmpty()) {
        break label372;
      }
    }
    label372:
    for (paramString = "";; paramString = ((aor)localLinkedList.getLast()).oog)
    {
      locala.fRc = paramString;
      com.tencent.mm.sdk.b.a.uql.m(localkr);
      new a(((a)paramk).hMX, localaot.tSg.tCl).v(50L, 50L);
      GMTrace.o(13184207421440L, 98230);
      return;
      paramString = ((aor)localLinkedList.getLast()).fDt;
      break;
    }
  }
  
  public final void b(e.b paramb)
  {
    GMTrace.i(13183938985984L, 98228);
    int i;
    if (paramb != null)
    {
      int j = paramb.getCmdId();
      if (paramb.getBuffer() == null)
      {
        i = -1;
        v.i("MicroMsg.OplogService", "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), bf.bJP() });
        paramb.hDk = bf.NA();
        j localj = this.hNs;
        if (paramb != null)
        {
          paramb.fRM = -1;
          ContentValues localContentValues = new ContentValues();
          if ((paramb.fRM & 0x2) != 0) {
            localContentValues.put("inserTime", Long.valueOf(paramb.hDk));
          }
          if ((paramb.fRM & 0x4) != 0) {
            localContentValues.put("cmdId", Integer.valueOf(paramb.getCmdId()));
          }
          if ((paramb.fRM & 0x8) != 0) {
            localContentValues.put("buffer", paramb.getBuffer());
          }
          if ((paramb.fRM & 0x10) != 0) {
            localContentValues.put("reserved1", Integer.valueOf(paramb.nxt));
          }
          if ((paramb.fRM & 0x20) != 0) {
            localContentValues.put("reserved2", Long.valueOf(paramb.nxu));
          }
          if ((paramb.fRM & 0x40) != 0) {
            localContentValues.put("reserved3", paramb.nxv);
          }
          if ((paramb.fRM & 0x80) != 0) {
            localContentValues.put("reserved4", paramb.nxw);
          }
          i = (int)localj.hnp.insert("oplog2", "id", localContentValues);
          if (i > 0) {
            paramb.id = i;
          }
        }
      }
    }
    for (;;)
    {
      this.hDt.v(0L, 0L);
      GMTrace.o(13183938985984L, 98228);
      return;
      i = paramb.getBuffer().length;
      break;
      v.i("MicroMsg.OplogService", "summeroplog dealWith option null");
    }
  }
  
  public final void c(e.b paramb)
  {
    GMTrace.i(13184073203712L, 98229);
    h.vJ();
    long l = h.vI().gXW.cs(Thread.currentThread().getId());
    this.hNs.a(paramb);
    h.vJ();
    h.vI().gXW.aD(l);
    GMTrace.o(13184073203712L, 98229);
  }
  
  private final class a
    extends ai
  {
    public a(final LinkedList<Integer> paramLinkedList)
    {
      super(new ai.a()
      {
        private int hKi;
        private int hNu;
        
        public final boolean oQ()
        {
          int j = 0;
          GMTrace.i(13183536332800L, 98225);
          int k = paramLinkedList.size();
          int m = localLinkedList.size();
          int i;
          Object localObject;
          if (k < m)
          {
            i = k;
            if (k != m) {
              v.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(this.hKi) });
            }
            localObject = new ArrayList();
            if (this.hKi < i) {
              break label176;
            }
            r.a.this.hqr = false;
            if (this.hNu > 0)
            {
              localObject = r.a.this.hDt;
              if (r.a.this.hDm.size() <= 0) {
                break label170;
              }
            }
          }
          label170:
          for (long l = 500L;; l = 0L)
          {
            ((ai)localObject).v(l, l);
            GMTrace.o(13183536332800L, 98225);
            return false;
            i = m;
            break;
          }
          label176:
          k = this.hKi + 20;
          if (k > i) {}
          for (;;)
          {
            if (this.hKi < i)
            {
              k = ((Integer)localLinkedList.get(this.hKi)).intValue();
              e.b localb = (e.b)paramLinkedList.get(this.hKi);
              m = localb.id;
              v.d("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()), Integer.valueOf(k) });
              if (k == 0)
              {
                this.hNu += 1;
                ((List)localObject).add(localb);
                r.a.this.hDm.remove(Integer.valueOf(m));
              }
              for (;;)
              {
                this.hKi += 1;
                break;
                if (k == 65103)
                {
                  v.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localb.getCmdId()) });
                }
                else
                {
                  Integer localInteger = (Integer)r.a.this.hDm.get(Integer.valueOf(m));
                  v.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.hDk), localInteger });
                  if (localInteger == null)
                  {
                    r.a.this.hDm.k(Integer.valueOf(m), Integer.valueOf(1));
                  }
                  else if (localInteger.intValue() < 2)
                  {
                    r.a.this.hDm.k(Integer.valueOf(m), Integer.valueOf(localInteger.intValue() + 1));
                  }
                  else
                  {
                    v.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(m), Long.valueOf(localb.hDk) });
                    ((List)localObject).add(localb);
                  }
                }
              }
            }
            k = ((List)localObject).size();
            if (k > 0)
            {
              h.vJ();
              l = h.vI().gXW.cs(Thread.currentThread().getId());
              i = j;
              while (i < k)
              {
                r.a.this.hNs.a((e.b)((List)localObject).get(i));
                i += 1;
              }
              h.vJ();
              h.vI().gXW.aD(l);
            }
            GMTrace.o(13183536332800L, 98225);
            return true;
            i = k;
          }
        }
        
        public final String toString()
        {
          GMTrace.i(13183670550528L, 98226);
          String str = super.toString() + "|RespHandler";
          GMTrace.o(13183670550528L, 98226);
          return str;
        }
      }, true);
      GMTrace.i(13185952251904L, 98243);
      GMTrace.o(13185952251904L, 98243);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ao/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */