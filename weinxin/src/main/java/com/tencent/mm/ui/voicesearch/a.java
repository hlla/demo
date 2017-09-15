package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.qk.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.n;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bh;
import com.tencent.mm.u.bi;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.tools.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a
  extends k<ae>
{
  private com.tencent.mm.ui.applet.b hAM;
  private b.b hAN;
  private String isc;
  protected List<String> jzO;
  private boolean vZV;
  private ColorStateList[] vtE;
  private HashMap<String, a> vtF;
  private b wpL;
  
  public a(Context paramContext, k.a parama)
  {
    super(paramContext, new ae());
    GMTrace.i(2842865696768L, 21181);
    this.jzO = null;
    this.vtE = new ColorStateList[2];
    this.vZV = true;
    this.hAN = null;
    this.hAM = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap jg(String paramAnonymousString)
      {
        GMTrace.i(2848637059072L, 21224);
        paramAnonymousString = com.tencent.mm.x.b.a(paramAnonymousString, false, -1);
        GMTrace.o(2848637059072L, 21224);
        return paramAnonymousString;
      }
    });
    this.uQY = parama;
    this.vtE[0] = com.tencent.mm.bg.a.S(paramContext, R.e.aVd);
    this.vtE[1] = com.tencent.mm.bg.a.S(paramContext, R.e.aVe);
    this.vtF = new HashMap();
    GMTrace.o(2842865696768L, 21181);
  }
  
  private static int rV(String paramString)
  {
    int j = 1;
    GMTrace.i(2843536785408L, 21186);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      GMTrace.o(2843536785408L, 21186);
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
    GMTrace.i(2843268349952L, 21184);
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
        v.d("MicroMsg.SearchConversationAdapter", "block user " + str);
      }
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.SearchConversationAdapter", localException, "", new Object[0]);
      arrayOfCursor[1] = ap.yY().hkt.a(this.isc, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      setCursor(new MergeCursor(arrayOfCursor));
      if ((this.wpL != null) && (this.isc != null)) {
        getCursor().getCount();
      }
      super.notifyDataSetChanged();
      GMTrace.o(2843268349952L, 21184);
    }
  }
  
  protected final void OM()
  {
    GMTrace.i(2843134132224L, 21183);
    OL();
    GMTrace.o(2843134132224L, 21183);
  }
  
  public final void a(String paramString, l paraml)
  {
    GMTrace.i(2843671003136L, 21187);
    if ((paramString != null) && (!paramString.equals("")) && (this.vtF != null)) {
      this.vtF.remove(paramString);
    }
    for (;;)
    {
      super.a(paramString, paraml);
      GMTrace.o(2843671003136L, 21187);
      return;
      if (this.vtF != null) {
        this.vtF.clear();
      }
    }
  }
  
  public final void cK(List<String> paramList)
  {
    GMTrace.i(2842999914496L, 21182);
    this.jzO = paramList;
    a(null, null);
    GMTrace.o(2842999914496L, 21182);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(2843402567680L, 21185);
    if (this.hAN == null) {
      this.hAN = new b.b()
      {
        public final int Fi()
        {
          GMTrace.i(2833604673536L, 21112);
          int i = a.this.getCount();
          GMTrace.o(2833604673536L, 21112);
          return i;
        }
        
        public final String fE(int paramAnonymousInt)
        {
          GMTrace.i(2833470455808L, 21111);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= a.this.getCount()))
          {
            v.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
            GMTrace.o(2833470455808L, 21111);
            return null;
          }
          Object localObject = (ae)a.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            GMTrace.o(2833470455808L, 21111);
            return null;
          }
          localObject = ((aj)localObject).field_username;
          GMTrace.o(2833470455808L, 21111);
          return (String)localObject;
        }
      };
    }
    if (this.hAM != null) {
      this.hAM.a(paramInt, this.hAN);
    }
    ae localae = (ae)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if ((rV(localae.field_msgType) == 34) && (localae.field_isSend == 0) && (!u.mA(localae.field_content)))
    {
      localObject1 = localae.field_content;
      if (!localae.field_username.equals("qmessage"))
      {
        paramViewGroup = (ViewGroup)localObject1;
        if (!localae.field_username.equals("floatbottle")) {}
      }
      else
      {
        localObject2 = ((String)localObject1).split(":");
        paramViewGroup = (ViewGroup)localObject1;
        if (localObject2 != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          if (localObject2.length > 3) {
            paramViewGroup = localObject2[1] + ":" + localObject2[2] + ":" + localObject2[3];
          }
        }
      }
      if (new com.tencent.mm.modelvoice.n(paramViewGroup).hZO) {}
    }
    for (int i = 1;; i = 0)
    {
      label469:
      int j;
      int k;
      if (paramView == null)
      {
        paramViewGroup = new c();
        localObject1 = View.inflate(this.context, R.i.dna, null);
        paramViewGroup.ipb = ((ImageView)((View)localObject1).findViewById(R.h.bqF));
        paramViewGroup.jUr = ((TextView)((View)localObject1).findViewById(R.h.cnW));
        paramViewGroup.jUs = ((TextView)((View)localObject1).findViewById(R.h.cKE));
        paramViewGroup.jUt = ((TextView)((View)localObject1).findViewById(R.h.cam));
        paramViewGroup.jUv = ((TextView)((View)localObject1).findViewById(R.h.cIC));
        paramViewGroup.jUv.setBackgroundResource(s.fg(this.context));
        paramViewGroup.vtM = ((ImageView)((View)localObject1).findViewById(R.h.bWW));
        paramViewGroup.vtN = ((ImageView)((View)localObject1).findViewById(R.h.cHr));
        ((View)localObject1).setTag(paramViewGroup);
        localObject2 = (a)this.vtF.get(localae.field_username + localae.field_content);
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new a();
          ((a)localObject2).nickName = com.tencent.mm.pluginsdk.ui.d.h.b(this.context, com.tencent.mm.u.n.eK(localae.field_username), paramViewGroup.jUr.getTextSize());
          if (localae.field_status != 1) {
            break label1094;
          }
          paramView = this.context.getString(R.l.ezg);
          ((a)localObject2).waq = paramView;
          j = (int)paramViewGroup.jUt.getTextSize();
          k = m.xP();
          paramView = localae.field_username;
          ap.yY();
          if (u.f((Integer)c.vr().get(17, null)) != 1) {
            break label1129;
          }
          paramInt = 1;
          label521:
          if ((!paramView.equals("qqmail")) || (paramInt != 0)) {
            break label1134;
          }
          paramView = this.context.getString(R.l.eTq);
          label546:
          ((a)localObject2).war = paramView;
          if ((com.tencent.mm.u.o.dH(localae.field_username)) && (j.eC(localae.field_username) == 0)) {
            ((a)localObject2).nickName = this.context.getString(R.l.dVj);
          }
        }
        switch (localae.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          label634:
          ((a)localObject2).was = paramInt;
          this.vtF.put(localae.field_username + localae.field_content, localObject2);
          paramView = (View)localObject2;
          paramViewGroup.jUt.setTextColor(this.vtE[i]);
          paramViewGroup.jUr.setText(paramView.nickName);
          paramViewGroup.jUs.setText(paramView.waq);
          paramViewGroup.jUt.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, paramView.war.toString(), paramViewGroup.jUt.getTextSize()));
          if (localae.field_conversationTime == 0L)
          {
            paramViewGroup.jUs.setVisibility(8);
            label764:
            paramViewGroup.vtM.setVisibility(8);
            if (com.tencent.mm.u.o.dH(localae.field_username))
            {
              ap.yY();
              paramView = c.wR().Rb(localae.field_username);
              if ((paramView != null) && (paramView.gkp == 0)) {
                paramViewGroup.vtM.setVisibility(0);
              }
            }
            com.tencent.mm.pluginsdk.ui.a.b.a(paramViewGroup.ipb, localae.field_username);
            if (this.vZV)
            {
              if (localae.field_unReadCount <= 100) {
                break label1320;
              }
              paramViewGroup.jUv.setText("...");
              paramViewGroup.jUv.setVisibility(0);
            }
            label868:
            if (ap.zb())
            {
              if (!com.tencent.mm.u.o.a(localae))
              {
                ap.yY();
                if (c.wW().g(localae))
                {
                  ap.yY();
                  c.wW().f(localae);
                }
              }
              ap.yY();
              if (c.wW().g(localae)) {
                break label1375;
              }
              ((View)localObject1).findViewById(R.h.bGC).setBackgroundResource(R.g.ben);
            }
            label945:
            paramView = new qk();
            paramView.fXk.fXm = true;
            com.tencent.mm.sdk.b.a.uql.m(paramView);
            if ((0L != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localae, 7, 0L)) && (!localae.field_username.equals(paramView.fXl.fXo)))
            {
              localae.t(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(localae, 6, localae.field_conversationTime));
              ap.yY();
              c.wW().a(localae, localae.field_username);
            }
            if ((l.a.szL != null) && (l.a.szL.Hp(localae.field_username))) {
              break label1392;
            }
            paramViewGroup.vtN.setVisibility(8);
          }
          break;
        }
      }
      for (;;)
      {
        GMTrace.o(2843402567680L, 21185);
        return (View)localObject1;
        paramViewGroup = (c)paramView.getTag();
        localObject1 = paramView;
        break;
        label1094:
        if (localae.field_conversationTime == Long.MAX_VALUE)
        {
          paramView = "";
          break label469;
        }
        paramView = com.tencent.mm.pluginsdk.j.o.c(this.context, localae.field_conversationTime, true);
        break label469;
        label1129:
        paramInt = 0;
        break label521;
        label1134:
        ap.yY();
        ay localay = c.wZ().AF("@t.qq.com");
        if ((localay != null) && (localay.isEnable())) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("tmessage")) || (paramInt != 0)) {
            break label1199;
          }
          paramView = this.context.getString(R.l.eTq);
          break;
        }
        label1199:
        if ((k & 0x40) != 0) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!paramView.equals("qmessage")) || (paramInt != 0)) {
            break label1242;
          }
          paramView = this.context.getString(R.l.eTq);
          break;
        }
        label1242:
        paramView = com.tencent.mm.pluginsdk.ui.d.h.c(this.context, com.tencent.mm.booter.notification.a.h.a(localae.field_isSend, localae.field_username, localae.field_content, rV(localae.field_msgType), this.context), j);
        break label546;
        paramInt = -1;
        break label634;
        paramInt = R.k.dxE;
        break label634;
        paramInt = -1;
        break label634;
        paramInt = R.k.dxD;
        break label634;
        paramViewGroup.jUs.setVisibility(0);
        break label764;
        label1320:
        if (localae.field_unReadCount > 0)
        {
          paramViewGroup.jUv.setText(localae.field_unReadCount);
          paramViewGroup.jUv.setVisibility(0);
          break label868;
        }
        paramViewGroup.jUv.setVisibility(4);
        break label868;
        label1375:
        ((View)localObject1).findViewById(R.h.bGC).setBackgroundResource(R.g.bem);
        break label945;
        label1392:
        paramViewGroup.vtN.setVisibility(0);
        if (localae.field_username.equals(paramView.fXl.fXo)) {
          paramViewGroup.vtN.setImageResource(R.k.dzH);
        } else {
          paramViewGroup.vtN.setImageResource(R.k.dzG);
        }
      }
    }
  }
  
  public final void yB(String paramString)
  {
    GMTrace.i(2843805220864L, 21188);
    this.isc = paramString;
    aEP();
    OL();
    GMTrace.o(2843805220864L, 21188);
  }
  
  private final class a
  {
    public CharSequence nickName;
    public CharSequence waq;
    public CharSequence war;
    public int was;
    
    public a()
    {
      GMTrace.i(2846892228608L, 21211);
      GMTrace.o(2846892228608L, 21211);
    }
  }
  
  public static abstract interface b {}
  
  public static final class c
  {
    public ImageView ipb;
    public TextView jUr;
    public TextView jUs;
    public TextView jUt;
    public TextView jUv;
    public ImageView vtM;
    public ImageView vtN;
    
    public c()
    {
      GMTrace.i(2848368623616L, 21222);
      GMTrace.o(2848368623616L, 21222);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/voicesearch/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */