package android.support.v7.widget;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

final class gu
  implements Runnable
{
  gu(SearchView.SearchAutoComplete paramSearchAutoComplete) {}
  
  public final void run()
  {
    SearchView.SearchAutoComplete localSearchAutoComplete = this.a;
    if (localSearchAutoComplete.a)
    {
      ((InputMethodManager)localSearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(localSearchAutoComplete, 0);
      localSearchAutoComplete.a = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */