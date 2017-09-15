package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.fts.d.d.b;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.pluginsdk.ui.tools.p.a;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.protocal.c.gv;
import com.tencent.mm.protocal.c.gw;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class BizChatSearchUI
  extends MMActivity
  implements p.a, BizChatSearchListView.a
{
  p jYP;
  String jZw;
  private AbsListView.OnScrollListener mvS;
  private int scene;
  private String vud;
  private c vue;
  BizChatSearchListView vuf;
  TextView vug;
  private a vuh;
  
  public BizChatSearchUI()
  {
    GMTrace.i(3002182139904L, 22368);
    this.mvS = new AbsListView.OnScrollListener()
    {
      boolean jYD;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2998826696704L, 22343);
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          this.jYD = true;
          GMTrace.o(2998826696704L, 22343);
          return;
        }
        this.jYD = false;
        GMTrace.o(2998826696704L, 22343);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        GMTrace.i(2998692478976L, 22342);
        if ((paramAnonymousInt == 0) && (this.jYD) && (BizChatSearchUI.a(BizChatSearchUI.this).vuw))
        {
          paramAnonymousAbsListView = BizChatSearchUI.a(BizChatSearchUI.this);
          if ((paramAnonymousAbsListView.bTi()) && (!paramAnonymousAbsListView.vuy))
          {
            paramAnonymousAbsListView.vuy = true;
            com.tencent.mm.modelbiz.a.l locall = new com.tencent.mm.modelbiz.a.l(paramAnonymousAbsListView.jZw, paramAnonymousAbsListView.kuS, paramAnonymousAbsListView.vuC);
            ap.vd().a(locall, 0);
            paramAnonymousAbsListView.bTk();
          }
        }
        GMTrace.o(2998692478976L, 22342);
      }
    };
    GMTrace.o(3002182139904L, 22368);
  }
  
  public final void AA(int paramInt)
  {
    GMTrace.i(3004463841280L, 22385);
    c localc;
    if (this.vue != null) {
      localc = this.vue;
    }
    switch (paramInt)
    {
    default: 
      localc.h(false, false);
      GMTrace.o(3004463841280L, 22385);
      return;
    case 1: 
      localc.h(true, false);
      GMTrace.o(3004463841280L, 22385);
      return;
    }
    localc.h(false, true);
    GMTrace.o(3004463841280L, 22385);
  }
  
  protected final void KD()
  {
    GMTrace.i(3002584793088L, 22371);
    if (bf.mA(this.jZw))
    {
      this.jZw = getIntent().getStringExtra("enterprise_biz_name");
      this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
      this.vud = getIntent().getStringExtra("biz_chat_search_text");
      if (bf.mA(this.jZw)) {
        finish();
      }
    }
    this.vuf = ((BizChatSearchListView)findViewById(R.h.btF));
    this.vug = ((TextView)findViewById(R.h.cog));
    this.vuh = new a(this.uRf.uRz, this.jZw, this.scene);
    if (a.a(this.vuh))
    {
      this.vue = new c();
      BizChatSearchListView localBizChatSearchListView = this.vuf;
      c localc = this.vue;
      View localView = View.inflate(this.uRf.uRz, R.i.dgD, null);
      localc.jYF = localView.findViewById(R.h.cbJ);
      localc.jYG = localView.findViewById(R.h.cbE);
      localc.jYH = localView.findViewById(R.h.cbK);
      localc.jYF.setVisibility(8);
      localc.jYG.setVisibility(8);
      localc.jYH.setVisibility(8);
      localBizChatSearchListView.addFooterView(localView);
      AA(0);
    }
    this.vuf.setAdapter(this.vuh);
    this.vuf.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(2971312062464L, 22138);
        paramAnonymousView = BizChatSearchUI.a(BizChatSearchUI.this).AB(paramAnonymousInt);
        paramAnonymousAdapterView = BizChatSearchUI.this;
        if ((paramAnonymousView.klJ == BizChatSearchUI.g.vuG) || (paramAnonymousView.klJ == BizChatSearchUI.g.vuH)) {
          if ((paramAnonymousView.data instanceof com.tencent.mm.modelbiz.a.c))
          {
            paramAnonymousView = (com.tencent.mm.modelbiz.a.c)paramAnonymousView.data;
            if (paramAnonymousView == null) {
              break label637;
            }
            paramAnonymousLong = paramAnonymousView.field_bizChatLocalId;
          }
        }
        for (;;)
        {
          if ((bf.mA(paramAnonymousAdapterView.jZw)) || (paramAnonymousLong < 0L))
          {
            GMTrace.o(2971312062464L, 22138);
            return;
            if ((paramAnonymousView.data instanceof gu))
            {
              Object localObject = ((gu)paramAnonymousView.data).tji;
              String str = paramAnonymousAdapterView.jZw;
              boolean bool = true;
              paramAnonymousView = new j();
              paramAnonymousView.field_userId = ((gx)localObject).tjg;
              paramAnonymousView.field_userName = ((gx)localObject).kfF;
              paramAnonymousView.field_brandUserName = str;
              paramAnonymousView.field_headImageUrl = ((gx)localObject).tja;
              paramAnonymousView.field_profileUrl = ((gx)localObject).tjo;
              paramAnonymousView.field_UserVersion = ((gx)localObject).ver;
              paramAnonymousView.field_addMemberUrl = ((gx)localObject).tje;
              if (!w.DL().b(paramAnonymousView)) {
                bool = w.DL().a(paramAnonymousView);
              }
              if (!bool)
              {
                paramAnonymousLong = -1L;
                continue;
              }
              localObject = new com.tencent.mm.modelbiz.a.c();
              ((com.tencent.mm.modelbiz.a.c)localObject).field_bizChatServId = paramAnonymousView.field_userId;
              ((com.tencent.mm.modelbiz.a.c)localObject).field_brandUserName = paramAnonymousView.field_brandUserName;
              ((com.tencent.mm.modelbiz.a.c)localObject).field_chatName = paramAnonymousView.field_userName;
              ((com.tencent.mm.modelbiz.a.c)localObject).field_chatType = 1;
              paramAnonymousView = com.tencent.mm.modelbiz.a.e.e((com.tencent.mm.modelbiz.a.c)localObject);
              if (paramAnonymousView == null)
              {
                paramAnonymousLong = -1L;
                continue;
              }
              localObject = w.DK().U(paramAnonymousView.field_bizChatLocalId);
              ((com.tencent.mm.modelbiz.a.a)localObject).field_bizChatId = paramAnonymousView.field_bizChatLocalId;
              ((com.tencent.mm.modelbiz.a.a)localObject).field_unReadCount = 0;
              if (bf.mA(((com.tencent.mm.modelbiz.a.a)localObject).field_brandUserName))
              {
                ((com.tencent.mm.modelbiz.a.a)localObject).field_brandUserName = paramAnonymousView.field_brandUserName;
                ((com.tencent.mm.modelbiz.a.a)localObject).field_lastMsgTime = System.currentTimeMillis();
                ((com.tencent.mm.modelbiz.a.a)localObject).field_flag = ((com.tencent.mm.modelbiz.a.a)localObject).field_lastMsgTime;
              }
              if (!w.DK().b((com.tencent.mm.modelbiz.a.a)localObject)) {
                w.DK().a((com.tencent.mm.modelbiz.a.a)localObject);
              }
              paramAnonymousLong = paramAnonymousView.field_bizChatLocalId;
            }
          }
          else
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView.jZw);
            paramAnonymousView.putExtra("key_biz_chat_id", paramAnonymousLong);
            paramAnonymousView.putExtra("finish_direct", true);
            paramAnonymousView.putExtra("key_need_send_video", false);
            paramAnonymousView.putExtra("key_is_biz_chat", true);
            com.tencent.mm.bb.d.a(paramAnonymousAdapterView.uRf.uRz, ".ui.chatting.En_5b8fbb1e", paramAnonymousView);
            GMTrace.o(2971312062464L, 22138);
            return;
            if (paramAnonymousView.klJ == BizChatSearchUI.g.vuI)
            {
              if (((Integer)paramAnonymousView.data).intValue() == BizChatSearchUI.g.vuM)
              {
                paramAnonymousView = new Intent(paramAnonymousAdapterView.uRf.uRz, BizChatSearchUI.class);
                paramAnonymousView.putExtra("enterprise_biz_name", paramAnonymousAdapterView.jZw);
                paramAnonymousView.putExtra("biz_chat_search_scene", 2);
                paramAnonymousView.putExtra("biz_chat_search_text", paramAnonymousAdapterView.jYP.bzR());
                paramAnonymousAdapterView.startActivity(paramAnonymousView);
                GMTrace.o(2971312062464L, 22138);
                return;
              }
              if (((Integer)paramAnonymousView.data).intValue() == BizChatSearchUI.g.vuN)
              {
                paramAnonymousView = new Intent(paramAnonymousAdapterView.uRf.uRz, BizChatSearchUI.class);
                paramAnonymousView.putExtra("enterprise_biz_name", paramAnonymousAdapterView.jZw);
                paramAnonymousView.putExtra("biz_chat_search_scene", 3);
                paramAnonymousView.putExtra("biz_chat_search_text", paramAnonymousAdapterView.jYP.bzR());
                paramAnonymousAdapterView.startActivity(paramAnonymousView);
              }
            }
            GMTrace.o(2971312062464L, 22138);
            return;
          }
          label637:
          paramAnonymousLong = -1L;
        }
      }
    });
    this.vuf.vuc = this;
    if (a.a(this.vuh)) {
      this.vuf.setOnScrollListener(this.mvS);
    }
    this.jYP = new p();
    this.jYP.lH(a.b(this.vuh));
    this.jYP.a(this);
    this.jYP.sVU = false;
    GMTrace.o(3002584793088L, 22371);
  }
  
  public final void OE()
  {
    GMTrace.i(3002853228544L, 22373);
    finish();
    GMTrace.o(3002853228544L, 22373);
  }
  
  public final void OF()
  {
    GMTrace.i(3002719010816L, 22372);
    GMTrace.o(3002719010816L, 22372);
  }
  
  public final void OG()
  {
    GMTrace.i(3002450575360L, 22370);
    GMTrace.o(3002450575360L, 22370);
  }
  
  public final void OH()
  {
    GMTrace.i(16851975274496L, 125557);
    GMTrace.o(16851975274496L, 125557);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt)
  {
    GMTrace.i(3004061188096L, 22382);
    GMTrace.o(3004061188096L, 22382);
  }
  
  public final void aed()
  {
    GMTrace.i(3003255881728L, 22376);
    aGY();
    GMTrace.o(3003255881728L, 22376);
  }
  
  public final void aee()
  {
    GMTrace.i(3003390099456L, 22377);
    GMTrace.o(3003390099456L, 22377);
  }
  
  public final boolean aef()
  {
    GMTrace.i(3004329623552L, 22384);
    aGY();
    GMTrace.o(3004329623552L, 22384);
    return false;
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3004195405824L, 22383);
    int i = R.i.dba;
    GMTrace.o(3004195405824L, 22383);
    return i;
  }
  
  public final boolean mQ(String paramString)
  {
    GMTrace.i(3003121664000L, 22375);
    aGY();
    GMTrace.o(3003121664000L, 22375);
    return true;
  }
  
  public final void mR(String paramString)
  {
    a locala = null;
    GMTrace.i(3002987446272L, 22374);
    if ((bf.mA(paramString)) && (this.vud != null))
    {
      paramString = this.vud;
      this.vud = null;
      if (!paramString.equals("")) {
        this.jYP.Uf(paramString);
      }
      p localp = this.jYP;
      if (a.b(this.vuh)) {
        paramString = this.uRf.uRz.getResources().getString(R.l.dOU);
      }
      for (;;)
      {
        localp.setHint(paramString);
        this.jYP.clearFocus();
        GMTrace.o(3002987446272L, 22374);
        return;
        if (a.a(this.vuh))
        {
          paramString = this.uRf.uRz.getResources().getString(R.l.dOY);
        }
        else
        {
          paramString = locala;
          if (a.d(this.vuh)) {
            paramString = this.uRf.uRz.getResources().getString(R.l.dOR);
          }
        }
      }
    }
    locala = this.vuh;
    locala.kuS = paramString;
    if (bf.mA(paramString))
    {
      locala.QZ();
      locala.vux = false;
      locala.vuB = false;
      locala.la(true);
      GMTrace.o(3002987446272L, 22374);
      return;
    }
    if (locala.bTi())
    {
      locala.vux = true;
      locala.vuB = false;
      locala.bTk();
      locala.aW(paramString, false);
      locala.Tj(paramString);
      GMTrace.o(3002987446272L, 22374);
      return;
    }
    locala.aW(paramString, true);
    if ((locala.vul) && (locala.vux)) {
      locala.Tj(paramString);
    }
    GMTrace.o(3002987446272L, 22374);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3002316357632L, 22369);
    super.onCreate(paramBundle);
    KD();
    GMTrace.o(3002316357632L, 22369);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    GMTrace.i(3003792752640L, 22380);
    this.jYP.a(this, paramMenu);
    GMTrace.o(3003792752640L, 22380);
    return true;
  }
  
  protected void onDestroy()
  {
    GMTrace.i(3003658534912L, 22379);
    super.onDestroy();
    GMTrace.o(3003658534912L, 22379);
  }
  
  protected void onPause()
  {
    GMTrace.i(3003524317184L, 22378);
    super.onPause();
    this.jYP.cancel();
    this.jYP.clearFocus();
    GMTrace.o(3003524317184L, 22378);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    GMTrace.i(3003926970368L, 22381);
    this.jYP.a(this, paramMenu);
    GMTrace.o(3003926970368L, 22381);
    return true;
  }
  
  private static final class a
    extends BaseAdapter
    implements com.tencent.mm.y.e
  {
    public static int vuj;
    private int Ul;
    private Context context;
    private com.tencent.mm.ah.a.a.c hIg;
    String jZw;
    String kuS;
    private int scene;
    private int vuA;
    public boolean vuB;
    int vuC;
    private int vuk;
    boolean vul;
    boolean vum;
    private ArrayList<com.tencent.mm.modelbiz.a.c> vun;
    private ArrayList<Object> vuo;
    private ArrayList<com.tencent.mm.modelbiz.a.c> vup;
    private BizChatSearchUI.g vuq;
    private ArrayList<BizChatSearchUI.g> vur;
    private BizChatSearchUI.g vus;
    private BizChatSearchUI.g vut;
    private ArrayList<BizChatSearchUI.g> vuu;
    private BizChatSearchUI.g vuv;
    public boolean vuw;
    public boolean vux;
    public boolean vuy;
    private boolean vuz;
    
    static
    {
      GMTrace.i(2966748659712L, 22104);
      vuj = 3;
      GMTrace.o(2966748659712L, 22104);
    }
    
    public a(Context paramContext, String paramString, int paramInt)
    {
      GMTrace.i(2963393216512L, 22079);
      this.vun = new ArrayList();
      this.vuo = new ArrayList();
      this.vup = new ArrayList();
      this.vur = new ArrayList();
      this.vuu = new ArrayList();
      this.vuw = true;
      this.vux = false;
      this.vuy = false;
      this.vuz = true;
      this.vuA = 0;
      this.Ul = 0;
      this.vuB = false;
      this.vuC = 0;
      this.context = paramContext;
      this.jZw = paramString;
      this.scene = paramInt;
      boolean bool1;
      if ((this.scene == 1) || (this.scene == 2))
      {
        bool1 = true;
        this.vul = bool1;
        if (this.scene != 1)
        {
          bool1 = bool2;
          if (this.scene != 3) {}
        }
        else
        {
          bool1 = true;
        }
        this.vum = bool1;
        if (this.scene != 1) {
          break label274;
        }
      }
      label274:
      for (paramInt = vuj;; paramInt = Integer.MAX_VALUE)
      {
        this.vuk = paramInt;
        paramContext = new c.a();
        paramContext.hIw = com.tencent.mm.modelbiz.a.e.iA(this.jZw);
        paramContext.hIt = true;
        paramContext.hIP = true;
        paramContext.hII = R.k.ber;
        this.hIg = paramContext.Hh();
        if (this.vul) {
          ap.vd().a(1364, this);
        }
        GMTrace.o(2963393216512L, 22079);
        return;
        bool1 = false;
        break;
      }
    }
    
    private static SpannableString a(Context paramContext, Spannable paramSpannable, int paramInt)
    {
      int i = 0;
      GMTrace.i(2965003829248L, 22091);
      paramContext = h.c(paramContext, paramSpannable, paramInt);
      ForegroundColorSpan[] arrayOfForegroundColorSpan = (ForegroundColorSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ForegroundColorSpan.class);
      if (arrayOfForegroundColorSpan != null)
      {
        int j = arrayOfForegroundColorSpan.length;
        paramInt = i;
        while (paramInt < j)
        {
          ForegroundColorSpan localForegroundColorSpan = arrayOfForegroundColorSpan[paramInt];
          paramContext.setSpan(localForegroundColorSpan, paramSpannable.getSpanStart(localForegroundColorSpan), paramSpannable.getSpanEnd(localForegroundColorSpan), paramSpannable.getSpanFlags(localForegroundColorSpan));
          paramInt += 1;
        }
      }
      GMTrace.o(2965003829248L, 22091);
      return paramContext;
    }
    
    private void bTg()
    {
      GMTrace.i(2964466958336L, 22087);
      if (bTi())
      {
        this.vux = false;
        this.vuB = true;
        bTk();
      }
      GMTrace.o(2964466958336L, 22087);
    }
    
    private boolean bTh()
    {
      GMTrace.i(2964601176064L, 22088);
      if (this.scene == 1)
      {
        GMTrace.o(2964601176064L, 22088);
        return true;
      }
      GMTrace.o(2964601176064L, 22088);
      return false;
    }
    
    private boolean bTj()
    {
      GMTrace.i(2964869611520L, 22090);
      if (this.scene == 3)
      {
        GMTrace.o(2964869611520L, 22090);
        return true;
      }
      GMTrace.o(2964869611520L, 22090);
      return false;
    }
    
    private static void n(View paramView, boolean paramBoolean)
    {
      GMTrace.i(2965138046976L, 22092);
      if (paramBoolean)
      {
        paramView.setBackgroundResource(R.g.ben);
        GMTrace.o(2965138046976L, 22092);
        return;
      }
      paramView.setBackgroundResource(R.g.beo);
      GMTrace.o(2965138046976L, 22092);
    }
    
    public final BizChatSearchUI.g AB(int paramInt)
    {
      GMTrace.i(2963930087424L, 22083);
      if (paramInt < this.vuA)
      {
        if (paramInt == 0)
        {
          if (this.vuq == null) {
            this.vuq = new BizChatSearchUI.g(BizChatSearchUI.g.vuK, Integer.valueOf(BizChatSearchUI.g.vuM));
          }
          localg = this.vuq;
          GMTrace.o(2963930087424L, 22083);
          return localg;
        }
        if ((paramInt == this.vuA - 1) && (this.vux) && (bTh()))
        {
          if (this.vus == null) {
            this.vus = new BizChatSearchUI.g();
          }
          this.vus.klJ = BizChatSearchUI.g.vuJ;
          this.vus.data = Integer.valueOf(BizChatSearchUI.g.vuM);
          localg = this.vus;
          GMTrace.o(2963930087424L, 22083);
          return localg;
        }
        if ((paramInt == this.vuA - 1) && (this.vuw) && (bTh()))
        {
          if (this.vus == null) {
            this.vus = new BizChatSearchUI.g();
          }
          this.vus.klJ = BizChatSearchUI.g.vuI;
          this.vus.data = Integer.valueOf(BizChatSearchUI.g.vuM);
          localg = this.vus;
          GMTrace.o(2963930087424L, 22083);
          return localg;
        }
        paramInt -= 1;
        if ((paramInt >= 0) && (paramInt < this.vur.size()))
        {
          localg = (BizChatSearchUI.g)this.vur.get(paramInt);
          GMTrace.o(2963930087424L, 22083);
          return localg;
        }
      }
      else
      {
        if (paramInt == this.vuA)
        {
          if (this.vut == null) {
            this.vut = new BizChatSearchUI.g(BizChatSearchUI.g.vuK, Integer.valueOf(BizChatSearchUI.g.vuN));
          }
          localg = this.vut;
          GMTrace.o(2963930087424L, 22083);
          return localg;
        }
        if ((paramInt == this.Ul - 1) && (this.vuz) && (bTh()))
        {
          if (this.vuv == null) {
            this.vuv = new BizChatSearchUI.g(BizChatSearchUI.g.vuI, Integer.valueOf(BizChatSearchUI.g.vuN));
          }
          localg = this.vuv;
          GMTrace.o(2963930087424L, 22083);
          return localg;
        }
        paramInt = paramInt - this.vuA - 1;
        if ((paramInt >= 0) && (paramInt < this.vuu.size()))
        {
          localg = (BizChatSearchUI.g)this.vuu.get(paramInt);
          GMTrace.o(2963930087424L, 22083);
          return localg;
        }
      }
      BizChatSearchUI.g localg = new BizChatSearchUI.g();
      GMTrace.o(2963930087424L, 22083);
      return localg;
    }
    
    final void QZ()
    {
      GMTrace.i(2965540700160L, 22095);
      this.vuC = 0;
      this.vuo.clear();
      this.vun.clear();
      this.vup.clear();
      GMTrace.o(2965540700160L, 22095);
    }
    
    final void Tj(final String paramString)
    {
      GMTrace.i(2965406482432L, 22094);
      if (!this.vul)
      {
        GMTrace.o(2965406482432L, 22094);
        return;
      }
      ae.f(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2982720569344L, 22223);
          if (!paramString.equals(BizChatSearchUI.a.c(BizChatSearchUI.a.this)))
          {
            GMTrace.o(2982720569344L, 22223);
            return;
          }
          com.tencent.mm.modelbiz.a.l locall = new com.tencent.mm.modelbiz.a.l(BizChatSearchUI.a.e(BizChatSearchUI.a.this), paramString, 0);
          ap.vd().a(locall, 0);
          GMTrace.o(2982720569344L, 22223);
        }
      }, 200L);
      GMTrace.o(2965406482432L, 22094);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
    {
      GMTrace.i(2964332740608L, 22086);
      Object localObject1;
      Object localObject2;
      if ((this.vul) && (paramk.getType() == 1364) && ((paramk instanceof com.tencent.mm.modelbiz.a.l)))
      {
        this.vuy = false;
        localObject1 = (com.tencent.mm.modelbiz.a.l)paramk;
        if ((((com.tencent.mm.modelbiz.a.l)localObject1).gUq != null) && (((com.tencent.mm.modelbiz.a.l)localObject1).gUq.hrS.hsa != null)) {}
        for (paramString = (gv)((com.tencent.mm.modelbiz.a.l)localObject1).gUq.hrS.hsa;; paramString = null)
        {
          paramk = paramString.fDj;
          localObject2 = paramString.tjf;
          if ((paramk.equals(this.kuS)) && (((String)localObject2).equals(this.jZw)) && (this.vuC == paramString.offset)) {
            break;
          }
          GMTrace.o(2964332740608L, 22086);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          bTg();
          GMTrace.o(2964332740608L, 22086);
          return;
        }
        if ((((com.tencent.mm.modelbiz.a.l)localObject1).gUq != null) && (((com.tencent.mm.modelbiz.a.l)localObject1).gUq.hrT.hsa != null)) {}
        for (paramString = (gw)((com.tencent.mm.modelbiz.a.l)localObject1).gUq.hrT.hsa; (paramString == null) || (paramString.tjl == null) || (paramString.tjl.ret != 0); paramString = null)
        {
          bTg();
          GMTrace.o(2964332740608L, 22086);
          return;
        }
        localObject1 = paramString.tjm;
        boolean bool = paramString.tjn;
        if (paramk.equals(this.kuS))
        {
          this.vux = false;
          this.vuC += ((List)localObject1).size();
          if (bTh())
          {
            if (this.vuo.size() < this.vun.size())
            {
              aW(paramk, true);
              GMTrace.o(2964332740608L, 22086);
              return;
            }
            if (this.vuo.size() > this.vun.size()) {}
          }
          else
          {
            if (bTi()) {
              this.vuw = bool;
            }
            if (bTj()) {
              break label485;
            }
            paramString = ((List)localObject1).iterator();
          }
        }
      }
      label485:
      label498:
      for (;;)
      {
        if (paramString.hasNext())
        {
          paramk = (gu)paramString.next();
          localObject1 = paramk.tji;
          if (!bf.mA(((gx)localObject1).tjg))
          {
            localObject2 = this.vun.iterator();
            com.tencent.mm.modelbiz.a.c localc;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localc = (com.tencent.mm.modelbiz.a.c)((Iterator)localObject2).next();
            } while (!((gx)localObject1).tjg.equals(localc.field_bizChatServId));
          }
        }
        else
        {
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label498;
            }
            this.vuo.add(paramk);
            break;
            la(true);
            GMTrace.o(2964332740608L, 22086);
            return;
          }
        }
      }
    }
    
    final void aW(String paramString, boolean paramBoolean)
    {
      GMTrace.i(2965272264704L, 22093);
      Object localObject2 = w.DK();
      String str = this.jZw;
      Object localObject1 = new ArrayList();
      if (!bf.mA(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("select BizChatInfo.*");
        localStringBuilder.append(" from BizChatConversation , BizChatInfo");
        localStringBuilder.append(" where BizChatConversation.brandUserName").append(" = '").append(str).append("'");
        localStringBuilder.append(" and BizChatInfo.brandUserName").append(" = '").append(str).append("'");
        localStringBuilder.append(" and BizChatConversation.bizChatId");
        localStringBuilder.append(" = BizChatInfo.bizChatLocalId");
        localStringBuilder.append(" and BizChatInfo.chatName").append(" like '%").append(paramString).append("%'");
        localStringBuilder.append(" order by BizChatConversation.flag").append(" desc");
        localStringBuilder.append(" , BizChatConversation.lastMsgTime").append(" desc");
        v.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", new Object[] { localStringBuilder.toString() });
        paramString = ((com.tencent.mm.modelbiz.a.b)localObject2).rawQuery(localStringBuilder.toString(), new String[0]);
        if (paramString != null)
        {
          if (paramString.moveToFirst()) {
            do
            {
              localObject2 = new com.tencent.mm.modelbiz.a.c();
              ((com.tencent.mm.modelbiz.a.c)localObject2).b(paramString);
              ((ArrayList)localObject1).add(localObject2);
            } while (paramString.moveToNext());
          }
          paramString.close();
        }
      }
      QZ();
      paramString = ((List)localObject1).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (com.tencent.mm.modelbiz.a.c)paramString.next();
        bool = ((com.tencent.mm.modelbiz.a.c)localObject1).DV();
        if ((bool) && (this.vum))
        {
          this.vup.add(localObject1);
        }
        else if ((!bool) && (this.vul))
        {
          this.vuo.add(localObject1);
          this.vun.add(localObject1);
        }
      }
      if (this.vul) {
        if (this.vuo.size() > this.vuk) {
          break label414;
        }
      }
      label414:
      for (boolean bool = true;; bool = false)
      {
        this.vux = bool;
        la(paramBoolean);
        GMTrace.o(2965272264704L, 22093);
        return;
      }
    }
    
    final boolean bTi()
    {
      GMTrace.i(2964735393792L, 22089);
      if (this.scene == 2)
      {
        GMTrace.o(2964735393792L, 22089);
        return true;
      }
      GMTrace.o(2964735393792L, 22089);
      return false;
    }
    
    final void bTk()
    {
      GMTrace.i(2965809135616L, 22097);
      BizChatSearchUI localBizChatSearchUI = (BizChatSearchUI)this.context;
      if (bTh())
      {
        if (bf.mA(this.kuS))
        {
          localBizChatSearchUI.vug.setVisibility(8);
          localBizChatSearchUI.vuf.setVisibility(8);
          GMTrace.o(2965809135616L, 22097);
          return;
        }
        if (getCount() <= 0)
        {
          localBizChatSearchUI.vug.setVisibility(0);
          localBizChatSearchUI.vuf.setVisibility(8);
          GMTrace.o(2965809135616L, 22097);
          return;
        }
        localBizChatSearchUI.vug.setVisibility(8);
        localBizChatSearchUI.vuf.setVisibility(0);
        GMTrace.o(2965809135616L, 22097);
        return;
      }
      if (bf.mA(this.kuS))
      {
        localBizChatSearchUI.vug.setVisibility(0);
        localBizChatSearchUI.vug.setText("");
        localBizChatSearchUI.vuf.setVisibility(8);
      }
      while (bTi()) {
        if (this.vuy)
        {
          localBizChatSearchUI.AA(1);
          GMTrace.o(2965809135616L, 22097);
          return;
          if ((bTi()) && (this.vux))
          {
            localBizChatSearchUI.vug.setVisibility(0);
            localBizChatSearchUI.vug.setText(R.l.dOS);
            localBizChatSearchUI.vuf.setVisibility(8);
          }
          else if ((bTi()) && (this.vuB))
          {
            localBizChatSearchUI.vug.setVisibility(0);
            localBizChatSearchUI.vug.setText(R.l.dOT);
            localBizChatSearchUI.vuf.setVisibility(8);
          }
          else if (getCount() <= 0)
          {
            localBizChatSearchUI.vug.setVisibility(0);
            localBizChatSearchUI.vug.setText(f.a(localBizChatSearchUI.getString(R.l.ePu), localBizChatSearchUI.getString(R.l.ePt), com.tencent.mm.plugin.fts.d.b.a.d(this.kuS, this.kuS)).mbY);
            localBizChatSearchUI.vuf.setVisibility(8);
          }
          else
          {
            localBizChatSearchUI.vug.setVisibility(8);
            localBizChatSearchUI.vuf.setVisibility(0);
          }
        }
        else
        {
          if (this.vuw)
          {
            localBizChatSearchUI.AA(2);
            GMTrace.o(2965809135616L, 22097);
            return;
          }
          localBizChatSearchUI.AA(0);
        }
      }
      GMTrace.o(2965809135616L, 22097);
    }
    
    public final int getCount()
    {
      GMTrace.i(2963527434240L, 22080);
      int i = this.Ul;
      GMTrace.o(2963527434240L, 22080);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(2964064305152L, 22084);
      long l = paramInt;
      GMTrace.o(2964064305152L, 22084);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      GMTrace.i(2963661651968L, 22081);
      BizChatSearchUI.g localg = AB(paramInt);
      if (localg != null)
      {
        paramInt = localg.klJ;
        GMTrace.o(2963661651968L, 22081);
        return paramInt;
      }
      paramInt = BizChatSearchUI.g.vuF;
      GMTrace.o(2963661651968L, 22081);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(2964198522880L, 22085);
      BizChatSearchUI.g localg = AB(paramInt);
      View localView;
      int i;
      BizChatSearchUI.f localf;
      Object localObject;
      if ((localg.klJ == BizChatSearchUI.g.vuG) || (localg.klJ == BizChatSearchUI.g.vuH))
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(this.context).inflate(R.i.ddw, paramViewGroup, false);
          i = paramViewGroup.getPaddingLeft();
          int j = paramViewGroup.getPaddingRight();
          localView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), i + j, -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
          paramView = new BizChatSearchUI.f();
          paramView.ipb = ((ImageView)localView.findViewById(R.h.bqF));
          paramView.ipc = ((TextView)localView.findViewById(R.h.cIY));
          paramView.ipd = ((TextView)localView.findViewById(R.h.bHU));
          paramView.ipa = localView.findViewById(R.h.cAE);
          localView.setTag(paramView);
        }
        localf = (BizChatSearchUI.f)localView.getTag();
        localObject = "";
        i = 0;
        if ((localg.data instanceof com.tencent.mm.modelbiz.a.c))
        {
          paramView = (com.tencent.mm.modelbiz.a.c)localg.data;
          if (paramView == null) {
            break label1235;
          }
          if (!paramView.DV())
          {
            localObject = w.DL().iE(paramView.field_bizChatServId);
            if (localObject != null)
            {
              paramViewGroup = ((j)localObject).field_userName;
              paramView = ((j)localObject).field_headImageUrl;
            }
          }
        }
      }
      for (;;)
      {
        boolean bool1 = false;
        i = 1;
        String str = "";
        localObject = paramViewGroup;
        paramViewGroup = str;
        for (;;)
        {
          if (i != 0)
          {
            localObject = com.tencent.mm.as.d.a((CharSequence)localObject, this.kuS);
            localObject = a(this.context, (Spannable)localObject, d.b.maP);
            label302:
            if (!bool1) {
              break label571;
            }
            str = this.context.getString(R.l.dOZ);
            paramViewGroup = com.tencent.mm.as.d.a(paramViewGroup, this.kuS);
          }
          label571:
          for (paramViewGroup = TextUtils.concat(new CharSequence[] { str, a(this.context, paramViewGroup, d.b.maP) });; paramViewGroup = "")
          {
            boolean bool2 = true;
            bool1 = bool2;
            if (localg.klJ == BizChatSearchUI.g.vuG)
            {
              bool1 = bool2;
              if (paramInt == this.vuA - 1)
              {
                bool1 = bool2;
                if (this.vuA != this.Ul) {
                  bool1 = false;
                }
              }
            }
            n(localf.ipa, bool1);
            com.tencent.mm.ah.n.GX().a(paramView, localf.ipb, this.hIg);
            com.tencent.mm.plugin.fts.d.e.a((CharSequence)localObject, localf.ipc);
            com.tencent.mm.plugin.fts.d.e.a(paramViewGroup, localf.ipd);
            GMTrace.o(2964198522880L, 22085);
            return localView;
            paramViewGroup = paramView.field_chatName;
            paramView = paramView.field_headImageUrl;
            break;
            if (!(localg.data instanceof gu)) {
              break label1221;
            }
            paramViewGroup = (gu)localg.data;
            paramView = paramViewGroup.tji;
            localObject = paramView.kfF;
            paramView = paramView.tja;
            bool1 = "userid".equals(paramViewGroup.tjj);
            if (!bool1) {}
            for (i = 1;; i = 0)
            {
              paramViewGroup = paramViewGroup.tjk;
              break;
            }
            localObject = a(this.context, new SpannableString((CharSequence)localObject), d.b.maP);
            break label302;
          }
          if (localg.klJ == BizChatSearchUI.g.vuK)
          {
            localObject = paramView;
            if (paramView == null)
            {
              localObject = LayoutInflater.from(this.context).inflate(R.i.ddC, paramViewGroup, false);
              paramView = new BizChatSearchUI.b();
              paramView.kxs = ((TextView)((View)localObject).findViewById(R.h.bVZ));
              paramView.mbE = ((View)localObject).findViewById(R.h.cqu);
              paramView.ipa = ((View)localObject).findViewById(R.h.cAE);
              ((View)localObject).setTag(paramView);
            }
            paramViewGroup = (BizChatSearchUI.b)((View)localObject).getTag();
            if (((Integer)localg.data).intValue() == BizChatSearchUI.g.vuM) {
              paramView = this.context.getResources().getString(R.l.dOX);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.fts.d.e.a(paramView, paramViewGroup.kxs);
            if (paramInt == 0) {
              paramViewGroup.mbE.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.ipa.setBackgroundResource(R.g.bgh);
              GMTrace.o(2964198522880L, 22085);
              return (View)localObject;
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.vuN) {
                break label1214;
              }
              paramView = this.context.getResources().getString(R.l.dOQ);
              break;
              paramViewGroup.mbE.setVisibility(0);
            }
            if (localg.klJ == BizChatSearchUI.g.vuI)
            {
              localObject = paramView;
              if (paramView == null)
              {
                localObject = LayoutInflater.from(this.context).inflate(R.i.ddL, paramViewGroup, false);
                paramView = new BizChatSearchUI.e();
                paramView.mbJ = ((TextView)((View)localObject).findViewById(R.h.cIA));
                paramView.jaK = ((ImageView)((View)localObject).findViewById(R.h.bWq));
                paramView.ipa = ((View)localObject).findViewById(R.h.cAE);
                ((View)localObject).setTag(paramView);
              }
              paramViewGroup = (BizChatSearchUI.e)((View)localObject).getTag();
              paramView = "";
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.vuM)
              {
                paramView = this.context.getResources().getString(R.l.dOW);
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.vuM) || (this.vuA == this.Ul)) {
                  break label1208;
                }
              }
            }
            label1202:
            label1208:
            for (bool1 = false;; bool1 = true)
            {
              n(paramViewGroup.ipa, bool1);
              paramViewGroup.mbJ.setText(paramView);
              paramViewGroup.jaK.setImageResource(R.k.dxe);
              GMTrace.o(2964198522880L, 22085);
              return (View)localObject;
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.vuN) {
                break;
              }
              paramView = this.context.getResources().getString(R.l.dOV);
              break;
              if (localg.klJ == BizChatSearchUI.g.vuJ)
              {
                localObject = paramView;
                if (paramView == null)
                {
                  localObject = LayoutInflater.from(this.context).inflate(R.i.ddE, paramViewGroup, false);
                  paramView = new BizChatSearchUI.d();
                  paramView.mbJ = ((TextView)((View)localObject).findViewById(R.h.cIA));
                  paramView.ipa = ((View)localObject).findViewById(R.h.cAE);
                  ((View)localObject).setTag(paramView);
                }
                paramView = (BizChatSearchUI.d)((View)localObject).getTag();
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.vuM) || (this.vuA == this.Ul)) {
                  break label1202;
                }
              }
              for (bool1 = false;; bool1 = true)
              {
                n(paramView.ipa, bool1);
                paramView.mbJ.setText(this.context.getResources().getString(R.l.dOS));
                GMTrace.o(2964198522880L, 22085);
                return (View)localObject;
                GMTrace.o(2964198522880L, 22085);
                return null;
              }
            }
            label1214:
            paramView = "";
          }
          label1221:
          bool1 = false;
          paramView = "";
          paramViewGroup = "";
        }
        label1235:
        paramView = "";
        paramViewGroup = "";
      }
    }
    
    public final int getViewTypeCount()
    {
      GMTrace.i(2963795869696L, 22082);
      int i = BizChatSearchUI.g.vuL;
      GMTrace.o(2963795869696L, 22082);
      return i;
    }
    
    final void la(boolean paramBoolean)
    {
      int k = 1;
      GMTrace.i(2965674917888L, 22096);
      this.vur.clear();
      this.vuu.clear();
      int i = 0;
      while (i < Math.min(this.vuk, this.vuo.size()))
      {
        this.vur.add(new BizChatSearchUI.g(BizChatSearchUI.g.vuG, this.vuo.get(i)));
        i += 1;
      }
      i = 0;
      while (i < Math.min(this.vuk, this.vup.size()))
      {
        this.vuu.add(new BizChatSearchUI.g(BizChatSearchUI.g.vuH, this.vup.get(i)));
        i += 1;
      }
      i = this.vuo.size();
      int m = this.vup.size();
      boolean bool;
      label197:
      int j;
      if (this.scene != 2)
      {
        if (this.vuo.size() > this.vuk)
        {
          bool = true;
          this.vuw = bool;
        }
      }
      else
      {
        if (this.vup.size() <= this.vuk) {
          break label337;
        }
        bool = true;
        this.vuz = bool;
        if ((i <= 0) && (!this.vux)) {
          break label358;
        }
        j = Math.min(i, this.vuk) + 1;
        if (!bTh()) {
          break label353;
        }
        if ((!this.vux) && (!this.vuw)) {
          break label343;
        }
        i = 1;
        label248:
        i += j;
      }
      for (;;)
      {
        this.vuA = i;
        j = i;
        if (m > 0)
        {
          m = i + 1 + Math.min(m, this.vuk);
          j = m;
          if (bTh()) {
            if (!this.vuz) {
              break label348;
            }
          }
        }
        label337:
        label343:
        label348:
        for (i = k;; i = 0)
        {
          j = m + i;
          this.Ul = j;
          if (paramBoolean)
          {
            notifyDataSetChanged();
            bTk();
          }
          GMTrace.o(2965674917888L, 22096);
          return;
          bool = false;
          break;
          bool = false;
          break label197;
          i = 0;
          break label248;
        }
        label353:
        i = j;
        continue;
        label358:
        i = 0;
      }
    }
  }
  
  private static final class b
  {
    public View ipa;
    public TextView kxs;
    public View mbE;
    
    public b()
    {
      GMTrace.i(2972251586560L, 22145);
      GMTrace.o(2972251586560L, 22145);
    }
  }
  
  private static final class c
  {
    View jYF;
    View jYG;
    View jYH;
    
    public c()
    {
      GMTrace.i(2984062746624L, 22233);
      GMTrace.o(2984062746624L, 22233);
    }
    
    final void h(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      GMTrace.i(2984196964352L, 22234);
      View localView = this.jYF;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.jYG.setVisibility(8);
        localView = this.jYH;
        if (!paramBoolean2) {
          break label74;
        }
      }
      label74:
      for (int i = j;; i = 8)
      {
        localView.setVisibility(i);
        GMTrace.o(2984196964352L, 22234);
        return;
        i = 8;
        break;
      }
    }
  }
  
  private static final class d
  {
    public View ipa;
    public TextView mbJ;
    
    public d()
    {
      GMTrace.i(3011845816320L, 22440);
      GMTrace.o(3011845816320L, 22440);
    }
  }
  
  private static final class e
  {
    public View ipa;
    public ImageView jaK;
    public TextView mbJ;
    
    public e()
    {
      GMTrace.i(2982049480704L, 22218);
      GMTrace.o(2982049480704L, 22218);
    }
  }
  
  private static final class f
  {
    public View ipa;
    public ImageView ipb;
    public TextView ipc;
    public TextView ipd;
    
    public f()
    {
      GMTrace.i(2995337035776L, 22317);
      GMTrace.o(2995337035776L, 22317);
    }
  }
  
  private static final class g
  {
    public static int vuF;
    public static int vuG;
    public static int vuH;
    public static int vuI;
    public static int vuJ;
    public static int vuK;
    public static int vuL;
    public static int vuM;
    public static int vuN;
    public Object data;
    public int klJ;
    
    static
    {
      GMTrace.i(2997752954880L, 22335);
      vuF = 0;
      vuG = 1;
      vuH = 2;
      vuI = 3;
      vuJ = 4;
      vuK = 5;
      vuL = 6;
      vuM = 1;
      vuN = 2;
      GMTrace.o(2997752954880L, 22335);
    }
    
    public g()
    {
      GMTrace.i(2997484519424L, 22333);
      this.klJ = vuF;
      this.data = null;
      GMTrace.o(2997484519424L, 22333);
    }
    
    public g(int paramInt, Object paramObject)
    {
      GMTrace.i(2997618737152L, 22334);
      this.klJ = paramInt;
      this.data = paramObject;
      GMTrace.o(2997618737152L, 22334);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bizchat/BizChatSearchUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */