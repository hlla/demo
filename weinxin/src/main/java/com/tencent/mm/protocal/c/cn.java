package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class cn
  extends ave
{
  public int jMq;
  public avt tea;
  
  public cn()
  {
    GMTrace.i(3803193540608L, 28336);
    GMTrace.o(3803193540608L, 28336);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3803327758336L, 28337);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tea == null) {
        throw new b("Not all required fields were included: ReqBuf");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.jMq);
      if (this.tea != null)
      {
        paramVarArgs.eQ(3, this.tea.aUd());
        this.tea.a(paramVarArgs);
      }
      GMTrace.o(3803327758336L, 28337);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.jMq);
      paramInt = i;
      if (this.tea != null) {
        paramInt = i + a.a.a.a.eN(3, this.tea.aUd());
      }
      GMTrace.o(3803327758336L, 28337);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tea == null) {
        throw new b("Not all required fields were included: ReqBuf");
      }
      GMTrace.o(3803327758336L, 28337);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      cn localcn = (cn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3803327758336L, 28337);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localcn.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3803327758336L, 28337);
        return 0;
      case 2: 
        localcn.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3803327758336L, 28337);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localcn.tea = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3803327758336L, 28337);
      return 0;
    }
    GMTrace.o(3803327758336L, 28337);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */