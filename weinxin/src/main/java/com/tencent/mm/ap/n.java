package com.tencent.mm.ap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.l.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.ArrayList;
import junit.framework.Assert;

public final class n
  extends j
{
  public static final String[] gUn;
  public g hnp;
  
  static
  {
    GMTrace.i(12941810204672L, 96424);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS packageinfo ( id int  PRIMARY KEY, version int  , name text  , size int  , packname text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE TABLE IF NOT EXISTS packageinfo2 ( localId text  PRIMARY KEY , id int  , version int  , name text  , size int  , packname text  , status int  , type int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
    GMTrace.o(12941810204672L, 96424);
  }
  
  public n(g paramg)
  {
    GMTrace.i(12939796938752L, 96409);
    this.hnp = paramg;
    GMTrace.o(12939796938752L, 96409);
  }
  
  public static String HZ()
  {
    GMTrace.i(12940736462848L, 96416);
    String str = a.xl();
    GMTrace.o(12940736462848L, 96416);
    return str;
  }
  
  public static String aR(int paramInt1, int paramInt2)
  {
    GMTrace.i(12940870680576L, 96417);
    String str = paramInt1 + "_" + paramInt2 + "_thumb.jpg";
    GMTrace.o(12940870680576L, 96417);
    return str;
  }
  
  public static int aZ(Context paramContext)
  {
    GMTrace.i(12941407551488L, 96421);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i;
    if (localDisplayMetrics.heightPixels > localDisplayMetrics.widthPixels) {
      i = 1;
    }
    while (localDisplayMetrics.density <= 1.0F) {
      if (i != 0)
      {
        GMTrace.o(12941407551488L, 96421);
        return 4;
        i = 0;
      }
      else
      {
        GMTrace.o(12941407551488L, 96421);
        return 2;
      }
    }
    if (i != 0)
    {
      GMTrace.o(12941407551488L, 96421);
      return 3;
    }
    GMTrace.o(12941407551488L, 96421);
    return 1;
  }
  
  public static String w(String paramString, boolean paramBoolean)
  {
    GMTrace.i(12941541769216L, 96422);
    if (paramBoolean)
    {
      paramString = a.xl() + paramString + "_chatting_bg_vertical.jpg";
      GMTrace.o(12941541769216L, 96422);
      return paramString;
    }
    paramString = a.xl() + paramString + "_chatting_bg_horizontal.jpg";
    GMTrace.o(12941541769216L, 96422);
    return paramString;
  }
  
  public final String B(String paramString, int paramInt)
  {
    GMTrace.i(12941675986944L, 96423);
    switch (paramInt)
    {
    default: 
      GMTrace.o(12941675986944L, 96423);
      return null;
    case 3: 
    case 4: 
      paramString = w(paramString, true);
      GMTrace.o(12941675986944L, 96423);
      return paramString;
    }
    paramString = w(paramString, false);
    GMTrace.o(12941675986944L, 96423);
    return paramString;
  }
  
  public final boolean a(m paramm)
  {
    GMTrace.i(12939931156480L, 96410);
    if (paramm == null)
    {
      GMTrace.o(12939931156480L, 96410);
      return false;
    }
    paramm.fRM = -1;
    paramm = paramm.pv();
    if ((int)this.hnp.insert("packageinfo2", "localId", paramm) != -1)
    {
      doNotify();
      GMTrace.o(12939931156480L, 96410);
      return true;
    }
    GMTrace.o(12939931156480L, 96410);
    return false;
  }
  
  public final m aQ(int paramInt1, int paramInt2)
  {
    m localm = null;
    GMTrace.i(12940333809664L, 96413);
    Object localObject = "select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.id = \"" + bf.my(String.valueOf(paramInt1)) + "\" and packageinfo2.type" + " = \"" + bf.my(String.valueOf(paramInt2)) + "\"";
    localObject = this.hnp.a((String)localObject, null, 2);
    if (localObject == null)
    {
      GMTrace.o(12940333809664L, 96413);
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localm = new m();
      localm.b((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    GMTrace.o(12940333809664L, 96413);
    return localm;
  }
  
  public final String aS(int paramInt1, int paramInt2)
  {
    GMTrace.i(12941004898304L, 96418);
    switch (paramInt2)
    {
    default: 
      GMTrace.o(12941004898304L, 96418);
      return "";
    case 0: 
      GMTrace.o(12941004898304L, 96418);
      return "";
    case 1: 
      localObject = paramInt1 + "_session_bg.zip";
      GMTrace.o(12941004898304L, 96418);
      return (String)localObject;
    case 2: 
      localObject = paramInt1 + "_emoji_art.temp";
      GMTrace.o(12941004898304L, 96418);
      return (String)localObject;
    case 8: 
      localObject = paramInt1 + "_regiondata.temp";
      GMTrace.o(12941004898304L, 96418);
      return (String)localObject;
    case 7: 
      localObject = paramInt1 + "_configlist.cfg";
      GMTrace.o(12941004898304L, 96418);
      return (String)localObject;
    case 9: 
      GMTrace.o(12941004898304L, 96418);
      return "_speex_upload.cfg";
    case 12: 
      GMTrace.o(12941004898304L, 96418);
      return "_rcpt_addr";
    case 18: 
      localObject = aQ(paramInt1, paramInt2);
      localObject = ((m)localObject).version + "_feature.zip";
      GMTrace.o(12941004898304L, 96418);
      return (String)localObject;
    case 5: 
      GMTrace.o(12941004898304L, 96418);
      return "brand_i18n.apk";
    case 19: 
      GMTrace.o(12941004898304L, 96418);
      return "_report_reason.temp";
    case 20: 
      GMTrace.o(12941004898304L, 96418);
      return "_pluginDesc.cfg";
    case 21: 
      GMTrace.o(12941004898304L, 96418);
      return "_trace_config.cfg";
    case 23: 
      GMTrace.o(12941004898304L, 96418);
      return "permissioncfg.cfg";
    case 26: 
      GMTrace.o(12941004898304L, 96418);
      return "ipcallCountryCodeConfig.cfg";
    }
    Object localObject = paramInt1 + "_sensewhere.xml";
    GMTrace.o(12941004898304L, 96418);
    return (String)localObject;
  }
  
  public final String aT(int paramInt1, int paramInt2)
  {
    GMTrace.i(12941139116032L, 96419);
    switch (paramInt2)
    {
    default: 
      GMTrace.o(12941139116032L, 96419);
      return "";
    case 0: 
      GMTrace.o(12941139116032L, 96419);
      return "";
    case 1: 
      str = a.xl() + paramInt1 + "_session_bg/";
      try
      {
        File localFile = new File(str);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        GMTrace.o(12941139116032L, 96419);
        return str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.PackageInfoStorage", "exception:%s", new Object[] { bf.g(localException) });
          v.e("MicroMsg.PackageInfoStorage", "can not create dir, dir = " + str);
        }
      }
    case 2: 
      GMTrace.o(12941139116032L, 96419);
      return "";
    }
    String str = aS(paramInt1, paramInt2);
    str = a.xl() + str.replace(".zip", "");
    GMTrace.o(12941139116032L, 96419);
    return str;
  }
  
  public final void aU(int paramInt1, int paramInt2)
  {
    GMTrace.i(12941273333760L, 96420);
    b.deleteFile(a.xl() + aS(paramInt1, paramInt2));
    m localm = aQ(paramInt1, paramInt2);
    if (localm != null)
    {
      localm.status = 5;
      t.Id().b(localm);
    }
    GMTrace.o(12941273333760L, 96420);
  }
  
  public final boolean b(m paramm)
  {
    GMTrace.i(12940065374208L, 96411);
    if (paramm != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ContentValues localContentValues = paramm.pv();
      if (localContentValues.size() <= 0) {
        break;
      }
      if (this.hnp.update("packageinfo2", localContentValues, "id= ? and type =?", new String[] { paramm.id, paramm.fKC }) <= 0) {
        break;
      }
      doNotify();
      GMTrace.o(12940065374208L, 96411);
      return true;
    }
    doNotify();
    GMTrace.o(12940065374208L, 96411);
    return false;
  }
  
  public final boolean gj(int paramInt)
  {
    GMTrace.i(12940199591936L, 96412);
    String str = "update packageinfo2 set status = 2 where status = 1 and type = " + paramInt + ";";
    boolean bool = this.hnp.eE("packageinfo2", str);
    doNotify();
    GMTrace.o(12940199591936L, 96412);
    return bool;
  }
  
  public final boolean gk(int paramInt)
  {
    GMTrace.i(12940468027392L, 96414);
    if (this.hnp.delete("packageinfo2", "type =?", new String[] { String.valueOf(paramInt) }) > 0)
    {
      doNotify();
      GMTrace.o(12940468027392L, 96414);
      return true;
    }
    GMTrace.o(12940468027392L, 96414);
    return false;
  }
  
  public final m[] gl(int paramInt)
  {
    GMTrace.i(12940602245120L, 96415);
    Object localObject = "select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=" + paramInt;
    localObject = this.hnp.a((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    while (((Cursor)localObject).moveToNext())
    {
      m localm = new m();
      localm.b((Cursor)localObject);
      localArrayList.add(localm);
    }
    ((Cursor)localObject).close();
    localObject = (m[])localArrayList.toArray(new m[localArrayList.size()]);
    GMTrace.o(12940602245120L, 96415);
    return (m[])localObject;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */