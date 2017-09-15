package android.support.v4.e;

public final class h
{
  public static abstract interface a<T>
  {
    public abstract T bF();
    
    public abstract boolean i(T paramT);
  }
  
  public static class b<T>
    implements h.a<T>
  {
    private final Object[] wf;
    private int wg;
    
    public b(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("The max pool size must be > 0");
      }
      this.wf = new Object[paramInt];
    }
    
    public T bF()
    {
      if (this.wg > 0)
      {
        int i = this.wg - 1;
        Object localObject = this.wf[i];
        this.wf[i] = null;
        this.wg -= 1;
        return (T)localObject;
      }
      return null;
    }
    
    public boolean i(T paramT)
    {
      boolean bool = false;
      int i = 0;
      if (i < this.wg) {
        if (this.wf[i] != paramT) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label50;
        }
        throw new IllegalStateException("Already in the pool!");
        i += 1;
        break;
      }
      label50:
      if (this.wg < this.wf.length)
      {
        this.wf[this.wg] = paramT;
        this.wg += 1;
        bool = true;
      }
      return bool;
    }
  }
  
  public static final class c<T>
    extends h.b<T>
  {
    private final Object mLock = new Object();
    
    public c()
    {
      super();
    }
    
    public final T bF()
    {
      synchronized (this.mLock)
      {
        Object localObject2 = super.bF();
        return (T)localObject2;
      }
    }
    
    public final boolean i(T paramT)
    {
      synchronized (this.mLock)
      {
        boolean bool = super.i(paramT);
        return bool;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/e/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */