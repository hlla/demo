package com.tencent.mm.f;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.ah.a;
import com.tencent.mm.e.a.qu;
import com.tencent.mm.e.a.qu.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  public a gMr;
  public Map<Integer, Long> gMs;
  public Map<Long, a> gMt;
  public c gMu;
  
  public b()
  {
    GMTrace.i(1272384061440L, 9480);
    this.gMs = new HashMap();
    this.gMt = new HashMap();
    this.gMu = new c() {};
    GMTrace.o(1272384061440L, 9480);
  }
  
  public final boolean a(ah paramah)
  {
    GMTrace.i(1272518279168L, 9481);
    String str = paramah.fDo.fDq;
    if (str == null) {}
    Map localMap;
    for (int i = -1;; i = str.length())
    {
      v.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster xml len[%d]", new Object[] { Integer.valueOf(i) });
      localMap = bg.q(str, "e");
      if (localMap != null) {
        break;
      }
      v.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
      GMTrace.o(1272518279168L, 9481);
      return false;
    }
    v.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", new Object[] { localMap });
    long l1 = bf.getLong((String)localMap.get(".e.NoticeId"), 0L);
    if (l1 <= 0L) {
      v.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
    }
    if (!r.ijC) {
      try
      {
        long l2 = bf.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bf.az(l2) > 0L)
        {
          v.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l2) });
          GMTrace.o(1272518279168L, 9481);
          return false;
        }
      }
      catch (Exception localException)
      {
        v.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { localException });
      }
    }
    Object localObject1 = new a();
    ((a)localObject1).gMy = String.valueOf(l1);
    Object localObject2 = aa.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", "");
    if ((!r.ijD) && (((String)localObject2).contains(((a)localObject1).gMy)))
    {
      v.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[] { localObject2, ((a)localObject1).gMy });
      GMTrace.o(1272518279168L, 9481);
      return false;
    }
    Object localObject4;
    if (this.gMt.size() > 0)
    {
      localObject4 = (a)this.gMt.get(Long.valueOf(l1));
      if (localObject4 != null) {
        v.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", new Object[] { localObject4 });
      }
    }
    for (;;)
    {
      localObject1 = (String)localMap.get(".e.Position");
      if (!bf.mA((String)localObject1)) {
        break;
      }
      v.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
      GMTrace.o(1272518279168L, 9481);
      return false;
      this.gMt.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
      continue;
      this.gMt.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
    }
    Object localObject8 = new ArrayList();
    localObject1 = ((String)localObject1).split(",");
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      v.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
      GMTrace.o(1272518279168L, 9481);
      return false;
    }
    i = 0;
    int k = localObject1.length;
    int j = 0;
    if (j < k)
    {
      int m = bf.getInt(localObject1[j], 0);
      if (m > 0) {
        if (m == 1)
        {
          i = 1;
          v.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", new Object[] { Integer.valueOf(m) });
        }
      }
      for (;;)
      {
        j += 1;
        break;
        ((ArrayList)localObject8).add(Integer.valueOf(m));
      }
    }
    if ((i == 0) && (((ArrayList)localObject8).size() == 0))
    {
      v.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
      GMTrace.o(1272518279168L, 9481);
      return false;
    }
    Object localObject6 = u.ea(aa.getContext());
    v.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", new Object[] { localObject6 });
    Object localObject3 = null;
    localObject2 = null;
    localObject1 = null;
    j = 0;
    Object localObject7 = new StringBuilder(".e.Item");
    if (j == 0)
    {
      localObject5 = "";
      label656:
      localObject5 = localObject5;
      localObject7 = (String)localMap.get((String)localObject5 + ".Language");
      if ((localObject7 == null) && (j > 3)) {
        break label1768;
      }
      if (!((String)localObject6).equalsIgnoreCase((String)localObject7)) {
        break label1062;
      }
      localObject7 = (String)localMap.get((String)localObject5 + ".Content");
      localObject6 = (String)localMap.get((String)localObject5 + ".Url");
    }
    for (final Object localObject5 = (String)localMap.get((String)localObject5 + ".Tips");; localObject5 = null)
    {
      v.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", new Object[] { localObject7, localObject5 });
      if (bf.mA((String)localObject7))
      {
        v.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
        label856:
        localObject6 = localObject2;
        if (bf.mA((String)localObject2)) {
          localObject6 = aa.getContext().getString(R.l.eby);
        }
        localObject5 = localObject1;
        localObject2 = localObject3;
        if (i != 0)
        {
          localObject2 = localObject3;
          if (bf.mA((String)localObject3)) {
            localObject2 = aa.getContext().getString(R.l.ebt);
          }
          localObject5 = localObject1;
          if (bf.mA((String)localObject1)) {
            localObject5 = aa.getContext().getString(R.l.ebw);
          }
          paramah.fDp.desc = ((String)localObject2);
          paramah.fDp.fDr = 30;
          paramah.fDp.showType = 0;
          paramah.fDp.url = ((String)localObject6);
          paramah.fDp.visible = true;
          paramah.fDp.fDu = 0;
          paramah.fDp.fDs = 6;
          paramah.fDp.fDt = "";
          paramah.fDp.fDv = String.valueOf(l1);
          paramah.fDp.position = 1;
        }
        if (((ArrayList)localObject8).size() == 0)
        {
          v.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
          GMTrace.o(1272518279168L, 9481);
          return false;
          localObject5 = Integer.valueOf(j);
          break label656;
          label1062:
          if (!"en".equalsIgnoreCase((String)localObject7)) {
            break label1753;
          }
          localObject2 = (String)localMap.get((String)localObject5 + ".Content");
          localObject3 = (String)localMap.get((String)localObject5 + ".Url");
          localObject1 = (String)localMap.get((String)localObject5 + ".Tips");
        }
      }
      for (;;)
      {
        localObject5 = localObject2;
        j += 1;
        localObject2 = localObject3;
        localObject3 = localObject5;
        break;
        if ((((a)localObject4).gMz != 0L) && (bf.aB(((a)localObject4).gMz) < 1800000L))
        {
          v.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
          GMTrace.o(1272518279168L, 9481);
          return false;
        }
        ((a)localObject4).gMz = bf.NB();
        localObject7 = ((ArrayList)localObject8).iterator();
        localObject1 = localObject5;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Integer)((Iterator)localObject7).next();
          localObject3 = Long.valueOf(bf.a((Long)this.gMs.get(localObject8), 0L));
          if ((((Long)localObject3).longValue() > 0L) && (((Long)localObject3).longValue() >= l1))
          {
            v.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[] { localObject8, localObject3, Long.valueOf(l1) });
          }
          else
          {
            localObject5 = (qu)((a)localObject4).gMB.get(localObject8);
            if (localObject5 != null) {
              break label1735;
            }
            localObject5 = new qu();
            ((qu)localObject5).fXF.showType = 0;
            ((qu)localObject5).fXF.fDr = 30;
            ((qu)localObject5).fXF.fDt = "";
            ((qu)localObject5).fXF.fDu = R.i.djk;
            ((qu)localObject5).fXF.position = ((Integer)localObject8).intValue();
            ((a)localObject4).gMB.put(localObject8, localObject5);
          }
        }
        label1735:
        for (;;)
        {
          if (bf.mA((String)localObject1)) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject3 = localObject1;
            if (bf.mA((String)localObject1))
            {
              j = R.l.ebv;
              switch (((Integer)localObject8).intValue())
              {
              }
            }
            for (;;)
            {
              localObject3 = aa.getContext().getString(j);
              ((qu)localObject5).fXF.desc = ((String)localObject3);
              ((qu)localObject5).fXF.url = ((String)localObject6);
              ((qu)localObject5).fXF.visible = true;
              ((qu)localObject5).fXF.fDs = 2;
              ((qu)localObject5).fXF.fDv = ((a)localObject4).gMy;
              this.gMs.put(localObject8, Long.valueOf(l1));
              if (i == 0)
              {
                paramah.fDp.desc = ((String)localObject3);
                paramah.fDp.fDr = 30;
                paramah.fDp.showType = 0;
                paramah.fDp.url = ((String)localObject6);
                paramah.fDp.visible = true;
                paramah.fDp.fDu = R.i.djk;
                paramah.fDp.fDs = 2;
                paramah.fDp.fDt = "";
                paramah.fDp.fDv = String.valueOf(l1);
                paramah.fDp.position = ((Integer)localObject8).intValue();
              }
              ae.v(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(1272249843712L, 9479);
                  a.uql.m(localObject5);
                  GMTrace.o(1272249843712L, 9479);
                }
              });
              localObject1 = localObject3;
              break;
              j = R.l.ebx;
              continue;
              j = R.l.ebu;
            }
            GMTrace.o(1272518279168L, 9481);
            return true;
          }
        }
        localObject3 = localObject7;
        localObject2 = localObject6;
        localObject1 = localObject5;
        break label856;
        label1753:
        localObject5 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject5;
      }
      label1768:
      localObject7 = null;
      localObject6 = null;
    }
  }
  
  public final boolean jdMethod_do(final String paramString)
  {
    GMTrace.i(1272652496896L, 9482);
    v.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[] { this.gMr, paramString });
    if (bf.mA(paramString))
    {
      GMTrace.o(1272652496896L, 9482);
      return false;
    }
    if (paramString.indexOf("<") < 0)
    {
      GMTrace.o(1272652496896L, 9482);
      return false;
    }
    Map localMap = bg.q(paramString, "e");
    if (localMap == null)
    {
      v.e("MicroMsg.BroadcastController", "this is not errmsg");
      GMTrace.o(1272652496896L, 9482);
      return false;
    }
    if (this.gMr == null)
    {
      this.gMr = new a();
      paramString = new qu();
      this.gMr.gMB.put(Integer.valueOf(0), paramString);
      paramString.fXF.desc = "";
      paramString.fXF.url = "";
      paramString.fXF.showType = 0;
      paramString.fXF.fDr = 30;
      paramString.fXF.visible = false;
      paramString.fXF.fDt = "";
      paramString.fXF.fDs = 0;
      paramString.fXF.fDu = R.i.djk;
      paramString.fXF.fDv = "";
      paramString.fXF.position = 0;
    }
    if (!r.ijB)
    {
      if ((this.gMr.gMz != 0L) && (bf.aB(this.gMr.gMz) < 1800000L))
      {
        v.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
        GMTrace.o(1272652496896L, 9482);
        return false;
      }
      this.gMr.gMz = bf.NB();
    }
    if (!r.ijC) {
      try
      {
        long l = bf.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bf.az(l) > 0L)
        {
          v.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l) });
          GMTrace.o(1272652496896L, 9482);
          return false;
        }
      }
      catch (Exception paramString)
      {
        v.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { paramString });
      }
    }
    this.gMr.gMy = ((String)localMap.get(".e.NoticeId"));
    paramString = aa.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", "");
    if ((!r.ijD) && (paramString.contains(this.gMr.gMy)))
    {
      v.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[] { paramString, this.gMr.gMy });
      GMTrace.o(1272652496896L, 9482);
      return false;
    }
    String str = u.ea(aa.getContext());
    Object localObject2 = null;
    Object localObject1 = null;
    paramString = null;
    int i = 0;
    Object localObject4 = new StringBuilder(".e.Item");
    if (i == 0)
    {
      localObject3 = "";
      label508:
      localObject3 = localObject3;
      localObject4 = (String)localMap.get((String)localObject3 + ".Language");
      if ((localObject4 == null) && (i > 3)) {
        break label1054;
      }
      if (!str.equalsIgnoreCase((String)localObject4)) {
        break label891;
      }
      str = (String)localMap.get((String)localObject3 + ".Content");
      localObject4 = (String)localMap.get((String)localObject3 + ".Url");
    }
    for (Object localObject3 = (String)localMap.get((String)localObject3 + ".Tips");; localObject3 = null)
    {
      if (bf.mA(str))
      {
        v.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
        label686:
        localObject3 = localObject1;
        if (bf.mA((String)localObject1)) {
          localObject3 = aa.getContext().getString(R.l.eby);
        }
        localObject1 = localObject2;
        if (bf.mA((String)localObject2))
        {
          v.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
          localObject1 = aa.getContext().getString(R.l.ebs);
        }
        localObject2 = paramString;
        if (bf.mA(paramString))
        {
          if (bf.mA((String)localObject1)) {
            localObject2 = aa.getContext().getString(R.l.ebv);
          }
        }
        else
        {
          label769:
          paramString = (qu)this.gMr.gMB.get(Integer.valueOf(0));
          paramString.fXF.desc = ((String)localObject2);
          paramString.fXF.url = ((String)localObject3);
          paramString.fXF.visible = true;
          paramString.fXF.fDs = 2;
          paramString.fXF.fDv = this.gMr.gMy;
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(1271981408256L, 9477);
              v.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
              a.uql.m(paramString);
              GMTrace.o(1271981408256L, 9477);
            }
          });
          this.gMr.gMA = ((String)localObject1);
          if (ap.vd().foreground) {
            qA();
          }
          GMTrace.o(1272652496896L, 9482);
          return true;
          localObject3 = Integer.valueOf(i);
          break label508;
          label891:
          if (!"en".equalsIgnoreCase((String)localObject4)) {
            break label1039;
          }
          localObject1 = (String)localMap.get((String)localObject3 + ".Content");
          localObject2 = (String)localMap.get((String)localObject3 + ".Url");
          paramString = (String)localMap.get((String)localObject3 + ".Tips");
        }
      }
      for (;;)
      {
        localObject3 = localObject1;
        i += 1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
        localObject2 = localObject1;
        break label769;
        localObject1 = localObject4;
        localObject2 = str;
        paramString = (String)localObject3;
        break label686;
        label1039:
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      label1054:
      localObject4 = null;
      str = null;
    }
  }
  
  final void qA()
  {
    GMTrace.i(1272786714624L, 9483);
    if ((this.gMr == null) || (this.gMr.gMB.get(Integer.valueOf(0)) == null) || (bf.mA(this.gMr.gMA)))
    {
      GMTrace.o(1272786714624L, 9483);
      return;
    }
    v.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[] { this.gMr.gMA });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_disaster_content", this.gMr.gMA);
    localIntent.putExtra("key_disaster_url", ((qu)this.gMr.gMB.get(Integer.valueOf(0))).fXF.url);
    localIntent.setClass(aa.getContext(), DisasterUI.class).addFlags(268435456);
    aa.getContext().startActivity(localIntent);
    this.gMr.gMA = null;
    GMTrace.o(1272786714624L, 9483);
  }
  
  static final class a
  {
    String gMA;
    Map<Integer, qu> gMB;
    String gMy;
    long gMz;
    
    a()
    {
      GMTrace.i(1271310319616L, 9472);
      this.gMy = null;
      this.gMz = 0L;
      this.gMA = null;
      this.gMB = new HashMap();
      GMTrace.o(1271310319616L, 9472);
    }
    
    public final String toString()
    {
      GMTrace.i(1271444537344L, 9473);
      Object localObject = this.gMB.keySet().iterator();
      Integer localInteger;
      for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localInteger + ",") {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      localObject = str;
      if (str.length() > 0) {
        localObject = str.substring(0, str.length() - 1);
      }
      str = String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[] { Integer.valueOf(hashCode()), this.gMy, Long.valueOf(this.gMz), this.gMA, localObject });
      GMTrace.o(1271444537344L, 9473);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */