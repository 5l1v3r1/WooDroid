package me.gilo.woodroid.models;

import android.os.Parcel;

import java.io.Serializable;

/**
 * Created by Aron on 11/26/2015.
 */
public class Attribute implements Serializable {
    private String name;
    private String slug;
    private int position;
    private boolean visible;
    private boolean variation;
    private String[] options;

    protected Attribute(Parcel in) {
        name = in.readString();
        slug = in.readString();
        position = in.readInt();
        visible = in.readByte() != 0;
        variation = in.readByte() != 0;
        options = in.createStringArray();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVariation() {
        return variation;
    }

    public void setVariation(boolean variation) {
        this.variation = variation;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

}
