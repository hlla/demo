package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class xc
  extends ave
{
  public int tCc;
  public int tCd;
  public LinkedList<avu> tCe;
  public int tCf;
  public LinkedList<avu> tCg;
  public int tCh;
  public avu tCi;
  public LinkedList<avu> thh;
  
  public xc()
  {
    GMTrace.i(4051496337408L, 30186);
    this.thh = new LinkedList();
    this.tCe = new LinkedList();
    this.tCg = new LinkedList();
    GMTrace.o(4051496337408L, 30186);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4051630555136L, 30187);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tCc);
      paramVarArgs.d(3, 8, this.thh);
      paramVarArgs.eO(4, this.tCd);
      paramVarArgs.d(5, 8, this.tCe);
      paramVarArgs.eO(6, this.tCf);
      paramVarArgs.d(7, 8, this.tCg);
      paramVarArgs.eO(8, this.tCh);
      if (this.tCi != null)
      {
        paramVarArgs.eQ(9, this.tCi.aUd());
        this.tCi.a(paramVarArgs);
      }
      GMTrace.o(4051630555136L, 30187);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tCc) + a.a.a.a.c(3, 8, this.thh) + a.a.a.a.eL(4, this.tCd) + a.a.a.a.c(5, 8, this.tCe) + a.a.a.a.eL(6, this.tCf) + a.a.a.a.c(7, 8, this.tCg) + a.a.a.a.eL(8, this.tCh);
      paramInt = i;
      if (this.tCi != null) {
        paramInt = i + a.a.a.a.eN(9, this.tCi.aUd());
      }
      GMTrace.o(4051630555136L, 30187);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.thh.clear();
      this.tCe.clear();
      this.tCg.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4051630555136L, 30187);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      xc localxc = (xc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(4051630555136L, 30187);
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
          localxc.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4051630555136L, 30187);
        return 0;
      case 2: 
        localxc.tCc = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4051630555136L, 30187);
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
          localxc.thh.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(4051630555136L, 30187);
        return 0;
      case 4: 
        localxc.tCd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4051630555136L, 30187);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localxc.tCe.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(4051630555136L, 30187);
        return 0;
      case 6: 
        localxc.tCf = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4051630555136L, 30187);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localxc.tCg.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(4051630555136L, 30187);
        return 0;
      case 8: 
        localxc.tCh = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4051630555136L, 30187);
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
        localxc.tCi = ((avu)localObject1);
        paramInt += 1;
      }
      GMTrace.o(4051630555136L, 30187);
      return 0;
    }
    GMTrace.o(4051630555136L, 30187);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/xc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */