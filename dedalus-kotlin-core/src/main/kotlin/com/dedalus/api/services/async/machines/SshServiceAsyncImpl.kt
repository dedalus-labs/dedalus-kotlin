// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.core.ClientOptions
import com.dedalus.api.core.RequestOptions
import com.dedalus.api.core.handlers.errorBodyHandler
import com.dedalus.api.core.handlers.errorHandler
import com.dedalus.api.core.handlers.jsonHandler
import com.dedalus.api.core.http.HttpMethod
import com.dedalus.api.core.http.HttpRequest
import com.dedalus.api.core.http.HttpResponse
import com.dedalus.api.core.http.HttpResponse.Handler
import com.dedalus.api.core.http.HttpResponseFor
import com.dedalus.api.core.http.json
import com.dedalus.api.core.http.parseable
import com.dedalus.api.core.prepareAsync
import com.dedalus.api.models.machines.ssh.SshCreateParams
import com.dedalus.api.models.machines.ssh.SshDeleteParams
import com.dedalus.api.models.machines.ssh.SshListPageAsync
import com.dedalus.api.models.machines.ssh.SshListParams
import com.dedalus.api.models.machines.ssh.SshRetrieveParams
import com.dedalus.api.models.machines.ssh.SshSession
import com.dedalus.api.models.machines.ssh.SshSessionList

class SshServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SshServiceAsync {

    private val withRawResponse: SshServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SshServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SshServiceAsync =
        SshServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(
        params: SshCreateParams,
        requestOptions: RequestOptions,
    ): SshSession =
        // post /v1/machines/{machine_id}/ssh
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: SshRetrieveParams,
        requestOptions: RequestOptions,
    ): SshSession =
        // get /v1/machines/{machine_id}/ssh/{session_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: SshListParams,
        requestOptions: RequestOptions,
    ): SshListPageAsync =
        // get /v1/machines/{machine_id}/ssh
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: SshDeleteParams,
        requestOptions: RequestOptions,
    ): SshSession =
        // delete /v1/machines/{machine_id}/ssh/{session_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SshServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): SshServiceAsync.WithRawResponse =
            SshServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<SshSession> =
            jsonHandler<SshSession>(clientOptions.jsonMapper)

        override suspend fun create(
            params: SshCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SshSession> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "machines", params._pathParam(0), "ssh")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<SshSession> =
            jsonHandler<SshSession>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: SshRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SshSession> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "machines",
                        params._pathParam(0),
                        "ssh",
                        params._pathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<SshSessionList> =
            jsonHandler<SshSessionList>(clientOptions.jsonMapper)

        override suspend fun list(
            params: SshListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SshListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "machines", params._pathParam(0), "ssh")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        SshListPageAsync.builder()
                            .service(SshServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<SshSession> =
            jsonHandler<SshSession>(clientOptions.jsonMapper)

        override suspend fun delete(
            params: SshDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SshSession> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "machines",
                        params._pathParam(0),
                        "ssh",
                        params._pathParam(1),
                    )
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
