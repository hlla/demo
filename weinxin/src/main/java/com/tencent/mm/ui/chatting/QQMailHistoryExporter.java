package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.e.a.ik.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class QQMailHistoryExporter
{
  private static final char[] jmw;
  private static final String[] jmx;
  private static final String vMe;
  private Context context;
  private x fOB;
  private float haV;
  private String vMc;
  private List<au> vzr;
  
  static
  {
    GMTrace.i(2172448145408L, 16186);
    vMe = "<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + com.tencent.mm.pluginsdk.ui.tools.s.er("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>";
    jmw = new char[] { 60, 62, 34, 39, 38, 10 };
    jmx = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />" };
    GMTrace.o(2172448145408L, 16186);
  }
  
  public QQMailHistoryExporter(Context paramContext, List<au> paramList, x paramx)
  {
    GMTrace.i(2171777056768L, 16181);
    this.vMc = null;
    this.fOB = null;
    this.haV = 1.0F;
    this.context = paramContext;
    this.vzr = paramList;
    this.fOB = paramx;
    GMTrace.o(2171777056768L, 16181);
  }
  
  private static String PV(String paramString)
  {
    GMTrace.i(2171642839040L, 16180);
    if (paramString == null)
    {
      GMTrace.o(2171642839040L, 16180);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int n = paramString.length();
    int i = 0;
    if (i < n)
    {
      char c = paramString.charAt(i);
      int m = 1;
      int j = jmw.length - 1;
      for (;;)
      {
        int k = m;
        if (j >= 0)
        {
          if (jmw[j] == c)
          {
            localStringBuffer.append(jmx[j]);
            k = 0;
          }
        }
        else
        {
          if (k != 0) {
            localStringBuffer.append(c);
          }
          i += 1;
          break;
        }
        j -= 1;
      }
    }
    paramString = localStringBuffer.toString();
    GMTrace.o(2171642839040L, 16180);
    return paramString;
  }
  
  private String aL(au paramau)
  {
    GMTrace.i(2172179709952L, 16184);
    String str = null;
    if (!this.fOB.field_username.endsWith("@chatroom")) {
      str = n.eK(paramau.field_talker);
    }
    for (;;)
    {
      if (paramau.field_isSend == 1)
      {
        v.i("MicroMsg.QQMailHistoryExporter", "isSend");
        str = m.xN();
      }
      long l = paramau.field_createTime;
      paramau = new SimpleDateFormat("HH:mm").format(new Date(l));
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(paramau);
      paramau = ((StringBuilder)localObject).toString();
      GMTrace.o(2172179709952L, 16184);
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
    GMTrace.i(2172045492224L, 16183);
    Object localObject;
    if (!this.fOB.field_username.endsWith("@chatroom"))
    {
      str1 = this.context.getString(R.l.eQR);
      localObject = this.fOB.tK();
      ap.yY();
      str1 = String.format(str1, new Object[] { localObject, com.tencent.mm.u.c.vr().get(4, null) });
      GMTrace.o(2172045492224L, 16183);
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
  
  private static String eN(long paramLong)
  {
    GMTrace.i(2172313927680L, 16185);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
    GMTrace.o(2172313927680L, 16185);
    return str;
  }
  
  public final String bWf()
  {
    GMTrace.i(2171911274496L, 16182);
    v.i("MicroMsg.QQMailHistoryExporter", "selectItems.size = %d", new Object[] { Integer.valueOf(this.vzr.size()) });
    if (com.tencent.mm.bg.a.dM(this.context)) {
      this.haV = com.tencent.mm.bg.a.dI(this.context);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<div id=\"history\">\n");
    localStringBuilder.append(String.format("<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>", new Object[] { Float.valueOf(this.haV), Float.valueOf(this.haV), bWg() }));
    Iterator localIterator = this.vzr.iterator();
    au localau;
    label203:
    Object localObject1;
    if (localIterator.hasNext())
    {
      localau = (au)localIterator.next();
      if (this.vMc == null)
      {
        this.vMc = eN(localau.field_createTime);
        localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.haV), this.vMc }));
        if (!localau.bMa()) {
          break label518;
        }
        if (!localau.bMa()) {
          break label512;
        }
        if (localau.field_isSend != 1) {
          break label364;
        }
        localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.haV), aL(localau), Float.valueOf(this.haV), PV(localau.field_content) });
      }
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject1);
      break;
      localObject1 = eN(localau.field_createTime);
      if (((String)localObject1).equals(this.vMc)) {
        break label203;
      }
      this.vMc = ((String)localObject1);
      localStringBuilder.append("<br>");
      localStringBuilder.append(String.format("<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n", new Object[] { Float.valueOf(this.haV), this.vMc }));
      break label203;
      label364:
      if (!this.fOB.field_username.endsWith("@chatroom"))
      {
        localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.haV), aL(localau), Float.valueOf(this.haV), PV(localau.field_content) });
      }
      else
      {
        int i = ay.gh(localau.field_content);
        if (i != -1)
        {
          localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.haV), aL(localau), Float.valueOf(this.haV), PV(localau.field_content.substring(i + 1).trim()) });
          continue;
          label512:
          localObject1 = null;
          continue;
          label518:
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
              v.d("MicroMsg.QQMailHistoryExporter", "hdPath[%s]", new Object[] { localObject1 });
              if (!bf.mA((String)localObject1))
              {
                localObject2 = "file://" + (String)localObject1;
                localObject1 = String.format(vMe, new Object[] { Long.valueOf(localau.field_msgId), Long.valueOf(localau.field_msgSvrId), localObject2, localObject1 });
              }
            }
            for (localObject1 = String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.haV), aL(localau), Float.valueOf(this.haV), localObject1 });; localObject1 = null)
            {
              localStringBuilder.append((String)localObject1);
              break;
            }
          }
          localObject1 = null;
          if (localau.bLP()) {
            localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.ebY) });
          }
          for (;;)
          {
            v.d("MicroMsg.QQMailHistoryExporter", "formatOtherMsg, msgStr = %s", new Object[] { localObject1 });
            localStringBuilder.append(String.format("<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n", new Object[] { Float.valueOf(this.haV), aL(localau), Float.valueOf(this.haV), localObject1 }));
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
              com.tencent.mm.sdk.b.a.uql.m((b)localObject1);
              localObject1 = String.format("[%s]", new Object[] { ((ik)localObject1).fNW.fNY });
            }
            else
            {
              if (localau.axH())
              {
                localObject2 = localau.field_content;
                localObject1 = localObject2;
                if (this.fOB.field_username.endsWith("@chatroom"))
                {
                  v.d("MicroMsg.QQMailHistoryExporter", "chatroom msg, parse it");
                  i = ay.gh(localau.field_content);
                  localObject1 = localObject2;
                  if (i != -1) {
                    localObject1 = PV(localau.field_content.substring(i + 1).trim());
                  }
                }
                localObject2 = f.a.ek(bf.PW((String)localObject1));
                if (localObject2 == null)
                {
                  v.w("MicroMsg.QQMailHistoryExporter", "appmsg content is null");
                  localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.ebO) });
                  continue;
                }
                f localf = g.aJ(((f.a)localObject2).appId, true);
                if ((localf == null) || (bf.mA(localf.field_appName)))
                {
                  localObject1 = ((f.a)localObject2).appName;
                  label1112:
                  localObject1 = g.a(this.context, localf, (String)localObject1);
                  if (localau.field_type != 16777265) {
                    break label1170;
                  }
                  i = 1;
                }
                for (;;)
                {
                  if (i != 0)
                  {
                    if (bf.mA((String)localObject1))
                    {
                      localObject1 = ((f.a)localObject2).title;
                      break;
                      localObject1 = localf.field_appName;
                      break label1112;
                      label1170:
                      i = 0;
                      continue;
                    }
                    localObject1 = String.format("[%s: %s]", new Object[] { localObject1, ((f.a)localObject2).title });
                    break;
                  }
                }
                if (localau.bMf())
                {
                  localObject1 = dq.a(localau, (f.a)localObject2);
                  if (!bf.mA((String)localObject1))
                  {
                    localObject2 = "file://" + (String)localObject1;
                    localObject1 = String.format(vMe, new Object[] { Long.valueOf(localau.field_msgId), Long.valueOf(localau.field_msgSvrId), localObject2, localObject1 });
                  }
                }
                else
                {
                  switch (((f.a)localObject2).type)
                  {
                  case 7: 
                  default: 
                    localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.ebO) });
                    break;
                  case 3: 
                    if (bf.mA(((f.a)localObject2).description))
                    {
                      localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.ebU), ((f.a)localObject2).title });
                      continue;
                    }
                    localObject1 = String.format("[%s: %s-%s]", new Object[] { this.context.getString(R.l.ebU), ((f.a)localObject2).title, ((f.a)localObject2).description });
                    break;
                  case 8: 
                    localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.ebR) });
                    break;
                  case 6: 
                    if (bf.mA(((f.a)localObject2).description))
                    {
                      localObject1 = String.format("[%s: %s]", new Object[] { this.context.getString(R.l.ebS), ((f.a)localObject2).title });
                      continue;
                    }
                    localObject1 = String.format("[%s: %s-%s(%s)]", new Object[] { this.context.getString(R.l.ebS), ((f.a)localObject2).title, ((f.a)localObject2).description, this.context.getString(R.l.ebP) });
                    break;
                  case 2: 
                    localObject1 = dq.a(localau, (f.a)localObject2);
                    if (bf.mA((String)localObject1)) {
                      break label1973;
                    }
                    localObject2 = "file://" + (String)localObject1;
                    localObject1 = String.format(vMe, new Object[] { Long.valueOf(localau.field_msgId), Long.valueOf(localau.field_msgSvrId), localObject2, localObject1 });
                    break;
                  case 1: 
                    if (bf.mA((String)localObject1))
                    {
                      localObject1 = ((f.a)localObject2).title;
                      continue;
                    }
                    localObject1 = String.format("[%s: %s]", new Object[] { localObject1, ((f.a)localObject2).title });
                    break;
                  case 4: 
                  case 5: 
                    localObject1 = String.format("[%s: %s]", new Object[] { ((f.a)localObject2).title, ((f.a)localObject2).url });
                    break;
                  }
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
                  localObject1 = String.format("[%s: %s(%s)]", new Object[] { localObject1, new File(com.tencent.mm.modelvideo.s.lw(localau.field_imgPath)).getName(), this.context.getString(R.l.ebP) });
                  continue;
                }
                if ((!localau.bMd()) && (!localau.bMe())) {
                  continue;
                }
                localObject1 = String.format("[%s]", new Object[] { this.context.getString(R.l.ebR) });
                continue;
                localStringBuilder.append("\n</div>\n");
                localObject1 = localStringBuilder.toString();
                GMTrace.o(2171911274496L, 16182);
                return (String)localObject1;
              }
              label1973:
              localObject1 = "";
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
  
  public static class ImageSpanData
    implements Parcelable
  {
    public static final Parcelable.Creator<ImageSpanData> CREATOR;
    int endPos;
    int hrc;
    String path;
    public int thumbnail;
    
    static
    {
      GMTrace.i(2210297544704L, 16468);
      CREATOR = new Parcelable.Creator() {};
      GMTrace.o(2210297544704L, 16468);
    }
    
    public ImageSpanData()
    {
      GMTrace.i(2209760673792L, 16464);
      this.thumbnail = 0;
      GMTrace.o(2209760673792L, 16464);
    }
    
    public int describeContents()
    {
      GMTrace.i(2209894891520L, 16465);
      GMTrace.o(2209894891520L, 16465);
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      GMTrace.i(2210029109248L, 16466);
      paramParcel.writeInt(this.hrc);
      paramParcel.writeInt(this.endPos);
      paramParcel.writeString(this.path);
      paramParcel.writeInt(this.thumbnail);
      GMTrace.o(2210029109248L, 16466);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/QQMailHistoryExporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */