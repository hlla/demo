package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.mf;
import com.tencent.mm.pluginsdk.model.app.ag;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChatFooter
  extends LinearLayout
  implements ViewTreeObserver.OnGlobalLayoutListener, h.a
{
  private static int count;
  private static final int[] jWL;
  private static final int[] jWM;
  private Activity activity;
  private Context context;
  public String fOl;
  private ImageView jWU;
  private boolean jXc;
  private final ad jXl;
  private String kTm;
  public View lLT;
  public View lLU;
  public View lLV;
  public View lLW;
  public View llc;
  public final ad mHandler;
  public MMEditText nto;
  public Button ntp;
  public ChatFooterPanel ntq;
  public com.tencent.mm.ui.base.o qXA;
  private TextView qXB;
  private ImageView qXC;
  public View qXD;
  public f sGT;
  private int sGU;
  public m sIY;
  public boolean sJc;
  private TextView sNA;
  private InputMethodManager sNB;
  public int sNC;
  private boolean sND;
  private boolean sNE;
  public boolean sNF;
  public b sNG;
  public c sNH;
  private l.a sNI;
  private boolean sNJ;
  public q sNK;
  private boolean sNL;
  private Animation sNM;
  private Animation sNN;
  private ChatFooterPanel.a sNO;
  private AppPanel.b sNP;
  public e sNQ;
  private int sNR;
  public boolean sNS;
  private int sNT;
  private final int sNU;
  private final int sNV;
  private final int sNW;
  private final int sNX;
  private final int sNY;
  private final int sNZ;
  public AppPanel sNk;
  public TextView sNl;
  private Button sNm;
  public ImageButton sNn;
  public LinearLayout sNo;
  public ChatFooterBottom sNp;
  public ImageButton sNq;
  public ImageButton sNr;
  private com.tencent.mm.ui.base.h sNs;
  private i sNt;
  public l sNu;
  public b sNv;
  private d sNw;
  public final a sNx;
  public boolean sNy;
  public boolean sNz;
  private final int sOa;
  private final int sOb;
  private int sOc;
  private int sOd;
  private int sOe;
  private int sOf;
  private boolean sOg;
  private final int sOh;
  private final int sOi;
  private volatile boolean sOj;
  private ad sOk;
  private int sOl;
  private int sOm;
  private int sOn;
  private View sOo;
  public boolean sOp;
  private int sOq;
  public String toUser;
  
  static
  {
    GMTrace.i(1015088676864L, 7563);
    count = 0;
    jWL = new int[] { 0, 15, 30, 45, 60, 75, 90, 100 };
    jWM = new int[] { R.g.bbF, R.g.bbG, R.g.bbH, R.g.bbI, R.g.bbJ, R.g.bbK, R.g.bbL };
    GMTrace.o(1015088676864L, 7563);
  }
  
  public ChatFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(998177243136L, 7437);
    GMTrace.o(998177243136L, 7437);
  }
  
  public ChatFooter(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(998311460864L, 7438);
    this.llc = null;
    this.nto = null;
    this.ntp = null;
    this.sNl = null;
    this.sNw = null;
    this.sNx = new a();
    this.sNy = false;
    this.sNz = false;
    this.jXc = false;
    this.sND = false;
    this.sNE = false;
    this.sNF = false;
    this.sJc = false;
    this.sNI = new l.a()
    {
      public final void clear()
      {
        GMTrace.i(1018309902336L, 7587);
        ChatFooter localChatFooter = ChatFooter.this;
        if (localChatFooter.nto != null) {
          localChatFooter.nto.setText("");
        }
        GMTrace.o(1018309902336L, 7587);
      }
    };
    this.mHandler = new ad()
    {
      @SuppressLint({"NewApi"})
      @TargetApi(11)
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(983681728512L, 7329);
        switch (paramAnonymousMessage.what)
        {
        }
        do
        {
          GMTrace.o(983681728512L, 7329);
          return;
        } while ((ChatFooter.a(ChatFooter.this) == null) || (paramAnonymousMessage.obj == null));
        boolean bool = ((Boolean)paramAnonymousMessage.obj).booleanValue();
        if (bool) {
          ChatFooter.a(ChatFooter.this).setAlpha(1.0F);
        }
        for (;;)
        {
          ChatFooter.a(ChatFooter.this, bool);
          break;
          ChatFooter.a(ChatFooter.this).setAlpha(0.5F);
        }
      }
    };
    this.sNJ = false;
    this.sNL = false;
    this.sNO = new ChatFooterPanel.a()
    {
      public final void Zb()
      {
        GMTrace.i(16374697033728L, 122001);
        ChatFooter.z(ChatFooter.this);
        ChatFooter.A(ChatFooter.this).setVisibility(0);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.a(ChatFooter.this, R.g.beg);
        ChatFooter.a(ChatFooter.this).wti.sendKeyEvent(new KeyEvent(0, 67));
        ChatFooter.a(ChatFooter.this).wti.sendKeyEvent(new KeyEvent(1, 67));
        GMTrace.o(16374697033728L, 122001);
      }
      
      public final void aIG()
      {
        GMTrace.i(16374428598272L, 121999);
        ChatFooter.z(ChatFooter.this);
        ChatFooter.A(ChatFooter.this).setVisibility(0);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.a(ChatFooter.this, R.g.beg);
        if (ChatFooter.h(ChatFooter.this) != null) {
          ChatFooter.h(ChatFooter.this).performClick();
        }
        GMTrace.o(16374428598272L, 121999);
      }
      
      public final void append(String paramAnonymousString)
      {
        GMTrace.i(16374831251456L, 122002);
        ChatFooter.z(ChatFooter.this);
        ChatFooter.A(ChatFooter.this).setVisibility(0);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, true);
        ChatFooter.a(ChatFooter.this, R.g.beg);
        try
        {
          ChatFooter.a(ChatFooter.this).Uw(paramAnonymousString);
          GMTrace.o(16374831251456L, 122002);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          v.printErrStackTrace("MicroMsg.ChatFooter", paramAnonymousString, "", new Object[0]);
          GMTrace.o(16374831251456L, 122002);
        }
      }
      
      public final void fx(boolean paramAnonymousBoolean)
      {
        GMTrace.i(16374562816000L, 122000);
        ChatFooter.z(ChatFooter.this);
        ChatFooter.A(ChatFooter.this).setVisibility(0);
        ChatFooter.r(ChatFooter.this).setVisibility(8);
        ChatFooter.a(ChatFooter.this, R.g.beg);
        if (ChatFooter.a(ChatFooter.this) != null) {
          ChatFooter.this.jC(paramAnonymousBoolean);
        }
        GMTrace.o(16374562816000L, 122000);
      }
    };
    this.sNP = new AppPanel.b()
    {
      public final void bFf()
      {
        GMTrace.i(16380602613760L, 122045);
        boolean bool = com.tencent.mm.pluginsdk.i.a.a(ChatFooter.b(ChatFooter.this), "android.permission.RECORD_AUDIO", 80, "", "");
        v.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bf.bJP(), ChatFooter.b(ChatFooter.this) });
        if (!bool)
        {
          GMTrace.o(16380602613760L, 122045);
          return;
        }
        int i = ap.vd().BR();
        if ((i == 4) || (i == 6))
        {
          ChatFooter.B(ChatFooter.this);
          GMTrace.o(16380602613760L, 122045);
          return;
        }
        if ((ChatFooter.l(ChatFooter.this) == null) || (!ChatFooter.l(ChatFooter.this).isShowing())) {
          ChatFooter.a(ChatFooter.this, com.tencent.mm.ui.base.g.h(ChatFooter.this.getContext(), R.l.fcg, R.l.dIG));
        }
        GMTrace.o(16380602613760L, 122045);
      }
    };
    this.jXl = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(16380199960576L, 122042);
        super.handleMessage(paramAnonymousMessage);
        if (ChatFooter.E(ChatFooter.this) != null)
        {
          ChatFooter.E(ChatFooter.this).dismiss();
          ChatFooter.r(ChatFooter.this).setBackgroundDrawable(com.tencent.mm.bg.a.a(ChatFooter.this.getContext(), R.g.biX));
          ChatFooter.r(ChatFooter.this).setEnabled(true);
        }
        GMTrace.o(16380199960576L, 122042);
      }
    };
    this.sNR = 0;
    this.sNS = false;
    this.sNT = 0;
    this.sNU = 0;
    this.sNV = 1;
    this.sNW = 2;
    this.sNX = 3;
    this.sNY = 20;
    this.sNZ = 21;
    this.sOa = 22;
    this.sOb = 23;
    this.sOc = 0;
    this.sOd = 0;
    this.sOe = -1;
    this.sOf = -1;
    this.sOg = false;
    this.sOh = 4097;
    this.sOi = 4098;
    this.sOk = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(16379663089664L, 122038);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          GMTrace.o(16379663089664L, 122038);
          return;
          ChatFooter.f(ChatFooter.this, true);
          paramAnonymousMessage = ChatFooter.m(ChatFooter.this).getLayoutParams();
          int i = ChatFooter.m(ChatFooter.this).getBottom() - ChatFooter.m(ChatFooter.this).getTop();
          if (ChatFooter.this.bFH())
          {
            if (ChatFooter.n(ChatFooter.this) != null) {
              ChatFooter.n(ChatFooter.this).setVisibility(8);
            }
            ChatFooter.K(ChatFooter.this).setVisibility(8);
            ChatFooter.m(ChatFooter.this).setVisibility(4);
          }
          if (i <= 3)
          {
            ChatFooter.f(ChatFooter.this, false);
            ChatFooter.m(ChatFooter.this).setVisibility(8);
            ChatFooter.b(ChatFooter.this, ChatFooter.this.bFL());
            GMTrace.o(16379663089664L, 122038);
            return;
          }
          paramAnonymousMessage.height = Math.max(i - 60, 1);
          ChatFooter.m(ChatFooter.this).setLayoutParams(paramAnonymousMessage);
          ChatFooter.L(ChatFooter.this);
        }
      }
    };
    this.sOl = -1;
    this.sOm = -1;
    this.sOn = -1;
    this.sOo = null;
    this.sOp = true;
    this.sOq = 0;
    long l = System.currentTimeMillis();
    this.sNB = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.llc = inflate(paramContext, R.i.cXk, this);
    this.nto = ((MMEditText)this.llc.findViewById(R.h.bAa));
    com.tencent.mm.ui.tools.a.c.d(this.nto).Cc(com.tencent.mm.i.b.sw()).a(null);
    this.nto.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
    paramAttributeSet = new mf();
    paramAttributeSet.fTm.fTo = this.nto;
    paramAttributeSet.fTm.fTn = new com.tencent.mm.pluginsdk.ui.a.a()
    {
      public final void MH(final String paramAnonymousString)
      {
        GMTrace.i(987708260352L, 7359);
        v.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", new Object[] { paramAnonymousString });
        if ((bf.mA(ChatFooter.c(ChatFooter.this))) || (bf.mA(paramAnonymousString)))
        {
          v.e("MicroMsg.ChatFooter", "onImageReceived, error args");
          GMTrace.o(987708260352L, 7359);
          return;
        }
        com.tencent.mm.ui.base.g.a(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(R.l.egI), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2Int = 1;
            GMTrace.i(969723084800L, 7225);
            boolean bool = com.tencent.mm.u.m.a(paramAnonymousString, ChatFooter.c(ChatFooter.this), true);
            paramAnonymous2DialogInterface = ChatFooter.this;
            if (bool) {}
            for (;;)
            {
              ChatFooter.a(paramAnonymous2DialogInterface, paramAnonymous2Int, paramAnonymousString);
              GMTrace.o(969723084800L, 7225);
              return;
              paramAnonymous2Int = 0;
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            GMTrace.i(987976695808L, 7361);
            GMTrace.o(987976695808L, 7361);
          }
        });
        GMTrace.o(987708260352L, 7359);
      }
    };
    com.tencent.mm.sdk.b.a.uql.m(paramAttributeSet);
    this.sNo = ((LinearLayout)this.llc.findViewById(R.h.cHA));
    this.sNp = ((ChatFooterBottom)findViewById(R.h.bzV));
    this.sNq = ((ImageButton)this.llc.findViewById(R.h.bzL));
    this.ntp = ((Button)this.llc.findViewById(R.h.bBk));
    getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.ntp.setTextSize(0, com.tencent.mm.bg.a.U(paramContext, R.f.aXr) * com.tencent.mm.bg.a.dK(paramContext));
    this.sNm = ((Button)this.llc.findViewById(R.h.cNo));
    this.sNn = ((ImageButton)findViewById(R.h.bAS));
    fw(false);
    bFP();
    this.sNt = new i(getContext(), getRootView(), this, new i.a()
    {
      public final void MZ(String paramAnonymousString)
      {
        GMTrace.i(1030255280128L, 7676);
        Intent localIntent = new Intent();
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(paramAnonymousString);
        if (ChatFooter.d(ChatFooter.this) != null) {
          localIntent.putExtra("GalleryUI_FromUser", ChatFooter.d(ChatFooter.this));
        }
        if (ChatFooter.e(ChatFooter.this) != null) {
          localIntent.putExtra("GalleryUI_ToUser", ChatFooter.e(ChatFooter.this));
        }
        localIntent.putExtra("query_source_type", 3);
        localIntent.putExtra("preview_image", true);
        localIntent.putStringArrayListExtra("preview_image_list", localArrayList);
        localIntent.putExtra("max_select_count", 1);
        localIntent.addFlags(67108864);
        if (ChatFooter.f(ChatFooter.this) != null)
        {
          com.tencent.mm.bb.d.a(ChatFooter.f(ChatFooter.this), "gallery", ".ui.GalleryEntryUI", localIntent, 217);
          GMTrace.o(1030255280128L, 7676);
          return;
        }
        com.tencent.mm.bb.d.b(paramContext, "gallery", ".ui.GalleryEntryUI", localIntent, 217);
        GMTrace.o(1030255280128L, 7676);
      }
    });
    this.sNt.sOM = this;
    paramContext = getContext();
    getRootView();
    this.sNu = new l(paramContext);
    this.sNu.sNI = this.sNI;
    v.d("MicroMsg.ChatFooter", "send edittext ime option %s", new Object[] { Integer.valueOf(this.nto.getImeOptions()) });
    this.nto.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(980997373952L, 7309);
        if ((paramAnonymousInt == 4) || ((paramAnonymousInt == 0) && (ChatFooter.g(ChatFooter.this))))
        {
          ChatFooter.h(ChatFooter.this).performClick();
          GMTrace.o(980997373952L, 7309);
          return true;
        }
        GMTrace.o(980997373952L, 7309);
        return false;
      }
    });
    this.nto.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(985963429888L, 7346);
        ChatFooter.this.jC(true);
        ChatFooter.i(ChatFooter.this);
        ChatFooter.j(ChatFooter.this).aJu();
        ChatFooter.k(ChatFooter.this);
        GMTrace.o(985963429888L, 7346);
        return false;
      }
    });
    this.nto.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        GMTrace.i(995492888576L, 7417);
        GMTrace.o(995492888576L, 7417);
        return false;
      }
    });
    this.ntp.setOnClickListener(new View.OnClickListener()
    {
      /* Error */
      public final void onClick(View paramAnonymousView)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: ldc2_w 32
        //   5: sipush 7661
        //   8: invokestatic 25	com/tencent/gmtrace/GMTrace:i	(JI)V
        //   11: aload_0
        //   12: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$2:sOr	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
        //   15: invokestatic 37	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/MMEditText;
        //   18: invokevirtual 43	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
        //   21: invokevirtual 47	java/lang/Object:toString	()Ljava/lang/String;
        //   24: astore_1
        //   25: ldc 49
        //   27: ldc 51
        //   29: invokestatic 57	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   32: aload_1
        //   33: invokevirtual 62	java/lang/String:trim	()Ljava/lang/String;
        //   36: invokevirtual 66	java/lang/String:length	()I
        //   39: ifne +76 -> 115
        //   42: aload_1
        //   43: invokevirtual 66	java/lang/String:length	()I
        //   46: ifeq +69 -> 115
        //   49: ldc 49
        //   51: ldc 68
        //   53: invokestatic 57	com/tencent/mm/sdk/platformtools/v:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   56: aload_0
        //   57: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$2:sOr	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
        //   60: invokestatic 72	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:l	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/base/h;
        //   63: ifnull +16 -> 79
        //   66: aload_0
        //   67: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$2:sOr	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
        //   70: invokestatic 72	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:l	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/base/h;
        //   73: invokevirtual 78	com/tencent/mm/ui/base/h:isShowing	()Z
        //   76: ifne +77 -> 153
        //   79: aload_0
        //   80: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$2:sOr	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
        //   83: aload_0
        //   84: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$2:sOr	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
        //   87: invokevirtual 82	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
        //   90: getstatic 88	com/tencent/mm/R$l:dTi	I
        //   93: getstatic 91	com/tencent/mm/R$l:dIG	I
        //   96: invokestatic 97	com/tencent/mm/ui/base/g:h	(Landroid/content/Context;II)Lcom/tencent/mm/ui/base/h;
        //   99: invokestatic 100	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;Lcom/tencent/mm/ui/base/h;)Lcom/tencent/mm/ui/base/h;
        //   102: pop
        //   103: ldc2_w 32
        //   106: sipush 7661
        //   109: invokestatic 28	com/tencent/gmtrace/GMTrace:o	(JI)V
        //   112: aload_0
        //   113: monitorexit
        //   114: return
        //   115: aload_0
        //   116: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$2:sOr	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
        //   119: invokestatic 104	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:j	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/pluginsdk/ui/chat/b;
        //   122: aload_1
        //   123: invokeinterface 110 2 0
        //   128: ifeq +25 -> 153
        //   131: aload_0
        //   132: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$2:sOr	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
        //   135: invokestatic 37	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/MMEditText;
        //   138: invokevirtual 113	com/tencent/mm/ui/widget/MMEditText:clearComposingText	()V
        //   141: aload_0
        //   142: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$2:sOr	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
        //   145: invokestatic 37	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/MMEditText;
        //   148: ldc 115
        //   150: invokevirtual 119	com/tencent/mm/ui/widget/MMEditText:setText	(Ljava/lang/CharSequence;)V
        //   153: ldc2_w 32
        //   156: sipush 7661
        //   159: invokestatic 28	com/tencent/gmtrace/GMTrace:o	(JI)V
        //   162: goto -50 -> 112
        //   165: astore_1
        //   166: aload_0
        //   167: monitorexit
        //   168: aload_1
        //   169: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	170	0	this	2
        //   0	170	1	paramAnonymousView	View
        // Exception table:
        //   from	to	target	type
        //   2	79	165	finally
        //   79	112	165	finally
        //   115	153	165	finally
        //   153	162	165	finally
      }
    });
    this.sNm.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(16375099686912L, 122004);
        if (paramAnonymousView != ChatFooter.r(ChatFooter.this))
        {
          GMTrace.o(16375099686912L, 122004);
          return false;
        }
        v.v("RcdBtnEvent", "event.getAction():" + paramAnonymousMotionEvent.getAction());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          GMTrace.o(16375099686912L, 122004);
          return false;
          v.i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", new Object[] { Integer.valueOf(ChatFooter.bFR()) });
          if ((ChatFooter.s(ChatFooter.this) instanceof Activity)) {
            ((Activity)ChatFooter.s(ChatFooter.this)).getWindow().addFlags(128);
          }
          if ((!ChatFooter.t(ChatFooter.this)) && (!ChatFooter.u(ChatFooter.this)))
          {
            ChatFooter.c(ChatFooter.this, true);
            ChatFooter.r(ChatFooter.this).setBackgroundDrawable(com.tencent.mm.bg.a.a(ChatFooter.this.getContext(), R.g.biY));
            ChatFooter.r(ChatFooter.this).setText(R.l.dSP);
            ChatFooter.j(ChatFooter.this).aJr();
            ChatFooter.r(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(R.l.dSs));
            continue;
            if ((ChatFooter.v(ChatFooter.this) == null) || (ChatFooter.w(ChatFooter.this) == null)) {
              v.e("MicroMsg.ChatFooter", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", new Object[] { ChatFooter.v(ChatFooter.this), ChatFooter.w(ChatFooter.this) });
            }
            if ((paramAnonymousMotionEvent.getX() > 0.0F) && (paramAnonymousMotionEvent.getY() > -ChatFooter.x(ChatFooter.this) / 2) && (paramAnonymousMotionEvent.getX() < ChatFooter.r(ChatFooter.this).getWidth()))
            {
              if (ChatFooter.v(ChatFooter.this) != null) {
                ChatFooter.v(ChatFooter.this).setVisibility(0);
              }
              if (ChatFooter.w(ChatFooter.this) != null)
              {
                ChatFooter.r(ChatFooter.this).setText(R.l.dSP);
                ChatFooter.w(ChatFooter.this).setVisibility(8);
              }
            }
            else
            {
              v.i("MicroMsg.ChatFooter", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()), Integer.valueOf(ChatFooter.x(ChatFooter.this)), Integer.valueOf(ChatFooter.r(ChatFooter.this).getWidth()), Integer.valueOf(ChatFooter.r(ChatFooter.this).getHeight()) });
              if (ChatFooter.v(ChatFooter.this) != null) {
                ChatFooter.v(ChatFooter.this).setVisibility(8);
              }
              if (ChatFooter.w(ChatFooter.this) != null)
              {
                ChatFooter.r(ChatFooter.this).setText(R.l.dSz);
                ChatFooter.w(ChatFooter.this).setVisibility(0);
                continue;
                if ((ChatFooter.s(ChatFooter.this) instanceof Activity)) {
                  ((Activity)ChatFooter.s(ChatFooter.this)).getWindow().clearFlags(128);
                }
                v.i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.bFR()) });
                ChatFooter.y(ChatFooter.this);
                v.i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", new Object[] { Integer.valueOf(ChatFooter.bFS()) });
              }
            }
          }
        }
      }
    });
    this.sNm.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        GMTrace.i(16379394654208L, 122036);
        switch (paramAnonymousKeyEvent.getAction())
        {
        }
        for (;;)
        {
          GMTrace.o(16379394654208L, 122036);
          return false;
          if (((paramAnonymousInt == 23) || (paramAnonymousInt == 66)) && (!ChatFooter.u(ChatFooter.this)) && (!ChatFooter.t(ChatFooter.this)))
          {
            ChatFooter.d(ChatFooter.this, true);
            ChatFooter.r(ChatFooter.this).setBackgroundDrawable(com.tencent.mm.bg.a.a(ChatFooter.this.getContext(), R.g.biY));
            ChatFooter.r(ChatFooter.this).setText(R.l.dSP);
            ChatFooter.j(ChatFooter.this).aJr();
            ChatFooter.r(ChatFooter.this).setContentDescription(ChatFooter.this.getContext().getString(R.l.dSs));
            continue;
            if ((paramAnonymousInt == 23) || (paramAnonymousInt == 66))
            {
              ChatFooter.r(ChatFooter.this).setBackgroundDrawable(com.tencent.mm.bg.a.a(ChatFooter.this.getContext(), R.g.biX));
              ChatFooter.r(ChatFooter.this).setText(R.l.dSO);
              ChatFooter.j(ChatFooter.this).aJo();
              ChatFooter.d(ChatFooter.this, false);
            }
          }
        }
      }
    });
    this.sNn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(16381273702400L, 122050);
        ChatFooter.q(ChatFooter.this);
        GMTrace.o(16381273702400L, 122050);
      }
    });
    bFj();
    this.sNq.setVisibility(0);
    this.sNq.setContentDescription(getContext().getString(R.l.dSp));
    this.sNq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(981265809408L, 7311);
        ChatFooter.this.bFh();
        if ((com.tencent.mm.u.m.yt().booleanValue()) && (ChatFooter.this.sNG != null)) {
          ChatFooter.this.sNG.a(Boolean.valueOf(true), Boolean.valueOf(true));
        }
        GMTrace.o(981265809408L, 7311);
      }
    });
    xB(-1);
    findViewById(R.h.bAo).setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(988245131264L, 7363);
        GMTrace.o(988245131264L, 7363);
        return true;
      }
    });
    v.d("MicroMsg.ChatFooter", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    GMTrace.o(998311460864L, 7438);
  }
  
  public static void bFI()
  {
    GMTrace.i(1005693435904L, 7493);
    GMTrace.o(1005693435904L, 7493);
  }
  
  private boolean bFK()
  {
    GMTrace.i(1006364524544L, 7498);
    if ((this.sOe > 0) && (this.sOe < this.sOf))
    {
      GMTrace.o(1006364524544L, 7498);
      return true;
    }
    GMTrace.o(1006364524544L, 7498);
    return false;
  }
  
  private void bFj()
  {
    GMTrace.i(1000056291328L, 7451);
    this.sNk = ((AppPanel)findViewById(R.h.bzg));
    this.sNk.sMo = this.sNP;
    this.sNk.xu(bFL());
    if ((com.tencent.mm.u.o.fE(this.kTm)) || (com.tencent.mm.u.o.fx(this.kTm)))
    {
      this.sNk.init(0);
      GMTrace.o(1000056291328L, 7451);
      return;
    }
    if (com.tencent.mm.u.o.eV(this.kTm))
    {
      this.sNk.init(4);
      GMTrace.o(1000056291328L, 7451);
      return;
    }
    if (com.tencent.mm.u.o.dH(this.kTm))
    {
      this.sNk.init(2);
      GMTrace.o(1000056291328L, 7451);
      return;
    }
    this.sNk.init(1);
    GMTrace.o(1000056291328L, 7451);
  }
  
  private void fw(boolean paramBoolean)
  {
    GMTrace.i(998982549504L, 7443);
    if (this.sNM == null)
    {
      this.sNM = AnimationUtils.loadAnimation(getContext(), R.a.aRm);
      this.sNM.setDuration(150L);
    }
    if (this.sNN == null)
    {
      this.sNN = AnimationUtils.loadAnimation(getContext(), R.a.aRn);
      this.sNN.setDuration(150L);
    }
    if ((this.ntp == null) || (this.sNq == null))
    {
      GMTrace.o(998982549504L, 7443);
      return;
    }
    if (this.sNJ)
    {
      if (this.sNq.getVisibility() != 0) {
        this.sNq.setVisibility(0);
      }
      GMTrace.o(998982549504L, 7443);
      return;
    }
    if ((this.ntp.getVisibility() == 0) && (paramBoolean))
    {
      GMTrace.o(998982549504L, 7443);
      return;
    }
    if ((this.sNq.getVisibility() == 0) && (!paramBoolean))
    {
      GMTrace.o(998982549504L, 7443);
      return;
    }
    if (paramBoolean)
    {
      this.ntp.startAnimation(this.sNM);
      this.ntp.setVisibility(0);
      this.sNq.startAnimation(this.sNN);
      this.sNq.setVisibility(8);
    }
    for (;;)
    {
      v.i("MicroMsg.ChatFooter", "jacks canSend:%B", new Object[] { Boolean.valueOf(paramBoolean) });
      this.ntp.getParent().requestLayout();
      GMTrace.o(998982549504L, 7443);
      return;
      this.sNq.startAnimation(this.sNM);
      if (!this.sNz) {
        this.sNq.setVisibility(0);
      }
      this.ntp.startAnimation(this.sNN);
      this.ntp.setVisibility(8);
    }
  }
  
  private void jD(boolean paramBoolean)
  {
    GMTrace.i(1007035613184L, 7503);
    if (this.sNr == null)
    {
      GMTrace.o(1007035613184L, 7503);
      return;
    }
    if ((this.sOg) && (paramBoolean))
    {
      GMTrace.o(1007035613184L, 7503);
      return;
    }
    if ((!this.sOg) && (!paramBoolean))
    {
      GMTrace.o(1007035613184L, 7503);
      return;
    }
    this.sOg = paramBoolean;
    if (paramBoolean)
    {
      this.sNr.setImageDrawable(getContext().getResources().getDrawable(R.g.bef));
      GMTrace.o(1007035613184L, 7503);
      return;
    }
    this.sNr.setImageDrawable(getContext().getResources().getDrawable(R.g.bee));
    GMTrace.o(1007035613184L, 7503);
  }
  
  private void xv(int paramInt)
  {
    GMTrace.i(999922073600L, 7450);
    if (this.sNn == null)
    {
      GMTrace.o(999922073600L, 7450);
      return;
    }
    if (paramInt == R.g.beg) {}
    for (int i = 1;; i = 0)
    {
      if (this.sNn != null)
      {
        if (i == 0) {
          break label92;
        }
        this.sNn.setContentDescription(getContext().getString(R.l.dSr));
      }
      for (;;)
      {
        this.sNn.setImageResource(paramInt);
        this.sNn.setPadding(0, 0, 0, 0);
        GMTrace.o(999922073600L, 7450);
        return;
        label92:
        this.sNn.setContentDescription(getContext().getString(R.l.dSq));
      }
    }
  }
  
  private void xz(int paramInt)
  {
    GMTrace.i(1002203774976L, 7467);
    this.sNC = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(1002203774976L, 7467);
      return;
      this.sNo.setVisibility(0);
      this.sNm.setVisibility(8);
      xv(R.g.beg);
      GMTrace.o(1002203774976L, 7467);
      return;
      this.sNo.setVisibility(8);
      this.sNm.setVisibility(0);
      xv(R.g.bef);
      if ((com.tencent.mm.u.m.yt().booleanValue()) && (this.sNG != null)) {
        this.sNG.b(Boolean.valueOf(true), Boolean.valueOf(true));
      }
    }
  }
  
  public final void MU(String paramString)
  {
    GMTrace.i(1000458944512L, 7454);
    this.sNx.sOw = paramString;
    GMTrace.o(1000458944512L, 7454);
  }
  
  public final void MV(String paramString)
  {
    GMTrace.i(1000593162240L, 7455);
    this.sNx.sOv = paramString;
    GMTrace.o(1000593162240L, 7455);
  }
  
  public final void MW(String paramString)
  {
    GMTrace.i(1000861597696L, 7457);
    p(paramString, -1, true);
    GMTrace.o(1000861597696L, 7457);
  }
  
  public final void MX(String paramString)
  {
    GMTrace.i(1001666904064L, 7463);
    if ((paramString == null) || (this.sNA == null))
    {
      GMTrace.o(1001666904064L, 7463);
      return;
    }
    this.sNA.setText(paramString);
    GMTrace.o(1001666904064L, 7463);
  }
  
  public final void MY(String paramString)
  {
    GMTrace.i(1007706701824L, 7508);
    this.kTm = paramString;
    if (this.ntq != null) {
      this.ntq.uB(this.kTm);
    }
    if (this.sNk != null)
    {
      if ((com.tencent.mm.u.o.fE(this.kTm)) || (com.tencent.mm.u.o.fx(this.kTm)))
      {
        this.sNk.sMu = 0;
        GMTrace.o(1007706701824L, 7508);
        return;
      }
      if (com.tencent.mm.u.o.eV(this.kTm))
      {
        this.sNk.sMu = 4;
        GMTrace.o(1007706701824L, 7508);
        return;
      }
      if (com.tencent.mm.u.o.dH(this.kTm))
      {
        this.sNk.sMu = 2;
        GMTrace.o(1007706701824L, 7508);
        return;
      }
      this.sNk.sMu = 1;
    }
    GMTrace.o(1007706701824L, 7508);
  }
  
  public final void X(String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(14460215361536L, 107737);
    if (this.sNx.sOy.containsKey(paramString1)) {}
    Object localObject;
    for (paramString1 = (LinkedList)this.sNx.sOy.get(paramString1);; paramString1 = (String)localObject)
    {
      localObject = new HashMap(1);
      ((HashMap)localObject).put(paramString3, paramString2);
      paramString1.add(localObject);
      GMTrace.o(14460215361536L, 107737);
      return;
      localObject = new LinkedList();
      this.sNx.sOy.put(paramString1, localObject);
    }
  }
  
  public final void a(Context paramContext, Activity paramActivity)
  {
    GMTrace.i(998445678592L, 7439);
    this.activity = paramActivity;
    bFP();
    if (this.ntq != null) {
      this.ntq.onResume();
    }
    if ((!this.sNJ) && (this.sNE))
    {
      v.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
      this.sNE = false;
      this.nto.setImeOptions(0);
      this.nto.setInputType(this.nto.getInputType() | 0x40);
    }
    for (;;)
    {
      if (this.sNk != null) {
        this.sNk.context = paramContext;
      }
      this.context = paramContext;
      this.sNt.sOL = false;
      if (!this.sJc)
      {
        this.llc.findViewById(R.h.bBm).setVisibility(0);
        this.nto.setVisibility(0);
      }
      bFB();
      post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(988513566720L, 7365);
          com.tencent.mm.compatible.util.j.f(ChatFooter.b(ChatFooter.this));
          GMTrace.o(988513566720L, 7365);
        }
      });
      GMTrace.o(998445678592L, 7439);
      return;
      if ((this.sNJ) && (!this.sNE)) {
        bFE();
      }
    }
  }
  
  @TargetApi(11)
  public final void a(View.OnDragListener paramOnDragListener)
  {
    GMTrace.i(1005425000448L, 7491);
    this.nto.setOnDragListener(paramOnDragListener);
    GMTrace.o(1005425000448L, 7491);
  }
  
  public final void a(AppPanel.a parama)
  {
    GMTrace.i(1005559218176L, 7492);
    this.sNk.sMn = parama;
    GMTrace.o(1005559218176L, 7492);
  }
  
  public final void a(d paramd)
  {
    GMTrace.i(1005827653632L, 7494);
    this.sNw = paramd;
    if (paramd == null)
    {
      GMTrace.o(1005827653632L, 7494);
      return;
    }
    paramd = findViewById(R.h.bAT);
    paramd.setVisibility(0);
    paramd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(16375502340096L, 122007);
        if (ChatFooter.I(ChatFooter.this) != null) {
          ChatFooter.I(ChatFooter.this).jE(false);
        }
        GMTrace.o(16375502340096L, 122007);
      }
    });
    GMTrace.o(1005827653632L, 7494);
  }
  
  public final void a(j paramj)
  {
    GMTrace.i(999787855872L, 7449);
    this.sNu.sOW = paramj;
    GMTrace.o(999787855872L, 7449);
  }
  
  public final void ab(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    GMTrace.i(1002337992704L, 7468);
    xz(paramInt);
    switch (paramInt)
    {
    default: 
      setVisibility(0);
      GMTrace.o(1002337992704L, 7468);
      return;
    case 1: 
      jy(true);
      bFM();
      if (paramBoolean)
      {
        r(1, -1, true);
        if (this.nto.length() > 0) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          fw(paramBoolean);
          GMTrace.o(1002337992704L, 7468);
          return;
        }
      }
      fw(false);
      GMTrace.o(1002337992704L, 7468);
      return;
    }
    r(0, -1, false);
    fw(false);
    GMTrace.o(1002337992704L, 7468);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    GMTrace.i(1001398468608L, 7461);
    this.sNQ = new e(paramTextWatcher);
    this.nto.addTextChangedListener(this.sNQ);
    GMTrace.o(1001398468608L, 7461);
  }
  
  public final void anI()
  {
    GMTrace.i(999519420416L, 7447);
    this.sNF = true;
    if (this.ntq != null) {
      this.ntq.anI();
    }
    GMTrace.o(999519420416L, 7447);
  }
  
  public final void auE()
  {
    GMTrace.i(1001935339520L, 7465);
    post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(16380736831488L, 122046);
        if (ChatFooter.E(ChatFooter.this) != null)
        {
          ChatFooter.E(ChatFooter.this).dismiss();
          ChatFooter.F(ChatFooter.this).setVisibility(0);
          ChatFooter.G(ChatFooter.this).setVisibility(8);
          ChatFooter.H(ChatFooter.this).setVisibility(8);
          ChatFooter.w(ChatFooter.this).setVisibility(8);
          ChatFooter.v(ChatFooter.this).setVisibility(0);
        }
        ChatFooter.r(ChatFooter.this).setBackgroundDrawable(com.tencent.mm.bg.a.a(ChatFooter.this.getContext(), R.g.biX));
        ChatFooter.r(ChatFooter.this).setText(R.l.dSO);
        ChatFooter.d(ChatFooter.this, false);
        ChatFooter.c(ChatFooter.this, false);
        GMTrace.o(16380736831488L, 122046);
      }
    });
    GMTrace.o(1001935339520L, 7465);
  }
  
  public final void b(f paramf)
  {
    GMTrace.i(999653638144L, 7448);
    this.sGT = paramf;
    if (this.ntq != null) {
      this.ntq.a(paramf);
    }
    GMTrace.o(999653638144L, 7448);
  }
  
  public final void bEp()
  {
    GMTrace.i(1000324726784L, 7453);
    if (!this.sJc)
    {
      GMTrace.o(1000324726784L, 7453);
      return;
    }
    View localView = findViewById(R.h.bAo);
    this.sJc = false;
    if (this.sIY != null)
    {
      this.sIY.destory();
      this.sIY.setVisibility(8);
    }
    localView.setVisibility(0);
    this.nto.setVisibility(0);
    this.nto.setText("");
    jy(true);
    bFB();
    r(0, -1, false);
    GMTrace.o(1000324726784L, 7453);
  }
  
  public final void bFA()
  {
    GMTrace.i(1004485476352L, 7484);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMr.sMU.value = false;
    localAppPanel.bEY();
    GMTrace.o(1004485476352L, 7484);
  }
  
  public final void bFB()
  {
    GMTrace.i(1004619694080L, 7485);
    this.sNr = ((ImageButton)this.llc.findViewById(R.h.bBo));
    this.sNr.setVisibility(0);
    this.sNr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(16380468396032L, 122044);
        ChatFooter.j(ChatFooter.this).aJs();
        if ((!ChatFooter.m(ChatFooter.this).fXt) && (ChatFooter.n(ChatFooter.this) != null) && (ChatFooter.n(ChatFooter.this).getVisibility() == 0))
        {
          ChatFooter.this.r(1, -1, true);
          GMTrace.o(16380468396032L, 122044);
          return;
        }
        if (ChatFooter.o(ChatFooter.this)) {
          ChatFooter.this.anI();
        }
        ChatFooter.this.bFk();
        if (!bf.mA(ChatFooter.a(ChatFooter.this).getText().toString())) {
          ChatFooter.n(ChatFooter.this).anN();
        }
        GMTrace.o(16380468396032L, 122044);
      }
    });
    if (this.sNu != null) {
      this.sNu.sOV = this.sNr;
    }
    GMTrace.o(1004619694080L, 7485);
  }
  
  public final void bFC()
  {
    GMTrace.i(1004753911808L, 7486);
    if (this.sNr != null) {
      this.sNr.setVisibility(8);
    }
    GMTrace.o(1004753911808L, 7486);
  }
  
  public final void bFD()
  {
    GMTrace.i(1004888129536L, 7487);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMB = true;
    localAppPanel.sMr.jx(false);
    localAppPanel.bEY();
    GMTrace.o(1004888129536L, 7487);
  }
  
  public final void bFE()
  {
    GMTrace.i(1005022347264L, 7488);
    v.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
    this.sNE = true;
    this.nto.setImeOptions(4);
    this.nto.setInputType(this.nto.getInputType() & 0xFFFFFFBF);
    GMTrace.o(1005022347264L, 7488);
  }
  
  public final void bFF()
  {
    GMTrace.i(1005156564992L, 7489);
    if (this.ntq != null) {
      this.ntq.refresh();
    }
    GMTrace.o(1005156564992L, 7489);
  }
  
  public final void bFG()
  {
    GMTrace.i(5893232001024L, 43908);
    this.sNk.refresh();
    GMTrace.o(5893232001024L, 43908);
  }
  
  public final boolean bFH()
  {
    GMTrace.i(1005290782720L, 7490);
    if (this.sNp.getVisibility() == 0)
    {
      GMTrace.o(1005290782720L, 7490);
      return true;
    }
    GMTrace.o(1005290782720L, 7490);
    return false;
  }
  
  public final void bFJ()
  {
    GMTrace.i(1006096089088L, 7496);
    r(2, 20, false);
    GMTrace.o(1006096089088L, 7496);
  }
  
  public final int bFL()
  {
    GMTrace.i(1006767177728L, 7501);
    int i = com.tencent.mm.compatible.util.j.c(getContext(), true);
    GMTrace.o(1006767177728L, 7501);
    return i;
  }
  
  public final void bFM()
  {
    GMTrace.i(1007169830912L, 7504);
    this.sNp.setVisibility(8);
    this.sNk.setVisibility(8);
    if (this.ntq != null) {
      this.ntq.setVisibility(8);
    }
    jD(false);
    GMTrace.o(1007169830912L, 7504);
  }
  
  public final void bFN()
  {
    GMTrace.i(1007438266368L, 7506);
    this.jXc = false;
    this.sNm.setBackgroundDrawable(com.tencent.mm.bg.a.a(getContext(), R.g.biX));
    this.sNm.setText(R.l.dSO);
    if (this.sNv != null)
    {
      if ((this.lLW != null) && (this.lLW.getVisibility() == 0))
      {
        this.sNv.aJq();
        GMTrace.o(1007438266368L, 7506);
        return;
      }
      this.sNv.aJo();
    }
    GMTrace.o(1007438266368L, 7506);
  }
  
  public final boolean bFO()
  {
    GMTrace.i(1007572484096L, 7507);
    if (this.sOd - getTop() > 50)
    {
      GMTrace.o(1007572484096L, 7507);
      return true;
    }
    GMTrace.o(1007572484096L, 7507);
    return false;
  }
  
  public final void bFP()
  {
    GMTrace.i(1007840919552L, 7509);
    ap.yY();
    this.sNJ = ((Boolean)com.tencent.mm.u.c.vr().get(66832, Boolean.valueOf(false))).booleanValue();
    GMTrace.o(1007840919552L, 7509);
  }
  
  public final int bFQ()
  {
    GMTrace.i(1008243572736L, 7512);
    int i = com.tencent.mm.compatible.util.j.aD(getContext());
    int j = getHeight();
    if (j < i)
    {
      GMTrace.o(1008243572736L, 7512);
      return j + i;
    }
    GMTrace.o(1008243572736L, 7512);
    return j;
  }
  
  public final void bFg()
  {
    GMTrace.i(998848331776L, 7442);
    if (this.sNk == null)
    {
      GMTrace.o(998848331776L, 7442);
      return;
    }
    this.sNk.bEW();
    GMTrace.o(998848331776L, 7442);
  }
  
  public final void bFh()
  {
    GMTrace.i(999116767232L, 7444);
    this.sNv.aJt();
    if ((this.sNk.getVisibility() == 0) && (!this.sNp.fXt))
    {
      if (this.sNC == 1)
      {
        r(1, -1, true);
        GMTrace.o(999116767232L, 7444);
        return;
      }
      r(0, -1, false);
      GMTrace.o(999116767232L, 7444);
      return;
    }
    r(2, 22, true);
    if ((this.sIY != null) && (this.sIY.getVisibility() == 0) && (this.sJc))
    {
      v.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
      this.sIY.setVisibility(8);
      this.sJc = false;
      this.sIY.reset();
    }
    Object localObject = ao.bDf();
    Context localContext = aa.getContext();
    if ((!ap.zb()) || (localContext == null)) {}
    for (;;)
    {
      localObject = ao.bDf();
      localContext = aa.getContext();
      if ((!ap.zb()) || (localContext == null)) {
        break label573;
      }
      if (!((ao)localObject).sCQ) {
        break;
      }
      v.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
      GMTrace.o(999116767232L, 7444);
      return;
      try
      {
        String str = com.tencent.mm.i.g.sV().getValue("ShowAPPSuggestion");
        if ((bf.mA(str)) || (Integer.valueOf(str).intValue() != 1)) {
          v.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", new Object[] { str });
        }
      }
      catch (Exception localException)
      {
        v.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", new Object[] { localException.getMessage() });
        if (((ao)localObject).sCP)
        {
          v.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
        }
        else
        {
          v.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
          ((ao)localObject).sCP = true;
          if (System.currentTimeMillis() - ((ao)localObject).sCS < 43200000L)
          {
            v.d("MicroMsg.SuggestionAppListLogic", "not now");
            ((ao)localObject).sCP = false;
          }
          else
          {
            ap.yY();
            ((ao)localObject).sCS = com.tencent.mm.u.c.vr().yw(352275);
            if (System.currentTimeMillis() - ((ao)localObject).sCS < 43200000L)
            {
              v.w("MicroMsg.SuggestionAppListLogic", "not now sp");
              ((ao)localObject).sCP = false;
            }
            else
            {
              if (((ao)localObject).lang == null) {
                ((ao)localObject).lang = u.d(localContext.getSharedPreferences(aa.bIN(), 0));
              }
              localObject = new ag(((ao)localObject).lang, new LinkedList());
              an.aBz();
              com.tencent.mm.pluginsdk.model.app.d.a(4, (w)localObject);
            }
          }
        }
      }
    }
    ((ao)localObject).sCQ = true;
    if (System.currentTimeMillis() - ((ao)localObject).sCV < 43200000L)
    {
      v.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
      ((ao)localObject).sCQ = false;
      GMTrace.o(999116767232L, 7444);
      return;
    }
    ap.yY();
    ((ao)localObject).sCV = com.tencent.mm.u.c.vr().yw(352276);
    if (System.currentTimeMillis() - ((ao)localObject).sCV < 43200000L)
    {
      v.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
      ((ao)localObject).sCQ = false;
      GMTrace.o(999116767232L, 7444);
      return;
    }
    if (((ao)localObject).lang == null) {
      ((ao)localObject).lang = u.d(localContext.getSharedPreferences(aa.bIN(), 0));
    }
    ao.cx(((ao)localObject).lang, ((ao)localObject).sCU);
    label573:
    GMTrace.o(999116767232L, 7444);
  }
  
  public final void bFi()
  {
    GMTrace.i(999385202688L, 7446);
    if (e.sOF == null)
    {
      this.ntq = new d(this.context);
      GMTrace.o(999385202688L, 7446);
      return;
    }
    if (this.ntq != null) {
      this.ntq.destroy();
    }
    this.ntq = e.sOF.bR(this.context);
    ChatFooterPanel localChatFooterPanel;
    if (this.ntq != null)
    {
      this.ntq.ls(ChatFooterPanel.sGW);
      if (this.ntq != null) {
        this.ntq.setVisibility(8);
      }
      if (this.ntq != null) {
        this.ntq.xf(this.sGU);
      }
      if (this.sNp != null) {
        this.sNp.addView(this.ntq, -1, -2);
      }
      if (this.ntq != null) {
        this.ntq.sGS = this.sNO;
      }
      if (this.ntq != null)
      {
        localChatFooterPanel = this.ntq;
        if (this.nto.getText().length() <= 0) {
          break label275;
        }
      }
    }
    label275:
    for (boolean bool = true;; bool = false)
    {
      localChatFooterPanel.dx(bool);
      if (this.ntq != null)
      {
        this.ntq.uB(this.kTm);
        this.ntq.lr(bFL());
        if (!bf.mA(this.nto.getText().toString())) {
          this.ntq.anN();
        }
      }
      if (this.sNF) {
        anI();
      }
      b(this.sGT);
      GMTrace.o(999385202688L, 7446);
      return;
    }
  }
  
  public final void bFk()
  {
    GMTrace.i(1000190509056L, 7452);
    this.sNC = 1;
    this.sNo.setVisibility(0);
    this.sNm.setVisibility(8);
    xv(R.g.beg);
    if (this.sIY != null)
    {
      this.sIY.setVisibility(8);
      this.sJc = false;
      this.sIY.reset();
    }
    r(2, 21, true);
    GMTrace.o(1000190509056L, 7452);
  }
  
  public final void bFl()
  {
    GMTrace.i(1001130033152L, 7459);
    this.sNm.setEnabled(false);
    this.sNm.setBackgroundDrawable(com.tencent.mm.bg.a.a(getContext(), R.g.biW));
    if (this.qXA != null)
    {
      this.lLU.setVisibility(0);
      this.lLT.setVisibility(8);
      this.qXD.setVisibility(8);
      this.qXA.update();
    }
    this.jXl.sendEmptyMessageDelayed(0, 500L);
    GMTrace.o(1001130033152L, 7459);
  }
  
  public final String bFm()
  {
    GMTrace.i(1001264250880L, 7460);
    if (this.nto == null)
    {
      GMTrace.o(1001264250880L, 7460);
      return "";
    }
    String str = this.nto.getText().toString();
    GMTrace.o(1001264250880L, 7460);
    return str;
  }
  
  public final void bFn()
  {
    GMTrace.i(1001801121792L, 7464);
    this.qXD.setVisibility(8);
    this.lLT.setVisibility(0);
    GMTrace.o(1001801121792L, 7464);
  }
  
  public final void bFo()
  {
    GMTrace.i(1002606428160L, 7470);
    this.sNo.setVisibility(0);
    this.sNn.setVisibility(8);
    this.sNm.setVisibility(8);
    GMTrace.o(1002606428160L, 7470);
  }
  
  public final void bFp()
  {
    GMTrace.i(1002740645888L, 7471);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMr.sML.value = false;
    localAppPanel.bEY();
    GMTrace.o(1002740645888L, 7471);
  }
  
  public final void bFq()
  {
    GMTrace.i(1002874863616L, 7472);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMr.sNd.value = false;
    localAppPanel.bEY();
    GMTrace.o(1002874863616L, 7472);
  }
  
  public final void bFr()
  {
    GMTrace.i(1003009081344L, 7473);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMr.sMM.value = false;
    localAppPanel.bEY();
    GMTrace.o(1003009081344L, 7473);
  }
  
  public final void bFs()
  {
    GMTrace.i(1003143299072L, 7474);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMr.sMO.value = false;
    localAppPanel.bEY();
    GMTrace.o(1003143299072L, 7474);
  }
  
  public final void bFt()
  {
    GMTrace.i(1003277516800L, 7475);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMr.sMP.value = false;
    localAppPanel.bEY();
    GMTrace.o(1003277516800L, 7475);
  }
  
  public final void bFu()
  {
    GMTrace.i(1003411734528L, 7476);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMr.sNc.value = false;
    localAppPanel.bEY();
    GMTrace.o(1003411734528L, 7476);
  }
  
  public final void bFv()
  {
    GMTrace.i(1003545952256L, 7477);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMr.sMQ.value = false;
    localAppPanel.bEY();
    v.d("MicroMsg.AppPanel", "enable false" + " isVoipPluginEnable " + localAppPanel.sMr.sMR.value);
    this.sNk.jt(true);
    GMTrace.o(1003545952256L, 7477);
  }
  
  public final void bFw()
  {
    GMTrace.i(1003948605440L, 7480);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMz = true;
    localAppPanel.sMr.jw(false);
    localAppPanel.bEY();
    GMTrace.o(1003948605440L, 7480);
  }
  
  public final void bFx()
  {
    GMTrace.i(1004082823168L, 7481);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMA = true;
    localAppPanel.sMr.jv(false);
    localAppPanel.bEY();
    GMTrace.o(1004082823168L, 7481);
  }
  
  public final void bFy()
  {
    GMTrace.i(1004217040896L, 7482);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMr.sMV.value = false;
    localAppPanel.bEY();
    v.d("MicroMsg.AppPanel", "disableTalkroom enable false");
    GMTrace.o(1004217040896L, 7482);
  }
  
  public final void bFz()
  {
    GMTrace.i(1004351258624L, 7483);
    AppPanel localAppPanel = this.sNk;
    localAppPanel.sMr.sNa.value = false;
    localAppPanel.bEY();
    GMTrace.o(1004351258624L, 7483);
  }
  
  public final void destroy()
  {
    GMTrace.i(998714114048L, 7441);
    if (this.ntq != null)
    {
      v.i("MicroMsg.ChatFooter", "jacks chat footer desctory smiley panel");
      this.ntq.anH();
      this.ntq.destroy();
      this.ntq = null;
    }
    if (this.sIY != null)
    {
      this.sIY.reset();
      this.sJc = false;
    }
    if (this.sNv != null) {
      this.sNv.release();
    }
    if (this.sNu != null)
    {
      this.sNu.sNI = null;
      this.sNu.sOW = null;
      this.sNu.hide();
    }
    v.d("MicroMsg.ChatFooter", "jacks destory");
    GMTrace.o(998714114048L, 7441);
  }
  
  public final HashMap<String, String> em(String paramString1, String paramString2)
  {
    GMTrace.i(14460349579264L, 107738);
    v.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] :%s :%s", new Object[] { paramString1, paramString2 });
    long l = System.currentTimeMillis();
    if (bf.mA(paramString2))
    {
      if (this.sNx.sOy.containsKey(paramString1)) {
        this.sNx.sOy.remove(paramString1);
      }
      GMTrace.o(14460349579264L, 107738);
      return null;
    }
    if ((!this.sNx.sOy.containsKey(paramString1)) || (((LinkedList)this.sNx.sOy.get(paramString1)).size() <= 0))
    {
      GMTrace.o(14460349579264L, 107738);
      return null;
    }
    Object localObject = new LinkedList();
    int j;
    for (int i = 0; i < paramString2.length(); i = j + 1)
    {
      i = paramString2.indexOf("@", i);
      if (i == -1) {
        break;
      }
      j = paramString2.indexOf(' ', i);
      if ((j == -1) || (j - i > 40)) {
        break;
      }
      ((List)localObject).add(paramString2.substring(i + 1, j));
    }
    v.i("MicroMsg.ChatFooter", "after split @ :%s", new Object[] { localObject });
    if (((List)localObject).size() <= 0)
    {
      ((LinkedList)this.sNx.sOy.get(paramString1)).clear();
      GMTrace.o(14460349579264L, 107738);
      return null;
    }
    paramString1 = (LinkedList)this.sNx.sOy.get(paramString1);
    if ((paramString1 != null) && (paramString1.size() > 0))
    {
      v.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", new Object[] { Integer.valueOf(paramString1.size()) });
      paramString2 = new LinkedList();
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label404;
        }
        String str = (String)((Iterator)localObject).next();
        Iterator localIterator = paramString1.iterator();
        if (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          if (!localHashMap.containsKey(str)) {
            break;
          }
          paramString2.add(localHashMap.get(str));
        }
      }
      label404:
      localObject = new HashMap(1);
      v.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", new Object[] { Integer.valueOf(paramString2.size()) });
      ((HashMap)localObject).put("atuserlist", "<![CDATA[" + bf.c(paramString2, ",") + "]]>");
      paramString1.clear();
      v.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      GMTrace.o(14460349579264L, 107738);
      return (HashMap<String, String>)localObject;
    }
    v.w("MicroMsg.ChatFooter", "list is null or size 0");
    GMTrace.o(14460349579264L, 107738);
    return null;
  }
  
  public final void jA(boolean paramBoolean)
  {
    GMTrace.i(1003680169984L, 7478);
    AppPanel localAppPanel = this.sNk;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAppPanel.sMr.sNf.value = paramBoolean;
      localAppPanel.bEY();
      v.d("MicroMsg.AppPanel", "enable " + localAppPanel.sMr.sNf.value + " isMultiTalkEnable " + paramBoolean);
      GMTrace.o(1003680169984L, 7478);
      return;
    }
  }
  
  public final void jB(boolean paramBoolean)
  {
    GMTrace.i(1003814387712L, 7479);
    AppPanel localAppPanel = this.sNk;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localAppPanel.sMr.sMY.value = paramBoolean;
      localAppPanel.bEY();
      GMTrace.o(1003814387712L, 7479);
      return;
    }
  }
  
  @TargetApi(11)
  public final void jC(final boolean paramBoolean)
  {
    GMTrace.i(1005961871360L, 7495);
    if (com.tencent.mm.compatible.util.f.eo(11))
    {
      com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a()
      {
        public final void run()
        {
          GMTrace.i(16380065742848L, 122041);
          Message localMessage = new Message();
          localMessage.what = 1002;
          localMessage.obj = Boolean.valueOf(paramBoolean);
          ChatFooter.J(ChatFooter.this).sendMessage(localMessage);
          GMTrace.o(16380065742848L, 122041);
        }
      });
      GMTrace.o(1005961871360L, 7495);
      return;
    }
    if (paramBoolean)
    {
      this.nto.setTextColor(getResources().getColor(R.e.aUZ));
      GMTrace.o(1005961871360L, 7495);
      return;
    }
    this.nto.setTextColor(getResources().getColor(R.e.aUk));
    jy(false);
    GMTrace.o(1005961871360L, 7495);
  }
  
  public final void jy(boolean paramBoolean)
  {
    GMTrace.i(999250984960L, 7445);
    if (this.nto == null)
    {
      GMTrace.o(999250984960L, 7445);
      return;
    }
    if (paramBoolean)
    {
      this.nto.requestFocus();
      GMTrace.o(999250984960L, 7445);
      return;
    }
    this.nto.clearFocus();
    GMTrace.o(999250984960L, 7445);
  }
  
  public final void jz(boolean paramBoolean)
  {
    GMTrace.i(1002472210432L, 7469);
    if (this.ntq != null) {
      this.ntq.k(paramBoolean, false);
    }
    GMTrace.o(1002472210432L, 7469);
  }
  
  public void onGlobalLayout()
  {
    GMTrace.i(1008109355008L, 7511);
    if ((this.activity == null) || (this.activity.getWindow() == null) || (this.activity.getWindow().getDecorView() == null))
    {
      GMTrace.o(1008109355008L, 7511);
      return;
    }
    if (this.sOn == -1)
    {
      v.w("MicroMsg.ChatFooter", "chattingui layout id == -1!");
      GMTrace.o(1008109355008L, 7511);
      return;
    }
    if (this.sOo == null) {
      this.sOo = this.activity.getWindow().getDecorView().findViewById(this.sOn);
    }
    if (this.sOo == null)
    {
      v.e("MicroMsg.ChatFooter", "can't get chattinguilayout by chattinguilayoutid: %d", new Object[] { Integer.valueOf(this.sOn) });
      GMTrace.o(1008109355008L, 7511);
      return;
    }
    int j = this.sOo.getHeight();
    int i = this.sOo.getWidth();
    v.d("MicroMsg.ChatFooter", "ashutest::keybord:ChatFooter measure height: %d, height: %d", new Object[] { Integer.valueOf(this.sOo.getMeasuredHeight()), Integer.valueOf(j) });
    if (this.sOf < j) {
      this.sOf = j;
    }
    this.sOe = j;
    if (this.sOl <= 0)
    {
      this.sOl = j;
      GMTrace.o(1008109355008L, 7511);
      return;
    }
    if (this.sOm <= 0)
    {
      this.sOm = i;
      GMTrace.o(1008109355008L, 7511);
      return;
    }
    if ((this.sOl == j) && (this.sOm == i))
    {
      GMTrace.o(1008109355008L, 7511);
      return;
    }
    if ((bFK()) && (this.sNL))
    {
      this.sNL = false;
      v.d("MicroMsg.ChatFooter", "keybord:Chatfooter Show keybord & hide diy panel by onGlobalLayout");
      postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(16381005266944L, 122048);
          ChatFooter.this.bFJ();
          GMTrace.o(16381005266944L, 122048);
        }
      }, 10L);
    }
    v.d("MicroMsg.ChatFooter", "keybord:Chatfooter keybord old: %d, new: %d", new Object[] { Integer.valueOf(this.sOl), Integer.valueOf(j) });
    int k = Math.abs(this.sOl - j);
    this.sOl = j;
    j = Math.abs(this.sOm - i);
    this.sOm = i;
    v.d("MicroMsg.ChatFooter", "alvinluo widthDiff: %d", new Object[] { Integer.valueOf(j) });
    if (this.sOp)
    {
      if (k == 0) {
        break label641;
      }
      if (!com.tencent.mm.compatible.util.j.aF(this.context))
      {
        GMTrace.o(1008109355008L, 7511);
        return;
      }
      v.d("MicroMsg.ChatFooter", "alvinluo keyboard current height: %d", new Object[] { Integer.valueOf(this.sOc) });
      if ((this.sOc != k) || (k == -1))
      {
        j = com.tencent.mm.compatible.util.j.aD(this.context);
        v.d("MicroMsg.ChatFooter", "alvinluo valid panel height: %d", new Object[] { Integer.valueOf(j) });
        i = j;
        if (k >= com.tencent.mm.compatible.util.j.aC(this.context)) {
          if (k <= com.tencent.mm.compatible.util.j.aB(this.context)) {
            break label698;
          }
        }
      }
    }
    label641:
    label698:
    for (i = j;; i = k)
    {
      if (this.sNS)
      {
        this.sNS = false;
        j = i;
        if (i < this.sOc) {
          j = this.sOc;
        }
        this.sOc = j;
        xB(j);
      }
      for (;;)
      {
        v.d("MicroMsg.ChatFooter", "keybord:Chatfooter Keyboard Size: " + k);
        GMTrace.o(1008109355008L, 7511);
        return;
        this.sOc = i;
        v.i("MicroMsg.ChatFooter", "jacks calc keyBord dialog height:%d", new Object[] { Integer.valueOf(this.sOc) });
        com.tencent.mm.compatible.util.j.o(getContext(), i);
        xB(i);
        continue;
        if (this.sNk != null)
        {
          this.sNk.sMH = true;
          this.sNk.anG();
        }
        if (this.ntq != null)
        {
          this.ntq.lr(com.tencent.mm.compatible.util.j.aD(this.context));
          bFF();
          this.ntq.anM();
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1006498742272L, 7499);
    v.d("MicroMsg.ChatFooter", "keybord:ChatFooter onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (getTop() != 0)
    {
      if (getTop() > this.sOd) {
        this.sOd = getTop();
      }
      if (this.sOd - getTop() <= 50) {
        break label141;
      }
      if (this.sNv != null) {
        this.sNv.fy(true);
      }
    }
    while (!paramBoolean)
    {
      GMTrace.o(1006498742272L, 7499);
      return;
      label141:
      if (this.sNv != null) {
        this.sNv.fy(false);
      }
    }
    if (this.sNu != null)
    {
      l locall = this.sNu;
      if (locall.sOU.isShowing())
      {
        locall.sOU.dismiss();
        locall.bFV();
      }
    }
    GMTrace.o(1006498742272L, 7499);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(1006632960000L, 7500);
    v.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", new Object[] { Integer.valueOf(View.MeasureSpec.getSize(paramInt2)), Integer.valueOf(getMeasuredHeight()) });
    super.onMeasure(paramInt1, paramInt2);
    v.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    GMTrace.o(1006632960000L, 7500);
  }
  
  public final void onPause()
  {
    GMTrace.i(998579896320L, 7440);
    this.sNL = true;
    if (this.ntq != null) {
      this.ntq.onPause();
    }
    if ((this.sJc) && (this.sIY != null)) {
      this.sIY.pause();
    }
    this.sNv.onPause();
    this.sOp = false;
    GMTrace.o(998579896320L, 7440);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1006901395456L, 7502);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    v.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    GMTrace.o(1006901395456L, 7502);
  }
  
  public final void p(String paramString, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(1000995815424L, 7458);
    if ((paramBoolean) && ((paramString == null) || (paramString.length() == 0) || (this.nto == null)))
    {
      this.nto.setText("");
      GMTrace.o(1000995815424L, 7458);
      return;
    }
    this.sNy = true;
    this.nto.setText(com.tencent.mm.pluginsdk.ui.d.h.b(getContext(), paramString, this.nto.getTextSize()));
    this.sNy = false;
    if ((paramInt < 0) || (paramInt > this.nto.getText().length()))
    {
      this.nto.setSelection(this.nto.getText().length());
      GMTrace.o(1000995815424L, 7458);
      return;
    }
    this.nto.setSelection(paramInt);
    GMTrace.o(1000995815424L, 7458);
  }
  
  public final void r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    GMTrace.i(1006230306816L, 7497);
    boolean bool1;
    if (paramBoolean)
    {
      if ((com.tencent.mm.u.m.yt().booleanValue()) && (this.sNG != null))
      {
        this.sNG.a(Boolean.valueOf(true), Boolean.valueOf(false));
        this.sNG.b(Boolean.valueOf(true), Boolean.valueOf(false));
      }
      this.sNq.setContentDescription(getContext().getString(R.l.dSo));
      switch (paramInt1)
      {
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      if (((bool1) && (paramInt2 != 21) && (this.sNr != null)) || ((this.sNr != null) && (!bool1) && ((paramInt2 == 21) || (paramInt2 == 20)))) {
        jD(false);
      }
      if ((paramInt1 != 0) || (bool1)) {
        break;
      }
      jD(false);
      GMTrace.o(1006230306816L, 7497);
      return;
      this.sNp.fXt = true;
      jy(true);
      jC(true);
      this.sNB.showSoftInput(this.nto, 0);
      bool1 = paramBoolean;
      continue;
      Object localObject;
      if (paramInt2 == 22)
      {
        if (this.sNk == null) {
          bFj();
        }
        this.sNk.bFc();
        if (this.ntq != null) {
          this.ntq.setVisibility(8);
        }
        this.sNk.setVisibility(0);
        localObject = this.sNt;
        i.2 local2 = new i.2((i)localObject, ((i)localObject).context.getMainLooper());
        ap.vL().D(new i.3((i)localObject, local2));
        jy(false);
        if (this.sNC == 2) {
          xz(1);
        }
      }
      for (;;)
      {
        this.sNp.setVisibility(0);
        if ((!bFK()) || (!com.tencent.mm.compatible.util.j.aF(getContext())))
        {
          localObject = this.sNp.getLayoutParams();
          if ((localObject != null) && (((ViewGroup.LayoutParams)localObject).height == 0))
          {
            ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.compatible.util.j.aD(getContext());
            this.sNp.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        bf.cV(this);
        bool1 = paramBoolean;
        break;
        if (paramInt2 == 21)
        {
          if (this.sNk != null) {
            this.sNk.setVisibility(8);
          }
          if (this.ntq == null) {
            bFi();
          }
          if (this.ntq != null) {
            this.ntq.setVisibility(0);
          }
          jD(true);
          jy(true);
        }
      }
      this.sNp.fXt = true;
      jy(true);
      jC(true);
      bool1 = paramBoolean;
      continue;
      this.sNq.setContentDescription(getContext().getString(R.l.dSp));
      switch (paramInt1)
      {
      default: 
        bool1 = paramBoolean;
        break;
      case 0: 
        bf.cV(this);
        jy(false);
        bool1 = paramBoolean;
        if (!this.sJc)
        {
          bFM();
          bool1 = paramBoolean;
        }
        break;
      case 1: 
        bf.cV(this);
        bool1 = paramBoolean;
        break;
      case 2: 
        if (paramInt2 == 20)
        {
          if (this.sJc)
          {
            bf.cV(this);
            bool1 = paramBoolean;
          }
          else
          {
            bFM();
            bool1 = paramBoolean;
          }
        }
        else if (paramInt2 == 22)
        {
          this.sNk.setVisibility(8);
          bool1 = paramBoolean;
        }
        else if (paramInt2 == 21)
        {
          bool1 = paramBoolean;
          if (this.ntq != null)
          {
            this.ntq.setVisibility(8);
            bool1 = paramBoolean;
          }
        }
        else
        {
          bool1 = paramBoolean;
          if (paramInt2 == 23)
          {
            bEp();
            bFM();
            bool1 = paramBoolean;
          }
        }
        break;
      }
    }
    if ((bool1) && (paramInt2 != 22)) {
      if (this.nto.length() <= 0) {
        break label735;
      }
    }
    label735:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      fw(paramBoolean);
      GMTrace.o(1006230306816L, 7497);
      return;
    }
  }
  
  public final void xA(int paramInt)
  {
    GMTrace.i(17439848923136L, 129937);
    if (paramInt == this.sNT)
    {
      GMTrace.o(17439848923136L, 129937);
      return;
    }
    this.sNT = paramInt;
    ImageView localImageView1 = (ImageView)findViewById(R.h.cGJ);
    ImageView localImageView2 = (ImageView)findViewById(R.h.cpo);
    if (this.sNT == 1)
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
      GMTrace.o(17439848923136L, 129937);
      return;
    }
    localImageView1.setVisibility(0);
    localImageView2.setVisibility(8);
    GMTrace.o(17439848923136L, 129937);
  }
  
  public final void xB(int paramInt)
  {
    GMTrace.i(1007304048640L, 7505);
    com.tencent.mm.compatible.util.j.sg();
    paramInt = com.tencent.mm.compatible.util.j.p(this.context, paramInt);
    this.sOc = paramInt;
    Object localObject;
    if ((paramInt > 0) && (this.sNp != null))
    {
      v.d("MicroMsg.ChatFooter", "set bottom panel height: %d", new Object[] { Integer.valueOf(paramInt) });
      localObject = new LinearLayout.LayoutParams(-1, 0);
      ((ViewGroup.LayoutParams)localObject).height = paramInt;
      this.sNp.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.sNk != null)
    {
      this.sNk.xu(paramInt);
      localObject = this.sNk;
      ((AppPanel)localObject).bFc();
      ((AppPanel)localObject).anG();
    }
    if (this.sIY != null)
    {
      this.sIY.xE(paramInt);
      this.sIY.bFc();
    }
    if (this.ntq != null)
    {
      if (!bFK()) {
        bFF();
      }
      this.ntq.lr(paramInt);
      this.ntq.anM();
    }
    GMTrace.o(1007304048640L, 7505);
  }
  
  public final void xC(int paramInt)
  {
    GMTrace.i(1007975137280L, 7510);
    this.sOo = null;
    this.sOn = paramInt;
    GMTrace.o(1007975137280L, 7510);
  }
  
  public final void xw(int paramInt)
  {
    GMTrace.i(1000727379968L, 7456);
    this.sNx.sOx = paramInt;
    GMTrace.o(1000727379968L, 7456);
  }
  
  public final void xx(int paramInt)
  {
    GMTrace.i(1001532686336L, 7462);
    this.sNR = 0;
    int i = com.tencent.mm.bg.a.fromDPToPix(getContext(), 180);
    int j = BackwardSupportUtil.b.a(getContext(), 50.0F);
    if (paramInt + j < i) {}
    for (this.sNR = -1;; this.sNR = ((paramInt - i) / 2 + j))
    {
      if (this.qXA == null)
      {
        this.qXA = new com.tencent.mm.ui.base.o(View.inflate(getContext(), R.i.dpx, null), -1, -2);
        this.jWU = ((ImageView)this.qXA.getContentView().findViewById(R.h.cNd));
        this.lLV = this.qXA.getContentView().findViewById(R.h.cNe);
        this.lLW = this.qXA.getContentView().findViewById(R.h.cNg);
        this.qXB = ((TextView)this.qXA.getContentView().findViewById(R.h.cNi));
        this.qXC = ((ImageView)this.qXA.getContentView().findViewById(R.h.cNh));
        this.qXD = this.qXA.getContentView().findViewById(R.h.cNj);
        this.lLT = this.qXA.getContentView().findViewById(R.h.cNk);
        this.lLU = this.qXA.getContentView().findViewById(R.h.cNl);
        this.sNA = ((TextView)this.qXA.getContentView().findViewById(R.h.cNn));
      }
      if (this.sNR != -1)
      {
        this.lLU.setVisibility(8);
        this.lLT.setVisibility(8);
        this.qXD.setVisibility(0);
        this.qXA.showAtLocation(this, 49, 0, this.sNR);
      }
      GMTrace.o(1001532686336L, 7462);
      return;
    }
  }
  
  public final void xy(int paramInt)
  {
    GMTrace.i(1002069557248L, 7466);
    int i = 0;
    for (;;)
    {
      if (i < jWM.length)
      {
        if ((paramInt >= jWL[i]) && (paramInt < jWL[(i + 1)])) {
          this.jWU.setBackgroundDrawable(com.tencent.mm.bg.a.a(getContext(), jWM[i]));
        }
      }
      else
      {
        if ((paramInt == -1) && (this.qXA != null))
        {
          this.qXA.dismiss();
          this.qXD.setVisibility(0);
          this.lLT.setVisibility(8);
          this.lLU.setVisibility(8);
        }
        GMTrace.o(1002069557248L, 7466);
        return;
      }
      i += 1;
    }
  }
  
  private static final class a
  {
    public String sOv;
    public String sOw;
    public int sOx;
    public HashMap<String, LinkedList<HashMap<String, String>>> sOy;
    
    public a()
    {
      GMTrace.i(1018980990976L, 7592);
      this.sOy = new HashMap();
      GMTrace.o(1018980990976L, 7592);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(Boolean paramBoolean1, Boolean paramBoolean2);
    
    public abstract void b(Boolean paramBoolean1, Boolean paramBoolean2);
  }
  
  public static abstract interface c
  {
    public abstract void d(Boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract boolean jE(boolean paramBoolean);
  }
  
  public final class e
    implements TextWatcher
  {
    private boolean sOA;
    private boolean sOB;
    TextWatcher sOz;
    
    public e(TextWatcher paramTextWatcher)
    {
      GMTrace.i(986500300800L, 7350);
      this.sOA = false;
      this.sOB = com.tencent.mm.compatible.util.f.ep(11);
      this.sOz = paramTextWatcher;
      GMTrace.o(986500300800L, 7350);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      boolean bool = true;
      GMTrace.i(986634518528L, 7351);
      if ((ChatFooter.g(ChatFooter.this)) && (this.sOA) && (paramEditable.length() > 0))
      {
        this.sOA = false;
        ChatFooter.a(ChatFooter.this).setText(paramEditable.subSequence(0, paramEditable.length() - 1));
        if (ChatFooter.a(ChatFooter.this).length() > 0) {
          ChatFooter.h(ChatFooter.this).performClick();
        }
        v.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        GMTrace.o(986634518528L, 7351);
        return;
      }
      this.sOz.afterTextChanged(paramEditable);
      if (ChatFooter.p(ChatFooter.this) != null)
      {
        if (ChatFooter.a(ChatFooter.this).getLineCount() > 1)
        {
          ChatFooter.p(ChatFooter.this).setVisibility(0);
          ChatFooter.p(ChatFooter.this).setText(paramEditable.length() + "/140");
        }
      }
      else {
        if ((paramEditable.length() <= 0) || (paramEditable.toString().trim().length() <= 0)) {
          break label302;
        }
      }
      for (;;)
      {
        ChatFooter.b(ChatFooter.this, bool);
        if (ChatFooter.n(ChatFooter.this) != null) {
          ChatFooter.n(ChatFooter.this).dx(bool);
        }
        v.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        GMTrace.o(986634518528L, 7351);
        return;
        ChatFooter.p(ChatFooter.this).setVisibility(8);
        break;
        label302:
        bool = false;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(986768736256L, 7352);
      this.sOz.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      v.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
      GMTrace.o(986768736256L, 7352);
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(986902953984L, 7353);
      if ((ChatFooter.g(ChatFooter.this)) && (paramInt2 == 0) && (paramInt1 == paramCharSequence.length() - 1) && (paramInt3 == 1) && (paramCharSequence.charAt(paramCharSequence.length() - 1) == '\n'))
      {
        this.sOA = true;
        GMTrace.o(986902953984L, 7353);
        return;
      }
      this.sOz.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      GMTrace.o(986902953984L, 7353);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/chat/ChatFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */