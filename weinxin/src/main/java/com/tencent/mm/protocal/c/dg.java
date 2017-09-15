package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class dg
  extends com.tencent.mm.bd.a
{
  public dh teV;
  public di tfb;
  public com.tencent.mm.bd.b tfc;
  
  public dg()
  {
    GMTrace.i(3932847865856L, 29302);
    GMTrace.o(3932847865856L, 29302);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3932982083584L, 29303);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tfb == null) {
        throw new a.a.a.b("Not all required fields were included: VoiceAttr");
      }
      if (this.teV == null) {
        throw new a.a.a.b("Not all required fields were included: UploadCtx");
      }
      if (this.tfc == null) {
        throw new a.a.a.b("Not all required fields were included: VoiceData");
      }
      if (this.tfb != null)
      {
        paramVarArgs.eQ(1, this.tfb.aUd());
        this.tfb.a(paramVarArgs);
      }
      if (this.teV != null)
      {
        paramVarArgs.eQ(2, this.teV.aUd());
        this.teV.a(paramVarArgs);
      }
      if (this.tfc != null) {
        paramVarArgs.b(3, this.tfc);
      }
      GMTrace.o(3932982083584L, 29303);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tfb != null) {
        i = a.a.a.a.eN(1, this.tfb.aUd()) + 0;
      }
      paramInt = i;
      if (this.teV != null) {
        paramInt = i + a.a.a.a.eN(2, this.teV.aUd());
      }
      i = paramInt;
      if (this.tfc != null) {
        i = paramInt + a.a.a.a.a(3, this.tfc);
      }
      GMTrace.o(3932982083584L, 29303);
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
      if (this.tfb == null) {
        throw new a.a.a.b("Not all required fields were included: VoiceAttr");
      }
      if (this.teV == null) {
        throw new a.a.a.b("Not all required fields were included: UploadCtx");
      }
      if (this.tfc == null) {
        throw new a.a.a.b("Not all required fields were included: VoiceData");
      }
      GMTrace.o(3932982083584L, 29303);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      dg localdg = (dg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(3932982083584L, 29303);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new di();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((di)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdg.tfb = ((di)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3932982083584L, 29303);
        return 0;
      case 2: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dh();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dh)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localdg.teV = ((dh)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3932982083584L, 29303);
        return 0;
      }
      localdg.tfc = ((a.a.a.a.a)localObject1).chR();
      GMTrace.o(3932982083584L, 29303);
      return 0;
    }
    GMTrace.o(3932982083584L, 29303);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */