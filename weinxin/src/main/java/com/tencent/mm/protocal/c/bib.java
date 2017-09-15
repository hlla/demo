package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class bib
  extends com.tencent.mm.bd.a
{
  public int tfd;
  public int tfe;
  public int tff;
  
  public bib()
  {
    GMTrace.i(3897951256576L, 29042);
    GMTrace.o(3897951256576L, 29042);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3898085474304L, 29043);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tfd);
      paramVarArgs.eO(2, this.tfe);
      paramVarArgs.eO(3, this.tff);
      GMTrace.o(3898085474304L, 29043);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tfd);
      int i = a.a.a.a.eL(2, this.tfe);
      int j = a.a.a.a.eL(3, this.tff);
      GMTrace.o(3898085474304L, 29043);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3898085474304L, 29043);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      bib localbib = (bib)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3898085474304L, 29043);
        return -1;
      case 1: 
        localbib.tfd = locala.xky.mL();
        GMTrace.o(3898085474304L, 29043);
        return 0;
      case 2: 
        localbib.tfe = locala.xky.mL();
        GMTrace.o(3898085474304L, 29043);
        return 0;
      }
      localbib.tff = locala.xky.mL();
      GMTrace.o(3898085474304L, 29043);
      return 0;
    }
    GMTrace.o(3898085474304L, 29043);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/bib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */