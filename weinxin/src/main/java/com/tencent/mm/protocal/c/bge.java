package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bge
  extends ave
{
  public String tjf;
  public gq tyW;
  
  public bge()
  {
    GMTrace.i(3853525188608L, 28711);
    GMTrace.o(3853525188608L, 28711);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3853659406336L, 28712);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tjf == null) {
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (this.tyW == null) {
        throw new b("Not all required fields were included: chat");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tjf != null) {
        paramVarArgs.e(2, this.tjf);
      }
      if (this.tyW != null)
      {
        paramVarArgs.eQ(3, this.tyW.aUd());
        this.tyW.a(paramVarArgs);
      }
      GMTrace.o(3853659406336L, 28712);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXb != null) {
        i = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      paramInt = i;
      if (this.tjf != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tjf);
      }
      i = paramInt;
      if (this.tyW != null) {
        i = paramInt + a.a.a.a.eN(3, this.tyW.aUd());
      }
      GMTrace.o(3853659406336L, 28712);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tjf == null) {
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (this.tyW == null) {
        throw new b("Not all required fields were included: chat");
      }
      GMTrace.o(3853659406336L, 28712);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bge localbge = (bge)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3853659406336L, 28712);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbge.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3853659406336L, 28712);
        return 0;
      case 2: 
        localbge.tjf = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3853659406336L, 28712);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new gq();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((gq)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localbge.tyW = ((gq)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3853659406336L, 28712);
      return 0;
    }
    GMTrace.o(3853659406336L, 28712);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */