package com.tencent.mm.plugin.record.a;

import android.database.Cursor;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.ah.c.a;
import com.tencent.mm.ah.d;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.fp.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.s.a.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class p
  implements i.a, com.tencent.mm.y.e
{
  public boolean oMH;
  public SparseArray<e> oMK;
  LinkedList<k> oML;
  
  public p()
  {
    GMTrace.i(7498073374720L, 55865);
    this.oMH = false;
    this.oMK = new SparseArray();
    this.oML = new LinkedList();
    ap.vd().a(632, this);
    s.aWy().a(this);
    GMTrace.o(7498073374720L, 55865);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(7498610245632L, 55869);
    v.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramk == null)
    {
      v.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
      GMTrace.o(7498610245632L, 55869);
      return;
    }
    switch (paramk.getType())
    {
    default: 
      this.oMH = false;
      a(null);
      GMTrace.o(7498610245632L, 55869);
      return;
    }
    v.d("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramString = (a)paramk;
    int k = paramInt1;
    int i = paramInt2;
    if (paramInt1 == 3)
    {
      paramk = paramString.oME.field_dataProto.txF.iterator();
      do
      {
        if (!paramk.hasNext()) {
          break;
        }
      } while (((rl)paramk.next()).aMw == 1);
    }
    for (int j = 0;; j = 1)
    {
      k = paramInt1;
      i = paramInt2;
      if (j != 0)
      {
        k = 0;
        i = 0;
      }
      Object localObject1;
      if ((k == 0) && (i == 0))
      {
        ap.yY();
        paramk = com.tencent.mm.u.c.wT().cA(paramString.oME.field_msgId);
        if (paramk.field_msgId == paramString.oME.field_msgId)
        {
          paramk.setContent(paramString.oMD);
          paramk.dv(1);
          ap.yY();
          com.tencent.mm.u.c.wT().a(paramString.oME.field_msgId, paramk);
        }
        localObject1 = an.bDc().ec(paramString.oME.field_msgId);
        if (localObject1 != null)
        {
          ((com.tencent.mm.t.f)localObject1).field_xml = paramk.field_content;
          an.bDc().c((com.tencent.mm.sdk.e.c)localObject1, new String[] { "msgId" });
        }
        s.aWx().rN(paramString.oME.field_localId);
        this.oMK.remove(paramString.oME.field_localId);
        an.bDe();
        am.a.eg(paramString.oME.field_msgId);
        v.d("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[] { Long.valueOf(paramString.oME.field_msgId), Integer.valueOf(paramString.oME.field_localId) });
        break;
      }
      v.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[] { Long.valueOf(paramString.oME.field_msgId), Integer.valueOf(paramString.oME.field_localId) });
      v.w("MicroMsg.RecordMsgSendService", "try upload from local");
      paramk = paramString.oME.field_dataProto.txF.iterator();
      while (paramk.hasNext())
      {
        localObject1 = (rl)paramk.next();
        String str;
        Object localObject2;
        boolean bool;
        if (((rl)localObject1).tvV > 0L)
        {
          str = m.d(((rl)localObject1).lII, paramString.oME.field_msgId, false);
          if (s.aWy().Dm(str) == null)
          {
            localObject2 = new g();
            ((g)localObject2).field_cdnKey = ((rl)localObject1).tvC;
            ((g)localObject2).field_cdnUrl = ((rl)localObject1).tvA;
            ((g)localObject2).field_dataId = ((rl)localObject1).lII;
            ((g)localObject2).field_mediaId = str;
            ((g)localObject2).field_totalLen = ((int)((rl)localObject1).tvV);
            ((g)localObject2).field_localId = ((g)localObject2).field_mediaId.hashCode();
            ((g)localObject2).field_path = m.c((rl)localObject1, paramString.oME.field_msgId);
            ((g)localObject2).field_type = 2;
            ((g)localObject2).field_fileType = m.rO(((rl)localObject1).aMw);
            ((g)localObject2).field_recordLocalId = paramString.oME.field_localId;
            ((g)localObject2).field_toUser = paramString.oME.field_toUser;
            ((g)localObject2).field_isThumb = false;
            bool = s.aWy().a((g)localObject2);
            v.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((g)localObject2).field_localId), Boolean.valueOf(bool) });
          }
        }
        if (((rl)localObject1).twg > 0L)
        {
          str = m.vV(((rl)localObject1).lII);
          localObject2 = m.d(str, paramString.oME.field_msgId, false);
          if (s.aWy().Dm((String)localObject2) == null)
          {
            g localg = new g();
            localg.field_cdnKey = ((rl)localObject1).tvw;
            localg.field_cdnUrl = ((rl)localObject1).hho;
            localg.field_dataId = str;
            localg.field_mediaId = ((String)localObject2);
            localg.field_totalLen = ((int)((rl)localObject1).twg);
            localg.field_localId = localg.field_mediaId.hashCode();
            localg.field_path = m.f((rl)localObject1, paramString.oME.field_msgId);
            localg.field_type = 2;
            localg.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
            localg.field_recordLocalId = paramString.oME.field_localId;
            localg.field_toUser = paramString.oME.field_toUser;
            localg.field_isThumb = true;
            bool = s.aWy().a(localg);
            v.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localg.field_localId), Boolean.valueOf(bool) });
          }
        }
      }
      s.aWA().run();
      GMTrace.o(7498610245632L, 55869);
      return;
    }
  }
  
  public final void a(int paramInt, g paramg)
  {
    GMTrace.i(7498744463360L, 55870);
    if (1 != paramInt)
    {
      v.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[] { Integer.valueOf(paramInt) });
      GMTrace.o(7498744463360L, 55870);
      return;
    }
    if (paramg == null)
    {
      v.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
      GMTrace.o(7498744463360L, 55870);
      return;
    }
    if (2 != paramg.field_type)
    {
      v.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload");
      GMTrace.o(7498744463360L, 55870);
      return;
    }
    if ((paramg.field_status == 0) || (1 == paramg.field_status))
    {
      v.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
      GMTrace.o(7498744463360L, 55870);
      return;
    }
    Object localObject1 = s.aWy();
    paramInt = paramg.field_recordLocalId;
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = "SELECT * FROM RecordCDNInfo WHERE recordLocalId = " + paramInt;
    localObject1 = ((i)localObject1).gUp.a((String)localObject2, null, 2);
    if (localObject1 != null)
    {
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new g();
        ((g)localObject2).b((Cursor)localObject1);
        localLinkedList.add(localObject2);
      }
      ((Cursor)localObject1).close();
    }
    v.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
    localObject1 = localLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (g)((Iterator)localObject1).next();
      if ((((g)localObject2).field_status == 0) || (1 == ((g)localObject2).field_status)) {
        v.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[] { ((g)localObject2).field_mediaId });
      }
    }
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt == 0)
      {
        GMTrace.o(7498744463360L, 55870);
        return;
      }
      localObject1 = s.aWx();
      paramInt = paramg.field_recordLocalId;
      localObject2 = "SELECT * FROM RecordMessageInfo WHERE localId=" + paramInt;
      v.d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", new Object[] { localObject2, Integer.valueOf(paramInt) });
      localObject2 = ((l)localObject1).gUp.a((String)localObject2, null, 2);
      if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject1 = new k();
        ((k)localObject1).b((Cursor)localObject2);
      }
      for (;;)
      {
        if (localObject2 != null) {
          ((Cursor)localObject2).close();
        }
        paramInt = paramg.field_recordLocalId;
        boolean bool;
        if (localObject1 != null)
        {
          bool = true;
          v.d("MicroMsg.RecordMsgSendService", "finish get record info, id %d result %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
          if (localObject1 == null) {
            break label1058;
          }
          paramg = ((k)localObject1).field_dataProto.txF;
          localObject2 = localLinkedList.iterator();
          label512:
          break label728;
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label858;
          }
          g localg = (g)((Iterator)localObject2).next();
          v.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[] { localg.field_dataId, Boolean.valueOf(localg.field_isThumb) });
          rl localrl;
          if (localg.field_isThumb)
          {
            localIterator = paramg.iterator();
            if (!localIterator.hasNext()) {
              continue;
            }
            localrl = (rl)localIterator.next();
            if (!localg.field_dataId.equals(m.vV(localrl.lII))) {
              break label512;
            }
            v.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localrl.tvw, localg.field_cdnKey, localrl.hho, localg.field_cdnUrl, Long.valueOf(localrl.twg), Integer.valueOf(localg.field_totalLen) });
            localrl.NN(localg.field_cdnKey);
            localrl.NM(localg.field_cdnUrl);
            continue;
            bool = false;
            break;
          }
          Iterator localIterator = paramg.iterator();
          label728:
          if (localIterator.hasNext())
          {
            localrl = (rl)localIterator.next();
            if (!localg.field_dataId.equals(localrl.lII)) {
              break label512;
            }
            v.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[] { localrl.tvC, localg.field_cdnKey, localrl.tvA, localg.field_cdnUrl, Long.valueOf(localrl.tvV), Integer.valueOf(localg.field_totalLen) });
            localrl.NP(localg.field_cdnKey);
            localrl.NO(localg.field_cdnUrl);
          }
        }
        label858:
        ap.yY();
        localObject2 = com.tencent.mm.u.c.wT().cA(((k)localObject1).field_msgId);
        v.i("MicroMsg.RecordMsgSendService", "update msg content, msg null ? %B, msgId %d recordInfoId %d", new Object[] { Boolean.valueOf(false), Long.valueOf(((ce)localObject2).field_msgId), Long.valueOf(((k)localObject1).field_msgId) });
        if (((ce)localObject2).field_msgId == ((k)localObject1).field_msgId)
        {
          ((au)localObject2).setContent(m.b(((k)localObject1).field_title, ((k)localObject1).field_desc, paramg, ((k)localObject1).field_favFrom));
          ((au)localObject2).dv(1);
          ap.yY();
          com.tencent.mm.u.c.wT().a(((k)localObject1).field_msgId, (au)localObject2);
        }
        paramg = an.bDc().ec(((k)localObject1).field_msgId);
        if (paramg != null)
        {
          paramg.field_xml = ((ce)localObject2).field_content;
          an.bDc().c(paramg, new String[] { "msgId" });
        }
        s.aWx().rN(((k)localObject1).field_localId);
        this.oMK.remove(((k)localObject1).field_localId);
        an.bDe();
        am.a.eg(((k)localObject1).field_msgId);
        label1058:
        paramg = localLinkedList.iterator();
        while (paramg.hasNext())
        {
          localObject1 = (g)paramg.next();
          s.aWy().a((g)localObject1, new String[] { "localId" });
        }
        this.oMH = false;
        a(null);
        GMTrace.o(7498744463360L, 55870);
        return;
        localObject1 = null;
      }
    }
  }
  
  public final void a(final k paramk)
  {
    GMTrace.i(7498207592448L, 55866);
    ap.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(7504247390208L, 55911);
        if (paramk != null)
        {
          if ((p.e)p.this.oMK.get(paramk.field_localId) == null)
          {
            v.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[] { Integer.valueOf(paramk.field_localId), Long.valueOf(paramk.field_msgId) });
            localObject1 = new p.e();
            p.this.oMK.put(paramk.field_localId, localObject1);
          }
          p.this.b(paramk);
        }
        p localp = p.this;
        if (localp.oMH)
        {
          v.d("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
          GMTrace.o(7504247390208L, 55911);
          return;
        }
        if (localp.oML.isEmpty())
        {
          v.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
          localObject2 = s.aWx();
          localObject1 = new LinkedList();
          localObject2 = ((l)localObject2).Kl();
          if (localObject2 != null)
          {
            ((Cursor)localObject2).moveToFirst();
            while (!((Cursor)localObject2).isAfterLast())
            {
              localObject3 = new k();
              ((k)localObject3).b((Cursor)localObject2);
              ((List)localObject1).add(localObject3);
              ((Cursor)localObject2).moveToNext();
            }
            ((Cursor)localObject2).close();
          }
          v.d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (k)((Iterator)localObject1).next();
            ap.yY();
            if (com.tencent.mm.u.c.wT().cA(((k)localObject2).field_msgId).field_type != 49)
            {
              v.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[] { Integer.valueOf(((k)localObject2).field_localId), Long.valueOf(((k)localObject2).field_msgId) });
              s.aWx().rN(((k)localObject2).field_localId);
            }
            else
            {
              localObject3 = (p.e)localp.oMK.get(((k)localObject2).field_localId);
              if (localObject3 != null)
              {
                if ((((p.e)localObject3).ihB < 0) && (SystemClock.elapsedRealtime() - ((p.e)localObject3).oMN < 300000L)) {
                  continue;
                }
                if (((p.e)localObject3).ihB < 0) {
                  ((p.e)localObject3).ihB = 3;
                }
              }
              for (;;)
              {
                v.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[] { Integer.valueOf(((k)localObject2).field_localId), Long.valueOf(((k)localObject2).field_msgId) });
                localp.b((k)localObject2);
                break;
                localObject3 = new p.e();
                localp.oMK.put(((k)localObject2).field_localId, localObject3);
              }
            }
          }
        }
        if (localp.oML.isEmpty())
        {
          v.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
          localp.finish();
          GMTrace.o(7504247390208L, 55911);
          return;
        }
        Object localObject3 = (k)localp.oML.removeFirst();
        Object localObject2 = (p.e)localp.oMK.get(((k)localObject3).field_localId);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new p.e();
          localp.oMK.put(((k)localObject3).field_localId, localObject1);
        }
        ((p.e)localObject1).ihB -= 1;
        int i;
        if (((p.e)localObject1).ihB < 0) {
          if (300000L > SystemClock.elapsedRealtime() - ((p.e)localObject1).oMN) {
            i = 0;
          }
        }
        while (i != 0)
        {
          localp.oMH = true;
          switch (((k)localObject3).field_type)
          {
          default: 
            localp.oMH = false;
            GMTrace.o(7504247390208L, 55911);
            return;
            ((p.e)localObject1).ihB = 2;
            ((p.e)localObject1).oMN = SystemClock.elapsedRealtime();
            i = 1;
            break;
          case 1: 
            com.tencent.mm.sdk.f.e.post(new p.c(localp, (k)localObject3), "RecordMsgSendService_favDataCopy");
            GMTrace.o(7504247390208L, 55911);
            return;
          case 2: 
            com.tencent.mm.sdk.f.e.post(new p.a(localp, (k)localObject3), "RecordMsgSendService_chatDataCopy");
            GMTrace.o(7504247390208L, 55911);
            return;
          case 0: 
            com.tencent.mm.sdk.f.e.post(new p.d(localp, (k)localObject3), "RecordMsgSendService_normalDataCopy");
            GMTrace.o(7504247390208L, 55911);
            return;
          case 3: 
            com.tencent.mm.sdk.f.e.post(new p.b(localp, (k)localObject3), "RecordMsgSendService_chatDataDownLoad");
            GMTrace.o(7504247390208L, 55911);
            return;
          }
        }
        localp.a(null);
        GMTrace.o(7504247390208L, 55911);
      }
      
      public final String toString()
      {
        GMTrace.i(7504381607936L, 55912);
        String str = super.toString() + "|run";
        GMTrace.o(7504381607936L, 55912);
        return str;
      }
    });
    GMTrace.o(7498207592448L, 55866);
  }
  
  public final void b(k paramk)
  {
    GMTrace.i(7498341810176L, 55867);
    if (!this.oML.contains(paramk)) {
      this.oML.add(paramk);
    }
    GMTrace.o(7498341810176L, 55867);
  }
  
  final void finish()
  {
    GMTrace.i(7498476027904L, 55868);
    this.oML.clear();
    this.oMK.clear();
    this.oMH = false;
    GMTrace.o(7498476027904L, 55868);
  }
  
  private final class a
    implements Runnable
  {
    private k oME;
    
    public a(k paramk)
    {
      GMTrace.i(7516461203456L, 56002);
      this.oME = paramk;
      GMTrace.o(7516461203456L, 56002);
    }
    
    public final void run()
    {
      GMTrace.i(7516595421184L, 56003);
      Iterator localIterator = this.oME.field_dataProto.txF.iterator();
      int k;
      for (int j = 0; localIterator.hasNext(); j = k)
      {
        rl localrl = (rl)localIterator.next();
        int i;
        String str;
        Object localObject;
        boolean bool;
        if (bf.mA(localrl.tvA))
        {
          i = j;
          if (!com.tencent.mm.a.e.aO(localrl.tvY)) {}
        }
        else
        {
          str = localrl.tvY;
          localObject = m.c(localrl, this.oME.field_msgId);
          bool = j.p(str, (String)localObject, false);
          v.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[] { localrl.tvA, str, localObject, Boolean.valueOf(bool) });
          k = j;
          if (bool)
          {
            if (bf.mA(localrl.tvR))
            {
              v.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
              localrl.NV(com.tencent.mm.a.g.aV((String)localObject));
              j = 1;
            }
            k = j;
            if (bf.mA(localrl.tvT))
            {
              v.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
              localrl.NW(com.tencent.mm.a.g.aW((String)localObject));
              k = 1;
            }
          }
          if (com.tencent.mm.a.e.aN((String)localObject) != 0) {
            localrl.ej(com.tencent.mm.a.e.aN((String)localObject));
          }
          str = m.d(localrl.lII, this.oME.field_msgId, false);
          i = k;
          if (s.aWy().Dm(str) == null)
          {
            localObject = new g();
            ((g)localObject).field_cdnKey = localrl.tvC;
            ((g)localObject).field_cdnUrl = localrl.tvA;
            ((g)localObject).field_dataId = localrl.lII;
            ((g)localObject).field_mediaId = str;
            ((g)localObject).field_totalLen = ((int)localrl.tvV);
            ((g)localObject).field_localId = ((g)localObject).field_mediaId.hashCode();
            ((g)localObject).field_path = m.c(localrl, this.oME.field_msgId);
            ((g)localObject).field_type = 2;
            ((g)localObject).field_fileType = m.rO(localrl.aMw);
            ((g)localObject).field_recordLocalId = this.oME.field_localId;
            ((g)localObject).field_toUser = this.oME.field_toUser;
            ((g)localObject).field_isThumb = false;
            bool = s.aWy().a((g)localObject);
            v.d("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[] { Integer.valueOf(((g)localObject).field_localId), Boolean.valueOf(bool), Integer.valueOf(((g)localObject).field_fileType), str });
            i = k;
          }
        }
        if (bf.mA(localrl.hho))
        {
          k = i;
          if (!com.tencent.mm.a.e.aO(localrl.twa)) {}
        }
        else
        {
          str = localrl.twa;
          localObject = m.f(localrl, this.oME.field_msgId);
          bool = j.p(str, (String)localObject, false);
          v.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str, localObject, Boolean.valueOf(bool) });
          localrl.ek(com.tencent.mm.a.e.aN((String)localObject));
          j = i;
          if (bool)
          {
            if (bf.mA(localrl.twc))
            {
              v.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
              localrl.Oa(com.tencent.mm.a.g.aV((String)localObject));
              i = 1;
            }
            j = i;
            if (bf.mA(localrl.twe))
            {
              v.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
              localrl.Ob(com.tencent.mm.a.g.aW((String)localObject));
              j = 1;
            }
          }
          str = m.vV(localrl.lII);
          localObject = m.d(str, this.oME.field_msgId, false);
          k = j;
          if (s.aWy().Dm((String)localObject) == null)
          {
            g localg = new g();
            localg.field_cdnKey = localrl.tvw;
            localg.field_cdnUrl = localrl.hho;
            localg.field_dataId = str;
            localg.field_mediaId = ((String)localObject);
            localg.field_totalLen = ((int)localrl.twg);
            localg.field_localId = localg.field_mediaId.hashCode();
            localg.field_path = m.f(localrl, this.oME.field_msgId);
            localg.field_type = 2;
            localg.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
            localg.field_recordLocalId = this.oME.field_localId;
            localg.field_toUser = this.oME.field_toUser;
            localg.field_isThumb = true;
            bool = s.aWy().a(localg);
            v.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localg.field_localId), Boolean.valueOf(bool) });
            k = j;
          }
        }
      }
      if (j != 0)
      {
        v.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.oME.field_localId), Long.valueOf(this.oME.field_msgId), Integer.valueOf(this.oME.field_type) });
        s.aWx().c(this.oME, new String[] { "localId" });
      }
      s.aWA().run();
      GMTrace.o(7516595421184L, 56003);
    }
  }
  
  private final class b
    implements s.a, com.tencent.mm.y.e, Runnable
  {
    public int i;
    public boolean mhk;
    public k oME;
    HashMap<Long, Boolean> oMY;
    HashMap<Long, String> oNc;
    
    public b(k paramk)
    {
      GMTrace.i(7517937598464L, 56013);
      this.i = 0;
      this.oMY = new HashMap();
      this.oNc = new HashMap();
      this.mhk = false;
      this.oME = paramk;
      o.KW().a(this, Looper.getMainLooper());
      ap.vd().a(221, this);
      GMTrace.o(7517937598464L, 56013);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
    {
      GMTrace.i(7518340251648L, 56016);
      if ((paramk instanceof ab))
      {
        ap.vd().b(221, this);
        if (this.oNc != null)
        {
          paramk = this.oNc.entrySet().iterator();
          while (paramk.hasNext())
          {
            paramString = (Map.Entry)paramk.next();
            long l = ((Long)paramString.getKey()).longValue();
            paramString = (String)paramString.getValue();
            if ((l > 0L) && (!((Boolean)this.oMY.get(Long.valueOf(l))).booleanValue()))
            {
              ap.yY();
              com.tencent.mm.u.c.wT().cA(l);
              com.tencent.mm.pluginsdk.model.app.b localb = com.tencent.mm.pluginsdk.model.app.l.Y(paramString, l);
              paramString = null;
              if (localb != null) {
                paramString = localb.field_fileFullPath;
              }
              if ((paramString != null) && (paramString.length() > 0))
              {
                this.oMY.put(Long.valueOf(l), Boolean.valueOf(true));
                paramString = this.oME.field_dataProto.txF.iterator();
                while (paramString.hasNext())
                {
                  rl localrl = (rl)paramString.next();
                  if (localrl.twG == l) {
                    localrl.NY(localb.field_fileFullPath);
                  }
                }
              }
            }
          }
        }
        a(this.oMY, this.mhk, this.oME);
        GMTrace.o(7518340251648L, 56016);
        return;
      }
      a(null, this.mhk, this.oME);
      GMTrace.o(7518340251648L, 56016);
    }
    
    public final void a(s.a.a parama)
    {
      GMTrace.i(7518206033920L, 56015);
      parama = t.lI(parama.fyw);
      if (parama != null)
      {
        ap.yY();
        au localau = com.tencent.mm.u.c.wT().cA(parama.hZW);
        if (parama.Ll())
        {
          this.oMY.put(Long.valueOf(localau.field_msgId), Boolean.valueOf(true));
          a(this.oMY, this.mhk, this.oME);
        }
        GMTrace.o(7518206033920L, 56015);
        return;
      }
      a(null, this.mhk, this.oME);
      GMTrace.o(7518206033920L, 56015);
    }
    
    public final void a(HashMap<Long, Boolean> paramHashMap, boolean paramBoolean, k paramk)
    {
      GMTrace.i(7518474469376L, 56017);
      if (paramHashMap != null)
      {
        paramHashMap = paramHashMap.entrySet().iterator();
        do
        {
          if (!paramHashMap.hasNext()) {
            break;
          }
        } while (Boolean.valueOf(((Boolean)((Map.Entry)paramHashMap.next()).getValue()).booleanValue()).booleanValue());
      }
      for (int j = 0;; j = 1)
      {
        if ((j != 0) && (paramBoolean))
        {
          o.KW().a(this);
          paramk.field_type = 2;
          s.aWx().c(paramk, new String[] { "localId" });
          s.aWz().a(paramk);
        }
        GMTrace.o(7518474469376L, 56017);
        return;
      }
    }
    
    public final void run()
    {
      GMTrace.i(7518071816192L, 56014);
      this.i = 0;
      this.mhk = false;
      Iterator localIterator = this.oME.field_dataProto.txF.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (rl)localIterator.next();
        final long l1 = ((rl)localObject1).twG;
        if (l1 > 0L)
        {
          ap.yY();
          final au localau = com.tencent.mm.u.c.wT().cA(l1);
          final Object localObject2 = ((rl)localObject1).tvY;
          if ((System.currentTimeMillis() - localau.field_createTime > 259200000L) && ((bf.mA((String)localObject2)) || (!com.tencent.mm.a.e.aO((String)localObject2)))) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              break label160;
            }
            v.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", new Object[] { Integer.valueOf(localau.field_type) });
            break;
          }
          label160:
          if (((rl)localObject1).aMw == 2)
          {
            if (localau.bLX())
            {
              localObject2 = com.tencent.mm.ah.n.GT().ai(localau.field_msgSvrId);
              label209:
              Object localObject3;
              long l2;
              long l3;
              if (localau.field_isSend == 1) {
                if (((d)localObject2).GC())
                {
                  j = 1;
                  if ((((d)localObject2).offset >= ((d)localObject2).hrb) && (((d)localObject2).hrb != 0)) {
                    break label383;
                  }
                  this.oMY.put(Long.valueOf(l1), Boolean.valueOf(false));
                  this.i = this.oME.field_dataProto.txF.indexOf(localObject1);
                  localObject3 = com.tencent.mm.ah.n.GU();
                  l2 = ((d)localObject2).hEG;
                  l3 = localau.field_msgId;
                  if (localau.field_isSend != 1) {
                    break label385;
                  }
                }
              }
              label383:
              label385:
              for (int k = R.g.bdI;; k = R.g.bdG)
              {
                ((com.tencent.mm.ah.c)localObject3).a(l2, l3, j, localObject1, k, new c.a()
                {
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
                  {
                    GMTrace.i(7511360929792L, 55964);
                    p.b.this.oMY.put(Long.valueOf(l1), Boolean.valueOf(true));
                    p.b.this.a(p.b.this.oMY, p.b.this.mhk, p.b.this.oME);
                    GMTrace.o(7511360929792L, 55964);
                  }
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.y.k paramAnonymousk)
                  {
                    GMTrace.i(7511092494336L, 55962);
                    GMTrace.o(7511092494336L, 55962);
                  }
                  
                  public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
                  {
                    GMTrace.i(7511226712064L, 55963);
                    boolean bool;
                    if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0))
                    {
                      bool = true;
                      v.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(paramAnonymousInt4) });
                      if (!(paramAnonymousObject instanceof rl)) {
                        break label308;
                      }
                      paramAnonymousObject = (rl)paramAnonymousObject;
                      ((rl)paramAnonymousObject).NY(com.tencent.mm.ah.n.GT().m(com.tencent.mm.ah.e.c(localObject2), "", ""));
                      ((rl)paramAnonymousObject).NZ(com.tencent.mm.ah.n.GT().v(localau.field_imgPath, true));
                      paramAnonymousString = bg.q(localObject2.hER, "msg");
                      if (paramAnonymousString == null) {
                        break label284;
                      }
                      ((rl)paramAnonymousObject).NO((String)paramAnonymousString.get(".msg.img.$cdnbigimgurl"));
                      ((rl)paramAnonymousObject).ej(bf.getInt((String)paramAnonymousString.get(".msg.img.$length"), 0));
                      ((rl)paramAnonymousObject).NP((String)paramAnonymousString.get(".msg.img.$aeskey"));
                      p.b.this.oME.field_dataProto.txF.set(p.b.this.i, paramAnonymousObject);
                      label218:
                      p.b.this.oMY.put(Long.valueOf(((rl)paramAnonymousObject).twG), Boolean.valueOf(true));
                    }
                    for (;;)
                    {
                      p.b.this.a(p.b.this.oMY, p.b.this.mhk, p.b.this.oME);
                      GMTrace.o(7511226712064L, 55963);
                      return;
                      bool = false;
                      break;
                      label284:
                      v.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", new Object[] { localObject2.hER });
                      break label218;
                      label308:
                      p.b.this.oMY.put(Long.valueOf(l1), Boolean.valueOf(true));
                    }
                  }
                });
                break;
                j = 0;
                break label209;
                if (!((d)localObject2).GC())
                {
                  j = 0;
                  break label209;
                }
                localObject3 = com.tencent.mm.ah.e.a((d)localObject2);
                if (!com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GT().m(((d)localObject3).hEH, "", "")))
                {
                  j = 0;
                  break label209;
                }
                j = 1;
                break label209;
                break;
              }
            }
            if (localau.bMf())
            {
              localObject1 = f.a.ek(localau.field_content);
              if (localObject1 == null)
              {
                v.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", new Object[] { localau.field_content });
              }
              else
              {
                if ((bf.mA(((f.a)localObject1).fCN)) && (!bf.mA(((f.a)localObject1).hhn)))
                {
                  v.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", new Object[] { localau.field_content });
                  ((f.a)localObject1).fCN = ((f.a)localObject1).hhn.hashCode();
                }
                localObject1 = ((f.a)localObject1).fCN;
                if (!com.tencent.mm.pluginsdk.model.app.l.a(localau, com.tencent.mm.pluginsdk.model.app.l.Y((String)localObject1, localau.field_msgId)))
                {
                  this.oMY.put(Long.valueOf(localau.field_msgId), Boolean.valueOf(false));
                  this.oNc.put(Long.valueOf(localau.field_msgId), localObject1);
                  com.tencent.mm.pluginsdk.model.app.l.a(localau, null);
                }
              }
            }
          }
          else if ((((rl)localObject1).aMw == 4) || (((rl)localObject1).aMw == 15))
          {
            localObject1 = t.lI(localau.field_imgPath);
            if ((localObject1 != null) && (((r)localObject1).status != 199))
            {
              this.oMY.put(Long.valueOf(l1), Boolean.valueOf(false));
              if (((r)localObject1).Lk())
              {
                v.i("MicroMsg.RecordMsgSendService", "start complete online video");
                t.lM(localau.field_imgPath);
              }
              else
              {
                v.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                t.lE(localau.field_imgPath);
              }
            }
          }
        }
      }
      this.mhk = true;
      p.this.oMH = false;
      a(this.oMY, this.mhk, this.oME);
      GMTrace.o(7518071816192L, 56014);
    }
  }
  
  private final class c
    implements Runnable
  {
    private k oME;
    
    public c(k paramk)
    {
      GMTrace.i(7513911066624L, 55983);
      this.oME = paramk;
      GMTrace.o(7513911066624L, 55983);
    }
    
    public final void run()
    {
      GMTrace.i(7514045284352L, 55984);
      Iterator localIterator = this.oME.field_dataProto.txF.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (rl)localIterator.next();
        fp localfp = new fp();
        localfp.fKg.type = 2;
        localfp.fKg.fKi = ((rl)localObject);
        com.tencent.mm.sdk.b.a.uql.m(localfp);
        v.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[] { ((rl)localObject).lII, Integer.valueOf(((rl)localObject).aMw) });
        if (!bf.mA(localfp.fKh.path))
        {
          String str = m.c((rl)localObject, this.oME.field_msgId);
          v.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[] { localfp.fKh.path, str });
          if (!localfp.fKh.path.equals(str)) {
            j.p(localfp.fKh.path, str, false);
          }
        }
        if (!bf.mA(localfp.fKh.fKq))
        {
          localObject = m.f((rl)localObject, this.oME.field_msgId);
          v.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[] { localfp.fKh.fKq, localObject });
          if (!localfp.fKh.fKq.equals(localObject)) {
            j.p(localfp.fKh.fKq, (String)localObject, false);
          }
        }
      }
      ap.vd().a(new a(this.oME), 0);
      GMTrace.o(7514045284352L, 55984);
    }
  }
  
  private final class d
    implements Runnable
  {
    private k oME;
    
    public d(k paramk)
    {
      GMTrace.i(7512300453888L, 55971);
      this.oME = paramk;
      GMTrace.o(7512300453888L, 55971);
    }
    
    public final void run()
    {
      GMTrace.i(7512434671616L, 55972);
      Iterator localIterator = this.oME.field_dataProto.txF.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        rl localrl = (rl)localIterator.next();
        int k = i;
        String str;
        Object localObject;
        boolean bool;
        if (!bf.mA(localrl.tvA))
        {
          str = m.c(localrl, this.oME.field_oriMsgId);
          localObject = m.c(localrl, this.oME.field_msgId);
          bool = j.p(str, (String)localObject, false);
          v.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[] { str, localObject, Boolean.valueOf(bool) });
          int j = i;
          if (bool)
          {
            if (bf.mA(localrl.tvR))
            {
              v.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
              localrl.NV(com.tencent.mm.a.g.aV((String)localObject));
              i = 1;
            }
            j = i;
            if (bf.mA(localrl.tvT))
            {
              v.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
              localrl.NW(com.tencent.mm.a.g.aW((String)localObject));
              j = 1;
            }
          }
          str = m.d(localrl.lII, this.oME.field_msgId, false);
          k = j;
          if (s.aWy().Dm(str) == null)
          {
            localObject = new g();
            ((g)localObject).field_cdnKey = localrl.tvC;
            ((g)localObject).field_cdnUrl = localrl.tvA;
            ((g)localObject).field_dataId = localrl.lII;
            ((g)localObject).field_mediaId = str;
            ((g)localObject).field_totalLen = ((int)localrl.tvV);
            ((g)localObject).field_localId = ((g)localObject).field_mediaId.hashCode();
            ((g)localObject).field_path = m.c(localrl, this.oME.field_msgId);
            ((g)localObject).field_type = 2;
            ((g)localObject).field_fileType = m.rO(localrl.aMw);
            ((g)localObject).field_recordLocalId = this.oME.field_localId;
            ((g)localObject).field_toUser = this.oME.field_toUser;
            ((g)localObject).field_isThumb = false;
            bool = s.aWy().a((g)localObject);
            v.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(((g)localObject).field_localId), Boolean.valueOf(bool) });
            k = j;
          }
        }
        i = k;
        if (!bf.mA(localrl.hho))
        {
          str = m.f(localrl, this.oME.field_oriMsgId);
          localObject = m.f(localrl, this.oME.field_msgId);
          v.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[] { str, localObject, Boolean.valueOf(j.p(str, (String)localObject, false)) });
          str = m.vV(localrl.lII);
          localObject = m.d(str, this.oME.field_msgId, false);
          i = k;
          if (s.aWy().Dm((String)localObject) == null)
          {
            g localg = new g();
            localg.field_cdnKey = localrl.tvw;
            localg.field_cdnUrl = localrl.hho;
            localg.field_dataId = str;
            localg.field_mediaId = ((String)localObject);
            localg.field_totalLen = ((int)localrl.twg);
            localg.field_localId = localg.field_mediaId.hashCode();
            localg.field_path = m.f(localrl, this.oME.field_msgId);
            localg.field_type = 2;
            localg.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
            localg.field_recordLocalId = this.oME.field_localId;
            localg.field_toUser = this.oME.field_toUser;
            localg.field_isThumb = true;
            bool = s.aWy().a(localg);
            v.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localg.field_localId), Boolean.valueOf(bool) });
            i = k;
          }
        }
      }
      if (i != 0)
      {
        v.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[] { Integer.valueOf(this.oME.field_localId), Long.valueOf(this.oME.field_msgId), Integer.valueOf(this.oME.field_type) });
        s.aWx().c(this.oME, new String[] { "localId" });
      }
      s.aWA().run();
      GMTrace.o(7512434671616L, 55972);
    }
  }
  
  private static final class e
  {
    int ihB;
    long oMN;
    
    public e()
    {
      GMTrace.i(7500355076096L, 55882);
      this.oMN = SystemClock.elapsedRealtime();
      this.ihB = 3;
      GMTrace.o(7500355076096L, 55882);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/record/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */