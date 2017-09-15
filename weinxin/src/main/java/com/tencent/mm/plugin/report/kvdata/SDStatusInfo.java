package com.tencent.mm.plugin.report.kvdata;

import a.a.a.b;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;

public class SDStatusInfo
  extends com.tencent.mm.bd.a
{
  public long eAvailableBlockCount_;
  public int eAvailablePer_;
  public long eAvailableSize_;
  public long eBlockCount_;
  public long eBlockSize_;
  public String ePath_;
  public long eTotalSize_;
  public String fSystem_;
  public int hasUnRemovable_;
  public int ratioHeavy_;
  public String root_;
  public long sAvailableBlockCount_;
  public int sAvailablePer_;
  public long sAvailableSize_;
  public long sBlockCount_;
  public long sBlockSize_;
  public long sTotalSize_;
  public int sizeHeavy_;
  public int useExternal_;
  public int weChatPer_;
  public WeChatSDInfo weChatSDInfo_;
  
  public SDStatusInfo()
  {
    GMTrace.i(17507226222592L, 130439);
    GMTrace.o(17507226222592L, 130439);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(17507360440320L, 130440);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (this.weChatSDInfo_ == null) {
        throw new b("Not all required fields were included: weChatSDInfo_");
      }
      if (this.weChatSDInfo_ != null)
      {
        paramVarArgs.eQ(1, this.weChatSDInfo_.aUd());
        this.weChatSDInfo_.a(paramVarArgs);
      }
      paramVarArgs.eO(2, this.weChatPer_);
      paramVarArgs.eO(3, this.sizeHeavy_);
      paramVarArgs.eO(4, this.ratioHeavy_);
      paramVarArgs.eO(5, this.useExternal_);
      paramVarArgs.eO(6, this.hasUnRemovable_);
      paramVarArgs.O(7, this.sBlockSize_);
      paramVarArgs.O(8, this.sBlockCount_);
      paramVarArgs.O(9, this.sTotalSize_);
      paramVarArgs.O(10, this.sAvailableBlockCount_);
      paramVarArgs.O(11, this.sAvailableSize_);
      paramVarArgs.eO(12, this.sAvailablePer_);
      paramVarArgs.O(13, this.eBlockSize_);
      paramVarArgs.O(14, this.eBlockCount_);
      paramVarArgs.O(15, this.eTotalSize_);
      paramVarArgs.O(16, this.eAvailableBlockCount_);
      paramVarArgs.O(17, this.eAvailableSize_);
      paramVarArgs.eO(18, this.eAvailablePer_);
      if (this.ePath_ != null) {
        paramVarArgs.e(19, this.ePath_);
      }
      if (this.root_ != null) {
        paramVarArgs.e(20, this.root_);
      }
      if (this.fSystem_ != null) {
        paramVarArgs.e(21, this.fSystem_);
      }
      GMTrace.o(17507360440320L, 130440);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = 0;
      if (this.weChatSDInfo_ != null) {
        paramInt = a.a.a.a.eN(1, this.weChatSDInfo_.aUd()) + 0;
      }
      i = paramInt + a.a.a.a.eL(2, this.weChatPer_) + a.a.a.a.eL(3, this.sizeHeavy_) + a.a.a.a.eL(4, this.ratioHeavy_) + a.a.a.a.eL(5, this.useExternal_) + a.a.a.a.eL(6, this.hasUnRemovable_) + a.a.a.a.N(7, this.sBlockSize_) + a.a.a.a.N(8, this.sBlockCount_) + a.a.a.a.N(9, this.sTotalSize_) + a.a.a.a.N(10, this.sAvailableBlockCount_) + a.a.a.a.N(11, this.sAvailableSize_) + a.a.a.a.eL(12, this.sAvailablePer_) + a.a.a.a.N(13, this.eBlockSize_) + a.a.a.a.N(14, this.eBlockCount_) + a.a.a.a.N(15, this.eTotalSize_) + a.a.a.a.N(16, this.eAvailableBlockCount_) + a.a.a.a.N(17, this.eAvailableSize_) + a.a.a.a.eL(18, this.eAvailablePer_);
      paramInt = i;
      if (this.ePath_ != null) {
        paramInt = i + a.a.a.b.b.a.f(19, this.ePath_);
      }
      i = paramInt;
      if (this.root_ != null) {
        i = paramInt + a.a.a.b.b.a.f(20, this.root_);
      }
      paramInt = i;
      if (this.fSystem_ != null) {
        paramInt = i + a.a.a.b.b.a.f(21, this.fSystem_);
      }
      GMTrace.o(17507360440320L, 130440);
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
      if (this.weChatSDInfo_ == null) {
        throw new b("Not all required fields were included: weChatSDInfo_");
      }
      GMTrace.o(17507360440320L, 130440);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
      SDStatusInfo localSDStatusInfo = (SDStatusInfo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        GMTrace.o(17507360440320L, 130440);
        return -1;
      case 1: 
        paramVarArgs = ((a.a.a.a.a)localObject1).Eg(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new WeChatSDInfo();
          localObject2 = new a.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((WeChatSDInfo)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.bd.a)localObject1, com.tencent.mm.bd.a.a((a.a.a.a.a)localObject2))) {}
          localSDStatusInfo.weChatSDInfo_ = ((WeChatSDInfo)localObject1);
          paramInt += 1;
        }
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 2: 
        localSDStatusInfo.weChatPer_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 3: 
        localSDStatusInfo.sizeHeavy_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 4: 
        localSDStatusInfo.ratioHeavy_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 5: 
        localSDStatusInfo.useExternal_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 6: 
        localSDStatusInfo.hasUnRemovable_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 7: 
        localSDStatusInfo.sBlockSize_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 8: 
        localSDStatusInfo.sBlockCount_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 9: 
        localSDStatusInfo.sTotalSize_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 10: 
        localSDStatusInfo.sAvailableBlockCount_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 11: 
        localSDStatusInfo.sAvailableSize_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 12: 
        localSDStatusInfo.sAvailablePer_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 13: 
        localSDStatusInfo.eBlockSize_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 14: 
        localSDStatusInfo.eBlockCount_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 15: 
        localSDStatusInfo.eTotalSize_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 16: 
        localSDStatusInfo.eAvailableBlockCount_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 17: 
        localSDStatusInfo.eAvailableSize_ = ((a.a.a.a.a)localObject1).xky.mM();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 18: 
        localSDStatusInfo.eAvailablePer_ = ((a.a.a.a.a)localObject1).xky.mL();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 19: 
        localSDStatusInfo.ePath_ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      case 20: 
        localSDStatusInfo.root_ = ((a.a.a.a.a)localObject1).xky.readString();
        GMTrace.o(17507360440320L, 130440);
        return 0;
      }
      localSDStatusInfo.fSystem_ = ((a.a.a.a.a)localObject1).xky.readString();
      GMTrace.o(17507360440320L, 130440);
      return 0;
    }
    GMTrace.o(17507360440320L, 130440);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/SDStatusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */