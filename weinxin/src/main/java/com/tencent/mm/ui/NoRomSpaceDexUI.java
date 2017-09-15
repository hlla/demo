package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;

public class NoRomSpaceDexUI
  extends MMActivity
{
  public NoRomSpaceDexUI()
  {
    GMTrace.i(3087007744000L, 23000);
    GMTrace.o(3087007744000L, 23000);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3087141961728L, 23001);
    int i = R.i.dkb;
    GMTrace.o(3087141961728L, 23001);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3087276179456L, 23002);
    super.onCreate(paramBundle);
    paramBundle = new h.a(this);
    paramBundle.zR(R.l.dVP);
    paramBundle.SW(getString(R.l.dVO));
    paramBundle.kH(false);
    paramBundle.zU(R.l.dVM).a(new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GMTrace.i(1605915115520L, 11965);
        Process.killProcess(Process.myPid());
        GMTrace.o(1605915115520L, 11965);
      }
    });
    paramBundle.WD().show();
    GMTrace.o(3087276179456L, 23002);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/NoRomSpaceDexUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */