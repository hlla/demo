package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class wm
  extends avm
{
  public int tAK;
  public atb tBy;
  
  public wm()
  {
    GMTrace.i(13575183663104L, 101143);
    GMTrace.o(13575183663104L, 101143);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13575317880832L, 101144);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tBy == null) {
        throw new b("Not all required fields were included: CertValue");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tBy != null)
      {
        paramVarArgs.eQ(2, this.tBy.aUd());
        this.tBy.a(paramVarArgs);
      }
      paramVarArgs.eO(3, this.tAK);
      GMTrace.o(13575317880832L, 101144);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt;
      if (this.tBy != null) {
        i = paramInt + a.a.a.a.eN(2, this.tBy.aUd());
      }
      paramInt = a.a.a.a.eL(3, this.tAK);
      GMTrace.o(13575317880832L, 101144);
      return i + paramInt;
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
      if (this.tBy == null) {
        throw new b("Not all required fields were included: CertValue");
      }
      GMTrace.o(13575317880832L, 101144);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      wm localwm = (wm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13575317880832L, 101144);
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
          localwm.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13575317880832L, 101144);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new atb();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((atb)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localwm.tBy = ((atb)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13575317880832L, 101144);
        return 0;
      }
      localwm.tAK = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13575317880832L, 101144);
      return 0;
    }
    GMTrace.o(13575317880832L, 101144);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/wm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */