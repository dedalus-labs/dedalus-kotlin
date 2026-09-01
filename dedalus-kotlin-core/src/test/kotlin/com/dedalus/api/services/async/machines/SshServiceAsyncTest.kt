// File generated from our OpenAPI spec by Stainless.

package com.dedalus.api.services.async.machines

import com.dedalus.api.TestServerExtension
import com.dedalus.api.client.okhttp.DedalusOkHttpClientAsync
import com.dedalus.api.models.machines.ssh.SshCreateParams
import com.dedalus.api.models.machines.ssh.SshDeleteParams
import com.dedalus.api.models.machines.ssh.SshListParams
import com.dedalus.api.models.machines.ssh.SshRetrieveParams
import com.dedalus.api.models.machines.ssh.SshSessionCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SshServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val sshServiceAsync = client.machines().ssh()

        val sshSession =
            sshServiceAsync.create(
                SshCreateParams.builder()
                    .machineId("dm-ecc2efdd-ddfa-31a9-c6f1-b833d337aa7c")
                    .sshSessionCreateParams(
                        SshSessionCreateParams.builder().publicKey("public_key").build()
                    )
                    .build()
            )

        sshSession.validate()
    }

    @Test
    suspend fun retrieve() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val sshServiceAsync = client.machines().ssh()

        val sshSession =
            sshServiceAsync.retrieve(
                SshRetrieveParams.builder()
                    .machineId("dm-ecc2efdd-ddfa-31a9-c6f1-b833d337aa7c")
                    .sessionId("session_id")
                    .build()
            )

        sshSession.validate()
    }

    @Test
    suspend fun list() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val sshServiceAsync = client.machines().ssh()

        val page =
            sshServiceAsync.list(
                SshListParams.builder().machineId("dm-ecc2efdd-ddfa-31a9-c6f1-b833d337aa7c").build()
            )

        page.response().validate()
    }

    @Test
    suspend fun delete() {
        val client =
            DedalusOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val sshServiceAsync = client.machines().ssh()

        val sshSession =
            sshServiceAsync.delete(
                SshDeleteParams.builder()
                    .machineId("dm-ecc2efdd-ddfa-31a9-c6f1-b833d337aa7c")
                    .sessionId("session_id")
                    .build()
            )

        sshSession.validate()
    }
}
