package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class zt
  extends ave
{
  public int jLr;
  public LinkedList<aoy> jLs;
  public int jMq;
  public int tdn;
  
  public zt()
  {
    GMTrace.i(3726286782464L, 27763);
    this.jLs = new LinkedList();
    GMTrace.o(3726286782464L, 27763);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3726421000192L, 27764);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.jLr);
      paramVarArgs.d(3, 8, this.jLs);
      paramVarArgs.eO(4, this.jMq);
      paramVarArgs.eO(5, this.tdn);
      GMTrace.o(3726421000192L, 27764);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXb != null) {
        paramInt = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.jLr);
      int j = a.a.a.a.c(3, 8, this.jLs);
      int k = a.a.a.a.eL(4, this.jMq);
      int m = a.a.a.a.eL(5, this.tdn);
      GMTrace.o(3726421000192L, 27764);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.jLs.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3726421000192L, 27764);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      zt localzt = (zt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3726421000192L, 27764);
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
          localzt.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3726421000192L, 27764);
        return 0;
      case 2: 
        localzt.jLr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3726421000192L, 27764);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aoy();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aoy)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localzt.jLs.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3726421000192L, 27764);
        return 0;
      case 4: 
        localzt.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3726421000192L, 27764);
        return 0;
      }
      localzt.tdn = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3726421000192L, 27764);
      return 0;
    }
    GMTrace.o(3726421000192L, 27764);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/zt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */