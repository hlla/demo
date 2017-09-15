package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.tools.s;
import java.util.HashMap;

public final class b
  extends com.tencent.mm.ui.k<com.tencent.mm.modelbiz.a.a>
  implements m.b
{
  protected MMSlideDelView.f jUm;
  protected MMSlideDelView.c jUn;
  protected MMSlideDelView.e jUo;
  protected MMSlideDelView.d jUp;
  private final String jZw;
  private com.tencent.mm.ah.a.a.c kuE;
  private final MMFragmentActivity vtA;
  private float vtB;
  private float vtC;
  private float vtD;
  private ColorStateList[] vtE;
  HashMap<String, a> vtF;
  
  public b(Context paramContext, k.a parama, String paramString)
  {
    super(paramContext, new com.tencent.mm.modelbiz.a.a());
    GMTrace.i(2974801723392L, 22164);
    this.jUp = MMSlideDelView.bSe();
    this.vtB = -1.0F;
    this.vtC = -1.0F;
    this.vtD = -1.0F;
    this.vtE = new ColorStateList[5];
    this.kuE = null;
    this.uQY = parama;
    this.vtA = ((MMFragmentActivity)paramContext);
    this.jZw = paramString;
    this.vtF = new HashMap();
    this.vtE[0] = com.tencent.mm.bg.a.S(paramContext, R.e.aUo);
    this.vtE[1] = com.tencent.mm.bg.a.S(paramContext, R.e.aVe);
    this.vtE[3] = com.tencent.mm.bg.a.S(paramContext, R.e.aVo);
    this.vtE[2] = com.tencent.mm.bg.a.S(paramContext, R.e.aVc);
    this.vtE[2] = com.tencent.mm.bg.a.S(paramContext, R.e.aVc);
    this.vtE[4] = com.tencent.mm.bg.a.S(paramContext, R.e.aUy);
    this.vtB = com.tencent.mm.bg.a.T(paramContext, R.f.aXH);
    this.vtC = com.tencent.mm.bg.a.T(paramContext, R.f.aXr);
    this.vtD = com.tencent.mm.bg.a.T(paramContext, R.f.aXV);
    paramContext = new c.a();
    paramContext.hIw = e.iA(this.jZw);
    paramContext.hIt = true;
    paramContext.hIP = true;
    paramContext.hII = R.k.ber;
    this.kuE = paramContext.Hh();
    GMTrace.o(2974801723392L, 22164);
  }
  
  private static String Ti(String paramString)
  {
    GMTrace.i(2976009682944L, 22173);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ua(paramString);
      GMTrace.o(2976009682944L, 22173);
      return paramString;
    }
    GMTrace.o(2976009682944L, 22173);
    return null;
  }
  
  private CharSequence a(com.tencent.mm.modelbiz.a.a parama, int paramInt, String paramString)
  {
    GMTrace.i(2976143900672L, 22174);
    if ((!bf.mA(parama.field_editingMsg)) && ((parama.field_atCount <= 0) || (parama.field_unReadCount <= 0)))
    {
      paramString = new SpannableStringBuilder(this.vtA.getString(R.l.eyN));
      paramString.setSpan(new ForegroundColorSpan(-5569532), 0, paramString.length(), 33);
      paramString.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.vtA, parama.field_editingMsg, paramInt));
      GMTrace.o(2976143900672L, 22174);
      return paramString;
    }
    Object localObject = parama.field_digest;
    String str1;
    if ((parama.field_msgType != null) && ((parama.field_msgType.equals("47")) || (parama.field_msgType.equals("1048625"))))
    {
      localObject = Ti(parama.field_digest);
      str1 = "";
      if (localObject != null)
      {
        parama = "[" + (String)localObject + "]";
        GMTrace.o(2976143900672L, 22174);
        return parama;
      }
      localObject = str1;
      if (parama.field_digest != null)
      {
        localObject = str1;
        if (parama.field_digest.contains(":"))
        {
          str1 = parama.field_digest.substring(0, parama.field_digest.indexOf(":"));
          String str2 = Ti(parama.field_digest.substring(parama.field_digest.indexOf(":") + 1).replace(" ", ""));
          localObject = str1;
          if (str2 != null)
          {
            parama = "[" + str2 + "]";
            if (bf.mA(str1))
            {
              GMTrace.o(2976143900672L, 22174);
              return parama;
            }
            parama = str1 + ": " + parama;
            GMTrace.o(2976143900672L, 22174);
            return parama;
          }
        }
      }
      str1 = this.vtA.getString(R.l.dGD);
      if (bf.mA((String)localObject))
      {
        localObject = str1;
        parama.field_digest = ((String)localObject);
      }
    }
    else
    {
      if (bf.mA(parama.field_digest)) {
        break label572;
      }
      if (bf.mA(parama.field_digestUser)) {
        break label564;
      }
    }
    for (;;)
    {
      try
      {
        paramString = String.format(parama.field_digest, new Object[] { paramString });
        paramString = paramString.replace('\n', ' ');
        if ((parama.field_atCount <= 0) || (parama.field_unReadCount <= 0)) {
          break label579;
        }
        parama = new SpannableStringBuilder(this.vtA.getString(R.l.eyJ));
        parama.setSpan(new ForegroundColorSpan(-5569532), 0, parama.length(), 33);
        parama.append(" ").append(com.tencent.mm.pluginsdk.ui.d.h.c(this.vtA, paramString, paramInt));
        GMTrace.o(2976143900672L, 22174);
        return parama;
        localObject = (String)localObject + ": " + str1;
      }
      catch (Exception paramString)
      {
        paramString = parama.field_digest;
        continue;
      }
      label564:
      paramString = parama.field_digest;
      continue;
      label572:
      paramString = "";
    }
    label579:
    parama = com.tencent.mm.pluginsdk.ui.d.h.c(this.vtA, paramString, paramInt);
    GMTrace.o(2976143900672L, 22174);
    return parama;
  }
  
  private static int rV(String paramString)
  {
    int j = 1;
    GMTrace.i(2976278118400L, 22175);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      GMTrace.o(2976278118400L, 22175);
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
  
  public final void OL()
  {
    GMTrace.i(2974935941120L, 22165);
    aEP();
    setCursor(w.DK().ip(this.jZw));
    if (this.uQY != null) {
      this.uQY.OI();
    }
    super.notifyDataSetChanged();
    GMTrace.o(2974935941120L, 22165);
  }
  
  protected final void OM()
  {
    GMTrace.i(2976412336128L, 22176);
    OL();
    GMTrace.o(2976412336128L, 22176);
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    GMTrace.i(2976546553856L, 22177);
    super.a(paramInt, paramm, paramObject);
    GMTrace.o(2976546553856L, 22177);
  }
  
  public final void a(MMSlideDelView.c paramc)
  {
    GMTrace.i(2975472812032L, 22169);
    this.jUn = paramc;
    GMTrace.o(2975472812032L, 22169);
  }
  
  public final void a(MMSlideDelView.e parame)
  {
    GMTrace.i(2975338594304L, 22168);
    this.jUo = parame;
    GMTrace.o(2975338594304L, 22168);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    GMTrace.i(2975204376576L, 22167);
    this.jUm = paramf;
    GMTrace.o(2975204376576L, 22167);
  }
  
  public final void eE(long paramLong)
  {
    GMTrace.i(2976680771584L, 22178);
    if (this.vtF != null) {
      this.vtF.remove(String.valueOf(paramLong));
    }
    GMTrace.o(2976680771584L, 22178);
  }
  
  public final int getItemViewType(int paramInt)
  {
    GMTrace.i(2975607029760L, 22170);
    GMTrace.o(2975607029760L, 22170);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(2975875465216L, 22172);
    Object localObject3 = (com.tencent.mm.modelbiz.a.a)getItem(paramInt);
    if (paramView != null) {}
    for (paramViewGroup = (b)paramView.getTag();; paramViewGroup = null)
    {
      if ((paramView == null) || (paramViewGroup == null))
      {
        paramViewGroup = new b();
        if (com.tencent.mm.bg.a.dM(this.vtA))
        {
          paramView = View.inflate(this.vtA, R.i.cZE, null);
          paramViewGroup.ipb = ((ImageView)paramView.findViewById(R.h.bqF));
          paramViewGroup.vtJ = ((NoMeasuredTextView)paramView.findViewById(R.h.cnW));
          paramViewGroup.vtK = ((NoMeasuredTextView)paramView.findViewById(R.h.cKE));
          paramViewGroup.vtL = ((NoMeasuredTextView)paramView.findViewById(R.h.cam));
          paramViewGroup.jUv = ((TextView)paramView.findViewById(R.h.cIC));
          paramViewGroup.jUv.setBackgroundResource(s.fg(this.vtA));
          paramViewGroup.vtM = ((ImageView)paramView.findViewById(R.h.bWW));
          paramViewGroup.vtO = paramView.findViewById(R.h.bqG);
          paramViewGroup.vtN = ((ImageView)paramView.findViewById(R.h.cHr));
          paramView.setTag(paramViewGroup);
          paramViewGroup.vtL.H(this.vtC);
          paramViewGroup.vtK.H(this.vtD);
          paramViewGroup.vtJ.H(this.vtB);
          paramViewGroup.vtL.setTextColor(this.vtE[0]);
          paramViewGroup.vtK.setTextColor(this.vtE[4]);
          paramViewGroup.vtJ.setTextColor(this.vtE[3]);
          paramViewGroup.vtL.vng = true;
          paramViewGroup.vtK.vng = false;
          paramViewGroup.vtJ.vng = true;
          paramViewGroup.vtK.wa();
        }
      }
      for (;;)
      {
        long l = ((com.tencent.mm.modelbiz.a.a)localObject3).field_bizChatId;
        Object localObject2 = (a)this.vtF.get(String.valueOf(l));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a();
          w.DK();
          ((a)localObject1).vtG = com.tencent.mm.modelbiz.a.b.c((com.tencent.mm.modelbiz.a.a)localObject3);
          localObject2 = w.DJ().aa(l);
          if (((com.tencent.mm.modelbiz.a.c)localObject2).DV())
          {
            ((a)localObject1).hzc = ((com.tencent.mm.modelbiz.a.c)localObject2).field_chatName;
            ((a)localObject1).kkZ = ((com.tencent.mm.modelbiz.a.c)localObject2).fu(1);
            ((a)localObject1).lUI = ((com.tencent.mm.modelbiz.a.c)localObject2).field_headImageUrl;
            label406:
            if (bf.mA(((a)localObject1).hzc)) {
              ((a)localObject1).hzc = this.vtA.getString(R.l.eMt);
            }
            ((a)localObject1).vtH = ((com.tencent.mm.modelbiz.a.a)localObject3);
            this.vtF.put(String.valueOf(l), localObject1);
          }
        }
        else
        {
          paramViewGroup.vtN.setVisibility(8);
          localObject3 = paramViewGroup.vtK;
          if (((a)localObject1).vtH.field_status != 1) {
            break label910;
          }
          localObject2 = this.vtA.getString(R.l.ezg);
          label493:
          ((NoMeasuredTextView)localObject3).setText((CharSequence)localObject2);
          com.tencent.mm.ah.n.GX().a(((a)localObject1).lUI, paramViewGroup.ipb, this.kuE);
          if (!((a)localObject1).kkZ) {
            break label931;
          }
          paramViewGroup.vtM.setVisibility(0);
          label535:
          paramViewGroup.vtJ.setText(com.tencent.mm.pluginsdk.ui.d.h.c(this.vtA, ((a)localObject1).hzc, (int)paramViewGroup.vtJ.gm.getTextSize()));
          localObject2 = a(((a)localObject1).vtH, (int)paramViewGroup.vtL.gm.getTextSize(), ((a)localObject1).hzc);
          switch (((a)localObject1).vtH.field_status)
          {
          case 3: 
          case 4: 
          default: 
            paramInt = -1;
            label642:
            paramViewGroup.vtJ.kT(false);
            if (paramInt != -1)
            {
              paramViewGroup.vtL.Ai(paramInt);
              paramViewGroup.vtL.kS(true);
              label671:
              paramViewGroup.vtL.setText((CharSequence)localObject2);
              paramViewGroup.vtL.setTextColor(com.tencent.mm.bg.a.S(this.vtA, R.e.aVd));
              if ((rV(((a)localObject1).vtH.field_msgType) == 34) && (((a)localObject1).vtH.field_isSend == 0) && (!bf.mA(((a)localObject1).vtH.field_content)) && (!new com.tencent.mm.modelvoice.n(((a)localObject1).vtH.field_content).hZO)) {
                paramViewGroup.vtL.setTextColor(com.tencent.mm.bg.a.S(this.vtA, R.e.aVe));
              }
              if (!((a)localObject1).kkZ) {
                break label989;
              }
              if (((a)localObject1).vtH.field_unReadCount <= 0) {
                break label978;
              }
              paramViewGroup.vtO.setVisibility(0);
              label803:
              paramViewGroup.jUv.setVisibility(4);
              label811:
              if (!((a)localObject1).vtG) {
                break label1119;
              }
              paramView.findViewById(R.h.bGC).setBackgroundResource(R.g.bem);
            }
            break;
          }
        }
        for (;;)
        {
          GMTrace.o(2975875465216L, 22172);
          return paramView;
          paramView = View.inflate(this.vtA, R.i.cZD, null);
          break;
          localObject2 = w.DL().iE(((com.tencent.mm.modelbiz.a.c)localObject2).field_bizChatServId);
          if (localObject2 == null) {
            break label406;
          }
          ((a)localObject1).hzc = ((j)localObject2).field_userName;
          ((a)localObject1).kkZ = ((j)localObject2).fu(1);
          ((a)localObject1).lUI = ((j)localObject2).field_headImageUrl;
          break label406;
          label910:
          localObject2 = o.c(this.vtA, ((a)localObject1).vtH.field_lastMsgTime, true);
          break label493;
          label931:
          paramViewGroup.vtM.setVisibility(8);
          break label535;
          paramInt = -1;
          break label642;
          paramInt = R.k.dxE;
          break label642;
          paramInt = -1;
          break label642;
          paramInt = R.k.dxD;
          break label642;
          paramViewGroup.vtL.kS(false);
          break label671;
          label978:
          paramViewGroup.vtO.setVisibility(4);
          break label803;
          label989:
          paramViewGroup.vtO.setVisibility(4);
          if (((a)localObject1).vtH.field_unReadCount > 99)
          {
            paramViewGroup.jUv.setText(R.l.eYH);
            paramViewGroup.jUv.setVisibility(0);
            v.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            break label811;
          }
          if (((a)localObject1).vtH.field_unReadCount > 0)
          {
            paramViewGroup.jUv.setText(((a)localObject1).vtH.field_unReadCount);
            paramViewGroup.jUv.setVisibility(0);
            v.v("MicroMsg.BizChatConversationAdapter", "has unread");
            break label811;
          }
          paramViewGroup.jUv.setVisibility(4);
          v.v("MicroMsg.BizChatConversationAdapter", "no unread");
          break label811;
          label1119:
          paramView.findViewById(R.h.bGC).setBackgroundResource(R.g.ben);
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    GMTrace.i(2975070158848L, 22166);
    GMTrace.o(2975070158848L, 22166);
    return 1;
  }
  
  public final void onPause()
  {
    GMTrace.i(2975741247488L, 22171);
    if (this.jUp != null) {
      this.jUp.aFa();
    }
    GMTrace.o(2975741247488L, 22171);
  }
  
  private final class a
  {
    String hzc;
    public boolean kkZ;
    String lUI;
    public boolean vtG;
    public com.tencent.mm.modelbiz.a.a vtH;
    
    public a()
    {
      GMTrace.i(3011040509952L, 22434);
      this.hzc = null;
      this.lUI = null;
      GMTrace.o(3011040509952L, 22434);
    }
  }
  
  public static final class b
  {
    public ImageView ipb;
    public TextView jUv;
    public NoMeasuredTextView vtJ;
    public NoMeasuredTextView vtK;
    public NoMeasuredTextView vtL;
    public ImageView vtM;
    public ImageView vtN;
    public View vtO;
    
    public b()
    {
      GMTrace.i(2991444721664L, 22288);
      GMTrace.o(2991444721664L, 22288);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bizchat/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */