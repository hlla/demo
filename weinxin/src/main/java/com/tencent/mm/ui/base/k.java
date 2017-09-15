package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.l;
import com.tencent.mm.sdk.platformtools.v;

public final class k
  extends AlertDialog
{
  private ListView Fg;
  private View kfJ;
  public BaseAdapter khv;
  private Context mContext;
  public AdapterView.OnItemClickListener sTD;
  private CharSequence uI;
  
  public k(Context paramContext)
  {
    super(paramContext, a.l.foC);
    GMTrace.i(3358261772288L, 25021);
    this.mContext = paramContext;
    if (a.dM(this.mContext)) {}
    for (this.kfJ = View.inflate(this.mContext, a.h.hdZ, null);; this.kfJ = View.inflate(this.mContext, a.h.dir, null))
    {
      this.Fg = ((ListView)this.kfJ.findViewById(a.g.list));
      GMTrace.o(3358261772288L, 25021);
      return;
    }
  }
  
  public final void dismiss()
  {
    GMTrace.i(3358798643200L, 25025);
    try
    {
      super.dismiss();
      GMTrace.o(3358798643200L, 25025);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.MMListDialog", "dismiss exception, e = " + localException.getMessage());
      GMTrace.o(3358798643200L, 25025);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3358395990016L, 25022);
    super.onCreate(paramBundle);
    setContentView(this.kfJ);
    GMTrace.o(3358395990016L, 25022);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    GMTrace.i(3358530207744L, 25023);
    if (paramCharSequence != null)
    {
      this.uI = paramCharSequence;
      GMTrace.o(3358530207744L, 25023);
      return;
    }
    this.uI = null;
    GMTrace.o(3358530207744L, 25023);
  }
  
  public final void show()
  {
    GMTrace.i(3358664425472L, 25024);
    if (this.uI != null) {
      this.uI.length();
    }
    if (this.sTD != null) {
      this.Fg.setOnItemClickListener(this.sTD);
    }
    if (this.khv != null) {
      this.Fg.setAdapter(this.khv);
    }
    super.show();
    GMTrace.o(3358664425472L, 25024);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */