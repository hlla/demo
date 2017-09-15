package com.google.android.gms.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class m<K, V>
  extends q<K, V>
  implements Map<K, V>
{
  p<K, V> azZ;
  
  private p<K, V> kT()
  {
    if (this.azZ == null) {
      this.azZ = new p()
      {
        protected final void O(int paramAnonymousInt)
        {
          m.this.removeAt(paramAnonymousInt);
        }
        
        protected final V a(int paramAnonymousInt, V paramAnonymousV)
        {
          m localm = m.this;
          paramAnonymousInt = (paramAnonymousInt << 1) + 1;
          Object localObject = localm.wm[paramAnonymousInt];
          localm.wm[paramAnonymousInt] = paramAnonymousV;
          return (V)localObject;
        }
        
        protected final int bA()
        {
          return m.this.hP;
        }
        
        protected final Map<K, V> bB()
        {
          return m.this;
        }
        
        protected final void bC()
        {
          m.this.clear();
        }
        
        protected final void c(K paramAnonymousK, V paramAnonymousV)
        {
          m.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final int g(Object paramAnonymousObject)
        {
          if (paramAnonymousObject == null) {
            return m.this.bG();
          }
          return m.this.indexOf(paramAnonymousObject, paramAnonymousObject.hashCode());
        }
        
        protected final int h(Object paramAnonymousObject)
        {
          return m.this.indexOfValue(paramAnonymousObject);
        }
        
        protected final Object k(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return m.this.wm[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
      };
    }
    return this.azZ;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    p localp = kT();
    if (localp.aAh == null) {
      localp.aAh = new p.b(localp);
    }
    return localp.aAh;
  }
  
  public Set<K> keySet()
  {
    p localp = kT();
    if (localp.aAi == null) {
      localp.aAi = new p.c(localp);
    }
    return localp.aAi;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    int i = this.hP + paramMap.size();
    Object localObject;
    if (this.wl.length < i)
    {
      localObject = this.wl;
      Object[] arrayOfObject = this.wm;
      super.bZ(i);
      if (this.hP > 0)
      {
        System.arraycopy(localObject, 0, this.wl, 0, this.hP);
        System.arraycopy(arrayOfObject, 0, this.wm, 0, this.hP << 1);
      }
      q.b((int[])localObject, arrayOfObject, this.hP);
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
    p localp = kT();
    if (localp.aAj == null) {
      localp.aAj = new p.e(localp);
    }
    return localp.aAj;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */