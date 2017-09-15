package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
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
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.qk.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.n;
import com.tencent.mm.pluginsdk.l.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bh;
import com.tencent.mm.u.bi;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class d
  extends k<com.tencent.mm.storage.ae>
  implements m.b
{
  private static long wak;
  private String isc;
  protected MMSlideDelView.f jUm;
  protected MMSlideDelView.c jUn;
  protected MMSlideDelView.e jUo;
  protected MMSlideDelView.d jUp;
  protected List<String> jzO;
  private boolean ngn;
  boolean qrV;
  private boolean vZV;
  private f vZW;
  private com.tencent.mm.pluginsdk.ui.d vZX;
  private boolean vZY;
  private boolean vZZ;
  private float vtB;
  protected float vtC;
  private float vtD;
  private ColorStateList[] vtE;
  HashMap<String, d> vtF;
  private boolean waa;
  private boolean wab;
  private c wac;
  private com.tencent.mm.sdk.b.c wad;
  private b wae;
  public String waf;
  final e wag;
  private final int wah;
  private final int wai;
  private a waj;
  private boolean wal;
  private ai wam;
  
  static
  {
    GMTrace.i(3414364782592L, 25439);
    wak = 2000L;
    GMTrace.o(3414364782592L, 25439);
  }
  
  public d(Context paramContext, k.a parama)
  {
    super(paramContext, new com.tencent.mm.storage.ae());
    GMTrace.i(3410204033024L, 25408);
    this.jzO = null;
    this.vtE = new ColorStateList[5];
    this.vZV = true;
    this.ngn = false;
    this.jUp = MMSlideDelView.bSe();
    this.vtB = -1.0F;
    this.vtC = -1.0F;
    this.vtD = -1.0F;
    this.vZY = false;
    this.vZZ = false;
    this.waa = false;
    this.wab = false;
    this.wad = null;
    this.wae = null;
    this.waf = "";
    this.wag = new e();
    this.qrV = false;
    this.wal = false;
    this.wam = new ai(ap.vL().nIe.getLooper(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(3421880975360L, 25495);
        if (d.d(d.this)) {
          d.e(d.this);
        }
        GMTrace.o(3421880975360L, 25495);
        return false;
      }
    }, false);
    this.uQY = parama;
    this.vtE[0] = com.tencent.mm.bg.a.S(paramContext, R.e.aUo);
    this.vtE[1] = com.tencent.mm.bg.a.S(paramContext, R.e.aVe);
    this.vtE[3] = com.tencent.mm.bg.a.S(paramContext, R.e.aVo);
    this.vtE[2] = com.tencent.mm.bg.a.S(paramContext, R.e.aVc);
    this.vtE[2] = com.tencent.mm.bg.a.S(paramContext, R.e.aVc);
    this.vtE[4] = com.tencent.mm.bg.a.S(paramContext, R.e.aUy);
    this.vtF = new HashMap();
    if (com.tencent.mm.bg.a.dM(paramContext)) {
      this.wai = paramContext.getResources().getDimensionPixelSize(R.f.aWN);
    }
    for (this.wah = paramContext.getResources().getDimensionPixelSize(R.f.aWO);; this.wah = paramContext.getResources().getDimensionPixelSize(R.f.aWP))
    {
      this.vtB = com.tencent.mm.bg.a.T(paramContext, R.f.aXH);
      this.vtC = com.tencent.mm.bg.a.T(paramContext, R.f.aXr);
      this.vtD = com.tencent.mm.bg.a.T(paramContext, R.f.aXV);
      GMTrace.o(3410204033024L, 25408);
      return;
      this.wai = paramContext.getResources().getDimensionPixelSize(R.f.aWM);
    }
  }
  
  private static String Ti(String paramString)
  {
    GMTrace.i(3412351516672L, 25424);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ua(paramString);
      GMTrace.o(3412351516672L, 25424);
      return paramString;
    }
    GMTrace.o(3412351516672L, 25424);
    return null;
  }
  
  private CharSequence a(com.tencent.mm.storage.ae paramae, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(3412217298944L, 25423);
    if ((!com.tencent.mm.platformtools.u.mA(paramae.field_editingMsg)) && ((paramae.field_atCount <= 0) || (paramae.field_unReadCount <= 0)))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.eyN));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, paramae.field_editingMsg, paramInt));
      GMTrace.o(3412217298944L, 25423);
      return (CharSequence)localObject1;
    }
    Object localObject1 = paramae.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramae = new SpannableString(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, (CharSequence)localObject1, paramInt));
      GMTrace.o(3412217298944L, 25423);
      return paramae;
    }
    localObject1 = paramae.field_username;
    int i;
    if (((String)localObject1).equals("qqmail"))
    {
      ap.yY();
      if (com.tencent.mm.platformtools.u.f((Integer)com.tencent.mm.u.c.vr().get(17, null)) == 1) {}
      for (i = 1; i == 0; i = 0)
      {
        paramae = this.context.getString(R.l.eTq);
        GMTrace.o(3412217298944L, 25423);
        return paramae;
      }
    }
    if (((String)localObject1).equals("tmessage"))
    {
      ap.yY();
      localObject1 = com.tencent.mm.u.c.wZ().AF("@t.qq.com");
      if ((localObject1 != null) && (((ay)localObject1).isEnable())) {}
      for (i = 1; i == 0; i = 0)
      {
        paramae = this.context.getString(R.l.eTq);
        GMTrace.o(3412217298944L, 25423);
        return paramae;
      }
    }
    String str1;
    if ((paramae.field_msgType != null) && ((paramae.field_msgType.equals("47")) || (paramae.field_msgType.equals("1048625"))))
    {
      localObject1 = Ti(paramae.field_digest);
      str1 = "";
      if (localObject1 != null)
      {
        paramae = "[" + (String)localObject1 + "]";
        GMTrace.o(3412217298944L, 25423);
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
              GMTrace.o(3412217298944L, 25423);
              return paramae;
            }
            paramae = str1 + ": " + paramae;
            GMTrace.o(3412217298944L, 25423);
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
        break label821;
      }
      if (com.tencent.mm.platformtools.u.mA(paramae.field_digestUser)) {
        break label810;
      }
      if ((paramae.field_isSend != 0) || (!com.tencent.mm.u.o.dH(paramae.field_username))) {
        break label798;
      }
      localObject1 = com.tencent.mm.u.n.E(paramae.field_digestUser, paramae.field_username);
    }
    label798:
    label810:
    label821:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramae.field_digest, new Object[] { localObject1 });
        str1 = ((String)localObject1).replace('\n', ' ');
        if ((paramae.field_atCount <= 0) || (paramae.field_unReadCount <= 0)) {
          break label852;
        }
        paramae = new SpannableStringBuilder(this.context.getString(R.l.eyJ));
        paramae.setSpan(new ForegroundColorSpan(-5569532), 0, paramae.length(), 33);
        paramae.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, str1, paramInt));
        GMTrace.o(3412217298944L, 25423);
        return paramae;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + str1;
      break;
      localObject1 = com.tencent.mm.u.n.eK(paramae.field_digestUser);
      continue;
      localObject1 = paramae.field_digest;
      continue;
      localObject2 = com.tencent.mm.booter.notification.a.h.a(paramae.field_isSend, paramae.field_username, paramae.field_content, rV(paramae.field_msgType), this.context);
    }
    label852:
    if ((paramBoolean) && (paramae.field_unReadCount > 1)) {
      localObject2 = this.context.getString(R.l.eyM, new Object[] { Integer.valueOf(paramae.field_unReadCount), str1 });
    }
    for (;;)
    {
      paramae = com.tencent.mm.pluginsdk.ui.d.h.c(this.context, (CharSequence)localObject2, paramInt);
      GMTrace.o(3412217298944L, 25423);
      return paramae;
      localObject2 = str1;
      if (paramae.field_unReadCount > 1)
      {
        localObject2 = str1;
        if (com.tencent.mm.u.o.fu(paramae.field_parentRef)) {
          localObject2 = this.context.getString(R.l.eyM, new Object[] { Integer.valueOf(paramae.field_unReadCount), str1 });
        }
      }
    }
  }
  
  private void bYm()
  {
    GMTrace.i(3411277774848L, 25416);
    if (this.vtF == null)
    {
      GMTrace.o(3411277774848L, 25416);
      return;
    }
    Iterator localIterator = this.vtF.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).waq = null;
    }
    GMTrace.o(3411277774848L, 25416);
  }
  
  private void bYn()
  {
    GMTrace.i(3412754169856L, 25427);
    com.tencent.mm.sdk.platformtools.ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3421075668992L, 25489);
        if (!ap.zb())
        {
          d.f(d.this).KI();
          v.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
          GMTrace.o(3421075668992L, 25489);
          return;
        }
        long l = com.tencent.mm.platformtools.u.NA();
        d.g(d.this);
        l = com.tencent.mm.platformtools.u.aA(l) * 3L;
        v.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", new Object[] { Long.valueOf(l), Long.valueOf(d.bYo()), Boolean.valueOf(d.d(d.this)) });
        d.eV((l + d.bYo()) / 2L);
        d.h(d.this);
        ai localai = d.f(d.this);
        l = d.bYo();
        localai.v(l, l);
        GMTrace.o(3421075668992L, 25489);
      }
    });
    GMTrace.o(3412754169856L, 25427);
  }
  
  private CharSequence i(com.tencent.mm.storage.ae paramae)
  {
    GMTrace.i(3410875121664L, 25413);
    if (paramae.field_status == 1)
    {
      paramae = this.context.getString(R.l.ezg);
      GMTrace.o(3410875121664L, 25413);
      return paramae;
    }
    if (paramae.field_conversationTime == Long.MAX_VALUE)
    {
      GMTrace.o(3410875121664L, 25413);
      return "";
    }
    paramae = com.tencent.mm.pluginsdk.j.o.c(this.context, paramae.field_conversationTime, true);
    GMTrace.o(3410875121664L, 25413);
    return paramae;
  }
  
  private static int rV(String paramString)
  {
    int j = 1;
    GMTrace.i(3412083081216L, 25422);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      GMTrace.o(3412083081216L, 25422);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public void OL()
  {
    GMTrace.i(3411680428032L, 25419);
    v.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", new Object[] { Boolean.valueOf(this.ngn) });
    if (this.ngn)
    {
      Cursor[] arrayOfCursor = new Cursor[2];
      arrayOfCursor[0] = ap.yY().hks.a(com.tencent.mm.u.o.hkZ, this.jzO, this.isc);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.jzO != null) && (this.jzO.size() > 0)) {
        localArrayList1.addAll(this.jzO);
      }
      try
      {
        while (arrayOfCursor[0].moveToNext())
        {
          String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
          localArrayList1.add(str);
          if (!str.endsWith("@chatroom")) {
            localArrayList2.add(str);
          }
          v.d("MicroMsg.ConversationAdapter", "block user " + str);
        }
        if (this.vZW == null) {}
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.ConversationAdapter", localException, "", new Object[0]);
        localArrayList1.add("officialaccounts");
        localArrayList1.add("helper_entry");
        arrayOfCursor[1] = ap.yY().hkt.b(this.isc, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
        setCursor(new MergeCursor(arrayOfCursor));
      }
    }
    for (;;)
    {
      if (this.isc != null) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      GMTrace.o(3411680428032L, 25419);
      return;
      ap.yY();
      setCursor(com.tencent.mm.u.c.wW().a(com.tencent.mm.u.o.hkZ, this.jzO, com.tencent.mm.k.a.gTI, false));
    }
  }
  
  protected final void OM()
  {
    GMTrace.i(3411009339392L, 25414);
    OL();
    GMTrace.o(3411009339392L, 25414);
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    GMTrace.i(3412485734400L, 25425);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      v.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      GMTrace.o(3412485734400L, 25425);
      return;
    }
    a((String)paramObject, null);
    GMTrace.o(3412485734400L, 25425);
  }
  
  public final void a(MMSlideDelView.c paramc)
  {
    GMTrace.i(3410606686208L, 25411);
    this.jUn = paramc;
    GMTrace.o(3410606686208L, 25411);
  }
  
  public final void a(MMSlideDelView.e parame)
  {
    GMTrace.i(3410472468480L, 25410);
    this.jUo = parame;
    GMTrace.o(3410472468480L, 25410);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    GMTrace.i(3410338250752L, 25409);
    this.jUm = paramf;
    GMTrace.o(3410338250752L, 25409);
  }
  
  public final void a(String paramString, l paraml)
  {
    GMTrace.i(3412619952128L, 25426);
    v.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", new Object[] { Boolean.valueOf(this.vZY), Boolean.valueOf(this.vZZ), paramString });
    if ((!com.tencent.mm.platformtools.u.mA(paramString)) && (this.vtF != null)) {
      this.vtF.remove(paramString);
    }
    if (this.vZY)
    {
      v.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", new Object[] { Boolean.valueOf(this.wal), Boolean.valueOf(this.wam.bJg()) });
      this.wal = true;
      if (this.wam.bJg()) {
        bYn();
      }
      GMTrace.o(3412619952128L, 25426);
      return;
    }
    this.vZZ = true;
    GMTrace.o(3412619952128L, 25426);
  }
  
  protected void a(String paramString, g paramg)
  {
    GMTrace.i(3411948863488L, 25421);
    GMTrace.o(3411948863488L, 25421);
  }
  
  public void detach()
  {
    GMTrace.i(3410740903936L, 25412);
    GMTrace.o(3410740903936L, 25412);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(3411814645760L, 25420);
    com.tencent.mm.storage.ae localae = (com.tencent.mm.storage.ae)getItem(paramInt);
    String str = localae.field_username;
    paramViewGroup = this.wag;
    paramViewGroup.fJC = str;
    paramViewGroup.jht = null;
    paramViewGroup.waC = null;
    paramViewGroup.gUE = false;
    if (!com.tencent.mm.platformtools.u.mA(str)) {
      paramViewGroup.gUE = true;
    }
    this.waj = new a();
    Object localObject1;
    label439:
    Object localObject2;
    x localx;
    label549:
    boolean bool;
    label557:
    label580:
    label603:
    label647:
    Object localObject3;
    if (paramView == null)
    {
      paramViewGroup = new g();
      if (com.tencent.mm.bg.a.dM(this.context))
      {
        paramView = View.inflate(this.context, R.i.cZE, null);
        paramViewGroup.ipb = ((ImageView)paramView.findViewById(R.h.bqF));
        a.b.a(paramViewGroup.ipb, str);
        localObject1 = (com.tencent.mm.pluginsdk.ui.a)paramViewGroup.ipb.getDrawable();
        if (this.vZX != null) {
          this.vZX.a((com.tencent.mm.pluginsdk.ui.d.a)localObject1);
        }
        paramViewGroup.vtJ = ((NoMeasuredTextView)paramView.findViewById(R.h.cnW));
        paramViewGroup.waD = ((NoMeasuredTextView)paramView.findViewById(R.h.cFT));
        paramViewGroup.vtK = ((NoMeasuredTextView)paramView.findViewById(R.h.cKE));
        paramViewGroup.vtL = ((NoMeasuredTextView)paramView.findViewById(R.h.cam));
        paramViewGroup.jUv = ((TextView)paramView.findViewById(R.h.cIC));
        paramViewGroup.jUv.setBackgroundResource(s.fg(this.context));
        paramViewGroup.vtM = ((ImageView)paramView.findViewById(R.h.bWW));
        paramViewGroup.vtO = paramView.findViewById(R.h.bqG);
        paramViewGroup.vtN = ((ImageView)paramView.findViewById(R.h.cHr));
        paramViewGroup.waE = ((ImageView)paramView.findViewById(R.h.ccg));
        paramView.setTag(paramViewGroup);
        paramViewGroup.vtL.H(this.vtC);
        paramViewGroup.vtK.H(this.vtD);
        paramViewGroup.vtJ.H(this.vtB);
        paramViewGroup.waD.H(this.vtC);
        paramViewGroup.vtL.setTextColor(this.vtE[0]);
        paramViewGroup.vtK.setTextColor(this.vtE[4]);
        paramViewGroup.vtJ.setTextColor(this.vtE[3]);
        paramViewGroup.waD.setTextColor(this.vtE[0]);
        paramViewGroup.vtL.vng = true;
        paramViewGroup.vtK.vng = false;
        paramViewGroup.vtJ.vng = true;
        paramViewGroup.waD.vng = true;
        paramViewGroup.vtK.wa();
        localObject2 = (d)this.vtF.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = new d();
          localObject1 = this.wag;
          if ((((e)localObject1).gUE) && (((e)localObject1).jht == null))
          {
            ap.yY();
            ((e)localObject1).jht = com.tencent.mm.u.c.wR().Rb(((e)localObject1).fJC);
          }
          localx = ((e)localObject1).jht;
          if (localx == null) {
            break label1723;
          }
          ((d)localObject2).wau = localx.gkz;
          ((d)localObject2).wat = ((int)localx.gTG);
          if (localx == null) {
            break label1738;
          }
          bool = true;
          ((d)localObject2).way = bool;
          if ((localx == null) || (!localx.tE())) {
            break label1744;
          }
          bool = true;
          ((d)localObject2).waA = bool;
          if ((localx == null) || (localx.gkp != 0)) {
            break label1750;
          }
          bool = true;
          ((d)localObject2).waz = bool;
          ((d)localObject2).vAw = com.tencent.mm.u.o.dH(str);
          if ((!((d)localObject2).vAw) || (!((d)localObject2).waz) || (localae.field_unReadCount <= 0)) {
            break label1756;
          }
          bool = true;
          ((d)localObject2).wax = bool;
          ((d)localObject2).klJ = 0;
          if ((rV(localae.field_msgType) == 34) && (localae.field_isSend == 0) && (!com.tencent.mm.platformtools.u.mA(localae.field_content)))
          {
            localObject3 = localae.field_content;
            if (!str.equals("qmessage"))
            {
              localObject1 = localObject3;
              if (!str.equals("floatbottle")) {}
            }
            else
            {
              String[] arrayOfString = ((String)localObject3).split(":");
              localObject1 = localObject3;
              if (arrayOfString != null)
              {
                localObject1 = localObject3;
                if (arrayOfString.length > 3) {
                  localObject1 = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
                }
              }
            }
            if (!new com.tencent.mm.modelvoice.n((String)localObject1).hZO) {
              ((d)localObject2).klJ = 1;
            }
          }
          localObject1 = com.tencent.mm.u.n.a(localx, str, ((d)localObject2).vAw);
          if ((!((d)localObject2).vAw) || (localObject1 != null)) {
            break label1762;
          }
          ((d)localObject2).nickName = this.context.getString(R.l.dVj);
          label863:
          ((d)localObject2).waq = i(localae);
          ((d)localObject2).war = a(localae, (int)paramViewGroup.vtL.gm.getTextSize(), ((d)localObject2).wax);
          ((d)localObject2).waB = localae.field_attrflag;
        }
        switch (localae.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label958:
          ((d)localObject2).was = paramInt;
          ((d)localObject2).wav = com.tencent.mm.u.o.a(localae);
          ap.yY();
          ((d)localObject2).vtG = com.tencent.mm.u.c.wW().g(localae);
          if ((localx != null) && (localx.tD()))
          {
            bool = true;
            label1009:
            ((d)localObject2).waw = bool;
            ((d)localObject2).sDp = com.tencent.mm.sdk.platformtools.u.bIz();
            this.vtF.put(str, localObject2);
            localObject1 = localObject2;
            if (((d)localObject1).waq == null) {
              ((d)localObject1).waq = i(localae);
            }
            if ((!((d)localObject1).wax) && (!com.tencent.mm.u.o.fu(localae.field_parentRef))) {
              break label1829;
            }
            paramViewGroup.vtL.setTextColor(this.vtE[0]);
            label1091:
            com.tencent.mm.booter.notification.a.h.dX(paramViewGroup.vtL.getWidth());
            com.tencent.mm.booter.notification.a.h.dY((int)paramViewGroup.vtL.gm.getTextSize());
            com.tencent.mm.booter.notification.a.h.a(paramViewGroup.vtL.gm);
            if (!str.toLowerCase().endsWith("@t.qq.com")) {
              break label1849;
            }
            paramViewGroup.vtJ.Aj(R.g.bfP);
            paramViewGroup.vtJ.kT(true);
            label1157:
            paramInt = ((d)localObject1).was;
            if (paramInt == -1) {
              break label1860;
            }
            paramViewGroup.vtL.Ai(paramInt);
            paramViewGroup.vtL.kS(true);
            label1184:
            paramViewGroup.vtJ.setText(((d)localObject1).nickName);
            paramViewGroup.waD.setVisibility(8);
            localObject2 = paramViewGroup.vtK.getLayoutParams();
            if (((d)localObject1).waq.length() <= 9) {
              break label1871;
            }
            if (((ViewGroup.LayoutParams)localObject2).width != this.wai)
            {
              ((ViewGroup.LayoutParams)localObject2).width = this.wai;
              paramViewGroup.vtK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            }
            label1259:
            v.v("MicroMsg.ConversationAdapter", "layout update time width %d", new Object[] { Integer.valueOf(((ViewGroup.LayoutParams)localObject2).width) });
            paramViewGroup.vtK.setText(((d)localObject1).waq);
            paramViewGroup.vtL.setText(((d)localObject1).war);
            if ((!((d)localObject1).vAw) || (!((d)localObject1).waz)) {
              break label1904;
            }
            paramViewGroup.vtM.setVisibility(0);
            label1331:
            a.b.a(paramViewGroup.ipb, str);
            if (this.vZV)
            {
              if ((localae != null) && (paramViewGroup != null) && (localObject1 != null)) {
                break label1935;
              }
              v.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
            }
            if ((!((d)localObject1).wav) && (((d)localObject1).vtG) && (ap.zb()))
            {
              ap.yY();
              com.tencent.mm.u.c.wW().f(localae);
            }
            if ((!((d)localObject1).vtG) || (localae.field_conversationTime == -1L)) {
              break label2296;
            }
            paramView.findViewById(R.h.bGC).setBackgroundResource(R.g.bem);
            label1440:
            com.tencent.mm.bb.d.bGH();
            localObject2 = new qk();
            ((qk)localObject2).fXk.fXm = true;
            com.tencent.mm.sdk.b.a.uql.m((b)localObject2);
            if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localae, 7, 0L)) && (!localae.field_username.equals(((qk)localObject2).fXl.fXo)))
            {
              localae.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localae, 6, localae.field_conversationTime));
              ap.yY();
              com.tencent.mm.u.c.wW().a(localae, localae.field_username);
            }
            if ((l.a.szL != null) && (l.a.szL.Hp(localae.field_username))) {
              break label2312;
            }
            paramViewGroup.vtN.setVisibility(8);
            label1571:
            if ((l.a.szS == null) || (!l.a.szS.zq(localae.field_username))) {
              break label2365;
            }
            paramViewGroup.waE.setVisibility(0);
          }
          break;
        }
      }
    }
    for (;;)
    {
      this.waj.content = String.valueOf(((d)localObject1).war);
      this.waj.aIO = String.valueOf(((d)localObject1).nickName);
      this.waj.wap = String.valueOf(((d)localObject1).waq);
      localObject1 = this.waj;
      a.a.uVh.a(paramView, ((a)localObject1).aIO, ((a)localObject1).wao, ((a)localObject1).wap, ((a)localObject1).content);
      a(str, paramViewGroup);
      GMTrace.o(3411814645760L, 25420);
      return paramView;
      paramView = View.inflate(this.context, R.i.cZD, null);
      break;
      paramViewGroup = (g)paramView.getTag();
      break label439;
      label1723:
      ((d)localObject2).wau = -1;
      ((d)localObject2).wat = -1;
      break label549;
      label1738:
      bool = false;
      break label557;
      label1744:
      bool = false;
      break label580;
      label1750:
      bool = false;
      break label603;
      label1756:
      bool = false;
      break label647;
      label1762:
      ((d)localObject2).nickName = com.tencent.mm.pluginsdk.ui.d.h.b(this.context, com.tencent.mm.u.n.a(localx, str, ((d)localObject2).vAw), paramViewGroup.vtJ.gm.getTextSize());
      break label863;
      paramInt = -1;
      break label958;
      paramInt = R.k.dxE;
      break label958;
      paramInt = -1;
      break label958;
      paramInt = R.k.dxD;
      break label958;
      bool = false;
      break label1009;
      label1829:
      paramViewGroup.vtL.setTextColor(this.vtE[localObject1.klJ]);
      break label1091;
      label1849:
      paramViewGroup.vtJ.kT(false);
      break label1157;
      label1860:
      paramViewGroup.vtL.kS(false);
      break label1184;
      label1871:
      if (((ViewGroup.LayoutParams)localObject2).width == this.wah) {
        break label1259;
      }
      ((ViewGroup.LayoutParams)localObject2).width = this.wah;
      paramViewGroup.vtK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label1259;
      label1904:
      if (((d)localObject1).waw)
      {
        paramViewGroup.vtM.setVisibility(0);
        break label1331;
      }
      paramViewGroup.vtM.setVisibility(8);
      break label1331;
      label1935:
      paramViewGroup.jUv.setVisibility(4);
      paramViewGroup.vtO.setVisibility(4);
      if (com.tencent.mm.u.o.fu(localae.field_username))
      {
        localObject2 = paramViewGroup.vtO;
        if (localae.field_unReadCount > 0) {}
        for (paramInt = 0;; paramInt = 4)
        {
          ((View)localObject2).setVisibility(paramInt);
          paramViewGroup.vtJ.setTextColor(this.vtE[3]);
          break;
        }
      }
      localObject3 = paramViewGroup.vtJ;
      if ((((d)localObject1).way) && (((d)localObject1).wau == 1)) {}
      for (localObject2 = this.vtE[2];; localObject2 = this.vtE[3])
      {
        ((NoMeasuredTextView)localObject3).setTextColor((ColorStateList)localObject2);
        if ((((d)localObject1).way) && (((d)localObject1).wat != 0)) {
          break label2082;
        }
        v.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
        break;
      }
      label2082:
      if (com.tencent.mm.u.o.fu(localae.field_parentRef))
      {
        localObject2 = paramViewGroup.vtO;
        if (localae.field_unReadCount > 0) {}
        for (paramInt = 0;; paramInt = 4)
        {
          ((View)localObject2).setVisibility(paramInt);
          break;
        }
      }
      if ((((d)localObject1).waw) && (((d)localObject1).waA))
      {
        localObject2 = paramViewGroup.vtO;
        if (localae.field_unReadCount > 0) {}
        for (paramInt = 0;; paramInt = 4)
        {
          ((View)localObject2).setVisibility(paramInt);
          break;
        }
      }
      if ((((d)localObject1).vAw) && (((d)localObject1).waz))
      {
        localObject2 = paramViewGroup.vtO;
        if (localae.field_unReadCount > 0) {}
        for (paramInt = 0;; paramInt = 4)
        {
          ((View)localObject2).setVisibility(paramInt);
          break;
        }
      }
      paramInt = localae.field_unReadCount;
      if (paramInt > 99)
      {
        paramViewGroup.jUv.setText(R.l.eYH);
        paramViewGroup.jUv.setVisibility(0);
      }
      for (;;)
      {
        this.waj.wao = paramInt;
        break;
        if (paramInt > 0)
        {
          paramViewGroup.jUv.setText(localae.field_unReadCount);
          paramViewGroup.jUv.setVisibility(0);
        }
      }
      label2296:
      paramView.findViewById(R.h.bGC).setBackgroundResource(R.g.ben);
      break label1440;
      label2312:
      paramViewGroup.vtN.setVisibility(0);
      if (localae.field_username.equals(((qk)localObject2).fXl.fXo))
      {
        paramViewGroup.vtN.setImageResource(R.k.dzH);
        break label1571;
      }
      paramViewGroup.vtN.setImageResource(R.k.dzG);
      break label1571;
      label2365:
      paramViewGroup.waE.setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    GMTrace.i(3411546210304L, 25418);
    this.wam.KI();
    this.wae = null;
    this.wac = null;
    if (this.vtF != null)
    {
      this.vtF.clear();
      this.vtF = null;
    }
    aEP();
    this.uQY = null;
    detach();
    GMTrace.o(3411546210304L, 25418);
  }
  
  public final void onPause()
  {
    GMTrace.i(3411143557120L, 25415);
    if (this.jUp != null) {
      this.jUp.aFa();
    }
    this.vZY = false;
    GMTrace.o(3411143557120L, 25415);
  }
  
  public final void onResume()
  {
    int i = 1;
    GMTrace.i(3411411992576L, 25417);
    v.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", new Object[] { Boolean.valueOf(this.vZY), Boolean.valueOf(this.waa), Boolean.valueOf(this.vZZ), Boolean.valueOf(this.wab) });
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
      if ((this.waa) && (this.wae != null)) {
        this.waa = false;
      }
      if ((this.vZZ) || (this.wab))
      {
        super.a(null, null);
        this.vZZ = false;
        this.wab = false;
      }
      GMTrace.o(3411411992576L, 25417);
      return;
      i = 0;
    }
  }
  
  private final class a
  {
    public String aIO;
    public String content;
    public int wao;
    public String wap;
    
    public a()
    {
      GMTrace.i(3422015193088L, 25496);
      GMTrace.o(3422015193088L, 25496);
    }
  }
  
  public static abstract interface b {}
  
  private final class c
    implements m.b
  {
    public final void a(int paramInt, m paramm, Object paramObject)
    {
      GMTrace.i(3430202474496L, 25557);
      if ((paramObject == null) || (!(paramObject instanceof String)))
      {
        v.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
        GMTrace.o(3430202474496L, 25557);
        return;
      }
      paramm = (String)paramObject;
      if (d.a(this.wan))
      {
        GMTrace.o(3430202474496L, 25557);
        return;
      }
      if ((paramm != null) && (!paramm.equals("")) && (d.b(this.wan) != null) && (d.b(this.wan).containsKey(Integer.valueOf(paramInt))))
      {
        d.b(this.wan).remove(Integer.valueOf(paramInt));
        d.c(this.wan);
      }
      GMTrace.o(3430202474496L, 25557);
    }
  }
  
  private final class d
  {
    public int klJ;
    public CharSequence nickName;
    public boolean sDp;
    public boolean vAw;
    public boolean vtG;
    public boolean waA;
    public int waB;
    public CharSequence waq;
    public CharSequence war;
    public int was;
    public int wat;
    public int wau;
    public boolean wav;
    public boolean waw;
    public boolean wax;
    public boolean way;
    public boolean waz;
    
    public d()
    {
      GMTrace.i(3415841177600L, 25450);
      GMTrace.o(3415841177600L, 25450);
    }
  }
  
  private final class e
  {
    String fJC;
    boolean gUE;
    x jht;
    Integer waC;
    
    public e()
    {
      GMTrace.i(3372891504640L, 25130);
      this.gUE = false;
      this.fJC = null;
      this.gUE = false;
      this.jht = null;
      this.waC = null;
      GMTrace.o(3372891504640L, 25130);
    }
  }
  
  public static abstract interface f {}
  
  public static final class g
  {
    public ImageView ipb;
    public TextView jUv;
    public NoMeasuredTextView vtJ;
    public NoMeasuredTextView vtK;
    public NoMeasuredTextView vtL;
    public ImageView vtM;
    public ImageView vtN;
    public View vtO;
    public NoMeasuredTextView waD;
    public ImageView waE;
    
    public g()
    {
      GMTrace.i(3428860297216L, 25547);
      GMTrace.o(3428860297216L, 25547);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */