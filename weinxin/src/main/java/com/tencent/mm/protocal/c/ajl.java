package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ajl
  extends avm
{
  public int tLA;
  public LinkedList<ajj> tLC;
  public LinkedList<ajj> tLD;
  public int tLy;
  public String tsG;
  
  public ajl()
  {
    GMTrace.i(3992306319360L, 29745);
    this.tLC = new LinkedList();
    this.tLD = new LinkedList();
    GMTrace.o(3992306319360L, 29745);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3992440537088L, 29746);
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
      if (this.tsG != null) {
        paramVarArgs.e(2, this.tsG);
      }
      paramVarArgs.eO(3, this.tLy);
      paramVarArgs.d(4, 8, this.tLC);
      paramVarArgs.eO(5, this.tLA);
      paramVarArgs.d(6, 8, this.tLD);
      GMTrace.o(3992440537088L, 29746);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt;
      if (this.tsG != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tsG);
      }
      paramInt = a.a.a.a.eL(3, this.tLy);
      int j = a.a.a.a.c(4, 8, this.tLC);
      int k = a.a.a.a.eL(5, this.tLA);
      int m = a.a.a.a.c(6, 8, this.tLD);
      GMTrace.o(3992440537088L, 29746);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tLC.clear();
      this.tLD.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3992440537088L, 29746);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ajl localajl = (ajl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3992440537088L, 29746);
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
          localajl.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3992440537088L, 29746);
        return 0;
      case 2: 
        localajl.tsG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3992440537088L, 29746);
        return 0;
      case 3: 
        localajl.tLy = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3992440537088L, 29746);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ajj();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ajj)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localajl.tLC.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3992440537088L, 29746);
        return 0;
      case 5: 
        localajl.tLA = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3992440537088L, 29746);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ajj();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ajj)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localajl.tLD.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(3992440537088L, 29746);
      return 0;
    }
    GMTrace.o(3992440537088L, 29746);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ajl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */