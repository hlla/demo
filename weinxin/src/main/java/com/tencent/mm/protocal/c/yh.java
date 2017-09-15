package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class yh
  extends avm
{
  public String tDd;
  public long tDe;
  public bu tDf;
  public int tay;
  
  public yh()
  {
    GMTrace.i(3622804914176L, 26992);
    GMTrace.o(3622804914176L, 26992);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3622939131904L, 26993);
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
      paramVarArgs.eO(2, this.tay);
      paramVarArgs.O(3, this.tDe);
      if (this.tDf != null)
      {
        paramVarArgs.eQ(4, this.tDf.aUd());
        this.tDf.a(paramVarArgs);
      }
      if (this.tDd != null) {
        paramVarArgs.e(5, this.tDd);
      }
      GMTrace.o(3622939131904L, 26993);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tay) + a.a.a.a.N(3, this.tDe);
      paramInt = i;
      if (this.tDf != null) {
        paramInt = i + a.a.a.a.eN(4, this.tDf.aUd());
      }
      i = paramInt;
      if (this.tDd != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tDd);
      }
      GMTrace.o(3622939131904L, 26993);
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
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3622939131904L, 26993);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      yh localyh = (yh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3622939131904L, 26993);
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
          localyh.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3622939131904L, 26993);
        return 0;
      case 2: 
        localyh.tay = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3622939131904L, 26993);
        return 0;
      case 3: 
        localyh.tDe = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3622939131904L, 26993);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localyh.tDf = ((bu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3622939131904L, 26993);
        return 0;
      }
      localyh.tDd = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3622939131904L, 26993);
      return 0;
    }
    GMTrace.o(3622939131904L, 26993);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/yh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */