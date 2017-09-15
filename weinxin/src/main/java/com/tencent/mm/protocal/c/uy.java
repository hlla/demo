package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class uy
  extends avm
{
  public int result;
  public afq tAT;
  public String tAU;
  public afl tAV;
  
  public uy()
  {
    GMTrace.i(3886676967424L, 28958);
    GMTrace.o(3886676967424L, 28958);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3886811185152L, 28959);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tAT != null)
      {
        paramVarArgs.eQ(2, this.tAT.aUd());
        this.tAT.a(paramVarArgs);
      }
      if (this.tAU != null) {
        paramVarArgs.e(3, this.tAU);
      }
      if (this.tAV != null)
      {
        paramVarArgs.eQ(4, this.tAV.aUd());
        this.tAV.a(paramVarArgs);
      }
      paramVarArgs.eO(5, this.result);
      GMTrace.o(3886811185152L, 28959);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXs != null) {
        i = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      paramInt = i;
      if (this.tAT != null) {
        paramInt = i + a.a.a.a.eN(2, this.tAT.aUd());
      }
      i = paramInt;
      if (this.tAU != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tAU);
      }
      paramInt = i;
      if (this.tAV != null) {
        paramInt = i + a.a.a.a.eN(4, this.tAV.aUd());
      }
      i = a.a.a.a.eL(5, this.result);
      GMTrace.o(3886811185152L, 28959);
      return paramInt + i;
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
      GMTrace.o(3886811185152L, 28959);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      uy localuy = (uy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3886811185152L, 28959);
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
          localuy.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3886811185152L, 28959);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afq();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afq)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localuy.tAT = ((afq)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3886811185152L, 28959);
        return 0;
      case 3: 
        localuy.tAU = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3886811185152L, 28959);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localuy.tAV = ((afl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3886811185152L, 28959);
        return 0;
      }
      localuy.result = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3886811185152L, 28959);
      return 0;
    }
    GMTrace.o(3886811185152L, 28959);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/uy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */