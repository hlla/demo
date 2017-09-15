package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class ef
  extends com.tencent.mm.bd.a
{
  public String ID;
  public int tgr;
  public avt tgs;
  public String tgt;
  public int tgu;
  
  public ef()
  {
    GMTrace.i(3859699204096L, 28757);
    GMTrace.o(3859699204096L, 28757);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3859833421824L, 28758);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tgs == null) {
        throw new b("Not all required fields were included: QRCodeBuffer");
      }
      paramVarArgs.eO(1, this.tgr);
      if (this.tgs != null)
      {
        paramVarArgs.eQ(2, this.tgs.aUd());
        this.tgs.a(paramVarArgs);
      }
      if (this.tgt != null) {
        paramVarArgs.e(3, this.tgt);
      }
      paramVarArgs.eO(4, this.tgu);
      if (this.ID != null) {
        paramVarArgs.e(5, this.ID);
      }
      GMTrace.o(3859833421824L, 28758);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.tgr) + 0;
      paramInt = i;
      if (this.tgs != null) {
        paramInt = i + a.a.a.a.eN(2, this.tgs.aUd());
      }
      i = paramInt;
      if (this.tgt != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tgt);
      }
      i += a.a.a.a.eL(4, this.tgu);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + a.a.a.b.b.a.f(5, this.ID);
      }
      GMTrace.o(3859833421824L, 28758);
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
      if (this.tgs == null) {
        throw new b("Not all required fields were included: QRCodeBuffer");
      }
      GMTrace.o(3859833421824L, 28758);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      ef localef = (ef)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3859833421824L, 28758);
        return -1;
      case 1: 
        localef.tgr = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3859833421824L, 28758);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localef.tgs = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3859833421824L, 28758);
        return 0;
      case 3: 
        localef.tgt = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3859833421824L, 28758);
        return 0;
      case 4: 
        localef.tgu = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3859833421824L, 28758);
        return 0;
      }
      localef.ID = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3859833421824L, 28758);
      return 0;
    }
    GMTrace.o(3859833421824L, 28758);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */