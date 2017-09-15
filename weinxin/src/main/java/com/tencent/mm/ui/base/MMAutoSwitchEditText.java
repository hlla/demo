package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.gmtrace.GMTrace;

public class MMAutoSwitchEditText
  extends EditText
{
  a vgN;
  
  public MMAutoSwitchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3169148993536L, 23612);
    this.vgN = new a(this);
    addTextChangedListener(this.vgN);
    setOnKeyListener(this.vgN);
    GMTrace.o(3169148993536L, 23612);
  }
  
  public static final class a
    implements TextWatcher, View.OnKeyListener
  {
    private String jpC;
    private EditText kM;
    int mIndex;
    MMAutoSwitchEditText.c vgO;
    MMAutoSwitchEditText.b vgP;
    MMAutoSwitchEditText.d vgQ;
    int vgR;
    
    public a(EditText paramEditText)
    {
      GMTrace.i(3332089315328L, 24826);
      this.mIndex = 0;
      this.vgR = 4;
      this.kM = paramEditText;
      GMTrace.o(3332089315328L, 24826);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int j = 0;
      GMTrace.i(3332491968512L, 24829);
      this.jpC = paramEditable.toString();
      paramEditable = "";
      if (this.vgQ != null) {
        this.vgQ.bRE();
      }
      int i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (j >= this.jpC.length()) {
          break;
        }
        i += 1;
        k = i;
        if (i > this.vgR) {
          break;
        }
        paramEditable = paramEditable + this.jpC.charAt(j);
        j += 1;
      }
      if (k > this.vgR)
      {
        this.kM.setText(paramEditable);
        this.kM.setSelection(paramEditable.length());
      }
      if ((k >= this.vgR) && (this.vgO != null)) {
        this.vgO.zX(this.mIndex);
      }
      GMTrace.o(3332491968512L, 24829);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(3332223533056L, 24827);
      GMTrace.o(3332223533056L, 24827);
    }
    
    public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      GMTrace.i(3332626186240L, 24830);
      if ((paramInt == 67) && (this.kM.getText().toString().trim().length() == 0) && (this.vgP != null)) {
        this.vgP.zW(this.mIndex);
      }
      GMTrace.o(3332626186240L, 24830);
      return false;
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(3332357750784L, 24828);
      GMTrace.o(3332357750784L, 24828);
    }
  }
  
  public static abstract interface b
  {
    public abstract void zW(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void zX(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void bRE();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MMAutoSwitchEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */