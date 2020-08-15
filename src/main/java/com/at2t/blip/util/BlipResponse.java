package com.at2t.blip.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlipResponse {
    private StatusEnum status;
    private Object data;
    private String message;

}
