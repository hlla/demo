package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ad
  extends m
  implements ar
{
  public static final String[] gUn;
  public static final String[] gaA;
  private static String uHc;
  private static String uHd;
  private com.tencent.mm.sdk.e.e gUp;
  private final k<ar.a, x> htP;
  private com.tencent.mm.sdk.e.e uGZ;
  public final com.tencent.mm.a.f<String, x> uHa;
  public final com.tencent.mm.a.f<String, Integer> uHb;
  
  static
  {
    GMTrace.i(13214674845696L, 98457);
    gUn = new String[] { i.a(x.gTF, "rcontact"), i.a(x.gTF, "bottlecontact"), i.a(y.gTF, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );" };
    gaA = new String[] { "CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) " };
    uHc = "showHead = 32";
    uHd = "type & 64 !=0 ";
    GMTrace.o(13214674845696L, 98457);
  }
  
  public ad(g paramg)
  {
    GMTrace.i(13205011169280L, 98385);
    this.uHa = new com.tencent.mm.a.f(200);
    this.uHb = new com.tencent.mm.a.f(400);
    this.htP = new k() {};
    Object localObject = paramg.a("PRAGMA table_info( contact_ext )", null, 2);
    int n = ((Cursor)localObject).getColumnIndex("name");
    int j = 0;
    int i = 0;
    while ((((Cursor)localObject).moveToNext()) && ((i == 0) || (j == 0))) {
      if (n >= 0)
      {
        String str = ((Cursor)localObject).getString(n);
        if ("weiboNickname".equalsIgnoreCase(str)) {
          j = 1;
        } else if ("weiboFlag".equalsIgnoreCase(str)) {
          i = 1;
        }
      }
    }
    ((Cursor)localObject).close();
    if (i == 0) {
      paramg.eE("contact_ext", "Alter table contact_ext add weiboFlag INT DEFAULT 0 ");
    }
    if (j == 0) {
      paramg.eE("contact_ext", "Alter table contact_ext add weiboNickname INT DEFAULT 0 ");
    }
    localObject = paramg.a("PRAGMA table_info( rcontact )", null, 2);
    i = ((Cursor)localObject).getColumnIndex("name");
    do
    {
      if (!((Cursor)localObject).moveToNext()) {
        break;
      }
    } while ((i < 0) || (!"verifyFlag".equalsIgnoreCase(((Cursor)localObject).getString(i))));
    for (i = m;; i = 0)
    {
      ((Cursor)localObject).close();
      if (i == 0) {
        paramg.eE("rcontact", "Alter table rcontact add verifyFlag INT DEFAULT 0 ");
      }
      localObject = i.a(a.gTF, "bottlecontact", paramg).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramg.eE("bottlecontact", (String)((Iterator)localObject).next());
      }
      localObject = i.a(a.gTF, "rcontact", paramg).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramg.eE("rcontact", (String)((Iterator)localObject).next());
      }
      localObject = gaA;
      j = localObject.length;
      i = k;
      while (i < j)
      {
        paramg.eE("rcontact", localObject[i]);
        i += 1;
      }
      this.gUp = paramg;
      this.uGZ = paramg;
      GMTrace.o(13205011169280L, 98385);
      return;
    }
  }
  
  private void DX(String paramString)
  {
    GMTrace.i(13205682257920L, 98390);
    if (!bf.mA(paramString))
    {
      this.uHa.remove(paramString);
      this.uHb.remove(paramString);
    }
    GMTrace.o(13205682257920L, 98390);
  }
  
  private static String E(boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13213198450688L, 98446);
    String str2 = "type & " + a.tt() + "!=0";
    String str1 = str2;
    if (paramBoolean1) {
      str1 = str2 + " or type & " + a.tw() + "!=0";
    }
    str1 = " where (" + str1 + ")";
    str1 = str1 + " and type & " + a.tx() + "=0 ";
    str2 = str1 + " and type & " + a.tu() + " =0 ";
    str1 = str2;
    if (!paramBoolean2) {
      str1 = str2 + " and verifyFlag & " + x.bKW() + " =0 ";
    }
    GMTrace.o(13213198450688L, 98446);
    return str1;
  }
  
  private static String F(String[] paramArrayOfString)
  {
    GMTrace.i(13212527362048L, 98441);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      GMTrace.o(13212527362048L, 98441);
      return "";
    }
    String str1 = " and (";
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      String str2 = str1;
      if (i > 0) {
        str2 = str1 + " or ";
      }
      str1 = str2 + "username = '" + paramArrayOfString[i] + "' ";
      i += 1;
    }
    paramArrayOfString = str1 + " )";
    GMTrace.o(13212527362048L, 98441);
    return paramArrayOfString;
  }
  
  private static String QU(String paramString)
  {
    GMTrace.i(13204742733824L, 98383);
    paramString = "select *,rowid from " + QV(paramString) + " ";
    GMTrace.o(13204742733824L, 98383);
    return paramString;
  }
  
  private static String QV(String paramString)
  {
    GMTrace.i(13204876951552L, 98384);
    if (x.eO(paramString))
    {
      GMTrace.o(13204876951552L, 98384);
      return "bottlecontact";
    }
    GMTrace.o(13204876951552L, 98384);
    return "rcontact";
  }
  
  private static boolean T(x paramx)
  {
    boolean bool = false;
    GMTrace.i(13214540627968L, 98456);
    if (paramx == null)
    {
      GMTrace.o(13214540627968L, 98456);
      return false;
    }
    int i = paramx.versionCode;
    if (i <= 0) {}
    for (;;)
    {
      v.d("MicroMsg.ContactStorage", "it need to update contact: " + bool + " version code : " + i + " user: " + paramx.field_username);
      GMTrace.o(13214540627968L, 98456);
      return bool;
      bool = true;
    }
  }
  
  private static String bLm()
  {
    GMTrace.i(13212795797504L, 98443);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(" order by showHead asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    GMTrace.o(13212795797504L, 98443);
    return (String)localObject;
  }
  
  private static String bLo()
  {
    GMTrace.i(13213332668416L, 98447);
    String str = "type & " + a.tt() + "!=0";
    str = " where (" + str + ") and ";
    str = str + "type & " + a.tx() + "=0  ";
    GMTrace.o(13213332668416L, 98447);
    return str;
  }
  
  private static String bLp()
  {
    GMTrace.i(13213466886144L, 98448);
    String str = "type & " + a.tt() + "!=0";
    str = "( (" + str + ") and type & " + a.tu() + "=0 and username like '%@chatroom" + "')";
    GMTrace.o(13213466886144L, 98448);
    return str;
  }
  
  private static String bLq()
  {
    GMTrace.i(13213601103872L, 98449);
    String str = "type & " + a.tt() + "!=0";
    str = "( (" + str + ") and type & " + a.tu() + "=0 and username like '%@talkroom" + "')";
    GMTrace.o(13213601103872L, 98449);
    return str;
  }
  
  private static String cg(List<String> paramList)
  {
    GMTrace.i(13209977225216L, 98422);
    if ((paramList == null) || (paramList.size() == 0))
    {
      GMTrace.o(13209977225216L, 98422);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localStringBuilder.append(" or username = '").append(str).append("'");
    }
    paramList = localStringBuilder.toString();
    GMTrace.o(13209977225216L, 98422);
    return paramList;
  }
  
  private static String ch(List<String> paramList)
  {
    GMTrace.i(13210245660672L, 98424);
    String str = cg(paramList);
    int i = str.indexOf("or");
    paramList = str;
    if (i <= 2) {
      paramList = str.substring(i + 2);
    }
    GMTrace.o(13210245660672L, 98424);
    return paramList;
  }
  
  private static String o(String paramString, List<String> paramList)
  {
    GMTrace.i(13212393144320L, 98440);
    if ((paramString == null) || (paramString.equals("")))
    {
      GMTrace.o(13212393144320L, 98440);
      return "";
    }
    String str = " and (";
    Object localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.size() != 0)
      {
        localObject = paramList.iterator();
        for (paramList = " and ("; ((Iterator)localObject).hasNext(); paramList = paramList + "username = '" + str + "' or ") {
          str = (String)((Iterator)localObject).next();
        }
        localObject = paramList;
      }
    }
    paramList = (String)localObject + "conRemark like '%" + paramString + "%' or ";
    paramList = paramList + "conRemarkPYFull like '%" + paramString + "%' or ";
    paramList = paramList + "conRemarkPYShort like '%" + paramString + "%' or ";
    paramList = paramList + "alias like '%" + paramString + "%' or ";
    paramList = paramList + "username like '%" + paramString + "%' or ";
    paramList = paramList + "nickname like '%" + paramString + "%' or ";
    paramList = paramList + "pyInitial like '%" + paramString + "%' or ";
    paramString = paramList + "quanPin like '%" + paramString + "%' )";
    GMTrace.o(13212393144320L, 98440);
    return paramString;
  }
  
  public final String Dk()
  {
    GMTrace.i(15660256067584L, 116678);
    String str = bLm();
    GMTrace.o(15660256067584L, 116678);
    return str;
  }
  
  protected final boolean Fd()
  {
    GMTrace.i(13214406410240L, 98455);
    if ((this.gUp == null) || (this.gUp.bKd()))
    {
      if (this.gUp == null) {}
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.gUp.bKd()))
      {
        v.w("MicroMsg.ContactStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
        GMTrace.o(13214406410240L, 98455);
        return false;
      }
    }
    GMTrace.o(13214406410240L, 98455);
    return true;
  }
  
  public final void O(x paramx)
  {
    GMTrace.i(13205548040192L, 98389);
    if ((paramx == null) || (paramx.field_username == null) || (paramx.field_type == 0))
    {
      GMTrace.o(13205548040192L, 98389);
      return;
    }
    this.uHa.k(paramx.field_username, paramx);
    this.uHb.k(paramx.field_username, Integer.valueOf(paramx.field_type));
    GMTrace.o(13205548040192L, 98389);
  }
  
  public final boolean P(x paramx)
  {
    GMTrace.i(13205950693376L, 98392);
    if (Rd(paramx.field_username))
    {
      if (a(paramx.field_username, paramx) == 0)
      {
        GMTrace.o(13205950693376L, 98392);
        return true;
      }
      GMTrace.o(13205950693376L, 98392);
      return false;
    }
    if (S(paramx) >= 0)
    {
      GMTrace.o(13205950693376L, 98392);
      return true;
    }
    GMTrace.o(13205950693376L, 98392);
    return false;
  }
  
  public final boolean Q(x paramx)
  {
    GMTrace.i(13207561306112L, 98404);
    if (paramx != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("contact NULL !", bool);
      if (T(paramx)) {
        break;
      }
      GMTrace.o(13207561306112L, 98404);
      return true;
    }
    paramx.dc(paramx.sZ());
    this.htP.by(paramx);
    this.htP.doNotify();
    v.d("MicroMsg.ContactStorage", "replace : username=%s, showHead=%d, verifyFlag=%d", new Object[] { paramx.field_username, Integer.valueOf(paramx.field_showHead), Integer.valueOf(paramx.field_verifyFlag) });
    ContentValues localContentValues = paramx.pv();
    if ((int)paramx.gTG > 0) {
      localContentValues.put("rowid", Integer.valueOf((int)paramx.gTG));
    }
    if (this.gUp.replace(QV(paramx.field_username), a.gTF.uvq, localContentValues) > 0L) {}
    for (int i = 1;; i = 0)
    {
      DX(paramx.field_username);
      if (!bf.mA(paramx.field_encryptUsername)) {
        DX(paramx.field_encryptUsername);
      }
      if (i != 0) {
        break;
      }
      GMTrace.o(13207561306112L, 98404);
      return false;
    }
    b(4, this, paramx.field_username);
    GMTrace.o(13207561306112L, 98404);
    return true;
  }
  
  public final x QW(String paramString)
  {
    GMTrace.i(13205413822464L, 98388);
    paramString = (x)this.uHa.get(paramString);
    if (paramString != null)
    {
      GMTrace.o(13205413822464L, 98388);
      return paramString;
    }
    GMTrace.o(13205413822464L, 98388);
    return null;
  }
  
  public final boolean QX(String paramString)
  {
    GMTrace.i(13205816475648L, 98391);
    if ((bf.mA(paramString)) || ((paramString.contains("@")) && (!paramString.endsWith("@stranger"))))
    {
      GMTrace.o(13205816475648L, 98391);
      return false;
    }
    Object localObject = (Integer)this.uHb.get(paramString);
    if (localObject != null)
    {
      bool = a.ez(((Integer)localObject).intValue());
      GMTrace.o(13205816475648L, 98391);
      return bool;
    }
    localObject = Rb(paramString);
    if ((localObject == null) || ((!((af)localObject).field_username.equals(paramString)) && (!paramString.equals(((af)localObject).field_encryptUsername))))
    {
      this.uHb.k(paramString, Integer.valueOf(0));
      GMTrace.o(13205816475648L, 98391);
      return false;
    }
    this.uHb.k(paramString, Integer.valueOf(((af)localObject).field_type));
    boolean bool = a.ez(((af)localObject).field_type);
    GMTrace.o(13205816475648L, 98391);
    return bool;
  }
  
  public final x QY(String paramString)
  {
    GMTrace.i(13206084911104L, 98393);
    if (bf.mA(paramString))
    {
      GMTrace.o(13206084911104L, 98393);
      return null;
    }
    x localx = new x();
    paramString = "select *,rowid from rcontact where alias=" + g.dP(paramString);
    paramString = this.gUp.a(paramString, null, 2);
    if (paramString.moveToFirst())
    {
      localx.b(paramString);
      O(localx);
    }
    paramString.close();
    localx.bKZ();
    GMTrace.o(13206084911104L, 98393);
    return localx;
  }
  
  public final x QZ(String paramString)
  {
    GMTrace.i(13206621782016L, 98397);
    if (bf.mA(paramString))
    {
      GMTrace.o(13206621782016L, 98397);
      return null;
    }
    Object localObject = paramString;
    if (x.eO(paramString)) {
      localObject = x.QQ(paramString);
    }
    paramString = QW((String)localObject);
    if (paramString != null)
    {
      paramString.bKZ();
      GMTrace.o(13206621782016L, 98397);
      return paramString;
    }
    paramString = new x();
    localObject = QU((String)localObject) + " where username=" + g.dP((String)localObject);
    localObject = this.gUp.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.b((Cursor)localObject);
      O(paramString);
    }
    ((Cursor)localObject).close();
    paramString.bKZ();
    GMTrace.o(13206621782016L, 98397);
    return paramString;
  }
  
  public final boolean R(x paramx)
  {
    GMTrace.i(13207695523840L, 98405);
    if (S(paramx) > 0)
    {
      GMTrace.o(13207695523840L, 98405);
      return true;
    }
    GMTrace.o(13207695523840L, 98405);
    return false;
  }
  
  public final x Ra(String paramString)
  {
    GMTrace.i(13206755999744L, 98398);
    if (bf.mA(paramString))
    {
      GMTrace.o(13206755999744L, 98398);
      return null;
    }
    Object localObject = paramString;
    if (x.eO(paramString)) {
      localObject = x.QQ(paramString);
    }
    paramString = QW((String)localObject);
    if (paramString != null)
    {
      GMTrace.o(13206755999744L, 98398);
      return paramString;
    }
    paramString = new x();
    localObject = QU((String)localObject) + " where username=" + g.dP((String)localObject) + " or encryptUsername=" + g.dP((String)localObject);
    localObject = this.gUp.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.b((Cursor)localObject);
      O(paramString);
    }
    ((Cursor)localObject).close();
    GMTrace.o(13206755999744L, 98398);
    return paramString;
  }
  
  public final x Rb(String paramString)
  {
    GMTrace.i(13206890217472L, 98399);
    if (bf.mA(paramString))
    {
      GMTrace.o(13206890217472L, 98399);
      return null;
    }
    Object localObject = paramString;
    if (x.eO(paramString)) {
      localObject = x.QQ(paramString);
    }
    paramString = QW((String)localObject);
    if (paramString != null)
    {
      GMTrace.o(13206890217472L, 98399);
      return paramString;
    }
    paramString = new x();
    localObject = QU((String)localObject) + " where username=" + g.dP((String)localObject) + " or encryptUsername=" + g.dP((String)localObject);
    localObject = this.gUp.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      paramString.b((Cursor)localObject);
      ((Cursor)localObject).close();
      paramString.bKZ();
      O(paramString);
    }
    for (;;)
    {
      GMTrace.o(13206890217472L, 98399);
      return paramString;
      ((Cursor)localObject).close();
    }
  }
  
  public final long Rc(String paramString)
  {
    GMTrace.i(13207158652928L, 98401);
    long l2 = -1L;
    paramString = Rb(paramString);
    long l1 = l2;
    if (paramString != null)
    {
      l1 = l2;
      if (paramString.gTG > 0L) {
        l1 = (int)paramString.gTG;
      }
    }
    GMTrace.o(13207158652928L, 98401);
    return l1;
  }
  
  public final boolean Rd(String paramString)
  {
    GMTrace.i(13207292870656L, 98402);
    x localx = Rb(paramString);
    if ((localx != null) && (!bf.mA(localx.field_username)) && (localx.field_username.equals(paramString)))
    {
      GMTrace.o(13207292870656L, 98402);
      return true;
    }
    GMTrace.o(13207292870656L, 98402);
    return false;
  }
  
  public final boolean Re(String paramString)
  {
    boolean bool2 = false;
    GMTrace.i(13207427088384L, 98403);
    if (bf.mA(paramString))
    {
      GMTrace.o(13207427088384L, 98403);
      return false;
    }
    paramString = "select count(*) from " + QV(paramString) + " where type & " + a.tu() + " !=0 and username=" + g.dP(paramString);
    paramString = this.gUp.a(paramString, null, 2);
    boolean bool1 = bool2;
    if (paramString.moveToFirst())
    {
      bool1 = bool2;
      if (paramString.getInt(0) > 0) {
        bool1 = true;
      }
    }
    paramString.close();
    GMTrace.o(13207427088384L, 98403);
    return bool1;
  }
  
  public final byte[] Rf(String paramString)
  {
    GMTrace.i(13208098177024L, 98408);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      GMTrace.o(13208098177024L, 98408);
      return null;
    }
    y localy = new y();
    Cursor localCursor = this.gUp.a("ContactCmdBuf", null, "username=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor.moveToFirst()) {
      localy.b(localCursor);
    }
    localCursor.close();
    if (localy.field_cmdbuf == null) {}
    for (int i = -1;; i = localy.field_cmdbuf.length)
    {
      v.d("MicroMsg.ContactStorage", "getCmdbuf user:%s buf:%d", new Object[] { paramString, Integer.valueOf(i) });
      paramString = localy.field_cmdbuf;
      GMTrace.o(13208098177024L, 98408);
      return paramString;
    }
  }
  
  public final int Rg(String paramString)
  {
    GMTrace.i(13208232394752L, 98409);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
      GMTrace.o(13208232394752L, 98409);
      return -1;
    }
    int i = this.gUp.delete("ContactCmdBuf", "username=?", new String[] { paramString });
    v.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", new Object[] { paramString, Integer.valueOf(i) });
    GMTrace.o(13208232394752L, 98409);
    return i;
  }
  
  public final int Rh(String paramString)
  {
    GMTrace.i(13208366612480L, 98410);
    if (paramString.length() > 0) {}
    String str;
    int i;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = paramString;
      if (x.eO(paramString)) {
        str = x.QQ(paramString);
      }
      DX(str);
      paramString = new x(str);
      paramString.setType(0);
      paramString.setUsername("fake_" + bf.NA());
      paramString.bX("fake_" + bf.NA());
      i = this.gUp.update(QV(str), paramString.pv(), "username=?", new String[] { str });
      Rg(str);
      v.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", new Object[] { str, Integer.valueOf(i), bf.bJP() });
      if (i != 0) {
        break;
      }
      GMTrace.o(13208366612480L, 98410);
      return i;
    }
    b(5, this, str);
    GMTrace.o(13208366612480L, 98410);
    return i;
  }
  
  public final String Ri(String paramString)
  {
    GMTrace.i(13212661579776L, 98442);
    if ((paramString == null) || (paramString.equals("")))
    {
      GMTrace.o(13212661579776L, 98442);
      return "";
    }
    String str = " and (" + "conRemark like '%" + paramString + "%' or ";
    str = str + "conRemarkPYFull like '%" + paramString + "%' or ";
    str = str + "conRemarkPYShort like '%" + paramString + "%' or ";
    str = str + "alias like '%" + paramString + "%' or ";
    str = str + "username like '%" + paramString + "%' or ";
    str = str + "nickname like '%" + paramString + "%' or ";
    str = str + "pyInitial like '%" + paramString + "%' or ";
    paramString = str + "quanPin like '%" + paramString + "%' )";
    GMTrace.o(13212661579776L, 98442);
    return paramString;
  }
  
  public final int S(x paramx)
  {
    GMTrace.i(13207829741568L, 98406);
    if (bf.mz(paramx.field_username).length() <= 0)
    {
      v.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
      GMTrace.o(13207829741568L, 98406);
      return -1;
    }
    paramx.dc(paramx.sZ());
    this.htP.by(paramx);
    this.htP.doNotify();
    Object localObject = paramx.pv();
    long l = System.currentTimeMillis();
    int k = (int)this.gUp.insert(QV(paramx.field_username), a.gTF.uvq, (ContentValues)localObject);
    int m = (int)bf.aA(l);
    boolean bool = b.foreground;
    localObject = com.tencent.mm.plugin.report.c.oRz;
    int i;
    if (bool)
    {
      i = 11;
      if (!bool) {
        break label262;
      }
    }
    label262:
    for (int j = 12;; j = 15)
    {
      ((com.tencent.mm.plugin.report.c)localObject).c(463, i, j, m, false);
      v.i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", new Object[] { paramx.field_username, Integer.valueOf(paramx.field_showHead), Integer.valueOf(paramx.field_verifyFlag), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
      if (k == -1) {
        break label268;
      }
      paramx.gTG = k;
      O(paramx);
      b(2, this, paramx.field_username);
      GMTrace.o(13207829741568L, 98406);
      return k;
      i = 14;
      break;
    }
    label268:
    v.e("MicroMsg.ContactStorage", "insert failed: username=" + paramx.field_username);
    GMTrace.o(13207829741568L, 98406);
    return -1;
  }
  
  public final int a(String paramString, x paramx)
  {
    GMTrace.i(13208500830208L, 98411);
    v.i("MicroMsg.ContactStorage", "begin to update contact : " + paramString);
    if (!T(paramx))
    {
      GMTrace.o(13208500830208L, 98411);
      return 1;
    }
    long l = System.currentTimeMillis();
    String str = paramString;
    if (x.eO(paramString)) {
      str = x.QQ(paramString);
    }
    paramx.dc(paramx.sZ());
    this.htP.by(paramx);
    this.htP.doNotify();
    paramString = paramx.pv();
    if ((int)paramx.gTG > 0) {
      paramString.put("rowid", Integer.valueOf((int)paramx.gTG));
    }
    int i = 0;
    if (paramString.size() > 0) {
      i = this.gUp.update(QV(str), paramString, "username=?", new String[] { str });
    }
    v.i("MicroMsg.ContactStorage", "update : username=%s, showHead=%d, verifyFlag=%d, result1=%d, take[%d]ms", new Object[] { paramx.field_username, Integer.valueOf(paramx.field_showHead), Integer.valueOf(paramx.field_verifyFlag), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
    DX(str);
    if (!bf.mA(paramx.field_encryptUsername)) {
      DX(paramx.field_encryptUsername);
    }
    if (i != 0) {
      b(4, this, str);
    }
    GMTrace.o(13208500830208L, 98411);
    return i;
  }
  
  public final Cursor a(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13206219128832L, 98394);
    paramString1 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact " + e(paramString1, paramString2, paramList1) + cg(paramList2) + bLm();
    v.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact " + i(paramList1, paramBoolean2) + bLn();
      v.v("MicroMsg.ContactStorage", "favourSql " + paramString1);
      paramString2 = this.gUp.a(paramString2, null, 4);
      paramString1 = this.gUp.a(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.bj.a.f)) && ((paramString1 instanceof com.tencent.mm.bj.a.f)))
      {
        paramString1 = new com.tencent.mm.bj.a.e(new com.tencent.mm.bj.a.f[] { (com.tencent.mm.bj.a.f)paramString2, (com.tencent.mm.bj.a.f)paramString1 });
        GMTrace.o(13206219128832L, 98394);
        return paramString1;
      }
      paramString1 = com.tencent.mm.bj.c.bNy();
      GMTrace.o(13206219128832L, 98394);
      return paramString1;
    }
    paramString1 = this.gUp.a(paramString1, null, 4);
    GMTrace.o(13206219128832L, 98394);
    return paramString1;
  }
  
  public final Cursor a(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13210111442944L, 98423);
    paramString1 = "select * ,rowid from rcontact " + e(paramString1, paramString2, paramList) + cg(null) + bLm();
    v.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.gUp.rawQuery(paramString1, null);
    GMTrace.o(13210111442944L, 98423);
    return paramString1;
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString1, String paramString2, List<String> paramList1, List<String> paramList2)
  {
    GMTrace.i(13212258926592L, 98439);
    paramArrayOfString = "select * ,rowid from rcontact " + e(paramString1, paramString2, paramList2) + F(paramArrayOfString) + o(paramString2, paramList1) + bLm();
    v.i("MicroMsg.ContactStorage", paramArrayOfString);
    paramArrayOfString = this.gUp.rawQuery(paramArrayOfString, null);
    GMTrace.o(13212258926592L, 98439);
    return paramArrayOfString;
  }
  
  public final Cursor a(String[] paramArrayOfString, String paramString, List<String> paramList)
  {
    GMTrace.i(13212124708864L, 98438);
    paramString = "select * ,rowid from rcontact " + e(paramString, null, paramList) + F(paramArrayOfString);
    paramList = paramString;
    if (paramArrayOfString != null)
    {
      paramList = paramString;
      if (paramArrayOfString.length > 0)
      {
        paramString = paramString + " order by 1=1 ";
        int j = paramArrayOfString.length;
        int i = 0;
        for (;;)
        {
          paramList = paramString;
          if (i >= j) {
            break;
          }
          paramList = paramArrayOfString[i];
          paramString = paramString + ",username='" + paramList + "' desc";
          i += 1;
        }
      }
    }
    v.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : " + paramList);
    paramArrayOfString = this.gUp.rawQuery(paramList, null);
    GMTrace.o(13212124708864L, 98438);
    return paramArrayOfString;
  }
  
  public final void a(ar.a parama)
  {
    GMTrace.i(13205145387008L, 98386);
    this.htP.a(parama, null);
    GMTrace.o(13205145387008L, 98386);
  }
  
  public final Cursor aJZ()
  {
    GMTrace.i(13214272192512L, 98454);
    Cursor localCursor = this.gUp.rawQuery("select * ,rowid from rcontact  where rowid = -1", null);
    GMTrace.o(13214272192512L, 98454);
    return localCursor;
  }
  
  public final int b(String paramString, x paramx)
  {
    GMTrace.i(13208635047936L, 98412);
    if ((bf.mA(paramString)) || (paramx == null) || (bf.mA(paramx.field_username)))
    {
      v.e("MicroMsg.ContactStorage", "update : wrong input!");
      GMTrace.o(13208635047936L, 98412);
      return 0;
    }
    v.d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + paramx.field_username + " enUsername: " + paramString);
    if (!T(paramx))
    {
      GMTrace.o(13208635047936L, 98412);
      return 1;
    }
    if (x.eO(paramx.field_username)) {
      paramx.setUsername(x.QQ(paramx.field_username));
    }
    paramx.dc(paramx.sZ());
    this.htP.by(paramx);
    this.htP.doNotify();
    v.d("MicroMsg.ContactStorage", "update : oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", new Object[] { paramString, paramx.field_username, Integer.valueOf(paramx.field_showHead), Integer.valueOf(paramx.field_verifyFlag) });
    ContentValues localContentValues = paramx.pv();
    int i = 0;
    x localx;
    int j;
    if (paramx.gTG <= 0L)
    {
      localx = new x(paramString);
      localx.setType(0);
      localx.setUsername("fake_" + bf.NA());
      localx.bX("fake_" + bf.NA());
      j = this.gUp.update(QV(paramString), localx.pv(), "username=?", new String[] { paramString });
      v.d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + QV(paramString) + " user :" + paramString + ", res:" + j);
      if (localContentValues.size() > 0) {
        i = (int)this.gUp.replace(QV(paramx.field_username), a.gTF.uvq, localContentValues);
      }
    }
    for (;;)
    {
      DX(paramx.field_username);
      if (!bf.mA(paramx.field_encryptUsername)) {
        DX(paramx.field_encryptUsername);
      }
      b(3, this, paramString);
      b(3, this, paramx.field_username);
      GMTrace.o(13208635047936L, 98412);
      return i;
      if (paramString.equals(paramx.field_username))
      {
        if (localContentValues.size() > 0)
        {
          i = this.gUp.update(QV(paramx.field_username), localContentValues, "rowid=?", new String[] { paramx.gTG });
          v.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", new Object[] { paramx.field_username, Integer.valueOf(i), Long.valueOf(paramx.gTG) });
        }
      }
      else
      {
        localx = new x(paramString);
        localx.setType(0);
        localx.setUsername("fake_" + bf.NA());
        localx.bX("fake_" + bf.NA());
        j = this.gUp.update(QV(paramString), localx.pv(), "username=?", new String[] { paramString });
        v.d("MicroMsg.ContactStorage", "delete " + QV(paramString) + " user :" + paramString + ", res:" + j);
        if (localContentValues.size() > 0) {
          i = this.gUp.update(QV(paramx.field_username), localContentValues, "rowid=?", new String[] { paramx.gTG });
        }
      }
    }
  }
  
  public final int b(String[] paramArrayOfString1, String... paramVarArgs)
  {
    GMTrace.i(13214003757056L, 98452);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(a.tt()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(a.tx()).append(" =0 and ");
    localStringBuilder.append("type & ").append(a.tu()).append(" =0 and ");
    localStringBuilder.append("verifyFlag & 8").append(" = 0 and ");
    localStringBuilder.append("( username not like '%@%')");
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
    {
      int j = paramArrayOfString1.length;
      i = 0;
      while (i < j)
      {
        String str = paramArrayOfString1[i];
        localStringBuilder.append(" and rcontact.username").append(" != '").append(str).append("'");
        i += 1;
      }
    }
    int i = 0;
    while (i < 4)
    {
      paramArrayOfString1 = paramVarArgs[i];
      localStringBuilder.append(" and rcontact.username").append(" != '").append(paramArrayOfString1).append("'");
      i += 1;
    }
    localStringBuilder.append(" or username = 'weixin").append("'");
    paramArrayOfString1 = localStringBuilder.toString();
    paramVarArgs = this.gUp.a(paramArrayOfString1, null, 2);
    if ((paramVarArgs != null) && (paramVarArgs.moveToFirst()))
    {
      i = paramVarArgs.getInt(0);
      paramVarArgs.close();
    }
    for (;;)
    {
      v.d("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d", new Object[] { paramArrayOfString1, Integer.valueOf(i) });
      GMTrace.o(13214003757056L, 98452);
      return i;
      i = 0;
    }
  }
  
  public final Cursor b(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13206487564288L, 98396);
    paramString1 = "select username from rcontact " + e(paramString1, paramString2, paramList1) + cg(paramList2) + bLm();
    v.v("MicroMsg.ContactStorage", paramString1);
    if (paramBoolean1)
    {
      paramString2 = "select username from rcontact " + i(paramList1, paramBoolean2) + bLn();
      v.v("MicroMsg.ContactStorage", "favourSql " + paramString1);
      paramString2 = this.gUp.a(paramString2, null, 4);
      paramString1 = this.gUp.a(paramString1, null, 4);
      if (((paramString2 instanceof com.tencent.mm.bj.a.f)) && ((paramString1 instanceof com.tencent.mm.bj.a.f)))
      {
        paramString1 = new com.tencent.mm.bj.a.e(new com.tencent.mm.bj.a.f[] { (com.tencent.mm.bj.a.f)paramString2, (com.tencent.mm.bj.a.f)paramString1 });
        GMTrace.o(13206487564288L, 98396);
        return paramString1;
      }
      paramString1 = com.tencent.mm.bj.c.bNy();
      GMTrace.o(13206487564288L, 98396);
      return paramString1;
    }
    paramString1 = this.gUp.rawQuery(paramString1, null);
    GMTrace.o(13206487564288L, 98396);
    return paramString1;
  }
  
  public final void b(ar.a parama)
  {
    GMTrace.i(13205279604736L, 98387);
    if (this.htP != null) {
      this.htP.remove(parama);
    }
    GMTrace.o(13205279604736L, 98387);
  }
  
  public final int[] b(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    GMTrace.i(13211453620224L, 98433);
    paramString1 = "select distinct showHead from rcontact " + e(paramString1, paramString2, paramList) + Ri(paramString3) + bLm();
    long l = System.currentTimeMillis();
    paramString1 = this.gUp.rawQuery(paramString1, null);
    v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramString1.getCount() >= 0) {}
    for (int i = paramString1.getCount();; i = 0)
    {
      v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
      paramString2 = new int[i];
      if (paramString1.getCount() <= 0) {
        break;
      }
      int j = 0;
      while (j < i)
      {
        paramString1.moveToPosition(j);
        paramString2[j] = paramString1.getInt(0);
        j += 1;
      }
    }
    paramString1.close();
    GMTrace.o(13211453620224L, 98433);
    return paramString2;
  }
  
  public final int[] b(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    GMTrace.i(13211319402496L, 98432);
    paramString1 = "select distinct showHead from rcontact " + e(paramString1, paramString2, paramList) + F(paramArrayOfString) + bLm();
    long l = System.currentTimeMillis();
    paramString1 = this.gUp.rawQuery(paramString1, null);
    v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramString1.getCount() >= 0) {}
    for (int i = paramString1.getCount();; i = 0)
    {
      v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - l));
      paramString2 = new int[i];
      if (paramString1.getCount() <= 0) {
        break;
      }
      int j = 0;
      while (j < i)
      {
        paramString1.moveToPosition(j);
        paramString2[j] = paramString1.getInt(0);
        j += 1;
      }
    }
    paramString1.close();
    GMTrace.o(13211319402496L, 98432);
    return paramString2;
  }
  
  public final List<String> bLg()
  {
    GMTrace.i(13209306136576L, 98417);
    Object localObject = "select username from rcontact where " + bLp();
    localObject = this.gUp.a((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    if (localObject == null)
    {
      GMTrace.o(13209306136576L, 98417);
      return localArrayList;
    }
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        localArrayList.add(((Cursor)localObject).getString(0));
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    GMTrace.o(13209306136576L, 98417);
    return localArrayList;
  }
  
  public final Cursor bLh()
  {
    GMTrace.i(13209440354304L, 98418);
    Object localObject = "select * ,rowid from rcontact  where " + new StringBuilder("type & ").append(a.tu()).append("=0 and username like '%@chatroom").append("'").toString();
    localObject = this.gUp.rawQuery((String)localObject, null);
    GMTrace.o(13209440354304L, 98418);
    return (Cursor)localObject;
  }
  
  public final Cursor bLi()
  {
    GMTrace.i(13209574572032L, 98419);
    Object localObject = "select * ,rowid from rcontact " + bLo() + " AND type & 256" + " !=0 " + bLm();
    v.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.gUp.rawQuery((String)localObject, null);
    GMTrace.o(13209574572032L, 98419);
    return (Cursor)localObject;
  }
  
  public final Cursor bLj()
  {
    GMTrace.i(13209708789760L, 98420);
    Object localObject = "select * ,rowid from rcontact  where " + uHd + " and verifyFlag & " + x.bKW() + " !=0 ";
    v.v("MicroMsg.ContactStorage", "dkbf:" + (String)localObject);
    localObject = this.gUp.rawQuery((String)localObject, null);
    GMTrace.o(13209708789760L, 98420);
    return (Cursor)localObject;
  }
  
  public final Cursor bLk()
  {
    GMTrace.i(13209843007488L, 98421);
    Object localObject = "select * ,rowid from rcontact " + bLo() + " AND " + uHd + " AND " + uHc + bLn();
    v.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.gUp.rawQuery((String)localObject, null);
    GMTrace.o(13209843007488L, 98421);
    return (Cursor)localObject;
  }
  
  public final int bLl()
  {
    int i = 0;
    GMTrace.i(13211050967040L, 98430);
    Object localObject = "select count(rowid) from rcontact " + e("@biz.contact", null, null);
    v.v("MicroMsg.ContactStorage", (String)localObject);
    localObject = this.gUp.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    GMTrace.o(13211050967040L, 98430);
    return i;
  }
  
  public final String bLn()
  {
    GMTrace.i(13213064232960L, 98445);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(" order by case when verifyFlag & " + x.bKW() + " != 0 then 0 else 1 end , showHead asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuffer)localObject).append(" else upper(quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    GMTrace.o(13213064232960L, 98445);
    return (String)localObject;
  }
  
  public final int c(String[] paramArrayOfString1, String... paramVarArgs)
  {
    GMTrace.i(13214137974784L, 98453);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select count(username) from rcontact where ");
    localStringBuilder.append("type & ").append(a.tt()).append(" !=0 and ");
    localStringBuilder.append("type & ").append(a.tx()).append(" =0 and ");
    localStringBuilder.append("type & ").append(a.tu()).append(" =0 and ");
    localStringBuilder.append("verifyFlag & 8").append(" = 0 and ");
    localStringBuilder.append("( username like '%@chatroom')");
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
    {
      int j = paramArrayOfString1.length;
      i = 0;
      while (i < j)
      {
        String str = paramArrayOfString1[i];
        localStringBuilder.append(" and rcontact.username").append(" != '").append(str).append("'");
        i += 1;
      }
    }
    int i = 0;
    while (i < 4)
    {
      paramArrayOfString1 = paramVarArgs[i];
      localStringBuilder.append(" and rcontact.username").append(" != '").append(paramArrayOfString1).append("'");
      i += 1;
    }
    paramArrayOfString1 = localStringBuilder.toString();
    paramVarArgs = this.gUp.a(paramArrayOfString1, null, 2);
    if ((paramVarArgs != null) && (paramVarArgs.moveToFirst()))
    {
      i = paramVarArgs.getInt(0);
      paramVarArgs.close();
    }
    for (;;)
    {
      v.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", new Object[] { paramArrayOfString1, Integer.valueOf(i) });
      GMTrace.o(13214137974784L, 98453);
      return i;
      i = 0;
    }
  }
  
  public final Cursor c(String paramString1, String paramString2, List<String> paramList)
  {
    GMTrace.i(13210782531584L, 98428);
    paramString1 = a(paramString1, paramString2, paramList, false, false);
    GMTrace.o(13210782531584L, 98428);
    return paramString1;
  }
  
  public final void c(String paramString, x paramx)
  {
    GMTrace.i(13208769265664L, 98413);
    if (paramString == null)
    {
      GMTrace.o(13208769265664L, 98413);
      return;
    }
    String str = paramString;
    if (x.eO(paramString)) {
      str = x.QQ(paramString);
    }
    paramx.dc(paramx.sZ());
    if (o.d(paramx))
    {
      paramx.dc(43);
      paramx.bS(com.tencent.mm.platformtools.c.mr(paramx.tK()));
      paramx.bT(com.tencent.mm.platformtools.c.mq(paramx.tK()));
      paramx.bV(com.tencent.mm.platformtools.c.mq(paramx.tL()));
      paramx.bW(paramx.tL());
      GMTrace.o(13208769265664L, 98413);
      return;
    }
    if (o.fu(paramx.field_username))
    {
      v.i("MicroMsg.ContactStorage", "update official account helper showhead %d", new Object[] { Integer.valueOf(31) });
      paramx.dc(31);
    }
    this.htP.by(paramx);
    this.htP.doNotify();
    v.d("MicroMsg.ContactStorage", "username=%s, showHead=%d, verifyFlag=%d", new Object[] { paramx.field_username, Integer.valueOf(paramx.field_showHead), Integer.valueOf(paramx.field_verifyFlag) });
    paramString = paramx.pv();
    if ((int)paramx.gTG > 0) {
      paramString.put("rowid", Integer.valueOf((int)paramx.gTG));
    }
    if (paramString.size() > 0) {
      this.gUp.update(QV(str), paramString, "username=?", new String[] { str });
    }
    GMTrace.o(13208769265664L, 98413);
  }
  
  public final int[] c(String paramString1, String paramString2, String paramString3, List<String> paramList)
  {
    GMTrace.i(13211722055680L, 98435);
    long l = System.currentTimeMillis();
    paramString1 = "select count(*) from rcontact " + e(paramString1, paramString2, paramList) + Ri(paramString3);
    paramString1 = paramString1 + " group by showHead";
    paramString3 = this.gUp.rawQuery(paramString1, null);
    v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    int j = paramString3.getCount();
    v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
    paramString1 = null;
    if (j > 0)
    {
      paramString2 = new int[j];
      int i = 0;
      for (;;)
      {
        paramString1 = paramString2;
        if (i >= j) {
          break;
        }
        paramString3.moveToPosition(i);
        paramString2[i] = paramString3.getInt(0);
        i += 1;
      }
    }
    paramString3.close();
    GMTrace.o(13211722055680L, 98435);
    return paramString1;
  }
  
  public final int[] c(String paramString1, String paramString2, String[] paramArrayOfString, List<String> paramList)
  {
    Object localObject = null;
    GMTrace.i(13211990491136L, 98437);
    paramString1 = "select count(*) from rcontact " + e(paramString1, paramString2, paramList) + F(paramArrayOfString);
    paramString1 = paramString1 + " group by showHead";
    paramArrayOfString = this.gUp.rawQuery(paramString1, null);
    paramString1 = (String)localObject;
    if (paramArrayOfString.getCount() > 0)
    {
      int j = paramArrayOfString.getCount();
      paramString2 = new int[j];
      int i = 0;
      for (;;)
      {
        paramString1 = paramString2;
        if (i >= j) {
          break;
        }
        paramArrayOfString.moveToPosition(i);
        paramString2[i] = paramArrayOfString.getInt(0);
        i += 1;
      }
    }
    paramArrayOfString.close();
    GMTrace.o(13211990491136L, 98437);
    return paramString1;
  }
  
  public final Cursor cc(List<String> paramList)
  {
    int i = 0;
    GMTrace.i(17857131839488L, 133046);
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,type from rcontact  where ";
      label31:
      if (i >= paramList.size()) {
        break label152;
      }
      if (i == paramList.size() - 1) {
        break label107;
      }
    }
    label107:
    for (String str = str + "username = '" + (String)paramList.get(i) + "' OR ";; str = str + "username = '" + (String)paramList.get(i) + "'")
    {
      i += 1;
      break label31;
      bool = false;
      break;
    }
    label152:
    paramList = str + bLm();
    paramList = this.gUp.rawQuery(paramList, null);
    GMTrace.o(17857131839488L, 133046);
    return paramList;
  }
  
  public final Cursor cd(List<String> paramList)
  {
    int i = 0;
    GMTrace.i(13206353346560L, 98395);
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact  where ";
      label31:
      if (i >= paramList.size()) {
        break label152;
      }
      if (i == paramList.size() - 1) {
        break label107;
      }
    }
    label107:
    for (String str = str + "username = '" + (String)paramList.get(i) + "' OR ";; str = str + "username = '" + (String)paramList.get(i) + "'")
    {
      i += 1;
      break label31;
      bool = false;
      break;
    }
    label152:
    paramList = str + bLm();
    paramList = this.gUp.rawQuery(paramList, null);
    GMTrace.o(13206353346560L, 98395);
    return paramList;
  }
  
  public final Cursor ce(List<String> paramList)
  {
    int i = 0;
    GMTrace.i(13208903483392L, 98414);
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select * ,rowid from rcontact  where ";
      label31:
      if (i >= paramList.size()) {
        break label152;
      }
      if (i == paramList.size() - 1) {
        break label107;
      }
    }
    label107:
    for (String str = str + "username = '" + (String)paramList.get(i) + "' OR ";; str = str + "username = '" + (String)paramList.get(i) + "'")
    {
      i += 1;
      break label31;
      bool = false;
      break;
    }
    label152:
    paramList = str + bLm();
    paramList = this.gUp.rawQuery(paramList, null);
    GMTrace.o(13208903483392L, 98414);
    return paramList;
  }
  
  public final Cursor cf(List<String> paramList)
  {
    int j = 0;
    GMTrace.i(13209037701120L, 98415);
    boolean bool;
    if (paramList.size() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      str = "select * ,rowid from rcontact  where (";
      i = 0;
      label35:
      if (i >= paramList.size()) {
        break label157;
      }
      if (i == paramList.size() - 1) {
        break label112;
      }
    }
    label112:
    for (String str = str + "username = '" + (String)paramList.get(i) + "' OR ";; str = str + "username = '" + (String)paramList.get(i) + "'")
    {
      i += 1;
      break label35;
      bool = false;
      break;
    }
    label157:
    str = str + ") order by case username ";
    int i = j;
    while (i < paramList.size())
    {
      str = str + " when '" + (String)paramList.get(i) + "' then " + i;
      i += 1;
    }
    paramList = str + " end";
    v.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:" + paramList);
    paramList = this.gUp.rawQuery(paramList, null);
    GMTrace.o(13209037701120L, 98415);
    return paramList;
  }
  
  public final Cursor ci(List<String> paramList)
  {
    GMTrace.i(13210514096128L, 98426);
    paramList = "select * ,rowid from rcontact where (" + uHd + ") and (" + ch(paramList) + ")" + bLn();
    paramList = this.gUp.rawQuery(paramList, null);
    GMTrace.o(13210514096128L, 98426);
    return paramList;
  }
  
  public final Cursor cj(List<String> paramList)
  {
    GMTrace.i(13210648313856L, 98427);
    paramList = "select * ,rowid from rcontact " + i(paramList, false) + bLn();
    v.v("MicroMsg.ContactStorage", "favourSql " + paramList);
    paramList = this.gUp.rawQuery(paramList, null);
    GMTrace.o(13210648313856L, 98427);
    return paramList;
  }
  
  public final List<String> ck(List<String> paramList)
  {
    GMTrace.i(13211185184768L, 98431);
    if (paramList.isEmpty())
    {
      v.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
      paramList = new LinkedList();
      GMTrace.o(13211185184768L, 98431);
      return paramList;
    }
    long l = bf.NB();
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("username='").append((String)paramList.get(0)).append("'");
    int i = 1;
    while (i < paramList.size())
    {
      ((StringBuilder)localObject).append(" or username='").append((String)paramList.get(i)).append("'");
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showHead asc, ");
    localStringBuilder.append("pyInitial asc, ");
    localStringBuilder.append("quanPin asc, ");
    localStringBuilder.append("nickname asc, ");
    localStringBuilder.append("username asc ");
    localObject = String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[] { "username", "rcontact", ((StringBuilder)localObject).toString(), "type", Integer.valueOf(a.tt()), localStringBuilder.toString() });
    v.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", new Object[] { localObject });
    localObject = this.gUp.a((String)localObject, null, 2);
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext()) {
        localLinkedList.add(((Cursor)localObject).getString(0));
      }
      ((Cursor)localObject).close();
    }
    v.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", new Object[] { Long.valueOf(bf.aB(l)), paramList, localLinkedList.toString() });
    GMTrace.o(13211185184768L, 98431);
    return localLinkedList;
  }
  
  public final int[] cl(List<String> paramList)
  {
    GMTrace.i(13211587837952L, 98434);
    paramList = "select distinct showHead from rcontact  where (" + ch(paramList) + ") " + bLm();
    long l = System.currentTimeMillis();
    paramList = this.gUp.rawQuery(paramList, null);
    v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    if (paramList.getCount() >= 0) {}
    int[] arrayOfInt;
    for (int i = paramList.getCount();; i = 0)
    {
      v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
      arrayOfInt = new int[i];
      if (paramList.getCount() <= 0) {
        break;
      }
      int j = 0;
      while (j < i)
      {
        paramList.moveToPosition(j);
        arrayOfInt[j] = paramList.getInt(0);
        j += 1;
      }
    }
    paramList.close();
    GMTrace.o(13211587837952L, 98434);
    return arrayOfInt;
  }
  
  public final int[] cm(List<String> paramList)
  {
    int[] arrayOfInt = null;
    GMTrace.i(13211856273408L, 98436);
    long l = System.currentTimeMillis();
    paramList = "select count(*) from rcontact " + "where " + ch(paramList);
    paramList = paramList + " group by showHead";
    Cursor localCursor = this.gUp.a(paramList, null, 2);
    v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - l));
    l = System.currentTimeMillis();
    int j = localCursor.getCount();
    v.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - l));
    paramList = arrayOfInt;
    if (j > 0)
    {
      arrayOfInt = new int[j];
      int i = 0;
      for (;;)
      {
        paramList = arrayOfInt;
        if (i >= j) {
          break;
        }
        localCursor.moveToPosition(i);
        arrayOfInt[i] = localCursor.getInt(0);
        i += 1;
      }
    }
    localCursor.close();
    GMTrace.o(13211856273408L, 98436);
    return paramList;
  }
  
  public final Cursor d(String paramString1, String paramString2, List<String> paramList)
  {
    GMTrace.i(13210916749312L, 98429);
    paramString1 = "select * ,rowid from rcontact " + e(paramString1, paramString2, paramList) + bLm();
    v.v("MicroMsg.ContactStorage", paramString1);
    paramString1 = this.gUp.rawQuery(paramString1, null);
    GMTrace.o(13210916749312L, 98429);
    return paramString1;
  }
  
  public final String e(String paramString1, String paramString2, List<String> paramList)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool1 = true;
    GMTrace.i(13213869539328L, 98451);
    if ((paramString1 == null) || (paramString1.equals("@all.android"))) {
      paramString1 = "" + E(true, false);
    }
    for (;;)
    {
      String str1 = "";
      paramString2 = str1;
      if (paramList == null) {
        break;
      }
      paramString2 = str1;
      if (paramList.size() <= 0) {
        break;
      }
      paramList = paramList.iterator();
      for (paramString2 = ""; paramList.hasNext(); paramString2 = paramString2 + " and username != '" + str1 + "'") {
        str1 = (String)paramList.next();
      }
      if (paramString1.equals("@all.contact.android"))
      {
        paramString1 = "" + bLo();
      }
      else if (paramString1.equals("@all.chatroom.contact"))
      {
        paramString1 = new StringBuilder().append("");
        paramString2 = "(type & " + a.tt() + "!=0 and username like '%@chatroom" + "')";
        paramString2 = " where (" + paramString2 + ") and ";
        paramString1 = new StringBuilder().append(paramString2).append("type & ").append(a.tx()).append("=0 ").toString();
      }
      else
      {
        if (paramString1.equals("@all.contact.without.chatroom"))
        {
          paramString1 = new StringBuilder().append("");
          paramString2 = E(false, false);
          if ((paramString2 != null) && (paramString2.length() > 0)) {}
          for (;;)
          {
            Assert.assertTrue(bool1);
            str1 = " or (" + bLq() + ')';
            paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
            break;
            bool1 = false;
          }
        }
        if (paramString1.equals("@black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(a.tu()).append("!=0").toString();
        }
        else if (paramString1.equals("@werun.black.android"))
        {
          paramString1 = "" + new StringBuilder(" where type & ").append(a.tv()).append("!=0").toString();
        }
        else if (paramString1.equals("@t.qq.com"))
        {
          paramString1 = "" + new StringBuilder(" where username like '%").append("@t.qq.com").append("'").toString();
        }
        else
        {
          if (paramString1.equals("@domain.android"))
          {
            paramString1 = new StringBuilder().append("");
            str1 = E(true, false);
            if ((str1 != null) && (str1.length() > 0)) {}
            for (bool1 = bool2;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              paramString1 = new StringBuilder().append(str1).append(" and domainList like '%").append(paramString2).append("%'").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = E(false, false);
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool3;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + bLp() + ')';
              String str2 = " or (" + bLq() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(str2).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.no.verify.biz.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.tt() + " !=0 ";
            paramString2 = " where (" + paramString2 + ") and ";
            paramString2 = paramString2 + "type & " + a.tx() + " =0 and ";
            paramString2 = paramString2 + "type & " + a.tu() + " =0 and ";
            paramString2 = paramString2 + "verifyFlag & " + x.bKW() + " =0";
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool4;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + bLp() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@micromsg.with.all.biz.qq.com"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.tt() + " !=0 ";
            paramString2 = " where (" + paramString2 + ") and ";
            paramString2 = paramString2 + "type & " + a.tx() + " =0 and ";
            paramString2 = paramString2 + "type & " + a.tu() + " =0";
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool5;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              str1 = " or (" + bLp() + ')';
              paramString1 = new StringBuilder().append(paramString2).append(" and ( username not like '%@%'").append(str1).append(")").toString();
              break;
            }
          }
          if (paramString1.equals("@qqim"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = E(false, false);
            if ((paramString2 != null) && (paramString2.length() > 0)) {}
            for (bool1 = bool6;; bool1 = false)
            {
              Assert.assertTrue(bool1);
              paramString1 = new StringBuilder().append(paramString2).append(" and username like '%").append("@qqim").append("'").toString();
              break;
            }
          }
          if (paramString1.equals("@all.chatroom"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.tt() + " !=0";
            paramString2 = paramString2 + " or type & 2 !=0";
            paramString2 = paramString2 + " or type & 4 !=0";
            paramString2 = paramString2 + " or 1";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@verify.contact"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.tt() + " != 0 and ";
            paramString2 = paramString2 + "verifyFlag & " + x.bKV() + " != 0";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@biz.contact"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.tt() + " != 0 and ";
            paramString2 = paramString2 + "verifyFlag & " + x.bKW() + " != 0";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else if (paramString1.equals("@all.weixin.android"))
          {
            paramString1 = new StringBuilder().append("");
            paramString2 = "type & " + a.tt() + " != 0 or  (username not like '%@qqim" + "' and username not like '%@qr" + "' and username not like '%@bottle" + "' and username not like '%@fb" + "' and username not like '%@google" + "' and username not like '%@t.qq.com" + "' and username not like '%@t.sina.com" + "' and username not like '%@t.sina.com" + "')";
            paramString1 = new StringBuilder(" where (").append(paramString2).append(") ").toString();
          }
          else
          {
            v.d("MicroMsg.ContactStorage", "unknow role type");
            paramString1 = "" + E(false, false);
          }
        }
      }
    }
    paramString1 = paramString1 + paramString2;
    GMTrace.o(13213869539328L, 98451);
    return paramString1;
  }
  
  public final x ez(long paramLong)
  {
    x localx = null;
    GMTrace.i(13207024435200L, 98400);
    if (paramLong <= 0L)
    {
      GMTrace.o(13207024435200L, 98400);
      return null;
    }
    Object localObject = "select * ,rowid from rcontact  where rowid=" + paramLong;
    localObject = this.gUp.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localx = new x();
      localx.b((Cursor)localObject);
      O(localx);
    }
    ((Cursor)localObject).close();
    if (localx != null) {
      localx.bKZ();
    }
    GMTrace.o(13207024435200L, 98400);
    return localx;
  }
  
  public final Cursor h(List<String> paramList, boolean paramBoolean)
  {
    GMTrace.i(13210379878400L, 98425);
    String str = "select * ,rowid from rcontact  where " + ch(paramList);
    paramList = str;
    if (paramBoolean) {
      paramList = str + " " + bLm();
    }
    v.d("MicroMsg.ContactStorage", "sql " + paramList);
    paramList = this.gUp.rawQuery(paramList, null);
    GMTrace.o(13210379878400L, 98425);
    return paramList;
  }
  
  public final String i(List<String> paramList, boolean paramBoolean)
  {
    GMTrace.i(13213735321600L, 98450);
    String str2 = E(false, paramBoolean) + " AND " + uHd;
    String str1 = "";
    Object localObject = str1;
    if (paramList != null)
    {
      localObject = str1;
      if (paramList.size() > 0)
      {
        localObject = paramList.iterator();
        for (paramList = ""; ((Iterator)localObject).hasNext(); paramList = paramList + " AND username != '" + str1 + "'") {
          str1 = (String)((Iterator)localObject).next();
        }
        localObject = paramList;
      }
    }
    paramList = str2 + (String)localObject;
    GMTrace.o(13213735321600L, 98450);
    return paramList;
  }
  
  public final int w(String paramString, byte[] paramArrayOfByte)
  {
    int i = -1;
    GMTrace.i(13207963959296L, 98407);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
      GMTrace.o(13207963959296L, 98407);
      return -1;
    }
    y localy = new y();
    localy.field_cmdbuf = paramArrayOfByte;
    localy.field_username = paramString;
    int j = (int)this.gUp.replace("ContactCmdBuf", "username", localy.pv());
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      v.d("MicroMsg.ContactStorage", "setCmdbuf user:%s buf:%d result:%d", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
      GMTrace.o(13207963959296L, 98407);
      return j;
      i = paramArrayOfByte.length;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */