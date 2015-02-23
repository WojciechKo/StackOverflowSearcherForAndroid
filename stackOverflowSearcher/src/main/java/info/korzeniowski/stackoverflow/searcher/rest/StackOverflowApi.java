package info.korzeniowski.stackoverflow.searcher.rest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface StackOverflowApi {

    @GET("/search?site=stackoverflow")
    void query(@Query("intitle") String intitle, Callback<QueryResult> callback);

    public static class QueryResult {
        @SerializedName("items")
        public List<Topic> topics;
    }

    public static class Topic {
        @SerializedName("title")
        public String title;

        public Topic(String title) {
            this.title = title;
        }
    }
}
