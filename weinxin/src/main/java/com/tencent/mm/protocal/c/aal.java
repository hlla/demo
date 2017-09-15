package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aal
  extends ave
{
  public int mse;
  public int tEI;
  
  public aal()
  {
    GMTrace.i(3872047235072L, 28849);
    GMTrace.o(3872047235072L, 28849);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3872181452800L, 28850);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.mse);
      paramVarArgs.eO(3, this.tEI);
      GMTrace.o(3872181452800L, 28850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.mse);
      int j = a.a.a.a.eL(3, this.tEI);
      GMTrace.o(3872181452800L, 28850);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3872181452800L, 28850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aal localaal = (aal)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3872181452800L, 28850);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localaal.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3872181452800L, 28850);
        return 0;
      case 2: 
        localaal.mse = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3872181452800L, 28850);
        return 0;
      }
      localaal.tEI = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3872181452800L, 28850);
      return 0;
    }
    GMTrace.o(3872181452800L, 28850);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */