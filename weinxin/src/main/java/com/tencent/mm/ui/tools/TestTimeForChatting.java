package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;

public class TestTimeForChatting
  extends DrawedCallBackLinearLayout
{
  public final String TAG;
  public int haf;
  public int wmM;
  public int wmN;
  
  public TestTimeForChatting(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(1943204265984L, 14478);
    this.TAG = "MicroMsg.TestTimeForChatting";
    this.haf = 0;
    this.wmM = 0;
    this.wmN = 0;
    GMTrace.o(1943204265984L, 14478);
  }
  
  public TestTimeForChatting(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1943338483712L, 14479);
    this.TAG = "MicroMsg.TestTimeForChatting";
    this.haf = 0;
    this.wmM = 0;
    this.wmN = 0;
    GMTrace.o(1943338483712L, 14479);
  }
  
  public final void bZK()
  {
    GMTrace.i(1943606919168L, 14481);
    v.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", new Object[] { Integer.valueOf(this.haf) });
    g.oSF.i(11198, new Object[] { Integer.valueOf(this.haf) });
    GMTrace.o(1943606919168L, 14481);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    GMTrace.i(1943741136896L, 14482);
    this.haf += 1;
    try
    {
      super.dispatchDraw(paramCanvas);
      f.rV(9);
      f.rV(18);
      f.rV(25);
      f.rV(24);
      f.rV(20);
      GMTrace.o(1943741136896L, 14482);
      return;
    }
    catch (Throwable paramCanvas)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.TestTimeForChatting", paramCanvas, "dispatchDraw", new Object[0]);
      }
    }
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    GMTrace.i(1943875354624L, 14483);
    v.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", new Object[] { paramRect.toString(), Integer.valueOf(this.wmM), Integer.valueOf(this.wmN) });
    paramRect.bottom += this.wmM;
    paramRect.right += this.wmN;
    boolean bool = super.fitSystemWindows(paramRect);
    GMTrace.o(1943875354624L, 14483);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1943472701440L, 14480);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    GMTrace.o(1943472701440L, 14480);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/TestTimeForChatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */