package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bu
  extends com.tencent.mm.bd.a
{
  public int jLP;
  public int mrC;
  public int ofk;
  public int tdA;
  public avt tdB;
  public String tdC;
  public String tdD;
  public long tdE;
  public int tdF;
  public int tdw;
  public avu tdx;
  public avu tdy;
  public avu tdz;
  
  public bu()
  {
    GMTrace.i(13575586316288L, 101146);
    GMTrace.o(13575586316288L, 101146);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13575720534016L, 101147);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tdx == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.tdz == null) {
        throw new b("Not all required fields were included: Content");
      }
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      paramVarArgs.eO(1, this.tdw);
      if (this.tdx != null)
      {
        paramVarArgs.eQ(2, this.tdx.aUd());
        this.tdx.a(paramVarArgs);
      }
      if (this.tdy != null)
      {
        paramVarArgs.eQ(3, this.tdy.aUd());
        this.tdy.a(paramVarArgs);
      }
      paramVarArgs.eO(4, this.mrC);
      if (this.tdz != null)
      {
        paramVarArgs.eQ(5, this.tdz.aUd());
        this.tdz.a(paramVarArgs);
      }
      paramVarArgs.eO(6, this.jLP);
      paramVarArgs.eO(7, this.tdA);
      if (this.tdB != null)
      {
        paramVarArgs.eQ(8, this.tdB.aUd());
        this.tdB.a(paramVarArgs);
      }
      paramVarArgs.eO(9, this.ofk);
      if (this.tdC != null) {
        paramVarArgs.e(10, this.tdC);
      }
      if (this.tdD != null) {
        paramVarArgs.e(11, this.tdD);
      }
      paramVarArgs.O(12, this.tdE);
      paramVarArgs.eO(13, this.tdF);
      GMTrace.o(13575720534016L, 101147);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tdw) + 0;
      paramInt = i;
      if (this.tdx != null) {
        paramInt = i + a.a.a.a.eN(2, this.tdx.aUd());
      }
      i = paramInt;
      if (this.tdy != null) {
        i = paramInt + a.a.a.a.eN(3, this.tdy.aUd());
      }
      i += a.a.a.a.eL(4, this.mrC);
      paramInt = i;
      if (this.tdz != null) {
        paramInt = i + a.a.a.a.eN(5, this.tdz.aUd());
      }
      i = paramInt + a.a.a.a.eL(6, this.jLP) + a.a.a.a.eL(7, this.tdA);
      paramInt = i;
      if (this.tdB != null) {
        paramInt = i + a.a.a.a.eN(8, this.tdB.aUd());
      }
      i = paramInt + a.a.a.a.eL(9, this.ofk);
      paramInt = i;
      if (this.tdC != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.tdC);
      }
      i = paramInt;
      if (this.tdD != null) {
        i = paramInt + a.a.a.b.b.a.f(11, this.tdD);
      }
      paramInt = a.a.a.a.N(12, this.tdE);
      int j = a.a.a.a.eL(13, this.tdF);
      GMTrace.o(13575720534016L, 101147);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tdx == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.tdz == null) {
        throw new b("Not all required fields were included: Content");
      }
      if (this.tdB == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      GMTrace.o(13575720534016L, 101147);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bu localbu = (bu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13575720534016L, 101147);
        return -1;
      case 1: 
        localbu.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbu.tdx = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbu.tdy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 4: 
        localbu.mrC = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbu.tdz = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 6: 
        localbu.jLP = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 7: 
        localbu.tdA = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 8: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localbu.tdB = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 9: 
        localbu.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 10: 
        localbu.tdC = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 11: 
        localbu.tdD = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(13575720534016L, 101147);
        return 0;
      case 12: 
        localbu.tdE = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(13575720534016L, 101147);
        return 0;
      }
      localbu.tdF = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13575720534016L, 101147);
      return 0;
    }
    GMTrace.o(13575720534016L, 101147);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */