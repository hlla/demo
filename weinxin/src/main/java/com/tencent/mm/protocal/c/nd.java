package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class nd
  extends com.tencent.mm.bd.a
{
  public avu trH;
  public int trJ;
  
  public nd()
  {
    GMTrace.i(13334665494528L, 99351);
    GMTrace.o(13334665494528L, 99351);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13334799712256L, 99352);
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
      paramVarArgs.eO(2, this.trJ);
      GMTrace.o(13334799712256L, 99352);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.trH != null) {
        paramInt = a.a.a.a.eN(1, this.trH.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.trJ);
      GMTrace.o(13334799712256L, 99352);
      return paramInt + i;
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
      GMTrace.o(13334799712256L, 99352);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      nd localnd = (nd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13334799712256L, 99352);
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
          localnd.trH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13334799712256L, 99352);
        return 0;
      }
      localnd.trJ = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13334799712256L, 99352);
      return 0;
    }
    GMTrace.o(13334799712256L, 99352);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/nd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */