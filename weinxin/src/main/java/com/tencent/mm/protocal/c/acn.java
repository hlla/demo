package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class acn
  extends ave
{
  public int tGE;
  public String tGF;
  public avt thY;
  
  public acn()
  {
    GMTrace.i(3706154123264L, 27613);
    GMTrace.o(3706154123264L, 27613);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3706288340992L, 27614);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.thY == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tGE);
      if (this.tGF != null) {
        paramVarArgs.e(3, this.tGF);
      }
      if (this.thY != null)
      {
        paramVarArgs.eQ(4, this.thY.aUd());
        this.thY.a(paramVarArgs);
      }
      GMTrace.o(3706288340992L, 27614);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tGE);
      paramInt = i;
      if (this.tGF != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tGF);
      }
      i = paramInt;
      if (this.thY != null) {
        i = paramInt + a.a.a.a.eN(4, this.thY.aUd());
      }
      GMTrace.o(3706288340992L, 27614);
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
      if (this.thY == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      GMTrace.o(3706288340992L, 27614);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      acn localacn = (acn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3706288340992L, 27614);
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
          localacn.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3706288340992L, 27614);
        return 0;
      case 2: 
        localacn.tGE = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3706288340992L, 27614);
        return 0;
      case 3: 
        localacn.tGF = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3706288340992L, 27614);
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
        localacn.thY = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3706288340992L, 27614);
      return 0;
    }
    GMTrace.o(3706288340992L, 27614);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/acn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */