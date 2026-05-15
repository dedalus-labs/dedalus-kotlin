// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.models.usage

import com.dedalus.api.core.Params
import com.dedalus.api.core.http.Headers
import com.dedalus.api.core.http.QueryParams
import java.util.Objects

/** List machine compute usage breakdown */
class UsageMachineComputeParams
private constructor(
    private val granularity: String?,
    private val machineId: String?,
    private val periodEnd: String?,
    private val periodStart: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Usage breakdown granularity: hour or day. Defaults to hour. */
    fun granularity(): String? = granularity

    /** Optional machine ID filter. */
    fun machineId(): String? = machineId

    /** Last UTC usage date to include (YYYY-MM-DD). Defaults to current time. */
    fun periodEnd(): String? = periodEnd

    /** Usage period start (YYYY-MM-DD). Defaults to first of current month. */
    fun periodStart(): String? = periodStart

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        fun none(): UsageMachineComputeParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [UsageMachineComputeParams].
         */
        fun builder() = Builder()
    }

    /** A builder for [UsageMachineComputeParams]. */
    class Builder internal constructor() {

        private var granularity: String? = null
        private var machineId: String? = null
        private var periodEnd: String? = null
        private var periodStart: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(usageMachineComputeParams: UsageMachineComputeParams) = apply {
            granularity = usageMachineComputeParams.granularity
            machineId = usageMachineComputeParams.machineId
            periodEnd = usageMachineComputeParams.periodEnd
            periodStart = usageMachineComputeParams.periodStart
            additionalHeaders = usageMachineComputeParams.additionalHeaders.toBuilder()
            additionalQueryParams = usageMachineComputeParams.additionalQueryParams.toBuilder()
        }

        /** Usage breakdown granularity: hour or day. Defaults to hour. */
        fun granularity(granularity: String?) = apply { this.granularity = granularity }

        /** Optional machine ID filter. */
        fun machineId(machineId: String?) = apply { this.machineId = machineId }

        /** Last UTC usage date to include (YYYY-MM-DD). Defaults to current time. */
        fun periodEnd(periodEnd: String?) = apply { this.periodEnd = periodEnd }

        /** Usage period start (YYYY-MM-DD). Defaults to first of current month. */
        fun periodStart(periodStart: String?) = apply { this.periodStart = periodStart }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [UsageMachineComputeParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UsageMachineComputeParams =
            UsageMachineComputeParams(
                granularity,
                machineId,
                periodEnd,
                periodStart,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                granularity?.let { put("granularity", it) }
                machineId?.let { put("machine_id", it) }
                periodEnd?.let { put("period_end", it) }
                periodStart?.let { put("period_start", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsageMachineComputeParams &&
            granularity == other.granularity &&
            machineId == other.machineId &&
            periodEnd == other.periodEnd &&
            periodStart == other.periodStart &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            granularity,
            machineId,
            periodEnd,
            periodStart,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "UsageMachineComputeParams{granularity=$granularity, machineId=$machineId, periodEnd=$periodEnd, periodStart=$periodStart, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
