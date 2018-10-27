package android.support.v4.app;

import android.a.b.ah;
import android.a.b.ai;
import android.a.b.j;
import android.a.b.l;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.g.w;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

public class o
  extends cq
  implements ai, c, e
{
  public final t a = new t(new q(this));
  public final Handler b = new p(this);
  public boolean c;
  public boolean d;
  private boolean e;
  private int f;
  private w g;
  private boolean h;
  private boolean i = true;
  private ah j;
  
  private final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.a.c.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  private static boolean a(v paramv, l paraml)
  {
    paramv = paramv.g().iterator();
    boolean bool1 = false;
    while (paramv.hasNext())
    {
      Object localObject = (Fragment)paramv.next();
      if (localObject != null)
      {
        boolean bool2 = bool1;
        if (((Fragment)localObject).C.a().a(l.e))
        {
          ((Fragment)localObject).C.a(paraml);
          bool2 = true;
        }
        localObject = ((Fragment)localObject).j;
        bool1 = bool2;
        if (localObject != null) {
          bool1 = a((v)localObject, paraml) | bool2;
        }
      }
    }
    return (byte)bool1;
  }
  
  static void b(int paramInt)
  {
    if ((0xFFFF0000 & paramInt) != 0) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
  }
  
  private final void k()
  {
    while (a(O_(), l.a)) {}
  }
  
  public void I_()
  {
    this.a.a.c.s();
  }
  
  public final v O_()
  {
    return this.a.a.c;
  }
  
  final int a(Fragment paramFragment)
  {
    if (this.g.b() < 65534)
    {
      while (this.g.d(this.f) >= 0) {
        this.f = ((this.f + 1) % 65534);
      }
      int k = this.f;
      this.g.b(k, paramFragment.Z);
      this.f = ((this.f + 1) % 65534);
      return k;
    }
    throw new IllegalStateException("Too many pending Fragment activity results.");
  }
  
  public Object af_()
  {
    return null;
  }
  
  public final void c_(int paramInt)
  {
    if ((!this.c) && (paramInt != -1)) {
      b(paramInt);
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("  ");
    localObject = ((StringBuilder)localObject).toString();
    paramPrintWriter.print((String)localObject);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.e);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.h);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.i);
    if (getApplication() != null) {
      bt.a(this).a((String)localObject, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.a.a.c.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final ah e_()
  {
    if (getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.j == null) {
      this.j = new ah();
    }
    return this.j;
  }
  
  @Deprecated
  public final bt g()
  {
    return bt.a(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.a();
    int k = paramInt1 >> 16;
    if (k != 0)
    {
      k -= 1;
      String str = (String)this.g.a(k, null);
      Object localObject = this.g;
      k = android.support.v4.g.e.a(((w)localObject).c, ((w)localObject).d, k);
      if ((k >= 0) && (localObject.e[k] != w.a))
      {
        ((w)localObject).e[k] = w.a;
        ((w)localObject).b = true;
      }
      if (str == null)
      {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      }
      localObject = this.a.a(str);
      if (localObject == null)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("Activity result no fragment exists for who: ");
        paramIntent.append(str);
        Log.w("FragmentActivity", paramIntent.toString());
        return;
      }
      ((Fragment)localObject).a((char)paramInt1, paramInt2, paramIntent);
      return;
    }
    a.a();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    z localz = this.a.a.c;
    boolean bool = localz.i();
    if (((!bool) || (Build.VERSION.SDK_INT > 25)) && ((bool) || (!localz.d()))) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.a();
    this.a.a.c.a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = this.a.a;
    ((u)localObject).c.a((u)localObject, (s)localObject, null);
    super.onCreate(paramBundle);
    localObject = (r)getLastNonConfigurationInstance();
    if (localObject != null) {
      this.j = ((r)localObject).c;
    }
    Parcelable localParcelable;
    t localt;
    if (paramBundle != null)
    {
      localParcelable = paramBundle.getParcelable("android:support:fragments");
      localt = this.a;
      if (localObject == null) {
        break label226;
      }
    }
    label173:
    label226:
    for (localObject = ((r)localObject).b;; localObject = null)
    {
      localt.a.c.a(localParcelable, (aq)localObject);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        this.f = paramBundle.getInt("android:support:next_request_index");
        localObject = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if (localObject != null) {
          break label173;
        }
        Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
      }
      for (;;)
      {
        if (this.g == null)
        {
          this.g = new w();
          this.f = 0;
        }
        this.a.a.c.p();
        return;
        if (paramBundle == null) {
          break;
        }
        int k = localObject.length;
        if (k != paramBundle.length) {
          break;
        }
        this.g = new w(k);
        k = 0;
        while (k < localObject.length)
        {
          this.g.b(localObject[k], paramBundle[k]);
          k += 1;
        }
      }
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool = super.onCreatePanelMenu(paramInt, paramMenu);
      t localt = this.a;
      MenuInflater localMenuInflater = getMenuInflater();
      return bool | localt.a.c.a(paramMenu, localMenuInflater);
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView2 = a(paramView, paramString, paramContext, paramAttributeSet);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    return localView1;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    View localView2 = a(null, paramString, paramContext, paramAttributeSet);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return localView1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.j != null) && (!isChangingConfigurations())) {
      this.j.a();
    }
    this.a.a.c.u();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.a.a.c.v();
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
    case 6: 
      return this.a.a.c.b(paramMenuItem);
    }
    return this.a.a.c.a(paramMenuItem);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    this.a.a.c.b(paramBoolean);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.a.a();
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
      this.a.a.c.b(paramMenu);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.h = false;
    if (this.b.hasMessages(2))
    {
      this.b.removeMessages(2);
      I_();
    }
    this.a.a.c.c(3);
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.a.a.c.c(paramBoolean);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    this.b.removeMessages(2);
    I_();
    this.a.b();
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null)) {
      return super.onPreparePanel(0, paramView, paramMenu) | this.a.a.c.a(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a();
    paramInt = (char)(paramInt >> 16);
    if (paramInt != 0)
    {
      paramInt -= 1;
      paramArrayOfString = (String)this.g.a(paramInt, null);
      localObject = this.g;
      paramInt = android.support.v4.g.e.a(((w)localObject).c, ((w)localObject).d, paramInt);
      if ((paramInt >= 0) && (localObject.e[paramInt] != w.a))
      {
        ((w)localObject).e[paramInt] = w.a;
        ((w)localObject).b = true;
      }
      if (paramArrayOfString == null) {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
      }
    }
    else
    {
      return;
    }
    Object localObject = this.a.a(paramArrayOfString);
    if (localObject == null)
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("Activity result no fragment exists for who: ");
      paramArrayOfInt.append(paramArrayOfString);
      Log.w("FragmentActivity", paramArrayOfInt.toString());
      return;
    }
    ((Fragment)localObject).a(paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    this.b.sendEmptyMessage(2);
    this.h = true;
    this.a.b();
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    Object localObject1 = af_();
    Object localObject2 = this.a.a.c;
    z.a(((z)localObject2).h);
    localObject2 = ((z)localObject2).h;
    if ((localObject2 != null) || (this.j != null) || (localObject1 != null))
    {
      r localr = new r();
      localr.a = localObject1;
      localr.c = this.j;
      localr.b = ((aq)localObject2);
      return localr;
    }
    return null;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    k();
    Object localObject = this.a.a.c.m();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (this.g.b() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", this.f);
      localObject = new int[this.g.b()];
      String[] arrayOfString = new String[this.g.b()];
      int k = 0;
      while (k < this.g.b())
      {
        localObject[k] = this.g.b(k);
        arrayOfString[k] = ((String)this.g.c(k));
        k += 1;
      }
      paramBundle.putIntArray("android:support:request_indicies", (int[])localObject);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.i = false;
    if (!this.e)
    {
      this.e = true;
      this.a.a.c.q();
    }
    this.a.a();
    this.a.b();
    this.a.a.c.r();
  }
  
  public void onStateNotSaved()
  {
    this.a.a();
  }
  
  public void onStop()
  {
    super.onStop();
    this.i = true;
    k();
    this.a.a.c.t();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((!this.d) && (paramInt != -1)) {
      b(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if ((!this.d) && (paramInt != -1)) {
      b(paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != -1) {
      b(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    if (paramInt1 != -1) {
      b(paramInt1);
    }
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  @Deprecated
  public void u_()
  {
    invalidateOptionsMenu();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */