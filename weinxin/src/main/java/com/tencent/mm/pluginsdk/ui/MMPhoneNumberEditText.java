package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.bi.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public class MMPhoneNumberEditText
  extends EditText
{
  public String jvl;
  private View.OnFocusChangeListener oLU;
  public boolean sHE;
  public Drawable sHF;
  a sHG;
  public boolean sHH;
  private boolean sHI;
  int suz;
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1185410973696L, 8832);
    this.jvl = "";
    this.sHE = false;
    this.sHI = false;
    this.suz = 0;
    this.oLU = null;
    init();
    GMTrace.o(1185410973696L, 8832);
  }
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1185545191424L, 8833);
    this.jvl = "";
    this.sHE = false;
    this.sHI = false;
    this.suz = 0;
    this.oLU = null;
    init();
    GMTrace.o(1185545191424L, 8833);
  }
  
  private void MC(String paramString)
  {
    GMTrace.i(1185947844608L, 8836);
    int i = getSelectionStart();
    setText(g.bKx().d(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      GMTrace.o(1185947844608L, 8836);
      return;
    }
    setSelection(i);
    GMTrace.o(1185947844608L, 8836);
  }
  
  private void bEb()
  {
    GMTrace.i(1186216280064L, 8838);
    if (getText().toString().equals(""))
    {
      bEd();
      GMTrace.o(1186216280064L, 8838);
      return;
    }
    bEc();
    GMTrace.o(1186216280064L, 8838);
  }
  
  private void bEd()
  {
    GMTrace.i(1186484715520L, 8840);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    GMTrace.o(1186484715520L, 8840);
  }
  
  private void init()
  {
    GMTrace.i(1185679409152L, 8834);
    this.sHF = getResources().getDrawable(R.g.bgf);
    this.sHF.setBounds(0, 0, this.sHF.getIntrinsicWidth(), this.sHF.getIntrinsicHeight());
    v.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.sHF.getIntrinsicWidth()), Integer.valueOf(this.sHF.getIntrinsicHeight()) });
    bEb();
    setHeight(this.sHF.getIntrinsicHeight() + getResources().getDimensionPixelSize(R.f.aXI) * 5);
    clearFocus();
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(1153064501248L, 8591);
        paramAnonymousView = MMPhoneNumberEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          GMTrace.o(1153064501248L, 8591);
          return false;
        }
        if ((paramAnonymousMotionEvent.getAction() == 1) && (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMPhoneNumberEditText.this.sHF.getIntrinsicWidth()))
        {
          if (!paramAnonymousView.isFocused()) {
            break label99;
          }
          paramAnonymousView.setText("");
          MMPhoneNumberEditText.a(paramAnonymousView);
        }
        for (;;)
        {
          GMTrace.o(1153064501248L, 8591);
          return false;
          label99:
          if (MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) {
            MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).f(paramAnonymousView);
          }
        }
      }
    });
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        GMTrace.i(1161922871296L, 8657);
        GMTrace.o(1161922871296L, 8657);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1162057089024L, 8658);
        if (bf.mA(paramAnonymousCharSequence.toString()))
        {
          MMPhoneNumberEditText.a(MMPhoneNumberEditText.this, true);
          GMTrace.o(1162057089024L, 8658);
          return;
        }
        MMPhoneNumberEditText.a(MMPhoneNumberEditText.this, false);
        GMTrace.o(1162057089024L, 8658);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1161788653568L, 8656);
        MMPhoneNumberEditText.c(MMPhoneNumberEditText.this);
        if ((paramAnonymousCharSequence.toString().equals("")) && (!MMPhoneNumberEditText.d(MMPhoneNumberEditText.this)))
        {
          if ((MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) && (MMPhoneNumberEditText.this.isFocused()))
          {
            MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).g(MMPhoneNumberEditText.this);
            GMTrace.o(1161788653568L, 8656);
          }
        }
        else if ((!paramAnonymousCharSequence.toString().equals("")) && (MMPhoneNumberEditText.d(MMPhoneNumberEditText.this)))
        {
          if ((MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) && (MMPhoneNumberEditText.this.isFocused()))
          {
            MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).bEe();
            GMTrace.o(1161788653568L, 8656);
          }
        }
        else if ((MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) && (MMPhoneNumberEditText.this.isFocused())) {
          MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).bEf();
        }
        GMTrace.o(1161788653568L, 8656);
      }
    });
    super.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        GMTrace.i(1165144096768L, 8681);
        if (MMPhoneNumberEditText.e(MMPhoneNumberEditText.this) != null) {
          MMPhoneNumberEditText.e(MMPhoneNumberEditText.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        MMPhoneNumberEditText.c(MMPhoneNumberEditText.this);
        GMTrace.o(1165144096768L, 8681);
      }
    });
    GMTrace.o(1185679409152L, 8834);
  }
  
  final void bEc()
  {
    GMTrace.i(1186350497792L, 8839);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.sHF, getCompoundDrawables()[3]);
    GMTrace.o(1186350497792L, 8839);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    GMTrace.i(1186618933248L, 8841);
    if (!(paramParcelable instanceof TextView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      GMTrace.o(1186618933248L, 8841);
      return;
    }
    if (!this.sHE) {
      paramParcelable = View.BaseSavedState.EMPTY_STATE;
    }
    super.onRestoreInstanceState(paramParcelable);
    GMTrace.o(1186618933248L, 8841);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    GMTrace.i(1185813626880L, 8835);
    boolean bool = super.onTextContextMenuItem(paramInt);
    String str;
    if (paramInt == 16908322)
    {
      this.suz = 0;
      str = getText().toString();
    }
    try
    {
      MC(str);
      GMTrace.o(1185813626880L, 8835);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        v.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.suz) });
        if (this.suz < 3)
        {
          this.suz += 1;
          MC(" " + str);
        }
        else
        {
          v.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
        }
      }
    }
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    GMTrace.i(1186082062336L, 8837);
    this.oLU = paramOnFocusChangeListener;
    GMTrace.o(1186082062336L, 8837);
  }
  
  public static abstract interface a
  {
    public abstract void bEe();
    
    public abstract void bEf();
    
    public abstract void f(MMPhoneNumberEditText paramMMPhoneNumberEditText);
    
    public abstract void g(MMPhoneNumberEditText paramMMPhoneNumberEditText);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/MMPhoneNumberEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */