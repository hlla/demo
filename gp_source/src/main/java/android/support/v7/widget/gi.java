package android.support.v7.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class gi
  implements View.OnFocusChangeListener
{
  gi(SearchView paramSearchView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    paramView = this.a;
    View.OnFocusChangeListener localOnFocusChangeListener = paramView.mOnQueryTextFocusChangeListener;
    if (localOnFocusChangeListener != null) {
      localOnFocusChangeListener.onFocusChange(paramView, paramBoolean);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */