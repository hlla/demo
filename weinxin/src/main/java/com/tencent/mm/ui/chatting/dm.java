package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.view.ViewStub;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.bi.f.a;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.k.a.b.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.y.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class dm
{
  public List<au> kbK;
  ad mHandler;
  ChattingAnimFrame vGi;
  public Activity vGj;
  
  public dm()
  {
    GMTrace.i(2256334225408L, 16811);
    this.vGi = null;
    this.mHandler = new ad(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(2305860567040L, 17180);
        if ((dm.this.kbK == null) || (!ap.zb()))
        {
          GMTrace.o(2305860567040L, 17180);
          return;
        }
        v.d("MicroMsg.EggMgr", "post start egg");
        dm.this.a(dm.this.vGj, dm.this.kbK);
        GMTrace.o(2305860567040L, 17180);
      }
    };
    GMTrace.o(2256334225408L, 16811);
  }
  
  private static boolean ad(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(2256602660864L, 16813);
    if ((com.tencent.mm.platformtools.u.mA(paramString1)) || (com.tencent.mm.platformtools.u.mA(paramString2)) || (aa.getContext() == null))
    {
      GMTrace.o(2256602660864L, 16813);
      return false;
    }
    String str = paramString1.toLowerCase();
    j = str.indexOf(paramString2.toLowerCase());
    int i = j;
    if (j == -1)
    {
      GMTrace.o(2256602660864L, 16813);
      return false;
    }
    do
    {
      for (;;)
      {
        try
        {
          if ((i >= str.length() - 1) || (com.tencent.mm.platformtools.u.mA(paramString3))) {
            continue;
          }
          if ((i <= 0) || (str.charAt(i - 1) < 'a') || (str.charAt(i - 1) > 'z')) {
            continue;
          }
          v.v("MicroMsg.EggMgr", "letter in the prefix");
          localObject = paramString1.substring(0, i);
          int k = ((String)localObject).lastIndexOf('/');
          j = k;
          if (k == -1) {
            continue;
          }
          localObject = ((String)localObject).subSequence(k, ((String)localObject).length());
          com.tencent.mm.bi.g.bKx();
          localObject = com.tencent.mm.bi.f.bKu().Qy((String)localObject);
          if (localObject == null) {
            continue;
          }
          localObject = ((f.a)localObject).text;
          j = k;
          if (com.tencent.mm.platformtools.u.mA((String)localObject)) {
            continue;
          }
          j = k;
          if (((String)localObject).length() + k != i) {
            continue;
          }
          j = -2;
          v.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
        }
        catch (Exception paramString1)
        {
          Object localObject;
          v.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", new Object[] { paramString1.getMessage() });
          v.printErrStackTrace("MicroMsg.EggMgr", paramString1, "", new Object[0]);
          continue;
          boolean bool1 = true;
          continue;
          boolean bool2 = true;
          continue;
          if (j == -2) {
            continue;
          }
          bool1 = false;
          continue;
        }
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (paramString2.length() + i < str.length())
          {
            bool2 = bool1;
            if (str.charAt(paramString2.length() + i) >= 'a')
            {
              bool2 = bool1;
              if (str.charAt(paramString2.length() + i) <= 'z')
              {
                v.v("MicroMsg.EggMgr", "letter in the suffix");
                bool2 = false;
              }
            }
          }
        }
        if (!bool2) {
          continue;
        }
        v.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", new Object[] { Integer.valueOf(i), Integer.valueOf(str.length()), Integer.valueOf(paramString2.length()) });
        GMTrace.o(2256602660864L, 16813);
        return bool2;
        localObject = null;
      }
      j = str.indexOf(paramString2.toLowerCase(), i + 1);
      i = j;
    } while (j != -1);
    GMTrace.o(2256602660864L, 16813);
    return false;
  }
  
  private static void aj(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2256736878592L, 16814);
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new StringBuilder();
        ap.yY();
        localObject1 = com.tencent.mm.a.e.d(com.tencent.mm.u.c.xu() + "eggresult.rep", 0, -1);
        com.tencent.mm.ap.g localg;
        if (localObject1 != null)
        {
          v.d("MicroMsg.EggMgr", "data not null, parse it");
          localObject1 = (com.tencent.mm.ap.h)new com.tencent.mm.ap.h().aD((byte[])localObject1);
          localObject2 = ((com.tencent.mm.ap.h)localObject1).hNQ.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label320;
          }
          localg = (com.tencent.mm.ap.g)((Iterator)localObject2).next();
          if (localg.hND != paramInt) {
            continue;
          }
          if (paramBoolean)
          {
            localg.hNO += 1;
            break label325;
            if (i == 0)
            {
              localObject2 = new com.tencent.mm.ap.g();
              ((com.tencent.mm.ap.g)localObject2).hND = paramInt;
              if (!paramBoolean) {
                break label311;
              }
              ((com.tencent.mm.ap.g)localObject2).hNO = 1;
              ((com.tencent.mm.ap.h)localObject1).hNQ.add(localObject2);
            }
            localObject2 = ((com.tencent.mm.ap.h)localObject1).toByteArray();
            v.d("MicroMsg.EggMgr", "report list is %s, then save it", new Object[] { localObject1.toString() });
            localObject1 = new StringBuilder();
            ap.yY();
            com.tencent.mm.a.e.b(com.tencent.mm.u.c.xu() + "eggresult.rep", (byte[])localObject2, localObject2.length);
            GMTrace.o(2256736878592L, 16814);
          }
        }
        else
        {
          v.d("MicroMsg.EggMgr", "data is null, new one");
          localObject1 = new com.tencent.mm.ap.h();
          continue;
        }
        localg.hNP += 1;
      }
      catch (Exception localException)
      {
        v.w("MicroMsg.EggMgr", "statistics crash : %s", new Object[] { localException.getLocalizedMessage() });
        v.printErrStackTrace("MicroMsg.EggMgr", localException, "", new Object[0]);
        GMTrace.o(2256736878592L, 16814);
        return;
      }
      label311:
      ((com.tencent.mm.ap.g)localObject2).hNP = 1;
      continue;
      label320:
      int i = 0;
      continue;
      label325:
      i = 1;
    }
  }
  
  public final void a(Activity paramActivity, List<au> paramList)
  {
    GMTrace.i(2256468443136L, 16812);
    if (paramList == null)
    {
      GMTrace.o(2256468443136L, 16812);
      return;
    }
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      au localau = (au)localIterator1.next();
      ap.yY();
      if (com.tencent.mm.platformtools.u.az(com.tencent.mm.platformtools.u.d((Long)com.tencent.mm.u.c.vr().get(68108, null))) * 1000L > 21600000L) {
        new ad().postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2295257366528L, 17101);
            if (!ap.zb())
            {
              GMTrace.o(2295257366528L, 17101);
              return;
            }
            m localm = new m(37);
            ap.vd().a(localm, 0);
            ap.yY();
            com.tencent.mm.u.c.vr().set(68108, Long.valueOf(com.tencent.mm.platformtools.u.Nz()));
            GMTrace.o(2295257366528L, 17101);
          }
        }, 10000L);
      }
      paramList = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().alA();
      int i;
      if (paramList == null)
      {
        v.d("MicroMsg.EggMgr", "eggList is null");
        i = 0;
      }
      while (i != 0)
      {
        GMTrace.o(2256468443136L, 16812);
        return;
        int m = (int)bf.Nz();
        v.d("MicroMsg.EggMgr", "cursecond is %d, getEggList.size is %d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramList.hNM.size()) });
        Iterator localIterator2 = paramList.hNM.iterator();
        for (;;)
        {
          if (localIterator2.hasNext())
          {
            com.tencent.mm.ap.d locald = (com.tencent.mm.ap.d)localIterator2.next();
            paramList = locald.hNG;
            int k = 0;
            label245:
            Iterator localIterator3;
            if (com.tencent.mm.platformtools.u.mA(paramList))
            {
              i = 1;
              if (i == 0) {
                break label348;
              }
              localIterator3 = locald.hNB.iterator();
            }
            String str2;
            for (;;)
            {
              if (!localIterator3.hasNext()) {
                break label477;
              }
              com.tencent.mm.ap.e locale = (com.tencent.mm.ap.e)localIterator3.next();
              str2 = locale.hNL;
              if (com.tencent.mm.platformtools.u.mA(str2))
              {
                v.e("MicroMsg.EggMgr", "error egg keyWord");
                continue;
                paramList = paramList.split(",");
                int n = paramList.length;
                int j = 0;
                for (;;)
                {
                  i = k;
                  if (j >= n) {
                    break label245;
                  }
                  if (paramList[j].equals(com.tencent.mm.sdk.platformtools.u.bID()))
                  {
                    i = 1;
                    break label245;
                    label348:
                    break;
                  }
                  j += 1;
                }
              }
              else
              {
                String str1 = localau.field_content;
                paramList = str1;
                if (o.dH(localau.field_talker))
                {
                  i = ay.gh(str1);
                  paramList = str1;
                  if (i != -1) {
                    paramList = str1.substring(i + 1).trim();
                  }
                }
                if (ad(paramList, str2, locale.lang))
                {
                  if (this.vGi == null)
                  {
                    paramList = (ViewStub)paramActivity.findViewById(R.h.cMs);
                    if (paramList != null) {
                      paramList.inflate();
                    }
                    this.vGi = ((ChattingAnimFrame)paramActivity.findViewById(R.h.bzf));
                  }
                  if (this.vGi != null) {
                    break label479;
                  }
                  v.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
                }
              }
            }
            label477:
            continue;
            label479:
            boolean bool;
            if ((locald.hNE <= m) && (m <= locald.hNF + 86400L))
            {
              this.vGi.a(locald);
              i = locald.hND;
              if (localau.field_isSend == 1) {}
              for (bool = true;; bool = false)
              {
                aj(i, bool);
                v.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", new Object[] { str2, Integer.valueOf(locald.hNE), Integer.valueOf(locald.hNF) });
                i = 1;
                break;
              }
            }
            if ((locald.hNE == locald.hNF) && (locald.hNE == 0))
            {
              this.vGi.a(locald);
              i = locald.hND;
              if (localau.field_isSend == 1) {}
              for (bool = true;; bool = false)
              {
                aj(i, bool);
                v.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", new Object[] { str2 });
                i = 1;
                break;
              }
            }
            v.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", new Object[] { str2, Integer.valueOf(locald.hNE), Integer.valueOf(locald.hNF) });
            i = 0;
            break;
          }
        }
        v.d("MicroMsg.EggMgr", "no match");
        i = 0;
      }
    }
    GMTrace.o(2256468443136L, 16812);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */