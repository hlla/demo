package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class cl
  extends com.tencent.mm.bd.a
{
  public int tdY;
  public int tdZ;
  
  public cl()
  {
    GMTrace.i(3822252457984L, 28478);
    GMTrace.o(3822252457984L, 28478);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3822386675712L, 28479);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.tdY);
      paramVarArgs.eO(2, this.tdZ);
      GMTrace.o(3822386675712L, 28479);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.tdY);
      int i = a.a.a.a.eL(2, this.tdZ);
      GMTrace.o(3822386675712L, 28479);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(3822386675712L, 28479);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      cl localcl = (cl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(3822386675712L, 28479);
        return -1;
      case 1: 
        localcl.tdY = locala.xky.mL();
        GMTrace.o(3822386675712L, 28479);
        return 0;
      }
      localcl.tdZ = locala.xky.mL();
      GMTrace.o(3822386675712L, 28479);
      return 0;
    }
    GMTrace.o(3822386675712L, 28479);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */