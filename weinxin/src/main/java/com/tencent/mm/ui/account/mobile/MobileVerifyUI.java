package com.tencent.mm.ui.account.mobile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.c;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.RegByMobileVoiceVerifyUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.y.n;
import java.util.Timer;
import java.util.TimerTask;

public class MobileVerifyUI
  extends MMActivity
{
  String aIO;
  protected String fOz;
  int hSt;
  protected ProgressDialog isb;
  String lMD;
  String oTI;
  private Timer oiY;
  private ContentResolver pwX;
  private String[] pxc;
  protected Button rvO;
  SecurityImage uSI;
  private com.tencent.mm.pluginsdk.j.a uWD;
  protected boolean uXv;
  private int uYS;
  protected EditText vaW;
  private int vbD;
  protected TextView vbO;
  protected boolean vcA;
  protected boolean vcB;
  protected int vcC;
  private b vcD;
  String vcE;
  protected MMFormInputView vco;
  protected TextView vcp;
  protected TextView vcq;
  protected TextView vcr;
  protected ScrollView vcs;
  private c vct;
  private long vcu;
  private boolean vcv;
  private String vcw;
  private boolean vcx;
  Boolean vcy;
  Boolean vcz;
  
  public MobileVerifyUI()
  {
    GMTrace.i(2622077534208L, 19536);
    this.isb = null;
    this.vcu = 0L;
    this.vcv = false;
    this.vcx = false;
    this.uSI = null;
    this.uYS = 30;
    this.vcA = false;
    this.vcB = false;
    this.vcC = -1;
    this.uXv = false;
    GMTrace.o(2622077534208L, 19536);
  }
  
  private void OQ()
  {
    GMTrace.i(2623419711488L, 19546);
    this.vcx = false;
    this.vcp.setEnabled(false);
    this.vcq.setVisibility(0);
    this.vcq.setText(getResources().getQuantityString(R.j.dsl, this.uYS, new Object[] { Integer.valueOf(this.uYS) }));
    this.vcp.setVisibility(8);
    aDD();
    this.vcD.zz(a.vcN);
    com.tencent.mm.ui.base.g.bk(this, getString(R.l.eAQ));
    GMTrace.o(2623419711488L, 19546);
  }
  
  private void aDD()
  {
    GMTrace.i(2622882840576L, 19542);
    if (!this.vcv)
    {
      this.oiY = new Timer();
      this.vcv = true;
      this.vcu = this.uYS;
      TimerTask local1 = new TimerTask()
      {
        public final void run()
        {
          GMTrace.i(2629593726976L, 19592);
          MobileVerifyUI.this.vcq.post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2603421270016L, 19397);
              MobileVerifyUI.b(MobileVerifyUI.this);
              if (MobileVerifyUI.c(MobileVerifyUI.this) >= 0L)
              {
                MobileVerifyUI.this.vcq.setText(MobileVerifyUI.this.getResources().getQuantityString(R.j.dsl, (int)MobileVerifyUI.c(MobileVerifyUI.this), new Object[] { Integer.valueOf((int)MobileVerifyUI.c(MobileVerifyUI.this)) }));
                GMTrace.o(2603421270016L, 19397);
                return;
              }
              MobileVerifyUI.this.vcq.setVisibility(8);
              MobileVerifyUI.this.vcp.setVisibility(0);
              MobileVerifyUI.d(MobileVerifyUI.this);
              MobileVerifyUI.this.vcp.setEnabled(true);
              MobileVerifyUI.this.vcp.setText(MobileVerifyUI.this.getString(R.l.eBa));
              GMTrace.o(2603421270016L, 19397);
            }
          });
          GMTrace.o(2629593726976L, 19592);
        }
      };
      this.oiY.schedule(local1, 1000L, 1000L);
    }
    GMTrace.o(2622882840576L, 19542);
  }
  
  /* Error */
  private void bRc()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc2_w 225
    //   6: sipush 19552
    //   9: invokestatic 107	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   12: ldc -28
    //   14: invokestatic 234	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   17: astore 8
    //   19: aload_0
    //   20: aload_0
    //   21: invokevirtual 238	com/tencent/mm/ui/account/mobile/MobileVerifyUI:getContentResolver	()Landroid/content/ContentResolver;
    //   24: putfield 240	com/tencent/mm/ui/account/mobile/MobileVerifyUI:pwX	Landroid/content/ContentResolver;
    //   27: ldc -14
    //   29: astore 6
    //   31: iconst_0
    //   32: istore_1
    //   33: iload_1
    //   34: aload_0
    //   35: getfield 244	com/tencent/mm/ui/account/mobile/MobileVerifyUI:pxc	[Ljava/lang/String;
    //   38: arraylength
    //   39: if_icmpge +98 -> 137
    //   42: iload_1
    //   43: aload_0
    //   44: getfield 244	com/tencent/mm/ui/account/mobile/MobileVerifyUI:pxc	[Ljava/lang/String;
    //   47: arraylength
    //   48: iconst_1
    //   49: isub
    //   50: if_icmpne +46 -> 96
    //   53: new 246	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   60: aload 6
    //   62: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc -3
    //   67: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_0
    //   71: getfield 244	com/tencent/mm/ui/account/mobile/MobileVerifyUI:pxc	[Ljava/lang/String;
    //   74: iload_1
    //   75: aaload
    //   76: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc -1
    //   81: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 6
    //   89: iload_1
    //   90: iconst_1
    //   91: iadd
    //   92: istore_1
    //   93: goto -60 -> 33
    //   96: new 246	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   103: aload 6
    //   105: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc_w 261
    //   111: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: getfield 244	com/tencent/mm/ui/account/mobile/MobileVerifyUI:pxc	[Ljava/lang/String;
    //   118: iload_1
    //   119: aaload
    //   120: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 263
    //   126: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 6
    //   134: goto -45 -> 89
    //   137: new 246	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   144: aload 6
    //   146: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 265
    //   152: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokestatic 271	java/lang/System:currentTimeMillis	()J
    //   158: ldc2_w 272
    //   161: lsub
    //   162: invokevirtual 276	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   165: ldc_w 278
    //   168: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore 6
    //   176: ldc_w 280
    //   179: new 246	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 282
    //   186: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload 6
    //   191: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 291	com/tencent/mm/sdk/platformtools/v:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 6
    //   202: ifnull +14 -> 216
    //   205: aload 6
    //   207: ldc_w 293
    //   210: invokevirtual 299	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +13 -> 226
    //   216: ldc2_w 225
    //   219: sipush 19552
    //   222: invokestatic 130	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   225: return
    //   226: aload_0
    //   227: getfield 240	com/tencent/mm/ui/account/mobile/MobileVerifyUI:pwX	Landroid/content/ContentResolver;
    //   230: aload 8
    //   232: iconst_3
    //   233: anewarray 295	java/lang/String
    //   236: dup
    //   237: iconst_0
    //   238: ldc_w 301
    //   241: aastore
    //   242: dup
    //   243: iconst_1
    //   244: ldc_w 303
    //   247: aastore
    //   248: dup
    //   249: iconst_2
    //   250: ldc_w 305
    //   253: aastore
    //   254: aload 6
    //   256: aconst_null
    //   257: aconst_null
    //   258: invokevirtual 311	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   261: astore 6
    //   263: aload 6
    //   265: ifnonnull +35 -> 300
    //   268: aload 6
    //   270: ifnull +20 -> 290
    //   273: aload 6
    //   275: invokeinterface 317 1 0
    //   280: ifne +10 -> 290
    //   283: aload 6
    //   285: invokeinterface 320 1 0
    //   290: ldc2_w 225
    //   293: sipush 19552
    //   296: invokestatic 130	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   299: return
    //   300: iconst_m1
    //   301: istore_1
    //   302: lconst_0
    //   303: lstore_2
    //   304: aload 6
    //   306: invokeinterface 323 1 0
    //   311: ifeq +34 -> 345
    //   314: aload 6
    //   316: iconst_2
    //   317: invokeinterface 327 2 0
    //   322: lstore 4
    //   324: lload 4
    //   326: lload_2
    //   327: lcmp
    //   328: ifle +304 -> 632
    //   331: aload 6
    //   333: invokeinterface 331 1 0
    //   338: istore_1
    //   339: lload 4
    //   341: lstore_2
    //   342: goto +290 -> 632
    //   345: aload_0
    //   346: aconst_null
    //   347: putfield 333	com/tencent/mm/ui/account/mobile/MobileVerifyUI:vcw	Ljava/lang/String;
    //   350: iload_1
    //   351: iflt +146 -> 497
    //   354: aload 6
    //   356: iload_1
    //   357: invokeinterface 336 2 0
    //   362: pop
    //   363: aload 6
    //   365: aload 6
    //   367: ldc_w 301
    //   370: invokeinterface 340 2 0
    //   375: invokeinterface 341 2 0
    //   380: astore 8
    //   382: ldc_w 343
    //   385: invokestatic 349	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   388: aload 8
    //   390: invokevirtual 353	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   393: astore 8
    //   395: aload 8
    //   397: invokevirtual 358	java/util/regex/Matcher:find	()Z
    //   400: ifeq +10 -> 410
    //   403: aload 8
    //   405: invokevirtual 361	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   408: astore 7
    //   410: aload_0
    //   411: aload 7
    //   413: putfield 333	com/tencent/mm/ui/account/mobile/MobileVerifyUI:vcw	Ljava/lang/String;
    //   416: aload_0
    //   417: getfield 115	com/tencent/mm/ui/account/mobile/MobileVerifyUI:vcx	Z
    //   420: ifne +77 -> 497
    //   423: aload_0
    //   424: iconst_1
    //   425: putfield 115	com/tencent/mm/ui/account/mobile/MobileVerifyUI:vcx	Z
    //   428: aload_0
    //   429: getfield 363	com/tencent/mm/ui/account/mobile/MobileVerifyUI:vaW	Landroid/widget/EditText;
    //   432: aload_0
    //   433: getfield 333	com/tencent/mm/ui/account/mobile/MobileVerifyUI:vcw	Ljava/lang/String;
    //   436: invokevirtual 366	android/widget/EditText:setText	(Ljava/lang/CharSequence;)V
    //   439: aload_0
    //   440: invokevirtual 369	com/tencent/mm/ui/account/mobile/MobileVerifyUI:aGY	()V
    //   443: aload_0
    //   444: getfield 363	com/tencent/mm/ui/account/mobile/MobileVerifyUI:vaW	Landroid/widget/EditText;
    //   447: invokevirtual 373	android/widget/EditText:getText	()Landroid/text/Editable;
    //   450: invokevirtual 374	java/lang/Object:toString	()Ljava/lang/String;
    //   453: invokevirtual 377	java/lang/String:trim	()Ljava/lang/String;
    //   456: ldc_w 293
    //   459: invokevirtual 299	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   462: ifne +35 -> 497
    //   465: aload_0
    //   466: getfield 109	com/tencent/mm/ui/account/mobile/MobileVerifyUI:isb	Landroid/app/ProgressDialog;
    //   469: ifnull +15 -> 484
    //   472: aload_0
    //   473: getfield 109	com/tencent/mm/ui/account/mobile/MobileVerifyUI:isb	Landroid/app/ProgressDialog;
    //   476: invokevirtual 382	android/app/ProgressDialog:dismiss	()V
    //   479: aload_0
    //   480: aconst_null
    //   481: putfield 109	com/tencent/mm/ui/account/mobile/MobileVerifyUI:isb	Landroid/app/ProgressDialog;
    //   484: aload_0
    //   485: getfield 180	com/tencent/mm/ui/account/mobile/MobileVerifyUI:vcD	Lcom/tencent/mm/ui/account/mobile/MobileVerifyUI$b;
    //   488: getstatic 385	com/tencent/mm/ui/account/mobile/MobileVerifyUI$a:vcO	I
    //   491: invokeinterface 187 2 0
    //   496: pop
    //   497: aload 6
    //   499: ifnull +108 -> 607
    //   502: aload 6
    //   504: invokeinterface 317 1 0
    //   509: ifne +98 -> 607
    //   512: aload 6
    //   514: invokeinterface 320 1 0
    //   519: ldc2_w 225
    //   522: sipush 19552
    //   525: invokestatic 130	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   528: return
    //   529: astore 7
    //   531: aconst_null
    //   532: astore 6
    //   534: ldc_w 280
    //   537: aload 7
    //   539: invokevirtual 386	java/lang/Exception:toString	()Ljava/lang/String;
    //   542: invokestatic 389	com/tencent/mm/sdk/platformtools/v:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: aload 6
    //   547: ifnull +60 -> 607
    //   550: aload 6
    //   552: invokeinterface 317 1 0
    //   557: ifne +50 -> 607
    //   560: aload 6
    //   562: invokeinterface 320 1 0
    //   567: ldc2_w 225
    //   570: sipush 19552
    //   573: invokestatic 130	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   576: return
    //   577: astore 7
    //   579: aconst_null
    //   580: astore 6
    //   582: aload 6
    //   584: ifnull +20 -> 604
    //   587: aload 6
    //   589: invokeinterface 317 1 0
    //   594: ifne +10 -> 604
    //   597: aload 6
    //   599: invokeinterface 320 1 0
    //   604: aload 7
    //   606: athrow
    //   607: ldc2_w 225
    //   610: sipush 19552
    //   613: invokestatic 130	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   616: return
    //   617: astore 7
    //   619: goto -37 -> 582
    //   622: astore 7
    //   624: goto -42 -> 582
    //   627: astore 7
    //   629: goto -95 -> 534
    //   632: goto -328 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	635	0	this	MobileVerifyUI
    //   32	325	1	i	int
    //   303	39	2	l1	long
    //   322	18	4	l2	long
    //   29	569	6	localObject1	Object
    //   1	411	7	str	String
    //   529	9	7	localException1	Exception
    //   577	28	7	localObject2	Object
    //   617	1	7	localObject3	Object
    //   622	1	7	localObject4	Object
    //   627	1	7	localException2	Exception
    //   17	387	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   226	263	529	java/lang/Exception
    //   226	263	577	finally
    //   304	324	617	finally
    //   331	339	617	finally
    //   345	350	617	finally
    //   354	395	617	finally
    //   395	410	617	finally
    //   410	484	617	finally
    //   484	497	617	finally
    //   534	545	622	finally
    //   304	324	627	java/lang/Exception
    //   331	339	627	java/lang/Exception
    //   345	350	627	java/lang/Exception
    //   354	395	627	java/lang/Exception
    //   395	410	627	java/lang/Exception
    //   410	484	627	java/lang/Exception
    //   484	497	627	java/lang/Exception
  }
  
  private void bte()
  {
    GMTrace.i(2623285493760L, 19545);
    aGY();
    if (this.vaW.getText().toString().trim().equals(""))
    {
      com.tencent.mm.ui.base.g.h(this, R.l.dOd, R.l.dIG);
      GMTrace.o(2623285493760L, 19545);
      return;
    }
    this.vcD.zz(a.vcM);
    GMTrace.o(2623285493760L, 19545);
  }
  
  private void goBack()
  {
    GMTrace.i(2623688146944L, 19548);
    com.tencent.mm.plugin.c.b.mN(this.oTI);
    if (!this.vcD.zz(a.vcL))
    {
      finish();
      GMTrace.o(2623688146944L, 19548);
      return;
    }
    GMTrace.o(2623688146944L, 19548);
  }
  
  protected final void KD()
  {
    GMTrace.i(2623151276032L, 19544);
    v.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.fOz);
    this.vco = ((MMFormInputView)findViewById(R.h.btj));
    Object localObject = this.vco;
    if (((MMFormInputView)localObject).oAr != null) {
      ((MMFormInputView)localObject).oAr.setImeOptions(5);
    }
    for (;;)
    {
      this.vco.setInputType(3);
      this.vaW = this.vco.oAr;
      this.vcp = ((TextView)findViewById(R.h.ckD));
      this.vcq = ((TextView)findViewById(R.h.ckC));
      this.vbO = ((TextView)findViewById(R.h.bth));
      this.vbO.setText(this.fOz);
      this.fOz = am.PA(this.fOz);
      this.vcp.setText(getString(R.l.eBb));
      this.vcr = ((TextView)findViewById(R.h.btk));
      this.rvO = ((Button)findViewById(R.h.cnP));
      this.vcs = ((ScrollView)findViewById(R.h.czV));
      this.pxc = getResources().getStringArray(R.c.aSp);
      localObject = getString(R.l.eJA);
      this.vcr.setText(Html.fromHtml((String)localObject));
      localObject = new InputFilter()
      {
        public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          GMTrace.i(2596039294976L, 19342);
          paramAnonymousCharSequence = com.tencent.mm.sdk.platformtools.bf.K(paramAnonymousCharSequence);
          GMTrace.o(2596039294976L, 19342);
          return paramAnonymousCharSequence;
        }
      };
      this.vcq.setVisibility(0);
      this.vcq.setText(getResources().getQuantityString(R.j.dsl, this.uYS, new Object[] { Integer.valueOf(this.uYS) }));
      aDD();
      this.vcx = false;
      this.vaW.setFilters(new InputFilter[] { localObject });
      this.vaW.addTextChangedListener(new MMEditText.c(this.vaW, null, 12));
      this.rvO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2615769300992L, 19489);
          MobileVerifyUI.e(MobileVerifyUI.this);
          GMTrace.o(2615769300992L, 19489);
        }
      });
      this.rvO.setEnabled(false);
      this.vaW.setTextSize(15.0F);
      this.vaW.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          GMTrace.i(2621674881024L, 19533);
          if (com.tencent.mm.sdk.platformtools.bf.mA(MobileVerifyUI.this.vaW.getText().toString()))
          {
            MobileVerifyUI.this.vaW.setTextSize(15.0F);
            MobileVerifyUI.this.vaW.setGravity(16);
          }
          while ((MobileVerifyUI.this.vaW.getText() != null) && (MobileVerifyUI.this.vaW.getText().toString().length() > 0))
          {
            MobileVerifyUI.this.rvO.setEnabled(true);
            GMTrace.o(2621674881024L, 19533);
            return;
            MobileVerifyUI.this.vaW.setTextSize(24.0F);
            MobileVerifyUI.this.vaW.setGravity(16);
          }
          MobileVerifyUI.this.rvO.setEnabled(false);
          GMTrace.o(2621674881024L, 19533);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2621809098752L, 19534);
          GMTrace.o(2621809098752L, 19534);
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(2621943316480L, 19535);
          GMTrace.o(2621943316480L, 19535);
        }
      });
      this.vcp.setOnClickListener(new View.OnClickListener()
      {
        private final int vcH;
        private final int vcI;
        private final int vcJ;
        
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(2609461067776L, 19442);
          paramAnonymousView = new com.tencent.mm.ui.tools.l(MobileVerifyUI.this);
          paramAnonymousView.qHD = new n.c()
          {
            public final void a(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              GMTrace.i(2599797391360L, 19370);
              paramAnonymous2l.e(0, MobileVerifyUI.this.getString(R.l.eBb));
              if (com.tencent.mm.ai.b.jO(MobileVerifyUI.this.fOz)) {
                paramAnonymous2l.e(1, MobileVerifyUI.this.getString(R.l.dOf));
              }
              if ((MobileVerifyUI.f(MobileVerifyUI.this) == 2) && (MobileVerifyUI.this.vcB)) {
                paramAnonymous2l.e(2, MobileVerifyUI.this.getString(R.l.eJD));
              }
              GMTrace.o(2599797391360L, 19370);
            }
          };
          paramAnonymousView.qHE = new n.d()
          {
            public final void c(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              GMTrace.i(2631204339712L, 19604);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              default: 
                GMTrace.o(2631204339712L, 19604);
                return;
              case 0: 
                MobileVerifyUI.g(MobileVerifyUI.this);
                GMTrace.o(2631204339712L, 19604);
                return;
              }
              MobileVerifyUI.this.aGY();
              if (MobileVerifyUI.f(MobileVerifyUI.this) == 2) {
                com.tencent.mm.plugin.c.b.mN("R200_500");
              }
              for (;;)
              {
                paramAnonymous2MenuItem = new Intent(MobileVerifyUI.this, RegByMobileVoiceVerifyUI.class);
                Bundle localBundle = new Bundle();
                localBundle.putString("bindmcontact_mobile", MobileVerifyUI.this.fOz);
                localBundle.putInt("voice_verify_type", MobileVerifyUI.h(MobileVerifyUI.this));
                paramAnonymous2MenuItem.putExtras(localBundle);
                MobileVerifyUI.this.startActivity(paramAnonymous2MenuItem);
                break;
                if (MobileVerifyUI.f(MobileVerifyUI.this) == 3) {
                  com.tencent.mm.plugin.c.b.mN("F200_300");
                }
              }
            }
          };
          paramAnonymousView.bkT();
          GMTrace.o(2609461067776L, 19442);
        }
      });
      this.vcp.setEnabled(false);
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2579664732160L, 19220);
          MobileVerifyUI.i(MobileVerifyUI.this);
          GMTrace.o(2579664732160L, 19220);
          return true;
        }
      });
      this.vaW.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          GMTrace.i(2580872691712L, 19229);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            MobileVerifyUI.e(MobileVerifyUI.this);
            GMTrace.o(2580872691712L, 19229);
            return true;
          }
          GMTrace.o(2580872691712L, 19229);
          return false;
        }
      });
      this.vaW.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          GMTrace.i(2588254666752L, 19284);
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            MobileVerifyUI.e(MobileVerifyUI.this);
            GMTrace.o(2588254666752L, 19284);
            return true;
          }
          GMTrace.o(2588254666752L, 19284);
          return false;
        }
      });
      GMTrace.o(2623151276032L, 19544);
      return;
      v.e("MicroMsg.MMFormInputView", "contentET is null!");
    }
  }
  
  public final void bil()
  {
    GMTrace.i(2623017058304L, 19543);
    if (this.uRf.uRR == 1)
    {
      this.vcs.scrollTo(0, this.vcs.getChildAt(0).getMeasuredHeight() - this.vcs.getMeasuredHeight());
      GMTrace.o(2623017058304L, 19543);
      return;
    }
    this.vcs.scrollTo(0, 0);
    GMTrace.o(2623017058304L, 19543);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2622748622848L, 19541);
    int i = R.i.djp;
    GMTrace.o(2622748622848L, 19541);
    return i;
  }
  
  protected final void kB(boolean paramBoolean)
  {
    GMTrace.i(2624090800128L, 19551);
    Intent localIntent = new Intent(this, RegByMobileSetPwdUI.class);
    localIntent.putExtra("kintent_hint", getString(R.l.eSR));
    localIntent.putExtra("kintent_cancelable", paramBoolean);
    startActivityForResult(localIntent, 0);
    GMTrace.o(2624090800128L, 19551);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2622211751936L, 19537);
    super.onCreate(paramBundle);
    com.tencent.mm.u.bf.zK();
    this.vcz = Boolean.valueOf(true);
    this.vbD = getIntent().getIntExtra("mobile_verify_purpose", 0);
    this.vcE = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
    this.lMD = getIntent().getStringExtra("kintent_password");
    this.aIO = getIntent().getStringExtra("kintent_nickname");
    this.vcy = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
    this.uXv = getIntent().getBooleanExtra("from_deep_link", false);
    switch (this.vbD)
    {
    default: 
      v.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.vbD) });
      finish();
      GMTrace.o(2622211751936L, 19537);
      return;
    case 2: 
      this.vcD = new h();
      if ((this.lMD != null) && (this.lMD.length() >= 8))
      {
        this.hSt = 1;
        paramBundle = getString(R.l.dNK);
        if (d.sXk) {
          paramBundle = getString(R.l.bpC) + getString(R.l.dCT);
        }
        qL(paramBundle);
        this.uYS = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.vcA = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.vcB = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.fOz = getIntent().getExtras().getString("bindmcontact_mobile");
        this.oTI = com.tencent.mm.plugin.c.b.OA();
        KD();
        this.vcD.a(this);
        if (this.vcE == null) {
          break label433;
        }
        this.vaW.setText(this.vcE);
        bte();
      }
      break;
    }
    for (;;)
    {
      this.uWD = new com.tencent.mm.pluginsdk.j.a();
      GMTrace.o(2622211751936L, 19537);
      return;
      this.hSt = 4;
      break;
      this.vcD = new f();
      break;
      this.vcD = new g();
      break;
      label433:
      this.vct = new c(this);
      getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this.vct);
    }
  }
  
  public void onDestroy()
  {
    GMTrace.i(2622345969664L, 19538);
    if (this.vct != null)
    {
      getContentResolver().unregisterContentObserver(this.vct);
      this.vct = null;
    }
    if (this.uWD != null) {
      this.uWD.close();
    }
    super.onDestroy();
    GMTrace.o(2622345969664L, 19538);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2623553929216L, 19547);
    if (paramInt == 4)
    {
      goBack();
      GMTrace.o(2623553929216L, 19547);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2623553929216L, 19547);
    return bool;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    GMTrace.i(2623822364672L, 19549);
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nofification_type");
      v.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", new Object[] { paramIntent });
      if ((paramIntent != null) && (paramIntent.equals("no_reg_notification"))) {
        OQ();
      }
    }
    GMTrace.o(2623822364672L, 19549);
  }
  
  public void onPause()
  {
    GMTrace.i(2622614405120L, 19540);
    super.onPause();
    this.vcD.stop();
    GMTrace.o(2622614405120L, 19540);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    GMTrace.i(2624359235584L, 19553);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (int i = -1;; i = paramArrayOfInt.length)
      {
        v.w("MicroMsg.MobileVerifyUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, com.tencent.mm.sdk.platformtools.bf.bJP() });
        GMTrace.o(2624359235584L, 19553);
        return;
      }
    }
    v.i("MicroMsg.MobileVerifyUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(2624359235584L, 19553);
      return;
      if (paramArrayOfInt[0] == 0) {
        bRc();
      }
    }
  }
  
  public void onResume()
  {
    GMTrace.i(2622480187392L, 19539);
    super.onResume();
    this.vcD.start();
    GMTrace.o(2622480187392L, 19539);
  }
  
  protected final boolean p(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(2623956582400L, 19550);
    Object localObject = com.tencent.mm.f.a.dn(paramString);
    if (localObject != null)
    {
      ((com.tencent.mm.f.a)localObject).a(this, null, null);
      GMTrace.o(2623956582400L, 19550);
      return true;
    }
    if (paramInt1 == 4) {}
    int i;
    switch (paramInt2)
    {
    default: 
      switch (paramInt2)
      {
      default: 
        i = 0;
      }
      break;
    }
    while (i != 0)
    {
      GMTrace.o(2623956582400L, 19550);
      return true;
      if (ap.vd().BR() == 5)
      {
        com.tencent.mm.ui.base.g.h(this, R.l.eDh, R.l.eDg);
        GMTrace.o(2623956582400L, 19550);
        return true;
      }
      m.bo(this);
      GMTrace.o(2623956582400L, 19550);
      return true;
      Toast.makeText(this, R.l.dNq, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, R.l.dNn, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, R.l.dNp, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, R.l.dNs, 0).show();
      i = 1;
      continue;
      com.tencent.mm.ui.base.g.a(this, getString(R.l.dNZ), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2628788420608L, 19586);
          GMTrace.o(2628788420608L, 19586);
        }
      });
      i = 1;
      continue;
      com.tencent.mm.ui.base.g.a(this, R.l.dNX, R.l.btk, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2615366647808L, 19486);
          GMTrace.o(2615366647808L, 19486);
        }
      });
      i = 1;
      continue;
      ap.hold();
      ActionBarActivity localActionBarActivity = this.uRf.uRz;
      if (TextUtils.isEmpty(ap.uI())) {}
      for (localObject = com.tencent.mm.bg.a.V(this.uRf.uRz, R.l.eza);; localObject = ap.uI())
      {
        com.tencent.mm.ui.base.g.a(localActionBarActivity, (String)localObject, this.uRf.uRz.getString(R.l.dIG), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2582751739904L, 19243);
            GMTrace.o(2582751739904L, 19243);
          }
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(2629056856064L, 19588);
            GMTrace.o(2629056856064L, 19588);
          }
        });
        i = 1;
        break;
      }
    }
    paramString = new p(paramInt1, paramInt2, paramString);
    if (this.uWD.a(this, paramString))
    {
      GMTrace.o(2623956582400L, 19550);
      return true;
    }
    GMTrace.o(2623956582400L, 19550);
    return false;
  }
  
  protected static enum a
  {
    static
    {
      GMTrace.i(2586644054016L, 19272);
      vcL = 1;
      vcM = 2;
      vcN = 3;
      vcO = 4;
      vcP = new int[] { vcL, vcM, vcN, vcO };
      GMTrace.o(2586644054016L, 19272);
    }
    
    public static int[] bRj()
    {
      GMTrace.i(2586509836288L, 19271);
      int[] arrayOfInt = (int[])vcP.clone();
      GMTrace.o(2586509836288L, 19271);
      return arrayOfInt;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(MobileVerifyUI paramMobileVerifyUI);
    
    public abstract void start();
    
    public abstract void stop();
    
    public abstract boolean zz(int paramInt);
  }
  
  public final class c
    extends ContentObserver
  {
    private Activity activity;
    
    public c(Activity paramActivity)
    {
      super();
      GMTrace.i(2604092358656L, 19402);
      this.activity = paramActivity;
      GMTrace.o(2604092358656L, 19402);
    }
    
    public final void onChange(boolean paramBoolean)
    {
      GMTrace.i(2604226576384L, 19403);
      super.onChange(paramBoolean);
      if (MobileVerifyUI.f(MobileVerifyUI.this) != 3)
      {
        paramBoolean = com.tencent.mm.pluginsdk.i.a.a(this.activity, "android.permission.READ_SMS", 128, "", "");
        v.i("MicroMsg.MobileVerifyUI", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(paramBoolean), com.tencent.mm.sdk.platformtools.bf.bJP(), this.activity });
        if (!paramBoolean)
        {
          GMTrace.o(2604226576384L, 19403);
          return;
        }
        MobileVerifyUI.j(MobileVerifyUI.this);
      }
      GMTrace.o(2604226576384L, 19403);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/mobile/MobileVerifyUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */