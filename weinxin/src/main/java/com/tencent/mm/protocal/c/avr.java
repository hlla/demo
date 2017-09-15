package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class avr
  extends avm
{
  public String tXA;
  public String tXz;
  
  public avr()
  {
    GMTrace.i(4037269258240L, 30080);
    GMTrace.o(4037269258240L, 30080);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4037403475968L, 30081);
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
      if (this.tXz != null) {
        paramVarArgs.e(2, this.tXz);
      }
      if (this.tXA != null) {
        paramVarArgs.e(3, this.tXA);
      }
      GMTrace.o(4037403475968L, 30081);
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
      if (this.tXz != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tXz);
      }
      i = paramInt;
      if (this.tXA != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tXA);
      }
      GMTrace.o(4037403475968L, 30081);
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
      GMTrace.o(4037403475968L, 30081);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      avr localavr = (avr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4037403475968L, 30081);
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
          localavr.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4037403475968L, 30081);
        return 0;
      case 2: 
        localavr.tXz = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4037403475968L, 30081);
        return 0;
      }
      localavr.tXA = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(4037403475968L, 30081);
      return 0;
    }
    GMTrace.o(4037403475968L, 30081);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/avr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */