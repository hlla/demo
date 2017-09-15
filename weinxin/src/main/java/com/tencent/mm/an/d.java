package com.tencent.mm.an;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class d
  extends a
{
  public String fPK;
  public LinkedList<String> hMV;
  public String url;
  
  public d(Map<String, String> paramMap)
  {
    super(paramMap);
    GMTrace.i(315545878528L, 2351);
    this.hMV = new LinkedList();
    GMTrace.o(315545878528L, 2351);
  }
  
  protected final boolean HV()
  {
    GMTrace.i(315680096256L, 2352);
    if (this.values == null)
    {
      v.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
      GMTrace.o(315680096256L, 2352);
      return false;
    }
    v.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bf.mz(this.TYPE), Integer.valueOf(this.values.size()) });
    Object localObject1;
    int i;
    if ((!bf.mA(this.TYPE)) && (this.TYPE.equalsIgnoreCase("delchatroommember")))
    {
      this.url = bf.mz((String)this.values.get(".sysmsg.delchatroommember.url"));
      this.fPK = bf.mz((String)this.values.get(".sysmsg.delchatroommember.link.qrcode"));
      this.hMV.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
      localObject1 = this.values.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
          this.hMV.add(this.values.get(localObject2));
        }
      }
      localObject1 = new StringBuilder();
      Object localObject2 = this.values.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if (str.startsWith(hME))
        {
          if (((StringBuilder)localObject1).length() > 0) {
            ((StringBuilder)localObject1).insert(0, (String)this.values.get(str));
          } else {
            ((StringBuilder)localObject1).append((String)this.values.get(str));
          }
        }
        else
        {
          if (!str.startsWith(".sysmsg.delchatroommember.link.text")) {
            break label514;
          }
          ((StringBuilder)localObject1).append((String)this.values.get(str));
          this.hMI.add(this.values.get(str));
          i = ((String)this.values.get(str)).length();
        }
      }
    }
    label514:
    for (;;)
    {
      break;
      this.hMJ.addFirst(Integer.valueOf(((StringBuilder)localObject1).length() - i));
      this.hMK.add(Integer.valueOf(((StringBuilder)localObject1).length()));
      this.hMG = ((StringBuilder)localObject1).toString();
      v.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", new Object[] { this.url, this.fPK, Integer.valueOf(this.hMV.size()) });
      GMTrace.o(315680096256L, 2352);
      return true;
      v.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", new Object[] { bf.mz(this.TYPE) });
      GMTrace.o(315680096256L, 2352);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/an/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */