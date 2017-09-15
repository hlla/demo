package com.tencent.mm.modelvideo;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i
  implements f.a
{
  public LinkedList<au> hYN;
  long hYO;
  private int hYP;
  private int hYQ;
  public boolean hYR;
  public boolean hYS;
  private boolean hYT;
  private boolean hYU;
  public f hYV;
  long hYW;
  
  public i()
  {
    GMTrace.i(17456491921408L, 130061);
    this.hYN = new LinkedList();
    this.hYO = 0L;
    this.hYP = 0;
    this.hYQ = 0;
    this.hYR = false;
    this.hYS = false;
    this.hYT = false;
    this.hYU = false;
    this.hYV = null;
    this.hYW = 0L;
    GMTrace.o(17456491921408L, 130061);
  }
  
  public final void KQ()
  {
    GMTrace.i(17456760356864L, 130063);
    h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17457431445504L, 130068);
        if (o.Lb().fBc)
        {
          GMTrace.o(17457431445504L, 130068);
          return;
        }
        if (i.this.hYV != null)
        {
          GMTrace.o(17457431445504L, 130068);
          return;
        }
        if ((i.this.hYR) || (i.this.hYS))
        {
          GMTrace.o(17457431445504L, 130068);
          return;
        }
        Object localObject1;
        int i;
        if (i.this.hYN.isEmpty())
        {
          localObject1 = i.this;
          if (bf.az(((i)localObject1).hYW) > 600L) {
            ((i)localObject1).hYW = bf.Nz();
          }
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              i.this.KR();
            }
            GMTrace.o(17457431445504L, 130068);
            return;
          }
        }
        Object localObject5 = new PBool();
        for (;;)
        {
          Object localObject6;
          synchronized (i.this.hYN)
          {
            Iterator localIterator = i.this.hYN.iterator();
            localObject1 = null;
            if (!localIterator.hasNext()) {
              break label679;
            }
            localObject1 = (au)localIterator.next();
            localObject6 = i.this;
            if (localObject1 == null)
            {
              ((PBool)localObject5).value = true;
              i = 0;
              if (!((PBool)localObject5).value) {
                break label938;
              }
              localIterator.remove();
              break label938;
            }
            r localr = t.lI(((ce)localObject1).field_imgPath);
            if ((localr != null) && (localr.Ll()))
            {
              v.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", new Object[] { Integer.valueOf(localObject6.hashCode()), localr.getFileName() });
              String str = (String)bg.q(localr.Li(), "msg").get(".msg.videomsg.$newmd5");
              boolean bool = com.tencent.mm.u.o.dH(localr.Lf());
              if (!bool) {
                break label945;
              }
              i = 2;
              ((i)localObject6).a(str, i, localr.hrb);
              g.oSF.a(354L, 146L, 1L, false);
              if (bool)
              {
                g.oSF.a(354L, 126L, 1L, false);
                ((PBool)localObject5).value = true;
                i = 0;
                continue;
              }
              g.oSF.a(354L, 125L, 1L, false);
            }
          }
          if (bf.aA(((ce)localObject2).field_createTime) >= 86400000L)
          {
            v.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", new Object[] { Integer.valueOf(localObject6.hashCode()) });
            ((PBool)localObject5).value = true;
            i = 0;
          }
          else
          {
            if (((i)localObject6).bu(true)) {
              v.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((i)localObject6).hYO) });
            }
            label666:
            for (;;)
            {
              ((PBool)localObject5).value = false;
              i = 0;
              break;
              v.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", new Object[] { Integer.valueOf(localObject6.hashCode()), Long.valueOf(((ce)localObject2).field_msgId), ((ce)localObject2).gxv });
              localObject6 = ay.gm(((ce)localObject2).gxv);
              if (localObject6 == null)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (((ay.b)localObject6).hmI <= 0)
              {
                ((PBool)localObject5).value = true;
                i = 0;
                break;
              }
              if (!b.iU(((ay.b)localObject6).hmK))
              {
                if (al.isWifi(aa.getContext())) {
                  i = ((ay.b)localObject6).hmJ | 0x1;
                }
                for (;;)
                {
                  if (i <= 0) {
                    break label666;
                  }
                  ((PBool)localObject5).value = false;
                  i = 1;
                  break;
                  if (al.is4G(aa.getContext()))
                  {
                    i = ((ay.b)localObject6).hmJ | 0x2;
                  }
                  else
                  {
                    if (!al.is3G(aa.getContext())) {
                      break label668;
                    }
                    i = ((ay.b)localObject6).hmJ | 0x4;
                  }
                }
              }
            }
            label668:
            ((PBool)localObject5).value = false;
            i = 0;
            continue;
            label679:
            label938:
            do
            {
              if (localObject2 == null)
              {
                GMTrace.o(17457431445504L, 130068);
                return;
              }
              i.this.hYV = new f(((ce)localObject2).field_msgId);
              v.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", new Object[] { Integer.valueOf(i.this.hashCode()), i.this.hYV.KN() });
              if (i.this.hYV.a(i.this) < 0)
              {
                v.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(i.this.hashCode()) });
                synchronized (i.this.hYN)
                {
                  ??? = i.this.hYN.iterator();
                  while (((Iterator)???).hasNext())
                  {
                    localObject5 = (au)((Iterator)???).next();
                    if ((localObject5 != null) && (((ce)localObject5).field_msgId == i.this.hYV.fGD))
                    {
                      v.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(i.this.hYV.fGD) });
                      ((Iterator)???).remove();
                    }
                  }
                }
                i.this.hYV = null;
              }
              GMTrace.o(17457431445504L, 130068);
              return;
            } while (i != 0);
            continue;
            label945:
            i = 1;
          }
        }
      }
    });
    GMTrace.o(17456760356864L, 130063);
  }
  
  public final boolean KR()
  {
    GMTrace.i(18680289165312L, 139179);
    long l1 = bf.NB();
    int i = ((a)h.h(a.class)).sV().getInt("PreLoadVideoExpiredTime", 1);
    long l2 = bf.Nz() - i * 86400L;
    v.i("MicroMsg.PreloadVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d] isC2C[%b]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(1), Integer.valueOf(111), Long.valueOf(l2), Boolean.valueOf(true) });
    List localList = o.KW().a(111, 1, l2);
    if ((localList == null) || (localList.isEmpty()))
    {
      GMTrace.o(18680289165312L, 139179);
      return false;
    }
    Iterator localIterator = localList.iterator();
    i = 0;
    r localr;
    while (localIterator.hasNext())
    {
      localr = (r)localIterator.next();
      if (localr != null)
      {
        o.KW();
        String str = s.lw(localr.getFileName());
        if (bf.mA(str)) {
          break label399;
        }
        File localFile = new File(str);
        if (!localFile.exists()) {
          break label399;
        }
        l2 = localFile.length();
        v.i("MicroMsg.PreloadVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", new Object[] { localr.getFileName(), Long.valueOf(l2), Integer.valueOf(localr.fOr), Long.valueOf(localr.hZT), str });
        if ((l2 <= 0L) || (l2 > localr.fOr)) {
          break label399;
        }
        localFile.delete();
        i += 1;
      }
    }
    label399:
    for (;;)
    {
      localr.fOr = 0;
      localr.fRM = 1;
      t.e(localr);
      break;
      g.oSF.a(354L, 144L, i, false);
      v.i("MicroMsg.PreloadVideoService", "%d delete expire file size %d delete count %d costTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(localList.size()), Integer.valueOf(i), Long.valueOf(bf.aB(l1)) });
      GMTrace.o(18680289165312L, 139179);
      return false;
    }
  }
  
  public final void a(final f paramf, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    GMTrace.i(17456894574592L, 130064);
    if (paramf == null)
    {
      v.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", new Object[] { Integer.valueOf(hashCode()) });
      GMTrace.o(17456894574592L, 130064);
      return;
    }
    if (this.hYV != paramf) {
      v.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", new Object[] { Integer.valueOf(hashCode()) });
    }
    v.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[] { Integer.valueOf(hashCode()), paramf.KN(), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17448304640000L, 130000);
        long l = paramf.fGD;
        synchronized (i.this.hYN)
        {
          Iterator localIterator = i.this.hYN.iterator();
          while (localIterator.hasNext())
          {
            au localau = (au)localIterator.next();
            if ((localau != null) && (localau.field_msgId == l))
            {
              v.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", new Object[] { Integer.valueOf(i.this.hashCode()), Long.valueOf(l) });
              localIterator.remove();
            }
          }
        }
        i.this.bt(true);
        if (i.this.hYV != null) {
          i.this.hYV.hYw = null;
        }
        i.this.hYV = null;
        i.this.KR();
        i.this.KQ();
        GMTrace.o(17448304640000L, 130000);
      }
    });
    GMTrace.o(17456894574592L, 130064);
  }
  
  public final void a(String paramString, int paramInt, long paramLong)
  {
    GMTrace.i(18680423383040L, 139180);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(bf.Nz()).append(",");
    localStringBuffer.append(bf.Nz()).append(",");
    localStringBuffer.append(0).append(",");
    localStringBuffer.append(paramString).append(",");
    localStringBuffer.append(paramInt).append(",");
    localStringBuffer.append(0).append(",");
    localStringBuffer.append(paramLong);
    paramString = localStringBuffer.toString();
    v.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    g.oSF.A(14499, paramString);
    GMTrace.o(18680423383040L, 139180);
  }
  
  public final void bt(boolean paramBoolean)
  {
    GMTrace.i(18680020729856L, 139177);
    if (paramBoolean)
    {
      this.hYP = ((Integer)h.vI().vr().get(w.a.uFX, Integer.valueOf(0))).intValue();
      this.hYP += 1;
      h.vI().vr().a(w.a.uFX, Integer.valueOf(this.hYP));
      GMTrace.o(18680020729856L, 139177);
      return;
    }
    this.hYQ = ((Integer)h.vI().vr().get(w.a.uFY, Integer.valueOf(0))).intValue();
    this.hYQ += 1;
    h.vI().vr().a(w.a.uFY, Integer.valueOf(this.hYQ));
    GMTrace.o(18680020729856L, 139177);
  }
  
  public final boolean bu(boolean paramBoolean)
  {
    int k = 100;
    GMTrace.i(18680154947584L, 139178);
    this.hYO = ((Long)h.vI().vr().get(w.a.uFW, Long.valueOf(-1L))).longValue();
    if (bf.aA(this.hYO) >= 86400000L)
    {
      this.hYO = bf.NA();
      h.vI().vr().a(w.a.uFW, Long.valueOf(this.hYO));
      h.vI().vr().a(w.a.uFX, Integer.valueOf(0));
      h.vI().vr().a(w.a.uFY, Integer.valueOf(0));
      this.hYU = false;
      this.hYT = false;
    }
    this.hYP = ((Integer)h.vI().vr().get(w.a.uFX, Integer.valueOf(0))).intValue();
    this.hYQ = ((Integer)h.vI().vr().get(w.a.uFY, Integer.valueOf(0))).intValue();
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.hYP;
      i = ((a)h.h(a.class)).sV().getInt("C2CMaxPreloadVideo", 100);
      if (i > 0) {
        break label398;
      }
      i = k;
    }
    label221:
    label369:
    label398:
    for (;;)
    {
      boolean bool;
      if (j >= i)
      {
        bool = true;
        v.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.hYP), Integer.valueOf(this.hYQ) });
        if (bool)
        {
          if (!paramBoolean) {
            break label369;
          }
          if (!this.hYT)
          {
            this.hYT = true;
            g.oSF.a(354L, 127L, 1L, false);
          }
        }
      }
      for (;;)
      {
        GMTrace.o(18680154947584L, 139178);
        return bool;
        j = this.hYQ;
        i = ((a)h.h(a.class)).sV().getInt("SnsMaxPreloadVideo", 100);
        break;
        bool = false;
        break label221;
        if (!this.hYU)
        {
          this.hYU = true;
          g.oSF.a(354L, 128L, 1L, false);
        }
      }
    }
  }
  
  public final void stopDownload()
  {
    GMTrace.i(17456626139136L, 130062);
    v.i("MicroMsg.PreloadVideoService", "%d stop download", new Object[] { Integer.valueOf(hashCode()) });
    h.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17455149744128L, 130051);
        if (i.this.hYV != null) {
          i.this.hYV.stop();
        }
        i.this.hYV = null;
        GMTrace.o(17455149744128L, 130051);
      }
    });
    GMTrace.o(17456626139136L, 130062);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelvideo/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */