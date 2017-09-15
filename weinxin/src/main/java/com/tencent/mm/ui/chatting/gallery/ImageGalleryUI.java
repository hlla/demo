package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewPager.e;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.aj;
import com.tencent.mm.e.a.ak;
import com.tencent.mm.e.a.aq;
import com.tencent.mm.e.a.aq.b;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.a.gg;
import com.tencent.mm.e.a.gg.b;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.b;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.ui.tools.g.b;
import com.tencent.mm.ui.widget.e.a;
import com.tencent.mm.ui.x;
import com.tencent.mm.y.n;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI
  extends MMActivity
  implements View.OnClickListener, ai.a
{
  protected String chatroomName;
  public long fGD;
  protected String fJC;
  public long jZq;
  private n.d kRo;
  Bundle kjW;
  private boolean kjX;
  com.tencent.mm.ui.tools.g kjY;
  int kjZ;
  int kka;
  int kkb;
  int kkc;
  private com.tencent.mm.sdk.b.c lFy;
  private ImageView lKx;
  private ad mHandler;
  protected MMViewPager mfB;
  private int mmc;
  private int mmd;
  private boolean nyM;
  private com.tencent.mm.ui.widget.e qrH;
  private String qrI;
  private String qrL;
  private boolean qrM;
  private com.tencent.mm.sdk.b.c qrO;
  int qxG;
  int qxH;
  int qxI;
  private float qxJ;
  private int qxK;
  private int qxL;
  public boolean sLe;
  private boolean svZ;
  protected boolean vHr;
  private HashSet<Long> vJf;
  public b vNV;
  private final boolean vOf;
  private b.b vPO;
  private RelativeLayout vPP;
  private RelativeLayout vPQ;
  private boolean vPR;
  private boolean vPS;
  private ImageView vPT;
  private RelativeLayout vPU;
  private RelativeLayout vPV;
  private FrameLayout vPW;
  View vPX;
  Button vPY;
  Button vPZ;
  View vQa;
  private View vQb;
  protected VideoPlayerSeekBar vQc;
  private MultiTouchImageView vQd;
  int vQe;
  int vQf;
  boolean vQg;
  ArrayList<Integer> vQh;
  protected boolean vQi;
  protected boolean vQj;
  private boolean vQk;
  private String vQl;
  public a vQm;
  private View vQn;
  private CheckBox vQo;
  private View vQp;
  private int vQq;
  private ViewPager.e vQr;
  boolean vQs;
  ai vQt;
  private HashMap<Long, String> vQu;
  private boolean vQv;
  private boolean vQw;
  private ai vQx;
  private boolean vQy;
  private boolean vQz;
  private boolean vzI;
  
  public ImageGalleryUI()
  {
    GMTrace.i(2446923399168L, 18231);
    this.vPS = false;
    this.qxI = 0;
    this.vQe = 0;
    this.vQf = 0;
    this.kjZ = 0;
    this.kka = 0;
    this.kkb = 0;
    this.kkc = 0;
    this.vQh = new ArrayList();
    this.vzI = false;
    this.sLe = false;
    this.qrM = false;
    this.vQi = false;
    this.vHr = false;
    this.vQj = false;
    this.kjX = false;
    this.vOf = false;
    this.vQl = null;
    this.lFy = new com.tencent.mm.sdk.b.c() {};
    this.qrO = new com.tencent.mm.sdk.b.c() {};
    this.svZ = true;
    this.qxJ = 1.0F;
    this.qxK = 0;
    this.qxL = 0;
    this.kRo = new n.d()
    {
      public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        GMTrace.i(2483162185728L, 18501);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          GMTrace.o(2483162185728L, 18501);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.f(ImageGalleryUI.this).bWA();
          r localr;
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.bMb()))
          {
            localr = t.lI(paramAnonymousMenuItem.field_imgPath);
            if ((localr.status != 199) && (localr.status != 199))
            {
              ImageGalleryUI.b(ImageGalleryUI.this, t.e(paramAnonymousMenuItem.field_msgId, 1));
              ImageGalleryUI.f(ImageGalleryUI.this).Bn(ImageGalleryUI.this.mfB.ys);
              GMTrace.o(2483162185728L, 18501);
              return;
            }
            ImageGalleryUI.f(ImageGalleryUI.this).Bi(ImageGalleryUI.this.mfB.ys);
            GMTrace.o(2483162185728L, 18501);
            return;
          }
          ImageGalleryUI.f(ImageGalleryUI.this).Bi(ImageGalleryUI.this.mfB.ys);
          GMTrace.o(2483162185728L, 18501);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.f(ImageGalleryUI.this).bWA();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.bMb()))
          {
            localr = t.lI(paramAnonymousMenuItem.field_imgPath);
            if ((localr.status != 199) && (localr.status != 199))
            {
              ImageGalleryUI.b(ImageGalleryUI.this, t.e(paramAnonymousMenuItem.field_msgId, 2));
              ImageGalleryUI.f(ImageGalleryUI.this).Bn(ImageGalleryUI.this.mfB.ys);
              GMTrace.o(2483162185728L, 18501);
              return;
            }
            paramAnonymousMenuItem = new ArrayList();
            paramAnonymousMenuItem.add(ImageGalleryUI.f(ImageGalleryUI.this).bWA());
            b.c(ImageGalleryUI.this.uRf.uRz, paramAnonymousMenuItem);
            GMTrace.o(2483162185728L, 18501);
            return;
          }
          paramAnonymousMenuItem = new ArrayList();
          paramAnonymousMenuItem.add(ImageGalleryUI.f(ImageGalleryUI.this).bWA());
          com.tencent.mm.modelstat.b.hTV.y((au)paramAnonymousMenuItem.get(0));
          b.c(ImageGalleryUI.this.uRf.uRz, paramAnonymousMenuItem);
          GMTrace.o(2483162185728L, 18501);
          return;
          ImageGalleryUI.f(ImageGalleryUI.this).Bj(ImageGalleryUI.this.mfB.ys);
          GMTrace.o(2483162185728L, 18501);
          return;
          if (com.tencent.mm.bb.d.Jr("favorite"))
          {
            ImageGalleryUI.f(ImageGalleryUI.this).Bk(ImageGalleryUI.this.mfB.ys);
            GMTrace.o(2483162185728L, 18501);
            return;
            v.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
            paramAnonymousMenuItem = new bx();
            paramAnonymousMenuItem.fFe.activity = ImageGalleryUI.this;
            paramAnonymousMenuItem.fFe.fDB = ImageGalleryUI.c(ImageGalleryUI.this);
            paramAnonymousMenuItem.fFe.fFf = ImageGalleryUI.w(ImageGalleryUI.this);
            paramAnonymousMenuItem.fFe.fFg = ImageGalleryUI.x(ImageGalleryUI.this);
            paramAnonymousMenuItem.fFe.scene = 37;
            paramAnonymousMenuItem.fFe.fFl = ImageGalleryUI.this.getIntent().getBundleExtra("_stat_obj");
            ImageGalleryUI.a(ImageGalleryUI.this, paramAnonymousMenuItem);
            ImageGalleryUI.b(ImageGalleryUI.this, paramAnonymousMenuItem);
            com.tencent.mm.sdk.b.a.uql.m(paramAnonymousMenuItem);
            GMTrace.o(2483162185728L, 18501);
            return;
            ImageGalleryUI.y(ImageGalleryUI.this);
            GMTrace.o(2483162185728L, 18501);
            return;
            if (b.aR(ImageGalleryUI.f(ImageGalleryUI.this).bWA())) {
              ImageGalleryUI.z(ImageGalleryUI.this);
            }
          }
        }
      }
    };
    this.vQq = 0;
    this.vQr = new ViewPager.e()
    {
      private boolean vQB;
      
      public final void V(int paramAnonymousInt)
      {
        GMTrace.i(2440212512768L, 18181);
        if (ImageGalleryUI.f(ImageGalleryUI.this) == null)
        {
          GMTrace.o(2440212512768L, 18181);
          return;
        }
        Object localObject1 = ImageGalleryUI.f(ImageGalleryUI.this).Ag(paramAnonymousInt);
        if (localObject1 == null) {
          v.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        ImageGalleryUI.q(ImageGalleryUI.this);
        ImageGalleryUI.e(ImageGalleryUI.this, paramAnonymousInt);
        Object localObject2;
        long l;
        if (ImageGalleryUI.f(ImageGalleryUI.this) != null)
        {
          localObject2 = ImageGalleryUI.f(ImageGalleryUI.this);
          ((b)localObject2).vOc.bWI();
          ((b)localObject2).vOd.bWI();
          localObject2 = ImageGalleryUI.f(ImageGalleryUI.this).Bh(paramAnonymousInt);
          if (((b.aR((au)localObject2)) || (b.aU((au)localObject2))) && (localObject1 != null) && (((View)localObject1).getTag() != null)) {
            ((j)((View)localObject1).getTag()).vRy.bSz();
          }
          if (localObject2 != null) {
            ImageGalleryUI.this.eT(((ce)localObject2).field_msgId);
          }
          if (ImageGalleryUI.f(ImageGalleryUI.this) == null) {
            break label416;
          }
          localObject1 = ImageGalleryUI.f(ImageGalleryUI.this).e((au)localObject2, false);
          if (!b.a((au)localObject2, (com.tencent.mm.ah.d)localObject1)) {
            break label340;
          }
          localObject1 = com.tencent.mm.ah.e.a((com.tencent.mm.ah.d)localObject1);
          int i = ((com.tencent.mm.ah.d)localObject1).hrb;
          int j = ((com.tencent.mm.ah.d)localObject1).offset;
          if (i == 0) {
            break label334;
          }
          l = j * 100L / i - 1L;
          i = Math.max(1, (int)l);
          v.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
          ImageGalleryUI.this.BB(i);
        }
        for (;;)
        {
          if (ImageGalleryUI.f(ImageGalleryUI.this) != null) {
            ImageGalleryUI.f(ImageGalleryUI.this).V(paramAnonymousInt);
          }
          GMTrace.o(2440212512768L, 18181);
          return;
          label334:
          l = 0L;
          break;
          label340:
          if ((localObject2 != null) && (!((au)localObject2).bMb()) && (ImageGalleryUI.f(ImageGalleryUI.this).aW((au)localObject2)))
          {
            ImageGalleryUI.this.eu(false);
          }
          else
          {
            ImageGalleryUI.this.eu(true);
            for (;;)
            {
              if (localObject2 != null) {
                break label426;
              }
              v.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = " + paramAnonymousInt);
              break;
              label416:
              v.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
            }
            label426:
            ImageGalleryUI.this.bk((au)localObject2);
            ImageGalleryUI.g(ImageGalleryUI.this);
          }
        }
      }
      
      public final void W(int paramAnonymousInt)
      {
        GMTrace.i(2440346730496L, 18182);
        v.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 2)
        {
          this.vQB = true;
          ImageGalleryUI.A(ImageGalleryUI.this);
          ImageGalleryUI.B(ImageGalleryUI.this);
          ImageGalleryUI.C(ImageGalleryUI.this);
        }
        if (paramAnonymousInt == 0)
        {
          if (this.vQB) {
            ImageGalleryUI.this.bXc();
          }
          this.vQB = false;
        }
        if (ImageGalleryUI.f(ImageGalleryUI.this) != null)
        {
          Object localObject = ImageGalleryUI.f(ImageGalleryUI.this);
          if (((b)localObject).vOb != null)
          {
            localObject = ((b)localObject).vOb;
            ((d)localObject).xV = paramAnonymousInt;
            if (((d)localObject).vPp != null) {
              ((d)localObject).vPp.W(paramAnonymousInt);
            }
          }
        }
        GMTrace.o(2440346730496L, 18182);
      }
      
      public final void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        GMTrace.i(2440078295040L, 18180);
        GMTrace.o(2440078295040L, 18180);
      }
    };
    this.vQs = false;
    this.vQt = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(2473095856128L, 18426);
        if (ImageGalleryUI.D(ImageGalleryUI.this)) {
          ImageGalleryUI.this.bWU();
        }
        GMTrace.o(2473095856128L, 18426);
        return false;
      }
    }, false);
    this.vQu = new HashMap();
    this.vQv = false;
    this.vQw = false;
    this.mHandler = new ad();
    this.vQy = false;
    this.vQz = false;
    this.vJf = new HashSet();
    GMTrace.o(2446923399168L, 18231);
  }
  
  static Animation BA(int paramInt)
  {
    GMTrace.i(2453097414656L, 18277);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(10.0F));
    GMTrace.o(2453097414656L, 18277);
    return localAlphaAnimation;
  }
  
  private void By(int paramInt)
  {
    GMTrace.i(2451486801920L, 18265);
    v.i("MicroMsg.ImageGalleryUI", "enterGrid source : " + paramInt);
    if (this.vNV == null)
    {
      v.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
      GMTrace.o(2451486801920L, 18265);
      return;
    }
    com.tencent.mm.plugin.report.service.g.oSF.a(219L, 13L, 1L, true);
    int i = this.vNV.ani();
    if (this.vNV.bWA() == null)
    {
      v.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
      GMTrace.o(2451486801920L, 18265);
      return;
    }
    int j = this.vNV.vNX.Br(this.mfB.ys);
    if (!this.vQi)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.uRf.uRz, MediaHistoryGalleryUI.class);
      localIntent.addFlags(67108864);
      localIntent.putExtra("kintent_intent_source", paramInt);
      localIntent.putExtra("kintent_talker", bWN());
      localIntent.putExtra("kintent_image_count", i);
      localIntent.putExtra("kintent_image_index", j);
      localIntent.putExtra("key_biz_chat_id", this.jZq);
      localIntent.putExtra("key_is_biz_chat", this.sLe);
      startActivity(localIntent);
      com.tencent.mm.ui.base.b.eM(this.uRf.uRz);
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2445849657344L, 18223);
          ImageGalleryUI.this.finish();
          GMTrace.o(2445849657344L, 18223);
        }
      }, 50L);
      GMTrace.o(2451486801920L, 18265);
      return;
    }
    aht();
    GMTrace.o(2451486801920L, 18265);
  }
  
  private static void L(View paramView, int paramInt)
  {
    GMTrace.i(2447728705536L, 18237);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    GMTrace.o(2447728705536L, 18237);
  }
  
  private View a(b paramb, MMViewPager paramMMViewPager)
  {
    GMTrace.i(2449070882816L, 18247);
    boolean bool1;
    if (paramb == null)
    {
      bool1 = true;
      if (paramMMViewPager != null) {
        break label81;
      }
    }
    label81:
    for (boolean bool2 = true;; bool2 = false)
    {
      v.d("MicroMsg.ImageGalleryUI", "get current view adapter is null %b, gallery is null %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramb == null) || (paramMMViewPager == null)) {
        break label159;
      }
      if (paramb.bWA() != null) {
        break label87;
      }
      GMTrace.o(2449070882816L, 18247);
      return null;
      bool1 = false;
      break;
    }
    label87:
    if ((paramb.bWA().bLX()) || (paramb.bWA().bMf())) {
      paramb = paramb.ng(paramMMViewPager.ys);
    }
    for (;;)
    {
      GMTrace.o(2449070882816L, 18247);
      return paramb;
      if ((paramb.bWA().bMb()) || (paramb.bWA().bMc()))
      {
        paramb = paramb.Bl(paramMMViewPager.ys);
        continue;
        label159:
        v.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", new Object[] { Integer.valueOf(hashCode()) });
      }
      else
      {
        paramb = null;
      }
    }
  }
  
  private void aht()
  {
    GMTrace.i(2449205100544L, 18248);
    if (this.vPS)
    {
      v.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
      GMTrace.o(2449205100544L, 18248);
      return;
    }
    this.vPS = true;
    if (this.vPR)
    {
      finish();
      com.tencent.mm.ui.base.b.eM(this.uRf.uRz);
      GMTrace.o(2449205100544L, 18248);
      return;
    }
    v.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
    int n = 0;
    int m = 0;
    int i2 = this.mfB.getWidth() / 2;
    int i1 = this.mfB.getHeight() / 2;
    this.vNV.bWy();
    Object localObject1;
    int i3;
    int i;
    int k;
    int j;
    label433:
    Object localObject2;
    if (this.vQi)
    {
      localObject1 = new gg();
      ((gg)localObject1).fLo.fGD = this.vNV.Bh(this.mfB.ys).field_msgId;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      i3 = ((gg)localObject1).fLp.fDU;
      i = ((gg)localObject1).fLp.fDV;
      k = ((gg)localObject1).fLp.fDS;
      j = ((gg)localObject1).fLp.fDT;
      this.qxG = this.mfB.getWidth();
      this.qxH = this.mfB.getHeight();
      if ((this.vNV != null) && (this.vNV.bWA() != null))
      {
        if ((this.vNV.bWA().bMc()) || (this.vNV.bWA().bMb())) {
          this.qxH = ((int)(this.qxG / i3 * i));
        }
        if ((this.vNV.bWA().bLX()) || (this.vNV.bWA().bMf())) {
          this.vQd = this.vNV.ng(this.mfB.ys);
        }
      }
      m = i;
      if (this.vQd != null)
      {
        this.qxH = ((int)(this.qxG / this.vQd.imageWidth * this.vQd.imageHeight));
        m = i;
        if (this.qxH > this.mfB.getHeight())
        {
          m = i;
          if (this.qxH < this.mfB.getHeight() * 1.5D)
          {
            if (!this.vQi) {
              break label919;
            }
            this.qxI = (this.qxH - this.mfB.getHeight());
            m = i;
          }
          this.qxH = this.mfB.getHeight();
        }
      }
      localObject1 = this.kjY;
      i = this.vQe;
      n = this.vQf;
      ((com.tencent.mm.ui.tools.g)localObject1).qmP = i;
      ((com.tencent.mm.ui.tools.g)localObject1).qmQ = n;
      ((com.tencent.mm.ui.tools.g)localObject1).qmR = 0;
      ((com.tencent.mm.ui.tools.g)localObject1).qmS = 0;
      this.kjY.qmO = this.qxI;
      this.kjY.ek(this.qxG, this.qxH);
      this.kjY.p(k, j, i3, m);
      localObject1 = this.mfB;
      localObject2 = a(this.vNV, this.mfB);
      if (localObject2 == null) {
        break label938;
      }
      localObject1 = localObject2;
      if (this.qxJ != 1.0D)
      {
        this.kjY.wks = (1.0F / this.qxJ);
        if (this.qxK == 0)
        {
          localObject1 = localObject2;
          if (this.qxL == 0) {}
        }
        else
        {
          i = (int)(this.mfB.getWidth() / 2 * (1.0F - this.qxJ));
          j = this.qxK;
          k = (int)(this.mfB.getHeight() / 2 + this.qxL - this.qxH / 2 * this.qxJ);
          this.kjY.el(i + j, k);
          localObject1 = localObject2;
        }
      }
    }
    label919:
    label938:
    for (;;)
    {
      this.kjY.a((View)localObject1, this.lKx, new g.b()
      {
        public final void onAnimationEnd()
        {
          GMTrace.i(2465579663360L, 18370);
          ImageGalleryUI.p(ImageGalleryUI.this).post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2435380674560L, 18145);
              ImageGalleryUI.this.finish();
              ImageGalleryUI.this.overridePendingTransition(0, 0);
              ImageGalleryUI.u(ImageGalleryUI.this);
              GMTrace.o(2435380674560L, 18145);
            }
          });
          GMTrace.o(2465579663360L, 18370);
        }
        
        public final void onAnimationStart()
        {
          GMTrace.i(2465445445632L, 18369);
          ImageGalleryUI.dx(ImageGalleryUI.s(ImageGalleryUI.this));
          ImageGalleryUI.dx(ImageGalleryUI.t(ImageGalleryUI.this));
          new ad().postDelayed(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2413905838080L, 17985);
              if (ImageGalleryUI.l(ImageGalleryUI.this) != null) {
                ImageGalleryUI.l(ImageGalleryUI.this).bSz();
              }
              GMTrace.o(2413905838080L, 17985);
            }
          }, 20L);
          GMTrace.o(2465445445632L, 18369);
        }
      }, null);
      GMTrace.o(2449205100544L, 18248);
      return;
      localObject1 = this.vNV.Bh(this.mfB.ys);
      if (localObject1 != null)
      {
        localObject2 = new aq();
        ((aq)localObject2).fDQ.fCQ = ((au)localObject1);
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
        n = ((aq)localObject2).fDR.fDU;
        m = ((aq)localObject2).fDR.fDV;
        i2 = ((aq)localObject2).fDR.fDS;
        i1 = ((aq)localObject2).fDR.fDT;
      }
      if ((i2 == 0) && (i1 == 0))
      {
        k = this.mfB.getWidth() / 2;
        j = this.mfB.getHeight() / 2;
        i = m;
        i3 = n;
        break;
      }
      j = i1;
      k = i2;
      i = m;
      i3 = n;
      if (localObject1 == null) {
        break;
      }
      if (((ce)localObject1).field_isSend == 0) {
        this.vQe = com.tencent.mm.bg.a.fromDPToPix(this.uRf.uRz, 5);
      }
      j = i1;
      k = i2;
      i = m;
      i3 = n;
      if (((ce)localObject1).field_isSend != 1) {
        break;
      }
      this.vQf = com.tencent.mm.bg.a.fromDPToPix(this.uRf.uRz, 5);
      j = i1;
      k = i2;
      i = m;
      i3 = n;
      break;
      m = i * this.mfB.getHeight() / this.qxH;
      break label433;
    }
  }
  
  private ImageGalleryUI bWL()
  {
    GMTrace.i(2447460270080L, 18235);
    if (this.vPU == null) {
      this.vPU = ((RelativeLayout)((ViewStub)findViewById(R.h.bVo)).inflate());
    }
    GMTrace.o(2447460270080L, 18235);
    return this;
  }
  
  private ImageGalleryUI bWM()
  {
    GMTrace.i(2447594487808L, 18236);
    if (this.vPV == null)
    {
      this.vPV = ((RelativeLayout)((ViewStub)findViewById(R.h.bWD)).inflate());
      this.vPV.findViewById(R.h.bJQ).setOnClickListener(this);
    }
    GMTrace.o(2447594487808L, 18236);
    return this;
  }
  
  private String bWN()
  {
    GMTrace.i(2448802447360L, 18245);
    if ((this.chatroomName != null) && (this.chatroomName.length() > 0))
    {
      str = this.chatroomName;
      GMTrace.o(2448802447360L, 18245);
      return str;
    }
    String str = this.fJC;
    GMTrace.o(2448802447360L, 18245);
    return str;
  }
  
  private void bWO()
  {
    GMTrace.i(2449876189184L, 18253);
    if ((this.vNV == null) || (this.vPR))
    {
      GMTrace.o(2449876189184L, 18253);
      return;
    }
    if (!this.vNV.bWz())
    {
      GMTrace.o(2449876189184L, 18253);
      return;
    }
    if (bWL().vPU == null)
    {
      GMTrace.o(2449876189184L, 18253);
      return;
    }
    if (g.a.vPK.vPI)
    {
      bWQ();
      GMTrace.o(2449876189184L, 18253);
      return;
    }
    if ((this.vzI) || (this.vQk))
    {
      bWQ();
      GMTrace.o(2449876189184L, 18253);
      return;
    }
    v.d("MicroMsg.ImageGalleryUI", "%d show enter grid is video %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bWR()) });
    bWP();
    bXc();
    GMTrace.o(2449876189184L, 18253);
  }
  
  private void bWP()
  {
    int i = 0;
    GMTrace.i(2450010406912L, 18254);
    L(bWL().vPU, 0);
    RelativeLayout localRelativeLayout = bWM().vPV;
    if (this.vPO == b.b.vOC) {}
    for (;;)
    {
      L(localRelativeLayout, i);
      GMTrace.o(2450010406912L, 18254);
      return;
      i = 8;
    }
  }
  
  private void bWQ()
  {
    GMTrace.i(2450144624640L, 18255);
    L(bWL().vPU, 8);
    L(bWM().vPV, 8);
    GMTrace.o(2450144624640L, 18255);
  }
  
  private boolean bWR()
  {
    GMTrace.i(2450547277824L, 18258);
    if (this.vPO == b.b.vOD)
    {
      GMTrace.o(2450547277824L, 18258);
      return true;
    }
    GMTrace.o(2450547277824L, 18258);
    return false;
  }
  
  private void bWZ()
  {
    GMTrace.i(2452694761472L, 18274);
    if ((bWL().vPU == null) || (!this.vQy) || (bWR()))
    {
      GMTrace.o(2452694761472L, 18274);
      return;
    }
    if (bWL().vPU.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.ImageGalleryUI", "fadeInEnterGirdBtn: %B %s", new Object[] { Boolean.valueOf(bool), bf.bJP() });
      bWL().vPU.startAnimation(bXb());
      bWM().vPV.startAnimation(bXb());
      this.vQy = false;
      GMTrace.o(2452694761472L, 18274);
      return;
    }
  }
  
  private void bXa()
  {
    boolean bool = true;
    GMTrace.i(2452828979200L, 18275);
    if ((bWL().vPW == null) || (!this.vQz))
    {
      GMTrace.o(2452828979200L, 18275);
      return;
    }
    if (bWL().vPW.getVisibility() == 0) {}
    for (;;)
    {
      v.d("MicroMsg.ImageGalleryUI", "fadeInPositionAtChatRecordBtn: %B", new Object[] { Boolean.valueOf(bool) });
      bWL().vPW.startAnimation(bXb());
      this.vQz = false;
      GMTrace.o(2452828979200L, 18275);
      return;
      bool = false;
    }
  }
  
  private static Animation bXb()
  {
    GMTrace.i(2452963196928L, 18276);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillAfter(true);
    GMTrace.o(2452963196928L, 18276);
    return localAlphaAnimation;
  }
  
  private void bXd()
  {
    GMTrace.i(2453500067840L, 18280);
    v.d("MicroMsg.ImageGalleryUI", "jacks stop Hide Timer");
    this.vQx.KI();
    GMTrace.o(2453500067840L, 18280);
  }
  
  private void bXe()
  {
    GMTrace.i(2454439591936L, 18287);
    boolean bool = x.eF(this);
    int i = x.eE(this);
    v.i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.nyM), Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((this.nyM) && (bool))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.vPP.getLayoutParams());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, i);
      this.vPP.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(this.vPQ.getLayoutParams());
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, 0, localLayoutParams.bottomMargin);
      this.vPQ.setLayoutParams(localLayoutParams);
    }
    GMTrace.o(2454439591936L, 18287);
  }
  
  private void bXf()
  {
    GMTrace.i(2454573809664L, 18288);
    boolean bool = x.eF(this);
    int i = x.eE(this);
    v.i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.nyM), Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((this.nyM) && (bool))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.vPP.getLayoutParams());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, i, 0);
      this.vPP.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(this.vPQ.getLayoutParams());
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, i, localLayoutParams.bottomMargin);
      this.vPQ.setLayoutParams(localLayoutParams);
    }
    GMTrace.o(2454573809664L, 18288);
  }
  
  private void bXg()
  {
    GMTrace.i(16438584672256L, 122477);
    String str1 = getIntent().getStringExtra("GalleryUI_FromUser");
    String str2 = getIntent().getStringExtra("GalleryUI_ToUser");
    Intent localIntent = new Intent();
    au localau = this.vNV.bWA();
    String str3 = d.a(localau, d.bg(localau), false);
    v.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[] { str3, Long.valueOf(localau.field_msgId) });
    localIntent.putExtra("before_photo_edit", str3);
    localIntent.putExtra("GalleryUI_FromUser", str1);
    localIntent.putExtra("GalleryUI_ToUser", str2);
    localIntent.putExtra("GalleryUI_ToUser", str2);
    localIntent.putExtra("from_scene", 291);
    localIntent.putExtra("after_photo_edit", "");
    com.tencent.mm.bb.d.b(this, "photoedit", ".ui.MMPhotoEditUI", localIntent, 4369);
    overridePendingTransition(0, 0);
    GMTrace.o(16438584672256L, 122477);
  }
  
  private static boolean d(au paramau, com.tencent.mm.ah.d paramd)
  {
    GMTrace.i(2450278842368L, 18256);
    try
    {
      if ((b.b(paramau, paramd) == 0) && (paramd.GC()))
      {
        boolean bool = paramau.bMj();
        if (!bool)
        {
          GMTrace.o(2450278842368L, 18256);
          return true;
        }
      }
    }
    catch (NullPointerException paramau)
    {
      v.e("MicroMsg.ImageGalleryUI", "error:" + paramau);
      GMTrace.o(2450278842368L, 18256);
    }
    return false;
  }
  
  private static int dv(View paramView)
  {
    GMTrace.i(2447862923264L, 18238);
    if (paramView != null)
    {
      int i = paramView.getVisibility();
      GMTrace.o(2447862923264L, 18238);
      return i;
    }
    GMTrace.o(2447862923264L, 18238);
    return 8;
  }
  
  private static void dw(View paramView)
  {
    GMTrace.i(2451218366464L, 18263);
    if (com.tencent.mm.compatible.util.d.eo(16))
    {
      paramView.setBackground(null);
      GMTrace.o(2451218366464L, 18263);
      return;
    }
    paramView.setBackgroundDrawable(null);
    GMTrace.o(2451218366464L, 18263);
  }
  
  private void lq(boolean paramBoolean)
  {
    GMTrace.i(2451084148736L, 18262);
    v.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.vPQ.setBackgroundResource(R.g.bfS);
      this.vPP.setBackgroundResource(R.g.bfR);
      GMTrace.o(2451084148736L, 18262);
      return;
    }
    dw(this.vPQ);
    dw(this.vPP);
    GMTrace.o(2451084148736L, 18262);
  }
  
  public final void BB(int paramInt)
  {
    GMTrace.i(2453634285568L, 18281);
    eu(true);
    bWU();
    bWJ().vPX.setVisibility(0);
    bWJ().vPY.setVisibility(8);
    bWJ().vPZ.setVisibility(0);
    bWJ().vQa.setVisibility(8);
    bWX();
    bWY();
    bWJ().vPZ.setText(paramInt + "%");
    GMTrace.o(2453634285568L, 18281);
  }
  
  public final void Bx(int paramInt)
  {
    GMTrace.i(2450413060096L, 18257);
    bk(this.vNV.Bh(paramInt));
    GMTrace.o(2450413060096L, 18257);
  }
  
  public final void Bz(final int paramInt)
  {
    GMTrace.i(2452157890560L, 18270);
    if (bWK().vQb == null)
    {
      GMTrace.o(2452157890560L, 18270);
      return;
    }
    bWK().vQb.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2436991287296L, 18157);
        if (ImageGalleryUI.f(ImageGalleryUI.this) == null)
        {
          GMTrace.o(2436991287296L, 18157);
          return;
        }
        b localb = ImageGalleryUI.f(ImageGalleryUI.this);
        int i = paramInt;
        localb.vOc.pause(i);
        GMTrace.o(2436991287296L, 18157);
      }
    });
    GMTrace.o(2452157890560L, 18270);
  }
  
  protected final void KD()
  {
    GMTrace.i(2448936665088L, 18246);
    this.kjY = new com.tencent.mm.ui.tools.g(this.uRf.uRz);
    this.vQx = new ai(this, false);
    this.kjX = false;
    this.fJC = getIntent().getStringExtra("img_gallery_talker");
    this.vQi = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
    this.vHr = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
    this.vQk = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
    this.vzI = getIntent().getBooleanExtra("show_search_chat_content_result", false);
    this.sLe = getIntent().getBooleanExtra("key_is_biz_chat", false);
    this.jZq = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.vPR = getIntent().getBooleanExtra("img_preview_only", false);
    if (!this.vPR)
    {
      localObject1 = "MicroMsg.ImageGalleryUI initView, talker is null, stack = " + bf.bJP();
      if (this.fJC == null) {
        break label386;
      }
    }
    long l;
    label386:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject1, bool);
      this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
      this.vQj = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
      this.vQl = getIntent().getStringExtra("img_gallery_enter_video_opcode");
      bool = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
      localObject2 = getIntent().getStringExtra("img_gallery_directly_send_name");
      this.fGD = getIntent().getLongExtra("img_gallery_msg_id", 0L);
      l = getIntent().getLongExtra("img_gallery_msg_svr_id", 0L);
      if ((this.fGD > 0L) || (l != 0L)) {
        break;
      }
      v.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.fGD + ", msgSvrId = " + l + ", stack = " + bf.bJP());
      finish();
      GMTrace.o(2448936665088L, 18246);
      return;
    }
    if (this.fGD == 0L)
    {
      ap.yY();
      this.fGD = com.tencent.mm.u.c.wT().x(bWN(), l).field_msgId;
    }
    ap.yY();
    Object localObject1 = com.tencent.mm.u.c.wT().cA(this.fGD);
    if (((ce)localObject1).field_msgId <= 0L)
    {
      v.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.fGD + ", msgSvrId = " + l + ", stack = " + bf.bJP());
      finish();
      GMTrace.o(2448936665088L, 18246);
      return;
    }
    this.vNV = new b(this, this.fGD, bWN(), this.sLe, this.jZq, bool, (String)localObject2, Boolean.valueOf(this.vQj));
    this.vNV.vOf = false;
    this.vNV.vNZ = getIntent().getBooleanExtra("start_chatting_ui", true);
    this.vNV.vOe = new b.c()
    {
      public final void TZ()
      {
        GMTrace.i(2426522304512L, 18079);
        if (ImageGalleryUI.f(ImageGalleryUI.this) == null)
        {
          GMTrace.o(2426522304512L, 18079);
          return;
        }
        ImageGalleryUI.g(ImageGalleryUI.this);
        ImageGalleryUI.f(ImageGalleryUI.this).V(100000);
        GMTrace.o(2426522304512L, 18079);
      }
    };
    this.vPP = ((RelativeLayout)findViewById(R.h.bHh));
    this.vPQ = ((RelativeLayout)findViewById(R.h.bHg));
    this.vPT = ((ImageView)findViewById(R.h.cLw));
    this.vPT.setOnClickListener(this);
    Object localObject2 = getWindowManager().getDefaultDisplay();
    int j = ((Display)localObject2).getWidth();
    int k = ((Display)localObject2).getHeight();
    int i;
    if (j < k)
    {
      i = 1;
      v.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i != 0) {
        break label1102;
      }
      i = 0;
      label727:
      if (i == 0) {
        break label1107;
      }
      bXe();
    }
    for (;;)
    {
      this.lKx = ((ImageView)findViewById(R.h.bSm));
      this.lKx.setLayerType(2, null);
      this.mfB = ((MMViewPager)findViewById(R.h.bSk));
      this.mfB.setLayerType(2, null);
      this.mfB.setVerticalFadingEdgeEnabled(false);
      this.mfB.setHorizontalFadingEdgeEnabled(false);
      this.mfB.vlF = new MMViewPager.e()
      {
        public final void ahu()
        {
          GMTrace.i(2434843803648L, 18141);
          ImageGalleryUI.h(ImageGalleryUI.this);
          GMTrace.o(2434843803648L, 18141);
        }
        
        public final void ayV()
        {
          GMTrace.i(2434978021376L, 18142);
          ImageGalleryUI.i(ImageGalleryUI.this);
          GMTrace.o(2434978021376L, 18142);
        }
      };
      if (!this.vPR)
      {
        this.mfB.vlH = this.vQr;
        this.mfB.vlG = new MMViewPager.c()
        {
          public final void atY()
          {
            GMTrace.i(2434172715008L, 18136);
            ImageGalleryUI.this.lp(true);
            GMTrace.o(2434172715008L, 18136);
          }
        };
      }
      this.mfB.BW(1);
      localObject2 = this.mfB;
      i = ((WxViewPager)localObject2).yz;
      ((WxViewPager)localObject2).yz = 50;
      j = ((WxViewPager)localObject2).getWidth();
      ((WxViewPager)localObject2).u(j, j, 50, i);
      ((WxViewPager)localObject2).requestLayout();
      this.mfB.a(this.vNV);
      Bx(100000);
      this.mfB.Y(100000);
      this.mfB.postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2409073999872L, 17949);
          if (ImageGalleryUI.f(ImageGalleryUI.this) == null)
          {
            GMTrace.o(2409073999872L, 17949);
            return;
          }
          if ((g.a.vPK.vPI) && (ImageGalleryUI.j(ImageGalleryUI.this) != null))
          {
            ImageGalleryUI.j(ImageGalleryUI.this).setChecked(g.a.vPK.bj(ImageGalleryUI.f(ImageGalleryUI.this).bWA()));
            ImageGalleryUI.k(ImageGalleryUI.this).setOnClickListener(ImageGalleryUI.this);
          }
          if (ImageGalleryUI.this.mfB.ys != 100000)
          {
            GMTrace.o(2409073999872L, 17949);
            return;
          }
          ImageGalleryUI.this.bXc();
          b.b localb = b.aX(ImageGalleryUI.f(ImageGalleryUI.this).Bh(100000));
          if ((!ImageGalleryUI.this.vQj) && (localb == b.b.vOD)) {
            ImageGalleryUI.f(ImageGalleryUI.this).Bm(100000);
          }
          if (localb == b.b.vOE) {
            ImageGalleryUI.f(ImageGalleryUI.this).Bq(100000);
          }
          GMTrace.o(2409073999872L, 17949);
        }
      }, 0L);
      if (g.a.vPK.vPI)
      {
        this.vQn = ((ViewStub)findViewById(R.h.cCd)).inflate();
        this.vQn.setVisibility(0);
        this.vQo = ((CheckBox)this.vQn.findViewById(R.h.cji));
        this.vQp = this.vQn.findViewById(R.h.cjj);
      }
      this.vQg = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
      localObject1 = this.vNV.e((au)localObject1, true);
      if (localObject1 == null) {
        v.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[] { Boolean.valueOf(this.vQg) });
      }
      if ((!this.vQg) || (localObject1 == null) || (!((com.tencent.mm.ah.d)localObject1).GB())) {
        break label1114;
      }
      bXg();
      this.vQg = false;
      GMTrace.o(2448936665088L, 18246);
      return;
      i = 0;
      break;
      label1102:
      i = 1;
      break label727;
      label1107:
      bXf();
    }
    label1114:
    if (this.vQg) {
      v.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
    }
    GMTrace.o(2448936665088L, 18246);
  }
  
  protected final void Sz()
  {
    GMTrace.i(2449741971456L, 18252);
    super.Sz();
    GMTrace.o(2449741971456L, 18252);
  }
  
  public final boolean WV()
  {
    GMTrace.i(2447997140992L, 18239);
    GMTrace.o(2447997140992L, 18239);
    return true;
  }
  
  final ImageGalleryUI bWJ()
  {
    GMTrace.i(2447191834624L, 18233);
    if (this.vPX == null)
    {
      this.vPX = ((ViewStub)findViewById(R.h.bWE)).inflate();
      this.vPY = ((Button)this.vPX.findViewById(R.h.bHi));
      this.vPZ = ((Button)this.vPX.findViewById(R.h.bHj));
      this.vQa = this.vPX.findViewById(R.h.bHk);
    }
    GMTrace.o(2447191834624L, 18233);
    return this;
  }
  
  protected final ImageGalleryUI bWK()
  {
    GMTrace.i(2447326052352L, 18234);
    if (this.vQb == null)
    {
      this.vQb = ((ViewStub)findViewById(R.h.cLH)).inflate();
      this.vQc = ((VideoPlayerSeekBar)findViewById(R.h.cLO));
      this.vQc.f(this);
    }
    GMTrace.o(2447326052352L, 18234);
    return this;
  }
  
  protected final void bWS()
  {
    GMTrace.i(2450681495552L, 18259);
    if (this.vQs) {
      this.vQt.v(4000L, 4000L);
    }
    GMTrace.o(2450681495552L, 18259);
  }
  
  public final void bWT()
  {
    GMTrace.i(2450815713280L, 18260);
    v.i("MicroMsg.ImageGalleryUI", "show video tool bar");
    eu(true);
    lq(true);
    L(this.vPX, 8);
    L(bWK().vQb, 0);
    L(this.vPT, 0);
    bWL().vPU.clearAnimation();
    if (this.vPR) {
      bWQ();
    }
    for (;;)
    {
      bXd();
      this.vQs = true;
      bWS();
      GMTrace.o(2450815713280L, 18260);
      return;
      bWP();
    }
  }
  
  public final void bWU()
  {
    GMTrace.i(2450949931008L, 18261);
    v.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
    lq(false);
    L(bWK().vQb, 8);
    L(this.vPT, 8);
    if (bWR())
    {
      bXd();
      bWQ();
    }
    this.vQs = false;
    GMTrace.o(2450949931008L, 18261);
  }
  
  public final int bWV()
  {
    GMTrace.i(15334106988544L, 114248);
    int i = this.mfB.ys;
    GMTrace.o(15334106988544L, 114248);
    return i;
  }
  
  public final boolean bWW()
  {
    GMTrace.i(2452023672832L, 18269);
    boolean bool = bWK().vQc.fKu;
    GMTrace.o(2452023672832L, 18269);
    return bool;
  }
  
  final void bWX()
  {
    GMTrace.i(2452426326016L, 18272);
    if ((bWL().vPU == null) || (this.vQy))
    {
      GMTrace.o(2452426326016L, 18272);
      return;
    }
    if (this.vPU.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.ImageGalleryUI", "fadeOutEnterGirdBtn: %B", new Object[] { Boolean.valueOf(bool) });
      Animation localAnimation = BA(300);
      localAnimation.setFillAfter(false);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          GMTrace.i(2462090002432L, 18344);
          ImageGalleryUI.E(ImageGalleryUI.this);
          ImageGalleryUI.F(ImageGalleryUI.this);
          GMTrace.o(2462090002432L, 18344);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
          GMTrace.i(2462224220160L, 18345);
          GMTrace.o(2462224220160L, 18345);
        }
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          GMTrace.i(2461955784704L, 18343);
          GMTrace.o(2461955784704L, 18343);
        }
      });
      bWL().vPU.startAnimation(localAnimation);
      this.vQy = true;
      GMTrace.o(2452426326016L, 18272);
      return;
    }
  }
  
  final void bWY()
  {
    GMTrace.i(2452560543744L, 18273);
    if ((bWL().vPW == null) || (this.vQz))
    {
      GMTrace.o(2452560543744L, 18273);
      return;
    }
    bWL().vPW.startAnimation(BA(300));
    this.vQz = true;
    GMTrace.o(2452560543744L, 18273);
  }
  
  protected final void bXc()
  {
    GMTrace.i(2453365850112L, 18279);
    if ((dv(this.vPX) == 0) && (dv(this.vPY) == 0)) {}
    for (int i = 1; (i != 0) || (this.vNV == null); i = 0)
    {
      GMTrace.o(2453365850112L, 18279);
      return;
    }
    v.d("MicroMsg.ImageGalleryUI", "jacks start Hide Timer");
    this.vQx.v(4000L, 4000L);
    GMTrace.o(2453365850112L, 18279);
  }
  
  public final void bk(au paramau)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        GMTrace.i(2451352584192L, 18264);
        this.vPO = b.aX(paramau);
        v.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.vPO);
        if ((g.a.vPK.vPI) && (this.vQo != null)) {
          this.vQo.setChecked(g.a.vPK.bj(paramau));
        }
        switch (11.vOl[this.vPO.ordinal()])
        {
        case 1: 
          GMTrace.o(2451352584192L, 18264);
          label129:
          return;
        }
      }
      finally {}
      bWU();
      L(this.vPX, 8);
      lr(true);
      paramau = i.bl(paramau);
      if (paramau == null)
      {
        GMTrace.o(2451352584192L, 18264);
      }
      else
      {
        bWK().vQc.sD(paramau.hZV);
        i = j;
      }
      try
      {
        if (this.vNV.bWB() != null)
        {
          i = j;
          if (this.vNV.bWB().vRm != null) {
            i = this.vNV.bWB().vRm.getCurrentPosition() / 1000;
          }
        }
      }
      catch (Exception paramau)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.ImageGalleryUI", paramau, "", new Object[0]);
          i = j;
        }
      }
      bWK().vQc.seek(i);
      GMTrace.o(2451352584192L, 18264);
    }
    com.tencent.mm.ah.d locald = this.vNV.e(paramau, false);
    bWU();
    bWO();
    int i = this.mfB.ys;
    if ((d(paramau, locald)) && (!paramau.bMj()) && (locald.GB()))
    {
      bWJ().vPY.setVisibility(0);
      bWJ().vPZ.setVisibility(8);
      bWJ().vQa.setVisibility(8);
      String str = (String)this.vQu.get(Long.valueOf(locald.hEG));
      localObject2 = str;
      if (str == null)
      {
        localObject2 = bg.q(locald.hER, "msg");
        if (localObject2 == null)
        {
          v.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[] { locald.hER });
          i = -1;
          break label895;
          label442:
          this.vQu.put(Long.valueOf(locald.hEG), localObject2);
        }
      }
      else
      {
        bWJ().vPY.setText(getString(R.l.eaS, new Object[] { localObject2 }));
        L(this.vPX, 0);
      }
    }
    for (;;)
    {
      if ((!this.vQg) || (locald == null) || (!locald.GB()) || (this.vNV.bWA() == null) || (paramau.field_msgId != this.vNV.bWA().field_msgId)) {
        break label730;
      }
      v.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[] { Long.valueOf(paramau.field_msgId) });
      bXg();
      this.vQg = false;
      GMTrace.o(2451352584192L, 18264);
      break;
      i = bf.getInt((String)((Map)localObject2).get(".msg.img.$hdlength"), 0);
      break label895;
      label607:
      Object localObject1;
      localObject2 = new BigDecimal(localObject1);
      float f = ((BigDecimal)localObject2).divide(new BigDecimal(1048576), 2, 0).floatValue();
      if (f > 1.0F)
      {
        localObject2 = (int)f + "M";
        break label442;
      }
      f = ((BigDecimal)localObject2).divide(new BigDecimal(1024), 2, 0).floatValue();
      localObject2 = (int)f + "K";
      break label442;
      L(this.vPX, 8);
    }
    label730:
    boolean bool = this.vQg;
    long l = paramau.field_msgId;
    if (this.vNV.bWA() == null)
    {
      paramau = "null";
      label756:
      if (locald == null) {
        break label914;
      }
    }
    label895:
    label914:
    for (Object localObject2 = Boolean.valueOf(locald.GB());; localObject2 = "")
    {
      v.w("MicroMsg.ImageGalleryUI", "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), paramau, localObject2 });
      GMTrace.o(2451352584192L, 18264);
      break label129;
      paramau = Long.valueOf(this.vNV.bWA().field_msgId);
      break label756;
      bWU();
      bWO();
      GMTrace.o(2451352584192L, 18264);
      break label129;
      bWU();
      bWO();
      L(this.vPX, 8);
      this.vNV.Bq(this.mfB.ys);
      break;
      break;
      l = i;
      if (l >= 0L) {
        break label607;
      }
      localObject2 = "";
      break label442;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    GMTrace.i(2452292108288L, 18271);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      if (this.qrH != null)
      {
        this.qrH.bza();
        this.qrH = null;
      }
      for (;;)
      {
        GMTrace.o(2452292108288L, 18271);
        return true;
        lp(true);
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    GMTrace.o(2452292108288L, 18271);
    return bool;
  }
  
  public final int eS(long paramLong)
  {
    GMTrace.i(2454036938752L, 18284);
    if (bf.mA(this.vQl))
    {
      GMTrace.o(2454036938752L, 18284);
      return 0;
    }
    try
    {
      int j = t.e(paramLong, this.vQl);
      int i = j;
      if (j == -1)
      {
        this.vQl = null;
        i = 0;
      }
      v.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[] { Integer.valueOf(i), this.vQl });
      GMTrace.o(2454036938752L, 18284);
      return i;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + localException.toString());
      GMTrace.o(2454036938752L, 18284);
    }
    return 0;
  }
  
  public final void eT(long paramLong)
  {
    GMTrace.i(2454171156480L, 18285);
    if ((bf.mA(this.vQl)) || (paramLong == 0L))
    {
      GMTrace.o(2454171156480L, 18285);
      return;
    }
    if (t.e(paramLong, this.vQl) == -1)
    {
      this.vQl = null;
      v.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.vQl });
    }
    GMTrace.o(2454171156480L, 18285);
  }
  
  public final void eu(boolean paramBoolean)
  {
    int i = 8;
    GMTrace.i(2449473536000L, 18250);
    if (((paramBoolean) && (this.vPP.getVisibility() == 0)) || ((!paramBoolean) && (this.vPP.getVisibility() == 8)))
    {
      GMTrace.o(2449473536000L, 18250);
      return;
    }
    Object localObject = this.vPP;
    if (paramBoolean) {
      i = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    localObject = this.uRf.uRz;
    if (paramBoolean) {}
    for (i = R.a.aQJ;; i = R.a.aQK)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      this.vPP.startAnimation((Animation)localObject);
      GMTrace.o(2449473536000L, 18250);
      return;
    }
  }
  
  public void finish()
  {
    GMTrace.i(2453902721024L, 18283);
    this.vJf.clear();
    super.finish();
    GMTrace.o(2453902721024L, 18283);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2449607753728L, 18251);
    int i = R.i.dfw;
    GMTrace.o(2449607753728L, 18251);
    return i;
  }
  
  protected final void lp(boolean paramBoolean)
  {
    GMTrace.i(2449339318272L, 18249);
    if (this.vNV == null)
    {
      GMTrace.o(2449339318272L, 18249);
      return;
    }
    if (this.vQq < 0)
    {
      GMTrace.o(2449339318272L, 18249);
      return;
    }
    Object localObject2 = this.vNV.Bh(this.vQq);
    int i = this.vNV.vOb.bf((au)localObject2);
    if ((i == 5) || (i == 6))
    {
      v.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
      GMTrace.o(2449339318272L, 18249);
      return;
    }
    if (this.vNV.aW((au)localObject2))
    {
      v.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
      GMTrace.o(2449339318272L, 18249);
      return;
    }
    if ((b.aS((au)localObject2)) && (i.bl((au)localObject2) == null))
    {
      v.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
      GMTrace.o(2449339318272L, 18249);
      return;
    }
    final Object localObject3 = new ArrayList();
    final ArrayList localArrayList = new ArrayList();
    ((List)localObject3).add(Integer.valueOf(0));
    localArrayList.add(getString(R.l.eLD));
    if (com.tencent.mm.bb.d.Jr("favorite"))
    {
      ((List)localObject3).add(Integer.valueOf(2));
      localArrayList.add(getString(R.l.eFS));
    }
    if ((b.aR((au)localObject2)) || (b.aV((au)localObject2)))
    {
      ((List)localObject3).add(Integer.valueOf(1));
      localArrayList.add(getString(R.l.eOc));
      if ((b.aR((au)localObject2)) || (b.aT((au)localObject2)))
      {
        localObject1 = new dd();
        ((dd)localObject1).fGN.fGD = ((ce)localObject2).field_msgId;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
        if ((((dd)localObject1).fGO.fGl) || (com.tencent.mm.pluginsdk.model.app.g.L(this.uRf.uRz, ((ce)localObject2).field_type)))
        {
          ((List)localObject3).add(Integer.valueOf(4));
          localArrayList.add(getString(R.l.dUm));
        }
      }
      if (b.aR((au)localObject2))
      {
        ((List)localObject3).add(Integer.valueOf(6));
        localArrayList.add(getString(R.l.dTF));
      }
      if ((this.qrL != null) && (!this.vQk))
      {
        ((List)localObject3).add(Integer.valueOf(3));
        if (!com.tencent.mm.plugin.scanner.a.aj(this.mmc, this.qrL)) {
          break label804;
        }
        localObject1 = getString(R.l.eIt);
        label472:
        localArrayList.add(localObject1);
      }
      if ((!this.vzI) && (!this.sLe) && (!g.a.vPK.vPI) && (!this.vQk))
      {
        ((List)localObject3).add(Integer.valueOf(5));
        localArrayList.add(getString(R.l.dTE));
      }
      if ((this.qrH == null) || (!this.qrM)) {
        break label815;
      }
      this.qrM = false;
      label557:
      this.qrH.qHD = new n.c()
      {
        public final void a(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          GMTrace.i(2462761091072L, 18349);
          paramAnonymousl.clear();
          int i = 0;
          while (i < localObject3.size())
          {
            paramAnonymousl.e(((Integer)localObject3.get(i)).intValue(), (CharSequence)localArrayList.get(i));
            i += 1;
          }
          GMTrace.o(2462761091072L, 18349);
        }
      };
      this.qrH.qHE = this.kRo;
      this.qrH.byZ();
      this.qrH.wsV = new e.a()
      {
        public final void onDismiss()
        {
          GMTrace.i(14655636373504L, 109193);
          ak localak = new ak();
          localak.fDC.filePath = ImageGalleryUI.b(ImageGalleryUI.this);
          com.tencent.mm.sdk.b.a.uql.m(localak);
          ImageGalleryUI.v(ImageGalleryUI.this);
          ImageGalleryUI.e(ImageGalleryUI.this);
          ImageGalleryUI.a(ImageGalleryUI.this, null);
          ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.b(ImageGalleryUI.this, 0));
          GMTrace.o(14655636373504L, 109193);
        }
      };
      if (((b.aR((au)localObject2)) || (b.aV((au)localObject2))) && (true == paramBoolean) && (ap.vd().BR() != 0) && (!this.vQk))
      {
        localObject1 = null;
        if (!b.aR((au)localObject2)) {
          break label840;
        }
        localObject3 = this.vNV.e((au)localObject2, true);
        if (localObject3 == null) {}
      }
    }
    label804:
    label815:
    label840:
    for (Object localObject1 = d.a((au)localObject2, (com.tencent.mm.ah.d)localObject3, false);; localObject1 = b.bb((au)localObject2))
    {
      if (localObject1 != null)
      {
        localObject2 = new lw();
        ((lw)localObject2).fSR.filePath = ((String)localObject1);
        this.qrI = ((String)localObject1);
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
      }
      GMTrace.o(2449339318272L, 18249);
      return;
      if ((b.aS((au)localObject2)) || (b.aT((au)localObject2)))
      {
        ((List)localObject3).add(Integer.valueOf(1));
        localArrayList.add(getString(R.l.eOf));
        break;
      }
      ((List)localObject3).add(Integer.valueOf(1));
      localArrayList.add(getString(R.l.eOe));
      break;
      localObject1 = getString(R.l.eIs);
      break label472;
      this.qrH = new com.tencent.mm.ui.widget.e(this.uRf.uRz, com.tencent.mm.ui.widget.e.wsK, false);
      break label557;
    }
  }
  
  public final void lr(boolean paramBoolean)
  {
    GMTrace.i(2451889455104L, 18268);
    try
    {
      VideoPlayerSeekBar localVideoPlayerSeekBar = bWK().vQc;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localVideoPlayerSeekBar.bX(paramBoolean);
        GMTrace.o(2451889455104L, 18268);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + localException.toString());
      GMTrace.o(2451889455104L, 18268);
    }
  }
  
  public final boolean oQ()
  {
    GMTrace.i(2453231632384L, 18278);
    bWX();
    bWY();
    GMTrace.o(2453231632384L, 18278);
    return false;
  }
  
  public void onBackPressed()
  {
    GMTrace.i(2448668229632L, 18244);
    v.i("MicroMsg.ImageGalleryUI", "onBackPressed");
    if (this.vQi)
    {
      By(1);
      GMTrace.o(2448668229632L, 18244);
      return;
    }
    try
    {
      g.a.vPK.detach();
      aht();
      GMTrace.o(2448668229632L, 18244);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.ImageGalleryUI", localException.getMessage());
      GMTrace.o(2448668229632L, 18244);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    GMTrace.i(2451755237376L, 18267);
    if (this.vNV == null)
    {
      GMTrace.o(2451755237376L, 18267);
      return;
    }
    if (paramView.getId() == R.h.bVo)
    {
      By(0);
      GMTrace.o(2451755237376L, 18267);
      return;
    }
    if (paramView.getId() == R.h.bJQ)
    {
      v.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[] { Integer.valueOf(this.mfB.ys) });
      L(bWM().vPV, 8);
      paramView = this.vNV.Bh(this.mfB.ys);
      com.tencent.mm.ah.d locald = this.vNV.e(paramView, false);
      int i = this.mfB.ys;
      if ((d(paramView, locald)) && (!paramView.bMj()) && (locald.GB()))
      {
        this.vNV.al(this.mfB.ys, true);
        GMTrace.o(2451755237376L, 18267);
        return;
      }
      b.b(this.uRf.uRz, this.vNV.bWA(), true);
      GMTrace.o(2451755237376L, 18267);
      return;
    }
    if (paramView.getId() == R.h.bHi)
    {
      this.vNV.al(this.mfB.ys, false);
      GMTrace.o(2451755237376L, 18267);
      return;
    }
    if (paramView.getId() == R.h.bHj)
    {
      this.vNV.Bp(this.mfB.ys);
      Bx(this.mfB.ys);
      bWZ();
      bXa();
      bXc();
      GMTrace.o(2451755237376L, 18267);
      return;
    }
    if (paramView.getId() == R.h.bnd)
    {
      onBackPressed();
      GMTrace.o(2451755237376L, 18267);
      return;
    }
    if (paramView.getId() == R.h.cLw)
    {
      onBackPressed();
      GMTrace.o(2451755237376L, 18267);
      return;
    }
    if (paramView.getId() == R.h.cjj)
    {
      boolean bool2 = this.vQo.isChecked();
      if ((!bool2) && (g.a.vPK.vOh.size() >= 9))
      {
        Toast.makeText(this, getResources().getString(R.l.enO, new Object[] { Integer.valueOf(9) }), 1).show();
        GMTrace.o(2451755237376L, 18267);
        return;
      }
      paramView = this.vQo;
      if (!bool2) {}
      for (;;)
      {
        paramView.setChecked(bool1);
        if (!this.vQo.isChecked()) {
          break;
        }
        g.a.vPK.bh(this.vNV.bWA());
        GMTrace.o(2451755237376L, 18267);
        return;
        bool1 = false;
      }
      g.a.vPK.bi(this.vNV.bWA());
      GMTrace.o(2451755237376L, 18267);
      return;
    }
    if (paramView.getId() == R.h.crB) {
      this.vNV.Bm(this.mfB.ys);
    }
    GMTrace.o(2451755237376L, 18267);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(2454305374208L, 18286);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      v.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      bXe();
      GMTrace.o(2454305374208L, 18286);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      v.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      bXf();
      GMTrace.o(2454305374208L, 18286);
      return;
    }
    GMTrace.o(2454305374208L, 18286);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2448131358720L, 18240);
    requestWindowFeature(1);
    long l = System.currentTimeMillis();
    this.svZ = true;
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.eo(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (this.nyM = true;; this.nyM = false)
    {
      KD();
      this.kjW = paramBundle;
      com.tencent.mm.sdk.b.a.uql.b(this.lFy);
      com.tencent.mm.sdk.b.a.uql.b(this.qrO);
      this.vPS = false;
      v.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      GMTrace.o(2448131358720L, 18240);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2448534011904L, 18243);
    v.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", new Object[] { Integer.valueOf(hashCode()) });
    if (this.vNV != null)
    {
      this.vNV.detach();
      this.vNV = null;
    }
    bXd();
    this.vQt.KI();
    com.tencent.mm.sdk.b.a.uql.c(this.lFy);
    com.tencent.mm.sdk.b.a.uql.c(this.qrO);
    if (this.vQc != null) {
      this.vQc.f(null);
    }
    this.vQc = null;
    super.onDestroy();
    GMTrace.o(2448534011904L, 18243);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2453768503296L, 18282);
    if (paramInt == 82)
    {
      GMTrace.o(2453768503296L, 18282);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2453768503296L, 18282);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(2447057616896L, 18232);
    v.i("MicroMsg.ImageGalleryUI", "on pause");
    super.onPause();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    Object localObject;
    if ((!isFinishing()) && (this.vNV != null))
    {
      localObject = this.vNV;
      ((b)localObject).vOc.vQQ.sendEmptyMessageAtTime(1, 200L);
      ((b)localObject).vOd.bWI();
    }
    if (this.qrL != null)
    {
      localObject = new aj();
      ((aj)localObject).fDA.activity = this;
      ((aj)localObject).fDA.fDB = this.qrL;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      this.qrL = null;
      this.mmd = 0;
      this.mmc = 0;
    }
    GMTrace.o(2447057616896L, 18232);
  }
  
  protected void onResume()
  {
    GMTrace.i(2448265576448L, 18241);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    if ((!this.svZ) && (this.vNV != null)) {
      Bx(this.mfB.ys);
    }
    this.svZ = false;
    if (this.vNV != null) {
      this.vNV.bWC();
    }
    GMTrace.o(2448265576448L, 18241);
  }
  
  public void onStart()
  {
    GMTrace.i(2448399794176L, 18242);
    this.vQj = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    if (!this.vPR)
    {
      Bundle localBundle = this.kjW;
      if (!this.kjX)
      {
        this.kjX = true;
        if (Build.VERSION.SDK_INT >= 12)
        {
          this.kjZ = getIntent().getIntExtra("img_gallery_top", 0);
          this.kka = getIntent().getIntExtra("img_gallery_left", 0);
          this.kkb = getIntent().getIntExtra("img_gallery_width", 0);
          this.kkc = getIntent().getIntExtra("img_gallery_height", 0);
          if ((this.kjZ == 0) && (this.kka == 0) && (this.kkb == 0) && (this.kkc == 0))
          {
            au localau = this.vNV.Bh(this.mfB.ys);
            if (localau != null)
            {
              aq localaq = new aq();
              localaq.fDQ.fCQ = localau;
              com.tencent.mm.sdk.b.a.uql.m(localaq);
              this.kkb = localaq.fDR.fDU;
              this.kkc = localaq.fDR.fDV;
              this.kka = localaq.fDR.fDS;
              this.kjZ = localaq.fDR.fDT;
            }
          }
          this.kjY.p(this.kka, this.kjZ, this.kkb, this.kkc);
          if (localBundle == null) {
            this.mfB.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              public final boolean onPreDraw()
              {
                GMTrace.i(2462492655616L, 18347);
                ImageGalleryUI.this.mfB.getViewTreeObserver().removeOnPreDrawListener(this);
                ImageGalleryUI.this.qxG = ImageGalleryUI.this.mfB.getWidth();
                ImageGalleryUI.this.qxH = ImageGalleryUI.this.mfB.getHeight();
                if (ImageGalleryUI.f(ImageGalleryUI.this).bWA().bMc()) {
                  ImageGalleryUI.this.qxH = ((int)(ImageGalleryUI.this.qxG / ImageGalleryUI.this.kkb * ImageGalleryUI.this.kkc));
                }
                if (ImageGalleryUI.f(ImageGalleryUI.this).bWA().bLX()) {
                  ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.f(ImageGalleryUI.this).ng(ImageGalleryUI.this.mfB.ys));
                }
                if (ImageGalleryUI.l(ImageGalleryUI.this) != null)
                {
                  ImageGalleryUI.this.qxH = ((int)(ImageGalleryUI.this.qxG / ImageGalleryUI.l(ImageGalleryUI.this).imageWidth * ImageGalleryUI.l(ImageGalleryUI.this).imageHeight));
                  if (ImageGalleryUI.this.qxH > ImageGalleryUI.this.mfB.getHeight()) {
                    ImageGalleryUI.this.qxH = ImageGalleryUI.this.mfB.getHeight();
                  }
                }
                ImageGalleryUI.this.kjY.ek(ImageGalleryUI.this.qxG, ImageGalleryUI.this.qxH);
                if (!ImageGalleryUI.this.vQj)
                {
                  ImageGalleryUI.m(ImageGalleryUI.this);
                  ImageGalleryUI.n(ImageGalleryUI.this);
                  ImageGalleryUI.this.kjY.a(ImageGalleryUI.this.mfB, ImageGalleryUI.o(ImageGalleryUI.this), new g.b()
                  {
                    public final void onAnimationEnd()
                    {
                      GMTrace.i(2471082590208L, 18411);
                      ImageGalleryUI.p(ImageGalleryUI.this).post(new Runnable()
                      {
                        public final void run()
                        {
                          GMTrace.i(2434575368192L, 18139);
                          if (ImageGalleryUI.this.vQm != null) {
                            ImageGalleryUI.this.vQm.i(Boolean.valueOf(false));
                          }
                          GMTrace.o(2434575368192L, 18139);
                        }
                      });
                      GMTrace.o(2471082590208L, 18411);
                    }
                    
                    public final void onAnimationStart()
                    {
                      GMTrace.i(2470948372480L, 18410);
                      if (ImageGalleryUI.this.vQm != null) {
                        ImageGalleryUI.this.vQm.i(Boolean.valueOf(true));
                      }
                      GMTrace.o(2470948372480L, 18410);
                    }
                  });
                }
                ImageGalleryUI.q(ImageGalleryUI.this);
                GMTrace.o(2462492655616L, 18347);
                return true;
              }
            });
          }
        }
      }
    }
    super.onStart();
    GMTrace.o(2448399794176L, 18242);
  }
  
  public static abstract interface a
  {
    public abstract void i(Boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/ImageGalleryUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */