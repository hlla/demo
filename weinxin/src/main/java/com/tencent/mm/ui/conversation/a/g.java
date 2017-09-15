package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.lang.ref.WeakReference;

public final class g
  extends b
{
  public boolean vvA;
  public String wcZ;
  public String wda;
  
  public g(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext);
    GMTrace.i(14507728437248L, 108091);
    this.wcZ = null;
    this.wda = null;
    this.vvA = false;
    this.wcZ = paramString1;
    this.wda = paramString2;
    this.vvA = paramBoolean;
    if (this.view != null)
    {
      paramContext = (TextView)this.view.findViewById(R.h.bBj);
      paramString1 = ap.yY().xz().O(this.wcZ, "wording");
      paramString2 = ap.yY().xz().O(this.wda, "wording");
      if (bf.mA(paramString1)) {
        break label166;
      }
      paramContext.setText(paramString1);
    }
    for (;;)
    {
      ((TextView)this.view.findViewById(R.h.bBi)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14494440882176L, 107992);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("k_username", g.this.wcZ);
          int i = 39;
          if (g.this.vvA) {
            i = 36;
          }
          paramAnonymousView.putExtra("showShare", false);
          paramAnonymousView.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
          if (g.this.sLV.get() != null) {
            com.tencent.mm.bb.d.b((Context)g.this.sLV.get(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          }
          ap.yY().xz().gB(g.this.wcZ);
          ap.yY().xz().gB(g.this.wda);
          GMTrace.o(14494440882176L, 107992);
        }
      });
      ((ImageView)this.view.findViewById(R.h.bBh)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14506788913152L, 108084);
          ap.yY().xz().gB(g.this.wcZ);
          ap.yY().xz().gB(g.this.wda);
          GMTrace.o(14506788913152L, 108084);
        }
      });
      GMTrace.o(14507728437248L, 108091);
      return;
      label166:
      if (!bf.mA(paramString2)) {
        paramContext.setText(paramString2);
      }
    }
  }
  
  public final void destroy()
  {
    GMTrace.i(14507996872704L, 108093);
    GMTrace.o(14507996872704L, 108093);
  }
  
  public final int getLayoutId()
  {
    GMTrace.i(14507862654976L, 108092);
    int i = R.i.cYD;
    GMTrace.o(14507862654976L, 108092);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */