package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
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
import com.tencent.mm.e.a.z;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.h;
import com.tencent.mm.pluginsdk.l.n;
import com.tencent.mm.pluginsdk.l.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.a;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.t.j;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class g
  extends com.tencent.mm.ui.e<String, ae>
  implements m.b
{
  protected MMSlideDelView.f jUm;
  protected MMSlideDelView.c jUn;
  protected MMSlideDelView.d jUp;
  protected List<String> jzO;
  boolean ndm;
  private boolean ngn;
  boolean qrV;
  public boolean vHC;
  private boolean vZV;
  com.tencent.mm.pluginsdk.ui.d vZX;
  private float vtB;
  private float vtC;
  private float vtD;
  private ColorStateList[] vtE;
  HashMap<String, d> vtF;
  private boolean waW;
  private qk waX;
  b waY;
  private HashSet<String> waZ;
  private boolean waa;
  com.tencent.mm.sdk.b.c wad;
  public String waf;
  private final int wah;
  private final int wai;
  private boolean wba;
  HashMap<String, Integer> wbb;
  boolean wbc;
  HashSet<String> wbd;
  boolean wbe;
  private boolean wbf;
  public String wbg;
  final e wbh;
  private float wbi;
  private a wbj;
  private long wbk;
  
  public g(Context paramContext, e.a parama)
  {
    super(paramContext, (byte)0);
    GMTrace.i(3397587566592L, 25314);
    this.jzO = null;
    this.vtE = new ColorStateList[5];
    this.vZV = true;
    this.waW = false;
    this.jUp = MMSlideDelView.bSe();
    this.waX = null;
    this.ngn = false;
    this.vtB = -1.0F;
    this.vtC = -1.0F;
    this.vtD = -1.0F;
    this.waa = false;
    this.wad = null;
    this.waY = null;
    this.vHC = false;
    this.wba = false;
    this.wbb = new HashMap();
    this.wbc = false;
    this.wbe = false;
    this.wbf = false;
    this.waf = "";
    this.wbg = "";
    this.wbh = new e();
    this.qrV = false;
    this.wbi = -1.0F;
    this.wbk = 0L;
    this.ndm = false;
    this.TAG = "MicroMsg.ConversationWithCacheAdapter";
    super.a(parama);
    this.vtE[0] = com.tencent.mm.bg.a.S(paramContext, R.e.aUo);
    this.vtE[1] = com.tencent.mm.bg.a.S(paramContext, R.e.aVe);
    this.vtE[3] = com.tencent.mm.bg.a.S(paramContext, R.e.aVo);
    this.vtE[2] = com.tencent.mm.bg.a.S(paramContext, R.e.aVc);
    this.vtE[2] = com.tencent.mm.bg.a.S(paramContext, R.e.aVc);
    this.vtE[4] = com.tencent.mm.bg.a.S(paramContext, R.e.aUy);
    if (com.tencent.mm.bg.a.dM(paramContext)) {
      this.wai = paramContext.getResources().getDimensionPixelSize(R.f.aWN);
    }
    for (this.wah = paramContext.getResources().getDimensionPixelSize(R.f.aWO);; this.wah = paramContext.getResources().getDimensionPixelSize(R.f.aWP))
    {
      this.vtF = new HashMap();
      this.waZ = new HashSet();
      this.wbd = new HashSet();
      this.vtB = paramContext.getResources().getDimension(R.f.aXH);
      this.vtC = paramContext.getResources().getDimension(R.f.aXr);
      this.vtD = paramContext.getResources().getDimension(R.f.aXV);
      this.jzO = new ArrayList();
      this.jzO.add("qmessage");
      GMTrace.o(3397587566592L, 25314);
      return;
      this.wai = paramContext.getResources().getDimensionPixelSize(R.f.aWM);
    }
  }
  
  private static String Ti(String paramString)
  {
    GMTrace.i(3399869267968L, 25331);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ua(paramString);
      GMTrace.o(3399869267968L, 25331);
      return paramString;
    }
    GMTrace.o(3399869267968L, 25331);
    return null;
  }
  
  static int a(ae paramae, d paramd)
  {
    GMTrace.i(3399332397056L, 25327);
    if ((paramae == null) || (paramae.field_unReadCount <= 0))
    {
      if ((paramae != null) && ((paramae.eC(8388608)) || (paramae.eC(2097152))) && (paramae != null) && (paramae.field_unReadMuteCount > 0))
      {
        GMTrace.o(3399332397056L, 25327);
        return 1;
      }
      GMTrace.o(3399332397056L, 25327);
      return 0;
    }
    if (com.tencent.mm.u.o.fu(paramae.field_username))
    {
      GMTrace.o(3399332397056L, 25327);
      return 1;
    }
    if (com.tencent.mm.u.o.fz(paramae.field_username))
    {
      ap.yY();
      if (!com.tencent.mm.u.c.vr().c(w.a.uCW, true))
      {
        GMTrace.o(3399332397056L, 25327);
        return 1;
      }
    }
    if (com.tencent.mm.u.o.fD(paramae.field_username))
    {
      ap.yY();
      if (!com.tencent.mm.u.c.vr().c(w.a.uCX, true))
      {
        GMTrace.o(3399332397056L, 25327);
        return 1;
      }
    }
    if ((paramd.waw) && (paramd.waA))
    {
      GMTrace.o(3399332397056L, 25327);
      return 1;
    }
    if ((paramd.vAw) && (paramd.waz))
    {
      GMTrace.o(3399332397056L, 25327);
      return 1;
    }
    GMTrace.o(3399332397056L, 25327);
    return 2;
  }
  
  private SparseArray<String> a(e.b<String, ae> paramb, SparseArray<String> paramSparseArray, HashMap<String, ae> paramHashMap)
  {
    GMTrace.i(3400540356608L, 25336);
    String str = (String)paramb.zk;
    int k = paramSparseArray.size();
    ae localae = (ae)paramb.uNf;
    int j = paramSparseArray.size();
    int i = 0;
    label42:
    if (i < j) {
      if (!((String)paramSparseArray.get(i)).equals(str)) {}
    }
    for (;;)
    {
      v.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", new Object[] { str, Integer.valueOf(k), Integer.valueOf(i) });
      switch (paramb.uNe)
      {
      case 3: 
      case 4: 
      default: 
        if (i >= 0) {
          break label423;
        }
        v.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
        GMTrace.o(3400540356608L, 25336);
        return paramSparseArray;
        i += 1;
        break label42;
        i = -1;
      }
    }
    j = i;
    if (i < 0)
    {
      GMTrace.o(3400540356608L, 25336);
      return paramSparseArray;
    }
    while (j < k - 1)
    {
      paramSparseArray.put(j, paramSparseArray.get(j + 1));
      j += 1;
    }
    paramSparseArray.remove(k - 1);
    for (;;)
    {
      GMTrace.o(3400540356608L, 25336);
      return paramSparseArray;
      if (localae == null)
      {
        v.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
        if (i >= 0)
        {
          v.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", new Object[] { str });
          while (i < k - 1)
          {
            paramSparseArray.put(i, paramSparseArray.get(i + 1));
            i += 1;
          }
          paramSparseArray.remove(k - 1);
        }
        GMTrace.o(3400540356608L, 25336);
        return paramSparseArray;
      }
      if (i >= 0) {
        break;
      }
      i = 0;
      while ((i < k) && (d((String)paramSparseArray.get(i), paramHashMap).field_flag > localae.field_flag)) {
        i += 1;
      }
      j = k;
      while (j > i)
      {
        paramSparseArray.put(j, paramSparseArray.get(j - 1));
        j -= 1;
      }
      paramSparseArray.put(i, str);
    }
    label423:
    paramb = d(str, paramHashMap);
    if (localae == null)
    {
      v.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", new Object[] { str });
      while (i < k - 1)
      {
        paramSparseArray.put(i, paramSparseArray.get(i + 1));
        i += 1;
      }
      paramSparseArray.remove(k - 1);
      GMTrace.o(3400540356608L, 25336);
      return paramSparseArray;
    }
    long l1 = paramb.field_flag;
    long l2 = localae.field_flag;
    if (l1 == l2)
    {
      GMTrace.o(3400540356608L, 25336);
      return paramSparseArray;
    }
    int n;
    int m;
    if (l1 < l2)
    {
      n = i - 1;
      j = 0;
      m = 1;
      label556:
      k = j;
      label560:
      if (k > n) {
        break label786;
      }
      if (d((String)paramSparseArray.get(k), paramHashMap).field_flag > localae.field_flag) {
        break label687;
      }
    }
    label687:
    label786:
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", new Object[] { Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(-1), Boolean.valueOf(bool), Integer.valueOf(i), str });
      if (!bool)
      {
        GMTrace.o(3400540356608L, 25336);
        return paramSparseArray;
        n = k - 1;
        j = i + 1;
        m = 0;
        break label556;
        k += 1;
        break label560;
      }
      if (m != 0) {
        while (i > k)
        {
          paramSparseArray.put(i, paramSparseArray.get(i - 1));
          i -= 1;
        }
      }
      k -= 1;
      for (;;)
      {
        j = k;
        if (i >= k) {
          break;
        }
        paramSparseArray.put(i, paramSparseArray.get(i + 1));
        i += 1;
      }
      j = k;
      paramSparseArray.put(j, str);
      break;
    }
  }
  
  private void a(d paramd)
  {
    GMTrace.i(3399198179328L, 25326);
    if ((paramd.vAw) && (paramd.gMN == null))
    {
      paramd.nickName = this.context.getString(R.l.dVj);
      GMTrace.o(3399198179328L, 25326);
      return;
    }
    paramd.nickName = com.tencent.mm.pluginsdk.ui.d.h.c(this.context, paramd.gMN, com.tencent.mm.bg.a.T(this.context, R.f.aXH));
    GMTrace.o(3399198179328L, 25326);
  }
  
  private CharSequence b(ae paramae, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(3399735050240L, 25330);
    if ((!com.tencent.mm.platformtools.u.mA(paramae.field_editingMsg)) && ((paramae.field_atCount <= 0) || ((paramae.field_unReadCount <= 0) && (paramae.field_unReadMuteCount <= 0))))
    {
      localObject1 = new SpannableStringBuilder(this.context.getString(R.l.eyN));
      ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-5569532), 0, ((SpannableStringBuilder)localObject1).length(), 33);
      ((SpannableStringBuilder)localObject1).append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, paramae.field_editingMsg, paramInt));
      GMTrace.o(3399735050240L, 25330);
      return (CharSequence)localObject1;
    }
    if (rV(paramae.field_msgType) == 10000)
    {
      boolean bool2 = com.tencent.mm.u.o.fu(paramae.field_username);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = paramae.eC(2097152);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = paramae.eC(8388608);
      }
      bool1 = bool2;
      if (!bool2) {
        bool1 = paramae.eC(16777216);
      }
      bool2 = bool1;
      if (!bool1) {
        bool2 = com.tencent.mm.u.o.fD(paramae.field_username);
      }
      if (!bool2)
      {
        paramae = new SpannableString(com.tencent.mm.pluginsdk.ui.d.h.g(this.context, paramae.field_content, paramInt));
        GMTrace.o(3399735050240L, 25330);
        return paramae;
      }
    }
    Object localObject2;
    if (rV(paramae.field_msgType) == 49)
    {
      localObject1 = com.tencent.mm.u.n.eK(paramae.field_digestUser);
      localObject2 = f.a.ek(paramae.field_content);
      if ((localObject2 != null) && (((f.a)localObject2).type == 40) && (j.eo(paramae.field_content).hkf == 19))
      {
        if (com.tencent.mm.platformtools.u.mA((String)localObject1)) {}
        for (localObject1 = this.context.getString(R.l.dIj);; localObject1 = (String)localObject1 + ": " + this.context.getString(R.l.dIj))
        {
          paramae.cu((String)localObject1);
          GMTrace.o(3399735050240L, 25330);
          return (CharSequence)localObject1;
        }
      }
    }
    Object localObject1 = paramae.field_digest;
    if ((localObject1 != null) && (((String)localObject1).startsWith("<img src=\"original_label.png\"/>  ")))
    {
      paramae = new SpannableString(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, (CharSequence)localObject1, paramInt));
      GMTrace.o(3399735050240L, 25330);
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
        GMTrace.o(3399735050240L, 25330);
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
        GMTrace.o(3399735050240L, 25330);
        return paramae;
      }
    }
    if ((paramae.field_msgType != null) && (paramae.field_msgType.equals("64")))
    {
      paramae = paramae.field_content;
      GMTrace.o(3399735050240L, 25330);
      return paramae;
    }
    if ((paramae.field_msgType != null) && ((paramae.field_msgType.equals("47")) || (paramae.field_msgType.equals("1048625"))))
    {
      localObject1 = Ti(paramae.field_digest);
      localObject2 = "";
      if (!com.tencent.mm.platformtools.u.mA((String)localObject1))
      {
        paramae = "[" + (String)localObject1 + "]";
        GMTrace.o(3399735050240L, 25330);
        return paramae;
      }
      localObject1 = localObject2;
      if (paramae.field_digest != null)
      {
        localObject1 = localObject2;
        if (paramae.field_digest.contains(":"))
        {
          localObject2 = paramae.field_digest.substring(0, paramae.field_digest.indexOf(":"));
          String str2 = Ti(paramae.field_digest.substring(paramae.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject1 = localObject2;
          if (!com.tencent.mm.platformtools.u.mA(str2))
          {
            paramae = "[" + str2 + "]";
            if (com.tencent.mm.platformtools.u.mA((String)localObject2))
            {
              paramae = com.tencent.mm.pluginsdk.ui.d.h.c(this.context, (CharSequence)localObject2, paramInt);
              GMTrace.o(3399735050240L, 25330);
              return paramae;
            }
            localObject1 = new SpannableStringBuilder();
            ((SpannableStringBuilder)localObject1).append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, (CharSequence)localObject2, paramInt));
            ((SpannableStringBuilder)localObject1).append(": ");
            ((SpannableStringBuilder)localObject1).append(paramae);
            GMTrace.o(3399735050240L, 25330);
            return (CharSequence)localObject1;
          }
        }
      }
      localObject2 = this.context.getString(R.l.dGD);
      if (com.tencent.mm.platformtools.u.mA((String)localObject1))
      {
        localObject1 = localObject2;
        paramae.cu((String)localObject1);
      }
    }
    else
    {
      if (com.tencent.mm.platformtools.u.mA(paramae.field_digest)) {
        break label1183;
      }
      if (com.tencent.mm.platformtools.u.mA(paramae.field_digestUser)) {
        break label1172;
      }
      if ((paramae.field_isSend != 0) || (!com.tencent.mm.u.o.dH(paramae.field_username))) {
        break label1160;
      }
      localObject1 = com.tencent.mm.u.n.E(paramae.field_digestUser, paramae.field_username);
    }
    label1160:
    label1172:
    label1183:
    String str1;
    for (;;)
    {
      try
      {
        localObject1 = String.format(paramae.field_digest, new Object[] { localObject1 });
        localObject1 = ((String)localObject1).replace('\n', ' ');
        if (paramae.field_UnReadInvite <= 0) {
          break label1228;
        }
        if (paramae.field_UnReadInvite >= 4096) {
          break label1214;
        }
        paramae = this.context.getString(R.l.eyK, new Object[] { Integer.valueOf(paramae.field_UnReadInvite) });
        paramae = new SpannableStringBuilder(paramae);
        paramae.setSpan(new ForegroundColorSpan(-5569532), 0, paramae.length(), 33);
        paramae.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, (CharSequence)localObject1, paramInt));
        GMTrace.o(3399735050240L, 25330);
        return paramae;
      }
      catch (Exception localException) {}
      localObject1 = (String)localObject1 + ": " + (String)localObject2;
      break;
      localObject1 = com.tencent.mm.u.n.eK(paramae.field_digestUser);
      continue;
      localObject1 = paramae.field_digest;
      continue;
      str1 = com.tencent.mm.booter.notification.a.h.a(paramae.field_isSend, paramae.field_username, paramae.field_content, rV(paramae.field_msgType), this.context);
      continue;
      label1214:
      paramae = this.context.getString(R.l.eyI);
    }
    label1228:
    if ((paramae.field_atCount > 0) && ((paramae.field_unReadCount > 0) || (paramae.field_unReadMuteCount > 0)))
    {
      localObject2 = this.context;
      if (paramae.field_atCount < 4096) {}
      for (i = R.l.eyJ;; i = R.l.eyL)
      {
        paramae = new SpannableStringBuilder(((Context)localObject2).getString(i));
        paramae.setSpan(new ForegroundColorSpan(-5569532), 0, paramae.length(), 33);
        paramae.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, str1, paramInt));
        GMTrace.o(3399735050240L, 25330);
        return paramae;
      }
    }
    if ((paramae.eC(16777216)) && ((paramae.field_unReadCount > 0) || (paramae.field_unReadMuteCount > 0)))
    {
      paramae = this.context.getString(R.l.dAO);
      str1 = str1.replace(paramae, "");
      paramae = new SpannableStringBuilder(paramae);
      paramae.setSpan(new ForegroundColorSpan(-5569532), 0, paramae.length(), 33);
      paramae.append(com.tencent.mm.pluginsdk.ui.d.h.c(this.context, str1, paramInt));
      GMTrace.o(3399735050240L, 25330);
      return paramae;
    }
    if ((paramBoolean) && ((paramae.field_unReadCount > 1) || (paramae.field_unReadMuteCount > 0))) {}
    for (paramae = this.context.getString(R.l.eyM, new Object[] { Integer.valueOf(paramae.field_unReadCount), str1 });; paramae = str1)
    {
      paramae = com.tencent.mm.pluginsdk.ui.d.h.c(this.context, paramae, paramInt);
      GMTrace.o(3399735050240L, 25330);
      return paramae;
    }
  }
  
  private void bYm()
  {
    GMTrace.i(3398527090688L, 25321);
    if (this.vtF == null)
    {
      GMTrace.o(3398527090688L, 25321);
      return;
    }
    Iterator localIterator = this.vtF.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((d)((Map.Entry)localIterator.next()).getValue()).waq = null;
    }
    GMTrace.o(3398527090688L, 25321);
  }
  
  private void bYr()
  {
    GMTrace.i(3400808792064L, 25338);
    if ((this.vtF == null) || (this.waZ == null) || (this.waZ.isEmpty()))
    {
      GMTrace.o(3400808792064L, 25338);
      return;
    }
    v.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", new Object[] { Integer.valueOf(this.waZ.size()) });
    Iterator localIterator = this.waZ.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      int j = i;
      d locald;
      x localx;
      boolean bool2;
      if (str1 != null)
      {
        j = i;
        if (!str1.equals(""))
        {
          j = i;
          if (this.vtF.containsKey(str1))
          {
            locald = (d)this.vtF.get(str1);
            j = i;
            if (locald != null)
            {
              this.wbh.cH(str1);
              bool1 = com.tencent.mm.u.o.dH(str1);
              localx = this.wbh.bYt();
              if (localx == null) {
                continue;
              }
              String str2 = com.tencent.mm.u.n.a(localx, str1, bool1);
              v.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", new Object[] { str2, locald.gMN });
              j = i;
              if (str2 != null)
              {
                j = i;
                if (!str2.equals(locald.gMN))
                {
                  locald.gMN = str2;
                  a(locald);
                  j = 1;
                }
              }
              bool2 = localx.tD();
              if (localx.gkp != 0) {
                break label339;
              }
            }
          }
        }
      }
      label339:
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((locald.waw != bool2) || (bool1 != locald.waz))
        {
          locald.waw = bool2;
          locald.waz = bool1;
          locald.waA = localx.tE();
          j = 1;
          v.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", new Object[] { str1 });
        }
        i = j;
        break;
      }
    }
    if (i != 0) {
      notifyDataSetChanged();
    }
    this.waZ.clear();
    GMTrace.o(3400808792064L, 25338);
  }
  
  private ae d(String paramString, HashMap<String, ae> paramHashMap)
  {
    GMTrace.i(3400406138880L, 25335);
    if ((paramHashMap != null) && (paramHashMap.containsKey(paramString)))
    {
      paramString = (ae)paramHashMap.get(paramString);
      GMTrace.o(3400406138880L, 25335);
      return paramString;
    }
    paramString = (ae)bC(paramString);
    GMTrace.o(3400406138880L, 25335);
    return paramString;
  }
  
  private CharSequence i(ae paramae)
  {
    GMTrace.i(3398124437504L, 25318);
    if (paramae.field_status == 1)
    {
      paramae = this.context.getString(R.l.ezg);
      GMTrace.o(3398124437504L, 25318);
      return paramae;
    }
    if (paramae.field_conversationTime == Long.MAX_VALUE)
    {
      GMTrace.o(3398124437504L, 25318);
      return "";
    }
    paramae = com.tencent.mm.pluginsdk.j.o.c(this.context, paramae.field_conversationTime, true);
    GMTrace.o(3398124437504L, 25318);
    return paramae;
  }
  
  private static int rV(String paramString)
  {
    int j = 1;
    GMTrace.i(3399466614784L, 25328);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      GMTrace.o(3399466614784L, 25328);
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
  
  public final void BK(int paramInt)
  {
    GMTrace.i(3401211445248L, 25341);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      GMTrace.o(3401211445248L, 25341);
      return;
    }
    ae localae = (ae)yL(paramInt);
    if (localae == null)
    {
      GMTrace.o(3401211445248L, 25341);
      return;
    }
    a.b.bDS().bf(localae.field_username);
    GMTrace.o(3401211445248L, 25341);
  }
  
  public final boolean TU(String paramString)
  {
    GMTrace.i(3401077227520L, 25340);
    if ((this.vtF == null) || (!this.vtF.containsKey(paramString)))
    {
      GMTrace.o(3401077227520L, 25340);
      return true;
    }
    GMTrace.o(3401077227520L, 25340);
    return false;
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    int j = 0;
    GMTrace.i(3400674574336L, 25337);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      v.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      GMTrace.o(3400674574336L, 25337);
      return;
    }
    String str = (String)paramObject;
    if ((paramm instanceof as))
    {
      v.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), str });
      int i = j;
      if (str.contains("@"))
      {
        i = j;
        if (!str.endsWith("@chatroom")) {
          if (!str.endsWith("@micromsg.qq.com")) {
            break label157;
          }
        }
      }
      label157:
      for (i = j; i != 0; i = 1)
      {
        GMTrace.o(3400674574336L, 25337);
        return;
      }
      if (this.vtF != null) {
        if (paramObject.equals(""))
        {
          if (paramInt == 5)
          {
            this.wbe = true;
            super.o(null, 1);
            GMTrace.o(3400674574336L, 25337);
          }
        }
        else {
          this.wbd.add(str);
        }
      }
      i = paramInt;
      if (paramInt == 3) {
        i = 2;
      }
      super.o(str, i);
      GMTrace.o(3400674574336L, 25337);
      return;
    }
    if ((paramm instanceof ar))
    {
      v.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", new Object[] { Integer.valueOf(paramInt), paramObject, Boolean.valueOf(this.ndm) });
      if (this.ndm)
      {
        GMTrace.o(3400674574336L, 25337);
        return;
      }
      this.wbc = true;
      if ((paramInt == 5) || (paramInt == 2))
      {
        GMTrace.o(3400674574336L, 25337);
        return;
      }
      if ((this.vtF == null) || (!this.vtF.containsKey(str)))
      {
        GMTrace.o(3400674574336L, 25337);
        return;
      }
      if (this.waZ != null) {
        this.waZ.add(str);
      }
    }
    GMTrace.o(3400674574336L, 25337);
  }
  
  public final void a(MMSlideDelView.c paramc)
  {
    GMTrace.i(3397990219776L, 25317);
    this.jUn = paramc;
    GMTrace.o(3397990219776L, 25317);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    GMTrace.i(3397721784320L, 25315);
    this.jUm = paramf;
    GMTrace.o(3397721784320L, 25315);
  }
  
  public final SparseArray<String>[] a(HashSet<e.b<String, ae>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    GMTrace.i(3400271921152L, 25334);
    if ((paramArrayOfSparseArray == null) || (paramArrayOfSparseArray.length <= 0))
    {
      GMTrace.o(3400271921152L, 25334);
      return paramArrayOfSparseArray;
    }
    v.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", new Object[] { Integer.valueOf(paramHashSet.size()), Integer.valueOf(paramArrayOfSparseArray[0].size()) });
    Object localObject1 = new ArrayList();
    Object localObject2 = paramHashSet.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (e.b)((Iterator)localObject2).next();
      if ((localObject3 != null) && (((e.b)localObject3).uNe != 5) && (!((ArrayList)localObject1).contains(((e.b)localObject3).zk)))
      {
        v.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + (String)((e.b)localObject3).zk);
        ((ArrayList)localObject1).add(((e.b)localObject3).zk);
      }
    }
    localObject2 = new HashMap();
    ap.yY();
    Object localObject3 = com.tencent.mm.u.c.wW().a((ArrayList)localObject1, com.tencent.mm.u.o.hkZ, this.jzO, com.tencent.mm.k.a.gTI);
    Object localObject4;
    while (((Cursor)localObject3).moveToNext())
    {
      localObject4 = new ae();
      ((ae)localObject4).b((Cursor)localObject3);
      ((HashMap)localObject2).put(((aj)localObject4).field_username, localObject4);
    }
    ((Cursor)localObject3).close();
    localObject3 = paramHashSet.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (e.b)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        if (((e.b)localObject4).uNe != 5)
        {
          StringBuilder localStringBuilder = new StringBuilder("evnet name,").append((String)((e.b)localObject4).zk).append("  event.newObj   ==");
          if (((HashMap)localObject2).get(((e.b)localObject4).zk) == null) {}
          for (boolean bool = true;; bool = false)
          {
            v.d("MicroMsg.ConversationWithCacheAdapter", bool);
            ((e.b)localObject4).uNf = ((HashMap)localObject2).get(((e.b)localObject4).zk);
            break;
          }
        }
        ((e.b)localObject4).uNf = null;
      }
    }
    ((ArrayList)localObject1).clear();
    ((HashMap)localObject2).clear();
    localObject1 = new HashMap();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      localObject2 = (e.b)paramHashSet.next();
      if (localObject2 != null)
      {
        a((e.b)localObject2, paramArrayOfSparseArray[0], (HashMap)localObject1);
        if (((e.b)localObject2).uNe != 5) {
          ((HashMap)localObject1).put(((e.b)localObject2).zk, ((e.b)localObject2).uNf);
        }
      }
    }
    GMTrace.o(3400271921152L, 25334);
    return paramArrayOfSparseArray;
  }
  
  public final ArrayList<ae> ai(ArrayList<String> paramArrayList)
  {
    GMTrace.i(3400137703424L, 25333);
    v.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    ap.yY();
    paramArrayList = com.tencent.mm.u.c.wW().a(paramArrayList, com.tencent.mm.u.o.hkZ, this.jzO, com.tencent.mm.k.a.gTI);
    while (paramArrayList.moveToNext())
    {
      ae localae = new ae();
      localae.b(paramArrayList);
      localArrayList.add(localae);
    }
    paramArrayList.close();
    GMTrace.o(3400137703424L, 25333);
    return localArrayList;
  }
  
  public final boolean bNB()
  {
    GMTrace.i(3400943009792L, 25339);
    boolean bool = super.bNB();
    GMTrace.o(3400943009792L, 25339);
    return bool;
  }
  
  public final com.tencent.mm.bj.a.d bOE()
  {
    GMTrace.i(16852780580864L, 125563);
    v.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
    ap.yY();
    com.tencent.mm.bj.a.d locald = (com.tencent.mm.bj.a.d)com.tencent.mm.u.c.wW().a(com.tencent.mm.u.o.hkZ, this.jzO, com.tencent.mm.k.a.gTI, true);
    GMTrace.o(16852780580864L, 125563);
    return locald;
  }
  
  public final void bXA()
  {
    boolean bool1 = true;
    GMTrace.i(3398258655232L, 25319);
    if (this.jzO == null) {
      this.jzO = new ArrayList();
    }
    this.jzO.clear();
    int i;
    if ((com.tencent.mm.u.m.xP() & 0x8000) == 0)
    {
      i = 1;
      boolean bool2 = com.tencent.mm.u.m.yc();
      if ((i == 0) || (!bool2)) {
        break label145;
      }
      label62:
      if (bool1 != this.wbf)
      {
        if (!bool1) {
          break label150;
        }
        ap.yY();
        a(5, (com.tencent.mm.sdk.e.m)com.tencent.mm.u.c.wW(), "floatbottle");
      }
    }
    for (;;)
    {
      this.wbf = bool1;
      if (this.wbf) {
        this.jzO.add("floatbottle");
      }
      this.jzO.add("qmessage");
      GMTrace.o(3398258655232L, 25319);
      return;
      i = 0;
      break;
      label145:
      bool1 = false;
      break label62;
      label150:
      ap.yY();
      a(2, (com.tencent.mm.sdk.e.m)com.tencent.mm.u.c.wW(), "floatbottle");
    }
  }
  
  public final void bYq()
  {
    GMTrace.i(3398795526144L, 25323);
    super.o(null, 1);
    GMTrace.o(3398795526144L, 25323);
  }
  
  public final void clearCache()
  {
    GMTrace.i(3399600832512L, 25329);
    if (this.vtF != null)
    {
      this.vtF.clear();
      this.wbe = true;
    }
    GMTrace.o(3399600832512L, 25329);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(3398929743872L, 25324);
    this.wbj = new a();
    ae localae = (ae)yL(paramInt);
    Object localObject1 = localae.field_username;
    this.wbh.cH((String)localObject1);
    Object localObject2;
    Object localObject3;
    int i;
    if (this.wbb.containsKey(localObject1))
    {
      if (paramInt != ((Integer)this.wbb.get(localObject1)).intValue())
      {
        localObject2 = bOF();
        int k;
        if (this.uMR == null)
        {
          paramViewGroup = null;
          localObject3 = new StringBuffer();
          k = localObject2.length;
          i = 0;
        }
        Map.Entry localEntry;
        for (;;)
        {
          if (i >= k) {
            break label251;
          }
          localEntry = localObject2[i];
          int j = 0;
          for (;;)
          {
            if ((j < localEntry.size()) && (j < 50))
            {
              ((StringBuffer)localObject3).append("[");
              ((StringBuffer)localObject3).append(j);
              ((StringBuffer)localObject3).append(",");
              ((StringBuffer)localObject3).append(localEntry.keyAt(j));
              ((StringBuffer)localObject3).append(",");
              ((StringBuffer)localObject3).append((String)localEntry.valueAt(j));
              ((StringBuffer)localObject3).append("]");
              j += 1;
              continue;
              paramViewGroup = this.uMR.uKT.bNA();
              break;
            }
          }
          i += 1;
        }
        label251:
        ((StringBuffer)localObject3).append("\n");
        if (paramViewGroup != null)
        {
          localObject2 = paramViewGroup.entrySet().iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            localEntry = (Map.Entry)((Iterator)localObject2).next();
            if (i >= 50) {
              break;
            }
            i += 1;
            ((StringBuffer)localObject3).append("[");
            ((StringBuffer)localObject3).append(localEntry.getKey());
            ((StringBuffer)localObject3).append(",");
            if (localEntry.getValue() != null) {
              ((StringBuffer)localObject3).append(((ae)localEntry.getValue()).field_username);
            }
            ((StringBuffer)localObject3).append("]");
          }
          ((StringBuffer)localObject3).append("\n");
        }
        localObject2 = ((StringBuffer)localObject3).toString();
        localObject3 = this.wbb.toString();
        if (paramViewGroup == null) {
          break label1666;
        }
        i = paramViewGroup.size();
        v.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", new Object[] { localObject2, localObject1, Integer.valueOf(paramInt), localObject3, Integer.valueOf(i) });
        if (!this.wba)
        {
          com.tencent.mm.plugin.fts.a.e.mM(20);
          this.wba = true;
        }
        if (System.currentTimeMillis() - this.wbk > 3600000L)
        {
          super.o(null, 1);
          this.wbk = System.currentTimeMillis();
        }
      }
      label507:
      if (paramView != null) {
        break label1729;
      }
      paramViewGroup = new f();
      if (!com.tencent.mm.bg.a.dM(this.context)) {
        break label1689;
      }
      paramView = View.inflate(this.context, R.i.cZG, null);
      label541:
      paramViewGroup.ipb = ((ImageView)paramView.findViewById(R.h.bqF));
      a.b.a(paramViewGroup.ipb, (String)localObject1);
      localObject2 = (com.tencent.mm.pluginsdk.ui.a)paramViewGroup.ipb.getDrawable();
      if (this.vZX != null) {
        this.vZX.a((d.a)localObject2);
      }
      paramViewGroup.vtJ = ((NoMeasuredTextView)paramView.findViewById(R.h.cnW));
      paramViewGroup.vtK = ((NoMeasuredTextView)paramView.findViewById(R.h.cKE));
      paramViewGroup.wbu = ((ImageView)paramView.findViewById(R.h.can));
      paramViewGroup.vtL = ((NoMeasuredTextView)paramView.findViewById(R.h.cam));
      paramViewGroup.jUv = ((TextView)paramView.findViewById(R.h.cIC));
      paramViewGroup.vtM = ((ImageView)paramView.findViewById(R.h.bWW));
      paramViewGroup.vtO = paramView.findViewById(R.h.bqG);
      paramViewGroup.vtN = ((ImageView)paramView.findViewById(R.h.cHr));
      paramViewGroup.waE = ((ImageView)paramView.findViewById(R.h.ccg));
      paramViewGroup.wbv = ((ImageView)paramView.findViewById(R.h.clB));
      paramViewGroup.jUv.setBackgroundResource(s.fg(this.context));
      paramViewGroup.wbw = new c();
      paramView.setTag(paramViewGroup);
      paramViewGroup.vtL.H(com.tencent.mm.bg.a.T(this.context, R.f.aXT));
      paramViewGroup.vtK.H(com.tencent.mm.bg.a.T(this.context, R.f.aXV));
      paramViewGroup.vtJ.H(com.tencent.mm.bg.a.T(this.context, R.f.aXH));
      this.wbi = paramViewGroup.vtJ.gm.getTextSize();
      paramViewGroup.vtL.setTextColor(this.vtE[0]);
      paramViewGroup.vtK.setTextColor(this.vtE[4]);
      paramViewGroup.vtJ.setTextColor(this.vtE[3]);
      paramViewGroup.vtL.vng = true;
      paramViewGroup.vtK.vng = false;
      paramViewGroup.vtJ.vng = true;
      paramViewGroup.vtK.wa();
      label898:
      localObject2 = j(localae);
      if (((d)localObject2).war == null) {
        ((d)localObject2).war = b(localae, (int)paramViewGroup.vtL.gm.getTextSize(), ((d)localObject2).wax);
      }
      if (((d)localObject2).waq == null) {
        ((d)localObject2).waq = i(localae);
      }
      if (!((d)localObject2).wax) {
        break label1740;
      }
      paramViewGroup.vtL.setTextColor(this.vtE[0]);
      label981:
      com.tencent.mm.booter.notification.a.h.dX(paramViewGroup.vtL.getWidth());
      com.tencent.mm.booter.notification.a.h.dY((int)paramViewGroup.vtL.gm.getTextSize());
      com.tencent.mm.booter.notification.a.h.a(paramViewGroup.vtL.gm);
      if (!((String)localObject1).toLowerCase().endsWith("@t.qq.com")) {
        break label1760;
      }
      paramViewGroup.vtJ.Aj(R.g.bfP);
      paramViewGroup.vtJ.kT(true);
      label1047:
      paramInt = ((d)localObject2).was;
      if (paramInt == -1) {
        break label1771;
      }
      paramViewGroup.vtL.Ai(paramInt);
      paramViewGroup.vtL.kS(true);
      v.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", new Object[] { localObject1, Integer.valueOf(((d)localObject2).was) });
      label1102:
      paramViewGroup.vtJ.setText(((d)localObject2).nickName);
      localObject3 = paramViewGroup.vtK.getLayoutParams();
      if (((d)localObject2).waq.length() < 9) {
        break label1789;
      }
      if (((ViewGroup.LayoutParams)localObject3).width != this.wai)
      {
        ((ViewGroup.LayoutParams)localObject3).width = this.wai;
        paramViewGroup.vtK.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      label1168:
      paramViewGroup.vtK.setText(((d)localObject2).waq);
      paramViewGroup.vtL.setText(((d)localObject2).war);
      paramViewGroup.wbu.setVisibility(8);
      paramViewGroup.vtM.setVisibility(8);
      if (!((d)localObject2).vAw) {
        break label1822;
      }
      if (((d)localObject2).waz) {
        paramViewGroup.vtM.setVisibility(0);
      }
      label1234:
      a.b.a(paramViewGroup.ipb, (String)localObject1);
      if (this.vZV)
      {
        if ((localae != null) && (paramViewGroup != null) && (localObject2 != null)) {
          break label1841;
        }
        v.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
      }
      label1272:
      if ((!((d)localObject2).wav) && (((d)localObject2).vtG) && (ap.zb()))
      {
        ap.yY();
        com.tencent.mm.u.c.wW().f(localae);
      }
      if ((!((d)localObject2).vtG) || (localae.field_conversationTime == -1L)) {
        break label2068;
      }
      paramView.findViewById(R.h.bGC).setBackgroundResource(R.g.bem);
      label1342:
      if (Build.VERSION.SDK_INT >= 21) {
        paramView.findViewById(R.h.bGC).setOnTouchListener(new View.OnTouchListener()
        {
          @TargetApi(21)
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            GMTrace.i(3426847031296L, 25532);
            paramAnonymousView.findViewById(R.h.bGC).getBackground().setHotspot(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
            GMTrace.o(3426847031296L, 25532);
            return false;
          }
        });
      }
      com.tencent.mm.bb.d.bGH();
      if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localae, 7, 0L)) && (!localae.field_username.equals(this.waX.fXl.fXo)))
      {
        localae.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localae, 6, localae.field_conversationTime));
        ap.yY();
        com.tencent.mm.u.c.wW().a(localae, localae.field_username);
      }
      if ((l.a.szL != null) && (l.a.szL.Hp(localae.field_username))) {
        break label2084;
      }
      paramViewGroup.vtN.setVisibility(8);
      label1474:
      if ((l.a.szS == null) || (!l.a.szS.zq(localae.field_username))) {
        break label2139;
      }
      paramViewGroup.waE.setVisibility(0);
      label1504:
      if ((!com.tencent.mm.u.o.dH(localae.field_username)) || (l.a.szT == null) || (!l.a.szT.AY(localae.field_username))) {
        break label2164;
      }
      if ((!l.a.szT.aMH()) || (!l.a.szT.cS(localae.field_username, com.tencent.mm.u.m.xL()))) {
        break label2151;
      }
      paramViewGroup.wbv.setImageResource(R.k.dvt);
      label1577:
      paramViewGroup.wbv.setVisibility(0);
    }
    for (;;)
    {
      this.wbj.content = String.valueOf(((d)localObject2).war);
      this.wbj.aIO = ((d)localObject2).gMN;
      this.wbj.wap = String.valueOf(((d)localObject2).waq);
      paramViewGroup = this.wbj;
      a.a.uVh.a(paramView, paramViewGroup.aIO, paramViewGroup.wao, paramViewGroup.wap, paramViewGroup.content);
      GMTrace.o(3398929743872L, 25324);
      return paramView;
      label1666:
      i = 0;
      break;
      this.wbb.put(localObject1, Integer.valueOf(paramInt));
      break label507;
      label1689:
      if (com.tencent.mm.bg.a.dN(this.context))
      {
        paramView = View.inflate(this.context, R.i.cZH, null);
        break label541;
      }
      paramView = View.inflate(this.context, R.i.cZF, null);
      break label541;
      label1729:
      paramViewGroup = (f)paramView.getTag();
      break label898;
      label1740:
      paramViewGroup.vtL.setTextColor(this.vtE[localObject2.klJ]);
      break label981;
      label1760:
      paramViewGroup.vtJ.kT(false);
      break label1047;
      label1771:
      paramViewGroup.vtL.kS(false);
      paramViewGroup.vtL.invalidate();
      break label1102;
      label1789:
      if (((ViewGroup.LayoutParams)localObject3).width == this.wah) {
        break label1168;
      }
      ((ViewGroup.LayoutParams)localObject3).width = this.wah;
      paramViewGroup.vtK.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      break label1168;
      label1822:
      if (!((d)localObject2).waw) {
        break label1234;
      }
      paramViewGroup.vtM.setVisibility(0);
      break label1234;
      label1841:
      paramViewGroup.jUv.setVisibility(4);
      paramViewGroup.vtO.setVisibility(4);
      if ((!com.tencent.mm.u.o.eR(localae.field_username)) && (((d)localObject2).way) && ((((d)localObject2).wau == 1) || (((d)localObject2).wau == 2) || (((d)localObject2).wau == 3))) {}
      for (localObject1 = this.vtE[2];; localObject1 = this.vtE[3])
      {
        paramViewGroup.vtJ.setTextColor((ColorStateList)localObject1);
        if ((((d)localObject2).way) && (((d)localObject2).wat != 0)) {
          break label1958;
        }
        v.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
        break;
      }
      label1958:
      paramInt = a(localae, (d)localObject2);
      if (paramInt == 1)
      {
        paramViewGroup.vtO.setVisibility(0);
        break label1272;
      }
      if (paramInt != 2) {
        break label1272;
      }
      paramInt = localae.field_unReadCount;
      if (paramInt > 99)
      {
        paramViewGroup.jUv.setText(R.l.eYH);
        paramViewGroup.jUv.setVisibility(0);
      }
      for (;;)
      {
        this.wbj.wao = paramInt;
        break;
        if (paramInt > 0)
        {
          paramViewGroup.jUv.setText(localae.field_unReadCount);
          paramViewGroup.jUv.setVisibility(0);
        }
      }
      label2068:
      paramView.findViewById(R.h.bGC).setBackgroundResource(R.g.ben);
      break label1342;
      label2084:
      paramViewGroup.vtN.setVisibility(0);
      if (localae.field_username.equals(this.waX.fXl.fXo))
      {
        paramViewGroup.vtN.setImageResource(R.k.dzH);
        break label1474;
      }
      paramViewGroup.vtN.setImageResource(R.k.dzG);
      break label1474;
      label2139:
      paramViewGroup.waE.setVisibility(8);
      break label1504;
      label2151:
      paramViewGroup.wbv.setImageResource(R.k.dvu);
      break label1577;
      label2164:
      paramViewGroup.wbv.setVisibility(8);
    }
  }
  
  final d j(ae paramae)
  {
    boolean bool2 = true;
    GMTrace.i(3399063961600L, 25325);
    String str2 = paramae.field_username;
    Object localObject = (d)this.vtF.get(str2);
    if (localObject != null)
    {
      GMTrace.o(3399063961600L, 25325);
      return (d)localObject;
    }
    d locald = new d();
    this.wbh.cH(str2);
    x localx = this.wbh.bYt();
    label110:
    label131:
    label152:
    label193:
    int i;
    if (localx != null)
    {
      locald.wau = localx.gkz;
      locald.wat = ((int)localx.gTG);
      if (localx == null) {
        break label576;
      }
      bool1 = true;
      locald.way = bool1;
      if ((localx == null) || (!localx.tE())) {
        break label581;
      }
      bool1 = true;
      locald.waA = bool1;
      if ((localx == null) || (localx.gkp != 0)) {
        break label586;
      }
      bool1 = true;
      locald.waz = bool1;
      locald.vAw = com.tencent.mm.u.o.dH(str2);
      if ((!locald.vAw) || (!locald.waz) || (paramae.field_unReadCount <= 0)) {
        break label591;
      }
      bool1 = true;
      locald.wax = bool1;
      locald.klJ = 0;
      if ((rV(paramae.field_msgType) == 34) && (paramae.field_isSend == 0) && (!com.tencent.mm.platformtools.u.mA(paramae.field_content)))
      {
        String str1 = paramae.field_content;
        if ((!str2.equals("qmessage")) && (!str2.equals("floatbottle")) && (!str2.equals("officialaccounts")) && (!paramae.eC(2097152)))
        {
          localObject = str1;
          if (!paramae.eC(8388608)) {}
        }
        else
        {
          String[] arrayOfString = str1.split(":");
          localObject = str1;
          if (arrayOfString != null)
          {
            localObject = str1;
            if (arrayOfString.length > 3) {
              localObject = arrayOfString[1] + ":" + arrayOfString[2] + ":" + arrayOfString[3];
            }
          }
        }
        if (!new com.tencent.mm.modelvoice.n((String)localObject).hZO) {
          locald.klJ = 1;
        }
      }
      locald.gMN = com.tencent.mm.u.n.a(localx, str2, locald.vAw);
      a(locald);
      locald.waq = i(paramae);
      switch (paramae.field_status)
      {
      case 3: 
      case 4: 
      case 6: 
      case 7: 
      default: 
        i = -1;
        label482:
        locald.was = i;
        locald.wav = com.tencent.mm.u.o.a(paramae);
        ap.yY();
        locald.vtG = com.tencent.mm.u.c.wW().g(paramae);
        if ((localx == null) || (!localx.tD())) {
          break;
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locald.waw = bool1;
      this.vtF.put(str2, locald);
      GMTrace.o(3399063961600L, 25325);
      return locald;
      locald.wau = -1;
      locald.wat = -1;
      break;
      label576:
      bool1 = false;
      break label110;
      label581:
      bool1 = false;
      break label131;
      label586:
      bool1 = false;
      break label152;
      label591:
      bool1 = false;
      break label193;
      i = -1;
      break label482;
      i = R.k.dxE;
      break label482;
      i = -1;
      break label482;
      i = R.k.dxD;
      break label482;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    GMTrace.i(17879009329152L, 133209);
    super.notifyDataSetChanged();
    this.wbb.clear();
    v.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
    GMTrace.o(17879009329152L, 133209);
  }
  
  public final void onPause()
  {
    GMTrace.i(3398392872960L, 25320);
    v.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.vHC);
    if (!this.vHC)
    {
      GMTrace.o(3398392872960L, 25320);
      return;
    }
    this.vHC = false;
    super.pause();
    if (this.jUp != null) {
      this.jUp.aFa();
    }
    GMTrace.o(3398392872960L, 25320);
  }
  
  public final void onResume()
  {
    GMTrace.i(3398661308416L, 25322);
    v.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.vHC);
    if (this.vHC)
    {
      GMTrace.o(3398661308416L, 25322);
      return;
    }
    this.vHC = true;
    bXA();
    bYr();
    v.i(this.TAG, "newcursor resume syncNow ");
    this.uMQ = true;
    kd(true);
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = com.tencent.mm.pluginsdk.j.n.a("MM/dd", (Time)localObject).toString();
    String str = com.tencent.mm.sdk.platformtools.u.bID();
    if ((!this.waf.equals(localObject)) || (!this.wbg.equals(str))) {}
    for (int i = 1;; i = 0)
    {
      this.waf = ((String)localObject);
      this.wbg = str;
      if (i != 0) {
        bYm();
      }
      if ((this.waa) && (this.waY != null))
      {
        this.waY.bYs();
        this.waa = false;
        super.o(null, 1);
      }
      this.waX = new qk();
      this.waX.fXk.fXm = true;
      com.tencent.mm.sdk.b.a.uql.m(this.waX);
      GMTrace.o(3398661308416L, 25322);
      return;
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
      GMTrace.i(3374636335104L, 25143);
      GMTrace.o(3374636335104L, 25143);
    }
  }
  
  public static abstract interface b
  {
    public abstract void bYs();
  }
  
  final class c
  {
    public View jUw;
    public TextView jUx;
    String username;
    public View vjM;
    boolean wbm;
    boolean wbn;
    boolean wbo;
    boolean wbp;
    boolean wbq;
    public ImageView wbr;
    public TextView wbs;
    public View wbt;
    
    c()
    {
      GMTrace.i(3416109613056L, 25452);
      this.username = "";
      this.wbm = false;
      this.wbn = false;
      this.wbo = false;
      this.wbp = false;
      this.wbq = false;
      this.jUw = null;
      this.vjM = null;
      this.wbr = null;
      this.wbs = null;
      this.jUx = null;
      this.wbt = null;
      GMTrace.o(3416109613056L, 25452);
    }
  }
  
  private final class d
  {
    public String gMN;
    public int klJ;
    public CharSequence nickName;
    public boolean vAw;
    public boolean vtG;
    public boolean waA;
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
      GMTrace.i(3436510707712L, 25604);
      GMTrace.o(3436510707712L, 25604);
    }
  }
  
  private final class e
  {
    private String fJC;
    private boolean gUE;
    private x jht;
    private Integer waC;
    
    public e()
    {
      GMTrace.i(3418122878976L, 25467);
      this.gUE = false;
      this.fJC = null;
      this.gUE = false;
      this.jht = null;
      this.waC = null;
      GMTrace.o(3418122878976L, 25467);
    }
    
    public final x bYt()
    {
      GMTrace.i(3418391314432L, 25469);
      if ((this.gUE) && (this.jht == null) && (ap.zb()))
      {
        ap.yY();
        this.jht = com.tencent.mm.u.c.wR().Rb(this.fJC);
      }
      x localx = this.jht;
      GMTrace.o(3418391314432L, 25469);
      return localx;
    }
    
    public final void cH(String paramString)
    {
      GMTrace.i(3418257096704L, 25468);
      this.fJC = paramString;
      this.jht = null;
      this.waC = null;
      this.gUE = false;
      if (!com.tencent.mm.platformtools.u.mA(paramString)) {
        this.gUE = true;
      }
      GMTrace.o(3418257096704L, 25468);
    }
  }
  
  public static final class f
  {
    public ImageView ipb;
    public TextView jUv;
    public NoMeasuredTextView vtJ;
    public NoMeasuredTextView vtK;
    public NoMeasuredTextView vtL;
    public ImageView vtM;
    public ImageView vtN;
    public View vtO;
    public ImageView waE;
    public ImageView wbu;
    public ImageView wbv;
    public g.c wbw;
    
    public f()
    {
      GMTrace.i(3388460761088L, 25246);
      GMTrace.o(3388460761088L, 25246);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */