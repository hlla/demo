package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aak
  extends avm
{
  public amt tEG;
  public bih tEH;
  
  public aak()
  {
    GMTrace.i(13169577689088L, 98121);
    GMTrace.o(13169577689088L, 98121);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13169711906816L, 98122);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tEG == null) {
        throw new b("Not all required fields were included: UserInfo");
      }
      if (this.tEH == null) {
        throw new b("Not all required fields were included: UserInfoExt");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tEG != null)
      {
        paramVarArgs.eQ(2, this.tEG.aUd());
        this.tEG.a(paramVarArgs);
      }
      if (this.tEH != null)
      {
        paramVarArgs.eQ(3, this.tEH.aUd());
        this.tEH.a(paramVarArgs);
      }
      GMTrace.o(13169711906816L, 98122);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXs != null) {
        i = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      paramInt = i;
      if (this.tEG != null) {
        paramInt = i + a.a.a.a.eN(2, this.tEG.aUd());
      }
      i = paramInt;
      if (this.tEH != null) {
        i = paramInt + a.a.a.a.eN(3, this.tEH.aUd());
      }
      GMTrace.o(13169711906816L, 98122);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tEG == null) {
        throw new b("Not all required fields were included: UserInfo");
      }
      if (this.tEH == null) {
        throw new b("Not all required fields were included: UserInfoExt");
      }
      GMTrace.o(13169711906816L, 98122);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aak localaak = (aak)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13169711906816L, 98122);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localaak.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13169711906816L, 98122);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new amt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((amt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localaak.tEG = ((amt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13169711906816L, 98122);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bih();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bih)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localaak.tEH = ((bih)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13169711906816L, 98122);
      return 0;
    }
    GMTrace.o(13169711906816L, 98122);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */