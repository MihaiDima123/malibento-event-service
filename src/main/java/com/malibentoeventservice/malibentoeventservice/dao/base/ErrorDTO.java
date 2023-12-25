package com.malibentoeventservice.malibentoeventservice.dao.base;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
    private static final String DEFAULT_DETAIL = "";
    private static final String DEFAULT_TITLE = DEFAULT_DETAIL;

    private String detail = DEFAULT_DETAIL;
    private String title = DEFAULT_TITLE;

    private static ErrorDTO empty() {
        return new ErrorDTO();
    }

    public static ErrorDTO from(final String detail, final String title) {
        return ErrorDTO
                .empty()
                .ofDetail(detail)
                .ofTitle(title);
    }

    public static ErrorDTO from(final String detail) {
        return ErrorDTO
                .empty()
                .ofDetail(detail);
    }

    public ErrorDTO ofDetail(final String detail) {
        this.detail = detail;
        return this;
    }

    public ErrorDTO ofTitle(final String title) {
        this.title = title;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public String getTitle() {
        return title;
    }
}
