package com.tencent.mm.plugin.record.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.protocal.c.se;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.o;
import java.util.List;

public final class n
{
  public static String ar(List<rl> paramList)
  {
    GMTrace.i(7512703107072L, 55974);
    if ((paramList == null) || (paramList.size() == 0))
    {
      v.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
      GMTrace.o(7512703107072L, 55974);
      return "";
    }
    int j = paramList.size();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<datalist count='").append(j).append("'>");
    int i = 0;
    if (i < j)
    {
      Object localObject1 = (rl)paramList.get(i);
      localStringBuffer.append("<dataitem ");
      if (((rl)localObject1).tvO) {
        localStringBuffer.append("datatype='").append(((rl)localObject1).aMw).append("'");
      }
      if (((rl)localObject1).twr) {
        localStringBuffer.append(" datastatus='").append(((rl)localObject1).twq).append("'");
      }
      if (((rl)localObject1).tvX) {
        localStringBuffer.append(" dataid='").append(((rl)localObject1).lII).append("'");
      }
      if (((rl)localObject1).twD) {
        localStringBuffer.append(" htmlid='").append(((rl)localObject1).twC).append("'");
      }
      if (((rl)localObject1).twJ) {
        localStringBuffer.append(" dataillegaltype='").append(((rl)localObject1).twI).append("'");
      }
      if (((rl)localObject1).twj) {
        localStringBuffer.append(" datasourceid='").append(((rl)localObject1).twi).append("'");
      }
      localStringBuffer.append(">");
      if (((rl)localObject1).tvQ) {
        localStringBuffer.append("<datafmt>").append(((rl)localObject1).tvP).append("</datafmt>");
      }
      if (((rl)localObject1).tvt) {
        localStringBuffer.append("<datatitle>").append(bf.PV(((rl)localObject1).title)).append("</datatitle>");
      }
      if (((rl)localObject1).tvu) {
        localStringBuffer.append("<datadesc>").append(bf.PV(((rl)localObject1).desc)).append("</datadesc>");
      }
      if (((rl)localObject1).tvv) {
        localStringBuffer.append("<cdnthumburl>").append(bf.PV(((rl)localObject1).hho)).append("</cdnthumburl>");
      }
      if (((rl)localObject1).tvy) {
        localStringBuffer.append("<thumbwidth>").append(((rl)localObject1).hht).append("</thumbwidth>");
      }
      if (((rl)localObject1).tvz) {
        localStringBuffer.append("<thumbheight>").append(((rl)localObject1).hhs).append("</thumbheight>");
      }
      if (((rl)localObject1).tvB) {
        localStringBuffer.append("<cdndataurl>").append(bf.PV(((rl)localObject1).tvA)).append("</cdndataurl>");
      }
      if (((rl)localObject1).tvx) {
        localStringBuffer.append("<cdnthumbkey>").append(bf.PV(((rl)localObject1).tvw)).append("</cdnthumbkey>");
      }
      if (((rl)localObject1).tvD) {
        localStringBuffer.append("<cdndatakey>").append(bf.PV(((rl)localObject1).tvC)).append("</cdndatakey>");
      }
      if (((rl)localObject1).tvF) {
        localStringBuffer.append("<cdnencryver>").append(((rl)localObject1).tvE).append("</cdnencryver>");
      }
      if (((rl)localObject1).tvG) {
        localStringBuffer.append("<duration>").append(((rl)localObject1).duration).append("</duration>");
      }
      if (((rl)localObject1).tvI) {
        localStringBuffer.append("<streamweburl>").append(bf.PV(((rl)localObject1).tvH)).append("</streamweburl>");
      }
      if (((rl)localObject1).tvK) {
        localStringBuffer.append("<streamdataurl>").append(bf.PV(((rl)localObject1).tvJ)).append("</streamdataurl>");
      }
      if (((rl)localObject1).tvM) {
        localStringBuffer.append("<streamlowbandurl>").append(bf.PV(((rl)localObject1).tvL)).append("</streamlowbandurl>");
      }
      if (((rl)localObject1).tvN) {
        localStringBuffer.append("<dataext>").append(bf.PV(((rl)localObject1).fFj)).append("</dataext>");
      }
      if (((rl)localObject1).tvS) {
        localStringBuffer.append("<fullmd5>").append(((rl)localObject1).tvR).append("</fullmd5>");
      }
      if (((rl)localObject1).tvU) {
        localStringBuffer.append("<head256md5>").append(((rl)localObject1).tvT).append("</head256md5>");
      }
      if (((rl)localObject1).tvW) {
        localStringBuffer.append("<datasize>").append(((rl)localObject1).tvV).append("</datasize>");
      }
      if (((rl)localObject1).twd) {
        localStringBuffer.append("<thumbfullmd5>").append(((rl)localObject1).twc).append("</thumbfullmd5>");
      }
      if (((rl)localObject1).twf) {
        localStringBuffer.append("<thumbhead256md5>").append(((rl)localObject1).twe).append("</thumbhead256md5>");
      }
      if (((rl)localObject1).twh) {
        localStringBuffer.append("<thumbsize>").append(((rl)localObject1).twg).append("</thumbsize>");
      }
      if (((rl)localObject1).twl) {
        localStringBuffer.append("<streamvideoid>").append(bf.PV(((rl)localObject1).twk)).append("</streamvideoid>");
      }
      if (((rl)localObject1).twt) {
        localStringBuffer.append("<sourcetitle>").append(bf.PV(((rl)localObject1).tws)).append("</sourcetitle>");
      }
      if (((rl)localObject1).twx) {
        localStringBuffer.append("<sourcename>").append(bf.PV(((rl)localObject1).tww)).append("</sourcename>");
      }
      if (((rl)localObject1).twz) {
        localStringBuffer.append("<sourcetime>").append(bf.PV(((rl)localObject1).twy)).append("</sourcetime>");
      }
      if (((rl)localObject1).twE) {
        localStringBuffer.append("<statextstr>").append(bf.PV(((rl)localObject1).fUO)).append("</statextstr>");
      }
      if (((rl)localObject1).twL) {
        localStringBuffer.append("<recordxml>").append(((rl)localObject1).twK).append("</recordxml>");
      }
      Object localObject2 = ((rl)localObject1).twu;
      if ((localObject2 == null) || (((rm)localObject2).twM == null) || (((rm)localObject2).twM.aUd() == 0))
      {
        v.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
        label1139:
        localObject2 = ((rl)localObject1).twu;
        if ((localObject2 != null) && (((rm)localObject2).twO != null) && (((rm)localObject2).twO.aUd() != 0)) {
          break label1595;
        }
        v.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
        label1178:
        localObject2 = ((rl)localObject1).twu;
        if ((localObject2 != null) && (((rm)localObject2).twQ != null) && (((rm)localObject2).twQ.aUd() != 0)) {
          break label1774;
        }
        v.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
        label1217:
        localObject2 = ((rl)localObject1).twu;
        if ((localObject2 != null) && (((rm)localObject2).twS != null) && (((rm)localObject2).twS.aUd() != 0)) {
          break label1992;
        }
        v.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
        label1256:
        localObject1 = ((rl)localObject1).twu;
        if ((localObject1 != null) && (((rm)localObject1).twU != null) && (((rm)localObject1).twU.aUd() != 0)) {
          break label2186;
        }
        v.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
      }
      for (;;)
      {
        localStringBuffer.append("</dataitem>");
        i += 1;
        break;
        localObject2 = ((rm)localObject2).twM;
        if (((rn)localObject2).txm) {
          localStringBuffer.append("<appid>").append(((rn)localObject2).appId).append("</appid>");
        }
        if (((rn)localObject2).txn) {
          localStringBuffer.append("<link>").append(bf.PV(((rn)localObject2).hSD)).append("</link>");
        }
        if (((rn)localObject2).txq) {
          localStringBuffer.append("<brandid>").append(bf.PV(((rn)localObject2).fCA)).append("</brandid>");
        }
        if ((((rn)localObject2).txe) && (((rn)localObject2).txj))
        {
          if (((rn)localObject2).fOl.equals(((rn)localObject2).txi))
          {
            localStringBuffer.append("<dataitemsource><fromusr>").append(bf.PV(((rn)localObject2).fOl)).append("</fromusr></dataitemsource>");
            break label1139;
          }
          if ((!o.dH(((rn)localObject2).fOl)) && (!e.is(((rn)localObject2).txi))) {
            break label1139;
          }
          localStringBuffer.append("<dataitemsource><realchatname>").append(bf.PV(((rn)localObject2).txi)).append("</realchatname></dataitemsource>");
          break label1139;
        }
        if (((rn)localObject2).txe)
        {
          localStringBuffer.append("<dataitemsource><fromusr>").append(bf.PV(((rn)localObject2).fOl)).append("</fromusr></dataitemsource>");
          break label1139;
        }
        if (!((rn)localObject2).txj) {
          break label1139;
        }
        localStringBuffer.append("<dataitemsource><realchatname>").append(bf.PV(((rn)localObject2).txi)).append("</realchatname></dataitemsource>");
        break label1139;
        label1595:
        localObject2 = ((rm)localObject2).twO;
        localStringBuffer.append("<locitem>");
        if (((rr)localObject2).txy) {
          localStringBuffer.append("<label>").append(bf.PV(((rr)localObject2).label)).append("</label>");
        }
        if (((rr)localObject2).txw) {
          localStringBuffer.append("<lat>").append(((rr)localObject2).lat).append("</lat>");
        }
        if (((rr)localObject2).txv) {
          localStringBuffer.append("<lng>").append(((rr)localObject2).lng).append("</lng>");
        }
        if (((rr)localObject2).txx) {
          localStringBuffer.append("<scale>").append(((rr)localObject2).fNU).append("</scale>");
        }
        if (((rr)localObject2).txz) {
          localStringBuffer.append("<poiname>").append(((rr)localObject2).fRN).append("</poiname>");
        }
        localStringBuffer.append("</locitem>");
        break label1178;
        label1774:
        localObject2 = ((rm)localObject2).twQ;
        localStringBuffer.append("<weburlitem>");
        if (((se)localObject2).tyg) {
          localStringBuffer.append("<link>").append(bf.PV(((se)localObject2).tyf)).append("</link>");
        }
        if (((se)localObject2).tvu) {
          localStringBuffer.append("<desc>").append(bf.PV(((se)localObject2).desc)).append("</desc>");
        }
        if (((se)localObject2).txA) {
          localStringBuffer.append("<thumburl>").append(bf.PV(((se)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((se)localObject2).tvt) {
          localStringBuffer.append("<title>").append(bf.PV(((se)localObject2).title)).append("</title>");
        }
        if (((se)localObject2).tyi) {
          localStringBuffer.append("<opencache>").append(((se)localObject2).tyh).append("</opencache>");
        }
        if (((se)localObject2).tyj) {
          localStringBuffer.append("<contentattr>").append(((se)localObject2).hhl).append("</contentattr>");
        }
        localStringBuffer.append("</weburlitem>");
        break label1217;
        label1992:
        localObject2 = ((rm)localObject2).twS;
        localStringBuffer.append("<productitem");
        if (((rt)localObject2).txC) {
          localStringBuffer.append(" type='").append(((rt)localObject2).type).append("'");
        }
        localStringBuffer.append(">");
        if (((rt)localObject2).tvt) {
          localStringBuffer.append("<title>").append(bf.PV(((rt)localObject2).title)).append("</title>");
        }
        if (((rt)localObject2).tvu) {
          localStringBuffer.append("<desc>").append(bf.PV(((rt)localObject2).desc)).append("</desc>");
        }
        if (((rt)localObject2).txA) {
          localStringBuffer.append("<thumburl>").append(bf.PV(((rt)localObject2).thumbUrl)).append("</thumburl>");
        }
        if (((rt)localObject2).txB) {
          localStringBuffer.append("<productinfo>").append(bf.PV(((rt)localObject2).info)).append("</productinfo>");
        }
        localStringBuffer.append("</productitem>");
        break label1256;
        label2186:
        localObject1 = ((rm)localObject1).twU;
        localStringBuffer.append("<tvitem>");
        if (((ry)localObject1).tvt) {
          localStringBuffer.append("<title>").append(bf.PV(((ry)localObject1).title)).append("</title>");
        }
        if (((ry)localObject1).tvu) {
          localStringBuffer.append("<desc>").append(bf.PV(((ry)localObject1).desc)).append("</desc>");
        }
        if (((ry)localObject1).txA) {
          localStringBuffer.append("<thumburl>").append(bf.PV(((ry)localObject1).thumbUrl)).append("</thumburl>");
        }
        if (((ry)localObject1).txB) {
          localStringBuffer.append("<tvinfo>").append(bf.PV(((ry)localObject1).info)).append("</tvinfo>");
        }
        localStringBuffer.append("</tvitem>");
      }
    }
    localStringBuffer.append("</datalist>");
    paramList = localStringBuffer.toString();
    GMTrace.o(7512703107072L, 55974);
    return paramList;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/record/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */