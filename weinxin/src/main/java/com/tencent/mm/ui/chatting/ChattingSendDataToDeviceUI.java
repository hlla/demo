package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cq;
import com.tencent.mm.e.a.db;
import com.tencent.mm.e.a.db.b;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.dd.b;
import com.tencent.mm.e.a.dt;
import com.tencent.mm.e.a.dt.a;
import com.tencent.mm.e.a.dw;
import com.tencent.mm.e.a.dw.b;
import com.tencent.mm.e.a.dx;
import com.tencent.mm.e.a.dx.a;
import com.tencent.mm.e.a.ej;
import com.tencent.mm.e.a.ej.a;
import com.tencent.mm.e.a.hm;
import com.tencent.mm.e.a.hm.b;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXLocationObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.c.bey;
import com.tencent.mm.protocal.c.mj;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.Sort3rdAppUI;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class ChattingSendDataToDeviceUI
  extends MMActivity
{
  boolean fHE;
  private f.a fSK;
  String filePath;
  private long gLu;
  String iAx;
  private String laI;
  private au qUw;
  private HorizontalListView sPa;
  private HorizontalListView vER;
  private c vES;
  private a vET;
  private int vEU;
  private String vEV;
  private RelativeLayout vEW;
  private RelativeLayout vEX;
  private TextView vEY;
  private Boolean vEZ;
  private b vFa;
  private List<c> vFb;
  private List<com.tencent.mm.pluginsdk.model.app.f> vFc;
  private long vFd;
  private boolean vFe;
  boolean vFf;
  boolean vFg;
  int vFh;
  int vFi;
  private HashMap<String, View> vFj;
  HashMap<String, c> vFk;
  Map<Integer, View> vFl;
  Map<String, Integer> vFm;
  WXMediaMessage vFn;
  private com.tencent.mm.sdk.b.c vFo;
  private com.tencent.mm.sdk.b.c vFp;
  private boolean vvA;
  boolean vwp;
  
  public ChattingSendDataToDeviceUI()
  {
    GMTrace.i(2310960840704L, 17218);
    this.vEV = "";
    this.vEZ = Boolean.valueOf(false);
    this.vFb = new ArrayList();
    this.vFc = new ArrayList();
    this.vFd = 0L;
    this.vFe = true;
    this.fHE = false;
    this.vFf = false;
    this.vFg = true;
    this.vFh = 2;
    this.vFi = -1;
    this.vFj = new HashMap();
    this.vFk = new HashMap();
    this.vFl = new HashMap();
    this.vFm = new HashMap();
    this.vFn = null;
    this.filePath = null;
    this.iAx = null;
    this.vwp = false;
    this.vFo = new com.tencent.mm.sdk.b.c() {};
    this.vFp = new com.tencent.mm.sdk.b.c() {};
    GMTrace.o(2310960840704L, 17218);
  }
  
  private static boolean a(c paramc, long paramLong)
  {
    boolean bool = true;
    GMTrace.i(2312303017984L, 17228);
    if (paramLong == -1L)
    {
      GMTrace.o(2312303017984L, 17228);
      return false;
    }
    String str1 = paramc.fHD;
    ap.yY();
    Object localObject = com.tencent.mm.u.c.wT().cA(paramLong);
    if ((((ce)localObject).field_msgId == 0L) || (str1 == null))
    {
      GMTrace.o(2312303017984L, 17228);
      return false;
    }
    int i = ((ce)localObject).field_type;
    String str2 = ((ce)localObject).field_content;
    if (((au)localObject).axH())
    {
      localObject = f.a.ek(str2);
      if (localObject == null)
      {
        v.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        GMTrace.o(2312303017984L, 17228);
        return false;
      }
      if (((f.a)localObject).type == 3) {
        if (!str1.contains("wxmsg_music")) {
          break label198;
        }
      }
    }
    for (;;)
    {
      GMTrace.o(2312303017984L, 17228);
      return bool;
      if (((f.a)localObject).type == 4) {
        bool = false;
      } else if (((f.a)localObject).type == 6)
      {
        if (str1.contains("wxmsg_file")) {}
      }
      else {
        label198:
        label269:
        label289:
        do
        {
          do
          {
            do
            {
              do
              {
                bool = false;
                break;
                if (((f.a)localObject).type == 5)
                {
                  bool = a(((f.a)localObject).url, paramc);
                  break;
                }
              } while ((((f.a)localObject).type != 2) || (!str1.contains("wxmsg_image")));
              break;
              if (i != 3) {
                break label269;
              }
            } while (!str1.contains("wxmsg_image"));
            break;
            if (i != 48) {
              break label289;
            }
          } while (!str1.contains("wxmsg_poi"));
          break;
        } while ((i != 62) || (!str1.contains("wxmsg_video")));
      }
    }
  }
  
  private static boolean a(c paramc, String paramString)
  {
    boolean bool = true;
    GMTrace.i(2312034582528L, 17226);
    if (paramString == null)
    {
      GMTrace.o(2312034582528L, 17226);
      return false;
    }
    Object localObject = new hm();
    ((hm)localObject).fMK.fGE = paramString;
    com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    paramString = ((hm)localObject).fML.fMM;
    int i = paramString.udP.trf;
    v.i("MicroMsg.ChattingSendDataToDeviceUI", "isNeedToShowSnsInfo contentStyle %d", new Object[] { Integer.valueOf(i) });
    localObject = paramc.fHD;
    if (localObject == null)
    {
      v.e("MicroMsg.ChattingSendDataToDeviceUI", "ability is null");
      GMTrace.o(2312034582528L, 17226);
      return false;
    }
    if (i == 1) {
      if (!((String)localObject).contains("wxmsg_image")) {
        break label162;
      }
    }
    for (;;)
    {
      GMTrace.o(2312034582528L, 17226);
      return bool;
      if (i == 4)
      {
        if (((String)localObject).contains("wxmsg_music")) {}
      }
      else
      {
        label162:
        label187:
        do
        {
          do
          {
            bool = false;
            break;
            if (i != 15) {
              break label187;
            }
          } while (!((String)localObject).contains("wxmsg_video"));
          break;
        } while (i != 3);
        bool = a(paramString.udP.mrm, paramc);
      }
    }
  }
  
  private static boolean a(String paramString, c paramc)
  {
    bool2 = false;
    GMTrace.i(2311900364800L, 17225);
    Object localObject = paramc.fHD;
    paramc = paramc.vFC;
    paramString = Uri.parse(paramString).getHost();
    bool1 = bool2;
    if (paramc != null)
    {
      bool1 = bool2;
      if (paramc.length() > 0)
      {
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (!((String)localObject).contains("wxmsg_url")) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramc).getJSONArray("wxmsg_url");
        int j = ((JSONArray)localObject).length();
        i = 0;
        bool1 = bool2;
        if (i < j)
        {
          bool1 = ((JSONArray)localObject).getString(i).equals(paramString);
          if (!bool1) {
            continue;
          }
          bool1 = true;
        }
      }
      catch (JSONException paramString)
      {
        int i;
        v.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", paramString, paramc, new Object[0]);
        bool1 = bool2;
        continue;
      }
      GMTrace.o(2311900364800L, 17225);
      return bool1;
      i += 1;
    }
  }
  
  private void bUB()
  {
    GMTrace.i(2311631929344L, 17223);
    if ((this.vES == null) || (this.vFd == 0L))
    {
      if (this.vES == null) {}
      for (boolean bool = true;; bool = false)
      {
        v.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.vFd) });
        if (this.vEX != null) {
          this.vEX.setVisibility(8);
        }
        GMTrace.o(2311631929344L, 17223);
        return;
      }
    }
    this.vFc = com.tencent.mm.pluginsdk.model.app.g.b(this, this.vFd, false);
    if ((!com.tencent.mm.pluginsdk.model.app.g.m(this, this.vFd)) && (this.vEX != null)) {
      this.vEX.setVisibility(8);
    }
    ArrayList localArrayList = new ArrayList();
    final Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((this.vFc != null) && (this.vFc.size() > 0))
    {
      localObject1 = an.bDd().ef(this.vFd);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        Collections.sort(this.vFc, new Comparator() {});
      }
      localObject1 = this.vFc.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.pluginsdk.model.app.f)((Iterator)localObject1).next();
        localObject3 = new di();
        ((di)localObject3).appId = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appId;
        ((di)localObject3).gMN = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName;
        ((di)localObject3).iconUrl = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appIconUrl;
        localArrayList.add(localObject3);
      }
    }
    if (this.vFn == null)
    {
      localObject2 = null;
      localObject3 = null;
      switch (this.qUw.field_type)
      {
      default: 
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      this.vFn = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
      this.vFn.sdkVer = 620757000;
      if ((this.iAx != null) && (this.filePath != null) && (localObject1 != null) && ((localObject1 instanceof WXFileObject))) {
        this.vwp = true;
      }
      label411:
      this.vES.vwp = this.vwp;
      this.vES.ao(localArrayList);
      this.vES.notifyDataSetChanged();
      GMTrace.o(2311631929344L, 17223);
      return;
      localObject1 = localObject3;
      if (this.fSK != null) {
        if (this.fSK.type == 3)
        {
          localObject1 = new WXMusicObject();
          ((WXMusicObject)localObject1).musicUrl = this.fSK.url;
          ((WXMusicObject)localObject1).musicDataUrl = this.fSK.hhx;
          ((WXMusicObject)localObject1).musicLowBandUrl = this.fSK.hhf;
          ((WXMusicObject)localObject1).musicLowBandDataUrl = this.fSK.hhy;
        }
        else if (this.fSK.type == 4)
        {
          localObject1 = new WXVideoObject();
          ((WXVideoObject)localObject1).videoUrl = this.fSK.url;
          ((WXVideoObject)localObject1).videoLowBandUrl = this.fSK.hhy;
        }
        else if (this.fSK.type == 5)
        {
          localObject1 = new WXWebpageObject(this.fSK.url);
        }
        else
        {
          if (this.fSK.type == 6)
          {
            localObject3 = an.abF().LV(this.fSK.fCN);
            if (localObject3 != null)
            {
              v.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath });
              localObject1 = new WXFileObject(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath);
              this.filePath = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath;
              this.iAx = this.fSK.hhh;
            }
            while (q.Mk(this.filePath) != null)
            {
              com.tencent.mm.ui.base.g.bk(this, getString(R.l.dVl));
              finish();
              break label411;
              v.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
              localObject1 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (this.fSK.type == 2)
          {
            localObject1 = new WXImageObject();
            localObject2 = n.GT().n(this.qUw);
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = n.GT().jv(((d)localObject2).hEH);
              if (bf.mA(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = n.GT().jv(((d)localObject2).hEJ);
              }
            }
            this.filePath = ((WXImageObject)localObject1).imagePath;
            this.iAx = this.fSK.hhh;
            v.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            localObject1 = new WXTextObject(this.qUw.field_content);
            continue;
            localObject1 = new WXImageObject();
            localObject2 = n.GT().n(this.qUw);
            int i;
            if (localObject2 != null)
            {
              ((WXImageObject)localObject1).imagePath = n.GT().jv(((d)localObject2).hEH);
              if (bf.mA(((WXImageObject)localObject1).imagePath)) {
                ((WXImageObject)localObject1).imagePath = n.GT().jv(((d)localObject2).hEJ);
              }
              if (!bf.mA(((WXImageObject)localObject1).imagePath))
              {
                this.filePath = ((WXImageObject)localObject1).imagePath;
                i = ((WXImageObject)localObject1).imagePath.lastIndexOf(".");
                if ((i >= 0) && (i < ((WXImageObject)localObject1).imagePath.length() - 1)) {
                  this.iAx = ((WXImageObject)localObject1).imagePath.substring(i + 1);
                }
              }
            }
            v.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", new Object[] { ((WXImageObject)localObject1).imagePath });
            continue;
            ap.yY();
            localObject1 = com.tencent.mm.u.c.wT().Au(this.qUw.field_content);
            localObject1 = new WXLocationObject(((au.b)localObject1).mZn, ((au.b)localObject1).mZo);
            continue;
            localObject2 = new WXVideoObject();
            com.tencent.mm.modelvideo.o.KW();
            localObject3 = s.lw(this.qUw.field_imgPath);
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              ((WXVideoObject)localObject2).videoUrl = ((String)localObject3);
              this.filePath = ((String)localObject3);
              i = ((String)localObject3).lastIndexOf(".");
              localObject1 = localObject2;
              if (i >= 0)
              {
                localObject1 = localObject2;
                if (i < ((String)localObject3).length() - 1)
                {
                  this.iAx = ((String)localObject3).substring(i + 1);
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void bUC()
  {
    GMTrace.i(2311766147072L, 17224);
    Object localObject1 = new db();
    Object localObject2;
    int i;
    if (this.fHE)
    {
      localObject2 = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
      ((db)localObject1).fGB.fGE = this.laI;
      ((db)localObject1).fGB.fGF = ((String)localObject2);
      ((db)localObject1).fGB.fGG = i;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject1);
      if (!((db)localObject1).fGC.fGl) {
        break label436;
      }
      localObject1 = ((db)localObject1).fGC.fGH;
      int j = ((List)localObject1).size();
      i = 0;
      label116:
      if (i >= j) {
        break label373;
      }
      localObject2 = new c();
      ((c)localObject2).fGc = ((String)((Map)((List)localObject1).get(i)).get("deviceType"));
      ((c)localObject2).deviceID = ((String)((Map)((List)localObject1).get(i)).get("deviceID"));
      ((c)localObject2).gMN = ((String)((Map)((List)localObject1).get(i)).get("displayName"));
      ((c)localObject2).iconUrl = ((String)((Map)((List)localObject1).get(i)).get("iconUrl"));
      ((c)localObject2).fHD = ((String)((Map)((List)localObject1).get(i)).get("ability"));
      ((c)localObject2).vFC = ((String)((Map)((List)localObject1).get(i)).get("abilityInf"));
      if ((!this.fHE) || (!a((c)localObject2, this.laI))) {
        break label339;
      }
      this.vFb.add(localObject2);
    }
    for (;;)
    {
      i += 1;
      break label116;
      ((db)localObject1).fGB.fGD = this.gLu;
      break;
      label339:
      if ((!this.fHE) && (a((c)localObject2, this.gLu))) {
        this.vFb.add(localObject2);
      }
    }
    label373:
    if (this.vFb.size() > 0)
    {
      v.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
      this.vET.ao(this.vFb);
      if (this.vET.getCount() > 0)
      {
        this.vEY.setText(R.l.dSV);
        this.vFe = false;
      }
      this.vET.notifyDataSetChanged();
    }
    label436:
    GMTrace.o(2311766147072L, 17224);
  }
  
  private void lQ(int paramInt)
  {
    GMTrace.i(2311229276160L, 17220);
    if (this.fHE)
    {
      com.tencent.mm.plugin.report.service.g.oSF.i(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vFi), "", Integer.valueOf(2), Integer.valueOf(this.vFh) });
      GMTrace.o(2311229276160L, 17220);
      return;
    }
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.oSF;
    int i = this.vFi;
    long l = this.gLu;
    String str2 = "";
    ap.yY();
    Object localObject = com.tencent.mm.u.c.wT().cA(l);
    String str1;
    if (((ce)localObject).field_msgId == 0L) {
      str1 = "";
    }
    for (;;)
    {
      localg.i(13197, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), str1, Integer.valueOf(1), Integer.valueOf(this.vFh) });
      GMTrace.o(2311229276160L, 17220);
      return;
      String str3 = ((ce)localObject).field_content;
      str1 = str2;
      if (((ce)localObject).field_type == 49)
      {
        localObject = f.a.ek(str3);
        str1 = str2;
        if (localObject != null)
        {
          str1 = str2;
          if (((f.a)localObject).type == 6) {
            str1 = ((f.a)localObject).hhh;
          }
        }
      }
    }
  }
  
  public final b bUD()
  {
    GMTrace.i(2312974106624L, 17233);
    if (this.vFa == null) {
      this.vFa = new b();
    }
    b localb = this.vFa;
    GMTrace.o(2312974106624L, 17233);
    return localb;
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2311363493888L, 17221);
    int i = R.i.cYE;
    GMTrace.o(2311363493888L, 17221);
    return i;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(2312705671168L, 17231);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, R.l.ebH, R.l.ebI, 1);
    GMTrace.o(2312705671168L, 17231);
  }
  
  public void onBackPressed()
  {
    GMTrace.i(2312168800256L, 17227);
    if (this.vFj.size() > 0)
    {
      h.a locala = new h.a(this);
      locala.zS(R.l.dVo);
      locala.zU(R.l.dVq).a(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2520340496384L, 18778);
          paramAnonymousDialogInterface = ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).keySet().iterator();
          while (paramAnonymousDialogInterface.hasNext())
          {
            String str = (String)paramAnonymousDialogInterface.next();
            cq localcq = new cq();
            localcq.fFY.fwB = str;
            com.tencent.mm.sdk.b.a.uql.m(localcq);
          }
          ChattingSendDataToDeviceUI.this.finish();
          GMTrace.o(2520340496384L, 18778);
        }
      });
      locala.zV(R.l.dVp).b(new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(2170166444032L, 16169);
          paramAnonymousDialogInterface.dismiss();
          GMTrace.o(2170166444032L, 16169);
        }
      });
      locala.WD().show();
      GMTrace.o(2312168800256L, 17227);
      return;
    }
    super.onBackPressed();
    GMTrace.o(2312168800256L, 17227);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(2311497711616L, 17222);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = new db();
    if (this.fHE)
    {
      String str = getIntent().getExtras().getString("sns_send_data_ui_image_path");
      int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
      paramConfiguration.fGB.fGE = this.laI;
      paramConfiguration.fGB.fGF = str;
      paramConfiguration.fGB.fGG = i;
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.uql.m(paramConfiguration);
      if ((paramConfiguration.fGC.fGl) && (this.vFb.size() > 0))
      {
        v.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[] { Integer.valueOf(this.vFb.size()) });
        this.vET.ao(this.vFb);
        if (this.vET.getCount() > 0)
        {
          this.vEY.setText(R.l.dSV);
          this.vFe = false;
        }
        this.vET.notifyDataSetChanged();
      }
      GMTrace.o(2311497711616L, 17222);
      return;
      paramConfiguration.fGB.fGD = this.gLu;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 6;
    GMTrace.i(2311095058432L, 17219);
    super.onCreate(paramBundle);
    this.fHE = getIntent().getExtras().getBoolean("sns_send_data_ui_activity", false);
    v.i("MicroMsg.ChattingSendDataToDeviceUI", "isSnsMsg:" + this.fHE);
    if (!this.fHE)
    {
      this.gLu = getIntent().getExtras().getLong("Retr_Msg_Id");
      if (this.gLu != -1L)
      {
        ap.yY();
        this.qUw = com.tencent.mm.u.c.wT().cA(this.gLu);
        if ((this.qUw != null) && (this.qUw.field_msgId != 0L)) {
          break label549;
        }
      }
    }
    this.vFh = getIntent().getExtras().getInt("exdevice_open_scene_type", 2);
    this.vFf = false;
    setFinishOnTouchOutside(true);
    this.vFb.clear();
    this.vFk.clear();
    this.vEW = ((RelativeLayout)findViewById(R.h.cnN));
    paramBundle = new dd();
    label261:
    Object localObject;
    if (this.fHE)
    {
      this.laI = getIntent().getExtras().getString("sns_local_id");
      if (this.laI != null)
      {
        paramBundle.fGN.fGE = this.laI;
        v.i("MicroMsg.ChattingSendDataToDeviceUI", "mSnsLocalId: %s", new Object[] { this.laI });
      }
      com.tencent.mm.sdk.b.a.uql.m(paramBundle);
      if (!paramBundle.fGO.fGl) {
        break label1248;
      }
      this.vEZ = Boolean.valueOf(true);
      com.tencent.mm.sdk.b.a.uql.b(this.vFo);
      com.tencent.mm.sdk.b.a.uql.b(this.vFp);
      this.vEW.setVisibility(0);
      this.sPa = ((HorizontalListView)findViewById(R.h.cbq));
      this.vEY = ((TextView)findViewById(R.h.bqy));
      this.vEY.setText(R.l.dVk);
      this.vET = new a(this);
      this.sPa.setAdapter(this.vET);
      this.sPa.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(2251502387200L, 16775);
          ChattingSendDataToDeviceUI.this.vFf = true;
          ChattingSendDataToDeviceUI.c localc = ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).AO(paramAnonymousInt);
          String str1 = localc.fGc;
          paramAnonymousAdapterView = localc.deviceID;
          String str2 = localc.fHD;
          try
          {
            if (ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).get(paramAnonymousAdapterView) != null)
            {
              v.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
              paramAnonymousView = new cq();
              paramAnonymousView.fFY.fwB = paramAnonymousAdapterView;
              com.tencent.mm.sdk.b.a.uql.m(paramAnonymousView);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_cancel", paramAnonymousAdapterView, 0);
              localc.fHI = "send_data_cancel";
              ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).remove(paramAnonymousAdapterView);
              paramAnonymousAdapterView = (eo)((View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramAnonymousInt))).getTag();
              paramAnonymousAdapterView.vFx.setText(ChattingSendDataToDeviceUI.this.getText(R.l.dVn));
              paramAnonymousAdapterView.vFx.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.aVL));
              paramAnonymousAdapterView.vMK.setVisibility(8);
              paramAnonymousAdapterView.vMK.setProgress(0);
              GMTrace.o(2251502387200L, 16775);
              return;
            }
            localc.fHI = "send_data_sending";
            ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(localc.deviceID, localc);
            ChattingSendDataToDeviceUI.b(ChattingSendDataToDeviceUI.this).put(paramAnonymousAdapterView, paramAnonymousView);
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", paramAnonymousAdapterView, 1);
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 3);
            paramAnonymousView = new dw();
            paramAnonymousView.fHB.fwB = paramAnonymousAdapterView;
            paramAnonymousView.fHB.fGc = str1;
            paramAnonymousView.fHB.data = ChattingSendDataToDeviceUI.e(ChattingSendDataToDeviceUI.this);
            paramAnonymousView.fHB.fHD = str2;
            if (ChattingSendDataToDeviceUI.this.fHE)
            {
              paramAnonymousView.fHB.fGE = ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this);
              paramAnonymousView.fHB.fHE = ChattingSendDataToDeviceUI.this.fHE;
            }
            for (;;)
            {
              com.tencent.mm.sdk.b.a.uql.m(paramAnonymousView);
              if (!paramAnonymousView.fHC.fHF)
              {
                ChattingSendDataToDeviceUI.Tv("send_data_failed");
                v.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
              }
              GMTrace.o(2251502387200L, 16775);
              return;
              paramAnonymousView.fHB.fGD = ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this);
            }
            return;
          }
          catch (Exception paramAnonymousAdapterView)
          {
            ChattingSendDataToDeviceUI.Tv("send_data_failed");
            v.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[] { paramAnonymousAdapterView });
            GMTrace.o(2251502387200L, 16775);
          }
        }
      });
      bUC();
      if (!this.fHE) {
        break label1058;
      }
      paramBundle = this.laI;
      if (paramBundle == null) {
        break label1053;
      }
      localObject = new hm();
      ((hm)localObject).fMK.fGE = paramBundle;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      i = ((hm)localObject).fML.fMM.udP.trf;
      if (i != 1) {
        break label1021;
      }
      i = 3;
      label463:
      this.vFi = i;
      lQ(1);
    }
    for (;;)
    {
      this.vEX = ((RelativeLayout)findViewById(R.h.bpP));
      this.vER = ((HorizontalListView)findViewById(R.h.bpy));
      this.vES = new c(this);
      this.vER.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(2231369728000L, 16625);
          v.i("MicroMsg.ChattingSendDataToDeviceUI", "onItemClick(%d).", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 1)
          {
            paramAnonymousAdapterView = new Intent(ChattingSendDataToDeviceUI.this, Sort3rdAppUI.class);
            paramAnonymousAdapterView.addFlags(67108864);
            paramAnonymousAdapterView.putExtra("KFlag", ChattingSendDataToDeviceUI.h(ChattingSendDataToDeviceUI.this));
            ChattingSendDataToDeviceUI.this.startActivity(paramAnonymousAdapterView);
            GMTrace.o(2231369728000L, 16625);
            return;
          }
          if ((ChattingSendDataToDeviceUI.this.vwp) && (paramAnonymousInt == paramAnonymousAdapterView.getAdapter().getCount() - 2))
          {
            if ((ChattingSendDataToDeviceUI.this.filePath == null) || (ChattingSendDataToDeviceUI.this.iAx == null))
            {
              com.tencent.mm.ui.base.g.bk(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(R.l.ebH));
              GMTrace.o(2231369728000L, 16625);
              return;
            }
            com.tencent.mm.pluginsdk.ui.tools.a.b(ChattingSendDataToDeviceUI.this, ChattingSendDataToDeviceUI.this.filePath, ChattingSendDataToDeviceUI.this.iAx.toLowerCase(), 1);
            GMTrace.o(2231369728000L, 16625);
            return;
          }
          if ((paramAnonymousInt >= 0) && (paramAnonymousInt < paramAnonymousAdapterView.getAdapter().getCount() - 1))
          {
            paramAnonymousAdapterView = (com.tencent.mm.pluginsdk.model.app.f)ChattingSendDataToDeviceUI.i(ChattingSendDataToDeviceUI.this).get(paramAnonymousInt);
            if (!com.tencent.mm.pluginsdk.model.app.g.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView))
            {
              com.tencent.mm.ui.base.g.bk(ChattingSendDataToDeviceUI.this.getBaseContext(), ChattingSendDataToDeviceUI.this.getString(R.l.dVm));
              paramAnonymousAdapterView.field_status = 4;
              an.aRk().a(paramAnonymousAdapterView, new String[0]);
              ChattingSendDataToDeviceUI.j(ChattingSendDataToDeviceUI.this);
              GMTrace.o(2231369728000L, 16625);
              return;
            }
            com.tencent.mm.bk.a.post(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(17888673005568L, 133281);
                com.tencent.mm.pluginsdk.model.app.g.a(ChattingSendDataToDeviceUI.this.getBaseContext(), paramAnonymousAdapterView.field_packageName, ChattingSendDataToDeviceUI.this.vFn, paramAnonymousAdapterView.field_appId, paramAnonymousAdapterView.field_openId, 0, null, null);
                GMTrace.o(17888673005568L, 133281);
              }
            });
          }
          GMTrace.o(2231369728000L, 16625);
        }
      });
      this.vER.setAdapter(this.vES);
      GMTrace.o(2311095058432L, 17219);
      return;
      label549:
      this.vEU = this.qUw.field_type;
      this.vvA = com.tencent.mm.u.o.dH(this.qUw.field_talker);
      this.vEV = this.qUw.field_content;
      int j;
      if ((this.vvA) && (this.qUw.field_isSend == 0))
      {
        localObject = this.qUw.field_content;
        j = this.qUw.field_isSend;
        paramBundle = (Bundle)localObject;
        if (this.vvA)
        {
          paramBundle = (Bundle)localObject;
          if (localObject != null)
          {
            paramBundle = (Bundle)localObject;
            if (j == 0) {
              paramBundle = ay.gj((String)localObject);
            }
          }
        }
        this.vEV = paramBundle;
      }
      if (this.qUw.field_type == 49)
      {
        this.fSK = f.a.ek(this.vEV);
        if (this.fSK == null)
        {
          v.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams content is null");
          break;
        }
        if (this.fSK.type == 3) {
          this.vFd = 16L;
        }
      }
      for (;;)
      {
        v.i("MicroMsg.ChattingSendDataToDeviceUI", "contentFlag: %s", new Object[] { Long.valueOf(this.vFd) });
        break;
        if (this.fSK.type == 4)
        {
          this.vFd = 8L;
        }
        else if (this.fSK.type == 5)
        {
          this.vFd = 32L;
        }
        else
        {
          if (this.fSK.type == 6)
          {
            paramBundle = b.a.LA(this.fSK.hhh);
            if (paramBundle == null)
            {
              v.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams TYPE_FILE getContentTypeFlag null");
              break;
            }
            this.vFd = paramBundle.longValue();
            continue;
          }
          if (this.fSK.type == 2)
          {
            this.vFd = 2L;
            paramBundle = n.GT().n(this.qUw);
            if (paramBundle != null) {
              this.vEV = paramBundle.hER;
            }
          }
          else
          {
            v.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams APPMSG not support type");
            break;
            if (this.qUw.field_type == 3)
            {
              paramBundle = n.GT().n(this.qUw);
              if (paramBundle != null) {
                this.vEV = paramBundle.hER;
              }
            }
            for (;;)
            {
              paramBundle = b.a.LA(this.vEU);
              if (paramBundle != null) {
                break label996;
              }
              v.e("MicroMsg.ChattingSendDataToDeviceUI", "initParams not appmsg getContentTypeFlag null");
              break;
              if (this.qUw.field_type == 43)
              {
                paramBundle = com.tencent.mm.modelvideo.o.KW().lt(this.qUw.field_imgPath);
                if (paramBundle != null) {
                  this.vEV = paramBundle.Li();
                }
              }
            }
            label996:
            this.vFd = paramBundle.longValue();
          }
        }
      }
      paramBundle.fGN.fGD = this.gLu;
      break label261;
      label1021:
      if (i == 4)
      {
        i = 1;
        break label463;
      }
      if (i == 15)
      {
        i = 6;
        break label463;
      }
      if (i == 3)
      {
        i = 5;
        break label463;
      }
      label1053:
      i = 0;
      break label463;
      label1058:
      long l = this.gLu;
      if ((l == -1L) || (l == Long.MIN_VALUE)) {
        i = 0;
      }
      for (;;)
      {
        this.vFi = i;
        break;
        ap.yY();
        paramBundle = com.tencent.mm.u.c.wT().cA(l);
        if (paramBundle.field_msgId != 0L)
        {
          j = paramBundle.field_type;
          localObject = paramBundle.field_content;
          if (!paramBundle.axH()) {
            break label1218;
          }
          paramBundle = f.a.ek((String)localObject);
          if (paramBundle != null) {
            break label1157;
          }
          v.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
        }
        label1157:
        label1218:
        do
        {
          do
          {
            i = 0;
            break;
            if (paramBundle.type == 3)
            {
              i = 1;
              break;
            }
            if (paramBundle.type == 4) {
              break;
            }
            if (paramBundle.type == 6)
            {
              i = 4;
              break;
            }
            if (paramBundle.type == 2)
            {
              i = 3;
              break;
            }
          } while (paramBundle.type != 5);
          i = 5;
          break;
          if (j == 3)
          {
            i = 3;
            break;
          }
          if (j == 48)
          {
            i = 2;
            break;
          }
        } while (j != 62);
      }
      label1248:
      this.vEW.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2312839888896L, 17232);
    super.onDestroy();
    v.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
    this.vFg = false;
    if (this.vEZ.booleanValue())
    {
      if (!this.vFf) {
        lQ(2);
      }
      com.tencent.mm.sdk.b.a.uql.c(this.vFo);
      com.tencent.mm.sdk.b.a.uql.c(this.vFp);
      ej localej = new ej();
      com.tencent.mm.sdk.b.a.uql.m(localej);
      if (localej.fIc.fHF) {
        v.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
      }
    }
    com.tencent.mm.sdk.platformtools.a.cR(getWindow().getDecorView());
    com.tencent.mm.sdk.platformtools.a.dU(this);
    GMTrace.o(2312839888896L, 17232);
  }
  
  protected void onPause()
  {
    GMTrace.i(2312571453440L, 17230);
    super.onPause();
    GMTrace.o(2312571453440L, 17230);
  }
  
  protected void onResume()
  {
    GMTrace.i(2312437235712L, 17229);
    super.onResume();
    bUB();
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    float f;
    if (this.vEZ.booleanValue())
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.sPa.getLayoutParams();
      i = localLayoutParams.height;
      f = com.tencent.mm.bg.a.dI(this);
      if (f != 1.125F) {
        break label90;
      }
    }
    for (localLayoutParams.height = (i + getResources().getDimensionPixelSize(R.f.aXw));; localLayoutParams.height = (i + getResources().getDimensionPixelSize(R.f.aXG))) {
      label90:
      do
      {
        this.sPa.setLayoutParams(localLayoutParams);
        GMTrace.o(2312437235712L, 17229);
        return;
      } while ((f != 1.375F) && (f != 1.25F) && (f != 1.625F));
    }
  }
  
  private final class a
    extends BaseAdapter
  {
    private Context context;
    private com.tencent.mm.ah.a.a.c lgD;
    private Map<String, ChattingSendDataToDeviceUI.c> vFy;
    private List<Map<String, ChattingSendDataToDeviceUI.c>> vwo;
    
    public a(Context paramContext)
    {
      GMTrace.i(2407194951680L, 17935);
      this.context = paramContext;
      this.vwo = new ArrayList();
      this$1 = new c.a();
      ChattingSendDataToDeviceUI.this.hII = R.g.bhp;
      this.lgD = ChattingSendDataToDeviceUI.this.Hh();
      GMTrace.o(2407194951680L, 17935);
    }
    
    public final ChattingSendDataToDeviceUI.c AO(int paramInt)
    {
      GMTrace.i(2407597604864L, 17938);
      ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)((Map)this.vwo.get(paramInt)).get("hard_device_info");
      GMTrace.o(2407597604864L, 17938);
      return localc;
    }
    
    public final void ao(List<ChattingSendDataToDeviceUI.c> paramList)
    {
      GMTrace.i(2407329169408L, 17936);
      this.vwo.clear();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        this.vFy = new HashMap();
        this.vFy.put("hard_device_info", paramList.get(i));
        this.vwo.add(this.vFy);
        i += 1;
      }
      GMTrace.o(2407329169408L, 17936);
    }
    
    public final int getCount()
    {
      GMTrace.i(2407463387136L, 17937);
      int i = this.vwo.size();
      GMTrace.o(2407463387136L, 17937);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(2407731822592L, 17939);
      long l = paramInt;
      GMTrace.o(2407731822592L, 17939);
      return l;
    }
    
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(2407866040320L, 17940);
      ChattingSendDataToDeviceUI.c localc = AO(paramInt);
      v.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
      final int i;
      final int j;
      StringBuffer localStringBuffer;
      float f;
      label264:
      int k;
      label267:
      String str2;
      if (ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramInt)) == null)
      {
        paramView = new eo();
        paramViewGroup = View.inflate(paramViewGroup.getContext(), R.i.dnF, null);
        paramView.ljI = paramViewGroup.findViewById(R.h.bGk);
        paramView.kxz = ((TextView)paramViewGroup.findViewById(R.h.cmd));
        paramView.jaK = ((ImageView)paramViewGroup.findViewById(R.h.bWo));
        paramView.vFx = ((TextView)paramViewGroup.findViewById(R.h.cCl));
        paramView.vMK = ((SendDataToDeviceProgressBar)paramViewGroup.findViewById(R.h.cCk));
        paramView.vMK.setVisibility(4);
        ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).put(Integer.valueOf(paramInt), paramViewGroup);
        paramViewGroup.setTag(paramView);
        ChattingSendDataToDeviceUI.k(ChattingSendDataToDeviceUI.this).put(localc.deviceID, Integer.valueOf(paramInt));
        String str1 = localc.gMN;
        i = 8;
        j = 0;
        localObject = new StringBuffer();
        localStringBuffer = new StringBuffer();
        f = com.tencent.mm.bg.a.dI(this.context);
        if ((f != 1.125F) && (f != 1.25F)) {
          break label374;
        }
        i = 6;
        k = 0;
        if (k >= str1.length()) {
          break label419;
        }
        int m = Character.codePointAt(str1, k);
        str2 = str1.substring(k, k + 1);
        if ((m < 0) || (m > 255)) {
          break label398;
        }
        j += 1;
        label318:
        if (j > i) {
          break label407;
        }
        localObject = ((StringBuffer)localObject).append(str2);
      }
      for (;;)
      {
        k += 1;
        break label267;
        paramViewGroup = (View)ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this).get(Integer.valueOf(paramInt));
        paramView = (eo)paramViewGroup.getTag();
        break;
        label374:
        if ((f != 1.375F) && (f != 1.625F)) {
          break label264;
        }
        i = 5;
        break label264;
        label398:
        j += 2;
        break label318;
        label407:
        localStringBuffer = localStringBuffer.append(str2);
      }
      label419:
      paramView.kxz.setText(((StringBuffer)localObject).toString());
      if (j >= i) {
        paramView.vFx.setText(localStringBuffer);
      }
      final Object localObject = null;
      if (ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(AO(paramInt).deviceID)) {
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(AO(paramInt).deviceID);
      }
      if ((localObject != null) && (((ChattingSendDataToDeviceUI.c)localObject).fHI != null))
      {
        v.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[] { Integer.valueOf(paramInt), ((ChattingSendDataToDeviceUI.c)localObject).fHI });
        if (!((ChattingSendDataToDeviceUI.c)localObject).fHI.equals("send_data_sending")) {
          break label752;
        }
        paramView.vFx.setText(this.context.getString(R.l.dVv));
        paramView.vFx.setTextColor(this.context.getResources().getColor(R.e.aVM));
        paramView.vMK.setProgress(localc.progress);
        paramView.vMK.setVisibility(0);
        localObject = localc.deviceID;
        localObject = (ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(localObject);
        j = ((ChattingSendDataToDeviceUI.c)localObject).progress;
        if (j < 100) {
          break label738;
        }
        i = 0;
        e.b(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2209626456064L, 16463);
            int i = j + 1;
            int j;
            while (ChattingSendDataToDeviceUI.this.vFg)
            {
              if (i >= 100) {
                j = i;
              }
              try
              {
                if (localObject.fHI.equals("send_data_sucess"))
                {
                  j = i;
                  ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                  {
                    public final void run()
                    {
                      GMTrace.i(2174192975872L, 16199);
                      ChattingSendDataToDeviceUI.a.1.this.vFs.vMK.setProgress(0);
                      ChattingSendDataToDeviceUI.a.1.this.vFs.vMK.setVisibility(4);
                      ChattingSendDataToDeviceUI.a.1.this.vFs.vFx.setText(ChattingSendDataToDeviceUI.this.getText(R.l.dVt));
                      ChattingSendDataToDeviceUI.a.1.this.vFs.vFx.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.aVM));
                      ChattingSendDataToDeviceUI.a.1.this.vFt.fHI = "send_data_sucess";
                      ChattingSendDataToDeviceUI.a.1.this.vFt.progress = 0;
                      ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.vFt.deviceID, ChattingSendDataToDeviceUI.a.1.this.vFt);
                      v.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.vFt.deviceID });
                      GMTrace.o(2174192975872L, 16199);
                    }
                  });
                  GMTrace.o(2209626456064L, 16463);
                  return;
                }
                j = i;
                if (!localObject.fHI.equals("send_data_failed")) {
                  continue;
                }
                j = i;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
                {
                  public final void run()
                  {
                    GMTrace.i(2370687729664L, 17663);
                    ChattingSendDataToDeviceUI.a.1.this.vFs.vMK.setProgress(0);
                    ChattingSendDataToDeviceUI.a.1.this.vFs.vMK.setVisibility(4);
                    ChattingSendDataToDeviceUI.a.1.this.vFs.vFx.setText(ChattingSendDataToDeviceUI.this.getText(R.l.dVr));
                    ChattingSendDataToDeviceUI.a.1.this.vFs.vFx.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.aVN));
                    ChattingSendDataToDeviceUI.a.1.this.vFt.fHI = "send_data_failed";
                    ChattingSendDataToDeviceUI.a.1.this.vFt.progress = 0;
                    ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).put(ChattingSendDataToDeviceUI.a.1.this.vFt.deviceID, ChattingSendDataToDeviceUI.a.1.this.vFt);
                    v.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", new Object[] { ChattingSendDataToDeviceUI.a.1.this.vFt.deviceID });
                    GMTrace.o(2370687729664L, 17663);
                  }
                });
                GMTrace.o(2209626456064L, 16463);
                return;
              }
              catch (Exception localException)
              {
                v.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", new Object[] { localException });
                i = j;
              }
              j = i;
              paramView.vMK.setProgress(i);
              j = i;
              localObject.progress = i;
              i += 1;
              j = i;
              Thread.sleep(i);
            }
            GMTrace.o(2209626456064L, 16463);
          }
        }, "SendDataState_handler").start();
      }
      for (;;)
      {
        v.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localc.gMN });
        n.GX().a(localc.iconUrl, paramView.jaK, this.lgD);
        paramView.ljI.setTag(Integer.valueOf(paramInt));
        GMTrace.o(2407866040320L, 17940);
        return paramViewGroup;
        label738:
        i = 500 / (100 - j);
        break;
        label752:
        if (((ChattingSendDataToDeviceUI.c)localObject).fHI.equals("send_data_sucess"))
        {
          paramView.vFx.setText(this.context.getString(R.l.dVt));
          paramView.vFx.setTextColor(this.context.getResources().getColor(R.e.aVM));
          paramView.vMK.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).fHI.equals("send_data_cancel"))
        {
          paramView.vFx.setText(this.context.getString(R.l.dVn));
          paramView.vFx.setTextColor(this.context.getResources().getColor(R.e.aVL));
          paramView.vMK.setVisibility(4);
        }
        else if (((ChattingSendDataToDeviceUI.c)localObject).fHI.equals("send_data_failed"))
        {
          paramView.vFx.setText(this.context.getString(R.l.dVr));
          paramView.vFx.setTextColor(this.context.getResources().getColor(R.e.aVN));
          paramView.vMK.setVisibility(4);
        }
      }
    }
  }
  
  public final class b
  {
    public b()
    {
      GMTrace.i(2162918686720L, 16115);
      GMTrace.o(2162918686720L, 16115);
    }
    
    public final boolean n(com.tencent.mm.sdk.b.b paramb)
    {
      GMTrace.i(2163052904448L, 16116);
      Object localObject1;
      int i;
      Object localObject2;
      if ((paramb instanceof dt))
      {
        paramb = ((dt)paramb).fHv.fGH;
        localObject1 = new ArrayList();
        i = 0;
        while (i < paramb.size())
        {
          localObject2 = new ChattingSendDataToDeviceUI.c(ChattingSendDataToDeviceUI.this);
          ((ChattingSendDataToDeviceUI.c)localObject2).fGc = ((String)((Map)paramb.get(i)).get("deviceType"));
          ((ChattingSendDataToDeviceUI.c)localObject2).deviceID = ((String)((Map)paramb.get(i)).get("deviceID"));
          ((ChattingSendDataToDeviceUI.c)localObject2).gMN = ((String)((Map)paramb.get(i)).get("displayName"));
          ((ChattingSendDataToDeviceUI.c)localObject2).iconUrl = ((String)((Map)paramb.get(i)).get("iconUrl"));
          ((ChattingSendDataToDeviceUI.c)localObject2).fHD = ((String)((Map)paramb.get(i)).get("ability"));
          ((ChattingSendDataToDeviceUI.c)localObject2).vFC = ((String)((Map)paramb.get(i)).get("abilityInf"));
          if (((ChattingSendDataToDeviceUI.this.fHE) && (ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, (ChattingSendDataToDeviceUI.c)localObject2, ChattingSendDataToDeviceUI.f(ChattingSendDataToDeviceUI.this)))) || ((!ChattingSendDataToDeviceUI.this.fHE) && (ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, (ChattingSendDataToDeviceUI.c)localObject2, ChattingSendDataToDeviceUI.g(ChattingSendDataToDeviceUI.this)))))
          {
            if ((ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).containsKey(((ChattingSendDataToDeviceUI.c)localObject2).deviceID)) && (((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(((ChattingSendDataToDeviceUI.c)localObject2).deviceID)).fHI != null))
            {
              ((ChattingSendDataToDeviceUI.c)localObject2).fHI = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(((ChattingSendDataToDeviceUI.c)localObject2).deviceID)).fHI;
              ((ChattingSendDataToDeviceUI.c)localObject2).progress = ((ChattingSendDataToDeviceUI.c)ChattingSendDataToDeviceUI.d(ChattingSendDataToDeviceUI.this).get(((ChattingSendDataToDeviceUI.c)localObject2).deviceID)).progress;
            }
            ((List)localObject1).add(localObject2);
          }
          i += 1;
        }
        if (ChattingSendDataToDeviceUI.l(ChattingSendDataToDeviceUI.this).size() != ((List)localObject1).size())
        {
          ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, (List)localObject1);
          ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(2373237866496L, 17682);
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).ao(ChattingSendDataToDeviceUI.l(ChattingSendDataToDeviceUI.this));
              if (ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).getCount() > 0)
              {
                ChattingSendDataToDeviceUI.m(ChattingSendDataToDeviceUI.this).setText(R.l.dSV);
                ChattingSendDataToDeviceUI.n(ChattingSendDataToDeviceUI.this);
              }
              ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this).notifyDataSetChanged();
              GMTrace.o(2373237866496L, 17682);
            }
          });
        }
        GMTrace.o(2163052904448L, 16116);
        return true;
      }
      if ((paramb instanceof dx))
      {
        localObject1 = (dx)paramb;
        localObject2 = ((dx)localObject1).fHG.fHI;
        paramb = ((dx)localObject1).fHG.fwB;
        if (((String)localObject2).equals("send_data_sending")) {
          ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", paramb, ((dx)localObject1).fHG.progress);
        }
        do
        {
          for (;;)
          {
            GMTrace.o(2163052904448L, 16116);
            return true;
            if (!((String)localObject2).equals("send_data_failed")) {
              break;
            }
            ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_failed", paramb, 0);
          }
        } while (!((String)localObject2).equals("send_data_sucess"));
        localObject1 = ChattingSendDataToDeviceUI.this;
        for (;;)
        {
          int j;
          try
          {
            i = ((Integer)((ChattingSendDataToDeviceUI)localObject1).vFm.get(paramb)).intValue();
            localObject2 = (eo)((View)((ChattingSendDataToDeviceUI)localObject1).vFl.get(Integer.valueOf(i))).getTag();
            v.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[] { Integer.valueOf(((eo)localObject2).vMK.getProgress()), paramb });
            ChattingSendDataToDeviceUI.c localc = (ChattingSendDataToDeviceUI.c)((ChattingSendDataToDeviceUI)localObject1).vFk.get(paramb);
            ((ChattingSendDataToDeviceUI)localObject1).runOnUiThread(new ChattingSendDataToDeviceUI.7((ChattingSendDataToDeviceUI)localObject1, (eo)localObject2, localc));
            j = Math.abs(((eo)localObject2).vMK.getProgress());
            localc.progress = j;
            if (j < 100) {
              break label760;
            }
            i = 0;
            v.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[] { Integer.valueOf(i) });
            e.b(new ChattingSendDataToDeviceUI.8((ChattingSendDataToDeviceUI)localObject1, j, (eo)localObject2, paramb, localc, i), "progressSuccess_handler").start();
            ((ChattingSendDataToDeviceUI)localObject1).vFk.put(localc.deviceID, localc);
          }
          catch (Exception paramb)
          {
            v.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", new Object[] { paramb });
          }
          break;
          label760:
          i = 500 / (100 - j);
        }
      }
      GMTrace.o(2163052904448L, 16116);
      return true;
    }
  }
  
  public final class c
  {
    String deviceID;
    String fGc;
    String fHD;
    String fHI;
    String gMN;
    String iconUrl;
    int progress;
    String vFC;
    
    public c()
    {
      GMTrace.i(2169361137664L, 16163);
      GMTrace.o(2169361137664L, 16163);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ChattingSendDataToDeviceUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */