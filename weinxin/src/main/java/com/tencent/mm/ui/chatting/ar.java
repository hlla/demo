package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
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
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.a.kq;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.j;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.t.f.a.a;
import com.tencent.mm.t.j;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.List;

final class ar
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  private boolean vAw;
  private c vAx;
  
  public ar(int paramInt)
  {
    super(paramInt);
    GMTrace.i(2219021697024L, 16533);
    c.a locala = new c.a();
    locala.hII = R.k.dtp;
    locala.aO(com.tencent.mm.bg.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aa.getContext(), 20), com.tencent.mm.bg.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aa.getContext(), 20)).hIr = true;
    this.vAx = locala.Hh();
    GMTrace.o(2219021697024L, 16533);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2219155914752L, 16534);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof n)))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXw);
      ((View)localObject).setTag(new n(this.klJ).q((View)localObject, true));
    }
    GMTrace.o(2219155914752L, 16534);
    return (View)localObject;
  }
  
  public final void a(final ag.a parama, int paramInt, final En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2219290132480L, 16535);
    final n localn = (n)parama;
    this.vAn = parama1;
    localn.reset();
    Object localObject2 = paramau.field_content;
    parama1.aG(paramau);
    parama1.aH(paramau);
    parama1.aI(paramau);
    int i;
    if (this.vAw)
    {
      i = paramau.field_content.indexOf(':');
      if (i != -1) {
        localObject2 = paramau.field_content.substring(i + 1);
      }
    }
    for (;;)
    {
      f.a locala;
      Object localObject3;
      final Object localObject1;
      label429:
      label456:
      com.tencent.mm.pluginsdk.model.app.f localf;
      label526:
      boolean bool;
      if (localObject2 != null)
      {
        locala = f.a.B((String)localObject2, paramau.field_reserved);
        localObject3 = j.eo((String)localObject2);
        paramString = new ds(paramau, parama1.vvA, paramInt, null, 0, (byte)0);
        localObject1 = paramString;
        if (locala != null)
        {
          localn.ipc.setText(locala.getTitle());
          localn.ipd.setText(locala.getDescription());
          localn.mwR.setMaxLines(1);
          localn.ipc.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.aVo));
          localn.ipd.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.aUo));
          localn.vxn.setBackgroundResource(R.g.bdF);
          localn.vxn.setPadding(0, parama1.uRf.uRz.getResources().getDimensionPixelSize(R.f.aXy), 0, 0);
          localn.vwA.setVisibility(0);
          localn.vxl.setVisibility(0);
          localn.ipd.setVisibility(0);
          localn.vxb.setVisibility(8);
          localn.vxd.setVisibility(8);
          localn.vxc.setVisibility(8);
          localn.vxp.setVisibility(8);
          localn.vxq.setVisibility(8);
          localn.vwX.setVisibility(8);
          localn.vwY.setVisibility(8);
          localn.vxy.setVisibility(8);
          localn.vxr.setVisibility(8);
          localn.vxn.setVisibility(0);
          n.I(localn.vxm, localn.vwx);
          localObject1 = (com.tencent.mm.t.d)locala.n(com.tencent.mm.t.d.class);
          ChattingItemFooter localChattingItemFooter = localn.vxf;
          if (localObject1 != null) {
            break label1493;
          }
          localObject1 = null;
          if (!localChattingItemFooter.b((List)localObject1, paramau.field_talker, false)) {
            break label1503;
          }
          localn.vxm.setBackgroundResource(R.g.bdX);
          localf = com.tencent.mm.pluginsdk.model.app.g.cv(locala.appId, locala.fWv);
          if ((localf != null) && (localf.bCM())) {
            b(parama1, locala, paramau);
          }
          if ((localf != null) && (localf.field_appName != null) && (localf.field_appName.trim().length() > 0)) {
            break label1517;
          }
          localObject1 = locala.appName;
          bool = true;
          com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 12);
          if ((locala.type == 20) || ("wxaf060266bfa9a35c".equals(locala.appId))) {
            bool = l.a.bCf().baJ();
          }
          if ((!bool) || (locala.appId == null) || (locala.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.g.bn((String)localObject1))) {
            break label1544;
          }
          localn.lLh.setText(com.tencent.mm.pluginsdk.model.app.g.a(parama1.uRf.uRz, localf, (String)localObject1));
          localn.lLh.setVisibility(0);
          localn.lLh.setCompoundDrawables(null, null, null, null);
          localn.vwZ.setVisibility(0);
          localn.vwW.setVisibility(0);
          if ((localf == null) || (!localf.bCM())) {
            break label1527;
          }
          a(parama1, localn.lLh, paramau, locala, localf.field_packageName, paramau.field_msgSvrId);
          label705:
          a(parama1, localn.vwW, locala.appId);
          label719:
          if ((locala.hhd == null) || (locala.hhd.hjX == 0)) {
            break label1703;
          }
          i = 1;
          label741:
          if (i != 0) {
            localn.vwZ.setVisibility(8);
          }
          bool = false;
          localn.vwA.setVisibility(0);
          if ((locala.hhd == null) || (locala.hhd.hjU != 1)) {
            break label1709;
          }
          i = 1;
          label791:
          if ((i != 0) || (!this.sWq)) {
            break label1721;
          }
          localChattingItemFooter = null;
          localObject1 = localChattingItemFooter;
          if (locala.type != 33)
          {
            localObject1 = localChattingItemFooter;
            if (locala.type != 36) {
              localObject1 = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz), false);
            }
          }
          if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
            break label1715;
          }
          localn.vwA.setImageBitmap((Bitmap)localObject1);
          label881:
          if (locala.type == 3) {
            localn.vxn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              public final boolean onPreDraw()
              {
                GMTrace.i(2368540246016L, 17647);
                localn.vxn.getViewTreeObserver().removeOnPreDrawListener(this);
                int i = com.tencent.mm.bg.a.fromDPToPix(parama1.uRf.uRz, 24);
                Bitmap localBitmap = localObject1;
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
                  localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, R.g.bdF, j, i));
                  localn.vxn.setBackgroundDrawable((Drawable)localObject);
                  GMTrace.o(2368540246016L, 17647);
                  return true;
                }
              }
            });
          }
          label914:
          if ((locala.gxt != null) && (locala.gxt.length() != 0)) {
            break label1745;
          }
          localn.vwP.setVisibility(8);
          label943:
          localn.vxe.setOnClickListener(null);
          localn.vxh.setVisibility(0);
          localn.vxa.setVisibility(8);
          localn.vxk.setVisibility(0);
          localn.vxi.setVisibility(8);
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
            paramInt = 1;
          }
        }
      }
      for (;;)
      {
        label1177:
        if (paramInt != 0)
        {
          if ((locala.title == null) || (locala.title.length() <= 0)) {
            break label5961;
          }
          localn.mwR.setVisibility(0);
          localn.mwR.setMaxLines(2);
          localn.mwR.setText(locala.title);
          label1231:
          localn.ipc.setVisibility(8);
          if (bool)
          {
            if ((locala.type != 33) && (locala.type != 36)) {
              break label5974;
            }
            paramString = com.tencent.mm.ah.n.GT().jw(paramau.field_imgPath);
            localn.vwA.setImageResource(R.k.dtk);
            com.tencent.mm.modelappbrand.a.b.AY().a(localn.vwA, "file://" + paramString, null, null, ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aL(50, 50));
          }
        }
        label1340:
        if (!parama1.vvA) {
          if (com.tencent.mm.pluginsdk.model.app.g.g(localf))
          {
            localn.vxg.setVisibility(0);
            c(parama1, localn.vxg, ds.a(locala, paramau));
            localObject1 = parama;
          }
        }
        for (;;)
        {
          localn.vxm.setTag(localObject1);
          localn.vxm.setOnClickListener(parama1.vzN.vDb);
          if (this.sWq)
          {
            localn.vxm.setOnLongClickListener(parama1.vzN.vDd);
            localn.vxm.setOnTouchListener(parama1.vzN.vDf);
          }
          GMTrace.o(2219290132480L, 16535);
          return;
          v.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramau.field_msgId), paramString });
          localObject3 = null;
          locala = null;
          break;
          label1493:
          localObject1 = ((com.tencent.mm.t.d)localObject1).hhc;
          break label429;
          label1503:
          localn.vxm.setBackgroundResource(R.g.bdT);
          break label456;
          label1517:
          localObject1 = localf.field_appName;
          break label526;
          label1527:
          a(parama1, localn.lLh, locala.appId);
          break label705;
          label1544:
          if (locala.type == 24)
          {
            localn.lLh.setText(com.tencent.mm.sdk.platformtools.aa.getContext().getString(R.l.ehq));
            localn.vwZ.setVisibility(0);
            localn.lLh.setVisibility(0);
            localn.vwW.setVisibility(8);
            break label719;
          }
          if ((locala.type == 19) || (((j)localObject3).hkf == 19))
          {
            localn.lLh.setText(com.tencent.mm.sdk.platformtools.aa.getContext().getString(R.l.dTU));
            localn.vwZ.setVisibility(0);
            localn.lLh.setVisibility(0);
            localn.vwW.setVisibility(8);
            break label719;
          }
          localn.vwZ.setVisibility(8);
          localn.lLh.setVisibility(8);
          localn.vwW.setVisibility(8);
          break label719;
          label1703:
          i = 0;
          break label741;
          label1709:
          i = 0;
          break label791;
          label1715:
          bool = true;
          break label881;
          label1721:
          localn.vwA.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.bhM));
          bool = false;
          break label914;
          label1745:
          localn.vwP.setVisibility(0);
          b(parama1, localn.vwP, ds.TE(locala.gxt));
          break label943;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            localn.ipc.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.white));
            label1826:
            localn.ipd.setVisibility(0);
            localn.ipd.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.white));
            localn.mwR.setVisibility(8);
            localn.vxa.setVisibility(4);
            localn.vxe.setVisibility(0);
            if (parama.vAl != paramau.field_msgId) {
              break label2047;
            }
            localn.vxe.setImageResource(R.g.bhm);
            label1911:
            localn.ipd.setMaxLines(2);
            if (bool)
            {
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
              if ((parama != null) && (!parama.isRecycled())) {
                break label2061;
              }
              localn.vwA.setImageResource(R.k.dsW);
            }
          }
          for (;;)
          {
            parama = new cv.b();
            parama.fGD = paramau.field_msgId;
            parama.fQO = paramau.field_content;
            parama.fNR = paramau.field_imgPath;
            localn.vxe.setTag(parama);
            localn.vxe.setOnClickListener(parama1.vzN.vDl);
            parama = paramString;
            paramInt = 0;
            break;
            localn.ipc.setVisibility(8);
            break label1826;
            label2047:
            localn.vxe.setImageResource(R.g.bhn);
            break label1911;
            label2061:
            localn.vwA.setImageBitmap(parama);
          }
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            localn.ipc.setMaxLines(2);
          }
          for (;;)
          {
            localn.ipd.setVisibility(0);
            localn.mwR.setVisibility(8);
            localn.vxe.setVisibility(8);
            localn.vxa.setVisibility(4);
            localn.ipd.setMaxLines(2);
            localn.ipd.setText(bf.ay(locala.hhg));
            n.a(localn, (String)localObject2, locala.hhg);
            n.a(localn, Boolean.valueOf(true), paramau, locala.fCN, locala.title);
            if (!bool) {
              break label6110;
            }
            if (!bf.Ql(locala.hhh)) {
              break label2255;
            }
            localn.vwA.setImageResource(R.g.bcg);
            parama = paramString;
            paramInt = 0;
            break;
            localn.ipc.setVisibility(8);
          }
          label2255:
          localn.vwA.setImageResource(com.tencent.mm.pluginsdk.model.q.LU(locala.hhh));
          parama = paramString;
          paramInt = 0;
          break label1177;
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.ipc.setVisibility(0);
            label2307:
            localn.ipd.setVisibility(0);
            localn.mwR.setVisibility(8);
            localn.vxe.setVisibility(0);
            localn.vxe.setImageResource(R.g.bkU);
            localn.vxa.setVisibility(4);
            localn.ipd.setMaxLines(2);
            if (!bool) {
              break label6110;
            }
            parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
            if ((parama != null) && (!parama.isRecycled())) {
              break label2442;
            }
            localn.vwA.setImageResource(R.k.dth);
          }
          for (;;)
          {
            localn.vxe.setVisibility(8);
            parama = paramString;
            paramInt = 0;
            break;
            localn.ipc.setVisibility(8);
            break label2307;
            label2442:
            localn.vwA.setImageBitmap(parama);
          }
          localn.ipc.setVisibility(8);
          if ((locala.title != null) && (locala.title.length() > 0))
          {
            localn.mwR.setMaxLines(2);
            localn.mwR.setVisibility(0);
            localn.mwR.setText(locala.getTitle());
          }
          for (;;)
          {
            localn.ipd.setMaxLines(3);
            localn.vxe.setVisibility(8);
            localn.vxa.setVisibility(4);
            if (!bool) {
              break label6110;
            }
            parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
            if ((parama != null) && (!parama.isRecycled())) {
              break label2610;
            }
            localn.vwA.setImageResource(R.k.dtk);
            parama = paramString;
            paramInt = 0;
            break;
            localn.mwR.setVisibility(8);
          }
          label2610:
          localn.vwA.setImageBitmap(parama);
          parama = paramString;
          paramInt = 0;
          break label1177;
          localObject1 = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(locala.hjC);
          if (localObject1 != null)
          {
            parama = ((WxaAttributes)localObject1).field_nickname;
            label2659:
            if (localObject1 == null) {
              break label2862;
            }
          }
          label2862:
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
            parama = paramString;
            paramInt = 0;
            break;
            parama = locala.fUI;
            break label2659;
          }
          localObject1 = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(locala.hjC);
          switch (locala.hjE)
          {
          default: 
            parama = paramString;
            paramInt = 1;
            break;
          case 2: 
          case 3: 
            if (localObject1 != null)
            {
              parama = ((WxaAttributes)localObject1).field_nickname;
              if (localObject1 == null) {
                break label3195;
              }
              localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;
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
              localn.vxz.setVisibility(4);
              localn.vxA.setVisibility(0);
              com.tencent.mm.modelappbrand.a.b.AY().a(new b.h()
              {
                public final void Ba()
                {
                  GMTrace.i(17902363213824L, 133383);
                  GMTrace.o(17902363213824L, 133383);
                }
                
                public final void Bb()
                {
                  GMTrace.i(17902631649280L, 133385);
                  GMTrace.o(17902631649280L, 133385);
                }
                
                public final String Bc()
                {
                  GMTrace.i(17902765867008L, 133386);
                  String str = "CHAT#" + com.tencent.mm.plugin.appbrand.k.b.aM(this);
                  GMTrace.o(17902765867008L, 133386);
                  return str;
                }
                
                public final void h(Bitmap paramAnonymousBitmap)
                {
                  GMTrace.i(17902497431552L, 133384);
                  if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                  {
                    localn.vxz.setImageBitmap(paramAnonymousBitmap);
                    localn.vxz.setVisibility(0);
                    localn.vxA.setVisibility(4);
                    GMTrace.o(17902497431552L, 133384);
                    return;
                  }
                  localn.vxz.setVisibility(4);
                  localn.vxA.setVisibility(0);
                  GMTrace.o(17902497431552L, 133384);
                }
              }, "file://" + parama, null, ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aL(215, 168));
              parama = paramString;
              paramInt = 0;
              break;
              parama = locala.fUI;
              break label2943;
              localObject1 = locala.hjL;
              break label2955;
              localn.vxx.setText(R.l.dFU);
              continue;
              localn.vxx.setText(R.l.dFT);
            }
          case 1: 
            label2943:
            label2955:
            label3195:
            if (localObject1 != null)
            {
              parama = ((WxaAttributes)localObject1).field_nickname;
              label3244:
              if (localObject1 == null) {
                break label3366;
              }
            }
            label3366:
            for (localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;; localObject1 = null)
            {
              localn.vxn.setVisibility(8);
              localn.vxy.setVisibility(8);
              localn.vxr.setVisibility(0);
              localn.vxt.setText(parama);
              if (!bf.mA((String)localObject1)) {
                break label3372;
              }
              parama = com.tencent.mm.ah.n.GT().jw(paramau.field_imgPath);
              com.tencent.mm.modelappbrand.a.b.AY().a(localn.vxs, "file://" + parama, com.tencent.mm.modelappbrand.a.a.AX(), com.tencent.mm.modelappbrand.a.e.hqo);
              parama = paramString;
              paramInt = 0;
              break;
              parama = locala.title;
              break label3244;
            }
            label3372:
            com.tencent.mm.modelappbrand.a.b.AY().a(localn.vxs, (String)localObject1, com.tencent.mm.modelappbrand.a.a.AX(), com.tencent.mm.modelappbrand.a.e.hqo);
            parama = paramString;
            paramInt = 0;
            break;
            localn.ipc.setVisibility(8);
            if ((locala.title != null) && (locala.title.trim().length() > 0))
            {
              localn.mwR.setVisibility(0);
              localn.mwR.setText(locala.getTitle());
            }
            for (;;)
            {
              localn.ipd.setMaxLines(3);
              localn.vxe.setVisibility(8);
              localn.vxa.setVisibility(0);
              if (!bool) {
                break label6110;
              }
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
              if ((parama != null) && (!parama.isRecycled())) {
                break label3550;
              }
              localn.vwA.setImageResource(R.k.dtk);
              parama = paramString;
              paramInt = 0;
              break;
              localn.mwR.setVisibility(8);
            }
            label3550:
            localn.vwA.setImageBitmap(parama);
            parama = paramString;
            paramInt = 0;
            break;
            localn.mwR.setVisibility(0);
            if (locala.hhB == 1) {
              localn.mwR.setText(R.l.eOS);
            }
            for (;;)
            {
              if ((locala.title != null) && (locala.title.length() > 0))
              {
                localn.ipc.setVisibility(0);
                localn.ipc.setText(locala.getTitle());
              }
              localn.ipd.setMaxLines(4);
              localn.vxa.setVisibility(4);
              localn.vxe.setVisibility(8);
              if (!bool) {
                break label6110;
              }
              parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
              if ((parama == null) || (parama.isRecycled())) {
                break label3780;
              }
              localn.vwA.setImageBitmap(parama);
              parama = paramString;
              paramInt = 0;
              break;
              if (locala.hhB == 2) {
                localn.mwR.setText(R.l.eOU);
              } else if (locala.hhB == 3) {
                localn.mwR.setText(R.l.eOT);
              } else {
                localn.mwR.setText(R.l.eOV);
              }
            }
            label3780:
            localn.vwA.setImageResource(R.k.dtk);
            parama = paramString;
            paramInt = 0;
            break;
            localn.ipc.setVisibility(0);
            localn.ipc.setText(locala.getTitle());
            localn.mwR.setVisibility(0);
            localn.mwR.setText(R.l.ezI);
            localn.ipd.setMaxLines(4);
            localn.vxa.setVisibility(4);
            localn.vxe.setVisibility(8);
            if (!bool) {
              break label6110;
            }
            parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
            if ((parama != null) && (!parama.isRecycled()))
            {
              localn.vwA.setImageBitmap(parama);
              parama = paramString;
              paramInt = 0;
              break;
            }
            localn.vwA.setImageResource(R.k.dtk);
            parama = paramString;
            paramInt = 0;
            break;
            if ((locala.title != null) && (locala.title.length() > 0))
            {
              localn.ipc.setVisibility(0);
              localn.ipc.setText(locala.getTitle());
              localn.mwR.setVisibility(8);
            }
            localn.ipd.setMaxLines(4);
            localn.vxa.setVisibility(4);
            localn.vxe.setVisibility(8);
            if (!bool) {
              break label6110;
            }
            parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
            if ((parama != null) && (!parama.isRecycled()))
            {
              localn.vwA.setImageBitmap(parama);
              parama = paramString;
              paramInt = 0;
              break;
            }
            localn.vwA.setImageResource(R.k.dtk);
            parama = paramString;
            paramInt = 0;
            break;
            if ((locala.title != null) && (locala.title.length() > 0)) {
              localn.ipc.setVisibility(0);
            }
            for (;;)
            {
              localn.ipd.setVisibility(0);
              localn.mwR.setVisibility(8);
              localn.vxe.setVisibility(8);
              localn.vxa.setVisibility(4);
              localn.ipd.setMaxLines(2);
              if (!bool) {
                break label6110;
              }
              parama = com.tencent.mm.pluginsdk.model.app.g.b(locala.appId, 1, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
              if ((parama != null) && (!parama.isRecycled())) {
                break label4239;
              }
              localn.vwA.setImageResource(R.k.dtk);
              parama = paramString;
              paramInt = 0;
              break;
              localn.ipc.setVisibility(8);
            }
            label4239:
            localn.vwA.setImageBitmap(parama);
            parama = paramString;
            paramInt = 0;
            break;
            if ((locala.title != null) && (locala.title.length() > 0))
            {
              localn.ipc.setVisibility(0);
              label4284:
              localn.ipd.setVisibility(0);
              localn.mwR.setVisibility(8);
              localn.vxe.setVisibility(8);
              localn.vxa.setVisibility(4);
              localn.ipd.setMaxLines(2);
              if (bool)
              {
                parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
                if ((parama != null) && (!parama.isRecycled())) {
                  break label4457;
                }
                localn.vwA.setImageResource(R.k.dtk);
              }
            }
            for (;;)
            {
              parama = new ds(paramau, false, paramInt, "", 8, false, locala.title, locala.fUH, locala.fUI, locala.title, locala.hhJ, locala.url, false, false);
              localn.vxm.setTag(parama);
              paramInt = 0;
              break;
              localn.ipc.setVisibility(8);
              break label4284;
              label4457:
              localn.vwA.setImageBitmap(parama);
            }
            if ((locala.title != null) && (locala.title.length() > 0))
            {
              localn.ipc.setVisibility(0);
              label4497:
              localn.ipd.setVisibility(0);
              localn.mwR.setVisibility(8);
              localn.vxe.setVisibility(8);
              localn.vxa.setVisibility(4);
              localn.ipd.setMaxLines(2);
              if (bool)
              {
                parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
                if ((parama != null) && (!parama.isRecycled())) {
                  break label4673;
                }
                localn.vwA.setImageResource(R.k.dtk);
              }
            }
            for (;;)
            {
              parama = new ds(paramau, paramInt, "", parama1.bVI(), locala.fUH, locala.fUI, locala.title, locala.hjq, locala.designerName, locala.designerRediretctUrl, locala.url);
              localn.vxm.setTag(parama);
              paramInt = 0;
              break;
              localn.ipc.setVisibility(8);
              break label4497;
              label4673:
              localn.vwA.setImageBitmap(parama);
            }
            if ((locala.title != null) && (locala.title.length() > 0))
            {
              localn.ipc.setVisibility(0);
              label4713:
              localn.ipd.setVisibility(0);
              localn.mwR.setVisibility(8);
              localn.vxe.setVisibility(8);
              localn.vxa.setVisibility(4);
              localn.ipd.setMaxLines(2);
              if (bool)
              {
                parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
                if ((parama != null) && (!parama.isRecycled())) {
                  break label4970;
                }
                localn.vwA.setImageResource(R.k.dtk);
              }
              label4809:
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
                break label4982;
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
              paramInt = 0;
              break;
              localn.ipc.setVisibility(8);
              break label4713;
              label4970:
              localn.vwA.setImageBitmap(parama);
              break label4809;
              label4982:
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
                break label6110;
              }
              parama = com.tencent.mm.ah.n.GT().a(paramau.field_imgPath, com.tencent.mm.bg.a.getDensity(parama1.uRf.uRz));
              if (parama == null) {
                break label5220;
              }
              localn.vwA.setImageBitmap(parama);
              parama = paramString;
              paramInt = 0;
              break;
              localn.mwR.setVisibility(8);
            }
            label5220:
            localn.vwA.setImageResource(R.k.dtk);
            parama = paramString;
            paramInt = 0;
            break;
            localn.ipc.setVisibility(8);
            localn.mwR.setVisibility(0);
            if ((locala.title != null) && (locala.title.trim().length() > 0)) {
              localn.mwR.setText(com.tencent.mm.pluginsdk.ui.d.h.b(localn.mwR.getContext(), locala.title, localn.mwR.getTextSize()));
            }
            for (;;)
            {
              localn.ipd.setMaxLines(3);
              localn.vxe.setVisibility(8);
              localn.vxa.setVisibility(4);
              if (bool)
              {
                localn.vwA.setVisibility(8);
                localn.vxl.setVisibility(8);
              }
              n.a(parama1, localn, locala, paramau, bool);
              parama = paramString;
              paramInt = 0;
              break;
              localn.mwR.setText(com.tencent.mm.pluginsdk.ui.d.h.b(localn.mwR.getContext(), com.tencent.mm.sdk.platformtools.aa.getContext().getString(R.l.ejH), localn.mwR.getTextSize()));
            }
            n.a(parama1, localn, locala, bool);
            parama = paramString;
            paramInt = 0;
            break;
            if ((locala.title != null) && (locala.title.length() > 0))
            {
              localn.ipc.setVisibility(0);
              if (!bf.mA(locala.hiy))
              {
                localn.ipc.setTextColor(bf.aF(locala.hiy, parama1.uRf.uRz.getResources().getColor(R.e.black)));
                label5513:
                localn.ipd.setMaxLines(2);
                localn.ipd.setVisibility(0);
                if (bf.mA(locala.hiz)) {
                  break label5835;
                }
                localn.ipd.setTextColor(bf.aF(locala.hiz, parama1.uRf.uRz.getResources().getColor(R.e.aUf)));
                label5574:
                localn.mwR.setVisibility(8);
                localn.vxa.setVisibility(4);
                localn.vxe.setVisibility(8);
                localn.vwZ.setVisibility(0);
                localn.lLh.setVisibility(0);
                if (bf.mA(locala.hiu)) {
                  break label5862;
                }
                localn.lLh.setText(locala.hiu);
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
                      GMTrace.i(17903436955648L, 133391);
                      if (paramAnonymousb.bitmap != null)
                      {
                        paramAnonymousString = paramAnonymousb.bitmap;
                        localn.vxn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                        {
                          public final boolean onPreDraw()
                          {
                            GMTrace.i(17897934028800L, 133350);
                            ar.3.this.vAy.vxn.getViewTreeObserver().removeOnPreDrawListener(this);
                            int j = ar.3.this.vAy.vxn.getHeight();
                            int k = ar.3.this.vAy.vxn.getWidth();
                            int i = j;
                            if (j == 0) {
                              i = com.tencent.mm.bg.a.T(ar.3.this.vwq.uRf.uRz, R.f.aZe);
                            }
                            j = k;
                            if (k == 0) {
                              j = com.tencent.mm.bg.a.T(ar.3.this.vwq.uRf.uRz, R.f.aZf);
                            }
                            BitmapDrawable localBitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(paramAnonymousString, R.g.bdF, j, i));
                            ar.3.this.vAy.vxn.setBackgroundDrawable(localBitmapDrawable);
                            GMTrace.o(17897934028800L, 133350);
                            return true;
                          }
                        });
                      }
                      GMTrace.o(17903436955648L, 133391);
                    }
                    
                    public final void jL(String paramAnonymousString)
                    {
                      GMTrace.i(17903302737920L, 133390);
                      GMTrace.o(17903302737920L, 133390);
                    }
                  });
                  parama = paramString;
                  paramInt = 0;
                  break;
                  localn.ipc.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.black));
                  break label5513;
                  localn.ipc.setVisibility(8);
                  break label5513;
                  label5835:
                  localn.ipd.setTextColor(parama1.uRf.uRz.getResources().getColor(R.e.aUf));
                  break label5574;
                  label5862:
                  localn.lLh.setText(R.l.dTT);
                  continue;
                }
                localn.vxn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                {
                  public final boolean onPreDraw()
                  {
                    GMTrace.i(17896457633792L, 133339);
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
                      localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, R.g.bdF, j, i));
                      localn.vxn.setBackgroundDrawable((Drawable)localObject);
                      GMTrace.o(17896457633792L, 133339);
                      return true;
                    }
                  }
                });
                parama = paramString;
                paramInt = 0;
                break;
              }
            }
            localn.vwA.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.bhM));
            parama = paramString;
            paramInt = 0;
            break;
            if (((j)localObject3).hkf != 19) {
              break label6110;
            }
            n.a(parama1, localn, locala, bool);
            parama = paramString;
            paramInt = 0;
            break;
            label5961:
            localn.mwR.setVisibility(8);
            break label1231;
            label5974:
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
            if ((paramString != null) && (!paramString.isRecycled()))
            {
              localn.vwA.setImageBitmap(paramString);
              break label1340;
            }
            localn.vwA.setImageResource(R.g.bcg);
            break label1340;
            localn.vxg.setVisibility(8);
            localObject1 = parama;
            continue;
            localn.vxg.setVisibility(8);
            localObject1 = parama;
          }
        }
        label6110:
        parama = paramString;
        paramInt = 0;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2219424350208L, 16536);
    int i = ((ds)paramView.getTag()).position;
    int j = com.tencent.mm.pluginsdk.model.app.l.Mf(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    f.a locala = f.a.ek(this.vAn.cQ(paramau.field_content, paramau.field_isSend));
    Object localObject = com.tencent.mm.pluginsdk.model.app.g.aJ(locala.appId, false);
    if ((com.tencent.mm.pluginsdk.model.app.g.h((com.tencent.mm.pluginsdk.model.app.f)localObject)) && (!aa.ah(paramau)))
    {
      if (locala.type != 6) {
        break label565;
      }
      com.tencent.mm.pluginsdk.model.app.b localb = com.tencent.mm.pluginsdk.model.app.l.Mg(locala.fCN);
      if (((localb == null) || (!d.c(paramau, localb.field_fileFullPath))) && (!paramau.bMj())) {
        paramContextMenu.add(i, 111, 0, this.vAn.getString(R.l.eLz));
      }
    }
    if ((locala.hhg <= 0) || ((locala.hhg > 0) && (j >= 100))) {}
    boolean bool;
    switch (locala.type)
    {
    default: 
      bool = false;
      label267:
      if ((bool) && (!this.vAn.bVz())) {
        paramContextMenu.add(i, 114, 0, paramView.getContext().getString(R.l.dUd));
      }
      if ((com.tencent.mm.bb.d.Jr("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.f)localObject).bCM()))) {
        switch (locala.type)
        {
        }
      }
      break;
    }
    for (;;)
    {
      localObject = new dd();
      ((dd)localObject).fGN.fGD = paramau.field_msgId;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      if ((((dd)localObject).fGO.fGl) || (d.a(this.vAn.uRf.uRz, locala))) {
        paramContextMenu.add(i, 128, 0, paramView.getContext().getString(R.l.dUm));
      }
      if (!this.vAn.bVz()) {
        paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
      }
      GMTrace.o(2219424350208L, 16536);
      return true;
      label565:
      paramContextMenu.add(i, 111, 0, this.vAn.getString(R.l.eLz));
      break;
      bool = com.tencent.mm.modelbiz.e.Dy();
      break label267;
      bool = com.tencent.mm.modelbiz.e.Du();
      break label267;
      bool = com.tencent.mm.modelbiz.e.Dx();
      break label267;
      bool = com.tencent.mm.modelbiz.e.Dp();
      break label267;
      bool = com.tencent.mm.modelbiz.e.Dn();
      break label267;
      bool = com.tencent.mm.modelbiz.e.Dw();
      break label267;
      bool = com.tencent.mm.modelbiz.e.Dq();
      break label267;
      bool = false;
      if ((locala.hiq != 5) && (locala.hiq != 6) && (locala.hiq != 2)) {
        break label267;
      }
      if (locala.hiq != 2) {
        paramContextMenu.clear();
      }
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
      GMTrace.o(2219424350208L, 16536);
      return false;
      paramContextMenu.clear();
      paramContextMenu.add(i, 100, 0, this.vAn.getString(R.l.dUh));
      GMTrace.o(2219424350208L, 16536);
      return false;
      paramContextMenu.add(i, 116, 0, paramView.getContext().getString(R.l.eFS));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2219558567936L, 16537);
    switch (paramMenuItem.getItemId())
    {
    default: 
      GMTrace.o(2219558567936L, 16537);
      return false;
    case 100: 
      Object localObject = paramau.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = f.a.ek((String)localObject);
      }
      if (paramMenuItem != null)
      {
        com.tencent.mm.pluginsdk.model.app.l.ed(paramau.field_msgId);
        if (19 == paramMenuItem.type)
        {
          localObject = new lz();
          ((lz)localObject).fSV.type = 3;
          ((lz)localObject).fSV.fGD = paramau.field_msgId;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
        }
      }
      ay.L(paramau.field_msgId);
      localObject = com.tencent.mm.pluginsdk.model.app.g.aJ(paramMenuItem.appId, false);
      if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject).bCM())) {
        a(parama, paramMenuItem, paramau, (com.tencent.mm.pluginsdk.model.app.f)localObject);
      }
      GMTrace.o(2219558567936L, 16537);
      return false;
    case 111: 
      d.a(parama, paramau, a(parama, paramau));
      GMTrace.o(2219558567936L, 16537);
      return false;
    }
    paramMenuItem = paramau.field_content;
    if (paramMenuItem == null)
    {
      GMTrace.o(2219558567936L, 16537);
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
      GMTrace.o(2219558567936L, 16537);
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
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2219692785664L, 16538);
    com.tencent.mm.modelstat.a.a(paramau, a.a.hTS);
    Object localObject1 = paramau.field_content;
    paramView = Boolean.valueOf(false);
    if (localObject1 == null)
    {
      GMTrace.o(2219692785664L, 16538);
      return false;
    }
    f.a locala = f.a.ek(parama.cQ((String)localObject1, paramau.field_isSend));
    localObject1 = j.eo((String)localObject1);
    if (locala == null)
    {
      GMTrace.o(2219692785664L, 16538);
      return false;
    }
    if (((j)localObject1).hkf != 0)
    {
      paramView = Boolean.valueOf(true);
      locala.type = ((j)localObject1).hkf;
    }
    localObject1 = com.tencent.mm.pluginsdk.model.app.g.aJ(locala.appId, false);
    if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject1).bCM())) {
      a(parama, locala, c(parama, paramau), (com.tencent.mm.pluginsdk.model.app.f)localObject1, paramau.field_msgSvrId);
    }
    int j;
    Object localObject2;
    Object localObject3;
    int i;
    switch (locala.type)
    {
    default: 
      j = 1;
      if ((j == 0) || (locala.url == null) || (locala.url.equals(""))) {
        break label3053;
      }
      if (!bf.mA(locala.canvasPageXml))
      {
        paramView = new Intent();
        paramView.putExtra("sns_landig_pages_from_source", 5);
        paramView.putExtra("msg_id", paramau.field_msgId);
        paramView.putExtra("sns_landing_pages_xml", locala.canvasPageXml);
        paramView.putExtra("sns_landing_pages_share_thumb_url", paramau.field_imgPath);
        paramView.addFlags(268435456);
        com.tencent.mm.bb.d.b(parama.uRf.uRz, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramView);
        GMTrace.o(2219692785664L, 16538);
        return true;
      }
      break;
    case 3: 
      com.tencent.mm.plugin.report.service.g.oSF.i(13043, new Object[] { Integer.valueOf(2), locala.description, locala.appId });
    case 4: 
      if ((com.tencent.mm.n.a.aJ(parama.uRf.uRz)) || (com.tencent.mm.n.a.aH(parama.uRf.uRz)))
      {
        v.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
        GMTrace.o(2219692785664L, 16538);
        return true;
      }
      if (a(parama, locala, paramau))
      {
        GMTrace.o(2219692785664L, 16538);
        return true;
      }
      localObject1 = com.tencent.mm.pluginsdk.model.app.p.s(locala.url, "message");
      localObject2 = com.tencent.mm.pluginsdk.model.app.p.s(locala.hhf, "message");
      localObject3 = ay(parama.uRf.uRz, locala.appId);
      if (localObject3 == null)
      {
        paramView = null;
        if (localObject3 != null) {
          break label604;
        }
      }
      for (i = 0;; i = ((PackageInfo)localObject3).versionCode)
      {
        a(parama, (String)localObject1, (String)localObject2, paramView, i, locala.appId, true, paramau.field_msgId, paramau.field_msgSvrId, paramau);
        GMTrace.o(2219692785664L, 16538);
        return true;
        paramView = ((PackageInfo)localObject3).versionName;
        break;
      }
    case 6: 
      if (!this.sWq)
      {
        s.eP(parama.uRf.uRz);
        GMTrace.o(2219692785664L, 16538);
        return true;
      }
      paramView = new Intent();
      paramView.setClassName(parama.uRf.uRz, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
      paramView.putExtra("app_msg_id", paramau.field_msgId);
      parama.startActivity(paramView);
      GMTrace.o(2219692785664L, 16538);
      return true;
    case 7: 
      if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject1).bCM()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.f)localObject1)))
      {
        GMTrace.o(2219692785664L, 16538);
        return true;
      }
      if ((locala.fCN == null) || (locala.fCN.length() == 0)) {
        parama.aw(paramau);
      }
      for (;;)
      {
        GMTrace.o(2219692785664L, 16538);
        return true;
        if (!this.sWq)
        {
          s.eP(parama.uRf.uRz);
          GMTrace.o(2219692785664L, 16538);
          return true;
        }
        paramView = new Intent();
        paramView.setClassName(parama.uRf.uRz, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramView.putExtra("app_msg_id", paramau.field_msgId);
        parama.startActivityForResult(paramView, 210);
      }
    case 10: 
      if (bf.mA(locala.hhC))
      {
        GMTrace.o(2219692785664L, 16538);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_Product_xml", locala.hhC);
      paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
      if (paramau.field_imgPath == null) {
        paramView.putExtra("key_ProductUI_chatting_msgId", paramau.field_msgId);
      }
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "scanner", ".ui.ProductUI", paramView);
      GMTrace.o(2219692785664L, 16538);
      return true;
    case 20: 
      if (bf.mA(locala.hhF))
      {
        GMTrace.o(2219692785664L, 16538);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_TV_xml", locala.hhF);
      paramView.putExtra("key_TV_getProductInfoScene", 1);
      if (paramau.field_imgPath == null) {
        paramView.putExtra("key_TVInfoUI_chatting_msgId", paramau.field_msgId);
      }
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "shake", ".ui.TVInfoUI", paramView);
      GMTrace.o(2219692785664L, 16538);
      return true;
    case 13: 
      if (bf.mA(locala.hhI))
      {
        GMTrace.o(2219692785664L, 16538);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_product_info", locala.hhI);
      paramView.putExtra("key_product_scene", 1);
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "product", ".ui.MallProductUI", paramView);
      GMTrace.o(2219692785664L, 16538);
      return true;
    case 19: 
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("message_id", paramau.field_msgId);
      ((Intent)localObject1).putExtra("record_xml", locala.hhG);
      ((Intent)localObject1).putExtra("big_appmsg", paramView);
      b.a((Intent)localObject1, parama, paramau, this);
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "record", ".ui.RecordMsgDetailUI", (Intent)localObject1);
      GMTrace.o(2219692785664L, 16538);
      return true;
    case 16: 
      if (bf.mA(locala.fMX))
      {
        GMTrace.o(2219692785664L, 16538);
        return false;
      }
      paramView = new Intent();
      paramView.setFlags(65536);
      paramView.putExtra("key_card_app_msg", locala.fMX);
      paramView.putExtra("key_from_scene", locala.hiq);
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "card", ".ui.CardDetailUI", paramView);
      GMTrace.o(2219692785664L, 16538);
      return true;
    case 33: 
      v.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { locala.hjC, locala.hjB, locala.hjD, locala.url, Integer.valueOf(locala.hjJ), locala.hjF });
      localObject2 = parama.bTW();
      localObject3 = a(parama, paramau);
      paramView = new Bundle();
      if ((parama instanceof AppBrandServiceChattingUI.a))
      {
        i = 10;
        paramView.putInt("stat_scene", i);
        paramView.putString("stat_msg_id", "msg_" + Long.toString(paramau.field_msgSvrId));
        paramView.putString("stat_chat_talker_username", (String)localObject2);
        paramView.putString("stat_send_msg_user", (String)localObject3);
        switch (locala.hjE)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        j = i;
        if (i != 0) {
          break;
        }
        GMTrace.o(2219692785664L, 16538);
        return true;
        if (parama.vzR)
        {
          i = 2;
          break label1410;
        }
        if (o.eV((String)localObject2))
        {
          i = 7;
          break label1410;
        }
        i = 1;
        break label1410;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("key_username", locala.hjC);
        if (parama.vzR)
        {
          ((Intent)localObject1).putExtra("key_from_scene", 1);
          ((Intent)localObject1).putExtra("key_scene_note", (String)localObject2 + ":" + (String)localObject3);
        }
        for (;;)
        {
          localObject2 = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject2).appId = locala.hjD;
          ((WxaExposedParams.a)localObject2).fFi = 6;
          ((WxaExposedParams.a)localObject2).izA = locala.hjJ;
          ((WxaExposedParams.a)localObject2).izB = locala.hjG;
          ((Intent)localObject1).putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject2).RI());
          ((Intent)localObject1).putExtra("_stat_obj", paramView);
          com.tencent.mm.bb.d.b(parama.uRf.uRz, "appbrand", ".ui.AppBrandProfileUI", (Intent)localObject1);
          i = 0;
          break;
          ((Intent)localObject1).putExtra("key_from_scene", 2);
          ((Intent)localObject1).putExtra("key_scene_note", (String)localObject2);
        }
        if ((parama instanceof AppBrandServiceChattingUI.a))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject2, 1073, locala, paramView);
          i = 0;
        }
        else if (o.eV((String)localObject2))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject2, 1074, locala, paramView);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.c((String)localObject2, (String)localObject3, parama.vzR, locala, paramView);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.d((String)localObject2, (String)localObject3, parama.vzR, locala, paramView);
          i = 0;
        }
      }
    case 36: 
      if ((bf.mA(locala.hjD)) && (bf.mA(locala.hjC)))
      {
        paramau = locala.url;
        if (parama.vzR) {}
        for (paramView = "groupmessage";; paramView = "singlemessage")
        {
          paramView = com.tencent.mm.pluginsdk.model.app.p.s(paramau, paramView);
          paramau = new Intent();
          paramau.putExtra("rawUrl", paramView);
          paramau.putExtra("webpageTitle", locala.title);
          paramau.putExtra("shortUrl", locala.url);
          com.tencent.mm.bb.d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramau);
          GMTrace.o(2219692785664L, 16538);
          return true;
        }
      }
      paramView = parama.bTW();
      localObject1 = a(parama, paramau);
      localObject2 = new Bundle();
      if (parama.vzR)
      {
        i = 2;
        ((Bundle)localObject2).putInt("stat_scene", i);
        ((Bundle)localObject2).putString("stat_msg_id", "msg_" + Long.toString(paramau.field_msgSvrId));
        ((Bundle)localObject2).putString("stat_chat_talker_username", paramView);
        ((Bundle)localObject2).putString("stat_send_msg_user", (String)localObject1);
        boolean bool = bf.mA(locala.hjI);
        v.i("MicroMsg.ChattingItemAppMsgFrom", "withShareTicket = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          break label2142;
        }
        com.tencent.mm.modelappbrand.a.b(parama.bTW(), a(parama, paramau), parama.vzR, locala, (Bundle)localObject2);
      }
      for (;;)
      {
        GMTrace.o(2219692785664L, 16538);
        return true;
        if (o.eV(paramView))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        com.tencent.mm.modelappbrand.a.a(parama.bTW(), a(parama, paramau), parama.vzR, locala, (Bundle)localObject2);
      }
    case 24: 
      paramView = new kq();
      paramView.fQY.context = parama.uRf.uRz;
      paramView.fQY.fGD = paramau.field_msgId;
      paramView.fQY.fQZ = locala.hhG;
      com.tencent.mm.sdk.b.a.uql.m(paramView);
      GMTrace.o(2219692785664L, 16538);
      return true;
    case 34: 
      label604:
      label1410:
      label2142:
      paramView = new Intent();
      paramView.putExtra("key_from_user_name", a(parama, paramau));
      paramView.putExtra("key_biz_uin", locala.his);
      paramView.putExtra("key_order_id", locala.hit);
      if ((paramau.field_talker != null) && (!paramau.field_talker.equals("")) && (paramau.field_talker.endsWith("@chatroom"))) {
        paramView.putExtra("key_chatroom_name", paramau.field_talker);
      }
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "card", ".ui.CardGiftAcceptUI", paramView);
      GMTrace.o(2219692785664L, 16538);
      return true;
    }
    localObject1 = locala.url;
    if (parama.vzR)
    {
      paramView = "groupmessage";
      localObject3 = com.tencent.mm.pluginsdk.model.app.p.s((String)localObject1, paramView);
      paramView = locala.url;
      localObject1 = ay(parama.uRf.uRz, locala.appId);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject3);
      ((Intent)localObject2).putExtra("webpageTitle", locala.title);
      if ((locala.appId != null) && (("wx751a1acca5688ba3".equals(locala.appId)) || ("wxfbc915ff7c30e335".equals(locala.appId)) || ("wx482a4001c37e2b74".equals(locala.appId))))
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("jsapi_args_appid", locala.appId);
        ((Intent)localObject2).putExtra("jsapiargs", (Bundle)localObject3);
      }
      if (bf.mA(paramView)) {
        break label2999;
      }
      ((Intent)localObject2).putExtra("shortUrl", paramView);
      label2534:
      if (localObject1 != null) {
        break label3016;
      }
      paramView = null;
      label2541:
      ((Intent)localObject2).putExtra("version_name", paramView);
      if (localObject1 != null) {
        break label3025;
      }
      i = 0;
      label2559:
      ((Intent)localObject2).putExtra("version_code", i);
      if (!bf.mA(locala.fUH))
      {
        ((Intent)localObject2).putExtra("srcUsername", locala.fUH);
        ((Intent)localObject2).putExtra("srcDisplayname", locala.fUI);
      }
      ((Intent)localObject2).putExtra("msg_id", paramau.field_msgId);
      ((Intent)localObject2).putExtra("KPublisherId", "msg_" + Long.toString(paramau.field_msgSvrId));
      ((Intent)localObject2).putExtra("KAppId", locala.appId);
      ((Intent)localObject2).putExtra("geta8key_username", parama.bTW());
      ((Intent)localObject2).putExtra("pre_username", a(parama, paramau));
      ((Intent)localObject2).putExtra("from_scence", 2);
      ((Intent)localObject2).putExtra("expid_str", paramau.gxE);
      i = com.tencent.mm.u.p.G(a(parama, paramau), parama.bTW());
      ((Intent)localObject2).putExtra("prePublishId", "msg_" + Long.toString(paramau.field_msgSvrId));
      ((Intent)localObject2).putExtra("preUsername", a(parama, paramau));
      ((Intent)localObject2).putExtra("preChatName", parama.bTW());
      ((Intent)localObject2).putExtra("preChatTYPE", i);
      ((Intent)localObject2).putExtra("preMsgIndex", 0);
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
      ((Intent)localObject2).putExtra("share_report_pre_msg_url", locala.url);
      ((Intent)localObject2).putExtra("share_report_pre_msg_title", locala.title);
      ((Intent)localObject2).putExtra("share_report_pre_msg_desc", locala.description);
      ((Intent)localObject2).putExtra("share_report_pre_msg_icon_url", locala.thumburl);
      ((Intent)localObject2).putExtra("share_report_pre_msg_appid", locala.appId);
      ((Intent)localObject2).putExtra("share_report_from_scene", i);
      if (i == 5) {
        ((Intent)localObject2).putExtra("share_report_biz_username", parama.bTW());
      }
      com.tencent.mm.bb.d.b(parama.uRf.uRz, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      GMTrace.o(2219692785664L, 16538);
      return true;
      paramView = "singlemessage";
      break;
      label2999:
      ((Intent)localObject2).putExtra("shortUrl", locala.url);
      break label2534;
      label3016:
      paramView = ((PackageInfo)localObject1).versionName;
      break label2541;
      label3025:
      i = ((PackageInfo)localObject1).versionCode;
      break label2559;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
    label3053:
    GMTrace.o(2219692785664L, 16538);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */