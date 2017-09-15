package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mm.bg.a;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.aa;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI
  extends MMActivity
{
  private static boolean vtq;
  private String fJC;
  private ListView jZa;
  private q krF;
  private String kuI;
  private String kuJ;
  private p kuK;
  private String mTitle;
  private a vxK;
  
  static
  {
    GMTrace.i(14470550126592L, 107814);
    vtq = false;
    GMTrace.o(14470550126592L, 107814);
  }
  
  public AtSomeoneUI()
  {
    GMTrace.i(2309216010240L, 17205);
    GMTrace.o(2309216010240L, 17205);
  }
  
  protected static String a(q paramq, String paramString)
  {
    GMTrace.i(2310021316608L, 17211);
    if (paramq == null)
    {
      GMTrace.o(2310021316608L, 17211);
      return null;
    }
    paramq = paramq.eK(paramString);
    GMTrace.o(2310021316608L, 17211);
    return paramq;
  }
  
  protected final void KD()
  {
    boolean bool = true;
    GMTrace.i(2309484445696L, 17207);
    qL(this.mTitle);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2154462969856L, 16052);
        AtSomeoneUI.this.setResult(0);
        AtSomeoneUI.this.finish();
        GMTrace.o(2154462969856L, 16052);
        return true;
      }
    });
    this.kuK = new p(true, true);
    this.kuK.wlY = new p.b()
    {
      public final void OE()
      {
        GMTrace.i(2126545682432L, 15844);
        GMTrace.o(2126545682432L, 15844);
      }
      
      public final void OF()
      {
        GMTrace.i(2126679900160L, 15845);
        GMTrace.o(2126679900160L, 15845);
      }
      
      public final void OG()
      {
        GMTrace.i(2126814117888L, 15846);
        GMTrace.o(2126814117888L, 15846);
      }
      
      public final void OH()
      {
        GMTrace.i(16775202734080L, 124985);
        GMTrace.o(16775202734080L, 124985);
      }
      
      public final boolean mQ(String paramAnonymousString)
      {
        GMTrace.i(2126411464704L, 15843);
        GMTrace.o(2126411464704L, 15843);
        return false;
      }
      
      public final void mR(String paramAnonymousString)
      {
        GMTrace.i(2126277246976L, 15842);
        AtSomeoneUI.a locala = AtSomeoneUI.a(AtSomeoneUI.this);
        locala.kuS = paramAnonymousString;
        locala.a(null, null);
        GMTrace.o(2126277246976L, 15842);
      }
    };
    a(this.kuK);
    this.jZa = ((ListView)findViewById(R.h.bzc));
    x localx = new x();
    q localq = this.krF;
    Object localObject1 = null;
    if (!u.mA(this.kuJ))
    {
      localObject1 = this.kuJ.split(",");
      v.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString((Object[])localObject1) });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.krF != null)
      {
        v.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
        localObject2 = u.c(this.krF.DU(), ",").split(",");
      }
    }
    if (localObject2 == null) {
      if (this.krF != null) {
        break label323;
      }
    }
    for (;;)
    {
      v.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", new Object[] { Boolean.valueOf(bool) });
      localObject1 = new LinkedList();
      if (!u.mA(this.kuI)) {
        localObject1 = u.f(this.kuI.split(","));
      }
      ap.yY();
      ay localay = c.wZ().AF("@t.qq.com");
      if (localay != null) {
        ((List)localObject1).add(localay.name);
      }
      this.vxK = new a(this, localx, localq, (String[])localObject2, (List)localObject1);
      this.jZa.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 1;
          GMTrace.i(2240228098048L, 16691);
          Intent localIntent = new Intent();
          if ((paramAnonymousInt == 0) && (AtSomeoneUI.ez()))
          {
            localIntent.putExtra("Select_Conv_User", AtSomeoneUI.this.getString(R.l.dJd, new Object[] { "" }));
            localIntent.putExtra("select_raw_user_name", "notify@all");
            AtSomeoneUI.this.setResult(-1, localIntent);
            AtSomeoneUI.this.finish();
            GMTrace.o(2240228098048L, 16691);
            return;
          }
          paramAnonymousAdapterView = AtSomeoneUI.a(AtSomeoneUI.this);
          if (AtSomeoneUI.ez()) {}
          for (;;)
          {
            x localx = (x)paramAnonymousAdapterView.getItem(paramAnonymousInt - i);
            paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.b(AtSomeoneUI.this), localx.field_username);
            paramAnonymousAdapterView = paramAnonymousView;
            if (u.mA(paramAnonymousView)) {
              paramAnonymousAdapterView = localx.tK();
            }
            localIntent.putExtra("select_raw_user_name", localx.field_username);
            localIntent.putExtra("Select_Conv_User", paramAnonymousAdapterView);
            break;
            i = 0;
          }
        }
      });
      this.jZa.setAdapter(this.vxK);
      GMTrace.o(2309484445696L, 17207);
      return;
      label323:
      bool = false;
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2309887098880L, 17210);
    int i = R.i.cUJ;
    GMTrace.o(2309887098880L, 17210);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2309350227968L, 17206);
    super.onCreate(paramBundle);
    this.kuI = getIntent().getStringExtra("Block_list");
    this.kuJ = getIntent().getStringExtra("Chatroom_member_list");
    this.fJC = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    ap.yY();
    this.krF = c.xa().fV(this.fJC);
    if ((this.krF != null) && (this.krF.field_roomowner.equals(m.xL()))) {
      vtq = false;
    }
    KD();
    GMTrace.o(2309350227968L, 17206);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2309752881152L, 17209);
    this.vxK.aEP();
    super.onDestroy();
    GMTrace.o(2309752881152L, 17209);
  }
  
  protected void onPause()
  {
    GMTrace.i(2309618663424L, 17208);
    super.onPause();
    if (this.kuK != null) {
      this.kuK.bZF();
    }
    GMTrace.o(2309618663424L, 17208);
  }
  
  private static final class a
    extends k<x>
  {
    private List<String> jzO;
    private q krF;
    String kuS;
    private String[] vts;
    private Bitmap vtt;
    
    public a(Context paramContext, x paramx, q paramq, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramx);
      GMTrace.i(2277003755520L, 16965);
      this.krF = paramq;
      this.vts = paramArrayOfString;
      this.jzO = paramList;
      this.vtt = d.t(paramContext.getResources().getDrawable(R.k.dtN));
      GMTrace.o(2277003755520L, 16965);
    }
    
    public final void OL()
    {
      GMTrace.i(2277272190976L, 16967);
      ap.yY();
      ar localar = c.wR();
      String[] arrayOfString1 = this.vts;
      String str1 = this.kuS;
      String str2 = this.kuS;
      Object localObject;
      if ((this.krF == null) || (str2 == null) || (this.vts == null))
      {
        localObject = null;
        setCursor(localar.a(arrayOfString1, "@all.chatroom", str1, (List)localObject, this.jzO));
        super.notifyDataSetChanged();
        GMTrace.o(2277272190976L, 16967);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString2 = this.vts;
      int j = arrayOfString2.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = arrayOfString2[i];
        String str3 = this.krF.eK((String)localObject);
        if ((str3 != null) && (str3.contains(str2))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    
    protected final void OM()
    {
      GMTrace.i(2277406408704L, 16968);
      aEP();
      OL();
      GMTrace.o(2277406408704L, 16968);
    }
    
    protected final int aBO()
    {
      GMTrace.i(14469342167040L, 107805);
      if (AtSomeoneUI.ez())
      {
        GMTrace.o(14469342167040L, 107805);
        return 1;
      }
      GMTrace.o(14469342167040L, 107805);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(2277137973248L, 16966);
      AtSomeoneUI.b localb;
      if (paramView == null)
      {
        paramViewGroup = View.inflate(this.context, R.i.cUI, null);
        localb = new AtSomeoneUI.b();
        localb.kvj = ((MaskLayout)paramViewGroup.findViewById(R.h.bqi));
        localb.jXN = ((TextView)paramViewGroup.findViewById(R.h.bqj));
        localb.vtu = ((ImageView)paramViewGroup.findViewById(R.h.content));
        paramViewGroup.setTag(localb);
      }
      while ((paramInt == 0) && (AtSomeoneUI.ez()))
      {
        localb.vtu.setImageBitmap(this.vtt);
        localb.jXN.setText(this.context.getResources().getString(R.l.dJd, new Object[] { "@" }));
        GMTrace.o(2277137973248L, 16966);
        return paramViewGroup;
        localb = (AtSomeoneUI.b)paramView.getTag();
        paramViewGroup = paramView;
      }
      int i;
      x localx;
      Object localObject;
      if (AtSomeoneUI.ez())
      {
        i = 1;
        localx = (x)getItem(paramInt - i);
        paramView = localb.jXN;
        localObject = this.context;
        if (o.fE(localx.field_username)) {
          break label365;
        }
        paramInt = R.e.aVa;
        label211:
        paramView.setTextColor(a.S((Context)localObject, paramInt));
        a.b.a((ImageView)localb.kvj.view, localx.field_username);
        if (localx.field_verifyFlag == 0) {
          break label394;
        }
        if (ag.a.hlC == null) {
          break label383;
        }
        paramView = ag.a.hlC.eZ(localx.field_verifyFlag);
        if (paramView == null) {
          break label372;
        }
        paramView = l.il(paramView);
        localb.kvj.d(paramView, MaskLayout.a.vmg);
        label289:
        if (u.mA(localx.field_conRemark)) {
          break label405;
        }
      }
      label365:
      label372:
      label383:
      label394:
      label405:
      for (paramView = localx.field_conRemark;; paramView = AtSomeoneUI.a(this.krF, localx.field_username))
      {
        localObject = paramView;
        if (u.mA(paramView)) {
          localObject = localx.tK();
        }
        localb.jXN.setText(h.b(this.context, (CharSequence)localObject, localb.jXN.getTextSize()));
        GMTrace.o(2277137973248L, 16966);
        return paramViewGroup;
        i = 0;
        break;
        paramInt = R.e.aVb;
        break label211;
        localb.kvj.bSx();
        break label289;
        localb.kvj.bSx();
        break label289;
        localb.kvj.bSx();
        break label289;
      }
    }
    
    public final boolean nF(int paramInt)
    {
      GMTrace.i(14469476384768L, 107806);
      GMTrace.o(14469476384768L, 107806);
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
      GMTrace.i(2267071643648L, 16891);
      GMTrace.o(2267071643648L, 16891);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/AtSomeoneUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */