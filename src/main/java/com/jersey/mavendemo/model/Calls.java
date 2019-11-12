package com.jersey.mavendemo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Calls {
    private String callId;
    private String callName;
    private String timestamp;
}
