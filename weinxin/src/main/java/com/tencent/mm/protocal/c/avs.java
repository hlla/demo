package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class avs
  extends com.tencent.mm.bd.a
{
  public avu tJy;
  public avu trH;
  
  public avs()
  {
    GMTrace.i(13341644816384L, 99403);
    GMTrace.o(13341644816384L, 99403);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13341779034112L, 99404);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.tJy == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.trH != null)
      {
        paramVarArgs.eQ(1, this.trH.aUd());
        this.trH.a(paramVarArgs);
      }
      if (this.tJy != null)
      {
        paramVarArgs.eQ(2, this.tJy.aUd());
        this.tJy.a(paramVarArgs);
      }
      GMTrace.o(13341779034112L, 99404);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.trH != null) {
        paramInt = a.a.a.a.eN(1, this.trH.aUd()) + 0;
      }
      i = paramInt;
      if (this.tJy != null) {
        i = paramInt + a.a.a.a.eN(2, this.tJy.aUd());
      }
      GMTrace.o(13341779034112L, 99404);
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
      if (this.trH == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.tJy == null) {
        throw new b("Not all required fields were included: NickName");
      }
      GMTrace.o(13341779034112L, 99404);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      avs localavs = (avs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13341779034112L, 99404);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localavs.trH = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13341779034112L, 99404);
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
        for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localavs.tJy = ((avu)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13341779034112L, 99404);
      return 0;
    }
    GMTrace.o(13341779034112L, 99404);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/avs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */