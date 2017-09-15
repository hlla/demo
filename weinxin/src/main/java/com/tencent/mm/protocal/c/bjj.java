package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bjj
  extends avm
{
  public int tCc;
  public int the;
  public LinkedList<avu> thh;
  public String uhm;
  
  public bjj()
  {
    GMTrace.i(3655688257536L, 27237);
    this.thh = new LinkedList();
    GMTrace.o(3655688257536L, 27237);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3655822475264L, 27238);
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
      paramVarArgs.eO(2, this.the);
      paramVarArgs.eO(3, this.tCc);
      paramVarArgs.d(4, 8, this.thh);
      if (this.uhm != null) {
        paramVarArgs.e(5, this.uhm);
      }
      GMTrace.o(3655822475264L, 27238);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.the) + a.a.a.a.eL(3, this.tCc) + a.a.a.a.c(4, 8, this.thh);
      paramInt = i;
      if (this.uhm != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.uhm);
      }
      GMTrace.o(3655822475264L, 27238);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.thh.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3655822475264L, 27238);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bjj localbjj = (bjj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3655822475264L, 27238);
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
          localbjj.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3655822475264L, 27238);
        return 0;
      case 2: 
        localbjj.the = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3655822475264L, 27238);
        return 0;
      case 3: 
        localbjj.tCc = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3655822475264L, 27238);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbjj.thh.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3655822475264L, 27238);
        return 0;
      }
      localbjj.uhm = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3655822475264L, 27238);
      return 0;
    }
    GMTrace.o(3655822475264L, 27238);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */