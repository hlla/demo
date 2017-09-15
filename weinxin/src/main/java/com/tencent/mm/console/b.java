package com.tencent.mm.console;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.e.a.bh;
import com.tencent.mm.e.a.bj;
import com.tencent.mm.e.a.bk;
import com.tencent.mm.e.a.bz;
import com.tencent.mm.e.a.cd;
import com.tencent.mm.e.a.cf;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.fi;
import com.tencent.mm.e.a.lj;
import com.tencent.mm.e.a.oo;
import com.tencent.mm.e.a.or;
import com.tencent.mm.e.a.pc;
import com.tencent.mm.e.a.ph;
import com.tencent.mm.e.a.ss;
import com.tencent.mm.e.a.st;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.pluginsdk.l.j;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.l.v;
import com.tencent.mm.pluginsdk.l.y;
import com.tencent.mm.pluginsdk.l.z;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.amx;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aw;
import com.tencent.mm.u.ax;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.u.bf.a;
import com.tencent.mm.u.bp;
import com.tencent.mm.u.c.a.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.d.g;
import com.tencent.mm.y.d.a;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class b
{
  static
  {
    GMTrace.i(424799109120L, 3165);
    com.tencent.mm.console.a.b.init();
    com.tencent.mm.console.a.g.init();
    com.tencent.mm.console.a.h.init();
    com.tencent.mm.console.a.e.init();
    com.tencent.mm.console.a.c.init();
    com.tencent.mm.console.a.d.init();
    com.tencent.mm.console.a.a.init();
    com.tencent.mm.console.a.j.init();
    com.tencent.mm.console.a.f.init();
    com.tencent.mm.console.a.i.init();
    GMTrace.o(424799109120L, 3165);
  }
  
  private static int dK(String paramString)
  {
    GMTrace.i(423993802752L, 3159);
    if ((!paramString.startsWith("//")) || (paramString.length() <= 2))
    {
      GMTrace.o(423993802752L, 3159);
      return 0;
    }
    int j = paramString.indexOf(" ");
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    try
    {
      i = bf.getInt(paramString.substring(2, i), 0);
      j = com.tencent.mm.protocal.d.sXh % 256;
      if ((j == 0) || (i < j) || (i % j != 0))
      {
        GMTrace.o(423993802752L, 3159);
        return 0;
      }
    }
    catch (Exception paramString)
    {
      GMTrace.o(423993802752L, 3159);
      return 0;
    }
    i /= j;
    GMTrace.o(423993802752L, 3159);
    return i;
  }
  
  private static String dL(String paramString)
  {
    GMTrace.i(424128020480L, 3160);
    int i = paramString.indexOf(" ");
    if (i < 0)
    {
      GMTrace.o(424128020480L, 3160);
      return "";
    }
    paramString = paramString.substring(i).trim();
    GMTrace.o(424128020480L, 3160);
    return paramString;
  }
  
  /* Error */
  private static StringBuilder ev(int paramInt)
  {
    // Byte code:
    //   0: ldc2_w 159
    //   3: sipush 3162
    //   6: invokestatic 68	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 162	java/util/Date
    //   12: dup
    //   13: invokestatic 166	com/tencent/mm/sdk/platformtools/bf:NA	()J
    //   16: iload_0
    //   17: i2l
    //   18: ldc2_w 167
    //   21: lmul
    //   22: lsub
    //   23: invokespecial 172	java/util/Date:<init>	(J)V
    //   26: astore_1
    //   27: new 174	java/text/SimpleDateFormat
    //   30: dup
    //   31: ldc -80
    //   33: invokestatic 182	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   36: invokespecial 185	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   39: astore_2
    //   40: new 187	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   47: getstatic 195	com/tencent/mm/compatible/util/e:hgl	Ljava/lang/String;
    //   50: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc -55
    //   55: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_2
    //   59: aload_1
    //   60: invokevirtual 205	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   63: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc -49
    //   68: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore_1
    //   75: new 187	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   82: astore 4
    //   84: new 212	java/io/File
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: invokevirtual 219	java/io/File:exists	()Z
    //   95: ifne +43 -> 138
    //   98: new 187	java/lang/StringBuilder
    //   101: dup
    //   102: new 187	java/lang/StringBuilder
    //   105: dup
    //   106: ldc -35
    //   108: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: iload_0
    //   112: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc -30
    //   117: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: astore_1
    //   127: ldc2_w 159
    //   130: sipush 3162
    //   133: invokestatic 103	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   136: aload_1
    //   137: areturn
    //   138: new 228	java/io/BufferedReader
    //   141: dup
    //   142: new 230	java/io/InputStreamReader
    //   145: dup
    //   146: new 232	java/io/FileInputStream
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 233	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   154: invokespecial 236	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   157: invokespecial 239	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   160: astore_2
    //   161: aload_2
    //   162: astore_1
    //   163: aload_2
    //   164: invokevirtual 242	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   167: invokestatic 245	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   170: ifeq +55 -> 225
    //   173: aload_2
    //   174: astore_1
    //   175: aload_2
    //   176: invokevirtual 248	java/io/BufferedReader:close	()V
    //   179: aload_2
    //   180: astore_1
    //   181: new 187	java/lang/StringBuilder
    //   184: dup
    //   185: new 187	java/lang/StringBuilder
    //   188: dup
    //   189: ldc -6
    //   191: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: iload_0
    //   195: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc -4
    //   200: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: astore_3
    //   210: aload_2
    //   211: invokevirtual 248	java/io/BufferedReader:close	()V
    //   214: ldc2_w 159
    //   217: sipush 3162
    //   220: invokestatic 103	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   223: aload_3
    //   224: areturn
    //   225: aload_2
    //   226: astore_1
    //   227: aload_2
    //   228: invokevirtual 242	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   231: astore_3
    //   232: aload_3
    //   233: ifnull +88 -> 321
    //   236: aload_2
    //   237: astore_1
    //   238: aload 4
    //   240: new 114	java/lang/String
    //   243: dup
    //   244: aload_3
    //   245: ldc -2
    //   247: invokevirtual 258	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   250: iconst_1
    //   251: aaload
    //   252: iconst_0
    //   253: invokestatic 264	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   256: invokespecial 267	java/lang/String:<init>	([B)V
    //   259: ldc_w 269
    //   262: invokevirtual 258	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   265: iconst_1
    //   266: aaload
    //   267: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_2
    //   272: astore_1
    //   273: aload 4
    //   275: ldc_w 271
    //   278: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: goto -57 -> 225
    //   285: astore_3
    //   286: aload_2
    //   287: astore_1
    //   288: ldc_w 273
    //   291: aload_3
    //   292: ldc -107
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 279	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 248	java/io/BufferedReader:close	()V
    //   309: ldc2_w 159
    //   312: sipush 3162
    //   315: invokestatic 103	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   318: aload 4
    //   320: areturn
    //   321: aload_2
    //   322: invokevirtual 248	java/io/BufferedReader:close	()V
    //   325: goto -16 -> 309
    //   328: astore_1
    //   329: goto -20 -> 309
    //   332: astore_2
    //   333: aconst_null
    //   334: astore_1
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 248	java/io/BufferedReader:close	()V
    //   343: aload_2
    //   344: athrow
    //   345: astore_1
    //   346: goto -132 -> 214
    //   349: astore_1
    //   350: goto -41 -> 309
    //   353: astore_1
    //   354: goto -11 -> 343
    //   357: astore_2
    //   358: goto -23 -> 335
    //   361: astore_3
    //   362: aconst_null
    //   363: astore_2
    //   364: goto -78 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramInt	int
    //   26	262	1	localObject1	Object
    //   328	1	1	localException1	Exception
    //   334	6	1	localObject2	Object
    //   345	1	1	localException2	Exception
    //   349	1	1	localException3	Exception
    //   353	1	1	localException4	Exception
    //   39	283	2	localObject3	Object
    //   332	12	2	localObject4	Object
    //   357	1	2	localObject5	Object
    //   363	1	2	localObject6	Object
    //   209	36	3	localObject7	Object
    //   285	7	3	localException5	Exception
    //   361	1	3	localException6	Exception
    //   82	237	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   163	173	285	java/lang/Exception
    //   175	179	285	java/lang/Exception
    //   181	210	285	java/lang/Exception
    //   227	232	285	java/lang/Exception
    //   238	271	285	java/lang/Exception
    //   273	282	285	java/lang/Exception
    //   321	325	328	java/lang/Exception
    //   138	161	332	finally
    //   210	214	345	java/lang/Exception
    //   305	309	349	java/lang/Exception
    //   339	343	353	java/lang/Exception
    //   163	173	357	finally
    //   175	179	357	finally
    //   181	210	357	finally
    //   227	232	357	finally
    //   238	271	357	finally
    //   273	282	357	finally
    //   288	301	357	finally
    //   138	161	361	java/lang/Exception
  }
  
  private static void ew(int paramInt)
  {
    GMTrace.i(424530673664L, 3163);
    SharedPreferences localSharedPreferences = ak.aZ(com.tencent.mm.sdk.platformtools.aa.getContext(), "sp_sns_dynswitch_stg");
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Bad op parameter: " + paramInt);
    case -1: 
      localSharedPreferences.edit().remove("st_sw_use_vcodec_img").commit();
      GMTrace.o(424530673664L, 3163);
      return;
    case 0: 
      localSharedPreferences.edit().putBoolean("st_sw_use_vcodec_img", false).commit();
      GMTrace.o(424530673664L, 3163);
      return;
    }
    localSharedPreferences.edit().putBoolean("st_sw_use_vcodec_img", true).commit();
    GMTrace.o(424530673664L, 3163);
  }
  
  private static void ex(int paramInt)
  {
    GMTrace.i(424664891392L, 3164);
    SharedPreferences localSharedPreferences = ak.aZ(com.tencent.mm.sdk.platformtools.aa.getContext(), "sp_sns_dynswitch_stg");
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Bad op parameter: " + paramInt);
    case -1: 
      localSharedPreferences.edit().remove("st_sw_use_wxpc_img").commit();
      GMTrace.o(424664891392L, 3164);
      return;
    case 0: 
      localSharedPreferences.edit().putBoolean("st_sw_use_wxpc_img", false).commit();
      GMTrace.o(424664891392L, 3164);
      return;
    }
    localSharedPreferences.edit().putBoolean("st_sw_use_wxpc_img", true).commit();
    GMTrace.o(424664891392L, 3164);
  }
  
  public static boolean v(final Context paramContext, final String paramString)
  {
    GMTrace.i(424262238208L, 3161);
    if (!paramString.startsWith("//"))
    {
      GMTrace.o(424262238208L, 3161);
      return false;
    }
    if (com.tencent.mm.pluginsdk.b.b.aN(paramContext, paramString))
    {
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//clearWXSNSDB"))
    {
      paramContext = new oo();
      com.tencent.mm.sdk.b.a.uql.m(paramContext);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//verifytokenerror"))
    {
      r.ijw = true;
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.equalsIgnoreCase("//ftsmsbiz"))
    {
      localObject1 = com.tencent.mm.as.f.Ir();
      paramString = new StringBuilder();
      localObject1 = ((amy)localObject1).jLs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (amx)((Iterator)localObject1).next();
        paramString.append(String.format("%s | %.2f | %s", new Object[] { com.tencent.mm.u.n.eK(((amx)localObject4).tfa), Double.valueOf(((amx)localObject4).tPT), com.tencent.mm.pluginsdk.j.o.Z("yyyy-MM-dd HH:mm", ((amx)localObject4).tPU / 1000L) }));
        paramString.append("\n");
      }
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setText(paramString.toString());
      ((TextView)localObject1).setGravity(19);
      ((TextView)localObject1).setTextSize(1, 10.0F);
      ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject1).setTextColor(-16711936);
      ((TextView)localObject1).setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(R.f.aXs);
      ((TextView)localObject1).setPadding(i, i, i, i);
      com.tencent.mm.ui.base.g.a(paramContext, null, (View)localObject1, null);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//wxafts"))
    {
      paramContext = new st();
      paramContext.gay.gaz = paramString;
      com.tencent.mm.sdk.b.a.uql.m(paramContext);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (com.tencent.mm.sdk.a.b.bIk())
    {
      if (paramString.startsWith("//launchapp clear"))
      {
        com.tencent.mm.kernel.h.vI().vr().a(w.a.uEq, "");
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//setsupportwxcode"))
      {
        com.tencent.mm.kernel.h.vI().vr().a(w.a.uFC, Boolean.valueOf(true));
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//setnotsupportwxcode"))
      {
        com.tencent.mm.kernel.h.vI().vr().a(w.a.uFC, Boolean.valueOf(false));
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//resetsupportwxcode"))
      {
        com.tencent.mm.kernel.h.vI().vr().a(w.a.uFC, null);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
    }
    if (paramString.startsWith("//testsightwidget"))
    {
      paramString = new Intent();
      paramString.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
      paramString.putExtra("KSightThumbPath", "");
      paramString.putExtra("sight_md5", com.tencent.mm.a.g.aV("/mnt/sdcard/tencent/tempvideo4.mp4"));
      paramString.putExtra("KSnsPostManu", true);
      paramString.putExtra("KTouchCameraTime", bf.Nz());
      paramString.putExtra("Ksnsupload_type", 14);
      com.tencent.mm.bb.d.b(paramContext, "sns", ".ui.En_c4f742e5", paramString);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//ftstemplatetest"))
    {
      localObject1 = new com.tencent.mm.e.a.bb();
      ((com.tencent.mm.e.a.bb)localObject1).fEr.fEs = 27;
      ((com.tencent.mm.e.a.bb)localObject1).fEr.fEs = 1;
      ((com.tencent.mm.e.a.bb)localObject1).fEr.filePath = "/sdcard/fts_template.zip";
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
    }
    if (paramString.startsWith("//sightforward"))
    {
      paramString = new Intent();
      paramString.setClassName(paramContext, "com.tencent.mm.ui.transmit.SightForwardUI");
      paramContext.startActivity(paramString);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//uplog"))
    {
      localObject1 = "weixin";
      if (ap.zb()) {
        localObject1 = com.tencent.mm.u.m.xL();
      }
      localObject4 = paramString.split(" ");
      j = 0;
      i = 0;
      paramString = (String)localObject1;
      if (localObject4 != null)
      {
        if (localObject4.length > 1) {
          i = bf.getInt(localObject4[1], 0);
        }
        paramString = (String)localObject1;
        j = i;
        if (localObject4.length > 2)
        {
          paramString = localObject4[2];
          j = i;
        }
      }
      ap.vd().d(new com.tencent.mm.u.bb(new bb.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          GMTrace.i(415806521344L, 3098);
          ap.vd().a(1, "", 0, false);
          v.bIF();
          ap.vd().a(2, this.gTf, j, ap.zb());
          GMTrace.o(415806521344L, 3098);
        }
      }));
      paramContext.getString(R.l.dIG);
      ap.a(new com.tencent.mm.u.ad()
      {
        public final void ey(int paramAnonymousInt)
        {
          GMTrace.i(425604415488L, 3171);
          v.i("MicroMsg.CommandProcessor", "ipxx progress:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt < 0)
          {
            ap.a(null);
            this.gTv.dismiss();
            com.tencent.mm.ui.base.g.h(paramContext, R.l.eYX, R.l.dIG);
            GMTrace.o(425604415488L, 3171);
            return;
          }
          if (paramAnonymousInt >= 100)
          {
            ap.a(null);
            this.gTv.dismiss();
            com.tencent.mm.ui.base.g.h(paramContext, R.l.eZb, R.l.dIG);
            GMTrace.o(425604415488L, 3171);
            return;
          }
          this.gTv.setMessage(paramContext.getString(R.l.eYY) + paramAnonymousInt + "%");
          GMTrace.o(425604415488L, 3171);
        }
      });
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//upcrash"))
    {
      paramContext = "weixin";
      if (ap.zb()) {
        paramContext = com.tencent.mm.u.m.xL();
      }
      localObject1 = paramString.split(" ");
      j = 0;
      i = 0;
      paramString = paramContext;
      if (localObject1 != null)
      {
        if (localObject1.length > 1) {
          i = bf.getInt(localObject1[1], 0);
        }
        paramString = paramContext;
        j = i;
        if (localObject1.length > 2)
        {
          paramString = localObject1[2];
          j = i;
        }
      }
      ap.vd().d(new com.tencent.mm.u.bb(new bb.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          GMTrace.i(422517407744L, 3148);
          ap.vd().a(3, this.gTf, j, ap.zb());
          GMTrace.o(422517407744L, 3148);
        }
      }));
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//switchnotificationstatus"))
    {
      if (!com.tencent.mm.i.f.sk()) {}
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.i.f.aI(bool1);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
    }
    if (paramString.startsWith("//fixError0831"))
    {
      v.i("MicroMsg.CommandProcessor", "fixError0831");
      com.tencent.mm.sdk.b.a.uql.m(new bh());
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//cleanpaycn"))
    {
      v.i("MicroMsg.CommandProcessor", "cleanpaycn");
      com.tencent.mm.sdk.b.a.uql.m(new bk());
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//busiluck "))
    {
      paramString = paramString.replace("//busiluck ", "");
      paramString = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=" + paramString;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_way", 5);
      ((Intent)localObject1).putExtra("key_native_url", paramString);
      com.tencent.mm.bb.d.b(paramContext, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", (Intent)localObject1);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//testsoter"))
    {
      paramString = new Intent();
      paramString.setClassName(com.tencent.mm.sdk.platformtools.aa.getPackageName(), "com.tencent.mm.plugin.soter.ui.SoterTestUI");
      paramContext.startActivity(paramString);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//facevideo"))
    {
      paramContext = paramString.split(" ");
      if (paramContext.length == 3)
      {
        com.tencent.mm.u.ao.hlE.L("imgType", paramContext[1]);
        com.tencent.mm.u.ao.hlE.L("depth", paramContext[2]);
      }
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//alpha"))
    {
      paramContext = paramString.split(" ");
      if (paramContext.length == 2) {
        com.tencent.mm.u.ao.hlE.L("alpha_duration", paramContext[1]);
      }
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//rectwidth"))
    {
      paramContext = paramString.split(" ");
      if (paramContext.length == 2) {
        com.tencent.mm.u.ao.hlE.L("rect_width", paramContext[1]);
      }
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//newyearsw "))
    {
      ap.yY();
      i = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uyp, Integer.valueOf(0))).intValue();
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uyp, Integer.valueOf(i ^ 0x1));
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//commitxlog"))
    {
      ap.vd().a(1, "", 0, false);
      v.bIF();
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//netstatus"))
    {
      paramString = al.ed(com.tencent.mm.sdk.platformtools.aa.getContext());
      com.tencent.mm.ui.base.g.b(paramContext, paramString, "netstatus", paramContext.getString(R.l.fbV), paramContext.getString(R.l.dXa), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(414195908608L, 3086);
          ((ClipboardManager)this.gTh.getSystemService("clipboard")).setText(paramString);
          GMTrace.o(414195908608L, 3086);
        }
      }, null);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//scaninterval "))
    {
      localObject1 = paramString.split(" ");
      l1 = -1L;
    }
    try
    {
      l2 = bf.getLong(localObject1[1], -1L);
      l1 = l2;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        long l2;
        continue;
        paramString = null;
        continue;
        paramString = null;
        continue;
        Object localObject3 = null;
        paramString = null;
        continue;
        localObject4 = null;
        localObject3 = null;
        paramString = null;
      }
    }
    if (l1 > 0L)
    {
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uDB, Long.valueOf(l1));
      v.i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", new Object[] { Long.valueOf(l1) });
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//scanwait "))
    {
      localObject1 = paramString.split(" ");
      l1 = -1L;
    }
    try
    {
      l2 = bf.getLong(localObject1[1], -1L);
      l1 = l2;
    }
    catch (Exception localException2)
    {
      boolean bool3;
      boolean bool2;
      boolean bool4;
      for (;;) {}
    }
    if (l1 > 0L)
    {
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uDC, Long.valueOf(l1));
      v.i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", new Object[] { Long.valueOf(l1) });
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.equalsIgnoreCase("//delayquery"))
    {
      if (!r.ijz) {}
      for (bool1 = true;; bool1 = false)
      {
        r.ijz = bool1;
        GMTrace.o(424262238208L, 3161);
        return true;
      }
    }
    if (paramString.equalsIgnoreCase("//swipe"))
    {
      paramContext = com.tencent.mm.sdk.platformtools.aa.bIO();
      bool1 = paramContext.getBoolean("settings_support_swipe", true);
      paramContext = paramContext.edit();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramContext.putBoolean("settings_support_swipe", bool1).commit();
        GMTrace.o(424262238208L, 3161);
        return true;
      }
    }
    if (paramString.equalsIgnoreCase("//multiwebview"))
    {
      paramContext = LauncherUI.bPy().getSharedPreferences(com.tencent.mm.sdk.platformtools.aa.bIN(), 0);
      bool1 = paramContext.getBoolean("settings_multi_webview", false);
      if (bool1)
      {
        paramContext = paramContext.edit();
        if (bool1) {
          break label1966;
        }
      }
      label1966:
      for (bool1 = true;; bool1 = false)
      {
        paramContext.putBoolean("settings_multi_webview", bool1).commit();
        GMTrace.o(424262238208L, 3161);
        return true;
      }
    }
    if (paramString.equalsIgnoreCase("//sightinfo"))
    {
      ap.yY();
      bool1 = ((Boolean)com.tencent.mm.u.c.vr().get(344065, Boolean.valueOf(false))).booleanValue();
      ap.yY();
      paramContext = com.tencent.mm.u.c.vr();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramContext.set(344065, Boolean.valueOf(bool1));
        ap.yY();
        com.tencent.mm.u.c.vr().jV(true);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
    }
    if (paramString.startsWith("//sighttest"))
    {
      i = bf.PX(paramString.replace("//sighttest ", ""));
      ap.yY();
      com.tencent.mm.u.c.vr().set(344066, Integer.valueOf(i));
      ap.yY();
      com.tencent.mm.u.c.vr().jV(true);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//wxcamera"))
    {
      i = bf.PX(paramString.replace("//wxcamera ", ""));
      v.i("MicroMsg.CommandProcessor", "set param %d", new Object[] { Integer.valueOf(i) });
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uDq, Integer.valueOf(i));
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//printcrash"))
    {
      paramString = paramString.replace("//printcrash ", "");
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setText(ev(bf.getInt(paramString, 0)));
      ((TextView)localObject1).setGravity(19);
      ((TextView)localObject1).setTextSize(1, 8.0F);
      ((TextView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject1).setTextColor(-16711936);
      ((TextView)localObject1).setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(R.f.aXU);
      ((TextView)localObject1).setPadding(i, i, i, i);
      ((TextView)localObject1).setMovementMethod(ScrollingMovementMethod.getInstance());
      com.tencent.mm.ui.base.g.a(paramContext, null, (View)localObject1, null);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//printleak"))
    {
      paramString = new TextView(paramContext);
      paramString.setText(com.tencent.mm.compatible.b.e.qW());
      paramString.setGravity(19);
      paramString.setTextSize(1, 8.0F);
      paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      paramString.setTextColor(-16711936);
      paramString.setTypeface(Typeface.MONOSPACE);
      i = paramContext.getResources().getDimensionPixelSize(R.f.aXU);
      paramString.setPadding(i, i, i, i);
      paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
      com.tencent.mm.ui.base.g.a(paramContext, null, paramString, null);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//resetmapcnt"))
    {
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uFD, Integer.valueOf(0));
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.equals("//testrsa"))
    {
      com.tencent.mm.protocal.ac.G("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.equals("//testrsabad"))
    {
      com.tencent.mm.protocal.ac.G("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.equals("//walletofflinetest"))
    {
      ap.yY();
      com.tencent.mm.u.c.vr().a(w.a.uCV, Boolean.valueOf(false));
      GMTrace.o(424262238208L, 3161);
      return false;
    }
    if (paramString.startsWith("//makemsgdata "))
    {
      i = bf.getInt(paramString.split(" ")[1], 0);
      ap.yY();
      com.tencent.mm.u.c.wT().w(En_5b8fbb1e.a.vGp, i);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//pullappservice"))
    {
      com.tencent.mm.pluginsdk.model.app.ao.bDf().dA(com.tencent.mm.sdk.platformtools.aa.getContext());
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//boundaryconfig"))
    {
      v.i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitSessionTextMsg"), 0)) });
      v.i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitSNSObjectText"), 0)) });
      v.i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("SnsCommentMaxSize"), 0)) });
      v.i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitFavText"), 0)) });
      v.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitSendEmotionBufSize"), 0)) });
      v.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitSendEmotionWidth"), 0)) });
      v.i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitFavImageSize"), 0)) });
      v.i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitFavVoiceLength"), 0)) });
      v.i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitSessionShortVideoBufSize"), 0)) });
      v.i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitVideoSize"), 0)) });
      v.i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", new Object[] { Integer.valueOf(bf.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitFileSize"), 0)) });
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//whatsnew"))
    {
      MMAppMgr.aa((Activity)paramContext);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//profile "))
    {
      ap.yY();
      paramString = com.tencent.mm.u.c.wR().Rb(paramString.replace("//profile ", "").trim());
      if ((paramString != null) && (paramString.tJ() != 0))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramString.getUsername());
        com.tencent.mm.bb.d.b(paramContext, "profile", ".ui.ContactInfoUI", (Intent)localObject1);
      }
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//cs"))
    {
      paramContext = new Intent();
      paramContext.putExtra("voipCSBizId", "gh_b35727b00b78");
      paramContext.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
      com.tencent.mm.bb.d.b(com.tencent.mm.sdk.platformtools.aa.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//acs"))
    {
      paramContext = new Intent();
      paramContext.putExtra("voipCSBizId", "gh_e8b085bb67e0");
      paramContext.putExtra("voipCSAppId", "wx1224160e0adcefd6");
      com.tencent.mm.bb.d.b(com.tencent.mm.sdk.platformtools.aa.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//wifiset"))
    {
      paramContext = new Intent();
      paramContext.putExtra("free_wifi_ssid", "Xiaomi_WENDY");
      paramContext.putExtra("free_wifi_passowrd", "WX12345789");
      com.tencent.mm.bb.d.b(com.tencent.mm.sdk.platformtools.aa.getContext(), "freewifi", ".ui.FreeWifiCopyPwdUI", paramContext);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//bcs"))
    {
      paramContext = new Intent();
      paramContext.putExtra("voipCSBizId", "gh_e8b085bb67e0");
      paramContext.putExtra("voipCSAppId", "wx1224160e0adcefd6");
      paramContext.putExtra("voipCSAllowBackCamera", "1");
      paramContext.putExtra("voipCSShowOther", "1");
      paramContext.putExtra("voipCSAvatarUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=28737416,3249768666&fm=58");
      paramContext.putExtra("voipCSContext", "test");
      com.tencent.mm.bb.d.b(com.tencent.mm.sdk.platformtools.aa.getContext(), "voip_cs", ".ui.VoipCSMainUI", paramContext);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//getfpkey"))
    {
      paramString = com.tencent.mm.storage.ba.bMM();
      com.tencent.mm.ui.base.g.b(paramContext, paramString, "Fingerprint Key", paramContext.getString(R.l.fbV), paramContext.getString(R.l.dXa), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(422248972288L, 3146);
          ((ClipboardManager)this.gTh.getSystemService("clipboard")).setText(paramString);
          Toast.makeText(this.gTh, R.l.fbW, 0).show();
          GMTrace.o(422248972288L, 3146);
        }
      }, null);
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//commitwd"))
    {
      WatchDogPushReceiver.Kj();
      GMTrace.o(424262238208L, 3161);
      return true;
    }
    if (paramString.startsWith("//setsnstestenv"))
    {
      paramString = paramString.split(" +");
      if (paramString.length <= 1) {
        break label14760;
      }
      localObject4 = paramString[1];
      if ((!com.tencent.mm.sdk.platformtools.p.isIPv4Address((String)localObject4)) && (!com.tencent.mm.sdk.platformtools.p.isIPv6Address((String)localObject4))) {
        break label14760;
      }
      if (paramString.length <= 2) {
        break label14752;
      }
      localObject1 = paramString[2];
      if ((!com.tencent.mm.sdk.platformtools.p.isIPv4Address((String)localObject1)) && (!com.tencent.mm.sdk.platformtools.p.isIPv6Address((String)localObject1))) {
        break label14752;
      }
      if (paramString.length > 3)
      {
        paramString = paramString[3];
        if (localObject4 != null) {}
        for (bool1 = true;; bool1 = false)
        {
          r.iiV = bool1;
          r.iiM = (String)localObject4;
          r.ijq = (String)localObject1;
          r.ijr = paramString;
          ap.vd().d(new com.tencent.mm.modelcdntran.e());
          Toast.makeText(paramContext, String.format("%s %s %s", new Object[] { r.iiM, r.ijq, r.ijr }), 1).show();
          GMTrace.o(424262238208L, 3161);
          return true;
        }
      }
    }
    else
    {
      if (paramString.startsWith("//snsvcodec"))
      {
        paramContext = paramString.split(" +");
        if (paramContext.length > 1)
        {
          paramContext = paramContext[1];
          if ("on".equalsIgnoreCase(paramContext))
          {
            ew(1);
            v.i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
          }
        }
        for (;;)
        {
          GMTrace.o(424262238208L, 3161);
          return true;
          if ("off".equalsIgnoreCase(paramContext))
          {
            ew(0);
            v.i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
            continue;
            ew(-1);
            v.i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
          }
        }
      }
      if (paramString.startsWith("//snswxpc"))
      {
        paramContext = paramString.split(" +");
        if (paramContext.length > 1)
        {
          paramContext = paramContext[1];
          if ("on".equalsIgnoreCase(paramContext))
          {
            ex(1);
            v.i("MicroMsg.CommandProcessor", "snswxpc val: 1");
          }
        }
        for (;;)
        {
          GMTrace.o(424262238208L, 3161);
          return true;
          if ("off".equalsIgnoreCase(paramContext))
          {
            ex(0);
            v.i("MicroMsg.CommandProcessor", "snswxpc val: 0");
            continue;
            ex(-1);
            v.i("MicroMsg.CommandProcessor", "snswxpc val: -1");
          }
        }
      }
      if (paramString.startsWith("//mmdumpsys"))
      {
        ap.vL().D(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(427886116864L, 3188);
            new ai(new ai.a()
            {
              /* Error */
              public final boolean oQ()
              {
                // Byte code:
                //   0: ldc2_w 36
                //   3: sipush 3144
                //   6: invokestatic 27	com/tencent/gmtrace/GMTrace:i	(JI)V
                //   9: bipush 23
                //   11: invokestatic 43	com/tencent/mm/compatible/util/d:eo	(I)Z
                //   14: ifeq +282 -> 296
                //   17: ldc 45
                //   19: ldc 47
                //   21: iconst_1
                //   22: anewarray 4	java/lang/Object
                //   25: dup
                //   26: iconst_0
                //   27: invokestatic 53	android/os/Debug:getRuntimeStats	()Ljava/util/Map;
                //   30: aastore
                //   31: invokestatic 58	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                //   34: invokestatic 62	android/os/Debug:getPss	()J
                //   37: lstore_1
                //   38: new 64	android/os/Debug$MemoryInfo
                //   41: dup
                //   42: invokespecial 65	android/os/Debug$MemoryInfo:<init>	()V
                //   45: astore_3
                //   46: aload_3
                //   47: invokestatic 69	android/os/Debug:getMemoryInfo	(Landroid/os/Debug$MemoryInfo;)V
                //   50: bipush 23
                //   52: invokestatic 43	com/tencent/mm/compatible/util/d:eo	(I)Z
                //   55: ifeq +273 -> 328
                //   58: ldc 45
                //   60: ldc 71
                //   62: iconst_2
                //   63: anewarray 4	java/lang/Object
                //   66: dup
                //   67: iconst_0
                //   68: lload_1
                //   69: invokestatic 77	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                //   72: aastore
                //   73: dup
                //   74: iconst_1
                //   75: aload_3
                //   76: invokevirtual 80	android/os/Debug$MemoryInfo:getMemoryStats	()Ljava/util/Map;
                //   79: aastore
                //   80: invokestatic 58	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                //   83: invokestatic 86	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
                //   86: ldc 88
                //   88: invokevirtual 92	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
                //   91: astore 5
                //   93: new 94	java/io/LineNumberReader
                //   96: dup
                //   97: new 96	java/io/InputStreamReader
                //   100: dup
                //   101: aload 5
                //   103: invokevirtual 102	java/lang/Process:getInputStream	()Ljava/io/InputStream;
                //   106: invokespecial 105	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
                //   109: invokespecial 108	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
                //   112: astore 4
                //   114: aload 4
                //   116: astore_3
                //   117: aload 4
                //   119: invokevirtual 112	java/io/LineNumberReader:readLine	()Ljava/lang/String;
                //   122: astore 6
                //   124: aload 6
                //   126: ifnull +233 -> 359
                //   129: aload 4
                //   131: astore_3
                //   132: aload 6
                //   134: invokevirtual 118	java/lang/String:length	()I
                //   137: ifle -23 -> 114
                //   140: aload 4
                //   142: astore_3
                //   143: ldc 45
                //   145: aload 6
                //   147: invokestatic 121	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
                //   150: goto -36 -> 114
                //   153: astore 5
                //   155: aload 4
                //   157: astore_3
                //   158: ldc 45
                //   160: ldc 123
                //   162: iconst_1
                //   163: anewarray 4	java/lang/Object
                //   166: dup
                //   167: iconst_0
                //   168: aload 5
                //   170: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
                //   173: aastore
                //   174: invokestatic 129	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                //   177: aload 4
                //   179: ifnull +8 -> 187
                //   182: aload 4
                //   184: invokevirtual 132	java/io/LineNumberReader:close	()V
                //   187: ldc 45
                //   189: ldc -122
                //   191: iconst_1
                //   192: anewarray 4	java/lang/Object
                //   195: dup
                //   196: iconst_0
                //   197: invokestatic 139	java/lang/Thread:activeCount	()I
                //   200: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                //   203: aastore
                //   204: invokestatic 58	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                //   207: invokestatic 147	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
                //   210: astore_3
                //   211: aload_3
                //   212: invokeinterface 153 1 0
                //   217: invokeinterface 159 1 0
                //   222: astore 4
                //   224: aload 4
                //   226: invokeinterface 164 1 0
                //   231: ifeq +234 -> 465
                //   234: aload 4
                //   236: invokeinterface 168 1 0
                //   241: checkcast 136	java/lang/Thread
                //   244: astore 5
                //   246: aload 5
                //   248: invokevirtual 172	java/lang/Thread:getState	()Ljava/lang/Thread$State;
                //   251: getstatic 178	java/lang/Thread$State:RUNNABLE	Ljava/lang/Thread$State;
                //   254: if_acmpne -30 -> 224
                //   257: ldc 45
                //   259: ldc -76
                //   261: iconst_2
                //   262: anewarray 4	java/lang/Object
                //   265: dup
                //   266: iconst_0
                //   267: aload 5
                //   269: invokevirtual 183	java/lang/Thread:getName	()Ljava/lang/String;
                //   272: aastore
                //   273: dup
                //   274: iconst_1
                //   275: aload_3
                //   276: aload 5
                //   278: invokeinterface 187 2 0
                //   283: checkcast 189	[Ljava/lang/StackTraceElement;
                //   286: invokestatic 195	com/tencent/mm/sdk/platformtools/ag:b	([Ljava/lang/StackTraceElement;)Ljava/lang/String;
                //   289: aastore
                //   290: invokestatic 58	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                //   293: goto -69 -> 224
                //   296: ldc 45
                //   298: ldc -59
                //   300: iconst_2
                //   301: anewarray 4	java/lang/Object
                //   304: dup
                //   305: iconst_0
                //   306: invokestatic 200	android/os/Debug:getGlobalGcInvocationCount	()I
                //   309: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                //   312: aastore
                //   313: dup
                //   314: iconst_1
                //   315: invokestatic 203	android/os/Debug:getThreadGcInvocationCount	()I
                //   318: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                //   321: aastore
                //   322: invokestatic 58	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                //   325: goto -291 -> 34
                //   328: ldc 45
                //   330: ldc -51
                //   332: iconst_2
                //   333: anewarray 4	java/lang/Object
                //   336: dup
                //   337: iconst_0
                //   338: lload_1
                //   339: invokestatic 77	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                //   342: aastore
                //   343: dup
                //   344: iconst_1
                //   345: aload_3
                //   346: getfield 209	android/os/Debug$MemoryInfo:nativePss	I
                //   349: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                //   352: aastore
                //   353: invokestatic 58	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                //   356: goto -273 -> 83
                //   359: aload 4
                //   361: astore_3
                //   362: aload 5
                //   364: invokevirtual 212	java/lang/Process:waitFor	()I
                //   367: pop
                //   368: aload 4
                //   370: astore_3
                //   371: aload 5
                //   373: invokevirtual 215	java/lang/Process:destroy	()V
                //   376: aload 4
                //   378: invokevirtual 132	java/io/LineNumberReader:close	()V
                //   381: goto -194 -> 187
                //   384: astore_3
                //   385: ldc 45
                //   387: ldc -39
                //   389: iconst_1
                //   390: anewarray 4	java/lang/Object
                //   393: dup
                //   394: iconst_0
                //   395: aload_3
                //   396: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
                //   399: aastore
                //   400: invokestatic 129	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                //   403: goto -216 -> 187
                //   406: astore_3
                //   407: ldc 45
                //   409: ldc -39
                //   411: iconst_1
                //   412: anewarray 4	java/lang/Object
                //   415: dup
                //   416: iconst_0
                //   417: aload_3
                //   418: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
                //   421: aastore
                //   422: invokestatic 129	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                //   425: goto -238 -> 187
                //   428: astore 4
                //   430: aconst_null
                //   431: astore_3
                //   432: aload_3
                //   433: ifnull +7 -> 440
                //   436: aload_3
                //   437: invokevirtual 132	java/io/LineNumberReader:close	()V
                //   440: aload 4
                //   442: athrow
                //   443: astore_3
                //   444: ldc 45
                //   446: ldc -39
                //   448: iconst_1
                //   449: anewarray 4	java/lang/Object
                //   452: dup
                //   453: iconst_0
                //   454: aload_3
                //   455: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
                //   458: aastore
                //   459: invokestatic 129	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
                //   462: goto -22 -> 440
                //   465: ldc2_w 36
                //   468: sipush 3144
                //   471: invokestatic 30	com/tencent/gmtrace/GMTrace:o	(JI)V
                //   474: iconst_1
                //   475: ireturn
                //   476: astore 4
                //   478: goto -46 -> 432
                //   481: astore 5
                //   483: aconst_null
                //   484: astore 4
                //   486: goto -331 -> 155
                // Local variable table:
                //   start	length	slot	name	signature
                //   0	489	0	this	1
                //   37	302	1	l	long
                //   45	326	3	localObject1	Object
                //   384	12	3	localException1	Exception
                //   406	12	3	localException2	Exception
                //   431	6	3	localObject2	Object
                //   443	12	3	localException3	Exception
                //   112	265	4	localObject3	Object
                //   428	13	4	localObject4	Object
                //   476	1	4	localObject5	Object
                //   484	1	4	localObject6	Object
                //   91	11	5	localProcess	Process
                //   153	16	5	localException4	Exception
                //   244	128	5	localThread	Thread
                //   481	1	5	localException5	Exception
                //   122	24	6	str	String
                // Exception table:
                //   from	to	target	type
                //   117	124	153	java/lang/Exception
                //   132	140	153	java/lang/Exception
                //   143	150	153	java/lang/Exception
                //   362	368	153	java/lang/Exception
                //   371	376	153	java/lang/Exception
                //   376	381	384	java/lang/Exception
                //   182	187	406	java/lang/Exception
                //   83	114	428	finally
                //   436	440	443	java/lang/Exception
                //   117	124	476	finally
                //   132	140	476	finally
                //   143	150	476	finally
                //   158	177	476	finally
                //   362	368	476	finally
                //   371	376	476	finally
                //   83	114	481	java/lang/Exception
              }
            }, true).v(10000L, 10000L);
            GMTrace.o(427886116864L, 3188);
          }
        });
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//remittance reset"))
      {
        ap.yY();
        com.tencent.mm.u.c.vr().set(327729, "0");
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//wv "))
      {
        paramString = paramString.replace("//wv ", "");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString);
        com.tencent.mm.bb.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//wvjsapi "))
      {
        paramString = paramString.replace("//wvjsapi ", "");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString);
        com.tencent.mm.bb.d.b(paramContext, "webview", ".ui.tools.WebViewTestUI", (Intent)localObject1);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//setibeacontabuinopen"))
      {
        if (ap.zb())
        {
          ap.yY();
          com.tencent.mm.u.c.vr().a(w.a.uAT, Integer.valueOf(1));
          GMTrace.o(424262238208L, 3161);
          return true;
        }
        GMTrace.o(424262238208L, 3161);
        return false;
      }
      if (paramString.startsWith("//setibeacontabuinclose"))
      {
        if (ap.zb())
        {
          ap.yY();
          com.tencent.mm.u.c.vr().a(w.a.uAT, Integer.valueOf(0));
          GMTrace.o(424262238208L, 3161);
          return true;
        }
        GMTrace.o(424262238208L, 3161);
        return false;
      }
      if (paramString.startsWith("//setibeaconpushopen"))
      {
        if (ap.zb())
        {
          ap.yY();
          com.tencent.mm.u.c.vr().a(w.a.uAO, Boolean.valueOf(true));
          GMTrace.o(424262238208L, 3161);
          return true;
        }
        GMTrace.o(424262238208L, 3161);
        return false;
      }
      if (paramString.startsWith("//setibeaconpushclose"))
      {
        if (ap.zb())
        {
          ap.yY();
          com.tencent.mm.u.c.vr().a(w.a.uAO, Boolean.valueOf(false));
          GMTrace.o(424262238208L, 3161);
          return true;
        }
        GMTrace.o(424262238208L, 3161);
        return false;
      }
      if (paramString.startsWith("//ibeacon"))
      {
        bool1 = false;
        bool3 = false;
        if (Build.VERSION.SDK_INT >= 18) {
          bool1 = true;
        }
        paramString = BluetoothAdapter.getDefaultAdapter();
        bool2 = bool3;
        if (paramString != null)
        {
          bool2 = bool3;
          if (paramString.getState() == 12) {
            bool2 = true;
          }
        }
        bool4 = paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if ((bool1) && (bool2) && (bool4)) {}
        for (bool3 = true;; bool3 = false)
        {
          paramString = "isNowSupportedIbeacon:" + bool3 + "\n\nisSystemSupported:" + bool1 + "\nisBlueStateOn:" + bool2 + "\nisSupportedBLE:" + bool4 + "\nSDK:" + Build.VERSION.SDK_INT + "\nModel:" + Build.BRAND + "-" + com.tencent.mm.compatible.d.p.rF() + "\noperatingSystemInfo:" + com.tencent.mm.compatible.d.p.rJ();
          com.tencent.mm.ui.base.g.b(paramContext, paramString, "TestResult", paramContext.getString(R.l.dTf), paramContext.getString(R.l.dXa), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(414732779520L, 3090);
              ((ClipboardManager)this.gTh.getSystemService("clipboard")).setText(paramString);
              GMTrace.o(414732779520L, 3090);
            }
          }, null);
          GMTrace.o(424262238208L, 3161);
          return true;
        }
      }
      if (paramString.startsWith("//gettbs"))
      {
        bool1 = com.tencent.mm.compatible.d.p.gQV.gRH;
        paramString = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        localObject1 = paramString.getString("tbs_download", null);
        localObject4 = paramString.getString("tbs_webview_disable", null);
        bool2 = paramString.getBoolean("x5_jscore_enabled", false);
        i = WebView.getTbsCoreVersion(paramContext);
        j = WebView.getTbsSDKVersion(paramContext);
        Toast.makeText(paramContext, String.format("forceSys:%b\ntbs_download:%s\ntbs_disable:%s\ntbs_disable_min_sdk_version:%s\ntbs_disable_max_sdk_version:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d\nx5JsCoreEnabled:%b", new Object[] { Boolean.valueOf(bool1), localObject1, localObject4, paramString.getString("tbs_webview_min_sdk_version", null), paramString.getString("tbs_webview_max_sdk_version", null), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool2) }), 1).show();
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//deletetbs"))
      {
        paramString = new Intent();
        paramString.setComponent(new ComponentName(com.tencent.mm.sdk.platformtools.aa.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
        paramContext.sendBroadcast(paramString);
        paramContext = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        paramContext.putLong("last_check_ts", 0L);
        paramContext.apply();
        ap.yY();
        com.tencent.mm.u.c.vr().a(w.a.uBQ, Boolean.valueOf(false));
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//tbsDisableOverScroll"))
      {
        localObject1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        try
        {
          paramContext = paramString.substring(paramString.indexOf(":") + 1);
          ((SharedPreferences.Editor)localObject1).putBoolean("tbs_disable_over_scroll", Boolean.parseBoolean(paramContext));
          ((SharedPreferences.Editor)localObject1).apply();
          GMTrace.o(424262238208L, 3161);
          return true;
        }
        catch (IndexOutOfBoundsException paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
      }
      if (paramString.startsWith("//enabletbs"))
      {
        localObject1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        paramString = paramString.replace("//enabletbs ", "");
        if ("1".equals(paramString)) {}
        for (paramContext = "0";; paramContext = "1")
        {
          ((SharedPreferences.Editor)localObject1).putString("tbs_webview_disable", paramContext);
          if ("0".equals(paramString))
          {
            ((SharedPreferences.Editor)localObject1).putString("tbs_webview_min_sdk_version", "0");
            ((SharedPreferences.Editor)localObject1).putString("tbs_webview_max_sdk_version", "0");
          }
          ((SharedPreferences.Editor)localObject1).apply();
          GMTrace.o(424262238208L, 3161);
          return true;
        }
      }
      if (paramString.startsWith("//wvsha1"))
      {
        localObject1 = paramContext.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
        try
        {
          paramContext = paramString.substring(paramString.indexOf(":") + 1);
          ((SharedPreferences.Editor)localObject1).putBoolean("wvsha1", Boolean.parseBoolean(paramContext));
          ((SharedPreferences.Editor)localObject1).apply();
          GMTrace.o(424262238208L, 3161);
          return true;
        }
        catch (IndexOutOfBoundsException paramContext)
        {
          for (;;)
          {
            paramContext = "";
          }
        }
      }
      if (paramString.startsWith("//channelId")) {
        com.tencent.mm.ui.base.g.z(paramContext, com.tencent.mm.sdk.platformtools.f.fuN, "channelId");
      }
      if (paramString.startsWith("//traceroute"))
      {
        com.tencent.mm.bb.d.w(paramContext, "traceroute", ".ui.NetworkDiagnoseIntroUI");
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//qzone "))
      {
        localObject1 = paramString.replace("//qzone ", "");
        new com.tencent.mm.pluginsdk.ui.applet.o(paramContext).MS((String)localObject1);
      }
      if (paramString.startsWith("//dumpcrash"))
      {
        com.tencent.mm.sdk.platformtools.j.p(com.tencent.mm.compatible.util.e.hgg + "crash/", com.tencent.mm.compatible.util.e.hgl, false);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//dumpanr"))
      {
        com.tencent.mm.sdk.platformtools.j.p("/data/anr/", com.tencent.mm.compatible.util.e.hgl, false);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//testanr")) {
        try
        {
          Thread.sleep(10000L);
          GMTrace.o(424262238208L, 3161);
          return true;
        }
        catch (InterruptedException paramContext)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          }
        }
      }
      if (paramString.startsWith("//opensnsadRightbar"))
      {
        r.iiL = true;
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//setlocation "))
      {
        paramContext = paramString.split(" ");
        if ((paramContext != null) && (com.tencent.mm.sdk.a.b.bIk()))
        {
          r.iib = true;
          if (paramContext.length > 0) {
            r.lat = bf.getDouble(paramContext[1], 0.0D);
          }
          if (paramContext.length > 1) {
            r.lng = bf.getDouble(paramContext[2], 0.0D);
          }
          GMTrace.o(424262238208L, 3161);
          return true;
        }
        GMTrace.o(424262238208L, 3161);
        return false;
      }
      if (paramString.startsWith("//switchsdcard"))
      {
        paramString = com.tencent.mm.sdk.platformtools.au.bJs();
        j = paramString.size();
        v.i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = " + j);
        if ((j > 0) && (paramString.get(0) != null) && (!bf.mA(((au.a)paramString.get(0)).utF)))
        {
          i = 0;
          while (i < j)
          {
            v.i("MicroMsg.CommandProcessor", "switchsdcard list i = " + i + " StatMountParse: " + paramString.get(i));
            i += 1;
          }
        }
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label14742;
          }
          if (!((au.a)paramString.get(i)).utF.equals(com.tencent.mm.compatible.util.e.hgi))
          {
            paramString = ((au.a)paramString.get(i)).utF;
            localObject1 = (Activity)paramContext;
            v.i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: " + paramString);
            if (!bf.mA(paramString)) {
              break;
            }
            com.tencent.mm.ui.base.g.bi(paramContext, paramContext.getString(R.l.eXj));
            GMTrace.o(424262238208L, 3161);
            return true;
          }
          i += 1;
        }
        com.tencent.mm.ui.base.g.b(paramContext, paramContext.getString(R.l.eXk), "", paramContext.getString(R.l.dHL), paramContext.getString(R.l.dGk), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(415001214976L, 3092);
            paramAnonymousDialogInterface = new s(w.hgg + "SdcardInfo.cfg");
            paramAnonymousDialogInterface.set(1, this.gTy);
            v.i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + paramAnonymousDialogInterface.get(1));
            com.tencent.mm.sdk.platformtools.ac.Pt("welcome_page_show");
            com.tencent.mm.kernel.k.e(paramContext, true);
            paramAnonymousDialogInterface = new com.tencent.mm.e.a.y();
            paramAnonymousDialogInterface.fCW.fCX = false;
            com.tencent.mm.sdk.b.a.uql.m(paramAnonymousDialogInterface);
            WorkerProfile.oC().fxl.ox();
            ap.getNotification().qi();
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.setComponent(new ComponentName(d.g.uMO, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            paramAnonymousDialogInterface.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            com.tencent.mm.sdk.platformtools.aa.getContext().sendBroadcast(paramAnonymousDialogInterface);
            if (l.a.szN != null) {
              l.a.szN.ai(localObject1);
            }
            localObject1.finish();
            GMTrace.o(415001214976L, 3092);
          }
        }, null);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//getip"))
      {
        ap.vd().d(new com.tencent.mm.u.bb(new bb.a()
        {
          public final void a(com.tencent.mm.network.e paramAnonymouse)
          {
            GMTrace.i(420638359552L, 3134);
            if (paramAnonymouse == null)
            {
              GMTrace.o(420638359552L, 3134);
              return;
            }
            String[] arrayOfString = paramAnonymouse.getIPsString(true);
            int i = 0;
            while (i < arrayOfString.length)
            {
              v.d("MicroMsg.CommandProcessor", "dkip long:%d  %s", new Object[] { Integer.valueOf(i), arrayOfString[i] });
              v.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[] { Integer.valueOf(i), com.tencent.mm.network.a.c.ml(arrayOfString[i]).toString() });
              i += 1;
            }
            paramAnonymouse = paramAnonymouse.getIPsString(false);
            i = 0;
            while (i < paramAnonymouse.length)
            {
              v.d("MicroMsg.CommandProcessor", "dkip short:%d %s", new Object[] { Integer.valueOf(i), paramAnonymouse[i] });
              v.d("MicroMsg.CommandProcessor", "dkip long:%d %s", new Object[] { Integer.valueOf(i), com.tencent.mm.network.a.c.ml(paramAnonymouse[i]).toString() });
              i += 1;
            }
            GMTrace.o(420638359552L, 3134);
          }
        }));
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//localjsapi"))
      {
        paramString = "file://" + com.tencent.mm.compatible.util.e.hgk + "test_jsapi.html";
        v.v("MicroMsg.CommandProcessor", "alvinluo path: %s", new Object[] { paramString });
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramString);
        com.tencent.mm.bb.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//getlocalkey"))
      {
        paramString = com.tencent.mm.storage.ba.bML();
        com.tencent.mm.ui.base.g.b(paramContext, paramString, "Fingerprint Key", paramContext.getString(R.l.fbV), paramContext.getString(R.l.dXa), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(423859585024L, 3158);
            ((ClipboardManager)this.gTh.getSystemService("clipboard")).setText(paramString);
            Toast.makeText(this.gTh, R.l.fbW, 0).show();
            GMTrace.o(423859585024L, 3158);
          }
        }, null);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//getdevid"))
      {
        paramString = com.tencent.mm.compatible.d.p.rB();
        com.tencent.mm.ui.base.g.b(paramContext, paramString, "devid", paramContext.getString(R.l.dTf), paramContext.getString(R.l.dXa), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(425335980032L, 3169);
            ((ClipboardManager)this.gTh.getSystemService("clipboard")).setText(paramString);
            GMTrace.o(425335980032L, 3169);
          }
        }, null);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//testhtml"))
      {
        paramString = new Intent();
        paramString.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
        com.tencent.mm.bb.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramString);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//testlocalhtml "))
      {
        paramString = paramString.replace("//testlocalhtml ", "");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", "file://" + paramString);
        ((Intent)localObject1).putExtra("neverGetA8Key", true);
        com.tencent.mm.bb.d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//setkey"))
      {
        if (com.tencent.mm.storage.ba.RW(paramString.replace("//setkey", ""))) {
          Toast.makeText(paramContext, R.l.fbo, 0).show();
        }
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//checkspell"))
      {
        paramString = paramString.replace("//checkspell ", "");
        if (bf.mA(paramString))
        {
          GMTrace.o(424262238208L, 3161);
          return true;
        }
        localObject1 = new StringBuilder();
        i = 0;
        while (i < paramString.length())
        {
          ((StringBuilder)localObject1).append("[" + paramString.charAt(i) + ":" + SpellMap.d(paramString.charAt(i)) + "]");
          i += 1;
        }
        com.tencent.mm.ui.base.g.z(paramContext, ((StringBuilder)localObject1).toString(), "Check Spell");
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//gallery "))
      {
        paramString = paramString.replace("//gallery ", "");
        if (bf.mA(paramString))
        {
          GMTrace.o(424262238208L, 3161);
          return true;
        }
        paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.aa.bIN(), 0).edit().putString("gallery", paramString).commit();
        GMTrace.o(424262238208L, 3161);
        return true;
      }
      if (paramString.startsWith("//svgtag"))
      {
        paramContext = paramString.replace("//svgtag ", "");
        if (paramContext.equals("on")) {
          com.tencent.mm.bh.c.jI(true);
        }
        for (;;)
        {
          GMTrace.o(424262238208L, 3161);
          return true;
          if (paramContext.equals("off")) {
            com.tencent.mm.bh.c.jI(false);
          }
        }
      }
      if (paramString.startsWith("//svgcode")) {}
      try
      {
        paramContext = paramString.replace("//svgcode ", "");
        if (!paramContext.equals("on")) {
          paramContext.equals("off");
        }
        paramContext = Class.forName("com.tencent.mm.BuildConfig");
        paramString = paramContext.getDeclaredField("SVGCode");
        paramString.setAccessible(true);
        bool1 = paramString.getBoolean(paramContext);
      }
      catch (ClassNotFoundException paramContext)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (NoSuchFieldException paramContext)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (IllegalAccessException paramContext)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
      }
      catch (IllegalArgumentException paramContext)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
          bool1 = false;
        }
        if (!paramString.startsWith("//testMbanner")) {
          break label6737;
        }
        try
        {
          paramContext = paramString.replace("//testMbanner ", "").split(",");
          if (paramContext.length < 2) {
            break label6726;
          }
          ax.zj().a(new aw(Integer.valueOf(paramContext[0]).intValue(), Integer.valueOf(paramContext[1]).intValue(), null));
          GMTrace.o(424262238208L, 3161);
          return true;
          if (!paramString.startsWith("//testrsa")) {
            break label6758;
          }
          com.tencent.mm.protocal.ac.G("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", 106);
          if (!paramString.startsWith("//recomT")) {
            break label6801;
          }
          try
          {
            paramContext = paramString.replace("//recomT ", "");
            ap.yY().xy().a(paramContext, true, null);
            GMTrace.o(424262238208L, 3161);
            return true;
            if (!paramString.startsWith("//recomF")) {
              break label6844;
            }
            try
            {
              paramContext = paramString.replace("//recomF ", "");
              ap.yY().xy().a(paramContext, false, null);
              GMTrace.o(424262238208L, 3161);
              return true;
              if (!paramString.startsWith("//testgetreg")) {
                break label6934;
              }
              try
              {
                paramContext = paramString.replace("//testgetreg ", "").split(",");
                if (paramContext.length <= 2) {
                  break label6923;
                }
                new bf.a().fi(Integer.valueOf(paramContext[0]).intValue()).fk(Integer.valueOf(paramContext[1]).intValue()).fj(Integer.valueOf(paramContext[2]).intValue()).commit();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//ffmpeg")) {
                  break label7071;
                }
                try
                {
                  i = paramString.indexOf("-r ");
                  j = paramString.indexOf("-b ");
                  paramContext = paramString.substring(i + 3, j);
                  paramString = paramString.substring(j + 3);
                  float f = bf.getFloat(paramContext.trim(), 0.0F);
                  i = bf.getInt(paramString.trim(), 0);
                  com.tencent.mm.plugin.sight.base.b.prY = i;
                  com.tencent.mm.plugin.sight.base.b.prZ = f;
                  Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), "set C2C video encode frame rate " + f + " bitrate " + i, 0).show();
                  GMTrace.o(424262238208L, 3161);
                  return true;
                }
                catch (Exception paramContext)
                {
                  for (;;)
                  {
                    Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                  }
                }
                if (!paramString.startsWith("//onlinevideo")) {
                  break label7179;
                }
                for (;;)
                {
                  try
                  {
                    i = bf.getInt(paramString.replace("//onlinevideo ", ""), 0);
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.uCU, Integer.valueOf(i));
                    if (i <= 0) {
                      continue;
                    }
                    paramContext = "online video";
                    Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), paramContext, 0).show();
                  }
                  catch (Exception paramContext)
                  {
                    v.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                    Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), "set online video fail, please ensure your command.", 1).show();
                    continue;
                  }
                  GMTrace.o(424262238208L, 3161);
                  return true;
                  paramContext = "offline video";
                }
                if (!paramString.startsWith("//hevcinfo")) {
                  break label7255;
                }
                paramContext = com.tencent.mm.plugin.s.e.aKj();
                paramString = En_5b8fbb1e.a.vGp;
                localObject1 = new com.tencent.mm.storage.au();
                ((com.tencent.mm.storage.au)localObject1).cH(paramString);
                ((com.tencent.mm.storage.au)localObject1).dw(2);
                ((com.tencent.mm.storage.au)localObject1).setType(1);
                ((com.tencent.mm.storage.au)localObject1).z(System.currentTimeMillis());
                ((com.tencent.mm.storage.au)localObject1).setContent(paramContext);
                ay.i((com.tencent.mm.storage.au)localObject1);
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//presns")) {
                  break label7306;
                }
                com.tencent.mm.kernel.h.vL().e(new Runnable()
                {
                  public final void run()
                  {
                    GMTrace.i(16873181675520L, 125715);
                    com.tencent.mm.sdk.b.a.uql.m(new pc());
                    GMTrace.o(16873181675520L, 125715);
                  }
                }, 3000L);
                Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), "preload sns", 0).show();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//calcwxdata")) {
                  break label7357;
                }
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uFK, Long.valueOf(0L));
                Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), "calc wx data success", 0).show();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//upfacemodel")) {
                  break label7394;
                }
                ap.vd().d(new com.tencent.mm.pluginsdk.k.a.b.m(42));
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//facett")) {
                  break label7432;
                }
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.uEt, Boolean.valueOf(false));
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//switchpaytype")) {
                  break label7527;
                }
                paramContext = paramString.split(" ");
                if ((paramContext == null) || (paramContext.length < 2)) {
                  break label7516;
                }
                try
                {
                  i = bf.getInt(paramContext[1], 0);
                  ap.yY();
                  com.tencent.mm.u.c.vr().set(339975, Integer.valueOf(i));
                  GMTrace.o(424262238208L, 3161);
                  return true;
                }
                catch (Exception paramContext)
                {
                  v.e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                  GMTrace.o(424262238208L, 3161);
                  return false;
                }
                GMTrace.o(424262238208L, 3161);
                return false;
                if (!paramString.startsWith("//setNfcOpenUrl ")) {
                  break label7585;
                }
                paramContext = paramString.replace("//setNfcOpenUrl ", "");
                paramString = com.tencent.mm.sdk.platformtools.aa.bIP().edit();
                paramString.putString("nfc_open_url", paramContext);
                paramString.commit();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//snskvtest ")) {
                  break label7650;
                }
                paramContext = paramString.replace("//snskvtest", "").trim();
                if (!paramContext.equals("0")) {
                  break label7633;
                }
                r.ijh = false;
                for (;;)
                {
                  GMTrace.o(424262238208L, 3161);
                  return true;
                  if (paramContext.equals("1")) {
                    r.ijh = true;
                  }
                }
                if (!paramString.startsWith("//emoji ")) {
                  break label7701;
                }
                paramContext = paramString.replace("//emoji ", "");
                ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uh(paramContext);
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//share ")) {
                  break label7755;
                }
                i = Integer.valueOf(paramString.replace("//share ", "")).intValue();
                ap.yY();
                com.tencent.mm.u.c.vr().set(229635, Integer.valueOf(i));
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//dumpappinfoblob ")) {
                  break label7844;
                }
                paramString = paramString.replace("//dumpappinfoblob ", "");
                paramString = an.aRk().Md(paramString);
                com.tencent.mm.ui.base.g.z(paramContext, paramString.px() + "\n" + paramString.py() + "\n" + paramString.pz(), "");
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//googleauth ")) {
                  break label7961;
                }
                paramString = paramString.replace("//googleauth ", "");
                if (TextUtils.isEmpty(paramString)) {
                  break label7909;
                }
                if (!"webview".equals(paramString)) {
                  break label7920;
                }
                paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.aa.bIN(), 0).edit().putBoolean("googleauth", true).commit();
                for (;;)
                {
                  GMTrace.o(424262238208L, 3161);
                  return true;
                  if ("local".equals(paramString)) {
                    paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.aa.bIN(), 0).edit().putBoolean("googleauth", false).commit();
                  }
                }
                if (!paramString.startsWith("//clrgamecache")) {
                  break label7997;
                }
                paramString = l.a.bCg();
                if (paramString == null) {
                  break label7986;
                }
                paramString.cl(paramContext);
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//clearwepkg")) {
                  break label8081;
                }
                paramContext = new ss();
                paramContext.gau.fEx = 6;
                paramString = paramString.replace("//clearwepkg ", "").trim();
                if ((bf.mA(paramString)) || (paramString.equals("//clearwepkg"))) {
                  break label8062;
                }
                paramContext.gau.gav = paramString;
                com.tencent.mm.sdk.b.a.uql.m(paramContext);
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//googlemap")) {
                  break label8106;
                }
                r.iiK = true;
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//sosomap")) {
                  break label8131;
                }
                r.iiK = false;
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//opentrace")) {
                  break label8166;
                }
                new com.tencent.mm.ui.applet.d();
                com.tencent.mm.ui.applet.d.eJ(com.tencent.mm.sdk.platformtools.aa.getContext());
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//updateConversation")) {
                  break label8275;
                }
                v.i("MicroMsg.CommandProcessor", "update all conversation start");
                ap.yY();
                paramContext = com.tencent.mm.u.c.wW().bLy().iterator();
                while (paramContext.hasNext())
                {
                  paramString = (String)paramContext.next();
                  ap.yY();
                  paramString = com.tencent.mm.u.c.wT().cN(paramString, " and not ( type = 10000 and isSend != 2 ) ");
                  ap.yY();
                  com.tencent.mm.u.c.wW().X(paramString);
                }
                v.i("MicroMsg.CommandProcessor", "update all conversation end");
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//setshakecarddata")) {
                  break label8304;
                }
                l.a.bCf().baH();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//clearshakecarddata")) {
                  break label8333;
                }
                l.a.bCf().baI();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//pageSize")) {
                  break label8394;
                }
                paramContext = com.tencent.mm.sdk.platformtools.aa.getContext();
                paramString = new StringBuilder("pageSize is ");
                ap.yY();
                Toast.makeText(paramContext, com.tencent.mm.u.c.wO().getPageSize(), 1).show();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//resetDBStatus")) {
                  break label8582;
                }
                ap.yY();
                paramContext = new File(com.tencent.mm.u.c.vp());
                try
                {
                  paramString = new StringBuilder();
                  ap.yY();
                  paramString = com.tencent.mm.u.c.xu() + paramContext.getName().replace(".db", ".db.backup");
                  com.tencent.mm.ui.tools.e.e(new File(paramString), paramContext);
                  v.i("MicroMsg.CommandProcessor", "backupPath db path is %s", new Object[] { paramString });
                  com.tencent.mm.a.e.a(paramContext, new File(paramContext.getAbsolutePath() + "err" + System.currentTimeMillis()));
                  Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), "db状态已重置,请重启微信", 1).show();
                  GMTrace.o(424262238208L, 3161);
                  return true;
                }
                catch (Exception paramContext)
                {
                  for (;;)
                  {
                    v.w("MicroMsg.CommandProcessor", "delete failed: " + paramContext.getMessage());
                  }
                }
                if (!paramString.startsWith("//makesnsdata ")) {
                  break label8627;
                }
                i = bf.getInt(paramString.replace("//makesnsdata ", ""), 0);
                l.z.bCl().dc(i);
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//setsnsupload ")) {
                  break label8664;
                }
                r.iiU = bf.getInt(paramString.replace("//setsnsupload ", ""), 0);
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//logsnstable")) {
                  break label8701;
                }
                paramContext = new cf();
                com.tencent.mm.sdk.b.a.uql.m(paramContext);
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//fpsreset ")) {
                  break label8767;
                }
                paramContext = new fi();
                if (!paramString.equalsIgnoreCase("//fpsreset on")) {
                  break label8756;
                }
                for (paramContext.fJL.fEx = 1;; paramContext.fJL.fEx = 0)
                {
                  com.tencent.mm.sdk.b.a.uql.m(paramContext);
                  GMTrace.o(424262238208L, 3161);
                  return true;
                }
                if (!paramString.startsWith("//resetsnstip")) {
                  break label8805;
                }
                ap.yY();
                com.tencent.mm.u.c.vr().set(327776, Integer.valueOf(0));
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//checkcount")) {
                  break label8895;
                }
                ap.yY();
                i = com.tencent.mm.u.c.wT().Ax(En_5b8fbb1e.a.vGp);
                ap.yY();
                j = com.tencent.mm.u.c.wT().Av(En_5b8fbb1e.a.vGp);
                Toast.makeText(paramContext, "current count :" + i + " countAuto :" + j, 1).show();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//changeframe ")) {
                  break label8962;
                }
                paramContext = paramString.replace("//changeframe ", "");
                com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(paramContext).floatValue()).commit();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//opendumpview")) {
                  break label8997;
                }
                new com.tencent.mm.ui.applet.c();
                com.tencent.mm.ui.applet.c.eI(com.tencent.mm.sdk.platformtools.aa.getContext());
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//dumpmemory")) {
                  break label9027;
                }
                System.gc();
                System.gc();
                com.tencent.mm.bl.b.bNW();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//dumpsnsfile")) {
                  break label9064;
                }
                paramContext = new or();
                com.tencent.mm.sdk.b.a.uql.m(paramContext);
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//coverage")) {
                  break label9098;
                }
                com.tencent.mm.plugin.report.b.f.Dy(paramString.trim().substring(10));
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//dumpthreadpool")) {
                  break label9122;
                }
                com.tencent.mm.sdk.f.e.bKl();
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//testverifypsw ")) {
                  break label9213;
                }
                paramContext = paramString.replace("//testverifypsw ", "").trim();
                if (!paramContext.equals("0")) {
                  break label9196;
                }
                r.ijj = false;
                for (;;)
                {
                  v.d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", new Object[] { paramString, Boolean.valueOf(r.ijj) });
                  GMTrace.o(424262238208L, 3161);
                  return true;
                  if (paramContext.equals("1")) {
                    r.ijj = true;
                  }
                }
                if (!paramString.startsWith("//pickpoi")) {
                  break label9263;
                }
                paramString = new Intent();
                paramString.putExtra("map_view_type", 8);
                com.tencent.mm.bb.d.b(paramContext, "location", ".ui.RedirectUI", paramString);
                GMTrace.o(424262238208L, 3161);
                return true;
                if (!paramString.startsWith("//configlist")) {
                  break label9570;
                }
                if (!paramString.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                  break label9362;
                }
                paramString = com.tencent.mm.platformtools.u.aq(paramString, "^//configlist set ([\\S]*)=([\\S]*)$");
                if ((paramString == null) || (paramString.size() != 2)) {
                  break label9351;
                }
                paramContext = (String)paramString.get(0);
                paramString = (String)paramString.get(1);
                com.tencent.mm.i.g.sV().put(paramContext, paramString);
                paramContext = new cg();
                com.tencent.mm.sdk.b.a.uql.m(paramContext);
                for (;;)
                {
                  GMTrace.o(424262238208L, 3161);
                  return true;
                  if (paramString.matches("^//configlist get ([\\S]*)$"))
                  {
                    paramString = com.tencent.mm.platformtools.u.aq(paramString, "^//configlist get ([\\S]*)$");
                    if ((paramString != null) && (paramString.size() == 1))
                    {
                      paramString = (String)paramString.get(0);
                      localObject1 = com.tencent.mm.i.g.sV().getValue(paramString);
                      Toast.makeText(paramContext, paramString + "=" + (String)localObject1, 0).show();
                    }
                  }
                  else
                  {
                    ap.yY();
                    paramString = (String)com.tencent.mm.u.c.vr().get(278530, "");
                    ap.yY();
                    localObject1 = (String)com.tencent.mm.u.c.vr().get(278529, "");
                    localObject4 = com.tencent.mm.compatible.util.e.hgk + "dynacfg.xml";
                    bf.q((String)localObject4, (paramString + (String)localObject1).getBytes());
                    Toast.makeText(paramContext, "output dynacfg xml to " + (String)localObject4, 0).show();
                  }
                }
                if (!paramString.startsWith("//security")) {
                  break label9613;
                }
                try
                {
                  paramContext = paramString.replace("//security ", "");
                  ap.yY().xz().a(paramContext, true, null);
                  GMTrace.o(424262238208L, 3161);
                  return true;
                  if (!paramString.startsWith("//updatepackage")) {
                    break label9666;
                  }
                  try
                  {
                    paramContext = new com.tencent.mm.ap.k(bf.getInt(paramString.replace("//updatepackage ", "").trim(), 0));
                    ap.vd().d(paramContext);
                    GMTrace.o(424262238208L, 3161);
                    return true;
                    if (!paramString.startsWith("//copypackage")) {
                      break label9792;
                    }
                    v.i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", new Object[] { paramString });
                    paramString = com.tencent.mm.sdk.platformtools.au.bJs();
                    i = paramString.size();
                    v.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", new Object[] { Integer.valueOf(i) });
                    if (i >= 2) {
                      break label9750;
                    }
                    com.tencent.mm.ui.base.g.bi(paramContext, paramContext.getString(R.l.eaE));
                    for (;;)
                    {
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      com.tencent.mm.ui.base.g.b(paramContext, paramContext.getString(R.l.eaG), "", paramContext.getString(R.l.dHL), paramContext.getString(R.l.dGk), new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                        {
                          GMTrace.i(427080810496L, 3182);
                          com.tencent.mm.sdk.f.e.post(new Runnable()
                          {
                            public final void run()
                            {
                              GMTrace.i(427349245952L, 3184);
                              try
                              {
                                String str1 = com.tencent.mm.compatible.util.e.hgi;
                                ap.yY();
                                String str2 = com.tencent.mm.u.c.xl();
                                ap.yY();
                                Object localObject = com.tencent.mm.u.c.wK();
                                String str3 = str2.substring(str1.length());
                                v.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", new Object[] { Integer.valueOf(b.5.this.gTk), str1, str2, localObject, str3 });
                                int i = 0;
                                while (i < b.5.this.gTk)
                                {
                                  localObject = ((au.a)b.5.this.gTl.get(i)).utF;
                                  if ((!bf.mA((String)localObject)) && (!str1.contains((CharSequence)localObject)))
                                  {
                                    localObject = new File((String)localObject + str3);
                                    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
                                    {
                                      boolean bool = com.tencent.mm.sdk.platformtools.j.p(((File)localObject).getAbsolutePath(), str2, false);
                                      v.i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", new Object[] { str2, ((File)localObject).getAbsolutePath(), Boolean.valueOf(bool) });
                                      if (bool)
                                      {
                                        new com.tencent.mm.sdk.platformtools.ad(Looper.getMainLooper()).post(new Runnable()
                                        {
                                          public final void run()
                                          {
                                            GMTrace.i(423591149568L, 3156);
                                            com.tencent.mm.ui.base.g.bk(b.5.this.val$context, b.5.this.val$context.getString(R.l.eaF));
                                            GMTrace.o(423591149568L, 3156);
                                          }
                                        });
                                        GMTrace.o(427349245952L, 3184);
                                        return;
                                      }
                                    }
                                  }
                                  i += 1;
                                }
                                new com.tencent.mm.sdk.platformtools.ad(Looper.getMainLooper()).post(new Runnable()
                                {
                                  public final void run()
                                  {
                                    GMTrace.i(421712101376L, 3142);
                                    com.tencent.mm.ui.base.g.bk(b.5.this.val$context, b.5.this.val$context.getString(R.l.eaE));
                                    GMTrace.o(421712101376L, 3142);
                                  }
                                });
                                GMTrace.o(427349245952L, 3184);
                                return;
                              }
                              catch (Exception localException)
                              {
                                v.w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", new Object[] { localException.getMessage() });
                                GMTrace.o(427349245952L, 3184);
                              }
                            }
                          }, "copypackage");
                          GMTrace.o(427080810496L, 3182);
                        }
                      }, null);
                    }
                    if (!paramString.startsWith("//copy -n ")) {
                      break label9922;
                    }
                    v.i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", new Object[] { paramString });
                    localObject1 = com.tencent.mm.sdk.platformtools.au.bJs();
                    i = ((ArrayList)localObject1).size();
                    v.i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", new Object[] { Integer.valueOf(i) });
                    if (i >= 2) {
                      break label9878;
                    }
                    com.tencent.mm.ui.base.g.bi(paramContext, paramContext.getString(R.l.eaE));
                    for (;;)
                    {
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      com.tencent.mm.ui.base.g.b(paramContext, paramContext.getString(R.l.eaG), "", paramContext.getString(R.l.dHL), paramContext.getString(R.l.dGk), new DialogInterface.OnClickListener()
                      {
                        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                        {
                          GMTrace.i(16873718546432L, 125719);
                          com.tencent.mm.sdk.f.e.post(new Runnable()
                          {
                            public final void run()
                            {
                              GMTrace.i(16873986981888L, 125721);
                              try
                              {
                                Object localObject1 = b.6.this.gTo.substring(10);
                                String str1 = com.tencent.mm.compatible.util.e.hgi;
                                ap.yY();
                                Object localObject2 = com.tencent.mm.u.c.xv();
                                String str2 = (String)localObject2 + (String)localObject1;
                                String str3 = str2.substring(str1.length());
                                v.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", new Object[] { localObject1, str1, localObject2, str2, str3 });
                                int i = 0;
                                while (i < b.6.this.gTk)
                                {
                                  localObject1 = ((au.a)b.6.this.gTl.get(i)).utF;
                                  if ((!bf.mA((String)localObject1)) && (!str1.contains((CharSequence)localObject1)))
                                  {
                                    localObject1 = new File((String)localObject1 + str3);
                                    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
                                    {
                                      localObject2 = new File(str2);
                                      if (!((File)localObject2).exists()) {
                                        ((File)localObject2).mkdir();
                                      }
                                      boolean bool = com.tencent.mm.sdk.platformtools.j.p(((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath(), false);
                                      v.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", new Object[] { ((File)localObject2).getAbsolutePath(), ((File)localObject1).getAbsolutePath(), Boolean.valueOf(bool) });
                                      if (bool)
                                      {
                                        new com.tencent.mm.sdk.platformtools.ad(Looper.getMainLooper()).post(new Runnable()
                                        {
                                          public final void run()
                                          {
                                            GMTrace.i(16874926505984L, 125728);
                                            com.tencent.mm.ui.base.g.bk(b.6.this.val$context, b.6.this.val$context.getString(R.l.eaF));
                                            GMTrace.o(16874926505984L, 125728);
                                          }
                                        });
                                        GMTrace.o(16873986981888L, 125721);
                                        return;
                                      }
                                    }
                                  }
                                  i += 1;
                                }
                                new com.tencent.mm.sdk.platformtools.ad(Looper.getMainLooper()).post(new Runnable()
                                {
                                  public final void run()
                                  {
                                    GMTrace.i(16874389635072L, 125724);
                                    com.tencent.mm.ui.base.g.bk(b.6.this.val$context, b.6.this.val$context.getString(R.l.eaE));
                                    GMTrace.o(16874389635072L, 125724);
                                  }
                                });
                                GMTrace.o(16873986981888L, 125721);
                                return;
                              }
                              catch (Exception localException)
                              {
                                v.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", new Object[] { localException.getMessage() });
                                GMTrace.o(16873986981888L, 125721);
                              }
                            }
                          }, "copy -n");
                          GMTrace.o(16873718546432L, 125719);
                        }
                      }, null);
                    }
                    if (!paramString.startsWith("//deletepackage")) {
                      break label9981;
                    }
                    try
                    {
                      paramContext = paramString.replace("//deletepackage ", "");
                      paramString = new bz();
                      paramString.fFp.fFq = bf.getInt(paramContext, 0);
                      com.tencent.mm.sdk.b.a.uql.m(paramString);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//audiowritetofile")) {
                        break label10009;
                      }
                      com.tencent.mm.compatible.d.p.gQT.gOh = true;
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//bankcard")) {
                        break label10087;
                      }
                      paramString = new Intent();
                      paramString.putExtra("BaseScanUI_select_scan_mode", 7);
                      paramString.putExtra("bank_card_owner", "test");
                      if ((com.tencent.mm.modelvideo.y.aI(paramContext)) || (com.tencent.mm.al.a.aH(paramContext))) {
                        break label10076;
                      }
                      com.tencent.mm.bb.d.b((Activity)paramContext, "scanner", ".ui.BaseScanUI", paramString);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//banner")) {
                        break label10169;
                      }
                      localObject1 = bg.q("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                      v.d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", new Object[] { (String)((Map)localObject1).get(".sysmsg.mainframebanner.$type"), (String)((Map)localObject1).get(".sysmsg.mainframebanner.showtype"), (String)((Map)localObject1).get(".sysmsg.mainframebanner.data") });
                      if (!paramString.startsWith("//gamemsg")) {
                        break label10214;
                      }
                      paramContext = new lj();
                      paramContext.fSa.content = paramString;
                      com.tencent.mm.sdk.b.a.uql.m(paramContext);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//shortcut#")) {
                        break label10244;
                      }
                      com.tencent.mm.plugin.ac.c.prQ = paramString.substring(11);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//gallerytype")) {
                        break label10285;
                      }
                      if (com.tencent.mm.ui.chatting.af.vzL) {
                        break label10279;
                      }
                      for (bool1 = true;; bool1 = false)
                      {
                        com.tencent.mm.ui.chatting.af.vzL = bool1;
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      }
                      paramContext.getString(R.l.fcM);
                      if (!paramString.startsWith("//fullexit")) {
                        break label10343;
                      }
                      com.tencent.mm.sdk.platformtools.ac.Pt("show_whatsnew");
                      com.tencent.mm.kernel.k.e(paramContext, true);
                      MMAppMgr.ai(paramContext);
                      ap.hold();
                      com.tencent.mm.kernel.h.vJ().eh("");
                      MMAppMgr.Sh();
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//cleardldb")) {
                        break label10375;
                      }
                      ap.yY();
                      com.tencent.mm.u.c.wX().akM();
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//setcardlayouttestdata")) {
                        break label10420;
                      }
                      paramContext = paramString.replace("//setcardlayouttestdata ", "");
                      ap.yY();
                      com.tencent.mm.u.c.vr().a(w.a.uyR, paramContext);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//delchatroomsysmsg")) {
                        break label10559;
                      }
                      paramString = paramString.replace("//delchatroomsysmsg ", "");
                      i = paramString.indexOf(" ");
                      paramContext = paramString.substring(0, i);
                      paramString = paramString.substring(i);
                      if (!bf.mA(paramContext)) {
                        break label10478;
                      }
                      GMTrace.o(424262238208L, 3161);
                      return false;
                      if (!paramString.startsWith("<")) {
                        break label10548;
                      }
                      localObject1 = new com.tencent.mm.storage.au();
                      ((com.tencent.mm.storage.au)localObject1).z(System.currentTimeMillis());
                      ((com.tencent.mm.storage.au)localObject1).setType(10002);
                      ((com.tencent.mm.storage.au)localObject1).setContent(paramString);
                      ((com.tencent.mm.storage.au)localObject1).dw(0);
                      ((com.tencent.mm.storage.au)localObject1).cH(paramContext);
                      ay.i((com.tencent.mm.storage.au)localObject1);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      GMTrace.o(424262238208L, 3161);
                      return false;
                      if (!paramString.startsWith("//resetcrseq")) {
                        break label10904;
                      }
                      localObject1 = paramString.split(" ");
                      try
                      {
                        l1 = bf.getLong(localObject1[1], -1L);
                        l2 = bf.getLong(localObject1[2], -1L);
                        long l3 = bf.getLong(localObject1[3], -1L);
                        i = bf.getInt(localObject1[4], -1);
                        if (l1 > 0L)
                        {
                          localObject1 = l1 + "@chatroom";
                          ap.yY();
                          localObject1 = com.tencent.mm.u.c.wW().Rl((String)localObject1);
                          if (localObject1 != null)
                          {
                            v.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] before [%d, %d, %d] [%d, %d, %d]", new Object[] { ((com.tencent.mm.storage.ae)localObject1).getUsername(), Long.valueOf(((com.tencent.mm.storage.ae)localObject1).pG()), Long.valueOf(((com.tencent.mm.storage.ae)localObject1).pE()), Integer.valueOf(((com.tencent.mm.storage.ae)localObject1).pF()), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i) });
                            if (l2 > -1L) {
                              ((com.tencent.mm.storage.ae)localObject1).v(l2);
                            }
                            if (l3 > -1L) {
                              ((com.tencent.mm.storage.ae)localObject1).u(l3);
                            }
                            if (i >= 0) {
                              ((com.tencent.mm.storage.ae)localObject1).dB(i);
                            }
                            ap.yY();
                            i = com.tencent.mm.u.c.wW().a((com.tencent.mm.storage.ae)localObject1, ((com.tencent.mm.storage.ae)localObject1).getUsername(), false);
                            v.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] done [%d, %d, %d] ret:%d", new Object[] { ((com.tencent.mm.storage.ae)localObject1).getUsername(), Long.valueOf(((com.tencent.mm.storage.ae)localObject1).pG()), Long.valueOf(((com.tencent.mm.storage.ae)localObject1).pE()), Integer.valueOf(((com.tencent.mm.storage.ae)localObject1).pF()), Integer.valueOf(i) });
                            GMTrace.o(424262238208L, 3161);
                            return true;
                          }
                        }
                      }
                      catch (Exception localException1)
                      {
                        v.printErrStackTrace("MicroMsg.CommandProcessor", localException1, "summerbadcr resetcrseq", new Object[0]);
                      }
                      if (!paramString.startsWith("//printchatroominfo")) {
                        break label11013;
                      }
                      paramContext = En_5b8fbb1e.a.vGp;
                      if (com.tencent.mm.u.o.dH(paramContext)) {
                        break label10936;
                      }
                      GMTrace.o(424262238208L, 3161);
                      return false;
                      ap.yY();
                      Object localObject2 = com.tencent.mm.u.c.xa().fV(paramContext);
                      if (localObject2 != null) {
                        break label10984;
                      }
                      v.e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", new Object[] { paramContext });
                      GMTrace.o(424262238208L, 3161);
                      return false;
                      ap.vL().D(new Runnable()
                      {
                        public final void run()
                        {
                          GMTrace.i(16875194941440L, 125730);
                          i = this.gTr.bKI();
                          j = this.gTr.field_chatroomdataflag;
                          int k = this.gTr.bKL();
                          Object localObject1 = this.gTr;
                          if (((q)localObject1).b(((q)localObject1).uxk)) {
                            ((q)localObject1).bKH();
                          }
                          int m = ((q)localObject1).uxk.status;
                          int n = this.gTr.bKM();
                          localObject1 = this.gTr;
                          if (((q)localObject1).b(((q)localObject1).uxk)) {
                            ((q)localObject1).bKH();
                          }
                          Object localObject3 = ((q)localObject1).uxk.gML;
                          localObject1 = this.gTr.DU();
                          ap.yY();
                          Object localObject2 = com.tencent.mm.u.c.wT().cN(paramContext, " and flag != 0 and msgSeq != 0");
                          boolean bool;
                          if ((localObject2 != null) && (((com.tencent.mm.e.b.ce)localObject2).field_msgId > 0L))
                          {
                            bool = true;
                            ap.yY();
                            int i1 = com.tencent.mm.u.c.wT().Av(paramContext);
                            v.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", new Object[] { paramContext, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(i1), Integer.valueOf(n), localObject3, Integer.valueOf(((List)localObject1).size()) });
                            localObject2 = new StringBuilder();
                            ((StringBuilder)localObject2).append("---chatroominfo---\nid:").append(paramContext).append("\nver:").append(i).append("\nflag:").append(j).append("\ntype:").append(k).append("\nstatus:").append(m).append("\nget:").append(bool).append("\nmsgCount:").append(i1).append("\nmaxCount:").append(n).append("\nupgrader:").append((String)localObject3).append("\nmembersize:").append(((List)localObject1).size());
                            localObject3 = paramString.split(" ");
                            i = -1;
                          }
                          try
                          {
                            j = bf.getInt(localObject3[1], 0);
                            i = j;
                          }
                          catch (Exception localException)
                          {
                            for (;;)
                            {
                              continue;
                              i = j;
                            }
                          }
                          if (i != -1) {}
                          for (;;)
                          {
                            j = i;
                            if (i > ((List)localObject1).size()) {
                              j = ((List)localObject1).size();
                            }
                            if (j <= 10) {
                              break label576;
                            }
                            i = 10;
                            if (i > 0) {
                              ((StringBuilder)localObject2).append("\nmember:");
                            }
                            j = 0;
                            while (j < i)
                            {
                              ((StringBuilder)localObject2).append("\n").append((String)((List)localObject1).get(j));
                              j += 1;
                            }
                            bool = false;
                            break;
                            i = ((List)localObject1).size();
                          }
                          localObject1 = new com.tencent.mm.storage.au();
                          ((com.tencent.mm.storage.au)localObject1).cH(paramContext);
                          ((com.tencent.mm.storage.au)localObject1).dw(2);
                          ((com.tencent.mm.storage.au)localObject1).setType(1);
                          ((com.tencent.mm.storage.au)localObject1).z(System.currentTimeMillis());
                          ((com.tencent.mm.storage.au)localObject1).setContent(((StringBuilder)localObject2).toString());
                          ay.i((com.tencent.mm.storage.au)localObject1);
                          GMTrace.o(16875194941440L, 125730);
                        }
                      });
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.equals("//testupdate")) {
                        break label11114;
                      }
                      paramString = "";
                      try
                      {
                        paramContext = bf.convertStreamToString(paramContext.getAssets().open("aplha_update_info.xml"));
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(352273, paramContext);
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(352274, Long.valueOf(System.currentTimeMillis()));
                        new com.tencent.mm.pluginsdk.model.app.a(paramContext).bCL();
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      }
                      catch (IOException paramContext)
                      {
                        for (;;)
                        {
                          v.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "", new Object[0]);
                          paramContext = paramString;
                        }
                      }
                      if ((!paramString.equals("//checkUpdate0")) && (!paramString.equals("//checkUpdate1"))) {
                        break label11164;
                      }
                      l.y.bCk().gF(paramString.equals("//checkUpdate1"));
                      l.y.szZ = true;
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.equals("//debugsnstimelinestat")) {
                        break label11234;
                      }
                      if (r.ijc) {
                        break label11228;
                      }
                      for (bool1 = true;; bool1 = false)
                      {
                        r.ijc = bool1;
                        Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), "debugSnsTimelineStat: " + r.ijc, 0).show();
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      }
                      if ((!paramString.startsWith("//abtestmsg")) || (!com.tencent.mm.sdk.a.b.bIk())) {
                        break label11296;
                      }
                      paramContext = com.tencent.mm.u.c.a.gC(paramString.replace("//abtestmsg", ""));
                      com.tencent.mm.u.c.c.Az().i(paramContext.how, 0);
                      com.tencent.mm.u.c.c.AA().i(paramContext.hox, 1);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//triggergetabtest")) {
                        break label11334;
                      }
                      ap.yY();
                      com.tencent.mm.u.c.vr().a(w.a.uzz, Long.valueOf(1L));
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//vad")) {
                        break label11599;
                      }
                      localObject2 = com.tencent.mm.sdk.platformtools.aa.bIO();
                      if (localObject2 != null) {
                        break label11365;
                      }
                      GMTrace.o(424262238208L, 3161);
                      return false;
                      if (!paramString.startsWith("//vad get")) {
                        break label11399;
                      }
                      com.tencent.mm.ui.base.g.z(paramContext, com.tencent.mm.aw.a.c.LZ(), "VAD PARAMS").show();
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      paramContext = ((SharedPreferences)localObject2).edit();
                      if (!paramString.startsWith("//vad sd")) {
                        break label11442;
                      }
                      paramContext.putInt("s_delay_time", Integer.valueOf(paramString.substring(9).trim()).intValue());
                      if (!paramString.startsWith("//vad st")) {
                        break label11477;
                      }
                      paramContext.putInt("sil_time", Integer.valueOf(paramString.substring(9).trim()).intValue());
                      if (!paramString.startsWith("//vad snr")) {
                        break label11512;
                      }
                      paramContext.putFloat("s_n_ration", Float.valueOf(paramString.substring(10).trim()).floatValue());
                      if (!paramString.startsWith("//vad sw")) {
                        break label11547;
                      }
                      paramContext.putInt("s_window", Integer.valueOf(paramString.substring(9).trim()).intValue());
                      if (!paramString.startsWith("//vad sl")) {
                        break label11582;
                      }
                      paramContext.putInt("s_length", Integer.valueOf(paramString.substring(9).trim()).intValue());
                      paramContext.apply();
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//dumpabtestrecords")) {
                        break label11770;
                      }
                      if (2 >= v.getLogLevel()) {
                        break label11627;
                      }
                      GMTrace.o(424262238208L, 3161);
                      return false;
                      if (!paramString.contains("info")) {
                        break label11760;
                      }
                      for (paramString = com.tencent.mm.u.c.c.AA().bKz();; paramString = com.tencent.mm.u.c.c.Az().bKz())
                      {
                        localObject2 = new TextView(paramContext);
                        ((TextView)localObject2).setText(paramString);
                        ((TextView)localObject2).setGravity(8388627);
                        ((TextView)localObject2).setTextSize(1, 10.0F);
                        ((TextView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                        ((TextView)localObject2).setTextColor(-16744704);
                        ((TextView)localObject2).setTypeface(Typeface.MONOSPACE);
                        ((TextView)localObject2).setMovementMethod(new ScrollingMovementMethod());
                        i = paramContext.getResources().getDimensionPixelSize(R.f.aXs);
                        ((TextView)localObject2).setPadding(i, i, i, i);
                        com.tencent.mm.ui.base.g.a(paramContext, null, (View)localObject2, null);
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      }
                      if (!paramString.startsWith("//triggerWebViewCookiesCleanup")) {
                        break label11808;
                      }
                      ap.yY();
                      com.tencent.mm.u.c.vr().a(w.a.uAG, Long.valueOf(0L));
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//cleanwebcache")) {
                        break label11845;
                      }
                      paramContext = new bj();
                      com.tencent.mm.sdk.b.a.uql.m(paramContext);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//triggerWebViewCacheCleanup")) {
                        break label11908;
                      }
                      paramString = new Intent();
                      paramString.setComponent(new ComponentName(d.g.uMO, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                      paramString.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                      paramContext.sendBroadcast(paramString);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//dumpsnsabtest")) {
                        break label11945;
                      }
                      paramContext = new cd();
                      com.tencent.mm.sdk.b.a.uql.m(paramContext);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//dumpsilkvoicefile")) {
                        break label11970;
                      }
                      r.ijg = true;
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//fucktit")) {
                        break label12008;
                      }
                      ap.yY();
                      com.tencent.mm.u.c.vr().a(w.a.uAt, Boolean.valueOf(true));
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//clog ")) {
                        break label12062;
                      }
                      paramContext = paramString.substring(7);
                      com.tencent.mm.plugin.report.service.g.oSF.dk(paramContext, "test cLog " + System.currentTimeMillis());
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if ((!paramString.startsWith("//testformsg")) || (!com.tencent.mm.sdk.a.b.bIk())) {
                        break label12167;
                      }
                      paramContext = paramString.substring(12).trim();
                      v.i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + ap.getSysCmdMsgExtension());
                      paramString = new bu();
                      paramString.tdz = com.tencent.mm.platformtools.n.mw(paramContext);
                      paramString.mrC = 10002;
                      paramContext = new d.a(paramString, false, false, false);
                      ap.getSysCmdMsgExtension().b(paramContext);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//canwebviewcachedownload")) {
                        break label12234;
                      }
                      if (bf.getInt(bf.mz(paramString.substring(25)).trim(), 1) <= 0) {
                        break label12228;
                      }
                      for (bool1 = true;; bool1 = false)
                      {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(w.a.uBd, Boolean.valueOf(bool1));
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      }
                      if (!paramString.startsWith("//canwebviewcacheprepushdownload")) {
                        break label12301;
                      }
                      if (bf.getInt(bf.mz(paramString.substring(32)).trim(), 1) <= 0) {
                        break label12295;
                      }
                      for (bool1 = true;; bool1 = false)
                      {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(w.a.uBe, Boolean.valueOf(bool1));
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      }
                      if (!paramString.startsWith("//resetsnslukcy")) {
                        break label12389;
                      }
                      ap.yY();
                      com.tencent.mm.u.c.vr().a(w.a.uBs, Boolean.valueOf(false));
                      ap.yY();
                      com.tencent.mm.u.c.vr().a(w.a.uBt, Integer.valueOf(0));
                      ap.yY();
                      com.tencent.mm.u.c.vr().a(w.a.uBu, Integer.valueOf(0));
                      paramContext = new ph();
                      com.tencent.mm.sdk.b.a.uql.m(paramContext);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//mmimgdec ")) {
                        break label12470;
                      }
                      paramString = paramString.substring(11);
                      if (!"on".equalsIgnoreCase(paramString)) {
                        break label12442;
                      }
                      MMBitmapFactory.setUseMMBitmapFactory(true);
                      Toast.makeText(paramContext, "内置图片(png)解析库开启", 0).show();
                      for (;;)
                      {
                        GMTrace.o(424262238208L, 3161);
                        return true;
                        if ("off".equalsIgnoreCase(paramString))
                        {
                          MMBitmapFactory.setUseMMBitmapFactory(false);
                          Toast.makeText(paramContext, "内置图片(png)解析库关闭", 0).show();
                        }
                      }
                      if (!paramString.startsWith("//enablempsp")) {
                        break label12506;
                      }
                      ak.a.jP(false);
                      Toast.makeText(paramContext, "设置成功，请重启微信！", 0).show();
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//disablempsp")) {
                        break label12542;
                      }
                      ak.a.jP(true);
                      Toast.makeText(paramContext, "设置成功，请重启微信！", 0).show();
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//soterpay")) {
                        break label12573;
                      }
                      com.tencent.mm.bb.d.w(paramContext, "fingerprint", ".ui.SoterPayTestUI");
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      paramContext.getString(R.l.fbI);
                      if (!paramString.startsWith("//getdltaskinfo")) {
                        break label12750;
                      }
                      paramContext = paramString.replace("//getdltaskinfo ", "");
                      for (;;)
                      {
                        try
                        {
                          paramString = com.tencent.mm.plugin.downloader.model.d.ba(bf.getLong(paramContext, 0L));
                          if (paramString == null) {
                            continue;
                          }
                          v.i("getdltaskinfo", "%d, %s, %s, %s", new Object[] { Long.valueOf(paramString.field_downloadId), paramString.field_downloadUrl, paramString.field_filePath, paramString.field_md5 });
                        }
                        catch (Exception paramString)
                        {
                          paramContext = com.tencent.mm.plugin.downloader.model.d.tD(paramContext);
                          if (paramContext == null) {
                            continue;
                          }
                          v.i("getdltaskinfo", "%d, %s, %s, %s", new Object[] { Long.valueOf(paramContext.field_downloadId), paramContext.field_downloadUrl, paramContext.field_filePath, paramContext.field_md5 });
                          continue;
                          v.i("getdltaskinfo", "infoURL null");
                          continue;
                        }
                        GMTrace.o(424262238208L, 3161);
                        return true;
                        v.i("getdltaskinfo", "infoID null");
                      }
                      if (!paramString.startsWith("//testscan ")) {
                        break label12814;
                      }
                      if (r.ijl) {
                        break label12808;
                      }
                      for (bool1 = true;; bool1 = false)
                      {
                        r.ijl = bool1;
                        r.ijn = bf.getInt(paramString.replace("//testscan", "").trim(), 0);
                        r.ijo = 0;
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      }
                      if (!paramString.startsWith("//switchrecordmode")) {
                        break label12921;
                      }
                      paramContext = com.tencent.mm.sdk.platformtools.aa.bIO();
                      bool2 = paramContext.getBoolean("settings_voicerecorder_mode", false);
                      if (bool2) {
                        break label12899;
                      }
                      bool1 = true;
                      paramContext.edit().putBoolean("settings_voicerecorder_mode", bool1).commit();
                      if (!bool2) {
                        break label12905;
                      }
                      Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), "Turn off silk record", 1).show();
                      for (;;)
                      {
                        GMTrace.o(424262238208L, 3161);
                        return true;
                        bool1 = false;
                        break;
                        Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), "Turn on silk record", 1).show();
                      }
                      if (!paramString.startsWith("//indoorsensorconfig ")) {
                        break label12958;
                      }
                      com.tencent.mm.modelstat.e.JY().kR(paramString.replace("//indoorsensorconfig ", ""));
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//testindoorsensor ")) {
                        break label13030;
                      }
                      paramContext = paramString.replace("//testindoorsensor ", "").split(",");
                      com.tencent.mm.modelstat.e.JY().a(12345, false, paramContext[0].equals("1"), bf.getFloat(paramContext[1], 0.0F), bf.getFloat(paramContext[2], 0.0F), 12);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//facedebug")) {
                        break label13051;
                      }
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//rstfacett")) {
                        break label13072;
                      }
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//switchjsc")) {
                        break label13209;
                      }
                      paramContext = paramString.replace("//switchjsc ", "");
                      paramString = com.tencent.mm.sdk.platformtools.aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                      if (!"clear".equals(paramContext)) {
                        break label13143;
                      }
                      paramString.edit().remove("switch_x5_jscore").apply();
                      for (;;)
                      {
                        GMTrace.o(424262238208L, 3161);
                        return true;
                        if ("true".equals(paramContext)) {
                          paramString.edit().putBoolean("switch_x5_jscore", true).apply();
                        } else if ("false".equals(paramContext)) {
                          paramString.edit().putBoolean("switch_x5_jscore", false).apply();
                        }
                      }
                      if (!paramString.startsWith("//rfcdn")) {
                        break label13263;
                      }
                      try
                      {
                        com.tencent.mm.modelcdntran.g.En().keep_OnRequestDoGetCdnDnsInfo(888);
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      }
                      catch (Exception paramContext)
                      {
                        for (;;)
                        {
                          v.e("MicroMsg.CommandProcessor", "rfcdn :%s", new Object[] { bf.g(paramContext) });
                        }
                      }
                      if (!paramString.startsWith("//testcrscroll ")) {
                        break label13337;
                      }
                      localObject2 = paramString.split(" ");
                      if ((localObject2 == null) || (localObject2.length <= 1)) {
                        break label13337;
                      }
                      En_5b8fbb1e.vGm = bf.getInt(localObject2[1], 0);
                      v.i("MicroMsg.CommandProcessor", "summerbadcr testscroll new BADCR_SCROLL_DELAY[%d]", new Object[] { Integer.valueOf(En_5b8fbb1e.vGm) });
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//switchx5jscore")) {
                        break label13411;
                      }
                      paramContext = com.tencent.mm.sdk.platformtools.aa.bIO();
                      bool1 = paramContext.getBoolean("switch_x5_jscore", true);
                      paramContext = paramContext.edit();
                      if (bool1) {
                        break label13405;
                      }
                      for (bool1 = true;; bool1 = false)
                      {
                        paramContext.putBoolean("switch_x5_jscore", bool1).apply();
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      }
                      if (!paramString.startsWith("//switchmusicplayer")) {
                        break label13813;
                      }
                      v.i("MicroMsg.CommandProcessor", "msg:%s", new Object[] { paramString });
                      paramContext = paramString.split(" ");
                      if (paramContext.length <= 2) {
                        break label13536;
                      }
                      if (bf.getInt(paramContext[1], 0) != 0) {
                        break label13547;
                      }
                      i = 0;
                      int k = bf.getInt(paramContext[2], -1);
                      ap.yY();
                      j = ((Integer)com.tencent.mm.u.c.vr().get(w.a.uEY, Integer.valueOf(0))).intValue();
                      if (k != -1) {
                        break label13560;
                      }
                      if (i == 0) {
                        break label13552;
                      }
                      i = 255;
                      j = 1;
                      for (;;)
                      {
                        if (j != 0)
                        {
                          ap.yY();
                          com.tencent.mm.u.c.vr().a(w.a.uEY, Integer.valueOf(i));
                        }
                        GMTrace.o(424262238208L, 3161);
                        return true;
                        i = 1;
                        break;
                        i = 0;
                        j = 1;
                        continue;
                        if (k == 0)
                        {
                          if (i != 0)
                          {
                            i = j | 0x1;
                            j = 1;
                          }
                          else
                          {
                            i = j & 0xFFFFFFFE;
                            j = 1;
                          }
                        }
                        else if (k == 1)
                        {
                          if (i != 0)
                          {
                            i = j | 0x2;
                            j = 1;
                          }
                          else
                          {
                            i = j & 0xFFFFFFFD;
                            j = 1;
                          }
                        }
                        else if (k == 4)
                        {
                          if (i != 0)
                          {
                            i = j | 0x4;
                            j = 1;
                          }
                          else
                          {
                            i = j & 0xFFFFFFFB;
                            j = 1;
                          }
                        }
                        else if (k == 6)
                        {
                          if (i != 0)
                          {
                            i = j | 0x10;
                            j = 1;
                          }
                          else
                          {
                            i = j & 0xFFFFFFEF;
                            j = 1;
                          }
                        }
                        else if (k == 7)
                        {
                          if (i != 0)
                          {
                            i = j | 0x20;
                            j = 1;
                          }
                          else
                          {
                            i = j & 0xFFFFFFDF;
                            j = 1;
                          }
                        }
                        else if (k == 8)
                        {
                          if (i != 0)
                          {
                            i = j | 0x40;
                            j = 1;
                          }
                          else
                          {
                            i = j & 0xFFFFFFBF;
                            j = 1;
                          }
                        }
                        else if (k == 9)
                        {
                          if (i != 0)
                          {
                            i = j | 0x80;
                            j = 1;
                          }
                          else
                          {
                            i = j & 0xFF7F;
                            j = 1;
                          }
                        }
                        else
                        {
                          k = 0;
                          i = j;
                          j = k;
                        }
                      }
                      if (!paramString.startsWith("//testdefaultrsa")) {
                        break label13889;
                      }
                      v.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa");
                      com.tencent.mm.protocal.ac.G("", "", 0);
                      new com.tencent.mm.modelsimple.u("", "", "", 0).Jh().a(com.tencent.mm.kernel.h.vH().vd().vh(), new com.tencent.mm.y.e()
                      {
                        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
                        {
                          GMTrace.i(16876000247808L, 125736);
                          v.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                          if ((paramAnonymousInt1 == 4) && (paramAnonymousInt2 == -102))
                          {
                            com.tencent.mm.sdk.platformtools.ae.v(new Runnable()
                            {
                              public final void run()
                              {
                                GMTrace.i(16873450110976L, 125717);
                                b.w(b.8.this.val$context, "RSA(req) fatal err, must recheck!!!");
                                GMTrace.o(16873450110976L, 125717);
                              }
                            });
                            GMTrace.o(16876000247808L, 125736);
                            return;
                          }
                          new com.tencent.mm.modelsimple.m().a(com.tencent.mm.kernel.h.vH().gXs.hsI, new com.tencent.mm.y.e()
                          {
                            public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, com.tencent.mm.y.k paramAnonymous2k)
                            {
                              GMTrace.i(16875731812352L, 125734);
                              v.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), paramAnonymous2String });
                              if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == -102))
                              {
                                com.tencent.mm.sdk.platformtools.ae.v(new Runnable()
                                {
                                  public final void run()
                                  {
                                    GMTrace.i(16874658070528L, 125726);
                                    b.w(b.8.this.val$context, "RSA(base) fatal err, must recheck!!!");
                                    GMTrace.o(16874658070528L, 125726);
                                  }
                                });
                                GMTrace.o(16875731812352L, 125734);
                                return;
                              }
                              Toast.makeText(b.8.this.val$context, "DefaultRSA check pass", 0).show();
                              b.w(b.8.this.val$context, "");
                              GMTrace.o(16875731812352L, 125734);
                            }
                          });
                          GMTrace.o(16876000247808L, 125736);
                        }
                      });
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      if (!paramString.startsWith("//dumpdefaultrsa")) {
                        break label13919;
                      }
                      bool1 = w(paramContext, "");
                      GMTrace.o(424262238208L, 3161);
                      return bool1;
                      if (!paramString.startsWith("//hardwareinfo")) {
                        break label13955;
                      }
                      ((com.tencent.mm.plugin.hardwareopt.a.a.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).eL(true);
                      GMTrace.o(424262238208L, 3161);
                      return true;
                      i = dK(paramString);
                      v.d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", new Object[] { Integer.valueOf(i) });
                      switch (i)
                      {
                      default: 
                        GMTrace.o(424262238208L, 3161);
                        return false;
                      case 0: 
                        GMTrace.o(424262238208L, 3161);
                        return false;
                      case 568: 
                        Assert.assertTrue("test errlog", false);
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 569: 
                        ap.yY().xw();
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 570: 
                        if (com.tencent.mm.storage.ba.RW(dL(paramString))) {
                          Toast.makeText(paramContext, R.l.fbo, 0).show();
                        }
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 571: 
                        paramContext = dL(paramString);
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(8195, paramContext);
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 572: 
                        com.tencent.mm.sdk.platformtools.f.fuP = Integer.valueOf(dL(paramString)).intValue();
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 574: 
                        paramString = new StringBuilder().append(com.tencent.mm.compatible.d.p.rA());
                        ap.yY();
                        com.tencent.mm.ui.base.g.z(paramContext, com.tencent.mm.a.g.n(com.tencent.mm.u.c.uH().getBytes()), "md5");
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 579: 
                        paramContext = dL(paramString);
                        ag.a.yI().J(paramContext, "");
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 580: 
                        ap.vd().d(new com.tencent.mm.u.bb(new bb.a()
                        {
                          public final void a(com.tencent.mm.network.e paramAnonymouse)
                          {
                            GMTrace.i(16875463376896L, 125732);
                            if (paramAnonymouse == null)
                            {
                              GMTrace.o(16875463376896L, 125732);
                              return;
                            }
                            paramAnonymouse = paramAnonymouse.Cc();
                            ap.yY();
                            int i = com.tencent.mm.u.c.uH();
                            paramAnonymouse.i(new byte[0], i);
                            GMTrace.o(16875463376896L, 125732);
                          }
                        }));
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 581: 
                        paramContext = dL(paramString);
                        an.aRj().Mb(paramContext);
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 582: 
                        paramContext = dL(paramString);
                        ap.yY();
                        paramContext = com.tencent.mm.u.c.wR().Rb(paramContext);
                        if ((paramContext == null) || (paramContext.tJ() == 0))
                        {
                          GMTrace.o(424262238208L, 3161);
                          return false;
                        }
                        paramContext.tc();
                        com.tencent.mm.u.o.t(paramContext);
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 583: 
                        ap.yY();
                        com.tencent.mm.u.c.xx();
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 584: 
                      case 585: 
                        com.tencent.mm.u.ba.gp(dL(paramString));
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 586: 
                        paramContext = paramString.split(" ");
                        if ((paramContext != null) && (paramContext.length == 3)) {
                          com.tencent.mm.modelmulti.t.aP(bf.getInt(paramContext[1], 0), bf.getInt(paramContext[2], 0));
                        }
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 587: 
                        paramContext = new com.tencent.mm.e.a.ce();
                        com.tencent.mm.sdk.b.a.uql.m(paramContext);
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 588: 
                        com.tencent.mm.a.e.aS("/sdcard/tencent/MicroMsg/back");
                        ap.yY();
                        com.tencent.mm.sdk.platformtools.j.p(com.tencent.mm.u.c.xu(), "/sdcard/tencent/MicroMsg/back", false);
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      case 590: 
                        GMTrace.o(424262238208L, 3161);
                        return true;
                      }
                      try
                      {
                        paramContext = paramString.split(" ");
                        if ((paramContext != null) && (paramContext.length > 1))
                        {
                          paramContext = bg.q(paramContext[0], "sysmsg");
                          ap.yY().xA().k(paramContext);
                        }
                      }
                      catch (Exception paramContext)
                      {
                        for (;;)
                        {
                          v.printErrStackTrace("MicroMsg.CommandProcessor", paramContext, "hy: error occured in commandProcessor", new Object[0]);
                        }
                      }
                      GMTrace.o(424262238208L, 3161);
                      return true;
                    }
                    catch (Exception paramContext)
                    {
                      for (;;) {}
                    }
                  }
                  catch (Exception paramContext)
                  {
                    for (;;) {}
                  }
                }
                catch (Exception paramContext)
                {
                  for (;;) {}
                }
              }
              catch (Exception paramContext)
              {
                for (;;) {}
              }
            }
            catch (Exception paramContext)
            {
              for (;;) {}
            }
          }
          catch (Exception paramContext)
          {
            for (;;) {}
          }
        }
        catch (Exception paramContext)
        {
          for (;;) {}
        }
      }
      catch (Exception paramContext)
      {
        for (;;) {}
      }
      Toast.makeText(com.tencent.mm.sdk.platformtools.aa.getContext(), "Using SVG Code : " + bool1 + " " + com.tencent.mm.svg.b.b.bNQ(), 1).show();
      GMTrace.o(424262238208L, 3161);
      return true;
    }
  }
  
  public static boolean w(Context paramContext, String paramString)
  {
    GMTrace.i(14453772910592L, 107689);
    StringBuffer localStringBuffer = new StringBuffer();
    if (!bf.mA(paramString)) {
      localStringBuffer.append(paramString + "\n\n");
    }
    localStringBuffer.append("Default RSA Info:\n");
    localStringBuffer.append("ClientVersion: " + com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION + "\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_VERSION = 157\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_KEYN = DFCA42006DB7133D885F1A96C5619061A164C450C2003DCD4DD6268A01C2EAD9A75441E7DE44C5D9FC0E17B85C07FF044F62387EE3224080F3C04C6441EC683FE7BC7D97F1115B720B240BBF62CA28004160B30951AE80C75DF5D7C67D2C2241D291550E68890914CAC9F575599570D26F58883E4685A50FAF2C6C2C85C03CE90D6DCC52AEA0960DFBC5A86344ECCD6F3D6B8C898EDA99A43FE3D5D2BA716AA67E947FB97C67F78B7B2BF349079D796E1B0B2F49143F7587A6A186D608065FDB6D238FF1F1BC34DF908D81E09AC37B5A5E9DA7AF468FBBF9BDD423B3FB884FAF3AE00F3E1C7E29FDCB6E95F44ACC12B06F30C672DF245E2FC0D5CE7347AC092B len(512" + ")\n");
    localStringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_VERSION = 158\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_KEYN = E161DA03D0B6AAD21F9A4FB27C32A3208AF25A707BB0E8ECE79506FBBAF97519D9794B7E1B44D2C6F2588495C4E040303B4C915F172DD558A49552762CB28AB309C08152A8C55A4DFC6EA80D1F4D860190A8EE251DF8DECB9B083674D56CD956FF652C3C724B9F02BE5C7CBC63FC0124AA260D889A73E91292B6A02121D25AAA7C1A87752575C181FFB25A6282725B0C38A2AD57676E0884FE20CF56256E14529BC7E82CD1F4A1155984512BD273D68F769AF46E1B0E3053816D39EB1F0588384F2F4B286E5CFAFB4D0435BDF7D3AA8D3E0C45716EAD190FDC66884B275BA08D8ED94B1F84E7729C25BD014E7FA3A23123E10D3A93B4154452DDB9EE5F8DAB67 len(512" + ")\n");
    localStringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
    v.i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + localStringBuffer.toString());
    if (!com.tencent.mm.sdk.a.b.bIk())
    {
      GMTrace.o(14453772910592L, 107689);
      return false;
    }
    paramString = new TextView(paramContext);
    paramString.setText(localStringBuffer.toString());
    paramString.setGravity(19);
    paramString.setTextSize(1, 10.0F);
    paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramString.setTextColor(-16711936);
    paramString.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(R.f.aXU);
    paramString.setPadding(i, i, i, i);
    paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
    com.tencent.mm.ui.base.g.a(paramContext, null, paramString, null);
    if (com.tencent.mm.protocal.ac.bHm()) {
      Toast.makeText(paramContext, "dump file:" + com.tencent.mm.compatible.util.e.hgk + "DefaultRSA.java", 1).show();
    }
    GMTrace.o(14453772910592L, 107689);
    return true;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/console/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */