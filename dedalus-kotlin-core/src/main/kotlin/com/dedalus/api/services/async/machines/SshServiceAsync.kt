// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.core.ClientOptions
import com.dedalus.api.core.RequestOptions
import com.dedalus.api.core.http.HttpResponseFor
import com.dedalus.api.models.machines.ssh.SshCreateParams
import com.dedalus.api.models.machines.ssh.SshDeleteParams
import com.dedalus.api.models.machines.ssh.SshListPageAsync
import com.dedalus.api.models.machines.ssh.SshListParams
import com.dedalus.api.models.machines.ssh.SshRetrieveParams
import com.dedalus.api.models.machines.ssh.SshSession
import com.google.errorprone.annotations.MustBeClosed

interface SshServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SshServiceAsync

    /** Create SSH session */
    suspend fun create(
        params: SshCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SshSession

    /** Get SSH session */
    suspend fun retrieve(
        params: SshRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SshSession

    /** List SSH sessions */
    suspend fun list(
        params: SshListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SshListPageAsync

    /** Delete SSH session */
    suspend fun delete(
        params: SshDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SshSession

    /** A view of [SshServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SshServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/machines/{machine_id}/ssh`, but is otherwise
         * the same as [SshServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: SshCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SshSession>

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}/ssh/{session_id}`, but is
         * otherwise the same as [SshServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: SshRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SshSession>

        /**
         * Returns a raw HTTP response for `get /v1/machines/{machine_id}/ssh`, but is otherwise the
         * same as [SshServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: SshListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SshListPageAsync>

        /**
         * Returns a raw HTTP response for `delete /v1/machines/{machine_id}/ssh/{session_id}`, but
         * is otherwise the same as [SshServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: SshDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SshSession>
    }
}
