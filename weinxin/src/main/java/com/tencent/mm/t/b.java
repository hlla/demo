package com.tencent.mm.t;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Map;

public class b
  extends c
{
  public String hha;
  
  public b()
  {
    GMTrace.i(16689169170432L, 124344);
    GMTrace.o(16689169170432L, 124344);
  }
  
  public final void a(StringBuilder paramStringBuilder, f.a parama, String paramString, keep_SceneResult paramkeep_SceneResult, int paramInt1, int paramInt2)
  {
    GMTrace.i(16689437605888L, 124346);
    GMTrace.o(16689437605888L, 124346);
  }
  
  public final void a(Map<String, String> paramMap, f.a parama)
  {
    GMTrace.i(16689571823616L, 124347);
    if (parama.type == 2001) {
      this.hha = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.locallogoicon"));
    }
    GMTrace.o(16689571823616L, 124347);
  }
  
  public final c wD()
  {
    GMTrace.i(16689303388160L, 124345);
    b localb = new b();
    GMTrace.o(16689303388160L, 124345);
    return localb;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/t/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */