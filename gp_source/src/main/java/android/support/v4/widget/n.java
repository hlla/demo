package android.support.v4.widget;

import android.database.DataSetObserver;

final class n
  extends DataSetObserver
{
  n(l paraml) {}
  
  public final void onChanged()
  {
    l locall = this.a;
    locall.d = true;
    locall.notifyDataSetChanged();
  }
  
  public final void onInvalidated()
  {
    l locall = this.a;
    locall.d = false;
    locall.notifyDataSetInvalidated();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */