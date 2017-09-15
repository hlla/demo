package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<a> jT = new ArrayList();
  private Context mContext;
  private int pl;
  private l qR;
  private TabHost.OnTabChangeListener qY;
  private a qZ;
  private boolean ra;
  
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.pl = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
  }
  
  private p a(String paramString, p paramp)
  {
    Object localObject = null;
    int i = 0;
    if (i < this.jT.size())
    {
      a locala = (a)this.jT.get(i);
      if (!locala.tag.equals(paramString)) {
        break label213;
      }
      localObject = locala;
    }
    label200:
    label213:
    for (;;)
    {
      i += 1;
      break;
      if (localObject == null) {
        throw new IllegalStateException("No tab known for tag " + paramString);
      }
      paramString = paramp;
      if (this.qZ != localObject)
      {
        paramString = paramp;
        if (paramp == null) {
          paramString = this.qR.aV();
        }
        if ((this.qZ != null) && (this.qZ.ov != null)) {
          paramString.b(this.qZ.ov);
        }
        if (localObject != null)
        {
          if (((a)localObject).ov != null) {
            break label200;
          }
          ((a)localObject).ov = Fragment.a(this.mContext, ((a)localObject).rc.getName(), ((a)localObject).rd);
          paramString.a(this.pl, ((a)localObject).ov, ((a)localObject).tag);
        }
      }
      for (;;)
      {
        this.qZ = ((a)localObject);
        return paramString;
        paramString.c(((a)localObject).ov);
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    Object localObject1 = null;
    int i = 0;
    if (i < this.jT.size())
    {
      a locala = (a)this.jT.get(i);
      locala.ov = this.qR.k(locala.tag);
      Object localObject2 = localObject1;
      if (locala.ov != null)
      {
        localObject2 = localObject1;
        if (!locala.ov.pn)
        {
          if (!locala.tag.equals(str)) {
            break label108;
          }
          this.qZ = locala;
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label108:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.qR.aV();
        }
        ((p)localObject2).b(locala.ov);
      }
    }
    this.ra = true;
    localObject1 = a(str, (p)localObject1);
    if (localObject1 != null)
    {
      ((p)localObject1).commit();
      this.qR.executePendingTransactions();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.ra = false;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.rb);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.rb = getCurrentTabTag();
    return localSavedState;
  }
  
  public void onTabChanged(String paramString)
  {
    if (this.ra)
    {
      p localp = a(paramString, null);
      if (localp != null) {
        localp.commit();
      }
    }
    if (this.qY != null) {
      this.qY.onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.qY = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    String rb;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.rb = paramParcel.readString();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.rb + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.rb);
    }
  }
  
  static final class a
  {
    public Fragment ov;
    public final Class<?> rc;
    public final Bundle rd;
    public final String tag;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/FragmentTabHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */