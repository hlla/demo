package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelstat.b.b;
import com.tencent.mm.modelvideo.s.a;
import com.tencent.mm.modelvideo.s.a.a;
import com.tencent.mm.pluginsdk.model.app.j.a;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.r;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import junit.framework.Assert;

public final class cv
  extends com.tencent.mm.ui.k<com.tencent.mm.storage.au>
  implements s.a, j.a, com.tencent.mm.y.e
{
  private static Map<String, Integer> vDH;
  private static HashMap<String, com.tencent.mm.pluginsdk.ui.e> vDN;
  private int fFI;
  protected String fJC;
  boolean fwJ;
  int hOq;
  protected String hrv;
  protected long jZq;
  ad jrx;
  protected com.tencent.mm.ah.a.a.c kuE;
  int kvt;
  private LayoutInflater mwN;
  private short[] nvS;
  protected com.tencent.mm.pluginsdk.ui.e oIE;
  protected View.OnCreateContextMenuListener oJh;
  private HashMap<Integer, ag> qGc;
  private boolean sLe;
  private boolean sWq;
  private short[] vCT;
  public long vCU;
  private HashSet<Long> vCV;
  com.tencent.mm.pluginsdk.ui.d.e vCW;
  protected p vCX;
  private String vCY;
  private final int vCZ;
  boolean vDA;
  boolean vDB;
  TreeSet<Long> vDC;
  long vDD;
  Map<Long, View> vDE;
  Map<Long, Integer> vDF;
  private List<Long> vDG;
  com.tencent.mm.storage.au vDI;
  private boolean vDJ;
  private boolean vDK;
  boolean vDL;
  View.OnClickListener vDM;
  private long vDO;
  private final int vDa;
  protected cw vDb;
  private cw vDc;
  protected cy vDd;
  private cy vDe;
  protected cz vDf;
  private cz vDg;
  protected cx vDh;
  private cx vDi;
  protected com.tencent.mm.pluginsdk.ui.chat.k vDj;
  private com.tencent.mm.pluginsdk.ui.chat.k vDk;
  protected a vDl;
  private a vDm;
  protected o vDn;
  private o vDo;
  private View.OnCreateContextMenuListener vDp;
  protected View.OnClickListener vDq;
  private long vDr;
  private long vDs;
  private long vDt;
  private int vDu;
  private int vDv;
  boolean vDw;
  boolean vDx;
  private boolean vDy;
  boolean vDz;
  protected En_5b8fbb1e.a vxP;
  
  static
  {
    GMTrace.i(2405986992128L, 17926);
    HashMap localHashMap = new HashMap();
    vDH = localHashMap;
    localHashMap.put("T49S", Integer.valueOf(19));
    vDH.put("T49R", Integer.valueOf(18));
    vDH.put("T268435505S", Integer.valueOf(21));
    vDH.put("T268435505R", Integer.valueOf(20));
    vDH.put("T1048625S", Integer.valueOf(30));
    vDH.put("T1048625R", Integer.valueOf(29));
    vDH.put("T369098801S", Integer.valueOf(47));
    vDH.put("T369098801R", Integer.valueOf(46));
    vDH.put("T335544369S", Integer.valueOf(42));
    vDH.put("T335544369R", Integer.valueOf(41));
    vDH.put("T402653233S", Integer.valueOf(45));
    vDH.put("T402653233R", Integer.valueOf(44));
    vDH.put("T16777265S", Integer.valueOf(23));
    vDH.put("T16777265R", Integer.valueOf(22));
    vDH.put("T10000R", Integer.valueOf(5));
    vDH.put("T10000S", Integer.valueOf(5));
    vDH.put("T10002R", Integer.valueOf(5));
    vDH.put("T64R", Integer.valueOf(5));
    vDH.put("T39S", Integer.valueOf(3));
    vDH.put("T39R", Integer.valueOf(1));
    vDH.put("T3S", Integer.valueOf(3));
    vDH.put("T3R", Integer.valueOf(1));
    vDH.put("T23S", Integer.valueOf(3));
    vDH.put("T23R", Integer.valueOf(1));
    vDH.put("T47S", Integer.valueOf(15));
    vDH.put("T47R", Integer.valueOf(14));
    vDH.put("T34S", Integer.valueOf(7));
    vDH.put("T34R", Integer.valueOf(6));
    vDH.put("T35R", Integer.valueOf(8));
    vDH.put("T42S", Integer.valueOf(13));
    vDH.put("T42R", Integer.valueOf(12));
    vDH.put("T37R", Integer.valueOf(9));
    vDH.put("T40R", Integer.valueOf(9));
    vDH.put("T43S", Integer.valueOf(11));
    vDH.put("T43R", Integer.valueOf(10));
    vDH.put("T48S", Integer.valueOf(17));
    vDH.put("T48R", Integer.valueOf(16));
    vDH.put("T52R", Integer.valueOf(25));
    vDH.put("T50R", Integer.valueOf(24));
    vDH.put("T50S", Integer.valueOf(43));
    vDH.put("T285212721R", Integer.valueOf(26));
    vDH.put("T301989937S", Integer.valueOf(32));
    vDH.put("T301989937R", Integer.valueOf(31));
    vDH.put("T1S", Integer.valueOf(4));
    vDH.put("T1R", Integer.valueOf(2));
    vDH.put("T11S", Integer.valueOf(4));
    vDH.put("T11R", Integer.valueOf(2));
    vDH.put("T13S", Integer.valueOf(3));
    vDH.put("T13R", Integer.valueOf(1));
    vDH.put("T21S", Integer.valueOf(4));
    vDH.put("T21R", Integer.valueOf(2));
    vDH.put("T31S", Integer.valueOf(4));
    vDH.put("T31R", Integer.valueOf(2));
    vDH.put("T36S", Integer.valueOf(4));
    vDH.put("T36R", Integer.valueOf(2));
    vDH.put("T53R", Integer.valueOf(27));
    vDH.put("T53S", Integer.valueOf(28));
    vDH.put("T55R", Integer.valueOf(36));
    vDH.put("T55S", Integer.valueOf(37));
    vDH.put("T57R", Integer.valueOf(36));
    vDH.put("T57S", Integer.valueOf(37));
    vDH.put("T-1879048191R", Integer.valueOf(33));
    vDH.put("T-1879048189R", Integer.valueOf(34));
    vDH.put("T-1879048190R", Integer.valueOf(35));
    vDH.put("T-1879048188R", Integer.valueOf(38));
    vDH.put("T-1879048187R", Integer.valueOf(39));
    vDH.put("T318767153R", Integer.valueOf(40));
    vDH.put("T486539313R", Integer.valueOf(65));
    vDH.put("T-1879048186R", Integer.valueOf(48));
    vDH.put("T-1879048186S", Integer.valueOf(49));
    vDH.put("T-1879048185R", Integer.valueOf(52));
    vDH.put("T-1879048185S", Integer.valueOf(52));
    vDH.put("T-1879048183R", Integer.valueOf(57));
    vDH.put("T-1879048183S", Integer.valueOf(57));
    vDH.put("T-1879048176R", Integer.valueOf(58));
    vDH.put("T-1879048176S", Integer.valueOf(58));
    vDH.put("T419430449R", Integer.valueOf(53));
    vDH.put("T419430449S", Integer.valueOf(54));
    vDH.put("T436207665R", Integer.valueOf(59));
    vDH.put("T436207665S", Integer.valueOf(60));
    vDH.put("T62R", Integer.valueOf(55));
    vDH.put("T62S", Integer.valueOf(56));
    vDH.put("T452984881R", Integer.valueOf(61));
    vDH.put("T452984881S", Integer.valueOf(62));
    vDH.put("T469762097R", Integer.valueOf(63));
    vDH.put("T469762097S", Integer.valueOf(64));
    vDH.put("T503316529R", Integer.valueOf(66));
    vDH.put("T503316529S", Integer.valueOf(67));
    vDH.put("T520093745R", Integer.valueOf(68));
    vDH.put("T520093745S", Integer.valueOf(69));
    vDH.put("T553648177R", Integer.valueOf(72));
    vDH.put("T553648177S", Integer.valueOf(73));
    vDN = new HashMap();
    GMTrace.o(2405986992128L, 17926);
  }
  
  public cv(final En_5b8fbb1e.a parama, com.tencent.mm.storage.au paramau, String paramString1, String paramString2, p paramp, View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    super(parama.uRf.uRz, paramau);
    GMTrace.i(2401423589376L, 17892);
    this.vCU = -1L;
    this.fwJ = true;
    this.vCV = new HashSet();
    this.vDr = -1L;
    this.vDs = -1L;
    this.vDt = -1L;
    this.vDu = 0;
    this.vDv = 0;
    this.vDw = false;
    this.vDx = false;
    this.vDy = false;
    this.vDz = false;
    this.vDA = false;
    this.vDB = false;
    this.vDD = -1L;
    this.qGc = new HashMap();
    this.qGc.put(Integer.valueOf(19), new az(19));
    this.qGc.put(Integer.valueOf(18), new ar(18));
    this.qGc.put(Integer.valueOf(21), new ba());
    this.qGc.put(Integer.valueOf(20), new as());
    this.qGc.put(Integer.valueOf(23), new ay());
    this.qGc.put(Integer.valueOf(22), new ax());
    this.qGc.put(Integer.valueOf(30), new aq());
    this.qGc.put(Integer.valueOf(29), new ap());
    this.qGc.put(Integer.valueOf(47), new az(47));
    this.qGc.put(Integer.valueOf(46), new ar(46));
    this.qGc.put(Integer.valueOf(42), new az(42));
    this.qGc.put(Integer.valueOf(41), new ar(41));
    this.qGc.put(Integer.valueOf(45), new az(45));
    this.qGc.put(Integer.valueOf(44), new ar(44));
    this.qGc.put(Integer.valueOf(5), new bz());
    this.qGc.put(Integer.valueOf(3), new bs());
    this.qGc.put(Integer.valueOf(1), new br());
    this.qGc.put(Integer.valueOf(15), new bm());
    this.qGc.put(Integer.valueOf(14), new bl());
    this.qGc.put(Integer.valueOf(7), new cj());
    this.qGc.put(Integer.valueOf(6), new cf());
    this.qGc.put(Integer.valueOf(8), new bv());
    this.qGc.put(Integer.valueOf(13), new bh());
    this.qGc.put(Integer.valueOf(12), new bg());
    this.qGc.put(Integer.valueOf(9), new bn());
    this.qGc.put(Integer.valueOf(11), new ce(11));
    this.qGc.put(Integer.valueOf(10), new cd(10));
    this.qGc.put(Integer.valueOf(17), new bu());
    this.qGc.put(Integer.valueOf(16), new bt());
    this.qGc.put(Integer.valueOf(25), new cp());
    this.qGc.put(Integer.valueOf(24), new cm());
    this.qGc.put(Integer.valueOf(43), new cq());
    this.qGc.put(Integer.valueOf(4), new cc(4));
    this.qGc.put(Integer.valueOf(2), new cb(2));
    this.qGc.put(Integer.valueOf(26), new be());
    this.qGc.put(Integer.valueOf(27), new cn());
    this.qGc.put(Integer.valueOf(28), new co());
    this.qGc.put(Integer.valueOf(31), new cb(2));
    this.qGc.put(Integer.valueOf(32), new cc(4));
    this.qGc.put(Integer.valueOf(33), new ci());
    this.qGc.put(Integer.valueOf(34), new cg());
    this.qGc.put(Integer.valueOf(35), new ch());
    this.qGc.put(Integer.valueOf(36), new bx());
    this.qGc.put(Integer.valueOf(37), new by());
    this.qGc.put(Integer.valueOf(38), new ct());
    this.qGc.put(Integer.valueOf(39), new cs());
    this.qGc.put(Integer.valueOf(40), new bj());
    this.qGc.put(Integer.valueOf(65), new bf());
    this.qGc.put(Integer.valueOf(48), new at());
    this.qGc.put(Integer.valueOf(49), new au());
    this.qGc.put(Integer.valueOf(52), new bo());
    this.qGc.put(Integer.valueOf(57), new bp());
    this.qGc.put(Integer.valueOf(58), new bq());
    this.qGc.put(Integer.valueOf(54), new aw());
    this.qGc.put(Integer.valueOf(53), new av());
    this.qGc.put(Integer.valueOf(60), new ak());
    this.qGc.put(Integer.valueOf(59), new ah());
    this.qGc.put(Integer.valueOf(56), new ce(56));
    this.qGc.put(Integer.valueOf(55), new cd(55));
    this.qGc.put(Integer.valueOf(62), new ao());
    this.qGc.put(Integer.valueOf(61), new an());
    this.qGc.put(Integer.valueOf(64), new aj());
    this.qGc.put(Integer.valueOf(63), new ai());
    this.qGc.put(Integer.valueOf(67), new am());
    this.qGc.put(Integer.valueOf(66), new al());
    this.qGc.put(Integer.valueOf(69), new ao());
    this.qGc.put(Integer.valueOf(68), new an());
    this.qGc.put(Integer.valueOf(73), new bc());
    this.qGc.put(Integer.valueOf(72), new bb());
    this.vDI = new com.tencent.mm.storage.au();
    this.sLe = false;
    this.vDJ = false;
    this.vDK = false;
    this.vDL = false;
    this.vDM = null;
    this.oIE = null;
    this.sWq = false;
    this.vDO = 0L;
    this.kuE = null;
    this.vDD = -1L;
    this.vxP = parama;
    this.fFI = 211;
    this.vCZ = parama.getResources().getDimensionPixelSize(R.f.aXU);
    this.vDa = parama.getResources().getDimensionPixelSize(R.f.aXw);
    this.vCW = new com.tencent.mm.pluginsdk.ui.d.e()
    {
      public final Object a(com.tencent.mm.pluginsdk.ui.applet.i paramAnonymousi)
      {
        GMTrace.i(2237812178944L, 16673);
        com.tencent.mm.pluginsdk.wallet.f.xO(6);
        switch (paramAnonymousi.type)
        {
        case 3: 
        case 5: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 19: 
        case 24: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        default: 
        case 4: 
        case 2: 
        case 6: 
        case 7: 
        case 9: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 20: 
        case 21: 
        case 22: 
        case 23: 
          for (;;)
          {
            GMTrace.o(2237812178944L, 16673);
            return null;
            cv.a(cv.this, paramAnonymousi);
            continue;
            parama.finish();
          }
        case 25: 
        case 30: 
        case 31: 
          paramAnonymousi = cv.a(cv.this);
          GMTrace.o(2237812178944L, 16673);
          return paramAnonymousi;
        }
        paramAnonymousi = cv.a(cv.this);
        GMTrace.o(2237812178944L, 16673);
        return paramAnonymousi;
      }
    };
    this.vDp = paramOnCreateContextMenuListener;
    this.oJh = paramOnCreateContextMenuListener;
    paramau = new cy(paramOnCreateContextMenuListener, parama);
    this.vDe = paramau;
    this.vDd = paramau;
    paramau = new cz();
    this.vDg = paramau;
    this.vDf = paramau;
    paramau = new cx(parama);
    this.vDi = paramau;
    this.vDh = paramau;
    paramau = new com.tencent.mm.pluginsdk.ui.chat.k(parama.uRf.uRz);
    this.vDk = paramau;
    this.vDj = paramau;
    paramau = new a();
    this.vDm = paramau;
    this.vDl = paramau;
    paramau = new o(parama);
    this.vDo = paramau;
    this.vDn = paramau;
    this.vDq = new df(parama);
    paramau = this.qGc.keySet().iterator();
    while (paramau.hasNext())
    {
      paramOnCreateContextMenuListener = (Integer)paramau.next();
      ((ag)this.qGc.get(paramOnCreateContextMenuListener)).vvA = parama.vvA;
    }
    a(paramString1, paramp, paramString2);
    this.vDE = new HashMap();
    this.vDF = new HashMap();
    this.vDG = new ArrayList();
    if (this.kuE == null)
    {
      parama = new c.a();
      parama.hIw = com.tencent.mm.modelbiz.a.e.iB(this.vxP.bTW());
      parama.hIt = true;
      parama.hIP = true;
      parama.hII = R.k.ber;
      this.kuE = parama.Hh();
    }
    GMTrace.o(2401423589376L, 17892);
  }
  
  public static void S(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(2405450121216L, 17922);
    h.i(paramString, paramInt1, paramInt2);
    GMTrace.o(2405450121216L, 17922);
  }
  
  static com.tencent.mm.storage.au a(com.tencent.mm.storage.au paramau, Cursor paramCursor)
  {
    GMTrace.i(2401960460288L, 17896);
    com.tencent.mm.storage.au localau = paramau;
    if (paramau == null) {
      localau = new com.tencent.mm.storage.au();
    }
    localau.b(paramCursor);
    GMTrace.o(2401960460288L, 17896);
    return localau;
  }
  
  private static short aq(com.tencent.mm.storage.au paramau)
  {
    int m = 0;
    int k = 1;
    GMTrace.i(2403034202112L, 17904);
    int j;
    if (paramau.field_isSend == 1)
    {
      i = 1;
      if (paramau.field_type != 49) {
        break label186;
      }
      localObject1 = com.tencent.mm.sdk.platformtools.bf.PW(paramau.field_content);
      j = m;
      if (localObject1 != null)
      {
        localObject1 = f.a.B((String)localObject1, paramau.field_reserved);
        j = m;
        if (localObject1 != null)
        {
          j = m;
          if (((f.a)localObject1).type == 2000)
          {
            paramau.setType(419430449);
            com.tencent.mm.u.ap.yY();
            com.tencent.mm.u.c.wT().a(paramau.field_msgId, paramau);
            j = 1;
          }
        }
      }
      if (j == 0) {
        break label186;
      }
      localObject1 = vDH;
      localObject2 = new StringBuilder("T419430449");
      if (i == 0) {
        break label179;
      }
    }
    short s;
    label179:
    for (paramau = "S";; paramau = "R")
    {
      s = (short)com.tencent.mm.sdk.platformtools.bf.f((Integer)((Map)localObject1).get(paramau));
      GMTrace.o(2403034202112L, 17904);
      return s;
      i = 0;
      break;
    }
    label186:
    Object localObject2 = vDH;
    StringBuilder localStringBuilder = new StringBuilder("T").append(paramau.field_type);
    if (i != 0) {}
    for (Object localObject1 = "S";; localObject1 = "R")
    {
      j = com.tencent.mm.sdk.platformtools.bf.f((Integer)((Map)localObject2).get((String)localObject1));
      if (j <= 0) {
        break;
      }
      s = (short)j;
      GMTrace.o(2403034202112L, 17904);
      return s;
    }
    boolean bool1 = paramau.bLX();
    boolean bool2 = paramau.bLP();
    if (bool1)
    {
      j = k;
      if (i != 0) {
        j = 3;
      }
      s = (short)j;
      GMTrace.o(2403034202112L, 17904);
      return s;
    }
    if (bool2)
    {
      if (i != 0) {}
      for (i = 7;; i = 6)
      {
        s = (short)i;
        GMTrace.o(2403034202112L, 17904);
        return s;
      }
    }
    if (paramau.bMd())
    {
      if (i != 0) {}
      for (i = 15;; i = 14)
      {
        s = (short)i;
        GMTrace.o(2403034202112L, 17904);
        return s;
      }
    }
    if (i != 0) {}
    for (int i = 4;; i = 2)
    {
      s = (short)i;
      GMTrace.o(2403034202112L, 17904);
      return s;
    }
  }
  
  public final int AL(int paramInt)
  {
    GMTrace.i(2403302637568L, 17906);
    if (this.vDy)
    {
      paramInt = this.vDu;
      GMTrace.o(2403302637568L, 17906);
      return paramInt;
    }
    if (paramInt <= 0)
    {
      GMTrace.o(2403302637568L, 17906);
      return 0;
    }
    if (this.kvt < paramInt) {
      paramInt = this.kvt;
    }
    for (this.kvt = 0;; this.kvt -= paramInt)
    {
      GMTrace.o(2403302637568L, 17906);
      return paramInt;
    }
  }
  
  public final void AM(int paramInt)
  {
    GMTrace.i(2404510597120L, 17915);
    com.tencent.mm.storage.au localau = (com.tencent.mm.storage.au)getItem(paramInt);
    if ((localau != null) && (localau.field_msgId != 0L)) {
      this.vCV.add(Long.valueOf(localau.field_msgId));
    }
    GMTrace.o(2404510597120L, 17915);
  }
  
  public final void OL()
  {
    GMTrace.i(2402363113472L, 17899);
    label71:
    boolean bool1;
    Object localObject;
    if ((this.jZq != -1L) && (this.vxP.sLe))
    {
      this.sLe = true;
      if (this.vDy) {
        break label1428;
      }
      if (!this.sLe) {
        break label331;
      }
      com.tencent.mm.u.ap.yY();
      this.hOq = com.tencent.mm.u.c.wU().ag(this.fJC, this.jZq);
      bool1 = false;
      if ((this.kvt < 0) || (this.kvt > this.hOq))
      {
        bool1 = true;
        this.kvt = (this.hOq - 18);
      }
      v.i("MicroMsg.ChattingListAdapter", "summerbadcr resetCursor restart:%b fromCount:%d totalcount:%d limit:%d, talker:%s isBizChat:%b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(this.kvt), Integer.valueOf(this.hOq), Integer.valueOf(this.hOq - this.kvt), this.fJC, Boolean.valueOf(this.sLe) });
      if (!this.sLe) {
        break label354;
      }
      com.tencent.mm.u.ap.yY();
      localObject = com.tencent.mm.u.c.wU().h(this.fJC, this.jZq, this.hOq - this.kvt);
      label216:
      if ((localObject != null) && (!((Cursor)localObject).isClosed())) {
        break label1317;
      }
      v.w("MicroMsg.ChattingListAdapter", "update pos fail, cursor is null");
      label240:
      setCursor((Cursor)localObject);
    }
    for (;;)
    {
      int i = getCount();
      if (i > 0)
      {
        this.vCT = new short[i];
        this.nvS = new short[i];
      }
      this.vDE.clear();
      this.vDF.clear();
      this.vDG.clear();
      super.notifyDataSetChanged();
      if (this.vDB) {
        com.tencent.mm.av.l.KA().Ku();
      }
      GMTrace.o(2402363113472L, 17899);
      return;
      this.sLe = false;
      break;
      label331:
      com.tencent.mm.u.ap.yY();
      this.hOq = com.tencent.mm.u.c.wT().Av(this.fJC);
      break label71;
      label354:
      if (!this.vxP.vzR)
      {
        com.tencent.mm.u.ap.yY();
        localObject = com.tencent.mm.u.c.wT().bj(this.fJC, this.hOq - this.kvt);
        break label216;
      }
      com.tencent.mm.u.ap.yY();
      Cursor localCursor = com.tencent.mm.u.c.wT().bj(this.fJC, this.hOq - this.kvt);
      localObject = localCursor;
      if (!this.vxP.vGw) {
        break label216;
      }
      label442:
      label492:
      long l1;
      int k;
      label522:
      int j;
      if (localCursor == null)
      {
        i = -1;
        v.i("MicroMsg.ChattingListAdapter", "summerbadcr resetCursor check fault count[%d], talker[%s]", new Object[] { Integer.valueOf(i), this.fJC });
        localObject = localCursor;
        if (i <= 0) {
          break label216;
        }
        if (!bool1) {
          break label704;
        }
        if (!localCursor.moveToLast()) {
          break label714;
        }
        l1 = System.currentTimeMillis();
        com.tencent.mm.u.ap.yY();
        localObject = com.tencent.mm.u.c.wW().Rl(this.fJC);
        if (localObject != null) {
          break label721;
        }
        k = 0;
        v.i("MicroMsg.ChattingListAdapter", "summerbadcr revisedCursor check fault first/last seq[%d], restart[%b], undeliver[%d]", new Object[] { Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("msgSeq"))), Boolean.valueOf(bool1), Integer.valueOf(k) });
        j = 0;
        label575:
        label623:
        do
        {
          i = localCursor.getInt(localCursor.getColumnIndex("flag"));
          if (((i & 0x2) != 0) || (localCursor.getInt(localCursor.getColumnIndex("isSend")) == 0)) {
            break;
          }
          i = j + 1;
          if (!bool1) {
            break label1302;
          }
          j = i;
        } while (localCursor.moveToPrevious());
      }
      for (;;)
      {
        k = 1;
        j = i;
        for (i = k;; i = 0)
        {
          localObject = localCursor;
          if (i != 0) {
            v.i("MicroMsg.ChattingListAdapter", "summerbadcr resetCursor check fault traversal all not found take time[%d]ms, cursor index:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(j) });
          }
          label704:
          label714:
          for (localObject = localCursor;; localObject = localCursor)
          {
            break;
            i = localCursor.getCount();
            break label442;
            if (localCursor.moveToFirst()) {
              break label492;
            }
          }
          label721:
          k = ((com.tencent.mm.e.b.aj)localObject).field_UnDeliverCount;
          break label522;
          if ((k != 0) || ((i & 0x2) != 0)) {
            break label913;
          }
          i = localCursor.getInt(localCursor.getColumnIndex("type"));
          if ((i > 50) || (i < 0))
          {
            i = j + 1;
            break label623;
          }
          this.vxP.vGw = false;
          localObject = new com.tencent.mm.storage.au();
          ((com.tencent.mm.storage.au)localObject).b(localCursor);
          localCursor.moveToFirst();
          v.i("MicroMsg.ChattingListAdapter", "summerbadcr revisedCursor check fault but not needCheckFault more break[%d, %d, %d, %d, %d, %d] take time[%d]ms, cursor index:%d", new Object[] { Integer.valueOf(((com.tencent.mm.e.b.ce)localObject).field_flag), Integer.valueOf(((com.tencent.mm.e.b.ce)localObject).field_isSend), Long.valueOf(((com.tencent.mm.e.b.ce)localObject).field_msgId), Long.valueOf(((com.tencent.mm.e.b.ce)localObject).field_msgSvrId), Long.valueOf(((com.tencent.mm.e.b.ce)localObject).field_msgSeq), Integer.valueOf(((com.tencent.mm.e.b.ce)localObject).field_type), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(j) });
        }
        label913:
        if ((i & 0x1) == 0)
        {
          i = j + 1;
          break label623;
        }
        if (j == 0)
        {
          i = j + 1;
          v.i("MicroMsg.ChattingListAdapter", "summerbadcr revisedCursor check fault index == 0 continue");
          break label623;
        }
        boolean bool2;
        label955:
        label1022:
        int m;
        long l2;
        long l3;
        long l4;
        int n;
        long l5;
        long l6;
        if ((i & 0x4) != 0)
        {
          bool2 = true;
          localObject = new com.tencent.mm.storage.au();
          ((com.tencent.mm.storage.au)localObject).b(localCursor);
          localCursor.close();
          if (!bool1) {
            break label1211;
          }
          this.kvt = (this.hOq - j - 1);
          com.tencent.mm.u.ap.yY();
          localCursor = com.tencent.mm.u.c.wT().bj(this.fJC, this.hOq - this.kvt);
          k = ((com.tencent.mm.e.b.ce)localObject).field_flag;
          m = ((com.tencent.mm.e.b.ce)localObject).field_isSend;
          l2 = ((com.tencent.mm.e.b.ce)localObject).field_msgId;
          l3 = ((com.tencent.mm.e.b.ce)localObject).field_msgSvrId;
          l4 = ((com.tencent.mm.e.b.ce)localObject).field_msgSeq;
          n = ((com.tencent.mm.e.b.ce)localObject).field_type;
          l5 = ((com.tencent.mm.e.b.ce)localObject).field_createTime;
          l6 = System.currentTimeMillis();
          if (localCursor != null) {
            break label1291;
          }
        }
        label1211:
        label1291:
        for (i = -1;; i = localCursor.getCount())
        {
          v.i("MicroMsg.ChattingListAdapter", "summerbadcr revisedCursor check fault faultUp[%b]  break[%d, %d, %d, %d, %d, %d, %d] take time[%d]ms, cursor index:%d, nowCount:%d, fromCount:%d", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(n), Long.valueOf(l5), Long.valueOf(l6 - l1), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.kvt) });
          i = 0;
          break;
          bool2 = false;
          break label955;
          if (bool2)
          {
            this.kvt += j;
            com.tencent.mm.u.ap.yY();
            localCursor = com.tencent.mm.u.c.wT().bj(this.fJC, this.hOq - this.kvt);
            break label1022;
          }
          com.tencent.mm.u.ap.yY();
          localCursor = com.tencent.mm.u.c.wT().g(this.fJC, this.hOq - this.kvt, ((com.tencent.mm.e.b.ce)localObject).field_createTime);
          break label1022;
        }
        label1302:
        j = i;
        if (localCursor.moveToNext()) {
          break label575;
        }
      }
      label1317:
      if (((Cursor)localObject).moveToLast())
      {
        this.vDI = a(this.vDI, (Cursor)localObject);
        this.vDs = this.vDI.field_createTime;
      }
      this.vDD = -1L;
      if (((Cursor)localObject).moveToFirst())
      {
        this.vDI = a(this.vDI, (Cursor)localObject);
        this.vDr = this.vDI.field_createTime;
      }
      v.d("MicroMsg.ChattingListAdapter", "update pos topCreateTime[%d] downCreateTime[%d]", new Object[] { Long.valueOf(this.vDr), Long.valueOf(this.vDs) });
      break label240;
      label1428:
      v.i("MicroMsg.ChattingListAdapter", "topLoadMore[%B] downLoadMore[%B]", new Object[] { Boolean.valueOf(this.vDw), Boolean.valueOf(this.vDx) });
      if ((!this.vDw) && (!this.vDx) && (this.vDs >= this.vDt))
      {
        if (this.sLe)
        {
          com.tencent.mm.u.ap.yY();
          this.vDt = com.tencent.mm.u.c.wU().aj(this.fJC, this.jZq);
          com.tencent.mm.u.ap.yY();
          this.vDv = Math.max(0, com.tencent.mm.u.c.wU().b(this.fJC, this.jZq, this.vDs, this.vDt) - 1);
          label1552:
          this.vDs = this.vDt;
        }
      }
      else
      {
        if (this.vDw)
        {
          this.vDw = false;
          if (!this.sLe) {
            break label1938;
          }
          com.tencent.mm.u.ap.yY();
          l1 = com.tencent.mm.u.c.wU().n(this.fJC, this.jZq, this.vDr);
          com.tencent.mm.u.ap.yY();
          this.vDu = Math.max(0, com.tencent.mm.u.c.wU().b(this.fJC, this.jZq, l1, this.vDr) - 1);
          label1637:
          this.vDr = l1;
        }
        if (this.vDx)
        {
          this.vDx = false;
          if (!this.sLe) {
            break label1995;
          }
          com.tencent.mm.u.ap.yY();
          l1 = com.tencent.mm.u.c.wU().o(this.fJC, this.jZq, this.vDs);
          com.tencent.mm.u.ap.yY();
        }
      }
      for (this.vDv = Math.max(0, com.tencent.mm.u.c.wU().b(this.fJC, this.jZq, this.vDs, l1) - 1);; this.vDv = Math.max(0, com.tencent.mm.u.c.wT().g(this.fJC, this.vDs, l1) - 1))
      {
        this.vDs = l1;
        v.v("MicroMsg.ChattingListAdapter", "query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", new Object[] { Long.valueOf(this.vDr), Long.valueOf(this.vDs), Long.valueOf(this.vDt), Integer.valueOf(this.vDu), Integer.valueOf(this.vDv) });
        if (!this.sLe) {
          break label2052;
        }
        com.tencent.mm.u.ap.yY();
        v.v("MicroMsg.ChattingListAdapter", "count([top, down]) = %d", new Object[] { Integer.valueOf(com.tencent.mm.u.c.wU().b(this.fJC, this.jZq, this.vDr, this.vDs)) });
        com.tencent.mm.u.ap.yY();
        setCursor(com.tencent.mm.u.c.wU().c(this.fJC, this.jZq, this.vDr, this.vDs));
        break;
        this.vDt = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().AB(this.fJC);
        com.tencent.mm.u.ap.yY();
        this.vDv = Math.max(0, com.tencent.mm.u.c.wT().g(this.fJC, this.vDs, this.vDt) - 1);
        break label1552;
        label1938:
        com.tencent.mm.u.ap.yY();
        l1 = com.tencent.mm.u.c.wT().J(this.fJC, this.vDr);
        com.tencent.mm.u.ap.yY();
        this.vDu = Math.max(0, com.tencent.mm.u.c.wT().g(this.fJC, l1, this.vDr) - 1);
        break label1637;
        label1995:
        com.tencent.mm.u.ap.yY();
        l1 = com.tencent.mm.u.c.wT().K(this.fJC, this.vDs);
        com.tencent.mm.u.ap.yY();
      }
      label2052:
      com.tencent.mm.u.ap.yY();
      v.v("MicroMsg.ChattingListAdapter", "count([top, down]) = %d", new Object[] { Integer.valueOf(com.tencent.mm.u.c.wT().g(this.fJC, this.vDr, this.vDs)) });
      com.tencent.mm.u.ap.yY();
      setCursor(com.tencent.mm.u.c.wT().h(this.fJC, this.vDr, this.vDs));
    }
  }
  
  protected final void OM()
  {
    GMTrace.i(2402228895744L, 17898);
    com.tencent.mm.u.ap.yY();
    setCursor(com.tencent.mm.u.c.wT().aJZ());
    GMTrace.o(2402228895744L, 17898);
  }
  
  public final boolean Tu(String paramString)
  {
    GMTrace.i(2404644814848L, 17916);
    try
    {
      this.oIE = new com.tencent.mm.pluginsdk.ui.e(com.tencent.mm.sdk.platformtools.bf.convertStreamToString(new FileInputStream(paramString)));
      GMTrace.o(2404644814848L, 17916);
      return true;
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.ChattingListAdapter", paramString, "", new Object[0]);
      this.oIE = null;
      GMTrace.o(2404644814848L, 17916);
    }
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(2404913250304L, 17918);
    if (this.jrx != null) {
      this.jrx.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2236067348480L, 16660);
          cv.this.notifyDataSetChanged();
          GMTrace.o(2236067348480L, 16660);
        }
      });
    }
    GMTrace.o(2404913250304L, 17918);
  }
  
  public final void a(long paramLong, com.tencent.mm.storage.au paramau, boolean paramBoolean)
  {
    GMTrace.i(2405047468032L, 17919);
    if ((!this.vDE.containsKey(Long.valueOf(paramLong))) || (!this.vDF.containsKey(Long.valueOf(paramLong))))
    {
      v.d("MicroMsg.ChattingListAdapter", "msg not display, " + paramLong);
      GMTrace.o(2405047468032L, 17919);
      return;
    }
    Object localObject1 = (ag.a)((View)this.vDE.get(Long.valueOf(paramLong))).getTag();
    if (((Integer)this.vDF.get(Long.valueOf(paramLong))).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject2 = ai(3, bool);
      if ((localObject2 instanceof br))
      {
        localObject2 = (br)localObject2;
        if ((localObject2 != null) && (true == paramBoolean))
        {
          localObject1 = (dr)localObject1;
          n.GT().a(((dr)localObject1).vwI, paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(((br)localObject2).vAn.uRf.uRz), paramau.gxw, paramau.gxx, R.g.bdG, ((dr)localObject1).vKZ, R.g.bdH, 1, null);
        }
      }
      GMTrace.o(2405047468032L, 17919);
      return;
    }
  }
  
  public final void a(s.a.a parama)
  {
    GMTrace.i(2405315903488L, 17921);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parama != null)
    {
      if (parama.iac != 3) {
        break label55;
      }
      bool1 = eh.b(parama);
    }
    for (;;)
    {
      if (!bool1) {
        ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2492960079872L, 18574);
            cv.this.a(null, null);
            GMTrace.o(2492960079872L, 18574);
          }
        });
      }
      GMTrace.o(2405315903488L, 17921);
      return;
      label55:
      if ((parama.iac != 2) && (parama.iac != -1))
      {
        bool1 = bool2;
        if (parama.iac != 1) {}
      }
      else
      {
        bool1 = el.b(parama);
      }
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    GMTrace.i(2402765766656L, 17902);
    if (this.vDL)
    {
      this.vDL = false;
      GMTrace.o(2402765766656L, 17902);
      return;
    }
    if (this.vDJ)
    {
      this.vDK = true;
      GMTrace.o(2402765766656L, 17902);
      return;
    }
    if (this.fJC == null)
    {
      GMTrace.o(2402765766656L, 17902);
      return;
    }
    if (!this.fwJ)
    {
      v.i("MicroMsg.ChattingListAdapter", "is not resumeState ");
      GMTrace.o(2402765766656L, 17902);
      return;
    }
    super.a(paramString, paraml);
    GMTrace.o(2402765766656L, 17902);
  }
  
  public final void a(String paramString1, p paramp, String paramString2)
  {
    GMTrace.i(2401557807104L, 17893);
    this.vDC = new TreeSet();
    this.vCY = paramString1;
    if (x.eO(paramString1)) {}
    for (this.hrv = x.QQ(paramString2);; this.hrv = paramString2)
    {
      this.vCX = paramp;
      paramp = new cw(this.vxP, paramString1);
      this.vDc = paramp;
      this.vDb = paramp;
      this.fJC = paramString1;
      this.jZq = this.vxP.bVG();
      bUk();
      GMTrace.o(2401557807104L, 17893);
      return;
    }
  }
  
  public final ag ai(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2404376379392L, 17914);
    Map localMap = vDH;
    StringBuilder localStringBuilder = new StringBuilder("T").append(paramInt);
    if (paramBoolean)
    {
      localObject = "S";
      int i = com.tencent.mm.sdk.platformtools.bf.f((Integer)localMap.get((String)localObject));
      paramInt = i;
      if (i == 0)
      {
        localMap = vDH;
        localStringBuilder = new StringBuilder("T1");
        if (!paramBoolean) {
          break label155;
        }
      }
    }
    label155:
    for (Object localObject = "S";; localObject = "R")
    {
      paramInt = com.tencent.mm.sdk.platformtools.bf.f((Integer)localMap.get((String)localObject));
      localObject = (ag)this.qGc.get(Integer.valueOf(paramInt));
      GMTrace.o(2404376379392L, 17914);
      return (ag)localObject;
      localObject = "R";
      break;
    }
  }
  
  public final void auc()
  {
    GMTrace.i(2404242161664L, 17913);
    this.vDz = false;
    notifyDataSetChanged();
    v.d("MicroMsg.ChattingListAdapter", "enable ClickListener");
    this.vDb = this.vDc;
    this.vDd = this.vDe;
    this.vDf = this.vDg;
    this.vDh = this.vDi;
    this.vDj = this.vDk;
    this.vDl = this.vDm;
    this.vDn = this.vDo;
    this.vxP.bVH();
    GMTrace.o(2404242161664L, 17913);
  }
  
  public final void bCV()
  {
    GMTrace.i(2405181685760L, 17920);
    if (this.jrx != null) {
      this.jrx.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2169898008576L, 16167);
          cv.this.notifyDataSetChanged();
          GMTrace.o(2169898008576L, 16167);
        }
      });
    }
    GMTrace.o(2405181685760L, 17920);
  }
  
  public final void bUk()
  {
    GMTrace.i(2401692024832L, 17894);
    if (this.vDC != null) {
      this.vDC.clear();
    }
    this.hOq = 0;
    this.kvt = -1;
    this.vDr = -1L;
    this.vDs = -1L;
    this.vDt = -1L;
    this.vCU = -1L;
    this.vDu = 0;
    this.vDv = 0;
    this.vDw = false;
    this.vDx = false;
    this.vDy = false;
    this.vDz = false;
    GMTrace.o(2401692024832L, 17894);
  }
  
  public final boolean bUl()
  {
    GMTrace.i(2402094678016L, 17897);
    if (this.vDy)
    {
      this.vDt = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().AB(this.fJC);
      if (this.vDt >= this.vDs)
      {
        this.vDs = this.vDt;
        OL();
        GMTrace.o(2402094678016L, 17897);
        return true;
      }
    }
    GMTrace.o(2402094678016L, 17897);
    return false;
  }
  
  public final void bUm()
  {
    GMTrace.i(2402631548928L, 17901);
    this.vDK = false;
    this.vDJ = false;
    this.vDL = false;
    a(null, null);
    GMTrace.o(2402631548928L, 17901);
  }
  
  public final boolean bUn()
  {
    GMTrace.i(2403436855296L, 17907);
    if (!this.vDy)
    {
      if (this.kvt <= 0)
      {
        GMTrace.o(2403436855296L, 17907);
        return true;
      }
      GMTrace.o(2403436855296L, 17907);
      return false;
    }
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().AA(this.fJC);
    if (this.vDr <= l)
    {
      GMTrace.o(2403436855296L, 17907);
      return true;
    }
    GMTrace.o(2403436855296L, 17907);
    return false;
  }
  
  public final boolean bUo()
  {
    GMTrace.i(2403571073024L, 17908);
    if (!this.vDy)
    {
      GMTrace.o(2403571073024L, 17908);
      return true;
    }
    long l = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().AB(this.fJC);
    if (this.vDs >= l)
    {
      GMTrace.o(2403571073024L, 17908);
      return true;
    }
    GMTrace.o(2403571073024L, 17908);
    return false;
  }
  
  final void bUp()
  {
    GMTrace.i(2403973726208L, 17911);
    v.d("MicroMsg.ChattingListAdapter", "disable clickListener");
    this.vDb = null;
    this.vDd = null;
    this.vDf = null;
    this.vDh = null;
    this.vDj = null;
    this.vDl = null;
    this.vDn = null;
    GMTrace.o(2403973726208L, 17911);
  }
  
  public final void bUq()
  {
    GMTrace.i(2404107943936L, 17912);
    this.vDz = true;
    notifyDataSetChanged();
    bUp();
    GMTrace.o(2404107943936L, 17912);
  }
  
  public final boolean bm(Context paramContext, String paramString)
  {
    GMTrace.i(2404779032576L, 17917);
    if (vDN.containsKey(paramString))
    {
      this.oIE = ((com.tencent.mm.pluginsdk.ui.e)vDN.get(paramString));
      GMTrace.o(2404779032576L, 17917);
      return true;
    }
    try
    {
      this.oIE = new com.tencent.mm.pluginsdk.ui.e(com.tencent.mm.sdk.platformtools.bf.convertStreamToString(paramContext.getAssets().open(paramString)));
      vDN.put(paramString, this.oIE);
      GMTrace.o(2404779032576L, 17917);
      return true;
    }
    catch (Exception paramContext)
    {
      v.printErrStackTrace("MicroMsg.ChattingListAdapter", paramContext, "", new Object[0]);
      GMTrace.o(2404779032576L, 17917);
    }
    return false;
  }
  
  public final boolean eG(long paramLong)
  {
    GMTrace.i(2403839508480L, 17910);
    if (this.vDC.contains(Long.valueOf(paramLong)))
    {
      v.d("MicroMsg.ChattingListAdapter", "remove select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      this.vDC.remove(Long.valueOf(paramLong));
    }
    for (;;)
    {
      a(null, null);
      GMTrace.o(2403839508480L, 17910);
      return true;
      v.d("MicroMsg.ChattingListAdapter", "add select item, msgId = %d", new Object[] { Long.valueOf(paramLong) });
      if (this.vDC.size() >= 100)
      {
        com.tencent.mm.ui.base.g.b(this.vxP.uRf.uRz, this.vxP.getString(R.l.eeX, new Object[] { Integer.valueOf(100) }), "", true);
        GMTrace.o(2403839508480L, 17910);
        return false;
      }
      this.vDC.add(Long.valueOf(paramLong));
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    GMTrace.i(2402899984384L, 17903);
    paramInt = aq((com.tencent.mm.storage.au)getItem(paramInt));
    GMTrace.o(2402899984384L, 17903);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(2403705290752L, 17909);
    com.tencent.mm.storage.au localau = (com.tencent.mm.storage.au)getItem(paramInt);
    v.i("MicroMsg.ChattingListAdapter", "shwen getview:%d, msgId %d, svrId %d, type:%d, send:%d, talker:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(localau.field_msgId), Long.valueOf(localau.field_msgSvrId), Integer.valueOf(localau.field_type), Integer.valueOf(localau.field_isSend), localau.field_talker });
    if (paramInt == 0) {
      this.vxP.bUV();
    }
    long l1;
    long l2;
    int i;
    if ((paramInt != 0) && ((this.nvS[paramInt] == 0) || (this.vCT[(paramInt - 1)] == 0)))
    {
      paramViewGroup = (com.tencent.mm.storage.au)getItem(paramInt - 1);
      l1 = paramViewGroup.field_createTime;
      l2 = localau.field_createTime;
      if (l2 - l1 >= 60000L) {
        break label1076;
      }
      i = 1;
    }
    for (;;)
    {
      int j;
      label183:
      label200:
      label259:
      label275:
      int k;
      boolean bool;
      label294:
      Object localObject1;
      label438:
      label483:
      label503:
      Object localObject2;
      if ((l2 - l1) / 180000L < 1L)
      {
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label1088;
        }
        this.nvS[paramInt] = 2;
        this.vCT[(paramInt - 1)] = aq(paramViewGroup);
        if (((this.nvS[paramInt] != 1) && (paramInt != 0) && (!this.vCV.contains(Long.valueOf(localau.field_msgId)))) || (localau.field_createTime <= 1000L)) {
          break label1098;
        }
        i = 1;
        if (localau.field_msgId != this.vCU) {
          break label1104;
        }
        j = 1;
        k = localau.field_type;
        if (localau.field_isSend != 1) {
          break label1110;
        }
        bool = true;
        localObject1 = ai(k, bool);
        if (localObject1 != null) {
          this.vCT[paramInt] = ((short)((ag)localObject1).bUe());
        }
        if ((localObject1 == null) && (paramView == null)) {
          v.e("MicroMsg.ChattingListAdapter", "inflating fail, item & convertView both are null, msgtype = " + localau.field_type + ", isSend = " + localau.field_isSend);
        }
        paramViewGroup = paramView;
        if (paramView == null)
        {
          if (this.mwN == null) {
            this.mwN = r.eC(this.vxP.uRf.uRz);
          }
          paramViewGroup = ((ag)localObject1).a(this.mwN, paramView);
        }
        paramView = (ag.a)paramViewGroup.getTag();
        Assert.assertNotNull(paramViewGroup);
        Assert.assertNotNull(paramView);
        if (!this.vDz) {
          break label1116;
        }
        k = 1;
        paramView.vAk = k;
        if (i == 0) {
          break label1122;
        }
        paramView.kvw.setVisibility(0);
        paramView.kvw.setText(com.tencent.mm.pluginsdk.j.o.c(this.vxP.uRf.uRz, localau.field_createTime, false));
        if (paramView.vAi != null)
        {
          if (j == 0) {
            break label1134;
          }
          paramView.vAi.setVisibility(0);
        }
        i = localau.field_type;
        if (localau.field_isSend != 1) {
          break label1146;
        }
        bool = true;
        localObject1 = ai(i, bool);
        if (localObject1 != null)
        {
          this.vCT[paramInt] = ((short)((ag)localObject1).bUe());
          paramView.vAl = 0L;
          localObject2 = com.tencent.mm.am.b.HM();
          if ((localObject2 == null) || (((anc)localObject2).tps == null) || (((anc)localObject2).tPV != 0) || (!com.tencent.mm.am.b.HK())) {}
        }
      }
      try
      {
        paramView.vAl = com.tencent.mm.sdk.platformtools.bf.getLong(((anc)localObject2).tps, 0L);
        localObject2 = this.vxP;
        l1 = this.vDO;
        l2 = System.currentTimeMillis();
        this.vDO = l2;
        if (l1 + 30000L < l2)
        {
          com.tencent.mm.u.ap.yY();
          this.sWq = com.tencent.mm.u.c.isSDCardAvailable();
        }
        ((ag)localObject1).a(paramView, paramInt, (En_5b8fbb1e.a)localObject2, localau, this.sWq);
        if ((paramView.kvw.getVisibility() == 0) && (this.oIE != null))
        {
          paramView.kvw.setTextColor(this.oIE.sGK);
          if (this.oIE.sGL)
          {
            paramView.kvw.setShadowLayer(2.0F, 1.2F, 1.2F, this.oIE.sGM);
            if (!this.oIE.sGN) {
              break label1176;
            }
            paramView.kvw.setBackgroundResource(R.g.bdP);
            paramView.kvw.setPadding(this.vDa, this.vCZ, this.vDa, this.vCZ);
          }
        }
        else
        {
          if ((paramView.phd != null) && (paramView.phd.getVisibility() == 0) && (this.oIE != null) && (!this.fJC.equals("qqmail")) && (aq(localau) != 40))
          {
            paramView.phd.setTextColor(this.oIE.sGO);
            paramView.phd.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          }
          if (this.vDz)
          {
            if (!localau.isSystem()) {
              break label1187;
            }
            paramInt = 0;
            if (paramInt != 0) {}
          }
          else
          {
            if (!this.vDA) {
              break label1192;
            }
          }
          if (paramView.mdQ != null) {
            paramView.mdQ.setChecked(this.vDC.contains(Long.valueOf(localau.field_msgId)));
          }
          if (paramView.nQv != null)
          {
            paramView.nQv.setTag(Long.valueOf(localau.field_msgId));
            paramView.nQv.setOnClickListener(this.vDM);
          }
          paramView.le(true);
          paramView = this.vDE.entrySet().iterator();
          while (paramView.hasNext())
          {
            localObject1 = (Map.Entry)paramView.next();
            if (((Map.Entry)localObject1).getValue() == paramViewGroup)
            {
              this.vDE.remove(((Map.Entry)localObject1).getKey());
              this.vDF.remove(((Map.Entry)localObject1).getKey());
            }
          }
          this.vDE.put(Long.valueOf(localau.field_msgId), paramViewGroup);
          if (localau.bLX()) {
            this.vDF.put(Long.valueOf(localau.field_msgId), Integer.valueOf(localau.field_isSend));
          }
          GMTrace.o(2403705290752L, 17909);
          return paramViewGroup;
          label1076:
          i = 0;
          continue;
          j = 0;
          break label183;
          label1088:
          this.nvS[paramInt] = 1;
          break label200;
          label1098:
          i = 0;
          break label259;
          label1104:
          j = 0;
          break label275;
          label1110:
          bool = false;
          break label294;
          label1116:
          k = 0;
          break label438;
          label1122:
          paramView.kvw.setVisibility(8);
          break label483;
          label1134:
          paramView.vAi.setVisibility(8);
          break label503;
          label1146:
          bool = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramView.vAl = 0L;
          continue;
          paramView.kvw.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          continue;
          label1176:
          paramView.kvw.setBackgroundColor(0);
          continue;
          label1187:
          paramInt = 1;
          continue;
          label1192:
          paramView.le(false);
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    GMTrace.i(2403168419840L, 17905);
    GMTrace.o(2403168419840L, 17905);
    return 75;
  }
  
  public final void lf(boolean paramBoolean)
  {
    GMTrace.i(2402497331200L, 17900);
    this.vDJ = paramBoolean;
    if (!paramBoolean) {
      this.vDL = false;
    }
    if ((!paramBoolean) && (this.vDK))
    {
      a(null, null);
      this.vDK = false;
    }
    GMTrace.o(2402497331200L, 17900);
  }
  
  public final int n(long paramLong, boolean paramBoolean)
  {
    GMTrace.i(2401826242560L, 17895);
    com.tencent.mm.u.ap.yY();
    com.tencent.mm.storage.au localau = com.tencent.mm.u.c.wT().cA(paramLong);
    if (localau.field_msgId != paramLong)
    {
      v.w("MicroMsg.ChattingListAdapter", "get msg info by id %d error", new Object[] { Long.valueOf(paramLong) });
      GMTrace.o(2401826242560L, 17895);
      return 0;
    }
    long l = localau.field_createTime;
    int i;
    if ((l < this.vDr) || (l > this.vDs))
    {
      this.vDr = l;
      this.vDt = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().AB(this.fJC);
      if (paramBoolean)
      {
        this.vDs = this.vDt;
        this.vDy = true;
        com.tencent.mm.u.ap.yY();
        i = com.tencent.mm.u.c.wT().g(this.fJC, this.vDr, this.vDs);
        v.v("MicroMsg.ChattingListAdapter", "reset position, reload count %d", new Object[] { Integer.valueOf(i) });
        if (i >= 18) {
          break label396;
        }
        v.d("MicroMsg.ChattingListAdapter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", new Object[] { Long.valueOf(this.vDr), Integer.valueOf(0) });
        com.tencent.mm.u.ap.yY();
        this.vDr = com.tencent.mm.u.c.wT().J(this.fJC, this.vDr);
        com.tencent.mm.u.ap.yY();
        i = com.tencent.mm.u.c.wT().g(this.fJC, this.vDr, l);
      }
    }
    for (;;)
    {
      v.v("MicroMsg.ChattingListAdapter", "set local message id, id[%d] top create time[%d] bottom create time[%d] last create time[%d] selection[%d]", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.vDr), Long.valueOf(this.vDs), Long.valueOf(this.vDt), Integer.valueOf(i) });
      GMTrace.o(2401826242560L, 17895);
      return i;
      com.tencent.mm.u.ap.yY();
      this.vDs = com.tencent.mm.u.c.wT().K(this.fJC, l);
      break;
      com.tencent.mm.u.ap.yY();
      i = com.tencent.mm.u.c.wT().g(this.fJC, this.vDr, l);
      continue;
      label396:
      i = 0;
    }
  }
  
  final class a
    implements View.OnClickListener
  {
    a()
    {
      GMTrace.i(2155134058496L, 16057);
      GMTrace.o(2155134058496L, 16057);
    }
    
    private static boolean eH(long paramLong)
    {
      GMTrace.i(2155402493952L, 16059);
      anc localanc = com.tencent.mm.am.b.HM();
      if ((localanc != null) && (localanc.tps != null) && (localanc.tPV == 0) && (com.tencent.mm.am.b.HK())) {
        try
        {
          long l = Long.parseLong(localanc.tps);
          if (paramLong == l)
          {
            GMTrace.o(2155402493952L, 16059);
            return true;
          }
        }
        catch (Exception localException)
        {
          GMTrace.o(2155402493952L, 16059);
          return false;
        }
      }
      GMTrace.o(2155402493952L, 16059);
      return false;
    }
    
    public final void onClick(View paramView)
    {
      int j = 0;
      GMTrace.i(2155268276224L, 16058);
      long l1;
      com.tencent.mm.storage.au localau;
      int i;
      if ((paramView.getTag() instanceof cv.b))
      {
        paramView = (cv.b)paramView.getTag();
        l1 = paramView.fGD;
        com.tencent.mm.u.ap.yY();
        localau = com.tencent.mm.u.c.wT().cA(paramView.fGD);
        if (!eH(l1)) {
          break label144;
        }
        com.tencent.mm.plugin.report.service.g.oSF.A(10231, "1");
        com.tencent.mm.am.b.HI();
        if (localau.field_msgId == l1)
        {
          paramView = com.tencent.mm.modelstat.b.hTV;
          i = com.tencent.mm.t.g.g(localau);
          if (paramView.JU()) {
            if (j == 0) {
              break label259;
            }
          }
        }
      }
      label144:
      label259:
      for (Object localObject = b.b.hUr;; localObject = b.b.hUs)
      {
        paramView.a(localau, (b.b)localObject, i);
        do
        {
          cv.this.vxP.vzN.notifyDataSetChanged();
          GMTrace.o(2155268276224L, 16058);
          return;
          localObject = f.a.ek(paramView.fQO);
          if (localObject != null)
          {
            com.tencent.mm.plugin.report.service.g.oSF.A(10090, "0,1");
            com.tencent.mm.am.a.a locala = (com.tencent.mm.am.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.am.a.a.class);
            long l2 = paramView.fGD;
            String str = paramView.fNR;
            com.tencent.mm.u.ap.yY();
            com.tencent.mm.am.b.b(locala.a((f.a)localObject, String.valueOf(l2), str, com.tencent.mm.u.c.xv(), paramView.fNR));
          }
        } while (localau.field_msgId != l1);
        paramView = com.tencent.mm.modelstat.b.hTV;
        if (localObject != null)
        {
          i = ((f.a)localObject).type;
          j = 1;
          break;
        }
        i = 0;
        j = 1;
        break;
      }
    }
  }
  
  static final class b
  {
    public long fGD;
    public String fNR;
    public String fQO;
    
    b()
    {
      GMTrace.i(2204794617856L, 16427);
      GMTrace.o(2204794617856L, 16427);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */