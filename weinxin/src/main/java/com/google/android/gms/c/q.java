package com.google.android.gms.c;

import java.util.Map;

public class q<K, V>
{
  static Object[] wh;
  static int wi;
  static Object[] wj;
  static int wk;
  int hP = 0;
  int[] wl = n.vQ;
  Object[] wm = n.vS;
  
  static void b(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (wk < 10)
        {
          paramArrayOfObject[0] = wj;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label117;
          wj = paramArrayOfObject;
          wk += 1;
        }
        return;
      }
      finally {}
    }
    if (paramArrayOfInt.length == 4) {}
    for (;;)
    {
      try
      {
        if (wi < 10)
        {
          paramArrayOfObject[0] = wh;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          wh = paramArrayOfObject;
          wi += 1;
        }
        return;
      }
      finally {}
      label117:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      return;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private K keyAt(int paramInt)
  {
    return (K)this.wm[(paramInt << 1)];
  }
  
  private V valueAt(int paramInt)
  {
    return (V)this.wm[((paramInt << 1) + 1)];
  }
  
  final int bG()
  {
    int m = this.hP;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = n.a(this.wl, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.wm[(j << 1)] == null);
    int k = j + 1;
    while ((k < m) && (this.wl[k] == 0))
    {
      if (this.wm[(k << 1)] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.wl[j] != 0)) {
        break label121;
      }
      i = j;
      if (this.wm[(j << 1)] == null) {
        break;
      }
      j -= 1;
    }
    label121:
    return k ^ 0xFFFFFFFF;
  }
  
  final void bZ(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (wj != null)
        {
          Object[] arrayOfObject1 = wj;
          this.wm = arrayOfObject1;
          wj = (Object[])arrayOfObject1[0];
          this.wl = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          wk -= 1;
          return;
        }
        this.wl = new int[paramInt];
        this.wm = new Object[paramInt << 1];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (wh != null)
          {
            Object[] arrayOfObject2 = wh;
            this.wm = arrayOfObject2;
            wh = (Object[])arrayOfObject2[0];
            this.wl = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            wi -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  public void clear()
  {
    if (this.hP != 0)
    {
      b(this.wl, this.wm, this.hP);
      this.wl = n.vQ;
      this.wm = n.vS;
      this.hP = 0;
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    if (paramObject == null) {
      if (bG() < 0) {}
    }
    while (indexOf(paramObject, paramObject.hashCode()) >= 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return indexOfValue(paramObject) >= 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Map))
      {
        paramObject = (Map)paramObject;
        if (size() != ((Map)paramObject).size()) {
          return false;
        }
        int i = 0;
        try
        {
          while (i < this.hP)
          {
            Object localObject1 = keyAt(i);
            Object localObject2 = valueAt(i);
            Object localObject3 = ((Map)paramObject).get(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null) {
                break label121;
              }
              if (!((Map)paramObject).containsKey(localObject1)) {
                break label121;
              }
            }
            else
            {
              boolean bool = localObject2.equals(localObject3);
              if (!bool) {
                return false;
              }
            }
            i += 1;
          }
          return false;
        }
        catch (NullPointerException paramObject)
        {
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
      }
    }
    label121:
    return false;
  }
  
  public V get(Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = bG(); i >= 0; i = indexOf(paramObject, paramObject.hashCode())) {
      return (V)this.wm[((i << 1) + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.wl;
    Object[] arrayOfObject = this.wm;
    int n = this.hP;
    int i = 1;
    int j = 0;
    int k = 0;
    if (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      if (localObject == null) {}
      for (int m = 0;; m = localObject.hashCode())
      {
        k += (m ^ i1);
        j += 1;
        i += 2;
        break;
      }
    }
    return k;
  }
  
  final int indexOf(Object paramObject, int paramInt)
  {
    int m = this.hP;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = n.a(this.wl, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.wm[(j << 1)]));
    int k = j + 1;
    while ((k < m) && (this.wl[k] == paramInt))
    {
      if (paramObject.equals(this.wm[(k << 1)])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.wl[j] != paramInt)) {
        break label156;
      }
      i = j;
      if (paramObject.equals(this.wm[(j << 1)])) {
        break;
      }
      j -= 1;
    }
    label156:
    return k ^ 0xFFFFFFFF;
  }
  
  final int indexOfValue(Object paramObject)
  {
    int i = 1;
    int j = 1;
    int k = this.hP * 2;
    Object[] arrayOfObject = this.wm;
    if (paramObject == null)
    {
      i = j;
      while (i < k)
      {
        if (arrayOfObject[i] == null) {
          return i >> 1;
        }
        i += 2;
      }
    }
    do
    {
      i += 2;
      if (i >= k) {
        break;
      }
    } while (!paramObject.equals(arrayOfObject[i]));
    return i >> 1;
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.hP <= 0;
  }
  
  public V put(K paramK, V paramV)
  {
    int k = 8;
    int i;
    int j;
    if (paramK == null)
    {
      i = bG();
      j = 0;
    }
    while (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.wm[i];
      this.wm[i] = paramV;
      return paramK;
      j = paramK.hashCode();
      i = indexOf(paramK, j);
    }
    int m = i ^ 0xFFFFFFFF;
    if (this.hP >= this.wl.length)
    {
      if (this.hP < 8) {
        break label267;
      }
      i = this.hP + (this.hP >> 1);
    }
    for (;;)
    {
      int[] arrayOfInt = this.wl;
      Object[] arrayOfObject = this.wm;
      bZ(i);
      if (this.wl.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.wl, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.wm, 0, arrayOfObject.length);
      }
      b(arrayOfInt, arrayOfObject, this.hP);
      if (m < this.hP)
      {
        System.arraycopy(this.wl, m, this.wl, m + 1, this.hP - m);
        System.arraycopy(this.wm, m << 1, this.wm, m + 1 << 1, this.hP - m << 1);
      }
      this.wl[m] = j;
      this.wm[(m << 1)] = paramK;
      this.wm[((m << 1) + 1)] = paramV;
      this.hP += 1;
      return null;
      label267:
      i = k;
      if (this.hP < 4) {
        i = 4;
      }
    }
  }
  
  public V remove(Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = bG(); i >= 0; i = indexOf(paramObject, paramObject.hashCode())) {
      return (V)removeAt(i);
    }
    return null;
  }
  
  public final V removeAt(int paramInt)
  {
    int i = 8;
    Object localObject = this.wm[((paramInt << 1) + 1)];
    if (this.hP <= 1)
    {
      b(this.wl, this.wm, this.hP);
      this.wl = n.vQ;
      this.wm = n.vS;
      this.hP = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return (V)localObject;
      if ((this.wl.length <= 8) || (this.hP >= this.wl.length / 3)) {
        break;
      }
      if (this.hP > 8) {
        i = this.hP + (this.hP >> 1);
      }
      arrayOfInt = this.wl;
      arrayOfObject = this.wm;
      bZ(i);
      this.hP -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.wl, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.wm, 0, paramInt << 1);
      }
    } while (paramInt >= this.hP);
    System.arraycopy(arrayOfInt, paramInt + 1, this.wl, paramInt, this.hP - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.wm, paramInt << 1, this.hP - paramInt << 1);
    return (V)localObject;
    this.hP -= 1;
    if (paramInt < this.hP)
    {
      System.arraycopy(this.wl, paramInt + 1, this.wl, paramInt, this.hP - paramInt);
      System.arraycopy(this.wm, paramInt + 1 << 1, this.wm, paramInt << 1, this.hP - paramInt << 1);
    }
    this.wm[(this.hP << 1)] = null;
    this.wm[((this.hP << 1) + 1)] = null;
    return (V)localObject;
  }
  
  public int size()
  {
    return this.hP;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.hP * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.hP)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = keyAt(i);
      if (localObject != this)
      {
        localStringBuilder.append(localObject);
        label70:
        localStringBuilder.append('=');
        localObject = valueAt(i);
        if (localObject == this) {
          break label111;
        }
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
        break label70;
        label111:
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */