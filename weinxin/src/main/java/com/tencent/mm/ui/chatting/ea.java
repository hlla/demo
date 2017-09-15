package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.e.a.ik.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class ea
{
  private Context context;
  private x fOB;
  private SimpleDateFormat jDt;
  String maf;
  private String vMc;
  ArrayList<Uri> vMd;
  List<au> vzr;
  
  public ea(Context paramContext, List<au> paramList, x paramx)
  {
    GMTrace.i(2364245278720L, 17615);
    this.vMc = null;
    this.fOB = null;
    this.jDt = new SimpleDateFormat("yyyy-MM-dd");
    this.maf = null;
    this.vMd = new ArrayList();
    this.context = paramContext;
    this.vzr = paramList;
    this.fOB = paramx;
    GMTrace.o(2364245278720L, 17615);
  }
  
  private String aL(au paramau)
  {
    GMTrace.i(2364647931904L, 17618);
    String str = null;
    if (!this.fOB.field_username.endsWith("@chatroom")) {
      str = n.eK(paramau.field_talker);
    }
    for (;;)
    {
      if (paramau.field_isSend == 1)
      {
        v.i("MicroMsg.OtherMailHistoryExporter", "isSend");
        str = m.xN();
      }
      long l = paramau.field_createTime;
      paramau = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(paramau);
      paramau = ((StringBuilder)localObject).toString();
      GMTrace.o(2364647931904L, 17618);
      return paramau;
      localObject = paramau.field_content;
      int i = ay.gh((String)localObject);
      if (i != -1) {
        str = n.eK(((String)localObject).substring(0, i).trim());
      }
    }
  }
  
  private String bWg()
  {
    GMTrace.i(2364513714176L, 17617);
    Object localObject;
    if (!this.fOB.field_username.endsWith("@chatroom"))
    {
      str1 = this.context.getString(R.l.eQR);
      localObject = this.fOB.tK();
      ap.yY();
      str1 = String.format(str1, new Object[] { localObject, com.tencent.mm.u.c.vr().get(4, null) });
      GMTrace.o(2364513714176L, 17617);
      return str1;
    }
    if (bf.mA(this.fOB.field_nickname))
    {
      localObject = j.eA(this.fOB.field_username).iterator();
      String str2;
      for (str1 = ""; ((Iterator)localObject).hasNext(); str1 = str1 + str2 + ", ") {
        str2 = n.eK((String)((Iterator)localObject).next());
      }
    }
    for (String str1 = str1.substring(0, str1.length() - 2);; str1 = this.fOB.tK())
    {
      str1 = String.format(this.context.getString(R.l.eQQ), new Object[] { str1 });
      break;
    }
  }
  
  private String eN(long paramLong)
  {
    GMTrace.i(2364782149632L, 17619);
    String str = this.jDt.format(new Date(paramLong));
    GMTrace.o(2364782149632L, 17619);
    return str;
  }
  
  public final String bWf()
  {
    GMTrace.i(2364379496448L, 17616);
    if (this.maf == null) {}
    Object localObject1;
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.OtherMailHistoryExporter", "export: history is null? %B, selectItems.size = %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.vzr.size()) });
      if (this.maf == null) {
        break;
      }
      localObject1 = this.maf;
      GMTrace.o(2364379496448L, 17616);
      return (String)localObject1;
    }
    this.vMd.clear();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(bWg());
    localStringBuilder.append("\n\n");
    Iterator localIterator = this.vzr.iterator();
    au localau;
    if (localIterator.hasNext())
    {
      localau = (au)localIterator.next();
      if (this.vMc == null)
      {
        this.vMc = eN(localau.field_createTime);
        localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.vMc }));
        localStringBuilder.append("\n");
        label201:
        if (!localau.bMa()) {
          break label438;
        }
        if (!localau.bMa()) {
          break label432;
        }
        if (localau.field_isSend != 1) {
          break label330;
        }
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aL(localau), localau.field_content });
      }
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = eN(localau.field_createTime);
      if (((String)localObject1).equals(this.vMc)) {
        break label201;
      }
      this.vMc = ((String)localObject1);
      localStringBuilder.append(String.format("—————  %s  —————\n\n", new Object[] { this.vMc }));
      localStringBuilder.append("\n");
      break label201;
      label330:
      if (!this.fOB.field_username.endsWith("@chatroom"))
      {
        localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aL(localau), localau.field_content });
      }
      else
      {
        int i = ay.gh(localau.field_content);
        if (i != -1)
        {
          localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aL(localau), localau.field_content.substring(i + 1).trim() });
          continue;
          label432:
          localObject1 = null;
          continue;
          label438:
          Object localObject2;
          if (localau.bLX())
          {
            if (localau.bLX())
            {
              long l1 = localau.field_msgId;
              long l2 = localau.field_msgSvrId;
              localObject2 = dq.eL(l1);
              localObject1 = localObject2;
              if (bf.mA((String)localObject2)) {
                localObject1 = dq.eM(l2);
              }
              v.d("MicroMsg.OtherMailHistoryExporter", "hdPath[%s]", new Object[] { localObject1 });
              if (!bf.mA((String)localObject1))
              {
                localObject2 = "file://" + (String)localObject1;
                this.vMd.add(Uri.parse((String)localObject2));
                localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(R.l.ebT), new File((String)localObject1).getName(), this.context.getString(R.l.ebP) });
              }
            }
            for (localObject1 = String.format("%s\n\n%s\n\n", new Object[] { aL(localau), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          if (localau.bLP()) {
            localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.ebY) });
          }
          for (;;)
          {
            v.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
            localStringBuilder.append(String.format("%s\n\n%s\n\n", new Object[] { aL(localau), localObject1 }));
            break;
            if (localau.bLT())
            {
              if (localau.field_isSend == 1) {
                localObject1 = this.context.getString(R.l.ebW);
              } else {
                localObject1 = this.context.getString(R.l.ebV);
              }
            }
            else if (localau.bLZ())
            {
              localObject1 = new ik();
              ((ik)localObject1).fNV.fNQ = 1;
              ((ik)localObject1).fNV.fCQ = localau;
              a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
              localObject1 = String.format("[%s]", new Object[] { ((ik)localObject1).fNW.fNY });
            }
            else
            {
              if (localau.axH())
              {
                localObject1 = f.a.ek(bf.PW(localau.field_content));
                if (localObject1 != null)
                {
                  switch (((f.a)localObject1).type)
                  {
                  }
                  for (;;)
                  {
                    localObject2 = g.aJ(((f.a)localObject1).appId, true);
                    if (localObject2 != null) {
                      break label983;
                    }
                    localObject1 = "";
                    break;
                    localObject2 = an.abF().LV(((f.a)localObject1).fCN);
                    if (localObject2 != null)
                    {
                      localObject2 = new File(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
                      if (((File)localObject2).exists()) {
                        this.vMd.add(Uri.fromFile((File)localObject2));
                      }
                    }
                  }
                  label983:
                  localObject2 = ((f)localObject2).field_appName;
                  if (6 == ((f.a)localObject1).type)
                  {
                    localObject1 = String.format("[%s: %s(%s)]", new Object[] { this.context.getString(R.l.ebO), localObject2, this.context.getString(R.l.ebP) });
                    continue;
                  }
                  localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.ebO), localObject2 });
                }
              }
              else
              {
                if (localau.bLY())
                {
                  ap.yY();
                  localObject1 = com.tencent.mm.u.c.wT().At(localau.field_content).fER;
                  localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.ebQ), localObject1 });
                  continue;
                }
                if (localau.bMb())
                {
                  localObject1 = this.context.getString(R.l.ebX);
                  o.KW();
                  localObject2 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new File(s.lw(localau.field_imgPath)).getName(), this.context.getString(R.l.ebP) });
                  o.KW();
                  File localFile = new File(s.lw(localau.field_imgPath));
                  localObject1 = localObject2;
                  if (!localFile.exists()) {
                    continue;
                  }
                  this.vMd.add(Uri.fromFile(localFile));
                  localObject1 = localObject2;
                  continue;
                }
                if ((localau.bMd()) || (localau.bMe()))
                {
                  localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.ebR) });
                  continue;
                  localStringBuilder.append("\n\n");
                  this.maf = localStringBuilder.toString();
                  localObject1 = this.maf;
                  GMTrace.o(2364379496448L, 17616);
                  return (String)localObject1;
                }
              }
              localObject1 = null;
            }
          }
        }
        else
        {
          localObject1 = null;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */