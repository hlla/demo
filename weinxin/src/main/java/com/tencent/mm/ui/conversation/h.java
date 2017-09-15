package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.tools.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class h
  extends k<com.tencent.mm.storage.ae>
  implements m.b
{
  private static long wak;
  private String fRk;
  protected MMSlideDelView.f jUm;
  protected MMSlideDelView.c jUn;
  protected MMSlideDelView.e jUo;
  protected MMSlideDelView.d jUp;
  private boolean vZY;
  private boolean vZZ;
  private float vtB;
  private float vtC;
  private float vtD;
  HashMap<String, a> vtF;
  public String waf;
  private final int wah;
  private final int wai;
  private boolean wal;
  ai wam;
  private ColorStateList[] wbx;
  
  static
  {
    GMTrace.i(3386850148352L, 25234);
    wak = 2000L;
    GMTrace.o(3386850148352L, 25234);
  }
  
  public h(Context paramContext, String paramString, k.a parama)
  {
    super(paramContext, new com.tencent.mm.storage.ae());
    GMTrace.i(3383494705152L, 25209);
    this.wbx = new ColorStateList[5];
    this.jUp = MMSlideDelView.bSe();
    this.vtB = -1.0F;
    this.vtC = -1.0F;
    this.vtD = -1.0F;
    this.vZY = false;
    this.vZZ = false;
    this.waf = "";
    this.wal = false;
    this.wam = new ai(ap.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(3408459202560L, 25395);
        if (h.a(h.this)) {
          h.b(h.this);
        }
        GMTrace.o(3408459202560L, 25395);
        return false;
      }
    }, false);
    this.uQY = parama;
    this.fRk = paramString;
    this.vtF = new HashMap();
    this.wbx[0] = com.tencent.mm.bg.a.S(paramContext, R.e.aUo);
    this.wbx[1] = com.tencent.mm.bg.a.S(paramContext, R.e.aVe);
    this.wbx[3] = com.tencent.mm.bg.a.S(paramContext, R.e.aVo);
    this.wbx[2] = com.tencent.mm.bg.a.S(paramContext, R.e.aVc);
    this.wbx[2] = com.tencent.mm.bg.a.S(paramContext, R.e.aVc);
    this.wbx[4] = com.tencent.mm.bg.a.S(paramContext, R.e.aUy);
    if (com.tencent.mm.bg.a.dM(paramContext)) {
      this.wai = paramContext.getResources().getDimensionPixelSize(R.f.aWN);
    }
    for (this.wah = paramContext.getResources().getDimensionPixelSize(R.f.aWO);; this.wah = paramContext.getResources().getDimensionPixelSize(R.f.aWP))
    {
      this.vtB = com.tencent.mm.bg.a.T(paramContext, R.f.aXH);
      this.vtC = com.tencent.mm.bg.a.T(paramContext, R.f.aXr);
      this.vtD = com.tencent.mm.bg.a.T(paramContext, R.f.aXV);
      ap.yY();
      com.tencent.mm.u.c.wW().a(this);
      GMTrace.o(3383494705152L, 25209);
      return;
      this.wai = paramContext.getResources().getDimensionPixelSize(R.f.aWM);
    }
  }
  
  private static String Ti(String paramString)
  {
    GMTrace.i(3384971100160L, 25220);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ua(paramString);
      GMTrace.o(3384971100160L, 25220);
      return paramString;
    }
    GMTrace.o(3384971100160L, 25220);
    return null;
  }
  
  private void bYm()
  {
    GMTrace.i(3385239535616L, 25222);
    if (this.vtF == null)
    {
      GMTrace.o(3385239535616L, 25222);
      return;
    }
    Iterator localIterator = this.vtF.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).waq = null;
    }
    GMTrace.o(3385239535616L, 25222);
  }
  
  private void bYn()
  {
    GMTrace.i(3385642188800L, 25225);
    com.tencent.mm.sdk.platformtools.ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3397184913408L, 25311);
        if (!ap.zb())
        {
          h.c(h.this).KI();
          v.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
          GMTrace.o(3397184913408L, 25311);
          return;
        }
        long l = com.tencent.mm.platformtools.u.NA();
        h.d(h.this);
        l = com.tencent.mm.platformtools.u.aA(l) * 3L;
        v.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(h.bYu()), Boolean.valueOf(h.a(h.this)) });
        h.eW((l + h.bYu()) / 2L);
        h.e(h.this);
        ai localai = h.c(h.this);
        l = h.bYu();
        localai.v(l, l);
        GMTrace.o(3397184913408L, 25311);
      }
    });
    GMTrace.o(3385642188800L, 25225);
  }
  
  private CharSequence c(com.tencent.mm.storage.ae paramae, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(3384836882432L, 25219);
    if ((!com.tencent.mm.platformtools.u.mA(paramae.field_editingMsg)) && ((paramae.field_atCount <= 0) || (paramae.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.eyN));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, paramae.field_editingMsg, paramInt));
      GMTrace.o(3384836882432L, 25219);
      return (CharSequence)localObject1;
    }
    Object localObject1 = paramae.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramae = new SpannableString(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, (CharSequence)localObject1, paramInt));
      GMTrace.o(3384836882432L, 25219);
      return paramae;
    }
    String str1;
    if ((k(paramae) == 47) || (k(paramae) == 1048625))
    {
      localObject1 = Ti(paramae.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramae = "[" + (String)localObject1 + "]";
        GMTrace.o(3384836882432L, 25219);
        return paramae;
      }
      localObject1 = str1;
      if (paramae.field_digest != null)
      {
        localObject1 = str1;
        if (paramae.field_digest.contains(":"))
        {
          str1 = paramae.field_digest.substring(0, paramae.field_digest.indexOf(":"));
          String str2 = Ti(paramae.field_digest.substring(paramae.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = str1;
          if (str2 != null)
          {
            paramae = "[" + str2 + "]";
            if (com.tencent.mm.platformtools.u.mA(str1))
            {
              GMTrace.o(3384836882432L, 25219);
              return paramae;
            }
            paramae = str1 + ": " + paramae;
            GMTrace.o(3384836882432L, 25219);
            return paramae;
          }
        }
      }
      str1 = this.context.getString(R.l.dGD);
      if (com.tencent.mm.platformtools.u.mA((String)localObject1))
      {
        localObject1 = str1;
        paramae.cu((String)localObject1);
      }
    }
    else
    {
      if (com.tencent.mm.platformtools.u.mA(paramae.field_digest)) {
        break label654;
      }
      if (com.tencent.mm.platformtools.u.mA(paramae.field_digestUser)) {
        break label643;
      }
      if ((paramae.field_isSend != 0) || (!com.tencent.mm.u.o.dH(paramae.field_username))) {
        break label631;
      }
      localObject1 = com.tencent.mm.u.n.E(paramae.field_digestUser, paramae.field_username);
    }
    for (;;)
    {
      label631:
      label643:
      try
      {
        localObject1 = String.format(paramae.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramae.field_atCount <= 0) || (paramae.field_unReadCount <= 0)) {
          break label682;
        }
        paramae = new SpannableStringBuilder(this.context.getString(R.l.eyJ));
        paramae.setSpan(new ForegroundColorSpan(-5569532), 0, paramae.length(), 33);
        paramae.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, str1, paramInt));
        GMTrace.o(3384836882432L, 25219);
        return paramae;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = com.tencent.mm.u.n.eK(paramae.field_digestUser);
      continue;
      localObject1 = paramae.field_digest;
      continue;
      label654:
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramae.field_isSend, paramae.field_username, paramae.field_content, k(paramae), this.context);
    }
    label682:
    Object localObject2 = str1;
    if (paramBoolean)
    {
      localObject2 = str1;
      if (paramae.field_unReadCount > 1) {
        localObject2 = this.context.getString(R.l.eyM, new Object[] { Integer.valueOf(paramae.field_unReadCount), str1 });
      }
    }
    paramae = com.tencent.mm.pluginsdk.ui.d.h.c(this.context, (CharSequence)localObject2, paramInt);
    GMTrace.o(3384836882432L, 25219);
    return paramae;
  }
  
  private CharSequence i(com.tencent.mm.storage.ae paramae)
  {
    GMTrace.i(3385105317888L, 25221);
    if (paramae.field_status == 1)
    {
      paramae = this.context.getString(R.l.ezg);
      GMTrace.o(3385105317888L, 25221);
      return paramae;
    }
    if (paramae.field_conversationTime == Long.MAX_VALUE)
    {
      GMTrace.o(3385105317888L, 25221);
      return "";
    }
    paramae = com.tencent.mm.pluginsdk.j.o.c(this.context, paramae.field_conversationTime, true);
    GMTrace.o(3385105317888L, 25221);
    return paramae;
  }
  
  private static int k(com.tencent.mm.storage.ae paramae)
  {
    int j = 1;
    GMTrace.i(3384702664704L, 25218);
    paramae = paramae.field_msgType;
    int i = j;
    if (paramae != null)
    {
      i = j;
      if (paramae.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramae).intValue();
      GMTrace.o(3384702664704L, 25218);
      return i;
    }
    catch (NumberFormatException paramae)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public final void OL()
  {
    GMTrace.i(3384434229248L, 25216);
    aEP();
    ap.yY();
    setCursor(com.tencent.mm.u.c.wW().c(com.tencent.mm.u.o.hkZ, null, this.fRk));
    if (this.uQY != null) {
      this.uQY.OI();
    }
    super.notifyDataSetChanged();
    GMTrace.o(3384434229248L, 25216);
  }
  
  protected final void OM()
  {
    GMTrace.i(3384300011520L, 25215);
    OL();
    GMTrace.o(3384300011520L, 25215);
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    GMTrace.i(3385373753344L, 25223);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      v.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      GMTrace.o(3385373753344L, 25223);
      return;
    }
    a((String)paramObject, null);
    GMTrace.o(3385373753344L, 25223);
  }
  
  public final void a(MMSlideDelView.c paramc)
  {
    GMTrace.i(3383897358336L, 25212);
    this.jUn = paramc;
    GMTrace.o(3383897358336L, 25212);
  }
  
  public final void a(MMSlideDelView.e parame)
  {
    GMTrace.i(3383763140608L, 25211);
    this.jUo = parame;
    GMTrace.o(3383763140608L, 25211);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    GMTrace.i(3383628922880L, 25210);
    this.jUm = paramf;
    GMTrace.o(3383628922880L, 25210);
  }
  
  public final void a(String paramString, l paraml)
  {
    GMTrace.i(3385507971072L, 25224);
    v.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.vZY), Boolean.valueOf(this.vZZ), paramString });
    if ((!com.tencent.mm.platformtools.u.mA(paramString)) && (this.vtF != null)) {
      this.vtF.remove(paramString);
    }
    if (this.vZY)
    {
      v.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.wal), Boolean.valueOf(this.wam.bJg()) });
      this.wal = true;
      if (this.wam.bJg()) {
        bYn();
      }
      GMTrace.o(3385507971072L, 25224);
      return;
    }
    this.vZZ = true;
    GMTrace.o(3385507971072L, 25224);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(3384568446976L, 25217);
    com.tencent.mm.storage.ae localae = (com.tencent.mm.storage.ae)getItem(paramInt);
    String str = localae.field_username;
    paramViewGroup = null;
    if (paramView != null) {
      paramViewGroup = (b)paramView.getTag();
    }
    if ((paramView == null) || (paramViewGroup == null))
    {
      paramViewGroup = new b();
      if (com.tencent.mm.bg.a.dM(this.context))
      {
        paramView = View.inflate(this.context, R.i.cZE, null);
        paramViewGroup.ipb = ((ImageView)paramView.findViewById(R.h.bqF));
        paramViewGroup.wbA = ((NoMeasuredTextView)paramView.findViewById(R.h.cnW));
        paramViewGroup.wbA.H(this.vtB);
        paramViewGroup.wbA.setTextColor(this.wbx[3]);
        paramViewGroup.wbA.vng = true;
        paramViewGroup.wbB = ((NoMeasuredTextView)paramView.findViewById(R.h.cKE));
        paramViewGroup.wbB.H(this.vtD);
        paramViewGroup.wbB.setTextColor(this.wbx[4]);
        paramViewGroup.wbB.vng = false;
        paramViewGroup.wbB.wa();
        paramViewGroup.wbC = ((NoMeasuredTextView)paramView.findViewById(R.h.cam));
        paramViewGroup.wbC.H(this.vtC);
        paramViewGroup.wbC.setTextColor(this.wbx[0]);
        paramViewGroup.wbC.vng = true;
        paramViewGroup.wbD = ((TextView)paramView.findViewById(R.h.cIC));
        paramViewGroup.wbD.setBackgroundResource(s.fg(this.context));
        paramViewGroup.vtM = ((ImageView)paramView.findViewById(R.h.bWW));
        paramViewGroup.vtO = paramView.findViewById(R.h.bqG);
        paramView.findViewById(R.h.cHr).setVisibility(8);
        paramView.findViewById(R.h.ccg).setVisibility(8);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      a locala = (a)this.vtF.get(str);
      ap.yY();
      Object localObject = com.tencent.mm.u.c.wR().Rb(str);
      label380:
      boolean bool;
      if (locala == null)
      {
        locala = new a();
        if (localObject != null)
        {
          locala.wat = ((int)((com.tencent.mm.j.a)localObject).gTG);
          if (localObject == null) {
            break label1103;
          }
          bool = true;
          label388:
          locala.way = bool;
          if ((localObject == null) || (!((x)localObject).tE())) {
            break label1109;
          }
          bool = true;
          label411:
          locala.waA = bool;
          if ((localObject == null) || (!((x)localObject).tD())) {
            break label1115;
          }
          bool = true;
          label434:
          locala.waw = bool;
          if (localae.field_unReadCount <= 0) {
            break label1121;
          }
          bool = true;
          label452:
          locala.wbz = bool;
          locala.klJ = 0;
          if ((k(localae) == 34) && (localae.field_isSend == 0) && (!com.tencent.mm.platformtools.u.mA(localae.field_content)) && (!new com.tencent.mm.modelvoice.n(localae.field_content).hZO)) {
            locala.klJ = 1;
          }
          locala.nickName = com.tencent.mm.pluginsdk.ui.d.h.b(this.context, com.tencent.mm.u.n.a((x)localObject, str, false), paramViewGroup.wbA.gm.getTextSize());
          locala.waq = i(localae);
          paramInt = (int)paramViewGroup.wbC.gm.getTextSize();
          if ((!locala.waw) || (!locala.wbz)) {
            break label1127;
          }
          bool = true;
          label590:
          locala.war = c(localae, paramInt, bool);
          locala.waB = localae.field_attrflag;
          switch (localae.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label658:
            locala.was = paramInt;
            ap.yY();
            locala.vtG = com.tencent.mm.u.c.wW().g(localae);
            locala.sDp = com.tencent.mm.sdk.platformtools.u.bIz();
            this.vtF.put(str, locala);
          }
        }
      }
      for (;;)
      {
        if (locala.waq == null) {
          locala.waq = i(localae);
        }
        if ((locala.waw) && (locala.wbz))
        {
          paramViewGroup.wbC.setTextColor(this.wbx[0]);
          label751:
          com.tencent.mm.booter.notification.a.h.dX(paramViewGroup.wbC.getWidth());
          com.tencent.mm.booter.notification.a.h.dY((int)paramViewGroup.wbC.gm.getTextSize());
          com.tencent.mm.booter.notification.a.h.a(paramViewGroup.wbC.gm);
          if (locala.was == -1) {
            break label1177;
          }
          paramViewGroup.wbC.Ai(locala.was);
          paramViewGroup.wbC.kS(true);
          label814:
          paramViewGroup.wbC.setText(locala.war);
          paramViewGroup.wbA.kT(false);
          paramViewGroup.wbA.setText(locala.nickName);
          localObject = paramViewGroup.wbB.getLayoutParams();
          if (locala.waq.length() <= 9) {
            break label1188;
          }
          if (((ViewGroup.LayoutParams)localObject).width != this.wai)
          {
            ((ViewGroup.LayoutParams)localObject).width = this.wai;
            paramViewGroup.wbB.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          label900:
          paramViewGroup.wbB.setText(locala.waq);
          if (!locala.waw) {
            break label1221;
          }
          paramViewGroup.vtM.setVisibility(0);
          label928:
          a.b.a(paramViewGroup.ipb, str);
          paramViewGroup.wbD.setVisibility(4);
          paramViewGroup.vtO.setVisibility(4);
          if ((locala.way) && (locala.wat != 0))
          {
            paramInt = localae.field_unReadCount;
            if (!locala.waw) {
              break label1238;
            }
            paramViewGroup = paramViewGroup.vtO;
            if (paramInt <= 0) {
              break label1233;
            }
            paramInt = 0;
            label994:
            paramViewGroup.setVisibility(paramInt);
          }
          label999:
          if ((!locala.vtG) || (localae.field_conversationTime == -1L)) {
            break label1291;
          }
          paramView.findViewById(R.h.bGC).setBackgroundResource(R.g.bem);
        }
        for (;;)
        {
          a.a.uVh.a(paramView, String.valueOf(locala.nickName), localae.field_unReadCount, String.valueOf(locala.waq), String.valueOf(locala.war));
          GMTrace.o(3384568446976L, 25217);
          return paramView;
          paramView = View.inflate(this.context, R.i.cZD, null);
          break;
          locala.wat = -1;
          break label380;
          label1103:
          bool = false;
          break label388;
          label1109:
          bool = false;
          break label411;
          label1115:
          bool = false;
          break label434;
          label1121:
          bool = false;
          break label452;
          label1127:
          bool = false;
          break label590;
          paramInt = -1;
          break label658;
          paramInt = R.k.dxE;
          break label658;
          paramInt = -1;
          break label658;
          paramInt = R.k.dxD;
          break label658;
          paramViewGroup.wbC.setTextColor(this.wbx[locala.klJ]);
          break label751;
          label1177:
          paramViewGroup.wbC.kS(false);
          break label814;
          label1188:
          if (((ViewGroup.LayoutParams)localObject).width == this.wah) {
            break label900;
          }
          ((ViewGroup.LayoutParams)localObject).width = this.wah;
          paramViewGroup.wbB.setLayoutParams((ViewGroup.LayoutParams)localObject);
          break label900;
          label1221:
          paramViewGroup.vtM.setVisibility(8);
          break label928;
          label1233:
          paramInt = 4;
          break label994;
          label1238:
          if (paramInt > 99)
          {
            paramViewGroup.wbD.setText(R.l.eYH);
            paramViewGroup.wbD.setVisibility(0);
            break label999;
          }
          if (paramInt <= 0) {
            break label999;
          }
          paramViewGroup.wbD.setText(String.valueOf(paramInt));
          paramViewGroup.wbD.setVisibility(0);
          break label999;
          label1291:
          paramView.findViewById(R.h.bGC).setBackgroundResource(R.g.ben);
        }
      }
    }
  }
  
  public final void onPause()
  {
    GMTrace.i(3384031576064L, 25213);
    if (this.jUp != null) {
      this.jUp.aFa();
    }
    this.vZY = false;
    GMTrace.o(3384031576064L, 25213);
  }
  
  public final void onResume()
  {
    int i = 1;
    GMTrace.i(3384165793792L, 25214);
    this.vZY = true;
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.j.n.a("MM/dd", (Time)localObject).toString();
    if (!this.waf.equals(localObject)) {}
    for (;;)
    {
      this.waf = ((String)localObject);
      if (i != 0) {
        bYm();
      }
      if (this.vZZ)
      {
        super.a(null, null);
        this.vZZ = false;
      }
      GMTrace.o(3384165793792L, 25214);
      return;
      i = 0;
    }
  }
  
  private final class a
  {
    public int klJ;
    public CharSequence nickName;
    public boolean sDp;
    public boolean vtG;
    public boolean waA;
    public int waB;
    public CharSequence waq;
    public CharSequence war;
    public int was;
    public int wat;
    public boolean waw;
    public boolean way;
    public boolean wbz;
    
    public a()
    {
      GMTrace.i(3376783818752L, 25159);
      GMTrace.o(3376783818752L, 25159);
    }
  }
  
  public static final class b
  {
    public ImageView ipb;
    public ImageView vtM;
    public View vtO;
    public NoMeasuredTextView wbA;
    public NoMeasuredTextView wbB;
    public NoMeasuredTextView wbC;
    public TextView wbD;
    
    public b()
    {
      GMTrace.i(3376649601024L, 25158);
      GMTrace.o(3376649601024L, 25158);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */