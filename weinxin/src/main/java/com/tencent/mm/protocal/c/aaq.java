package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aaq
  extends avm
{
  public int tES;
  public avt tET;
  public String tEU;
  public String tEV;
  public String tEW;
  
  public aaq()
  {
    GMTrace.i(3645085057024L, 27158);
    GMTrace.o(3645085057024L, 27158);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3645219274752L, 27159);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tET == null) {
        throw new b("Not all required fields were included: QRCode");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tET != null)
      {
        paramVarArgs.eQ(2, this.tET.aUd());
        this.tET.a(paramVarArgs);
      }
      paramVarArgs.eO(5, this.tES);
      if (this.tEU != null) {
        paramVarArgs.e(6, this.tEU);
      }
      if (this.tEV != null) {
        paramVarArgs.e(7, this.tEV);
      }
      if (this.tEW != null) {
        paramVarArgs.e(8, this.tEW);
      }
      GMTrace.o(3645219274752L, 27159);
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
      if (this.tET != null) {
        i = paramInt + a.a.a.a.eN(2, this.tET.aUd());
      }
      i += a.a.a.a.eL(5, this.tES);
      paramInt = i;
      if (this.tEU != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tEU);
      }
      i = paramInt;
      if (this.tEV != null) {
        i = paramInt + a.a.a.b.b.a.f(7, this.tEV);
      }
      paramInt = i;
      if (this.tEW != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.tEW);
      }
      GMTrace.o(3645219274752L, 27159);
      return paramInt;
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
      if (this.tET == null) {
        throw new b("Not all required fields were included: QRCode");
      }
      GMTrace.o(3645219274752L, 27159);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aaq localaaq = (aaq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 3: 
      case 4: 
      default: 
        GMTrace.o(3645219274752L, 27159);
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
          localaaq.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3645219274752L, 27159);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localaaq.tET = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3645219274752L, 27159);
        return 0;
      case 5: 
        localaaq.tES = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3645219274752L, 27159);
        return 0;
      case 6: 
        localaaq.tEU = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3645219274752L, 27159);
        return 0;
      case 7: 
        localaaq.tEV = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3645219274752L, 27159);
        return 0;
      }
      localaaq.tEW = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3645219274752L, 27159);
      return 0;
    }
    GMTrace.o(3645219274752L, 27159);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */