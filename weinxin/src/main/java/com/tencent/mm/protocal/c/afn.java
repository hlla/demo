package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class afn
  extends com.tencent.mm.bd.a
{
  public double latitude;
  public double longitude;
  
  public afn()
  {
    GMTrace.i(4015660204032L, 29919);
    GMTrace.o(4015660204032L, 29919);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(4015794421760L, 29920);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.a(1, this.latitude);
      paramVarArgs.a(2, this.longitude);
      GMTrace.o(4015794421760L, 29920);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.b.b.a.cH(1);
      int i = a.a.a.b.b.a.cH(2);
      GMTrace.o(4015794421760L, 29920);
      return paramInt + 8 + 0 + (i + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(4015794421760L, 29920);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      afn localafn = (afn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(4015794421760L, 29920);
        return -1;
      case 1: 
        localafn.latitude = locala.xky.readDouble();
        GMTrace.o(4015794421760L, 29920);
        return 0;
      }
      localafn.longitude = locala.xky.readDouble();
      GMTrace.o(4015794421760L, 29920);
      return 0;
    }
    GMTrace.o(4015794421760L, 29920);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/afn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */