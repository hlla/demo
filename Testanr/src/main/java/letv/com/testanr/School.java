/**
 *
 */

package letv.com.testanr;

/**
 * Created by chengjian
 */

import android.os.Parcel;
import android.os.Parcelable;

public class School implements Parcelable {

    private String name;
    private String type;

    public School() {
    }

    public School(Parcel source) {
        this.setName(source.readString());
        this.setType(source.readString());
    }

    public String getName() {
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
        School school = new School();
        school.name = source.readString();
        school.type = source.readString();
        return null;
    }

    public static final Creator<School> CREATOR = new Creator<School>() {
        public School createFromParcel(Parcel source) {
            return new School(source);
        }

        public School[] newArray(int size) {
            return new School[size];
        }
    };

}
