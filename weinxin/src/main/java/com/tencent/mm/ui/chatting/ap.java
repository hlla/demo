package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import java.lang.ref.WeakReference;
import java.util.Map;

final class ap
  extends ag.b
{
  private En_5b8fbb1e.a vAn;
  
  public ap()
  {
    super(22);
    GMTrace.i(2385317462016L, 17772);
    GMTrace.o(2385317462016L, 17772);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2385451679744L, 17773);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cXz);
      ((View)localObject).setTag(new h(this.klJ).p((View)localObject, true));
    }
    GMTrace.o(2385451679744L, 17773);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2385585897472L, 17774);
    this.vAn = parama1;
    parama1.aI(paramau);
    h localh = (h)parama;
    parama = null;
    Object localObject1 = paramau.field_content;
    if (localObject1 != null) {}
    for (localObject1 = f.a.B((String)localObject1, paramau.field_reserved);; localObject1 = null)
    {
      Object localObject2 = parama;
      if (localObject1 != null)
      {
        localObject2 = parama;
        if (((f.a)localObject1).hhi != null) {
          localObject2 = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(((f.a)localObject1).hhi);
        }
      }
      long l;
      if ((localObject2 == null) || (!((com.tencent.mm.storage.a.c)localObject2).bNh()))
      {
        String str = n.GT().v(paramau.field_imgPath, true);
        Bitmap localBitmap = n.GX().jI(str);
        if (localBitmap != null)
        {
          parama = localBitmap;
          if (!localBitmap.isRecycled()) {}
        }
        else
        {
          parama = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
          n.GX().h(str, parama);
        }
        if (localObject2 == null)
        {
          localh.vwL.setVisibility(0);
          localh.vwK.setVisibility(8);
          localObject2 = localh.vwM;
          if (localObject1 == null)
          {
            l = 0L;
            ((TextView)localObject2).setText(u.ay(l));
            localh.vwM.setVisibility(0);
            localh.vwL.setImageResource(R.g.beJ);
            label234:
            if ((localObject1 != null) && (!bf.mA(((f.a)localObject1).hhi))) {
              h.vwN.put(((f.a)localObject1).hhi, new WeakReference(localh));
            }
            if ((parama != null) && (!parama.isRecycled())) {
              break label607;
            }
            parama = com.tencent.mm.sdk.platformtools.d.t(this.vAn.getResources().getDrawable(R.g.bcg));
          }
        }
      }
      label607:
      for (;;)
      {
        localh.vwH.setImageBitmap(parama);
        for (;;)
        {
          localh.vwH.setTag(new ds(paramau, parama1.vvA, paramInt, paramString, 0, (byte)0));
          localh.vwH.setOnClickListener(parama1.vzN.vDb);
          localh.vwH.setOnLongClickListener(parama1.vzN.vDd);
          localh.vwH.setOnTouchListener(parama1.vzN.vDf);
          localh.vwL.setOnClickListener(parama1.vzN.vDb);
          localh.vwL.setOnClickListener(parama1.vzN.vDb);
          localh.vwL.setOnLongClickListener(parama1.vzN.vDd);
          localh.vwL.setTag(localh.vwH.getTag());
          GMTrace.o(2385585897472L, 17774);
          return;
          l = ((f.a)localObject1).hhg;
          break;
          localh.vwK.setVisibility(0);
          localh.vwM.setVisibility(8);
          localh.vwL.setVisibility(8);
          localh.vwK.setProgress(0);
          localh.vwM.setVisibility(8);
          break label234;
          localh.vwH.a((com.tencent.mm.storage.a.c)localObject2, paramau.field_msgId);
          localh.vwL.setVisibility(8);
          localh.vwK.setVisibility(8);
          localh.vwM.setVisibility(8);
          localh.vwL.setVisibility(8);
          if ((localObject1 != null) && (!bf.mA(((f.a)localObject1).hhi))) {
            h.vwN.remove(((f.a)localObject1).hhi);
          }
          v((com.tencent.mm.storage.a.c)localObject2);
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2385854332928L, 17776);
    int i = ((ds)paramView.getTag()).position;
    aj localaj = aj.RC(paramau.field_content);
    paramau = f.a.B(paramau.field_content, paramau.field_reserved);
    if (paramau == null)
    {
      paramau = new f.a();
      paramau.hhi = localaj.fFN;
    }
    for (;;)
    {
      if ((!u.mA(paramau.hhi)) && (!paramau.hhi.equals("-1")))
      {
        paramau = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramau.hhi);
        if (paramau != null)
        {
          if ((paramau.field_catalog != com.tencent.mm.storage.a.c.uJj) && (!paramau.bNj())) {
            paramContextMenu.add(i, 104, 0, paramView.getContext().getString(R.l.dUq));
          }
          if (paramau != null) {
            g.oSF.i(12789, new Object[] { Integer.valueOf(0), paramau.EQ(), Integer.valueOf(0), paramau.field_designerID, paramau.field_groupId, "", "", "", "", paramau.field_activityid });
          }
          boolean bool = paramau.bNh();
          if ((paramau.field_catalog == com.tencent.mm.storage.a.c.uJj) || (bf.mA(paramau.field_groupId)) || ((!bf.mA(paramau.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(paramau.field_groupId))))
          {
            if (!bool) {
              break label364;
            }
            paramContextMenu.add(i, 113, 0, R.l.eLz);
          }
        }
      }
      for (;;)
      {
        if (!this.vAn.bVz()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUf));
        }
        GMTrace.o(2385854332928L, 17776);
        return true;
        label364:
        v.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2385988550656L, 17777);
    GMTrace.o(2385988550656L, 17777);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2386122768384L, 17778);
    GMTrace.o(2386122768384L, 17778);
    return false;
  }
  
  protected final boolean a(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2385720115200L, 17775);
    boolean bool = parama.vvA;
    GMTrace.o(2385720115200L, 17775);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */