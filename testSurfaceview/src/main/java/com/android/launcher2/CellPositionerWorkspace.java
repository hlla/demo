package com.android.launcher2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CellPositionerWorkspace
  implements CellPositioner
{
  private final int[][] directions;
  private int mCellHeight;
  private int mCellWidth;
  private final DeltaProvider mDeltaProvider;
  private final ArrayList<PositionDelta> mDeltas;
  private PositionDelta mDragDelta;
  private final GridDimensionProvider mGridDimensionProvider;
  private final CellLayout mLayout;
  final int mNumColumns;
  final int mNumRows;
  private boolean[][] mOccupied;
  private boolean mShrinkingEnabled;
  private final int[] tmpExactXY = new int[2];
  private List<PositionDelta> tmpForSort;
  private final int[] tmpRect;
  private List<PositionDelta> tmpRollback;
  private final ArrayList<PositionDelta> tmpShiftDeltas;
  private final ArrayList<PositionDelta> tmpSortedDeltas;
  private final int[] tmpXY = new int[2];
  
  public CellPositionerWorkspace(CellLayout paramCellLayout, DeltaProvider paramDeltaProvider, GridDimensionProvider paramGridDimensionProvider)
  {
    int[] arrayOfInt1 = { 0, 0 };
    int[] arrayOfInt2 = { 0, -1 };
    int[] arrayOfInt3 = { 0, 1 };
    int[] arrayOfInt4 = { 1, -1 };
    this.directions = new int[][] { arrayOfInt1, arrayOfInt2, { -1, 0 }, { 1, 0 }, arrayOfInt3, { -1, -1 }, arrayOfInt4, { 1, 1 }, { -1, 1 } };
    this.tmpRollback = new ArrayList();
    this.mShrinkingEnabled = false;
    this.tmpRect = new int[4];
    this.tmpShiftDeltas = new ArrayList();
    this.tmpSortedDeltas = new ArrayList();
    this.tmpForSort = new ArrayList();
    this.mLayout = paramCellLayout;
    this.mDeltaProvider = paramDeltaProvider;
    this.mGridDimensionProvider = paramGridDimensionProvider;
    this.mDeltas = new ArrayList();
    this.mNumRows = this.mGridDimensionProvider.getNumRows();
    this.mNumColumns = this.mGridDimensionProvider.getNumColumns();
    this.mCellWidth = this.mGridDimensionProvider.getCellWidth();
    this.mCellHeight = this.mGridDimensionProvider.getCellHeight();
  }
  
  private void calculateOccupiedCells(List<PositionDelta> paramList)
  {
    int i = this.mNumColumns;
    int j = this.mNumRows;
    this.mOccupied = ((boolean[][])Array.newInstance(Boolean.TYPE, new int[] { i, j }));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      markCellsForDelta((PositionDelta)paramList.next(), true);
    }
  }
  
  private boolean findDeltas(PositionDelta paramPositionDelta, List<PositionDelta> paramList1, List<PositionDelta> paramList2, boolean paramBoolean)
  {
    paramList2.clear();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      PositionDelta localPositionDelta = (PositionDelta)paramList1.next();
      if ((!paramBoolean) || (localPositionDelta.overlaps(paramPositionDelta))) {
        this.tmpForSort.add(localPositionDelta);
      }
    }
    paramPositionDelta = this.tmpForSort.iterator();
    while (paramPositionDelta.hasNext())
    {
      paramList1 = (PositionDelta)paramPositionDelta.next();
      if ((!paramList1.shrinkable()) && ((paramList1.getSpanX() > 1) || (paramList1.getSpanY() > 1))) {
        paramList2.add(paramList1);
      }
    }
    paramPositionDelta = this.tmpForSort.iterator();
    while (paramPositionDelta.hasNext())
    {
      paramList1 = (PositionDelta)paramPositionDelta.next();
      if ((paramList1.getSpanX() == 1) && (paramList1.getSpanY() == 1)) {
        paramList2.add(paramList1);
      }
    }
    paramPositionDelta = this.tmpForSort.iterator();
    while (paramPositionDelta.hasNext())
    {
      paramList1 = (PositionDelta)paramPositionDelta.next();
      if ((paramList1.shrinkable()) && ((paramList1.getSpanX() > 1) || (paramList1.getSpanY() > 1))) {
        paramList2.add(paramList1);
      }
    }
    this.tmpForSort.clear();
    return !paramList2.isEmpty();
  }
  
  private boolean findNearestArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, WidgetSizes paramWidgetSizes, boolean paramBoolean, int[] paramArrayOfInt)
  {
    if ((paramBoolean) && (paramInt3 == 1) && (paramInt4 == 1))
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt2;
      return true;
    }
    float f2 = Float.MAX_VALUE;
    int k = 0;
    while (k < this.mNumRows - (paramInt4 - 1))
    {
      int i = 0;
      if (i < this.mNumColumns - (paramInt3 - 1))
      {
        int j;
        label73:
        int m;
        label82:
        float f1;
        if (!paramBoolean)
        {
          j = 0;
          if (j < paramInt3)
          {
            m = 0;
            if (m < paramInt4) {
              if ((paramWidgetSizes != null) && (paramWidgetSizes.getAvailableSizeCount() > 0) && (!paramWidgetSizes.isAvailableSize(j + 1, m + 1)))
              {
                j = i + j;
                f1 = f2;
              }
            }
          }
        }
        label175:
        do
        {
          float f3;
          do
          {
            for (;;)
            {
              i = j + 1;
              f2 = f1;
              break;
              if (this.mOccupied[(i + j)][(k + m)] == 0) {
                break label175;
              }
              j = i + j;
              f1 = f2;
            }
            m += 1;
            break label82;
            j += 1;
            break label73;
            f3 = Math.abs(i - paramInt1) * this.mCellWidth + Math.abs(k - paramInt2) * this.mCellHeight;
            f1 = f2;
            j = i;
          } while (f3 > f2);
          f2 = f3;
          paramArrayOfInt[0] = i;
          paramArrayOfInt[1] = k;
          f1 = f2;
          j = i;
        } while (f2 != 0.0F);
        return true;
      }
      k += 1;
    }
    return f2 != Float.MAX_VALUE;
  }
  
  private boolean isDeltaValid(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt2 >= 0);
  }
  
  private void markCellsForDelta(PositionDelta paramPositionDelta, boolean paramBoolean)
  {
    int n = this.mLayout.getCountX();
    int i1 = this.mLayout.getCountY();
    int k = paramPositionDelta.getX();
    int m = paramPositionDelta.getY();
    int i2 = paramPositionDelta.getSpanX();
    int i3 = paramPositionDelta.getSpanY();
    if (isDeltaValid(k, m))
    {
      int i = k;
      while ((i < k + i2) && (i < n))
      {
        int j = m;
        while ((j < m + i3) && (j < i1))
        {
          this.mOccupied[i][j] = paramBoolean;
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private boolean quickCheckEnoughSpace(int paramInt)
  {
    int j = 0;
    int i = 0;
    while (i < this.mNumColumns)
    {
      int k = 0;
      while (k < this.mNumRows)
      {
        int m = j;
        if (this.mOccupied[i][k] == 0)
        {
          j += 1;
          m = j;
          if (j >= paramInt) {
            return true;
          }
        }
        k += 1;
        j = m;
      }
      i += 1;
    }
    return false;
  }
  
  private void resetDeltas()
  {
    this.mDeltas.clear();
    this.mDeltaProvider.getDeltas(this.mDeltas);
    int i;
    if (this.mDragDelta != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.mDeltas.size())
      {
        if (((PositionDelta)this.mDeltas.get(i)).item == this.mDragDelta.item) {
          this.mDeltas.remove(i);
        }
      }
      else
      {
        calculateOccupiedCells(this.mDeltas);
        return;
      }
      i += 1;
    }
  }
  
  private boolean shiftDeltas(PositionDelta paramPositionDelta, boolean paramBoolean)
  {
    this.tmpShiftDeltas.clear();
    Object localObject = this.mDeltas.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PositionDelta localPositionDelta = (PositionDelta)((Iterator)localObject).next();
      this.tmpShiftDeltas.add(new PositionDelta(localPositionDelta));
    }
    if (findDeltas(paramPositionDelta, this.tmpShiftDeltas, this.tmpSortedDeltas, paramBoolean))
    {
      calculateOccupiedCells(this.mDeltas);
      localObject = this.tmpSortedDeltas.iterator();
      while (((Iterator)localObject).hasNext()) {
        markCellsForDelta((PositionDelta)((Iterator)localObject).next(), false);
      }
      markCellsForDelta(paramPositionDelta, true);
      toRect(this.tmpRect, this.tmpSortedDeltas);
      int i;
      int j;
      int k;
      int m;
      if (findNearestArea(this.tmpRect[0], this.tmpRect[1], this.tmpRect[2], this.tmpRect[3], null, false, this.tmpXY))
      {
        i = this.tmpXY[0];
        j = this.tmpRect[0];
        k = this.tmpXY[1];
        m = this.tmpRect[1];
        paramPositionDelta = this.tmpSortedDeltas.iterator();
        while (paramPositionDelta.hasNext())
        {
          localObject = (PositionDelta)paramPositionDelta.next();
          ((PositionDelta)localObject).setX(((PositionDelta)localObject).getX() + (i - j));
          ((PositionDelta)localObject).setY(((PositionDelta)localObject).getY() + (k - m));
          markCellsForDelta((PositionDelta)localObject, true);
        }
      }
      paramPositionDelta = this.tmpSortedDeltas.iterator();
      if (paramPositionDelta.hasNext())
      {
        localObject = (PositionDelta)paramPositionDelta.next();
        int i1;
        if (!findNearestArea(((PositionDelta)localObject).getX(), ((PositionDelta)localObject).getY(), ((PositionDelta)localObject).getSpanX(), ((PositionDelta)localObject).getSpanY(), ((PositionDelta)localObject).getSupportWidgetSizes(), false, this.tmpXY))
        {
          if ((!this.mShrinkingEnabled) || (!((PositionDelta)localObject).shrinkable())) {
            return false;
          }
          m = ((PositionDelta)localObject).getSpanX();
          k = ((PositionDelta)localObject).getSpanY();
          int n = ((PositionDelta)localObject).getMinSpanX();
          i1 = ((PositionDelta)localObject).getMinSpanY();
          for (;;)
          {
            if ((m > k) && (m > n))
            {
              j = m - 1;
              i = k;
              label408:
              m = j;
              k = i;
              if (findNearestArea(((PositionDelta)localObject).getX(), ((PositionDelta)localObject).getY(), j, i, ((PositionDelta)localObject).getSupportWidgetSizes(), false, this.tmpXY))
              {
                label445:
                k = i;
                if (j < ((PositionDelta)localObject).getSpanX())
                {
                  if (findNearestArea(((PositionDelta)localObject).getX(), ((PositionDelta)localObject).getY(), j + 1, i, ((PositionDelta)localObject).getSupportWidgetSizes(), false, this.tmpXY)) {
                    break label603;
                  }
                  k = i;
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((k >= ((PositionDelta)localObject).getSpanY()) || (!findNearestArea(((PositionDelta)localObject).getX(), ((PositionDelta)localObject).getY(), j, k + 1, ((PositionDelta)localObject).getSupportWidgetSizes(), false, this.tmpXY)))
          {
            ((PositionDelta)localObject).setSpanY(k);
            ((PositionDelta)localObject).setSpanX(j);
            ((PositionDelta)localObject).setX(this.tmpXY[0]);
            ((PositionDelta)localObject).setY(this.tmpXY[1]);
            markCellsForDelta((PositionDelta)localObject, true);
            break;
            if (k > i1)
            {
              i = k - 1;
              j = m;
              break label408;
            }
            return false;
            label603:
            j += 1;
            break label445;
          }
          k += 1;
        }
      }
    }
    this.mDeltas.clear();
    this.mDeltas.addAll(this.tmpShiftDeltas);
    return true;
  }
  
  private void toRect(int[] paramArrayOfInt, ArrayList<PositionDelta> paramArrayList)
  {
    paramArrayOfInt[0] = 100;
    paramArrayOfInt[1] = 100;
    paramArrayOfInt[2] = 0;
    paramArrayOfInt[3] = 0;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      PositionDelta localPositionDelta = (PositionDelta)paramArrayList.next();
      paramArrayOfInt[0] = Math.min(localPositionDelta.getX(), paramArrayOfInt[0]);
      paramArrayOfInt[1] = Math.min(localPositionDelta.getY(), paramArrayOfInt[1]);
      paramArrayOfInt[2] = Math.max(localPositionDelta.getX() + localPositionDelta.getSpanX(), paramArrayOfInt[2]);
      paramArrayOfInt[3] = Math.max(localPositionDelta.getY() + localPositionDelta.getSpanY(), paramArrayOfInt[3]);
    }
    paramArrayOfInt[2] -= paramArrayOfInt[0];
    paramArrayOfInt[3] -= paramArrayOfInt[1];
  }
  
  private boolean tryRearrange(boolean paramBoolean)
  {
    int k = this.mDragDelta.getSpanX();
    int m = this.mDragDelta.getSpanY();
    int n = this.tmpExactXY[0];
    int i1 = this.tmpExactXY[1];
    int i = 0;
    int j;
    int i2;
    if (i < this.directions.length)
    {
      j = n + this.directions[i][0];
      i2 = i1 + this.directions[i][1];
      if ((j >= 0) && (i2 >= 0) && (j + k <= this.mNumColumns) && (i2 + m <= this.mNumRows))
      {
        this.mDragDelta.setX(j);
        this.mDragDelta.setY(i2);
        if (!shiftDeltas(this.mDragDelta, true)) {}
      }
    }
    do
    {
      return true;
      if (!paramBoolean)
      {
        if (!quickCheckEnoughSpace(k * m)) {
          return false;
        }
      }
      else
      {
        i += 1;
        break;
      }
      i = 0;
      if (i >= this.directions.length) {
        break label259;
      }
      j = n + this.directions[i][0];
      i2 = i1 + this.directions[i][1];
      if ((j < 0) || (i2 < 0) || (j + k > this.mNumColumns) || (i2 + m > this.mNumRows)) {
        break label255;
      }
      this.mDragDelta.setX(j);
      this.mDragDelta.setY(i2);
    } while (shiftDeltas(this.mDragDelta, false));
    label255:
    if (!paramBoolean) {
      label259:
      if (paramBoolean) {
        i = 0;
      }
    } else {
      for (;;)
      {
        if (i >= this.mNumColumns - k + 1) {
          break label374;
        }
        j = 0;
        label280:
        if (j < this.mNumRows - m + 1)
        {
          i2 = Math.abs(n - i);
          int i3 = Math.abs(i1 - j);
          if ((i2 < 2) && (i3 < 2)) {}
          do
          {
            j += 1;
            break label280;
            i += 1;
            break;
            this.mDragDelta.setX(i);
            this.mDragDelta.setY(j);
          } while (!shiftDeltas(this.mDragDelta, false));
          return true;
        }
        i += 1;
      }
    }
    label374:
    return false;
  }
  
  public void addDelta(PositionDelta paramPositionDelta)
  {
    this.mDeltas.add(paramPositionDelta);
    calculateOccupiedCells(this.mDeltas);
  }
  
  public PositionDelta deltaAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Iterator localIterator = this.mDeltas.iterator();
    while (localIterator.hasNext())
    {
      PositionDelta localPositionDelta = (PositionDelta)localIterator.next();
      int i = localPositionDelta.getX();
      int j = localPositionDelta.getY();
      if ((paramInt1 == i) && (paramInt2 == j)) {
        return localPositionDelta;
      }
      int k = localPositionDelta.getSpanX();
      int m = localPositionDelta.getSpanY();
      if ((paramInt1 + paramInt3 - 1 >= i) && (paramInt1 < i + k) && (paramInt2 + paramInt4 - 1 >= j) && (paramInt2 < j + m)) {
        return localPositionDelta;
      }
    }
    return null;
  }
  
  public int[] findNearestVacantArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    reset(true);
    if (!findNearestArea(paramInt1, paramInt2, paramInt3, paramInt4, null, false, paramArrayOfInt))
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
    }
    return paramArrayOfInt;
  }
  
  public List<PositionDelta> getDeltas()
  {
    return this.mDeltas;
  }
  
  public PositionDelta getDragDelta()
  {
    if (this.mDragDelta == null) {
      return null;
    }
    return new PositionDelta(this.mDragDelta);
  }
  
  public void removeDelta(PositionDelta paramPositionDelta)
  {
    this.mDeltas.remove(paramPositionDelta);
    calculateOccupiedCells(this.mDeltas);
  }
  
  public void reset(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mDragDelta = null;
    }
    resetDeltas();
  }
  
  public void resetDragDelta()
  {
    this.mDragDelta = null;
  }
  
  public boolean updateDeltasForDrag(PositionDelta paramPositionDelta, WidgetSizes paramWidgetSizes, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mDragDelta = paramPositionDelta;
    this.mShrinkingEnabled = paramBoolean1;
    this.tmpRollback.clear();
    this.tmpRollback.addAll(this.mDeltas);
    resetDeltas();
    this.mCellWidth = this.mGridDimensionProvider.getCellWidth();
    this.mCellHeight = this.mGridDimensionProvider.getCellHeight();
    int n = paramPositionDelta.getSpanX();
    int i1 = paramPositionDelta.getSpanY();
    int i2 = paramPositionDelta.getX();
    int i3 = paramPositionDelta.getY();
    if ((n < 1) || (i1 < 1)) {
      throw new IllegalArgumentException("span must be at least 1! spanX: " + n + "   spanY: " + i1);
    }
    if (findNearestArea(i2, i3, n, i1, null, true, this.tmpExactXY))
    {
      this.mDragDelta.setX(this.tmpExactXY[0]);
      this.mDragDelta.setY(this.tmpExactXY[1]);
      if ((findNearestArea(i2, i3, n, i1, null, paramBoolean3, this.tmpXY)) && (this.tmpExactXY[0] == this.tmpXY[0]) && (this.tmpExactXY[1] == this.tmpXY[1]))
      {
        this.tmpRollback.clear();
        return true;
      }
      if (tryRearrange(paramBoolean2))
      {
        tryRearrange(paramBoolean2);
        this.tmpRollback.clear();
        return true;
      }
    }
    int k = n;
    int j = i1;
    if ((k > paramInt1) || (j > paramInt2))
    {
      int i;
      int m;
      if ((k > j) && (k > paramInt1))
      {
        i = k - 1;
        m = j;
      }
      for (;;)
      {
        if ((paramWidgetSizes != null) && (paramWidgetSizes.getAvailableSizeCount() > 0))
        {
          k = i;
          j = m;
          if (!paramWidgetSizes.isAvailableSize(i, m)) {
            break;
          }
        }
        k = i;
        j = m;
        if (!findNearestArea(i2, i3, i, m, null, true, this.tmpExactXY)) {
          break;
        }
        this.mDragDelta.setSpanX(i);
        this.mDragDelta.setSpanY(m);
        k = i;
        j = m;
        if (!tryRearrange(paramBoolean2)) {
          break;
        }
        tryRearrange(paramBoolean2);
        this.tmpRollback.clear();
        return true;
        if (j > paramInt2)
        {
          m = j - 1;
          i = k;
        }
        else
        {
          if (k <= paramInt1) {
            break label472;
          }
          i = k - 1;
          m = j;
        }
      }
      label472:
      throw new IllegalStateException();
    }
    this.mDragDelta.setX(i2);
    this.mDragDelta.setY(i3);
    this.mDragDelta.setSpanX(n);
    this.mDragDelta.setSpanY(i1);
    this.mDeltas.clear();
    this.mDeltas.addAll(this.tmpRollback);
    this.tmpRollback.clear();
    return false;
  }
  
  public static abstract interface DeltaProvider
  {
    public abstract void getDeltas(List<PositionDelta> paramList);
  }
  
  public static abstract interface GridDimensionProvider
  {
    public abstract int getCellHeight();
    
    public abstract int getCellWidth();
    
    public abstract int getNumColumns();
    
    public abstract int getNumRows();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CellPositionerWorkspace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */