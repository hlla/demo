package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bjn
  extends com.tencent.mm.bd.a
{
  public int the;
  public String tpP;
  public avt ufp;
  public int uhq;
  
  public bjn()
  {
    GMTrace.i(3916473303040L, 29180);
    GMTrace.o(3916473303040L, 29180);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3916607520768L, 29181);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.ufp == null) {
        throw new b("Not all required fields were included: Text");
      }
      if (this.ufp != null)
      {
        paramVarArgs.eQ(1, this.ufp.aUd());
        this.ufp.a(paramVarArgs);
      }
      if (this.tpP != null) {
        paramVarArgs.e(2, this.tpP);
      }
      paramVarArgs.eO(3, this.the);
      paramVarArgs.eO(4, this.uhq);
      GMTrace.o(3916607520768L, 29181);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.ufp != null) {
        paramInt = a.a.a.a.eN(1, this.ufp.aUd()) + 0;
      }
      i = paramInt;
      if (this.tpP != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tpP);
      }
      paramInt = a.a.a.a.eL(3, this.the);
      int j = a.a.a.a.eL(4, this.uhq);
      GMTrace.o(3916607520768L, 29181);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.ufp == null) {
        throw new b("Not all required fields were included: Text");
      }
      GMTrace.o(3916607520768L, 29181);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bjn localbjn = (bjn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3916607520768L, 29181);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbjn.ufp = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3916607520768L, 29181);
        return 0;
      case 2: 
        localbjn.tpP = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3916607520768L, 29181);
        return 0;
      case 3: 
        localbjn.the = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3916607520768L, 29181);
        return 0;
      }
      localbjn.uhq = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3916607520768L, 29181);
      return 0;
    }
    GMTrace.o(3916607520768L, 29181);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bjn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */