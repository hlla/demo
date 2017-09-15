package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.av.f;
import com.tencent.mm.av.g;
import com.tencent.mm.e.a.fh;
import com.tencent.mm.e.a.fh.b;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.x.n;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends RelativeLayout
{
  public static Boolean vVH;
  private Context context;
  private boolean isVisible;
  private View llc;
  private View vVI;
  private final ai vVJ;
  j.a vVK;
  boolean vVL;
  
  static
  {
    GMTrace.i(1715705217024L, 12783);
    vVH = Boolean.valueOf(true);
    GMTrace.o(1715705217024L, 12783);
  }
  
  public k(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(1714363039744L, 12773);
    this.context = null;
    this.llc = null;
    this.vVI = null;
    this.isVisible = true;
    this.vVJ = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(1788451225600L, 13325);
        v.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
        k.bXO();
        k.a(k.this);
        GMTrace.o(1788451225600L, 13325);
        return false;
      }
    }, true);
    this.vVK = new j.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.l paramAnonymousl)
      {
        GMTrace.i(1812073545728L, 13501);
        v.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
        if (!k.b(k.this).bJg()) {
          k.b(k.this).KI();
        }
        paramAnonymousString = k.b(k.this);
        if (k.c(k.this)) {}
        for (long l = 500L;; l = 1000L)
        {
          paramAnonymousString.v(l, l);
          GMTrace.o(1812073545728L, 13501);
          return;
        }
      }
    };
    this.vVL = false;
    this.context = paramContext;
    com.tencent.mm.av.l.Kz().c(this.vVK);
    bXM();
    init();
    GMTrace.o(1714363039744L, 12773);
  }
  
  private static void bXM()
  {
    GMTrace.i(1714765692928L, 12776);
    int i = com.tencent.mm.av.l.Kz().Kn();
    v.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      ap.yY();
      com.tencent.mm.u.c.vr().set(143618, Integer.valueOf(i));
    }
    GMTrace.o(1714765692928L, 12776);
  }
  
  public static void bXN()
  {
    GMTrace.i(1714899910656L, 12777);
    ap.yY();
    if (com.tencent.mm.u.c.wM())
    {
      ap.yY();
      if (com.tencent.mm.u.c.vr().getInt(143618, 0) > 0) {
        ag.C("fmessage", 2);
      }
    }
    ap.yY();
    com.tencent.mm.u.c.vr().set(143618, Integer.valueOf(0));
    GMTrace.o(1714899910656L, 12777);
  }
  
  private void init()
  {
    GMTrace.i(1714497257472L, 12774);
    Object localObject2 = com.tencent.mm.av.l.Kz();
    v.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", new Object[] { Integer.valueOf(4) });
    Object localObject1 = new ArrayList();
    Object localObject3 = "select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4";
    localObject2 = ((com.tencent.mm.av.c)localObject2).gUp.a((String)localObject3, null, 2);
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new com.tencent.mm.av.b();
      ((com.tencent.mm.av.b)localObject3).b((Cursor)localObject2);
      if (!bf.mA(((com.tencent.mm.av.b)localObject3).field_talker)) {
        ((List)localObject1).add(localObject3);
      }
    }
    ((Cursor)localObject2).close();
    int i = ((List)localObject1).size();
    v.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[] { Integer.valueOf(i) });
    removeAllViews();
    if (i <= 0) {
      if (this.context == null)
      {
        v.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
        localObject1 = this.llc.findViewById(R.h.bQi);
        if (localObject1 != null) {
          if (!this.isVisible) {
            break label1345;
          }
        }
      }
    }
    label494:
    label585:
    label737:
    label742:
    label971:
    label1033:
    label1345:
    for (i = 0;; i = 8)
    {
      ((View)localObject1).setVisibility(i);
      this.vVI.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(1837843349504L, 13693);
          if ((k.d(k.this) instanceof MMActivity)) {
            ((MMActivity)k.d(k.this)).aGY();
          }
          GMTrace.o(1837843349504L, 13693);
          return false;
        }
      });
      i = com.tencent.mm.av.l.Kz().Kn();
      v.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[] { Integer.valueOf(i) });
      localObject1 = (TextView)this.llc.findViewById(R.h.bQp);
      ((TextView)localObject1).setBackgroundResource(s.fg(this.context));
      if (i > 0) {
        break label1351;
      }
      ((TextView)localObject1).setVisibility(8);
      vVH = Boolean.valueOf(false);
      GMTrace.o(1714497257472L, 12774);
      return;
      this.llc = View.inflate(this.context, R.i.dcY, this);
      this.vVI = this.llc.findViewById(R.h.bQr);
      localObject1 = this.vVI.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.bg.a.U(this.context, R.f.aWL) * com.tencent.mm.bg.a.dL(this.context)));
      this.vVI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.llc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1745904205824L, 13008);
          v.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
          com.tencent.mm.bb.d.b(k.d(k.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
          GMTrace.o(1745904205824L, 13008);
        }
      });
      localObject1 = (MaskLayout)this.llc.findViewById(R.h.bQd);
      n.Bl();
      localObject2 = com.tencent.mm.x.d.hm("fmessage");
      ((ImageView)((MaskLayout)localObject1).view).setImageBitmap((Bitmap)localObject2);
      break;
      if (i == 1)
      {
        localObject2 = (com.tencent.mm.av.b)((List)localObject1).get(0);
        if (this.context == null)
        {
          v.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
          break;
        }
        Object localObject4;
        Context localContext;
        boolean bool;
        if (com.tencent.mm.bg.a.dM(this.context))
        {
          this.llc = View.inflate(this.context, R.i.ddb, this);
          ((TextView)this.llc.findViewById(R.h.bQw)).setText(h.a(this.context, ((com.tencent.mm.av.b)localObject2).field_displayName));
          localObject3 = (TextView)this.llc.findViewById(R.h.bQv);
          localObject4 = com.tencent.mm.av.l.Ky().lb(((com.tencent.mm.av.b)localObject2).field_talker);
          localContext = this.context;
          i = ((f)localObject4).field_type;
          int j = ((com.tencent.mm.av.b)localObject2).field_addScene;
          localObject1 = ((f)localObject4).field_msgContent;
          if (((f)localObject4).Kq()) {
            break label737;
          }
          bool = true;
          v.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject1, Boolean.valueOf(bool) });
          if (i != 0) {
            break label971;
          }
          if (localObject1 != null) {
            break label742;
          }
          v.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
          localObject1 = null;
          if (!u.mA((String)localObject1)) {
            break label1033;
          }
          ((TextView)localObject3).setVisibility(8);
        }
        for (;;)
        {
          this.vVI = this.llc.findViewById(R.h.bQi);
          this.llc.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              GMTrace.i(1740267061248L, 12966);
              v.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
              ap.yY();
              com.tencent.mm.u.c.vr().set(143618, Integer.valueOf(0));
              com.tencent.mm.bb.d.b(k.d(k.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
              GMTrace.o(1740267061248L, 12966);
            }
          });
          a.b.a((ImageView)((MaskLayout)this.llc.findViewById(R.h.bQd)).view, ((com.tencent.mm.av.b)localObject2).field_talker);
          break;
          this.llc = View.inflate(this.context, R.i.dda, this);
          break label494;
          bool = false;
          break label585;
          localObject1 = au.a.RE((String)localObject1);
          switch (((au.a)localObject1).scene)
          {
          default: 
            localObject1 = localContext.getString(R.l.dTr);
            break;
          case 4: 
            localObject1 = localContext.getString(R.l.dTm);
            break;
          case 10: 
          case 11: 
            localObject4 = new fh();
            ((fh)localObject4).fJI.fJF = ((au.a)localObject1).uIi;
            ((fh)localObject4).fJI.fJG = ((au.a)localObject1).uIj;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject4);
            localObject1 = localContext.getString(R.l.dTp, new Object[] { bf.ap(((fh)localObject4).fJJ.fJK, "") });
            break;
          case 31: 
            localObject1 = localContext.getString(R.l.dTy);
            break;
          case 32: 
            localObject1 = localContext.getString(R.l.dTs);
            break;
          case 58: 
          case 59: 
          case 60: 
            localObject1 = localContext.getString(R.l.dTn);
            break;
            if (bool) {
              break;
            }
            localObject1 = au.d.RH((String)localObject1);
            if ((((au.d)localObject1).content != null) && (!((au.d)localObject1).content.trim().equals("")))
            {
              localObject1 = ((au.d)localObject1).content;
              break;
            }
            localObject1 = localContext.getString(R.l.ekR);
            break;
            ((TextView)localObject3).setText((CharSequence)localObject1);
          }
        }
      }
      if (this.context == null)
      {
        v.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
        break;
      }
      this.llc = View.inflate(this.context, R.i.dcZ, this);
      i = ((List)localObject1).size();
      v.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[] { Integer.valueOf(i) });
      localObject2 = (com.tencent.mm.av.b)((List)localObject1).get(0);
      localObject3 = (MaskLayout)this.llc.findViewById(R.h.bQd);
      a.b.a((ImageView)((MaskLayout)localObject3).view, ((com.tencent.mm.av.b)localObject2).field_talker);
      ((MaskLayout)localObject3).setVisibility(0);
      localObject2 = (com.tencent.mm.av.b)((List)localObject1).get(1);
      localObject3 = (MaskLayout)this.llc.findViewById(R.h.bQe);
      a.b.a((ImageView)((MaskLayout)localObject3).view, ((com.tencent.mm.av.b)localObject2).field_talker);
      ((MaskLayout)localObject3).setVisibility(0);
      if (i > 2)
      {
        localObject2 = (com.tencent.mm.av.b)((List)localObject1).get(2);
        localObject3 = (MaskLayout)this.llc.findViewById(R.h.bQf);
        a.b.a((ImageView)((MaskLayout)localObject3).view, ((com.tencent.mm.av.b)localObject2).field_talker);
        ((MaskLayout)localObject3).setVisibility(0);
      }
      if (i > 3)
      {
        localObject1 = (com.tencent.mm.av.b)((List)localObject1).get(3);
        localObject2 = (MaskLayout)this.llc.findViewById(R.h.bQg);
        a.b.a((ImageView)((MaskLayout)localObject2).view, ((com.tencent.mm.av.b)localObject1).field_talker);
        ((MaskLayout)localObject2).setVisibility(0);
      }
      this.vVI = this.llc.findViewById(R.h.bQi);
      this.vVI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1777176936448L, 13241);
          v.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
          ap.yY();
          com.tencent.mm.u.c.vr().set(143618, Integer.valueOf(0));
          com.tencent.mm.bb.d.b(k.d(k.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
          GMTrace.o(1777176936448L, 13241);
        }
      });
      break;
    }
    label1351:
    ((TextView)localObject1).setVisibility(0);
    vVH = Boolean.valueOf(true);
    if (i > 99)
    {
      ((TextView)localObject1).setText(getContext().getString(R.l.eYH));
      GMTrace.o(1714497257472L, 12774);
      return;
    }
    ((TextView)localObject1).setText(String.valueOf(i));
    GMTrace.o(1714497257472L, 12774);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */