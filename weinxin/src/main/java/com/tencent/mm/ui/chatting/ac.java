package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.lz.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac
{
  public static com.tencent.mm.ui.base.p vzj;
  public static a vzt;
  
  static
  {
    GMTrace.i(2186406789120L, 16290);
    vzj = null;
    GMTrace.o(2186406789120L, 16290);
  }
  
  public static void a(En_5b8fbb1e.a parama, da paramda, String paramString, long paramLong)
  {
    GMTrace.i(2185869918208L, 16286);
    ActionBarActivity localActionBarActivity = parama.uRf.uRz;
    if ((!u.mA(paramString)) && (paramString.length() > 0))
    {
      localActionBarActivity.getString(R.l.dIG);
      vzj = g.a(localActionBarActivity, localActionBarActivity.getString(R.l.eRb), false, null);
      da.vEf.c(new b(parama, localActionBarActivity, paramString, paramLong, vzt));
    }
    if (paramda != null) {
      paramda.bUs();
    }
    GMTrace.o(2185869918208L, 16286);
  }
  
  public static void a(final En_5b8fbb1e.a parama, List<au> paramList, boolean paramBoolean, final da paramda, final x paramx)
  {
    GMTrace.i(2185333047296L, 16282);
    if (parama == null)
    {
      v.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
      GMTrace.o(2185333047296L, 16282);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      v.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
      GMTrace.o(2185333047296L, 16282);
      return;
    }
    Object localObject = new a();
    vzt = (a)localObject;
    ((a)localObject).vzr = new LinkedList(paramList);
    vzt.vvA = paramBoolean;
    vzt.fTc = paramx.field_username;
    vzt.vzB = true;
    final ActionBarActivity localActionBarActivity = parama.uRf.uRz;
    if (localActionBarActivity == null)
    {
      GMTrace.o(2185333047296L, 16282);
      return;
    }
    com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l(localActionBarActivity);
    locall.wkZ = new n.a()
    {
      public final void a(ImageView paramAnonymousImageView, MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2408268693504L, 17943);
        a.b.b(paramAnonymousImageView, paramAnonymousMenuItem.getTitle(), false);
        GMTrace.o(2408268693504L, 17943);
      }
    };
    locall.wla = new n.b()
    {
      public final void a(TextView paramAnonymousTextView, MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2245865242624L, 16733);
        if (paramAnonymousTextView != null)
        {
          ap.yY();
          x localx = com.tencent.mm.u.c.wR().Rb(paramAnonymousMenuItem.getTitle());
          if ((localx == null) || ((int)localx.gTG <= 0))
          {
            paramAnonymousTextView.setText(paramAnonymousMenuItem.getTitle());
            GMTrace.o(2245865242624L, 16733);
            return;
          }
          paramAnonymousTextView.setText(h.a(this.val$context, localx.tK()));
        }
        GMTrace.o(2245865242624L, 16733);
      }
    };
    if (com.tencent.mm.pluginsdk.model.app.p.n(localActionBarActivity, "com.tencent.wework")) {}
    for (localObject = aa.bTQ();; localObject = aa.bTP())
    {
      locall.qHD = new n.c()
      {
        public final void a(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          GMTrace.i(2223585099776L, 16567);
          paramAnonymousl.W(1193046, R.l.eAD, R.g.bdL);
          Iterator localIterator = this.vzu.iterator();
          while (localIterator.hasNext()) {
            paramAnonymousl.add((String)localIterator.next());
          }
          GMTrace.o(2223585099776L, 16567);
        }
      };
      locall.qHE = new n.d()
      {
        public final void c(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(2384243720192L, 17764);
          if (paramAnonymousMenuItem.getItemId() == 1193046)
          {
            if (aa.cx(this.vzm))
            {
              g.a(localActionBarActivity, localActionBarActivity.getString(R.l.eaz), "", localActionBarActivity.getString(R.l.dAD), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  GMTrace.i(2530406825984L, 18853);
                  GMTrace.o(2530406825984L, 18853);
                }
              });
              GMTrace.o(2384243720192L, 17764);
              return;
            }
            if (aa.cy(this.vzm))
            {
              g.a(localActionBarActivity, localActionBarActivity.getString(R.l.eaA), "", localActionBarActivity.getString(R.l.dAD), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  GMTrace.i(2137148882944L, 15923);
                  GMTrace.o(2137148882944L, 15923);
                }
              });
              GMTrace.o(2384243720192L, 17764);
              return;
            }
            if (aa.cw(this.vzm))
            {
              g.a(localActionBarActivity, localActionBarActivity.getString(R.l.eaB), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  GMTrace.i(2380619841536L, 17737);
                  GMTrace.o(2380619841536L, 17737);
                }
              }, null);
              GMTrace.o(2384243720192L, 17764);
              return;
            }
            if ((ad.a(parama, this.vzm, paramx)) && (paramda != null)) {
              paramda.bUs();
            }
            GMTrace.o(2384243720192L, 17764);
            return;
          }
          if (aa.cx(this.vzm))
          {
            g.a(localActionBarActivity, localActionBarActivity.getString(R.l.eaz), "", localActionBarActivity.getString(R.l.dAD), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(2516313964544L, 18748);
                GMTrace.o(2516313964544L, 18748);
              }
            });
            GMTrace.o(2384243720192L, 17764);
            return;
          }
          if (aa.cy(this.vzm))
          {
            g.a(localActionBarActivity, localActionBarActivity.getString(R.l.eaA), "", localActionBarActivity.getString(R.l.dAD), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(2526111858688L, 18821);
                GMTrace.o(2526111858688L, 18821);
              }
            });
            GMTrace.o(2384243720192L, 17764);
            return;
          }
          final Object localObject = this.vzm;
          label359:
          label361:
          Iterator localIterator;
          if (localObject == null)
          {
            v.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
            break label422;
            break label422;
            break label422;
            paramAnonymousInt = 0;
            if ((paramAnonymousInt == 0) && (!aa.cw(this.vzm))) {
              break label668;
            }
            g.a(localActionBarActivity, localActionBarActivity.getString(R.l.eaB), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(2143188680704L, 15968);
                GMTrace.o(2143188680704L, 15968);
              }
            }, null);
            GMTrace.o(2384243720192L, 17764);
          }
          else
          {
            localIterator = ((List)localObject).iterator();
          }
          label422:
          label668:
          label932:
          label933:
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label359;
            }
            au localau = (au)localIterator.next();
            if (localau.field_isSend == 1) {
              break label359;
            }
            if (localau.bLX())
            {
              localObject = null;
              if (localau.field_msgId > 0L) {
                localObject = n.GT().aj(localau.field_msgId);
              }
              if (((localObject != null) && (((com.tencent.mm.ah.d)localObject).hEG > 0L)) || (localau.field_msgSvrId <= 0L)) {
                break label932;
              }
              localObject = n.GT().ai(localau.field_msgSvrId);
            }
            for (;;)
            {
              if ((localObject == null) || ((((com.tencent.mm.ah.d)localObject).offset >= ((com.tencent.mm.ah.d)localObject).hrb) && (((com.tencent.mm.ah.d)localObject).hrb != 0))) {
                break label933;
              }
              paramAnonymousInt = 1;
              break label361;
              if (localau.bMb())
              {
                localObject = o.KW().lt(localau.field_imgPath);
                if ((localObject == null) || (((r)localObject).status == 199) || (((r)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label361;
              }
              if (localau.bMc())
              {
                localObject = t.lI(localau.field_imgPath);
                if ((localObject == null) || (((r)localObject).status == 199) || (((r)localObject).status == 199)) {
                  break;
                }
                paramAnonymousInt = 1;
                break label361;
              }
              if (!localau.bMe()) {
                break;
              }
              if (!aa.ad(localau))
              {
                paramAnonymousInt = 1;
                break label361;
              }
              paramAnonymousInt = 0;
              break label361;
              localObject = (String)paramAnonymousMenuItem.getTitle();
              if (com.tencent.mm.modelbiz.e.hZ((String)localObject))
              {
                if (this.vzm.size() <= 1)
                {
                  ac.vzt.vzB = true;
                  ac.a((String)localObject, parama, this.vzm);
                  GMTrace.o(2384243720192L, 17764);
                  return;
                }
                new com.tencent.mm.ui.tools.l(localActionBarActivity).b(paramAnonymousMenuItem.getActionView(), new View.OnCreateContextMenuListener()new n.d
                {
                  public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
                  {
                    GMTrace.i(2149094260736L, 16012);
                    paramAnonymous2ContextMenu.add(0, 0, 0, R.l.eBu);
                    paramAnonymous2ContextMenu.add(0, 1, 1, R.l.eBv);
                    GMTrace.o(2149094260736L, 16012);
                  }
                }, new n.d()
                {
                  public final void c(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                  {
                    GMTrace.i(2484370145280L, 18510);
                    if (paramAnonymous2MenuItem.getItemId() == 0) {}
                    for (ac.vzt.vzB = true;; ac.vzt.vzB = false)
                    {
                      ac.a(localObject, ac.4.this.vzv, ac.4.this.vzm);
                      GMTrace.o(2484370145280L, 18510);
                      return;
                    }
                  }
                });
                GMTrace.o(2384243720192L, 17764);
                return;
              }
              if (aa.cu(this.vzm))
              {
                localObject = localActionBarActivity.getString(R.l.esA);
                g.a(localActionBarActivity, (String)localObject, "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    GMTrace.i(2497255047168L, 18606);
                    paramAnonymous2DialogInterface = ac.4.this.vzm;
                    if ((paramAnonymous2DialogInterface == null) || (paramAnonymous2DialogInterface.isEmpty())) {
                      v.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                    }
                    label37:
                    for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                    {
                      if (paramAnonymous2Int == 0) {
                        break label190;
                      }
                      v.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                      if (ac.4.this.vzx != null) {
                        ac.4.this.vzx.bUs();
                      }
                      GMTrace.o(2497255047168L, 18606);
                      return;
                      paramAnonymous2DialogInterface = paramAnonymous2DialogInterface.iterator();
                      if (!paramAnonymous2DialogInterface.hasNext()) {
                        break label37;
                      }
                      au localau = (au)paramAnonymous2DialogInterface.next();
                      if (aa.ah(localau)) {
                        break label37;
                      }
                      if ((localau.bLP()) || (aa.ac(localau)) || (localau.bLY()) || (aa.ae(localau)) || (aa.af(localau)) || (localau.field_type == -1879048186) || (aa.ak(localau)) || (aa.ag(localau)) || (aa.aj(localau)) || (aa.an(localau))) {
                        break;
                      }
                    }
                    label190:
                    paramAnonymous2DialogInterface = ac.4.this.val$context;
                    ac.4.this.val$context.getString(R.l.dIG);
                    ac.vzj = g.a(paramAnonymous2DialogInterface, ac.4.this.val$context.getString(R.l.eRb), false, null);
                    da.vEf.c(new ac.b(ac.4.this.vzv, ac.4.this.val$context, paramAnonymousMenuItem.getTitle(), -1L, ac.vzt));
                    if (ac.4.this.vzx != null) {
                      ac.4.this.vzx.bUs();
                    }
                    GMTrace.o(2497255047168L, 18606);
                  }
                }, null);
                GMTrace.o(2384243720192L, 17764);
                return;
              }
              localObject = localActionBarActivity;
              localActionBarActivity.getString(R.l.dIG);
              ac.vzj = g.a((Context)localObject, localActionBarActivity.getString(R.l.eRb), false, null);
              da.vEf.c(new ac.b(parama, localActionBarActivity, paramAnonymousMenuItem.getTitle(), -1L, ac.vzt));
              if (paramda != null) {
                paramda.bUs();
              }
              GMTrace.o(2384243720192L, 17764);
              return;
            }
          }
        }
      };
      locall.bkT();
      GMTrace.o(2185333047296L, 16282);
      return;
    }
  }
  
  public static void a(String paramString, q paramq)
  {
    GMTrace.i(2185601482752L, 16284);
    Object localObject = com.tencent.mm.modelbiz.e.hW(paramString);
    if (localObject == null)
    {
      GMTrace.o(2185601482752L, 16284);
      return;
    }
    if (((BizInfo)localObject).CJ())
    {
      localObject = new Intent(paramq.uRf.uRz, BizChatSelectConversationUI.class);
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("biz_chat_scene", 2);
      ((Intent)localObject).putExtra("enterprise_extra_params", vzt.vzB);
      paramq.startActivityForResult((Intent)localObject, 225);
      GMTrace.o(2185601482752L, 16284);
      return;
    }
    if (((BizInfo)localObject).CH())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("enterprise_biz_name", paramString);
      ((Intent)localObject).putExtra("enterprise_scene", 1);
      com.tencent.mm.bb.d.a(paramq, "brandservice", ".ui.EnterpriseBizContactPlainListUI", (Intent)localObject, 225);
    }
    GMTrace.o(2185601482752L, 16284);
  }
  
  public static void a(String paramString, final q paramq, List<au> paramList)
  {
    GMTrace.i(2185467265024L, 16283);
    ActionBarActivity localActionBarActivity = paramq.uRf.uRz;
    if (localActionBarActivity == null)
    {
      GMTrace.o(2185467265024L, 16283);
      return;
    }
    Object localObject = com.tencent.mm.modelbiz.e.hW(paramString);
    if (localObject == null)
    {
      GMTrace.o(2185467265024L, 16283);
      return;
    }
    boolean bool1 = ((BizInfo)localObject).CJ();
    boolean bool2;
    int i;
    if (vzt.vzB)
    {
      bool2 = aa.cu(paramList);
      if (bool1) {
        if ((paramList == null) || (paramList.isEmpty()))
        {
          v.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
          i = 1;
          vzt.vzr = new LinkedList(paramList);
          if ((!bool2) && (i == 0)) {
            break label283;
          }
          paramList = localActionBarActivity.getString(R.l.eeD);
        }
      }
    }
    for (;;)
    {
      if (paramList != null)
      {
        g.a(localActionBarActivity, paramList, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2493228515328L, 18576);
            ac.a(this.uNt, paramq);
            GMTrace.o(2493228515328L, 18576);
          }
        }, null);
        GMTrace.o(2185467265024L, 16283);
        return;
        localObject = paramList.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            au localau = (au)((Iterator)localObject).next();
            if ((!localau.bMa()) && (!localau.bLP()) && (!localau.bLX()) && (!localau.bLZ()) && (!aa.ai(localau)))
            {
              i = 1;
              break;
            }
          }
        }
        i = 0;
        break;
        if (!bool2) {
          break label283;
        }
        paramList = localActionBarActivity.getString(R.l.eeE);
        continue;
      }
      a(paramString, paramq);
      GMTrace.o(2185467265024L, 16283);
      return;
      label283:
      paramList = null;
    }
  }
  
  public static lz bl(Context paramContext, String paramString)
  {
    GMTrace.i(2185735700480L, 16285);
    lz locallz = new lz();
    locallz.fSV.type = 6;
    locallz.fSV.fTb = vzt.vzr;
    locallz.fSV.toUser = paramString;
    locallz.fSV.fTc = vzt.fTc;
    locallz.fSV.context = paramContext;
    com.tencent.mm.sdk.b.a.uql.m(locallz);
    vzt.fSz = locallz.fSW.fSz;
    vzt.vzs = locallz.fSW.fTe;
    GMTrace.o(2185735700480L, 16285);
    return locallz;
  }
  
  private static final class a
  {
    cb fSz;
    String fTc;
    boolean vvA;
    boolean vzB;
    List<au> vzr;
    com.tencent.mm.protocal.b.a.d vzs;
    
    public a()
    {
      GMTrace.i(2305457913856L, 17177);
      GMTrace.o(2305457913856L, 17177);
    }
  }
  
  private static final class b
    implements aq.a
  {
    private Context context;
    private String htS;
    private long jZq;
    private boolean sLe;
    private En_5b8fbb1e.a vzC;
    private ac.a vzD;
    
    public b(En_5b8fbb1e.a parama, Context paramContext, String paramString, long paramLong, ac.a parama1)
    {
      GMTrace.i(2221437616128L, 16551);
      this.vzC = parama;
      this.context = paramContext;
      this.htS = paramString;
      this.jZq = paramLong;
      this.vzD = parama1;
      this.sLe = com.tencent.mm.modelbiz.e.dr(paramString);
      GMTrace.o(2221437616128L, 16551);
    }
    
    private void bTS()
    {
      GMTrace.i(2221706051584L, 16553);
      Iterator localIterator = this.vzD.vzr.iterator();
      while (localIterator.hasNext())
      {
        au localau = (au)localIterator.next();
        Context localContext = this.context;
        boolean bool = this.vzD.vvA;
        String str = this.htS;
        if (localau.bMa()) {
          aa.a(localContext, str, localau, bool);
        } else if (localau.bLX()) {
          aa.b(localContext, str, localau);
        } else if ((localau.bMb()) && (!this.sLe)) {
          aa.c(localContext, str, localau);
        } else if (localau.bLZ()) {
          aa.c(localContext, str, localau, bool);
        } else if (((localau.bMd()) || (localau.bMe())) && (!this.sLe))
        {
          if (!aa.ac(localau)) {
            aa.a(localContext, str, localau);
          }
        }
        else if ((localau.axH()) && ((!this.sLe) || (aa.ai(localau))) && (!aa.aj(localau)) && (localau.field_type != 318767153) && (!aa.an(localau)) && (!aa.ae(localau))) {
          aa.b(localContext, str, localau, bool);
        }
      }
      GMTrace.o(2221706051584L, 16553);
    }
    
    private void bTT()
    {
      GMTrace.i(2221840269312L, 16554);
      ac.bl(this.context, this.htS);
      lz locallz = new lz();
      locallz.fSV.type = 5;
      locallz.fSV.fTb = this.vzD.vzr;
      locallz.fSV.toUser = this.htS;
      locallz.fSV.fTc = this.vzD.fTc;
      locallz.fSV.context = this.context;
      locallz.fSV.fSz = this.vzD.fSz;
      locallz.fSV.fTe = this.vzD.vzs;
      com.tencent.mm.sdk.b.a.uql.m(locallz);
      GMTrace.o(2221840269312L, 16554);
    }
    
    public final boolean Bn()
    {
      GMTrace.i(2221571833856L, 16552);
      if (this.sLe)
      {
        com.tencent.mm.modelbiz.a.c localc = w.DJ().aa(this.jZq);
        synchronized (com.tencent.mm.modelbiz.a.e.hwA)
        {
          String str = com.tencent.mm.modelbiz.a.e.zz();
          com.tencent.mm.modelbiz.a.e.d(localc);
          if (this.vzD.vzB)
          {
            bTS();
            com.tencent.mm.modelbiz.a.e.iy(str);
            GMTrace.o(2221571833856L, 16552);
            return true;
          }
          bTT();
        }
      }
      if (this.vzD.vzB) {
        bTS();
      }
      for (;;)
      {
        GMTrace.o(2221571833856L, 16552);
        return true;
        bTT();
      }
    }
    
    public final boolean Bo()
    {
      GMTrace.i(2221974487040L, 16555);
      if (ac.vzj != null) {
        ac.vzj.dismiss();
      }
      com.tencent.mm.ui.snackbar.a.a(this.context, this.vzC.mView.findViewById(R.h.cka), this.context.getString(R.l.ekN));
      GMTrace.o(2221974487040L, 16555);
      return true;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */