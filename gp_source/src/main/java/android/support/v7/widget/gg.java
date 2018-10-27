package android.support.v7.widget;

import android.text.Editable;
import android.text.TextWatcher;

final class gg
  implements TextWatcher
{
  gg(SearchView paramSearchView) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.onTextChanged(paramCharSequence);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */