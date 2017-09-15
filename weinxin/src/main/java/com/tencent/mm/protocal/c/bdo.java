package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bdo
  extends com.tencent.mm.bd.a
{
  public int udm;
  public int udn;
  public LinkedList<anp> udo;
  
  public bdo()
  {
    GMTrace.i(13096429027328L, 97576);
    this.udo = new LinkedList();
    GMTrace.o(13096429027328L, 97576);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13096563245056L, 97577);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.udm);
      paramVarArgs.eO(2, this.udn);
      paramVarArgs.d(3, 8, this.udo);
      GMTrace.o(13096563245056L, 97577);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.udm);
      i = a.a.a.a.eL(2, this.udn);
      int j = a.a.a.a.c(3, 8, this.udo);
      GMTrace.o(13096563245056L, 97577);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.udo.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13096563245056L, 97577);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bdo localbdo = (bdo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13096563245056L, 97577);
        return -1;
      case 1: 
        localbdo.udm = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096563245056L, 97577);
        return 0;
      case 2: 
        localbdo.udn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13096563245056L, 97577);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new anp();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((anp)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbdo.udo.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(13096563245056L, 97577);
      return 0;
    }
    GMTrace.o(13096563245056L, 97577);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */