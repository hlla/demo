package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class abm
  extends ave
{
  public int mqW;
  public LinkedList<avu> msD;
  public int msV;
  public int msW;
  public String msi;
  public int tFC;
  
  public abm()
  {
    GMTrace.i(4023579049984L, 29978);
    this.msD = new LinkedList();
    GMTrace.o(4023579049984L, 29978);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4023713267712L, 29979);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.mqW);
      paramVarArgs.eO(3, this.msV);
      paramVarArgs.eO(4, this.msW);
      if (this.msi != null) {
        paramVarArgs.e(5, this.msi);
      }
      paramVarArgs.eO(6, this.tFC);
      paramVarArgs.d(7, 8, this.msD);
      GMTrace.o(4023713267712L, 29979);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.mqW) + a.a.a.a.eL(3, this.msV) + a.a.a.a.eL(4, this.msW);
      paramInt = i;
      if (this.msi != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.msi);
      }
      i = a.a.a.a.eL(6, this.tFC);
      int j = a.a.a.a.c(7, 8, this.msD);
      GMTrace.o(4023713267712L, 29979);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.msD.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4023713267712L, 29979);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      abm localabm = (abm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(4023713267712L, 29979);
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
          localabm.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4023713267712L, 29979);
        return 0;
      case 2: 
        localabm.mqW = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4023713267712L, 29979);
        return 0;
      case 3: 
        localabm.msV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4023713267712L, 29979);
        return 0;
      case 4: 
        localabm.msW = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4023713267712L, 29979);
        return 0;
      case 5: 
        localabm.msi = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4023713267712L, 29979);
        return 0;
      case 6: 
        localabm.tFC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4023713267712L, 29979);
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
        localabm.msD.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(4023713267712L, 29979);
      return 0;
    }
    GMTrace.o(4023713267712L, 29979);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/abm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */