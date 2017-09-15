package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.lp;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelmulti.b.a;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public final class f
  implements View.OnCreateContextMenuListener, AdapterView.OnItemLongClickListener
{
  public Activity activity;
  public String fJC;
  private n.d nwm;
  public ae vUE;
  private g vZM;
  private ListView vZj;
  private int[] waF;
  
  public f(g paramg, ListView paramListView, Activity paramActivity, int[] paramArrayOfInt)
  {
    GMTrace.i(14681808830464L, 109388);
    this.fJC = "";
    this.vUE = null;
    this.waF = new int[2];
    this.nwm = new n.d()
    {
      public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        GMTrace.i(14515647283200L, 108150);
        paramAnonymousInt = -1;
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          if (paramAnonymousInt > 0)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(11090, new Object[] { Integer.valueOf(paramAnonymousInt) });
            v.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          }
          GMTrace.o(14515647283200L, 108150);
          return;
          paramAnonymousMenuItem = f.this.fJC;
          Object localObject2 = f.this.activity;
          Object localObject3 = f.this.vUE;
          Object localObject1 = new PBool();
          if (o.dH(paramAnonymousMenuItem))
          {
            ap.yY();
            localObject3 = com.tencent.mm.u.c.wT().Af(paramAnonymousMenuItem);
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.d(paramAnonymousMenuItem, ((ce)localObject3).field_msgSvrId));
            ((PBool)localObject1).value = false;
            ((Context)localObject2).getString(R.l.dIG);
            localObject2 = com.tencent.mm.ui.base.g.a((Context)localObject2, ((Context)localObject2).getString(R.l.dIV), true, new b.1((PBool)localObject1));
            if (com.tencent.mm.u.i.er(paramAnonymousMenuItem)) {
              q.HA().a(new b.a(paramAnonymousMenuItem, 0, 0, 0, 0));
            }
            ay.a(paramAnonymousMenuItem, new b.2((PBool)localObject1, (ProgressDialog)localObject2, paramAnonymousMenuItem));
          }
          for (;;)
          {
            if (!o.fc(paramAnonymousMenuItem)) {
              break label1136;
            }
            v.d("MicroMsg.ConvDelLogic", "del all qmessage");
            ay.zp();
            ap.yY();
            com.tencent.mm.u.c.wW().An("@qqim");
            paramAnonymousInt = 1;
            break;
            if (o.fl(paramAnonymousMenuItem))
            {
              ap.yY();
              com.tencent.mm.u.c.wW().An(paramAnonymousMenuItem);
              localObject1 = new lp();
              ((lp)localObject1).fSx.opType = 4;
              ((lp)localObject1).fSx.fSC = 20;
              com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            }
            else if (o.fb(paramAnonymousMenuItem))
            {
              ap.yY();
              com.tencent.mm.u.c.wW().An(paramAnonymousMenuItem);
            }
            else if (o.fe(paramAnonymousMenuItem))
            {
              ap.yY();
              com.tencent.mm.u.c.wW().Rk(paramAnonymousMenuItem);
            }
            else if (e.dr(paramAnonymousMenuItem))
            {
              ((PBool)localObject1).value = false;
              ((Context)localObject2).getString(R.l.dIG);
              ay.a(paramAnonymousMenuItem, new b.4((PBool)localObject1, com.tencent.mm.ui.base.g.a((Context)localObject2, ((Context)localObject2).getString(R.l.dIV), true, new b.3((PBool)localObject1)), paramAnonymousMenuItem));
            }
            else
            {
              ap.yY();
              au localau = com.tencent.mm.u.c.wT().Af(paramAnonymousMenuItem);
              ap.yY();
              com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.d(paramAnonymousMenuItem, localau.field_msgSvrId));
              ((PBool)localObject1).value = false;
              ((Context)localObject2).getString(R.l.dIG);
              ay.a(paramAnonymousMenuItem, new b.6((PBool)localObject1, com.tencent.mm.ui.base.g.a((Context)localObject2, ((Context)localObject2).getString(R.l.dIV), true, new b.5((PBool)localObject1))));
              ap.yY();
              localObject1 = com.tencent.mm.u.c.wR().Rb(paramAnonymousMenuItem);
              ((x)localObject1).tj();
              ((x)localObject1).tk();
              if ((((x)localObject1).bKU()) && (e.hX(paramAnonymousMenuItem))) {
                com.tencent.mm.plugin.report.service.g.oSF.i(13773, new Object[] { Integer.valueOf(0), Integer.valueOf(((aj)localObject3).field_unReadCount), Integer.valueOf(1), ((aj)localObject3).field_username });
              }
              localObject2 = new amb();
              v.i("MicroMsg.ConvDelLogic", "oplog modContact user:%s remark:%s type:%d ", new Object[] { ((af)localObject1).field_username, ((af)localObject1).field_conRemark, Integer.valueOf(((af)localObject1).field_type) });
              ((amb)localObject2).trH = new avu().OU(u.mz(((af)localObject1).field_username));
              ((amb)localObject2).tJy = new avu().OU(u.mz(((af)localObject1).field_nickname));
              ((amb)localObject2).trx = new avu().OU(u.mz(((x)localObject1).pB()));
              ((amb)localObject2).jdField_try = new avu().OU(u.mz(((x)localObject1).pC()));
              ((amb)localObject2).hAl = ((af)localObject1).gkh;
              ((amb)localObject2).tqP = 561023;
              ((amb)localObject2).tqQ = ((af)localObject1).field_type;
              ((amb)localObject2).tOz = new avu().OU(u.mz(((af)localObject1).field_conRemark));
              ((amb)localObject2).tOA = new avu().OU(u.mz(((af)localObject1).field_conRemarkPYShort));
              ((amb)localObject2).tOB = new avu().OU(u.mz(((af)localObject1).field_conRemarkPYFull));
              ((amb)localObject2).tqV = ((af)localObject1).gkm;
              ((amb)localObject2).tOT = new avu().OU(u.mz(((af)localObject1).field_domainList));
              ((amb)localObject2).tqZ = ((af)localObject1).gkp;
              ((amb)localObject2).hAp = ((af)localObject1).gkq;
              ((amb)localObject2).hAo = u.mz(((af)localObject1).signature);
              ((amb)localObject2).hAn = u.mz(((x)localObject1).getCityCode());
              ((amb)localObject2).hAm = u.mz(((x)localObject1).bKY());
              ((amb)localObject2).tLf = u.mz(((af)localObject1).gkv);
              ((amb)localObject2).tLh = ((af)localObject1).field_weiboFlag;
              ((amb)localObject2).tOP = 0;
              ((amb)localObject2).tdB = new avt();
              ((amb)localObject2).hAu = u.mz(((x)localObject1).getCountryCode());
              ap.yY();
              com.tencent.mm.u.c.wQ().b(new e.a(2, (com.tencent.mm.bd.a)localObject2));
              ap.yY();
              com.tencent.mm.u.c.wR().a(paramAnonymousMenuItem, (x)localObject1);
              ap.yY();
              localObject2 = com.tencent.mm.u.c.wW().Rl(paramAnonymousMenuItem);
              ap.yY();
              com.tencent.mm.u.c.wW().Rk(paramAnonymousMenuItem);
              if ((localObject2 != null) && ((((ae)localObject2).eC(4194304)) || ((((x)localObject1).bKU()) && (!com.tencent.mm.j.a.ez(((af)localObject1).field_type)) && (((aj)localObject2).field_conversationTime < w.DT()))))
              {
                localObject1 = new com.tencent.mm.modelsimple.i(paramAnonymousMenuItem);
                ap.vd().a((k)localObject1, 0);
              }
            }
          }
          label1136:
          if (o.fa(paramAnonymousMenuItem))
          {
            v.d("MicroMsg.ConvDelLogic", "del all tmessage");
            ay.zq();
            ap.yY();
            com.tencent.mm.u.c.wW().An("@t.qq.com");
          }
          paramAnonymousInt = 1;
          continue;
          paramAnonymousInt = 4;
          v.d("MicroMsg.ConversationClickListener", "placed to the top");
          o.l(f.this.fJC, true);
          ap.yY();
          paramAnonymousMenuItem = com.tencent.mm.u.c.wR().Rb(f.this.fJC);
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.bKU())) {
            com.tencent.mm.plugin.report.service.g.oSF.i(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
          }
          com.tencent.mm.ui.base.g.bk(f.this.activity, f.this.activity.getString(R.l.eyT));
          com.tencent.mm.modelstat.b.hTV.b(true, f.this.fJC, true);
          continue;
          paramAnonymousInt = 5;
          v.d("MicroMsg.ConversationClickListener", "unplaced to the top");
          o.m(f.this.fJC, true);
          ap.yY();
          paramAnonymousMenuItem = com.tencent.mm.u.c.wR().Rb(f.this.fJC);
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.bKU())) {
            com.tencent.mm.plugin.report.service.g.oSF.i(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
          }
          com.tencent.mm.ui.base.g.bk(f.this.activity, f.this.activity.getString(R.l.eyU));
          com.tencent.mm.modelstat.b.hTV.b(true, f.this.fJC, false);
          continue;
          paramAnonymousInt = 3;
          v.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[] { f.this.fJC });
          ap.yY();
          com.tencent.mm.u.c.wW().Rn(f.this.fJC);
          MMAppMgr.cancelNotification(f.this.fJC);
          ag.C(f.this.fJC, 1);
          com.tencent.mm.modelstat.b.hTV.A(f.this.fJC, false);
          continue;
          paramAnonymousInt = 2;
          v.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[] { f.this.fJC });
          ap.yY();
          com.tencent.mm.u.c.wW().Ro(f.this.fJC);
          com.tencent.mm.modelstat.b.hTV.A(f.this.fJC, true);
          continue;
          v.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[] { f.this.fJC });
          f.this.fJC.endsWith("@chatroom");
          paramAnonymousMenuItem = f.this.fJC;
          localObject1 = f.this.activity;
          localObject2 = new PBool();
          ((PBool)localObject2).value = false;
          ((Context)localObject1).getString(R.l.dIG);
          ay.a(paramAnonymousMenuItem, new b.8((PBool)localObject2, com.tencent.mm.ui.base.g.a((Context)localObject1, ((Context)localObject1).getString(R.l.dIV), true, new b.7((PBool)localObject2))));
          continue;
          v.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[] { f.this.fJC });
          ap.yY();
          paramAnonymousMenuItem = com.tencent.mm.u.c.wR().Rb(f.this.fJC);
          com.tencent.mm.ui.tools.b.a(e.hW(f.this.fJC), f.this.activity, paramAnonymousMenuItem, 1);
        }
      }
    };
    this.vZM = paramg;
    this.vZj = paramListView;
    this.activity = paramActivity;
    this.waF = paramArrayOfInt;
    GMTrace.o(14681808830464L, 109388);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    int j = 1;
    GMTrace.i(14488803737600L, 107950);
    ap.yY();
    x localx = com.tencent.mm.u.c.wR().Rb(this.fJC);
    if (localx == null)
    {
      v.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.fJC);
      GMTrace.o(14488803737600L, 107950);
      return;
    }
    String str = localx.tL();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (u.mA(localx.field_nickname)) {
        paramView = this.activity.getString(R.l.dVj);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(h.a(this.activity, paramView));
    int i;
    if (this.vUE != null)
    {
      i = 1;
      if ((i & o.b(this.vUE)) != 0)
      {
        paramView = this.fJC;
        ap.yY();
        paramView = com.tencent.mm.u.c.wW().Rl(paramView);
        if (paramView == null) {
          break label422;
        }
        if ((paramView.field_unReadCount > 0) || (paramView.eC(1048576))) {
          break label416;
        }
        i = j;
        label201:
        if (i == 0) {
          break label428;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 8, 0, R.l.eyR);
      }
      label223:
      if ((this.vUE != null) && (o.a(this.vUE)))
      {
        ap.yY();
        if (!com.tencent.mm.u.c.wW().Rs(this.fJC)) {
          break label448;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 6, 0, R.l.eyS);
      }
    }
    for (;;)
    {
      if ((localx.bKU()) && (com.tencent.mm.j.a.ez(localx.field_type)) && (!o.fF(localx.field_username)) && (!o.fh(localx.field_username)))
      {
        paramView = e.hW(localx.field_username);
        if ((paramView != null) && (paramView.CE())) {
          paramContextMenu.add(paramContextMenuInfo.position, 10, 0, R.l.eyO);
        }
      }
      if ((this.vUE == null) || (this.vUE.field_conversationTime == -1L)) {
        break label545;
      }
      if (!o.fa(this.fJC)) {
        break label494;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.eyX);
      GMTrace.o(14488803737600L, 107950);
      return;
      i = 0;
      break;
      label416:
      i = 0;
      break label201;
      label422:
      i = 0;
      break label201;
      label428:
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.eyP);
      break label223;
      label448:
      if (localx.bKU()) {
        paramContextMenu.add(paramContextMenuInfo.position, 5, 0, R.l.eac);
      } else {
        paramContextMenu.add(paramContextMenuInfo.position, 5, 0, R.l.eyQ);
      }
    }
    label494:
    if (o.fb(this.fJC))
    {
      paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.eyW);
      GMTrace.o(14488803737600L, 107950);
      return;
    }
    paramContextMenu.add(paramContextMenuInfo.position, 4, 0, R.l.eyV);
    label545:
    GMTrace.o(14488803737600L, 107950);
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GMTrace.i(14488669519872L, 107949);
    if (paramInt < this.vZj.getHeaderViewsCount())
    {
      v.d("MicroMsg.ConversationClickListener", "on long click header view");
      GMTrace.o(14488669519872L, 107949);
      return true;
    }
    this.vUE = ((ae)this.vZM.yL(paramInt - this.vZj.getHeaderViewsCount()));
    if (this.vUE == null)
    {
      v.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[] { Integer.valueOf(this.vZj.getHeaderViewsCount()), Integer.valueOf(paramInt) });
      GMTrace.o(14488669519872L, 107949);
      return true;
    }
    this.fJC = this.vUE.field_username;
    new com.tencent.mm.ui.widget.g(this.activity).a(paramView, paramInt, paramLong, this, this.nwm, this.waF[0], this.waF[1]);
    GMTrace.o(14488669519872L, 107949);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */