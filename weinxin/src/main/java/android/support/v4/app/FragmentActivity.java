package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.e.i;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentActivity
  extends g
  implements a.a, b.a
{
  final Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        super.handleMessage(paramAnonymousMessage);
      case 1: 
        do
        {
          return;
        } while (!FragmentActivity.this.pQ);
        FragmentActivity.this.n(false);
        return;
      }
      FragmentActivity.this.aP();
      FragmentActivity.this.pN.execPendingActions();
    }
  };
  final j pN = new j(new a());
  boolean pO;
  boolean pP;
  boolean pQ;
  boolean pR;
  boolean pS;
  boolean pT;
  int pU;
  boolean pV;
  android.support.v4.e.j<String> pW;
  boolean pp;
  
  private void a(String paramString, PrintWriter paramPrintWriter, View paramView)
  {
    paramPrintWriter.print(paramString);
    if (paramView == null) {
      paramPrintWriter.println("null");
    }
    for (;;)
    {
      return;
      paramPrintWriter.println(x(paramView));
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        if (j > 0)
        {
          paramString = paramString + "  ";
          int i = 0;
          while (i < j)
          {
            a(paramString, paramPrintWriter, paramView.getChildAt(i));
            i += 1;
          }
        }
      }
    }
  }
  
  private int d(Fragment paramFragment)
  {
    if (this.pW.size() >= 65534) {
      throw new IllegalStateException("Too many pending Fragment activity results.");
    }
    while (this.pW.indexOfKey(this.pU) >= 0) {
      this.pU = ((this.pU + 1) % 65534);
    }
    int i = this.pU;
    this.pW.put(i, paramFragment.oV);
    this.pU = ((this.pU + 1) % 65534);
    return i;
  }
  
  private static String x(View paramView)
  {
    char c3 = 'F';
    char c2 = '.';
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramView.getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
    localStringBuilder.append(' ');
    char c1;
    label118:
    label135:
    label152:
    label169:
    label186:
    label203:
    label220:
    label244:
    label261:
    int i;
    Object localObject;
    switch (paramView.getVisibility())
    {
    default: 
      localStringBuilder.append('.');
      if (paramView.isFocusable())
      {
        c1 = 'F';
        localStringBuilder.append(c1);
        if (!paramView.isEnabled()) {
          break label562;
        }
        c1 = 'E';
        localStringBuilder.append(c1);
        if (!paramView.willNotDraw()) {
          break label568;
        }
        c1 = '.';
        localStringBuilder.append(c1);
        if (!paramView.isHorizontalScrollBarEnabled()) {
          break label574;
        }
        c1 = 'H';
        localStringBuilder.append(c1);
        if (!paramView.isVerticalScrollBarEnabled()) {
          break label580;
        }
        c1 = 'V';
        localStringBuilder.append(c1);
        if (!paramView.isClickable()) {
          break label586;
        }
        c1 = 'C';
        localStringBuilder.append(c1);
        if (!paramView.isLongClickable()) {
          break label592;
        }
        c1 = 'L';
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
        if (!paramView.isFocused()) {
          break label598;
        }
        c1 = c3;
        localStringBuilder.append(c1);
        if (!paramView.isSelected()) {
          break label604;
        }
        c1 = 'S';
        localStringBuilder.append(c1);
        c1 = c2;
        if (paramView.isPressed()) {
          c1 = 'P';
        }
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
        localStringBuilder.append(paramView.getLeft());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getTop());
        localStringBuilder.append('-');
        localStringBuilder.append(paramView.getRight());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getBottom());
        i = paramView.getId();
        if (i != -1)
        {
          localStringBuilder.append(" #");
          localStringBuilder.append(Integer.toHexString(i));
          localObject = paramView.getResources();
          if ((i != 0) && (localObject != null)) {
            switch (0xFF000000 & i)
            {
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        paramView = ((Resources)localObject).getResourcePackageName(i);
        String str = ((Resources)localObject).getResourceTypeName(i);
        localObject = ((Resources)localObject).getResourceEntryName(i);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramView);
        localStringBuilder.append(":");
        localStringBuilder.append(str);
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
      }
      catch (Resources.NotFoundException paramView)
      {
        label562:
        label568:
        label574:
        label580:
        label586:
        label592:
        label598:
        label604:
        continue;
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append('V');
      break;
      localStringBuilder.append('I');
      break;
      localStringBuilder.append('G');
      break;
      c1 = '.';
      break label118;
      c1 = '.';
      break label135;
      c1 = 'D';
      break label152;
      c1 = '.';
      break label169;
      c1 = '.';
      break label186;
      c1 = '.';
      break label203;
      c1 = '.';
      break label220;
      c1 = '.';
      break label244;
      c1 = '.';
      break label261;
      paramView = "app";
      continue;
      paramView = "android";
    }
  }
  
  public final void C(int paramInt)
  {
    if ((!this.pT) && (paramInt != -1) && ((0xFFFF0000 & paramInt) != 0)) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
  }
  
  final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.pN.ph.pg.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    a(paramFragment, paramIntent, paramInt, null);
  }
  
  public final void a(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    this.pV = true;
    if (paramInt == -1) {}
    try
    {
      a.a(this, paramIntent, -1, paramBundle);
      return;
    }
    finally
    {
      this.pV = false;
    }
    if ((0xFFFF0000 & paramInt) != 0) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    a.a(this, paramIntent, (d(paramFragment) + 1 << 16) + (0xFFFF & paramInt), paramBundle);
    this.pV = false;
  }
  
  protected final void aP()
  {
    this.pN.ph.pg.dispatchResume();
  }
  
  public void aQ()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      invalidateOptionsMenu();
      return;
    }
    this.pS = true;
  }
  
  public final l aR()
  {
    return this.pN.ph.pg;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = Build.VERSION.SDK_INT;
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.pO);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.pP);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.pQ);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.pR);
    k localk = this.pN.ph;
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(localk.pz);
    if (localk.py != null)
    {
      paramPrintWriter.print(str);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(localk.py)));
      paramPrintWriter.println(":");
      localk.py.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.pN.ph.pg.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    a(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }
  
  final void n(boolean paramBoolean)
  {
    Object localObject;
    if (!this.pR)
    {
      this.pR = true;
      this.pp = paramBoolean;
      this.mHandler.removeMessages(1);
      localObject = this.pN;
      paramBoolean = this.pp;
      localObject = ((j)localObject).ph;
      ((k)localObject).qe = paramBoolean;
      if ((((k)localObject).py != null) && (((k)localObject).pz))
      {
        ((k)localObject).pz = false;
        if (!paramBoolean) {
          break label90;
        }
        ((k)localObject).py.bf();
      }
    }
    for (;;)
    {
      this.pN.ph.pg.G(2);
      return;
      label90:
      ((k)localObject).py.be();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.pN.noteStateNotSaved();
    int i = paramInt1 >> 16;
    if (i != 0)
    {
      i -= 1;
      Object localObject = (String)this.pW.get(i);
      this.pW.remove(i);
      if (localObject == null) {}
      do
      {
        return;
        localObject = this.pN.i((String)localObject);
      } while (localObject == null);
      ((Fragment)localObject).onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.pN.ph.pg.popBackStackImmediate()) {
      aE();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.pN.ph.pg.dispatchConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = this.pN;
    ((j)localObject1).ph.pg.a(((j)localObject1).ph, ((j)localObject1).ph, null);
    super.onCreate(paramBundle);
    localObject1 = (b)getLastNonConfigurationInstance();
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = this.pN;
      localObject3 = ((b)localObject1).qa;
      ((j)localObject2).ph.qd = ((i)localObject3);
    }
    if (paramBundle != null)
    {
      localObject2 = paramBundle.getParcelable("android:support:fragments");
      localObject3 = this.pN;
      if (localObject1 == null) {
        break label194;
      }
      localObject1 = ((b)localObject1).pZ;
      ((j)localObject3).ph.pg.restoreAllState((Parcelable)localObject2, (List)localObject1);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        this.pU = paramBundle.getInt("android:support:next_request_index");
        localObject1 = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if ((localObject1 != null) && (paramBundle != null) && (localObject1.length == paramBundle.length)) {
          break label199;
        }
      }
    }
    for (;;)
    {
      if (this.pW == null)
      {
        this.pW = new android.support.v4.e.j();
        this.pU = 0;
      }
      this.pN.ph.pg.dispatchCreate();
      return;
      label194:
      localObject1 = null;
      break;
      label199:
      this.pW = new android.support.v4.e.j(localObject1.length);
      int i = 0;
      while (i < localObject1.length)
      {
        this.pW.put(localObject1[i], paramBundle[i]);
        i += 1;
      }
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool1 = super.onCreatePanelMenu(paramInt, paramMenu);
      j localj = this.pN;
      MenuInflater localMenuInflater = getMenuInflater();
      boolean bool2 = localj.ph.pg.dispatchCreateOptionsMenu(paramMenu, localMenuInflater);
      if (Build.VERSION.SDK_INT >= 11) {
        return bool1 | bool2;
      }
      return true;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    n(false);
    this.pN.ph.pg.dispatchDestroy();
    k localk = this.pN.ph;
    if (localk.py != null) {
      localk.py.bi();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      onBackPressed();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.pN.ph.pg.dispatchLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return this.pN.ph.pg.dispatchOptionsItemSelected(paramMenuItem);
    }
    return this.pN.ph.pg.dispatchContextItemSelected(paramMenuItem);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.pN.noteStateNotSaved();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.pN.ph.pg.dispatchOptionsMenuClosed(paramMenu);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.pP = false;
    if (this.mHandler.hasMessages(2))
    {
      this.mHandler.removeMessages(2);
      aP();
    }
    this.pN.ph.pg.G(4);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    this.mHandler.removeMessages(2);
    aP();
    this.pN.execPendingActions();
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null))
    {
      if (this.pS)
      {
        this.pS = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
      return super.onPreparePanel(0, paramView, paramMenu) | this.pN.ph.pg.dispatchPrepareOptionsMenu(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramInt = paramInt >> 16 & 0xFFFF;
    if (paramInt != 0)
    {
      paramInt -= 1;
      paramArrayOfString = (String)this.pW.get(paramInt);
      this.pW.remove(paramInt);
      if (paramArrayOfString != null) {
        break label42;
      }
    }
    label42:
    while (this.pN.i(paramArrayOfString) == null) {
      return;
    }
    Fragment.aJ();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.pP = true;
    this.pN.execPendingActions();
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    if (this.pQ) {
      n(true);
    }
    m localm = this.pN.ph.pg;
    Object localObject2;
    if (localm.qj != null)
    {
      int i = 0;
      localObject1 = null;
      localObject2 = localObject1;
      if (i < localm.qj.size())
      {
        Fragment localFragment = (Fragment)localm.qj.get(i);
        localObject3 = localObject1;
        if (localFragment != null)
        {
          localObject3 = localObject1;
          if (localFragment.po)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
            localFragment.pp = true;
            if (localFragment.oX == null) {
              break label177;
            }
          }
        }
        label177:
        for (int j = localFragment.oX.mIndex;; j = -1)
        {
          localFragment.oY = j;
          localObject3 = localObject2;
          if (m.DEBUG)
          {
            new StringBuilder("retainNonConfig: keeping retained ").append(localFragment);
            localObject3 = localObject2;
          }
          i += 1;
          localObject1 = localObject3;
          break;
        }
      }
    }
    else
    {
      localObject2 = null;
    }
    Object localObject1 = this.pN.ph.aU();
    if ((localObject2 == null) && (localObject1 == null)) {
      return null;
    }
    Object localObject3 = new b();
    ((b)localObject3).pY = null;
    ((b)localObject3).pZ = ((List)localObject2);
    ((b)localObject3).qa = ((i)localObject1);
    return localObject3;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Object localObject = this.pN.ph.pg.saveAllState();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (this.pW.size() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", this.pU);
      localObject = new int[this.pW.size()];
      String[] arrayOfString = new String[this.pW.size()];
      int i = 0;
      while (i < this.pW.size())
      {
        localObject[i] = this.pW.keyAt(i);
        arrayOfString[i] = ((String)this.pW.valueAt(i));
        i += 1;
      }
      paramBundle.putIntArray("android:support:request_indicies", (int[])localObject);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.pQ = false;
    this.pR = false;
    this.mHandler.removeMessages(1);
    if (!this.pO)
    {
      this.pO = true;
      this.pN.ph.pg.dispatchActivityCreated();
    }
    this.pN.noteStateNotSaved();
    this.pN.execPendingActions();
    Object localObject = this.pN.ph;
    if (!((k)localObject).pz)
    {
      ((k)localObject).pz = true;
      if (((k)localObject).py == null) {
        break label183;
      }
      ((k)localObject).py.bd();
    }
    k localk;
    int k;
    for (;;)
    {
      ((k)localObject).pA = true;
      this.pN.ph.pg.dispatchStart();
      localk = this.pN.ph;
      if (localk.qd == null) {
        return;
      }
      k = localk.qd.size();
      localObject = new t[k];
      i = k - 1;
      while (i >= 0)
      {
        localObject[i] = ((t)localk.qd.valueAt(i));
        i -= 1;
      }
      label183:
      if (!((k)localObject).pA)
      {
        ((k)localObject).py = ((k)localObject).a("(root)", ((k)localObject).pz, false);
        if ((((k)localObject).py != null) && (!((k)localObject).py.ny)) {
          ((k)localObject).py.bd();
        }
      }
    }
    int i = 0;
    while (i < k)
    {
      localk = localObject[i];
      if (localk.pp)
      {
        if (t.DEBUG) {
          new StringBuilder("Finished Retaining in ").append(localk);
        }
        localk.pp = false;
        int j = localk.ru.size() - 1;
        while (j >= 0)
        {
          t.a locala = (t.a)localk.ru.valueAt(j);
          if (locala.pp)
          {
            if (t.DEBUG) {
              new StringBuilder("  Finished Retaining: ").append(locala);
            }
            locala.pp = false;
            if ((locala.ny != locala.rC) && (!locala.ny)) {
              locala.stop();
            }
          }
          if ((locala.ny) && (locala.rA) && (!locala.rD)) {
            locala.c(locala.rz, locala.mData);
          }
          j -= 1;
        }
      }
      localk.bh();
      i += 1;
    }
  }
  
  public void onStateNotSaved()
  {
    this.pN.noteStateNotSaved();
  }
  
  public void onStop()
  {
    super.onStop();
    this.pQ = true;
    this.mHandler.sendEmptyMessage(1);
    this.pN.ph.pg.dispatchStop();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((!this.pV) && (paramInt != -1) && ((0xFFFF0000 & paramInt) != 0)) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  final class a
    extends k<FragmentActivity>
  {
    public a()
    {
      super();
    }
    
    public final void a(String paramString, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      FragmentActivity.this.dump(paramString, null, paramPrintWriter, paramArrayOfString);
    }
    
    public final boolean aS()
    {
      return !FragmentActivity.this.isFinishing();
    }
    
    public final void aT()
    {
      FragmentActivity.this.aQ();
    }
    
    public final void b(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
    {
      FragmentActivity.this.a(paramFragment, paramIntent, paramInt, null);
    }
    
    public final View onFindViewById(int paramInt)
    {
      return FragmentActivity.this.findViewById(paramInt);
    }
    
    public final LayoutInflater onGetLayoutInflater()
    {
      return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
    }
    
    public final int onGetWindowAnimations()
    {
      Window localWindow = FragmentActivity.this.getWindow();
      if (localWindow == null) {
        return 0;
      }
      return localWindow.getAttributes().windowAnimations;
    }
    
    public final boolean onHasView()
    {
      Window localWindow = FragmentActivity.this.getWindow();
      return (localWindow != null) && (localWindow.peekDecorView() != null);
    }
    
    public final boolean onHasWindowAnimations()
    {
      return FragmentActivity.this.getWindow() != null;
    }
  }
  
  static final class b
  {
    Object pY;
    List<Fragment> pZ;
    i<String, s> qa;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/FragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */