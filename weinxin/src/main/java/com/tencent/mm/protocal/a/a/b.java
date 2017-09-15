package com.tencent.mm.protocal.a.a;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bd.a
{
  public int nettype;
  public int sYH;
  public LinkedList<a> sYI;
  public int uin;
  
  public b()
  {
    GMTrace.i(13100858212352L, 97609);
    this.sYI = new LinkedList();
    GMTrace.o(13100858212352L, 97609);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13100992430080L, 97610);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.uin);
      paramVarArgs.eO(2, this.sYH);
      paramVarArgs.d(3, 8, this.sYI);
      paramVarArgs.eO(4, this.nettype);
      GMTrace.o(13100992430080L, 97610);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.uin);
      i = a.a.a.a.eL(2, this.sYH);
      int j = a.a.a.a.c(3, 8, this.sYI);
      int k = a.a.a.a.eL(4, this.nettype);
      GMTrace.o(13100992430080L, 97610);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sYI.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(13100992430080L, 97610);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(13100992430080L, 97610);
        return -1;
      case 1: 
        localb.uin = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13100992430080L, 97610);
        return 0;
      case 2: 
        localb.sYH = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13100992430080L, 97610);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((a)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localb.sYI.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(13100992430080L, 97610);
        return 0;
      }
      localb.nettype = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13100992430080L, 97610);
      return 0;
    }
    GMTrace.o(13100992430080L, 97610);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */