package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aam
  extends avm
{
  public int mse;
  public ash tEJ;
  public asf tEK;
  
  public aam()
  {
    GMTrace.i(3643474444288L, 27146);
    GMTrace.o(3643474444288L, 27146);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3643608662016L, 27147);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tEJ == null) {
        throw new b("Not all required fields were included: QQGroup");
      }
      if (this.tEK == null) {
        throw new b("Not all required fields were included: QQFriend");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.mse);
      if (this.tEJ != null)
      {
        paramVarArgs.eQ(3, this.tEJ.aUd());
        this.tEJ.a(paramVarArgs);
      }
      if (this.tEK != null)
      {
        paramVarArgs.eQ(4, this.tEK.aUd());
        this.tEK.a(paramVarArgs);
      }
      GMTrace.o(3643608662016L, 27147);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.mse);
      paramInt = i;
      if (this.tEJ != null) {
        paramInt = i + a.a.a.a.eN(3, this.tEJ.aUd());
      }
      i = paramInt;
      if (this.tEK != null) {
        i = paramInt + a.a.a.a.eN(4, this.tEK.aUd());
      }
      GMTrace.o(3643608662016L, 27147);
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
      if (this.tEJ == null) {
        throw new b("Not all required fields were included: QQGroup");
      }
      if (this.tEK == null) {
        throw new b("Not all required fields were included: QQFriend");
      }
      GMTrace.o(3643608662016L, 27147);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aam localaam = (aam)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3643608662016L, 27147);
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
          localaam.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3643608662016L, 27147);
        return 0;
      case 2: 
        localaam.mse = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3643608662016L, 27147);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ash();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ash)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localaam.tEJ = ((ash)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3643608662016L, 27147);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new asf();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((asf)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
        localaam.tEK = ((asf)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3643608662016L, 27147);
      return 0;
    }
    GMTrace.o(3643608662016L, 27147);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */