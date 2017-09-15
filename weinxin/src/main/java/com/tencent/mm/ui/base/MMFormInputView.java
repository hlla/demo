package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.v;

public class MMFormInputView
  extends LinearLayout
{
  private TextView ipc;
  private int layout;
  private Context mContext;
  public EditText oAr;
  private int vhv;
  private int vhw;
  private int[] vhx;
  public View.OnFocusChangeListener vhy;
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
    GMTrace.i(3343363604480L, 24910);
    GMTrace.o(3343363604480L, 24910);
  }
  
  @TargetApi(11)
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3343229386752L, 24909);
    this.mContext = null;
    this.vhv = -1;
    this.vhw = -1;
    this.layout = -1;
    this.vhy = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.fpZ, paramInt, 0);
    this.vhw = paramAttributeSet.getResourceId(a.m.hfx, -1);
    this.vhv = paramAttributeSet.getResourceId(a.m.hfz, -1);
    this.layout = paramAttributeSet.getResourceId(a.m.hfy, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    GMTrace.o(3343229386752L, 24909);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    GMTrace.i(3343766257664L, 24913);
    if ((paramTextWatcher != null) && (this.oAr != null))
    {
      this.oAr.addTextChangedListener(paramTextWatcher);
      GMTrace.o(3343766257664L, 24913);
      return;
    }
    v.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.oAr });
    GMTrace.o(3343766257664L, 24913);
  }
  
  public final Editable getText()
  {
    GMTrace.i(3343900475392L, 24914);
    if (this.oAr != null)
    {
      Editable localEditable = this.oAr.getText();
      GMTrace.o(3343900475392L, 24914);
      return localEditable;
    }
    v.e("MicroMsg.MMFormInputView", "contentET is null!");
    GMTrace.o(3343900475392L, 24914);
    return null;
  }
  
  public void onFinishInflate()
  {
    GMTrace.i(3343497822208L, 24911);
    this.ipc = ((TextView)findViewById(a.g.title));
    this.oAr = ((EditText)findViewById(a.g.bKI));
    if ((this.ipc == null) || (this.oAr == null)) {
      v.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.ipc, this.oAr });
    }
    for (;;)
    {
      if (this.oAr != null)
      {
        View.OnFocusChangeListener local1 = new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            GMTrace.i(3186463080448L, 23741);
            if (paramAnonymousView == MMFormInputView.a(MMFormInputView.this))
            {
              MMFormInputView.b(MMFormInputView.this);
              if (!paramAnonymousBoolean) {
                break label82;
              }
              MMFormInputView.this.setBackgroundResource(a.f.bfU);
            }
            for (;;)
            {
              MMFormInputView.c(MMFormInputView.this);
              if (MMFormInputView.d(MMFormInputView.this) != null) {
                MMFormInputView.d(MMFormInputView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
              }
              GMTrace.o(3186463080448L, 23741);
              return;
              label82:
              MMFormInputView.this.setBackgroundResource(a.f.bfV);
            }
          }
        };
        this.oAr.setOnFocusChangeListener(local1);
      }
      GMTrace.o(3343497822208L, 24911);
      return;
      if (this.vhv != -1) {
        this.ipc.setText(this.vhv);
      }
      if (this.vhw != -1) {
        this.oAr.setHint(this.vhw);
      }
    }
  }
  
  public final void setInputType(int paramInt)
  {
    GMTrace.i(3343632039936L, 24912);
    if (this.oAr != null)
    {
      this.oAr.setInputType(paramInt);
      GMTrace.o(3343632039936L, 24912);
      return;
    }
    v.e("MicroMsg.MMFormInputView", "contentET is null!");
    GMTrace.o(3343632039936L, 24912);
  }
  
  public final void setText(String paramString)
  {
    GMTrace.i(17512863367168L, 130481);
    if (this.oAr != null)
    {
      this.oAr.setText(paramString);
      GMTrace.o(17512863367168L, 130481);
      return;
    }
    v.e("MicroMsg.MMFormInputView", "contentET is null!");
    GMTrace.o(17512863367168L, 130481);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MMFormInputView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */