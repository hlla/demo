package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class axk
  extends avm
{
  public int jMq;
  public String mrA;
  public String mut;
  public String muu;
  public int ofk;
  public long tdE;
  public int tdw;
  public String teo;
  public String tlA;
  
  public axk()
  {
    GMTrace.i(3654346080256L, 27227);
    GMTrace.o(3654346080256L, 27227);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3654480297984L, 27228);
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
      if (this.mrA != null) {
        paramVarArgs.e(2, this.mrA);
      }
      if (this.muu != null) {
        paramVarArgs.e(3, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.e(4, this.mut);
      }
      paramVarArgs.eO(5, this.tdw);
      if (this.teo != null) {
        paramVarArgs.e(6, this.teo);
      }
      paramVarArgs.eO(7, this.ofk);
      paramVarArgs.eO(8, this.jMq);
      paramVarArgs.O(9, this.tdE);
      if (this.tlA != null) {
        paramVarArgs.e(10, this.tlA);
      }
      GMTrace.o(3654480297984L, 27228);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXs != null) {
        i = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      paramInt = i;
      if (this.mrA != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.mrA);
      }
      i = paramInt;
      if (this.muu != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.muu);
      }
      paramInt = i;
      if (this.mut != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.mut);
      }
      i = paramInt + a.a.a.a.eL(5, this.tdw);
      paramInt = i;
      if (this.teo != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.teo);
      }
      i = paramInt + a.a.a.a.eL(7, this.ofk) + a.a.a.a.eL(8, this.jMq) + a.a.a.a.N(9, this.tdE);
      paramInt = i;
      if (this.tlA != null) {
        paramInt = i + a.a.a.b.b.a.f(10, this.tlA);
      }
      GMTrace.o(3654480297984L, 27228);
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
      GMTrace.o(3654480297984L, 27228);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      axk localaxk = (axk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3654480297984L, 27228);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new en();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((en)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localaxk.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3654480297984L, 27228);
        return 0;
      case 2: 
        localaxk.mrA = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3654480297984L, 27228);
        return 0;
      case 3: 
        localaxk.muu = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3654480297984L, 27228);
        return 0;
      case 4: 
        localaxk.mut = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3654480297984L, 27228);
        return 0;
      case 5: 
        localaxk.tdw = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3654480297984L, 27228);
        return 0;
      case 6: 
        localaxk.teo = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3654480297984L, 27228);
        return 0;
      case 7: 
        localaxk.ofk = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3654480297984L, 27228);
        return 0;
      case 8: 
        localaxk.jMq = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3654480297984L, 27228);
        return 0;
      case 9: 
        localaxk.tdE = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(3654480297984L, 27228);
        return 0;
      }
      localaxk.tlA = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3654480297984L, 27228);
      return 0;
    }
    GMTrace.o(3654480297984L, 27228);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/axk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */