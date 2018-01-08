package com.android.common.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class CompositeCursorAdapter
  extends BaseAdapter
{
  private static final int INITIAL_CAPACITY = 2;
  private boolean mCacheValid = true;
  private final Context mContext;
  private int mCount = 0;
  private boolean mNotificationNeeded;
  private boolean mNotificationsEnabled = true;
  private ArrayList<Partition> mPartitions;
  
  public CompositeCursorAdapter(Context paramContext)
  {
    this(paramContext, 2);
  }
  
  public CompositeCursorAdapter(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mPartitions = new ArrayList();
  }
  
  public void addPartition(int paramInt, Partition paramPartition)
  {
    this.mPartitions.add(paramInt, paramPartition);
    invalidate();
    notifyDataSetChanged();
  }
  
  public void addPartition(Partition paramPartition)
  {
    this.mPartitions.add(paramPartition);
    invalidate();
    notifyDataSetChanged();
  }
  
  public void addPartition(boolean paramBoolean1, boolean paramBoolean2)
  {
    addPartition(new Partition(paramBoolean1, paramBoolean2));
  }
  
  public boolean areAllItemsEnabled()
  {
    Iterator localIterator = this.mPartitions.iterator();
    while (localIterator.hasNext()) {
      if (((Partition)localIterator.next()).hasHeader) {
        return false;
      }
    }
    return true;
  }
  
  protected void bindHeaderView(View paramView, int paramInt, Cursor paramCursor) {}
  
  protected abstract void bindView(View paramView, int paramInt1, Cursor paramCursor, int paramInt2);
  
  public void changeCursor(int paramInt, Cursor paramCursor)
  {
    Cursor localCursor = ((Partition)this.mPartitions.get(paramInt)).cursor;
    if (localCursor != paramCursor)
    {
      if ((localCursor != null) && (!localCursor.isClosed())) {
        localCursor.close();
      }
      ((Partition)this.mPartitions.get(paramInt)).cursor = paramCursor;
      if (paramCursor != null) {
        ((Partition)this.mPartitions.get(paramInt)).idColumnIndex = paramCursor.getColumnIndex("_id");
      }
      invalidate();
      notifyDataSetChanged();
    }
  }
  
  public void clearPartitions()
  {
    Iterator localIterator = this.mPartitions.iterator();
    while (localIterator.hasNext()) {
      ((Partition)localIterator.next()).cursor = null;
    }
    invalidate();
    notifyDataSetChanged();
  }
  
  public void close()
  {
    Iterator localIterator = this.mPartitions.iterator();
    while (localIterator.hasNext())
    {
      Cursor localCursor = ((Partition)localIterator.next()).cursor;
      if ((localCursor != null) && (!localCursor.isClosed())) {
        localCursor.close();
      }
    }
    this.mPartitions.clear();
    invalidate();
    notifyDataSetChanged();
  }
  
  protected void ensureCacheValid()
  {
    if (this.mCacheValid) {
      return;
    }
    this.mCount = 0;
    Iterator localIterator = this.mPartitions.iterator();
    if (localIterator.hasNext())
    {
      Partition localPartition = (Partition)localIterator.next();
      Cursor localCursor = localPartition.cursor;
      if (localCursor != null) {}
      for (int i = localCursor.getCount();; i = 0)
      {
        int j = i;
        if (localPartition.hasHeader) {
          if (i == 0)
          {
            j = i;
            if (!localPartition.showIfEmpty) {}
          }
          else
          {
            j = i + 1;
          }
        }
        localPartition.count = j;
        this.mCount += j;
        break;
      }
    }
    this.mCacheValid = true;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public int getCount()
  {
    ensureCacheValid();
    return this.mCount;
  }
  
  public Cursor getCursor(int paramInt)
  {
    return ((Partition)this.mPartitions.get(paramInt)).cursor;
  }
  
  protected View getHeaderView(int paramInt, Cursor paramCursor, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (;;)
    {
      bindHeaderView(paramView, paramInt, paramCursor);
      return paramView;
      paramView = newHeaderView(this.mContext, paramInt, paramCursor, paramViewGroup);
    }
  }
  
  public Object getItem(int paramInt)
  {
    ensureCacheValid();
    int i = 0;
    Object localObject = this.mPartitions.iterator();
    for (;;)
    {
      Partition localPartition;
      int j;
      if (((Iterator)localObject).hasNext())
      {
        localPartition = (Partition)((Iterator)localObject).next();
        j = i + localPartition.count;
        if ((paramInt < i) || (paramInt >= j)) {
          break label99;
        }
        i = paramInt - i;
        paramInt = i;
        if (localPartition.hasHeader) {
          paramInt = i - 1;
        }
        if (paramInt != -1) {}
      }
      else
      {
        return null;
      }
      localObject = localPartition.cursor;
      ((Cursor)localObject).moveToPosition(paramInt);
      return localObject;
      label99:
      i = j;
    }
  }
  
  public long getItemId(int paramInt)
  {
    ensureCacheValid();
    int i = 0;
    Object localObject = this.mPartitions.iterator();
    for (;;)
    {
      Partition localPartition;
      int j;
      if (((Iterator)localObject).hasNext())
      {
        localPartition = (Partition)((Iterator)localObject).next();
        j = i + localPartition.count;
        if ((paramInt < i) || (paramInt >= j)) {
          break label135;
        }
        i = paramInt - i;
        paramInt = i;
        if (localPartition.hasHeader) {
          paramInt = i - 1;
        }
        if (paramInt != -1) {
          break label80;
        }
      }
      label80:
      do
      {
        do
        {
          return 0L;
        } while (localPartition.idColumnIndex == -1);
        localObject = localPartition.cursor;
      } while ((localObject == null) || (((Cursor)localObject).isClosed()) || (!((Cursor)localObject).moveToPosition(paramInt)));
      return ((Cursor)localObject).getLong(localPartition.idColumnIndex);
      label135:
      i = j;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    ensureCacheValid();
    int j = 0;
    int i = 0;
    int m = this.mPartitions.size();
    while (i < m)
    {
      int k = j + ((Partition)this.mPartitions.get(i)).count;
      if ((paramInt >= j) && (paramInt < k))
      {
        j = paramInt - j;
        paramInt = j;
        if (((Partition)this.mPartitions.get(i)).hasHeader) {
          paramInt = j - 1;
        }
        if (paramInt == -1) {
          return -1;
        }
        return getItemViewType(i, paramInt);
      }
      j = k;
      i += 1;
    }
    throw new ArrayIndexOutOfBoundsException(paramInt);
  }
  
  protected int getItemViewType(int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public int getItemViewTypeCount()
  {
    return 1;
  }
  
  public int getOffsetInPartition(int paramInt)
  {
    ensureCacheValid();
    int i = 0;
    Iterator localIterator = this.mPartitions.iterator();
    while (localIterator.hasNext())
    {
      Partition localPartition = (Partition)localIterator.next();
      int j = i + localPartition.count;
      if ((paramInt >= i) && (paramInt < j))
      {
        i = paramInt - i;
        paramInt = i;
        if (localPartition.hasHeader) {
          paramInt = i - 1;
        }
        return paramInt;
      }
      i = j;
    }
    return -1;
  }
  
  public Partition getPartition(int paramInt)
  {
    return (Partition)this.mPartitions.get(paramInt);
  }
  
  public int getPartitionCount()
  {
    return this.mPartitions.size();
  }
  
  public int getPartitionForPosition(int paramInt)
  {
    ensureCacheValid();
    int j = 0;
    int i = 0;
    int m = this.mPartitions.size();
    while (i < m)
    {
      int k = j + ((Partition)this.mPartitions.get(i)).count;
      if ((paramInt >= j) && (paramInt < k)) {
        return i;
      }
      j = k;
      i += 1;
    }
    return -1;
  }
  
  public int getPositionForPartition(int paramInt)
  {
    ensureCacheValid();
    int j = 0;
    int i = 0;
    while (i < paramInt)
    {
      j += ((Partition)this.mPartitions.get(i)).count;
      i += 1;
    }
    return j;
  }
  
  protected View getView(int paramInt1, Cursor paramCursor, int paramInt2, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (;;)
    {
      bindView(paramView, paramInt1, paramCursor, paramInt2);
      return paramView;
      paramView = newView(this.mContext, paramInt1, paramCursor, paramInt2, paramViewGroup);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ensureCacheValid();
    int j = 0;
    int i = 0;
    int m = this.mPartitions.size();
    while (i < m)
    {
      int k = j + ((Partition)this.mPartitions.get(i)).count;
      if ((paramInt >= j) && (paramInt < k))
      {
        j = paramInt - j;
        paramInt = j;
        if (((Partition)this.mPartitions.get(i)).hasHeader) {
          paramInt = j - 1;
        }
        if (paramInt == -1) {}
        for (paramView = getHeaderView(i, ((Partition)this.mPartitions.get(i)).cursor, paramView, paramViewGroup); paramView == null; paramView = getView(i, ((Partition)this.mPartitions.get(i)).cursor, paramInt, paramView, paramViewGroup))
        {
          throw new NullPointerException("View should not be null, partition: " + i + " position: " + paramInt);
          if (!((Partition)this.mPartitions.get(i)).cursor.moveToPosition(paramInt)) {
            throw new IllegalStateException("Couldn't move cursor to position " + paramInt);
          }
        }
      }
      j = k;
      i += 1;
    }
    throw new ArrayIndexOutOfBoundsException(paramInt);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return getItemViewTypeCount() + 1;
  }
  
  public boolean hasHeader(int paramInt)
  {
    return ((Partition)this.mPartitions.get(paramInt)).hasHeader;
  }
  
  protected void invalidate()
  {
    this.mCacheValid = false;
  }
  
  public boolean isEnabled(int paramInt)
  {
    ensureCacheValid();
    int j = 0;
    int i = 0;
    int m = this.mPartitions.size();
    while (i < m)
    {
      int k = j + ((Partition)this.mPartitions.get(i)).count;
      if ((paramInt >= j) && (paramInt < k))
      {
        paramInt -= j;
        if ((((Partition)this.mPartitions.get(i)).hasHeader) && (paramInt == 0)) {
          return false;
        }
        return isEnabled(i, paramInt);
      }
      j = k;
      i += 1;
    }
    return false;
  }
  
  protected boolean isEnabled(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public boolean isPartitionEmpty(int paramInt)
  {
    Cursor localCursor = ((Partition)this.mPartitions.get(paramInt)).cursor;
    return (localCursor == null) || (localCursor.getCount() == 0);
  }
  
  protected View newHeaderView(Context paramContext, int paramInt, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  protected abstract View newView(Context paramContext, int paramInt1, Cursor paramCursor, int paramInt2, ViewGroup paramViewGroup);
  
  public void notifyDataSetChanged()
  {
    if (this.mNotificationsEnabled)
    {
      this.mNotificationNeeded = false;
      super.notifyDataSetChanged();
      return;
    }
    this.mNotificationNeeded = true;
  }
  
  public void removePartition(int paramInt)
  {
    Cursor localCursor = ((Partition)this.mPartitions.get(paramInt)).cursor;
    if ((localCursor != null) && (!localCursor.isClosed())) {
      localCursor.close();
    }
    this.mPartitions.remove(paramInt);
    invalidate();
    notifyDataSetChanged();
  }
  
  public void setHasHeader(int paramInt, boolean paramBoolean)
  {
    ((Partition)this.mPartitions.get(paramInt)).hasHeader = paramBoolean;
    invalidate();
  }
  
  public void setNotificationsEnabled(boolean paramBoolean)
  {
    this.mNotificationsEnabled = paramBoolean;
    if ((paramBoolean) && (this.mNotificationNeeded)) {
      notifyDataSetChanged();
    }
  }
  
  public void setShowIfEmpty(int paramInt, boolean paramBoolean)
  {
    ((Partition)this.mPartitions.get(paramInt)).showIfEmpty = paramBoolean;
    invalidate();
  }
  
  public static class Partition
  {
    int count;
    Cursor cursor;
    boolean hasHeader;
    int idColumnIndex;
    boolean showIfEmpty;
    
    public Partition(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.showIfEmpty = paramBoolean1;
      this.hasHeader = paramBoolean2;
    }
    
    public boolean getHasHeader()
    {
      return this.hasHeader;
    }
    
    public boolean getShowIfEmpty()
    {
      return this.showIfEmpty;
    }
    
    public boolean isEmpty()
    {
      return this.count == 0;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/widget/CompositeCursorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */