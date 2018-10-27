package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.t;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;

public final class ee
  extends bx
{
  private final int c;
  private ec d;
  private MenuItem e;
  private final int f;
  
  public ee(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    paramContext = paramContext.getResources().getConfiguration();
    if ((Build.VERSION.SDK_INT >= 17) && (paramContext.getLayoutDirection() == 1))
    {
      this.c = 21;
      this.f = 22;
      return;
    }
    this.c = 22;
    this.f = 21;
  }
  
  public final boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    Object localObject1;
    int i;
    Object localObject2;
    if (this.d != null)
    {
      localObject1 = getAdapter();
      if (!(localObject1 instanceof HeaderViewListAdapter)) {
        break label193;
      }
      localObject1 = (HeaderViewListAdapter)localObject1;
      i = ((HeaderViewListAdapter)localObject1).getHeadersCount();
      localObject2 = (o)((HeaderViewListAdapter)localObject1).getWrappedAdapter();
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() != 10)
      {
        int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (j != -1)
        {
          i = j - i;
          if (i >= 0) {
            if (i < ((o)localObject2).getCount()) {
              localObject1 = (t)((o)localObject2).getItem(i);
            }
          }
        }
      }
      for (;;)
      {
        MenuItem localMenuItem = this.e;
        if (localMenuItem != localObject1)
        {
          localObject2 = ((o)localObject2).a;
          if (localMenuItem != null) {
            this.d.a((p)localObject2, localMenuItem);
          }
          this.e = ((MenuItem)localObject1);
          if (localObject1 != null) {
            this.d.b((p)localObject2, (MenuItem)localObject1);
          }
        }
        return super.onHoverEvent(paramMotionEvent);
        localObject1 = null;
        continue;
        localObject1 = null;
        continue;
        localObject1 = null;
        continue;
        localObject1 = null;
      }
      label193:
      localObject2 = (o)localObject1;
      i = 0;
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    ListMenuItemView localListMenuItemView = (ListMenuItemView)getSelectedView();
    if ((localListMenuItemView != null) && (paramInt == this.c))
    {
      if ((localListMenuItemView.isEnabled()) && (localListMenuItemView.getItemData().hasSubMenu())) {
        performItemClick(localListMenuItemView, getSelectedItemPosition(), getSelectedItemId());
      }
      return true;
    }
    if ((localListMenuItemView != null) && (paramInt == this.f))
    {
      setSelection(-1);
      ((o)getAdapter()).a.a(false);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void setHoverListener(ec paramec)
  {
    this.d = paramec;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */