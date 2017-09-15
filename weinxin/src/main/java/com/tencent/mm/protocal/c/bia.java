package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bia
  extends avm
{
  public int tNh;
  public long tdE;
  public int tdw;
  public String teo;
  public String tlA;
  public int ufO;
  
  public bia()
  {
    GMTrace.i(3680115884032L, 27419);
    GMTrace.o(3680115884032L, 27419);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3680250101760L, 27420);
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
      if (this.teo != null) {
        paramVarArgs.e(2, this.teo);
      }
      paramVarArgs.eO(3, this.tdw);
      paramVarArgs.eO(4, this.tNh);
      paramVarArgs.eO(5, this.ufO);
      paramVarArgs.O(6, this.tdE);
      if (this.tlA != null) {
        paramVarArgs.e(7, this.tlA);
      }
      GMTrace.o(3680250101760L, 27420);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt;
      if (this.teo != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.teo);
      }
      i = i + a.a.a.a.eL(3, this.tdw) + a.a.a.a.eL(4, this.tNh) + a.a.a.a.eL(5, this.ufO) + a.a.a.a.N(6, this.tdE);
      paramInt = i;
      if (this.tlA != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.tlA);
      }
      GMTrace.o(3680250101760L, 27420);
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
      GMTrace.o(3680250101760L, 27420);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bia localbia = (bia)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3680250101760L, 27420);
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
          localbia.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3680250101760L, 27420);
        return 0;
      case 2: 
        localbia.teo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3680250101760L, 27420);
        return 0;
      case 3: 
        localbia.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3680250101760L, 27420);
        return 0;
      case 4: 
        localbia.tNh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3680250101760L, 27420);
        return 0;
      case 5: 
        localbia.ufO = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3680250101760L, 27420);
        return 0;
      case 6: 
        localbia.tdE = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3680250101760L, 27420);
        return 0;
      }
      localbia.tlA = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3680250101760L, 27420);
      return 0;
    }
    GMTrace.o(3680250101760L, 27420);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */