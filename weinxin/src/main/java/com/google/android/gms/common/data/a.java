package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class a<T>
  implements b<T>
{
  public final DataHolder aoy;
  
  protected a(DataHolder paramDataHolder)
  {
    this.aoy = paramDataHolder;
    if (this.aoy != null) {
      this.aoy.aoK = this;
    }
  }
  
  public int getCount()
  {
    if (this.aoy == null) {
      return 0;
    }
    return this.aoy.aoJ;
  }
  
  public Iterator<T> iterator()
  {
    return new e(this);
  }
  
  public final void release()
  {
    if (this.aoy != null) {
      this.aoy.close();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/data/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */