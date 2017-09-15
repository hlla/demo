package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class afx
  extends avm
{
  public String tjf;
  public asy tjl;
  public String trl;
  public String trm;
  public int trn;
  public sr tro;
  public gx trp;
  
  public afx()
  {
    GMTrace.i(3937142833152L, 29334);
    GMTrace.o(3937142833152L, 29334);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3937277050880L, 29335);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tXs == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tjl == null) {
        throw new b("Not all required fields were included: qy_base_resp");
      }
      if (this.tXs != null)
      {
        paramVarArgs.eQ(1, this.tXs.aUd());
        this.tXs.a(paramVarArgs);
      }
      if (this.tjl != null)
      {
        paramVarArgs.eQ(2, this.tjl.aUd());
        this.tjl.a(paramVarArgs);
      }
      if (this.tjf != null) {
        paramVarArgs.e(3, this.tjf);
      }
      paramVarArgs.eO(4, this.trn);
      if (this.tro != null)
      {
        paramVarArgs.eQ(5, this.tro.aUd());
        this.tro.a(paramVarArgs);
      }
      if (this.trp != null)
      {
        paramVarArgs.eQ(6, this.trp.aUd());
        this.trp.a(paramVarArgs);
      }
      if (this.trl != null) {
        paramVarArgs.e(7, this.trl);
      }
      if (this.trm != null) {
        paramVarArgs.e(8, this.trm);
      }
      GMTrace.o(3937277050880L, 29335);
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
      if (this.tjl != null) {
        paramInt = i + a.a.a.a.eN(2, this.tjl.aUd());
      }
      i = paramInt;
      if (this.tjf != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tjf);
      }
      i += a.a.a.a.eL(4, this.trn);
      paramInt = i;
      if (this.tro != null) {
        paramInt = i + a.a.a.a.eN(5, this.tro.aUd());
      }
      i = paramInt;
      if (this.trp != null) {
        i = paramInt + a.a.a.a.eN(6, this.trp.aUd());
      }
      paramInt = i;
      if (this.trl != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.trl);
      }
      i = paramInt;
      if (this.trm != null) {
        i = paramInt + a.a.a.b.b.a.f(8, this.trm);
      }
      GMTrace.o(3937277050880L, 29335);
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
      if (this.tjl == null) {
        throw new b("Not all required fields were included: qy_base_resp");
      }
      GMTrace.o(3937277050880L, 29335);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      afx localafx = (afx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3937277050880L, 29335);
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
          localafx.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3937277050880L, 29335);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new asy();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((asy)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localafx.tjl = ((asy)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3937277050880L, 29335);
        return 0;
      case 3: 
        localafx.tjf = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3937277050880L, 29335);
        return 0;
      case 4: 
        localafx.trn = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3937277050880L, 29335);
        return 0;
      case 5: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sr();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sr)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localafx.tro = ((sr)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3937277050880L, 29335);
        return 0;
      case 6: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, avm.a((a.a.a.a.a)localObject2))) {}
          localafx.trp = ((gx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3937277050880L, 29335);
        return 0;
      case 7: 
        localafx.trl = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3937277050880L, 29335);
        return 0;
      }
      localafx.trm = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3937277050880L, 29335);
      return 0;
    }
    GMTrace.o(3937277050880L, 29335);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/afx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */