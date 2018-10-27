package android.support.v7.widget;

import android.database.Observable;
import java.util.ArrayList;

public final class ev
  extends Observable
{
  public final void a(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((ew)this.mObservers.get(i)).b(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((ew)this.mObservers.get(i)).a(paramInt1, paramInt2, paramObject);
      i -= 1;
    }
  }
  
  public final boolean a()
  {
    return this.mObservers.isEmpty() ^ true;
  }
  
  public final void b()
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((ew)this.mObservers.get(i)).a();
      i -= 1;
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((ew)this.mObservers.get(i)).c(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((ew)this.mObservers.get(i)).a(paramInt1, paramInt2, 1);
      i -= 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */