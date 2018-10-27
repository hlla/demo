package android.support.v7.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

final class q
  extends ArrayAdapter
{
  q(p paramp, Context paramContext, int paramInt, CharSequence[] paramArrayOfCharSequence, AlertController.RecycleListView paramRecycleListView)
  {
    super(paramContext, paramInt, 16908308, paramArrayOfCharSequence);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = this.a.d;
    if ((paramViewGroup != null) && (paramViewGroup[paramInt] != 0)) {
      this.b.setItemChecked(paramInt, true);
    }
    return paramView;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */