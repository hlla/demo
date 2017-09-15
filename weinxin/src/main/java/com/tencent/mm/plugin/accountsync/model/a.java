package com.tencent.mm.plugin.accountsync.model;

import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.iw;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a
  implements e
{
  public boolean hSG;
  public a.b hzN;
  public Set<String> irI;
  public com.tencent.mm.sdk.b.c irJ;
  public ad irK;
  
  public a()
  {
    GMTrace.i(7835496742912L, 58379);
    this.irI = Collections.synchronizedSet(new HashSet());
    this.hSG = false;
    this.irJ = new com.tencent.mm.sdk.b.c() {};
    this.irK = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(7831604428800L, 58350);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          GMTrace.o(7831604428800L, 58350);
          return;
          a.this.hSG = true;
          boolean bool = com.tencent.mm.modelfriend.a.a(a.this.hzN);
          if (!bool) {
            a.this.hSG = false;
          }
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
    };
    this.hzN = new a.b()
    {
      public final void bg(boolean paramAnonymousBoolean)
      {
        GMTrace.i(7834825654272L, 58374);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          GMTrace.o(7834825654272L, 58374);
          return;
        }
        if (m.Ft().size() > 0)
        {
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
          ap.vd().a(133, a.this);
          System.currentTimeMillis();
          localObject = new com.tencent.mm.modelfriend.aa(m.Ft(), m.Fs());
          ap.vd().a((k)localObject, 0);
          GMTrace.o(7834825654272L, 58374);
          return;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
        Object localObject = (String[])a.this.irI.toArray(new String[0]);
        a.this.irI.clear();
        ArrayList localArrayList = new ArrayList();
        int j = localObject.length;
        int i = 0;
        if (i < j)
        {
          String str = localObject[i];
          b localb = af.FZ().ja(str);
          if ((localb != null) && (!bf.mA(localb.EY())))
          {
            localArrayList.add(localb.EY());
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[] { localb.EY(), str });
          }
          for (;;)
          {
            i += 1;
            break;
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[] { str });
          }
        }
        ap.vd().a(32, a.this);
        if (localArrayList.size() == 0)
        {
          com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
          localObject = new com.tencent.mm.modelfriend.v();
          ap.vd().a((k)localObject, 0);
          GMTrace.o(7834825654272L, 58374);
          return;
        }
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[] { Integer.valueOf(localArrayList.size()) });
        localObject = new com.tencent.mm.modelfriend.v(localArrayList, null);
        ap.vd().a((k)localObject, 0);
        GMTrace.o(7834825654272L, 58374);
      }
    };
    com.tencent.mm.sdk.b.a.uql.b(this.irJ);
    GMTrace.o(7835496742912L, 58379);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(7835630960640L, 58380);
    if (paramk.getType() == 133)
    {
      ap.vd().b(133, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label143;
      }
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      this.hSG = false;
    }
    while (paramk.getType() == 32)
    {
      this.hSG = false;
      ap.vd().b(32, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
        GMTrace.o(7835630960640L, 58380);
        return;
        label143:
        ap.vd().a(32, this);
        paramString = (com.tencent.mm.modelfriend.aa)paramk;
        paramString = new com.tencent.mm.modelfriend.v(paramString.hBw, paramString.hBx);
        ap.vd().a(paramString, 0);
      }
      else
      {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
        d.be(com.tencent.mm.sdk.platformtools.aa.getContext());
      }
    }
    GMTrace.o(7835630960640L, 58380);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/accountsync/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */