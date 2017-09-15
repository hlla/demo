package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class gu
  extends com.tencent.mm.bd.a
{
  public gx tji;
  public String tjj;
  public String tjk;
  
  public gu()
  {
    GMTrace.i(3847082737664L, 28663);
    GMTrace.o(3847082737664L, 28663);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3847216955392L, 28664);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tji != null)
      {
        paramVarArgs.eQ(1, this.tji.aUd());
        this.tji.a(paramVarArgs);
      }
      if (this.tjj != null) {
        paramVarArgs.e(2, this.tjj);
      }
      if (this.tjk != null) {
        paramVarArgs.e(3, this.tjk);
      }
      GMTrace.o(3847216955392L, 28664);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tji != null) {
        i = a.a.a.a.eN(1, this.tji.aUd()) + 0;
      }
      paramInt = i;
      if (this.tjj != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.tjj);
      }
      i = paramInt;
      if (this.tjk != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tjk);
      }
      GMTrace.o(3847216955392L, 28664);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3847216955392L, 28664);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      gu localgu = (gu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3847216955392L, 28664);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((gx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localgu.tji = ((gx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3847216955392L, 28664);
        return 0;
      case 2: 
        localgu.tjj = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3847216955392L, 28664);
        return 0;
      }
      localgu.tjk = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3847216955392L, 28664);
      return 0;
    }
    GMTrace.o(3847216955392L, 28664);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/gu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */