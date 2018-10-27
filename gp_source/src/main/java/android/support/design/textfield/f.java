package android.support.design.textfield;

import android.text.Editable;
import android.text.TextWatcher;

final class f
  implements TextWatcher
{
  f(TextInputLayout paramTextInputLayout) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    TextInputLayout localTextInputLayout = this.a;
    localTextInputLayout.a(localTextInputLayout.e ^ true, false);
    localTextInputLayout = this.a;
    if (localTextInputLayout.b) {
      localTextInputLayout.a(paramEditable.length());
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/textfield/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */