package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ava
  extends ave
{
  public int tWV;
  public LinkedList<avu> tWW;
  public avu tWX;
  public avu tWY;
  
  public ava()
  {
    GMTrace.i(3980360941568L, 29656);
    this.tWW = new LinkedList();
    GMTrace.o(3980360941568L, 29656);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3980495159296L, 29657);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tWV);
      paramVarArgs.d(3, 8, this.tWW);
      if (this.tWX != null)
      {
        paramVarArgs.eQ(4, this.tWX.aUd());
        this.tWX.a(paramVarArgs);
      }
      if (this.tWY != null)
      {
        paramVarArgs.eQ(5, this.tWY.aUd());
        this.tWY.a(paramVarArgs);
      }
      GMTrace.o(3980495159296L, 29657);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tWV) + a.a.a.a.c(3, 8, this.tWW);
      paramInt = i;
      if (this.tWX != null) {
        paramInt = i + a.a.a.a.eN(4, this.tWX.aUd());
      }
      i = paramInt;
      if (this.tWY != null) {
        i = paramInt + a.a.a.a.eN(5, this.tWY.aUd());
      }
      GMTrace.o(3980495159296L, 29657);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tWW.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3980495159296L, 29657);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ava localava = (ava)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3980495159296L, 29657);
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
          localava.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3980495159296L, 29657);
        return 0;
      case 2: 
        localava.tWV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3980495159296L, 29657);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localava.tWW.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3980495159296L, 29657);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localava.tWX = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3980495159296L, 29657);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avu();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
        localava.tWY = ((avu)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3980495159296L, 29657);
      return 0;
    }
    GMTrace.o(3980495159296L, 29657);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ava.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */