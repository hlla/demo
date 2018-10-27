package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.c.a.a;
import android.support.v4.view.ag;
import android.util.SparseArray;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class p
  implements a
{
  private static final int[] z = { 1, 4, 5, 3, 2, 0 };
  public ArrayList a;
  public q b;
  public final Context c;
  public int d = 0;
  public t e;
  public Drawable f;
  public CharSequence g;
  public View h;
  public ArrayList i;
  public boolean j = false;
  public boolean k;
  private boolean l = false;
  private boolean m;
  private boolean n = false;
  private boolean o;
  private boolean p = false;
  private ArrayList q;
  private CopyOnWriteArrayList r = new CopyOnWriteArrayList();
  private boolean s = false;
  private boolean t;
  private final Resources u;
  private boolean v;
  private boolean w = false;
  private ArrayList x = new ArrayList();
  private ArrayList y;
  
  public p(Context paramContext)
  {
    this.c = paramContext;
    this.u = paramContext.getResources();
    this.i = new ArrayList();
    this.y = new ArrayList();
    this.o = true;
    this.a = new ArrayList();
    this.q = new ArrayList();
    this.m = true;
    if (this.u.getConfiguration().keyboard != 1) {
      if (!ag.c(ViewConfiguration.get(this.c), this.c)) {}
    }
    for (;;)
    {
      this.v = bool;
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private final t a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.x;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    if (!localArrayList.isEmpty())
    {
      int i3 = paramKeyEvent.getMetaState();
      KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
      paramKeyEvent.getKeyData(localKeyData);
      int i4 = localArrayList.size();
      if (i4 == 1)
      {
        paramKeyEvent = (t)localArrayList.get(0);
        return paramKeyEvent;
      }
      boolean bool = c();
      int i1 = 0;
      if (i1 < i4)
      {
        t localt = (t)localArrayList.get(i1);
        if (bool) {}
        for (int i2 = localt.getAlphabeticShortcut();; i2 = localt.getNumericShortcut())
        {
          if (i2 != localKeyData.meta[0]) {}
          for (;;)
          {
            if (i2 == localKeyData.meta[2])
            {
              paramKeyEvent = localt;
              if ((i3 & 0x2) != 0) {
                break;
              }
            }
            if (!bool) {}
            while ((i2 != 8) || (paramInt != 67))
            {
              i1 += 1;
              break;
            }
            return localt;
            paramKeyEvent = localt;
            if ((i3 & 0x2) == 0) {
              break;
            }
          }
        }
      }
      return null;
    }
    return null;
  }
  
  private final MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i1 = (0xFFFF0000 & paramInt3) >> 16;
    if ((i1 < 0) || (i1 >= z.length)) {
      throw new IllegalArgumentException("order does not contain a valid category.");
    }
    i1 = z[i1] << 16 | (char)paramInt3;
    paramCharSequence = new t(this, paramInt1, paramInt2, paramInt3, i1, paramCharSequence, this.d);
    ArrayList localArrayList = this.i;
    paramInt1 = localArrayList.size() - 1;
    while (paramInt1 >= 0) {
      if (((t)localArrayList.get(paramInt1)).c > i1) {
        paramInt1 -= 1;
      } else {
        paramInt1 += 1;
      }
    }
    for (;;)
    {
      localArrayList.add(paramInt1, paramCharSequence);
      b(true);
      return paramCharSequence;
      paramInt1 = 0;
    }
  }
  
  private final void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < this.i.size()))
    {
      this.i.remove(paramInt);
      if (paramBoolean) {
        b(true);
      }
    }
  }
  
  private final void a(List paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = c();
    int i4 = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if (paramKeyEvent.getKeyData(localKeyData)) {}
    label199:
    while (paramInt == 67)
    {
      int i5 = this.i.size();
      int i1 = 0;
      if (i1 >= i5) {
        break;
      }
      t localt = (t)this.i.get(i1);
      if (localt.hasSubMenu()) {
        ((p)localt.getSubMenu()).a(paramList, paramInt, paramKeyEvent);
      }
      if (!bool) {}
      for (int i2 = localt.getNumericShortcut();; i2 = localt.getAlphabeticShortcut())
      {
        if (!bool) {}
        for (int i3 = localt.getNumericModifiers();; i3 = localt.getAlphabeticModifiers())
        {
          if ((i4 & 0x1100F) != (i3 & 0x1100F)) {}
          for (;;)
          {
            i1 += 1;
            break;
            if (i2 != 0)
            {
              if ((i2 == localKeyData.meta[0]) || (i2 == localKeyData.meta[2])) {}
              for (;;)
              {
                if (!localt.isEnabled()) {
                  break label199;
                }
                paramList.add(localt);
                break;
                if ((!bool) || (i2 != 8) || (paramInt != 67)) {
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected String a()
  {
    return "android:menu:actionviewstates";
  }
  
  final void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = this.u;
    if (paramView != null)
    {
      this.h = paramView;
      this.g = null;
      this.f = null;
      b(false);
      return;
    }
    if (paramInt1 > 0) {
      this.g = localResources.getText(paramInt1);
    }
    for (;;)
    {
      if (paramInt2 > 0) {
        this.f = android.support.v4.content.d.a(this.c, paramInt2);
      }
      for (;;)
      {
        this.h = null;
        break;
        if (paramDrawable != null) {
          this.f = paramDrawable;
        }
      }
      if (paramCharSequence != null) {
        this.g = paramCharSequence;
      }
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    int i2 = size();
    int i1 = 0;
    Object localObject1 = null;
    if (i1 < i2)
    {
      MenuItem localMenuItem = getItem(i1);
      View localView = localMenuItem.getActionView();
      if (localView != null) {
        if (localView.getId() != -1) {}
      }
      for (;;)
      {
        if (!localMenuItem.hasSubMenu()) {}
        for (;;)
        {
          i1 += 1;
          break;
          ((ap)localMenuItem.getSubMenu()).a(paramBundle);
        }
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new SparseArray();
        }
        localView.saveHierarchyState((SparseArray)localObject2);
        if (localMenuItem.isActionViewExpanded())
        {
          paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject2;
        }
      }
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(a(), (SparseArray)localObject1);
    }
  }
  
  public final void a(af paramaf)
  {
    a(paramaf, this.c);
  }
  
  public final void a(af paramaf, Context paramContext)
  {
    this.r.add(new WeakReference(paramaf));
    paramaf.a(paramContext, this);
    this.m = true;
  }
  
  public void a(q paramq)
  {
    this.b = paramq;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!this.n)
    {
      this.n = true;
      Iterator localIterator = this.r.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        af localaf = (af)localWeakReference.get();
        if (localaf == null) {
          this.r.remove(localWeakReference);
        } else {
          localaf.a(this, paramBoolean);
        }
      }
      this.n = false;
    }
  }
  
  boolean a(p paramp, MenuItem paramMenuItem)
  {
    q localq = this.b;
    return (localq != null) && (localq.a(paramp, paramMenuItem));
  }
  
  public boolean a(t paramt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!this.r.isEmpty())
    {
      e();
      Iterator localIterator = this.r.iterator();
      bool1 = false;
      if (!localIterator.hasNext()) {
        break label113;
      }
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      af localaf = (af)localWeakReference.get();
      if (localaf == null) {
        this.r.remove(localWeakReference);
      }
      do
      {
        break;
        bool2 = localaf.b(paramt);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    }
    label113:
    for (;;)
    {
      f();
      bool2 = bool1;
      if (bool1)
      {
        this.e = paramt;
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, af paramaf, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    paramMenuItem = (t)paramMenuItem;
    if ((paramMenuItem != null) && (paramMenuItem.isEnabled()))
    {
      boolean bool3 = paramMenuItem.b();
      Object localObject = paramMenuItem.a;
      int i1;
      if (localObject != null) {
        if (((android.support.v4.view.d)localObject).e()) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (paramMenuItem.h())
        {
          bool1 = paramMenuItem.expandActionView() | bool3;
          if (!bool1) {
            return bool1;
          }
          a(true);
          return bool1;
        }
        if (paramMenuItem.hasSubMenu()) {}
        while (i1 != 0)
        {
          if ((paramInt & 0x4) != 0) {}
          for (;;)
          {
            if (!paramMenuItem.hasSubMenu()) {
              paramMenuItem.a(new ap(this.c, this, paramMenuItem));
            }
            paramMenuItem = (ap)paramMenuItem.getSubMenu();
            if (i1 != 0) {
              ((android.support.v4.view.d)localObject).a(paramMenuItem);
            }
            if (this.r.isEmpty()) {}
            for (;;)
            {
              bool2 = bool3 | bool1;
              bool1 = bool2;
              if (bool2) {
                break;
              }
              a(true);
              return bool2;
              bool1 = bool2;
              if (paramaf != null) {
                bool1 = paramaf.a(paramMenuItem);
              }
              paramaf = this.r.iterator();
              while (paramaf.hasNext())
              {
                localObject = (WeakReference)paramaf.next();
                af localaf = (af)((WeakReference)localObject).get();
                if (localaf == null) {
                  this.r.remove(localObject);
                } else if (!bool1) {
                  bool1 = localaf.a(paramMenuItem);
                }
              }
            }
            a(false);
          }
        }
        if ((paramInt & 0x1) != 0) {
          return bool3;
        }
        a(true);
        return bool3;
        i1 = 0;
        continue;
        i1 = 0;
      }
    }
    return false;
  }
  
  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, this.u.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, this.u.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.c.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    if (localList != null) {}
    for (int i1 = localList.size();; i1 = 0)
    {
      if ((paramInt4 & 0x1) == 0)
      {
        removeGroup(paramInt1);
        paramInt4 = 0;
      }
      while (paramInt4 < i1)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(paramInt4);
        if (localResolveInfo.specificIndex >= 0) {}
        for (paramComponentName = paramArrayOfIntent[localResolveInfo.specificIndex];; paramComponentName = paramIntent)
        {
          paramComponentName = new Intent(paramComponentName);
          paramComponentName.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
          paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
          if (paramArrayOfMenuItem == null) {}
          for (;;)
          {
            paramInt4 += 1;
            break;
            if (localResolveInfo.specificIndex >= 0) {
              paramArrayOfMenuItem[localResolveInfo.specificIndex] = paramComponentName;
            }
          }
        }
        paramInt4 = 0;
      }
    }
    return i1;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.u.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.u.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (t)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    ap localap = new ap(this.c, this, paramCharSequence);
    paramCharSequence.a(localap);
    return localap;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public final void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      SparseArray localSparseArray = paramBundle.getSparseParcelableArray(a());
      int i2 = size();
      int i1 = 0;
      if (i1 < i2)
      {
        MenuItem localMenuItem = getItem(i1);
        View localView = localMenuItem.getActionView();
        if ((localView != null) && (localView.getId() != -1)) {
          localView.restoreHierarchyState(localSparseArray);
        }
        if (!localMenuItem.hasSubMenu()) {}
        for (;;)
        {
          i1 += 1;
          break;
          ((ap)localMenuItem.getSubMenu()).b(paramBundle);
        }
      }
      i1 = paramBundle.getInt("android:menu:expandedactionview");
      if (i1 > 0)
      {
        paramBundle = findItem(i1);
        if (paramBundle != null) {
          paramBundle.expandActionView();
        }
      }
    }
  }
  
  public final void b(af paramaf)
  {
    Iterator localIterator = this.r.iterator();
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      af localaf = (af)localWeakReference.get();
      if (localaf == null) {}
      for (;;)
      {
        this.r.remove(localWeakReference);
        break;
        if (localaf != paramaf) {
          break;
        }
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.s)
    {
      this.p = true;
      if (paramBoolean) {
        this.w = true;
      }
    }
    for (;;)
    {
      return;
      if (!paramBoolean) {}
      while (!this.r.isEmpty())
      {
        e();
        Iterator localIterator = this.r.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          af localaf = (af)localWeakReference.get();
          if (localaf == null) {
            this.r.remove(localWeakReference);
          } else {
            localaf.a(paramBoolean);
          }
        }
        f();
        return;
        this.o = true;
        this.m = true;
      }
    }
  }
  
  public boolean b()
  {
    return this.l;
  }
  
  public boolean b(t paramt)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!this.r.isEmpty())
    {
      bool2 = bool1;
      if (this.e == paramt)
      {
        e();
        Iterator localIterator = this.r.iterator();
        bool1 = false;
        if (!localIterator.hasNext()) {
          break label125;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        af localaf = (af)localWeakReference.get();
        if (localaf == null) {
          this.r.remove(localWeakReference);
        }
        do
        {
          break;
          bool2 = localaf.c(paramt);
          bool1 = bool2;
        } while (!bool2);
        bool1 = bool2;
      }
    }
    label125:
    for (;;)
    {
      f();
      bool2 = bool1;
      if (bool1)
      {
        this.e = null;
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  boolean c()
  {
    return this.t;
  }
  
  public void clear()
  {
    t localt = this.e;
    if (localt != null) {
      b(localt);
    }
    this.i.clear();
    b(true);
  }
  
  public void clearHeader()
  {
    this.f = null;
    this.g = null;
    this.h = null;
    b(false);
  }
  
  public void close()
  {
    a(true);
  }
  
  public boolean d()
  {
    return this.v;
  }
  
  public final void e()
  {
    if (!this.s)
    {
      this.s = true;
      this.p = false;
      this.w = false;
    }
  }
  
  public final void f()
  {
    this.s = false;
    if (this.p)
    {
      this.p = false;
      b(this.w);
    }
  }
  
  public MenuItem findItem(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    if (i1 < i2)
    {
      t localt = (t)this.i.get(i1);
      Object localObject = localt;
      if (localt.getItemId() != paramInt)
      {
        if (!localt.hasSubMenu()) {}
        do
        {
          i1 += 1;
          break;
          localObject = localt.getSubMenu().findItem(paramInt);
        } while (localObject == null);
      }
      return (MenuItem)localObject;
    }
    return null;
  }
  
  final void g()
  {
    this.o = true;
    b(true);
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.i.get(paramInt);
  }
  
  final void h()
  {
    this.m = true;
    b(true);
  }
  
  public boolean hasVisibleItems()
  {
    if (!this.k)
    {
      int i2 = size();
      int i1 = 0;
      while (i1 < i2) {
        if (!((t)this.i.get(i1)).isVisible()) {
          i1 += 1;
        } else {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public final ArrayList i()
  {
    if (!this.o) {
      return this.y;
    }
    this.y.clear();
    int i2 = this.i.size();
    int i1 = 0;
    if (i1 < i2)
    {
      t localt = (t)this.i.get(i1);
      if (!localt.isVisible()) {}
      for (;;)
      {
        i1 += 1;
        break;
        this.y.add(localt);
      }
    }
    this.o = false;
    this.m = true;
    return this.y;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return a(paramInt, paramKeyEvent) != null;
  }
  
  public final void j()
  {
    ArrayList localArrayList = i();
    Object localObject;
    if (this.m)
    {
      localObject = this.r.iterator();
      i1 = 0;
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        af localaf = (af)localWeakReference.get();
        if (localaf == null) {
          this.r.remove(localWeakReference);
        } else {
          i1 = localaf.a() | i1;
        }
      }
      if (i1 == 0)
      {
        this.a.clear();
        this.q.clear();
        this.q.addAll(i());
        this.m = false;
      }
    }
    else
    {
      return;
    }
    this.a.clear();
    this.q.clear();
    int i3 = localArrayList.size();
    int i1 = 0;
    label143:
    if (i1 < i3)
    {
      localObject = (t)localArrayList.get(i1);
      if (!((t)localObject).f()) {
        break label183;
      }
      this.a.add(localObject);
    }
    for (;;)
    {
      int i2;
      i1 += 1;
      break label143;
      break;
      label183:
      this.q.add(localObject);
    }
  }
  
  public final ArrayList k()
  {
    j();
    return this.q;
  }
  
  public p l()
  {
    return this;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return a(findItem(paramInt1), null, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = a(paramInt1, paramKeyEvent);
    if (paramKeyEvent != null) {}
    for (boolean bool = a(paramKeyEvent, null, paramInt2);; bool = false)
    {
      if ((paramInt2 & 0x2) != 0) {
        a(true);
      }
      return bool;
    }
  }
  
  public void removeGroup(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((t)this.i.get(i1)).getGroupId() == paramInt) {
        break label99;
      }
      i1 += 1;
    }
    i1 = -1;
    label99:
    for (;;)
    {
      if (i1 >= 0)
      {
        int i3 = this.i.size();
        i2 = 0;
        while ((i2 < i3 - i1) && (((t)this.i.get(i1)).getGroupId() == paramInt))
        {
          a(i1, false);
          i2 += 1;
        }
        b(true);
      }
      return;
    }
  }
  
  public void removeItem(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label44;
      }
      if (((t)this.i.get(i1)).getItemId() == paramInt) {
        break;
      }
      i1 += 1;
    }
    for (;;)
    {
      a(i1, true);
      return;
      label44:
      i1 = -1;
    }
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = this.i.size();
    int i1 = 0;
    if (i1 < i2)
    {
      t localt = (t)this.i.get(i1);
      if (localt.getGroupId() != paramInt) {}
      for (;;)
      {
        i1 += 1;
        break;
        localt.a(paramBoolean2);
        localt.setCheckable(paramBoolean1);
      }
    }
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int i2 = this.i.size();
    int i1 = 0;
    if (i1 < i2)
    {
      t localt = (t)this.i.get(i1);
      if (localt.getGroupId() != paramInt) {}
      for (;;)
      {
        i1 += 1;
        break;
        localt.setEnabled(paramBoolean);
      }
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int i3 = this.i.size();
    int i2 = 0;
    int i1 = 0;
    if (i2 < i3)
    {
      t localt = (t)this.i.get(i2);
      if (localt.getGroupId() == paramInt) {
        if (localt.b(paramBoolean)) {
          i1 = 1;
        }
      }
      for (;;)
      {
        i2 += 1;
        break;
      }
    }
    if (i1 != 0) {
      b(true);
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.t = paramBoolean;
    b(false);
  }
  
  public int size()
  {
    return this.i.size();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */