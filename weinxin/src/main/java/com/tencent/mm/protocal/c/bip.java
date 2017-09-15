package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bip
  extends com.tencent.mm.bd.a
{
  public int fxf;
  public String mqJ;
  public avt ugK;
  public avt ugL;
  
  public bip()
  {
    GMTrace.i(3791650816000L, 28250);
    GMTrace.o(3791650816000L, 28250);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3791785033728L, 28251);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.ugK == null) {
        throw new b("Not all required fields were included: Icon");
      }
      if (this.ugL == null) {
        throw new b("Not all required fields were included: HDIcon");
      }
      paramVarArgs.eO(1, this.fxf);
      if (this.mqJ != null) {
        paramVarArgs.e(2, this.mqJ);
      }
      if (this.ugK != null)
      {
        paramVarArgs.eQ(3, this.ugK.aUd());
        this.ugK.a(paramVarArgs);
      }
      if (this.ugL != null)
      {
        paramVarArgs.eQ(4, this.ugL.aUd());
        this.ugL.a(paramVarArgs);
      }
      GMTrace.o(3791785033728L, 28251);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.fxf) + 0;
      paramInt = i;
      if (this.mqJ != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mqJ);
      }
      i = paramInt;
      if (this.ugK != null) {
        i = paramInt + a.a.a.a.eN(3, this.ugK.aUd());
      }
      paramInt = i;
      if (this.ugL != null) {
        paramInt = i + a.a.a.a.eN(4, this.ugL.aUd());
      }
      GMTrace.o(3791785033728L, 28251);
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
      if (this.ugK == null) {
        throw new b("Not all required fields were included: Icon");
      }
      if (this.ugL == null) {
        throw new b("Not all required fields were included: HDIcon");
      }
      GMTrace.o(3791785033728L, 28251);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bip localbip = (bip)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3791785033728L, 28251);
        return -1;
      case 1: 
        localbip.fxf = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3791785033728L, 28251);
        return 0;
      case 2: 
        localbip.mqJ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3791785033728L, 28251);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbip.ugK = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3791785033728L, 28251);
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
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbip.ugL = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3791785033728L, 28251);
      return 0;
    }
    GMTrace.o(3791785033728L, 28251);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */