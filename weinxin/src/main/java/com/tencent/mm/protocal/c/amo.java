package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class amo
  extends com.tencent.mm.bd.a
{
  public aqi tPk;
  public String tPo;
  
  public amo()
  {
    GMTrace.i(3723333992448L, 27741);
    GMTrace.o(3723333992448L, 27741);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3723468210176L, 27742);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tPo == null) {
        throw new b("Not all required fields were included: ContactUsername");
      }
      if (this.tPk == null) {
        throw new b("Not all required fields were included: PhoneNumListInfo");
      }
      if (this.tPo != null) {
        paramVarArgs.e(1, this.tPo);
      }
      if (this.tPk != null)
      {
        paramVarArgs.eQ(2, this.tPk.aUd());
        this.tPk.a(paramVarArgs);
      }
      GMTrace.o(3723468210176L, 27742);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tPo != null) {
        paramInt = a.a.a.b.b.a.f(1, this.tPo) + 0;
      }
      i = paramInt;
      if (this.tPk != null) {
        i = paramInt + a.a.a.a.eN(2, this.tPk.aUd());
      }
      GMTrace.o(3723468210176L, 27742);
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
      if (this.tPo == null) {
        throw new b("Not all required fields were included: ContactUsername");
      }
      if (this.tPk == null) {
        throw new b("Not all required fields were included: PhoneNumListInfo");
      }
      GMTrace.o(3723468210176L, 27742);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      amo localamo = (amo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3723468210176L, 27742);
        return -1;
      case 1: 
        localamo.tPo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3723468210176L, 27742);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aqi();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aqi)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localamo.tPk = ((aqi)localObject1);
        paramInt += 1;
      }
      GMTrace.o(3723468210176L, 27742);
      return 0;
    }
    GMTrace.o(3723468210176L, 27742);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/amo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */