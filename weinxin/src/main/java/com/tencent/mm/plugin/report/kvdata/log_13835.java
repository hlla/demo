package com.tencent.mm.plugin.report.kvdata;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public class log_13835
  extends com.tencent.mm.bd.a
{
  public int clientVersion_;
  public String currChatName_;
  public int device_;
  public int ds_;
  public int import_ds_;
  public LinkedList<IMBehavior> oplist_;
  public long time_stamp_;
  public long uin_;
  
  public log_13835()
  {
    GMTrace.i(10714601226240L, 79830);
    this.oplist_ = new LinkedList();
    GMTrace.o(10714601226240L, 79830);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(10714735443968L, 79831);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.currChatName_ == null) {
        throw new b("Not all required fields were included: currChatName_");
      }
      paramVarArgs.eO(1, this.import_ds_);
      paramVarArgs.eO(2, this.ds_);
      paramVarArgs.O(3, this.uin_);
      paramVarArgs.eO(4, this.device_);
      paramVarArgs.eO(5, this.clientVersion_);
      paramVarArgs.O(6, this.time_stamp_);
      if (this.currChatName_ != null) {
        paramVarArgs.e(7, this.currChatName_);
      }
      paramVarArgs.d(8, 8, this.oplist_);
      GMTrace.o(10714735443968L, 79831);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = a.a.a.a.eL(1, this.import_ds_) + 0 + a.a.a.a.eL(2, this.ds_) + a.a.a.a.N(3, this.uin_) + a.a.a.a.eL(4, this.device_) + a.a.a.a.eL(5, this.clientVersion_) + a.a.a.a.N(6, this.time_stamp_);
      paramInt = i;
      if (this.currChatName_ != null) {
        paramInt = i + a.a.a.b.b.a.f(7, this.currChatName_);
      }
      i = a.a.a.a.c(8, 8, this.oplist_);
      GMTrace.o(10714735443968L, 79831);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.oplist_.clear();
      paramVarArgs = new a.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      if (this.currChatName_ == null) {
        throw new b("Not all required fields were included: currChatName_");
      }
      GMTrace.o(10714735443968L, 79831);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      log_13835 locallog_13835 = (log_13835)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(10714735443968L, 79831);
        return -1;
      case 1: 
        locallog_13835.import_ds_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(10714735443968L, 79831);
        return 0;
      case 2: 
        locallog_13835.ds_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(10714735443968L, 79831);
        return 0;
      case 3: 
        locallog_13835.uin_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(10714735443968L, 79831);
        return 0;
      case 4: 
        locallog_13835.device_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(10714735443968L, 79831);
        return 0;
      case 5: 
        locallog_13835.clientVersion_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(10714735443968L, 79831);
        return 0;
      case 6: 
        locallog_13835.time_stamp_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(10714735443968L, 79831);
        return 0;
      case 7: 
        locallog_13835.currChatName_ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(10714735443968L, 79831);
        return 0;
      }
      paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new IMBehavior();
        localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((IMBehavior)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
        locallog_13835.oplist_.add(localObject1);
        paramInt += 1;
      }
      GMTrace.o(10714735443968L, 79831);
      return 0;
    }
    GMTrace.o(10714735443968L, 79831);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/log_13835.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */