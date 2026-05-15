// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.blocking

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

interface UsageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UsageService

    /** Get usage summary */
    fun retrieve(
        params: UsageRetrieveParams = UsageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrgUsage

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): OrgUsage =
        retrieve(UsageRetrieveParams.none(), requestOptions)

    /** List machine compute usage breakdown */
    fun machineCompute(
        params: UsageMachineComputeParams = UsageMachineComputeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MachineComputeUsage

    /** @see machineCompute */
    fun machineCompute(requestOptions: RequestOptions): MachineComputeUsage =
        machineCompute(UsageMachineComputeParams.none(), requestOptions)

    /** List machine storage usage breakdown */
    fun machineStorage(
        params: UsageMachineStorageParams = UsageMachineStorageParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MachineStorageUsage

    /** @see machineStorage */
    fun machineStorage(requestOptions: RequestOptions): MachineStorageUsage =
        machineStorage(UsageMachineStorageParams.none(), requestOptions)

    /** A view of [UsageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UsageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/usage`, but is otherwise the same as
         * [UsageService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: UsageRetrieveParams = UsageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrgUsage>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(requestOptions: RequestOptions): HttpResponseFor<OrgUsage> =
            retrieve(UsageRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/usage/machines/compute`, but is otherwise the
         * same as [UsageService.machineCompute].
         */
        @MustBeClosed
        fun machineCompute(
            params: UsageMachineComputeParams = UsageMachineComputeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MachineComputeUsage>

        /** @see machineCompute */
        @MustBeClosed
        fun machineCompute(requestOptions: RequestOptions): HttpResponseFor<MachineComputeUsage> =
            machineCompute(UsageMachineComputeParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/usage/machines/storage`, but is otherwise the
         * same as [UsageService.machineStorage].
         */
        @MustBeClosed
        fun machineStorage(
            params: UsageMachineStorageParams = UsageMachineStorageParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MachineStorageUsage>

        /** @see machineStorage */
        @MustBeClosed
        fun machineStorage(requestOptions: RequestOptions): HttpResponseFor<MachineStorageUsage> =
            machineStorage(UsageMachineStorageParams.none(), requestOptions)
    }
}
