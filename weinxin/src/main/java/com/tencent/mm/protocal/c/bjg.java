package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bjg
  extends avm
{
  public bjl tWD;
  public int tWy;
  public int tpm;
  public String uhh;
  
  public bjg()
  {
    GMTrace.i(3731118620672L, 27799);
    GMTrace.o(3731118620672L, 27799);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3731252838400L, 27800);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tWD == null) {
        throw new b("Not all required fields were included: NextPiece");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tWD != null)
      {
        paramVarArgs.eQ(2, this.tWD.aUd());
        this.tWD.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tpm);
      paramVarArgs.eO(4, this.tWy);
      if (this.uhh != null) {
        paramVarArgs.e(5, this.uhh);
      }
      GMTrace.o(3731252838400L, 27800);
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
      if (this.tWD != null) {
        i = paramInt + a.a.a.a.eN(2, this.tWD.aUd());
      }
      i = i + a.a.a.a.eL(3, this.tpm) + a.a.a.a.eL(4, this.tWy);
      paramInt = i;
      if (this.uhh != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.uhh);
      }
      GMTrace.o(3731252838400L, 27800);
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
      if (this.tWD == null) {
        throw new b("Not all required fields were included: NextPiece");
      }
      GMTrace.o(3731252838400L, 27800);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bjg localbjg = (bjg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3731252838400L, 27800);
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
          localbjg.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3731252838400L, 27800);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbjg.tWD = ((bjl)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3731252838400L, 27800);
        return 0;
      case 3: 
        localbjg.tpm = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3731252838400L, 27800);
        return 0;
      case 4: 
        localbjg.tWy = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3731252838400L, 27800);
        return 0;
      }
      localbjg.uhh = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3731252838400L, 27800);
      return 0;
    }
    GMTrace.o(3731252838400L, 27800);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bjg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */