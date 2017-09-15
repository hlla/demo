package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.sns.a.a.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.HashMap;

public final class j
{
  public String fOl;
  public String fOo;
  public long hZS;
  public int kC;
  public TextView lJf;
  public View mgy;
  public int qhY;
  public b vOt;
  public int vRA;
  public b.b vRb;
  public HashMap<String, Boolean> vRc;
  public RelativeLayout vRd;
  public f vRe;
  public ImageView vRf;
  public ImageView vRg;
  public MMPinProgressBtn vRh;
  public View vRi;
  public RelativeLayout vRj;
  public ImageView vRk;
  public ImageView vRl;
  public f vRm;
  public MMPinProgressBtn vRn;
  public TextView vRo;
  public LinearLayout vRp;
  public TextView vRq;
  public TextView vRr;
  public ImageView vRs;
  public ProgressBar vRt;
  public ProgressBar vRu;
  public LinearLayout vRv;
  public TextView vRw;
  public ImageView vRx;
  public MultiTouchImageView vRy;
  public int vRz;
  
  @TargetApi(11)
  public j(b paramb, View paramView)
  {
    GMTrace.i(2409879306240L, 17955);
    this.vRc = new HashMap();
    this.qhY = 0;
    this.vRz = 0;
    this.vRA = 0;
    this.fOl = "";
    this.mgy = paramView;
    this.vOt = paramb;
    this.vRy = ((MultiTouchImageView)paramView.findViewById(R.h.Kd));
    this.vRu = ((ProgressBar)paramView.findViewById(R.h.bWF));
    if ((com.tencent.mm.compatible.util.d.eo(11)) && (paramView.getLayerType() != 2)) {
      paramView.setLayerType(2, null);
    }
    GMTrace.o(2409879306240L, 17955);
  }
  
  public static void M(View paramView, int paramInt)
  {
    GMTrace.i(2410013523968L, 17956);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    GMTrace.o(2410013523968L, 17956);
  }
  
  public final void a(boolean paramBoolean, float paramFloat)
  {
    GMTrace.i(2410684612608L, 17961);
    v.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    if (paramBoolean)
    {
      View localView = (View)bXn().vRm;
      localView.setAlpha(paramFloat);
      M(localView, 0);
      if (paramFloat >= 1.0D)
      {
        M(bXn().vRk, 8);
        M(bXn().vRl, 8);
      }
      GMTrace.o(2410684612608L, 17961);
      return;
    }
    M((View)bXn().vRm, 8);
    M(bXn().vRk, 0);
    M(bXn().vRl, 0);
    GMTrace.o(2410684612608L, 17961);
  }
  
  public final j bXk()
  {
    GMTrace.i(2410147741696L, 17957);
    if (this.vRp == null)
    {
      this.vRp = ((LinearLayout)((ViewStub)this.mgy.findViewById(R.h.bWI)).inflate());
      this.vRt = ((ProgressBar)this.vRp.findViewById(R.h.bKq));
      this.vRq = ((TextView)this.vRp.findViewById(R.h.bKr));
      this.vRr = ((TextView)this.vRp.findViewById(R.h.bKp));
      this.vRs = ((ImageView)this.vRp.findViewById(R.h.bKs));
    }
    GMTrace.o(2410147741696L, 17957);
    return this;
  }
  
  public final j bXl()
  {
    GMTrace.i(2410281959424L, 17958);
    if (this.vRv == null)
    {
      this.vRv = ((LinearLayout)((ViewStub)this.mgy.findViewById(R.h.bWG)).inflate());
      this.vRx = ((ImageView)this.vRv.findViewById(R.h.bJW));
      this.vRw = ((TextView)this.vRv.findViewById(R.h.bJX));
    }
    GMTrace.o(2410281959424L, 17958);
    return this;
  }
  
  public final j bXm()
  {
    GMTrace.i(2410416177152L, 17959);
    if (this.vRd == null)
    {
      this.vRd = ((RelativeLayout)((ViewStub)this.mgy.findViewById(R.h.cFi)).inflate());
      this.vRe = com.tencent.mm.pluginsdk.ui.tools.n.dG(this.mgy.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      this.vRd.addView((View)this.vRe, localLayoutParams);
      ((View)this.vRe).setVisibility(8);
      this.vRi = this.vRd.findViewById(R.h.cIJ);
      this.vRi.setVisibility(8);
      this.lJf = ((TextView)this.vRd.findViewById(R.h.cEU));
      this.vRh = ((MMPinProgressBtn)this.vRd.findViewById(R.h.cFf));
      this.vRh.setVisibility(8);
      this.vRf = ((ImageView)this.vRd.findViewById(R.h.cFg));
      this.vRg = ((ImageView)this.vRd.findViewById(R.h.cMh));
      this.vRe.a(new f.a()
      {
        public final void TZ()
        {
          GMTrace.i(2463834832896L, 18357);
          GMTrace.o(2463834832896L, 18357);
        }
        
        public final int bI(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          GMTrace.i(2464237486080L, 18360);
          GMTrace.o(2464237486080L, 18360);
          return 0;
        }
        
        public final void bp(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          GMTrace.i(2464371703808L, 18361);
          GMTrace.o(2464371703808L, 18361);
        }
        
        public final void oW()
        {
          GMTrace.i(2464103268352L, 18359);
          j.this.vRe.start();
          j.this.vRi.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2468129800192L, 18389);
              if ((j.this.vRi == null) || (j.this.vRi.getVisibility() == 0))
              {
                GMTrace.o(2468129800192L, 18389);
                return;
              }
              if ((j.this.vRi.getTag() != null) && ((j.this.vRi.getTag() instanceof r)))
              {
                r localr = (r)j.this.vRi.getTag();
                if ((localr.iae != null) && (!bf.mA(localr.iae.hjt)))
                {
                  j.this.vRi.setVisibility(8);
                  GMTrace.o(2468129800192L, 18389);
                  return;
                }
                if ((localr.iae != null) && (!bf.mA(localr.iae.hjw)) && (!bf.mA(localr.iae.hjx)))
                {
                  j.this.vRi.setVisibility(8);
                  GMTrace.o(2468129800192L, 18389);
                  return;
                }
              }
              j.this.vRi.setVisibility(0);
              j.this.vRi.startAnimation(AnimationUtils.loadAnimation(j.this.vRi.getContext(), R.a.aQX));
              GMTrace.o(2468129800192L, 18389);
            }
          });
          GMTrace.o(2464103268352L, 18359);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          GMTrace.i(2463969050624L, 18358);
          j.this.vRe.stop();
          final String str = (String)((View)j.this.vRe).getTag();
          com.tencent.mm.sdk.a.b.r(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.bbJ() + "[ImageGallery] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + bf.ap(str, "")).getBytes(), 2), "FullScreenPlaySight");
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2463297961984L, 18353);
              if (bf.mA(str))
              {
                com.tencent.mm.ui.base.g.h(j.this.vOt.vNW, R.l.fac, R.l.dUX);
                GMTrace.o(2463297961984L, 18353);
                return;
              }
              Intent localIntent = new Intent();
              localIntent.setAction("android.intent.action.VIEW");
              localIntent.setDataAndType(Uri.fromFile(new File(str)), "video/*");
              try
              {
                j.this.vOt.vNW.startActivity(Intent.createChooser(localIntent, j.this.vOt.vNW.uRf.uRz.getString(R.l.ejD)));
                GMTrace.o(2463297961984L, 18353);
                return;
              }
              catch (Exception localException)
              {
                v.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.g.h(j.this.vOt.vNW, R.l.eiD, R.l.eiE);
                GMTrace.o(2463297961984L, 18353);
              }
            }
          });
          j.this.vRc.put(str, Boolean.valueOf(true));
          GMTrace.o(2463969050624L, 18358);
        }
      });
      this.lJf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          GMTrace.i(2438467682304L, 18168);
          if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof au)))
          {
            au localau = (au)paramAnonymousView.getTag();
            a.a(a.a.vvc, localau);
            r localr = t.lI(localau.field_imgPath);
            bdq localbdq = localr.iae;
            Object localObject;
            if ((localbdq != null) && (!u.mA(localbdq.hjt)))
            {
              o.KW();
              paramAnonymousView = s.lx(localau.field_imgPath);
              Intent localIntent = new Intent();
              localIntent.putExtra("IsAd", false);
              localIntent.putExtra("KStremVideoUrl", localbdq.hjt);
              localIntent.putExtra("KThumUrl", localbdq.hjy);
              localIntent.putExtra("KThumbPath", paramAnonymousView);
              localIntent.putExtra("KMediaId", "fakeid_" + localau.field_msgId);
              localIntent.putExtra("KMediaVideoTime", localbdq.txr);
              localIntent.putExtra("KMediaTitle", localbdq.hjv);
              localIntent.putExtra("StreamWording", localbdq.hjw);
              localIntent.putExtra("StremWebUrl", localbdq.hjx);
              localObject = localau.field_talker;
              boolean bool = ((String)localObject).endsWith("@chatroom");
              if (bool)
              {
                paramAnonymousView = ay.gi(localau.field_content);
                localIntent.putExtra("KSta_StremVideoAduxInfo", localbdq.hjz);
                localIntent.putExtra("KSta_StremVideoPublishId", localbdq.hjA);
                localIntent.putExtra("KSta_SourceType", 1);
                if (!bool) {
                  break label409;
                }
              }
              label409:
              for (int i = a.b.vvl.value;; i = a.b.vvk.value)
              {
                localIntent.putExtra("KSta_Scene", i);
                localIntent.putExtra("KSta_FromUserName", paramAnonymousView);
                localIntent.putExtra("KSta_ChatName", (String)localObject);
                localIntent.putExtra("KSta_MsgId", localau.field_msgSvrId);
                localIntent.putExtra("KSta_SnsStatExtStr", localr.fUO);
                if (bool) {
                  localIntent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.u.j.eC((String)localObject));
                }
                com.tencent.mm.bb.d.b(j.this.vOt.vNW.uRf.uRz, "sns", ".ui.VideoAdPlayerUI", localIntent);
                GMTrace.o(2438467682304L, 18168);
                return;
                paramAnonymousView = (View)localObject;
                break;
              }
            }
            if ((localbdq != null) && (!bf.mA(localbdq.hjw)) && (!bf.mA(localbdq.hjx)))
            {
              v.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + localbdq.hjx);
              paramAnonymousView = new Intent();
              localObject = new Bundle();
              ((Bundle)localObject).putString("key_snsad_statextstr", localr.fUO);
              paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject);
              paramAnonymousView.putExtra("rawUrl", localbdq.hjx);
              paramAnonymousView.putExtra("useJs", true);
              localObject = new c("", 18, 5, "", 2);
              ap.vd().a((k)localObject, 0);
              new ad(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(2420616724480L, 18035);
                  com.tencent.mm.bb.d.b(j.this.vOt.vNW.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                  GMTrace.o(2420616724480L, 18035);
                }
              });
            }
          }
          GMTrace.o(2438467682304L, 18168);
        }
      });
    }
    GMTrace.o(2410416177152L, 17959);
    return this;
  }
  
  public final j bXn()
  {
    GMTrace.i(2410550394880L, 17960);
    if (this.vRj == null)
    {
      this.vRj = ((RelativeLayout)((ViewStub)this.mgy.findViewById(R.h.cLZ)).inflate());
      this.vRk = ((ImageView)this.vRj.findViewById(R.h.cLI));
      this.vRl = ((ImageView)this.vRj.findViewById(R.h.cMg));
      this.vRl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2433635844096L, 18132);
          if (j.this.vOt != null)
          {
            v.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[] { Integer.valueOf(j.this.hashCode()), Integer.valueOf(j.this.kC) });
            j.this.vOt.Bm(j.this.kC);
          }
          GMTrace.o(2433635844096L, 18132);
        }
      });
      com.tencent.mm.modelcontrol.d.Ev();
      if (!com.tencent.mm.modelcontrol.d.EC()) {
        break label249;
      }
      this.vRm = new VideoPlayerTextureView(this.mgy.getContext());
      com.tencent.mm.plugin.report.service.g.oSF.a(354L, 150L, 1L, false);
    }
    for (;;)
    {
      this.vRo = ((TextView)this.mgy.findViewById(R.h.bHG));
      this.vRm.hd(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.vRj.addView((View)this.vRm, 2, localLayoutParams);
      this.vRn = ((MMPinProgressBtn)this.vRj.findViewById(R.h.cLD));
      this.vRn.setVisibility(8);
      ((View)this.vRm).setVisibility(8);
      this.vRm.a(new f.a()
      {
        public final void TZ()
        {
          GMTrace.i(2439004553216L, 18172);
          if (j.this.vOt != null) {
            j.this.vOt.vOc.bXh();
          }
          GMTrace.o(2439004553216L, 18172);
        }
        
        public final int bI(final int paramAnonymousInt1, final int paramAnonymousInt2)
        {
          GMTrace.i(2439407206400L, 18175);
          v.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(j.this.qhY), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(j.this.vRz), Integer.valueOf(j.this.vRA), j.this.fOl });
          ap.vL().D(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2483833274368L, 18506);
              com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.oSF;
              int j = j.this.vRz;
              if (paramAnonymousInt2 <= 0) {}
              for (int i = j.this.qhY * 1000;; i = paramAnonymousInt2)
              {
                localg.i(12084, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(1), j.this.fOl, Integer.valueOf(j.this.vRA), j.this.fOo, Long.valueOf(j.this.hZS) });
                GMTrace.o(2483833274368L, 18506);
                return;
              }
            }
          });
          GMTrace.o(2439407206400L, 18175);
          return 0;
        }
        
        public final void bp(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          GMTrace.i(2439541424128L, 18176);
          GMTrace.o(2439541424128L, 18176);
        }
        
        public final void oW()
        {
          GMTrace.i(2439272988672L, 18174);
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2427461828608L, 18086);
              j.this.vOt.vNW.lr(true);
              b localb = j.this.vOt;
              int i = j.this.kC;
              localb.vOc.BC(i);
              j.this.vOt.vOc.bXi();
              GMTrace.o(2427461828608L, 18086);
            }
          });
          GMTrace.o(2439272988672L, 18174);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          GMTrace.i(2439138770944L, 18173);
          v.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          if (j.this.vOt != null) {
            j.this.vOt.vOc.ec(paramAnonymousInt1, paramAnonymousInt2);
          }
          com.tencent.mm.plugin.report.service.g.oSF.i(12084, new Object[] { Integer.valueOf(j.this.vRz), Integer.valueOf(j.this.qhY * 1000), Integer.valueOf(0), Integer.valueOf(4), j.this.fOl, Integer.valueOf(j.this.vRA), j.this.fOo, Long.valueOf(j.this.hZS) });
          GMTrace.o(2439138770944L, 18173);
        }
      });
      GMTrace.o(2410550394880L, 17960);
      return this;
      label249:
      this.vRm = new VideoTextureView(this.mgy.getContext());
      com.tencent.mm.plugin.report.service.g.oSF.a(354L, 151L, 1L, false);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */