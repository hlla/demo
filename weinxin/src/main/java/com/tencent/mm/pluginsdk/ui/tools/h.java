package com.tencent.mm.pluginsdk.ui.tools;

import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ui.widget.MMEditText.b;

public final class h
{
  public static InputFilter[] sUQ;
  
  static
  {
    GMTrace.i(1108101562368L, 8256);
    sUQ = new InputFilter[] { new InputFilter.LengthFilter(50) };
    GMTrace.o(1108101562368L, 8256);
  }
  
  public static final class a
    implements TextWatcher
  {
    public MMEditText.b sUR;
    
    public a()
    {
      GMTrace.i(1110114828288L, 8271);
      this.sUR = null;
      GMTrace.o(1110114828288L, 8271);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      GMTrace.i(1110249046016L, 8272);
      GMTrace.o(1110249046016L, 8272);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(1110383263744L, 8273);
      GMTrace.o(1110383263744L, 8273);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(1110517481472L, 8274);
      if (this.sUR != null) {
        this.sUR.aXJ();
      }
      GMTrace.o(1110517481472L, 8274);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */