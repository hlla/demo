package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.k;

public final class dc
  extends k<au>
{
  private String fJC;
  private String hrv;
  private String jXC;
  a vEP;
  private boolean vvA;
  
  public dc(Context paramContext, au paramau, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramau);
    GMTrace.i(2485041233920L, 18515);
    this.fJC = paramString1;
    this.hrv = paramString2;
    this.vvA = paramBoolean;
    GMTrace.o(2485041233920L, 18515);
  }
  
  private String ar(au paramau)
  {
    GMTrace.i(2485443887104L, 18518);
    if (paramau.field_isSend == 1)
    {
      paramau = this.hrv;
      GMTrace.o(2485443887104L, 18518);
      return paramau;
    }
    paramau = this.fJC;
    GMTrace.o(2485443887104L, 18518);
    return paramau;
  }
  
  private CharSequence as(au paramau)
  {
    GMTrace.i(2485846540288L, 18521);
    if (paramau.field_createTime == Long.MAX_VALUE)
    {
      GMTrace.o(2485846540288L, 18521);
      return "";
    }
    paramau = o.c(this.context, paramau.field_createTime, true);
    GMTrace.o(2485846540288L, 18521);
    return paramau;
  }
  
  public final void OL()
  {
    GMTrace.i(2485578104832L, 18519);
    ap.yY();
    setCursor(com.tencent.mm.u.c.wT().cO(this.fJC, this.jXC));
    if ((this.vEP != null) && (!u.mA(this.jXC))) {
      this.vEP.AN(getCount());
    }
    super.notifyDataSetChanged();
    GMTrace.o(2485578104832L, 18519);
  }
  
  protected final void OM()
  {
    GMTrace.i(2485712322560L, 18520);
    aEP();
    OL();
    GMTrace.o(2485712322560L, 18520);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(2485175451648L, 18516);
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.dmZ, null);
      paramViewGroup = new b();
      paramViewGroup.ipb = ((ImageView)paramView.findViewById(R.h.bqF));
      paramViewGroup.jUr = ((TextView)paramView.findViewById(R.h.cnW));
      paramViewGroup.jUs = ((TextView)paramView.findViewById(R.h.cKE));
      paramViewGroup.vEQ = ((TextView)paramView.findViewById(R.h.clt));
      paramView.setTag(paramViewGroup);
      localObject = (au)getItem(paramInt);
      if (localObject != null)
      {
        if ((!this.vvA) || (((ce)localObject).field_isSend != 0)) {
          break label246;
        }
        String str1 = ((ce)localObject).field_content;
        String str2 = ay.gi(str1);
        if (!u.mA(str2))
        {
          a.b.a(paramViewGroup.ipb, str2);
          paramViewGroup.jUr.setText(h.b(this.context, n.eK(str2), paramViewGroup.jUr.getTextSize()));
        }
        paramViewGroup.jUs.setText(as((au)localObject));
        localObject = ay.gj(str1);
        paramViewGroup.vEQ.setText(h.b(this.context, (CharSequence)localObject, paramViewGroup.vEQ.getTextSize()));
      }
    }
    for (;;)
    {
      GMTrace.o(2485175451648L, 18516);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label246:
      a.b.a(paramViewGroup.ipb, ar((au)localObject));
      paramViewGroup.jUr.setText(h.b(this.context, n.eK(ar((au)localObject)), paramViewGroup.jUr.getTextSize()));
      paramViewGroup.jUs.setText(as((au)localObject));
      paramViewGroup.vEQ.setText(h.b(this.context, ((ce)localObject).field_content, paramViewGroup.vEQ.getTextSize()));
    }
  }
  
  public final void yB(String paramString)
  {
    GMTrace.i(2485309669376L, 18517);
    this.jXC = paramString;
    if (!u.mA(this.jXC))
    {
      aEP();
      OL();
    }
    GMTrace.o(2485309669376L, 18517);
  }
  
  public static abstract interface a
  {
    public abstract void AN(int paramInt);
  }
  
  private static final class b
  {
    public ImageView ipb;
    public TextView jUr;
    public TextView jUs;
    public TextView vEQ;
    
    public b()
    {
      GMTrace.i(2401155153920L, 17890);
      GMTrace.o(2401155153920L, 17890);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */