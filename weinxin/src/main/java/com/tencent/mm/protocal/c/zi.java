package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class zi
  extends ave
{
  public int mse;
  public int tEc;
  public LinkedList<alr> tEd;
  public int tEe;
  public LinkedList<ajt> tEf;
  public int tcg;
  public String tsQ;
  
  public zi()
  {
    GMTrace.i(3963717943296L, 29532);
    this.tEd = new LinkedList();
    this.tEf = new LinkedList();
    GMTrace.o(3963717943296L, 29532);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3963852161024L, 29533);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.mse);
      if (this.tsQ != null) {
        paramVarArgs.e(3, this.tsQ);
      }
      paramVarArgs.eO(4, this.tEc);
      paramVarArgs.d(5, 8, this.tEd);
      paramVarArgs.eO(6, this.tEe);
      paramVarArgs.d(7, 8, this.tEf);
      paramVarArgs.eO(8, this.tcg);
      GMTrace.o(3963852161024L, 29533);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.mse);
      paramInt = i;
      if (this.tsQ != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.tsQ);
      }
      i = a.a.a.a.eL(4, this.tEc);
      int j = a.a.a.a.c(5, 8, this.tEd);
      int k = a.a.a.a.eL(6, this.tEe);
      int m = a.a.a.a.c(7, 8, this.tEf);
      int n = a.a.a.a.eL(8, this.tcg);
      GMTrace.o(3963852161024L, 29533);
      return paramInt + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tEd.clear();
      this.tEf.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3963852161024L, 29533);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      zi localzi = (zi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3963852161024L, 29533);
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
          localzi.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3963852161024L, 29533);
        return 0;
      case 2: 
        localzi.mse = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3963852161024L, 29533);
        return 0;
      case 3: 
        localzi.tsQ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3963852161024L, 29533);
        return 0;
      case 4: 
        localzi.tEc = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3963852161024L, 29533);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alr();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alr)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localzi.tEd.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3963852161024L, 29533);
        return 0;
      case 6: 
        localzi.tEe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3963852161024L, 29533);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ajt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ajt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localzi.tEf.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3963852161024L, 29533);
        return 0;
      }
      localzi.tcg = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3963852161024L, 29533);
      return 0;
    }
    GMTrace.o(3963852161024L, 29533);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/zi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */