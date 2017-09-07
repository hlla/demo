/**
 *
 */

package com.example.testclient1;

/**
 * Created by chengjian ����8:24:25
 */

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class School implements Parcelable {
    private static final String TAG = "School";
    private String name;
    private String type;

    public School() {
    }

    public School(Parcel source) {
        super();
        this.setName(source.readString());
        this.setType(source.readString());
    }

    public String getName() {
//        CREATOR.createFromParcel00(null);
//        CREATOR.createFromParcel11(null);
//        CREATOR.newArray00(10);
//        CREATOR.newArray11(10);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
    }

    public School readFromParcel(Parcel source) {
        return null;
    }

//    class TestClass implements Parcelable.Creator<School> {
//        public School createFromParcel00(Parcel source) {
//            Log.d(TAG, "createFromParcel00000");
//            return new School();
//        }
//
//        @Override
//        public School createFromParcel(Parcel source) {
//            Log.d(TAG, "createFromParcelssss");
//            return new School(source);
//        }
//
//        public School createFromParcel11(Parcel source) {
//            Log.d(TAG, "createFromParcel11111");
//            return new School();
//        }
//
//        public School[] newArray00(int size) {
//            Log.d(TAG, "newArray0000");
//            return new School[size];
//        }
//
//        public School[] newArray(int size) {
//            Log.d(TAG, "newArraysss");
//            return new School[size];
//        }
//
//        public School[] newArray11(int size) {
//            Log.d(TAG, "newArray11111");
//            return new School[size];
//        }
//    }
    public static final Parcelable.Creator<School> CREATOR = new Parcelable.Creator<School>() {
        public School createFromParcel00(Parcel source) {
            Log.d(TAG, "createFromParcel00000");
            return new School();
        }

        @Override
        public School createFromParcel(Parcel source) {
            Log.d(TAG, "createFromParcelssss");
            return new School(source);
        }

        public School createFromParcel11(Parcel source) {
            Log.d(TAG, "createFromParcel11111");
            return new School();
        }

        public School[] newArray00(int size) {
            Log.d(TAG, "newArray0000");
            return new School[size];
        }

        public School[] newArray(int size) {
            Log.d(TAG, "newArraysss");
            return new School[size];
        }

        public School[] newArray11(int size) {
            Log.d(TAG, "newArray11111");
            return new School[size];
        }
    };

}
