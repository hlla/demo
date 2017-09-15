package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aml
  extends com.tencent.mm.bd.a
{
  public int tPi;
  public int tPy;
  public int tPz;
  public avu trH;
  
  public aml()
  {
    GMTrace.i(3898219692032L, 29044);
    GMTrace.o(3898219692032L, 29044);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3898353909760L, 29045);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.trH != null)
      {
        paramVarArgs.eQ(1, this.trH.aUd());
        this.trH.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tPy);
      paramVarArgs.eO(3, this.tPz);
      paramVarArgs.eO(4, this.tPi);
      GMTrace.o(3898353909760L, 29045);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.trH != null) {
        paramInt = a.a.a.a.eN(1, this.trH.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.tPy);
      int j = a.a.a.a.eL(3, this.tPz);
      int k = a.a.a.a.eL(4, this.tPi);
      GMTrace.o(3898353909760L, 29045);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      GMTrace.o(3898353909760L, 29045);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aml localaml = (aml)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3898353909760L, 29045);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaml.trH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3898353909760L, 29045);
        return 0;
      case 2: 
        localaml.tPy = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3898353909760L, 29045);
        return 0;
      case 3: 
        localaml.tPz = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3898353909760L, 29045);
        return 0;
      }
      localaml.tPi = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3898353909760L, 29045);
      return 0;
    }
    GMTrace.o(3898353909760L, 29045);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */