package com.tencent.mm.u;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class d
{
  private b fAG;
  private b.a hkE;
  public a hkF;
  private boolean hkG;
  private Context ty;
  
  public d()
  {
    GMTrace.i(656324689920L, 4890);
    this.hkG = false;
    this.ty = aa.getContext();
    GMTrace.o(656324689920L, 4890);
  }
  
  public final boolean a(a parama)
  {
    GMTrace.i(656458907648L, 4891);
    this.hkF = parama;
    parama = new b();
    if (this.fAG == null) {
      this.fAG = new b(this.ty);
    }
    if (this.hkE != parama) {
      this.hkE = parama;
    }
    this.fAG.a(this.hkE);
    if (this.fAG == null)
    {
      GMTrace.o(656458907648L, 4891);
      return false;
    }
    if (this.hkG)
    {
      GMTrace.o(656458907648L, 4891);
      return false;
    }
    this.fAG.requestFocus();
    this.hkG = true;
    boolean bool = this.hkG;
    GMTrace.o(656458907648L, 4891);
    return bool;
  }
  
  public final boolean aS(boolean paramBoolean)
  {
    GMTrace.i(656593125376L, 4892);
    if (this.fAG != null) {}
    for (boolean bool = this.fAG.rY();; bool = false)
    {
      this.hkG = false;
      if (paramBoolean)
      {
        this.fAG = null;
        this.hkE = null;
        this.hkF = null;
      }
      GMTrace.o(656593125376L, 4892);
      return bool;
    }
  }
  
  public static abstract interface a {}
  
  private final class b
    implements b.a
  {
    public b()
    {
      GMTrace.i(668270067712L, 4979);
      GMTrace.o(668270067712L, 4979);
    }
    
    public final void cX(int paramInt)
    {
      GMTrace.i(668404285440L, 4980);
      switch (paramInt)
      {
      case 0: 
      default: 
        v.v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
      }
      do
      {
        do
        {
          do
          {
            do
            {
              GMTrace.o(668404285440L, 4980);
              return;
              v.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
            } while (d.this.hkF == null);
            GMTrace.o(668404285440L, 4980);
            return;
            v.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          } while (d.this.hkF == null);
          GMTrace.o(668404285440L, 4980);
          return;
          v.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        } while (d.this.hkF == null);
        GMTrace.o(668404285440L, 4980);
        return;
        v.v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      } while (d.this.hkF == null);
      GMTrace.o(668404285440L, 4980);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */