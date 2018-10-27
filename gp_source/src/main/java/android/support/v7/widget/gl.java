package android.support.v7.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class gl
  implements View.OnKeyListener
{
  gl(SearchView paramSearchView) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    SearchView localSearchView = this.a;
    if (localSearchView.mSearchable != null)
    {
      if ((localSearchView.mSearchSrcTextView.isPopupShowing()) && (this.a.mSearchSrcTextView.getListSelection() != -1)) {
        return this.a.onSuggestionsKey(paramView, paramInt, paramKeyEvent);
      }
      if ((TextUtils.getTrimmedLength(this.a.mSearchSrcTextView.getText()) != 0) && (paramKeyEvent.hasNoModifiers()) && (paramKeyEvent.getAction() == 1) && (paramInt == 66))
      {
        paramView.cancelLongPress();
        paramView = this.a;
        paramView.launchQuerySearch(0, null, paramView.mSearchSrcTextView.getText().toString());
        return true;
      }
      return false;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */