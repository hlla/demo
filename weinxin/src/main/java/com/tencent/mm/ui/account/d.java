package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bg.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.x.b;

@Deprecated
final class d
  extends k<com.tencent.mm.modelfriend.h>
{
  private int[] hAK;
  private String isl;
  a uVS;
  
  public d(Context paramContext, k.a parama)
  {
    super(paramContext, new com.tencent.mm.modelfriend.h());
    GMTrace.i(2577114595328L, 19201);
    this.uQY = parama;
    GMTrace.o(2577114595328L, 19201);
  }
  
  public final void OL()
  {
    GMTrace.i(2577383030784L, 19203);
    i locali = af.Ga();
    String str = this.isl;
    StringBuilder localStringBuilder = new StringBuilder();
    if ((str != null) && (str.length() > 0))
    {
      localStringBuilder.append(" where ( ");
      localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
      localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
      localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
    }
    setCursor(locali.hnp.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
    this.hAK = new int[getCount()];
    if ((this.uVS != null) && (this.isl != null)) {
      this.uVS.zv(getCursor().getCount());
    }
    super.notifyDataSetChanged();
    GMTrace.o(2577383030784L, 19203);
  }
  
  protected final void OM()
  {
    GMTrace.i(2577248813056L, 19202);
    OL();
    GMTrace.o(2577248813056L, 19202);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(2577651466240L, 19205);
    Object localObject = (com.tencent.mm.modelfriend.h)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new b();
      paramView = View.inflate(this.context, R.i.dbT, null);
      paramViewGroup.ioB = ((ImageView)paramView.findViewById(R.h.bGc));
      paramViewGroup.hAR = ((TextView)paramView.findViewById(R.h.ctA));
      paramViewGroup.hAS = ((TextView)paramView.findViewById(R.h.ctu));
      paramViewGroup.uVT = ((TextView)paramView.findViewById(R.h.ctv));
      paramViewGroup.uVU = ((TextView)paramView.findViewById(R.h.cty));
      paramViewGroup.uVV = ((ImageView)paramView.findViewById(R.h.ctD));
      paramView.setTag(paramViewGroup);
      paramViewGroup.hAR.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, ((com.tencent.mm.modelfriend.h)localObject).Fe(), paramViewGroup.hAR.getTextSize()));
      paramViewGroup.uVU.setVisibility(8);
      paramViewGroup.uVV.setVisibility(0);
      switch (this.hAK[paramInt])
      {
      case 1: 
      default: 
        label208:
        localObject = b.gZ(((com.tencent.mm.modelfriend.h)localObject).gkj);
        if (localObject == null) {
          paramViewGroup.ioB.setImageDrawable(a.a(this.context, R.k.ber));
        }
        break;
      }
    }
    for (;;)
    {
      GMTrace.o(2577651466240L, 19205);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      paramViewGroup.uVT.setVisibility(8);
      paramViewGroup.hAS.setVisibility(0);
      paramViewGroup.hAS.setText(R.l.emM);
      paramViewGroup.hAS.setTextColor(this.context.getResources().getColor(R.e.aSG));
      break label208;
      if (((com.tencent.mm.modelfriend.h)localObject).status != 102)
      {
        ap.yY();
        if (!c.wR().QX(((com.tencent.mm.modelfriend.h)localObject).getUsername()))
        {
          paramViewGroup.hAS.setVisibility(8);
          paramViewGroup.uVT.setVisibility(0);
          break label208;
        }
      }
      if (((com.tencent.mm.modelfriend.h)localObject).status == 102)
      {
        paramViewGroup.hAS.setVisibility(8);
        paramViewGroup.uVT.setVisibility(8);
        paramViewGroup.uVV.setVisibility(8);
        break label208;
      }
      paramViewGroup.hAS.setVisibility(0);
      paramViewGroup.hAS.setText(R.l.emJ);
      paramViewGroup.hAS.setTextColor(this.context.getResources().getColor(R.e.aSF));
      paramViewGroup.uVT.setVisibility(8);
      break label208;
      paramViewGroup.ioB.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public final void yB(String paramString)
  {
    GMTrace.i(2577517248512L, 19204);
    this.isl = bf.my(paramString.trim());
    aEP();
    OL();
    GMTrace.o(2577517248512L, 19204);
  }
  
  public static abstract interface a
  {
    public abstract void zv(int paramInt);
  }
  
  static final class b
  {
    TextView hAR;
    TextView hAS;
    ImageView ioB;
    TextView uVT;
    TextView uVU;
    ImageView uVV;
    
    b()
    {
      GMTrace.i(2744215666688L, 20446);
      GMTrace.o(2744215666688L, 20446);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */