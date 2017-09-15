package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class kw
  extends com.tencent.mm.bd.a
{
  public LinkedList<avl> tpF;
  
  public kw()
  {
    GMTrace.i(4000627818496L, 29807);
    this.tpF = new LinkedList();
    GMTrace.o(4000627818496L, 29807);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4000762036224L, 29808);
    if (paramInt == 0)
    {
      ((a.a.a.c.a)paramVarArgs[0]).d(1, 8, this.tpF);
      GMTrace.o(4000762036224L, 29808);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.c(1, 8, this.tpF);
      GMTrace.o(4000762036224L, 29808);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tpF.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4000762036224L, 29808);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      kw localkw = (kw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4000762036224L, 29808);
        return -1;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avl();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((avl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localkw.tpF.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(4000762036224L, 29808);
      return 0;
    }
    GMTrace.o(4000762036224L, 29808);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/kw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */