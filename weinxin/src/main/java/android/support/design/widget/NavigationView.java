package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.b;
import android.support.design.a.f;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.a;
import android.support.design.internal.b.b;
import android.support.v4.os.c;
import android.support.v4.view.z;
import android.support.v7.view.g;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.view.menu.l;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class NavigationView
  extends ScrimInsetsFrameLayout
{
  private static final int[] dN = { 16842912 };
  private static final int[] iK = { -16842910 };
  private final a iL;
  private final android.support.design.internal.b iM = new android.support.design.internal.b();
  private a iN;
  private int iO;
  private MenuInflater iP;
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    t.g(paramContext);
    this.iL = new a(paramContext);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.co, paramInt, a.h.aR);
    setBackgroundDrawable(localTypedArray.getDrawable(a.i.cp));
    if (localTypedArray.hasValue(a.i.ct)) {
      z.g(this, localTypedArray.getDimensionPixelSize(a.i.ct, 0));
    }
    z.a(this, localTypedArray.getBoolean(a.i.cq, false));
    this.iO = localTypedArray.getDimensionPixelSize(a.i.cs, 0);
    ColorStateList localColorStateList;
    if (localTypedArray.hasValue(a.i.cw))
    {
      localColorStateList = localTypedArray.getColorStateList(a.i.cw);
      if (!localTypedArray.hasValue(a.i.cx)) {
        break label551;
      }
      paramInt = localTypedArray.getResourceId(a.i.cx, 0);
    }
    for (int i = 1;; i = 0)
    {
      paramAttributeSet = null;
      if (localTypedArray.hasValue(a.i.cy)) {
        paramAttributeSet = localTypedArray.getColorStateList(a.i.cy);
      }
      Object localObject = paramAttributeSet;
      if (i == 0)
      {
        localObject = paramAttributeSet;
        if (paramAttributeSet == null) {
          localObject = v(16842806);
        }
      }
      paramAttributeSet = localTypedArray.getDrawable(a.i.cv);
      this.iL.a(new f.a()
      {
        public final boolean a(f paramAnonymousf, MenuItem paramAnonymousMenuItem)
        {
          return (NavigationView.a(NavigationView.this) != null) && (NavigationView.a(NavigationView.this).af());
        }
        
        public final void b(f paramAnonymousf) {}
      });
      this.iM.dX = 1;
      this.iM.a(paramContext, this.iL);
      this.iM.a(localColorStateList);
      if (i != 0) {
        this.iM.e(paramInt);
      }
      this.iM.b((ColorStateList)localObject);
      this.iM.a(paramAttributeSet);
      this.iL.a(this.iM);
      paramContext = this.iM;
      if (paramContext.dT == null)
      {
        paramContext.dT = ((NavigationMenuView)paramContext.dZ.inflate(a.f.aF, this, false));
        if (paramContext.dY == null) {
          paramContext.dY = new b.b(paramContext);
        }
        paramContext.dU = ((LinearLayout)paramContext.dZ.inflate(a.f.aC, paramContext.dT, false));
        paramContext.dT.a(paramContext.dY);
      }
      addView((View)paramContext.dT);
      if (localTypedArray.hasValue(a.i.cz))
      {
        paramInt = localTypedArray.getResourceId(a.i.cz, 0);
        this.iM.g(true);
        if (this.iP == null) {
          this.iP = new g(getContext());
        }
        this.iP.inflate(paramInt, this.iL);
        this.iM.g(false);
        this.iM.f(false);
      }
      if (localTypedArray.hasValue(a.i.cu))
      {
        paramInt = localTypedArray.getResourceId(a.i.cu, 0);
        paramContext = this.iM;
        paramAttributeSet = paramContext.dZ.inflate(paramInt, paramContext.dU, false);
        paramContext.dU.addView(paramAttributeSet);
        paramContext.dT.setPadding(0, 0, 0, paramContext.dT.getPaddingBottom());
      }
      localTypedArray.recycle();
      return;
      localColorStateList = v(16842808);
      break;
      label551:
      paramInt = 0;
    }
  }
  
  private ColorStateList v(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = getResources().getColorStateList(((TypedValue)localObject).resourceId);
    } while (!getContext().getTheme().resolveAttribute(a.b.colorPrimary, (TypedValue)localObject, true));
    paramInt = ((TypedValue)localObject).data;
    int i = localColorStateList.getDefaultColor();
    localObject = iK;
    int[] arrayOfInt1 = dN;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(iK, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  protected final void a(Rect paramRect)
  {
    android.support.design.internal.b localb = this.iM;
    int i = paramRect.top;
    if (localb.ee != i)
    {
      localb.ee = i;
      if (localb.dU.getChildCount() == 0) {
        localb.dT.setPadding(0, localb.ee, 0, localb.dT.getPaddingBottom());
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    default: 
      i = paramInt1;
    }
    for (;;)
    {
      super.onMeasure(i, paramInt2);
      return;
      i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.iO), 1073741824);
      continue;
      i = View.MeasureSpec.makeMeasureSpec(this.iO, 1073741824);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      Object localObject1 = (SavedState)paramParcelable;
      super.onRestoreInstanceState(((SavedState)localObject1).getSuperState());
      paramParcelable = this.iL;
      localObject1 = ((SavedState)localObject1).iR.getSparseParcelableArray("android:menu:presenters");
      if ((localObject1 != null) && (!paramParcelable.QH.isEmpty()))
      {
        Iterator localIterator = paramParcelable.QH.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (WeakReference)localIterator.next();
          l locall = (l)((WeakReference)localObject2).get();
          if (locall == null)
          {
            paramParcelable.QH.remove(localObject2);
          }
          else
          {
            int i = locall.getId();
            if (i > 0)
            {
              localObject2 = (Parcelable)((SparseArray)localObject1).get(i);
              if (localObject2 != null) {
                locall.onRestoreInstanceState((Parcelable)localObject2);
              }
            }
          }
        }
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.iR = new Bundle();
    this.iL.dispatchSaveInstanceState(localSavedState.iR);
    return localSavedState;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = android.support.v4.os.b.a(new c() {});
    public Bundle iR;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super();
      this.iR = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.iR);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean af();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/NavigationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */