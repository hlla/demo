package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;

public final class hq
  extends com.tencent.mm.bd.a
{
  public int port;
  public b tkg;
  public b tkh;
  public int type;
  
  public hq()
  {
    GMTrace.i(13579478630400L, 101175);
    GMTrace.o(13579478630400L, 101175);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(13579612848128L, 101176);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.type);
      paramVarArgs.eO(2, this.port);
      if (this.tkg != null) {
        paramVarArgs.b(3, this.tkg);
      }
      if (this.tkh != null) {
        paramVarArgs.b(4, this.tkh);
      }
      GMTrace.o(13579612848128L, 101176);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.type) + 0 + a.a.a.a.eL(2, this.port);
      paramInt = i;
      if (this.tkg != null) {
        paramInt = i + a.a.a.a.a(3, this.tkg);
      }
      i = paramInt;
      if (this.tkh != null) {
        i = paramInt + a.a.a.a.a(4, this.tkh);
      }
      GMTrace.o(13579612848128L, 101176);
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
      GMTrace.o(13579612848128L, 101176);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      hq localhq = (hq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(13579612848128L, 101176);
        return -1;
      case 1: 
        localhq.type = locala.xky.mL();
        GMTrace.o(13579612848128L, 101176);
        return 0;
      case 2: 
        localhq.port = locala.xky.mL();
        GMTrace.o(13579612848128L, 101176);
        return 0;
      case 3: 
        localhq.tkg = locala.chR();
        GMTrace.o(13579612848128L, 101176);
        return 0;
      }
      localhq.tkh = locala.chR();
      GMTrace.o(13579612848128L, 101176);
      return 0;
    }
    GMTrace.o(13579612848128L, 101176);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */