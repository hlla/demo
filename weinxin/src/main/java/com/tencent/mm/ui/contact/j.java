package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;

public final class j
  extends LinearLayout
{
  private Context context;
  private String htS;
  
  public j(Context paramContext, String paramString)
  {
    super(paramContext);
    GMTrace.i(1841601445888L, 13721);
    this.context = paramContext;
    this.htS = paramString;
    paramContext = View.inflate(getContext(), R.i.daR, this);
    paramString = findViewById(R.h.bMc);
    paramContext.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1837574914048L, 13691);
        Intent localIntent = new Intent();
        localIntent.putExtra("enterprise_from_scene", 2);
        localIntent.putExtra("enterprise_biz_name", j.a(j.this));
        d.b(paramAnonymousView.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", localIntent);
        GMTrace.o(1837574914048L, 13691);
      }
    });
    paramString.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(1810731368448L, 13491);
        if ((j.b(j.this) instanceof MMActivity)) {
          ((MMActivity)j.b(j.this)).aGY();
        }
        GMTrace.o(1810731368448L, 13491);
        return false;
      }
    });
    ap.yY();
    paramContext = c.wR().QZ(this.htS);
    if ((paramContext == null) || ((int)paramContext.gTG <= 0))
    {
      v.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", new Object[] { this.htS });
      GMTrace.o(1841601445888L, 13721);
      return;
    }
    paramString = (MaskLayout)paramString.findViewById(R.h.btB);
    a.b.a((ImageView)paramString.view, this.htS);
    if (paramContext.field_verifyFlag != 0) {
      if (ag.a.hlC != null)
      {
        String str = ag.a.hlC.eZ(paramContext.field_verifyFlag);
        if (str != null) {
          paramString.d(l.il(str), MaskLayout.a.vmg);
        }
      }
    }
    for (;;)
    {
      ((TextView)findViewById(R.h.bMd)).setText(paramContext.tK());
      GMTrace.o(1841601445888L, 13721);
      return;
      paramString.bSw();
      continue;
      paramString.bSw();
      continue;
      paramString.bSw();
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */