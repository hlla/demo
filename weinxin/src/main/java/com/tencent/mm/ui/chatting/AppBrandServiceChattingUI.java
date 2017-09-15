package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.p;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.a.kd;
import com.tencent.mm.e.a.kj;
import com.tencent.mm.e.a.mt;
import com.tencent.mm.e.a.n.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.d.c.4;
import com.tencent.mm.ui.d.c.a;
import com.tencent.mm.ui.o;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class AppBrandServiceChattingUI
  extends MMFragmentActivity
{
  public com.tencent.mm.ui.q vvZ;
  public ad vwa;
  
  public AppBrandServiceChattingUI()
  {
    GMTrace.i(2496718176256L, 18602);
    this.vwa = new ad();
    GMTrace.o(2496718176256L, 18602);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    GMTrace.i(2496986611712L, 18604);
    v.d("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingUI dispatch key event %s", new Object[] { paramKeyEvent });
    if ((this.vvZ != null) && (this.vvZ.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      GMTrace.o(2496986611712L, 18604);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    GMTrace.o(2496986611712L, 18604);
    return bool;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2496852393984L, 18603);
    getWindow().setFormat(-2);
    e.R(this);
    overridePendingTransition(0, 0);
    super.onCreate(null);
    if (getIntent().getStringExtra("Chat_User") == null)
    {
      finish();
      v.e("MicroMsg.AppBrandServiceChattingUI", "talker is null !!!");
      GMTrace.o(2496852393984L, 18603);
      return;
    }
    setContentView(R.i.cYF);
    this.vvZ = new a((byte)0);
    paramBundle = getIntent().getExtras();
    paramBundle.putBoolean("FROM_APP_BRAND_CHATTING_ACTIVITY", true);
    this.vvZ.setArguments(paramBundle);
    aR().aV().a(R.h.ckg, this.vvZ).commit();
    cO().cP().show();
    if (getIntent().getBooleanExtra("resend_fail_messages", false))
    {
      com.tencent.mm.sdk.platformtools.ae.f(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2176743112704L, 16218);
          com.tencent.mm.ui.base.g.b(AppBrandServiceChattingUI.this, AppBrandServiceChattingUI.this.getString(R.l.eEj), "", AppBrandServiceChattingUI.this.getString(R.l.eEk), AppBrandServiceChattingUI.this.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(2497523482624L, 18608);
              paramAnonymous2DialogInterface = new mt();
              com.tencent.mm.sdk.b.a.uql.m(paramAnonymous2DialogInterface);
              GMTrace.o(2497523482624L, 18608);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(2298478592000L, 17125);
              paramAnonymous2DialogInterface = new kd();
              com.tencent.mm.sdk.b.a.uql.m(paramAnonymous2DialogInterface);
              GMTrace.o(2298478592000L, 17125);
            }
          });
          GMTrace.o(2176743112704L, 16218);
        }
      }, 500L);
      getIntent().putExtra("is_need_resend_sns", false);
    }
    com.tencent.mm.permission.a.Ni().Nj();
    bQd();
    this.vwa.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2280761851904L, 16993);
        if (AppBrandServiceChattingUI.this.vvZ != null) {
          e.a(AppBrandServiceChattingUI.this, AppBrandServiceChattingUI.this.vvZ.uRf.uRl);
        }
        GMTrace.o(2280761851904L, 16993);
      }
    });
    GMTrace.o(2496852393984L, 18603);
  }
  
  @SuppressLint({"ValidFragment"})
  public static final class a
    extends En_5b8fbb1e.a
  {
    public String appId;
    public int fromScene;
    private String iRq;
    private String iRr;
    private String iRs;
    private boolean iRt;
    private int iRu;
    public WxaExposedParams jhY;
    public String jkM;
    public View.OnCreateContextMenuListener oJh;
    public boolean vwd;
    private String vwe;
    private com.tencent.mm.sdk.b.c<kj> vwf;
    private com.tencent.mm.ui.d.c vwg;
    public com.tencent.mm.ui.d.a vwh;
    
    public a()
    {
      GMTrace.i(2292304576512L, 17079);
      this.vwe = "";
      GMTrace.o(2292304576512L, 17079);
    }
    
    public a(byte paramByte)
    {
      super();
      GMTrace.i(2292438794240L, 17080);
      this.vwe = "";
      GMTrace.o(2292438794240L, 17080);
    }
    
    private float xD(int paramInt)
    {
      GMTrace.i(17901289472000L, 133375);
      float f = TypedValue.applyDimension(1, paramInt, this.uRf.uRz.getResources().getDisplayMetrics());
      GMTrace.o(17901289472000L, 133375);
      return f;
    }
    
    public final void bTt()
    {
      GMTrace.i(2292841447424L, 17083);
      super.bTt();
      this.nvG.bFg();
      this.nvG.bFo();
      this.nvG.bFA();
      this.nvG.bFD();
      this.nvG.bFt();
      this.nvG.bFp();
      this.nvG.bFr();
      this.nvG.bFs();
      this.nvG.bFq();
      this.nvG.bFt();
      this.nvG.bFp();
      this.nvG.bFC();
      this.nvG.anI();
      this.nvG.bFu();
      this.nvG.bFv();
      this.nvG.jA(true);
      this.nvG.jB(true);
      this.nvG.bFw();
      this.nvG.bFx();
      this.nvG.bFy();
      this.nvG.bFs();
      this.nvG.bFz();
      this.nvG.jz(com.tencent.mm.bb.d.bGH());
      Object localObject = ((com.tencent.mm.plugin.appbrand.i.b)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(this.fOB.field_username);
      boolean bool;
      label231:
      label249:
      String str;
      int i;
      com.tencent.mm.storage.ae localae;
      if ((localObject != null) && ((((WxaAttributes)localObject).field_appOpt & 0x2) > 0))
      {
        bool = true;
        this.vwd = bool;
        if (localObject != null) {
          break label347;
        }
        localObject = null;
        this.appId = ((String)localObject);
        if (!this.vwd) {
          break label357;
        }
        AS(0);
        if (this.fromScene == 2)
        {
          localObject = this.appId;
          str = this.fOB.field_username;
          i = this.fromScene;
          ap.yY();
          localae = com.tencent.mm.u.c.wW().Rl(str);
          if (localae != null) {
            break label366;
          }
          v.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", new Object[] { str });
        }
      }
      for (;;)
      {
        this.vwh = new com.tencent.mm.ui.d.a(this.uRf.uRz);
        GMTrace.o(2292841447424L, 17083);
        return;
        bool = false;
        break;
        label347:
        localObject = ((WxaAttributes)localObject).field_appId;
        break label231;
        label357:
        AS(8);
        break label249;
        label366:
        int j = localae.field_unReadCount;
        str = bf.mz(this.jkM);
        v.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), localObject, Integer.valueOf(i), Integer.valueOf(j), str });
        com.tencent.mm.plugin.report.service.g.oSF.i(13799, new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(j), str, Long.valueOf(bf.Nz()) });
      }
    }
    
    protected final void bTu()
    {
      GMTrace.i(2292975665152L, 17084);
      super.bTu();
      ze(R.l.dFR);
      if (TextUtils.isEmpty(this.vwe)) {
        this.vwe = com.tencent.mm.ui.d.b.SS(com.tencent.mm.ui.d.b.SR(this.fOB.field_username));
      }
      if (TextUtils.isEmpty(this.vwe))
      {
        ze(R.l.dFR);
        GMTrace.o(2292975665152L, 17084);
        return;
      }
      SD(getResources().getString(R.l.dFR) + "-" + this.vwe);
      GMTrace.o(2292975665152L, 17084);
    }
    
    protected final void bTv()
    {
      GMTrace.i(2293109882880L, 17085);
      qL(this.fOB.field_nickname);
      if (this.vwd)
      {
        AS(0);
        GMTrace.o(2293109882880L, 17085);
        return;
      }
      AS(8);
      GMTrace.o(2293109882880L, 17085);
    }
    
    protected final void bTw()
    {
      GMTrace.i(2293244100608L, 17086);
      a(0, R.l.dEP, R.g.bha, new o()
      {
        public final void bsL()
        {
          GMTrace.i(2270427086848L, 16916);
          boolean bool = AppBrandServiceChattingUI.a.this.aqY();
          Runnable local1 = new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2372164124672L, 17674);
              String str1 = com.tencent.mm.ui.d.b.SR(AppBrandServiceChattingUI.a.this.fOB.field_username);
              if (TextUtils.isEmpty(str1)) {
                str1 = AppBrandServiceChattingUI.a.this.fOB.field_username;
              }
              for (String str2 = AppBrandServiceChattingUI.a.this.fOB.field_nickname;; str2 = com.tencent.mm.ui.d.b.SS(str1))
              {
                AppBrandServiceChattingUI.a.this.vwh.username = AppBrandServiceChattingUI.a.this.fOB.field_username;
                AppBrandServiceChattingUI.a.this.vwh.vcZ = false;
                AppBrandServiceChattingUI.a.this.vwh.scene = AppBrandServiceChattingUI.a.this.fromScene;
                AppBrandServiceChattingUI.a.this.vwh.vcY = AppBrandServiceChattingUI.a.this.jkM;
                if (AppBrandServiceChattingUI.a.this.fromScene != 2) {
                  break label253;
                }
                AppBrandServiceChattingUI.a.this.vwh.jhY = AppBrandServiceChattingUI.a.this.jhY;
                if (!AppBrandServiceChattingUI.a.this.vwd) {
                  break;
                }
                AppBrandServiceChattingUI.a.this.vwh.show(1);
                GMTrace.o(2372164124672L, 17674);
                return;
              }
              AppBrandServiceChattingUI.a.this.vwh.show(2);
              GMTrace.o(2372164124672L, 17674);
              return;
              label253:
              WxaExposedParams.a locala = new WxaExposedParams.a();
              locala.appId = AppBrandServiceChattingUI.a.this.appId;
              locala.fFi = 4;
              locala.username = str1;
              locala.fER = str2;
              AppBrandServiceChattingUI.a.this.vwh.jhY = locala.RI();
              AppBrandServiceChattingUI.a.this.vwh.appId = AppBrandServiceChattingUI.a.this.appId;
              if (AppBrandServiceChattingUI.a.this.vwd)
              {
                AppBrandServiceChattingUI.a.this.vwh.show(5);
                GMTrace.o(2372164124672L, 17674);
                return;
              }
              AppBrandServiceChattingUI.a.this.vwh.show(6);
              GMTrace.o(2372164124672L, 17674);
            }
          };
          if (bool) {}
          for (int i = 100;; i = 0)
          {
            com.tencent.mm.sdk.platformtools.ae.f(local1, i);
            GMTrace.o(2270427086848L, 16916);
            return;
          }
        }
      });
      kp(true);
      GMTrace.o(2293244100608L, 17086);
    }
    
    protected final void bTx()
    {
      GMTrace.i(2293378318336L, 17087);
      super.bTx();
      this.oJh = new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          GMTrace.i(2500207837184L, 18628);
          v.d("MicroMsg.AppBrandServiceChattingUI", "menuListener onCreateCotextMenuListener");
          if (paramAnonymousView == null)
          {
            GMTrace.o(2500207837184L, 18628);
            return;
          }
          paramAnonymousContextMenuInfo = (ds)paramAnonymousView.getTag();
          if (paramAnonymousContextMenuInfo == null)
          {
            GMTrace.o(2500207837184L, 18628);
            return;
          }
          int k = paramAnonymousContextMenuInfo.position;
          au localau = (au)AppBrandServiceChattingUI.a.this.vzN.getItem(k);
          if (localau == null)
          {
            v.e("MicroMsg.AppBrandServiceChattingUI", "msg is null!");
            GMTrace.o(2500207837184L, 18628);
            return;
          }
          if (localau.bMa())
          {
            paramAnonymousContextMenu.add(k, 102, 0, AppBrandServiceChattingUI.a.this.zo(R.l.dTf));
            paramAnonymousContextMenu.add(k, 108, 0, paramAnonymousView.getContext().getString(R.l.eLz));
            paramAnonymousContextMenu.add(k, 116, 0, paramAnonymousView.getContext().getString(R.l.eFS));
            if (com.tencent.mm.pluginsdk.model.app.g.L(AppBrandServiceChattingUI.a.this.uRf.uRz, localau.field_type)) {
              paramAnonymousContextMenu.add(k, 128, 0, paramAnonymousView.getContext().getString(R.l.dUm));
            }
          }
          if (localau.bLX())
          {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable())
            {
              paramAnonymousContextMenu.add(k, 110, 0, paramAnonymousView.getContext().getString(R.l.eLz));
              paramAnonymousContextMenu.add(k, 116, 0, paramAnonymousView.getContext().getString(R.l.eFS));
              paramAnonymousContextMenuInfo = new dd();
              paramAnonymousContextMenuInfo.fGN.fGD = localau.field_msgId;
              com.tencent.mm.sdk.b.a.uql.m(paramAnonymousContextMenuInfo);
              if ((paramAnonymousContextMenuInfo.fGO.fGl) || (com.tencent.mm.pluginsdk.model.app.g.L(AppBrandServiceChattingUI.a.this.uRf.uRz, localau.field_type))) {
                paramAnonymousContextMenu.add(k, 128, 0, paramAnonymousView.getContext().getString(R.l.dUm));
              }
              paramAnonymousContextMenuInfo = null;
              if (localau.field_msgId > 0L) {
                paramAnonymousContextMenuInfo = com.tencent.mm.ah.n.GT().aj(localau.field_msgId);
              }
              if ((com.tencent.mm.bb.d.Jr("photoedit")) && (paramAnonymousContextMenuInfo.status != -1))
              {
                paramAnonymousContextMenuInfo = paramAnonymousContextMenu.add(k, 130, 0, paramAnonymousView.getContext().getString(R.l.dTF));
                int j = 0;
                int i = 0;
                int[] arrayOfInt = new int[2];
                if (paramAnonymousView != null)
                {
                  j = paramAnonymousView.getWidth();
                  i = paramAnonymousView.getHeight();
                  paramAnonymousView.getLocationInWindow(arrayOfInt);
                }
                Intent localIntent = new Intent();
                localIntent.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
                paramAnonymousContextMenuInfo.setIntent(localIntent);
              }
            }
          }
          if (localau.axH())
          {
            paramAnonymousContextMenu.add(k, 111, 0, AppBrandServiceChattingUI.a.this.zo(R.l.eLz));
            paramAnonymousContextMenuInfo = localau.field_content;
            if (paramAnonymousContextMenuInfo == null)
            {
              GMTrace.o(2500207837184L, 18628);
              return;
            }
            paramAnonymousContextMenuInfo = f.a.ek(paramAnonymousContextMenuInfo);
            if (paramAnonymousContextMenuInfo == null)
            {
              GMTrace.o(2500207837184L, 18628);
              return;
            }
            if (paramAnonymousContextMenuInfo.type == 5) {
              paramAnonymousContextMenu.add(k, 116, 0, paramAnonymousView.getContext().getString(R.l.eFS));
            }
          }
          paramAnonymousContextMenu.add(k, 100, 0, paramAnonymousView.getContext().getString(R.l.dUh));
          paramAnonymousContextMenu.add(k, 122, 0, AppBrandServiceChattingUI.a.this.zo(R.l.dUk));
          GMTrace.o(2500207837184L, 18628);
        }
      };
      this.vzN.vDb = new cw(this, bTW())
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2238080614400L, 16675);
          v.d("MicroMsg.AppBrandServiceChattingUI", "clickListener ChattingListClickListener onClick");
          Object localObject = (ds)paramAnonymousView.getTag();
          au localau;
          switch (((ds)localObject).klJ)
          {
          case 1: 
          case 9: 
          default: 
            localau = ((ds)localObject).fTa;
            if (localau == null)
            {
              GMTrace.o(2238080614400L, 16675);
              return;
            }
            break;
          case 6: 
            super.onClick(paramAnonymousView);
            GMTrace.o(2238080614400L, 16675);
            return;
          }
          if (localau.bLX())
          {
            super.onClick(paramAnonymousView);
            GMTrace.o(2238080614400L, 16675);
            return;
          }
          if ((((ds)localObject).klJ == 0) && (localau.axH()))
          {
            localObject = localau.field_content;
            if (localObject == null)
            {
              GMTrace.o(2238080614400L, 16675);
              return;
            }
            localObject = f.a.ek((String)localObject);
            if (localObject == null)
            {
              GMTrace.o(2238080614400L, 16675);
              return;
            }
            if ((AppBrandServiceChattingUI.a.this.fromScene == 2) && (((f.a)localObject).type == 33) && (AppBrandServiceChattingUI.a.this.jhY.appId.equals(((f.a)localObject).hjD)))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("keyOutPagePath", ((f.a)localObject).hjB);
              AppBrandServiceChattingUI.a.this.bOZ().setResult(-1, paramAnonymousView);
              AppBrandServiceChattingUI.a.this.finish();
              GMTrace.o(2238080614400L, 16675);
              return;
            }
            super.onClick(paramAnonymousView);
            GMTrace.o(2238080614400L, 16675);
            return;
          }
          if ((((ds)localObject).klJ == 5) && (localau.field_isSend == 1))
          {
            super.onClick(paramAnonymousView);
            GMTrace.o(2238080614400L, 16675);
            return;
          }
          GMTrace.o(2238080614400L, 16675);
        }
      };
      this.vzN.vDd = new cy(this.vzN.oJh, this)
      {
        public int jZe;
        public int jZf;
        public View vwl;
        
        public final boolean onLongClick(View paramAnonymousView)
        {
          GMTrace.i(2143725551616L, 15972);
          v.d("MicroMsg.AppBrandServiceChattingUI", "longClickListener ChattingListClickListener onLongClick");
          Object localObject;
          if ((paramAnonymousView.getTag() instanceof ds))
          {
            localObject = (ds)paramAnonymousView.getTag();
            if (((ds)localObject).klJ == 1)
            {
              GMTrace.o(2143725551616L, 15972);
              return true;
            }
            if (((ds)localObject).klJ == 9)
            {
              GMTrace.o(2143725551616L, 15972);
              return true;
            }
          }
          if ((paramAnonymousView.getTag(R.h.cJn) instanceof int[]))
          {
            localObject = (int[])paramAnonymousView.getTag(R.h.cJn);
            new com.tencent.mm.ui.widget.g(AppBrandServiceChattingUI.a.this.uRf.uRz).a(paramAnonymousView, AppBrandServiceChattingUI.a.this.oJh, AppBrandServiceChattingUI.a.this.nwm, localObject[0], localObject[1]);
          }
          for (;;)
          {
            GMTrace.o(2143725551616L, 15972);
            return true;
            if (((this.jZe == 0) && (this.jZf == 0)) || (!this.vwl.equals(paramAnonymousView))) {
              paramAnonymousView.setOnTouchListener(new View.OnTouchListener()
              {
                public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
                {
                  GMTrace.i(17904376479744L, 133398);
                  AppBrandServiceChattingUI.a.5.this.jZe = ((int)paramAnonymous2MotionEvent.getRawX());
                  AppBrandServiceChattingUI.a.5.this.jZf = ((int)paramAnonymous2MotionEvent.getRawY());
                  AppBrandServiceChattingUI.a.5.this.vwl = paramAnonymous2View;
                  GMTrace.o(17904376479744L, 133398);
                  return false;
                }
              });
            } else {
              new com.tencent.mm.ui.widget.g(AppBrandServiceChattingUI.a.this.uRf.uRz).a(paramAnonymousView, AppBrandServiceChattingUI.a.this.oJh, AppBrandServiceChattingUI.a.this.nwm, this.jZe, this.jZf);
            }
          }
        }
      };
      GMTrace.o(2293378318336L, 17087);
    }
    
    protected final boolean bTy()
    {
      GMTrace.i(2293646753792L, 17089);
      Object localObject;
      if (this.fromScene == 2)
      {
        ap.yY();
        localObject = com.tencent.mm.u.c.wW().Rl("appbrandcustomerservicemsg");
        if ((localObject != null) && (!bf.mA(((aj)localObject).field_username)))
        {
          int i = ((aj)localObject).field_unReadCount;
          com.tencent.mm.e.a.n localn = new com.tencent.mm.e.a.n();
          localn.fCy.fCA = this.fOB.field_username;
          com.tencent.mm.sdk.b.a.uql.m(localn);
          int j = localn.fCz.fCB;
          v.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          ((com.tencent.mm.storage.ae)localObject).dt(Math.max(0, i - j));
          ap.yY();
          if (com.tencent.mm.u.c.wW().a((com.tencent.mm.storage.ae)localObject, ((aj)localObject).field_username) == -1) {
            v.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
          }
        }
      }
      for (;;)
      {
        boolean bool = super.bTy();
        GMTrace.o(2293646753792L, 17089);
        return bool;
        localObject = new com.tencent.mm.e.a.q();
        ((com.tencent.mm.e.a.q)localObject).fCK.fCA = this.fOB.field_username;
        ((com.tencent.mm.e.a.q)localObject).fCK.fCB = 0;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
        continue;
        v.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
        continue;
        v.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", new Object[] { this.fOB.field_username });
        localObject = new com.tencent.mm.e.a.q();
        ((com.tencent.mm.e.a.q)localObject).fCK.fCA = this.fOB.field_username;
        ((com.tencent.mm.e.a.q)localObject).fCK.fCB = 0;
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      }
    }
    
    public final void bTz()
    {
      GMTrace.i(18822023086080L, 140235);
      f.a locala = new f.a();
      locala.title = this.iRq;
      locala.type = 33;
      locala.hjC = this.jhY.username;
      Object localObject1;
      Object localObject2;
      if (bf.mA(this.iRr))
      {
        localObject1 = this.jhY.iFy;
        locala.hjB = ((String)localObject1);
        locala.hjD = this.jhY.appId;
        locala.hjJ = this.jhY.izA;
        locala.hjK = this.jhY.izB;
        locala.hjF = this.jhY.iFx;
        locala.hjE = 2;
        locala.url = this.jhY.iFz;
        locala.hjL = this.jhY.iconUrl;
        locala.fUN = ("wxapp_" + this.jhY.appId + this.jhY.iFy);
        locala.fUH = this.jhY.username;
        locala.fUI = this.jhY.fER;
        localObject2 = new byte[0];
        if (this.iRu != 4) {
          break label317;
        }
        localObject1 = com.tencent.mm.modelappbrand.a.b.AY().gN(this.iRs);
      }
      for (;;)
      {
        label233:
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          v.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
          localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
        }
        for (localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();; localObject1 = localObject2)
        {
          com.tencent.mm.pluginsdk.model.app.l.a(locala, this.appId, this.iRq, this.fOB.field_username, null, (byte[])localObject1);
          GMTrace.o(18822023086080L, 140235);
          return;
          localObject1 = this.iRr;
          break;
          label317:
          if (bf.mA(this.iRs)) {
            break label428;
          }
          Bitmap localBitmap = com.tencent.mm.modelappbrand.a.b.AY().gN(this.iRs);
          if (localBitmap != null)
          {
            localObject1 = localBitmap;
            if (!localBitmap.isRecycled()) {
              break label233;
            }
          }
          localBitmap = com.tencent.mm.sdk.platformtools.d.Pf(this.iRs);
          localObject1 = localBitmap;
          if (this.iRu == 2) {
            break label233;
          }
          boolean bool = com.tencent.mm.loader.stub.b.deleteFile(this.iRs);
          v.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[] { this.iRs, Boolean.valueOf(bool) });
          localObject1 = localBitmap;
          break label233;
          v.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null");
        }
        label428:
        localObject1 = null;
      }
    }
    
    public final void onActivityCreated(Bundle paramBundle)
    {
      GMTrace.i(2292707229696L, 17082);
      super.onActivityCreated(paramBundle);
      if (this.fromScene == 2)
      {
        paramBundle = new k(bTW(), 19, getStringExtra("key_temp_session_from"));
        ap.vd().a(paramBundle, 0);
        v.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
      }
      this.vwf = new com.tencent.mm.sdk.b.c() {};
      com.tencent.mm.sdk.b.a.uql.b(this.vwf);
      GMTrace.o(2292707229696L, 17082);
    }
    
    public final void onCreate(Bundle paramBundle)
    {
      GMTrace.i(2292573011968L, 17081);
      super.onCreate(paramBundle);
      this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
      Object localObject = null;
      paramBundle = (Bundle)localObject;
      if (this.uOa)
      {
        paramBundle = (Bundle)localObject;
        if (bOZ() != null) {
          paramBundle = bOZ().getIntent().getParcelableExtra("app_brand_chatting_expose_params");
        }
      }
      localObject = paramBundle;
      if (paramBundle == null)
      {
        localObject = paramBundle;
        if (this.oW != null) {
          localObject = this.oW.getParcelable("app_brand_chatting_expose_params");
        }
      }
      this.jhY = ((WxaExposedParams)localObject);
      this.jkM = bf.mz(getStringExtra("key_scene_id"));
      this.iRq = getStringExtra("sendMessageTitle");
      this.iRr = getStringExtra("sendMessagePath");
      this.iRs = getStringExtra("sendMessageImg");
      this.iRt = aS("showMessageCard", false).booleanValue();
      this.iRu = getIntExtra("isBitmapFrom", 1);
      v.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
      v.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[] { this.jhY });
      v.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, isBitmapFrom:%d", new Object[] { this.jkM, this.iRq, this.iRr, this.iRs, Boolean.valueOf(this.iRt), Integer.valueOf(this.iRu) });
      GMTrace.o(2292573011968L, 17081);
    }
    
    public final void onDestroy()
    {
      GMTrace.i(2293780971520L, 17090);
      super.onDestroy();
      com.tencent.mm.sdk.b.a.uql.c(this.vwf);
      GMTrace.o(2293780971520L, 17090);
    }
    
    public final void onViewAttachedToWindow(View paramView)
    {
      GMTrace.i(17901155254272L, 133374);
      super.onViewAttachedToWindow(paramView);
      View localView;
      ChatFooter localChatFooter;
      if ((this.fromScene == 2) && (this.iRt)) {
        if (this.vwg == null)
        {
          paramView = aG();
          localView = this.nvG.getRootView();
          localChatFooter = this.nvG;
          if (bf.mA(this.nvG.bFm())) {
            break label255;
          }
        }
      }
      label255:
      for (boolean bool = true;; bool = false)
      {
        this.vwg = new com.tencent.mm.ui.d.c(paramView, localView, localChatFooter, bool);
        this.vwg.sOL = false;
        if (!bf.mA(this.iRs))
        {
          int i = (int)xD(75);
          int j = (int)xD(60);
          if ((this.iRu != 4) && (!this.iRs.startsWith("file://"))) {
            this.iRs = ("file://" + this.iRs);
          }
          com.tencent.mm.modelappbrand.a.b.AY().a(this.vwg, this.iRs, null, ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aL(i, j));
        }
        this.vwg.vdi = new c.a()
        {
          public final void bRo()
          {
            GMTrace.i(17899813076992L, 133364);
            AppBrandServiceChattingUI.a.this.aqY();
            ap.vL().D(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(18822291521536L, 140237);
                AppBrandServiceChattingUI.a.this.bTz();
                GMTrace.o(18822291521536L, 140237);
              }
            });
            GMTrace.o(17899813076992L, 133364);
          }
        };
        paramView = this.vwg;
        v.d("MicroMsg.AppBrandServiceImageBubble", "show");
        ap.vL().D(new c.4(paramView));
        GMTrace.o(17901155254272L, 133374);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/AppBrandServiceChattingUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */