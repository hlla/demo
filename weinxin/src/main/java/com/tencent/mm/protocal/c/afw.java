package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class afw
  extends ave
{
  public String tJs;
  public LinkedList<String> tJt;
  public String trk;
  
  public afw()
  {
    GMTrace.i(3690584866816L, 27497);
    this.tJt = new LinkedList();
    GMTrace.o(3690584866816L, 27497);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3690719084544L, 27498);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.trk == null) {
        throw new b("Not all required fields were included: corp_id");
      }
      if (this.tJs == null) {
        throw new b("Not all required fields were included: bizchat_name");
      }
      if (this.tXb != null)
      {
        paramVarArgs.eQ(1, this.tXb.aUd());
        this.tXb.a(paramVarArgs);
      }
      if (this.trk != null) {
        paramVarArgs.e(2, this.trk);
      }
      if (this.tJs != null) {
        paramVarArgs.e(3, this.tJs);
      }
      paramVarArgs.d(4, 1, this.tJt);
      GMTrace.o(3690719084544L, 27498);
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
      if (this.tJs != null) {
        i = paramInt + a.a.a.b.b.a.f(3, this.tJs);
      }
      paramInt = a.a.a.a.c(4, 1, this.tJt);
      GMTrace.o(3690719084544L, 27498);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tJt.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = ave.a(paramVarArgs); paramInt > 0; paramInt = ave.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.trk == null) {
        throw new b("Not all required fields were included: corp_id");
      }
      if (this.tJs == null) {
        throw new b("Not all required fields were included: bizchat_name");
      }
      GMTrace.o(3690719084544L, 27498);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      afw localafw = (afw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(3690719084544L, 27498);
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
          localafw.tXb = ((em)localObject1);
          paramInt += 1;
        }
        GMTrace.o(3690719084544L, 27498);
        return 0;
      case 2: 
        localafw.trk = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3690719084544L, 27498);
        return 0;
      case 3: 
        localafw.tJs = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(3690719084544L, 27498);
        return 0;
      }
      localafw.tJt.add(((a.a.a.a.a)localObject1).xky.readString());
      GMTrace.o(3690719084544L, 27498);
      return 0;
    }
    GMTrace.o(3690719084544L, 27498);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/afw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */