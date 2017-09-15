package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bpk
  extends com.tencent.mm.bd.a
{
  public avt tFA;
  public String tFx;
  
  public bpk()
  {
    GMTrace.i(13577733799936L, 101162);
    GMTrace.o(13577733799936L, 101162);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13577868017664L, 101163);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tFA == null) {
        throw new b("Not all required fields were included: VerifyBuff");
      }
      if (this.tFx != null) {
        paramVarArgs.e(1, this.tFx);
      }
      if (this.tFA != null)
      {
        paramVarArgs.eQ(2, this.tFA.aUd());
        this.tFA.a(paramVarArgs);
      }
      GMTrace.o(13577868017664L, 101163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tFx != null) {
        paramInt = a.a.a.b.b.a.f(1, this.tFx) + 0;
      }
      i = paramInt;
      if (this.tFA != null) {
        i = paramInt + a.a.a.a.eN(2, this.tFA.aUd());
      }
      GMTrace.o(13577868017664L, 101163);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tFA == null) {
        throw new b("Not all required fields were included: VerifyBuff");
      }
      GMTrace.o(13577868017664L, 101163);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bpk localbpk = (bpk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13577868017664L, 101163);
        return -1;
      case 1: 
        localbpk.tFx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13577868017664L, 101163);
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
        localbpk.tFA = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13577868017664L, 101163);
      return 0;
    }
    GMTrace.o(13577868017664L, 101163);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */