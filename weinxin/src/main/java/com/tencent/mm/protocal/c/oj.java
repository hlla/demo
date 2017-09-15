package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class oj
  extends avm
{
  public String jLx;
  public String mrA;
  public int tfd;
  public int tfe;
  public int tff;
  public avt tqC;
  public String tso;
  
  public oj()
  {
    GMTrace.i(3992843190272L, 29749);
    GMTrace.o(3992843190272L, 29749);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3992977408000L, 29750);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.mrA != null) {
        paramVarArgs.e(2, this.mrA);
      }
      if (this.tso != null) {
        paramVarArgs.e(3, this.tso);
      }
      if (this.jLx != null) {
        paramVarArgs.e(4, this.jLx);
      }
      paramVarArgs.eO(5, this.tfd);
      paramVarArgs.eO(6, this.tfe);
      paramVarArgs.eO(7, this.tff);
      if (this.tqC != null)
      {
        paramVarArgs.eQ(8, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      GMTrace.o(3992977408000L, 29750);
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
      if (this.mrA != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mrA);
      }
      i = paramInt;
      if (this.tso != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tso);
      }
      paramInt = i;
      if (this.jLx != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.jLx);
      }
      i = paramInt + a.a.a.a.eL(5, this.tfd) + a.a.a.a.eL(6, this.tfe) + a.a.a.a.eL(7, this.tff);
      paramInt = i;
      if (this.tqC != null) {
        paramInt = i + a.a.a.a.eN(8, this.tqC.aUd());
      }
      GMTrace.o(3992977408000L, 29750);
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
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      GMTrace.o(3992977408000L, 29750);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      oj localoj = (oj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3992977408000L, 29750);
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
          localoj.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3992977408000L, 29750);
        return 0;
      case 2: 
        localoj.mrA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3992977408000L, 29750);
        return 0;
      case 3: 
        localoj.tso = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3992977408000L, 29750);
        return 0;
      case 4: 
        localoj.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3992977408000L, 29750);
        return 0;
      case 5: 
        localoj.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3992977408000L, 29750);
        return 0;
      case 6: 
        localoj.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3992977408000L, 29750);
        return 0;
      case 7: 
        localoj.tff = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3992977408000L, 29750);
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
        localoj.tqC = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3992977408000L, 29750);
      return 0;
    }
    GMTrace.o(3992977408000L, 29750);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/oj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */