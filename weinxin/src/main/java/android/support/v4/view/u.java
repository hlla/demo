package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class u
{
  private final DataSetObservable xo = new DataSetObservable();
  private DataSetObserver xp;
  
  final void a(DataSetObserver paramDataSetObserver)
  {
    try
    {
      this.xp = paramDataSetObserver;
      return;
    }
    finally {}
  }
  
  public void a(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }
  
  public abstract boolean a(View paramView, Object paramObject);
  
  public Object b(ViewGroup paramViewGroup, int paramInt)
  {
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  public CharSequence bK()
  {
    return null;
  }
  
  public void ba() {}
  
  public Parcelable bb()
  {
    return null;
  }
  
  public void d(Object paramObject) {}
  
  public abstract int getCount();
  
  public int j(Object paramObject)
  {
    return -1;
  }
  
  public void notifyDataSetChanged()
  {
    try
    {
      if (this.xp != null) {
        this.xp.onChanged();
      }
      this.xo.notifyChanged();
      return;
    }
    finally {}
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.xo.registerObserver(paramDataSetObserver);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.xo.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */