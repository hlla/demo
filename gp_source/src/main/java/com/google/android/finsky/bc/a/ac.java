package com.google.android.finsky.bc.a;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.finsky.be.w;
import com.google.wireless.android.finsky.dfe.e.a.de;
import com.google.wireless.android.finsky.dfe.e.a.df;
import com.google.wireless.android.finsky.dfe.e.a.ee;
import com.google.wireless.android.finsky.dfe.e.a.en;

final class ac
  implements TextWatcher
{
  ac(aa paramaa, boolean paramBoolean1, boolean paramBoolean2, TextView paramTextView, EditText paramEditText, boolean paramBoolean3) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    aa localaa;
    if (this.f)
    {
      localaa = this.a;
      localaa.b.a(localaa.a.d.h.C, paramEditable.toString().matches(this.a.a.g));
    }
    if (paramEditable.length() > 0)
    {
      localaa = this.a;
      localaa.c.a(localaa.a.e, paramEditable.toString());
      return;
    }
    paramEditable = this.a;
    paramEditable.c.a(paramEditable.a.e);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.d) && (this.c))
    {
      paramInt1 = this.a.a.d.f;
      if (paramCharSequence.length() <= paramInt1) {
        this.b.setText(String.format(this.a.a.a.e, new Object[] { Integer.valueOf(paramCharSequence.length()), Integer.valueOf(paramInt1) }));
      }
      if (paramCharSequence.length() >= paramInt1) {
        com.google.android.finsky.bw.t.a(this.e.getContext(), this.e);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */