package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.e.a.kq;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.j;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.tools.ShowImageUI;

final class az
  extends ag.c
{
  public En_5b8fbb1e.a vAn;
  private com.tencent.mm.ah.a.a.c vAx;
  
  public az(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2518461448192L, 18764);
    c.a locala = new c.a();
    locala.hII = R.k.dtp;
    locala.aO(com.tencent.mm.bg.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aa.getContext(), 20), com.tencent.mm.bg.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aa.getContext(), 20)).hIr = true;
    this.vAx = locala.Hh();
    GMTrace.o(2518461448192L, 18764);
  }
  
  private static void a(n paramn, cv paramcv, au paramau)
  {
    GMTrace.i(2518864101376L, 18767);
    if ((paramau.field_status == 2) && (a(paramcv, paramau.field_msgId)))
    {
      if (paramn.vwJ != null)
      {
        paramn.vwJ.setVisibility(0);
        GMTrace.o(2518864101376L, 18767);
      }
    }
    else if (paramn.vwJ != null) {
      paramn.vwJ.setVisibility(8);
    }
    GMTrace.o(2518864101376L, 18767);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2518595665920L, 18765);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof n)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYb);
      ((View)localObject).setTag(new n(this.klJ).q((View)localObject, false));
    }
    GMTrace.o(2518595665920L, 18765);
    return (View)localObject;
  }
  
  public final void a(final ag.a parama, int paramInt, final En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2518729883648L, 18766);
    final n localn = (n)parama;
    this.vAn = parama1;
    parama1.aI(paramau);
    localn.reset();
    String str = paramau.field_content;
    parama1.aG(paramau);
    f.a locala;
    Object localObject1;
    if (str != null)
    {
      locala = f.a.B(str, paramau.field_reserved);
      localObject1 = com.tencent.mm.t.j.eo(str);
    }
    for (;;)
    {
      paramString = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
      final Object localObject2 = paramString;
      Object localObject3;
      boolean bool;
      label584:
      label598:
      label695:
      label728:
      int i;
      if (locala != null)
      {
        localObject3 = com.tencent.mm.pluginsdk.model.app.g.cv(locala.appId, locala.fWv);
        localn.ipc.setText(locala.title);
        localn.ipd.setText(locala.description);
        localn.mwR.setMaxLines(1);
        localn.ipc.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.aVo));
        localn.ipd.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.aUo));
        localn.vxn.setBackgroundResource(R.g.bdQ);
        localn.vxn.setPadding(0, parama1.uRf.uRz.getResources().getDimensionPixelSize(R.f.aXy), 0, 0);
        localn.vwA.setVisibility(0);
        localn.vxl.setVisibility(0);
        localn.ipd.setVisibility(0);
        localn.vxp.setVisibility(8);
        localn.vxq.setVisibility(8);
        localn.vxd.setVisibility(8);
        localn.vxc.setVisibility(8);
        localn.vxa.setVisibility(8);
        localn.vwY.setVisibility(8);
        localn.vwX.setVisibility(8);
        localn.vxy.setVisibility(8);
        localn.vxr.setVisibility(8);
        localn.vxn.setVisibility(0);
        n.I(localn.vxm, localn.vwx);
        if ((localObject3 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appName.trim().length() > 0)) {
          break label1203;
        }
        localObject2 = locala.appName;
        bool = true;
        com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 12);
        if ((locala.type == 20) || ("wxaf060266bfa9a35c".equals(locala.appId))) {
          bool = l.a.bCf().baJ();
        }
        if ((!bool) || (locala.appId == null) || (locala.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.bn((String)localObject2))) {
          break label1230;
        }
        localn.lLh.setText(com.tencent.mm.pluginsdk.model.app.g.a(parama1.uRf.uRz, (com.tencent.mm.pluginsdk.model.app.f)localObject3, (String)localObject2));
        localn.vwZ.setVisibility(0);
        localn.lLh.setVisibility(0);
        localn.lLh.setCompoundDrawables(null, null, null, null);
        localn.vwW.setVisibility(0);
        if ((localObject3 == null) || (!((com.tencent.mm.pluginsdk.model.app.f)localObject3).bCM())) {
          break label1213;
        }
        a(parama1, localn.lLh, paramau, locala, ((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_packageName, paramau.field_msgSvrId);
        a(parama1, localn.vwW, locala.appId);
        bool = false;
        localn.vwA.setVisibility(0);
        if (!this.sWq) {
          break label1395;
        }
        localObject3 = null;
        localObject2 = localObject3;
        if (locala.type != 33)
        {
          localObject2 = localObject3;
          if (locala.type != 36) {
            localObject2 = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz), false);
          }
        }
        if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
          break label1389;
        }
        localn.vwA.setImageBitmap((Bitmap)localObject2);
        if (locala.type == 3) {
          localn.vxn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              GMTrace.i(2273245659136L, 16937);
              localn.vxn.getViewTreeObserver().removeOnPreDrawListener(this);
              int i = com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 24);
              Bitmap localBitmap = localObject2;
              Object localObject;
              if (localBitmap != null)
              {
                localObject = localBitmap;
                if (!localBitmap.isRecycled()) {}
              }
              else
              {
                localObject = com.tencent.mm.sdk.platformtools.d.U(parama1.uRf.uRz.getResources().getColor(R.e.aTo), i, i);
              }
              int j = ((Bitmap)localObject).getHeight();
              if (i > j) {
                i = j;
              }
              for (;;)
              {
                localObject = com.tencent.mm.sdk.platformtools.d.c(com.tencent.mm.sdk.platformtools.d.N(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                j = localn.vxn.getHeight();
                int k = localn.vxn.getWidth();
                i = j;
                if (j == 0) {
                  i = com.tencent.mm.bg.a.T(parama1.uRf.uRz, R.f.aZe);
                }
                j = k;
                if (k == 0) {
                  j = com.tencent.mm.bg.a.T(parama1.uRf.uRz, R.f.aZf);
                }
                localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, R.g.bdQ, j, i));
                localn.vxn.setBackgroundDrawable((Drawable)localObject);
                GMTrace.o(2273245659136L, 16937);
                return true;
              }
            }
          });
        }
        localn.vxe.setOnClickListener(null);
        switch (locala.type)
        {
        case 1: 
        case 2: 
        case 8: 
        case 9: 
        case 11: 
        case 12: 
        case 14: 
        case 17: 
        case 18: 
        case 21: 
        case 22: 
        case 23: 
        case 28: 
        case 29: 
        case 30: 
        case 31: 
        case 32: 
        case 35: 
        case 37: 
        case 38: 
        case 39: 
        default: 
          parama = paramString;
          i = 1;
        }
      }
      for (;;)
      {
        label926:
        if (i != 0)
        {
          if ((locala.title == null) || (locala.title.length() <= 0)) {
            break label6248;
          }
          localn.mwR.setVisibility(0);
          localn.mwR.setMaxLines(2);
          localn.mwR.setText(locala.title);
          label981:
          localn.ipc.setVisibility(8);
          if (bool)
          {
            if ((locala.type != 33) && (locala.type != 36)) {
              break label6261;
            }
            paramString = com.tencent.mm.ah.n.GT().jw(paramau.field_imgPath);
            localn.vwA.setImageResource(R.k.dtk);
            com.tencent.mm.modelappbrand.a.b.AY().a(localn.vwA, "file://" + paramString, null, null, ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aL(50, 50));
          }
        }
        for (;;)
        {
          n.a(localn, str, locala.hhg);
          localObject2 = parama;
          localn.vxm.setTag(localObject2);
          localn.vxm.setOnClickListener(parama1.vzN.vDb);
          if (this.sWq)
          {
            localn.vxm.setOnLongClickListener(parama1.vzN.vDd);
            localn.vxm.setOnTouchListener(parama1.vzN.vDf);
          }
          a(paramInt, localn, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
          GMTrace.o(2518729883648L, 18766);
          return;
          label1203:
          localObject2 = ((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_appName;
          break;
          label1213:
          a(parama1, localn.lLh, locala.appId);
          break label584;
          label1230:
          if (locala.type == 24)
          {
            localn.lLh.setText(com.tencent.mm.sdk.platformtools.aa.getContext().getString(R.l.ehq));
            localn.vwZ.setVisibility(0);
            localn.lLh.setVisibility(0);
            localn.vwW.setVisibility(8);
            break label598;
          }
          if ((locala.type == 19) || (((com.tencent.mm.t.j)localObject1).hkf == 19))
          {
            localn.lLh.setText(com.tencent.mm.sdk.platformtools.aa.getContext().getString(R.l.dTU));
            localn.vwZ.setVisibility(0);
            localn.lLh.setVisibility(0);
            localn.vwW.setVisibility(8);
            break label598;
          }
          localn.vwZ.setVisibility(8);
          localn.lLh.setVisibility(8);
          localn.vwW.setVisibility(8);
          break label598;
          label1389:
          bool = true;
          break label695;
          label1395:
          localn.vwA.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.bhM));
          bool = false;
          break label728;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            localn.ipc.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.white));
            label1471:
            localn.ipd.setVisibility(0);
            localn.ipd.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.white));
            localn.mwR.setVisibility(8);
            localn.vxa.setVisibility(4);
            localn.ipd.setMaxLines(2);
            localn.vxe.setVisibility(0);
            if (parama.vAl != paramau.field_msgId) {
              break label1717;
            }
            localn.vxe.setImageResource(R.g.bhm);
            label1565:
            parama = new cv.b();
            parama.fGD = paramau.field_msgId;
            parama.fQO = paramau.field_content;
            parama.fNR = paramau.field_imgPath;
            localn.vxe.setTag(parama);
            localn.vxe.setOnClickListener(parama1.vzN.vDl);
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
              if ((parama != null) && (!parama.isRecycled())) {
                break label1731;
              }
              localn.vwA.setImageResource(R.k.dsW);
            }
          }
          for (;;)
          {
            if (!bUg()) {
              break label1743;
            }
            if (localn.oCh == null) {
              break label6365;
            }
            localn.oCh.setVisibility(8);
            parama = paramString;
            i = 0;
            break;
            localn.ipc.setVisibility(8);
            break label1471;
            label1717:
            localn.vxe.setImageResource(R.g.bhn);
            break label1565;
            label1731:
            localn.vwA.setImageBitmap(parama);
          }
          label1743:
          if (localn.oCh == null) {
            break label6365;
          }
          localn.oCh.setVisibility(0);
          if (paramau.field_status < 2) {
            break label6365;
          }
          localn.oCh.setVisibility(8);
          parama = paramString;
          i = 0;
          break label926;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            localn.ipc.setMaxLines(2);
          }
          for (;;)
          {
            localn.ipd.setVisibility(0);
            localn.mwR.setVisibility(8);
            localn.vxa.setVisibility(4);
            localn.ipd.setMaxLines(2);
            localn.ipd.setText(bf.ay(locala.hhg));
            localn.vxe.setVisibility(8);
            n.a(localn, Boolean.valueOf(false), paramau, locala.fCN, locala.title);
            if (!bool) {
              break label6365;
            }
            if (!bf.Ql(locala.hhh)) {
              break label1959;
            }
            localn.vwA.setImageResource(R.g.bcg);
            parama = paramString;
            i = 0;
            break;
            localn.ipc.setVisibility(8);
          }
          label1959:
          localn.vwA.setImageResource(com.tencent.mm.pluginsdk.model.q.LU(locala.hhh));
          parama = paramString;
          i = 0;
          break label926;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            label2012:
            localn.ipd.setVisibility(0);
            localn.mwR.setVisibility(8);
            localn.ipd.setMaxLines(2);
            localn.vxa.setVisibility(4);
            localn.vxe.setVisibility(0);
            localn.vxe.setImageResource(R.g.bkU);
            if (!bool) {
              break label6365;
            }
            parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
            if ((parama != null) && (!parama.isRecycled())) {
              break label2148;
            }
            localn.vwA.setImageResource(R.k.dth);
          }
          for (;;)
          {
            localn.vxe.setVisibility(8);
            parama = paramString;
            i = 0;
            break;
            localn.ipc.setVisibility(8);
            break label2012;
            label2148:
            localn.vwA.setImageBitmap(parama);
          }
          localObject1 = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(locala.hjC);
          if (localObject1 != null)
          {
            parama = ((WxaAttributes)localObject1).field_nickname;
            label2192:
            if (localObject1 == null) {
              break label2431;
            }
          }
          label2431:
          for (localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;; localObject1 = locala.hjL)
          {
            localn.vxn.setVisibility(8);
            localn.vxy.setVisibility(0);
            localn.vxr.setVisibility(8);
            localn.vxu.setVisibility(8);
            localn.vxB.setText(locala.title);
            localn.vxu.setText(locala.description);
            localn.vxw.setText(parama);
            localn.vxx.setText(R.l.dDQ);
            com.tencent.mm.ah.n.GX().a((String)localObject1, localn.vxv, this.vAx);
            parama = com.tencent.mm.ah.n.GT().jw(paramau.field_imgPath);
            localn.vxz.setImageBitmap(null);
            com.tencent.mm.modelappbrand.a.b.AY().a(localn.vxz, "file://" + parama, null, null, ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aL(215, 168));
            if (!bUg()) {
              break label2441;
            }
            a(localn, parama1.vzN, paramau);
            if (localn.oCh == null) {
              break label6365;
            }
            localn.oCh.setVisibility(8);
            parama = paramString;
            i = 0;
            break;
            parama = locala.fUI;
            break label2192;
          }
          label2441:
          if (localn.oCh == null) {
            break label6365;
          }
          localn.oCh.setVisibility(0);
          if (paramau.field_status < 2) {
            break label6365;
          }
          localn.oCh.setVisibility(8);
          parama = paramString;
          i = 0;
          break label926;
          localn.ipc.setVisibility(8);
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.mwR.setMaxLines(2);
            localn.mwR.setVisibility(0);
            localn.mwR.setText(locala.title);
            label2546:
            localn.ipd.setMaxLines(3);
            localn.vxa.setVisibility(4);
            localn.vxe.setVisibility(8);
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
              if (parama != null) {
                break label2712;
              }
              parama = com.tencent.mm.platformtools.j.a(new com.tencent.mm.pluginsdk.model.s(locala.thumburl, paramau.field_type, "@S", false));
              if (parama == null) {
                break label2698;
              }
              localn.vwA.setImageBitmap(parama);
            }
          }
          for (;;)
          {
            if (!bUg()) {
              break label2745;
            }
            a(localn, parama1.vzN, paramau);
            if (localn.oCh == null) {
              break label6365;
            }
            localn.oCh.setVisibility(8);
            parama = paramString;
            i = 0;
            break;
            localn.mwR.setVisibility(8);
            break label2546;
            label2698:
            localn.vwA.setImageResource(R.k.dtk);
            continue;
            label2712:
            if (parama.isRecycled()) {
              localn.vwA.setImageResource(R.k.dtk);
            } else {
              localn.vwA.setImageBitmap(parama);
            }
          }
          label2745:
          if (localn.oCh == null) {
            break label6365;
          }
          localn.oCh.setVisibility(0);
          if (paramau.field_status < 2) {
            break label6365;
          }
          localn.oCh.setVisibility(8);
          parama = paramString;
          i = 0;
          break label926;
          localObject1 = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(locala.hjC);
          switch (locala.hjE)
          {
          default: 
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              break label6374;
            }
            if (!bUg()) {
              break label3336;
            }
            a(localn, parama1.vzN, paramau);
            if (localn.oCh == null) {
              break label6374;
            }
            localn.oCh.setVisibility(8);
            parama = paramString;
            break;
            if (localObject1 != null)
            {
              parama = ((WxaAttributes)localObject1).field_nickname;
              label2904:
              if (localObject1 == null) {
                break label3135;
              }
              localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;
              label2916:
              localn.vxn.setVisibility(8);
              localn.vxy.setVisibility(0);
              localn.vxr.setVisibility(8);
              localn.vxu.setVisibility(8);
              localn.vxB.setText(locala.title);
              localn.vxu.setText(locala.description);
              localn.vxw.setText(parama);
              switch (locala.hjJ)
              {
              default: 
                localn.vxx.setText(R.l.dDQ);
              }
            }
            for (;;)
            {
              com.tencent.mm.ah.n.GX().a((String)localObject1, localn.vxv, this.vAx);
              parama = com.tencent.mm.ah.n.GT().jw(paramau.field_imgPath);
              localn.vxz.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.AY().a(new b.h()
              {
                public final void Ba()
                {
                  GMTrace.i(17910416277504L, 133443);
                  GMTrace.o(17910416277504L, 133443);
                }
                
                public final void Bb()
                {
                  GMTrace.i(17910684712960L, 133445);
                  GMTrace.o(17910684712960L, 133445);
                }
                
                public final String Bc()
                {
                  GMTrace.i(17910818930688L, 133446);
                  String str = "CHAT#" + com.tencent.mm.plugin.appbrand.k.b.aM(this);
                  GMTrace.o(17910818930688L, 133446);
                  return str;
                }
                
                public final void h(Bitmap paramAnonymousBitmap)
                {
                  GMTrace.i(17910550495232L, 133444);
                  if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                  {
                    localn.vxz.setImageBitmap(paramAnonymousBitmap);
                    localn.vxz.setVisibility(0);
                    localn.vxA.setVisibility(4);
                    GMTrace.o(17910550495232L, 133444);
                    return;
                  }
                  localn.vxz.setVisibility(4);
                  localn.vxA.setVisibility(0);
                  GMTrace.o(17910550495232L, 133444);
                }
              }, "file://" + parama, null, ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aL(215, 168));
              i = 0;
              break;
              parama = locala.fUI;
              break label2904;
              label3135:
              localObject1 = locala.hjL;
              break label2916;
              localn.vxx.setText(R.l.dFU);
              continue;
              localn.vxx.setText(R.l.dFT);
            }
            if (localObject1 != null)
            {
              parama = ((WxaAttributes)localObject1).field_nickname;
              label3184:
              if (localObject1 == null) {
                break label3304;
              }
            }
            label3304:
            for (localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;; localObject1 = null)
            {
              localn.vxn.setVisibility(8);
              localn.vxy.setVisibility(8);
              localn.vxr.setVisibility(0);
              localn.vxt.setText(parama);
              if (!bf.mA((String)localObject1)) {
                break label3310;
              }
              parama = com.tencent.mm.ah.n.GT().jw(paramau.field_imgPath);
              com.tencent.mm.modelappbrand.a.b.AY().a(localn.vxs, "file://" + parama, com.tencent.mm.modelappbrand.a.a.AX(), com.tencent.mm.modelappbrand.a.e.hqo);
              i = 0;
              break;
              parama = locala.title;
              break label3184;
            }
            label3310:
            com.tencent.mm.modelappbrand.a.b.AY().a(localn.vxs, (String)localObject1, com.tencent.mm.modelappbrand.a.a.AX(), com.tencent.mm.modelappbrand.a.e.hqo);
            i = 0;
          }
          label3336:
          if (localn.oCh == null) {
            break label6374;
          }
          localn.oCh.setVisibility(0);
          if (paramau.field_status < 2) {
            break label6374;
          }
          localn.oCh.setVisibility(8);
          parama = paramString;
          break label926;
          localn.ipc.setVisibility(8);
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.mwR.setVisibility(0);
            localn.mwR.setText(locala.title);
            label3429:
            localn.ipd.setMaxLines(3);
            localn.vxa.setVisibility(0);
            localn.vxe.setVisibility(8);
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
              if ((parama != null) && (!parama.isRecycled())) {
                break label3550;
              }
              localn.vwA.setImageResource(R.k.dtk);
            }
          }
          for (;;)
          {
            if (!bUg()) {
              break label3562;
            }
            if (localn.oCh == null) {
              break label6365;
            }
            localn.oCh.setVisibility(8);
            parama = paramString;
            i = 0;
            break;
            localn.mwR.setVisibility(8);
            break label3429;
            label3550:
            localn.vwA.setImageBitmap(parama);
          }
          label3562:
          if (localn.oCh == null) {
            break label6365;
          }
          localn.oCh.setVisibility(0);
          if (paramau.field_status < 2) {
            break label6365;
          }
          localn.oCh.setVisibility(8);
          parama = paramString;
          i = 0;
          break label926;
          localn.mwR.setVisibility(0);
          if (locala.hhB == 1) {
            localn.mwR.setText(R.l.eOS);
          }
          for (;;)
          {
            if ((locala.title != null) && (locala.title.length() > 0))
            {
              localn.ipc.setVisibility(0);
              localn.ipc.setText(locala.title);
            }
            localn.ipd.setMaxLines(4);
            localn.vxa.setVisibility(4);
            localn.vxe.setVisibility(8);
            if (!bool) {
              break label6365;
            }
            parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
            if ((parama == null) || (parama.isRecycled())) {
              break label3821;
            }
            localn.vwA.setImageBitmap(parama);
            parama = paramString;
            i = 0;
            break;
            if (locala.hhB == 2) {
              localn.mwR.setText(R.l.eOU);
            } else if (locala.hhB == 3) {
              localn.mwR.setText(R.l.eOT);
            } else {
              localn.mwR.setText(R.l.eOV);
            }
          }
          label3821:
          localn.vwA.setImageResource(R.k.dtk);
          parama = paramString;
          i = 0;
          break label926;
          localn.ipc.setVisibility(0);
          localn.ipc.setText(locala.title);
          localn.mwR.setVisibility(0);
          localn.mwR.setText(R.l.ezI);
          localn.ipd.setMaxLines(4);
          localn.vxa.setVisibility(4);
          localn.vxe.setVisibility(8);
          if (!bool) {
            break label6365;
          }
          parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
          if ((parama != null) && (!parama.isRecycled()))
          {
            localn.vwA.setImageBitmap(parama);
            parama = paramString;
            i = 0;
            break label926;
          }
          localn.vwA.setImageResource(R.k.dtk);
          parama = paramString;
          i = 0;
          break label926;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            localn.ipc.setText(locala.title);
            localn.mwR.setVisibility(8);
          }
          localn.ipd.setMaxLines(4);
          localn.vxa.setVisibility(4);
          localn.vxe.setVisibility(8);
          if (!bool) {
            break label6365;
          }
          parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
          if ((parama != null) && (!parama.isRecycled()))
          {
            localn.vwA.setImageBitmap(parama);
            parama = paramString;
            i = 0;
            break label926;
          }
          localn.vwA.setImageResource(R.k.dtk);
          parama = paramString;
          i = 0;
          break label926;
          if ((locala.title != null) && (locala.title.length() > 0)) {
            localn.ipc.setVisibility(0);
          }
          for (;;)
          {
            localn.ipd.setVisibility(0);
            localn.mwR.setVisibility(8);
            localn.vxa.setVisibility(8);
            localn.vxe.setVisibility(4);
            localn.ipd.setMaxLines(2);
            if (!bool) {
              break label6365;
            }
            parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
            if ((parama != null) && (!parama.isRecycled())) {
              break label4286;
            }
            localn.vwA.setImageResource(R.k.dtk);
            parama = paramString;
            i = 0;
            break;
            localn.ipc.setVisibility(8);
          }
          label4286:
          localn.vwA.setImageBitmap(parama);
          parama = paramString;
          i = 0;
          break label926;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            label4332:
            localn.ipd.setVisibility(0);
            localn.mwR.setVisibility(8);
            localn.vxe.setVisibility(8);
            localn.vxa.setVisibility(4);
            localn.ipd.setMaxLines(2);
            if (bool)
            {
              parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
              if ((parama != null) && (!parama.isRecycled())) {
                break label4505;
              }
              localn.vwA.setImageResource(R.k.dtk);
            }
          }
          for (;;)
          {
            parama = new ds(paramau, false, paramInt, "", 8, false, parama1.bVI(), locala.fUH, locala.fUI, locala.title, locala.hhJ, locala.url, false, false);
            localn.vxm.setTag(parama);
            i = 0;
            break;
            localn.ipc.setVisibility(8);
            break label4332;
            label4505:
            localn.vwA.setImageBitmap(parama);
          }
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            label4545:
            localn.ipd.setVisibility(0);
            localn.mwR.setVisibility(8);
            localn.vxe.setVisibility(8);
            localn.vxa.setVisibility(4);
            localn.ipd.setMaxLines(2);
            if (bool)
            {
              parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
              if ((parama != null) && (!parama.isRecycled())) {
                break label4722;
              }
              localn.vwA.setImageResource(R.k.dtk);
            }
          }
          for (;;)
          {
            parama = new ds(paramau, paramInt, "", parama1.bVI(), locala.fUH, locala.fUI, locala.title, locala.hjq, locala.designerName, locala.designerRediretctUrl, locala.url);
            localn.vxm.setTag(parama);
            i = 0;
            break;
            localn.ipc.setVisibility(8);
            break label4545;
            label4722:
            localn.vwA.setImageBitmap(parama);
          }
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            label4762:
            localn.ipd.setVisibility(0);
            localn.mwR.setVisibility(8);
            localn.vxe.setVisibility(8);
            localn.vxa.setVisibility(4);
            localn.ipd.setMaxLines(2);
            if (bool)
            {
              if (!bf.mA(paramau.field_imgPath)) {
                break label5003;
              }
              com.tencent.mm.ah.n.GX().a(locala.thumburl, localn.vwA);
            }
            label4841:
            parama = new ds();
            parama.fTa = paramau;
            parama.vvA = false;
            parama.position = paramInt;
            parama.vLb = false;
            parama.title = parama1.bVI();
            parama.fUH = locala.fUH;
            parama.fUI = locala.fUI;
            parama.vLc = locala.title;
            if (locala.type != 26) {
              break label5062;
            }
            parama.klJ = 12;
            parama.tid = locala.tid;
            parama.hjr = locala.hjr;
            parama.desc = locala.desc;
            parama.iconUrl = locala.iconUrl;
            parama.secondUrl = locala.secondUrl;
            parama.pageType = locala.pageType;
          }
          for (;;)
          {
            localn.vxm.setTag(parama);
            i = 0;
            break;
            localn.ipc.setVisibility(8);
            break label4762;
            label5003:
            parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
            if ((parama == null) || (parama.isRecycled()))
            {
              localn.vwA.setImageResource(R.k.dtk);
              break label4841;
            }
            localn.vwA.setImageBitmap(parama);
            break label4841;
            label5062:
            if (locala.type == 27)
            {
              parama.klJ = 13;
              parama.tid = locala.tid;
              parama.hjr = locala.hjr;
              parama.desc = locala.desc;
              parama.iconUrl = locala.iconUrl;
              parama.secondUrl = locala.secondUrl;
              parama.pageType = locala.pageType;
            }
            else
            {
              v.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
            }
          }
          localn.ipc.setVisibility(0);
          localn.ipc.setText(locala.description);
          localn.ipd.setText(locala.hip);
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.mwR.setVisibility(0);
            localn.mwR.setText(locala.title);
          }
          for (;;)
          {
            localn.ipd.setMaxLines(4);
            localn.vxa.setVisibility(4);
            localn.vxe.setVisibility(8);
            if (!bool) {
              break label6365;
            }
            parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
            if (parama == null) {
              break label5313;
            }
            localn.vwA.setImageBitmap(parama);
            parama = paramString;
            i = 0;
            break;
            localn.mwR.setVisibility(8);
          }
          label5313:
          localn.vwA.setImageResource(R.k.dtk);
          parama = paramString;
          i = 0;
          break label926;
          localn.ipc.setVisibility(8);
          localn.mwR.setVisibility(0);
          if ((locala.title != null) && (locala.title.length() > 0)) {
            localn.mwR.setText(com.tencent.mm.pluginsdk.ui.d.h.c(localn.mwR.getContext(), locala.title, (int)localn.mwR.getTextSize()));
          }
          for (;;)
          {
            localn.ipd.setMaxLines(3);
            localn.vxa.setVisibility(4);
            localn.vxe.setVisibility(8);
            if (bool) {
              localn.vwA.setVisibility(8);
            }
            n.a(parama1, localn, locala, paramau, bool);
            if (!bUg()) {
              break label5543;
            }
            a(localn, parama1.vzN, paramau);
            if (localn.oCh == null) {
              break label6365;
            }
            localn.oCh.setVisibility(8);
            parama = paramString;
            i = 0;
            break;
            localn.mwR.setText(com.tencent.mm.pluginsdk.ui.d.h.c(localn.mwR.getContext(), com.tencent.mm.sdk.platformtools.aa.getContext().getString(R.l.ejH), (int)localn.mwR.getTextSize()));
          }
          label5543:
          if (localn.oCh == null) {
            break label6365;
          }
          localn.oCh.setVisibility(0);
          if (paramau.field_status < 2) {
            break label6365;
          }
          localn.oCh.setVisibility(8);
          parama = paramString;
          i = 0;
          break label926;
          n.a(parama1, localn, locala, bool);
          if (bUg())
          {
            a(localn, parama1.vzN, paramau);
            if (localn.oCh == null) {
              break label6365;
            }
            localn.oCh.setVisibility(8);
            parama = paramString;
            i = 0;
            break label926;
          }
          if (localn.oCh == null) {
            break label6365;
          }
          localn.oCh.setVisibility(0);
          if (paramau.field_status < 2) {
            break label6365;
          }
          localn.oCh.setVisibility(8);
          parama = paramString;
          i = 0;
          break label926;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            if (!bf.mA(locala.hiy)) {
              if (!bf.mA(locala.hiy))
              {
                localn.ipc.setTextColor(bf.aF(locala.hiy, parama1.uRf.uRz.getResources().getColor(R.e.black)));
                label5769:
                localn.ipd.setMaxLines(2);
                localn.ipd.setVisibility(0);
                if (bf.mA(locala.hiz)) {
                  break label6119;
                }
                localn.ipd.setTextColor(bf.aF(locala.hiz, parama1.uRf.uRz.getResources().getColor(R.e.aUf)));
                label5830:
                localn.mwR.setVisibility(8);
                localn.vxa.setVisibility(4);
                localn.vxe.setVisibility(8);
                localn.vwZ.setVisibility(0);
                localn.lLh.setVisibility(0);
                if (bf.mA(locala.hiu)) {
                  break label6146;
                }
                localn.lLh.setText(locala.hiu);
              }
            }
          }
          for (;;)
          {
            if (this.sWq)
            {
              parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz), false);
              if ((parama != null) && (!parama.isRecycled()))
              {
                localObject1 = com.tencent.mm.sdk.platformtools.d.a(parama, false, parama.getWidth() / 2);
                localn.vwA.setImageBitmap((Bitmap)localObject1);
              }
              if (!bf.mA(locala.hix))
              {
                parama = com.tencent.mm.ah.n.GX();
                localObject1 = locala.hix;
                localObject2 = new ImageView(parama1.uRf.uRz);
                localObject3 = new c.a();
                ((c.a)localObject3).hIt = true;
                parama.a((String)localObject1, (ImageView)localObject2, ((c.a)localObject3).Hh(), new com.tencent.mm.ah.a.c.g()
                {
                  public final void a(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ah.a.d.b paramAnonymousb)
                  {
                    GMTrace.i(17894444367872L, 133324);
                    if (paramAnonymousb.bitmap != null)
                    {
                      paramAnonymousString = paramAnonymousb.bitmap;
                      localn.vxn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                      {
                        public final boolean onPreDraw()
                        {
                          GMTrace.i(17909745188864L, 133438);
                          az.3.this.vAy.vxn.getViewTreeObserver().removeOnPreDrawListener(this);
                          int j = az.3.this.vAy.vxn.getHeight();
                          int k = az.3.this.vAy.vxn.getWidth();
                          int i = j;
                          if (j == 0) {
                            i = com.tencent.mm.bg.a.T(az.3.this.vwq.uRf.uRz, R.f.aZe);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.bg.a.T(az.3.this.vwq.uRf.uRz, R.f.aZf);
                          }
                          BitmapDrawable localBitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(paramAnonymousString, R.g.bdQ, j, i));
                          az.3.this.vAy.vxn.setBackgroundDrawable(localBitmapDrawable);
                          GMTrace.o(17909745188864L, 133438);
                          return true;
                        }
                      });
                    }
                    GMTrace.o(17894444367872L, 133324);
                  }
                  
                  public final void jL(String paramAnonymousString)
                  {
                    GMTrace.i(17894310150144L, 133323);
                    GMTrace.o(17894310150144L, 133323);
                  }
                });
                parama = paramString;
                i = 0;
                break;
                localn.ipc.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.black));
                break label5769;
                localn.ipc.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.black));
                break label5769;
                localn.ipc.setVisibility(8);
                break label5769;
                label6119:
                localn.ipd.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.aUf));
                break label5830;
                label6146:
                localn.lLh.setText(R.l.dTT);
                continue;
              }
              localn.vxn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                public final boolean onPreDraw()
                {
                  GMTrace.i(17894847021056L, 133327);
                  localn.vxn.getViewTreeObserver().removeOnPreDrawListener(this);
                  int i = com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 24);
                  Bitmap localBitmap = parama;
                  Object localObject;
                  if (localBitmap != null)
                  {
                    localObject = localBitmap;
                    if (!localBitmap.isRecycled()) {}
                  }
                  else
                  {
                    localObject = com.tencent.mm.sdk.platformtools.d.U(parama1.uRf.uRz.getResources().getColor(R.e.aTo), i, i);
                  }
                  int j = ((Bitmap)localObject).getHeight();
                  if (i > j) {
                    i = j;
                  }
                  for (;;)
                  {
                    localObject = com.tencent.mm.sdk.platformtools.d.c(com.tencent.mm.sdk.platformtools.d.N(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                    j = localn.vxn.getHeight();
                    int k = localn.vxn.getWidth();
                    i = j;
                    if (j == 0) {
                      i = com.tencent.mm.bg.a.T(parama1.uRf.uRz, R.f.aZe);
                    }
                    j = k;
                    if (k == 0) {
                      j = com.tencent.mm.bg.a.T(parama1.uRf.uRz, R.f.aZf);
                    }
                    localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, R.g.bdQ, j, i));
                    localn.vxn.setBackgroundDrawable((Drawable)localObject);
                    GMTrace.o(17894847021056L, 133327);
                    return true;
                  }
                }
              });
              parama = paramString;
              i = 0;
              break;
            }
          }
          localn.vwA.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.bhM));
          parama = paramString;
          i = 0;
          break label926;
          if (((com.tencent.mm.t.j)localObject1).hkf != 19) {
            break label6365;
          }
          n.a(parama1, localn, locala, bool);
          parama = paramString;
          i = 0;
          break label926;
          label6248:
          localn.mwR.setVisibility(8);
          break label981;
          label6261:
          localObject1 = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
          if (localObject1 != null)
          {
            paramString = (String)localObject1;
            if (!((Bitmap)localObject1).isRecycled()) {}
          }
          else
          {
            paramString = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz), false);
          }
          if ((paramString != null) && (!paramString.isRecycled())) {
            localn.vwA.setImageBitmap(paramString);
          } else {
            localn.vwA.setImageResource(R.g.bcg);
          }
        }
        label6365:
        parama = paramString;
        i = 0;
        continue;
        label6374:
        parama = paramString;
      }
      localObject1 = null;
      locala = null;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2518998319104L, 18768);
    int i = ((ds)paramView.getTag()).position;
    Object localObject1 = paramau.field_content;
    if (localObject1 == null)
    {
      GMTrace.o(2518998319104L, 18768);
      return true;
    }
    localObject1 = f.a.ek(this.vAn.cQ((String)localObject1, paramau.field_isSend));
    if (localObject1 == null)
    {
      GMTrace.o(2518998319104L, 18768);
      return true;
    }
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.g.aJ(((f.a)localObject1).appId, false);
    if ((com.tencent.mm.pluginsdk.model.app.g.h((com.tencent.mm.pluginsdk.model.app.f)localObject2)) && (!aa.ah(paramau))) {
      paramContextMenu.add(i, 111, 0, this.vAn.getString(R.l.eLz));
    }
    if (((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.dUp));
    }
    boolean bool;
    switch (((f.a)localObject1).type)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if ((bool) && (!this.vAn.bVz())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(R.l.dUd));
      }
      if ((com.tencent.mm.bb.d.Jr("favorite")) && ((localObject2 == null) || (!((com.tencent.mm.pluginsdk.model.app.f)localObject2).bCM()))) {
        switch (((f.a)localObject1).type)
        {
        }
      }
      for (;;)
      {
        localObject2 = new dd();
        ((dd)localObject2).fGN.fGD = paramau.field_msgId;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
        if ((((dd)localObject2).fGO.fGl) || (d.a(this.vAn.uRf.uRz, (f.a)localObject1))) {
          paramContextMenu.add(i, 128, 0, paramView.getContext().getString(R.l.dUm));
        }
        if (!this.vAn.bVz()) {
          paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
        }
        GMTrace.o(2518998319104L, 18768);
        return true;
        bool = com.tencent.mm.modelbiz.e.Dy();
        break;
        bool = com.tencent.mm.modelbiz.e.Du();
        break;
        bool = com.tencent.mm.modelbiz.e.Dx();
        break;
        bool = com.tencent.mm.modelbiz.e.Dp();
        break;
        bool = com.tencent.mm.modelbiz.e.Dn();
        break;
        bool = com.tencent.mm.modelbiz.e.Dw();
        break;
        bool = com.tencent.mm.modelbiz.e.Dq();
        break;
        if ((((f.a)localObject1).hiq != 5) && (((f.a)localObject1).hiq != 6) && (((f.a)localObject1).hiq != 2)) {
          break label765;
        }
        if (((f.a)localObject1).hiq != 2) {
          paramContextMenu.clear();
        }
        paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
        GMTrace.o(2518998319104L, 18768);
        return false;
        paramContextMenu.clear();
        paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
        GMTrace.o(2518998319104L, 18768);
        return false;
        paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.eFS));
      }
      label765:
      bool = false;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2519132536832L, 18769);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      GMTrace.o(2519132536832L, 18769);
      return false;
      Object localObject = paramau.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = f.a.ek((String)localObject);
      }
      if ((paramMenuItem != null) && (19 == paramMenuItem.type))
      {
        localObject = new lz();
        ((lz)localObject).fSV.type = 3;
        ((lz)localObject).fSV.fGD = paramau.field_msgId;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      }
      ay.L(paramau.field_msgId);
      if (paramMenuItem != null)
      {
        localObject = com.tencent.mm.pluginsdk.model.app.g.aJ(paramMenuItem.appId, false);
        if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject).bCM())) {
          a(parama, paramMenuItem, paramau, (com.tencent.mm.pluginsdk.model.app.f)localObject);
        }
      }
      GMTrace.o(2519132536832L, 18769);
      return false;
      d.a(parama, paramau, a(parama, paramau));
      GMTrace.o(2519132536832L, 18769);
      return false;
      paramMenuItem = paramau.field_content;
      if (paramMenuItem == null)
      {
        GMTrace.o(2519132536832L, 18769);
        return false;
      }
      paramMenuItem = f.a.ek(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        GMTrace.o(2519132536832L, 18769);
        return false;
        ef.a(paramau, parama.cQ(paramau.field_content, paramau.field_isSend), parama.uRf.uRz);
        continue;
        ef.b(paramau, parama.uRf.uRz);
        continue;
        ef.b(paramau, parama.cQ(paramau.field_content, paramau.field_isSend), parama.uRf.uRz);
        continue;
        ef.a(paramau, parama.uRf.uRz, a(parama, paramau), parama.vzR);
        continue;
        ef.k(parama.cQ(paramau.field_content, paramau.field_isSend), parama.uRf.uRz);
        continue;
        ef.c(paramau, parama.cQ(paramau.field_content, paramau.field_isSend), parama.uRf.uRz);
        continue;
        ef.a(paramau, parama.uRf.uRz);
      }
      paramMenuItem = paramau.field_content;
      if (paramMenuItem == null)
      {
        GMTrace.o(2519132536832L, 18769);
        return false;
      }
      paramMenuItem = f.a.ek(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        default: 
          break;
        case 16: 
          parama = new hq();
          parama.fMW.fMX = paramMenuItem.fMX;
          parama.fMW.fEL = paramau.field_msgId;
          parama.fMW.fMY = paramau.field_talker;
          com.tencent.mm.sdk.b.a.uql.m(parama);
        }
      }
    }
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, final au paramau)
  {
    GMTrace.i(2519266754560L, 18770);
    if ((((ds)paramView.getTag()).klJ == 5) && (paramau.field_isSend == 1))
    {
      if (paramau != null) {
        com.tencent.mm.ui.base.g.b(this.vAn.uRf.uRz, this.vAn.getString(R.l.dVd), "", this.vAn.getString(R.l.dIn), this.vAn.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2310826622976L, 17217);
            ed.V(paramau);
            az.this.vAn.bVv();
            GMTrace.o(2310826622976L, 17217);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(17911087366144L, 133448);
            GMTrace.o(17911087366144L, 133448);
          }
        });
      }
      GMTrace.o(2519266754560L, 18770);
      return true;
    }
    paramView = paramau.field_content;
    if (paramView == null)
    {
      GMTrace.o(2519266754560L, 18770);
      return false;
    }
    Object localObject1 = f.a.ek(paramView);
    if (localObject1 == null)
    {
      GMTrace.o(2519266754560L, 18770);
      return false;
    }
    paramView = com.tencent.mm.pluginsdk.model.app.g.aJ(((f.a)localObject1).appId, true);
    if ((paramView != null) && (!bf.mA(paramView.field_appId)) && (paramView.bCM())) {
      a(parama, (f.a)localObject1, m.xL(), paramView, paramau.field_msgSvrId);
    }
    int i;
    Object localObject3;
    Object localObject4;
    switch (((f.a)localObject1).type)
    {
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    case 17: 
    case 18: 
    case 21: 
    case 22: 
    case 23: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 35: 
    default: 
      if ((((f.a)localObject1).url == null) || (((f.a)localObject1).url.equals(""))) {
        break label4037;
      }
      if (!bf.mA(((f.a)localObject1).canvasPageXml))
      {
        paramView = new Intent();
        paramView.putExtra("sns_landig_pages_from_source", 5);
        paramView.putExtra("msg_id", paramau.field_msgId);
        paramView.putExtra("sns_landing_pages_xml", ((f.a)localObject1).canvasPageXml);
        paramView.putExtra("sns_landing_pages_share_thumb_url", paramau.field_imgPath);
        paramView.addFlags(268435456);
        com.tencent.mm.bb.d.b(parama.uRf.uRz, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramView);
        GMTrace.o(2519266754560L, 18770);
        return true;
      }
      break;
    case 6: 
      ap.yY();
      if (!com.tencent.mm.u.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.s.eP(parama.uRf.uRz);
        GMTrace.o(2519266754560L, 18770);
        return true;
      }
      if (bf.Ql(((f.a)localObject1).hhh))
      {
        long l = paramau.field_msgId;
        localObject1 = ((f.a)localObject1).fCN;
        paramView = an.abF().LV((String)localObject1);
        if ((paramView == null) || (!paramView.ayY())) {
          i = 0;
        }
        while (i != 0)
        {
          GMTrace.o(2519266754560L, 18770);
          return true;
          ap.yY();
          localObject2 = com.tencent.mm.u.c.wT().cA(l);
          if (((au)localObject2).bMj())
          {
            v.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[] { localObject1, Long.valueOf(l), Long.valueOf(((ce)localObject2).field_msgSvrId), ((ce)localObject2).field_imgPath });
            paramView = new Intent();
            paramView.setClassName(this.vAn.uRf.uRz, "com.tencent.mm.ui.chatting.ResourcesExceedUI");
            paramView.putExtra("clean_view_type", 1);
            this.vAn.startActivity(paramView);
            i = 1;
          }
          else
          {
            localObject1 = new Intent(this.vAn.uRf.uRz, ShowImageUI.class);
            ((Intent)localObject1).putExtra("key_image_path", paramView.field_fileFullPath);
            ((Intent)localObject1).putExtra("key_message_id", l);
            ((Intent)localObject1).putExtra("key_favorite", true);
            this.vAn.startActivity((Intent)localObject1);
            i = 1;
          }
        }
      }
      paramView = new Intent();
      paramView.setClassName(parama.uRf.uRz, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
      paramView.putExtra("app_msg_id", paramau.field_msgId);
      parama.startActivity(paramView);
      GMTrace.o(2519266754560L, 18770);
      return true;
    case 3: 
      com.tencent.mm.plugin.report.service.g.oSF.i(13043, new Object[] { Integer.valueOf(2), ((f.a)localObject1).description, ((f.a)localObject1).appId });
    case 4: 
      if (a(parama, (f.a)localObject1, paramau))
      {
        GMTrace.o(2519266754560L, 18770);
        return true;
      }
      localObject2 = com.tencent.mm.pluginsdk.model.app.p.s(((f.a)localObject1).url, "message");
      localObject3 = com.tencent.mm.pluginsdk.model.app.p.s(((f.a)localObject1).hhf, "message");
      localObject4 = ay(parama.uRf.uRz, ((f.a)localObject1).appId);
      if (localObject4 == null)
      {
        paramView = null;
        if (localObject4 != null) {
          break label972;
        }
      }
      for (i = 0;; i = ((PackageInfo)localObject4).versionCode)
      {
        a(parama, (String)localObject2, (String)localObject3, paramView, i, ((f.a)localObject1).appId, true, paramau.field_msgId, paramau.field_msgSvrId, paramau);
        GMTrace.o(2519266754560L, 18770);
        return true;
        paramView = ((PackageInfo)localObject4).versionName;
        break;
      }
    case 5: 
      if (!bf.mA(((f.a)localObject1).canvasPageXml))
      {
        paramView = new Intent();
        paramView.putExtra("sns_landig_pages_from_source", 5);
        paramView.putExtra("msg_id", paramau.field_msgId);
        paramView.putExtra("sns_landing_pages_xml", ((f.a)localObject1).canvasPageXml);
        paramView.putExtra("sns_landing_pages_share_thumb_url", paramau.field_imgPath);
        paramView.addFlags(268435456);
        com.tencent.mm.bb.d.b(parama.uRf.uRz, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramView);
        GMTrace.o(2519266754560L, 18770);
        return true;
      }
      if ((((f.a)localObject1).url != null) && (!((f.a)localObject1).url.equals("")))
      {
        localObject2 = ((f.a)localObject1).url;
        if (!parama.vzR) {
          break label1744;
        }
        paramView = "groupmessage";
        localObject4 = com.tencent.mm.pluginsdk.model.app.p.s((String)localObject2, paramView);
        paramView = ((f.a)localObject1).hhf;
        localObject2 = ay(parama.uRf.uRz, ((f.a)localObject1).appId);
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("rawUrl", (String)localObject4);
        ((Intent)localObject3).putExtra("webpageTitle", ((f.a)localObject1).title);
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("key_snsad_statextstr", ((f.a)localObject1).fUO);
        if ((((f.a)localObject1).appId != null) && (("wx751a1acca5688ba3".equals(((f.a)localObject1).appId)) || ("wxfbc915ff7c30e335".equals(((f.a)localObject1).appId)) || ("wx482a4001c37e2b74".equals(((f.a)localObject1).appId)))) {
          ((Bundle)localObject4).putString("jsapi_args_appid", ((f.a)localObject1).appId);
        }
        ((Intent)localObject3).putExtra("jsapiargs", (Bundle)localObject4);
        if (bf.mA(paramView)) {
          break label1751;
        }
        ((Intent)localObject3).putExtra("shortUrl", paramView);
        if (localObject2 != null) {
          break label1768;
        }
        paramView = null;
        ((Intent)localObject3).putExtra("version_name", paramView);
        if (localObject2 != null) {
          break label1777;
        }
        i = 0;
        ((Intent)localObject3).putExtra("version_code", i);
        if (!bf.mA(((f.a)localObject1).fUH))
        {
          ((Intent)localObject3).putExtra("srcUsername", ((f.a)localObject1).fUH);
          ((Intent)localObject3).putExtra("srcDisplayname", ((f.a)localObject1).fUI);
        }
        ((Intent)localObject3).putExtra("msg_id", paramau.field_msgId);
        ((Intent)localObject3).putExtra("KPublisherId", "msg_" + Long.toString(paramau.field_msgSvrId));
        ((Intent)localObject3).putExtra("KAppId", ((f.a)localObject1).appId);
        ((Intent)localObject3).putExtra("geta8key_username", parama.bTW());
        ((Intent)localObject3).putExtra("pre_username", a(parama, paramau));
        ((Intent)localObject3).putExtra("from_scence", 2);
        i = com.tencent.mm.u.p.G(a(parama, paramau), parama.bTW());
        ((Intent)localObject3).putExtra("prePublishId", "msg_" + Long.toString(paramau.field_msgSvrId));
        ((Intent)localObject3).putExtra("preUsername", a(parama, paramau));
        ((Intent)localObject3).putExtra("preChatName", parama.bTW());
        ((Intent)localObject3).putExtra("preChatTYPE", i);
        ((Intent)localObject3).putExtra("preMsgIndex", 0);
        switch (i)
        {
        case 3: 
        case 4: 
        case 5: 
        default: 
          i = 0;
        }
      }
      for (;;)
      {
        ((Intent)localObject3).putExtra("share_report_pre_msg_url", ((f.a)localObject1).url);
        ((Intent)localObject3).putExtra("share_report_pre_msg_title", ((f.a)localObject1).title);
        ((Intent)localObject3).putExtra("share_report_pre_msg_desc", ((f.a)localObject1).description);
        ((Intent)localObject3).putExtra("share_report_pre_msg_icon_url", ((f.a)localObject1).thumburl);
        ((Intent)localObject3).putExtra("share_report_pre_msg_appid", ((f.a)localObject1).appId);
        ((Intent)localObject3).putExtra("share_report_from_scene", i);
        if (i == 5) {
          ((Intent)localObject3).putExtra("share_report_biz_username", parama.bTW());
        }
        com.tencent.mm.bb.d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", (Intent)localObject3);
        GMTrace.o(2519266754560L, 18770);
        return true;
        paramView = "singlemessage";
        break;
        ((Intent)localObject3).putExtra("shortUrl", ((f.a)localObject1).url);
        break label1301;
        paramView = ((PackageInfo)localObject2).versionName;
        break label1308;
        i = ((PackageInfo)localObject2).versionCode;
        break label1326;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 5;
      }
    case 33: 
      v.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((f.a)localObject1).hjC, ((f.a)localObject1).hjB, ((f.a)localObject1).hjD, ((f.a)localObject1).url, Integer.valueOf(((f.a)localObject1).hjJ), ((f.a)localObject1).hjF });
      localObject2 = parama.bTW();
      localObject3 = a(parama, paramau);
      localObject4 = new Bundle();
      if ((parama instanceof AppBrandServiceChattingUI.a))
      {
        i = 10;
        ((Bundle)localObject4).putInt("stat_scene", i);
        ((Bundle)localObject4).putString("stat_msg_id", "msg_" + Long.toString(paramau.field_msgSvrId));
        ((Bundle)localObject4).putString("stat_chat_talker_username", (String)localObject2);
        ((Bundle)localObject4).putString("stat_send_msg_user", (String)localObject3);
        switch (((f.a)localObject1).hjE)
        {
        default: 
          i = 1;
        }
      }
      while (i == 0)
      {
        GMTrace.o(2519266754560L, 18770);
        return true;
        if (parama.vzR)
        {
          i = 2;
          break label1904;
        }
        if (o.eV((String)localObject2))
        {
          i = 7;
          break label1904;
        }
        i = 1;
        break label1904;
        paramView = new Intent();
        paramView.putExtra("key_username", ((f.a)localObject1).hjC);
        if (parama.vzR)
        {
          paramView.putExtra("key_from_scene", 1);
          paramView.putExtra("key_scene_note", parama.bTW() + ":" + (String)localObject3);
        }
        for (;;)
        {
          paramView.putExtra("_stat_obj", (Bundle)localObject4);
          localObject2 = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject2).appId = ((f.a)localObject1).hjD;
          ((WxaExposedParams.a)localObject2).fFi = 6;
          ((WxaExposedParams.a)localObject2).izA = ((f.a)localObject1).hjJ;
          ((WxaExposedParams.a)localObject2).izB = ((f.a)localObject1).hjG;
          paramView.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject2).RI());
          com.tencent.mm.bb.d.b(parama.uRf.uRz, "appbrand", ".ui.AppBrandProfileUI", paramView);
          i = 0;
          break;
          paramView.putExtra("key_from_scene", 2);
          paramView.putExtra("key_scene_note", (String)localObject2);
        }
        if ((parama instanceof AppBrandServiceChattingUI.a))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject2, 1073, (f.a)localObject1, (Bundle)localObject4);
          i = 0;
        }
        else if (o.eV((String)localObject2))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject2, 1074, (f.a)localObject1, (Bundle)localObject4);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.c((String)localObject2, (String)localObject3, parama.vzR, (f.a)localObject1, (Bundle)localObject4);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.d((String)localObject2, (String)localObject3, parama.vzR, (f.a)localObject1, (Bundle)localObject4);
          i = 0;
        }
      }
    case 36: 
      if ((bf.mA(((f.a)localObject1).hjD)) && (bf.mA(((f.a)localObject1).hjC)))
      {
        paramau = ((f.a)localObject1).url;
        if (parama.vzR) {}
        for (paramView = "groupmessage";; paramView = "singlemessage")
        {
          paramView = com.tencent.mm.pluginsdk.model.app.p.s(paramau, paramView);
          paramau = new Intent();
          paramau.putExtra("rawUrl", paramView);
          paramau.putExtra("webpageTitle", ((f.a)localObject1).title);
          paramau.putExtra("shortUrl", ((f.a)localObject1).url);
          com.tencent.mm.bb.d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramau);
          GMTrace.o(2519266754560L, 18770);
          return true;
        }
      }
      paramView = parama.bTW();
      localObject2 = a(parama, paramau);
      localObject3 = new Bundle();
      if (parama.vzR)
      {
        i = 2;
        ((Bundle)localObject3).putInt("stat_scene", i);
        ((Bundle)localObject3).putString("stat_msg_id", "msg_" + Long.toString(paramau.field_msgSvrId));
        ((Bundle)localObject3).putString("stat_chat_talker_username", paramView);
        ((Bundle)localObject3).putString("stat_send_msg_user", (String)localObject2);
        boolean bool = bf.mA(((f.a)localObject1).hjI);
        v.i("MicroMsg.ChattingItemAppMsgTo", "withShareTicket = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label2632;
        }
        com.tencent.mm.modelappbrand.a.b(parama.bTW(), a(parama, paramau), parama.vzR, (f.a)localObject1, (Bundle)localObject3);
      }
      for (;;)
      {
        GMTrace.o(2519266754560L, 18770);
        return true;
        if (o.eV(paramView))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        com.tencent.mm.modelappbrand.a.a(parama.bTW(), a(parama, paramau), parama.vzR, (f.a)localObject1, (Bundle)localObject3);
      }
    case 7: 
      if ((paramView != null) && (paramView.bCM()) && (a(parama, paramView)))
      {
        GMTrace.o(2519266754560L, 18770);
        return true;
      }
      parama.aw(paramau);
      GMTrace.o(2519266754560L, 18770);
      return true;
    case 10: 
      if (bf.mA(((f.a)localObject1).hhC))
      {
        GMTrace.o(2519266754560L, 18770);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_Product_xml", ((f.a)localObject1).hhC);
      paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
      if (paramau.field_imgPath == null) {
        paramView.putExtra("key_ProductUI_chatting_msgId", paramau.field_msgId);
      }
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "scanner", ".ui.ProductUI", paramView);
      GMTrace.o(2519266754560L, 18770);
      return true;
    case 20: 
      if (bf.mA(((f.a)localObject1).hhF))
      {
        GMTrace.o(2519266754560L, 18770);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_TV_xml", ((f.a)localObject1).hhF);
      paramView.putExtra("key_TV_getProductInfoScene", 1);
      if (paramau.field_imgPath == null) {
        paramView.putExtra("key_TVInfoUI_chatting_msgId", paramau.field_msgId);
      }
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "shake", ".ui.TVInfoUI", paramView);
      GMTrace.o(2519266754560L, 18770);
      return true;
    case 13: 
      if (bf.mA(((f.a)localObject1).hhI))
      {
        GMTrace.o(2519266754560L, 18770);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_product_info", ((f.a)localObject1).hhI);
      paramView.putExtra("key_product_scene", 1);
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "product", ".ui.MallProductUI", paramView);
      GMTrace.o(2519266754560L, 18770);
      return true;
    case 16: 
      if (bf.mA(((f.a)localObject1).fMX))
      {
        GMTrace.o(2519266754560L, 18770);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", ((f.a)localObject1).fMX);
      paramView.putExtra("key_from_scene", ((f.a)localObject1).hiq);
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "card", ".ui.CardDetailUI", paramView);
      GMTrace.o(2519266754560L, 18770);
      return true;
    case 19: 
      paramView = new Intent();
      paramView.putExtra("message_id", paramau.field_msgId);
      paramView.putExtra("record_xml", ((f.a)localObject1).hhG);
      b.a(paramView, parama, paramau, this);
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "record", ".ui.RecordMsgDetailUI", paramView);
      GMTrace.o(2519266754560L, 18770);
      return true;
    case 24: 
      paramView = new kq();
      paramView.fQY.context = parama.uRf.uRz;
      paramView.fQY.fGD = paramau.field_msgId;
      paramView.fQY.fQZ = ((f.a)localObject1).hhG;
      com.tencent.mm.sdk.b.a.uql.m(paramView);
      GMTrace.o(2519266754560L, 18770);
      return true;
    case 34: 
      label972:
      label1301:
      label1308:
      label1326:
      label1744:
      label1751:
      label1768:
      label1777:
      label1904:
      label2632:
      paramView = new Intent();
      paramView.putExtra("key_biz_uin", ((f.a)localObject1).his);
      paramView.putExtra("key_order_id", ((f.a)localObject1).hit);
      if ((paramau.field_talker != null) && (!paramau.field_talker.equals("")) && (paramau.field_talker.endsWith("@chatroom"))) {
        paramView.putExtra("key_chatroom_name", paramau.field_talker);
      }
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "card", ".ui.CardGiftAcceptUI", paramView);
      GMTrace.o(2519266754560L, 18770);
      return true;
    }
    Object localObject2 = ((f.a)localObject1).url;
    if (parama.vzR)
    {
      paramView = "groupmessage";
      localObject4 = com.tencent.mm.pluginsdk.model.app.p.s((String)localObject2, paramView);
      paramView = ((f.a)localObject1).url;
      localObject2 = ay(parama.uRf.uRz, ((f.a)localObject1).appId);
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("rawUrl", (String)localObject4);
      ((Intent)localObject3).putExtra("webpageTitle", ((f.a)localObject1).title);
      if ((((f.a)localObject1).appId != null) && (("wx751a1acca5688ba3".equals(((f.a)localObject1).appId)) || ("wxfbc915ff7c30e335".equals(((f.a)localObject1).appId)) || ("wx482a4001c37e2b74".equals(((f.a)localObject1).appId))))
      {
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("jsapi_args_appid", ((f.a)localObject1).appId);
        ((Intent)localObject3).putExtra("jsapiargs", (Bundle)localObject4);
      }
      if (bf.mA(paramView)) {
        break label3983;
      }
      ((Intent)localObject3).putExtra("shortUrl", paramView);
      label3518:
      if (localObject2 != null) {
        break label4000;
      }
      paramView = null;
      label3525:
      ((Intent)localObject3).putExtra("version_name", paramView);
      if (localObject2 != null) {
        break label4009;
      }
      i = 0;
      label3543:
      ((Intent)localObject3).putExtra("version_code", i);
      if (!bf.mA(((f.a)localObject1).fUH))
      {
        ((Intent)localObject3).putExtra("srcUsername", ((f.a)localObject1).fUH);
        ((Intent)localObject3).putExtra("srcDisplayname", ((f.a)localObject1).fUI);
      }
      ((Intent)localObject3).putExtra("msg_id", paramau.field_msgId);
      ((Intent)localObject3).putExtra("KPublisherId", "msg_" + Long.toString(paramau.field_msgSvrId));
      ((Intent)localObject3).putExtra("KAppId", ((f.a)localObject1).appId);
      ((Intent)localObject3).putExtra("geta8key_username", parama.bTW());
      ((Intent)localObject3).putExtra("pre_username", a(parama, paramau));
      ((Intent)localObject3).putExtra("from_scence", 2);
      ((Intent)localObject3).putExtra("expid_str", paramau.gxE);
      i = com.tencent.mm.u.p.G(a(parama, paramau), parama.bTW());
      ((Intent)localObject3).putExtra("prePublishId", "msg_" + Long.toString(paramau.field_msgSvrId));
      ((Intent)localObject3).putExtra("preUsername", a(parama, paramau));
      ((Intent)localObject3).putExtra("preChatName", parama.bTW());
      ((Intent)localObject3).putExtra("preChatTYPE", i);
      ((Intent)localObject3).putExtra("preMsgIndex", 0);
      switch (i)
      {
      case 3: 
      case 4: 
      case 5: 
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((Intent)localObject3).putExtra("share_report_pre_msg_url", ((f.a)localObject1).url);
      ((Intent)localObject3).putExtra("share_report_pre_msg_title", ((f.a)localObject1).title);
      ((Intent)localObject3).putExtra("share_report_pre_msg_desc", ((f.a)localObject1).description);
      ((Intent)localObject3).putExtra("share_report_pre_msg_icon_url", ((f.a)localObject1).thumburl);
      ((Intent)localObject3).putExtra("share_report_pre_msg_appid", ((f.a)localObject1).appId);
      ((Intent)localObject3).putExtra("share_report_from_scene", i);
      if (i == 5) {
        ((Intent)localObject3).putExtra("share_report_biz_username", parama.bTW());
      }
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", (Intent)localObject3);
      GMTrace.o(2519266754560L, 18770);
      return true;
      paramView = "singlemessage";
      break;
      label3983:
      ((Intent)localObject3).putExtra("shortUrl", ((f.a)localObject1).url);
      break label3518;
      label4000:
      paramView = ((PackageInfo)localObject2).versionName;
      break label3525;
      label4009:
      i = ((PackageInfo)localObject2).versionCode;
      break label3543;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
    label4037:
    GMTrace.o(2519266754560L, 18770);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */