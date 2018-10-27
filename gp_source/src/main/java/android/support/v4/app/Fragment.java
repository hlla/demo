package android.support.v4.app;

import android.a.b.ah;
import android.a.b.ai;
import android.a.b.j;
import android.a.b.t;
import android.a.b.y;
import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.g.f;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Fragment
  implements ai, android.a.b.n, ComponentCallbacks, View.OnCreateContextMenuListener
{
  private static final android.support.v4.g.v b = new android.support.v4.g.v();
  public static final Object e = new Object();
  public boolean A;
  public LayoutInflater B;
  public android.a.b.o C = new android.a.b.o(this);
  public boolean D = true;
  public Fragment E;
  public boolean F;
  public float G;
  public boolean H;
  public boolean I;
  public boolean J;
  public boolean K;
  public Bundle L;
  public Boolean M;
  public SparseArray N;
  public int O = 0;
  public String P;
  public Fragment Q;
  public int R = -1;
  public int S;
  public boolean T = true;
  public View U;
  public android.a.b.n V;
  public y W = new y();
  public android.a.b.o X;
  public ah Y;
  public String Z;
  private m a;
  public boolean f;
  public Bundle g;
  public int h;
  public boolean i;
  public z j;
  public aq k;
  public ViewGroup l;
  public int m;
  public boolean n;
  public boolean o;
  public int p;
  public z q;
  public boolean r;
  public boolean s;
  public boolean t;
  public boolean u;
  public u v;
  public boolean w;
  public int x = -1;
  public View y;
  public boolean z;
  
  private final void U()
  {
    if (this.v == null) {
      throw new IllegalStateException("Fragment has not been attached yet.");
    }
    this.j = new z();
    this.j.a(this.v, new k(this), this);
  }
  
  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Class localClass2 = (Class)b.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        b.put(paramString, localClass1);
      }
      paramContext = (Fragment)localClass1.getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.f(paramBundle);
      }
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an");
      paramBundle.append(" empty constructor that is public");
      throw new Fragment.InstantiationException(paramBundle.toString(), paramContext);
    }
    catch (InstantiationException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an");
      paramBundle.append(" empty constructor that is public");
      throw new Fragment.InstantiationException(paramBundle.toString(), paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": make sure class name exists, is public, and has an");
      paramBundle.append(" empty constructor that is public");
      throw new Fragment.InstantiationException(paramBundle.toString(), paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": could not find Fragment constructor");
      throw new Fragment.InstantiationException(paramBundle.toString(), paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Unable to instantiate fragment ");
      paramBundle.append(paramString);
      paramBundle.append(": calling Fragment constructor caused an exception");
      throw new Fragment.InstantiationException(paramBundle.toString(), paramContext);
    }
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    try
    {
      Class localClass2 = (Class)b.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        b.put(paramString, localClass1);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass1);
      return bool;
    }
    catch (ClassNotFoundException paramContext) {}
    return false;
  }
  
  public static void aW_() {}
  
  public static Animation aZ_()
  {
    return null;
  }
  
  public static Animator ba_()
  {
    return null;
  }
  
  public static void t() {}
  
  public static void z() {}
  
  public final Object A()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.c;
    }
    return null;
  }
  
  public final Object B()
  {
    m localm = this.a;
    if (localm != null)
    {
      if (localm.l != e) {
        return this.a.l;
      }
      return A();
    }
    return null;
  }
  
  public final Object C()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.e;
    }
    return null;
  }
  
  public final Object D()
  {
    m localm = this.a;
    if (localm != null)
    {
      if (localm.k != e) {
        return this.a.k;
      }
      return C();
    }
    return null;
  }
  
  public final Object E()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.m;
    }
    return null;
  }
  
  public final Object F()
  {
    m localm = this.a;
    if (localm != null)
    {
      if (localm.n != e) {
        return this.a.n;
      }
      return E();
    }
    return null;
  }
  
  public final m G()
  {
    if (this.a == null) {
      this.a = new m();
    }
    return this.a;
  }
  
  final int H()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.h;
    }
    return 0;
  }
  
  final int I()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.i;
    }
    return 0;
  }
  
  final int J()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.j;
    }
    return 0;
  }
  
  final cp K()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.d;
    }
    return null;
  }
  
  final cp L()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.f;
    }
    return null;
  }
  
  final View M()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.a;
    }
    return null;
  }
  
  final Animator N()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.b;
    }
    return null;
  }
  
  final int O()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.o;
    }
    return 0;
  }
  
  final boolean P()
  {
    if (this.a != null) {}
    return false;
  }
  
  public final j P_()
  {
    return this.C;
  }
  
  final boolean Q()
  {
    m localm = this.a;
    if (localm != null) {
      return localm.g;
    }
    return false;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  public final String a(int paramInt, Object... paramVarArgs)
  {
    return k().getString(paramInt, paramVarArgs);
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    if ((this.a != null) || (paramInt1 != 0) || (paramInt2 != 0))
    {
      G();
      m localm = this.a;
      localm.i = paramInt1;
      localm.j = paramInt2;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  final void a(int paramInt, Fragment paramFragment)
  {
    this.x = paramInt;
    if (paramFragment != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFragment.Z);
      localStringBuilder.append(":");
      localStringBuilder.append(this.x);
      this.Z = localStringBuilder.toString();
      return;
    }
    paramFragment = new StringBuilder();
    paramFragment.append("android:fragment:");
    paramFragment.append(this.x);
    this.Z = paramFragment.toString();
  }
  
  final void a(Animator paramAnimator)
  {
    G().b = paramAnimator;
  }
  
  @Deprecated
  public void a(Activity paramActivity)
  {
    this.i = true;
  }
  
  public void a(Context paramContext)
  {
    this.i = true;
    paramContext = this.v;
    if (paramContext != null) {}
    for (paramContext = paramContext.a;; paramContext = null)
    {
      if (paramContext != null)
      {
        this.i = false;
        a(paramContext);
      }
      return;
    }
  }
  
  public final void a(Intent paramIntent)
  {
    u localu = this.v;
    if (localu == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("Fragment ");
      paramIntent.append(this);
      paramIntent.append(" not attached to Activity");
      throw new IllegalStateException(paramIntent.toString());
    }
    localu.a(this, paramIntent, -1);
  }
  
  public void a(Bundle paramBundle)
  {
    this.i = true;
    h(paramBundle);
    paramBundle = this.j;
    if ((paramBundle != null) && (paramBundle.d <= 0)) {
      paramBundle.p();
    }
  }
  
  public final void a(Fragment paramFragment, int paramInt)
  {
    z localz = this.q;
    if (paramFragment != null) {}
    for (Object localObject = paramFragment.q;; localObject = null)
    {
      if (localz == null) {
        localObject = paramFragment;
      }
      for (;;)
      {
        if (localObject != null)
        {
          if (localObject == this)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Setting ");
            ((StringBuilder)localObject).append(paramFragment);
            ((StringBuilder)localObject).append(" as the target of ");
            ((StringBuilder)localObject).append(this);
            ((StringBuilder)localObject).append(" would create a target cycle");
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
          localObject = ((Fragment)localObject).Q;
        }
        else
        {
          this.Q = paramFragment;
          this.S = paramInt;
          return;
          if (localObject == null)
          {
            localObject = paramFragment;
          }
          else
          {
            if (localz != localObject) {
              break;
            }
            localObject = paramFragment;
          }
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(paramFragment);
    ((StringBuilder)localObject).append(" must share the same FragmentManager to be set as a target fragment");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public final void a(cp paramcp)
  {
    G().d = paramcp;
  }
  
  public void a(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public void a(View paramView, Bundle paramBundle) {}
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.p));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.m));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.P);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.O);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.x);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.Z);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.h);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.f);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.H);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.r);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.w);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.t);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.o);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.D);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.s);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.J);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.K);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.T);
    if (this.q != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.q);
    }
    if (this.v != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.v);
    }
    if (this.E != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.E);
    }
    if (this.g != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.g);
    }
    if (this.L != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.L);
    }
    if (this.N != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.N);
    }
    if (this.Q != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.Q);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.S);
    }
    if (H() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(H());
    }
    if (this.l != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.l);
    }
    if (this.U != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.U);
    }
    if (this.y != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.U);
    }
    if (M() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(M());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(O());
    }
    if (by_() != null) {
      bt.a(this).a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.j != null)
    {
      paramPrintWriter.print(paramString);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Child ");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append(":");
      paramPrintWriter.println(((StringBuilder)localObject).toString());
      localObject = this.j;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("  ");
      ((v)localObject).a(localStringBuilder.toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public void a(int[] paramArrayOfInt) {}
  
  public final void aX_()
  {
    if (this.s != true)
    {
      this.s = true;
      if ((s_()) && (!this.t)) {
        this.v.d();
      }
    }
  }
  
  public final LayoutInflater aY_()
  {
    LayoutInflater localLayoutInflater2 = this.B;
    LayoutInflater localLayoutInflater1 = localLayoutInflater2;
    if (localLayoutInflater2 == null) {
      localLayoutInflater1 = g(null);
    }
    return localLayoutInflater1;
  }
  
  public LayoutInflater a_(Bundle paramBundle)
  {
    return r();
  }
  
  public final void a_(Object paramObject)
  {
    G().m = paramObject;
  }
  
  public final void a_(String[] paramArrayOfString)
  {
    u localu = this.v;
    if (localu == null)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("Fragment ");
      paramArrayOfString.append(this);
      paramArrayOfString.append(" not attached to Activity");
      throw new IllegalStateException(paramArrayOfString.toString());
    }
    localu.a(this, paramArrayOfString);
  }
  
  public boolean a_(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void au_()
  {
    this.i = true;
  }
  
  public void av_()
  {
    this.i = true;
  }
  
  final void b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    z localz = this.j;
    if (localz != null) {
      localz.o();
    }
    this.F = true;
    this.V = new l(this);
    this.X = null;
    this.U = a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.U != null)
    {
      this.V.P_();
      this.W.a(this.V);
      return;
    }
    if (this.X != null) {
      throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }
    this.V = null;
  }
  
  final boolean bw_()
  {
    return this.h > 0;
  }
  
  public final boolean bx_()
  {
    z localz = this.q;
    if (localz != null) {
      return localz.i();
    }
    return false;
  }
  
  public final Context by_()
  {
    u localu = this.v;
    if (localu != null) {
      return localu.b;
    }
    return null;
  }
  
  public final String c(int paramInt)
  {
    return k().getString(paramInt);
  }
  
  public final void c(boolean paramBoolean)
  {
    if (this.D != paramBoolean)
    {
      this.D = paramBoolean;
      if ((this.s) && (s_()) && (!this.t)) {
        this.v.d();
      }
    }
  }
  
  final void d(int paramInt)
  {
    if ((this.a != null) || (paramInt != 0)) {
      G().h = paramInt;
    }
  }
  
  public void d(Bundle paramBundle)
  {
    this.i = true;
  }
  
  final void d(boolean paramBoolean)
  {
    G().g = paramBoolean;
  }
  
  final void d_(View paramView)
  {
    G().a = paramView;
  }
  
  final void e(int paramInt)
  {
    G().o = paramInt;
  }
  
  public void e(Bundle paramBundle) {}
  
  public final ah e_()
  {
    if (by_() == null) {
      throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }
    if (this.Y == null) {
      this.Y = new ah();
    }
    return this.Y;
  }
  
  public void f()
  {
    this.i = true;
    if (this.U != null) {
      this.X.a(android.a.b.k.c);
    }
  }
  
  public final void f(Bundle paramBundle)
  {
    if ((this.x >= 0) && (bx_())) {
      throw new IllegalStateException("Fragment already active and state has been saved");
    }
    this.g = paramBundle;
  }
  
  final LayoutInflater g(Bundle paramBundle)
  {
    this.B = a_(paramBundle);
    return this.B;
  }
  
  final void h(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        if (this.j == null) {
          U();
        }
        this.j.a(paramBundle, this.k);
        this.k = null;
        this.j.p();
      }
    }
  }
  
  public void i(Bundle paramBundle)
  {
    this.i = true;
    if (this.U != null) {
      this.X.a(android.a.b.k.b);
    }
  }
  
  public final o j()
  {
    u localu = this.v;
    if (localu != null) {
      return (o)localu.a;
    }
    return null;
  }
  
  public final Resources k()
  {
    Object localObject = by_();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" not attached to a context.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return ((Context)localObject).getResources();
  }
  
  public final v l()
  {
    int i1;
    if (this.j == null)
    {
      U();
      i1 = this.O;
      if (i1 < 4) {
        break label33;
      }
      this.j.s();
    }
    for (;;)
    {
      return this.j;
      label33:
      if (i1 >= 3) {
        this.j.r();
      } else if (i1 >= 2) {
        this.j.q();
      } else if (i1 > 0) {
        this.j.p();
      }
    }
  }
  
  public void o_()
  {
    this.i = true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.i = true;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    j().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onLowMemory()
  {
    this.i = true;
  }
  
  @Deprecated
  public final LayoutInflater r()
  {
    Object localObject = this.v;
    if (localObject == null) {
      throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }
    localObject = ((u)localObject).c();
    l();
    android.support.v4.view.n.a((LayoutInflater)localObject, this.j);
    return (LayoutInflater)localObject;
  }
  
  public final void s()
  {
    this.i = true;
    Object localObject = this.v;
    if (localObject != null) {}
    for (localObject = ((u)localObject).a;; localObject = null)
    {
      if (localObject != null)
      {
        this.i = false;
        this.i = true;
      }
      return;
    }
  }
  
  public final boolean s_()
  {
    return (this.v != null) && (this.f);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    u localu = this.v;
    if (localu == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("Fragment ");
      paramIntent.append(this);
      paramIntent.append(" not attached to Activity");
      throw new IllegalStateException(paramIntent.toString());
    }
    localu.a(this, paramIntent, paramInt);
  }
  
  public final boolean t_()
  {
    return this.O >= 4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    f.a(this, localStringBuilder);
    if (this.x >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.x);
    }
    if (this.p != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.p));
    }
    if (this.P != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.P);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void w()
  {
    this.i = true;
  }
  
  public void x()
  {
    this.i = true;
  }
  
  public void y()
  {
    this.i = true;
    ah localah = this.Y;
    if ((localah != null) && (!this.v.c.i)) {
      localah.a();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/Fragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */