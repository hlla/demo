package com.tencent.mm.protocal.b.a;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;

public final class a
  extends com.tencent.mm.bd.a
{
  public int actionType;
  public int id;
  public String sZw;
  public String sZx;
  
  public a()
  {
    GMTrace.i(4080084713472L, 30399);
    GMTrace.o(4080084713472L, 30399);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4080218931200L, 30400);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.sZw == null) {
        throw new b("Not all required fields were included: btnStr");
      }
      paramVarArgs.eO(1, this.id);
      paramVarArgs.eO(2, this.actionType);
      if (this.sZw != null) {
        paramVarArgs.e(3, this.sZw);
      }
      if (this.sZx != null) {
        paramVarArgs.e(4, this.sZx);
      }
      GMTrace.o(4080218931200L, 30400);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.id) + 0 + a.a.a.a.eL(2, this.actionType);
      paramInt = i;
      if (this.sZw != null) {
        paramInt = i + a.a.a.b.b.a.f(3, this.sZw);
      }
      i = paramInt;
      if (this.sZx != null) {
        i = paramInt + a.a.a.b.b.a.f(4, this.sZx);
      }
      GMTrace.o(4080218931200L, 30400);
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
      if (this.sZw == null) {
        throw new b("Not all required fields were included: btnStr");
      }
      GMTrace.o(4080218931200L, 30400);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(4080218931200L, 30400);
        return -1;
      case 1: 
        locala1.id = locala.xky.mL();
        GMTrace.o(4080218931200L, 30400);
        return 0;
      case 2: 
        locala1.actionType = locala.xky.mL();
        GMTrace.o(4080218931200L, 30400);
        return 0;
      case 3: 
        locala1.sZw = locala.xky.readString();
        GMTrace.o(4080218931200L, 30400);
        return 0;
      }
      locala1.sZx = locala.xky.readString();
      GMTrace.o(4080218931200L, 30400);
      return 0;
    }
    GMTrace.o(4080218931200L, 30400);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */