package android.support.v7.view.menu;

import android.support.v7.widget.ch;

final class b
  extends ch
{
  public b(ActionMenuItemView paramActionMenuItemView)
  {
    super(paramActionMenuItemView);
  }
  
  public final al a()
  {
    c localc = this.c.d;
    if (localc != null) {
      return localc.a();
    }
    return null;
  }
  
  protected final boolean b()
  {
    boolean bool2 = false;
    Object localObject = this.c;
    r localr = ((ActionMenuItemView)localObject).c;
    boolean bool1 = bool2;
    if (localr != null)
    {
      bool1 = bool2;
      if (localr.a(((ActionMenuItemView)localObject).b))
      {
        localObject = a();
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((al)localObject).d()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */