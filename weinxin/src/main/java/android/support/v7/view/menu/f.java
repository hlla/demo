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
import android.support.v4.view.d;
import android.support.v4.view.m;
import android.support.v7.a.a.b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class f
  implements a
{
  private static final int[] Qo = { 1, 4, 5, 3, 2, 0 };
  private final Resources Cu;
  Drawable QA;
  View QB;
  private boolean QC = false;
  private boolean QD = false;
  boolean QE = false;
  private boolean QF = false;
  private ArrayList<h> QG = new ArrayList();
  public CopyOnWriteArrayList<WeakReference<l>> QH = new CopyOnWriteArrayList();
  h QI;
  public boolean QJ;
  private boolean Qp;
  private boolean Qq;
  public a Qr;
  private ArrayList<h> Qs;
  private boolean Qt;
  public ArrayList<h> Qu;
  private ArrayList<h> Qv;
  private boolean Qw;
  public int Qx = 0;
  private ContextMenu.ContextMenuInfo Qy;
  CharSequence Qz;
  ArrayList<h> eh;
  public final Context mContext;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.Cu = paramContext.getResources();
    this.eh = new ArrayList();
    this.Qs = new ArrayList();
    this.Qt = true;
    this.Qu = new ArrayList();
    this.Qv = new ArrayList();
    this.Qw = true;
    if ((this.Cu.getConfiguration().keyboard != 1) && (this.Cu.getBoolean(a.b.IO))) {}
    for (;;)
    {
      this.Qq = bool;
      return;
      bool = false;
    }
  }
  
  private h a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.QG;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty())
    {
      paramKeyEvent = null;
      return paramKeyEvent;
    }
    int k = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int m = localArrayList.size();
    if (m == 1) {
      return (h)localArrayList.get(0);
    }
    boolean bool = dt();
    int i = 0;
    label84:
    if (i < m)
    {
      h localh = (h)localArrayList.get(i);
      if (bool) {}
      for (int j = localh.getAlphabeticShortcut();; j = localh.getNumericShortcut())
      {
        if (j == localKeyData.meta[0])
        {
          paramKeyEvent = localh;
          if ((k & 0x2) == 0) {
            break;
          }
        }
        if (j == localKeyData.meta[2])
        {
          paramKeyEvent = localh;
          if ((k & 0x2) != 0) {
            break;
          }
        }
        if ((bool) && (j == 8))
        {
          paramKeyEvent = localh;
          if (paramInt == 67) {
            break;
          }
        }
        i += 1;
        break label84;
      }
    }
    return null;
  }
  
  private void a(List<h> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = dt();
    int k = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int m = this.eh.size();
    int i = 0;
    label49:
    h localh;
    if (i < m)
    {
      localh = (h)this.eh.get(i);
      if (localh.hasSubMenu()) {
        ((f)localh.getSubMenu()).a(paramList, paramInt, paramKeyEvent);
      }
      if (!bool) {
        break label184;
      }
    }
    label184:
    for (int j = localh.getAlphabeticShortcut();; j = localh.getNumericShortcut())
    {
      if (((k & 0x5) == 0) && (j != 0) && ((j == localKeyData.meta[0]) || (j == localKeyData.meta[2]) || ((bool) && (j == 8) && (paramInt == 67))) && (localh.isEnabled())) {
        paramList.add(localh);
      }
      i += 1;
      break label49;
      break;
    }
  }
  
  private static int b(ArrayList<h> paramArrayList, int paramInt)
  {
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      if (((h)paramArrayList.get(i)).PA <= paramInt) {
        return i + 1;
      }
      i -= 1;
    }
    return 0;
  }
  
  private void m(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.eh.size())) {}
    do
    {
      return;
      this.eh.remove(paramInt);
    } while (!paramBoolean);
    h(true);
  }
  
  public final void D(boolean paramBoolean)
  {
    if (this.QF) {
      return;
    }
    this.QF = true;
    Iterator localIterator = this.QH.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      l locall = (l)localWeakReference.get();
      if (locall == null) {
        this.QH.remove(localWeakReference);
      } else {
        locall.a(this, paramBoolean);
      }
    }
    this.QF = false;
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i = (0xFFFF0000 & paramInt3) >> 16;
    if ((i < 0) || (i >= Qo.length)) {
      throw new IllegalArgumentException("order does not contain a valid category.");
    }
    i = Qo[i] << 16 | 0xFFFF & paramInt3;
    paramCharSequence = new h(this, paramInt1, paramInt2, paramInt3, i, paramCharSequence, this.Qx);
    if (this.Qy != null) {
      paramCharSequence.QU = this.Qy;
    }
    this.eh.add(b(this.eh, i), paramCharSequence);
    h(true);
    return paramCharSequence;
  }
  
  public void a(a parama)
  {
    this.Qr = parama;
  }
  
  public final void a(l paraml)
  {
    a(paraml, this.mContext);
  }
  
  public final void a(l paraml, Context paramContext)
  {
    this.QH.add(new WeakReference(paraml));
    paraml.a(paramContext, this);
    this.Qw = true;
  }
  
  final void a(CharSequence paramCharSequence, Drawable paramDrawable, View paramView)
  {
    if (paramView != null)
    {
      this.QB = paramView;
      this.Qz = null;
      this.QA = null;
    }
    for (;;)
    {
      h(false);
      return;
      if (paramCharSequence != null) {
        this.Qz = paramCharSequence;
      }
      if (paramDrawable != null) {
        this.QA = paramDrawable;
      }
      this.QB = null;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, l paraml, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    paramMenuItem = (h)paramMenuItem;
    if ((paramMenuItem == null) || (!paramMenuItem.isEnabled())) {
      bool1 = false;
    }
    boolean bool3;
    Object localObject;
    label95:
    do
    {
      return bool1;
      bool3 = paramMenuItem.dD();
      localObject = paramMenuItem.QR;
      if ((localObject != null) && (((d)localObject).hasSubMenu())) {}
      for (int i = 1;; i = 0)
      {
        if (!paramMenuItem.dK()) {
          break label95;
        }
        bool2 = paramMenuItem.expandActionView() | bool3;
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        D(true);
        return bool2;
      }
      if ((!paramMenuItem.hasSubMenu()) && (i == 0)) {
        break label283;
      }
      D(false);
      if (!paramMenuItem.hasSubMenu()) {
        paramMenuItem.b(new p(this.mContext, this, paramMenuItem));
      }
      paramMenuItem = (p)paramMenuItem.getSubMenu();
      if (i != 0) {
        ((d)localObject).onPrepareSubMenu(paramMenuItem);
      }
      if (!this.QH.isEmpty()) {
        break;
      }
      bool2 = bool3 | bool1;
      bool1 = bool2;
    } while (bool2);
    D(true);
    return bool2;
    bool1 = bool2;
    if (paraml != null) {
      bool1 = paraml.a(paramMenuItem);
    }
    paraml = this.QH.iterator();
    label214:
    while (paraml.hasNext())
    {
      localObject = (WeakReference)paraml.next();
      l locall = (l)((WeakReference)localObject).get();
      if (locall == null)
      {
        this.QH.remove(localObject);
      }
      else
      {
        if (bool1) {
          break label297;
        }
        bool1 = locall.a(paramMenuItem);
      }
    }
    label283:
    label297:
    for (;;)
    {
      break label214;
      break;
      if ((paramInt & 0x1) == 0) {
        D(true);
      }
      return bool3;
    }
  }
  
  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, this.Cu.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, this.Cu.getString(paramInt4));
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
    PackageManager localPackageManager = this.mContext.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i;
    label52:
    ResolveInfo localResolveInfo;
    if (localList != null)
    {
      i = localList.size();
      if ((paramInt4 & 0x1) == 0) {
        removeGroup(paramInt1);
      }
      paramInt4 = 0;
      if (paramInt4 >= i) {
        break label214;
      }
      localResolveInfo = (ResolveInfo)localList.get(paramInt4);
      if (localResolveInfo.specificIndex >= 0) {
        break label201;
      }
    }
    label201:
    for (paramComponentName = paramIntent;; paramComponentName = paramArrayOfIntent[localResolveInfo.specificIndex])
    {
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0)) {
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = paramComponentName;
      }
      paramInt4 += 1;
      break label52;
      i = 0;
      break;
    }
    label214:
    return i;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.Cu.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.Cu.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (h)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    p localp = new p(this.mContext, this, paramCharSequence);
    paramCharSequence.b(localp);
    return localp;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public final void b(l paraml)
  {
    Iterator localIterator = this.QH.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      l locall = (l)localWeakReference.get();
      if ((locall == null) || (locall == paraml)) {
        this.QH.remove(localWeakReference);
      }
    }
  }
  
  boolean b(f paramf, MenuItem paramMenuItem)
  {
    return (this.Qr != null) && (this.Qr.a(paramf, paramMenuItem));
  }
  
  public void clear()
  {
    if (this.QI != null) {
      h(this.QI);
    }
    this.eh.clear();
    h(true);
  }
  
  public void clearHeader()
  {
    this.QA = null;
    this.Qz = null;
    this.QB = null;
    h(false);
  }
  
  public void close()
  {
    D(true);
  }
  
  public final void dA()
  {
    ArrayList localArrayList = dz();
    if (!this.Qw) {
      return;
    }
    Object localObject = this.QH.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      l locall = (l)localWeakReference.get();
      if (locall == null) {
        this.QH.remove(localWeakReference);
      } else {
        i = locall.B() | i;
      }
    }
    if (i != 0)
    {
      this.Qu.clear();
      this.Qv.clear();
      int k = localArrayList.size();
      i = 0;
      if (i < k)
      {
        localObject = (h)localArrayList.get(i);
        if (((h)localObject).dH()) {
          this.Qu.add(localObject);
        }
        for (;;)
        {
          int j;
          i += 1;
          break;
          this.Qv.add(localObject);
        }
      }
    }
    else
    {
      this.Qu.clear();
      this.Qv.clear();
      this.Qv.addAll(dz());
    }
    this.Qw = false;
  }
  
  public final ArrayList<h> dB()
  {
    dA();
    return this.Qv;
  }
  
  public f dC()
  {
    return this;
  }
  
  public final void dispatchSaveInstanceState(Bundle paramBundle)
  {
    if (this.QH.isEmpty()) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator = this.QH.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (WeakReference)localIterator.next();
      l locall = (l)((WeakReference)localObject).get();
      if (locall == null)
      {
        this.QH.remove(localObject);
      }
      else
      {
        int i = locall.getId();
        if (i > 0)
        {
          localObject = locall.onSaveInstanceState();
          if (localObject != null) {
            localSparseArray.put(i, localObject);
          }
        }
      }
    }
    paramBundle.putSparseParcelableArray("android:menu:presenters", localSparseArray);
  }
  
  protected String ds()
  {
    return "android:menu:actionviewstates";
  }
  
  boolean dt()
  {
    return this.Qp;
  }
  
  public boolean du()
  {
    return this.Qq;
  }
  
  public final void dv()
  {
    if (!this.QC)
    {
      this.QC = true;
      this.QD = false;
    }
  }
  
  public final void dw()
  {
    this.QC = false;
    if (this.QD)
    {
      this.QD = false;
      h(true);
    }
  }
  
  final void dx()
  {
    this.Qt = true;
    h(true);
  }
  
  final void dy()
  {
    this.Qw = true;
    h(true);
  }
  
  public final ArrayList<h> dz()
  {
    if (!this.Qt) {
      return this.Qs;
    }
    this.Qs.clear();
    int j = this.eh.size();
    int i = 0;
    while (i < j)
    {
      h localh = (h)this.eh.get(i);
      if (localh.isVisible()) {
        this.Qs.add(localh);
      }
      i += 1;
    }
    this.Qt = false;
    this.Qw = true;
    return this.Qs;
  }
  
  public final void e(Bundle paramBundle)
  {
    int j = size();
    int i = 0;
    Object localObject3;
    for (Object localObject1 = null; i < j; localObject1 = localObject3)
    {
      MenuItem localMenuItem = getItem(i);
      View localView = m.a(localMenuItem);
      localObject3 = localObject1;
      if (localView != null)
      {
        localObject3 = localObject1;
        if (localView.getId() != -1)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new SparseArray();
          }
          localView.saveHierarchyState((SparseArray)localObject2);
          localObject3 = localObject2;
          if (m.d(localMenuItem))
          {
            paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
            localObject3 = localObject2;
          }
        }
      }
      if (localMenuItem.hasSubMenu()) {
        ((p)localMenuItem.getSubMenu()).e(paramBundle);
      }
      i += 1;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(ds(), (SparseArray)localObject1);
    }
  }
  
  public final void f(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      int i;
      do
      {
        return;
        SparseArray localSparseArray = paramBundle.getSparseParcelableArray(ds());
        int j = size();
        i = 0;
        while (i < j)
        {
          MenuItem localMenuItem = getItem(i);
          View localView = m.a(localMenuItem);
          if ((localView != null) && (localView.getId() != -1)) {
            localView.restoreHierarchyState(localSparseArray);
          }
          if (localMenuItem.hasSubMenu()) {
            ((p)localMenuItem.getSubMenu()).f(paramBundle);
          }
          i += 1;
        }
        i = paramBundle.getInt("android:menu:expandedactionview");
      } while (i <= 0);
      paramBundle = findItem(i);
    } while (paramBundle == null);
    m.b(paramBundle);
  }
  
  public MenuItem findItem(int paramInt)
  {
    int j = size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (h)this.eh.get(i);
      if (((h)localObject).getItemId() == paramInt) {}
      MenuItem localMenuItem;
      do
      {
        return (MenuItem)localObject;
        if (!((h)localObject).hasSubMenu()) {
          break;
        }
        localMenuItem = ((h)localObject).getSubMenu().findItem(paramInt);
        localObject = localMenuItem;
      } while (localMenuItem != null);
      i += 1;
    }
    return null;
  }
  
  protected final f g(CharSequence paramCharSequence)
  {
    a(paramCharSequence, null, null);
    return this;
  }
  
  public boolean g(h paramh)
  {
    boolean bool2 = false;
    if (this.QH.isEmpty()) {
      return bool2;
    }
    dv();
    Iterator localIterator = this.QH.iterator();
    boolean bool1 = false;
    for (;;)
    {
      label29:
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        l locall = (l)localWeakReference.get();
        if (locall == null)
        {
          this.QH.remove(localWeakReference);
        }
        else
        {
          bool1 = locall.b(paramh);
          if (!bool1) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      dw();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.QI = paramh;
      return bool1;
      break label29;
    }
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.eh.get(paramInt);
  }
  
  public void h(boolean paramBoolean)
  {
    if (!this.QC)
    {
      if (paramBoolean)
      {
        this.Qt = true;
        this.Qw = true;
      }
      if (!this.QH.isEmpty())
      {
        dv();
        Iterator localIterator = this.QH.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          l locall = (l)localWeakReference.get();
          if (locall == null) {
            this.QH.remove(localWeakReference);
          } else {
            locall.f(paramBoolean);
          }
        }
        dw();
      }
      return;
    }
    this.QD = true;
  }
  
  public boolean h(h paramh)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!this.QH.isEmpty())
    {
      if (this.QI != paramh) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    dv();
    Iterator localIterator = this.QH.iterator();
    bool1 = false;
    for (;;)
    {
      label41:
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        l locall = (l)localWeakReference.get();
        if (locall == null)
        {
          this.QH.remove(localWeakReference);
        }
        else
        {
          bool1 = locall.c(paramh);
          if (!bool1) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      dw();
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.QI = null;
      return bool1;
      break label41;
    }
  }
  
  public boolean hasVisibleItems()
  {
    if (this.QJ) {
      return true;
    }
    int j = size();
    int i = 0;
    while (i < j)
    {
      if (((h)this.eh.get(i)).isVisible()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return a(paramInt, paramKeyEvent) != null;
  }
  
  protected final f k(Drawable paramDrawable)
  {
    a(null, paramDrawable, null);
    return this;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return a(findItem(paramInt1), null, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = a(paramInt1, paramKeyEvent);
    boolean bool = false;
    if (paramKeyEvent != null) {
      bool = a(paramKeyEvent, null, paramInt2);
    }
    if ((paramInt2 & 0x2) != 0) {
      D(true);
    }
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    int j = size();
    int i = 0;
    if (i < j) {
      if (((h)this.eh.get(i)).getGroupId() != paramInt) {}
    }
    for (;;)
    {
      label30:
      if (i >= 0)
      {
        int k = this.eh.size();
        j = 0;
        for (;;)
        {
          if ((j < k - i) && (((h)this.eh.get(i)).getGroupId() == paramInt))
          {
            m(i, false);
            j += 1;
            continue;
            i += 1;
            break;
            i = -1;
            break label30;
          }
        }
        h(true);
      }
    }
  }
  
  public void removeItem(int paramInt)
  {
    int j = size();
    int i = 0;
    if (i < j) {
      if (((h)this.eh.get(i)).getItemId() != paramInt) {}
    }
    for (;;)
    {
      m(i, true);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = this.eh.size();
    int i = 0;
    while (i < j)
    {
      h localh = (h)this.eh.get(i);
      if (localh.getGroupId() == paramInt)
      {
        localh.E(paramBoolean2);
        localh.setCheckable(paramBoolean1);
      }
      i += 1;
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int j = this.eh.size();
    int i = 0;
    while (i < j)
    {
      h localh = (h)this.eh.get(i);
      if (localh.getGroupId() == paramInt) {
        localh.setEnabled(paramBoolean);
      }
      i += 1;
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int k = this.eh.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      h localh = (h)this.eh.get(j);
      if ((localh.getGroupId() != paramInt) || (!localh.G(paramBoolean))) {
        break label74;
      }
      i = 1;
    }
    label74:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0) {
        h(true);
      }
      return;
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.Qp = paramBoolean;
    h(false);
  }
  
  public int size()
  {
    return this.eh.size();
  }
  
  public static abstract interface a
  {
    public abstract boolean a(f paramf, MenuItem paramMenuItem);
    
    public abstract void b(f paramf);
  }
  
  public static abstract interface b
  {
    public abstract boolean f(h paramh);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/view/menu/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */