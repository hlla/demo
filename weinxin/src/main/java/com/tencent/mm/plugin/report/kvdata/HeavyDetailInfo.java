package com.tencent.mm.plugin.report.kvdata;

import com.tencent.gmtrace.GMTrace;

public class HeavyDetailInfo
  extends com.tencent.mm.bd.a
{
  public long chatroom_;
  public long contact_;
  public long conversation_;
  public long dbSize_;
  public long favDbSize_;
  public long flag_;
  public long message_;
  public long sdFileRatio_;
  public long sdFileSize_;
  
  public HeavyDetailInfo()
  {
    GMTrace.i(17773916848128L, 132426);
    GMTrace.o(17773916848128L, 132426);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17774051065856L, 132427);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.O(1, this.flag_);
      paramVarArgs.O(2, this.sdFileSize_);
      paramVarArgs.O(3, this.sdFileRatio_);
      paramVarArgs.O(4, this.dbSize_);
      paramVarArgs.O(5, this.message_);
      paramVarArgs.O(6, this.conversation_);
      paramVarArgs.O(7, this.contact_);
      paramVarArgs.O(8, this.chatroom_);
      paramVarArgs.O(9, this.favDbSize_);
      GMTrace.o(17774051065856L, 132427);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.N(1, this.flag_);
      int i = a.a.a.a.N(2, this.sdFileSize_);
      int j = a.a.a.a.N(3, this.sdFileRatio_);
      int k = a.a.a.a.N(4, this.dbSize_);
      int m = a.a.a.a.N(5, this.message_);
      int n = a.a.a.a.N(6, this.conversation_);
      int i1 = a.a.a.a.N(7, this.contact_);
      int i2 = a.a.a.a.N(8, this.chatroom_);
      int i3 = a.a.a.a.N(9, this.favDbSize_);
      GMTrace.o(17774051065856L, 132427);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(17774051065856L, 132427);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      HeavyDetailInfo localHeavyDetailInfo = (HeavyDetailInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(17774051065856L, 132427);
        return -1;
      case 1: 
        localHeavyDetailInfo.flag_ = locala.xky.mM();
        GMTrace.o(17774051065856L, 132427);
        return 0;
      case 2: 
        localHeavyDetailInfo.sdFileSize_ = locala.xky.mM();
        GMTrace.o(17774051065856L, 132427);
        return 0;
      case 3: 
        localHeavyDetailInfo.sdFileRatio_ = locala.xky.mM();
        GMTrace.o(17774051065856L, 132427);
        return 0;
      case 4: 
        localHeavyDetailInfo.dbSize_ = locala.xky.mM();
        GMTrace.o(17774051065856L, 132427);
        return 0;
      case 5: 
        localHeavyDetailInfo.message_ = locala.xky.mM();
        GMTrace.o(17774051065856L, 132427);
        return 0;
      case 6: 
        localHeavyDetailInfo.conversation_ = locala.xky.mM();
        GMTrace.o(17774051065856L, 132427);
        return 0;
      case 7: 
        localHeavyDetailInfo.contact_ = locala.xky.mM();
        GMTrace.o(17774051065856L, 132427);
        return 0;
      case 8: 
        localHeavyDetailInfo.chatroom_ = locala.xky.mM();
        GMTrace.o(17774051065856L, 132427);
        return 0;
      }
      localHeavyDetailInfo.favDbSize_ = locala.xky.mM();
      GMTrace.o(17774051065856L, 132427);
      return 0;
    }
    GMTrace.o(17774051065856L, 132427);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/HeavyDetailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */