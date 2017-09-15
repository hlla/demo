package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.fb;
import com.tencent.mm.e.a.fb.a;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l.l;
import com.tencent.mm.protocal.c.ast;
import com.tencent.mm.protocal.c.bib;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.bg;
import com.tencent.mm.u.ag.f;
import com.tencent.mm.u.am;
import com.tencent.mm.u.an;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements am, an
{
  public static com.tencent.mm.storage.bf qQs;
  private Map<String, am> hnK;
  private a qQt;
  
  public a()
  {
    GMTrace.i(5848940150784L, 43578);
    this.hnK = new HashMap();
    v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
    this.hnK = oI();
    GMTrace.o(5848940150784L, 43578);
  }
  
  public final am Hh(String paramString)
  {
    GMTrace.i(5849879674880L, 43585);
    paramString = (am)this.hnK.get(paramString);
    GMTrace.o(5849879674880L, 43585);
    return paramString;
  }
  
  public final void aM(boolean paramBoolean)
  {
    GMTrace.i(5849342803968L, 43581);
    v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
    Iterator localIterator = this.hnK.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((am)((Map.Entry)localIterator.next()).getValue()).aM(paramBoolean);
    }
    if (this.qQt == null) {
      this.qQt = new a();
    }
    com.tencent.mm.sdk.b.a.uql.b(this.qQt);
    GMTrace.o(5849342803968L, 43581);
  }
  
  public final void aN(boolean paramBoolean)
  {
    GMTrace.i(5849477021696L, 43582);
    v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
    Iterator localIterator = this.hnK.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((am)((Map.Entry)localIterator.next()).getValue()).aN(paramBoolean);
    }
    GMTrace.o(5849477021696L, 43582);
  }
  
  public final void b(String paramString, am paramam)
  {
    GMTrace.i(5850013892608L, 43586);
    this.hnK.put(paramString, paramam);
    GMTrace.o(5850013892608L, 43586);
  }
  
  public final void eD(int paramInt)
  {
    GMTrace.i(5849208586240L, 43580);
    v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
    Iterator localIterator = this.hnK.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((am)((Map.Entry)localIterator.next()).getValue()).eD(paramInt);
    }
    GMTrace.o(5849208586240L, 43580);
  }
  
  public final Map<String, am> oI()
  {
    GMTrace.i(5849745457152L, 43584);
    v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    localHashMap.put(com.tencent.mm.ae.d.class.getName(), new com.tencent.mm.ae.d());
    localHashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
    localHashMap.put(com.tencent.mm.plugin.subapp.a.c.class.getName(), new com.tencent.mm.plugin.subapp.a.c());
    Object localObject = new com.tencent.mm.plugin.subapp.c.d();
    com.tencent.mm.u.ag.a.hlD = (ag.f)localObject;
    localHashMap.put(com.tencent.mm.plugin.subapp.c.d.class.getName(), localObject);
    localObject = new com.tencent.mm.plugin.subapp.jdbiz.c();
    localHashMap.put(com.tencent.mm.plugin.subapp.jdbiz.c.class.getName(), localObject);
    com.tencent.mm.pluginsdk.l.aa.sAa = (l.l)localObject;
    localObject = new com.tencent.mm.modelmulti.p();
    localHashMap.put(com.tencent.mm.modelmulti.p.class.getName(), localObject);
    GMTrace.o(5849745457152L, 43584);
    return localHashMap;
  }
  
  public final void onAccountRelease()
  {
    GMTrace.i(5849611239424L, 43583);
    v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
    Iterator localIterator = this.hnK.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((am)((Map.Entry)localIterator.next()).getValue()).onAccountRelease();
    }
    if (this.qQt != null) {
      com.tencent.mm.sdk.b.a.uql.c(this.qQt);
    }
    GMTrace.o(5849611239424L, 43583);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, g.c> uh()
  {
    GMTrace.i(5849074368512L, 43579);
    v.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.hnK.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((am)localEntry.getValue()).uh() != null) {
        localHashMap.putAll(((am)localEntry.getValue()).uh());
      }
    }
    GMTrace.o(5849074368512L, 43579);
    return localHashMap;
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<fb>
    implements e
  {
    private volatile boolean qQA;
    public boolean qQB;
    private ai qQC;
    private fb qQD;
    private boolean qQE;
    private int qQF;
    private Map<String, String> qQG;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.a qQv;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.c qQw;
    private com.tencent.mm.plugin.subapp.ui.voicetranstext.b qQx;
    private com.tencent.mm.modelvoice.b qQy;
    private com.tencent.mm.modelvoice.p qQz;
    
    public a()
    {
      GMTrace.i(5757672095744L, 42898);
      this.qQA = false;
      this.qQB = false;
      this.qQG = new HashMap();
      this.uqt = fb.class.getName().hashCode();
      GMTrace.o(5757672095744L, 42898);
    }
    
    private void a(String paramString, a parama)
    {
      GMTrace.i(14524774088704L, 108218);
      v.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", new Object[] { parama });
      if (this.qQC != null) {
        this.qQC.KI();
      }
      ap.vd().b(546, this);
      ap.vd().b(547, this);
      ap.vd().b(548, this);
      if (this.qQD != null)
      {
        if (com.tencent.mm.sdk.platformtools.bf.mA(paramString)) {
          break label434;
        }
        this.qQG.put(this.qQD.fJo.fyw, paramString);
        if (((a.qQs == null) || (com.tencent.mm.sdk.platformtools.bf.mA(a.qQs.field_content))) && (this.qQD.fJo.fFi == 1))
        {
          bg localbg = m.LA();
          v.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", new Object[] { this.qQD.fJo.fJq, this.qQD.fJo.fyw });
          com.tencent.mm.storage.bf localbf = new com.tencent.mm.storage.bf();
          localbf.field_msgId = Long.valueOf(this.qQD.fJo.fJq).longValue();
          localbf.RZ(this.qQD.fJo.fyw);
          localbf.field_content = paramString;
          localbg.a(localbf);
          g.oSF.i(14220, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
        }
        this.qQD.fJp.fHh = true;
        this.qQD.fJp.content = paramString;
        if (parama != a.qQP) {
          break label479;
        }
        this.qQD.fJp.state = 1;
      }
      for (;;)
      {
        v.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", new Object[] { paramString });
        if (this.qQD.fJo.fJs != null) {
          this.qQD.fJo.fJs.run();
        }
        this.qQv = null;
        this.qQw = null;
        this.qQx = null;
        this.qQD = null;
        this.qQE = false;
        this.qQB = false;
        this.qQA = false;
        this.qQF = 20;
        a.qQs = null;
        GMTrace.o(14524774088704L, 108218);
        return;
        label434:
        if (parama != a.qQN) {
          break;
        }
        v.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", new Object[] { this.qQD.fJo.fJq });
        this.qQD.fJp.state = 2;
        break;
        label479:
        if (parama == a.qQO) {
          this.qQD.fJp.state = 2;
        }
      }
    }
    
    public final void a(final int paramInt1, int paramInt2, String paramString, k paramk)
    {
      GMTrace.i(5758074748928L, 42901);
      v.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      switch (paramk.getType())
      {
      default: 
        GMTrace.o(5758074748928L, 42901);
        return;
      case 546: 
        if (this.qQv.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.qUj)
        {
          v.i("MicroMsg.SubCoreSubapp", "check result: done");
          a(a.qQN);
          if (this.qQv.bnb()) {}
          for (paramString = this.qQv.qUk.uhu;; paramString = null)
          {
            a(paramString, a.qQN);
            GMTrace.o(5758074748928L, 42901);
            return;
          }
        }
        if (this.qQv.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.qUi)
        {
          if (this.qQv.qUk != null) {
            com.tencent.mm.sdk.platformtools.bf.mA(this.qQv.qUk.uhu);
          }
          v.i("MicroMsg.SubCoreSubapp", "check result: processing");
          a(a.qQM);
          GMTrace.o(5758074748928L, 42901);
          return;
        }
        if (this.qQv.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.qUh)
        {
          v.i("MicroMsg.SubCoreSubapp", "check result: not exist");
          a(a.qQK);
          GMTrace.o(5758074748928L, 42901);
          return;
        }
        if (this.qQv.qUm != null)
        {
          paramInt1 = this.qQv.qUm.tVz;
          GMTrace.o(5758074748928L, 42901);
          return;
        }
        break;
      case 547: 
        if (this.qQw.bnd())
        {
          v.i("MicroMsg.SubCoreSubapp", "succeed upload");
          a(a.qQM);
          GMTrace.o(5758074748928L, 42901);
          return;
        }
        v.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.qQw.qUl.tfe), Integer.valueOf(this.qQw.qUl.tff) });
        a(a.qQL);
        GMTrace.o(5758074748928L, 42901);
        return;
      case 548: 
        paramInt1 = this.qQx.qUo;
        v.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", new Object[] { Integer.valueOf(paramInt1) });
        this.qQA = false;
        if ((!this.qQx.isComplete()) && (this.qQx.bnb()))
        {
          v.i("MicroMsg.SubCoreSubapp", "refreshResult result");
          paramString = this.qQx.qUk.uhu;
          if (this.qQD != null)
          {
            this.qQD.fJp.fHh = false;
            this.qQD.fJp.content = paramString;
            v.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", new Object[] { Boolean.valueOf(com.tencent.mm.sdk.platformtools.bf.mA(paramString)) });
            if (this.qQD.fJo.fJs != null) {
              this.qQD.fJo.fJs.run();
            }
          }
          if (!this.qQx.isComplete()) {
            break label613;
          }
          v.i("MicroMsg.SubCoreSubapp", "succeed get");
          if (!this.qQx.bnb()) {
            break label608;
          }
        }
        label608:
        for (paramString = this.qQx.qUk.uhu;; paramString = null)
        {
          a(a.qQN);
          a(paramString, a.qQN);
          GMTrace.o(5758074748928L, 42901);
          return;
          if (this.qQx.bnb()) {
            break;
          }
          v.d("MicroMsg.SubCoreSubapp", "result not valid");
          break;
        }
        label613:
        v.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", new Object[] { Integer.valueOf(paramInt1) });
        if (!this.qQB)
        {
          paramInt2 = this.qQF - 1;
          this.qQF = paramInt2;
          if (paramInt2 < 0)
          {
            v.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", new Object[] { Integer.valueOf(20) });
            a(a.qQO);
            g.oSF.i(14220, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2) });
            GMTrace.o(5758074748928L, 42901);
            return;
          }
          if (this.qQC == null) {
            this.qQC = new ai(new ai.a()
            {
              public final boolean oQ()
              {
                GMTrace.i(5857798520832L, 43644);
                if (a.a.this.qQB)
                {
                  GMTrace.o(5857798520832L, 43644);
                  return false;
                }
                v.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
                a.a.this.a(a.a.a.qQM);
                GMTrace.o(5857798520832L, 43644);
                return false;
              }
            }, false);
          }
          paramString = this.qQC;
          long l = paramInt1 * 1000;
          paramString.v(l, l);
        }
        GMTrace.o(5758074748928L, 42901);
        return;
        a(a.qQO);
        g.oSF.i(14220, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
      }
      GMTrace.o(5758074748928L, 42901);
    }
    
    public final void a(a parama)
    {
      GMTrace.i(14524639870976L, 108217);
      switch (a.1.qQu[parama.ordinal()])
      {
      }
      for (;;)
      {
        GMTrace.o(14524639870976L, 108217);
        return;
        v.i("MicroMsg.SubCoreSubapp", "net check");
        if (this.qQz.fTG > 0L) {
          v.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", new Object[] { Long.valueOf(this.qQz.fTG) });
        }
        for (this.qQv = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.qQz.clientId, this.qQz.hrb, this.qQy.getFormat(), this.qQz.fTG, this.qQz.fyw);; this.qQv = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.qQz.clientId, this.qQz.hrb, this.qQz.fyw))
        {
          ap.vd().a(this.qQv, 0);
          ap.vd().a(this.qQv.getType(), this);
          GMTrace.o(14524639870976L, 108217);
          return;
          v.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", new Object[] { Long.valueOf(this.qQz.fTG) });
        }
        v.i("MicroMsg.SubCoreSubapp", "net upload");
        if (this.qQv == null)
        {
          v.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
          GMTrace.o(14524639870976L, 108217);
          return;
        }
        this.qQw = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.qQz.clientId, this.qQv.qUl, this.qQy.getFormat(), this.qQz.fyw);
        ap.vd().a(this.qQw, 0);
        ap.vd().a(this.qQw.getType(), this);
        GMTrace.o(14524639870976L, 108217);
        return;
        v.i("MicroMsg.SubCoreSubapp", "net upload more");
        if (this.qQw == null)
        {
          v.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
          GMTrace.o(14524639870976L, 108217);
          return;
        }
        this.qQw = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.qQw);
        ap.vd().a(this.qQw, 0);
        ap.vd().a(this.qQw.getType(), this);
        GMTrace.o(14524639870976L, 108217);
        return;
        if (this.qQA)
        {
          v.i("MicroMsg.SubCoreSubapp", "pulling so pass");
          GMTrace.o(14524639870976L, 108217);
          return;
        }
        v.i("MicroMsg.SubCoreSubapp", "net get");
        if (this.qQv == null)
        {
          v.w("MicroMsg.SubCoreSubapp", "request get must after check!");
          GMTrace.o(14524639870976L, 108217);
          return;
        }
        this.qQA = true;
        this.qQx = new com.tencent.mm.plugin.subapp.ui.voicetranstext.b(this.qQz.clientId);
        ap.vd().a(this.qQx, 0);
        ap.vd().a(this.qQx.getType(), this);
        GMTrace.o(14524639870976L, 108217);
        return;
        this.qQB = true;
        GMTrace.o(14524639870976L, 108217);
        return;
        ap.vd().c(this.qQv);
        ap.vd().c(this.qQw);
        ap.vd().c(this.qQx);
        a(null, a.qQP);
        GMTrace.o(14524639870976L, 108217);
        return;
        a(null, a.qQO);
      }
    }
    
    private static enum a
    {
      static
      {
        GMTrace.i(5758611619840L, 42905);
        qQJ = new a("CHECK", 0);
        qQK = new a("UPLOAD", 1);
        qQL = new a("UPLOAD_MORE", 2);
        qQM = new a("GET", 3);
        qQN = new a("FINISH", 4);
        qQO = new a("ERROR", 5);
        qQP = new a("CANCEL", 6);
        qQQ = new a[] { qQJ, qQK, qQL, qQM, qQN, qQO, qQP };
        GMTrace.o(5758611619840L, 42905);
      }
      
      private a()
      {
        GMTrace.i(14525176741888L, 108221);
        GMTrace.o(14525176741888L, 108221);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */