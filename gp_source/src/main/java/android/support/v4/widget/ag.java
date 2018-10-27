package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;

public final class ag
  extends a
{
  private final ListView f;
  
  public ag(ListView paramListView)
  {
    super(paramListView);
    this.f = paramListView;
  }
  
  public final void a(int paramInt)
  {
    ListView localListView = this.f;
    if (Build.VERSION.SDK_INT >= 19) {
      localListView.scrollListBy(paramInt);
    }
    int i;
    View localView;
    do
    {
      do
      {
        return;
        i = localListView.getFirstVisiblePosition();
      } while (i == -1);
      localView = localListView.getChildAt(0);
    } while (localView == null);
    localListView.setSelectionFromTop(i, localView.getTop() - paramInt);
  }
  
  public final boolean b()
  {
    return false;
  }
  
  public final boolean b(int paramInt)
  {
    boolean bool2 = false;
    ListView localListView = this.f;
    int i = localListView.getCount();
    boolean bool1 = bool2;
    int j;
    int k;
    if (i != 0)
    {
      j = localListView.getChildCount();
      k = localListView.getFirstVisiblePosition();
      if (paramInt > 0) {
        break label75;
      }
      bool1 = bool2;
      if (paramInt < 0) {
        if (k <= 0)
        {
          bool1 = bool2;
          if (localListView.getChildAt(0).getTop() >= 0) {
            break label72;
          }
        }
      }
    }
    label72:
    label75:
    while ((k + j < i) || (localListView.getChildAt(j - 1).getBottom() > localListView.getHeight()))
    {
      bool1 = true;
      return bool1;
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */