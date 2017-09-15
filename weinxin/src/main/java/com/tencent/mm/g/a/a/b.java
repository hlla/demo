package com.tencent.mm.g.a.a;

import com.tencent.gmtrace.GMTrace;

public final class b
  extends com.tencent.mm.bd.a
{
  public String gMN;
  public int gMO;
  public String gMP;
  public String userName;
  
  public b()
  {
    GMTrace.i(1593164431360L, 11870);
    GMTrace.o(1593164431360L, 11870);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(1593298649088L, 11871);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.e(1, this.userName);
      }
      if (this.gMN != null) {
        paramVarArgs.e(2, this.gMN);
      }
      paramVarArgs.eO(3, this.gMO);
      if (this.gMP != null) {
        paramVarArgs.e(4, this.gMP);
      }
      GMTrace.o(1593298649088L, 11871);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = a.a.a.b.b.a.f(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gMN != null) {
        i = paramInt + a.a.a.b.b.a.f(2, this.gMN);
      }
      i += a.a.a.a.eL(3, this.gMO);
      paramInt = i;
      if (this.gMP != null) {
        paramInt = i + a.a.a.b.b.a.f(4, this.gMP);
      }
      GMTrace.o(1593298649088L, 11871);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        GMTrace.o(1593298649088L, 11871);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(1593298649088L, 11871);
          return -1;
        case 1: 
          localb.userName = locala.xky.readString();
          GMTrace.o(1593298649088L, 11871);
          return 0;
        case 2: 
          localb.gMN = locala.xky.readString();
          GMTrace.o(1593298649088L, 11871);
          return 0;
        case 3: 
          localb.gMO = locala.xky.mL();
          GMTrace.o(1593298649088L, 11871);
          return 0;
        }
        localb.gMP = locala.xky.readString();
        GMTrace.o(1593298649088L, 11871);
        return 0;
      }
      GMTrace.o(1593298649088L, 11871);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/g/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */