package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import java.lang.ref.WeakReference;

public final class f
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  public String wcZ;
  public String wda;
  
  public f(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    GMTrace.i(14497527889920L, 108015);
    this.wcZ = null;
    this.wda = null;
    this.wcZ = paramString1;
    this.wda = paramString2;
    if (this.view != null)
    {
      paramContext = (ImageView)this.view.findViewById(R.h.bzS);
      this.view.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(14496991019008L, 108011);
          paramAnonymousView = new Intent((Context)f.this.sLV.get(), SelectContactUI.class);
          paramAnonymousView.putExtra("list_attr", s.ef(s.vWO, 256));
          paramAnonymousView.putExtra("list_type", 10);
          paramAnonymousView.putExtra("received_card_name", f.this.wcZ);
          paramAnonymousView.putExtra("recommend_friends", true);
          paramAnonymousView.putExtra("titile", ((Context)f.this.sLV.get()).getString(R.l.dCK));
          ((Context)f.this.sLV.get()).startActivity(paramAnonymousView);
          ap.yY().xy().gB(f.this.wcZ);
          ap.yY().xy().gB(f.this.wda);
          g.oSF.i(11003, new Object[] { f.this.wcZ, Integer.valueOf(2), Integer.valueOf(0) });
          GMTrace.o(14496991019008L, 108011);
        }
      });
      paramContext.setImageBitmap(com.tencent.mm.x.b.a(this.wcZ, true, -1));
    }
    GMTrace.o(14497527889920L, 108015);
  }
  
  public final void destroy()
  {
    GMTrace.i(14497796325376L, 108017);
    GMTrace.o(14497796325376L, 108017);
  }
  
  public final int getLayoutId()
  {
    GMTrace.i(14497662107648L, 108016);
    int i = R.i.cYC;
    GMTrace.o(14497662107648L, 108016);
    return i;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */