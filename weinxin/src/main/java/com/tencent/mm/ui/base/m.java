package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;

public final class m
  implements MenuItem
{
  private int OS;
  private int OZ;
  public String iMj;
  private int iconId;
  private Intent intent;
  public CharSequence pfk;
  private CharSequence title;
  public boolean udt;
  private int vjm;
  private Drawable vjn;
  public ContextMenu.ContextMenuInfo vjo;
  private MenuItem.OnMenuItemClickListener vjp;
  
  public m(int paramInt1, int paramInt2)
  {
    GMTrace.i(13081799294976L, 97467);
    this.pfk = null;
    this.udt = false;
    this.OZ = paramInt1;
    this.OS = paramInt2;
    GMTrace.o(13081799294976L, 97467);
  }
  
  public final boolean collapseActionView()
  {
    GMTrace.i(13086094262272L, 97499);
    GMTrace.o(13086094262272L, 97499);
    return false;
  }
  
  public final boolean expandActionView()
  {
    GMTrace.i(13086228480000L, 97500);
    GMTrace.o(13086228480000L, 97500);
    return false;
  }
  
  public final ActionProvider getActionProvider()
  {
    GMTrace.i(13086362697728L, 97501);
    GMTrace.o(13086362697728L, 97501);
    return null;
  }
  
  public final View getActionView()
  {
    GMTrace.i(13086496915456L, 97502);
    GMTrace.o(13086496915456L, 97502);
    return null;
  }
  
  public final char getAlphabeticShortcut()
  {
    GMTrace.i(13084215214080L, 97485);
    GMTrace.o(13084215214080L, 97485);
    return '\000';
  }
  
  public final int getGroupId()
  {
    GMTrace.i(13082067730432L, 97469);
    int i = this.OS;
    GMTrace.o(13082067730432L, 97469);
    return i;
  }
  
  public final Drawable getIcon()
  {
    GMTrace.i(13083275689984L, 97478);
    if (this.vjn == null)
    {
      if (this.iconId != 0)
      {
        localDrawable = aa.getContext().getResources().getDrawable(this.iconId);
        GMTrace.o(13083275689984L, 97478);
        return localDrawable;
      }
      GMTrace.o(13083275689984L, 97478);
      return null;
    }
    Drawable localDrawable = this.vjn;
    GMTrace.o(13083275689984L, 97478);
    return localDrawable;
  }
  
  public final Intent getIntent()
  {
    GMTrace.i(13083544125440L, 97480);
    Intent localIntent = this.intent;
    GMTrace.o(13083544125440L, 97480);
    return localIntent;
  }
  
  public final int getItemId()
  {
    GMTrace.i(13081933512704L, 97468);
    int i = this.OZ;
    GMTrace.o(13081933512704L, 97468);
    return i;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    GMTrace.i(13085960044544L, 97498);
    ContextMenu.ContextMenuInfo localContextMenuInfo = this.vjo;
    GMTrace.o(13085960044544L, 97498);
    return localContextMenuInfo;
  }
  
  public final char getNumericShortcut()
  {
    GMTrace.i(13083946778624L, 97483);
    GMTrace.o(13083946778624L, 97483);
    return '\000';
  }
  
  public final int getOrder()
  {
    GMTrace.i(13082201948160L, 97470);
    GMTrace.o(13082201948160L, 97470);
    return 0;
  }
  
  public final SubMenu getSubMenu()
  {
    GMTrace.i(13085557391360L, 97495);
    GMTrace.o(13085557391360L, 97495);
    return null;
  }
  
  public final CharSequence getTitle()
  {
    GMTrace.i(13082604601344L, 97473);
    if (this.title == null)
    {
      if (this.vjm != 0)
      {
        localObject = aa.getContext().getString(this.vjm);
        GMTrace.o(13082604601344L, 97473);
        return (CharSequence)localObject;
      }
      GMTrace.o(13082604601344L, 97473);
      return null;
    }
    Object localObject = this.title;
    GMTrace.o(13082604601344L, 97473);
    return (CharSequence)localObject;
  }
  
  public final CharSequence getTitleCondensed()
  {
    GMTrace.i(13082873036800L, 97475);
    GMTrace.o(13082873036800L, 97475);
    return null;
  }
  
  public final boolean hasSubMenu()
  {
    GMTrace.i(13085423173632L, 97494);
    GMTrace.o(13085423173632L, 97494);
    return false;
  }
  
  public final boolean isActionViewExpanded()
  {
    GMTrace.i(13086631133184L, 97503);
    GMTrace.o(13086631133184L, 97503);
    return false;
  }
  
  public final boolean isCheckable()
  {
    GMTrace.i(13084483649536L, 97487);
    GMTrace.o(13084483649536L, 97487);
    return false;
  }
  
  public final boolean isChecked()
  {
    GMTrace.i(13084752084992L, 97489);
    GMTrace.o(13084752084992L, 97489);
    return false;
  }
  
  public final boolean isEnabled()
  {
    GMTrace.i(13085288955904L, 97493);
    GMTrace.o(13085288955904L, 97493);
    return true;
  }
  
  public final boolean isVisible()
  {
    GMTrace.i(13085020520448L, 97491);
    GMTrace.o(13085020520448L, 97491);
    return true;
  }
  
  public final boolean performClick()
  {
    GMTrace.i(13085825826816L, 97497);
    if (this.vjp != null)
    {
      boolean bool = this.vjp.onMenuItemClick(this);
      GMTrace.o(13085825826816L, 97497);
      return bool;
    }
    GMTrace.o(13085825826816L, 97497);
    return false;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    GMTrace.i(13086765350912L, 97504);
    GMTrace.o(13086765350912L, 97504);
    return null;
  }
  
  public final MenuItem setActionView(int paramInt)
  {
    GMTrace.i(13087033786368L, 97506);
    GMTrace.o(13087033786368L, 97506);
    return null;
  }
  
  public final MenuItem setActionView(View paramView)
  {
    GMTrace.i(13086899568640L, 97505);
    GMTrace.o(13086899568640L, 97505);
    return null;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    GMTrace.i(13084080996352L, 97484);
    GMTrace.o(13084080996352L, 97484);
    return this;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    GMTrace.i(13084349431808L, 97486);
    GMTrace.o(13084349431808L, 97486);
    return this;
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    GMTrace.i(13084617867264L, 97488);
    GMTrace.o(13084617867264L, 97488);
    return this;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    GMTrace.i(13085154738176L, 97492);
    GMTrace.o(13085154738176L, 97492);
    return this;
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    GMTrace.i(13083141472256L, 97477);
    this.iconId = paramInt;
    GMTrace.o(13083141472256L, 97477);
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    GMTrace.i(13083007254528L, 97476);
    this.vjn = paramDrawable;
    GMTrace.o(13083007254528L, 97476);
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    GMTrace.i(13083409907712L, 97479);
    this.intent = paramIntent;
    GMTrace.o(13083409907712L, 97479);
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    GMTrace.i(13083812560896L, 97482);
    GMTrace.o(13083812560896L, 97482);
    return this;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    GMTrace.i(13087168004096L, 97507);
    GMTrace.o(13087168004096L, 97507);
    return null;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(13085691609088L, 97496);
    this.vjp = paramOnMenuItemClickListener;
    GMTrace.o(13085691609088L, 97496);
    return this;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    GMTrace.i(13083678343168L, 97481);
    GMTrace.o(13083678343168L, 97481);
    return this;
  }
  
  public final void setShowAsAction(int paramInt)
  {
    GMTrace.i(13087302221824L, 97508);
    GMTrace.o(13087302221824L, 97508);
  }
  
  public final MenuItem setShowAsActionFlags(int paramInt)
  {
    GMTrace.i(13087436439552L, 97509);
    GMTrace.o(13087436439552L, 97509);
    return null;
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    GMTrace.i(13082470383616L, 97472);
    this.vjm = paramInt;
    GMTrace.o(13082470383616L, 97472);
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    GMTrace.i(13082336165888L, 97471);
    this.title = paramCharSequence;
    GMTrace.o(13082336165888L, 97471);
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    GMTrace.i(13082738819072L, 97474);
    GMTrace.o(13082738819072L, 97474);
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    GMTrace.i(13084886302720L, 97490);
    GMTrace.o(13084886302720L, 97490);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */