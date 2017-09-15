package com.tencent.mm.storage.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends ao
{
  public static int TYPE_TEXT;
  protected static c.a gTF;
  public static final String kJM;
  public static int uJa;
  public static int uJe;
  public static int uJf;
  public static int uJg;
  public static int uJh;
  public static int uJi;
  public static int uJj;
  public static int uJk;
  public static int uJl;
  public static int uJm;
  public static int uJn;
  public static int uJo;
  public static int uJp;
  public static int uJq;
  public static int uJr;
  public static int uJs;
  public static int uJt;
  public static int uJu;
  public static int uJv;
  public static int uJw;
  public static int uJx;
  public static int uJy;
  public final String oxR;
  
  static
  {
    GMTrace.i(1555046596608L, 11586);
    uJf = 17;
    uJg = 32;
    uJh = 49;
    uJi = 50;
    uJe = 65;
    uJj = 81;
    uJa = -1;
    uJk = 1;
    uJl = 2;
    uJm = 3;
    TYPE_TEXT = 4;
    uJn = 10;
    uJo = 11;
    uJp = 0;
    uJq = 1;
    uJr = 3;
    uJs = 4;
    uJt = 8;
    uJu = 0;
    uJv = 1;
    uJw = 0;
    uJx = 1;
    uJy = 1;
    c.a locala = new c.a();
    locala.hXn = new Field[29];
    locala.columns = new String[30];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "md5";
    locala.uvr.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.uvq = "md5";
    locala.columns[1] = "svrid";
    locala.uvr.put("svrid", "TEXT");
    localStringBuilder.append(" svrid TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "catalog";
    locala.uvr.put("catalog", "INTEGER");
    localStringBuilder.append(" catalog INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "type";
    locala.uvr.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "size";
    locala.uvr.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "start";
    locala.uvr.put("start", "INTEGER");
    localStringBuilder.append(" start INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "state";
    locala.uvr.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "name";
    locala.uvr.put("name", "TEXT");
    localStringBuilder.append(" name TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "content";
    locala.uvr.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "reserved1";
    locala.uvr.put("reserved1", "TEXT");
    localStringBuilder.append(" reserved1 TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "reserved2";
    locala.uvr.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "reserved3";
    locala.uvr.put("reserved3", "INTEGER");
    localStringBuilder.append(" reserved3 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "reserved4";
    locala.uvr.put("reserved4", "INTEGER");
    localStringBuilder.append(" reserved4 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "app_id";
    locala.uvr.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "groupId";
    locala.uvr.put("groupId", "TEXT default '' ");
    localStringBuilder.append(" groupId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "lastUseTime";
    locala.uvr.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localStringBuilder.append(", ");
    locala.columns[16] = "framesInfo";
    locala.uvr.put("framesInfo", "TEXT default '' ");
    localStringBuilder.append(" framesInfo TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "idx";
    locala.uvr.put("idx", "INTEGER default '0' ");
    localStringBuilder.append(" idx INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "temp";
    locala.uvr.put("temp", "INTEGER default '0' ");
    localStringBuilder.append(" temp INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "source";
    locala.uvr.put("source", "INTEGER default '0' ");
    localStringBuilder.append(" source INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "needupload";
    locala.uvr.put("needupload", "INTEGER default '0' ");
    localStringBuilder.append(" needupload INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "designerID";
    locala.uvr.put("designerID", "TEXT");
    localStringBuilder.append(" designerID TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "thumbUrl";
    locala.uvr.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "cdnUrl";
    locala.uvr.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "encrypturl";
    locala.uvr.put("encrypturl", "TEXT");
    localStringBuilder.append(" encrypturl TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "aeskey";
    locala.uvr.put("aeskey", "TEXT");
    localStringBuilder.append(" aeskey TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "width";
    locala.uvr.put("width", "INTEGER default '0' ");
    localStringBuilder.append(" width INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[27] = "height";
    locala.uvr.put("height", "INTEGER default '0' ");
    localStringBuilder.append(" height INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[28] = "activityid";
    locala.uvr.put("activityid", "TEXT");
    localStringBuilder.append(" activityid TEXT");
    locala.columns[29] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    kJM = File.separator;
    GMTrace.o(1555046596608L, 11586);
  }
  
  public c()
  {
    GMTrace.i(1551422717952L, 11559);
    StringBuilder localStringBuilder = new StringBuilder();
    h.vJ();
    this.oxR = (h.vI().gXV + "emoji/");
    reset();
    GMTrace.o(1551422717952L, 11559);
  }
  
  public c(String paramString)
  {
    GMTrace.i(1551556935680L, 11560);
    this.oxR = paramString;
    reset();
    GMTrace.o(1551556935680L, 11560);
  }
  
  public static InputStream bb(Context paramContext, String paramString)
  {
    GMTrace.i(1552228024320L, 11565);
    if ((paramContext == null) || (bf.mA(paramString)))
    {
      GMTrace.o(1552228024320L, 11565);
      return null;
    }
    try
    {
      paramString = paramString.split("\\.")[0];
      v.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", new Object[] { paramString });
      int i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
      paramContext = paramContext.getResources().openRawResource(i);
      GMTrace.o(1552228024320L, 11565);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      v.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", new Object[] { paramContext.getMessage() });
      GMTrace.o(1552228024320L, 11565);
    }
    return null;
  }
  
  public static boolean yD(int paramInt)
  {
    GMTrace.i(1553167548416L, 11572);
    if ((paramInt == uJi) || (paramInt == uJh))
    {
      GMTrace.o(1553167548416L, 11572);
      return true;
    }
    GMTrace.o(1553167548416L, 11572);
    return false;
  }
  
  public final String EQ()
  {
    GMTrace.i(1553435983872L, 11574);
    if (this.field_md5 == null)
    {
      GMTrace.o(1553435983872L, 11574);
      return "";
    }
    String str = this.field_md5;
    GMTrace.o(1553435983872L, 11574);
    return str;
  }
  
  public final boolean bA(Object paramObject)
  {
    GMTrace.i(1554778161152L, 11584);
    if ((paramObject != null) && ((paramObject instanceof c)) && (((c)paramObject).EQ().equalsIgnoreCase(this.field_md5)))
    {
      GMTrace.o(1554778161152L, 11584);
      return true;
    }
    GMTrace.o(1554778161152L, 11584);
    return false;
  }
  
  public final boolean bCM()
  {
    GMTrace.i(1552630677504L, 11568);
    if ((this.field_catalog == uJi) || (this.field_catalog == uJh))
    {
      GMTrace.o(1552630677504L, 11568);
      return true;
    }
    GMTrace.o(1552630677504L, 11568);
    return false;
  }
  
  public final boolean bNh()
  {
    GMTrace.i(1551959588864L, 11563);
    if ((this.field_catalog == uJf) || (this.field_catalog == uJi) || (this.field_catalog == uJh))
    {
      GMTrace.o(1551959588864L, 11563);
      return true;
    }
    if (!bf.mA(this.field_groupId)) {}
    for (File localFile = new File(this.oxR + this.field_groupId + File.separator + EQ()); (localFile.exists()) && (localFile.length() > 0L); localFile = new File(this.oxR + EQ()))
    {
      GMTrace.o(1551959588864L, 11563);
      return true;
    }
    GMTrace.o(1551959588864L, 11563);
    return false;
  }
  
  public final void bNi()
  {
    GMTrace.i(1552093806592L, 11564);
    if ((this.field_catalog == uJf) || (this.field_catalog == uJi) || (this.field_catalog == uJh))
    {
      GMTrace.o(1552093806592L, 11564);
      return;
    }
    if (!bf.mA(this.field_groupId)) {}
    for (File localFile = new File(this.oxR + this.field_groupId + File.separator + EQ());; localFile = new File(this.oxR + EQ()))
    {
      if (localFile.exists()) {
        localFile.delete();
      }
      GMTrace.o(1552093806592L, 11564);
      return;
    }
  }
  
  public final boolean bNj()
  {
    GMTrace.i(1552764895232L, 11569);
    if ((this.field_catalog == uJf) || (this.field_catalog == uJi) || (this.field_catalog == uJh))
    {
      GMTrace.o(1552764895232L, 11569);
      return true;
    }
    GMTrace.o(1552764895232L, 11569);
    return false;
  }
  
  public final boolean bNk()
  {
    GMTrace.i(1552899112960L, 11570);
    boolean bool = this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
    GMTrace.o(1552899112960L, 11570);
    return bool;
  }
  
  public final boolean bNl()
  {
    GMTrace.i(1553301766144L, 11573);
    if ((bf.mA(this.field_app_id)) && (!bf.mA(this.field_groupId)) && (!this.field_groupId.equals(String.valueOf(a.uJc))) && (!this.field_groupId.equals(String.valueOf(a.uJb))) && (!this.field_groupId.equals(String.valueOf(a.uJd))) && (!this.field_groupId.equals(String.valueOf(uJe))))
    {
      GMTrace.o(1553301766144L, 11573);
      return true;
    }
    GMTrace.o(1553301766144L, 11573);
    return false;
  }
  
  public final boolean bNm()
  {
    GMTrace.i(1553570201600L, 11575);
    if (EQ().length() == 32)
    {
      GMTrace.o(1553570201600L, 11575);
      return true;
    }
    GMTrace.o(1553570201600L, 11575);
    return false;
  }
  
  public final boolean bNn()
  {
    GMTrace.i(1554375507968L, 11581);
    if ((this.field_catalog == uJf) || (this.field_catalog == a.uJc) || (this.field_catalog == uJi) || (this.field_catalog == uJh))
    {
      GMTrace.o(1554375507968L, 11581);
      return true;
    }
    if (bNl())
    {
      String str = eN(this.field_groupId, EQ());
      localObject = str;
      if (str == null) {
        localObject = this.oxR + this.field_groupId + File.separator + EQ();
      }
    }
    for (Object localObject = new File((String)localObject); (((File)localObject).exists()) && (((File)localObject).length() > 0L); localObject = new File(this.oxR + EQ()))
    {
      GMTrace.o(1554375507968L, 11581);
      return true;
    }
    GMTrace.o(1554375507968L, 11581);
    return false;
  }
  
  /* Error */
  public final byte[] dP(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc2_w 466
    //   3: sipush 11562
    //   6: invokestatic 43	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: iload_1
    //   10: iflt +7 -> 17
    //   13: iload_2
    //   14: ifge +14 -> 28
    //   17: ldc2_w 466
    //   20: sipush 11562
    //   23: invokestatic 277	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   26: aconst_null
    //   27: areturn
    //   28: aload_0
    //   29: getfield 393	com/tencent/mm/storage/a/c:field_catalog	I
    //   32: getstatic 45	com/tencent/mm/storage/a/c:uJf	I
    //   35: if_icmpeq +23 -> 58
    //   38: aload_0
    //   39: getfield 393	com/tencent/mm/storage/a/c:field_catalog	I
    //   42: getstatic 51	com/tencent/mm/storage/a/c:uJi	I
    //   45: if_icmpeq +13 -> 58
    //   48: aload_0
    //   49: getfield 393	com/tencent/mm/storage/a/c:field_catalog	I
    //   52: getstatic 49	com/tencent/mm/storage/a/c:uJh	I
    //   55: if_icmpne +160 -> 215
    //   58: ldc_w 326
    //   61: ldc_w 469
    //   64: iconst_1
    //   65: anewarray 330	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_0
    //   71: invokevirtual 472	com/tencent/mm/storage/a/c:getName	()Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic 336	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: invokestatic 478	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   81: aload_0
    //   82: invokevirtual 472	com/tencent/mm/storage/a/c:getName	()Ljava/lang/String;
    //   85: invokestatic 480	com/tencent/mm/storage/a/c:bb	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   88: astore 6
    //   90: iload_1
    //   91: i2l
    //   92: lstore_3
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: lload_3
    //   100: invokevirtual 486	java/io/InputStream:skip	(J)J
    //   103: pop2
    //   104: aload 6
    //   106: astore 5
    //   108: iload_2
    //   109: newarray <illegal type>
    //   111: astore 7
    //   113: aload 6
    //   115: astore 5
    //   117: aload 6
    //   119: aload 7
    //   121: iconst_0
    //   122: iload_2
    //   123: invokevirtual 490	java/io/InputStream:read	([BII)I
    //   126: pop
    //   127: aload 6
    //   129: ifnull +8 -> 137
    //   132: aload 6
    //   134: invokevirtual 493	java/io/InputStream:close	()V
    //   137: ldc2_w 466
    //   140: sipush 11562
    //   143: invokestatic 277	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   146: aload 7
    //   148: areturn
    //   149: astore 5
    //   151: ldc_w 326
    //   154: ldc_w 495
    //   157: iconst_1
    //   158: anewarray 330	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload 5
    //   165: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   168: aastore
    //   169: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: goto -35 -> 137
    //   175: astore 7
    //   177: aconst_null
    //   178: astore 6
    //   180: aload 6
    //   182: astore 5
    //   184: ldc_w 326
    //   187: ldc_w 495
    //   190: iconst_1
    //   191: anewarray 330	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload 7
    //   198: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   201: aastore
    //   202: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: aload 6
    //   207: ifnull +8 -> 215
    //   210: aload 6
    //   212: invokevirtual 493	java/io/InputStream:close	()V
    //   215: new 108	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   222: aload_0
    //   223: getfield 300	com/tencent/mm/storage/a/c:oxR	Ljava/lang/String;
    //   226: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokevirtual 383	com/tencent/mm/storage/a/c:EQ	()Ljava/lang/String;
    //   233: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: astore 5
    //   241: aload_0
    //   242: invokevirtual 457	com/tencent/mm/storage/a/c:bNl	()Z
    //   245: ifeq +42 -> 287
    //   248: new 108	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   255: aload_0
    //   256: getfield 300	com/tencent/mm/storage/a/c:oxR	Ljava/lang/String;
    //   259: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_0
    //   263: getfield 399	com/tencent/mm/storage/a/c:field_groupId	Ljava/lang/String;
    //   266: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: getstatic 272	java/io/File:separator	Ljava/lang/String;
    //   272: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_0
    //   276: invokevirtual 383	com/tencent/mm/storage/a/c:EQ	()Ljava/lang/String;
    //   279: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: astore 5
    //   287: aload 5
    //   289: aload_0
    //   290: getfield 505	com/tencent/mm/storage/a/c:field_start	I
    //   293: iload_2
    //   294: invokestatic 511	com/tencent/mm/a/e:c	(Ljava/lang/String;II)[B
    //   297: astore 5
    //   299: ldc2_w 466
    //   302: sipush 11562
    //   305: invokestatic 277	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   308: aload 5
    //   310: areturn
    //   311: astore 5
    //   313: ldc_w 326
    //   316: ldc_w 495
    //   319: iconst_1
    //   320: anewarray 330	java/lang/Object
    //   323: dup
    //   324: iconst_0
    //   325: aload 5
    //   327: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   330: aastore
    //   331: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   334: goto -119 -> 215
    //   337: astore 6
    //   339: aconst_null
    //   340: astore 5
    //   342: aload 5
    //   344: ifnull +8 -> 352
    //   347: aload 5
    //   349: invokevirtual 493	java/io/InputStream:close	()V
    //   352: aload 6
    //   354: athrow
    //   355: astore 5
    //   357: ldc_w 326
    //   360: ldc_w 495
    //   363: iconst_1
    //   364: anewarray 330	java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: aload 5
    //   371: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   374: aastore
    //   375: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   378: goto -26 -> 352
    //   381: astore 6
    //   383: goto -41 -> 342
    //   386: astore 7
    //   388: goto -208 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	c
    //   0	391	1	paramInt1	int
    //   0	391	2	paramInt2	int
    //   92	8	3	l	long
    //   95	21	5	localInputStream1	InputStream
    //   149	15	5	localIOException1	java.io.IOException
    //   182	127	5	localObject1	Object
    //   311	15	5	localIOException2	java.io.IOException
    //   340	8	5	localObject2	Object
    //   355	15	5	localIOException3	java.io.IOException
    //   88	123	6	localInputStream2	InputStream
    //   337	16	6	localObject3	Object
    //   381	1	6	localObject4	Object
    //   111	36	7	arrayOfByte	byte[]
    //   175	22	7	localIOException4	java.io.IOException
    //   386	1	7	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   132	137	149	java/io/IOException
    //   58	90	175	java/io/IOException
    //   210	215	311	java/io/IOException
    //   58	90	337	finally
    //   347	352	355	java/io/IOException
    //   97	104	381	finally
    //   108	113	381	finally
    //   117	127	381	finally
    //   184	205	381	finally
    //   97	104	386	java/io/IOException
    //   108	113	386	java/io/IOException
    //   117	127	386	java/io/IOException
  }
  
  public final String eN(String paramString1, String paramString2)
  {
    String str = null;
    GMTrace.i(1554509725696L, 11582);
    if ((bf.mA(paramString1)) && (bf.mA(paramString2)))
    {
      v.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. productid and md5 are null.");
      GMTrace.o(1554509725696L, 11582);
      return null;
    }
    if (!bf.mA(paramString2)) {
      if (!bf.mA(paramString1)) {
        break label92;
      }
    }
    label92:
    for (str = this.oxR + paramString2;; str = this.oxR + paramString1 + kJM + paramString2)
    {
      GMTrace.o(1554509725696L, 11582);
      return str;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    GMTrace.i(1554643943424L, 11583);
    boolean bool = bA(paramObject);
    GMTrace.o(1554643943424L, 11583);
    return bool;
  }
  
  public final Bitmap ew(Context paramContext)
  {
    try
    {
      GMTrace.i(1552362242048L, 11566);
      paramContext = ex(paramContext);
      GMTrace.o(1552362242048L, 11566);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public final Bitmap ex(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_0
    //   16: monitorenter
    //   17: ldc2_w 532
    //   20: sipush 11567
    //   23: invokestatic 43	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   26: aload_1
    //   27: bipush 120
    //   29: invokestatic 539	com/tencent/mm/bg/a:fromDPToPix	(Landroid/content/Context;I)I
    //   32: pop
    //   33: aload_0
    //   34: getfield 393	com/tencent/mm/storage/a/c:field_catalog	I
    //   37: getstatic 45	com/tencent/mm/storage/a/c:uJf	I
    //   40: if_icmpeq +37 -> 77
    //   43: aload_0
    //   44: getfield 393	com/tencent/mm/storage/a/c:field_catalog	I
    //   47: getstatic 433	com/tencent/mm/storage/a/a:uJc	I
    //   50: if_icmpeq +27 -> 77
    //   53: aload_0
    //   54: getfield 393	com/tencent/mm/storage/a/c:field_catalog	I
    //   57: getstatic 51	com/tencent/mm/storage/a/c:uJi	I
    //   60: if_icmpeq +17 -> 77
    //   63: aload_0
    //   64: getfield 393	com/tencent/mm/storage/a/c:field_catalog	I
    //   67: istore_2
    //   68: getstatic 49	com/tencent/mm/storage/a/c:uJh	I
    //   71: istore_3
    //   72: iload_2
    //   73: iload_3
    //   74: if_icmpne +238 -> 312
    //   77: aload_0
    //   78: invokevirtual 472	com/tencent/mm/storage/a/c:getName	()Ljava/lang/String;
    //   81: astore 4
    //   83: aload_0
    //   84: getfield 542	com/tencent/mm/storage/a/c:field_type	I
    //   87: getstatic 61	com/tencent/mm/storage/a/c:uJl	I
    //   90: if_icmpne +19 -> 109
    //   93: aload_0
    //   94: invokevirtual 545	com/tencent/mm/storage/a/c:pM	()Ljava/lang/String;
    //   97: invokestatic 318	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   100: ifeq +53 -> 153
    //   103: aload_0
    //   104: invokevirtual 472	com/tencent/mm/storage/a/c:getName	()Ljava/lang/String;
    //   107: astore 4
    //   109: aload_1
    //   110: aload 4
    //   112: invokestatic 480	com/tencent/mm/storage/a/c:bb	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   115: astore 4
    //   117: aload 4
    //   119: astore_1
    //   120: aload 4
    //   122: invokestatic 551	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   125: astore 5
    //   127: aload 4
    //   129: ifnull +1129 -> 1258
    //   132: aload 4
    //   134: invokevirtual 493	java/io/InputStream:close	()V
    //   137: aload 5
    //   139: astore_1
    //   140: ldc2_w 532
    //   143: sipush 11567
    //   146: invokestatic 277	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: areturn
    //   153: aload_0
    //   154: invokevirtual 545	com/tencent/mm/storage/a/c:pM	()Ljava/lang/String;
    //   157: astore 4
    //   159: goto -50 -> 109
    //   162: astore_1
    //   163: ldc_w 326
    //   166: ldc_w 495
    //   169: iconst_1
    //   170: anewarray 330	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_1
    //   176: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   179: aastore
    //   180: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload 5
    //   185: astore_1
    //   186: goto -46 -> 140
    //   189: astore 5
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 4
    //   196: astore_1
    //   197: ldc_w 326
    //   200: ldc_w 495
    //   203: iconst_1
    //   204: anewarray 330	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload 5
    //   211: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   214: aastore
    //   215: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload 4
    //   220: ifnull +87 -> 307
    //   223: aload 4
    //   225: invokevirtual 493	java/io/InputStream:close	()V
    //   228: aconst_null
    //   229: astore_1
    //   230: goto -90 -> 140
    //   233: astore_1
    //   234: ldc_w 326
    //   237: ldc_w 495
    //   240: iconst_1
    //   241: anewarray 330	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: aload_1
    //   247: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   250: aastore
    //   251: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: aconst_null
    //   255: astore_1
    //   256: goto -116 -> 140
    //   259: astore_1
    //   260: aload 6
    //   262: astore 4
    //   264: aload 4
    //   266: ifnull +8 -> 274
    //   269: aload 4
    //   271: invokevirtual 493	java/io/InputStream:close	()V
    //   274: aload_1
    //   275: athrow
    //   276: astore_1
    //   277: aload_0
    //   278: monitorexit
    //   279: aload_1
    //   280: athrow
    //   281: astore 4
    //   283: ldc_w 326
    //   286: ldc_w 495
    //   289: iconst_1
    //   290: anewarray 330	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: aload 4
    //   297: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   300: aastore
    //   301: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: goto -30 -> 274
    //   307: aconst_null
    //   308: astore_1
    //   309: goto -169 -> 140
    //   312: aload 8
    //   314: astore 6
    //   316: aload_0
    //   317: invokevirtual 457	com/tencent/mm/storage/a/c:bNl	()Z
    //   320: ifeq +164 -> 484
    //   323: aload 8
    //   325: astore 6
    //   327: aload_0
    //   328: aload_0
    //   329: getfield 399	com/tencent/mm/storage/a/c:field_groupId	Ljava/lang/String;
    //   332: aload_0
    //   333: invokevirtual 383	com/tencent/mm/storage/a/c:EQ	()Ljava/lang/String;
    //   336: invokevirtual 461	com/tencent/mm/storage/a/c:eN	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   339: astore_1
    //   340: aload_1
    //   341: ifnonnull +914 -> 1255
    //   344: aload 8
    //   346: astore 6
    //   348: new 108	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   355: aload_0
    //   356: getfield 300	com/tencent/mm/storage/a/c:oxR	Ljava/lang/String;
    //   359: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_0
    //   363: getfield 399	com/tencent/mm/storage/a/c:field_groupId	Ljava/lang/String;
    //   366: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: getstatic 272	java/io/File:separator	Ljava/lang/String;
    //   372: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_0
    //   376: invokevirtual 383	com/tencent/mm/storage/a/c:EQ	()Ljava/lang/String;
    //   379: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: ldc_w 553
    //   385: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: astore_1
    //   392: aload 8
    //   394: astore 6
    //   396: new 269	java/io/File
    //   399: dup
    //   400: aload_1
    //   401: invokespecial 401	java/io/File:<init>	(Ljava/lang/String;)V
    //   404: astore_1
    //   405: aload 8
    //   407: astore 6
    //   409: aload_1
    //   410: invokevirtual 404	java/io/File:exists	()Z
    //   413: ifeq +213 -> 626
    //   416: aload 8
    //   418: astore 6
    //   420: new 555	java/io/FileInputStream
    //   423: dup
    //   424: aload_1
    //   425: invokespecial 558	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   428: astore_1
    //   429: aload_1
    //   430: invokestatic 551	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   433: astore 5
    //   435: aload_1
    //   436: astore 7
    //   438: aload 5
    //   440: astore_1
    //   441: aload 7
    //   443: ifnull -303 -> 140
    //   446: aload 7
    //   448: invokevirtual 559	java/io/FileInputStream:close	()V
    //   451: aload 5
    //   453: astore_1
    //   454: goto -314 -> 140
    //   457: astore_1
    //   458: ldc_w 326
    //   461: ldc_w 495
    //   464: iconst_1
    //   465: anewarray 330	java/lang/Object
    //   468: dup
    //   469: iconst_0
    //   470: aload_1
    //   471: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   474: aastore
    //   475: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   478: aload 5
    //   480: astore_1
    //   481: goto -341 -> 140
    //   484: aload 8
    //   486: astore 6
    //   488: new 269	java/io/File
    //   491: dup
    //   492: new 108	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   499: aload_0
    //   500: getfield 300	com/tencent/mm/storage/a/c:oxR	Ljava/lang/String;
    //   503: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: aload_0
    //   507: invokevirtual 383	com/tencent/mm/storage/a/c:EQ	()Ljava/lang/String;
    //   510: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: ldc_w 561
    //   516: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokespecial 401	java/io/File:<init>	(Ljava/lang/String;)V
    //   525: astore_1
    //   526: goto -121 -> 405
    //   529: astore 7
    //   531: aconst_null
    //   532: astore_1
    //   533: aload 4
    //   535: astore 5
    //   537: aload_1
    //   538: astore 4
    //   540: aload 5
    //   542: astore 6
    //   544: ldc_w 326
    //   547: ldc_w 495
    //   550: iconst_1
    //   551: anewarray 330	java/lang/Object
    //   554: dup
    //   555: iconst_0
    //   556: aload 7
    //   558: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   561: aastore
    //   562: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   565: aload 5
    //   567: astore 6
    //   569: ldc_w 326
    //   572: aload 7
    //   574: invokevirtual 562	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   577: invokestatic 564	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   580: aload 4
    //   582: astore_1
    //   583: aload 5
    //   585: ifnull -445 -> 140
    //   588: aload 5
    //   590: invokevirtual 559	java/io/FileInputStream:close	()V
    //   593: aload 4
    //   595: astore_1
    //   596: goto -456 -> 140
    //   599: astore_1
    //   600: ldc_w 326
    //   603: ldc_w 495
    //   606: iconst_1
    //   607: anewarray 330	java/lang/Object
    //   610: dup
    //   611: iconst_0
    //   612: aload_1
    //   613: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   616: aastore
    //   617: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   620: aload 4
    //   622: astore_1
    //   623: goto -483 -> 140
    //   626: aload 8
    //   628: astore 6
    //   630: aload_0
    //   631: invokevirtual 457	com/tencent/mm/storage/a/c:bNl	()Z
    //   634: ifeq +251 -> 885
    //   637: aload 8
    //   639: astore 6
    //   641: getstatic 569	android/os/Build$VERSION:SDK_INT	I
    //   644: bipush 19
    //   646: if_icmpge +600 -> 1246
    //   649: aload 8
    //   651: astore 6
    //   653: new 555	java/io/FileInputStream
    //   656: dup
    //   657: new 108	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   664: aload_0
    //   665: getfield 300	com/tencent/mm/storage/a/c:oxR	Ljava/lang/String;
    //   668: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload_0
    //   672: getfield 399	com/tencent/mm/storage/a/c:field_groupId	Ljava/lang/String;
    //   675: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: getstatic 272	java/io/File:separator	Ljava/lang/String;
    //   681: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_0
    //   685: invokevirtual 383	com/tencent/mm/storage/a/c:EQ	()Ljava/lang/String;
    //   688: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokespecial 570	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   697: astore_1
    //   698: aload_1
    //   699: invokestatic 551	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   702: astore 4
    //   704: aload_1
    //   705: astore 6
    //   707: aload_0
    //   708: invokevirtual 457	com/tencent/mm/storage/a/c:bNl	()Z
    //   711: ifeq +219 -> 930
    //   714: aload_1
    //   715: astore 6
    //   717: ldc_w 326
    //   720: ldc_w 572
    //   723: invokestatic 574	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   726: aload 4
    //   728: astore 5
    //   730: aload_1
    //   731: astore 7
    //   733: aload_1
    //   734: astore 6
    //   736: new 269	java/io/File
    //   739: dup
    //   740: new 108	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   747: aload_0
    //   748: getfield 300	com/tencent/mm/storage/a/c:oxR	Ljava/lang/String;
    //   751: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload_0
    //   755: getfield 399	com/tencent/mm/storage/a/c:field_groupId	Ljava/lang/String;
    //   758: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: getstatic 272	java/io/File:separator	Ljava/lang/String;
    //   764: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload_0
    //   768: invokevirtual 383	com/tencent/mm/storage/a/c:EQ	()Ljava/lang/String;
    //   771: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: ldc_w 576
    //   777: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: invokespecial 401	java/io/File:<init>	(Ljava/lang/String;)V
    //   786: invokevirtual 404	java/io/File:exists	()Z
    //   789: ifne -351 -> 438
    //   792: aload 4
    //   794: astore 5
    //   796: aload_1
    //   797: astore 7
    //   799: aload_1
    //   800: astore 6
    //   802: getstatic 569	android/os/Build$VERSION:SDK_INT	I
    //   805: bipush 19
    //   807: if_icmpge -369 -> 438
    //   810: aload_1
    //   811: astore 6
    //   813: aload 4
    //   815: bipush 100
    //   817: getstatic 582	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   820: new 108	java/lang/StringBuilder
    //   823: dup
    //   824: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   827: aload_0
    //   828: getfield 300	com/tencent/mm/storage/a/c:oxR	Ljava/lang/String;
    //   831: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: aload_0
    //   835: getfield 399	com/tencent/mm/storage/a/c:field_groupId	Ljava/lang/String;
    //   838: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: getstatic 272	java/io/File:separator	Ljava/lang/String;
    //   844: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload_0
    //   848: invokevirtual 383	com/tencent/mm/storage/a/c:EQ	()Ljava/lang/String;
    //   851: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: ldc_w 576
    //   857: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: iconst_0
    //   864: invokestatic 586	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   867: aload 4
    //   869: astore 5
    //   871: aload_1
    //   872: astore 7
    //   874: goto -436 -> 438
    //   877: astore 7
    //   879: aload_1
    //   880: astore 5
    //   882: goto -342 -> 540
    //   885: aload 8
    //   887: astore 6
    //   889: new 555	java/io/FileInputStream
    //   892: dup
    //   893: new 108	java/lang/StringBuilder
    //   896: dup
    //   897: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   900: aload_0
    //   901: getfield 300	com/tencent/mm/storage/a/c:oxR	Ljava/lang/String;
    //   904: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload_0
    //   908: invokevirtual 383	com/tencent/mm/storage/a/c:EQ	()Ljava/lang/String;
    //   911: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   917: invokespecial 570	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   920: astore_1
    //   921: aload_1
    //   922: invokestatic 551	com/tencent/mm/sdk/platformtools/d:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   925: astore 4
    //   927: goto -223 -> 704
    //   930: aload_1
    //   931: astore 6
    //   933: aload 4
    //   935: bipush 100
    //   937: getstatic 582	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   940: new 108	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   947: aload_0
    //   948: getfield 300	com/tencent/mm/storage/a/c:oxR	Ljava/lang/String;
    //   951: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: aload_0
    //   955: invokevirtual 383	com/tencent/mm/storage/a/c:EQ	()Ljava/lang/String;
    //   958: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: ldc_w 561
    //   964: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   970: iconst_0
    //   971: invokestatic 586	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   974: aload 4
    //   976: astore 5
    //   978: aload_1
    //   979: astore 7
    //   981: goto -543 -> 438
    //   984: astore 6
    //   986: aload_1
    //   987: astore 5
    //   989: aload 6
    //   991: astore_1
    //   992: aload 5
    //   994: astore 6
    //   996: ldc_w 326
    //   999: ldc_w 495
    //   1002: iconst_1
    //   1003: anewarray 330	java/lang/Object
    //   1006: dup
    //   1007: iconst_0
    //   1008: aload_1
    //   1009: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1012: aastore
    //   1013: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1016: aload 5
    //   1018: astore 6
    //   1020: ldc_w 326
    //   1023: aload_1
    //   1024: invokevirtual 362	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1027: invokestatic 564	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1030: aload 4
    //   1032: astore_1
    //   1033: aload 5
    //   1035: ifnull -895 -> 140
    //   1038: aload 5
    //   1040: invokevirtual 559	java/io/FileInputStream:close	()V
    //   1043: aload 4
    //   1045: astore_1
    //   1046: goto -906 -> 140
    //   1049: astore_1
    //   1050: ldc_w 326
    //   1053: ldc_w 495
    //   1056: iconst_1
    //   1057: anewarray 330	java/lang/Object
    //   1060: dup
    //   1061: iconst_0
    //   1062: aload_1
    //   1063: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1066: aastore
    //   1067: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1070: aload 4
    //   1072: astore_1
    //   1073: goto -933 -> 140
    //   1076: astore_1
    //   1077: aload 6
    //   1079: ifnull +8 -> 1087
    //   1082: aload 6
    //   1084: invokevirtual 559	java/io/FileInputStream:close	()V
    //   1087: aload_1
    //   1088: athrow
    //   1089: astore 4
    //   1091: ldc_w 326
    //   1094: ldc_w 495
    //   1097: iconst_1
    //   1098: anewarray 330	java/lang/Object
    //   1101: dup
    //   1102: iconst_0
    //   1103: aload 4
    //   1105: invokestatic 499	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1108: aastore
    //   1109: invokestatic 502	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1112: goto -25 -> 1087
    //   1115: astore 4
    //   1117: aload_1
    //   1118: astore 6
    //   1120: aload 4
    //   1122: astore_1
    //   1123: goto -46 -> 1077
    //   1126: astore 4
    //   1128: aload_1
    //   1129: astore 6
    //   1131: aload 4
    //   1133: astore_1
    //   1134: goto -57 -> 1077
    //   1137: astore 4
    //   1139: aload_1
    //   1140: astore 6
    //   1142: aload 4
    //   1144: astore_1
    //   1145: goto -68 -> 1077
    //   1148: astore_1
    //   1149: aconst_null
    //   1150: astore 4
    //   1152: goto -160 -> 992
    //   1155: astore 6
    //   1157: aconst_null
    //   1158: astore 4
    //   1160: aload_1
    //   1161: astore 5
    //   1163: aload 6
    //   1165: astore_1
    //   1166: goto -174 -> 992
    //   1169: astore 6
    //   1171: aconst_null
    //   1172: astore 4
    //   1174: aload_1
    //   1175: astore 5
    //   1177: aload 6
    //   1179: astore_1
    //   1180: goto -188 -> 992
    //   1183: astore 6
    //   1185: aconst_null
    //   1186: astore 4
    //   1188: aload_1
    //   1189: astore 5
    //   1191: aload 6
    //   1193: astore_1
    //   1194: goto -202 -> 992
    //   1197: astore 7
    //   1199: aconst_null
    //   1200: astore 4
    //   1202: aload_1
    //   1203: astore 5
    //   1205: goto -665 -> 540
    //   1208: astore 7
    //   1210: aconst_null
    //   1211: astore 4
    //   1213: aload_1
    //   1214: astore 5
    //   1216: goto -676 -> 540
    //   1219: astore 7
    //   1221: aconst_null
    //   1222: astore 4
    //   1224: aload_1
    //   1225: astore 5
    //   1227: goto -687 -> 540
    //   1230: astore 5
    //   1232: aload_1
    //   1233: astore 4
    //   1235: aload 5
    //   1237: astore_1
    //   1238: goto -974 -> 264
    //   1241: astore 5
    //   1243: goto -1049 -> 194
    //   1246: aconst_null
    //   1247: astore 4
    //   1249: aload 7
    //   1251: astore_1
    //   1252: goto -548 -> 704
    //   1255: goto -863 -> 392
    //   1258: aload 5
    //   1260: astore_1
    //   1261: goto -1121 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1264	0	this	c
    //   0	1264	1	paramContext	Context
    //   67	8	2	i	int
    //   71	4	3	j	int
    //   1	269	4	localObject1	Object
    //   281	253	4	localIOException1	java.io.IOException
    //   538	533	4	localObject2	Object
    //   1089	15	4	localIOException2	java.io.IOException
    //   1115	6	4	localObject3	Object
    //   1126	6	4	localObject4	Object
    //   1137	6	4	localObject5	Object
    //   1150	98	4	localContext1	Context
    //   7	177	5	localBitmap	Bitmap
    //   189	21	5	localException1	Exception
    //   433	793	5	localObject6	Object
    //   1230	6	5	localObject7	Object
    //   1241	18	5	localException2	Exception
    //   13	919	6	localObject8	Object
    //   984	6	6	localException3	Exception
    //   994	147	6	localObject9	Object
    //   1155	9	6	localException4	Exception
    //   1169	9	6	localException5	Exception
    //   1183	9	6	localException6	Exception
    //   4	443	7	localContext2	Context
    //   529	44	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   731	142	7	localContext3	Context
    //   877	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   979	1	7	localContext4	Context
    //   1197	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   1208	1	7	localFileNotFoundException4	java.io.FileNotFoundException
    //   1219	31	7	localFileNotFoundException5	java.io.FileNotFoundException
    //   10	876	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   132	137	162	java/io/IOException
    //   77	83	189	java/lang/Exception
    //   83	109	189	java/lang/Exception
    //   109	117	189	java/lang/Exception
    //   153	159	189	java/lang/Exception
    //   223	228	233	java/io/IOException
    //   77	83	259	finally
    //   83	109	259	finally
    //   109	117	259	finally
    //   153	159	259	finally
    //   17	72	276	finally
    //   132	137	276	finally
    //   140	149	276	finally
    //   163	183	276	finally
    //   223	228	276	finally
    //   234	254	276	finally
    //   269	274	276	finally
    //   274	276	276	finally
    //   283	304	276	finally
    //   446	451	276	finally
    //   458	478	276	finally
    //   588	593	276	finally
    //   600	620	276	finally
    //   1038	1043	276	finally
    //   1050	1070	276	finally
    //   1082	1087	276	finally
    //   1087	1089	276	finally
    //   1091	1112	276	finally
    //   269	274	281	java/io/IOException
    //   446	451	457	java/io/IOException
    //   316	323	529	java/io/FileNotFoundException
    //   327	340	529	java/io/FileNotFoundException
    //   348	392	529	java/io/FileNotFoundException
    //   396	405	529	java/io/FileNotFoundException
    //   409	416	529	java/io/FileNotFoundException
    //   420	429	529	java/io/FileNotFoundException
    //   488	526	529	java/io/FileNotFoundException
    //   630	637	529	java/io/FileNotFoundException
    //   641	649	529	java/io/FileNotFoundException
    //   653	698	529	java/io/FileNotFoundException
    //   889	921	529	java/io/FileNotFoundException
    //   588	593	599	java/io/IOException
    //   707	714	877	java/io/FileNotFoundException
    //   717	726	877	java/io/FileNotFoundException
    //   736	792	877	java/io/FileNotFoundException
    //   802	810	877	java/io/FileNotFoundException
    //   813	867	877	java/io/FileNotFoundException
    //   933	974	877	java/io/FileNotFoundException
    //   707	714	984	java/lang/Exception
    //   717	726	984	java/lang/Exception
    //   736	792	984	java/lang/Exception
    //   802	810	984	java/lang/Exception
    //   813	867	984	java/lang/Exception
    //   933	974	984	java/lang/Exception
    //   1038	1043	1049	java/io/IOException
    //   316	323	1076	finally
    //   327	340	1076	finally
    //   348	392	1076	finally
    //   396	405	1076	finally
    //   409	416	1076	finally
    //   420	429	1076	finally
    //   488	526	1076	finally
    //   544	565	1076	finally
    //   569	580	1076	finally
    //   630	637	1076	finally
    //   641	649	1076	finally
    //   653	698	1076	finally
    //   707	714	1076	finally
    //   717	726	1076	finally
    //   736	792	1076	finally
    //   802	810	1076	finally
    //   813	867	1076	finally
    //   889	921	1076	finally
    //   933	974	1076	finally
    //   996	1016	1076	finally
    //   1020	1030	1076	finally
    //   1082	1087	1089	java/io/IOException
    //   429	435	1115	finally
    //   698	704	1126	finally
    //   921	927	1137	finally
    //   316	323	1148	java/lang/Exception
    //   327	340	1148	java/lang/Exception
    //   348	392	1148	java/lang/Exception
    //   396	405	1148	java/lang/Exception
    //   409	416	1148	java/lang/Exception
    //   420	429	1148	java/lang/Exception
    //   488	526	1148	java/lang/Exception
    //   630	637	1148	java/lang/Exception
    //   641	649	1148	java/lang/Exception
    //   653	698	1148	java/lang/Exception
    //   889	921	1148	java/lang/Exception
    //   429	435	1155	java/lang/Exception
    //   698	704	1169	java/lang/Exception
    //   921	927	1183	java/lang/Exception
    //   429	435	1197	java/io/FileNotFoundException
    //   698	704	1208	java/io/FileNotFoundException
    //   921	927	1219	java/io/FileNotFoundException
    //   120	127	1230	finally
    //   197	218	1230	finally
    //   120	127	1241	java/lang/Exception
  }
  
  public final String getName()
  {
    GMTrace.i(1553838637056L, 11577);
    if (this.field_name == null)
    {
      GMTrace.o(1553838637056L, 11577);
      return "";
    }
    String str = this.field_name;
    GMTrace.o(1553838637056L, 11577);
    return str;
  }
  
  public final void iZ(String paramString)
  {
    GMTrace.i(18616669962240L, 138705);
    this.field_md5 = paramString;
    GMTrace.o(18616669962240L, 138705);
  }
  
  public final boolean isGif()
  {
    GMTrace.i(1553033330688L, 11571);
    if ((this.field_type == uJl) || (this.field_type == uJn))
    {
      GMTrace.o(1553033330688L, 11571);
      return true;
    }
    GMTrace.o(1553033330688L, 11571);
    return false;
  }
  
  public final String pM()
  {
    GMTrace.i(1553972854784L, 11578);
    if (this.field_content == null)
    {
      GMTrace.o(1553972854784L, 11578);
      return "";
    }
    String str = this.field_content;
    GMTrace.o(1553972854784L, 11578);
    return str;
  }
  
  public final void reset()
  {
    GMTrace.i(1551691153408L, 11561);
    this.field_md5 = "";
    this.field_svrid = "";
    this.field_catalog = uJf;
    this.field_type = uJk;
    this.field_size = 0;
    this.field_start = 0;
    this.field_state = uJp;
    this.field_name = "";
    this.field_content = "";
    this.field_reserved1 = "";
    this.field_reserved2 = "";
    this.field_reserved3 = 0;
    this.field_reserved4 = 0;
    this.field_app_id = "";
    this.field_temp = 0;
    GMTrace.o(1551691153408L, 11561);
  }
  
  protected final c.a sY()
  {
    GMTrace.i(1554241290240L, 11580);
    c.a locala = gTF;
    GMTrace.o(1554241290240L, 11580);
    return locala;
  }
  
  public final void setSize(int paramInt)
  {
    GMTrace.i(18617072615424L, 138708);
    this.field_size = paramInt;
    GMTrace.o(18617072615424L, 138708);
  }
  
  public final void setType(int paramInt)
  {
    GMTrace.i(18616938397696L, 138707);
    this.field_type = paramInt;
    GMTrace.o(18616938397696L, 138707);
  }
  
  public final String toString()
  {
    GMTrace.i(1554912378880L, 11585);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("field_md5:").append(this.field_md5).append("\n");
    ((StringBuilder)localObject).append("field_svrid:").append(this.field_svrid).append("\n");
    ((StringBuilder)localObject).append("field_catalog:").append(this.field_catalog).append("\n");
    ((StringBuilder)localObject).append("field_type:").append(this.field_type).append("\n");
    ((StringBuilder)localObject).append("field_size:").append(this.field_size).append("\n");
    ((StringBuilder)localObject).append("field_start:").append(this.field_start).append("\n");
    ((StringBuilder)localObject).append("field_state:").append(this.field_state).append("\n");
    ((StringBuilder)localObject).append("field_name:").append(this.field_name).append("\n");
    ((StringBuilder)localObject).append("field_content:").append(this.field_content).append("\n");
    ((StringBuilder)localObject).append("field_reserved1:").append(this.field_reserved1).append("\n");
    ((StringBuilder)localObject).append("field_reserved2:").append(this.field_reserved2).append("\n");
    ((StringBuilder)localObject).append("field_reserved3:").append(this.field_reserved3).append("\n");
    ((StringBuilder)localObject).append("field_reserved4:").append(this.field_reserved4).append("\n");
    ((StringBuilder)localObject).append("field_app_id:").append(this.field_app_id).append("\n");
    ((StringBuilder)localObject).append("field_groupId:").append(this.field_groupId).append("\n");
    ((StringBuilder)localObject).append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
    ((StringBuilder)localObject).append("field_framesInfo:").append(this.field_framesInfo).append("\n");
    ((StringBuilder)localObject).append("field_idx:").append(this.field_idx).append("\n");
    ((StringBuilder)localObject).append("field_temp:").append(this.field_temp).append("\n");
    ((StringBuilder)localObject).append("field_source:").append(this.field_source).append("\n");
    ((StringBuilder)localObject).append("field_needupload:").append(this.field_needupload).append("\n");
    ((StringBuilder)localObject).append("field_designerID:").append(this.field_designerID).append("\n");
    ((StringBuilder)localObject).append("field_thumbUrl:").append(this.field_thumbUrl).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    GMTrace.o(1554912378880L, 11585);
    return (String)localObject;
  }
  
  public final void yE(int paramInt)
  {
    GMTrace.i(18616804179968L, 138706);
    this.field_catalog = paramInt;
    GMTrace.o(18616804179968L, 138706);
  }
  
  public final void yF(int paramInt)
  {
    GMTrace.i(18617206833152L, 138709);
    this.field_temp = 1;
    GMTrace.o(18617206833152L, 138709);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */