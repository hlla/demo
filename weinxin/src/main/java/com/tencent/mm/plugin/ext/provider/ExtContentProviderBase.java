package com.tencent.mm.plugin.ext.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.y.n;
import java.util.HashMap;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtContentProviderBase
  extends ContentProvider
{
  protected static boolean jNF;
  private static HashMap<String, Long> loO;
  public MatrixCursor jND;
  private long loJ;
  private String loK;
  public String loL;
  private String[] loM;
  private int loN;
  
  static
  {
    GMTrace.i(5735123517440L, 42730);
    jNF = false;
    loO = new HashMap();
    GMTrace.o(5735123517440L, 42730);
  }
  
  public ExtContentProviderBase()
  {
    GMTrace.i(5732304945152L, 42709);
    this.jND = new MatrixCursor(new String[0]);
    this.loJ = bf.NB();
    this.loL = "";
    this.loN = 0;
    GMTrace.o(5732304945152L, 42709);
  }
  
  private int aqQ()
  {
    GMTrace.i(5733647122432L, 42719);
    int i = (int)bf.aB(this.loJ);
    GMTrace.o(5733647122432L, 42719);
    return i;
  }
  
  private void bX(Context paramContext)
  {
    GMTrace.i(5734855081984L, 42728);
    if (paramContext == null)
    {
      v.w("MicroMsg.ExtContentProviderBase", "in initCallerPkgName(), context == null");
      GMTrace.o(5734855081984L, 42728);
      return;
    }
    v.i("MicroMsg.ExtContentProviderBase", "Binder.getCallingUid() = " + Binder.getCallingUid());
    this.loM = paramContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
    if (this.loM == null) {
      v.w("MicroMsg.ExtContentProviderBase", "m_pkgs == null");
    }
    GMTrace.o(5734855081984L, 42728);
  }
  
  private static String f(Uri paramUri)
  {
    GMTrace.i(5734452428800L, 42725);
    if (paramUri == null)
    {
      GMTrace.o(5734452428800L, 42725);
      return "";
    }
    paramUri = bf.mz(paramUri.getQueryParameter("appid"));
    GMTrace.o(5734452428800L, 42725);
    return paramUri;
  }
  
  public static MatrixCursor ma(int paramInt)
  {
    GMTrace.i(5734989299712L, 42729);
    v.i("MicroMsg.ExtContentProviderBase", "returnMatrix = " + paramInt);
    MatrixCursor localMatrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.loq);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt) });
    GMTrace.o(5734989299712L, 42729);
    return localMatrixCursor;
  }
  
  protected final void a(Uri paramUri, Context paramContext, int paramInt)
  {
    GMTrace.i(5733915557888L, 42721);
    this.loL = f(paramUri);
    bX(paramContext);
    this.loN = paramInt;
    this.loJ = bf.NB();
    GMTrace.o(5733915557888L, 42721);
  }
  
  public final void a(Uri paramUri, Context paramContext, int paramInt, String[] paramArrayOfString)
  {
    GMTrace.i(5734049775616L, 42722);
    this.loL = f(paramUri);
    if (paramArrayOfString == null) {
      bX(paramContext);
    }
    for (;;)
    {
      this.loN = paramInt;
      this.loJ = bf.NB();
      GMTrace.o(5734049775616L, 42722);
      return;
      this.loM = paramArrayOfString;
    }
  }
  
  protected final void a(Uri paramUri, Context paramContext, UriMatcher paramUriMatcher)
  {
    GMTrace.i(5733781340160L, 42720);
    this.loL = f(paramUri);
    bX(paramContext);
    if (paramUriMatcher != null)
    {
      this.loN = paramUriMatcher.match(paramUri);
      if (this.loN < 0) {
        this.loN = 0;
      }
    }
    this.loJ = bf.NB();
    GMTrace.o(5733781340160L, 42720);
  }
  
  public final boolean acE()
  {
    GMTrace.i(5734318211072L, 42724);
    try
    {
      v.i("MicroMsg.ExtContentProviderBase", "checkIsLogin()");
      if (!jNF)
      {
        final com.tencent.mm.pluginsdk.f.a.a locala = new com.tencent.mm.pluginsdk.f.a.a();
        locala.b(4000L, new Runnable()
        {
          public final void run()
          {
            GMTrace.i(5729083719680L, 42685);
            try
            {
              boolean bool = ap.zb();
              if (!bool)
              {
                GMTrace.o(5729083719680L, 42685);
                return;
              }
              ap.vd().a(new bb(new bb.a()
              {
                public final void a(e paramAnonymous2e)
                {
                  GMTrace.i(5726936236032L, 42669);
                  v.i("MicroMsg.ExtContentProviderBase", "checkIsLogin() onSceneEnd()");
                  ExtContentProviderBase.1.this.jNN.countDown();
                  GMTrace.o(5726936236032L, 42669);
                }
              }), 0);
              GMTrace.o(5729083719680L, 42685);
              return;
            }
            catch (Exception localException)
            {
              v.e("MicroMsg.ExtContentProviderBase", "exception in NetSceneLocalProxy");
              locala.countDown();
              GMTrace.o(5729083719680L, 42685);
            }
          }
        });
      }
      if ((ap.zb()) && (ap.za()) && (!ap.uP())) {}
      for (jNF = true;; jNF = false)
      {
        v.i("MicroMsg.ExtContentProviderBase", "hasLogin = " + jNF);
        boolean bool = jNF;
        GMTrace.o(5734318211072L, 42724);
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      v.w("MicroMsg.ExtContentProviderBase", localException.getMessage());
      v.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException, "", new Object[0]);
      GMTrace.o(5734318211072L, 42724);
    }
  }
  
  public final String aqR()
  {
    GMTrace.i(5734183993344L, 42723);
    if (!bf.mA(this.loK))
    {
      str = this.loK;
      GMTrace.o(5734183993344L, 42723);
      return str;
    }
    if ((this.loM == null) || (this.loM.length <= 0))
    {
      GMTrace.o(5734183993344L, 42723);
      return "";
    }
    String str = this.loM[0];
    GMTrace.o(5734183993344L, 42723);
    return str;
  }
  
  public final int aqS()
  {
    GMTrace.i(5734720864256L, 42727);
    if (bf.mA(this.loL))
    {
      v.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      GMTrace.o(5734720864256L, 42727);
      return 7;
    }
    if ((this.loM == null) || (this.loM.length <= 0))
    {
      v.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      GMTrace.o(5734720864256L, 42727);
      return 6;
    }
    for (;;)
    {
      try
      {
        localf = com.tencent.mm.pluginsdk.model.app.g.aJ(this.loL, true);
        if (localf == null)
        {
          v.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
          GMTrace.o(5734720864256L, 42727);
          return 13;
        }
        if (localf.field_status == 3)
        {
          v.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localf.field_packageName });
          i = 10;
          k = i;
        }
      }
      catch (Exception localException2)
      {
        f localf;
        int k;
        Object localObject1;
        Object localObject2;
        int i = 0;
        continue;
        int j = 0;
        continue;
        i += 1;
        continue;
      }
      try
      {
        localObject1 = Long.valueOf(bf.a((Long)loO.get(this.loL), 0L));
        k = i;
        v.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { localObject1, Long.valueOf(System.currentTimeMillis()) });
        k = i;
        if (System.currentTimeMillis() - ((Long)localObject1).longValue() > 3600000L)
        {
          k = i;
          v.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.loL });
          k = i;
          a.a.aRo().Ck(this.loL);
          k = i;
          loO.put(this.loL, Long.valueOf(System.currentTimeMillis()));
        }
        GMTrace.o(5734720864256L, 42727);
        return i;
        localObject1 = this.loM;
        j = localObject1.length;
        i = 0;
        if (i < j)
        {
          localObject2 = localObject1[i];
          if ((!((String)localObject2).equals(localf.field_packageName)) || (!p.b(aa.getContext(), localf, (String)localObject2))) {
            continue;
          }
          v.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject2 });
        }
      }
      catch (Exception localException1)
      {
        try
        {
          this.loK = ((String)localObject2);
          j = 1;
          i = j;
          if (j != 1) {
            continue;
          }
          k = j;
          localObject2 = (Integer)b.b.szC.get(Integer.valueOf(this.loN));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            k = j;
            bS(5, 16);
            k = j;
            v.i("MicroMsg.ExtContentProviderBase", "api flag = null");
            k = j;
            localObject1 = Integer.valueOf(64);
          }
          k = j;
          if (!com.tencent.mm.pluginsdk.model.app.g.a(localf, ((Integer)localObject1).intValue()))
          {
            i = 11;
            continue;
          }
          k = j;
          v.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
          i = j;
        }
        catch (Exception localException3)
        {
          i = 1;
          continue;
        }
        localException1 = localException1;
        i = k;
        v.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { localException1.getMessage() });
        v.printErrStackTrace("MicroMsg.ExtContentProviderBase", localException1, "", new Object[0]);
      }
    }
  }
  
  public final void bS(int paramInt1, int paramInt2)
  {
    GMTrace.i(5733378686976L, 42717);
    v.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { aqR(), this.loL, Integer.valueOf(this.loN), Integer.valueOf(paramInt1), Integer.valueOf(aqQ()) });
    com.tencent.mm.plugin.report.service.g.oSF.i(10505, new Object[] { aqR(), this.loL, Integer.valueOf(this.loN), Integer.valueOf(paramInt1), Integer.valueOf(aqQ()), Integer.valueOf(paramInt2) });
    GMTrace.o(5733378686976L, 42717);
  }
  
  public final boolean bW(Context paramContext)
  {
    GMTrace.i(5734586646528L, 42726);
    if (paramContext == null)
    {
      v.w("MicroMsg.ExtContentProviderBase", "in checkAppId(), context == null");
      GMTrace.o(5734586646528L, 42726);
      return false;
    }
    if (bf.mA(this.loL))
    {
      v.e("MicroMsg.ExtContentProviderBase", "invalid appid, ignore");
      GMTrace.o(5734586646528L, 42726);
      return false;
    }
    if ((this.loM == null) || (this.loM.length <= 0))
    {
      v.e("MicroMsg.ExtContentProviderBase", "packageList is null");
      GMTrace.o(5734586646528L, 42726);
      return false;
    }
    bool2 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    bool1 = bool4;
    for (;;)
    {
      try
      {
        localf = com.tencent.mm.pluginsdk.model.app.g.aJ(this.loL, true);
        if (localf == null)
        {
          bool1 = bool4;
          v.w("MicroMsg.ExtContentProviderBase", "app not reg, do nothing");
          GMTrace.o(5734586646528L, 42726);
          return false;
        }
        bool1 = bool4;
        if (localf.field_status != 3) {
          continue;
        }
        bool1 = bool4;
        v.e("MicroMsg.ExtContentProviderBase", "app is in blacklist.pkg:%s", new Object[] { localf.field_packageName });
        bool2 = bool3;
        bool1 = bool2;
        paramContext = Long.valueOf(bf.a((Long)loO.get(this.loL), 0L));
        bool1 = bool2;
        v.i("MicroMsg.ExtContentProviderBase", "lastCheckTime = %s, current = %s", new Object[] { paramContext, Long.valueOf(System.currentTimeMillis()) });
        bool1 = bool2;
        if (System.currentTimeMillis() - paramContext.longValue() > 3600000L)
        {
          bool1 = bool2;
          v.i("MicroMsg.ExtContentProviderBase", "update appInfo %s", new Object[] { this.loL });
          bool1 = bool2;
          a.a.aRo().Ck(this.loL);
          bool1 = bool2;
          loO.put(this.loL, Long.valueOf(System.currentTimeMillis()));
        }
      }
      catch (Exception paramContext)
      {
        f localf;
        int j;
        int i;
        Object localObject;
        v.e("MicroMsg.ExtContentProviderBase", "Exception in isAppidValid, %s", new Object[] { paramContext.getMessage() });
        v.printErrStackTrace("MicroMsg.ExtContentProviderBase", paramContext, "", new Object[0]);
        bool2 = bool1;
        continue;
        i += 1;
        continue;
      }
      GMTrace.o(5734586646528L, 42726);
      return bool2;
      bool1 = bool4;
      paramContext = this.loM;
      bool1 = bool4;
      j = paramContext.length;
      i = 0;
      bool3 = bool2;
      if (i < j)
      {
        localObject = paramContext[i];
        bool1 = bool4;
        if (!((String)localObject).equals(localf.field_packageName)) {
          continue;
        }
        bool1 = bool4;
        if (!p.b(aa.getContext(), localf, (String)localObject)) {
          continue;
        }
        bool1 = bool4;
        v.i("MicroMsg.ExtContentProviderBase", "check app success, calling package name = %s", new Object[] { localObject });
        bool1 = true;
        bool3 = true;
        this.loK = ((String)localObject);
      }
      bool2 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        localObject = (Integer)b.b.szC.get(Integer.valueOf(this.loN));
        paramContext = (Context)localObject;
        if (localObject == null)
        {
          bool1 = bool3;
          paramContext = Integer.valueOf(64);
        }
        bool1 = bool3;
        if (!com.tencent.mm.pluginsdk.model.app.g.a(localf, paramContext.intValue()))
        {
          bool2 = false;
        }
        else
        {
          bool1 = bool3;
          v.e("MicroMsg.ExtContentProviderBase", "appInfoFlag not set");
          bool2 = bool3;
        }
      }
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(5732976033792L, 42714);
    GMTrace.o(5732976033792L, 42714);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    GMTrace.i(5732707598336L, 42712);
    GMTrace.o(5732707598336L, 42712);
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    GMTrace.i(5732841816064L, 42713);
    GMTrace.o(5732841816064L, 42713);
    return null;
  }
  
  public final void lZ(int paramInt)
  {
    GMTrace.i(5733244469248L, 42716);
    v.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { aqR(), this.loL, Integer.valueOf(this.loN), Integer.valueOf(paramInt), Integer.valueOf(aqQ()) });
    com.tencent.mm.plugin.report.service.g.oSF.i(10505, new Object[] { aqR(), this.loL, Integer.valueOf(this.loN), Integer.valueOf(paramInt), Integer.valueOf(aqQ()) });
    GMTrace.o(5733244469248L, 42716);
  }
  
  public boolean onCreate()
  {
    GMTrace.i(5732439162880L, 42710);
    GMTrace.o(5732439162880L, 42710);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    GMTrace.i(5732573380608L, 42711);
    GMTrace.o(5732573380608L, 42711);
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(5733110251520L, 42715);
    GMTrace.o(5733110251520L, 42715);
    return 0;
  }
  
  public final void z(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(5733512904704L, 42718);
    v.i("MicroMsg.ExtContentProviderBase", "callingPkg = %s, appID = %s, apiID = %s, result = %s, timeCost = %s", new Object[] { aqR(), this.loL, Integer.valueOf(this.loN), Integer.valueOf(paramInt2), Integer.valueOf(aqQ()) });
    com.tencent.mm.plugin.report.service.g.oSF.i(10505, new Object[] { aqR(), this.loL, Integer.valueOf(this.loN), Integer.valueOf(paramInt2), Integer.valueOf(aqQ()), Integer.valueOf(paramInt3) });
    com.tencent.mm.plugin.report.service.g.oSF.a(300L, paramInt1, 1L, false);
    GMTrace.o(5733512904704L, 42718);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ext/provider/ExtContentProviderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */