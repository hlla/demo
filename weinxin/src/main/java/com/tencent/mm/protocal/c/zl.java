package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class zl
  extends avm
{
  public long tdE;
  public int tdw;
  public avu tdx;
  public avu tdy;
  public int tfd;
  public int tfe;
  public int tff;
  public avt tqC;
  
  public zl()
  {
    GMTrace.i(3758499037184L, 28003);
    GMTrace.o(3758499037184L, 28003);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3758633254912L, 28004);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tdx == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tdw);
      if (this.tdx != null)
      {
        paramVarArgs.eQ(3, this.tdx.aUd());
        this.tdx.a(paramVarArgs);
      }
      if (this.tdy != null)
      {
        paramVarArgs.eQ(4, this.tdy.aUd());
        this.tdy.a(paramVarArgs);
      }
      paramVarArgs.eO(5, this.tfd);
      paramVarArgs.eO(6, this.tfe);
      paramVarArgs.eO(7, this.tff);
      if (this.tqC != null)
      {
        paramVarArgs.eQ(8, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      paramVarArgs.O(9, this.tdE);
      GMTrace.o(3758633254912L, 28004);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tdw);
      paramInt = i;
      if (this.tdx != null) {
        paramInt = i + a.a.a.a.eN(3, this.tdx.aUd());
      }
      i = paramInt;
      if (this.tdy != null) {
        i = paramInt + a.a.a.a.eN(4, this.tdy.aUd());
      }
      i = i + a.a.a.a.eL(5, this.tfd) + a.a.a.a.eL(6, this.tfe) + a.a.a.a.eL(7, this.tff);
      paramInt = i;
      if (this.tqC != null) {
        paramInt = i + a.a.a.a.eN(8, this.tqC.aUd());
      }
      i = a.a.a.a.N(9, this.tdE);
      GMTrace.o(3758633254912L, 28004);
      return paramInt + i;
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
      if (this.tdx == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      GMTrace.o(3758633254912L, 28004);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      zl localzl = (zl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3758633254912L, 28004);
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
          localzl.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3758633254912L, 28004);
        return 0;
      case 2: 
        localzl.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3758633254912L, 28004);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localzl.tdx = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3758633254912L, 28004);
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
          localzl.tdy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3758633254912L, 28004);
        return 0;
      case 5: 
        localzl.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3758633254912L, 28004);
        return 0;
      case 6: 
        localzl.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3758633254912L, 28004);
        return 0;
      case 7: 
        localzl.tff = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3758633254912L, 28004);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localzl.tqC = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3758633254912L, 28004);
        return 0;
      }
      localzl.tdE = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(3758633254912L, 28004);
      return 0;
    }
    GMTrace.o(3758633254912L, 28004);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/zl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */