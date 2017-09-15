package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.d;
import android.text.ClipboardManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.jo;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.protocal.c.ast;
import com.tencent.mm.protocal.c.bib;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;

public class VoiceTransTextUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.y.e
{
  private final String TAG;
  private long gLu;
  private int iE;
  private int jcv;
  private int jcw;
  private View kGa;
  private ScrollView lhj;
  private Button lwR;
  private ad mHandler;
  private long oHl;
  private volatile boolean qQA;
  private boolean qQB;
  private ai qQC;
  private com.tencent.mm.storage.bf qQs;
  private a qQv;
  private c qQw;
  private b qQx;
  private com.tencent.mm.modelvoice.b qQy;
  private int qUA;
  private View.OnTouchListener qUB;
  private View.OnClickListener qUC;
  private ClipboardManager qUD;
  private View.OnLongClickListener qUE;
  private View qUp;
  private View qUq;
  private LinearLayout qUr;
  private TextView qUs;
  private int qUt;
  private boolean qUu;
  private p qUv;
  private au qUw;
  private com.tencent.mm.sdk.b.c qUx;
  private boolean qUy;
  private boolean qUz;
  
  public VoiceTransTextUI()
  {
    GMTrace.i(5763846111232L, 42944);
    this.TAG = "MicroMsg.VoiceTransTextUI";
    this.kGa = null;
    this.qUp = null;
    this.qUq = null;
    this.qUr = null;
    this.qUs = null;
    this.lwR = null;
    this.lhj = null;
    this.qQA = false;
    this.qUt = 6;
    this.qQB = false;
    this.qUu = false;
    this.qUy = false;
    this.qUz = false;
    this.oHl = 0L;
    this.qUC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(5772972916736L, 43012);
        VoiceTransTextUI.this.finish();
        GMTrace.o(5772972916736L, 43012);
      }
    };
    this.qUE = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        GMTrace.i(5763443458048L, 42941);
        v.d("MicroMsg.VoiceTransTextUI", "onLongClick");
        paramAnonymousView = VoiceTransTextUI.this;
        String str = VoiceTransTextUI.this.getString(R.l.dGp);
        g.c local1 = new g.c()
        {
          public final void hp(int paramAnonymous2Int)
          {
            GMTrace.i(5771093868544L, 42998);
            if ((paramAnonymous2Int == 0) && (VoiceTransTextUI.a(VoiceTransTextUI.this) != null) && (VoiceTransTextUI.b(VoiceTransTextUI.this) != null)) {
              VoiceTransTextUI.a(VoiceTransTextUI.this).setText(VoiceTransTextUI.b(VoiceTransTextUI.this).getText());
            }
            GMTrace.o(5771093868544L, 42998);
          }
        };
        g.a(paramAnonymousView, "", new String[] { str }, "", local1);
        GMTrace.o(5763443458048L, 42941);
        return false;
      }
    };
    this.mHandler = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(5771362304000L, 43000);
        int i = paramAnonymousMessage.what;
        if (i == 1)
        {
          VoiceTransTextUI.b(VoiceTransTextUI.this, true);
          GMTrace.o(5771362304000L, 43000);
          return;
        }
        if (i == 2) {
          VoiceTransTextUI.b(VoiceTransTextUI.this, false);
        }
        GMTrace.o(5771362304000L, 43000);
      }
    };
    GMTrace.o(5763846111232L, 42944);
  }
  
  private void Hm(String paramString)
  {
    GMTrace.i(5765590941696L, 42957);
    this.qQB = true;
    if (!com.tencent.mm.sdk.platformtools.bf.mA(paramString))
    {
      bg localbg = m.LA();
      com.tencent.mm.storage.bf localbf = new com.tencent.mm.storage.bf();
      localbf.field_msgId = this.gLu;
      localbf.RZ(bnf());
      localbf.field_content = paramString;
      localbg.a(localbf);
    }
    ar(b.qUQ, paramString);
    GMTrace.o(5765590941696L, 42957);
  }
  
  private void ar(int paramInt, String paramString)
  {
    GMTrace.i(5764517199872L, 42949);
    switch (9.qUK[(paramInt - 1)])
    {
    }
    for (;;)
    {
      if ((paramInt != b.qUQ) && (paramInt != b.qUS)) {
        break label241;
      }
      this.lhj.setOnTouchListener(this.qUB);
      this.kGa.setOnClickListener(this.qUC);
      GMTrace.o(5764517199872L, 42949);
      return;
      if (com.tencent.mm.sdk.platformtools.bf.mA(paramString))
      {
        paramInt = b.qUS;
        paramString = null;
        break;
      }
      this.qUr.setVisibility(0);
      this.qUp.setVisibility(8);
      this.lwR.setVisibility(4);
      this.qUq.setVisibility(8);
      this.qUs.setText(paramString);
      hS(true);
      continue;
      this.qUr.setVisibility(0);
      this.qUp.setVisibility(0);
      this.lwR.setVisibility(0);
      if (paramString != null)
      {
        this.qUs.setText(paramString);
        hS(false);
        continue;
        this.qUr.setVisibility(8);
        this.qUp.setVisibility(8);
        this.lwR.setHeight(0);
        this.lwR.setVisibility(8);
        this.qUq.setVisibility(0);
      }
    }
    label241:
    this.lhj.setOnTouchListener(null);
    this.kGa.setOnClickListener(null);
    GMTrace.o(5764517199872L, 42949);
  }
  
  private void bne()
  {
    GMTrace.i(5764651417600L, 42950);
    v.d("MicroMsg.VoiceTransTextUI", "cancel all net");
    if (this.qQv != null)
    {
      ap.vd().c(this.qQv);
      ap.vd().b(this.qQv.getType(), this);
    }
    if (this.qQw != null)
    {
      ap.vd().c(this.qQw);
      ap.vd().b(this.qQw.getType(), this);
    }
    if (this.qQx != null)
    {
      ap.vd().c(this.qQx);
      ap.vd().b(this.qQx.getType(), this);
    }
    GMTrace.o(5764651417600L, 42950);
  }
  
  private String bnf()
  {
    GMTrace.i(5764785635328L, 42951);
    if (this.qUv != null)
    {
      str = this.qUv.clientId;
      GMTrace.o(5764785635328L, 42951);
      return str;
    }
    String str = this.qUw.field_talker + this.qUw.field_msgId + "T" + this.qUw.field_createTime;
    GMTrace.o(5764785635328L, 42951);
    return str;
  }
  
  private int bng()
  {
    GMTrace.i(5764919853056L, 42952);
    if (this.qUv != null)
    {
      i = this.qUv.hrb;
      GMTrace.o(5764919853056L, 42952);
      return i;
    }
    int i = o.ly(this.qUw.field_imgPath);
    GMTrace.o(5764919853056L, 42952);
    return i;
  }
  
  private com.tencent.mm.modelvoice.b bnh()
  {
    GMTrace.i(5765322506240L, 42955);
    if (this.qQy == null)
    {
      if (this.qUv == null) {
        break label53;
      }
      this.qQy = q.lW(this.qUv.fyw);
    }
    for (;;)
    {
      com.tencent.mm.modelvoice.b localb = this.qQy;
      GMTrace.o(5765322506240L, 42955);
      return localb;
      label53:
      if (this.qUw != null) {
        this.qQy = q.lW(this.qUw.field_imgPath);
      } else {
        v.d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
      }
    }
  }
  
  private String getFileName()
  {
    GMTrace.i(5765188288512L, 42954);
    if (this.qUv != null)
    {
      str = this.qUv.fyw;
      GMTrace.o(5765188288512L, 42954);
      return str;
    }
    String str = this.qUw.field_imgPath;
    GMTrace.o(5765188288512L, 42954);
    return str;
  }
  
  private void hS(final boolean paramBoolean)
  {
    GMTrace.i(5765993594880L, 42960);
    if ((this.lhj == null) || (this.qUr == null))
    {
      GMTrace.o(5765993594880L, 42960);
      return;
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(5761967063040L, 42930);
        if (VoiceTransTextUI.r(VoiceTransTextUI.this).getMeasuredHeight() >= VoiceTransTextUI.s(VoiceTransTextUI.this).getMeasuredHeight())
        {
          VoiceTransTextUI.r(VoiceTransTextUI.this).fullScroll(130);
          int i = VoiceTransTextUI.r(VoiceTransTextUI.this).getScrollY();
          VoiceTransTextUI.d(VoiceTransTextUI.this, VoiceTransTextUI.r(VoiceTransTextUI.this).getPaddingTop());
          VoiceTransTextUI.d(VoiceTransTextUI.this, VoiceTransTextUI.t(VoiceTransTextUI.this) - i);
          if (!paramBoolean)
          {
            if (VoiceTransTextUI.t(VoiceTransTextUI.this) > 0)
            {
              VoiceTransTextUI.r(VoiceTransTextUI.this).setPadding(0, VoiceTransTextUI.t(VoiceTransTextUI.this), 0, 0);
              GMTrace.o(5761967063040L, 42930);
            }
          }
          else
          {
            VoiceTransTextUI.r(VoiceTransTextUI.this).setPadding(0, 0, 0, 0);
            VoiceTransTextUI.u(VoiceTransTextUI.this).setVisibility(8);
            VoiceTransTextUI.u(VoiceTransTextUI.this).setHeight(0);
          }
        }
        GMTrace.o(5761967063040L, 42930);
      }
    }, 5L);
    GMTrace.o(5765993594880L, 42960);
  }
  
  private long pI()
  {
    GMTrace.i(5765054070784L, 42953);
    if (this.qUv == null)
    {
      GMTrace.o(5765054070784L, 42953);
      return -1L;
    }
    long l = this.qUv.fTG;
    GMTrace.o(5765054070784L, 42953);
    return l;
  }
  
  private void uu(int paramInt)
  {
    GMTrace.i(5764382982144L, 42948);
    bne();
    switch (9.qUJ[(paramInt - 1)])
    {
    }
    for (;;)
    {
      GMTrace.o(5764382982144L, 42948);
      return;
      v.i("MicroMsg.VoiceTransTextUI", "net check");
      if (pI() > 0L) {
        v.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", new Object[] { Long.valueOf(pI()) });
      }
      for (this.qQv = new a(bnf(), bng(), bnh().getFormat(), pI(), getFileName());; this.qQv = new a(bnf(), bng(), getFileName()))
      {
        ap.vd().a(this.qQv, 0);
        ap.vd().a(this.qQv.getType(), this);
        if (this.qUx != null) {
          break;
        }
        if (this.qUx == null) {
          this.qUx = new com.tencent.mm.sdk.b.c() {};
        }
        com.tencent.mm.sdk.b.a.uql.b(this.qUx);
        GMTrace.o(5764382982144L, 42948);
        return;
        v.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", new Object[] { Long.valueOf(pI()) });
      }
      v.i("MicroMsg.VoiceTransTextUI", "net upload");
      if (this.qQv == null)
      {
        v.d("MicroMsg.VoiceTransTextUI", "request upload must after check!");
        GMTrace.o(5764382982144L, 42948);
        return;
      }
      if (bnh() == null)
      {
        v.d("MicroMsg.VoiceTransTextUI", "can't get FileOperator!");
        GMTrace.o(5764382982144L, 42948);
        return;
      }
      this.qQw = new c(bnf(), this.qQv.qUl, bnh().getFormat(), getFileName());
      ap.vd().a(this.qQw, 0);
      ap.vd().a(this.qQw.getType(), this);
      GMTrace.o(5764382982144L, 42948);
      return;
      v.i("MicroMsg.VoiceTransTextUI", "net upload more");
      if (this.qQw == null)
      {
        v.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
        GMTrace.o(5764382982144L, 42948);
        return;
      }
      this.qQw = new c(this.qQw);
      ap.vd().a(this.qQw, 0);
      ap.vd().a(this.qQw.getType(), this);
      GMTrace.o(5764382982144L, 42948);
      return;
      this.qUu = false;
      if (this.qQA)
      {
        v.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
        GMTrace.o(5764382982144L, 42948);
        return;
      }
      v.i("MicroMsg.VoiceTransTextUI", "net get");
      if (this.qQv == null)
      {
        v.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
        GMTrace.o(5764382982144L, 42948);
        return;
      }
      this.qQA = true;
      this.qQx = new b(bnf());
      ap.vd().a(this.qQx, 0);
      ap.vd().a(this.qQx.getType(), this);
    }
  }
  
  protected final void KD()
  {
    GMTrace.i(5764248764416L, 42947);
    zd(R.l.faQ);
    this.lwR.setOnClickListener(this);
    if ((this.qQs != null) && (!com.tencent.mm.sdk.platformtools.bf.mA(this.qQs.field_content)))
    {
      ar(b.qUQ, this.qQs.field_content);
      if ((this.lhj != null) && (this.qUr != null)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label115;
      }
      GMTrace.o(5764248764416L, 42947);
      return;
      this.mHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(5772704481280L, 43010);
          VoiceTransTextUI.r(VoiceTransTextUI.this).setPadding(0, 0, 0, 0);
          VoiceTransTextUI.s(VoiceTransTextUI.this).setGravity(17);
          GMTrace.o(5772704481280L, 43010);
        }
      }, 5L);
      break;
    }
    label115:
    ar(b.qUR, null);
    uu(a.qUL);
    GMTrace.o(5764248764416L, 42947);
  }
  
  public final void a(final int paramInt1, int paramInt2, String paramString, k paramk)
  {
    paramString = null;
    Object localObject = null;
    GMTrace.i(5765456723968L, 42956);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    switch (paramk.getType())
    {
    default: 
      GMTrace.o(5765456723968L, 42956);
      return;
    case 546: 
      if (this.qQv.mState == a.qUj)
      {
        v.i("MicroMsg.VoiceTransTextUI", "check result: done");
        paramString = (String)localObject;
        if (this.qQv.bnb()) {
          paramString = this.qQv.qUk.uhu;
        }
        Hm(paramString);
        GMTrace.o(5765456723968L, 42956);
        return;
      }
      if (this.qQv.mState == a.qUi)
      {
        if ((this.qQv.qUk != null) && (com.tencent.mm.sdk.platformtools.bf.mA(this.qQv.qUk.uhu))) {
          ar(b.qUR, this.qQv.qUk.uhu);
        }
        v.i("MicroMsg.VoiceTransTextUI", "check result: processing");
        uu(a.qUO);
        GMTrace.o(5765456723968L, 42956);
        return;
      }
      if (this.qQv.mState == a.qUh)
      {
        v.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
        uu(a.qUM);
        GMTrace.o(5765456723968L, 42956);
        return;
      }
      if (this.qQv.qUm != null)
      {
        this.qUt = this.qQv.qUm.tVz;
        GMTrace.o(5765456723968L, 42956);
        return;
      }
      break;
    case 547: 
      if (this.qQw.bnd())
      {
        v.i("MicroMsg.VoiceTransTextUI", "succeed upload");
        uu(a.qUO);
        GMTrace.o(5765456723968L, 42956);
        return;
      }
      v.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", new Object[] { Integer.valueOf(this.qQw.qUl.tfe), Integer.valueOf(this.qQw.qUl.tff) });
      uu(a.qUN);
      GMTrace.o(5765456723968L, 42956);
      return;
    case 548: 
      this.qUt = this.qQx.qUo;
      this.qQA = false;
      if ((!this.qQx.isComplete()) && (this.qQx.bnb()))
      {
        paramk = this.qQx.qUk.uhu;
        ar(b.qUR, paramk);
        v.d("MicroMsg.VoiceTransTextUI", "result valid:%s", new Object[] { this.qQx.qUk.uhu });
      }
      while (this.qQx.isComplete())
      {
        v.i("MicroMsg.VoiceTransTextUI", "succeed get");
        if (this.qQx.bnb()) {
          paramString = this.qQx.qUk.uhu;
        }
        Hm(paramString);
        GMTrace.o(5765456723968L, 42956);
        return;
        if (!this.qQx.bnb()) {
          v.d("MicroMsg.VoiceTransTextUI", "result not valid");
        }
      }
      if (this.qUu)
      {
        v.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
        uu(a.qUO);
        GMTrace.o(5765456723968L, 42956);
        return;
      }
      v.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", new Object[] { Integer.valueOf(this.qUt) });
      paramInt1 = this.qUt;
      if (!this.qQB)
      {
        if (this.qQC == null) {
          this.qQC = new ai(new ai.a()
          {
            public final boolean oQ()
            {
              GMTrace.i(5772436045824L, 43008);
              if (VoiceTransTextUI.m(VoiceTransTextUI.this))
              {
                GMTrace.o(5772436045824L, 43008);
                return false;
              }
              v.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", new Object[] { Integer.valueOf(paramInt1) });
              VoiceTransTextUI.c(VoiceTransTextUI.this, VoiceTransTextUI.a.qUO);
              GMTrace.o(5772436045824L, 43008);
              return false;
            }
          }, false);
        }
        paramString = this.qQC;
        long l = paramInt1 * 1000;
        paramString.v(l, l);
      }
      GMTrace.o(5765456723968L, 42956);
      return;
      this.qQB = true;
      ar(b.qUS, null);
    }
    GMTrace.o(5765456723968L, 42956);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(5764114546688L, 42946);
    int i = R.i.dpA;
    GMTrace.o(5764114546688L, 42946);
    return i;
  }
  
  public void onClick(View paramView)
  {
    GMTrace.i(5765859377152L, 42959);
    finish();
    GMTrace.o(5765859377152L, 42959);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(5763980328960L, 42945);
    super.onCreate(paramBundle);
    this.iE = ViewConfiguration.get(this.uRf.uRz).getScaledTouchSlop();
    this.qUD = ((ClipboardManager)getSystemService("clipboard"));
    this.kGa = findViewById(R.h.cNB);
    this.qUp = findViewById(R.h.cNw);
    this.qUq = findViewById(R.h.cNA);
    this.qUs = ((TextView)findViewById(R.h.cNy));
    this.lwR = ((Button)findViewById(R.h.cNx));
    this.qUr = ((LinearLayout)findViewById(R.h.cNz));
    this.lhj = ((ScrollView)findViewById(R.h.bSg));
    this.qUB = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(5762235498496L, 42932);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          GMTrace.o(5762235498496L, 42932);
          return false;
          VoiceTransTextUI.c(VoiceTransTextUI.this);
          VoiceTransTextUI.a(VoiceTransTextUI.this, paramAnonymousView.getScrollY());
          VoiceTransTextUI.b(VoiceTransTextUI.this, VoiceTransTextUI.d(VoiceTransTextUI.this));
          VoiceTransTextUI.e(VoiceTransTextUI.this).removeMessages(0);
          if (VoiceTransTextUI.f(VoiceTransTextUI.this))
          {
            VoiceTransTextUI.g(VoiceTransTextUI.this);
            VoiceTransTextUI.a(VoiceTransTextUI.this, true);
            continue;
            if (Math.abs(VoiceTransTextUI.h(VoiceTransTextUI.this) - paramAnonymousView.getScrollY()) > VoiceTransTextUI.i(VoiceTransTextUI.this)) {
              VoiceTransTextUI.e(VoiceTransTextUI.this).sendMessage(VoiceTransTextUI.e(VoiceTransTextUI.this).obtainMessage(0, paramAnonymousView));
            }
            if ((VoiceTransTextUI.j(VoiceTransTextUI.this) < 800L) && (Math.abs(VoiceTransTextUI.h(VoiceTransTextUI.this) - paramAnonymousView.getScrollY()) <= VoiceTransTextUI.i(VoiceTransTextUI.this)) && (!VoiceTransTextUI.k(VoiceTransTextUI.this)))
            {
              VoiceTransTextUI.e(VoiceTransTextUI.this).removeMessages(0);
              VoiceTransTextUI.l(VoiceTransTextUI.this);
              VoiceTransTextUI.this.finish();
            }
            VoiceTransTextUI.a(VoiceTransTextUI.this, false);
          }
        }
      }
    };
    this.qUs.setOnLongClickListener(this.qUE);
    this.qUs.setOnClickListener(this.qUC);
    this.gLu = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1L);
    int i;
    if (this.gLu < 0L) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        v.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
        GMTrace.o(5763980328960L, 42945);
        return;
        v.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", new Object[] { Long.valueOf(this.gLu) });
        Object localObject = m.LA();
        long l = this.gLu;
        if (l < 0L) {
          paramBundle = null;
        }
        for (;;)
        {
          this.qQs = paramBundle;
          if ((this.qQs == null) || (com.tencent.mm.sdk.platformtools.bf.mA(this.qQs.field_content))) {
            break label367;
          }
          v.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
          i = 1;
          break;
          paramBundle = new com.tencent.mm.storage.bf();
          localObject = ((bg)localObject).gUp.a("VoiceTransText", null, "msgId=?", new String[] { String.valueOf(l) }, null, null, null, 2);
          if (((Cursor)localObject).moveToFirst()) {
            paramBundle.b((Cursor)localObject);
          }
          ((Cursor)localObject).close();
        }
        label367:
        paramBundle = getIntent().getExtras().getString("voice_trans_text_img_path");
        if (com.tencent.mm.sdk.platformtools.bf.mA(paramBundle))
        {
          i = 0;
          continue;
        }
        this.qUv = m.Lz().mh(paramBundle);
        if (this.qUv != null)
        {
          v.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
          i = 1;
          continue;
        }
        ap.yY();
        this.qUw = com.tencent.mm.u.c.wT().cA(this.gLu);
        if (this.qUw != null)
        {
          v.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
          i = 1;
        }
      }
      else
      {
        paramBundle = cO().cP();
        if (paramBundle != null) {
          paramBundle.hide();
        }
        KD();
        GMTrace.o(5763980328960L, 42945);
        return;
      }
      i = 0;
    }
  }
  
  protected void onDestroy()
  {
    GMTrace.i(5765725159424L, 42958);
    bne();
    if (this.qQC != null) {
      this.qQC.KI();
    }
    if (this.qUx != null)
    {
      com.tencent.mm.sdk.b.a.uql.c(this.qUx);
      this.qUx = null;
    }
    super.onDestroy();
    GMTrace.o(5765725159424L, 42958);
  }
  
  private static enum a
  {
    static
    {
      GMTrace.i(5771899174912L, 43004);
      qUL = 1;
      qUM = 2;
      qUN = 3;
      qUO = 4;
      qUP = new int[] { qUL, qUM, qUN, qUO };
      GMTrace.o(5771899174912L, 43004);
    }
    
    public static int[] bni()
    {
      GMTrace.i(5771764957184L, 43003);
      int[] arrayOfInt = (int[])qUP.clone();
      GMTrace.o(5771764957184L, 43003);
      return arrayOfInt;
    }
  }
  
  private static enum b
  {
    static
    {
      GMTrace.i(5771630739456L, 43002);
      qUQ = 1;
      qUR = 2;
      qUS = 3;
      qUT = new int[] { qUQ, qUR, qUS };
      GMTrace.o(5771630739456L, 43002);
    }
    
    public static int[] bnj()
    {
      GMTrace.i(5771496521728L, 43001);
      int[] arrayOfInt = (int[])qUT.clone();
      GMTrace.o(5771496521728L, 43001);
      return arrayOfInt;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */