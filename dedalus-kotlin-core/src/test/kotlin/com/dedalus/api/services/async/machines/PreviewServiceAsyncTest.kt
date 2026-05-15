// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.TestServerExtension
import com.dedalus.api.client.okhttp.DedalusOkHttpClientAsync
import com.dedalus.api.models.machines.previews.PreviewCreateParams
import com.dedalus.api.models.machines.previews.PreviewDeleteParams
import com.dedalus.api.models.machines.previews.PreviewListParams
import com.dedalus.api.models.machines.previews.PreviewRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PreviewServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val previewServiceAsync = client.machines().previews()

        val preview =
            previewServiceAsync.create(
                PreviewCreateParams.builder()
                    .machineId("dm-3")
                    .previewCreateParams(
                        PreviewCreateParams.builder()
                            .port(0L)
                            .protocol(PreviewCreateParams.Protocol.HTTP)
                            .visibility(PreviewCreateParams.Visibility.PUBLIC)
                            .build()
                    )
                    .build()
            )

        preview.validate()
    }

    @Test
    suspend fun retrieve() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val previewServiceAsync = client.machines().previews()

        val preview =
            previewServiceAsync.retrieve(
                PreviewRetrieveParams.builder().machineId("dm-3").previewId("preview_id").build()
            )

        preview.validate()
    }

    @Test
    suspend fun list() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val previewServiceAsync = client.machines().previews()

        val page = previewServiceAsync.list(PreviewListParams.builder().machineId("dm-3").build())

        page.response().validate()
    }

    @Test
    suspend fun delete() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val previewServiceAsync = client.machines().previews()

        val preview =
            previewServiceAsync.delete(
                PreviewDeleteParams.builder().machineId("dm-3").previewId("preview_id").build()
            )

        preview.validate()
    }
}
