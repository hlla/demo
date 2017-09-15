package com.tencent.mm.protocal.b.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.rl;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bd.a
{
  public String desc;
  public LinkedList<rl> hkc;
  public String sZz;
  public String title;
  
  public c()
  {
    GMTrace.i(4079816278016L, 30397);
    this.hkc = new LinkedList();
    GMTrace.o(4079816278016L, 30397);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4079950495744L, 30398);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      paramVarArgs.d(3, 8, this.hkc);
      if (this.sZz != null) {
        paramVarArgs.e(4, this.sZz);
      }
      GMTrace.o(4079950495744L, 30398);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.title != null) {
        paramInt = a.a.a.b.b.a.f(1, this.title) + 0;
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.desc);
      }
      i += a.a.a.a.c(3, 8, this.hkc);
      paramInt = i;
      if (this.sZz != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.sZz);
      }
      GMTrace.o(4079950495744L, 30398);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hkc.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4079950495744L, 30398);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4079950495744L, 30398);
        return -1;
      case 1: 
        localc.title = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4079950495744L, 30398);
        return 0;
      case 2: 
        localc.desc = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4079950495744L, 30398);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rl();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((rl)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localc.hkc.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(4079950495744L, 30398);
        return 0;
      }
      localc.sZz = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(4079950495744L, 30398);
      return 0;
    }
    GMTrace.o(4079950495744L, 30398);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */