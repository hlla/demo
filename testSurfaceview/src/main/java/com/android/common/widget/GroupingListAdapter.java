package com.android.common.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class GroupingListAdapter
  extends BaseAdapter
{
  private static final long EXPANDED_GROUP_MASK = Long.MIN_VALUE;
  private static final int GROUP_METADATA_ARRAY_INCREMENT = 128;
  private static final int GROUP_METADATA_ARRAY_INITIAL_SIZE = 16;
  private static final long GROUP_OFFSET_MASK = 4294967295L;
  private static final long GROUP_SIZE_MASK = 9223372032559808512L;
  public static final int ITEM_TYPE_GROUP_HEADER = 1;
  public static final int ITEM_TYPE_IN_GROUP = 2;
  public static final int ITEM_TYPE_STANDALONE = 0;
  protected ContentObserver mChangeObserver = new ContentObserver(new Handler())
  {
    public boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public void onChange(boolean paramAnonymousBoolean)
    {
      GroupingListAdapter.this.onContentChanged();
    }
  };
  private Context mContext;
  private int mCount;
  private Cursor mCursor;
  protected DataSetObserver mDataSetObserver = new DataSetObserver()
  {
    public void onChanged()
    {
      GroupingListAdapter.this.notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      GroupingListAdapter.this.notifyDataSetInvalidated();
    }
  };
  private int mGroupCount;
  private long[] mGroupMetadata;
  private int mLastCachedCursorPosition;
  private int mLastCachedGroup;
  private int mLastCachedListPosition;
  private SparseIntArray mPositionCache = new SparseIntArray();
  private PositionMetadata mPositionMetadata = new PositionMetadata();
  private int mRowIdColumnIndex;
  
  public GroupingListAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    resetCache();
  }
  
  private void findGroups()
  {
    this.mGroupCount = 0;
    this.mGroupMetadata = new long[16];
    if (this.mCursor == null) {
      return;
    }
    addGroups(this.mCursor);
  }
  
  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
  
  private void resetCache()
  {
    this.mCount = -1;
    this.mLastCachedListPosition = -1;
    this.mLastCachedCursorPosition = -1;
    this.mLastCachedGroup = -1;
    PositionMetadata.access$002(this.mPositionMetadata, -1);
    this.mPositionCache.clear();
  }
  
  protected void addGroup(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.mGroupCount >= this.mGroupMetadata.length)
    {
      arrayOfLong = new long[idealLongArraySize(this.mGroupMetadata.length + 128)];
      System.arraycopy(this.mGroupMetadata, 0, arrayOfLong, 0, this.mGroupCount);
      this.mGroupMetadata = arrayOfLong;
    }
    long l2 = paramInt2 << 32 | paramInt1;
    long l1 = l2;
    if (paramBoolean) {
      l1 = l2 | 0x8000000000000000;
    }
    long[] arrayOfLong = this.mGroupMetadata;
    paramInt1 = this.mGroupCount;
    this.mGroupCount = (paramInt1 + 1);
    arrayOfLong[paramInt1] = l1;
  }
  
  protected abstract void addGroups(Cursor paramCursor);
  
  protected abstract void bindChildView(View paramView, Context paramContext, Cursor paramCursor);
  
  protected abstract void bindGroupView(View paramView, Context paramContext, Cursor paramCursor, int paramInt, boolean paramBoolean);
  
  protected abstract void bindStandAloneView(View paramView, Context paramContext, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor == this.mCursor) {
      return;
    }
    if (this.mCursor != null)
    {
      this.mCursor.unregisterContentObserver(this.mChangeObserver);
      this.mCursor.unregisterDataSetObserver(this.mDataSetObserver);
      this.mCursor.close();
    }
    this.mCursor = paramCursor;
    resetCache();
    findGroups();
    if (paramCursor != null)
    {
      paramCursor.registerContentObserver(this.mChangeObserver);
      paramCursor.registerDataSetObserver(this.mDataSetObserver);
      this.mRowIdColumnIndex = paramCursor.getColumnIndexOrThrow("_id");
      notifyDataSetChanged();
      return;
    }
    notifyDataSetInvalidated();
  }
  
  public int getCount()
  {
    if (this.mCursor == null) {
      return 0;
    }
    if (this.mCount != -1) {
      return this.mCount;
    }
    int k = 0;
    int i = 0;
    int j = 0;
    if (j < this.mGroupCount)
    {
      long l = this.mGroupMetadata[j];
      int n = (int)(0xFFFFFFFF & l);
      int m;
      label67:
      int i1;
      if ((0x8000000000000000 & l) != 0L)
      {
        m = 1;
        i1 = (int)((0x7FFFFFFF00000000 & l) >> 32);
        i += n - k;
        if (m == 0) {
          break label117;
        }
        i += i1 + 1;
      }
      for (;;)
      {
        k = n + i1;
        j += 1;
        break;
        m = 0;
        break label67;
        label117:
        i += 1;
      }
    }
    this.mCount = (this.mCursor.getCount() + i - k);
    return this.mCount;
  }
  
  public Cursor getCursor()
  {
    return this.mCursor;
  }
  
  public int getGroupSize(int paramInt)
  {
    obtainPositionMetadata(this.mPositionMetadata, paramInt);
    return this.mPositionMetadata.childCount;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.mCursor == null) {}
    do
    {
      return null;
      obtainPositionMetadata(this.mPositionMetadata, paramInt);
    } while (!this.mCursor.moveToPosition(this.mPositionMetadata.cursorPosition));
    return this.mCursor;
  }
  
  public long getItemId(int paramInt)
  {
    if (getItem(paramInt) != null) {
      return this.mCursor.getLong(this.mRowIdColumnIndex);
    }
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    obtainPositionMetadata(this.mPositionMetadata, paramInt);
    return this.mPositionMetadata.itemType;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    obtainPositionMetadata(this.mPositionMetadata, paramInt);
    View localView = paramView;
    paramView = localView;
    if (localView == null) {
      switch (this.mPositionMetadata.itemType)
      {
      default: 
        paramView = localView;
      }
    }
    for (;;)
    {
      this.mCursor.moveToPosition(this.mPositionMetadata.cursorPosition);
      switch (this.mPositionMetadata.itemType)
      {
      default: 
        return paramView;
        paramView = newStandAloneView(this.mContext, paramViewGroup);
        continue;
        paramView = newGroupView(this.mContext, paramViewGroup);
        continue;
        paramView = newChildView(this.mContext, paramViewGroup);
      }
    }
    bindStandAloneView(paramView, this.mContext, this.mCursor);
    return paramView;
    bindGroupView(paramView, this.mContext, this.mCursor, this.mPositionMetadata.childCount, this.mPositionMetadata.isExpanded);
    return paramView;
    bindChildView(paramView, this.mContext, this.mCursor);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isGroupHeader(int paramInt)
  {
    obtainPositionMetadata(this.mPositionMetadata, paramInt);
    return this.mPositionMetadata.itemType == 1;
  }
  
  protected abstract View newChildView(Context paramContext, ViewGroup paramViewGroup);
  
  protected abstract View newGroupView(Context paramContext, ViewGroup paramViewGroup);
  
  protected abstract View newStandAloneView(Context paramContext, ViewGroup paramViewGroup);
  
  public void obtainPositionMetadata(PositionMetadata paramPositionMetadata, int paramInt)
  {
    if (paramPositionMetadata.listPosition == paramInt) {
      return;
    }
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i = i1;
    int k = i2;
    int j = n;
    int m;
    if (this.mLastCachedListPosition != -1)
    {
      if (paramInt > this.mLastCachedListPosition) {
        break label241;
      }
      i = this.mPositionCache.indexOfKey(paramInt);
      m = i;
      if (i < 0)
      {
        i = (i ^ 0xFFFFFFFF) - 1;
        m = i;
        if (i >= this.mPositionCache.size()) {
          m = i - 1;
        }
      }
      i = i1;
      k = i2;
      j = n;
      if (m >= 0)
      {
        j = this.mPositionCache.keyAt(m);
        k = this.mPositionCache.valueAt(m);
      }
    }
    long l;
    for (i = (int)(0xFFFFFFFF & this.mGroupMetadata[k]);; i = this.mLastCachedCursorPosition)
    {
      m = j;
      j = k;
      k = i;
      if (j >= this.mGroupCount) {
        break label395;
      }
      l = this.mGroupMetadata[j];
      n = (int)(0xFFFFFFFF & l);
      i = m + (n - k);
      if (j > this.mLastCachedGroup)
      {
        this.mPositionCache.append(i, j);
        this.mLastCachedListPosition = i;
        this.mLastCachedCursorPosition = n;
        this.mLastCachedGroup = j;
      }
      if (paramInt >= i) {
        break;
      }
      paramPositionMetadata.itemType = 0;
      paramPositionMetadata.cursorPosition = (n - (i - paramInt));
      return;
      label241:
      k = this.mLastCachedGroup;
      j = this.mLastCachedListPosition;
    }
    if ((0x8000000000000000 & l) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      k = (int)((0x7FFFFFFF00000000 & l) >> 32);
      if (paramInt != i) {
        break;
      }
      paramPositionMetadata.itemType = 1;
      PositionMetadata.access$102(paramPositionMetadata, j);
      paramPositionMetadata.isExpanded = bool;
      paramPositionMetadata.childCount = k;
      paramPositionMetadata.cursorPosition = n;
      return;
    }
    if (bool)
    {
      if (paramInt < i + k + 1)
      {
        paramPositionMetadata.itemType = 2;
        paramPositionMetadata.cursorPosition = (paramInt - i + n - 1);
        return;
      }
      i += k + 1;
    }
    for (;;)
    {
      k = n + k;
      j += 1;
      m = i;
      break;
      i += 1;
    }
    label395:
    paramPositionMetadata.itemType = 0;
    paramPositionMetadata.cursorPosition = (paramInt - m + k);
  }
  
  protected void onContentChanged() {}
  
  public void toggleGroup(int paramInt)
  {
    obtainPositionMetadata(this.mPositionMetadata, paramInt);
    if (this.mPositionMetadata.itemType != 1) {
      throw new IllegalArgumentException("Not a group at position " + paramInt);
    }
    long[] arrayOfLong;
    if (this.mPositionMetadata.isExpanded)
    {
      arrayOfLong = this.mGroupMetadata;
      paramInt = this.mPositionMetadata.groupPosition;
      arrayOfLong[paramInt] &= 0x7FFFFFFFFFFFFFFF;
    }
    for (;;)
    {
      resetCache();
      notifyDataSetChanged();
      return;
      arrayOfLong = this.mGroupMetadata;
      paramInt = this.mPositionMetadata.groupPosition;
      arrayOfLong[paramInt] |= 0x8000000000000000;
    }
  }
  
  protected static class PositionMetadata
  {
    int childCount;
    int cursorPosition;
    private int groupPosition;
    boolean isExpanded;
    int itemType;
    private int listPosition = -1;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/widget/GroupingListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */