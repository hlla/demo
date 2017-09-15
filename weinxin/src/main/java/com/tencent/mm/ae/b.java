package com.tencent.mm.ae;

import android.content.ContentValues;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;

public final class b
  extends j
{
  public static final String[] gUn;
  g hnp;
  
  static
  {
    GMTrace.i(4089077301248L, 30466);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
    GMTrace.o(4089077301248L, 30466);
  }
  
  public b(g paramg)
  {
    GMTrace.i(4088808865792L, 30464);
    this.hnp = paramg;
    GMTrace.o(4088808865792L, 30464);
  }
  
  public final boolean a(a parama)
  {
    GMTrace.i(15353165905920L, 114390);
    parama.fRM = -1;
    ContentValues localContentValues = new ContentValues();
    if ((parama.fRM & 0x1) != 0) {
      localContentValues.put("username", parama.getUsername());
    }
    if ((parama.fRM & 0x2) != 0) {
      localContentValues.put("inserttime", Long.valueOf(parama.hDk));
    }
    if ((parama.fRM & 0x4) != 0) {
      localContentValues.put("type", Integer.valueOf(parama.type));
    }
    if ((parama.fRM & 0x8) != 0) {
      localContentValues.put("lastgettime", Integer.valueOf(parama.hDl));
    }
    if ((parama.fRM & 0x10) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(parama.hnl));
    }
    if ((parama.fRM & 0x20) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(parama.hBg));
    }
    if ((parama.fRM & 0x40) != 0) {
      localContentValues.put("reserved3", parama.zJ());
    }
    if ((parama.fRM & 0x80) != 0) {
      localContentValues.put("reserved4", parama.Gq());
    }
    if ((int)this.hnp.replace("getcontactinfov2", "username", localContentValues) != -1)
    {
      Qq(parama.getUsername());
      GMTrace.o(15353165905920L, 114390);
      return true;
    }
    GMTrace.o(15353165905920L, 114390);
    return false;
  }
  
  public final boolean jm(String paramString)
  {
    GMTrace.i(4088943083520L, 30465);
    if (this.hnp.delete("getcontactinfov2", "username= ?", new String[] { paramString }) > 0)
    {
      Qq(paramString);
      GMTrace.o(4088943083520L, 30465);
      return true;
    }
    GMTrace.o(4088943083520L, 30465);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ae/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */