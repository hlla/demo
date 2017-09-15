package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class axx
  extends com.tencent.mm.bd.a
{
  public String fFN;
  public int hYE;
  public int hZV;
  public int hhs;
  public int hht;
  public String hhu;
  public String pZk;
  public LinkedList<bfe> tYD;
  public int tYE;
  public String url;
  
  public axx()
  {
    GMTrace.i(3954859573248L, 29466);
    this.tYD = new LinkedList();
    GMTrace.o(3954859573248L, 29466);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3954993790976L, 29467);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.pZk == null) {
        throw new b("Not all required fields were included: clientID");
      }
      paramVarArgs.d(1, 8, this.tYD);
      if (this.pZk != null) {
        paramVarArgs.e(2, this.pZk);
      }
      if (this.fFN != null) {
        paramVarArgs.e(3, this.fFN);
      }
      if (this.hhu != null) {
        paramVarArgs.e(4, this.hhu);
      }
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      paramVarArgs.eO(6, this.hZV);
      paramVarArgs.eO(7, this.hYE);
      paramVarArgs.eO(8, this.tYE);
      paramVarArgs.eO(9, this.hhs);
      paramVarArgs.eO(10, this.hht);
      GMTrace.o(3954993790976L, 29467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.c(1, 8, this.tYD) + 0;
      paramInt = i;
      if (this.pZk != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.pZk);
      }
      i = paramInt;
      if (this.fFN != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.fFN);
      }
      paramInt = i;
      if (this.hhu != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.hhu);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.url);
      }
      paramInt = a.a.a.a.eL(6, this.hZV);
      int j = a.a.a.a.eL(7, this.hYE);
      int k = a.a.a.a.eL(8, this.tYE);
      int m = a.a.a.a.eL(9, this.hhs);
      int n = a.a.a.a.eL(10, this.hht);
      GMTrace.o(3954993790976L, 29467);
      return i + paramInt + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tYD.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.pZk == null) {
        throw new b("Not all required fields were included: clientID");
      }
      GMTrace.o(3954993790976L, 29467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      axx localaxx = (axx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3954993790976L, 29467);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfe();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bfe)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaxx.tYD.add(localObject1);
          paramInt += 1;
        }
        GMTrace.o(3954993790976L, 29467);
        return 0;
      case 2: 
        localaxx.pZk = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3954993790976L, 29467);
        return 0;
      case 3: 
        localaxx.fFN = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3954993790976L, 29467);
        return 0;
      case 4: 
        localaxx.hhu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3954993790976L, 29467);
        return 0;
      case 5: 
        localaxx.url = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3954993790976L, 29467);
        return 0;
      case 6: 
        localaxx.hZV = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3954993790976L, 29467);
        return 0;
      case 7: 
        localaxx.hYE = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3954993790976L, 29467);
        return 0;
      case 8: 
        localaxx.tYE = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3954993790976L, 29467);
        return 0;
      case 9: 
        localaxx.hhs = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3954993790976L, 29467);
        return 0;
      }
      localaxx.hht = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(3954993790976L, 29467);
      return 0;
    }
    GMTrace.o(3954993790976L, 29467);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/axx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */