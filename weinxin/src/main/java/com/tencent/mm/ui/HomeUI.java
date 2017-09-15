package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.e;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.as.m.a;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.an;
import com.tencent.mm.e.a.aw;
import com.tencent.mm.e.a.aw.b;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.el;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.e.a.hr.a;
import com.tencent.mm.e.a.ia;
import com.tencent.mm.e.a.la;
import com.tencent.mm.e.a.la.a;
import com.tencent.mm.e.a.qw;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.aa;
import com.tencent.mm.pluginsdk.l.c;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.l.j;
import com.tencent.mm.pluginsdk.l.l;
import com.tencent.mm.pluginsdk.l.q;
import com.tencent.mm.pluginsdk.l.s;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.af;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.bindmobile.BindMContactUI;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.contact.AddressUI.a;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.y.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public final class HomeUI
  implements m.b
{
  public static Boolean uOq;
  public static Boolean uOr;
  private static HashMap<String, Integer> uPk;
  public ActionBar Gx;
  private String fRk;
  private final long hXu;
  public View ipa;
  public ProgressDialog isb;
  public int lBf;
  public int lNE;
  public long mgP;
  LayoutInflater mwN;
  private boolean oGy;
  private View piH;
  private TextView piI;
  public EditText piJ;
  public com.tencent.mm.ui.base.h piK;
  public boolean piL;
  private View qMT;
  public int qgn;
  private final long qpq;
  public long qpr;
  com.tencent.mm.sdk.b.c uNJ;
  ImageView uOA;
  View uOB;
  MenuItem uOC;
  MenuItem uOD;
  b uOE;
  public VoiceSearchLayout uOF;
  com.tencent.mm.sdk.b.c uOG;
  a.a uOH;
  m.b uOI;
  com.tencent.mm.sdk.b.c uOJ;
  public String uOK;
  MessageQueue.IdleHandler uOL;
  MessageQueue.IdleHandler uOM;
  private int uON;
  public hr.a uOO;
  com.tencent.mm.sdk.b.c uOP;
  public la.a uOQ;
  com.tencent.mm.sdk.b.c uOR;
  com.tencent.mm.sdk.b.c uOS;
  private int uOT;
  private int uOU;
  public View uOV;
  public View uOW;
  public En_5b8fbb1e.a uOX;
  public TestTimeForChatting uOY;
  public OnLayoutChangedLinearLayout uOZ;
  private final long uOd;
  public boolean uOe;
  public boolean uOf;
  public com.tencent.mm.y.e uOg;
  boolean uOh;
  boolean uOi;
  public boolean uOj;
  private HashSet<i> uOk;
  public boolean uOl;
  public c uOm;
  CustomViewPager uOn;
  c uOo;
  public u uOp;
  private final long uOs;
  private final long uOt;
  public a uOu;
  public MMFragmentActivity uOv;
  private boolean uOw;
  public Runnable uOx;
  public long uOy;
  public View uOz;
  public OnLayoutChangedLinearLayout.a uPa;
  String uPb;
  Bundle uPc;
  Runnable uPd;
  Runnable uPe;
  private Animation uPf;
  public boolean uPg;
  public Animation uPh;
  public boolean uPi;
  public LinkedList<Runnable> uPj;
  public HashMap<Integer, q> uPl;
  final HashMap<String, Object> values;
  
  static
  {
    GMTrace.i(14990509604864L, 111688);
    uOq = Boolean.valueOf(false);
    uOr = Boolean.valueOf(false);
    HashMap localHashMap = new HashMap();
    uPk = localHashMap;
    localHashMap.put("tab_main", Integer.valueOf(0));
    uPk.put("tab_address", Integer.valueOf(1));
    uPk.put("tab_find_friend", Integer.valueOf(2));
    uPk.put("tab_settings", Integer.valueOf(3));
    GMTrace.o(14990509604864L, 111688);
  }
  
  public HomeUI()
  {
    GMTrace.i(14975879872512L, 111579);
    this.hXu = 180000L;
    this.uOd = 604800000L;
    this.oGy = true;
    this.uOf = false;
    this.uOk = new HashSet();
    this.fRk = null;
    this.uOl = false;
    this.uOs = 432000000L;
    this.uOt = 604800000L;
    this.uOu = a.uPE;
    this.uOw = com.tencent.mm.sdk.platformtools.u.bIz();
    this.uOx = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14975343001600L, 111575);
        if (!com.tencent.mm.kernel.h.vG().uV())
        {
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LauncherUI", "Account not Ready!!!");
          GMTrace.o(14975343001600L, 111575);
          return;
        }
        if (HomeUI.this.uOm == null)
        {
          com.tencent.mm.sdk.platformtools.v.w("MicroMsg.LauncherUI", "set tag job, but tab view is null");
          GMTrace.o(14975343001600L, 111575);
          return;
        }
        int i;
        if (!ap.zb())
        {
          com.tencent.mm.sdk.platformtools.v.w("MicroMsg.UnreadCountHelper", "getFindTabUnreadCount, but mmcore not ready");
          i = 0;
          HomeUI.this.uOm.kb(false);
          HomeUI.this.uOm.yS(i);
          if ((i <= 0) && (com.tencent.mm.az.a.bCb()) && (com.tencent.mm.av.l.KA().Ks() > 0)) {
            HomeUI.this.uOm.kb(true);
          }
          if ((i <= 0) && ((com.tencent.mm.u.m.xW() & 0x8000) == 0))
          {
            ap.yY();
            if (bf.b((Boolean)com.tencent.mm.u.c.vr().get(68384, null), true))
            {
              ap.yY();
              if (!bf.mA((String)com.tencent.mm.u.c.vr().get(68377, null)))
              {
                HomeUI.this.uOm.kb(true);
                GMTrace.o(14975343001600L, 111575);
              }
            }
          }
        }
        else
        {
          if ((com.tencent.mm.u.m.xP() & 0x8000) != 0) {
            break label936;
          }
        }
        label767:
        label915:
        label926:
        label936:
        for (int j = com.tencent.mm.u.h.xI() + 0;; j = 0)
        {
          if (((com.tencent.mm.u.m.xW() & 0x200) == 0) && (!com.tencent.mm.az.a.bCb())) {}
          for (i = com.tencent.mm.av.l.KA().Ks() + 0;; i = 0)
          {
            int k = i;
            Object localObject;
            if ((com.tencent.mm.u.m.xW() & 0x100) == 0)
            {
              localObject = com.tencent.mm.av.l.KB();
              k = i;
              if (localObject != null) {
                k = i + ((com.tencent.mm.av.k)localObject).Ks();
              }
              k += l.a.bCf().baE();
            }
            j += k;
            i = j;
            if ((com.tencent.mm.u.m.xW() & 0x8000) == 0)
            {
              i = j;
              if (com.tencent.mm.plugin.sns.b.m.pPa != null) {
                i = j + com.tencent.mm.plugin.sns.b.m.pPa.Ks();
              }
            }
            break;
            boolean bool;
            if (i <= 0)
            {
              localObject = com.tencent.mm.i.g.sV().getValue("JDEntranceConfigName");
              String str1 = com.tencent.mm.i.g.sV().getValue("JDEntranceConfigIconUrl");
              String str2 = com.tencent.mm.i.g.sV().getValue("JDEntranceConfigJumpUrl");
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "jd tryshow configName " + (String)localObject + " iconUrl " + str1 + " jumpUrl " + str2);
              if ((!bf.mA((String)localObject)) && (!bf.mA(str1)) && (!bf.mA(str2)))
              {
                localObject = l.aa.sAa;
                if (localObject != null)
                {
                  bool = ((l.l)localObject).bmG();
                  com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "jdshowFriend " + bool);
                  if (bool)
                  {
                    localObject = ((l.l)localObject).bmO();
                    if ((((l.e)localObject).axw()) && (!((l.e)localObject).bmx()))
                    {
                      HomeUI.this.uOm.kb(true);
                      GMTrace.o(14975343001600L, 111575);
                      return;
                    }
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "jd time is not start or jd time isExpire");
                  }
                }
              }
            }
            ap.yY();
            if (((Boolean)com.tencent.mm.u.c.vr().get(589825, Boolean.valueOf(false))).booleanValue()) {
              HomeUI.this.uOm.kb(true);
            }
            if (com.tencent.mm.i.g.sV().getInt("WCOEntranceSwitch", 0) > 0)
            {
              ap.yY();
              com.tencent.mm.u.c.vr().a(w.a.uAb, Boolean.valueOf(true));
              if ((!HomeUI.this.uOm.bOt()) && (i <= 0))
              {
                ap.yY();
                if (((Integer)com.tencent.mm.u.c.vr().get(w.a.uAc, Integer.valueOf(0))).intValue() >= com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0))
                {
                  ap.yY();
                  if (((Boolean)com.tencent.mm.u.c.vr().get(w.a.uAe, Boolean.valueOf(false))).booleanValue() != true) {}
                }
                else
                {
                  HomeUI.this.uOm.kb(true);
                }
              }
              if ((i <= 0) && (((Boolean)com.tencent.mm.kernel.h.vI().vr().get(w.a.uCF, Boolean.valueOf(false))).booleanValue())) {
                HomeUI.this.uOm.kb(true);
              }
              localObject = com.tencent.mm.as.m.Ix();
              if ((!((com.tencent.mm.as.m)localObject).valid()) || (((com.tencent.mm.as.m)localObject).hPS.hPU != 1)) {
                break label915;
              }
              i = 1;
              if (i != 0) {
                HomeUI.this.uOm.kb(true);
              }
              ap.yY();
              if ((com.tencent.mm.u.c.vr().getInt(40, 0) & 0x20000) != 0) {
                break label926;
              }
            }
            for (i = 1;; i = 0)
            {
              if (bf.getInt(com.tencent.mm.i.g.sV().getValue("VoiceprintEntry"), 0) == 1) {
                ap.yY();
              }
              for (bool = ((Boolean)com.tencent.mm.u.c.vr().get(w.a.uyq, Boolean.valueOf(true))).booleanValue();; bool = false)
              {
                if ((bool) && (i != 0))
                {
                  com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "show voiceprint dot");
                  HomeUI.this.uOm.kc(true);
                }
                HomeUI.this.uOe = false;
                GMTrace.o(14975343001600L, 111575);
                return;
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uAb, Boolean.valueOf(false));
                break;
                i = 0;
                break label767;
              }
            }
          }
        }
      }
      
      public final String toString()
      {
        GMTrace.i(14975477219328L, 111576);
        String str = super.toString() + "|setTagRunnable";
        GMTrace.o(14975477219328L, 111576);
        return str;
      }
    };
    this.uOy = 0L;
    this.qgn = 0;
    this.mgP = 0L;
    this.uOE = new b();
    this.values = new HashMap();
    this.lBf = -1;
    this.lNE = -1;
    this.uOG = new com.tencent.mm.sdk.b.c() {};
    this.uOH = new a.a()
    {
      public final void a(w.a paramAnonymousa)
      {
        GMTrace.i(14922729652224L, 111183);
        GMTrace.o(14922729652224L, 111183);
      }
      
      public final void eE(int paramAnonymousInt)
      {
        GMTrace.i(14922461216768L, 111181);
        if ((paramAnonymousInt == 262145) || (paramAnonymousInt == 262156) || (paramAnonymousInt == 262152) || (paramAnonymousInt == 266260) || (paramAnonymousInt == 266267)) {
          HomeUI.this.bPg();
        }
        if ((paramAnonymousInt == 262147) || (paramAnonymousInt == 262149)) {
          HomeUI.this.bPg();
        }
        GMTrace.o(14922461216768L, 111181);
      }
      
      public final void eF(int paramAnonymousInt)
      {
        GMTrace.i(14922595434496L, 111182);
        if (paramAnonymousInt == 266241) {
          HomeUI.this.bPg();
        }
        if (paramAnonymousInt == 266244)
        {
          com.tencent.mm.q.c.uk().aE(262147, 266241);
          com.tencent.mm.q.c.uk().aE(262149, 266241);
          HomeUI.this.bPg();
        }
        GMTrace.o(14922595434496L, 111182);
      }
    };
    this.uOI = new m.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.m paramAnonymousm, Object paramAnonymousObject)
      {
        GMTrace.i(14924071829504L, 111193);
        int i = bf.n(paramAnonymousObject, 0);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousm });
        ap.yY();
        if ((paramAnonymousm != com.tencent.mm.u.c.vr()) || (i <= 0))
        {
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LauncherUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramAnonymousm });
          GMTrace.o(14924071829504L, 111193);
          return;
        }
        HomeUI.this.bPd();
        if (i == 143618)
        {
          HomeUI.this.bPs();
          GMTrace.o(14924071829504L, 111193);
          return;
        }
        if ((i == 204817) || (i == 204820)) {
          HomeUI.this.bPg();
        }
        GMTrace.o(14924071829504L, 111193);
      }
    };
    this.uOJ = new com.tencent.mm.sdk.b.c() {};
    this.uOM = new MessageQueue.IdleHandler()
    {
      /* Error */
      public final boolean queueIdle()
      {
        // Byte code:
        //   0: ldc2_w 35
        //   3: ldc 37
        //   5: invokestatic 28	com/tencent/gmtrace/GMTrace:i	(JI)V
        //   8: invokestatic 43	com/tencent/mm/u/ap:yY	()Lcom/tencent/mm/u/c;
        //   11: pop
        //   12: invokestatic 49	com/tencent/mm/u/c:vr	()Lcom/tencent/mm/storage/t;
        //   15: bipush 15
        //   17: aconst_null
        //   18: invokevirtual 55	com/tencent/mm/storage/t:get	(ILjava/lang/Object;)Ljava/lang/Object;
        //   21: checkcast 57	java/lang/Integer
        //   24: invokestatic 63	com/tencent/mm/sdk/platformtools/bf:f	(Ljava/lang/Integer;)I
        //   27: ifne +26 -> 53
        //   30: iconst_1
        //   31: istore_1
        //   32: iload_1
        //   33: ifeq +25 -> 58
        //   36: ldc 65
        //   38: ldc 67
        //   40: invokestatic 73	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   43: ldc2_w 35
        //   46: ldc 37
        //   48: invokestatic 31	com/tencent/gmtrace/GMTrace:o	(JI)V
        //   51: iconst_0
        //   52: ireturn
        //   53: iconst_0
        //   54: istore_1
        //   55: goto -23 -> 32
        //   58: getstatic 79	com/tencent/mm/u/ao:hlE	Lcom/tencent/mm/u/ao;
        //   61: ldc 81
        //   63: ldc 83
        //   65: invokevirtual 87	com/tencent/mm/u/ao:A	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   68: astore_3
        //   69: invokestatic 90	com/tencent/mm/u/ap:za	()Z
        //   72: ifne +12 -> 84
        //   75: aload_3
        //   76: ldc 83
        //   78: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   81: ifne +28 -> 109
        //   84: invokestatic 100	com/tencent/mm/u/ap:vd	()Lcom/tencent/mm/y/n;
        //   87: new 102	com/tencent/mm/u/bb
        //   90: dup
        //   91: new 10	com/tencent/mm/ui/HomeUI$7$1
        //   94: dup
        //   95: aload_0
        //   96: invokespecial 105	com/tencent/mm/ui/HomeUI$7$1:<init>	(Lcom/tencent/mm/ui/HomeUI$7;)V
        //   99: ldc 107
        //   101: invokespecial 110	com/tencent/mm/u/bb:<init>	(Lcom/tencent/mm/u/bb$a;Ljava/lang/String;)V
        //   104: iconst_0
        //   105: invokevirtual 116	com/tencent/mm/y/n:a	(Lcom/tencent/mm/y/k;I)Z
        //   108: pop
        //   109: new 118	com/tencent/mm/booter/y$1
        //   112: dup
        //   113: new 120	com/tencent/mm/booter/y
        //   116: dup
        //   117: aload_0
        //   118: getfield 16	com/tencent/mm/ui/HomeUI$7:uPm	Lcom/tencent/mm/ui/HomeUI;
        //   121: getfield 124	com/tencent/mm/ui/HomeUI:uOv	Lcom/tencent/mm/ui/MMFragmentActivity;
        //   124: invokespecial 127	com/tencent/mm/booter/y:<init>	(Landroid/content/Context;)V
        //   127: invokespecial 130	com/tencent/mm/booter/y$1:<init>	(Lcom/tencent/mm/booter/y;)V
        //   130: ldc -124
        //   132: invokestatic 138	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
        //   135: iconst_1
        //   136: invokestatic 144	com/tencent/mm/booter/o:onCreate	(Z)V
        //   139: invokestatic 147	com/tencent/mm/ui/HomeUI:bPi	()V
        //   142: invokestatic 152	com/tencent/mm/plugin/report/service/e:aXA	()V
        //   145: invokestatic 158	com/tencent/mm/ah/m:GK	()Lcom/tencent/mm/ah/m;
        //   148: getfield 162	com/tencent/mm/ah/m:hGO	Lcom/tencent/mm/ah/m$c;
        //   151: astore_3
        //   152: aload_3
        //   153: getfield 168	com/tencent/mm/ah/m$c:hHd	Ljava/util/LinkedList;
        //   156: invokevirtual 174	java/util/LinkedList:size	()I
        //   159: ifgt +13 -> 172
        //   162: aload_3
        //   163: getfield 177	com/tencent/mm/ah/m$c:hHc	Ljava/util/LinkedList;
        //   166: invokevirtual 174	java/util/LinkedList:size	()I
        //   169: ifle +30 -> 199
        //   172: aload_3
        //   173: invokevirtual 180	com/tencent/mm/ah/m$c:GN	()V
        //   176: invokestatic 186	android/os/Looper:myQueue	()Landroid/os/MessageQueue;
        //   179: aload_0
        //   180: getfield 16	com/tencent/mm/ui/HomeUI$7:uPm	Lcom/tencent/mm/ui/HomeUI;
        //   183: getfield 190	com/tencent/mm/ui/HomeUI:uOM	Landroid/os/MessageQueue$IdleHandler;
        //   186: invokevirtual 196	android/os/MessageQueue:removeIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
        //   189: ldc2_w 35
        //   192: ldc 37
        //   194: invokestatic 31	com/tencent/gmtrace/GMTrace:o	(JI)V
        //   197: iconst_0
        //   198: ireturn
        //   199: invokestatic 202	com/tencent/mm/kernel/h:vI	()Lcom/tencent/mm/kernel/e;
        //   202: invokevirtual 205	com/tencent/mm/kernel/e:vr	()Lcom/tencent/mm/storage/t;
        //   205: ldc -50
        //   207: ldc 83
        //   209: invokevirtual 55	com/tencent/mm/storage/t:get	(ILjava/lang/Object;)Ljava/lang/Object;
        //   212: checkcast 92	java/lang/String
        //   215: astore 5
        //   217: invokestatic 202	com/tencent/mm/kernel/h:vI	()Lcom/tencent/mm/kernel/e;
        //   220: invokevirtual 205	com/tencent/mm/kernel/e:vr	()Lcom/tencent/mm/storage/t;
        //   223: ldc -49
        //   225: ldc 83
        //   227: invokevirtual 55	com/tencent/mm/storage/t:get	(ILjava/lang/Object;)Ljava/lang/Object;
        //   230: checkcast 92	java/lang/String
        //   233: astore 4
        //   235: aload 5
        //   237: invokestatic 211	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
        //   240: ifne +54 -> 294
        //   243: aload 5
        //   245: ldc -43
        //   247: invokevirtual 217	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   250: astore 5
        //   252: aload_3
        //   253: monitorenter
        //   254: aload 5
        //   256: arraylength
        //   257: istore_2
        //   258: iconst_0
        //   259: istore_1
        //   260: iload_1
        //   261: iload_2
        //   262: if_icmpge +30 -> 292
        //   265: aload 5
        //   267: iload_1
        //   268: aaload
        //   269: invokestatic 221	com/tencent/mm/ah/m$c:jB	(Ljava/lang/String;)Lcom/tencent/mm/ah/m$b;
        //   272: astore 6
        //   274: aload 6
        //   276: ifnull +135 -> 411
        //   279: aload_3
        //   280: getfield 168	com/tencent/mm/ah/m$c:hHd	Ljava/util/LinkedList;
        //   283: aload 6
        //   285: invokevirtual 224	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   288: pop
        //   289: goto +122 -> 411
        //   292: aload_3
        //   293: monitorexit
        //   294: aload 4
        //   296: invokestatic 211	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
        //   299: ifne +65 -> 364
        //   302: aload 4
        //   304: ldc -43
        //   306: invokevirtual 217	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   309: astore 4
        //   311: aload_3
        //   312: monitorenter
        //   313: aload 4
        //   315: arraylength
        //   316: istore_2
        //   317: iconst_0
        //   318: istore_1
        //   319: iload_1
        //   320: iload_2
        //   321: if_icmpge +41 -> 362
        //   324: aload 4
        //   326: iload_1
        //   327: aaload
        //   328: invokestatic 227	com/tencent/mm/ah/m$c:jA	(Ljava/lang/String;)Lcom/tencent/mm/ah/m$b;
        //   331: astore 5
        //   333: aload 5
        //   335: ifnull +13 -> 348
        //   338: aload_3
        //   339: getfield 177	com/tencent/mm/ah/m$c:hHc	Ljava/util/LinkedList;
        //   342: aload 5
        //   344: invokevirtual 224	java/util/LinkedList:add	(Ljava/lang/Object;)Z
        //   347: pop
        //   348: iload_1
        //   349: iconst_1
        //   350: iadd
        //   351: istore_1
        //   352: goto -33 -> 319
        //   355: astore 4
        //   357: aload_3
        //   358: monitorexit
        //   359: aload 4
        //   361: athrow
        //   362: aload_3
        //   363: monitorexit
        //   364: ldc -27
        //   366: ldc -25
        //   368: iconst_2
        //   369: anewarray 4	java/lang/Object
        //   372: dup
        //   373: iconst_0
        //   374: aload_3
        //   375: getfield 177	com/tencent/mm/ah/m$c:hHc	Ljava/util/LinkedList;
        //   378: invokevirtual 174	java/util/LinkedList:size	()I
        //   381: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   384: aastore
        //   385: dup
        //   386: iconst_1
        //   387: aload_3
        //   388: getfield 168	com/tencent/mm/ah/m$c:hHd	Ljava/util/LinkedList;
        //   391: invokevirtual 174	java/util/LinkedList:size	()I
        //   394: invokestatic 235	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   397: aastore
        //   398: invokestatic 238	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   401: goto -229 -> 172
        //   404: astore 4
        //   406: aload_3
        //   407: monitorexit
        //   408: aload 4
        //   410: athrow
        //   411: iload_1
        //   412: iconst_1
        //   413: iadd
        //   414: istore_1
        //   415: goto -155 -> 260
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	418	0	this	7
        //   31	384	1	i	int
        //   257	65	2	j	int
        //   68	339	3	localObject1	Object
        //   233	92	4	localObject2	Object
        //   355	5	4	localObject3	Object
        //   404	5	4	localObject4	Object
        //   215	128	5	localObject5	Object
        //   272	12	6	localb	com.tencent.mm.ah.m.b
        // Exception table:
        //   from	to	target	type
        //   254	258	355	finally
        //   265	274	355	finally
        //   279	289	355	finally
        //   292	294	355	finally
        //   357	359	355	finally
        //   313	317	404	finally
        //   324	333	404	finally
        //   338	348	404	finally
        //   362	364	404	finally
        //   406	408	404	finally
      }
    };
    this.uON = -1;
    this.uNJ = new com.tencent.mm.sdk.b.c() {};
    this.uOO = null;
    this.uOP = new com.tencent.mm.sdk.b.c() {};
    this.uOQ = null;
    this.uOR = new com.tencent.mm.sdk.b.c() {};
    this.uOS = new com.tencent.mm.sdk.b.c() {};
    this.uOT = -1;
    this.uOU = -1;
    this.uPa = new OnLayoutChangedLinearLayout.a()
    {
      public final void bPx()
      {
        GMTrace.i(18985902931968L, 141456);
        if (HomeUI.this.uPh == null)
        {
          HomeUI.this.uPh = AnimationUtils.loadAnimation(HomeUI.this.uOv, MMFragmentActivity.a.uTa);
          HomeUI.this.uPh.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              GMTrace.i(18984158101504L, 141443);
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "klem animationEnd");
              HomeUI.this.bPn();
              HomeUI.this.uOv.O(1.0F);
              GMTrace.o(18984158101504L, 141443);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation)
            {
              GMTrace.i(18984023883776L, 141442);
              GMTrace.o(18984023883776L, 141442);
            }
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              GMTrace.i(18983889666048L, 141441);
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "klem onAnimationStart");
              HomeUI.this.bPm();
              HomeUI.this.kj(false);
              GMTrace.o(18983889666048L, 141441);
            }
          });
        }
        if (HomeUI.this.uPg)
        {
          HomeUI.this.uOX.mView.startAnimation(HomeUI.this.uPh);
          HomeUI.this.uPg = false;
        }
        for (;;)
        {
          HomeUI.this.uOZ.vnK = null;
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "klem CHATTING ONLAYOUT ");
          GMTrace.o(18985902931968L, 141456);
          return;
          HomeUI.this.bPm();
          HomeUI.this.bPn();
        }
      }
    };
    this.uPd = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14971987558400L, 111550);
        HomeUI.this.uPi = false;
        if (HomeUI.this.uOv.isFinishing())
        {
          GMTrace.o(14971987558400L, 111550);
          return;
        }
        HomeUI.this.dS(4, HomeUI.this.lBf);
        if (HomeUI.this.uOY == null) {}
        for (boolean bool = false;; bool = HomeUI.this.uOY.isShown())
        {
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "ashutest::startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
          Intent localIntent = new Intent().putExtra("Chat_User", HomeUI.this.uPb);
          if (HomeUI.this.uPc != null) {
            localIntent.putExtras(HomeUI.this.uPc);
          }
          localIntent.putExtra("img_gallery_enter_from_chatting_ui", true);
          HomeUI.this.af(localIntent);
          HomeUI.this.uOZ.vnK = HomeUI.this.uPa;
          HomeUI.this.uOY.setVisibility(0);
          HomeUI.this.bPl();
          com.tencent.mm.sdk.f.e.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(18987110891520L, 141465);
              com.tencent.mm.modelstat.d.a(3, "En_5b8fbb1e" + HomeUI.this.uOX.bVa(), HomeUI.this.uOX.hashCode());
              GMTrace.o(18987110891520L, 141465);
            }
          }, "directReport_startChattingRunnable");
          HomeUI.this.uOy = bf.Nz();
          if (HomeUI.this.uOX.bPY()) {
            com.tencent.mm.ui.widget.j.a(HomeUI.this.uOv);
          }
          GMTrace.o(14971987558400L, 111550);
          return;
        }
      }
      
      public final String toString()
      {
        GMTrace.i(18987245109248L, 141466);
        String str = super.toString() + "|startChattingRunnable";
        GMTrace.o(18987245109248L, 141466);
        return str;
      }
    };
    this.uPe = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14920179515392L, 111164);
        if ((com.tencent.mm.n.a.aI(HomeUI.this.uOv)) || (com.tencent.mm.n.a.aH(HomeUI.this.uOv)))
        {
          GMTrace.o(14920179515392L, 111164);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("BaseScanUI_select_scan_mode", 1);
        localIntent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        localIntent.setFlags(65536);
        com.tencent.mm.plugin.report.service.g.oSF.i(11409, new Object[0]);
        com.tencent.mm.bb.d.b(HomeUI.this.uOv, "scanner", ".ui.BaseScanUI", localIntent);
        GMTrace.o(14920179515392L, 111164);
      }
    };
    this.uPg = false;
    this.uPi = true;
    this.qpq = 300L;
    this.qpr = SystemClock.elapsedRealtime();
    this.uPj = new LinkedList();
    this.uPl = new HashMap();
    GMTrace.o(14975879872512L, 111579);
  }
  
  public static boolean VC()
  {
    GMTrace.i(14981114363904L, 111618);
    GMTrace.o(14981114363904L, 111618);
    return true;
  }
  
  private void bPe()
  {
    GMTrace.i(14976550961152L, 111584);
    if (!ap.zb())
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LauncherUI", "mmcore has not ready");
      GMTrace.o(14976550961152L, 111584);
      return;
    }
    ap.yY();
    Boolean localBoolean = Boolean.valueOf(bf.f((Boolean)com.tencent.mm.u.c.vr().get(340227, null)));
    if ((!localBoolean.booleanValue()) && (!com.tencent.mm.ui.contact.k.vVH.booleanValue()))
    {
      uOq = Boolean.valueOf(true);
      kg(true);
    }
    long l1 = System.currentTimeMillis();
    ap.yY();
    long l2 = bf.a((Long)com.tencent.mm.u.c.vr().get(340240, null), 0L);
    ap.yY();
    boolean bool1 = bf.f((Boolean)com.tencent.mm.u.c.vr().get(340230, null));
    ap.yY();
    boolean bool2 = bf.f((Boolean)com.tencent.mm.u.c.vr().get(340228, null));
    ap.yY();
    boolean bool3 = bf.f((Boolean)com.tencent.mm.u.c.vr().get(340229, null));
    if ((localBoolean.booleanValue()) && (Boolean.valueOf(bool2).booleanValue()) && (Boolean.valueOf(bool3).booleanValue()) && (!Boolean.valueOf(bool1).booleanValue()) && (l1 - l2 >= 432000000L))
    {
      uOr = Boolean.valueOf(true);
      kg(false);
    }
    GMTrace.o(14976550961152L, 111584);
  }
  
  public static void bPi()
  {
    GMTrace.i(16019288489984L, 119353);
    if (Build.VERSION.SDK_INT < 18)
    {
      Intent localIntent = new Intent(aa.getContext(), NotifyReceiver.NotifyService.class);
      aa.getContext().startService(localIntent);
    }
    GMTrace.o(16019288489984L, 119353);
  }
  
  private ViewGroup bPo()
  {
    GMTrace.i(14978698444800L, 111600);
    Object localObject1 = this.Gx.getCustomView().getParent();
    Object localObject2 = null;
    ViewGroup localViewGroup = (ViewGroup)this.uOv.getWindow().getDecorView();
    while ((localObject1 != localViewGroup) && (localObject1 != null))
    {
      ViewParent localViewParent = ((ViewParent)localObject1).getParent();
      localObject2 = localObject1;
      localObject1 = localViewParent;
    }
    localObject1 = (ViewGroup)localObject2;
    GMTrace.o(14978698444800L, 111600);
    return (ViewGroup)localObject1;
  }
  
  private boolean bPp()
  {
    GMTrace.i(14978832662528L, 111601);
    Object localObject = this.uOv.aR().aW();
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "fragments is null");
      GMTrace.o(14978832662528L, 111601);
      return true;
    }
    if (((List)localObject).size() >= 5)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LauncherUI", "fragments more than 5! %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((Fragment)((Iterator)localObject).next() instanceof En_5b8fbb1e.a));
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LauncherUI", "fragments more than 5 and find a ChattingUIFragmet!!");
      GMTrace.o(14978832662528L, 111601);
      return false;
    }
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "fragments size %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
    GMTrace.o(14978832662528L, 111601);
    return true;
  }
  
  private void bPt()
  {
    GMTrace.i(14980577492992L, 111614);
    this.uOl = false;
    this.uOF.reset();
    GMTrace.o(14980577492992L, 111614);
  }
  
  private void kg(final boolean paramBoolean)
  {
    GMTrace.i(14976685178880L, 111585);
    if (this.qMT != null)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LauncherUI", "tipsView already shown");
      GMTrace.o(14976685178880L, 111585);
      return;
    }
    this.qMT = View.inflate(aa.getContext(), R.i.dka, null);
    Object localObject = (TextView)this.qMT.findViewById(R.h.cnK);
    if (paramBoolean) {
      ((TextView)localObject).setText(aa.getContext().getString(R.l.dBI));
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(-2, -2, 53);
      this.qMT.setBackgroundResource(R.g.bia);
      if (this.ipa != null)
      {
        ((ViewGroup)this.ipa).addView(this.qMT, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(aa.getContext(), R.a.aRI);
        this.qMT.startAnimation((Animation)localObject);
        this.qMT.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(14970108510208L, 111536);
            HomeUI.this.uOp.dL();
            if (paramBoolean)
            {
              HomeUI.this.c(Boolean.valueOf(true), Boolean.valueOf(true));
              GMTrace.o(14970108510208L, 111536);
              return;
            }
            HomeUI.this.c(Boolean.valueOf(true), Boolean.valueOf(false));
            GMTrace.o(14970108510208L, 111536);
          }
        });
      }
      GMTrace.o(14976685178880L, 111585);
      return;
      ((TextView)localObject).setText(aa.getContext().getString(R.l.dBH));
    }
  }
  
  public final void SC(String paramString)
  {
    GMTrace.i(14979637968896L, 111607);
    if ((paramString == null) || (paramString.equals("")))
    {
      GMTrace.o(14979637968896L, 111607);
      return;
    }
    yW(((Integer)uPk.get(paramString)).intValue());
    GMTrace.o(14979637968896L, 111607);
  }
  
  public final void Y(Runnable paramRunnable)
  {
    GMTrace.i(14979369533440L, 111605);
    if (!this.uPj.contains(paramRunnable)) {
      this.uPj.add(paramRunnable);
    }
    GMTrace.o(14979369533440L, 111605);
  }
  
  public final void Z(Runnable paramRunnable)
  {
    GMTrace.i(14979503751168L, 111606);
    this.uPj.remove(paramRunnable);
    GMTrace.o(14979503751168L, 111606);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    GMTrace.i(14980711710720L, 111615);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      GMTrace.o(14980711710720L, 111615);
      return;
    }
    ap.yY();
    if (paramm == com.tencent.mm.u.c.wW())
    {
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "Launcherui onNotifyChange event type %d, username %s", new Object[] { Integer.valueOf(paramInt), paramObject });
      if (com.tencent.mm.storage.x.eO((String)paramObject)) {
        bPd();
      }
      GMTrace.o(14980711710720L, 111615);
      return;
    }
    GMTrace.o(14980711710720L, 111615);
  }
  
  public final void a(FitSystemWindowLayoutView paramFitSystemWindowLayoutView, int paramInt, Rect paramRect, ViewGroup paramViewGroup)
  {
    GMTrace.i(14978966880256L, 111602);
    int j = this.uOv.getWindow().getDecorView().getBottom();
    int k = this.uOv.cO().cP().getCustomView().getBottom();
    if ((this.uOm != null) && ((this.uOm instanceof View))) {}
    for (int i = j - (((View)this.uOm).getBottom() + (paramInt + k));; i = 0)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i) });
      paramFitSystemWindowLayoutView.uPJ = paramViewGroup;
      paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
      GMTrace.o(14978966880256L, 111602);
      return;
    }
  }
  
  public final void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    GMTrace.i(14978564227072L, 111599);
    if (this.uOY == null) {}
    for (boolean bool = false;; bool = this.uOY.isShown())
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "try startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      ap.getNotification().aw(false);
      this.uPc = paramBundle;
      this.uPb = paramString;
      this.uPg = paramBoolean;
      ap.vL().bIX();
      ae.yq(-8);
      if (this.uOe)
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "remove setTagRunnable");
        ae.I(this.uOx);
      }
      ae.v(this.uPd);
      if ((com.tencent.mm.u.m.yt().booleanValue()) && ((uOq.booleanValue()) || (uOr.booleanValue()))) {
        c(Boolean.valueOf(false), Boolean.valueOf(false));
      }
      paramString = (com.tencent.mm.ui.conversation.j)this.uPl.get(Integer.valueOf(0));
      if (paramString != null) {
        paramString.onHiddenChanged(true);
      }
      GMTrace.o(14978564227072L, 111599);
      return;
    }
  }
  
  public final boolean a(final hr.a parama)
  {
    GMTrace.i(15335851819008L, 114261);
    if ((parama == null) || (parama.fNa == null) || (parama.fNa.sZy == null) || (parama.fNa.sZy.size() == 0))
    {
      GMTrace.o(15335851819008L, 114261);
      return false;
    }
    final int i = parama.fNa.id;
    String str1 = parama.fNa.title;
    String str2 = parama.fNa.fEi;
    int j = parama.type;
    int k = parama.fNa.sZy.size();
    if (j == 0) {
      if (k == 1)
      {
        parama = (com.tencent.mm.protocal.b.a.a)parama.fNa.sZy.get(0);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.sZw, parama.sZx });
        com.tencent.mm.ui.base.g.a(this.uOv, str2, str1, parama.sZw, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(14920850604032L, 111169);
            HomeUI.this.d(i, parama.actionType, parama.id, parama.sZx);
            paramAnonymousDialogInterface.dismiss();
            GMTrace.o(14920850604032L, 111169);
          }
        });
      }
    }
    for (;;)
    {
      GMTrace.o(15335851819008L, 114261);
      return true;
      final com.tencent.mm.protocal.b.a.a locala1 = (com.tencent.mm.protocal.b.a.a)parama.fNa.sZy.get(1);
      parama = (com.tencent.mm.protocal.b.a.a)parama.fNa.sZy.get(0);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", new Object[] { str1, str2, Integer.valueOf(locala1.id), Integer.valueOf(locala1.actionType), locala1.sZw, locala1.sZx, Integer.valueOf(parama.id), Integer.valueOf(parama.actionType), parama.sZw, parama.sZx });
      com.tencent.mm.ui.base.g.a(this.uOv, str2, str1, locala1.sZw, parama.sZw, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(14916421419008L, 111136);
          HomeUI.this.d(i, locala1.actionType, locala1.id, locala1.sZx);
          paramAnonymousDialogInterface.dismiss();
          GMTrace.o(14916421419008L, 111136);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(18982815924224L, 141433);
          HomeUI.this.d(i, parama.actionType, parama.id, parama.sZx);
          paramAnonymousDialogInterface.dismiss();
          GMTrace.o(18982815924224L, 141433);
        }
      });
      continue;
      if (j == 1)
      {
        locala1 = (com.tencent.mm.protocal.b.a.a)parama.fNa.sZy.get(0);
        com.tencent.mm.protocal.b.a.a locala2 = (com.tencent.mm.protocal.b.a.a)parama.fNa.sZy.get(1);
        com.tencent.mm.ui.base.g.a(this.uOv, str2, str1, locala1.sZw, locala2.sZw, false, parama.fNb, parama.fNc);
      }
    }
  }
  
  @TargetApi(16)
  public final void af(Intent paramIntent)
  {
    GMTrace.i(16019825360896L, 119357);
    long l = System.currentTimeMillis();
    if (this.uOX == null)
    {
      this.uOX = En_5b8fbb1e.a.bUG();
      this.uOX.e(this.uOV, this.uOW);
      this.uOV = null;
      this.uOW = null;
    }
    for (boolean bool = true;; bool = false)
    {
      if (this.uOY == null) {
        if (!this.uOX.bPY())
        {
          this.uOY = ((TestTimeForChatting)this.uOv.findViewById(R.h.bzK));
          this.uON = this.uOY.getId();
          if (!bool) {
            break label984;
          }
          this.uOX.hMt = true;
          this.uOX.nfK = false;
          this.uOX.setArguments(com.tencent.mm.sdk.platformtools.r.ad(paramIntent));
          if (!bPp()) {
            break label956;
          }
          this.uOv.aR().aV().a(this.uON, this.uOX).commitAllowingStateLoss();
          this.uOv.aR().executePendingTransactions();
          label176:
          this.uOZ = ((OnLayoutChangedLinearLayout)this.uOX.mView.findViewById(R.h.bzU));
          this.uOX.li(true);
        }
      }
      for (;;)
      {
        if (this.uOX.bPY()) {
          this.uOX.uSO.wvC = false;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool), paramIntent });
        GMTrace.o(16019825360896L, 119357);
        return;
        final Object localObject3 = new int[2];
        this.uOv.cO().cP().getCustomView().getLocationInWindow((int[])localObject3);
        Object localObject4 = new TestTimeForChatting(this.uOv);
        Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
        ((TestTimeForChatting)localObject4).setId(R.h.bAi);
        this.uON = ((TestTimeForChatting)localObject4).getId();
        ((TestTimeForChatting)localObject4).setOrientation(1);
        ((TestTimeForChatting)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        final FitSystemWindowLayoutView localFitSystemWindowLayoutView = new FitSystemWindowLayoutView(this.uOv);
        localFitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        final Object localObject2 = bPo();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((ViewGroup)this.uOv.getWindow().getDecorView()).getChildAt(0);
        }
        localObject2 = (ViewGroup)localObject1;
        ((ViewGroup)this.uOv.getWindow().getDecorView()).removeView((View)localObject1);
        ((View)localObject1).setId(R.h.caJ);
        localFitSystemWindowLayoutView.addView((View)localObject1);
        localFitSystemWindowLayoutView.addView((View)localObject4);
        ((ViewGroup)this.uOv.getWindow().getDecorView()).addView(localFitSystemWindowLayoutView);
        this.uOv.getWindow().getDecorView().requestFitSystemWindows();
        int i = localObject3[1];
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows. statusBarHeight:%d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          a(localFitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), (ViewGroup)localObject2);
        }
        for (;;)
        {
          this.uOY = ((TestTimeForChatting)this.uOv.findViewById(this.uON));
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "ashu::prepareChattingFragment init chattingView, top %s", new Object[] { Integer.valueOf(localObject3[1]) });
          break;
          this.uOv.cO().cP().getCustomView().post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(14917629378560L, 111145);
              HomeUI.this.uOv.cO().cP().getCustomView().getLocationInWindow(localObject3);
              int i = localObject3[1];
              if (i > 0)
              {
                HomeUI.this.a(localFitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), localObject2);
                GMTrace.o(14917629378560L, 111145);
                return;
              }
              if (com.tencent.mm.compatible.util.d.eo(20)) {
                localFitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
                {
                  @TargetApi(20)
                  public final WindowInsets onApplyWindowInsets(View paramAnonymous2View, WindowInsets paramAnonymous2WindowInsets)
                  {
                    GMTrace.i(18988721504256L, 141477);
                    if (paramAnonymous2WindowInsets == null)
                    {
                      GMTrace.o(18988721504256L, 141477);
                      return paramAnonymous2WindowInsets;
                    }
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "OnApplyWindowInsetsListener %s", new Object[] { paramAnonymous2WindowInsets });
                    paramAnonymous2WindowInsets.consumeSystemWindowInsets();
                    HomeUI.this.a(HomeUI.26.this.uPx, paramAnonymous2WindowInsets.getSystemWindowInsetTop(), new Rect(paramAnonymous2WindowInsets.getSystemWindowInsetLeft(), paramAnonymous2WindowInsets.getSystemWindowInsetTop(), paramAnonymous2WindowInsets.getSystemWindowInsetRight(), paramAnonymous2WindowInsets.getSystemWindowInsetBottom()), HomeUI.26.this.uPy);
                    GMTrace.o(18988721504256L, 141477);
                    return paramAnonymous2WindowInsets;
                  }
                });
              }
              GMTrace.o(14917629378560L, 111145);
            }
          });
        }
        if (!this.uOX.bPY()) {
          break;
        }
        localObject1 = new int[2];
        this.uOY.getLocationInWindow((int[])localObject1);
        if (localObject1[1] == 0)
        {
          localObject2 = (ViewGroup)this.uOv.getWindow().getDecorView();
          i = 0;
        }
        for (;;)
        {
          if (i < ((ViewGroup)localObject2).getChildCount())
          {
            localObject3 = ((ViewGroup)this.uOv.getWindow().getDecorView()).getChildAt(i);
            if ((localObject3 instanceof FitSystemWindowLayoutView))
            {
              this.uOv.cO().cP().getCustomView().getLocationInWindow((int[])localObject1);
              localObject2 = (FitSystemWindowLayoutView)localObject3;
              i = ((ViewGroup)this.uOv.findViewById(R.h.caJ)).getPaddingTop();
              int j = com.tencent.mm.ui.base.s.ab(this.uOv, -1);
              localObject3 = new Rect();
              localObject4 = this.uOv.getWindow();
              ((Window)localObject4).getDecorView().getWindowVisibleDisplayFrame((Rect)localObject3);
              int k = ((Window)localObject4).getDecorView().getHeight();
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "rootLayout2 fitSystemWindows detect: ActionBar's CustomView location[1]:%d, paddingTop:%d getStatusBarHeight():%d, heightFromSysR:%d, rectangle.top:%d, rectangle.height:%d, DecorHeight:%d, cacheInsetsTop:%d", new Object[] { Integer.valueOf(localObject1[1]), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.pluginsdk.e.ds(this.uOv)), Integer.valueOf(j), Integer.valueOf(((Rect)localObject3).top), Integer.valueOf(((Rect)localObject3).height()), Integer.valueOf(k), Integer.valueOf(((FitSystemWindowLayoutView)localObject2).uPI) });
              ((FitSystemWindowLayoutView)localObject2).fitSystemWindows(new Rect(0, ((FitSystemWindowLayoutView)localObject2).uPI, 0, 0));
            }
          }
          else
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "ashu::prepareChattingFragment has chattingView, top %s", new Object[] { Integer.valueOf(localObject1[1]) });
            break;
          }
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LauncherUI", "on position %d, rootLayout not found!", new Object[] { Integer.valueOf(i) });
          i += 1;
        }
        label956:
        this.uOv.aR().aV().b(this.uON, this.uOX).commitAllowingStateLoss();
        break label176;
        label984:
        this.uOX.hMt = true;
        this.uOX.nfK = false;
        this.uOX.oW.putAll(com.tencent.mm.sdk.platformtools.r.ad(paramIntent));
        this.uOX.bTt();
        this.uOX.onResume();
        this.uOX.li(true);
      }
    }
  }
  
  public final void ajd()
  {
    GMTrace.i(14976148307968L, 111581);
    Object localObject2 = getString(R.l.bpC);
    Object localObject1 = localObject2;
    if (com.tencent.mm.protocal.d.sXk)
    {
      if (this.uOw) {
        localObject1 = (String)localObject2 + getString(R.l.dCT);
      }
    }
    else
    {
      if ((this.uOm == null) || (this.uOm.bOp() <= 0)) {
        break label237;
      }
      localObject2 = localObject1;
      if (!this.uOw) {
        localObject2 = (String)localObject1 + " ";
      }
      localObject1 = (String)localObject2 + "(" + this.uOm.bOp() + ")";
    }
    label237:
    for (;;)
    {
      localObject2 = (TextView)this.Gx.getCustomView().findViewById(16908308);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setTextSize(0, com.tencent.mm.bg.a.U(aa.getContext(), R.f.aWx) * com.tencent.mm.bg.a.dK(aa.getContext()));
      }
      GMTrace.o(14976148307968L, 111581);
      return;
      localObject1 = (String)localObject2 + " " + getString(R.l.dCT);
      break;
    }
  }
  
  public final void bOi()
  {
    GMTrace.i(14980443275264L, 111613);
    this.uOv.moveTaskToBack(true);
    if (ap.zb()) {
      ap.vL().e(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(18986842456064L, 141463);
          if (ap.zb())
          {
            ap.yY();
            com.tencent.mm.storage.t localt = com.tencent.mm.u.c.vr();
            if (localt != null) {
              localt.jV(true);
            }
          }
          GMTrace.o(18986842456064L, 141463);
        }
      }, 500L);
    }
    com.tencent.mm.app.l locall = com.tencent.mm.app.l.os();
    locall.fwJ = false;
    locall.fwK.removeMessages(63537);
    locall.fwK.removeMessages(62537);
    locall.fwK.sendEmptyMessageDelayed(63537, 3000L);
    locall.fwK.sendEmptyMessageDelayed(62537, 30000L);
    GMTrace.o(14980443275264L, 111613);
  }
  
  public final void bPb()
  {
    GMTrace.i(14976014090240L, 111580);
    long l1 = bf.NA();
    com.tencent.mm.sdk.a.b.aX(true);
    final boolean bool;
    Object localObject;
    long l2;
    long l3;
    label428:
    long l4;
    if (this.uOX == null)
    {
      bool = false;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "onResume, chatting is show %B, accountHasReady %B", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(ap.zb()) });
      if ((!bool) && (ap.zb())) {
        com.tencent.mm.plugin.sight.decode.a.b.wl();
      }
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "onResume start :%d", new Object[] { Integer.valueOf(this.lBf) });
      com.tencent.mm.sdk.f.e.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14924608700416L, 111197);
          if (bool)
          {
            com.tencent.mm.modelstat.d.a(3, "En_5b8fbb1e" + HomeUI.this.uOX.bVa(), hashCode());
            HomeUI.this.uOy = bf.Nz();
            GMTrace.o(14924608700416L, 111197);
            return;
          }
          HomeUI.this.dS(3, HomeUI.this.lBf);
          GMTrace.o(14924608700416L, 111197);
        }
      }, "directReport_onResume");
      if (bool) {
        this.uOy = bf.Nz();
      }
      com.tencent.mm.ui.widget.j.b(this.uOv);
      this.uOv.O(1.0F);
      this.uOu = a.uPF;
      if (this.uPl.size() != 0) {
        ((i)this.uPl.get(Integer.valueOf(this.lBf))).bOl();
      }
      if (((this.uOX == null) || (!this.uOX.hMt)) && (l.a.szR != null) && (l.a.szS != null) && (!bf.mA(l.a.szS.aGo())))
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "launcher onResume end track %s", new Object[] { l.a.szR.aGe() });
        localObject = new el();
        ((el)localObject).fIe.username = l.a.szR.aGe();
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      }
      if (this.uOl)
      {
        this.uOl = false;
        bPt();
      }
      com.tencent.mm.x.m.Bw();
      localObject = ao.hlE.A("login_user_name", "");
      if (((ap.za()) || (!((String)localObject).equals(""))) && (!ap.zb())) {
        com.tencent.mm.kernel.h.vG().initialize();
      }
      l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.LauncherUI", "[Launching Application]");
      com.tencent.mm.kernel.k.e(this.uOv, false);
      com.tencent.mm.kernel.k.f(this.uOv, false);
      l3 = System.currentTimeMillis();
      if (this.uOh)
      {
        this.uOh = false;
        SC("tab_main");
      }
      if (!this.uOv.getSharedPreferences(aa.bIN(), 0).getBoolean("settings_landscape_mode", false)) {
        break label1424;
      }
      this.uOv.setRequestedOrientation(-1);
      l4 = System.currentTimeMillis();
      if (LauncherUI.bPy() != null)
      {
        ap.yY();
        com.tencent.mm.u.c.wW().a(this);
        ap.yY();
        com.tencent.mm.u.c.vr().a(this.uOI);
        com.tencent.mm.q.c.uk().a(this.uOH);
        com.tencent.mm.sdk.b.a.uql.b(this.uOP);
        com.tencent.mm.sdk.b.a.uql.b(this.uOJ);
        com.tencent.mm.sdk.b.a.uql.b(this.uNJ);
        com.tencent.mm.sdk.b.a.uql.b(this.uOS);
        com.tencent.mm.sdk.b.a.uql.b(this.uOR);
        bPk();
        bPs();
        bPc();
        bPg();
        kh(false);
        com.tencent.mm.sdk.b.a.uql.b(this.uOG);
        if (this.uOv.getIntent() == null) {
          break label1435;
        }
        localObject = com.tencent.mm.sdk.platformtools.r.i(this.uOv.getIntent(), "LauncherUI.Show.Update.DialogMsg");
        if (!bf.mA((String)localObject))
        {
          this.uOv.getIntent().putExtra("LauncherUI.Show.Update.DialogMsg", "");
          ki(false);
          SC("tab_main");
          com.tencent.mm.plugin.report.service.g.oSF.a(405L, 33L, 1L, true);
          com.tencent.mm.ui.base.g.a(this.uOv, (String)localObject, getString(R.l.fcO), getString(R.l.fcP), getString(R.l.fcN), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(14973732388864L, 111563);
              com.tencent.mm.plugin.report.service.g.oSF.i(11584, new Object[] { Integer.valueOf(1) });
              com.tencent.mm.plugin.report.service.g.oSF.a(405L, 34L, 1L, true);
              paramAnonymousDialogInterface = com.tencent.mm.sdk.platformtools.r.i(HomeUI.this.uOv.getIntent(), "LauncherUI.Show.Update.Url");
              if (bf.mA(paramAnonymousDialogInterface))
              {
                paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.tencent.mm"));
                paramAnonymousDialogInterface.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
                paramAnonymousDialogInterface.setFlags(268435456);
                try
                {
                  HomeUI.this.uOv.startActivity(paramAnonymousDialogInterface);
                  GMTrace.o(14973732388864L, 111563);
                  return;
                }
                catch (Exception paramAnonymousDialogInterface)
                {
                  paramAnonymousDialogInterface = new Intent();
                  localObject = com.tencent.mm.sdk.platformtools.u.ea(HomeUI.this.uOv);
                  if (!bf.mA((String)localObject)) {
                    break label228;
                  }
                }
                paramAnonymousDialogInterface.putExtra("rawUrl", "http://www.wechat.com/en/");
                for (;;)
                {
                  paramAnonymousDialogInterface.putExtra("showShare", false);
                  paramAnonymousDialogInterface.putExtra("show_bottom", false);
                  paramAnonymousDialogInterface.putExtra("needRedirect", false);
                  paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
                  paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
                  paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
                  com.tencent.mm.bb.d.b(HomeUI.this.uOv, "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
                  GMTrace.o(14973732388864L, 111563);
                  return;
                  label228:
                  if ((((String)localObject).equals("zh_TW")) || (((String)localObject).equals("zh_HK"))) {
                    paramAnonymousDialogInterface.putExtra("rawUrl", "http://www.wechat.com/");
                  } else if (((String)localObject).equals("ja")) {
                    paramAnonymousDialogInterface.putExtra("rawUrl", "http://www.wechat.com/ja/");
                  } else if (((String)localObject).equals("ko")) {
                    paramAnonymousDialogInterface.putExtra("rawUrl", "http://www.wechat.com/ko/");
                  } else {
                    paramAnonymousDialogInterface.putExtra("rawUrl", "http://www.wechat.com/en/");
                  }
                }
              }
              Object localObject = new Intent();
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousDialogInterface);
              ((Intent)localObject).putExtra("showShare", false);
              ((Intent)localObject).putExtra("show_bottom", false);
              ((Intent)localObject).putExtra("needRedirect", false);
              ((Intent)localObject).putExtra("neverGetA8Key", true);
              ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
              ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
              com.tencent.mm.bb.d.b(HomeUI.this.uOv, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
              GMTrace.o(14973732388864L, 111563);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(18988587286528L, 141476);
              com.tencent.mm.plugin.report.service.g.oSF.i(11584, new Object[] { Integer.valueOf(2) });
              com.tencent.mm.plugin.report.service.g.oSF.a(405L, 35L, 1L, true);
              GMTrace.o(18988587286528L, 141476);
            }
          });
        }
        label687:
        localObject = new aw();
        com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
        if ((((aw)localObject).fEg.fEh) && (!bf.mA(((aw)localObject).fEg.fEi)))
        {
          com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "  now show msg:%s", new Object[] { ((aw)localObject).fEg.fEi });
          com.tencent.mm.ui.base.g.b(this.uOv, ((aw)localObject).fEg.fEi, ((aw)localObject).fEg.title, true);
        }
        if (this.uOQ != null) {
          com.tencent.mm.bb.d.b(this.uOv, "sandbox", ".updater.AppUpdaterUI", this.uOQ.intent);
        }
        this.uOQ = null;
        if (!a(this.uOO)) {
          ap.vL().e(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(18982950141952L, 141434);
              int j = 0;
              final Object localObject1 = aa.bIO();
              int i = j;
              if (f.sa())
              {
                long l1 = ((SharedPreferences)localObject1).getLong("show_sdcard_full_time", 0L);
                long l2 = System.currentTimeMillis();
                if (l2 - l1 <= 1800000L)
                {
                  i = j;
                  if (l1 <= l2) {}
                }
                else
                {
                  com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "summer show sd full tip");
                  ((SharedPreferences)localObject1).edit().putLong("show_sdcard_full_time", l2).commit();
                  com.tencent.mm.ui.base.g.b(HomeUI.this.uOv, HomeUI.this.getString(R.l.ePo), HomeUI.this.getString(R.l.ePp), HomeUI.this.getString(R.l.dGm), HomeUI.this.getString(R.l.dHp), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      GMTrace.i(18984694972416L, 141447);
                      ap.yY();
                      if (com.tencent.mm.u.c.isSDCardAvailable())
                      {
                        Intent localIntent = new Intent();
                        localIntent.putExtra("had_detected_no_sdcard_space", true);
                        com.tencent.mm.bb.d.b(HomeUI.this.uOv, "clean", ".ui.CleanUI", localIntent);
                      }
                      for (;;)
                      {
                        paramAnonymous2DialogInterface.dismiss();
                        com.tencent.mm.plugin.report.service.g.oSF.a(282L, 1L, 1L, false);
                        GMTrace.o(18984694972416L, 141447);
                        return;
                        com.tencent.mm.ui.base.s.eP(HomeUI.this.uOv);
                      }
                    }
                  }, null);
                  com.tencent.mm.plugin.report.service.g.oSF.a(282L, 0L, 1L, false);
                  i = 1;
                }
              }
              String str;
              if (i == 0)
              {
                ap.yY();
                boolean bool1 = ((Boolean)com.tencent.mm.u.c.vr().get(w.a.uzC, Boolean.valueOf(false))).booleanValue();
                if (bool1)
                {
                  ap.yY();
                  str = (String)com.tencent.mm.u.c.vr().get(6, "");
                  if (!bf.mA(str)) {
                    break label564;
                  }
                  ap.yY();
                  boolean bool2 = ((Boolean)com.tencent.mm.u.c.vr().get(w.a.uzD, Boolean.valueOf(false))).booleanValue();
                  ap.yY();
                  com.tencent.mm.storage.t localt = com.tencent.mm.u.c.vr();
                  w.a locala = w.a.uzE;
                  Object localObject2 = HomeUI.this;
                  localObject1 = HomeUI.this.getString(R.l.dNE);
                  localObject2 = ((HomeUI)localObject2).values.get(localObject1);
                  if (!(localObject2 instanceof String)) {
                    break label494;
                  }
                  com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "getString(): key=" + (String)localObject1 + ", value=" + localObject2.toString());
                  localObject1 = (String)localObject2;
                  localObject1 = (String)localt.get(locala, localObject1);
                  com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", new Object[] { Boolean.valueOf(bool1), str, Boolean.valueOf(bool2), localObject1 });
                  if (!bool2) {
                    break label500;
                  }
                  com.tencent.mm.ui.base.g.a(HomeUI.this.uOv, (String)localObject1, HomeUI.this.getString(R.l.dIG), HomeUI.this.getString(R.l.dHL), false, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      GMTrace.i(18984963407872L, 141449);
                      Intent localIntent = new Intent();
                      localIntent.setClassName(HomeUI.this.uOv, "com.tencent.mm.ui.account.bind.BindMobileUI");
                      localIntent.putExtra("kstyle_bind_wording", new BindWordingContent(localObject1, ""));
                      MMWizardActivity.w(HomeUI.this.uOv, localIntent);
                      paramAnonymous2DialogInterface.dismiss();
                      GMTrace.o(18984963407872L, 141449);
                    }
                  });
                }
              }
              for (;;)
              {
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uzC, Boolean.valueOf(false));
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uzE, "");
                ap.yY();
                com.tencent.mm.u.c.vr().jV(true);
                GMTrace.o(18982950141952L, 141434);
                return;
                label494:
                localObject1 = null;
                break;
                label500:
                com.tencent.mm.ui.base.g.b(HomeUI.this.uOv, (String)localObject1, HomeUI.this.getString(R.l.dIG), HomeUI.this.getString(R.l.dHL), HomeUI.this.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    GMTrace.i(18986708238336L, 141462);
                    Intent localIntent = new Intent();
                    localIntent.setClassName(HomeUI.this.uOv, "com.tencent.mm.ui.account.bind.BindMobileUI");
                    localIntent.putExtra("kstyle_bind_wording", new BindWordingContent(localObject1, ""));
                    MMWizardActivity.w(HomeUI.this.uOv, localIntent);
                    paramAnonymous2DialogInterface.dismiss();
                    GMTrace.o(18986708238336L, 141462);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    GMTrace.i(18988453068800L, 141475);
                    paramAnonymous2DialogInterface.dismiss();
                    GMTrace.o(18988453068800L, 141475);
                  }
                });
                continue;
                label564:
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "summerbindmobile has bind[%s]", new Object[] { str });
              }
            }
            
            public final String toString()
            {
              GMTrace.i(18983084359680L, 141435);
              String str = super.toString() + "|doOnResumeCheck";
              GMTrace.o(18983084359680L, 141435);
              return str;
            }
          }, 500L);
        }
        this.uOO = null;
        if (bPv())
        {
          Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
          {
            public final boolean queueIdle()
            {
              GMTrace.i(14992791306240L, 111705);
              long l = System.currentTimeMillis();
              if (HomeUI.this.uOY == null)
              {
                if (HomeUI.this.uOV == null) {
                  HomeUI.this.uOV = r.eC(HomeUI.this.uOv).inflate(R.i.cXf, null);
                }
                if (HomeUI.this.uOW == null) {
                  HomeUI.this.uOW = r.eC(HomeUI.this.uOv).inflate(R.i.cTs, null);
                }
              }
              com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "prepare chattingUI view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              GMTrace.o(14992791306240L, 111705);
              return false;
            }
          });
          this.uOL = new MessageQueue.IdleHandler()
          {
            @TargetApi(17)
            public final boolean queueIdle()
            {
              GMTrace.i(14969571639296L, 111532);
              try
              {
                if ((HomeUI.this.uOv.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (HomeUI.this.uOv.isDestroyed())))
                {
                  HomeUI.this.uOV = null;
                  HomeUI.this.uOW = null;
                  int i = Build.VERSION.SDK_INT;
                  if (Build.VERSION.SDK_INT >= 17) {}
                  for (boolean bool = HomeUI.this.uOv.isDestroyed();; bool = HomeUI.this.uOv.isFinishing())
                  {
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "prepare chattingUI but activity finished just ret sdk[%d] isDestroyed[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
                    GMTrace.o(14969571639296L, 111532);
                    return false;
                  }
                }
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "prepare chattingUI logic start");
                long l = System.currentTimeMillis();
                if (HomeUI.this.uOY == null)
                {
                  Object localObject = com.tencent.mm.u.m.xL();
                  localObject = new Intent().putExtra("Chat_User", (String)localObject);
                  HomeUI.this.af((Intent)localObject);
                  HomeUI.this.uOX.nfK = true;
                  HomeUI.this.uOX.bUU();
                  HomeUI.this.uOY.setVisibility(8);
                  HomeUI.this.uOX.uSN = true;
                  HomeUI.this.uOX.onPause();
                  HomeUI.this.uOX.bUR();
                  HomeUI.this.uOX.hMt = false;
                  HomeUI.this.bPk();
                  com.tencent.mm.ui.base.x.a(true, new Intent().putExtra("classname", LauncherUI.class.getName()));
                }
                HomeUI.this.uOV = null;
                HomeUI.this.uOW = null;
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "prepare chattingUI logic use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.LauncherUI", localException, "", new Object[0]);
                  new Handler().post(new Runnable()
                  {
                    public final void run()
                    {
                      GMTrace.i(16310943612928L, 121526);
                      throw new RuntimeException(localException);
                    }
                  });
                }
              }
              GMTrace.o(14969571639296L, 111532);
              return false;
            }
          };
          Looper.myQueue().addIdleHandler(this.uOL);
        }
        if (this.lBf != 0) {
          break label1447;
        }
        ap.getNotification().aw(true);
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - l4));
      localObject = (i)yX(this.lBf);
      if (localObject != null) {
        ((i)localObject).bOm();
      }
      com.tencent.mm.sdk.platformtools.v.v("MicroMsg.LauncherUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - l3));
      com.tencent.mm.x.b.a(com.tencent.mm.u.m.xL(), false, -1);
      this.uOh = false;
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - l2));
      int i = com.tencent.mm.sdk.platformtools.r.a(this.uOv.getIntent(), "preferred_tab", 0);
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "KEVIN onNewIntent, tabIdx = %d", new Object[] { Integer.valueOf(i) });
      if (i != 0)
      {
        yW(i);
        this.uOv.getIntent().putExtra("preferred_tab", 0);
      }
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "initView " + (System.currentTimeMillis() - l1));
      if (this.uOl)
      {
        this.uOl = false;
        bPt();
      }
      localObject = com.tencent.mm.app.l.os();
      ((com.tencent.mm.app.l)localObject).fwJ = true;
      ((com.tencent.mm.app.l)localObject).fwK.removeMessages(63537);
      ((com.tencent.mm.app.l)localObject).fwK.removeMessages(62537);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - l1));
      if (this.uOm != null) {
        this.uOm.bOo();
      }
      if ((this.uOX != null) && (this.uOX.bPY())) {
        this.uOX.uSO.mEnable = true;
      }
      if (com.tencent.mm.u.m.yt().booleanValue()) {
        bPe();
      }
      i = com.tencent.mm.bg.a.dJ(aa.getContext());
      l1 = System.currentTimeMillis();
      if (l1 - aa.getContext().getSharedPreferences(aa.bIN() + "_font_size_report_time", 4).getLong("font_size_report_time", 0L) > 604800000L)
      {
        com.tencent.mm.plugin.report.service.g.oSF.i(14239, new Object[] { Integer.valueOf(i) });
        aa.getContext().getSharedPreferences(aa.bIN() + "_font_size_report_time", 4).edit().putLong("font_size_report_time", l1).commit();
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "using font size kvReport logID:%d , usingFontSize: %d", new Object[] { Integer.valueOf(14239), Integer.valueOf(i) });
      }
      GMTrace.o(14976014090240L, 111580);
      return;
      bool = this.uOX.hMt;
      break;
      label1424:
      this.uOv.setRequestedOrientation(1);
      break label428;
      label1435:
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.LauncherUI", "dz[getIntent is null!]");
      break label687;
      label1447:
      ap.getNotification().aw(false);
    }
  }
  
  protected final void bPc()
  {
    GMTrace.i(14976282525696L, 111582);
    this.uOe = true;
    ae.I(this.uOx);
    ae.v(this.uOx);
    GMTrace.o(14976282525696L, 111582);
  }
  
  protected final void bPd()
  {
    GMTrace.i(14976416743424L, 111583);
    this.uOe = true;
    ae.I(this.uOx);
    ae.f(this.uOx, 300L);
    GMTrace.o(14976416743424L, 111583);
  }
  
  public final void bPf()
  {
    GMTrace.i(14976953614336L, 111587);
    if ((this.uOp == null) || (!ap.zb()))
    {
      GMTrace.o(14976953614336L, 111587);
      return;
    }
    if (this.uOp.isShowing())
    {
      this.uOp.dismiss();
      GMTrace.o(14976953614336L, 111587);
      return;
    }
    this.uOp.dL();
    GMTrace.o(14976953614336L, 111587);
  }
  
  public final void bPg()
  {
    GMTrace.i(14977087832064L, 111588);
    if (!ap.zb())
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.LauncherUI", "want update more menu new tips, but mmcore not ready");
      GMTrace.o(14977087832064L, 111588);
      return;
    }
    boolean bool3 = com.tencent.mm.q.c.uk().aC(262156, 266241);
    boolean bool4 = com.tencent.mm.q.c.uk().aD(262156, 266241);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "hasMallNew: %s, hasMallDot: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
    boolean bool2;
    boolean bool1;
    if (!bool3)
    {
      bool2 = bool4;
      bool1 = bool3;
      if (!bool4) {}
    }
    else
    {
      ap.yY();
      long l1 = ((Long)com.tencent.mm.u.c.vr().get(w.a.uGo, Long.valueOf(-1L))).longValue();
      long l2 = bf.getLong(com.tencent.mm.i.g.sV().getValue("PayWalletRedDotExpire"), -1L);
      long l3 = System.currentTimeMillis();
      double d = (l3 - l1) / 8.64E7D;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(86400000L * l2), Long.valueOf(l3), Double.valueOf(d) });
      bool2 = bool4;
      bool1 = bool3;
      if (l1 > 0L)
      {
        bool2 = bool4;
        bool1 = bool3;
        if (l2 > 0L)
        {
          bool2 = bool4;
          bool1 = bool3;
          if (d >= l2)
          {
            com.tencent.mm.q.c.uk().s(262156, false);
            bool1 = false;
            bool2 = false;
          }
        }
      }
    }
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "after check, hasMallNew: %s, hasMallDot: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    bool3 = com.tencent.mm.q.c.uk().aC(262145, 266241);
    bool4 = com.tencent.mm.q.c.uk().aD(266260, 266241);
    boolean bool5 = com.tencent.mm.q.c.uk().aC(262147, 266241);
    boolean bool6 = com.tencent.mm.q.c.uk().aC(262149, 266241);
    boolean bool7 = com.tencent.mm.q.c.uk().aD(262152, 266256);
    boolean bool8 = com.tencent.mm.q.c.uk().aC(262152, 266256);
    Object localObject = (com.tencent.mm.plugin.welab.a.a.c)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.c.class);
    int i;
    if (localObject != null) {
      if ((((com.tencent.mm.plugin.welab.a.a.c)localObject).bAC()) || (((com.tencent.mm.plugin.welab.a.a.c)localObject).bAD())) {
        i = 1;
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.q.c.uk();
      label464:
      int k;
      if (!((com.tencent.mm.q.a)localObject).gUE)
      {
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.NewBadge", "hasUnreadNum NewBadge has not initialized");
        j = 0;
        localObject = l.a.szP;
        if ((localObject == null) || ((!((l.c)localObject).afD()) && (!((l.c)localObject).afE()))) {
          break label625;
        }
        k = 1;
        label497:
        if ((k == 0) || ((!bool7) && (!bool8) && (j <= 0))) {
          break label631;
        }
      }
      label625:
      label631:
      for (int j = 1;; j = 0)
      {
        if ((!bool2) && (!bool1) && (!bool3) && (j == 0) && (!bool5) && (!bool6) && (!bool4) && (i == 0)) {
          break label637;
        }
        this.uOm.kc(true);
        GMTrace.o(14977087832064L, 111588);
        return;
        i = 0;
        break;
        localObject = ((com.tencent.mm.q.a)localObject).gUC.p(262152, 266256, 4);
        if (localObject == null)
        {
          j = 0;
          break label464;
        }
        j = com.tencent.mm.q.a.parseInt(((com.tencent.mm.q.b.a)localObject).value);
        break label464;
        k = 0;
        break label497;
      }
      label637:
      this.uOm.kc(false);
      GMTrace.o(14977087832064L, 111588);
      return;
      i = 0;
    }
  }
  
  final void bPh()
  {
    GMTrace.i(14977356267520L, 111590);
    if (!((com.tencent.mm.plugin.fts.a.l)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).isFTSIndexReady())
    {
      Toast.makeText(aa.getContext(), R.l.ePU, 0).show();
      GMTrace.o(14977356267520L, 111590);
      return;
    }
    Object localObject = new Intent().putExtra("from_tab_index", this.lBf).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    com.tencent.mm.bb.d.b(this.uOv, "search", ".ui.FTSMainUI", (Intent)localObject);
    int i;
    if (this.lBf == 0) {
      i = 1;
    }
    for (;;)
    {
      localObject = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      com.tencent.mm.sdk.platformtools.v.v("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick:%d %s", new Object[] { Integer.valueOf(10991), localObject });
      com.tencent.mm.plugin.report.service.g.oSF.A(10991, (String)localObject);
      GMTrace.o(14977356267520L, 111590);
      return;
      if (this.lBf == 1) {
        i = 2;
      } else if (this.lBf == 2) {
        i = 3;
      } else if (this.lBf == 3) {
        i = 4;
      } else {
        i = 0;
      }
    }
  }
  
  public final com.tencent.mm.y.e bPj()
  {
    GMTrace.i(14977758920704L, 111593);
    if (this.uOg == null) {
      this.uOg = new com.tencent.mm.y.e()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
        {
          GMTrace.i(18985097625600L, 141450);
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "summeralert onSceneEnd " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + " errMsg " + paramAnonymousString + "  " + paramAnonymousk.getType());
          if (HomeUI.this.isb != null)
          {
            HomeUI.this.isb.dismiss();
            HomeUI.this.isb = null;
          }
          if (paramAnonymousk.getType() == 255)
          {
            ap.vd().b(255, HomeUI.this.uOg);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              HomeUI.this.gN(true);
              GMTrace.o(18985097625600L, 141450);
              return;
            }
            if (p.a.a(HomeUI.this.uOv, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, 4))
            {
              GMTrace.o(18985097625600L, 141450);
              return;
            }
            HomeUI.this.gN(false);
            GMTrace.o(18985097625600L, 141450);
            return;
          }
          if (paramAnonymousk.getType() == 384)
          {
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              ap.yY();
              com.tencent.mm.u.c.vr().set(77830, ((ai)paramAnonymousk).Fv());
              paramAnonymousString = new Intent();
              paramAnonymousString.putExtra("kintent_hint", HomeUI.this.getString(R.l.eSR));
              com.tencent.mm.bb.d.b(HomeUI.this.uOv, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", paramAnonymousString);
              GMTrace.o(18985097625600L, 141450);
              return;
            }
            HomeUI.this.piL = true;
            com.tencent.mm.ui.base.g.a(HomeUI.this.uOv, R.l.eTe, R.l.dIG, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(14923266523136L, 111187);
                HomeUI.this.bPw();
                GMTrace.o(14923266523136L, 111187);
              }
            });
          }
          GMTrace.o(18985097625600L, 141450);
        }
      };
    }
    com.tencent.mm.y.e locale = this.uOg;
    GMTrace.o(14977758920704L, 111593);
    return locale;
  }
  
  public final void bPk()
  {
    GMTrace.i(14978027356160L, 111595);
    com.tencent.mm.ui.conversation.j localj = (com.tencent.mm.ui.conversation.j)this.uPl.get(Integer.valueOf(0));
    if (localj != null)
    {
      if (localj.vZM != null) {
        localj.vZM.bXA();
      }
      localj.bYC();
    }
    GMTrace.o(14978027356160L, 111595);
  }
  
  public final void bPl()
  {
    GMTrace.i(14978161573888L, 111596);
    com.tencent.mm.ui.conversation.j localj = (com.tencent.mm.ui.conversation.j)this.uPl.get(Integer.valueOf(0));
    if (localj != null) {
      localj.bYD();
    }
    GMTrace.o(14978161573888L, 111596);
  }
  
  public final void bPm()
  {
    GMTrace.i(16019556925440L, 119355);
    this.uOY.haf = 0;
    GMTrace.o(16019556925440L, 119355);
  }
  
  public final void bPn()
  {
    GMTrace.i(16019691143168L, 119356);
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18986305585152L, 141459);
        ap.vL().bJa();
        ae.yq(0);
        HomeUI.this.uOY.bZK();
        HomeUI.this.uOX.nfK = true;
        HomeUI.this.uOX.bUU();
        HomeUI.this.uOX.li(false);
        HomeUI.this.bPu();
        GMTrace.o(18986305585152L, 141459);
      }
      
      public final String toString()
      {
        GMTrace.i(18986439802880L, 141460);
        String str = super.toString() + "|chattingView_onAnimationEnd";
        GMTrace.o(18986439802880L, 141460);
        return str;
      }
    });
    GMTrace.o(16019691143168L, 119356);
  }
  
  void bPq()
  {
    GMTrace.i(14979235315712L, 111604);
    if ((this.uOX != null) && (this.uOX.hMt))
    {
      GMTrace.o(14979235315712L, 111604);
      return;
    }
    this.Gx.setLogo(new ColorDrawable(this.uOv.getResources().getColor(17170445)));
    this.Gx.cK();
    this.Gx.setDisplayHomeAsUpEnabled(false);
    this.Gx.cJ();
    this.Gx.cL();
    this.Gx.setCustomView(r.eC(this.uOv).inflate(R.i.cTt, new LinearLayout(this.uOv), false));
    ajd();
    this.Gx.getCustomView().findViewById(R.h.bna).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(18985366061056L, 141452);
        if (SystemClock.elapsedRealtime() - HomeUI.this.qpr < 300L)
        {
          paramAnonymousView = HomeUI.this.uPj.iterator();
          while (paramAnonymousView.hasNext()) {
            ((Runnable)paramAnonymousView.next()).run();
          }
        }
        HomeUI.this.qpr = SystemClock.elapsedRealtime();
        GMTrace.o(18985366061056L, 141452);
      }
    });
    GMTrace.o(14979235315712L, 111604);
  }
  
  public final int bPr()
  {
    GMTrace.i(14980040622080L, 111610);
    long l = System.currentTimeMillis();
    int i;
    if (!ap.zb())
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
      i = 0;
    }
    for (;;)
    {
      yY(i);
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "unreadcheck setConversationTagUnread  last time %d, unread %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
      GMTrace.o(14980040622080L, 111610);
      return i;
      i = com.tencent.mm.u.p.a(com.tencent.mm.u.o.hkZ, y.bQw());
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", new Object[] { Integer.valueOf(i) });
    }
  }
  
  public final void bPs()
  {
    GMTrace.i(14980309057536L, 111612);
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18987916197888L, 141471);
        if (!ap.zb()) {
          com.tencent.mm.sdk.platformtools.v.w("MicroMsg.UnreadCountHelper", "getAddrTabUnreadCount, but mmcore not ready");
        }
        for (int i = 0;; i = com.tencent.mm.platformtools.u.f((Integer)com.tencent.mm.u.c.vr().get(143618, null)))
        {
          if (HomeUI.this.uOm != null) {
            HomeUI.this.uOm.yR(i);
          }
          GMTrace.o(18987916197888L, 141471);
          return;
          ap.yY();
        }
      }
      
      public final String toString()
      {
        GMTrace.i(18988050415616L, 141472);
        String str = super.toString() + "|setAddressTagUnread";
        GMTrace.o(18988050415616L, 141472);
        return str;
      }
    });
    GMTrace.o(14980309057536L, 111612);
  }
  
  public final void bPu()
  {
    boolean bool = true;
    GMTrace.i(14980845928448L, 111616);
    if (!bPv())
    {
      GMTrace.o(14980845928448L, 111616);
      return;
    }
    if (this.uOX == null) {}
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.uOX != null) {
        this.uOX.uSO.wrX = false;
      }
      GMTrace.o(14980845928448L, 111616);
      return;
      bool = false;
    }
  }
  
  final boolean bPv()
  {
    GMTrace.i(14980980146176L, 111617);
    if ((com.tencent.mm.compatible.util.d.eo(19)) && (com.tencent.mm.compatible.h.a.rX()) && (!com.tencent.mm.compatible.e.b.ay(this.uOv)))
    {
      GMTrace.o(14980980146176L, 111617);
      return true;
    }
    GMTrace.o(14980980146176L, 111617);
    return false;
  }
  
  public final void bPw()
  {
    GMTrace.i(14981382799360L, 111620);
    if (this.piK != null)
    {
      this.piK.show();
      GMTrace.o(14981382799360L, 111620);
      return;
    }
    if (this.piH == null)
    {
      this.piH = View.inflate(this.uOv, R.i.dnH, null);
      this.piI = ((TextView)this.piH.findViewById(R.h.cCr));
      this.piI.setText(getString(R.l.eSw));
      this.piJ = ((EditText)this.piH.findViewById(R.h.cCq));
      this.piJ.setInputType(129);
    }
    this.piK = com.tencent.mm.ui.base.g.a(this.uOv, null, this.piH, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(14970376945664L, 111538);
        paramAnonymousDialogInterface = HomeUI.this.piJ.getText().toString();
        HomeUI.this.piJ.setText("");
        HomeUI.this.piJ.clearFocus();
        com.tencent.mm.platformtools.u.a(HomeUI.this.uOv, HomeUI.this.piJ);
        if ((paramAnonymousDialogInterface == null) || (paramAnonymousDialogInterface.equals("")))
        {
          com.tencent.mm.ui.base.g.a(HomeUI.this.uOv, R.l.eZP, R.l.dIG, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              GMTrace.i(18984426536960L, 141445);
              GMTrace.o(18984426536960L, 141445);
            }
          });
          GMTrace.o(14970376945664L, 111538);
          return;
        }
        HomeUI.this.bPj();
        ap.vd().a(384, HomeUI.this.uOg);
        paramAnonymousDialogInterface = new ai(paramAnonymousDialogInterface, "", "", "");
        ap.vd().a(paramAnonymousDialogInterface, 0);
        HomeUI localHomeUI = HomeUI.this;
        MMFragmentActivity localMMFragmentActivity = HomeUI.this.uOv;
        HomeUI.this.getString(R.l.dIG);
        localHomeUI.isb = com.tencent.mm.ui.base.g.a(localMMFragmentActivity, HomeUI.this.getString(R.l.eSD), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            GMTrace.i(18985634496512L, 141454);
            ap.vd().b(384, HomeUI.this.uOg);
            HomeUI.this.uOg = null;
            ap.vd().c(paramAnonymousDialogInterface);
            GMTrace.o(18985634496512L, 141454);
          }
        });
        GMTrace.o(14970376945664L, 111538);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(18983352795136L, 141437);
        HomeUI.this.piJ.setText("");
        HomeUI.this.piK.dismiss();
        GMTrace.o(18983352795136L, 141437);
      }
    });
    GMTrace.o(14981382799360L, 111620);
  }
  
  public final void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    GMTrace.i(14976819396608L, 111586);
    if (this.qMT != null)
    {
      this.qMT.clearAnimation();
      this.qMT.setVisibility(8);
      if (paramBoolean1.booleanValue())
      {
        if (!paramBoolean2.booleanValue()) {
          break label97;
        }
        ap.yY();
        com.tencent.mm.u.c.vr().set(340227, Boolean.valueOf(true));
        com.tencent.mm.plugin.report.service.g.oSF.a(232L, 0L, 1L, false);
        uOq = Boolean.valueOf(false);
      }
    }
    for (;;)
    {
      this.qMT = null;
      GMTrace.o(14976819396608L, 111586);
      return;
      label97:
      ap.yY();
      com.tencent.mm.u.c.vr().set(340230, Boolean.valueOf(true));
      com.tencent.mm.plugin.report.service.g.oSF.a(232L, 5L, 1L, false);
      uOr = Boolean.valueOf(false);
    }
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, final String paramString)
  {
    GMTrace.i(16019422707712L, 119354);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "summeralert jumpByActionType  alertId[%d], actionType[%d], btnId[%d], url[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    com.tencent.mm.plugin.report.service.g.oSF.i(13191, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Boolean.valueOf(false) });
    switch (paramInt2)
    {
    }
    for (;;)
    {
      GMTrace.o(16019422707712L, 119354);
      return;
      GMTrace.o(16019422707712L, 119354);
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramString);
      ((Intent)localObject).putExtra("showShare", false);
      ((Intent)localObject).putExtra("show_bottom", false);
      ((Intent)localObject).putExtra("needRedirect", false);
      ((Intent)localObject).putExtra("neverGetA8Key", true);
      ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.sXt);
      ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.sXq);
      com.tencent.mm.bb.d.b(this.uOv, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      GMTrace.o(16019422707712L, 119354);
      return;
      if (this.piL)
      {
        gN(true);
        GMTrace.o(16019422707712L, 119354);
        return;
      }
      bPj();
      ap.vd().a(255, this.uOg);
      paramString = new com.tencent.mm.modelsimple.v(1);
      ap.vd().a(paramString, 0);
      localObject = this.uOv;
      getString(R.l.dIG);
      this.isb = com.tencent.mm.ui.base.g.a((Context)localObject, getString(R.l.eSD), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(18983621230592L, 141439);
          ap.vd().c(paramString);
          GMTrace.o(18983621230592L, 141439);
        }
      });
      GMTrace.o(16019422707712L, 119354);
      return;
      paramString = new Intent();
      paramString.setClass(this.uOv, BindMContactUI.class);
      paramString.putExtra("is_bind_for_change_mobile", true);
      localObject = ((TelephonyManager)this.uOv.getSystemService("phone")).getSimCountryIso();
      if (!bf.mA((String)localObject))
      {
        localObject = com.tencent.mm.ai.b.g(this.uOv, (String)localObject, this.uOv.getString(R.l.bGH));
        if (localObject != null)
        {
          paramString.putExtra("country_name", ((com.tencent.mm.ai.b.a)localObject).hJn);
          paramString.putExtra("couttry_code", ((com.tencent.mm.ai.b.a)localObject).hJm);
        }
      }
      MMWizardActivity.w(this.uOv, paramString);
      GMTrace.o(16019422707712L, 119354);
      return;
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 1);
      paramString.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
      paramString.setFlags(65536);
      if ((!com.tencent.mm.n.a.aI(this.uOv)) && (!com.tencent.mm.n.a.aH(this.uOv))) {
        com.tencent.mm.bb.d.b(this.uOv, "scanner", ".ui.BaseScanUI", paramString);
      }
    }
  }
  
  public final void dR(int paramInt1, int paramInt2)
  {
    GMTrace.i(14978295791616L, 111597);
    if (paramInt1 == paramInt2)
    {
      GMTrace.o(14978295791616L, 111597);
      return;
    }
    if ((this.uOT == paramInt2) && (this.uOU == paramInt1))
    {
      GMTrace.o(14978295791616L, 111597);
      return;
    }
    this.uOT = paramInt2;
    this.uOU = paramInt1;
    yX(paramInt1);
    q localq = yX(paramInt2);
    if ((localq != null) && ((localq instanceof i))) {
      ((i)localq).bOX();
    }
    dS(4, paramInt1);
    dS(3, paramInt2);
    GMTrace.o(14978295791616L, 111597);
  }
  
  public final void dS(int paramInt1, int paramInt2)
  {
    GMTrace.i(14981248581632L, 111619);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "clickFlowStat index:%d op:%d %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bf.bJP() });
    if (paramInt2 < 0)
    {
      GMTrace.o(14981248581632L, 111619);
      return;
    }
    String str = "MainUI";
    if (paramInt2 == 1) {
      str = "AddressUI";
    }
    if (paramInt2 == 2) {
      str = "FindMoreFriendUI";
    }
    if (paramInt2 == 3) {
      str = "MoreTabUI";
    }
    com.tencent.mm.modelstat.d.a(paramInt1, str, this.uOv.hashCode() / 16 * 16 + paramInt2);
    GMTrace.o(14981248581632L, 111619);
  }
  
  public final void gN(boolean paramBoolean)
  {
    GMTrace.i(14977893138432L, 111594);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "summeralert handlePassword " + paramBoolean);
    if (paramBoolean)
    {
      bPw();
      GMTrace.o(14977893138432L, 111594);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("kintent_hint", getString(R.l.eSR));
    com.tencent.mm.bb.d.b(this.uOv, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", localIntent);
    GMTrace.o(14977893138432L, 111594);
  }
  
  public final String getString(int paramInt)
  {
    GMTrace.i(14977490485248L, 111591);
    String str = this.uOv.getString(paramInt);
    GMTrace.o(14977490485248L, 111591);
    return str;
  }
  
  public final void kh(boolean paramBoolean)
  {
    GMTrace.i(14977222049792L, 111589);
    if ((this.uOp == null) || (this.uOz == null))
    {
      GMTrace.o(14977222049792L, 111589);
      return;
    }
    if (!ap.zb())
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.LauncherUI", "want update more menu new tips, but mmcore not ready");
      GMTrace.o(14977222049792L, 111589);
      return;
    }
    this.uOp.uUc.kx(paramBoolean);
    if (this.uOp.uUc.uTV > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.uOB.setVisibility(0);
      GMTrace.o(14977222049792L, 111589);
      return;
    }
    this.uOB.setVisibility(8);
    GMTrace.o(14977222049792L, 111589);
  }
  
  public final void ki(boolean paramBoolean)
  {
    GMTrace.i(14979101097984L, 111603);
    boolean bool;
    if (this.uOY == null)
    {
      bool = false;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.lBf != 0) || (!com.tencent.mm.kernel.h.vH().gXs.foreground)) {
        break label138;
      }
      ap.getNotification().aw(true);
    }
    for (;;)
    {
      if ((this.uOX != null) && (this.uOX.bPY())) {
        com.tencent.mm.ui.widget.j.b(this.uOv);
      }
      if ((this.uOY != null) && (this.uOY.getVisibility() != 8) && (this.uOX != null)) {
        break label150;
      }
      GMTrace.o(14979101097984L, 111603);
      return;
      bool = this.uOY.isShown();
      break;
      label138:
      ap.getNotification().aw(false);
    }
    label150:
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "closeChatting");
    bPk();
    com.tencent.mm.sdk.f.e.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(18985231843328L, 141451);
        com.tencent.mm.modelstat.d.a(4, "En_5b8fbb1e" + HomeUI.this.uOX.bVa(), HomeUI.this.uOX.hashCode());
        com.tencent.mm.modelstat.d.d("En_5b8fbb1e" + HomeUI.this.uOX.bVa(), HomeUI.this.uOy, bf.Nz());
        GMTrace.o(18985231843328L, 141451);
      }
    }, "directReport_closeChatting");
    this.uOY.setVisibility(8);
    this.uPi = true;
    if (this.uPf == null)
    {
      this.uPf = AnimationUtils.loadAnimation(this.uOv, MMFragmentActivity.a.uTd);
      this.uPf.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          GMTrace.i(18987781980160L, 141470);
          ap.vL().bJa();
          ae.yq(0);
          if (HomeUI.this.uOe)
          {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "start  setAppTagUnreadNow");
            HomeUI.this.bPc();
          }
          HomeUI.this.bPu();
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "klem pop out onAnimationEnd");
          GMTrace.o(18987781980160L, 141470);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
          GMTrace.i(18987647762432L, 141469);
          GMTrace.o(18987647762432L, 141469);
        }
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          GMTrace.i(18987513544704L, 141468);
          ap.vL().bIX();
          ae.yq(-8);
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "klem pop out onAnimationStart");
          HomeUI.this.kj(true);
          GMTrace.o(18987513544704L, 141468);
        }
      });
    }
    this.uOX.onPause();
    this.uOX.bUR();
    this.uOX.hMt = false;
    dS(3, this.lBf);
    com.tencent.mm.ui.base.x.a(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
    if (paramBoolean) {
      this.uOY.startAnimation(this.uPf);
    }
    for (;;)
    {
      if (!this.uOX.bPY()) {
        bPq();
      }
      this.uOv.aQ();
      com.tencent.mm.ui.conversation.j localj = (com.tencent.mm.ui.conversation.j)this.uPl.get(Integer.valueOf(0));
      if (localj != null)
      {
        View localView = localj.uRf.ipa;
        if (localj.uRf != null) {
          localj.uRf.onResume();
        }
        localj.onHiddenChanged(false);
      }
      if (com.tencent.mm.u.m.yt().booleanValue()) {
        bPe();
      }
      GMTrace.o(14979101097984L, 111603);
      return;
      this.uOv.O(1.0F);
      bPu();
    }
  }
  
  public final void kj(boolean paramBoolean)
  {
    GMTrace.i(16019959578624L, 119358);
    if (a.uPF != this.uOu)
    {
      GMTrace.o(16019959578624L, 119358);
      return;
    }
    this.uOv.d(paramBoolean, 0);
    GMTrace.o(16019959578624L, 119358);
  }
  
  public final void yV(int paramInt)
  {
    GMTrace.i(14978430009344L, 111598);
    q localq = yX(paramInt);
    if (localq == null)
    {
      GMTrace.o(14978430009344L, 111598);
      return;
    }
    if ((localq instanceof i))
    {
      ((i)localq).bOn();
      if (this.uOF != null) {
        this.uOF.reset();
      }
    }
    GMTrace.o(14978430009344L, 111598);
  }
  
  public final void yW(int paramInt)
  {
    GMTrace.i(14979772186624L, 111608);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lBf), Boolean.valueOf(this.uOj), Integer.valueOf(this.uPl.size()) });
    if ((!this.uOj) || (paramInt < 0) || ((this.uOo != null) && (paramInt > this.uOo.getCount() - 1)))
    {
      GMTrace.o(14979772186624L, 111608);
      return;
    }
    if ((this.lBf == paramInt) && (this.uPl.size() != 0))
    {
      GMTrace.o(14979772186624L, 111608);
      return;
    }
    this.lBf = paramInt;
    if (this.uOm != null) {
      this.uOm.lF(this.lBf);
    }
    if (this.uOn != null)
    {
      this.uOn.k(this.lBf, false);
      yV(this.lBf);
    }
    if ((this.lBf == 0) && (com.tencent.mm.kernel.h.vH().gXs.foreground))
    {
      ap.getNotification().aw(true);
      GMTrace.o(14979772186624L, 111608);
      return;
    }
    ap.getNotification().aw(false);
    GMTrace.o(14979772186624L, 111608);
  }
  
  public final q yX(int paramInt)
  {
    q localq = null;
    GMTrace.i(14979906404352L, 111609);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "get tab %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      GMTrace.o(14979906404352L, 111609);
      return null;
    }
    if (this.uPl.containsKey(Integer.valueOf(paramInt)))
    {
      localq = (q)this.uPl.get(Integer.valueOf(paramInt));
      GMTrace.o(14979906404352L, 111609);
      return localq;
    }
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.v.v("MicroMsg.LauncherUI", "createFragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localq != null) {
        localq.a(this.uOv);
      }
      this.uPl.put(Integer.valueOf(paramInt), localq);
      GMTrace.o(14979906404352L, 111609);
      return localq;
      localBundle.putInt(com.tencent.mm.ui.conversation.j.class.getName(), 0);
      localq = (q)Fragment.a(this.uOv, com.tencent.mm.ui.conversation.j.class.getName(), localBundle);
      ap.getNotification().aw(true);
      continue;
      localBundle.putInt(AddressUI.a.class.getName(), 1);
      localBundle.putBoolean("Need_Voice_Search", true);
      localBundle.putBoolean("favour_include_biz", true);
      localq = (q)Fragment.a(this.uOv, AddressUI.a.class.getName(), localBundle);
      continue;
      localBundle.putInt(g.class.getName(), 2);
      localq = (q)Fragment.a(this.uOv, g.class.getName(), localBundle);
      continue;
      localBundle.putInt(s.class.getName(), 3);
      localq = (q)Fragment.a(this.uOv, s.class.getName(), localBundle);
    }
  }
  
  public final void yY(int paramInt)
  {
    GMTrace.i(14980174839808L, 111611);
    if (this.uOm != null)
    {
      this.uOm.yQ(paramInt);
      ajd();
    }
    GMTrace.o(14980174839808L, 111611);
  }
  
  public static class FitSystemWindowLayoutView
    extends FrameLayout
  {
    private Rect fv;
    public int uPI;
    public ViewGroup uPJ;
    
    public FitSystemWindowLayoutView(Context paramContext)
    {
      super();
      GMTrace.i(14974671912960L, 111570);
      this.fv = new Rect();
      this.uPJ = null;
      GMTrace.o(14974671912960L, 111570);
    }
    
    public FitSystemWindowLayoutView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      GMTrace.i(14974537695232L, 111569);
      this.fv = new Rect();
      this.uPJ = null;
      GMTrace.o(14974537695232L, 111569);
    }
    
    @TargetApi(14)
    public boolean fitSystemWindows(Rect paramRect)
    {
      GMTrace.i(14974806130688L, 111571);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d", new Object[] { paramRect.toString(), Integer.valueOf(this.uPI), Integer.valueOf(hashCode()) });
      this.uPI = paramRect.top;
      Object localObject1;
      int j;
      int k;
      int i;
      Object localObject2;
      label207:
      label259:
      label326:
      boolean bool;
      if ((this.uPJ != null) && ((this.uPJ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject1 = (ViewGroup.MarginLayoutParams)this.uPJ.getLayoutParams();
        j = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
        k = ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        i = 0;
        if (i < getChildCount())
        {
          localObject2 = getChildAt(i);
          if (!(localObject2 instanceof TestTimeForChatting)) {
            break label459;
          }
          localObject2 = (TestTimeForChatting)localObject2;
          if ((Float.compare(j, com.tencent.mm.bg.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 1.5F) > 0) || (j < 0))
          {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).wmM = 0;
            if ((Float.compare(k, com.tencent.mm.bg.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 1.5F) <= 0) && (k >= 0)) {
              break label449;
            }
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).wmN = 0;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          }
        }
        else
        {
          x.t(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
        }
      }
      else
      {
        this.fv.set(paramRect);
        if (!com.tencent.mm.compatible.util.d.eo(14)) {
          break label473;
        }
        i = 0;
        if (i >= getChildCount()) {
          break label473;
        }
        localObject1 = getChildAt(i);
        if (!(localObject1 instanceof TestTimeForChatting)) {
          break label466;
        }
        ((View)localObject1).setFitsSystemWindows(true);
        bool = ((TestTimeForChatting)localObject1).fitSystemWindows(paramRect);
        ((View)localObject1).setFitsSystemWindows(false);
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Build.VERSION.SDK_INT) });
        bool = super.fitSystemWindows(this.fv);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[] { Boolean.valueOf(bool) });
        GMTrace.o(14974806130688L, 111571);
        return bool;
        ((TestTimeForChatting)localObject2).wmM = j;
        break label207;
        label449:
        ((TestTimeForChatting)localObject2).wmN = k;
        break label259;
        label459:
        i += 1;
        break;
        label466:
        i += 1;
        break label326;
        label473:
        bool = false;
      }
    }
  }
  
  private static enum a
  {
    static
    {
      GMTrace.i(14919105773568L, 111156);
      uPE = new a("ACTIVITY_CREATE", 0);
      uPF = new a("ACTIVITY_RESUME", 1);
      uPG = new a("ACTIVITY_PAUSE", 2);
      uPH = new a[] { uPE, uPF, uPG };
      GMTrace.o(14919105773568L, 111156);
    }
    
    private a()
    {
      GMTrace.i(14918971555840L, 111155);
      GMTrace.o(14918971555840L, 111155);
    }
  }
  
  private final class b
    implements Runnable
  {
    int aMA;
    int fFI;
    Intent fFJ;
    int uPK;
    
    public b()
    {
      GMTrace.i(14992925523968L, 111706);
      this.uPK = 0;
      GMTrace.o(14992925523968L, 111706);
    }
    
    public final void run()
    {
      GMTrace.i(14993059741696L, 111707);
      if ((ap.zb()) && (HomeUI.this.uOj))
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.uPK) });
        HomeUI.this.a(HomeUI.this.uOK, null, false);
        ae.v(new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            GMTrace.i(14967021502464L, 111513);
            if (HomeUI.this.uOX == null) {}
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B", new Object[] { Boolean.valueOf(bool) });
              if (HomeUI.this.uOX != null)
              {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "on select image ActivityResult. do post activity result");
                HomeUI.this.uOX.onActivityResult(HomeUI.b.this.fFI & 0xFFFF, HomeUI.b.this.aMA, HomeUI.b.this.fFJ);
              }
              GMTrace.o(14967021502464L, 111513);
              return;
              bool = false;
            }
          }
          
          public final String toString()
          {
            GMTrace.i(14967155720192L, 111514);
            String str = super.toString() + "|PostSelectImageJob_onActivityResult";
            GMTrace.o(14967155720192L, 111514);
            return str;
          }
        });
        GMTrace.o(14993059741696L, 111707);
        return;
      }
      if (this.uPK >= 3)
      {
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.LauncherUI", "on post select image job, match max retry count");
        GMTrace.o(14993059741696L, 111707);
        return;
      }
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.LauncherUI", "on post select image job, acc not ready or view init(%B), cur retry count %d", new Object[] { Boolean.valueOf(HomeUI.this.uOj), Integer.valueOf(this.uPK) });
      this.uPK += 1;
      ae.f(this, 300L);
      GMTrace.o(14993059741696L, 111707);
    }
    
    public final String toString()
    {
      GMTrace.i(14993193959424L, 111708);
      String str = super.toString() + "|PostSelectImageJob";
      GMTrace.o(14993193959424L, 111708);
      return str;
    }
  }
  
  public final class c
    extends android.support.v4.app.o
    implements ViewPager.e, c.a
  {
    private int qgn;
    private AddressUI.a uPM;
    private final WxViewPager uPN;
    private boolean uPO;
    
    public c(FragmentActivity paramFragmentActivity, WxViewPager paramWxViewPager)
    {
      super();
      GMTrace.i(14993462394880L, 111710);
      this.uPO = false;
      this.qgn = 0;
      this.uPN = paramWxViewPager;
      this.uPN.a(this);
      this.uPN.b(this);
      GMTrace.o(14993462394880L, 111710);
    }
    
    public final Fragment I(int paramInt)
    {
      GMTrace.i(14993730830336L, 111712);
      q localq = HomeUI.this.yX(paramInt);
      GMTrace.o(14993730830336L, 111712);
      return localq;
    }
    
    public final void V(int paramInt)
    {
      GMTrace.i(14993999265792L, 111714);
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "on page selected changed to %d", new Object[] { Integer.valueOf(paramInt) });
      com.tencent.mm.sdk.platformtools.v.v("MicroMsg.LauncherUI", "reportSwitch clickCount:%d, pos:%d", new Object[] { Integer.valueOf(this.qgn), Integer.valueOf(paramInt) });
      if (this.qgn > 0)
      {
        this.qgn -= 1;
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.uPO = false;
        HomeUI.this.dR(HomeUI.this.lNE, HomeUI.this.lBf);
        HomeUI.this.lNE = HomeUI.this.lBf;
        HomeUI.this.lBf = paramInt;
        if (HomeUI.this.uOm != null) {
          HomeUI.this.uOm.lF(paramInt);
        }
        HomeUI.this.uOv.aQ();
        if ((HomeUI.this.lNE == 1) && (HomeUI.this.lBf != 1))
        {
          ap.yY();
          com.tencent.mm.u.c.vr().set(340226, Long.valueOf(System.currentTimeMillis()));
        }
        if (HomeUI.this.lBf == 1)
        {
          long l = System.currentTimeMillis();
          ap.yY();
          if (l - bf.a((Long)com.tencent.mm.u.c.vr().get(340226, null), 0L) >= 180000L) {
            ((AddressUI.a)HomeUI.this.yX(HomeUI.this.lBf)).bXC();
          }
        }
        if (HomeUI.this.lBf != 0) {
          break;
        }
        ap.getNotification().aw(true);
        GMTrace.o(14993999265792L, 111714);
        return;
        com.tencent.mm.plugin.report.service.g.oSF.A(10957, "1");
        continue;
        com.tencent.mm.plugin.report.service.g.oSF.A(10957, "2");
        continue;
        com.tencent.mm.plugin.report.service.g.oSF.A(10957, "3");
        continue;
        com.tencent.mm.plugin.report.service.g.oSF.A(10957, "4");
        continue;
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          com.tencent.mm.plugin.report.service.g.oSF.A(10957, "5");
          break;
        case 1: 
          com.tencent.mm.plugin.report.service.g.oSF.A(10957, "6");
          break;
        case 2: 
          com.tencent.mm.plugin.report.service.g.oSF.A(10957, "7");
        }
      }
      ap.getNotification().aw(false);
      GMTrace.o(14993999265792L, 111714);
    }
    
    public final void W(int paramInt)
    {
      GMTrace.i(14994133483520L, 111715);
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "onPageScrollStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (this.uPM != null))
      {
        this.uPM.ls(true);
        this.uPM = null;
      }
      GMTrace.o(14994133483520L, 111715);
    }
    
    public final void a(final int paramInt1, float paramFloat, int paramInt2)
    {
      GMTrace.i(14993865048064L, 111713);
      if (HomeUI.this.uOm != null) {
        HomeUI.this.uOm.i(paramInt1, paramFloat);
      }
      if (0.0F != paramFloat)
      {
        if (this.uPM == null) {
          this.uPM = ((AddressUI.a)HomeUI.this.yX(1));
        }
        this.uPM.ls(false);
        GMTrace.o(14993865048064L, 111713);
        return;
      }
      com.tencent.mm.sdk.platformtools.v.v("MicroMsg.LauncherUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(HomeUI.this.lNE) });
      if (-1 == HomeUI.this.lNE)
      {
        HomeUI.this.dR(HomeUI.this.lNE, HomeUI.this.lBf);
        HomeUI.this.yV(paramInt1);
        GMTrace.o(14993865048064L, 111713);
        return;
      }
      ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14967692591104L, 111518);
          HomeUI.this.dR(HomeUI.this.lNE, HomeUI.this.lBf);
          HomeUI.this.yV(paramInt1);
          GMTrace.o(14967692591104L, 111518);
        }
      });
      GMTrace.o(14993865048064L, 111713);
    }
    
    public final int getCount()
    {
      GMTrace.i(14993596612608L, 111711);
      GMTrace.o(14993596612608L, 111711);
      return 4;
    }
    
    public final void lG(int paramInt)
    {
      GMTrace.i(14994267701248L, 111716);
      if (paramInt == HomeUI.this.lBf)
      {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LauncherUI", "on click same index");
        q localq = HomeUI.this.yX(paramInt);
        if ((localq instanceof AbstractTabChildActivity.a)) {
          ((AbstractTabChildActivity.a)localq).bOh();
        }
        GMTrace.o(14994267701248L, 111716);
        return;
      }
      this.uPO = true;
      this.qgn += 1;
      com.tencent.mm.sdk.platformtools.v.v("MicroMsg.LauncherUI", "onTabClick count:%d", new Object[] { Integer.valueOf(this.qgn) });
      this.uPN.k(paramInt, false);
      if (paramInt == 3)
      {
        com.tencent.mm.q.c.uk().aE(262145, 266241);
        com.tencent.mm.q.c.uk().aE(262156, 266241);
        com.tencent.mm.q.c.uk().aE(262147, 266241);
        com.tencent.mm.q.c.uk().aE(262149, 266241);
      }
      GMTrace.o(14994267701248L, 111716);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/HomeUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */