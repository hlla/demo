package com.android.launcher2;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public class ChildIterable<T extends View>
  implements Iterable<T>
{
  private ViewGroup mView;
  
  public ChildIterable(ViewGroup paramViewGroup)
  {
    this.mView = paramViewGroup;
  }
  
  public Iterator<T> iterator()
  {
    return new ChildIterator(null);
  }
  
  private class ChildIterator<T>
    implements Iterator<T>
  {
    int mIndex = 0;
    
    private ChildIterator() {}
    
    public boolean hasNext()
    {
      return this.mIndex < ChildIterable.this.mView.getChildCount();
    }
    
    public T next()
    {
      View localView = ChildIterable.this.mView.getChildAt(this.mIndex);
      this.mIndex += 1;
      return localView;
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/ChildIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */