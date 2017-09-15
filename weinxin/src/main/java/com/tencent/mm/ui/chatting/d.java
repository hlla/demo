package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.ByteArrayOutputStream;
import java.io.File;

final class d
{
  private static void a(En_5b8fbb1e.a parama, Intent paramIntent, au paramau, String paramString)
  {
    GMTrace.i(2206405230592L, 16439);
    if ((paramau.bMj()) || (c(paramau, paramString)))
    {
      v.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
      com.tencent.mm.ui.base.g.a(parama.uRf.uRz, parama.uRf.uRz.getString(R.l.ejQ), parama.uRf.uRz.getString(R.l.dIG), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2254455177216L, 16797);
          GMTrace.o(2254455177216L, 16797);
        }
      });
      GMTrace.o(2206405230592L, 16439);
      return;
    }
    parama.startActivity(paramIntent);
    GMTrace.o(2206405230592L, 16439);
  }
  
  static void a(En_5b8fbb1e.a parama, final au paramau, String paramString)
  {
    GMTrace.i(2206271012864L, 16438);
    Object localObject1 = parama.cQ(paramau.field_content, paramau.field_isSend);
    final Intent localIntent = new Intent(parama.uRf.uRz, MsgRetransmitUI.class);
    localIntent.putExtra("Retr_Msg_content", (String)localObject1);
    localIntent.putExtra("Retr_MsgFromScene", 2);
    localObject1 = f.a.ek((String)localObject1);
    if ((localObject1 != null) && (19 == ((f.a)localObject1).type)) {
      localIntent.putExtra("Retr_Msg_Type", 10);
    }
    for (;;)
    {
      localIntent.putExtra("Retr_Msg_Id", paramau.field_msgId);
      if ((localObject1 != null) && (((f.a)localObject1).type == 6)) {
        break label416;
      }
      parama.startActivity(localIntent);
      GMTrace.o(2206271012864L, 16438);
      return;
      if ((localObject1 != null) && (24 == ((f.a)localObject1).type))
      {
        localIntent.putExtra("Retr_Msg_Type", 10);
      }
      else
      {
        if ((localObject1 == null) || (16 != ((f.a)localObject1).type)) {
          break;
        }
        localIntent.putExtra("Retr_Msg_Type", 14);
      }
    }
    localIntent.putExtra("Retr_Msg_Type", 2);
    final Object localObject2 = paramau.field_talker;
    Object localObject3 = com.tencent.mm.u.q.fQ(paramau.field_msgSvrId);
    localIntent.putExtra("reportSessionId", (String)localObject3);
    localObject3 = com.tencent.mm.u.q.yC().n((String)localObject3, true);
    ((q.b)localObject3).l("prePublishId", "msg_" + paramau.field_msgSvrId);
    ((q.b)localObject3).l("preUsername", paramString);
    ((q.b)localObject3).l("preChatName", localObject2);
    if ((localObject1 != null) && (33 == ((f.a)localObject1).type))
    {
      if (!parama.vzR) {
        break label392;
      }
      ((q.b)localObject3).l("fromScene", Integer.valueOf(2));
      localIntent.putExtra("Retr_MsgAppBrandFromScene", 2);
    }
    for (;;)
    {
      localIntent.putExtra("Retr_MsgFromUserName", paramString);
      localIntent.putExtra("Retr_MsgTalker", paramau.field_talker);
      ((q.b)localObject3).l("sendAppMsgScene", Integer.valueOf(1));
      ((com.tencent.mm.plugin.sns.b.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.h.class)).a("adExtStr", (q.b)localObject3, paramau);
      break;
      label392:
      ((q.b)localObject3).l("fromScene", Integer.valueOf(1));
      localIntent.putExtra("Retr_MsgAppBrandFromScene", 1);
    }
    label416:
    if ((((f.a)localObject1).hhk != 0) || (((f.a)localObject1).hhg > 26214400)) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("Retr_Big_File", bool);
      localObject2 = com.tencent.mm.pluginsdk.model.app.l.Mg(((f.a)localObject1).fCN);
      if (localObject2 == null) {
        break label563;
      }
      localObject3 = new File(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
      if ((!((File)localObject3).exists()) || (((File)localObject3).length() != ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_totalLen)) {
        break;
      }
      parama.startActivity(localIntent);
      GMTrace.o(2206271012864L, 16438);
      return;
    }
    if ((((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_offset > 0L) && (((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_totalLen > ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_offset))
    {
      a(parama, localIntent, paramau, ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
      GMTrace.o(2206271012864L, 16438);
      return;
    }
    label563:
    v.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[] { Integer.valueOf(((f.a)localObject1).hhg), ((f.a)localObject1).hhn, bf.Qi(((f.a)localObject1).hhu) });
    if (!bool)
    {
      a(parama, localIntent, paramau, null);
      GMTrace.o(2206271012864L, 16438);
      return;
    }
    localIntent.putExtra("Retr_Big_File", bool);
    localObject3 = new com.tencent.mm.modelcdntran.h();
    ((com.tencent.mm.modelcdntran.h)localObject3).hyM = new h.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, keep_ProgressInfo paramAnonymouskeep_ProgressInfo, keep_SceneResult paramAnonymouskeep_SceneResult, boolean paramAnonymousBoolean)
      {
        GMTrace.i(2144262422528L, 15976);
        boolean bool1;
        boolean bool2;
        if (paramAnonymouskeep_ProgressInfo != null)
        {
          bool1 = true;
          if (paramAnonymouskeep_SceneResult == null) {
            break label122;
          }
          bool2 = true;
          label24:
          v.i("MicroMsg.AppMessageUtil", "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymouskeep_ProgressInfo, paramAnonymouskeep_SceneResult, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymouskeep_SceneResult != null)
          {
            if (!paramAnonymouskeep_SceneResult.field_exist_whencheck) {
              break label128;
            }
            this.vwq.startActivity(localIntent);
          }
        }
        for (;;)
        {
          GMTrace.o(2144262422528L, 15976);
          return 0;
          bool1 = false;
          break;
          label122:
          bool2 = false;
          break label24;
          label128:
          if ((paramau.bMj()) || ((localObject2 != null) && (d.c(paramau, localObject2.field_fileFullPath))))
          {
            v.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
            com.tencent.mm.ui.base.g.a(this.vwq.uRf.uRz, this.vwq.uRf.uRz.getString(R.l.ejQ), this.vwq.uRf.uRz.getString(R.l.dIG), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(2233651429376L, 16642);
                GMTrace.o(2233651429376L, 16642);
              }
            });
          }
          else
          {
            com.tencent.mm.ui.base.g.b(this.vwq.uRf.uRz, this.vwq.getString(R.l.eaB), "", true);
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        GMTrace.i(2144396640256L, 15977);
        GMTrace.o(2144396640256L, 15977);
      }
      
      public final byte[] i(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        GMTrace.i(2144530857984L, 15978);
        GMTrace.o(2144530857984L, 15978);
        return new byte[0];
      }
    };
    ((com.tencent.mm.modelcdntran.h)localObject3).field_mediaId = com.tencent.mm.modelcdntran.d.a("checkExist", bf.NA(), paramString, paramau.field_msgId);
    ((com.tencent.mm.modelcdntran.h)localObject3).field_fileId = ((f.a)localObject1).hhn;
    ((com.tencent.mm.modelcdntran.h)localObject3).field_aesKey = ((f.a)localObject1).hhu;
    ((com.tencent.mm.modelcdntran.h)localObject3).field_filemd5 = ((f.a)localObject1).filemd5;
    ((com.tencent.mm.modelcdntran.h)localObject3).field_fileType = com.tencent.mm.modelcdntran.b.hxv;
    ((com.tencent.mm.modelcdntran.h)localObject3).field_talker = paramString;
    ((com.tencent.mm.modelcdntran.h)localObject3).field_priority = com.tencent.mm.modelcdntran.b.hxt;
    ((com.tencent.mm.modelcdntran.h)localObject3).field_svr_signature = "";
    ((com.tencent.mm.modelcdntran.h)localObject3).field_onlycheckexist = true;
    bool = com.tencent.mm.modelcdntran.g.Em().b((com.tencent.mm.modelcdntran.h)localObject3);
    v.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.modelcdntran.h)localObject3).field_fileId, ((com.tencent.mm.modelcdntran.h)localObject3).field_mediaId, bf.Qi(((com.tencent.mm.modelcdntran.h)localObject3).field_aesKey) });
    if (!bool) {
      a(parama, localIntent, paramau, null);
    }
    GMTrace.o(2206271012864L, 16438);
  }
  
  static boolean a(Context paramContext, f.a parama)
  {
    GMTrace.i(2206136795136L, 16437);
    if ((parama == null) || (paramContext == null))
    {
      GMTrace.o(2206136795136L, 16437);
      return false;
    }
    boolean bool;
    if (parama.type == 3)
    {
      bool = com.tencent.mm.pluginsdk.model.app.g.m(paramContext, 16L);
      GMTrace.o(2206136795136L, 16437);
      return bool;
    }
    if (parama.type == 4)
    {
      bool = com.tencent.mm.pluginsdk.model.app.g.m(paramContext, 8L);
      GMTrace.o(2206136795136L, 16437);
      return bool;
    }
    if (parama.type == 5)
    {
      bool = com.tencent.mm.pluginsdk.model.app.g.m(paramContext, 32L);
      GMTrace.o(2206136795136L, 16437);
      return bool;
    }
    if (parama.type == 6)
    {
      parama = b.a.LA(parama.hhh);
      if (parama == null)
      {
        GMTrace.o(2206136795136L, 16437);
        return false;
      }
      bool = com.tencent.mm.pluginsdk.model.app.g.m(paramContext, parama.longValue());
      GMTrace.o(2206136795136L, 16437);
      return bool;
    }
    GMTrace.o(2206136795136L, 16437);
    return false;
  }
  
  public static boolean c(au paramau, String paramString)
  {
    GMTrace.i(2206539448320L, 16440);
    if ((System.currentTimeMillis() - paramau.field_createTime > 259200000L) && ((bf.mA(paramString)) || (!e.aO(paramString))))
    {
      GMTrace.o(2206539448320L, 16440);
      return true;
    }
    GMTrace.o(2206539448320L, 16440);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */