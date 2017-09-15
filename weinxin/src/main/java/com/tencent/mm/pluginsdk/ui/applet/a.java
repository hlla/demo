package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.iw;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class a
  implements e
{
  private String chatroomName;
  private Context context;
  private p irp;
  private LinkedList<String> oFg;
  private LinkedList<Integer> oFh;
  public String orn;
  private a sKg;
  public b sKh;
  private LinkedList<String> sKi;
  public String sKj;
  public String sKk;
  public String sKl;
  public String sKm;
  public boolean sKn;
  public boolean sKo;
  public String sKp;
  public boolean sKq;
  
  public a(Context paramContext, a parama)
  {
    GMTrace.i(937108176896L, 6982);
    this.orn = "";
    this.sKk = "";
    this.chatroomName = "";
    this.sKn = true;
    this.sKo = true;
    this.sKp = "";
    this.sKq = false;
    this.context = paramContext;
    this.sKg = parama;
    this.oFg = new LinkedList();
    this.sKi = new LinkedList();
    this.irp = null;
    GMTrace.o(937108176896L, 6982);
  }
  
  private void a(String paramString1, LinkedList<Integer> paramLinkedList, boolean paramBoolean, String paramString2)
  {
    GMTrace.i(937913483264L, 6988);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramLinkedList == null) {
        break label209;
      }
    }
    label209:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.sKn = paramBoolean;
      h.vH().gXs.a(30, this);
      if (this.sKo)
      {
        Context localContext = this.context;
        this.context.getString(a.g.dIG);
        this.irp = g.a(localContext, this.context.getString(a.g.kCq), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(945429676032L, 7044);
            a.this.c(false, false, a.this.sKk, a.this.sKp);
            GMTrace.o(945429676032L, 7044);
          }
        });
      }
      this.oFh = paramLinkedList;
      this.oFg.add(paramString1);
      this.sKk = paramString1;
      paramString1 = new com.tencent.mm.pluginsdk.model.n(1, this.oFg, paramLinkedList, this.sKi, "", this.orn, null, this.chatroomName, paramString2);
      if (!bf.mA(this.sKl)) {
        paramString1.ei(this.sKl, this.sKm);
      }
      h.vH().gXs.a(paramString1, 0);
      GMTrace.o(937913483264L, 6988);
      return;
      bool = false;
      break;
    }
  }
  
  private void r(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(938316136448L, 6991);
    if ((this.sKq) && (!bf.mA(paramString))) {
      Toast.makeText(this.context, paramString, 1).show();
    }
    for (;;)
    {
      c(false, false, this.sKk, this.sKp);
      GMTrace.o(938316136448L, 6991);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -22)) {
        Toast.makeText(this.context, this.context.getString(a.g.dBY), 1).show();
      } else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bf.mA(paramString))) {
        Toast.makeText(this.context, paramString, 1).show();
      } else {
        Toast.makeText(this.context, this.context.getString(a.g.dBX), 1).show();
      }
    }
  }
  
  public final void MI(String paramString)
  {
    GMTrace.i(937645047808L, 6986);
    if (!TextUtils.isEmpty(paramString)) {
      this.sKi.add(paramString);
    }
    GMTrace.o(937645047808L, 6986);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, final k paramk)
  {
    GMTrace.i(938181918720L, 6990);
    v.d("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if (paramk.getType() != 30)
    {
      v.w("MicroMsg.AddContact", "not expected scene,  type = " + paramk.getType());
      GMTrace.o(938181918720L, 6990);
      return;
    }
    if (this.irp != null)
    {
      this.irp.dismiss();
      this.irp = null;
    }
    h.vH().gXs.b(30, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.sKk = ((com.tencent.mm.pluginsdk.model.n)paramk).bCA();
      c(true, false, this.sKk, this.sKp);
      GMTrace.o(938181918720L, 6990);
      return;
    }
    if (paramInt2 == -44)
    {
      paramString = this.sKp;
      if (this.sKh != null)
      {
        this.sKh.aFh();
        c(false, false, this.sKk, paramString);
        GMTrace.o(938181918720L, 6990);
        return;
      }
      paramString = new m(this.context, new m.a()
      {
        public final void dj(boolean paramAnonymousBoolean)
        {
          GMTrace.i(962475327488L, 7171);
          String str = a.this.sKp;
          a.this.c(false, paramAnonymousBoolean, a.this.sKk, str);
          GMTrace.o(962475327488L, 7171);
        }
      });
      if (this.sKj != null) {
        paramString.sKj = this.sKj;
      }
      if (this.sKn)
      {
        paramk = this.oFg;
        LinkedList localLinkedList = this.oFh;
        paramString.sLO = false;
        paramString.onStart();
        h.vH().gXs.a(new com.tencent.mm.pluginsdk.model.n(2, paramk, localLinkedList, "", ""), 0);
        GMTrace.o(938181918720L, 6990);
        return;
      }
      paramString.g(this.oFg, this.oFh);
      GMTrace.o(938181918720L, 6990);
      return;
    }
    if (paramInt2 == -87)
    {
      g.b(this.context, this.context.getString(a.g.dXA), "", true);
      GMTrace.o(938181918720L, 6990);
      return;
    }
    if ((paramInt2 == -101) && (!bf.mA(paramString)))
    {
      v.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
      g.a(this.context, paramString, "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(962206892032L, 7169);
          a.this.c(false, false, a.this.sKk, a.this.sKp);
          GMTrace.o(962206892032L, 7169);
        }
      });
      GMTrace.o(938181918720L, 6990);
      return;
    }
    if (paramInt2 == 65234)
    {
      paramInt1 = ((com.tencent.mm.pluginsdk.model.n)paramk).fJB;
      v.d("MicroMsg.AddContact", "onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 == 3) {
        g.b(this.context, this.context.getString(a.g.eag), this.context.getString(a.g.dIG), this.context.getString(a.g.dDa), this.context.getString(a.g.dGk), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(934558040064L, 6963);
            v.d("MicroMsg.AddContact", "dealwith verify relation out of date");
            paramAnonymousDialogInterface = (com.tencent.mm.pluginsdk.model.n)paramk;
            if ((paramAnonymousDialogInterface.gUq != null) && (paramAnonymousDialogInterface.gUq.BG() != null)) {}
            for (paramAnonymousDialogInterface = ((bja)paramAnonymousDialogInterface.gUq.hrS.hsa).uhe;; paramAnonymousDialogInterface = null)
            {
              List localList = ((com.tencent.mm.pluginsdk.model.n)paramk).sAP;
              if ((localList != null) && (localList.size() > 0)) {
                a.this.c((String)localList.get(0), paramAnonymousDialogInterface);
              }
              GMTrace.o(934558040064L, 6963);
              return;
            }
          }
        }, null);
      }
      GMTrace.o(938181918720L, 6990);
      return;
    }
    if (paramInt2 == -2)
    {
      if (!bf.mA(paramString))
      {
        g.a(this.context, paramString, this.context.getString(a.g.dIG), this.context.getString(a.g.dHL), null);
        GMTrace.o(938181918720L, 6990);
        return;
      }
      r(paramInt1, paramInt2, null);
      GMTrace.o(938181918720L, 6990);
      return;
    }
    r(paramInt1, paramInt2, paramString);
    GMTrace.o(938181918720L, 6990);
  }
  
  public final void a(String paramString1, LinkedList<Integer> paramLinkedList, String paramString2)
  {
    GMTrace.i(937510830080L, 6985);
    a(paramString1, paramLinkedList, false, paramString2);
    GMTrace.o(937510830080L, 6985);
  }
  
  public final void b(String paramString1, String paramString2, LinkedList<Integer> paramLinkedList)
  {
    GMTrace.i(937242394624L, 6983);
    this.chatroomName = paramString2;
    a(paramString1, paramLinkedList, false, "");
    GMTrace.o(937242394624L, 6983);
  }
  
  public final void b(String paramString, LinkedList<Integer> paramLinkedList, boolean paramBoolean)
  {
    GMTrace.i(937779265536L, 6987);
    a(paramString, paramLinkedList, paramBoolean, "");
    GMTrace.o(937779265536L, 6987);
  }
  
  public final void c(String paramString, LinkedList<Integer> paramLinkedList)
  {
    GMTrace.i(937376612352L, 6984);
    a(paramString, paramLinkedList, false, "");
    GMTrace.o(937376612352L, 6984);
  }
  
  public final void c(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    GMTrace.i(938047700992L, 6989);
    if (this.sKg != null) {
      this.sKg.a(paramBoolean1, paramBoolean2, paramString1, paramString2);
    }
    if (paramBoolean1)
    {
      paramString2 = new iw();
      paramString2.fOy.username = paramString1;
      com.tencent.mm.sdk.b.a.uql.m(paramString2);
    }
    GMTrace.o(938047700992L, 6989);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract boolean aFh();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */