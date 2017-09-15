package com.tencent.mm.bc;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.protocal.c.ady;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class b
{
  public static void run()
  {
    GMTrace.i(13047171121152L, 97209);
    if ((!ap.zb()) || (ap.uP()))
    {
      GMTrace.o(13047171121152L, 97209);
      return;
    }
    long l3 = bf.Nz();
    ap.yY();
    long l2 = bf.a((Long)c.vr().get(331797, null), 0L);
    long l1 = l2;
    if (10013 == r.iiC)
    {
      l1 = l2;
      if (r.iiD != 0) {
        l1 = 0L;
      }
    }
    if (l1 < l3)
    {
      ap.yY();
      c.vr().set(331797, Long.valueOf(l3 + 432000L));
      try
      {
        ady localady = new ady();
        localady.tHM = "";
        Account[] arrayOfAccount = AccountManager.get(aa.getContext()).getAccountsByType("com.google");
        int j = arrayOfAccount.length;
        int i = 0;
        while (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          if (!bf.mA(localady.tHM)) {
            break;
          }
          v.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[] { localAccount.name });
          localady.tHM = localAccount.name;
          i += 1;
        }
        if ((10013 == r.iiC) && (r.iiD != 0)) {
          localady.tHM = "rssjbbk@gmail.com";
        }
        if (!bf.mA(localady.tHM))
        {
          ap.yY();
          c.wQ().b(new e.a(57, localady));
          GMTrace.o(13047171121152L, 97209);
          return;
        }
        v.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
        GMTrace.o(13047171121152L, 97209);
        return;
      }
      catch (Exception localException)
      {
        v.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", new Object[] { localException.getMessage() });
      }
    }
    GMTrace.o(13047171121152L, 97209);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bc/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */