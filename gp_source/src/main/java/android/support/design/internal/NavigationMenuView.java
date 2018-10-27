package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.ah;
import android.support.v7.view.menu.p;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class NavigationMenuView
  extends RecyclerView
  implements ah
{
  public NavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutManager(new LinearLayoutManager(1, false));
  }
  
  public final void a(p paramp) {}
  
  public int getWindowAnimations()
  {
    return 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/NavigationMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */