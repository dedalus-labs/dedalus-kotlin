// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.core.ClientOptions
import com.dedalus.api.core.RequestOptions
import com.dedalus.api.core.http.HttpResponseFor
import com.dedalus.api.models.machines.terminals.Terminal
import com.dedalus.api.models.machines.terminals.TerminalCreateParams
import com.dedalus.api.models.machines.terminals.TerminalDeleteParams
import com.dedalus.api.models.machines.terminals.TerminalListPageAsync
import com.dedalus.api.models.machines.terminals.TerminalListParams
import com.dedalus.api.models.machines.terminals.TerminalRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface TerminalServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TerminalServiceAsync

    /** Create terminal */
    suspend fun create(
        params: TerminalCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Terminal

    /** Get terminal */
    suspend fun retrieve(
        params: TerminalRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Terminal

    /** List terminals */
    suspend fun list(
        params: TerminalListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TerminalListPageAsync

    /** Delete terminal */
    suspend fun delete(
        params: TerminalDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Terminal

    /**
     * A view of [TerminalServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): TerminalServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/machines/{machine_id}/terminals`, but is
         * otherwise the same as [TerminalServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: TerminalCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Terminal>

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}/terminals/{terminal_id}`,
         * but is otherwise the same as [TerminalServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: TerminalRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Terminal>

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}/terminals`, but is
         * otherwise the same as [TerminalServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: TerminalListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TerminalListPageAsync>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/machines/{machine_id}/terminals/{terminal_id}`, but is otherwise the same as
         * [TerminalServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: TerminalDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Terminal>
    }
}
