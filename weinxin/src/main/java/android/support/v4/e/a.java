package android.support.v4.e;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends i<K, V>
  implements Map<K, V>
{
  g<K, V> vO;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  private g<K, V> bz()
  {
    if (this.vO == null) {
      this.vO = new g()
      {
        protected final void O(int paramAnonymousInt)
        {
          a.this.removeAt(paramAnonymousInt);
        }
        
        protected final V a(int paramAnonymousInt, V paramAnonymousV)
        {
          return (V)a.this.setValueAt(paramAnonymousInt, paramAnonymousV);
        }
        
        protected final int bA()
        {
          return a.this.hP;
        }
        
        protected final Map<K, V> bB()
        {
          return a.this;
        }
        
        protected final void bC()
        {
          a.this.clear();
        }
        
        protected final void c(K paramAnonymousK, V paramAnonymousV)
        {
          a.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final int g(Object paramAnonymousObject)
        {
          return a.this.indexOfKey(paramAnonymousObject);
        }
        
        protected final int h(Object paramAnonymousObject)
        {
          return a.this.indexOfValue(paramAnonymousObject);
        }
        
        protected final Object k(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.wm[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
      };
    }
    return this.vO;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    g localg = bz();
    if (localg.vX == null) {
      localg.vX = new g.b(localg);
    }
    return localg.vX;
  }
  
  public Set<K> keySet()
  {
    g localg = bz();
    if (localg.vY == null) {
      localg.vY = new g.c(localg);
    }
    return localg.vY;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    int i = this.hP + paramMap.size();
    Object localObject;
    if (this.wl.length < i)
    {
      localObject = this.wl;
      Object[] arrayOfObject = this.wm;
      super.T(i);
      if (this.hP > 0)
      {
        System.arraycopy(localObject, 0, this.wl, 0, this.hP);
        System.arraycopy(arrayOfObject, 0, this.wm, 0, this.hP << 1);
      }
      i.a((int[])localObject, arrayOfObject, this.hP);
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject = (Map.Entry)paramMap.next();
      put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
    }
  }
  
  public Collection<V> values()
  {
    g localg = bz();
    if (localg.vZ == null) {
      localg.vZ = new g.e(localg);
    }
    return localg.vZ;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */