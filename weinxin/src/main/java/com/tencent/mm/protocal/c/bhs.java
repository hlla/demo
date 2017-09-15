package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bhs
  extends avm
{
  public int ofk;
  public long tdE;
  public int tdw;
  public avu tdx;
  public avu tdy;
  public int tfd;
  public int tfe;
  public int tff;
  public String tlA;
  public String tlE;
  public avu ufz;
  
  public bhs()
  {
    GMTrace.i(3899293433856L, 29052);
    GMTrace.o(3899293433856L, 29052);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3899427651584L, 29053);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.ufz == null) {
        throw new b("Not all required fields were included: ClientImgId");
      }
      if (this.tdx == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.tdw);
      if (this.ufz != null)
      {
        paramVarArgs.eQ(3, this.ufz.aUd());
        this.ufz.a(paramVarArgs);
      }
      if (this.tdx != null)
      {
        paramVarArgs.eQ(4, this.tdx.aUd());
        this.tdx.a(paramVarArgs);
      }
      if (this.tdy != null)
      {
        paramVarArgs.eQ(5, this.tdy.aUd());
        this.tdy.a(paramVarArgs);
      }
      paramVarArgs.eO(6, this.tfd);
      paramVarArgs.eO(7, this.tfe);
      paramVarArgs.eO(8, this.tff);
      paramVarArgs.eO(9, this.ofk);
      paramVarArgs.O(10, this.tdE);
      if (this.tlA != null) {
        paramVarArgs.e(11, this.tlA);
      }
      if (this.tlE != null) {
        paramVarArgs.e(12, this.tlE);
      }
      GMTrace.o(3899427651584L, 29053);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tdw);
      paramInt = i;
      if (this.ufz != null) {
        paramInt = i + a.a.a.a.eN(3, this.ufz.aUd());
      }
      i = paramInt;
      if (this.tdx != null) {
        i = paramInt + a.a.a.a.eN(4, this.tdx.aUd());
      }
      paramInt = i;
      if (this.tdy != null) {
        paramInt = i + a.a.a.a.eN(5, this.tdy.aUd());
      }
      i = paramInt + a.a.a.a.eL(6, this.tfd) + a.a.a.a.eL(7, this.tfe) + a.a.a.a.eL(8, this.tff) + a.a.a.a.eL(9, this.ofk) + a.a.a.a.N(10, this.tdE);
      paramInt = i;
      if (this.tlA != null) {
        paramInt = i + a.a.a.b.b.a.f(11, this.tlA);
      }
      i = paramInt;
      if (this.tlE != null) {
        i = paramInt + a.a.a.b.b.a.f(12, this.tlE);
      }
      GMTrace.o(3899427651584L, 29053);
      return i;
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
      if (this.ufz == null) {
        throw new b("Not all required fields were included: ClientImgId");
      }
      if (this.tdx == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.tdy == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      GMTrace.o(3899427651584L, 29053);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bhs localbhs = (bhs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3899427651584L, 29053);
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
          localbhs.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3899427651584L, 29053);
        return 0;
      case 2: 
        localbhs.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3899427651584L, 29053);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbhs.ufz = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3899427651584L, 29053);
        return 0;
      case 4: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avu();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbhs.tdx = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3899427651584L, 29053);
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
          for (bool = true; bool; bool = ((avu)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localbhs.tdy = ((avu)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3899427651584L, 29053);
        return 0;
      case 6: 
        localbhs.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3899427651584L, 29053);
        return 0;
      case 7: 
        localbhs.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3899427651584L, 29053);
        return 0;
      case 8: 
        localbhs.tff = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3899427651584L, 29053);
        return 0;
      case 9: 
        localbhs.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3899427651584L, 29053);
        return 0;
      case 10: 
        localbhs.tdE = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3899427651584L, 29053);
        return 0;
      case 11: 
        localbhs.tlA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3899427651584L, 29053);
        return 0;
      }
      localbhs.tlE = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3899427651584L, 29053);
      return 0;
    }
    GMTrace.o(3899427651584L, 29053);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */