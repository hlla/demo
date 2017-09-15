package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class akf
  extends com.tencent.mm.bd.a
{
  public String fDt;
  public String tMp;
  public int tdn;
  
  public akf()
  {
    GMTrace.i(3844935254016L, 28647);
    GMTrace.o(3844935254016L, 28647);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3845069471744L, 28648);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tMp != null) {
        paramVarArgs.e(1, this.tMp);
      }
      if (this.fDt != null) {
        paramVarArgs.e(2, this.fDt);
      }
      paramVarArgs.eO(3, this.tdn);
      GMTrace.o(3845069471744L, 28648);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tMp == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = a.a.a.b.b.a.f(1, this.tMp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fDt != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.fDt);
      }
      paramInt = a.a.a.a.eL(3, this.tdn);
      GMTrace.o(3845069471744L, 28648);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(3845069471744L, 28648);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        akf localakf = (akf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3845069471744L, 28648);
          return -1;
        case 1: 
          localakf.tMp = locala.xky.readString();
          GMTrace.o(3845069471744L, 28648);
          return 0;
        case 2: 
          localakf.fDt = locala.xky.readString();
          GMTrace.o(3845069471744L, 28648);
          return 0;
        }
        localakf.tdn = locala.xky.mL();
        GMTrace.o(3845069471744L, 28648);
        return 0;
      }
      GMTrace.o(3845069471744L, 28648);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/akf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */