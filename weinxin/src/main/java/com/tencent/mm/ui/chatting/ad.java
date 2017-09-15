package com.tencent.mm.ui.chatting;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.j.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ad
{
  public static boolean a(En_5b8fbb1e.a parama, List<au> paramList, x paramx)
  {
    GMTrace.i(2212042375168L, 16481);
    if (parama == null)
    {
      v.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, context is null");
      GMTrace.o(2212042375168L, 16481);
      return false;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      v.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, select item empty");
      GMTrace.o(2212042375168L, 16481);
      return false;
    }
    if ((paramx == null) || ((int)paramx.gTG <= 0))
    {
      v.w("MicroMsg.ChattingEditModeSendToMail", "do send to mail fail, contact error");
      GMTrace.o(2212042375168L, 16481);
      return false;
    }
    boolean bool = b(parama, paramList, paramx);
    GMTrace.o(2212042375168L, 16481);
    return bool;
  }
  
  private static boolean b(En_5b8fbb1e.a parama, List<au> paramList, x paramx)
  {
    GMTrace.i(2212176592896L, 16482);
    String str;
    Object localObject2;
    label141:
    Object localObject3;
    if (!paramx.field_username.endsWith("@chatroom"))
    {
      str = parama.getString(R.l.eQU);
      localObject1 = paramx.tK();
      ap.yY();
      str = String.format(str, new Object[] { localObject1, com.tencent.mm.u.c.vr().get(4, null) });
      g.oSF.i(10811, new Object[] { Integer.valueOf(7), Integer.valueOf(paramList.size()) });
      if ((m.xW() & 0x1) != 0) {
        break label609;
      }
      v.d("MicroMsg.ChattingEditModeSendToMail", "use qq mail plugin to send mail");
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        break label492;
      }
      localObject3 = (au)localIterator.next();
      if (!((au)localObject3).bMb()) {
        break label366;
      }
      o.KW();
      ((List)localObject1).add(s.lw(((ce)localObject3).field_imgPath));
      ((List)localObject2).add(null);
    }
    for (;;)
    {
      v.i("MicroMsg.ChattingEditModeSendToMail", "file path = " + localObject1 + "file name = " + localObject2);
      break label141;
      if (bf.mA(paramx.field_nickname))
      {
        localObject1 = j.eA(paramx.field_username).iterator();
        for (str = ""; ((Iterator)localObject1).hasNext(); str = str + (String)localObject2 + ", ") {
          localObject2 = n.eK((String)((Iterator)localObject1).next());
        }
      }
      for (str = str.substring(0, str.length() - 2);; str = paramx.tK())
      {
        str = String.format(parama.getString(R.l.eQV), new Object[] { str });
        break;
      }
      label366:
      if (((au)localObject3).axH())
      {
        localObject3 = f.a.ek(((ce)localObject3).field_content);
        if (localObject3 == null) {
          break label141;
        }
        switch (((f.a)localObject3).type)
        {
        case 5: 
        default: 
          break;
        case 4: 
        case 6: 
          Object localObject4 = an.abF().LV(((f.a)localObject3).fCN);
          if (localObject4 == null) {
            break label141;
          }
          localObject4 = new File(((b)localObject4).field_fileFullPath);
          if (((File)localObject4).exists())
          {
            ((List)localObject1).add(((File)localObject4).getAbsolutePath());
            ((List)localObject2).add(((f.a)localObject3).title);
          }
          break;
        }
      }
    }
    label492:
    paramList = new QQMailHistoryExporter(parama.uRf.uRz, paramList, paramx).bWf();
    paramx = new Intent();
    paramx.putExtra("mail_mode", 6);
    paramx.putExtra("mail_content", paramList);
    paramx.putExtra("subject", str);
    paramx.putExtra("show_qqmail", true);
    paramx.putStringArrayListExtra("mail_attach", (ArrayList)localObject1);
    paramx.putStringArrayListExtra("mail_attach_title", (ArrayList)localObject2);
    d.a(parama, "qqmail", ".ui.ComposeUI", paramx, 220);
    GMTrace.o(2212176592896L, 16482);
    return false;
    label609:
    v.w("MicroMsg.ChattingEditModeSendToMail", "use order mail app to send mail");
    paramList = new ea(parama.uRf.uRz, paramList, paramx);
    Object localObject1 = paramList.bWf();
    paramx = new Intent("android.intent.action.SEND_MULTIPLE");
    paramx.setType("message/rfc822");
    paramx.putExtra("android.intent.extra.SUBJECT", str);
    paramx.putExtra("android.intent.extra.TEXT", (String)localObject1);
    boolean bool;
    if (paramList.maf == null) {
      bool = true;
    }
    for (;;)
    {
      v.d("MicroMsg.OtherMailHistoryExporter", "get image attach: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramList.vzr.size()) });
      if (paramList.maf != null)
      {
        paramList = paramList.vMd;
        paramx.putParcelableArrayListExtra("android.intent.extra.STREAM", paramList);
      }
      try
      {
        parama.startActivity(Intent.createChooser(paramx, parama.getString(R.l.eQT)));
        GMTrace.o(2212176592896L, 16482);
        return true;
        bool = false;
        continue;
        v.w("MicroMsg.OtherMailHistoryExporter", "had not exported, do export first");
        paramList.bWf();
        paramList = paramList.vMd;
      }
      catch (ActivityNotFoundException paramList)
      {
        for (;;)
        {
          Toast.makeText(parama.uRf.uRz, R.l.eQW, 0).show();
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */