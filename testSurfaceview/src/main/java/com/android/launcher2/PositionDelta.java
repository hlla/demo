package com.android.launcher2;

public class PositionDelta
{
  final BaseItem item;
  private boolean mChanged = false;
  private WidgetSizes mSupportWidgetSizes = null;
  private final int minSpanX;
  private final int minSpanY;
  private final int ospanX;
  private final int ospanY;
  private final int ox;
  private final int oy;
  private int spanX;
  private int spanY;
  private int x;
  private int y;
  
  public PositionDelta()
  {
    this.item = null;
    this.ox = 0;
    this.oy = 0;
    this.spanY = 1;
    this.spanX = 1;
    this.ospanY = 1;
    this.ospanX = 1;
    this.minSpanY = 1;
    this.minSpanX = 1;
  }
  
  public PositionDelta(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.item = null;
    this.x = paramInt1;
    this.ox = paramInt1;
    this.y = paramInt2;
    this.oy = paramInt2;
    this.spanX = paramInt3;
    this.ospanX = paramInt3;
    this.minSpanX = paramInt3;
    this.spanY = paramInt4;
    this.ospanY = paramInt4;
    this.minSpanY = paramInt4;
  }
  
  public PositionDelta(BaseItem paramBaseItem)
  {
    this.item = paramBaseItem;
    int i;
    if ((paramBaseItem instanceof HomeItem))
    {
      i = ((HomeItem)paramBaseItem).cellX;
      this.x = i;
      this.ox = i;
      i = ((HomeItem)paramBaseItem).cellY;
      this.y = i;
      this.oy = i;
      i = paramBaseItem.getSpanX();
      this.spanX = i;
      this.ospanX = i;
      i = paramBaseItem.getSpanY();
      this.spanY = i;
      this.ospanY = i;
      if ((!(paramBaseItem instanceof HomeWidgetItem)) || (((HomeWidgetItem)paramBaseItem).resizeMode == 0)) {
        break label225;
      }
      Object localObject = (HomeWidgetItem)paramBaseItem;
      int j = ((HomeWidgetItem)localObject).resizeMode;
      localObject = ((HomeWidgetItem)localObject).getResizeSpans();
      if ((j & 0x1) == 0) {
        break label209;
      }
      i = localObject[0];
      label139:
      this.minSpanX = i;
      if ((j & 0x2) == 0) {
        break label217;
      }
      i = localObject[1];
    }
    label155:
    for (this.minSpanY = i;; this.minSpanY = this.spanY)
    {
      if ((BaseItem.isWidget(paramBaseItem)) && ((paramBaseItem instanceof HomeWidgetItem))) {
        this.mSupportWidgetSizes = ((HomeWidgetItem)paramBaseItem).getSupportWidgetSizes();
      }
      return;
      this.x = 0;
      this.ox = 0;
      this.y = 0;
      this.oy = 0;
      break;
      label209:
      i = this.spanX;
      break label139;
      label217:
      i = this.spanY;
      break label155;
      label225:
      this.minSpanX = this.spanX;
    }
  }
  
  public PositionDelta(PositionDelta paramPositionDelta)
  {
    this.item = paramPositionDelta.item;
    this.x = paramPositionDelta.x;
    this.y = paramPositionDelta.y;
    this.ox = paramPositionDelta.ox;
    this.oy = paramPositionDelta.oy;
    this.spanX = paramPositionDelta.spanX;
    this.spanY = paramPositionDelta.spanY;
    this.ospanX = paramPositionDelta.ospanX;
    this.ospanY = paramPositionDelta.ospanY;
    this.mChanged = paramPositionDelta.mChanged;
    this.minSpanX = paramPositionDelta.minSpanX;
    this.minSpanY = paramPositionDelta.minSpanY;
    this.mSupportWidgetSizes = paramPositionDelta.mSupportWidgetSizes;
  }
  
  private void updateChanged()
  {
    if ((this.x != this.ox) || (this.y != this.oy) || (this.spanX != this.ospanX) || (this.spanY != this.ospanY)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mChanged = bool;
      return;
    }
  }
  
  public boolean changed()
  {
    return this.mChanged;
  }
  
  public boolean differentFrom(PositionDelta paramPositionDelta)
  {
    return (this.x != paramPositionDelta.x) || (this.y != paramPositionDelta.y) || (this.spanX != paramPositionDelta.spanX) || (this.spanY != paramPositionDelta.spanY);
  }
  
  int getMinSpanX()
  {
    return this.minSpanX;
  }
  
  int getMinSpanY()
  {
    return this.minSpanY;
  }
  
  int getSpanX()
  {
    return this.spanX;
  }
  
  int getSpanY()
  {
    return this.spanY;
  }
  
  public WidgetSizes getSupportWidgetSizes()
  {
    return this.mSupportWidgetSizes;
  }
  
  int getX()
  {
    return this.x;
  }
  
  int getY()
  {
    return this.y;
  }
  
  public boolean hasSupportWidgetSize()
  {
    return (this.mSupportWidgetSizes != null) && (this.mSupportWidgetSizes.getAvailableSizeCount() > 0);
  }
  
  boolean overlaps(PositionDelta paramPositionDelta)
  {
    int i = paramPositionDelta.getX();
    int j = paramPositionDelta.getY();
    int k = paramPositionDelta.getSpanX();
    int m = paramPositionDelta.getSpanY();
    return (this.x + this.spanX - 1 >= i) && (this.x <= i + k - 1) && (this.y + this.spanY - 1 >= j) && (this.y <= j + m - 1);
  }
  
  void setSpanX(int paramInt)
  {
    this.spanX = paramInt;
    updateChanged();
  }
  
  void setSpanY(int paramInt)
  {
    this.spanY = paramInt;
    updateChanged();
  }
  
  void setX(int paramInt)
  {
    this.x = paramInt;
    updateChanged();
  }
  
  void setY(int paramInt)
  {
    this.y = paramInt;
    updateChanged();
  }
  
  public boolean shrinkable()
  {
    return (this.minSpanX < this.spanX) || (this.minSpanY < this.spanY);
  }
  
  public boolean spanChanged()
  {
    return (this.spanX != this.ospanX) || (this.spanY != this.ospanY);
  }
  
  public String toString()
  {
    return "PositionDelta(changed=" + this.mChanged + " x=" + this.x + " y=" + this.y + " spanX=" + this.spanX + " spanY=" + this.spanY + " ox=" + this.ox + " oy=" + this.oy + " ospanX=" + this.ospanX + " ospanY=" + this.ospanY + ")";
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/PositionDelta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */