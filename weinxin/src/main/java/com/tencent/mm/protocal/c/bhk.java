package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class bhk
  extends avm
{
  public int tfd;
  public int tfe;
  public String tov;
  public String tow;
  public String ufl;
  
  public bhk()
  {
    GMTrace.i(4047469805568L, 30156);
    GMTrace.o(4047469805568L, 30156);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4047604023296L, 30157);
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
      paramVarArgs.eO(2, this.tfd);
      paramVarArgs.eO(3, this.tfe);
      if (this.ufl != null) {
        paramVarArgs.e(4, this.ufl);
      }
      if (this.tov != null) {
        paramVarArgs.e(5, this.tov);
      }
      if (this.tow != null) {
        paramVarArgs.e(6, this.tow);
      }
      GMTrace.o(4047604023296L, 30157);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.tXs != null) {
        paramInt = a.a.a.a.eN(1, this.tXs.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.tfd) + a.a.a.a.eL(3, this.tfe);
      paramInt = i;
      if (this.ufl != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.ufl);
      }
      i = paramInt;
      if (this.tov != null) {
        i = paramInt + a.a.a.b.b.a.f(5, this.tov);
      }
      paramInt = i;
      if (this.tow != null) {
        paramInt = i + a.a.a.b.b.a.f(6, this.tow);
      }
      GMTrace.o(4047604023296L, 30157);
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
      GMTrace.o(4047604023296L, 30157);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      bhk localbhk = (bhk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(4047604023296L, 30157);
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
          localbhk.tXs = ((en)localObject1);
          paramInt += 1;
        }
        GMTrace.o(4047604023296L, 30157);
        return 0;
      case 2: 
        localbhk.tfd = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4047604023296L, 30157);
        return 0;
      case 3: 
        localbhk.tfe = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(4047604023296L, 30157);
        return 0;
      case 4: 
        localbhk.ufl = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4047604023296L, 30157);
        return 0;
      case 5: 
        localbhk.tov = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(4047604023296L, 30157);
        return 0;
      }
      localbhk.tow = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(4047604023296L, 30157);
      return 0;
    }
    GMTrace.o(4047604023296L, 30157);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bhk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */