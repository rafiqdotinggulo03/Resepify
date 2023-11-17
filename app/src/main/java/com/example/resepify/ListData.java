package com.example.resepify;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ListData implements Parcelable {
    private String recipe_name;
    private String recipe_time;
    private String recipe_ingredients;

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getRecipe_time() {
        return recipe_time;
    }

    public void setRecipe_time(String recipe_time) {
        this.recipe_time = recipe_time;
    }

    public String getRecipe_ingredients() {
        return recipe_ingredients;
    }

    public void setRecipe_ingredients(String recipe_ingredients) {
        this.recipe_ingredients = recipe_ingredients;
    }

    ListData(){

    }
    private ListData(Parcel in) {
        this.recipe_name = in.readString();
        this.recipe_time = in.readString();
        this.recipe_ingredients = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.recipe_name);
        dest.writeString(this.recipe_time);
        dest.writeString(this.recipe_ingredients);
    }
    public static final Creator<ListData> CREATOR = new Creator<ListData>() {
        @Override
        public ListData createFromParcel(Parcel in) {
            return new ListData(in);
        }

        @Override
        public ListData[] newArray(int size) {
            return new ListData[size];
        }
    };
}
