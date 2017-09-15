package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class aks
  extends com.tencent.mm.bd.a
{
  public String jLx;
  public or tgd;
  public avt thY;
  public String tie;
  public String tio;
  
  public aks()
  {
    GMTrace.i(13580283936768L, 101181);
    GMTrace.o(13580283936768L, 101181);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13580418154496L, 101182);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.thY == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      if (this.tgd == null) {
        throw new b("Not all required fields were included: CliPubECDHKey");
      }
      if (this.thY != null)
      {
        paramVarArgs.eQ(1, this.thY.aUd());
        this.thY.a(paramVarArgs);
      }
      if (this.tgd != null)
      {
        paramVarArgs.eQ(2, this.tgd.aUd());
        this.tgd.a(paramVarArgs);
      }
      if (this.jLx != null) {
        paramVarArgs.e(3, this.jLx);
      }
      if (this.tie != null) {
        paramVarArgs.e(4, this.tie);
      }
      if (this.tio != null) {
        paramVarArgs.e(5, this.tio);
      }
      GMTrace.o(13580418154496L, 101182);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.thY != null) {
        i = a.a.a.a.eN(1, this.thY.aUd()) + 0;
      }
      paramInt = i;
      if (this.tgd != null) {
        paramInt = i + a.a.a.a.eN(2, this.tgd.aUd());
      }
      i = paramInt;
      if (this.jLx != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.jLx);
      }
      paramInt = i;
      if (this.tie != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tie);
      }
      i = paramInt;
      if (this.tio != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tio);
      }
      GMTrace.o(13580418154496L, 101182);
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
      if (this.thY == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      if (this.tgd == null) {
        throw new b("Not all required fields were included: CliPubECDHKey");
      }
      GMTrace.o(13580418154496L, 101182);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      aks localaks = (aks)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13580418154496L, 101182);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaks.thY = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13580418154496L, 101182);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new or();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((or)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaks.tgd = ((or)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13580418154496L, 101182);
        return 0;
      case 3: 
        localaks.jLx = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13580418154496L, 101182);
        return 0;
      case 4: 
        localaks.tie = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13580418154496L, 101182);
        return 0;
      }
      localaks.tio = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(13580418154496L, 101182);
      return 0;
    }
    GMTrace.o(13580418154496L, 101182);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/aks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */