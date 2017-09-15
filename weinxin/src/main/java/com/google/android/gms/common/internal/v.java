package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class v
{
  public static a Y(Object paramObject)
  {
    return new a(paramObject);
  }
  
  public static boolean d(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static final class a
  {
    private final List<String> arj;
    private final Object ark;
    
    public a(Object paramObject)
    {
      this.ark = w.Z(paramObject);
      this.arj = new ArrayList();
    }
    
    public final a h(String paramString, Object paramObject)
    {
      this.arj.add((String)w.Z(paramString) + "=" + String.valueOf(paramObject));
      return this;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100).append(this.ark.getClass().getSimpleName()).append('{');
      int j = this.arj.size();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)this.arj.get(i));
        if (i < j - 1) {
          localStringBuilder.append(", ");
        }
        i += 1;
      }
      return '}';
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */