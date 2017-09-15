package com.tencent.mm.ab;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class d
  extends ab
{
  public d()
  {
    GMTrace.i(4497099194368L, 33506);
    GMTrace.o(4497099194368L, 33506);
  }
  
  public final boolean eX(int paramInt)
  {
    GMTrace.i(4497367629824L, 33508);
    if ((paramInt != 0) && (paramInt < 604176383))
    {
      GMTrace.o(4497367629824L, 33508);
      return true;
    }
    GMTrace.o(4497367629824L, 33508);
    return false;
  }
  
  public final String getTag()
  {
    GMTrace.i(4497501847552L, 33509);
    GMTrace.o(4497501847552L, 33509);
    return "MicroMsg.VerifyFlagDataTransfer";
  }
  
  public final void transfer(int paramInt)
  {
    GMTrace.i(4497233412096L, 33507);
    v.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if (!eX(paramInt))
    {
      v.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
      GMTrace.o(4497233412096L, 33507);
      return;
    }
    long l = System.currentTimeMillis();
    ap.yY();
    if (bf.f((Integer)c.vr().get(86017, null)) == 3)
    {
      v.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
      GMTrace.o(4497233412096L, 33507);
      return;
    }
    ap.yY();
    c.wO().eE("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
    ap.yY();
    Cursor localCursor = c.wR().c("@all.weixin.android", "", null);
    localCursor.moveToFirst();
    while (!localCursor.isAfterLast())
    {
      x localx = new x();
      localx.b(localCursor);
      ap.yY();
      c.wR().c(localx.field_username, localx);
      localCursor.moveToNext();
    }
    localCursor.close();
    v.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    ap.yY();
    c.vr().set(86017, Integer.valueOf(3));
    v.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - l) + " ms");
    GMTrace.o(4497233412096L, 33507);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ab/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */