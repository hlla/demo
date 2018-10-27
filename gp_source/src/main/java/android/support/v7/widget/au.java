package android.support.v7.widget;

import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

final class au
  implements ListAdapter, SpinnerAdapter
{
  private SpinnerAdapter a;
  private ListAdapter b;
  
  public au(SpinnerAdapter paramSpinnerAdapter, Resources.Theme paramTheme)
  {
    this.a = paramSpinnerAdapter;
    if ((paramSpinnerAdapter instanceof ListAdapter)) {
      this.b = ((ListAdapter)paramSpinnerAdapter);
    }
    if (paramTheme != null)
    {
      if ((Build.VERSION.SDK_INT < 23) || (!(paramSpinnerAdapter instanceof ThemedSpinnerAdapter))) {
        break label66;
      }
      paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
      if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
        paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
      }
    }
    label66:
    do
    {
      do
      {
        return;
      } while (!(paramSpinnerAdapter instanceof hb));
      paramSpinnerAdapter = (hb)paramSpinnerAdapter;
    } while (paramSpinnerAdapter.b() != null);
    paramSpinnerAdapter.a();
  }
  
  public final boolean areAllItemsEnabled()
  {
    ListAdapter localListAdapter = this.b;
    if (localListAdapter == null) {
      return true;
    }
    return localListAdapter.areAllItemsEnabled();
  }
  
  public final int getCount()
  {
    SpinnerAdapter localSpinnerAdapter = this.a;
    if (localSpinnerAdapter != null) {
      return localSpinnerAdapter.getCount();
    }
    return 0;
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SpinnerAdapter localSpinnerAdapter = this.a;
    if (localSpinnerAdapter != null) {
      return localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
    }
    return null;
  }
  
  public final Object getItem(int paramInt)
  {
    SpinnerAdapter localSpinnerAdapter = this.a;
    if (localSpinnerAdapter != null) {
      return localSpinnerAdapter.getItem(paramInt);
    }
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    SpinnerAdapter localSpinnerAdapter = this.a;
    if (localSpinnerAdapter != null) {
      return localSpinnerAdapter.getItemId(paramInt);
    }
    return -1L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final boolean hasStableIds()
  {
    SpinnerAdapter localSpinnerAdapter = this.a;
    return (localSpinnerAdapter != null) && (localSpinnerAdapter.hasStableIds());
  }
  
  public final boolean isEmpty()
  {
    return getCount() == 0;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    ListAdapter localListAdapter = this.b;
    if (localListAdapter == null) {
      return true;
    }
    return localListAdapter.isEnabled(paramInt);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    SpinnerAdapter localSpinnerAdapter = this.a;
    if (localSpinnerAdapter != null) {
      localSpinnerAdapter.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    SpinnerAdapter localSpinnerAdapter = this.a;
    if (localSpinnerAdapter != null) {
      localSpinnerAdapter.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */