package com.android.launcher2;

import java.util.List;

public class CellPositionerNoGap
  implements CellPositioner
{
  private final CellLayout mLayout;
  
  public CellPositionerNoGap(CellLayout paramCellLayout)
  {
    this.mLayout = paramCellLayout;
  }
  
  public void addDelta(PositionDelta paramPositionDelta) {}
  
  public PositionDelta deltaAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  public int[] findNearestVacantArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {}
    for (;;)
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt2;
      return paramArrayOfInt;
      paramArrayOfInt = new int[2];
    }
  }
  
  public List<PositionDelta> getDeltas()
  {
    return null;
  }
  
  public void removeDelta(PositionDelta paramPositionDelta) {}
  
  public void reset(boolean paramBoolean) {}
  
  public void resetDragDelta() {}
  
  public boolean updateDeltasForDrag(PositionDelta paramPositionDelta, WidgetSizes paramWidgetSizes, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return true;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CellPositionerNoGap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */