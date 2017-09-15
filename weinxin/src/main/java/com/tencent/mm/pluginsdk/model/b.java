package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.av.i;
import com.tencent.mm.av.l;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;

public final class b
  implements com.tencent.mm.y.d
{
  public b()
  {
    GMTrace.i(761417170944L, 5673);
    GMTrace.o(761417170944L, 5673);
  }
  
  public final d.b b(d.a parama)
  {
    GMTrace.i(761551388672L, 5674);
    bu localbu = parama.hsc;
    if ((localbu == null) || (localbu.mrC != 47))
    {
      v.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
      GMTrace.o(761551388672L, 5674);
      return null;
    }
    Object localObject1 = n.a(localbu.tdx);
    Object localObject2 = n.a(localbu.tdy);
    ap.yY();
    if (((String)com.tencent.mm.u.c.vr().get(2, null)).equals(localObject1))
    {
      localObject1 = localObject2;
      localObject2 = n.a(localbu.tdz);
      ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a((String)localObject1, (String)localObject2, localbu.tdE, localbu.tdC, parama);
      localObject1 = ay.gm(localbu.tdC);
      if (localObject1 != null)
      {
        v.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", new Object[] { ((ay.b)localObject1).hmx });
        if ((((ay.b)localObject1).hmz != null) && (((ay.b)localObject1).scene == 1))
        {
          parama = n.a(localbu.tdx);
          ap.yY();
          com.tencent.mm.u.c.vr().set(73729, Integer.valueOf(1));
          localObject2 = new com.tencent.mm.av.h();
          ((com.tencent.mm.av.h)localObject2).field_content = aa.getContext().getString(R.l.eDa);
          ((com.tencent.mm.av.h)localObject2).field_createtime = bf.Nz();
          ((com.tencent.mm.av.h)localObject2).field_imgpath = "";
          ((com.tencent.mm.av.h)localObject2).field_sayhicontent = ((com.tencent.mm.av.h)localObject2).field_content;
          ((com.tencent.mm.av.h)localObject2).field_sayhiuser = parama;
          ((com.tencent.mm.av.h)localObject2).field_scene = 18;
          if (localbu.jLP <= 3) {
            break label382;
          }
        }
      }
    }
    label382:
    for (int i = localbu.jLP;; i = 3)
    {
      ((com.tencent.mm.av.h)localObject2).field_status = i;
      ((com.tencent.mm.av.h)localObject2).field_svrid = localbu.tdE;
      ((com.tencent.mm.av.h)localObject2).field_talker = parama;
      ((com.tencent.mm.av.h)localObject2).field_type = localbu.mrC;
      ((com.tencent.mm.av.h)localObject2).field_isSend = 0;
      ((com.tencent.mm.av.h)localObject2).field_sayhiencryptuser = parama;
      ((com.tencent.mm.av.h)localObject2).field_ticket = ((ay.b)localObject1).hmz;
      l.KA().a((com.tencent.mm.av.h)localObject2);
      localObject1 = new ig();
      ((ig)localObject1).fNG.fNH = parama;
      a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      GMTrace.o(761551388672L, 5674);
      return null;
      break;
    }
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(761685606400L, 5675);
    GMTrace.o(761685606400L, 5675);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */