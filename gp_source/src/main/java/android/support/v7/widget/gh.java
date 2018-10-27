package android.support.v7.widget;

import android.support.v4.widget.l;

final class gh
  implements Runnable
{
  gh(SearchView paramSearchView) {}
  
  public final void run()
  {
    l locall = this.a.mSuggestionsAdapter;
    if ((locall != null) && ((locall instanceof gx))) {
      locall.a(null);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */