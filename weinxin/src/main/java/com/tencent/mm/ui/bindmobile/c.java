package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.bj.g;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.k.a;
import java.util.LinkedList;

public final class c
  extends a
{
  private int[] hAK;
  private String isl;
  private a.a vsC;
  private a.b vsD;
  
  public c(Context paramContext, k.a parama)
  {
    super(paramContext, new b());
    GMTrace.i(3098818904064L, 23088);
    this.vsD = new a.b()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        GMTrace.i(3146600415232L, 23444);
        v.i("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final b localb = (b)c.this.getItem(paramAnonymousInt1);
        if (localb == null)
        {
          v.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramAnonymousString });
          GMTrace.o(3146600415232L, 23444);
          return;
        }
        v.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { localb.toString() });
        if (localb.status == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(c.a(c.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              GMTrace.i(3126870409216L, 23297);
              v.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              b localb = af.FZ().jb(paramAnonymous2String2);
              if (localb != null)
              {
                if (paramAnonymous2Boolean1)
                {
                  localb.username = paramAnonymous2String1;
                  localb.status = 2;
                  localb.hrh = 2;
                  v.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[] { localb.toString() });
                  af.FZ().a(paramAnonymous2String2, localb);
                  c.this.OL();
                  bm.zN().c(26, new Object[0]);
                  GMTrace.o(3126870409216L, 23297);
                }
              }
              else {
                v.w("MicroMsg.MobileFriendAdapter", "cpan mobile friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              GMTrace.o(3126870409216L, 23297);
            }
          });
          paramAnonymousString.sKh = new com.tencent.mm.pluginsdk.ui.applet.a.b()
          {
            public final boolean aFh()
            {
              GMTrace.i(3124588707840L, 23280);
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", localb.getUsername());
              localIntent.putExtra("Contact_Nick", localb.EV());
              localIntent.putExtra("Contact_Scene", 13);
              localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
              localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
              localIntent.putExtra("sayhi_with_jump_to_profile", true);
              d.b(c.b(c.this), "profile", ".ui.SayHiWithSnsPermissionUI", localIntent, 1);
              GMTrace.o(3124588707840L, 23280);
              return true;
            }
          };
          if ((c.c(c.this) instanceof MobileFriendUI)) {
            ((MobileFriendUI)c.e(c.this)).uRg = new MMActivity.a()
            {
              public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                GMTrace.i(3140426399744L, 23398);
                if ((paramAnonymous2Int1 == 1) && (paramAnonymous2Int1 == -1)) {
                  ((MobileFriendUI)c.d(c.this)).b(localb);
                }
                GMTrace.o(3140426399744L, 23398);
              }
            };
          }
          paramAnonymousString.sKp = localb.EQ();
          paramAnonymousString.sKo = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(13));
          paramAnonymousString.b(localb.getUsername(), localLinkedList, false);
        }
        GMTrace.o(3146600415232L, 23444);
      }
    };
    this.uQY = parama;
    this.context = paramContext;
    kl(true);
    GMTrace.o(3098818904064L, 23088);
  }
  
  private static b a(b paramb, Cursor paramCursor)
  {
    GMTrace.i(3099489992704L, 23093);
    b localb = paramb;
    if (paramb == null) {
      localb = new b();
    }
    localb.b(paramCursor);
    GMTrace.o(3099489992704L, 23093);
    return localb;
  }
  
  private static String a(b paramb)
  {
    GMTrace.i(3099624210432L, 23094);
    if (paramb.hAj == 123)
    {
      GMTrace.o(3099624210432L, 23094);
      return "#";
    }
    char c = (char)paramb.hAj;
    GMTrace.o(3099624210432L, 23094);
    return String.valueOf(c);
  }
  
  public final void OL()
  {
    GMTrace.i(3099221557248L, 23091);
    aEP();
    Object localObject = af.FZ();
    String str = this.isl;
    StringBuilder localStringBuilder = new StringBuilder();
    if ((str != null) && (str.length() > 0))
    {
      localStringBuilder.append(" and ( ");
      localStringBuilder.append("addr_upload2.realname like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.username like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.nickname like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
      localStringBuilder.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
    }
    localStringBuilder.append(" and (");
    localStringBuilder.append("addr_upload2.status=1");
    localStringBuilder.append(" or ");
    localStringBuilder.append("addr_upload2.status=2");
    localStringBuilder.append(")");
    ap.yY();
    str = (String)com.tencent.mm.u.c.vr().get(6, null);
    if ((str != null) && (!str.equals(""))) {}
    for (localObject = ((com.tencent.mm.modelfriend.c)localObject).hnp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + localStringBuilder.toString() + " order by showhead", null, 0);; localObject = ((com.tencent.mm.modelfriend.c)localObject).hnp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + localStringBuilder.toString() + " order by showhead", null, 0))
    {
      setCursor((Cursor)localObject);
      this.hAK = new int[getCount()];
      if ((this.vsC != null) && (this.isl != null)) {
        this.vsC.zv(getCursor().getCount());
      }
      notifyDataSetChanged();
      GMTrace.o(3099221557248L, 23091);
      return;
    }
  }
  
  protected final void OM()
  {
    GMTrace.i(3099087339520L, 23090);
    OL();
    GMTrace.o(3099087339520L, 23090);
  }
  
  public final void a(a.a parama)
  {
    GMTrace.i(3098684686336L, 23087);
    this.vsC = parama;
    GMTrace.o(3098684686336L, 23087);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(3099355774976L, 23092);
    b localb = (b)getItem(paramInt);
    label168:
    label200:
    Object localObject;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.ddt, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.ukp = paramInt;
      paramViewGroup.hRY = localb.EQ();
      paramViewGroup.status = localb.status;
      paramViewGroup.jhr.setText(localb.ES());
      paramViewGroup.vsN.setText(this.context.getString(R.l.emO) + localb.EV());
      com.tencent.mm.pluginsdk.ui.a.b.a(paramViewGroup.ioB, localb.getUsername());
      switch (localb.status)
      {
      default: 
        switch (localb.hrh)
        {
        default: 
          localObject = (b)getItem(paramInt - 1);
          if (localObject == null)
          {
            i = -1;
            label220:
            if (paramInt != 0) {
              break label678;
            }
            localObject = a(localb);
            if (!bf.mA((String)localObject)) {
              break label647;
            }
            v.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { localb.getUsername(), Integer.valueOf(paramInt) });
            paramViewGroup.qFP.setVisibility(8);
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      GMTrace.o(3099355774976L, 23092);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      if (localb.hrh == 2)
      {
        paramViewGroup.vsH.setClickable(false);
        paramViewGroup.vsH.setBackgroundDrawable(null);
        paramViewGroup.ioG.setText(R.l.emL);
        paramViewGroup.ioG.setTextColor(this.context.getResources().getColor(R.e.aUz));
        break label168;
      }
      paramViewGroup.vsH.setClickable(true);
      paramViewGroup.vsH.setBackgroundResource(R.g.bcZ);
      paramViewGroup.ioG.setText(R.l.emK);
      paramViewGroup.ioG.setTextColor(this.context.getResources().getColor(R.e.white));
      break label168;
      ap.yY();
      if ((com.tencent.mm.u.c.wR().QX(localb.getUsername())) || (m.xL().equals(localb.getUsername())))
      {
        paramViewGroup.vsH.setClickable(false);
        paramViewGroup.vsH.setBackgroundDrawable(null);
        paramViewGroup.ioG.setText(R.l.emJ);
        paramViewGroup.ioG.setTextColor(this.context.getResources().getColor(R.e.aUz));
        break label168;
      }
      if (localb.hrh == 2)
      {
        paramViewGroup.vsH.setClickable(false);
        paramViewGroup.vsH.setBackgroundDrawable(null);
        paramViewGroup.ioG.setText(R.l.emN);
        paramViewGroup.ioG.setTextColor(this.context.getResources().getColor(R.e.aUz));
        break label168;
      }
      paramViewGroup.vsH.setClickable(true);
      paramViewGroup.vsH.setBackgroundResource(R.g.bcZ);
      paramViewGroup.ioG.setText(R.l.emI);
      paramViewGroup.ioG.setTextColor(this.context.getResources().getColor(R.e.white));
      break label168;
      paramViewGroup.ioG.setVisibility(4);
      paramViewGroup.oDD.setVisibility(0);
      break label200;
      paramViewGroup.ioG.setVisibility(0);
      paramViewGroup.oDD.setVisibility(4);
      break label200;
      i = ((b)localObject).hAj;
      break label220;
      label647:
      paramViewGroup.qFP.setVisibility(0);
      paramViewGroup.qFP.setText((CharSequence)localObject);
      paramViewGroup.qFP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      continue;
      label678:
      if (localb.hAj != i) {}
      for (i = 1;; i = 0)
      {
        localObject = a(localb);
        if ((!bf.mA((String)localObject)) && (i != 0)) {
          break label757;
        }
        v.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { localb.getUsername(), Integer.valueOf(paramInt) });
        paramViewGroup.qFP.setVisibility(8);
        break;
      }
      label757:
      paramViewGroup.qFP.setVisibility(0);
      paramViewGroup.qFP.setText((CharSequence)localObject);
      paramViewGroup.qFP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }
  
  public final void yB(String paramString)
  {
    GMTrace.i(3098953121792L, 23089);
    this.isl = bf.my(paramString.trim());
    aEP();
    OL();
    GMTrace.o(3098953121792L, 23089);
  }
  
  final class a
  {
    String hRY;
    ImageView ioB;
    TextView ioG;
    TextView jhr;
    ProgressBar oDD;
    TextView qFP;
    int status;
    int ukp;
    View vsH;
    TextView vsN;
    
    public a(View paramView)
    {
      GMTrace.i(3125259796480L, 23285);
      this.qFP = ((TextView)paramView.findViewById(R.h.bRQ));
      this.ioB = ((ImageView)paramView.findViewById(R.h.bRP));
      this.jhr = ((TextView)paramView.findViewById(R.h.bRR));
      this.vsN = ((TextView)paramView.findViewById(R.h.bRU));
      this.vsH = paramView.findViewById(R.h.bRO);
      this.ioG = ((TextView)paramView.findViewById(R.h.bRT));
      this.oDD = ((ProgressBar)paramView.findViewById(R.h.bRS));
      this.vsH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3117340950528L, 23226);
          if (c.f(c.this) != null) {
            c.f(c.this).e(c.a.this.ukp, c.a.this.hRY, c.a.this.status);
          }
          GMTrace.o(3117340950528L, 23226);
        }
      });
      GMTrace.o(3125259796480L, 23285);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindmobile/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */