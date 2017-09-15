package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class ps
  extends ave
{
  public int teq;
  public String tiV;
  public b trQ;
  public b tui;
  
  public ps()
  {
    GMTrace.i(3767357407232L, 28069);
    GMTrace.o(3767357407232L, 28069);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3767491624960L, 28070);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.tiV != null) {
        paramVarArgs.e(2, this.tiV);
      }
      paramVarArgs.eO(3, this.teq);
      if (this.tui != null) {
        paramVarArgs.b(4, this.tui);
      }
      if (this.trQ != null) {
        paramVarArgs.b(5, this.trQ);
      }
      GMTrace.o(3767491624960L, 28070);
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
      if (this.tiV != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.tiV);
      }
      i += a.a.a.a.eL(3, this.teq);
      paramInt = i;
      if (this.tui != null) {
        paramInt = i + a.a.a.a.a(4, this.tui);
      }
      i = paramInt;
      if (this.trQ != null) {
        i = paramInt + a.a.a.a.a(5, this.trQ);
      }
      GMTrace.o(3767491624960L, 28070);
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
      GMTrace.o(3767491624960L, 28070);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ps localps = (ps)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3767491624960L, 28070);
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
          localps.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3767491624960L, 28070);
        return 0;
      case 2: 
        localps.tiV = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3767491624960L, 28070);
        return 0;
      case 3: 
        localps.teq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3767491624960L, 28070);
        return 0;
      case 4: 
        localps.tui = ((a.a.a.a.a)localObject1).chR();
        GMTrace.o(3767491624960L, 28070);
        return 0;
      }
      localps.trQ = ((a.a.a.a.a)localObject1).chR();
      GMTrace.o(3767491624960L, 28070);
      return 0;
    }
    GMTrace.o(3767491624960L, 28070);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */