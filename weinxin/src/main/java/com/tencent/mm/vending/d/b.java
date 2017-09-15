package com.tencent.mm.vending.d;

import com.tencent.gmtrace.GMTrace;
import java.util.ArrayList;
import java.util.List;

public final class b<T>
{
  private volatile List<T> wAz;
  
  public b(List paramList)
  {
    GMTrace.i(276085866496L, 2057);
    this.wAz = paramList;
    GMTrace.o(276085866496L, 2057);
  }
  
  public final T get(int paramInt)
  {
    GMTrace.i(276354301952L, 2059);
    Object localObject = this.wAz.get(paramInt);
    GMTrace.o(276354301952L, 2059);
    return (T)localObject;
  }
  
  public final int size()
  {
    GMTrace.i(276220084224L, 2058);
    int i = this.wAz.size();
    GMTrace.o(276220084224L, 2058);
    return i;
  }
  
  public static final class a<T>
  {
    private ArrayList<T> wAA;
    
    public a()
    {
      GMTrace.i(275548995584L, 2053);
      this.wAA = new ArrayList();
      GMTrace.o(275548995584L, 2053);
    }
    
    private void bDy()
    {
      GMTrace.i(275683213312L, 2054);
      if (this.wAA == null) {
        throw new IllegalAccessError();
      }
      GMTrace.o(275683213312L, 2054);
    }
    
    public final b<T> cbp()
    {
      GMTrace.i(275951648768L, 2056);
      bDy();
      Object localObject = this.wAA;
      this.wAA = null;
      localObject = new b((List)localObject);
      GMTrace.o(275951648768L, 2056);
      return (b<T>)localObject;
    }
    
    public final a<T> r(T... paramVarArgs)
    {
      GMTrace.i(275817431040L, 2055);
      bDy();
      int i = 0;
      while (i <= 0)
      {
        T ? = paramVarArgs[0];
        this.wAA.add(?);
        i += 1;
      }
      GMTrace.o(275817431040L, 2055);
      return this;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/vending/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */