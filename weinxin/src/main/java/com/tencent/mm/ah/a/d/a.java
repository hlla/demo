package com.tencent.mm.ah.a.d;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import java.util.Map;

public final class a<K, V>
{
  private f<K, V> hIY;
  
  public a(int paramInt)
  {
    GMTrace.i(13721883639808L, 102236);
    this.hIY = new f(paramInt);
    GMTrace.o(13721883639808L, 102236);
  }
  
  public final void clear()
  {
    GMTrace.i(13722017857536L, 102237);
    if (this.hIY == null) {
      throw new NullPointerException("mData == null");
    }
    this.hIY.trimToSize(-1);
    GMTrace.o(13722017857536L, 102237);
  }
  
  public final V get(K paramK)
  {
    GMTrace.i(13722152075264L, 102238);
    if (this.hIY == null) {
      throw new NullPointerException("mData == null");
    }
    paramK = this.hIY.get(paramK);
    GMTrace.o(13722152075264L, 102238);
    return paramK;
  }
  
  public final V put(K paramK, V paramV)
  {
    GMTrace.i(13722286292992L, 102239);
    if (this.hIY == null) {
      throw new NullPointerException("mData == null");
    }
    paramK = this.hIY.put(paramK, paramV);
    GMTrace.o(13722286292992L, 102239);
    return paramK;
  }
  
  public final Map<K, V> snapshot()
  {
    try
    {
      GMTrace.i(13722420510720L, 102240);
      if (this.hIY == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    Map localMap = this.hIY.snapshot();
    GMTrace.o(13722420510720L, 102240);
    return localMap;
  }
  
  public final String toString()
  {
    try
    {
      GMTrace.i(13722554728448L, 102241);
      if (this.hIY == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    String str = this.hIY.toString();
    GMTrace.o(13722554728448L, 102241);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/a/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */