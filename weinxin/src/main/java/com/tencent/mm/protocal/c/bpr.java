package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bpr
  extends ave
{
  public String fTE;
  public LinkedList<String> umk;
  
  public bpr()
  {
    GMTrace.i(14305730756608L, 106586);
    this.umk = new LinkedList();
    GMTrace.o(14305730756608L, 106586);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(14305864974336L, 106587);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.fTE != null) {
        paramVarArgs.e(2, this.fTE);
      }
      paramVarArgs.d(3, 1, this.umk);
      GMTrace.o(14305864974336L, 106587);
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
      if (this.fTE != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.fTE);
      }
      paramInt = a.a.a.a.c(3, 1, this.umk);
      GMTrace.o(14305864974336L, 106587);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.umk.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(14305864974336L, 106587);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bpr localbpr = (bpr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(14305864974336L, 106587);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localbpr.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(14305864974336L, 106587);
        return 0;
      case 2: 
        localbpr.fTE = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(14305864974336L, 106587);
        return 0;
      }
      localbpr.umk.add(((a.a.a.a.a)localObject1).xky.readString());
      GMTrace.o(14305864974336L, 106587);
      return 0;
    }
    GMTrace.o(14305864974336L, 106587);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */