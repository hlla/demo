package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bme
  extends com.tencent.mm.bd.a
{
  public avt tdB;
  public String tip;
  public avt tit;
  public String uke;
  
  public bme()
  {
    GMTrace.i(13574109921280L, 101135);
    GMTrace.o(13574109921280L, 101135);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13574244139008L, 101136);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tit == null) {
        throw new b("Not all required fields were included: KSid");
      }
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.uke != null) {
        paramVarArgs.e(1, this.uke);
      }
      if (this.tit != null)
      {
        paramVarArgs.eQ(2, this.tit.aUd());
        this.tit.a(paramVarArgs);
      }
      if (this.tip != null) {
        paramVarArgs.e(3, this.tip);
      }
      if (this.tdB != null)
      {
        paramVarArgs.eQ(4, this.tdB.aUd());
        this.tdB.a(paramVarArgs);
      }
      GMTrace.o(13574244139008L, 101136);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.uke != null) {
        i = a.a.a.b.b.a.f(1, this.uke) + 0;
      }
      paramInt = i;
      if (this.tit != null) {
        paramInt = i + a.a.a.a.eN(2, this.tit.aUd());
      }
      i = paramInt;
      if (this.tip != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tip);
      }
      paramInt = i;
      if (this.tdB != null) {
        paramInt = i + a.a.a.a.eN(4, this.tdB.aUd());
      }
      GMTrace.o(13574244139008L, 101136);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tit == null) {
        throw new b("Not all required fields were included: KSid");
      }
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      GMTrace.o(13574244139008L, 101136);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bme localbme = (bme)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13574244139008L, 101136);
        return -1;
      case 1: 
        localbme.uke = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13574244139008L, 101136);
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
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbme.tit = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13574244139008L, 101136);
        return 0;
      case 3: 
        localbme.tip = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13574244139008L, 101136);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avt();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localbme.tdB = ((avt)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13574244139008L, 101136);
      return 0;
    }
    GMTrace.o(13574244139008L, 101136);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */