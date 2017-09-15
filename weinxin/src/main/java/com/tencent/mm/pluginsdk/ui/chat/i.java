package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.x;
import java.util.ArrayList;

public final class i
{
  Bitmap bitmap;
  Context context;
  ImageView fMP;
  SharedPreferences hgn;
  private View ipa;
  View neg;
  View qkq;
  private h sOI;
  public g sOJ;
  public o sOK;
  boolean sOL;
  h.a sOM;
  public a sON;
  
  public i(Context paramContext, View paramView1, View paramView2, a parama)
  {
    GMTrace.i(1019249426432L, 7594);
    this.ipa = null;
    this.fMP = null;
    this.bitmap = null;
    this.sOL = true;
    this.context = paramContext;
    this.qkq = paramView1;
    this.neg = paramView2;
    this.sOI = new h(this.context);
    this.hgn = paramContext.getSharedPreferences(aa.bIN(), 0);
    this.sON = parama;
    this.ipa = View.inflate(this.context, R.i.cXm, null);
    this.fMP = ((ImageView)this.ipa.findViewById(R.h.cvX));
    this.sOK = new o(this.ipa, -2, -2, true);
    this.sOK.setBackgroundDrawable(new ColorDrawable(0));
    this.sOK.setOutsideTouchable(true);
    this.ipa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(993882275840L, 7405);
        if ((i.this.sON != null) && (i.this.sOJ != null)) {
          i.this.sON.MZ(i.this.sOJ.sOH);
        }
        i.this.sOK.dismiss();
        GMTrace.o(993882275840L, 7405);
      }
    });
    GMTrace.o(1019249426432L, 7594);
  }
  
  public final String bFU()
  {
    for (;;)
    {
      try
      {
        GMTrace.i(1019383644160L, 7595);
        if (this.sOI == null)
        {
          v.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
          localObject1 = null;
          this.sOJ = ((g)localObject1);
          if (this.sOJ == null)
          {
            GMTrace.o(1019383644160L, 7595);
            localObject1 = null;
            return (String)localObject1;
          }
        }
        else
        {
          localObject1 = this.sOI.bFT();
          if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
          {
            v.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
            localObject1 = null;
            continue;
          }
          g localg = (g)((ArrayList)localObject1).get(0);
          if (localg != null)
          {
            if (bf.az(localg.mcU) >= 0L) {
              break label313;
            }
            i = 1;
            if (i != 0)
            {
              v.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", new Object[] { localg.sOH });
              localObject1 = null;
              continue;
            }
          }
          if ((localg != null) && (localg.sOH != null) && (localg.sOH.contains(e.hgj)))
          {
            localObject1 = null;
            continue;
          }
          if (localg != null)
          {
            if (bf.az(localg.mcU) > 30L) {
              break label318;
            }
            i = 1;
            if (i != 0)
            {
              localObject1 = localg;
              if (!this.hgn.getString("chattingui_recent_shown_image_path", "").equals(localg.sOH)) {
                continue;
              }
              v.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
              localObject1 = null;
              continue;
            }
          }
          if (localg != null) {
            break label323;
          }
          bool = true;
          v.d("MicroMsg.RecentImageBubble", "because of checkAddDate(addDate) == false, or imageItem == null : %s", new Object[] { Boolean.valueOf(bool) });
          localObject1 = null;
          continue;
        }
        Object localObject1 = this.sOJ.fKq;
        if (this.sOJ.fKq == null) {
          localObject1 = this.sOJ.sOH;
        }
        GMTrace.o(1019383644160L, 7595);
        continue;
        i = 0;
      }
      finally {}
      label313:
      continue;
      label318:
      int i = 0;
      continue;
      label323:
      boolean bool = false;
    }
  }
  
  final float xD(int paramInt)
  {
    GMTrace.i(1019517861888L, 7596);
    float f = TypedValue.applyDimension(1, paramInt, this.context.getResources().getDisplayMetrics());
    GMTrace.o(1019517861888L, 7596);
    return f;
  }
  
  public static abstract interface a
  {
    public abstract void MZ(String paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/chat/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */