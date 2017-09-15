package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.e.c;
import android.support.v4.view.h;
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

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener
{
  private static final android.support.v4.e.i<String, Class<?>> oP = new android.support.v4.e.i();
  static final Object oQ = new Object();
  int mIndex = -1;
  int mState = 0;
  String mTag;
  public View mView;
  View oR;
  int oS;
  Bundle oT;
  SparseArray<Parcelable> oU;
  String oV;
  public Bundle oW;
  Fragment oX;
  int oY = -1;
  int oZ;
  boolean pA;
  Object pB = null;
  Object pC = oQ;
  Object pD = null;
  Object pE = oQ;
  Object pF = null;
  Object pG = oQ;
  Boolean pH;
  Boolean pI;
  ak pJ = null;
  ak pK = null;
  boolean pa;
  public boolean pb;
  boolean pc;
  boolean pd;
  boolean pe;
  int pf;
  m pg;
  k ph;
  m pi;
  public Fragment pj;
  int pk;
  int pl;
  public boolean pm;
  boolean pn;
  boolean po;
  boolean pp;
  boolean pq;
  boolean pr = true;
  boolean ps;
  int pt;
  ViewGroup pu;
  View pv;
  boolean pw;
  boolean px = true;
  t py;
  boolean pz;
  
  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Class localClass2 = (Class)oP.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        oP.put(paramString, localClass1);
      }
      paramContext = (Fragment)localClass1.newInstance();
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.oW = paramBundle;
      }
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new a("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new a("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new a("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
  }
  
  public static void aJ() {}
  
  public static Animation aL()
  {
    return null;
  }
  
  public static Fragment b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }
  
  static boolean c(Context paramContext, String paramString)
  {
    try
    {
      Class localClass2 = (Class)oP.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        oP.put(paramString, localClass1);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass1);
      return bool;
    }
    catch (ClassNotFoundException paramContext) {}
    return false;
  }
  
  public static void onDestroyOptionsMenu() {}
  
  final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.pi != null) {
      this.pi.qw = false;
    }
    return onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public final FragmentActivity aG()
  {
    if (this.ph == null) {
      return null;
    }
    return (FragmentActivity)this.ph.qb;
  }
  
  public final void aH()
  {
    if (this.pq != true)
    {
      this.pq = true;
      if ((isAdded()) && (!this.pm)) {
        this.ph.aT();
      }
    }
  }
  
  public final s aI()
  {
    if (this.py != null) {
      return this.py;
    }
    if (this.ph == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.pA = true;
    this.py = this.ph.a(this.oV, this.pz, true);
    return this.py;
  }
  
  public final void aK()
  {
    this.ps = true;
    if (this.ph == null) {}
    for (Activity localActivity = null;; localActivity = this.ph.qb)
    {
      if (localActivity != null)
      {
        this.ps = false;
        this.ps = true;
      }
      return;
    }
  }
  
  public void aM() {}
  
  final void aN()
  {
    this.pi = new m();
    this.pi.a(this.ph, new i()
    {
      public final View onFindViewById(int paramAnonymousInt)
      {
        if (Fragment.this.mView == null) {
          throw new IllegalStateException("Fragment does not have a view");
        }
        return Fragment.this.mView.findViewById(paramAnonymousInt);
      }
      
      public final boolean onHasView()
      {
        return Fragment.this.mView != null;
      }
    }, this);
  }
  
  final void aO()
  {
    if (this.pi != null) {
      this.pi.G(2);
    }
    this.mState = 2;
    if (this.pz)
    {
      this.pz = false;
      if (!this.pA)
      {
        this.pA = true;
        this.py = this.ph.a(this.oV, this.pz, false);
      }
      if (this.py != null)
      {
        if (!this.ph.qe) {
          break label89;
        }
        this.py.bf();
      }
    }
    return;
    label89:
    this.py.be();
  }
  
  public LayoutInflater c(Bundle paramBundle)
  {
    paramBundle = this.ph.onGetLayoutInflater();
    if (this.pi == null)
    {
      aN();
      if (this.mState < 5) {
        break label44;
      }
      this.pi.dispatchResume();
    }
    for (;;)
    {
      h.a(paramBundle, this.pi);
      return paramBundle;
      label44:
      if (this.mState >= 4) {
        this.pi.dispatchStart();
      } else if (this.mState >= 2) {
        this.pi.dispatchActivityCreated();
      } else if (this.mState > 0) {
        this.pi.dispatchCreate();
      }
    }
  }
  
  final void c(int paramInt, Fragment paramFragment)
  {
    this.mIndex = paramInt;
    if (paramFragment != null)
    {
      this.oV = (paramFragment.oV + ":" + this.mIndex);
      return;
    }
    this.oV = ("android:fragment:" + this.mIndex);
  }
  
  final void d(Bundle paramBundle)
  {
    onSaveInstanceState(paramBundle);
    if (this.pi != null)
    {
      Parcelable localParcelable = this.pi.saveAllState();
      if (localParcelable != null) {
        paramBundle.putParcelable("android:support:fragments", localParcelable);
      }
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.pk));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.pl));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.mState);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.mIndex);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.oV);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.pf);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.pa);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.pb);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.pc);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.pd);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.pm);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.pn);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.pr);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.pq);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.po);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.pp);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.px);
    if (this.pg != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.pg);
    }
    if (this.ph != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.ph);
    }
    if (this.pj != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.pj);
    }
    if (this.oW != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.oW);
    }
    if (this.oT != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.oT);
    }
    if (this.oU != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.oU);
    }
    if (this.oX != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.oX);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.oZ);
    }
    if (this.pt != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(this.pt);
    }
    if (this.pu != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.pu);
    }
    if (this.mView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.mView);
    }
    if (this.pv != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.mView);
    }
    if (this.oR != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(this.oR);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(this.oS);
    }
    if (this.py != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      this.py.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.pi != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.pi + ":");
      this.pi.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public Context getContext()
  {
    if (this.ph == null) {
      return null;
    }
    return this.ph.mContext;
  }
  
  public final Resources getResources()
  {
    if (this.ph == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    return this.ph.mContext.getResources();
  }
  
  public final String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    return getResources().getString(paramInt, paramVarArgs);
  }
  
  public boolean getUserVisibleHint()
  {
    return this.px;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final boolean isAdded()
  {
    return (this.ph != null) && (this.pa);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.ps = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @Deprecated
  public void onAttach(Activity paramActivity)
  {
    this.ps = true;
  }
  
  public void onAttach(Context paramContext)
  {
    this.ps = true;
    if (this.ph == null) {}
    for (paramContext = null;; paramContext = this.ph.qb)
    {
      if (paramContext != null)
      {
        this.ps = false;
        onAttach(paramContext);
      }
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.ps = true;
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.ps = true;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    aG().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  public void onDestroy()
  {
    this.ps = true;
    if (!this.pA)
    {
      this.pA = true;
      this.py = this.ph.a(this.oV, this.pz, false);
    }
    if (this.py != null) {
      this.py.bi();
    }
  }
  
  public void onDestroyView()
  {
    this.ps = true;
  }
  
  public void onDetach()
  {
    this.ps = true;
  }
  
  public void onHiddenChanged(boolean paramBoolean) {}
  
  public void onLowMemory()
  {
    this.ps = true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onPause()
  {
    this.ps = true;
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu) {}
  
  public void onResume()
  {
    this.ps = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.ps = true;
    if (!this.pz)
    {
      this.pz = true;
      if (!this.pA)
      {
        this.pA = true;
        this.py = this.ph.a(this.oV, this.pz, false);
      }
      if (this.py != null) {
        this.py.bd();
      }
    }
  }
  
  public void onStop()
  {
    this.ps = true;
  }
  
  public void setArguments(Bundle paramBundle)
  {
    if (this.mIndex >= 0) {
      throw new IllegalStateException("Fragment already active");
    }
    this.oW = paramBundle;
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    if (this.pr != paramBoolean)
    {
      this.pr = paramBoolean;
      if ((this.pq) && (isAdded()) && (!this.pm)) {
        this.ph.aT();
      }
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if ((!this.px) && (paramBoolean) && (this.mState < 4)) {
      this.pg.f(this);
    }
    this.px = paramBoolean;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.pw = paramBoolean;
      return;
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (this.ph == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.ph.b(this, paramIntent, -1, null);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.ph == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.ph.b(this, paramIntent, paramInt, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    c.a(this, localStringBuilder);
    if (this.mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mIndex);
    }
    if (this.pk != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.pk));
    }
    if (this.mTag != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mTag);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    final Bundle pM;
    
    SavedState(Bundle paramBundle)
    {
      this.pM = paramBundle;
    }
    
    SavedState(Parcel paramParcel)
    {
      this.pM = paramParcel.readBundle();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeBundle(this.pM);
    }
  }
  
  public static final class a
    extends RuntimeException
  {
    public a(String paramString, Exception paramException)
    {
      super(paramException);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/Fragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */