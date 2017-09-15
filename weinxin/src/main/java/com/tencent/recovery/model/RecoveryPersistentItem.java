package com.tencent.recovery.model;

import android.os.Parcelable;

public abstract class RecoveryPersistentItem
  implements Parcelable
{
  public abstract boolean UU(String paramString);
  
  public abstract String cdp();
  
  public String toString()
  {
    return cdp();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/recovery/model/RecoveryPersistentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */