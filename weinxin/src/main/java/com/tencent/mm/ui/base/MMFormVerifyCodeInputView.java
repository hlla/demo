package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.k;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private ai hQB;
  private TextView ipc;
  private int layout;
  private Context mContext;
  public EditText oAr;
  private TextView vhH;
  private Button vhI;
  private int vhJ;
  private int vhK;
  private int vhL;
  public View.OnClickListener vhM;
  private int vhv;
  private int vhw;
  private int[] vhx;
  private View.OnFocusChangeListener vhy;
  
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
    GMTrace.i(17515010850816L, 130497);
    GMTrace.o(17515010850816L, 130497);
  }
  
  @TargetApi(11)
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(17514876633088L, 130496);
    this.mContext = null;
    this.vhv = -1;
    this.vhw = -1;
    this.vhJ = -1;
    this.layout = -1;
    this.vhK = 60;
    this.vhL = this.vhK;
    this.vhy = null;
    this.vhM = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.fpZ, paramInt, 0);
    this.vhw = paramAttributeSet.getResourceId(a.m.hfx, -1);
    this.vhv = paramAttributeSet.getResourceId(a.m.hfz, -1);
    this.vhJ = paramAttributeSet.getResourceId(a.m.hfw, -1);
    this.layout = paramAttributeSet.getResourceId(a.m.hfy, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    GMTrace.o(17514876633088L, 130496);
  }
  
  public final void bRI()
  {
    GMTrace.i(17515279286272L, 130499);
    this.vhI.setVisibility(8);
    this.vhH.setVisibility(0);
    this.vhH.setText(getContext().getString(a.k.hfc, new Object[] { Integer.valueOf(this.vhK) }));
    if (this.hQB != null)
    {
      this.hQB.KI();
      this.hQB.v(1000L, 1000L);
      GMTrace.o(17515279286272L, 130499);
      return;
    }
    if (getContext() != null)
    {
      this.hQB = new ai(getContext().getMainLooper(), new ai.a()
      {
        public final boolean oQ()
        {
          GMTrace.i(17514205544448L, 130491);
          MMFormVerifyCodeInputView.f(MMFormVerifyCodeInputView.this);
          MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this).setText(MMFormVerifyCodeInputView.this.getContext().getString(a.k.hfc, new Object[] { Integer.valueOf(MMFormVerifyCodeInputView.g(MMFormVerifyCodeInputView.this)) }));
          if (MMFormVerifyCodeInputView.g(MMFormVerifyCodeInputView.this) == 0)
          {
            MMFormVerifyCodeInputView.i(MMFormVerifyCodeInputView.this).KI();
            MMFormVerifyCodeInputView.a(MMFormVerifyCodeInputView.this, MMFormVerifyCodeInputView.j(MMFormVerifyCodeInputView.this));
            MMFormVerifyCodeInputView.k(MMFormVerifyCodeInputView.this).setVisibility(0);
            MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this).setVisibility(8);
          }
          GMTrace.o(17514205544448L, 130491);
          return true;
        }
      }, true);
      this.hQB.v(1000L, 1000L);
      GMTrace.o(17515279286272L, 130499);
      return;
    }
    this.hQB.KI();
    GMTrace.o(17515279286272L, 130499);
  }
  
  public final void bRJ()
  {
    GMTrace.i(17515547721728L, 130501);
    if (this.oAr != null)
    {
      this.oAr.setInputType(3);
      GMTrace.o(17515547721728L, 130501);
      return;
    }
    v.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    GMTrace.o(17515547721728L, 130501);
  }
  
  public final Editable getText()
  {
    GMTrace.i(17515681939456L, 130502);
    if (this.oAr != null)
    {
      Editable localEditable = this.oAr.getText();
      GMTrace.o(17515681939456L, 130502);
      return localEditable;
    }
    v.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    GMTrace.o(17515681939456L, 130502);
    return null;
  }
  
  public void onFinishInflate()
  {
    GMTrace.i(17515145068544L, 130498);
    this.ipc = ((TextView)findViewById(a.g.title));
    this.oAr = ((EditText)findViewById(a.g.bKI));
    this.vhH = ((TextView)findViewById(a.g.hdf));
    this.vhI = ((Button)findViewById(a.g.hcQ));
    if ((this.ipc == null) || (this.oAr == null) || (this.vhH == null) || (this.vhI == null)) {
      v.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.ipc, this.oAr, this.vhH, this.vhI });
    }
    for (;;)
    {
      if (this.oAr != null)
      {
        View.OnFocusChangeListener local1 = new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            GMTrace.i(17513131802624L, 130483);
            if (paramAnonymousView == MMFormVerifyCodeInputView.a(MMFormVerifyCodeInputView.this))
            {
              MMFormVerifyCodeInputView.b(MMFormVerifyCodeInputView.this);
              if (!paramAnonymousBoolean) {
                break label80;
              }
              MMFormVerifyCodeInputView.this.setBackgroundResource(a.f.bfU);
            }
            for (;;)
            {
              MMFormVerifyCodeInputView.c(MMFormVerifyCodeInputView.this);
              if (MMFormVerifyCodeInputView.d(MMFormVerifyCodeInputView.this) != null) {
                MMFormVerifyCodeInputView.d(MMFormVerifyCodeInputView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
              }
              GMTrace.o(17513131802624L, 130483);
              return;
              label80:
              MMFormVerifyCodeInputView.this.setBackgroundResource(a.f.bfV);
            }
          }
        };
        this.oAr.setOnFocusChangeListener(local1);
      }
      if (this.vhI != null) {
        this.vhI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(17513400238080L, 130485);
            if (MMFormVerifyCodeInputView.e(MMFormVerifyCodeInputView.this) != null) {
              MMFormVerifyCodeInputView.e(MMFormVerifyCodeInputView.this).onClick(paramAnonymousView);
            }
            GMTrace.o(17513400238080L, 130485);
          }
        });
      }
      GMTrace.o(17515145068544L, 130498);
      return;
      if (this.vhv != -1) {
        this.ipc.setText(this.vhv);
      }
      if (this.vhw != -1) {
        this.oAr.setHint(this.vhw);
      }
      if (this.vhJ != -1) {
        this.vhI.setText(this.vhJ);
      }
    }
  }
  
  public final void reset()
  {
    GMTrace.i(17515413504000L, 130500);
    if (this.hQB != null) {
      this.hQB.KI();
    }
    this.oAr.setText("");
    this.vhH.setVisibility(8);
    this.vhL = this.vhK;
    this.vhI.setVisibility(0);
    GMTrace.o(17515413504000L, 130500);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MMFormVerifyCodeInputView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */