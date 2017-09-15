package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bhm
  extends avm
{
  public int the;
  public avt ufp;
  
  public bhm()
  {
    GMTrace.i(3998211899392L, 29789);
    GMTrace.o(3998211899392L, 29789);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3998346117120L, 29790);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.ufp == null) {
        throw new b("Not all required fields were included: Text");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.the);
      if (this.ufp != null)
      {
        paramVarArgs.eQ(3, this.ufp.aUd());
        this.ufp.a(paramVarArgs);
      }
      GMTrace.o(3998346117120L, 29790);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.the);
      paramInt = i;
      if (this.ufp != null) {
        paramInt = i + a.a.a.a.eN(3, this.ufp.aUd());
      }
      GMTrace.o(3998346117120L, 29790);
      return paramInt;
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
      if (this.ufp == null) {
        throw new b("Not all required fields were included: Text");
      }
      GMTrace.o(3998346117120L, 29790);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bhm localbhm = (bhm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3998346117120L, 29790);
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
          localbhm.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3998346117120L, 29790);
        return 0;
      case 2: 
        localbhm.the = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3998346117120L, 29790);
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
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localbhm.ufp = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3998346117120L, 29790);
      return 0;
    }
    GMTrace.o(3998346117120L, 29790);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bhm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */