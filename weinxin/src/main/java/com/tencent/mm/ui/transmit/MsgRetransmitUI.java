package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.lz.a;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.e.a.of;
import com.tencent.mm.e.a.ou;
import com.tencent.mm.e.a.ov;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.pluginsdk.model.app.z.a;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.ab;
import com.tencent.mm.ui.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public class MsgRetransmitUI
  extends MMBaseActivity
  implements com.tencent.mm.y.e
{
  public long fGD;
  private String fKq;
  private float fNS;
  public String fSi;
  public String fyw;
  private int hEK;
  private float hGC;
  private String hGD;
  private com.tencent.mm.y.f hGb;
  private String iCm;
  private ProgressDialog isb;
  long jZq;
  private int length;
  private ad mHandler;
  public int msgType;
  boolean sLe;
  private long startTime;
  private int vBh;
  private boolean vuS;
  public List<String> wnE;
  private String wnF;
  private boolean wnG;
  private boolean wnH;
  private com.tencent.mm.ui.base.h wnI;
  private int wnJ;
  private int wnK;
  private com.tencent.mm.ah.k wnL;
  private boolean wnM;
  private List<String> wnN;
  private int wnO;
  private int wnP;
  private boolean wnQ;
  private boolean wnR;
  private int wnS;
  private boolean wnT;
  private boolean wnU;
  private boolean wnV;
  private int wnW;
  private int wnX;
  private String wnY;
  private String wnZ;
  private int woa;
  private boolean wob;
  boolean woc;
  
  public MsgRetransmitUI()
  {
    GMTrace.i(3026743984128L, 22551);
    this.wnF = null;
    this.wnG = true;
    this.wnH = false;
    this.isb = null;
    this.hEK = 0;
    this.wnJ = 0;
    this.wnK = 0;
    this.wnL = null;
    this.wnM = false;
    this.wnN = null;
    this.hGb = null;
    this.wnO = 0;
    this.wnP = 0;
    this.wnQ = false;
    this.wnR = false;
    this.vuS = false;
    this.vBh = -1;
    this.wnU = true;
    this.wnV = true;
    this.wnW = 0;
    this.startTime = 0L;
    this.wob = true;
    this.mHandler = new ad();
    this.woc = false;
    GMTrace.o(3026743984128L, 22551);
  }
  
  private boolean Up(String paramString)
  {
    GMTrace.i(3027549290496L, 22557);
    f.a locala = f.a.ek(bf.PW(this.fSi));
    v.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", new Object[] { this.fSi, locala });
    if (locala == null)
    {
      v.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
      GMTrace.o(3027549290496L, 22557);
      return false;
    }
    ap.yY();
    au localau = com.tencent.mm.u.c.wT().cA(this.fGD);
    if ((localau.bLO()) || (localau.bLN()))
    {
      com.tencent.mm.ui.chatting.aa.a(this, paramString, this.fSi, localau.field_isSend, this.vuS);
      GMTrace.o(3027549290496L, 22557);
      return true;
    }
    String str = null;
    Object localObject = null;
    byte[] arrayOfByte1 = null;
    boolean bool;
    if (this.wnF == null)
    {
      localObject = str;
      if (this.vBh < 0)
      {
        localObject = str;
        if (localau.field_imgPath != null)
        {
          localObject = str;
          if (!localau.field_imgPath.equals(""))
          {
            str = com.tencent.mm.ah.n.GT().v(localau.field_imgPath, true);
            localObject = arrayOfByte1;
            try
            {
              arrayOfByte1 = FileOp.c(str, 0, -1);
              localObject = arrayOfByte1;
              bool = bq(arrayOfByte1);
              localObject = arrayOfByte1;
              if (!bool)
              {
                GMTrace.o(3027549290496L, 22557);
                return false;
              }
            }
            catch (Exception localException1)
            {
              v.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException1.getLocalizedMessage() });
            }
          }
        }
      }
    }
    for (;;)
    {
      a(paramString, locala, (byte[])localObject);
      break;
      try
      {
        byte[] arrayOfByte2 = FileOp.c(this.wnF, 0, -1);
        localObject = arrayOfByte2;
        bool = bq(arrayOfByte2);
        localObject = arrayOfByte2;
        if (!bool)
        {
          GMTrace.o(3027549290496L, 22557);
          return false;
        }
      }
      catch (Exception localException2)
      {
        v.printErrStackTrace("MicroMsg.MsgRetransmitUI", localException2, "", new Object[0]);
        v.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", new Object[] { paramString, localException2.getLocalizedMessage() });
      }
    }
  }
  
  private void Uq(final String paramString)
  {
    GMTrace.i(3028220379136L, 22562);
    v.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
    paramString = new com.tencent.mm.pluginsdk.model.j(this, null, getIntent(), paramString, 1, new j.a()
    {
      public final void bCz()
      {
        GMTrace.i(3047950385152L, 22709);
        if (MsgRetransmitUI.f(MsgRetransmitUI.this) != null)
        {
          MsgRetransmitUI.f(MsgRetransmitUI.this).dismiss();
          MsgRetransmitUI.g(MsgRetransmitUI.this);
        }
        MsgRetransmitUI.this.finish();
        GMTrace.o(3047950385152L, 22709);
      }
    });
    com.tencent.mm.sdk.f.e.post(paramString, "ChattingUI_importMultiVideo");
    getString(R.l.dIG);
    this.isb = com.tencent.mm.ui.base.g.a(this, getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GMTrace.i(3038286708736L, 22637);
        paramString.bCx();
        MsgRetransmitUI.this.woc = true;
        MsgRetransmitUI.this.finish();
        GMTrace.o(3038286708736L, 22637);
      }
    });
    GMTrace.o(3028220379136L, 22562);
  }
  
  /* Error */
  private static boolean Ur(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 348
    //   3: sipush 22565
    //   6: invokestatic 116	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: ldc -63
    //   11: ldc_w 351
    //   14: iconst_2
    //   15: anewarray 197	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: bipush 7
    //   26: invokestatic 357	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: invokestatic 359	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_0
    //   36: invokestatic 363	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore_2
    //   40: aload_2
    //   41: astore_1
    //   42: new 365	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger
    //   45: dup
    //   46: invokespecial 366	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:<init>	()V
    //   49: astore_3
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: aload_3
    //   54: invokestatic 372	com/tencent/mm/sdk/platformtools/MMBitmapFactory:checkIsImageLegal	(Ljava/io/InputStream;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Z
    //   57: ifne +66 -> 123
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: invokevirtual 376	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:getDecodeResult	()I
    //   66: sipush 2000
    //   69: if_icmplt +54 -> 123
    //   72: aload_2
    //   73: astore_1
    //   74: ldc -63
    //   76: ldc_w 378
    //   79: invokestatic 381	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_2
    //   83: astore_1
    //   84: aload_0
    //   85: bipush 7
    //   87: aload_3
    //   88: invokestatic 387	com/tencent/mm/sdk/platformtools/MMBitmapFactory$KVStatHelper:getKVStatString	(Ljava/lang/Object;ILcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Ljava/lang/String;
    //   91: astore_3
    //   92: aload_2
    //   93: astore_1
    //   94: getstatic 393	com/tencent/mm/plugin/report/service/g:oSF	Lcom/tencent/mm/plugin/report/service/g;
    //   97: sipush 12712
    //   100: aload_3
    //   101: invokevirtual 397	com/tencent/mm/plugin/report/service/g:A	(ILjava/lang/String;)V
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 402	java/io/InputStream:close	()V
    //   112: ldc2_w 348
    //   115: sipush 22565
    //   118: invokestatic 170	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   121: iconst_0
    //   122: ireturn
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 402	java/io/InputStream:close	()V
    //   131: ldc2_w 348
    //   134: sipush 22565
    //   137: invokestatic 170	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   140: iconst_1
    //   141: ireturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_1
    //   145: ldc -63
    //   147: ldc_w 404
    //   150: iconst_1
    //   151: anewarray 197	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_0
    //   157: aastore
    //   158: invokestatic 406	com/tencent/mm/sdk/platformtools/v:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 402	java/io/InputStream:close	()V
    //   169: ldc2_w 348
    //   172: sipush 22565
    //   175: invokestatic 170	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   178: iconst_0
    //   179: ireturn
    //   180: astore_0
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 402	java/io/InputStream:close	()V
    //   189: aload_0
    //   190: athrow
    //   191: astore_0
    //   192: goto -80 -> 112
    //   195: astore_0
    //   196: goto -65 -> 131
    //   199: astore_0
    //   200: goto -31 -> 169
    //   203: astore_1
    //   204: goto -15 -> 189
    //   207: astore_0
    //   208: goto -27 -> 181
    //   211: astore_1
    //   212: aload_2
    //   213: astore_1
    //   214: goto -69 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramString	String
    //   34	60	1	localObject1	Object
    //   142	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   144	42	1	localObject2	Object
    //   203	1	1	localException	Exception
    //   211	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   213	1	1	localObject3	Object
    //   39	174	2	localInputStream	java.io.InputStream
    //   49	52	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   35	40	142	java/io/FileNotFoundException
    //   35	40	180	finally
    //   42	50	180	finally
    //   52	60	180	finally
    //   62	72	180	finally
    //   74	82	180	finally
    //   84	92	180	finally
    //   94	104	180	finally
    //   108	112	191	java/lang/Exception
    //   127	131	195	java/lang/Exception
    //   165	169	199	java/lang/Exception
    //   185	189	203	java/lang/Exception
    //   145	161	207	finally
    //   42	50	211	java/io/FileNotFoundException
    //   52	60	211	java/io/FileNotFoundException
    //   62	72	211	java/io/FileNotFoundException
    //   74	82	211	java/io/FileNotFoundException
    //   84	92	211	java/io/FileNotFoundException
    //   94	104	211	java/io/FileNotFoundException
  }
  
  private void a(final String paramString, final int paramInt, final com.tencent.mm.y.f paramf)
  {
    GMTrace.i(3028354596864L, 22563);
    final String str2 = m.xL();
    final String str1 = "";
    ap.yY();
    au localau1 = com.tencent.mm.u.c.wT().cA(this.fGD);
    if (localau1.field_msgId == this.fGD) {
      str1 = localau1.field_content;
    }
    com.tencent.mm.ah.d locald1 = null;
    if (localau1.field_msgId > 0L) {
      locald1 = com.tencent.mm.ah.n.GT().aj(localau1.field_msgId);
    }
    Object localObject1;
    if (locald1 != null)
    {
      localObject1 = locald1;
      if (locald1.hEG > 0L) {}
    }
    else
    {
      localObject1 = locald1;
      if (localau1.field_msgSvrId > 0L) {
        localObject1 = com.tencent.mm.ah.n.GT().ai(localau1.field_msgSvrId);
      }
    }
    if ((str1 == null) && (localau1.field_msgSvrId > 0L)) {
      str1 = ((com.tencent.mm.ah.d)localObject1).hER;
    }
    for (;;)
    {
      if ((localObject1 != null) && ((((com.tencent.mm.ah.d)localObject1).offset < ((com.tencent.mm.ah.d)localObject1).hrb) || (((com.tencent.mm.ah.d)localObject1).hrb == 0)) && (!this.wnQ))
      {
        locald1 = com.tencent.mm.ah.n.GT().ai(localau1.field_msgSvrId);
        int i;
        Object localObject2;
        long l1;
        long l2;
        boolean bool;
        if (localau1.field_isSend == 1) {
          if (locald1.GC())
          {
            i = 1;
            localObject1 = new PString();
            localObject2 = new PInt();
            PInt localPInt = new PInt();
            ((PString)localObject1).value = this.fyw;
            l1 = com.tencent.mm.ah.n.GT().a(this.fyw, i, paramInt, 0, (PString)localObject1, (PInt)localObject2, localPInt);
            com.tencent.mm.ah.d locald2 = com.tencent.mm.ah.n.GT().b(Long.valueOf(l1));
            locald2.fR(1);
            au localau2 = new au();
            localau2.setType(com.tencent.mm.u.o.fH(paramString));
            localau2.cH(paramString);
            localau2.dw(1);
            localau2.dv(1);
            localau2.cI(((PString)localObject1).value);
            localau2.dH(((PInt)localObject2).value);
            localau2.dI(localPInt.value);
            localau2.z(ay.gk(localau2.field_talker));
            if (com.tencent.mm.modelbiz.e.dr(localau2.field_talker)) {
              localau1.cN(com.tencent.mm.modelbiz.a.e.zz());
            }
            ap.yY();
            l2 = com.tencent.mm.u.c.wT().L(localau2);
            if (l2 < 0L) {
              break label624;
            }
            bool = true;
            label417:
            Assert.assertTrue(bool);
            v.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = " + l2);
            locald2.ag((int)l2);
            com.tencent.mm.ah.n.GT().a(Long.valueOf(l1), locald2);
            localObject1 = new HashMap();
            ((HashMap)localObject1).put(Long.valueOf(l2), locald1);
            localObject2 = com.tencent.mm.ah.n.GU();
            l1 = locald1.hEG;
            l2 = localau1.field_msgId;
            if (localau1.field_isSend != 1) {
              break label630;
            }
          }
        }
        label624:
        label630:
        for (int j = R.g.bdI;; j = R.g.bdG)
        {
          ((com.tencent.mm.ah.c)localObject2).a(l1, l2, i, localObject1, j, new com.tencent.mm.ah.c.a()
          {
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
            {
              GMTrace.i(3019227791360L, 22495);
              GMTrace.o(3019227791360L, 22495);
            }
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, com.tencent.mm.y.k paramAnonymousk)
            {
              GMTrace.i(3018959355904L, 22493);
              GMTrace.o(3018959355904L, 22493);
            }
            
            public final void a(long paramAnonymousLong1, long paramAnonymousLong2, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, int paramAnonymousInt3, int paramAnonymousInt4, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
            {
              GMTrace.i(3019093573632L, 22494);
              if ((paramAnonymousInt3 == 0) && (paramAnonymousInt4 == 0)) {}
              for (paramAnonymousInt1 = 1; (paramAnonymousObject instanceof HashMap); paramAnonymousInt1 = 0)
              {
                paramAnonymousObject = (HashMap)paramAnonymousObject;
                if (paramAnonymousObject == null) {
                  break;
                }
                paramAnonymousObject = ((HashMap)paramAnonymousObject).entrySet().iterator();
                while (((Iterator)paramAnonymousObject).hasNext())
                {
                  paramAnonymousk = (Map.Entry)((Iterator)paramAnonymousObject).next();
                  paramAnonymousString = (Long)paramAnonymousk.getKey();
                  paramAnonymousk = (com.tencent.mm.ah.d)paramAnonymousk.getValue();
                  MsgRetransmitUI.this.fyw = com.tencent.mm.ah.n.GT().m(com.tencent.mm.ah.e.c(paramAnonymousk), "", "");
                  if (paramAnonymousInt1 != 0)
                  {
                    ap.yY();
                    com.tencent.mm.u.c.wT().cB(paramAnonymousString.longValue());
                    MsgRetransmitUI.a(MsgRetransmitUI.this, paramString, paramInt, str2, str1, paramf);
                  }
                }
              }
              GMTrace.o(3019093573632L, 22494);
            }
          });
          GMTrace.o(3028354596864L, 22563);
          return;
          i = 0;
          break;
          if (!locald1.GC())
          {
            i = 0;
            break;
          }
          localObject1 = com.tencent.mm.ah.e.a(locald1);
          if (!com.tencent.mm.a.e.aO(com.tencent.mm.ah.n.GT().m(((com.tencent.mm.ah.d)localObject1).hEH, "", "")))
          {
            i = 0;
            break;
          }
          i = 1;
          break;
          bool = false;
          break label417;
        }
      }
      a(paramString, paramInt, str2, str1, paramf);
      GMTrace.o(3028354596864L, 22563);
      return;
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, com.tencent.mm.y.f paramf)
  {
    GMTrace.i(3028488814592L, 22564);
    String str;
    boolean bool;
    if (!bf.mA(this.fyw))
    {
      this.wnO = 1;
      this.wnP = 1;
      if (!Ur(this.fyw))
      {
        GMTrace.o(3028488814592L, 22564);
        return;
      }
      str = this.fyw;
      if (this.hEK == 0)
      {
        bool = true;
        if (!m.a(str, paramString1, bool)) {
          break label237;
        }
      }
      label237:
      for (this.hEK = 1;; this.hEK = 0)
      {
        long l = System.currentTimeMillis();
        com.tencent.mm.plugin.report.service.g.oSF.a(106L, 96L, 1L, false);
        this.wnL = new com.tencent.mm.ah.k(paramInt, paramString2, paramString1, this.fyw, this.hEK, paramf, 0, paramString3, "", true, R.g.bdI, this.wnS, this.hGC, this.fNS);
        if (this.wnK == 1) {
          this.wnL.GJ();
        }
        ap.vd().a(this.wnL, 0);
        this.wnM = true;
        v.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.hEK) });
        bm.zN().c(bm.hnE, null);
        GMTrace.o(3028488814592L, 22564);
        return;
        bool = false;
        break;
      }
    }
    if (this.wnQ)
    {
      this.wnO += 1;
      if (!Ur((String)this.wnN.get(0)))
      {
        GMTrace.o(3028488814592L, 22564);
        return;
      }
      str = (String)this.wnN.get(0);
      if (this.hEK != 0) {
        break label448;
      }
      bool = true;
      if (!m.a(str, paramString1, bool)) {
        break label454;
      }
    }
    label448:
    label454:
    for (this.hEK = 1;; this.hEK = 0)
    {
      v.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", new Object[] { Integer.valueOf(this.hEK) });
      this.wnL = new com.tencent.mm.ah.k(paramInt, paramString2, paramString1, (String)this.wnN.get(0), this.hEK, paramf, 0, paramString3, "", true, R.g.bdI);
      if (this.wnK == 1) {
        this.wnL.GJ();
      }
      this.wnM = true;
      ap.vd().a(this.wnL, 0);
      bm.zN().c(bm.hnE, null);
      GMTrace.o(3028488814592L, 22564);
      return;
      bool = false;
      break;
    }
  }
  
  private void a(final String paramString, final f.a parama, final byte[] paramArrayOfByte)
  {
    GMTrace.i(3027683508224L, 22558);
    v.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", new Object[] { paramString, parama.fCN });
    Object localObject3 = l.Mg(parama.fCN);
    final Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath != null)
      {
        localObject1 = localObject2;
        if (!((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath.equals(""))
        {
          ap.yY();
          localObject1 = l.W(com.tencent.mm.u.c.xn(), parama.title, parama.hhh);
          FileOp.p(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath, (String)localObject1);
          v.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", new Object[] { ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath, parama.title, localObject1, Boolean.valueOf(((com.tencent.mm.pluginsdk.model.app.b)localObject3).ayY()) });
        }
      }
    }
    localObject2 = f.a.a(parama);
    ((f.a)localObject2).hhj = 3;
    if ((bf.mA((String)localObject1)) && ((parama.hhk != 0) || (parama.hhg > 26214400)))
    {
      v.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", new Object[] { Integer.valueOf(parama.hhk), Integer.valueOf(parama.hhg) });
      ap.vd().a(new z(parama, null, paramString, new z.a()
      {
        public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, String paramAnonymousString5, long paramAnonymousLong)
        {
          GMTrace.i(3015469694976L, 22467);
          v.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", new Object[] { paramAnonymousString1, bf.Qi(paramAnonymousString2), bf.Qi(paramAnonymousString3), bf.Qi(parama.hhu), bf.Qi(paramAnonymousString4), bf.Qi(paramAnonymousString5) });
          if (!bf.mA(paramAnonymousString3))
          {
            l.a(localObject2, parama.appId, parama.appName, paramString, "", paramArrayOfByte, MsgRetransmitUI.a(MsgRetransmitUI.this), paramAnonymousString3);
            GMTrace.o(3015469694976L, 22467);
            return;
          }
          com.tencent.mm.ui.base.g.b(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(R.l.eaB), "", true);
          MsgRetransmitUI.this.finish();
          GMTrace.o(3015469694976L, 22467);
        }
      }), 0);
      GMTrace.o(3027683508224L, 22558);
      return;
    }
    l.a((f.a)localObject2, parama.appId, parama.appName, paramString, (String)localObject1, paramArrayOfByte, this.iCm);
    if (((f.a)localObject2).type == 36) {
      if (!paramString.endsWith("chatroom")) {
        break label464;
      }
    }
    label464:
    for (int i = 1;; i = 0)
    {
      parama = URLEncoder.encode(bf.mz(((f.a)localObject2).url));
      paramArrayOfByte = URLEncoder.encode(bf.mz(((f.a)localObject2).title));
      localObject1 = URLEncoder.encode(bf.mz(((f.a)localObject2).description));
      localObject3 = URLEncoder.encode(bf.mz(((f.a)localObject2).hjB));
      com.tencent.mm.plugin.report.service.g.oSF.i(14127, new Object[] { ((f.a)localObject2).appId, ((f.a)localObject2).hjC, localObject3, paramArrayOfByte, localObject1, "", parama, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), paramString });
      GMTrace.o(3027683508224L, 22558);
      return;
    }
  }
  
  private void bZQ()
  {
    GMTrace.i(3027280855040L, 22555);
    Object localObject6;
    switch (this.wnK)
    {
    default: 
      v.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", new Object[] { Integer.valueOf(this.wnK) });
      finish();
      GMTrace.o(3027280855040L, 22555);
      return;
    case 0: 
      int i;
      switch (this.msgType)
      {
      case 3: 
      default: 
        v.e("MicroMsg.MsgRetransmitUI", "unknown type %s", new Object[] { Integer.valueOf(this.msgType) });
      case 2: 
      case 6: 
      case 10: 
      case 12: 
      case 13: 
      case 14: 
      case 16: 
        i = 1;
      }
      final Object localObject2;
      boolean bool1;
      for (;;)
      {
        if (i != 0)
        {
          if ((this.msgType == 11) || (this.msgType == 1))
          {
            localObject1 = this.wnE;
            v.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
            if ((11 == this.msgType) && (t.lK(this.fyw)))
            {
              com.tencent.mm.ui.snackbar.a.c(this, getResources().getString(R.l.eRc), "");
              this.mHandler.postDelayed(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(3049024126976L, 22717);
                  MsgRetransmitUI.this.finish();
                  GMTrace.o(3049024126976L, 22717);
                }
              }, 1800L);
              GMTrace.o(3027280855040L, 22555);
              return;
              if (bZR()) {
                break;
              }
              finish();
              i = 0;
              continue;
              if ((this.fSi != null) && (!this.fSi.equals(""))) {
                break;
              }
              v.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
              finish();
              i = 0;
              continue;
              finish();
              i = 0;
              continue;
              if (!bZR())
              {
                finish();
                i = 0;
                continue;
              }
              if (this.fyw != null) {
                break;
              }
              v.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
              finish();
              i = 0;
              continue;
              if ((this.fSi != null) && (!this.fSi.equals(""))) {
                break;
              }
              v.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
              finish();
              i = 0;
              continue;
            }
            localObject3 = new b();
            ((b)localObject3).wor = new LinkedList();
            ((b)localObject3).wor.addAll((Collection)localObject1);
            localObject4 = ((List)localObject1).iterator();
            if (((Iterator)localObject4).hasNext())
            {
              localObject5 = (String)((Iterator)localObject4).next();
              localObject1 = new a();
              getString(R.l.dIG);
              this.isb = com.tencent.mm.ui.base.g.a(this, getString(R.l.dIt), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                {
                  GMTrace.i(3016543436800L, 22475);
                  localObject1.woj = true;
                  GMTrace.o(3016543436800L, 22475);
                }
              });
              ((a)localObject1).context = this;
              ((a)localObject1).fyw = this.fyw;
              ((a)localObject1).isG = this.isb;
              ((a)localObject1).wnJ = this.wnJ;
              ((a)localObject1).hZV = this.length;
              ((a)localObject1).hYh = this.msgType;
              ((a)localObject1).wol = false;
              ((a)localObject1).userName = ((String)localObject5);
              ((a)localObject1).wom = true;
              ((a)localObject1).wnH = this.wnH;
              ((a)localObject1).wop = ((b)localObject3);
              localObject2 = t.lI(this.fyw);
              if ((localObject2 != null) && (((r)localObject2).iae != null))
              {
                v.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
                ((a)localObject1).woo = ((r)localObject2).iae;
                ((a)localObject1).gxv = ((r)localObject2).Lf();
              }
              ((a)localObject1).execute(new Object[0]);
              bm.zN().c(bm.hnF, null);
              if (this.fGD != -1L)
              {
                ap.yY();
                localObject6 = com.tencent.mm.u.c.wT().cA(this.fGD);
                bool1 = com.tencent.mm.u.o.dH((String)localObject5);
                if (bool1)
                {
                  localObject1 = a.c.vvq;
                  if (!this.wnT) {
                    break label775;
                  }
                  localObject2 = a.d.vvu;
                  if (!bool1) {
                    break label783;
                  }
                }
                for (i = com.tencent.mm.u.j.eC((String)localObject5);; i = 0)
                {
                  com.tencent.mm.ui.chatting.a.a((a.c)localObject1, (a.d)localObject2, (au)localObject6, i);
                  break;
                  localObject1 = a.c.vvp;
                  break label732;
                  localObject2 = a.d.vvt;
                  break label744;
                }
              }
            }
            GMTrace.o(3027280855040L, 22555);
            return;
          }
          if (this.msgType == 0) {
            this.wnW = this.wnE.size();
          }
          i = this.wnE.size();
          localObject1 = this.wnE.iterator();
          bool1 = true;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            i -= 1;
            boolean bool2;
            if (i == 0)
            {
              bool2 = true;
              switch (this.msgType)
              {
              }
            }
            for (;;)
            {
              if (this.wnR) {
                ab.lc(bool2);
              }
              break;
              bool2 = false;
              break label873;
              ap.vL().bIY();
              ap.vL().D(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(3032917999616L, 22597);
                  v.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                  MsgRetransmitUI.a(MsgRetransmitUI.this, localObject2);
                  GMTrace.o(3032917999616L, 22597);
                }
              });
              continue;
              bool1 = Up((String)localObject2);
              continue;
              m.xL();
              localObject2 = new com.tencent.mm.modelmulti.j((String)localObject2, this.fSi, com.tencent.mm.u.o.fG((String)localObject2));
              ap.vd().a((com.tencent.mm.y.k)localObject2, 0);
              bool1 = true;
              continue;
              bool1 = bb((String)localObject2, false);
              continue;
              localObject3 = f.a.ek(bf.PW(this.fSi));
              if (localObject3 == null)
              {
                v.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
                bool1 = false;
              }
              else
              {
                a((String)localObject2, (f.a)localObject3, null);
                bool1 = true;
                continue;
                localObject2 = new com.tencent.mm.modelvoice.f(q.c((String)localObject2, this.fyw, this.length), 1);
                ap.vd().a((com.tencent.mm.y.k)localObject2, 0);
                bool1 = true;
                continue;
                localObject2 = new com.tencent.mm.modelmulti.j((String)localObject2, this.fSi, 42);
                ap.vd().a((com.tencent.mm.y.k)localObject2, 0);
                continue;
                localObject2 = new com.tencent.mm.modelmulti.j((String)localObject2, this.fSi, 48);
                ap.vd().a((com.tencent.mm.y.k)localObject2, 0);
                bool1 = true;
                continue;
                localObject3 = new lz();
                ((lz)localObject3).fSV.type = 4;
                localObject4 = ((lz)localObject3).fSV;
                ap.yY();
                ((lz.a)localObject4).fTa = com.tencent.mm.u.c.wT().cA(this.fGD);
                ((lz)localObject3).fSV.toUser = ((String)localObject2);
                com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
                continue;
                ab.l(this, (String)localObject2, bool2);
                continue;
                ab.k(this, (String)localObject2, bool2);
                continue;
                localObject3 = new of();
                ((of)localObject3).fVf.fEL = this.fGD;
                ((of)localObject3).fVf.fMX = this.fSi;
                ((of)localObject3).fVf.fMY = ((String)localObject2);
                com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject3);
              }
            }
          }
          localObject3 = (String)this.wnE.get(0);
          switch (this.msgType)
          {
          case 3: 
          case 15: 
          default: 
            finish();
          }
        }
      }
      GMTrace.o(3027280855040L, 22555);
      return;
      GMTrace.o(3027280855040L, 22555);
      return;
      if ((this.msgType == 2) || (this.msgType == 16))
      {
        localObject4 = f.a.ek(bf.PW(this.fSi));
        if ((localObject4 != null) && (((f.a)localObject4).type == 5) && (!bf.mA(((f.a)localObject4).url))) {
          localObject1 = "";
        }
      }
      else
      {
        try
        {
          localObject2 = URLEncoder.encode(((f.a)localObject4).url, "UTF-8");
          localObject1 = localObject2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            i = 2;
          }
        }
        if (bool1)
        {
          i = 1;
          v.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((f.a)localObject4).url, Long.valueOf(this.startTime), Integer.valueOf(this.wnX), Integer.valueOf(1), Integer.valueOf(i) });
          com.tencent.mm.plugin.report.service.g.oSF.i(13378, new Object[] { localObject1, Long.valueOf(this.startTime), Integer.valueOf(this.wnX), Integer.valueOf(1), Integer.valueOf(i) });
        }
      }
      while (bool1)
      {
        if (this.wnH) {
          com.tencent.mm.ui.snackbar.a.e(this, getString(R.l.esd));
        }
        if (this.wob) {
          this.mHandler.postDelayed(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(3014664388608L, 22461);
              MsgRetransmitUI.this.finish();
              GMTrace.o(3014664388608L, 22461);
            }
          }, 1800L);
        }
        if ((this.wnG) && (!this.wnU))
        {
          localObject1 = new Intent(this, En_5b8fbb1e.class);
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("Chat_User", (String)localObject3);
          startActivity((Intent)localObject1);
        }
        GMTrace.o(3027280855040L, 22555);
        return;
        if ((!bool1) && (localObject4 != null) && (((f.a)localObject4).type == 33))
        {
          localObject1 = new com.tencent.mm.e.a.o();
          ((com.tencent.mm.e.a.o)localObject1).fCC.scene = this.woa;
          if (2 == this.woa)
          {
            ((com.tencent.mm.e.a.o)localObject1).fCC.fCE = (this.wnZ + ":" + this.wnY);
            if (!((String)localObject3).endsWith("@chatroom")) {
              break label2024;
            }
          }
          for (((com.tencent.mm.e.a.o)localObject1).fCC.action = 2;; ((com.tencent.mm.e.a.o)localObject1).fCC.action = 1)
          {
            ((com.tencent.mm.e.a.o)localObject1).fCC.fCD = (((f.a)localObject4).hjJ + 1);
            ((com.tencent.mm.e.a.o)localObject1).fCC.fCF = ((f.a)localObject4).hjB;
            ((com.tencent.mm.e.a.o)localObject1).fCC.fCA = ((f.a)localObject4).hjC;
            ((com.tencent.mm.e.a.o)localObject1).fCC.appId = ((f.a)localObject4).hjD;
            ((com.tencent.mm.e.a.o)localObject1).fCC.fCG = "";
            ((com.tencent.mm.e.a.o)localObject1).fCC.fCH = bf.Nz();
            ((com.tencent.mm.e.a.o)localObject1).fCC.fCI = 2;
            com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
            break;
            ((com.tencent.mm.e.a.o)localObject1).fCC.fCE = this.wnZ;
            break label1893;
          }
        }
      }
      finish();
      GMTrace.o(3027280855040L, 22555);
      return;
    case 1: 
      label732:
      label744:
      label775:
      label783:
      label873:
      label1893:
      label2024:
      localObject1 = (String)this.wnE.get(0);
      if (!bZR())
      {
        finish();
        GMTrace.o(3027280855040L, 22555);
        return;
      }
      switch (this.msgType)
      {
      default: 
        v.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", new Object[] { Integer.valueOf(this.msgType) });
        GMTrace.o(3027280855040L, 22555);
        return;
      case 0: 
        if ((this.wnN != null) && (this.wnN.size() > 0)) {
          this.wnP = this.wnN.size();
        }
        this.hGb = new com.tencent.mm.y.f()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.y.k paramAnonymousk)
          {
            GMTrace.i(3016811872256L, 22477);
            if ((MsgRetransmitUI.b(MsgRetransmitUI.this) == null) || (paramAnonymousInt2 == 0))
            {
              GMTrace.o(3016811872256L, 22477);
              return;
            }
            paramAnonymousInt1 = (int)(paramAnonymousInt1 * 100L / paramAnonymousInt2);
            MsgRetransmitUI.b(MsgRetransmitUI.this).setMessage(MsgRetransmitUI.this.getString(R.l.eBs, new Object[] { Integer.valueOf(MsgRetransmitUI.c(MsgRetransmitUI.this)), Integer.valueOf(MsgRetransmitUI.d(MsgRetransmitUI.this)), Integer.valueOf(paramAnonymousInt1) }));
            GMTrace.o(3016811872256L, 22477);
          }
        };
        this.wnI = com.tencent.mm.ui.base.g.a(this, getString(R.l.eBs, new Object[] { Integer.valueOf(1), Integer.valueOf(this.wnP), Integer.valueOf(0) }), getString(R.l.dIG), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(3017348743168L, 22481);
            if (MsgRetransmitUI.b(MsgRetransmitUI.this) != null) {
              MsgRetransmitUI.b(MsgRetransmitUI.this).cancel();
            }
            GMTrace.o(3017348743168L, 22481);
          }
        });
        this.wnI.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(3038555144192L, 22639);
            com.tencent.mm.ui.base.g.a(MsgRetransmitUI.this, R.l.eBo, R.l.dIG, R.l.dIW, R.l.dHI, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(3055332360192L, 22764);
                com.tencent.mm.ah.f localf;
                com.tencent.mm.ah.d locald;
                if (MsgRetransmitUI.e(MsgRetransmitUI.this) != null)
                {
                  ap.vd().c(MsgRetransmitUI.e(MsgRetransmitUI.this));
                  paramAnonymous2Int = (int)MsgRetransmitUI.e(MsgRetransmitUI.this).hGc;
                  paramAnonymous2DialogInterface = com.tencent.mm.ah.n.GT().fT(paramAnonymous2Int);
                  if (paramAnonymous2DialogInterface != null)
                  {
                    localf = com.tencent.mm.ah.n.GT();
                    locald = localf.fT(paramAnonymous2Int);
                    if ((locald != null) && (locald.hEG == paramAnonymous2Int)) {
                      break label146;
                    }
                  }
                }
                for (;;)
                {
                  ap.yY();
                  com.tencent.mm.u.c.wT().cB(paramAnonymous2DialogInterface.hEO);
                  Toast.makeText(MsgRetransmitUI.this, R.l.eBp, 1).show();
                  MsgRetransmitUI.this.finish();
                  GMTrace.o(3055332360192L, 22764);
                  return;
                  label146:
                  FileOp.deleteFile(localf.m(locald.hEH, "", ""));
                  FileOp.deleteFile(localf.m(locald.hEJ, "", ""));
                  FileOp.deleteFile(localf.m(locald.hEJ, "", "") + "hd");
                  localf.hnp.delete("ImgInfo2", "id=?", new String[] { String.valueOf(paramAnonymous2Int) });
                  if (locald.GC())
                  {
                    locald = localf.fT(locald.hEQ);
                    if (locald != null)
                    {
                      FileOp.deleteFile(localf.m(locald.hEH, "", ""));
                      FileOp.deleteFile(localf.m(locald.hEJ, "", ""));
                      FileOp.deleteFile(localf.m(locald.hEJ, "", "") + "hd");
                      localf.hnp.delete("ImgInfo2", "id=?", new String[] { locald.hEG });
                    }
                  }
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                GMTrace.i(3039763103744L, 22648);
                if (MsgRetransmitUI.b(MsgRetransmitUI.this) != null) {
                  MsgRetransmitUI.b(MsgRetransmitUI.this).show();
                }
                GMTrace.o(3039763103744L, 22648);
              }
            });
            GMTrace.o(3038555144192L, 22639);
          }
        });
        this.wnI.setCanceledOnTouchOutside(false);
        this.wnI.getButton(-1).setText(R.l.dGk);
        a((String)localObject1, 6, this.hGb);
        GMTrace.o(3027280855040L, 22555);
        return;
      case 1: 
      case 11: 
        if (!com.tencent.mm.network.aa.bn(this))
        {
          com.tencent.mm.ui.base.g.a(this, R.l.eZZ, R.l.dIG, R.l.dHL, R.l.dGk, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(3014932824064L, 22463);
              MsgRetransmitUI.a(MsgRetransmitUI.this, MsgRetransmitUI.this.getIntent(), localObject1);
              GMTrace.o(3014932824064L, 22463);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(3045266030592L, 22689);
              MsgRetransmitUI.this.finish();
              GMTrace.o(3045266030592L, 22689);
            }
          });
          GMTrace.o(3027280855040L, 22555);
          return;
        }
        m(getIntent(), (String)localObject1);
        GMTrace.o(3027280855040L, 22555);
        return;
      }
      bb((String)localObject1, true);
      GMTrace.o(3027280855040L, 22555);
      return;
    }
    switch (this.msgType)
    {
    default: 
      GMTrace.o(3027280855040L, 22555);
      return;
    }
    this.wnE.get(0);
    final Object localObject1 = getIntent().getExtras().getString("_mmessage_appPackage");
    Object localObject3 = new com.tencent.mm.pluginsdk.model.app.f();
    ((com.tencent.mm.pluginsdk.model.app.f)localObject3).field_packageName = ((String)localObject1);
    an.aRk().b((com.tencent.mm.sdk.e.c)localObject3, new String[] { "packageName" });
    Object localObject5 = new SendMessageToWX.Req(getIntent().getExtras()).message;
    Object localObject4 = new c(new c.a()
    {
      public final void bZS()
      {
        GMTrace.i(3018154049536L, 22487);
        MsgRetransmitUI.this.finish();
        GMTrace.o(3018154049536L, 22487);
      }
    });
    if (((WXMediaMessage)localObject5).thumbData == null) {}
    for (localObject1 = null;; localObject1 = com.tencent.mm.sdk.platformtools.d.bd(((WXMediaMessage)localObject5).thumbData)) {
      switch (((WXMediaMessage)localObject5).mediaObject.type())
      {
      default: 
        v.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + ((WXMediaMessage)localObject5).mediaObject.type());
        GMTrace.o(3027280855040L, 22555);
        return;
      }
    }
    localObject1 = View.inflate(this, R.i.cUH, null);
    ((TextView)((View)localObject1).findViewById(R.h.cIY)).setText(((WXMediaMessage)localObject5).title);
    for (;;)
    {
      ((TextView)((View)localObject1).findViewById(R.h.cFT)).setText(com.tencent.mm.pluginsdk.model.app.g.a(this, (com.tencent.mm.pluginsdk.model.app.f)localObject3, null));
      ((c)localObject4).oGr = com.tencent.mm.ui.base.g.a(this, null, (View)localObject1, getString(R.l.dIs), getString(R.l.dGk), new c.1((c)localObject4), new c.2((c)localObject4));
      break;
      View localView = View.inflate(this, R.i.cUG, null);
      ((ImageView)localView.findViewById(R.h.cHU)).setImageBitmap((Bitmap)localObject1);
      ((TextView)localView.findViewById(R.h.cIY)).setText(((WXMediaMessage)localObject5).title);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.cUF, null);
      ((ImageView)localView.findViewById(R.h.cHU)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.cIY);
      localObject6 = (TextView)localView.findViewById(R.h.bHU);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.cUF, null);
      ((ImageView)localView.findViewById(R.h.cHU)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.cIY);
      localObject6 = (TextView)localView.findViewById(R.h.bHU);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.cUF, null);
      ((ImageView)localView.findViewById(R.h.cHU)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.cIY);
      localObject6 = (TextView)localView.findViewById(R.h.bHU);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.cUF, null);
      ((ImageView)localView.findViewById(R.h.cHU)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.cIY);
      localObject6 = (TextView)localView.findViewById(R.h.bHU);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
      continue;
      localView = View.inflate(this, R.i.cUF, null);
      ((ImageView)localView.findViewById(R.h.cHU)).setImageBitmap((Bitmap)localObject1);
      localObject1 = (TextView)localView.findViewById(R.h.cIY);
      localObject6 = (TextView)localView.findViewById(R.h.bHU);
      ((TextView)localObject1).setText(((WXMediaMessage)localObject5).title);
      ((TextView)localObject6).setText(((WXMediaMessage)localObject5).description);
      localObject1 = localView;
    }
  }
  
  private boolean bZR()
  {
    GMTrace.i(3027951943680L, 22560);
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      v.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
      s.eP(this);
      GMTrace.o(3027951943680L, 22560);
      return false;
    }
    GMTrace.o(3027951943680L, 22560);
    return true;
  }
  
  private boolean bb(String paramString, boolean paramBoolean)
  {
    GMTrace.i(3027817725952L, 22559);
    if (this.fyw == null)
    {
      GMTrace.o(3027817725952L, 22559);
      return false;
    }
    com.tencent.mm.storage.a.c localc = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX(this.fyw);
    int i;
    Object localObject;
    if (localc == null)
    {
      i = com.tencent.mm.a.e.aN(this.fyw);
      if (localc != null) {
        break label295;
      }
      localObject = this.fyw;
      label76:
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      if (((com.tencent.mm.sdk.platformtools.d.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.i.b.sB())) && (localOptions.outWidth <= com.tencent.mm.i.b.sB())) {
        break label612;
      }
    }
    label295:
    label605:
    label612:
    for (int j = 1;; j = 0)
    {
      if ((i > com.tencent.mm.i.b.sC()) || (j != 0))
      {
        if (localc == null) {}
        for (paramString = "fileName";; paramString = localc.EQ())
        {
          v.i("MicroMsg.MsgRetransmitUI", "emoji is over size. md5:%s size:%d", new Object[] { paramString, Integer.valueOf(this.length) });
          this.wob = false;
          this.wnH = false;
          com.tencent.mm.ui.base.g.a(this, getString(R.l.eco), "", getString(R.l.esi), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(3017885614080L, 22485);
              MsgRetransmitUI.this.finish();
              GMTrace.o(3017885614080L, 22485);
            }
          });
          if (this.wnS == 1) {
            com.tencent.mm.plugin.report.service.g.oSF.i(13459, new Object[] { Integer.valueOf(i), Integer.valueOf(1), localc.EQ(), Integer.valueOf(1) });
          }
          GMTrace.o(3027817725952L, 22559);
          return true;
          i = com.tencent.mm.a.e.aN(localc.eN(localc.field_groupId, localc.EQ()));
          break;
          localObject = localc.eN(localc.field_groupId, localc.EQ());
          break label76;
        }
      }
      if (this.wnS == 1) {
        com.tencent.mm.plugin.report.service.g.oSF.i(13459, new Object[] { Integer.valueOf(i), Integer.valueOf(0), localc.EQ(), Integer.valueOf(1) });
      }
      if (paramBoolean)
      {
        if (localc != null) {
          break label605;
        }
        localObject = new WXMediaMessage(new WXEmojiObject(this.fyw));
        localObject = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(getApplicationContext(), (WXMediaMessage)localObject, "");
      }
      for (localObject = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().tX((String)localObject);; localObject = localc)
      {
        com.tencent.mm.plugin.report.service.g.oSF.i(13459, new Object[] { Integer.valueOf(i), Integer.valueOf(0), ((com.tencent.mm.storage.a.c)localObject).EQ(), Integer.valueOf(2) });
        com.tencent.mm.ui.chatting.aa.b((com.tencent.mm.storage.a.c)localObject, paramString);
        finish();
        GMTrace.o(3027817725952L, 22559);
        return true;
        if ((localc != null) && (i > com.tencent.mm.i.b.sA()))
        {
          com.tencent.mm.ui.chatting.aa.b(localc, paramString);
          GMTrace.o(3027817725952L, 22559);
          return true;
        }
        if (((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().l(this, paramString, this.fyw))
        {
          GMTrace.o(3027817725952L, 22559);
          return true;
        }
        v.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
        GMTrace.o(3027817725952L, 22559);
        return false;
      }
    }
  }
  
  private static boolean bq(byte[] paramArrayOfByte)
  {
    GMTrace.i(3028757250048L, 22566);
    v.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d], scene:%d", new Object[] { Byte.valueOf(paramArrayOfByte[0]), Byte.valueOf(paramArrayOfByte[1]), Byte.valueOf(paramArrayOfByte[2]), Byte.valueOf(paramArrayOfByte[3]), Byte.valueOf(paramArrayOfByte[4]), Integer.valueOf(6) });
    MMBitmapFactory.DecodeResultLogger localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
    if ((!MMBitmapFactory.checkIsImageLegal(paramArrayOfByte, localDecodeResultLogger)) && (localDecodeResultLogger.getDecodeResult() >= 2000))
    {
      v.w("MicroMsg.MsgRetransmitUI", "try to send illegal image.");
      paramArrayOfByte = MMBitmapFactory.KVStatHelper.getKVStatString(paramArrayOfByte, 6, localDecodeResultLogger);
      com.tencent.mm.plugin.report.service.g.oSF.A(12712, paramArrayOfByte);
      GMTrace.o(3028757250048L, 22566);
      return false;
    }
    GMTrace.o(3028757250048L, 22566);
    return true;
  }
  
  private void m(Intent paramIntent, String paramString)
  {
    GMTrace.i(3028086161408L, 22561);
    if (this.wnQ)
    {
      this.wnP = this.wnN.size();
      paramIntent = paramIntent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          paramIntent.next();
          if (this.woc) {
            break;
          }
          Uq(paramString);
        }
        GMTrace.o(3028086161408L, 22561);
        return;
      }
      finish();
      GMTrace.o(3028086161408L, 22561);
      return;
    }
    this.wnP = 1;
    Uq(paramString);
    GMTrace.o(3028086161408L, 22561);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
  {
    GMTrace.i(3028891467776L, 22567);
    if ((paramk.getType() != 110) || (!(paramk instanceof com.tencent.mm.ah.k)))
    {
      GMTrace.o(3028891467776L, 22567);
      return;
    }
    paramString = (com.tencent.mm.ah.k)paramk;
    Object localObject;
    if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false))
    {
      paramk = getIntent().getStringExtra("Retr_KSnsId");
      if (!com.tencent.mm.u.o.dH(paramString.fUR)) {
        break label201;
      }
      localObject = new ou();
      ((ou)localObject).fVE.fVz = paramk;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    }
    while ((this.wnN != null) && (this.wnN.size() > 1))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this, getString(R.l.eBq, new Object[] { this.wnN.get(0) }), 1).show();
      }
      this.wnN.remove(0);
      a(paramString.fUR, 3, this.hGb);
      GMTrace.o(3028891467776L, 22567);
      return;
      label201:
      localObject = new ov();
      ((ov)localObject).fVF.fVz = paramk;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    }
    if (this.wnI != null)
    {
      this.wnI.dismiss();
      this.wnI = null;
    }
    this.wnW -= 1;
    if ((this.wnW <= 0) || (!this.wnV))
    {
      this.wnM = false;
      ap.vd().b(110, this);
      if (this.wnK != 0)
      {
        if ((this.wnG) && (!this.wnU))
        {
          paramk = new Intent(this, En_5b8fbb1e.class);
          paramk.addFlags(67108864);
          paramk.putExtra("Chat_User", paramString.fUR);
          startActivity(paramk);
        }
        finish();
      }
    }
    GMTrace.o(3028891467776L, 22567);
  }
  
  public void finish()
  {
    GMTrace.i(3027012419584L, 22553);
    super.finish();
    overridePendingTransition(0, 0);
    GMTrace.o(3027012419584L, 22553);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(3027415072768L, 22556);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      Object localObject = f.a.ek(bf.PW(this.fSi));
      if ((localObject != null) && (((f.a)localObject).type == 5) && (((f.a)localObject).url != null))
      {
        v.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), ((f.a)localObject).url, Long.valueOf(this.startTime), Integer.valueOf(this.wnX), Integer.valueOf(1), Integer.valueOf(3) });
        paramIntent = "";
        try
        {
          localObject = URLEncoder.encode(((f.a)localObject).url, "UTF-8");
          paramIntent = (Intent)localObject;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.MsgRetransmitUI", localUnsupportedEncodingException, "", new Object[0]);
          }
        }
        com.tencent.mm.plugin.report.service.g.oSF.i(13378, new Object[] { paramIntent, Long.valueOf(this.startTime), Integer.valueOf(this.wnX), Integer.valueOf(1), Integer.valueOf(3) });
      }
      while ((localUnsupportedEncodingException == null) || (localUnsupportedEncodingException.type != 33))
      {
        finish();
        GMTrace.o(3027415072768L, 22556);
        return;
      }
      paramIntent = new com.tencent.mm.e.a.o();
      paramIntent.fCC.scene = this.woa;
      if (2 == this.woa) {}
      for (paramIntent.fCC.fCE = (this.wnZ + ":" + this.wnY);; paramIntent.fCC.fCE = this.wnZ)
      {
        paramIntent.fCC.fCD = (localUnsupportedEncodingException.hjJ + 1);
        paramIntent.fCC.fCF = localUnsupportedEncodingException.hjB;
        paramIntent.fCC.fCA = localUnsupportedEncodingException.hjC;
        paramIntent.fCC.appId = localUnsupportedEncodingException.hjD;
        paramIntent.fCC.action = 1;
        paramIntent.fCC.fCG = "";
        paramIntent.fCC.fCH = bf.Nz();
        paramIntent.fCC.fCI = 3;
        com.tencent.mm.sdk.b.a.uql.m(paramIntent);
        break;
      }
    }
    if (paramInt1 != 0)
    {
      v.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = " + paramInt1);
      GMTrace.o(3027415072768L, 22556);
      return;
    }
    this.wnE = bf.f(paramIntent.getStringExtra("Select_Conv_User").split(","));
    String str1 = paramIntent.getStringExtra("custom_send_text");
    this.sLe = paramIntent.getBooleanExtra("key_is_biz_chat", false);
    if (this.sLe) {
      this.jZq = paramIntent.getLongExtra("key_biz_chat_id", -1L);
    }
    paramInt1 = paramIntent.getIntExtra("Retr_Msg_Type", -1);
    if (paramInt1 != -1)
    {
      v.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(paramInt1) });
      this.msgType = paramInt1;
    }
    v.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", new Object[] { Integer.valueOf(this.msgType), Integer.valueOf(this.wnK), Integer.valueOf(this.wnE.size()) });
    bZQ();
    if (!TextUtils.isEmpty(str1))
    {
      paramIntent = this.wnE.iterator();
      while (paramIntent.hasNext())
      {
        String str2 = (String)paramIntent.next();
        nv localnv = new nv();
        localnv.fUQ.fUR = str2;
        localnv.fUQ.content = str1;
        localnv.fUQ.type = com.tencent.mm.u.o.fG(str2);
        localnv.fUQ.flags = 0;
        com.tencent.mm.sdk.b.a.uql.m(localnv);
      }
    }
    GMTrace.o(3027415072768L, 22556);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3026878201856L, 22552);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    x.a(getWindow());
    v.i("MicroMsg.MsgRetransmitUI", "on activity create");
    this.startTime = bf.Nz();
    this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
    this.fSi = getIntent().getStringExtra("Retr_Msg_content");
    this.fGD = getIntent().getLongExtra("Retr_Msg_Id", -1L);
    this.fyw = getIntent().getStringExtra("Retr_File_Name");
    this.wnN = getIntent().getStringArrayListExtra("Retr_File_Path_List");
    boolean bool;
    if ((this.wnN != null) && (this.wnN.size() > 0))
    {
      bool = true;
      this.wnQ = bool;
      this.hEK = getIntent().getIntExtra("Retr_Compress_Type", 0);
      this.wnK = getIntent().getIntExtra("Retr_Scene", 0);
      this.length = getIntent().getIntExtra("Retr_length", 0);
      this.wnJ = getIntent().getIntExtra("Retr_video_isexport", 0);
      this.wnF = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.wnG = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
      this.wnU = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
      paramBundle = getIntent();
      if (this.wnK != 0) {
        break label742;
      }
      bool = true;
      label260:
      this.wnV = paramBundle.getBooleanExtra("Multi_Retr", bool);
      if (this.wnV) {
        this.wnU = true;
      }
      this.wnH = getIntent().getBooleanExtra("Retr_show_success_tips", this.wnU);
      this.wnR = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
      this.vuS = getIntent().getBooleanExtra("is_group_chat", false);
      this.vBh = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.fKq = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
      this.wnS = getIntent().getIntExtra("Retr_MsgImgScene", 0);
      this.hGC = getIntent().getFloatExtra("Retr_Longtitude", -1000.0F);
      this.fNS = getIntent().getFloatExtra("Retr_Latitude", -1000.0F);
      this.hGD = getIntent().getStringExtra("Retr_AttachedContent");
      this.wnT = "gallery".equals(getIntent().getStringExtra("Retr_From"));
      this.iCm = getIntent().getStringExtra("reportSessionId");
      this.wnX = getIntent().getIntExtra("Retr_MsgFromScene", 0);
      this.wnY = getIntent().getStringExtra("Retr_MsgFromUserName");
      this.wnZ = getIntent().getStringExtra("Retr_MsgTalker");
      this.woa = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
      ap.vd().a(110, this);
      if (!com.tencent.mm.compatible.util.d.eo(19)) {
        setContentView(R.i.cVH);
      }
      paramBundle = new Intent(this, SelectConversationUI.class);
      paramBundle.putExtra("scene", 8);
      paramBundle.putExtra("select_is_ret", true);
      if (this.wnV) {
        paramBundle.putExtra("mutil_select_is_ret", true);
      }
      switch (this.msgType)
      {
      case 3: 
      case 4: 
      case 5: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      default: 
        paramBundle.putExtra("Select_Conv_Type", 3);
      }
    }
    for (;;)
    {
      paramBundle.putExtra("Retr_Msg_Type", this.msgType);
      paramBundle.putExtra("Retr_Msg_Id", this.fGD);
      paramBundle.putExtra("Retr_Msg_content", this.fSi);
      paramBundle.putExtra("image_path", this.fyw);
      startActivityForResult(paramBundle, 0);
      GMTrace.o(3026878201856L, 22552);
      return;
      bool = false;
      break;
      label742:
      bool = false;
      break label260;
      paramBundle.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
      paramBundle.putExtra("Select_Conv_Type", 3);
      continue;
      paramBundle.putExtra("Select_Conv_Type", 11);
    }
  }
  
  protected void onDestroy()
  {
    GMTrace.i(3027146637312L, 22554);
    if (!this.wnM) {
      ap.vd().b(110, this);
    }
    super.onDestroy();
    GMTrace.o(3027146637312L, 22554);
  }
  
  public static final class a
    extends AsyncTask<Object, Object, String>
  {
    public Context context;
    public String fUO;
    public String fyw;
    public String gxv;
    public int hYh;
    public int hZV;
    public Dialog isG;
    private ad mHandler;
    public String userName;
    public boolean wnH;
    public int wnJ;
    public boolean woj;
    public String wok;
    public boolean wol;
    public boolean wom;
    public boolean won;
    public bdq woo;
    public MsgRetransmitUI.b wop;
    
    public a()
    {
      GMTrace.i(3044729159680L, 22685);
      this.wol = true;
      this.wom = false;
      this.wnH = false;
      this.won = true;
      this.woo = null;
      this.wop = null;
      this.mHandler = new ad();
      GMTrace.o(3044729159680L, 22685);
    }
  }
  
  private static final class b
  {
    boolean fFa;
    public List<String> wor;
    
    public b()
    {
      GMTrace.i(3012919558144L, 22448);
      this.wor = null;
      this.fFa = true;
      GMTrace.o(3012919558144L, 22448);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/transmit/MsgRetransmitUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */