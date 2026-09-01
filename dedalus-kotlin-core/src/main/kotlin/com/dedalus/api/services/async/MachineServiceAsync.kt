// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async

import com.dedalus.api.core.ClientOptions
import com.dedalus.api.core.RequestOptions
import com.dedalus.api.core.http.HttpResponseFor
import com.dedalus.api.models.machines.CreateParams
import com.dedalus.api.models.machines.Machine
import com.dedalus.api.models.machines.MachineCreateParams
import com.dedalus.api.models.machines.MachineDeleteParams
import com.dedalus.api.models.machines.MachineListPageAsync
import com.dedalus.api.models.machines.MachineListParams
import com.dedalus.api.models.machines.MachineRetrieveParams
import com.dedalus.api.models.machines.MachineRetrieveResponse
import com.dedalus.api.models.machines.MachineSleepParams
import com.dedalus.api.models.machines.MachineUpdateParams
import com.dedalus.api.models.machines.MachineWakeParams
import com.dedalus.api.services.async.machines.ExecutionServiceAsync
import com.dedalus.api.services.async.machines.SshServiceAsync
import com.google.errorprone.annotations.MustBeClosed

interface MachineServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MachineServiceAsync

    fun ssh(): SshServiceAsync

    fun executions(): ExecutionServiceAsync

    /** Create machine */
    suspend fun create(
        params: MachineCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Machine

    /** @see create */
    suspend fun create(
        createParams: CreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Machine =
        create(MachineCreateParams.builder().createParams(createParams).build(), requestOptions)

    /** Get machine */
    suspend fun retrieve(
        params: MachineRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MachineRetrieveResponse

    /** Update machine */
    suspend fun update(
        params: MachineUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Machine

    /** List machines */
    suspend fun list(
        params: MachineListParams = MachineListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MachineListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): MachineListPageAsync =
        list(MachineListParams.none(), requestOptions)

    /** Destroy machine */
    suspend fun delete(
        params: MachineDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Machine

    /** Sleep a running machine */
    suspend fun sleep(
        params: MachineSleepParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Machine

    /** Wake a sleeping machine */
    suspend fun wake(
        params: MachineWakeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Machine

    /**
     * A view of [MachineServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): MachineServiceAsync.WithRawResponse

        fun ssh(): SshServiceAsync.WithRawResponse

        fun executions(): ExecutionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/machines`, but is otherwise the same as
         * [MachineServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: MachineCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Machine>

        /** @see create */
        @MustBeClosed
        suspend fun create(
            createParams: CreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Machine> =
            create(MachineCreateParams.builder().createParams(createParams).build(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}`, but is otherwise the
         * same as [MachineServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: MachineRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MachineRetrieveResponse>

        /**
         * Returns a raw HTTP response for `patch /v1/machines/{machine_id}`, but is otherwise the
         * same as [MachineServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            params: MachineUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Machine>

        /**
         * Returns a raw HTTP response for `get /v1/machines`, but is otherwise the same as
         * [MachineServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: MachineListParams = MachineListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MachineListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<MachineListPageAsync> =
            list(MachineListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/machines/{machine_id}`, but is otherwise the
         * same as [MachineServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: MachineDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Machine>

        /**
         * Returns a raw HTTP response for `post /v1/machines/{machine_id}/sleep`, but is otherwise
         * the same as [MachineServiceAsync.sleep].
         */
        @MustBeClosed
        suspend fun sleep(
            params: MachineSleepParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Machine>

        /**
         * Returns a raw HTTP response for `post /v1/machines/{machine_id}/wake`, but is otherwise
         * the same as [MachineServiceAsync.wake].
         */
        @MustBeClosed
        suspend fun wake(
            params: MachineWakeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Machine>
    }
}
