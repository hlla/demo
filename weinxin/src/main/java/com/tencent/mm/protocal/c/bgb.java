package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bgb
  extends avm
{
  public int ueL;
  public dr ueM;
  public ap ueN;
  public ang ueO;
  
  public bgb()
  {
    GMTrace.i(13577196929024L, 101158);
    GMTrace.o(13577196929024L, 101158);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13577331146752L, 101159);
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
      paramVarArgs.eO(2, this.ueL);
      if (this.ueM != null)
      {
        paramVarArgs.eQ(3, this.ueM.aUd());
        this.ueM.a(paramVarArgs);
      }
      if (this.ueN != null)
      {
        paramVarArgs.eQ(4, this.ueN.aUd());
        this.ueN.a(paramVarArgs);
      }
      if (this.ueO != null)
      {
        paramVarArgs.eQ(5, this.ueO.aUd());
        this.ueO.a(paramVarArgs);
      }
      GMTrace.o(13577331146752L, 101159);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.ueL);
      paramInt = i;
      if (this.ueM != null) {
        paramInt = i + a.a.a.a.eN(3, this.ueM.aUd());
      }
      i = paramInt;
      if (this.ueN != null) {
        i = paramInt + a.a.a.a.eN(4, this.ueN.aUd());
      }
      paramInt = i;
      if (this.ueO != null) {
        paramInt = i + a.a.a.a.eN(5, this.ueO.aUd());
      }
      GMTrace.o(13577331146752L, 101159);
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
      GMTrace.o(13577331146752L, 101159);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bgb localbgb = (bgb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13577331146752L, 101159);
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
          localbgb.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13577331146752L, 101159);
        return 0;
      case 2: 
        localbgb.ueL = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13577331146752L, 101159);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dr();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dr)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbgb.ueM = ((dr)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13577331146752L, 101159);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ap();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ap)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbgb.ueN = ((ap)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13577331146752L, 101159);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ang();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ang)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localbgb.ueO = ((ang)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13577331146752L, 101159);
      return 0;
    }
    GMTrace.o(13577331146752L, 101159);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */