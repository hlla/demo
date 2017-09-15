package com.tencent.mm.plugin.record.a;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.a;
import com.tencent.mm.e.a.qy;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class m
{
  private static final com.tencent.mm.a.f<Integer, com.tencent.mm.protocal.b.a.c> hjT;
  
  static
  {
    GMTrace.i(7510824058880L, 55960);
    hjT = new com.tencent.mm.a.f(32);
    GMTrace.o(7510824058880L, 55960);
  }
  
  public static com.tencent.mm.protocal.b.a.c Dn(String paramString)
  {
    GMTrace.i(7509884534784L, 55953);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.RecordMsgLogic", "xml is null");
      GMTrace.o(7509884534784L, 55953);
      return null;
    }
    int i = paramString.hashCode();
    Object localObject = (com.tencent.mm.protocal.b.a.c)hjT.get(Integer.valueOf(i));
    if (localObject != null)
    {
      v.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
      GMTrace.o(7509884534784L, 55953);
      return (com.tencent.mm.protocal.b.a.c)localObject;
    }
    if (paramString.trim().startsWith("<recordinfo>")) {}
    for (localObject = bg.q(paramString, "recordinfo"); localObject == null; localObject = bg.q("<recordinfo>" + paramString + "</recordinfo>", "recordinfo"))
    {
      v.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[] { paramString });
      GMTrace.o(7509884534784L, 55953);
      return null;
    }
    com.tencent.mm.protocal.b.a.c localc = new com.tencent.mm.protocal.b.a.c();
    localc.title = ((String)((Map)localObject).get(".recordinfo.title"));
    localc.desc = ((String)((Map)localObject).get(".recordinfo.desc"));
    localc.sZz = ((String)((Map)localObject).get(".recordinfo.favusername"));
    a(paramString, localc);
    hjT.put(Integer.valueOf(i), localc);
    GMTrace.o(7509884534784L, 55953);
    return localc;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, List<au> paramList, cb paramcb, com.tencent.mm.protocal.b.a.d paramd)
  {
    GMTrace.i(7508139704320L, 55940);
    if (bf.mA(paramString1))
    {
      v.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      GMTrace.o(7508139704320L, 55940);
      return -1;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      v.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      GMTrace.o(7508139704320L, 55940);
      return -1;
    }
    com.tencent.mm.protocal.b.a.d locald;
    if (paramcb != null)
    {
      locald = paramd;
      if (paramd != null) {}
    }
    else
    {
      paramcb = new cb();
      if (!com.tencent.mm.pluginsdk.model.g.a(paramContext, paramcb, paramString2, paramList, true))
      {
        GMTrace.o(7508139704320L, 55940);
        return -1;
      }
      locald = a(paramContext, paramcb, paramString2);
    }
    paramList = a(locald.title, locald.desc, paramcb.fFr.fFt.txF);
    paramd = new au();
    paramString2 = null;
    if (!bf.mA(locald.fKq))
    {
      paramContext = bf.readFromFile(locald.fKq);
      if (paramContext != null) {
        if (paramContext.length <= 32768) {
          break label443;
        }
      }
    }
    long l;
    int i;
    label443:
    for (paramContext = com.tencent.mm.ah.n.GT().a(paramContext, false, Bitmap.CompressFormat.JPEG);; paramContext = com.tencent.mm.ah.n.GT().f(8, paramContext))
    {
      v.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " thumbData MsgInfo path:" + paramContext);
      if (!bf.mA(paramContext)) {
        paramd.cI(paramContext);
      }
      paramd.setContent(f.a.a(paramList, null, null));
      paramd.dv(1);
      paramd.cH(paramString1);
      paramd.z(ay.gk(paramString1));
      paramd.dw(1);
      paramd.setType(49);
      if (com.tencent.mm.modelbiz.e.dr(paramString1)) {
        paramd.cN(com.tencent.mm.modelbiz.a.e.zz());
      }
      ap.yY();
      l = com.tencent.mm.u.c.wT().L(paramd);
      v.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label456;
      }
      v.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + "insert msg failed :" + l);
      i = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(7508139704320L, 55940);
      return 0 - i;
      paramContext = paramString2;
      if (locald.fSZ != 0) {
        break;
      }
      paramContext = paramString2;
      if (bf.mA(locald.lCI)) {
        break;
      }
      paramContext = com.tencent.mm.sdk.platformtools.d.K(com.tencent.mm.x.b.a(locald.lCI, false, -1));
      break;
    }
    label456:
    v.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sb() + " new msg inserted to db , local id = " + l);
    paramd.x(l);
    paramContext = new com.tencent.mm.t.f();
    paramContext.field_xml = paramd.field_content;
    paramContext.field_title = paramList.title;
    paramContext.field_type = paramList.type;
    paramContext.field_description = paramList.description;
    paramContext.field_msgId = l;
    an.bDc().b(paramContext);
    paramContext = paramcb.fFr.fFt.txF.iterator();
    for (boolean bool = false; paramContext.hasNext(); bool = true)
    {
      label568:
      paramString2 = (rl)paramContext.next();
      paramd = paramString2.toString();
      i = paramString2.aMw;
      paramString2.NX(com.tencent.mm.a.g.n((paramd + i + System.currentTimeMillis()).getBytes()));
      if ((!bool) && (!com.tencent.mm.a.e.aO(paramString2.tvY)) && (!com.tencent.mm.a.e.aO(paramString2.twa)) && (bf.mA(paramString2.tvA)) && (bf.mA(paramString2.hho))) {
        break label568;
      }
    }
    v.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      paramContext = new k();
      paramContext.field_msgId = l;
      paramContext.field_title = paramList.title;
      paramContext.field_desc = paramList.description;
      paramContext.field_toUser = paramString1;
      paramContext.field_dataProto = paramcb.fFr.fFt;
      paramContext.field_type = 3;
      paramContext.field_localId = (new Random().nextInt(2147483645) + 1);
      v.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(s.aWx().b(paramContext)), Long.valueOf(l), Integer.valueOf(paramContext.field_localId) });
      s.aWz().a(paramContext);
    }
    for (;;)
    {
      GMTrace.o(7508139704320L, 55940);
      return 0;
      v.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[] { Long.valueOf(l) });
      an.bDe();
      am.a.eg(l);
    }
  }
  
  public static int a(String paramString1, ru paramru, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    GMTrace.i(7508676575232L, 55944);
    if (bf.mA(paramString1))
    {
      v.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      GMTrace.o(7508676575232L, 55944);
      return -1;
    }
    if ((paramru == null) || (paramru.txF.isEmpty()))
    {
      v.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
      GMTrace.o(7508676575232L, 55944);
      return -1;
    }
    paramString3 = a(paramString2, paramString3, paramru.txF);
    au localau = new au();
    paramString2 = null;
    if (!bf.mA(paramString4))
    {
      paramString2 = bf.readFromFile(paramString4);
      if (paramString2 != null) {
        if (paramString2.length <= 32768) {
          break label373;
        }
      }
    }
    long l;
    label373:
    for (paramString2 = com.tencent.mm.ah.n.GT().a(paramString2, false, Bitmap.CompressFormat.JPEG);; paramString2 = com.tencent.mm.ah.n.GT().f(8, paramString2))
    {
      v.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " thumbData MsgInfo path:" + paramString2);
      if (!bf.mA(paramString2)) {
        localau.cI(paramString2);
      }
      localau.setContent(f.a.a(paramString3, null, null));
      localau.dv(1);
      localau.cH(paramString1);
      localau.z(ay.gk(paramString1));
      localau.dw(1);
      localau.setType(49);
      if (com.tencent.mm.modelbiz.e.dr(paramString1)) {
        localau.cN(com.tencent.mm.modelbiz.a.e.zz());
      }
      ap.yY();
      l = com.tencent.mm.u.c.wT().L(localau);
      v.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " msginfo insert id: " + l);
      if (l >= 0L) {
        break label386;
      }
      v.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + "insert msg failed :" + l);
      paramInt = com.tencent.mm.compatible.util.g.sb();
      GMTrace.o(7508676575232L, 55944);
      return 0 - paramInt;
      if (paramInt != 0)
      {
        paramString2 = com.tencent.mm.sdk.platformtools.d.K(com.tencent.mm.sdk.platformtools.d.yk(paramInt));
        break;
      }
      if (bf.mA(paramString5)) {
        break;
      }
      paramString2 = com.tencent.mm.sdk.platformtools.d.K(com.tencent.mm.x.b.a(paramString5, false, -1));
      break;
    }
    label386:
    v.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sb() + " new msg inserted to db , local id = " + l);
    localau.x(l);
    paramString2 = new com.tencent.mm.t.f();
    paramString2.field_xml = localau.field_content;
    paramString2.field_title = paramString3.title;
    paramString2.field_type = paramString3.type;
    paramString2.field_description = paramString3.description;
    paramString2.field_msgId = l;
    an.bDc().b(paramString2);
    paramString2 = paramru.txF.iterator();
    do
    {
      if (!paramString2.hasNext()) {
        break;
      }
      paramString4 = (rl)paramString2.next();
    } while ((bf.mA(paramString4.tvA)) && (bf.mA(paramString4.hho)));
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt != 0) || (com.tencent.mm.pluginsdk.model.c.sAx))
      {
        paramString2 = new k();
        paramString2.field_msgId = l;
        paramString2.field_title = paramString3.title;
        paramString2.field_desc = paramString3.description;
        paramString2.field_toUser = paramString1;
        paramString2.field_dataProto = paramru;
        paramString2.field_type = 1;
        paramString2.field_localId = (new Random().nextInt(2147483645) + 1);
        s.aWx().b(paramString2);
        s.aWz().a(paramString2);
      }
      for (;;)
      {
        GMTrace.o(7508676575232L, 55944);
        return 0;
        v.d("MicroMsg.RecordMsgLogic", "do not trans cdn, directly send msg");
        an.bDe();
        am.a.eg(l);
      }
    }
  }
  
  public static int a(String paramString1, String paramString2, au paramau)
  {
    GMTrace.i(7508542357504L, 55943);
    if (bf.mA(paramString1))
    {
      v.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
      GMTrace.o(7508542357504L, 55943);
      return -1;
    }
    if ((paramau == null) || (bf.mA(paramau.field_content)))
    {
      v.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
      GMTrace.o(7508542357504L, 55943);
      return -1;
    }
    if (1 == paramau.field_status)
    {
      v.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
      GMTrace.o(7508542357504L, 55943);
      return -1;
    }
    paramString1 = bf.f(paramString1.split(",")).iterator();
    String str;
    Object localObject2;
    f.a locala;
    com.tencent.mm.protocal.b.a.c localc;
    Object localObject1;
    long l;
    if (paramString1.hasNext())
    {
      str = (String)paramString1.next();
      v.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[] { str, Long.valueOf(paramau.field_msgId), Integer.valueOf(paramau.field_status) });
      localObject2 = ay.gj(paramau.field_content);
      locala = f.a.ek((String)localObject2);
      if (locala == null)
      {
        v.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
        GMTrace.o(7508542357504L, 55943);
        return -1;
      }
      localc = Dn(locala.hhG);
      if (localc == null)
      {
        v.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
        GMTrace.o(7508542357504L, 55943);
        return -1;
      }
      localObject1 = new au();
      if (!bf.mA(paramau.field_imgPath))
      {
        Object localObject3 = bf.readFromFile(com.tencent.mm.ah.n.GT().v(paramau.field_imgPath, true));
        localObject3 = com.tencent.mm.ah.n.GT().f(8, (byte[])localObject3);
        v.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " thumbData from msg MsgInfo path:" + (String)localObject3);
        if (!bf.mA((String)localObject3)) {
          ((au)localObject1).cI((String)localObject3);
        }
      }
      ((au)localObject1).setContent((String)localObject2);
      ((au)localObject1).dv(1);
      ((au)localObject1).cH(str);
      ((au)localObject1).z(ay.gk(str));
      ((au)localObject1).dw(1);
      ((au)localObject1).setType(49);
      ap.yY();
      l = com.tencent.mm.u.c.wT().L((au)localObject1);
      v.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " msginfo insert id: " + l);
      if (l < 0L)
      {
        v.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + "insert msg failed :" + l);
        i = com.tencent.mm.compatible.util.g.sb();
        GMTrace.o(7508542357504L, 55943);
        return 0 - i;
      }
      v.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sb() + " new msg inserted to db , local id = " + l);
      ((au)localObject1).x(l);
      localObject2 = new qy();
      ((qy)localObject2).fXL.fXM = paramau.field_msgId;
      ((qy)localObject2).fXL.fXN = l;
      a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      localObject2 = new com.tencent.mm.t.f();
      ((com.tencent.mm.t.f)localObject2).field_xml = ((ce)localObject1).field_content;
      ((com.tencent.mm.t.f)localObject2).field_title = locala.title;
      ((com.tencent.mm.t.f)localObject2).field_type = locala.type;
      ((com.tencent.mm.t.f)localObject2).field_description = locala.description;
      ((com.tencent.mm.t.f)localObject2).field_msgId = l;
      an.bDc().b((com.tencent.mm.sdk.e.c)localObject2);
      localObject1 = localc.hkc.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (rl)((Iterator)localObject1).next();
      } while ((bf.mA(((rl)localObject2).tvA)) && (bf.mA(((rl)localObject2).hho)));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = new k();
        localObject2 = new ru();
        ((ru)localObject2).txF.addAll(localc.hkc);
        ((k)localObject1).field_msgId = l;
        ((k)localObject1).field_oriMsgId = paramau.field_msgId;
        ((k)localObject1).field_toUser = str;
        ((k)localObject1).field_title = locala.title;
        ((k)localObject1).field_desc = locala.description;
        ((k)localObject1).field_dataProto = ((ru)localObject2);
        ((k)localObject1).field_type = 0;
        ((k)localObject1).field_favFrom = localc.sZz;
        ((k)localObject1).field_localId = (new Random().nextInt(2147483645) + 1);
        s.aWx().b((com.tencent.mm.sdk.e.c)localObject1);
        s.aWz().a((k)localObject1);
      }
      for (;;)
      {
        if (bf.mA(paramString2)) {
          break label864;
        }
        com.tencent.mm.plugin.messenger.a.d.aJP().A(str, paramString2, com.tencent.mm.u.o.fG(str));
        break;
        v.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
        an.bDe();
        am.a.eg(l);
      }
      label864:
      break;
      GMTrace.o(7508542357504L, 55943);
      return 0;
    }
  }
  
  public static com.tencent.mm.protocal.b.a.d a(Context paramContext, cb paramcb, String paramString)
  {
    GMTrace.i(7508273922048L, 55941);
    com.tencent.mm.protocal.b.a.d locald = new com.tencent.mm.protocal.b.a.d();
    Object localObject1 = new SparseIntArray();
    int i;
    Object localObject2;
    if (com.tencent.mm.modelbiz.e.dr(paramString))
    {
      locald.title = paramcb.fFr.fFt.title;
      v.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[] { locald.title });
      i = 0;
      paramString = new LinkedList();
      if (paramcb.fFr.fFt == null) {
        break label398;
      }
      paramcb = paramcb.fFr.fFt.txF;
      localObject2 = paramcb.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label1397;
      }
      Object localObject3 = (rl)((Iterator)localObject2).next();
      int j = ((SparseIntArray)localObject1).get(((rl)localObject3).aMw);
      ((SparseIntArray)localObject1).put(((rl)localObject3).aMw, j + 1);
      switch (((rl)localObject3).aMw)
      {
      case 9: 
      case 12: 
      case 13: 
      default: 
        break;
      case 1: 
        if (paramString.size() < 5)
        {
          paramString.add(((rl)localObject3).tww + ":" + ((rl)localObject3).desc + "\n");
          continue;
          if (com.tencent.mm.u.o.dH(paramString))
          {
            locald.title = paramContext.getString(R.l.eIx);
            break;
          }
          localObject2 = com.tencent.mm.u.m.xN();
          paramString = com.tencent.mm.u.n.eJ(paramString);
          if (((String)localObject2).equals(paramString))
          {
            locald.title = paramContext.getString(R.l.eiU, new Object[] { localObject2 });
            break;
          }
          locald.title = paramContext.getString(R.l.eiT, new Object[] { localObject2, paramString });
          break;
          paramcb = new LinkedList();
        }
        break;
      case 3: 
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dIQ) + "\n");
        }
        break;
      case 2: 
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dIa) + "\n");
        }
        if (i == 0)
        {
          a(locald, (rl)localObject3, R.g.bbX);
          i = 1;
        }
        break;
      case 5: 
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dIM) + ((rl)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (rl)localObject3, R.k.dtk);
          i = 1;
        }
        break;
      case 15: 
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dIP) + "\n");
        }
        if (i == 0)
        {
          a(locald, (rl)localObject3, R.k.dth);
          i = 1;
        }
        break;
      case 4: 
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dIP) + "\n");
        }
        if (i == 0)
        {
          a(locald, (rl)localObject3, R.k.dth);
          i = 1;
        }
        break;
      case 6: 
        if (paramString.size() < 5)
        {
          paramcb = ((rl)localObject3).twu.twO;
          localObject3 = new StringBuilder().append(((rl)localObject3).tww).append(":").append(paramContext.getString(R.l.dHt));
          if ((!bf.mA(paramcb.fRN)) && (!paramcb.fRN.equals(paramContext.getString(R.l.ewq)))) {
            break label904;
          }
        }
        for (paramcb = paramcb.label;; paramcb = paramcb.fRN)
        {
          paramString.add(paramcb + "\n");
          if (i != 0) {
            break;
          }
          locald.fSZ = R.k.dsV;
          i = 1;
          break;
        }
      case 7: 
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dHA) + ((rl)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (rl)localObject3, R.k.dsW);
          i = 1;
        }
        break;
      case 8: 
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dHf) + ((rl)localObject3).title + "\n");
        }
        if (i == 0)
        {
          a(locald, (rl)localObject3, R.k.dte);
          i = 1;
        }
        break;
      case 10: 
      case 11: 
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dIc) + ((rl)localObject3).twu.twS.title + "\n");
        }
        if (i == 0)
        {
          a(locald, (rl)localObject3, R.k.dte);
          i = 1;
        }
        break;
      case 14: 
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dDe) + "\n");
        }
        if (i == 0)
        {
          a(locald, (rl)localObject3, R.k.dte);
          i = 1;
        }
        break;
      case 16: 
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dHj) + "\n");
        }
        if (i == 0)
        {
          ap.yY();
          locald.lCI = com.tencent.mm.u.c.wT().At(((rl)localObject3).desc).rTh;
          i = 1;
        }
        break;
      case 17: 
        label398:
        label904:
        if (paramString.size() < 5) {
          paramString.add(((rl)localObject3).tww + ":" + paramContext.getString(R.l.dIj) + "\n");
        }
        break;
      }
    }
    label1397:
    locald.desc = "";
    paramcb = paramString.iterator();
    for (paramContext = ""; paramcb.hasNext(); paramContext = paramContext + (String)localObject1) {
      localObject1 = (String)paramcb.next();
    }
    paramcb = paramContext.trim();
    paramContext = paramcb;
    if (paramString.size() >= 5) {
      paramContext = paramcb + "...";
    }
    locald.desc = paramContext;
    GMTrace.o(7508273922048L, 55941);
    return locald;
  }
  
  public static f.a a(String paramString1, String paramString2, List<rl> paramList)
  {
    GMTrace.i(7508005486592L, 55939);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bf.PV(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bf.PV(paramString2)).append("</desc>");
    localStringBuilder.append(n.ar(paramList));
    localStringBuilder.append("<favusername>").append(bf.PV(com.tencent.mm.u.m.xL())).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    f.a locala = new f.a();
    locala.title = paramString1;
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 200) {
        paramString1 = paramString2.substring(0, 200);
      }
    }
    locala.description = paramString1;
    if ((!bf.bV(paramList)) && (!bf.mA(((rl)paramList.get(0)).tvP)) && (((rl)paramList.get(0)).tvP.equals(".htm"))) {
      locala.type = 24;
    }
    for (locala.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; locala.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      locala.action = "view";
      locala.hhG = localStringBuilder.toString();
      GMTrace.o(7508005486592L, 55939);
      return locala;
      locala.type = 19;
    }
  }
  
  private static void a(com.tencent.mm.protocal.b.a.d paramd, rl paramrl, int paramInt)
  {
    GMTrace.i(7508408139776L, 55942);
    paramrl = paramrl.twa;
    if (com.tencent.mm.a.e.aO(paramrl))
    {
      paramd.fKq = paramrl;
      GMTrace.o(7508408139776L, 55942);
      return;
    }
    paramd.fSZ = paramInt;
    GMTrace.o(7508408139776L, 55942);
  }
  
  /* Error */
  private static void a(String paramString, com.tencent.mm.protocal.b.a.c paramc)
  {
    // Byte code:
    //   0: ldc2_w 867
    //   3: ldc_w 869
    //   6: invokestatic 18	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_1
    //   10: getfield 603	com/tencent/mm/protocal/b/a/c:hkc	Ljava/util/LinkedList;
    //   13: invokevirtual 872	java/util/LinkedList:clear	()V
    //   16: invokestatic 878	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 882	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   26: new 884	org/xml/sax/InputSource
    //   29: dup
    //   30: new 886	java/io/ByteArrayInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 406	java/lang/String:getBytes	()[B
    //   38: invokespecial 889	java/io/ByteArrayInputStream:<init>	([B)V
    //   41: invokespecial 892	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   44: invokevirtual 898	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
    //   47: astore_0
    //   48: aload_0
    //   49: invokeinterface 903 1 0
    //   54: aload_0
    //   55: invokeinterface 907 1 0
    //   60: ldc_w 909
    //   63: invokeinterface 915 2 0
    //   68: astore_0
    //   69: aload_0
    //   70: ifnull +2963 -> 3033
    //   73: aload_0
    //   74: iconst_0
    //   75: invokeinterface 921 2 0
    //   80: invokeinterface 927 1 0
    //   85: astore 7
    //   87: aload 7
    //   89: ifnull +2944 -> 3033
    //   92: aload 7
    //   94: invokeinterface 930 1 0
    //   99: ifle +2934 -> 3033
    //   102: aload 7
    //   104: invokeinterface 930 1 0
    //   109: istore_3
    //   110: iconst_0
    //   111: istore_2
    //   112: iload_2
    //   113: iload_3
    //   114: if_icmpge +2919 -> 3033
    //   117: aload 7
    //   119: iload_2
    //   120: invokeinterface 921 2 0
    //   125: astore 4
    //   127: aload 4
    //   129: invokestatic 933	com/tencent/mm/sdk/platformtools/bg:b	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   132: astore_0
    //   133: aload 4
    //   135: checkcast 911	org/w3c/dom/Element
    //   138: ldc_w 935
    //   141: invokeinterface 915 2 0
    //   146: astore 4
    //   148: aload 4
    //   150: ifnull +2898 -> 3048
    //   153: aload 4
    //   155: invokeinterface 930 1 0
    //   160: ifle +2888 -> 3048
    //   163: aload 4
    //   165: iconst_0
    //   166: invokeinterface 921 2 0
    //   171: invokeinterface 939 1 0
    //   176: invokestatic 933	com/tencent/mm/sdk/platformtools/bg:b	(Lorg/w3c/dom/Node;)Ljava/lang/String;
    //   179: astore 4
    //   181: aload_0
    //   182: invokevirtual 78	java/lang/String:trim	()Ljava/lang/String;
    //   185: ldc_w 941
    //   188: invokevirtual 83	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   191: ifeq +2852 -> 3043
    //   194: aload_0
    //   195: ldc_w 943
    //   198: invokestatic 91	com/tencent/mm/sdk/platformtools/bg:q	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   201: astore_0
    //   202: new 392	com/tencent/mm/protocal/c/rl
    //   205: dup
    //   206: invokespecial 944	com/tencent/mm/protocal/c/rl:<init>	()V
    //   209: astore 8
    //   211: aload 8
    //   213: aload_0
    //   214: new 98	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 946
    //   224: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc_w 948
    //   230: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokeinterface 117 2 0
    //   241: checkcast 53	java/lang/String
    //   244: iconst_0
    //   245: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   248: invokevirtual 956	com/tencent/mm/protocal/c/rl:xW	(I)Lcom/tencent/mm/protocal/c/rl;
    //   251: pop
    //   252: aload 8
    //   254: aload_0
    //   255: new 98	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 946
    //   265: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 958
    //   271: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokeinterface 117 2 0
    //   282: checkcast 53	java/lang/String
    //   285: invokevirtual 961	com/tencent/mm/protocal/c/rl:Oc	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   288: pop
    //   289: aload 8
    //   291: aload_0
    //   292: new 98	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 946
    //   302: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 963
    //   308: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokeinterface 117 2 0
    //   319: checkcast 53	java/lang/String
    //   322: iconst_0
    //   323: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   326: invokevirtual 966	com/tencent/mm/protocal/c/rl:xX	(I)Lcom/tencent/mm/protocal/c/rl;
    //   329: pop
    //   330: aload 8
    //   332: aload_0
    //   333: new 98	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 946
    //   343: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc_w 968
    //   349: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokeinterface 117 2 0
    //   360: checkcast 53	java/lang/String
    //   363: invokevirtual 971	com/tencent/mm/protocal/c/rl:NU	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   366: pop
    //   367: aload 8
    //   369: aload_0
    //   370: new 98	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 946
    //   380: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 973
    //   386: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokeinterface 117 2 0
    //   397: checkcast 53	java/lang/String
    //   400: invokevirtual 976	com/tencent/mm/protocal/c/rl:NK	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   403: pop
    //   404: aload 8
    //   406: aload_0
    //   407: new 98	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 946
    //   417: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc_w 978
    //   423: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokeinterface 117 2 0
    //   434: checkcast 53	java/lang/String
    //   437: invokevirtual 981	com/tencent/mm/protocal/c/rl:NL	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   440: pop
    //   441: aload 8
    //   443: aload_0
    //   444: new 98	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   451: ldc_w 946
    //   454: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: ldc_w 983
    //   460: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokeinterface 117 2 0
    //   471: checkcast 53	java/lang/String
    //   474: invokevirtual 986	com/tencent/mm/protocal/c/rl:NM	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   477: pop
    //   478: aload 8
    //   480: aload_0
    //   481: new 98	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 946
    //   491: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 988
    //   497: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokeinterface 117 2 0
    //   508: checkcast 53	java/lang/String
    //   511: invokevirtual 991	com/tencent/mm/protocal/c/rl:NN	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   514: pop
    //   515: aload 8
    //   517: aload_0
    //   518: new 98	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   525: ldc_w 946
    //   528: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: ldc_w 993
    //   534: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokeinterface 117 2 0
    //   545: checkcast 53	java/lang/String
    //   548: iconst_0
    //   549: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   552: invokevirtual 996	com/tencent/mm/protocal/c/rl:xT	(I)Lcom/tencent/mm/protocal/c/rl;
    //   555: pop
    //   556: aload 8
    //   558: aload_0
    //   559: new 98	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 946
    //   569: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: ldc_w 998
    //   575: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokeinterface 117 2 0
    //   586: checkcast 53	java/lang/String
    //   589: iconst_0
    //   590: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   593: invokevirtual 1001	com/tencent/mm/protocal/c/rl:xU	(I)Lcom/tencent/mm/protocal/c/rl;
    //   596: pop
    //   597: aload 8
    //   599: aload_0
    //   600: new 98	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   607: ldc_w 946
    //   610: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: ldc_w 1003
    //   616: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokeinterface 117 2 0
    //   627: checkcast 53	java/lang/String
    //   630: invokevirtual 1006	com/tencent/mm/protocal/c/rl:NO	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   633: pop
    //   634: aload 8
    //   636: aload_0
    //   637: new 98	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   644: ldc_w 946
    //   647: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: ldc_w 1008
    //   653: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokeinterface 117 2 0
    //   664: checkcast 53	java/lang/String
    //   667: invokevirtual 1011	com/tencent/mm/protocal/c/rl:NP	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   670: pop
    //   671: aload_0
    //   672: new 98	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   679: ldc_w 946
    //   682: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: ldc_w 1013
    //   688: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokeinterface 117 2 0
    //   699: checkcast 53	java/lang/String
    //   702: astore 5
    //   704: aload 5
    //   706: ifnull +23 -> 729
    //   709: aload 5
    //   711: invokevirtual 832	java/lang/String:length	()I
    //   714: ifle +15 -> 729
    //   717: aload 8
    //   719: aload 5
    //   721: iconst_0
    //   722: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   725: invokevirtual 1016	com/tencent/mm/protocal/c/rl:xV	(I)Lcom/tencent/mm/protocal/c/rl;
    //   728: pop
    //   729: aload 8
    //   731: aload_0
    //   732: new 98	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   739: ldc_w 946
    //   742: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: ldc_w 1018
    //   748: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokeinterface 117 2 0
    //   759: checkcast 53	java/lang/String
    //   762: invokevirtual 1021	com/tencent/mm/protocal/c/rl:NR	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   765: pop
    //   766: aload 8
    //   768: aload_0
    //   769: new 98	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   776: ldc_w 946
    //   779: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: ldc_w 1023
    //   785: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: invokeinterface 117 2 0
    //   796: checkcast 53	java/lang/String
    //   799: invokevirtual 1026	com/tencent/mm/protocal/c/rl:NS	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   802: pop
    //   803: aload 8
    //   805: aload_0
    //   806: new 98	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   813: ldc_w 946
    //   816: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: ldc_w 1028
    //   822: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokeinterface 117 2 0
    //   833: checkcast 53	java/lang/String
    //   836: invokevirtual 1031	com/tencent/mm/protocal/c/rl:NQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   839: pop
    //   840: aload 8
    //   842: aload_0
    //   843: new 98	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   850: ldc_w 946
    //   853: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: ldc_w 1033
    //   859: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokeinterface 117 2 0
    //   870: checkcast 53	java/lang/String
    //   873: invokevirtual 1036	com/tencent/mm/protocal/c/rl:NV	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   876: pop
    //   877: aload 8
    //   879: aload_0
    //   880: new 98	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   887: ldc_w 946
    //   890: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: ldc_w 1038
    //   896: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokeinterface 117 2 0
    //   907: checkcast 53	java/lang/String
    //   910: invokevirtual 1041	com/tencent/mm/protocal/c/rl:NW	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   913: pop
    //   914: aload_0
    //   915: new 98	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   922: ldc_w 946
    //   925: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: ldc_w 1043
    //   931: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: invokeinterface 117 2 0
    //   942: checkcast 53	java/lang/String
    //   945: astore 5
    //   947: aload 5
    //   949: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   952: ifne +16 -> 968
    //   955: aload 8
    //   957: aload 5
    //   959: iconst_0
    //   960: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   963: i2l
    //   964: invokevirtual 1047	com/tencent/mm/protocal/c/rl:ej	(J)Lcom/tencent/mm/protocal/c/rl;
    //   967: pop
    //   968: aload 8
    //   970: aload_0
    //   971: new 98	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   978: ldc_w 946
    //   981: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: ldc_w 1049
    //   987: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   993: invokeinterface 117 2 0
    //   998: checkcast 53	java/lang/String
    //   1001: invokevirtual 1052	com/tencent/mm/protocal/c/rl:NT	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1004: pop
    //   1005: aload 8
    //   1007: aload_0
    //   1008: new 98	java/lang/StringBuilder
    //   1011: dup
    //   1012: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1015: ldc_w 946
    //   1018: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: ldc_w 1054
    //   1024: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: invokeinterface 117 2 0
    //   1035: checkcast 53	java/lang/String
    //   1038: invokevirtual 1057	com/tencent/mm/protocal/c/rl:Oa	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1041: pop
    //   1042: aload 8
    //   1044: aload_0
    //   1045: new 98	java/lang/StringBuilder
    //   1048: dup
    //   1049: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1052: ldc_w 946
    //   1055: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: ldc_w 1059
    //   1061: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokeinterface 117 2 0
    //   1072: checkcast 53	java/lang/String
    //   1075: invokevirtual 1062	com/tencent/mm/protocal/c/rl:Ob	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1078: pop
    //   1079: aload_0
    //   1080: new 98	java/lang/StringBuilder
    //   1083: dup
    //   1084: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1087: ldc_w 946
    //   1090: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: ldc_w 1064
    //   1096: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokeinterface 117 2 0
    //   1107: checkcast 53	java/lang/String
    //   1110: astore 5
    //   1112: aload 5
    //   1114: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   1117: ifne +16 -> 1133
    //   1120: aload 8
    //   1122: aload 5
    //   1124: iconst_0
    //   1125: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   1128: i2l
    //   1129: invokevirtual 1066	com/tencent/mm/protocal/c/rl:ek	(J)Lcom/tencent/mm/protocal/c/rl;
    //   1132: pop
    //   1133: aload 8
    //   1135: aload_0
    //   1136: new 98	java/lang/StringBuilder
    //   1139: dup
    //   1140: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1143: ldc_w 946
    //   1146: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: ldc_w 1068
    //   1152: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1158: invokeinterface 117 2 0
    //   1163: checkcast 53	java/lang/String
    //   1166: invokevirtual 1071	com/tencent/mm/protocal/c/rl:Od	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1169: pop
    //   1170: aload_0
    //   1171: new 98	java/lang/StringBuilder
    //   1174: dup
    //   1175: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1178: ldc_w 946
    //   1181: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: ldc_w 1073
    //   1187: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1193: invokeinterface 117 2 0
    //   1198: checkcast 53	java/lang/String
    //   1201: astore 6
    //   1203: aload 6
    //   1205: astore 5
    //   1207: aload 6
    //   1209: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   1212: ifeq +9 -> 1221
    //   1215: iload_2
    //   1216: invokestatic 1075	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1219: astore 5
    //   1221: aload 8
    //   1223: aload 5
    //   1225: invokevirtual 416	com/tencent/mm/protocal/c/rl:NX	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1228: pop
    //   1229: aload_0
    //   1230: new 98	java/lang/StringBuilder
    //   1233: dup
    //   1234: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1237: ldc_w 946
    //   1240: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: ldc_w 1077
    //   1246: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1252: invokeinterface 117 2 0
    //   1257: checkcast 53	java/lang/String
    //   1260: astore 5
    //   1262: aload 5
    //   1264: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   1267: ifne +11 -> 1278
    //   1270: aload 8
    //   1272: aload 5
    //   1274: invokevirtual 1080	com/tencent/mm/protocal/c/rl:Oh	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1277: pop
    //   1278: aload 8
    //   1280: aload_0
    //   1281: new 98	java/lang/StringBuilder
    //   1284: dup
    //   1285: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1288: ldc_w 946
    //   1291: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: ldc_w 1082
    //   1297: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: invokeinterface 117 2 0
    //   1308: checkcast 53	java/lang/String
    //   1311: iconst_0
    //   1312: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   1315: invokevirtual 1085	com/tencent/mm/protocal/c/rl:xY	(I)Lcom/tencent/mm/protocal/c/rl;
    //   1318: pop
    //   1319: aload 8
    //   1321: aload_0
    //   1322: new 98	java/lang/StringBuilder
    //   1325: dup
    //   1326: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1329: ldc_w 946
    //   1332: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: ldc_w 1087
    //   1338: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1344: invokeinterface 117 2 0
    //   1349: checkcast 53	java/lang/String
    //   1352: invokevirtual 1090	com/tencent/mm/protocal/c/rl:Oe	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1355: pop
    //   1356: aload 8
    //   1358: aload_0
    //   1359: new 98	java/lang/StringBuilder
    //   1362: dup
    //   1363: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1366: ldc_w 946
    //   1369: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: ldc_w 1092
    //   1375: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: invokeinterface 117 2 0
    //   1386: checkcast 53	java/lang/String
    //   1389: invokevirtual 1095	com/tencent/mm/protocal/c/rl:Of	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1392: pop
    //   1393: aload 8
    //   1395: aload_0
    //   1396: new 98	java/lang/StringBuilder
    //   1399: dup
    //   1400: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1403: ldc_w 946
    //   1406: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: ldc_w 1097
    //   1412: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1418: invokeinterface 117 2 0
    //   1423: checkcast 53	java/lang/String
    //   1426: invokevirtual 1100	com/tencent/mm/protocal/c/rl:Og	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1429: pop
    //   1430: aload 8
    //   1432: aload_0
    //   1433: new 98	java/lang/StringBuilder
    //   1436: dup
    //   1437: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1440: ldc_w 946
    //   1443: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: ldc_w 1102
    //   1449: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: invokeinterface 117 2 0
    //   1460: checkcast 53	java/lang/String
    //   1463: invokevirtual 1105	com/tencent/mm/protocal/c/rl:Oi	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1466: pop
    //   1467: aload 4
    //   1469: ifnull +11 -> 1480
    //   1472: aload 8
    //   1474: aload 4
    //   1476: invokevirtual 1108	com/tencent/mm/protocal/c/rl:Ok	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rl;
    //   1479: pop
    //   1480: new 736	com/tencent/mm/protocal/c/rm
    //   1483: dup
    //   1484: invokespecial 1109	com/tencent/mm/protocal/c/rm:<init>	()V
    //   1487: astore 4
    //   1489: new 1111	com/tencent/mm/protocal/c/rn
    //   1492: dup
    //   1493: invokespecial 1112	com/tencent/mm/protocal/c/rn:<init>	()V
    //   1496: astore 5
    //   1498: aload 5
    //   1500: aload_0
    //   1501: new 98	java/lang/StringBuilder
    //   1504: dup
    //   1505: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1508: ldc_w 946
    //   1511: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: ldc_w 1114
    //   1517: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1523: invokeinterface 117 2 0
    //   1528: checkcast 53	java/lang/String
    //   1531: iconst_0
    //   1532: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   1535: invokevirtual 1118	com/tencent/mm/protocal/c/rn:xZ	(I)Lcom/tencent/mm/protocal/c/rn;
    //   1538: pop
    //   1539: aload_0
    //   1540: new 98	java/lang/StringBuilder
    //   1543: dup
    //   1544: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1547: ldc_w 946
    //   1550: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: ldc_w 1120
    //   1556: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1562: invokeinterface 117 2 0
    //   1567: checkcast 53	java/lang/String
    //   1570: astore 6
    //   1572: aload 6
    //   1574: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   1577: ifne +32 -> 1609
    //   1580: aload 5
    //   1582: aload 6
    //   1584: invokevirtual 1124	com/tencent/mm/protocal/c/rn:Ol	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rn;
    //   1587: pop
    //   1588: ldc_w 1126
    //   1591: ldc_w 1128
    //   1594: iconst_1
    //   1595: anewarray 4	java/lang/Object
    //   1598: dup
    //   1599: iconst_0
    //   1600: aload 5
    //   1602: getfield 1131	com/tencent/mm/protocal/c/rn:fOl	Ljava/lang/String;
    //   1605: aastore
    //   1606: invokestatic 442	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1609: aload_0
    //   1610: new 98	java/lang/StringBuilder
    //   1613: dup
    //   1614: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1617: ldc_w 946
    //   1620: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1623: ldc_w 1133
    //   1626: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1632: invokeinterface 117 2 0
    //   1637: checkcast 53	java/lang/String
    //   1640: astore 6
    //   1642: aload 6
    //   1644: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   1647: ifne +32 -> 1679
    //   1650: aload 5
    //   1652: aload 6
    //   1654: invokevirtual 1136	com/tencent/mm/protocal/c/rn:Oo	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rn;
    //   1657: pop
    //   1658: ldc_w 1126
    //   1661: ldc_w 1138
    //   1664: iconst_1
    //   1665: anewarray 4	java/lang/Object
    //   1668: dup
    //   1669: iconst_0
    //   1670: aload 5
    //   1672: getfield 1141	com/tencent/mm/protocal/c/rn:txi	Ljava/lang/String;
    //   1675: aastore
    //   1676: invokestatic 442	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1679: aload 5
    //   1681: aload_0
    //   1682: new 98	java/lang/StringBuilder
    //   1685: dup
    //   1686: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1689: ldc_w 946
    //   1692: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1695: ldc_w 1143
    //   1698: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1701: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1704: invokeinterface 117 2 0
    //   1709: checkcast 53	java/lang/String
    //   1712: invokevirtual 1146	com/tencent/mm/protocal/c/rn:Oq	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rn;
    //   1715: pop
    //   1716: aload 5
    //   1718: aload_0
    //   1719: new 98	java/lang/StringBuilder
    //   1722: dup
    //   1723: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1726: ldc_w 946
    //   1729: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: ldc_w 1148
    //   1735: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1741: invokeinterface 117 2 0
    //   1746: checkcast 53	java/lang/String
    //   1749: invokevirtual 1151	com/tencent/mm/protocal/c/rn:Or	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rn;
    //   1752: pop
    //   1753: aload 5
    //   1755: aload_0
    //   1756: new 98	java/lang/StringBuilder
    //   1759: dup
    //   1760: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1763: ldc_w 946
    //   1766: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: ldc_w 1153
    //   1772: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1778: invokeinterface 117 2 0
    //   1783: checkcast 53	java/lang/String
    //   1786: invokevirtual 1156	com/tencent/mm/protocal/c/rn:Os	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rn;
    //   1789: pop
    //   1790: aload 4
    //   1792: aload 5
    //   1794: invokevirtual 1160	com/tencent/mm/protocal/c/rm:c	(Lcom/tencent/mm/protocal/c/rn;)Lcom/tencent/mm/protocal/c/rm;
    //   1797: pop
    //   1798: new 98	java/lang/StringBuilder
    //   1801: dup
    //   1802: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1805: ldc_w 946
    //   1808: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: ldc_w 1162
    //   1814: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1820: astore 6
    //   1822: aload_0
    //   1823: aload 6
    //   1825: invokeinterface 1165 2 0
    //   1830: ifne +201 -> 2031
    //   1833: ldc_w 1126
    //   1836: ldc_w 1167
    //   1839: iconst_1
    //   1840: anewarray 4	java/lang/Object
    //   1843: dup
    //   1844: iconst_0
    //   1845: aload 6
    //   1847: aastore
    //   1848: invokestatic 1169	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1851: new 98	java/lang/StringBuilder
    //   1854: dup
    //   1855: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1858: ldc_w 946
    //   1861: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1864: ldc_w 1171
    //   1867: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1873: astore 5
    //   1875: aload_0
    //   1876: aload 5
    //   1878: invokeinterface 1165 2 0
    //   1883: ifne +578 -> 2461
    //   1886: ldc_w 1126
    //   1889: ldc_w 1167
    //   1892: iconst_1
    //   1893: anewarray 4	java/lang/Object
    //   1896: dup
    //   1897: iconst_0
    //   1898: aload 5
    //   1900: aastore
    //   1901: invokestatic 1169	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1904: new 98	java/lang/StringBuilder
    //   1907: dup
    //   1908: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1911: ldc_w 946
    //   1914: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: ldc_w 1173
    //   1920: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1926: astore 5
    //   1928: aload_0
    //   1929: aload 5
    //   1931: invokeinterface 1165 2 0
    //   1936: ifne +729 -> 2665
    //   1939: ldc_w 1126
    //   1942: ldc_w 1167
    //   1945: iconst_1
    //   1946: anewarray 4	java/lang/Object
    //   1949: dup
    //   1950: iconst_0
    //   1951: aload 5
    //   1953: aastore
    //   1954: invokestatic 1169	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1957: new 98	java/lang/StringBuilder
    //   1960: dup
    //   1961: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1964: ldc_w 946
    //   1967: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1970: ldc_w 1175
    //   1973: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1976: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1979: astore 5
    //   1981: aload_0
    //   1982: aload 5
    //   1984: invokeinterface 1165 2 0
    //   1989: ifne +880 -> 2869
    //   1992: ldc_w 1126
    //   1995: ldc_w 1167
    //   1998: iconst_1
    //   1999: anewarray 4	java/lang/Object
    //   2002: dup
    //   2003: iconst_0
    //   2004: aload 5
    //   2006: aastore
    //   2007: invokestatic 1169	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2010: aload 8
    //   2012: aload 4
    //   2014: invokevirtual 1178	com/tencent/mm/protocal/c/rl:a	(Lcom/tencent/mm/protocal/c/rm;)Lcom/tencent/mm/protocal/c/rl;
    //   2017: pop
    //   2018: aload_1
    //   2019: getfield 603	com/tencent/mm/protocal/b/a/c:hkc	Ljava/util/LinkedList;
    //   2022: aload 8
    //   2024: invokevirtual 1179	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   2027: pop
    //   2028: goto +1026 -> 3054
    //   2031: new 745	com/tencent/mm/protocal/c/rr
    //   2034: dup
    //   2035: invokespecial 1180	com/tencent/mm/protocal/c/rr:<init>	()V
    //   2038: astore 5
    //   2040: aload_0
    //   2041: new 98	java/lang/StringBuilder
    //   2044: dup
    //   2045: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2048: aload 6
    //   2050: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: ldc_w 1182
    //   2056: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2059: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2062: invokeinterface 117 2 0
    //   2067: checkcast 53	java/lang/String
    //   2070: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   2073: ifne +39 -> 2112
    //   2076: aload 5
    //   2078: aload_0
    //   2079: new 98	java/lang/StringBuilder
    //   2082: dup
    //   2083: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2086: aload 6
    //   2088: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: ldc_w 1182
    //   2094: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2097: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2100: invokeinterface 117 2 0
    //   2105: checkcast 53	java/lang/String
    //   2108: invokevirtual 1186	com/tencent/mm/protocal/c/rr:Ot	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rr;
    //   2111: pop
    //   2112: aload_0
    //   2113: new 98	java/lang/StringBuilder
    //   2116: dup
    //   2117: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2120: aload 6
    //   2122: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: ldc_w 1188
    //   2128: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2131: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2134: invokeinterface 117 2 0
    //   2139: checkcast 53	java/lang/String
    //   2142: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   2145: ifne +39 -> 2184
    //   2148: aload 5
    //   2150: aload_0
    //   2151: new 98	java/lang/StringBuilder
    //   2154: dup
    //   2155: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2158: aload 6
    //   2160: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2163: ldc_w 1188
    //   2166: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2169: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2172: invokeinterface 117 2 0
    //   2177: checkcast 53	java/lang/String
    //   2180: invokevirtual 1191	com/tencent/mm/protocal/c/rr:Ou	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rr;
    //   2183: pop
    //   2184: aload_0
    //   2185: new 98	java/lang/StringBuilder
    //   2188: dup
    //   2189: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2192: aload 6
    //   2194: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: ldc_w 1193
    //   2200: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2203: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2206: invokeinterface 117 2 0
    //   2211: checkcast 53	java/lang/String
    //   2214: astore 9
    //   2216: aload 9
    //   2218: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   2221: ifne +15 -> 2236
    //   2224: aload 5
    //   2226: aload 9
    //   2228: dconst_0
    //   2229: invokestatic 1197	com/tencent/mm/sdk/platformtools/bf:getDouble	(Ljava/lang/String;D)D
    //   2232: invokevirtual 1201	com/tencent/mm/protocal/c/rr:l	(D)Lcom/tencent/mm/protocal/c/rr;
    //   2235: pop
    //   2236: aload_0
    //   2237: new 98	java/lang/StringBuilder
    //   2240: dup
    //   2241: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2244: aload 6
    //   2246: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: ldc_w 1203
    //   2252: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2258: invokeinterface 117 2 0
    //   2263: checkcast 53	java/lang/String
    //   2266: astore 9
    //   2268: aload 9
    //   2270: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   2273: ifne +15 -> 2288
    //   2276: aload 5
    //   2278: aload 9
    //   2280: dconst_0
    //   2281: invokestatic 1197	com/tencent/mm/sdk/platformtools/bf:getDouble	(Ljava/lang/String;D)D
    //   2284: invokevirtual 1205	com/tencent/mm/protocal/c/rr:m	(D)Lcom/tencent/mm/protocal/c/rr;
    //   2287: pop
    //   2288: aload_0
    //   2289: new 98	java/lang/StringBuilder
    //   2292: dup
    //   2293: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2296: aload 6
    //   2298: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: ldc_w 1207
    //   2304: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2307: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2310: invokeinterface 117 2 0
    //   2315: checkcast 53	java/lang/String
    //   2318: astore 6
    //   2320: aload 6
    //   2322: invokestatic 41	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   2325: ifne +37 -> 2362
    //   2328: aload 6
    //   2330: bipush 46
    //   2332: invokevirtual 1210	java/lang/String:indexOf	(I)I
    //   2335: iconst_m1
    //   2336: if_icmpeq +110 -> 2446
    //   2339: aload 5
    //   2341: aload 6
    //   2343: iconst_0
    //   2344: aload 6
    //   2346: bipush 46
    //   2348: invokevirtual 1210	java/lang/String:indexOf	(I)I
    //   2351: invokevirtual 836	java/lang/String:substring	(II)Ljava/lang/String;
    //   2354: iconst_m1
    //   2355: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   2358: invokevirtual 1214	com/tencent/mm/protocal/c/rr:ya	(I)Lcom/tencent/mm/protocal/c/rr;
    //   2361: pop
    //   2362: aload 4
    //   2364: aload 5
    //   2366: invokevirtual 1217	com/tencent/mm/protocal/c/rm:a	(Lcom/tencent/mm/protocal/c/rr;)Lcom/tencent/mm/protocal/c/rm;
    //   2369: pop
    //   2370: goto -519 -> 1851
    //   2373: astore_0
    //   2374: ldc 43
    //   2376: ldc_w 1219
    //   2379: iconst_1
    //   2380: anewarray 4	java/lang/Object
    //   2383: dup
    //   2384: iconst_0
    //   2385: aload_0
    //   2386: invokevirtual 1222	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2389: aastore
    //   2390: invokestatic 96	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2393: ldc 43
    //   2395: aload_0
    //   2396: ldc_w 799
    //   2399: iconst_0
    //   2400: anewarray 4	java/lang/Object
    //   2403: invokestatic 1226	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2406: aload_1
    //   2407: getfield 603	com/tencent/mm/protocal/b/a/c:hkc	Ljava/util/LinkedList;
    //   2410: invokevirtual 872	java/util/LinkedList:clear	()V
    //   2413: goto +641 -> 3054
    //   2416: astore_0
    //   2417: ldc 43
    //   2419: ldc_w 1228
    //   2422: iconst_1
    //   2423: anewarray 4	java/lang/Object
    //   2426: dup
    //   2427: iconst_0
    //   2428: aload_0
    //   2429: invokevirtual 1229	java/lang/Exception:toString	()Ljava/lang/String;
    //   2432: aastore
    //   2433: invokestatic 96	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2436: ldc2_w 867
    //   2439: ldc_w 869
    //   2442: invokestatic 29	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   2445: return
    //   2446: aload 5
    //   2448: aload 6
    //   2450: iconst_m1
    //   2451: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   2454: invokevirtual 1214	com/tencent/mm/protocal/c/rr:ya	(I)Lcom/tencent/mm/protocal/c/rr;
    //   2457: pop
    //   2458: goto -96 -> 2362
    //   2461: new 1231	com/tencent/mm/protocal/c/se
    //   2464: dup
    //   2465: invokespecial 1232	com/tencent/mm/protocal/c/se:<init>	()V
    //   2468: astore 6
    //   2470: aload 6
    //   2472: aload_0
    //   2473: new 98	java/lang/StringBuilder
    //   2476: dup
    //   2477: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2480: aload 5
    //   2482: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2485: ldc_w 1234
    //   2488: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2491: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2494: invokeinterface 117 2 0
    //   2499: checkcast 53	java/lang/String
    //   2502: invokevirtual 1238	com/tencent/mm/protocal/c/se:OP	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/se;
    //   2505: pop
    //   2506: aload 6
    //   2508: aload_0
    //   2509: new 98	java/lang/StringBuilder
    //   2512: dup
    //   2513: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2516: aload 5
    //   2518: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2521: ldc_w 1240
    //   2524: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2527: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2530: invokeinterface 117 2 0
    //   2535: checkcast 53	java/lang/String
    //   2538: invokevirtual 1243	com/tencent/mm/protocal/c/se:OQ	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/se;
    //   2541: pop
    //   2542: aload 6
    //   2544: aload_0
    //   2545: new 98	java/lang/StringBuilder
    //   2548: dup
    //   2549: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2552: aload 5
    //   2554: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2557: ldc_w 1245
    //   2560: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2563: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2566: invokeinterface 117 2 0
    //   2571: checkcast 53	java/lang/String
    //   2574: invokevirtual 1248	com/tencent/mm/protocal/c/se:OS	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/se;
    //   2577: pop
    //   2578: aload 6
    //   2580: aload_0
    //   2581: new 98	java/lang/StringBuilder
    //   2584: dup
    //   2585: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2588: aload 5
    //   2590: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2593: ldc_w 1148
    //   2596: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2599: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2602: invokeinterface 117 2 0
    //   2607: checkcast 53	java/lang/String
    //   2610: invokevirtual 1251	com/tencent/mm/protocal/c/se:OR	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/se;
    //   2613: pop
    //   2614: aload 6
    //   2616: aload_0
    //   2617: new 98	java/lang/StringBuilder
    //   2620: dup
    //   2621: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2624: aload 5
    //   2626: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2629: ldc_w 1253
    //   2632: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2635: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2638: invokeinterface 117 2 0
    //   2643: checkcast 53	java/lang/String
    //   2646: iconst_0
    //   2647: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   2650: invokevirtual 1257	com/tencent/mm/protocal/c/se:yf	(I)Lcom/tencent/mm/protocal/c/se;
    //   2653: pop
    //   2654: aload 4
    //   2656: aload 6
    //   2658: invokevirtual 1260	com/tencent/mm/protocal/c/rm:a	(Lcom/tencent/mm/protocal/c/se;)Lcom/tencent/mm/protocal/c/rm;
    //   2661: pop
    //   2662: goto -758 -> 1904
    //   2665: new 778	com/tencent/mm/protocal/c/rt
    //   2668: dup
    //   2669: invokespecial 1261	com/tencent/mm/protocal/c/rt:<init>	()V
    //   2672: astore 6
    //   2674: aload 6
    //   2676: aload_0
    //   2677: new 98	java/lang/StringBuilder
    //   2680: dup
    //   2681: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2684: aload 5
    //   2686: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2689: ldc_w 1234
    //   2692: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2695: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2698: invokeinterface 117 2 0
    //   2703: checkcast 53	java/lang/String
    //   2706: invokevirtual 1265	com/tencent/mm/protocal/c/rt:Ov	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rt;
    //   2709: pop
    //   2710: aload 6
    //   2712: aload_0
    //   2713: new 98	java/lang/StringBuilder
    //   2716: dup
    //   2717: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2720: aload 5
    //   2722: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2725: ldc_w 1240
    //   2728: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2731: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2734: invokeinterface 117 2 0
    //   2739: checkcast 53	java/lang/String
    //   2742: invokevirtual 1268	com/tencent/mm/protocal/c/rt:Ow	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rt;
    //   2745: pop
    //   2746: aload 6
    //   2748: aload_0
    //   2749: new 98	java/lang/StringBuilder
    //   2752: dup
    //   2753: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2756: aload 5
    //   2758: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2761: ldc_w 1245
    //   2764: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2767: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2770: invokeinterface 117 2 0
    //   2775: checkcast 53	java/lang/String
    //   2778: invokevirtual 1271	com/tencent/mm/protocal/c/rt:Ox	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rt;
    //   2781: pop
    //   2782: aload 6
    //   2784: aload_0
    //   2785: new 98	java/lang/StringBuilder
    //   2788: dup
    //   2789: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2792: aload 5
    //   2794: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2797: ldc_w 1273
    //   2800: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2806: invokeinterface 117 2 0
    //   2811: checkcast 53	java/lang/String
    //   2814: invokevirtual 1276	com/tencent/mm/protocal/c/rt:Oy	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/rt;
    //   2817: pop
    //   2818: aload 6
    //   2820: aload_0
    //   2821: new 98	java/lang/StringBuilder
    //   2824: dup
    //   2825: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2828: aload 5
    //   2830: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2833: ldc_w 1278
    //   2836: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2839: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2842: invokeinterface 117 2 0
    //   2847: checkcast 53	java/lang/String
    //   2850: iconst_0
    //   2851: invokestatic 952	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   2854: invokevirtual 1282	com/tencent/mm/protocal/c/rt:yb	(I)Lcom/tencent/mm/protocal/c/rt;
    //   2857: pop
    //   2858: aload 4
    //   2860: aload 6
    //   2862: invokevirtual 1285	com/tencent/mm/protocal/c/rm:a	(Lcom/tencent/mm/protocal/c/rt;)Lcom/tencent/mm/protocal/c/rm;
    //   2865: pop
    //   2866: goto -909 -> 1957
    //   2869: new 1287	com/tencent/mm/protocal/c/ry
    //   2872: dup
    //   2873: invokespecial 1288	com/tencent/mm/protocal/c/ry:<init>	()V
    //   2876: astore 6
    //   2878: aload 6
    //   2880: aload_0
    //   2881: new 98	java/lang/StringBuilder
    //   2884: dup
    //   2885: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2888: aload 5
    //   2890: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2893: ldc_w 1234
    //   2896: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2899: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2902: invokeinterface 117 2 0
    //   2907: checkcast 53	java/lang/String
    //   2910: invokevirtual 1292	com/tencent/mm/protocal/c/ry:OL	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/ry;
    //   2913: pop
    //   2914: aload 6
    //   2916: aload_0
    //   2917: new 98	java/lang/StringBuilder
    //   2920: dup
    //   2921: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2924: aload 5
    //   2926: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2929: ldc_w 1240
    //   2932: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2935: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2938: invokeinterface 117 2 0
    //   2943: checkcast 53	java/lang/String
    //   2946: invokevirtual 1295	com/tencent/mm/protocal/c/ry:OM	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/ry;
    //   2949: pop
    //   2950: aload 6
    //   2952: aload_0
    //   2953: new 98	java/lang/StringBuilder
    //   2956: dup
    //   2957: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2960: aload 5
    //   2962: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2965: ldc_w 1245
    //   2968: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2971: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2974: invokeinterface 117 2 0
    //   2979: checkcast 53	java/lang/String
    //   2982: invokevirtual 1298	com/tencent/mm/protocal/c/ry:ON	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/ry;
    //   2985: pop
    //   2986: aload 6
    //   2988: aload_0
    //   2989: new 98	java/lang/StringBuilder
    //   2992: dup
    //   2993: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   2996: aload 5
    //   2998: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3001: ldc_w 1300
    //   3004: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3007: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3010: invokeinterface 117 2 0
    //   3015: checkcast 53	java/lang/String
    //   3018: invokevirtual 1303	com/tencent/mm/protocal/c/ry:OO	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/ry;
    //   3021: pop
    //   3022: aload 4
    //   3024: aload 6
    //   3026: invokevirtual 1306	com/tencent/mm/protocal/c/rm:a	(Lcom/tencent/mm/protocal/c/ry;)Lcom/tencent/mm/protocal/c/rm;
    //   3029: pop
    //   3030: goto -1020 -> 2010
    //   3033: ldc2_w 867
    //   3036: ldc_w 869
    //   3039: invokestatic 29	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   3042: return
    //   3043: aconst_null
    //   3044: astore_0
    //   3045: goto -2843 -> 202
    //   3048: aconst_null
    //   3049: astore 4
    //   3051: goto -2870 -> 181
    //   3054: iload_2
    //   3055: iconst_1
    //   3056: iadd
    //   3057: istore_2
    //   3058: goto -2946 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3061	0	paramString	String
    //   0	3061	1	paramc	com.tencent.mm.protocal.b.a.c
    //   111	2947	2	i	int
    //   109	6	3	j	int
    //   19	3031	4	localObject1	Object
    //   702	2295	5	localObject2	Object
    //   1201	1824	6	localObject3	Object
    //   85	33	7	localNodeList	org.w3c.dom.NodeList
    //   209	1814	8	localrl	rl
    //   2214	65	9	str	String
    // Exception table:
    //   from	to	target	type
    //   202	704	2373	java/lang/Exception
    //   709	729	2373	java/lang/Exception
    //   729	968	2373	java/lang/Exception
    //   968	1133	2373	java/lang/Exception
    //   1133	1203	2373	java/lang/Exception
    //   1207	1221	2373	java/lang/Exception
    //   1221	1278	2373	java/lang/Exception
    //   1278	1467	2373	java/lang/Exception
    //   1472	1480	2373	java/lang/Exception
    //   1480	1609	2373	java/lang/Exception
    //   1609	1679	2373	java/lang/Exception
    //   1679	1851	2373	java/lang/Exception
    //   1851	1904	2373	java/lang/Exception
    //   1904	1957	2373	java/lang/Exception
    //   1957	2010	2373	java/lang/Exception
    //   2010	2028	2373	java/lang/Exception
    //   2031	2112	2373	java/lang/Exception
    //   2112	2184	2373	java/lang/Exception
    //   2184	2236	2373	java/lang/Exception
    //   2236	2288	2373	java/lang/Exception
    //   2288	2362	2373	java/lang/Exception
    //   2362	2370	2373	java/lang/Exception
    //   2446	2458	2373	java/lang/Exception
    //   2461	2662	2373	java/lang/Exception
    //   2665	2866	2373	java/lang/Exception
    //   2869	3030	2373	java/lang/Exception
    //   21	69	2416	java/lang/Exception
    //   73	87	2416	java/lang/Exception
    //   92	110	2416	java/lang/Exception
    //   117	148	2416	java/lang/Exception
    //   153	181	2416	java/lang/Exception
    //   181	202	2416	java/lang/Exception
    //   2374	2413	2416	java/lang/Exception
  }
  
  public static boolean a(rl paramrl, long paramLong, boolean paramBoolean)
  {
    GMTrace.i(7510152970240L, 55955);
    if (paramrl == null)
    {
      v.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
      GMTrace.o(7510152970240L, 55955);
      return false;
    }
    String str = d(paramrl.lII, paramLong, true);
    g localg2 = s.aWy().Dm(str);
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg2 = new g();
      localg2.field_cdnKey = paramrl.tvC;
      localg2.field_cdnUrl = paramrl.tvA;
      localg2.field_dataId = paramrl.lII;
      localg2.field_mediaId = str;
      localg2.field_totalLen = ((int)paramrl.tvV);
      localg2.field_localId = (new Random().nextInt(2147483645) + 1);
      localg2.field_path = c(paramrl, paramLong);
      localg2.field_type = 1;
      localg2.field_fileType = rO(paramrl.aMw);
      localg2.field_isThumb = false;
      boolean bool = s.aWy().a(localg2);
      v.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localg2.field_localId), Boolean.valueOf(bool) });
      localg1 = localg2;
      if (!bf.mA(paramrl.twC))
      {
        localg1 = localg2;
        if (paramrl.twC.equals("WeNoteHtmlFile"))
        {
          s.aWA().a(localg2, true);
          localg1 = localg2;
        }
      }
    }
    v.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[] { localg1 });
    if (4 == localg1.field_status)
    {
      v.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(localg1.field_errCode) });
      GMTrace.o(7510152970240L, 55955);
      return false;
    }
    if (3 == localg1.field_status)
    {
      v.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(localg1.field_errCode), Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        localg1.field_status = 1;
        s.aWy().b(localg1, new String[] { "localId" });
      }
    }
    else
    {
      s.aWA().run();
      GMTrace.o(7510152970240L, 55955);
      return true;
    }
    GMTrace.o(7510152970240L, 55955);
    return false;
  }
  
  public static String b(String paramString1, String paramString2, List<rl> paramList, String paramString3)
  {
    GMTrace.i(7507871268864L, 55938);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<recordinfo>");
    localStringBuilder.append("<title>").append(bf.PV(paramString1)).append("</title>");
    localStringBuilder.append("<desc>").append(bf.PV(paramString2)).append("</desc>");
    localStringBuilder.append(n.ar(paramList));
    localStringBuilder.append("<favusername>").append(bf.PV(paramString3)).append("</favusername>");
    localStringBuilder.append("</recordinfo>");
    paramString3 = new f.a();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    if ((!bf.mA(((rl)paramList.get(0)).tvP)) && (((rl)paramList.get(0)).tvP.equals(".htm"))) {
      paramString3.type = 24;
    }
    for (paramString3.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";; paramString3.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0")
    {
      paramString3.action = "view";
      paramString3.hhG = localStringBuilder.toString();
      paramString1 = f.a.a(paramString3, null, null);
      GMTrace.o(7507871268864L, 55938);
      return paramString1;
      paramString3.type = 19;
    }
  }
  
  public static boolean b(rl paramrl, long paramLong, boolean paramBoolean)
  {
    GMTrace.i(7510421405696L, 55957);
    if (paramrl == null)
    {
      v.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
      GMTrace.o(7510421405696L, 55957);
      return false;
    }
    String str1 = vV(paramrl.lII);
    String str2 = d(str1, paramLong, true);
    g localg2 = s.aWy().Dm(str2);
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = new g();
      localg1.field_cdnKey = paramrl.tvw;
      localg1.field_cdnUrl = paramrl.hho;
      localg1.field_dataId = str1;
      localg1.field_mediaId = str2;
      localg1.field_totalLen = ((int)paramrl.twg);
      localg1.field_localId = (new Random().nextInt(2147483645) + 1);
      localg1.field_path = f(paramrl, paramLong);
      localg1.field_type = 1;
      localg1.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
      localg1.field_isThumb = true;
      boolean bool = s.aWy().a(localg1);
      v.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[] { Integer.valueOf(localg1.field_localId), Boolean.valueOf(bool) });
    }
    v.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[] { localg1 });
    if (4 == localg1.field_status)
    {
      v.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[] { Integer.valueOf(localg1.field_errCode) });
      GMTrace.o(7510421405696L, 55957);
      return false;
    }
    if (3 == localg1.field_status)
    {
      v.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[] { Integer.valueOf(localg1.field_errCode), Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        localg1.field_status = 1;
        s.aWy().b(localg1, new String[] { "localId" });
      }
    }
    else
    {
      s.aWA().run();
      GMTrace.o(7510421405696L, 55957);
      return true;
    }
    GMTrace.o(7510421405696L, 55957);
    return false;
  }
  
  public static String c(rl paramrl, long paramLong)
  {
    int i = 1;
    GMTrace.i(7509079228416L, 55947);
    if (paramrl == null)
    {
      GMTrace.o(7509079228416L, 55947);
      return "";
    }
    String str1 = paramrl.lII;
    if ((bf.mA(str1)) || (!ap.zb()))
    {
      GMTrace.o(7509079228416L, 55947);
      return "";
    }
    File localFile = cS(paramLong);
    if ((paramrl.aMw == 8) && (!bf.mA(paramrl.title)))
    {
      str1 = paramrl.title;
      int j = paramrl.lII.hashCode();
      ap.yY();
      localFile = new File(String.format("%s/%d/%d/", new Object[] { com.tencent.mm.u.c.xp(), Long.valueOf(paramLong), Integer.valueOf(j & 0xFF) }));
      if ((!localFile.exists()) || (!localFile.isDirectory())) {
        localFile.mkdirs();
      }
    }
    for (;;)
    {
      String str2 = str1;
      if (paramrl.tvP != null)
      {
        str2 = str1;
        if (paramrl.tvP.trim().length() > 0)
        {
          str2 = str1;
          if (i == 0) {
            str2 = str1 + "." + paramrl.tvP;
          }
        }
      }
      paramrl = new File(localFile, str2).getAbsolutePath();
      GMTrace.o(7509079228416L, 55947);
      return paramrl;
      i = 0;
    }
  }
  
  private static File cS(long paramLong)
  {
    GMTrace.i(7508810792960L, 55945);
    ap.yY();
    File localFile = new File(String.format("%s/%d/", new Object[] { com.tencent.mm.u.c.xp(), Long.valueOf(paramLong) }));
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    GMTrace.o(7508810792960L, 55945);
    return localFile;
  }
  
  public static void cT(long paramLong)
  {
    GMTrace.i(7508945010688L, 55946);
    File localFile = cS(paramLong);
    boolean bool = com.tencent.mm.a.e.d(localFile);
    v.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[] { localFile.getAbsolutePath(), Boolean.valueOf(bool) });
    GMTrace.o(7508945010688L, 55946);
  }
  
  public static String d(String paramString, long paramLong, boolean paramBoolean)
  {
    GMTrace.i(7509750317056L, 55952);
    if (paramBoolean)
    {
      paramString = paramString + "@record_download@" + paramLong;
      GMTrace.o(7509750317056L, 55952);
      return paramString;
    }
    paramString = paramString + "@record_upload@" + paramLong;
    GMTrace.o(7509750317056L, 55952);
    return paramString;
  }
  
  public static boolean d(rl paramrl, long paramLong)
  {
    GMTrace.i(7509213446144L, 55948);
    boolean bool = new File(c(paramrl, paramLong)).exists();
    GMTrace.o(7509213446144L, 55948);
    return bool;
  }
  
  public static boolean e(rl paramrl, long paramLong)
  {
    GMTrace.i(7509347663872L, 55949);
    boolean bool = new File(f(paramrl, paramLong)).exists();
    GMTrace.o(7509347663872L, 55949);
    return bool;
  }
  
  public static String eL(String paramString)
  {
    GMTrace.i(7510555623424L, 55958);
    ap.yY();
    Object localObject = com.tencent.mm.u.c.wR().Rb(paramString);
    if (localObject == null)
    {
      v.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[] { paramString });
      GMTrace.o(7510555623424L, 55958);
      return "";
    }
    String str = ((x)localObject).tL();
    localObject = str;
    if (com.tencent.mm.u.o.dH(str))
    {
      paramString = j.eA(paramString);
      localObject = com.tencent.mm.u.m.xL();
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label113;
      }
      v.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
    }
    for (localObject = str;; localObject = j.b(paramString, 3))
    {
      GMTrace.o(7510555623424L, 55958);
      return (String)localObject;
      label113:
      paramString.remove(localObject);
      paramString.add(0, localObject);
    }
  }
  
  public static String f(rl paramrl, long paramLong)
  {
    GMTrace.i(7509481881600L, 55950);
    if ((paramrl == null) || (bf.mA(paramrl.lII)))
    {
      GMTrace.o(7509481881600L, 55950);
      return "";
    }
    paramrl = vV(paramrl.lII);
    paramrl = new File(cS(paramLong), paramrl).getAbsolutePath();
    GMTrace.o(7509481881600L, 55950);
    return paramrl;
  }
  
  public static boolean g(rl paramrl, long paramLong)
  {
    GMTrace.i(7510287187968L, 55956);
    if (paramrl == null)
    {
      v.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
      GMTrace.o(7510287187968L, 55956);
      return true;
    }
    paramrl = d(paramrl.lII, paramLong, true);
    paramrl = s.aWy().Dm(paramrl);
    if (paramrl == null)
    {
      v.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
      GMTrace.o(7510287187968L, 55956);
      return false;
    }
    if (4 == paramrl.field_status)
    {
      v.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[] { Integer.valueOf(paramrl.field_errCode) });
      GMTrace.o(7510287187968L, 55956);
      return true;
    }
    v.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[] { Integer.valueOf(paramrl.field_status) });
    GMTrace.o(7510287187968L, 55956);
    return false;
  }
  
  public static boolean h(rl paramrl, long paramLong)
  {
    GMTrace.i(7510689841152L, 55959);
    boolean bool = com.tencent.mm.sdk.platformtools.o.Pi(c(paramrl, paramLong));
    GMTrace.o(7510689841152L, 55959);
    return bool;
  }
  
  public static int rO(int paramInt)
  {
    GMTrace.i(7510018752512L, 55954);
    if (2 == paramInt)
    {
      paramInt = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
      GMTrace.o(7510018752512L, 55954);
      return paramInt;
    }
    if (4 == paramInt)
    {
      paramInt = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
      GMTrace.o(7510018752512L, 55954);
      return paramInt;
    }
    paramInt = com.tencent.mm.modelcdntran.b.MediaType_FILE;
    GMTrace.o(7510018752512L, 55954);
    return paramInt;
  }
  
  public static String vV(String paramString)
  {
    GMTrace.i(7509616099328L, 55951);
    paramString = paramString + "_t";
    GMTrace.o(7509616099328L, 55951);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/record/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */