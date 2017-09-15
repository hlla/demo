package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.a.b.a;
import com.tencent.mm.modelbiz.a.b.a.b;
import com.tencent.mm.modelbiz.a.d.a;
import com.tencent.mm.modelbiz.a.d.a.b;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.c.a;
import com.tencent.mm.modelbiz.c.a.a;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay.a;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class BizChatConversationUI
  extends BaseConversationUI
{
  private View ipa;
  
  public BizChatConversationUI()
  {
    GMTrace.i(2970372538368L, 22131);
    GMTrace.o(2970372538368L, 22131);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(2970640973824L, 22133);
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.mm.pluginsdk.e.a(this, this.ipa);
    GMTrace.o(2970640973824L, 22133);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2970506756096L, 22132);
    super.onCreate(paramBundle);
    this.ipa = com.tencent.mm.ui.r.eC(this).inflate(R.i.cVG, null);
    setContentView(this.ipa);
    this.vZo = new a();
    aR().aV().a(R.h.ckg, this.vZo).commit();
    com.tencent.mm.pluginsdk.e.a(this, this.ipa);
    GMTrace.o(2970506756096L, 22132);
  }
  
  public static final class a
    extends BaseConversationUI.b
    implements com.tencent.mm.modelbiz.m, m.b
  {
    public String huP;
    public com.tencent.mm.ui.base.p irp;
    public n.d jUC;
    public boolean jUD;
    public TextView jUy;
    public ListView jUz;
    public com.tencent.mm.ui.tools.m jYT;
    public int jZe;
    public int jZf;
    public long jZq;
    public String jZw;
    public boolean uOa;
    private LinearLayout vtP;
    public b vtQ;
    j vtR;
    public int vtS;
    private b.a vtT;
    private d.a vtU;
    private c.a vtV;
    
    public a()
    {
      GMTrace.i(3005537583104L, 22393);
      this.jUD = false;
      this.vtS = 0;
      this.jZe = 0;
      this.jZf = 0;
      this.vtT = new b.a()
      {
        public final void a(b.a.b paramAnonymousb)
        {
          GMTrace.i(14672950460416L, 109322);
          if ((paramAnonymousb != null) && (paramAnonymousb.hwp != null) && (BizChatConversationUI.a.this.jZw.equals(paramAnonymousb.hwp.field_brandUserName)))
          {
            v.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
            BizChatConversationUI.a.this.vtQ.eE(paramAnonymousb.hwo);
            if (BizChatConversationUI.a.this.uOa) {
              BizChatConversationUI.a.this.vtQ.OL();
            }
          }
          GMTrace.o(14672950460416L, 109322);
        }
      };
      this.vtU = new d.a()
      {
        public final void a(d.a.b paramAnonymousb)
        {
          GMTrace.i(14671205629952L, 109309);
          if ((paramAnonymousb != null) && (paramAnonymousb.hwz != null) && (BizChatConversationUI.a.this.jZw.equals(paramAnonymousb.hwz.field_brandUserName)))
          {
            v.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
            BizChatConversationUI.a.this.vtQ.eE(paramAnonymousb.hwo);
            if (BizChatConversationUI.a.this.uOa) {
              BizChatConversationUI.a.this.vtQ.OL();
            }
          }
          GMTrace.o(14671205629952L, 109309);
        }
      };
      this.vtV = new c.a()
      {
        public final void a(c.a.a paramAnonymousa)
        {
          GMTrace.i(14671742500864L, 109313);
          String str = BizChatConversationUI.a.this.bTf();
          if ((paramAnonymousa != null) && (!bf.mA(paramAnonymousa.htS)) && (paramAnonymousa.htS.equals(str)))
          {
            int i = BizChatConversationUI.a.this.vtS;
            BizChatConversationUI.a.this.vtS = f.bc(BizChatConversationUI.a.this.uRf.uRz, str);
            if (BizChatConversationUI.a.this.vtS != i) {
              BizChatConversationUI.a.this.bTd();
            }
          }
          GMTrace.o(14671742500864L, 109313);
        }
      };
      GMTrace.o(3005537583104L, 22393);
    }
    
    public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
    {
      GMTrace.i(3007416631296L, 22407);
      GMTrace.o(3007416631296L, 22407);
    }
    
    public final void a(int paramInt, com.tencent.mm.y.k paramk)
    {
      GMTrace.i(3006745542656L, 22402);
      if (this.irp != null)
      {
        this.irp.dismiss();
        this.irp = null;
      }
      if (paramk.getType() == 1355)
      {
        paramk = ((com.tencent.mm.modelbiz.a.n)paramk).Eb();
        paramk = w.DJ().ir(paramk.tru.tyW.tiZ);
        if (paramk == null)
        {
          Toast.makeText(aa.getContext(), getString(R.l.eLU), 0).show();
          GMTrace.o(3006745542656L, 22402);
          return;
        }
        eF(paramk.field_bizChatLocalId);
      }
      GMTrace.o(3006745542656L, 22402);
    }
    
    public final void ay(LinkedList<String> paramLinkedList)
    {
      GMTrace.i(16020228014080L, 119360);
      if (paramLinkedList.size() == 0)
      {
        v.i("MicroMsg.BizChatConversationFmUI", "userIdList is empty");
        GMTrace.o(16020228014080L, 119360);
        return;
      }
      SharedPreferences localSharedPreferences = SA(aa.bIN());
      if (!localSharedPreferences.getBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + this.jZw, true))
      {
        GMTrace.o(16020228014080L, 119360);
        return;
      }
      v.i("MicroMsg.BizChatConversationFmUI", "updateData");
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.e.e locale = w.DL().gUp;
      long l1 = 0L;
      if ((locale instanceof com.tencent.mm.bj.g)) {
        l1 = ((com.tencent.mm.bj.g)locale).cs(Thread.currentThread().getId());
      }
      Iterator localIterator = paramLinkedList.iterator();
      label228:
      while (localIterator.hasNext())
      {
        paramLinkedList = (String)localIterator.next();
        com.tencent.mm.modelbiz.a.c localc = w.DJ().ir(paramLinkedList);
        if ((localc != null) && (!localc.DV()))
        {
          paramLinkedList = w.DL().iE(paramLinkedList);
          if (paramLinkedList != null) {}
          for (paramLinkedList = paramLinkedList.field_userName;; paramLinkedList = null)
          {
            if ((paramLinkedList == null) || (paramLinkedList.equals(localc.field_chatName))) {
              break label228;
            }
            localc.field_chatName = paramLinkedList;
            w.DJ().b(localc);
            break;
          }
        }
      }
      if ((locale instanceof com.tencent.mm.bj.g))
      {
        ap.yY();
        com.tencent.mm.u.c.wO().aD(l1);
      }
      localSharedPreferences.edit().putBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + this.jZw, false).commit();
      v.d("MicroMsg.BizChatConversationFmUI", "updateData use time:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      GMTrace.o(16020228014080L, 119360);
    }
    
    public final void bTd()
    {
      GMTrace.i(3006879760384L, 22403);
      String str = bTf();
      this.vtS = f.bc(this.uRf.uRz, str);
      if ((this.vtS == 2) && (this.vtP == null))
      {
        this.vtP = ((LinearLayout)findViewById(R.h.bottom_bar));
        Object localObject = this.vtP.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.bg.a.T(this.uRf.uRz, R.f.aWS);
        this.vtP.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = com.tencent.mm.ui.r.eC(this.uRf.uRz).inflate(R.i.dbc, this.vtP, false);
        float f = com.tencent.mm.bg.a.dI(this.uRf.uRz);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(R.h.bWq);
        int i = localImageView.getLayoutParams().height;
        localImageView.getLayoutParams().height = ((int)(i * f));
        localImageView.getLayoutParams().width = ((int)(f * i));
        localImageView.requestLayout();
        ((TextView)((View)localObject).findViewById(R.h.cIY)).setText(R.l.eeN);
        this.vtP.addView((View)localObject);
        ((View)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(3002047922176L, 22367);
            f.k(BizChatConversationUI.a.this.uRf.uRz, BizChatConversationUI.a.this.jZw, 4);
            GMTrace.o(3002047922176L, 22367);
          }
        });
        f.j(this.uRf.uRz, this.jZw, 4);
        f.bd(this.uRf.uRz, str);
      }
      if (this.vtP != null)
      {
        if (this.vtS == 2)
        {
          this.vtP.setVisibility(0);
          GMTrace.o(3006879760384L, 22403);
          return;
        }
        this.vtP.setVisibility(8);
      }
      GMTrace.o(3006879760384L, 22403);
    }
    
    final void bTe()
    {
      boolean bool = false;
      GMTrace.i(3007013978112L, 22404);
      Object localObject = w.DL().iG(this.jZw);
      this.vtR = w.DL().iE((String)localObject);
      String str = this.jZw;
      if (this.vtR == null) {
        bool = true;
      }
      v.i("MicroMsg.BizChatConversationFmUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, localObject, Boolean.valueOf(bool) });
      if ((bf.mA((String)localObject)) || (this.vtR == null) || (this.vtR.DW()) || (bf.mA(this.vtR.field_addMemberUrl)))
      {
        w.DN();
        h.a(this.jZw, this);
        localObject = bOZ();
        getString(R.l.dIG);
        this.irp = com.tencent.mm.ui.base.g.a((Context)localObject, getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(14672010936320L, 109315);
            BizChatConversationUI.a.this.finish();
            GMTrace.o(14672010936320L, 109315);
          }
        });
      }
      GMTrace.o(3007013978112L, 22404);
    }
    
    public final String bTf()
    {
      GMTrace.i(3007148195840L, 22405);
      if (bf.mA(this.huP)) {
        this.huP = w.DH().hO(this.jZw).CO();
      }
      String str = this.huP;
      GMTrace.o(3007148195840L, 22405);
      return str;
    }
    
    public final void eF(long paramLong)
    {
      GMTrace.i(3007282413568L, 22406);
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      this.vZA.a(this.jZw, localBundle, true);
      GMTrace.o(3007282413568L, 22406);
    }
    
    protected final int getLayoutId()
    {
      GMTrace.i(3005806018560L, 22395);
      int i = R.i.dbb;
      GMTrace.o(3005806018560L, 22395);
      return i;
    }
    
    public final String getUserName()
    {
      GMTrace.i(3005940236288L, 22396);
      if (bf.mA(this.huP))
      {
        str = this.jZw;
        GMTrace.o(3005940236288L, 22396);
        return str;
      }
      String str = this.huP;
      GMTrace.o(3005940236288L, 22396);
      return str;
    }
    
    public final void onActivityCreated(final Bundle paramBundle)
    {
      GMTrace.i(3005671800832L, 22394);
      super.onActivityCreated(paramBundle);
      this.jZw = bOZ().getIntent().getStringExtra("Contact_User");
      v.i("MicroMsg.BizChatConversationFmUI", "[regitListener]");
      w.DK().a(this.vtT, bOZ().getMainLooper());
      w.DJ().a(this.vtU, bOZ().getMainLooper());
      w.DO().a(this.vtV, bOZ().getMainLooper());
      ap.yY();
      com.tencent.mm.u.c.wW().a(this);
      this.jUy = ((TextView)findViewById(R.h.bLN));
      this.jUy.setText(R.l.eyY);
      this.jUz = ((ListView)findViewById(R.h.cIZ));
      bTd();
      this.vtQ = new b(bOZ(), new k.a()
      {
        public final void OI()
        {
          GMTrace.i(14670131888128L, 109301);
          BizChatConversationUI.a.this.qL(com.tencent.mm.u.n.eK(BizChatConversationUI.a.this.jZw));
          if (BizChatConversationUI.a.this.vtQ.getCount() <= 0)
          {
            BizChatConversationUI.a.this.jUy.setVisibility(0);
            BizChatConversationUI.a.this.jUz.setVisibility(8);
            GMTrace.o(14670131888128L, 109301);
            return;
          }
          BizChatConversationUI.a.this.jUy.setVisibility(8);
          if (BizChatConversationUI.a.this.jUz != null) {
            BizChatConversationUI.a.this.jUz.setVisibility(0);
          }
          GMTrace.o(14670131888128L, 109301);
        }
        
        public final void OJ()
        {
          GMTrace.i(14670266105856L, 109302);
          GMTrace.o(14670266105856L, 109302);
        }
      }, this.jZw);
      this.vtQ.a(new MMSlideDelView.c()
      {
        public final int bY(View paramAnonymousView)
        {
          GMTrace.i(14672816242688L, 109321);
          int i = BizChatConversationUI.a.this.jUz.getPositionForView(paramAnonymousView);
          GMTrace.o(14672816242688L, 109321);
          return i;
        }
      });
      this.vtQ.a(new MMSlideDelView.f()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt)
        {
          GMTrace.i(14672413589504L, 109318);
          BizChatConversationUI.a.this.jUz.performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
          GMTrace.o(14672413589504L, 109318);
        }
      });
      this.vtQ.a(new MMSlideDelView.e()
      {
        public final void aQ(Object paramAnonymousObject)
        {
          GMTrace.i(14671876718592L, 109314);
          if (paramAnonymousObject == null)
          {
            v.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
            GMTrace.o(14671876718592L, 109314);
            return;
          }
          GMTrace.o(14671876718592L, 109314);
        }
      });
      this.jUz.setAdapter(this.vtQ);
      this.jUC = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(2991713157120L, 22290);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            GMTrace.o(2991713157120L, 22290);
            return;
            paramAnonymousMenuItem = BizChatConversationUI.a.this;
            long l = BizChatConversationUI.a.this.jZq;
            v.i("MicroMsg.BizChatConversationFmUI", "deleteChatroom");
            w.DJ().aa(l);
            paramAnonymousMenuItem.jUD = false;
            FragmentActivity localFragmentActivity = paramAnonymousMenuItem.bOZ();
            paramAnonymousMenuItem.getString(R.l.dIG);
            paramAnonymousMenuItem.irp = com.tencent.mm.ui.base.g.a(localFragmentActivity, paramAnonymousMenuItem.getString(R.l.dIV), true, new BizChatConversationUI.a.7(paramAnonymousMenuItem));
            com.tencent.mm.u.g.a(paramAnonymousMenuItem.jZw, l, new BizChatConversationUI.a.8(paramAnonymousMenuItem, l));
            GMTrace.o(2991713157120L, 22290);
            return;
            paramAnonymousMenuItem = w.DK().U(BizChatConversationUI.a.this.jZq);
            paramAnonymousMenuItem.field_unReadCount = 1;
            paramAnonymousMenuItem.field_atCount = 0;
            w.DK().b(paramAnonymousMenuItem);
            com.tencent.mm.modelstat.b.hTV.A(paramAnonymousMenuItem.field_brandUserName, true);
            GMTrace.o(2991713157120L, 22290);
            return;
            w.DK().W(BizChatConversationUI.a.this.jZq);
            paramAnonymousMenuItem = w.DK().U(BizChatConversationUI.a.this.jZq);
            com.tencent.mm.modelstat.b.hTV.A(paramAnonymousMenuItem.field_brandUserName, false);
            GMTrace.o(2991713157120L, 22290);
            return;
            paramAnonymousMenuItem = w.DK().U(BizChatConversationUI.a.this.jZq);
            if (w.DK().X(BizChatConversationUI.a.this.jZq))
            {
              w.DK().Z(BizChatConversationUI.a.this.jZq);
              com.tencent.mm.modelstat.b.hTV.b(true, paramAnonymousMenuItem.field_brandUserName, false);
              GMTrace.o(2991713157120L, 22290);
              return;
            }
            w.DK().Y(BizChatConversationUI.a.this.jZq);
            com.tencent.mm.modelstat.b.hTV.b(true, paramAnonymousMenuItem.field_brandUserName, true);
          }
        }
      };
      paramBundle = new com.tencent.mm.ui.widget.g(bOZ());
      this.jUz.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(14676037468160L, 109345);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            BizChatConversationUI.a.this.jZe = ((int)paramAnonymousMotionEvent.getRawX());
            BizChatConversationUI.a.this.jZf = ((int)paramAnonymousMotionEvent.getRawY());
          }
          GMTrace.o(14676037468160L, 109345);
          return false;
        }
      });
      this.jUz.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(14670534541312L, 109304);
          paramBundle.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatConversationUI.a.this, BizChatConversationUI.a.this.jUC, BizChatConversationUI.a.this.jZe, BizChatConversationUI.a.this.jZf);
          GMTrace.o(14670534541312L, 109304);
          return true;
        }
      });
      this.jUz.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(14670668759040L, 109305);
          paramAnonymousAdapterView = (com.tencent.mm.modelbiz.a.a)BizChatConversationUI.a.this.vtQ.getItem(paramAnonymousInt);
          BizChatConversationUI.a.this.eF(paramAnonymousAdapterView.field_bizChatId);
          GMTrace.o(14670668759040L, 109305);
        }
      });
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2962722127872L, 22074);
          BizChatConversationUI.a.this.finish();
          GMTrace.o(2962722127872L, 22074);
          return true;
        }
      });
      a(1, R.l.eYc, R.k.dsK, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2969969885184L, 22128);
          v.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
          paramAnonymousMenuItem = new Intent(BizChatConversationUI.a.this.uRf.uRz, BizChatSearchUI.class);
          paramAnonymousMenuItem.putExtra("enterprise_biz_name", BizChatConversationUI.a.this.jZw);
          paramAnonymousMenuItem.putExtra("biz_chat_search_scene", 1);
          paramAnonymousMenuItem.putExtra("biz_chat_search_text", "");
          paramAnonymousMenuItem.addFlags(67108864);
          BizChatConversationUI.a.this.startActivity(paramAnonymousMenuItem);
          GMTrace.o(2969969885184L, 22128);
          return true;
        }
      });
      a(2, R.l.dBF, R.k.dsy, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(14669997670400L, 109300);
          if (BizChatConversationUI.a.this.jYT != null)
          {
            BizChatConversationUI.a.this.jYT.dismiss();
            BizChatConversationUI.a.this.jYT = null;
          }
          BizChatConversationUI.a.this.jYT = new com.tencent.mm.ui.tools.m(BizChatConversationUI.a.this.uRf.uRz);
          BizChatConversationUI.a.this.jYT.qHD = new n.c()
          {
            public final void a(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              GMTrace.i(14672279371776L, 109317);
              if (BizChatConversationUI.a.this.vtS == 1)
              {
                paramAnonymous2l.W(2, R.l.eeS, R.k.dsD);
                f.j(BizChatConversationUI.a.this.uRf.uRz, BizChatConversationUI.a.this.jZw, 6);
              }
              paramAnonymous2l.W(1, R.l.dOM, R.k.dsz);
              paramAnonymous2l.W(4, R.l.dOL, R.k.dsB);
              paramAnonymous2l.W(3, R.l.dBG, R.k.dsM);
              GMTrace.o(14672279371776L, 109317);
            }
          };
          BizChatConversationUI.a.this.jYT.qHE = new n.d()
          {
            public final void c(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              GMTrace.i(14672682024960L, 109320);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                GMTrace.o(14672682024960L, 109320);
                return;
                paramAnonymous2MenuItem = BizChatConversationUI.a.this;
                Object localObject = w.DL().iG(paramAnonymous2MenuItem.jZw);
                paramAnonymous2MenuItem.vtR = w.DL().iE((String)localObject);
                if ((paramAnonymous2MenuItem.vtR == null) || (bf.mA(paramAnonymous2MenuItem.vtR.field_addMemberUrl)))
                {
                  Toast.makeText(paramAnonymous2MenuItem.bOZ(), paramAnonymous2MenuItem.getString(R.l.dON), 0).show();
                  paramAnonymous2MenuItem.bTe();
                  GMTrace.o(14672682024960L, 109320);
                  return;
                }
                localObject = new Intent();
                ((Intent)localObject).putExtra("rawUrl", paramAnonymous2MenuItem.vtR.field_addMemberUrl);
                v.i("MicroMsg.BizChatConversationFmUI", "KRawUrl :%s", new Object[] { paramAnonymous2MenuItem.vtR.field_addMemberUrl });
                ((Intent)localObject).putExtra("useJs", true);
                ((Intent)localObject).addFlags(67108864);
                com.tencent.mm.bb.d.b(paramAnonymous2MenuItem.uRf.uRz, "webview", ".ui.tools.WebViewUI", (Intent)localObject, 1);
                GMTrace.o(14672682024960L, 109320);
                return;
                f.k(BizChatConversationUI.a.this.uRf.uRz, BizChatConversationUI.a.this.jZw, 6);
                GMTrace.o(14672682024960L, 109320);
                return;
                if (bf.mA(BizChatConversationUI.a.this.huP))
                {
                  paramAnonymous2MenuItem = w.DH().hO(BizChatConversationUI.a.this.jZw);
                  BizChatConversationUI.a.this.huP = paramAnonymous2MenuItem.CO();
                }
                if ((!bf.mA(BizChatConversationUI.a.this.huP)) && (w.DR().hB(BizChatConversationUI.a.this.huP)))
                {
                  w.DO();
                  com.tencent.mm.modelbiz.c.a(BizChatConversationUI.a.this.huP, null);
                }
                paramAnonymous2MenuItem = new Intent();
                paramAnonymous2MenuItem.putExtra("Contact_User", BizChatConversationUI.a.this.jZw);
                com.tencent.mm.bb.d.b(BizChatConversationUI.a.this.bOZ(), "profile", ".ui.ContactInfoUI", paramAnonymous2MenuItem);
                GMTrace.o(14672682024960L, 109320);
                return;
                if (!bf.mA(BizChatConversationUI.a.this.jZw))
                {
                  paramAnonymous2MenuItem = new Intent(BizChatConversationUI.a.this.uRf.uRz, BizChatFavUI.class);
                  paramAnonymous2MenuItem.putExtra("Contact_User", BizChatConversationUI.a.this.jZw);
                  paramAnonymous2MenuItem.addFlags(67108864);
                  BizChatConversationUI.a.this.startActivity(paramAnonymous2MenuItem);
                  GMTrace.o(14672682024960L, 109320);
                  return;
                }
                v.e("MicroMsg.BizChatConversationFmUI", "brandUserName null");
              }
            }
          };
          BizChatConversationUI.a.this.jYT.dL();
          GMTrace.o(14669997670400L, 109300);
          return false;
        }
      });
      bTe();
      ap.vL().e(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14676171685888L, 109346);
          v.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
          LinkedList localLinkedList1 = new LinkedList();
          LinkedList localLinkedList2 = new LinkedList();
          Cursor localCursor = w.DK().ip(BizChatConversationUI.a.this.jZw);
          if (localCursor.moveToFirst()) {
            while (!localCursor.isAfterLast())
            {
              Object localObject = new com.tencent.mm.modelbiz.a.a();
              ((com.tencent.mm.modelbiz.a.a)localObject).b(localCursor);
              localCursor.moveToNext();
              localObject = w.DJ().aa(((com.tencent.mm.modelbiz.a.a)localObject).field_bizChatId);
              if (((com.tencent.mm.modelbiz.a.c)localObject).DW()) {
                if (((com.tencent.mm.modelbiz.a.c)localObject).DV()) {
                  localLinkedList2.add(((com.tencent.mm.modelbiz.a.c)localObject).field_bizChatServId);
                } else {
                  localLinkedList1.add(((com.tencent.mm.modelbiz.a.c)localObject).field_bizChatServId);
                }
              }
            }
          }
          localCursor.close();
          if (localLinkedList2.size() > 0) {
            w.DN().a(localLinkedList2, BizChatConversationUI.a.this.jZw);
          }
          BizChatConversationUI.a.this.ay(localLinkedList1);
          if (localLinkedList1.size() > 0) {
            w.DN().b(localLinkedList1, BizChatConversationUI.a.this.jZw);
          }
          GMTrace.o(14676171685888L, 109346);
        }
      }, 300L);
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          GMTrace.i(2990370979840L, 22280);
          Object localObject = w.DH().hO(BizChatConversationUI.a.this.jZw);
          BizChatConversationUI.a.this.huP = ((BizInfo)localObject).CO();
          int m = BizChatConversationUI.a.this.bOZ().getIntent().getIntExtra("biz_chat_from_scene", 7);
          int i = -1;
          if (BizChatConversationUI.a.this.vtQ != null) {
            i = BizChatConversationUI.a.this.vtQ.getCount();
          }
          localObject = w.DO().hC(BizChatConversationUI.a.this.huP);
          int j;
          int k;
          label115:
          int n;
          long l1;
          if (localObject != null)
          {
            j = ((com.tencent.mm.modelbiz.b)localObject).field_qyUin;
            if (localObject == null) {
              break label348;
            }
            k = ((com.tencent.mm.modelbiz.b)localObject).field_userUin;
            n = w.DO().hE(BizChatConversationUI.a.this.jZw);
            if (localObject == null) {
              break label353;
            }
            l1 = ((com.tencent.mm.modelbiz.b)localObject).field_wwCorpId;
            label142:
            if (localObject == null) {
              break label359;
            }
          }
          label348:
          label353:
          label359:
          for (long l2 = ((com.tencent.mm.modelbiz.b)localObject).field_wwUserVid;; l2 = 0L)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(12648, new Object[] { BizChatConversationUI.a.this.huP, BizChatConversationUI.a.this.jZw, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
            v.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[] { BizChatConversationUI.a.this.huP, BizChatConversationUI.a.this.jZw, Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
            GMTrace.o(2990370979840L, 22280);
            return false;
            j = 0;
            break;
            k = 0;
            break label115;
            l1 = 0L;
            break label142;
          }
        }
      });
      paramBundle = bOZ().getIntent();
      if (com.tencent.mm.sdk.platformtools.r.a(paramBundle, "biz_chat_need_to_jump_to_chatting_ui", false))
      {
        long l = paramBundle.getLongExtra("biz_chat_chat_id", -1L);
        if (l != -1L) {
          eF(l);
        }
      }
      GMTrace.o(3005671800832L, 22394);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
    {
      GMTrace.i(3006611324928L, 22401);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 != -1)
      {
        GMTrace.o(3006611324928L, 22401);
        return;
      }
      switch (paramInt1)
      {
      default: 
        GMTrace.o(3006611324928L, 22401);
        return;
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      Object localObject;
      sr localsr;
      if (paramIntent != null)
      {
        v.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
        localObject = paramIntent.getString("enterprise_members");
        localsr = new sr();
        com.tencent.mm.modelbiz.a.c localc = new com.tencent.mm.modelbiz.a.c();
        if (this.vtR != null)
        {
          paramIntent = this.vtR.field_addMemberUrl;
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.jZw;
          if (!com.tencent.mm.modelbiz.a.e.a(localc, (String)localObject, null, localsr)) {
            break label272;
          }
          if (localc.field_bizChatLocalId == -1L) {
            break label212;
          }
          eF(localc.field_bizChatLocalId);
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        if (paramInt1 == 0)
        {
          Toast.makeText(bOZ(), getString(R.l.eLU), 0).show();
          GMTrace.o(3006611324928L, 22401);
          return;
          paramIntent = null;
          break;
          label212:
          w.DN();
          paramIntent = h.a(this.jZw, localsr, this);
          localObject = bOZ();
          getString(R.l.dIG);
          this.irp = com.tencent.mm.ui.base.g.a((Context)localObject, getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              GMTrace.i(3010637856768L, 22431);
              w.DN();
              h.f(paramIntent);
              GMTrace.o(3010637856768L, 22431);
            }
          });
          paramInt1 = 1;
          continue;
          label272:
          paramInt1 = 0;
          continue;
        }
        GMTrace.o(3006611324928L, 22401);
        return;
        paramInt1 = 0;
      }
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      GMTrace.i(3006477107200L, 22400);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenuInfo = (com.tencent.mm.modelbiz.a.a)this.vtQ.getItem(paramView.position);
      this.jZq = paramContextMenuInfo.field_bizChatId;
      if (paramContextMenuInfo.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 0, R.l.eyR);
        w.DK();
        if (!com.tencent.mm.modelbiz.a.b.c(paramContextMenuInfo)) {
          break label132;
        }
        paramContextMenu.add(paramView.position, 3, 1, R.l.eyS);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 2, R.l.eyV);
        GMTrace.o(3006477107200L, 22400);
        return;
        paramContextMenu.add(paramView.position, 2, 0, R.l.eyP);
        break;
        label132:
        paramContextMenu.add(paramView.position, 3, 1, R.l.eyQ);
      }
    }
    
    public final void onDestroy()
    {
      GMTrace.i(3006074454016L, 22397);
      v.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
      w.DK().a(this.vtT);
      w.DJ().a(this.vtU);
      w.DO().a(this.vtV);
      if (ap.zb())
      {
        ap.yY();
        com.tencent.mm.u.c.wW().b(this);
      }
      this.vtQ.aEP();
      b localb = this.vtQ;
      if (localb.vtF != null)
      {
        localb.vtF.clear();
        localb.vtF = null;
      }
      super.onDestroy();
      GMTrace.o(3006074454016L, 22397);
    }
    
    public final void onPause()
    {
      GMTrace.i(3006342889472L, 22399);
      v.i("MicroMsg.BizChatConversationFmUI", "on pause");
      ap.yY();
      com.tencent.mm.u.c.wW().Rn(this.jZw);
      com.tencent.mm.modelbiz.a.b localb = w.DK();
      String str = this.jZw;
      if (bf.mA(str)) {
        v.e("MicroMsg.BizConversationStorage", "brandUserName is null");
      }
      for (;;)
      {
        if (this.vtQ != null) {
          this.vtQ.onPause();
        }
        this.uOa = false;
        ap.getNotification().db("");
        super.onPause();
        GMTrace.o(3006342889472L, 22399);
        return;
        str = "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'";
        v.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", new Object[] { Boolean.valueOf(localb.gUp.eE("BizChatConversation", str)), str });
      }
    }
    
    public final void onResume()
    {
      GMTrace.i(3006208671744L, 22398);
      super.onResume();
      ap.yY();
      x localx = com.tencent.mm.u.c.wR().Rb(this.jZw);
      if ((localx == null) || (!com.tencent.mm.j.a.ez(localx.field_type)))
      {
        finish();
        GMTrace.o(3006208671744L, 22398);
        return;
      }
      BizInfo localBizInfo = com.tencent.mm.modelbiz.e.hW(this.jZw);
      if ((localBizInfo == null) || (localBizInfo.field_enterpriseFather == null) || (!o.eU(localBizInfo.field_enterpriseFather)))
      {
        finish();
        GMTrace.o(3006208671744L, 22398);
        return;
      }
      if (localx.tD()) {
        zj(0);
      }
      for (;;)
      {
        this.uOa = true;
        this.vtQ.a(null, null);
        ap.getNotification().db(this.jZw);
        GMTrace.o(3006208671744L, 22398);
        return;
        zj(8);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bizchat/BizChatConversationUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */