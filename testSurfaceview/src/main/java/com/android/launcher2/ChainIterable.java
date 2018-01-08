package com.android.launcher2;

import java.util.ArrayList;
import java.util.Iterator;

public class ChainIterable<T>
  implements Iterable<T>
{
  private Iterable<Iterable<T>> mIterables;
  
  public ChainIterable(Iterable<Iterable<T>> paramIterable)
  {
    this.mIterables = paramIterable;
  }
  
  public ChainIterable(Iterable<T> paramIterable1, Iterable<T> paramIterable2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramIterable1);
    localArrayList.add(paramIterable2);
    this.mIterables = localArrayList;
  }
  
  public Iterator<T> iterator()
  {
    return new ChainIterator();
  }
  
  private class ChainIterator
    implements Iterator<T>
  {
    private Iterator<T> mCurrent;
    private Iterator<Iterable<T>> mIterator = ChainIterable.this.mIterables.iterator();
    
    ChainIterator()
    {
      if (this.mIterator.hasNext()) {
        for (this.mCurrent = ((Iterable)this.mIterator.next()).iterator(); (!this.mCurrent.hasNext()) && (this.mIterator.hasNext()); this.mCurrent = ((Iterable)this.mIterator.next()).iterator()) {}
      }
    }
    
    public boolean hasNext()
    {
      return (this.mCurrent != null) && (this.mCurrent.hasNext());
    }
    
    public T next()
    {
      Object localObject = this.mCurrent.next();
      while ((!this.mCurrent.hasNext()) && (this.mIterator.hasNext())) {
        this.mCurrent = ((Iterable)this.mIterator.next()).iterator();
      }
      return (T)localObject;
    }
    
    public void remove() {}
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/ChainIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */