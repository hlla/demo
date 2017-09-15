package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class mm
  extends ave
{
  public String trk;
  public String trl;
  public String trm;
  
  public mm()
  {
    GMTrace.i(3823326199808L, 28486);
    GMTrace.o(3823326199808L, 28486);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3823460417536L, 28487);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trk == null) {
        throw new b("Not all required fields were included: corp_id");
      }
      if (this.trl == null) {
        throw new b("Not all required fields were included: qychat_type");
      }
      if (this.trm == null) {
        throw new b("Not all required fields were included: qychat_id");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.trk != null) {
        paramVarArgs.e(2, this.trk);
      }
      if (this.trl != null) {
        paramVarArgs.e(3, this.trl);
      }
      if (this.trm != null) {
        paramVarArgs.e(4, this.trm);
      }
      GMTrace.o(3823460417536L, 28487);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = 0;
      if (this.tXb != null) {
        i = a.a.a.a.eN(1, this.tXb.aUd()) + 0;
      }
      paramInt = i;
      if (this.trk != null) {
        paramInt = i + a.a.a.b.b.a.f(2, this.trk);
      }
      i = paramInt;
      if (this.trl != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.trl);
      }
      paramInt = i;
      if (this.trm != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.trm);
      }
      GMTrace.o(3823460417536L, 28487);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.trk == null) {
        throw new b("Not all required fields were included: corp_id");
      }
      if (this.trl == null) {
        throw new b("Not all required fields were included: qychat_type");
      }
      if (this.trm == null) {
        throw new b("Not all required fields were included: qychat_id");
      }
      GMTrace.o(3823460417536L, 28487);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      mm localmm = (mm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3823460417536L, 28487);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new em();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((em)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, ave.a((a.a.a.a.a)localObject2))) {}
          localmm.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3823460417536L, 28487);
        return 0;
      case 2: 
        localmm.trk = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3823460417536L, 28487);
        return 0;
      case 3: 
        localmm.trl = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3823460417536L, 28487);
        return 0;
      }
      localmm.trm = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(3823460417536L, 28487);
      return 0;
    }
    GMTrace.o(3823460417536L, 28487);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/mm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */