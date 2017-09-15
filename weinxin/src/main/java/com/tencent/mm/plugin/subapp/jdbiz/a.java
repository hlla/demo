package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.jw;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d.a;
import java.util.Map;

public final class a
  implements bp.a
{
  public com.tencent.mm.sdk.b.c qQS;
  
  public a()
  {
    GMTrace.i(5852027158528L, 43601);
    this.qQS = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(5852027158528L, 43601);
  }
  
  public final void a(final d.a parama)
  {
    GMTrace.i(5852161376256L, 43602);
    v.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
    Object localObject = parama.hsc;
    if (localObject == null)
    {
      v.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
      GMTrace.o(5852161376256L, 43602);
      return;
    }
    parama = new b();
    parama.FS(com.tencent.mm.platformtools.n.a(((bu)localObject).tdz));
    v.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bf.ap(parama.qQV, ""));
    if (bf.mA(parama.qQV)) {
      v.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
    }
    for (;;)
    {
      ap.yY();
      com.tencent.mm.u.c.vr().jV(true);
      GMTrace.o(5852161376256L, 43602);
      return;
      if (bf.mA(parama.qQW))
      {
        v.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
      }
      else if (!parama.a(c.bmE().bmJ()))
      {
        v.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
      }
      else if (!c.bmM())
      {
        v.e("MicroMsg.JDSysMsgNotifyLsn", "no entrance, ignore msg");
      }
      else
      {
        if (parama.qQV.equals("3"))
        {
          ((bu)localObject).tdD = null;
          if ((bf.mA(parama.qRg)) || (bf.mA(parama.jumpUrl)) || (bf.mA(parama.qRh)) || (bf.mA(parama.qRi)) || (bf.mA(parama.qRf))) {
            v.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
          }
          for (;;)
          {
            c.b(parama);
            break;
            if (parama.bmx())
            {
              v.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            }
            else
            {
              localObject = c.bmE();
              String str = parama.qQW;
              if (bf.mA(str)) {}
              for (boolean bool = false;; bool = ((c)localObject).qRl.containsKey(str))
              {
                if (!bool) {
                  break label348;
                }
                v.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + parama.qQW);
                break;
              }
              label348:
              if (!parama.a(c.bmE().bmJ()))
              {
                v.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
              }
              else
              {
                localObject = c.bmE();
                str = parama.qQW;
                if (!bf.mA(str)) {
                  ((c)localObject).qRl.put(str, Integer.valueOf(1));
                }
                v.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + parama.qQW);
                new ad(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    GMTrace.i(5851892940800L, 43600);
                    Object localObject = a.this;
                    b localb = parama;
                    ap.yY();
                    int i = ((Integer)com.tencent.mm.u.c.vr().get(15, Integer.valueOf(0))).intValue();
                    if ((ap.vd().foreground) && (1 == i))
                    {
                      localObject = c.bQ(localb.jumpUrl, 5);
                      JDRemindDialog.a(aa.getContext(), localb.qRg, localb.qRh, localb.qRi, (String)localObject, localb.qQW);
                      g.oSF.i(11178, new Object[] { localObject, c.bmE().bmJ().qQW, Integer.valueOf(5) });
                      GMTrace.o(5851892940800L, 43600);
                      return;
                    }
                    String str = c.bQ(localb.jumpUrl, 4);
                    Bundle localBundle = new Bundle();
                    localBundle.putString("activity_id", localb.qQW);
                    localBundle.putString("jump_url", str);
                    ((ai)ap.getNotification()).a(37, aa.getContext().getString(R.l.dIh), localb.qRf, str, "bizjd", localBundle);
                    com.tencent.mm.sdk.b.a.uql.b(((a)localObject).qQS);
                    g.oSF.i(11178, new Object[] { str, c.bmE().bmJ().qQW, Integer.valueOf(4) });
                    GMTrace.o(5851892940800L, 43600);
                  }
                });
              }
            }
          }
        }
        if (parama.qQV.equals("1")) {
          c.b(parama);
        } else if (parama.qQV.equals("2")) {
          c.b(parama);
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/jdbiz/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */