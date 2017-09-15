package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI
  extends MMActivity
{
  private static boolean vtq;
  private String fJC;
  private ListView jZa;
  private long jZq;
  private String kuI;
  private String kuJ;
  private p kuK;
  private String mTitle;
  private a vto;
  private com.tencent.mm.modelbiz.a.c vtp;
  
  static
  {
    GMTrace.i(14474174005248L, 107841);
    vtq = false;
    GMTrace.o(14474174005248L, 107841);
  }
  
  public BizChatAtSomeoneUI()
  {
    GMTrace.i(2982854787072L, 22224);
    GMTrace.o(2982854787072L, 22224);
  }
  
  protected static String a(com.tencent.mm.modelbiz.a.c paramc, String paramString)
  {
    GMTrace.i(2983660093440L, 22230);
    if (paramc == null)
    {
      GMTrace.o(2983660093440L, 22230);
      return null;
    }
    paramc = paramc.eK(paramString);
    GMTrace.o(2983660093440L, 22230);
    return paramc;
  }
  
  protected final void KD()
  {
    GMTrace.i(2983123222528L, 22226);
    qL(this.mTitle);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2967553966080L, 22110);
        BizChatAtSomeoneUI.this.setResult(0);
        BizChatAtSomeoneUI.this.finish();
        GMTrace.o(2967553966080L, 22110);
        return true;
      }
    });
    this.kuK = new p(true, true);
    this.kuK.wlY = new p.b()
    {
      public final void OE()
      {
        GMTrace.i(2996008124416L, 22322);
        GMTrace.o(2996008124416L, 22322);
      }
      
      public final void OF()
      {
        GMTrace.i(2996142342144L, 22323);
        GMTrace.o(2996142342144L, 22323);
      }
      
      public final void OG()
      {
        GMTrace.i(2996276559872L, 22324);
        GMTrace.o(2996276559872L, 22324);
      }
      
      public final void OH()
      {
        GMTrace.i(16851841056768L, 125556);
        GMTrace.o(16851841056768L, 125556);
      }
      
      public final boolean mQ(String paramAnonymousString)
      {
        GMTrace.i(2995873906688L, 22321);
        GMTrace.o(2995873906688L, 22321);
        return false;
      }
      
      public final void mR(String paramAnonymousString)
      {
        GMTrace.i(2995739688960L, 22320);
        BizChatAtSomeoneUI.a locala = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this);
        locala.kuS = paramAnonymousString;
        locala.a(null, null);
        GMTrace.o(2995739688960L, 22320);
      }
    };
    a(this.kuK);
    this.jZa = ((ListView)findViewById(R.h.bzc));
    j localj = new j();
    com.tencent.mm.modelbiz.a.c localc = this.vtp;
    String[] arrayOfString = null;
    if (!u.mA(this.kuJ))
    {
      arrayOfString = this.kuJ.split(";");
      v.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString(arrayOfString) });
    }
    Object localObject = new LinkedList();
    if (!u.mA(this.kuI)) {
      localObject = u.f(this.kuI.split(";"));
    }
    this.vto = new a(this, localj, localc, arrayOfString, (List)localObject);
    this.jZa.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(3011711598592L, 22439);
        paramAnonymousAdapterView = new Intent();
        if ((paramAnonymousInt == 0) && (BizChatAtSomeoneUI.ez()))
        {
          paramAnonymousAdapterView.putExtra("Select_Conv_User", BizChatAtSomeoneUI.this.getString(R.l.dJd, new Object[] { "" }));
          paramAnonymousAdapterView.putExtra("select_raw_user_name", "notify@all");
        }
        for (;;)
        {
          BizChatAtSomeoneUI.this.setResult(-1, paramAnonymousAdapterView);
          BizChatAtSomeoneUI.this.finish();
          GMTrace.o(3011711598592L, 22439);
          return;
          paramAnonymousView = (j)BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.this).getItem(paramAnonymousInt);
          String str = BizChatAtSomeoneUI.a(BizChatAtSomeoneUI.b(BizChatAtSomeoneUI.this), paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("select_raw_user_name", paramAnonymousView.field_userId);
          paramAnonymousAdapterView.putExtra("Select_Conv_User", str);
        }
      }
    });
    this.jZa.setAdapter(this.vto);
    this.jZa.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2994531729408L, 22311);
        GMTrace.o(2994531729408L, 22311);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        GMTrace.i(2994397511680L, 22310);
        n.GX().bi(paramAnonymousInt);
        GMTrace.o(2994397511680L, 22310);
      }
    });
    GMTrace.o(2983123222528L, 22226);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2983525875712L, 22229);
    int i = R.i.cUJ;
    GMTrace.o(2983525875712L, 22229);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2982989004800L, 22225);
    super.onCreate(paramBundle);
    this.kuI = getIntent().getStringExtra("Block_list");
    this.kuJ = getIntent().getStringExtra("Chatroom_member_list");
    this.fJC = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    this.jZq = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.vtp = w.DJ().aa(this.jZq);
    if (this.vtp == null)
    {
      v.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
      finish();
      GMTrace.o(2982989004800L, 22225);
      return;
    }
    if ((this.vtp != null) && (this.vtp.field_ownerUserId.equals(m.xL()))) {
      vtq = true;
    }
    KD();
    GMTrace.o(2982989004800L, 22225);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2983391657984L, 22228);
    this.vto.aEP();
    super.onDestroy();
    GMTrace.o(2983391657984L, 22228);
  }
  
  protected void onPause()
  {
    GMTrace.i(2983257440256L, 22227);
    super.onPause();
    if (this.kuK != null) {
      this.kuK.bZF();
    }
    GMTrace.o(2983257440256L, 22227);
  }
  
  private static final class a
    extends com.tencent.mm.ui.k<j>
  {
    private List<String> jzO;
    private com.tencent.mm.ah.a.a.c kuE;
    String kuS;
    private com.tencent.mm.modelbiz.a.c vtp;
    private String[] vts;
    private Bitmap vtt;
    
    public a(Context paramContext, j paramj, com.tencent.mm.modelbiz.a.c paramc, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramj);
      GMTrace.i(2994665947136L, 22312);
      this.kuE = null;
      this.vtp = paramc;
      this.vts = paramArrayOfString;
      this.jzO = paramList;
      paramj = new c.a();
      paramj.hIw = com.tencent.mm.modelbiz.a.e.iB(this.vtp.field_brandUserName);
      paramj.hIt = true;
      paramj.hIP = true;
      paramj.hII = R.k.ber;
      this.kuE = paramj.Hh();
      this.vtt = com.tencent.mm.sdk.platformtools.d.t(paramContext.getResources().getDrawable(R.k.dtN));
      GMTrace.o(2994665947136L, 22312);
    }
    
    public final void OL()
    {
      GMTrace.i(2994934382592L, 22314);
      aEP();
      com.tencent.mm.modelbiz.a.k localk = w.DL();
      Object localObject2 = this.vts;
      Object localObject1 = this.kuS;
      List localList = this.jzO;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("select *  from BizChatUserInfo where ");
      localObject2 = localStringBuilder.append(com.tencent.mm.modelbiz.a.k.a((String[])localObject2, localList));
      if ((localObject1 == null) || (((String)localObject1).equals(""))) {}
      for (localObject1 = "";; localObject1 = " and (" + "userName like '%" + (String)localObject1 + "%' )")
      {
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = localStringBuilder.append(" order by ");
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append(" case when length(BizChatUserInfo.userNamePY) > 0 then upper(").append("BizChatUserInfo.userNamePY) ");
        ((StringBuffer)localObject2).append(" else upper(BizChatUserInfo.userName) end asc, ");
        ((StringBuffer)localObject2).append(" upper(BizChatUserInfo.userNamePY) asc, ");
        ((StringBuffer)localObject2).append(" upper(BizChatUserInfo.userName) asc ");
        ((StringBuilder)localObject1).append(((StringBuffer)localObject2).toString());
        setCursor(localk.gUp.rawQuery(localStringBuilder.toString(), null));
        super.notifyDataSetChanged();
        GMTrace.o(2994934382592L, 22314);
        return;
      }
    }
    
    protected final void OM()
    {
      GMTrace.i(2995068600320L, 22315);
      OL();
      GMTrace.o(2995068600320L, 22315);
    }
    
    protected final int aBO()
    {
      GMTrace.i(14474308222976L, 107842);
      if (BizChatAtSomeoneUI.ez())
      {
        GMTrace.o(14474308222976L, 107842);
        return 1;
      }
      GMTrace.o(14474308222976L, 107842);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(2994800164864L, 22313);
      if (paramView == null)
      {
        paramView = View.inflate(this.context, R.i.cUI, null);
        paramViewGroup = new BizChatAtSomeoneUI.b();
        paramViewGroup.kvj = ((MaskLayout)paramView.findViewById(R.h.bqi));
        paramViewGroup.jXN = ((TextView)paramView.findViewById(R.h.bqj));
        paramView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (BizChatAtSomeoneUI.ez()))
      {
        paramViewGroup.vtu.setImageBitmap(this.vtt);
        paramViewGroup.jXN.setText(this.context.getResources().getString(R.l.dJd, new Object[] { "@" }));
        GMTrace.o(2994800164864L, 22313);
        return paramView;
        paramViewGroup = (BizChatAtSomeoneUI.b)paramView.getTag();
      }
      if (BizChatAtSomeoneUI.ez()) {}
      for (int i = 1;; i = 0)
      {
        Object localObject = (j)getItem(paramInt - i);
        paramViewGroup.jXN.setTextColor(com.tencent.mm.bg.a.S(this.context, R.e.aVa));
        ImageView localImageView = (ImageView)paramViewGroup.kvj.view;
        n.GX().a(((j)localObject).field_headImageUrl, localImageView, this.kuE);
        paramViewGroup.kvj.bSx();
        localObject = BizChatAtSomeoneUI.a(this.vtp, ((j)localObject).field_userId);
        paramViewGroup.jXN.setText(h.b(this.context, (CharSequence)localObject, paramViewGroup.jXN.getTextSize()));
        GMTrace.o(2994800164864L, 22313);
        return paramView;
      }
    }
    
    public final boolean nF(int paramInt)
    {
      GMTrace.i(14474442440704L, 107843);
      GMTrace.o(14474442440704L, 107843);
      return false;
    }
  }
  
  private static final class b
  {
    public TextView jXN;
    public MaskLayout kvj;
    public ImageView vtu;
    
    public b()
    {
      GMTrace.i(2998289825792L, 22339);
      GMTrace.o(2998289825792L, 22339);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bizchat/BizChatAtSomeoneUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */