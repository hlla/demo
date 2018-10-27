package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.c.a.a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ak
  extends e
  implements Menu
{
  ak(Context paramContext, a parama)
  {
    super(paramContext, parama);
  }
  
  public MenuItem add(int paramInt)
  {
    return a(((a)this.d).add(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(((a)this.d).add(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(((a)this.d).add(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(((a)this.d).add(paramCharSequence));
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    if (paramArrayOfMenuItem != null) {}
    for (MenuItem[] arrayOfMenuItem = new MenuItem[paramArrayOfMenuItem.length];; arrayOfMenuItem = null)
    {
      paramInt2 = ((a)this.d).addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, arrayOfMenuItem);
      if (arrayOfMenuItem == null) {
        break;
      }
      paramInt3 = arrayOfMenuItem.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt3)
      {
        paramArrayOfMenuItem[paramInt1] = a(arrayOfMenuItem[paramInt1]);
        paramInt1 += 1;
      }
    }
    return paramInt2;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return a(((a)this.d).addSubMenu(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(((a)this.d).addSubMenu(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(((a)this.d).addSubMenu(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return a(((a)this.d).addSubMenu(paramCharSequence));
  }
  
  public void clear()
  {
    Map localMap = this.b;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = this.c;
    if (localMap != null) {
      localMap.clear();
    }
    ((a)this.d).clear();
  }
  
  public void close()
  {
    ((a)this.d).close();
  }
  
  public MenuItem findItem(int paramInt)
  {
    return a(((a)this.d).findItem(paramInt));
  }
  
  public MenuItem getItem(int paramInt)
  {
    return a(((a)this.d).getItem(paramInt));
  }
  
  public boolean hasVisibleItems()
  {
    return ((a)this.d).hasVisibleItems();
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return ((a)this.d).isShortcutKey(paramInt, paramKeyEvent);
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return ((a)this.d).performIdentifierAction(paramInt1, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    return ((a)this.d).performShortcut(paramInt1, paramKeyEvent, paramInt2);
  }
  
  public void removeGroup(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramInt == ((MenuItem)((Iterator)localObject).next()).getGroupId()) {
          ((Iterator)localObject).remove();
        }
      }
    }
    ((a)this.d).removeGroup(paramInt);
  }
  
  public void removeItem(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((Map)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramInt == ((MenuItem)((Iterator)localObject).next()).getItemId()) {
          ((Iterator)localObject).remove();
        }
      }
    }
    ((a)this.d).removeItem(paramInt);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((a)this.d).setGroupCheckable(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    ((a)this.d).setGroupEnabled(paramInt, paramBoolean);
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    ((a)this.d).setGroupVisible(paramInt, paramBoolean);
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    ((a)this.d).setQwertyMode(paramBoolean);
  }
  
  public int size()
  {
    return ((a)this.d).size();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */