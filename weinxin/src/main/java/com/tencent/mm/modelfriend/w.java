package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.j.a;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aal;
import com.tencent.mm.protocal.c.aam;
import com.tencent.mm.protocal.c.ase;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.protocal.c.asg;
import com.tencent.mm.protocal.c.ash;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.h;
import com.tencent.mm.x.i;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class w
  extends com.tencent.mm.y.k
  implements j
{
  public final com.tencent.mm.y.b gUq;
  private com.tencent.mm.y.e gUt;
  
  public w(int paramInt)
  {
    GMTrace.i(4449049247744L, 33148);
    this.gUt = null;
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new aal();
    ((b.a)localObject).hrW = new aam();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqgroup";
    ((b.a)localObject).hrU = 143;
    ((b.a)localObject).hrX = 38;
    ((b.a)localObject).hrY = 1000000038;
    this.gUq = ((b.a)localObject).BE();
    localObject = (aal)this.gUq.hrS.hsa;
    ((aal)localObject).mse = 1;
    ((aal)localObject).tEI = paramInt;
    GMTrace.o(4449049247744L, 33148);
  }
  
  private static void a(ash paramash)
  {
    GMTrace.i(4449586118656L, 33152);
    Object localObject1 = af.Gc().hnp.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
    HashMap localHashMap;
    int i;
    if (localObject1 == null)
    {
      localHashMap = null;
      i = 0;
      label32:
      if (i >= paramash.jLr) {
        break label659;
      }
      localObject2 = (asg)paramash.tVa.get(i);
      v.d("MicroMsg.NetSceneGetQQGroup", "id:" + ((asg)localObject2).tEI + " name:" + ((asg)localObject2).tyT + " mem:" + ((asg)localObject2).tug + " wei:" + ((asg)localObject2).tUZ + " md5:" + ((asg)localObject2).tsQ);
      if (((asg)localObject2).tEI >= 0) {
        break label276;
      }
      localObject1 = null;
      label141:
      if (localObject1 != null) {
        break label338;
      }
      v.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:" + i);
    }
    label276:
    label338:
    while (((ab)localObject1).hBC == 0)
    {
      i += 1;
      break label32;
      if (((Cursor)localObject1).getCount() <= 0)
      {
        ((Cursor)localObject1).close();
        localHashMap = null;
        break;
      }
      localHashMap = new HashMap();
      i = 0;
      while (i < ((Cursor)localObject1).getCount())
      {
        ((Cursor)localObject1).moveToPosition(i);
        localObject2 = new ab();
        ((ab)localObject2).b((Cursor)localObject1);
        localHashMap.put(Integer.valueOf(((ab)localObject2).hBB), localObject2);
        i += 1;
      }
      ((Cursor)localObject1).close();
      break;
      localObject1 = new ab();
      ((ab)localObject1).hBB = ((asg)localObject2).tEI;
      ((ab)localObject1).hBI = ((asg)localObject2).tyT;
      ((ab)localObject1).hBC = ((asg)localObject2).tug;
      ((ab)localObject1).hBD = ((asg)localObject2).tUZ;
      ((ab)localObject1).hBH = ((asg)localObject2).tsQ;
      break label141;
    }
    if (localHashMap != null) {}
    for (Object localObject2 = (ab)localHashMap.get(Integer.valueOf(((ab)localObject1).hBB));; localObject2 = null)
    {
      if (localObject2 == null)
      {
        ((ab)localObject1).hBE = ((int)bf.Nz());
        ((ab)localObject1).hBF = ((int)bf.Nz());
        ((ab)localObject1).hBG = 1;
        localObject2 = af.Gc();
        if (localObject1 != null)
        {
          v.d("MicroMsg.QQGroupStorage", "insert: name:" + ((ab)localObject1).FO());
          ((ab)localObject1).fRM = -1;
          ContentValues localContentValues = ((ab)localObject1).FM();
          if ((int)((ac)localObject2).hnp.insert("qqgroup", "grouopid", localContentValues) >= 0) {
            ((ac)localObject2).doNotify();
          }
        }
        for (bool = true;; bool = false)
        {
          v.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + ((ab)localObject1).FO() + " ret:" + bool);
          break;
        }
      }
      ((ab)localObject2).hBG = -1;
      v.d("MicroMsg.NetSceneGetQQGroup", ((ab)localObject1).FN() + " " + ((ab)localObject2).FN() + " " + ((ab)localObject1).hBB);
      if (((ab)localObject2).FN().equals(((ab)localObject1).FN())) {
        break;
      }
      ((ab)localObject1).hBF = ((int)bf.Nz());
      ((ab)localObject1).hBG = 1;
      ((ab)localObject1).fRM = -1;
      boolean bool = af.Gc().a((ab)localObject1);
      v.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + ((ab)localObject1).FO() + " ret:" + bool);
      break;
      label659:
      if (localHashMap != null)
      {
        paramash = localHashMap.keySet().iterator();
        while (paramash.hasNext())
        {
          localObject1 = (ab)localHashMap.get(paramash.next());
          if (((ab)localObject1).hBG == 0)
          {
            localObject2 = af.Gc();
            i = ((ab)localObject1).hBB;
            v.d("MicroMsg.QQGroupStorage", "delete: id:" + i);
            if (((ac)localObject2).hnp.delete("qqgroup", "grouopid= ?", new String[] { String.valueOf(i) }) > 0)
            {
              ((ac)localObject2).doNotify();
              bool = true;
              label777:
              v.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + ((ab)localObject1).FO() + " ret:" + bool);
              localObject2 = af.Ge();
              i = ((ab)localObject1).hBB;
              v.d("MicroMsg.QQListStorage", "delete: GroupID:" + i);
              if (((ae)localObject2).hnp.delete("qqlist", "groupid= ?", new String[] { String.valueOf(i) }) <= 0) {
                break label921;
              }
            }
            label921:
            for (bool = true;; bool = false)
            {
              v.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + ((ab)localObject1).FO() + " ret:" + bool);
              break;
              bool = false;
              break label777;
            }
          }
        }
      }
      GMTrace.o(4449586118656L, 33152);
      return;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4449183465472L, 33149);
    this.gUt = parame1;
    parame1 = (aal)this.gUq.hrS.hsa;
    if ((parame1.mse == 1) && (af.Gc().fI(parame1.tEI) == null))
    {
      v.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
      GMTrace.o(4449183465472L, 33149);
      return -1;
    }
    int i = a(parame, this.gUq, this);
    GMTrace.o(4449183465472L, 33149);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4449451900928L, 33151);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4449451900928L, 33151);
      return;
    }
    v.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (aal)this.gUq.hrS.hsa;
    Object localObject2 = (aam)this.gUq.hrT.hsa;
    if (paramArrayOfByte.mse == 0) {
      a(((aam)localObject2).tEJ);
    }
    for (;;)
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4449451900928L, 33151);
      return;
      Object localObject1 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int j = 0;
      while (j < ((aam)localObject2).tEK.jLr)
      {
        localObject3 = (ase)((aam)localObject2).tEK.tUY.get(j);
        paramInt1 = paramArrayOfByte.tEI;
        v.v("MicroMsg.NetSceneGetQQGroup", "friend");
        paramp = new ad();
        paramp.hBJ = new o(((ase)localObject3).tUU).longValue();
        com.tencent.mm.x.b.d(paramp.hBJ, 3);
        paramp.hBL = paramInt1;
        paramp.hBK = ((ase)localObject3).tUW;
        label554:
        label696:
        int i;
        if (((ase)localObject3).tUW != 0)
        {
          if ((((ase)localObject3).jLx == null) || (((ase)localObject3).jLx.equals("")))
          {
            paramp = null;
            ((List)localObject1).add(paramp);
            paramp = new k();
            paramp.gkh = ((ase)localObject3).hAl;
            paramp.gkq = ((ase)localObject3).hAp;
            paramp.gkr = ((ase)localObject3).hAm;
            paramp.gks = ((ase)localObject3).hAn;
            paramp.signature = ((ase)localObject3).hAo;
            paramp.username = ((ase)localObject3).jLx;
            localArrayList1.add(paramp);
            paramp = new h();
            paramp.gkg = 3;
            paramp.aV(true);
            paramp.username = ((ase)localObject3).jLx;
            paramp.hrk = ((ase)localObject3).tov;
            paramp.hrj = ((ase)localObject3).tow;
            localArrayList2.add(paramp);
            j += 1;
            continue;
          }
          ap.yY();
          x localx = com.tencent.mm.u.c.wR().Rb(((ase)localObject3).jLx);
          if ((localx != null) && (localx.field_username.equals(((ase)localObject3).jLx)) && (a.ez(localx.field_type))) {
            paramp.hBK = 2;
          }
        }
        else
        {
          paramp.username = ((ase)localObject3).jLx;
          paramp.fER = ((ase)localObject3).jMD;
          paramp.hBR = ((ase)localObject3).tUX;
          paramp.hBS = com.tencent.mm.platformtools.c.mr(((ase)localObject3).tUX);
          paramp.hBT = com.tencent.mm.platformtools.c.mq(((ase)localObject3).tUX);
          paramp.hBM = com.tencent.mm.platformtools.c.mr(((ase)localObject3).jMD);
          paramp.hBN = com.tencent.mm.platformtools.c.mq(((ase)localObject3).jMD);
          paramp.hBO = ((ase)localObject3).tUV;
          paramp.hBP = com.tencent.mm.platformtools.c.mr(((ase)localObject3).tUV);
          paramp.hBQ = com.tencent.mm.platformtools.c.mq(((ase)localObject3).tUV);
          paramInt1 = 32;
          if (bf.mA(paramp.FV())) {
            break label794;
          }
          paramInt1 = paramp.FV().charAt(0);
          if ((paramInt1 < 97) || (paramInt1 > 122)) {
            break label866;
          }
          i = (char)(paramInt1 - 32);
        }
        for (;;)
        {
          paramp.hrg = i;
          ap.yY();
          com.tencent.mm.u.c.xB().eI(((ase)localObject3).jLx, ((ase)localObject3).tAe);
          v.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + paramp.FR() + "  remark: " + paramp.FU());
          break;
          paramp.hBK = 1;
          break label554;
          label794:
          if (!bf.mA(paramp.FW()))
          {
            paramInt1 = paramp.FW().charAt(0);
            break label696;
          }
          if (!bf.mA(paramp.FS()))
          {
            paramInt1 = paramp.FS().charAt(0);
            break label696;
          }
          if (bf.mA(paramp.FT())) {
            break label696;
          }
          paramInt1 = paramp.FT().charAt(0);
          break label696;
          label866:
          if (paramInt1 >= 65)
          {
            i = paramInt1;
            if (paramInt1 <= 90) {}
          }
          else
          {
            i = 123;
          }
        }
      }
      paramp = new HashMap();
      localObject2 = af.Ge();
      paramInt1 = paramArrayOfByte.tEI;
      v.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + paramInt1);
      Object localObject3 = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt1 + "\"";
      localObject2 = ((ae)localObject2).hnp.a((String)localObject3, null, 0);
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new ad();
        ((ad)localObject3).b((Cursor)localObject2);
        paramp.put(Long.valueOf(((ad)localObject3).hBJ), localObject3);
      }
      ((Cursor)localObject2).close();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ad)((Iterator)localObject1).next();
        if (paramp.containsKey(Long.valueOf(((ad)localObject2).hBJ)))
        {
          localObject3 = (ad)paramp.get(Long.valueOf(((ad)localObject2).hBJ));
          if (!bf.r(Long.valueOf(((ad)localObject3).hBJ), Long.valueOf(((ad)localObject2).hBJ))) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 != 0) {
              break label1509;
            }
            af.Ge().a(((ad)localObject2).hBJ, (ad)localObject2);
            paramp.remove(Long.valueOf(((ad)localObject2).hBJ));
            break;
            if (!bf.r(Integer.valueOf(((ad)localObject3).hBK), Integer.valueOf(((ad)localObject2).hBK))) {
              paramInt1 = 0;
            } else if (!bf.r(Integer.valueOf(((ad)localObject3).hBL), Integer.valueOf(((ad)localObject2).hBL))) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).username, ((ad)localObject2).username)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).fER, ((ad)localObject2).fER)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).hBM, ((ad)localObject2).hBM)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).hBN, ((ad)localObject2).hBN)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).hBO, ((ad)localObject2).hBO)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).hBP, ((ad)localObject2).hBP)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).hBQ, ((ad)localObject2).hBQ)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).hBR, ((ad)localObject2).hBR)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).hBS, ((ad)localObject2).hBS)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).hBT, ((ad)localObject2).hBT)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).hre, ((ad)localObject2).hre)) {
              paramInt1 = 0;
            } else if (!bf.r(((ad)localObject3).hrf, ((ad)localObject2).hrf)) {
              paramInt1 = 0;
            } else if (!bf.r(Integer.valueOf(((ad)localObject3).hrg), Integer.valueOf(((ad)localObject2).hrg))) {
              paramInt1 = 0;
            } else if (!bf.r(Integer.valueOf(((ad)localObject3).hrh), Integer.valueOf(((ad)localObject2).hrh))) {
              paramInt1 = 0;
            } else {
              paramInt1 = 1;
            }
          }
        }
        else
        {
          label1509:
          af.Ge().a((ad)localObject2);
        }
      }
      paramp = paramp.keySet().iterator();
      while (paramp.hasNext())
      {
        long l = ((Long)paramp.next()).longValue();
        localObject1 = af.Ge();
        v.d("MicroMsg.QQListStorage", "delete: QQ:" + l);
        if (((ae)localObject1).hnp.delete("qqlist", "qq= ?", new String[] { String.valueOf(l) }) > 0) {
          ((ae)localObject1).b(5, (m)localObject1, String.valueOf(l));
        }
      }
      af.Gb().z(localArrayList1);
      n.Bm().z(localArrayList2);
      paramp = new ab();
      paramp.hBB = paramArrayOfByte.tEI;
      paramp.hBG = 0;
      paramp.hBF = ((int)bf.Nz());
      paramp.fRM = 48;
      af.Gc().a(paramp);
    }
  }
  
  public final int getType()
  {
    GMTrace.i(4449317683200L, 33150);
    GMTrace.o(4449317683200L, 33150);
    return 143;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */