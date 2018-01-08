package com.android.launcher2;

import java.util.List;

public abstract interface CellPositioner
{
  public abstract void addDelta(PositionDelta paramPositionDelta);
  
  public abstract PositionDelta deltaAt(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @Deprecated
  public abstract int[] findNearestVacantArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);
  
  public abstract List<PositionDelta> getDeltas();
  
  public abstract void removeDelta(PositionDelta paramPositionDelta);
  
  public abstract void reset(boolean paramBoolean);
  
  public abstract void resetDragDelta();
  
  public abstract boolean updateDeltasForDrag(PositionDelta paramPositionDelta, WidgetSizes paramWidgetSizes, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/CellPositioner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */