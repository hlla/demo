package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.a;
import com.tencent.mm.pluginsdk.ui.chat.m;
import com.tencent.mm.pluginsdk.ui.chat.m.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter
  extends BasePanelKeybordLayout
{
  private MMActivity fBZ;
  ChatFooterPanel ntq;
  MMEditText qET;
  m sIY;
  ImageButton sIZ;
  private ImageButton sJa;
  LinearLayout sJb;
  private boolean sJc;
  private boolean sJd;
  private final int sJe;
  private final int sJf;
  a sJg;
  
  public VoiceInputFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(14460752232448L, 107741);
    this.qET = null;
    this.sJc = false;
    this.sJd = false;
    this.sJe = 1;
    this.sJf = 2;
    this.fBZ = ((MMActivity)paramContext);
    paramContext = (ViewGroup)r.eC(this.fBZ).inflate(R.i.dps, this);
    this.sJa = ((ImageButton)paramContext.findViewById(R.h.bom));
    this.sJa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(14461825974272L, 107749);
        VoiceInputFooter.c(VoiceInputFooter.this);
        GMTrace.o(14461825974272L, 107749);
      }
    });
    this.sIZ = ((ImageButton)paramContext.findViewById(R.h.bog));
    this.sIZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(16684605767680L, 124310);
        VoiceInputFooter.d(VoiceInputFooter.this);
        GMTrace.o(16684605767680L, 124310);
      }
    });
    if (e.sOF == null)
    {
      this.ntq = new d(this.fBZ);
      GMTrace.o(14460752232448L, 107741);
      return;
    }
    this.ntq = e.sOF.bR(getContext());
    this.ntq.ls(ChatFooterPanel.SCENE_SNS);
    this.ntq.setVisibility(8);
    this.sJb = ((LinearLayout)findViewById(R.h.cze));
    this.sJb.setOnClickListener(null);
    this.sJb.addView(this.ntq, -1, 0);
    this.ntq.anI();
    this.ntq.dy(false);
    this.ntq.sGS = new ChatFooterPanel.a()
    {
      public final void Zb()
      {
        GMTrace.i(16673734131712L, 124229);
        VoiceInputFooter.e(VoiceInputFooter.this).wti.sendKeyEvent(new KeyEvent(0, 67));
        VoiceInputFooter.e(VoiceInputFooter.this).wti.sendKeyEvent(new KeyEvent(1, 67));
        GMTrace.o(16673734131712L, 124229);
      }
      
      public final void aIG()
      {
        GMTrace.i(16673465696256L, 124227);
        GMTrace.o(16673465696256L, 124227);
      }
      
      public final void append(String paramAnonymousString)
      {
        GMTrace.i(16673868349440L, 124230);
        try
        {
          VoiceInputFooter.e(VoiceInputFooter.this).Uw(paramAnonymousString);
          GMTrace.o(16673868349440L, 124230);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          v.printErrStackTrace("MicroMsg.VoiceInputFooter", paramAnonymousString, "", new Object[0]);
          GMTrace.o(16673868349440L, 124230);
        }
      }
      
      public final void fx(boolean paramAnonymousBoolean)
      {
        GMTrace.i(16673599913984L, 124228);
        GMTrace.o(16673599913984L, 124228);
      }
    };
    GMTrace.o(14460752232448L, 107741);
  }
  
  private static void mJ(int paramInt)
  {
    GMTrace.i(16685142638592L, 124314);
    VoiceInputBehavior localVoiceInputBehavior = new VoiceInputBehavior();
    if (paramInt == 1) {
      localVoiceInputBehavior.smileIconClick = 1;
    }
    for (;;)
    {
      v.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[] { Integer.valueOf(localVoiceInputBehavior.cancel), Integer.valueOf(localVoiceInputBehavior.send), Integer.valueOf(localVoiceInputBehavior.click), Integer.valueOf(localVoiceInputBehavior.longClick), Long.valueOf(localVoiceInputBehavior.longClickTime), Integer.valueOf(localVoiceInputBehavior.textClick), Integer.valueOf(localVoiceInputBehavior.textChangeCount), Long.valueOf(localVoiceInputBehavior.textChangeTime), Integer.valueOf(localVoiceInputBehavior.textChangeReturn), Long.valueOf(localVoiceInputBehavior.voiceInputTime), Integer.valueOf(localVoiceInputBehavior.fail), Integer.valueOf(localVoiceInputBehavior.clear), Integer.valueOf(localVoiceInputBehavior.smileIconClick), Integer.valueOf(localVoiceInputBehavior.voiceIconClick), Integer.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(localVoiceInputBehavior.fullScreenVoiceLongClickTime) });
      log_13905 locallog_13905 = new log_13905();
      locallog_13905.viOp_ = localVoiceInputBehavior;
      g.oSF.b(13905, locallog_13905);
      GMTrace.o(16685142638592L, 124314);
      return;
      if (paramInt != 2) {
        break;
      }
      localVoiceInputBehavior.voiceIconClick = 1;
    }
    GMTrace.o(16685142638592L, 124314);
  }
  
  final void Yx()
  {
    GMTrace.i(14461020667904L, 107743);
    this.sJd = false;
    this.ntq.onPause();
    this.ntq.setVisibility(8);
    GMTrace.o(14461020667904L, 107743);
  }
  
  protected final List<View> aIF()
  {
    GMTrace.i(16685008420864L, 124313);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.ntq);
    localArrayList.add(this.sIY);
    GMTrace.o(16685008420864L, 124313);
    return localArrayList;
  }
  
  public final boolean bEo()
  {
    GMTrace.i(16684739985408L, 124311);
    if (this.sIY.getVisibility() == 0)
    {
      GMTrace.o(16684739985408L, 124311);
      return true;
    }
    GMTrace.o(16684739985408L, 124311);
    return false;
  }
  
  final void bEp()
  {
    GMTrace.i(16684874203136L, 124312);
    this.sJc = false;
    if (this.sIY != null)
    {
      this.sIY.pause();
      this.sIY.setVisibility(8);
      this.sJa.setImageResource(R.g.blc);
      int i = a.U(this.fBZ, R.f.bbj);
      this.sJa.setPadding(0, 0, i, 0);
      this.sIZ.setVisibility(0);
      if (this.sJg != null) {
        this.sJg.jl(false);
      }
    }
    GMTrace.o(16684874203136L, 124312);
  }
  
  public final boolean bla()
  {
    GMTrace.i(14460886450176L, 107742);
    if (this.ntq.getVisibility() == 0)
    {
      GMTrace.o(14460886450176L, 107742);
      return true;
    }
    GMTrace.o(14460886450176L, 107742);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void bEr();
    
    public abstract void jl(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/VoiceInputFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */