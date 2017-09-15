package com.tencent.mm.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public class bf
{
  private static bf hnq;
  public final SharedPreferences hgn;
  
  private bf()
  {
    GMTrace.i(13155753263104L, 98018);
    this.hgn = aa.getContext().getSharedPreferences(aa.bIN(), 0);
    GMTrace.o(13155753263104L, 98018);
  }
  
  public static bf zK()
  {
    GMTrace.i(13155887480832L, 98019);
    try
    {
      if (hnq == null) {
        hnq = new bf();
      }
      bf localbf = hnq;
      GMTrace.o(13155887480832L, 98019);
      return localbf;
    }
    finally {}
  }
  
  public static final class a
  {
    private int hnr;
    private int hns;
    private int hnt;
    private int id;
    
    public a()
    {
      GMTrace.i(13155082174464L, 98013);
      GMTrace.o(13155082174464L, 98013);
    }
    
    public final boolean commit()
    {
      GMTrace.i(13155619045376L, 98017);
      SharedPreferences.Editor localEditor = bf.zK().hgn.edit();
      if (this.id > 0)
      {
        localEditor.putInt("MicroMsg.RegStyleStoragestyle_id", this.id);
        if (this.hnr <= 0) {
          break label189;
        }
        localEditor.putInt("MicroMsg.RegStyleStoragenew_flow", this.hnr);
        label60:
        if (this.hns <= 0) {
          break label201;
        }
        localEditor.putInt("MicroMsg.RegStyleStoragehas_password", this.hns);
        label80:
        if (this.hnt <= 0) {
          break label213;
        }
        localEditor.putInt("MicroMsg.RegStyleStoragehas_AVATAR", this.hnt);
      }
      for (;;)
      {
        v.i("MicroMsg.RegStyleStorage", "id: " + this.id + " newFlow: " + this.hnr + "hasPassword:" + this.hns + "hasAvatar:" + this.hnt);
        boolean bool = localEditor.commit();
        GMTrace.o(13155619045376L, 98017);
        return bool;
        localEditor.remove("MicroMsg.RegStyleStoragestyle_id");
        break;
        label189:
        localEditor.remove("MicroMsg.RegStyleStoragenew_flow");
        break label60;
        label201:
        localEditor.remove("MicroMsg.RegStyleStoragehas_password");
        break label80;
        label213:
        localEditor.remove("MicroMsg.RegStyleStoragehas_AVATAR");
      }
    }
    
    public final a fi(int paramInt)
    {
      GMTrace.i(13155216392192L, 98014);
      this.hnr = paramInt;
      GMTrace.o(13155216392192L, 98014);
      return this;
    }
    
    public final a fj(int paramInt)
    {
      GMTrace.i(13155350609920L, 98015);
      this.hns = paramInt;
      GMTrace.o(13155350609920L, 98015);
      return this;
    }
    
    public final a fk(int paramInt)
    {
      GMTrace.i(13155484827648L, 98016);
      this.hnt = paramInt;
      GMTrace.o(13155484827648L, 98016);
      return this;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */