package com.malibentoeventservice.malibentoeventservice.dao.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
    private static final String DEFAULT_DETAIL = "";
    private static final String DEFAULT_TITLE = DEFAULT_DETAIL;

    private String detail = DEFAULT_DETAIL;
    private String title = DEFAULT_TITLE;

    private static ErrorDTO empty() {
        return new ErrorDTO();
    }

    @SuppressWarnings(value = "unused")
    public static ErrorDTO from(String detail, String title) {
        return ErrorDTO
                .empty()
                .ofDetail(detail)
                .ofTitle(title);
    }

    public static ErrorDTO from(String detail) {
        return ErrorDTO
                .empty()
                .ofTitle(detail);
    }

    public ErrorDTO ofDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public ErrorDTO ofTitle(String title) {
        this.title = title;
        return this;
    }
}
