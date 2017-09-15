package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.h;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.protocal.c.bjk;

public final class d
{
  public static bjk aq(int paramInt, String paramString)
  {
    GMTrace.i(5761698627584L, 42928);
    bjk localbjk = new bjk();
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      localbjk.tfi = 0;
      localbjk.tfj = 0;
      localbjk.tfg = 0;
      localbjk.tfh = 0;
    }
    for (;;)
    {
      GMTrace.o(5761698627584L, 42928);
      return localbjk;
      localbjk.tfi = 8000;
      localbjk.tfj = 16;
      localbjk.tfg = 5;
      localbjk.tfh = 5;
      continue;
      localbjk.tfi = 16000;
      localbjk.tfj = 16;
      localbjk.tfg = 4;
      localbjk.tfh = 4;
      continue;
      localbjk.tfi = 16000;
      paramString = q.lW(paramString);
      if (paramString != null)
      {
        paramInt = MediaRecorder.SilkGetEncSampleRate(((h)paramString).bd(0, 1).buf);
        if (paramInt >= 8000) {
          localbjk.tfi = paramInt;
        }
      }
      localbjk.tfj = 16;
      localbjk.tfg = 6;
      localbjk.tfh = 6;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/ui/voicetranstext/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */