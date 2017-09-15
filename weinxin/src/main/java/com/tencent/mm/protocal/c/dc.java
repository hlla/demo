package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class dc
  extends avm
{
  public com.tencent.mm.bd.b teO;
  public int teT;
  public int teU;
  public dh teV;
  public dd teW;
  
  public dc()
  {
    GMTrace.i(3783195099136L, 28187);
    GMTrace.o(3783195099136L, 28187);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3783329316864L, 28188);
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
      paramVarArgs.eO(2, this.teT);
      paramVarArgs.eO(3, this.teU);
      if (this.teO != null) {
        paramVarArgs.b(4, this.teO);
      }
      if (this.teV != null)
      {
        paramVarArgs.eQ(5, this.teV.aUd());
        this.teV.a(paramVarArgs);
      }
      if (this.teW != null)
      {
        paramVarArgs.eQ(6, this.teW.aUd());
        this.teW.a(paramVarArgs);
      }
      GMTrace.o(3783329316864L, 28188);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.teT) + a.a.a.a.eL(3, this.teU);
      paramInt = i;
      if (this.teO != null) {
        paramInt = i + a.a.a.a.a(4, this.teO);
      }
      i = paramInt;
      if (this.teV != null) {
        i = paramInt + a.a.a.a.eN(5, this.teV.aUd());
      }
      paramInt = i;
      if (this.teW != null) {
        paramInt = i + a.a.a.a.eN(6, this.teW.aUd());
      }
      GMTrace.o(3783329316864L, 28188);
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
        throw new a.a.a.b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3783329316864L, 28188);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      dc localdc = (dc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3783329316864L, 28188);
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
          localdc.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3783329316864L, 28188);
        return 0;
      case 2: 
        localdc.teT = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3783329316864L, 28188);
        return 0;
      case 3: 
        localdc.teU = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3783329316864L, 28188);
        return 0;
      case 4: 
        localdc.teO = ((a.a.a.a.a)localObject1).chR();
        GMTrace.o(3783329316864L, 28188);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dh();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dh)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localdc.teV = ((dh)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3783329316864L, 28188);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dd();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dd)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localdc.teW = ((dd)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3783329316864L, 28188);
      return 0;
    }
    GMTrace.o(3783329316864L, 28188);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */