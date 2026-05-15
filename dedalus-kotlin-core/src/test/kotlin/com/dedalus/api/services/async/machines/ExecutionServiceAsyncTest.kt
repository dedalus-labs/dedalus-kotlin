// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.TestServerExtension
import com.dedalus.api.client.okhttp.DedalusOkHttpClientAsync
import com.dedalus.api.core.JsonValue
import com.dedalus.api.models.machines.executions.ExecutionCreateParams
import com.dedalus.api.models.machines.executions.ExecutionDeleteParams
import com.dedalus.api.models.machines.executions.ExecutionEventsParams
import com.dedalus.api.models.machines.executions.ExecutionListParams
import com.dedalus.api.models.machines.executions.ExecutionOutputParams
import com.dedalus.api.models.machines.executions.ExecutionRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ExecutionServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val executionServiceAsync = client.machines().executions()

        val execution =
            executionServiceAsync.create(
                ExecutionCreateParams.builder()
                    .machineId("dm-3")
                    .executionCreateParams(
                        ExecutionCreateParams.builder()
                            .addCommand("string")
                            .cwd("cwd")
                            .env(
                                ExecutionCreateParams.Env.builder()
                                    .putAdditionalProperty("foo", JsonValue.from("string"))
                                    .build()
                            )
                            .stdin("stdin")
                            .timeoutMs(0L)
                            .build()
                    )
                    .build()
            )

        execution.validate()
    }

    @Test
    suspend fun retrieve() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val executionServiceAsync = client.machines().executions()

        val execution =
            executionServiceAsync.retrieve(
                ExecutionRetrieveParams.builder()
                    .machineId("dm-3")
                    .executionId("execution_id")
                    .build()
            )

        execution.validate()
    }

    @Test
    suspend fun list() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val executionServiceAsync = client.machines().executions()

        val page =
            executionServiceAsync.list(ExecutionListParams.builder().machineId("dm-3").build())

        page.response().validate()
    }

    @Test
    suspend fun delete() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val executionServiceAsync = client.machines().executions()

        val execution =
            executionServiceAsync.delete(
                ExecutionDeleteParams.builder()
                    .machineId("dm-3")
                    .executionId("execution_id")
                    .build()
            )

        execution.validate()
    }

    @Test
    suspend fun events() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val executionServiceAsync = client.machines().executions()

        val page =
            executionServiceAsync.events(
                ExecutionEventsParams.builder()
                    .machineId("dm-3")
                    .executionId("execution_id")
                    .build()
            )

        page.response().validate()
    }

    @Test
    suspend fun output() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val executionServiceAsync = client.machines().executions()

        val executionOutput =
            executionServiceAsync.output(
                ExecutionOutputParams.builder()
                    .machineId("dm-3")
                    .executionId("execution_id")
                    .build()
            )

        executionOutput.validate()
    }
}
