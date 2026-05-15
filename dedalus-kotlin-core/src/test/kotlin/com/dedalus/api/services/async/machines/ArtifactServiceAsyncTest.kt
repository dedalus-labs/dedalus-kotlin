// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.TestServerExtension
import com.dedalus.api.client.okhttp.DedalusOkHttpClientAsync
import com.dedalus.api.models.machines.artifacts.ArtifactDeleteParams
import com.dedalus.api.models.machines.artifacts.ArtifactListParams
import com.dedalus.api.models.machines.artifacts.ArtifactRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ArtifactServiceAsyncTest {

    @Test
    suspend fun retrieve() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val artifactServiceAsync = client.machines().artifacts()

        val artifact =
            artifactServiceAsync.retrieve(
                ArtifactRetrieveParams.builder().machineId("dm-3").artifactId("artifact_id").build()
            )

        artifact.validate()
    }

    @Test
    suspend fun list() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val artifactServiceAsync = client.machines().artifacts()

        val page = artifactServiceAsync.list(ArtifactListParams.builder().machineId("dm-3").build())

        page.response().validate()
    }

    @Test
    suspend fun delete() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val artifactServiceAsync = client.machines().artifacts()

        val artifact =
            artifactServiceAsync.delete(
                ArtifactDeleteParams.builder().machineId("dm-3").artifactId("artifact_id").build()
            )

        artifact.validate()
    }
}
