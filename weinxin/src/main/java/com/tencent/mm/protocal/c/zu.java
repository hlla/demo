package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class zu
  extends avm
{
  public int jLr;
  public LinkedList<aoy> jLs;
  public int jMq;
  public int tEt;
  public int tkt;
  
  public zu()
  {
    GMTrace.i(3909493981184L, 29128);
    this.jLs = new LinkedList();
    GMTrace.o(3909493981184L, 29128);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3909628198912L, 29129);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.jLr);
      paramVarArgs.d(3, 8, this.jLs);
      paramVarArgs.eO(4, this.tkt);
      paramVarArgs.eO(5, this.tEt);
      paramVarArgs.eO(6, this.jMq);
      GMTrace.o(3909628198912L, 29129);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = a.a.a.a.eL(2, this.jLr);
      int j = a.a.a.a.c(3, 8, this.jLs);
      int k = a.a.a.a.eL(4, this.tkt);
      int m = a.a.a.a.eL(5, this.tEt);
      int n = a.a.a.a.eL(6, this.jMq);
      GMTrace.o(3909628198912L, 29129);
      return paramInt + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.jLs.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3909628198912L, 29129);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      zu localzu = (zu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3909628198912L, 29129);
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
          localzu.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3909628198912L, 29129);
        return 0;
      case 2: 
        localzu.jLr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3909628198912L, 29129);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aoy();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aoy)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localzu.jLs.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3909628198912L, 29129);
        return 0;
      case 4: 
        localzu.tkt = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3909628198912L, 29129);
        return 0;
      case 5: 
        localzu.tEt = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3909628198912L, 29129);
        return 0;
      }
      localzu.jMq = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3909628198912L, 29129);
      return 0;
    }
    GMTrace.o(3909628198912L, 29129);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/zu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */