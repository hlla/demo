package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.h.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.TestTimeForChatting;

public class BaseConversationUI
  extends MMFragmentActivity
{
  private ActionBar Gx;
  b kUz;
  String title;
  private String uOK;
  private int uON;
  private View uOV;
  private View uOW;
  private En_5b8fbb1e.a uOX;
  private TestTimeForChatting uOY;
  private OnLayoutChangedLinearLayout uOZ;
  private long uOy;
  private OnLayoutChangedLinearLayout.a uPa;
  String uPb;
  Bundle uPc;
  Runnable uPd;
  private Animation uPf;
  private boolean uPg;
  private Animation uPh;
  public boolean uPi;
  private boolean vJc;
  private long vJe;
  public b vZo;
  private a vZp;
  private c vZq;
  
  public BaseConversationUI()
  {
    GMTrace.i(3430873563136L, 25562);
    this.uOy = 0L;
    this.vZp = a.vZw;
    this.uPg = false;
    this.uPi = true;
    this.uON = -1;
    this.uPa = new OnLayoutChangedLinearLayout.a()
    {
      public final void bPx()
      {
        GMTrace.i(14678587604992L, 109364);
        if (BaseConversationUI.g(BaseConversationUI.this) == null)
        {
          BaseConversationUI.a(BaseConversationUI.this, AnimationUtils.loadAnimation(BaseConversationUI.this, MMFragmentActivity.a.uTa));
          BaseConversationUI.g(BaseConversationUI.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              GMTrace.i(14683687878656L, 109402);
              v.i("MicroMsg.BaseConversationUI", "klem animationEnd");
              BaseConversationUI.i(BaseConversationUI.this);
              BaseConversationUI.this.O(1.0F);
              GMTrace.o(14683687878656L, 109402);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation)
            {
              GMTrace.i(14683553660928L, 109401);
              GMTrace.o(14683553660928L, 109401);
            }
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              GMTrace.i(14683419443200L, 109400);
              v.i("MicroMsg.BaseConversationUI", "klem onAnimationStart");
              BaseConversationUI.h(BaseConversationUI.this);
              BaseConversationUI.a(BaseConversationUI.this, false);
              GMTrace.o(14683419443200L, 109400);
            }
          });
        }
        if (BaseConversationUI.j(BaseConversationUI.this))
        {
          BaseConversationUI.a(BaseConversationUI.this).mView.startAnimation(BaseConversationUI.g(BaseConversationUI.this));
          BaseConversationUI.k(BaseConversationUI.this);
        }
        for (;;)
        {
          BaseConversationUI.l(BaseConversationUI.this).vnK = null;
          v.i("MicroMsg.BaseConversationUI", "klem CHATTING ONLAYOUT ");
          GMTrace.o(14678587604992L, 109364);
          return;
          BaseConversationUI.h(BaseConversationUI.this);
          BaseConversationUI.i(BaseConversationUI.this);
        }
      }
    };
    this.uPd = new Runnable()
    {
      public final void run()
      {
        GMTrace.i(14678184951808L, 109361);
        BaseConversationUI.this.uPi = false;
        if (BaseConversationUI.this.isFinishing())
        {
          GMTrace.o(14678184951808L, 109361);
          return;
        }
        if (BaseConversationUI.b(BaseConversationUI.this) == null) {}
        for (boolean bool = false;; bool = BaseConversationUI.b(BaseConversationUI.this).isShown())
        {
          v.i("MicroMsg.BaseConversationUI", "ashutest::startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
          Object localObject = new Intent().putExtra("Chat_User", BaseConversationUI.this.uPb);
          if (BaseConversationUI.this.uPc != null) {
            ((Intent)localObject).putExtras(BaseConversationUI.this.uPc);
          }
          ((Intent)localObject).putExtra("img_gallery_enter_from_chatting_ui", true);
          BaseConversationUI.a(BaseConversationUI.this, (Intent)localObject);
          BaseConversationUI.l(BaseConversationUI.this).vnK = BaseConversationUI.m(BaseConversationUI.this);
          BaseConversationUI.b(BaseConversationUI.this).setVisibility(0);
          localObject = BaseConversationUI.this;
          if ((((BaseConversationUI)localObject).vZo != null) && (!((BaseConversationUI)localObject).vZo.bPY())) {
            ((BaseConversationUI)localObject).vZo.kp(false);
          }
          if (BaseConversationUI.a(BaseConversationUI.this).bPY()) {
            com.tencent.mm.ui.widget.j.a(BaseConversationUI.this);
          }
          com.tencent.mm.sdk.f.e.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(14687043321856L, 109427);
              com.tencent.mm.modelstat.d.a(4, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
              com.tencent.mm.modelstat.d.a(3, "En_5b8fbb1e" + BaseConversationUI.a(BaseConversationUI.this).bVa(), BaseConversationUI.a(BaseConversationUI.this).hashCode());
              GMTrace.o(14687043321856L, 109427);
            }
          }, "directReport_startChattingRunnable");
          BaseConversationUI.a(BaseConversationUI.this, bf.Nz());
          GMTrace.o(14678184951808L, 109361);
          return;
        }
      }
      
      public final String toString()
      {
        GMTrace.i(14678319169536L, 109362);
        String str = super.toString() + "|startChattingRunnable";
        GMTrace.o(14678319169536L, 109362);
        return str;
      }
    };
    this.vZq = new c();
    this.vJc = false;
    this.vJe = 0L;
    GMTrace.o(3430873563136L, 25562);
  }
  
  private void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, int paramInt, Rect paramRect, ViewGroup paramViewGroup)
  {
    GMTrace.i(14995341443072L, 111724);
    int j = getWindow().getDecorView().getBottom();
    int k = cO().cP().getCustomView().getBottom();
    if ((this.vZo != null) && (this.vZo.mView != null)) {}
    for (int i = j - (paramInt + k + this.vZo.mView.getBottom());; i = 0)
    {
      v.i("MicroMsg.BaseConversationUI", "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i) });
      paramFitSystemWindowLayoutView.uPJ = paramViewGroup;
      paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
      GMTrace.o(14995341443072L, 111724);
      return;
    }
  }
  
  private void bPq()
  {
    GMTrace.i(3432752611328L, 25576);
    if ((this.uOX != null) && (this.uOX.hMt))
    {
      GMTrace.o(3432752611328L, 25576);
      return;
    }
    View localView = r.eC(this).inflate(R.i.cTs, null);
    this.kUz = new b(localView);
    this.Gx.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.Gx.cK();
    this.Gx.setDisplayHomeAsUpEnabled(false);
    this.Gx.cJ();
    this.Gx.cL();
    this.Gx.setCustomView(localView);
    ajd();
    this.kUz.h(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(14684090531840L, 109405);
        BaseConversationUI.this.finish();
        GMTrace.o(14684090531840L, 109405);
      }
    });
    GMTrace.o(3432752611328L, 25576);
  }
  
  private void bPu()
  {
    boolean bool = true;
    GMTrace.i(3431947304960L, 25570);
    if ((!com.tencent.mm.compatible.util.d.eo(19)) || (!a.rX()))
    {
      GMTrace.o(3431947304960L, 25570);
      return;
    }
    if (this.uOX == null) {}
    for (;;)
    {
      v.i("MicroMsg.BaseConversationUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.uOX != null) {
        this.uOX.uSO.wrX = false;
      }
      GMTrace.o(3431947304960L, 25570);
      return;
      bool = false;
    }
  }
  
  private ViewGroup bYj()
  {
    GMTrace.i(3432349958144L, 25573);
    Object localObject1 = this.Gx.getCustomView().getParent();
    Object localObject2 = null;
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    while ((localObject1 != localViewGroup) && (localObject1 != null))
    {
      ViewParent localViewParent = ((ViewParent)localObject1).getParent();
      localObject2 = localObject1;
      localObject1 = localViewParent;
    }
    localObject1 = (ViewGroup)localObject2;
    GMTrace.o(3432349958144L, 25573);
    return (ViewGroup)localObject1;
  }
  
  public final void O(float paramFloat)
  {
    GMTrace.i(3431678869504L, 25568);
    v.v("MicroMsg.BaseConversationUI", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(240L), this.vZp });
    if ((!com.tencent.mm.compatible.util.d.eo(19)) || (!a.rX()))
    {
      GMTrace.o(3431678869504L, 25568);
      return;
    }
    if (a.vZx != this.vZp)
    {
      super.O(paramFloat);
      if (Float.compare(1.0F, paramFloat) > 0)
      {
        GMTrace.o(3431678869504L, 25568);
        return;
      }
    }
    View localView = findViewById(R.h.caJ);
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      com.tencent.mm.ui.tools.j.n(localView, 0.0F);
      GMTrace.o(3431678869504L, 25568);
      return;
    }
    com.tencent.mm.ui.tools.j.n(localView, localView.getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
    GMTrace.o(3431678869504L, 25568);
  }
  
  public final void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    GMTrace.i(3432081522688L, 25571);
    if (this.uOY == null) {}
    for (boolean bool = false;; bool = this.uOY.isShown())
    {
      v.i("MicroMsg.BaseConversationUI", "try startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      this.uPc = paramBundle;
      this.uPb = paramString;
      this.uPg = paramBoolean;
      ap.vL().bIX();
      ae.yq(-8);
      ae.v(this.uPd);
      GMTrace.o(3432081522688L, 25571);
      return;
    }
  }
  
  public final void ajd()
  {
    GMTrace.i(3432886829056L, 25577);
    if (this.kUz != null) {
      this.kUz.setTitle(n.eK(this.title));
    }
    GMTrace.o(3432886829056L, 25577);
  }
  
  protected En_5b8fbb1e.a bYg()
  {
    GMTrace.i(3433692135424L, 25583);
    En_5b8fbb1e.a locala = En_5b8fbb1e.a.bUG();
    GMTrace.o(3433692135424L, 25583);
    return locala;
  }
  
  public final void bYk()
  {
    GMTrace.i(3432484175872L, 25574);
    if (this.vZo != null)
    {
      this.vZo.onResume();
      if (!this.vZo.bPY()) {
        this.vZo.kp(true);
      }
    }
    GMTrace.o(3432484175872L, 25574);
  }
  
  public final void d(boolean paramBoolean, int paramInt)
  {
    long l = 120L;
    GMTrace.i(3433423699968L, 25581);
    v.v("MicroMsg.BaseConversationUI", "ashutest: on settle %B, speed %d, status %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.vZp });
    if ((!com.tencent.mm.compatible.util.d.eo(19)) || (!a.rX()))
    {
      GMTrace.o(3433423699968L, 25581);
      return;
    }
    if (a.vZx != this.vZp)
    {
      super.d(paramBoolean, paramInt);
      GMTrace.o(3433423699968L, 25581);
      return;
    }
    View localView = findViewById(R.h.caJ);
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        com.tencent.mm.ui.tools.j.a(localView, l, 0.0F, 0.125F);
        GMTrace.o(3433423699968L, 25581);
        return;
        l = 240L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      com.tencent.mm.ui.tools.j.a(localView, l, localView.getWidth() * -1 / 4, 0.75F);
      GMTrace.o(3433423699968L, 25581);
      return;
      l = 240L;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    GMTrace.i(3433557917696L, 25582);
    v.i("MicroMsg.BaseConversationUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      ae.I(this.uPd);
    }
    boolean bool;
    if ((this.uOX != null) && (this.uOX.hMt) && (!this.uOX.vJd))
    {
      if (this.uOX.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))
      {
        GMTrace.o(3433557917696L, 25582);
        return true;
      }
      try
      {
        bool = super.dispatchKeyEvent(paramKeyEvent);
        GMTrace.o(3433557917696L, 25582);
        return bool;
      }
      catch (Exception paramKeyEvent)
      {
        v.w("MicroMsg.BaseConversationUI", "dispatch key event catch exception %s", new Object[] { paramKeyEvent.getMessage() });
        v.printErrStackTrace("MicroMsg.BaseConversationUI", paramKeyEvent, "", new Object[0]);
        GMTrace.o(3433557917696L, 25582);
        return false;
      }
    }
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (paramKeyEvent.getAction() == 0)
      {
        this.vJc = true;
        this.vJe = System.currentTimeMillis();
      }
      if (paramKeyEvent.getAction() == 1)
      {
        v.d("MicroMsg.BaseConversationUI", "hasBack %B, %d", new Object[] { Boolean.valueOf(this.vJc), Long.valueOf(System.currentTimeMillis() - this.vJe) });
        if ((!this.vJc) || (System.currentTimeMillis() - this.vJe > 30000L))
        {
          GMTrace.o(3433557917696L, 25582);
          return true;
        }
        finish();
      }
      GMTrace.o(3433557917696L, 25582);
      return true;
    }
    try
    {
      bool = super.dispatchKeyEvent(paramKeyEvent);
      GMTrace.o(3433557917696L, 25582);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      v.w("MicroMsg.BaseConversationUI", "dispatch key event catch exception %s", new Object[] { paramKeyEvent.getMessage() });
      v.printErrStackTrace("MicroMsg.BaseConversationUI", paramKeyEvent, "", new Object[0]);
      GMTrace.o(3433557917696L, 25582);
    }
    return false;
  }
  
  public final void ki(boolean paramBoolean)
  {
    GMTrace.i(3432618393600L, 25575);
    if (this.uOY == null) {}
    for (boolean bool = false;; bool = this.uOY.isShown())
    {
      v.i("MicroMsg.BaseConversationUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.uOX != null) && (this.uOX.bPY())) {
        com.tencent.mm.ui.widget.j.b(this);
      }
      if ((this.uOY != null) && (this.uOY.getVisibility() != 8) && (this.uOX != null)) {
        break;
      }
      GMTrace.o(3432618393600L, 25575);
      return;
    }
    v.i("MicroMsg.BaseConversationUI", "closeChatting");
    this.uOY.setVisibility(8);
    this.uPi = true;
    if (this.uPf == null)
    {
      this.uPf = AnimationUtils.loadAnimation(this, MMFragmentActivity.a.uTd);
      this.uPf.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          GMTrace.i(14682748354560L, 109395);
          ap.vL().bJa();
          ae.yq(0);
          BaseConversationUI.f(BaseConversationUI.this);
          v.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationEnd");
          GMTrace.o(14682748354560L, 109395);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
          GMTrace.i(14682614136832L, 109394);
          GMTrace.o(14682614136832L, 109394);
        }
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          GMTrace.i(14682479919104L, 109393);
          ap.vL().bIX();
          ae.yq(-8);
          v.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationStart");
          BaseConversationUI.a(BaseConversationUI.this, true);
          GMTrace.o(14682479919104L, 109393);
        }
      });
    }
    this.uOX.onPause();
    this.uOX.bUR();
    this.uOX.hMt = false;
    if (paramBoolean) {
      this.uOY.startAnimation(this.uPf);
    }
    for (;;)
    {
      if (!this.uOX.bPY()) {
        bPq();
      }
      aQ();
      bYk();
      com.tencent.mm.sdk.f.e.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14686774886400L, 109425);
          com.tencent.mm.modelstat.d.a(4, "En_5b8fbb1e" + BaseConversationUI.a(BaseConversationUI.this).bVa(), BaseConversationUI.a(BaseConversationUI.this).hashCode());
          com.tencent.mm.modelstat.d.d("En_5b8fbb1e" + BaseConversationUI.a(BaseConversationUI.this).bVa(), BaseConversationUI.e(BaseConversationUI.this), u.Nz());
          com.tencent.mm.modelstat.d.a(3, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
          GMTrace.o(14686774886400L, 109425);
        }
      }, "directReport_closeChatting");
      GMTrace.o(3432618393600L, 25575);
      return;
      O(1.0F);
      bPu();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    GMTrace.i(3431813087232L, 25569);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.vZo != null) {
      this.vZo.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 != -1)
    {
      GMTrace.o(3431813087232L, 25569);
      return;
    }
    if ((paramInt1 == 2001) && (this.uOX != null)) {
      this.uOX.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    int j = 0xFFFF & paramInt1;
    v.w("MicroMsg.BaseConversationUI", "check request code %d", new Object[] { Integer.valueOf(j) });
    switch (j)
    {
    default: 
      i = 0;
    }
    if ((i != 0) && (this.uOX == null))
    {
      v.i("MicroMsg.BaseConversationUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      ae.I(this.vZq);
      this.vZq.uPK = 0;
      this.vZq.fFI = paramInt1;
      this.vZq.aMA = paramInt2;
      this.vZq.fFJ = paramIntent;
      ae.v(this.vZq);
      GMTrace.o(3431813087232L, 25569);
      return;
    }
    GMTrace.o(3431813087232L, 25569);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3431007780864L, 25563);
    getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.e.R(this);
    super.onCreate(paramBundle);
    getWindow().setCallback(new c(getWindow().getCallback(), this));
    this.Gx = cO().cP();
    bQd();
    GMTrace.o(3431007780864L, 25563);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(3431544651776L, 25567);
    super.onDestroy();
    this.uOX = null;
    this.uOZ = null;
    this.uOY = null;
    this.vZo = null;
    this.kUz = null;
    this.uPh = null;
    this.uPf = null;
    GMTrace.o(3431544651776L, 25567);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    GMTrace.i(3431141998592L, 25564);
    v.i("MicroMsg.BaseConversationUI", "onNewIntent");
    setIntent(paramIntent);
    GMTrace.o(3431141998592L, 25564);
  }
  
  protected void onPause()
  {
    GMTrace.i(3431410434048L, 25566);
    v.i("MicroMsg.BaseConversationUI", "on pause");
    super.onPause();
    if (!isFinishing()) {
      com.tencent.mm.ui.widget.j.a(this);
    }
    this.vZp = a.vZy;
    if ((this.uOY != null) && (this.uOY.isShown())) {}
    for (final boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.f.e.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14678990258176L, 109367);
          String str;
          if (bool)
          {
            str = "En_5b8fbb1e" + BaseConversationUI.a(BaseConversationUI.this).bVa();
            if (!bool) {
              break label130;
            }
          }
          label130:
          for (int i = BaseConversationUI.a(BaseConversationUI.this).hashCode();; i = BaseConversationUI.this.hashCode())
          {
            com.tencent.mm.modelstat.d.a(4, str, i);
            if (bool) {
              com.tencent.mm.modelstat.d.d("En_5b8fbb1e" + BaseConversationUI.a(BaseConversationUI.this).bVa(), BaseConversationUI.e(BaseConversationUI.this), u.Nz());
            }
            GMTrace.o(14678990258176L, 109367);
            return;
            str = BaseConversationUI.this.getLocalClassName();
            break;
          }
        }
      }, "directReport_onPause");
      if ((this.uOX != null) && (this.uOX.bPY())) {
        this.uOX.uSO.mEnable = false;
      }
      GMTrace.o(3431410434048L, 25566);
      return;
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    GMTrace.i(3433155264512L, 25579);
    super.onRestoreInstanceState(paramBundle);
    this.uOK = paramBundle.getString("last_restore_talker");
    v.d("MicroMsg.BaseConversationUI", "onRestoreInstantceState:%s", new Object[] { this.uOK });
    GMTrace.o(3433155264512L, 25579);
  }
  
  protected void onResume()
  {
    GMTrace.i(3431276216320L, 25565);
    super.onResume();
    com.tencent.mm.ui.widget.j.b(this);
    O(1.0F);
    this.vZp = a.vZx;
    if ((this.uOY != null) && (this.uOY.isShown())) {}
    for (final boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.f.e.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14682211483648L, 109391);
          String str;
          if (bool)
          {
            str = "En_5b8fbb1e" + BaseConversationUI.a(BaseConversationUI.this).bVa();
            if (!bool) {
              break label85;
            }
          }
          label85:
          for (int i = BaseConversationUI.a(BaseConversationUI.this).hashCode();; i = BaseConversationUI.this.hashCode())
          {
            com.tencent.mm.modelstat.d.a(3, str, i);
            GMTrace.o(14682211483648L, 109391);
            return;
            str = BaseConversationUI.this.getLocalClassName();
            break;
          }
        }
      }, "directReport_onResume");
      if (!bool) {
        this.uOy = bf.Nz();
      }
      if ((com.tencent.mm.compatible.util.d.eo(19)) && (a.rX()))
      {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            GMTrace.i(3421344104448L, 25491);
            long l = System.currentTimeMillis();
            if (BaseConversationUI.b(BaseConversationUI.this) == null)
            {
              if (BaseConversationUI.c(BaseConversationUI.this) == null) {
                BaseConversationUI.a(BaseConversationUI.this, r.eC(BaseConversationUI.this).inflate(R.i.cXf, null));
              }
              if (BaseConversationUI.d(BaseConversationUI.this) == null) {
                BaseConversationUI.b(BaseConversationUI.this, r.eC(BaseConversationUI.this).inflate(R.i.cTs, null));
              }
            }
            v.d("MicroMsg.BaseConversationUI", "prepare chattingUI view use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            GMTrace.o(3421344104448L, 25491);
            return false;
          }
        });
        if ((this.uOX != null) && (this.uOX.bPY())) {
          this.uOX.uSO.mEnable = true;
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            GMTrace.i(14679527129088L, 109371);
            long l = System.currentTimeMillis();
            if (BaseConversationUI.b(BaseConversationUI.this) == null) {
              if ((BaseConversationUI.this.vZo == null) || (bf.mA(BaseConversationUI.this.vZo.getUserName()))) {
                break label213;
              }
            }
            label213:
            for (Object localObject = BaseConversationUI.this.vZo.getUserName();; localObject = com.tencent.mm.u.m.xL())
            {
              localObject = new Intent().putExtra("Chat_User", (String)localObject);
              BaseConversationUI.a(BaseConversationUI.this, (Intent)localObject);
              BaseConversationUI.a(BaseConversationUI.this).nfK = true;
              BaseConversationUI.a(BaseConversationUI.this).bUU();
              BaseConversationUI.b(BaseConversationUI.this).setVisibility(8);
              BaseConversationUI.a(BaseConversationUI.this).uSN = true;
              BaseConversationUI.a(BaseConversationUI.this).onPause();
              BaseConversationUI.a(BaseConversationUI.this).bUR();
              BaseConversationUI.a(BaseConversationUI.this).hMt = false;
              BaseConversationUI.this.bYk();
              BaseConversationUI.a(BaseConversationUI.this, null);
              BaseConversationUI.b(BaseConversationUI.this, null);
              v.d("MicroMsg.BaseConversationUI", "prepare chattingUI logic use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              GMTrace.o(14679527129088L, 109371);
              return false;
            }
          }
        });
      }
      bPq();
      this.Gx.show();
      GMTrace.o(3431276216320L, 25565);
      return;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    GMTrace.i(3433289482240L, 25580);
    if ((this.uOX != null) && (!bf.mA(this.uOX.bTW())))
    {
      v.d("MicroMsg.BaseConversationUI", "onSaveInstanceState:%s", new Object[] { this.uOX.bTW() });
      paramBundle.putString("last_restore_talker", this.uOX.bTW());
    }
    GMTrace.o(3433289482240L, 25580);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    GMTrace.i(3433021046784L, 25578);
    if ((this.uOX == null) || (this.uOX.vIs == null) || (!this.uOX.bPY()))
    {
      paramCallback = super.onWindowStartingActionMode(paramCallback);
      GMTrace.o(3433021046784L, 25578);
      return paramCallback;
    }
    if (com.tencent.mm.compatible.util.d.eq(22))
    {
      paramCallback = super.onWindowStartingActionMode(paramCallback);
      GMTrace.o(3433021046784L, 25578);
      return paramCallback;
    }
    ActionMode localActionMode = this.uOX.vIs.startActionMode(paramCallback);
    if (localActionMode == null)
    {
      paramCallback = super.onWindowStartingActionMode(paramCallback);
      GMTrace.o(3433021046784L, 25578);
      return paramCallback;
    }
    GMTrace.o(3433021046784L, 25578);
    return localActionMode;
  }
  
  private static enum a
  {
    static
    {
      GMTrace.i(3463488471040L, 25805);
      vZw = new a("ACTIVITY_CREATE", 0);
      vZx = new a("ACTIVITY_RESUME", 1);
      vZy = new a("ACTIVITY_PAUSE", 2);
      vZz = new a[] { vZw, vZx, vZy };
      GMTrace.o(3463488471040L, 25805);
    }
    
    private a()
    {
      GMTrace.i(3463354253312L, 25804);
      GMTrace.o(3463354253312L, 25804);
    }
  }
  
  public static class b
    extends q
  {
    public BaseConversationUI vZA;
    private BaseConversationUI.a vZB;
    
    public b()
    {
      GMTrace.i(3422552064000L, 25500);
      this.vZB = BaseConversationUI.a.vZw;
      GMTrace.o(3422552064000L, 25500);
    }
    
    public final void finish()
    {
      GMTrace.i(3423088934912L, 25504);
      bOZ().finish();
      GMTrace.o(3423088934912L, 25504);
    }
    
    public int getLayoutId()
    {
      GMTrace.i(3422686281728L, 25501);
      GMTrace.o(3422686281728L, 25501);
      return 0;
    }
    
    public String getUserName()
    {
      GMTrace.i(3423625805824L, 25508);
      GMTrace.o(3423625805824L, 25508);
      return null;
    }
    
    public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      GMTrace.i(3422820499456L, 25502);
      this.vZB = BaseConversationUI.a.vZw;
      this.vZA = ((BaseConversationUI)bOZ());
      paramLayoutInflater = paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
      aH();
      GMTrace.o(3422820499456L, 25502);
      return paramLayoutInflater;
    }
    
    public void onDestroy()
    {
      GMTrace.i(3423491588096L, 25507);
      if (this.vZB != BaseConversationUI.a.vZy)
      {
        v.w("MicroMsg.BaseConversationUI", "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
        onPause();
      }
      super.onDestroy();
      GMTrace.o(3423491588096L, 25507);
    }
    
    public void onPause()
    {
      GMTrace.i(3423357370368L, 25506);
      super.onPause();
      this.vZB = BaseConversationUI.a.vZy;
      GMTrace.o(3423357370368L, 25506);
    }
    
    public void onResume()
    {
      GMTrace.i(3423223152640L, 25505);
      super.onResume();
      this.vZB = BaseConversationUI.a.vZx;
      GMTrace.o(3423223152640L, 25505);
    }
    
    public final void qL(String paramString)
    {
      GMTrace.i(3422954717184L, 25503);
      if (this.vZA != null)
      {
        BaseConversationUI localBaseConversationUI = this.vZA;
        localBaseConversationUI.title = paramString;
        if (localBaseConversationUI.kUz != null) {
          localBaseConversationUI.ajd();
        }
      }
      GMTrace.o(3422954717184L, 25503);
    }
  }
  
  private final class c
    implements Runnable
  {
    int aMA;
    int fFI;
    Intent fFJ;
    int uPK;
    
    public c()
    {
      GMTrace.i(3408861855744L, 25398);
      this.uPK = 0;
      GMTrace.o(3408861855744L, 25398);
    }
    
    public final void run()
    {
      GMTrace.i(3408996073472L, 25399);
      if (ap.zb())
      {
        v.i("MicroMsg.BaseConversationUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.uPK) });
        BaseConversationUI.this.a(BaseConversationUI.n(BaseConversationUI.this), null, false);
        ae.v(new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            GMTrace.i(3406982807552L, 25384);
            if (BaseConversationUI.a(BaseConversationUI.this) == null) {}
            for (;;)
            {
              v.d("MicroMsg.BaseConversationUI", "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B", new Object[] { Boolean.valueOf(bool) });
              if (BaseConversationUI.a(BaseConversationUI.this) != null)
              {
                v.d("MicroMsg.BaseConversationUI", "on select image ActivityResult. do post activity result");
                BaseConversationUI.a(BaseConversationUI.this).onActivityResult(BaseConversationUI.c.this.fFI & 0xFFFF, BaseConversationUI.c.this.aMA, BaseConversationUI.c.this.fFJ);
              }
              GMTrace.o(3406982807552L, 25384);
              return;
              bool = false;
            }
          }
          
          public final String toString()
          {
            GMTrace.i(3407117025280L, 25385);
            String str = super.toString() + "|PostSelectImageJob_onActivityResult";
            GMTrace.o(3407117025280L, 25385);
            return str;
          }
        });
        GMTrace.o(3408996073472L, 25399);
        return;
      }
      if (this.uPK >= 3)
      {
        v.w("MicroMsg.BaseConversationUI", "on post select image job, match max retry count");
        GMTrace.o(3408996073472L, 25399);
        return;
      }
      v.w("MicroMsg.BaseConversationUI", "on post select image job, acc not ready, cur retry count %d", new Object[] { Integer.valueOf(this.uPK) });
      this.uPK += 1;
      ae.f(this, 300L);
      GMTrace.o(3408996073472L, 25399);
    }
    
    public final String toString()
    {
      GMTrace.i(3409130291200L, 25400);
      String str = super.toString() + "|PostSelectImageJob";
      GMTrace.o(3409130291200L, 25400);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/BaseConversationUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */