package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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

public final class b
  extends a
{
  private int[] hAK;
  private String isl;
  private a.a vsC;
  private a.b vsD;
  
  public b(Context paramContext, k.a parama)
  {
    super(paramContext, new com.tencent.mm.modelfriend.b());
    GMTrace.i(3115461902336L, 23212);
    this.vsD = new a.b()
    {
      public final void e(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        GMTrace.i(3109824757760L, 23170);
        v.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), paramAnonymousString, Integer.valueOf(paramAnonymousInt2) });
        final com.tencent.mm.modelfriend.b localb = (com.tencent.mm.modelfriend.b)b.this.getItem(paramAnonymousInt1);
        if (localb == null)
        {
          v.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[] { paramAnonymousString });
          GMTrace.o(3109824757760L, 23170);
          return;
        }
        v.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[] { localb.toString() });
        if (localb.status == 1)
        {
          paramAnonymousString = new com.tencent.mm.pluginsdk.ui.applet.a(b.a(b.this), new com.tencent.mm.pluginsdk.ui.applet.a.a()
          {
            public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
            {
              GMTrace.i(3128481021952L, 23309);
              v.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
              com.tencent.mm.modelfriend.b localb = af.FZ().jb(paramAnonymous2String2);
              if (localb != null)
              {
                if (paramAnonymous2Boolean1)
                {
                  localb.username = paramAnonymous2String1;
                  localb.status = 2;
                  localb.hrh = 2;
                  v.d("MicroMsg.MobileFriendAdapter", "f :%s", new Object[] { localb.toString() });
                  af.FZ().a(paramAnonymous2String2, localb);
                  b.this.OL();
                  bm.zN().c(26, new Object[0]);
                  GMTrace.o(3128481021952L, 23309);
                }
              }
              else {
                v.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", new Object[] { paramAnonymous2String2 });
              }
              GMTrace.o(3128481021952L, 23309);
            }
          });
          paramAnonymousString.sKh = new com.tencent.mm.pluginsdk.ui.applet.a.b()
          {
            public final boolean aFh()
            {
              GMTrace.i(3102711218176L, 23117);
              Intent localIntent = new Intent();
              localIntent.putExtra("Contact_User", localb.getUsername());
              localIntent.putExtra("Contact_Nick", localb.EV());
              localIntent.putExtra("Contact_Scene", 13);
              localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
              localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
              localIntent.putExtra("sayhi_with_jump_to_profile", true);
              d.b(b.b(b.this), "profile", ".ui.SayHiWithSnsPermissionUI", localIntent, 1);
              GMTrace.o(3102711218176L, 23117);
              return true;
            }
          };
          if ((b.c(b.this) instanceof MobileFriendUI)) {
            ((MobileFriendUI)b.e(b.this)).uRg = new MMActivity.a()
            {
              public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
              {
                GMTrace.i(3106871967744L, 23148);
                if ((paramAnonymous2Int1 == 1) && (paramAnonymous2Int2 == -1)) {
                  ((MobileFriendUI)b.d(b.this)).b(localb);
                }
                GMTrace.o(3106871967744L, 23148);
              }
            };
          }
          paramAnonymousString.sKp = localb.EQ();
          paramAnonymousString.sKo = false;
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(Integer.valueOf(13));
          paramAnonymousString.b(localb.getUsername(), localLinkedList, false);
        }
        GMTrace.o(3109824757760L, 23170);
      }
    };
    this.uQY = parama;
    this.context = paramContext;
    GMTrace.o(3115461902336L, 23212);
  }
  
  private static com.tencent.mm.modelfriend.b a(com.tencent.mm.modelfriend.b paramb, Cursor paramCursor)
  {
    GMTrace.i(3116132990976L, 23217);
    com.tencent.mm.modelfriend.b localb = paramb;
    if (paramb == null) {
      localb = new com.tencent.mm.modelfriend.b();
    }
    localb.b(paramCursor);
    GMTrace.o(3116132990976L, 23217);
    return localb;
  }
  
  public final void OL()
  {
    GMTrace.i(3115864555520L, 23215);
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
    for (localObject = ((com.tencent.mm.modelfriend.c)localObject).hnp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + localStringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);; localObject = ((com.tencent.mm.modelfriend.c)localObject).hnp.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + localStringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0))
    {
      setCursor((Cursor)localObject);
      this.hAK = new int[getCount()];
      if ((this.vsC != null) && (this.isl != null)) {
        this.vsC.zv(getCursor().getCount());
      }
      notifyDataSetChanged();
      GMTrace.o(3115864555520L, 23215);
      return;
    }
  }
  
  protected final void OM()
  {
    GMTrace.i(3115730337792L, 23214);
    OL();
    GMTrace.o(3115730337792L, 23214);
  }
  
  public final void a(a.a parama)
  {
    GMTrace.i(3115327684608L, 23211);
    this.vsC = parama;
    GMTrace.o(3115327684608L, 23211);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(3115998773248L, 23216);
    com.tencent.mm.modelfriend.b localb = (com.tencent.mm.modelfriend.b)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, R.i.djm, null);
      paramView = new a(localView);
      paramView.hAR = ((TextView)localView.findViewById(R.h.cks));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.ukp = paramInt;
      paramViewGroup.fFN = localb.EQ();
      paramViewGroup.status = localb.status;
      paramViewGroup.hAR.setText(localb.ES());
      switch (localb.status)
      {
      default: 
        label136:
        switch (localb.hrh)
        {
        }
        break;
      }
    }
    for (;;)
    {
      GMTrace.o(3115998773248L, 23216);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      if (localb.hrh == 2)
      {
        paramViewGroup.vsH.setClickable(false);
        paramViewGroup.vsH.setBackgroundDrawable(null);
        paramViewGroup.ioG.setText(R.l.emL);
        paramViewGroup.ioG.setTextColor(this.context.getResources().getColor(R.e.aUz));
        break label136;
      }
      paramViewGroup.vsH.setClickable(true);
      paramViewGroup.vsH.setBackgroundResource(R.g.bcZ);
      paramViewGroup.ioG.setText(R.l.emK);
      paramViewGroup.ioG.setTextColor(this.context.getResources().getColor(R.e.white));
      break label136;
      v.d("MicroMsg.MobileFriendAdapter", "username:%s", new Object[] { localb.getUsername() });
      ap.yY();
      if ((com.tencent.mm.u.c.wR().QX(localb.getUsername())) || (m.xL().equals(localb.getUsername())))
      {
        paramViewGroup.vsH.setClickable(false);
        paramViewGroup.vsH.setBackgroundDrawable(null);
        paramViewGroup.ioG.setText(R.l.emJ);
        paramViewGroup.ioG.setTextColor(this.context.getResources().getColor(R.e.aUz));
        break label136;
      }
      if (localb.hrh == 2)
      {
        paramViewGroup.vsH.setClickable(false);
        paramViewGroup.vsH.setBackgroundDrawable(null);
        paramViewGroup.ioG.setText(R.l.emN);
        paramViewGroup.ioG.setTextColor(this.context.getResources().getColor(R.e.aUz));
        break label136;
      }
      paramViewGroup.vsH.setClickable(true);
      paramViewGroup.vsH.setBackgroundResource(R.g.bcZ);
      paramViewGroup.ioG.setText(R.l.emI);
      paramViewGroup.ioG.setTextColor(this.context.getResources().getColor(R.e.white));
      break label136;
      paramViewGroup.ioG.setVisibility(4);
      paramViewGroup.vsI.setVisibility(0);
      continue;
      paramViewGroup.ioG.setVisibility(0);
      paramViewGroup.vsI.setVisibility(4);
    }
  }
  
  public final void yB(String paramString)
  {
    GMTrace.i(3115596120064L, 23213);
    this.isl = bf.my(paramString.trim());
    aEP();
    OL();
    GMTrace.o(3115596120064L, 23213);
  }
  
  final class a
  {
    String fFN;
    TextView hAR;
    TextView ioG;
    int status;
    int ukp;
    View vsH;
    ProgressBar vsI;
    
    public a(View paramView)
    {
      GMTrace.i(3110898499584L, 23178);
      this.hAR = ((TextView)paramView.findViewById(R.h.cks));
      this.vsH = paramView.findViewById(R.h.ckk);
      this.ioG = ((TextView)paramView.findViewById(R.h.ckv));
      this.vsI = ((ProgressBar)paramView.findViewById(R.h.cku));
      this.vsH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3121904353280L, 23260);
          if (b.f(b.this) != null) {
            b.f(b.this).e(b.a.this.ukp, b.a.this.fFN, b.a.this.status);
          }
          GMTrace.o(3121904353280L, 23260);
        }
      });
      GMTrace.o(3110898499584L, 23178);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindmobile/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */