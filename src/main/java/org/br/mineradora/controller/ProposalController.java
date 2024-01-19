package org.br.mineradora.controller;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.persistence.GeneratedValue;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.br.mineradora.dto.ProposalDetailsDTO;
import org.br.mineradora.service.ProposalService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("api/proposta")
@Authenticated
public class ProposalController {

    private final Logger LOG = LoggerFactory.getLogger(ProposalController.class);

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    ProposalService proposalService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"user","manager"})
    public ProposalDetailsDTO findDetailsProposal(@PathParam("id") long id) {
        return proposalService.findFullProposal(id);
    }

    @POST
    @Transactional
    @RolesAllowed("proposal-customer")
    public Response createProposal(ProposalDetailsDTO proposalDetailsDTO) {

        LOG.info("--- Recebendo proposta de compra ---");

        try {

            proposalService.createNewProposal(proposalDetailsDTO);
            return Response.ok().build();
        } catch (Exception e) {

            return Response.serverError().build();

        }

    }


    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    public Response removeProposal(@PathParam("id") long id) {

        try {
            proposalService.removeProposal(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
