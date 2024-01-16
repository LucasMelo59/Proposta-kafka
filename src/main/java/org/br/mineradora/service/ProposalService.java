package org.br.mineradora.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.br.mineradora.dto.ProposalDetailsDTO;
import org.br.mineradora.entity.ProposalEntity;

public interface ProposalService {

    ProposalDetailsDTO findFullProposal(long id);

    void createNewProposal(ProposalDetailsDTO proposalDetailsDTO);

    void removeProposal(long id);

}
