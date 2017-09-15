package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.w;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class e<T>
  implements Iterator<T>
{
  protected final b<T> aoS;
  protected int aoT;
  
  public e(b<T> paramb)
  {
    this.aoS = ((b)w.Z(paramb));
    this.aoT = -1;
  }
  
  public final boolean hasNext()
  {
    return this.aoT < this.aoS.getCount() - 1;
  }
  
  public final T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.aoT);
    }
    b localb = this.aoS;
    int i = this.aoT + 1;
    this.aoT = i;
    return (T)localb.get(i);
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/data/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */