package com.tencent.mm.ui.chatting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.oa;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class o
  implements View.OnClickListener, t, e
{
  public En_5b8fbb1e.a fyf;
  public ProgressDialog isb;
  
  public o(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2304518389760L, 17170);
    this.fyf = parama;
    GMTrace.o(2304518389760L, 17170);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, w paramw)
  {
    GMTrace.i(2304786825216L, 17172);
    v.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.isb != null) && (this.isb.isShowing()))
    {
      this.isb.dismiss();
      this.isb = null;
    }
    an.aBz().b(2, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.g.bk(this.fyf.bOZ(), this.fyf.getString(R.l.epj));
      GMTrace.o(2304786825216L, 17172);
      return;
    }
    if (p.a.a(this.fyf.bOZ(), paramInt1, paramInt2, paramString, 4))
    {
      GMTrace.o(2304786825216L, 17172);
      return;
    }
    Toast.makeText(this.fyf.bOZ(), this.fyf.getString(R.l.eoH, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    GMTrace.o(2304786825216L, 17172);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2304921042944L, 17173);
    if ((this.isb != null) && (this.isb.isShowing()))
    {
      this.isb.dismiss();
      this.isb = null;
    }
    ap.vd().b(1030, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.g.bk(this.fyf.bOZ(), this.fyf.getString(R.l.epj));
      GMTrace.o(2304921042944L, 17173);
      return;
    }
    Toast.makeText(this.fyf.bOZ(), this.fyf.getString(R.l.eXW, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    GMTrace.o(2304921042944L, 17173);
  }
  
  public final void g(final k paramk)
  {
    GMTrace.i(16016738353152L, 119334);
    ap.vd().a(paramk, 0);
    FragmentActivity localFragmentActivity = this.fyf.bOZ();
    this.fyf.getString(R.l.dIG);
    this.isb = com.tencent.mm.ui.base.g.a(localFragmentActivity, this.fyf.getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(2370419294208L, 17661);
        ap.vd().c(paramk);
        an.aBz().b(2, o.this);
        GMTrace.o(2370419294208L, 17661);
      }
    });
    GMTrace.o(16016738353152L, 119334);
  }
  
  public final void onClick(final View paramView)
  {
    boolean bool = true;
    final int i = 0;
    GMTrace.i(2304652607488L, 17171);
    if (paramView.getTag() == null)
    {
      v.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
      GMTrace.o(2304652607488L, 17171);
      return;
    }
    final Object localObject1;
    if ((paramView.getTag() instanceof ds))
    {
      localObject1 = (ds)paramView.getTag();
      if (localObject1 == null)
      {
        v.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
        GMTrace.o(2304652607488L, 17171);
        return;
      }
      paramView = ((ds)localObject1).fSK.appId;
      if (bf.mA(paramView)) {
        v.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
      }
      while (i == 0)
      {
        GMTrace.o(2304652607488L, 17171);
        return;
        if (com.tencent.mm.pluginsdk.model.app.g.aJ(paramView, false) == null) {
          v.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = " + paramView);
        } else {
          i = 1;
        }
      }
      an.aBz().a(2, this);
      if (this.fyf.vzR)
      {
        i = 2;
        paramView = this.fyf.bTW();
        if (!com.tencent.mm.u.o.dH(paramView)) {
          break label505;
        }
        paramView = ay.gi(((ds)localObject1).fTa.field_content);
      }
    }
    label505:
    for (;;)
    {
      localObject1 = ((ds)localObject1).fSK;
      com.tencent.mm.ui.base.g.b(this.fyf.bOZ(), this.fyf.getString(R.l.dHv), this.fyf.getString(R.l.dHw), this.fyf.getString(R.l.dBv), this.fyf.getString(R.l.eIN), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2110707990528L, 15726);
          paramAnonymousDialogInterface = new x(2, new aj(localObject1.appId, 0, "1"));
          o.this.g(paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = l.a.szQ;
          if (paramAnonymousDialogInterface != null)
          {
            o.this.fyf.bOZ();
            paramAnonymousDialogInterface.a(paramView, localObject1.appId, localObject1.type, i, localObject1.mediaTagName, 1);
          }
          GMTrace.o(2110707990528L, 15726);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2196473118720L, 16365);
          paramAnonymousDialogInterface = new x(2, new aj(localObject1.appId, 0, "0"));
          o.this.g(paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = l.a.szQ;
          if (paramAnonymousDialogInterface != null)
          {
            o.this.fyf.bOZ();
            paramAnonymousDialogInterface.a(paramView, localObject1.appId, localObject1.type, i, localObject1.mediaTagName, 2);
          }
          GMTrace.o(2196473118720L, 16365);
        }
      });
      GMTrace.o(2304652607488L, 17171);
      return;
      i = 1;
      break;
      if ((paramView.getTag() instanceof ej))
      {
        final Object localObject2 = (ej)paramView.getTag();
        if (localObject2 == null)
        {
          v.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
          GMTrace.o(2304652607488L, 17171);
          return;
        }
        if ((localObject2 == null) || (bf.mA(((ej)localObject2).hih)) || (((ej)localObject2).fTa == null))
        {
          if (localObject2 == null) {}
          for (;;)
          {
            v.e("MicroMsg.AppSpamClickListener", "wrong args, tag is null ? ", new Object[] { Boolean.valueOf(bool) });
            GMTrace.o(2304652607488L, 17171);
            return;
            bool = false;
          }
        }
        paramView = this.fyf.bOZ().getString(R.l.eXU);
        localObject1 = this.fyf.bOZ().getString(R.l.eXV);
        String str = this.fyf.bOZ().getString(R.l.dGk);
        FragmentActivity localFragmentActivity = this.fyf.bOZ();
        localObject2 = new g.c()
        {
          public final void hp(int paramAnonymousInt)
          {
            GMTrace.i(2214055641088L, 16496);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              GMTrace.o(2214055641088L, 16496);
              return;
              Intent localIntent = new Intent();
              try
              {
                localIntent.putExtra("rawUrl", String.format("http://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[] { URLEncoder.encode(localObject2.rTh, "UTF-8"), URLEncoder.encode(localObject2.hih, "UTF-8"), Long.valueOf(localObject2.fTa.field_msgSvrId), Integer.valueOf((int)(localObject2.fTa.field_createTime / 1000L)), Integer.valueOf(42) }));
                localIntent.putExtra("show_bottom", false);
                localIntent.putExtra("showShare", false);
                com.tencent.mm.bb.d.b(o.this.fyf.bOZ(), "webview", ".ui.tools.WebViewUI", localIntent);
                GMTrace.o(2214055641088L, 16496);
                return;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                v.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[] { localUnsupportedEncodingException.getMessage() });
                GMTrace.o(2214055641088L, 16496);
                return;
              }
              v.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[] { localObject2.rTh, localObject2.hih });
              ap.vd().a(1030, o.this);
              Object localObject2 = new akf();
              ((akf)localObject2).tdn = 1;
              ((akf)localObject2).tMp = localObject2.hih;
              ((akf)localObject2).fDt = "";
              Object localObject1 = new LinkedList();
              ((LinkedList)localObject1).add(localObject2);
              localObject2 = new oa();
              ((oa)localObject2).fUX.fTz = localObject2.rTh;
              ((oa)localObject2).fUX.fUY = ((LinkedList)localObject1);
              if (a.uql.m((b)localObject2))
              {
                localObject1 = o.this;
                localObject2 = o.this.fyf.bOZ();
                o.this.fyf.getString(R.l.dIG);
                ((o)localObject1).isb = com.tencent.mm.ui.base.g.a((Context)localObject2, o.this.fyf.getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    GMTrace.i(2496315523072L, 18599);
                    ap.vd().b(1030, o.this);
                    GMTrace.o(2496315523072L, 18599);
                  }
                });
              }
            }
          }
        };
        com.tencent.mm.ui.base.g.a(localFragmentActivity, null, new String[] { paramView, localObject1, str }, null, true, (g.c)localObject2);
      }
      GMTrace.o(2304652607488L, 17171);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */