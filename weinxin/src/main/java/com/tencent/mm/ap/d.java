package com.tencent.mm.ap;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bd.a
{
  public LinkedList<e> hNB;
  public int hNC;
  public int hND;
  public int hNE;
  public int hNF;
  public String hNG;
  public String hNH;
  public int hNI;
  public int hNJ;
  public int hNK;
  public int maxSize;
  public String name;
  
  public d()
  {
    GMTrace.i(12938991632384L, 96403);
    this.hNB = new LinkedList();
    GMTrace.o(12938991632384L, 96403);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(12939125850112L, 96404);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.hNB);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.eO(3, this.hNC);
      paramVarArgs.eO(4, this.hND);
      paramVarArgs.eO(5, this.hNE);
      paramVarArgs.eO(6, this.hNF);
      if (this.hNG != null) {
        paramVarArgs.e(7, this.hNG);
      }
      if (this.hNH != null) {
        paramVarArgs.e(8, this.hNH);
      }
      paramVarArgs.eO(9, this.hNI);
      paramVarArgs.eO(10, this.hNJ);
      paramVarArgs.eO(11, this.hNK);
      paramVarArgs.eO(12, this.maxSize);
      GMTrace.o(12939125850112L, 96404);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.c(1, 8, this.hNB) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.name);
      }
      i = paramInt + a.a.a.a.eL(3, this.hNC) + a.a.a.a.eL(4, this.hND) + a.a.a.a.eL(5, this.hNE) + a.a.a.a.eL(6, this.hNF);
      paramInt = i;
      if (this.hNG != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.hNG);
      }
      i = paramInt;
      if (this.hNH != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.hNH);
      }
      paramInt = a.a.a.a.eL(9, this.hNI);
      int j = a.a.a.a.eL(10, this.hNJ);
      int k = a.a.a.a.eL(11, this.hNK);
      int m = a.a.a.a.eL(12, this.maxSize);
      GMTrace.o(12939125850112L, 96404);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hNB.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(12939125850112L, 96404);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(12939125850112L, 96404);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          locald.hNB.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(12939125850112L, 96404);
        return 0;
      case 2: 
        locald.name = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(12939125850112L, 96404);
        return 0;
      case 3: 
        locald.hNC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(12939125850112L, 96404);
        return 0;
      case 4: 
        locald.hND = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(12939125850112L, 96404);
        return 0;
      case 5: 
        locald.hNE = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(12939125850112L, 96404);
        return 0;
      case 6: 
        locald.hNF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(12939125850112L, 96404);
        return 0;
      case 7: 
        locald.hNG = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(12939125850112L, 96404);
        return 0;
      case 8: 
        locald.hNH = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(12939125850112L, 96404);
        return 0;
      case 9: 
        locald.hNI = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(12939125850112L, 96404);
        return 0;
      case 10: 
        locald.hNJ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(12939125850112L, 96404);
        return 0;
      case 11: 
        locald.hNK = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(12939125850112L, 96404);
        return 0;
      }
      locald.maxSize = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(12939125850112L, 96404);
      return 0;
    }
    GMTrace.o(12939125850112L, 96404);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */