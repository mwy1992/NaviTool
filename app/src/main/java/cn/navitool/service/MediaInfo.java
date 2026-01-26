package cn.navitool.service;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.util.Objects;

/**
 * Shared Media State Model
 * Used to transport media info from MediaNotificationListener to ClusterHudManager.
 */
public class MediaInfo implements Parcelable {
    public String packageName;
    public String title;
    public String artist;
    public String album;
    public Bitmap artwork; // Transferred separately or small icon
    public boolean isPlaying;
    public long timestamp;

    public MediaInfo() {
        this.timestamp = System.currentTimeMillis();
    }

    public MediaInfo(String packageName, String title, String artist, String album, Bitmap artwork, boolean isPlaying) {
        this.packageName = packageName;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.artwork = artwork;
        this.isPlaying = isPlaying;
        this.timestamp = System.currentTimeMillis();
    }

    protected MediaInfo(Parcel in) {
        packageName = in.readString();
        title = in.readString();
        artist = in.readString();
        album = in.readString();
        artwork = in.readParcelable(Bitmap.class.getClassLoader());
        isPlaying = in.readByte() != 0;
        timestamp = in.readLong();
    }

    public static final Creator<MediaInfo> CREATOR = new Creator<MediaInfo>() {
        @Override
        public MediaInfo createFromParcel(Parcel in) {
            return new MediaInfo(in);
        }

        @Override
        public MediaInfo[] newArray(int size) {
            return new MediaInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(packageName);
        dest.writeString(title);
        dest.writeString(artist);
        dest.writeString(album);
        dest.writeParcelable(artwork, flags);
        dest.writeByte((byte) (isPlaying ? 1 : 0));
        dest.writeLong(timestamp);
    }
    
    /**
     * Check if this media info has valid content (Title is required)
     */
    public boolean isValid() {
        return !TextUtils.isEmpty(title);
    }

    /**
     * Helper to check if metadata (Title/Artist) changed significantly
     */
    public boolean isMetadataDifferent(MediaInfo other) {
        if (other == null) return true;
        if (!Objects.equals(title, other.title)) return true;
        if (!Objects.equals(artist, other.artist)) return true;
        
        // [FIX] Check Artwork change
        boolean thisHasArt = (artwork != null);
        boolean otherHasArt = (other.artwork != null);
        if (thisHasArt != otherHasArt) return true;
        
        if (thisHasArt) {
             // Use sameAs for pixel comparison (Bitmap.equals only checks reference)
             // Note: Performance impact is negligible for HUD thumbnails (200x200)
             if (!artwork.sameAs(other.artwork)) return true; 
        }

        // Playing state change is technically a diff, but metadata might be same
        return false;
    }
    
    /**
     * Get a formatted display string (Title - Artist)
     */
    public String getFormatText() {
        if (TextUtils.isEmpty(artist)) {
            return title == null ? "" : title;
        }
        return title + "\n" + artist;
    }

    @Override
    public String toString() {
        return "MediaInfo{" +
                "pkg='" + packageName + '\'' +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", playing=" + isPlaying +
                ", hasArt=" + (artwork != null) +
                '}';
    }
}
