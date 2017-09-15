package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.e.a;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.y;
import com.tencent.mm.u.z;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g.a;
import com.tencent.mm.y.g.b;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class p
  implements e.a, com.tencent.mm.modelvoice.c, SensorController.a, z, g.a, g.b
{
  private static SensorController jVB;
  private int fyK;
  private boolean fyM;
  public boolean jVE;
  private aw jVF;
  public long jVG;
  private boolean jVL;
  private boolean jXk;
  g lDm;
  private List<au> vxM;
  public long vxN;
  private com.tencent.mm.ui.base.o vxO;
  public En_5b8fbb1e.a vxP;
  public com.tencent.mm.ui.base.o vxQ;
  boolean vxR;
  boolean vxS;
  boolean vxT;
  com.tencent.mm.sdk.b.c vxU;
  private ad vxV;
  private ad vxW;
  
  public p(En_5b8fbb1e.a parama, String paramString)
  {
    GMTrace.i(2387867598848L, 17791);
    this.jXk = false;
    this.vxN = -1L;
    this.jVG = -1L;
    this.vxS = true;
    this.vxT = false;
    this.fyM = false;
    this.vxU = new com.tencent.mm.sdk.b.c() {};
    this.vxV = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool = true;
        GMTrace.i(2265192595456L, 16877);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          v.i("MicroMsg.AutoPlay", "reset speaker");
          p.this.vxP.cT(true);
          paramAnonymousMessage = p.this;
          if (!p.this.vxP.jVH) {}
          for (;;)
          {
            paramAnonymousMessage.jVE = bool;
            GMTrace.o(2265192595456L, 16877);
            return;
            bool = false;
          }
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          v.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          GMTrace.o(2265192595456L, 16877);
        }
      }
    };
    this.vxW = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(16458314678272L, 122624);
        super.handleMessage(paramAnonymousMessage);
        try
        {
          v.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
          p.this.bTF();
          GMTrace.o(16458314678272L, 122624);
          return;
        }
        catch (Exception paramAnonymousMessage)
        {
          v.printErrStackTrace("MicroMsg.AutoPlay", paramAnonymousMessage, "", new Object[0]);
          GMTrace.o(16458314678272L, 122624);
        }
      }
    };
    this.jVL = false;
    this.vxP = parama;
    if (jVB == null) {
      jVB = new SensorController(parama.bOZ().getApplicationContext());
    }
    if (this.jVF == null) {
      this.jVF = new aw(parama.bOZ().getApplicationContext());
    }
    Tl(paramString);
    com.tencent.mm.sdk.b.a.uql.b(this.vxU);
    ap.oH().a(this);
    GMTrace.o(2387867598848L, 17791);
  }
  
  private void AE(int paramInt)
  {
    GMTrace.i(2388270252032L, 17794);
    for (;;)
    {
      if (this.vxP == null)
      {
        v.e("MicroMsg.AutoPlay", "context is null");
        GMTrace.o(2388270252032L, 17794);
        return;
      }
      Object localObject = this.vxP.bVJ();
      if (localObject == null)
      {
        v.e("MicroMsg.AutoPlay", "add next failed: null adapter");
        GMTrace.o(2388270252032L, 17794);
        return;
      }
      v.d("MicroMsg.AutoPlay", "position : " + paramInt + "adapter getCount = " + ((cv)localObject).getCount());
      if ((paramInt < 0) || (paramInt >= ((cv)localObject).getCount()))
      {
        GMTrace.o(2388270252032L, 17794);
        return;
      }
      localObject = (au)((cv)localObject).getItem(paramInt);
      if (localObject == null)
      {
        GMTrace.o(2388270252032L, 17794);
        return;
      }
      if ((((au)localObject).bLP()) && (((ce)localObject).field_isSend == 0) && (!com.tencent.mm.modelvoice.q.C((au)localObject)) && (!com.tencent.mm.modelvoice.q.D((au)localObject))) {
        ab((au)localObject);
      }
      paramInt += 1;
    }
  }
  
  private void ab(au paramau)
  {
    GMTrace.i(2388404469760L, 17795);
    if (paramau == null)
    {
      GMTrace.o(2388404469760L, 17795);
      return;
    }
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      if (this.vxM.size() > 0)
      {
        this.vxM.clear();
        s.eP(this.vxP.bOZ());
      }
      GMTrace.o(2388404469760L, 17795);
      return;
    }
    int j = this.vxM.size();
    int i = 0;
    while (i < j)
    {
      if (((au)this.vxM.get(i)).field_msgId == paramau.field_msgId)
      {
        GMTrace.o(2388404469760L, 17795);
        return;
      }
      i += 1;
    }
    if ((this.vxR) || (this.vxM.size() == 0)) {
      this.vxM.add(paramau);
    }
    v.d("MicroMsg.AutoPlay", "add voice msg :" + this.vxM.size());
    GMTrace.o(2388404469760L, 17795);
  }
  
  private void bRU()
  {
    GMTrace.i(17906926616576L, 133417);
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(17888136134656L, 133277);
        if ((p.this.vxP != null) && (p.this.vxP.bVJ() != null))
        {
          v.i("MicroMsg.AutoPlay", "resetAutoPlay notifyDataSetChanged");
          p.this.vxP.bVJ().notifyDataSetChanged();
        }
        GMTrace.o(17888136134656L, 133277);
      }
    });
    GMTrace.o(17906926616576L, 133417);
  }
  
  private void bTD()
  {
    GMTrace.i(2389478211584L, 17803);
    int k = this.vxM.size();
    int i = 0;
    int j = -1;
    if (i < k)
    {
      if (((au)this.vxM.get(i)).field_msgId != this.vxN) {
        break label117;
      }
      j = i;
    }
    label117:
    for (;;)
    {
      i += 1;
      break;
      if (j != -1) {
        this.vxM.remove(j);
      }
      v.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.vxM.size());
      GMTrace.o(2389478211584L, 17803);
      return;
    }
  }
  
  private void bTH()
  {
    GMTrace.i(2390149300224L, 17808);
    v.i("MicroMsg.AutoPlay", "stop play complete");
    ac.Pt("keep_app_silent");
    this.vxP.releaseWakeLock();
    bTD();
    if ((this.vxM.isEmpty()) && (this.fyM))
    {
      e.qE().qH();
      this.fyM = false;
    }
    e.qE().b(this);
    if (this.vxM.isEmpty())
    {
      jVB.bJw();
      this.jVF.bJx();
    }
    bRU();
    this.vxN = -1L;
    bTI();
    GMTrace.o(2390149300224L, 17808);
  }
  
  public final void A(au paramau)
  {
    GMTrace.i(2389075558400L, 17800);
    if ((this.vxS) && (this.vxM.isEmpty()))
    {
      GMTrace.o(2389075558400L, 17800);
      return;
    }
    if ((paramau == null) || (!paramau.bLP()) || (paramau.field_isSend == 1))
    {
      GMTrace.o(2389075558400L, 17800);
      return;
    }
    if ((paramau.field_talker == null) || (!paramau.field_talker.equals(this.vxP.bTW())))
    {
      GMTrace.o(2389075558400L, 17800);
      return;
    }
    if ((!ap.vd().foreground) || (this.vxP.isFinishing()))
    {
      GMTrace.o(2389075558400L, 17800);
      return;
    }
    if (com.tencent.mm.modelvoice.q.D(paramau))
    {
      v.e("MicroMsg.AutoPlay", "should not in this route");
      GMTrace.o(2389075558400L, 17800);
      return;
    }
    ab(paramau);
    if ((!this.jXk) && (!this.lDm.isPlaying()) && (u.bp(this.vxP.bOZ()))) {
      bTE();
    }
    GMTrace.o(2389075558400L, 17800);
  }
  
  public final void Tl(String paramString)
  {
    GMTrace.i(2388001816576L, 17792);
    v.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", new Object[] { Boolean.valueOf(this.vxT) });
    if ((this.vxT) || (this.vxP == null))
    {
      GMTrace.o(2388001816576L, 17792);
      return;
    }
    this.vxM = new LinkedList();
    this.jXk = false;
    this.vxN = -1L;
    this.jVE = false;
    this.jVG = -1L;
    this.vxR = false;
    this.fyK = 0;
    if (com.tencent.mm.u.o.fq(paramString))
    {
      this.fyK = 1;
      this.lDm = new com.tencent.mm.c.a.a(this.vxP.bOZ(), 1);
      GMTrace.o(2388001816576L, 17792);
      return;
    }
    this.fyK = 0;
    this.lDm = new com.tencent.mm.c.a.a(this.vxP.bOZ(), 0);
    GMTrace.o(2388001816576L, 17792);
  }
  
  public final void a(int paramInt, au paramau)
  {
    GMTrace.i(2388538687488L, 17796);
    if ((paramau == null) || (!paramau.bLP()))
    {
      GMTrace.o(2388538687488L, 17796);
      return;
    }
    Object localObject = new com.tencent.mm.modelvoice.n(paramau.field_content);
    if (((((com.tencent.mm.modelvoice.n)localObject).time == 0L) && (paramau.field_isSend == 0)) || ((paramau.field_status == 1) && (paramau.field_isSend == 1)))
    {
      GMTrace.o(2388538687488L, 17796);
      return;
    }
    if ((paramau.field_isSend == 0) && (((com.tencent.mm.modelvoice.n)localObject).time == -1L))
    {
      GMTrace.o(2388538687488L, 17796);
      return;
    }
    bTA();
    ap.yY();
    localObject = (Boolean)com.tencent.mm.u.c.vr().get(4115, null);
    if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
    {
      ap.yY();
      com.tencent.mm.u.c.vr().set(4115, Boolean.valueOf(true));
      bTI();
      this.vxQ = s.a(this.vxP.bOZ(), this.vxP.getString(R.l.dUF), 4000L);
    }
    if ((this.lDm.isPlaying()) && (paramau.field_msgId == this.vxN))
    {
      lb(true);
      GMTrace.o(2388538687488L, 17796);
      return;
    }
    ab(paramau);
    if ((paramau.field_isSend == 0) && (!com.tencent.mm.modelvoice.q.C(paramau))) {
      AE(paramInt + 1);
    }
    bTE();
    GMTrace.o(2388538687488L, 17796);
  }
  
  public final void b(int paramInt, au paramau)
  {
    GMTrace.i(2388672905216L, 17797);
    if (paramau == null)
    {
      GMTrace.o(2388672905216L, 17797);
      return;
    }
    bTA();
    ap.yY();
    Boolean localBoolean = (Boolean)com.tencent.mm.u.c.vr().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ap.yY();
      com.tencent.mm.u.c.vr().set(4115, Boolean.valueOf(true));
      bTI();
      this.vxQ = s.a(this.vxP.bOZ(), this.vxP.getString(R.l.dUF), 4000L);
    }
    if ((this.lDm.isPlaying()) && (paramau.field_msgId == this.vxN))
    {
      lb(true);
      GMTrace.o(2388672905216L, 17797);
      return;
    }
    ab(paramau);
    if ((paramau.field_isSend == 0) && (!com.tencent.mm.modelvoice.q.C(paramau))) {
      AE(paramInt + 1);
    }
    bTE();
    GMTrace.o(2388672905216L, 17797);
  }
  
  public final void bTA()
  {
    GMTrace.i(2388136034304L, 17793);
    v.d("MicroMsg.AutoPlay", "clear play list, stack: %s", new Object[] { u.ND() });
    if (this.vxO != null) {
      this.vxO.dismiss();
    }
    this.vxM.clear();
    GMTrace.o(2388136034304L, 17793);
  }
  
  public final void bTB()
  {
    GMTrace.i(2389209776128L, 17801);
    this.jXk = true;
    lb(true);
    bTA();
    GMTrace.o(2389209776128L, 17801);
  }
  
  public final void bTC()
  {
    GMTrace.i(2389343993856L, 17802);
    this.jXk = false;
    bTE();
    GMTrace.o(2389343993856L, 17802);
  }
  
  public final void bTE()
  {
    GMTrace.i(2389612429312L, 17804);
    v.d("MicroMsg.AutoPlay", "play next: size = " + this.vxM.size());
    if (this.vxM.size() <= 0)
    {
      this.vxV.sendEmptyMessageDelayed(0, 1000L);
      GMTrace.o(2389612429312L, 17804);
      return;
    }
    if (!e.qE().qO())
    {
      e.qE();
      if (e.qL())
      {
        e.qE().a(this);
        int i = e.qE().qG();
        this.fyM = true;
        if ((i != -1) && (i != 0))
        {
          v.i("MicroMsg.AutoPlay", "play next: ret = " + i);
          this.vxW.sendEmptyMessageDelayed(0, 1000L);
          GMTrace.o(2389612429312L, 17804);
          return;
        }
      }
    }
    bTF();
    GMTrace.o(2389612429312L, 17804);
  }
  
  public final void bTF()
  {
    GMTrace.i(16458448896000L, 122625);
    int i;
    au localau;
    try
    {
      v.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.vxM.size());
      if (this.vxM.size() <= 0)
      {
        this.vxV.sendEmptyMessageDelayed(0, 1000L);
        GMTrace.o(16458448896000L, 122625);
        return;
      }
      int j = 0;
      long l = ((au)this.vxM.get(0)).field_createTime;
      int k = this.vxM.size();
      i = 1;
      if (i < k)
      {
        if (l <= ((au)this.vxM.get(i)).field_createTime) {
          break label838;
        }
        l = ((au)this.vxM.get(i)).field_createTime;
        j = i;
        break label838;
      }
      localau = (au)this.vxM.get(j);
      if (localau == null) {
        break label729;
      }
      if (localau == null) {
        break label386;
      }
      if ((localau.bLP()) || (localau.bMg())) {
        break label849;
      }
      if (localau.field_type != -1879048190) {
        break label376;
      }
      i = 1;
      if (i != 0) {
        break label849;
      }
      if (localau.field_type != -1879048189) {
        break label381;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      label229:
      Runnable local4;
      v.printErrStackTrace("MicroMsg.AutoPlay", localException, "", new Object[0]);
      GMTrace.o(16458448896000L, 122625);
      return;
    }
    Assert.assertTrue(bool1);
    v.i("MicroMsg.AutoPlay", "start play msg: %d", new Object[] { Long.valueOf(localau.field_msgId) });
    if (!jVB.utT)
    {
      jVB.a(this);
      local4 = new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2252576129024L, 16783);
          p.this.jVG = u.NB();
          GMTrace.o(2252576129024L, 16783);
        }
      };
      if (!this.jVF.M(local4)) {
        break label392;
      }
    }
    label376:
    label381:
    label386:
    label392:
    for (this.jVG = 0L;; this.jVG = -1L)
    {
      ap.yY();
      if ((com.tencent.mm.u.c.isSDCardAvailable()) || (u.mA(localau.field_imgPath))) {
        break label402;
      }
      this.vxM.clear();
      s.eP(this.vxP.bOZ());
      GMTrace.o(16458448896000L, 122625);
      return;
      i = 0;
      break;
      i = 0;
      break label845;
      bool1 = false;
      break label229;
    }
    label402:
    ap.yY();
    Object localObject;
    if ((com.tencent.mm.u.c.isSDCardAvailable()) && (this.vxP.jVH))
    {
      if (this.vxO != null) {
        this.vxO.dismiss();
      }
      bool1 = e.qE().qO();
      boolean bool2 = e.qE().qI();
      v.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPluged: %b, isBluetoothOn: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) && (bool2)) {
        this.vxO = s.a(this.vxP.bOZ(), R.k.dzM, this.vxP.getString(R.l.dSw));
      }
    }
    else
    {
      ac.Ps("keep_app_silent");
      com.tencent.mm.modelvoice.q.E(localau);
      this.lDm.ap(true);
      this.vxP.vGD.setKeepScreenOn(true);
      if ((e.qE().qO()) || (e.qE().qI()))
      {
        v.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(e.qE().qO()), Boolean.valueOf(e.qE().qI()) });
        this.jVE = false;
      }
      localObject = localau.field_imgPath;
      if (this.fyK != 1) {
        break label769;
      }
      localObject = h.at((String)localObject, false);
      label632:
      v.i("MicroMsg.AutoPlay", "startplay");
      if (!this.lDm.a((String)localObject, this.jVE, true, -1)) {
        break label779;
      }
      localObject = this.lDm;
      if (this.vxM.size() <= 1) {
        break label855;
      }
    }
    label729:
    label769:
    label779:
    label838:
    label845:
    label849:
    label855:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((g)localObject).ar(bool1);
      this.lDm.a(this);
      this.lDm.a(this);
      this.vxN = localau.field_msgId;
      for (;;)
      {
        bRU();
        this.vxT = false;
        GMTrace.o(16458448896000L, 122625);
        return;
        this.vxO = s.a(this.vxP.bOZ(), R.k.dzS, this.vxP.getString(R.l.dSx));
        break;
        localObject = com.tencent.mm.modelvoice.q.jt((String)localObject);
        break label632;
        this.vxN = -1L;
        if (this.fyM)
        {
          e.qE().qH();
          this.fyM = false;
        }
        e.qE().b(this);
        Toast.makeText(this.vxP.bOZ(), this.vxP.getString(R.l.dUX), 0).show();
      }
      i += 1;
      break;
      if (i == 0) {
        break label386;
      }
      bool1 = true;
      break label229;
    }
  }
  
  public final void bTG()
  {
    GMTrace.i(2389746647040L, 17805);
    if ((this.lDm != null) && (this.lDm.isPlaying()))
    {
      v.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", new Object[] { Boolean.valueOf(this.jVE), Boolean.valueOf(this.lDm.isPlaying()) });
      this.lDm.aq(this.jVE);
    }
    GMTrace.o(2389746647040L, 17805);
  }
  
  public final void bTI()
  {
    GMTrace.i(2390820388864L, 17813);
    if (this.vxQ != null) {
      this.vxQ.dismiss();
    }
    GMTrace.o(2390820388864L, 17813);
  }
  
  public final void c(int paramInt, au paramau)
  {
    GMTrace.i(2388807122944L, 17798);
    if (paramau == null)
    {
      GMTrace.o(2388807122944L, 17798);
      return;
    }
    bTA();
    ap.yY();
    Boolean localBoolean = (Boolean)com.tencent.mm.u.c.vr().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ap.yY();
      com.tencent.mm.u.c.vr().set(4115, Boolean.valueOf(true));
      bTI();
      this.vxQ = s.a(this.vxP.bOZ(), this.vxP.getString(R.l.dUF), 4000L);
    }
    if ((this.lDm.isPlaying()) && (paramau.field_msgId == this.vxN))
    {
      lb(true);
      GMTrace.o(2388807122944L, 17798);
      return;
    }
    ab(paramau);
    if ((paramau.field_isSend == 0) && (!com.tencent.mm.modelvoice.q.C(paramau))) {
      AE(paramInt + 1);
    }
    bTE();
    GMTrace.o(2388807122944L, 17798);
  }
  
  public final void cS(final boolean paramBoolean)
  {
    boolean bool = true;
    GMTrace.i(2390686171136L, 17812);
    v.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + paramBoolean + "  hasSkip:" + this.jVL + " tick:" + u.aB(this.jVG) + "  lt:" + this.jVG);
    if (this.jVL)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.jVL = paramBoolean;
        GMTrace.o(2390686171136L, 17812);
        return;
      }
    }
    if (this.vxP == null)
    {
      jVB.bJw();
      GMTrace.o(2390686171136L, 17812);
      return;
    }
    v.i("MicroMsg.AutoPlay", "isScreenOn: %s", new Object[] { Boolean.valueOf(this.vxP.uRf.uRp) });
    if ((!paramBoolean) && (this.jVG != -1L) && (u.aB(this.jVG) > 400L))
    {
      this.jVL = true;
      GMTrace.o(2390686171136L, 17812);
      return;
    }
    this.jVL = false;
    if (this.lDm.oS())
    {
      GMTrace.o(2390686171136L, 17812);
      return;
    }
    if (ap.yZ().qI())
    {
      bTI();
      v.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
      GMTrace.o(2390686171136L, 17812);
      return;
    }
    if (this.vxP.jVH)
    {
      this.jVE = false;
      if (this.vxN != -1L) {
        this.vxP.cT(paramBoolean);
      }
      for (this.vxT = paramBoolean;; this.vxT = true)
      {
        bTG();
        GMTrace.o(2390686171136L, 17812);
        return;
        this.vxP.cT(true);
      }
    }
    if (this.vxN != -1L)
    {
      if (this.vxP.uRf.uRp == paramBoolean)
      {
        GMTrace.o(2390686171136L, 17812);
        return;
      }
      this.vxP.cT(paramBoolean);
      this.vxT = paramBoolean;
      new ai(new ai.a()
      {
        public final boolean oQ()
        {
          GMTrace.i(17905181786112L, 133404);
          if (!paramBoolean)
          {
            v.i("MicroMsg.AutoPlay", "speaker off");
            p.this.jVE = false;
            p localp = p.this;
            if (localp.lDm.isPlaying())
            {
              v.d("MicroMsg.AutoPlay", "deal sensor event, play next");
              localp.bTE();
            }
          }
          for (;;)
          {
            GMTrace.o(17905181786112L, 133404);
            return false;
            v.i("MicroMsg.AutoPlay", "speaker true");
            p.this.bTI();
            if (p.this.vxP != null) {
              p.this.vxQ = s.a(p.this.vxP.bOZ(), p.this.vxP.getString(R.l.elG), 2000L);
            }
            p.this.jVE = true;
            p.this.bTG();
          }
        }
      }, false).v(50L, 50L);
    }
    v.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", new Object[] { Boolean.valueOf(this.vxT) });
    GMTrace.o(2390686171136L, 17812);
  }
  
  public final void cW(int paramInt)
  {
    GMTrace.i(16458583113728L, 122626);
    v.i("MicroMsg.AutoPlay", "onBluetoothHeadsetStateChange, status: %d, isRequestStartBluetooth: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.fyM) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(16458583113728L, 122626);
      return;
      if (this.vxW.hasMessages(0))
      {
        this.vxW.removeMessages(0);
        this.vxW.sendEmptyMessage(0);
        GMTrace.o(16458583113728L, 122626);
        return;
        if (this.vxW.hasMessages(0)) {
          this.vxW.removeMessages(0);
        }
        if (this.fyM)
        {
          e.qE().qH();
          this.fyM = false;
        }
      }
    }
  }
  
  public final void d(int paramInt, au paramau)
  {
    GMTrace.i(2388941340672L, 17799);
    if (paramau == null)
    {
      GMTrace.o(2388941340672L, 17799);
      return;
    }
    bTA();
    ap.yY();
    Boolean localBoolean = (Boolean)com.tencent.mm.u.c.vr().get(4115, null);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ap.yY();
      com.tencent.mm.u.c.vr().set(4115, Boolean.valueOf(true));
      bTI();
      this.vxQ = s.a(this.vxP.bOZ(), this.vxP.getString(R.l.dUF), 4000L);
    }
    if ((this.lDm.isPlaying()) && (paramau.field_msgId == this.vxN))
    {
      lb(true);
      GMTrace.o(2388941340672L, 17799);
      return;
    }
    ab(paramau);
    if ((paramau.field_isSend == 0) && (!com.tencent.mm.modelvoice.q.C(paramau))) {
      AE(paramInt + 1);
    }
    bTE();
    GMTrace.o(2388941340672L, 17799);
  }
  
  public final boolean isPlaying()
  {
    GMTrace.i(2390283517952L, 17809);
    boolean bool = this.lDm.isPlaying();
    GMTrace.o(2390283517952L, 17809);
    return bool;
  }
  
  public final void lb(boolean paramBoolean)
  {
    GMTrace.i(2390015082496L, 17807);
    v.i("MicroMsg.AutoPlay", "stop play");
    ac.Pt("keep_app_silent");
    this.lDm.stop();
    this.vxP.releaseWakeLock();
    bTD();
    if (this.fyM)
    {
      e.qE().qH();
      this.fyM = false;
    }
    e.qE().b(this);
    if (this.vxM.isEmpty())
    {
      jVB.bJw();
      this.jVF.bJx();
    }
    if (paramBoolean)
    {
      v.i("MicroMsg.AutoPlay", "resetAutoPlay stop play fresh tid[%d] this[%d] looper[%s], stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(hashCode()), Looper.myLooper(), u.ND() });
      bRU();
    }
    this.vxN = -1L;
    bTI();
    this.vxT = false;
    GMTrace.o(2390015082496L, 17807);
  }
  
  public final void oW()
  {
    GMTrace.i(2390417735680L, 17810);
    v.v("MicroMsg.AutoPlay", "voice play completion isSpeakerOn " + this.jVE);
    if (this.vxP != null)
    {
      bTH();
      this.vxP.releaseWakeLock();
      bTE();
    }
    GMTrace.o(2390417735680L, 17810);
  }
  
  public final void onError()
  {
    GMTrace.i(2390551953408L, 17811);
    v.e("MicroMsg.AutoPlay", "voice play error");
    lb(true);
    bTE();
    GMTrace.o(2390551953408L, 17811);
  }
  
  public final void release()
  {
    GMTrace.i(2389880864768L, 17806);
    v.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
    if (this.jVF != null) {
      this.jVF.bJx();
    }
    GMTrace.o(2389880864768L, 17806);
  }
  
  public final void yG()
  {
    GMTrace.i(2390954606592L, 17814);
    v.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    GMTrace.o(2390954606592L, 17814);
  }
  
  public final void yH()
  {
    GMTrace.i(2391088824320L, 17815);
    v.i("MicroMsg.AutoPlay", "phone comming or record start, stop play");
    lb(true);
    bTA();
    GMTrace.o(2391088824320L, 17815);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */