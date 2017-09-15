package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class yb
  extends avm
{
  public com.tencent.mm.bd.b tCV;
  public int tCW;
  public com.tencent.mm.bd.b tCX;
  
  public yb()
  {
    GMTrace.i(3627636752384L, 27028);
    GMTrace.o(3627636752384L, 27028);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3627770970112L, 27029);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new a.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tCW);
      if (this.tCX != null) {
        paramVarArgs.b(4, this.tCX);
      }
      if (this.tCV != null) {
        paramVarArgs.b(5, this.tCV);
      }
      GMTrace.o(3627770970112L, 27029);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(3, this.tCW);
      paramInt = i;
      if (this.tCX != null) {
        paramInt = i + a.a.a.a.a(4, this.tCX);
      }
      i = paramInt;
      if (this.tCV != null) {
        i = paramInt + a.a.a.a.a(5, this.tCV);
      }
      GMTrace.o(3627770970112L, 27029);
      return i;
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
        throw new a.a.a.b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3627770970112L, 27029);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      yb localyb = (yb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 2: 
      default: 
        GMTrace.o(3627770970112L, 27029);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localyb.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3627770970112L, 27029);
        return 0;
      case 3: 
        localyb.tCW = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3627770970112L, 27029);
        return 0;
      case 4: 
        localyb.tCX = ((a.a.a.a.a)localObject1).chR();
        GMTrace.o(3627770970112L, 27029);
        return 0;
      }
      localyb.tCV = ((a.a.a.a.a)localObject1).chR();
      GMTrace.o(3627770970112L, 27029);
      return 0;
    }
    GMTrace.o(3627770970112L, 27029);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/yb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */