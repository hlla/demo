package com.tencent.mm.modelbiz;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.af;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d
  extends i<BizInfo>
{
  public static final String[] gUn;
  public static final String[] gaA;
  public static Map<String, String> hvh;
  private final k<a, d.a.b> htP;
  
  static
  {
    GMTrace.i(4589575208960L, 34195);
    gUn = new String[] { i.a(BizInfo.gTF, "bizinfo") };
    hvh = new HashMap();
    gaA = new String[] { "CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) " };
    GMTrace.o(4589575208960L, 34195);
  }
  
  public d(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, BizInfo.gTF, "bizinfo", gaA);
    GMTrace.i(4585414459392L, 34164);
    this.htP = new k() {};
    GMTrace.o(4585414459392L, 34164);
  }
  
  public static String Dk()
  {
    GMTrace.i(4586756636672L, 34174);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("rcontact.showHead asc, ");
    ((StringBuffer)localObject).append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(").append("rcontact.conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(rcontact.quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(rcontact.conRemark) > 0 then upper(").append("rcontact.conRemark) ");
    ((StringBuffer)localObject).append(" else upper(rcontact.quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    GMTrace.o(4586756636672L, 34174);
    return (String)localObject;
  }
  
  public static String Dl()
  {
    GMTrace.i(4586890854400L, 34175);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("rcontact.type & ").append(2048).append(" desc, ");
    ((StringBuffer)localObject).append("rcontact.showHead asc, ");
    ((StringBuffer)localObject).append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(").append("rcontact.conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(rcontact.quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(rcontact.conRemark) > 0 then upper(").append("rcontact.conRemark) ");
    ((StringBuffer)localObject).append(" else upper(rcontact.quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    GMTrace.o(4586890854400L, 34175);
    return (String)localObject;
  }
  
  public static List<String> Dm()
  {
    GMTrace.i(4588233031680L, 34185);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select rcontact.username");
    ((StringBuilder)localObject).append(", bizinfo.enterpriseFather");
    ((StringBuilder)localObject).append(", bizinfo.bitFlag").append(" & 1");
    c((StringBuilder)localObject);
    d((StringBuilder)localObject);
    ((StringBuilder)localObject).append(" and (");
    ((StringBuilder)localObject).append(" (bizinfo.bitFlag").append(" & 1) != 0");
    ((StringBuilder)localObject).append(" or ");
    ((StringBuilder)localObject).append(" (bizinfo.acceptType").append(" & 128) > 0 ");
    ((StringBuilder)localObject).append(" and (bizinfo.brandFlag").append(" & 1) == 0) ");
    localObject = ((StringBuilder)localObject).toString();
    v.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", new Object[] { localObject });
    localObject = com.tencent.mm.kernel.h.vI().gXW.a((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    if (localObject == null)
    {
      GMTrace.o(4588233031680L, 34185);
      return localArrayList;
    }
    if (((Cursor)localObject).moveToNext())
    {
      if (((Cursor)localObject).getInt(2) > 0)
      {
        i = 1;
        label176:
        if (i == 0) {
          break label204;
        }
      }
      label204:
      for (int i = 0;; i = 1)
      {
        localArrayList.add(((Cursor)localObject).getString(i));
        break;
        i = 0;
        break label176;
      }
    }
    ((Cursor)localObject).close();
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().ck(localArrayList);
    GMTrace.o(4588233031680L, 34185);
    return (List<String>)localObject;
  }
  
  public static void a(StringBuilder paramStringBuilder)
  {
    GMTrace.i(4587025072128L, 34176);
    paramStringBuilder.append("select bizinfo.username").append(" ");
    GMTrace.o(4587025072128L, 34176);
  }
  
  public static void a(StringBuilder paramStringBuilder, String paramString)
  {
    GMTrace.i(4587561943040L, 34180);
    paramStringBuilder.append(" and bizinfo.type").append(" = 3");
    paramStringBuilder.append(" and bizinfo.enterpriseFather").append(" = '").append(paramString).append("' ");
    GMTrace.o(4587561943040L, 34180);
  }
  
  public static void a(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    GMTrace.i(4587696160768L, 34181);
    paramStringBuilder.append(" and (bizinfo.bitFlag").append(" & 1) ");
    if (paramBoolean) {}
    for (String str = "!=";; str = "==")
    {
      paramStringBuilder.append(str).append(" 0 ");
      GMTrace.o(4587696160768L, 34181);
      return;
    }
  }
  
  public static void b(StringBuilder paramStringBuilder)
  {
    GMTrace.i(4587159289856L, 34177);
    paramStringBuilder.append("select bizinfo.brandIconURL");
    paramStringBuilder.append(", bizinfo.type");
    paramStringBuilder.append(", bizinfo.status");
    paramStringBuilder.append(", bizinfo.enterpriseFather");
    paramStringBuilder.append(", bizinfo.brandFlag");
    paramStringBuilder.append(", bizinfo.extInfo");
    paramStringBuilder.append(", rcontact.username");
    paramStringBuilder.append(", rcontact.conRemark");
    paramStringBuilder.append(", rcontact.quanPin");
    paramStringBuilder.append(", rcontact.nickname");
    paramStringBuilder.append(", rcontact.alias");
    paramStringBuilder.append(", rcontact.type").append(" ");
    GMTrace.o(4587159289856L, 34177);
  }
  
  public static void b(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    GMTrace.i(4587830378496L, 34182);
    paramStringBuilder.append(" and (bizinfo.brandFlag").append(" & 1) ");
    if (paramBoolean) {}
    for (String str = "==";; str = "!=")
    {
      paramStringBuilder.append(str).append(" 0 ");
      GMTrace.o(4587830378496L, 34182);
      return;
    }
  }
  
  public static void c(StringBuilder paramStringBuilder)
  {
    GMTrace.i(4587293507584L, 34178);
    paramStringBuilder.append(" from rcontact, bizinfo");
    paramStringBuilder.append(" where rcontact.username").append(" = bizinfo.username");
    paramStringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(x.bKW()).append(") != 0 ");
    paramStringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
    GMTrace.o(4587293507584L, 34178);
  }
  
  public static void d(StringBuilder paramStringBuilder)
  {
    GMTrace.i(4587427725312L, 34179);
    paramStringBuilder.append(" and bizinfo.type").append(" = 3 ");
    GMTrace.o(4587427725312L, 34179);
  }
  
  public static List<String> fy(int paramInt)
  {
    GMTrace.i(4588769902592L, 34189);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select bizinfo.username");
    ((StringBuilder)localObject1).append(" from rcontact, bizinfo");
    ((StringBuilder)localObject1).append(" where bizinfo.specialType").append(" = 1");
    ((StringBuilder)localObject1).append(" and rcontact.username").append(" = bizinfo.username");
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag").append(" & ").append(x.bKW()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type").append(" & 1) != 0 ");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    v.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", new Object[] { localObject2 });
    localObject1 = new ArrayList();
    localObject2 = com.tencent.mm.kernel.h.vI().gXW.a((String)localObject2, null, 2);
    paramInt = ((Cursor)localObject2).getColumnIndex("username");
    while (((Cursor)localObject2).moveToNext()) {
      ((List)localObject1).add(((Cursor)localObject2).getString(paramInt));
    }
    ((Cursor)localObject2).close();
    GMTrace.o(4588769902592L, 34189);
    return (List<String>)localObject1;
  }
  
  public static List<String> hR(String paramString)
  {
    GMTrace.i(4588501467136L, 34187);
    Object localObject = new StringBuilder();
    a((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    paramString = ((StringBuilder)localObject).toString();
    v.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.h.vI().gXW.a(paramString, null, 2);
    if (paramString == null)
    {
      GMTrace.o(4588501467136L, 34187);
      return null;
    }
    localObject = new ArrayList();
    while (paramString.moveToNext()) {
      ((List)localObject).add(paramString.getString(0));
    }
    paramString.close();
    GMTrace.o(4588501467136L, 34187);
    return (List<String>)localObject;
  }
  
  public static String hS(String paramString)
  {
    GMTrace.i(4588635684864L, 34188);
    if (bf.mA(paramString))
    {
      v.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
      GMTrace.o(4588635684864L, 34188);
      return null;
    }
    if ((hvh != null) && (hvh.containsKey(paramString)))
    {
      paramString = (String)hvh.get(paramString);
      if ((!bf.mA(paramString)) && (o.eU(paramString)))
      {
        GMTrace.o(4588635684864L, 34188);
        return paramString;
      }
      GMTrace.o(4588635684864L, 34188);
      return null;
    }
    Object localObject = new StringBuilder();
    a((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    a((StringBuilder)localObject, true);
    localObject = ((StringBuilder)localObject).toString();
    v.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", new Object[] { localObject });
    Cursor localCursor = com.tencent.mm.kernel.h.vI().gXW.a((String)localObject, null, 2);
    if (localCursor == null)
    {
      GMTrace.o(4588635684864L, 34188);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = localCursor.getString(0);
      hvh.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localCursor.close();
      GMTrace.o(4588635684864L, 34188);
      return paramString;
    }
  }
  
  public static boolean hT(String paramString)
  {
    boolean bool = false;
    GMTrace.i(4588904120320L, 34190);
    if ((bf.mA(paramString)) || (!e.ic(paramString)))
    {
      GMTrace.o(4588904120320L, 34190);
      return false;
    }
    Object localObject1 = e.hW(paramString);
    Object localObject2;
    if ((((BizInfo)localObject1).bd(false) != null) && (((BizInfo)localObject1).bd(false).Di() != null) && (!bf.mA(((BizInfo)localObject1).CO())))
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rx(((BizInfo)localObject1).CO());
      if ((localObject2 != null) && (((aj)localObject2).field_username.equals(paramString)) && (((aj)localObject2).field_unReadCount > 0)) {
        ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rn(((BizInfo)localObject1).CO());
      }
    }
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Aq(paramString);
    ((Cursor)localObject1).moveToFirst();
    while (!((Cursor)localObject1).isAfterLast())
    {
      localObject2 = new au();
      ((au)localObject2).b((Cursor)localObject1);
      ((au)localObject2).dv(4);
      v.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + ((ce)localObject2).field_msgSvrId + " status = " + ((ce)localObject2).field_status);
      ((Cursor)localObject1).moveToNext();
      bool = true;
    }
    ((Cursor)localObject1).close();
    if (bool)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rn(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().Ao(paramString);
    }
    GMTrace.o(4588904120320L, 34190);
    return bool;
  }
  
  public static void hU(String paramString)
  {
    GMTrace.i(4589038338048L, 34191);
    if ((bf.mA(paramString)) || (!e.ic(paramString)))
    {
      GMTrace.o(4589038338048L, 34191);
      return;
    }
    ((a)com.tencent.mm.kernel.h.j(a.class)).getNotification().db(paramString);
    ((a)com.tencent.mm.kernel.h.j(a.class)).getNotification().ox();
    GMTrace.o(4589038338048L, 34191);
  }
  
  public static void hV(String paramString)
  {
    GMTrace.i(4589172555776L, 34192);
    if ((bf.mA(paramString)) || (!e.ic(paramString)))
    {
      GMTrace.o(4589172555776L, 34192);
      return;
    }
    ((a)com.tencent.mm.kernel.h.j(a.class)).getNotification().db("");
    GMTrace.o(4589172555776L, 34192);
  }
  
  public static Cursor t(String paramString, boolean paramBoolean)
  {
    GMTrace.i(4588367249408L, 34186);
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    b(localStringBuilder, true);
    if (paramBoolean) {
      a(localStringBuilder, false);
    }
    localStringBuilder.append(" order by ");
    localStringBuilder.append(Dl());
    paramString = localStringBuilder.toString();
    v.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.h.vI().gXW.a(paramString, null, 0);
    GMTrace.o(4588367249408L, 34186);
    return paramString;
  }
  
  public static Cursor v(String paramString, int paramInt)
  {
    GMTrace.i(4587964596224L, 34183);
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    a(localStringBuilder, false);
    b(localStringBuilder, true);
    localStringBuilder.append(" and (bizinfo.acceptType").append(" & ").append(paramInt).append(") > 0 ");
    localStringBuilder.append(" order by ");
    localStringBuilder.append(Dk());
    paramString = localStringBuilder.toString();
    v.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.h.vI().gXW.a(paramString, null, 0);
    GMTrace.o(4587964596224L, 34183);
    return paramString;
  }
  
  public final void a(a parama)
  {
    GMTrace.i(4585682894848L, 34166);
    if (this.htP != null) {
      this.htP.remove(parama);
    }
    GMTrace.o(4585682894848L, 34166);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    GMTrace.i(18486210330624L, 137733);
    this.htP.a(parama, paramLooper);
    GMTrace.o(18486210330624L, 137733);
  }
  
  public final void c(BizInfo paramBizInfo)
  {
    GMTrace.i(4586085548032L, 34169);
    v.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.a(paramBizInfo, new String[] { "username" })), paramBizInfo.field_username });
    d.a.b localb = new d.a.b();
    localb.htS = paramBizInfo.field_username;
    localb.hvn = d.a.a.hvk;
    localb.hvo = paramBizInfo;
    this.htP.by(localb);
    this.htP.doNotify();
    GMTrace.o(4586085548032L, 34169);
  }
  
  public final boolean d(BizInfo paramBizInfo)
  {
    GMTrace.i(4586219765760L, 34170);
    paramBizInfo.field_updateTime = System.currentTimeMillis();
    paramBizInfo.CC();
    v.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", new Object[] { paramBizInfo.field_username, paramBizInfo.field_brandList, Integer.valueOf(paramBizInfo.field_brandFlag), paramBizInfo.field_brandInfo, paramBizInfo.field_extInfo, paramBizInfo.field_brandIconURL, Long.valueOf(paramBizInfo.field_updateTime) });
    Object localObject = paramBizInfo.bd(false);
    if (localObject != null)
    {
      localObject = ((BizInfo.ExtInfo)localObject).Da();
      if (localObject != null) {
        paramBizInfo.field_specialType = ((BizInfo.ExtInfo.a)localObject).huM;
      }
    }
    boolean bool = super.b(paramBizInfo);
    if ((bool) && (!o.dH(paramBizInfo.field_username)))
    {
      localObject = new d.a.b();
      ((d.a.b)localObject).htS = paramBizInfo.field_username;
      ((d.a.b)localObject).hus = paramBizInfo.CD();
      ((d.a.b)localObject).hvn = d.a.a.hvj;
      ((d.a.b)localObject).hvo = paramBizInfo;
      this.htP.by(localObject);
      this.htP.doNotify();
    }
    GMTrace.o(4586219765760L, 34170);
    return bool;
  }
  
  public final boolean e(BizInfo paramBizInfo)
  {
    GMTrace.i(4586353983488L, 34171);
    paramBizInfo.field_updateTime = System.currentTimeMillis();
    paramBizInfo.CC();
    Object localObject = paramBizInfo.bd(false);
    if (localObject != null)
    {
      localObject = ((BizInfo.ExtInfo)localObject).Da();
      if (localObject != null) {
        paramBizInfo.field_specialType = ((BizInfo.ExtInfo.a)localObject).huM;
      }
    }
    boolean bool = super.a(paramBizInfo);
    if ((bool) && (!o.dH(paramBizInfo.field_username)))
    {
      localObject = new d.a.b();
      ((d.a.b)localObject).htS = paramBizInfo.field_username;
      ((d.a.b)localObject).hus = paramBizInfo.CD();
      ((d.a.b)localObject).hvn = d.a.a.hvl;
      ((d.a.b)localObject).hvo = paramBizInfo;
      this.htP.by(localObject);
      this.htP.doNotify();
    }
    GMTrace.o(4586353983488L, 34171);
    return bool;
  }
  
  public final List<String> fw(int paramInt)
  {
    GMTrace.i(4586488201216L, 34172);
    Object localObject = String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[] { "username", "bizinfo", "acceptType", Integer.valueOf(paramInt) });
    v.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", new Object[] { localObject });
    long l = bf.NB();
    localObject = rawQuery((String)localObject, new String[0]);
    LinkedList localLinkedList = new LinkedList();
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        do
        {
          localLinkedList.add(((Cursor)localObject).getString(0));
        } while (((Cursor)localObject).moveToNext());
      }
      ((Cursor)localObject).close();
      v.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bf.aB(l)) });
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().ck(localLinkedList);
      GMTrace.o(4586488201216L, 34172);
      return (List<String>)localObject;
    }
    v.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bf.aB(l)) });
    GMTrace.o(4586488201216L, 34172);
    return localLinkedList;
  }
  
  public final int fx(int paramInt)
  {
    GMTrace.i(4586622418944L, 34173);
    List localList = fw(paramInt);
    if (bf.bV(localList))
    {
      GMTrace.o(4586622418944L, 34173);
      return 0;
    }
    paramInt = localList.size();
    GMTrace.o(4586622418944L, 34173);
    return paramInt;
  }
  
  public final BizInfo hO(String paramString)
  {
    GMTrace.i(4585817112576L, 34167);
    BizInfo localBizInfo = new BizInfo();
    localBizInfo.field_username = paramString;
    super.b(localBizInfo, new String[0]);
    GMTrace.o(4585817112576L, 34167);
    return localBizInfo;
  }
  
  public final void hP(String paramString)
  {
    GMTrace.i(4585951330304L, 34168);
    BizInfo localBizInfo = new BizInfo();
    localBizInfo.field_username = paramString;
    v.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.a(localBizInfo, new String[] { "username" })), paramString });
    d.a.b localb = new d.a.b();
    localb.htS = paramString;
    localb.hvn = d.a.a.hvk;
    localb.hvo = localBizInfo;
    this.htP.by(localb);
    this.htP.doNotify();
    GMTrace.o(4585951330304L, 34168);
  }
  
  public final Cursor hQ(String paramString)
  {
    GMTrace.i(4588098813952L, 34184);
    Object localObject = hR(paramString);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bf.mA(hO(str).CN())) {
        localArrayList.add(str);
      }
    }
    if (localArrayList.size() <= 0)
    {
      GMTrace.o(4588098813952L, 34184);
      return null;
    }
    localObject = new StringBuilder();
    b((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    b((StringBuilder)localObject, true);
    ((StringBuilder)localObject).append(" and (");
    int i = 0;
    while (i < localArrayList.size())
    {
      paramString = (String)localArrayList.get(i);
      if (i > 0) {
        ((StringBuilder)localObject).append(" or ");
      }
      ((StringBuilder)localObject).append("rcontact.username = '").append(paramString).append("'");
      i += 1;
    }
    ((StringBuilder)localObject).append(") order by ");
    ((StringBuilder)localObject).append(Dl());
    paramString = ((StringBuilder)localObject).toString();
    v.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.h.vI().gXW.a(paramString, null, 0);
    GMTrace.o(4588098813952L, 34184);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public static enum a
    {
      static
      {
        GMTrace.i(4585280241664L, 34163);
        hvj = 1;
        hvk = 2;
        hvl = 3;
        hvm = new int[] { hvj, hvk, hvl };
        GMTrace.o(4585280241664L, 34163);
      }
    }
    
    public static final class b
    {
      public String htS;
      public boolean hus;
      public int hvn;
      public BizInfo hvo;
      
      public b()
      {
        GMTrace.i(4553202204672L, 33924);
        GMTrace.o(4553202204672L, 33924);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */