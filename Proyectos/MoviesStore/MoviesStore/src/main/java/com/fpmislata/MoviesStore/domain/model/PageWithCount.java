package com.fpmislata.MoviesStore.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageWithCount<T> {
    private List<T> data;
    private long count;
}
