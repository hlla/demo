package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class o
  extends u
{
  private final l qR;
  private p qS = null;
  private Fragment qT = null;
  private ArrayList<Fragment.SavedState> qW = new ArrayList();
  private ArrayList<Fragment> qX = new ArrayList();
  
  public o(l paraml)
  {
    this.qR = paraml;
  }
  
  public abstract Fragment I(int paramInt);
  
  public final void a(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.qW.clear();
      this.qX.clear();
      int i;
      if (paramClassLoader != null)
      {
        i = 0;
        while (i < paramClassLoader.length)
        {
          this.qW.add((Fragment.SavedState)paramClassLoader[i]);
          i += 1;
        }
      }
      paramClassLoader = paramParcelable.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        Object localObject = (String)paramClassLoader.next();
        if (((String)localObject).startsWith("f"))
        {
          i = Integer.parseInt(((String)localObject).substring(1));
          localObject = this.qR.c(paramParcelable, (String)localObject);
          if (localObject != null)
          {
            while (this.qX.size() <= i) {
              this.qX.add(null);
            }
            ((Fragment)localObject).setMenuVisibility(false);
            this.qX.set(i, localObject);
          }
        }
      }
    }
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (this.qS == null) {
      this.qS = this.qR.aV();
    }
    while (this.qW.size() <= paramInt) {
      this.qW.add(null);
    }
    ArrayList localArrayList = this.qW;
    if (((Fragment)paramObject).isAdded()) {}
    for (paramViewGroup = this.qR.e((Fragment)paramObject);; paramViewGroup = null)
    {
      localArrayList.set(paramInt, paramViewGroup);
      this.qX.set(paramInt, null);
      this.qS.a((Fragment)paramObject);
      return;
    }
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).mView == paramView;
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.qX.size() > paramInt)
    {
      localObject = (Fragment)this.qX.get(paramInt);
      if (localObject != null) {
        return localObject;
      }
    }
    if (this.qS == null) {
      this.qS = this.qR.aV();
    }
    Fragment localFragment = I(paramInt);
    if (this.qW.size() > paramInt)
    {
      localObject = (Fragment.SavedState)this.qW.get(paramInt);
      if (localObject != null)
      {
        if (localFragment.mIndex >= 0) {
          throw new IllegalStateException("Fragment already active");
        }
        if ((localObject == null) || (((Fragment.SavedState)localObject).pM == null)) {
          break label144;
        }
      }
    }
    label144:
    for (Object localObject = ((Fragment.SavedState)localObject).pM;; localObject = null)
    {
      localFragment.oT = ((Bundle)localObject);
      while (this.qX.size() <= paramInt) {
        this.qX.add(null);
      }
    }
    localFragment.setMenuVisibility(false);
    localFragment.setUserVisibleHint(false);
    this.qX.set(paramInt, localFragment);
    this.qS.a(paramViewGroup.getId(), localFragment);
    return localFragment;
  }
  
  public final void ba()
  {
    if (this.qS != null)
    {
      this.qS.commitAllowingStateLoss();
      this.qS = null;
      this.qR.executePendingTransactions();
    }
  }
  
  public final Parcelable bb()
  {
    Object localObject1 = null;
    Object localObject2;
    if (this.qW.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new Fragment.SavedState[this.qW.size()];
      this.qW.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    int i = 0;
    while (i < this.qX.size())
    {
      Fragment localFragment = (Fragment)this.qX.get(i);
      localObject2 = localObject1;
      if (localFragment != null)
      {
        localObject2 = localObject1;
        if (localFragment.isAdded())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Bundle();
          }
          localObject1 = "f" + i;
          this.qR.a((Bundle)localObject2, (String)localObject1, localFragment);
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return (Parcelable)localObject1;
  }
  
  public final void d(Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (paramObject != this.qT)
    {
      if (this.qT != null)
      {
        this.qT.setMenuVisibility(false);
        this.qT.setUserVisibleHint(false);
      }
      if (paramObject != null)
      {
        ((Fragment)paramObject).setMenuVisibility(true);
        ((Fragment)paramObject).setUserVisibleHint(true);
      }
      this.qT = ((Fragment)paramObject);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */