package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class dw
  extends com.tencent.mm.bd.a
{
  public dx tga;
  public du tgb;
  
  public dw()
  {
    GMTrace.i(13574915227648L, 101141);
    GMTrace.o(13574915227648L, 101141);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13575049445376L, 101142);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tga == null) {
        throw new b("Not all required fields were included: RsaReqData");
      }
      if (this.tgb == null) {
        throw new b("Not all required fields were included: AesReqData");
      }
      if (this.tga != null)
      {
        paramVarArgs.eQ(1, this.tga.aUd());
        this.tga.a(paramVarArgs);
      }
      if (this.tgb != null)
      {
        paramVarArgs.eQ(2, this.tgb.aUd());
        this.tgb.a(paramVarArgs);
      }
      GMTrace.o(13575049445376L, 101142);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tga != null) {
        paramInt = a.a.a.a.eN(1, this.tga.aUd()) + 0;
      }
      i = paramInt;
      if (this.tgb != null) {
        i = paramInt + a.a.a.a.eN(2, this.tgb.aUd());
      }
      GMTrace.o(13575049445376L, 101142);
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
      if (this.tga == null) {
        throw new b("Not all required fields were included: RsaReqData");
      }
      if (this.tgb == null) {
        throw new b("Not all required fields were included: AesReqData");
      }
      GMTrace.o(13575049445376L, 101142);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      dw localdw = (dw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13575049445376L, 101142);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dx();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdw.tga = ((dx)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13575049445376L, 101142);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new du();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((du)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        localdw.tgb = ((du)localObject1);
        paramInt += 1;
      }
      GMTrace.o(13575049445376L, 101142);
      return 0;
    }
    GMTrace.o(13575049445376L, 101142);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */