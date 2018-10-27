package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.d;
import android.view.MenuItem;
import android.view.View;

public abstract interface b
  extends MenuItem
{
  public abstract b a(d paramd);
  
  public abstract b a(CharSequence paramCharSequence);
  
  public abstract d a();
  
  public abstract b b(CharSequence paramCharSequence);
  
  public abstract boolean collapseActionView();
  
  public abstract boolean expandActionView();
  
  public abstract View getActionView();
  
  public abstract int getAlphabeticModifiers();
  
  public abstract CharSequence getContentDescription();
  
  public abstract ColorStateList getIconTintList();
  
  public abstract PorterDuff.Mode getIconTintMode();
  
  public abstract int getNumericModifiers();
  
  public abstract CharSequence getTooltipText();
  
  public abstract boolean isActionViewExpanded();
  
  public abstract MenuItem setActionView(int paramInt);
  
  public abstract MenuItem setActionView(View paramView);
  
  public abstract MenuItem setAlphabeticShortcut(char paramChar, int paramInt);
  
  public abstract MenuItem setIconTintList(ColorStateList paramColorStateList);
  
  public abstract MenuItem setIconTintMode(PorterDuff.Mode paramMode);
  
  public abstract MenuItem setNumericShortcut(char paramChar, int paramInt);
  
  public abstract MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2);
  
  public abstract void setShowAsAction(int paramInt);
  
  public abstract MenuItem setShowAsActionFlags(int paramInt);
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */