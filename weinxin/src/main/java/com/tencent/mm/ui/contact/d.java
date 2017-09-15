package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.k;
import java.util.List;

public final class d
  extends k<x>
{
  protected MMActivity fBZ;
  com.tencent.mm.ui.applet.b hAM;
  private b.b hAN;
  protected MMSlideDelView.f jUm;
  protected MMSlideDelView.c jUn;
  protected MMSlideDelView.d jUp;
  protected List<String> jzO;
  protected MMSlideDelView.e nVv;
  com.tencent.mm.pluginsdk.ui.d sLl;
  protected String vSQ;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext, new x());
    GMTrace.i(1830864027648L, 13641);
    this.vSQ = null;
    this.jzO = null;
    this.jUp = MMSlideDelView.bSe();
    this.hAM = null;
    this.hAN = null;
    this.fBZ = ((MMActivity)paramContext);
    this.vSQ = paramString;
    this.hAM = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap jg(String paramAnonymousString)
      {
        GMTrace.i(1813818376192L, 13514);
        paramAnonymousString = com.tencent.mm.x.b.a(paramAnonymousString, false, -1);
        GMTrace.o(1813818376192L, 13514);
        return paramAnonymousString;
      }
    });
    GMTrace.o(1830864027648L, 13641);
  }
  
  private String W(x paramx)
  {
    GMTrace.i(1832071987200L, 13650);
    if (paramx.field_showHead == 31)
    {
      GMTrace.o(1832071987200L, 13650);
      return "";
    }
    if (paramx.field_showHead == 43)
    {
      paramx = this.fBZ.getString(R.l.eMt);
      GMTrace.o(1832071987200L, 13650);
      return paramx;
    }
    char c = (char)paramx.field_showHead;
    GMTrace.o(1832071987200L, 13650);
    return String.valueOf(c);
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    GMTrace.i(1831937769472L, 13649);
    x localx = (x)getItem(paramInt1 + 1);
    if ((localx == null) || ((localx.field_showHead != paramInt2) && (!u.mA(W(localx))))) {
      parama.vUy.setBackgroundResource(0);
    }
    GMTrace.o(1831937769472L, 13649);
  }
  
  public final void OL()
  {
    try
    {
      GMTrace.i(1831669334016L, 13647);
      ap.yY();
      Cursor localCursor = c.wR().c(this.vSQ, "", this.jzO);
      aEP();
      setCursor(localCursor);
      notifyDataSetChanged();
      GMTrace.o(1831669334016L, 13647);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected final void OM()
  {
    GMTrace.i(1831535116288L, 13646);
    OL();
    GMTrace.o(1831535116288L, 13646);
  }
  
  public final void a(MMSlideDelView.c paramc)
  {
    GMTrace.i(1831266680832L, 13644);
    this.jUn = paramc;
    GMTrace.o(1831266680832L, 13644);
  }
  
  public final void a(MMSlideDelView.e parame)
  {
    GMTrace.i(1831132463104L, 13643);
    this.nVv = parame;
    GMTrace.o(1831132463104L, 13643);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    GMTrace.i(1830998245376L, 13642);
    this.jUm = paramf;
    GMTrace.o(1830998245376L, 13642);
  }
  
  public final int getCount()
  {
    GMTrace.i(1831400898560L, 13645);
    int i = getCursor().getCount();
    GMTrace.o(1831400898560L, 13645);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(1831803551744L, 13648);
    if (this.hAN == null) {
      this.hAN = new b.b()
      {
        public final int Fi()
        {
          GMTrace.i(1749125431296L, 13032);
          int i = d.this.getCount();
          GMTrace.o(1749125431296L, 13032);
          return i;
        }
        
        public final String fE(int paramAnonymousInt)
        {
          GMTrace.i(1748991213568L, 13031);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= d.this.getCount()))
          {
            v.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
            GMTrace.o(1748991213568L, 13031);
            return null;
          }
          Object localObject = (x)d.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            GMTrace.o(1748991213568L, 13031);
            return null;
          }
          localObject = ((af)localObject).field_username;
          GMTrace.o(1748991213568L, 13031);
          return (String)localObject;
        }
      };
    }
    if (this.hAM != null) {
      this.hAM.a(paramInt, this.hAN);
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.fBZ, R.i.cWZ, null);
      paramViewGroup = new a();
      paramViewGroup.mRQ = ((TextView)paramView.findViewById(R.h.bGd));
      paramViewGroup.kvj = ((MaskLayout)paramView.findViewById(R.h.bGb));
      paramViewGroup.jXN = ((TextView)paramView.findViewById(R.h.bGf));
      paramViewGroup.vUy = ((ViewGroup)paramView.findViewById(R.h.bGe));
      localObject1 = paramViewGroup.vUy.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.bg.a.U(this.fBZ, R.f.aWL) * com.tencent.mm.bg.a.dL(this.fBZ)));
      paramViewGroup.vUy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (x)getItem(paramInt - 1);
      int i;
      label195:
      Object localObject2;
      if (localObject1 == null)
      {
        i = -1;
        localObject1 = (x)getItem(paramInt);
        if (paramInt != 0) {
          break label466;
        }
        localObject2 = W((x)localObject1);
        if (!u.mA((String)localObject2)) {
          break label435;
        }
        v.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((af)localObject1).field_username, Integer.valueOf(paramInt) });
        paramViewGroup.mRQ.setVisibility(8);
        label262:
        if (getItem(paramInt + 1) == null) {
          paramViewGroup.vUy.setBackgroundResource(0);
        }
        label280:
        localObject2 = paramViewGroup.jXN;
        MMActivity localMMActivity = this.fBZ;
        if (o.fE(((af)localObject1).field_username)) {
          break label639;
        }
        paramInt = R.e.aVa;
        ((TextView)localObject2).setTextColor(com.tencent.mm.bg.a.S(localMMActivity, paramInt));
        localObject2 = (ImageView)paramViewGroup.kvj.view;
        a.b.a((ImageView)localObject2, ((af)localObject1).field_username);
        localObject2 = (com.tencent.mm.pluginsdk.ui.a)((ImageView)localObject2).getDrawable();
        if (this.sLl != null) {
          this.sLl.a((com.tencent.mm.pluginsdk.ui.d.a)localObject2);
        }
        paramViewGroup.kvj.bSx();
      }
      try
      {
        paramViewGroup.jXN.setText(h.c(this.fBZ, n.eK(((af)localObject1).field_username), (int)paramViewGroup.jXN.getTextSize()));
        GMTrace.o(1831803551744L, 13648);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        continue;
        i = ((af)localObject1).field_showHead;
        break label195;
        label435:
        paramViewGroup.mRQ.setVisibility(0);
        paramViewGroup.mRQ.setText((CharSequence)localObject2);
        paramViewGroup.mRQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        break label262;
        label466:
        if ((paramInt > 0) && (((af)localObject1).field_showHead != i))
        {
          localObject2 = W((x)localObject1);
          paramViewGroup.vUy.setBackgroundResource(R.g.ben);
          if (u.mA((String)localObject2))
          {
            v.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((af)localObject1).field_username, Integer.valueOf(paramInt) });
            paramViewGroup.mRQ.setVisibility(8);
          }
          for (;;)
          {
            a(paramViewGroup, paramInt, i);
            break;
            paramViewGroup.mRQ.setVisibility(0);
            paramViewGroup.mRQ.setText((CharSequence)localObject2);
            if (((af)localObject1).field_showHead == 32)
            {
              paramViewGroup.mRQ.setCompoundDrawablesWithIntrinsicBounds(R.g.bgW, 0, 0, 0);
              paramViewGroup.mRQ.setCompoundDrawablePadding(2);
            }
            else
            {
              paramViewGroup.mRQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
          }
        }
        paramViewGroup.mRQ.setVisibility(8);
        a(paramViewGroup, paramInt, i);
        break label280;
        label639:
        paramInt = R.e.aVb;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramViewGroup.jXN.setText("");
        }
      }
    }
  }
  
  protected static final class a
  {
    public TextView jXN;
    public MaskLayout kvj;
    public TextView mRQ;
    public ViewGroup vUy;
    
    public a()
    {
      GMTrace.i(1746441076736L, 13012);
      GMTrace.o(1746441076736L, 13012);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */