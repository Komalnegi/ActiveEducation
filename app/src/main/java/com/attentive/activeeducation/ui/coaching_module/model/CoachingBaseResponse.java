
package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CollegeBaseResponse {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("state")
    @Expose
    private List<State> state = null;
    @SerializedName("city")
    @Expose
    private List<City> city = null;
    @SerializedName("class")
    @Expose
    private List<Clas> _class = null;
    @SerializedName("board")
    @Expose
    private List<Board> board = null;
    @SerializedName("stream")
    @Expose
    private List<Stream> stream = null;
    @SerializedName("statusArray")
    @Expose
    private List<StatusArray> statusArray = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<State> getState() {
        return state;
    }

    public void setState(List<State> state) {
        this.state = state;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    public List<Clas> getClass_() {
        return _class;
    }

    public void setClass_(List<Clas> _class) {
        this._class = _class;
    }

    public List<Board> getBoard() {
        return board;
    }

    public void setBoard(List<Board> board) {
        this.board = board;
    }

    public List<Stream> getStream() {
        return stream;
    }

    public void setStream(List<Stream> stream) {
        this.stream = stream;
    }

    public List<StatusArray> getStatusArray() {
        return statusArray;
    }

    public void setStatusArray(List<StatusArray> statusArray) {
        this.statusArray = statusArray;
    }

}
