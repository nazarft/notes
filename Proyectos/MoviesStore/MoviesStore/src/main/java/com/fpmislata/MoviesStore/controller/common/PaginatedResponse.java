package com.fpmislata.MoviesStore.controller.common;

import lombok.Data;

import java.util.List;

@Data
public class PaginatedResponse<T>{
    private List<T> data;
    private long total;
    private int currentPage;
    private int pageSize;
    private String next;
    private String previous;

    public PaginatedResponse(List<T> data, long total, int currentPage, int pageSize, String baseUrl) {
        this.data = data;
        this.total = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.next = createNextLink(baseUrl);
        this.previous = createPreviousLink(baseUrl);
    }
    private String createNextLink(String baseUrl){
        if (currentPage * pageSize < total){
            return baseUrl + "?page=" + (currentPage + 1) + "&size" + pageSize;
        }
        return null;
    }
    private String createPreviousLink(String baseUrl){
        if (currentPage * pageSize > total){
            return baseUrl + "?page=" + (currentPage - 1) + "&size" + pageSize;
        }
        return null;
    }
}
