package com.tencent.mm.modelfriend;

import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static final HashSet<b> hzP;
  private static final b hzQ;
  public static Thread thread;
  
  static
  {
    GMTrace.i(4420058218496L, 32932);
    thread = null;
    hzP = new HashSet();
    hzQ = new b()
    {
      public final void bg(boolean paramAnonymousBoolean)
      {
        GMTrace.i(4442606796800L, 33100);
        v.i("MicroMsg.AddrBookSyncHelper", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          GMTrace.o(4442606796800L, 33100);
          return;
        }
        System.currentTimeMillis();
        aa localaa = new aa(m.Ft(), m.Fs());
        ap.vd().a(localaa, 0);
        GMTrace.o(4442606796800L, 33100);
      }
    };
    GMTrace.o(4420058218496L, 32932);
  }
  
  public static boolean EM()
  {
    GMTrace.i(4419387129856L, 32927);
    boolean bool = a(hzQ);
    GMTrace.o(4419387129856L, 32927);
    return bool;
  }
  
  public static boolean EN()
  {
    GMTrace.i(4419655565312L, 32929);
    boolean bool = a.hzK;
    GMTrace.o(4419655565312L, 32929);
    return bool;
  }
  
  public static boolean a(b paramb)
  {
    GMTrace.i(4419521347584L, 32928);
    long l = Thread.currentThread().getId();
    boolean bool = m.Fp();
    if (!bool)
    {
      v.e("MicroMsg.AddrBookSyncHelper", "canSync:%b, skip", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(4419521347584L, 32928);
      return false;
    }
    ae.v(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(4422742573056L, 32952);
        if ((a.thread != null) && (a.thread.isAlive())) {}
        for (boolean bool = true;; bool = false)
        {
          v.i("MicroMsg.AddrBookSyncHelper", "syncAddrBook running:%b setSize:%d call:%d callback:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(a.hzP.size()), Long.valueOf(this.hzR), this.hzS });
          a.hzP.add(this.hzS);
          if (!bool) {
            break;
          }
          GMTrace.o(4422742573056L, 32952);
          return;
        }
        a.thread = e.d(new a.a(), "AddrBookSyncHelper_addrBookRead", 1);
        m.Fj();
        a.thread.start();
        GMTrace.o(4422742573056L, 32952);
      }
    });
    GMTrace.o(4419521347584L, 32928);
    return true;
  }
  
  private static final class a
    implements Runnable
  {
    public static boolean hzK;
    private static byte[] hzT;
    private static final ad hzZ;
    private List<String[]> hzU;
    private List<String[]> hzV;
    private List<b> hzW;
    private List<b> hzX;
    private bd hzY;
    
    static
    {
      GMTrace.i(4430795636736L, 33012);
      hzK = false;
      hzT = new byte[0];
      hzZ = new ad(Looper.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          GMTrace.i(4449854554112L, 33154);
          if (!ap.zb())
          {
            GMTrace.o(4449854554112L, 33154);
            return;
          }
          g.a locala = new g.a();
          int i = a.hzP.size();
          boolean bool = Boolean.parseBoolean(paramAnonymousMessage.obj.toString());
          paramAnonymousMessage = a.hzP.iterator();
          while (paramAnonymousMessage.hasNext()) {
            ((a.b)paramAnonymousMessage.next()).bg(bool);
          }
          a.hzP.clear();
          v.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[] { Integer.valueOf(i), Long.valueOf(locala.se()) });
          GMTrace.o(4449854554112L, 33154);
        }
      };
      GMTrace.o(4430795636736L, 33012);
    }
    
    public a()
    {
      GMTrace.i(4429990330368L, 33006);
      GMTrace.o(4429990330368L, 33006);
    }
    
    private static void EO()
    {
      GMTrace.i(4430392983552L, 33009);
      bd localbd = new bd("MicroMsg.AddrBookSyncHelper", "delete");
      ArrayList localArrayList = new ArrayList();
      List localList = com.tencent.mm.pluginsdk.a.dp(com.tencent.mm.sdk.platformtools.aa.getContext());
      Iterator localIterator = af.FZ().Fc().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String[])localIterator.next();
        String str = bf.mz(localObject[0]);
        localObject = bf.mz(localObject[1]);
        if ((!str.equals("")) && (!localList.contains(str))) {
          localArrayList.add(localObject);
        }
      }
      if (localArrayList.size() > 0)
      {
        af.FZ().A(localArrayList);
        m.C(localArrayList);
      }
      localbd.addSplit("end");
      localbd.dumpToLog();
      GMTrace.o(4430392983552L, 33009);
    }
    
    private static List<b> a(int paramInt, List<String[]> paramList)
    {
      GMTrace.i(4430527201280L, 33010);
      if (paramList == null)
      {
        v.e("MicroMsg.AddrBookSyncHelper", "sync address book failed, null info list");
        paramList = new LinkedList();
        GMTrace.o(4430527201280L, 33010);
        return paramList;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String[])localIterator.next();
        if (paramList != null)
        {
          String str1 = paramList[0];
          String str2 = paramList[1];
          String str3 = paramList[2];
          String str4 = paramList[3];
          long l = bf.PY(paramList[4]);
          if ((str3 != null) && (!str3.equals("")))
          {
            paramList = "";
            if (paramInt == 1) {
              paramList = g.n(str3.getBytes());
            }
            if (paramInt == 0)
            {
              paramList = com.tencent.mm.pluginsdk.a.Dg(str3);
              if (bf.mA(paramList)) {
                v.d("MicroMsg.AddrBookSyncHelper", "formatted mobile null, continue");
              } else {
                paramList = g.n(paramList.getBytes());
              }
            }
            else
            {
              b localb = new b();
              localb.gTO = str2;
              localb.hAc = com.tencent.mm.platformtools.c.mr(str2);
              localb.hAd = com.tencent.mm.platformtools.c.mq(str2);
              localb.hAa = str1;
              localb.hre = str4;
              localb.iZ(paramList);
              localb.hAD = l;
              localb.hAj = localb.sZ();
              if (paramInt == 1) {
                localb.gkk = str3;
              }
              if (paramInt == 0) {
                localb.hAg = str3;
              }
              localb.type = paramInt;
              localb.fRM = 1095798;
              localArrayList.add(localb);
            }
          }
        }
      }
      GMTrace.o(4430527201280L, 33010);
      return localArrayList;
    }
    
    private static List<b> a(List<b> paramList, int paramInt1, int paramInt2)
    {
      GMTrace.i(4430124548096L, 33007);
      LinkedList localLinkedList = new LinkedList();
      while (paramInt1 < paramInt2)
      {
        localLinkedList.add(paramList.get(paramInt1));
        paramInt1 += 1;
      }
      GMTrace.o(4430124548096L, 33007);
      return localLinkedList;
    }
    
    public final void run()
    {
      GMTrace.i(4430258765824L, 33008);
      synchronized (hzT)
      {
        this.hzY = new bd("MicroMsg.AddrBookSyncHelper", "sync addrBook");
        this.hzY.addSplit("sync begin");
        v.d("MicroMsg.AddrBookSyncHelper", "reading email info");
        this.hzU = com.tencent.mm.pluginsdk.a.jdMethod_do(com.tencent.mm.sdk.platformtools.aa.getContext());
        if (this.hzU != null) {
          v.i("MicroMsg.AddrBookSyncHelper", "sync address book email size: " + this.hzU.size());
        }
        this.hzX = a(1, this.hzU);
        v.d("MicroMsg.AddrBookSyncHelper", "reading mobile info");
        this.hzV = com.tencent.mm.pluginsdk.a.dm(com.tencent.mm.sdk.platformtools.aa.getContext());
        if (this.hzV != null) {
          v.i("MicroMsg.AddrBookSyncHelper", "sync address book mobile size: " + this.hzV.size());
        }
        this.hzW = a(0, this.hzV);
        v.d("MicroMsg.AddrBookSyncHelper", "reading done, begin sync to addr_upload");
        if ((this.hzU != null) && (this.hzX.size() > 0))
        {
          i = 0;
          if (i < this.hzX.size())
          {
            v.i("MicroMsg.AddrBookSyncHelper", "sync email index: " + i);
            if (i + 100 < this.hzX.size()) {}
            for (localObject1 = a(this.hzX, i, i + 100);; localObject1 = a(this.hzX, i, this.hzX.size()))
            {
              v.i("MicroMsg.AddrBookSyncHelper", "sync email listToSync size: " + ((List)localObject1).size());
              m.D((List)localObject1);
              i += 100;
              break;
            }
          }
        }
        if ((this.hzW == null) || (this.hzW.size() == 0))
        {
          v.i("MicroMsg.AddrBookSyncHelper", "mobile list null stop service");
          localObject1 = hzZ.obtainMessage();
          ((Message)localObject1).obj = Boolean.valueOf(false);
          hzZ.sendMessage((Message)localObject1);
          GMTrace.o(4430258765824L, 33008);
          return;
        }
        int i = 0;
        if (i < this.hzW.size())
        {
          v.i("MicroMsg.AddrBookSyncHelper", "sync mobile index: " + i);
          if (!ap.zb())
          {
            v.i("MicroMsg.AddrBookSyncHelper", "account not ready, stop sync");
            localObject1 = hzZ.obtainMessage();
            ((Message)localObject1).obj = Boolean.valueOf(false);
            hzZ.sendMessage((Message)localObject1);
            GMTrace.o(4430258765824L, 33008);
            return;
          }
          if (i + 100 < this.hzW.size()) {}
          for (localObject1 = a(this.hzW, i, i + 100);; localObject1 = a(this.hzW, i, this.hzW.size()))
          {
            v.i("MicroMsg.AddrBookSyncHelper", "sync mobile listToSync size: " + ((List)localObject1).size());
            m.D((List)localObject1);
            i += 100;
            break;
          }
        }
        v.i("MicroMsg.AddrBookSyncHelper", "sync ok");
        if (!ap.zb())
        {
          v.i("MicroMsg.AddrBookSyncHelper", "account not ready, exit");
          localObject1 = hzZ.obtainMessage();
          ((Message)localObject1).obj = Boolean.valueOf(false);
          hzZ.sendMessage((Message)localObject1);
          GMTrace.o(4430258765824L, 33008);
          return;
        }
        EO();
        System.currentTimeMillis();
        this.hzY.addSplit("sync ok");
        this.hzY.dumpToLog();
        Object localObject1 = hzZ.obtainMessage();
        ((Message)localObject1).obj = Boolean.valueOf(true);
        hzZ.sendMessage((Message)localObject1);
        GMTrace.o(4430258765824L, 33008);
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void bg(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */