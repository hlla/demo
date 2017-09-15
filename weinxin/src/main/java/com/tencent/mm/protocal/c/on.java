package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class on
  extends avm
{
  public long tdE;
  public int tdw;
  public String teo;
  public int the;
  public int tjF;
  public avt tqC;
  public int tsu;
  public int tsw;
  public int tsx;
  
  public on()
  {
    GMTrace.i(4005191221248L, 29841);
    GMTrace.o(4005191221248L, 29841);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4005325438976L, 29842);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      paramVarArgs.eO(1, this.tdw);
      paramVarArgs.eO(2, this.tjF);
      paramVarArgs.eO(3, this.tsu);
      paramVarArgs.eO(5, this.tsw);
      if (this.teo != null) {
        paramVarArgs.e(6, this.teo);
      }
      if (this.tqC != null)
      {
        paramVarArgs.eQ(7, this.tqC.aUd());
        this.tqC.a(paramVarArgs);
      }
      paramVarArgs.eO(8, this.the);
      if (this.tXs != null)
      {
        paramVarArgs.eQ(9, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(10, this.tsx);
      paramVarArgs.O(11, this.tdE);
      GMTrace.o(4005325438976L, 29842);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tdw) + 0 + a.a.a.a.eL(2, this.tjF) + a.a.a.a.eL(3, this.tsu) + a.a.a.a.eL(5, this.tsw);
      paramInt = i;
      if (this.teo != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.teo);
      }
      i = paramInt;
      if (this.tqC != null) {
        i = paramInt + a.a.a.a.eN(7, this.tqC.aUd());
      }
      i += a.a.a.a.eL(8, this.the);
      paramInt = i;
      if (this.tXs != null) {
        paramInt = i + a.a.a.a.eN(9, this.tXs.aUd());
      }
      i = a.a.a.a.eL(10, this.tsx);
      int j = a.a.a.a.N(11, this.tdE);
      GMTrace.o(4005325438976L, 29842);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = avm.a(paramVarArgs); paramInt > 0; paramInt = avm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tqC == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(4005325438976L, 29842);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      on localon = (on)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 4: 
      default: 
        GMTrace.o(4005325438976L, 29842);
        return -1;
      case 1: 
        localon.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4005325438976L, 29842);
        return 0;
      case 2: 
        localon.tjF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4005325438976L, 29842);
        return 0;
      case 3: 
        localon.tsu = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4005325438976L, 29842);
        return 0;
      case 5: 
        localon.tsw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4005325438976L, 29842);
        return 0;
      case 6: 
        localon.teo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4005325438976L, 29842);
        return 0;
      case 7: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localon.tqC = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4005325438976L, 29842);
        return 0;
      case 8: 
        localon.the = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4005325438976L, 29842);
        return 0;
      case 9: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localon.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4005325438976L, 29842);
        return 0;
      case 10: 
        localon.tsx = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4005325438976L, 29842);
        return 0;
      }
      localon.tdE = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(4005325438976L, 29842);
      return 0;
    }
    GMTrace.o(4005325438976L, 29842);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/on.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */