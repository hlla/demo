package com.tencent.mm.plugin.report.kvdata;

import com.tencent.gmtrace.GMTrace;

public class log_13913
  extends com.tencent.mm.bd.a
{
  public int clientVersion_;
  public int device_;
  public int ds_;
  public String error_;
  public int import_ds_;
  public int scene_;
  public long time_stamp_;
  public long uin_;
  
  public log_13913()
  {
    GMTrace.i(10713795919872L, 79824);
    GMTrace.o(10713795919872L, 79824);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(10713930137600L, 79825);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.import_ds_);
      paramVarArgs.eO(2, this.ds_);
      paramVarArgs.O(3, this.uin_);
      paramVarArgs.eO(4, this.device_);
      paramVarArgs.eO(5, this.clientVersion_);
      paramVarArgs.O(6, this.time_stamp_);
      paramVarArgs.eO(7, this.scene_);
      if (this.error_ != null) {
        paramVarArgs.e(8, this.error_);
      }
      GMTrace.o(10713930137600L, 79825);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = a.a.a.a.eL(1, this.import_ds_) + 0 + a.a.a.a.eL(2, this.ds_) + a.a.a.a.N(3, this.uin_) + a.a.a.a.eL(4, this.device_) + a.a.a.a.eL(5, this.clientVersion_) + a.a.a.a.N(6, this.time_stamp_) + a.a.a.a.eL(7, this.scene_);
      paramInt = i;
      if (this.error_ != null) {
        paramInt = i + a.a.a.b.b.a.f(8, this.error_);
      }
      GMTrace.o(10713930137600L, 79825);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(10713930137600L, 79825);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      log_13913 locallog_13913 = (log_13913)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(10713930137600L, 79825);
        return -1;
      case 1: 
        locallog_13913.import_ds_ = locala.xky.mL();
        GMTrace.o(10713930137600L, 79825);
        return 0;
      case 2: 
        locallog_13913.ds_ = locala.xky.mL();
        GMTrace.o(10713930137600L, 79825);
        return 0;
      case 3: 
        locallog_13913.uin_ = locala.xky.mM();
        GMTrace.o(10713930137600L, 79825);
        return 0;
      case 4: 
        locallog_13913.device_ = locala.xky.mL();
        GMTrace.o(10713930137600L, 79825);
        return 0;
      case 5: 
        locallog_13913.clientVersion_ = locala.xky.mL();
        GMTrace.o(10713930137600L, 79825);
        return 0;
      case 6: 
        locallog_13913.time_stamp_ = locala.xky.mM();
        GMTrace.o(10713930137600L, 79825);
        return 0;
      case 7: 
        locallog_13913.scene_ = locala.xky.mL();
        GMTrace.o(10713930137600L, 79825);
        return 0;
      }
      locallog_13913.error_ = locala.xky.readString();
      GMTrace.o(10713930137600L, 79825);
      return 0;
    }
    GMTrace.o(10713930137600L, 79825);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/log_13913.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */