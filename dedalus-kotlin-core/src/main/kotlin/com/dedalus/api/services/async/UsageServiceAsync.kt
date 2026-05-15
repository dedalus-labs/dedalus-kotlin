// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async

import com.dedalus.api.core.ClientOptions
import com.dedalus.api.core.RequestOptions
import com.dedalus.api.core.http.HttpResponseFor
import com.dedalus.api.models.usage.MachineComputeUsage
import com.dedalus.api.models.usage.MachineStorageUsage
import com.dedalus.api.models.usage.OrgUsage
import com.dedalus.api.models.usage.UsageMachineComputeParams
import com.dedalus.api.models.usage.UsageMachineStorageParams
import com.dedalus.api.models.usage.UsageRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface UsageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UsageServiceAsync

    /** Get usage summary */
    suspend fun retrieve(
        params: UsageRetrieveParams = UsageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrgUsage

    /** @see retrieve */
    suspend fun retrieve(requestOptions: RequestOptions): OrgUsage =
        retrieve(UsageRetrieveParams.none(), requestOptions)

    /** List machine compute usage breakdown */
    suspend fun machineCompute(
        params: UsageMachineComputeParams = UsageMachineComputeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MachineComputeUsage

    /** @see machineCompute */
    suspend fun machineCompute(requestOptions: RequestOptions): MachineComputeUsage =
        machineCompute(UsageMachineComputeParams.none(), requestOptions)

    /** List machine storage usage breakdown */
    suspend fun machineStorage(
        params: UsageMachineStorageParams = UsageMachineStorageParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MachineStorageUsage

    /** @see machineStorage */
    suspend fun machineStorage(requestOptions: RequestOptions): MachineStorageUsage =
        machineStorage(UsageMachineStorageParams.none(), requestOptions)

    /** A view of [UsageServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): UsageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/usage`, but is otherwise the same as
         * [UsageServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: UsageRetrieveParams = UsageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrgUsage>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(requestOptions: RequestOptions): HttpResponseFor<OrgUsage> =
            retrieve(UsageRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/usage/machines/compute`, but is otherwise the
         * same as [UsageServiceAsync.machineCompute].
         */
        @MustBeClosed
        suspend fun machineCompute(
            params: UsageMachineComputeParams = UsageMachineComputeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MachineComputeUsage>

        /** @see machineCompute */
        @MustBeClosed
        suspend fun machineCompute(
            requestOptions: RequestOptions
        ): HttpResponseFor<MachineComputeUsage> =
            machineCompute(UsageMachineComputeParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/usage/machines/storage`, but is otherwise the
         * same as [UsageServiceAsync.machineStorage].
         */
        @MustBeClosed
        suspend fun machineStorage(
            params: UsageMachineStorageParams = UsageMachineStorageParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MachineStorageUsage>

        /** @see machineStorage */
        @MustBeClosed
        suspend fun machineStorage(
            requestOptions: RequestOptions
        ): HttpResponseFor<MachineStorageUsage> =
            machineStorage(UsageMachineStorageParams.none(), requestOptions)
    }
}
