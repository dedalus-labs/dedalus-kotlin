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
import com.dedalus.api.models.machines.artifacts.Artifact
import com.dedalus.api.models.machines.artifacts.ArtifactDeleteParams
import com.dedalus.api.models.machines.artifacts.ArtifactList
import com.dedalus.api.models.machines.artifacts.ArtifactListPageAsync
import com.dedalus.api.models.machines.artifacts.ArtifactListParams
import com.dedalus.api.models.machines.artifacts.ArtifactRetrieveParams

class ArtifactServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ArtifactServiceAsync {

    private val withRawResponse: ArtifactServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ArtifactServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ArtifactServiceAsync =
        ArtifactServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: ArtifactRetrieveParams,
        requestOptions: RequestOptions,
    ): Artifact =
        // get /v1/machines/{machine_id}/artifacts/{artifact_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: ArtifactListParams,
        requestOptions: RequestOptions,
    ): ArtifactListPageAsync =
        // get /v1/machines/{machine_id}/artifacts
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: ArtifactDeleteParams,
        requestOptions: RequestOptions,
    ): Artifact =
        // delete /v1/machines/{machine_id}/artifacts/{artifact_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ArtifactServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ArtifactServiceAsync.WithRawResponse =
            ArtifactServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<Artifact> =
            jsonHandler<Artifact>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: ArtifactRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Artifact> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "machines",
                        params._pathParam(0),
                        "artifacts",
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

        private val listHandler: Handler<ArtifactList> =
            jsonHandler<ArtifactList>(clientOptions.jsonMapper)

        override suspend fun list(
            params: ArtifactListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ArtifactListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "machines", params._pathParam(0), "artifacts")
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
                        ArtifactListPageAsync.builder()
                            .service(ArtifactServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Artifact> =
            jsonHandler<Artifact>(clientOptions.jsonMapper)

        override suspend fun delete(
            params: ArtifactDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Artifact> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "machines",
                        params._pathParam(0),
                        "artifacts",
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
