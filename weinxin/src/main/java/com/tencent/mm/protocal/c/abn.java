package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class abn
  extends avm
{
  public LinkedList<aw> mtI;
  public LinkedList<adu> mti;
  public int tFD;
  public LinkedList<ati> tFE;
  public int tFF;
  public int tFG;
  public int tFH;
  public adt tFI;
  
  public abn()
  {
    GMTrace.i(3909762416640L, 29130);
    this.tFE = new LinkedList();
    this.mtI = new LinkedList();
    this.mti = new LinkedList();
    GMTrace.o(3909762416640L, 29130);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3909896634368L, 29131);
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
      paramVarArgs.eO(2, this.tFD);
      paramVarArgs.d(3, 8, this.tFE);
      paramVarArgs.eO(4, this.tFF);
      paramVarArgs.eO(5, this.tFG);
      paramVarArgs.d(6, 8, this.mtI);
      paramVarArgs.eO(7, this.tFH);
      paramVarArgs.d(8, 8, this.mti);
      if (this.tFI != null)
      {
        paramVarArgs.eQ(9, this.tFI.aUd());
        this.tFI.a(paramVarArgs);
      }
      GMTrace.o(3909896634368L, 29131);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tFD) + a.a.a.a.c(3, 8, this.tFE) + a.a.a.a.eL(4, this.tFF) + a.a.a.a.eL(5, this.tFG) + a.a.a.a.c(6, 8, this.mtI) + a.a.a.a.eL(7, this.tFH) + a.a.a.a.c(8, 8, this.mti);
      paramInt = i;
      if (this.tFI != null) {
        paramInt = i + a.a.a.a.eN(9, this.tFI.aUd());
      }
      GMTrace.o(3909896634368L, 29131);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tFE.clear();
      this.mtI.clear();
      this.mti.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3909896634368L, 29131);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      abn localabn = (abn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3909896634368L, 29131);
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
          localabn.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3909896634368L, 29131);
        return 0;
      case 2: 
        localabn.tFD = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3909896634368L, 29131);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ati();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ati)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localabn.tFE.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3909896634368L, 29131);
        return 0;
      case 4: 
        localabn.tFF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3909896634368L, 29131);
        return 0;
      case 5: 
        localabn.tFG = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3909896634368L, 29131);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aw)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localabn.mtI.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3909896634368L, 29131);
        return 0;
      case 7: 
        localabn.tFH = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3909896634368L, 29131);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localabn.mti.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3909896634368L, 29131);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new adt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((adt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localabn.tFI = ((adt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3909896634368L, 29131);
      return 0;
    }
    GMTrace.o(3909896634368L, 29131);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/abn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */