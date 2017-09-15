package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class tp
  extends avm
{
  public LinkedList<com.tencent.mm.bd.b> tAn;
  public int tAo;
  public LinkedList<Integer> tAp;
  public int ttV;
  
  public tp()
  {
    GMTrace.i(3929089769472L, 29274);
    this.tAn = new LinkedList();
    this.tAp = new LinkedList();
    GMTrace.o(3929089769472L, 29274);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3929223987200L, 29275);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new a.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.d(2, 6, this.tAn);
      paramVarArgs.eO(3, this.tAo);
      paramVarArgs.eO(4, this.ttV);
      paramVarArgs.d(5, 2, this.tAp);
      GMTrace.o(3929223987200L, 29275);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = a.a.a.a.c(2, 6, this.tAn);
      int j = a.a.a.a.eL(3, this.tAo);
      int k = a.a.a.a.eL(4, this.ttV);
      int m = a.a.a.a.c(5, 2, this.tAp);
      GMTrace.o(3929223987200L, 29275);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tAn.clear();
      this.tAp.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new a.a.a.b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3929223987200L, 29275);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      tp localtp = (tp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3929223987200L, 29275);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localtp.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3929223987200L, 29275);
        return 0;
      case 2: 
        localtp.tAn.add(((a.a.a.a.a)localObject1).chR());
        GMTrace.o(3929223987200L, 29275);
        return 0;
      case 3: 
        localtp.tAo = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3929223987200L, 29275);
        return 0;
      case 4: 
        localtp.ttV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3929223987200L, 29275);
        return 0;
      }
      localtp.tAp.add(Integer.valueOf(((a.a.a.a.a)localObject1).xky.mL()));
      GMTrace.o(3929223987200L, 29275);
      return 0;
    }
    GMTrace.o(3929223987200L, 29275);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/tp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */