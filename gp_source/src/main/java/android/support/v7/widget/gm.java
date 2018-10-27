package android.support.v7.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class gm
  implements TextView.OnEditorActionListener
{
  gm(SearchView paramSearchView) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    this.a.onSubmitQuery();
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */