package com.tencent.mm.plugin.fts.d;

import android.graphics.Color;
import android.text.TextPaint;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.aa;

public final class d
{
  public static final class a
  {
    public static final int maM;
    public static final int maN;
    public static final int maO;
    
    static
    {
      GMTrace.i(18565667225600L, 138325);
      maM = Color.parseColor("#45C01A");
      maN = Color.parseColor("#661AAD19");
      maO = Color.parseColor("#801AAD19");
      GMTrace.o(18565667225600L, 138325);
    }
  }
  
  public static final class b
  {
    public static final int maP;
    public static final TextPaint maQ;
    public static final int maR;
    public static final TextPaint maS;
    public static final int maT;
    public static final TextPaint maU;
    
    static
    {
      GMTrace.i(18561506476032L, 138294);
      maP = a.T(aa.getContext(), j.b.aXH);
      maQ = new TextPaint();
      maR = a.T(aa.getContext(), j.b.aXr);
      maS = new TextPaint();
      maT = a.T(aa.getContext(), j.b.aXT);
      maU = new TextPaint();
      maQ.setTextSize(maP);
      maS.setTextSize(maR);
      maU.setTextSize(maT);
      GMTrace.o(18561506476032L, 138294);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */