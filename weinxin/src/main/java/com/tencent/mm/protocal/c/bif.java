package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bif
  extends avm
{
  public String mut;
  public String muu;
  public int ofk;
  public long tdE;
  public int tdw;
  public String teo;
  public int the;
  public int tjF;
  public int tsu;
  public int tsw;
  public int tsx;
  
  public bif()
  {
    GMTrace.i(3985595432960L, 29695);
    GMTrace.o(3985595432960L, 29695);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3985729650688L, 29696);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.muu != null) {
        paramVarArgs.e(1, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.e(2, this.mut);
      }
      paramVarArgs.eO(3, this.tjF);
      paramVarArgs.eO(4, this.tsu);
      paramVarArgs.eO(5, this.ofk);
      if (this.teo != null) {
        paramVarArgs.e(6, this.teo);
      }
      paramVarArgs.eO(7, this.tdw);
      paramVarArgs.eO(8, this.tsw);
      paramVarArgs.eO(9, this.the);
      if (this.tXs != null)
      {
        paramVarArgs.eQ(10, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(11, this.tsx);
      paramVarArgs.O(12, this.tdE);
      GMTrace.o(3985729650688L, 29696);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.muu != null) {
        paramInt = a.a.a.b.b.a.f(1, this.muu) + 0;
      }
      i = paramInt;
      if (this.mut != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.mut);
      }
      i = i + a.a.a.a.eL(3, this.tjF) + a.a.a.a.eL(4, this.tsu) + a.a.a.a.eL(5, this.ofk);
      paramInt = i;
      if (this.teo != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.teo);
      }
      i = paramInt + a.a.a.a.eL(7, this.tdw) + a.a.a.a.eL(8, this.tsw) + a.a.a.a.eL(9, this.the);
      paramInt = i;
      if (this.tXs != null) {
        paramInt = i + a.a.a.a.eN(10, this.tXs.aUd());
      }
      i = a.a.a.a.eL(11, this.tsx);
      int j = a.a.a.a.N(12, this.tdE);
      GMTrace.o(3985729650688L, 29696);
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
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      GMTrace.o(3985729650688L, 29696);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bif localbif = (bif)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3985729650688L, 29696);
        return -1;
      case 1: 
        localbif.muu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3985729650688L, 29696);
        return 0;
      case 2: 
        localbif.mut = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3985729650688L, 29696);
        return 0;
      case 3: 
        localbif.tjF = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3985729650688L, 29696);
        return 0;
      case 4: 
        localbif.tsu = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3985729650688L, 29696);
        return 0;
      case 5: 
        localbif.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3985729650688L, 29696);
        return 0;
      case 6: 
        localbif.teo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3985729650688L, 29696);
        return 0;
      case 7: 
        localbif.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3985729650688L, 29696);
        return 0;
      case 8: 
        localbif.tsw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3985729650688L, 29696);
        return 0;
      case 9: 
        localbif.the = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3985729650688L, 29696);
        return 0;
      case 10: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbif.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3985729650688L, 29696);
        return 0;
      case 11: 
        localbif.tsx = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3985729650688L, 29696);
        return 0;
      }
      localbif.tdE = ((a.a.a.a.a)localObject1).xky.mM();
      GMTrace.o(3985729650688L, 29696);
      return 0;
    }
    GMTrace.o(3985729650688L, 29696);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */