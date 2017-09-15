package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aew
  extends com.tencent.mm.bd.a
{
  public int tIw;
  public LinkedList<amw> tIx;
  public int tIy;
  
  public aew()
  {
    GMTrace.i(13096697462784L, 97578);
    this.tIx = new LinkedList();
    GMTrace.o(13096697462784L, 97578);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13096831680512L, 97579);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tIw);
      paramVarArgs.d(2, 8, this.tIx);
      paramVarArgs.eO(3, this.tIy);
      GMTrace.o(13096831680512L, 97579);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tIw);
      i = a.a.a.a.c(2, 8, this.tIx);
      int j = a.a.a.a.eL(3, this.tIy);
      GMTrace.o(13096831680512L, 97579);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tIx.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13096831680512L, 97579);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aew localaew = (aew)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13096831680512L, 97579);
        return -1;
      case 1: 
        localaew.tIw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096831680512L, 97579);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new amw();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((amw)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaew.tIx.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13096831680512L, 97579);
        return 0;
      }
      localaew.tIy = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13096831680512L, 97579);
      return 0;
    }
    GMTrace.o(13096831680512L, 97579);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */