package com.tencent.mm.plugin.report.kvdata;

import com.tencent.gmtrace.GMTrace;

public class VoiceInputBehavior
  extends com.tencent.mm.bd.a
{
  public int cancel;
  public int clear;
  public int click;
  public int fail;
  public int fullScreenVoiceLongClick;
  public long fullScreenVoiceLongClickTime;
  public int longClick;
  public long longClickTime;
  public int send;
  public int smileIconClick;
  public int textChangeCount;
  public int textChangeReturn;
  public long textChangeTime;
  public int textClick;
  public int voiceIconClick;
  public long voiceInputTime;
  
  public VoiceInputBehavior()
  {
    GMTrace.i(10714869661696L, 79832);
    GMTrace.o(10714869661696L, 79832);
  }
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(10715003879424L, 79833);
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      paramVarArgs.eO(1, this.cancel);
      paramVarArgs.eO(2, this.send);
      paramVarArgs.eO(3, this.click);
      paramVarArgs.eO(4, this.longClick);
      paramVarArgs.O(5, this.longClickTime);
      paramVarArgs.eO(6, this.textClick);
      paramVarArgs.eO(7, this.textChangeCount);
      paramVarArgs.O(8, this.textChangeTime);
      paramVarArgs.eO(9, this.textChangeReturn);
      paramVarArgs.O(10, this.voiceInputTime);
      paramVarArgs.eO(11, this.fail);
      paramVarArgs.eO(12, this.clear);
      paramVarArgs.eO(13, this.smileIconClick);
      paramVarArgs.eO(14, this.voiceIconClick);
      paramVarArgs.eO(15, this.fullScreenVoiceLongClick);
      paramVarArgs.O(16, this.fullScreenVoiceLongClickTime);
      GMTrace.o(10715003879424L, 79833);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = a.a.a.a.eL(1, this.cancel);
      int i = a.a.a.a.eL(2, this.send);
      int j = a.a.a.a.eL(3, this.click);
      int k = a.a.a.a.eL(4, this.longClick);
      int m = a.a.a.a.N(5, this.longClickTime);
      int n = a.a.a.a.eL(6, this.textClick);
      int i1 = a.a.a.a.eL(7, this.textChangeCount);
      int i2 = a.a.a.a.N(8, this.textChangeTime);
      int i3 = a.a.a.a.eL(9, this.textChangeReturn);
      int i4 = a.a.a.a.N(10, this.voiceInputTime);
      int i5 = a.a.a.a.eL(11, this.fail);
      int i6 = a.a.a.a.eL(12, this.clear);
      int i7 = a.a.a.a.eL(13, this.smileIconClick);
      int i8 = a.a.a.a.eL(14, this.voiceIconClick);
      int i9 = a.a.a.a.eL(15, this.fullScreenVoiceLongClick);
      int i10 = a.a.a.a.N(16, this.fullScreenVoiceLongClickTime);
      GMTrace.o(10715003879424L, 79833);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9 + i10;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bd.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bd.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.chS();
        }
      }
      GMTrace.o(10715003879424L, 79833);
      return 0;
    }
    if (paramInt == 3)
    {
      a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
      VoiceInputBehavior localVoiceInputBehavior = (VoiceInputBehavior)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        GMTrace.o(10715003879424L, 79833);
        return -1;
      case 1: 
        localVoiceInputBehavior.cancel = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 2: 
        localVoiceInputBehavior.send = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 3: 
        localVoiceInputBehavior.click = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 4: 
        localVoiceInputBehavior.longClick = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 5: 
        localVoiceInputBehavior.longClickTime = locala.xky.mM();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 6: 
        localVoiceInputBehavior.textClick = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 7: 
        localVoiceInputBehavior.textChangeCount = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 8: 
        localVoiceInputBehavior.textChangeTime = locala.xky.mM();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 9: 
        localVoiceInputBehavior.textChangeReturn = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 10: 
        localVoiceInputBehavior.voiceInputTime = locala.xky.mM();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 11: 
        localVoiceInputBehavior.fail = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 12: 
        localVoiceInputBehavior.clear = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 13: 
        localVoiceInputBehavior.smileIconClick = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 14: 
        localVoiceInputBehavior.voiceIconClick = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      case 15: 
        localVoiceInputBehavior.fullScreenVoiceLongClick = locala.xky.mL();
        GMTrace.o(10715003879424L, 79833);
        return 0;
      }
      localVoiceInputBehavior.fullScreenVoiceLongClickTime = locala.xky.mM();
      GMTrace.o(10715003879424L, 79833);
      return 0;
    }
    GMTrace.o(10715003879424L, 79833);
    return -1;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/kvdata/VoiceInputBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */