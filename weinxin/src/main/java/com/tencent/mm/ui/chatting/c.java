package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

final class c
  extends BaseAdapter
{
  private Context context;
  private com.tencent.mm.ah.a.a.c lgD;
  private List<di> vwo;
  boolean vwp;
  
  public c(Context paramContext)
  {
    GMTrace.i(2109365813248L, 15716);
    this.vwp = false;
    this.context = paramContext;
    this.vwo = new ArrayList();
    paramContext = new c.a();
    paramContext.hII = R.g.bhp;
    this.lgD = paramContext.Hh();
    ao(null);
    GMTrace.o(2109365813248L, 15716);
  }
  
  private di AD(int paramInt)
  {
    GMTrace.i(2109768466432L, 15719);
    di localdi = (di)this.vwo.get(paramInt);
    GMTrace.o(2109768466432L, 15719);
    return localdi;
  }
  
  public final void ao(List<di> paramList)
  {
    GMTrace.i(2109500030976L, 15717);
    this.vwo.clear();
    if ((paramList != null) && (paramList.size() != 0)) {
      this.vwo.addAll(paramList);
    }
    if (this.vwp)
    {
      paramList = this.vwo;
      localdi = new di();
      localdi.roM = R.g.bjt;
      localdi.gMN = this.context.getString(R.l.dVu);
      paramList.add(localdi);
    }
    paramList = this.vwo;
    di localdi = new di();
    localdi.roM = R.g.bjs;
    localdi.gMN = this.context.getString(R.l.eUj);
    paramList.add(localdi);
    v.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[] { Integer.valueOf(this.vwo.size()) });
    GMTrace.o(2109500030976L, 15717);
  }
  
  public final int getCount()
  {
    GMTrace.i(2109634248704L, 15718);
    int i = this.vwo.size();
    GMTrace.o(2109634248704L, 15718);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    GMTrace.i(2109902684160L, 15720);
    long l = paramInt;
    GMTrace.o(2109902684160L, 15720);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(2110036901888L, 15721);
    di localdi = AD(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new eo();
      localObject = View.inflate(paramViewGroup.getContext(), R.i.dnF, null);
      paramView.ljI = ((View)localObject).findViewById(R.h.bGk);
      paramView.kxz = ((TextView)((View)localObject).findViewById(R.h.cmd));
      paramView.jaK = ((ImageView)((View)localObject).findViewById(R.h.bWo));
      paramView.vFx = ((TextView)((View)localObject).findViewById(R.h.cCl));
      paramView.vMK = ((SendDataToDeviceProgressBar)((View)localObject).findViewById(R.h.cCk));
      paramView.vMK.setVisibility(4);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.kxz.setText(localdi.gMN);
      v.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localdi.gMN });
      if (localdi.roM == 0) {
        break label223;
      }
      paramViewGroup.jaK.setImageResource(localdi.roM);
    }
    for (;;)
    {
      paramViewGroup.ljI.setTag(Integer.valueOf(paramInt));
      GMTrace.o(2110036901888L, 15721);
      return paramView;
      paramViewGroup = (eo)paramView.getTag();
      break;
      label223:
      localObject = g.b(localdi.appId, 1, com.tencent.mm.bg.a.getDensity(this.context));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramViewGroup.jaK.setImageBitmap((Bitmap)localObject);
      } else {
        n.GX().a(localdi.iconUrl, paramViewGroup.jaK, this.lgD);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */