package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bfo
  extends avm
{
  public int fIq;
  public String fIr;
  public String ues;
  public String uet;
  public azx ueu;
  public int version;
  
  public bfo()
  {
    GMTrace.i(3851914575872L, 28699);
    GMTrace.o(3851914575872L, 28699);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3852048793600L, 28700);
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
      paramVarArgs.eO(2, this.fIq);
      if (this.fIr != null) {
        paramVarArgs.e(3, this.fIr);
      }
      if (this.ues != null) {
        paramVarArgs.e(4, this.ues);
      }
      if (this.uet != null) {
        paramVarArgs.e(5, this.uet);
      }
      if (this.ueu != null)
      {
        paramVarArgs.eQ(6, this.ueu.aUd());
        this.ueu.a(paramVarArgs);
      }
      paramVarArgs.eO(7, this.version);
      GMTrace.o(3852048793600L, 28700);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.fIq);
      paramInt = i;
      if (this.fIr != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.fIr);
      }
      i = paramInt;
      if (this.ues != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.ues);
      }
      paramInt = i;
      if (this.uet != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.uet);
      }
      i = paramInt;
      if (this.ueu != null) {
        i = paramInt + a.a.a.a.eN(6, this.ueu.aUd());
      }
      paramInt = a.a.a.a.eL(7, this.version);
      GMTrace.o(3852048793600L, 28700);
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
      GMTrace.o(3852048793600L, 28700);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bfo localbfo = (bfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3852048793600L, 28700);
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
          localbfo.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3852048793600L, 28700);
        return 0;
      case 2: 
        localbfo.fIq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3852048793600L, 28700);
        return 0;
      case 3: 
        localbfo.fIr = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3852048793600L, 28700);
        return 0;
      case 4: 
        localbfo.ues = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3852048793600L, 28700);
        return 0;
      case 5: 
        localbfo.uet = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3852048793600L, 28700);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbfo.ueu = ((azx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3852048793600L, 28700);
        return 0;
      }
      localbfo.version = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3852048793600L, 28700);
      return 0;
    }
    GMTrace.o(3852048793600L, 28700);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */