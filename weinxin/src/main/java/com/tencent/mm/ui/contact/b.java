package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class b
  extends RelativeLayout
{
  private TextView contentView;
  private Context context;
  private View llc;
  private View nrp;
  
  public b(Context paramContext, final a parama)
  {
    super(paramContext);
    GMTrace.i(1731140255744L, 12898);
    this.llc = null;
    this.nrp = null;
    this.contentView = null;
    this.context = paramContext;
    View.inflate(getContext(), R.i.cTx, this);
    this.llc = findViewById(R.h.bGk);
    this.nrp = this.llc.findViewById(R.h.bnJ);
    paramContext = this.nrp.getLayoutParams();
    paramContext.height = ((int)(a.U(this.context, R.f.aWL) * a.dL(this.context)));
    this.nrp.setLayoutParams(paramContext);
    this.contentView = ((TextView)this.nrp.findViewById(R.h.bnL));
    this.llc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1708323241984L, 12728);
        switch (b.3.vTQ[parama.ordinal()])
        {
        default: 
          v.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", new Object[] { parama });
          GMTrace.o(1708323241984L, 12728);
          return;
        case 1: 
          paramAnonymousView = new Intent();
          paramAnonymousView.setClassName(b.a(b.this), "com.tencent.mm.ui.contact.ChatroomContactUI");
          b.a(b.this).startActivity(paramAnonymousView);
          GMTrace.o(1708323241984L, 12728);
          return;
        case 2: 
          paramAnonymousView = new Intent();
          com.tencent.mm.bb.d.b(b.a(b.this), "label", ".ui.ContactLabelManagerUI", paramAnonymousView);
          GMTrace.o(1708323241984L, 12728);
          return;
        }
        paramAnonymousView = new Intent();
        com.tencent.mm.bb.d.b(b.a(b.this), "ipcall", ".ui.IPCallAddressUI", paramAnonymousView);
        GMTrace.o(1708323241984L, 12728);
      }
    });
    this.nrp.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(1708860112896L, 12732);
        if ((b.a(b.this) instanceof MMActivity)) {
          ((MMActivity)b.a(b.this)).aGY();
        }
        GMTrace.o(1708860112896L, 12732);
        return false;
      }
    });
    paramContext = (ImageView)((MaskLayout)this.nrp.findViewById(R.h.bnK)).view;
    switch (3.vTQ[parama.ordinal()])
    {
    }
    for (;;)
    {
      GMTrace.o(1731140255744L, 12898);
      return;
      this.contentView.setText(R.l.dCj);
      com.tencent.mm.x.d.a(getContext(), paramContext, R.k.dwf);
      GMTrace.o(1731140255744L, 12898);
      return;
      this.contentView.setText(R.l.dCm);
      com.tencent.mm.x.d.a(getContext(), paramContext, R.k.dwg);
      GMTrace.o(1731140255744L, 12898);
      return;
      this.nrp.setBackgroundResource(R.g.ben);
      this.contentView.setText(R.l.dCl);
      com.tencent.mm.x.d.a(getContext(), paramContext, R.k.dwi);
    }
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    GMTrace.i(1731274473472L, 12899);
    View localView = this.llc;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      GMTrace.o(1731274473472L, 12899);
      return;
    }
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(1843748929536L, 13737);
      vTR = new a("Chatromm", 0);
      vTS = new a("ContactLabel", 1);
      vTT = new a("ContactIpCall", 2);
      vTU = new a[] { vTR, vTS, vTT };
      GMTrace.o(1843748929536L, 13737);
    }
    
    private a()
    {
      GMTrace.i(1843614711808L, 13736);
      GMTrace.o(1843614711808L, 13736);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */