package com.desafio.starkbank.boundary.clients;

import java.util.UUID;

public interface StarkbankSandboxClient
{
    UUID createTransfer(Long net);
}
