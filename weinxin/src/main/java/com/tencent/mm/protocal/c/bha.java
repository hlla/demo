package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bha
  extends avm
{
  public String tPj;
  public String tdq;
  public int tfd;
  public int tfe;
  
  public bha()
  {
    GMTrace.i(3677163094016L, 27397);
    GMTrace.o(3677163094016L, 27397);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3677297311744L, 27398);
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
      paramVarArgs.eO(2, this.tfe);
      paramVarArgs.eO(3, this.tfd);
      if (this.tdq != null) {
        paramVarArgs.e(4, this.tdq);
      }
      if (this.tPj != null) {
        paramVarArgs.e(5, this.tPj);
      }
      GMTrace.o(3677297311744L, 27398);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tfe) + a.a.a.a.eL(3, this.tfd);
      paramInt = i;
      if (this.tdq != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.tdq);
      }
      i = paramInt;
      if (this.tPj != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tPj);
      }
      GMTrace.o(3677297311744L, 27398);
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
      GMTrace.o(3677297311744L, 27398);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bha localbha = (bha)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3677297311744L, 27398);
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
          localbha.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3677297311744L, 27398);
        return 0;
      case 2: 
        localbha.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3677297311744L, 27398);
        return 0;
      case 3: 
        localbha.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(3677297311744L, 27398);
        return 0;
      case 4: 
        localbha.tdq = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3677297311744L, 27398);
        return 0;
      }
      localbha.tPj = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3677297311744L, 27398);
      return 0;
    }
    GMTrace.o(3677297311744L, 27398);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */