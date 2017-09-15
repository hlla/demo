package com.tencent.mm.plugin.bbom;

import android.os.RemoteException;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.fo;
import com.tencent.mm.e.a.hw;
import com.tencent.mm.e.a.jo;
import com.tencent.mm.e.a.jo.a;
import com.tencent.mm.e.a.ol;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.qk.b;
import com.tencent.mm.e.a.rp;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.protocal.o.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.t;

public final class k
  implements com.tencent.mm.plugin.zero.a.c
{
  public k()
  {
    GMTrace.i(8025414828032L, 59794);
    GMTrace.o(8025414828032L, 59794);
  }
  
  public final void a(NotifyReceiver.NotifyService paramNotifyService, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    GMTrace.i(8025549045760L, 59795);
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(8025549045760L, 59795);
      return;
      v.d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
      paramNotifyService = new o.b();
      paramNotifyService.deviceID = p.rB();
      paramArrayOfByte2 = new t(paramNotifyService, 10);
      try
      {
        if (paramArrayOfByte2.a(10, paramArrayOfByte1, null)) {
          ap.vd().a(0, 0, "", new j(paramNotifyService));
        }
        GMTrace.o(8025549045760L, 59795);
        return;
      }
      catch (RemoteException paramNotifyService)
      {
        v.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", paramNotifyService, "", new Object[0]);
        GMTrace.o(8025549045760L, 59795);
        return;
      }
      NotifyReceiver.NotifyService.cT("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
      paramNotifyService = new qk();
      paramNotifyService.fXk.fXm = true;
      a.uql.m(paramNotifyService);
      paramNotifyService = paramNotifyService.fXl.fXo;
      if (!bf.mA(paramNotifyService))
      {
        v.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: " + paramNotifyService);
        paramNotifyService = new qk();
        paramNotifyService.fXk.fXn = true;
        a.uql.m(paramNotifyService);
      }
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
      {
        if (paramArrayOfByte1[0] == 1)
        {
          v.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
          paramNotifyService = new rr();
          paramNotifyService.fYy.fJB = 3;
          paramNotifyService.fYy.fYs = paramArrayOfByte1;
          a.uql.m(paramNotifyService);
          GMTrace.o(8025549045760L, 59795);
          return;
        }
        if (paramArrayOfByte1[0] == 101)
        {
          v.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
          paramNotifyService = new hw();
          paramNotifyService.fNo.fNp = paramArrayOfByte1;
          a.uql.m(paramNotifyService);
          GMTrace.o(8025549045760L, 59795);
          return;
        }
        if (paramArrayOfByte1[0] == 3)
        {
          v.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
          paramNotifyService = new rr();
          paramNotifyService.fYy.fJB = 9;
          paramNotifyService.fYy.fYs = paramArrayOfByte1;
          a.uql.m(paramNotifyService);
          GMTrace.o(8025549045760L, 59795);
          return;
        }
        if (paramArrayOfByte1[0] == 2)
        {
          v.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
          paramNotifyService = new rr();
          paramNotifyService.fYy.fJB = 10;
          paramNotifyService.fYy.fYs = paramArrayOfByte1;
          a.uql.m(paramNotifyService);
          GMTrace.o(8025549045760L, 59795);
          return;
        }
        if (paramArrayOfByte1[0] == 102)
        {
          v.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
          paramNotifyService = new rp();
          paramNotifyService.fYr.fYs = paramArrayOfByte1;
          a.uql.m(paramNotifyService);
          GMTrace.o(8025549045760L, 59795);
          return;
          v.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
          paramNotifyService = new rr();
          paramNotifyService.fYy.fJB = 6;
          paramNotifyService.fYy.fYs = paramArrayOfByte1;
          a.uql.m(paramNotifyService);
          GMTrace.o(8025549045760L, 59795);
          return;
          v.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
          paramNotifyService = new fo();
          paramNotifyService.fKe.fKf = paramArrayOfByte1;
          a.uql.m(paramNotifyService);
          GMTrace.o(8025549045760L, 59795);
          return;
          NotifyReceiver.NotifyService.cT("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
          if (!bf.bm(paramArrayOfByte1))
          {
            paramNotifyService = new String(paramArrayOfByte1);
            paramArrayOfByte1 = new ah();
            paramArrayOfByte1.fDo.type = 4;
            paramArrayOfByte1.fDo.fDq = paramNotifyService;
            a.uql.m(paramArrayOfByte1);
            GMTrace.o(8025549045760L, 59795);
            return;
            v.i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
            if (paramArrayOfByte1.length >= 8)
            {
              paramNotifyService = new byte[4];
              paramArrayOfByte2 = new byte[4];
              System.arraycopy(paramArrayOfByte1, 0, paramNotifyService, 0, 4);
              System.arraycopy(paramArrayOfByte1, 4, paramArrayOfByte2, 0, 4);
              paramArrayOfByte1 = new jo();
              paramArrayOfByte1.fPP.fPQ = com.tencent.mm.a.n.c(paramNotifyService, 0);
              paramArrayOfByte1.fPP.fPR = com.tencent.mm.a.n.c(paramArrayOfByte2, 0);
              v.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", new Object[] { Integer.valueOf(paramArrayOfByte1.fPP.fPQ), Integer.valueOf(paramArrayOfByte1.fPP.fPR) });
              a.uql.m(paramArrayOfByte1);
            }
            GMTrace.o(8025549045760L, 59795);
            return;
            if (paramArrayOfByte1 == null)
            {
              paramInt = -1;
              v.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]", new Object[] { Integer.valueOf(paramInt) });
              com.tencent.mm.plugin.report.c.oRz.a(403L, 38L, 1L, false);
              if (paramArrayOfByte1 == null) {
                break label1102;
              }
            }
            label1102:
            for (paramNotifyService = new axi();; paramNotifyService = null)
            {
              try
              {
                paramNotifyService.aD(paramArrayOfByte1);
                v.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", new Object[] { Integer.valueOf(paramNotifyService.tYl), Integer.valueOf(paramNotifyService.tYm), Integer.valueOf(paramNotifyService.tYn), Integer.valueOf(paramNotifyService.tYo), Integer.valueOf(paramNotifyService.tYp), Integer.valueOf(paramNotifyService.tYq) });
                paramNotifyService = MMProtocalJni.decodeSecureNotifyData(paramArrayOfByte2, paramNotifyService.tYl, paramNotifyService.tYm, paramNotifyService.tYn, paramNotifyService.tYo, paramNotifyService.tYp, paramNotifyService.tYq, paramNotifyService.tYr, paramNotifyService.tsy.sWU);
                if (paramNotifyService == null) {
                  break label1107;
                }
                v.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", new Object[] { Integer.valueOf(paramNotifyService.length) });
                paramArrayOfByte1 = new ol();
                paramArrayOfByte1.fVv.data = paramNotifyService;
                a.uql.m(paramArrayOfByte1);
                GMTrace.o(8025549045760L, 59795);
                return;
              }
              catch (Exception paramNotifyService)
              {
                v.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + paramNotifyService.getMessage());
                com.tencent.mm.plugin.report.c.oRz.a(403L, 39L, 1L, false);
              }
              paramInt = paramArrayOfByte1.length;
              break;
            }
            label1107:
            v.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
            com.tencent.mm.plugin.report.c.oRz.a(403L, 40L, 1L, false);
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/bbom/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */