package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v4.view.m;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.ah.b;
import com.tencent.mm.e.a.qu;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.j;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.f.c.b;
import com.tencent.mm.ui.tools.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class l
{
  private static boolean uRD;
  public static final int uRP;
  public static boolean uRj;
  public ActionBar Gx;
  private int PROXIMITY_SCREEN_OFF_WAKE_LOCK;
  String className;
  public AudioManager iaU;
  public View ipa;
  private p kuK;
  public Context mContext;
  private int meR;
  private LayoutInflater mwN;
  protected ad oNC;
  private final long qpq;
  public long qpr;
  private boolean uRA;
  private a uRB;
  LinkedList<a> uRC;
  ArrayList<Dialog> uRE;
  View uRF;
  public TextView uRG;
  View uRH;
  public ImageView uRI;
  View uRJ;
  private TextView uRK;
  public int uRL;
  private boolean uRM;
  private c uRN;
  private int uRO;
  private int uRQ;
  public int uRR;
  private a uRS;
  private MenuItem uRT;
  private Runnable uRU;
  private Runnable uRV;
  protected boolean uRe;
  private View uRk;
  public View uRl;
  public View uRm;
  public TextView uRn;
  public FrameLayout uRo;
  public boolean uRp;
  String uRq;
  int uRr;
  int uRs;
  com.tencent.mm.ui.widget.d uRt;
  com.tencent.mm.ui.widget.d uRu;
  private com.tencent.mm.ui.widget.d uRv;
  private com.tencent.mm.ui.widget.d uRw;
  private boolean uRx;
  boolean uRy;
  public ActionBarActivity uRz;
  private PowerManager.WakeLock wakeLock;
  
  static
  {
    GMTrace.i(2550136832000L, 19000);
    uRj = false;
    uRD = false;
    uRP = a.h.hdz;
    GMTrace.o(2550136832000L, 19000);
  }
  
  public l()
  {
    GMTrace.i(2539533631488L, 18921);
    this.uRp = true;
    this.uRq = " ";
    this.uRr = 0;
    this.uRs = 0;
    this.uRt = null;
    this.uRu = null;
    this.uRv = null;
    this.uRw = null;
    this.uRx = false;
    this.uRy = false;
    this.meR = 0;
    this.uRe = false;
    this.oNC = new ad(Looper.getMainLooper());
    this.uRB = new a();
    this.uRC = new LinkedList();
    this.uRL = 0;
    this.uRM = false;
    this.uRN = new c() {};
    this.uRO = a.h.hdy;
    this.uRQ = -1;
    this.uRR = 0;
    this.wakeLock = null;
    this.PROXIMITY_SCREEN_OFF_WAKE_LOCK = 32;
    this.uRU = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3063251206144L, 22823);
        l.this.uRz.getWindow().setFlags(1024, 1024);
        if (l.this.Gx != null) {
          l.this.Gx.hide();
        }
        GMTrace.o(3063251206144L, 22823);
      }
    };
    this.uRV = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1597996269568L, 11906);
        if (l.this.Gx != null) {
          l.this.Gx.show();
        }
        GMTrace.o(1597996269568L, 11906);
      }
    };
    this.qpq = 300L;
    this.qpr = SystemClock.elapsedRealtime();
    GMTrace.o(2539533631488L, 18921);
  }
  
  public static void bPG()
  {
    GMTrace.i(2542486421504L, 18943);
    uRD = true;
    GMTrace.o(2542486421504L, 18943);
  }
  
  public static Locale et(Context paramContext)
  {
    GMTrace.i(2540070502400L, 18925);
    Object localObject = u.d(paramContext.getSharedPreferences(aa.bIN(), 0));
    Resources localResources = aa.getResources();
    if (((String)localObject).equals("language_default"))
    {
      u.a(paramContext, Locale.ENGLISH);
      if ((localResources instanceof com.tencent.mm.bh.a)) {
        ((com.tencent.mm.bh.a)localResources).bHu();
      }
      paramContext = Locale.getDefault();
      GMTrace.o(2540070502400L, 18925);
      return paramContext;
    }
    localObject = u.Pn((String)localObject);
    u.a(paramContext, (Locale)localObject);
    if ((localResources instanceof com.tencent.mm.bh.a)) {
      ((com.tencent.mm.bh.a)localResources).bHu();
    }
    GMTrace.o(2540070502400L, 18925);
    return (Locale)localObject;
  }
  
  private View findViewById(int paramInt)
  {
    GMTrace.i(2539802066944L, 18923);
    View localView = this.ipa.findViewById(paramInt);
    if (localView != null)
    {
      GMTrace.o(2539802066944L, 18923);
      return localView;
    }
    localView = this.uRz.findViewById(paramInt);
    GMTrace.o(2539802066944L, 18923);
    return localView;
  }
  
  private void kr(boolean paramBoolean)
  {
    GMTrace.i(2542352203776L, 18942);
    if ((!uRD) && (paramBoolean))
    {
      com.tencent.mm.ui.base.x.a(paramBoolean, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
      GMTrace.o(2542352203776L, 18942);
      return;
    }
    com.tencent.mm.ui.base.x.a(paramBoolean, new Intent().putExtra("classname", getClassName() + aFH()));
    GMTrace.o(2542352203776L, 18942);
  }
  
  private boolean zk(int paramInt)
  {
    GMTrace.i(2546915606528L, 18976);
    int i = 0;
    while (i < this.uRC.size())
    {
      if (((a)this.uRC.get(i)).uSc == paramInt)
      {
        v.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
        this.uRC.remove(i);
        GMTrace.o(2546915606528L, 18976);
        return true;
      }
      i += 1;
    }
    GMTrace.o(2546915606528L, 18976);
    return false;
  }
  
  public final void L(CharSequence paramCharSequence)
  {
    GMTrace.i(2544365469696L, 18957);
    if (this.Gx == null)
    {
      GMTrace.o(2544365469696L, 18957);
      return;
    }
    this.uRq = paramCharSequence.toString();
    this.uRG.setText(paramCharSequence);
    if (com.tencent.mm.bg.a.dM(this.uRz)) {
      this.uRG.setTextSize(0, com.tencent.mm.bg.a.U(this.uRz, a.e.aWx) * com.tencent.mm.bg.a.dK(this.uRz));
    }
    SE(paramCharSequence.toString());
    GMTrace.o(2544365469696L, 18957);
  }
  
  public final void SD(String paramString)
  {
    GMTrace.i(2544768122880L, 18960);
    if (this.Gx == null)
    {
      GMTrace.o(2544768122880L, 18960);
      return;
    }
    if (paramString == null)
    {
      this.uRK.setVisibility(8);
      GMTrace.o(2544768122880L, 18960);
      return;
    }
    this.uRK.setText(paramString);
    if (com.tencent.mm.bg.a.dM(this.uRz))
    {
      this.uRK.setTextSize(1, 14.0F);
      this.uRG.setTextSize(1, 18.0F);
    }
    this.uRK.setVisibility(0);
    SE(paramString);
    GMTrace.o(2544768122880L, 18960);
  }
  
  protected final void SE(String paramString)
  {
    GMTrace.i(2544499687424L, 18958);
    com.tencent.mm.ui.a.a locala = a.a.uVh;
    ActionBarActivity localActionBarActivity = this.uRz;
    if (!locala.bQx())
    {
      if ((bf.mA(paramString)) || (localActionBarActivity == null))
      {
        GMTrace.o(2544499687424L, 18958);
        return;
      }
      paramString = localActionBarActivity.getString(a.k.heV) + paramString;
      localActionBarActivity.getWindow().getDecorView().setContentDescription(paramString);
    }
    GMTrace.o(2544499687424L, 18958);
  }
  
  protected abstract void Sz();
  
  public boolean WV()
  {
    GMTrace.i(2540607373312L, 18929);
    GMTrace.o(2540607373312L, 18929);
    return false;
  }
  
  final void Z(Activity paramActivity)
  {
    GMTrace.i(2540741591040L, 18930);
    if ((this.Gx != null) && (!WV()))
    {
      if (Build.VERSION.SDK_INT < 11) {
        this.Gx.setBackgroundDrawable(new ColorDrawable(this.mContext.getResources().getColor(a.d.aSD)));
      }
      v.d("MicroMsg.MMActivityController", "onCreate, after");
      this.Gx.setLogo(new ColorDrawable(this.uRz.getResources().getColor(17170445)));
      this.Gx.cK();
      this.Gx.setDisplayHomeAsUpEnabled(false);
      this.Gx.cJ();
      this.Gx.cL();
      this.Gx.setIcon(a.f.bkQ);
      if (this.uRQ == -1) {
        this.Gx.setCustomView(r.eC(this.uRz).inflate(this.uRO, new LinearLayout(this.uRz), false));
      }
      for (;;)
      {
        this.uRG = ((TextView)findViewById(16908308));
        this.uRK = ((TextView)findViewById(16908309));
        this.uRF = findViewById(a.g.divider);
        this.uRH = findViewById(a.g.bnd);
        this.uRI = ((ImageView)findViewById(a.g.bne));
        if (this.uRI != null) {
          this.uRI.setContentDescription(this.uRz.getString(a.k.dDf));
        }
        this.uRJ = findViewById(a.g.hbP);
        if (this.uRG != null) {
          this.uRG.setText(a.k.bpC);
        }
        if (paramActivity.getClass().getName() != "WebViewUI") {
          break;
        }
        if (this.uRJ != null) {
          this.uRJ.setVisibility(8);
        }
        if (this.uRI != null) {
          this.uRI.setVisibility(0);
        }
        if (this.uRH == null) {
          break label520;
        }
        this.uRH.setVisibility(0);
        GMTrace.o(2540741591040L, 18930);
        return;
        this.Gx.setCustomView(r.eC(this.uRz).inflate(this.uRQ, new LinearLayout(this.uRz), false));
      }
      if ((paramActivity instanceof MMActivity))
      {
        if (this.uRJ != null) {
          this.uRJ.setVisibility(8);
        }
        if (this.uRI != null) {
          this.uRI.setVisibility(0);
        }
        if (this.uRH != null) {
          this.uRH.setVisibility(0);
        }
        if (this.uRG != null)
        {
          this.uRG.setVisibility(0);
          GMTrace.o(2540741591040L, 18930);
        }
      }
      else
      {
        if (this.uRJ != null) {
          this.uRJ.setVisibility(0);
        }
        if (this.uRI != null) {
          this.uRI.setVisibility(8);
        }
        if (this.uRH != null) {
          this.uRH.setVisibility(8);
        }
      }
    }
    label520:
    GMTrace.o(2540741591040L, 18930);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2546512953344L, 18973);
    a(paramInt1, paramInt3, this.mContext.getString(paramInt2), paramOnMenuItemClickListener, null, b.uSi);
    GMTrace.o(2546512953344L, 18973);
  }
  
  public final void a(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2546244517888L, 18971);
    a(paramInt1, paramInt2, "", paramOnMenuItemClickListener, null, b.uSi);
    GMTrace.o(2546244517888L, 18971);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, int paramInt3)
  {
    GMTrace.i(2547184041984L, 18978);
    a locala = new a();
    locala.uSc = paramInt1;
    locala.uSd = paramInt2;
    locala.text = paramString;
    locala.oTr = paramOnMenuItemClickListener;
    locala.lJL = paramOnLongClickListener;
    locala.uSh = paramInt3;
    if ((locala.uSd == a.f.bha) && (bf.mA(paramString))) {
      locala.text = this.mContext.getString(a.k.heU);
    }
    zk(locala.uSc);
    this.uRC.add(locala);
    new ad().postDelayed(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2897223876608L, 21586);
        l.this.aQ();
        GMTrace.o(2897223876608L, 21586);
      }
    }, 200L);
    GMTrace.o(2547184041984L, 18978);
  }
  
  public final void a(int paramInt, String paramString, Drawable paramDrawable, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2546378735616L, 18972);
    int i = b.uSi;
    a locala = new a();
    locala.uSc = paramInt;
    locala.uSe = paramDrawable;
    locala.text = paramString;
    locala.oTr = paramOnMenuItemClickListener;
    locala.lJL = null;
    locala.uSh = i;
    zk(locala.uSc);
    this.uRC.add(locala);
    new ad().postDelayed(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(2536849276928L, 18901);
        l.this.aQ();
        GMTrace.o(2536849276928L, 18901);
      }
    }, 200L);
    GMTrace.o(2546378735616L, 18972);
  }
  
  public final void a(int paramInt1, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, int paramInt2)
  {
    GMTrace.i(2546110300160L, 18970);
    a(paramInt1, 0, paramString, paramOnMenuItemClickListener, null, paramInt2);
    GMTrace.o(2546110300160L, 18970);
  }
  
  public final void a(int paramInt1, final boolean paramBoolean1, final String paramString1, final String paramString2, final String paramString3, final int paramInt2, boolean paramBoolean2)
  {
    GMTrace.i(2539667849216L, 18922);
    v.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString3, Integer.valueOf(paramInt2), this.uRm });
    if (!byc())
    {
      GMTrace.o(2539667849216L, 18922);
      return;
    }
    if ((!paramBoolean1) && (this.uRm == null))
    {
      GMTrace.o(2539667849216L, 18922);
      return;
    }
    if ((this.Gx != null) && (!this.Gx.isShowing()))
    {
      v.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
      GMTrace.o(2539667849216L, 18922);
      return;
    }
    if (this.uRo == null) {
      this.uRo = ((FrameLayout)this.ipa.findViewById(a.g.cka));
    }
    if (this.uRm != null) {
      this.uRo.removeView(this.uRm);
    }
    int i = a.h.djk;
    if (paramInt1 > 0) {}
    for (;;)
    {
      this.uRm = this.mwN.inflate(paramInt1, null);
      this.uRn = ((TextView)this.uRm.findViewById(a.g.coL));
      this.uRm.findViewById(a.g.hcC).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2530675261440L, 18855);
          paramAnonymousView = new ah();
          paramAnonymousView.fDo.type = 1;
          paramAnonymousView.fDo.fDq = paramString3;
          paramAnonymousView.fDo.position = paramInt2;
          com.tencent.mm.sdk.b.a.uql.m(paramAnonymousView);
          l.this.uRm.setVisibility(8);
          GMTrace.o(2530675261440L, 18855);
        }
      });
      this.uRm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3467112349696L, 25832);
          if (paramString1 != null)
          {
            paramAnonymousView = new Intent("android.intent.action.VIEW");
            paramAnonymousView.setData(Uri.parse(paramString1));
            l.this.mContext.startActivity(paramAnonymousView);
          }
          GMTrace.o(3467112349696L, 25832);
        }
      });
      paramString3 = new FrameLayout.LayoutParams(-1, -2);
      if ((this.uRM) && (Build.VERSION.SDK_INT >= 16))
      {
        paramString3.setMargins(0, BackwardSupportUtil.b.a(this.uRz, 48.0F), 0, 0);
        v.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", new Object[] { Integer.valueOf(paramString3.height), Integer.valueOf(paramString3.topMargin) });
      }
      this.uRo.addView(this.uRm, this.uRo.getChildCount(), paramString3);
      if (this.uRm != null)
      {
        if (paramBoolean2)
        {
          paramString3 = this.uRm;
          if (paramBoolean1)
          {
            paramInt1 = 0;
            paramString3.setVisibility(paramInt1);
            String str = this.mContext.getString(a.k.heY);
            paramString3 = paramString2;
            if (bf.mA(paramString2)) {
              paramString3 = this.mContext.getString(a.k.ebv);
            }
            if (paramString1 == null) {
              break label539;
            }
            paramString1 = new SpannableString(paramString3 + str);
            paramString2 = new ForegroundColorSpan(-10119449);
            paramInt1 = paramString3.length();
            paramInt2 = paramString3.length();
            paramString1.setSpan(paramString2, paramInt1, str.length() + paramInt2, 33);
            this.uRn.setText(paramString1);
          }
          for (;;)
          {
            this.uRm.invalidate();
            this.uRo.invalidate();
            GMTrace.o(2539667849216L, 18922);
            return;
            paramInt1 = 8;
            break;
            label539:
            v.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
            this.uRn.setText(paramString3);
          }
        }
        this.uRm.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(3470467792896L, 25857);
            Object localObject = l.this.uRm;
            int i;
            if (paramBoolean1)
            {
              i = 0;
              ((View)localObject).setVisibility(i);
              String str = l.this.mContext.getString(a.k.heY);
              if (!bf.mA(paramString2)) {
                break label180;
              }
              localObject = l.this.mContext.getString(a.k.ebv);
              label69:
              if (paramString1 == null) {
                break label188;
              }
              SpannableString localSpannableString = new SpannableString((String)localObject + str);
              localSpannableString.setSpan(new ForegroundColorSpan(-10119449), ((String)localObject).length(), ((String)localObject).length() + str.length(), 33);
              l.this.uRn.setText(localSpannableString);
            }
            for (;;)
            {
              l.this.uRm.invalidate();
              l.this.uRo.invalidate();
              GMTrace.o(3470467792896L, 25857);
              return;
              i = 8;
              break;
              label180:
              localObject = paramString2;
              break label69;
              label188:
              v.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
              l.this.uRn.setText((CharSequence)localObject);
            }
          }
        });
      }
      GMTrace.o(2539667849216L, 18922);
      return;
      paramInt1 = i;
    }
  }
  
  public final void a(Context paramContext, ActionBarActivity paramActionBarActivity)
  {
    GMTrace.i(2540473155584L, 18928);
    this.mContext = paramActionBarActivity;
    this.uRz = paramActionBarActivity;
    Sz();
    this.className = getClass().getName();
    w.aB(3, this.className);
    et(paramContext);
    this.iaU = ((AudioManager)this.mContext.getSystemService("audio"));
    int i = getLayoutId();
    this.mwN = LayoutInflater.from(this.mContext);
    this.ipa = this.mwN.inflate(a.h.hdO, null);
    this.uRk = this.ipa.findViewById(a.g.hcy);
    this.uRo = ((FrameLayout)this.ipa.findViewById(a.g.cka));
    this.meR = this.mContext.getResources().getDimensionPixelSize(a.e.hby);
    label313:
    label410:
    long l;
    String str;
    if (i != -1)
    {
      this.uRl = bPQ();
      if (this.uRl == null)
      {
        this.uRl = this.mwN.inflate(getLayoutId(), null);
        this.uRo.addView(this.uRl, 0);
      }
    }
    else
    {
      bF(this.ipa);
      if (bPE())
      {
        x.d(x.a(this.uRz.getWindow(), this.uRl), this.uRl);
        ((ViewGroup)this.uRl.getParent()).removeView(this.uRl);
        ((ViewGroup)this.uRz.getWindow().getDecorView()).addView(this.uRl, 0);
        int j = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 25);
        paramContext = this.mContext.getResources().getDisplayMetrics();
        if (paramContext.widthPixels <= paramContext.heightPixels) {
          break label660;
        }
        i = this.mContext.getResources().getDimensionPixelSize(a.e.aWQ);
        this.uRl.setPadding(this.uRl.getPaddingLeft(), i + (j + this.uRl.getPaddingTop()), this.uRl.getPaddingRight(), this.uRl.getPaddingBottom());
      }
      this.Gx = cP();
      v.d("MicroMsg.MMActivityController", "onCreate, before.");
      Z(paramActionBarActivity);
      if ((this.uRo == null) || (!(this.uRo instanceof LayoutListenerView))) {
        break label677;
      }
      ((LayoutListenerView)this.uRo).uQV = new LayoutListenerView.a()
      {
        private final int uRZ;
        
        public final void onSizeChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          GMTrace.i(3089021009920L, 23015);
          if ((l.this.uRz.getWindow().getAttributes().flags & 0x400) != 0) {}
          for (int i = 1; i != 0; i = 0)
          {
            GMTrace.o(3089021009920L, 23015);
            return;
          }
          if ((paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0) && (paramAnonymousInt3 != 0) && (paramAnonymousInt4 != 0) && (paramAnonymousInt1 == paramAnonymousInt3))
          {
            l locall;
            if ((paramAnonymousInt2 > paramAnonymousInt4) && (paramAnonymousInt2 - paramAnonymousInt4 > this.uRZ))
            {
              locall = l.this;
              locall.uRR = 2;
              locall.bil();
              GMTrace.o(3089021009920L, 23015);
              return;
            }
            if ((paramAnonymousInt4 > paramAnonymousInt2) && (paramAnonymousInt4 - paramAnonymousInt2 > this.uRZ))
            {
              locall = l.this;
              locall.uRR = 1;
              locall.bil();
            }
          }
          GMTrace.o(3089021009920L, 23015);
        }
      };
      paramContext = new ah();
      paramContext.fDo.type = 2;
      paramContext.fDo.position = this.uRL;
      com.tencent.mm.sdk.b.a.uql.m(paramContext);
      if (paramContext.fDp.fDs == 2)
      {
        l = System.currentTimeMillis();
        str = paramContext.fDp.fDv;
        i = paramContext.fDp.position;
        v.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", new Object[] { Integer.valueOf(i), str, bf.bJP() });
        if ((i <= 0) || (i == this.uRL)) {
          break label689;
        }
        v.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.uRL) });
      }
    }
    for (;;)
    {
      v.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - l));
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramContext = paramActionBarActivity.getWindow();
        paramContext.clearFlags(201326592);
        paramContext.addFlags(Integer.MIN_VALUE);
        paramContext.setStatusBarColor(paramActionBarActivity.getResources().getColor(a.d.aVV));
      }
      GMTrace.o(2540473155584L, 18928);
      return;
      if (this.uRl.getParent() == null) {
        break;
      }
      ((ViewGroup)this.uRl.getParent()).removeView(this.uRl);
      break;
      label660:
      i = this.mContext.getResources().getDimensionPixelSize(a.e.aWR);
      break label313;
      label677:
      v.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
      break label410;
      label689:
      a(paramContext.fDp.fDu, paramContext.fDp.visible, paramContext.fDp.url, paramContext.fDp.desc, str, i, true);
    }
  }
  
  public final void a(final MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    GMTrace.i(2546647171072L, 18974);
    if (this.Gx == null)
    {
      GMTrace.o(2546647171072L, 18974);
      return;
    }
    if (paramOnMenuItemClickListener == null) {
      this.Gx.setDisplayHomeAsUpEnabled(false);
    }
    for (;;)
    {
      if ((this.uRI != null) && (paramInt != 0)) {
        this.uRI.setImageResource(paramInt);
      }
      this.uRB.uSc = 16908332;
      this.uRB.oTr = paramOnMenuItemClickListener;
      GMTrace.o(2546647171072L, 18974);
      return;
      this.Gx.setDisplayHomeAsUpEnabled(false);
      if (this.uRH != null) {
        this.uRH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(3078015156224L, 22933);
            paramOnMenuItemClickListener.onMenuItemClick(null);
            GMTrace.o(3078015156224L, 22933);
          }
        });
      }
    }
  }
  
  public final void a(MenuItem paramMenuItem, a parama)
  {
    GMTrace.i(2543291727872L, 18949);
    if (!this.uRp)
    {
      v.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
      GMTrace.o(2543291727872L, 18949);
      return;
    }
    if (parama.oTr != null) {
      parama.oTr.onMenuItemClick(paramMenuItem);
    }
    GMTrace.o(2543291727872L, 18949);
  }
  
  final void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    GMTrace.i(2545707646976L, 18967);
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.uRC.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (!localIterator.hasNext()) {
        break label134;
      }
      locala = (a)localIterator.next();
      if (locala.fFL == paramBoolean2) {
        break label210;
      }
      locala.fFL = paramBoolean2;
      paramBoolean1 = true;
    }
    label134:
    label207:
    label210:
    for (;;)
    {
      break;
      localIterator = this.uRC.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.uSc != paramInt) || (locala.fFL == paramBoolean2)) {
          break label207;
        }
        locala.fFL = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        if (this.kuK == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.kuK.wlT)
        {
          if (!paramBoolean1) {
            aQ();
          }
          v.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          GMTrace.o(2545707646976L, 18967);
          return;
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean, p paramp)
  {
    GMTrace.i(2545976082432L, 18969);
    v.v("MicroMsg.MMActivityController", "add search menu");
    a locala = new a();
    locala.uSc = a.g.cjD;
    locala.text = this.mContext.getString(a.k.dIr);
    locala.uSd = a.j.dsL;
    locala.oTr = null;
    locala.lJL = null;
    zi(locala.uSc);
    this.uRC.add(0, locala);
    this.uRA = paramBoolean;
    this.kuK = paramp;
    aQ();
    GMTrace.o(2545976082432L, 18969);
  }
  
  protected abstract String aFH();
  
  public final void aHc()
  {
    GMTrace.i(2547989348352L, 18984);
    Object localObject = this.uRz;
    InputMethodManager localInputMethodManager = (InputMethodManager)((Activity)localObject).getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      localObject = ((Activity)localObject).getCurrentFocus();
      if ((localObject != null) && (((View)localObject).getWindowToken() != null)) {
        localInputMethodManager.toggleSoftInput(0, 2);
      }
    }
    GMTrace.o(2547989348352L, 18984);
  }
  
  public void aQ()
  {
    GMTrace.i(2545304993792L, 18964);
    this.uRz.aQ();
    GMTrace.o(2545304993792L, 18964);
  }
  
  public final void ag(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2539936284672L, 18924);
    this.uRL = paramInt;
    this.uRM = paramBoolean;
    GMTrace.o(2539936284672L, 18924);
  }
  
  public final boolean aqY()
  {
    GMTrace.i(2547720912896L, 18982);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.mContext.getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      GMTrace.o(2547720912896L, 18982);
      return false;
    }
    Object localObject = this.uRz.getCurrentFocus();
    if (localObject == null)
    {
      GMTrace.o(2547720912896L, 18982);
      return false;
    }
    localObject = ((View)localObject).getWindowToken();
    if (localObject == null)
    {
      GMTrace.o(2547720912896L, 18982);
      return false;
    }
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow((IBinder)localObject, 0);
      v.v("MicroMsg.MMActivityController", "hide VKB result %B", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(2547720912896L, 18982);
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        v.e("MicroMsg.MMActivityController", "hide VKB exception %s", new Object[] { localIllegalArgumentException });
        boolean bool = false;
      }
    }
  }
  
  final void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    GMTrace.i(2545841864704L, 18968);
    Iterator localIterator;
    boolean bool;
    a locala;
    if (paramBoolean1)
    {
      localIterator = this.uRC.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (!localIterator.hasNext()) {
        break label134;
      }
      locala = (a)localIterator.next();
      if (locala.visible == paramBoolean2) {
        break label215;
      }
      locala.visible = paramBoolean2;
      paramBoolean1 = true;
    }
    label134:
    label212:
    label215:
    for (;;)
    {
      break;
      localIterator = this.uRC.iterator();
      paramBoolean1 = false;
      bool = paramBoolean1;
      if (localIterator.hasNext())
      {
        locala = (a)localIterator.next();
        if ((locala.uSc != paramInt) || (locala.visible == paramBoolean2)) {
          break label212;
        }
        locala.visible = paramBoolean2;
        paramBoolean1 = true;
      }
      for (;;)
      {
        break;
        if (this.kuK == null) {}
        for (paramBoolean1 = false;; paramBoolean1 = this.kuK.wlT)
        {
          if ((bool) && (!paramBoolean1)) {
            aQ();
          }
          v.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean1) });
          GMTrace.o(2545841864704L, 18968);
          return;
        }
      }
    }
  }
  
  protected abstract void bF(View paramView);
  
  protected abstract boolean bPE();
  
  protected abstract View bPQ();
  
  public final boolean bPR()
  {
    GMTrace.i(2541546897408L, 18936);
    boolean bool = this.uRe;
    GMTrace.o(2541546897408L, 18936);
    return bool;
  }
  
  public final boolean bPS()
  {
    GMTrace.i(2543157510144L, 18948);
    if ((this.uRB != null) && (this.uRB.fFL))
    {
      a(null, this.uRB);
      GMTrace.o(2543157510144L, 18948);
      return true;
    }
    GMTrace.o(2543157510144L, 18948);
    return false;
  }
  
  final void bPT()
  {
    GMTrace.i(2545170776064L, 18963);
    Object localObject1 = "%s";
    int n = this.mContext.getResources().getDimensionPixelSize(a.e.aWD);
    if (this.uRr != 0) {
      localObject1 = "# " + "%s";
    }
    if (this.uRs != 0) {
      localObject1 = (String)localObject1 + " #";
    }
    for (int i = 1;; i = 0)
    {
      int j;
      if (this.uRx)
      {
        localObject1 = (String)localObject1 + " #";
        j = i + 2;
      }
      for (i = 1;; i = 0)
      {
        int m;
        int k;
        if (this.uRy)
        {
          localObject1 = (String)localObject1 + " #";
          m = 1;
          k = j + 2;
          j = i + 2;
        }
        for (i = m;; i = m)
        {
          Object localObject2 = String.format((String)localObject1, new Object[] { this.uRq });
          v.v("MicroMsg.MMActivityController", "span title format %s", new Object[] { localObject1 });
          localObject1 = b.a(this.mContext, (CharSequence)localObject2, n);
          if ((localObject1 instanceof SpannableString))
          {
            localObject2 = (SpannableString)localObject1;
            if (this.uRr != 0) {
              ((SpannableString)localObject2).setSpan(this.uRt, 0, 1, 33);
            }
            if (this.uRs != 0)
            {
              k = ((SpannableString)localObject2).length() - k;
              ((SpannableString)localObject2).setSpan(this.uRu, k, k + 1, 33);
            }
            if (this.uRx)
            {
              if (this.uRv == null) {
                this.uRv = dT(n, a.j.heL);
              }
              j = ((SpannableString)localObject2).length() - j;
              ((SpannableString)localObject2).setSpan(this.uRv, j, j + 1, 33);
            }
            if (this.uRy)
            {
              if (this.uRw == null) {
                this.uRw = dT(n, a.j.heM);
              }
              i = ((SpannableString)localObject2).length() - i;
              ((SpannableString)localObject2).setSpan(this.uRw, i, i + 1, 33);
            }
          }
          this.uRG.setText((CharSequence)localObject1);
          GMTrace.o(2545170776064L, 18963);
          return;
          k = j;
          m = 0;
          j = i;
        }
        j = i;
      }
    }
  }
  
  public boolean bPU()
  {
    GMTrace.i(2545439211520L, 18965);
    GMTrace.o(2545439211520L, 18965);
    return false;
  }
  
  public final void bPV()
  {
    GMTrace.i(2546781388800L, 18975);
    if (this.uRC.isEmpty())
    {
      GMTrace.o(2546781388800L, 18975);
      return;
    }
    this.uRC.clear();
    aQ();
    GMTrace.o(2546781388800L, 18975);
  }
  
  public final void bPW()
  {
    boolean bool = true;
    GMTrace.i(2547452477440L, 18980);
    if (this.Gx != null) {}
    for (;;)
    {
      v.v("MicroMsg.MMActivityController", "hideTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (this.Gx != null) {
        break;
      }
      GMTrace.o(2547452477440L, 18980);
      return;
      bool = false;
    }
    this.Gx.hide();
    GMTrace.o(2547452477440L, 18980);
  }
  
  public abstract void bil();
  
  public boolean byc()
  {
    GMTrace.i(2541949550592L, 18939);
    GMTrace.o(2541949550592L, 18939);
    return true;
  }
  
  public ActionBar cP()
  {
    GMTrace.i(2540338937856L, 18927);
    ActionBar localActionBar = this.uRz.cO().cP();
    GMTrace.o(2540338937856L, 18927);
    return localActionBar;
  }
  
  public final void cT(boolean paramBoolean)
  {
    GMTrace.i(2541278461952L, 18934);
    this.uRp = paramBoolean;
    if ((this.uRk == null) && (this.ipa != null)) {
      this.uRk = this.ipa.findViewById(a.g.hcy);
    }
    if (this.uRk == null)
    {
      v.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
      GMTrace.o(2541278461952L, 18934);
      return;
    }
    Object localObject = this.uRk;
    if (!paramBoolean)
    {
      bool = true;
      ((View)localObject).setFocusable(bool);
      localObject = this.uRk;
      if (paramBoolean) {
        break label169;
      }
    }
    label169:
    for (boolean bool = true;; bool = false)
    {
      ((View)localObject).setFocusableInTouchMode(bool);
      if (paramBoolean) {
        break label174;
      }
      localObject = this.uRz;
      if (this.wakeLock == null)
      {
        uRj = true;
        this.wakeLock = ((PowerManager)((Context)localObject).getSystemService("power")).newWakeLock(this.PROXIMITY_SCREEN_OFF_WAKE_LOCK, "screen Lock");
        this.wakeLock.acquire();
      }
      GMTrace.o(2541278461952L, 18934);
      return;
      bool = false;
      break;
    }
    label174:
    if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
    {
      uRj = false;
      this.wakeLock.release();
      this.wakeLock = null;
    }
    GMTrace.o(2541278461952L, 18934);
  }
  
  public final boolean cV(View paramView)
  {
    GMTrace.i(2547855130624L, 18983);
    if (paramView == null)
    {
      GMTrace.o(2547855130624L, 18983);
      return false;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.mContext.getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      GMTrace.o(2547855130624L, 18983);
      return false;
    }
    paramView = paramView.getWindowToken();
    if (paramView == null)
    {
      GMTrace.o(2547855130624L, 18983);
      return false;
    }
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow(paramView, 0);
      GMTrace.o(2547855130624L, 18983);
      return bool;
    }
    catch (IllegalArgumentException paramView)
    {
      for (;;)
      {
        v.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
  }
  
  public final void d(boolean paramBoolean, long paramLong)
  {
    GMTrace.i(2544097034240L, 18955);
    if (paramBoolean)
    {
      if (this.Gx != null) {
        this.Gx.hide();
      }
      this.oNC.removeCallbacks(this.uRV);
      this.oNC.removeCallbacks(this.uRU);
      this.oNC.postDelayed(this.uRU, paramLong);
      GMTrace.o(2544097034240L, 18955);
      return;
    }
    this.uRz.getWindow().clearFlags(1024);
    this.oNC.removeCallbacks(this.uRU);
    this.oNC.removeCallbacks(this.uRV);
    this.oNC.postDelayed(this.uRV, paramLong);
    GMTrace.o(2544097034240L, 18955);
  }
  
  final com.tencent.mm.ui.widget.d dT(int paramInt1, int paramInt2)
  {
    GMTrace.i(2545036558336L, 18962);
    Drawable localDrawable = this.mContext.getResources().getDrawable(paramInt2);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    com.tencent.mm.ui.widget.d locald = new com.tencent.mm.ui.widget.d(localDrawable);
    locald.wsv = ((localDrawable.getIntrinsicHeight() - paramInt1) / 2);
    GMTrace.o(2545036558336L, 18962);
    return locald;
  }
  
  protected abstract String getClassName();
  
  protected abstract int getLayoutId();
  
  public final void km(boolean paramBoolean)
  {
    GMTrace.i(2543962816512L, 18954);
    if (paramBoolean)
    {
      if (this.Gx != null) {
        this.Gx.hide();
      }
      this.oNC.removeCallbacks(this.uRV);
      this.oNC.removeCallbacks(this.uRU);
      this.oNC.postDelayed(this.uRU, 256L);
      GMTrace.o(2543962816512L, 18954);
      return;
    }
    this.uRz.getWindow().clearFlags(1024);
    this.oNC.removeCallbacks(this.uRU);
    this.oNC.removeCallbacks(this.uRV);
    this.oNC.postDelayed(this.uRV, 256L);
    GMTrace.o(2543962816512L, 18954);
  }
  
  public final void kn(boolean paramBoolean)
  {
    GMTrace.i(2545573429248L, 18966);
    if (this.uRB == null)
    {
      GMTrace.o(2545573429248L, 18966);
      return;
    }
    if (this.uRB.fFL != paramBoolean)
    {
      this.uRB.fFL = paramBoolean;
      aQ();
    }
    GMTrace.o(2545573429248L, 18966);
  }
  
  public final boolean onCreateOptionsMenu(Menu paramMenu)
  {
    GMTrace.i(2542754856960L, 18945);
    v.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.uRC.size()) });
    if ((this.Gx == null) || (this.uRC.size() == 0))
    {
      v.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.uRC.size()) });
      GMTrace.o(2542754856960L, 18945);
      return false;
    }
    this.uRS = null;
    this.uRT = null;
    int i = this.Gx.getHeight();
    Object localObject1;
    if (i == 0)
    {
      localObject1 = this.mContext.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject1).widthPixels > ((DisplayMetrics)localObject1).heightPixels) {
        i = this.mContext.getResources().getDimensionPixelSize(a.e.aWQ);
      }
    }
    for (;;)
    {
      Iterator localIterator = this.uRC.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          final a locala = (a)localIterator.next();
          if (locala.uSc == 16908332)
          {
            v.v("MicroMsg.MMActivityController", "match back option menu, continue");
            continue;
            i = this.mContext.getResources().getDimensionPixelSize(a.e.aWR);
            break;
          }
          if (locala.uSc == a.g.cjD)
          {
            boolean bool2 = this.uRA;
            if (this.kuK == null) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              v.v("MicroMsg.MMActivityController", "match search menu, enable search view[%B], search view helper is null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
              if ((!this.uRA) || (this.kuK == null)) {
                break;
              }
              this.kuK.a(this.uRz, paramMenu);
              break;
            }
          }
          final MenuItem localMenuItem = paramMenu.add(0, locala.uSc, 0, locala.text);
          localObject1 = getClass().getName();
          label355:
          View.OnClickListener local10;
          View.OnLongClickListener local11;
          label477:
          label498:
          Object localObject2;
          if (localMenuItem == null)
          {
            v.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
            local10 = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                GMTrace.i(2067087228928L, 15401);
                l.this.a(localMenuItem, locala);
                GMTrace.o(2067087228928L, 15401);
              }
            };
            local11 = new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                GMTrace.i(2550673702912L, 19004);
                l locall = l.this;
                l.a locala = locala;
                if (!locall.uRp)
                {
                  v.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
                  GMTrace.o(2550673702912L, 19004);
                  return true;
                }
                if (locala.lJL != null)
                {
                  boolean bool = locala.lJL.onLongClick(paramAnonymousView);
                  GMTrace.o(2550673702912L, 19004);
                  return bool;
                }
                GMTrace.o(2550673702912L, 19004);
                return false;
              }
            };
            if ((locala.uSd == 0) && (locala.uSe == null)) {
              break label859;
            }
            if (locala.lJL == null) {
              break label819;
            }
            int j = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 56);
            if (locala.uSg != null) {
              break label793;
            }
            localObject1 = new ImageButton(this.mContext);
            ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(j, i));
            ((View)localObject1).setBackgroundResource(a.f.bbD);
            ((View)localObject1).setMinimumHeight(i);
            ((View)localObject1).setMinimumWidth(j);
            locala.uSg = ((View)localObject1);
            if (locala.uSe == null) {
              break label803;
            }
            ((ImageButton)localObject1).setImageDrawable(locala.uSe);
            m.a(localMenuItem, (View)localObject1);
            localObject2 = ((View)localObject1).getLayoutParams();
            ((ViewGroup.LayoutParams)localObject2).width = j;
            ((ViewGroup.LayoutParams)localObject2).height = i;
            ((View)localObject1).setOnClickListener(local10);
            ((View)localObject1).setOnLongClickListener(local11);
            ((View)localObject1).setEnabled(locala.fFL);
            ((View)localObject1).setContentDescription(locala.text);
          }
          for (;;)
          {
            localMenuItem.setEnabled(locala.fFL);
            localMenuItem.setVisible(locala.visible);
            m.a(localMenuItem, 2);
            if (locala.uSd == a.f.bha)
            {
              this.uRS = locala;
              this.uRT = localMenuItem;
            }
            v.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", new Object[] { Integer.valueOf(locala.uSc), locala.text, Boolean.valueOf(locala.fFL), Boolean.valueOf(locala.visible) });
            break;
            if (localMenuItem.getTitleCondensed() == null)
            {
              v.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", new Object[] { localObject1 });
              localMenuItem.setTitleCondensed("");
              break label355;
            }
            if ((localMenuItem.getTitleCondensed() instanceof String)) {
              break label355;
            }
            v.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", new Object[] { localObject1, localMenuItem.getTitleCondensed().getClass().getName(), localMenuItem.getTitleCondensed() });
            localMenuItem.setTitleCondensed(localMenuItem.getTitleCondensed().toString());
            break label355;
            label793:
            localObject1 = locala.uSg;
            break label477;
            label803:
            ((ImageButton)localObject1).setImageResource(locala.uSd);
            break label498;
            label819:
            if (locala.uSe != null) {
              localMenuItem.setIcon(locala.uSe);
            } else {
              localMenuItem.setIcon(locala.uSd);
            }
          }
          label859:
          if (locala.uSf == null) {
            locala.uSf = View.inflate(this.mContext, a.h.cTr, null);
          }
          if (locala.uSh == b.uSk)
          {
            locala.uSf.findViewById(a.g.bmQ).setVisibility(8);
            locala.uSf.findViewById(a.g.divider).setVisibility(8);
            localObject1 = (TextView)locala.uSf.findViewById(a.g.bmR);
            ((TextView)localObject1).setBackgroundResource(a.f.bdb);
            ((TextView)localObject1).setPadding(this.meR, 0, this.meR, 0);
          }
          for (;;)
          {
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setText(locala.text);
            ((TextView)localObject1).setOnClickListener(local10);
            ((TextView)localObject1).setOnLongClickListener(local11);
            ((TextView)localObject1).setEnabled(locala.fFL);
            m.a(localMenuItem, locala.uSf);
            break;
            if (locala.uSh == b.uSj)
            {
              locala.uSf.findViewById(a.g.bmQ).setVisibility(8);
              locala.uSf.findViewById(a.g.divider).setVisibility(8);
              localObject1 = (TextView)locala.uSf.findViewById(a.g.bmR);
              ((TextView)localObject1).setBackgroundResource(a.f.bcZ);
              ((TextView)localObject1).setPadding(this.meR, 0, this.meR, 0);
            }
            else if (locala.uSh == b.uSl)
            {
              locala.uSf.findViewById(a.g.bmQ).setVisibility(8);
              locala.uSf.findViewById(a.g.divider).setVisibility(8);
              localObject1 = (TextView)locala.uSf.findViewById(a.g.bmR);
              ((TextView)locala.uSf.findViewById(a.g.bmR)).setTextColor(-8393929);
              ((TextView)localObject1).setBackgroundResource(a.f.hbJ);
              ((TextView)localObject1).setPadding(this.meR, 0, this.meR, 0);
              locala.uSf.setBackgroundColor(-16777216);
            }
            else if ((locala.uSh == b.uSm) || (locala.uSh == b.uSn) || (locala.uSh == b.uSo) || (locala.uSh == b.uSq))
            {
              locala.uSf.findViewById(a.g.bmR).setVisibility(8);
              locala.uSf.findViewById(a.g.divider).setVisibility(8);
              localObject2 = (TextView)locala.uSf.findViewById(a.g.bmQ);
              if (locala.uSh == b.uSn)
              {
                ((TextView)localObject2).setTextColor(this.uRz.getResources().getColor(a.d.hbr));
                localObject1 = localObject2;
              }
              else if (locala.uSh == b.uSo)
              {
                ((TextView)localObject2).setTextColor(this.uRz.getResources().getColor(a.d.aWt));
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = localObject2;
                if (locala.uSh == b.uSq)
                {
                  ((TextView)localObject2).setTextColor(this.uRz.getResources().getColor(a.d.hbl));
                  localObject1 = localObject2;
                }
              }
            }
            else if (locala.uSh == b.uSp)
            {
              locala.uSf.findViewById(a.g.bmQ).setVisibility(8);
              locala.uSf.findViewById(a.g.divider).setVisibility(8);
              localObject1 = (TextView)locala.uSf.findViewById(a.g.bmR);
              ((TextView)localObject1).setBackgroundResource(a.f.hbA);
              ((TextView)localObject1).setPadding(this.meR, 0, this.meR, 0);
              ((TextView)localObject1).setTextColor(-2601405);
            }
            else
            {
              locala.uSf.findViewById(a.g.bmR).setVisibility(8);
              locala.uSf.findViewById(a.g.divider).setVisibility(0);
              localObject1 = (TextView)locala.uSf.findViewById(a.g.bmQ);
            }
          }
        }
      }
      GMTrace.o(2542754856960L, 18945);
      return true;
    }
  }
  
  public final void onDestroy()
  {
    GMTrace.i(2542217986048L, 18941);
    if (this.uRE != null)
    {
      int j = this.uRE.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.uRE.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.uRE.clear();
      this.uRE = null;
    }
    GMTrace.o(2542217986048L, 18941);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2541815332864L, 18938);
    int j;
    int i;
    if ((paramInt == 25) && (this.iaU != null))
    {
      if (paramKeyEvent.getAction() == 0)
      {
        paramInt = this.iaU.getStreamMaxVolume(3);
        j = this.iaU.getStreamVolume(3);
        i = paramInt / 7;
        paramInt = i;
        if (i == 0) {
          paramInt = 1;
        }
        this.iaU.setStreamVolume(3, j - paramInt, 5);
      }
      GMTrace.o(2541815332864L, 18938);
      return true;
    }
    if ((paramInt == 24) && (this.iaU != null))
    {
      if (paramKeyEvent.getAction() == 0)
      {
        paramInt = this.iaU.getStreamMaxVolume(3);
        j = this.iaU.getStreamVolume(3);
        if (j >= paramInt)
        {
          v.i("MicroMsg.MMActivityController", "has set the max volume");
          GMTrace.o(2541815332864L, 18938);
          return true;
        }
        i = paramInt / 7;
        paramInt = i;
        if (i == 0) {
          paramInt = 1;
        }
        this.iaU.setStreamVolume(3, paramInt + j, 5);
      }
      GMTrace.o(2541815332864L, 18938);
      return true;
    }
    if ((this.uRA) && (this.kuK != null) && (this.kuK.onKeyDown(paramInt, paramKeyEvent)))
    {
      v.d("MicroMsg.MMActivityController", "match search view on key down");
      GMTrace.o(2541815332864L, 18938);
      return true;
    }
    GMTrace.o(2541815332864L, 18938);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2541681115136L, 18937);
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      if ((this.uRS != null) && (this.uRS.fFL)) {
        a(this.uRT, this.uRS);
      }
      GMTrace.o(2541681115136L, 18937);
      return true;
    }
    GMTrace.o(2541681115136L, 18937);
    return false;
  }
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    GMTrace.i(2543023292416L, 18947);
    v.v("MicroMsg.MMActivityController", "on options item selected");
    if (!this.uRp)
    {
      v.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
      GMTrace.o(2543023292416L, 18947);
      return true;
    }
    if ((paramMenuItem.getItemId() == this.uRB.uSc) && (this.uRB.fFL))
    {
      a(paramMenuItem, this.uRB);
      GMTrace.o(2543023292416L, 18947);
      return true;
    }
    Iterator localIterator = this.uRC.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramMenuItem.getItemId() == locala.uSc)
      {
        v.d("MicroMsg.MMActivityController", "on option menu %d click", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
        a(paramMenuItem, locala);
        GMTrace.o(2543023292416L, 18947);
        return true;
      }
    }
    GMTrace.o(2543023292416L, 18947);
    return false;
  }
  
  public final void onPause()
  {
    GMTrace.i(2542620639232L, 18944);
    kr(false);
    com.tencent.mm.sdk.b.a.uql.c(this.uRN);
    GMTrace.o(2542620639232L, 18944);
  }
  
  public final boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    GMTrace.i(2542889074688L, 18946);
    v.d("MicroMsg.MMActivityController", "on prepare option menu");
    if ((this.uRA) && (this.kuK != null)) {
      this.kuK.a(this.uRz, paramMenu);
    }
    GMTrace.o(2542889074688L, 18946);
    return true;
  }
  
  public final void onResume()
  {
    GMTrace.i(2542083768320L, 18940);
    kr(true);
    com.tencent.mm.sdk.b.a.uql.b(this.uRN);
    ah localah = new ah();
    localah.fDo.type = 2;
    localah.fDo.position = this.uRL;
    com.tencent.mm.sdk.b.a.uql.m(localah);
    long l;
    String str;
    int i;
    if (localah.fDp.fDs == 2)
    {
      l = System.currentTimeMillis();
      str = localah.fDp.fDv;
      i = localah.fDp.position;
      v.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", new Object[] { Integer.valueOf(i), str });
      if ((i <= 0) || (i == this.uRL)) {
        break label203;
      }
      v.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", new Object[] { Integer.valueOf(i), Integer.valueOf(this.uRL) });
    }
    for (;;)
    {
      v.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - l));
      GMTrace.o(2542083768320L, 18940);
      return;
      label203:
      a(localah.fDp.fDu, localah.fDp.visible, localah.fDp.url, localah.fDp.desc, str, i, true);
    }
  }
  
  public final void onStart()
  {
    GMTrace.i(2541412679680L, 18935);
    this.uRe = this.mContext.getSharedPreferences(aa.bIN(), 0).getBoolean("settings_landscape_mode", false);
    if (this.uRe)
    {
      this.uRz.setRequestedOrientation(-1);
      GMTrace.o(2541412679680L, 18935);
      return;
    }
    this.uRz.setRequestedOrientation(1);
    GMTrace.o(2541412679680L, 18935);
  }
  
  public final void qL(String paramString)
  {
    GMTrace.i(2544231251968L, 18956);
    if (this.Gx == null)
    {
      GMTrace.o(2544231251968L, 18956);
      return;
    }
    this.uRq = paramString;
    if (com.tencent.mm.bg.a.dM(this.uRz)) {
      this.uRG.setTextSize(0, com.tencent.mm.bg.a.U(this.uRz, a.e.aWx) * com.tencent.mm.bg.a.dK(this.uRz));
    }
    bPT();
    SE(paramString);
    GMTrace.o(2544231251968L, 18956);
  }
  
  public final void zd(int paramInt)
  {
    GMTrace.i(2544633905152L, 18959);
    qL(this.mContext.getString(paramInt));
    GMTrace.o(2544633905152L, 18959);
  }
  
  public final void ze(int paramInt)
  {
    GMTrace.i(2544902340608L, 18961);
    if (this.Gx == null)
    {
      GMTrace.o(2544902340608L, 18961);
      return;
    }
    this.uRK.setText(this.mContext.getString(paramInt));
    if (com.tencent.mm.bg.a.dM(this.uRz))
    {
      this.uRK.setTextSize(1, 14.0F);
      this.uRG.setTextSize(1, 18.0F);
    }
    this.uRK.setVisibility(0);
    SE(this.mContext.getString(paramInt));
    GMTrace.o(2544902340608L, 18961);
  }
  
  public final boolean zi(int paramInt)
  {
    GMTrace.i(2547049824256L, 18977);
    int i = 0;
    while (i < this.uRC.size())
    {
      if (((a)this.uRC.get(i)).uSc == paramInt)
      {
        v.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", new Object[] { Integer.valueOf(paramInt) });
        this.uRC.remove(i);
        aQ();
        GMTrace.o(2547049824256L, 18977);
        return true;
      }
      i += 1;
    }
    GMTrace.o(2547049824256L, 18977);
    return false;
  }
  
  public final void zj(int paramInt)
  {
    GMTrace.i(2547586695168L, 18981);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.uRx = bool;
      bPT();
      GMTrace.o(2547586695168L, 18981);
      return;
    }
  }
  
  public final a zl(int paramInt)
  {
    GMTrace.i(2547318259712L, 18979);
    Iterator localIterator = this.uRC.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.uSc == paramInt)
      {
        GMTrace.o(2547318259712L, 18979);
        return locala;
      }
    }
    GMTrace.o(2547318259712L, 18979);
    return null;
  }
  
  public static final class a
  {
    boolean fFL;
    View.OnLongClickListener lJL;
    MenuItem.OnMenuItemClickListener oTr;
    String text;
    int uSc;
    int uSd;
    Drawable uSe;
    View uSf;
    View uSg;
    int uSh;
    boolean visible;
    
    public a()
    {
      GMTrace.i(2077690429440L, 15480);
      this.uSc = -1;
      this.fFL = true;
      this.visible = true;
      this.uSh = l.b.uSi;
      GMTrace.o(2077690429440L, 15480);
    }
  }
  
  public static enum b
  {
    static
    {
      GMTrace.i(2534164922368L, 18881);
      uSi = 1;
      uSj = 2;
      uSk = 3;
      uSl = 4;
      uSm = 5;
      uSn = 6;
      uSo = 7;
      uSp = 8;
      uSq = 9;
      uSr = new int[] { uSi, uSj, uSk, uSl, uSm, uSn, uSo, uSp, uSq };
      GMTrace.o(2534164922368L, 18881);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */