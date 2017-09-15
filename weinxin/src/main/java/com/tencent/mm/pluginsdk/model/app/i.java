package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.e.b.n;
import com.tencent.mm.plugin.w.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends com.tencent.mm.sdk.e.i<f>
{
  public static final String[] gUn;
  public final com.tencent.mm.a.f<String, f> sBL;
  
  static
  {
    GMTrace.i(819130793984L, 6103);
    gUn = new String[] { com.tencent.mm.sdk.e.i.a(f.gTF, "AppInfo") };
    GMTrace.o(819130793984L, 6103);
  }
  
  public i(e parame)
  {
    super(parame, f.gTF, "AppInfo", n.gaA);
    GMTrace.i(816580657152L, 6084);
    this.sBL = new com.tencent.mm.a.f(50);
    parame = new f();
    parame.field_appId = "wx4310bbd51be7d979";
    if (!super.b(parame, new String[0]))
    {
      parame = new f();
      parame.field_appId = "wx4310bbd51be7d979";
      parame.field_appName = "weixinfile";
      parame.field_packageName = "com.tencent.mm.openapi";
      parame.field_status = -1;
      super.b(parame);
    }
    GMTrace.o(816580657152L, 6084);
  }
  
  private void DX(String paramString)
  {
    GMTrace.i(816849092608L, 6086);
    if (!bf.mA(paramString)) {
      this.sBL.remove(paramString);
    }
    GMTrace.o(816849092608L, 6086);
  }
  
  public static f bCU()
  {
    GMTrace.i(818593923072L, 6099);
    f localf = new f();
    localf.field_appName = "invalid_appname";
    localf.field_packageName = "";
    localf.field_signature = "";
    localf.field_status = 3;
    GMTrace.o(818593923072L, 6099);
    return localf;
  }
  
  public static String cw(String paramString, int paramInt)
  {
    int i = 0;
    GMTrace.i(818191269888L, 6096);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.AppInfoStorage", "getIconPath : invalid argument");
      GMTrace.o(818191269888L, 6096);
      return null;
    }
    String str = a.xm();
    File localFile1 = new File(str);
    File localFile2;
    if (!localFile1.exists()) {
      if (!localFile1.getParentFile().exists())
      {
        localFile2 = localFile1.getParentFile();
        File localFile3 = new File(localFile2.getAbsolutePath() + System.currentTimeMillis());
        if (localFile3.mkdir()) {
          localFile3.renameTo(localFile2);
        }
      }
      else
      {
        if ((localFile1.mkdir()) && (localFile1.isDirectory())) {
          break label197;
        }
        v.e("MicroMsg.AppInfoStorage", "mkdir error. %s", new Object[] { str });
      }
    }
    while (i == 0)
    {
      GMTrace.o(818191269888L, 6096);
      return null;
      v.e("MicroMsg.AppInfoStorage", "mkdir error, %s", new Object[] { localFile2.getAbsolutePath() });
      continue;
      label197:
      i = 1;
    }
    switch (paramInt)
    {
    default: 
      v.e("MicroMsg.AppInfoStorage", "getIconPath, unknown iconType = " + paramInt);
      GMTrace.o(818191269888L, 6096);
      return null;
    case 1: 
      paramString = a.xm() + g.n(paramString.getBytes()) + ".png";
      GMTrace.o(818191269888L, 6096);
      return paramString;
    case 2: 
      paramString = a.xm() + g.n(paramString.getBytes()) + "_wm.png";
      GMTrace.o(818191269888L, 6096);
      return paramString;
    case 3: 
      paramString = a.xm() + g.n(paramString.getBytes()) + "_sg.png";
      GMTrace.o(818191269888L, 6096);
      return paramString;
    case 5: 
      paramString = a.xm() + g.n(paramString.getBytes()) + "_sl.png";
      GMTrace.o(818191269888L, 6096);
      return paramString;
    }
    paramString = a.xm() + g.n(paramString.getBytes()) + "_sp.png";
    GMTrace.o(818191269888L, 6096);
    return paramString;
  }
  
  private void k(f paramf)
  {
    GMTrace.i(816714874880L, 6085);
    if ((paramf == null) || (paramf.field_appId == null))
    {
      GMTrace.o(816714874880L, 6085);
      return;
    }
    this.sBL.k(paramf.field_appId, paramf);
    GMTrace.o(816714874880L, 6085);
  }
  
  public final f Md(String paramString)
  {
    GMTrace.i(817520181248L, 6091);
    if ((paramString == null) || (paramString.length() == 0))
    {
      v.e("MicroMsg.AppInfoStorage", "appId is null");
      GMTrace.o(817520181248L, 6091);
      return null;
    }
    f localf = (f)this.sBL.get(paramString);
    if (localf != null) {}
    while ((localf != null) && (!bf.mA(localf.field_appId)))
    {
      GMTrace.o(817520181248L, 6091);
      return localf;
      localf = null;
    }
    localf = new f();
    localf.field_appId = paramString;
    if (super.b(localf, new String[0]))
    {
      k(localf);
      GMTrace.o(817520181248L, 6091);
      return localf;
    }
    GMTrace.o(817520181248L, 6091);
    return null;
  }
  
  public final boolean a(f paramf, String... paramVarArgs)
  {
    GMTrace.i(817117528064L, 6088);
    if ((paramf == null) || (bf.mA(paramf.field_appId)))
    {
      GMTrace.o(817117528064L, 6088);
      return false;
    }
    DX(paramf.field_appId);
    boolean bool = super.a(paramf, false, paramVarArgs);
    if (bool) {
      a(paramf.field_appId, 3, paramf.field_appId);
    }
    GMTrace.o(817117528064L, 6088);
    return bool;
  }
  
  public final boolean b(f paramf, String... paramVarArgs)
  {
    GMTrace.i(817251745792L, 6089);
    if ((paramf == null) || (bf.mA(paramf.field_appId)))
    {
      GMTrace.o(817251745792L, 6089);
      return false;
    }
    DX(paramf.field_appId);
    boolean bool = super.b(paramf, false, paramVarArgs);
    if (bool) {
      a(paramf.field_appId, 5, paramf.field_appId);
    }
    GMTrace.o(817251745792L, 6089);
    return bool;
  }
  
  public final List<String> bCS()
  {
    GMTrace.i(817385963520L, 6090);
    v.d("MicroMsg.AppInfoStorage", "getNullOpenIdList, maxCount = -1");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = rawQuery("select appId from AppInfo where openId is NULL ", new String[0]);
    if (localCursor == null)
    {
      v.e("MicroMsg.AppInfoStorage", "get null cursor");
      GMTrace.o(817385963520L, 6090);
      return localArrayList;
    }
    int i = localCursor.getCount();
    if (i <= 0)
    {
      v.w("MicroMsg.AppInfoStorage", "getNullOpenIdList fail, cursor count = " + i);
      localCursor.close();
      GMTrace.o(817385963520L, 6090);
      return localArrayList;
    }
    if (localCursor.moveToFirst()) {
      while (!localCursor.isAfterLast())
      {
        i = localCursor.getColumnIndex("appId");
        if (i >= 0)
        {
          String str = localCursor.getString(i);
          if (!bf.mA(str)) {
            localArrayList.add(str);
          }
        }
        localCursor.moveToNext();
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    GMTrace.o(817385963520L, 6090);
    return localArrayList;
  }
  
  public final Cursor bCT()
  {
    GMTrace.i(818057052160L, 6095);
    Cursor localCursor = rawQuery("select * from AppInfo where appType like '%1,%'", new String[0]);
    if (localCursor == null)
    {
      v.e("MicroMsg.AppInfoStorage", "getGameApp : cursor is null");
      GMTrace.o(818057052160L, 6095);
      return null;
    }
    GMTrace.o(818057052160L, 6095);
    return localCursor;
  }
  
  public final Cursor cG(int paramInt1, int paramInt2)
  {
    GMTrace.i(817922834432L, 6094);
    Object localObject = new StringBuilder(256);
    ((StringBuilder)localObject).append("select * from AppInfo");
    ((StringBuilder)localObject).append(" where ");
    if (paramInt1 != 0) {
      ((StringBuilder)localObject).append(" ( serviceAppInfoFlag & ").append(paramInt1).append(" ) != 0 and ");
    }
    ((StringBuilder)localObject).append(" ( serviceShowFlag & ").append(paramInt2).append(" ) != 0");
    localObject = rawQuery(((StringBuilder)localObject).toString(), new String[0]);
    if (localObject == null)
    {
      v.e("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag : cursor is null");
      GMTrace.o(817922834432L, 6094);
      return null;
    }
    v.d("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag count = %d", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    GMTrace.o(817922834432L, 6094);
    return (Cursor)localObject;
  }
  
  /* Error */
  public final boolean d(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: ldc2_w 367
    //   3: sipush 6098
    //   6: invokestatic 20	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_1
    //   10: ifnull +19 -> 29
    //   13: aload_1
    //   14: invokevirtual 121	java/lang/String:length	()I
    //   17: ifeq +12 -> 29
    //   20: aload_2
    //   21: ifnull +8 -> 29
    //   24: aload_2
    //   25: arraylength
    //   26: ifne +22 -> 48
    //   29: ldc 123
    //   31: ldc_w 370
    //   34: invokestatic 131	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: ldc2_w 367
    //   40: sipush 6098
    //   43: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_1
    //   49: iload_3
    //   50: invokestatic 372	com/tencent/mm/pluginsdk/model/app/i:cw	(Ljava/lang/String;I)Ljava/lang/String;
    //   53: astore 4
    //   55: aload 4
    //   57: ifnonnull +22 -> 79
    //   60: ldc 123
    //   62: ldc_w 374
    //   65: invokestatic 131	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc2_w 367
    //   71: sipush 6098
    //   74: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   77: iconst_0
    //   78: ireturn
    //   79: new 139	java/io/File
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore 4
    //   90: aload 4
    //   92: invokevirtual 145	java/io/File:exists	()Z
    //   95: ifeq +9 -> 104
    //   98: aload 4
    //   100: invokevirtual 377	java/io/File:delete	()Z
    //   103: pop
    //   104: new 379	java/io/FileOutputStream
    //   107: dup
    //   108: aload 4
    //   110: invokespecial 382	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   113: astore 4
    //   115: aload 4
    //   117: aload_2
    //   118: invokevirtual 386	java/io/FileOutputStream:write	([B)V
    //   121: aload 4
    //   123: invokevirtual 387	java/io/FileOutputStream:close	()V
    //   126: aload_0
    //   127: aload_1
    //   128: invokevirtual 390	com/tencent/mm/pluginsdk/model/app/i:Qq	(Ljava/lang/String;)V
    //   131: ldc2_w 367
    //   134: sipush 6098
    //   137: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   140: iconst_1
    //   141: ireturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: ldc 123
    //   147: aload_1
    //   148: ldc 110
    //   150: iconst_0
    //   151: anewarray 185	java/lang/Object
    //   154: invokestatic 394	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: ldc 123
    //   159: new 151	java/lang/StringBuilder
    //   162: dup
    //   163: ldc_w 396
    //   166: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: aload_1
    //   170: invokevirtual 399	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   173: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 131	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 387	java/io/FileOutputStream:close	()V
    //   190: ldc2_w 367
    //   193: sipush 6098
    //   196: invokestatic 39	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   199: iconst_0
    //   200: ireturn
    //   201: astore_1
    //   202: goto -12 -> 190
    //   205: astore_1
    //   206: aload 4
    //   208: astore_2
    //   209: goto -64 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	i
    //   0	212	1	paramString	String
    //   0	212	2	paramArrayOfByte	byte[]
    //   0	212	3	paramInt	int
    //   53	154	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   104	115	142	java/lang/Exception
    //   186	190	201	java/io/IOException
    //   115	131	205	java/lang/Exception
  }
  
  public final boolean l(f paramf)
  {
    GMTrace.i(816983310336L, 6087);
    if ((paramf == null) || (bf.mA(paramf.field_appId)))
    {
      GMTrace.o(816983310336L, 6087);
      return false;
    }
    if (super.a(paramf, false))
    {
      a(paramf.field_appId, 2, paramf.field_appId);
      k(paramf);
      GMTrace.o(816983310336L, 6087);
      return true;
    }
    GMTrace.o(816983310336L, 6087);
    return false;
  }
  
  public final boolean s(String paramString, Bitmap paramBitmap)
  {
    GMTrace.i(818325487616L, 6097);
    if ((paramString == null) || (paramString.length() == 0) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      v.e("MicroMsg.AppInfoStorage", "saveIcon : invalid argument");
      GMTrace.o(818325487616L, 6097);
      return false;
    }
    Object localObject = cw(paramString, 1);
    if (localObject == null)
    {
      v.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
      GMTrace.o(818325487616L, 6097);
      return false;
    }
    localObject = new File((String)localObject);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      localObject = new FileOutputStream((File)localObject);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((FileOutputStream)localObject).close();
      Qq(paramString);
      GMTrace.o(818325487616L, 6097);
      return true;
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.AppInfoStorage", paramString, "", new Object[0]);
      v.e("MicroMsg.AppInfoStorage", "saveIcon : compress occurs an exception");
      GMTrace.o(818325487616L, 6097);
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */