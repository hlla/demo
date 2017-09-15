package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class axz
  extends ave
{
  public int tLy;
  public LinkedList<avu> tLz;
  public String tsG;
  
  public axz()
  {
    GMTrace.i(4037806129152L, 30084);
    this.tLz = new LinkedList();
    GMTrace.o(4037806129152L, 30084);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4037940346880L, 30085);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tsG != null) {
        paramVarArgs.e(2, this.tsG);
      }
      paramVarArgs.eO(3, this.tLy);
      paramVarArgs.d(4, 8, this.tLz);
      GMTrace.o(4037940346880L, 30085);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt;
      if (this.tsG != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tsG);
      }
      paramInt = a.a.a.a.eL(3, this.tLy);
      int j = a.a.a.a.c(4, 8, this.tLz);
      GMTrace.o(4037940346880L, 30085);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tLz.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4037940346880L, 30085);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      axz localaxz = (axz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(4037940346880L, 30085);
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
          localaxz.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4037940346880L, 30085);
        return 0;
      case 2: 
        localaxz.tsG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4037940346880L, 30085);
        return 0;
      case 3: 
        localaxz.tLy = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4037940346880L, 30085);
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
        localaxz.tLz.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(4037940346880L, 30085);
      return 0;
    }
    GMTrace.o(4037940346880L, 30085);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/axz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */