package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public final class hp
  extends com.tencent.mm.bd.a
{
  public String tjf;
  public LinkedList<String> tkf;
  
  public hp()
  {
    GMTrace.i(3693000785920L, 27515);
    this.tkf = new LinkedList();
    GMTrace.o(3693000785920L, 27515);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(3693135003648L, 27516);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.tjf == null) {
        throw new b("Not all required fields were included: brand_user_name");
      }
      if (this.tjf != null) {
        paramVarArgs.e(2, this.tjf);
      }
      paramVarArgs.d(3, 1, this.tkf);
      GMTrace.o(3693135003648L, 27516);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tjf == null) {
        break label338;
      }
    }
    label338:
    for (paramInt = a.a.a.b.b.a.f(2, this.tjf) + 0;; paramInt = 0)
    {
      int i = a.a.a.a.c(3, 1, this.tkf);
      GMTrace.o(3693135003648L, 27516);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tkf.clear();
        paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.chS();
          }
        }
        if (this.tjf == null) {
          throw new b("Not all required fields were included: brand_user_name");
        }
        GMTrace.o(3693135003648L, 27516);
        return 0;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        hp localhp = (hp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          GMTrace.o(3693135003648L, 27516);
          return -1;
        case 2: 
          localhp.tjf = locala.xky.readString();
          GMTrace.o(3693135003648L, 27516);
          return 0;
        }
        localhp.tkf.add(locala.xky.readString());
        GMTrace.o(3693135003648L, 27516);
        return 0;
      }
      GMTrace.o(3693135003648L, 27516);
      return -1;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/hp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */