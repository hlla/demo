package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.rl;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

@com.tencent.mm.ui.base.a(3)
public class VoiceInputUI
  extends MMActivity
{
  private String fEi;
  private Button kQZ;
  private int offset;
  private MMEditText sJG;
  private VoiceInputFooter sJH;
  private String sJI;
  private long sJJ;
  private boolean sJK;
  private boolean sJL;
  private View.OnTouchListener sJM;
  private MenuItem.OnMenuItemClickListener sJN;
  private VoiceInputFooter.a sJO;
  private int textChangeCount;
  
  public VoiceInputUI()
  {
    GMTrace.i(1173465595904L, 8743);
    this.sJJ = 0L;
    this.textChangeCount = 0;
    this.sJK = true;
    this.sJL = false;
    this.sJM = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(934289604608L, 6961);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          VoiceInputUI.a(VoiceInputUI.this);
        }
        for (;;)
        {
          GMTrace.o(934289604608L, 6961);
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1)
          {
            if (VoiceInputUI.b(VoiceInputUI.this).bEo())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.bEp();
              paramAnonymousView.setVisibility(8);
            }
            if (VoiceInputUI.b(VoiceInputUI.this).bla())
            {
              paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
              paramAnonymousView.Yx();
              paramAnonymousView.setVisibility(8);
            }
            paramAnonymousView = VoiceInputUI.b(VoiceInputUI.this);
            paramAnonymousView.setVisibility(0);
            if (paramAnonymousView.sIZ != null) {
              paramAnonymousView.sIZ.setImageResource(R.g.bee);
            }
          }
        }
      }
    };
    this.sJN = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1157359468544L, 8623);
        VoiceInputUI.c(VoiceInputUI.this).setText("");
        VoiceInputUI.d(VoiceInputUI.this);
        VoiceInputUI.this.xi(6);
        GMTrace.o(1157359468544L, 8623);
        return true;
      }
    };
    this.sJO = new VoiceInputFooter.a()
    {
      public final void bEr()
      {
        GMTrace.i(16683263590400L, 124300);
        VoiceInputUI.this.xi(8);
        GMTrace.o(16683263590400L, 124300);
      }
      
      public final void jl(boolean paramAnonymousBoolean)
      {
        GMTrace.i(16683129372672L, 124299);
        if (paramAnonymousBoolean)
        {
          VoiceInputUI.e(VoiceInputUI.this).setVisibility(4);
          GMTrace.o(16683129372672L, 124299);
          return;
        }
        VoiceInputUI.e(VoiceInputUI.this).setVisibility(0);
        GMTrace.o(16683129372672L, 124299);
      }
    };
    GMTrace.o(1173465595904L, 8743);
  }
  
  private static void a(VoiceInputBehavior paramVoiceInputBehavior)
  {
    GMTrace.i(16682189848576L, 124292);
    v.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(paramVoiceInputBehavior.cancel), Integer.valueOf(paramVoiceInputBehavior.send), Integer.valueOf(paramVoiceInputBehavior.click), Integer.valueOf(paramVoiceInputBehavior.longClick), Long.valueOf(paramVoiceInputBehavior.longClickTime), Integer.valueOf(paramVoiceInputBehavior.textClick), Integer.valueOf(paramVoiceInputBehavior.textChangeCount), Long.valueOf(paramVoiceInputBehavior.textChangeTime), Integer.valueOf(paramVoiceInputBehavior.textChangeReturn), Long.valueOf(paramVoiceInputBehavior.voiceInputTime), Integer.valueOf(paramVoiceInputBehavior.fail), Integer.valueOf(paramVoiceInputBehavior.clear), Integer.valueOf(paramVoiceInputBehavior.smileIconClick), Integer.valueOf(paramVoiceInputBehavior.voiceIconClick), Integer.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(paramVoiceInputBehavior.fullScreenVoiceLongClickTime) });
    log_13905 locallog_13905 = new log_13905();
    locallog_13905.viOp_ = paramVoiceInputBehavior;
    g.oSF.b(13905, locallog_13905);
    GMTrace.o(16682189848576L, 124292);
  }
  
  private void mJ(int paramInt)
  {
    GMTrace.i(16682324066304L, 124293);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    localVoiceInputBehavior.textChangeCount = this.textChangeCount;
    localVoiceInputBehavior.textChangeReturn = paramInt;
    if (this.sJJ != 0L)
    {
      localVoiceInputBehavior.textChangeTime = bf.aB(this.sJJ);
      this.sJJ = 0L;
    }
    a(localVoiceInputBehavior);
    GMTrace.o(16682324066304L, 124293);
  }
  
  public final void VD()
  {
    GMTrace.i(1174270902272L, 8749);
    xi(3);
    super.VD();
    GMTrace.o(1174270902272L, 8749);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1174136684544L, 8748);
    int i = R.i.dpr;
    GMTrace.o(1174136684544L, 8748);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1173599813632L, 8744);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.fEi = paramBundle.getStringExtra("text");
      this.offset = paramBundle.getIntExtra("offset", -1);
      this.sJI = paramBundle.getStringExtra("punctuation");
    }
    this.sJJ = bf.NB();
    this.textChangeCount = 0;
    this.sJL = false;
    this.sJK = true;
    this.sJG = ((MMEditText)findViewById(R.h.cMH));
    this.kQZ = ((Button)findViewById(R.h.cMG));
    this.sJG.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(16684337332224L, 124308);
        v.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", new Object[] { Boolean.valueOf(VoiceInputUI.f(VoiceInputUI.this)), Boolean.valueOf(VoiceInputUI.g(VoiceInputUI.this)) });
        if (VoiceInputUI.f(VoiceInputUI.this))
        {
          VoiceInputUI.h(VoiceInputUI.this);
          GMTrace.o(16684337332224L, 124308);
          return;
        }
        VoiceInputUI.d(VoiceInputUI.this);
        VoiceInputUI.c(VoiceInputUI.this).requestLayout();
        GMTrace.o(16684337332224L, 124308);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16684068896768L, 124306);
        GMTrace.o(16684068896768L, 124306);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(16684203114496L, 124307);
        GMTrace.o(16684203114496L, 124307);
      }
    });
    this.kQZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(16673063043072L, 124224);
        paramAnonymousView = new VoiceInputBehavior();
        paramAnonymousView.send = 3;
        VoiceInputUI.b(paramAnonymousView);
        VoiceInputUI.this.xi(7);
        GMTrace.o(16673063043072L, 124224);
      }
    });
    qL(getString(R.l.faq));
    ko(true);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1223126155264L, 9113);
        VoiceInputUI.this.xi(1);
        GMTrace.o(1223126155264L, 9113);
        return true;
      }
    });
    this.sJG.setOnTouchListener(this.sJM);
    this.sJG.Uw(this.fEi);
    if (this.offset != -1) {
      this.sJG.setSelection(this.offset);
    }
    this.sJH = ((VoiceInputFooter)findViewById(R.h.czv));
    paramBundle = this.sJH;
    Object localObject = this.sJG;
    String str = this.sJI;
    paramBundle.qET = ((MMEditText)localObject);
    ((MMEditText)localObject).setOnClickListener(new VoiceInputFooter.1(paramBundle));
    ((MMEditText)localObject).setOnEditorActionListener(new VoiceInputFooter.2(paramBundle));
    if (paramBundle.sIY == null)
    {
      paramBundle.sIY = new m(paramBundle.getContext(), true, paramBundle.qET);
      paramBundle.sIY.sPj = new VoiceInputFooter.6(paramBundle);
      paramBundle.sIY.xE(j.aD(paramBundle.getContext()));
    }
    paramBundle.sIY.bFW();
    paramBundle.sIY.bFc();
    paramBundle.sIY.setVisibility(8);
    localObject = paramBundle.sIY;
    if (str != null) {
      ((m)localObject).sPF = str;
    }
    ((m)localObject).bFY();
    paramBundle.sJb.addView(paramBundle.sIY, -1, 0);
    this.sJH.sJg = this.sJO;
    GMTrace.o(1173599813632L, 8744);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(1174002466816L, 8747);
    super.onDestroy();
    if (this.sJH != null)
    {
      VoiceInputFooter localVoiceInputFooter = this.sJH;
      if (localVoiceInputFooter.ntq != null)
      {
        localVoiceInputFooter.ntq.anH();
        localVoiceInputFooter.ntq.destroy();
      }
      if (localVoiceInputFooter.sIY != null) {
        localVoiceInputFooter.sIY.destory();
      }
    }
    GMTrace.o(1174002466816L, 8747);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(1174405120000L, 8750);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      xi(2);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(1174405120000L, 8750);
    return bool;
  }
  
  protected void onPause()
  {
    GMTrace.i(1173868249088L, 8746);
    super.onPause();
    GMTrace.o(1173868249088L, 8746);
  }
  
  protected void onResume()
  {
    GMTrace.i(1173734031360L, 8745);
    super.onResume();
    this.sJG.requestFocus();
    GMTrace.o(1173734031360L, 8745);
  }
  
  public final void xi(int paramInt)
  {
    GMTrace.i(1174539337728L, 8751);
    v.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", new Object[] { Integer.valueOf(paramInt), bf.bJP().toString() });
    rl localrl;
    if (paramInt == 8)
    {
      mJ(7);
      localrl = new rl();
      if (paramInt != 7) {
        break label141;
      }
      localrl.fYl.action = 1;
      label71:
      if (!this.sJL) {
        break label169;
      }
    }
    label141:
    label169:
    for (localrl.fYl.fYm = 1;; localrl.fYl.fYm = 2)
    {
      localrl.fYl.result = this.sJG.getText().toString();
      com.tencent.mm.sdk.b.a.uql.m(localrl);
      bf.cV(this.sJG);
      super.finish();
      GMTrace.o(1174539337728L, 8751);
      return;
      mJ(paramInt);
      break;
      if (paramInt == 8)
      {
        localrl.fYl.action = 4;
        break label71;
      }
      localrl.fYl.action = 2;
      break label71;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/VoiceInputUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */