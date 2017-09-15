package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class zj
  extends avm
{
  public int jLr;
  public LinkedList<aju> mrh;
  public String tsQ;
  
  public zj()
  {
    GMTrace.i(3769504890880L, 28085);
    this.mrh = new LinkedList();
    GMTrace.o(3769504890880L, 28085);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3769639108608L, 28086);
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
      paramVarArgs.eO(2, this.jLr);
      paramVarArgs.d(3, 8, this.mrh);
      if (this.tsQ != null) {
        paramVarArgs.e(4, this.tsQ);
      }
      GMTrace.o(3769639108608L, 28086);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.jLr) + a.a.a.a.c(3, 8, this.mrh);
      paramInt = i;
      if (this.tsQ != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tsQ);
      }
      GMTrace.o(3769639108608L, 28086);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.mrh.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3769639108608L, 28086);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      zj localzj = (zj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3769639108608L, 28086);
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
          localzj.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3769639108608L, 28086);
        return 0;
      case 2: 
        localzj.jLr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3769639108608L, 28086);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aju();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aju)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localzj.mrh.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3769639108608L, 28086);
        return 0;
      }
      localzj.tsQ = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3769639108608L, 28086);
      return 0;
    }
    GMTrace.o(3769639108608L, 28086);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/zj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */