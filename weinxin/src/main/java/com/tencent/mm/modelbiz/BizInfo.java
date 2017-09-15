package com.tencent.mm.modelbiz;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.y;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class BizInfo
  extends y
{
  protected static c.a gTF;
  public static int htY;
  public static int htZ;
  public static int hua;
  private static int hud;
  private static ExtInfo hue;
  private List<a> hub;
  public ExtInfo huc;
  
  static
  {
    GMTrace.i(4548370366464L, 33888);
    htY = 1;
    htZ = 0;
    hua = 1;
    c.a locala = new c.a();
    locala.hXn = new Field[19];
    locala.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.uvr.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "username";
    locala.columns[1] = "brandList";
    locala.uvr.put("brandList", "TEXT default '' ");
    localStringBuilder.append(" brandList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandListVersion";
    locala.uvr.put("brandListVersion", "TEXT");
    localStringBuilder.append(" brandListVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "brandListContent";
    locala.uvr.put("brandListContent", "TEXT");
    localStringBuilder.append(" brandListContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "brandFlag";
    locala.uvr.put("brandFlag", "INTEGER");
    localStringBuilder.append(" brandFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "extInfo";
    locala.uvr.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "brandInfo";
    locala.uvr.put("brandInfo", "TEXT");
    localStringBuilder.append(" brandInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "brandIconURL";
    locala.uvr.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "updateTime";
    locala.uvr.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "hadAlert";
    locala.uvr.put("hadAlert", "INTEGER");
    localStringBuilder.append(" hadAlert INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "acceptType";
    locala.uvr.put("acceptType", "INTEGER default '0' ");
    localStringBuilder.append(" acceptType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "type";
    locala.uvr.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "status";
    locala.uvr.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "enterpriseFather";
    locala.uvr.put("enterpriseFather", "TEXT");
    localStringBuilder.append(" enterpriseFather TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "kfWorkerId";
    locala.uvr.put("kfWorkerId", "TEXT");
    localStringBuilder.append(" kfWorkerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "specialType";
    locala.uvr.put("specialType", "INTEGER");
    localStringBuilder.append(" specialType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "attrSyncVersion";
    locala.uvr.put("attrSyncVersion", "TEXT");
    localStringBuilder.append(" attrSyncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "incrementUpdateTime";
    locala.uvr.put("incrementUpdateTime", "LONG");
    localStringBuilder.append(" incrementUpdateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "bitFlag";
    locala.uvr.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    locala.columns[19] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    hud = 0;
    hue = null;
    GMTrace.o(4548370366464L, 33888);
  }
  
  public BizInfo()
  {
    GMTrace.i(4545283358720L, 33865);
    GMTrace.o(4545283358720L, 33865);
  }
  
  private boolean fu(int paramInt)
  {
    GMTrace.i(4548101931008L, 33886);
    if ((this.field_bitFlag & paramInt) != 0)
    {
      GMTrace.o(4548101931008L, 33886);
      return true;
    }
    GMTrace.o(4548101931008L, 33886);
    return false;
  }
  
  private void fv(int paramInt)
  {
    GMTrace.i(4548236148736L, 33887);
    this.field_bitFlag |= paramInt;
    GMTrace.o(4548236148736L, 33887);
  }
  
  public final boolean CA()
  {
    GMTrace.i(4545820229632L, 33869);
    if ((this.field_brandFlag & 0x4) != 0)
    {
      GMTrace.o(4545820229632L, 33869);
      return true;
    }
    GMTrace.o(4545820229632L, 33869);
    return false;
  }
  
  public final boolean CB()
  {
    GMTrace.i(4545954447360L, 33870);
    if (System.currentTimeMillis() - this.field_updateTime > 86400000L)
    {
      GMTrace.o(4545954447360L, 33870);
      return true;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    if (this.field_updateTime < localCalendar.getTimeInMillis())
    {
      GMTrace.o(4545954447360L, 33870);
      return true;
    }
    GMTrace.o(4545954447360L, 33870);
    return false;
  }
  
  public final void CC()
  {
    GMTrace.i(4546088665088L, 33871);
    bd(false);
    ExtInfo localExtInfo = this.huc;
    if (localExtInfo.hug != null) {
      localExtInfo.huu = localExtInfo.hug.optInt("ConnectorMsgType");
    }
    this.field_acceptType = localExtInfo.huu;
    this.field_type = bd(false).De();
    if (CJ())
    {
      fv(1);
      GMTrace.o(4546088665088L, 33871);
      return;
    }
    this.field_bitFlag &= 0xFFFFFFFE;
    GMTrace.o(4546088665088L, 33871);
  }
  
  public final boolean CD()
  {
    GMTrace.i(4546222882816L, 33872);
    bd(false);
    v.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[] { this.field_username, Boolean.valueOf(this.huc.CD()) });
    boolean bool = this.huc.CD();
    GMTrace.o(4546222882816L, 33872);
    return bool;
  }
  
  public final boolean CE()
  {
    GMTrace.i(4546357100544L, 33873);
    bd(false);
    if (this.field_type == 1)
    {
      GMTrace.o(4546357100544L, 33873);
      return true;
    }
    GMTrace.o(4546357100544L, 33873);
    return false;
  }
  
  public final boolean CF()
  {
    GMTrace.i(4546491318272L, 33874);
    bd(false);
    if (this.field_type == 0)
    {
      GMTrace.o(4546491318272L, 33874);
      return true;
    }
    GMTrace.o(4546491318272L, 33874);
    return false;
  }
  
  public final boolean CG()
  {
    GMTrace.i(4546625536000L, 33875);
    bd(false);
    if ((this.field_type == 2) || (this.field_type == 3))
    {
      GMTrace.o(4546625536000L, 33875);
      return true;
    }
    GMTrace.o(4546625536000L, 33875);
    return false;
  }
  
  public final boolean CH()
  {
    GMTrace.i(4546759753728L, 33876);
    bd(false);
    if (this.field_type == 2)
    {
      GMTrace.o(4546759753728L, 33876);
      return true;
    }
    GMTrace.o(4546759753728L, 33876);
    return false;
  }
  
  public final boolean CI()
  {
    GMTrace.i(4546893971456L, 33877);
    bd(false);
    if (this.field_type == 3)
    {
      GMTrace.o(4546893971456L, 33877);
      return true;
    }
    GMTrace.o(4546893971456L, 33877);
    return false;
  }
  
  public final boolean CJ()
  {
    GMTrace.i(4547028189184L, 33878);
    bd(false);
    boolean bool1;
    if ((this.huc != null) && (this.huc.Di() != null)) {
      if (this.huc.hur.huR == 1)
      {
        bool1 = true;
        if ((bool1) && (!fu(1)))
        {
          fv(1);
          w.DH().e(this);
        }
        bool2 = bool1;
        if (bool1) {
          v.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", new Object[] { this.field_username });
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      GMTrace.o(4547028189184L, 33878);
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  public final boolean CK()
  {
    GMTrace.i(4547162406912L, 33879);
    bd(false);
    boolean bool1;
    if ((this.huc != null) && (this.huc.Di() != null)) {
      if (this.huc.hur.huR == 2)
      {
        bool1 = true;
        if ((bool1) && (!fu(2)))
        {
          fv(2);
          w.DH().e(this);
        }
        bool2 = bool1;
        if (bool1) {
          v.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", new Object[] { this.field_username });
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      GMTrace.o(4547162406912L, 33879);
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  public final String CL()
  {
    GMTrace.i(4547296624640L, 33880);
    bd(false);
    if (this.huc != null)
    {
      Object localObject = this.huc.Di();
      if ((localObject != null) && (((BizInfo.ExtInfo.b.a)localObject).huS != null) && (!((BizInfo.ExtInfo.b.a)localObject).huS.isEmpty()))
      {
        localObject = ((BizInfo.ExtInfo.b.a)localObject).huS;
        GMTrace.o(4547296624640L, 33880);
        return (String)localObject;
      }
    }
    GMTrace.o(4547296624640L, 33880);
    return null;
  }
  
  public final long CM()
  {
    GMTrace.i(18486076112896L, 137732);
    bd(false);
    if (this.huc != null)
    {
      BizInfo.ExtInfo.b.a locala = this.huc.Di();
      if ((locala != null) && (locala.appid != 0L))
      {
        long l = locala.appid;
        GMTrace.o(18486076112896L, 137732);
        return l;
      }
    }
    GMTrace.o(18486076112896L, 137732);
    return 0L;
  }
  
  public final String CN()
  {
    GMTrace.i(4547430842368L, 33881);
    bd(false);
    if (this.huc != null)
    {
      Object localObject = this.huc.Di();
      if (localObject != null)
      {
        localObject = ((BizInfo.ExtInfo.b.a)localObject).huT;
        GMTrace.o(4547430842368L, 33881);
        return (String)localObject;
      }
    }
    GMTrace.o(4547430842368L, 33881);
    return null;
  }
  
  public final String CO()
  {
    GMTrace.i(4547565060096L, 33882);
    String str = bd(false).Di().huP;
    if (bf.mA(str)) {
      v.e("MicroMsg.BizInfo", "check father: %s, %s", new Object[] { this.field_username, str });
    }
    GMTrace.o(4547565060096L, 33882);
    return str;
  }
  
  /* Error */
  public final List<a> CP()
  {
    // Byte code:
    //   0: ldc2_w 434
    //   3: ldc_w 436
    //   6: invokestatic 58	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: getfield 438	com/tencent/mm/modelbiz/BizInfo:hub	Ljava/util/List;
    //   13: ifnull +19 -> 32
    //   16: aload_0
    //   17: getfield 438	com/tencent/mm/modelbiz/BizInfo:hub	Ljava/util/List;
    //   20: astore_2
    //   21: ldc2_w 434
    //   24: ldc_w 436
    //   27: invokestatic 210	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   30: aload_2
    //   31: areturn
    //   32: aload_0
    //   33: new 440	java/util/LinkedList
    //   36: dup
    //   37: invokespecial 441	java/util/LinkedList:<init>	()V
    //   40: putfield 438	com/tencent/mm/modelbiz/BizInfo:hub	Ljava/util/List;
    //   43: aload_0
    //   44: getfield 444	com/tencent/mm/modelbiz/BizInfo:field_brandInfo	Ljava/lang/String;
    //   47: ifnull +13 -> 60
    //   50: aload_0
    //   51: getfield 444	com/tencent/mm/modelbiz/BizInfo:field_brandInfo	Ljava/lang/String;
    //   54: invokevirtual 447	java/lang/String:length	()I
    //   57: ifne +19 -> 76
    //   60: aload_0
    //   61: getfield 438	com/tencent/mm/modelbiz/BizInfo:hub	Ljava/util/List;
    //   64: astore_2
    //   65: ldc2_w 434
    //   68: ldc_w 436
    //   71: invokestatic 210	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   74: aload_2
    //   75: areturn
    //   76: new 283	org/json/JSONObject
    //   79: dup
    //   80: aload_0
    //   81: getfield 444	com/tencent/mm/modelbiz/BizInfo:field_brandInfo	Ljava/lang/String;
    //   84: invokespecial 450	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   87: ldc_w 452
    //   90: invokevirtual 456	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   93: astore_2
    //   94: iconst_0
    //   95: istore_1
    //   96: iload_1
    //   97: aload_2
    //   98: invokevirtual 459	org/json/JSONArray:length	()I
    //   101: if_icmpge +105 -> 206
    //   104: new 34	com/tencent/mm/modelbiz/BizInfo$a
    //   107: dup
    //   108: invokespecial 460	com/tencent/mm/modelbiz/BizInfo$a:<init>	()V
    //   111: astore_3
    //   112: aload_2
    //   113: iload_1
    //   114: invokevirtual 464	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   117: astore 4
    //   119: aload_3
    //   120: aload 4
    //   122: ldc_w 466
    //   125: invokevirtual 470	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   128: putfield 472	com/tencent/mm/modelbiz/BizInfo$a:title	Ljava/lang/String;
    //   131: aload_3
    //   132: aload 4
    //   134: ldc_w 474
    //   137: invokevirtual 470	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   140: putfield 476	com/tencent/mm/modelbiz/BizInfo$a:url	Ljava/lang/String;
    //   143: aload_3
    //   144: aload 4
    //   146: ldc_w 478
    //   149: invokevirtual 470	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   152: putfield 481	com/tencent/mm/modelbiz/BizInfo$a:huf	Ljava/lang/String;
    //   155: aload_3
    //   156: aload 4
    //   158: ldc_w 483
    //   161: invokevirtual 470	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   164: putfield 485	com/tencent/mm/modelbiz/BizInfo$a:description	Ljava/lang/String;
    //   167: aload_0
    //   168: getfield 438	com/tencent/mm/modelbiz/BizInfo:hub	Ljava/util/List;
    //   171: aload_3
    //   172: invokeinterface 491 2 0
    //   177: pop
    //   178: iload_1
    //   179: iconst_1
    //   180: iadd
    //   181: istore_1
    //   182: goto -86 -> 96
    //   185: astore_2
    //   186: ldc_w 311
    //   189: ldc_w 493
    //   192: iconst_1
    //   193: anewarray 315	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_2
    //   199: invokestatic 497	com/tencent/mm/sdk/platformtools/bf:g	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   202: aastore
    //   203: invokestatic 429	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload_0
    //   207: getfield 438	com/tencent/mm/modelbiz/BizInfo:hub	Ljava/util/List;
    //   210: astore_2
    //   211: ldc2_w 434
    //   214: ldc_w 436
    //   217: invokestatic 210	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   220: aload_2
    //   221: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	BizInfo
    //   95	87	1	i	int
    //   20	93	2	localObject	Object
    //   185	14	2	localException	Exception
    //   210	11	2	localList	List
    //   111	61	3	locala	a
    //   117	40	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   76	94	185	java/lang/Exception
    //   96	178	185	java/lang/Exception
  }
  
  public final boolean Cz()
  {
    GMTrace.i(4545686011904L, 33868);
    if ((this.field_brandFlag & 0x1) == 0)
    {
      GMTrace.o(4545686011904L, 33868);
      return true;
    }
    GMTrace.o(4545686011904L, 33868);
    return false;
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4547699277824L, 33883);
    super.b(paramCursor);
    GMTrace.o(4547699277824L, 33883);
  }
  
  public final ExtInfo bd(boolean paramBoolean)
  {
    GMTrace.i(4545551794176L, 33867);
    if ((this.huc == null) || (paramBoolean))
    {
      System.currentTimeMillis();
      if ((bf.mA(this.field_extInfo)) || (hud != this.field_extInfo.hashCode())) {
        break label70;
      }
      this.huc = hue;
    }
    for (;;)
    {
      ExtInfo localExtInfo = this.huc;
      GMTrace.o(4545551794176L, 33867);
      return localExtInfo;
      label70:
      localExtInfo = ExtInfo.hH(this.field_extInfo);
      this.huc = localExtInfo;
      hue = localExtInfo;
      hud = bf.mz(this.field_extInfo).hashCode();
    }
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4547833495552L, 33884);
    ContentValues localContentValues = super.pv();
    GMTrace.o(4547833495552L, 33884);
    return localContentValues;
  }
  
  protected final c.a sY()
  {
    GMTrace.i(4545417576448L, 33866);
    c.a locala = gTF;
    GMTrace.o(4545417576448L, 33866);
    return locala;
  }
  
  public static final class ExtInfo
  {
    private int huA;
    private int huB;
    private String huC;
    private boolean huD;
    public int huE;
    private f huF;
    private String huG;
    private String huH;
    private boolean huI;
    private List<WxaEntryInfo> huJ;
    public JSONObject hug;
    private boolean huh;
    public boolean hui;
    public boolean huj;
    public boolean huk;
    private String hul;
    private String hum;
    private List<e> hun;
    private c huo;
    private b hup;
    private d huq;
    public BizInfo.ExtInfo.b.a hur;
    private boolean hus;
    boolean hut;
    int huu;
    public boolean huv;
    public int huw;
    private int hux;
    private String huy;
    private a huz;
    
    private ExtInfo()
    {
      GMTrace.i(4534009069568L, 33781);
      this.hug = null;
      this.huh = true;
      this.hui = false;
      this.huj = false;
      this.huk = false;
      this.hun = null;
      this.huo = null;
      this.hup = null;
      this.huq = null;
      this.hur = null;
      this.hus = false;
      this.hut = false;
      this.huv = false;
      this.huw = 0;
      this.hux = 0;
      this.huz = null;
      this.huA = 0;
      this.huB = BizInfo.htZ;
      this.huD = false;
      this.huI = false;
      GMTrace.o(4534009069568L, 33781);
    }
    
    public static ExtInfo hH(String paramString)
    {
      GMTrace.i(4534143287296L, 33782);
      ExtInfo localExtInfo = new ExtInfo();
      if (bf.mA(paramString))
      {
        GMTrace.o(4534143287296L, 33782);
        return localExtInfo;
      }
      try
      {
        System.currentTimeMillis();
        localExtInfo.hug = new JSONObject(paramString);
        GMTrace.o(4534143287296L, 33782);
        return localExtInfo;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          v.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bf.g(paramString) });
        }
      }
    }
    
    public final boolean CD()
    {
      boolean bool = false;
      GMTrace.i(4533203763200L, 33775);
      if (this.hug != null)
      {
        if (bf.getInt(this.hug.optString("ReportLocationType"), 0) > 0) {
          bool = true;
        }
        this.hus = bool;
      }
      bool = this.hus;
      GMTrace.o(4533203763200L, 33775);
      return bool;
    }
    
    public final List<WxaEntryInfo> CQ()
    {
      GMTrace.i(4531458932736L, 33762);
      Object localObject1;
      if (this.huJ == null)
      {
        this.huJ = new LinkedList();
        if (this.hug != null)
        {
          localObject1 = this.hug.optString("BindWxaInfo");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          if (localObject1 == null) {
            break label230;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("wxaEntryInfo");
          if (localObject1 == null) {
            break label215;
          }
          int i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            break label215;
          }
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject2 != null)
          {
            String str1 = ((JSONObject)localObject2).optString("username");
            String str2 = ((JSONObject)localObject2).optString("title");
            String str3 = ((JSONObject)localObject2).optString("title_key");
            localObject2 = ((JSONObject)localObject2).optString("icon_url");
            if ((!TextUtils.isEmpty(str1)) && ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3))))
            {
              WxaEntryInfo localWxaEntryInfo = new WxaEntryInfo();
              localWxaEntryInfo.username = str1;
              localWxaEntryInfo.title = str2;
              localWxaEntryInfo.hvg = str3;
              localWxaEntryInfo.iconUrl = ((String)localObject2);
              this.huJ.add(localWxaEntryInfo);
            }
          }
          i += 1;
          continue;
          localList = null;
        }
        catch (JSONException localJSONException) {}
        continue;
        label215:
        List localList = this.huJ;
        GMTrace.o(4531458932736L, 33762);
        return localList;
        label230:
        localList = null;
      }
    }
    
    public final boolean CR()
    {
      GMTrace.i(4531593150464L, 33763);
      if ((this.hug != null) && (this.hug.optJSONObject("WifiBizInfo") != null) && (this.hug.optJSONObject("WifiBizInfo").optInt("IsWXWiFi") == 1)) {
        this.huI = true;
      }
      boolean bool = this.huI;
      GMTrace.o(4531593150464L, 33763);
      return bool;
    }
    
    public final boolean CS()
    {
      GMTrace.i(4531727368192L, 33764);
      if (this.hug != null) {
        this.huB = bf.getInt(this.hug.optString("NotifyManage"), BizInfo.htZ);
      }
      if (this.huB == BizInfo.htY)
      {
        GMTrace.o(4531727368192L, 33764);
        return true;
      }
      GMTrace.o(4531727368192L, 33764);
      return false;
    }
    
    public final String CT()
    {
      GMTrace.i(4531861585920L, 33765);
      if (this.hug != null) {
        this.hul = this.hug.optString("VerifyContactPromptTitle");
      }
      String str = this.hul;
      GMTrace.o(4531861585920L, 33765);
      return str;
    }
    
    public final String CU()
    {
      GMTrace.i(4531995803648L, 33766);
      if (this.hug != null) {
        this.huG = this.hug.optString("TrademarkUrl");
      }
      String str = this.huG;
      GMTrace.o(4531995803648L, 33766);
      return str;
    }
    
    public final String CV()
    {
      GMTrace.i(4532130021376L, 33767);
      if (this.hug != null) {
        this.huH = this.hug.optString("TrademarkName");
      }
      String str = this.huH;
      GMTrace.o(4532130021376L, 33767);
      return str;
    }
    
    public final String CW()
    {
      GMTrace.i(4532264239104L, 33768);
      if (this.hug != null) {
        this.hum = this.hug.optString("ConferenceContactExpireTime");
      }
      String str = this.hum;
      GMTrace.o(4532264239104L, 33768);
      return str;
    }
    
    public final List<e> CX()
    {
      GMTrace.i(4532398456832L, 33769);
      if ((this.hug != null) && (this.hun == null)) {
        this.hun = e.b(this.hug.optJSONArray("Privilege"));
      }
      List localList = this.hun;
      GMTrace.o(4532398456832L, 33769);
      return localList;
    }
    
    public final int CY()
    {
      GMTrace.i(4532532674560L, 33770);
      if (this.hug != null) {
        this.huA = this.hug.optInt("InteractiveMode");
      }
      int i = this.huA;
      GMTrace.o(4532532674560L, 33770);
      return i;
    }
    
    public final d CZ()
    {
      GMTrace.i(4532666892288L, 33771);
      if ((this.hug != null) && (this.huq == null)) {
        this.huq = d.hM(this.hug.optString("PayShowInfo"));
      }
      d locald = this.huq;
      GMTrace.o(4532666892288L, 33771);
      return locald;
    }
    
    public final a Da()
    {
      GMTrace.i(4532801110016L, 33772);
      if ((this.hug != null) && (this.huz == null))
      {
        localObject = this.hug.optString("HardwareBizInfo");
        if (localObject != null) {
          this.huz = a.hI((String)localObject);
        }
      }
      Object localObject = this.huz;
      GMTrace.o(4532801110016L, 33772);
      return (a)localObject;
    }
    
    public final c Db()
    {
      GMTrace.i(4532935327744L, 33773);
      if ((this.hug != null) && (this.huo == null)) {
        this.huo = c.hL(this.hug.optString("VerifySource"));
      }
      c localc = this.huo;
      GMTrace.o(4532935327744L, 33773);
      return localc;
    }
    
    public final f Dc()
    {
      GMTrace.i(4533069545472L, 33774);
      if ((this.hug != null) && (this.huF == null))
      {
        localObject = this.hug.optString("RegisterSource");
        if (localObject != null) {
          this.huF = f.hN((String)localObject);
        }
      }
      Object localObject = this.huF;
      GMTrace.o(4533069545472L, 33774);
      return (f)localObject;
    }
    
    public final boolean Dd()
    {
      boolean bool = true;
      GMTrace.i(4533337980928L, 33776);
      if (this.hug != null) {
        if (bf.getInt(this.hug.optString("IsTrademarkProtection"), 0) != 1) {
          break label57;
        }
      }
      for (;;)
      {
        this.huD = bool;
        bool = this.huD;
        GMTrace.o(4533337980928L, 33776);
        return bool;
        label57:
        bool = false;
      }
    }
    
    public final int De()
    {
      GMTrace.i(4533472198656L, 33777);
      if (this.hug != null) {
        this.hux = this.hug.optInt("ServiceType", 0);
      }
      int i = this.hux;
      GMTrace.o(4533472198656L, 33777);
      return i;
    }
    
    public final String Df()
    {
      GMTrace.i(4533606416384L, 33778);
      if (this.hug != null) {
        this.huy = this.hug.optString("SupportEmoticonLinkPrefix");
      }
      String str = this.huy;
      GMTrace.o(4533606416384L, 33778);
      return str;
    }
    
    public final b Dg()
    {
      GMTrace.i(4533740634112L, 33779);
      if ((this.hug != null) && (this.hup == null))
      {
        localObject = this.hug.optString("MMBizMenu");
        if (localObject != null) {
          this.hup = b.hJ((String)localObject);
        }
      }
      Object localObject = this.hup;
      GMTrace.o(4533740634112L, 33779);
      return (b)localObject;
    }
    
    public final String Dh()
    {
      GMTrace.i(4533874851840L, 33780);
      if (this.hug != null) {
        this.huC = this.hug.optString("ServicePhone");
      }
      String str = this.huC;
      GMTrace.o(4533874851840L, 33780);
      return str;
    }
    
    public final BizInfo.ExtInfo.b.a Di()
    {
      GMTrace.i(4534277505024L, 33783);
      if ((this.hug != null) && (this.hur == null))
      {
        localObject = this.hug.optString("EnterpriseBizInfo");
        if (localObject != null) {
          this.hur = BizInfo.ExtInfo.b.a.hK((String)localObject);
        }
      }
      Object localObject = this.hur;
      GMTrace.o(4534277505024L, 33783);
      return (BizInfo.ExtInfo.b.a)localObject;
    }
    
    public static class WxaEntryInfo
      implements Parcelable
    {
      public static final Parcelable.Creator<WxaEntryInfo> CREATOR;
      public String hvg;
      public String iconUrl;
      public String title;
      public String username;
      
      static
      {
        GMTrace.i(4584609153024L, 34158);
        CREATOR = new Parcelable.Creator() {};
        GMTrace.o(4584609153024L, 34158);
      }
      
      public WxaEntryInfo()
      {
        GMTrace.i(4584072282112L, 34154);
        GMTrace.o(4584072282112L, 34154);
      }
      
      protected WxaEntryInfo(Parcel paramParcel)
      {
        GMTrace.i(4584206499840L, 34155);
        this.username = paramParcel.readString();
        this.title = paramParcel.readString();
        this.hvg = paramParcel.readString();
        this.iconUrl = paramParcel.readString();
        GMTrace.o(4584206499840L, 34155);
      }
      
      public int describeContents()
      {
        GMTrace.i(4584474935296L, 34157);
        GMTrace.o(4584474935296L, 34157);
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        GMTrace.i(4584340717568L, 34156);
        paramParcel.writeString(this.username);
        paramParcel.writeString(this.title);
        paramParcel.writeString(this.hvg);
        paramParcel.writeString(this.iconUrl);
        GMTrace.o(4584340717568L, 34156);
      }
    }
    
    public static final class a
    {
      public int huK;
      public int huL;
      public int huM;
      
      public a()
      {
        GMTrace.i(4538438254592L, 33814);
        GMTrace.o(4538438254592L, 33814);
      }
      
      public static a hI(String paramString)
      {
        GMTrace.i(4538572472320L, 33815);
        v.i("MicroMsg.BizInfo", "HardwareBizInfo = " + paramString);
        a locala = new a();
        if ((paramString == null) || (paramString.length() <= 0))
        {
          GMTrace.o(4538572472320L, 33815);
          return locala;
        }
        try
        {
          paramString = new JSONObject(paramString);
          locala.huK = paramString.optInt("hardware_flag");
          locala.huL = paramString.optInt("connect_status_display_mode");
          locala.huM = paramString.optInt("special_internal_brand_type");
          GMTrace.o(4538572472320L, 33815);
          return locala;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            v.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bf.g(paramString) });
          }
        }
      }
      
      public final boolean Dj()
      {
        GMTrace.i(4538706690048L, 33816);
        if ((this.huK & 0x1) > 0)
        {
          GMTrace.o(4538706690048L, 33816);
          return true;
        }
        GMTrace.o(4538706690048L, 33816);
        return false;
      }
    }
    
    public static final class b
    {
      public int huN;
      public List<i> huO;
      public int type;
      
      public b()
      {
        GMTrace.i(4536559206400L, 33800);
        this.huO = null;
        GMTrace.o(4536559206400L, 33800);
      }
      
      public static b hJ(String paramString)
      {
        GMTrace.i(4536693424128L, 33801);
        v.i("MicroMsg.BizInfo", "MenuInfo = " + paramString);
        b localb = new b();
        if ((paramString == null) || (paramString.length() <= 0))
        {
          GMTrace.o(4536693424128L, 33801);
          return localb;
        }
        try
        {
          paramString = new JSONObject(paramString);
          localb.huN = paramString.optInt("update_time");
          localb.type = paramString.optInt("type", 0);
          localb.huO = i.c(paramString.optJSONArray("button_list"));
          GMTrace.o(4536693424128L, 33801);
          return localb;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            v.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bf.g(paramString) });
          }
        }
      }
      
      public static final class a
      {
        public long appid;
        public String huP;
        public String huQ;
        public int huR;
        public String huS;
        public String huT;
        
        public a()
        {
          GMTrace.i(4583803846656L, 34152);
          this.appid = 0L;
          GMTrace.o(4583803846656L, 34152);
        }
        
        public static a hK(String paramString)
        {
          GMTrace.i(4583938064384L, 34153);
          v.i("MicroMsg.BizInfo", "EnterpriseBizInfo = " + paramString);
          a locala = new a();
          if ((paramString == null) || (paramString.length() <= 0))
          {
            GMTrace.o(4583938064384L, 34153);
            return locala;
          }
          try
          {
            paramString = new JSONObject(paramString);
            locala.huP = paramString.optString("belong");
            locala.huQ = paramString.optString("freeze_wording");
            locala.huR = paramString.optInt("child_type");
            locala.huS = paramString.optString("home_url");
            paramString = paramString.optString("exattr");
            if (bf.mA(paramString)) {
              locala.huT = null;
            }
            for (;;)
            {
              GMTrace.o(4583938064384L, 34153);
              return locala;
              paramString = new JSONObject(paramString);
              locala.huT = paramString.optString("chat_extension_url");
              locala.appid = paramString.optLong("app_id");
            }
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              v.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bf.g(paramString) });
            }
          }
        }
      }
    }
    
    public static final class c
    {
      public int huU;
      public String huV;
      public String huW;
      public String huX;
      public String huY;
      
      public c()
      {
        GMTrace.i(4550383632384L, 33903);
        this.huU = 0;
        GMTrace.o(4550383632384L, 33903);
      }
      
      public static c hL(String paramString)
      {
        GMTrace.i(4550517850112L, 33904);
        if (bf.mA(paramString))
        {
          GMTrace.o(4550517850112L, 33904);
          return null;
        }
        v.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[] { paramString });
        c localc = new c();
        try
        {
          paramString = new JSONObject(paramString);
          localc.huU = paramString.optInt("Type");
          localc.huV = paramString.optString("Description");
          localc.huW = paramString.optString("Name");
          localc.huX = paramString.optString("IntroUrl");
          localc.huY = paramString.optString("VerifySubTitle");
          v.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[] { Integer.valueOf(localc.huU), localc.huV, localc.huW, localc.huX });
          GMTrace.o(4550517850112L, 33904);
          return localc;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            v.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bf.g(paramString) });
          }
        }
      }
    }
    
    public static final class d
    {
      public int huZ;
      public String hva;
      public List<String> hvb;
      public String hvc;
      
      public d()
      {
        GMTrace.i(4523808522240L, 33705);
        GMTrace.o(4523808522240L, 33705);
      }
      
      public static d hM(String paramString)
      {
        GMTrace.i(4523942739968L, 33706);
        if (bf.mA(paramString))
        {
          GMTrace.o(4523942739968L, 33706);
          return null;
        }
        try
        {
          d locald = new d();
          paramString = new JSONObject(paramString);
          locald.huZ = paramString.optInt("reputation_level", -1);
          locald.hva = paramString.optString("scope_of_business");
          locald.hvc = paramString.optString("guarantee_detail_h5_url");
          paramString = paramString.optJSONArray("guarantee_info");
          if (paramString != null)
          {
            int j = paramString.length();
            if (j > 0)
            {
              locald.hvb = new ArrayList();
              int i = 0;
              while (i < j)
              {
                String str = paramString.getString(i);
                if (!bf.mA(str)) {
                  locald.hvb.add(str);
                }
                i += 1;
              }
            }
          }
          GMTrace.o(4523942739968L, 33706);
          return locald;
        }
        catch (Exception paramString)
        {
          v.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bf.g(paramString) });
          GMTrace.o(4523942739968L, 33706);
        }
        return null;
      }
    }
    
    public static final class e
    {
      public String description;
      public String hvd;
      public String iconUrl;
      
      public e()
      {
        GMTrace.i(4545014923264L, 33863);
        GMTrace.o(4545014923264L, 33863);
      }
      
      public static List<e> b(JSONArray paramJSONArray)
      {
        GMTrace.i(4545149140992L, 33864);
        localLinkedList = new LinkedList();
        if (paramJSONArray == null)
        {
          GMTrace.o(4545149140992L, 33864);
          return localLinkedList;
        }
        try
        {
          int j = paramJSONArray.length();
          int i = 0;
          while (i < j)
          {
            e locale = new e();
            JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
            locale.iconUrl = localJSONObject.optString("icon");
            locale.description = localJSONObject.optString("description");
            locale.hvd = localJSONObject.optString("description_key");
            localLinkedList.add(locale);
            i += 1;
          }
          return localLinkedList;
        }
        catch (Exception paramJSONArray)
        {
          v.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bf.g(paramJSONArray) });
          GMTrace.o(4545149140992L, 33864);
        }
      }
    }
    
    public static final class f
    {
      public String hve;
      public String hvf;
      
      public f()
      {
        GMTrace.i(4539377778688L, 33821);
        GMTrace.o(4539377778688L, 33821);
      }
      
      public static f hN(String paramString)
      {
        GMTrace.i(4539511996416L, 33822);
        v.i("MicroMsg.BizInfo", "RegisterSource = %s", new Object[] { paramString });
        f localf = new f();
        if ((paramString == null) || (paramString.length() <= 0))
        {
          GMTrace.o(4539511996416L, 33822);
          return localf;
        }
        try
        {
          paramString = new JSONObject(paramString);
          localf.hve = paramString.optString("RegisterBody");
          localf.hvf = paramString.optString("IntroUrl");
          GMTrace.o(4539511996416L, 33822);
          return localf;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            v.e("MicroMsg.BizInfo", "exception in RegisterSource:%s", new Object[] { bf.g(paramString) });
          }
        }
      }
    }
  }
  
  public static final class a
  {
    public String description;
    public String huf;
    public String title;
    public String url;
    
    public a()
    {
      GMTrace.i(4523674304512L, 33704);
      GMTrace.o(4523674304512L, 33704);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/BizInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */