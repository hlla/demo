package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.kj;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.pr.a;
import com.tencent.mm.e.a.ri;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.i.b.a;
import com.tencent.mm.protocal.c.beg;
import com.tencent.mm.protocal.c.bqq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.q;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class bj
  extends ag
{
  static int vBr;
  static int vBs;
  public String ivn;
  private View.OnClickListener ljD;
  public p uUn;
  public com.tencent.mm.ah.a.a.c uUw;
  public En_5b8fbb1e.a vAn;
  private View.OnClickListener vBm;
  private View.OnClickListener vBn;
  private View.OnClickListener vBo;
  private En_5b8fbb1e.b vBp;
  public String vBq;
  public com.tencent.mm.sdk.b.c<kj> vwf;
  
  static
  {
    GMTrace.i(2491081031680L, 18560);
    vBr = Color.parseColor("#888888");
    vBs = Color.parseColor("#888888");
    GMTrace.o(2491081031680L, 18560);
  }
  
  public bj()
  {
    super(40);
    GMTrace.i(2488128241664L, 18538);
    c.a locala = new c.a();
    locala.hIQ = true;
    locala.hII = R.g.bcX;
    this.uUw = locala.Hh();
    this.vBm = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        GMTrace.i(2218619043840L, 16530);
        final au localau = (au)paramAnonymousView.getTag(R.h.cnq);
        if (localau == null)
        {
          v.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
          GMTrace.o(2218619043840L, 16530);
          return;
        }
        Object localObject = bg.q(localau.field_content, "msg");
        if ((localObject == null) || (((Map)localObject).size() == 0))
        {
          GMTrace.o(2218619043840L, 16530);
          return;
        }
        final String str = bf.mz((String)((Map)localObject).get(".msg.fromusername"));
        WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(str);
        final int i = bf.n(((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
        final int j = bf.n(((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
        localObject = new com.tencent.mm.ui.widget.e(paramAnonymousView.getContext(), com.tencent.mm.ui.widget.e.wsK, false);
        final boolean bool;
        if ((localWxaAttributes != null) && ((localWxaAttributes.field_appOpt & 0x1) > 0))
        {
          bool = true;
          if (!bool) {
            break label255;
          }
          ((com.tencent.mm.ui.widget.e)localObject).d(paramAnonymousView.getResources().getString(R.l.eES), 3);
        }
        for (;;)
        {
          ((com.tencent.mm.ui.widget.e)localObject).qHD = new n.c()
          {
            public final void a(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              GMTrace.i(2142651809792L, 15964);
              if (bool) {
                paramAnonymous2l.a(1, paramAnonymousView.getResources().getColor(R.e.aUd), paramAnonymousView.getResources().getString(R.l.eER));
              }
              for (;;)
              {
                paramAnonymous2l.add(0, 2, 0, paramAnonymousView.getResources().getString(R.l.eEJ));
                GMTrace.o(2142651809792L, 15964);
                return;
                paramAnonymous2l.a(0, paramAnonymousView.getResources().getColor(R.e.aVE), paramAnonymousView.getResources().getString(R.l.eEE));
              }
            }
          };
          ((com.tencent.mm.ui.widget.e)localObject).qHE = new n.d()
          {
            public final void c(final MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              GMTrace.i(2366258544640L, 17630);
              v.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramAnonymous2MenuItem.getItemId()), Integer.valueOf(paramAnonymous2Int) });
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                GMTrace.o(2366258544640L, 17630);
                return;
                ((dy)paramAnonymousView.getTag(R.h.cmZ)).vLz.setVisibility(0);
                paramAnonymous2MenuItem = new ri();
                paramAnonymous2MenuItem.fYg.fCA = str;
                paramAnonymous2MenuItem.fYg.action = 1;
                paramAnonymous2MenuItem.fYg.fYi = 1;
                com.tencent.mm.sdk.b.a.uql.m(paramAnonymous2MenuItem);
                paramAnonymous2MenuItem = new LinkedList();
                Object localObject = new beg();
                ((beg)localObject).udz = str;
                ((beg)localObject).udy = 0;
                ((beg)localObject).jMq = 1;
                paramAnonymous2MenuItem.add(localObject);
                bj.v(2, bj.this.ivn, bj.this.vBq);
                ap.vd().a(1176, new com.tencent.mm.y.e()
                {
                  public final void a(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, k paramAnonymous3k)
                  {
                    GMTrace.i(2161308073984L, 16103);
                    ap.vd().b(1176, this);
                    v.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, Boolean.valueOf(true) });
                    if (bj.1.2.this.hkK != bj.1.2.this.jic.getTag(R.h.cnq))
                    {
                      v.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(bj.1.2.this.hkK.field_msgId) });
                      GMTrace.o(2161308073984L, 16103);
                      return;
                    }
                    if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0))
                    {
                      ((dy)bj.1.2.this.jic.getTag(R.h.cmZ)).vLz.setVisibility(8);
                      s.makeText(bj.1.2.this.jic.getContext(), R.l.eEO, 0).show();
                      paramAnonymous3String = new ri();
                      paramAnonymous3String.fYg.fCA = bj.1.2.this.sjO;
                      paramAnonymous3String.fYg.action = 2;
                      paramAnonymous3String.fYg.fYi = 1;
                      com.tencent.mm.sdk.b.a.uql.m(paramAnonymous3String);
                      if (bj.this.vAn != null) {
                        bj.this.vAn.bRU();
                      }
                      GMTrace.o(2161308073984L, 16103);
                      return;
                    }
                    GMTrace.o(2161308073984L, 16103);
                  }
                });
                paramAnonymous2MenuItem = new j(paramAnonymous2MenuItem);
                ap.vd().a(paramAnonymous2MenuItem, 0);
                if (bj.this.vAn != null)
                {
                  bj.this.vAn.bRU();
                  GMTrace.o(2366258544640L, 17630);
                  return;
                  ((dy)paramAnonymousView.getTag(R.h.cmZ)).vLz.setVisibility(8);
                  paramAnonymous2MenuItem = new ri();
                  paramAnonymous2MenuItem.fYg.fCA = str;
                  paramAnonymous2MenuItem.fYg.action = 2;
                  paramAnonymous2MenuItem.fYg.fYi = 1;
                  com.tencent.mm.sdk.b.a.uql.m(paramAnonymous2MenuItem);
                  paramAnonymous2MenuItem = new LinkedList();
                  localObject = new beg();
                  ((beg)localObject).udz = str;
                  ((beg)localObject).udy = 1;
                  ((beg)localObject).jMq = 1;
                  paramAnonymous2MenuItem.add(localObject);
                  bj.v(3, bj.this.ivn, bj.this.vBq);
                  ap.vd().a(1176, new com.tencent.mm.y.e()
                  {
                    public final void a(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, k paramAnonymous3k)
                    {
                      GMTrace.i(2158757937152L, 16084);
                      ap.vd().b(1176, this);
                      v.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, Boolean.valueOf(false) });
                      if (bj.1.2.this.hkK != bj.1.2.this.jic.getTag(R.h.cnq))
                      {
                        v.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(bj.1.2.this.hkK.field_msgId) });
                        GMTrace.o(2158757937152L, 16084);
                        return;
                      }
                      if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0))
                      {
                        ((dy)bj.1.2.this.jic.getTag(R.h.cmZ)).vLz.setVisibility(0);
                        s.makeText(bj.1.2.this.jic.getContext(), R.l.eEO, 0).show();
                        paramAnonymous3String = new ri();
                        paramAnonymous3String.fYg.fCA = bj.1.2.this.sjO;
                        paramAnonymous3String.fYg.action = 1;
                        paramAnonymous3String.fYg.fYi = 1;
                        com.tencent.mm.sdk.b.a.uql.m(paramAnonymous3String);
                        if (bj.this.vAn != null) {
                          bj.this.vAn.bRU();
                        }
                        GMTrace.o(2158757937152L, 16084);
                        return;
                      }
                      GMTrace.o(2158757937152L, 16084);
                    }
                  });
                  paramAnonymous2MenuItem = new j(paramAnonymous2MenuItem);
                  ap.vd().a(paramAnonymous2MenuItem, 0);
                  if (bj.this.vAn != null)
                  {
                    bj.this.vAn.bRU();
                    GMTrace.o(2366258544640L, 17630);
                    return;
                    ap.vd().a(1198, new com.tencent.mm.y.e()
                    {
                      public final void a(int paramAnonymous3Int1, int paramAnonymous3Int2, final String paramAnonymous3String, k paramAnonymous3k)
                      {
                        Object localObject = null;
                        GMTrace.i(2301565599744L, 17148);
                        ap.vd().b(1198, this);
                        v.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymous3Int1), Integer.valueOf(paramAnonymous3Int2), paramAnonymous3String, Boolean.valueOf(false) });
                        if (bj.this.uUn != null)
                        {
                          bj.this.uUn.dismiss();
                          bj.this.uUn = null;
                        }
                        if ((paramAnonymous3Int1 != 0) || (paramAnonymous3Int2 != 0))
                        {
                          s.makeText(bj.1.2.this.jic.getContext(), R.l.eEK, 0).show();
                          GMTrace.o(2301565599744L, 17148);
                          return;
                        }
                        paramAnonymous3k = (com.tencent.mm.modelappbrand.n)paramAnonymous3k;
                        paramAnonymous3String = (String)localObject;
                        if (paramAnonymous3k.hpE != null) {
                          paramAnonymous3String = (bqq)paramAnonymous3k.hpE.hrT.hsa;
                        }
                        if (paramAnonymous3String == null)
                        {
                          s.makeText(bj.1.2.this.jic.getContext(), R.l.eEK, 0).show();
                          GMTrace.o(2301565599744L, 17148);
                          return;
                        }
                        paramAnonymous3String = paramAnonymous3String.unf;
                        v.i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[] { bj.1.2.this.sjO });
                        ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).a(bj.1.2.this.sjO, new b.a()
                        {
                          public final void c(WxaAttributes paramAnonymous4WxaAttributes)
                          {
                            GMTrace.i(17919811518464L, 133513);
                            if (paramAnonymous4WxaAttributes == null)
                            {
                              s.makeText(bj.1.2.this.jic.getContext(), R.l.eEO, 0).show();
                              GMTrace.o(17919811518464L, 133513);
                              return;
                            }
                            Object localObject = paramAnonymous4WxaAttributes.field_appId;
                            if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramAnonymous3String)))
                            {
                              v.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[] { localObject, paramAnonymous3String });
                              s.makeText(bj.1.2.this.jic.getContext(), R.l.eEO, 0).show();
                              GMTrace.o(17919811518464L, 133513);
                              return;
                            }
                            try
                            {
                              paramAnonymous4WxaAttributes = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(paramAnonymous3String, "utf-8"), Integer.valueOf(1), Integer.valueOf(bj.1.2.this.vBw), Integer.valueOf(bj.1.2.this.iGK) });
                              v.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramAnonymous3String, localObject, paramAnonymous4WxaAttributes });
                              localObject = new Intent();
                              ((Intent)localObject).putExtra("rawUrl", paramAnonymous4WxaAttributes);
                              d.b(bj.this.vAn.uRf.uRz, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
                              GMTrace.o(17919811518464L, 133513);
                              return;
                            }
                            catch (UnsupportedEncodingException paramAnonymous4WxaAttributes)
                            {
                              v.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                              s.makeText(bj.1.2.this.jic.getContext(), R.l.eEO, 0).show();
                              GMTrace.o(17919811518464L, 133513);
                            }
                          }
                        });
                        GMTrace.o(2301565599744L, 17148);
                      }
                    });
                    paramAnonymous2MenuItem = new com.tencent.mm.modelappbrand.n(localau.field_content);
                    localObject = bj.this;
                    Context localContext = paramAnonymousView.getContext();
                    paramAnonymousView.getResources().getString(R.l.dIG);
                    ((bj)localObject).uUn = com.tencent.mm.ui.base.g.a(localContext, paramAnonymousView.getResources().getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                      {
                        GMTrace.i(2520608931840L, 18780);
                        ap.vd().c(paramAnonymous2MenuItem);
                        GMTrace.o(2520608931840L, 18780);
                      }
                    });
                    ap.vd().a(paramAnonymous2MenuItem, 0);
                    bj.v(4, bj.this.ivn, bj.this.vBq);
                  }
                }
              }
            }
          };
          ((com.tencent.mm.ui.widget.e)localObject).byZ();
          GMTrace.o(2218619043840L, 16530);
          return;
          bool = false;
          break;
          label255:
          ((com.tencent.mm.ui.widget.e)localObject).d(paramAnonymousView.getResources().getString(R.l.eEF), 3);
        }
      }
    };
    this.vBn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2279688110080L, 16985);
        Object localObject2 = (ds)paramAnonymousView.getTag();
        v.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", new Object[] { ((ds)localObject2).userName });
        Object localObject1 = bg.q(((com.tencent.mm.pluginsdk.ui.chat.c)localObject2).fTa.field_content, "msg");
        if ((localObject1 != null) && (((Map)localObject1).size() != 0)) {
          bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
        }
        localObject1 = bj.this;
        paramAnonymousView.getContext();
        Object localObject3 = ((ds)localObject2).userName;
        paramAnonymousView = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og((String)localObject3);
        if (paramAnonymousView != null) {
          bj.v(1, paramAnonymousView.field_appId, ((bj)localObject1).vBq);
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_username", (String)localObject3);
        ((Intent)localObject2).putExtra("key_from_scene", 5);
        if (paramAnonymousView != null)
        {
          localObject3 = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject3).appId = paramAnonymousView.field_appId;
          ((WxaExposedParams.a)localObject3).fFi = 6;
          ((Intent)localObject2).putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject3).RI());
        }
        d.b(((bj)localObject1).vAn.uRf.uRz, "appbrand", ".ui.AppBrandProfileUI", (Intent)localObject2);
        GMTrace.o(2279688110080L, 16985);
      }
    };
    this.vwf = new com.tencent.mm.sdk.b.c() {};
    this.vBp = new En_5b8fbb1e.b()
    {
      public final void bUh()
      {
        GMTrace.i(17610439655424L, 131208);
        GMTrace.o(17610439655424L, 131208);
      }
      
      public final void bUi()
      {
        GMTrace.i(17610573873152L, 131209);
        GMTrace.o(17610573873152L, 131209);
      }
      
      public final void bUj()
      {
        GMTrace.i(2296331108352L, 17109);
        v.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExit, then remove AppBrandTmplMsgReceivingSwitchListener.");
        com.tencent.mm.sdk.b.a.uql.c(bj.this.vwf);
        if (bj.this.vAn != null) {
          bj.this.vAn.b(this);
        }
        GMTrace.o(2296331108352L, 17109);
      }
    };
    this.vBo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2308410703872L, 17199);
        ds localds = (ds)paramAnonymousView.getTag();
        v.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localds.userName });
        pr localpr = new pr();
        localpr.fWr.userName = localds.userName;
        localpr.fWr.fWt = localds.vLh;
        Map localMap = bg.q(localds.fTa.field_content, "msg");
        String str = "";
        paramAnonymousView = str;
        if (localMap != null)
        {
          paramAnonymousView = str;
          if (localMap.size() > 0)
          {
            localpr.fWr.fWu = bf.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            paramAnonymousView = bf.mz((String)localMap.get(".msg.appmsg.template_id"));
          }
        }
        localpr.fWr.fWx = true;
        localpr.fWr.scene = 1014;
        localpr.fWr.fCE = (localds.fTa.field_msgSvrId + ":" + localds.userName + ":" + bj.this.vAn.bTW() + ":" + paramAnonymousView);
        com.tencent.mm.sdk.b.a.uql.m(localpr);
        bj.v(9, bj.this.ivn, bj.this.vBq);
        com.tencent.mm.plugin.report.service.g.oSF.i(11608, new Object[] { bj.this.vBq, localds.userName, Integer.valueOf(0) });
        GMTrace.o(2308410703872L, 17199);
      }
    };
    this.ljD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2308679139328L, 17201);
        paramAnonymousView = (ds)paramAnonymousView.getTag();
        Object localObject2 = bg.q(paramAnonymousView.fTa.field_content, "msg");
        if (localObject2 == null)
        {
          v.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
          GMTrace.o(2308679139328L, 17201);
          return;
        }
        Object localObject1 = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_username");
        String str = (String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_path");
        int i = bf.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
        int j = bf.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
        localObject2 = bf.mz((String)((Map)localObject2).get(".msg.appmsg.template_id"));
        v.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[] { localObject1 });
        pr localpr = new pr();
        localpr.fWr.userName = ((String)localObject1);
        localpr.fWr.fWt = str;
        localpr.fWr.fWu = j;
        localpr.fWr.fWv = i;
        localpr.fWr.fWx = true;
        localObject1 = localpr.fWr;
        if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).em(paramAnonymousView.userName)) {}
        for (i = 1014;; i = 1043)
        {
          ((pr.a)localObject1).scene = i;
          localpr.fWr.fCE = (paramAnonymousView.fTa.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + bj.this.vAn.bTW() + ":" + (String)localObject2);
          com.tencent.mm.sdk.b.a.uql.m(localpr);
          bj.v(9, bj.this.ivn, bj.this.vBq);
          com.tencent.mm.plugin.report.service.g.oSF.i(11608, new Object[] { bj.this.vBq, paramAnonymousView.userName, Integer.valueOf(0) });
          GMTrace.o(2308679139328L, 17201);
          return;
        }
      }
    };
    GMTrace.o(2488128241664L, 18538);
  }
  
  private static int To(String paramString)
  {
    int j = 0;
    GMTrace.i(2489738854400L, 18550);
    if (bf.mA(paramString))
    {
      GMTrace.o(2489738854400L, 18550);
      return 0;
    }
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[Α-￥]")) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    GMTrace.o(2489738854400L, 18550);
    return i;
  }
  
  private void a(ImageView paramImageView, En_5b8fbb1e.a parama, String paramString1, au paramau, String paramString2)
  {
    GMTrace.i(2489201983488L, 18546);
    if (paramImageView == null)
    {
      GMTrace.o(2489201983488L, 18546);
      return;
    }
    if (com.tencent.mm.u.o.fE(paramString1))
    {
      paramImageView.setVisibility(8);
      GMTrace.o(2489201983488L, 18546);
      return;
    }
    paramImageView.setVisibility(0);
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).em(paramString1))
    {
      com.tencent.mm.ah.n.GX().a(paramString2, paramImageView, this.uUw);
      paramImageView.setTag(new ds(paramau, paramString1, 1));
      paramImageView.setOnClickListener(this.vBn);
      paramImageView.setOnLongClickListener(parama.vzN.vDd);
      paramImageView.setContentDescription(com.tencent.mm.u.n.eK(paramString1) + parama.uRf.uRz.getString(R.l.dJf));
      GMTrace.o(2489201983488L, 18546);
      return;
    }
    paramau = com.tencent.mm.modelbiz.l.b(paramString1, null, 0);
    if (paramau != null)
    {
      paramImageView.setImageBitmap(paramau);
      label181:
      if (!parama.vzR) {
        break label286;
      }
    }
    label286:
    for (paramau = parama.bTW();; paramau = null)
    {
      paramImageView.setTag(new ds(paramString1, 1, paramau));
      paramImageView.setOnClickListener(parama.vzN.vDb);
      break;
      paramImageView.setImageResource(R.g.bcX);
      ap.yY();
      paramau = com.tencent.mm.u.c.wR().Rb(paramString1);
      if ((paramau == null) || ((int)paramau.gTG <= 0)) {
        break label181;
      }
      com.tencent.mm.u.ag.a.hlA.J(paramau.field_username, "");
      com.tencent.mm.x.b.he(paramau.field_username);
      break label181;
    }
  }
  
  private void a(dy paramdy, au paramau, Map<String, String> paramMap)
  {
    GMTrace.i(17917529817088L, 133496);
    LinearLayout localLinearLayout = paramdy.vLM;
    int j = localLinearLayout.getChildCount();
    int i = 0;
    if (i < 10)
    {
      if (i == 0) {}
      final String str1;
      for (paramdy = ".msg.appmsg.mmreader.template_detail.opitems.opitem";; paramdy = ".msg.appmsg.mmreader.template_detail.opitems.opitem" + i)
      {
        str1 = (String)paramMap.get(paramdy + ".word");
        if (!bf.mA(str1)) {
          break label179;
        }
        v.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[] { Integer.valueOf(i) });
        j = localLinearLayout.getChildCount();
        if (j <= i) {
          break label800;
        }
        if (i != 0) {
          break;
        }
        localLinearLayout.removeAllViews();
        GMTrace.o(17917529817088L, 133496);
        return;
      }
      localLinearLayout.removeViews(i, j - i);
      GMTrace.o(17917529817088L, 133496);
      return;
      label179:
      Object localObject1;
      label198:
      final Object localObject2;
      final int k;
      label318:
      final String str2;
      if (i < j)
      {
        localObject1 = (LinearLayout)localLinearLayout.getChildAt(i);
        localObject1 = (u)((LinearLayout)localObject1).getTag();
        localObject2 = (String)paramMap.get(paramdy + ".icon");
        k = d(paramMap, paramdy + ".color", -16777216);
        ((u)localObject1).iUi.setTextColor(k);
        ((u)localObject1).iUi.setText(str1);
        if (!bf.mA((String)localObject2)) {
          break label727;
        }
        ((u)localObject1).jiQ.setVisibility(8);
        ((u)localObject1).iUi.setPadding(0, 0, 0, 0);
        str2 = (String)paramMap.get(paramdy + ".url");
        str1 = bf.mz((String)paramMap.get(".msg.fromusername"));
        final int m = bf.getInt((String)paramMap.get(paramdy + ".op_type"), 0);
        localObject2 = (String)paramMap.get(paramdy + ".weapp_username");
        ds localds = new ds(paramau, str1, str2);
        ((u)localObject1).vyg.setTag(localds);
        k = i + 1;
        if ((m != 1) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          break label775;
        }
        str2 = (String)paramMap.get(paramdy + ".weapp_path");
        m = bf.getInt((String)paramMap.get(paramdy + ".weapp_version"), 0);
        paramdy = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(17916053422080L, 133485);
            paramAnonymousView = (ds)paramAnonymousView.getTag();
            v.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { localObject2 });
            pr localpr = new pr();
            localpr.fWr.userName = localObject2;
            localpr.fWr.fWt = str2;
            localpr.fWr.fWu = this.vBC;
            localpr.fWr.fWv = m;
            localpr.fWr.fWx = true;
            pr.a locala = localpr.fWr;
            if (com.tencent.mm.t.h.em(str1)) {}
            for (int i = 1014;; i = 1043)
            {
              locala.scene = i;
              localpr.fWr.fCE = (paramAnonymousView.fTa.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + bj.this.vAn.bTW() + ":" + this.vAt);
              com.tencent.mm.sdk.b.a.uql.m(localpr);
              bj.v(9, bj.this.ivn, bj.this.vBq);
              com.tencent.mm.plugin.report.service.g.oSF.i(11608, new Object[] { bj.this.vBq, str1, Integer.valueOf(k) });
              GMTrace.o(17916053422080L, 133485);
              return;
            }
          }
        };
        ((u)localObject1).vyg.setOnClickListener(paramdy);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (LinearLayout)LayoutInflater.from(this.vAn.uRf.uRz).inflate(R.i.cXi, null, false);
        localObject2 = new u();
        ((u)localObject2).iUi = ((TextView)((LinearLayout)localObject1).findViewById(R.h.cni));
        ((u)localObject2).jiQ = ((ImageView)((LinearLayout)localObject1).findViewById(R.h.cnh));
        ((u)localObject2).vyg = ((LinearLayout)((LinearLayout)localObject1).findViewById(R.h.cng));
        ((LinearLayout)localObject1).setTag(localObject2);
        localLinearLayout.addView((View)localObject1);
        break label198;
        label727:
        ((u)localObject1).jiQ.setVisibility(0);
        f(((u)localObject1).jiQ, (String)localObject2);
        ((u)localObject1).iUi.setPadding(0, 0, com.tencent.mm.bg.a.fromDPToPix(this.vAn.uRf.uRz, 28), 0);
        break label318;
        label775:
        ((u)localObject1).vyg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(17901557907456L, 133377);
            if (!bf.mA(str2))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("rawUrl", str2);
              d.b(bj.this.vAn.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              com.tencent.mm.plugin.report.service.g.oSF.i(11608, new Object[] { bj.this.vBq, str1, Integer.valueOf(k) });
            }
            GMTrace.o(17901557907456L, 133377);
          }
        });
      }
    }
    label800:
    GMTrace.o(17917529817088L, 133496);
  }
  
  private void a(dy paramdy, String paramString1, String paramString2)
  {
    GMTrace.i(17917395599360L, 133495);
    paramdy.vLy.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.vAn.uRf.uRz, paramString2, paramdy.vLy.getTextSize()));
    com.tencent.mm.ah.n.GX().a(paramString1, paramdy.vLx, this.uUw);
    paramdy.vLx.setTag(null);
    paramdy.vLx.setOnClickListener(null);
    paramdy.vLw.setTag(null);
    paramdy.vLw.setOnClickListener(null);
    paramdy.vLw.setVisibility(0);
    GMTrace.o(17917395599360L, 133495);
  }
  
  private static int d(Map<String, String> paramMap, String paramString, int paramInt)
  {
    GMTrace.i(2489604636672L, 18549);
    if ((paramMap == null) || (bf.mA(paramString)))
    {
      GMTrace.o(2489604636672L, 18549);
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(bf.mz((String)paramMap.get(paramString)));
      paramInt = i;
    }
    catch (Exception paramMap)
    {
      for (;;) {}
    }
    GMTrace.o(2489604636672L, 18549);
    return paramInt;
  }
  
  private static void f(ImageView paramImageView, String paramString)
  {
    GMTrace.i(2489336201216L, 18547);
    if ((bf.mA(paramString)) || (paramImageView == null))
    {
      GMTrace.o(2489336201216L, 18547);
      return;
    }
    Object localObject = new c.a();
    ap.yY();
    ((c.a)localObject).hIw = com.tencent.mm.u.c.xc();
    ((c.a)localObject).hIt = true;
    ((c.a)localObject).hIP = true;
    localObject = ((c.a)localObject).Hh();
    com.tencent.mm.ah.n.GX().a(paramString, paramImageView, (com.tencent.mm.ah.a.a.c)localObject);
    GMTrace.o(2489336201216L, 18547);
  }
  
  public static void v(int paramInt, String paramString1, String paramString2)
  {
    GMTrace.i(2489470418944L, 18548);
    v.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[] { Integer.valueOf(13796), Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.g.oSF.i(13796, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0), Long.valueOf(bf.Nz()) });
    GMTrace.o(2489470418944L, 18548);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2488262459392L, 18539);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXt);
      paramLayoutInflater = new dk(this.klJ);
      paramLayoutInflater.mdQ = ((CheckBox)((View)localObject).findViewById(R.h.bzW));
      paramLayoutInflater.nQv = ((View)localObject).findViewById(R.h.bAQ);
      paramLayoutInflater.phd = ((TextView)((View)localObject).findViewById(R.h.bBz));
      paramLayoutInflater.ipb = ((ImageView)((View)localObject).findViewById(R.h.bzM));
      paramLayoutInflater.kvw = ((TextView)((View)localObject).findViewById(R.h.bBt));
      paramLayoutInflater.vyb = ((LinearLayout)((View)localObject).findViewById(R.h.bAd));
      paramLayoutInflater.vGd.oIQ = ((View)localObject).findViewById(R.h.bAD);
      paramLayoutInflater.vGd.vGf = ((View)localObject).findViewById(R.h.bVO);
      paramLayoutInflater.vGd.iUi = ((TextView)paramLayoutInflater.vGd.oIQ.findViewById(R.h.title));
      paramLayoutInflater.vGd.mxJ = ((TextView)paramLayoutInflater.vGd.oIQ.findViewById(R.h.cId));
      paramLayoutInflater.vGd.vGg = ((LinearLayout)paramLayoutInflater.vGd.oIQ.findViewById(R.h.bJp));
      paramLayoutInflater.vGd.vyf = ((TextView)paramLayoutInflater.vyb.findViewById(R.h.bIm));
      paramLayoutInflater.vGd.vGh = paramLayoutInflater.vyb.findViewById(R.h.cCs);
      paramLayoutInflater.vGe.vLu = ((View)localObject).findViewById(R.h.bAC);
      paramLayoutInflater.vGe.vLv = ((ImageView)((View)localObject).findViewById(R.h.cno));
      paramLayoutInflater.vGe.vLw = ((View)localObject).findViewById(R.h.cnn);
      paramLayoutInflater.vGe.vLy = ((TextView)((View)localObject).findViewById(R.h.cnB));
      paramLayoutInflater.vGe.vLx = ((ImageView)((View)localObject).findViewById(R.h.cmY));
      paramLayoutInflater.vGe.vLz = ((View)localObject).findViewById(R.h.cmZ);
      paramLayoutInflater.vGe.vLA = ((View)localObject).findViewById(R.h.cnq);
      paramLayoutInflater.vGe.vLB = ((TextView)((View)localObject).findViewById(R.h.cnv));
      paramLayoutInflater.vGe.vLC = ((TextView)((View)localObject).findViewById(R.h.cnu));
      paramLayoutInflater.vGe.vLD = ((TextView)((View)localObject).findViewById(R.h.cnm));
      paramLayoutInflater.vGe.xoh = ((View)localObject).findViewById(R.h.jcd);
      paramLayoutInflater.vGe.vLE = ((LinearLayout)((View)localObject).findViewById(R.h.cnw));
      paramLayoutInflater.vGe.vLF = ((TextView)((View)localObject).findViewById(R.h.cny));
      paramLayoutInflater.vGe.vLH = ((TextView)((View)localObject).findViewById(R.h.cnz));
      paramLayoutInflater.vGe.vLG = ((TextView)((View)localObject).findViewById(R.h.cnA));
      paramLayoutInflater.vGe.vLI = ((View)localObject).findViewById(R.h.cnx);
      paramLayoutInflater.vGe.vLJ = ((LinearLayout)((View)localObject).findViewById(R.h.cnp));
      paramLayoutInflater.vGe.vLN = ((View)localObject).findViewById(R.h.cnl);
      paramLayoutInflater.vGe.vLK = ((View)localObject).findViewById(R.h.buD);
      paramLayoutInflater.vGe.vLL = ((LinearLayout)((View)localObject).findViewById(R.h.cnj));
      paramLayoutInflater.vGe.vLM = ((LinearLayout)((View)localObject).findViewById(R.h.bKw));
      paramLayoutInflater.vGe.vLO = ((LinearLayout)((View)localObject).findViewById(R.h.cna));
      paramLayoutInflater.vGe.vLR = ((TextView)((View)localObject).findViewById(R.h.cnc));
      paramLayoutInflater.vGe.vLT = ((ImageView)((View)localObject).findViewById(R.h.cnb));
      paramLayoutInflater.vGe.vLQ = ((View)localObject).findViewById(R.h.cnk);
      paramLayoutInflater.vGe.vLP = ((LinearLayout)((View)localObject).findViewById(R.h.cnd));
      paramLayoutInflater.vGe.vLS = ((TextView)((View)localObject).findViewById(R.h.cnf));
      paramLayoutInflater.vGe.vLU = ((ImageView)((View)localObject).findViewById(R.h.cne));
      paramLayoutInflater.vGe.vLV = ((ImageView)((View)localObject).findViewById(R.h.cmX));
      paramLayoutInflater.vxg = ((ImageView)((View)localObject).findViewById(R.h.bAB));
      paramLayoutInflater.vGe.vLW = ((View)localObject).findViewById(R.h.cnr);
      paramLayoutInflater.vGe.vLX = ((ImageView)((View)localObject).findViewById(R.h.cns));
      paramLayoutInflater.vGe.vLY = ((TextView)((View)localObject).findViewById(R.h.cnt));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    GMTrace.o(2488262459392L, 18539);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, final En_5b8fbb1e.a parama1, au paramau, final String paramString)
  {
    GMTrace.i(2488530894848L, 18541);
    this.vAn = parama1;
    dk localdk = (dk)parama;
    Object localObject1 = bg.q(paramau.field_content, "msg");
    if ((localObject1 == null) || (((Map)localObject1).size() == 0))
    {
      v.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
      localdk.vyb.setVisibility(8);
      GMTrace.o(2488530894848L, 18541);
      return;
    }
    localdk.vyb.setVisibility(0);
    final int i = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    this.vBq = bf.mz((String)((Map)localObject1).get(".msg.appmsg.template_id"));
    com.tencent.mm.sdk.b.a.uql.c(this.vwf);
    parama1.b(this.vBp);
    final dy localdy;
    label260:
    final int j;
    int k;
    label403:
    label450:
    label472:
    boolean bool;
    if (i != 0)
    {
      localdk.vGd.oIQ.setVisibility(8);
      localdy = localdk.vGe;
      if (bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1)
      {
        a(localdy, bf.mz((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bf.mz((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")));
        if (bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) == 0) {
          break label1565;
        }
        localdy.vLw.setBackgroundResource(R.g.bhb);
        j = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);
        if (j != 0) {
          break label1615;
        }
        localdy.vLB.setVisibility(0);
        parama = bf.mz((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_header.title"));
        k = d((Map)localObject1, ".msg.appmsg.mmreader.template_header.title_color", -16777216);
        localdy.vLB.setTextColor(k);
        localdy.vLB.setText(parama);
        long l = bf.getLong(bf.mz((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_header.pub_time")), 0L);
        if (l <= 0L) {
          break label1602;
        }
        localdy.vLC.setText(com.tencent.mm.pluginsdk.j.o.Z(this.vAn.getString(R.l.elj), l));
        localdy.vLC.setVisibility(0);
        parama = bf.mz((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_header.first_data"));
        k = d((Map)localObject1, ".msg.appmsg.mmreader.template_header.first_color", vBs);
        if (!bf.mA(parama)) {
          break label1638;
        }
        localdy.vLD.setVisibility(8);
        if ((j == 0) || (!bf.mA(parama))) {
          break label1714;
        }
        localdy.xoh.setVisibility(8);
        bool = false;
        if (!"notifymessage".equals(paramau.field_talker)) {
          break label5025;
        }
        parama = bf.mz((String)((Map)localObject1).get(".msg.fromusername"));
        bool = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).em(parama);
        if (!bool) {
          break label1774;
        }
        this.vAn.a(this.vBp);
        com.tencent.mm.sdk.b.a.uql.b(this.vwf);
        parama1 = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(parama);
        if (parama1 == null) {
          break label1732;
        }
        if ((parama1.field_appOpt & 0x1) <= 0) {
          break label1726;
        }
        i = 1;
        label582:
        this.ivn = parama1.field_appId;
      }
    }
    for (;;)
    {
      label590:
      parama = localdy.vLz;
      label604:
      label624:
      label896:
      label905:
      label935:
      final Object localObject2;
      if (i != 0)
      {
        i = 0;
        parama.setVisibility(i);
        parama = localdy.vLA;
        if (!bool) {
          break label1787;
        }
        i = 0;
        parama.setVisibility(i);
        localdy.vLA.setTag(R.h.cnq, paramau);
        localdy.vLA.setTag(R.h.cmZ, localdy);
        localdy.vLA.setOnClickListener(this.vBm);
        localdy.vLv.setVisibility(8);
        parama = bf.mz((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_header.first_data"));
        localdy.vLD.setText(parama);
        parama = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
        parama1 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
        if (bf.mA(parama1)) {
          break label1827;
        }
        i = d((Map)localObject1, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", -16777216);
        j = d((Map)localObject1, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", -16777216);
        k = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
        localdy.vLF.setTextColor(i);
        localdy.vLH.setTextColor(j);
        localdy.vLF.setText(parama);
        if ((k <= 0) || (k >= parama1.length())) {
          break label1794;
        }
        localdy.vLG.setVisibility(0);
        localdy.vLG.setText(parama1.substring(0, k));
        localdy.vLG.setTextColor(j);
        localdy.vLH.setTypeface(com.tencent.mm.wallet_core.ui.e.fm(this.vAn.uRf.uRz));
        localdy.vLH.setText(parama1.substring(k));
        localdy.vLE.setVisibility(0);
        parama1 = new ArrayList();
        i = 0;
        j = 0;
        if (j < 100)
        {
          if (j != 0) {
            break label1840;
          }
          parama = ".msg.appmsg.mmreader.template_detail.line_content.lines.line";
          paramString = (String)((Map)localObject1).get(parama + ".value.word");
          localObject2 = (String)((Map)localObject1).get(parama + ".key.word");
          if ((!bf.mA(paramString)) || (!bf.mA((String)localObject2))) {
            break label1862;
          }
          v.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", new Object[] { Integer.valueOf(j) });
        }
        if (i <= 8) {
          break label2053;
        }
        i = 8;
        label1047:
        paramString = localdy.vLJ;
        if (paramString.getChildCount() > parama1.size())
        {
          if (parama1.size() != 0) {
            break label2056;
          }
          paramString.removeAllViews();
        }
        label1082:
        k = paramString.getChildCount();
        j = 0;
        label1092:
        if (j >= parama1.size()) {
          break label2209;
        }
        localObject2 = (dt)parama1.get(j);
        if (j >= k) {
          break label2086;
        }
        parama = (LinearLayout)paramString.getChildAt(j);
        label1134:
        parama = (du)parama.getTag();
        if (!((dt)localObject2).vLn) {
          break label2165;
        }
        parama.vLo.setVisibility(8);
      }
      label1325:
      label1448:
      label1486:
      label1565:
      label1602:
      label1615:
      label1638:
      label1714:
      label1726:
      label1732:
      label1774:
      label1787:
      label1794:
      label1827:
      label1840:
      label1862:
      final Object localObject3;
      for (;;)
      {
        parama.vLp.setTextColor(((dt)localObject2).vLm);
        parama.vLp.setText(((dt)localObject2).vLk);
        j += 1;
        break label1092;
        if (bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0)
        {
          a(localdy, bf.mz((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_header.icon_url")), bf.mz((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_header.display_name")));
          break;
        }
        if ("notifymessage".equals(paramau.field_talker))
        {
          parama1 = bf.mz((String)((Map)localObject1).get(".msg.fromusername"));
          if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).em(parama1))
          {
            paramString = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(parama1);
            if (paramString == null)
            {
              parama = null;
              a(localdy.vLx, this.vAn, parama1, paramau, parama);
              if (paramString != null) {
                break label1448;
              }
              parama = parama1;
            }
          }
          for (;;)
          {
            localdy.vLy.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.vAn.uRf.uRz, parama, localdy.vLy.getTextSize()));
            if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).em(parama1)) {
              break label1486;
            }
            localdy.vLw.setTag(new ds(paramau, parama1, 0));
            localdy.vLw.setOnClickListener(this.vBn);
            localdy.vLw.setVisibility(0);
            break;
            parama = paramString.field_brandIconURL;
            break label1325;
            parama = paramString.field_nickname;
            continue;
            a(localdy.vLx, this.vAn, parama1, paramau, null);
            parama = this.vAn.eK(parama1);
          }
          paramString = localdy.vLw;
          if (this.vAn.vzR) {}
          for (parama = this.vAn.bTW();; parama = null)
          {
            paramString.setTag(new ds(parama1, 1, parama));
            localdy.vLw.setOnClickListener(this.vAn.vzN.vDb);
            break;
          }
        }
        localdy.vLw.setVisibility(8);
        break;
        j = localdy.vLw.getPaddingLeft();
        localdy.vLw.setBackgroundResource(R.g.bgg);
        localdy.vLw.setPadding(j, 0, 0, 0);
        break label260;
        localdy.vLC.setVisibility(8);
        break label403;
        localdy.vLB.setVisibility(8);
        localdy.vLC.setVisibility(8);
        break label403;
        localdy.vLD.setTextColor(k);
        localdy.vLD.setText(parama);
        localdy.vLD.setVisibility(0);
        if (i == 2)
        {
          localdy.vLD.setPadding(0, this.vAn.getResources().getDimensionPixelOffset(R.f.aXs), 0, 0);
          break label450;
        }
        localdy.vLD.setPadding(0, 0, 0, 0);
        break label450;
        localdy.xoh.setVisibility(0);
        break label472;
        i = 0;
        break label582;
        v.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[] { parama });
        ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).a(parama, new b.a()
        {
          public final void c(WxaAttributes paramAnonymousWxaAttributes)
          {
            int j = 0;
            GMTrace.i(17911355801600L, 133450);
            if (paramAnonymousWxaAttributes == null)
            {
              GMTrace.o(17911355801600L, 133450);
              return;
            }
            bj.this.ivn = paramAnonymousWxaAttributes.field_appId;
            if ((paramAnonymousWxaAttributes.field_appOpt & 0x1) > 0)
            {
              i = 1;
              paramAnonymousWxaAttributes = localdy.vLz;
              if (i == 0) {
                break label78;
              }
            }
            label78:
            for (int i = j;; i = 8)
            {
              paramAnonymousWxaAttributes.setVisibility(i);
              GMTrace.o(17911355801600L, 133450);
              return;
              i = 0;
              break;
            }
          }
        });
        i = 0;
        break label590;
        i = 8;
        break label604;
        i = 8;
        break label624;
        localdy.vLG.setVisibility(8);
        localdy.vLH.setTypeface(Typeface.DEFAULT);
        localdy.vLH.setText(parama1);
        break label896;
        localdy.vLE.setVisibility(8);
        break label905;
        parama = ".msg.appmsg.mmreader.template_detail.line_content.lines.line" + j;
        break label935;
        localObject3 = new dt();
        ((dt)localObject3).vLk = paramString;
        ((dt)localObject3).vLj = bf.mz((String)localObject2);
        ((dt)localObject3).vLl = d((Map)localObject1, parama + ".key.color", vBr);
        ((dt)localObject3).vLm = d((Map)localObject1, parama + ".value.color", -16777216);
        if (bf.getInt((String)((Map)localObject1).get(parama + ".key.hide"), 0) != 0)
        {
          bool = true;
          label1994:
          ((dt)localObject3).vLn = bool;
          k = (To(((dt)localObject3).vLj) + 1) / 2;
          if (k <= i) {
            break label2050;
          }
          i = k;
        }
        label2050:
        for (;;)
        {
          parama1.add(localObject3);
          j += 1;
          break;
          bool = false;
          break label1994;
        }
        label2053:
        break label1047;
        label2056:
        j = paramString.getChildCount();
        paramString.removeViews(parama1.size(), j - parama1.size());
        break label1082;
        label2086:
        parama = (LinearLayout)LayoutInflater.from(this.vAn.uRf.uRz).inflate(R.i.cXj, null, false);
        localObject3 = new du();
        ((du)localObject3).vLo = ((TextView)parama.findViewById(R.h.cbf));
        ((du)localObject3).vLp = ((TextView)parama.findViewById(R.h.cbg));
        parama.setTag(localObject3);
        paramString.addView(parama);
        break label1134;
        label2165:
        parama.vLo.setVisibility(0);
        parama.vLo.setEms(i);
        parama.vLo.setTextColor(((dt)localObject2).vLl);
        parama.vLo.setText(((dt)localObject2).vLj);
      }
      label2209:
      label2303:
      final Object localObject4;
      if (paramString.getChildCount() == 0)
      {
        localdy.vLI.setVisibility(8);
        paramString.setVisibility(8);
        if (bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) == 0) {
          break label2631;
        }
        localdy.vLW.setVisibility(8);
        localdy.vLL.setVisibility(8);
        localdy.vLN.setVisibility(8);
        localdy.vLM.setVisibility(0);
        a(localdy, paramau, (Map)localObject1);
        paramString = bf.mz((String)((Map)localObject1).get(".msg.fromusername"));
        parama = null;
        if (!bf.mA(paramString))
        {
          ap.yY();
          parama = com.tencent.mm.u.c.wR().Rb(paramString).tK();
        }
        localObject3 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.category.item.title");
        localObject4 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.category.item.url");
        localObject2 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.category.item.native_url");
        parama1 = (String)((Map)localObject1).get(".msg.appmsg.template_id");
        i = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        String str = (String)((Map)localObject1).get(".msg.appmsg.mmreader.category.item.weapp_username");
        if ((i != 1) || (TextUtils.isEmpty(str))) {
          break label4071;
        }
        paramString = new ds(paramau, paramString, (String)localObject4);
        paramString.position = paramInt;
        localdy.vLu.setTag(paramString);
        localdy.vLu.setOnClickListener(this.ljD);
      }
      for (;;)
      {
        localdy.vLu.setOnLongClickListener(this.vAn.vzN.vDd);
        if (com.tencent.mm.i.g.sW().sI())
        {
          localdk.vxg.setVisibility(0);
          c(this.vAn, localdk.vxg, new ej(parama1, paramau, parama));
        }
        localdk.vGe.vLu.setVisibility(0);
        GMTrace.o(2488530894848L, 18541);
        return;
        if (bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
          localdy.vLI.setVisibility(8);
        }
        for (;;)
        {
          paramString.setVisibility(0);
          break;
          localdy.vLI.setVisibility(0);
        }
        label2631:
        localdy.vLM.setVisibility(8);
        parama1 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
        parama = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
        if (!bf.mA(parama1))
        {
          i = d((Map)localObject1, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", -16777216);
          localdy.vLR.setTextColor(i);
          localdy.vLR.setText(parama1);
          if (bf.mA(parama))
          {
            localdy.vLT.setVisibility(8);
            localdy.vLR.setPadding(0, 0, 0, 0);
            label2737:
            localObject2 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
            parama1 = bf.mz((String)((Map)localObject1).get(".msg.fromusername"));
            i = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
            paramString = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
            localObject3 = new ds(paramau, parama1, (String)localObject2);
            localdy.vLO.setTag(localObject3);
            localdy.vLW.setTag(localObject3);
            if ((i != 1) || (TextUtils.isEmpty(paramString))) {
              break label3625;
            }
            localObject2 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
            i = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
            parama1 = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                GMTrace.i(2116747788288L, 15771);
                paramAnonymousView = (ds)paramAnonymousView.getTag();
                v.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { paramString });
                pr localpr = new pr();
                localpr.fWr.userName = paramString;
                localpr.fWr.fWt = localObject2;
                localpr.fWr.fWu = this.vBC;
                localpr.fWr.fWv = i;
                localpr.fWr.fWx = true;
                pr.a locala = localpr.fWr;
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).em(parama1)) {}
                for (int i = 1014;; i = 1043)
                {
                  locala.scene = i;
                  localpr.fWr.fCE = (paramAnonymousView.fTa.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + bj.this.vAn.bTW() + ":" + this.vAt);
                  com.tencent.mm.sdk.b.a.uql.m(localpr);
                  bj.v(9, bj.this.ivn, bj.this.vBq);
                  com.tencent.mm.plugin.report.service.g.oSF.i(11608, new Object[] { bj.this.vBq, parama1, Integer.valueOf(1) });
                  GMTrace.o(2116747788288L, 15771);
                  return;
                }
              }
            };
            localdy.vLO.setOnClickListener(parama1);
            localdy.vLW.setOnClickListener(parama1);
            label2952:
            localdy.vLO.setVisibility(0);
            label2961:
            paramString = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
            parama1 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
            if (bf.mA(paramString)) {
              break label3739;
            }
            i = d((Map)localObject1, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", -16777216);
            localdy.vLS.setTextColor(i);
            localdy.vLS.setText(paramString);
            if (!bf.mA(parama1)) {
              break label3669;
            }
            localdy.vLU.setVisibility(8);
            localdy.vLS.setPadding(0, 0, 0, 0);
            label3060:
            localObject3 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
            paramString = bf.mz((String)((Map)localObject1).get(".msg.fromusername"));
            i = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
            localObject2 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
            localdy.vLP.setTag(new ds(paramau, paramString, (String)localObject3));
            if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject2))) {
              break label3716;
            }
            localObject3 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
            i = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
            j = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
            localObject4 = bf.mz((String)((Map)localObject1).get(".msg.appmsg.template_id"));
            localdy.vLP.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                GMTrace.i(2246133678080L, 16735);
                paramAnonymousView = (ds)paramAnonymousView.getTag();
                v.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { localObject2 });
                pr localpr = new pr();
                localpr.fWr.userName = localObject2;
                localpr.fWr.fWt = localObject3;
                localpr.fWr.fWu = j;
                localpr.fWr.fWv = i;
                localpr.fWr.fWx = true;
                pr.a locala = localpr.fWr;
                if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).em(paramString)) {}
                for (int i = 1014;; i = 1043)
                {
                  locala.scene = i;
                  localpr.fWr.fCE = (paramAnonymousView.fTa.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + bj.this.vAn.bTW() + ":" + localObject4);
                  com.tencent.mm.sdk.b.a.uql.m(localpr);
                  bj.v(9, bj.this.ivn, bj.this.vBq);
                  com.tencent.mm.plugin.report.service.g.oSF.i(11608, new Object[] { bj.this.vBq, paramString, Integer.valueOf(2) });
                  GMTrace.o(2246133678080L, 16735);
                  return;
                }
              }
            });
            label3261:
            localdy.vLP.setVisibility(0);
            label3270:
            localdy.vLV.setVisibility(8);
            if ((localdy.vLO.getVisibility() != 8) || (localdy.vLP.getVisibility() != 8)) {
              break label3752;
            }
            localdy.vLL.setVisibility(8);
            localdy.vLK.setVisibility(8);
            localdy.vLN.setVisibility(8);
            if ((localdy.vLO.getVisibility() != 0) || (localdy.vLP.getVisibility() != 0)) {
              break label4027;
            }
            localdy.vLQ.setVisibility(0);
            label3367:
            parama = bf.mz((String)((Map)localObject1).get(".msg.fromusername"));
            i = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
            paramString = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
            if ((x.em(parama)) || (localdy.vLO.getVisibility() == 8) || (localdy.vLP.getVisibility() != 8) || (i != 1) || (!x.em(paramString))) {
              break label4058;
            }
            localObject2 = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(paramString);
            if (localObject2 != null) {
              break label4040;
            }
            parama = null;
            label3490:
            if (localObject2 != null) {
              break label4049;
            }
          }
        }
        label3625:
        label3669:
        label3716:
        label3739:
        label3752:
        label4027:
        label4040:
        label4049:
        for (parama1 = paramString;; parama1 = ((WxaAttributes)localObject2).field_nickname)
        {
          com.tencent.mm.ah.n.GX().a(parama, localdy.vLX, this.uUw);
          localdy.vLY.setText(parama1);
          if (localObject2 == null) {
            ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).a(paramString, new b.a()
            {
              public final void c(WxaAttributes paramAnonymousWxaAttributes)
              {
                GMTrace.i(17916456075264L, 133488);
                if (paramAnonymousWxaAttributes == null)
                {
                  GMTrace.o(17916456075264L, 133488);
                  return;
                }
                ae.v(new Runnable()
                {
                  public final void run()
                  {
                    GMTrace.i(16793456345088L, 125121);
                    com.tencent.mm.ah.n.GX().a(this.jgH, bj.4.this.vBE.vLX, bj.this.uUw);
                    if (TextUtils.isEmpty(this.vBF)) {}
                    for (String str = bj.4.this.vBA;; str = this.vBF)
                    {
                      bj.4.this.vBE.vLY.setText(str);
                      GMTrace.o(16793456345088L, 125121);
                      return;
                    }
                  }
                });
                GMTrace.o(17916456075264L, 133488);
              }
            });
          }
          localdy.vLW.setVisibility(0);
          localdy.vLL.setVisibility(8);
          break;
          localdy.vLT.setVisibility(0);
          f(localdy.vLT, parama);
          localdy.vLR.setPadding(0, 0, com.tencent.mm.bg.a.fromDPToPix(this.vAn.uRf.uRz, 16), 0);
          break label2737;
          localdy.vLO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              GMTrace.i(2239691227136L, 16687);
              if (!bf.mA(localObject2))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", localObject2);
                d.b(bj.this.vAn.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.g.oSF.i(11608, new Object[] { bj.this.vBq, parama1, Integer.valueOf(1) });
              }
              GMTrace.o(2239691227136L, 16687);
            }
          });
          localdy.vLW.setOnClickListener(null);
          break label2952;
          localdy.vLO.setVisibility(8);
          break label2961;
          localdy.vLU.setVisibility(0);
          f(localdy.vLU, parama1);
          localdy.vLS.setPadding(0, 0, com.tencent.mm.bg.a.fromDPToPix(this.vAn.uRf.uRz, 16), 0);
          break label3060;
          localdy.vLP.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              GMTrace.i(2118492618752L, 15784);
              if (!bf.mA(localObject3))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("rawUrl", localObject3);
                d.b(bj.this.vAn.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                com.tencent.mm.plugin.report.service.g.oSF.i(11608, new Object[] { bj.this.vBq, paramString, Integer.valueOf(2) });
              }
              GMTrace.o(2118492618752L, 15784);
            }
          });
          break label3261;
          localdy.vLP.setVisibility(8);
          break label3270;
          localdy.vLN.setVisibility(0);
          i = this.vAn.getResources().getDimensionPixelOffset(R.f.aXs);
          if ((localdy.vLO.getVisibility() == 0) && (localdy.vLP.getVisibility() == 0))
          {
            localdy.vLO.setGravity(17);
            localdy.vLP.setGravity(17);
            localdy.vLO.setPadding(i, 0, i, 0);
            localdy.vLP.setPadding(i, 0, i, 0);
          }
          for (;;)
          {
            localdy.vLL.setVisibility(0);
            localdy.vLK.setVisibility(0);
            break;
            if (localdy.vLO.getVisibility() == 0)
            {
              if (bf.mA(parama))
              {
                localdy.vLO.setGravity(19);
                localdy.vLO.setPadding(i, 0, 0, 0);
                localdy.vLV.setVisibility(0);
              }
              else
              {
                localdy.vLO.setGravity(17);
                localdy.vLO.setPadding(i, 0, i, 0);
              }
            }
            else if (bf.mA(parama1))
            {
              localdy.vLP.setGravity(19);
              localdy.vLP.setPadding(this.vAn.getResources().getDimensionPixelOffset(R.f.aXs), 0, 0, 0);
              localdy.vLV.setVisibility(0);
            }
            else
            {
              localdy.vLP.setGravity(17);
              localdy.vLP.setPadding(i, 0, i, 0);
            }
          }
          localdy.vLQ.setVisibility(8);
          break label3367;
          parama = ((WxaAttributes)localObject2).field_brandIconURL;
          break label3490;
        }
        label4058:
        localdy.vLW.setVisibility(8);
        break label2303;
        label4071:
        if ((i == -1) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).em(paramString)))
        {
          localObject1 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
          localObject4 = localdy.vLu;
          paramString = new ds(paramau, false, paramInt, paramString, 6, false, this.vAn.bVI(), paramString, parama, (String)localObject3);
          paramString.fZv = ((String)localObject2);
          paramString.vLh = ((String)localObject1);
          ((View)localObject4).setTag(paramString);
          localdy.vLu.setOnClickListener(this.vBo);
        }
        else
        {
          localObject1 = localdy.vLu;
          paramString = new ds(paramau, false, paramInt, (String)localObject4, 6, false, this.vAn.bVI(), paramString, parama, (String)localObject3);
          paramString.fZv = ((String)localObject2);
          ((View)localObject1).setTag(paramString);
          localdy.vLu.setOnClickListener(this.vAn.vzN.vDb);
        }
      }
      localdk.vGe.vLu.setVisibility(8);
      parama1 = bf.mz((String)((Map)localObject1).get(".msg.fromusername"));
      i = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
      v.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        parama = bf.mz((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
        paramString = bf.mz((String)((Map)localObject1).get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
        a(localdk, com.tencent.mm.pluginsdk.ui.d.h.b(this.vAn.uRf.uRz, paramString, localdk.phd.getTextSize()));
        localdk.ipb.setTag(null);
        localdk.ipb.setOnClickListener(null);
        com.tencent.mm.ah.n.GX().a(parama, localdk.ipb, this.uUw);
        v.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[] { paramau.field_talker });
        if ((!"notifymessage".equals(paramau.field_talker)) && (i != 1)) {
          break label4869;
        }
        localdk.vGd.vGf.setVisibility(0);
        localdk.vGd.iUi.setTextSize(0, com.tencent.mm.bg.a.T(localdk.vGd.iUi.getContext(), R.f.aXH));
        label4511:
        localdk.vGd.oIQ.setVisibility(0);
        paramString = dj.ai((Map)localObject1);
        if (!bf.mA(paramString.url)) {
          break label4915;
        }
        localdk.vGd.vGh.setVisibility(8);
        localdk.vGd.vyf.setVisibility(8);
        label4567:
        localdk.vGd.iUi.setText(paramString.title);
        localdk.vGd.mxJ.setText(com.tencent.mm.pluginsdk.j.o.Z(this.vAn.getString(R.l.elh), paramString.time));
        bk.a(localdk.vGd.vGg, (Map)localObject1);
        parama = null;
        if (!bf.mA(parama1))
        {
          ap.yY();
          parama = com.tencent.mm.u.c.wR().Rb(parama1).tK();
        }
        i = bf.getInt((String)((Map)localObject1).get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
        localObject1 = (String)((Map)localObject1).get(".msg.appmsg.mmreader.category.item.weapp_username");
        if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label4942;
        }
        parama1 = new ds(paramau, parama1, paramString.url);
        parama1.position = paramInt;
        localdk.vGd.oIQ.setTag(parama1);
        localdk.vGd.oIQ.setOnClickListener(this.ljD);
      }
      for (;;)
      {
        localdk.vGd.oIQ.setOnLongClickListener(this.vAn.vzN.vDd);
        if (com.tencent.mm.i.g.sW().sI())
        {
          localdk.vxg.setVisibility(0);
          c(this.vAn, localdk.vxg, new ej(paramString.hih, paramau, parama));
        }
        localdk.vGd.oIQ.setVisibility(0);
        GMTrace.o(2488530894848L, 18541);
        return;
        a(localdk, this.vAn, paramau, parama1);
        a(localdk.ipb, this.vAn, parama1, paramau, null);
        break;
        label4869:
        localdk.vGd.vGf.setVisibility(8);
        localdk.vGd.iUi.setTextSize(0, com.tencent.mm.bg.a.T(localdk.vGd.iUi.getContext(), R.f.aWx));
        break label4511;
        label4915:
        localdk.vGd.vGh.setVisibility(0);
        localdk.vGd.vyf.setVisibility(0);
        break label4567;
        label4942:
        localObject1 = localdk.vGd.oIQ;
        parama1 = new ds(paramau, false, paramInt, paramString.url, 6, false, this.vAn.bVI(), parama1, parama, paramString.title);
        parama1.fZv = paramString.fZv;
        ((View)localObject1).setTag(parama1);
        localdk.vGd.oIQ.setOnClickListener(this.vAn.vzN.vDb);
      }
      label5025:
      i = 0;
    }
  }
  
  protected final void a(ag.a parama, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2489067765760L, 18545);
    if ((paramString == null) || (parama.phd == null))
    {
      GMTrace.o(2489067765760L, 18545);
      return;
    }
    a(parama, com.tencent.mm.pluginsdk.ui.d.h.b(parama1.uRf.uRz, parama1.eK(paramString), parama.phd.getTextSize()));
    GMTrace.o(2489067765760L, 18545);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2488665112576L, 18542);
    paramau = (ds)paramView.getTag();
    if (paramau == null)
    {
      GMTrace.o(2488665112576L, 18542);
      return false;
    }
    int i = paramau.position;
    if (!this.vAn.bVz()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUh));
    }
    GMTrace.o(2488665112576L, 18542);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2488933548032L, 18544);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      GMTrace.o(2488933548032L, 18544);
      return false;
      paramMenuItem = bg.q(paramau.field_content, "msg");
      if ((paramMenuItem == null) || (paramMenuItem.size() == 0))
      {
        GMTrace.o(2488933548032L, 18544);
        return false;
      }
      paramMenuItem = bf.mz((String)paramMenuItem.get(".msg.fromusername"));
      if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).em(paramMenuItem)) {
        v(7, this.ivn, this.vBq);
      }
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2488799330304L, 18543);
    GMTrace.o(2488799330304L, 18543);
    return false;
  }
  
  protected final boolean bUf()
  {
    GMTrace.i(2488396677120L, 18540);
    GMTrace.o(2488396677120L, 18540);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */