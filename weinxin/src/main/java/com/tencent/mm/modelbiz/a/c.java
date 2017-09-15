package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.u;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  extends u
{
  protected static c.a gTF;
  private Map<String, j> hwq;
  private List<String> hwr;
  
  static
  {
    GMTrace.i(4559242002432L, 33969);
    c.a locala = new c.a();
    locala.hXn = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bizChatLocalId";
    locala.uvr.put("bizChatLocalId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "bizChatLocalId";
    locala.columns[1] = "bizChatServId";
    locala.uvr.put("bizChatServId", "TEXT");
    localStringBuilder.append(" bizChatServId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandUserName";
    locala.uvr.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "chatType";
    locala.uvr.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "headImageUrl";
    locala.uvr.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "chatName";
    locala.uvr.put("chatName", "TEXT default '' ");
    localStringBuilder.append(" chatName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "chatNamePY";
    locala.uvr.put("chatNamePY", "TEXT default '' ");
    localStringBuilder.append(" chatNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "chatVersion";
    locala.uvr.put("chatVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" chatVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "needToUpdate";
    locala.uvr.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "bitFlag";
    locala.uvr.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "maxMemberCnt";
    locala.uvr.put("maxMemberCnt", "INTEGER default '0' ");
    localStringBuilder.append(" maxMemberCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "ownerUserId";
    locala.uvr.put("ownerUserId", "TEXT");
    localStringBuilder.append(" ownerUserId TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "userList";
    locala.uvr.put("userList", "TEXT");
    localStringBuilder.append(" userList TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "addMemberUrl";
    locala.uvr.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    locala.columns[14] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(4559242002432L, 33969);
  }
  
  public c()
  {
    GMTrace.i(4558168260608L, 33961);
    this.hwq = new HashMap();
    GMTrace.o(4558168260608L, 33961);
  }
  
  public final List<String> DU()
  {
    GMTrace.i(4558570913792L, 33964);
    if (this.hwr != null)
    {
      localObject = this.hwr;
      GMTrace.o(4558570913792L, 33964);
      return (List<String>)localObject;
    }
    Object localObject = this.field_userList;
    if (bf.mA((String)localObject))
    {
      localObject = new LinkedList();
      GMTrace.o(4558570913792L, 33964);
      return (List<String>)localObject;
    }
    this.hwr = bf.f(((String)localObject).split(";"));
    localObject = this.hwr;
    GMTrace.o(4558570913792L, 33964);
    return (List<String>)localObject;
  }
  
  public final boolean DV()
  {
    GMTrace.i(4558973566976L, 33967);
    if (this.field_bizChatServId == null)
    {
      GMTrace.o(4558973566976L, 33967);
      return false;
    }
    boolean bool = this.field_bizChatServId.endsWith("@qy_g");
    GMTrace.o(4558973566976L, 33967);
    return bool;
  }
  
  public final boolean DW()
  {
    GMTrace.i(4559107784704L, 33968);
    if (this.field_needToUpdate)
    {
      GMTrace.o(4559107784704L, 33968);
      return true;
    }
    if ((DV()) && (bf.mA(this.field_userList)))
    {
      GMTrace.o(4559107784704L, 33968);
      return true;
    }
    if ((bf.mA(this.field_chatNamePY)) && (!bf.mA(this.field_chatName)))
    {
      GMTrace.o(4559107784704L, 33968);
      return true;
    }
    GMTrace.o(4559107784704L, 33968);
    return false;
  }
  
  public final String eK(String paramString)
  {
    GMTrace.i(4558705131520L, 33965);
    paramString = iq(paramString);
    if (paramString == null)
    {
      GMTrace.o(4558705131520L, 33965);
      return "";
    }
    paramString = bf.ap(paramString.field_userName, "");
    GMTrace.o(4558705131520L, 33965);
    return paramString;
  }
  
  public final boolean fu(int paramInt)
  {
    GMTrace.i(4558436696064L, 33963);
    if ((this.field_bitFlag & paramInt) != 0)
    {
      GMTrace.o(4558436696064L, 33963);
      return true;
    }
    GMTrace.o(4558436696064L, 33963);
    return false;
  }
  
  public final j iq(String paramString)
  {
    GMTrace.i(4558839349248L, 33966);
    if ((!this.hwq.containsKey(paramString)) || (this.hwq.get(paramString) == null))
    {
      long l = System.currentTimeMillis();
      j localj = w.DL().iE(paramString);
      if (localj != null) {
        this.hwq.put(localj.field_userId, localj);
      }
      v.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    }
    if (this.hwq.containsKey(paramString))
    {
      paramString = (j)this.hwq.get(paramString);
      GMTrace.o(4558839349248L, 33966);
      return paramString;
    }
    GMTrace.o(4558839349248L, 33966);
    return null;
  }
  
  protected final c.a sY()
  {
    GMTrace.i(4558302478336L, 33962);
    c.a locala = gTF;
    GMTrace.o(4558302478336L, 33962);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */