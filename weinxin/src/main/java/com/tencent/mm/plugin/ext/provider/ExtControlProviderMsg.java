package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.et;
import com.tencent.mm.e.a.et.b;
import com.tencent.mm.e.a.ev;
import com.tencent.mm.e.a.ew;
import com.tencent.mm.e.a.ew.b;
import com.tencent.mm.e.a.fc;
import com.tencent.mm.e.a.fc.b;
import com.tencent.mm.e.a.fd;
import com.tencent.mm.e.a.fd.b;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderMsg
  extends ExtContentProviderBase
{
  private static final UriMatcher loR;
  private static final String[] loU;
  private static final String[] loV;
  private static final String[] loW;
  private static final String[] loX;
  private static final String[] loY;
  private static final String[] loZ;
  private String[] loC;
  private int loD;
  private boolean loS;
  private Context loT;
  private MatrixCursor lpa;
  
  static
  {
    GMTrace.i(5732170727424L, 42708);
    loU = new String[] { "msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime" };
    loV = new String[] { "userId", "unReadCount" };
    loW = new String[] { "userId", "unReadCount" };
    loX = new String[] { "userId", "retCode", "msgId" };
    loY = new String[] { "msgId", "retCode" };
    loZ = new String[] { "msgId", "retCode" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    loR = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
    loR.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
    loR.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
    loR.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
    loR.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
    loR.addURI("com.tencent.mm.plugin.ext.message", "playVoice", 12);
    loR.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
    loR.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    GMTrace.o(5732170727424L, 42708);
  }
  
  public ExtControlProviderMsg()
  {
    GMTrace.i(5729486372864L, 42688);
    this.lpa = null;
    this.loS = false;
    this.loC = null;
    this.loD = -1;
    GMTrace.o(5729486372864L, 42688);
  }
  
  public ExtControlProviderMsg(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    GMTrace.i(5729620590592L, 42689);
    this.lpa = null;
    this.loS = false;
    this.loC = null;
    this.loD = -1;
    this.loS = true;
    this.loC = paramArrayOfString;
    this.loD = paramInt;
    this.loT = paramContext;
    GMTrace.o(5729620590592L, 42689);
  }
  
  private Cursor a(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    GMTrace.i(5730694332416L, 42697);
    v.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
    v.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[] { paramString1, paramString2 });
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      bS(3, 3701);
      paramArrayOfString = ma(3701);
      GMTrace.o(5730694332416L, 42697);
      return paramArrayOfString;
    }
    if (bf.mA(paramString1))
    {
      v.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
      bS(3, 3702);
      paramArrayOfString = ma(3702);
      GMTrace.o(5730694332416L, 42697);
      return paramArrayOfString;
    }
    if (bf.mA(paramString2))
    {
      v.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
      bS(3, 3703);
      paramArrayOfString = ma(3703);
      GMTrace.o(5730694332416L, 42697);
      return paramArrayOfString;
    }
    boolean bool1;
    if ((paramString1 != null) && (paramString1.equalsIgnoreCase("openapi"))) {
      bool1 = true;
    }
    x localx;
    boolean bool2;
    String str;
    int i;
    for (;;)
    {
      if (bool1) {}
      try
      {
        paramString1 = com.tencent.mm.plugin.ext.b.aqG().RY(paramArrayOfString[0]);
        if ((paramString1 == null) || (bf.mA(paramString1.field_openId)) || (bf.mA(paramString1.field_username)))
        {
          v.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
          bS(3, 3704);
          paramArrayOfString = ma(3704);
          GMTrace.o(5730694332416L, 42697);
          return paramArrayOfString;
          bool1 = false;
        }
        else
        {
          ap.yY();
          long l;
          for (localx = com.tencent.mm.u.c.wR().Rb(paramString1.field_username); (localx == null) || (localx.field_username == null) || (localx.field_username.length() <= 0); localx = com.tencent.mm.u.c.wR().ez(l))
          {
            v.e("MicroMsg.ExtControlProviderMsg", "contact is null");
            bS(3, 3705);
            paramArrayOfString = ma(3705);
            GMTrace.o(5730694332416L, 42697);
            return paramArrayOfString;
            l = com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString[0]);
            ap.yY();
          }
          bool2 = false;
          str = localx.tL();
          if (localx.field_username.endsWith("@chatroom"))
          {
            str = com.tencent.mm.u.n.eK(localx.field_username);
            bool2 = true;
          }
          if (bool1)
          {
            i = 0;
            try
            {
              int j = bf.getInt(paramString2, 0);
              i = j;
            }
            catch (Exception paramString1)
            {
              for (;;)
              {
                v.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[] { paramString2 });
              }
            }
            if ((i <= 0) || (i >= 15))
            {
              ap.yY();
              paramString1 = com.tencent.mm.u.c.wT().bk(localx.field_username, 15);
              if (paramString1 != null) {
                break label595;
              }
              v.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
              z(3, 4, 3706);
              paramArrayOfString = ma(3706);
              GMTrace.o(5730694332416L, 42697);
              return paramArrayOfString;
            }
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        paramString1 = null;
      }
    }
    for (;;)
    {
      v.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (paramString1 != null) {
        paramString1.close();
      }
      z(3, 4, 12);
      paramArrayOfString = ma(12);
      GMTrace.o(5730694332416L, 42697);
      return paramArrayOfString;
      ap.yY();
      paramString1 = com.tencent.mm.u.c.wT().bk(localx.field_username, i);
      break;
      ap.yY();
      paramString1 = com.tencent.mm.u.c.wT().bk(localx.field_username, 3);
      break;
      label595:
      paramString2 = new MatrixCursor(loU);
      try
      {
        if ((paramString1.getCount() > 0) && (paramString1.moveToFirst()))
        {
          au localau = new au();
          do
          {
            localau.b(paramString1);
            a(paramString2, localau, localx, bool2, str, bool1, paramArrayOfString[0]);
          } while (paramString1.moveToNext());
        }
        paramString1.close();
        z(2, 0, 1);
        GMTrace.o(5730694332416L, 42697);
        return paramString2;
      }
      catch (Exception paramArrayOfString)
      {
        paramString1 = paramString2;
      }
    }
  }
  
  private void a(MatrixCursor paramMatrixCursor, au paramau, x paramx, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    GMTrace.i(5731633856512L, 42704);
    if (paramau == null)
    {
      GMTrace.o(5731633856512L, 42704);
      return;
    }
    if (bf.mA(paramString2))
    {
      v.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
      GMTrace.o(5731633856512L, 42704);
      return;
    }
    if ((paramau.field_type == 9999) || (paramau.field_type == 10000))
    {
      GMTrace.o(5731633856512L, 42704);
      return;
    }
    String str2 = "";
    String str3 = "";
    String str1 = str3;
    Object localObject = str2;
    int i;
    if (paramBoolean1)
    {
      i = ay.gh(paramau.field_content);
      str1 = str3;
      localObject = str2;
      if (i != -1)
      {
        str1 = str3;
        localObject = str2;
        if (paramau.field_content.length() > i)
        {
          String str4 = paramau.field_content.substring(0, i).trim();
          str1 = str3;
          localObject = str2;
          if (str4 != null)
          {
            str1 = str3;
            localObject = str2;
            if (str4.length() > 0)
            {
              str1 = str3;
              localObject = str2;
              if (paramau.field_content.length() >= i + 2)
              {
                localObject = com.tencent.mm.u.n.eK(str4);
                str1 = paramau.field_content.substring(i + 2);
              }
            }
          }
        }
      }
    }
    int k = com.tencent.mm.plugin.ext.b.b.H(paramau);
    if (k == 1) {
      if (paramBoolean1)
      {
        localObject = (String)localObject + "!]" + str1;
        if (!paramBoolean2) {
          break label413;
        }
      }
    }
    label413:
    label575:
    for (;;)
    {
      try
      {
        if (bf.mA(paramString2))
        {
          v.w("MicroMsg.ExtControlProviderMsg", "userId is null");
          GMTrace.o(5731633856512L, 42704);
          return;
          localObject = paramau.field_content;
          break;
          if (k == 2)
          {
            localObject = m.Lz().gQ((int)paramau.field_msgId);
            if ((localObject == null) || (((p)localObject).fyw == null)) {
              break label575;
            }
            localObject = q.jt(((p)localObject).fyw);
            v.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", new Object[] { localObject });
            break;
          }
          if (paramBoolean1) {
            break;
          }
          if (this.loT != null)
          {
            localObject = this.loT.getString(R.l.egJ);
            break;
          }
          localObject = "";
          break;
          paramString2 = com.tencent.mm.plugin.ext.a.a.bK((int)paramx.gTG);
          continue;
        }
        paramx = com.tencent.mm.plugin.ext.a.a.bK(paramau.field_msgId);
        if (paramau.field_isSend == 0)
        {
          i = 1;
          if (paramau.field_status == 4)
          {
            j = 1;
            paramMatrixCursor.addRow(new Object[] { paramx, paramString2, paramString1, Integer.valueOf(i), Integer.valueOf(k), localObject, Integer.valueOf(j), Long.valueOf(paramau.field_createTime) });
            GMTrace.o(5731633856512L, 42704);
          }
        }
        else
        {
          i = 2;
          continue;
        }
        int j = 2;
        continue;
        localObject = "";
      }
      catch (Exception paramMatrixCursor)
      {
        v.e("MicroMsg.ExtControlProviderMsg", paramMatrixCursor.getMessage());
        v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramMatrixCursor, "", new Object[0]);
        GMTrace.o(5731633856512L, 42704);
        return;
      }
    }
  }
  
  private Cursor aqT()
  {
    GMTrace.i(5730828550144L, 42698);
    v.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
    MatrixCursor localMatrixCursor = new MatrixCursor(loW);
    label277:
    for (;;)
    {
      try
      {
        ap.yY();
        Cursor localCursor = com.tencent.mm.u.c.wT().aJY();
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            String str = localCursor.getString(localCursor.getColumnIndex("talker"));
            ap.yY();
            x localx = com.tencent.mm.u.c.wR().Rb(str);
            if (!o.dH(str))
            {
              if ((o.fE(localx.field_username)) || (o.fC(localx.field_username)) || (x.yx(localx.field_verifyFlag)) || (o.fu(localx.field_username))) {
                break label277;
              }
              if (!o.fv(localx.field_username)) {
                continue;
              }
              break label277;
              if (i == 0) {
                localMatrixCursor.addRow(new Object[] { com.tencent.mm.plugin.ext.a.a.bK((int)localx.gTG), Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("unReadCount"))) });
              }
            }
            if (localCursor.moveToNext()) {
              continue;
            }
          }
          else
          {
            localCursor.close();
          }
        }
        else
        {
          lZ(0);
          GMTrace.o(5730828550144L, 42698);
          return localMatrixCursor;
        }
        int i = 1;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
        v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
        localMatrixCursor.close();
        lZ(4);
        GMTrace.o(5730828550144L, 42698);
        return null;
      }
    }
  }
  
  private Cursor c(String[] paramArrayOfString, String paramString)
  {
    GMTrace.i(5730962767872L, 42699);
    v.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      lZ(3);
      GMTrace.o(5730962767872L, 42699);
      return null;
    }
    for (;;)
    {
      try
      {
        long l = com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString[0]);
        ap.yY();
        localau = com.tencent.mm.u.c.wT().cA(l);
        ap.yY();
        localx = com.tencent.mm.u.c.wR().Rb(localau.field_talker);
        if ((localx == null) || ((int)localx.gTG <= 0))
        {
          lZ(3);
          GMTrace.o(5730962767872L, 42699);
          return null;
        }
        bool1 = false;
        str = localx.tL();
        if (localx.field_username.endsWith("@chatroom"))
        {
          str = com.tencent.mm.u.n.eK(localx.field_username);
          bool1 = true;
        }
        if ((paramString != null) && (paramString.equalsIgnoreCase("openapi")))
        {
          bool2 = true;
          paramString = new MatrixCursor(loU);
        }
      }
      catch (Exception paramArrayOfString)
      {
        au localau;
        x localx;
        boolean bool1;
        String str;
        boolean bool2;
        paramString = null;
      }
      try
      {
        a(paramString, localau, localx, bool1, str, bool2, paramArrayOfString[0]);
        lZ(0);
        GMTrace.o(5730962767872L, 42699);
        return paramString;
      }
      catch (Exception paramArrayOfString)
      {
        for (;;) {}
      }
      bool2 = false;
    }
    v.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
    v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
    if (paramString != null) {
      paramString.close();
    }
    lZ(4);
    GMTrace.o(5730962767872L, 42699);
    return null;
  }
  
  private Cursor m(String[] paramArrayOfString)
  {
    GMTrace.i(5730560114688L, 42696);
    v.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      lZ(3);
      GMTrace.o(5730560114688L, 42696);
      return null;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(loV);
    try
    {
      if ("*".equals(paramArrayOfString[0]))
      {
        ap.yY();
        localMatrixCursor.addRow(new Object[] { "0", Integer.valueOf(com.tencent.mm.u.c.wW().fM("")) });
      }
      for (;;)
      {
        lZ(0);
        GMTrace.o(5730560114688L, 42696);
        return localMatrixCursor;
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          long l = com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString[i]);
          ap.yY();
          x localx = com.tencent.mm.u.c.wR().ez(l);
          if ((localx != null) && ((int)localx.gTG > 0))
          {
            ap.yY();
            localMatrixCursor.addRow(new Object[] { Long.valueOf(l), Integer.valueOf(com.tencent.mm.u.c.wW().fM(" and ( rconversation.username='" + localx.field_username + "' );")) });
          }
          i += 1;
        }
      }
      return null;
    }
    catch (Exception paramArrayOfString)
    {
      v.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      localMatrixCursor.close();
      lZ(4);
      GMTrace.o(5730560114688L, 42696);
    }
  }
  
  private Cursor n(final String[] paramArrayOfString)
  {
    GMTrace.i(5731096985600L, 42700);
    v.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      v.w("MicroMsg.ExtControlProviderMsg", "wrong args");
      lZ(3);
      GMTrace.o(5731096985600L, 42700);
      return null;
    }
    try
    {
      final int i = Integer.valueOf(paramArrayOfString[0]).intValue();
      final long l = com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString[1]);
      if (l <= 0L)
      {
        lZ(3);
        GMTrace.o(5731096985600L, 42700);
        return null;
      }
      com.tencent.mm.pluginsdk.f.a.a locala = new com.tencent.mm.pluginsdk.f.a.a();
      locala.b(4000L, new Runnable()
      {
        public final void run()
        {
          GMTrace.i(5718480519168L, 42606);
          Object localObject1;
          Object localObject2;
          if (i == 1)
          {
            com.tencent.mm.plugin.ext.b.aqD();
            localObject1 = com.tencent.mm.plugin.ext.b.bI(l);
            if ((localObject1 == null) || ((int)((com.tencent.mm.j.a)localObject1).gTG <= 0))
            {
              ExtControlProviderMsg.this.lZ(3);
              paramArrayOfString.countDown();
              GMTrace.o(5718480519168L, 42606);
              return;
            }
            localObject2 = new ew();
            ((ew)localObject2).fIW.op = 1;
            ((ew)localObject2).fIW.username = ((af)localObject1).field_username;
            if (!com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject2))
            {
              ExtControlProviderMsg.this.lZ(4);
              paramArrayOfString.countDown();
              GMTrace.o(5718480519168L, 42606);
              return;
            }
            ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.aqU()));
            if ((localObject1 != null) && ((int)((com.tencent.mm.j.a)localObject1).gTG > 0) && (((ew)localObject2).fIX.fFa))
            {
              ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.iGt[1], Integer.valueOf(1), "0" });
              ExtControlProviderMsg.this.lZ(0);
              v.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", new Object[] { Boolean.valueOf(((ew)localObject2).fIX.fFa), ((ew)localObject2).fIX.fyw });
            }
          }
          for (;;)
          {
            paramArrayOfString.countDown();
            GMTrace.o(5718480519168L, 42606);
            return;
            ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.iGt[1], Integer.valueOf(2), "0" });
            ExtControlProviderMsg.this.lZ(3);
            break;
            if (i == 2)
            {
              localObject1 = new ew();
              ((ew)localObject1).fIW.op = 2;
              if (!com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1))
              {
                ExtControlProviderMsg.this.lZ(4);
                paramArrayOfString.countDown();
                GMTrace.o(5718480519168L, 42606);
                return;
              }
              localObject2 = ((ew)localObject1).fIX.fyw;
              ExtControlProviderMsg.a(ExtControlProviderMsg.this, new MatrixCursor(ExtControlProviderMsg.aqU()));
              fc localfc = new fc();
              localfc.fJt.fyw = ((String)localObject2);
              if (!com.tencent.mm.sdk.b.a.uql.m(localfc))
              {
                ExtControlProviderMsg.this.lZ(4);
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).close();
                paramArrayOfString.countDown();
                GMTrace.o(5718480519168L, 42606);
                return;
              }
              v.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", new Object[] { Long.valueOf(localfc.fJu.fGD) });
              long l = localfc.fJu.fGD;
              if (l > 0L)
              {
                try
                {
                  if (!((ew)localObject1).fIX.fFa) {
                    break label655;
                  }
                  if ((aa.getContext() == null) || (!al.isConnected(aa.getContext()))) {
                    break label606;
                  }
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.iGt[1], Integer.valueOf(1), com.tencent.mm.plugin.ext.a.a.bK(l) });
                  ExtControlProviderMsg.this.lZ(0);
                }
                catch (Exception localException)
                {
                  v.w("MicroMsg.ExtControlProviderMsg", localException.getMessage());
                  v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
                  ExtControlProviderMsg.this.lZ(4);
                }
                continue;
                label606:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.iGt[1], Integer.valueOf(6), com.tencent.mm.plugin.ext.a.a.bK(l) });
                ExtControlProviderMsg.this.lZ(4);
                continue;
                label655:
                ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.iGt[1], Integer.valueOf(4), com.tencent.mm.plugin.ext.a.a.bK(l) });
                ExtControlProviderMsg.this.lZ(4);
              }
              else
              {
                ExtControlProviderMsg.this.lZ(3);
              }
            }
          }
        }
      });
      paramArrayOfString = this.lpa;
      GMTrace.o(5731096985600L, 42700);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      v.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.lpa != null) {
        this.lpa.close();
      }
      lZ(4);
      GMTrace.o(5731096985600L, 42700);
    }
    return null;
  }
  
  private Cursor o(String[] paramArrayOfString)
  {
    GMTrace.i(5731231203328L, 42701);
    v.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      lZ(3);
      GMTrace.o(5731231203328L, 42701);
      return null;
    }
    fd localfd = null;
    try
    {
      i = Integer.valueOf(paramArrayOfString[0]).intValue();
      long l = com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString[1]);
      if (l <= 0L)
      {
        lZ(3);
        GMTrace.o(5731231203328L, 42701);
        return null;
      }
      if (i != 3) {
        break label387;
      }
      localObject = new MatrixCursor(loY);
      try
      {
        localfd = new fd();
        localfd.fJv.fGD = l;
        com.tencent.mm.sdk.b.a.uql.m(localfd);
        if ((localfd.fJw.fyw == null) || (localfd.fJw.fyw.length() <= 0))
        {
          ((MatrixCursor)localObject).addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          lZ(4);
          GMTrace.o(5731231203328L, 42701);
          return (Cursor)localObject;
        }
        ev localev = new ev();
        localev.fIR.op = 1;
        localev.fIR.fyw = localfd.fJw.fyw;
        if (com.tencent.mm.sdk.b.a.uql.m(localev))
        {
          ((MatrixCursor)localObject).addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(1) });
          lZ(0);
        }
        for (;;)
        {
          com.tencent.mm.plugin.ext.b.aqD();
          com.tencent.mm.plugin.ext.b.bJ(l);
          GMTrace.o(5731231203328L, 42701);
          return (Cursor)localObject;
          v.e("MicroMsg.ExtControlProviderMsg", "play failed");
          ((MatrixCursor)localObject).addRow(new Object[] { paramArrayOfString[1], Integer.valueOf(2) });
          lZ(4);
        }
        v.e("MicroMsg.ExtControlProviderMsg", ((Exception)localObject).getMessage());
      }
      catch (Exception localException2)
      {
        paramArrayOfString = (String[])localObject;
        localObject = localException2;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int i;
        Object localObject;
        paramArrayOfString = localException2;
      }
    }
    v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", (Throwable)localObject, "", new Object[0]);
    if (paramArrayOfString != null) {
      paramArrayOfString.close();
    }
    lZ(4);
    GMTrace.o(5731231203328L, 42701);
    return null;
    label387:
    if (i == 4)
    {
      paramArrayOfString = new ev();
      paramArrayOfString.fIR.op = 2;
      if (!com.tencent.mm.sdk.b.a.uql.m(paramArrayOfString)) {
        break label442;
      }
      v.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
      lZ(0);
    }
    for (;;)
    {
      GMTrace.o(5731231203328L, 42701);
      return null;
      label442:
      v.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
      lZ(4);
    }
  }
  
  private Cursor p(String[] paramArrayOfString)
  {
    GMTrace.i(5731365421056L, 42702);
    v.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      bS(3, 3801);
      paramArrayOfString = ma(3801);
      GMTrace.o(5731365421056L, 42702);
      return paramArrayOfString;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramArrayOfString.length) {
          if ((paramArrayOfString[i] == null) || (paramArrayOfString[i].length() <= 0))
          {
            v.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = " + i);
          }
          else
          {
            long l = com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString[i]);
            com.tencent.mm.plugin.ext.b.aqD();
            com.tencent.mm.plugin.ext.b.bJ(l);
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        v.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
        v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
        bS(4, 12);
        paramArrayOfString = ma(12);
        GMTrace.o(5731365421056L, 42702);
        return paramArrayOfString;
      }
      bS(0, 1);
      paramArrayOfString = ma(1);
      GMTrace.o(5731365421056L, 42702);
      return paramArrayOfString;
      i += 1;
    }
  }
  
  private Cursor q(final String[] paramArrayOfString)
  {
    GMTrace.i(5731499638784L, 42703);
    v.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
      lZ(3);
      GMTrace.o(5731499638784L, 42703);
      return null;
    }
    try
    {
      long l = com.tencent.mm.plugin.ext.a.a.vw(paramArrayOfString[0]);
      if (l <= 0L)
      {
        lZ(3);
        GMTrace.o(5731499638784L, 42703);
        return null;
      }
      com.tencent.mm.plugin.ext.b.aqD();
      final x localx = com.tencent.mm.plugin.ext.b.bI(l);
      if ((localx == null) || ((int)localx.gTG <= 0))
      {
        v.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
        lZ(3);
        GMTrace.o(5731499638784L, 42703);
        return null;
      }
      this.lpa = new MatrixCursor(loZ);
      final com.tencent.mm.pluginsdk.f.a.a locala = new com.tencent.mm.pluginsdk.f.a.a();
      locala.b(15000L, new Runnable()
      {
        public final void run()
        {
          GMTrace.i(5726667800576L, 42667);
          Object localObject = new et();
          ((et)localObject).fIM.toUserName = localx.field_username;
          ((et)localObject).fIM.content = paramArrayOfString[1];
          ((et)localObject).fIM.type = o.fG(localx.field_username);
          ((et)localObject).fIM.flags = 0;
          if (!com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject))
          {
            ExtControlProviderMsg.this.lZ(4);
            locala.countDown();
            GMTrace.o(5726667800576L, 42667);
            return;
          }
          k localk = ((et)localObject).fIN.fIO;
          try
          {
            localObject = new e()
            {
              public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, k paramAnonymous2k)
              {
                GMTrace.i(5726399365120L, 42665);
                v.d("MicroMsg.ExtControlProviderMsg", "onSceneEnd errType=%s, errCode=%s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                if (paramAnonymous2k == null)
                {
                  v.e("MicroMsg.ExtControlProviderMsg", "scene == null");
                  ap.vd().b(522, this);
                  ExtControlProviderMsg.this.lZ(4);
                  ExtControlProviderMsg.2.this.jNN.countDown();
                  GMTrace.o(5726399365120L, 42665);
                  return;
                }
                switch (paramAnonymous2k.getType())
                {
                default: 
                  ExtControlProviderMsg.this.lZ(0);
                }
                for (;;)
                {
                  ExtControlProviderMsg.2.this.jNN.countDown();
                  ap.vd().b(522, this);
                  GMTrace.o(5726399365120L, 42665);
                  return;
                  if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0))
                  {
                    v.d("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd ok, ");
                    ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.lpf, Integer.valueOf(1) });
                    break;
                  }
                  v.e("MicroMsg.ExtControlProviderMsg", "rtSENDMSG onSceneEnd err, errType = " + paramAnonymous2Int1 + ", errCode = " + paramAnonymous2Int2);
                  ExtControlProviderMsg.a(ExtControlProviderMsg.this).addRow(new Object[] { this.lpf, Integer.valueOf(2) });
                  ExtControlProviderMsg.this.lZ(4);
                }
              }
            };
            ap.vd().a(522, (e)localObject);
            ap.vd().a(localk, 0);
            GMTrace.o(5726667800576L, 42667);
            return;
          }
          catch (Exception localException)
          {
            v.e("MicroMsg.ExtControlProviderMsg", localException.getMessage());
            v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", localException, "", new Object[0]);
            ExtControlProviderMsg.this.lZ(4);
            locala.countDown();
            GMTrace.o(5726667800576L, 42667);
          }
        }
      });
      paramArrayOfString = this.lpa;
      GMTrace.o(5731499638784L, 42703);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      v.e("MicroMsg.ExtControlProviderMsg", paramArrayOfString.getMessage());
      v.printErrStackTrace("MicroMsg.ExtControlProviderMsg", paramArrayOfString, "", new Object[0]);
      if (this.lpa != null) {
        this.lpa.close();
      }
      lZ(4);
      GMTrace.o(5731499638784L, 42703);
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(5730291679232L, 42694);
    GMTrace.o(5730291679232L, 42694);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    GMTrace.i(5729754808320L, 42690);
    GMTrace.o(5729754808320L, 42690);
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    GMTrace.i(5730157461504L, 42693);
    GMTrace.o(5730157461504L, 42693);
    return null;
  }
  
  public boolean onCreate()
  {
    GMTrace.i(5729889026048L, 42691);
    GMTrace.o(5729889026048L, 42691);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    GMTrace.i(5730023243776L, 42692);
    v.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.loS);
    if (this.loS)
    {
      a(paramUri, this.loT, this.loD, this.loC);
      if (bf.mA(this.loL))
      {
        v.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
        bS(3, 7);
        paramUri = ma(7);
        GMTrace.o(5730023243776L, 42692);
        return paramUri;
      }
      if (bf.mA(aqR()))
      {
        v.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
        bS(3, 6);
        paramUri = ma(6);
        GMTrace.o(5730023243776L, 42692);
        return paramUri;
      }
      int i = aqS();
      if (i != 1)
      {
        v.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = " + i);
        bS(2, i);
        paramUri = ma(i);
        GMTrace.o(5730023243776L, 42692);
        return paramUri;
      }
    }
    else
    {
      this.loT = getContext();
      a(paramUri, this.loT, loR);
      if (paramUri == null)
      {
        lZ(3);
        GMTrace.o(5730023243776L, 42692);
        return null;
      }
      if ((bf.mA(this.loL)) || (bf.mA(aqR())))
      {
        lZ(3);
        GMTrace.o(5730023243776L, 42692);
        return null;
      }
      if (!acE())
      {
        lZ(1);
        paramUri = this.jND;
        GMTrace.o(5730023243776L, 42692);
        return paramUri;
      }
      if (!bW(this.loT))
      {
        v.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
        lZ(2);
        GMTrace.o(5730023243776L, 42692);
        return null;
      }
    }
    paramArrayOfString1 = bf.mz(paramUri.getQueryParameter("source"));
    paramString1 = bf.mz(paramUri.getQueryParameter("count"));
    if (!this.loS) {
      this.loD = loR.match(paramUri);
    }
    switch (this.loD)
    {
    default: 
      bS(3, 15);
      GMTrace.o(5730023243776L, 42692);
      return null;
    case 7: 
      paramUri = c(paramArrayOfString2, paramArrayOfString1);
      GMTrace.o(5730023243776L, 42692);
      return paramUri;
    case 8: 
      paramUri = m(paramArrayOfString2);
      GMTrace.o(5730023243776L, 42692);
      return paramUri;
    case 9: 
      paramUri = a(paramArrayOfString2, paramArrayOfString1, paramString1);
      GMTrace.o(5730023243776L, 42692);
      return paramUri;
    case 10: 
      paramUri = aqT();
      GMTrace.o(5730023243776L, 42692);
      return paramUri;
    case 11: 
      paramUri = n(paramArrayOfString2);
      GMTrace.o(5730023243776L, 42692);
      return paramUri;
    case 12: 
      paramUri = o(paramArrayOfString2);
      GMTrace.o(5730023243776L, 42692);
      return paramUri;
    case 13: 
      paramUri = p(paramArrayOfString2);
      GMTrace.o(5730023243776L, 42692);
      return paramUri;
    }
    paramUri = q(paramArrayOfString2);
    GMTrace.o(5730023243776L, 42692);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    GMTrace.i(5730425896960L, 42695);
    GMTrace.o(5730425896960L, 42695);
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ext/provider/ExtControlProviderMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */