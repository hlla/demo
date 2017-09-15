package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.v;

public final class bc
  extends i<bb>
  implements g
{
  public static final String[] gUn;
  private e gUp;
  private final k<g.a, bb> uIK;
  
  static
  {
    GMTrace.i(13203803209728L, 98376);
    gUn = new String[] { i.a(bb.gTF, "Stranger") };
    GMTrace.o(13203803209728L, 98376);
  }
  
  public bc(e parame)
  {
    super(parame, bb.gTF, "Stranger", null);
    GMTrace.i(13203132121088L, 98371);
    this.uIK = new k() {};
    this.gUp = parame;
    GMTrace.o(13203132121088L, 98371);
  }
  
  private void b(bb parambb)
  {
    GMTrace.i(13202729467904L, 98368);
    if (this.uIK.by(parambb)) {
      this.uIK.doNotify();
    }
    GMTrace.o(13202729467904L, 98368);
  }
  
  public final bb AG(String paramString)
  {
    GMTrace.i(13203266338816L, 98372);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(13203266338816L, 98372);
      return null;
    }
    bb localbb = new bb();
    paramString = this.gUp.a("Stranger", null, "encryptUsername = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst()) {
      localbb.b(paramString);
    }
    paramString.close();
    GMTrace.o(13203266338816L, 98372);
    return localbb;
  }
  
  public final int AH(String paramString)
  {
    GMTrace.i(13203400556544L, 98373);
    int i = this.gUp.delete("Stranger", "(encryptUsername=?)", new String[] { paramString });
    if (i > 0) {
      doNotify();
    }
    v.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + paramString + " result:" + i);
    GMTrace.o(13203400556544L, 98373);
    return i;
  }
  
  public final void a(g.a parama)
  {
    GMTrace.i(13202863685632L, 98369);
    this.uIK.a(parama, null);
    GMTrace.o(13202863685632L, 98369);
  }
  
  public final void b(g.a parama)
  {
    GMTrace.i(13202997903360L, 98370);
    this.uIK.remove(parama);
    GMTrace.o(13202997903360L, 98370);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */