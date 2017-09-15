package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aw.b.b;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.e.a.rl;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.HashSet;
import java.util.Set;

public final class m
  extends LinearLayout
{
  private Context mContext;
  private TelephonyManager mKO;
  PhoneStateListener mKP;
  private Button ntp;
  private boolean sJA;
  private MMEditText sJG;
  private VoiceInputLayout.a sJv;
  private int sMI;
  private h sNs;
  private long sPA;
  private boolean sPB;
  private boolean sPC;
  private final int sPD;
  private boolean sPE;
  public String sPF;
  private Toast sPG;
  private Set<String> sPH;
  private n sPI;
  private c<rl> sPJ;
  private b sPK;
  private VoiceInputLayout.b sPL;
  private boolean sPM;
  private VoiceInputLayout sPg;
  private ImageButton sPh;
  private Button sPi;
  public a sPj;
  private MMEditText sPk;
  private VoiceInputScrollView sPl;
  private TextView sPm;
  private long sPn;
  private boolean sPo;
  private float sPp;
  private float sPq;
  private boolean sPr;
  private boolean sPs;
  private boolean sPt;
  private int sPu;
  private final String sPv;
  private boolean sPw;
  private boolean sPx;
  private long sPy;
  private long sPz;
  
  public m(Context paramContext, boolean paramBoolean, MMEditText paramMMEditText)
  {
    super(paramContext);
    GMTrace.i(16674405220352L, 124234);
    this.sPk = null;
    this.sPn = 0L;
    this.sPo = false;
    this.sPp = 0.0F;
    this.sPq = 0.0F;
    this.sPr = false;
    this.sPs = false;
    this.sJA = false;
    this.sPt = false;
    this.sPu = 300;
    this.sPv = "voiceinput_downdistance_content";
    this.sPw = false;
    this.sPx = false;
    this.sPy = 0L;
    this.sPz = 0L;
    this.sPA = 0L;
    this.sPB = false;
    this.sPC = false;
    this.sPD = 2;
    this.sPE = false;
    this.sPF = "";
    this.sPH = new HashSet();
    this.sJv = new VoiceInputLayout.a()
    {
      public final void bEx()
      {
        GMTrace.i(16680713453568L, 124281);
        m.b(m.this, R.l.fap);
        GMTrace.o(16680713453568L, 124281);
      }
    };
    this.mKP = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        GMTrace.i(16681250324480L, 124285);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        int i = -1;
        if (m.j(m.this) != null) {
          i = m.j(m.this).bEw();
        }
        v.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
        if (i != 2)
        {
          GMTrace.o(16681250324480L, 124285);
          return;
        }
        m.this.pause();
        GMTrace.o(16681250324480L, 124285);
      }
    };
    this.sPL = new VoiceInputLayout.b()
    {
      public final void T(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16680445018112L, 124279);
        v.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(System.currentTimeMillis()) });
        m.r(m.this);
        m.f(m.this).a(m.e(m.this));
        m.g(m.this);
        if ((m.n(m.this) instanceof Activity)) {
          ((Activity)m.n(m.this)).getWindow().clearFlags(128);
        }
        m.c(m.this, paramAnonymousInt1);
        if (paramAnonymousInt1 == 12) {
          m.b(m.this, R.l.fao);
        }
        for (;;)
        {
          m.i(m.this).jk(false);
          m.e(m.this).setHint(null);
          GMTrace.o(16680445018112L, 124279);
          return;
          m.b(m.this, R.l.dGM);
        }
      }
      
      public final void b(String[] paramAnonymousArrayOfString, Set<String> paramAnonymousSet)
      {
        GMTrace.i(16680310800384L, 124278);
        if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.length > 0) && (paramAnonymousArrayOfString[0].length() > 0))
        {
          if (m.s(m.this))
          {
            m.d(m.this, false);
            m.t(m.this);
          }
          m.f(m.this).a(m.e(m.this), paramAnonymousArrayOfString[0], true);
          if (m.e(m.this).getText().length() != 0)
          {
            m.e(m.this).setCursorVisible(true);
            m.e(m.this).requestFocus();
            bf.cV(m.j(m.this));
          }
          if ((!m.u(m.this)) && (paramAnonymousArrayOfString[0].length() != 0))
          {
            m.b(m.this, true);
            m.b(m.this, System.currentTimeMillis());
            v.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(m.v(m.this) - m.k(m.this)) });
          }
          m.w(m.this).addAll(paramAnonymousSet);
        }
        GMTrace.o(16680310800384L, 124278);
      }
      
      public final void bEA()
      {
        GMTrace.i(16679908147200L, 124275);
        v.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        m.r(m.this);
        m.f(m.this).a(m.e(m.this));
        m.g(m.this);
        if ((m.n(m.this) instanceof Activity)) {
          ((Activity)m.n(m.this)).getWindow().clearFlags(128);
        }
        m.xG(2);
        m.i(m.this).jk(false);
        m.e(m.this).setHint(null);
        GMTrace.o(16679908147200L, 124275);
      }
      
      public final void bEB()
      {
        GMTrace.i(16680042364928L, 124276);
        v.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        m.f(m.this).a(m.e(m.this));
        m.g(m.this);
        if ((m.n(m.this) instanceof Activity)) {
          ((Activity)m.n(m.this)).getWindow().clearFlags(128);
        }
        m.xG(3);
        m.i(m.this).jk(false);
        m.e(m.this).setHint(null);
        GMTrace.o(16680042364928L, 124276);
      }
      
      public final void bEC()
      {
        GMTrace.i(16680176582656L, 124277);
        v.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        m.r(m.this);
        m.f(m.this).a(m.e(m.this));
        m.g(m.this);
        if ((m.n(m.this) instanceof Activity)) {
          ((Activity)m.n(m.this)).getWindow().clearFlags(128);
        }
        m.c(m.this, 1);
        m.i(m.this).jk(false);
        m.e(m.this).setHint(null);
        GMTrace.o(16680176582656L, 124277);
      }
      
      public final void bEy()
      {
        GMTrace.i(16679639711744L, 124273);
        m.a(m.this, System.currentTimeMillis());
        v.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(m.k(m.this)) });
        v.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(m.k(m.this)) });
        m.b(m.this, false);
        m.c(m.this, true);
        m.d(m.this, true);
        m.b(m.this, 0L);
        m.l(m.this);
        m.g(m.this);
        m.m(m.this).setVisibility(8);
        m.c(m.this, false);
        m.f(m.this).sJp = 3;
        m.f(m.this).b(m.e(m.this));
        m.bFZ();
        if (m.e(m.this) != null)
        {
          if ((m.e(m.this).getText() != null) && (m.e(m.this).getText().length() > 0)) {
            m.e(m.this).setCursorVisible(true);
          }
          m.e(m.this).requestFocus();
          bf.cV(m.j(m.this));
        }
        if ((m.n(m.this) instanceof Activity)) {
          ((Activity)m.n(m.this)).getWindow().addFlags(128);
        }
        m.o(m.this).setVisibility(4);
        m.p(m.this).setVisibility(4);
        m.q(m.this).setVisibility(8);
        m.e(m.this).setHint(m.this.getResources().getString(R.l.fan));
        m.i(m.this).jk(true);
        GMTrace.o(16679639711744L, 124273);
      }
      
      public final void bEz()
      {
        GMTrace.i(16679773929472L, 124274);
        m.i(m.this).jk(false);
        m.e(m.this).setHint(null);
        GMTrace.o(16679773929472L, 124274);
      }
    };
    this.sMI = com.tencent.mm.bg.a.fromDPToPix(getContext(), 215);
    this.sPM = true;
    this.mContext = paramContext;
    this.sPo = paramBoolean;
    this.sPk = paramMMEditText;
    init();
    this.sPI = new n(this.mContext);
    bFW();
    GMTrace.o(16674405220352L, 124234);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    GMTrace.i(1021933780992L, 7614);
    v.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    g.oSF.b(13905, locallog_13905);
    GMTrace.o(1021933780992L, 7614);
  }
  
  private void bFX()
  {
    GMTrace.i(1021396910080L, 7610);
    v.d("MicroMsg.VoiceInputPanel", "closePanel");
    VoiceInputBehavior localVoiceInputBehavior;
    if (this.sPj != null)
    {
      this.sPB = true;
      v.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
      localVoiceInputBehavior = new VoiceInputBehavior();
      if ((this.sJG == null) || (this.sJG.getText() == null) || (this.sJG.getText().length() <= 0)) {
        break label147;
      }
      if (!this.sPB) {
        break label138;
      }
      localVoiceInputBehavior.cancel = 14;
    }
    for (;;)
    {
      if (this.sPn != 0L)
      {
        localVoiceInputBehavior.voiceInputTime = bf.aB(this.sPn);
        this.sPn = 0L;
      }
      a(localVoiceInputBehavior);
      this.sPj.bEq();
      GMTrace.o(1021396910080L, 7610);
      return;
      label138:
      localVoiceInputBehavior.cancel = 16;
      continue;
      label147:
      if (this.sPB) {
        localVoiceInputBehavior.cancel = 2;
      } else {
        localVoiceInputBehavior.cancel = 15;
      }
    }
  }
  
  @TargetApi(16)
  private void init()
  {
    GMTrace.i(1020725821440L, 7605);
    v.d("MicroMsg.VoiceInputPanel", "init");
    View.inflate(getContext(), R.i.dpq, this);
    this.sPh = ((ImageButton)findViewById(R.h.cMK));
    this.sPi = ((Button)findViewById(R.h.cMJ));
    this.ntp = ((Button)findViewById(R.h.cMN));
    this.sPm = ((TextView)findViewById(R.h.cGp));
    if (this.sPo)
    {
      this.sPh.setVisibility(4);
      this.ntp.setVisibility(4);
      this.sPi.setVisibility(8);
      if ((!this.sPo) || (this.sPk == null)) {
        break label234;
      }
      this.sJG = this.sPk;
    }
    for (;;)
    {
      this.sPl = ((VoiceInputScrollView)findViewById(R.h.cMM));
      this.sPh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16674271002624L, 124233);
          m.c(m.this);
          GMTrace.o(16674271002624L, 124233);
        }
      });
      this.ntp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16680579235840L, 124280);
          m.a(m.this, 2);
          GMTrace.o(16680579235840L, 124280);
        }
      });
      this.sPi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(16674002567168L, 124231);
          m.this.reset();
          paramAnonymousView = new VoiceInputBehavior();
          paramAnonymousView.clear = 1;
          m.c(paramAnonymousView);
          GMTrace.o(16674002567168L, 124231);
        }
      });
      this.sPl.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(16681116106752L, 124284);
          boolean bool = m.a(m.this, paramAnonymousView, paramAnonymousMotionEvent);
          GMTrace.o(16681116106752L, 124284);
          return bool;
        }
      });
      GMTrace.o(1020725821440L, 7605);
      return;
      this.sPh.setVisibility(0);
      break;
      label234:
      this.sJG = ((MMEditText)findViewById(R.h.cMO));
      this.sJG.setHintTextColor(getResources().getColor(R.e.aVl));
      this.sJG.setClickable(true);
      this.sJG.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          GMTrace.i(16674136784896L, 124232);
          if (m.a(m.this)) {
            m.b(m.this);
          }
          GMTrace.o(16674136784896L, 124232);
          return true;
        }
      });
      this.sJG.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(16679371276288L, 124271);
          boolean bool = m.a(m.this, paramAnonymousView, paramAnonymousMotionEvent);
          GMTrace.o(16679371276288L, 124271);
          return bool;
        }
      });
    }
  }
  
  private static void xF(int paramInt)
  {
    GMTrace.i(1022067998720L, 7615);
    v.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", new Object[] { Integer.valueOf(paramInt) });
    g.oSF.a(455L, paramInt, 1L, false);
    GMTrace.o(1022067998720L, 7615);
  }
  
  public final void bFW()
  {
    GMTrace.i(1020860039168L, 7606);
    this.sPn = bf.NB();
    if (this.sPJ == null)
    {
      v.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
      this.sPJ = new c() {};
      com.tencent.mm.sdk.b.a.uql.b(this.sPJ);
    }
    if (this.sPg == null)
    {
      this.sPg = ((VoiceInputLayout)findViewById(R.h.cMP));
      this.sPg.sJq = this.sPL;
      this.sPg.a(this.sJv);
      this.sPg.jm(this.sPo);
    }
    if (this.sPm != null) {
      this.sPm.setVisibility(0);
    }
    if (this.sPK == null) {
      this.sPK = new b();
    }
    SharedPreferences localSharedPreferences = aa.bIO();
    if (localSharedPreferences != null)
    {
      String str = localSharedPreferences.getString("voiceinput_downdistance_content", "");
      if (!str.equalsIgnoreCase(""))
      {
        v.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", new Object[] { Integer.valueOf(str.length()) });
        this.sPI.b(this.sJG);
        this.sPI.a(this.sJG, str, false);
        this.sPI.a(this.sJG);
        this.sPI.b(this.sJG);
        bFY();
        this.sPl.fullScroll(130);
        localSharedPreferences.edit().remove("voiceinput_downdistance_content").apply();
      }
    }
    this.mKO = ((TelephonyManager)aa.getContext().getSystemService("phone"));
    this.mKO.listen(this.mKP, 32);
    GMTrace.o(1020860039168L, 7606);
  }
  
  public final void bFY()
  {
    GMTrace.i(1021799563264L, 7613);
    v.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
    if ((this.sJG != null) && (this.sJG.getText() != null) && (this.sJG.getText().length() == 0))
    {
      this.sJG.setSelection(0);
      this.sJG.setCursorVisible(false);
      this.ntp.setVisibility(4);
      if (!this.sPo) {
        this.sPh.setVisibility(0);
      }
      this.sPi.setVisibility(8);
      this.sPm.setVisibility(0);
      if (this.sPo)
      {
        if ((this.sPk == null) || (this.sPk.getText() == null) || (this.sPk.getText().length() != 0)) {
          break label299;
        }
        this.ntp.setVisibility(4);
      }
    }
    for (;;)
    {
      this.sJG.clearFocus();
      v.i("MicroMsg.VoiceInputPanel", "resumeMusic");
      ap.yZ().qQ();
      if (!this.sPx)
      {
        this.sPx = true;
        this.sPA = System.currentTimeMillis();
        v.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(this.sPA), Long.valueOf(this.sPA - this.sPz) });
      }
      GMTrace.o(1021799563264L, 7613);
      return;
      if (this.sJG != null) {
        this.sJG.setCursorVisible(true);
      }
      this.ntp.setVisibility(0);
      if (!this.sPo)
      {
        this.sPh.setVisibility(8);
        this.sPi.setVisibility(0);
      }
      this.sPm.setVisibility(8);
      break;
      label299:
      this.ntp.setVisibility(0);
    }
  }
  
  public final void bFc()
  {
    GMTrace.i(1021665345536L, 7612);
    v.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", new Object[] { Integer.valueOf(this.sMI), Boolean.valueOf(this.sPM) });
    if (this.sPM)
    {
      this.sPM = false;
      View localView = findViewById(R.h.cML);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = this.sMI;
      Object localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new LinearLayout.LayoutParams(-1, i);
      }
      ((ViewGroup.LayoutParams)localObject).height = i;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      init();
      requestLayout();
    }
    GMTrace.o(1021665345536L, 7612);
  }
  
  public final void destory()
  {
    GMTrace.i(1021262692352L, 7609);
    v.i("MicroMsg.VoiceInputPanel", "destory");
    reset();
    if (this.sPJ != null)
    {
      com.tencent.mm.sdk.b.a.uql.c(this.sPJ);
      this.sPJ = null;
    }
    if (this.sPg != null)
    {
      this.sPg.sJq = null;
      this.sPg = null;
    }
    if (this.sPK != null) {
      this.sPK = null;
    }
    if ((this.mKO != null) && (this.mKP != null))
    {
      this.mKO.listen(this.mKP, 0);
      this.mKP = null;
    }
    this.mKO = null;
    this.sPk = null;
    GMTrace.o(1021262692352L, 7609);
  }
  
  public final void pause()
  {
    GMTrace.i(1020994256896L, 7607);
    v.i("MicroMsg.VoiceInputPanel", "pause");
    if (this.sPg != null) {
      this.sPg.bEt();
    }
    this.sPp = 0.0F;
    this.sPq = 0.0F;
    this.sPr = false;
    this.sPs = false;
    this.sJA = false;
    this.sPt = false;
    this.sPB = false;
    this.sPM = true;
    GMTrace.o(1020994256896L, 7607);
  }
  
  public final void reset()
  {
    GMTrace.i(1021128474624L, 7608);
    v.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
    pause();
    this.sPC = false;
    this.sPH.clear();
    if (this.sJG != null)
    {
      if (this.sPI != null)
      {
        this.sPI.b(this.sJG);
        this.sPI.a(this.sJG, "", false);
        this.sPI.a(this.sJG);
        this.sPI.b(this.sJG);
      }
      bFY();
    }
    GMTrace.o(1021128474624L, 7608);
  }
  
  public final void xE(int paramInt)
  {
    GMTrace.i(1021531127808L, 7611);
    v.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", new Object[] { Integer.valueOf(this.sMI), Integer.valueOf(paramInt) });
    if (this.sMI != paramInt)
    {
      this.sMI = paramInt;
      this.sPM = true;
    }
    GMTrace.o(1021531127808L, 7611);
  }
  
  public static abstract interface a
  {
    public abstract void MG(String paramString);
    
    public abstract void bEq();
    
    public abstract void jk(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/chat/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */