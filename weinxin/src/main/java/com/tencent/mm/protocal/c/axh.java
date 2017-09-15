package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class axh
  extends com.tencent.mm.bd.a
{
  public int tfN;
  public or tfx;
  public avt tfy;
  public avt tfz;
  
  public axh()
  {
    GMTrace.i(13576928493568L, 101156);
    GMTrace.o(13576928493568L, 101156);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13577062711296L, 101157);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tfz == null) {
        throw new b("Not all required fields were included: AutoAuthKey");
      }
      if (this.tfx == null) {
        throw new b("Not all required fields were included: SvrPubECDHKey");
      }
      if (this.tfy == null) {
        throw new b("Not all required fields were included: SessionKey");
      }
      if (this.tfz != null)
      {
        paramVarArgs.eQ(1, this.tfz.aUd());
        this.tfz.a(paramVarArgs);
      }
      if (this.tfx != null)
      {
        paramVarArgs.eQ(2, this.tfx.aUd());
        this.tfx.a(paramVarArgs);
      }
      if (this.tfy != null)
      {
        paramVarArgs.eQ(3, this.tfy.aUd());
        this.tfy.a(paramVarArgs);
      }
      paramVarArgs.eO(4, this.tfN);
      GMTrace.o(13577062711296L, 101157);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tfz != null) {
        i = a.a.a.a.eN(1, this.tfz.aUd()) + 0;
      }
      paramInt = i;
      if (this.tfx != null) {
        paramInt = i + a.a.a.a.eN(2, this.tfx.aUd());
      }
      i = paramInt;
      if (this.tfy != null) {
        i = paramInt + a.a.a.a.eN(3, this.tfy.aUd());
      }
      paramInt = a.a.a.a.eL(4, this.tfN);
      GMTrace.o(13577062711296L, 101157);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.tfz == null) {
        throw new b("Not all required fields were included: AutoAuthKey");
      }
      if (this.tfx == null) {
        throw new b("Not all required fields were included: SvrPubECDHKey");
      }
      if (this.tfy == null) {
        throw new b("Not all required fields were included: SessionKey");
      }
      GMTrace.o(13577062711296L, 101157);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      axh localaxh = (axh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        GMTrace.o(13577062711296L, 101157);
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
          localaxh.tfz = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13577062711296L, 101157);
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
          localaxh.tfx = ((or)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13577062711296L, 101157);
        return 0;
      case 3: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avt();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avt)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localaxh.tfy = ((avt)localObject1);
          paramInt += 1;
        }
        GMTrace.o(13577062711296L, 101157);
        return 0;
      }
      localaxh.tfN = ((a.a.a.a.a)localObject1).xky.mL();
      GMTrace.o(13577062711296L, 101157);
      return 0;
    }
    GMTrace.o(13577062711296L, 101157);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/axh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */