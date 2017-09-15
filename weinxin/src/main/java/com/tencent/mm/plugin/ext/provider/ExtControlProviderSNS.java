package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.d;
import com.tencent.mm.e.a.eq;
import com.tencent.mm.e.a.eq.b;
import com.tencent.mm.e.a.er;
import com.tencent.mm.e.a.er.b;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.b.af;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.u.c;
import java.util.List;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public final class ExtControlProviderSNS
  extends ExtContentProviderBase
{
  private static final UriMatcher loR;
  private static boolean lpq;
  private static ai lpr;
  private static final String[] lpt;
  private boolean fJc;
  private boolean fJd;
  private int fJe;
  private String lpu;
  
  static
  {
    GMTrace.i(5726130929664L, 42663);
    lpt = new String[] { "feedId", "desc", "url", "nickname", "avatar", "timestamp", "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    loR = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
    lpq = false;
    lpr = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(5723312357376L, 42642);
        ExtControlProviderSNS.aqW();
        GMTrace.o(5723312357376L, 42642);
        return false;
      }
    }, false);
    GMTrace.o(5726130929664L, 42663);
  }
  
  public ExtControlProviderSNS()
  {
    GMTrace.i(5724251881472L, 42649);
    this.fJc = false;
    this.fJd = false;
    this.fJe = 0;
    this.lpu = "";
    GMTrace.o(5724251881472L, 42649);
  }
  
  private Cursor aqX()
  {
    GMTrace.i(5724922970112L, 42654);
    v.i("MicroMsg.ExtControlProviderSNS", "getSnsCursor() , needDownload = true");
    d locald = new d(lpt, (byte)0);
    Object localObject1 = new eq();
    ((eq)localObject1).fIs.fIu = this.lpu;
    if (!com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1))
    {
      locald.close();
      GMTrace.o(5724922970112L, 42654);
      return null;
    }
    Cursor localCursor = ((eq)localObject1).fIt.fIl;
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        i = localCursor.getCount();
        v.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = " + i);
        er localer;
        if ((i > 0) && (localCursor.moveToFirst()))
        {
          if (localCursor != null)
          {
            localer = new er();
            localer.fIv.fIx = localCursor;
            if (!com.tencent.mm.sdk.b.a.uql.m(localer)) {
              v.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
            }
          }
          else
          {
            if (localCursor.moveToNext()) {
              continue;
            }
          }
        }
        else
        {
          v.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + locald.getCount());
          localCursor.close();
          GMTrace.o(5724922970112L, 42654);
          return locald;
        }
        ap.yY();
        Object localObject2 = c.wR().QZ(localer.fIw.fIy);
        if ((localObject2 == null) || ((int)((com.tencent.mm.j.a)localObject2).gTG <= 0)) {
          continue;
        }
        String str3 = "";
        switch (localer.fIw.fIC)
        {
        case 2: 
          if ((localer.fIw.fIE == null) || (localer.fIw.fIE.size() <= 0) || (getContext() == null)) {
            break label842;
          }
          v.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", new Object[] { Integer.valueOf(localer.fIw.fIE.size()) });
          if ((i != 2) && (i != 6) && (i != 3) && (i != 4)) {
            break label842;
          }
          localObject1 = (String)localer.fIw.fIE.get(0);
          String str2 = str3;
          if (localer.fIw.fIF != null)
          {
            str2 = str3;
            if (localer.fIw.fIF.size() > 0)
            {
              str2 = str3;
              if (getContext() != null)
              {
                v.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[] { Integer.valueOf(localer.fIw.fIF.size()), Integer.valueOf(localer.fIw.fIG), Integer.valueOf(localer.fIw.fIH) });
                if ((i != 2) && (i != 6) && (i != 3))
                {
                  str2 = str3;
                  if (i != 4) {}
                }
                else
                {
                  str2 = (String)localer.fIw.fIF.get(0);
                }
              }
            }
          }
          str3 = com.tencent.mm.x.b.hd(localer.fIw.fIy);
          try
          {
            String str4 = com.tencent.mm.plugin.ext.a.a.bK(localer.fIw.fIz);
            String str5 = localer.fIw.fIA;
            String str6 = ((x)localObject2).tL();
            localObject2 = str3;
            if (str3 == null) {
              localObject2 = "";
            }
            locald.addRow(new Object[] { str4, str5, localObject1, str6, localObject2, Long.valueOf(localer.fIw.fIB), Integer.valueOf(localer.fIw.fID), Integer.valueOf(i), str2, Integer.valueOf(localer.fIw.fIG), Integer.valueOf(localer.fIw.fIH) });
          }
          catch (Exception localException1)
          {
            v.e("MicroMsg.ExtControlProviderSNS", localException1.getMessage());
            v.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException1, "", new Object[0]);
          }
          continue;
          i = 1;
        }
      }
      catch (Exception localException2)
      {
        v.e("MicroMsg.ExtControlProviderSNS", localException2.getMessage());
        v.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException2, "", new Object[0]);
        if (localCursor != null) {
          localCursor.close();
        }
        locald.close();
        GMTrace.o(5724922970112L, 42654);
        return null;
      }
      continue;
      int i = 2;
      continue;
      i = 3;
      continue;
      i = 6;
      continue;
      i = 4;
      continue;
      label842:
      String str1 = "";
      continue;
      i = 5;
    }
  }
  
  /* Error */
  private Cursor bL(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc2_w 365
    //   5: ldc_w 367
    //   8: invokestatic 47	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   11: ldc -119
    //   13: new 139	java/lang/StringBuilder
    //   16: dup
    //   17: ldc_w 369
    //   20: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: lload_1
    //   24: invokevirtual 372	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 153	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc -119
    //   35: ldc_w 374
    //   38: iconst_1
    //   39: anewarray 285	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: lload_1
    //   45: invokestatic 341	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: aastore
    //   49: invokestatic 376	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: lload_1
    //   53: lconst_0
    //   54: lcmp
    //   55: ifne +67 -> 122
    //   58: invokestatic 238	com/tencent/mm/u/ap:yY	()Lcom/tencent/mm/u/c;
    //   61: pop
    //   62: invokestatic 244	com/tencent/mm/u/c:wR	()Lcom/tencent/mm/storage/ar;
    //   65: invokestatic 381	com/tencent/mm/u/m:xL	()Ljava/lang/String;
    //   68: invokeinterface 259 2 0
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +12 -> 89
    //   80: aload 4
    //   82: getfield 265	com/tencent/mm/j/a:gTG	J
    //   85: l2i
    //   86: ifgt +54 -> 140
    //   89: ldc -119
    //   91: ldc_w 383
    //   94: invokestatic 354	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iconst_0
    //   98: istore_3
    //   99: iload_3
    //   100: ifne +161 -> 261
    //   103: ldc -119
    //   105: ldc_w 385
    //   108: invokestatic 225	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: ldc2_w 365
    //   114: ldc_w 367
    //   117: invokestatic 103	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   120: aconst_null
    //   121: areturn
    //   122: invokestatic 238	com/tencent/mm/u/ap:yY	()Lcom/tencent/mm/u/c;
    //   125: pop
    //   126: invokestatic 244	com/tencent/mm/u/c:wR	()Lcom/tencent/mm/storage/ar;
    //   129: lload_1
    //   130: invokeinterface 389 3 0
    //   135: astore 4
    //   137: goto -62 -> 75
    //   140: aload_0
    //   141: aload 4
    //   143: getfield 394	com/tencent/mm/e/b/af:field_type	I
    //   146: invokestatic 397	com/tencent/mm/j/a:ez	(I)Z
    //   149: putfield 110	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:fJc	Z
    //   152: aload_0
    //   153: aload 4
    //   155: getfield 400	com/tencent/mm/e/b/af:field_username	Ljava/lang/String;
    //   158: invokestatic 404	com/tencent/mm/u/m:eH	(Ljava/lang/String;)Z
    //   161: putfield 112	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:fJd	Z
    //   164: ldc -119
    //   166: ldc_w 406
    //   169: iconst_3
    //   170: anewarray 285	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload 4
    //   177: getfield 400	com/tencent/mm/e/b/af:field_username	Ljava/lang/String;
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: aload_0
    //   184: getfield 110	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:fJc	Z
    //   187: invokestatic 411	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   190: aastore
    //   191: dup
    //   192: iconst_2
    //   193: aload_0
    //   194: getfield 112	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:fJd	Z
    //   197: invokestatic 411	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   200: aastore
    //   201: invokestatic 295	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: new 413	com/tencent/mm/pluginsdk/f/a/a
    //   207: dup
    //   208: invokespecial 414	com/tencent/mm/pluginsdk/f/a/a:<init>	()V
    //   211: astore 5
    //   213: aload 5
    //   215: ldc2_w 415
    //   218: new 8	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2
    //   221: dup
    //   222: aload_0
    //   223: aload 4
    //   225: aload 5
    //   227: invokespecial 419	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2:<init>	(Lcom/tencent/mm/plugin/ext/provider/ExtControlProviderSNS;Lcom/tencent/mm/storage/x;Lcom/tencent/mm/pluginsdk/f/a/a;)V
    //   230: invokevirtual 422	com/tencent/mm/pluginsdk/f/a/a:b	(JLjava/lang/Runnable;)V
    //   233: goto -134 -> 99
    //   236: astore 4
    //   238: ldc -119
    //   240: aload 4
    //   242: invokevirtual 351	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   245: invokestatic 354	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: ldc -119
    //   250: aload 4
    //   252: ldc 116
    //   254: iconst_0
    //   255: anewarray 285	java/lang/Object
    //   258: invokestatic 358	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_0
    //   262: invokespecial 424	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:aqX	()Landroid/database/Cursor;
    //   265: astore 4
    //   267: ldc2_w 365
    //   270: ldc_w 367
    //   273: invokestatic 103	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   276: aload 4
    //   278: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	ExtControlProviderSNS
    //   0	279	1	paramLong	long
    //   1	99	3	i	int
    //   73	151	4	localx	x
    //   236	15	4	localException	Exception
    //   265	12	4	localCursor	Cursor
    //   211	15	5	locala	com.tencent.mm.pluginsdk.f.a.a
    // Exception table:
    //   from	to	target	type
    //   33	52	236	java/lang/Exception
    //   58	75	236	java/lang/Exception
    //   80	89	236	java/lang/Exception
    //   89	97	236	java/lang/Exception
    //   103	111	236	java/lang/Exception
    //   122	137	236	java/lang/Exception
    //   140	233	236	java/lang/Exception
  }
  
  private static void dM(boolean paramBoolean)
  {
    GMTrace.i(5724386099200L, 42650);
    if (paramBoolean)
    {
      lpq = true;
      lpr.v(15000L, 15000L);
      GMTrace.o(5724386099200L, 42650);
      return;
    }
    lpr.v(0L, 0L);
    GMTrace.o(5724386099200L, 42650);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(5725325623296L, 42657);
    GMTrace.o(5725325623296L, 42657);
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    GMTrace.i(5725057187840L, 42655);
    GMTrace.o(5725057187840L, 42655);
    return null;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    GMTrace.i(5725191405568L, 42656);
    GMTrace.o(5725191405568L, 42656);
    return null;
  }
  
  public final boolean onCreate()
  {
    GMTrace.i(5724520316928L, 42651);
    GMTrace.o(5724520316928L, 42651);
    return false;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    GMTrace.i(5724654534656L, 42652);
    v.i("MicroMsg.ExtControlProviderSNS", "query() " + paramUri);
    a(paramUri, getContext(), loR);
    if (paramUri == null)
    {
      lZ(3);
      GMTrace.o(5724654534656L, 42652);
      return null;
    }
    if ((bf.mA(this.loL)) || (bf.mA(aqR())))
    {
      lZ(3);
      GMTrace.o(5724654534656L, 42652);
      return null;
    }
    if (lpq)
    {
      v.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
      lZ(5);
      GMTrace.o(5724654534656L, 42652);
      return null;
    }
    dM(true);
    if (!acE())
    {
      dM(false);
      lZ(1);
      paramUri = this.jND;
      GMTrace.o(5724654534656L, 42652);
      return paramUri;
    }
    if (!bW(getContext()))
    {
      v.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
      dM(false);
      lZ(2);
      GMTrace.o(5724654534656L, 42652);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      v.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
      dM(false);
      lZ(3);
      GMTrace.o(5724654534656L, 42652);
      return null;
    }
    paramArrayOfString1 = paramArrayOfString2[0];
    if (bf.mA(paramArrayOfString1))
    {
      v.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
      dM(false);
      lZ(3);
      GMTrace.o(5724654534656L, 42652);
      return null;
    }
    for (;;)
    {
      try
      {
        boolean bool = "0".equals(paramArrayOfString1.trim());
        long l;
        if (bool) {
          l = 0L;
        }
        switch (loR.match(paramUri))
        {
        default: 
          paramUri = null;
          if (paramUri == null) {
            break label424;
          }
          lZ(0);
          dM(false);
          GMTrace.o(5724654534656L, 42652);
          return paramUri;
          l = Long.valueOf(com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString1.trim())).longValue();
          break;
        case 17: 
          paramUri = bL(l);
        }
      }
      catch (Exception paramUri)
      {
        v.e("MicroMsg.ExtControlProviderSNS", paramUri.getMessage());
        v.printErrStackTrace("MicroMsg.ExtControlProviderSNS", paramUri, "", new Object[0]);
        dM(false);
        lZ(4);
        GMTrace.o(5724654534656L, 42652);
        return null;
      }
      continue;
      label424:
      lZ(4);
    }
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(5725459841024L, 42658);
    GMTrace.o(5725459841024L, 42658);
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */