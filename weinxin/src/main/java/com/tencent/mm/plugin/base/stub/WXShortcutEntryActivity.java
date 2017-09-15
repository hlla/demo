package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.ac.b;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.ac.d;
import com.tencent.mm.plugin.ac.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;

public class WXShortcutEntryActivity
  extends AutoLoginActivity
{
  public WXShortcutEntryActivity()
  {
    GMTrace.i(12833899151360L, 95620);
    GMTrace.o(12833899151360L, 95620);
  }
  
  protected final void a(AutoLoginActivity.b paramb, Intent paramIntent)
  {
    GMTrace.i(12834301804544L, 95623);
    if (paramIntent == null)
    {
      v.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
      finish();
      GMTrace.o(12834301804544L, 95623);
      return;
    }
    paramb = new d();
    paramb.a(new e());
    paramb.a(new c());
    int i = r.a(paramIntent, "type", 0);
    if (paramIntent != null)
    {
      paramb = (b)paramb.prS.get(i);
      if (paramb != null) {
        paramb.n(this, paramIntent);
      }
    }
    finish();
    GMTrace.o(12834301804544L, 95623);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(12834033369088L, 95621);
    super.onCreate(paramBundle);
    GMTrace.o(12834033369088L, 95621);
  }
  
  protected final boolean u(Intent paramIntent)
  {
    GMTrace.i(12834167586816L, 95622);
    GMTrace.o(12834167586816L, 95622);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/stub/WXShortcutEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */