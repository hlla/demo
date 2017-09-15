package com.tencent.recovery.config;

import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.util.AttributeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Express
{
  public List<List<ExpressItem>> wNY = new ArrayList();
  
  public final void cX(List<ExpressItem> paramList)
  {
    this.wNY.add(paramList);
  }
  
  public final boolean cY(List<RecoveryStatusItem> paramList)
  {
    boolean bool2 = false;
    Iterator localIterator1 = this.wNY.iterator();
    for (;;)
    {
      boolean bool1 = bool2;
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((List)localIterator1.next()).iterator();
        ExpressItem localExpressItem;
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          localExpressItem = (ExpressItem)localIterator2.next();
          Iterator localIterator3 = paramList.iterator();
          i = 0;
          while (localIterator3.hasNext())
          {
            RecoveryStatusItem localRecoveryStatusItem = (RecoveryStatusItem)localIterator3.next();
            if ((AttributeUtil.ee(localExpressItem.wNX, localRecoveryStatusItem.wNX)) && (AttributeUtil.ee(localExpressItem.wNZ, localRecoveryStatusItem.wNZ)) && (AttributeUtil.ee(localExpressItem.wOa, localRecoveryStatusItem.wOa))) {
              i += 1;
            }
          }
        } while (localExpressItem.count <= i);
      }
      for (int i = 0; i != 0; i = 1)
      {
        bool1 = true;
        return bool1;
      }
    }
  }
  
  public String toString()
  {
    return this.wNY.toString();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/config/Express.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */