package com.epam.tc.hw4;

import io.qameta.allure.Attachment;

public class AttachmentUtils {

    @Attachment(type = "image/png", value = "try to use param {name}")
    public static byte[] makeImagesAttachment(final String name, final byte[] source) {
        return source;
    }
}
