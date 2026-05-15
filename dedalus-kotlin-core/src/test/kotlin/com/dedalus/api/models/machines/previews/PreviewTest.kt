// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.models.machines.previews

import com.dedalus.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PreviewTest {

    @Test
    fun create() {
        val preview =
            Preview.builder()
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .machineId("machine_id")
                .port(0L)
                .previewId("preview_id")
                .status(Preview.Status.WAKE_IN_PROGRESS)
                .visibility(Preview.Visibility.PUBLIC)
                .errorCode("error_code")
                .errorMessage("error_message")
                .expiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .protocol(Preview.Protocol.HTTP)
                .readyAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .retryAfterMs(0L)
                .url("url")
                .build()

        assertThat(preview.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(preview.machineId()).isEqualTo("machine_id")
        assertThat(preview.port()).isEqualTo(0L)
        assertThat(preview.previewId()).isEqualTo("preview_id")
        assertThat(preview.status()).isEqualTo(Preview.Status.WAKE_IN_PROGRESS)
        assertThat(preview.visibility()).isEqualTo(Preview.Visibility.PUBLIC)
        assertThat(preview.errorCode()).isEqualTo("error_code")
        assertThat(preview.errorMessage()).isEqualTo("error_message")
        assertThat(preview.expiresAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(preview.protocol()).isEqualTo(Preview.Protocol.HTTP)
        assertThat(preview.readyAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(preview.retryAfterMs()).isEqualTo(0L)
        assertThat(preview.url()).isEqualTo("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val preview =
            Preview.builder()
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .machineId("machine_id")
                .port(0L)
                .previewId("preview_id")
                .status(Preview.Status.WAKE_IN_PROGRESS)
                .visibility(Preview.Visibility.PUBLIC)
                .errorCode("error_code")
                .errorMessage("error_message")
                .expiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .protocol(Preview.Protocol.HTTP)
                .readyAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .retryAfterMs(0L)
                .url("url")
                .build()

        val roundtrippedPreview =
            jsonMapper.readValue(jsonMapper.writeValueAsString(preview), jacksonTypeRef<Preview>())

        assertThat(roundtrippedPreview).isEqualTo(preview)
    }
}
