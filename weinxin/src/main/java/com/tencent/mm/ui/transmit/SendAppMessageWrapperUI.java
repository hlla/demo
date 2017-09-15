package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.k.a;
import com.tencent.mm.protocal.c.bpr;
import com.tencent.mm.protocal.c.bps;
import com.tencent.mm.protocal.c.bqb;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import com.tencent.mm.y.u.a;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public class SendAppMessageWrapperUI
  extends MMActivity
{
  private String aJE;
  private ai fyz;
  private int lFM;
  private int scene;
  private String toUser;
  private WXMediaMessage vFn;
  private f woW;
  private boolean woX;
  
  public SendAppMessageWrapperUI()
  {
    GMTrace.i(3049829433344L, 22723);
    this.aJE = null;
    this.woW = null;
    this.toUser = null;
    this.vFn = null;
    this.scene = 0;
    this.woX = false;
    this.lFM = 0;
    this.fyz = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(3015738130432L, 22469);
        if ((SendAppMessageWrapperUI.this.getWindow() == null) || (SendAppMessageWrapperUI.this.getWindow().getDecorView() == null) || (SendAppMessageWrapperUI.this.getWindow().getDecorView().getWindowToken() == null))
        {
          if (SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this) < 10)
          {
            SendAppMessageWrapperUI.b(SendAppMessageWrapperUI.this);
            GMTrace.o(3015738130432L, 22469);
            return true;
          }
          GMTrace.o(3015738130432L, 22469);
          return false;
        }
        SendAppMessageWrapperUI.c(SendAppMessageWrapperUI.this);
        GMTrace.o(3015738130432L, 22469);
        return false;
      }
    }, true);
    GMTrace.o(3049829433344L, 22723);
  }
  
  private k.a a(final WXMediaMessage paramWXMediaMessage)
  {
    GMTrace.i(17933904379904L, 133618);
    paramWXMediaMessage = new k.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        GMTrace.i(3038018273280L, 22635);
        if (paramAnonymousBoolean)
        {
          SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this, paramWXMediaMessage, paramAnonymousString, paramAnonymousInt);
          GMTrace.o(3038018273280L, 22635);
          return;
        }
        SendAppMessageWrapperUI.d(SendAppMessageWrapperUI.this);
        GMTrace.o(3038018273280L, 22635);
      }
    };
    GMTrace.o(17933904379904L, 133618);
    return paramWXMediaMessage;
  }
  
  private void a(final WXMediaMessage paramWXMediaMessage, final LinkedList<String> paramLinkedList)
  {
    GMTrace.i(17934038597632L, 133619);
    WXMiniProgramObject localWXMiniProgramObject = (WXMiniProgramObject)paramWXMediaMessage.mediaObject;
    final Object localObject1 = new StringBuilder("1_");
    ((StringBuilder)localObject1).append(this.woW.field_appId);
    ((StringBuilder)localObject1).append("_");
    ap.yY();
    ((StringBuilder)localObject1).append(o.getString(c.uH()));
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(bf.Nz());
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append("1");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2;
    Object localObject3;
    if (localWXMiniProgramObject.withShareTicket)
    {
      localObject2 = new b.a();
      ((b.a)localObject2).hrU = 1118;
      ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
      localObject3 = new bpr();
      ((bpr)localObject3).fTE = this.woW.field_appId;
      ((bpr)localObject3).umk = paramLinkedList;
      ((b.a)localObject2).hrV = ((com.tencent.mm.bd.a)localObject3);
      ((b.a)localObject2).hrW = new bps();
      u.a(((b.a)localObject2).BE(), new u.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, k paramAnonymousk)
        {
          GMTrace.i(17930683154432L, 133594);
          v.i("MicroMsg.SendAppMessageWrapperUI", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousString = (bps)paramAnonymousb.hrT.hsa;
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null) && (paramAnonymousString.uml != null))
          {
            if (paramAnonymousString.uml == null)
            {
              paramAnonymousString = new LinkedList();
              v.i("MicroMsg.SendAppMessageWrapperUI", "get wxaAppShareInfoList size = %d, toUserList size = %d", new Object[] { Integer.valueOf(paramAnonymousString.size()), Integer.valueOf(paramLinkedList.size()) });
              paramAnonymousInt1 = 0;
              label119:
              if (paramAnonymousInt1 >= paramLinkedList.size()) {
                break label324;
              }
              if (paramAnonymousInt1 >= paramAnonymousString.size()) {
                break label248;
              }
            }
            label248:
            for (paramAnonymousb = (bqb)paramAnonymousString.get(paramAnonymousInt1);; paramAnonymousb = new bqb())
            {
              paramAnonymousk = new f.a();
              paramAnonymousk.appId = SendAppMessageWrapperUI.e(SendAppMessageWrapperUI.this).field_appId;
              paramAnonymousk.appName = SendAppMessageWrapperUI.e(SendAppMessageWrapperUI.this).field_appName;
              paramAnonymousk.hhj = 2;
              paramAnonymousk.hjI = paramAnonymousb.umJ;
              paramAnonymousk.hjH = localObject1;
              l.a(paramAnonymousk, paramWXMediaMessage, (String)paramLinkedList.get(paramAnonymousInt1));
              paramAnonymousInt1 += 1;
              break label119;
              paramAnonymousString = paramAnonymousString.uml;
              break;
            }
          }
          else
          {
            paramAnonymousString = paramLinkedList.iterator();
            while (paramAnonymousString.hasNext())
            {
              paramAnonymousb = (String)paramAnonymousString.next();
              l.a(paramWXMediaMessage, SendAppMessageWrapperUI.e(SendAppMessageWrapperUI.this).field_appId, SendAppMessageWrapperUI.e(SendAppMessageWrapperUI.this).field_appName, paramAnonymousb, 2, null, null);
            }
          }
          label324:
          GMTrace.o(17930683154432L, 133594);
          return 0;
        }
      });
      paramLinkedList = paramLinkedList.iterator();
      label209:
      if (!paramLinkedList.hasNext()) {
        break label450;
      }
      localObject1 = (String)paramLinkedList.next();
      if (!((String)localObject1).endsWith("chatroom")) {
        break label445;
      }
    }
    label445:
    for (int i = 1;; i = 0)
    {
      localObject2 = p.encode(bf.mz(localWXMiniProgramObject.webpageUrl));
      localObject3 = p.encode(bf.mz(paramWXMediaMessage.title));
      String str1 = p.encode(bf.mz(paramWXMediaMessage.description));
      String str2 = p.encode(bf.mz(localWXMiniProgramObject.path));
      g.oSF.i(14127, new Object[] { this.woW.field_appId, localWXMiniProgramObject.userName, str2, localObject3, str1, "", localObject2, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), localObject1 });
      break label209;
      localObject1 = paramLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        l.a(paramWXMediaMessage, this.woW.field_appId, this.woW.field_appName, (String)localObject2, 2, null, null);
      }
      break;
    }
    label450:
    GMTrace.o(17934038597632L, 133619);
  }
  
  private void lK(boolean paramBoolean)
  {
    GMTrace.i(14676305903616L, 109347);
    Intent localIntent = com.tencent.mm.modelsns.a.a(this.vFn, this.woW.field_appId, this.woW.field_appName);
    if (localIntent == null)
    {
      finish();
      GMTrace.o(14676305903616L, 109347);
      return;
    }
    String str = null;
    if ((this.vFn.getType() == 5) || (this.vFn.getType() == 2) || (this.vFn.getType() == 38))
    {
      v.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", new Object[] { this.woW.field_appId });
      str = q.fQ("app_" + this.woW.field_appId);
      q.b localb = q.yC().n(str, true);
      localb.l("prePublishId", "app_" + this.woW.field_appId);
      if ((this.vFn.mediaObject instanceof WXWebpageObject)) {
        localb.l("url", ((WXWebpageObject)this.vFn.mediaObject).webpageUrl);
      }
    }
    localIntent.putExtra("reportSessionId", str);
    if (!paramBoolean)
    {
      d.b(this, "sns", ".ui.En_c4f742e5", localIntent);
      GMTrace.o(14676305903616L, 109347);
      return;
    }
    d.b(this, "sns", ".ui.En_c4f742e5", localIntent, 1);
    GMTrace.o(14676305903616L, 109347);
  }
  
  protected final void KD()
  {
    GMTrace.i(3050634739712L, 22729);
    GMTrace.o(3050634739712L, 22729);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3050768957440L, 22730);
    GMTrace.o(3050768957440L, 22730);
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(3050097868800L, 22725);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    v.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + paramInt1 + " resultCode " + paramInt2);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1) {
        ReportUtil.a(this, ReportUtil.b(getIntent().getExtras(), 0));
      }
      for (;;)
      {
        finish();
        GMTrace.o(3050097868800L, 22725);
        return;
        ReportUtil.a(this, ReportUtil.b(getIntent().getExtras(), -2));
      }
    }
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      WXVideoFileObject localWXVideoFileObject = (WXVideoFileObject)this.vFn.mediaObject;
      localWXVideoFileObject.filePath = paramIntent.getStringExtra("K_SEGMENTVIDEOPATH");
      if ((bf.mA(localWXVideoFileObject.filePath)) || (!e.aO(localWXVideoFileObject.filePath))) {
        break label182;
      }
      lK(false);
    }
    for (;;)
    {
      finish();
      GMTrace.o(3050097868800L, 22725);
      return;
      label182:
      setResult(-5);
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc2_w 883
    //   3: sipush 22724
    //   6: invokestatic 45	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 886	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   14: aload_0
    //   15: invokevirtual 891	android/support/v7/app/AppCompatActivity:cO	()Landroid/support/v7/app/d;
    //   18: invokevirtual 897	android/support/v7/app/d:cP	()Landroid/support/v7/app/ActionBar;
    //   21: invokevirtual 902	android/support/v7/app/ActionBar:hide	()V
    //   24: aload_0
    //   25: invokestatic 907	com/tencent/mm/sdk/platformtools/aa:bIN	()Ljava/lang/String;
    //   28: iconst_0
    //   29: invokevirtual 911	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   32: astore_1
    //   33: aload_1
    //   34: ldc_w 913
    //   37: iconst_0
    //   38: invokeinterface 919 3 0
    //   43: ifne +43 -> 86
    //   46: ldc_w 275
    //   49: ldc_w 921
    //   52: invokestatic 444	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 57	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:woX	Z
    //   60: aload_0
    //   61: iconst_m1
    //   62: invokevirtual 924	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:setRequestedOrientation	(I)V
    //   65: aload_1
    //   66: invokeinterface 928 1 0
    //   71: ldc_w 913
    //   74: iconst_1
    //   75: invokeinterface 934 3 0
    //   80: invokeinterface 937 1 0
    //   85: pop
    //   86: aload_0
    //   87: invokevirtual 482	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getIntent	()Landroid/content/Intent;
    //   90: invokevirtual 488	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   93: astore 5
    //   95: new 939	com/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req
    //   98: dup
    //   99: aload 5
    //   101: invokespecial 941	com/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req:<init>	(Landroid/os/Bundle;)V
    //   104: astore 4
    //   106: aload_0
    //   107: aload 5
    //   109: ldc_w 696
    //   112: invokevirtual 943	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: putfield 51	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:toUser	Ljava/lang/String;
    //   118: aload_0
    //   119: aload 5
    //   121: ldc_w 945
    //   124: iconst_0
    //   125: invokevirtual 946	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   128: putfield 55	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:scene	I
    //   131: aload 5
    //   133: ldc_w 948
    //   136: invokevirtual 943	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_3
    //   140: aload_3
    //   141: astore_1
    //   142: aload_3
    //   143: ifnonnull +21 -> 164
    //   146: aload 5
    //   148: ldc_w 950
    //   151: invokevirtual 943	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokestatic 956	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   157: ldc_w 958
    //   160: invokevirtual 961	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore_1
    //   164: aload_0
    //   165: new 105	com/tencent/mm/pluginsdk/model/app/f
    //   168: dup
    //   169: invokespecial 962	com/tencent/mm/pluginsdk/model/app/f:<init>	()V
    //   172: putfield 49	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:woW	Lcom/tencent/mm/pluginsdk/model/app/f;
    //   175: aload_0
    //   176: getfield 49	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:woW	Lcom/tencent/mm/pluginsdk/model/app/f;
    //   179: aload_1
    //   180: putfield 108	com/tencent/mm/pluginsdk/model/app/f:field_appId	Ljava/lang/String;
    //   183: invokestatic 968	com/tencent/mm/pluginsdk/model/app/an:aRk	()Lcom/tencent/mm/pluginsdk/model/app/i;
    //   186: aload_0
    //   187: getfield 49	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:woW	Lcom/tencent/mm/pluginsdk/model/app/f;
    //   190: iconst_0
    //   191: anewarray 211	java/lang/String
    //   194: invokevirtual 973	com/tencent/mm/pluginsdk/model/app/i:b	(Lcom/tencent/mm/sdk/e/c;[Ljava/lang/String;)Z
    //   197: pop
    //   198: aload_0
    //   199: getfield 49	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:woW	Lcom/tencent/mm/pluginsdk/model/app/f;
    //   202: getfield 263	com/tencent/mm/pluginsdk/model/app/f:field_appName	Ljava/lang/String;
    //   205: ifnonnull +104 -> 309
    //   208: aload_0
    //   209: getstatic 976	com/tencent/mm/R$l:dXh	I
    //   212: invokevirtual 412	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getString	(I)Ljava/lang/String;
    //   215: astore_1
    //   216: aload_0
    //   217: aload_0
    //   218: getstatic 979	com/tencent/mm/R$l:dXf	I
    //   221: iconst_1
    //   222: anewarray 246	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload_1
    //   228: aastore
    //   229: invokevirtual 440	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   232: putfield 47	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:aJE	Ljava/lang/String;
    //   235: aload_0
    //   236: aload 4
    //   238: getfield 982	com/tencent/mm/opensdk/modelmsg/SendMessageToWX$Req:message	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   241: putfield 53	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vFn	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   244: ldc_w 275
    //   247: ldc_w 984
    //   250: iconst_2
    //   251: anewarray 246	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_0
    //   257: getfield 53	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vFn	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   260: getfield 987	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:messageAction	Ljava/lang/String;
    //   263: aastore
    //   264: dup
    //   265: iconst_1
    //   266: aload_0
    //   267: getfield 53	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vFn	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   270: getfield 990	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:messageExt	Ljava/lang/String;
    //   273: aastore
    //   274: invokestatic 992	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: aload_0
    //   278: getfield 55	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:scene	I
    //   281: iconst_1
    //   282: if_icmpne +980 -> 1262
    //   285: aload_0
    //   286: getfield 53	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vFn	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   289: getfield 94	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   292: ifnonnull +36 -> 328
    //   295: aload_0
    //   296: invokevirtual 500	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:finish	()V
    //   299: ldc2_w 883
    //   302: sipush 22724
    //   305: invokestatic 72	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   308: return
    //   309: aload_0
    //   310: getfield 738	com/tencent/mm/ui/MMActivity:uRf	Lcom/tencent/mm/ui/l;
    //   313: getfield 560	com/tencent/mm/ui/l:uRz	Landroid/support/v7/app/ActionBarActivity;
    //   316: aload_0
    //   317: getfield 49	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:woW	Lcom/tencent/mm/pluginsdk/model/app/f;
    //   320: aconst_null
    //   321: invokestatic 995	com/tencent/mm/pluginsdk/model/app/g:a	(Landroid/content/Context;Lcom/tencent/mm/pluginsdk/model/app/f;Ljava/lang/String;)Ljava/lang/String;
    //   324: astore_1
    //   325: goto -109 -> 216
    //   328: aload_0
    //   329: getfield 53	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vFn	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   332: invokevirtual 295	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:getType	()I
    //   335: bipush 38
    //   337: if_icmpne +156 -> 493
    //   340: aload_0
    //   341: getfield 53	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vFn	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   344: getfield 94	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   347: checkcast 861	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject
    //   350: astore_1
    //   351: aload_1
    //   352: getfield 869	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject:filePath	Ljava/lang/String;
    //   355: astore 5
    //   357: aload_1
    //   358: getfield 869	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject:filePath	Ljava/lang/String;
    //   361: invokestatic 704	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   364: ifne +384 -> 748
    //   367: aload_1
    //   368: getfield 869	com/tencent/mm/opensdk/modelmsg/WXVideoFileObject:filePath	Ljava/lang/String;
    //   371: invokestatic 874	com/tencent/mm/a/e:aO	(Ljava/lang/String;)Z
    //   374: ifeq +374 -> 748
    //   377: new 997	android/media/MediaMetadataRetriever
    //   380: dup
    //   381: invokespecial 998	android/media/MediaMetadataRetriever:<init>	()V
    //   384: astore_3
    //   385: aload_3
    //   386: astore_1
    //   387: aload_3
    //   388: aload 5
    //   390: invokevirtual 1001	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   393: aload_3
    //   394: astore_1
    //   395: aload_3
    //   396: bipush 9
    //   398: invokevirtual 1004	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   401: iconst_m1
    //   402: invokestatic 358	com/tencent/mm/sdk/platformtools/bf:getInt	(Ljava/lang/String;I)I
    //   405: istore_2
    //   406: aload_3
    //   407: astore_1
    //   408: ldc_w 275
    //   411: ldc_w 1006
    //   414: iconst_1
    //   415: anewarray 246	java/lang/Object
    //   418: dup
    //   419: iconst_0
    //   420: iload_2
    //   421: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   424: aastore
    //   425: invokestatic 992	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   428: iload_2
    //   429: sipush 10500
    //   432: if_icmplt +17 -> 449
    //   435: aload_3
    //   436: astore_1
    //   437: aload_0
    //   438: bipush -5
    //   440: invokevirtual 878	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:setResult	(I)V
    //   443: aload_3
    //   444: astore_1
    //   445: aload_0
    //   446: invokevirtual 500	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:finish	()V
    //   449: aload_3
    //   450: invokevirtual 1009	android/media/MediaMetadataRetriever:release	()V
    //   453: new 484	android/content/Intent
    //   456: dup
    //   457: invokespecial 795	android/content/Intent:<init>	()V
    //   460: astore_1
    //   461: aload_1
    //   462: ldc_w 863
    //   465: aload 5
    //   467: invokevirtual 831	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   470: pop
    //   471: aload_1
    //   472: ldc_w 1011
    //   475: ldc -5
    //   477: invokevirtual 831	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   480: pop
    //   481: aload_0
    //   482: ldc_w 1013
    //   485: ldc_w 1015
    //   488: aload_1
    //   489: iconst_2
    //   490: invokestatic 843	com/tencent/mm/bb/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;I)V
    //   493: aload_0
    //   494: getfield 53	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vFn	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   497: invokevirtual 295	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:getType	()I
    //   500: bipush 39
    //   502: if_icmpne +745 -> 1247
    //   505: aload_0
    //   506: getfield 53	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:vFn	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;
    //   509: getfield 94	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   512: checkcast 1017	com/tencent/mm/opensdk/modelmsg/WXGameVideoFileObject
    //   515: astore_1
    //   516: aload_1
    //   517: getfield 1018	com/tencent/mm/opensdk/modelmsg/WXGameVideoFileObject:filePath	Ljava/lang/String;
    //   520: invokestatic 704	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   523: ifne +62 -> 585
    //   526: aload_1
    //   527: getfield 1018	com/tencent/mm/opensdk/modelmsg/WXGameVideoFileObject:filePath	Ljava/lang/String;
    //   530: invokestatic 874	com/tencent/mm/a/e:aO	(Ljava/lang/String;)Z
    //   533: ifeq +52 -> 585
    //   536: aload_1
    //   537: getfield 1018	com/tencent/mm/opensdk/modelmsg/WXGameVideoFileObject:filePath	Ljava/lang/String;
    //   540: astore_1
    //   541: invokestatic 346	com/tencent/mm/i/g:sV	()Lcom/tencent/mm/i/e;
    //   544: ldc_w 1020
    //   547: ldc_w 1021
    //   550: invokevirtual 1022	com/tencent/mm/i/e:getInt	(Ljava/lang/String;I)I
    //   553: istore_2
    //   554: aload_1
    //   555: invokestatic 1028	com/tencent/mm/modelsfs/FileOp:kj	(Ljava/lang/String;)J
    //   558: iload_2
    //   559: i2l
    //   560: lcmp
    //   561: ifle +194 -> 755
    //   564: ldc_w 1030
    //   567: ldc_w 1032
    //   570: invokestatic 305	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: iconst_1
    //   574: istore_2
    //   575: iload_2
    //   576: ifeq +184 -> 760
    //   579: iconst_1
    //   580: istore_2
    //   581: iload_2
    //   582: ifeq +665 -> 1247
    //   585: aload_0
    //   586: aload_0
    //   587: invokevirtual 482	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:getIntent	()Landroid/content/Intent;
    //   590: invokevirtual 488	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   593: bipush -5
    //   595: invokestatic 494	com/tencent/mm/pluginsdk/model/app/ReportUtil:b	(Landroid/os/Bundle;I)Lcom/tencent/mm/pluginsdk/model/app/ReportUtil$ReportArgs;
    //   598: invokestatic 497	com/tencent/mm/pluginsdk/model/app/ReportUtil:a	(Landroid/content/Context;Lcom/tencent/mm/pluginsdk/model/app/ReportUtil$ReportArgs;)V
    //   601: aload_0
    //   602: invokevirtual 500	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:finish	()V
    //   605: ldc2_w 883
    //   608: sipush 22724
    //   611: invokestatic 72	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   614: return
    //   615: astore_1
    //   616: ldc_w 275
    //   619: aload_1
    //   620: ldc_w 1034
    //   623: iconst_1
    //   624: anewarray 246	java/lang/Object
    //   627: dup
    //   628: iconst_0
    //   629: aload_1
    //   630: invokevirtual 1037	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   633: aastore
    //   634: invokestatic 1041	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   637: goto -184 -> 453
    //   640: astore 4
    //   642: aconst_null
    //   643: astore_3
    //   644: aload_3
    //   645: astore_1
    //   646: ldc_w 275
    //   649: aload 4
    //   651: ldc_w 1043
    //   654: iconst_2
    //   655: anewarray 246	java/lang/Object
    //   658: dup
    //   659: iconst_0
    //   660: aload 5
    //   662: aastore
    //   663: dup
    //   664: iconst_1
    //   665: aload 4
    //   667: invokevirtual 1037	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   670: aastore
    //   671: invokestatic 1041	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   674: aload_3
    //   675: ifnull -222 -> 453
    //   678: aload_3
    //   679: invokevirtual 1009	android/media/MediaMetadataRetriever:release	()V
    //   682: goto -229 -> 453
    //   685: astore_1
    //   686: ldc_w 275
    //   689: aload_1
    //   690: ldc_w 1034
    //   693: iconst_1
    //   694: anewarray 246	java/lang/Object
    //   697: dup
    //   698: iconst_0
    //   699: aload_1
    //   700: invokevirtual 1037	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   703: aastore
    //   704: invokestatic 1041	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   707: goto -254 -> 453
    //   710: astore_3
    //   711: aconst_null
    //   712: astore_1
    //   713: aload_1
    //   714: ifnull +7 -> 721
    //   717: aload_1
    //   718: invokevirtual 1009	android/media/MediaMetadataRetriever:release	()V
    //   721: aload_3
    //   722: athrow
    //   723: astore_1
    //   724: ldc_w 275
    //   727: aload_1
    //   728: ldc_w 1034
    //   731: iconst_1
    //   732: anewarray 246	java/lang/Object
    //   735: dup
    //   736: iconst_0
    //   737: aload_1
    //   738: invokevirtual 1037	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   741: aastore
    //   742: invokestatic 1041	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   745: goto -24 -> 721
    //   748: aload_0
    //   749: invokevirtual 500	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:finish	()V
    //   752: goto -299 -> 453
    //   755: iconst_0
    //   756: istore_2
    //   757: goto -182 -> 575
    //   760: aload_1
    //   761: invokestatic 1049	com/tencent/mm/modelsns/a$a:kG	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/a$a;
    //   764: astore_1
    //   765: aload_1
    //   766: getfield 1052	com/tencent/mm/modelsns/a$a:hSQ	I
    //   769: ifle +46 -> 815
    //   772: aload_1
    //   773: getfield 1055	com/tencent/mm/modelsns/a$a:hSP	I
    //   776: ifle +39 -> 815
    //   779: aload_1
    //   780: getfield 1052	com/tencent/mm/modelsns/a$a:hSQ	I
    //   783: i2f
    //   784: aload_1
    //   785: getfield 1055	com/tencent/mm/modelsns/a$a:hSP	I
    //   788: i2f
    //   789: fdiv
    //   790: ldc_w 1056
    //   793: fcmpl
    //   794: ifgt +21 -> 815
    //   797: aload_1
    //   798: getfield 1052	com/tencent/mm/modelsns/a$a:hSQ	I
    //   801: i2f
    //   802: aload_1
    //   803: getfield 1055	com/tencent/mm/modelsns/a$a:hSP	I
    //   806: i2f
    //   807: fdiv
    //   808: ldc_w 1057
    //   811: fcmpg
    //   812: ifge +193 -> 1005
    //   815: ldc_w 1030
    //   818: ldc_w 1059
    //   821: iconst_2
    //   822: anewarray 246	java/lang/Object
    //   825: dup
    //   826: iconst_0
    //   827: aload_1
    //   828: getfield 1052	com/tencent/mm/modelsns/a$a:hSQ	I
    //   831: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   834: aastore
    //   835: dup
    //   836: iconst_1
    //   837: aload_1
    //   838: getfield 1055	com/tencent/mm/modelsns/a$a:hSP	I
    //   841: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   844: aastore
    //   845: invokestatic 992	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   848: iconst_1
    //   849: istore_2
    //   850: iload_2
    //   851: ifne +149 -> 1000
    //   854: ldc_w 1030
    //   857: ldc_w 1061
    //   860: iconst_1
    //   861: anewarray 246	java/lang/Object
    //   864: dup
    //   865: iconst_0
    //   866: aload_1
    //   867: getfield 1064	com/tencent/mm/modelsns/a$a:hSO	I
    //   870: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   873: aastore
    //   874: invokestatic 992	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   877: aload_1
    //   878: getfield 1064	com/tencent/mm/modelsns/a$a:hSO	I
    //   881: sipush 1000
    //   884: if_icmpgt +126 -> 1010
    //   887: iconst_1
    //   888: istore_2
    //   889: iload_2
    //   890: ifne +110 -> 1000
    //   893: ldc_w 1030
    //   896: ldc_w 1066
    //   899: iconst_1
    //   900: anewarray 246	java/lang/Object
    //   903: dup
    //   904: iconst_0
    //   905: aload_1
    //   906: aastore
    //   907: invokestatic 283	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   910: aload_1
    //   911: getfield 1069	com/tencent/mm/modelsns/a$a:hSL	Ljava/lang/String;
    //   914: invokestatic 704	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   917: ifne +57 -> 974
    //   920: aload_1
    //   921: getfield 1069	com/tencent/mm/modelsns/a$a:hSL	Ljava/lang/String;
    //   924: astore_3
    //   925: aload_3
    //   926: invokestatic 704	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   929: ifeq +101 -> 1030
    //   932: iconst_1
    //   933: istore_2
    //   934: iload_2
    //   935: ifne +39 -> 974
    //   938: ldc_w 1071
    //   941: aload_1
    //   942: getfield 1074	com/tencent/mm/modelsns/a$a:hSM	Ljava/lang/String;
    //   945: invokevirtual 1077	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   948: ifeq +26 -> 974
    //   951: aload_1
    //   952: getfield 1080	com/tencent/mm/modelsns/a$a:hSN	Ljava/lang/String;
    //   955: invokestatic 704	com/tencent/mm/sdk/platformtools/bf:mA	(Ljava/lang/String;)Z
    //   958: ifne +279 -> 1237
    //   961: ldc_w 1082
    //   964: aload_1
    //   965: getfield 1080	com/tencent/mm/modelsns/a$a:hSN	Ljava/lang/String;
    //   968: invokevirtual 1077	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   971: ifne +266 -> 1237
    //   974: ldc_w 1030
    //   977: ldc_w 1084
    //   980: iconst_1
    //   981: anewarray 246	java/lang/Object
    //   984: dup
    //   985: iconst_0
    //   986: aload_1
    //   987: getfield 1074	com/tencent/mm/modelsns/a$a:hSM	Ljava/lang/String;
    //   990: aastore
    //   991: invokestatic 992	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   994: iconst_1
    //   995: istore_2
    //   996: iload_2
    //   997: ifeq +245 -> 1242
    //   1000: iconst_1
    //   1001: istore_2
    //   1002: goto -421 -> 581
    //   1005: iconst_0
    //   1006: istore_2
    //   1007: goto -157 -> 850
    //   1010: aload_1
    //   1011: getfield 1064	com/tencent/mm/modelsns/a$a:hSO	I
    //   1014: sipush 10500
    //   1017: if_icmplt +8 -> 1025
    //   1020: iconst_1
    //   1021: istore_2
    //   1022: goto -133 -> 889
    //   1025: iconst_0
    //   1026: istore_2
    //   1027: goto -138 -> 889
    //   1030: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1033: ifnonnull +148 -> 1181
    //   1036: new 1090	java/util/HashSet
    //   1039: dup
    //   1040: invokespecial 1091	java/util/HashSet:<init>	()V
    //   1043: astore 4
    //   1045: aload 4
    //   1047: putstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1050: aload 4
    //   1052: ldc_w 1093
    //   1055: invokeinterface 1098 2 0
    //   1060: pop
    //   1061: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1064: ldc_w 1100
    //   1067: invokeinterface 1098 2 0
    //   1072: pop
    //   1073: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1076: ldc_w 1102
    //   1079: invokeinterface 1098 2 0
    //   1084: pop
    //   1085: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1088: ldc_w 1104
    //   1091: invokeinterface 1098 2 0
    //   1096: pop
    //   1097: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1100: ldc_w 1106
    //   1103: invokeinterface 1098 2 0
    //   1108: pop
    //   1109: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1112: ldc_w 1108
    //   1115: invokeinterface 1098 2 0
    //   1120: pop
    //   1121: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1124: ldc_w 1110
    //   1127: invokeinterface 1098 2 0
    //   1132: pop
    //   1133: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1136: ldc_w 1112
    //   1139: invokeinterface 1098 2 0
    //   1144: pop
    //   1145: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1148: ldc_w 1114
    //   1151: invokeinterface 1098 2 0
    //   1156: pop
    //   1157: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1160: ldc_w 1116
    //   1163: invokeinterface 1098 2 0
    //   1168: pop
    //   1169: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1172: ldc_w 1118
    //   1175: invokeinterface 1098 2 0
    //   1180: pop
    //   1181: aload_3
    //   1182: invokevirtual 1121	java/lang/String:trim	()Ljava/lang/String;
    //   1185: astore_3
    //   1186: aload_3
    //   1187: ldc_w 1123
    //   1190: invokevirtual 1126	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1193: istore_2
    //   1194: iload_2
    //   1195: iflt +11 -> 1206
    //   1198: iload_2
    //   1199: aload_3
    //   1200: invokevirtual 432	java/lang/String:length	()I
    //   1203: if_icmplt +8 -> 1211
    //   1206: iconst_1
    //   1207: istore_2
    //   1208: goto -274 -> 934
    //   1211: getstatic 1088	com/tencent/mm/modelsns/a:hSK	Ljava/util/Set;
    //   1214: aload_3
    //   1215: iload_2
    //   1216: invokevirtual 1129	java/lang/String:substring	(I)Ljava/lang/String;
    //   1219: invokeinterface 1132 2 0
    //   1224: ifne +8 -> 1232
    //   1227: iconst_1
    //   1228: istore_2
    //   1229: goto -295 -> 934
    //   1232: iconst_0
    //   1233: istore_2
    //   1234: goto -300 -> 934
    //   1237: iconst_0
    //   1238: istore_2
    //   1239: goto -243 -> 996
    //   1242: iconst_0
    //   1243: istore_2
    //   1244: goto -663 -> 581
    //   1247: aload_0
    //   1248: iconst_1
    //   1249: invokespecial 876	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:lK	(Z)V
    //   1252: ldc2_w 883
    //   1255: sipush 22724
    //   1258: invokestatic 72	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   1261: return
    //   1262: aload_0
    //   1263: getfield 69	com/tencent/mm/ui/transmit/SendAppMessageWrapperUI:fyz	Lcom/tencent/mm/sdk/platformtools/ai;
    //   1266: ldc2_w 1133
    //   1269: ldc2_w 1133
    //   1272: invokevirtual 1137	com/tencent/mm/sdk/platformtools/ai:v	(JJ)V
    //   1275: ldc2_w 883
    //   1278: sipush 22724
    //   1281: invokestatic 72	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   1284: return
    //   1285: astore_3
    //   1286: goto -573 -> 713
    //   1289: astore 4
    //   1291: goto -647 -> 644
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1294	0	this	SendAppMessageWrapperUI
    //   0	1294	1	paramBundle	android.os.Bundle
    //   405	839	2	i	int
    //   139	540	3	localObject1	Object
    //   710	12	3	localObject2	Object
    //   924	291	3	str	String
    //   1285	1	3	localObject3	Object
    //   104	133	4	localReq	com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req
    //   640	26	4	localException1	Exception
    //   1043	8	4	localHashSet	java.util.HashSet
    //   1289	1	4	localException2	Exception
    //   93	568	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   449	453	615	java/lang/Exception
    //   377	385	640	java/lang/Exception
    //   678	682	685	java/lang/Exception
    //   377	385	710	finally
    //   717	721	723	java/lang/Exception
    //   387	393	1285	finally
    //   395	406	1285	finally
    //   408	428	1285	finally
    //   437	443	1285	finally
    //   445	449	1285	finally
    //   646	674	1285	finally
    //   387	393	1289	java/lang/Exception
    //   395	406	1289	java/lang/Exception
    //   408	428	1289	java/lang/Exception
    //   437	443	1289	java/lang/Exception
    //   445	449	1289	java/lang/Exception
  }
  
  protected void onDestroy()
  {
    GMTrace.i(3050232086528L, 22726);
    super.onDestroy();
    if (this.woX)
    {
      v.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
      SharedPreferences localSharedPreferences = getSharedPreferences(aa.bIN(), 0);
      setRequestedOrientation(1);
      localSharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
    }
    GMTrace.o(3050232086528L, 22726);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3050366304256L, 22727);
    aGY();
    boolean bool = super.onTouchEvent(paramMotionEvent);
    GMTrace.o(3050366304256L, 22727);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/transmit/SendAppMessageWrapperUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */