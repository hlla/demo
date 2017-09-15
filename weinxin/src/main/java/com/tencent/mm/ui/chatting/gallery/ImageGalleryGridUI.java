package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView<*>;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cb.a;
import com.tencent.mm.e.a.cb.b;
import com.tencent.mm.e.a.gg;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.kq;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.e.a.mn.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.ab;
import com.tencent.mm.ui.chatting.dx;
import com.tencent.mm.ui.chatting.dx.a;
import com.tencent.mm.ui.chatting.eu;
import com.tencent.mm.ui.chatting.z;
import com.tencent.mm.ui.l;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@com.tencent.mm.ui.base.a(19)
public class ImageGalleryGridUI
  extends MMActivity
  implements MenuItem.OnMenuItemClickListener, View.OnClickListener, ViewTreeObserver.OnPreDrawListener, AdapterView.OnItemClickListener, dx, g.b
{
  private boolean fAx;
  private String fJC;
  protected ad handler;
  public long jZq;
  private TextView meb;
  private Animation puq;
  public boolean sLe;
  private boolean sWq;
  private long vDO;
  private com.tencent.mm.sdk.b.c vHY;
  public int vOP;
  private GridView vOQ;
  c vOR;
  private WeakReference<c.a> vOS;
  private Boolean vOT;
  private Boolean vOU;
  private TextView vOV;
  private Runnable vOW;
  private Runnable vOX;
  private boolean vOY;
  Runnable vOZ;
  public View vPa;
  private View vPb;
  private int vPc;
  private View vPd;
  private View vPe;
  private View vPf;
  private View vPg;
  
  public ImageGalleryGridUI()
  {
    GMTrace.i(2420750942208L, 18036);
    this.vOW = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2433904279552L, 18134);
        if ((ImageGalleryGridUI.a(ImageGalleryGridUI.this) != null) && (ImageGalleryGridUI.a(ImageGalleryGridUI.this).getVisibility() != 4)) {
          ImageGalleryGridUI.a(ImageGalleryGridUI.this).setVisibility(4);
        }
        GMTrace.o(2433904279552L, 18134);
      }
    };
    this.vOX = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2463566397440L, 18355);
        if ((ImageGalleryGridUI.a(ImageGalleryGridUI.this) != null) && (ImageGalleryGridUI.a(ImageGalleryGridUI.this).getVisibility() != 0)) {
          ImageGalleryGridUI.a(ImageGalleryGridUI.this).setVisibility(0);
        }
        GMTrace.o(2463566397440L, 18355);
      }
    };
    this.vHY = new com.tencent.mm.sdk.b.c() {};
    this.vOY = false;
    this.sWq = false;
    this.vDO = 0L;
    this.vOZ = new Runnable()
    {
      @TargetApi(12)
      public final void run()
      {
        GMTrace.i(2409745088512L, 17954);
        if (ImageGalleryGridUI.this.vPa != null)
        {
          ImageGalleryGridUI.this.vPa.setVisibility(8);
          ImageGalleryGridUI.this.vPa = null;
        }
        GMTrace.o(2409745088512L, 17954);
      }
    };
    this.vPa = null;
    this.vPc = -1;
    this.fAx = true;
    GMTrace.o(2420750942208L, 18036);
  }
  
  @TargetApi(11)
  private void Bt(int paramInt)
  {
    GMTrace.i(2421958901760L, 18045);
    Object localObject = getIntent();
    if (((Intent)localObject).getIntExtra("kintent_intent_source", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.vOT = Boolean.valueOf(bool);
      this.fJC = ((Intent)localObject).getStringExtra("kintent_talker");
      this.vOP = ((Intent)localObject).getIntExtra("kintent_image_index", 0);
      this.sLe = ((Intent)localObject).getBooleanExtra("key_is_biz_chat", false);
      this.jZq = getIntent().getLongExtra("key_biz_chat_id", -1L);
      this.vOU = Boolean.valueOf(true);
      qL(getString(R.l.dCR));
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2409476653056L, 17952);
          ImageGalleryGridUI.this.onBackPressed();
          GMTrace.o(2409476653056L, 17952);
          return true;
        }
      });
      this.vPb = findViewById(R.h.ckZ);
      localObject = findViewById(R.h.bNS);
      this.vPd = ((View)localObject);
      ((View)localObject).setOnClickListener(this);
      localObject = findViewById(R.h.cJu);
      this.vPe = ((View)localObject);
      ((View)localObject).setOnClickListener(this);
      localObject = findViewById(R.h.czs);
      this.vPf = ((View)localObject);
      ((View)localObject).setOnClickListener(this);
      localObject = findViewById(R.h.beu);
      this.vPg = ((View)localObject);
      ((View)localObject).setOnClickListener(this);
      this.meb = ((TextView)findViewById(R.h.bok));
      this.vOV = ((TextView)findViewById(R.h.boi));
      if (paramInt != 0) {
        break label381;
      }
      this.vOQ = ((GridView)findViewById(R.h.bWJ));
      this.vOQ.setOnItemClickListener(this);
      this.vOQ.setNumColumns(3);
      localObject = new au();
      if (this.sLe) {
        ((au)localObject).A(this.jZq);
      }
      this.vOR = new c(this, (au)localObject, this.fJC);
      if (this.vOR.getCount() != 0) {
        break;
      }
      this.vOV.setVisibility(0);
      GMTrace.o(2421958901760L, 18045);
      return;
    }
    this.vOV.setVisibility(8);
    this.vOQ.setAdapter(this.vOR);
    bWE();
    for (;;)
    {
      this.vOQ.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private Runnable meG;
        
        private void er(boolean paramAnonymousBoolean)
        {
          GMTrace.i(2435649110016L, 18147);
          if (paramAnonymousBoolean)
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.meG);
            if (ImageGalleryGridUI.b(ImageGalleryGridUI.this).getVisibility() != 0)
            {
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.uRf.uRz, R.a.aQX);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).setVisibility(0);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).startAnimation(localAnimation);
              GMTrace.o(2435649110016L, 18147);
            }
          }
          else
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.meG);
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).postDelayed(this.meG, 256L);
          }
          GMTrace.o(2435649110016L, 18147);
        }
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2435917545472L, 18149);
          paramAnonymousAbsListView = ImageGalleryGridUI.this;
          Object localObject = (au)paramAnonymousAbsListView.vOR.getItem(paramAnonymousInt1);
          if (localObject == null) {}
          for (paramAnonymousAbsListView = null;; paramAnonymousAbsListView = com.tencent.mm.ui.gridviewheaders.a.bYY().a((Date)localObject, paramAnonymousAbsListView))
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).setText(paramAnonymousAbsListView);
            GMTrace.o(2435917545472L, 18149);
            return;
            localObject = new Date(((ce)localObject).field_createTime);
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          GMTrace.i(2435783327744L, 18148);
          if (1 == paramAnonymousInt) {
            er(true);
          }
          for (;;)
          {
            com.tencent.mm.ah.n.GX().bi(paramAnonymousInt);
            GMTrace.o(2435783327744L, 18148);
            return;
            if (paramAnonymousInt == 0) {
              er(false);
            }
          }
        }
      });
      GMTrace.o(2421958901760L, 18045);
      return;
      label381:
      if (this.vOR != null)
      {
        this.vOR.notifyDataSetChanged();
        bWE();
      }
    }
  }
  
  private void K(View paramView, int paramInt)
  {
    GMTrace.i(2423166861312L, 18054);
    if (this.vOR == null)
    {
      GMTrace.o(2423166861312L, 18054);
      return;
    }
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_biz_chat_id", this.jZq);
    localIntent.putExtra("key_is_biz_chat", this.sLe);
    localIntent.putExtra("intent.key.with.footer", true);
    au localau = (au)this.vOR.getItem(paramInt);
    if (localau == null)
    {
      GMTrace.o(2423166861312L, 18054);
      return;
    }
    int j = getResources().getConfiguration().orientation;
    int i = 0;
    paramInt = 0;
    int[] arrayOfInt = new int[2];
    if (paramView != null)
    {
      i = paramView.getWidth();
      paramInt = paramView.getHeight();
      paramView.getLocationInWindow(arrayOfInt);
    }
    localIntent.addFlags(536870912);
    localIntent.putExtra("img_gallery_msg_id", localau.field_msgId).putExtra("img_gallery_msg_svr_id", localau.field_msgSvrId).putExtra("img_gallery_talker", localau.field_talker).putExtra("img_gallery_chatroom_name", localau.field_talker).putExtra("img_gallery_orientation", j);
    if (paramView != null) {
      localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", paramInt).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
    }
    for (;;)
    {
      startActivity(localIntent);
      overridePendingTransition(0, 0);
      GMTrace.o(2423166861312L, 18054);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  private boolean a(au paramau, com.tencent.mm.pluginsdk.model.app.f paramf)
  {
    GMTrace.i(2422495772672L, 18049);
    if ((!paramau.field_talker.endsWith("@qqim")) || (!paramf.field_packageName.equals("com.tencent.mobileqq")))
    {
      GMTrace.o(2422495772672L, 18049);
      return false;
    }
    v.d("MicroMsg.GalleryGridUI", "jacks open QQ");
    paramau = new Intent("android.intent.action.MAIN", null);
    paramau.addCategory("android.intent.category.LAUNCHER");
    paramau.addFlags(268435456);
    paramau.setClassName("com.tencent.mobileqq", as(this.uRf.uRz, "com.tencent.mobileqq"));
    paramau.putExtra("platformId", "wechat");
    ap.yY();
    paramf = com.tencent.mm.u.c.vr().get(9, null);
    int i;
    if ((paramf != null) && ((paramf instanceof Integer))) {
      i = ((Integer)paramf).intValue();
    }
    for (;;)
    {
      int j;
      if (i != 0) {
        j = 0;
      }
      try
      {
        paramf = String.valueOf(i).getBytes("utf-8");
        byte[] arrayOfByte = "asdfghjkl;'".getBytes("utf-8");
        int m = arrayOfByte.length;
        int k = 0;
        i = j;
        j = k;
        while (j < m)
        {
          k = arrayOfByte[j];
          if (i >= paramf.length) {
            break;
          }
          paramf[i] = ((byte)(k ^ paramf[i]));
          j += 1;
          i += 1;
        }
        paramau.putExtra("tencent_gif", paramf);
        i = 0;
      }
      catch (UnsupportedEncodingException paramf)
      {
        try
        {
          for (;;)
          {
            startActivity(paramau);
            GMTrace.o(2422495772672L, 18049);
            return true;
            paramf = paramf;
            v.printErrStackTrace("MicroMsg.GalleryGridUI", paramf, "", new Object[0]);
          }
        }
        catch (Exception paramau)
        {
          for (;;) {}
        }
      }
    }
  }
  
  private static String as(Context paramContext, String paramString)
  {
    GMTrace.i(2422629990400L, 18050);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext == null) {
        break label108;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    GMTrace.o(2422629990400L, 18050);
    return paramContext;
  }
  
  private static PackageInfo ay(Context paramContext, String paramString)
  {
    GMTrace.i(2422898425856L, 18052);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      GMTrace.o(2422898425856L, 18052);
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.g.aJ(paramString, true);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      GMTrace.o(2422898425856L, 18052);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      v.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
      GMTrace.o(2422898425856L, 18052);
    }
    return null;
  }
  
  private void b(cb paramcb)
  {
    GMTrace.i(2424374820864L, 18063);
    paramcb.fFr.activity = this;
    paramcb.fFr.fFy = 45;
    com.tencent.mm.sdk.b.a.uql.m(paramcb);
    if ((paramcb.fFs.ret == -2) || (paramcb.fFs.ret > 0))
    {
      GMTrace.o(2424374820864L, 18063);
      return;
    }
    if (paramcb.fFs.ret <= 0)
    {
      bWl();
      if (14 != paramcb.fFr.type)
      {
        v.d("MicroMsg.GalleryGridUI", "not record type, do not report");
        GMTrace.o(2424374820864L, 18063);
        return;
      }
      if (paramcb.fFr.fFu == null)
      {
        v.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
        GMTrace.o(2424374820864L, 18063);
        return;
      }
      com.tencent.mm.plugin.report.service.g.oSF.i(11142, new Object[] { Integer.valueOf(paramcb.fFr.fFu.txQ), Integer.valueOf(paramcb.fFr.fFu.txR), Integer.valueOf(paramcb.fFr.fFu.txS), Integer.valueOf(paramcb.fFr.fFu.txT), Integer.valueOf(paramcb.fFr.fFu.txU), Integer.valueOf(paramcb.fFr.fFu.txV), Integer.valueOf(paramcb.fFr.fFu.txW), Integer.valueOf(paramcb.fFr.fFu.txX), Integer.valueOf(paramcb.fFr.fFu.txY), Integer.valueOf(paramcb.fFr.fFu.txZ), Integer.valueOf(paramcb.fFr.fFu.tya), Integer.valueOf(paramcb.fFr.fFu.tyb), Integer.valueOf(paramcb.fFr.fFu.tyc), Integer.valueOf(paramcb.fFr.fFu.tyd), Integer.valueOf(paramcb.fFr.fFu.tye) });
    }
    GMTrace.o(2424374820864L, 18063);
  }
  
  private void bWE()
  {
    GMTrace.i(2422093119488L, 18046);
    int i = this.vOQ.getFirstVisiblePosition();
    int j = this.vOQ.getLastVisiblePosition();
    int k = this.vOP;
    if ((k >= i) && (k <= j))
    {
      GMTrace.o(2422093119488L, 18046);
      return;
    }
    this.vOQ.setSelection(k);
    GMTrace.o(2422093119488L, 18046);
  }
  
  private void bWF()
  {
    GMTrace.i(2423703732224L, 18058);
    if ((!g.a.vPK.vOh.isEmpty()) && (g.a.vPK.vPI)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.vPd.setEnabled(true);
      this.vPe.setEnabled(true);
      this.vPf.setEnabled(true);
      this.vPg.setEnabled(true);
      GMTrace.o(2423703732224L, 18058);
      return;
    }
    this.vPd.setEnabled(false);
    this.vPe.setEnabled(false);
    this.vPf.setEnabled(false);
    this.vPg.setEnabled(false);
    GMTrace.o(2423703732224L, 18058);
  }
  
  private void bWk()
  {
    GMTrace.i(2423569514496L, 18057);
    qL(getString(R.l.enU, new Object[] { Integer.valueOf(g.a.vPK.vOh.size()) }));
    g.a.vPK.vPI = true;
    if (this.vOR == null)
    {
      GMTrace.o(2423569514496L, 18057);
      return;
    }
    if (this.puq == null) {
      this.puq = AnimationUtils.loadAnimation(this, R.a.aRq);
    }
    c localc = this.vOR;
    localc.hPG = false;
    localc.notifyDataSetChanged();
    this.vPb.setVisibility(0);
    this.vPb.startAnimation(this.puq);
    this.vPd.setEnabled(false);
    this.vPe.setEnabled(false);
    this.vPf.setEnabled(false);
    this.vPg.setEnabled(false);
    this.vPc = this.vOQ.getPaddingBottom();
    this.vOQ.setPadding(this.vOQ.getPaddingLeft(), this.vOQ.getPaddingTop(), this.vOQ.getPaddingRight(), com.tencent.mm.bg.a.T(this.uRf.uRz, R.f.aXP));
    com.tencent.mm.plugin.report.service.g.oSF.i(11627, new Object[] { Integer.valueOf(2) });
    zi(0);
    a(0, getString(R.l.enp), this);
    GMTrace.o(2423569514496L, 18057);
  }
  
  private String bd(au paramau)
  {
    GMTrace.i(2422764208128L, 18051);
    String str = this.fJC;
    boolean bool = this.fJC.endsWith("@chatroom");
    if (!bool)
    {
      GMTrace.o(2422764208128L, 18051);
      return str;
    }
    if (bool)
    {
      paramau = ay.gi(paramau.field_content);
      if ((str == null) || (paramau == null) || (paramau.length() <= 0)) {}
    }
    for (;;)
    {
      GMTrace.o(2422764208128L, 18051);
      return paramau;
      paramau = str;
    }
  }
  
  private void be(au paramau)
  {
    GMTrace.i(2423032643584L, 18053);
    long l1 = this.vDO;
    long l2 = System.currentTimeMillis();
    this.vDO = l2;
    if (l1 + 30000L < l2)
    {
      ap.yY();
      this.sWq = com.tencent.mm.u.c.isSDCardAvailable();
    }
    if (!this.sWq)
    {
      s.eP(this.uRf.uRz);
      GMTrace.o(2423032643584L, 18053);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(this.uRf.uRz, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", paramau.field_msgId);
    startActivity(localIntent);
    GMTrace.o(2423032643584L, 18053);
  }
  
  private static List<au> cD(List<au> paramList)
  {
    GMTrace.i(2424240603136L, 18062);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      au localau = (au)paramList.next();
      if ((!b.aT(localau)) && (!b.aU(localau))) {
        localArrayList.add(localau);
      }
    }
    GMTrace.o(2424240603136L, 18062);
    return localArrayList;
  }
  
  private static void cz(List<au> paramList)
  {
    GMTrace.i(2424106385408L, 18061);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      au localau = (au)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.vvo, a.d.vvt, localau, 0);
    }
    GMTrace.o(2424106385408L, 18061);
  }
  
  public final void a(dx.a parama)
  {
    GMTrace.i(14958968438784L, 111453);
    GMTrace.o(14958968438784L, 111453);
  }
  
  public final void b(dx.a parama)
  {
    GMTrace.i(14959102656512L, 111454);
    if (parama == dx.a.vLq)
    {
      this.vOR.OL();
      this.vOR.notifyDataSetChanged();
    }
    bWl();
    GMTrace.o(14959102656512L, 111454);
  }
  
  protected final boolean bPE()
  {
    GMTrace.i(2421153595392L, 18039);
    GMTrace.o(2421153595392L, 18039);
    return true;
  }
  
  public final void bUu()
  {
    GMTrace.i(14958834221056L, 111452);
    GMTrace.o(14958834221056L, 111452);
  }
  
  public final boolean bUv()
  {
    GMTrace.i(2424911691776L, 18067);
    GMTrace.o(2424911691776L, 18067);
    return true;
  }
  
  public final void bWG()
  {
    GMTrace.i(2424509038592L, 18064);
    if ((this.vOR != null) && (this.fAx)) {
      this.vOR.vOI = true;
    }
    qL(getString(R.l.enU, new Object[] { Integer.valueOf(g.a.vPK.vOh.size()) }));
    bWF();
    GMTrace.o(2424509038592L, 18064);
  }
  
  public final void bWl()
  {
    GMTrace.i(2423837949952L, 18059);
    g.a.vPK.vPI = false;
    qL(getString(R.l.dCR));
    if (this.vOR == null)
    {
      GMTrace.o(2423837949952L, 18059);
      return;
    }
    this.vOR.notifyDataSetChanged();
    if (this.vPc >= 0) {
      this.vOQ.setPadding(this.vOQ.getPaddingLeft(), this.vOQ.getPaddingTop(), this.vOQ.getPaddingRight(), this.vPc);
    }
    this.vPb.setVisibility(8);
    zi(0);
    a(0, getString(R.l.enq), this);
    GMTrace.o(2423837949952L, 18059);
  }
  
  public final void clear()
  {
    GMTrace.i(2424643256320L, 18065);
    if ((this.vOR != null) && (this.fAx)) {
      this.vOR.vOI = true;
    }
    bWF();
    GMTrace.o(2424643256320L, 18065);
  }
  
  public void finish()
  {
    GMTrace.i(2422227337216L, 18047);
    super.finish();
    g.a.vPK.detach();
    GMTrace.o(2422227337216L, 18047);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2420885159936L, 18037);
    int i = R.i.bWJ;
    GMTrace.o(2420885159936L, 18037);
    return i;
  }
  
  public void onBackPressed()
  {
    GMTrace.i(2421824684032L, 18044);
    if (g.a.vPK.vPI)
    {
      bWl();
      GMTrace.o(2421824684032L, 18044);
      return;
    }
    if (this.vOT.booleanValue())
    {
      super.onBackPressed();
      GMTrace.o(2421824684032L, 18044);
      return;
    }
    if (this.vOP >= 0) {
      K(null, this.vOP);
    }
    finish();
    GMTrace.o(2421824684032L, 18044);
  }
  
  public void onClick(final View paramView)
  {
    GMTrace.i(2423972167680L, 18060);
    if (g.a.vPK.vOh.isEmpty())
    {
      GMTrace.o(2423972167680L, 18060);
      return;
    }
    boolean bool = this.fJC.toLowerCase().endsWith("@chatroom");
    final Object localObject2 = g.a.vPK.vOh;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      GMTrace.o(2423972167680L, 18060);
      return;
    }
    if (paramView.getId() == R.h.beu)
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(11627, new Object[] { Integer.valueOf(5) });
      paramView = new TreeSet();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(Long.valueOf(((au)((Iterator)localObject1).next()).field_msgId));
      }
      com.tencent.mm.ui.base.g.b(this, getString(R.l.dWV), "", getString(R.l.ebn), getString(R.l.dGk), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2413100531712L, 17979);
          v.i("MicroMsg.GalleryGridUI", "delete message");
          z.a(ImageGalleryGridUI.this, paramView, ImageGalleryGridUI.this);
          ImageGalleryGridUI.this.bWl();
          GMTrace.o(2413100531712L, 17979);
        }
      }, null);
      GMTrace.o(2423972167680L, 18060);
      return;
    }
    if (paramView.getId() == R.h.bNS)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(219L, 18L, 1L, true);
      final cb localcb = new cb();
      if (com.tencent.mm.pluginsdk.model.g.a(this.uRf.uRz, localcb, this.fJC, (List)localObject2, false))
      {
        b(localcb);
        cz((List)localObject2);
        GMTrace.o(2423972167680L, 18060);
        return;
      }
      if (((List)localObject2).size() > 1)
      {
        ActionBarActivity localActionBarActivity = this.uRf.uRz;
        if (localcb.fFr.fFx >= 0)
        {
          paramView = this.uRf.uRz.getString(R.l.eig);
          if (localcb.fFr.fFx < 0) {
            break label417;
          }
        }
        label417:
        for (localObject1 = this.uRf.uRz.getString(R.l.dXc);; localObject1 = this.uRf.uRz.getString(R.l.eFS))
        {
          com.tencent.mm.ui.base.g.b(localActionBarActivity, paramView, "", (String)localObject1, this.uRf.uRz.getString(R.l.dXa), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(2468398235648L, 18391);
              if ((localcb.fFr.type == 14) && (localcb.fFr.fFt.txF.size() == 0))
              {
                ImageGalleryGridUI.this.bWl();
                GMTrace.o(2468398235648L, 18391);
                return;
              }
              ImageGalleryGridUI.a(ImageGalleryGridUI.this, localcb);
              ImageGalleryGridUI.cE(localObject2);
              GMTrace.o(2468398235648L, 18391);
            }
          }, null);
          GMTrace.o(2423972167680L, 18060);
          return;
          paramView = this.uRf.uRz.getString(R.l.eif);
          break;
        }
      }
      com.tencent.mm.ui.base.g.h(this.uRf.uRz, localcb.fFr.fFx, 0);
      GMTrace.o(2423972167680L, 18060);
      return;
    }
    if (paramView.getId() == R.h.cJu)
    {
      com.tencent.mm.plugin.report.service.g.oSF.a(219L, 19L, 1L, true);
      ab.a(this, (List)localObject2, bool, this.fJC, this);
      bWl();
      GMTrace.o(2423972167680L, 18060);
      return;
    }
    com.tencent.mm.plugin.report.service.g.oSF.i(11627, new Object[] { Integer.valueOf(3) });
    paramView = cD((List)localObject2);
    if (paramView.size() != ((List)localObject2).size())
    {
      com.tencent.mm.ui.base.g.a(this.uRf.uRz, R.l.enK, R.l.dIG, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2437796593664L, 18163);
          b.c(ImageGalleryGridUI.this.uRf.uRz, paramView);
          ImageGalleryGridUI.this.bWl();
          GMTrace.o(2437796593664L, 18163);
        }
      }, null);
      GMTrace.o(2423972167680L, 18060);
      return;
    }
    Object localObject1 = (au)paramView.get(0);
    if ((((List)localObject2).size() == 1) && (localObject1 != null) && (((au)localObject1).axH()))
    {
      localObject2 = ((ce)localObject1).field_content;
      paramView = null;
      if (localObject2 != null) {
        paramView = f.a.B((String)localObject2, ((ce)localObject1).field_reserved);
      }
      if ((paramView != null) && (paramView.type == 6)) {
        be((au)localObject1);
      }
      GMTrace.o(2423972167680L, 18060);
      return;
    }
    b.c(this, (List)localObject2);
    bWl();
    GMTrace.o(2423972167680L, 18060);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2421019377664L, 18038);
    super.onCreate(paramBundle);
    this.vOY = true;
    this.handler = new ad();
    Bt(0);
    com.tencent.mm.sdk.b.a.uql.b(this.vHY);
    GMTrace.o(2421019377664L, 18038);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2421287813120L, 18040);
    this.handler.removeCallbacks(this.vOX);
    this.handler = null;
    com.tencent.mm.ah.n.GX().bi(0);
    com.tencent.mm.sdk.b.a.uql.c(this.vHY);
    super.onDestroy();
    GMTrace.o(2421287813120L, 18040);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GMTrace.i(2422361554944L, 18048);
    au localau = (au)this.vOR.getItem(paramInt);
    paramAdapterView = localau.field_content;
    if (paramAdapterView != null) {}
    for (paramAdapterView = f.a.B(paramAdapterView, localau.field_reserved);; paramAdapterView = null)
    {
      if ((paramAdapterView != null) && (paramAdapterView.type == 6))
      {
        be(localau);
        GMTrace.o(2422361554944L, 18048);
        return;
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramAdapterView != null) && (paramAdapterView.type == 3))
      {
        localObject1 = com.tencent.mm.pluginsdk.model.app.p.s(paramAdapterView.url, "message");
        localObject2 = com.tencent.mm.pluginsdk.model.app.p.s(paramAdapterView.hhf, "message");
        localObject3 = ay(this.uRf.uRz, paramAdapterView.appId);
        if (localObject3 == null)
        {
          paramView = null;
          if (localObject3 != null) {
            break label211;
          }
        }
        long l;
        label211:
        for (paramInt = 0;; paramInt = ((PackageInfo)localObject3).versionCode)
        {
          localObject3 = paramAdapterView.appId;
          paramLong = localau.field_msgId;
          l = localau.field_msgSvrId;
          if (((localObject1 != null) && (((String)localObject1).length() != 0)) || ((localObject2 != null) && (((String)localObject2).length() != 0))) {
            break label220;
          }
          v.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
          GMTrace.o(2422361554944L, 18048);
          return;
          paramView = ((PackageInfo)localObject3).versionName;
          break;
        }
        label220:
        if (al.isMobile(this.uRf.uRz))
        {
          paramAdapterView = (AdapterView<?>)localObject1;
          if (localObject2 != null)
          {
            if (((String)localObject2).length() > 0) {
              break label512;
            }
            paramAdapterView = (AdapterView<?>)localObject1;
          }
        }
        for (;;)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("msg_id", paramLong);
          ((Intent)localObject1).putExtra("rawUrl", paramAdapterView);
          ((Intent)localObject1).putExtra("version_name", paramView);
          ((Intent)localObject1).putExtra("version_code", paramInt);
          ((Intent)localObject1).putExtra("usePlugin", true);
          ((Intent)localObject1).putExtra("geta8key_username", this.fJC);
          ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(l));
          ((Intent)localObject1).putExtra("KAppId", (String)localObject3);
          paramAdapterView = bd(localau);
          ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
          ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(l));
          if (localau != null) {
            ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
          }
          ((Intent)localObject1).putExtra("preChatName", this.fJC);
          ((Intent)localObject1).putExtra("preChatTYPE", com.tencent.mm.u.p.G(paramAdapterView, this.fJC));
          ((Intent)localObject1).putExtra("preMsgIndex", 0);
          com.tencent.mm.bb.d.b(this.uRf.uRz, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          GMTrace.o(2422361554944L, 18048);
          return;
          if (localObject1 != null)
          {
            paramAdapterView = (AdapterView<?>)localObject1;
            if (((String)localObject1).length() > 0) {}
          }
          else
          {
            label512:
            paramAdapterView = (AdapterView<?>)localObject2;
          }
        }
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 5))
      {
        if ((paramAdapterView.url != null) && (!paramAdapterView.url.equals("")))
        {
          localObject1 = paramAdapterView.url;
          if (!this.fJC.endsWith("@chatroom")) {
            break label1001;
          }
          paramView = "groupmessage";
          localObject3 = com.tencent.mm.pluginsdk.model.app.p.s((String)localObject1, paramView);
          paramView = paramAdapterView.url;
          localObject2 = ay(this.uRf.uRz, paramAdapterView.appId);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
          ((Intent)localObject1).putExtra("webpageTitle", paramAdapterView.title);
          if ((paramAdapterView.appId != null) && (("wx751a1acca5688ba3".equals(paramAdapterView.appId)) || ("wxfbc915ff7c30e335".equals(paramAdapterView.appId)) || ("wx482a4001c37e2b74".equals(paramAdapterView.appId))))
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("jsapi_args_appid", paramAdapterView.appId);
            ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject3);
          }
          if (bf.mA(paramView)) {
            break label1008;
          }
          ((Intent)localObject1).putExtra("shortUrl", paramView);
          label730:
          if (localObject2 != null) {
            break label1024;
          }
          paramView = null;
          label737:
          ((Intent)localObject1).putExtra("version_name", paramView);
          if (localObject2 != null) {
            break label1033;
          }
        }
        label1001:
        label1008:
        label1024:
        label1033:
        for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
        {
          ((Intent)localObject1).putExtra("version_code", paramInt);
          if (!bf.mA(paramAdapterView.fUH))
          {
            ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.fUH);
            ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.fUI);
          }
          ((Intent)localObject1).putExtra("msg_id", localau.field_msgId);
          ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localau.field_msgSvrId));
          ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
          ((Intent)localObject1).putExtra("geta8key_username", this.fJC);
          paramAdapterView = bd(localau);
          ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
          ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localau.field_msgSvrId));
          ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
          ((Intent)localObject1).putExtra("preChatName", this.fJC);
          ((Intent)localObject1).putExtra("preChatTYPE", com.tencent.mm.u.p.G(paramAdapterView, this.fJC));
          ((Intent)localObject1).putExtra("preMsgIndex", 0);
          com.tencent.mm.bb.d.b(this.uRf.uRz, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          GMTrace.o(2422361554944L, 18048);
          return;
          paramView = "singlemessage";
          break;
          ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
          break label730;
          paramView = ((PackageInfo)localObject2).versionName;
          break label737;
        }
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 19))
      {
        paramView = new Intent();
        paramView.putExtra("message_id", localau.field_msgId);
        paramView.putExtra("record_xml", paramAdapterView.hhG);
        com.tencent.mm.bb.d.b(this.uRf.uRz, "record", ".ui.RecordMsgDetailUI", paramView);
        GMTrace.o(2422361554944L, 18048);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 24))
      {
        paramView = new kq();
        paramView.fQY.context = this.uRf.uRz;
        paramView.fQY.fGD = localau.field_msgId;
        paramView.fQY.fQZ = paramAdapterView.hhG;
        com.tencent.mm.sdk.b.a.uql.m(paramView);
        GMTrace.o(2422361554944L, 18048);
        return;
      }
      label1295:
      Object localObject4;
      label1355:
      boolean bool;
      if ((paramAdapterView != null) && (paramAdapterView.type == 7))
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.g.aJ(paramAdapterView.appId, false);
        if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject2).bCM()))
        {
          localObject1 = this.fJC;
          paramView = (View)localObject1;
          if (o.dH((String)localObject1)) {
            paramView = ay.gi(localau.field_content);
          }
          paramLong = localau.field_msgSvrId;
          if ((localObject2 != null) && (com.tencent.mm.pluginsdk.model.app.p.n(this.uRf.uRz, ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_packageName)))
          {
            paramInt = 3;
            if (paramAdapterView.type != 2) {
              break label1692;
            }
            paramInt = 4;
            localObject3 = new mn();
            ((mn)localObject3).fTD.context = this.uRf.uRz;
            ((mn)localObject3).fTD.scene = 1;
            ((mn)localObject3).fTD.fTE = paramAdapterView.appId;
            localObject4 = ((mn)localObject3).fTD;
            if (localObject2 != null) {
              break label1705;
            }
            localObject1 = null;
            ((mn.a)localObject4).packageName = ((String)localObject1);
            ((mn)localObject3).fTD.msgType = paramAdapterView.type;
            ((mn)localObject3).fTD.fOl = paramView;
            ((mn)localObject3).fTD.fTF = paramInt;
            ((mn)localObject3).fTD.mediaTagName = paramAdapterView.mediaTagName;
            ((mn)localObject3).fTD.fTG = paramLong;
            ((mn)localObject3).fTD.fTH = "";
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
            paramView = l.a.szQ;
            if ((com.tencent.mm.pluginsdk.model.app.g.a(this.uRf.uRz, (com.tencent.mm.pluginsdk.model.app.f)localObject2)) || (paramView == null)) {
              break label1805;
            }
            if (bf.mA(((com.tencent.mm.e.b.n)localObject2).geY)) {
              break label1715;
            }
            bool = q.aR(this.uRf.uRz, ((com.tencent.mm.e.b.n)localObject2).geY);
            v.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { ((com.tencent.mm.e.b.n)localObject2).geY, Boolean.valueOf(bool) });
            if (!bool) {
              break label1715;
            }
            paramInt = 1;
          }
          for (;;)
          {
            if (paramInt == 0)
            {
              if ((paramAdapterView.fCN == null) || (paramAdapterView.fCN.length() == 0))
              {
                paramView = localau.field_content;
                paramAdapterView = paramView;
                if (localau.field_isSend == 0)
                {
                  paramInt = localau.field_isSend;
                  paramAdapterView = paramView;
                  if (!this.sLe)
                  {
                    paramAdapterView = paramView;
                    if (o.dH(this.fJC))
                    {
                      paramAdapterView = paramView;
                      if (paramView != null)
                      {
                        paramAdapterView = paramView;
                        if (paramInt == 0) {
                          paramAdapterView = ay.gj(paramView);
                        }
                      }
                    }
                  }
                }
                paramView = f.a.ek(paramAdapterView);
                localObject1 = com.tencent.mm.pluginsdk.model.app.g.aJ(paramView.appId, true);
                if ((localObject1 != null) && (com.tencent.mm.pluginsdk.model.app.p.n(this.uRf.uRz, ((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_packageName)))
                {
                  if (((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_status == 3)
                  {
                    v.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + ((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_packageName);
                    GMTrace.o(2422361554944L, 18048);
                    return;
                    paramInt = 6;
                    break;
                    label1692:
                    if (paramAdapterView.type != 5) {
                      break label1295;
                    }
                    paramInt = 1;
                    break label1295;
                    label1705:
                    localObject1 = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_packageName;
                    break label1355;
                    label1715:
                    localObject1 = new gh();
                    ((gh)localObject1).fLs.actionCode = 2;
                    ((gh)localObject1).fLs.scene = 1;
                    ((gh)localObject1).fLs.appId = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appId;
                    ((gh)localObject1).fLs.context = this.uRf.uRz;
                    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
                    new Intent();
                    paramView.B(((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appId, 1, 1);
                    paramInt = 1;
                    continue;
                    label1805:
                    paramInt = 0;
                    continue;
                  }
                  if (!com.tencent.mm.pluginsdk.model.app.p.b(this.uRf.uRz, (com.tencent.mm.pluginsdk.model.app.f)localObject1))
                  {
                    v.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[] { ((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_appName });
                    Toast.makeText(this.uRf.uRz, getString(R.l.eoF, new Object[] { com.tencent.mm.pluginsdk.model.app.g.a(this.uRf.uRz, (com.tencent.mm.pluginsdk.model.app.f)localObject1, null) }), 1).show();
                    GMTrace.o(2422361554944L, 18048);
                    return;
                  }
                  if (a(localau, (com.tencent.mm.pluginsdk.model.app.f)localObject1)) {
                    break label2136;
                  }
                  localObject2 = new WXAppExtendObject();
                  ((WXAppExtendObject)localObject2).extInfo = paramView.extInfo;
                  if ((paramView.fCN != null) && (paramView.fCN.length() > 0))
                  {
                    paramAdapterView = an.abF().LV(paramView.fCN);
                    if (paramAdapterView != null) {
                      break label2076;
                    }
                  }
                  label2076:
                  for (paramAdapterView = null;; paramAdapterView = paramAdapterView.field_fileFullPath)
                  {
                    ((WXAppExtendObject)localObject2).filePath = paramAdapterView;
                    paramAdapterView = new WXMediaMessage();
                    paramAdapterView.sdkVer = 620757000;
                    paramAdapterView.mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
                    paramAdapterView.title = paramView.title;
                    paramAdapterView.description = paramView.description;
                    paramAdapterView.messageAction = paramView.messageAction;
                    paramAdapterView.messageExt = paramView.messageExt;
                    paramAdapterView.thumbData = e.c(com.tencent.mm.ah.n.GT().jv(localau.field_imgPath), 0, -1);
                    new eu(this).a(((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_packageName, paramAdapterView, ((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_appId, ((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_openId);
                    GMTrace.o(2422361554944L, 18048);
                    return;
                  }
                }
                paramAdapterView = com.tencent.mm.pluginsdk.model.app.p.t(this.uRf.uRz, paramView.appId, "message");
                paramView = new Intent();
                paramView.putExtra("rawUrl", paramAdapterView);
                com.tencent.mm.bb.d.b(this.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramView);
                label2136:
                GMTrace.o(2422361554944L, 18048);
                return;
              }
              if (!this.sWq)
              {
                s.eP(this.uRf.uRz);
                GMTrace.o(2422361554944L, 18048);
                return;
              }
              paramAdapterView = new Intent();
              paramAdapterView.setClassName(this.uRf.uRz, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              paramAdapterView.putExtra("app_msg_id", localau.field_msgId);
              startActivityForResult(paramAdapterView, 210);
            }
          }
        }
        GMTrace.o(2422361554944L, 18048);
        return;
      }
      int i;
      if ((localau.bMb()) || (localau.bLX()) || (localau.bMc()) || (localau.bMf()))
      {
        if ((paramAdapterView == null) || (bf.mA(paramAdapterView.hjt)))
        {
          i = 0;
          if (i != 0) {
            GMTrace.o(2422361554944L, 18048);
          }
        }
        else
        {
          localObject1 = localau.field_imgPath;
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("IsAd", false);
          ((Intent)localObject3).putExtra("KStremVideoUrl", paramAdapterView.hjt);
          ((Intent)localObject3).putExtra("KThumUrl", paramAdapterView.hjy);
          ((Intent)localObject3).putExtra("KThumbPath", (String)localObject1);
          ((Intent)localObject3).putExtra("KMediaId", "fakeid_" + localau.field_msgId);
          ((Intent)localObject3).putExtra("KMediaVideoTime", paramAdapterView.hju);
          ((Intent)localObject3).putExtra("StremWebUrl", paramAdapterView.hjx);
          ((Intent)localObject3).putExtra("StreamWording", paramAdapterView.hjw);
          ((Intent)localObject3).putExtra("KMediaTitle", paramAdapterView.title);
          localObject2 = localau.field_talker;
          bool = ((String)localObject2).endsWith("@chatroom");
          if (bool)
          {
            localObject1 = ay.gi(localau.field_content);
            label2468:
            ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramAdapterView.hjz);
            ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramAdapterView.hjA);
            ((Intent)localObject3).putExtra("KSta_SourceType", 1);
            if (!bool) {
              break label2627;
            }
          }
          label2627:
          for (i = a.b.vvl.value;; i = a.b.vvk.value)
          {
            ((Intent)localObject3).putExtra("KSta_Scene", i);
            ((Intent)localObject3).putExtra("KSta_FromUserName", (String)localObject1);
            ((Intent)localObject3).putExtra("KSta_ChatName", (String)localObject2);
            ((Intent)localObject3).putExtra("KSta_MsgId", localau.field_msgSvrId);
            ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", paramAdapterView.fUO);
            if (bool) {
              ((Intent)localObject3).putExtra("KSta_ChatroomMembercount", j.eC((String)localObject2));
            }
            com.tencent.mm.bb.d.b(this.uRf.uRz, "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
            i = 1;
            break;
            localObject1 = localObject2;
            break label2468;
          }
        }
        K(paramView, paramInt);
        GMTrace.o(2422361554944L, 18048);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 15))
      {
        localObject1 = paramAdapterView.hhJ;
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = ((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ud(paramAdapterView.url);
        }
        if (TextUtils.isEmpty(paramView))
        {
          paramView = new Intent();
          paramView.putExtra("geta8key_username", m.xL());
          paramView.putExtra("rawUrl", paramAdapterView.url);
          com.tencent.mm.bb.d.b(this.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramView);
          GMTrace.o(2422361554944L, 18048);
          return;
        }
        v.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("extra_id", paramView);
        paramAdapterView.putExtra("preceding_scence", 123);
        paramAdapterView.putExtra("download_entrance_scene", 23);
        com.tencent.mm.bb.d.b(this.uRf.uRz, "emoji", ".ui.EmojiStoreDetailUI", paramAdapterView);
        com.tencent.mm.plugin.report.service.g.oSF.i(10993, new Object[] { Integer.valueOf(2), paramView });
        GMTrace.o(2422361554944L, 18048);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 26))
      {
        paramInt = paramAdapterView.tid;
        paramView = paramAdapterView.hjr;
        localObject1 = paramAdapterView.desc;
        localObject2 = paramAdapterView.iconUrl;
        localObject3 = paramAdapterView.secondUrl;
        i = paramAdapterView.pageType;
        if (paramInt != 0)
        {
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("geta8key_username", bd(localau));
          ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.gxt);
          ((Intent)localObject4).putExtra("topic_id", paramInt);
          ((Intent)localObject4).putExtra("topic_name", paramView);
          ((Intent)localObject4).putExtra("topic_desc", (String)localObject1);
          ((Intent)localObject4).putExtra("topic_icon_url", (String)localObject2);
          ((Intent)localObject4).putExtra("topic_ad_url", (String)localObject3);
          ((Intent)localObject4).putExtra("extra_scence", 23);
          com.tencent.mm.bb.d.b(this.uRf.uRz, "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject4);
          GMTrace.o(2422361554944L, 18048);
          return;
        }
        v.i("MicroMsg.GalleryGridUI", "topic id is zero.");
        GMTrace.o(2422361554944L, 18048);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 27))
      {
        paramInt = paramAdapterView.tid;
        paramView = paramAdapterView.hjr;
        localObject1 = paramAdapterView.desc;
        localObject2 = paramAdapterView.iconUrl;
        localObject3 = paramAdapterView.secondUrl;
        i = paramAdapterView.pageType;
        if (paramInt != 0)
        {
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("geta8key_username", bd(localau));
          ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.gxt);
          ((Intent)localObject4).putExtra("set_id", paramInt);
          ((Intent)localObject4).putExtra("set_title", paramView);
          ((Intent)localObject4).putExtra("set_iconURL", (String)localObject2);
          ((Intent)localObject4).putExtra("set_desc", (String)localObject1);
          ((Intent)localObject4).putExtra("headurl", (String)localObject3);
          ((Intent)localObject4).putExtra("pageType", i);
          com.tencent.mm.bb.d.b(this.uRf.uRz, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject4);
          GMTrace.o(2422361554944L, 18048);
          return;
        }
        v.i("MicroMsg.GalleryGridUI", "topic id is zero.");
        GMTrace.o(2422361554944L, 18048);
        return;
      }
      v.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[] { localau.field_talker, Long.valueOf(localau.field_msgId), Integer.valueOf(localau.field_type), localau.field_content });
      if ((paramAdapterView.url != null) && (!paramAdapterView.url.equals("")) && (paramAdapterView.url != null) && (!paramAdapterView.url.equals("")))
      {
        localObject1 = paramAdapterView.url;
        if (!o.dH(this.fJC)) {
          break label3809;
        }
        paramView = "groupmessage";
        localObject3 = com.tencent.mm.pluginsdk.model.app.p.s((String)localObject1, paramView);
        paramView = paramAdapterView.url;
        localObject2 = ay(this.uRf.uRz, paramAdapterView.appId);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
        ((Intent)localObject1).putExtra("webpageTitle", paramAdapterView.title);
        if ((paramAdapterView.appId != null) && (("wx751a1acca5688ba3".equals(paramAdapterView.appId)) || ("wxfbc915ff7c30e335".equals(paramAdapterView.appId)) || ("wx482a4001c37e2b74".equals(paramAdapterView.appId))))
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("jsapi_args_appid", paramAdapterView.appId);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject3);
        }
        if (bf.mA(paramView)) {
          break label3816;
        }
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        label3536:
        if (localObject2 != null) {
          break label3832;
        }
        paramView = null;
        label3543:
        ((Intent)localObject1).putExtra("version_name", paramView);
        if (localObject2 != null) {
          break label3841;
        }
      }
      label3809:
      label3816:
      label3832:
      label3841:
      for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
      {
        ((Intent)localObject1).putExtra("version_code", paramInt);
        if (!bf.mA(paramAdapterView.fUH))
        {
          ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.fUH);
          ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.fUI);
        }
        ((Intent)localObject1).putExtra("msg_id", localau.field_msgId);
        ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localau.field_msgSvrId));
        ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
        ((Intent)localObject1).putExtra("geta8key_username", m.xL());
        ((Intent)localObject1).putExtra("pre_username", bd(localau));
        ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localau.field_msgSvrId));
        paramAdapterView = bd(localau);
        paramView = m.xL();
        ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
        ((Intent)localObject1).putExtra("preChatName", paramView);
        ((Intent)localObject1).putExtra("preChatTYPE", com.tencent.mm.u.p.G(paramAdapterView, paramView));
        ((Intent)localObject1).putExtra("preMsgIndex", 0);
        com.tencent.mm.bb.d.b(this.uRf.uRz, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        GMTrace.o(2422361554944L, 18048);
        return;
        paramView = "singlemessage";
        break;
        ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
        break label3536;
        paramView = ((PackageInfo)localObject2).versionName;
        break label3543;
      }
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    GMTrace.i(2423435296768L, 18056);
    if (paramMenuItem.getTitle().equals(getString(R.l.enq)))
    {
      g.a.vPK.clear();
      bWk();
    }
    for (;;)
    {
      GMTrace.o(2423435296768L, 18056);
      return false;
      bWl();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    GMTrace.i(2421690466304L, 18043);
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
    Bt(1);
    GMTrace.o(2421690466304L, 18043);
  }
  
  protected void onPause()
  {
    GMTrace.i(2421556248576L, 18042);
    g localg = g.a.vPK;
    if (this != null) {
      localg.vPJ.remove(this);
    }
    this.fAx = true;
    super.onPause();
    GMTrace.o(2421556248576L, 18042);
  }
  
  public boolean onPreDraw()
  {
    GMTrace.i(2423301079040L, 18055);
    final Object localObject1 = (c.a)this.vOS.get();
    if (localObject1 == null)
    {
      GMTrace.o(2423301079040L, 18055);
      return true;
    }
    final Object localObject2 = ((c.a)localObject1).ppc.getViewTreeObserver();
    if (!((ViewTreeObserver)localObject2).isAlive())
    {
      GMTrace.o(2423301079040L, 18055);
      return true;
    }
    ((ViewTreeObserver)localObject2).removeOnPreDrawListener(this);
    int i = ((c.a)localObject1).ppc.getMeasuredWidth();
    int j = ((c.a)localObject1).ppc.getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      GMTrace.o(2423301079040L, 18055);
      return true;
    }
    localObject2 = (RelativeLayout.LayoutParams)((c.a)localObject1).vNF.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = i;
    ((ViewGroup.LayoutParams)localObject2).height = j;
    ((c.a)localObject1).vNF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = ((c.a)localObject1).vNF;
    localObject2 = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.vPa = ((View)localObject1);
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2445044350976L, 18217);
          if (Build.VERSION.SDK_INT >= 16)
          {
            localObject1.animate().setDuration(500L).alpha(0.0F).withEndAction(ImageGalleryGridUI.this.vOZ).withLayer().setInterpolator(localObject2);
            GMTrace.o(2445044350976L, 18217);
            return;
          }
          if (ImageGalleryGridUI.this.handler == null)
          {
            GMTrace.o(2445044350976L, 18217);
            return;
          }
          localObject1.animate().setDuration(500L).alpha(0.0F).setInterpolator(localObject2);
          ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.vOZ, 500L);
          GMTrace.o(2445044350976L, 18217);
        }
      }, 700L);
    }
    GMTrace.o(2423301079040L, 18055);
    return true;
  }
  
  protected void onResume()
  {
    GMTrace.i(2421422030848L, 18041);
    g.a.vPK.a(this);
    this.fAx = false;
    if (this.vOY)
    {
      if (!g.a.vPK.vPI) {
        break label149;
      }
      bWk();
    }
    for (;;)
    {
      this.handler.postDelayed(this.vOX, 300L);
      super.onResume();
      if (this.vOR != null)
      {
        this.vOR.vOI = true;
        c localc = this.vOR;
        if (localc.vOI) {
          localc.notifyDataSetChanged();
        }
        if (g.a.vPK.vPI) {
          qL(getString(R.l.enU, new Object[] { Integer.valueOf(g.a.vPK.vOh.size()) }));
        }
      }
      this.vOY = false;
      bWF();
      GMTrace.o(2421422030848L, 18041);
      return;
      label149:
      bWl();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */