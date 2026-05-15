// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.models.machines.executions

import com.dedalus.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExecutionEventTest {

    @Test
    fun create() {
        val executionEvent =
            ExecutionEvent.builder()
                .at(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .sequence(0L)
                .type(ExecutionEvent.Type.LIFECYCLE)
                .chunk("chunk")
                .errorCode("error_code")
                .errorMessage("error_message")
                .exitCode(0L)
                .signal(0L)
                .status(ExecutionEvent.Status.WAKE_IN_PROGRESS)
                .build()

        assertThat(executionEvent.at()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(executionEvent.sequence()).isEqualTo(0L)
        assertThat(executionEvent.type()).isEqualTo(ExecutionEvent.Type.LIFECYCLE)
        assertThat(executionEvent.chunk()).isEqualTo("chunk")
        assertThat(executionEvent.errorCode()).isEqualTo("error_code")
        assertThat(executionEvent.errorMessage()).isEqualTo("error_message")
        assertThat(executionEvent.exitCode()).isEqualTo(0L)
        assertThat(executionEvent.signal()).isEqualTo(0L)
        assertThat(executionEvent.status()).isEqualTo(ExecutionEvent.Status.WAKE_IN_PROGRESS)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val executionEvent =
            ExecutionEvent.builder()
                .at(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .sequence(0L)
                .type(ExecutionEvent.Type.LIFECYCLE)
                .chunk("chunk")
                .errorCode("error_code")
                .errorMessage("error_message")
                .exitCode(0L)
                .signal(0L)
                .status(ExecutionEvent.Status.WAKE_IN_PROGRESS)
                .build()

        val roundtrippedExecutionEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(executionEvent),
                jacksonTypeRef<ExecutionEvent>(),
            )

        assertThat(roundtrippedExecutionEvent).isEqualTo(executionEvent)
    }
}
