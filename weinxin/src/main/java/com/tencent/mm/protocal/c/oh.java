package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class oh
  extends avm
{
  public int jMq;
  public avt tsm;
  public int tsn;
  
  public oh()
  {
    GMTrace.i(3905735884800L, 29100);
    GMTrace.o(3905735884800L, 29100);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3905870102528L, 29101);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tsm == null) {
        throw new b("Not all required fields were included: PackageBuf");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tsm != null)
      {
        paramVarArgs.eQ(2, this.tsm.aUd());
        this.tsm.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.jMq);
      paramVarArgs.eO(4, this.tsn);
      GMTrace.o(3905870102528L, 29101);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt;
      if (this.tsm != null) {
        i = paramInt + a.a.a.a.eN(2, this.tsm.aUd());
      }
      paramInt = a.a.a.a.eL(3, this.jMq);
      int j = a.a.a.a.eL(4, this.tsn);
      GMTrace.o(3905870102528L, 29101);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tsm == null) {
        throw new b("Not all required fields were included: PackageBuf");
      }
      GMTrace.o(3905870102528L, 29101);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      oh localoh = (oh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3905870102528L, 29101);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localoh.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3905870102528L, 29101);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localoh.tsm = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3905870102528L, 29101);
        return 0;
      case 3: 
        localoh.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3905870102528L, 29101);
        return 0;
      }
      localoh.tsn = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3905870102528L, 29101);
      return 0;
    }
    GMTrace.o(3905870102528L, 29101);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/oh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */