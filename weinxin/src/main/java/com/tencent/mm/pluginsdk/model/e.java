package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.f;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.a;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.fp.b;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.lz.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.protocal.c.se;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.t.k;
import com.tencent.mm.t.l;
import com.tencent.mm.u.m;
import com.tencent.mm.x.i;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e
{
  private static rv S(au paramau)
  {
    GMTrace.i(727728521216L, 5422);
    rv localrv = new rv();
    if (paramau.field_isSend == 1)
    {
      localrv.OC(m.xL());
      localrv.OD(paramau.field_talker);
      if (com.tencent.mm.u.o.dH(paramau.field_talker)) {
        localrv.OF(localrv.fOl);
      }
    }
    do
    {
      localrv.ye(1);
      localrv.ep(paramau.field_createTime);
      localrv.OG(paramau.field_msgSvrId);
      if (paramau.field_msgSvrId > 0L) {
        localrv.OE(paramau.field_msgSvrId);
      }
      GMTrace.o(727728521216L, 5422);
      return localrv;
      localrv.OC(paramau.field_talker);
      localrv.OD(m.xL());
    } while (!com.tencent.mm.u.o.dH(paramau.field_talker));
    if (paramau.field_content != null) {}
    for (String str = paramau.field_content.substring(0, Math.max(0, paramau.field_content.indexOf(':')));; str = "")
    {
      localrv.OF(str);
      if ((bf.mA(localrv.txi)) || (paramau.bLP())) {
        break;
      }
      paramau.setContent(paramau.field_content.substring(localrv.txi.length() + 1));
      if ((paramau.field_content.length() > 0) && ('\n' == paramau.field_content.charAt(0))) {
        paramau.setContent(paramau.field_content.substring(1));
      }
      if (!paramau.bMi()) {
        break;
      }
      paramau.cK(paramau.field_transContent.substring(localrv.txi.length() + 1));
      if ((paramau.field_transContent.length() <= 0) || ('\n' != paramau.field_transContent.charAt(0))) {
        break;
      }
      paramau.cK(paramau.field_transContent.substring(1));
      break;
    }
  }
  
  private static rl a(rl paramrl, int paramInt)
  {
    GMTrace.i(728936480768L, 5431);
    rl localrl = q(paramrl);
    localrl.xW(paramInt);
    if ((paramrl.twu != null) && (paramrl.twu.twS != null))
    {
      rt localrt = new rt();
      localrt.Ov(paramrl.twu.twS.title);
      localrt.Ow(paramrl.twu.twS.desc);
      localrt.yb(paramrl.twu.twS.type);
      localrt.Oy(paramrl.twu.twS.info);
      localrt.Ox(paramrl.twu.twS.thumbUrl);
      localrl.twu.a(localrt);
    }
    GMTrace.o(728936480768L, 5431);
    return localrl;
  }
  
  private static rl a(au paramau, f.a parama, int paramInt)
  {
    GMTrace.i(728265392128L, 5426);
    rl localrl = new rl();
    a(localrl, paramau);
    localrl.NR(parama.hhx);
    localrl.NS(parama.hhy);
    localrl.NQ(parama.url);
    localrl.jG(true);
    paramau = new File(bf.ap(com.tencent.mm.ah.n.GT().v(paramau.field_imgPath, true), ""));
    if (paramau.exists()) {
      localrl.NZ(paramau.getAbsolutePath());
    }
    for (;;)
    {
      localrl.NK(parama.title);
      localrl.NL(parama.description);
      localrl.Oj(parama.canvasPageXml);
      localrl.xW(paramInt);
      localrl.Oi(parama.fUO);
      GMTrace.o(728265392128L, 5426);
      return localrl;
      localrl.jH(true);
    }
  }
  
  private static void a(rl paramrl1, rl paramrl2)
  {
    GMTrace.i(728802263040L, 5430);
    paramrl1.NR(paramrl2.tvJ);
    paramrl1.NS(paramrl2.tvL);
    paramrl1.NQ(paramrl2.tvH);
    paramrl1.NK(paramrl2.title);
    paramrl1.NL(paramrl2.desc);
    GMTrace.o(728802263040L, 5430);
  }
  
  private static void a(rl paramrl, au paramau)
  {
    GMTrace.i(727996956672L, 5424);
    if (paramau.field_isSend == 1)
    {
      if ((com.tencent.mm.u.o.dH(paramau.field_talker)) || (paramau.field_talker.equals("filehelper")))
      {
        paramrl.Oc(String.valueOf(paramau.field_msgSvrId));
        GMTrace.o(727996956672L, 5424);
        return;
      }
      paramrl.Oc(paramau.field_talker + "#" + String.valueOf(paramau.field_msgSvrId));
      GMTrace.o(727996956672L, 5424);
      return;
    }
    paramrl.Oc(String.valueOf(paramau.field_msgSvrId));
    GMTrace.o(727996956672L, 5424);
  }
  
  public static boolean a(cb paramcb, int paramInt, String paramString)
  {
    GMTrace.i(727325868032L, 5419);
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcb.fFr.fFx = R.l.ehT;
      GMTrace.o(727325868032L, 5419);
      return false;
    }
    v.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    ru localru = new ru();
    rv localrv = new rv();
    rl localrl = new rl();
    localrl.xW(2);
    localrl.NY(paramString);
    localrl.NX(g.n((localrl.toString() + 2 + System.currentTimeMillis()).getBytes()));
    Object localObject = new fp();
    ((fp)localObject).fKg.type = 27;
    ((fp)localObject).fKg.fKi = localrl;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((fp)localObject).fKh.fKq;
    com.tencent.mm.sdk.platformtools.d.b(paramString, 150, 150, Bitmap.CompressFormat.JPEG, 90, (String)localObject);
    localrl.NZ((String)localObject);
    localrv.OC(m.xL());
    localrv.OD(m.xL());
    localrv.ye(paramInt);
    localrv.ep(bf.NA());
    localru.a(localrv);
    localru.txF.add(localrl);
    paramcb.fFr.title = localrl.title;
    paramcb.fFr.fFt = localru;
    paramcb.fFr.type = 2;
    GMTrace.o(727325868032L, 5419);
    return true;
  }
  
  public static boolean a(cb paramcb, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(727191650304L, 5418);
    if (bf.mA(paramString1))
    {
      v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
      paramcb.fFr.fFx = R.l.ehT;
      GMTrace.o(727191650304L, 5418);
      return false;
    }
    v.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", new Object[] { paramString2, paramString3, paramString1, Integer.valueOf(paramInt) });
    if (new File(paramString1).length() > com.tencent.mm.i.b.sD())
    {
      paramcb.fFr.fFx = R.l.ejz;
      GMTrace.o(727191650304L, 5418);
      return false;
    }
    ru localru = new ru();
    rv localrv = new rv();
    rl localrl = new rl();
    localrl.NY(paramString1);
    localrl.xW(8);
    localrl.NU(com.tencent.mm.a.e.aQ(paramString1));
    localrl.jH(true);
    localrl.NK(paramString2);
    localrl.NL(paramString3);
    localrv.OC(m.xL());
    localrv.OD(m.xL());
    localrv.ye(paramInt);
    localrv.ep(bf.NA());
    localru.a(localrv);
    localru.txF.add(localrl);
    paramcb.fFr.title = localrl.title;
    paramcb.fFr.desc = localrl.title;
    paramcb.fFr.fFt = localru;
    paramcb.fFr.type = 8;
    GMTrace.o(727191650304L, 5418);
    return true;
  }
  
  public static boolean a(cb paramcb, long paramLong)
  {
    GMTrace.i(727460085760L, 5420);
    boolean bool = a(paramcb, ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().cA(paramLong));
    GMTrace.o(727460085760L, 5420);
    return bool;
  }
  
  public static boolean a(cb paramcb, Intent paramIntent)
  {
    GMTrace.i(727057432576L, 5417);
    if (paramcb == null)
    {
      v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
      if (paramcb.fFr != null) {
        paramcb.fFr.fFx = R.l.ehT;
      }
      GMTrace.o(727057432576L, 5417);
      return false;
    }
    double d1 = paramIntent.getDoubleExtra("kwebmap_slat", 0.0D);
    double d2 = paramIntent.getDoubleExtra("kwebmap_lng", 0.0D);
    int i = paramIntent.getIntExtra("kwebmap_scale", 0);
    Object localObject1 = bf.ap(paramIntent.getStringExtra("Kwebmap_locaion"), "");
    Object localObject2 = paramIntent.getStringExtra("kPoiName");
    paramIntent.getCharSequenceExtra("kRemark");
    paramIntent.getStringArrayListExtra("kTags");
    paramIntent = new rr();
    paramIntent.Ot((String)localObject1);
    paramIntent.m(d1);
    paramIntent.l(d2);
    paramIntent.ya(i);
    paramIntent.Ou((String)localObject2);
    localObject1 = new ru();
    localObject2 = new rv();
    String str = m.xL();
    ((rv)localObject2).OC(str);
    ((rv)localObject2).OD(str);
    ((rv)localObject2).ye(6);
    ((rv)localObject2).ep(bf.NA());
    ((ru)localObject1).b(paramIntent);
    ((ru)localObject1).a((rv)localObject2);
    paramcb.fFr.fFt = ((ru)localObject1);
    paramcb.fFr.type = 6;
    GMTrace.o(727057432576L, 5417);
    return true;
  }
  
  public static boolean a(cb paramcb, au paramau)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    GMTrace.i(727594303488L, 5421);
    if ((paramcb == null) || (paramau == null))
    {
      v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
      if (paramcb != null) {
        paramcb.fFr.fFx = R.l.ehT;
      }
      GMTrace.o(727594303488L, 5421);
      return false;
    }
    au localau = au.Y(paramau);
    if (localau.bMa())
    {
      paramau = new ru();
      paramau.a(S(localau));
      paramcb.fFr.fFt = paramau;
      if (!localau.bMm())
      {
        paramcb.fFr.desc = localau.field_content;
        paramcb.fFr.type = 1;
        if (com.tencent.mm.ui.tools.h.Ul(paramcb.fFr.desc) <= com.tencent.mm.i.b.sz()) {
          break label236;
        }
        paramcb.fFr.fFx = R.l.ejx;
      }
    }
    label236:
    Object localObject2;
    label326:
    Object localObject3;
    for (;;)
    {
      paramcb.fFr.fFj = localau.field_content;
      if ((bool1) || (paramcb.fFr.fFx == 0)) {
        c.a(localau, paramcb, bool1);
      }
      GMTrace.o(727594303488L, 5421);
      return bool1;
      paramcb.fFr.desc = (localau.field_content + "\n\n" + localau.field_transContent);
      break;
      bool1 = true;
      continue;
      if (localau.bLP())
      {
        localObject1 = new ru();
        ((ru)localObject1).a(S(localau));
        localObject2 = new rl();
        a((rl)localObject2, localau);
        if (com.tencent.mm.u.o.fq(localau.field_talker))
        {
          paramau = localau.field_imgPath;
          paramau = com.tencent.mm.sdk.platformtools.h.a(com.tencent.mm.plugin.record.b.xg(), "recbiz_", paramau, ".rec", 2);
          if (bf.mA(paramau))
          {
            paramau = null;
            ((rl)localObject2).NY(paramau);
          }
        }
        for (;;)
        {
          ((rl)localObject2).xW(3);
          ((rl)localObject2).jH(true);
          paramau = q.lW(localau.field_imgPath);
          if (paramau == null) {
            break;
          }
          ((rl)localObject2).NU(wQ(paramau.getFormat()));
          ((rl)localObject2).xV((int)new com.tencent.mm.modelvoice.n(localau.field_content).time);
          paramau = new LinkedList();
          paramau.add(localObject2);
          ((ru)localObject1).av(paramau);
          paramcb.fFr.fFt = ((ru)localObject1);
          paramcb.fFr.type = 3;
          bool1 = true;
          break;
          new File(paramau).exists();
          break label326;
          ((rl)localObject2).NY(q.jt(localau.field_imgPath));
        }
      }
      if (localau.bLZ())
      {
        bool1 = b(paramcb, localau);
      }
      else if (localau.bLX())
      {
        paramau = null;
        if (localau.field_msgId > 0L) {
          paramau = com.tencent.mm.ah.n.GT().aj(localau.field_msgId);
        }
        if (paramau != null)
        {
          localObject1 = paramau;
          if (paramau.hEG > 0L) {}
        }
        else
        {
          localObject1 = paramau;
          if (localau.field_msgSvrId > 0L) {
            localObject1 = com.tencent.mm.ah.n.GT().ai(localau.field_msgSvrId);
          }
        }
        if (localObject1 == null)
        {
          v.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
          paramcb.fFr.fFx = R.l.ehZ;
        }
        else
        {
          paramau = new ru();
          paramau.a(S(localau));
          localObject2 = new rl();
          a((rl)localObject2, localau);
          ((rl)localObject2).xW(2);
          ((rl)localObject2).NY(com.tencent.mm.ah.n.GT().m(com.tencent.mm.ah.e.c((com.tencent.mm.ah.d)localObject1), "", ""));
          if (((com.tencent.mm.ah.d)localObject1).GC())
          {
            localObject1 = com.tencent.mm.ah.n.GT().fT(((com.tencent.mm.ah.d)localObject1).hEQ);
            if (((com.tencent.mm.ah.d)localObject1).hrb > ((com.tencent.mm.ah.d)localObject1).offset) {
              ((rl)localObject2).NY(com.tencent.mm.ah.n.GT().m("SERVERID://" + localau.field_msgSvrId, "", ""));
            }
          }
          ((rl)localObject2).NZ(com.tencent.mm.ah.n.GT().v(localau.field_imgPath, true));
          localObject1 = new LinkedList();
          ((LinkedList)localObject1).add(localObject2);
          paramau.av((LinkedList)localObject1);
          paramcb.fFr.fFt = paramau;
          paramcb.fFr.type = 2;
          bool1 = true;
        }
      }
      else if ((localau.bMb()) || (localau.bMc()))
      {
        localObject1 = new ru();
        ((ru)localObject1).a(S(localau));
        paramau = new rl();
        a(paramau, localau);
        com.tencent.mm.modelvideo.o.KW();
        paramau.NZ(com.tencent.mm.modelvideo.s.lx(localau.field_imgPath));
        paramau.NU(com.tencent.mm.a.e.aQ(paramau.tvY));
        localObject2 = t.lI(localau.field_imgPath);
        v.i("MicroMsg.GetFavDataSource", "video length is %d", new Object[] { Integer.valueOf(((r)localObject2).hrb) });
        if (((r)localObject2).hrb > com.tencent.mm.i.b.sD())
        {
          paramcb.fFr.fFx = R.l.ejz;
        }
        else if ((localau.bMc()) && (t.lK(((r)localObject2).getFileName())))
        {
          paramcb.fFr.fFx = R.l.ehS;
        }
        else
        {
          if (((r)localObject2).Ll())
          {
            com.tencent.mm.modelvideo.o.KW();
            localObject3 = com.tencent.mm.modelvideo.s.lw(localau.field_imgPath);
            v.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", new Object[] { localObject3 });
            paramau.NY((String)localObject3);
            label1004:
            paramau.xV(((r)localObject2).hZV);
            localObject2 = new LinkedList();
            ((LinkedList)localObject2).add(paramau);
            ((ru)localObject1).av((LinkedList)localObject2);
            paramcb.fFr.fFt = ((ru)localObject1);
            if (!localau.bMc()) {
              break label1234;
            }
            paramcb.fFr.type = 16;
            paramau.xW(15);
          }
          for (;;)
          {
            localObject1 = t.lI(localau.field_imgPath);
            paramau.Oi(((r)localObject1).fUO);
            localObject1 = ((r)localObject1).iae;
            if ((localObject1 != null) && (!bf.mA(((bdq)localObject1).hjz)))
            {
              localObject2 = new ro();
              ((ro)localObject2).hjt = ((bdq)localObject1).hjt;
              ((ro)localObject2).txr = ((bdq)localObject1).txr;
              ((ro)localObject2).hjw = ((bdq)localObject1).hjw;
              ((ro)localObject2).hjx = ((bdq)localObject1).hjx;
              ((ro)localObject2).hjv = ((bdq)localObject1).hjv;
              ((ro)localObject2).hjy = ((bdq)localObject1).hjy;
              ((ro)localObject2).hjz = ((bdq)localObject1).hjz;
              ((ro)localObject2).hjA = ((bdq)localObject1).hjA;
              paramau.a((ro)localObject2);
            }
            bool1 = true;
            break;
            v.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
            paramau.NY("");
            break label1004;
            label1234:
            paramcb.fFr.type = 4;
            paramau.xW(4);
          }
        }
      }
      else
      {
        if ((!localau.bLN()) && (!localau.bLO())) {
          break label1277;
        }
        bool1 = c(paramcb, localau);
      }
    }
    label1277:
    if (localau.bLY()) {}
    while ((!localau.axH()) || (localau.bMe()))
    {
      paramcb.fFr.fFx = R.l.eib;
      break;
    }
    paramau = new ru();
    paramau.a(S(localau));
    Object localObject1 = localau.field_content;
    if (localObject1 == null)
    {
      paramcb.fFr.fFx = R.l.eic;
      bool1 = false;
    }
    for (;;)
    {
      break;
      localObject1 = f.a.ek((String)localObject1);
      if (localObject1 == null)
      {
        paramcb.fFr.fFx = R.l.eic;
        bool1 = false;
      }
      else
      {
        paramcb.fFr.fFt = paramau;
        localObject2 = paramau.txD;
        ((rv)localObject2).OI(((f.a)localObject1).appId);
        ((rv)localObject2).OK(((f.a)localObject1).fUH);
        switch (((f.a)localObject1).type)
        {
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 21: 
        case 22: 
        case 23: 
        default: 
          paramcb.fFr.fFx = R.l.eib;
          bool1 = false;
          break;
        case 1: 
          paramcb.fFr.fFt = paramau;
          paramcb.fFr.desc = ((f.a)localObject1).title;
          paramcb.fFr.type = 1;
          bool1 = bool2;
          break;
        case 2: 
          if (!com.tencent.mm.kernel.h.vI().isSDCardAvailable())
          {
            paramcb.fFr.fFx = R.l.eii;
            bool1 = false;
          }
          else
          {
            localObject3 = com.tencent.mm.plugin.w.a.abF().LV(((f.a)localObject1).fCN);
            localObject2 = new rl();
            a((rl)localObject2, localau);
            if (localObject3 != null) {
              ((rl)localObject2).NY(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath);
            }
            localObject3 = com.tencent.mm.ah.n.GT().v(localau.field_imgPath, true);
            if (com.tencent.mm.a.e.aO((String)localObject3)) {
              ((rl)localObject2).NZ((String)localObject3);
            }
            ((rl)localObject2).xW(2);
            ((rl)localObject2).NK(((f.a)localObject1).title);
            ((rl)localObject2).NL(((f.a)localObject1).description);
            paramau.txF.add(localObject2);
            paramcb.fFr.type = 2;
            bool1 = bool2;
          }
          break;
        case 3: 
          localObject1 = a(localau, (f.a)localObject1, 7);
          paramau.txF.add(localObject1);
          paramcb.fFr.type = 7;
          bool1 = bool2;
          break;
        case 4: 
          localObject1 = a(localau, (f.a)localObject1, 4);
          paramau.OA(((rl)localObject1).title);
          paramau.OB(((rl)localObject1).desc);
          paramau.txF.add(localObject1);
          paramcb.fFr.type = 4;
          bool1 = bool2;
          break;
        case 5: 
          if ((((f.a)localObject1).url != null) && (!((f.a)localObject1).url.equals("")))
          {
            paramau.txD.OJ(((f.a)localObject1).url);
            localObject1 = a(localau, (f.a)localObject1, 5);
            paramau.txF.add(localObject1);
            paramau.OA(((rl)localObject1).title);
            paramau.OB(((rl)localObject1).desc);
            paramcb.fFr.type = 5;
            bool1 = bool2;
          }
          else
          {
            paramcb.fFr.fFx = R.l.ehX;
            bool1 = false;
          }
          break;
        case 6: 
          if (!com.tencent.mm.kernel.h.vI().isSDCardAvailable())
          {
            paramcb.fFr.fFx = R.l.eii;
            bool1 = false;
          }
          else
          {
            localObject3 = com.tencent.mm.plugin.w.a.abF().LV(((f.a)localObject1).fCN);
            localObject2 = new rl();
            if (localObject3 != null) {
              ((rl)localObject2).NY(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath);
            }
            a((rl)localObject2, localau);
            ((rl)localObject2).xW(8);
            ((rl)localObject2).NU(((f.a)localObject1).hhh);
            localObject3 = com.tencent.mm.ah.n.GT().v(localau.field_imgPath, true);
            if (bf.mA((String)localObject3)) {
              ((rl)localObject2).jH(true);
            }
            if (com.tencent.mm.a.e.aO((String)localObject3)) {
              ((rl)localObject2).NZ((String)localObject3);
            }
            ((rl)localObject2).NK(((f.a)localObject1).title);
            ((rl)localObject2).NL(((f.a)localObject1).description);
            paramau.txF.add(localObject2);
            paramcb.fFr.desc = ((f.a)localObject1).title;
            paramcb.fFr.type = 8;
            bool1 = bool2;
          }
          break;
        case 7: 
          if ((((f.a)localObject1).fCN == null) || (((f.a)localObject1).fCN.length() == 0)) {
            paramcb.fFr.fFx = R.l.ehU;
          }
          while (com.tencent.mm.kernel.h.vI().isSDCardAvailable())
          {
            paramcb.fFr.fFx = R.l.eib;
            bool1 = false;
            break;
          }
          paramcb.fFr.fFx = R.l.eii;
          bool1 = false;
          break;
        case 10: 
          localObject2 = new rt();
          ((rt)localObject2).Ov(((f.a)localObject1).title);
          ((rt)localObject2).Ow(((f.a)localObject1).description);
          ((rt)localObject2).yb(((f.a)localObject1).hhB);
          ((rt)localObject2).Oy(((f.a)localObject1).hhC);
          ((rt)localObject2).Ox(((f.a)localObject1).thumburl);
          paramcb.fFr.title = ((f.a)localObject1).title;
          paramcb.fFr.desc = ((f.a)localObject1).description;
          paramcb.fFr.type = 10;
          paramau.b((rt)localObject2);
          bool1 = bool2;
          break;
        case 20: 
          localObject2 = new ry();
          ((ry)localObject2).OL(((f.a)localObject1).title);
          ((ry)localObject2).OM(((f.a)localObject1).description);
          ((ry)localObject2).OO(((f.a)localObject1).hhF);
          ((ry)localObject2).ON(((f.a)localObject1).thumburl);
          paramcb.fFr.title = ((f.a)localObject1).title;
          paramcb.fFr.desc = ((f.a)localObject1).description;
          paramcb.fFr.type = 15;
          paramau.b((ry)localObject2);
          bool1 = bool2;
          break;
        case 13: 
          localObject2 = new rt();
          ((rt)localObject2).Ov(((f.a)localObject1).title);
          ((rt)localObject2).Ow(((f.a)localObject1).description);
          ((rt)localObject2).yb(((f.a)localObject1).hhH);
          ((rt)localObject2).Oy(((f.a)localObject1).hhI);
          ((rt)localObject2).Ox(((f.a)localObject1).thumburl);
          paramcb.fFr.title = ((f.a)localObject1).title;
          paramcb.fFr.desc = ((f.a)localObject1).description;
          paramcb.fFr.type = 11;
          paramau.b((rt)localObject2);
          bool1 = bool2;
          break;
        case 19: 
        case 24: 
          paramcb.fFr.fFu = new sd();
          bool1 = a(paramcb, (f.a)localObject1, paramau, localau);
        }
      }
    }
  }
  
  private static boolean a(cb paramcb, f.a parama, ru paramru, au paramau)
  {
    GMTrace.i(728533827584L, 5428);
    Object localObject1 = new lz();
    ((lz)localObject1).fSV.type = 0;
    ((lz)localObject1).fSV.fSX = parama.hhG;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
    com.tencent.mm.protocal.b.a.c localc = ((lz)localObject1).fSW.fTf;
    if (localc == null)
    {
      v.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
      paramcb.fFr.fFx = R.l.eic;
      GMTrace.o(728533827584L, 5428);
      return false;
    }
    paramru.OA(localc.title);
    Iterator localIterator = localc.hkc.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject1 = (rl)localIterator.next();
      switch (((rl)localObject1).aMw)
      {
      case 9: 
      case 13: 
      default: 
        parama = null;
        label226:
        if (parama != null) {
          if (paramau.field_isSend == 1) {
            if ((com.tencent.mm.u.o.dH(paramau.field_talker)) || (paramau.field_talker.equals("filehelper")))
            {
              localObject1 = String.format("%d$%d", new Object[] { Long.valueOf(paramau.field_msgSvrId), Integer.valueOf(i) });
              label291:
              parama.Oc((String)localObject1);
              paramru.txF.add(parama);
              i += 1;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      break;
      long l = paramau.field_msgId;
      parama = q((rl)localObject1);
      parama.xW(3);
      if (!bf.mA(((rl)localObject1).twC))
      {
        localObject2 = new lz();
        ((lz)localObject2).fSV.type = 1;
        ((lz)localObject2).fSV.fJV = ((rl)localObject1);
        ((lz)localObject2).fSV.fGD = l;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
        if ((bf.mA(((lz)localObject2).fSW.fTg)) && (bf.mA(((lz)localObject2).fSW.fKq))) {
          v.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
        }
        parama.NY(((lz)localObject2).fSW.fTg);
        parama.xV(((rl)localObject1).duration);
        parama.jH(true);
        parama.jG(false);
        parama.NU(((rl)localObject1).tvP);
      }
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).txS += 1;
      break label226;
      parama = q((rl)localObject1);
      parama.xW(1);
      parama.NL(((rl)localObject1).desc);
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).txQ += 1;
      break label226;
      l = paramau.field_msgId;
      parama = q((rl)localObject1);
      parama.xW(2);
      Object localObject2 = new lz();
      ((lz)localObject2).fSV.type = 1;
      ((lz)localObject2).fSV.fJV = ((rl)localObject1);
      ((lz)localObject2).fSV.fGD = l;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      if ((bf.mA(((lz)localObject2).fSW.fTg)) && (bf.mA(((lz)localObject2).fSW.fKq))) {
        v.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
      }
      parama.NY(((lz)localObject2).fSW.fTg);
      parama.NZ(((lz)localObject2).fSW.fKq);
      parama.jH(false);
      parama.jG(false);
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).txR += 1;
      break label226;
      l = paramau.field_msgId;
      parama = q((rl)localObject1);
      a(parama, (rl)localObject1);
      parama.xW(5);
      localObject2 = new lz();
      ((lz)localObject2).fSV.type = 1;
      ((lz)localObject2).fSV.fJV = ((rl)localObject1);
      ((lz)localObject2).fSV.fGD = l;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      if ((bf.mA(((lz)localObject2).fSW.fTg)) && (bf.mA(((lz)localObject2).fSW.fKq))) {
        v.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
      }
      parama.NZ(((lz)localObject2).fSW.fKq);
      parama.jH(false);
      if ((((rl)localObject1).twu != null) && (((rl)localObject1).twu.twQ != null))
      {
        localObject2 = new se();
        ((se)localObject2).OP(((rl)localObject1).twu.twQ.title);
        ((se)localObject2).OQ(((rl)localObject1).twu.twQ.desc);
        ((se)localObject2).OS(((rl)localObject1).twu.twQ.thumbUrl);
        ((se)localObject2).yf(((rl)localObject1).twu.twQ.tyh);
        ((se)localObject2).OR(((rl)localObject1).twu.twQ.tyf);
        parama.twu.a((se)localObject2);
      }
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).txU += 1;
      break label226;
      l = paramau.field_msgId;
      parama = q((rl)localObject1);
      a(parama, (rl)localObject1);
      if (((rl)localObject1).aMw == 15) {
        parama.xW(15);
      }
      for (;;)
      {
        localObject2 = new lz();
        ((lz)localObject2).fSV.type = 1;
        ((lz)localObject2).fSV.fJV = ((rl)localObject1);
        ((lz)localObject2).fSV.fGD = l;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
        if ((bf.mA(((lz)localObject2).fSW.fTg)) && (bf.mA(((lz)localObject2).fSW.fKq))) {
          v.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
        }
        parama.jG(false);
        parama.NY(((lz)localObject2).fSW.fTg);
        parama.jH(false);
        parama.NZ(((lz)localObject2).fSW.fKq);
        parama.xV(((rl)localObject1).duration);
        localObject1 = paramcb.fFr.fFu;
        ((sd)localObject1).txT += 1;
        break;
        parama.xW(4);
      }
      parama = q((rl)localObject1);
      parama.xW(6);
      if ((((rl)localObject1).twu != null) && (((rl)localObject1).twu.twO != null))
      {
        localObject2 = new rr();
        ((rr)localObject2).Ot(((rl)localObject1).twu.twO.label);
        ((rr)localObject2).m(((rl)localObject1).twu.twO.lat);
        ((rr)localObject2).l(((rl)localObject1).twu.twO.lng);
        ((rr)localObject2).ya(((rl)localObject1).twu.twO.fNU);
        ((rr)localObject2).Ou(((rl)localObject1).twu.twO.fRN);
        parama.twu.a((rr)localObject2);
      }
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).txV += 1;
      break label226;
      l = paramau.field_msgId;
      parama = q((rl)localObject1);
      a(parama, (rl)localObject1);
      parama.xW(7);
      localObject2 = new lz();
      ((lz)localObject2).fSV.type = 1;
      ((lz)localObject2).fSV.fJV = ((rl)localObject1);
      ((lz)localObject2).fSV.fGD = l;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      if ((bf.mA(((lz)localObject2).fSW.fTg)) && (bf.mA(((lz)localObject2).fSW.fKq))) {
        v.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
      }
      parama.NZ(((lz)localObject2).fSW.fKq);
      parama.jH(false);
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).txW += 1;
      break label226;
      l = paramau.field_msgId;
      parama = q((rl)localObject1);
      a(parama, (rl)localObject1);
      parama.xW(8);
      localObject2 = new lz();
      ((lz)localObject2).fSV.type = 1;
      ((lz)localObject2).fSV.fJV = ((rl)localObject1);
      ((lz)localObject2).fSV.fGD = l;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      if ((bf.mA(((lz)localObject2).fSW.fTg)) && (bf.mA(((lz)localObject2).fSW.fKq))) {
        v.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
      }
      parama.NY(((lz)localObject2).fSW.fTg);
      parama.NZ(((lz)localObject2).fSW.fKq);
      parama.jG(false);
      parama.NU(((rl)localObject1).tvP);
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).txX += 1;
      break label226;
      parama = a((rl)localObject1, ((rl)localObject1).aMw);
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).txZ += 1;
      break label226;
      parama = a((rl)localObject1, ((rl)localObject1).aMw);
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).tya += 1;
      break label226;
      parama = q((rl)localObject1);
      parama.xW(14);
      if ((((rl)localObject1).twu != null) && (((rl)localObject1).twu.twU != null))
      {
        localObject2 = new ry();
        ((ry)localObject2).OL(((rl)localObject1).twu.twU.title);
        ((ry)localObject2).OM(((rl)localObject1).twu.twU.desc);
        ((ry)localObject2).OO(((rl)localObject1).twu.twU.info);
        ((ry)localObject2).ON(((rl)localObject1).twu.twU.thumbUrl);
        parama.twu.a((ry)localObject2);
      }
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).tyd += 1;
      break label226;
      parama = q((rl)localObject1);
      parama.xW(16);
      parama.NL(((rl)localObject1).desc);
      localObject1 = paramcb.fFr.fFu;
      ((sd)localObject1).tye += 1;
      break label226;
      parama = q((rl)localObject1);
      parama.NK(((rl)localObject1).title);
      parama.NL(((rl)localObject1).desc);
      parama.xW(17);
      parama.Ok(((rl)localObject1).twK);
      break label226;
      localObject1 = String.format("%s#%d$%d", new Object[] { paramau.field_talker, Long.valueOf(paramau.field_msgSvrId), Integer.valueOf(i) });
      break label291;
      localObject1 = String.format("%d$%d", new Object[] { Long.valueOf(paramau.field_msgSvrId), Integer.valueOf(i) });
      break label291;
      if ((!bf.mA(((rl)localc.hkc.get(0)).tvP)) && (((rl)localc.hkc.get(0)).tvP.equals(".htm"))) {}
      for (paramcb.fFr.type = 18;; paramcb.fFr.type = 14)
      {
        GMTrace.o(728533827584L, 5428);
        return true;
      }
    }
  }
  
  private static boolean b(cb paramcb, au paramau)
  {
    GMTrace.i(727862738944L, 5423);
    ru localru = new ru();
    localru.a(S(paramau));
    paramau = bg.q(paramau.field_content, "msg");
    if (paramau != null) {
      try
      {
        rr localrr = new rr();
        localrr.Ot((String)paramau.get(".msg.location.$label"));
        localrr.m(Double.parseDouble((String)paramau.get(".msg.location.$x")));
        localrr.l(Double.parseDouble((String)paramau.get(".msg.location.$y")));
        localrr.ya(Integer.valueOf((String)paramau.get(".msg.location.$scale")).intValue());
        localrr.Ou((String)paramau.get(".msg.location.$poiname"));
        localru.b(localrr);
        paramcb.fFr.type = 6;
        paramcb.fFr.fFt = localru;
        GMTrace.o(727862738944L, 5423);
        return true;
      }
      catch (Exception paramau)
      {
        v.e("MicroMsg.GetFavDataSource", "parse failed, %s", new Object[] { paramau.getStackTrace().toString() });
      }
    }
    paramcb.fFr.fFx = R.l.eic;
    GMTrace.o(727862738944L, 5423);
    return false;
  }
  
  private static boolean c(cb paramcb, au paramau)
  {
    GMTrace.i(728399609856L, 5427);
    ru localru = new ru();
    Object localObject1 = S(paramau);
    localru.a((rv)localObject1);
    try
    {
      Object localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rR(paramau.field_content);
      Object localObject3 = ((k)localObject2).hkc;
      ((rv)localObject1).OK(((k)localObject2).fUH);
      if ((localObject3 != null) && (((List)localObject3).size() > paramcb.fFr.fFv))
      {
        v.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", new Object[] { Integer.valueOf(paramcb.fFr.fFv) });
        localObject2 = (l)((List)localObject3).get(paramcb.fFr.fFv);
        ((rv)localObject1).OJ(((l)localObject2).url);
        if (paramcb.fFr.fFv > 0) {
          ((rv)localObject1).OE("");
        }
        localObject3 = new rl();
        ((rl)localObject3).NK(((l)localObject2).title);
        ((rl)localObject3).NL(((l)localObject2).hkk);
        a((rl)localObject3, paramau);
        localObject1 = ((l)localObject2).hki;
        if (!bf.mA((String)localObject1)) {
          break label473;
        }
        com.tencent.mm.x.h localh = com.tencent.mm.x.n.Bm().hs(paramau.field_talker);
        if (localh == null) {
          break label473;
        }
        localObject1 = localh.Bs();
      }
      for (;;)
      {
        if (!bf.mA((String)localObject1))
        {
          int i = paramau.field_type;
          if (paramcb.fFr.fFv > 0)
          {
            paramau = "@S";
            ((rl)localObject3).NZ(s.n((String)localObject1, i, paramau));
            ((rl)localObject3).jH(false);
            if ((bf.mA(((rl)localObject3).twa)) || (!FileOp.aO(((rl)localObject3).twa)))
            {
              ((rl)localObject3).NT((String)localObject1);
              ((rl)localObject3).jH(true);
              paramau = new se();
              paramau.OS((String)localObject1);
              localru.b(paramau);
            }
          }
        }
        for (;;)
        {
          ((rl)localObject3).jG(true);
          ((rl)localObject3).xW(5);
          localru.txF.add(localObject3);
          paramcb.fFr.fFt = localru;
          paramcb.fFr.desc = ((l)localObject2).title;
          paramcb.fFr.type = 5;
          GMTrace.o(728399609856L, 5427);
          return true;
          paramau = "@T";
          break;
          ((rl)localObject3).jH(true);
        }
      }
    }
    catch (Exception paramau)
    {
      v.printErrStackTrace("MicroMsg.GetFavDataSource", paramau, "", new Object[0]);
      v.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", new Object[] { paramau.getLocalizedMessage() });
      paramcb.fFr.fFx = R.l.eic;
      GMTrace.o(728399609856L, 5427);
      return false;
    }
  }
  
  private static rl q(rl paramrl)
  {
    GMTrace.i(728668045312L, 5429);
    rl localrl = new rl();
    rm localrm = new rm();
    rn localrn1 = new rn();
    rn localrn2 = paramrl.twu.twM;
    if (localrn2.txe) {
      localrn1.Ol(localrn2.fOl);
    }
    if (localrn2.txf) {
      localrn1.Om(localrn2.toUser);
    }
    if (localrn2.txj) {
      localrn1.Oo(localrn2.txi);
    }
    localrn1.xZ(1);
    localrn1.em(bf.NA());
    localrm.c(localrn1);
    localrl.a(localrm);
    localrl.Of(paramrl.tww);
    localrl.Og(paramrl.twy);
    localrl.jH(true);
    localrl.jG(true);
    localrl.Oh(paramrl.twC);
    localrl.xY(paramrl.twI);
    localrl.NV(paramrl.tvR);
    localrl.NW(paramrl.tvT);
    localrl.ej(paramrl.tvV);
    localrl.Oa(paramrl.twc);
    localrl.Ob(paramrl.twe);
    localrl.ek(paramrl.twg);
    GMTrace.o(728668045312L, 5429);
    return localrl;
  }
  
  public static String wQ(int paramInt)
  {
    GMTrace.i(728131174400L, 5425);
    if (paramInt == 1)
    {
      GMTrace.o(728131174400L, 5425);
      return "speex";
    }
    if (paramInt == 4)
    {
      GMTrace.o(728131174400L, 5425);
      return "silk";
    }
    GMTrace.o(728131174400L, 5425);
    return "amr";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */