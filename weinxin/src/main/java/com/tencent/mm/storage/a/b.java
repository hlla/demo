package com.tencent.mm.storage.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.t;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class b
  extends i<a>
  implements f.a
{
  public static final String[] gUn;
  public com.tencent.mm.sdk.e.e gUp;
  
  static
  {
    GMTrace.i(1560549523456L, 11627);
    gUn = new String[] { i.a(a.gTF, "EmojiGroupInfo") };
    GMTrace.o(1560549523456L, 11627);
  }
  
  public b(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, a.gTF, "EmojiGroupInfo", null);
    GMTrace.i(1555986120704L, 11593);
    this.gUp = parame;
    GMTrace.o(1555986120704L, 11593);
  }
  
  private int bMO()
  {
    k = 0;
    j = 0;
    GMTrace.i(1556791427072L, 11599);
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.gUp.a("select  count(*) from EmojiInfo where catalog=?", new String[] { a.uJd }, 2);
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
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + localException.getMessage());
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
        break label191;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1556791427072L, 11599);
    return j;
  }
  
  public static boolean bMW()
  {
    GMTrace.i(1557999386624L, 11608);
    boolean bool = ((Boolean)h.vI().vr().get(208912, Boolean.valueOf(false))).booleanValue();
    GMTrace.o(1557999386624L, 11608);
    return bool;
  }
  
  private static String bMZ()
  {
    GMTrace.i(1558938910720L, 11615);
    String str = yB(a.TYPE_SYSTEM) + " or " + yB(a.TYPE_CUSTOM) + " or " + yB(a.uIY) + " or " + yB(a.uJa);
    GMTrace.o(1558938910720L, 11615);
    return str;
  }
  
  private static String bNa()
  {
    GMTrace.i(1559073128448L, 11616);
    String str = " ( " + yB(a.uIY) + " and " + bNb() + " ) ";
    GMTrace.o(1559073128448L, 11616);
    return str;
  }
  
  private static String bNb()
  {
    GMTrace.i(1559341563904L, 11618);
    String str = " ( status = '7" + "' ) ";
    GMTrace.o(1559341563904L, 11618);
    return str;
  }
  
  private ArrayList<a> ev(Context paramContext)
  {
    GMTrace.i(1556522991616L, 11597);
    a locala = null;
    Element localElement = null;
    NodeList localNodeList = null;
    localArrayList = new ArrayList();
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    localObject2 = localNodeList;
    localObject3 = locala;
    localObject1 = localElement;
    try
    {
      v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml start.");
      localObject2 = localNodeList;
      localObject3 = locala;
      localObject1 = localElement;
      paramContext = paramContext.getAssets().open("custom_emoji/manifest.xml");
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      localNodeList = localDocumentBuilderFactory.newDocumentBuilder().parse(paramContext).getDocumentElement().getElementsByTagName("catalog");
      i = 0;
    }
    catch (IOException paramContext)
    {
      int k;
      localObject1 = localObject2;
      v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[] { bf.g(paramContext) });
      localObject1 = localObject2;
      v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "init emoji group db error." + paramContext.getMessage());
      if (localObject2 == null) {
        break label673;
      }
      try
      {
        ((InputStream)localObject2).close();
        for (;;)
        {
          GMTrace.o(1556522991616L, 11597);
          return localArrayList;
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          if (localArrayList.size() > 0)
          {
            localObject2 = paramContext;
            localObject3 = paramContext;
            localObject1 = paramContext;
            cn(localArrayList);
          }
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml end.");
          if (paramContext != null) {
            try
            {
              paramContext.close();
            }
            catch (Exception paramContext)
            {
              v.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", paramContext, "", new Object[0]);
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", paramContext, "", new Object[0]);
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        localObject1 = localObject3;
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[] { bf.g(paramContext) });
        localObject1 = localObject3;
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "parse xml error; " + paramContext.getMessage());
        if (localObject3 != null) {
          try
          {
            ((InputStream)localObject3).close();
          }
          catch (Exception paramContext)
          {
            v.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", paramContext, "", new Object[0]);
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        if (localObject1 != null) {}
        try
        {
          ((InputStream)localObject1).close();
          throw paramContext;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", localException, "", new Object[0]);
          }
        }
        i += 1;
        continue;
        int j = 0;
      }
    }
    localObject2 = paramContext;
    localObject3 = paramContext;
    localObject1 = paramContext;
    if (i < localNodeList.getLength())
    {
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      locala = new a();
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      localElement = (Element)localNodeList.item(i);
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      k = Integer.decode(localElement.getAttribute("id")).intValue();
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      if (!TextUtils.isEmpty(localElement.getAttribute("sort")))
      {
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "Set Sort id:%d,sort:%d", new Object[] { Integer.valueOf(k), Integer.decode(localElement.getAttribute("sort")) });
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        j = a.uJc;
        if ((k & j) != j) {
          break label902;
        }
        j = 1;
        if (j == 0) {
          break label590;
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        if (bMO() <= 0)
        {
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          if (!bMW()) {
            break label590;
          }
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        locala.field_sort = -1;
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        h.vI().vr().set(208912, Boolean.valueOf(true));
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "moveCustomEmojiTabToSecond");
      }
      for (;;)
      {
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        locala.field_productID = String.valueOf(k);
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        locala.field_packName = localElement.getAttribute("name");
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        if (!TextUtils.isEmpty(localElement.getAttribute("type")))
        {
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          locala.field_type = Integer.decode(localElement.getAttribute("type")).intValue();
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        if (!TextUtils.isEmpty(localElement.getAttribute("free")))
        {
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          locala.field_packType = Integer.decode(localElement.getAttribute("free")).intValue();
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        if (locala.field_type != a.TYPE_SYSTEM)
        {
          localObject2 = paramContext;
          localObject3 = paramContext;
          localObject1 = paramContext;
          if (locala.field_type != a.TYPE_CUSTOM) {
            break;
          }
        }
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        localArrayList.add(locala);
        break;
        label590:
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        locala.field_sort = (i + 1);
      }
    }
  }
  
  private static String yB(int paramInt)
  {
    GMTrace.i(1559207346176L, 11617);
    String str = " ( type = '" + paramInt + "' ) ";
    GMTrace.o(1559207346176L, 11617);
    return str;
  }
  
  private static String yC(int paramInt)
  {
    GMTrace.i(1559475781632L, 11619);
    String str = " ( " + yB(paramInt) + " and ( ( ( flag & 256 ) = 0 )  or ( flag is null ) )  ) ";
    GMTrace.o(1559475781632L, 11619);
    return str;
  }
  
  public final boolean Sb(String paramString)
  {
    localObject = null;
    Cursor localCursor = null;
    boolean bool = false;
    GMTrace.i(1557865168896L, 11607);
    if (TextUtils.isEmpty(paramString)) {
      v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "product id is null.");
    }
    String str = "select count(*) from EmojiGroupInfo where productID = '" + paramString + "' AND " + bNb() + " AND ( ( ( flag & 256 ) = 0 )  or ( flag is null ) ) ";
    paramString = localCursor;
    try
    {
      localCursor = this.gUp.a(str, null, 2);
      if (localCursor != null)
      {
        paramString = localCursor;
        localObject = localCursor;
        if (localCursor.moveToFirst())
        {
          paramString = localCursor;
          localObject = localCursor;
          int i = localCursor.getInt(0);
          if (i > 0) {
            bool = true;
          }
          if (localCursor != null) {
            localCursor.close();
          }
          GMTrace.o(1557865168896L, 11607);
          return bool;
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
        localObject = paramString;
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + localException.getMessage());
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label233;
      }
      ((Cursor)localObject).close();
    }
    GMTrace.o(1557865168896L, 11607);
    return false;
  }
  
  public final boolean Sc(String paramString)
  {
    GMTrace.i(1558402039808L, 11611);
    String str;
    if (!bf.mA(paramString)) {
      str = paramString;
    }
    for (;;)
    {
      try
      {
        if (paramString.equals("com.tencent.xin.emoticon.tusiji")) {
          str = a.uJb;
        }
        paramString = aP(str, true);
        if (paramString == null)
        {
          bool = false;
          if (bool)
          {
            a("event_update_group", 0, bf.bJP().toString());
            Qq("delete_group");
          }
          GMTrace.o(1558402039808L, 11611);
          return bool;
        }
        if (paramString != null)
        {
          if (paramString.field_type == a.TYPE_CUSTOM) {
            v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks refuse delete custom emoji");
          }
        }
        else
        {
          paramString.field_lastUseTime = System.currentTimeMillis();
          paramString.field_recommand = 0;
          paramString.field_sync = 0;
          bool = a(paramString);
          continue;
        }
        paramString.field_flag |= 0x100;
        paramString.field_status = -1;
        paramString.field_sort = 1;
        paramString.field_recommand = 0;
        paramString.field_sync = 0;
        continue;
        boolean bool = false;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Delete By ProductId fail." + paramString.getMessage());
      }
    }
  }
  
  public final int Sd(String paramString)
  {
    GMTrace.i(1560281088000L, 11625);
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
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[] { bf.g(paramString) });
        localObject = str;
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "[countProductId]Count ProductId fail." + paramString.getMessage());
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
      v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "count product id use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      GMTrace.o(1560281088000L, 11625);
      return j;
      label215:
      int j = 0;
      continue;
      label220:
      int i = 0;
    }
  }
  
  public final int a(f paramf)
  {
    GMTrace.i(1556254556160L, 11595);
    if (paramf != null) {
      this.gUp = paramf;
    }
    GMTrace.o(1556254556160L, 11595);
    return 0;
  }
  
  /* Error */
  public final a aP(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc2_w 466
    //   3: sipush 11598
    //   6: invokestatic 21	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: getfield 50	com/tencent/mm/storage/a/b:gUp	Lcom/tencent/mm/sdk/e/e;
    //   13: ldc_w 469
    //   16: iconst_1
    //   17: anewarray 23	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: aload_1
    //   23: aastore
    //   24: iconst_2
    //   25: invokeinterface 79 4 0
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +49 -> 81
    //   35: aload_3
    //   36: invokeinterface 85 1 0
    //   41: ifeq +40 -> 81
    //   44: new 25	com/tencent/mm/storage/a/a
    //   47: dup
    //   48: invokespecial 244	com/tencent/mm/storage/a/a:<init>	()V
    //   51: astore 6
    //   53: aload 6
    //   55: aload_3
    //   56: invokevirtual 473	com/tencent/mm/storage/a/a:b	(Landroid/database/Cursor;)V
    //   59: aload_3
    //   60: ifnull +9 -> 69
    //   63: aload_3
    //   64: invokeinterface 92 1 0
    //   69: ldc2_w 466
    //   72: sipush 11598
    //   75: invokestatic 40	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   78: aload 6
    //   80: areturn
    //   81: aload_3
    //   82: ifnull +179 -> 261
    //   85: aload_3
    //   86: invokeinterface 92 1 0
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnonnull +115 -> 209
    //   97: iload_2
    //   98: ifeq +92 -> 190
    //   101: ldc2_w 466
    //   104: sipush 11598
    //   107: invokestatic 40	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 5
    //   114: aconst_null
    //   115: astore 4
    //   117: aconst_null
    //   118: astore_3
    //   119: ldc 94
    //   121: new 60	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 475
    //   128: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload_1
    //   132: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 477
    //   138: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 5
    //   143: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 111	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload 4
    //   157: ifnull +99 -> 256
    //   160: aload 4
    //   162: invokeinterface 92 1 0
    //   167: aload_3
    //   168: astore_1
    //   169: goto -76 -> 93
    //   172: astore_1
    //   173: aconst_null
    //   174: astore 4
    //   176: aload 4
    //   178: ifnull +10 -> 188
    //   181: aload 4
    //   183: invokeinterface 92 1 0
    //   188: aload_1
    //   189: athrow
    //   190: new 25	com/tencent/mm/storage/a/a
    //   193: dup
    //   194: invokespecial 244	com/tencent/mm/storage/a/a:<init>	()V
    //   197: astore_1
    //   198: ldc2_w 466
    //   201: sipush 11598
    //   204: invokestatic 40	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   207: aload_1
    //   208: areturn
    //   209: ldc2_w 466
    //   212: sipush 11598
    //   215: invokestatic 40	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   218: aload_1
    //   219: areturn
    //   220: astore_1
    //   221: aload_3
    //   222: astore 4
    //   224: goto -48 -> 176
    //   227: astore_1
    //   228: goto -52 -> 176
    //   231: astore 5
    //   233: aconst_null
    //   234: astore 6
    //   236: aload_3
    //   237: astore 4
    //   239: aload 6
    //   241: astore_3
    //   242: goto -123 -> 119
    //   245: astore 5
    //   247: aload_3
    //   248: astore 4
    //   250: aload 6
    //   252: astore_3
    //   253: goto -134 -> 119
    //   256: aload_3
    //   257: astore_1
    //   258: goto -165 -> 93
    //   261: aconst_null
    //   262: astore_1
    //   263: goto -170 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	b
    //   0	266	1	paramString	String
    //   0	266	2	paramBoolean	boolean
    //   30	227	3	localObject1	Object
    //   115	134	4	localObject2	Object
    //   112	30	5	localException1	Exception
    //   231	1	5	localException2	Exception
    //   245	1	5	localException3	Exception
    //   51	200	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   9	31	112	java/lang/Exception
    //   9	31	172	finally
    //   35	53	220	finally
    //   53	59	220	finally
    //   119	155	227	finally
    //   35	53	231	java/lang/Exception
    //   53	59	245	java/lang/Exception
  }
  
  public final void ag(ArrayList<String> paramArrayList)
  {
    GMTrace.i(1558536257536L, 11612);
    g localg;
    long l;
    if ((this.gUp instanceof g))
    {
      localg = (g)this.gUp;
      l = localg.cs(Thread.currentThread().getId());
      v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround deleteByGroupIdList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          Sc((String)paramArrayList.next());
        }
      }
      if (localg != null)
      {
        localg.aD(l);
        v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end deleteByGroupIdList transaction");
      }
      GMTrace.o(1558536257536L, 11612);
      return;
      localg = null;
      l = -1L;
    }
  }
  
  public final boolean bMP()
  {
    boolean bool = true;
    GMTrace.i(1556925644800L, 11600);
    localObject3 = null;
    localObject1 = null;
    try
    {
      Cursor localCursor = this.gUp.a("select * from EmojiGroupInfo where type=?", new String[] { a.TYPE_SYSTEM }, 2);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          a locala = new a();
          localObject1 = localCursor;
          localObject3 = localCursor;
          locala.b(localCursor);
          localObject1 = localCursor;
          localObject3 = localCursor;
          int i = locala.field_flag;
          if ((i & 0x100) > 0)
          {
            i = 1;
            if (i != 0) {
              break label161;
            }
          }
          for (;;)
          {
            if (localCursor != null) {
              localCursor.close();
            }
            GMTrace.o(1556925644800L, 11600);
            return bool;
            i = 0;
            break;
            label161:
            bool = false;
          }
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
        v.d("MicroMsg.emoji.EmojiGroupInfoStorage", localException.toString());
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label230;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1556925644800L, 11600);
    return false;
  }
  
  public final List<a> bMQ()
  {
    localObject3 = null;
    localObject1 = null;
    GMTrace.i(1557059862528L, 11601);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + yC(a.TYPE_SYSTEM) + " or " + yC(a.TYPE_CUSTOM) + " order by sort ASC";
    try
    {
      localObject4 = this.gUp.a((String)localObject4, null, 2);
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
            a locala = new a();
            localObject1 = localObject4;
            localObject3 = localObject4;
            locala.b((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(locala);
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
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get system group fail." + localException.getMessage());
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label242;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1557059862528L, 11601);
    return localArrayList;
  }
  
  public final List<a> bMR()
  {
    localObject3 = null;
    localObject1 = null;
    GMTrace.i(1557194080256L, 11602);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + bMZ() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.gUp.a((String)localObject4, null, 2);
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
            a locala = new a();
            localObject1 = localObject4;
            localObject3 = localObject4;
            locala.b((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(locala);
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
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + localException.getMessage());
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label225;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1557194080256L, 11602);
    return localArrayList;
  }
  
  public final HashMap<String, a> bMS()
  {
    localObject3 = null;
    localObject1 = null;
    GMTrace.i(1557328297984L, 11603);
    HashMap localHashMap = new HashMap();
    Object localObject4 = "select * from EmojiGroupInfo where " + bMZ() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.gUp.a((String)localObject4, null, 2);
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
            a locala = new a();
            localObject1 = localObject4;
            localObject3 = localObject4;
            locala.b((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localHashMap.put(locala.field_productID, locala);
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
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + localException.getMessage());
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label228;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1557328297984L, 11603);
    return localHashMap;
  }
  
  public final ArrayList<a> bMT()
  {
    localObject3 = null;
    localObject1 = null;
    GMTrace.i(1557462515712L, 11604);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + bNa() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.gUp.a((String)localObject4, null, 2);
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
            a locala = new a();
            localObject1 = localObject4;
            localObject3 = localObject4;
            locala.b((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(locala);
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
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + localException.getMessage());
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label223;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1557462515712L, 11604);
    return localArrayList;
  }
  
  public final int bMU()
  {
    localObject3 = null;
    localObject1 = null;
    k = 0;
    j = 0;
    GMTrace.i(1557596733440L, 11605);
    Object localObject4 = "select count(*) from EmojiGroupInfo where " + bNa() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.gUp.a((String)localObject4, null, 2);
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
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getDownloadGroupListCount fail." + localException.getMessage());
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
        break label197;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1557596733440L, 11605);
    return j;
  }
  
  public final HashMap<String, ak> bMV()
  {
    localObject3 = null;
    localObject1 = null;
    GMTrace.i(1557730951168L, 11606);
    HashMap localHashMap = new HashMap();
    Object localObject4 = "select * from EmojiGroupInfo where " + bNa() + " order by sort ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.gUp.a((String)localObject4, null, 2);
      if (localObject4 != null)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (((Cursor)localObject4).moveToFirst())
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          ak localak = new ak();
          localObject1 = localObject4;
          localObject3 = localObject4;
          int i = ((Cursor)localObject4).getColumnIndex("productID");
          localObject1 = localObject4;
          localObject3 = localObject4;
          int j = ((Cursor)localObject4).getColumnIndex("packName");
          boolean bool;
          do
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            String str = ((Cursor)localObject4).getString(i);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localak.fFR = str;
            localObject1 = localObject4;
            localObject3 = localObject4;
            localak.kRg = ((Cursor)localObject4).getString(j);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localak.yy(7);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localHashMap.put(str, localak);
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
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get download group map failed." + localException.getMessage());
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label336;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1557730951168L, 11606);
    return localHashMap;
  }
  
  public final void bMX()
  {
    GMTrace.i(1558670475264L, 11613);
    String str = a.TYPE_CUSTOM;
    str = "UPDATE EmojiGroupInfo SET sort=-1,lastUseTime=" + System.currentTimeMillis() + " WHERE type=" + str;
    if (this.gUp.eE("EmojiGroupInfo", str)) {
      a("event_update_group", 0, bf.bJP().toString());
    }
    h.vI().vr().set(208912, Boolean.valueOf(true));
    GMTrace.o(1558670475264L, 11613);
  }
  
  public final ArrayList<a> bMY()
  {
    localObject3 = null;
    localObject1 = null;
    GMTrace.i(1558804692992L, 11614);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where " + bNa() + " or " + yC(a.TYPE_SYSTEM) + " or " + yC(a.TYPE_CUSTOM) + " or " + new StringBuilder(" ( recommand = '1").append("' ) ").toString() + " order by sort ASC,idx ASC,lastUseTime DESC";
    try
    {
      localObject4 = this.gUp.a((String)localObject4, null, 2);
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
            a locala = new a();
            localObject1 = localObject4;
            localObject3 = localObject4;
            locala.b((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(locala);
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
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + localException.getMessage());
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label277;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1558804692992L, 11614);
    return localArrayList;
  }
  
  /* Error */
  public final boolean bNc()
  {
    // Byte code:
    //   0: ldc2_w 644
    //   3: sipush 11620
    //   6: invokestatic 21	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 60	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   16: getstatic 148	com/tencent/mm/storage/a/a:TYPE_SYSTEM	I
    //   19: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore_3
    //   26: new 60	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   33: getstatic 160	com/tencent/mm/storage/a/a:uIY	I
    //   36: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 4
    //   44: ldc 94
    //   46: ldc_w 647
    //   49: iconst_1
    //   50: anewarray 275	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: ldc_w 649
    //   58: aastore
    //   59: invokestatic 500	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_0
    //   65: getfield 50	com/tencent/mm/storage/a/b:gUp	Lcom/tencent/mm/sdk/e/e;
    //   68: ldc_w 649
    //   71: iconst_4
    //   72: anewarray 23	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: aload_3
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload 4
    //   83: aastore
    //   84: dup
    //   85: iconst_2
    //   86: ldc_w 453
    //   89: aastore
    //   90: dup
    //   91: iconst_3
    //   92: ldc_w 651
    //   95: aastore
    //   96: iconst_2
    //   97: invokeinterface 79 4 0
    //   102: astore_3
    //   103: aload_3
    //   104: ifnull +37 -> 141
    //   107: aload_3
    //   108: astore_2
    //   109: aload_3
    //   110: invokeinterface 85 1 0
    //   115: istore_1
    //   116: iload_1
    //   117: ifeq +24 -> 141
    //   120: aload_3
    //   121: ifnull +9 -> 130
    //   124: aload_3
    //   125: invokeinterface 92 1 0
    //   130: ldc2_w 644
    //   133: sipush 11620
    //   136: invokestatic 40	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   139: iconst_1
    //   140: ireturn
    //   141: aload_3
    //   142: ifnull +9 -> 151
    //   145: aload_3
    //   146: invokeinterface 92 1 0
    //   151: ldc2_w 644
    //   154: sipush 11620
    //   157: invokestatic 40	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_2
    //   163: aconst_null
    //   164: astore_2
    //   165: ldc 94
    //   167: ldc_w 653
    //   170: invokestatic 111	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_2
    //   174: ifnull -23 -> 151
    //   177: aload_2
    //   178: invokeinterface 92 1 0
    //   183: goto -32 -> 151
    //   186: astore_3
    //   187: aload_2
    //   188: ifnull +9 -> 197
    //   191: aload_2
    //   192: invokeinterface 92 1 0
    //   197: aload_3
    //   198: athrow
    //   199: astore_3
    //   200: goto -13 -> 187
    //   203: astore_2
    //   204: aload_3
    //   205: astore_2
    //   206: goto -41 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	b
    //   115	2	1	bool	boolean
    //   63	46	2	localObject1	Object
    //   162	1	2	localException1	Exception
    //   164	28	2	localObject2	Object
    //   203	1	2	localException2	Exception
    //   205	1	2	localObject3	Object
    //   25	121	3	localObject4	Object
    //   186	12	3	localObject5	Object
    //   199	6	3	localObject6	Object
    //   42	40	4	str	String
    // Exception table:
    //   from	to	target	type
    //   64	103	162	java/lang/Exception
    //   64	103	186	finally
    //   109	116	186	finally
    //   165	173	199	finally
    //   109	116	203	java/lang/Exception
  }
  
  /* Error */
  public final List<String> bNd()
  {
    // Byte code:
    //   0: ldc2_w 655
    //   3: sipush 11621
    //   6: invokestatic 21	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: new 189	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 190	java/util/ArrayList:<init>	()V
    //   16: astore 5
    //   18: new 60	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   25: getstatic 160	com/tencent/mm/storage/a/a:uIY	I
    //   28: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore_3
    //   35: aconst_null
    //   36: astore_2
    //   37: aload_0
    //   38: getfield 50	com/tencent/mm/storage/a/b:gUp	Lcom/tencent/mm/sdk/e/e;
    //   41: ldc_w 658
    //   44: iconst_2
    //   45: anewarray 23	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: aload_3
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: ldc_w 660
    //   57: aastore
    //   58: iconst_2
    //   59: invokeinterface 79 4 0
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull +57 -> 125
    //   71: aload 4
    //   73: astore_2
    //   74: aload 4
    //   76: astore_3
    //   77: aload 4
    //   79: invokeinterface 85 1 0
    //   84: ifeq +41 -> 125
    //   87: aload 4
    //   89: astore_2
    //   90: aload 4
    //   92: astore_3
    //   93: aload 5
    //   95: aload 4
    //   97: iconst_0
    //   98: invokeinterface 606 2 0
    //   103: invokevirtual 325	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload 4
    //   109: astore_2
    //   110: aload 4
    //   112: astore_3
    //   113: aload 4
    //   115: invokeinterface 552 1 0
    //   120: istore_1
    //   121: iload_1
    //   122: ifne -35 -> 87
    //   125: aload 4
    //   127: ifnull +10 -> 137
    //   130: aload 4
    //   132: invokeinterface 92 1 0
    //   137: ldc2_w 655
    //   140: sipush 11621
    //   143: invokestatic 40	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   146: aload 5
    //   148: areturn
    //   149: astore_3
    //   150: aload_2
    //   151: astore_3
    //   152: ldc 94
    //   154: ldc_w 662
    //   157: iconst_1
    //   158: anewarray 275	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: invokestatic 405	com/tencent/mm/sdk/platformtools/bf:bJP	()Lcom/tencent/mm/sdk/platformtools/ag;
    //   166: aastore
    //   167: invokestatic 335	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload_2
    //   171: ifnull -34 -> 137
    //   174: aload_2
    //   175: invokeinterface 92 1 0
    //   180: goto -43 -> 137
    //   183: astore_2
    //   184: aconst_null
    //   185: astore_3
    //   186: aload_3
    //   187: ifnull +9 -> 196
    //   190: aload_3
    //   191: invokeinterface 92 1 0
    //   196: aload_2
    //   197: athrow
    //   198: astore_2
    //   199: goto -13 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	b
    //   120	2	1	bool	boolean
    //   36	139	2	localObject1	Object
    //   183	14	2	localObject2	Object
    //   198	1	2	localObject3	Object
    //   34	79	3	localObject4	Object
    //   149	1	3	localException	Exception
    //   151	40	3	localObject5	Object
    //   64	67	4	localCursor	Cursor
    //   16	131	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   37	66	149	java/lang/Exception
    //   77	87	149	java/lang/Exception
    //   93	107	149	java/lang/Exception
    //   113	121	149	java/lang/Exception
    //   37	66	183	finally
    //   77	87	198	finally
    //   93	107	198	finally
    //   113	121	198	finally
    //   152	170	198	finally
  }
  
  public final List<String> bNe()
  {
    GMTrace.i(1559878434816L, 11622);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = a.uIY;
    Object localObject6 = a.TYPE_SYSTEM;
    Object localObject1 = null;
    try
    {
      localObject6 = this.gUp.a("select productID from EmojiGroupInfo where sync=? and (type=?  and status=?) or (type=? and flag=?)", new String[] { "0", localObject4, "7", localObject6, "0" }, 2);
      if (localObject6 != null)
      {
        localObject1 = localObject6;
        localObject4 = localObject6;
      }
      boolean bool;
      if (localObject5 == null) {
        break label231;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          if (((Cursor)localObject6).moveToFirst())
          {
            localObject1 = localObject6;
            localObject4 = localObject6;
            localArrayList.add(((Cursor)localObject6).getString(0));
            localObject1 = localObject6;
            localObject4 = localObject6;
            bool = ((Cursor)localObject6).moveToNext();
            if (bool) {
              continue;
            }
          }
          if (localObject6 != null) {
            ((Cursor)localObject6).close();
          }
          GMTrace.o(1559878434816L, 11622);
          return localArrayList;
        }
        finally
        {
          Object localObject5;
          continue;
        }
        localException = localException;
        localObject5 = localObject1;
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToUploadStoreEmojiProductList. exception.%s", new Object[] { bf.bJP() });
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      localObject2 = finally;
      localObject5 = null;
    }
    ((Cursor)localObject5).close();
    label231:
    throw ((Throwable)localObject2);
  }
  
  public final ArrayList<a> bNf()
  {
    GMTrace.i(1560012652544L, 11623);
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = "select * from EmojiGroupInfo where  (type=?  and status=?) or (type=? and flag=?)  order by sort ASC,idx ASC,lastUseTime DESC";
    Object localObject5 = a.uIY;
    String str = a.TYPE_SYSTEM;
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = this.gUp.a((String)localObject4, new String[] { localObject5, "7", str, "0" }, 2);
      localObject1 = localObject4;
      localObject3 = localObject4;
      v.v("MicroMsg.emoji.EmojiGroupInfoStorage", "getNewMineGroupList : ===========");
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
            localObject5 = new a();
            localObject1 = localObject4;
            localObject3 = localObject4;
            ((a)localObject5).b((Cursor)localObject4);
            localObject1 = localObject4;
            localObject3 = localObject4;
            localArrayList.add(localObject5);
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
        v.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + localException.getMessage());
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label286;
      }
      ((Cursor)localObject3).close();
    }
    GMTrace.o(1560012652544L, 11623);
    return localArrayList;
  }
  
  public final void bNg()
  {
    GMTrace.i(1560146870272L, 11624);
    v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart begin");
    a locala = aP(String.valueOf(a.uJc), false);
    if (locala == null) {
      locala = new a();
    }
    for (;;)
    {
      locala.field_productID = String.valueOf(a.uJc);
      locala.field_packName = "emoji_custom_group";
      locala.field_type = a.TYPE_CUSTOM;
      locala.field_status = 0;
      locala.field_packStatus = 1;
      locala.field_flag = 0;
      a(locala);
      v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart end");
      GMTrace.o(1560146870272L, 11624);
      return;
      v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "EmojiGroupInfo:%s", new Object[] { locala.toString() });
    }
  }
  
  public final boolean c(a parama)
  {
    GMTrace.i(1558133604352L, 11609);
    if (parama == null)
    {
      v.f("MicroMsg.emoji.EmojiGroupInfoStorage", "insert assertion!,invalid emojigroup info.");
      GMTrace.o(1558133604352L, 11609);
      return false;
    }
    parama.field_lastUseTime = System.currentTimeMillis();
    parama.field_sort = 1;
    v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks insert: packname: %s, lasttime: %d", new Object[] { parama.field_packName, Long.valueOf(parama.field_lastUseTime) });
    parama.field_lastUseTime = System.currentTimeMillis();
    if (parama != null) {
      parama.field_flag &= 0xFEFF;
    }
    boolean bool = a(parama);
    if (bool) {
      a("event_update_group", 0, bf.bJP().toString());
    }
    GMTrace.o(1558133604352L, 11609);
    return bool;
  }
  
  public final boolean cn(List<a> paramList)
  {
    GMTrace.i(1558267822080L, 11610);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "updateList . list is null.");
      GMTrace.o(1558267822080L, 11610);
      return false;
    }
    g localg;
    long l;
    if ((this.gUp instanceof g))
    {
      localg = (g)this.gUp;
      l = localg.cs(Thread.currentThread().getId());
      v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround updateList in a transaction, ticket = %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      int i = 0;
      while (i < paramList.size())
      {
        a locala = (a)paramList.get(i);
        v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks packname: productid: %s, lasttime: %d, sort: %d", new Object[] { locala.field_productID, Long.valueOf(locala.field_lastUseTime), Integer.valueOf(locala.field_sort) });
        a(locala);
        i += 1;
      }
      if (localg != null)
      {
        localg.aD(l);
        v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
      }
      a("event_update_group", 0, bf.bJP().toString());
      GMTrace.o(1558267822080L, 11610);
      return true;
      localg = null;
      l = -1L;
    }
  }
  
  public final boolean eu(Context paramContext)
  {
    GMTrace.i(1556388773888L, 11596);
    v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init start.");
    ev(paramContext);
    v.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init end.");
    GMTrace.o(1556388773888L, 11596);
    return true;
  }
  
  public final String getTableName()
  {
    GMTrace.i(1556120338432L, 11594);
    GMTrace.o(1556120338432L, 11594);
    return "EmojiGroupInfo";
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */