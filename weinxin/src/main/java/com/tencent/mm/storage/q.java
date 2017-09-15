package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ae;
import com.tencent.mm.g.a.a.a;
import com.tencent.mm.g.a.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class q
  extends ae
{
  protected static c.a gTF;
  public Map<String, b> hwq;
  private a uxj;
  public a uxk;
  private List<String> uxl;
  
  static
  {
    GMTrace.i(1588869464064L, 11838);
    c.a locala = new c.a();
    locala.hXn = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "chatroomname";
    locala.uvr.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "chatroomname";
    locala.columns[1] = "addtime";
    locala.uvr.put("addtime", "LONG");
    localStringBuilder.append(" addtime LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "memberlist";
    locala.uvr.put("memberlist", "TEXT");
    localStringBuilder.append(" memberlist TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "displayname";
    locala.uvr.put("displayname", "TEXT");
    localStringBuilder.append(" displayname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "chatroomnick";
    locala.uvr.put("chatroomnick", "TEXT");
    localStringBuilder.append(" chatroomnick TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "roomflag";
    locala.uvr.put("roomflag", "INTEGER");
    localStringBuilder.append(" roomflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "roomowner";
    locala.uvr.put("roomowner", "TEXT");
    localStringBuilder.append(" roomowner TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "roomdata";
    locala.uvr.put("roomdata", "BLOB");
    localStringBuilder.append(" roomdata BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "isShowname";
    locala.uvr.put("isShowname", "INTEGER");
    localStringBuilder.append(" isShowname INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "selfDisplayName";
    locala.uvr.put("selfDisplayName", "TEXT");
    localStringBuilder.append(" selfDisplayName TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "style";
    locala.uvr.put("style", "INTEGER");
    localStringBuilder.append(" style INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "chatroomdataflag";
    locala.uvr.put("chatroomdataflag", "INTEGER");
    localStringBuilder.append(" chatroomdataflag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "modifytime";
    locala.uvr.put("modifytime", "LONG");
    localStringBuilder.append(" modifytime LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "chatroomnotice";
    locala.uvr.put("chatroomnotice", "TEXT");
    localStringBuilder.append(" chatroomnotice TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "chatroomVersion";
    locala.uvr.put("chatroomVersion", "INTEGER");
    localStringBuilder.append(" chatroomVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "chatroomnoticeEditor";
    locala.uvr.put("chatroomnoticeEditor", "TEXT");
    localStringBuilder.append(" chatroomnoticeEditor TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomnoticePublishTime";
    locala.uvr.put("chatroomnoticePublishTime", "LONG");
    localStringBuilder.append(" chatroomnoticePublishTime LONG");
    localStringBuilder.append(", ");
    locala.columns[17] = "chatroomLocalVersion";
    locala.uvr.put("chatroomLocalVersion", "LONG");
    localStringBuilder.append(" chatroomLocalVersion LONG");
    locala.columns[18] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(1588869464064L, 11838);
  }
  
  public q()
  {
    GMTrace.i(1585648238592L, 11814);
    this.uxj = new a();
    this.uxk = this.uxj;
    this.uxl = new LinkedList();
    this.hwq = new HashMap();
    GMTrace.o(1585648238592L, 11814);
  }
  
  private static int FM(String paramString)
  {
    int j = 0;
    GMTrace.i(1587929939968L, 11831);
    try
    {
      i = bf.getInt(paramString, 0);
      GMTrace.o(1587929939968L, 11831);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
        if (paramString != null)
        {
          v.e("MicroMsg.ChatRoomMember", "parserInt error " + paramString);
          i = j;
        }
      }
    }
  }
  
  private static a QI(String paramString)
  {
    GMTrace.i(1588064157696L, 11832);
    a locala = new a();
    if (bf.mA(paramString))
    {
      GMTrace.o(1588064157696L, 11832);
      return locala;
    }
    int i = paramString.indexOf('<');
    String str1 = paramString;
    if (i > 0) {
      str1 = paramString.substring(i);
    }
    Map localMap = bg.q(str1, "RoomData");
    if (localMap == null)
    {
      v.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
      GMTrace.o(1588064157696L, 11832);
      return null;
    }
    i = 0;
    for (;;)
    {
      try
      {
        b localb = new b();
        if (i == 0)
        {
          paramString = ".RoomData.Member.$UserName";
          str2 = ".RoomData.Member.DisplayName";
          str1 = ".RoomData.Member.Flag";
          paramString = bf.ap((String)localMap.get(paramString), "");
          if (!bf.mA(paramString))
          {
            localb.userName = paramString;
            localb.gMN = bf.ap((String)localMap.get(str2), "");
            localb.gMO = FM((String)localMap.get(str1));
            locala.gMJ.add(localb);
            i += 1;
          }
        }
        else
        {
          if (i == 0) {
            break label389;
          }
          paramString = ".RoomData.Member" + i + ".$UserName";
          str2 = ".RoomData.Member" + i + ".DisplayName";
          str1 = ".RoomData.Member" + i + ".Flag";
          continue;
        }
        locala.type = FM((String)localMap.get(".RoomData.Type"));
        locala.status = FM((String)localMap.get(".RoomData.Status"));
        locala.gMK = FM((String)localMap.get(".RoomData.MaxCount"));
        locala.gML = bf.ap((String)localMap.get(".RoomData.ExtInfo.Upgrader"), "");
        GMTrace.o(1588064157696L, 11832);
        return locala;
      }
      catch (Exception paramString)
      {
        GMTrace.o(1588064157696L, 11832);
        return locala;
      }
      label389:
      str1 = null;
      String str2 = null;
      paramString = null;
    }
  }
  
  public static List<String> QJ(String paramString)
  {
    GMTrace.i(1588198375424L, 11833);
    LinkedList localLinkedList = new LinkedList();
    if (bf.mA(paramString))
    {
      GMTrace.o(1588198375424L, 11833);
      return localLinkedList;
    }
    paramString = paramString.split(";");
    int i = 0;
    while (i < paramString.length)
    {
      localLinkedList.add(paramString[i]);
      i += 1;
    }
    GMTrace.o(1588198375424L, 11833);
    return localLinkedList;
  }
  
  private void a(a parama)
  {
    GMTrace.i(1586050891776L, 11817);
    if (this.field_roomdata == null) {
      parama = new a();
    }
    parama = parama.gMJ.iterator();
    while (parama.hasNext())
    {
      b localb = (b)parama.next();
      this.hwq.put(localb.userName, localb);
    }
    GMTrace.o(1586050891776L, 11817);
  }
  
  public static boolean bKK()
  {
    GMTrace.i(1586856198144L, 11823);
    GMTrace.o(1586856198144L, 11823);
    return false;
  }
  
  public final List<String> DU()
  {
    GMTrace.i(1585916674048L, 11816);
    if ((this.uxl == null) || (this.uxl.size() == 0)) {
      this.uxl = QJ(this.field_memberlist);
    }
    List localList = this.uxl;
    GMTrace.o(1585916674048L, 11816);
    return localList;
  }
  
  public final b QH(String paramString)
  {
    GMTrace.i(1586453544960L, 11820);
    if (this.hwq.size() <= 0) {
      bKH();
    }
    if (this.hwq.containsKey(paramString))
    {
      paramString = (b)this.hwq.get(paramString);
      GMTrace.o(1586453544960L, 11820);
      return paramString;
    }
    GMTrace.o(1586453544960L, 11820);
    return null;
  }
  
  public final q a(String paramString, a parama, boolean paramBoolean)
  {
    GMTrace.i(1588601028608L, 11836);
    this.field_modifytime = System.currentTimeMillis();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = null;
      Iterator localIterator = parama.gMJ.iterator();
      if (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb.userName == null) || (!localb.userName.equals(paramString))) {
          break label232;
        }
        localObject = localb;
      }
    }
    label232:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        this.field_selfDisplayName = ((b)localObject).gMN;
        this.field_isShowname = (((b)localObject).gMO & 0x1);
      }
      for (int i = ((b)localObject).gMO;; i = 0)
      {
        v.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", new Object[] { this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i) });
        parama.fRM = (i & 0x2 | parama.fRM & 0xFFFFFFFD);
        this.field_chatroomdataflag = parama.fRM;
        try
        {
          this.field_roomdata = parama.toByteArray();
          this.uxk = parama;
          a(parama);
          GMTrace.o(1588601028608L, 11836);
          return this;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            v.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[] { bf.g(paramString) });
          }
        }
      }
    }
  }
  
  public final boolean b(a parama)
  {
    GMTrace.i(1586319327232L, 11819);
    if (this.uxj.aUd() == parama.aUd())
    {
      GMTrace.o(1586319327232L, 11819);
      return true;
    }
    GMTrace.o(1586319327232L, 11819);
    return false;
  }
  
  public final void bKH()
  {
    GMTrace.i(1586185109504L, 11818);
    if (bf.bm(this.field_roomdata))
    {
      GMTrace.o(1586185109504L, 11818);
      return;
    }
    try
    {
      this.uxk = ((a)new a().aD(this.field_roomdata));
      a(this.uxk);
      GMTrace.o(1586185109504L, 11818);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.uxk = new a();
      }
    }
  }
  
  public final int bKI()
  {
    GMTrace.i(1586587762688L, 11821);
    if (b(this.uxk)) {
      bKH();
    }
    int i = this.uxk.fPt;
    GMTrace.o(1586587762688L, 11821);
    return i;
  }
  
  public final boolean bKJ()
  {
    GMTrace.i(1586721980416L, 11822);
    if (b(this.uxk)) {
      bKH();
    }
    if (this.uxk.fPt < this.uxk.gMM)
    {
      GMTrace.o(1586721980416L, 11822);
      return true;
    }
    GMTrace.o(1586721980416L, 11822);
    return false;
  }
  
  public final int bKL()
  {
    GMTrace.i(1587124633600L, 11825);
    if (b(this.uxk)) {
      bKH();
    }
    int i = this.uxk.type;
    GMTrace.o(1587124633600L, 11825);
    return i;
  }
  
  public final int bKM()
  {
    GMTrace.i(1587258851328L, 11826);
    if (b(this.uxk)) {
      bKH();
    }
    int i = this.uxk.gMK;
    GMTrace.o(1587258851328L, 11826);
    return i;
  }
  
  public final boolean bKN()
  {
    GMTrace.i(1587795722240L, 11830);
    if (this.field_isShowname > 0)
    {
      GMTrace.o(1587795722240L, 11830);
      return true;
    }
    GMTrace.o(1587795722240L, 11830);
    return false;
  }
  
  public final a bKO()
  {
    GMTrace.i(1588735246336L, 11837);
    if (b(this.uxk)) {
      bKH();
    }
    a locala = this.uxk;
    GMTrace.o(1588735246336L, 11837);
    return locala;
  }
  
  public final q bX(List<String> paramList)
  {
    GMTrace.i(1588332593152L, 11834);
    Object localObject2;
    if ((paramList == null) || (paramList.size() == 0))
    {
      localObject2 = "";
      this.field_memberlist = ((String)localObject2);
      GMTrace.o(1588332593152L, 11834);
      return this;
    }
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= paramList.size()) {
        break;
      }
      localObject2 = (String)localObject1 + (String)paramList.get(i);
      localObject1 = localObject2;
      if (i < paramList.size() - 1) {
        localObject1 = (String)localObject2 + ";";
      }
      i += 1;
    }
  }
  
  public final void eA(int paramInt)
  {
    GMTrace.i(1586990415872L, 11824);
    this.field_chatroomdataflag = (this.uxk.fRM & 0xFFFFFFFD | paramInt & 0x2);
    GMTrace.o(1586990415872L, 11824);
  }
  
  public final q eJ(String paramString1, String paramString2)
  {
    GMTrace.i(1588466810880L, 11835);
    paramString1 = a(paramString1, QI(paramString2), false);
    GMTrace.o(1588466810880L, 11835);
    return paramString1;
  }
  
  public final String eK(String paramString)
  {
    GMTrace.i(1587527286784L, 11828);
    paramString = QH(paramString);
    if (paramString == null)
    {
      GMTrace.o(1587527286784L, 11828);
      return "";
    }
    paramString = bf.ap(paramString.gMN, "");
    GMTrace.o(1587527286784L, 11828);
    return paramString;
  }
  
  public final q jU(boolean paramBoolean)
  {
    GMTrace.i(1587661504512L, 11829);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.field_isShowname = i;
      GMTrace.o(1587661504512L, 11829);
      return this;
    }
  }
  
  protected final c.a sY()
  {
    GMTrace.i(1585782456320L, 11815);
    c.a locala = gTF;
    GMTrace.o(1585782456320L, 11815);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */