package com.tencent.mm.ui.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.o;

public final class b
  extends o
{
  public long mDuration;
  @SuppressLint({"HandlerLeak"})
  private ad mHandler;
  
  private b(View paramView)
  {
    super(paramView);
    GMTrace.i(2873869991936L, 21412);
    this.mDuration = 3000L;
    this.mHandler = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(2873735774208L, 21411);
        switch (paramAnonymousMessage.what)
        {
        default: 
          super.handleMessage(paramAnonymousMessage);
          GMTrace.o(2873735774208L, 21411);
          return;
        }
        b.this.dismiss();
        GMTrace.o(2873735774208L, 21411);
      }
    };
    GMTrace.o(2873869991936L, 21412);
  }
  
  public static b fc(Context paramContext)
  {
    GMTrace.i(2874004209664L, 21413);
    paramContext = LayoutInflater.from(paramContext).inflate(a.h.heE, null);
    ((TextView)paramContext.findViewById(a.g.hdu)).setVisibility(8);
    b localb = new b(paramContext);
    localb.setFocusable(false);
    localb.setContentView(paramContext);
    localb.setWidth(-1);
    localb.setHeight(-1);
    localb.setAnimationStyle(a.l.hfm);
    localb.mDuration = 1200L;
    GMTrace.o(2874004209664L, 21413);
    return localb;
  }
  
  public final void showAsDropDown(View paramView)
  {
    GMTrace.i(2874272645120L, 21415);
    super.showAsDropDown(paramView);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    GMTrace.o(2874272645120L, 21415);
  }
  
  public final void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    GMTrace.i(2874138427392L, 21414);
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    GMTrace.o(2874138427392L, 21414);
  }
  
  public final void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(2874406862848L, 21416);
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    this.mHandler.removeMessages(256);
    this.mHandler.sendEmptyMessageDelayed(256, this.mDuration);
    GMTrace.o(2874406862848L, 21416);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */