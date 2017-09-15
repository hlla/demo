package com.tencent.mm.plugin.w;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.gt;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.n;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class a
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.b.b
{
  private static HashMap<Integer, g.c> gJh;
  private static a odF;
  private i jGV;
  private com.tencent.mm.pluginsdk.model.app.c jGW;
  private com.tencent.mm.pluginsdk.model.app.e odG;
  private com.tencent.mm.pluginsdk.model.app.h odH;
  private m odI;
  private d odJ;
  private com.tencent.mm.sdk.b.c odK;
  
  static
  {
    GMTrace.i(18738271223808L, 139611);
    HashMap localHashMap = new HashMap();
    gJh = localHashMap;
    localHashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(18736123740160L, 139595);
        String[] arrayOfString = com.tencent.mm.pluginsdk.model.app.c.gUn;
        GMTrace.o(18736123740160L, 139595);
        return arrayOfString;
      }
    });
    gJh.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new g.c()
    {
      public final String[] pP()
      {
        GMTrace.i(18735855304704L, 139593);
        String[] arrayOfString = i.gUn;
        GMTrace.o(18735855304704L, 139593);
        return arrayOfString;
      }
    });
    GMTrace.o(18738271223808L, 139611);
  }
  
  private a()
  {
    GMTrace.i(18736257957888L, 139596);
    this.odK = new com.tencent.mm.sdk.b.c() {};
    a.a.a(new com.tencent.mm.plugin.w.a.a()
    {
      public final com.tencent.mm.pluginsdk.model.app.f Cj(String paramAnonymousString)
      {
        GMTrace.i(18731828772864L, 139563);
        paramAnonymousString = a.aRk().Md(paramAnonymousString);
        GMTrace.o(18731828772864L, 139563);
        return paramAnonymousString;
      }
      
      public final void Ck(String paramAnonymousString)
      {
        GMTrace.i(18732499861504L, 139568);
        a.aRj().Mb(paramAnonymousString);
        GMTrace.o(18732499861504L, 139568);
      }
      
      public final void Z(LinkedList<String> paramAnonymousLinkedList)
      {
        GMTrace.i(18733170950144L, 139573);
        a.aRj().at(paramAnonymousLinkedList);
        GMTrace.o(18733170950144L, 139573);
      }
      
      public final Bitmap a(String paramAnonymousString, int paramAnonymousInt, float paramAnonymousFloat)
      {
        GMTrace.i(18732231426048L, 139566);
        a.aRk();
        if ((paramAnonymousString == null) || (paramAnonymousString.length() == 0))
        {
          v.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
          GMTrace.o(18732231426048L, 139566);
          return null;
        }
        if (paramAnonymousString.equals("wx7fa037cc7dfabad5"))
        {
          paramAnonymousString = BitmapFactory.decodeResource(aa.getContext().getResources(), a.c.bpw);
          GMTrace.o(18732231426048L, 139566);
          return paramAnonymousString;
        }
        paramAnonymousString = i.cw(paramAnonymousString, paramAnonymousInt);
        if (!com.tencent.mm.a.e.aO(paramAnonymousString))
        {
          v.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + paramAnonymousString + ", iconType = " + paramAnonymousInt);
          GMTrace.o(18732231426048L, 139566);
          return null;
        }
        paramAnonymousString = BackwardSupportUtil.b.c(paramAnonymousString, paramAnonymousFloat);
        GMTrace.o(18732231426048L, 139566);
        return paramAnonymousString;
      }
      
      public final i aRm()
      {
        GMTrace.i(18733036732416L, 139572);
        i locali = a.aRk();
        GMTrace.o(18733036732416L, 139572);
        return locali;
      }
      
      public final Cursor aRn()
      {
        GMTrace.i(18733439385600L, 139575);
        Object localObject = a.aRk();
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("select * from AppInfo");
        localStringBuilder.append(" where ");
        localStringBuilder.append("serviceAppType > 0");
        localObject = ((i)localObject).rawQuery(localStringBuilder.toString(), new String[0]);
        if (localObject == null)
        {
          v.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
          GMTrace.o(18733439385600L, 139575);
          return null;
        }
        v.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
        GMTrace.o(18733439385600L, 139575);
        return (Cursor)localObject;
      }
      
      public final void bv(String paramAnonymousString, int paramAnonymousInt)
      {
        GMTrace.i(18732365643776L, 139567);
        a.aRi().cu(paramAnonymousString, paramAnonymousInt);
        GMTrace.o(18732365643776L, 139567);
      }
      
      public final void c(com.tencent.mm.pluginsdk.model.app.f paramAnonymousf)
      {
        GMTrace.i(18732634079232L, 139569);
        i locali = a.aRk();
        if ((paramAnonymousf != null) && (paramAnonymousf.field_status != 5))
        {
          paramAnonymousf.field_status = 3;
          v.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", new Object[] { paramAnonymousf.field_packageName });
          locali.a(paramAnonymousf, new String[0]);
        }
        GMTrace.o(18732634079232L, 139569);
      }
      
      public final Cursor cG(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        GMTrace.i(18733305167872L, 139574);
        Cursor localCursor = a.aRk().cG(paramAnonymousInt1, paramAnonymousInt2);
        GMTrace.o(18733305167872L, 139574);
        return localCursor;
      }
      
      public final void d(com.tencent.mm.pluginsdk.model.app.f paramAnonymousf)
      {
        GMTrace.i(18732768296960L, 139570);
        i locali = a.aRk();
        if ((paramAnonymousf == null) || (paramAnonymousf.field_status != 3))
        {
          GMTrace.o(18732768296960L, 139570);
          return;
        }
        paramAnonymousf.field_status = 4;
        locali.a(paramAnonymousf, new String[0]);
        GMTrace.o(18732768296960L, 139570);
      }
      
      public final void e(com.tencent.mm.pluginsdk.model.app.f paramAnonymousf)
      {
        GMTrace.i(18732902514688L, 139571);
        a.aRk().a(paramAnonymousf, new String[0]);
        GMTrace.o(18732902514688L, 139571);
      }
      
      public final Cursor m(int[] paramAnonymousArrayOfInt)
      {
        GMTrace.i(18732097208320L, 139565);
        i locali = a.aRk();
        String str = "select * from AppInfo where ";
        int i = 0;
        while (i <= 0)
        {
          str = str + " status = " + paramAnonymousArrayOfInt[0];
          i += 1;
        }
        paramAnonymousArrayOfInt = locali.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
        if (paramAnonymousArrayOfInt == null)
        {
          v.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          GMTrace.o(18732097208320L, 139565);
          return null;
        }
        GMTrace.o(18732097208320L, 139565);
        return paramAnonymousArrayOfInt;
      }
      
      public final Cursor qP(int paramAnonymousInt)
      {
        GMTrace.i(18731962990592L, 139564);
        Cursor localCursor = a.aRk().rawQuery("select * from AppInfo where status = 5" + " order by modifyTime asc", new String[0]);
        if (localCursor == null)
        {
          v.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
          GMTrace.o(18731962990592L, 139564);
          return null;
        }
        GMTrace.o(18731962990592L, 139564);
        return localCursor;
      }
    });
    GMTrace.o(18736257957888L, 139596);
  }
  
  public static d aBz()
  {
    GMTrace.i(18737465917440L, 139605);
    com.tencent.mm.kernel.h.vG().uQ();
    if (aRh().odJ == null) {
      aRh().odJ = new d();
    }
    d locald = aRh().odJ;
    GMTrace.o(18737465917440L, 139605);
    return locald;
  }
  
  public static a aRh()
  {
    GMTrace.i(18736392175616L, 139597);
    if (odF == null) {}
    try
    {
      if (odF == null) {
        odF = new a();
      }
      a locala = odF;
      GMTrace.o(18736392175616L, 139597);
      return locala;
    }
    finally {}
  }
  
  public static com.tencent.mm.pluginsdk.model.app.e aRi()
  {
    GMTrace.i(18736929046528L, 139601);
    com.tencent.mm.kernel.h.vG().uQ();
    if (aRh().odG == null) {
      aRh().odG = new com.tencent.mm.pluginsdk.model.app.e();
    }
    com.tencent.mm.pluginsdk.model.app.e locale = aRh().odG;
    GMTrace.o(18736929046528L, 139601);
    return locale;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.h aRj()
  {
    GMTrace.i(18737063264256L, 139602);
    com.tencent.mm.kernel.h.vG().uQ();
    if (aRh().odH == null) {
      aRh().odH = new com.tencent.mm.pluginsdk.model.app.h();
    }
    com.tencent.mm.pluginsdk.model.app.h localh = aRh().odH;
    GMTrace.o(18737063264256L, 139602);
    return localh;
  }
  
  public static i aRk()
  {
    GMTrace.i(18737197481984L, 139603);
    com.tencent.mm.kernel.h.vG().uQ();
    if (aRh().jGV == null) {
      aRh().jGV = new i(com.tencent.mm.kernel.h.vI().gXW);
    }
    i locali = aRh().jGV;
    GMTrace.o(18737197481984L, 139603);
    return locali;
  }
  
  public static m aRl()
  {
    GMTrace.i(18737331699712L, 139604);
    com.tencent.mm.kernel.h.vG().uQ();
    if (aRh().odI == null) {
      aRh().odI = new m();
    }
    m localm = aRh().odI;
    GMTrace.o(18737331699712L, 139604);
    return localm;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.c abF()
  {
    GMTrace.i(18736794828800L, 139600);
    com.tencent.mm.kernel.h.vG().uQ();
    if (aRh().jGW == null) {
      aRh().jGW = new com.tencent.mm.pluginsdk.model.app.c(com.tencent.mm.kernel.h.vI().gXW);
    }
    com.tencent.mm.pluginsdk.model.app.c localc = aRh().jGW;
    GMTrace.o(18736794828800L, 139600);
    return localc;
  }
  
  public static String xm()
  {
    GMTrace.i(18736660611072L, 139599);
    String str = com.tencent.mm.kernel.h.vI().gXV + "openapi/";
    GMTrace.o(18736660611072L, 139599);
    return str;
  }
  
  public HashMap<Integer, g.c> collectDatabaseFactory()
  {
    GMTrace.i(18737868570624L, 139608);
    HashMap localHashMap = gJh;
    GMTrace.o(18737868570624L, 139608);
    return localHashMap;
  }
  
  public List<String> collectStoragePaths()
  {
    GMTrace.i(18736526393344L, 139598);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "openapi/" });
    GMTrace.o(18736526393344L, 139598);
    return localLinkedList;
  }
  
  public void onAccountInitialized(e.f paramf)
  {
    GMTrace.i(18737600135168L, 139606);
    com.tencent.mm.u.x.a.hly = aRj();
    com.tencent.mm.sdk.b.a.uql.b(this.odK);
    GMTrace.o(18737600135168L, 139606);
  }
  
  public void onAccountRelease()
  {
    GMTrace.i(18737734352896L, 139607);
    Object localObject = aRh().odH;
    if (localObject != null)
    {
      com.tencent.mm.kernel.h.vH().gXs.b(231, (com.tencent.mm.y.e)localObject);
      aBz().b(7, (t)localObject);
    }
    localObject = aRh().odG;
    if (localObject != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.e)localObject).sBt.clear();
      ((com.tencent.mm.pluginsdk.model.app.e)localObject).pkz.clear();
      ((com.tencent.mm.pluginsdk.model.app.e)localObject).sBu.clear();
    }
    localObject = aRh().odI;
    if (localObject != null)
    {
      v.d("MicroMsg.AppSettingService", "stop service");
      ((m)localObject).sBT.clear();
      aBz().b(1, (t)localObject);
    }
    if (this.odJ != null)
    {
      localObject = this.odJ;
      com.tencent.mm.kernel.h.vH().gXs.b(452, (com.tencent.mm.y.e)localObject);
      ((d)localObject).hsM.clear();
    }
    if (aRh().jGV != null) {
      aRh().jGV.sBL.clear();
    }
    com.tencent.mm.sdk.b.a.uql.c(this.odK);
    GMTrace.o(18737734352896L, 139607);
  }
  
  public void onDataBaseClosed(g paramg1, g paramg2)
  {
    GMTrace.i(18738137006080L, 139610);
    this.jGW = null;
    this.jGV = null;
    GMTrace.o(18738137006080L, 139610);
  }
  
  public void onDataBaseOpened(g paramg1, g paramg2)
  {
    GMTrace.i(18738002788352L, 139609);
    GMTrace.o(18738002788352L, 139609);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/w/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */