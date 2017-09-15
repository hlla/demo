package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.c.a;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.a;
import com.tencent.mm.e.a.cb.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.snackbar.b.c;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.k;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class da
  implements dx
{
  public static aq vEf;
  public x fOB;
  public com.tencent.mm.ui.tools.l iLr;
  public p kuK;
  Animation puq;
  public boolean vDz;
  public ChattingFooterMoreBtnBar vEg;
  public dc vEh;
  private ChatFooterCustom vEi;
  public boolean vEj;
  public boolean vvA;
  public En_5b8fbb1e.a vzE;
  public cv vzF;
  private ChatFooter vzG;
  boolean vzI;
  
  static
  {
    GMTrace.i(2230295986176L, 16617);
    vEf = new aq(5, "MicroMsg.ChattingMoreBtnBarHelper");
    GMTrace.o(2230295986176L, 16617);
  }
  
  public da(En_5b8fbb1e.a parama, ChattingFooterMoreBtnBar paramChattingFooterMoreBtnBar, cv paramcv, ChatFooter paramChatFooter, ChatFooterCustom paramChatFooterCustom, x paramx, boolean paramBoolean)
  {
    GMTrace.i(2227611631616L, 16597);
    this.vDz = false;
    this.vzI = false;
    this.vEj = true;
    this.vzE = parama;
    this.vEg = paramChattingFooterMoreBtnBar;
    this.vzG = paramChatFooter;
    this.vEi = paramChatFooterCustom;
    this.vzF = paramcv;
    b(paramx, paramBoolean);
    this.puq = AnimationUtils.loadAnimation(parama.uRf.uRz, R.a.aRq);
    if (this.vzI) {
      v.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
    }
    for (;;)
    {
      this.vEg.c(3, new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          GMTrace.i(2505979199488L, 18671);
          if (da.this.vzF.vDC.size() == 0)
          {
            v.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
            GMTrace.o(2505979199488L, 18671);
            return;
          }
          paramAnonymousView = da.this.vzE.uRf.uRz;
          com.tencent.mm.ui.base.g.a(paramAnonymousView, paramAnonymousView.getString(R.l.dWV), "", paramAnonymousView.getString(R.l.ebn), paramAnonymousView.getString(R.l.dGk), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(2513763827712L, 18729);
              v.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
              z.a(paramAnonymousView, da.this.vzF.vDC, da.this);
              da.this.bUs();
              GMTrace.o(2513763827712L, 18729);
            }
          }, null, R.e.aSJ);
          GMTrace.o(2505979199488L, 18671);
        }
      });
      this.vEg.c(2, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2212847681536L, 16487);
          if (da.this.vzF.vDC.size() == 0)
          {
            v.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
            GMTrace.o(2212847681536L, 16487);
            return;
          }
          ac.a(da.this.vzE, da.this.bUr(), da.this.vvA, da.this, da.this.fOB);
          GMTrace.o(2212847681536L, 16487);
        }
      });
      this.vEg.c(1, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2484772798464L, 18513);
          if (da.this.vzF.vDC.size() == 0)
          {
            v.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
            GMTrace.o(2484772798464L, 18513);
            return;
          }
          paramAnonymousView = da.this.bUr();
          if (aa.cx(paramAnonymousView))
          {
            com.tencent.mm.ui.base.g.a(da.this.vzE.uRf.uRz, da.this.vzE.uRf.uRz.getString(R.l.eaz), "", da.this.vzE.uRf.uRz.getString(R.l.dAD), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(2185198829568L, 16281);
                GMTrace.o(2185198829568L, 16281);
              }
            });
            GMTrace.o(2484772798464L, 18513);
            return;
          }
          if (aa.cy(paramAnonymousView))
          {
            com.tencent.mm.ui.base.g.a(da.this.vzE.uRf.uRz, da.this.vzE.uRf.uRz.getString(R.l.eaA), "", da.this.vzE.uRf.uRz.getString(R.l.dAD), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(2142383374336L, 15962);
                GMTrace.o(2142383374336L, 15962);
              }
            });
            GMTrace.o(2484772798464L, 18513);
            return;
          }
          if (aa.cw(paramAnonymousView))
          {
            com.tencent.mm.ui.base.g.a(da.this.vzE.uRf.uRz, da.this.vzE.uRf.uRz.getString(R.l.eaB), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(2201304956928L, 16401);
                GMTrace.o(2201304956928L, 16401);
              }
            }, null);
            GMTrace.o(2484772798464L, 18513);
            return;
          }
          if (ad.a(da.this.vzE, paramAnonymousView, da.this.fOB)) {
            da.this.bUs();
          }
          GMTrace.o(2484772798464L, 18513);
        }
      });
      this.vEg.c(0, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2115674046464L, 15763);
          if (da.this.vzF.vDC.size() == 0)
          {
            v.w("MicroMsg.ChattingMoreBtnBarHelper", "ignore click del btn, selected items count is 0");
            GMTrace.o(2115674046464L, 15763);
            return;
          }
          if (((o.eV(da.this.fOB.field_username)) && (!com.tencent.mm.modelbiz.e.dr(da.this.fOB.field_username))) || (o.fF(da.this.fOB.field_username)))
          {
            da.this.vEj = true;
            ab.a(da.this.vzE.uRf.uRz, da.this.bUr(), da.this.vvA, da.this.fOB.field_username, da.this);
            GMTrace.o(2115674046464L, 15763);
            return;
          }
          da.this.iLr.b(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
          {
            public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
            {
              GMTrace.i(2529869955072L, 18849);
              paramAnonymous2ContextMenu.add(0, 0, 0, R.l.eBu);
              paramAnonymous2ContextMenu.add(0, 1, 1, R.l.eBv);
              if (WWAPIFactory.hM(da.this.vzE.uRf.uRz).chH()) {
                paramAnonymous2ContextMenu.add(0, 2, 2, da.this.vzE.uRf.uRz.getString(R.l.eBw, new Object[] { WWAPIFactory.hM(da.this.vzE.uRf.uRz).chI() }));
              }
              GMTrace.o(2529869955072L, 18849);
            }
          }, new n.d()
          {
            public final void c(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              GMTrace.i(2511079473152L, 18709);
              Object localObject;
              if (paramAnonymous2MenuItem.getItemId() == 0)
              {
                da.this.vEj = true;
                paramAnonymous2MenuItem = da.this;
                localObject = paramAnonymous2MenuItem.bUr();
                new com.tencent.mm.sdk.platformtools.ad().post(new da.8(paramAnonymous2MenuItem, (List)localObject));
              }
              for (;;)
              {
                ab.a(da.this.vzE.uRf.uRz, da.this.bUr(), da.this.vvA, da.this.fOB.field_username, da.this);
                GMTrace.o(2511079473152L, 18709);
                return;
                if (2 == paramAnonymous2MenuItem.getItemId())
                {
                  paramAnonymous2MenuItem = da.this.vzE.uRf.uRz;
                  localObject = da.this.fOB;
                  List localList = da.this.bUr();
                  boolean bool = da.this.vvA;
                  if (localList.size() != 0)
                  {
                    if (!aa.cw(localList)) {
                      break label262;
                    }
                    v.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
                    com.tencent.mm.ui.base.g.a(paramAnonymous2MenuItem, paramAnonymous2MenuItem.getString(R.l.eaC), "", new eg.1(), null);
                  }
                  for (;;)
                  {
                    da.this.bUs();
                    GMTrace.o(2511079473152L, 18709);
                    return;
                    label262:
                    if (!aa.a(localList, null))
                    {
                      v.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
                      com.tencent.mm.ui.base.g.b(paramAnonymous2MenuItem, paramAnonymous2MenuItem.getString(R.l.esB), "", paramAnonymous2MenuItem.getString(R.l.eLz), paramAnonymous2MenuItem.getString(R.l.dGk), new eg.2(paramAnonymous2MenuItem, (x)localObject, localList, bool), null);
                    }
                    else
                    {
                      eg.a(paramAnonymous2MenuItem, (x)localObject, localList, bool);
                    }
                  }
                }
                da.this.vEj = false;
              }
            }
          });
          GMTrace.o(2115674046464L, 15763);
        }
      });
      this.vEg.c(4, new View.OnClickListener()
      {
        public static void cz(List<au> paramAnonymousList)
        {
          GMTrace.i(2492423208960L, 18570);
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            au localau = (au)paramAnonymousList.next();
            a.a(a.c.vvo, a.d.vvt, localau, 0);
          }
          GMTrace.o(2492423208960L, 18570);
        }
        
        public final void b(cb paramAnonymouscb)
        {
          GMTrace.i(2492154773504L, 18568);
          paramAnonymouscb.fFr.ov = da.this.vzE;
          paramAnonymouscb.fFr.fFy = 41;
          paramAnonymouscb.fFr.fFA = new b.c()
          {
            public final void azg()
            {
              GMTrace.i(2287875391488L, 17046);
              da.this.bUs();
              da.this.vEg.setVisibility(4);
              GMTrace.o(2287875391488L, 17046);
            }
            
            public final void azh()
            {
              GMTrace.i(2288143826944L, 17048);
              da.this.vzE.bUL();
              GMTrace.o(2288143826944L, 17048);
            }
            
            public final void onHide()
            {
              GMTrace.i(2288009609216L, 17047);
              da.this.bUs();
              GMTrace.o(2288009609216L, 17047);
            }
          };
          com.tencent.mm.sdk.b.a.uql.m(paramAnonymouscb);
          int i;
          Object localObject1;
          long l;
          label90:
          Object localObject2;
          if (paramAnonymouscb.fFs.ret == 0)
          {
            i = 1;
            localObject1 = da.this.bUr();
            l = bf.Nz();
            Iterator localIterator = ((List)localObject1).iterator();
            while (localIterator.hasNext())
            {
              localObject1 = (au)localIterator.next();
              if (((au)localObject1).axH())
              {
                localObject2 = f.a.ek(bf.PW(((ce)localObject1).field_content));
                if ((localObject2 != null) && (((f.a)localObject2).type == 5) && (!bf.mA(((f.a)localObject2).url))) {
                  if (!((au)localObject1).bLN()) {
                    break label658;
                  }
                }
              }
            }
          }
          label658:
          for (int j = 1;; j = 2)
          {
            v.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((f.a)localObject2).url, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(1) });
            localObject1 = "";
            try
            {
              localObject2 = URLEncoder.encode(((f.a)localObject2).url, "UTF-8");
              localObject1 = localObject2;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              for (;;)
              {
                v.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", localUnsupportedEncodingException, "", new Object[0]);
              }
            }
            com.tencent.mm.plugin.report.service.g.oSF.i(13378, new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(i) });
            break label90;
            i = 2;
            break;
            if (paramAnonymouscb.fFs.ret == 0)
            {
              if (14 != paramAnonymouscb.fFr.type)
              {
                v.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
                GMTrace.o(2492154773504L, 18568);
                return;
              }
              if (paramAnonymouscb.fFr.fFu == null)
              {
                v.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
                GMTrace.o(2492154773504L, 18568);
                return;
              }
              com.tencent.mm.plugin.report.service.g.oSF.i(11142, new Object[] { Integer.valueOf(paramAnonymouscb.fFr.fFu.txQ), Integer.valueOf(paramAnonymouscb.fFr.fFu.txR), Integer.valueOf(paramAnonymouscb.fFr.fFu.txS), Integer.valueOf(paramAnonymouscb.fFr.fFu.txT), Integer.valueOf(paramAnonymouscb.fFr.fFu.txU), Integer.valueOf(paramAnonymouscb.fFr.fFu.txV), Integer.valueOf(paramAnonymouscb.fFr.fFu.txW), Integer.valueOf(paramAnonymouscb.fFr.fFu.txX), Integer.valueOf(paramAnonymouscb.fFr.fFu.txY), Integer.valueOf(paramAnonymouscb.fFr.fFu.txZ), Integer.valueOf(paramAnonymouscb.fFr.fFu.tya), Integer.valueOf(paramAnonymouscb.fFr.fFu.tyb), Integer.valueOf(paramAnonymouscb.fFr.fFu.tyc), Integer.valueOf(paramAnonymouscb.fFr.fFu.tyd), Integer.valueOf(paramAnonymouscb.fFr.fFu.tye) });
            }
            GMTrace.o(2492154773504L, 18568);
            return;
          }
        }
        
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2492288991232L, 18569);
          final List localList = da.this.bUr();
          if (aa.cx(localList))
          {
            com.tencent.mm.ui.base.g.a(da.this.vzE.uRf.uRz, da.this.vzE.uRf.uRz.getString(R.l.eih), "", da.this.vzE.uRf.uRz.getString(R.l.dAD), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(2136612012032L, 15919);
                GMTrace.o(2136612012032L, 15919);
              }
            });
            GMTrace.o(2492288991232L, 18569);
            return;
          }
          final cb localcb = new cb();
          v.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[] { da.this.fOB.field_username });
          Object localObject1;
          Object localObject2;
          if (localList.size() == 1)
          {
            paramAnonymousView = (au)localList.get(0);
            if ((paramAnonymousView != null) && ((paramAnonymousView.axH()) || (paramAnonymousView.bLN()) || (paramAnonymousView.bLO())))
            {
              localObject1 = com.tencent.mm.u.q.fQ(paramAnonymousView.field_msgSvrId);
              localObject2 = com.tencent.mm.u.q.yC().n((String)localObject1, true);
              ((q.b)localObject2).l("prePublishId", "msg_" + paramAnonymousView.field_msgSvrId);
              ((q.b)localObject2).l("preUsername", ag.a(paramAnonymousView, da.this.vvA, da.this.vzE.sLe));
              ((q.b)localObject2).l("preChatName", da.this.fOB.field_username);
              ((q.b)localObject2).l("preMsgIndex", Integer.valueOf(0));
              ((q.b)localObject2).l("sendAppMsgScene", Integer.valueOf(1));
              ((com.tencent.mm.plugin.sns.b.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.h.class)).a("adExtStr", (q.b)localObject2, paramAnonymousView);
              localcb.fFr.fFw = ((String)localObject1);
            }
          }
          if (com.tencent.mm.pluginsdk.model.g.a(da.this.vzE.uRf.uRz, localcb, da.this.fOB.field_username, localList, false))
          {
            paramAnonymousView = localList.iterator();
            while (paramAnonymousView.hasNext())
            {
              localObject1 = (au)paramAnonymousView.next();
              if (((au)localObject1).axH()) {
                b.hTV.c((au)localObject1, com.tencent.mm.t.g.g((au)localObject1));
              } else {
                b.hTV.t((au)localObject1);
              }
            }
            b(localcb);
            cz(da.this.bUr());
            GMTrace.o(2492288991232L, 18569);
            return;
          }
          if (da.this.bUr().size() > 1)
          {
            localObject2 = da.this.vzE.uRf.uRz;
            if (localcb.fFr.fFx >= 0)
            {
              paramAnonymousView = da.this.vzE.uRf.uRz.getString(R.l.eig);
              if (localcb.fFr.fFx < 0) {
                break label626;
              }
            }
            label626:
            for (localObject1 = da.this.vzE.uRf.uRz.getString(R.l.dXc);; localObject1 = da.this.vzE.uRf.uRz.getString(R.l.eFS))
            {
              com.tencent.mm.ui.base.g.b((Context)localObject2, paramAnonymousView, "", (String)localObject1, da.this.vzE.uRf.uRz.getString(R.l.dXa), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  GMTrace.i(2521414238208L, 18786);
                  paramAnonymous2DialogInterface = localList.iterator();
                  while (paramAnonymous2DialogInterface.hasNext())
                  {
                    au localau = (au)paramAnonymous2DialogInterface.next();
                    if ((!localau.bMe()) && (!localau.bMd()))
                    {
                      if ((localcb.fFr.type == 14) && (localcb.fFr.fFt.txF.size() == 0))
                      {
                        da.this.bUs();
                        GMTrace.o(2521414238208L, 18786);
                        return;
                      }
                      da.6.this.b(localcb);
                      da.6.cz(da.this.bUr());
                      GMTrace.o(2521414238208L, 18786);
                      return;
                    }
                  }
                  GMTrace.o(2521414238208L, 18786);
                }
              }, null);
              GMTrace.o(2492288991232L, 18569);
              return;
              paramAnonymousView = da.this.vzE.uRf.uRz.getString(R.l.eif);
              break;
            }
          }
          com.tencent.mm.ui.base.g.h(da.this.vzE.uRf.uRz, localcb.fFr.fFx, 0);
          GMTrace.o(2492288991232L, 18569);
        }
      });
      this.vzF.vDM = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2280493416448L, 16991);
          if (da.this.vzF.eG(((Long)paramAnonymousView.getTag()).longValue()))
          {
            int i = da.this.vzF.vDC.size();
            da.this.vzE.bVp();
            da.this.kuK.bZF();
            da.this.vEg.setVisibility(0);
            da.this.vEg.AK(i);
          }
          GMTrace.o(2280493416448L, 16991);
        }
      };
      this.iLr = new com.tencent.mm.ui.tools.l(this.vzE.uRf.uRz);
      GMTrace.o(2227611631616L, 16597);
      return;
      this.kuK = new p(true, true);
      this.kuK.wlY = new p.b()
      {
        public final void OE()
        {
          GMTrace.i(2166139912192L, 16139);
          v.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
          if (da.this.vzF.vDz)
          {
            da.this.vzE.bVp();
            da.this.vEg.setVisibility(0);
            da.this.vEg.AK(da.this.vzF.vDC.size());
          }
          GMTrace.o(2166139912192L, 16139);
        }
        
        public final void OF()
        {
          GMTrace.i(2166274129920L, 16140);
          v.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
          com.tencent.mm.plugin.report.service.g.oSF.a(219L, 21L, 1L, true);
          if (da.this.vzF.vDz)
          {
            da.this.vzE.bVo();
            da.this.vEg.setVisibility(8);
          }
          GMTrace.o(2166274129920L, 16140);
        }
        
        public final void OG()
        {
          GMTrace.i(2166542565376L, 16142);
          GMTrace.o(2166542565376L, 16142);
        }
        
        public final void OH()
        {
          GMTrace.i(16785269063680L, 125060);
          GMTrace.o(16785269063680L, 125060);
        }
        
        public final boolean mQ(String paramAnonymousString)
        {
          GMTrace.i(2166408347648L, 16141);
          GMTrace.o(2166408347648L, 16141);
          return false;
        }
        
        public final void mR(String paramAnonymousString)
        {
          GMTrace.i(2166005694464L, 16138);
          v.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
          if (bf.mA(paramAnonymousString))
          {
            if (da.this.vzE.vHG)
            {
              if (da.this.vEh != null) {
                da.this.vEh.yB("");
              }
              da.this.vzE.AT(-1);
              GMTrace.o(2166005694464L, 16138);
              return;
            }
            if (da.this.vDz)
            {
              da.this.vzE.bVp();
              da.this.vEg.setVisibility(0);
              da.this.vEg.AK(da.this.vzF.vDC.size());
              GMTrace.o(2166005694464L, 16138);
              return;
            }
            da.this.vzE.bVp();
            da.this.vEg.setVisibility(8);
            GMTrace.o(2166005694464L, 16138);
            return;
          }
          v.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
          da.this.vEg.setVisibility(8);
          da.this.vzE.bVo();
          if (da.this.vEh != null) {
            da.this.vEh.yB(paramAnonymousString);
          }
          GMTrace.o(2166005694464L, 16138);
        }
      };
    }
  }
  
  public final void a(dx.a parama)
  {
    GMTrace.i(14950646939648L, 111391);
    GMTrace.o(14950646939648L, 111391);
  }
  
  public final void b(x paramx, boolean paramBoolean)
  {
    GMTrace.i(2227745849344L, 16598);
    this.fOB = paramx;
    this.vvA = paramBoolean;
    GMTrace.o(2227745849344L, 16598);
  }
  
  public final void b(dx.a parama)
  {
    GMTrace.i(14950915375104L, 111393);
    bUs();
    GMTrace.o(14950915375104L, 111393);
  }
  
  public final List<au> bUr()
  {
    GMTrace.i(2227880067072L, 16599);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.vzF.vDC.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      v.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", new Object[] { Long.valueOf(l) });
      ap.yY();
      localLinkedList.add(com.tencent.mm.u.c.wT().cA(l));
    }
    Collections.sort(localLinkedList, new Comparator() {});
    GMTrace.o(2227880067072L, 16599);
    return localLinkedList;
  }
  
  public final void bUs()
  {
    GMTrace.i(2228014284800L, 16600);
    this.vzE.a(false, this.kuK);
    this.vEg.setVisibility(8);
    this.vzF.auc();
    this.vzE.bVp();
    this.vDz = false;
    this.vzE.bVd();
    this.vzE.bVR();
    this.vzE.bVc();
    this.vzE.aqY();
    ab.bTR();
    GMTrace.o(2228014284800L, 16600);
  }
  
  public final void bUt()
  {
    GMTrace.i(2228148502528L, 16601);
    if (this.kuK != null) {
      this.kuK.bZF();
    }
    GMTrace.o(2228148502528L, 16601);
  }
  
  public final void bUu()
  {
    GMTrace.i(14950781157376L, 111392);
    bUs();
    GMTrace.o(14950781157376L, 111392);
  }
  
  public final boolean bUv()
  {
    GMTrace.i(2228551155712L, 16604);
    boolean bool = this.vEj;
    GMTrace.o(2228551155712L, 16604);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */