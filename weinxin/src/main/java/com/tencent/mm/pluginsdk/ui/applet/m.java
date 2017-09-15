package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import junit.framework.Assert;

public final class m
  implements e
{
  public Context context;
  p irp;
  public EditText oAr;
  LinkedList<Integer> oFh;
  public com.tencent.mm.ui.base.h oGr;
  public View oGs;
  public TextView oGt;
  String sKj;
  public a sLM;
  LinkedList<String> sLN;
  boolean sLO;
  
  public m(Context paramContext, a parama)
  {
    GMTrace.i(960327843840L, 7155);
    this.oGr = null;
    this.sLO = true;
    this.context = paramContext;
    this.sLM = parama;
    GMTrace.o(960327843840L, 7155);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(960864714752L, 7159);
    if (paramk.getType() != 30)
    {
      v.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + paramk.getType());
      GMTrace.o(960864714752L, 7159);
      return;
    }
    v.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if (this.irp != null)
    {
      this.irp.dismiss();
      this.irp = null;
    }
    onStop();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.sLO) {
        g.bk(this.context, this.context.getString(a.g.eRd));
      }
      this.sLM.dj(true);
      GMTrace.o(960864714752L, 7159);
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -34)) {
      paramk = this.context.getString(a.g.ekV);
    }
    for (;;)
    {
      if (this.sLO) {
        Toast.makeText(this.context, paramk, 1).show();
      }
      this.sLM.dj(false);
      GMTrace.o(960864714752L, 7159);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -94))
      {
        paramk = this.context.getString(a.g.ekW);
      }
      else if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramk = paramString;
        if (!bf.mA(paramString)) {}
      }
      else if (paramInt1 == 4)
      {
        paramk = paramString;
        if (!bf.mA(paramString)) {}
      }
      else
      {
        paramk = this.context.getString(a.g.eRc);
      }
    }
  }
  
  public final void g(LinkedList<String> paramLinkedList, LinkedList<Integer> paramLinkedList1)
  {
    GMTrace.i(960730497024L, 7158);
    boolean bool;
    if (paramLinkedList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramLinkedList1.size() <= 0) {
        break label322;
      }
      bool = true;
      label34:
      Assert.assertTrue(bool);
      onStart();
      this.sLN = paramLinkedList;
      this.oFh = paramLinkedList1;
      this.oGs = View.inflate(this.context, a.e.dnH, null);
      if (this.sKj != null) {
        break label328;
      }
      bool = true;
      label78:
      if (this.sKj != null) {
        break label334;
      }
    }
    label322:
    label328:
    label334:
    for (int i = 0;; i = this.sKj.length())
    {
      v.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), this.sKj });
      if (!bf.mA(this.sKj)) {
        ((TextView)this.oGs.findViewById(a.d.cCr)).setText(this.sKj);
      }
      this.oAr = ((EditText)this.oGs.findViewById(a.d.cCq));
      this.oGt = ((TextView)this.oGs.findViewById(a.d.cSY));
      this.oGt.setVisibility(0);
      this.oAr.setText(null);
      this.oGt.setText("50");
      this.oAr.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.sUQ);
      this.oAr.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          GMTrace.i(958985666560L, 7145);
          int j = 50 - paramAnonymousEditable.length();
          int i = j;
          if (j < 0) {
            i = 0;
          }
          if (m.this.oGt != null) {
            m.this.oGt.setText(String.valueOf(i));
          }
          GMTrace.o(958985666560L, 7145);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(958851448832L, 7144);
          GMTrace.o(958851448832L, 7144);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(958717231104L, 7143);
          GMTrace.o(958717231104L, 7143);
        }
      });
      paramLinkedList = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(942879539200L, 7025);
          if (m.this.oGr != null)
          {
            m.this.oGr.dismiss();
            m.this.oGr = null;
          }
          new ai(new ai.a()
          {
            public final boolean oQ()
            {
              GMTrace.i(943147974656L, 7027);
              if (m.this.oGs != null)
              {
                m localm = m.this;
                String str = m.this.oAr.getText().toString().trim();
                Context localContext = localm.context;
                localm.context.getString(a.g.dIG);
                localm.irp = g.a(localContext, localm.context.getString(a.g.eRe), true, new m.5(localm));
                com.tencent.mm.kernel.h.vH().gXs.a(new com.tencent.mm.pluginsdk.model.n(2, localm.sLN, localm.oFh, str, ""), 0);
              }
              GMTrace.o(943147974656L, 7027);
              return false;
            }
          }, false).v(500L, 500L);
          GMTrace.o(942879539200L, 7025);
        }
      };
      paramLinkedList1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(961133150208L, 7161);
          if (m.this.oGr != null)
          {
            m.this.oGr.dismiss();
            m.this.oGr = null;
          }
          m.this.onStop();
          if (m.this.sLM != null) {
            m.this.sLM.dj(false);
          }
          GMTrace.o(961133150208L, 7161);
        }
      };
      this.oGr = g.a(this.context, this.context.getString(a.g.eRf), this.oGs, paramLinkedList, paramLinkedList1);
      if (this.oGr == null) {
        onStop();
      }
      this.oAr.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(938718789632L, 6994);
          if ((m.this.context instanceof MMActivity)) {
            ((MMActivity)m.this.context).aHc();
          }
          GMTrace.o(938718789632L, 6994);
        }
      });
      GMTrace.o(960730497024L, 7158);
      return;
      bool = false;
      break;
      bool = false;
      break label34;
      bool = false;
      break label78;
    }
  }
  
  final void onStart()
  {
    GMTrace.i(960462061568L, 7156);
    com.tencent.mm.kernel.h.vH().gXs.a(30, this);
    GMTrace.o(960462061568L, 7156);
  }
  
  public final void onStop()
  {
    GMTrace.i(960596279296L, 7157);
    com.tencent.mm.kernel.h.vH().gXs.b(30, this);
    if (this.oGr != null)
    {
      this.oGr.dismiss();
      this.oGr = null;
    }
    GMTrace.o(960596279296L, 7157);
  }
  
  public static abstract interface a
  {
    public abstract void dj(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */