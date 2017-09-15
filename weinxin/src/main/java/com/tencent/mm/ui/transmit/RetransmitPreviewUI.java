package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.bi.g;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.MMTextView;

public class RetransmitPreviewUI
  extends MMActivity
{
  private String text;
  private MMTextView vDV;
  
  public RetransmitPreviewUI()
  {
    GMTrace.i(3038957797376L, 22642);
    this.vDV = null;
    this.text = null;
    GMTrace.o(3038957797376L, 22642);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3039092015104L, 22643);
    int i = R.i.cXR;
    GMTrace.o(3039092015104L, 22643);
    return i;
  }
  
  public void onBackPressed()
  {
    GMTrace.i(3039360450560L, 22645);
    finish();
    GMTrace.o(3039360450560L, 22645);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3039226232832L, 22644);
    super.onCreate(paramBundle);
    qL("");
    this.text = getIntent().getStringExtra("Retr_Msg_content");
    this.vDV = ((MMTextView)findViewById(R.h.bSh));
    this.vDV.setText(g.bKx().d(this.uRf.uRz, this.text, this.vDV.getTextSize()));
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(3038823579648L, 22641);
        RetransmitPreviewUI.this.finish();
        GMTrace.o(3038823579648L, 22641);
        return true;
      }
    });
    GMTrace.o(3039226232832L, 22644);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(3039494668288L, 22646);
    super.onDestroy();
    GMTrace.o(3039494668288L, 22646);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/transmit/RetransmitPreviewUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */