package org.spring.busreservation.dto;

import java.io.Serializable;

public class CaptchaDto implements Serializable {
    private Long id;
    private byte[] captchaImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getCaptchaImage() {
        return captchaImage;
    }

    public void setCaptchaImage(byte[] captchaImage) {
        this.captchaImage = captchaImage;
    }
}
