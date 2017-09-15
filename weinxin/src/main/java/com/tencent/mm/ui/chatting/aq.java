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
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;
import java.util.Map;

final class aq
  extends ag.c
{
  private En_5b8fbb1e.a vAn;
  
  public aq()
  {
    super(23);
    GMTrace.i(2179159031808L, 16236);
    GMTrace.o(2179159031808L, 16236);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    GMTrace.i(2179293249536L, 16237);
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = paramView;
      if (((ag.a)paramView.getTag()).type == this.klJ) {}
    }
    else
    {
      localObject = new bi(paramLayoutInflater, R.i.cYe);
      ((View)localObject).setTag(new h(this.klJ).p((View)localObject, false));
    }
    GMTrace.o(2179293249536L, 16237);
    return (View)localObject;
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau, String paramString)
  {
    GMTrace.i(2179427467264L, 16238);
    this.vAn = parama1;
    parama1.aI(paramau);
    h localh = (h)parama;
    Object localObject;
    if (paramau != null)
    {
      parama = paramau.field_content;
      localObject = aj.RC(paramau.field_content);
      if (((aj)localObject).hZO) {
        break label670;
      }
      if (parama == null) {
        break label664;
      }
      paramString = f.a.B(parama, paramau.field_reserved);
      if (paramString == null) {
        break label659;
      }
      parama = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(paramString.hhi);
    }
    for (;;)
    {
      if ((((aj)localObject).fFN != null) && (!((aj)localObject).fFN.equals("-1")) && (parama == null)) {
        parama = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(((aj)localObject).fFN);
      }
      for (;;)
      {
        int i;
        if ((parama != null) && (parama.bNh()))
        {
          localh.vwH.a(parama, paramau.field_msgId);
          paramString = localh.vwH;
          if (paramString.sQc != null) {
            paramString.sQc.resume();
          }
          if (paramau.field_status != 1)
          {
            i = 1;
            paramString = localh.oCh;
            if (i == 0) {
              break label404;
            }
            i = 4;
            label223:
            paramString.setVisibility(i);
            v(parama);
            if (bUg())
            {
              if ((paramau == null) || (paramau.field_status != 2) || (!a(parama1.vzN, paramau.field_msgId))) {
                break label635;
              }
              if (localh.vwJ != null) {
                localh.vwJ.setVisibility(0);
              }
            }
          }
        }
        for (;;)
        {
          localh.vwH.setTag(new ds(paramau, parama1.vvA, paramInt, parama1.vzN.hrv, 0, (byte)0));
          localh.vwH.setOnClickListener(parama1.vzN.vDb);
          localh.vwH.setOnLongClickListener(parama1.vzN.vDd);
          localh.vwH.setOnTouchListener(parama1.vzN.vDf);
          a(paramInt, localh, paramau, parama1.vzN.hrv, parama1.vvA, parama1.vzN.vDb);
          GMTrace.o(2179427467264L, 16238);
          return;
          i = 0;
          break;
          label404:
          i = 0;
          break label223;
          String str = n.GT().v(paramau.field_imgPath, true);
          localObject = n.GX().jI(str);
          if (localObject != null)
          {
            parama = (ag.a)localObject;
            if (!((Bitmap)localObject).isRecycled()) {}
          }
          else
          {
            parama = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
            n.GX().h(str, parama);
          }
          localh.oCh.setVisibility(8);
          localh.vwL.setVisibility(0);
          localh.vwK.setVisibility(8);
          localObject = localh.vwM;
          if (paramString == null) {}
          for (long l = 0L;; l = paramString.hhg)
          {
            ((TextView)localObject).setText(u.ay(l));
            localh.vwM.setVisibility(0);
            localh.vwL.setImageResource(R.g.beJ);
            if (parama != null)
            {
              localObject = parama;
              if (!parama.isRecycled()) {}
            }
            else
            {
              localObject = com.tencent.mm.sdk.platformtools.d.t(this.vAn.getResources().getDrawable(R.g.bcg));
            }
            localh.vwH.setImageBitmap((Bitmap)localObject);
            if ((paramString == null) || (bf.mA(paramString.hhi))) {
              break;
            }
            h.vwN.put(paramString.hhi, new WeakReference(localh));
            break;
          }
          label635:
          if (localh.vwJ != null) {
            localh.vwJ.setVisibility(8);
          }
        }
      }
      label659:
      parama = null;
      continue;
      label664:
      paramString = null;
      break;
      label670:
      parama = null;
      paramString = null;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, au paramau)
  {
    GMTrace.i(2179561684992L, 16239);
    ap.yY();
    int i;
    Object localObject;
    f.a locala;
    if (com.tencent.mm.u.c.isSDCardAvailable())
    {
      i = ((ds)paramView.getTag()).position;
      localObject = aj.RC(paramau.field_content);
      locala = f.a.B(paramau.field_content, paramau.field_reserved);
      if (locala != null) {
        break label524;
      }
      locala = new f.a();
      locala.hhi = ((aj)localObject).fFN;
    }
    label488:
    label500:
    label524:
    for (;;)
    {
      if ((!u.mA(locala.hhi)) && (!locala.hhi.equals("-1")))
      {
        localObject = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(locala.hhi);
        if (localObject == null) {
          break label500;
        }
        if ((((com.tencent.mm.storage.a.c)localObject).field_catalog != com.tencent.mm.storage.a.c.uJj) && (!((com.tencent.mm.storage.a.c)localObject).bNj())) {
          paramContextMenu.add(i, 104, 0, paramView.getContext().getString(R.l.dUq));
        }
        g.oSF.i(12789, new Object[] { Integer.valueOf(0), ((com.tencent.mm.storage.a.c)localObject).EQ(), Integer.valueOf(0), ((com.tencent.mm.storage.a.c)localObject).field_designerID, ((com.tencent.mm.storage.a.c)localObject).field_groupId, "", "", "", "", ((com.tencent.mm.storage.a.c)localObject).field_activityid });
        boolean bool = ((com.tencent.mm.storage.a.c)localObject).bNh();
        if ((((com.tencent.mm.storage.a.c)localObject).field_catalog == com.tencent.mm.storage.a.c.uJj) || (bf.mA(((com.tencent.mm.storage.a.c)localObject).field_groupId)) || ((!bf.mA(((com.tencent.mm.storage.a.c)localObject).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(((com.tencent.mm.storage.a.c)localObject).field_groupId))))
        {
          if (!bool) {
            break label488;
          }
          paramContextMenu.add(i, 113, 0, R.l.eLz);
        }
      }
      for (;;)
      {
        if (paramau.field_status == 5) {
          paramContextMenu.add(i, 103, 0, paramView.getContext().getString(R.l.dVe));
        }
        if ((!paramau.bLN()) && (paramau.bMe()) && ((paramau.field_status == 2) || (paramau.gxz == 1)) && (ao(paramau)) && (Tm(paramau.field_talker))) {
          paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.dUp));
        }
        if (!this.vAn.bVz()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.dUf));
        }
        GMTrace.o(2179561684992L, 16239);
        return true;
        v.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
        continue;
        v.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", new Object[] { locala.hhi });
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2179695902720L, 16240);
    GMTrace.o(2179695902720L, 16240);
    return false;
  }
  
  public final boolean a(View paramView, En_5b8fbb1e.a parama, au paramau)
  {
    GMTrace.i(2179830120448L, 16241);
    GMTrace.o(2179830120448L, 16241);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */