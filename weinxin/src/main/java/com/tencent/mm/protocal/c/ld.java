package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ld
  extends avm
{
  public String tpN;
  public String tpO;
  
  public ld()
  {
    GMTrace.i(3870705057792L, 28839);
    GMTrace.o(3870705057792L, 28839);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3870839275520L, 28840);
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
      if (this.tpN != null) {
        paramVarArgs.e(2, this.tpN);
      }
      if (this.tpO != null) {
        paramVarArgs.e(3, this.tpO);
      }
      GMTrace.o(3870839275520L, 28840);
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
      if (this.tpN != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tpN);
      }
      i = paramInt;
      if (this.tpO != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tpO);
      }
      GMTrace.o(3870839275520L, 28840);
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
      GMTrace.o(3870839275520L, 28840);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ld localld = (ld)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3870839275520L, 28840);
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
          localld.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3870839275520L, 28840);
        return 0;
      case 2: 
        localld.tpN = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3870839275520L, 28840);
        return 0;
      }
      localld.tpO = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3870839275520L, 28840);
      return 0;
    }
    GMTrace.o(3870839275520L, 28840);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */