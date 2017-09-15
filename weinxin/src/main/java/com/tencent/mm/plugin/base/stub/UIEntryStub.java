package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.mm.y.n;

@a(7)
public class UIEntryStub
  extends Activity
{
  private Intent fNF;
  private int jNt;
  private boolean jNu;
  private String uq;
  
  public UIEntryStub()
  {
    GMTrace.i(12834436022272L, 95624);
    GMTrace.o(12834436022272L, 95624);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(12834570240000L, 95625);
    super.onCreate(paramBundle);
    NotifyReceiver.pX();
    this.jNu = false;
    GMTrace.o(12834570240000L, 95625);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    GMTrace.i(12834704457728L, 95626);
    super.onNewIntent(paramIntent);
    this.fNF = paramIntent;
    v.i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", new Object[] { Boolean.valueOf(this.jNu) });
    this.jNu = false;
    GMTrace.o(12834704457728L, 95626);
  }
  
  public void onResume()
  {
    GMTrace.i(12834838675456L, 95627);
    super.onResume();
    if (this.fNF == null) {
      this.fNF = getIntent();
    }
    ap.vd().a(new bb(new bb.a()
    {
      public final void a(e paramAnonymouse)
      {
        GMTrace.i(12835643981824L, 95633);
        if (paramAnonymouse == null)
        {
          UIEntryStub.this.finish();
          GMTrace.o(12835643981824L, 95633);
          return;
        }
        v.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", new Object[] { Boolean.valueOf(UIEntryStub.a(UIEntryStub.this)) });
        if (!UIEntryStub.a(UIEntryStub.this))
        {
          UIEntryStub.b(UIEntryStub.this);
          UIEntryStub.a(UIEntryStub.this, UIEntryStub.c(UIEntryStub.this).getExtras());
        }
        GMTrace.o(12835643981824L, 95633);
      }
    }), 0);
    GMTrace.o(12834838675456L, 95627);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/stub/UIEntryStub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */