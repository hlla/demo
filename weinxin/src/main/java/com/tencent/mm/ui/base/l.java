package com.tencent.mm.ui.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class l
  implements ContextMenu
{
  public CharSequence Qz;
  public List<MenuItem> vjl;
  
  public l()
  {
    GMTrace.i(13087704875008L, 97511);
    this.vjl = new ArrayList();
    GMTrace.o(13087704875008L, 97511);
  }
  
  public final MenuItem W(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(13088510181376L, 97517);
    m localm = new m(paramInt1, 0);
    localm.setTitle(paramInt2);
    localm.setIcon(paramInt3);
    this.vjl.add(localm);
    GMTrace.o(13088510181376L, 97517);
    return localm;
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    GMTrace.i(13089047052288L, 97521);
    m localm = new m(paramInt1, 0);
    paramCharSequence = new SpannableString(paramCharSequence);
    paramCharSequence.setSpan(new ForegroundColorSpan(paramInt2), 0, paramCharSequence.length(), 0);
    localm.setTitle(paramCharSequence);
    this.vjl.add(localm);
    GMTrace.o(13089047052288L, 97521);
    return localm;
  }
  
  public final MenuItem a(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    GMTrace.i(13088912834560L, 97520);
    m localm = new m(paramInt1, 0);
    localm.setTitle(paramCharSequence);
    localm.setIcon(paramInt2);
    this.vjl.add(localm);
    GMTrace.o(13088912834560L, 97520);
    return localm;
  }
  
  public final MenuItem a(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Drawable paramDrawable, boolean paramBoolean)
  {
    GMTrace.i(18766188511232L, 139819);
    m localm = new m(paramInt, 0);
    localm.setTitle(paramCharSequence1);
    localm.pfk = paramCharSequence2;
    localm.setIcon(paramDrawable);
    localm.udt = paramBoolean;
    this.vjl.add(localm);
    GMTrace.o(18766188511232L, 139819);
    return localm;
  }
  
  public final MenuItem add(int paramInt)
  {
    GMTrace.i(13088241745920L, 97515);
    m localm = new m(0, 0);
    localm.setTitle(paramInt);
    this.vjl.add(localm);
    GMTrace.o(13088241745920L, 97515);
    return localm;
  }
  
  public final MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(13087973310464L, 97513);
    m localm = new m(paramInt2, paramInt1);
    localm.setTitle(paramInt4);
    this.vjl.add(localm);
    GMTrace.o(13087973310464L, 97513);
    return localm;
  }
  
  public final MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    GMTrace.i(13088107528192L, 97514);
    m localm = new m(paramInt2, paramInt1);
    localm.setTitle(paramCharSequence);
    this.vjl.add(localm);
    GMTrace.o(13088107528192L, 97514);
    return localm;
  }
  
  public final MenuItem add(CharSequence paramCharSequence)
  {
    GMTrace.i(13088375963648L, 97516);
    m localm = new m(0, 0);
    localm.setTitle(paramCharSequence);
    this.vjl.add(localm);
    GMTrace.o(13088375963648L, 97516);
    return localm;
  }
  
  public final int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    GMTrace.i(13089718140928L, 97526);
    GMTrace.o(13089718140928L, 97526);
    return 0;
  }
  
  public final SubMenu addSubMenu(int paramInt)
  {
    GMTrace.i(13089315487744L, 97523);
    GMTrace.o(13089315487744L, 97523);
    return null;
  }
  
  public final SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(13089583923200L, 97525);
    GMTrace.o(13089583923200L, 97525);
    return null;
  }
  
  public final SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    GMTrace.i(13089449705472L, 97524);
    GMTrace.o(13089449705472L, 97524);
    return null;
  }
  
  public final SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    GMTrace.i(13089181270016L, 97522);
    GMTrace.o(13089181270016L, 97522);
    return null;
  }
  
  public final boolean bSa()
  {
    GMTrace.i(13087839092736L, 97512);
    if (this.vjl.size() == 0)
    {
      GMTrace.o(13087839092736L, 97512);
      return true;
    }
    GMTrace.o(13087839092736L, 97512);
    return false;
  }
  
  public final void clear()
  {
    GMTrace.i(13090120794112L, 97529);
    Iterator localIterator = this.vjl.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      ((m)localMenuItem).vjo = null;
      ((m)localMenuItem).setOnMenuItemClickListener(null);
    }
    this.vjl.clear();
    this.Qz = null;
    GMTrace.o(13090120794112L, 97529);
  }
  
  public final void clearHeader()
  {
    GMTrace.i(13092536713216L, 97547);
    GMTrace.o(13092536713216L, 97547);
  }
  
  public final void close()
  {
    GMTrace.i(13091194535936L, 97537);
    GMTrace.o(13091194535936L, 97537);
  }
  
  public final MenuItem dX(int paramInt1, int paramInt2)
  {
    GMTrace.i(13088644399104L, 97518);
    m localm = new m(paramInt1, 0);
    localm.setTitle(paramInt2);
    this.vjl.add(localm);
    GMTrace.o(13088644399104L, 97518);
    return localm;
  }
  
  public final MenuItem e(int paramInt, CharSequence paramCharSequence)
  {
    GMTrace.i(13088778616832L, 97519);
    m localm = new m(paramInt, 0);
    localm.setTitle(paramCharSequence);
    this.vjl.add(localm);
    GMTrace.o(13088778616832L, 97519);
    return localm;
  }
  
  public final MenuItem findItem(int paramInt)
  {
    GMTrace.i(13090791882752L, 97534);
    Iterator localIterator = this.vjl.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt)
      {
        GMTrace.o(13090791882752L, 97534);
        return localMenuItem;
      }
    }
    GMTrace.o(13090791882752L, 97534);
    return null;
  }
  
  public final MenuItem getItem(int paramInt)
  {
    GMTrace.i(13091060318208L, 97536);
    MenuItem localMenuItem = (MenuItem)this.vjl.get(paramInt);
    GMTrace.o(13091060318208L, 97536);
    return localMenuItem;
  }
  
  public final boolean hasVisibleItems()
  {
    GMTrace.i(13090657665024L, 97533);
    GMTrace.o(13090657665024L, 97533);
    return false;
  }
  
  public final boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(13091462971392L, 97539);
    GMTrace.o(13091462971392L, 97539);
    return false;
  }
  
  public final boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    GMTrace.i(13091597189120L, 97540);
    GMTrace.o(13091597189120L, 97540);
    return false;
  }
  
  public final boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    GMTrace.i(13091328753664L, 97538);
    GMTrace.o(13091328753664L, 97538);
    return false;
  }
  
  public final void removeGroup(int paramInt)
  {
    GMTrace.i(13089986576384L, 97528);
    GMTrace.o(13089986576384L, 97528);
  }
  
  public final void removeItem(int paramInt)
  {
    GMTrace.i(13089852358656L, 97527);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.vjl.iterator();
    while (localIterator.hasNext())
    {
      MenuItem localMenuItem = (MenuItem)localIterator.next();
      if (localMenuItem.getItemId() == paramInt) {
        localArrayList.add(localMenuItem);
      }
    }
    this.vjl.removeAll(localArrayList);
    GMTrace.o(13089852358656L, 97527);
  }
  
  public final void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13090255011840L, 97530);
    GMTrace.o(13090255011840L, 97530);
  }
  
  public final void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(13090523447296L, 97532);
    GMTrace.o(13090523447296L, 97532);
  }
  
  public final void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(13090389229568L, 97531);
    GMTrace.o(13090389229568L, 97531);
  }
  
  public final ContextMenu setHeaderIcon(int paramInt)
  {
    GMTrace.i(13092134060032L, 97544);
    GMTrace.o(13092134060032L, 97544);
    return this;
  }
  
  public final ContextMenu setHeaderIcon(Drawable paramDrawable)
  {
    GMTrace.i(13092268277760L, 97545);
    GMTrace.o(13092268277760L, 97545);
    return this;
  }
  
  public final ContextMenu setHeaderTitle(int paramInt)
  {
    GMTrace.i(13091865624576L, 97542);
    if (paramInt > 0)
    {
      ContextMenu localContextMenu = setHeaderTitle(aa.getContext().getString(paramInt));
      GMTrace.o(13091865624576L, 97542);
      return localContextMenu;
    }
    GMTrace.o(13091865624576L, 97542);
    return this;
  }
  
  public final ContextMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    GMTrace.i(13091999842304L, 97543);
    if (paramCharSequence == null)
    {
      GMTrace.o(13091999842304L, 97543);
      return this;
    }
    this.Qz = paramCharSequence;
    GMTrace.o(13091999842304L, 97543);
    return this;
  }
  
  public final ContextMenu setHeaderView(View paramView)
  {
    GMTrace.i(13092402495488L, 97546);
    GMTrace.o(13092402495488L, 97546);
    return this;
  }
  
  public final void setQwertyMode(boolean paramBoolean)
  {
    GMTrace.i(13091731406848L, 97541);
    GMTrace.o(13091731406848L, 97541);
  }
  
  public final int size()
  {
    GMTrace.i(13090926100480L, 97535);
    if (this.vjl == null)
    {
      GMTrace.o(13090926100480L, 97535);
      return 0;
    }
    int i = this.vjl.size();
    GMTrace.o(13090926100480L, 97535);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */