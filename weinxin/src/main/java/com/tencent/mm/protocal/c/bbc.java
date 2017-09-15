package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bbc
  extends com.tencent.mm.bd.a
{
  public int ofk;
  public String tfa;
  public avt uac;
  
  public bbc()
  {
    GMTrace.i(4040490483712L, 30104);
    GMTrace.o(4040490483712L, 30104);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4040624701440L, 30105);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.uac == null) {
        throw new b("Not all required fields were included: HBBuffer");
      }
      if (this.tfa != null) {
        paramVarArgs.e(1, this.tfa);
      }
      paramVarArgs.eO(2, this.ofk);
      if (this.uac != null)
      {
        paramVarArgs.eQ(3, this.uac.aUd());
        this.uac.a(paramVarArgs);
      }
      GMTrace.o(4040624701440L, 30105);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tfa != null) {
        paramInt = a.a.a.b.b.a.f(1, this.tfa) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.ofk);
      paramInt = i;
      if (this.uac != null) {
        paramInt = i + a.a.a.a.eN(3, this.uac.aUd());
      }
      GMTrace.o(4040624701440L, 30105);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.uac == null) {
        throw new b("Not all required fields were included: HBBuffer");
      }
      GMTrace.o(4040624701440L, 30105);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bbc localbbc = (bbc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4040624701440L, 30105);
        return -1;
      case 1: 
        localbbc.tfa = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4040624701440L, 30105);
        return 0;
      case 2: 
        localbbc.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4040624701440L, 30105);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbbc.uac = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(4040624701440L, 30105);
      return 0;
    }
    GMTrace.o(4040624701440L, 30105);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */