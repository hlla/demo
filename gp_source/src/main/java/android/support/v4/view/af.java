package android.support.v4.view;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

final class af
{
  public static final ArrayList c = new ArrayList();
  public WeakReference a = null;
  public WeakHashMap b = null;
  private SparseArray d = null;
  
  static af a(View paramView)
  {
    af localaf2 = (af)paramView.getTag(2131429437);
    af localaf1 = localaf2;
    if (localaf2 == null)
    {
      localaf1 = new af();
      paramView.setTag(2131429437, localaf1);
    }
    return localaf1;
  }
  
  static boolean b(View paramView)
  {
    paramView = (ArrayList)paramView.getTag(2131429438);
    if (paramView != null)
    {
      int i = paramView.size() - 1;
      while (i >= 0) {
        if (!((ae)paramView.get(i)).a()) {
          i -= 1;
        } else {
          return true;
        }
      }
    }
    return false;
  }
  
  final SparseArray a()
  {
    if (this.d == null) {
      this.d = new SparseArray();
    }
    return this.d;
  }
  
  final View a(View paramView, KeyEvent paramKeyEvent)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((WeakHashMap)localObject).containsKey(paramView)))
    {
      if ((paramView instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        int i = localViewGroup.getChildCount() - 1;
        while (i >= 0)
        {
          localObject = a(localViewGroup.getChildAt(i), paramKeyEvent);
          if (localObject == null) {
            i -= 1;
          } else {
            paramKeyEvent = (KeyEvent)localObject;
          }
        }
      }
      do
      {
        return paramKeyEvent;
        paramKeyEvent = paramView;
      } while (b(paramView));
      return null;
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */