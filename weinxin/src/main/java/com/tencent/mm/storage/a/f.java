package com.tencent.mm.storage.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.emoji.d;
import com.tencent.mm.protocal.c.ou;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class f
  extends i<c>
  implements f.a
{
  public static final String[] gUn;
  private static int[] uJA;
  public com.tencent.mm.sdk.e.e gUp;
  
  static
  {
    GMTrace.i(1545785573376L, 11517);
    gUn = new String[] { i.a(c.gTF, "EmojiInfo"), "CREATE INDEX IF NOT EXISTS emojiinfogrouptempindex  on EmojiInfo  (  groupId,temp )" };
    uJA = new int[] { 2, 4, 8 };
    GMTrace.o(1545785573376L, 11517);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, c.gTF, "EmojiInfo", null);
    GMTrace.i(1540685299712L, 11479);
    this.gUp = parame;
    GMTrace.o(1540685299712L, 11479);
  }
  
  private c a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, int paramInt4)
  {
    GMTrace.i(1541759041536L, 11487);
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      v.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
      GMTrace.o(1541759041536L, 11487);
      return null;
    }
    if ((paramString1 == null) || (paramString1.length() <= 0))
    {
      v.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
      paramString1 = null;
    }
    for (;;)
    {
      paramString1.field_state = c.uJr;
      if (!s(paramString1)) {
        break;
      }
      Qq("create_emoji_info_notify");
      GMTrace.o(1541759041536L, 11487);
      return paramString1;
      c localc = Sh(paramString1);
      paramString3 = localc;
      if (localc == null)
      {
        d.akN();
        paramString3 = new c(d.akO());
        paramString3.field_catalog = paramInt1;
      }
      paramString3.field_md5 = paramString1;
      paramString3.field_svrid = paramString2;
      paramString3.field_type = paramInt2;
      paramString3.field_size = paramInt3;
      paramString3.field_state = c.uJp;
      paramString3.field_reserved1 = null;
      paramString3.field_reserved2 = null;
      paramString3.field_app_id = paramString4;
      paramString3.field_temp = 1;
      paramString3.field_reserved4 = 0;
      paramString1 = paramString3;
      if (!TextUtils.isEmpty(paramString5))
      {
        paramString3.field_groupId = paramString5;
        paramString1 = paramString3;
      }
    }
    GMTrace.o(1541759041536L, 11487);
    return null;
  }
  
  private static List<c> a(InputStream[] paramArrayOfInputStream)
  {
    GMTrace.i(1543638089728L, 11501);
    ArrayList localArrayList = new ArrayList();
    Object localObject = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int k;
      try
      {
        DocumentBuilder localDocumentBuilder = ((DocumentBuilderFactory)localObject).newDocumentBuilder();
        int i = 0;
        if (i <= 0)
        {
          localObject = paramArrayOfInputStream[i];
          if (localObject != null)
          {
            NodeList localNodeList1 = localDocumentBuilder.parse((InputStream)localObject).getDocumentElement().getElementsByTagName("catalog");
            int j = 0;
            if (j < localNodeList1.getLength())
            {
              localObject = (Element)localNodeList1.item(j);
              int m = Integer.decode(((Element)localObject).getAttribute("id")).intValue();
              NodeList localNodeList2 = ((Element)localObject).getElementsByTagName("emoji");
              k = 0;
              if (k < localNodeList2.getLength())
              {
                d.akN();
                c localc = new c(d.akO());
                localObject = (Element)localNodeList2.item(k);
                localc.field_md5 = ((Element)localObject).getAttribute("md5");
                if (!localc.bNm()) {
                  break label374;
                }
                localc.field_catalog = m;
                localc.field_groupId = String.valueOf(m);
                localc.field_name = ((Element)localObject).getAttribute("name");
                localc.field_type = Integer.decode(((Element)localObject).getAttribute("type")).intValue();
                localObject = ((Element)localObject).getFirstChild();
                if ((localObject instanceof CharacterData))
                {
                  localObject = ((CharacterData)localObject).getData();
                  if (localc.field_type != c.TYPE_TEXT) {
                    break label371;
                  }
                  localObject = new String(Base64.decode((String)localObject, 0));
                  localc.field_content = ((String)localObject);
                  localArrayList.add(localc);
                  break label374;
                }
                localObject = "";
                continue;
              }
              j += 1;
              continue;
            }
          }
          i += 1;
        }
        continue;
      }
      catch (Exception paramArrayOfInputStream)
      {
        v.e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + paramArrayOfInputStream.getMessage());
        GMTrace.o(1543638089728L, 11501);
        return localArrayList;
      }
      label371:
      label374:
      k += 1;
    }
  }
  
  private int yG(int paramInt)
  {
    j = 0;
    i = 0;
    GMTrace.i(1542430130176L, 11492);
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.gUp.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[] { String.valueOf(paramInt), "0" }, 2);
      paramInt = i;
      if (localCursor != null)
      {
        paramInt = i;
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          paramInt = localCursor.getInt(0);
        }
      }
      i = paramInt;
      if (localCursor != null)
      {
        localCursor.close();
        i = paramInt;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bf.g(localException) });
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + localException.getMessage());
        i = j;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          i = j;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label211;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1542430130176L, 11492);
    return i;
  }
  
  private boolean yI(int paramInt)
  {
    GMTrace.i(1543369654272L, 11499);
    if (this.gUp.delete("EmojiInfo", "catalog=?", new String[] { String.valueOf(paramInt) }) >= 0)
    {
      GMTrace.o(1543369654272L, 11499);
      return true;
    }
    GMTrace.o(1543369654272L, 11499);
    return false;
  }
  
  public final int Sd(String paramString)
  {
    GMTrace.i(1542564347904L, 11493);
    long l = System.currentTimeMillis();
    Object localObject = null;
    String str = null;
    for (;;)
    {
      try
      {
        paramString = this.gUp.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[] { paramString, "0" }, 2);
        if (paramString == null) {
          break label220;
        }
        str = paramString;
        localObject = paramString;
        if (!paramString.moveToFirst()) {
          break label220;
        }
        str = paramString;
        localObject = paramString;
        i = paramString.getInt(0);
        j = i;
        if (paramString != null)
        {
          paramString.close();
          j = i;
        }
      }
      catch (Exception paramString)
      {
        localObject = str;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bf.g(paramString) });
        localObject = str;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + paramString.getMessage());
        if (str == null) {
          break label215;
        }
        str.close();
        j = 0;
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        ((Cursor)localObject).close();
      }
      v.d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      GMTrace.o(1542564347904L, 11493);
      return j;
      label215:
      int j = 0;
      continue;
      label220:
      int i = 0;
    }
  }
  
  /* Error */
  public final c Sh(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 352
    //   3: sipush 11491
    //   6: invokestatic 23	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_1
    //   10: invokestatic 357	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   13: ifne +12 -> 25
    //   16: aload_1
    //   17: invokevirtual 63	java/lang/String:length	()I
    //   20: bipush 32
    //   22: if_icmpeq +30 -> 52
    //   25: ldc 65
    //   27: ldc_w 359
    //   30: iconst_1
    //   31: anewarray 310	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: aastore
    //   38: invokestatic 361	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: ldc2_w 352
    //   44: sipush 11491
    //   47: invokestatic 46	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   50: aconst_null
    //   51: areturn
    //   52: aload_0
    //   53: getfield 56	com/tencent/mm/storage/a/f:gUp	Lcom/tencent/mm/sdk/e/e;
    //   56: ldc 33
    //   58: aconst_null
    //   59: ldc_w 363
    //   62: iconst_1
    //   63: anewarray 25	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: aload_1
    //   69: aastore
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: iconst_2
    //   74: invokeinterface 366 9 0
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +147 -> 228
    //   84: aload_1
    //   85: invokeinterface 300 1 0
    //   90: ifeq +138 -> 228
    //   93: invokestatic 100	com/tencent/mm/plugin/emoji/d:akN	()Lcom/tencent/mm/plugin/emoji/d;
    //   96: pop
    //   97: new 27	com/tencent/mm/storage/a/c
    //   100: dup
    //   101: invokestatic 104	com/tencent/mm/plugin/emoji/d:akO	()Ljava/lang/String;
    //   104: invokespecial 106	com/tencent/mm/storage/a/c:<init>	(Ljava/lang/String;)V
    //   107: astore_3
    //   108: aload_3
    //   109: aload_1
    //   110: invokevirtual 370	com/tencent/mm/storage/a/c:b	(Landroid/database/Cursor;)V
    //   113: aload_3
    //   114: astore_2
    //   115: aload_2
    //   116: astore_3
    //   117: aload_1
    //   118: ifnull +11 -> 129
    //   121: aload_1
    //   122: invokeinterface 306 1 0
    //   127: aload_2
    //   128: astore_3
    //   129: ldc2_w 352
    //   132: sipush 11491
    //   135: invokestatic 46	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   138: aload_3
    //   139: areturn
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_1
    //   145: ldc 65
    //   147: ldc_w 372
    //   150: iconst_1
    //   151: anewarray 310	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_3
    //   157: invokevirtual 373	java/lang/Exception:toString	()Ljava/lang/String;
    //   160: aastore
    //   161: invokestatic 319	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload_1
    //   165: astore_3
    //   166: aload_2
    //   167: ifnull -38 -> 129
    //   170: aload_2
    //   171: invokeinterface 306 1 0
    //   176: aload_1
    //   177: astore_3
    //   178: goto -49 -> 129
    //   181: astore_2
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_1
    //   185: ifnull +9 -> 194
    //   188: aload_1
    //   189: invokeinterface 306 1 0
    //   194: aload_2
    //   195: athrow
    //   196: astore_2
    //   197: goto -13 -> 184
    //   200: astore_3
    //   201: aload_2
    //   202: astore_1
    //   203: aload_3
    //   204: astore_2
    //   205: goto -21 -> 184
    //   208: astore_3
    //   209: aload_1
    //   210: astore_2
    //   211: aconst_null
    //   212: astore_1
    //   213: goto -68 -> 145
    //   216: astore 4
    //   218: aload_1
    //   219: astore_2
    //   220: aload_3
    //   221: astore_1
    //   222: aload 4
    //   224: astore_3
    //   225: goto -80 -> 145
    //   228: aconst_null
    //   229: astore_2
    //   230: goto -115 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	f
    //   0	233	1	paramString	String
    //   114	57	2	localObject1	Object
    //   181	14	2	localObject2	Object
    //   196	6	2	localObject3	Object
    //   204	26	2	localObject4	Object
    //   107	32	3	localObject5	Object
    //   140	17	3	localException1	Exception
    //   165	13	3	str	String
    //   200	4	3	localObject6	Object
    //   208	13	3	localException2	Exception
    //   224	1	3	localObject7	Object
    //   216	7	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   52	80	140	java/lang/Exception
    //   52	80	181	finally
    //   84	108	196	finally
    //   108	113	196	finally
    //   145	164	200	finally
    //   84	108	208	java/lang/Exception
    //   108	113	216	java/lang/Exception
  }
  
  /* Error */
  public final c Si(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc2_w 375
    //   7: sipush 11502
    //   10: invokestatic 23	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   13: aload_0
    //   14: getfield 56	com/tencent/mm/storage/a/f:gUp	Lcom/tencent/mm/sdk/e/e;
    //   17: ldc_w 378
    //   20: iconst_2
    //   21: anewarray 25	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: aload_1
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc_w 290
    //   33: aastore
    //   34: iconst_2
    //   35: invokeinterface 295 4 0
    //   40: astore_1
    //   41: aload_1
    //   42: invokeinterface 300 1 0
    //   47: ifeq +140 -> 187
    //   50: invokestatic 100	com/tencent/mm/plugin/emoji/d:akN	()Lcom/tencent/mm/plugin/emoji/d;
    //   53: pop
    //   54: new 27	com/tencent/mm/storage/a/c
    //   57: dup
    //   58: invokestatic 104	com/tencent/mm/plugin/emoji/d:akO	()Ljava/lang/String;
    //   61: invokespecial 106	com/tencent/mm/storage/a/c:<init>	(Ljava/lang/String;)V
    //   64: astore_3
    //   65: aload_3
    //   66: aload_1
    //   67: invokevirtual 370	com/tencent/mm/storage/a/c:b	(Landroid/database/Cursor;)V
    //   70: aload_3
    //   71: astore_2
    //   72: aload_2
    //   73: astore_3
    //   74: aload_1
    //   75: ifnull +11 -> 86
    //   78: aload_1
    //   79: invokeinterface 306 1 0
    //   84: aload_2
    //   85: astore_3
    //   86: ldc2_w 375
    //   89: sipush 11502
    //   92: invokestatic 46	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   95: aload_3
    //   96: areturn
    //   97: astore 4
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_2
    //   102: astore_3
    //   103: ldc 65
    //   105: new 264	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 380
    //   112: invokespecial 267	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload 4
    //   117: invokevirtual 270	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 280	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_1
    //   130: astore_3
    //   131: aload_2
    //   132: ifnull -46 -> 86
    //   135: aload_2
    //   136: invokeinterface 306 1 0
    //   141: aload_1
    //   142: astore_3
    //   143: goto -57 -> 86
    //   146: astore_1
    //   147: aload_3
    //   148: ifnull +9 -> 157
    //   151: aload_3
    //   152: invokeinterface 306 1 0
    //   157: aload_1
    //   158: athrow
    //   159: astore_2
    //   160: aload_1
    //   161: astore_3
    //   162: aload_2
    //   163: astore_1
    //   164: goto -17 -> 147
    //   167: astore 4
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_1
    //   172: astore_2
    //   173: aload_3
    //   174: astore_1
    //   175: goto -74 -> 101
    //   178: astore 4
    //   180: aload_1
    //   181: astore_2
    //   182: aload_3
    //   183: astore_1
    //   184: goto -83 -> 101
    //   187: aconst_null
    //   188: astore_2
    //   189: goto -117 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	f
    //   0	192	1	paramString	String
    //   3	133	2	localObject1	Object
    //   159	4	2	localObject2	Object
    //   172	17	2	str	String
    //   1	182	3	localObject3	Object
    //   97	19	4	localException1	Exception
    //   167	1	4	localException2	Exception
    //   178	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   13	41	97	java/lang/Exception
    //   13	41	146	finally
    //   103	129	146	finally
    //   41	65	159	finally
    //   65	70	159	finally
    //   41	65	167	java/lang/Exception
    //   65	70	178	java/lang/Exception
  }
  
  public final boolean Sj(String paramString)
  {
    GMTrace.i(1544443396096L, 11507);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = "groupId = '" + paramString + "'";
      try
      {
        if (this.gUp.delete("EmojiInfo", paramString, null) >= 0)
        {
          GMTrace.o(1544443396096L, 11507);
          return true;
        }
        GMTrace.o(1544443396096L, 11507);
        return false;
      }
      catch (Exception paramString)
      {
        v.i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + paramString.getMessage());
      }
    }
    GMTrace.o(1544443396096L, 11507);
    return false;
  }
  
  public final int a(com.tencent.mm.bj.f paramf)
  {
    GMTrace.i(1540953735168L, 11481);
    if (paramf != null) {
      this.gUp = paramf;
    }
    GMTrace.o(1540953735168L, 11481);
    return 0;
  }
  
  public final c a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    GMTrace.i(1541624823808L, 11486);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, null, paramString3, paramString4, 1);
    GMTrace.o(1541624823808L, 11486);
    return paramString1;
  }
  
  public final void a(Context paramContext, c paramc)
  {
    GMTrace.i(1543503872000L, 11500);
    Object localObject;
    Context localContext;
    if ((paramc.field_catalog == c.uJf) || (paramc.field_catalog == c.uJi) || (paramc.field_catalog == c.uJh))
    {
      localObject = null;
      localContext = null;
    }
    for (;;)
    {
      try
      {
        paramContext = c.bb(paramContext, paramc.getName());
        if (paramContext == null) {
          break label279;
        }
        localContext = paramContext;
        localObject = paramContext;
        j = paramContext.available();
        i = j;
      }
      catch (IOException paramContext)
      {
        localObject = localContext;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bf.g(paramContext) });
        if (localContext == null) {
          break label274;
        }
        try
        {
          localContext.close();
          i = 0;
        }
        catch (IOException paramContext)
        {
          v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bf.g(paramContext) });
          i = 0;
        }
        continue;
      }
      finally
      {
        if (localObject == null) {
          break label218;
        }
      }
      try
      {
        paramContext.close();
        i = j;
      }
      catch (IOException paramContext)
      {
        v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bf.g(paramContext) });
        i = j;
        continue;
      }
      if ((i != 0) && (i != paramc.field_size))
      {
        paramc.field_size = i;
        t(paramc);
      }
      GMTrace.o(1543503872000L, 11500);
      return;
      try
      {
        ((InputStream)localObject).close();
        label218:
        throw paramContext;
      }
      catch (IOException paramc)
      {
        for (;;)
        {
          v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bf.g(paramc) });
        }
      }
      int i = com.tencent.mm.a.e.aN(paramc.oxR + paramc.EQ());
      continue;
      label274:
      i = 0;
      continue;
      label279:
      int j = 0;
    }
  }
  
  public final boolean ax(LinkedList<String> paramLinkedList)
  {
    GMTrace.i(1544846049280L, 11510);
    if ((paramLinkedList == null) || (paramLinkedList.size() <= 0))
    {
      v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
      GMTrace.o(1544846049280L, 11510);
      return false;
    }
    v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPDATE");
    localStringBuilder.append(" EmojiInfo ");
    localStringBuilder.append(" SET ");
    localStringBuilder.append("needupload");
    localStringBuilder.append("=");
    localStringBuilder.append(c.uJx);
    localStringBuilder.append(" where ");
    localStringBuilder.append("md5");
    localStringBuilder.append(" IN (");
    int i = 0;
    while (i < paramLinkedList.size())
    {
      localStringBuilder.append("'" + (String)paramLinkedList.get(i) + "'");
      if (i < paramLinkedList.size() - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    v.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
    boolean bool = this.gUp.eE("EmojiInfo", localStringBuilder.toString());
    GMTrace.o(1544846049280L, 11510);
    return bool;
  }
  
  public final c b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    GMTrace.i(1541356388352L, 11484);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, null, null, paramString3, 1);
    GMTrace.o(1541356388352L, 11484);
    return paramString1;
  }
  
  public final List<c> bNo()
  {
    GMTrace.i(1542832783360L, 11495);
    ArrayList localArrayList = new ArrayList();
    int i = a.uJc;
    int j = a.uJd;
    int k = c.uJs;
    Cursor localCursor = this.gUp.a("select  * from EmojiInfo where catalog=?  or catalog=? and state!=? order by reserved3 asc", new String[] { String.valueOf(i), String.valueOf(j), String.valueOf(k) }, 2);
    if (localCursor.moveToFirst()) {
      do
      {
        d.akN();
        c localc = new c(d.akO());
        localc.b(localCursor);
        localArrayList.add(localc);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    GMTrace.o(1542832783360L, 11495);
    return localArrayList;
  }
  
  public final List<String> bNp()
  {
    GMTrace.i(1542967001088L, 11496);
    ArrayList localArrayList = new ArrayList();
    localObject3 = null;
    localObject1 = null;
    Object localObject4 = a.uJd;
    try
    {
      localObject4 = this.gUp.a("select md5 from EmojiInfo where catalog=?  order by reserved3 asc", new String[] { localObject4 }, 2);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(((Cursor)localObject4).getString(0));
            localObject1 = localObject4;
            localObject3 = localObject4;
            bool = ((Cursor)localObject4).moveToNext();
          } while (bool);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", new Object[] { bf.g(localException) });
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label197;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1542967001088L, 11496);
    return localArrayList;
  }
  
  public final List<String> bNq()
  {
    GMTrace.i(1543101218816L, 11497);
    ArrayList localArrayList = new ArrayList();
    localObject3 = null;
    localObject1 = null;
    Object localObject4 = a.uJd;
    String str = c.uJv;
    try
    {
      localObject4 = this.gUp.a("select md5 from EmojiInfo where catalog=? and source=?", new String[] { localObject4, str }, 2);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(((Cursor)localObject4).getString(0));
            localObject1 = localObject4;
            localObject3 = localObject4;
            bool = ((Cursor)localObject4).moveToNext();
          } while (bool);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", new Object[] { bf.g(localException) });
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label220;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1543101218816L, 11497);
    return localArrayList;
  }
  
  public final List<String> bNr()
  {
    GMTrace.i(1544577613824L, 11508);
    ArrayList localArrayList = new ArrayList();
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.gUp.a("select md5 from EmojiInfo where catalog=? or temp=?", new String[] { "85", "2" }, 2);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localCursor;
            localObject3 = localCursor;
            localArrayList.add(localCursor.getString(0));
            localObject1 = localCursor;
            localObject3 = localCursor;
            bool = localCursor.moveToNext();
          } while (bool);
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", new Object[] { bf.g(localException) });
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label186;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1544577613824L, 11508);
    return localArrayList;
  }
  
  public final int bNs()
  {
    k = 0;
    j = 0;
    GMTrace.i(1544711831552L, 11509);
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.gUp.rawQuery("select md5 from EmojiInfo where catalog=? or temp=?", new String[] { "85", "2" });
      int i = j;
      if (localCursor != null)
      {
        i = j;
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          i = localCursor.getCount();
        }
      }
      j = i;
      if (localCursor != null)
      {
        localCursor.close();
        j = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", new Object[] { bf.g(localException) });
        j = k;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          j = k;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label178;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1544711831552L, 11509);
    return j;
  }
  
  public final ArrayList<String> bNt()
  {
    GMTrace.i(1544980267008L, 11511);
    ArrayList localArrayList = new ArrayList();
    localObject3 = null;
    localObject1 = null;
    int i = c.uJx;
    int j = a.uJd;
    try
    {
      Cursor localCursor = this.gUp.a("select md5 from EmojiInfo where needupload=? and catalog=?", new String[] { String.valueOf(i), String.valueOf(j) }, 2);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          boolean bool;
          do
          {
            localObject1 = localCursor;
            localObject3 = localCursor;
            localArrayList.add(localCursor.getString(0));
            localObject1 = localCursor;
            localObject3 = localCursor;
            bool = localCursor.moveToNext();
          } while (bool);
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "get need upload emoji MD5 list failed :%s", new Object[] { bf.g(localException) });
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label209;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1544980267008L, 11511);
    return localArrayList;
  }
  
  public final int bNu()
  {
    k = 0;
    j = 0;
    GMTrace.i(1545114484736L, 11512);
    localObject3 = null;
    localObject1 = null;
    int i = a.uJd;
    try
    {
      Cursor localCursor = this.gUp.a("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[] { String.valueOf(i) }, 2);
      i = j;
      if (localCursor != null)
      {
        i = j;
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          i = localCursor.getInt(0);
        }
      }
      j = i;
      if (localCursor != null)
      {
        localCursor.close();
        j = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", new Object[] { bf.g(localException) });
        j = k;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          j = k;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label179;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1545114484736L, 11512);
    return j;
  }
  
  public final ArrayList<c> bNv()
  {
    GMTrace.i(1545248702464L, 11513);
    localObject3 = null;
    localObject1 = null;
    int i = a.uJd;
    int j = a.uJe;
    try
    {
      Cursor localCursor = this.gUp.a("SELECT * FROM EmojiInfo WHERE catalog =?  OR catalog=? OR groupId IS NOT NULL", new String[] { String.valueOf(i), String.valueOf(j) }, 2);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          ArrayList localArrayList = new ArrayList();
          boolean bool;
          do
          {
            localObject1 = localCursor;
            localObject3 = localCursor;
            c localc = new c();
            localObject1 = localCursor;
            localObject3 = localCursor;
            localc.b(localCursor);
            localObject1 = localCursor;
            localObject3 = localCursor;
            if ((localc.field_reserved4 & c.uJy) != c.uJy)
            {
              localObject1 = localCursor;
              localObject3 = localCursor;
              localArrayList.add(localc);
            }
            localObject1 = localCursor;
            localObject3 = localCursor;
            bool = localCursor.moveToNext();
          } while (bool);
          if (localCursor != null) {
            localCursor.close();
          }
          GMTrace.o(1545248702464L, 11513);
          return localArrayList;
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", new Object[] { bf.g(localException) });
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label289;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1545248702464L, 11513);
    return null;
  }
  
  public final c c(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    GMTrace.i(1541490606080L, 11485);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, null, null, paramString3, 1);
    GMTrace.o(1541490606080L, 11485);
    return paramString1;
  }
  
  public final boolean co(List<String> paramList)
  {
    GMTrace.i(1544040742912L, 11504);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      GMTrace.o(1544040742912L, 11504);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UPDATE");
    localStringBuilder.append(" EmojiInfo ");
    localStringBuilder.append(" SET ");
    localStringBuilder.append("catalog");
    localStringBuilder.append("=");
    localStringBuilder.append(c.uJe);
    localStringBuilder.append(",");
    localStringBuilder.append("source");
    localStringBuilder.append("=");
    localStringBuilder.append(c.uJu);
    localStringBuilder.append(",");
    localStringBuilder.append("needupload");
    localStringBuilder.append("=");
    localStringBuilder.append(c.uJw);
    localStringBuilder.append(" where ");
    localStringBuilder.append("md5");
    localStringBuilder.append(" IN (");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append("'" + (String)paramList.get(i) + "'");
      if (i < paramList.size() - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    v.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
    if (this.gUp.eE("EmojiInfo", localStringBuilder.toString())) {
      Qq("delete_emoji_info_notify");
    }
    GMTrace.o(1544040742912L, 11504);
    return true;
  }
  
  public final boolean cp(List<String> paramList)
  {
    GMTrace.i(1544174960640L, 11505);
    v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
    long l2 = System.currentTimeMillis();
    if ((paramList == null) || (paramList.size() <= 0))
    {
      v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
      GMTrace.o(1544174960640L, 11505);
      return false;
    }
    Object localObject1 = bNp();
    g localg;
    if ((this.gUp instanceof g)) {
      localg = (g)this.gUp;
    }
    for (long l1 = localg.cs(Thread.currentThread().getId());; l1 = -1L)
    {
      Object localObject2 = paramList.iterator();
      int j;
      for (int i = 1; ((Iterator)localObject2).hasNext(); i = j)
      {
        Object localObject3 = (String)((Iterator)localObject2).next();
        c localc = Sh((String)localObject3);
        j = i;
        if (localc != null)
        {
          j = i;
          if (!bf.mA(localc.EQ()))
          {
            localc.field_reserved3 = i;
            if (!((List)localObject1).isEmpty()) {
              ((List)localObject1).remove(localObject3);
            }
            j = i + 1;
            localObject3 = localc.pv();
            if (this.gUp.replace("EmojiInfo", "md5", (ContentValues)localObject3) < 0L)
            {
              if (localg != null) {
                localg.aD(l1);
              }
              v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
              GMTrace.o(1544174960640L, 11505);
              return false;
            }
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = Sh((String)((Iterator)localObject1).next());
          if ((localObject2 != null) && (!bf.mA(((c)localObject2).EQ())))
          {
            ((c)localObject2).field_reserved3 = i;
            i += 1;
            localObject2 = ((c)localObject2).pv();
            if (this.gUp.replace("EmojiInfo", "md5", (ContentValues)localObject2) < 0L)
            {
              if (localg != null) {
                localg.aD(l1);
              }
              v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
              GMTrace.o(1544174960640L, 11505);
              return false;
            }
          }
        }
      }
      if (localg != null) {
        localg.aD(l1);
      }
      l1 = System.currentTimeMillis();
      if (paramList == null) {}
      for (i = 0;; i = paramList.size())
      {
        v.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d", new Object[] { Long.valueOf(l1 - l2), Integer.valueOf(i) });
        GMTrace.o(1544174960640L, 11505);
        return true;
      }
      localg = null;
    }
  }
  
  public final boolean cq(List<ou> paramList)
  {
    int i = 0;
    GMTrace.i(1545517137920L, 11515);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      v.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
      GMTrace.o(1545517137920L, 11515);
      return false;
    }
    v.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", new Object[] { Integer.valueOf(paramList.size()) });
    g localg;
    long l;
    if ((this.gUp instanceof g))
    {
      localg = (g)this.gUp;
      l = localg.cs(Thread.currentThread().getId());
      v.i("MicroMsg.emoji.EmojiInfoStorage", "surround updateEmojiURL in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      if (i < paramList.size())
      {
        ou localou = (ou)paramList.get(i);
        c localc2 = Sh(localou.tsH);
        c localc1 = localc2;
        if (localc2 == null)
        {
          localc1 = new c();
          localc1.field_md5 = localou.tsH;
          localc1.field_catalog = c.uJe;
          v.i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
        }
        localc1.field_cdnUrl = localou.mrm;
        localc1.field_encrypturl = localou.tsJ;
        localc1.field_aeskey = localou.tsK;
        localc1.field_designerID = localou.tsI;
        localc1.field_thumbUrl = localou.ofO;
        localc1.field_groupId = localou.tfq;
        t(localc1);
        i += 1;
      }
      else
      {
        if (localg != null)
        {
          localg.aD(l);
          v.i("MicroMsg.emoji.EmojiInfoStorage", "end updateList transaction");
        }
        GMTrace.o(1545517137920L, 11515);
        return true;
        localg = null;
        l = -1L;
      }
    }
  }
  
  /* Error */
  public final boolean eu(Context paramContext)
  {
    // Byte code:
    //   0: ldc2_w 730
    //   3: sipush 11482
    //   6: invokestatic 23	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: ldc 65
    //   11: ldc_w 733
    //   14: invokestatic 391	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: ldc_w 735
    //   21: invokevirtual 94	com/tencent/mm/storage/a/f:Sh	(Ljava/lang/String;)Lcom/tencent/mm/storage/a/c;
    //   24: astore 7
    //   26: aload_0
    //   27: ldc_w 737
    //   30: invokevirtual 94	com/tencent/mm/storage/a/f:Sh	(Ljava/lang/String;)Lcom/tencent/mm/storage/a/c;
    //   33: astore 8
    //   35: aload_0
    //   36: getstatic 740	com/tencent/mm/storage/a/c:uJg	I
    //   39: invokespecial 742	com/tencent/mm/storage/a/f:yG	(I)I
    //   42: istore_2
    //   43: ldc 65
    //   45: ldc_w 744
    //   48: iconst_1
    //   49: anewarray 310	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: iload_2
    //   55: invokestatic 457	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: aastore
    //   59: invokestatic 361	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: aload 7
    //   64: ifnonnull +24 -> 88
    //   67: aload 8
    //   69: ifnull +14 -> 83
    //   72: aload 8
    //   74: invokevirtual 747	com/tencent/mm/storage/a/c:pM	()Ljava/lang/String;
    //   77: invokevirtual 63	java/lang/String:length	()I
    //   80: ifeq +8 -> 88
    //   83: iload_2
    //   84: iconst_2
    //   85: if_icmpgt +35 -> 120
    //   88: ldc 65
    //   90: ldc_w 749
    //   93: invokestatic 391	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: getstatic 407	com/tencent/mm/storage/a/c:uJf	I
    //   100: invokespecial 751	com/tencent/mm/storage/a/f:yI	(I)Z
    //   103: pop
    //   104: aload_0
    //   105: getstatic 410	com/tencent/mm/storage/a/c:uJi	I
    //   108: invokespecial 751	com/tencent/mm/storage/a/f:yI	(I)Z
    //   111: pop
    //   112: aload_0
    //   113: getstatic 413	com/tencent/mm/storage/a/c:uJh	I
    //   116: invokespecial 751	com/tencent/mm/storage/a/f:yI	(I)Z
    //   119: pop
    //   120: aload_0
    //   121: ldc_w 753
    //   124: invokevirtual 94	com/tencent/mm/storage/a/f:Sh	(Ljava/lang/String;)Lcom/tencent/mm/storage/a/c;
    //   127: astore 7
    //   129: aload 7
    //   131: ifnull +46 -> 177
    //   134: aload 7
    //   136: getfield 109	com/tencent/mm/storage/a/c:field_catalog	I
    //   139: getstatic 407	com/tencent/mm/storage/a/c:uJf	I
    //   142: if_icmpne +35 -> 177
    //   145: ldc 65
    //   147: ldc_w 755
    //   150: invokestatic 391	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_0
    //   154: getstatic 407	com/tencent/mm/storage/a/c:uJf	I
    //   157: invokespecial 751	com/tencent/mm/storage/a/f:yI	(I)Z
    //   160: pop
    //   161: aload_0
    //   162: getstatic 410	com/tencent/mm/storage/a/c:uJi	I
    //   165: invokespecial 751	com/tencent/mm/storage/a/f:yI	(I)Z
    //   168: pop
    //   169: aload_0
    //   170: getstatic 413	com/tencent/mm/storage/a/c:uJh	I
    //   173: invokespecial 751	com/tencent/mm/storage/a/f:yI	(I)Z
    //   176: pop
    //   177: aload_1
    //   178: ldc_w 757
    //   181: invokestatic 420	com/tencent/mm/storage/a/c:bb	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   184: astore 7
    //   186: aload 7
    //   188: ifnull +35 -> 223
    //   191: ldc 65
    //   193: ldc_w 759
    //   196: invokestatic 391	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_0
    //   200: getstatic 407	com/tencent/mm/storage/a/c:uJf	I
    //   203: invokespecial 751	com/tencent/mm/storage/a/f:yI	(I)Z
    //   206: pop
    //   207: aload_0
    //   208: getstatic 410	com/tencent/mm/storage/a/c:uJi	I
    //   211: invokespecial 751	com/tencent/mm/storage/a/f:yI	(I)Z
    //   214: pop
    //   215: aload_0
    //   216: getstatic 413	com/tencent/mm/storage/a/c:uJh	I
    //   219: invokespecial 751	com/tencent/mm/storage/a/f:yI	(I)Z
    //   222: pop
    //   223: aload 7
    //   225: ifnull +8 -> 233
    //   228: aload 7
    //   230: invokevirtual 426	java/io/InputStream:close	()V
    //   233: aload_0
    //   234: getstatic 407	com/tencent/mm/storage/a/c:uJf	I
    //   237: invokespecial 742	com/tencent/mm/storage/a/f:yG	(I)I
    //   240: ifeq +14 -> 254
    //   243: ldc2_w 730
    //   246: sipush 11482
    //   249: invokestatic 46	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   252: iconst_1
    //   253: ireturn
    //   254: aconst_null
    //   255: astore 10
    //   257: aconst_null
    //   258: astore 9
    //   260: aload 9
    //   262: astore 8
    //   264: aload 10
    //   266: astore 7
    //   268: ldc 65
    //   270: ldc_w 761
    //   273: invokestatic 391	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload 9
    //   278: astore 8
    //   280: aload 10
    //   282: astore 7
    //   284: invokestatic 341	java/lang/System:currentTimeMillis	()J
    //   287: lstore_3
    //   288: aload 9
    //   290: astore 8
    //   292: aload 10
    //   294: astore 7
    //   296: aload_1
    //   297: invokevirtual 767	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   300: ldc_w 769
    //   303: invokevirtual 775	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   306: astore_1
    //   307: aload_1
    //   308: astore 8
    //   310: aload_1
    //   311: astore 7
    //   313: iconst_1
    //   314: anewarray 422	java/io/InputStream
    //   317: dup
    //   318: iconst_0
    //   319: aload_1
    //   320: aastore
    //   321: invokestatic 777	com/tencent/mm/storage/a/f:a	([Ljava/io/InputStream;)Ljava/util/List;
    //   324: astore 10
    //   326: aload_1
    //   327: astore 8
    //   329: aload_1
    //   330: astore 7
    //   332: ldc 65
    //   334: ldc_w 779
    //   337: iconst_1
    //   338: anewarray 310	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: invokestatic 341	java/lang/System:currentTimeMillis	()J
    //   346: lload_3
    //   347: lsub
    //   348: invokestatic 348	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   351: aastore
    //   352: invokestatic 361	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   355: aload_1
    //   356: astore 8
    //   358: aload_1
    //   359: astore 7
    //   361: invokestatic 341	java/lang/System:currentTimeMillis	()J
    //   364: lstore 5
    //   366: aload_1
    //   367: astore 8
    //   369: aload_1
    //   370: astore 7
    //   372: aload 10
    //   374: invokeinterface 599 1 0
    //   379: ifle +168 -> 547
    //   382: aload_1
    //   383: astore 8
    //   385: aload_1
    //   386: astore 7
    //   388: aload 10
    //   390: invokeinterface 599 1 0
    //   395: ifle +152 -> 547
    //   398: ldc2_w 674
    //   401: lstore_3
    //   402: aload_1
    //   403: astore 8
    //   405: aload_1
    //   406: astore 7
    //   408: aload_0
    //   409: getfield 56	com/tencent/mm/storage/a/f:gUp	Lcom/tencent/mm/sdk/e/e;
    //   412: instanceof 623
    //   415: ifeq +348 -> 763
    //   418: aload_1
    //   419: astore 8
    //   421: aload_1
    //   422: astore 7
    //   424: aload_0
    //   425: getfield 56	com/tencent/mm/storage/a/f:gUp	Lcom/tencent/mm/sdk/e/e;
    //   428: checkcast 623	com/tencent/mm/bj/g
    //   431: astore 9
    //   433: aload_1
    //   434: astore 8
    //   436: aload_1
    //   437: astore 7
    //   439: aload 9
    //   441: invokestatic 629	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   444: invokevirtual 632	java/lang/Thread:getId	()J
    //   447: invokevirtual 636	com/tencent/mm/bj/g:cs	(J)J
    //   450: lstore_3
    //   451: aload_1
    //   452: astore 8
    //   454: aload_1
    //   455: astore 7
    //   457: aload 10
    //   459: invokeinterface 640 1 0
    //   464: astore 10
    //   466: aload_1
    //   467: astore 8
    //   469: aload_1
    //   470: astore 7
    //   472: aload 10
    //   474: invokeinterface 645 1 0
    //   479: ifeq +131 -> 610
    //   482: aload_1
    //   483: astore 8
    //   485: aload_1
    //   486: astore 7
    //   488: aload 10
    //   490: invokeinterface 649 1 0
    //   495: checkcast 27	com/tencent/mm/storage/a/c
    //   498: invokevirtual 661	com/tencent/mm/storage/a/c:pv	()Landroid/content/ContentValues;
    //   501: astore 11
    //   503: aload_1
    //   504: astore 8
    //   506: aload_1
    //   507: astore 7
    //   509: aload_0
    //   510: getfield 56	com/tencent/mm/storage/a/f:gUp	Lcom/tencent/mm/sdk/e/e;
    //   513: ldc 33
    //   515: ldc -40
    //   517: aload 11
    //   519: invokeinterface 665 4 0
    //   524: lconst_0
    //   525: lcmp
    //   526: ifge -60 -> 466
    //   529: aload 9
    //   531: ifnull +16 -> 547
    //   534: aload_1
    //   535: astore 8
    //   537: aload_1
    //   538: astore 7
    //   540: aload 9
    //   542: lload_3
    //   543: invokevirtual 669	com/tencent/mm/bj/g:aD	(J)I
    //   546: pop
    //   547: aload_1
    //   548: astore 8
    //   550: aload_1
    //   551: astore 7
    //   553: ldc 65
    //   555: ldc_w 781
    //   558: iconst_1
    //   559: anewarray 310	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: invokestatic 341	java/lang/System:currentTimeMillis	()J
    //   567: lload 5
    //   569: lsub
    //   570: invokestatic 348	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   573: aastore
    //   574: invokestatic 361	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   577: aload_1
    //   578: astore 8
    //   580: aload_1
    //   581: astore 7
    //   583: ldc 65
    //   585: ldc_w 783
    //   588: invokestatic 487	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   591: aload_1
    //   592: ifnull +7 -> 599
    //   595: aload_1
    //   596: invokevirtual 426	java/io/InputStream:close	()V
    //   599: ldc2_w 730
    //   602: sipush 11482
    //   605: invokestatic 46	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   608: iconst_1
    //   609: ireturn
    //   610: aload 9
    //   612: ifnull -65 -> 547
    //   615: aload_1
    //   616: astore 8
    //   618: aload_1
    //   619: astore 7
    //   621: aload 9
    //   623: lload_3
    //   624: invokevirtual 669	com/tencent/mm/bj/g:aD	(J)I
    //   627: pop
    //   628: goto -81 -> 547
    //   631: astore_1
    //   632: aload 8
    //   634: astore 7
    //   636: ldc 65
    //   638: new 264	java/lang/StringBuilder
    //   641: dup
    //   642: ldc_w 785
    //   645: invokespecial 267	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   648: aload_1
    //   649: invokevirtual 786	java/io/IOException:getMessage	()Ljava/lang/String;
    //   652: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 280	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   661: aload 8
    //   663: ifnull -64 -> 599
    //   666: aload 8
    //   668: invokevirtual 426	java/io/InputStream:close	()V
    //   671: goto -72 -> 599
    //   674: astore_1
    //   675: ldc 65
    //   677: ldc_w 308
    //   680: iconst_1
    //   681: anewarray 310	java/lang/Object
    //   684: dup
    //   685: iconst_0
    //   686: aload_1
    //   687: invokestatic 316	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   690: aastore
    //   691: invokestatic 319	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   694: goto -95 -> 599
    //   697: astore_1
    //   698: ldc 65
    //   700: ldc_w 308
    //   703: iconst_1
    //   704: anewarray 310	java/lang/Object
    //   707: dup
    //   708: iconst_0
    //   709: aload_1
    //   710: invokestatic 316	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   713: aastore
    //   714: invokestatic 319	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   717: goto -118 -> 599
    //   720: astore_1
    //   721: aload 7
    //   723: ifnull +8 -> 731
    //   726: aload 7
    //   728: invokevirtual 426	java/io/InputStream:close	()V
    //   731: aload_1
    //   732: athrow
    //   733: astore 7
    //   735: ldc 65
    //   737: ldc_w 308
    //   740: iconst_1
    //   741: anewarray 310	java/lang/Object
    //   744: dup
    //   745: iconst_0
    //   746: aload 7
    //   748: invokestatic 316	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   751: aastore
    //   752: invokestatic 319	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   755: goto -24 -> 731
    //   758: astore 7
    //   760: goto -527 -> 233
    //   763: aconst_null
    //   764: astore 9
    //   766: goto -315 -> 451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	769	0	this	f
    //   0	769	1	paramContext	Context
    //   42	44	2	i	int
    //   287	337	3	l1	long
    //   364	204	5	l2	long
    //   24	703	7	localObject1	Object
    //   733	14	7	localException1	Exception
    //   758	1	7	localException2	Exception
    //   33	634	8	localObject2	Object
    //   258	507	9	localg	g
    //   255	234	10	localObject3	Object
    //   501	17	11	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   268	276	631	java/io/IOException
    //   284	288	631	java/io/IOException
    //   296	307	631	java/io/IOException
    //   313	326	631	java/io/IOException
    //   332	355	631	java/io/IOException
    //   361	366	631	java/io/IOException
    //   372	382	631	java/io/IOException
    //   388	398	631	java/io/IOException
    //   408	418	631	java/io/IOException
    //   424	433	631	java/io/IOException
    //   439	451	631	java/io/IOException
    //   457	466	631	java/io/IOException
    //   472	482	631	java/io/IOException
    //   488	503	631	java/io/IOException
    //   509	529	631	java/io/IOException
    //   540	547	631	java/io/IOException
    //   553	577	631	java/io/IOException
    //   583	591	631	java/io/IOException
    //   621	628	631	java/io/IOException
    //   666	671	674	java/lang/Exception
    //   595	599	697	java/lang/Exception
    //   268	276	720	finally
    //   284	288	720	finally
    //   296	307	720	finally
    //   313	326	720	finally
    //   332	355	720	finally
    //   361	366	720	finally
    //   372	382	720	finally
    //   388	398	720	finally
    //   408	418	720	finally
    //   424	433	720	finally
    //   439	451	720	finally
    //   457	466	720	finally
    //   472	482	720	finally
    //   488	503	720	finally
    //   509	529	720	finally
    //   540	547	720	finally
    //   553	577	720	finally
    //   583	591	720	finally
    //   621	628	720	finally
    //   636	661	720	finally
    //   726	731	733	java/lang/Exception
    //   228	233	758	java/lang/Exception
  }
  
  /* Error */
  public final String getKey()
  {
    // Byte code:
    //   0: ldc2_w 788
    //   3: sipush 11514
    //   6: invokestatic 23	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: getfield 56	com/tencent/mm/storage/a/f:gUp	Lcom/tencent/mm/sdk/e/e;
    //   13: ldc_w 791
    //   16: iconst_1
    //   17: anewarray 25	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc_w 793
    //   25: aastore
    //   26: iconst_2
    //   27: invokeinterface 295 4 0
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +72 -> 106
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokeinterface 300 1 0
    //   45: ifeq +61 -> 106
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: iconst_0
    //   52: invokeinterface 527 2 0
    //   57: astore_3
    //   58: aload_2
    //   59: astore_1
    //   60: ldc 65
    //   62: new 264	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 795
    //   69: invokespecial 267	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload_3
    //   73: invokestatic 798	com/tencent/mm/sdk/platformtools/bf:Qi	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 391	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_2
    //   86: ifnull +9 -> 95
    //   89: aload_2
    //   90: invokeinterface 306 1 0
    //   95: ldc2_w 788
    //   98: sipush 11514
    //   101: invokestatic 46	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   104: aload_3
    //   105: areturn
    //   106: aload_2
    //   107: ifnull +9 -> 116
    //   110: aload_2
    //   111: invokeinterface 306 1 0
    //   116: invokestatic 804	com/tencent/mm/sdk/platformtools/aa:getContext	()Landroid/content/Context;
    //   119: invokestatic 808	com/tencent/mm/sdk/platformtools/bf:em	(Landroid/content/Context;)Ljava/lang/String;
    //   122: astore_1
    //   123: aload_1
    //   124: invokestatic 357	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   127: ifne +127 -> 254
    //   130: aload_1
    //   131: invokevirtual 812	java/lang/String:getBytes	()[B
    //   134: invokestatic 818	com/tencent/mm/a/g:n	([B)Ljava/lang/String;
    //   137: astore_1
    //   138: ldc 65
    //   140: new 264	java/lang/StringBuilder
    //   143: dup
    //   144: ldc_w 820
    //   147: invokespecial 267	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload_1
    //   151: invokestatic 798	com/tencent/mm/sdk/platformtools/bf:Qi	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 391	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: new 27	com/tencent/mm/storage/a/c
    //   166: dup
    //   167: invokespecial 585	com/tencent/mm/storage/a/c:<init>	()V
    //   170: astore_2
    //   171: aload_2
    //   172: aload_1
    //   173: putfield 113	com/tencent/mm/storage/a/c:field_md5	Ljava/lang/String;
    //   176: aload_2
    //   177: sipush 153
    //   180: putfield 109	com/tencent/mm/storage/a/c:field_catalog	I
    //   183: aload_0
    //   184: aload_2
    //   185: invokevirtual 84	com/tencent/mm/storage/a/f:s	(Lcom/tencent/mm/storage/a/c;)Z
    //   188: ifeq +79 -> 267
    //   191: ldc2_w 788
    //   194: sipush 11514
    //   197: invokestatic 46	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   200: aload_1
    //   201: areturn
    //   202: astore_3
    //   203: aconst_null
    //   204: astore_2
    //   205: aload_2
    //   206: astore_1
    //   207: ldc 65
    //   209: ldc_w 822
    //   212: iconst_1
    //   213: anewarray 310	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: aload_3
    //   219: invokestatic 316	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   222: aastore
    //   223: invokestatic 319	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: aload_2
    //   227: ifnull -111 -> 116
    //   230: aload_2
    //   231: invokeinterface 306 1 0
    //   236: goto -120 -> 116
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_1
    //   242: aload_1
    //   243: ifnull +9 -> 252
    //   246: aload_1
    //   247: invokeinterface 306 1 0
    //   252: aload_2
    //   253: athrow
    //   254: ldc_w 824
    //   257: invokevirtual 812	java/lang/String:getBytes	()[B
    //   260: invokestatic 818	com/tencent/mm/a/g:n	([B)Ljava/lang/String;
    //   263: astore_1
    //   264: goto -126 -> 138
    //   267: ldc2_w 788
    //   270: sipush 11514
    //   273: invokestatic 46	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   276: aconst_null
    //   277: areturn
    //   278: astore_2
    //   279: goto -37 -> 242
    //   282: astore_3
    //   283: goto -78 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	f
    //   38	226	1	localObject1	Object
    //   32	199	2	localObject2	Object
    //   239	14	2	localObject3	Object
    //   278	1	2	localObject4	Object
    //   57	48	3	str	String
    //   202	17	3	localException1	Exception
    //   282	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	33	202	java/lang/Exception
    //   9	33	239	finally
    //   39	48	278	finally
    //   50	58	278	finally
    //   60	85	278	finally
    //   207	226	278	finally
    //   39	48	282	java/lang/Exception
    //   50	58	282	java/lang/Exception
    //   60	85	282	java/lang/Exception
  }
  
  public final String getTableName()
  {
    GMTrace.i(1540819517440L, 11480);
    GMTrace.o(1540819517440L, 11480);
    return "EmojiInfo";
  }
  
  public final boolean j(List<c> paramList, String paramString)
  {
    GMTrace.i(1544309178368L, 11506);
    if (paramList.size() <= 0)
    {
      v.i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
      GMTrace.o(1544309178368L, 11506);
      return false;
    }
    v.i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", new Object[] { paramString, Integer.valueOf(paramList.size()) });
    g localg;
    if ((this.gUp instanceof g)) {
      localg = (g)this.gUp;
    }
    for (long l = localg.cs(Thread.currentThread().getId());; l = -1L)
    {
      Object localObject = tZ(paramString);
      paramString = new HashMap();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        paramString.put(localc.EQ(), localc);
      }
      int i = 0;
      while (i < paramList.size())
      {
        localObject = (c)paramList.get(i);
        ((c)localObject).field_temp = 0;
        this.gUp.replace("EmojiInfo", "md5", ((c)localObject).pv());
        paramString.remove(((c)localObject).EQ());
        i += 1;
      }
      paramList = paramString.entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject = (Map.Entry)paramList.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (c)((Map.Entry)localObject).getValue();
        ((c)localObject).field_temp = 1;
        this.gUp.update("EmojiInfo", ((c)localObject).pv(), "md5=?", new String[] { paramString });
        v.d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", new Object[] { ((c)localObject).field_groupId });
      }
      if (localg != null) {
        localg.aD(l);
      }
      GMTrace.o(1544309178368L, 11506);
      return true;
      localg = null;
    }
  }
  
  public final int jW(boolean paramBoolean)
  {
    k = 0;
    j = 0;
    GMTrace.i(1542698565632L, 11494);
    localObject3 = null;
    localObject1 = null;
    String str = "select count(*)  from EmojiInfo where catalog=? ";
    Object localObject4 = new String[1];
    localObject4[0] = a.uJd;
    if (paramBoolean)
    {
      str = "select  count(*) from EmojiInfo where catalog=?  or catalog=?";
      localObject4 = new String[2];
      localObject4[0] = String.valueOf(a.uJc);
      localObject4[1] = String.valueOf(a.uJd);
    }
    try
    {
      localObject4 = this.gUp.a(str, (String[])localObject4, 2);
      int i = j;
      if (localObject4 != null)
      {
        i = j;
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          i = ((Cursor)localObject4).getInt(0);
        }
      }
      j = i;
      if (localObject4 != null)
      {
        ((Cursor)localObject4).close();
        j = i;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[] { bf.g(localException) });
        localObject3 = localObject1;
        v.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", new Object[] { localException.toString() });
        j = k;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          j = k;
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label258;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1542698565632L, 11494);
    return j;
  }
  
  public final c r(c paramc)
  {
    GMTrace.i(1541222170624L, 11483);
    if ((bf.mA(paramc.EQ())) || (paramc.EQ().length() <= 0))
    {
      v.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
      GMTrace.o(1541222170624L, 11483);
      return null;
    }
    if (s(paramc))
    {
      Qq("create_emoji_info_notify");
      GMTrace.o(1541222170624L, 11483);
      return paramc;
    }
    GMTrace.o(1541222170624L, 11483);
    return null;
  }
  
  public final boolean s(c paramc)
  {
    GMTrace.i(1541893259264L, 11488);
    if ((paramc == null) || (!paramc.bNm()))
    {
      v.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
      GMTrace.o(1541893259264L, 11488);
      return false;
    }
    ContentValues localContentValues = paramc.pv();
    long l = this.gUp.replace("EmojiInfo", "md5", localContentValues);
    if (l != -1L) {
      Qq(paramc.EQ());
    }
    if (l >= 0L)
    {
      GMTrace.o(1541893259264L, 11488);
      return true;
    }
    GMTrace.o(1541893259264L, 11488);
    return false;
  }
  
  public final boolean t(c paramc)
  {
    GMTrace.i(1542027476992L, 11489);
    if ((paramc == null) || (!paramc.bNm()))
    {
      v.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
      GMTrace.o(1542027476992L, 11489);
      return false;
    }
    int i = this.gUp.update("EmojiInfo", paramc.pv(), "md5=?", new String[] { paramc.EQ() });
    if (i > 0)
    {
      Qq(paramc.EQ());
      Qq("event_update_emoji");
    }
    if (i > 0)
    {
      GMTrace.o(1542027476992L, 11489);
      return true;
    }
    GMTrace.o(1542027476992L, 11489);
    return false;
  }
  
  public final List<c> tZ(String paramString)
  {
    GMTrace.i(1543906525184L, 11503);
    ArrayList localArrayList = new ArrayList();
    localObject = null;
    str = null;
    try
    {
      paramString = this.gUp.a("select * from EmojiInfo where groupId=? and temp=? order by idx asc", new String[] { paramString, "0" }, 2);
      if (paramString != null)
      {
        str = paramString;
        localObject = paramString;
        if (paramString.moveToFirst())
        {
          boolean bool;
          do
          {
            str = paramString;
            localObject = paramString;
            d.akN();
            str = paramString;
            localObject = paramString;
            c localc = new c(d.akO());
            str = paramString;
            localObject = paramString;
            localc.b(paramString);
            str = paramString;
            localObject = paramString;
            localArrayList.add(localc);
            str = paramString;
            localObject = paramString;
            bool = paramString.moveToNext();
          } while (bool);
        }
      }
      if (paramString != null) {
        paramString.close();
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        localObject = str;
        v.w("MicroMsg.emoji.EmojiInfoStorage", "[getEmojiListByGroupId] Exception:%s", new Object[] { paramString.toString() });
        if (str != null) {
          str.close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label208;
      }
      ((Cursor)localObject).close();
    }
    GMTrace.o(1543906525184L, 11503);
    return localArrayList;
  }
  
  public final boolean u(c paramc)
  {
    GMTrace.i(1542161694720L, 11490);
    if ((paramc == null) || (!paramc.bNm()))
    {
      v.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
      GMTrace.o(1542161694720L, 11490);
      return false;
    }
    if (this.gUp.update("EmojiInfo", paramc.pv(), "md5=?", new String[] { paramc.EQ() }) > 0)
    {
      GMTrace.o(1542161694720L, 11490);
      return true;
    }
    GMTrace.o(1542161694720L, 11490);
    return false;
  }
  
  public final Cursor yH(int paramInt)
  {
    GMTrace.i(1543235436544L, 11498);
    Cursor localCursor = this.gUp.query("EmojiInfo", null, "catalog=? and temp=?", new String[] { String.valueOf(paramInt), "0" }, null, null, null);
    GMTrace.o(1543235436544L, 11498);
    return localCursor;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */