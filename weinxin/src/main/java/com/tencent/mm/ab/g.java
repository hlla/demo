package com.tencent.mm.ab;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.av.f;
import com.tencent.mm.av.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import java.util.LinkedList;

public final class g
  extends ab
{
  public g()
  {
    GMTrace.i(4501394161664L, 33538);
    GMTrace.o(4501394161664L, 33538);
  }
  
  public final boolean eX(int paramInt)
  {
    GMTrace.i(4501528379392L, 33539);
    if ((paramInt != 0) && (paramInt < 604307701))
    {
      GMTrace.o(4501528379392L, 33539);
      return true;
    }
    GMTrace.o(4501528379392L, 33539);
    return false;
  }
  
  public final String getTag()
  {
    GMTrace.i(4501796814848L, 33541);
    GMTrace.o(4501796814848L, 33541);
    return "MicroMsg.FMessageDataTransfer";
  }
  
  public final void transfer(int paramInt)
  {
    GMTrace.i(4501662597120L, 33540);
    if ((paramInt != 0) && (paramInt < 604307701))
    {
      ap.yY();
      Object localObject1 = com.tencent.mm.u.c.wT().bn("fmessage", 20);
      if (localObject1 == null)
      {
        v.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
        GMTrace.o(4501662597120L, 33540);
        return;
      }
      l.Kz();
      v.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + localObject1.length);
      int i = localObject1.length;
      paramInt = 0;
      if (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if ((localObject2 == null) || (((ce)localObject2).field_msgId == 0L)) {
          v.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
        }
        Object localObject3;
        for (;;)
        {
          paramInt += 1;
          break;
          v.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + ((ce)localObject2).field_type);
          localObject3 = ((ce)localObject2).field_content;
          if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
            v.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + ((ce)localObject2).field_msgId);
          } else {
            switch (((ce)localObject2).field_type)
            {
            case 38: 
            case 39: 
            default: 
              v.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + ((ce)localObject2).field_type);
              break;
            case 40: 
              v.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + ((ce)localObject2).field_content);
              localObject3 = au.a.RE(((ce)localObject2).field_content);
              localf = new f();
              localf.field_createTime = ((ce)localObject2).field_createTime;
              localf.field_isSend = 0;
              localf.field_msgContent = ((ce)localObject2).field_content;
              localf.field_svrId = ((ce)localObject2).field_msgSvrId;
              localf.field_talker = ((au.a)localObject3).rTh;
              localf.field_type = 0;
              l.Ky().a(localf);
              break;
            case 37: 
              v.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + ((ce)localObject2).field_content);
              localObject3 = au.d.RH(((ce)localObject2).field_content);
              if ((u.mA(((au.d)localObject3).rTh)) || ((((au.d)localObject3).scene != 18) && (!ay.fc(((au.d)localObject3).scene)))) {
                break label463;
              }
              v.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + ((au.d)localObject3).scene);
            }
          }
        }
        label463:
        f localf = new f();
        localf.field_createTime = ((ce)localObject2).field_createTime;
        localf.field_isSend = 0;
        localf.field_msgContent = ((ce)localObject2).field_content;
        localf.field_svrId = ((ce)localObject2).field_msgSvrId;
        localf.field_talker = ((au.d)localObject3).rTh;
        switch (((au.d)localObject3).fJB)
        {
        case 3: 
        case 4: 
        default: 
          localf.field_type = 1;
        }
        for (;;)
        {
          l.Ky().a(localf);
          break;
          localf.field_type = 1;
          continue;
          localf.field_type = 2;
          continue;
          localf.field_type = 3;
        }
      }
      ap.yY();
      com.tencent.mm.u.c.vr().set(143618, Integer.valueOf(0));
      l.Kz().Km();
      v.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
      ap.yY();
      com.tencent.mm.u.c.wR().Rh("fmessage");
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add("fmessage");
      ap.yY();
      com.tencent.mm.u.c.wW().aw((LinkedList)localObject1);
    }
    GMTrace.o(4501662597120L, 33540);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ab/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */