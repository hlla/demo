package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ang
  extends com.tencent.mm.bd.a
{
  public afa tif;
  public hr tig;
  public ane tih;
  
  public ang()
  {
    GMTrace.i(13575854751744L, 101148);
    GMTrace.o(13575854751744L, 101148);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13575988969472L, 101149);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tif != null)
      {
        paramVarArgs.eQ(1, this.tif.aUd());
        this.tif.a(paramVarArgs);
      }
      if (this.tih != null)
      {
        paramVarArgs.eQ(2, this.tih.aUd());
        this.tih.a(paramVarArgs);
      }
      if (this.tig != null)
      {
        paramVarArgs.eQ(3, this.tig.aUd());
        this.tig.a(paramVarArgs);
      }
      GMTrace.o(13575988969472L, 101149);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tif != null) {
        i = a.a.a.a.eN(1, this.tif.aUd()) + 0;
      }
      paramInt = i;
      if (this.tih != null) {
        paramInt = i + a.a.a.a.eN(2, this.tih.aUd());
      }
      i = paramInt;
      if (this.tig != null) {
        i = paramInt + a.a.a.a.eN(3, this.tig.aUd());
      }
      GMTrace.o(13575988969472L, 101149);
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
      GMTrace.o(13575988969472L, 101149);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ang localang = (ang)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13575988969472L, 101149);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afa();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afa)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localang.tif = ((afa)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13575988969472L, 101149);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ane();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ane)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localang.tih = ((ane)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13575988969472L, 101149);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new hr();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((hr)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localang.tig = ((hr)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13575988969472L, 101149);
      return 0;
    }
    GMTrace.o(13575988969472L, 101149);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */