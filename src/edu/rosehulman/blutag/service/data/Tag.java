package edu.rosehulman.blutag.service.data;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class Tag implements Comparable<Tag>, Parcelable {
	public Date time;
	
	public String player;
	
	public Tag() {
	}
	
	public int hashCode() {
		return time.hashCode();
	}

	@Override
	public int compareTo(Tag another) {
		return time.compareTo(another.time);
	}

    protected Tag(Parcel in) {
        long tmpTime = in.readLong();
        time = tmpTime != -1 ? new Date(tmpTime) : null;
        player = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(time != null ? time.getTime() : -1L);
        dest.writeString(player);
    }

    public static final Parcelable.Creator<Tag> CREATOR = new Parcelable.Creator<Tag>() {
        @Override
        public Tag createFromParcel(Parcel in) {
            return new Tag(in);
        }

        @Override
        public Tag[] newArray(int size) {
            return new Tag[size];
        }
    };
}