package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.c.a.b;
import android.view.MenuItem;
import android.view.View;

public final class m
{
  static final d xe = new a();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      xe = new c();
      return;
    }
    if (i >= 11)
    {
      xe = new b();
      return;
    }
  }
  
  public static MenuItem a(MenuItem paramMenuItem, d paramd)
  {
    Object localObject = paramMenuItem;
    if ((paramMenuItem instanceof b)) {
      localObject = ((b)paramMenuItem).a(paramd);
    }
    return (MenuItem)localObject;
  }
  
  public static MenuItem a(MenuItem paramMenuItem, e parame)
  {
    if ((paramMenuItem instanceof b)) {
      return ((b)paramMenuItem).a(parame);
    }
    return xe.a(paramMenuItem, parame);
  }
  
  public static MenuItem a(MenuItem paramMenuItem, View paramView)
  {
    if ((paramMenuItem instanceof b)) {
      return ((b)paramMenuItem).setActionView(paramView);
    }
    return xe.a(paramMenuItem, paramView);
  }
  
  public static View a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof b)) {
      return ((b)paramMenuItem).getActionView();
    }
    return xe.a(paramMenuItem);
  }
  
  public static void a(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof b))
    {
      ((b)paramMenuItem).setShowAsAction(paramInt);
      return;
    }
    xe.a(paramMenuItem, paramInt);
  }
  
  public static MenuItem b(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof b)) {
      return ((b)paramMenuItem).setActionView(paramInt);
    }
    return xe.b(paramMenuItem, paramInt);
  }
  
  public static boolean b(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof b)) {
      return ((b)paramMenuItem).expandActionView();
    }
    return xe.b(paramMenuItem);
  }
  
  public static boolean c(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof b)) {
      return ((b)paramMenuItem).collapseActionView();
    }
    return xe.c(paramMenuItem);
  }
  
  public static boolean d(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof b)) {
      return ((b)paramMenuItem).isActionViewExpanded();
    }
    return xe.d(paramMenuItem);
  }
  
  static final class a
    implements m.d
  {
    public final MenuItem a(MenuItem paramMenuItem, m.e parame)
    {
      return paramMenuItem;
    }
    
    public final MenuItem a(MenuItem paramMenuItem, View paramView)
    {
      return paramMenuItem;
    }
    
    public final View a(MenuItem paramMenuItem)
    {
      return null;
    }
    
    public final void a(MenuItem paramMenuItem, int paramInt) {}
    
    public final MenuItem b(MenuItem paramMenuItem, int paramInt)
    {
      return paramMenuItem;
    }
    
    public final boolean b(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public final boolean c(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public final boolean d(MenuItem paramMenuItem)
    {
      return false;
    }
  }
  
  static class b
    implements m.d
  {
    public MenuItem a(MenuItem paramMenuItem, m.e parame)
    {
      return paramMenuItem;
    }
    
    public final MenuItem a(MenuItem paramMenuItem, View paramView)
    {
      return paramMenuItem.setActionView(paramView);
    }
    
    public final View a(MenuItem paramMenuItem)
    {
      return paramMenuItem.getActionView();
    }
    
    public final void a(MenuItem paramMenuItem, int paramInt)
    {
      paramMenuItem.setShowAsAction(paramInt);
    }
    
    public final MenuItem b(MenuItem paramMenuItem, int paramInt)
    {
      return paramMenuItem.setActionView(paramInt);
    }
    
    public boolean b(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public boolean c(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public boolean d(MenuItem paramMenuItem)
    {
      return false;
    }
  }
  
  static final class c
    extends m.b
  {
    public final MenuItem a(MenuItem paramMenuItem, final m.e parame)
    {
      if (parame == null) {
        return n.a(paramMenuItem, null);
      }
      n.a(paramMenuItem, new n.b()
      {
        public final boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
        {
          return parame.onMenuItemActionCollapse(paramAnonymousMenuItem);
        }
        
        public final boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
        {
          return parame.onMenuItemActionExpand(paramAnonymousMenuItem);
        }
      });
    }
    
    public final boolean b(MenuItem paramMenuItem)
    {
      return paramMenuItem.expandActionView();
    }
    
    public final boolean c(MenuItem paramMenuItem)
    {
      return paramMenuItem.collapseActionView();
    }
    
    public final boolean d(MenuItem paramMenuItem)
    {
      return paramMenuItem.isActionViewExpanded();
    }
  }
  
  static abstract interface d
  {
    public abstract MenuItem a(MenuItem paramMenuItem, m.e parame);
    
    public abstract MenuItem a(MenuItem paramMenuItem, View paramView);
    
    public abstract View a(MenuItem paramMenuItem);
    
    public abstract void a(MenuItem paramMenuItem, int paramInt);
    
    public abstract MenuItem b(MenuItem paramMenuItem, int paramInt);
    
    public abstract boolean b(MenuItem paramMenuItem);
    
    public abstract boolean c(MenuItem paramMenuItem);
    
    public abstract boolean d(MenuItem paramMenuItem);
  }
  
  public static abstract interface e
  {
    public abstract boolean onMenuItemActionCollapse(MenuItem paramMenuItem);
    
    public abstract boolean onMenuItemActionExpand(MenuItem paramMenuItem);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */