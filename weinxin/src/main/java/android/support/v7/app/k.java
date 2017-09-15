package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.z;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.l.a;
import android.support.v7.widget.u;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

final class k
  extends ActionBar
{
  public u HI;
  public Window.Callback HJ;
  private boolean HK;
  private boolean HL;
  private ArrayList<Object> HM;
  private final Runnable HN;
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.HI.getDisplayOptions();
    this.HI.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void cJ()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void cK()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void cL()
  {
    setDisplayOptions(16, 16);
  }
  
  public final boolean cM()
  {
    this.HI.eI().removeCallbacks(this.HN);
    z.a(this.HI.eI(), this.HN);
    return true;
  }
  
  public final boolean collapseActionView()
  {
    if (this.HI.hasExpandedActionView())
    {
      this.HI.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void e(CharSequence paramCharSequence)
  {
    this.HI.e(paramCharSequence);
  }
  
  public final View getCustomView()
  {
    return this.HI.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.HI.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.HI.getHeight();
  }
  
  public final Context getThemedContext()
  {
    return this.HI.getContext();
  }
  
  public final CharSequence getTitle()
  {
    return this.HI.getTitle();
  }
  
  public final void hide()
  {
    this.HI.setVisibility(8);
  }
  
  public final boolean isShowing()
  {
    return this.HI.getVisibility() == 0;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  final void onDestroy()
  {
    this.HI.eI().removeCallbacks(this.HN);
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.HK)
    {
      this.HI.a(new a(), new b());
      this.HK = true;
    }
    Menu localMenu = this.HI.getMenu();
    int i;
    if (localMenu != null)
    {
      if (paramKeyEvent == null) {
        break label98;
      }
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label103;
      }
    }
    label98:
    label103:
    for (boolean bool = true;; bool = false)
    {
      localMenu.setQwertyMode(bool);
      localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      return true;
      i = -1;
      break;
    }
  }
  
  public final boolean requestFocus()
  {
    ViewGroup localViewGroup = this.HI.eI();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.HI.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(this.HI.getContext()).inflate(paramInt, this.HI.eI(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    ActionBar.LayoutParams localLayoutParams = new ActionBar.LayoutParams(-2, -2);
    if (paramView != null) {
      paramView.setLayoutParams(localLayoutParams);
    }
    this.HI.setCustomView(paramView);
  }
  
  public final void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      return;
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    setDisplayOptions(paramInt, -1);
  }
  
  public final void setElevation(float paramFloat)
  {
    z.g(this.HI.eI(), paramFloat);
  }
  
  public final void setIcon(int paramInt)
  {
    this.HI.setIcon(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.HI.setLogo(paramDrawable);
  }
  
  public final void show()
  {
    this.HI.setVisibility(0);
  }
  
  public final void w(boolean paramBoolean) {}
  
  public final void x(boolean paramBoolean) {}
  
  public final void y(boolean paramBoolean)
  {
    if (paramBoolean == this.HL) {}
    for (;;)
    {
      return;
      this.HL = paramBoolean;
      int j = this.HM.size();
      int i = 0;
      while (i < j)
      {
        this.HM.get(i);
        i += 1;
      }
    }
  }
  
  private final class a
    implements l.a
  {
    private boolean GZ;
    
    public a() {}
    
    public final void a(f paramf, boolean paramBoolean)
    {
      if (this.GZ) {
        return;
      }
      this.GZ = true;
      k.this.HI.dismissPopupMenus();
      if (k.this.HJ != null) {
        k.this.HJ.onPanelClosed(108, paramf);
      }
      this.GZ = false;
    }
    
    public final boolean d(f paramf)
    {
      if (k.this.HJ != null)
      {
        k.this.HJ.onMenuOpened(108, paramf);
        return true;
      }
      return false;
    }
  }
  
  private final class b
    implements f.a
  {
    public b() {}
    
    public final boolean a(f paramf, MenuItem paramMenuItem)
    {
      return false;
    }
    
    public final void b(f paramf)
    {
      if (k.this.HJ != null)
      {
        if (!k.this.HI.isOverflowMenuShowing()) {
          break label41;
        }
        k.this.HJ.onPanelClosed(108, paramf);
      }
      label41:
      while (!k.this.HJ.onPreparePanel(0, null, paramf)) {
        return;
      }
      k.this.HJ.onMenuOpened(108, paramf);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */