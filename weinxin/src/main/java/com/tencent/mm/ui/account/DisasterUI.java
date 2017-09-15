package com.tencent.mm.ui.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class DisasterUI
  extends MMActivity
{
  public DisasterUI()
  {
    GMTrace.i(2638586314752L, 19659);
    GMTrace.o(2638586314752L, 19659);
  }
  
  public final boolean byc()
  {
    GMTrace.i(2638988967936L, 19662);
    GMTrace.o(2638988967936L, 19662);
    return false;
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2638854750208L, 19661);
    int i = R.i.cZZ;
    GMTrace.o(2638854750208L, 19661);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2638720532480L, 19660);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_disaster_content");
    final String str = getIntent().getStringExtra("key_disaster_url");
    v.i("MicroMsg.DisasterUI", "summerdiz onCreate :%d, content[%s], url[%s]", new Object[] { Integer.valueOf(hashCode()), paramBundle, str });
    ((TextView)findViewById(R.h.coL)).setText(paramBundle);
    findViewById(R.h.coK).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2654558224384L, 19778);
        g.oSF.i(13939, new Object[] { Integer.valueOf(1) });
        paramAnonymousView = new Intent("android.intent.action.VIEW");
        paramAnonymousView.setData(Uri.parse(str));
        DisasterUI.this.startActivity(paramAnonymousView);
        GMTrace.o(2654558224384L, 19778);
      }
    });
    qL(getString(R.l.ebz));
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2685294084096L, 20007);
        g.oSF.i(13939, new Object[] { Integer.valueOf(3) });
        DisasterUI.this.finish();
        GMTrace.o(2685294084096L, 20007);
        return true;
      }
    });
    GMTrace.o(2638720532480L, 19660);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/DisasterUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */