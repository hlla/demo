package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class azb
  extends ave
{
  public String lcR;
  public avt tfz;
  public String tsG;
  
  public azb()
  {
    GMTrace.i(13167967076352L, 98109);
    GMTrace.o(13167967076352L, 98109);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13168101294080L, 98110);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.lcR != null) {
        paramVarArgs.e(2, this.lcR);
      }
      if (this.tsG != null) {
        paramVarArgs.e(3, this.tsG);
      }
      if (this.tfz != null)
      {
        paramVarArgs.eQ(4, this.tfz.aUd());
        this.tfz.a(paramVarArgs);
      }
      GMTrace.o(13168101294080L, 98110);
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
      if (this.lcR != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.lcR);
      }
      i = paramInt;
      if (this.tsG != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tsG);
      }
      paramInt = i;
      if (this.tfz != null) {
        paramInt = i + a.a.a.a.eN(4, this.tfz.aUd());
      }
      GMTrace.o(13168101294080L, 98110);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13168101294080L, 98110);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      azb localazb = (azb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13168101294080L, 98110);
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
          localazb.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13168101294080L, 98110);
        return 0;
      case 2: 
        localazb.lcR = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13168101294080L, 98110);
        return 0;
      case 3: 
        localazb.tsG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13168101294080L, 98110);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localazb.tfz = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13168101294080L, 98110);
      return 0;
    }
    GMTrace.o(13168101294080L, 98110);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/azb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */