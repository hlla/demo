package letv.com.testanr;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

public class TestBean implements Serializable, Parcelable {


    private static final long serialVersionUID = 7287187310356785403L;
    /**
     * sceneID : 1
     * updatetime : 1542680153
     * configStr : ["{\"coolingtime\": \"1542680153\",\"startTime\": \"1542680153\"}",
     * "{\"coolingtime\": \"8888\",\"startTime\": \"222222\"}"]
     * datas : [{"id":1,"title":"sky","type":0,"plaqueAdID":"","videoAdID":"",
     * "jumpurl":"http://wwww.xxxx.com","intentAction":"","desc":"hahhha","thumburl":["http://img
     * .xxx.net","http://img.xxx.net"],"coverurl":["http://img.xxx.net","http://img.xxx.net"],
     * "pkgname":"com.test.xxx","subposid":"","weight":200,"extendStr":"{\"key1\": \"value\",
     * \"key2\": \"value\"}"},{"id":1,"title":"sky","type":0,"plaqueAdID":"","videoAdID":"",
     * "jumpurl":"http://wwww.xxxx.com","intentAction":"","coverurl":["http://img.xxx.net",
     * "http://img.xxx.net"],"pkgname":"com.test.xxx","subposid":"","weight":200,
     * "extendStr":"{\"key1\": \"value\",\"key2\": \"value\"}"}]
     */

    private int sceneID;
    private String updatetime;
    private String startDate;
    private String endDate;
    /**
     * startTime的格式是"11:00-1,13:00-3" 表示一个时间对应一个id的DatasBean数据,如果没有id，表示没有对应关系
     * ，直接根据具体业务从datas里面获取DatasBean数据,业务端不要直接使用starttime和endtime，请使用ShowTimePolicy
     */
    private String starttime;
    private String endtime;
    private List<ShowTimePolicy> showTimePolicies;

    private String configStr;
    public ArrayMap<String, String> config;
    private List<DatasBean> datas;

    public String getConfigStr() {
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    private boolean hasMore;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public List<ShowTimePolicy> getShowTimePolicy() {
        return showTimePolicies;
    }

    public void setShowTimePolicy(List<ShowTimePolicy> showTimePolicies) {
        this.showTimePolicies = showTimePolicies;
    }

    public static class ShowTimePolicy implements Serializable, Parcelable {
        private static final long serialVersionUID = -6309548074270703098L;
        private String startTime;
        private String endTime;
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.startTime);
            dest.writeString(this.endTime);
            dest.writeString(this.id);
        }

        public ShowTimePolicy() {
        }

        protected ShowTimePolicy(Parcel in) {
            this.startTime = in.readString();
            this.endTime = in.readString();
            this.id = in.readString();
        }

        public static final Creator<ShowTimePolicy> CREATOR = new Creator<ShowTimePolicy>() {
            @Override
            public ShowTimePolicy createFromParcel(Parcel source) {
                return new ShowTimePolicy(source);
            }

            @Override
            public ShowTimePolicy[] newArray(int size) {
                return new ShowTimePolicy[size];
            }
        };
    }

    public int getSceneID() {
        return sceneID;
    }

    public void setSceneID(int sceneID) {
        this.sceneID = sceneID;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean implements Serializable, Parcelable {
        private static final long serialVersionUID = 4061011691994543109L;
        /*
         * type 内推跳转类型
         */
        public static final int TYPE_H5 = 0;
        public static final int TYPE_GP = 1;
        public static final int TYPE_INNER = 2;
        public static final int TYPE_GAME_CP = 3;
        public static final int TYPE_GAME_H5 = 4;

        /*
         * 内推固定action
         */
        private static final String ACTION_H5 = "com.test.h5";
        private static final String ACTION_GAME_H5 = "com.test.gameh5";
        /**
         * 扩展字段
         */
        public static final String KEY_EXTRA_CP = "cp";
        /**
         * id : 1
         * title : sky
         * type : 0
         * plaqueAdID :
         * videoAdID :
         * jumpurl : http://wwww.xxxx.com
         * intentAction :
         * desc : hahhha
         * thumburl : ["http://img.xxx.net","http://img.xxx.net"]
         * coverurl : ["http://img.xxx.net","http://img.xxx.net"]
         * pkgname : com.test.xxx
         * subposid :
         * weight : 200
         * extendStr : {"key1": "value","key2": "value"}
         */

        private int id;
        private String title;
        private int type;
        private String plaqueAdID;
        private String videoAdID;
        private String jumpurl;
        private String intentAction;
        private String desc;
        private String pkgname;
        private String subposid;
        private int weight;
        private String extendStr;
        private List<String> thumburl;
        private List<String> coverurl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getPlaqueAdID() {
            return plaqueAdID;
        }

        public void setPlaqueAdID(String plaqueAdID) {
            this.plaqueAdID = plaqueAdID;
        }

        public String getVideoAdID() {
            return videoAdID;
        }

        public void setVideoAdID(String videoAdID) {
            this.videoAdID = videoAdID;
        }

        public String getJumpurl() {
            return jumpurl;
        }

        public void setJumpurl(String jumpurl) {
            this.jumpurl = jumpurl;
        }

        public String getIntentAction() {
            if (TextUtils.isEmpty(intentAction)) {
                if (type == TYPE_H5) {
                    intentAction = ACTION_H5;
                } else if (type == TYPE_GAME_H5) {
                    intentAction = ACTION_GAME_H5;
                }
            }
            return intentAction;
        }

        public void setIntentAction(String intentAction) {
            this.intentAction = intentAction;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPkgname() {
            return pkgname;
        }

        public void setPkgname(String pkgname) {
            this.pkgname = pkgname;
        }

        public String getSubposid() {
            return subposid;
        }

        public void setSubposid(String subposid) {
            this.subposid = subposid;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }


        public List<String> getThumburl() {
            return thumburl;
        }

        public void setThumburl(List<String> thumburl) {
            this.thumburl = thumburl;
        }

        public List<String> getCoverurl() {
            return coverurl;
        }

        public void setCoverurl(List<String> coverurl) {
            this.coverurl = coverurl;
        }

        public DatasBean() {
        }
//
//        public boolean getConfigBooleanValue(String key, boolean defValue) {
//            boolean result = defValue;
//            if (null != extendStr) {
//                String value = extendStr.get(key);
//                if (!TextUtils.isEmpty(value)) {
//                    result = "1".equalsIgnoreCase(extendStr.get(key));
//                }
//            }
//            return result;
//        }
//
//        public String getConfigStringValue(String key, String defValue) {
//            String result = defValue;
//            if (null != extendStr) {
//                String value = extendStr.get(key);
//                if (!TextUtils.isEmpty(value)) {
//                    result = extendStr.get(key);
//                }
//            }
//            return result;
//        }
//
//        public int getConfigIntValue(String key, int defValue) {
//            int result = defValue;
//            if (null != extendStr) {
//                String value = extendStr.get(key);
//                if (!TextUtils.isEmpty(value) && TextUtils.isDigitsOnly(value)) {
//                    result = Integer.valueOf(extendStr.get(key));
//                }
//            }
//            return result;
//        }
//
//        public long getConfigLongValue(String key, long defValue) {
//            long result = defValue;
//            if (null != extendStr) {
//                String value = extendStr.get(key);
//                if (!TextUtils.isEmpty(value) && TextUtils.isDigitsOnly(value)) {
//                    result = Integer.valueOf(extendStr.get(key));
//                }
//            }
//            return result;
//        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.title);
            dest.writeInt(this.type);
            dest.writeString(this.plaqueAdID);
            dest.writeString(this.videoAdID);
            dest.writeString(this.jumpurl);
            dest.writeString(this.intentAction);
            dest.writeString(this.desc);
            dest.writeString(this.pkgname);
            dest.writeString(this.subposid);
            dest.writeInt(this.weight);
//            dest.writeInt(this.extendStr.size());
//            for (Map.Entry<String, String> entry : this.extendStr.entrySet()) {
//                dest.writeString(entry.getKey());
//                dest.writeString(entry.getValue());
//            }
            dest.writeStringList(this.thumburl);
            dest.writeStringList(this.coverurl);
        }

        protected DatasBean(Parcel in) {
            this.id = in.readInt();
            this.title = in.readString();
            this.type = in.readInt();
            this.plaqueAdID = in.readString();
            this.videoAdID = in.readString();
            this.jumpurl = in.readString();
            this.intentAction = in.readString();
            this.desc = in.readString();
            this.pkgname = in.readString();
            this.subposid = in.readString();
            this.weight = in.readInt();
            this.thumburl = in.createStringArrayList();
            this.coverurl = in.createStringArrayList();
        }

        public static final Creator<DatasBean> CREATOR = new Creator<DatasBean>() {
            @Override
            public DatasBean createFromParcel(Parcel source) {
                return new DatasBean(source);
            }

            @Override
            public DatasBean[] newArray(int size) {
                return new DatasBean[size];
            }
        };
    }

    public TestBean() {
    }


//    public boolean getConfigBooleanValue(String key, boolean defValue) {
//        boolean result = defValue;
//        if (null != configStr) {
//            String value = configStr.get(key);
//            if (!TextUtils.isEmpty(value)) {
//                result = "1".equalsIgnoreCase(configStr.get(key));
//            }
//        }
//        return result;
//    }
//
//    public String getConfigStringValue(String key, String defValue) {
//        String result = defValue;
//        if (null != configStr) {
//            String value = configStr.get(key);
//            if (!TextUtils.isEmpty(value)) {
//                result = configStr.get(key);
//            }
//        }
//        return result;
//    }
//
//    public int getConfigIntValue(String key, int defValue) {
//        int result = defValue;
//        if (null != configStr) {
//            String value = configStr.get(key);
//            if (!TextUtils.isEmpty(value) && TextUtils.isDigitsOnly(value)) {
//                result = Integer.valueOf(configStr.get(key));
//            }
//        }
//        return result;
//    }

//    public long getConfigLongValue(String key, long defValue) {
//        long result = defValue;
//        if (null != configStr) {
//            String value = configStr.get(key);
//            if (!TextUtils.isEmpty(value) && TextUtils.isDigitsOnly(value)) {
//                result = Integer.valueOf(configStr.get(key));
//            }
//        }
//        return result;
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(this.sceneID);
//        dest.writeLong(this.updatetime);
//        dest.writeLong(this.startDate);
//        dest.writeLong(this.endDate);
//        dest.writeString(this.starttime);
//        dest.writeString(this.endtime);
//        dest.writeTypedList(this.showTimePolicies);
//        dest.writeInt(this.configStr.size());
//        for (Map.Entry<String, String> entry : this.configStr.entrySet()) {
//            dest.writeString(entry.getKey());
//            dest.writeString(entry.getValue());
//        }
        dest.writeTypedList(this.datas);
        dest.writeByte(this.hasMore ? (byte) 1 : (byte) 0);
    }

    protected TestBean(Parcel in) {
//        this.sceneID = in.readInt();
//        this.updatetime = in.readLong();
//        this.startDate = in.readLong();
//        this.endDate = in.readLong();
//        this.starttime = in.readString();
//        this.endtime = in.readString();
//        this.showTimePolicies = in.createTypedArrayList(ShowTimePolicy.CREATOR);
//        int configStrSize = in.readInt();
//        this.configStr = new ArrayMap<>(configStrSize);
//        for (int i = 0; i < configStrSize; i++) {
//            String key = in.readString();
//            String value = in.readString();
//            this.configStr.put(key, value);
//        }
//        this.datas = in.createTypedArrayList(DatasBean.CREATOR);
//        this.hasMore = in.readByte() != 0;
    }

    public static final Creator<TestBean> CREATOR = new Creator<TestBean>() {
        @Override
        public TestBean createFromParcel(Parcel source) {
            return new TestBean(source);
        }

        @Override
        public TestBean[] newArray(int size) {
            return new TestBean[size];
        }
    };
}
