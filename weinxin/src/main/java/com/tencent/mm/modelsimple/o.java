package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.ah.b;
import com.tencent.mm.e.a.il;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.protocal.c.xl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Map;

public final class o
  extends k
  implements j
{
  private static Map<String, String> hRA;
  public static Map<String, Long> hRz;
  public boolean fMd;
  private com.tencent.mm.y.e gUt;
  public c<com.tencent.mm.e.a.a> hRB;
  private final com.tencent.mm.y.b hRy;
  
  static
  {
    GMTrace.i(1358551842816L, 10122);
    hRz = new HashMap();
    GMTrace.o(1358551842816L, 10122);
  }
  
  public o(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(1357075447808L, 10111);
    this.fMd = false;
    b.a locala = new b.a();
    locala.hrV = new xk();
    locala.hrW = new xl();
    locala.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
    locala.hrU = 775;
    locala.hrX = 0;
    locala.hrY = 0;
    this.hRy = locala.BE();
    this.hRy.fYi = 1;
    ((xk)this.hRy.hrS.hsa).fMc = paramInt;
    this.fMd = paramBoolean;
    Ja();
    v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.fMd), bf.bJP() });
    GMTrace.o(1357075447808L, 10111);
  }
  
  private void Ja()
  {
    for (;;)
    {
      int i;
      Object localObject4;
      try
      {
        GMTrace.i(1357612318720L, 10115);
        if (hRA != null) {
          break label372;
        }
        v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
        hRA = new HashMap();
        SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("disaster_pref", 4);
        Object localObject1 = localSharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (bf.mA((String)localObject1)) {
          break label355;
        }
        String[] arrayOfString1 = ((String)localObject1).split(";");
        if ((arrayOfString1 == null) || (arrayOfString1.length <= 0)) {
          break label355;
        }
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        int j = arrayOfString1.length;
        i = 0;
        String str1 = "";
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split(",");
          localObject1 = str1;
          localObject4 = str1;
          try
          {
            if (bf.getLong(arrayOfString2[0], 0L) <= 0L) {
              break label384;
            }
            localObject1 = str1;
            if (bf.az(bf.getLong(arrayOfString2[1], 0L)) < 86400L)
            {
              localObject1 = str1;
              String str2 = localSharedPreferences.getString(arrayOfString2[0], "");
              localObject1 = str1;
              localObject4 = str1;
              if (!bf.mA(str2))
              {
                localObject1 = str1;
                localObject4 = str1 + arrayOfString2[0] + "," + arrayOfString2[1] + ";";
                localObject1 = localObject4;
                hRA.put(arrayOfString2[0], str2);
              }
            }
            else
            {
              localObject1 = str1;
              localEditor.remove(arrayOfString2[0]).commit();
              localObject4 = str1;
            }
          }
          catch (Exception localException)
          {
            v.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", new Object[] { localException.getMessage() });
            localObject4 = localObject1;
          }
        }
        localEditor.putString("disaster_new_noticeid_list_key", localException).commit();
      }
      finally {}
      v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", new Object[] { localException, hRz });
      label355:
      v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", new Object[] { hRA });
      label372:
      GMTrace.o(1357612318720L, 10115);
      return;
      label384:
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  public static void ak(String paramString1, String paramString2)
  {
    GMTrace.i(16012577603584L, 119303);
    SharedPreferences localSharedPreferences = aa.getContext().getSharedPreferences("disaster_pref", 4);
    Object localObject2 = localSharedPreferences.getString("disaster_new_noticeid_list_key", "");
    Object localObject1 = localObject2;
    if (!bf.mA((String)localObject2)) {
      localObject1 = (String)localObject2 + ";";
    }
    localObject1 = (String)localObject1 + paramString1 + "," + bf.Nz();
    localObject2 = localSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject2).putString(paramString1, paramString2);
    ((SharedPreferences.Editor)localObject2).putString("disaster_new_noticeid_list_key", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).commit();
    hRA.put(paramString1, paramString2);
    v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz saveDisasterNotice newNoticeIdList[%s], noticeId[%s], content[%s]", new Object[] { localSharedPreferences.getString("disaster_new_noticeid_list_key", ""), paramString1, localSharedPreferences.getString(paramString1, "") });
    GMTrace.o(16012577603584L, 119303);
  }
  
  private void z(final String paramString, final boolean paramBoolean)
  {
    GMTrace.i(1357478100992L, 10114);
    ap.vL().D(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1350767214592L, 10064);
        int i;
        final Object localObject1;
        String str;
        int j;
        final Object localObject2;
        if (paramString == null)
        {
          i = -1;
          v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean) });
          localObject1 = new ah();
          ((ah)localObject1).fDo.type = 5;
          ((ah)localObject1).fDo.fDq = paramString;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
          str = ((ah)localObject1).fDp.fDv;
          i = ((ah)localObject1).fDp.position;
          j = ((ah)localObject1).fDp.fDs;
          v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Boolean.valueOf(o.this.fMd), o.hRz });
          if ((i != 1) || (j != 6)) {
            break label369;
          }
          if (paramBoolean) {
            o.ak(str, paramString);
          }
          if (!o.this.fMd) {
            break label316;
          }
          localObject2 = ((ah)localObject1).fDp.desc;
          localObject1 = ((ah)localObject1).fDp.url;
          v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", new Object[] { Boolean.valueOf(aa.bIK()) });
          if (o.this.hRB == null) {
            o.this.hRB = new c() {};
          }
          com.tencent.mm.sdk.b.a.uql.b(o.this.hRB);
        }
        for (;;)
        {
          o.hRz.put(str, Long.valueOf(bf.NB()));
          GMTrace.o(1350767214592L, 10064);
          return;
          i = paramString.length();
          break;
          label316:
          localObject2 = new il();
          ((il)localObject2).fOa.content = ((ah)localObject1).fDp.desc;
          ((il)localObject2).fOa.url = ((ah)localObject1).fDp.url;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2);
        }
        label369:
        if (j == 2)
        {
          if (paramBoolean) {
            o.ak(str, paramString);
          }
          o.hRz.put(str, Long.valueOf(bf.NB()));
        }
        GMTrace.o(1350767214592L, 10064);
      }
    });
    GMTrace.o(1357478100992L, 10114);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(1357343883264L, 10113);
    xk localxk = (xk)this.hRy.hrS.hsa;
    long l = bf.a((Long)hRz.get(localxk.fMc), 0L);
    v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", new Object[] { Integer.valueOf(localxk.fMc), Long.valueOf(l), hRz });
    if ((l != 0L) && (bf.aB(l) < 1800000L))
    {
      v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", new Object[] { Integer.valueOf(localxk.fMc) });
      GMTrace.o(1357343883264L, 10113);
      return -1;
    }
    String str = bf.ap((String)hRA.get(localxk.fMc), "");
    if (!bf.mA(str))
    {
      v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", new Object[] { Integer.valueOf(localxk.fMc), str });
      z(str, false);
      GMTrace.o(1357343883264L, 10113);
      return -1;
    }
    this.gUt = parame1;
    int i = a(parame, this.hRy, this);
    GMTrace.o(1357343883264L, 10113);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(1357746536448L, 10116);
    v.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      z(((xl)this.hRy.hrT.hsa).content, true);
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(1357746536448L, 10116);
  }
  
  public final int getType()
  {
    GMTrace.i(1357209665536L, 10112);
    GMTrace.o(1357209665536L, 10112);
    return 775;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */