package android.support.v7.widget;

import android.view.View;
import android.view.View.OnClickListener;

final class gk
  implements View.OnClickListener
{
  gk(SearchView paramSearchView) {}
  
  public final void onClick(View paramView)
  {
    SearchView localSearchView = this.a;
    if (paramView == localSearchView.mSearchButton) {
      localSearchView.onSearchClicked();
    }
    do
    {
      return;
      if (paramView == localSearchView.mCloseButton)
      {
        localSearchView.onCloseClicked();
        return;
      }
      if (paramView == localSearchView.mGoButton)
      {
        localSearchView.onSubmitQuery();
        return;
      }
      if (paramView == localSearchView.mVoiceButton)
      {
        localSearchView.onVoiceClicked();
        return;
      }
    } while (paramView != localSearchView.mSearchSrcTextView);
    localSearchView.forceSuggestionQuery();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */